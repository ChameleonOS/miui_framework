// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ExtendedResponseCache;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.ResponseSource;
import java.net.URI;
import java.net.URLConnection;
import java.util.Map;
import libcore.io.DiskLruCache;
import libcore.io.IoUtils;

public final class HttpResponseCache extends ResponseCache
    implements Closeable, ExtendedResponseCache {

    private HttpResponseCache(File file, long l) throws IOException {
        _flddelegate = new libcore.net.http.HttpResponseCache(file, l);
    }

    public static HttpResponseCache getInstalled() {
        ResponseCache responsecache = ResponseCache.getDefault();
        HttpResponseCache httpresponsecache;
        if(responsecache instanceof HttpResponseCache)
            httpresponsecache = (HttpResponseCache)responsecache;
        else
            httpresponsecache = null;
        return httpresponsecache;
    }

    public static HttpResponseCache install(File file, long l) throws IOException {
        HttpResponseCache httpresponsecache = getInstalled();
        if(httpresponsecache == null) goto _L2; else goto _L1
_L1:
        DiskLruCache disklrucache = httpresponsecache._flddelegate.getCache();
        if(!disklrucache.getDirectory().equals(file) || disklrucache.maxSize() != l || disklrucache.isClosed()) goto _L4; else goto _L3
_L3:
        return httpresponsecache;
_L4:
        IoUtils.closeQuietly(httpresponsecache);
_L2:
        HttpResponseCache httpresponsecache1 = new HttpResponseCache(file, l);
        ResponseCache.setDefault(httpresponsecache1);
        httpresponsecache = httpresponsecache1;
        if(true) goto _L3; else goto _L5
_L5:
    }

    public void close() throws IOException {
        if(ResponseCache.getDefault() == this)
            ResponseCache.setDefault(null);
        _flddelegate.getCache().close();
    }

    public void delete() throws IOException {
        if(ResponseCache.getDefault() == this)
            ResponseCache.setDefault(null);
        _flddelegate.getCache().delete();
    }

    public void flush() {
        _flddelegate.getCache().flush();
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public CacheResponse get(URI uri, String s, Map map) throws IOException {
        return _flddelegate.get(uri, s, map);
    }

    public int getHitCount() {
        return _flddelegate.getHitCount();
    }

    public int getNetworkCount() {
        return _flddelegate.getNetworkCount();
    }

    public int getRequestCount() {
        return _flddelegate.getRequestCount();
    }

    public long maxSize() {
        return _flddelegate.getCache().maxSize();
    }

    public CacheRequest put(URI uri, URLConnection urlconnection) throws IOException {
        return _flddelegate.put(uri, urlconnection);
    }

    public long size() {
        return _flddelegate.getCache().size();
    }

    public void trackConditionalCacheHit() {
        _flddelegate.trackConditionalCacheHit();
    }

    public void trackResponse(ResponseSource responsesource) {
        _flddelegate.trackResponse(responsesource);
    }

    public void update(CacheResponse cacheresponse, HttpURLConnection httpurlconnection) {
        _flddelegate.update(cacheresponse, httpurlconnection);
    }

    private final libcore.net.http.HttpResponseCache _flddelegate;
}
