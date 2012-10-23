// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;
import org.apache.harmony.security.provider.cert.X509CertImpl;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;
import org.apache.harmony.xnet.provider.jsse.TrustManagerImpl;

// Referenced classes of package android.net.http:
//            SslError, SslCertificate, HttpsConnection

public class CertificateChainValidator {

    private CertificateChainValidator() {
    }

    private void closeSocketThrowException(SSLSocket sslsocket, String s) throws IOException {
        if(sslsocket != null) {
            SSLSession sslsession = sslsocket.getSession();
            if(sslsession != null)
                sslsession.invalidate();
            sslsocket.close();
        }
        throw new SSLHandshakeException(s);
    }

    private void closeSocketThrowException(SSLSocket sslsocket, String s, String s1) throws IOException {
        if(s == null)
            s = s1;
        closeSocketThrowException(sslsocket, s);
    }

    public static CertificateChainValidator getInstance() {
        return sInstance;
    }

    public static void handleTrustStorageUpdate() {
        X509TrustManager x509trustmanager = SSLParametersImpl.getDefaultTrustManager();
        if(x509trustmanager instanceof TrustManagerImpl)
            ((TrustManagerImpl)x509trustmanager).handleTrustStorageUpdate();
_L2:
        return;
        KeyManagementException keymanagementexception;
        keymanagementexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static SslError verifyServerCertificates(byte abyte0[][], String s, String s1) throws IOException {
        if(abyte0 == null || abyte0.length == 0)
            throw new IllegalArgumentException("bad certificate chain");
        X509Certificate ax509certificate[] = new X509Certificate[abyte0.length];
        for(int i = 0; i < abyte0.length; i++)
            ax509certificate[i] = new X509CertImpl(abyte0[i]);

        return verifyServerDomainAndCertificates(ax509certificate, s, s1);
    }

    private static SslError verifyServerDomainAndCertificates(X509Certificate ax509certificate[], String s, String s1) throws IOException {
        boolean flag;
        X509Certificate x509certificate;
        flag = false;
        x509certificate = ax509certificate[0];
        if(x509certificate == null)
            throw new IllegalArgumentException("certificate for this site is null");
        if(s != null && !s.isEmpty() && sVerifier.verify(s, x509certificate))
            flag = true;
        if(flag) goto _L2; else goto _L1
_L1:
        SslError sslerror = new SslError(2, x509certificate);
_L4:
        return sslerror;
_L2:
        SSLParametersImpl.getDefaultTrustManager().checkServerTrusted(ax509certificate, s1);
        sslerror = null;
        continue; /* Loop/switch isn't completed */
        GeneralSecurityException generalsecurityexception;
        generalsecurityexception;
        sslerror = new SslError(3, x509certificate);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public SslError doHandshakeAndValidateServerCertificates(HttpsConnection httpsconnection, SSLSocket sslsocket, String s) throws IOException {
        java.security.cert.Certificate acertificate[];
        if(!sslsocket.getSession().isValid())
            closeSocketThrowException(sslsocket, "failed to perform SSL handshake");
        acertificate = sslsocket.getSession().getPeerCertificates();
        if(acertificate != null && acertificate.length != 0) goto _L2; else goto _L1
_L1:
        closeSocketThrowException(sslsocket, "failed to retrieve peer certificates");
_L4:
        return verifyServerDomainAndCertificates((X509Certificate[])(X509Certificate[])acertificate, s, "RSA");
_L2:
        if(httpsconnection != null && acertificate[0] != null)
            httpsconnection.setCertificate(new SslCertificate((X509Certificate)acertificate[0]));
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final CertificateChainValidator sInstance = new CertificateChainValidator();
    private static final DefaultHostnameVerifier sVerifier = new DefaultHostnameVerifier();

}
