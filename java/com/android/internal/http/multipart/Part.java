// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.http.multipart;

import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.util.EncodingUtils;

public abstract class Part {

    public Part() {
    }

    public static String getBoundary() {
        return "----------------314159265358979323846";
    }

    public static long getLengthOfParts(Part apart[]) throws IOException {
        return getLengthOfParts(apart, DEFAULT_BOUNDARY_BYTES);
    }

    public static long getLengthOfParts(Part apart[], byte abyte0[]) throws IOException {
        long l;
        int i;
        LOG.trace("getLengthOfParts(Parts[])");
        if(apart == null)
            throw new IllegalArgumentException("Parts may not be null");
        l = 0L;
        i = 0;
_L3:
        long l2;
        if(i >= apart.length)
            break MISSING_BLOCK_LABEL_79;
        apart[i].setPartBoundary(abyte0);
        l2 = apart[i].length();
        if(l2 >= 0L) goto _L2; else goto _L1
_L1:
        long l1 = -1L;
_L4:
        return l1;
_L2:
        l += l2;
        i++;
          goto _L3
        l1 = l + (long)EXTRA_BYTES.length + (long)abyte0.length + (long)EXTRA_BYTES.length + (long)CRLF_BYTES.length;
          goto _L4
    }

    public static void sendParts(OutputStream outputstream, Part apart[]) throws IOException {
        sendParts(outputstream, apart, DEFAULT_BOUNDARY_BYTES);
    }

    public static void sendParts(OutputStream outputstream, Part apart[], byte abyte0[]) throws IOException {
        if(apart == null)
            throw new IllegalArgumentException("Parts may not be null");
        if(abyte0 == null || abyte0.length == 0)
            throw new IllegalArgumentException("partBoundary may not be empty");
        for(int i = 0; i < apart.length; i++) {
            apart[i].setPartBoundary(abyte0);
            apart[i].send(outputstream);
        }

        outputstream.write(EXTRA_BYTES);
        outputstream.write(abyte0);
        outputstream.write(EXTRA_BYTES);
        outputstream.write(CRLF_BYTES);
    }

    public abstract String getCharSet();

    public abstract String getContentType();

    public abstract String getName();

    protected byte[] getPartBoundary() {
        byte abyte0[];
        if(boundaryBytes == null)
            abyte0 = DEFAULT_BOUNDARY_BYTES;
        else
            abyte0 = boundaryBytes;
        return abyte0;
    }

    public abstract String getTransferEncoding();

    public boolean isRepeatable() {
        return true;
    }

    public long length() throws IOException {
        LOG.trace("enter length()");
        long l;
        if(lengthOfData() < 0L) {
            l = -1L;
        } else {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            sendStart(bytearrayoutputstream);
            sendDispositionHeader(bytearrayoutputstream);
            sendContentTypeHeader(bytearrayoutputstream);
            sendTransferEncodingHeader(bytearrayoutputstream);
            sendEndOfHeader(bytearrayoutputstream);
            sendEnd(bytearrayoutputstream);
            l = (long)bytearrayoutputstream.size() + lengthOfData();
        }
        return l;
    }

    protected abstract long lengthOfData() throws IOException;

    public void send(OutputStream outputstream) throws IOException {
        LOG.trace("enter send(OutputStream out)");
        sendStart(outputstream);
        sendDispositionHeader(outputstream);
        sendContentTypeHeader(outputstream);
        sendTransferEncodingHeader(outputstream);
        sendEndOfHeader(outputstream);
        sendData(outputstream);
        sendEnd(outputstream);
    }

    protected void sendContentTypeHeader(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendContentTypeHeader(OutputStream out)");
        String s = getContentType();
        if(s != null) {
            outputstream.write(CRLF_BYTES);
            outputstream.write(CONTENT_TYPE_BYTES);
            outputstream.write(EncodingUtils.getAsciiBytes(s));
            String s1 = getCharSet();
            if(s1 != null) {
                outputstream.write(CHARSET_BYTES);
                outputstream.write(EncodingUtils.getAsciiBytes(s1));
            }
        }
    }

    protected abstract void sendData(OutputStream outputstream) throws IOException;

    protected void sendDispositionHeader(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendDispositionHeader(OutputStream out)");
        outputstream.write(CONTENT_DISPOSITION_BYTES);
        outputstream.write(QUOTE_BYTES);
        outputstream.write(EncodingUtils.getAsciiBytes(getName()));
        outputstream.write(QUOTE_BYTES);
    }

    protected void sendEnd(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendEnd(OutputStream out)");
        outputstream.write(CRLF_BYTES);
    }

    protected void sendEndOfHeader(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendEndOfHeader(OutputStream out)");
        outputstream.write(CRLF_BYTES);
        outputstream.write(CRLF_BYTES);
    }

    protected void sendStart(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendStart(OutputStream out)");
        outputstream.write(EXTRA_BYTES);
        outputstream.write(getPartBoundary());
        outputstream.write(CRLF_BYTES);
    }

    protected void sendTransferEncodingHeader(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendTransferEncodingHeader(OutputStream out)");
        String s = getTransferEncoding();
        if(s != null) {
            outputstream.write(CRLF_BYTES);
            outputstream.write(CONTENT_TRANSFER_ENCODING_BYTES);
            outputstream.write(EncodingUtils.getAsciiBytes(s));
        }
    }

    void setPartBoundary(byte abyte0[]) {
        boundaryBytes = abyte0;
    }

    public String toString() {
        return getName();
    }

    protected static final String BOUNDARY = "----------------314159265358979323846";
    protected static final byte BOUNDARY_BYTES[];
    protected static final String CHARSET = "; charset=";
    protected static final byte CHARSET_BYTES[] = EncodingUtils.getAsciiBytes("; charset=");
    protected static final String CONTENT_DISPOSITION = "Content-Disposition: form-data; name=";
    protected static final byte CONTENT_DISPOSITION_BYTES[] = EncodingUtils.getAsciiBytes("Content-Disposition: form-data; name=");
    protected static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding: ";
    protected static final byte CONTENT_TRANSFER_ENCODING_BYTES[] = EncodingUtils.getAsciiBytes("Content-Transfer-Encoding: ");
    protected static final String CONTENT_TYPE = "Content-Type: ";
    protected static final byte CONTENT_TYPE_BYTES[] = EncodingUtils.getAsciiBytes("Content-Type: ");
    protected static final String CRLF = "\r\n";
    protected static final byte CRLF_BYTES[] = EncodingUtils.getAsciiBytes("\r\n");
    private static final byte DEFAULT_BOUNDARY_BYTES[];
    protected static final String EXTRA = "--";
    protected static final byte EXTRA_BYTES[] = EncodingUtils.getAsciiBytes("--");
    private static final Log LOG = LogFactory.getLog(com/android/internal/http/multipart/Part);
    protected static final String QUOTE = "\"";
    protected static final byte QUOTE_BYTES[] = EncodingUtils.getAsciiBytes("\"");
    private byte boundaryBytes[];

    static  {
        BOUNDARY_BYTES = EncodingUtils.getAsciiBytes("----------------314159265358979323846");
        DEFAULT_BOUNDARY_BYTES = BOUNDARY_BYTES;
    }
}
