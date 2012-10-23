// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;
import org.apache.harmony.xnet.provider.jsse.*;
import org.apache.http.*;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package android.net.http:
//            Connection, AndroidHttpClientConnection, Headers, Request, 
//            CertificateChainValidator, EventHandler, SSLConnectionClosedByUserException, RequestFeeder, 
//            SslCertificate

public class HttpsConnection extends Connection {

    HttpsConnection(Context context, HttpHost httphost, HttpHost httphost1, RequestFeeder requestfeeder) {
        super(context, httphost, requestfeeder);
        mSuspendLock = new Object();
        mSuspended = false;
        mAborted = false;
        mProxyHost = httphost1;
    }

    /**
     * @deprecated Method getSocketFactory is deprecated
     */

    private static SSLSocketFactory getSocketFactory() {
        android/net/http/HttpsConnection;
        JVM INSTR monitorenter ;
        SSLSocketFactory sslsocketfactory = mSslSocketFactory;
        android/net/http/HttpsConnection;
        JVM INSTR monitorexit ;
        return sslsocketfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public static void initializeEngine(File file) {
        org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache sslclientsessioncache;
        sslclientsessioncache = null;
        if(file == null)
            break MISSING_BLOCK_LABEL_41;
        Log.d("HttpsConnection", (new StringBuilder()).append("Caching SSL sessions in ").append(file).append(".").toString());
        sslclientsessioncache = FileClientSessionCache.usingDirectory(file);
        OpenSSLContextImpl opensslcontextimpl;
        opensslcontextimpl = new OpenSSLContextImpl();
        TrustManager atrustmanager[] = new TrustManager[1];
        atrustmanager[0] = new X509TrustManager() {

            public void checkClientTrusted(X509Certificate ax509certificate[], String s) {
            }

            public void checkServerTrusted(X509Certificate ax509certificate[], String s) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

        };
        opensslcontextimpl.engineInit(null, atrustmanager, null);
        opensslcontextimpl.engineGetClientSessionContext().setPersistentCache(sslclientsessioncache);
        android/net/http/HttpsConnection;
        JVM INSTR monitorenter ;
        mSslSocketFactory = opensslcontextimpl.engineGetSocketFactory();
        return;
        KeyManagementException keymanagementexception;
        keymanagementexception;
        throw new RuntimeException(keymanagementexception);
        IOException ioexception;
        ioexception;
        throw new RuntimeException(ioexception);
    }

    void closeConnection() {
        if(mSuspended)
            restartConnection(false);
        if(super.mHttpClientConnection != null && super.mHttpClientConnection.isOpen())
            super.mHttpClientConnection.close();
_L1:
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
          goto _L1
    }

    String getScheme() {
        return "https";
    }

    AndroidHttpClientConnection openConnection(Request request) throws IOException {
        SSLSocket sslsocket = null;
        if(mProxyHost == null) goto _L2; else goto _L1
_L1:
        AndroidHttpClientConnection androidhttpclientconnection1 = null;
        Socket socket = new Socket(mProxyHost.getHostName(), mProxyHost.getPort());
        CertificateChainValidator certificatechainvalidator;
        String s1;
        SslError sslerror;
        AndroidHttpClientConnection androidhttpclientconnection;
        Object obj1;
        boolean flag;
        IOException ioexception2;
        AndroidHttpClientConnection androidhttpclientconnection2;
        BasicHttpParams basichttpparams1;
        Headers headers;
        BasicHttpRequest basichttprequest;
        IOException ioexception4;
        HttpException httpexception;
        ParseException parseexception;
        Header aheader[];
        int i;
        int j;
        StatusLine statusline;
        int k;
        try {
            socket.setSoTimeout(60000);
            androidhttpclientconnection2 = new AndroidHttpClientConnection();
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception2) {
            continue; /* Loop/switch isn't completed */
        }
        basichttpparams1 = new BasicHttpParams();
        HttpConnectionParams.setSocketBufferSize(basichttpparams1, 8192);
        androidhttpclientconnection2.bind(socket, basichttpparams1);
        headers = new Headers();
        basichttprequest = new BasicHttpRequest("CONNECT", super.mHost.toHostString());
        aheader = request.mHttpRequest.getAllHeaders();
        i = aheader.length;
        j = 0;
_L5:
        if(j >= i) goto _L4; else goto _L3
_L3:
        Header header = aheader[j];
        String s7 = header.getName().toLowerCase();
        if(s7.startsWith("proxy") || s7.equals("keep-alive") || s7.equals("host"))
            basichttprequest.addHeader(header);
        j++;
          goto _L5
        ioexception2;
_L14:
        if(androidhttpclientconnection1 != null)
            androidhttpclientconnection1.close();
        String s2 = ioexception2.getMessage();
        if(s2 == null)
            s2 = "failed to establish a connection to the proxy";
        IOException ioexception3 = new IOException(s2);
        throw ioexception3;
_L4:
        androidhttpclientconnection2.sendRequestHeader(basichttprequest);
        androidhttpclientconnection2.flush();
        do {
            statusline = androidhttpclientconnection2.parseResponseHeader(headers);
            k = statusline.getStatusCode();
        } while(k < 200);
        if(k != 200) goto _L7; else goto _L6
_L6:
        try {
            sslsocket = (SSLSocket)getSocketFactory().createSocket(socket, super.mHost.getHostName(), super.mHost.getPort(), true);
        }
        catch(IOException ioexception8) {
            if(false)
                throw null;
            String s6 = ioexception8.getMessage();
            if(s6 == null)
                s6 = "failed to create an SSL socket";
            IOException ioexception9 = new IOException(s6);
            throw ioexception9;
        }
_L11:
        certificatechainvalidator = CertificateChainValidator.getInstance();
        s1 = super.mHost.getHostName();
        sslerror = certificatechainvalidator.doHandshakeAndValidateServerCertificates(this, sslsocket, s1);
        if(sslerror == null) goto _L9; else goto _L8
_L8:
        synchronized(mSuspendLock) {
            mSuspended = true;
        }
        if(!request.getEventHandler().handleSslErrorRequest(sslerror))
            throw new IOException((new StringBuilder()).append("failed to handle ").append(sslerror).toString());
          goto _L10
        parseexception;
        String s5 = parseexception.getMessage();
        if(s5 == null)
            s5 = "failed to send a CONNECT request";
        IOException ioexception7 = new IOException(s5);
        throw ioexception7;
        httpexception;
        String s4 = httpexception.getMessage();
        if(s4 == null)
            s4 = "failed to send a CONNECT request";
        IOException ioexception6 = new IOException(s4);
        throw ioexception6;
        ioexception4;
        String s3 = ioexception4.getMessage();
        if(s3 == null)
            s3 = "failed to send a CONNECT request";
        IOException ioexception5 = new IOException(s3);
        throw ioexception5;
_L7:
        ProtocolVersion protocolversion = statusline.getProtocolVersion();
        request.mEventHandler.status(protocolversion.getMajor(), protocolversion.getMinor(), k, statusline.getReasonPhrase());
        request.mEventHandler.headers(headers);
        request.mEventHandler.endData();
        androidhttpclientconnection2.close();
        androidhttpclientconnection = null;
_L12:
        return androidhttpclientconnection;
_L2:
        try {
            sslsocket = (SSLSocket)getSocketFactory().createSocket(super.mHost.getHostName(), super.mHost.getPort());
            sslsocket.setSoTimeout(60000);
        }
        catch(IOException ioexception) {
            if(sslsocket != null)
                sslsocket.close();
            String s = ioexception.getMessage();
            if(s == null)
                s = "failed to create an SSL socket";
            IOException ioexception1 = new IOException(s);
            throw ioexception1;
        }
          goto _L11
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L10:
        obj1 = mSuspendLock;
        obj1;
        JVM INSTR monitorenter ;
        flag = mSuspended;
        BasicHttpParams basichttpparams;
        Exception exception1;
        if(flag)
            try {
                mSuspendLock.wait(0x927c0L);
                if(mSuspended) {
                    mSuspended = false;
                    mAborted = true;
                }
            }
            catch(InterruptedException interruptedexception) { }
            finally {
                obj1;
            }
        if(mAborted) {
            sslsocket.close();
            SSLConnectionClosedByUserException sslconnectionclosedbyuserexception = new SSLConnectionClosedByUserException("connection closed by the user");
            throw sslconnectionclosedbyuserexception;
        }
        if(true)
            break MISSING_BLOCK_LABEL_762;
        JVM INSTR monitorexit ;
        throw exception1;
        obj1;
        JVM INSTR monitorexit ;
_L9:
        androidhttpclientconnection = new AndroidHttpClientConnection();
        basichttpparams = new BasicHttpParams();
        basichttpparams.setIntParameter("http.socket.buffer-size", 8192);
        androidhttpclientconnection.bind(sslsocket, basichttpparams);
          goto _L12
        ioexception2;
        androidhttpclientconnection1 = androidhttpclientconnection2;
        if(true) goto _L14; else goto _L13
_L13:
    }

    void restartConnection(boolean flag) {
        boolean flag1 = false;
        Object obj = mSuspendLock;
        obj;
        JVM INSTR monitorenter ;
        if(mSuspended) {
            mSuspended = false;
            if(!flag)
                flag1 = true;
            mAborted = flag1;
            mSuspendLock.notify();
        }
        return;
    }

    void setCertificate(SslCertificate sslcertificate) {
        super.mCertificate = sslcertificate;
    }

    public volatile String toString() {
        return super.toString();
    }

    private static SSLSocketFactory mSslSocketFactory = null;
    private boolean mAborted;
    private HttpHost mProxyHost;
    private Object mSuspendLock;
    private boolean mSuspended;

    static  {
        initializeEngine(null);
    }
}
