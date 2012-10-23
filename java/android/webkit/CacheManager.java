// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.net.http.Headers;
import android.util.Log;
import java.io.*;
import java.util.Map;

public final class CacheManager {
    public static class CacheResult {

        public String getContentDisposition() {
            return contentdisposition;
        }

        public long getContentLength() {
            return contentLength;
        }

        public String getETag() {
            return etag;
        }

        public String getEncoding() {
            return encoding;
        }

        public long getExpires() {
            return expires;
        }

        public String getExpiresString() {
            return expiresString;
        }

        public int getHttpStatusCode() {
            return httpStatusCode;
        }

        public InputStream getInputStream() {
            return inStream;
        }

        public String getLastModified() {
            return lastModified;
        }

        public String getLocalPath() {
            return localPath;
        }

        public String getLocation() {
            return location;
        }

        public String getMimeType() {
            return mimeType;
        }

        public OutputStream getOutputStream() {
            return outStream;
        }

        public void setContentLength(long l) {
            contentLength = l;
        }

        public void setEncoding(String s) {
            encoding = s;
        }

        public void setInputStream(InputStream inputstream) {
            inStream = inputstream;
        }

        long contentLength;
        String contentdisposition;
        String crossDomain;
        String encoding;
        String etag;
        long expires;
        String expiresString;
        int httpStatusCode;
        InputStream inStream;
        String lastModified;
        String localPath;
        String location;
        String mimeType;
        File outFile;
        OutputStream outStream;

        public CacheResult() {
        }
    }


    public CacheManager() {
    }

    public static boolean cacheDisabled() {
        return false;
    }

    static CacheResult createCacheFile(String s, int i, Headers headers, String s1, boolean flag) {
        return null;
    }

    public static boolean endCacheTransaction() {
        return false;
    }

    static CacheResult getCacheFile(String s, long l, Map map) {
        CacheResult cacheresult = nativeGetCacheResult(s);
        if(cacheresult != null) goto _L2; else goto _L1
_L1:
        cacheresult = null;
_L4:
        return cacheresult;
_L2:
        File file = new File(mBaseDir, cacheresult.localPath);
        cacheresult.inStream = new FileInputStream(file);
        FileNotFoundException filenotfoundexception;
        if(map != null && cacheresult.expires >= 0L && cacheresult.expires <= System.currentTimeMillis())
            if(cacheresult.lastModified == null && cacheresult.etag == null) {
                cacheresult = null;
            } else {
                if(cacheresult.etag != null)
                    map.put("if-none-match", cacheresult.etag);
                if(cacheresult.lastModified != null)
                    map.put("if-modified-since", cacheresult.lastModified);
            }
        continue; /* Loop/switch isn't completed */
        filenotfoundexception;
        Log.v("cache", (new StringBuilder()).append("getCacheFile(): Failed to open file: ").append(filenotfoundexception).toString());
        cacheresult = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static CacheResult getCacheFile(String s, Map map) {
        return getCacheFile(s, 0L, map);
    }

    public static File getCacheFileBaseDir() {
        return mBaseDir;
    }

    static void init(Context context) {
        mBaseDir = new File(context.getCacheDir(), "webviewCacheChromiumStaging");
        if(!mBaseDir.exists())
            mBaseDir.mkdirs();
    }

    private static native CacheResult nativeGetCacheResult(String s);

    static boolean removeAllCacheFiles() {
        (new Thread(new Runnable() {

            public void run() {
                String as[];
                int i;
                as = CacheManager.mBaseDir.list();
                if(as == null)
                    break MISSING_BLOCK_LABEL_78;
                i = 0;
_L1:
                if(i >= as.length)
                    break MISSING_BLOCK_LABEL_78;
                File file = new File(CacheManager.mBaseDir, as[i]);
                if(!file.delete())
                    Log.e("cache", (new StringBuilder()).append(file.getPath()).append(" delete failed.").toString());
                i++;
                  goto _L1
                SecurityException securityexception;
                securityexception;
            }

        })).start();
        return true;
    }

    static void saveCacheFile(String s, long l, CacheResult cacheresult) {
        cacheresult.outStream.close();
        if(!$assertionsDisabled)
            throw new AssertionError();
        break MISSING_BLOCK_LABEL_23;
        IOException ioexception;
        ioexception;
    }

    public static void saveCacheFile(String s, CacheResult cacheresult) {
        saveCacheFile(s, 0L, cacheresult);
    }

    public static boolean startCacheTransaction() {
        return false;
    }

    static final boolean $assertionsDisabled = false;
    static final String HEADER_KEY_IFMODIFIEDSINCE = "if-modified-since";
    static final String HEADER_KEY_IFNONEMATCH = "if-none-match";
    private static final String LOGTAG = "cache";
    private static File mBaseDir;

    static  {
        boolean flag;
        if(!android/webkit/CacheManager.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }

}
