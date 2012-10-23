// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Rect, Bitmap

public final class LargeBitmap {

    private LargeBitmap(int i) {
        mNativeLargeBitmap = i;
        mRecycled = false;
    }

    private void checkRecycled(String s) {
        if(mRecycled)
            throw new IllegalStateException(s);
        else
            return;
    }

    private static native void nativeClean(int i);

    private static native Bitmap nativeDecodeRegion(int i, int j, int k, int l, int i1, BitmapFactory.Options options);

    private static native int nativeGetHeight(int i);

    private static native int nativeGetWidth(int i);

    public Bitmap decodeRegion(Rect rect, BitmapFactory.Options options) {
        checkRecycled("decodeRegion called on recycled large bitmap");
        if(rect.left < 0 || rect.top < 0 || rect.right > getWidth() || rect.bottom > getHeight())
            throw new IllegalArgumentException("rectangle is not inside the image");
        else
            return nativeDecodeRegion(mNativeLargeBitmap, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top, options);
    }

    protected void finalize() {
        recycle();
    }

    public int getHeight() {
        checkRecycled("getHeight called on recycled large bitmap");
        return nativeGetHeight(mNativeLargeBitmap);
    }

    public int getWidth() {
        checkRecycled("getWidth called on recycled large bitmap");
        return nativeGetWidth(mNativeLargeBitmap);
    }

    public final boolean isRecycled() {
        return mRecycled;
    }

    public void recycle() {
        if(!mRecycled) {
            nativeClean(mNativeLargeBitmap);
            mRecycled = true;
        }
    }

    private int mNativeLargeBitmap;
    private boolean mRecycled;
}
