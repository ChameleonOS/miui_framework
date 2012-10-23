// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package javax.microedition.khronos.egl;

import com.google.android.gles_jni.EGLImpl;
import javax.microedition.khronos.opengles.GL;

// Referenced classes of package javax.microedition.khronos.egl:
//            EGL

public abstract class EGLContext {

    public EGLContext() {
    }

    public static EGL getEGL() {
        return EGL_INSTANCE;
    }

    public abstract GL getGL();

    private static final EGL EGL_INSTANCE = new EGLImpl();

}
