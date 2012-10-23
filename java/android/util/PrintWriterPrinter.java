// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.PrintWriter;

// Referenced classes of package android.util:
//            Printer

public class PrintWriterPrinter
    implements Printer {

    public PrintWriterPrinter(PrintWriter printwriter) {
        mPW = printwriter;
    }

    public void println(String s) {
        mPW.println(s);
    }

    private final PrintWriter mPW;
}
