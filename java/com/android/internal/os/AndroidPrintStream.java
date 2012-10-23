// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.util.Log;

// Referenced classes of package com.android.internal.os:
//            LoggingPrintStream

class AndroidPrintStream extends LoggingPrintStream {

    public AndroidPrintStream(int i, String s) {
        if(s == null) {
            throw new NullPointerException("tag");
        } else {
            priority = i;
            tag = s;
            return;
        }
    }

    protected void log(String s) {
        Log.println(priority, tag, s);
    }

    private final int priority;
    private final String tag;
}
