package com.cloudera.se.hbase.test.model;

/**
 * Created by jholoman on 5/8/15.
 */
public class Who
{
    private String PtyId;

    private String EvHubCstId;

    private String OlbId;

    public String getPtyId ()
    {
        return PtyId;
    }

    public void setPtyId (String PtyId)
    {
        this.PtyId = PtyId;
    }

    public String getEvHubCstId ()
    {
        return EvHubCstId;
    }

    public void setEvHubCstId (String EvHubCstId)
    {
        this.EvHubCstId = EvHubCstId;
    }

    public String getOlbId ()
    {
        return OlbId;
    }

    public void setOlbId (String OlbId)
    {
        this.OlbId = OlbId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [PtyId = "+PtyId+", EvHubCstId = "+EvHubCstId+", OlbId = "+OlbId+"]";
    }
}
