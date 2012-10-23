// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.util.Arrays;

public class Objects {

    public Objects() {
    }

    public static boolean equal(Object obj, Object obj1) {
        boolean flag;
        if(obj == obj1 || obj != null && obj.equals(obj1))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static transient int hashCode(Object aobj[]) {
        return Arrays.hashCode(aobj);
    }
}
