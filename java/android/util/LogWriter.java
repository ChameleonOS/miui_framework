// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.Writer;

// Referenced classes of package android.util:
//            Log

public class LogWriter extends Writer {

    public LogWriter(int i, String s) {
        mBuilder = new StringBuilder(128);
        mPriority = i;
        mTag = s;
        mBuffer = 0;
    }

    public LogWriter(int i, String s, int j) {
        mBuilder = new StringBuilder(128);
        mPriority = i;
        mTag = s;
        mBuffer = j;
    }

    private void flushBuilder() {
        if(mBuilder.length() > 0) {
            Log.println_native(mBuffer, mPriority, mTag, mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
        }
    }

    public void close() {
        flushBuilder();
    }

    public void flush() {
        flushBuilder();
    }

    public void write(char ac[], int i, int j) {
        int k = 0;
        while(k < j)  {
            char c = ac[i + k];
            if(c == '\n')
                flushBuilder();
            else
                mBuilder.append(c);
            k++;
        }
    }

    private final int mBuffer;
    private StringBuilder mBuilder;
    private final int mPriority;
    private final String mTag;
}
