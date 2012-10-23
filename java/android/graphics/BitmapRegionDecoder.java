// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import java.io.*;

// Referenced classes of package android.graphics:
//            Rect, Bitmap

public final class BitmapRegionDecoder {

    private BitmapRegionDecoder(int i) {
        mNativeBitmapRegionDecoder = i;
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

    private static native BitmapRegionDecoder nativeNewInstance(int i, boolean flag);

    private static native BitmapRegionDecoder nativeNewInstance(FileDescriptor filedescriptor, boolean flag);

    private static native BitmapRegionDecoder nativeNewInstance(InputStream inputstream, byte abyte0[], boolean flag);

    private static native BitmapRegionDecoder nativeNewInstance(byte abyte0[], int i, int j, boolean flag);

    public static BitmapRegionDecoder newInstance(FileDescriptor filedescriptor, boolean flag) throws IOException {
        return nativeNewInstance(filedescriptor, flag);
    }

    public static BitmapRegionDecoder newInstance(InputStream inputstream, boolean flag) throws IOException {
        if(!inputstream.markSupported())
            inputstream = new BufferedInputStream(inputstream, 16384);
        BitmapRegionDecoder bitmapregiondecoder;
        if(inputstream instanceof android.content.res.AssetManager.AssetInputStream)
            bitmapregiondecoder = nativeNewInstance(((android.content.res.AssetManager.AssetInputStream)inputstream).getAssetInt(), flag);
        else
            bitmapregiondecoder = nativeNewInstance(inputstream, new byte[16384], flag);
        return bitmapregiondecoder;
    }

    public static BitmapRegionDecoder newInstance(String s, boolean flag) throws IOException {
        FileInputStream fileinputstream = null;
        FileInputStream fileinputstream1 = new FileInputStream(s);
        BitmapRegionDecoder bitmapregiondecoder = newInstance(((InputStream) (fileinputstream1)), flag);
        Exception exception;
        IOException ioexception;
        if(fileinputstream1 != null)
            try {
                fileinputstream1.close();
            }
            catch(IOException ioexception1) { }
        return bitmapregiondecoder;
        exception;
_L2:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception) { }
        throw exception;
        exception;
        fileinputstream = fileinputstream1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static BitmapRegionDecoder newInstance(byte abyte0[], int i, int j, boolean flag) throws IOException {
        if((i | j) < 0 || abyte0.length < i + j)
            throw new ArrayIndexOutOfBoundsException();
        else
            return nativeNewInstance(abyte0, i, j, flag);
    }

    public Bitmap decodeRegion(Rect rect, BitmapFactory.Options options) {
        checkRecycled("decodeRegion called on recycled region decoder");
        if(rect.right <= 0 || rect.bottom <= 0 || rect.left >= getWidth() || rect.top >= getHeight())
            throw new IllegalArgumentException("rectangle is outside the image");
        else
            return nativeDecodeRegion(mNativeBitmapRegionDecoder, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top, options);
    }

    protected void finalize() throws Throwable {
        recycle();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getHeight() {
        checkRecycled("getHeight called on recycled region decoder");
        return nativeGetHeight(mNativeBitmapRegionDecoder);
    }

    public int getWidth() {
        checkRecycled("getWidth called on recycled region decoder");
        return nativeGetWidth(mNativeBitmapRegionDecoder);
    }

    public final boolean isRecycled() {
        return mRecycled;
    }

    public void recycle() {
        if(!mRecycled) {
            nativeClean(mNativeBitmapRegionDecoder);
            mRecycled = true;
        }
    }

    private int mNativeBitmapRegionDecoder;
    private boolean mRecycled;
}
