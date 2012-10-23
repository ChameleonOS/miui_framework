// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.rtp;

import java.net.InetAddress;
import java.util.*;

// Referenced classes of package android.net.rtp:
//            AudioStream, AudioCodec

public class AudioGroup {

    public AudioGroup() {
        mMode = 0;
    }

    private native int nativeAdd(int i, int j, String s, int k, String s1, int l);

    private native void nativeRemove(int i);

    private native void nativeSendDtmf(int i);

    private native void nativeSetMode(int i);

    /**
     * @deprecated Method add is deprecated
     */

    void add(AudioStream audiostream) {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mStreams.containsKey(audiostream);
        if(flag)
            break MISSING_BLOCK_LABEL_115;
        AudioCodec audiocodec = audiostream.getCodec();
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(audiocodec.type);
        aobj[1] = audiocodec.rtpmap;
        aobj[2] = audiocodec.fmtp;
        String s = String.format("%d %s %s", aobj);
        int i = nativeAdd(audiostream.getMode(), audiostream.getSocket(), audiostream.getRemoteAddress().getHostAddress(), audiostream.getRemotePort(), s, audiostream.getDtmfType());
        mStreams.put(audiostream, Integer.valueOf(i));
        this;
        JVM INSTR monitorexit ;
        return;
        NullPointerException nullpointerexception;
        nullpointerexception;
        throw new IllegalStateException(nullpointerexception);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clear() {
        AudioStream aaudiostream[] = getStreams();
        int i = aaudiostream.length;
        for(int j = 0; j < i; j++)
            aaudiostream[j].join(null);

    }

    protected void finalize() throws Throwable {
        nativeRemove(0);
        super.finalize();
    }

    public int getMode() {
        return mMode;
    }

    public AudioStream[] getStreams() {
        this;
        JVM INSTR monitorenter ;
        AudioStream aaudiostream[] = (AudioStream[])mStreams.keySet().toArray(new AudioStream[mStreams.size()]);
        return aaudiostream;
    }

    /**
     * @deprecated Method remove is deprecated
     */

    void remove(AudioStream audiostream) {
        this;
        JVM INSTR monitorenter ;
        Integer integer = (Integer)mStreams.remove(audiostream);
        if(integer != null)
            nativeRemove(integer.intValue());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void sendDtmf(int i) {
        if(i < 0 || i > 15)
            throw new IllegalArgumentException("Invalid event");
        this;
        JVM INSTR monitorenter ;
        nativeSendDtmf(i);
        return;
    }

    public void setMode(int i) {
        if(i < 0 || i > 3)
            throw new IllegalArgumentException("Invalid mode");
        this;
        JVM INSTR monitorenter ;
        nativeSetMode(i);
        mMode = i;
        return;
    }

    public static final int MODE_ECHO_SUPPRESSION = 3;
    private static final int MODE_LAST = 3;
    public static final int MODE_MUTED = 1;
    public static final int MODE_NORMAL = 2;
    public static final int MODE_ON_HOLD;
    private int mMode;
    private int mNative;
    private final Map mStreams = new HashMap();

    static  {
        System.loadLibrary("rtp_jni");
    }
}
