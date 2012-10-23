// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.text.*;
import javax.microedition.khronos.opengles.GL;

// Referenced classes of package android.graphics:
//            Bitmap, Path, Rect, RectF, 
//            Region, Matrix, Paint, Picture, 
//            TemporaryBuffer, DrawFilter

public class Canvas {
    public static final class VertexMode extends Enum {

        public static VertexMode valueOf(String s) {
            return (VertexMode)Enum.valueOf(android/graphics/Canvas$VertexMode, s);
        }

        public static VertexMode[] values() {
            return (VertexMode[])$VALUES.clone();
        }

        private static final VertexMode $VALUES[];
        public static final VertexMode TRIANGLES;
        public static final VertexMode TRIANGLE_FAN;
        public static final VertexMode TRIANGLE_STRIP;
        public final int nativeInt;

        static  {
            TRIANGLES = new VertexMode("TRIANGLES", 0, 0);
            TRIANGLE_STRIP = new VertexMode("TRIANGLE_STRIP", 1, 1);
            TRIANGLE_FAN = new VertexMode("TRIANGLE_FAN", 2, 2);
            VertexMode avertexmode[] = new VertexMode[3];
            avertexmode[0] = TRIANGLES;
            avertexmode[1] = TRIANGLE_STRIP;
            avertexmode[2] = TRIANGLE_FAN;
            $VALUES = avertexmode;
        }

        private VertexMode(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }

    public static final class EdgeType extends Enum {

        public static EdgeType valueOf(String s) {
            return (EdgeType)Enum.valueOf(android/graphics/Canvas$EdgeType, s);
        }

        public static EdgeType[] values() {
            return (EdgeType[])$VALUES.clone();
        }

        private static final EdgeType $VALUES[];
        public static final EdgeType AA;
        public static final EdgeType BW;
        public final int nativeInt;

        static  {
            BW = new EdgeType("BW", 0, 0);
            AA = new EdgeType("AA", 1, 1);
            EdgeType aedgetype[] = new EdgeType[2];
            aedgetype[0] = BW;
            aedgetype[1] = AA;
            $VALUES = aedgetype;
        }

        private EdgeType(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }

    private static class CanvasFinalizer {

        protected void finalize() throws Throwable {
            if(mNativeCanvas != 0)
                Canvas.finalizer(mNativeCanvas);
            super.finalize();
            return;
            Exception exception;
            exception;
            super.finalize();
            throw exception;
        }

        private final int mNativeCanvas;

        public CanvasFinalizer(int i) {
            mNativeCanvas = i;
        }
    }


    public Canvas() {
        mDensity = 0;
        mScreenDensity = 0;
        mNativeCanvas = initRaster(0);
        mFinalizer = new CanvasFinalizer(mNativeCanvas);
    }

    Canvas(int i) {
        mDensity = 0;
        mScreenDensity = 0;
        if(i == 0) {
            throw new IllegalStateException();
        } else {
            mNativeCanvas = i;
            mFinalizer = new CanvasFinalizer(i);
            mDensity = Bitmap.getDefaultDensity();
            return;
        }
    }

    public Canvas(Bitmap bitmap) {
        mDensity = 0;
        mScreenDensity = 0;
        if(!bitmap.isMutable()) {
            throw new IllegalStateException("Immutable bitmap passed to Canvas constructor");
        } else {
            throwIfRecycled(bitmap);
            mNativeCanvas = initRaster(bitmap.ni());
            mFinalizer = new CanvasFinalizer(mNativeCanvas);
            mBitmap = bitmap;
            mDensity = bitmap.mDensity;
            return;
        }
    }

    protected static void checkRange(int i, int j, int k) {
        if((j | k) < 0 || j + k > i)
            throw new ArrayIndexOutOfBoundsException();
        else
            return;
    }

    private static native void finalizer(int i);

    public static native void freeCaches();

    public static native void freeTextLayoutCaches();

    private static native int initRaster(int i);

    private static native void nativeDrawBitmapMatrix(int i, int j, int k, int l);

    private static native void nativeDrawBitmapMesh(int i, int j, int k, int l, float af[], int i1, int ai[], int j1, 
            int k1);

    private static native void nativeDrawVertices(int i, int j, int k, float af[], int l, float af1[], int i1, int ai[], 
            int j1, short aword0[], int k1, int l1, int i2);

