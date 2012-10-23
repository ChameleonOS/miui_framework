// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            Printer, Log

public class LogPrinter
    implements Printer {

    public LogPrinter(int i, String s) {
        mPriority = i;
        mTag = s;
        mBuffer = 0;
    }

    public LogPrinter(int i, String s, int j) {
        mPriority = i;
        mTag = s;
        mBuffer = j;
    }

    public void println(String s) {
        Log.println_native(mBuffer, mPriority, mTag, s);
    }

    private final int mBuffer;
    private final int mPriority;
    private final String mTag;
}
