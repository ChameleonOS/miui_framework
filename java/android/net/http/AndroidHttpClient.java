// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.ContentResolver;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.android.internal.http.HttpDateTime;
import com.android.internal.os.RuntimeInit;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.*;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.*;
import org.apache.http.protocol.*;

public final class AndroidHttpClient
    implements HttpClient {
    private class CurlLogger
        implements HttpRequestInterceptor {

        public void process(HttpRequest httprequest, HttpContext httpcontext) throws HttpException, IOException {
            LoggingConfiguration loggingconfiguration = curlConfiguration;
            if(loggingconfiguration != null && loggingconfiguration.isLoggable() && (httprequest instanceof HttpUriRequest))
                loggingconfiguration.println(AndroidHttpClient.toCurl((HttpUriRequest)httprequest, false));
        }

        final AndroidHttpClient this$0;

        private CurlLogger() {
            this$0 = AndroidHttpClient.this;
            super();
        }

    }

    private static class LoggingConfiguration {

        private boolean isLoggable() {
            return Log.isLoggable(tag, level);
        }

        private void println(String s) {
            Log.println(level, tag, s);
        }

        private final int level;
        private final String tag;



        private LoggingConfiguration(String s, int i) {
            tag = s;
            level = i;
        }

    }

    static class Injector {

        static String getUserAgent(String s) {
            if(s == null)
                s = RuntimeInit.callGetDefaultUserAgent();
            return s;
        }

        Injector() {
        }
    }


    private AndroidHttpClient(ClientConnectionManager clientconnectionmanager, HttpParams httpparams) {
        mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");
        _flddelegate = new DefaultHttpClient(clientconnectionmanager, httpparams) {

            protected HttpContext createHttpContext() {
                BasicHttpContext basichttpcontext = new BasicHttpContext();
                basichttpcontext.setAttribute("http.authscheme-registry", getAuthSchemes());
                basichttpcontext.setAttribute("http.cookiespec-registry", getCookieSpecs());
                basichttpcontext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
                return basichttpcontext;
            }

            protected BasicHttpProcessor createHttpProcessor() {
                BasicHttpProcessor basichttpprocessor = super.createHttpProcessor();
                basichttpprocessor.addRequestInterceptor(AndroidHttpClient.sThreadCheckInterceptor);
                basichttpprocessor.addRequestInterceptor(new CurlLogger());
                return basichttpprocessor;
            }

            final AndroidHttpClient this$0;

             {
                this$0 = AndroidHttpClient.this;
                super(clientconnectionmanager, httpparams);
            }
        };
    }

    public static AbstractHttpEntity getCompressedEntity(byte abyte0[], ContentResolver contentresolver) throws IOException {
        ByteArrayEntity bytearrayentity;
        if((long)abyte0.length < getMinGzipSize(contentresolver)) {
            bytearrayentity = new ByteArrayEntity(abyte0);
        } else {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
            gzipoutputstream.write(abyte0);
            gzipoutputstream.close();
            bytearrayentity = new ByteArrayEntity(bytearrayoutputstream.toByteArray());
            bytearrayentity.setContentEncoding("gzip");
        }
        return bytearrayentity;
    }

    public static long getMinGzipSize(ContentResolver contentresolver) {
        return DEFAULT_SYNC_MIN_GZIP_BYTES;
    }

    public static InputStream getUngzippedContent(HttpEntity httpentity) throws IOException {
        Object obj = httpentity.getContent();
        Object obj1;
        if(obj == null) {
            obj1 = obj;
        } else {
            Header header = httpentity.getContentEncoding();
            if(header == null) {
                obj1 = obj;
            } else {
                String s = header.getValue();
                if(s == null) {
                    obj1 = obj;
                } else {
                    if(s.contains("gzip"))
                        obj = new GZIPInputStream(((InputStream) (obj)));
                    obj1 = obj;
                }
            }
        }
        return ((InputStream) (obj1));
    }

    private static boolean isBinaryContent(HttpUriRequest httpurirequest) {
        boolean flag;
        Header aheader[];
        flag = true;
        aheader = httpurirequest.getHeaders("content-encoding");
        if(aheader == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        i1 = aheader.length;
        j1 = 0;
_L6:
        if(j1 >= i1) goto _L2; else goto _L3
_L3:
        if(!"gzip".equalsIgnoreCase(aheader[j1].getValue())) goto _L5; else goto _L4
_L4:
        return flag;
_L5:
        j1++;
          goto _L6
_L2:
        Header aheader1[] = httpurirequest.getHeaders("content-type");
        if(aheader1 == null) goto _L4; else goto _L7
_L7:
        int i;
        int j;
        i = aheader1.length;
        j = 0;
_L10:
        if(j >= i) goto _L4; else goto _L8
_L8:
        Header header;
        String as[];
        int k;
        int l;
        header = aheader1[j];
        as = textContentTypes;
        k = as.length;
        l = 0;
_L9:
label0:
        {
            if(l >= k)
                break MISSING_BLOCK_LABEL_140;
            String s = as[l];
            if(!header.getValue().startsWith(s))
                break label0;
            flag = false;
        }
          goto _L4
        l++;
          goto _L9
        j++;
          goto _L10
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest httprequest) {
        httprequest.addHeader("Accept-Encoding", "gzip");
    }

    public static AndroidHttpClient newInstance(String s) {
        return newInstance(s, null);
    }

    public static AndroidHttpClient newInstance(String s, Context context) {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, false);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 60000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 60000);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpClientParams.setRedirecting(basichttpparams, false);
        SSLSessionCache sslsessioncache;
        SchemeRegistry schemeregistry;
        if(context == null)
            sslsessioncache = null;
        else
            sslsessioncache = new SSLSessionCache(context);
        HttpProtocolParams.setUserAgent(basichttpparams, Injector.getUserAgent(s));
        schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(60000, sslsessioncache), 443));
        return new AndroidHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }

    public static long parseDate(String s) {
        return HttpDateTime.parse(s);
    }

    private static String toCurl(HttpUriRequest httpurirequest, boolean flag) throws IOException {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("curl ");
        Header aheader[] = httpurirequest.getAllHeaders();
        int i = aheader.length;
        int j = 0;
        while(j < i)  {
            Header header = aheader[j];
            if(flag || !header.getName().equals("Authorization") && !header.getName().equals("Cookie")) {
                stringbuilder.append("--header \"");
                stringbuilder.append(header.toString().trim());
                stringbuilder.append("\" ");
            }
            j++;
        }
        java.net.URI uri = httpurirequest.getURI();
        if(httpurirequest instanceof RequestWrapper) {
            HttpRequest httprequest = ((RequestWrapper)httpurirequest).getOriginal();
            if(httprequest instanceof HttpUriRequest)
                uri = ((HttpUriRequest)httprequest).getURI();
        }
        stringbuilder.append("\"");
        stringbuilder.append(uri);
        stringbuilder.append("\"");
        if(httpurirequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity httpentity = ((HttpEntityEnclosingRequest)httpurirequest).getEntity();
            if(httpentity != null && httpentity.isRepeatable())
                if(httpentity.getContentLength() < 1024L) {
                    ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                    httpentity.writeTo(bytearrayoutputstream);
                    if(isBinaryContent(httpurirequest)) {
                        String s1 = Base64.encodeToString(bytearrayoutputstream.toByteArray(), 2);
                        stringbuilder.insert(0, (new StringBuilder()).append("echo '").append(s1).append("' | base64 -d > /tmp/$$.bin; ").toString());
                        stringbuilder.append(" --data-binary @/tmp/$$.bin");
                    } else {
                        String s = bytearrayoutputstream.toString();
                        stringbuilder.append(" --data-ascii \"").append(s).append("\"");
                    }
                } else {
                    stringbuilder.append(" [TOO MUCH DATA TO INCLUDE]");
                }
        }
        return stringbuilder.toString();
    }

    public void close() {
        if(mLeakedException != null) {
            getConnectionManager().shutdown();
            mLeakedException = null;
        }
    }

    public void disableCurlLogging() {
        curlConfiguration = null;
    }

    public void enableCurlLogging(String s, int i) {
        if(s == null)
            throw new NullPointerException("name");
        if(i < 2 || i > 7) {
            throw new IllegalArgumentException("Level is out of range [2..7]");
        } else {
            curlConfiguration = new LoggingConfiguration(s, i);
            return;
        }
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler) throws IOException, ClientProtocolException {
        return _flddelegate.execute(httphost, httprequest, responsehandler);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext) throws IOException, ClientProtocolException {
        return _flddelegate.execute(httphost, httprequest, responsehandler, httpcontext);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler) throws IOException, ClientProtocolException {
        return _flddelegate.execute(httpurirequest, responsehandler);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext) throws IOException, ClientProtocolException {
        return _flddelegate.execute(httpurirequest, responsehandler, httpcontext);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest) throws IOException {
        return _flddelegate.execute(httphost, httprequest);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext) throws IOException {
        return _flddelegate.execute(httphost, httprequest, httpcontext);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest) throws IOException {
        return _flddelegate.execute(httpurirequest);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext) throws IOException {
        return _flddelegate.execute(httpurirequest, httpcontext);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if(mLeakedException != null) {
            Log.e("AndroidHttpClient", "Leak found", mLeakedException);
            mLeakedException = null;
        }
    }

    public ClientConnectionManager getConnectionManager() {
        return _flddelegate.getConnectionManager();
    }

    public HttpParams getParams() {
        return _flddelegate.getParams();
    }

    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 0L;
    private static final int SOCKET_OPERATION_TIMEOUT = 60000;
    private static final String TAG = "AndroidHttpClient";
    private static final HttpRequestInterceptor sThreadCheckInterceptor = new HttpRequestInterceptor() {

        public void process(HttpRequest httprequest, HttpContext httpcontext) {
            if(Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper())
                throw new RuntimeException("This thread forbids HTTP requests");
            else
                return;
        }

    };
    private static String textContentTypes[];
    private volatile LoggingConfiguration curlConfiguration;
    private final HttpClient _flddelegate;
    private RuntimeException mLeakedException;

    static  {
        DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
        String as[] = new String[3];
        as[0] = "text/";
        as[1] = "application/xml";
        as[2] = "application/json";
        textContentTypes = as;
    }



}
