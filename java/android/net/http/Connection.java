// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.Context;
import android.os.SystemClock;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.*;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package android.net.http:
//            Request, RequestFeeder, HttpConnection, HttpsConnection, 
//            ErrorStrings, EventHandler, SSLConnectionClosedByUserException, AndroidHttpClientConnection, 
//            SslCertificate

abstract class Connection {

    protected Connection(Context context, HttpHost httphost, RequestFeeder requestfeeder) {
        mHttpClientConnection = null;
        mCertificate = null;
        mActive = STATE_NORMAL;
        mContext = context;
        mHost = httphost;
        mRequestFeeder = requestfeeder;
        mCanPersist = false;
        mHttpContext = new BasicHttpContext(null);
    }

    private boolean clearPipe(LinkedList linkedlist) {
        boolean flag = true;
        RequestFeeder requestfeeder = mRequestFeeder;
        requestfeeder;
        JVM INSTR monitorenter ;
        while(!linkedlist.isEmpty())  {
            Request request = (Request)linkedlist.removeLast();
            mRequestFeeder.requeueRequest(request);
            flag = false;
        }
        if(flag)
            if(!mRequestFeeder.haveRequest(mHost))
                flag = true;
            else
                flag = false;
        return flag;
    }

    static Connection getConnection(Context context, HttpHost httphost, HttpHost httphost1, RequestFeeder requestfeeder) {
        Object obj;
        if(httphost.getSchemeName().equals("http"))
            obj = new android.net.http.HttpConnection(context, httphost, requestfeeder);
        else
            obj = new HttpsConnection(context, httphost, httphost1, requestfeeder);
        return ((Connection) (obj));
    }

    private boolean httpFailure(Request request, int i, Exception exception) {
        boolean flag = true;
        int j = 1 + request.mFailCount;
        request.mFailCount = j;
        if(j >= 2) {
            flag = false;
            String s;
            if(i < 0) {
                s = ErrorStrings.getString(i, mContext);
            } else {
                Throwable throwable = exception.getCause();
                if(throwable != null)
                    s = throwable.toString();
                else
                    s = exception.getMessage();
            }
            request.mEventHandler.error(i, s);
            request.complete();
        }
        closeConnection();
        mHttpContext.removeAttribute("http.connection");
        return flag;
    }

    private boolean keepAlive(HttpEntity httpentity, ProtocolVersion protocolversion, int i, HttpContext httpcontext) {
        int j;
        int k;
        HttpConnection httpconnection;
        j = 1;
        k = 0;
        httpconnection = (HttpConnection)httpcontext.getAttribute("http.connection");
        break MISSING_BLOCK_LABEL_20;
        if((httpconnection == null || httpconnection.isOpen()) && (httpentity == null || httpentity.getContentLength() >= 0L || httpentity.isChunked() && !protocolversion.lessEquals(HttpVersion.HTTP_1_0)) && i != j)
            if(i == 2) {
                k = j;
            } else {
                if(protocolversion.lessEquals(HttpVersion.HTTP_1_0))
                    j = 0;
                k = j;
            }
        return k;
    }

    private boolean openHttpConnection(Request request) {
        boolean flag1;
label0:
        {
            boolean flag;
            int i;
            Object obj;
label1:
            {
                flag = true;
                flag1 = false;
                SystemClock.uptimeMillis();
                i = 0;
                obj = null;
                try {
                    mCertificate = null;
                    mHttpClientConnection = openConnection(request);
                    if(mHttpClientConnection != null) {
                        mHttpClientConnection.setSocketTimeout(60000);
                        mHttpContext.setAttribute("http.connection", mHttpClientConnection);
                        break label1;
                    }
                    request.mFailCount = 2;
                    break label0;
                }
                catch(UnknownHostException unknownhostexception) {
                    i = -2;
                    obj = unknownhostexception;
                }
                catch(IllegalArgumentException illegalargumentexception) {
                    i = -6;
                    request.mFailCount = 2;
                    obj = illegalargumentexception;
                }
                catch(SSLConnectionClosedByUserException sslconnectionclosedbyuserexception) {
                    request.mFailCount = 2;
                    break label0;
                }
                catch(SSLHandshakeException sslhandshakeexception) {
                    request.mFailCount = 2;
                    i = -11;
                    obj = sslhandshakeexception;
                }
                catch(IOException ioexception) {
                    i = -6;
                    obj = ioexception;
                }
            }
            while(i != 0)  {
                if(request.mFailCount < 2) {
                    mRequestFeeder.requeueRequest(request);
                    request.mFailCount = 1 + request.mFailCount;
                } else {
                    httpFailure(request, i, ((Exception) (obj)));
                }
                if(i != 0)
                    flag = false;
                flag1 = flag;
                break label0;
            }
            flag1 = flag;
        }
        return flag1;
    }

    void cancel() {
        mActive = STATE_CANCEL_REQUESTED;
        closeConnection();
    }

    abstract void closeConnection();

    byte[] getBuf() {
        if(mBuf == null)
            mBuf = new byte[8192];
        return mBuf;
    }

    boolean getCanPersist() {
        return mCanPersist;
    }

    SslCertificate getCertificate() {
        return mCertificate;
    }

    HttpHost getHost() {
        return mHost;
    }

    HttpContext getHttpContext() {
        return mHttpContext;
    }

    abstract String getScheme();

    abstract AndroidHttpClientConnection openConnection(Request request) throws IOException;

