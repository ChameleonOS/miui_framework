// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import android.os.Looper;
import android.util.Log;
import com.google.android.gles_jni.EGLImpl;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public abstract class ManagedEGLContext {

    public ManagedEGLContext(EGLContext eglcontext) {
        mContext = eglcontext;
        ArrayList arraylist = sActive;
        arraylist;
        JVM INSTR monitorenter ;
        sActive.add(this);
        return;
    }

    public static boolean doTerminate() {
        boolean flag;
        flag = false;
        if(Looper.getMainLooper() != Looper.myLooper())
            throw new IllegalStateException("Called on wrong thread");
        ArrayList arraylist = sActive;
        arraylist;
        JVM INSTR monitorenter ;
        javax.microedition.khronos.egl.EGLDisplay egldisplay;
        if(sActive.size() <= 0)
            break MISSING_BLOCK_LABEL_195;
        egldisplay = ((EGL10)EGLContext.getEGL()).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if(egldisplay == EGL10.EGL_NO_DISPLAY) {
            Log.w("ManagedEGLContext", "doTerminate failed: no display");
            break MISSING_BLOCK_LABEL_195;
        }
        break MISSING_BLOCK_LABEL_81;
        Exception exception;
        exception;
        throw exception;
        if(EGLImpl.getInitCount(egldisplay) == sActive.size())
            break MISSING_BLOCK_LABEL_141;
        Log.w("ManagedEGLContext", (new StringBuilder()).append("doTerminate failed: EGL count is ").append(EGLImpl.getInitCount(egldisplay)).append(" but managed count is ").append(sActive.size()).toString());
        arraylist;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_195;
        ArrayList arraylist1;
        arraylist1 = new ArrayList(sActive);
        sActive.clear();
        arraylist;
        JVM INSTR monitorexit ;
        for(int i = 0; i < arraylist1.size(); i++)
            ((ManagedEGLContext)arraylist1.get(i)).execTerminate();

        flag = true;
        return flag;
    }

    void execTerminate() {
        onTerminate(mContext);
    }

    public EGLContext getContext() {
        return mContext;
    }

    public abstract void onTerminate(EGLContext eglcontext);

    public void terminate() {
        execTerminate();
    }

    static final String TAG = "ManagedEGLContext";
    static final ArrayList sActive = new ArrayList();
    final EGLContext mContext;

}
