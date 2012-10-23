// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import android.content.Context;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.*;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package android.opengl:
//            EGLLogWrapper, GLDebugHelper

public class GLSurfaceView extends SurfaceView
    implements android.view.SurfaceHolder.Callback {
    private static class GLThreadManager {

        private void checkGLESVersion() {
            if(!mGLESVersionCheckComplete) {
                mGLESVersion = SystemProperties.getInt("ro.opengles.version", 0);
                if(mGLESVersion >= 0x20000)
                    mMultipleGLESContextsAllowed = true;
                mGLESVersionCheckComplete = true;
            }
        }

        /**
         * @deprecated Method checkGLDriver is deprecated
         */

        public void checkGLDriver(GL10 gl10) {
            boolean flag = true;
            this;
            JVM INSTR monitorenter ;
            if(mGLESDriverCheckComplete) goto _L2; else goto _L1
_L1:
            String s;
            checkGLESVersion();
            s = gl10.glGetString(7937);
            if(mGLESVersion >= 0x20000) goto _L4; else goto _L3
_L3:
            boolean flag1;
            if(s.startsWith("Q3Dimension MSM7500 "))
                break MISSING_BLOCK_LABEL_78;
            flag1 = flag;
_L5:
            mMultipleGLESContextsAllowed = flag1;
            notifyAll();
_L4:
            if(mMultipleGLESContextsAllowed)
                flag = false;
            mLimitedGLESContexts = flag;
            mGLESDriverCheckComplete = true;
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            flag1 = false;
              goto _L5
            Exception exception;
            exception;
            throw exception;
        }

        public void releaseEglContextLocked(GLThread glthread) {
            if(mEglOwner == glthread)
                mEglOwner = null;
            notifyAll();
        }

        /**
         * @deprecated Method shouldReleaseEGLContextWhenPausing is deprecated
         */

        public boolean shouldReleaseEGLContextWhenPausing() {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mLimitedGLESContexts;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method shouldTerminateEGLWhenPausing is deprecated
         */

        public boolean shouldTerminateEGLWhenPausing() {
            this;
            JVM INSTR monitorenter ;
            boolean flag;
            checkGLESVersion();
            flag = mMultipleGLESContextsAllowed;
            boolean flag1;
            if(!flag)
                flag1 = true;
            else
                flag1 = false;
            this;
            JVM INSTR monitorexit ;
            return flag1;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method threadExiting is deprecated
         */

        public void threadExiting(GLThread glthread) {
            this;
            JVM INSTR monitorenter ;
            glthread.mExited = true;
            if(mEglOwner == glthread)
                mEglOwner = null;
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public boolean tryAcquireEglContextLocked(GLThread glthread) {
            boolean flag = true;
            if(mEglOwner != glthread && mEglOwner != null) goto _L2; else goto _L1
_L1:
            mEglOwner = glthread;
            notifyAll();
_L4:
            return flag;
_L2:
            checkGLESVersion();
            if(!mMultipleGLESContextsAllowed) {
                if(mEglOwner != null)
                    mEglOwner.requestReleaseEglContextLocked();
                flag = false;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 0x20000;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;


        private GLThreadManager() {
        }

    }

    static class LogWriter extends Writer {

        private void flushBuilder() {
            if(mBuilder.length() > 0) {
                Log.v("GLSurfaceView", mBuilder.toString());
                mBuilder.delete(0, mBuilder.length());
            }
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char ac[], int i, int j) {
            int k = 0;
            while(k < j)  {
                char c = ac[i + k];
                if(c == '\n')
                    flushBuilder();
                else
                    mBuilder.append(c);
                k++;
            }
        }

        private StringBuilder mBuilder;

        LogWriter() {
            mBuilder = new StringBuilder();
        }
    }

    static class GLThread extends Thread {

        private void guardedRun() throws InterruptedException {
            GL10 gl10;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            boolean flag5;
            boolean flag6;
            boolean flag7;
            int i;
            int j;
            Runnable runnable;
            mEglHelper = new EglHelper(mGLSurfaceViewWeakRef);
            mHaveEglContext = false;
            mHaveEglSurface = false;
            gl10 = null;
            flag = false;
            flag1 = false;
            flag2 = false;
            flag3 = false;
            flag4 = false;
            flag5 = false;
            flag6 = false;
            flag7 = false;
            i = 0;
            j = 0;
            runnable = null;
            if(true) goto _L2; else goto _L1
_L1:
            glthreadmanager1;
            JVM INSTR monitorenter ;
_L2:
label0:
            {
                synchronized(GLSurfaceView.sGLThreadManager) {
                    if(!mShouldExit)
                        break label0;
                }
                synchronized(GLSurfaceView.sGLThreadManager) {
                    stopEglSurfaceLocked();
                    stopEglContextLocked();
                }
                return;
            }
            if(mEventQueue.isEmpty()) goto _L4; else goto _L3
_L3:
            runnable = (Runnable)mEventQueue.remove(0);
_L13:
            glthreadmanager1;
            JVM INSTR monitorexit ;
            if(runnable == null)
                break MISSING_BLOCK_LABEL_590;
            runnable.run();
            runnable = null;
              goto _L2
_L4:
            boolean flag8;
            flag8 = false;
            if(mPaused != mRequestPaused) {
                flag8 = mRequestPaused;
                mPaused = mRequestPaused;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
            if(mShouldReleaseEglContext) {
                stopEglSurfaceLocked();
                stopEglContextLocked();
                mShouldReleaseEglContext = false;
                flag7 = true;
            }
            if(flag3) {
                stopEglSurfaceLocked();
                stopEglContextLocked();
                flag3 = false;
            }
            if(flag8 && mHaveEglSurface)
                stopEglSurfaceLocked();
            if(!flag8 || !mHaveEglContext) goto _L6; else goto _L5
_L5:
            GLSurfaceView glsurfaceview3 = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
            if(glsurfaceview3 != null) goto _L8; else goto _L7
_L7:
            boolean flag10 = false;
_L14:
            if(!flag10 || GLSurfaceView.sGLThreadManager.shouldReleaseEGLContextWhenPausing())
                stopEglContextLocked();
_L6:
            if(flag8 && GLSurfaceView.sGLThreadManager.shouldTerminateEGLWhenPausing())
                mEglHelper.finish();
            if(!mHasSurface && !mWaitingForSurface) {
                if(mHaveEglSurface)
                    stopEglSurfaceLocked();
                mWaitingForSurface = true;
                mSurfaceIsBad = false;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
            if(mHasSurface && mWaitingForSurface) {
                mWaitingForSurface = false;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
            if(flag6) {
                flag5 = false;
                flag6 = false;
                mRenderComplete = true;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
            if(!readyToDraw())
                break MISSING_BLOCK_LABEL_581;
            if(mHaveEglContext) goto _L10; else goto _L9
_L9:
            if(!flag7) goto _L12; else goto _L11
_L11:
            flag7 = false;
_L10:
            if(mHaveEglContext && !mHaveEglSurface) {
                mHaveEglSurface = true;
                flag1 = true;
                flag2 = true;
                flag4 = true;
            }
            if(!mHaveEglSurface)
                break MISSING_BLOCK_LABEL_581;
            if(mSizeChanged) {
                flag4 = true;
                i = mWidth;
                j = mHeight;
                flag5 = true;
                flag1 = true;
                mSizeChanged = false;
            }
            mRequestRender = false;
            GLSurfaceView.sGLThreadManager.notifyAll();
              goto _L13
            exception2;
            throw exception2;
            Exception exception;
            exception;
            synchronized(GLSurfaceView.sGLThreadManager) {
                stopEglSurfaceLocked();
                stopEglContextLocked();
            }
            throw exception;
_L8:
            flag10 = glsurfaceview3.mPreserveEGLContextOnPause;
              goto _L14
_L12:
            boolean flag9 = GLSurfaceView.sGLThreadManager.tryAcquireEglContextLocked(this);
            if(!flag9) goto _L10; else goto _L15
_L15:
            try {
                mEglHelper.start();
            }
            catch(RuntimeException runtimeexception) {
                GLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
                throw runtimeexception;
            }
            mHaveEglContext = true;
            flag = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
              goto _L10
            GLSurfaceView.sGLThreadManager.wait();
            if(!flag1) goto _L17; else goto _L16
_L16:
            if(mEglHelper.createSurface()) goto _L19; else goto _L18
_L18:
            GLThreadManager glthreadmanager3 = GLSurfaceView.sGLThreadManager;
            glthreadmanager3;
            JVM INSTR monitorenter ;
            mSurfaceIsBad = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
            glthreadmanager3;
            JVM INSTR monitorexit ;
              goto _L2
_L17:
            if(flag2) {
                gl10 = (GL10)mEglHelper.createGL();
                GLSurfaceView.sGLThreadManager.checkGLDriver(gl10);
                flag2 = false;
            }
            if(!flag) goto _L21; else goto _L20
_L20:
            GLSurfaceView glsurfaceview2 = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
            if(glsurfaceview2 != null)
                glsurfaceview2.mRenderer.onSurfaceCreated(gl10, mEglHelper.mEglConfig);
              goto _L22
_L21:
            if(!flag4) goto _L24; else goto _L23
_L23:
            GLSurfaceView glsurfaceview1 = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
            if(glsurfaceview1 != null)
                glsurfaceview1.mRenderer.onSurfaceChanged(gl10, i, j);
              goto _L25
_L24:
            int k;
            GLSurfaceView glsurfaceview = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
            if(glsurfaceview != null)
                glsurfaceview.mRenderer.onDrawFrame(gl10);
            k = mEglHelper.swap();
            k;
            JVM INSTR lookupswitch 2: default 812
        //                       12288: 886
        //                       12302: 897;
               goto _L26 _L27 _L28
_L26:
            EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", k);
            GLThreadManager glthreadmanager2 = GLSurfaceView.sGLThreadManager;
            glthreadmanager2;
            JVM INSTR monitorenter ;
            mSurfaceIsBad = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
            glthreadmanager2;
            JVM INSTR monitorexit ;
              goto _L27
            exception1;
            glthreadmanager;
            JVM INSTR monitorexit ;
            throw exception1;
            exception3;
            glthreadmanager4;
            JVM INSTR monitorexit ;
            throw exception3;
_L19:
            flag1 = false;
              goto _L17
_L22:
            flag = false;
              goto _L21
_L25:
            flag4 = false;
              goto _L24
_L27:
            if(!flag5) goto _L2; else goto _L29
_L29:
            flag6 = true;
              goto _L2
_L28:
            flag3 = true;
              goto _L27
        }

        private boolean readyToDraw() {
            boolean flag = true;
            if(mPaused || !mHasSurface || mSurfaceIsBad || mWidth <= 0 || mHeight <= 0 || !mRequestRender && mRenderMode != flag)
                flag = false;
            return flag;
        }

        private void stopEglContextLocked() {
            if(mHaveEglContext) {
                mEglHelper.finish();
                mHaveEglContext = false;
                GLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if(mHaveEglSurface) {
                mHaveEglSurface = false;
                mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            boolean flag;
            if(mHaveEglContext && mHaveEglSurface && readyToDraw())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public int getRenderMode() {
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            int i = mRenderMode;
            return i;
        }

        public void onPause() {
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mRequestPaused = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
_L2:
            boolean flag;
            if(mExited)
                break MISSING_BLOCK_LABEL_58;
            flag = mPaused;
            Exception exception;
            if(flag)
                break MISSING_BLOCK_LABEL_58;
            try {
                GLSurfaceView.sGLThreadManager.wait();
            }
            catch(InterruptedException interruptedexception) {
                Thread.currentThread().interrupt();
            }
            finally {
                glthreadmanager;
            }
            if(true) goto _L2; else goto _L1
_L1:
            JVM INSTR monitorexit ;
            throw exception;
            glthreadmanager;
            JVM INSTR monitorexit ;
        }

        public void onResume() {
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mRequestPaused = false;
            mRequestRender = true;
            mRenderComplete = false;
            GLSurfaceView.sGLThreadManager.notifyAll();
_L2:
            boolean flag;
            if(mExited || !mPaused)
                break MISSING_BLOCK_LABEL_75;
            flag = mRenderComplete;
            Exception exception;
            if(flag)
                break MISSING_BLOCK_LABEL_75;
            try {
                GLSurfaceView.sGLThreadManager.wait();
            }
            catch(InterruptedException interruptedexception) {
                Thread.currentThread().interrupt();
            }
            finally {
                glthreadmanager;
            }
            if(true) goto _L2; else goto _L1
_L1:
            JVM INSTR monitorexit ;
            throw exception;
            glthreadmanager;
            JVM INSTR monitorexit ;
        }

        public void onWindowResize(int i, int j) {
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mWidth = i;
            mHeight = j;
            mSizeChanged = true;
            mRequestRender = true;
            mRenderComplete = false;
            GLSurfaceView.sGLThreadManager.notifyAll();
_L2:
            boolean flag;
            if(mExited || mPaused || mRenderComplete)
                break MISSING_BLOCK_LABEL_96;
            flag = ableToDraw();
            Exception exception;
            if(!flag)
                break MISSING_BLOCK_LABEL_96;
            try {
                GLSurfaceView.sGLThreadManager.wait();
            }
            catch(InterruptedException interruptedexception) {
                Thread.currentThread().interrupt();
            }
            finally {
                glthreadmanager;
            }
            if(true) goto _L2; else goto _L1
_L1:
            JVM INSTR monitorexit ;
            throw exception;
            glthreadmanager;
            JVM INSTR monitorexit ;
        }

        public void queueEvent(Runnable runnable) {
            if(runnable == null)
                throw new IllegalArgumentException("r must not be null");
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mEventQueue.add(runnable);
            GLSurfaceView.sGLThreadManager.notifyAll();
            return;
        }

        public void requestExitAndWait() {
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mShouldExit = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
_L2:
            boolean flag = mExited;
            Exception exception;
            if(flag)
                break MISSING_BLOCK_LABEL_51;
            try {
                GLSurfaceView.sGLThreadManager.wait();
            }
            catch(InterruptedException interruptedexception) {
                Thread.currentThread().interrupt();
            }
            finally {
                glthreadmanager;
            }
            if(true) goto _L2; else goto _L1
_L1:
            JVM INSTR monitorexit ;
            throw exception;
            glthreadmanager;
            JVM INSTR monitorexit ;
        }

        public void requestReleaseEglContextLocked() {
            mShouldReleaseEglContext = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
        }

        public void requestRender() {
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mRequestRender = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
            return;
        }

        public void run() {
            setName((new StringBuilder()).append("GLThread ").append(getId()).toString());
            guardedRun();
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
_L2:
            glthreadmanager.threadExiting(this);
            return;
            Exception exception;
            exception;
            GLSurfaceView.sGLThreadManager.threadExiting(this);
            throw exception;
            InterruptedException interruptedexception;
            interruptedexception;
            glthreadmanager = GLSurfaceView.sGLThreadManager;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void setRenderMode(int i) {
            if(i < 0 || i > 1)
                throw new IllegalArgumentException("renderMode");
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mRenderMode = i;
            GLSurfaceView.sGLThreadManager.notifyAll();
            return;
        }

        public void surfaceCreated() {
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mHasSurface = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
_L2:
            boolean flag;
            if(!mWaitingForSurface)
                break MISSING_BLOCK_LABEL_58;
            flag = mExited;
            Exception exception;
            if(flag)
                break MISSING_BLOCK_LABEL_58;
            try {
                GLSurfaceView.sGLThreadManager.wait();
            }
            catch(InterruptedException interruptedexception) {
                Thread.currentThread().interrupt();
            }
            finally {
                glthreadmanager;
            }
            if(true) goto _L2; else goto _L1
_L1:
            JVM INSTR monitorexit ;
            throw exception;
            glthreadmanager;
            JVM INSTR monitorexit ;
        }

        public void surfaceDestroyed() {
            GLThreadManager glthreadmanager = GLSurfaceView.sGLThreadManager;
            glthreadmanager;
            JVM INSTR monitorenter ;
            mHasSurface = false;
            GLSurfaceView.sGLThreadManager.notifyAll();
_L2:
            boolean flag;
            if(mWaitingForSurface)
                break MISSING_BLOCK_LABEL_58;
            flag = mExited;
            Exception exception;
            if(flag)
                break MISSING_BLOCK_LABEL_58;
            try {
                GLSurfaceView.sGLThreadManager.wait();
            }
            catch(InterruptedException interruptedexception) {
                Thread.currentThread().interrupt();
            }
            finally {
                glthreadmanager;
            }
            if(true) goto _L2; else goto _L1
_L1:
            JVM INSTR monitorexit ;
            throw exception;
            glthreadmanager;
            JVM INSTR monitorexit ;
        }

        private EglHelper mEglHelper;
        private ArrayList mEventQueue;
        private boolean mExited;
        private WeakReference mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode;
        private boolean mRequestPaused;
        private boolean mRequestRender;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int mWidth;


/*
        static boolean access$1102(GLThread glthread, boolean flag) {
            glthread.mExited = flag;
            return flag;
        }

*/

        GLThread(WeakReference weakreference) {
            mEventQueue = new ArrayList();
            mSizeChanged = true;
            mWidth = 0;
            mHeight = 0;
            mRequestRender = true;
            mRenderMode = 1;
            mGLSurfaceViewWeakRef = weakreference;
        }
    }

    private static class EglHelper {

        private void destroySurfaceImp() {
            if(mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE) {
                mEgl.eglMakeCurrent(mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLSurfaceView glsurfaceview = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
                if(glsurfaceview != null)
                    glsurfaceview.mEGLWindowSurfaceFactory.destroySurface(mEgl, mEglDisplay, mEglSurface);
                mEglSurface = null;
            }
        }

        public static String formatEglError(String s, int i) {
            return (new StringBuilder()).append(s).append(" failed: ").append(EGLLogWrapper.getErrorString(i)).toString();
        }

        public static void logEglErrorAsWarning(String s, String s1, int i) {
            Log.w(s, formatEglError(s1, i));
        }

        private void throwEglException(String s) {
            throwEglException(s, mEgl.eglGetError());
        }

        public static void throwEglException(String s, int i) {
            throw new RuntimeException(formatEglError(s, i));
        }

        GL createGL() {
            GL gl = mEglContext.getGL();
            GLSurfaceView glsurfaceview = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
            if(glsurfaceview != null) {
                if(glsurfaceview.mGLWrapper != null)
                    gl = glsurfaceview.mGLWrapper.wrap(gl);
                if((3 & glsurfaceview.mDebugFlags) != 0) {
                    int i = 0;
                    LogWriter logwriter = null;
                    if((1 & glsurfaceview.mDebugFlags) != 0)
                        i = false | true;
                    if((2 & glsurfaceview.mDebugFlags) != 0)
                        logwriter = new LogWriter();
                    gl = GLDebugHelper.wrap(gl, i, logwriter);
                }
            }
            return gl;
        }

        public boolean createSurface() {
            boolean flag = false;
            if(mEgl == null)
                throw new RuntimeException("egl not initialized");
            if(mEglDisplay == null)
                throw new RuntimeException("eglDisplay not initialized");
            if(mEglConfig == null)
                throw new RuntimeException("mEglConfig not initialized");
            destroySurfaceImp();
            GLSurfaceView glsurfaceview = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
            if(glsurfaceview != null)
                mEglSurface = glsurfaceview.mEGLWindowSurfaceFactory.createWindowSurface(mEgl, mEglDisplay, mEglConfig, glsurfaceview.getHolder());
            else
                mEglSurface = null;
            if(mEglSurface == null || mEglSurface == EGL10.EGL_NO_SURFACE) {
                if(mEgl.eglGetError() == 12299)
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
            } else
            if(!mEgl.eglMakeCurrent(mEglDisplay, mEglSurface, mEglSurface, mEglContext))
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", mEgl.eglGetError());
            else
                flag = true;
            return flag;
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void finish() {
            if(mEglContext != null) {
                GLSurfaceView glsurfaceview = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
                if(glsurfaceview != null)
                    glsurfaceview.mEGLContextFactory.destroyContext(mEgl, mEglDisplay, mEglContext);
                mEglContext = null;
            }
            if(mEglDisplay != null) {
                mEgl.eglTerminate(mEglDisplay);
                mEglDisplay = null;
            }
        }

        public void start() {
            mEgl = (EGL10)EGLContext.getEGL();
            mEglDisplay = mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if(mEglDisplay == EGL10.EGL_NO_DISPLAY)
                throw new RuntimeException("eglGetDisplay failed");
            int ai[] = new int[2];
            if(!mEgl.eglInitialize(mEglDisplay, ai))
                throw new RuntimeException("eglInitialize failed");
            GLSurfaceView glsurfaceview = (GLSurfaceView)mGLSurfaceViewWeakRef.get();
            if(glsurfaceview == null) {
                mEglConfig = null;
                mEglContext = null;
            } else {
                mEglConfig = glsurfaceview.mEGLConfigChooser.chooseConfig(mEgl, mEglDisplay);
                mEglContext = glsurfaceview.mEGLContextFactory.createContext(mEgl, mEglDisplay, mEglConfig);
            }
            if(mEglContext == null || mEglContext == EGL10.EGL_NO_CONTEXT) {
                mEglContext = null;
                throwEglException("createContext");
            }
            mEglSurface = null;
        }

        public int swap() {
            int i;
            if(!mEgl.eglSwapBuffers(mEglDisplay, mEglSurface))
                i = mEgl.eglGetError();
            else
                i = 12288;
            return i;
        }

        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference weakreference) {
            mGLSurfaceViewWeakRef = weakreference;
        }
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser {

        final GLSurfaceView this$0;

        public SimpleEGLConfigChooser(boolean flag) {
            this$0 = GLSurfaceView.this;
            byte byte0;
            if(flag)
                byte0 = 16;
            else
                byte0 = 0;
            super(5, 6, 5, 0, byte0, 0);
        }
    }

    private class ComponentSizeChooser extends BaseConfigChooser {

        private int findConfigAttrib(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, int i, int j) {
            if(egl10.eglGetConfigAttrib(egldisplay, eglconfig, i, mValue))
                j = mValue[0];
            return j;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay, EGLConfig aeglconfig[]) {
            int i;
            int j;
            i = aeglconfig.length;
            j = 0;
_L3:
            if(j >= i) goto _L2; else goto _L1
_L1:
            EGLConfig eglconfig;
            eglconfig = aeglconfig[j];
            int k = findConfigAttrib(egl10, egldisplay, eglconfig, 12325, 0);
            int l = findConfigAttrib(egl10, egldisplay, eglconfig, 12326, 0);
            if(k < mDepthSize || l < mStencilSize)
                continue; /* Loop/switch isn't completed */
            int i1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12324, 0);
            int j1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12323, 0);
            int k1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12322, 0);
            int l1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12321, 0);
            if(i1 != mRedSize || j1 != mGreenSize || k1 != mBlueSize || l1 != mAlphaSize)
                continue; /* Loop/switch isn't completed */
_L4:
            return eglconfig;
            j++;
              goto _L3
_L2:
            eglconfig = null;
              goto _L4
        }

        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int mValue[];
        final GLSurfaceView this$0;

        public ComponentSizeChooser(int i, int j, int k, int l, int i1, int j1) {
            this$0 = GLSurfaceView.this;
            int ai[] = new int[13];
            ai[0] = 12324;
            ai[1] = i;
            ai[2] = 12323;
            ai[3] = j;
            ai[4] = 12322;
            ai[5] = k;
            ai[6] = 12321;
            ai[7] = l;
            ai[8] = 12325;
            ai[9] = i1;
            ai[10] = 12326;
            ai[11] = j1;
            ai[12] = 12344;
            super(ai);
            mValue = new int[1];
            mRedSize = i;
            mGreenSize = j;
            mBlueSize = k;
            mAlphaSize = l;
            mDepthSize = i1;
            mStencilSize = j1;
        }
    }

    private abstract class BaseConfigChooser
        implements EGLConfigChooser {

        private int[] filterConfigSpec(int ai[]) {
            if(mEGLContextClientVersion == 2) {
                int i = ai.length;
                int ai1[] = new int[i + 2];
                System.arraycopy(ai, 0, ai1, 0, i - 1);
                ai1[i - 1] = 12352;
                ai1[i] = 4;
                ai1[i + 1] = 12344;
                ai = ai1;
            }
            return ai;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay) {
            int ai[] = new int[1];
            if(!egl10.eglChooseConfig(egldisplay, mConfigSpec, null, 0, ai))
                throw new IllegalArgumentException("eglChooseConfig failed");
            int i = ai[0];
            if(i <= 0)
                throw new IllegalArgumentException("No configs match configSpec");
            EGLConfig aeglconfig[] = new EGLConfig[i];
            if(!egl10.eglChooseConfig(egldisplay, mConfigSpec, aeglconfig, i, ai))
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            EGLConfig eglconfig = chooseConfig(egl10, egldisplay, aeglconfig);
            if(eglconfig == null)
                throw new IllegalArgumentException("No config chosen");
            else
                return eglconfig;
        }

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay, EGLConfig aeglconfig[]);

        protected int mConfigSpec[];
        final GLSurfaceView this$0;

        public BaseConfigChooser(int ai[]) {
            this$0 = GLSurfaceView.this;
            super();
            mConfigSpec = filterConfigSpec(ai);
        }
    }

    public static interface EGLConfigChooser {

        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay);
    }

    private static class DefaultWindowSurfaceFactory
        implements EGLWindowSurfaceFactory {

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, Object obj) {
            EGLSurface eglsurface = null;
            EGLSurface eglsurface1 = egl10.eglCreateWindowSurface(egldisplay, eglconfig, obj, null);
            eglsurface = eglsurface1;
_L2:
            return eglsurface;
            IllegalArgumentException illegalargumentexception;
            illegalargumentexception;
            Log.e("GLSurfaceView", "eglCreateWindowSurface", illegalargumentexception);
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void destroySurface(EGL10 egl10, EGLDisplay egldisplay, EGLSurface eglsurface) {
            egl10.eglDestroySurface(egldisplay, eglsurface);
        }

        private DefaultWindowSurfaceFactory() {
        }

    }

    public static interface EGLWindowSurfaceFactory {

        public abstract EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, Object obj);

        public abstract void destroySurface(EGL10 egl10, EGLDisplay egldisplay, EGLSurface eglsurface);
    }

    private class DefaultContextFactory
        implements EGLContextFactory {

        public EGLContext createContext(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig) {
            int ai[] = new int[3];
            ai[0] = EGL_CONTEXT_CLIENT_VERSION;
            ai[1] = mEGLContextClientVersion;
            ai[2] = 12344;
            EGLContext eglcontext = EGL10.EGL_NO_CONTEXT;
            if(mEGLContextClientVersion == 0)
                ai = null;
            return egl10.eglCreateContext(egldisplay, eglconfig, eglcontext, ai);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay egldisplay, EGLContext eglcontext) {
            if(!egl10.eglDestroyContext(egldisplay, eglcontext)) {
                Log.e("DefaultContextFactory", (new StringBuilder()).append("display:").append(egldisplay).append(" context: ").append(eglcontext).toString());
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
        }

        private int EGL_CONTEXT_CLIENT_VERSION;
        final GLSurfaceView this$0;

        private DefaultContextFactory() {
            this$0 = GLSurfaceView.this;
            super();
            EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

    }

    public static interface EGLContextFactory {

        public abstract EGLContext createContext(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig);

        public abstract void destroyContext(EGL10 egl10, EGLDisplay egldisplay, EGLContext eglcontext);
    }

    public static interface Renderer {

        public abstract void onDrawFrame(GL10 gl10);

        public abstract void onSurfaceChanged(GL10 gl10, int i, int j);

        public abstract void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig);
    }

    public static interface GLWrapper {

        public abstract GL wrap(GL gl);
    }


    public GLSurfaceView(Context context) {
        super(context);
        mThisWeakRef = new WeakReference(this);
        init();
    }

    public GLSurfaceView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mThisWeakRef = new WeakReference(this);
        init();
    }

    private void checkRenderThreadState() {
        if(mGLThread != null)
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        else
            return;
    }

    private void init() {
        getHolder().addCallback(this);
    }

    protected void finalize() throws Throwable {
        if(mGLThread != null)
            mGLThread.requestExitAndWait();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getDebugFlags() {
        return mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return mGLThread.getRenderMode();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(mDetached && mRenderer != null) {
            int i = 1;
            if(mGLThread != null)
                i = mGLThread.getRenderMode();
            mGLThread = new GLThread(mThisWeakRef);
            if(i != 1)
                mGLThread.setRenderMode(i);
            mGLThread.start();
        }
        mDetached = false;
    }

    protected void onDetachedFromWindow() {
        if(mGLThread != null)
            mGLThread.requestExitAndWait();
        mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        mGLThread.onPause();
    }

    public void onResume() {
        mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        mGLThread.queueEvent(runnable);
    }

    public void requestRender() {
        mGLThread.requestRender();
    }

    public void setDebugFlags(int i) {
        mDebugFlags = i;
    }

    public void setEGLConfigChooser(int i, int j, int k, int l, int i1, int j1) {
        setEGLConfigChooser(((EGLConfigChooser) (new ComponentSizeChooser(i, j, k, l, i1, j1))));
    }

    public void setEGLConfigChooser(EGLConfigChooser eglconfigchooser) {
        checkRenderThreadState();
        mEGLConfigChooser = eglconfigchooser;
    }

    public void setEGLConfigChooser(boolean flag) {
        setEGLConfigChooser(((EGLConfigChooser) (new SimpleEGLConfigChooser(flag))));
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        mEGLContextClientVersion = i;
    }

    public void setEGLContextFactory(EGLContextFactory eglcontextfactory) {
        checkRenderThreadState();
        mEGLContextFactory = eglcontextfactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eglwindowsurfacefactory) {
        checkRenderThreadState();
        mEGLWindowSurfaceFactory = eglwindowsurfacefactory;
    }

    public void setGLWrapper(GLWrapper glwrapper) {
        mGLWrapper = glwrapper;
    }

    public void setPreserveEGLContextOnPause(boolean flag) {
        mPreserveEGLContextOnPause = flag;
    }

    public void setRenderMode(int i) {
        mGLThread.setRenderMode(i);
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if(mEGLConfigChooser == null)
            mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        if(mEGLContextFactory == null)
            mEGLContextFactory = new DefaultContextFactory();
        if(mEGLWindowSurfaceFactory == null)
            mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        mRenderer = renderer;
        mGLThread = new GLThread(mThisWeakRef);
        mGLThread.start();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
        mGLThread.onWindowResize(j, k);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder) {
        mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder) {
        mGLThread.surfaceDestroyed();
    }

    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceView";
    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private Renderer mRenderer;
    private final WeakReference mThisWeakRef;










}
