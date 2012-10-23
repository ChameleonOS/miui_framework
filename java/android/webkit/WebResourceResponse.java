// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import java.io.InputStream;

public class WebResourceResponse {

    public WebResourceResponse(String s, String s1, InputStream inputstream) {
        mMimeType = s;
        mEncoding = s1;
        mInputStream = inputstream;
    }

    public InputStream getData() {
        return mInputStream;
    }

    public String getEncoding() {
        return mEncoding;
    }

    public String getMimeType() {
        return mMimeType;
    }

    public void setData(InputStream inputstream) {
        mInputStream = inputstream;
    }

    public void setEncoding(String s) {
        mEncoding = s;
    }

    public void setMimeType(String s) {
        mMimeType = s;
    }

    private String mEncoding;
    private InputStream mInputStream;
    private String mMimeType;
}
