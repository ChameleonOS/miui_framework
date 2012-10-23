// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;


public class ErrorCodes {

    public ErrorCodes() {
    }

    public static String asString(int i) {
        i;
        JVM INSTR tableswitch -21 0: default 104
    //                   -21 235
    //                   -20 229
    //                   -19 223
    //                   -18 217
    //                   -17 211
    //                   -16 205
    //                   -15 199
    //                   -14 193
    //                   -13 187
    //                   -12 181
    //                   -11 175
    //                   -10 169
    //                   -9 163
    //                   -8 157
    //                   -7 151
    //                   -6 145
    //                   -5 139
    //                   -4 133
    //                   -3 127
    //                   -2 121
    //                   -1 115
    //                   0 109;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
        String s = "UNKNOWN ERROR";
_L25:
        return s;
_L23:
        s = "SUCCESS";
        continue; /* Loop/switch isn't completed */
_L22:
        s = "IO";
        continue; /* Loop/switch isn't completed */
_L21:
        s = "CANCELLED";
        continue; /* Loop/switch isn't completed */
_L20:
        s = "TIMEOUT";
        continue; /* Loop/switch isn't completed */
_L19:
        s = "BUSY";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "CONNECT/DISCONNECT";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "READ";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "WRITE";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "INVALID_PARAM";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "INSUFFICIENT_RESOURCES";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "SOCKET_CREATION";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "SOCKET_NOT_CONNECTED";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "BUFFER_TO_SMALL";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "SAP_USED";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "SERVICE_NAME_USED";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "SOCKET_OPTIONS";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "NFC_ON";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "NOT_INITIALIZED";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "SE_ALREADY_SELECTED";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "SE_CONNECTED";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "NO_SE_CONNECTED";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "NOT_SUPPORTED";
        if(true) goto _L25; else goto _L24
_L24:
    }

    public static boolean isError(int i) {
        boolean flag;
        if(i < 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final int ERROR_BUFFER_TO_SMALL = -12;
    public static final int ERROR_BUSY = -4;
    public static final int ERROR_CANCELLED = -2;
    public static final int ERROR_CONNECT = -5;
    public static final int ERROR_DISCONNECT = -5;
    public static final int ERROR_INSUFFICIENT_RESOURCES = -9;
    public static final int ERROR_INVALID_PARAM = -8;
    public static final int ERROR_IO = -1;
    public static final int ERROR_NFC_ON = -16;
    public static final int ERROR_NOT_INITIALIZED = -17;
    public static final int ERROR_NOT_SUPPORTED = -21;
    public static final int ERROR_NO_SE_CONNECTED = -20;
    public static final int ERROR_READ = -6;
    public static final int ERROR_SAP_USED = -13;
    public static final int ERROR_SERVICE_NAME_USED = -14;
    public static final int ERROR_SE_ALREADY_SELECTED = -18;
    public static final int ERROR_SE_CONNECTED = -19;
    public static final int ERROR_SOCKET_CREATION = -10;
    public static final int ERROR_SOCKET_NOT_CONNECTED = -11;
    public static final int ERROR_SOCKET_OPTIONS = -15;
    public static final int ERROR_TIMEOUT = -3;
    public static final int ERROR_WRITE = -7;
    public static final int SUCCESS;
}
