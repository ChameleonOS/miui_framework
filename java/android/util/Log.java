// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import com.android.internal.os.RuntimeInit;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public final class Log {
    public static interface TerribleFailureHandler {

        public abstract void onTerribleFailure(String s, TerribleFailure terriblefailure);
    }

    private static class TerribleFailure extends Exception {

        TerribleFailure(String s, Throwable throwable) {
            super(s, throwable);
        }
    }


    private Log() {
    }

    public static int d(String s, String s1) {
        return println_native(0, 3, s, s1);
    }

    public static int d(String s, String s1, Throwable throwable) {
        return println_native(0, 3, s, (new StringBuilder()).append(s1).append('\n').append(getStackTraceString(throwable)).toString());
    }

    public static int e(String s, String s1) {
        return println_native(0, 6, s, s1);
    }

    public static int e(String s, String s1, Throwable throwable) {
        return println_native(0, 6, s, (new StringBuilder()).append(s1).append('\n').append(getStackTraceString(throwable)).toString());
    }

    public static String getStackTraceString(Throwable throwable) {
        if(throwable != null) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        return s;
_L2:
        Throwable throwable1 = throwable;
        do {
            if(throwable1 == null)
                break;
            if(throwable1 instanceof UnknownHostException) {
                s = "";
                continue; /* Loop/switch isn't completed */
            }
            throwable1 = throwable1.getCause();
        } while(true);
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        s = stringwriter.toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static int i(String s, String s1) {
        return println_native(0, 4, s, s1);
    }

    public static int i(String s, String s1, Throwable throwable) {
        return println_native(0, 4, s, (new StringBuilder()).append(s1).append('\n').append(getStackTraceString(throwable)).toString());
    }

    public static native boolean isLoggable(String s, int j);

    public static int println(int j, String s, String s1) {
        return println_native(0, j, s, s1);
    }

    public static native int println_native(int j, int k, String s, String s1);

    public static TerribleFailureHandler setWtfHandler(TerribleFailureHandler terriblefailurehandler) {
        if(terriblefailurehandler == null) {
            throw new NullPointerException("handler == null");
        } else {
            TerribleFailureHandler terriblefailurehandler1 = sWtfHandler;
            sWtfHandler = terriblefailurehandler;
            return terriblefailurehandler1;
        }
    }

    public static int v(String s, String s1) {
        return println_native(0, 2, s, s1);
    }

    public static int v(String s, String s1, Throwable throwable) {
        return println_native(0, 2, s, (new StringBuilder()).append(s1).append('\n').append(getStackTraceString(throwable)).toString());
    }

    public static int w(String s, String s1) {
        return println_native(0, 5, s, s1);
    }

    public static int w(String s, String s1, Throwable throwable) {
        return println_native(0, 5, s, (new StringBuilder()).append(s1).append('\n').append(getStackTraceString(throwable)).toString());
    }

    public static int w(String s, Throwable throwable) {
        return println_native(0, 5, s, getStackTraceString(throwable));
    }

    public static int wtf(String s, String s1) {
        return wtf(s, s1, null);
    }

    public static int wtf(String s, String s1, Throwable throwable) {
        TerribleFailure terriblefailure = new TerribleFailure(s1, throwable);
        int j = println_native(0, 7, s, (new StringBuilder()).append(s1).append('\n').append(getStackTraceString(throwable)).toString());
        sWtfHandler.onTerribleFailure(s, terriblefailure);
        return j;
    }

    public static int wtf(String s, Throwable throwable) {
        return wtf(s, throwable.getMessage(), throwable);
    }

    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int LOG_ID_EVENTS = 2;
    public static final int LOG_ID_MAIN = 0;
    public static final int LOG_ID_RADIO = 1;
    public static final int LOG_ID_SYSTEM = 3;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static TerribleFailureHandler sWtfHandler = new TerribleFailureHandler() {

        public void onTerribleFailure(String s, TerribleFailure terriblefailure) {
            RuntimeInit.wtf(s, terriblefailure);
        }

    };

}
