// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;


// Referenced classes of package android.net.http:
//            EventHandler, HttpLog, SslCertificate, SslError, 
//            Headers

public class LoggingEventHandler
    implements EventHandler {

    public LoggingEventHandler() {
    }

    public void certificate(SslCertificate sslcertificate) {
    }

    public void data(byte abyte0[], int i) {
    }

    public void endData() {
    }

    public void error(int i, String s) {
    }

    public boolean handleSslErrorRequest(SslError sslerror) {
        return false;
    }

    public void headers(Headers headers1) {
    }

    public void locationChanged(String s, boolean flag) {
    }

    public void requestSent() {
        HttpLog.v("LoggingEventHandler:requestSent()");
    }

    public void status(int i, int j, int k, String s) {
    }
}
