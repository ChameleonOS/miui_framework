// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.util.EventLog;

public class EventLogTags {

    private EventLogTags() {
    }

    public static void writeBrowserDoubleTapDuration(int i, long l) {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Long.valueOf(l);
        EventLog.writeEvent(0x111d6, aobj);
    }

    public static void writeBrowserSnapCenter() {
        EventLog.writeEvent(0x11206, new Object[0]);
    }

    public static void writeBrowserTextSizeChange(int i, int j) {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        EventLog.writeEvent(0x11207, aobj);
    }

    public static void writeBrowserZoomLevelChange(int i, int j, long l) {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Long.valueOf(l);
        EventLog.writeEvent(0x111d5, aobj);
    }

    public static final int BROWSER_DOUBLE_TAP_DURATION = 0x111d6;
    public static final int BROWSER_SNAP_CENTER = 0x11206;
    public static final int BROWSER_TEXT_SIZE_CHANGE = 0x11207;
    public static final int BROWSER_ZOOM_LEVEL_CHANGE = 0x111d5;
}
