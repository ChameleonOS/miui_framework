// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.Looper;

public class WindowManagerPolicyThread {

    public WindowManagerPolicyThread() {
    }

    public static Looper getLooper() {
        return mLooper;
    }

    public static Thread getThread() {
        return mThread;
    }

    public static void set(Thread thread, Looper looper) {
        mThread = thread;
        mLooper = looper;
    }

    static Looper mLooper;
    static Thread mThread;
}
