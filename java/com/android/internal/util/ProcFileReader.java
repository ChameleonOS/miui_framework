// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.io.*;
import java.nio.charset.Charsets;

public class ProcFileReader
    implements Closeable {

    public ProcFileReader(InputStream inputstream) throws IOException {
        this(inputstream, 4096);
    }

    public ProcFileReader(InputStream inputstream, int i) throws IOException {
        mStream = inputstream;
        mBuffer = new byte[i];
        fillBuf();
    }

    private void consumeBuf(int i) throws IOException {
        System.arraycopy(mBuffer, i, mBuffer, 0, mTail - i);
        mTail = mTail - i;
        if(mTail == 0)
            fillBuf();
    }

    private int fillBuf() throws IOException {
        int i = mBuffer.length - mTail;
        if(i == 0)
            throw new IOException("attempting to fill already-full buffer");
        int j = mStream.read(mBuffer, mTail, i);
        if(j != -1)
            mTail = j + mTail;
        return j;
    }

    private NumberFormatException invalidLong(int i) {
        return new NumberFormatException((new StringBuilder()).append("invalid long: ").append(new String(mBuffer, 0, i, Charsets.US_ASCII)).toString());
    }

    private int nextTokenIndex() throws IOException {
        int i;
        if(mLineFinished)
            throw new IOException("no tokens remaining on current line");
        i = 0;
_L6:
        byte byte0;
        if(i >= mTail)
            break; /* Loop/switch isn't completed */
        byte0 = mBuffer[i];
        if(byte0 != 10) goto _L2; else goto _L1
_L1:
        mLineFinished = true;
_L4:
        return i;
_L2:
        if(byte0 == 32) goto _L4; else goto _L3
_L3:
        i++;
        if(true) goto _L6; else goto _L5
_L5:
        if(fillBuf() > 0) goto _L6; else goto _L7
_L7:
        throw new IOException("end of stream while looking for token boundary");
    }

    public void close() throws IOException {
        mStream.close();
    }

    public void finishLine() throws IOException {
        if(!mLineFinished) goto _L2; else goto _L1
_L1:
        mLineFinished = false;
_L4:
        return;
_L2:
        int i = 0;
label0:
        do
            do {
                if(i >= mTail)
                    continue label0;
                if(mBuffer[i] == 10) {
                    consumeBuf(i + 1);
                    continue; /* Loop/switch isn't completed */
                }
                i++;
            } while(true);
        while(fillBuf() > 0);
        throw new IOException("end of stream while looking for line boundary");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean hasMoreData() {
        boolean flag;
        if(mTail > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int nextInt() throws IOException {
        long l = nextLong();
        if(l > 0x7fffffffL || l < 0xffffffff80000000L)
            throw new NumberFormatException("parsed value larger than integer");
        else
            return (int)l;
    }

    public long nextLong() throws IOException {
        int i = 1;
        int j = nextTokenIndex();
        int k;
        long l;
        if(mBuffer[0] == 45)
            k = i;
        else
            k = 0;
        l = 0L;
        if(k == 0)
            i = 0;
        for(; i < j; i++) {
            int i1 = -48 + mBuffer[i];
            if(i1 < 0 || i1 > 9)
                throw invalidLong(j);
            long l1 = 10L * l - (long)i1;
            if(l1 > l)
                throw invalidLong(j);
            l = l1;
        }

        consumeBuf(j + 1);
        if(k == 0)
            l = -l;
        return l;
    }

    public String nextString() throws IOException {
        int i = nextTokenIndex();
        String s = new String(mBuffer, 0, i, Charsets.US_ASCII);
        consumeBuf(i + 1);
        return s;
    }

    private final byte mBuffer[];
    private boolean mLineFinished;
    private final InputStream mStream;
    private int mTail;
}
