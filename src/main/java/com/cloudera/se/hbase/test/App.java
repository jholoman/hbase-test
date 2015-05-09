package com.cloudera.se.hbase.test;

import com.cloudera.se.hbase.test.util.EventUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

/**
 * Created by jholoman on 5/8/15.
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, JsonProcessingException, Exception {

        if (args.length == 0) {
            System.out.println("---------");
            System.out.println("App <cmd> ");
            System.out.println("");
            System.out.println("Randomize");
            System.out.println("---------");
            return;
        }

        String cmd = args[0];
        String[] subArgs = new String[args.length - 1];
        System.arraycopy(args, 1, subArgs, 0, subArgs.length);


        if (cmd.equals("Randomize") || cmd.length() == 0) {
            EventUtils.main(subArgs);
        }
        /*
        else if (cmd.equals("Producer")) {
            ProducerTest.main(subArgs);
        } else if (cmd.equals("WriteTest")) {
            EventUtils.main(subArgs);
        } else if (cmd.equals("BP")) {
            byteTest(subArgs);
        } else if (cmd.equals("testJSON")) {
            EventUtils.testJSONserde(Long.parseLong(subArgs[0]));
        } else if (cmd.equals("cidr")) {
            cidrTest(subArgs);
        } else {
            System.out.println("Unknown cmd:" + args[0]);
        }
        */
    }
}
