// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.res.AssetFileDescriptor;
import android.os.*;
import android.util.AndroidRuntimeException;
import android.util.Log;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;

// Referenced classes of package android.media:
//            AudioTrack

public class JetPlayer {
    public static interface OnJetEventListener {

        public abstract void onJetEvent(JetPlayer jetplayer, short word0, byte byte0, byte byte1, byte byte2, byte byte3);

        public abstract void onJetNumQueuedSegmentUpdate(JetPlayer jetplayer, int i);

        public abstract void onJetPauseUpdate(JetPlayer jetplayer, int i);

        public abstract void onJetUserIdUpdate(JetPlayer jetplayer, int i, int j);
    }

    private class NativeEventHandler extends Handler {

        public void handleMessage(Message message) {
            OnJetEventListener onjeteventlistener;
            synchronized(mEventListenerLock) {
                onjeteventlistener = mJet.mJetEventListener;
            }
            message.what;
            JVM INSTR tableswitch 1 4: default 56
        //                       1 87
        //                       2 166
        //                       3 193
        //                       4 216;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            JetPlayer.loge((new StringBuilder()).append("Unknown message type ").append(message.what).toString());
_L7:
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
_L2:
            if(onjeteventlistener != null)
                mJetEventListener.onJetEvent(mJet, (short)((0xff000000 & message.arg1) >> 24), (byte)((0xfc0000 & message.arg1) >> 18), (byte)(1 + ((0x3c000 & message.arg1) >> 14)), (byte)((0x3f80 & message.arg1) >> 7), (byte)(0x7f & message.arg1));
            continue; /* Loop/switch isn't completed */
_L3:
            if(onjeteventlistener != null)
                onjeteventlistener.onJetUserIdUpdate(mJet, message.arg1, message.arg2);
            continue; /* Loop/switch isn't completed */
_L4:
            if(onjeteventlistener != null)
                onjeteventlistener.onJetNumQueuedSegmentUpdate(mJet, message.arg1);
            continue; /* Loop/switch isn't completed */
_L5:
            if(onjeteventlistener != null)
                onjeteventlistener.onJetPauseUpdate(mJet, message.arg1);
            if(true) goto _L7; else goto _L6
_L6:
        }

        private JetPlayer mJet;
        final JetPlayer this$0;

        public NativeEventHandler(JetPlayer jetplayer1, Looper looper) {
            this$0 = JetPlayer.this;
            super(looper);
            mJet = jetplayer1;
        }
    }


    private JetPlayer() {
        mEventHandler = null;
        mInitializationLooper = null;
        mJetEventListener = null;
        Looper looper = Looper.myLooper();
        mInitializationLooper = looper;
        if(looper == null)
            mInitializationLooper = Looper.getMainLooper();
        int i = AudioTrack.getMinBufferSize(22050, 12, 2);
        if(i != -1 && i != -2)
            native_setup(new WeakReference(this), getMaxTracks(), Math.max(1200, i / 4));
    }

    public static JetPlayer getJetPlayer() {
        if(singletonRef == null)
            singletonRef = new JetPlayer();
        return singletonRef;
    }

    public static int getMaxTracks() {
        return MAXTRACKS;
    }

    private static void logd(String s) {
        Log.d("JetPlayer-J", (new StringBuilder()).append("[ android.media.JetPlayer ] ").append(s).toString());
    }

    private static void loge(String s) {
        Log.e("JetPlayer-J", (new StringBuilder()).append("[ android.media.JetPlayer ] ").append(s).toString());
    }

    private final native boolean native_clearQueue();

    private final native boolean native_closeJetFile();

    private final native void native_finalize();

    private final native boolean native_loadJetFromFile(String s);

    private final native boolean native_loadJetFromFileD(FileDescriptor filedescriptor, long l, long l1);

    private final native boolean native_pauseJet();

    private final native boolean native_playJet();

    private final native boolean native_queueJetSegment(int i, int j, int k, int l, int i1, byte byte0);

    private final native boolean native_queueJetSegmentMuteArray(int i, int j, int k, int l, boolean aflag[], byte byte0);

    private final native void native_release();

    private final native boolean native_setMuteArray(boolean aflag[], boolean flag);

    private final native boolean native_setMuteFlag(int i, boolean flag, boolean flag1);

    private final native boolean native_setMuteFlags(int i, boolean flag);

    private final native boolean native_setup(Object obj, int i, int j);

