// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.*;
import android.opengl.GLUtils;
import android.opengl.ManagedEGLContext;
import android.os.*;
import android.util.Log;
import com.google.android.gles_jni.EGLImpl;
import java.io.File;
import java.io.PrintWriter;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.*;
import javax.microedition.khronos.opengles.GL;

// Referenced classes of package android.view:
//            GLES20Canvas, DisplayList, HardwareLayer, View, 
//            HardwareCanvas, SurfaceHolder, ViewGroup, GLES20DisplayList, 
//            GLES20RenderLayer, GLES20TextureLayer, ViewRootImpl, Surface

public abstract class HardwareRenderer {
    static class Gl20Renderer extends GlRenderer {
        static class Gl20RendererEglContext extends ManagedEGLContext {

            public void onTerminate(final EGLContext eglContext) {
                if(mHandler.getLooper() == Looper.myLooper()) goto _L2; else goto _L1
_L1:
                mHandler.post(new Runnable() {

                    public void run() {
                        onTerminate(eglContext);
                    }

                    final Gl20RendererEglContext this$0;
                    final EGLContext val$eglContext;

                     {
                        this$0 = Gl20RendererEglContext.this;
                        eglContext = eglcontext;
                        super();
                    }
                });
_L3:
                return;
_L2:
                Object aobj[] = GlRenderer.sEglLock;
                aobj;
                JVM INSTR monitorenter ;
                if(GlRenderer.sEgl != null) goto _L4; else goto _L3
_L4:
                break MISSING_BLOCK_LABEL_53;
                Exception exception;
                exception;
                throw exception;
                if(EGLImpl.getInitCount(GlRenderer.sEglDisplay) == 1) {
                    Gl20Renderer.usePbufferSurface(eglContext);
                    GLES20Canvas.terminateCaches();
                    GlRenderer.sEgl.eglDestroyContext(GlRenderer.sEglDisplay, eglContext);
                    GlRenderer.sEglContextStorage.set(null);
                    GlRenderer.sEglContextStorage.remove();
                    GlRenderer.sEgl.eglDestroySurface(GlRenderer.sEglDisplay, Gl20Renderer.sPbuffer);
                    GlRenderer.sEgl.eglMakeCurrent(GlRenderer.sEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                    GlRenderer.sEgl.eglReleaseThread();
                    GlRenderer.sEgl.eglTerminate(GlRenderer.sEglDisplay);
                    GlRenderer.sEgl = null;
                    GlRenderer.sEglDisplay = null;
                    GlRenderer.sEglConfig = null;
                    Gl20Renderer.sPbuffer = null;
                }
                aobj;
                JVM INSTR monitorexit ;
                  goto _L3
            }

            final Handler mHandler = new Handler();

            public Gl20RendererEglContext(EGLContext eglcontext) {
                super(eglcontext);
            }
        }


        static HardwareRenderer create(boolean flag) {
            Gl20Renderer gl20renderer;
            if(GLES20Canvas.isAvailable())
                gl20renderer = new Gl20Renderer(flag);
            else
                gl20renderer = null;
            return gl20renderer;
        }

        private static void destroyHardwareLayer(View view) {
            view.destroyLayer(true);
            if(view instanceof ViewGroup) {
                ViewGroup viewgroup = (ViewGroup)view;
                int i = viewgroup.getChildCount();
                for(int j = 0; j < i; j++)
                    destroyHardwareLayer(viewgroup.getChildAt(j));

            }
        }

        private static void destroyResources(View view) {
            view.destroyHardwareResources();
            if(view instanceof ViewGroup) {
                ViewGroup viewgroup = (ViewGroup)view;
                int i = viewgroup.getChildCount();
                for(int j = 0; j < i; j++)
                    destroyResources(viewgroup.getChildAt(j));

            }
        }

