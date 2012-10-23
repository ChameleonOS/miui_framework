// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;


public class BitwiseOutputStream {
    public static class AccessException extends Exception {

        public AccessException(String s) {
            super((new StringBuilder()).append("BitwiseOutputStream access failed: ").append(s).toString());
        }
    }


    public BitwiseOutputStream(int i) {
        mBuf = new byte[i];
        mEnd = i << 3;
        mPos = 0;
    }

    private void possExpand(int i) {
        if(i + mPos >= mEnd) {
            byte abyte0[] = new byte[i + mPos >>> 2];
            System.arraycopy(mBuf, 0, abyte0, 0, mEnd >>> 3);
            mBuf = abyte0;
            mEnd = abyte0.length << 3;
        }
    }

    public void skip(int i) {
        possExpand(i);
        mPos = i + mPos;
    }

    public byte[] toByteArray() {
        int i = mPos >>> 3;
        int j;
        int k;
        byte abyte0[];
        if((7 & mPos) > 0)
            j = 1;
        else
            j = 0;
        k = i + j;
        abyte0 = new byte[k];
        System.arraycopy(mBuf, 0, abyte0, 0, k);
        return abyte0;
    }

    public void write(int i, int j) throws AccessException {
        if(i < 0 || i > 8)
            throw new AccessException((new StringBuilder()).append("illegal write (").append(i).append(" bits)").toString());
        possExpand(i);
        int k = j & -1 >>> 32 - i;
        int l = mPos >>> 3;
        int i1 = 16 - (7 & mPos) - i;
        int j1 = k << i1;
        mPos = i + mPos;
        byte abyte0[] = mBuf;
        abyte0[l] = (byte)(abyte0[l] | j1 >>> 8);
        if(i1 < 8) {
            byte abyte1[] = mBuf;
            int k1 = l + 1;
            abyte1[k1] = (byte)(abyte1[k1] | j1 & 0xff);
        }
    }

    public void writeByteArray(int i, byte abyte0[]) throws AccessException {
        for(int j = 0; j < abyte0.length; j++) {
            int k = Math.min(8, i - (j << 3));
            if(k > 0)
                write(k, (byte)(abyte0[j] >>> 8 - k));
        }

    }

    private byte mBuf[];
    private int mEnd;
    private int mPos;
}
