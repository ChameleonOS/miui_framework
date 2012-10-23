// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.http.multipart;

import java.io.*;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EncodingUtils;

// Referenced classes of package com.android.internal.http.multipart:
//            Part

public class MultipartEntity extends AbstractHttpEntity {

    public MultipartEntity(Part apart[]) {
        contentConsumed = false;
        setContentType("multipart/form-data");
        if(apart == null) {
            throw new IllegalArgumentException("parts cannot be null");
        } else {
            parts = apart;
            params = null;
            return;
        }
    }

    public MultipartEntity(Part apart[], HttpParams httpparams) {
        contentConsumed = false;
        if(apart == null)
            throw new IllegalArgumentException("parts cannot be null");
        if(httpparams == null) {
            throw new IllegalArgumentException("params cannot be null");
        } else {
            parts = apart;
            params = httpparams;
            return;
        }
    }

    private static byte[] generateMultipartBoundary() {
        Random random = new Random();
        byte abyte0[] = new byte[30 + random.nextInt(11)];
        for(int i = 0; i < abyte0.length; i++)
            abyte0[i] = MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)];

        return abyte0;
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        if(!isRepeatable() && contentConsumed) {
            throw new IllegalStateException("Content has been consumed");
        } else {
            contentConsumed = true;
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            Part.sendParts(bytearrayoutputstream, parts, multipartBoundary);
            return new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
        }
    }

    public long getContentLength() {
        long l1 = Part.getLengthOfParts(parts, getMultipartBoundary());
        long l = l1;
_L2:
        return l;
        Exception exception;
        exception;
        log.error("An exception occurred while getting the length of the parts", exception);
        l = 0L;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Header getContentType() {
        StringBuffer stringbuffer = new StringBuffer("multipart/form-data");
        stringbuffer.append("; boundary=");
        stringbuffer.append(EncodingUtils.getAsciiString(getMultipartBoundary()));
        return new BasicHeader("Content-Type", stringbuffer.toString());
    }

    protected byte[] getMultipartBoundary() {
        if(multipartBoundary == null) {
            String s = null;
            if(params != null)
                s = (String)params.getParameter("http.method.multipart.boundary");
            if(s != null)
                multipartBoundary = EncodingUtils.getAsciiBytes(s);
            else
                multipartBoundary = generateMultipartBoundary();
        }
        return multipartBoundary;
    }

    public boolean isRepeatable() {
        int i = 0;
_L3:
        if(i >= parts.length)
            break MISSING_BLOCK_LABEL_33;
        if(parts[i].isRepeatable()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = true;
          goto _L4
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputstream) throws IOException {
        Part.sendParts(outputstream, parts, getMultipartBoundary());
    }

    public static final String MULTIPART_BOUNDARY = "http.method.multipart.boundary";
    private static byte MULTIPART_CHARS[] = EncodingUtils.getAsciiBytes("-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    private static final Log log = LogFactory.getLog(com/android/internal/http/multipart/MultipartEntity);
    private boolean contentConsumed;
    private byte multipartBoundary[];
    private HttpParams params;
    protected Part parts[];

}
