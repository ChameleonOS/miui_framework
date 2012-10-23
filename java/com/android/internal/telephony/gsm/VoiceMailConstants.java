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

class VoiceMailConstants {

    VoiceMailConstants() {
        CarrierVmMap = new HashMap();
        loadVoiceMail();
    }

    private void loadVoiceMail() {
        File file = new File(Environment.getRootDirectory(), "etc/voicemail-conf.xml");
        FileReader filereader = new FileReader(file);
        XmlPullParser xmlpullparser;
        xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(filereader);
        XmlUtils.beginDocument(xmlpullparser, "voicemail");
_L3:
        boolean flag;
        XmlUtils.nextElement(xmlpullparser);
        flag = "voicemail".equals(xmlpullparser.getName());
        if(flag) goto _L2; else goto _L1
_L1:
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Log.w("GSM", (new StringBuilder()).append("Can't open ").append(Environment.getRootDirectory()).append("/").append("etc/voicemail-conf.xml").toString());
          goto _L1
_L2:
        String as[] = new String[3];
        String s = xmlpullparser.getAttributeValue(null, "numeric");
        as[0] = xmlpullparser.getAttributeValue(null, "carrier");
        as[1] = xmlpullparser.getAttributeValue(null, "vmnumber");
        as[2] = xmlpullparser.getAttributeValue(null, "vmtag");
        CarrierVmMap.put(s, as);
          goto _L3
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        Log.w("GSM", (new StringBuilder()).append("Exception in Voicemail parser ").append(xmlpullparserexception).toString());
          goto _L1
        IOException ioexception;
        ioexception;
        Log.w("GSM", (new StringBuilder()).append("Exception in Voicemail parser ").append(ioexception).toString());
          goto _L1
    }

    boolean containsCarrier(String s) {
        return CarrierVmMap.containsKey(s);
    }

    String getCarrierName(String s) {
        return ((String[])CarrierVmMap.get(s))[0];
    }

    String getVoiceMailNumber(String s) {
        return ((String[])CarrierVmMap.get(s))[1];
    }

    String getVoiceMailTag(String s) {
        return ((String[])CarrierVmMap.get(s))[2];
    }

    static final String LOG_TAG = "GSM";
    static final int NAME = 0;
    static final int NUMBER = 1;
    static final String PARTNER_VOICEMAIL_PATH = "etc/voicemail-conf.xml";
    static final int SIZE = 3;
    static final int TAG = 2;
    private HashMap CarrierVmMap;
}
