package com.cloudera.se.hbase.test.util;

import com.cloudera.se.hbase.test.model.DataModelConsts;
import com.cloudera.se.hbase.test.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.io.compress.Compression;
import org.apache.hadoop.hbase.regionserver.BloomType;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

/**
 * Created by jholoman on 5/9/15.
 */
public class CEHUtils {

    private static void createTable(byte[] tableName, byte[] columnFamilyName,
                                    short regionCount, long regionMaxSize, HBaseAdmin admin)
            throws IOException {
        if (admin.tableExists(tableName)) {
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        }
        System.out.println("Creating Table: " + tableName);

        HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);

        HColumnDescriptor columnDescriptor = new HColumnDescriptor(columnFamilyName);

        columnDescriptor.setCompressionType(Compression.Algorithm.SNAPPY);
        columnDescriptor.setBlocksize(64 * 1024);
        columnDescriptor.setBloomFilterType(BloomType.ROW);

        tableDescriptor.addFamily(columnDescriptor);

        tableDescriptor.setMaxFileSize(regionMaxSize);

        tableDescriptor.setDurability(Durability.ASYNC_WAL);;

        regionCount = (short)Math.abs(regionCount);

        /*
        int regionRange = Short.MAX_VALUE/regionCount;
        int counter = 0;

        byte[][] splitKeys = new byte[regionCount][];
        for (int i = 0 ; i < splitKeys.length; i++) {
            counter = counter + regionRange;
            String key = StringUtils.leftPad(Integer.toString(counter), 5, '0');
            splitKeys[i] = Bytes.toBytes(key);
            System.out.println(" - Split: " + i + " '" + key + "'");
        }
        */

        admin.createTable(tableDescriptor);
    }

    public static void insertToTable(HConnection conn, List<Put> putList, byte[] tableName) throws IOException {

        HTableInterface table = conn.getTable(tableName);
        try {
            table.put(putList);
        } finally {
            table.close();
        }
    }
    public static void createCEHTables(String regionCount) throws Exception{

        long regionMaxSize = 107374182400l;

        Configuration config = HBaseConfiguration.addHbaseResources(new Configuration());

        HBaseAdmin admin = new HBaseAdmin(config);

        createTable(DataModelConsts.TABLE1, DataModelConsts.COLUMN_FAMILY, Short.parseShort(regionCount), regionMaxSize, admin);
        createTable(DataModelConsts.TABLE2, DataModelConsts.COLUMN_FAMILY, Short.parseShort(regionCount), regionMaxSize, admin);
        createTable(DataModelConsts.TABLE3, DataModelConsts.COLUMN_FAMILY, Short.parseShort(regionCount), regionMaxSize, admin);
        createTable(DataModelConsts.TABLE4, DataModelConsts.COLUMN_FAMILY, Short.parseShort(regionCount), regionMaxSize, admin);
        createTable(DataModelConsts.TABLE5, DataModelConsts.COLUMN_FAMILY, Short.parseShort(regionCount), regionMaxSize, admin);
    }

    public static Put getTable1Put(Event event) throws IOException{
        String rowKey = event.getWho().getEvHubCstId() + '^' + event.getWhen().getEvTs() + '^' + event.getWhere().getChnId();
        Put put = new Put(Bytes.toBytes(rowKey));
        put.add(DataModelConsts.COLUMN_FAMILY, DataModelConsts.TABLE1_C1, Bytes.toBytes(getEventJson(event)));
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
    public static String getEventJson(Event event) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(event);

    }

}