    private static native void nativeSetDrawFilter(int i, int j);

    private static native boolean native_clipPath(int i, int j, int k);

    private static native boolean native_clipRect(int i, float f, float f1, float f2, float f3, int j);

    private static native boolean native_clipRegion(int i, int j, int k);

    private static native void native_concat(int i, int j);

    private static native void native_drawARGB(int i, int j, int k, int l, int i1);

    private static native void native_drawArc(int i, RectF rectf, float f, float f1, boolean flag, int j);

    private native void native_drawBitmap(int i, int j, float f, float f1, int k, int l, int i1, 
            int j1);

    private static native void native_drawBitmap(int i, int j, Rect rect, Rect rect1, int k, int l, int i1);

    private native void native_drawBitmap(int i, int j, Rect rect, RectF rectf, int k, int l, int i1);

    private static native void native_drawBitmap(int i, int ai[], int j, int k, float f, float f1, int l, int i1, 
            boolean flag, int j1);

    private static native void native_drawCircle(int i, float f, float f1, float f2, int j);

    private static native void native_drawColor(int i, int j);

    private static native void native_drawColor(int i, int j, int k);

    private static native void native_drawLine(int i, float f, float f1, float f2, float f3, int j);

    private static native void native_drawOval(int i, RectF rectf, int j);

    private static native void native_drawPaint(int i, int j);

    private static native void native_drawPath(int i, int j, int k);

    private static native void native_drawPicture(int i, int j);

    private static native void native_drawPosText(int i, String s, float af[], int j);

    private static native void native_drawPosText(int i, char ac[], int j, int k, float af[], int l);

    private static native void native_drawRGB(int i, int j, int k, int l);

    private static native void native_drawRect(int i, float f, float f1, float f2, float f3, int j);

    private static native void native_drawRect(int i, RectF rectf, int j);

    private static native void native_drawRoundRect(int i, RectF rectf, float f, float f1, int j);

    private static native void native_drawText(int i, String s, int j, int k, float f, float f1, int l, int i1);

    private static native void native_drawText(int i, char ac[], int j, int k, float f, float f1, int l, int i1);

    private static native void native_drawTextOnPath(int i, String s, int j, float f, float f1, int k, int l);

    private static native void native_drawTextOnPath(int i, char ac[], int j, int k, int l, float f, float f1, int i1, 
            int j1);

    private static native void native_drawTextRun(int i, String s, int j, int k, int l, int i1, float f, float f1, 
            int j1, int k1);

    private static native void native_drawTextRun(int i, char ac[], int j, int k, int l, int i1, float f, float f1, 
            int j1, int k1);

    private static native void native_getCTM(int i, int j);

    private static native boolean native_getClipBounds(int i, Rect rect);

    private static native boolean native_quickReject(int i, float f, float f1, float f2, float f3, int j);

    private static native boolean native_quickReject(int i, int j, int k);

    private static native boolean native_quickReject(int i, RectF rectf, int j);

    private static native int native_saveLayer(int i, float f, float f1, float f2, float f3, int j, int k);

    private static native int native_saveLayer(int i, RectF rectf, int j, int k);

    private static native int native_saveLayerAlpha(int i, float f, float f1, float f2, float f3, int j, int k);

    private static native int native_saveLayerAlpha(int i, RectF rectf, int j, int k);

    private static native void native_setBitmap(int i, int j);

    private static native void native_setMatrix(int i, int j);

    private static void throwIfRecycled(Bitmap bitmap) {
        if(bitmap.isRecycled())
            throw new RuntimeException((new StringBuilder()).append("Canvas: trying to use a recycled bitmap ").append(bitmap).toString());
        else
            return;
    }

    public boolean clipPath(Path path) {
        return clipPath(path, Region.Op.INTERSECT);
    }

    public boolean clipPath(Path path, Region.Op op) {
        return native_clipPath(mNativeCanvas, path.ni(), op.nativeInt);
    }

    public native boolean clipRect(float f, float f1, float f2, float f3);

    public boolean clipRect(float f, float f1, float f2, float f3, Region.Op op) {
        return native_clipRect(mNativeCanvas, f, f1, f2, f3, op.nativeInt);
    }

    public native boolean clipRect(int i, int j, int k, int l);

    public native boolean clipRect(Rect rect);

