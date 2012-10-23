// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.util.EventLog;

public class EventLogTags {

    private EventLogTags() {
    }

    public static void writeTtsSpeakFailure(String s, int i, int j, int k, String s1, int l, int i1) {
        Object aobj[] = new Object[7];
        aobj[0] = s;
        aobj[1] = Integer.valueOf(i);
        aobj[2] = Integer.valueOf(j);
        aobj[3] = Integer.valueOf(k);
        aobj[4] = s1;
        aobj[5] = Integer.valueOf(l);
        aobj[6] = Integer.valueOf(i1);
        EventLog.writeEvent(0x128e2, aobj);
    }

    public static void writeTtsSpeakSuccess(String s, int i, int j, int k, String s1, int l, int i1, long l1, long l2, long l3) {
        Object aobj[] = new Object[10];
        aobj[0] = s;
        aobj[1] = Integer.valueOf(i);
        aobj[2] = Integer.valueOf(j);
        aobj[3] = Integer.valueOf(k);
        aobj[4] = s1;
        aobj[5] = Integer.valueOf(l);
        aobj[6] = Integer.valueOf(i1);
        aobj[7] = Long.valueOf(l1);
        aobj[8] = Long.valueOf(l2);
        aobj[9] = Long.valueOf(l3);
        EventLog.writeEvent(0x128e1, aobj);
    }

    public static final int TTS_SPEAK_FAILURE = 0x128e2;
    public static final int TTS_SPEAK_SUCCESS = 0x128e1;
}
