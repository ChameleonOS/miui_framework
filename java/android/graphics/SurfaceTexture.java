// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.os.*;
import java.lang.ref.WeakReference;

public class SurfaceTexture {
    private class EventHandler extends Handler {

        public void handleMessage(Message message) {
            if(mOnFrameAvailableListener != null)
                mOnFrameAvailableListener.onFrameAvailable(SurfaceTexture.this);
        }

        final SurfaceTexture this$0;

        public EventHandler(Looper looper) {
            this$0 = SurfaceTexture.this;
            super(looper);
        }
    }

    public static class OutOfResourcesException extends Exception {

        public OutOfResourcesException() {
        }

        public OutOfResourcesException(String s) {
            super(s);
        }
    }

    public static interface OnFrameAvailableListener {

        public abstract void onFrameAvailable(SurfaceTexture surfacetexture);
    }


    public SurfaceTexture(int i) {
        this(i, false);
    }

    public SurfaceTexture(int i, boolean flag) {
        Looper looper = Looper.myLooper();
        if(looper != null) {
            mEventHandler = new EventHandler(looper);
        } else {
            Looper looper1 = Looper.getMainLooper();
            if(looper1 != null)
                mEventHandler = new EventHandler(looper1);
            else
                mEventHandler = null;
        }
        nativeInit(i, new WeakReference(this), flag);
    }

    private native int nativeAttachToGLContext(int i);

    private static native void nativeClassInit();

    private native int nativeDetachFromGLContext();

    private native void nativeFinalize();

    private native int nativeGetQueuedCount();

    private native long nativeGetTimestamp();

    private native void nativeGetTransformMatrix(float af[]);

    private native void nativeInit(int i, Object obj, boolean flag);

    private native void nativeRelease();

    private native void nativeSetDefaultBufferSize(int i, int j);

    private native void nativeUpdateTexImage();

    private static void postEventFromNative(Object obj) {
        SurfaceTexture surfacetexture;
        surfacetexture = (SurfaceTexture)((WeakReference)obj).get();
        break MISSING_BLOCK_LABEL_11;
        if(surfacetexture != null && surfacetexture.mEventHandler != null) {
            Message message = surfacetexture.mEventHandler.obtainMessage();
            surfacetexture.mEventHandler.sendMessage(message);
        }
        return;
    }

    public void attachToGLContext(int i) {
        if(nativeAttachToGLContext(i) != 0)
            throw new RuntimeException("Error during detachFromGLContext (see logcat for details)");
        else
            return;
    }

    public void detachFromGLContext() {
        if(nativeDetachFromGLContext() != 0)
            throw new RuntimeException("Error during detachFromGLContext (see logcat for details)");
        else
            return;
    }

    protected void finalize() throws Throwable {
        nativeFinalize();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public long getTimestamp() {
        return nativeGetTimestamp();
    }

    public void getTransformMatrix(float af[]) {
        if(af.length != 16) {
            throw new IllegalArgumentException();
        } else {
            nativeGetTransformMatrix(af);
            return;
        }
    }

    public void release() {
        nativeRelease();
    }

    public void setDefaultBufferSize(int i, int j) {
        nativeSetDefaultBufferSize(i, j);
    }

    public void setOnFrameAvailableListener(OnFrameAvailableListener onframeavailablelistener) {
        mOnFrameAvailableListener = onframeavailablelistener;
    }

    public void updateTexImage() {
        nativeUpdateTexImage();
    }

    private EventHandler mEventHandler;
    private OnFrameAvailableListener mOnFrameAvailableListener;
    private int mSurfaceTexture;

    static  {
        nativeClassInit();
    }

}
