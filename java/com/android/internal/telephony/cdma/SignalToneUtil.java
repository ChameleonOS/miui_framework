// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import java.util.HashMap;

public class SignalToneUtil {

    private SignalToneUtil() {
    }

    public static int getAudioToneFromSignalInfo(int i, int j, int k) {
        Integer integer = (Integer)hm.get(signalParamHash(i, j, k));
        int l;
        if(integer == null)
            l = -1;
        else
            l = integer.intValue();
        return l;
    }

    private static Integer signalParamHash(int i, int j, int k) {
        Integer integer;
        if(i < 0 || i > 256 || j > 256 || j < 0 || k > 256 || k < 0) {
            integer = new Integer(-1);
        } else {
            if(i != 2)
                j = 0;
            integer = new Integer(k + (256 * (i * 256) + j * 256));
        }
        return integer;
    }

    public static final int CDMA_INVALID_TONE = -1;
    public static final int IS95_CONST_IR_ALERT_HIGH = 1;
    public static final int IS95_CONST_IR_ALERT_LOW = 2;
    public static final int IS95_CONST_IR_ALERT_MED = 0;
    public static final int IS95_CONST_IR_SIGNAL_IS54B = 2;
    public static final int IS95_CONST_IR_SIGNAL_ISDN = 1;
    public static final int IS95_CONST_IR_SIGNAL_TONE = 0;
    public static final int IS95_CONST_IR_SIGNAL_USR_DEFD_ALERT = 4;
    public static final int IS95_CONST_IR_SIG_IS54B_L = 1;
    public static final int IS95_CONST_IR_SIG_IS54B_NO_TONE = 0;
    public static final int IS95_CONST_IR_SIG_IS54B_PBX_L = 7;
    public static final int IS95_CONST_IR_SIG_IS54B_PBX_SLS = 10;
    public static final int IS95_CONST_IR_SIG_IS54B_PBX_SS = 8;
    public static final int IS95_CONST_IR_SIG_IS54B_PBX_SSL = 9;
    public static final int IS95_CONST_IR_SIG_IS54B_PBX_S_X4 = 11;
    public static final int IS95_CONST_IR_SIG_IS54B_SLS = 5;
    public static final int IS95_CONST_IR_SIG_IS54B_SS = 2;
    public static final int IS95_CONST_IR_SIG_IS54B_SSL = 3;
    public static final int IS95_CONST_IR_SIG_IS54B_SS_2 = 4;
    public static final int IS95_CONST_IR_SIG_IS54B_S_X4 = 6;
    public static final int IS95_CONST_IR_SIG_ISDN_INTGRP = 1;
    public static final int IS95_CONST_IR_SIG_ISDN_NORMAL = 0;
    public static final int IS95_CONST_IR_SIG_ISDN_OFF = 15;
    public static final int IS95_CONST_IR_SIG_ISDN_PAT_3 = 3;
    public static final int IS95_CONST_IR_SIG_ISDN_PAT_5 = 5;
    public static final int IS95_CONST_IR_SIG_ISDN_PAT_6 = 6;
    public static final int IS95_CONST_IR_SIG_ISDN_PAT_7 = 7;
    public static final int IS95_CONST_IR_SIG_ISDN_PING = 4;
    public static final int IS95_CONST_IR_SIG_ISDN_SP_PRI = 2;
    public static final int IS95_CONST_IR_SIG_TONE_ABBR_ALRT = 0;
    public static final int IS95_CONST_IR_SIG_TONE_ABB_INT = 3;
    public static final int IS95_CONST_IR_SIG_TONE_ABB_RE = 5;
    public static final int IS95_CONST_IR_SIG_TONE_ANSWER = 8;
    public static final int IS95_CONST_IR_SIG_TONE_BUSY = 6;
    public static final int IS95_CONST_IR_SIG_TONE_CALL_W = 9;
    public static final int IS95_CONST_IR_SIG_TONE_CONFIRM = 7;
    public static final int IS95_CONST_IR_SIG_TONE_DIAL = 0;
    public static final int IS95_CONST_IR_SIG_TONE_INT = 2;
    public static final int IS95_CONST_IR_SIG_TONE_NO_TONE = 63;
    public static final int IS95_CONST_IR_SIG_TONE_PIP = 10;
    public static final int IS95_CONST_IR_SIG_TONE_REORDER = 4;
    public static final int IS95_CONST_IR_SIG_TONE_RING = 1;
    public static final int TAPIAMSSCDMA_SIGNAL_PITCH_UNKNOWN;
    private static HashMap hm;