    public boolean clipRect(Rect rect, Region.Op op) {
        return native_clipRect(mNativeCanvas, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    public native boolean clipRect(RectF rectf);

    public boolean clipRect(RectF rectf, Region.Op op) {
        return native_clipRect(mNativeCanvas, rectf.left, rectf.top, rectf.right, rectf.bottom, op.nativeInt);
    }

    public boolean clipRegion(Region region) {
        return clipRegion(region, Region.Op.INTERSECT);
    }

    public boolean clipRegion(Region region, Region.Op op) {
        return native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt);
    }

    public void concat(Matrix matrix) {
        native_concat(mNativeCanvas, matrix.native_instance);
    }

    public void drawARGB(int i, int j, int k, int l) {
        native_drawARGB(mNativeCanvas, i, j, k, l);
    }

    public void drawArc(RectF rectf, float f, float f1, boolean flag, Paint paint) {
        if(rectf == null) {
            throw new NullPointerException();
        } else {
            native_drawArc(mNativeCanvas, rectf, f, f1, flag, paint.mNativePaint);
            return;
        }
    }

    public void drawBitmap(Bitmap bitmap, float f, float f1, Paint paint) {
        throwIfRecycled(bitmap);
        int i = mNativeCanvas;
        int j = bitmap.ni();
        int k;
        if(paint != null)
            k = paint.mNativePaint;
        else
            k = 0;
        native_drawBitmap(i, j, f, f1, k, mDensity, mScreenDensity, bitmap.mDensity);
    }

    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        int i = mNativeCanvas;
        int j = bitmap.ni();
        int k = matrix.ni();
        int l;
        if(paint != null)
            l = paint.mNativePaint;
        else
            l = 0;
        nativeDrawBitmapMatrix(i, j, k, l);
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect1, Paint paint) {
        if(rect1 == null)
            throw new NullPointerException();
        throwIfRecycled(bitmap);
        int i = mNativeCanvas;
        int j = bitmap.ni();
        int k;
        if(paint != null)
            k = paint.mNativePaint;
        else
            k = 0;
        native_drawBitmap(i, j, rect, rect1, k, mScreenDensity, bitmap.mDensity);
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectf, Paint paint) {
        if(rectf == null)
            throw new NullPointerException();
        throwIfRecycled(bitmap);
        int i = mNativeCanvas;
        int j = bitmap.ni();
        int k;
        if(paint != null)
            k = paint.mNativePaint;
        else
            k = 0;
        native_drawBitmap(i, j, rect, rectf, k, mScreenDensity, bitmap.mDensity);
    }

    public void drawBitmap(int ai[], int i, int j, float f, float f1, int k, int l, 
            boolean flag, Paint paint) {
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
        if(k != 0 && l != 0) {
            int k1 = mNativeCanvas;
            int l1;
            if(paint != null)
                l1 = paint.mNativePaint;
            else
                l1 = 0;
            native_drawBitmap(k1, ai, i, j, f, f1, k, l, flag, l1);
        }
    }

    public void drawBitmap(int ai[], int i, int j, int k, int l, int i1, int j1, 
            boolean flag, Paint paint) {
        drawBitmap(ai, i, j, k, l, i1, j1, flag, paint);
    }

    public void drawBitmapMesh(Bitmap bitmap, int i, int j, float af[], int k, int ai[], int l, 
            Paint paint) {
        if((l | (k | (i | j))) < 0)
            throw new ArrayIndexOutOfBoundsException();
        if(i != 0 && j != 0) {
            int i1 = (i + 1) * (j + 1);
            checkRange(af.length, k, i1 * 2);
            if(ai != null)
                checkRange(ai.length, l, i1);
            int j1 = mNativeCanvas;
            int k1 = bitmap.ni();
            int l1;
            if(paint != null)
                l1 = paint.mNativePaint;
            else
                l1 = 0;
            nativeDrawBitmapMesh(j1, k1, i, j, af, k, ai, l, l1);
        }
    }

    public void drawCircle(float f, float f1, float f2, Paint paint) {
        native_drawCircle(mNativeCanvas, f, f1, f2, paint.mNativePaint);
    }

    public void drawColor(int i) {
        native_drawColor(mNativeCanvas, i);
    }

    public void drawColor(int i, PorterDuff.Mode mode) {
        native_drawColor(mNativeCanvas, i, mode.nativeInt);
    }

