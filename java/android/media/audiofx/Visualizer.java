// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.audiofx;

import android.os.*;
import android.util.Log;
import java.lang.ref.WeakReference;

public class Visualizer {
    private class NativeEventHandler extends Handler {

        private void handleCaptureMessage(Message message) {
            OnDataCaptureListener ondatacapturelistener;
            synchronized(mListenerLock) {
                ondatacapturelistener = mVisualizer.mCaptureListener;
            }
            if(ondatacapturelistener == null) goto _L2; else goto _L1
_L1:
            byte abyte0[];
            int i;
            abyte0 = (byte[])(byte[])message.obj;
            i = message.arg1;
            message.what;
            JVM INSTR tableswitch 0 1: default 72
        //                       0 106
        //                       1 124;
               goto _L3 _L4 _L5
_L3:
            Log.e("Visualizer-JAVA", (new StringBuilder()).append("Unknown native event in handleCaptureMessge: ").append(message.what).toString());
_L2:
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
_L4:
            ondatacapturelistener.onWaveFormDataCapture(mVisualizer, abyte0, i);
            continue; /* Loop/switch isn't completed */
_L5:
            ondatacapturelistener.onFftDataCapture(mVisualizer, abyte0, i);
            if(true) goto _L2; else goto _L6
_L6:
        }

