// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import java.io.IOException;
import java.io.InputStream;

public final class AmrInputStream extends InputStream {

    public AmrInputStream(InputStream inputstream) {
        mBufIn = 0;
        mBufOut = 0;
        mOneByte = new byte[1];
        mInputStream = inputstream;
        mGae = GsmAmrEncoderNew();
        GsmAmrEncoderInitialize(mGae);
    }

    private static native void GsmAmrEncoderCleanup(int i);

    private static native void GsmAmrEncoderDelete(int i);

    private static native int GsmAmrEncoderEncode(int i, byte abyte0[], int j, byte abyte1[], int k) throws IOException;

    private static native void GsmAmrEncoderInitialize(int i);

    private static native int GsmAmrEncoderNew();

    public void close() throws IOException {
        if(mInputStream != null)
            mInputStream.close();
        mInputStream = null;
        if(mGae != 0)
            GsmAmrEncoderCleanup(mGae);
        if(mGae != 0)
            GsmAmrEncoderDelete(mGae);
        mGae = 0;
        return;
        Exception exception;
        exception;
        mInputStream = null;
        if(mGae != 0)
            GsmAmrEncoderCleanup(mGae);
        if(mGae != 0)
            GsmAmrEncoderDelete(mGae);
        mGae = 0;
        throw exception;
        Exception exception1;
        exception1;
        if(mGae != 0)
            GsmAmrEncoderDelete(mGae);
        mGae = 0;
        throw exception1;
        Exception exception2;
        exception2;
        mGae = 0;
        throw exception2;
        Exception exception3;
        exception3;
        mGae = 0;
        throw exception3;
        Exception exception4;
        exception4;
        if(mGae != 0)
            GsmAmrEncoderDelete(mGae);
        mGae = 0;
        throw exception4;
        Exception exception5;
        exception5;
        mGae = 0;
        throw exception5;
        Exception exception6;
        exception6;
        mGae = 0;
        throw exception6;
    }

    protected void finalize() throws Throwable {
        if(mGae != 0) {
            close();
            throw new IllegalStateException("someone forgot to close AmrInputStream");
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
        if(mGae == 0)
            throw new IllegalStateException("not open");
        if(mBufOut < mBufIn)
            break MISSING_BLOCK_LABEL_115;
        mBufOut = 0;
        mBufIn = 0;
        l = 0;
_L5:
        if(l >= 320) goto _L2; else goto _L1
_L1:
        int i1 = mInputStream.read(mBuf, l, 320 - l);
        if(i1 != k) goto _L4; else goto _L3
_L3:
        return k;
_L4:
        l += i1;
          goto _L5
_L2:
        mBufIn = GsmAmrEncoderEncode(mGae, mBuf, 0, mBuf, 0);
        if(j > mBufIn - mBufOut)
            j = mBufIn - mBufOut;
        System.arraycopy(mBuf, mBufOut, abyte0, i, j);
        mBufOut = j + mBufOut;
        k = j;
          goto _L3
    }

    private static final int SAMPLES_PER_FRAME = 160;
    private static final String TAG = "AmrInputStream";
    private final byte mBuf[] = new byte[320];
    private int mBufIn;
    private int mBufOut;
    private int mGae;
    private InputStream mInputStream;
    private byte mOneByte[];

    static  {
        System.loadLibrary("media_jni");
    }
}
