// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import java.io.IOException;
import java.io.Writer;
import javax.microedition.khronos.egl.*;

// Referenced classes of package android.opengl:
//            GLException

class EGLLogWrapper
    implements EGL11 {

    public EGLLogWrapper(EGL egl, int i, Writer writer) {
        boolean flag = true;
        super();
        mEgl10 = (EGL10)egl;
        mLog = writer;
        boolean flag1;
        if((i & 4) != 0)
            flag1 = flag;
        else
            flag1 = false;
        mLogArgumentNames = flag1;
        if((i & 1) == 0)
            flag = false;
        mCheckError = flag;
    }

    private void arg(String s, int i) {
        arg(s, Integer.toString(i));
    }

    private void arg(String s, Object obj) {
        arg(s, toString(obj));
    }

    private void arg(String s, String s1) {
        int i = mArgCount;
        mArgCount = i + 1;
        if(i > 0)
            log(", ");
        if(mLogArgumentNames)
            log((new StringBuilder()).append(s).append("=").toString());
        log(s1);
    }

    private void arg(String s, EGLContext eglcontext) {
        if(eglcontext == EGL10.EGL_NO_CONTEXT)
            arg(s, "EGL10.EGL_NO_CONTEXT");
        else
            arg(s, toString(eglcontext));
    }

    private void arg(String s, EGLDisplay egldisplay) {
        if(egldisplay == EGL10.EGL_DEFAULT_DISPLAY)
            arg(s, "EGL10.EGL_DEFAULT_DISPLAY");
        else
        if(egldisplay == EGL_NO_DISPLAY)
            arg(s, "EGL10.EGL_NO_DISPLAY");
        else
            arg(s, toString(egldisplay));
    }

    private void arg(String s, EGLSurface eglsurface) {
        if(eglsurface == EGL10.EGL_NO_SURFACE)
            arg(s, "EGL10.EGL_NO_SURFACE");
        else
            arg(s, toString(eglsurface));
    }

    private void arg(String s, int ai[]) {
        if(ai == null)
            arg(s, "null");
        else
            arg(s, toString(ai.length, ai, 0));
    }

    private void arg(String s, Object aobj[]) {
        if(aobj == null)
            arg(s, "null");
        else
            arg(s, toString(aobj.length, aobj, 0));
    }

    private void begin(String s) {
        log((new StringBuilder()).append(s).append('(').toString());
        mArgCount = 0;
    }

    private void checkError() {
        int i = mEgl10.eglGetError();
        if(i != 12288) {
            String s = (new StringBuilder()).append("eglError: ").append(getErrorString(i)).toString();
            logLine(s);
            if(mCheckError)
                throw new GLException(i, s);
        }
    }

    private void end() {
        log(");\n");
        flush();
    }

    private void flush() {
        mLog.flush();
_L1:
        return;
        IOException ioexception;
        ioexception;
        mLog = null;
          goto _L1
    }

    public static String getErrorString(int i) {
        i;
        JVM INSTR tableswitch 12288 12302: default 76
    //                   12288 83
    //                   12289 89
    //                   12290 95
    //                   12291 101
    //                   12292 107
    //                   12293 113
    //                   12294 119
    //                   12295 125
    //                   12296 131
    //                   12297 137
    //                   12298 143
    //                   12299 149
    //                   12300 155
    //                   12301 161
    //                   12302 167;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L1:
        String s = getHex(i);
_L18:
        return s;
_L2:
        s = "EGL_SUCCESS";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "EGL_NOT_INITIALIZED";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "EGL_BAD_ACCESS";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "EGL_BAD_ALLOC";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "EGL_BAD_ATTRIBUTE";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "EGL_BAD_CONFIG";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "EGL_BAD_CONTEXT";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "EGL_BAD_CURRENT_SURFACE";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "EGL_BAD_DISPLAY";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "EGL_BAD_MATCH";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "EGL_BAD_NATIVE_PIXMAP";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "EGL_BAD_NATIVE_WINDOW";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "EGL_BAD_PARAMETER";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "EGL_BAD_SURFACE";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "EGL_CONTEXT_LOST";
        if(true) goto _L18; else goto _L17
_L17:
    }

    private static String getHex(int i) {
        return (new StringBuilder()).append("0x").append(Integer.toHexString(i)).toString();
    }

    private void log(String s) {
        mLog.write(s);
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void logLine(String s) {
        log((new StringBuilder()).append(s).append('\n').toString());
    }

    private void returns(int i) {
        returns(Integer.toString(i));
    }

    private void returns(Object obj) {
        returns(toString(obj));
    }

    private void returns(String s) {
        log((new StringBuilder()).append(" returns ").append(s).append(";\n").toString());
        flush();
    }

    private void returns(boolean flag) {
        returns(Boolean.toString(flag));
    }

    private String toString(int i, int ai[], int j) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\n");
        int k = ai.length;
        int l = 0;
        while(l < i)  {
            int i1 = j + l;
            stringbuilder.append((new StringBuilder()).append(" [").append(i1).append("] = ").toString());
            if(i1 < 0 || i1 >= k)
                stringbuilder.append("out of bounds");
            else
                stringbuilder.append(ai[i1]);
            stringbuilder.append('\n');
            l++;
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private String toString(int i, Object aobj[], int j) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{\n");
        int k = aobj.length;
        int l = 0;
        while(l < i)  {
            int i1 = j + l;
            stringbuilder.append((new StringBuilder()).append(" [").append(i1).append("] = ").toString());
            if(i1 < 0 || i1 >= k)
                stringbuilder.append("out of bounds");
            else
                stringbuilder.append(aobj[i1]);
            stringbuilder.append('\n');
            l++;
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private String toString(Object obj) {
        String s;
        if(obj == null)
            s = "null";
        else
            s = obj.toString();
        return s;
    }

    public boolean eglChooseConfig(EGLDisplay egldisplay, int ai[], EGLConfig aeglconfig[], int i, int ai1[]) {
        begin("eglChooseConfig");
        arg("display", egldisplay);
        arg("attrib_list", ai);
        arg("config_size", i);
        end();
        boolean flag = mEgl10.eglChooseConfig(egldisplay, ai, aeglconfig, i, ai1);
        arg("configs", aeglconfig);
        arg("num_config", ai1);
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglCopyBuffers(EGLDisplay egldisplay, EGLSurface eglsurface, Object obj) {
        begin("eglCopyBuffers");
        arg("display", egldisplay);
        arg("surface", eglsurface);
        arg("native_pixmap", obj);
        end();
        boolean flag = mEgl10.eglCopyBuffers(egldisplay, eglsurface, obj);
        returns(flag);
        checkError();
        return flag;
    }

    public EGLContext eglCreateContext(EGLDisplay egldisplay, EGLConfig eglconfig, EGLContext eglcontext, int ai[]) {
        begin("eglCreateContext");
        arg("display", egldisplay);
        arg("config", eglconfig);
        arg("share_context", eglcontext);
        arg("attrib_list", ai);
        end();
        EGLContext eglcontext1 = mEgl10.eglCreateContext(egldisplay, eglconfig, eglcontext, ai);
        returns(eglcontext1);
        checkError();
        return eglcontext1;
    }

    public EGLSurface eglCreatePbufferSurface(EGLDisplay egldisplay, EGLConfig eglconfig, int ai[]) {
        begin("eglCreatePbufferSurface");
        arg("display", egldisplay);
        arg("config", eglconfig);
        arg("attrib_list", ai);
        end();
        EGLSurface eglsurface = mEgl10.eglCreatePbufferSurface(egldisplay, eglconfig, ai);
        returns(eglsurface);
        checkError();
        return eglsurface;
    }

    public EGLSurface eglCreatePixmapSurface(EGLDisplay egldisplay, EGLConfig eglconfig, Object obj, int ai[]) {
        begin("eglCreatePixmapSurface");
        arg("display", egldisplay);
        arg("config", eglconfig);
        arg("native_pixmap", obj);
        arg("attrib_list", ai);
        end();
        EGLSurface eglsurface = mEgl10.eglCreatePixmapSurface(egldisplay, eglconfig, obj, ai);
        returns(eglsurface);
        checkError();
        return eglsurface;
    }

    public EGLSurface eglCreateWindowSurface(EGLDisplay egldisplay, EGLConfig eglconfig, Object obj, int ai[]) {
        begin("eglCreateWindowSurface");
        arg("display", egldisplay);
        arg("config", eglconfig);
        arg("native_window", obj);
        arg("attrib_list", ai);
        end();
        EGLSurface eglsurface = mEgl10.eglCreateWindowSurface(egldisplay, eglconfig, obj, ai);
        returns(eglsurface);
        checkError();
        return eglsurface;
    }

    public boolean eglDestroyContext(EGLDisplay egldisplay, EGLContext eglcontext) {
        begin("eglDestroyContext");
        arg("display", egldisplay);
        arg("context", eglcontext);
        end();
        boolean flag = mEgl10.eglDestroyContext(egldisplay, eglcontext);
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglDestroySurface(EGLDisplay egldisplay, EGLSurface eglsurface) {
        begin("eglDestroySurface");
        arg("display", egldisplay);
        arg("surface", eglsurface);
        end();
        boolean flag = mEgl10.eglDestroySurface(egldisplay, eglsurface);
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglGetConfigAttrib(EGLDisplay egldisplay, EGLConfig eglconfig, int i, int ai[]) {
        begin("eglGetConfigAttrib");
        arg("display", egldisplay);
        arg("config", eglconfig);
        arg("attribute", i);
        end();
        boolean flag = mEgl10.eglGetConfigAttrib(egldisplay, eglconfig, i, ai);
        arg("value", ai);
        returns(flag);
        checkError();
        return false;
    }

    public boolean eglGetConfigs(EGLDisplay egldisplay, EGLConfig aeglconfig[], int i, int ai[]) {
        begin("eglGetConfigs");
        arg("display", egldisplay);
        arg("config_size", i);
        end();
        boolean flag = mEgl10.eglGetConfigs(egldisplay, aeglconfig, i, ai);
        arg("configs", aeglconfig);
        arg("num_config", ai);
        returns(flag);
        checkError();
        return flag;
    }

    public EGLContext eglGetCurrentContext() {
        begin("eglGetCurrentContext");
        end();
        EGLContext eglcontext = mEgl10.eglGetCurrentContext();
        returns(eglcontext);
        checkError();
        return eglcontext;
    }

    public EGLDisplay eglGetCurrentDisplay() {
        begin("eglGetCurrentDisplay");
        end();
        EGLDisplay egldisplay = mEgl10.eglGetCurrentDisplay();
        returns(egldisplay);
        checkError();
        return egldisplay;
    }

    public EGLSurface eglGetCurrentSurface(int i) {
        begin("eglGetCurrentSurface");
        arg("readdraw", i);
        end();
        EGLSurface eglsurface = mEgl10.eglGetCurrentSurface(i);
        returns(eglsurface);
        checkError();
        return eglsurface;
    }

    public EGLDisplay eglGetDisplay(Object obj) {
        begin("eglGetDisplay");
        arg("native_display", obj);
        end();
        EGLDisplay egldisplay = mEgl10.eglGetDisplay(obj);
        returns(egldisplay);
        checkError();
        return egldisplay;
    }

    public int eglGetError() {
        begin("eglGetError");
        end();
        int i = mEgl10.eglGetError();
        returns(getErrorString(i));
        return i;
    }

    public boolean eglInitialize(EGLDisplay egldisplay, int ai[]) {
        begin("eglInitialize");
        arg("display", egldisplay);
        end();
        boolean flag = mEgl10.eglInitialize(egldisplay, ai);
        returns(flag);
        arg("major_minor", ai);
        checkError();
        return flag;
    }

    public boolean eglMakeCurrent(EGLDisplay egldisplay, EGLSurface eglsurface, EGLSurface eglsurface1, EGLContext eglcontext) {
        begin("eglMakeCurrent");
        arg("display", egldisplay);
        arg("draw", eglsurface);
        arg("read", eglsurface1);
        arg("context", eglcontext);
        end();
        boolean flag = mEgl10.eglMakeCurrent(egldisplay, eglsurface, eglsurface1, eglcontext);
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglQueryContext(EGLDisplay egldisplay, EGLContext eglcontext, int i, int ai[]) {
        begin("eglQueryContext");
        arg("display", egldisplay);
        arg("context", eglcontext);
        arg("attribute", i);
        end();
        boolean flag = mEgl10.eglQueryContext(egldisplay, eglcontext, i, ai);
        returns(ai[0]);
        returns(flag);
        checkError();
        return flag;
    }

    public String eglQueryString(EGLDisplay egldisplay, int i) {
        begin("eglQueryString");
        arg("display", egldisplay);
        arg("name", i);
        end();
        String s = mEgl10.eglQueryString(egldisplay, i);
        returns(s);
        checkError();
        return s;
    }

    public boolean eglQuerySurface(EGLDisplay egldisplay, EGLSurface eglsurface, int i, int ai[]) {
        begin("eglQuerySurface");
        arg("display", egldisplay);
        arg("surface", eglsurface);
        arg("attribute", i);
        end();
        boolean flag = mEgl10.eglQuerySurface(egldisplay, eglsurface, i, ai);
        returns(ai[0]);
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglReleaseThread() {
        begin("eglReleaseThread");
        end();
        boolean flag = mEgl10.eglReleaseThread();
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglSwapBuffers(EGLDisplay egldisplay, EGLSurface eglsurface) {
        begin("eglInitialize");
        arg("display", egldisplay);
        arg("surface", eglsurface);
        end();
        boolean flag = mEgl10.eglSwapBuffers(egldisplay, eglsurface);
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglTerminate(EGLDisplay egldisplay) {
        begin("eglTerminate");
        arg("display", egldisplay);
        end();
        boolean flag = mEgl10.eglTerminate(egldisplay);
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglWaitGL() {
        begin("eglWaitGL");
        end();
        boolean flag = mEgl10.eglWaitGL();
        returns(flag);
        checkError();
        return flag;
    }

    public boolean eglWaitNative(int i, Object obj) {
        begin("eglWaitNative");
        arg("engine", i);
        arg("bindTarget", obj);
        end();
        boolean flag = mEgl10.eglWaitNative(i, obj);
        returns(flag);
        checkError();
        return flag;
    }

    private int mArgCount;
    boolean mCheckError;
    private EGL10 mEgl10;
    Writer mLog;
    boolean mLogArgumentNames;
}
