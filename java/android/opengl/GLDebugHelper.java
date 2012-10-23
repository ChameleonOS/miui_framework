// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import java.io.Writer;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.opengles.GL;

// Referenced classes of package android.opengl:
//            EGLLogWrapper, GLErrorWrapper, GLLogWrapper

public class GLDebugHelper {

    public GLDebugHelper() {
    }

    public static EGL wrap(EGL egl, int i, Writer writer) {
        if(writer != null)
            egl = new EGLLogWrapper(egl, i, writer);
        return egl;
    }

    public static GL wrap(GL gl, int i, Writer writer) {
        Object obj;
        Object obj1;
        if(i != 0)
            obj = new GLErrorWrapper(gl, i);
        else
            obj = gl;
        if(writer != null) {
            boolean flag;
            if((i & 4) != 0)
                flag = true;
            else
                flag = false;
            obj1 = new GLLogWrapper(((GL) (obj)), writer, flag);
        } else {
            obj1 = obj;
        }
        return ((GL) (obj1));
    }

    public static final int CONFIG_CHECK_GL_ERROR = 1;
    public static final int CONFIG_CHECK_THREAD = 2;
    public static final int CONFIG_LOG_ARGUMENT_NAMES = 4;
    public static final int ERROR_WRONG_THREAD = 28672;
}
