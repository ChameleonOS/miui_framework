// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class PowerProfile {

    public PowerProfile(Context context) {
        if(sPowerMap.size() == 0)
            readPowerValuesFromXml(context);
    }

    private void readPowerValuesFromXml(Context context) {
        XmlResourceParser xmlresourceparser;
        boolean flag;
        ArrayList arraylist;
        String s;
        xmlresourceparser = context.getResources().getXml(0x10f000a);
        flag = false;
        arraylist = new ArrayList();
        s = null;
        XmlUtils.beginDocument(xmlresourceparser, "device");
_L5:
        String s1;
        XmlUtils.nextElement(xmlresourceparser);
        s1 = xmlresourceparser.getName();
        if(s1 != null) goto _L2; else goto _L1
_L1:
        if(flag)
            sPowerMap.put(s, ((Object) (arraylist.toArray(new Double[arraylist.size()]))));
        xmlresourceparser.close();
        return;
_L2:
        if(!flag)
            break MISSING_BLOCK_LABEL_118;
        if(!s1.equals("value")) {
            sPowerMap.put(s, ((Object) (arraylist.toArray(new Double[arraylist.size()]))));
            flag = false;
        }
        if(!s1.equals("array")) goto _L4; else goto _L3
_L3:
        flag = true;
        arraylist.clear();
        s = xmlresourceparser.getAttributeValue(null, "name");
          goto _L5
_L4:
        if(!s1.equals("item") && !s1.equals("value")) goto _L5; else goto _L6
_L6:
        String s2;
        s2 = null;
        if(!flag)
            s2 = xmlresourceparser.getAttributeValue(null, "name");
        if(xmlresourceparser.next() != 4) goto _L5; else goto _L7
_L7:
        String s3 = xmlresourceparser.getText();
        double d = 0.0D;
        double d1 = Double.valueOf(s3).doubleValue();
        d = d1;
_L11:
        if(!s1.equals("item")) goto _L9; else goto _L8
_L8:
        sPowerMap.put(s2, Double.valueOf(d));
          goto _L5
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        throw new RuntimeException(xmlpullparserexception);
        Exception exception;
        exception;
        xmlresourceparser.close();
        throw exception;
_L9:
        if(!flag) goto _L5; else goto _L10
_L10:
        arraylist.add(Double.valueOf(d));
          goto _L5
        IOException ioexception;
        ioexception;
        throw new RuntimeException(ioexception);
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L11
    }

    public double getAveragePower(String s) {
        double d;
        if(sPowerMap.containsKey(s)) {
            Object obj = sPowerMap.get(s);
            if(obj instanceof Double[])
                d = ((Double[])(Double[])obj)[0].doubleValue();
            else
                d = ((Double)sPowerMap.get(s)).doubleValue();
        } else {
            d = 0.0D;
        }
        return d;
    }

    public double getAveragePower(String s, int i) {
        double d = 0.0D;
        if(!sPowerMap.containsKey(s)) goto _L2; else goto _L1
_L1:
        Object obj = sPowerMap.get(s);
        if(!(obj instanceof Double[])) goto _L4; else goto _L3
_L3:
        Double adouble[] = (Double[])(Double[])obj;
        if(adouble.length <= i || i < 0) goto _L6; else goto _L5
_L5:
        d = adouble[i].doubleValue();
_L2:
        return d;
_L6:
        if(i >= 0)
            d = adouble[-1 + adouble.length].doubleValue();
        continue; /* Loop/switch isn't completed */
_L4:
        d = ((Double)obj).doubleValue();
        if(true) goto _L2; else goto _L7
_L7:
    }

    public double getBatteryCapacity() {
        return getAveragePower("battery.capacity");
    }

    public int getNumSpeedSteps() {
        Object obj = sPowerMap.get("cpu.speeds");
        int i;
        if(obj != null && (obj instanceof Double[]))
            i = ((Double[])(Double[])obj).length;
        else
            i = 1;
        return i;
    }

    private static final String ATTR_NAME = "name";
    public static final String POWER_AUDIO = "dsp.audio";
    public static final String POWER_BATTERY_CAPACITY = "battery.capacity";
    public static final String POWER_BLUETOOTH_ACTIVE = "bluetooth.active";
    public static final String POWER_BLUETOOTH_AT_CMD = "bluetooth.at";
    public static final String POWER_BLUETOOTH_ON = "bluetooth.on";
    public static final String POWER_CPU_ACTIVE = "cpu.active";
    public static final String POWER_CPU_AWAKE = "cpu.awake";
    public static final String POWER_CPU_IDLE = "cpu.idle";
    public static final String POWER_CPU_SPEEDS = "cpu.speeds";
    public static final String POWER_GPS_ON = "gps.on";
    public static final String POWER_NONE = "none";
    public static final String POWER_RADIO_ACTIVE = "radio.active";
    public static final String POWER_RADIO_ON = "radio.on";
    public static final String POWER_RADIO_SCANNING = "radio.scanning";
    public static final String POWER_SCREEN_FULL = "screen.full";
    public static final String POWER_SCREEN_ON = "screen.on";
    public static final String POWER_VIDEO = "dsp.video";
    public static final String POWER_WIFI_ACTIVE = "wifi.active";
    public static final String POWER_WIFI_ON = "wifi.on";
    public static final String POWER_WIFI_SCAN = "wifi.scan";
    private static final String TAG_ARRAY = "array";
    private static final String TAG_ARRAYITEM = "value";
    private static final String TAG_DEVICE = "device";
    private static final String TAG_ITEM = "item";
    static final HashMap sPowerMap = new HashMap();

}
