package com.cloudera.se.hbase.test.util;

import com.cloudera.se.hbase.test.model.DataModelConsts;
import com.cloudera.se.hbase.test.model.Event;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by jholoman on 5/9/15.
 */
public class CEHUtils {


    public static void createTable(byte[] tableName, byte[] columnFamily) throws Exception, IOException {
        Configuration conf = HBaseConfiguration.create();
        HBaseAdmin hbase = new HBaseAdmin(conf);
        HTableDescriptor desc = new HTableDescriptor(TableName.valueOf(tableName));
        if (hbase.tableExists(tableName)) {
            hbase.disableTable(tableName);
            hbase.deleteTable(tableName);
        }
        HColumnDescriptor family = new HColumnDescriptor(columnFamily);
        desc.addFamily(family);
        hbase.createTable(desc);
    }

    public static void createCEHTables() throws Exception{
        createTable(DataModelConsts.TABLE1, DataModelConsts.COLUMN_FAMILY);
        createTable(DataModelConsts.TABLE2, DataModelConsts.COLUMN_FAMILY);
        createTable(DataModelConsts.TABLE3, DataModelConsts.COLUMN_FAMILY);
        createTable(DataModelConsts.TABLE4, DataModelConsts.COLUMN_FAMILY);
        createTable(DataModelConsts.TABLE5, DataModelConsts.COLUMN_FAMILY);
    }

    public static Put getTable1Put(Event event) throws IOException{
        String rowKey = event.getWho().getEvHubCstId() + '^' + event.getWhen().getEvTs() + '^' + event.getWhere().getChnId();
        Put put = new Put(Bytes.toBytes(rowKey));
        //put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE1_C1, Bytes.toBytes(EventUtils.printJson(event)));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE1_C2, Bytes.toBytes(event.getWhat().getEvInstId()));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE1_C3, Bytes.toBytes(event.getWhere().getEvDataSrcId()));
        return put;
    }

    public static Put getTable2Put(Event event) throws IOException {
        String rowKey = event.getWho().getEvHubCstId();
        Put put = new Put(Bytes.toBytes(rowKey));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE2_C1, Bytes.toBytes(event.getWhat().getEvId()));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE2_C2, Bytes.toBytes(event.getWhat().getEvTypSchmNm()));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE2_C3, Bytes.toBytes(event.getWhen().getEvTs()));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE2_C4, Bytes.toBytes(event.getWhere().getChnId()));
        return put;
    }

    public static Put getTable3Put(Event event) throws IOException {
        String rowKey = event.getWhat().getEvTypSchmNm() + '^' + event.getWhat().getEvId() + '^' + event.getWhen().getEvTs();
        Put put = new Put(Bytes.toBytes(rowKey));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE3_C1, Bytes.toBytes(event.getWho().getEvHubCstId()));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE3_C2, Bytes.toBytes(event.getWhat().getEvTypSchmNm()));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE3_C3, Bytes.toBytes(event.getWhen().getEvTs()));
        return put;
    }

    public static Put getTable4Put(Event event) throws IOException {
        String rowKey = event.getWho().getEvHubCstId() + '^' + event.getWhat().getEvId();
        Put put = new Put(Bytes.toBytes(rowKey));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE4_C1, Bytes.toBytes(event.getWhat().getEvInstId()));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE4_C2, Bytes.toBytes(event.getWhen().getEvTs()));

        return put;
    }

    public static Put getTable5Put(Event event) throws IOException {
        String rowKey = event.getWho().getEvHubCstId() + '^' + event.getWhere().getChnId() + '^' + event.getWhen().getEvTs();
        Put put = new Put(Bytes.toBytes(rowKey));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE5_C1, Bytes.toBytes(event.getWhat().getEvTypNm()));

        return put;
    }

}
