// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import java.io.OutputStream;

// Referenced classes of package android.graphics:
//            Rect

public class YuvImage {

    public YuvImage(byte abyte0[], int i, int j, int k, int ai[]) {
        if(i != 17 && i != 20)
            throw new IllegalArgumentException("only support ImageFormat.NV21 and ImageFormat.YUY2 for now");
        if(j <= 0 || k <= 0)
            throw new IllegalArgumentException("width and height must large than 0");
        if(abyte0 == null)
            throw new IllegalArgumentException("yuv cannot be null");
        if(ai == null)
            mStrides = calculateStrides(j, i);
        else
            mStrides = ai;
        mData = abyte0;
        mFormat = i;
        mWidth = j;
        mHeight = k;
    }

    private void adjustRectangle(Rect rect) {
        int i = rect.width();
        int j = rect.height();
        if(mFormat == 17) {
            i &= -2;
            int l = j & -2;
            rect.left = -2 & rect.left;
            rect.top = -2 & rect.top;
            rect.right = i + rect.left;
            rect.bottom = l + rect.top;
        }
        if(mFormat == 20) {
            int k = i & -2;
            rect.left = -2 & rect.left;
            rect.right = k + rect.left;
        }
    }

    private int[] calculateStrides(int i, int j) {
        int ai[];
        if(j == 17) {
            int ai2[] = new int[2];
            ai2[0] = i;
            ai2[1] = i;
            ai = ai2;
        } else
        if(j == 20) {
            int ai1[] = new int[1];
            ai1[0] = i * 2;
            ai = ai1;
        } else {
            ai = null;
        }
        return ai;
    }

    private static native boolean nativeCompressToJpeg(byte abyte0[], int i, int j, int k, int ai[], int ai1[], int l, OutputStream outputstream, 
            byte abyte1[]);

    int[] calculateOffsets(int i, int j) {
        int ai[];
        if(mFormat == 17) {
            int ai2[] = new int[2];
            ai2[0] = i + j * mStrides[0];
            ai2[1] = mHeight * mStrides[0] + (j / 2) * mStrides[1] + 2 * (i / 2);
            ai = ai2;
        } else
        if(mFormat == 20) {
            int ai1[] = new int[1];
            ai1[0] = j * mStrides[0] + 4 * (i / 2);
            ai = ai1;
        } else {
            ai = null;
        }
        return ai;
    }

    public boolean compressToJpeg(Rect rect, int i, OutputStream outputstream) {
        if(!(new Rect(0, 0, mWidth, mHeight)).contains(rect))
            throw new IllegalArgumentException("rectangle is not inside the image");
        if(i < 0 || i > 100)
            throw new IllegalArgumentException("quality must be 0..100");
        if(outputstream == null) {
            throw new IllegalArgumentException("stream cannot be null");
        } else {
            adjustRectangle(rect);
            int ai[] = calculateOffsets(rect.left, rect.top);
            return nativeCompressToJpeg(mData, mFormat, rect.width(), rect.height(), ai, mStrides, i, outputstream, new byte[4096]);
        }
    }

    public int getHeight() {
        return mHeight;
    }

    public int[] getStrides() {
        return mStrides;
    }

    public int getWidth() {
        return mWidth;
    }

    public byte[] getYuvData() {
        return mData;
    }

    public int getYuvFormat() {
        return mFormat;
    }

    private static final int WORKING_COMPRESS_STORAGE = 4096;
    private byte mData[];
    private int mFormat;
    private int mHeight;
    private int mStrides[];
    private int mWidth;
}
