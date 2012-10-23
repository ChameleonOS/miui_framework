// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.util.Log;

public abstract class CatLog {

    public CatLog() {
    }

    public static void d(Object obj, String s) {
        String s1 = obj.getClass().getName();
        Log.d("CAT", (new StringBuilder()).append(s1.substring(1 + s1.lastIndexOf('.'))).append(": ").append(s).toString());
    }

    public static void d(String s, String s1) {
        Log.d("CAT", (new StringBuilder()).append(s).append(": ").append(s1).toString());
    }

    static final boolean DEBUG = true;
}
