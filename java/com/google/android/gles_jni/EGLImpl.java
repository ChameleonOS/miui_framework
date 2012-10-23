// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.gles_jni;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import javax.microedition.khronos.egl.*;

// Referenced classes of package com.google.android.gles_jni:
//            EGLContextImpl, EGLDisplayImpl, EGLSurfaceImpl

public class EGLImpl
    implements EGL10 {

    public EGLImpl() {
        mContext = new EGLContextImpl(-1);
        mDisplay = new EGLDisplayImpl(-1);
        mSurface = new EGLSurfaceImpl(-1);
    }

    private native int _eglCreateContext(EGLDisplay egldisplay, EGLConfig eglconfig, EGLContext eglcontext, int ai[]);

    private native int _eglCreatePbufferSurface(EGLDisplay egldisplay, EGLConfig eglconfig, int ai[]);

    private native void _eglCreatePixmapSurface(EGLSurface eglsurface, EGLDisplay egldisplay, EGLConfig eglconfig, Object obj, int ai[]);

    private native int _eglCreateWindowSurface(EGLDisplay egldisplay, EGLConfig eglconfig, Object obj, int ai[]);

    private native int _eglCreateWindowSurfaceTexture(EGLDisplay egldisplay, EGLConfig eglconfig, Object obj, int ai[]);

    private native int _eglGetCurrentContext();

    private native int _eglGetCurrentDisplay();

    private native int _eglGetCurrentSurface(int i);

    private native int _eglGetDisplay(Object obj);

    private static native void _nativeClassInit();

    public static native int getInitCount(EGLDisplay egldisplay);

    public native boolean eglChooseConfig(EGLDisplay egldisplay, int ai[], EGLConfig aeglconfig[], int i, int ai1[]);

    public native boolean eglCopyBuffers(EGLDisplay egldisplay, EGLSurface eglsurface, Object obj);

    public EGLContext eglCreateContext(EGLDisplay egldisplay, EGLConfig eglconfig, EGLContext eglcontext, int ai[]) {
        int i = _eglCreateContext(egldisplay, eglconfig, eglcontext, ai);
        Object obj;
        if(i == 0)
            obj = EGL10.EGL_NO_CONTEXT;
        else
            obj = new EGLContextImpl(i);
        return ((EGLContext) (obj));
    }

    public EGLSurface eglCreatePbufferSurface(EGLDisplay egldisplay, EGLConfig eglconfig, int ai[]) {
        int i = _eglCreatePbufferSurface(egldisplay, eglconfig, ai);
        Object obj;
        if(i == 0)
            obj = EGL10.EGL_NO_SURFACE;
        else
            obj = new EGLSurfaceImpl(i);
        return ((EGLSurface) (obj));
    }

    public EGLSurface eglCreatePixmapSurface(EGLDisplay egldisplay, EGLConfig eglconfig, Object obj, int ai[]) {
        Object obj1 = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(((EGLSurface) (obj1)), egldisplay, eglconfig, obj, ai);
        if(((EGLSurfaceImpl) (obj1)).mEGLSurface == 0)
            obj1 = EGL10.EGL_NO_SURFACE;
        return ((EGLSurface) (obj1));
    }

    public EGLSurface eglCreateWindowSurface(EGLDisplay egldisplay, EGLConfig eglconfig, Object obj, int ai[]) {
        android.view.Surface surface = null;
        if(!(obj instanceof SurfaceView)) goto _L2; else goto _L1
_L1:
        surface = ((SurfaceView)obj).getHolder().getSurface();
_L4:
        int i;
        Object obj1;
        if(surface != null) {
            i = _eglCreateWindowSurface(egldisplay, eglconfig, surface, ai);
        } else {
label0:
            {
                if(!(obj instanceof SurfaceTexture))
                    break label0;
                i = _eglCreateWindowSurfaceTexture(egldisplay, eglconfig, obj, ai);
            }
        }
        if(i == 0)
            obj1 = EGL10.EGL_NO_SURFACE;
        else
            obj1 = new EGLSurfaceImpl(i);
        return ((EGLSurface) (obj1));
_L2:
        if(obj instanceof SurfaceHolder)
            surface = ((SurfaceHolder)obj).getSurface();
        continue; /* Loop/switch isn't completed */
        throw new UnsupportedOperationException("eglCreateWindowSurface() can only be called with an instance of SurfaceView, SurfaceHolder or SurfaceTexture at the moment, this will be fixed later.");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public native boolean eglDestroyContext(EGLDisplay egldisplay, EGLContext eglcontext);

    public native boolean eglDestroySurface(EGLDisplay egldisplay, EGLSurface eglsurface);

    public native boolean eglGetConfigAttrib(EGLDisplay egldisplay, EGLConfig eglconfig, int i, int ai[]);

    public native boolean eglGetConfigs(EGLDisplay egldisplay, EGLConfig aeglconfig[], int i, int ai[]);

    /**
     * @deprecated Method eglGetCurrentContext is deprecated
     */

    public EGLContext eglGetCurrentContext() {
        this;
        JVM INSTR monitorenter ;
        int i = _eglGetCurrentContext();
        if(i != 0) goto _L2; else goto _L1
_L1:
        Object obj = EGL10.EGL_NO_CONTEXT;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((EGLContext) (obj));
_L2:
        if(mContext.mEGLContext != i)
            mContext = new EGLContextImpl(i);
        obj = mContext;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method eglGetCurrentDisplay is deprecated
     */

    public EGLDisplay eglGetCurrentDisplay() {
        this;
        JVM INSTR monitorenter ;
        int i = _eglGetCurrentDisplay();
        if(i != 0) goto _L2; else goto _L1
_L1:
        Object obj = EGL10.EGL_NO_DISPLAY;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((EGLDisplay) (obj));
_L2:
        if(mDisplay.mEGLDisplay != i)
            mDisplay = new EGLDisplayImpl(i);
        obj = mDisplay;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method eglGetCurrentSurface is deprecated
     */

    public EGLSurface eglGetCurrentSurface(int i) {
        this;
        JVM INSTR monitorenter ;
        int j = _eglGetCurrentSurface(i);
        if(j != 0) goto _L2; else goto _L1
_L1:
        Object obj = EGL10.EGL_NO_SURFACE;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((EGLSurface) (obj));
_L2:
        if(mSurface.mEGLSurface != j)
            mSurface = new EGLSurfaceImpl(j);
        obj = mSurface;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method eglGetDisplay is deprecated
     */

    public EGLDisplay eglGetDisplay(Object obj) {
        this;
        JVM INSTR monitorenter ;
        int i = _eglGetDisplay(obj);
        if(i != 0) goto _L2; else goto _L1
_L1:
        Object obj1 = EGL10.EGL_NO_DISPLAY;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((EGLDisplay) (obj1));
_L2:
        if(mDisplay.mEGLDisplay != i)
            mDisplay = new EGLDisplayImpl(i);
        obj1 = mDisplay;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public native int eglGetError();

    public native boolean eglInitialize(EGLDisplay egldisplay, int ai[]);

    public native boolean eglMakeCurrent(EGLDisplay egldisplay, EGLSurface eglsurface, EGLSurface eglsurface1, EGLContext eglcontext);

    public native boolean eglQueryContext(EGLDisplay egldisplay, EGLContext eglcontext, int i, int ai[]);

    public native String eglQueryString(EGLDisplay egldisplay, int i);

    public native boolean eglQuerySurface(EGLDisplay egldisplay, EGLSurface eglsurface, int i, int ai[]);

    public native boolean eglReleaseThread();

    public native boolean eglSwapBuffers(EGLDisplay egldisplay, EGLSurface eglsurface);

    public native boolean eglTerminate(EGLDisplay egldisplay);

    public native boolean eglWaitGL();

    public native boolean eglWaitNative(int i, Object obj);

    private EGLContextImpl mContext;
    private EGLDisplayImpl mDisplay;
    private EGLSurfaceImpl mSurface;

    static  {
        _nativeClassInit();
    }
}
