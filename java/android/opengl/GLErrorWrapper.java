// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import java.nio.*;
import javax.microedition.khronos.opengles.*;

// Referenced classes of package android.opengl:
//            GLWrapperBase, GLException

class GLErrorWrapper extends GLWrapperBase {

    public GLErrorWrapper(GL gl, int i) {
        boolean flag = true;
        super(gl);
        boolean flag1;
        if((i & 1) != 0)
            flag1 = flag;
        else
            flag1 = false;
        mCheckError = flag1;
        if((i & 2) == 0)
            flag = false;
        mCheckThread = flag;
    }

    private void checkError() {
        if(mCheckError) {
            int i = super.mgl.glGetError();
            if(i != 0)
                throw new GLException(i);
        }
    }

    private void checkThread() {
        if(mCheckThread) {
            Thread thread = Thread.currentThread();
            if(mOurThread == null)
                mOurThread = thread;
            else
            if(!mOurThread.equals(thread))
                throw new GLException(28672, "OpenGL method called from wrong thread.");
        }
    }

    public void glActiveTexture(int i) {
        checkThread();
        super.mgl.glActiveTexture(i);
        checkError();
    }

    public void glAlphaFunc(int i, float f) {
        checkThread();
        super.mgl.glAlphaFunc(i, f);
        checkError();
    }

    public void glAlphaFuncx(int i, int j) {
        checkThread();
        super.mgl.glAlphaFuncx(i, j);
        checkError();
    }

    public void glBindBuffer(int i, int j) {
        checkThread();
        super.mgl11.glBindBuffer(i, j);
        checkError();
    }

    public void glBindFramebufferOES(int i, int j) {
        checkThread();
        super.mgl11ExtensionPack.glBindFramebufferOES(i, j);
        checkError();
    }

    public void glBindRenderbufferOES(int i, int j) {
        checkThread();
        super.mgl11ExtensionPack.glBindRenderbufferOES(i, j);
        checkError();
    }

    public void glBindTexture(int i, int j) {
        checkThread();
        super.mgl.glBindTexture(i, j);
        checkError();
    }

    public void glBlendEquation(int i) {
        checkThread();
        super.mgl11ExtensionPack.glBlendEquation(i);
        checkError();
    }

    public void glBlendEquationSeparate(int i, int j) {
        checkThread();
        super.mgl11ExtensionPack.glBlendEquationSeparate(i, j);
        checkError();
    }

    public void glBlendFunc(int i, int j) {
        checkThread();
        super.mgl.glBlendFunc(i, j);
        checkError();
    }

    public void glBlendFuncSeparate(int i, int j, int k, int l) {
        checkThread();
        super.mgl11ExtensionPack.glBlendFuncSeparate(i, j, k, l);
        checkError();
    }

    public void glBufferData(int i, int j, Buffer buffer, int k) {
        checkThread();
        super.mgl11.glBufferData(i, j, buffer, k);
        checkError();
    }

    public void glBufferSubData(int i, int j, int k, Buffer buffer) {
        checkThread();
        super.mgl11.glBufferSubData(i, j, k, buffer);
        checkError();
    }

    public int glCheckFramebufferStatusOES(int i) {
        checkThread();
        int j = super.mgl11ExtensionPack.glCheckFramebufferStatusOES(i);
        checkError();
        return j;
    }

    public void glClear(int i) {
        checkThread();
        super.mgl.glClear(i);
        checkError();
    }

    public void glClearColor(float f, float f1, float f2, float f3) {
        checkThread();
        super.mgl.glClearColor(f, f1, f2, f3);
        checkError();
    }

    public void glClearColorx(int i, int j, int k, int l) {
        checkThread();
        super.mgl.glClearColorx(i, j, k, l);
        checkError();
    }

    public void glClearDepthf(float f) {
        checkThread();
        super.mgl.glClearDepthf(f);
        checkError();
    }

    public void glClearDepthx(int i) {
        checkThread();
        super.mgl.glClearDepthx(i);
        checkError();
    }

    public void glClearStencil(int i) {
        checkThread();
        super.mgl.glClearStencil(i);
        checkError();
    }

    public void glClientActiveTexture(int i) {
        checkThread();
        super.mgl.glClientActiveTexture(i);
        checkError();
    }

    public void glClipPlanef(int i, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11.glClipPlanef(i, floatbuffer);
        checkError();
    }

    public void glClipPlanef(int i, float af[], int j) {
        checkThread();
        super.mgl11.glClipPlanef(i, af, j);
        checkError();
    }

    public void glClipPlanex(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glClipPlanex(i, intbuffer);
        checkError();
    }

