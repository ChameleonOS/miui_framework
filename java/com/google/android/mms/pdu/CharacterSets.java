// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class CharacterSets {

    private CharacterSets() {
    }

    public static int getMibEnumValue(String s) throws UnsupportedEncodingException {
        int i;
        if(s == null) {
            i = -1;
        } else {
            Integer integer = (Integer)NAME_TO_MIBENUM_MAP.get(s);
            if(integer == null)
                throw new UnsupportedEncodingException();
            i = integer.intValue();
        }
        return i;
    }

    public static String getMimeName(int i) throws UnsupportedEncodingException {
        String s = (String)MIBENUM_TO_NAME_MAP.get(Integer.valueOf(i));
        if(s == null)
            throw new UnsupportedEncodingException();
        else
            return s;
    }

    static final boolean $assertionsDisabled = false;
    public static final int ANY_CHARSET = 0;
    public static final int BIG5 = 2026;
    public static final int DEFAULT_CHARSET = 106;
    public static final String DEFAULT_CHARSET_NAME = "utf-8";
    public static final int ISO_8859_1 = 4;
    public static final int ISO_8859_2 = 5;
    public static final int ISO_8859_3 = 6;
    public static final int ISO_8859_4 = 7;
    public static final int ISO_8859_5 = 8;
    public static final int ISO_8859_6 = 9;
    public static final int ISO_8859_7 = 10;
    public static final int ISO_8859_8 = 11;
    public static final int ISO_8859_9 = 12;
    private static final int MIBENUM_NUMBERS[];
    private static final HashMap MIBENUM_TO_NAME_MAP;
    public static final String MIMENAME_ANY_CHARSET = "*";
    public static final String MIMENAME_BIG5 = "big5";
    public static final String MIMENAME_ISO_8859_1 = "iso-8859-1";
    public static final String MIMENAME_ISO_8859_2 = "iso-8859-2";
    public static final String MIMENAME_ISO_8859_3 = "iso-8859-3";
    public static final String MIMENAME_ISO_8859_4 = "iso-8859-4";
    public static final String MIMENAME_ISO_8859_5 = "iso-8859-5";
    public static final String MIMENAME_ISO_8859_6 = "iso-8859-6";
    public static final String MIMENAME_ISO_8859_7 = "iso-8859-7";
    public static final String MIMENAME_ISO_8859_8 = "iso-8859-8";
    public static final String MIMENAME_ISO_8859_9 = "iso-8859-9";
    public static final String MIMENAME_SHIFT_JIS = "shift_JIS";
    public static final String MIMENAME_UCS2 = "iso-10646-ucs-2";
    public static final String MIMENAME_US_ASCII = "us-ascii";
    public static final String MIMENAME_UTF_16 = "utf-16";
    public static final String MIMENAME_UTF_8 = "utf-8";
    private static final String MIME_NAMES[];
    private static final HashMap NAME_TO_MIBENUM_MAP;
    public static final int SHIFT_JIS = 17;
    public static final int UCS2 = 1000;
    public static final int US_ASCII = 3;
    public static final int UTF_16 = 1015;
    public static final int UTF_8 = 106;

    static  {
        boolean flag;
        int ai[];
        String as[];
        if(!com/google/android/mms/pdu/CharacterSets.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
        ai = new int[16];
        ai[0] = 0;
        ai[1] = 3;
        ai[2] = 4;
        ai[3] = 5;
        ai[4] = 6;
        ai[5] = 7;
        ai[6] = 8;
        ai[7] = 9;
        ai[8] = 10;
        ai[9] = 11;
        ai[10] = 12;
        ai[11] = 17;
        ai[12] = 106;
        ai[13] = 2026;
        ai[14] = 1000;
        ai[15] = 1015;
        MIBENUM_NUMBERS = ai;
        as = new String[16];
        as[0] = "*";
        as[1] = "us-ascii";
        as[2] = "iso-8859-1";
        as[3] = "iso-8859-2";
        as[4] = "iso-8859-3";
        as[5] = "iso-8859-4";
        as[6] = "iso-8859-5";
        as[7] = "iso-8859-6";
        as[8] = "iso-8859-7";
        as[9] = "iso-8859-8";
        as[10] = "iso-8859-9";
        as[11] = "shift_JIS";
        as[12] = "utf-8";
        as[13] = "big5";
        as[14] = "iso-10646-ucs-2";
        as[15] = "utf-16";
        MIME_NAMES = as;
        MIBENUM_TO_NAME_MAP = new HashMap();
        NAME_TO_MIBENUM_MAP = new HashMap();
        if(!$assertionsDisabled && MIBENUM_NUMBERS.length != MIME_NAMES.length)
            throw new AssertionError();
        int i = -1 + MIBENUM_NUMBERS.length;
        for(int j = 0; j <= i; j++) {
            MIBENUM_TO_NAME_MAP.put(Integer.valueOf(MIBENUM_NUMBERS[j]), MIME_NAMES[j]);
            NAME_TO_MIBENUM_MAP.put(MIME_NAMES[j], Integer.valueOf(MIBENUM_NUMBERS[j]));
        }

    }
}
