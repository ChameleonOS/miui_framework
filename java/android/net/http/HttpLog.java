// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.os.SystemClock;
import android.util.Log;

class HttpLog {

    HttpLog() {
    }

    static void e(String s) {
        Log.e("http", s);
    }

    static void v(String s) {
        Log.v("http", (new StringBuilder()).append(SystemClock.uptimeMillis()).append(" ").append(Thread.currentThread().getName()).append(" ").append(s).toString());
    }

    private static final boolean DEBUG = false;
    private static final String LOGTAG = "http";
    static final boolean LOGV;
}
