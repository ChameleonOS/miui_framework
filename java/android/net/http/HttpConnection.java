// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.Context;
import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.params.BasicHttpParams;

// Referenced classes of package android.net.http:
//            Connection, AndroidHttpClientConnection, Request, EventHandler, 
//            RequestFeeder

class HttpConnection extends Connection {

    HttpConnection(Context context, HttpHost httphost, RequestFeeder requestfeeder) {
        super(context, httphost, requestfeeder);
    }

    void closeConnection() {
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
        return "http";
    }

    AndroidHttpClientConnection openConnection(Request request) throws IOException {
        EventHandler eventhandler = request.getEventHandler();
        super.mCertificate = null;
        eventhandler.certificate(super.mCertificate);
        AndroidHttpClientConnection androidhttpclientconnection = new AndroidHttpClientConnection();
        BasicHttpParams basichttpparams = new BasicHttpParams();
        Socket socket = new Socket(super.mHost.getHostName(), super.mHost.getPort());
        basichttpparams.setIntParameter("http.socket.buffer-size", 8192);
        androidhttpclientconnection.bind(socket, basichttpparams);
        return androidhttpclientconnection;
    }

    void restartConnection(boolean flag) {
    }
}
