// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            Log

public final class Slog {

    private Slog() {
    }

    public static int d(String s, String s1) {
        return Log.println_native(3, 3, s, s1);
    }

    public static int d(String s, String s1, Throwable throwable) {
        return Log.println_native(3, 3, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    public static int e(String s, String s1) {
        return Log.println_native(3, 6, s, s1);
    }

    public static int e(String s, String s1, Throwable throwable) {
        return Log.println_native(3, 6, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    public static int i(String s, String s1) {
        return Log.println_native(3, 4, s, s1);
    }

    public static int i(String s, String s1, Throwable throwable) {
        return Log.println_native(3, 4, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    public static int println(int j, String s, String s1) {
        return Log.println_native(3, j, s, s1);
    }

    public static int v(String s, String s1) {
        return Log.println_native(3, 2, s, s1);
    }

    public static int v(String s, String s1, Throwable throwable) {
        return Log.println_native(3, 2, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    public static int w(String s, String s1) {
        return Log.println_native(3, 5, s, s1);
    }

    public static int w(String s, String s1, Throwable throwable) {
        return Log.println_native(3, 5, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    public static int w(String s, Throwable throwable) {
        return Log.println_native(3, 5, s, Log.getStackTraceString(throwable));
    }
}