    static  {
        hm = new HashMap();
        hm.put(signalParamHash(1, 0, 0), Integer.valueOf(45));
        hm.put(signalParamHash(1, 0, 1), Integer.valueOf(46));
        hm.put(signalParamHash(1, 0, 2), Integer.valueOf(47));
        hm.put(signalParamHash(1, 0, 3), Integer.valueOf(48));
        hm.put(signalParamHash(1, 0, 4), Integer.valueOf(49));
        hm.put(signalParamHash(1, 0, 5), Integer.valueOf(50));
        hm.put(signalParamHash(1, 0, 6), Integer.valueOf(51));
        hm.put(signalParamHash(1, 0, 7), Integer.valueOf(52));
        hm.put(signalParamHash(1, 0, 15), Integer.valueOf(98));
        hm.put(signalParamHash(0, 0, 0), Integer.valueOf(34));
        hm.put(signalParamHash(0, 0, 1), Integer.valueOf(35));
        hm.put(signalParamHash(0, 0, 2), Integer.valueOf(29));
        hm.put(signalParamHash(0, 0, 3), Integer.valueOf(30));
        hm.put(signalParamHash(0, 0, 4), Integer.valueOf(38));
        hm.put(signalParamHash(0, 0, 5), Integer.valueOf(39));
        hm.put(signalParamHash(0, 0, 6), Integer.valueOf(40));
        hm.put(signalParamHash(0, 0, 7), Integer.valueOf(32));
        hm.put(signalParamHash(0, 0, 8), Integer.valueOf(42));
        hm.put(signalParamHash(0, 0, 9), Integer.valueOf(43));
        hm.put(signalParamHash(0, 0, 10), Integer.valueOf(44));
        hm.put(signalParamHash(0, 0, 63), Integer.valueOf(98));
        hm.put(signalParamHash(2, 1, 1), Integer.valueOf(53));
        hm.put(signalParamHash(2, 0, 1), Integer.valueOf(54));
        hm.put(signalParamHash(2, 2, 1), Integer.valueOf(55));
        hm.put(signalParamHash(2, 1, 2), Integer.valueOf(56));
        hm.put(signalParamHash(2, 0, 2), Integer.valueOf(57));
        hm.put(signalParamHash(2, 2, 2), Integer.valueOf(58));
        hm.put(signalParamHash(2, 1, 3), Integer.valueOf(59));
        hm.put(signalParamHash(2, 0, 3), Integer.valueOf(60));
        hm.put(signalParamHash(2, 2, 3), Integer.valueOf(61));
        hm.put(signalParamHash(2, 1, 4), Integer.valueOf(62));
        hm.put(signalParamHash(2, 0, 4), Integer.valueOf(63));
        hm.put(signalParamHash(2, 2, 4), Integer.valueOf(64));
        hm.put(signalParamHash(2, 1, 5), Integer.valueOf(65));
        hm.put(signalParamHash(2, 0, 5), Integer.valueOf(66));
        hm.put(signalParamHash(2, 2, 5), Integer.valueOf(67));
        hm.put(signalParamHash(2, 1, 6), Integer.valueOf(68));
        hm.put(signalParamHash(2, 0, 6), Integer.valueOf(69));
        hm.put(signalParamHash(2, 2, 6), Integer.valueOf(70));
        hm.put(signalParamHash(2, 1, 7), Integer.valueOf(71));
        hm.put(signalParamHash(2, 0, 7), Integer.valueOf(72));
        hm.put(signalParamHash(2, 2, 7), Integer.valueOf(73));
        hm.put(signalParamHash(2, 1, 8), Integer.valueOf(74));
        hm.put(signalParamHash(2, 0, 8), Integer.valueOf(75));
        hm.put(signalParamHash(2, 2, 8), Integer.valueOf(76));
        hm.put(signalParamHash(2, 1, 9), Integer.valueOf(77));
        hm.put(signalParamHash(2, 0, 9), Integer.valueOf(78));
        hm.put(signalParamHash(2, 2, 9), Integer.valueOf(79));
        hm.put(signalParamHash(2, 1, 10), Integer.valueOf(80));
        hm.put(signalParamHash(2, 0, 10), Integer.valueOf(81));
        hm.put(signalParamHash(2, 2, 10), Integer.valueOf(82));
        hm.put(signalParamHash(2, 1, 11), Integer.valueOf(83));
        hm.put(signalParamHash(2, 0, 11), Integer.valueOf(84));
        hm.put(signalParamHash(2, 2, 11), Integer.valueOf(85));
        hm.put(signalParamHash(2, 0, 0), Integer.valueOf(98));
        hm.put(signalParamHash(4, 0, 0), Integer.valueOf(97));
        hm.put(signalParamHash(4, 0, 63), Integer.valueOf(97));
    }
}
