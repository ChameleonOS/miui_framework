// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.http.multipart;

import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.util.EncodingUtils;

// Referenced classes of package com.android.internal.http.multipart:
//            PartBase, FilePartSource, PartSource

public class FilePart extends PartBase {

    public FilePart(String s, PartSource partsource) {
        this(s, partsource, null, null);
    }

    public FilePart(String s, PartSource partsource, String s1, String s2) {
        if(s1 == null)
            s1 = "application/octet-stream";
        if(s2 == null)
            s2 = "ISO-8859-1";
        super(s, s1, s2, "binary");
        if(partsource == null) {
            throw new IllegalArgumentException("Source may not be null");
        } else {
            source = partsource;
            return;
        }
    }

    public FilePart(String s, File file) throws FileNotFoundException {
        this(s, ((PartSource) (new FilePartSource(file))), null, null);
    }

    public FilePart(String s, File file, String s1, String s2) throws FileNotFoundException {
        this(s, ((PartSource) (new FilePartSource(file))), s1, s2);
    }

    public FilePart(String s, String s1, File file) throws FileNotFoundException {
        this(s, ((PartSource) (new FilePartSource(s1, file))), null, null);
    }

    public FilePart(String s, String s1, File file, String s2, String s3) throws FileNotFoundException {
        this(s, ((PartSource) (new FilePartSource(s1, file))), s2, s3);
    }

    protected PartSource getSource() {
        LOG.trace("enter getSource()");
        return source;
    }

    protected long lengthOfData() {
        LOG.trace("enter lengthOfData()");
        return source.getLength();
    }

    protected void sendData(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendData(OutputStream out)");
        if(lengthOfData() != 0L) goto _L2; else goto _L1
_L1:
        LOG.debug("No data to send.");
_L4:
        return;
_L2:
        byte abyte0[];
        InputStream inputstream;
        abyte0 = new byte[4096];
        inputstream = source.createInputStream();
        Exception exception;
        do {
            int i = inputstream.read(abyte0);
            if(i < 0)
                break;
            outputstream.write(abyte0, 0, i);
        } while(true);
        inputstream.close();
        continue; /* Loop/switch isn't completed */
        exception;
        inputstream.close();
        throw exception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void sendDispositionHeader(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendDispositionHeader(OutputStream out)");
        super.sendDispositionHeader(outputstream);
        String s = source.getFileName();
        if(s != null) {
            outputstream.write(FILE_NAME_BYTES);
            outputstream.write(QUOTE_BYTES);
            outputstream.write(EncodingUtils.getAsciiBytes(s));
            outputstream.write(QUOTE_BYTES);
        }
    }

    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    protected static final String FILE_NAME = "; filename=";
    private static final byte FILE_NAME_BYTES[] = EncodingUtils.getAsciiBytes("; filename=");
    private static final Log LOG = LogFactory.getLog(com/android/internal/http/multipart/FilePart);
    private PartSource source;

}