    public void drawLine(float f, float f1, float f2, float f3, Paint paint) {
        native_drawLine(mNativeCanvas, f, f1, f2, f3, paint.mNativePaint);
    }

    public native void drawLines(float af[], int i, int j, Paint paint);

    public void drawLines(float af[], Paint paint) {
        drawLines(af, 0, af.length, paint);
    }

    public void drawOval(RectF rectf, Paint paint) {
        if(rectf == null) {
            throw new NullPointerException();
        } else {
            native_drawOval(mNativeCanvas, rectf, paint.mNativePaint);
            return;
        }
    }

    public void drawPaint(Paint paint) {
        native_drawPaint(mNativeCanvas, paint.mNativePaint);
    }

    public void drawPatch(Bitmap bitmap, byte abyte0[], RectF rectf, Paint paint) {
    }

    public void drawPath(Path path, Paint paint) {
        native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
    }

    public void drawPicture(Picture picture) {
        picture.endRecording();
        native_drawPicture(mNativeCanvas, picture.ni());
    }

    public void drawPicture(Picture picture, Rect rect) {
        save();
        translate(rect.left, rect.top);
        if(picture.getWidth() > 0 && picture.getHeight() > 0)
            scale((float)rect.width() / (float)picture.getWidth(), (float)rect.height() / (float)picture.getHeight());
        drawPicture(picture);
        restore();
    }

    public void drawPicture(Picture picture, RectF rectf) {
        save();
        translate(rectf.left, rectf.top);
        if(picture.getWidth() > 0 && picture.getHeight() > 0)
            scale(rectf.width() / (float)picture.getWidth(), rectf.height() / (float)picture.getHeight());
        drawPicture(picture);
        restore();
    }

    public native void drawPoint(float f, float f1, Paint paint);

    public native void drawPoints(float af[], int i, int j, Paint paint);

    public void drawPoints(float af[], Paint paint) {
        drawPoints(af, 0, af.length, paint);
    }

    public void drawPosText(String s, float af[], Paint paint) {
        if(2 * s.length() > af.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            native_drawPosText(mNativeCanvas, s, af, paint.mNativePaint);
            return;
        }
    }

    public void drawPosText(char ac[], int i, int j, float af[], Paint paint) {
        if(i < 0 || i + j > ac.length || j * 2 > af.length) {
            throw new IndexOutOfBoundsException();
        } else {
            native_drawPosText(mNativeCanvas, ac, i, j, af, paint.mNativePaint);
            return;
        }
    }

    public void drawRGB(int i, int j, int k) {
        native_drawRGB(mNativeCanvas, i, j, k);
    }

    public void drawRect(float f, float f1, float f2, float f3, Paint paint) {
        native_drawRect(mNativeCanvas, f, f1, f2, f3, paint.mNativePaint);
    }

    public void drawRect(Rect rect, Paint paint) {
        drawRect(rect.left, rect.top, rect.right, rect.bottom, paint);
    }

    public void drawRect(RectF rectf, Paint paint) {
        native_drawRect(mNativeCanvas, rectf, paint.mNativePaint);
    }

    public void drawRoundRect(RectF rectf, float f, float f1, Paint paint) {
        if(rectf == null) {
            throw new NullPointerException();
        } else {
            native_drawRoundRect(mNativeCanvas, rectf, f, f1, paint.mNativePaint);
            return;
        }
    }

    public void drawText(CharSequence charsequence, int i, int j, float f, float f1, Paint paint) {
        if((charsequence instanceof String) || (charsequence instanceof SpannedString) || (charsequence instanceof SpannableString))
            native_drawText(mNativeCanvas, charsequence.toString(), i, j, f, f1, paint.mBidiFlags, paint.mNativePaint);
        else
        if(charsequence instanceof GraphicsOperations) {
            ((GraphicsOperations)charsequence).drawText(this, i, j, f, f1, paint);
        } else {
            char ac[] = TemporaryBuffer.obtain(j - i);
            TextUtils.getChars(charsequence, i, j, ac, 0);
            native_drawText(mNativeCanvas, ac, 0, j - i, f, f1, paint.mBidiFlags, paint.mNativePaint);
            TemporaryBuffer.recycle(ac);
        }
    }

