package com.cloudera.se.hbase.test.model;

/**
 * Created by jholoman on 5/8/15.
 */
public class Where
{
    private String AppsysId;
    private String ChnNm;
    private String ChnUsgNm;
    private String SubChnNm;
    private String ChnId;
    private String DataClctPrcsId;
    private String ChnLingId;
    private String SrcChnIndCd;
    private String EvDataSrcId;
    public String getAppsysId ()
    {
        return AppsysId;
    }

    public void setAppsysId (String AppsysId)
    {
        this.AppsysId = AppsysId;
    }

    public String getChnNm ()
    {
        return ChnNm;
    }

    public void setChnNm (String ChnNm)
    {
        this.ChnNm = ChnNm;
    }

    public String getChnUsgNm ()
    {
        return ChnUsgNm;
    }

    public void setChnUsgNm (String ChnUsgNm)
    {
        this.ChnUsgNm = ChnUsgNm;
    }

    public String getSubChnNm ()
    {
        return SubChnNm;
    }

    public void setSubChnNm (String SubChnNm)
    {
        this.SubChnNm = SubChnNm;
    }

    public String getChnId ()
    {
        return ChnId;
    }

    public void setChnId (String ChnId)
    {
        this.ChnId = ChnId;
    }

    public String getDataClctPrcsId ()
    {
        return DataClctPrcsId;
    }

    public void setDataClctPrcsId (String DataClctPrcsId)
    {
        this.DataClctPrcsId = DataClctPrcsId;
    }

    public String getChnLingId ()
    {
        return ChnLingId;
    }

    public void setChnLingId (String ChnLingId)
    {
        this.ChnLingId = ChnLingId;
    }

    public String getSrcChnIndCd ()
    {
        return SrcChnIndCd;
    }

    public void setSrcChnIndCd (String SrcChnIndCd)
    {
        this.SrcChnIndCd = SrcChnIndCd;
    }

    public String getEvDataSrcId ()
    {
        return EvDataSrcId;
    }

    public void setEvDataSrcId (String EvDataSrcId)
    {
        this.EvDataSrcId = EvDataSrcId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [AppsysId = "+AppsysId+", ChnNm = "+ChnNm+", ChnUsgNm = "+ChnUsgNm+", SubChnNm = "+SubChnNm+", ChnId = "+ChnId+", DataClctPrcsId = "+DataClctPrcsId+", ChnLingId = "+ChnLingId+", SrcChnIndCd = "+SrcChnIndCd+", EvDataSrcId = "+EvDataSrcId+"]";
    }
}
