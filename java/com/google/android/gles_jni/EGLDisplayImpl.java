// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.gles_jni;

import javax.microedition.khronos.egl.EGLDisplay;

public class EGLDisplayImpl extends EGLDisplay {

    public EGLDisplayImpl(int i) {
        mEGLDisplay = i;
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
            EGLDisplayImpl egldisplayimpl = (EGLDisplayImpl)obj;
            if(mEGLDisplay != egldisplayimpl.mEGLDisplay)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return mEGLDisplay;
    }

    int mEGLDisplay;
}
