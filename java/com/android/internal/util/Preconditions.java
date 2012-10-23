// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;


public class Preconditions {

    public Preconditions() {
    }

    public static Object checkNotNull(Object obj) {
        if(obj == null)
            throw new NullPointerException();
        else
            return obj;
    }

    public static Object checkNotNull(Object obj, Object obj1) {
        if(obj == null)
            throw new NullPointerException(String.valueOf(obj1));
        else
            return obj;
    }
}
