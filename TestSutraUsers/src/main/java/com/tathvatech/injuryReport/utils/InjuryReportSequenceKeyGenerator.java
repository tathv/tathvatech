package com.tathvatech.injuryReport.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.tathvatech.ts.caf.core.SequenceIdGenerator;
import com.tathvatech.ts.core.sites.SiteOID;

public class InjuryReportSequenceKeyGenerator
{
    private static String SEQUENCE_KEY = "INJURY";
    private static String PREFIX = "INJ";
    private int siteFk;
    private String siteName;
    public InjuryReportSequenceKeyGenerator(int siteFk, String siteName)
    {
        this.siteFk=siteFk;
        this.siteName=siteName;
    }

    public String getNextSeq() throws Exception
    {
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int seqNo = SequenceIdGenerator.getNextSequence(SEQUENCE_KEY, ""+siteFk, year + "", null, null);
        if(seqNo < 10)
            return PREFIX + "_" + siteName + "_" + year + "_" + "00" + seqNo;
        else if(seqNo < 100)
            return PREFIX + "_" + siteName+ "_" + year + "_" + "0" + seqNo;
        else
            return PREFIX + "_" + siteName + "_" + year + "_" + "" + seqNo;
    }
}
