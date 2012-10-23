// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


public final class PresentationType extends Enum {

    private PresentationType(String s, int i) {
        super(s, i);
    }

    public static PresentationType valueOf(String s) {
        return (PresentationType)Enum.valueOf(com/android/internal/telephony/cat/PresentationType, s);
    }

    public static PresentationType[] values() {
        return (PresentationType[])$VALUES.clone();
    }

    private static final PresentationType $VALUES[];
    public static final PresentationType DATA_VALUES;
    public static final PresentationType NAVIGATION_OPTIONS;
    public static final PresentationType NOT_SPECIFIED;

    static  {
        NOT_SPECIFIED = new PresentationType("NOT_SPECIFIED", 0);
        DATA_VALUES = new PresentationType("DATA_VALUES", 1);
        NAVIGATION_OPTIONS = new PresentationType("NAVIGATION_OPTIONS", 2);
        PresentationType apresentationtype[] = new PresentationType[3];
        apresentationtype[0] = NOT_SPECIFIED;
        apresentationtype[1] = DATA_VALUES;
        apresentationtype[2] = NAVIGATION_OPTIONS;
        $VALUES = apresentationtype;
    }
}