    void processRequests(Request request) {
        int i = 0;
        Object obj = null;
        LinkedList linkedlist = new LinkedList();
        byte byte0 = 2;
        byte byte1 = 3;
        int j = 0;
        do {
            if(j == 3)
                break;
            if(mActive == STATE_CANCEL_REQUESTED) {
                boolean flag;
                int k;
                Request request1;
                IllegalStateException illegalstateexception;
                IOException ioexception;
                ParseException parseexception;
                Request request2;
                IllegalStateException illegalstateexception1;
                IOException ioexception1;
                HttpException httpexception;
                try {
                    Thread.sleep(100L);
                }
                catch(InterruptedException interruptedexception) { }
                mActive = STATE_NORMAL;
            }
            switch(j) {
            case 0: // '\0'
                if(linkedlist.size() == byte1) {
                    j = 1;
                } else {
                    if(request == null) {
                        request2 = mRequestFeeder.getRequest(mHost);
                    } else {
                        request2 = request;
                        request = null;
                    }
                    if(request2 == null) {
                        j = 2;
                    } else {
                        request2.setConnection(this);
                        if(request2.mCancelled)
                            request2.complete();
                        else
                        if((mHttpClientConnection == null || !mHttpClientConnection.isOpen()) && !openHttpConnection(request2)) {
                            j = 3;
                        } else {
                            request2.mEventHandler.certificate(mCertificate);
                            try {
                                request2.sendRequest(mHttpClientConnection);
                            }
                            // Misplaced declaration of an exception variable
                            catch(HttpException httpexception) {
                                obj = httpexception;
                                i = -1;
                            }
                            // Misplaced declaration of an exception variable
                            catch(IOException ioexception1) {
                                obj = ioexception1;
                                i = -7;
                            }
                            // Misplaced declaration of an exception variable
                            catch(IllegalStateException illegalstateexception1) {
                                obj = illegalstateexception1;
                                i = -7;
                            }
                            if(obj != null) {
                                if(httpFailure(request2, i, ((Exception) (obj))) && !request2.mCancelled)
                                    linkedlist.addLast(request2);
                                obj = null;
                                if(clearPipe(linkedlist))
                                    j = 3;
                                else
                                    j = 0;
                                byte1 = 1;
                                byte0 = byte1;
                            } else {
                                linkedlist.addLast(request2);
                                if(!mCanPersist)
                                    j = 1;
                            }
                        }
                    }
                }
                break;

            case 1: // '\001'
            case 2: // '\002'
                if(!mRequestFeeder.haveRequest(mHost))
                    flag = true;
                else
                    flag = false;
                k = linkedlist.size();
                if(j != 2 && k < byte0 && !flag && mCanPersist)
                    j = 0;
                else
                if(k == 0) {
                    if(flag)
                        j = 3;
                    else
                        j = 0;
                } else {
                    request1 = (Request)linkedlist.removeFirst();
                    try {
                        request1.readResponse(mHttpClientConnection);
                    }
                    // Misplaced declaration of an exception variable
                    catch(ParseException parseexception) {
                        obj = parseexception;
                        i = -7;
                    }
                    // Misplaced declaration of an exception variable
                    catch(IOException ioexception) {
                        obj = ioexception;
                        i = -7;
                    }
                    // Misplaced declaration of an exception variable
                    catch(IllegalStateException illegalstateexception) {
                        obj = illegalstateexception;
                        i = -7;
                    }
                    if(obj != null) {
                        if(httpFailure(request1, i, ((Exception) (obj))) && !request1.mCancelled) {
                            request1.reset();
                            linkedlist.addFirst(request1);
                        }
                        obj = null;
                        mCanPersist = false;
                    }
                    if(!mCanPersist) {
                        closeConnection();
                        mHttpContext.removeAttribute("http.connection");
                        clearPipe(linkedlist);
                        byte1 = 1;
                        byte0 = byte1;
                        j = 0;
                    }
                }
                break;
            }
        } while(true);
    }

    void setCanPersist(HttpEntity httpentity, ProtocolVersion protocolversion, int i) {
        mCanPersist = keepAlive(httpentity, protocolversion, i, mHttpContext);
    }

    void setCanPersist(boolean flag) {
        mCanPersist = flag;
    }

    /**
     * @deprecated Method toString is deprecated
     */

    public String toString() {
        this;
        JVM INSTR monitorenter ;
        String s = mHost.toString();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    private static final int DONE = 3;
    private static final int DRAIN = 2;
    private static final String HTTP_CONNECTION = "http.connection";
    private static final int MAX_PIPE = 3;
    private static final int MIN_PIPE = 2;
    private static final int READ = 1;
    private static final int RETRY_REQUEST_LIMIT = 2;
    private static final int SEND = 0;
    static final int SOCKET_TIMEOUT = 60000;
    private static int STATE_CANCEL_REQUESTED = 1;
    private static int STATE_NORMAL = 0;
    private static final String states[];
    private int mActive;
    private byte mBuf[];
    private boolean mCanPersist;
    protected SslCertificate mCertificate;
    Context mContext;
    HttpHost mHost;
    protected AndroidHttpClientConnection mHttpClientConnection;
    private HttpContext mHttpContext;
    RequestFeeder mRequestFeeder;

    static  {
        String as[] = new String[4];
        as[0] = "SEND";
        as[1] = "READ";
        as[2] = "DRAIN";
        as[3] = "DONE";
        states = as;
    }
}
