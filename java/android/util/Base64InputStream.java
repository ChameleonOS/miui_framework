// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.*;

// Referenced classes of package android.util:
//            Base64DataException

public class Base64InputStream extends FilterInputStream {

    public Base64InputStream(InputStream inputstream, int i) {
        this(inputstream, i, false);
    }

    public Base64InputStream(InputStream inputstream, int i, boolean flag) {
        super(inputstream);
        eof = false;
        inputBuffer = new byte[2048];
        if(flag)
            coder = new Base64.Encoder(i, null);
        else
            coder = new Base64.Decoder(i, null);
        coder.output = new byte[coder.maxOutputSize(2048)];
        outputStart = 0;
        outputEnd = 0;
    }

    private void refill() throws IOException {
        if(!eof) {
            int i = in.read(inputBuffer);
            boolean flag;
            if(i == -1) {
                eof = true;
                flag = coder.process(EMPTY, 0, 0, true);
            } else {
                flag = coder.process(inputBuffer, 0, i, false);
            }
            if(!flag)
                throw new Base64DataException("bad base-64");
            outputEnd = coder.op;
            outputStart = 0;
        }
    }

    public int available() {
        return outputEnd - outputStart;
    }

    public void close() throws IOException {
        in.close();
        inputBuffer = null;
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        if(outputStart >= outputEnd)
            refill();
        int j;
        if(outputStart >= outputEnd) {
            j = -1;
        } else {
            byte abyte0[] = coder.output;
            int i = outputStart;
            outputStart = i + 1;
            j = 0xff & abyte0[i];
        }
        return j;
    }

    public int read(byte abyte0[], int i, int j) throws IOException {
        if(outputStart >= outputEnd)
            refill();
        int k;
        if(outputStart >= outputEnd) {
            k = -1;
        } else {
            k = Math.min(j, outputEnd - outputStart);
            System.arraycopy(coder.output, outputStart, abyte0, i, k);
            outputStart = k + outputStart;
        }
        return k;
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long l) throws IOException {
        if(outputStart >= outputEnd)
            refill();
        long l1;
        if(outputStart >= outputEnd) {
            l1 = 0L;
        } else {
            l1 = Math.min(l, outputEnd - outputStart);
            outputStart = (int)(l1 + (long)outputStart);
        }
        return l1;
    }

    private static final int BUFFER_SIZE = 2048;
    private static byte EMPTY[] = new byte[0];
    private final Base64.Coder coder;
    private boolean eof;
    private byte inputBuffer[];
    private int outputEnd;
    private int outputStart;

}
