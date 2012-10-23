// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.gles_jni;

import javax.microedition.khronos.egl.EGLSurface;

public class EGLSurfaceImpl extends EGLSurface {

    public EGLSurfaceImpl() {
        mEGLSurface = 0;
        mNativePixelRef = 0;
    }

    public EGLSurfaceImpl(int i) {
        mEGLSurface = i;
        mNativePixelRef = 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(obj == null || getClass() != obj.getClass()) {
            flag = false;
        } else {
            EGLSurfaceImpl eglsurfaceimpl = (EGLSurfaceImpl)obj;
            if(mEGLSurface != eglsurfaceimpl.mEGLSurface)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return mEGLSurface;
    }

    int mEGLSurface;
    private int mNativePixelRef;
}
