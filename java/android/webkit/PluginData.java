// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import java.io.InputStream;
import java.util.Map;

public final class PluginData {

    public PluginData(InputStream inputstream, long l, Map map, int i) {
        mStream = inputstream;
        mContentLength = l;
        mHeaders = map;
        mStatusCode = i;
    }

    public long getContentLength() {
        return mContentLength;
    }

    public Map getHeaders() {
        return mHeaders;
    }

    public InputStream getInputStream() {
        return mStream;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    private long mContentLength;
    private Map mHeaders;
    private int mStatusCode;
    private InputStream mStream;
}
