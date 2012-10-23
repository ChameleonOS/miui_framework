// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.util.AndroidRuntimeException;

final class WindowLeaked extends AndroidRuntimeException {

    public WindowLeaked(String s) {
        super(s);
    }
}
