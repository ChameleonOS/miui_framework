// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.os.IBinder;
import android.os.SystemClock;
import android.util.EventLog;
import java.lang.ref.WeakReference;

public class BinderInternal {
    static final class GcWatcher {

        protected void finalize() throws Throwable {
            BinderInternal.handleGc();
            BinderInternal.mLastGcTime = SystemClock.uptimeMillis();
            BinderInternal.mGcWatcher = new WeakReference(new GcWatcher());
        }

        GcWatcher() {
        }
    }


    public BinderInternal() {
    }

    public static final native void disableBackgroundScheduling(boolean flag);

    static void forceBinderGc() {
        forceGc("Binder");
    }

    public static void forceGc(String s) {
        EventLog.writeEvent(2741, s);
        Runtime.getRuntime().gc();
    }

    public static final native IBinder getContextObject();

    public static long getLastGcTime() {
        return mLastGcTime;
    }

    static final native void handleGc();

    public static final native void joinThreadPool();

    static WeakReference mGcWatcher = new WeakReference(new GcWatcher());
    static long mLastGcTime;

}
