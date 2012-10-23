// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.*;

// Referenced classes of package android.util:
//            Base64DataException

public class Base64OutputStream extends FilterOutputStream {

    public Base64OutputStream(OutputStream outputstream, int i) {
        this(outputstream, i, true);
    }

    public Base64OutputStream(OutputStream outputstream, int i, boolean flag) {
        super(outputstream);
        buffer = null;
        bpos = 0;
        flags = i;
        if(flag)
            coder = new Base64.Encoder(i, null);
        else
            coder = new Base64.Decoder(i, null);
    }

    private byte[] embiggen(byte abyte0[], int i) {
        if(abyte0 == null || abyte0.length < i)
            abyte0 = new byte[i];
        return abyte0;
    }

    private void flushBuffer() throws IOException {
        if(bpos > 0) {
            internalWrite(buffer, 0, bpos, false);
            bpos = 0;
        }
    }

    private void internalWrite(byte abyte0[], int i, int j, boolean flag) throws IOException {
        coder.output = embiggen(coder.output, coder.maxOutputSize(j));
        if(!coder.process(abyte0, i, j, flag)) {
            throw new Base64DataException("bad base-64");
        } else {
            out.write(coder.output, 0, coder.op);
            return;
        }
    }

    public void close() throws IOException {
        IOException ioexception;
        ioexception = null;
        try {
            flushBuffer();
            internalWrite(EMPTY, 0, 0, true);
        }
        catch(IOException ioexception1) {
            ioexception = ioexception1;
        }
        if((0x10 & flags) != 0)
            break MISSING_BLOCK_LABEL_45;
        out.close();
_L1:
        if(ioexception != null)
            throw ioexception;
        else
            return;
        try {
            out.flush();
        }
        catch(IOException ioexception2) {
            if(ioexception != null)
                ioexception = ioexception2;
        }
          goto _L1
    }

    public void write(int i) throws IOException {
        if(buffer == null)
            buffer = new byte[1024];
        if(bpos >= buffer.length) {
            internalWrite(buffer, 0, bpos, false);
            bpos = 0;
        }
        byte abyte0[] = buffer;
        int j = bpos;
        bpos = j + 1;
        abyte0[j] = (byte)i;
    }

    public void write(byte abyte0[], int i, int j) throws IOException {
        if(j > 0) {
            flushBuffer();
            internalWrite(abyte0, i, j, false);
        }
    }

    private static byte EMPTY[] = new byte[0];
    private int bpos;
    private byte buffer[];
    private final Base64.Coder coder;
    private final int flags;

}
