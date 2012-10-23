// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            RectF, Bitmap, Paint, Canvas, 
//            Region, Rect

public class NinePatch {

    public NinePatch(Bitmap bitmap, byte abyte0[], String s) {
        mRect = new RectF();
        mBitmap = bitmap;
        mChunk = abyte0;
        mSrcName = s;
        validateNinePatchChunk(mBitmap.ni(), abyte0);
    }

    public NinePatch(NinePatch ninepatch) {
        mRect = new RectF();
        mBitmap = ninepatch.mBitmap;
        mChunk = ninepatch.mChunk;
        mSrcName = ninepatch.mSrcName;
        if(ninepatch.mPaint != null)
            mPaint = new Paint(ninepatch.mPaint);
        validateNinePatchChunk(mBitmap.ni(), mChunk);
    }

    public static native boolean isNinePatchChunk(byte abyte0[]);

    private static native void nativeDraw(int i, Rect rect, int j, byte abyte0[], int k, int l, int i1);

    private static native void nativeDraw(int i, RectF rectf, int j, byte abyte0[], int k, int l, int i1);

    private static native int nativeGetTransparentRegion(int i, byte abyte0[], Rect rect);

    private static native void validateNinePatchChunk(int i, byte abyte0[]);

    public void draw(Canvas canvas, Rect rect) {
        if(!canvas.isHardwareAccelerated()) {
            int i = canvas.mNativeCanvas;
            int j = mBitmap.ni();
            byte abyte0[] = mChunk;
            int k;
            if(mPaint != null)
                k = mPaint.mNativePaint;
            else
                k = 0;
            nativeDraw(i, rect, j, abyte0, k, canvas.mDensity, mBitmap.mDensity);
        } else {
            mRect.set(rect);
            canvas.drawPatch(mBitmap, mChunk, mRect, mPaint);
        }
    }

    public void draw(Canvas canvas, Rect rect, Paint paint) {
        if(!canvas.isHardwareAccelerated()) {
            int i = canvas.mNativeCanvas;
            int j = mBitmap.ni();
            byte abyte0[] = mChunk;
            int k;
            if(paint != null)
                k = paint.mNativePaint;
            else
                k = 0;
            nativeDraw(i, rect, j, abyte0, k, canvas.mDensity, mBitmap.mDensity);
        } else {
            mRect.set(rect);
            canvas.drawPatch(mBitmap, mChunk, mRect, paint);
        }
    }

    public void draw(Canvas canvas, RectF rectf) {
        if(!canvas.isHardwareAccelerated()) {
            int i = canvas.mNativeCanvas;
            int j = mBitmap.ni();
            byte abyte0[] = mChunk;
            int k;
            if(mPaint != null)
                k = mPaint.mNativePaint;
            else
                k = 0;
            nativeDraw(i, rectf, j, abyte0, k, canvas.mDensity, mBitmap.mDensity);
        } else {
            canvas.drawPatch(mBitmap, mChunk, rectf, mPaint);
        }
    }

    public int getDensity() {
        return mBitmap.mDensity;
    }

    public int getHeight() {
        return mBitmap.getHeight();
    }

    public final Region getTransparentRegion(Rect rect) {
        int i = nativeGetTransparentRegion(mBitmap.ni(), mChunk, rect);
        Region region;
        if(i != 0)
            region = new Region(i);
        else
            region = null;
        return region;
    }

    public int getWidth() {
        return mBitmap.getWidth();
    }

    public final boolean hasAlpha() {
        return mBitmap.hasAlpha();
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
    }

    private final Bitmap mBitmap;
    private final byte mChunk[];
    private Paint mPaint;
    private final RectF mRect;
    private String mSrcName;
}
