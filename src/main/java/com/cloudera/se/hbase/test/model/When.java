package com.cloudera.se.hbase.test.model;

/**
 * Created by jholoman on 5/8/15.
 */
public class When
{
    private String EvTs;

    private String EndTs;

    private String TxnmyRfrshTs;

    private String EvTypDataRtntnQt;

    private String StrtTs;

    public String getEvTs ()
    {
        return EvTs;
    }

    public void setEvTs (String EvTs)
    {
        this.EvTs = EvTs;
    }

    public String getEndTs ()
    {
        return EndTs;
    }

    public void setEndTs (String EndTs)
    {
        this.EndTs = EndTs;
    }

    public String getTxnmyRfrshTs ()
    {
        return TxnmyRfrshTs;
    }

    public void setTxnmyRfrshTs (String TxnmyRfrshTs)
    {
        this.TxnmyRfrshTs = TxnmyRfrshTs;
    }

    public String getEvTypDataRtntnQt ()
    {
        return EvTypDataRtntnQt;
    }

    public void setEvTypDataRtntnQt (String EvTypDataRtntnQt)
    {
        this.EvTypDataRtntnQt = EvTypDataRtntnQt;
    }

    public String getStrtTs ()
    {
        return StrtTs;
    }

    public void setStrtTs (String StrtTs)
    {
        this.StrtTs = StrtTs;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EvTs = "+EvTs+", EndTs = "+EndTs+", TxnmyRfrshTs = "+TxnmyRfrshTs+", EvTypDataRtntnQt = "+EvTypDataRtntnQt+", StrtTs = "+StrtTs+"]";
    }
}
