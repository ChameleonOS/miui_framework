// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import java.security.cert.X509Certificate;

// Referenced classes of package android.net.http:
//            SslCertificate

public class SslError {

    public SslError(int i, SslCertificate sslcertificate) {
        this(i, sslcertificate, "");
    }

    public SslError(int i, SslCertificate sslcertificate, String s) {
        if(!$assertionsDisabled && sslcertificate == null)
            throw new AssertionError();
        if(!$assertionsDisabled && s == null) {
            throw new AssertionError();
        } else {
            addError(i);
            mCertificate = sslcertificate;
            mUrl = s;
            return;
        }
    }

    public SslError(int i, X509Certificate x509certificate) {
        this(i, x509certificate, "");
    }

    public SslError(int i, X509Certificate x509certificate, String s) {
        this(i, new SslCertificate(x509certificate), s);
    }

    public static SslError SslErrorFromChromiumErrorCode(int i, SslCertificate sslcertificate, String s) {
        if(!$assertionsDisabled && (i < -299 || i > -200))
            throw new AssertionError();
        SslError sslerror;
        if(i == -200)
            sslerror = new SslError(2, sslcertificate, s);
        else
        if(i == -201)
            sslerror = new SslError(4, sslcertificate, s);
        else
        if(i == -202)
            sslerror = new SslError(3, sslcertificate, s);
        else
            sslerror = new SslError(5, sslcertificate, s);
        return sslerror;
    }

    public boolean addError(int i) {
        boolean flag;
        if(i >= 0 && i < 6)
            flag = true;
        else
            flag = false;
        if(flag)
            mErrors = mErrors | 1 << i;
        return flag;
    }

    public SslCertificate getCertificate() {
        return mCertificate;
    }

    public int getPrimaryError() {
        int i;
        if(mErrors == 0)
            break MISSING_BLOCK_LABEL_46;
        i = 5;
_L5:
        if(i < 0) goto _L2; else goto _L1
_L1:
        if((mErrors & 1 << i) == 0) goto _L4; else goto _L3
_L3:
        return i;
_L4:
        i--;
          goto _L5
_L2:
        if(!$assertionsDisabled)
            throw new AssertionError();
        i = -1;
          goto _L3
    }

    public String getUrl() {
        return mUrl;
    }

    public boolean hasError(int i) {
        boolean flag;
        if(i >= 0 && i < 6)
            flag = true;
        else
            flag = false;
        if(flag)
            if((mErrors & 1 << i) != 0)
                flag = true;
            else
                flag = false;
        return flag;
    }

    public String toString() {
        return (new StringBuilder()).append("primary error: ").append(getPrimaryError()).append(" certificate: ").append(getCertificate()).append(" on URL: ").append(getUrl()).toString();
    }

    static final boolean $assertionsDisabled = false;
    public static final int SSL_DATE_INVALID = 4;
    public static final int SSL_EXPIRED = 1;
    public static final int SSL_IDMISMATCH = 2;
    public static final int SSL_INVALID = 5;
    public static final int SSL_MAX_ERROR = 6;
    public static final int SSL_NOTYETVALID = 0;
    public static final int SSL_UNTRUSTED = 3;
    final SslCertificate mCertificate;
    int mErrors;
    final String mUrl;

    static  {
        boolean flag;
        if(!android/net/http/SslError.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }
}
