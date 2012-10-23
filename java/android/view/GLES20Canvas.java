// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.*;
import android.text.*;

// Referenced classes of package android.view:
//            HardwareCanvas, GLES20DisplayList, GLES20Layer, DisplayList, 
//            HardwareLayer

class GLES20Canvas extends HardwareCanvas {
    private static final class CanvasFinalizer {

        protected void finalize() throws Throwable {
            GLES20Canvas.nDestroyRenderer(mRenderer);
            super.finalize();
            return;
            Exception exception;
            exception;
            super.finalize();
            throw exception;
        }

        private final int mRenderer;

        public CanvasFinalizer(int i) {
            mRenderer = i;
        }
    }


    GLES20Canvas(int i, boolean flag) {
        mPoint = new float[2];
        mLine = new float[4];
        mClipBounds = new Rect();
        mPathBounds = new RectF();
        boolean flag1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        mOpaque = flag1;
        mRenderer = nCreateLayerRenderer(i);
        setupFinalizer();
    }

    GLES20Canvas(boolean flag) {
        this(false, flag);
    }

    protected GLES20Canvas(boolean flag, boolean flag1) {
        mPoint = new float[2];
        mLine = new float[4];
        mClipBounds = new Rect();
        mPathBounds = new RectF();
        boolean flag2;
        if(!flag1)
            flag2 = true;
        else
            flag2 = false;
        mOpaque = flag2;
        if(flag)
            mRenderer = nCreateDisplayListRenderer();
        else
            mRenderer = nCreateRenderer();
        setupFinalizer();
    }

    static void destroyDisplayList(int i) {
        nDestroyDisplayList(i);
    }

    public static void flushCaches(int i) {
        nFlushCaches(i);
    }

    static int getDisplayListSize(int i) {
        return nGetDisplayListSize(i);
    }

    public static int getStencilSize() {
        return nGetStencilSize();
    }

    public static void initCaches() {
        nInitCaches();
    }

    static boolean isAvailable() {
        return sIsAvailable;
    }

    private static native void nAttachFunctor(int i, int j);

    private static native int nCallDrawGLFunction(int i, int j);

    private static native boolean nClipRect(int i, float f, float f1, float f2, float f3, int j);

    private static native boolean nClipRect(int i, int j, int k, int l, int i1, int j1);

    private static native void nConcatMatrix(int i, int j);

    static native boolean nCopyLayer(int i, int j);

    private static native int nCreateDisplayListRenderer();

    static native int nCreateLayer(int i, int j, boolean flag, int ai[]);

    private static native int nCreateLayerRenderer(int i);

    private static native int nCreateRenderer();

    static native int nCreateTextureLayer(boolean flag, int ai[]);

    private static native void nDestroyDisplayList(int i);

    static native void nDestroyLayer(int i);

    static native void nDestroyLayerDeferred(int i);

    private static native void nDestroyRenderer(int i);

    private static native void nDetachFunctor(int i, int j);

    private static native void nDrawArc(int i, float f, float f1, float f2, float f3, float f4, float f5, boolean flag, 
            int j);

    private static native void nDrawBitmap(int i, int j, byte abyte0[], float f, float f1, float f2, float f3, float f4, 
            float f5, float f6, float f7, int k);

    private static native void nDrawBitmap(int i, int j, byte abyte0[], float f, float f1, int k);

    private static native void nDrawBitmap(int i, int j, byte abyte0[], int k, int l);

    private static native void nDrawBitmap(int i, int ai[], int j, int k, float f, float f1, int l, int i1, 
            boolean flag, int j1);

    private static native void nDrawBitmapMesh(int i, int j, byte abyte0[], int k, int l, float af[], int i1, int ai[], 
            int j1, int k1);

    private static native void nDrawCircle(int i, float f, float f1, float f2, int j);

    private static native void nDrawColor(int i, int j, int k);

    private static native int nDrawDisplayList(int i, int j, Rect rect, int k);

    private static native void nDrawLayer(int i, int j, float f, float f1, int k);

    private static native void nDrawLines(int i, float af[], int j, int k, int l);

    private static native void nDrawOval(int i, float f, float f1, float f2, float f3, int j);

    private static native void nDrawPatch(int i, int j, byte abyte0[], byte abyte1[], float f, float f1, float f2, float f3, 
            int k);

    private static native void nDrawPath(int i, int j, int k);

    private static native void nDrawPoints(int i, float af[], int j, int k, int l);

    private static native void nDrawPosText(int i, String s, int j, int k, float af[], int l);

    private static native void nDrawPosText(int i, char ac[], int j, int k, float af[], int l);

    private static native void nDrawRect(int i, float f, float f1, float f2, float f3, int j);

    private static native void nDrawRects(int i, int j, int k);

    private static native void nDrawRoundRect(int i, float f, float f1, float f2, float f3, float f4, float f5, int j);

