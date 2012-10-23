// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;


public class Smileys {

    public Smileys() {
    }

    public static int getSmileyResource(int i) {
        return sIconIds[i];
    }

    public static int ANGEL = 11;
    public static int COOL = 7;
    public static int CRYING = 13;
    public static int EMBARRASSED = 10;
    public static int FOOT_IN_MOUTH = 9;
    public static int HAPPY = 0;
    public static int KISSING = 5;
    public static int LAUGHING = 15;
    public static int LIPS_ARE_SEALED = 14;
    public static int MONEY_MOUTH = 8;
    public static int SAD = 1;
    public static int SURPRISED = 4;
    public static int TONGUE_STICKING_OUT = 3;
    public static int UNDECIDED = 12;
    public static int WINKING = 2;
    public static int WTF = 16;
    public static int YELLING = 6;
    private static final int sIconIds[];

    static  {
        int ai[] = new int[17];
        ai[0] = 0x1080263;
        ai[1] = 0x1080268;
        ai[2] = 0x108026c;
        ai[3] = 0x108026a;
        ai[4] = 0x1080269;
        ai[5] = 0x1080264;
        ai[6] = 0x108026e;
        ai[7] = 0x108025f;
        ai[8] = 0x1080267;
        ai[9] = 0x1080262;
        ai[10] = 0x1080261;
        ai[11] = 0x108025e;
        ai[12] = 0x108026b;
        ai[13] = 0x1080260;
        ai[14] = 0x1080266;
        ai[15] = 0x1080265;
        ai[16] = 0x108026d;
        sIconIds = ai;
    }
}
