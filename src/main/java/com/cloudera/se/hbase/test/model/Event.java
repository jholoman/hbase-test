package com.cloudera.se.hbase.test.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by jholoman on 5/8/15.
 */
public class Event
{
    private Where Where;

    private Why Why;

    private Who Who;

    private What What;

    private When When;

    public Event(Who who, What what, When when, Where where, Why why) {
        Where = where;
        Why = why;
        Who = who;
        What = what;
        When = when;
    }
    public Event() {
        Who = new Who();
        What = new What();
        When = new When();
        Where = new Where();
        Why = new Why();

        randomize(Who);
        randomize(What);
        randomize(When);
        randomize(Where);
        randomize(Why);
}
    public Where getWhere ()
    {
        return Where;
    }

    public void setWhere (Where Where)
    {
        this.Where = Where;
    }

    public Why getWhy ()
    {
        return Why;
    }

    public void setWhy (Why Why)
    {
        this.Why = Why;
    }

    public Who getWho ()
    {
        return Who;
    }

    public void setWho (Who Who)
    {
        this.Who = Who;
    }

    public What getWhat ()
    {
        return What;
    }

    public void setWhat (What What)
    {
        this.What = What;
    }

    public When getWhen ()
    {
        return When;
    }

    public void setWhen (When When)
    {
        this.When = When;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Where = "+Where+", Why = "+Why+", Who = "+Who+", What = "+What+", When = "+When+"]";
    }

    /*
  "Who":{
     "EvHubCstId":"dcca70a0-bccd-4e11-9323-e06af6321364",
     "OlbId":"amohammad@gmail.com",
     "PtyId":"20041701615"
  },
  */
    public static void randomize (Who who) {
        who.setEvHubCstId(String.valueOf(UUID.randomUUID()));
        who.setOlbId(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(0, 10)) + "@gmail.com");
        who.setPtyId(RandomStringUtils.randomNumeric(12));
    }
    /*
    "What":{
        "BrwsNm":"Firefox 3.0",
                "BusPrcsCd":"4.1.06.04.22",
                "BusPrcsNm":"Prompt For Single Sign On Validation",
                "BusTskNm":"Connect To Service",
                "DataClctTypCd":"OLBBusinessEvent",
                "DgtlBnkRsnCd":"",
                "DigBnkEvStsCd":"100",
                "EvExpncNm":"Neutral",
                "EvId":"61",
                "EvInstId":"77ab6da1-ec5b-11e4-a19c-6b772ff80d0e",
                "EvNm":"SSO Link From OLB To MyMerrill Redirect Initiated",
                "EvPrtyCd":"Normal",
                "EvTypNm":"MyMerrill Link Selection Captured",
                "EvTypSchmCd":"BRWS",
                "EvTypSchmNm":"Browsing",
                "LangCd":"en_us",
                "SessionId":"gzpb3Zf7MDT9XkZ8MXx4sesJm6FmUpzvV22rXQH1",
                "SrcEvTypCd":"680",
                "SvcCtgyId":"PPD",
                "SvcPrdNm":"BOR"
    },
    */
    public static void randomize (What what) {
        what.setBrwsNm(RandomStringUtils.randomAlphabetic(10));
        what.setBusPrcsCd(RandomStringUtils.randomAlphanumeric(12));
        what.setBusPrcsNm(RandomStringUtils.randomAlphabetic(30));
        what.setBusTskNm(RandomStringUtils.randomAlphabetic(12));
        what.setDataClctTypCd(RandomStringUtils.randomAlphabetic(15));
        what.setDigBnkEvStsCd(RandomStringUtils.randomNumeric(3));
        what.setEvExpncNm("Neutral");
        what.setEvId(RandomStringUtils.randomNumeric(2));
        what.setEvInstId(String.valueOf(UUID.randomUUID()));
        what.setEvNm(RandomStringUtils.randomAlphabetic(50));
        what.setEvPrtyCd("Normal");
        what.setEvTypNm(RandomStringUtils.randomAlphabetic(40));
        what.setEvTypSchmCd(RandomStringUtils.randomAlphabetic(3));
        what.setEvTypSchmNm(RandomStringUtils.randomAlphabetic(9));
        what.setLangCd("en_us");
        what.setSessionId(RandomStringUtils.randomAlphanumeric(41));
        what.setSrcEvTypCd(RandomStringUtils.randomNumeric(3));
        what.setSvcCtgyId(RandomStringUtils.randomAlphabetic(3));
        what.setSvcPrdNm(RandomStringUtils.randomAlphabetic(3));
    }
    /*
    "EndTs":"2015-04-26T21:27:57.645+0000",
            "EvTs":"2015-04-26T21:27:57.645+0000",
            "EvTypDataRtntnQt":"30",
            "StrtTs":"2015-04-26T21:27:57.645+0000",
            "TxnmyRfrshTs":"2015-04-24T15:10"
}
*/
    public static void randomize (When when) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss.SSS");
        String now = sdf.format(new Date());

        when.setEndTs(now);
        when.setEvTs(now);
        when.setStrtTs(now);
        when.setTxnmyRfrshTs(now);
        when.setEvTypDataRtntnQt(RandomStringUtils.randomNumeric(2));
    }
    /*"Where":{
      "AppsysId":"CEOAS",
      "ChnId":"15",
      "ChnLingId":"116",
      "ChnNm":"OnlineBanking",
      "ChnUsgNm":"Digital",
      "DataClctPrcsId":"EVTUSG-CAS-OLB",
      "EvDataSrcId":"OLB",
      "SrcChnIndCd":"I",
      "SubChnNm":"Desktop"
   },
   */
    public static void randomize (Where where) {
        where.setAppsysId(RandomStringUtils.randomAlphanumeric(5));
        where.setChnId(RandomStringUtils.randomNumeric(2));
        where.setChnLingId(RandomStringUtils.randomNumeric(3));
        where.setChnNm("Online Banking");
        where.setChnUsgNm("Digital");
        where.setDataClctPrcsId(RandomStringUtils.randomAlphabetic(15));
        where.setEvDataSrcId(RandomStringUtils.randomAlphabetic(3));
        where.setSrcChnIndCd("I");
        where.setSubChnNm("Desktop");
    }
    /*
    "Why":{
        "EvDe":"Customer Accessed MyMerrill From Single Sign-On Link In OLB"
    },
    */
    public static void randomize (Why why) {
        why.setEvDe(RandomStringUtils.randomAlphabetic(60));
    }

    public String getPayLoad() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        return mapper.writeValueAsString(this);
    }

}
