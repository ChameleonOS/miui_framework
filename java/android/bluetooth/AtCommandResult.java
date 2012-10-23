// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;


public class AtCommandResult {

    public AtCommandResult(int i) {
        mResultCode = i;
        mResponse = new StringBuilder();
    }

    public AtCommandResult(String s) {
        this(0);
        addResponse(s);
    }

    public static void appendWithCrlf(StringBuilder stringbuilder, String s) {
        if(stringbuilder.length() > 0 && s.length() > 0)
            stringbuilder.append("\r\n\r\n");
        stringbuilder.append(s);
    }

    public void addResponse(String s) {
        appendWithCrlf(mResponse, s);
    }

    public void addResult(AtCommandResult atcommandresult) {
        if(atcommandresult != null) {
            appendWithCrlf(mResponse, atcommandresult.mResponse.toString());
            mResultCode = atcommandresult.mResultCode;
        }
    }

    public int getResultCode() {
        return mResultCode;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(mResponse.toString());
        mResultCode;
        JVM INSTR tableswitch 0 1: default 40
    //                   0 45
    //                   1 54;
           goto _L1 _L2 _L3
_L1:
        return stringbuilder.toString();
_L2:
        appendWithCrlf(stringbuilder, "OK");
        continue; /* Loop/switch isn't completed */
_L3:
        appendWithCrlf(stringbuilder, "ERROR");
        if(true) goto _L1; else goto _L4
_L4:
    }

    public static final int ERROR = 1;
    private static final String ERROR_STRING = "ERROR";
    public static final int OK = 0;
    private static final String OK_STRING = "OK";
    public static final int UNSOLICITED = 2;
    private StringBuilder mResponse;
    private int mResultCode;
}
