// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import java.nio.IntBuffer;

public class GLES10Ext {

    public GLES10Ext() {
    }

    private static native void _nativeClassInit();

    public static native int glQueryMatrixxOES(IntBuffer intbuffer, IntBuffer intbuffer1);

    public static native int glQueryMatrixxOES(int ai[], int i, int ai1[], int j);

    static  {
        _nativeClassInit();
    }
}
