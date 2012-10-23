// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.*;
import android.util.*;
import java.util.ArrayList;

// Referenced classes of package android.view:
//            GLES20Canvas, GLES20DisplayList

class GLES20RecordingCanvas extends GLES20Canvas
    implements Poolable {

    private GLES20RecordingCanvas() {
        super(true, true);
    }


    static GLES20RecordingCanvas obtain(GLES20DisplayList gles20displaylist) {
        GLES20RecordingCanvas gles20recordingcanvas = (GLES20RecordingCanvas)sPool.acquire();
        gles20recordingcanvas.mDisplayList = gles20displaylist;
        return gles20recordingcanvas;
    }

    private void recordShaderBitmap(Paint paint) {
        if(paint != null) {
            android.graphics.Shader shader = paint.getShader();
            if(shader instanceof BitmapShader)
                mDisplayList.mBitmaps.add(((BitmapShader)shader).mBitmap);
        }
    }

    public void drawBitmap(Bitmap bitmap, float f, float f1, Paint paint) {
        super.drawBitmap(bitmap, f, f1, paint);
        mDisplayList.mBitmaps.add(bitmap);
    }

    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        super.drawBitmap(bitmap, matrix, paint);
        mDisplayList.mBitmaps.add(bitmap);
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect1, Paint paint) {
        super.drawBitmap(bitmap, rect, rect1, paint);
        mDisplayList.mBitmaps.add(bitmap);
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectf, Paint paint) {
        super.drawBitmap(bitmap, rect, rectf, paint);
        mDisplayList.mBitmaps.add(bitmap);
    }

    public void drawBitmap(int ai[], int i, int j, float f, float f1, int k, int l, 
            boolean flag, Paint paint) {
        super.drawBitmap(ai, i, j, f, f1, k, l, flag, paint);
    }

    public void drawBitmap(int ai[], int i, int j, int k, int l, int i1, int j1, 
            boolean flag, Paint paint) {
        super.drawBitmap(ai, i, j, k, l, i1, j1, flag, paint);
    }

    public void drawBitmapMesh(Bitmap bitmap, int i, int j, float af[], int k, int ai[], int l, 
            Paint paint) {
        super.drawBitmapMesh(bitmap, i, j, af, k, ai, l, paint);
        mDisplayList.mBitmaps.add(bitmap);
    }

    public void drawCircle(float f, float f1, float f2, Paint paint) {
        super.drawCircle(f, f1, f2, paint);
        recordShaderBitmap(paint);
    }

    public void drawLine(float f, float f1, float f2, float f3, Paint paint) {
        super.drawLine(f, f1, f2, f3, paint);
        recordShaderBitmap(paint);
    }

    public void drawLines(float af[], int i, int j, Paint paint) {
        super.drawLines(af, i, j, paint);
        recordShaderBitmap(paint);
    }

    public void drawLines(float af[], Paint paint) {
        super.drawLines(af, paint);
        recordShaderBitmap(paint);
    }

    public void drawOval(RectF rectf, Paint paint) {
        super.drawOval(rectf, paint);
        recordShaderBitmap(paint);
    }

    public void drawPaint(Paint paint) {
        super.drawPaint(paint);
        recordShaderBitmap(paint);
    }

    public void drawPatch(Bitmap bitmap, byte abyte0[], RectF rectf, Paint paint) {
        super.drawPatch(bitmap, abyte0, rectf, paint);
        mDisplayList.mBitmaps.add(bitmap);
    }

    public void drawPath(Path path, Paint paint) {
        super.drawPath(path, paint);
        recordShaderBitmap(paint);
    }

    public void drawPoint(float f, float f1, Paint paint) {
        super.drawPoint(f, f1, paint);
        recordShaderBitmap(paint);
    }

    public void drawPoints(float af[], int i, int j, Paint paint) {
        super.drawPoints(af, i, j, paint);
        recordShaderBitmap(paint);
    }

    public void drawPoints(float af[], Paint paint) {
        super.drawPoints(af, paint);
        recordShaderBitmap(paint);
    }

    public void drawPosText(String s, float af[], Paint paint) {
        super.drawPosText(s, af, paint);
        recordShaderBitmap(paint);
    }

    public void drawPosText(char ac[], int i, int j, float af[], Paint paint) {
        super.drawPosText(ac, i, j, af, paint);
        recordShaderBitmap(paint);
    }

    public void drawRect(float f, float f1, float f2, float f3, Paint paint) {
        super.drawRect(f, f1, f2, f3, paint);
        recordShaderBitmap(paint);
    }

    public void drawRect(Rect rect, Paint paint) {
        super.drawRect(rect, paint);
        recordShaderBitmap(paint);
    }

    public void drawRect(RectF rectf, Paint paint) {
        super.drawRect(rectf, paint);
        recordShaderBitmap(paint);
    }

    public void drawRoundRect(RectF rectf, float f, float f1, Paint paint) {
        super.drawRoundRect(rectf, f, f1, paint);
        recordShaderBitmap(paint);
    }

    public void drawText(CharSequence charsequence, int i, int j, float f, float f1, Paint paint) {
        super.drawText(charsequence, i, j, f, f1, paint);
        recordShaderBitmap(paint);
    }

    public void drawText(String s, float f, float f1, Paint paint) {
        super.drawText(s, f, f1, paint);
        recordShaderBitmap(paint);
    }

    public void drawText(String s, int i, int j, float f, float f1, Paint paint) {
        super.drawText(s, i, j, f, f1, paint);
        recordShaderBitmap(paint);
    }

    public void drawText(char ac[], int i, int j, float f, float f1, Paint paint) {
        super.drawText(ac, i, j, f, f1, paint);
        recordShaderBitmap(paint);
    }

    public void drawTextOnPath(String s, Path path, float f, float f1, Paint paint) {
        super.drawTextOnPath(s, path, f, f1, paint);
        recordShaderBitmap(paint);
    }

    public void drawTextOnPath(char ac[], int i, int j, Path path, float f, float f1, Paint paint) {
        super.drawTextOnPath(ac, i, j, path, f, f1, paint);
        recordShaderBitmap(paint);
    }

    public void drawTextRun(CharSequence charsequence, int i, int j, int k, int l, float f, float f1, 
            int i1, Paint paint) {
        super.drawTextRun(charsequence, i, j, k, l, f, f1, i1, paint);
        recordShaderBitmap(paint);
    }

    public void drawTextRun(char ac[], int i, int j, int k, int l, float f, float f1, 
            int i1, Paint paint) {
        super.drawTextRun(ac, i, j, k, l, f, f1, i1, paint);
        recordShaderBitmap(paint);
    }

    public void drawVertices(android.graphics.Canvas.VertexMode vertexmode, int i, float af[], int j, float af1[], int k, int ai[], 
            int l, short aword0[], int i1, int j1, Paint paint) {
        super.drawVertices(vertexmode, i, af, j, af1, k, ai, l, aword0, i1, j1, paint);
        recordShaderBitmap(paint);
    }

    int end(int i) {
        return getDisplayList(i);
    }

    public GLES20RecordingCanvas getNextPoolable() {
        return mNextPoolable;
    }

    public volatile Object getNextPoolable() {
        return getNextPoolable();
    }

    public boolean isPooled() {
        return mIsPooled;
    }

    void recycle() {
        mDisplayList = null;
        resetDisplayListRenderer();
        sPool.release(this);
    }

    public void setNextPoolable(GLES20RecordingCanvas gles20recordingcanvas) {
        mNextPoolable = gles20recordingcanvas;
    }

    public volatile void setNextPoolable(Object obj) {
        setNextPoolable((GLES20RecordingCanvas)obj);
    }

    public void setPooled(boolean flag) {
        mIsPooled = flag;
    }

    void start() {
        mDisplayList.mBitmaps.clear();
    }

    private static final int POOL_LIMIT = 25;
    private static final Pool sPool = Pools.synchronizedPool(Pools.finitePool(new PoolableManager() {

        public volatile Poolable newInstance() {
            return newInstance();
        }

        public GLES20RecordingCanvas newInstance() {
            return new GLES20RecordingCanvas();
        }

        public volatile void onAcquired(Poolable poolable) {
            onAcquired((GLES20RecordingCanvas)poolable);
        }

        public void onAcquired(GLES20RecordingCanvas gles20recordingcanvas) {
        }

        public volatile void onReleased(Poolable poolable) {
            onReleased((GLES20RecordingCanvas)poolable);
        }

        public void onReleased(GLES20RecordingCanvas gles20recordingcanvas) {
        }

    }, 25));
    private GLES20DisplayList mDisplayList;
    private boolean mIsPooled;
    private GLES20RecordingCanvas mNextPoolable;

}
