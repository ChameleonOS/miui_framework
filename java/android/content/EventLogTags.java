// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.util.EventLog;

public class EventLogTags {

    private EventLogTags() {
    }

    public static void writeBinderSample(String s, int i, int j, String s1, int k) {
        Object aobj[] = new Object[5];
        aobj[0] = s;
        aobj[1] = Integer.valueOf(i);
        aobj[2] = Integer.valueOf(j);
        aobj[3] = s1;
        aobj[4] = Integer.valueOf(k);
        EventLog.writeEvent(52004, aobj);
    }

    public static void writeContentQuerySample(String s, String s1, String s2, String s3, int i, String s4, int j) {
        Object aobj[] = new Object[7];
        aobj[0] = s;
        aobj[1] = s1;
        aobj[2] = s2;
        aobj[3] = s3;
        aobj[4] = Integer.valueOf(i);
        aobj[5] = s4;
        aobj[6] = Integer.valueOf(j);
        EventLog.writeEvent(52002, aobj);
    }

    public static void writeContentUpdateSample(String s, String s1, String s2, int i, String s3, int j) {
        Object aobj[] = new Object[6];
        aobj[0] = s;
        aobj[1] = s1;
        aobj[2] = s2;
        aobj[3] = Integer.valueOf(i);
        aobj[4] = s3;
        aobj[5] = Integer.valueOf(j);
        EventLog.writeEvent(52003, aobj);
    }

    public static final int BINDER_SAMPLE = 52004;
    public static final int CONTENT_QUERY_SAMPLE = 52002;
    public static final int CONTENT_UPDATE_SAMPLE = 52003;
}
