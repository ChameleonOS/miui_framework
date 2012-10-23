// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.os.*;
import android.util.AndroidRuntimeException;
import android.util.Log;
import java.io.*;
import java.lang.ref.WeakReference;

public class SoundPool {
    private class EventHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 1: default 24
        //                       1 53;
               goto _L1 _L2
_L1:
            Log.e("SoundPool", (new StringBuilder()).append("Unknown message type ").append(message.what).toString());
_L4:
            return;
_L2:
            Object obj = mLock;
            obj;
            JVM INSTR monitorenter ;
            if(mOnLoadCompleteListener != null)
                mOnLoadCompleteListener.onLoadComplete(mSoundPool, message.arg1, message.arg2);
            if(true) goto _L4; else goto _L3
_L3:
        }

        private SoundPool mSoundPool;
        final SoundPool this$0;

        public EventHandler(SoundPool soundpool1, Looper looper) {
            this$0 = SoundPool.this;
            super(looper);
            mSoundPool = soundpool1;
        }
    }

    public static interface OnLoadCompleteListener {

        public abstract void onLoadComplete(SoundPool soundpool, int i, int j);
    }


    public SoundPool(int i, int j, int k) {
        if(native_setup(new WeakReference(this), i, j, k) != 0) {
            throw new RuntimeException("Native setup failed");
        } else {
            mLock = new Object();
            return;
        }
    }

    private final native int _load(FileDescriptor filedescriptor, long l, long l1, int i);

    private final native int _load(String s, int i);

    private final native int native_setup(Object obj, int i, int j, int k);

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1) {
        SoundPool soundpool;
        soundpool = (SoundPool)((WeakReference)obj).get();
        break MISSING_BLOCK_LABEL_12;
        if(soundpool != null && soundpool.mEventHandler != null) {
            Message message = soundpool.mEventHandler.obtainMessage(i, j, k, obj1);
            soundpool.mEventHandler.sendMessage(message);
        }
        return;
    }

    public final native void autoPause();

    public final native void autoResume();

    protected void finalize() {
        release();
    }

    public int load(Context context, int i, int j) {
        AssetFileDescriptor assetfiledescriptor = context.getResources().openRawResourceFd(i);
        int k = 0;
        if(assetfiledescriptor != null) {
            k = _load(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), assetfiledescriptor.getLength(), j);
            try {
                assetfiledescriptor.close();
            }
            catch(IOException ioexception) { }
        }
        return k;
    }

    public int load(AssetFileDescriptor assetfiledescriptor, int i) {
        int j;
        if(assetfiledescriptor != null) {
            long l = assetfiledescriptor.getLength();
            if(l < 0L)
                throw new AndroidRuntimeException("no length for fd");
            j = _load(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), l, i);
        } else {
            j = 0;
        }
        return j;
    }

    public int load(FileDescriptor filedescriptor, long l, long l1, int i) {
        return _load(filedescriptor, l, l1, i);
    }

    public int load(String s, int i) {
        if(!s.startsWith("http:")) goto _L2; else goto _L1
_L1:
        int j = _load(s, i);
_L4:
        return j;
_L2:
        j = 0;
        try {
            File file = new File(s);
            ParcelFileDescriptor parcelfiledescriptor = ParcelFileDescriptor.open(file, 0x10000000);
            if(parcelfiledescriptor != null) {
                j = _load(parcelfiledescriptor.getFileDescriptor(), 0L, file.length(), i);
                parcelfiledescriptor.close();
            }
        }
        catch(IOException ioexception) {
            Log.e("SoundPool", (new StringBuilder()).append("error loading ").append(s).toString());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final native void pause(int i);

    public final native int play(int i, float f, float f1, int j, int k, float f2);

    public final native void release();

    public final native void resume(int i);

    public final native void setLoop(int i, int j);

    public void setOnLoadCompleteListener(OnLoadCompleteListener onloadcompletelistener) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(onloadcompletelistener == null)
            break MISSING_BLOCK_LABEL_85;
        Looper looper = Looper.myLooper();
        if(looper != null) {
            mEventHandler = new EventHandler(this, looper);
        } else {
            Looper looper1 = Looper.getMainLooper();
            if(looper1 == null)
                break MISSING_BLOCK_LABEL_77;
            mEventHandler = new EventHandler(this, looper1);
        }
_L1:
        mOnLoadCompleteListener = onloadcompletelistener;
        return;
        Exception exception;
        exception;
        throw exception;
        mEventHandler = null;
          goto _L1
        mEventHandler = null;
          goto _L1
    }

    public final native void setPriority(int i, int j);

    public final native void setRate(int i, float f);

    public final native void setVolume(int i, float f, float f1);

    public final native void stop(int i);

    public final native boolean unload(int i);

    private static final boolean DEBUG = false;
    private static final int SAMPLE_LOADED = 1;
    private static final String TAG = "SoundPool";
    private EventHandler mEventHandler;
    private final Object mLock;
    private int mNativeContext;
    private OnLoadCompleteListener mOnLoadCompleteListener;

    static  {
        System.loadLibrary("soundpool");
    }


}
