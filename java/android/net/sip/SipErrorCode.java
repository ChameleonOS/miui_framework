// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;


public class SipErrorCode {

    private SipErrorCode() {
    }

    public static String toString(int i) {
        i;
        JVM INSTR tableswitch -12 0: default 68
    //                   -12 145
    //                   -11 139
    //                   -10 133
    //                   -9 127
    //                   -8 121
    //                   -7 115
    //                   -6 109
    //                   -5 103
    //                   -4 97
    //                   -3 91
    //                   -2 85
    //                   -1 79
    //                   0 73;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        String s = "UNKNOWN";
_L16:
        return s;
_L14:
        s = "NO_ERROR";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "SOCKET_ERROR";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "SERVER_ERROR";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "TRANSACTION_TERMINTED";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "CLIENT_ERROR";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "TIME_OUT";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "INVALID_REMOTE_URI";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "PEER_NOT_REACHABLE";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "INVALID_CREDENTIALS";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "IN_PROGRESS";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "DATA_CONNECTION_LOST";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "CROSS_DOMAIN_AUTHENTICATION";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "SERVER_UNREACHABLE";
        if(true) goto _L16; else goto _L15
_L15:
    }

    public static final int CLIENT_ERROR = -4;
    public static final int CROSS_DOMAIN_AUTHENTICATION = -11;
    public static final int DATA_CONNECTION_LOST = -10;
    public static final int INVALID_CREDENTIALS = -8;
    public static final int INVALID_REMOTE_URI = -6;
    public static final int IN_PROGRESS = -9;
    public static final int NO_ERROR = 0;
    public static final int PEER_NOT_REACHABLE = -7;
    public static final int SERVER_ERROR = -2;
    public static final int SERVER_UNREACHABLE = -12;
    public static final int SOCKET_ERROR = -1;
    public static final int TIME_OUT = -5;
    public static final int TRANSACTION_TERMINTED = -3;
}
