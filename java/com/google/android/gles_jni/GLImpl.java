// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.gles_jni;

import android.app.AppGlobals;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.os.RemoteException;
import android.os.UserId;
import android.util.Log;
import java.nio.*;
import javax.microedition.khronos.opengles.*;

public class GLImpl
    implements GL10, GL10Ext, GL11, GL11Ext, GL11ExtensionPack {

    public GLImpl() {
        _colorPointer = null;
        _normalPointer = null;
        _texCoordPointer = null;
        _vertexPointer = null;
        _pointSizePointerOES = null;
        _matrixIndexPointerOES = null;
        _weightPointerOES = null;
    }

    private static native void _nativeClassInit();

    private static boolean allowIndirectBuffers(String s) {
        boolean flag = false;
        int i = 0;
        IPackageManager ipackagemanager = AppGlobals.getPackageManager();
        Object aobj[];
        try {
            ApplicationInfo applicationinfo = ipackagemanager.getApplicationInfo(s, 0, UserId.myUserId());
            if(applicationinfo != null)
                i = applicationinfo.targetSdkVersion;
        }
        catch(RemoteException remoteexception) { }
        aobj = new Object[2];
        aobj[0] = s;
        aobj[1] = Integer.valueOf(i);
        Log.e("OpenGLES", String.format("Application %s (SDK target %d) called a GL11 Pointer method with an indirect Buffer.", aobj));
        if(i <= 3)
            flag = true;
        return flag;
    }

    private native void glColorPointerBounds(int i, int j, int k, Buffer buffer, int l);

    private native void glMatrixIndexPointerOESBounds(int i, int j, int k, Buffer buffer, int l);

    private native void glNormalPointerBounds(int i, int j, Buffer buffer, int k);

    private native void glPointSizePointerOESBounds(int i, int j, Buffer buffer, int k);

    private native void glTexCoordPointerBounds(int i, int j, int k, Buffer buffer, int l);

    private native void glVertexPointerBounds(int i, int j, int k, Buffer buffer, int l);

    private native void glWeightPointerOESBounds(int i, int j, int k, Buffer buffer, int l);

    public native String _glGetString(int i);

    public native void glActiveTexture(int i);

    public native void glAlphaFunc(int i, float f);

    public native void glAlphaFuncx(int i, int j);

    public native void glBindBuffer(int i, int j);

    public native void glBindFramebufferOES(int i, int j);

    public native void glBindRenderbufferOES(int i, int j);

    public native void glBindTexture(int i, int j);

    public native void glBlendEquation(int i);

    public native void glBlendEquationSeparate(int i, int j);

    public native void glBlendFunc(int i, int j);

    public native void glBlendFuncSeparate(int i, int j, int k, int l);

    public native void glBufferData(int i, int j, Buffer buffer, int k);

    public native void glBufferSubData(int i, int j, int k, Buffer buffer);

    public native int glCheckFramebufferStatusOES(int i);

    public native void glClear(int i);

    public native void glClearColor(float f, float f1, float f2, float f3);

    public native void glClearColorx(int i, int j, int k, int l);

    public native void glClearDepthf(float f);

    public native void glClearDepthx(int i);

    public native void glClearStencil(int i);

    public native void glClientActiveTexture(int i);

    public native void glClipPlanef(int i, FloatBuffer floatbuffer);

    public native void glClipPlanef(int i, float af[], int j);

    public native void glClipPlanex(int i, IntBuffer intbuffer);

    public native void glClipPlanex(int i, int ai[], int j);

    public native void glColor4f(float f, float f1, float f2, float f3);

    public native void glColor4ub(byte byte0, byte byte1, byte byte2, byte byte3);

    public native void glColor4x(int i, int j, int k, int l);

    public native void glColorMask(boolean flag, boolean flag1, boolean flag2, boolean flag3);

    public native void glColorPointer(int i, int j, int k, int l);

    public void glColorPointer(int i, int j, int k, Buffer buffer) {
        glColorPointerBounds(i, j, k, buffer, buffer.remaining());
        if(i == 4 && (j == 5126 || j == 5121 || j == 5132) && k >= 0)
            _colorPointer = buffer;
    }

    public native void glCompressedTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            Buffer buffer);

    public native void glCompressedTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer);

    public native void glCopyTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1);

    public native void glCopyTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1);

    public native void glCullFace(int i);

    public native void glCurrentPaletteMatrixOES(int i);

    public native void glDeleteBuffers(int i, IntBuffer intbuffer);

    public native void glDeleteBuffers(int i, int ai[], int j);

    public native void glDeleteFramebuffersOES(int i, IntBuffer intbuffer);

    public native void glDeleteFramebuffersOES(int i, int ai[], int j);

    public native void glDeleteRenderbuffersOES(int i, IntBuffer intbuffer);

    public native void glDeleteRenderbuffersOES(int i, int ai[], int j);

    public native void glDeleteTextures(int i, IntBuffer intbuffer);

    public native void glDeleteTextures(int i, int ai[], int j);

    public native void glDepthFunc(int i);

    public native void glDepthMask(boolean flag);

    public native void glDepthRangef(float f, float f1);

    public native void glDepthRangex(int i, int j);

    public native void glDisable(int i);

    public native void glDisableClientState(int i);

    public native void glDrawArrays(int i, int j, int k);

    public native void glDrawElements(int i, int j, int k, int l);

    public native void glDrawElements(int i, int j, int k, Buffer buffer);

    public native void glDrawTexfOES(float f, float f1, float f2, float f3, float f4);

    public native void glDrawTexfvOES(FloatBuffer floatbuffer);

    public native void glDrawTexfvOES(float af[], int i);

    public native void glDrawTexiOES(int i, int j, int k, int l, int i1);

    public native void glDrawTexivOES(IntBuffer intbuffer);

    public native void glDrawTexivOES(int ai[], int i);

    public native void glDrawTexsOES(short word0, short word1, short word2, short word3, short word4);

    public native void glDrawTexsvOES(ShortBuffer shortbuffer);

    public native void glDrawTexsvOES(short aword0[], int i);

    public native void glDrawTexxOES(int i, int j, int k, int l, int i1);

    public native void glDrawTexxvOES(IntBuffer intbuffer);

    public native void glDrawTexxvOES(int ai[], int i);

    public native void glEnable(int i);

    public native void glEnableClientState(int i);

    public native void glFinish();

    public native void glFlush();

    public native void glFogf(int i, float f);

    public native void glFogfv(int i, FloatBuffer floatbuffer);

    public native void glFogfv(int i, float af[], int j);

    public native void glFogx(int i, int j);

    public native void glFogxv(int i, IntBuffer intbuffer);

    public native void glFogxv(int i, int ai[], int j);

    public native void glFramebufferRenderbufferOES(int i, int j, int k, int l);

    public native void glFramebufferTexture2DOES(int i, int j, int k, int l, int i1);

    public native void glFrontFace(int i);

    public native void glFrustumf(float f, float f1, float f2, float f3, float f4, float f5);

    public native void glFrustumx(int i, int j, int k, int l, int i1, int j1);

    public native void glGenBuffers(int i, IntBuffer intbuffer);

    public native void glGenBuffers(int i, int ai[], int j);

    public native void glGenFramebuffersOES(int i, IntBuffer intbuffer);

    public native void glGenFramebuffersOES(int i, int ai[], int j);

    public native void glGenRenderbuffersOES(int i, IntBuffer intbuffer);

    public native void glGenRenderbuffersOES(int i, int ai[], int j);

    public native void glGenTextures(int i, IntBuffer intbuffer);

    public native void glGenTextures(int i, int ai[], int j);

    public native void glGenerateMipmapOES(int i);

    public native void glGetBooleanv(int i, IntBuffer intbuffer);

    public native void glGetBooleanv(int i, boolean aflag[], int j);

    public native void glGetBufferParameteriv(int i, int j, IntBuffer intbuffer);

    public native void glGetBufferParameteriv(int i, int j, int ai[], int k);

    public native void glGetClipPlanef(int i, FloatBuffer floatbuffer);

    public native void glGetClipPlanef(int i, float af[], int j);

    public native void glGetClipPlanex(int i, IntBuffer intbuffer);

    public native void glGetClipPlanex(int i, int ai[], int j);

    public native int glGetError();

    public native void glGetFixedv(int i, IntBuffer intbuffer);

    public native void glGetFixedv(int i, int ai[], int j);

    public native void glGetFloatv(int i, FloatBuffer floatbuffer);

    public native void glGetFloatv(int i, float af[], int j);

    public native void glGetFramebufferAttachmentParameterivOES(int i, int j, int k, IntBuffer intbuffer);

    public native void glGetFramebufferAttachmentParameterivOES(int i, int j, int k, int ai[], int l);

    public native void glGetIntegerv(int i, IntBuffer intbuffer);

    public native void glGetIntegerv(int i, int ai[], int j);

    public native void glGetLightfv(int i, int j, FloatBuffer floatbuffer);

    public native void glGetLightfv(int i, int j, float af[], int k);

    public native void glGetLightxv(int i, int j, IntBuffer intbuffer);

    public native void glGetLightxv(int i, int j, int ai[], int k);

    public native void glGetMaterialfv(int i, int j, FloatBuffer floatbuffer);

    public native void glGetMaterialfv(int i, int j, float af[], int k);

    public native void glGetMaterialxv(int i, int j, IntBuffer intbuffer);

    public native void glGetMaterialxv(int i, int j, int ai[], int k);

    public void glGetPointerv(int i, Buffer abuffer[]) {
        throw new UnsupportedOperationException("glGetPointerv");
    }

    public native void glGetRenderbufferParameterivOES(int i, int j, IntBuffer intbuffer);

    public native void glGetRenderbufferParameterivOES(int i, int j, int ai[], int k);

    public String glGetString(int i) {
        return _glGetString(i);
    }

    public native void glGetTexEnviv(int i, int j, IntBuffer intbuffer);

    public native void glGetTexEnviv(int i, int j, int ai[], int k);

    public native void glGetTexEnvxv(int i, int j, IntBuffer intbuffer);

    public native void glGetTexEnvxv(int i, int j, int ai[], int k);

    public native void glGetTexGenfv(int i, int j, FloatBuffer floatbuffer);

    public native void glGetTexGenfv(int i, int j, float af[], int k);

    public native void glGetTexGeniv(int i, int j, IntBuffer intbuffer);

    public native void glGetTexGeniv(int i, int j, int ai[], int k);

    public native void glGetTexGenxv(int i, int j, IntBuffer intbuffer);

    public native void glGetTexGenxv(int i, int j, int ai[], int k);

    public native void glGetTexParameterfv(int i, int j, FloatBuffer floatbuffer);

    public native void glGetTexParameterfv(int i, int j, float af[], int k);

    public native void glGetTexParameteriv(int i, int j, IntBuffer intbuffer);

    public native void glGetTexParameteriv(int i, int j, int ai[], int k);

    public native void glGetTexParameterxv(int i, int j, IntBuffer intbuffer);

    public native void glGetTexParameterxv(int i, int j, int ai[], int k);

    public native void glHint(int i, int j);

    public native boolean glIsBuffer(int i);

    public native boolean glIsEnabled(int i);

    public native boolean glIsFramebufferOES(int i);

    public native boolean glIsRenderbufferOES(int i);

    public native boolean glIsTexture(int i);

    public native void glLightModelf(int i, float f);

    public native void glLightModelfv(int i, FloatBuffer floatbuffer);

    public native void glLightModelfv(int i, float af[], int j);

    public native void glLightModelx(int i, int j);

    public native void glLightModelxv(int i, IntBuffer intbuffer);

    public native void glLightModelxv(int i, int ai[], int j);

    public native void glLightf(int i, int j, float f);

    public native void glLightfv(int i, int j, FloatBuffer floatbuffer);

    public native void glLightfv(int i, int j, float af[], int k);

    public native void glLightx(int i, int j, int k);

    public native void glLightxv(int i, int j, IntBuffer intbuffer);

    public native void glLightxv(int i, int j, int ai[], int k);

    public native void glLineWidth(float f);

    public native void glLineWidthx(int i);

    public native void glLoadIdentity();

    public native void glLoadMatrixf(FloatBuffer floatbuffer);

    public native void glLoadMatrixf(float af[], int i);

    public native void glLoadMatrixx(IntBuffer intbuffer);

    public native void glLoadMatrixx(int ai[], int i);

    public native void glLoadPaletteFromModelViewMatrixOES();

    public native void glLogicOp(int i);

    public native void glMaterialf(int i, int j, float f);

    public native void glMaterialfv(int i, int j, FloatBuffer floatbuffer);

    public native void glMaterialfv(int i, int j, float af[], int k);

    public native void glMaterialx(int i, int j, int k);

    public native void glMaterialxv(int i, int j, IntBuffer intbuffer);

    public native void glMaterialxv(int i, int j, int ai[], int k);

    public native void glMatrixIndexPointerOES(int i, int j, int k, int l);

    public void glMatrixIndexPointerOES(int i, int j, int k, Buffer buffer) {
        glMatrixIndexPointerOESBounds(i, j, k, buffer, buffer.remaining());
        if((i == 2 || i == 3 || i == 4) && (j == 5126 || j == 5120 || j == 5122 || j == 5132) && k >= 0)
            _matrixIndexPointerOES = buffer;
    }

    public native void glMatrixMode(int i);

    public native void glMultMatrixf(FloatBuffer floatbuffer);

    public native void glMultMatrixf(float af[], int i);

    public native void glMultMatrixx(IntBuffer intbuffer);

    public native void glMultMatrixx(int ai[], int i);

    public native void glMultiTexCoord4f(int i, float f, float f1, float f2, float f3);

    public native void glMultiTexCoord4x(int i, int j, int k, int l, int i1);

    public native void glNormal3f(float f, float f1, float f2);

    public native void glNormal3x(int i, int j, int k);

    public native void glNormalPointer(int i, int j, int k);

    public void glNormalPointer(int i, int j, Buffer buffer) {
        glNormalPointerBounds(i, j, buffer, buffer.remaining());
        if((i == 5126 || i == 5120 || i == 5122 || i == 5132) && j >= 0)
            _normalPointer = buffer;
    }

    public native void glOrthof(float f, float f1, float f2, float f3, float f4, float f5);

    public native void glOrthox(int i, int j, int k, int l, int i1, int j1);

    public native void glPixelStorei(int i, int j);

    public native void glPointParameterf(int i, float f);

    public native void glPointParameterfv(int i, FloatBuffer floatbuffer);

    public native void glPointParameterfv(int i, float af[], int j);

    public native void glPointParameterx(int i, int j);

    public native void glPointParameterxv(int i, IntBuffer intbuffer);

    public native void glPointParameterxv(int i, int ai[], int j);

    public native void glPointSize(float f);

    public void glPointSizePointerOES(int i, int j, Buffer buffer) {
        glPointSizePointerOESBounds(i, j, buffer, buffer.remaining());
        if((i == 5126 || i == 5132) && j >= 0)
            _pointSizePointerOES = buffer;
    }

    public native void glPointSizex(int i);

    public native void glPolygonOffset(float f, float f1);

    public native void glPolygonOffsetx(int i, int j);

    public native void glPopMatrix();

    public native void glPushMatrix();

    public native int glQueryMatrixxOES(IntBuffer intbuffer, IntBuffer intbuffer1);

    public native int glQueryMatrixxOES(int ai[], int i, int ai1[], int j);

    public native void glReadPixels(int i, int j, int k, int l, int i1, int j1, Buffer buffer);

    public native void glRenderbufferStorageOES(int i, int j, int k, int l);

    public native void glRotatef(float f, float f1, float f2, float f3);

    public native void glRotatex(int i, int j, int k, int l);

    public native void glSampleCoverage(float f, boolean flag);

    public native void glSampleCoveragex(int i, boolean flag);

    public native void glScalef(float f, float f1, float f2);

    public native void glScalex(int i, int j, int k);

    public native void glScissor(int i, int j, int k, int l);

    public native void glShadeModel(int i);

    public native void glStencilFunc(int i, int j, int k);

    public native void glStencilMask(int i);

    public native void glStencilOp(int i, int j, int k);

    public native void glTexCoordPointer(int i, int j, int k, int l);

    public void glTexCoordPointer(int i, int j, int k, Buffer buffer) {
        glTexCoordPointerBounds(i, j, k, buffer, buffer.remaining());
        if((i == 2 || i == 3 || i == 4) && (j == 5126 || j == 5120 || j == 5122 || j == 5132) && k >= 0)
            _texCoordPointer = buffer;
    }

    public native void glTexEnvf(int i, int j, float f);

    public native void glTexEnvfv(int i, int j, FloatBuffer floatbuffer);

    public native void glTexEnvfv(int i, int j, float af[], int k);

    public native void glTexEnvi(int i, int j, int k);

    public native void glTexEnviv(int i, int j, IntBuffer intbuffer);

    public native void glTexEnviv(int i, int j, int ai[], int k);

    public native void glTexEnvx(int i, int j, int k);

    public native void glTexEnvxv(int i, int j, IntBuffer intbuffer);

    public native void glTexEnvxv(int i, int j, int ai[], int k);

    public native void glTexGenf(int i, int j, float f);

    public native void glTexGenfv(int i, int j, FloatBuffer floatbuffer);

    public native void glTexGenfv(int i, int j, float af[], int k);

    public native void glTexGeni(int i, int j, int k);

    public native void glTexGeniv(int i, int j, IntBuffer intbuffer);

    public native void glTexGeniv(int i, int j, int ai[], int k);

    public native void glTexGenx(int i, int j, int k);

    public native void glTexGenxv(int i, int j, IntBuffer intbuffer);

    public native void glTexGenxv(int i, int j, int ai[], int k);

    public native void glTexImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer);

    public native void glTexParameterf(int i, int j, float f);

    public native void glTexParameterfv(int i, int j, FloatBuffer floatbuffer);

    public native void glTexParameterfv(int i, int j, float af[], int k);

    public native void glTexParameteri(int i, int j, int k);

    public native void glTexParameteriv(int i, int j, IntBuffer intbuffer);

    public native void glTexParameteriv(int i, int j, int ai[], int k);

    public native void glTexParameterx(int i, int j, int k);

    public native void glTexParameterxv(int i, int j, IntBuffer intbuffer);

    public native void glTexParameterxv(int i, int j, int ai[], int k);

    public native void glTexSubImage2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, Buffer buffer);

    public native void glTranslatef(float f, float f1, float f2);

    public native void glTranslatex(int i, int j, int k);

    public native void glVertexPointer(int i, int j, int k, int l);

    public void glVertexPointer(int i, int j, int k, Buffer buffer) {
        glVertexPointerBounds(i, j, k, buffer, buffer.remaining());
        if((i == 2 || i == 3 || i == 4) && (j == 5126 || j == 5120 || j == 5122 || j == 5132) && k >= 0)
            _vertexPointer = buffer;
    }

    public native void glViewport(int i, int j, int k, int l);

    public native void glWeightPointerOES(int i, int j, int k, int l);

    public void glWeightPointerOES(int i, int j, int k, Buffer buffer) {
        glWeightPointerOESBounds(i, j, k, buffer, buffer.remaining());
    }

    Buffer _colorPointer;
    Buffer _matrixIndexPointerOES;
    Buffer _normalPointer;
    Buffer _pointSizePointerOES;
    Buffer _texCoordPointer;
    Buffer _vertexPointer;
    Buffer _weightPointerOES;
    private boolean haveCheckedExtensions;
    private boolean have_OES_blend_equation_separate;
    private boolean have_OES_blend_subtract;
    private boolean have_OES_framebuffer_object;
    private boolean have_OES_texture_cube_map;

    static  {
        _nativeClassInit();
    }
}
