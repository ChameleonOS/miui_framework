// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;


public class BitwiseInputStream {
    public static class AccessException extends Exception {

        public AccessException(String s) {
            super((new StringBuilder()).append("BitwiseInputStream access failed: ").append(s).toString());
        }
    }


    public BitwiseInputStream(byte abyte0[]) {
        mBuf = abyte0;
        mEnd = abyte0.length << 3;
        mPos = 0;
    }

    public int available() {
        return mEnd - mPos;
    }

    public int read(int i) throws AccessException {
        int j = mPos >>> 3;
        int k = 16 - (7 & mPos) - i;
        if(i < 0 || i > 8 || i + mPos > mEnd)
            throw new AccessException((new StringBuilder()).append("illegal read (pos ").append(mPos).append(", end ").append(mEnd).append(", bits ").append(i).append(")").toString());
        int l = (0xff & mBuf[j]) << 8;
        if(k < 8)
            l |= 0xff & mBuf[j + 1];
        int i1 = l >>> k & -1 >>> 32 - i;
        mPos = i + mPos;
        return i1;
    }

    public byte[] readByteArray(int i) throws AccessException {
        int j = i >>> 3;
        int k;
        int l;
        byte abyte0[];
        if((i & 7) > 0)
            k = 1;
        else
            k = 0;
        l = j + k;
        abyte0 = new byte[l];
        for(int i1 = 0; i1 < l; i1++) {
            int j1 = Math.min(8, i - (i1 << 3));
            abyte0[i1] = (byte)(read(j1) << 8 - j1);
        }

        return abyte0;
    }

    public void skip(int i) throws AccessException {
        if(i + mPos > mEnd) {
            throw new AccessException((new StringBuilder()).append("illegal skip (pos ").append(mPos).append(", end ").append(mEnd).append(", bits ").append(i).append(")").toString());
        } else {
            mPos = i + mPos;
            return;
        }
    }

    private byte mBuf[];
    private int mEnd;
    private int mPos;
}
