// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            SystemProperties

public final class Trace {

    private Trace() {
    }

    public static boolean isTagEnabled(long l) {
        boolean flag;
        if((l & sEnabledTags) != 0L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static native long nativeGetEnabledTags();

    private static native void nativeTraceBegin(long l, String s);

    private static native void nativeTraceCounter(long l, String s, int i);

    private static native void nativeTraceEnd(long l);

    public static void traceBegin(long l, String s) {
        if((l & sEnabledTags) != 0L)
            nativeTraceBegin(l, s);
    }

    public static void traceCounter(long l, String s, int i) {
        if((l & sEnabledTags) != 0L)
            nativeTraceCounter(l, s, i);
    }

    public static void traceEnd(long l) {
        if((l & sEnabledTags) != 0L)
            nativeTraceEnd(l);
    }

    public static final String PROPERTY_TRACE_TAG_ENABLEFLAGS = "debug.atrace.tags.enableflags";
    public static final int TRACE_FLAGS_START_BIT = 1;
    public static final String TRACE_TAGS[];
    public static final long TRACE_TAG_ACTIVITY_MANAGER = 64L;
    public static final long TRACE_TAG_ALWAYS = 1L;
    public static final long TRACE_TAG_AUDIO = 256L;
    public static final long TRACE_TAG_GRAPHICS = 2L;
    public static final long TRACE_TAG_INPUT = 4L;
    public static final long TRACE_TAG_NEVER = 0L;
    public static final long TRACE_TAG_SYNC_MANAGER = 128L;
    public static final long TRACE_TAG_VIDEO = 512L;
    public static final long TRACE_TAG_VIEW = 8L;
    public static final long TRACE_TAG_WEBVIEW = 16L;
    public static final long TRACE_TAG_WINDOW_MANAGER = 32L;
    private static long sEnabledTags = nativeGetEnabledTags();

    static  {
        String as[] = new String[9];
        as[0] = "Graphics";
        as[1] = "Input";
        as[2] = "View";
        as[3] = "WebView";
        as[4] = "Window Manager";
        as[5] = "Activity Manager";
        as[6] = "Sync Manager";
        as[7] = "Audio";
        as[8] = "Video";
        TRACE_TAGS = as;
        SystemProperties.addChangeCallback(new Runnable() {

            public void run() {
                Trace.sEnabledTags = Trace.nativeGetEnabledTags();
            }

        });
    }


/*
    static long access$002(long l) {
        sEnabledTags = l;
        return l;
    }

*/

}