    public void glClipPlanex(int i, int ai[], int j) {
        checkThread();
        super.mgl11.glClipPlanex(i, ai, j);
        checkError();
    }

    public void glColor4f(float f, float f1, float f2, float f3) {
        checkThread();
        super.mgl.glColor4f(f, f1, f2, f3);
        checkError();
    }

    public void glColor4ub(byte byte0, byte byte1, byte byte2, byte byte3) {
        checkThread();
        super.mgl11.glColor4ub(byte0, byte1, byte2, byte3);
        checkError();
    }

    public void glColor4x(int i, int j, int k, int l) {
        checkThread();
        super.mgl.glColor4x(i, j, k, l);
        checkError();
    }

    public void glColorMask(boolean flag, boolean flag1, boolean flag2, boolean flag3) {
        checkThread();
        super.mgl.glColorMask(flag, flag1, flag2, flag3);
        checkError();
    }

    public void glColorPointer(int i, int j, int k, int l) {
        checkThread();
        super.mgl11.glColorPointer(i, j, k, l);
        checkError();
    }

    public void glColorPointer(int i, int j, int k, Buffer buffer) {
        checkThread();
        super.mgl.glColorPointer(i, j, k, buffer);
        checkError();
    }

    public void glCompressedTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            Buffer buffer) {
        checkThread();
        super.mgl.glCompressedTexImage2D(i, j, k, l, i1, j1, k1, buffer);
        checkError();
    }

    public void glCompressedTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer) {
        checkThread();
        super.mgl.glCompressedTexSubImage2D(i, j, k, l, i1, j1, k1, l1, buffer);
        checkError();
    }

    public void glCopyTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
        checkThread();
        super.mgl.glCopyTexImage2D(i, j, k, l, i1, j1, k1, l1);
        checkError();
    }

    public void glCopyTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
        checkThread();
        super.mgl.glCopyTexSubImage2D(i, j, k, l, i1, j1, k1, l1);
        checkError();
    }

    public void glCullFace(int i) {
        checkThread();
        super.mgl.glCullFace(i);
        checkError();
    }

    public void glCurrentPaletteMatrixOES(int i) {
        checkThread();
        super.mgl11Ext.glCurrentPaletteMatrixOES(i);
        checkError();
    }

    public void glDeleteBuffers(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glDeleteBuffers(i, intbuffer);
        checkError();
    }

    public void glDeleteBuffers(int i, int ai[], int j) {
        checkThread();
        super.mgl11.glDeleteBuffers(i, ai, j);
        checkError();
    }

    public void glDeleteFramebuffersOES(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glDeleteFramebuffersOES(i, intbuffer);
        checkError();
    }

    public void glDeleteFramebuffersOES(int i, int ai[], int j) {
        checkThread();
        super.mgl11ExtensionPack.glDeleteFramebuffersOES(i, ai, j);
        checkError();
    }

    public void glDeleteRenderbuffersOES(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glDeleteRenderbuffersOES(i, intbuffer);
        checkError();
    }

    public void glDeleteRenderbuffersOES(int i, int ai[], int j) {
        checkThread();
        super.mgl11ExtensionPack.glDeleteRenderbuffersOES(i, ai, j);
        checkError();
    }

    public void glDeleteTextures(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl.glDeleteTextures(i, intbuffer);
        checkError();
    }

    public void glDeleteTextures(int i, int ai[], int j) {
        checkThread();
        super.mgl.glDeleteTextures(i, ai, j);
        checkError();
    }

    public void glDepthFunc(int i) {
        checkThread();
        super.mgl.glDepthFunc(i);
        checkError();
    }

    public void glDepthMask(boolean flag) {
        checkThread();
        super.mgl.glDepthMask(flag);
        checkError();
    }

    public void glDepthRangef(float f, float f1) {
        checkThread();
        super.mgl.glDepthRangef(f, f1);
        checkError();
    }

    public void glDepthRangex(int i, int j) {
        checkThread();
        super.mgl.glDepthRangex(i, j);
        checkError();
    }

    public void glDisable(int i) {
        checkThread();
        super.mgl.glDisable(i);
        checkError();
    }

    public void glDisableClientState(int i) {
        checkThread();
        super.mgl.glDisableClientState(i);
        checkError();
    }

    public void glDrawArrays(int i, int j, int k) {
        checkThread();
        super.mgl.glDrawArrays(i, j, k);
        checkError();
    }

    public void glDrawElements(int i, int j, int k, int l) {
        checkThread();
        super.mgl11.glDrawElements(i, j, k, l);
        checkError();
    }

    public void glDrawElements(int i, int j, int k, Buffer buffer) {
        checkThread();
        super.mgl.glDrawElements(i, j, k, buffer);
        checkError();
    }

    public void glDrawTexfOES(float f, float f1, float f2, float f3, float f4) {
        checkThread();
        super.mgl11Ext.glDrawTexfOES(f, f1, f2, f3, f4);
        checkError();
    }

    public void glDrawTexfvOES(FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11Ext.glDrawTexfvOES(floatbuffer);
        checkError();
    }

    public void glDrawTexfvOES(float af[], int i) {
        checkThread();
        super.mgl11Ext.glDrawTexfvOES(af, i);
        checkError();
    }

    public void glDrawTexiOES(int i, int j, int k, int l, int i1) {
        checkThread();
        super.mgl11Ext.glDrawTexiOES(i, j, k, l, i1);
        checkError();
    }

    public void glDrawTexivOES(IntBuffer intbuffer) {
        checkThread();
        super.mgl11Ext.glDrawTexivOES(intbuffer);
        checkError();
    }

    public void glDrawTexivOES(int ai[], int i) {
        checkThread();
        super.mgl11Ext.glDrawTexivOES(ai, i);
        checkError();
    }

    public void glDrawTexsOES(short word0, short word1, short word2, short word3, short word4) {
        checkThread();
        super.mgl11Ext.glDrawTexsOES(word0, word1, word2, word3, word4);
        checkError();
    }

    public void glDrawTexsvOES(ShortBuffer shortbuffer) {
        checkThread();
        super.mgl11Ext.glDrawTexsvOES(shortbuffer);
        checkError();
    }

    public void glDrawTexsvOES(short aword0[], int i) {
        checkThread();
        super.mgl11Ext.glDrawTexsvOES(aword0, i);
        checkError();
    }

    public void glDrawTexxOES(int i, int j, int k, int l, int i1) {
        checkThread();
        super.mgl11Ext.glDrawTexxOES(i, j, k, l, i1);
        checkError();
    }

    public void glDrawTexxvOES(IntBuffer intbuffer) {
        checkThread();
        super.mgl11Ext.glDrawTexxvOES(intbuffer);
        checkError();
    }

    public void glDrawTexxvOES(int ai[], int i) {
        checkThread();
        super.mgl11Ext.glDrawTexxvOES(ai, i);
        checkError();
    }

    public void glEnable(int i) {
        checkThread();
        super.mgl.glEnable(i);
        checkError();
    }

    public void glEnableClientState(int i) {
        checkThread();
        super.mgl.glEnableClientState(i);
        checkError();
    }

    public void glFinish() {
        checkThread();
        super.mgl.glFinish();
        checkError();
    }

    public void glFlush() {
        checkThread();
        super.mgl.glFlush();
        checkError();
    }

    public void glFogf(int i, float f) {
        checkThread();
        super.mgl.glFogf(i, f);
        checkError();
    }

    public void glFogfv(int i, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl.glFogfv(i, floatbuffer);
        checkError();
    }

    public void glFogfv(int i, float af[], int j) {
        checkThread();
        super.mgl.glFogfv(i, af, j);
        checkError();
    }

    public void glFogx(int i, int j) {
        checkThread();
        super.mgl.glFogx(i, j);
        checkError();
    }

    public void glFogxv(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl.glFogxv(i, intbuffer);
        checkError();
    }

    public void glFogxv(int i, int ai[], int j) {
        checkThread();
        super.mgl.glFogxv(i, ai, j);
        checkError();
    }

    public void glFramebufferRenderbufferOES(int i, int j, int k, int l) {
        checkThread();
        super.mgl11ExtensionPack.glFramebufferRenderbufferOES(i, j, k, l);
        checkError();
    }

    public void glFramebufferTexture2DOES(int i, int j, int k, int l, int i1) {
        checkThread();
        super.mgl11ExtensionPack.glFramebufferTexture2DOES(i, j, k, l, i1);
        checkError();
    }

    public void glFrontFace(int i) {
        checkThread();
        super.mgl.glFrontFace(i);
        checkError();
    }

    public void glFrustumf(float f, float f1, float f2, float f3, float f4, float f5) {
        checkThread();
        super.mgl.glFrustumf(f, f1, f2, f3, f4, f5);
        checkError();
    }

    public void glFrustumx(int i, int j, int k, int l, int i1, int j1) {
        checkThread();
        super.mgl.glFrustumx(i, j, k, l, i1, j1);
        checkError();
    }

    public void glGenBuffers(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGenBuffers(i, intbuffer);
        checkError();
    }

    public void glGenBuffers(int i, int ai[], int j) {
        checkThread();
        super.mgl11.glGenBuffers(i, ai, j);
        checkError();
    }

    public void glGenFramebuffersOES(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glGenFramebuffersOES(i, intbuffer);
        checkError();
    }

    public void glGenFramebuffersOES(int i, int ai[], int j) {
        checkThread();
        super.mgl11ExtensionPack.glGenFramebuffersOES(i, ai, j);
        checkError();
    }

    public void glGenRenderbuffersOES(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glGenRenderbuffersOES(i, intbuffer);
        checkError();
    }

    public void glGenRenderbuffersOES(int i, int ai[], int j) {
        checkThread();
        super.mgl11ExtensionPack.glGenRenderbuffersOES(i, ai, j);
        checkError();
    }

    public void glGenTextures(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl.glGenTextures(i, intbuffer);
        checkError();
    }

    public void glGenTextures(int i, int ai[], int j) {
        checkThread();
        super.mgl.glGenTextures(i, ai, j);
        checkError();
    }

    public void glGenerateMipmapOES(int i) {
        checkThread();
        super.mgl11ExtensionPack.glGenerateMipmapOES(i);
        checkError();
    }

    public void glGetBooleanv(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetBooleanv(i, intbuffer);
        checkError();
    }

    public void glGetBooleanv(int i, boolean aflag[], int j) {
        checkThread();
        super.mgl11.glGetBooleanv(i, aflag, j);
        checkError();
    }

    public void glGetBufferParameteriv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetBufferParameteriv(i, j, intbuffer);
        checkError();
    }

    public void glGetBufferParameteriv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glGetBufferParameteriv(i, j, ai, k);
        checkError();
    }

    public void glGetClipPlanef(int i, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11.glGetClipPlanef(i, floatbuffer);
        checkError();
    }

    public void glGetClipPlanef(int i, float af[], int j) {
        checkThread();
        super.mgl11.glGetClipPlanef(i, af, j);
        checkError();
    }

    public void glGetClipPlanex(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetClipPlanex(i, intbuffer);
        checkError();
    }

    public void glGetClipPlanex(int i, int ai[], int j) {
        checkThread();
        super.mgl11.glGetClipPlanex(i, ai, j);
        checkError();
    }

    public int glGetError() {
        checkThread();
        return super.mgl.glGetError();
    }

    public void glGetFixedv(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetFixedv(i, intbuffer);
        checkError();
    }

    public void glGetFixedv(int i, int ai[], int j) {
        checkThread();
        super.mgl11.glGetFixedv(i, ai, j);
        checkError();
    }

    public void glGetFloatv(int i, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11.glGetFloatv(i, floatbuffer);
        checkError();
    }

    public void glGetFloatv(int i, float af[], int j) {
        checkThread();
        super.mgl11.glGetFloatv(i, af, j);
        checkError();
    }

    public void glGetFramebufferAttachmentParameterivOES(int i, int j, int k, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(i, j, k, intbuffer);
        checkError();
    }

    public void glGetFramebufferAttachmentParameterivOES(int i, int j, int k, int ai[], int l) {
        checkThread();
        super.mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(i, j, k, ai, l);
        checkError();
    }

    public void glGetIntegerv(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl.glGetIntegerv(i, intbuffer);
        checkError();
    }

    public void glGetIntegerv(int i, int ai[], int j) {
        checkThread();
        super.mgl.glGetIntegerv(i, ai, j);
        checkError();
    }

    public void glGetLightfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11.glGetLightfv(i, j, floatbuffer);
        checkError();
    }

    public void glGetLightfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl11.glGetLightfv(i, j, af, k);
        checkError();
    }

    public void glGetLightxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetLightxv(i, j, intbuffer);
        checkError();
    }

    public void glGetLightxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glGetLightxv(i, j, ai, k);
        checkError();
    }

    public void glGetMaterialfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11.glGetMaterialfv(i, j, floatbuffer);
        checkError();
    }

    public void glGetMaterialfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl11.glGetMaterialfv(i, j, af, k);
        checkError();
    }

    public void glGetMaterialxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetMaterialxv(i, j, intbuffer);
        checkError();
    }

    public void glGetMaterialxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glGetMaterialxv(i, j, ai, k);
        checkError();
    }

    public void glGetPointerv(int i, Buffer abuffer[]) {
        checkThread();
        super.mgl11.glGetPointerv(i, abuffer);
        checkError();
    }

    public void glGetRenderbufferParameterivOES(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glGetRenderbufferParameterivOES(i, j, intbuffer);
        checkError();
    }

    public void glGetRenderbufferParameterivOES(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11ExtensionPack.glGetRenderbufferParameterivOES(i, j, ai, k);
        checkError();
    }

    public String glGetString(int i) {
        checkThread();
        String s = super.mgl.glGetString(i);
        checkError();
        return s;
    }

    public void glGetTexEnviv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetTexEnviv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexEnviv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glGetTexEnviv(i, j, ai, k);
        checkError();
    }

    public void glGetTexEnvxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetTexEnvxv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexEnvxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glGetTexEnvxv(i, j, ai, k);
        checkError();
    }

    public void glGetTexGenfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glGetTexGenfv(i, j, floatbuffer);
        checkError();
    }

    public void glGetTexGenfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl11ExtensionPack.glGetTexGenfv(i, j, af, k);
        checkError();
    }

    public void glGetTexGeniv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glGetTexGeniv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexGeniv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11ExtensionPack.glGetTexGeniv(i, j, ai, k);
        checkError();
    }

    public void glGetTexGenxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glGetTexGenxv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexGenxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11ExtensionPack.glGetTexGenxv(i, j, ai, k);
        checkError();
    }

    public void glGetTexParameterfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11.glGetTexParameterfv(i, j, floatbuffer);
        checkError();
    }

    public void glGetTexParameterfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl11.glGetTexParameterfv(i, j, af, k);
        checkError();
    }

    public void glGetTexParameteriv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetTexParameteriv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexParameteriv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glGetTexParameteriv(i, j, ai, k);
        checkError();
    }

    public void glGetTexParameterxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glGetTexParameterxv(i, j, intbuffer);
        checkError();
    }

    public void glGetTexParameterxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glGetTexParameterxv(i, j, ai, k);
        checkError();
    }

    public void glHint(int i, int j) {
        checkThread();
        super.mgl.glHint(i, j);
        checkError();
    }

    public boolean glIsBuffer(int i) {
        checkThread();
        boolean flag = super.mgl11.glIsBuffer(i);
        checkError();
        return flag;
    }

    public boolean glIsEnabled(int i) {
        checkThread();
        boolean flag = super.mgl11.glIsEnabled(i);
        checkError();
        return flag;
    }

    public boolean glIsFramebufferOES(int i) {
        checkThread();
        boolean flag = super.mgl11ExtensionPack.glIsFramebufferOES(i);
        checkError();
        return flag;
    }

    public boolean glIsRenderbufferOES(int i) {
        checkThread();
        super.mgl11ExtensionPack.glIsRenderbufferOES(i);
        checkError();
        return false;
    }

    public boolean glIsTexture(int i) {
        checkThread();
        boolean flag = super.mgl11.glIsTexture(i);
        checkError();
        return flag;
    }

    public void glLightModelf(int i, float f) {
        checkThread();
        super.mgl.glLightModelf(i, f);
        checkError();
    }

    public void glLightModelfv(int i, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl.glLightModelfv(i, floatbuffer);
        checkError();
    }

    public void glLightModelfv(int i, float af[], int j) {
        checkThread();
        super.mgl.glLightModelfv(i, af, j);
        checkError();
    }

    public void glLightModelx(int i, int j) {
        checkThread();
        super.mgl.glLightModelx(i, j);
        checkError();
    }

    public void glLightModelxv(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl.glLightModelxv(i, intbuffer);
        checkError();
    }

    public void glLightModelxv(int i, int ai[], int j) {
        checkThread();
        super.mgl.glLightModelxv(i, ai, j);
        checkError();
    }

    public void glLightf(int i, int j, float f) {
        checkThread();
        super.mgl.glLightf(i, j, f);
        checkError();
    }

    public void glLightfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl.glLightfv(i, j, floatbuffer);
        checkError();
    }

    public void glLightfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl.glLightfv(i, j, af, k);
        checkError();
    }

    public void glLightx(int i, int j, int k) {
        checkThread();
        super.mgl.glLightx(i, j, k);
        checkError();
    }

    public void glLightxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl.glLightxv(i, j, intbuffer);
        checkError();
    }

    public void glLightxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl.glLightxv(i, j, ai, k);
        checkError();
    }

    public void glLineWidth(float f) {
        checkThread();
        super.mgl.glLineWidth(f);
        checkError();
    }

    public void glLineWidthx(int i) {
        checkThread();
        super.mgl.glLineWidthx(i);
        checkError();
    }

    public void glLoadIdentity() {
        checkThread();
        super.mgl.glLoadIdentity();
        checkError();
    }

    public void glLoadMatrixf(FloatBuffer floatbuffer) {
        checkThread();
        super.mgl.glLoadMatrixf(floatbuffer);
        checkError();
    }

    public void glLoadMatrixf(float af[], int i) {
        checkThread();
        super.mgl.glLoadMatrixf(af, i);
        checkError();
    }

    public void glLoadMatrixx(IntBuffer intbuffer) {
        checkThread();
        super.mgl.glLoadMatrixx(intbuffer);
        checkError();
    }

    public void glLoadMatrixx(int ai[], int i) {
        checkThread();
        super.mgl.glLoadMatrixx(ai, i);
        checkError();
    }

    public void glLoadPaletteFromModelViewMatrixOES() {
        checkThread();
        super.mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        checkError();
    }

    public void glLogicOp(int i) {
        checkThread();
        super.mgl.glLogicOp(i);
        checkError();
    }

    public void glMaterialf(int i, int j, float f) {
        checkThread();
        super.mgl.glMaterialf(i, j, f);
        checkError();
    }

    public void glMaterialfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl.glMaterialfv(i, j, floatbuffer);
        checkError();
    }

    public void glMaterialfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl.glMaterialfv(i, j, af, k);
        checkError();
    }

    public void glMaterialx(int i, int j, int k) {
        checkThread();
        super.mgl.glMaterialx(i, j, k);
        checkError();
    }

    public void glMaterialxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl.glMaterialxv(i, j, intbuffer);
        checkError();
    }

    public void glMaterialxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl.glMaterialxv(i, j, ai, k);
        checkError();
    }

    public void glMatrixIndexPointerOES(int i, int j, int k, int l) {
        checkThread();
        super.mgl11Ext.glMatrixIndexPointerOES(i, j, k, l);
        checkError();
    }

    public void glMatrixIndexPointerOES(int i, int j, int k, Buffer buffer) {
        checkThread();
        super.mgl11Ext.glMatrixIndexPointerOES(i, j, k, buffer);
        checkError();
    }

    public void glMatrixMode(int i) {
        checkThread();
        super.mgl.glMatrixMode(i);
        checkError();
    }

    public void glMultMatrixf(FloatBuffer floatbuffer) {
        checkThread();
        super.mgl.glMultMatrixf(floatbuffer);
        checkError();
    }

    public void glMultMatrixf(float af[], int i) {
        checkThread();
        super.mgl.glMultMatrixf(af, i);
        checkError();
    }

    public void glMultMatrixx(IntBuffer intbuffer) {
        checkThread();
        super.mgl.glMultMatrixx(intbuffer);
        checkError();
    }

    public void glMultMatrixx(int ai[], int i) {
        checkThread();
        super.mgl.glMultMatrixx(ai, i);
        checkError();
    }

    public void glMultiTexCoord4f(int i, float f, float f1, float f2, float f3) {
        checkThread();
        super.mgl.glMultiTexCoord4f(i, f, f1, f2, f3);
        checkError();
    }

    public void glMultiTexCoord4x(int i, int j, int k, int l, int i1) {
        checkThread();
        super.mgl.glMultiTexCoord4x(i, j, k, l, i1);
        checkError();
    }

    public void glNormal3f(float f, float f1, float f2) {
        checkThread();
        super.mgl.glNormal3f(f, f1, f2);
        checkError();
    }

    public void glNormal3x(int i, int j, int k) {
        checkThread();
        super.mgl.glNormal3x(i, j, k);
        checkError();
    }

    public void glNormalPointer(int i, int j, int k) {
        checkThread();
        super.mgl11.glNormalPointer(i, j, k);
        checkError();
    }

    public void glNormalPointer(int i, int j, Buffer buffer) {
        checkThread();
        super.mgl.glNormalPointer(i, j, buffer);
        checkError();
    }

    public void glOrthof(float f, float f1, float f2, float f3, float f4, float f5) {
        checkThread();
        super.mgl.glOrthof(f, f1, f2, f3, f4, f5);
        checkError();
    }

    public void glOrthox(int i, int j, int k, int l, int i1, int j1) {
        checkThread();
        super.mgl.glOrthox(i, j, k, l, i1, j1);
        checkError();
    }

    public void glPixelStorei(int i, int j) {
        checkThread();
        super.mgl.glPixelStorei(i, j);
        checkError();
    }

    public void glPointParameterf(int i, float f) {
        checkThread();
        super.mgl11.glPointParameterf(i, f);
        checkError();
    }

    public void glPointParameterfv(int i, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11.glPointParameterfv(i, floatbuffer);
        checkError();
    }

    public void glPointParameterfv(int i, float af[], int j) {
        checkThread();
        super.mgl11.glPointParameterfv(i, af, j);
        checkError();
    }

    public void glPointParameterx(int i, int j) {
        checkThread();
        super.mgl11.glPointParameterx(i, j);
        checkError();
    }

    public void glPointParameterxv(int i, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glPointParameterxv(i, intbuffer);
        checkError();
    }

    public void glPointParameterxv(int i, int ai[], int j) {
        checkThread();
        super.mgl11.glPointParameterxv(i, ai, j);
        checkError();
    }

    public void glPointSize(float f) {
        checkThread();
        super.mgl.glPointSize(f);
        checkError();
    }

    public void glPointSizePointerOES(int i, int j, Buffer buffer) {
        checkThread();
        super.mgl11.glPointSizePointerOES(i, j, buffer);
        checkError();
    }

    public void glPointSizex(int i) {
        checkThread();
        super.mgl.glPointSizex(i);
        checkError();
    }

    public void glPolygonOffset(float f, float f1) {
        checkThread();
        super.mgl.glPolygonOffset(f, f1);
        checkError();
    }

    public void glPolygonOffsetx(int i, int j) {
        checkThread();
        super.mgl.glPolygonOffsetx(i, j);
        checkError();
    }

    public void glPopMatrix() {
        checkThread();
        super.mgl.glPopMatrix();
        checkError();
    }

    public void glPushMatrix() {
        checkThread();
        super.mgl.glPushMatrix();
        checkError();
    }

    public int glQueryMatrixxOES(IntBuffer intbuffer, IntBuffer intbuffer1) {
        checkThread();
        int i = super.mgl10Ext.glQueryMatrixxOES(intbuffer, intbuffer1);
        checkError();
        return i;
    }

    public int glQueryMatrixxOES(int ai[], int i, int ai1[], int j) {
        checkThread();
        int k = super.mgl10Ext.glQueryMatrixxOES(ai, i, ai1, j);
        checkError();
        return k;
    }

    public void glReadPixels(int i, int j, int k, int l, int i1, int j1, Buffer buffer) {
        checkThread();
        super.mgl.glReadPixels(i, j, k, l, i1, j1, buffer);
        checkError();
    }

    public void glRenderbufferStorageOES(int i, int j, int k, int l) {
        checkThread();
        super.mgl11ExtensionPack.glRenderbufferStorageOES(i, j, k, l);
        checkError();
    }

    public void glRotatef(float f, float f1, float f2, float f3) {
        checkThread();
        super.mgl.glRotatef(f, f1, f2, f3);
        checkError();
    }

    public void glRotatex(int i, int j, int k, int l) {
        checkThread();
        super.mgl.glRotatex(i, j, k, l);
        checkError();
    }

    public void glSampleCoverage(float f, boolean flag) {
        checkThread();
        super.mgl.glSampleCoverage(f, flag);
        checkError();
    }

    public void glSampleCoveragex(int i, boolean flag) {
        checkThread();
        super.mgl.glSampleCoveragex(i, flag);
        checkError();
    }

    public void glScalef(float f, float f1, float f2) {
        checkThread();
        super.mgl.glScalef(f, f1, f2);
        checkError();
    }

    public void glScalex(int i, int j, int k) {
        checkThread();
        super.mgl.glScalex(i, j, k);
        checkError();
    }

    public void glScissor(int i, int j, int k, int l) {
        checkThread();
        super.mgl.glScissor(i, j, k, l);
        checkError();
    }

    public void glShadeModel(int i) {
        checkThread();
        super.mgl.glShadeModel(i);
        checkError();
    }

    public void glStencilFunc(int i, int j, int k) {
        checkThread();
        super.mgl.glStencilFunc(i, j, k);
        checkError();
    }

    public void glStencilMask(int i) {
        checkThread();
        super.mgl.glStencilMask(i);
        checkError();
    }

    public void glStencilOp(int i, int j, int k) {
        checkThread();
        super.mgl.glStencilOp(i, j, k);
        checkError();
    }

    public void glTexCoordPointer(int i, int j, int k, int l) {
        checkThread();
        super.mgl11.glTexCoordPointer(i, j, k, l);
        checkError();
    }

    public void glTexCoordPointer(int i, int j, int k, Buffer buffer) {
        checkThread();
        super.mgl.glTexCoordPointer(i, j, k, buffer);
        checkError();
    }

    public void glTexEnvf(int i, int j, float f) {
        checkThread();
        super.mgl.glTexEnvf(i, j, f);
        checkError();
    }

    public void glTexEnvfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl.glTexEnvfv(i, j, floatbuffer);
        checkError();
    }

    public void glTexEnvfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl.glTexEnvfv(i, j, af, k);
        checkError();
    }

    public void glTexEnvi(int i, int j, int k) {
        checkThread();
        super.mgl11.glTexEnvi(i, j, k);
        checkError();
    }

    public void glTexEnviv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glTexEnviv(i, j, intbuffer);
        checkError();
    }

    public void glTexEnviv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glTexEnviv(i, j, ai, k);
        checkError();
    }

    public void glTexEnvx(int i, int j, int k) {
        checkThread();
        super.mgl.glTexEnvx(i, j, k);
        checkError();
    }

    public void glTexEnvxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl.glTexEnvxv(i, j, intbuffer);
        checkError();
    }

    public void glTexEnvxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl.glTexEnvxv(i, j, ai, k);
        checkError();
    }

    public void glTexGenf(int i, int j, float f) {
        checkThread();
        super.mgl11ExtensionPack.glTexGenf(i, j, f);
        checkError();
    }

    public void glTexGenfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glTexGenfv(i, j, floatbuffer);
        checkError();
    }

    public void glTexGenfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl11ExtensionPack.glTexGenfv(i, j, af, k);
        checkError();
    }

    public void glTexGeni(int i, int j, int k) {
        checkThread();
        super.mgl11ExtensionPack.glTexGeni(i, j, k);
        checkError();
    }

    public void glTexGeniv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glTexGeniv(i, j, intbuffer);
        checkError();
    }

    public void glTexGeniv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11ExtensionPack.glTexGeniv(i, j, ai, k);
        checkError();
    }

    public void glTexGenx(int i, int j, int k) {
        checkThread();
        super.mgl11ExtensionPack.glTexGenx(i, j, k);
        checkError();
    }

    public void glTexGenxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11ExtensionPack.glTexGenxv(i, j, intbuffer);
        checkError();
    }

    public void glTexGenxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11ExtensionPack.glTexGenxv(i, j, ai, k);
        checkError();
    }

    public void glTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer) {
        checkThread();
        super.mgl.glTexImage2D(i, j, k, l, i1, j1, k1, l1, buffer);
        checkError();
    }

    public void glTexParameterf(int i, int j, float f) {
        checkThread();
        super.mgl.glTexParameterf(i, j, f);
        checkError();
    }

    public void glTexParameterfv(int i, int j, FloatBuffer floatbuffer) {
        checkThread();
        super.mgl11.glTexParameterfv(i, j, floatbuffer);
        checkError();
    }

    public void glTexParameterfv(int i, int j, float af[], int k) {
        checkThread();
        super.mgl11.glTexParameterfv(i, j, af, k);
        checkError();
    }

    public void glTexParameteri(int i, int j, int k) {
        checkThread();
        super.mgl11.glTexParameteri(i, j, k);
        checkError();
    }

    public void glTexParameteriv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glTexParameteriv(i, j, intbuffer);
        checkError();
    }

    public void glTexParameteriv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glTexParameteriv(i, j, ai, k);
        checkError();
    }

    public void glTexParameterx(int i, int j, int k) {
        checkThread();
        super.mgl.glTexParameterx(i, j, k);
        checkError();
    }

    public void glTexParameterxv(int i, int j, IntBuffer intbuffer) {
        checkThread();
        super.mgl11.glTexParameterxv(i, j, intbuffer);
        checkError();
    }

    public void glTexParameterxv(int i, int j, int ai[], int k) {
        checkThread();
        super.mgl11.glTexParameterxv(i, j, ai, k);
        checkError();
    }

    public void glTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer) {
        checkThread();
        super.mgl.glTexSubImage2D(i, j, k, l, i1, j1, k1, l1, buffer);
        checkError();
    }

    public void glTranslatef(float f, float f1, float f2) {
        checkThread();
        super.mgl.glTranslatef(f, f1, f2);
        checkError();
    }

    public void glTranslatex(int i, int j, int k) {
        checkThread();
        super.mgl.glTranslatex(i, j, k);
        checkError();
    }

    public void glVertexPointer(int i, int j, int k, int l) {
        checkThread();
        super.mgl11.glVertexPointer(i, j, k, l);
        checkError();
    }

    public void glVertexPointer(int i, int j, int k, Buffer buffer) {
        checkThread();
        super.mgl.glVertexPointer(i, j, k, buffer);
        checkError();
    }

    public void glViewport(int i, int j, int k, int l) {
        checkThread();
        super.mgl.glViewport(i, j, k, l);
        checkError();
    }

    public void glWeightPointerOES(int i, int j, int k, int l) {
        checkThread();
        super.mgl11Ext.glWeightPointerOES(i, j, k, l);
        checkError();
    }

    public void glWeightPointerOES(int i, int j, int k, Buffer buffer) {
        checkThread();
        super.mgl11Ext.glWeightPointerOES(i, j, k, buffer);
        checkError();
    }

    boolean mCheckError;
    boolean mCheckThread;
    Thread mOurThread;
}