        static void endTrimMemory() {
            if(sEgl != null && sEglDisplay != null)
                sEgl.eglMakeCurrent(sEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        }

        static void startTrimMemory(int i) {
            if(sEgl != null && sEglConfig != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            Gl20RendererEglContext gl20renderereglcontext = (Gl20RendererEglContext)sEglContextStorage.get();
            if(gl20renderereglcontext != null) {
                usePbufferSurface(gl20renderereglcontext.getContext());
                if(i >= 80)
                    GLES20Canvas.flushCaches(2);
                else
                if(i >= 20)
                    GLES20Canvas.flushCaches(1);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private static void usePbufferSurface(EGLContext eglcontext) {
            synchronized(sPbufferLock) {
                if(sPbuffer == null) {
                    EGL10 egl10 = sEgl;
                    EGLDisplay egldisplay = sEglDisplay;
                    EGLConfig eglconfig = sEglConfig;
                    int ai[] = new int[5];
                    ai[0] = 12375;
                    ai[1] = 1;
                    ai[2] = 12374;
                    ai[3] = 1;
                    ai[4] = 12344;
                    sPbuffer = egl10.eglCreatePbufferSurface(egldisplay, eglconfig, ai);
                }
            }
            sEgl.eglMakeCurrent(sEglDisplay, sPbuffer, sPbuffer, eglcontext);
            return;
            exception;
            aobj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        boolean canDraw() {
            boolean flag;
            if(super.canDraw() && mGlCanvas != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        HardwareCanvas createCanvas() {
            GLES20Canvas gles20canvas = new GLES20Canvas(super.mTranslucent);
            mGlCanvas = gles20canvas;
            return gles20canvas;
        }

        public DisplayList createDisplayList(String s) {
            return new GLES20DisplayList(s);
        }

        HardwareLayer createHardwareLayer(int i, int j, boolean flag) {
            return new GLES20RenderLayer(i, j, flag);
        }

        HardwareLayer createHardwareLayer(boolean flag) {
            return new GLES20TextureLayer(flag);
        }

        ManagedEGLContext createManagedContext(EGLContext eglcontext) {
            return new Gl20RendererEglContext(super.mEglContext);
        }

        SurfaceTexture createSurfaceTexture(HardwareLayer hardwarelayer) {
            return ((GLES20TextureLayer)hardwarelayer).getSurfaceTexture();
        }

        void destroy(boolean flag) {
            super.destroy(flag);
            if(flag && mGlCanvas != null)
                mGlCanvas = null;
            return;
            Exception exception;
            exception;
            if(flag && mGlCanvas != null)
                mGlCanvas = null;
            throw exception;
        }

        void destroyHardwareResources(final View view) {
            if(view != null)
                safelyRun(new Runnable() {

                    public void run() {
                        Gl20Renderer.destroyResources(view);
                        GLES20Canvas.flushCaches(0);
                    }

                    final Gl20Renderer this$0;
                    final View val$view;

                 {
                    this$0 = Gl20Renderer.this;
                    view = view1;
                    super();
                }
                });
        }

        void destroyLayers(View view) {
            if(view != null && isEnabled() && checkCurrent() != 0) {
                destroyHardwareLayer(view);
                GLES20Canvas.flushCaches(0);
            }
        }

        int[] getConfig(boolean flag) {
            int i = 0;
            int ai[] = new int[17];
            ai[i] = 12352;
            ai[1] = 4;
            ai[2] = 12324;
            ai[3] = 8;
            ai[4] = 12323;
            ai[5] = 8;
            ai[6] = 12322;
            ai[7] = 8;
            ai[8] = 12321;
            ai[9] = 8;
            ai[10] = 12325;
            ai[11] = 0;
            ai[12] = 12326;
            ai[13] = GLES20Canvas.getStencilSize();
            ai[14] = 12339;
            if(flag)
                i = 1024;
            ai[15] = i | 4;
            ai[16] = 12344;
            return ai;
        }

        void initCaches() {
            GLES20Canvas.initCaches();
        }

        void onPostDraw() {
            mGlCanvas.onPostDraw();
        }

        int onPreDraw(Rect rect) {
            return mGlCanvas.onPreDraw(rect);
        }

        boolean safelyRun(Runnable runnable) {
            boolean flag;
            flag = true;
            if(isEnabled() && checkCurrent() != 0)
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            Gl20RendererEglContext gl20renderereglcontext = (Gl20RendererEglContext)sEglContextStorage.get();
            if(gl20renderereglcontext != null) goto _L4; else goto _L3
_L3:
            boolean flag1 = false;
_L6:
            return flag1;
_L4:
            usePbufferSurface(gl20renderereglcontext.getContext());
_L2:
            runnable.run();
            if(flag)
                sEgl.eglMakeCurrent(sEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            flag1 = true;
            if(true) goto _L6; else goto _L5
_L5:
            Exception exception;
            exception;
            if(flag)
                sEgl.eglMakeCurrent(sEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            throw exception;
        }

        void setSurfaceTexture(HardwareLayer hardwarelayer, SurfaceTexture surfacetexture) {
            ((GLES20TextureLayer)hardwarelayer).setSurfaceTexture(surfacetexture);
        }

        void setup(int i, int j) {
            super.setup(i, j);
            if(super.mVsyncDisabled)
                disableVsync();
        }

        private static EGLSurface sPbuffer;
        private static final Object sPbufferLock[] = new Object[0];
        private GLES20Canvas mGlCanvas;





/*
        static EGLSurface access$402(EGLSurface eglsurface) {
            sPbuffer = eglsurface;
            return eglsurface;
        }

*/


        Gl20Renderer(boolean flag) {
            super(2, flag);
        }
    }

    static abstract class GlRenderer extends HardwareRenderer {
        class FunctorsRunnable
            implements Runnable {

            public void run() {
                HardwareRenderer hardwarerenderer;
                hardwarerenderer = attachInfo.mHardwareRenderer;
                break MISSING_BLOCK_LABEL_8;
                if(hardwarerenderer != null && hardwarerenderer.isEnabled() && hardwarerenderer == GlRenderer.this && checkCurrent() != 0) {
                    int i = mCanvas.invokeFunctors(mRedrawClip);
                    handleFunctorStatus(attachInfo, i);
                }
                return;
            }

            View.AttachInfo attachInfo;
            final GlRenderer this$0;

            FunctorsRunnable() {
                this$0 = GlRenderer.this;
                super();
            }
        }


        private EGLConfig chooseEglConfig() {
            EGLConfig aeglconfig[] = new EGLConfig[1];
            int ai[] = new int[1];
            int ai1[] = getConfig(sDirtyRegions);
            String s = SystemProperties.get("debug.hwui.print_config", "");
            if("all".equalsIgnoreCase(s)) {
                sEgl.eglChooseConfig(sEglDisplay, ai1, null, 0, ai);
                EGLConfig aeglconfig1[] = new EGLConfig[ai[0]];
                sEgl.eglChooseConfig(sEglDisplay, ai1, aeglconfig1, ai[0], ai);
                int i = aeglconfig1.length;
                for(int j = 0; j < i; j++)
                    printConfig(aeglconfig1[j]);

            }
            if(!sEgl.eglChooseConfig(sEglDisplay, ai1, aeglconfig, 1, ai))
                throw new IllegalArgumentException((new StringBuilder()).append("eglChooseConfig failed ").append(GLUtils.getEGLErrorString(sEgl.eglGetError())).toString());
            EGLConfig eglconfig;
            if(ai[0] > 0) {
                if("choice".equalsIgnoreCase(s))
                    printConfig(aeglconfig[0]);
                eglconfig = aeglconfig[0];
            } else {
                eglconfig = null;
            }
            return eglconfig;
        }

        private boolean createSurface(SurfaceHolder surfaceholder) {
            mEglSurface = sEgl.eglCreateWindowSurface(sEglDisplay, sEglConfig, surfaceholder, null);
            if(mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE) goto _L2; else goto _L1
_L1:
            int i = sEgl.eglGetError();
            if(i != 12299) goto _L4; else goto _L3
_L3:
            boolean flag;
            Log.e("HardwareRenderer", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
            flag = false;
_L6:
            return flag;
_L4:
            throw new RuntimeException((new StringBuilder()).append("createWindowSurface failed ").append(GLUtils.getEGLErrorString(i)).toString());
_L2:
            flag = true;
            if(true) goto _L6; else goto _L5
_L5:
        }

        private void enableDirtyRegions() {
            if(!sDirtyRegions) goto _L2; else goto _L1
_L1:
            boolean flag = preserveBackBuffer();
            mDirtyRegionsEnabled = flag;
            if(!flag)
                Log.w("HardwareRenderer", "Backbuffer cannot be preserved");
_L4:
            return;
_L2:
            if(sDirtyRegionsRequested)
                mDirtyRegionsEnabled = isBackBufferPreserved();
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void fallback(boolean flag) {
            destroy(true);
            if(flag) {
                setRequested(false);
                Log.w("HardwareRenderer", "Mountain View, we've had a problem here. Switching back to software rendering.");
            }
        }

        private void handleFunctorStatus(View.AttachInfo attachinfo, int i) {
            if((i & 1) != 0)
                if(mRedrawClip.isEmpty()) {
                    attachinfo.mViewRootImpl.invalidate();
                } else {
                    attachinfo.mViewRootImpl.invalidateChildInParent(null, mRedrawClip);
                    mRedrawClip.setEmpty();
                }
            if((i & 2) != 0)
                scheduleFunctors(attachinfo, true);
        }

        private static void printConfig(EGLConfig eglconfig) {
            int ai[] = new int[1];
            Log.d("HardwareRenderer", (new StringBuilder()).append("EGL configuration ").append(eglconfig).append(":").toString());
            sEgl.eglGetConfigAttrib(sEglDisplay, eglconfig, 12324, ai);
            Log.d("HardwareRenderer", (new StringBuilder()).append("  RED_SIZE = ").append(ai[0]).toString());
            sEgl.eglGetConfigAttrib(sEglDisplay, eglconfig, 12323, ai);
            Log.d("HardwareRenderer", (new StringBuilder()).append("  GREEN_SIZE = ").append(ai[0]).toString());
            sEgl.eglGetConfigAttrib(sEglDisplay, eglconfig, 12322, ai);
            Log.d("HardwareRenderer", (new StringBuilder()).append("  BLUE_SIZE = ").append(ai[0]).toString());
            sEgl.eglGetConfigAttrib(sEglDisplay, eglconfig, 12321, ai);
            Log.d("HardwareRenderer", (new StringBuilder()).append("  ALPHA_SIZE = ").append(ai[0]).toString());
            sEgl.eglGetConfigAttrib(sEglDisplay, eglconfig, 12325, ai);
            Log.d("HardwareRenderer", (new StringBuilder()).append("  DEPTH_SIZE = ").append(ai[0]).toString());
            sEgl.eglGetConfigAttrib(sEglDisplay, eglconfig, 12326, ai);
            Log.d("HardwareRenderer", (new StringBuilder()).append("  STENCIL_SIZE = ").append(ai[0]).toString());
            sEgl.eglGetConfigAttrib(sEglDisplay, eglconfig, 12339, ai);
            Log.d("HardwareRenderer", (new StringBuilder()).append("  SURFACE_TYPE = 0x").append(Integer.toHexString(ai[0])).toString());
        }

        private void scheduleFunctors(View.AttachInfo attachinfo, boolean flag) {
            mFunctorsRunnable.attachInfo = attachinfo;
            if(!attachinfo.mHandler.hasCallbacks(mFunctorsRunnable)) {
                Handler handler = attachinfo.mHandler;
                FunctorsRunnable functorsrunnable = mFunctorsRunnable;
                long l;
                if(flag)
                    l = 4L;
                else
                    l = 0L;
                handler.postDelayed(functorsrunnable, l);
            }
        }

        boolean attachFunctor(View.AttachInfo attachinfo, int i) {
            boolean flag = false;
            if(mCanvas != null) {
                mCanvas.attachFunctor(i);
                scheduleFunctors(attachinfo, false);
                flag = true;
            }
            return flag;
        }

        boolean canDraw() {
            boolean flag;
            if(mGl != null && mCanvas != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        int checkCurrent() {
            boolean flag = true;
            if(mEglThread != Thread.currentThread())
                throw new IllegalStateException((new StringBuilder()).append("Hardware acceleration can only be used with a single UI thread.\nOriginal thread: ").append(mEglThread).append("\n").append("Current thread: ").append(Thread.currentThread()).toString());
            if(!mEglContext.equals(sEgl.eglGetCurrentContext()) || !mEglSurface.equals(sEgl.eglGetCurrentSurface(12377)))
                if(!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext)) {
                    Log.e("HardwareRenderer", (new StringBuilder()).append("eglMakeCurrent failed ").append(GLUtils.getEGLErrorString(sEgl.eglGetError())).toString());
                    fallback(flag);
                    flag = false;
                } else {
                    if(mUpdateDirtyRegions) {
                        enableDirtyRegions();
                        mUpdateDirtyRegions = false;
                    }
                    flag = 2;
                }
            return ((flag) ? 1 : 0);
        }

        void checkEglErrors() {
            if(isEnabled()) {
                int i = sEgl.eglGetError();
                if(i != 12288) {
                    Log.w("HardwareRenderer", (new StringBuilder()).append("EGL error: ").append(GLUtils.getEGLErrorString(i)).toString());
                    boolean flag;
                    if(i != 12302)
                        flag = true;
                    else
                        flag = false;
                    fallback(flag);
                }
            }
        }

        abstract HardwareCanvas createCanvas();

        EGLContext createContext(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig) {
            int ai[] = new int[3];
            ai[0] = 12440;
            ai[1] = mGlVersion;
            ai[2] = 12344;
            EGLContext eglcontext = EGL10.EGL_NO_CONTEXT;
            if(mGlVersion == 0)
                ai = null;
            return egl10.eglCreateContext(egldisplay, eglconfig, eglcontext, ai);
        }

        GL createEglSurface(SurfaceHolder surfaceholder) throws Surface.OutOfResourcesException {
            if(sEgl == null)
                throw new RuntimeException("egl not initialized");
            if(sEglDisplay == null)
                throw new RuntimeException("eglDisplay not initialized");
            if(sEglConfig == null)
                throw new RuntimeException("eglConfig not initialized");
            if(Thread.currentThread() != mEglThread)
                throw new IllegalStateException("HardwareRenderer cannot be used from multiple threads");
            destroySurface();
            GL gl;
            if(!createSurface(surfaceholder)) {
                gl = null;
            } else {
                if(!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext))
                    throw new Surface.OutOfResourcesException((new StringBuilder()).append("eglMakeCurrent failed ").append(GLUtils.getEGLErrorString(sEgl.eglGetError())).toString());
                initCaches();
                enableDirtyRegions();
                gl = mEglContext.getGL();
            }
            return gl;
        }

        abstract ManagedEGLContext createManagedContext(EGLContext eglcontext);

        void destroy(boolean flag) {
            if(flag && mCanvas != null)
                mCanvas = null;
            if(!isEnabled() || mDestroyed) {
                setEnabled(false);
            } else {
                destroySurface();
                setEnabled(false);
                mDestroyed = true;
                mGl = null;
            }
        }

        void destroySurface() {
            if(mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE) {
                sEgl.eglMakeCurrent(sEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
            }
        }

        void detachFunctor(int i) {
            if(mCanvas != null)
                mCanvas.detachFunctor(i);
        }

        boolean draw(View view, View.AttachInfo attachinfo, HardwareDrawCallbacks hardwaredrawcallbacks, Rect rect) {
            boolean flag;
            HardwareCanvas hardwarecanvas;
            int k;
            boolean flag1;
            if(!canDraw())
                break MISSING_BLOCK_LABEL_756;
            if(!hasDirtyRegions())
                rect = null;
            attachinfo.mIgnoreDirtyState = true;
            attachinfo.mDrawingTime = SystemClock.uptimeMillis();
            view.mPrivateFlags = 0x20 | view.mPrivateFlags;
            int i = checkCurrent();
            if(i == 0)
                break MISSING_BLOCK_LABEL_756;
            hardwarecanvas = mCanvas;
            attachinfo.mHardwareCanvas = hardwarecanvas;
            if(mProfileEnabled)
                mProfileLock.lock();
            int j;
            long l;
            DisplayList displaylist;
            long l1;
            float f;
            Paint paint1;
            long l2;
            int i1;
            float f1;
            float f2;
            if(i == 2) {
                rect = null;
                HardwareRenderer.beginFrame(null);
            } else {
                int ai[] = mSurfaceSize;
                HardwareRenderer.beginFrame(ai);
                if(ai[1] != mHeight || ai[0] != mWidth) {
                    mWidth = ai[0];
                    mHeight = ai[1];
                    hardwarecanvas.setViewport(mWidth, mHeight);
                    rect = null;
                }
            }
            j = onPreDraw(rect);
            k = hardwarecanvas.save();
            hardwaredrawcallbacks.onHardwarePreDraw(hardwarecanvas);
            if((0x80000000 & view.mPrivateFlags) != 0x80000000) goto _L2; else goto _L1
_L1:
            flag1 = true;
_L5:
            view.mRecreateDisplayList = flag1;
            view.mPrivateFlags = 0x7fffffff & view.mPrivateFlags;
            l = 0L;
            if(mProfileEnabled) {
                mProfileCurrentFrame = 3 + mProfileCurrentFrame;
                if(mProfileCurrentFrame >= mProfileData.length)
                    mProfileCurrentFrame = 0;
                l = System.nanoTime();
            }
            Trace.traceBegin(8L, "getDisplayList");
            displaylist = view.getDisplayList();
            Trace.traceEnd(8L);
            if(mProfileEnabled) {
                f2 = 1E-06F * (float)(System.nanoTime() - l);
                mProfileData[mProfileCurrentFrame] = f2;
            }
            if(displaylist == null) goto _L4; else goto _L3
_L3:
            l2 = 0L;
            if(mProfileEnabled)
                l2 = System.nanoTime();
            Trace.traceBegin(8L, "drawDisplayList");
            i1 = hardwarecanvas.drawDisplayList(displaylist, mRedrawClip, 1);
            j |= i1;
            Trace.traceEnd(8L);
            if(mProfileEnabled) {
                f1 = 1E-06F * (float)(System.nanoTime() - l2);
                mProfileData[1 + mProfileCurrentFrame] = f1;
            }
            handleFunctorStatus(attachinfo, j);
_L6:
            hardwaredrawcallbacks.onHardwarePostDraw(hardwarecanvas);
            hardwarecanvas.restoreToCount(k);
            view.mRecreateDisplayList = false;
            mFrameCount = 1L + mFrameCount;
            if(mDebugDirtyRegions) {
                if(mDebugPaint == null) {
                    mDebugPaint = new Paint();
                    mDebugPaint.setColor(0x7fff0000);
                }
                if(rect != null && (1L & mFrameCount) == 0L) {
                    paint1 = mDebugPaint;
                    hardwarecanvas.drawRect(rect, paint1);
                }
            }
            onPostDraw();
            attachinfo.mIgnoreDirtyState = false;
            if((j & 4) == 4) {
                l1 = 0L;
                if(mProfileEnabled)
                    l1 = System.nanoTime();
                sEgl.eglSwapBuffers(sEglDisplay, mEglSurface);
                if(mProfileEnabled) {
                    f = 1E-06F * (float)(System.nanoTime() - l1);
                    mProfileData[2 + mProfileCurrentFrame] = f;
                }
                checkEglErrors();
            }
            if(mProfileEnabled)
                mProfileLock.unlock();
            Exception exception;
            Paint paint;
            Exception exception1;
            Exception exception2;
            if(rect == null)
                flag = true;
            else
                flag = false;
_L7:
            return flag;
_L2:
            flag1 = false;
              goto _L5
            exception1;
            Trace.traceEnd(8L);
            throw exception1;
            exception;
            hardwaredrawcallbacks.onHardwarePostDraw(hardwarecanvas);
            hardwarecanvas.restoreToCount(k);
            view.mRecreateDisplayList = false;
            mFrameCount = 1L + mFrameCount;
            if(mDebugDirtyRegions) {
                if(mDebugPaint == null) {
                    mDebugPaint = new Paint();
                    mDebugPaint.setColor(0x7fff0000);
                }
                if(rect != null && (1L & mFrameCount) == 0L) {
                    paint = mDebugPaint;
                    hardwarecanvas.drawRect(rect, paint);
                }
            }
            throw exception;
            exception2;
            Trace.traceEnd(8L);
            throw exception2;
_L4:
            view.draw(hardwarecanvas);
              goto _L6
            flag = false;
              goto _L7
        }

        void dumpGfxInfo(PrintWriter printwriter) {
            if(!mProfileEnabled) goto _L2; else goto _L1
_L1:
            int i;
            printwriter.printf("\n\tDraw\tProcess\tExecute\n", new Object[0]);
            mProfileLock.lock();
            i = 0;
_L5:
            if(i < mProfileData.length && mProfileData[i] >= 0.0F) goto _L4; else goto _L3
_L3:
            mProfileCurrentFrame = mProfileData.length;
            mProfileLock.unlock();
_L2:
            return;
_L4:
            Object aobj[] = new Object[3];
            aobj[0] = Float.valueOf(mProfileData[i]);
            aobj[1] = Float.valueOf(mProfileData[i + 1]);
            aobj[2] = Float.valueOf(mProfileData[i + 2]);
            printwriter.printf("\t%3.2f\t%3.2f\t%3.2f\n", aobj);
            float af[] = mProfileData;
            float af1[] = mProfileData;
            int j = i + 1;
            mProfileData[i + 2] = -1F;
            af1[j] = -1F;
            af[i] = -1F;
            i += 3;
              goto _L5
            Exception exception;
            exception;
            mProfileLock.unlock();
            throw exception;
        }

        HardwareCanvas getCanvas() {
            return mCanvas;
        }

        abstract int[] getConfig(boolean flag);

        long getFrameCount() {
            return mFrameCount;
        }

        int getHeight() {
            return mHeight;
        }

        int getWidth() {
            return mWidth;
        }

        boolean hasDirtyRegions() {
            return mDirtyRegionsEnabled;
        }

        abstract void initCaches();

        boolean initialize(SurfaceHolder surfaceholder) throws Surface.OutOfResourcesException {
            boolean flag = true;
            if(!isRequested() || isEnabled()) goto _L2; else goto _L1
_L1:
            initializeEgl();
            mGl = createEglSurface(surfaceholder);
            mDestroyed = false;
            if(mGl == null) goto _L2; else goto _L3
_L3:
            if(sEgl.eglGetError() != 12288) {
                destroy(flag);
                setRequested(false);
            } else {
                if(mCanvas == null)
                    mCanvas = createCanvas();
                if(mCanvas != null)
                    setEnabled(flag);
                else
                    Log.w("HardwareRenderer", "Hardware accelerated Canvas could not be created");
            }
            if(mCanvas == null)
                flag = false;
_L5:
            return flag;
_L2:
            flag = false;
            if(true) goto _L5; else goto _L4
_L4:
        }

        void initializeEgl() {
            Object aobj[] = sEglLock;
            aobj;
            JVM INSTR monitorenter ;
            if(sEgl != null || sEglConfig != null)
                break MISSING_BLOCK_LABEL_210;
            sEgl = (EGL10)EGLContext.getEGL();
            sEglDisplay = sEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if(sEglDisplay == EGL10.EGL_NO_DISPLAY)
                throw new RuntimeException((new StringBuilder()).append("eglGetDisplay failed ").append(GLUtils.getEGLErrorString(sEgl.eglGetError())).toString());
            break MISSING_BLOCK_LABEL_93;
            Exception exception;
            exception;
            throw exception;
            int ai[] = new int[2];
            if(!sEgl.eglInitialize(sEglDisplay, ai))
                throw new RuntimeException((new StringBuilder()).append("eglInitialize failed ").append(GLUtils.getEGLErrorString(sEgl.eglGetError())).toString());
            sEglConfig = chooseEglConfig();
            if(sEglConfig == null)
                if(sDirtyRegions) {
                    sDirtyRegions = false;
                    sEglConfig = chooseEglConfig();
                    if(sEglConfig == null)
                        throw new RuntimeException("eglConfig not initialized");
                } else {
                    throw new RuntimeException("eglConfig not initialized");
                }
            aobj;
            JVM INSTR monitorexit ;
            ManagedEGLContext managedeglcontext = (ManagedEGLContext)sEglContextStorage.get();
            EGLContext eglcontext;
            if(managedeglcontext != null)
                eglcontext = managedeglcontext.getContext();
            else
                eglcontext = null;
            mEglContext = eglcontext;
            mEglThread = Thread.currentThread();
            if(mEglContext == null) {
                mEglContext = createContext(sEgl, sEglDisplay, sEglConfig);
                sEglContextStorage.set(createManagedContext(mEglContext));
            }
            return;
        }

        void invalidate(SurfaceHolder surfaceholder) {
            sEgl.eglMakeCurrent(sEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            if(mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE) {
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
                setEnabled(false);
            }
            if(surfaceholder.getSurface().isValid() && createSurface(surfaceholder)) goto _L2; else goto _L1
_L1:
            return;
_L2:
            mUpdateDirtyRegions = true;
            if(mCanvas != null)
                setEnabled(true);
            if(true) goto _L1; else goto _L3
_L3:
        }

        void onPostDraw() {
        }

        int onPreDraw(Rect rect) {
            return 0;
        }

        void setup(int i, int j) {
            if(validate()) {
                mCanvas.setViewport(i, j);
                mWidth = i;
                mHeight = j;
            }
        }

        void updateSurface(SurfaceHolder surfaceholder) throws Surface.OutOfResourcesException {
            if(isRequested() && isEnabled())
                createEglSurface(surfaceholder);
        }

        boolean validate() {
            boolean flag;
            if(checkCurrent() != 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
        static final int EGL_OPENGL_ES2_BIT = 4;
        static final int EGL_SURFACE_TYPE = 12339;
        static final int EGL_SWAP_BEHAVIOR_PRESERVED_BIT = 1024;
        static final int FUNCTOR_PROCESS_DELAY = 4;
        static final int SURFACE_STATE_ERROR = 0;
        static final int SURFACE_STATE_SUCCESS = 1;
        static final int SURFACE_STATE_UPDATED = 2;
        static boolean sDirtyRegions;
        static final boolean sDirtyRegionsRequested;
        static EGL10 sEgl;
        static EGLConfig sEglConfig;
        static final ThreadLocal sEglContextStorage = new ThreadLocal();
        static EGLDisplay sEglDisplay;
        static final Object sEglLock[] = new Object[0];
        HardwareCanvas mCanvas;
        final boolean mDebugDirtyRegions = "true".equalsIgnoreCase(SystemProperties.get("debug.hwui.show_dirty_regions", "false"));
        Paint mDebugPaint;
        private boolean mDestroyed;
        boolean mDirtyRegionsEnabled;
        EGLContext mEglContext;
        EGLSurface mEglSurface;
        Thread mEglThread;
        long mFrameCount;
        private final FunctorsRunnable mFunctorsRunnable = new FunctorsRunnable();
        GL mGl;
        final int mGlVersion;
        int mHeight;
        int mProfileCurrentFrame;
        final float mProfileData[];
        final boolean mProfileEnabled = "true".equalsIgnoreCase(SystemProperties.get("debug.hwui.profile", "false"));
        final ReentrantLock mProfileLock;
        private final Rect mRedrawClip = new Rect();
        private final int mSurfaceSize[] = new int[2];
        final boolean mTranslucent;
        boolean mUpdateDirtyRegions;
        final boolean mVsyncDisabled = "true".equalsIgnoreCase(SystemProperties.get("debug.hwui.disable_vsync", "false"));
        int mWidth;

        static  {
            sDirtyRegions = "true".equalsIgnoreCase(SystemProperties.get("debug.hwui.render_dirty_regions", "true"));
            sDirtyRegionsRequested = sDirtyRegions;
        }



        GlRenderer(int i, boolean flag) {
            mWidth = -1;
            mHeight = -1;
            mProfileCurrentFrame = -3;
            mGlVersion = i;
            mTranslucent = flag;
            if(mVsyncDisabled)
                Log.d("HardwareRenderer", "Disabling v-sync");
            if(mProfileEnabled)
                Log.d("HardwareRenderer", "Profiling hardware renderer");
            if(mProfileEnabled) {
                mProfileData = new float[3 * Integer.valueOf(SystemProperties.get("debug.hwui.profile.maxframes", Integer.toString(128))).intValue()];
                for(int j = 0; j < mProfileData.length; j += 3) {
                    float af[] = mProfileData;
                    float af1[] = mProfileData;
                    int k = j + 1;
                    mProfileData[j + 2] = -1F;
                    af1[k] = -1F;
                    af[j] = -1F;
                }

                mProfileLock = new ReentrantLock();
            } else {
                mProfileData = null;
                mProfileLock = null;
            }
            if(mDebugDirtyRegions)
                Log.d("HardwareRenderer", "Debugging dirty regions");
        }
    }

    static interface HardwareDrawCallbacks {

        public abstract void onHardwarePostDraw(HardwareCanvas hardwarecanvas);

        public abstract void onHardwarePreDraw(HardwareCanvas hardwarecanvas);
    }


    public HardwareRenderer() {
        mRequested = true;
    }

    private static void beginFrame(int ai[]) {
        nBeginFrame(ai);
    }

    static HardwareRenderer createGlRenderer(int i, boolean flag) {
        switch(i) {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown GL version: ").append(i).toString());

        case 2: // '\002'
            return Gl20Renderer.create(flag);
        }
    }

    public static void disable(boolean flag) {
        sRendererDisabled = true;
        if(flag)
            sSystemRendererDisabled = true;
    }

    static void disableVsync() {
        nDisableVsync();
    }

    static void endTrimMemory() {
        Gl20Renderer.endTrimMemory();
    }

    public static boolean isAvailable() {
        return GLES20Canvas.isAvailable();
    }

    static boolean isBackBufferPreserved() {
        return nIsBackBufferPreserved();
    }

    private static native void nBeginFrame(int ai[]);

    private static native void nDisableVsync();

    private static native boolean nIsBackBufferPreserved();

    private static native boolean nPreserveBackBuffer();

    private static native void nSetupShadersDiskCache(String s);

    static boolean preserveBackBuffer() {
        return nPreserveBackBuffer();
    }

    public static void setupDiskCache(File file) {
        nSetupShadersDiskCache((new File(file, "com.android.opengl.shaders_cache")).getAbsolutePath());
    }

    static void startTrimMemory(int i) {
        Gl20Renderer.startTrimMemory(i);
    }

    static void trimMemory(int i) {
        startTrimMemory(i);
        endTrimMemory();
    }

    abstract boolean attachFunctor(View.AttachInfo attachinfo, int i);

    public abstract DisplayList createDisplayList(String s);

    abstract HardwareLayer createHardwareLayer(int i, int j, boolean flag);

    abstract HardwareLayer createHardwareLayer(boolean flag);

    abstract SurfaceTexture createSurfaceTexture(HardwareLayer hardwarelayer);

    abstract void destroy(boolean flag);

    abstract void destroyHardwareResources(View view);

    abstract void destroyLayers(View view);

    abstract void detachFunctor(int i);

    abstract boolean draw(View view, View.AttachInfo attachinfo, HardwareDrawCallbacks hardwaredrawcallbacks, Rect rect);

    abstract void dumpGfxInfo(PrintWriter printwriter);

    abstract HardwareCanvas getCanvas();

    abstract long getFrameCount();

    abstract int getHeight();

    abstract int getWidth();

    abstract boolean initialize(SurfaceHolder surfaceholder) throws Surface.OutOfResourcesException;

    void initializeIfNeeded(int i, int j, SurfaceHolder surfaceholder) throws Surface.OutOfResourcesException {
        if(isRequested() && !isEnabled() && initialize(surfaceholder))
            setup(i, j);
    }

    abstract void invalidate(SurfaceHolder surfaceholder);

    boolean isEnabled() {
        return mEnabled;
    }

    boolean isRequested() {
        return mRequested;
    }

    abstract boolean safelyRun(Runnable runnable);

    void setEnabled(boolean flag) {
        mEnabled = flag;
    }

    void setRequested(boolean flag) {
        mRequested = flag;
    }

    abstract void setSurfaceTexture(HardwareLayer hardwarelayer, SurfaceTexture surfacetexture);

    abstract void setup(int i, int j);

    abstract void updateSurface(SurfaceHolder surfaceholder) throws Surface.OutOfResourcesException;

    abstract boolean validate();

    private static final String CACHE_PATH_SHADERS = "com.android.opengl.shaders_cache";
    public static final String DEBUG_DIRTY_REGIONS_PROPERTY = "debug.hwui.show_dirty_regions";
    static final String DISABLE_VSYNC_PROPERTY = "debug.hwui.disable_vsync";
    static final String LOG_TAG = "HardwareRenderer";
    static final String PRINT_CONFIG_PROPERTY = "debug.hwui.print_config";
    private static final int PROFILE_FRAME_DATA_COUNT = 3;
    static final String PROFILE_MAXFRAMES_PROPERTY = "debug.hwui.profile.maxframes";
    private static final int PROFILE_MAX_FRAMES = 128;
    public static final String PROFILE_PROPERTY = "debug.hwui.profile";
    public static final boolean RENDER_DIRTY_REGIONS = true;
    static final String RENDER_DIRTY_REGIONS_PROPERTY = "debug.hwui.render_dirty_regions";
    public static boolean sRendererDisabled = false;
    public static boolean sSystemRendererDisabled = false;
    private boolean mEnabled;
    private boolean mRequested;


}
