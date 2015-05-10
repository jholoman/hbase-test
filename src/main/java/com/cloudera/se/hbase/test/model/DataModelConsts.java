package com.cloudera.se.hbase.test.model;

/**
 * Created by jholoman on 9/27/14.
 */
import org.apache.hadoop.hbase.util.Bytes;

public class DataModelConsts {
    public static final byte[] TABLE1 = "ceh_be_by_cehuuid".getBytes();
    public static final byte[] TABLE2 = "ceh_be_attr_idx_by_cehuuid".getBytes();
    public static final byte[] TABLE3 = "ceh_be_inv_idx_by_attr".getBytes();
    public static final byte[] TABLE4 = "ceh_evt_ts".getBytes();
    public static final byte[] TABLE5 = "ceh_pty_chn_usag".getBytes();
    public static final byte[] COLUMN_FAMILY = Bytes.toBytes("c");
    public static final byte[] TABLE1_C1 = "evt_payload".getBytes();
    public static final byte[] TABLE1_C2 = "evt_uuid".getBytes();
    public static final byte[] TABLE1_C3 = "src_sys".getBytes();

    public static final byte[] TABLE2_C1 = "nm_id".getBytes();
    public static final byte[] TABLE2_C2 = "vl_id".getBytes();
    public static final byte[] TABLE2_C3 = "ev_ts".getBytes();
    public static final byte[] TABLE2_C4 = "chn_id".getBytes();

    public static final byte[] TABLE3_C1 = "ceh_uuid".getBytes();
    public static final byte[] TABLE3_C2 = "evt_ts".getBytes();
    public static final byte[] TABLE3_C3 = "chn_id".getBytes();

    public static final byte[] TABLE4_C1 = "guid".getBytes();
    public static final byte[] TABLE4_C2 = "evt_ts".getBytes();

    public static final byte[] TABLE5_C1 = "evt_typ".getBytes();

}



