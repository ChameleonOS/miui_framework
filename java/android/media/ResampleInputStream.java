// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import java.io.IOException;
import java.io.InputStream;

public final class ResampleInputStream extends InputStream {

    public ResampleInputStream(InputStream inputstream, int i, int j) {
        if(i != j * 2) {
            throw new IllegalArgumentException("only support 2:1 at the moment");
        } else {
            mInputStream = inputstream;
            mRateIn = 2;
            mRateOut = 1;
            return;
        }
    }

    private static native void fir21(byte abyte0[], int i, byte abyte1[], int j, int k);

    public void close() throws IOException {
        if(mInputStream != null)
            mInputStream.close();
        mInputStream = null;
        return;
        Exception exception;
        exception;
        mInputStream = null;
        throw exception;
    }

    protected void finalize() throws Throwable {
        if(mInputStream != null) {
            close();
            throw new IllegalStateException("someone forgot to close ResampleInputStream");
        } else {
            return;
        }
    }

    public int read() throws IOException {
        int i;
        if(read(mOneByte, 0, 1) == 1)
            i = 0xff & mOneByte[0];
        else
            i = -1;
        return i;
    }

    public int read(byte abyte0[]) throws IOException {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j) throws IOException {
        int k;
        int l;
        k = -1;
        if(mInputStream == null)
            throw new IllegalStateException("not open");
        l = 2 * (29 + ((j / 2) * mRateIn) / mRateOut);
        if(mBuf != null) goto _L2; else goto _L1
_L1:
        mBuf = new byte[l];
_L8:
        int i1 = 2 * (((-29 + mBufCount / 2) * mRateOut) / mRateIn);
        if(i1 <= 0) goto _L4; else goto _L3
_L3:
        byte abyte1[];
        int k1;
        int l1;
        if(i1 < j)
            k1 = i1;
        else
            k1 = 2 * (j / 2);
        fir21(mBuf, 0, abyte0, i, k1 / 2);
        l1 = (k1 * mRateIn) / mRateOut;
        mBufCount = mBufCount - l1;
        if(mBufCount > 0)
            System.arraycopy(mBuf, l1, mBuf, 0, mBufCount);
        k = k1;
_L6:
        return k;
_L2:
        if(l > mBuf.length) {
            abyte1 = new byte[l];
            System.arraycopy(mBuf, 0, abyte1, 0, mBufCount);
            mBuf = abyte1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int j1 = mInputStream.read(mBuf, mBufCount, mBuf.length - mBufCount);
        if(j1 == k) goto _L6; else goto _L5
_L5:
        mBufCount = j1 + mBufCount;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private static final String TAG = "ResampleInputStream";
    private static final int mFirLength = 29;
    private byte mBuf[];
    private int mBufCount;
    private InputStream mInputStream;
    private final byte mOneByte[] = new byte[1];
    private final int mRateIn;
    private final int mRateOut;

    static  {
        System.loadLibrary("media_jni");
    }
}
