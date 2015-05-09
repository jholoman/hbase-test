package com.cloudera.se.hbase.test.util;

import com.cloudera.se.hbase.test.model.Event;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.hbase.client.Put;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jholoman on 5/9/15.
 */
public class EventUtils {

    private static final Logger log = Logger.getLogger(EventUtils.class);

    private final static ObjectMapper mapper = new ObjectMapper();

    public static void main (String[] args) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss.SSS");

        if (args.length == 0) {

            System.out.println("---------");
            System.out.println("TestRandom <number of events>");
            System.out.println("---------");
            return;
        }
        long events = Long.parseLong(args[0]);

        String now = sdf.format(new Date());
        List<Put> table1PutList = new ArrayList<Put>();
        List<Put> table2PutList = new ArrayList<Put>();
        List<Put> table3PutList = new ArrayList<Put>();
        List<Put> table4PutList = new ArrayList<Put>();
        List<Put> table5PutList = new ArrayList<Put>();

        for (long nEvents = 0; nEvents < events ; nEvents++) {
            Event event = new Event();
            printJson(event);
            table1PutList.add(CEHUtils.getTable1Put(event));
            table2PutList.add(CEHUtils.getTable2Put(event));
            table3PutList.add(CEHUtils.getTable3Put(event));
            table4PutList.add(CEHUtils.getTable4Put(event));
            table5PutList.add(CEHUtils.getTable5Put(event));

        }
        String then = sdf.format(new Date());
        System.out.println(now);
        System.out.println(then);
        }

    public static void printJson(Event event) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
       //mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        //System.out.println(mapper.writeValueAsString(event));

    }
    }
