package com.cloudera.se.hbase.test.util;

import com.cloudera.se.hbase.test.model.DataModelConsts;
import com.cloudera.se.hbase.test.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;
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
public class Tester {

    private static final Logger log = Logger.getLogger(Tester.class);

    private final static ObjectMapper mapper = new ObjectMapper();

    public static void main (String[] args) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss.SSS");

        if (args.length == 0) {

            System.out.println("---------");
            System.out.println("TestRandom <number of events>");
            System.out.println("---------");
            return;
        }
        Configuration config = HBaseConfiguration.addHbaseResources(new Configuration());
        HConnection connection = HConnectionManager.createConnection(config);

        long events = Long.parseLong(args[0]);
        long batchSize = Long.parseLong(args[1]);
        long batchCounter = 0;

        String now = sdf.format(new Date());
        List<Put> table1PutList = new ArrayList<Put>();
        List<Put> table2PutList = new ArrayList<Put>();
        List<Put> table3PutList = new ArrayList<Put>();
        List<Put> table4PutList = new ArrayList<Put>();
        List<Put> table5PutList = new ArrayList<Put>();

        for (long nEvents = 0; nEvents < events; nEvents++) {
            batchCounter++;
            Event event = new Event();
            if (batchCounter < batchSize && nEvents < events) {
                table1PutList.add(CEHUtils.getTable1Put(event));
                table2PutList.add(CEHUtils.getTable2Put(event));
                table3PutList.add(CEHUtils.getTable3Put(event));
                table4PutList.add(CEHUtils.getTable4Put(event));
                table5PutList.add(CEHUtils.getTable5Put(event));
            } else  { // do the batch
                System.out.println("Starting");
                long startTime = System.currentTimeMillis();
                CEHUtils.insertToTable(connection,table1PutList, DataModelConsts.TABLE1);
                CEHUtils.insertToTable(connection,table2PutList, DataModelConsts.TABLE2);
                CEHUtils.insertToTable(connection,table3PutList, DataModelConsts.TABLE3);
                CEHUtils.insertToTable(connection,table4PutList, DataModelConsts.TABLE4);
                CEHUtils.insertToTable(connection,table5PutList, DataModelConsts.TABLE5);
                long endTime = System.currentTimeMillis();
                System.out.println("Ended");
                System.out.println(endTime - startTime);
                String then = sdf.format(new Date());
                System.out.println(now);
                System.out.println(then);

                //cleanup
                batchCounter = 0;
                table1PutList.clear();
                table2PutList.clear();
                table3PutList.clear();
                table4PutList.clear();
                table5PutList.clear();
            }
        }

        }



    }
