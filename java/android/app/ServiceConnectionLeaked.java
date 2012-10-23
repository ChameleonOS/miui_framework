// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.util.AndroidRuntimeException;

final class ServiceConnectionLeaked extends AndroidRuntimeException {

    public ServiceConnectionLeaked(String s) {
        super(s);
    }
}
