// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            Printer

public class PrefixPrinter
    implements Printer {

    private PrefixPrinter(Printer printer, String s) {
        mPrinter = printer;
        mPrefix = s;
    }

    public static Printer create(Printer printer, String s) {
        if(s != null && !s.equals(""))
            printer = new PrefixPrinter(printer, s);
        return printer;
    }

    public void println(String s) {
        mPrinter.println((new StringBuilder()).append(mPrefix).append(s).toString());
    }

    private final String mPrefix;
    private final Printer mPrinter;
}
