// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;


public class MediaSyncEvent {

    private MediaSyncEvent(int i) {
        mAudioSession = 0;
        mType = i;
    }

    public static MediaSyncEvent createEvent(int i) throws IllegalArgumentException {
        if(!isValidType(i))
            throw new IllegalArgumentException((new StringBuilder()).append(i).append("is not a valid MediaSyncEvent type.").toString());
        else
            return new MediaSyncEvent(i);
    }

    private static boolean isValidType(int i) {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 28
    //                   1 28;
           goto _L1 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getAudioSessionId() {
        return mAudioSession;
    }

    public int getType() {
        return mType;
    }

    public MediaSyncEvent setAudioSessionId(int i) throws IllegalArgumentException {
        if(i > 0) {
            mAudioSession = i;
            return this;
        } else {
            throw new IllegalArgumentException((new StringBuilder()).append(i).append(" is not a valid session ID.").toString());
        }
    }

    public static final int SYNC_EVENT_NONE = 0;
    public static final int SYNC_EVENT_PRESENTATION_COMPLETE = 1;
    private int mAudioSession;
    private final int mType;
}
