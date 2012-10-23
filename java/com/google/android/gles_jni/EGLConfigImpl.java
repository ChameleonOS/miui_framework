// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.gles_jni;

import javax.microedition.khronos.egl.EGLConfig;

public class EGLConfigImpl extends EGLConfig {

    EGLConfigImpl(int i) {
        mEGLConfig = i;
    }

    int get() {
        return mEGLConfig;
    }

    private int mEGLConfig;
}