    private static native void nDrawText(int i, String s, int j, int k, float f, float f1, int l, int i1);

    private static native void nDrawText(int i, char ac[], int j, int k, float f, float f1, int l, int i1);

    private static native void nDrawTextOnPath(int i, String s, int j, int k, int l, float f, float f1, int i1, 
            int j1);

    private static native void nDrawTextOnPath(int i, char ac[], int j, int k, int l, float f, float f1, int i1, 
            int j1);

    private static native void nDrawTextRun(int i, String s, int j, int k, int l, int i1, float f, float f1, 
            int j1, int k1);

    private static native void nDrawTextRun(int i, char ac[], int j, int k, int l, int i1, float f, float f1, 
            int j1, int k1);

    private static native void nFinish(int i);

    private static native void nFlushCaches(int i);

    static native void nFlushLayer(int i);

    private static native boolean nGetClipBounds(int i, Rect rect);

    private static native int nGetDisplayList(int i, int j);

    private static native int nGetDisplayListSize(int i);

    private static native void nGetMatrix(int i, int j);

    private static native int nGetMaximumTextureHeight();

    private static native int nGetMaximumTextureWidth();

    private static native int nGetSaveCount(int i);

    private static native int nGetStencilSize();

    private static native void nInitCaches();

    private static native void nInterrupt(int i);

    private static native int nInvokeFunctors(int i, Rect rect);

    private static native boolean nIsAvailable();

    private static native void nOutputDisplayList(int i, int j);

    private static native int nPrepare(int i, boolean flag);

    private static native int nPrepareDirty(int i, int j, int k, int l, int i1, boolean flag);

    private static native boolean nQuickReject(int i, float f, float f1, float f2, float f3, int j);

    private static native void nResetDisplayListRenderer(int i);

    private static native void nResetModifiers(int i, int j);

    private static native void nResetPaintFilter(int i);

    static native void nResizeLayer(int i, int j, int k, int ai[]);

    private static native void nRestore(int i);

    private static native void nRestoreToCount(int i, int j);

    private static native void nResume(int i);

    private static native void nRotate(int i, float f);

    private static native int nSave(int i, int j);

    private static native int nSaveLayer(int i, float f, float f1, float f2, float f3, int j, int k);

    private static native int nSaveLayer(int i, int j, int k);

    private static native int nSaveLayerAlpha(int i, float f, float f1, float f2, float f3, int j, int k);

    private static native int nSaveLayerAlpha(int i, int j, int k);

    private static native void nScale(int i, float f, float f1);

    private static native void nSetDisplayListName(int i, String s);

    private static native void nSetMatrix(int i, int j);

    static native void nSetTextureLayerTransform(int i, int j);

    private static native void nSetViewport(int i, int j, int k);

    private static native void nSetupColorFilter(int i, int j);

    private static native void nSetupPaintFilter(int i, int j, int k);

    private static native void nSetupShader(int i, int j);

    private static native void nSetupShadow(int i, float f, float f1, float f2, int j);

    private static native void nSkew(int i, float f, float f1);

    private static native void nTerminateCaches();

    private static native void nTranslate(int i, float f, float f1);

    static native void nUpdateRenderLayer(int i, int j, int k, int l, int i1, int j1, int k1);

    static native void nUpdateTextureLayer(int i, int j, int k, boolean flag, SurfaceTexture surfacetexture);

    static void setDisplayListName(int i, String s) {
        nSetDisplayListName(i, s);
    }

    private int setupColorFilter(Paint paint) {
        ColorFilter colorfilter = paint.getColorFilter();
        byte byte0;
        if(colorfilter != null) {
            nSetupColorFilter(mRenderer, colorfilter.nativeColorFilter);
            byte0 = 4;
        } else {
            byte0 = 0;
        }
        return byte0;
    }

    private void setupFinalizer() {
        if(mRenderer == 0) {
            throw new IllegalStateException("Could not create GLES20Canvas renderer");
        } else {
            mFinalizer = new CanvasFinalizer(mRenderer);
            return;
        }
    }

    private int setupModifiers(Bitmap bitmap, Paint paint) {
        int i;
        if(bitmap.getConfig() != android.graphics.Bitmap.Config.ALPHA_8) {
            ColorFilter colorfilter = paint.getColorFilter();
            if(colorfilter != null) {
                nSetupColorFilter(mRenderer, colorfilter.nativeColorFilter);
                i = 4;
            } else {
                i = 0;
            }
        } else {
            i = setupModifiers(paint);
        }
        return i;
    }

    private int setupModifiers(Paint paint) {
        int i = 0;
        if(paint.hasShadow) {
            nSetupShadow(mRenderer, paint.shadowRadius, paint.shadowDx, paint.shadowDy, paint.shadowColor);
            i = false | true;
        }
        Shader shader = paint.getShader();
        if(shader != null) {
            nSetupShader(mRenderer, shader.native_shader);
            i |= 2;
        }
        ColorFilter colorfilter = paint.getColorFilter();
        if(colorfilter != null) {
            nSetupColorFilter(mRenderer, colorfilter.nativeColorFilter);
            i |= 4;
        }
        return i;
    }

