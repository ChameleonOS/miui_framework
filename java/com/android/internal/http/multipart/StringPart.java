// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.util.EncodingUtils;

// Referenced classes of package com.android.internal.http.multipart:
//            PartBase

public class StringPart extends PartBase {

    public StringPart(String s, String s1) {
        this(s, s1, null);
    }

    public StringPart(String s, String s1, String s2) {
        if(s2 == null)
            s2 = "US-ASCII";
        super(s, "text/plain", s2, "8bit");
        if(s1 == null)
            throw new IllegalArgumentException("Value may not be null");
        if(s1.indexOf('\0') != -1) {
            throw new IllegalArgumentException("NULs may not be present in string parts");
        } else {
            value = s1;
            return;
        }
    }

    private byte[] getContent() {
        if(content == null)
            content = EncodingUtils.getBytes(value, getCharSet());
        return content;
    }

    protected long lengthOfData() {
        LOG.trace("enter lengthOfData()");
        return (long)getContent().length;
    }

    protected void sendData(OutputStream outputstream) throws IOException {
        LOG.trace("enter sendData(OutputStream)");
        outputstream.write(getContent());
    }

    public void setCharSet(String s) {
        super.setCharSet(s);
        content = null;
    }

    public static final String DEFAULT_CHARSET = "US-ASCII";
    public static final String DEFAULT_CONTENT_TYPE = "text/plain";
    public static final String DEFAULT_TRANSFER_ENCODING = "8bit";
    private static final Log LOG = LogFactory.getLog(com/android/internal/http/multipart/StringPart);
    private byte content[];
    private String value;

}