    public void drawText(String s, float f, float f1, Paint paint) {
        native_drawText(mNativeCanvas, s, 0, s.length(), f, f1, paint.mBidiFlags, paint.mNativePaint);
    }

    public void drawText(String s, int i, int j, float f, float f1, Paint paint) {
        if((i | j | j - i | s.length() - j) < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            native_drawText(mNativeCanvas, s, i, j, f, f1, paint.mBidiFlags, paint.mNativePaint);
            return;
        }
    }

    public void drawText(char ac[], int i, int j, float f, float f1, Paint paint) {
        if((i | j | i + j | ac.length - i - j) < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            native_drawText(mNativeCanvas, ac, i, j, f, f1, paint.mBidiFlags, paint.mNativePaint);
            return;
        }
    }

    public void drawTextOnPath(String s, Path path, float f, float f1, Paint paint) {
        if(s.length() > 0)
            native_drawTextOnPath(mNativeCanvas, s, path.ni(), f, f1, paint.mBidiFlags, paint.mNativePaint);
    }

    public void drawTextOnPath(char ac[], int i, int j, Path path, float f, float f1, Paint paint) {
        if(i < 0 || i + j > ac.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            native_drawTextOnPath(mNativeCanvas, ac, i, j, path.ni(), f, f1, paint.mBidiFlags, paint.mNativePaint);
            return;
        }
    }

