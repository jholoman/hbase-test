package com.cloudera.se.hbase.test.model;

/**
 * Created by jholoman on 5/8/15.
 */
public class Why
{
    private String EvDe;

    public String getEvDe ()
    {
        return EvDe;
    }

    public void setEvDe (String EvDe)
    {
        this.EvDe = EvDe;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EvDe = "+EvDe+"]";
    }
}
