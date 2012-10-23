// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import android.os.StrictMode;
import java.io.*;

public class MemInfoReader {

    public MemInfoReader() {
        mBuffer = new byte[1024];
    }

    private long extractMemValue(byte abyte0[], int i) {
_L3:
        if(i >= abyte0.length || abyte0[i] == 10)
            break MISSING_BLOCK_LABEL_102;
        if(abyte0[i] < 48 || abyte0[i] > 57) goto _L2; else goto _L1
_L1:
        long l;
        int j = i;
        int k;
        for(k = i + 1; k < abyte0.length && abyte0[k] >= 48 && abyte0[k] <= 57; k++);
        l = 1024L * (long)Integer.parseInt(new String(abyte0, 0, j, k - j));
_L4:
        return l;
_L2:
        i++;
          goto _L3
        l = 0L;
          goto _L4
    }

    private boolean matchText(byte abyte0[], int i, String s) {
        boolean flag;
        int j;
        flag = false;
        j = s.length();
        if(i + j < abyte0.length) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        for(int k = 0; k < j; k++)
            if(abyte0[i + k] != s.charAt(k))
                continue; /* Loop/switch isn't completed */

        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public long getCachedSize() {
        return mCachedSize;
    }

    public long getFreeSize() {
        return mFreeSize;
    }

    public long getTotalSize() {
        return mTotalSize;
    }

    public void readMemInfo() {
        android.os.StrictMode.ThreadPolicy threadpolicy = StrictMode.allowThreadDiskReads();
        int i;
        int j;
        int k;
        int l;
        mTotalSize = 0L;
        mFreeSize = 0L;
        mCachedSize = 0L;
        FileInputStream fileinputstream = new FileInputStream("/proc/meminfo");
        i = fileinputstream.read(mBuffer);
        fileinputstream.close();
        j = mBuffer.length;
        k = 0;
        l = 0;
_L7:
        if(l >= i || k >= 3)
            break MISSING_BLOCK_LABEL_214;
        if(!matchText(mBuffer, l, "MemTotal")) goto _L2; else goto _L1
_L1:
        l += 8;
        mTotalSize = extractMemValue(mBuffer, l);
        k++;
_L5:
        for(; l < j && mBuffer[l] != 10; l++);
        break MISSING_BLOCK_LABEL_208;
_L2:
        if(!matchText(mBuffer, l, "MemFree")) goto _L4; else goto _L3
_L3:
        l += 7;
        mFreeSize = extractMemValue(mBuffer, l);
        k++;
          goto _L5
_L4:
        if(!matchText(mBuffer, l, "Cached")) goto _L5; else goto _L6
_L6:
        l += 6;
        mCachedSize = extractMemValue(mBuffer, l);
        k++;
          goto _L5
        l++;
          goto _L7
        StrictMode.setThreadPolicy(threadpolicy);
_L9:
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        StrictMode.setThreadPolicy(threadpolicy);
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        StrictMode.setThreadPolicy(threadpolicy);
        if(true) goto _L9; else goto _L8
_L8:
        Exception exception;
        exception;
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
    }

    byte mBuffer[];
    private long mCachedSize;
    private long mFreeSize;
    private long mTotalSize;
}
