// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.test;

import java.io.*;

class LineReader {

    LineReader(InputStream inputstream) {
        buffer = new byte[4096];
        inStream = inputstream;
    }

    String getNextLine() {
        return getNextLine(false);
    }

    String getNextLine(boolean flag) {
        String s;
        int i;
        s = null;
        i = 0;
_L8:
        int k = inStream.read();
        if(k >= 0) goto _L2; else goto _L1
_L1:
        i;
_L5:
        return s;
_L2:
        if(!flag || k != 26) goto _L4; else goto _L3
_L3:
        int j = i;
_L9:
        String s1 = new String(buffer, 0, j, "US-ASCII");
        s = s1;
          goto _L5
_L4:
        if(k != 13 && k != 10) goto _L7; else goto _L6
_L6:
        if(i != 0) goto _L3; else goto _L8
_L7:
        byte abyte0[] = buffer;
        byte byte0;
        j = i + 1;
        byte0 = (byte)k;
        abyte0[i] = byte0;
        i = j;
          goto _L8
        IOException ioexception;
        ioexception;
        i;
          goto _L5
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        j = i;
_L10:
        System.err.println("ATChannel: buffer overflow");
          goto _L9
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        System.err.println("ATChannel: implausable UnsupportedEncodingException");
          goto _L5
        IndexOutOfBoundsException indexoutofboundsexception1;
        indexoutofboundsexception1;
          goto _L10
        IOException ioexception1;
        ioexception1;
          goto _L5
    }

    String getNextLineCtrlZ() {
        return getNextLine(true);
    }

    static final int BUFFER_SIZE = 4096;
    byte buffer[];
    InputStream inStream;
}