    public void drawTextRun(CharSequence charsequence, int i, int j, int k, int l, float f, float f1, 
            int i1, Paint paint) {
        if(charsequence == null)
            throw new NullPointerException("text is null");
        if(paint == null)
            throw new NullPointerException("paint is null");
        if((i | j | j - i | charsequence.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        int j1;
        if(i1 == 0)
            j1 = 0;
        else
            j1 = 1;
        if((charsequence instanceof String) || (charsequence instanceof SpannedString) || (charsequence instanceof SpannableString))
            native_drawTextRun(mNativeCanvas, charsequence.toString(), i, j, k, l, f, f1, j1, paint.mNativePaint);
        else
        if(charsequence instanceof GraphicsOperations) {
            ((GraphicsOperations)charsequence).drawTextRun(this, i, j, k, l, f, f1, j1, paint);
        } else {
            int k1 = l - k;
            int l1 = j - i;
            char ac[] = TemporaryBuffer.obtain(k1);
            TextUtils.getChars(charsequence, k, l, ac, 0);
            native_drawTextRun(mNativeCanvas, ac, i - k, l1, 0, k1, f, f1, j1, paint.mNativePaint);
            TemporaryBuffer.recycle(ac);
        }
    }

    public void drawTextRun(char ac[], int i, int j, int k, int l, float f, float f1, 
            int i1, Paint paint) {
        if(ac == null)
            throw new NullPointerException("text is null");
        if(paint == null)
            throw new NullPointerException("paint is null");
        if((i | j | ac.length - i - j) < 0)
            throw new IndexOutOfBoundsException();
        if(i1 != 0 && i1 != 1) {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown dir: ").append(i1).toString());
        } else {
            native_drawTextRun(mNativeCanvas, ac, i, j, k, l, f, f1, i1, paint.mNativePaint);
            return;
        }
    }

    public void drawVertices(VertexMode vertexmode, int i, float af[], int j, float af1[], int k, int ai[], 
            int l, short aword0[], int i1, int j1, Paint paint) {
        checkRange(af.length, j, i);
        if(af1 != null)
            checkRange(af1.length, k, i);
        if(ai != null)
            checkRange(ai.length, l, i / 2);
        if(aword0 != null)
            checkRange(aword0.length, i1, j1);
        nativeDrawVertices(mNativeCanvas, vertexmode.nativeInt, i, af, j, af1, k, ai, l, aword0, i1, j1, paint.mNativePaint);
    }

    public final Rect getClipBounds() {
        Rect rect = new Rect();
        getClipBounds(rect);
        return rect;
    }

    public boolean getClipBounds(Rect rect) {
        return native_getClipBounds(mNativeCanvas, rect);
    }

    public int getDensity() {
        return mDensity;
    }

    public DrawFilter getDrawFilter() {
        return mDrawFilter;
    }

    protected GL getGL() {
        return null;
    }

    public native int getHeight();

    public final Matrix getMatrix() {
        Matrix matrix = new Matrix();
        getMatrix(matrix);
        return matrix;
    }

    public void getMatrix(Matrix matrix) {
        native_getCTM(mNativeCanvas, matrix.native_instance);
    }

    public int getMaximumBitmapHeight() {
        return 32766;
    }

    public int getMaximumBitmapWidth() {
        return 32766;
    }

    public native int getSaveCount();

    public native int getWidth();

    public boolean isHardwareAccelerated() {
        return false;
    }

    public native boolean isOpaque();

    public boolean quickReject(float f, float f1, float f2, float f3, EdgeType edgetype) {
        return native_quickReject(mNativeCanvas, f, f1, f2, f3, edgetype.nativeInt);
    }

    public boolean quickReject(Path path, EdgeType edgetype) {
        return native_quickReject(mNativeCanvas, path.ni(), edgetype.nativeInt);
    }

    public boolean quickReject(RectF rectf, EdgeType edgetype) {
        return native_quickReject(mNativeCanvas, rectf, edgetype.nativeInt);
    }

    public native void restore();

    public native void restoreToCount(int i);

    public native void rotate(float f);

    public final void rotate(float f, float f1, float f2) {
        translate(f1, f2);
        rotate(f);
        translate(-f1, -f2);
    }

    public native int save();

    public native int save(int i);

    public int saveLayer(float f, float f1, float f2, float f3, Paint paint, int i) {
        int j = mNativeCanvas;
        int k;
        if(paint != null)
            k = paint.mNativePaint;
        else
            k = 0;
        return native_saveLayer(j, f, f1, f2, f3, k, i);
    }

    public int saveLayer(RectF rectf, Paint paint, int i) {
        int j = mNativeCanvas;
        int k;
        if(paint != null)
            k = paint.mNativePaint;
        else
            k = 0;
        return native_saveLayer(j, rectf, k, i);
    }

    public int saveLayerAlpha(float f, float f1, float f2, float f3, int i, int j) {
        return native_saveLayerAlpha(mNativeCanvas, f, f1, f2, f3, i, j);
    }

    public int saveLayerAlpha(RectF rectf, int i, int j) {
        int k = Math.min(255, Math.max(0, i));
        return native_saveLayerAlpha(mNativeCanvas, rectf, k, j);
    }

    public native void scale(float f, float f1);

    public final void scale(float f, float f1, float f2, float f3) {
        translate(f2, f3);
        scale(f, f1);
        translate(-f2, -f3);
    }

    public void setBitmap(Bitmap bitmap) {
        if(isHardwareAccelerated())
            throw new RuntimeException("Can't set a bitmap device on a GL canvas");
        int i = 0;
        if(bitmap != null) {
            if(!bitmap.isMutable())
                throw new IllegalStateException();
            throwIfRecycled(bitmap);
            mDensity = bitmap.mDensity;
            i = bitmap.ni();
        }
        native_setBitmap(mNativeCanvas, i);
        mBitmap = bitmap;
    }

    public void setDensity(int i) {
        if(mBitmap != null)
            mBitmap.setDensity(i);
        mDensity = i;
    }

    public void setDrawFilter(DrawFilter drawfilter) {
        int i = 0;
        if(drawfilter != null)
            i = drawfilter.mNativeInt;
        mDrawFilter = drawfilter;
        nativeSetDrawFilter(mNativeCanvas, i);
    }

    public void setMatrix(Matrix matrix) {
        int i = mNativeCanvas;
        int j;
        if(matrix == null)
            j = 0;
        else
            j = matrix.native_instance;
        native_setMatrix(i, j);
    }

    public void setScreenDensity(int i) {
        mScreenDensity = i;
    }

    public void setViewport(int i, int j) {
    }

    public native void skew(float f, float f1);

    public native void translate(float f, float f1);

    public static final int ALL_SAVE_FLAG = 31;
    public static final int CLIP_SAVE_FLAG = 2;
    public static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    public static final int DIRECTION_LTR = 0;
    public static final int DIRECTION_RTL = 1;
    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 8;
    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 4;
    public static final int MATRIX_SAVE_FLAG = 1;
    private static final int MAXMIMUM_BITMAP_SIZE = 32766;
    private Bitmap mBitmap;
    protected int mDensity;
    private DrawFilter mDrawFilter;
    private final CanvasFinalizer mFinalizer;
    final int mNativeCanvas;
    protected int mScreenDensity;
    private int mSurfaceFormat;

}