    private int setupModifiers(Paint paint, int i) {
        int j = 0;
        if(paint.hasShadow && (i & 1) != 0) {
            nSetupShadow(mRenderer, paint.shadowRadius, paint.shadowDx, paint.shadowDy, paint.shadowColor);
            j = false | true;
        }
        Shader shader = paint.getShader();
        if(shader != null && (i & 2) != 0) {
            nSetupShader(mRenderer, shader.native_shader);
            j |= 2;
        }
        ColorFilter colorfilter = paint.getColorFilter();
        if(colorfilter != null && (i & 4) != 0) {
            nSetupColorFilter(mRenderer, colorfilter.nativeColorFilter);
            j |= 4;
        }
        return j;
    }

    public static void terminateCaches() {
        nTerminateCaches();
    }

    public void attachFunctor(int i) {
        nAttachFunctor(mRenderer, i);
    }

    public int callDrawGLFunction(int i) {
        return nCallDrawGLFunction(mRenderer, i);
    }

    public boolean clipPath(Path path) {
        path.computeBounds(mPathBounds, true);
        return nClipRect(mRenderer, mPathBounds.left, mPathBounds.top, mPathBounds.right, mPathBounds.bottom, android.graphics.Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipPath(Path path, android.graphics.Region.Op op) {
        path.computeBounds(mPathBounds, true);
        return nClipRect(mRenderer, mPathBounds.left, mPathBounds.top, mPathBounds.right, mPathBounds.bottom, op.nativeInt);
    }

    public boolean clipRect(float f, float f1, float f2, float f3) {
        return nClipRect(mRenderer, f, f1, f2, f3, android.graphics.Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRect(float f, float f1, float f2, float f3, android.graphics.Region.Op op) {
        return nClipRect(mRenderer, f, f1, f2, f3, op.nativeInt);
    }

    public boolean clipRect(int i, int j, int k, int l) {
        return nClipRect(mRenderer, i, j, k, l, android.graphics.Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRect(Rect rect) {
        return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, android.graphics.Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRect(Rect rect, android.graphics.Region.Op op) {
        return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    public boolean clipRect(RectF rectf) {
        return nClipRect(mRenderer, rectf.left, rectf.top, rectf.right, rectf.bottom, android.graphics.Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRect(RectF rectf, android.graphics.Region.Op op) {
        return nClipRect(mRenderer, rectf.left, rectf.top, rectf.right, rectf.bottom, op.nativeInt);
    }

    public boolean clipRegion(Region region) {
        region.getBounds(mClipBounds);
        return nClipRect(mRenderer, mClipBounds.left, mClipBounds.top, mClipBounds.right, mClipBounds.bottom, android.graphics.Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRegion(Region region, android.graphics.Region.Op op) {
        region.getBounds(mClipBounds);
        return nClipRect(mRenderer, mClipBounds.left, mClipBounds.top, mClipBounds.right, mClipBounds.bottom, op.nativeInt);
    }

    public void concat(Matrix matrix) {
        nConcatMatrix(mRenderer, matrix.native_instance);
    }

    public void detachFunctor(int i) {
        nDetachFunctor(mRenderer, i);
    }

    public void drawARGB(int i, int j, int k, int l) {
        drawColor((i & 0xff) << 24 | (j & 0xff) << 16 | (k & 0xff) << 8 | l & 0xff);
    }

    public void drawArc(RectF rectf, float f, float f1, boolean flag, Paint paint) {
        int i = setupModifiers(paint, 6);
        nDrawArc(mRenderer, rectf.left, rectf.top, rectf.right, rectf.bottom, f, f1, flag, paint.mNativePaint);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawBitmap(Bitmap bitmap, float f, float f1, Paint paint) {
        int i;
        int j;
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("Cannot draw recycled bitmaps");
        if(paint != null)
            i = setupModifiers(bitmap, paint);
        else
            i = 0;
        if(paint != null)
            break MISSING_BLOCK_LABEL_80;
        j = 0;
_L1:
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, f, f1, j);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        j = paint.mNativePaint;
          goto _L1
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        int i;
        int j;
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("Cannot draw recycled bitmaps");
        if(paint != null)
            i = setupModifiers(bitmap, paint);
        else
            i = 0;
        if(paint != null)
            break MISSING_BLOCK_LABEL_79;
        j = 0;
_L1:
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, matrix.native_instance, j);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        j = paint.mNativePaint;
          goto _L1
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect1, Paint paint) {
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("Cannot draw recycled bitmaps");
        if(paint != null)
            i = setupModifiers(bitmap, paint);
        else
            i = 0;
        if(paint != null) goto _L2; else goto _L1
_L1:
        j = 0;
_L7:
        if(rect != null) goto _L4; else goto _L3
_L3:
        i1 = 0;
        k = 0;
        l = bitmap.getWidth();
        j1 = bitmap.getHeight();
_L5:
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, k, i1, l, j1, rect1.left, rect1.top, rect1.right, rect1.bottom, j);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
_L2:
        j = paint.mNativePaint;
        continue; /* Loop/switch isn't completed */
_L4:
        k = rect.left;
        l = rect.right;
        i1 = rect.top;
        j1 = rect.bottom;
          goto _L5
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectf, Paint paint) {
        int i;
        int j;
        float f;
        float f1;
        float f2;
        float f3;
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("Cannot draw recycled bitmaps");
        if(paint != null)
            i = setupModifiers(bitmap, paint);
        else
            i = 0;
        if(paint != null) goto _L2; else goto _L1
_L1:
        j = 0;
_L7:
        if(rect != null) goto _L4; else goto _L3
_L3:
        f2 = 0.0F;
        f = 0.0F;
        f1 = bitmap.getWidth();
        f3 = bitmap.getHeight();
_L5:
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, f, f2, f1, f3, rectf.left, rectf.top, rectf.right, rectf.bottom, j);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
_L2:
        j = paint.mNativePaint;
        continue; /* Loop/switch isn't completed */
_L4:
        int k;
        f = rect.left;
        f1 = rect.right;
        f2 = rect.top;
        k = rect.bottom;
        f3 = k;
          goto _L5
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public void drawBitmap(int ai[], int i, int j, float f, float f1, int k, int l, 
            boolean flag, Paint paint) {
        int k1;
        int l1;
        if(k < 0)
            throw new IllegalArgumentException("width must be >= 0");
        if(l < 0)
            throw new IllegalArgumentException("height must be >= 0");
        if(Math.abs(j) < k)
            throw new IllegalArgumentException("abs(stride) must be >= width");
        int i1 = i + j * (l - 1);
        int j1 = ai.length;
        if(i < 0 || i + k > j1 || i1 < 0 || i1 + k > j1)
            throw new ArrayIndexOutOfBoundsException();
        if(paint != null)
            k1 = setupColorFilter(paint);
        else
            k1 = 0;
        if(paint != null)
            break MISSING_BLOCK_LABEL_166;
        l1 = 0;
_L1:
        nDrawBitmap(mRenderer, ai, i, j, f, f1, k, l, flag, l1);
        if(k1 != 0)
            nResetModifiers(mRenderer, k1);
        return;
        l1 = paint.mNativePaint;
          goto _L1
        Exception exception;
        exception;
        if(k1 != 0)
            nResetModifiers(mRenderer, k1);
        throw exception;
    }

    public void drawBitmap(int ai[], int i, int j, int k, int l, int i1, int j1, 
            boolean flag, Paint paint) {
        drawBitmap(ai, i, j, k, l, i1, j1, flag, paint);
    }

    public void drawBitmapMesh(Bitmap bitmap, int i, int j, float af[], int k, int ai[], int l, 
            Paint paint) {
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("Cannot draw recycled bitmaps");
        if(i < 0 || j < 0 || k < 0 || l < 0)
            throw new ArrayIndexOutOfBoundsException();
        if(i != 0 && j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j1;
        int k1;
        int i1 = (i + 1) * (j + 1);
        checkRange(af.length, k, i1 * 2);
        if(paint != null)
            j1 = setupModifiers(bitmap, paint);
        else
            j1 = 0;
        if(paint != null)
            break MISSING_BLOCK_LABEL_144;
        k1 = 0;
_L3:
        nDrawBitmapMesh(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, i, j, af, k, null, 0, k1);
        if(j1 != 0)
            nResetModifiers(mRenderer, j1);
        continue; /* Loop/switch isn't completed */
        k1 = paint.mNativePaint;
          goto _L3
        Exception exception;
        exception;
        if(j1 != 0)
            nResetModifiers(mRenderer, j1);
        throw exception;
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void drawCircle(float f, float f1, float f2, Paint paint) {
        int i = setupModifiers(paint, 6);
        nDrawCircle(mRenderer, f, f1, f2, paint.mNativePaint);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawColor(int i) {
        drawColor(i, android.graphics.PorterDuff.Mode.SRC_OVER);
    }

    public void drawColor(int i, android.graphics.PorterDuff.Mode mode) {
        nDrawColor(mRenderer, i, mode.nativeInt);
    }

    public int drawDisplayList(DisplayList displaylist, Rect rect, int i) {
        return nDrawDisplayList(mRenderer, ((GLES20DisplayList)displaylist).getNativeDisplayList(), rect, i);
    }

    void drawHardwareLayer(HardwareLayer hardwarelayer, float f, float f1, Paint paint) {
        int i;
        int j;
        GLES20Layer gles20layer = (GLES20Layer)hardwarelayer;
        if(paint != null)
            i = setupColorFilter(paint);
        else
            i = 0;
        if(paint != null)
            break MISSING_BLOCK_LABEL_64;
        j = 0;
_L1:
        nDrawLayer(mRenderer, gles20layer.getLayer(), f, f1, j);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        j = paint.mNativePaint;
          goto _L1
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawLine(float f, float f1, float f2, float f3, Paint paint) {
        mLine[0] = f;
        mLine[1] = f1;
        mLine[2] = f2;
        mLine[3] = f3;
        drawLines(mLine, 0, 4, paint);
    }

    public void drawLines(float af[], int i, int j, Paint paint) {
        int k;
        if((i | j) < 0 || i + j > af.length)
            throw new IllegalArgumentException("The lines array must contain 4 elements per line.");
        k = setupModifiers(paint, 6);
        nDrawLines(mRenderer, af, i, j, paint.mNativePaint);
        if(k != 0)
            nResetModifiers(mRenderer, k);
        return;
        Exception exception;
        exception;
        if(k != 0)
            nResetModifiers(mRenderer, k);
        throw exception;
    }

    public void drawLines(float af[], Paint paint) {
        drawLines(af, 0, af.length, paint);
    }

    public void drawOval(RectF rectf, Paint paint) {
        int i = setupModifiers(paint, 6);
        nDrawOval(mRenderer, rectf.left, rectf.top, rectf.right, rectf.bottom, paint.mNativePaint);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawPaint(Paint paint) {
        Rect rect = mClipBounds;
        nGetClipBounds(mRenderer, rect);
        drawRect(rect.left, rect.top, rect.right, rect.bottom, paint);
    }

    public void drawPatch(Bitmap bitmap, byte abyte0[], RectF rectf, Paint paint) {
        int i;
        int j;
        if(bitmap.isRecycled())
            throw new IllegalArgumentException("Cannot draw recycled bitmaps");
        if(paint != null)
            i = setupColorFilter(paint);
        else
            i = 0;
        if(paint != null)
            break MISSING_BLOCK_LABEL_94;
        j = 0;
_L1:
        nDrawPatch(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, abyte0, rectf.left, rectf.top, rectf.right, rectf.bottom, j);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        j = paint.mNativePaint;
          goto _L1
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawPath(Path path, Paint paint) {
        int i = setupModifiers(paint, 6);
        if(!path.isSimplePath) goto _L2; else goto _L1
_L1:
        if(path.rects != null)
            nDrawRects(mRenderer, path.rects.mNativeRegion, paint.mNativePaint);
_L4:
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
_L2:
        nDrawPath(mRenderer, path.mNativePath, paint.mNativePaint);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawPicture(Picture picture) {
        if(!picture.createdFromStream)
            picture.endRecording();
    }

    public void drawPicture(Picture picture, Rect rect) {
        if(!picture.createdFromStream) {
            save();
            translate(rect.left, rect.top);
            if(picture.getWidth() > 0 && picture.getHeight() > 0)
                scale(rect.width() / picture.getWidth(), rect.height() / picture.getHeight());
            drawPicture(picture);
            restore();
        }
    }

    public void drawPicture(Picture picture, RectF rectf) {
        if(!picture.createdFromStream) {
            save();
            translate(rectf.left, rectf.top);
            if(picture.getWidth() > 0 && picture.getHeight() > 0)
                scale(rectf.width() / (float)picture.getWidth(), rectf.height() / (float)picture.getHeight());
            drawPicture(picture);
            restore();
        }
    }

    public void drawPoint(float f, float f1, Paint paint) {
        mPoint[0] = f;
        mPoint[1] = f1;
        drawPoints(mPoint, 0, 2, paint);
    }

    public void drawPoints(float af[], int i, int j, Paint paint) {
        int k = setupModifiers(paint, 6);
        nDrawPoints(mRenderer, af, i, j, paint.mNativePaint);
        if(k != 0)
            nResetModifiers(mRenderer, k);
        return;
        Exception exception;
        exception;
        if(k != 0)
            nResetModifiers(mRenderer, k);
        throw exception;
    }

    public void drawPoints(float af[], Paint paint) {
        drawPoints(af, 0, af.length, paint);
    }

    public void drawPosText(String s, float af[], Paint paint) {
        int i;
        if(2 * s.length() > af.length)
            throw new ArrayIndexOutOfBoundsException();
        i = setupModifiers(paint);
        nDrawPosText(mRenderer, s, 0, s.length(), af, paint.mNativePaint);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawPosText(char ac[], int i, int j, float af[], Paint paint) {
        int k;
        if(i < 0 || i + j > ac.length || j * 2 > af.length)
            throw new IndexOutOfBoundsException();
        k = setupModifiers(paint);
        nDrawPosText(mRenderer, ac, i, j, af, paint.mNativePaint);
        if(k != 0)
            nResetModifiers(mRenderer, k);
        return;
        Exception exception;
        exception;
        if(k != 0)
            nResetModifiers(mRenderer, k);
        throw exception;
    }

    public void drawRGB(int i, int j, int k) {
        drawColor(0xff000000 | (i & 0xff) << 16 | (j & 0xff) << 8 | k & 0xff);
    }

    public void drawRect(float f, float f1, float f2, float f3, Paint paint) {
        if(f != f2 && f1 != f3) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = setupModifiers(paint, 6);
        nDrawRect(mRenderer, f, f1, f2, f3, paint.mNativePaint);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawRect(Rect rect, Paint paint) {
        drawRect(rect.left, rect.top, rect.right, rect.bottom, paint);
    }

    public void drawRect(RectF rectf, Paint paint) {
        drawRect(rectf.left, rectf.top, rectf.right, rectf.bottom, paint);
    }

    public void drawRoundRect(RectF rectf, float f, float f1, Paint paint) {
        int i = setupModifiers(paint, 6);
        nDrawRoundRect(mRenderer, rectf.left, rectf.top, rectf.right, rectf.bottom, f, f1, paint.mNativePaint);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawText(CharSequence charsequence, int i, int j, float f, float f1, Paint paint) {
        int k = setupModifiers(paint);
        if(!(charsequence instanceof String) && !(charsequence instanceof SpannedString) && !(charsequence instanceof SpannableString)) goto _L2; else goto _L1
_L1:
        nDrawText(mRenderer, charsequence.toString(), i, j, f, f1, paint.mBidiFlags, paint.mNativePaint);
_L3:
        if(k != 0)
            nResetModifiers(mRenderer, k);
        return;
_L2:
        if(!(charsequence instanceof GraphicsOperations))
            break MISSING_BLOCK_LABEL_118;
        ((GraphicsOperations)charsequence).drawText(this, i, j, f, f1, paint);
          goto _L3
        Exception exception;
        exception;
        if(k != 0)
            nResetModifiers(mRenderer, k);
        throw exception;
        int l = j - i;
        char ac[] = TemporaryBuffer.obtain(l);
        TextUtils.getChars(charsequence, i, j, ac, 0);
        nDrawText(mRenderer, ac, 0, j - i, f, f1, paint.mBidiFlags, paint.mNativePaint);
        TemporaryBuffer.recycle(ac);
          goto _L3
    }

    public void drawText(String s, float f, float f1, Paint paint) {
        int i = setupModifiers(paint);
        nDrawText(mRenderer, s, 0, s.length(), f, f1, paint.mBidiFlags, paint.mNativePaint);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        return;
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawText(String s, int i, int j, float f, float f1, Paint paint) {
        int k;
        if((i | j | j - i | s.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        k = setupModifiers(paint);
        nDrawText(mRenderer, s, i, j, f, f1, paint.mBidiFlags, paint.mNativePaint);
        if(k != 0)
            nResetModifiers(mRenderer, k);
        return;
        Exception exception;
        exception;
        if(k != 0)
            nResetModifiers(mRenderer, k);
        throw exception;
    }

    public void drawText(char ac[], int i, int j, float f, float f1, Paint paint) {
        int k;
        if((i | j | i + j | ac.length - i - j) < 0)
            throw new IndexOutOfBoundsException();
        k = setupModifiers(paint);
        nDrawText(mRenderer, ac, i, j, f, f1, paint.mBidiFlags, paint.mNativePaint);
        if(k != 0)
            nResetModifiers(mRenderer, k);
        return;
        Exception exception;
        exception;
        if(k != 0)
            nResetModifiers(mRenderer, k);
        throw exception;
    }

    public void drawTextOnPath(String s, Path path, float f, float f1, Paint paint) {
        if(s.length() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = setupModifiers(paint);
        nDrawTextOnPath(mRenderer, s, 0, s.length(), path.mNativePath, f, f1, paint.mBidiFlags, paint.mNativePaint);
        if(i != 0)
            nResetModifiers(mRenderer, i);
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        if(i != 0)
            nResetModifiers(mRenderer, i);
        throw exception;
    }

    public void drawTextOnPath(char ac[], int i, int j, Path path, float f, float f1, Paint paint) {
        int k;
        if(i < 0 || i + j > ac.length)
            throw new ArrayIndexOutOfBoundsException();
        k = setupModifiers(paint);
        nDrawTextOnPath(mRenderer, ac, i, j, path.mNativePath, f, f1, paint.mBidiFlags, paint.mNativePaint);
        if(k != 0)
            nResetModifiers(mRenderer, k);
        return;
        Exception exception;
        exception;
        if(k != 0)
            nResetModifiers(mRenderer, k);
        throw exception;
    }

    public void drawTextRun(CharSequence charsequence, int i, int j, int k, int l, float f, float f1, 
            int i1, Paint paint) {
        int j1;
        int k1;
        if((i | j | j - i | charsequence.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        j1 = setupModifiers(paint);
        if(i1 == 0)
            k1 = 0;
        else
            k1 = 1;
        if(!(charsequence instanceof String) && !(charsequence instanceof SpannedString) && !(charsequence instanceof SpannableString)) goto _L2; else goto _L1
_L1:
        nDrawTextRun(mRenderer, charsequence.toString(), i, j, k, l, f, f1, k1, paint.mNativePaint);
_L3:
        if(j1 != 0)
            nResetModifiers(mRenderer, j1);
        return;
_L2:
        if(!(charsequence instanceof GraphicsOperations))
            break MISSING_BLOCK_LABEL_166;
        ((GraphicsOperations)charsequence).drawTextRun(this, i, j, k, l, f, f1, k1, paint);
          goto _L3
        Exception exception;
        exception;
        if(j1 != 0)
            nResetModifiers(mRenderer, j1);
        throw exception;
        int l1;
        int i2;
        l1 = l - k;
        i2 = j - i;
        char ac[] = TemporaryBuffer.obtain(l1);
        TextUtils.getChars(charsequence, k, l, ac, 0);
        nDrawTextRun(mRenderer, ac, i - k, i2, 0, l1, f, f1, k1, paint.mNativePaint);
        TemporaryBuffer.recycle(ac);
          goto _L3
    }

    public void drawTextRun(char ac[], int i, int j, int k, int l, float f, float f1, 
            int i1, Paint paint) {
        int j1;
        if((i | j | ac.length - i - j) < 0)
            throw new IndexOutOfBoundsException();
        if(i1 != 0 && i1 != 1)
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown direction: ").append(i1).toString());
        j1 = setupModifiers(paint);
        nDrawTextRun(mRenderer, ac, i, j, k, l, f, f1, i1, paint.mNativePaint);
        if(j1 != 0)
            nResetModifiers(mRenderer, j1);
        return;
        Exception exception;
        exception;
        if(j1 != 0)
            nResetModifiers(mRenderer, j1);
        throw exception;
    }

    public void drawVertices(android.graphics.Canvas.VertexMode vertexmode, int i, float af[], int j, float af1[], int k, int ai[], 
            int l, short aword0[], int i1, int j1, Paint paint) {
    }

    public boolean getClipBounds(Rect rect) {
        return nGetClipBounds(mRenderer, rect);
    }

    int getDisplayList(int i) {
        return nGetDisplayList(mRenderer, i);
    }

    public DrawFilter getDrawFilter() {
        return mFilter;
    }

    public int getHeight() {
        return mHeight;
    }

    public void getMatrix(Matrix matrix) {
        nGetMatrix(mRenderer, matrix.native_instance);
    }

    public int getMaximumBitmapHeight() {
        return nGetMaximumTextureHeight();
    }

    public int getMaximumBitmapWidth() {
        return nGetMaximumTextureWidth();
    }

    int getRenderer() {
        return mRenderer;
    }

    public int getSaveCount() {
        return nGetSaveCount(mRenderer);
    }

    public int getWidth() {
        return mWidth;
    }

    void interrupt() {
        nInterrupt(mRenderer);
    }

    public int invokeFunctors(Rect rect) {
        return nInvokeFunctors(mRenderer, rect);
    }

    public boolean isOpaque() {
        return mOpaque;
    }

    public void onPostDraw() {
        nFinish(mRenderer);
    }

    public int onPreDraw(Rect rect) {
        int i;
        if(rect != null)
            i = nPrepareDirty(mRenderer, rect.left, rect.top, rect.right, rect.bottom, mOpaque);
        else
            i = nPrepare(mRenderer, mOpaque);
        return i;
    }

    void outputDisplayList(DisplayList displaylist) {
        nOutputDisplayList(mRenderer, ((GLES20DisplayList)displaylist).getNativeDisplayList());
    }

    public boolean quickReject(float f, float f1, float f2, float f3, android.graphics.Canvas.EdgeType edgetype) {
        return nQuickReject(mRenderer, f, f1, f2, f3, edgetype.nativeInt);
    }

    public boolean quickReject(Path path, android.graphics.Canvas.EdgeType edgetype) {
        path.computeBounds(mPathBounds, true);
        return nQuickReject(mRenderer, mPathBounds.left, mPathBounds.top, mPathBounds.right, mPathBounds.bottom, edgetype.nativeInt);
    }

    public boolean quickReject(RectF rectf, android.graphics.Canvas.EdgeType edgetype) {
        return nQuickReject(mRenderer, rectf.left, rectf.top, rectf.right, rectf.bottom, edgetype.nativeInt);
    }

    protected void resetDisplayListRenderer() {
        nResetDisplayListRenderer(mRenderer);
    }

    public void restore() {
        nRestore(mRenderer);
    }

    public void restoreToCount(int i) {
        nRestoreToCount(mRenderer, i);
    }

    void resume() {
        nResume(mRenderer);
    }

    public void rotate(float f) {
        nRotate(mRenderer, f);
    }

    public int save() {
        return nSave(mRenderer, 3);
    }

    public int save(int i) {
        return nSave(mRenderer, i);
    }

    public int saveLayer(float f, float f1, float f2, float f3, Paint paint, int i) {
        int j;
        int k;
        int l;
        if(f >= f2 || f1 >= f3)
            break MISSING_BLOCK_LABEL_108;
        int i1;
        if(paint != null)
            k = setupColorFilter(paint);
        else
            k = 0;
        if(paint != null) goto _L2; else goto _L1
_L1:
        l = 0;
_L3:
        i1 = nSaveLayer(mRenderer, f, f1, f2, f3, l, i);
        j = i1;
        if(k != 0)
            nResetModifiers(mRenderer, k);
_L4:
        return j;
_L2:
        l = paint.mNativePaint;
          goto _L3
        Exception exception;
        exception;
        if(k != 0)
            nResetModifiers(mRenderer, k);
        throw exception;
        j = save(i);
          goto _L4
    }

    public int saveLayer(RectF rectf, Paint paint, int i) {
        if(rectf == null) goto _L2; else goto _L1
_L1:
        int i1 = saveLayer(rectf.left, rectf.top, rectf.right, rectf.bottom, paint, i);
_L5:
        return i1;
_L2:
        int j;
        int k;
        int l;
        if(paint != null)
            j = setupColorFilter(paint);
        else
            j = 0;
        if(paint != null)
            break MISSING_BLOCK_LABEL_88;
        k = 0;
_L3:
        l = nSaveLayer(mRenderer, k, i);
        i1 = l;
        if(j != 0)
            nResetModifiers(mRenderer, j);
        continue; /* Loop/switch isn't completed */
        k = paint.mNativePaint;
          goto _L3
        Exception exception;
        exception;
        if(j != 0)
            nResetModifiers(mRenderer, j);
        throw exception;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int saveLayerAlpha(float f, float f1, float f2, float f3, int i, int j) {
        int k;
        if(f < f2 && f1 < f3)
            k = nSaveLayerAlpha(mRenderer, f, f1, f2, f3, i, j);
        else
            k = save(j);
        return k;
    }

    public int saveLayerAlpha(RectF rectf, int i, int j) {
        int k;
        if(rectf != null)
            k = saveLayerAlpha(rectf.left, rectf.top, rectf.right, rectf.bottom, i, j);
        else
            k = nSaveLayerAlpha(mRenderer, i, j);
        return k;
    }

    public void scale(float f, float f1) {
        nScale(mRenderer, f, f1);
    }

    public void setDrawFilter(DrawFilter drawfilter) {
        mFilter = drawfilter;
        if(drawfilter != null) goto _L2; else goto _L1
_L1:
        nResetPaintFilter(mRenderer);
_L4:
        return;
_L2:
        if(drawfilter instanceof PaintFlagsDrawFilter) {
            PaintFlagsDrawFilter paintflagsdrawfilter = (PaintFlagsDrawFilter)drawfilter;
            nSetupPaintFilter(mRenderer, paintflagsdrawfilter.clearBits, paintflagsdrawfilter.setBits);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setMatrix(Matrix matrix) {
        int i = mRenderer;
        int j;
        if(matrix == null)
            j = 0;
        else
            j = matrix.native_instance;
        nSetMatrix(i, j);
    }

    public void setViewport(int i, int j) {
        mWidth = i;
        mHeight = j;
        nSetViewport(mRenderer, i, j);
    }

    public void skew(float f, float f1) {
        nSkew(mRenderer, f, f1);
    }

    public void translate(float f, float f1) {
        if(f != 0.0F || f1 != 0.0F)
            nTranslate(mRenderer, f, f1);
    }

    public static final int FLUSH_CACHES_FULL = 2;
    public static final int FLUSH_CACHES_LAYERS = 0;
    public static final int FLUSH_CACHES_MODERATE = 1;
    private static final int MODIFIER_COLOR_FILTER = 4;
    private static final int MODIFIER_NONE = 0;
    private static final int MODIFIER_SHADER = 2;
    private static final int MODIFIER_SHADOW = 1;
    private static boolean sIsAvailable = nIsAvailable();
    private final Rect mClipBounds;
    private DrawFilter mFilter;
    private CanvasFinalizer mFinalizer;
    private int mHeight;
    private final float mLine[];
    private final boolean mOpaque;
    private final RectF mPathBounds;
    private final float mPoint[];
    private int mRenderer;
    private int mWidth;


}
