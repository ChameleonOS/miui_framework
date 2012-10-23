// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.Context;
import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;
import org.apache.http.*;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.RequestContent;

// Referenced classes of package android.net.http:
//            HttpLog, Connection, EventHandler, HttpsConnection, 
//            AndroidHttpClientConnection, Headers

class Request {

    Request(String s, HttpHost httphost, HttpHost httphost1, String s1, InputStream inputstream, int i, EventHandler eventhandler, 
            Map map) {
        mCancelled = false;
        mFailCount = 0;
        mReceivedBytes = 0;
        mClientResource = new Object();
        mLoadingPaused = false;
        mEventHandler = eventhandler;
        mHost = httphost;
        mProxyHost = httphost1;
        mPath = s1;
        mBodyProvider = inputstream;
        mBodyLength = i;
        if(inputstream != null || "POST".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        mHttpRequest = new BasicHttpRequest(s, getUri());
_L4:
        addHeader("Host", getHostPort());
        addHeader("Accept-Encoding", "gzip");
        addHeaders(map);
        return;
_L2:
        mHttpRequest = new BasicHttpEntityEnclosingRequest(s, getUri());
        if(inputstream != null)
            setBodyProvider(inputstream, i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static boolean canResponseHaveBody(HttpRequest httprequest, int i) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(!"HEAD".equalsIgnoreCase(httprequest.getRequestLine().getMethod()) && i >= 200 && i != 204 && i != 304)
            flag = true;
        return flag;
    }

    private void setBodyProvider(InputStream inputstream, int i) {
        if(!inputstream.markSupported()) {
            throw new IllegalArgumentException("bodyProvider must support mark()");
        } else {
            inputstream.mark(0x7fffffff);
            ((BasicHttpEntityEnclosingRequest)mHttpRequest).setEntity(new InputStreamEntity(inputstream, i));
            return;
        }
    }

    void addHeader(String s, String s1) {
        if(s == null) {
            HttpLog.e("Null http header name");
            throw new NullPointerException("Null http header name");
        }
        if(s1 == null || s1.length() == 0) {
            String s2 = (new StringBuilder()).append("Null or empty value for header \"").append(s).append("\"").toString();
            HttpLog.e(s2);
            throw new RuntimeException(s2);
        } else {
            mHttpRequest.addHeader(s, s1);
            return;
        }
    }

    void addHeaders(Map map) {
        if(map != null) {
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext())  {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                addHeader((String)entry.getKey(), (String)entry.getValue());
            }
        }
    }

    /**
     * @deprecated Method cancel is deprecated
     */

    void cancel() {
        this;
        JVM INSTR monitorenter ;
        mLoadingPaused = false;
        notify();
        mCancelled = true;
        if(mConnection != null)
            mConnection.cancel();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void complete() {
        Object obj = mClientResource;
        obj;
        JVM INSTR monitorenter ;
        mClientResource.notifyAll();
        return;
    }

    void error(int i, int j) {
        mEventHandler.error(i, mConnection.mContext.getText(j).toString());
    }

    EventHandler getEventHandler() {
        return mEventHandler;
    }

    String getHostPort() {
        String s = mHost.getSchemeName();
        int i = mHost.getPort();
        String s1;
        if(i != 80 && s.equals("http") || i != 443 && s.equals("https"))
            s1 = mHost.toHostString();
        else
            s1 = mHost.getHostName();
        return s1;
    }

    String getUri() {
        String s;
        if(mProxyHost == null || mHost.getSchemeName().equals("https"))
            s = mPath;
        else
            s = (new StringBuilder()).append(mHost.getSchemeName()).append("://").append(getHostPort()).append(mPath).toString();
        return s;
    }

    public void handleSslErrorResponse(boolean flag) {
        HttpsConnection httpsconnection = (HttpsConnection)(HttpsConnection)mConnection;
        if(httpsconnection != null)
            httpsconnection.restartConnection(flag);
    }

    void readResponse(AndroidHttpClientConnection androidhttpclientconnection) throws IOException, ParseException {
        if(!mCancelled) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Headers headers;
        StatusLine statusline;
        int i;
        HttpEntity httpentity;
        boolean flag;
        androidhttpclientconnection.flush();
        headers = new Headers();
        do {
            statusline = androidhttpclientconnection.parseResponseHeader(headers);
            i = statusline.getStatusCode();
        } while(i < 200);
        ProtocolVersion protocolversion = statusline.getProtocolVersion();
        mEventHandler.status(protocolversion.getMajor(), protocolversion.getMinor(), i, statusline.getReasonPhrase());
        mEventHandler.headers(headers);
        httpentity = null;
        if(canResponseHaveBody(mHttpRequest, i))
            httpentity = androidhttpclientconnection.receiveResponseEntity(headers);
        flag = "bytes".equalsIgnoreCase(headers.getAcceptRanges());
        if(httpentity == null) goto _L4; else goto _L3
_L3:
        InputStream inputstream;
        Header header;
        Object obj;
        byte abyte0[];
        int j;
        inputstream = httpentity.getContent();
        header = httpentity.getContentEncoding();
        obj = null;
        abyte0 = null;
        j = 0;
        if(header == null) goto _L6; else goto _L5
_L5:
        if(!header.getValue().equals("gzip")) goto _L6; else goto _L7
_L7:
        GZIPInputStream gzipinputstream = new GZIPInputStream(inputstream);
        obj = gzipinputstream;
_L14:
        int k;
        int l;
        abyte0 = mConnection.getBuf();
        k = 0;
        l = abyte0.length / 2;
_L17:
        if(k == -1) goto _L9; else goto _L8
_L8:
        this;
        JVM INSTR monitorenter ;
_L11:
        boolean flag1 = mLoadingPaused;
        Exception exception1;
        if(!flag1)
            break; /* Loop/switch isn't completed */
        try {
            wait();
        }
        catch(InterruptedException interruptedexception) {
            HttpLog.e((new StringBuilder()).append("Interrupted exception whilst network thread paused at WebCore's request. ").append(interruptedexception.getMessage()).toString());
        }
        finally {
            this;
        }
        if(true) goto _L11; else goto _L10
_L10:
        if(false) goto _L13; else goto _L12
_L13:
        JVM INSTR monitorexit ;
        throw exception1;
        EOFException eofexception;
        eofexception;
        if(j <= 0)
            break MISSING_BLOCK_LABEL_293;
        mEventHandler.data(abyte0, j);
        if(obj != null)
            ((InputStream) (obj)).close();
_L4:
        mConnection.setCanPersist(httpentity, statusline.getProtocolVersion(), headers.getConnectionType());
        mEventHandler.endData();
        complete();
          goto _L1
_L6:
        obj = inputstream;
          goto _L14
_L12:
        this;
        JVM INSTR monitorexit ;
        k = ((InputStream) (obj)).read(abyte0, j, abyte0.length - j);
        if(k != -1) {
            j += k;
            if(flag)
                mReceivedBytes = k + mReceivedBytes;
        }
          goto _L15
_L16:
        mEventHandler.data(abyte0, j);
        j = 0;
        break; /* Loop/switch isn't completed */
_L9:
        if(obj != null)
            ((InputStream) (obj)).close();
          goto _L4
        IOException ioexception;
        ioexception;
        if(i != 200 && i != 206)
            break MISSING_BLOCK_LABEL_488;
        if(!flag || j <= 0)
            break MISSING_BLOCK_LABEL_470;
        mEventHandler.data(abyte0, j);
        throw ioexception;
        Exception exception;
        exception;
        if(obj != null)
            ((InputStream) (obj)).close();
        throw exception;
        if(obj != null)
            ((InputStream) (obj)).close();
          goto _L4
_L15:
        if(k != -1 && j < l) goto _L17; else goto _L16
    }

    void reset() {
        mHttpRequest.removeHeaders("content-length");
        if(mBodyProvider != null) {
            try {
                mBodyProvider.reset();
            }
            catch(IOException ioexception) { }
            setBodyProvider(mBodyProvider, mBodyLength);
        }
        if(mReceivedBytes > 0) {
            mFailCount = 0;
            HttpLog.v((new StringBuilder()).append("*** Request.reset() to range:").append(mReceivedBytes).toString());
            mHttpRequest.setHeader("Range", (new StringBuilder()).append("bytes=").append(mReceivedBytes).append("-").toString());
        }
    }

    void sendRequest(AndroidHttpClientConnection androidhttpclientconnection) throws HttpException, IOException {
        if(!mCancelled) goto _L2; else goto _L1
_L1:
        return;
_L2:
        requestContentProcessor.process(mHttpRequest, mConnection.getHttpContext());
        androidhttpclientconnection.sendRequestHeader(mHttpRequest);
        if(mHttpRequest instanceof HttpEntityEnclosingRequest)
            androidhttpclientconnection.sendRequestEntity((HttpEntityEnclosingRequest)mHttpRequest);
        if(true) goto _L1; else goto _L3
_L3:
    }

    void setConnection(Connection connection) {
        mConnection = connection;
    }

    /**
     * @deprecated Method setLoadingPaused is deprecated
     */

    void setLoadingPaused(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        mLoadingPaused = flag;
        if(!mLoadingPaused)
            notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString() {
        return mPath;
    }

    void waitUntilComplete() {
        Object obj = mClientResource;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        try {
            mClientResource.wait();
        }
        catch(InterruptedException interruptedexception) { }
        finally {
            obj;
        }
        return;
        throw exception;
    }

    private static final String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
    private static final String CONTENT_LENGTH_HEADER = "content-length";
    private static final String HOST_HEADER = "Host";
    private static RequestContent requestContentProcessor = new RequestContent();
    private int mBodyLength;
    private InputStream mBodyProvider;
    volatile boolean mCancelled;
    private final Object mClientResource;
    private Connection mConnection;
    EventHandler mEventHandler;
    int mFailCount;
    HttpHost mHost;
    BasicHttpRequest mHttpRequest;
    private boolean mLoadingPaused;
    String mPath;
    HttpHost mProxyHost;
    private int mReceivedBytes;

}
