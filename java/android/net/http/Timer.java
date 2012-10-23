// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.os.SystemClock;

class Timer {

    public Timer() {
        long l = SystemClock.uptimeMillis();
        mLast = l;
        mStart = l;
    }

    public void mark(String s) {
        mLast = SystemClock.uptimeMillis();
    }

    private long mLast;
    private long mStart;
}
