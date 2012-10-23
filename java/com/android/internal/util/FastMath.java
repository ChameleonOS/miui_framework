// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;


public class FastMath {

    public FastMath() {
    }

    public static int round(float f) {
        return (int)(0x800000L + (long)(1.677722E+07F * f) >> 24);
    }
}
