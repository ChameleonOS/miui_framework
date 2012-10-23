// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import java.io.*;
import java.util.Arrays;

public class LimitedLengthInputStream extends FilterInputStream {

    public LimitedLengthInputStream(InputStream inputstream, long l, long l1) throws IOException {
        super(inputstream);
        if(inputstream == null)
            throw new IOException("in == null");
        if(l < 0L)
            throw new IOException("offset < 0");
        if(l1 < 0L)
            throw new IOException("length < 0");
        if(l1 > 0x7fffffffffffffffL - l) {
            throw new IOException("offset + length > Long.MAX_VALUE");
        } else {
            mEnd = l + l1;
            skip(l);
            mOffset = l;
            return;
        }
    }

    /**
     * @deprecated Method read is deprecated
     */

    public int read() throws IOException {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = mOffset;
        l1 = mEnd;
        if(l < l1) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return j;
_L2:
        int i;
        mOffset = 1L + mOffset;
        i = super.read();
        j = i;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int read(byte abyte0[]) throws IOException {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j) throws IOException {
        int k;
        if(mOffset >= mEnd) {
            k = -1;
        } else {
            Arrays.checkOffsetAndCount(abyte0.length, i, j);
            if(mOffset > 0x7fffffffffffffffL - (long)j)
                throw new IOException((new StringBuilder()).append("offset out of bounds: ").append(mOffset).append(" + ").append(j).toString());
            if(mOffset + (long)j > mEnd)
                j = (int)(mEnd - mOffset);
            k = super.read(abyte0, i, j);
            mOffset = mOffset + (long)k;
        }
        return k;
    }

    private final long mEnd;
    private long mOffset;
}
