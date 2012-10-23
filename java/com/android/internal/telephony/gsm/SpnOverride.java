// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import java.io.*;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SpnOverride {

    SpnOverride() {
        CarrierSpnMap = new HashMap();
        loadSpnOverrides();
    }

    private void loadSpnOverrides() {
        File file = new File(Environment.getRootDirectory(), "etc/spn-conf.xml");
        FileReader filereader = new FileReader(file);
        XmlPullParser xmlpullparser;
        xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(filereader);
        XmlUtils.beginDocument(xmlpullparser, "spnOverrides");
_L3:
        boolean flag;
        XmlUtils.nextElement(xmlpullparser);
        flag = "spnOverride".equals(xmlpullparser.getName());
        if(flag) goto _L2; else goto _L1
_L1:
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Log.w("GSM", (new StringBuilder()).append("Can't open ").append(Environment.getRootDirectory()).append("/").append("etc/spn-conf.xml").toString());
          goto _L1
_L2:
        String s = xmlpullparser.getAttributeValue(null, "numeric");
        String s1 = xmlpullparser.getAttributeValue(null, "spn");
        CarrierSpnMap.put(s, s1);
          goto _L3
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        Log.w("GSM", (new StringBuilder()).append("Exception in spn-conf parser ").append(xmlpullparserexception).toString());
          goto _L1
        IOException ioexception;
        ioexception;
        Log.w("GSM", (new StringBuilder()).append("Exception in spn-conf parser ").append(ioexception).toString());
          goto _L1
    }

    boolean containsCarrier(String s) {
        return CarrierSpnMap.containsKey(s);
    }

    String getSpn(String s) {
        return (String)CarrierSpnMap.get(s);
    }

    static final String LOG_TAG = "GSM";
    static final String PARTNER_SPN_OVERRIDE_PATH = "etc/spn-conf.xml";
    private HashMap CarrierSpnMap;
}
