// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;


// Referenced classes of package android.net.http:
//            SslCertificate, SslError, Headers

public interface EventHandler {

    public abstract void certificate(SslCertificate sslcertificate);

    public abstract void data(byte abyte0[], int i);

    public abstract void endData();

    public abstract void error(int i, String s);

    public abstract boolean handleSslErrorRequest(SslError sslerror);

    public abstract void headers(Headers headers1);

    public abstract void status(int i, int j, int k, String s);

    public static final int ERROR = -1;
    public static final int ERROR_AUTH = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_IO = -7;
    public static final int ERROR_LOOKUP = -2;
    public static final int ERROR_PROXYAUTH = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int FILE_ERROR = -13;
    public static final int FILE_NOT_FOUND_ERROR = -14;
    public static final int OK = 0;
    public static final int TOO_MANY_REQUESTS_ERROR = -15;
}