        private void handleServerDiedMessage(Message message) {
            OnServerDiedListener onserverdiedlistener;
            synchronized(mListenerLock) {
                onserverdiedlistener = mVisualizer.mServerDiedListener;
            }
            if(onserverdiedlistener != null)
                onserverdiedlistener.onServerDied();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void handleMessage(Message message) {
            if(mVisualizer != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            switch(message.what) {
            default:
                Log.e("Visualizer-JAVA", (new StringBuilder()).append("Unknown native event: ").append(message.what).toString());
                break;

            case 0: // '\0'
            case 1: // '\001'
                handleCaptureMessage(message);
                break;

            case 2: // '\002'
                handleServerDiedMessage(message);
                break;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private Visualizer mVisualizer;
        final Visualizer this$0;

        public NativeEventHandler(Visualizer visualizer1, Looper looper) {
            this$0 = Visualizer.this;
            super(looper);
            mVisualizer = visualizer1;
        }
    }

    public static interface OnServerDiedListener {

        public abstract void onServerDied();
    }

    public static interface OnDataCaptureListener {

        public abstract void onFftDataCapture(Visualizer visualizer, byte abyte0[], int i);

        public abstract void onWaveFormDataCapture(Visualizer visualizer, byte abyte0[], int i);
    }


    public Visualizer(int i) throws UnsupportedOperationException, RuntimeException {
        int ai[];
        mState = 0;
        mStateLock = new Object();
        mListenerLock = new Object();
        mNativeEventHandler = null;
        mCaptureListener = null;
        mServerDiedListener = null;
        ai = new int[1];
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        mState = 0;
        int j = native_setup(new WeakReference(this), i, ai);
        if(j == 0 || j == -2)
            break MISSING_BLOCK_LABEL_185;
        Log.e("Visualizer-JAVA", (new StringBuilder()).append("Error code ").append(j).append(" when initializing Visualizer.").toString());
        switch(j) {
        default:
            throw new RuntimeException((new StringBuilder()).append("Cannot initialize Visualizer engine, error: ").append(j).toString());

        case -5: 
            break;
        }
        break MISSING_BLOCK_LABEL_175;
        Exception exception;
        exception;
        throw exception;
        throw new UnsupportedOperationException("Effect library not loaded");
        mId = ai[0];
        if(native_getEnabled())
            mState = 2;
        else
            mState = 1;
        obj;
        JVM INSTR monitorexit ;
    }

    public static native int[] getCaptureSizeRange();

    public static native int getMaxCaptureRate();

    private final native void native_finalize();

    private final native int native_getCaptureSize();

    private final native boolean native_getEnabled();

    private final native int native_getFft(byte abyte0[]);

    private final native int native_getSamplingRate();

    private final native int native_getScalingMode();

    private final native int native_getWaveForm(byte abyte0[]);

    private static final native void native_init();

    private final native void native_release();

    private final native int native_setCaptureSize(int i);

    private final native int native_setEnabled(boolean flag);

    private final native int native_setPeriodicCapture(int i, boolean flag, boolean flag1);

    private final native int native_setScalingMode(int i);

    private final native int native_setup(Object obj, int i, int ai[]);

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1) {
        Visualizer visualizer;
        visualizer = (Visualizer)((WeakReference)obj).get();
        break MISSING_BLOCK_LABEL_12;
        if(visualizer != null && visualizer.mNativeEventHandler != null) {
            Message message = visualizer.mNativeEventHandler.obtainMessage(i, j, k, obj1);
            visualizer.mNativeEventHandler.sendMessage(message);
        }
        return;
    }

    protected void finalize() {
        native_finalize();
    }

    public int getCaptureSize() throws IllegalStateException {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState == 0)
            throw new IllegalStateException((new StringBuilder()).append("getCaptureSize() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        throw exception;
        int i = native_getCaptureSize();
        obj;
        JVM INSTR monitorexit ;
        return i;
    }

    public boolean getEnabled() {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState == 0)
            throw new IllegalStateException((new StringBuilder()).append("getEnabled() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        throw exception;
        boolean flag = native_getEnabled();
        obj;
        JVM INSTR monitorexit ;
        return flag;
    }

    public int getFft(byte abyte0[]) throws IllegalStateException {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState != 2)
            throw new IllegalStateException((new StringBuilder()).append("getFft() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        throw exception;
        int i = native_getFft(abyte0);
        obj;
        JVM INSTR monitorexit ;
        return i;
    }

    public int getSamplingRate() throws IllegalStateException {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState == 0)
            throw new IllegalStateException((new StringBuilder()).append("getSamplingRate() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        throw exception;
        int i = native_getSamplingRate();
        obj;
        JVM INSTR monitorexit ;
        return i;
    }

    public int getScalingMode() throws IllegalStateException {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState == 0)
            throw new IllegalStateException((new StringBuilder()).append("getScalingMode() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        throw exception;
        int i = native_getScalingMode();
        obj;
        JVM INSTR monitorexit ;
        return i;
    }

    public int getWaveForm(byte abyte0[]) throws IllegalStateException {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState != 2)
            throw new IllegalStateException((new StringBuilder()).append("getWaveForm() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        throw exception;
        int i = native_getWaveForm(abyte0);
        obj;
        JVM INSTR monitorexit ;
        return i;
    }

    public void release() {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        native_release();
        mState = 0;
        return;
    }

    public int setCaptureSize(int i) throws IllegalStateException {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState != 1)
            throw new IllegalStateException((new StringBuilder()).append("setCaptureSize() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        throw exception;
        int j = native_setCaptureSize(i);
        obj;
        JVM INSTR monitorexit ;
        return j;
    }

    public int setDataCaptureListener(OnDataCaptureListener ondatacapturelistener, int i, boolean flag, boolean flag1) {
        synchronized(mListenerLock) {
            mCaptureListener = ondatacapturelistener;
        }
        if(ondatacapturelistener == null) {
            flag = false;
            flag1 = false;
        }
        int j = native_setPeriodicCapture(i, flag, flag1);
        if(j == 0 && ondatacapturelistener != null && mNativeEventHandler == null) {
            Looper looper = Looper.myLooper();
            if(looper != null) {
                mNativeEventHandler = new NativeEventHandler(this, looper);
            } else {
                Looper looper1 = Looper.getMainLooper();
                if(looper1 != null) {
                    mNativeEventHandler = new NativeEventHandler(this, looper1);
                } else {
                    mNativeEventHandler = null;
                    j = -3;
                }
            }
        }
        return j;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int setEnabled(boolean flag) throws IllegalStateException {
        int i = 2;
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState == 0)
            throw new IllegalStateException((new StringBuilder()).append("setEnabled() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_53;
        Exception exception;
        exception;
        throw exception;
        int j;
        j = 0;
        if(!flag)
            break MISSING_BLOCK_LABEL_68;
        if(mState == 1)
            break MISSING_BLOCK_LABEL_80;
        if(flag || mState != i)
            break MISSING_BLOCK_LABEL_101;
        j = native_setEnabled(flag);
        if(j != 0)
            break MISSING_BLOCK_LABEL_101;
        if(!flag)
            i = 1;
        mState = i;
        obj;
        JVM INSTR monitorexit ;
        return j;
    }

    public int setScalingMode(int i) throws IllegalStateException {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState == 0)
            throw new IllegalStateException((new StringBuilder()).append("setScalingMode() called in wrong state: ").append(mState).toString());
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        throw exception;
        int j = native_setScalingMode(i);
        obj;
        JVM INSTR monitorexit ;
        return j;
    }

    public int setServerDiedListener(OnServerDiedListener onserverdiedlistener) {
        Object obj = mListenerLock;
        obj;
        JVM INSTR monitorenter ;
        mServerDiedListener = onserverdiedlistener;
        return 0;
    }

    public static final int ALREADY_EXISTS = -2;
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -4;
    public static final int ERROR_DEAD_OBJECT = -7;
    public static final int ERROR_INVALID_OPERATION = -5;
    public static final int ERROR_NO_INIT = -3;
    public static final int ERROR_NO_MEMORY = -6;
    private static final int NATIVE_EVENT_FFT_CAPTURE = 1;
    private static final int NATIVE_EVENT_PCM_CAPTURE = 0;
    private static final int NATIVE_EVENT_SERVER_DIED = 2;
    public static final int SCALING_MODE_AS_PLAYED = 1;
    public static final int SCALING_MODE_NORMALIZED = 0;
    public static final int STATE_ENABLED = 2;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_UNINITIALIZED = 0;
    public static final int SUCCESS = 0;
    private static final String TAG = "Visualizer-JAVA";
    private OnDataCaptureListener mCaptureListener;
    private int mId;
    private int mJniData;
    private final Object mListenerLock;
    private NativeEventHandler mNativeEventHandler;
    private int mNativeVisualizer;
    private OnServerDiedListener mServerDiedListener;
    private int mState;
    private final Object mStateLock;

    static  {
        System.loadLibrary("audioeffect_jni");
        native_init();
    }



}