    private final native boolean native_triggerClip(int i);

    private static void postEventFromNative(Object obj, int i, int j, int k) {
        JetPlayer jetplayer = (JetPlayer)((WeakReference)obj).get();
        if(jetplayer != null && jetplayer.mEventHandler != null) {
            Message message = jetplayer.mEventHandler.obtainMessage(i, j, k, null);
            jetplayer.mEventHandler.sendMessage(message);
        }
    }

    public boolean clearQueue() {
        return native_clearQueue();
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public boolean closeJetFile() {
        return native_closeJetFile();
    }

    protected void finalize() {
        native_finalize();
    }

    public boolean loadJetFile(AssetFileDescriptor assetfiledescriptor) {
        long l = assetfiledescriptor.getLength();
        if(l < 0L)
            throw new AndroidRuntimeException("no length for fd");
        else
            return native_loadJetFromFileD(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), l);
    }

    public boolean loadJetFile(String s) {
        return native_loadJetFromFile(s);
    }

    public boolean pause() {
        return native_pauseJet();
    }

    public boolean play() {
        return native_playJet();
    }

    public boolean queueJetSegment(int i, int j, int k, int l, int i1, byte byte0) {
        return native_queueJetSegment(i, j, k, l, i1, byte0);
    }

    public boolean queueJetSegmentMuteArray(int i, int j, int k, int l, boolean aflag[], byte byte0) {
        boolean flag;
        if(aflag.length != getMaxTracks())
            flag = false;
        else
            flag = native_queueJetSegmentMuteArray(i, j, k, l, aflag, byte0);
        return flag;
    }

    public void release() {
        native_release();
        singletonRef = null;
    }

    public void setEventListener(OnJetEventListener onjeteventlistener) {
        setEventListener(onjeteventlistener, null);
    }

    public void setEventListener(OnJetEventListener onjeteventlistener, Handler handler) {
        Object obj = mEventListenerLock;
        obj;
        JVM INSTR monitorenter ;
        mJetEventListener = onjeteventlistener;
        if(onjeteventlistener == null)
            break MISSING_BLOCK_LABEL_67;
        if(handler != null)
            mEventHandler = new NativeEventHandler(this, handler.getLooper());
        else
            mEventHandler = new NativeEventHandler(this, mInitializationLooper);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
        mEventHandler = null;
          goto _L1
    }

    public boolean setMuteArray(boolean aflag[], boolean flag) {
        boolean flag1;
        if(aflag.length != getMaxTracks())
            flag1 = false;
        else
            flag1 = native_setMuteArray(aflag, flag);
        return flag1;
    }

    public boolean setMuteFlag(int i, boolean flag, boolean flag1) {
        return native_setMuteFlag(i, flag, flag1);
    }

    public boolean setMuteFlags(int i, boolean flag) {
        return native_setMuteFlags(i, flag);
    }

    public boolean triggerClip(int i) {
        return native_triggerClip(i);
    }

    private static final int JET_EVENT = 1;
    private static final int JET_EVENT_CHAN_MASK = 0x3c000;
    private static final int JET_EVENT_CHAN_SHIFT = 14;
    private static final int JET_EVENT_CTRL_MASK = 16256;
    private static final int JET_EVENT_CTRL_SHIFT = 7;
    private static final int JET_EVENT_SEG_MASK = 0xff000000;
    private static final int JET_EVENT_SEG_SHIFT = 24;
    private static final int JET_EVENT_TRACK_MASK = 0xfc0000;
    private static final int JET_EVENT_TRACK_SHIFT = 18;
    private static final int JET_EVENT_VAL_MASK = 127;
    private static final int JET_NUMQUEUEDSEGMENT_UPDATE = 3;
    private static final int JET_OUTPUT_CHANNEL_CONFIG = 12;
    private static final int JET_OUTPUT_RATE = 22050;
    private static final int JET_PAUSE_UPDATE = 4;
    private static final int JET_USERID_UPDATE = 2;
    private static int MAXTRACKS = 0;
    private static final String TAG = "JetPlayer-J";
    private static JetPlayer singletonRef;
    private NativeEventHandler mEventHandler;
    private final Object mEventListenerLock = new Object();
    private Looper mInitializationLooper;
    private OnJetEventListener mJetEventListener;
    private int mNativePlayerInJavaObj;

    static  {
        MAXTRACKS = 32;
    }



}
