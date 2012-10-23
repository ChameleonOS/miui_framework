// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BaseSurfaceHolder
    implements SurfaceHolder {

    public BaseSurfaceHolder() {
        mSurface = new Surface();
        mRequestedWidth = -1;
        mRequestedHeight = -1;
        mRequestedFormat = -1;
        mRequestedType = -1;
        mLastLockTime = 0L;
        mType = -1;
    }

    private final Canvas internalLockCanvas(Rect rect) {
        Canvas canvas;
        if(mType == 3)
            throw new android.view.SurfaceHolder.BadSurfaceTypeException("Surface type is SURFACE_TYPE_PUSH_BUFFERS");
        mSurfaceLock.lock();
        canvas = null;
        if(!onAllowLockCanvas())
            break MISSING_BLOCK_LABEL_85;
        if(rect == null) {
            if(mTmpDirty == null)
                mTmpDirty = new Rect();
            mTmpDirty.set(mSurfaceFrame);
            rect = mTmpDirty;
        }
        Canvas canvas1 = mSurface.lockCanvas(rect);
        canvas = canvas1;
_L1:
        Exception exception;
        if(canvas != null) {
            mLastLockTime = SystemClock.uptimeMillis();
        } else {
            long l = SystemClock.uptimeMillis();
            long l1 = 100L + mLastLockTime;
            if(l1 > l) {
                long l2 = l1 - l;
                try {
                    Thread.sleep(l2);
                }
                catch(InterruptedException interruptedexception) { }
                l = SystemClock.uptimeMillis();
            }
            mLastLockTime = l;
            mSurfaceLock.unlock();
            canvas = null;
        }
        return canvas;
        exception;
        Log.e("BaseSurfaceHolder", "Exception locking surface", exception);
          goto _L1
    }

    public void addCallback(android.view.SurfaceHolder.Callback callback) {
        ArrayList arraylist = mCallbacks;
        arraylist;
        JVM INSTR monitorenter ;
        if(!mCallbacks.contains(callback))
            mCallbacks.add(callback);
        return;
    }

    public android.view.SurfaceHolder.Callback[] getCallbacks() {
        if(!mHaveGottenCallbacks) goto _L2; else goto _L1
_L1:
        android.view.SurfaceHolder.Callback acallback[] = mGottenCallbacks;
_L5:
        return acallback;
_L2:
        ArrayList arraylist = mCallbacks;
        arraylist;
        JVM INSTR monitorenter ;
        int i = mCallbacks.size();
        if(i <= 0)
            break MISSING_BLOCK_LABEL_87;
        if(mGottenCallbacks == null || mGottenCallbacks.length != i)
            mGottenCallbacks = new android.view.SurfaceHolder.Callback[i];
        mCallbacks.toArray(mGottenCallbacks);
_L3:
        mHaveGottenCallbacks = true;
        acallback = mGottenCallbacks;
        continue; /* Loop/switch isn't completed */
        mGottenCallbacks = null;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int getRequestedFormat() {
        return mRequestedFormat;
    }

    public int getRequestedHeight() {
        return mRequestedHeight;
    }

    public int getRequestedType() {
        return mRequestedType;
    }

    public int getRequestedWidth() {
        return mRequestedWidth;
    }

    public Surface getSurface() {
        return mSurface;
    }

    public Rect getSurfaceFrame() {
        return mSurfaceFrame;
    }

    public Canvas lockCanvas() {
        return internalLockCanvas(null);
    }

    public Canvas lockCanvas(Rect rect) {
        return internalLockCanvas(rect);
    }

    public abstract boolean onAllowLockCanvas();

    public abstract void onRelayoutContainer();

    public abstract void onUpdateSurface();

    public void removeCallback(android.view.SurfaceHolder.Callback callback) {
        ArrayList arraylist = mCallbacks;
        arraylist;
        JVM INSTR monitorenter ;
        mCallbacks.remove(callback);
        return;
    }

    public void setFixedSize(int i, int j) {
        if(mRequestedWidth != i || mRequestedHeight != j) {
            mRequestedWidth = i;
            mRequestedHeight = j;
            onRelayoutContainer();
        }
    }

    public void setFormat(int i) {
        if(mRequestedFormat != i) {
            mRequestedFormat = i;
            onUpdateSurface();
        }
    }

    public void setSizeFromLayout() {
        if(mRequestedWidth != -1 || mRequestedHeight != -1) {
            mRequestedHeight = -1;
            mRequestedWidth = -1;
            onRelayoutContainer();
        }
    }

    public void setSurfaceFrameSize(int i, int j) {
        mSurfaceFrame.top = 0;
        mSurfaceFrame.left = 0;
        mSurfaceFrame.right = i;
        mSurfaceFrame.bottom = j;
    }

    public void setType(int i) {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 57
    //                   2 57;
           goto _L1 _L2 _L2
_L1:
        i;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 62
    //                   1 56
    //                   2 56
    //                   3 62;
           goto _L3 _L4 _L3 _L3 _L4
_L3:
        return;
_L2:
        i = 0;
          goto _L1
_L4:
        if(mRequestedType != i) {
            mRequestedType = i;
            onUpdateSurface();
        }
          goto _L3
    }

    public void ungetCallbacks() {
        mHaveGottenCallbacks = false;
    }

    public void unlockCanvasAndPost(Canvas canvas) {
        mSurface.unlockCanvasAndPost(canvas);
        mSurfaceLock.unlock();
    }

    static final boolean DEBUG = false;
    private static final String TAG = "BaseSurfaceHolder";
    public final ArrayList mCallbacks = new ArrayList();
    android.view.SurfaceHolder.Callback mGottenCallbacks[];
    boolean mHaveGottenCallbacks;
    long mLastLockTime;
    protected int mRequestedFormat;
    int mRequestedHeight;
    int mRequestedType;
    int mRequestedWidth;
    public Surface mSurface;
    final Rect mSurfaceFrame = new Rect();
    public final ReentrantLock mSurfaceLock = new ReentrantLock();
    Rect mTmpDirty;
    int mType;
}
