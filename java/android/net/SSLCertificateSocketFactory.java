// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.SystemProperties;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.harmony.xnet.provider.jsse.ClientSessionContext;
import org.apache.harmony.xnet.provider.jsse.OpenSSLContextImpl;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;
import org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache;

// Referenced classes of package android.net:
//            SSLSessionCache

public class SSLCertificateSocketFactory extends SSLSocketFactory {

    public SSLCertificateSocketFactory(int i) {
        this(i, null, true);
    }

    private SSLCertificateSocketFactory(int i, SSLSessionCache sslsessioncache, boolean flag) {
        SSLClientSessionCache sslclientsessioncache = null;
        super();
        mInsecureFactory = null;
        mSecureFactory = null;
        mTrustManagers = null;
        mKeyManagers = null;
        mNpnProtocols = null;
        mHandshakeTimeoutMillis = i;
        if(sslsessioncache != null)
            sslclientsessioncache = sslsessioncache.mSessionCache;
        mSessionCache = sslclientsessioncache;
        mSecure = flag;
    }

    public static SocketFactory getDefault(int i) {
        return new SSLCertificateSocketFactory(i, null, true);
    }

    public static SSLSocketFactory getDefault(int i, SSLSessionCache sslsessioncache) {
        return new SSLCertificateSocketFactory(i, sslsessioncache, true);
    }

    /**
     * @deprecated Method getDelegate is deprecated
     */

    private SSLSocketFactory getDelegate() {
        this;
        JVM INSTR monitorenter ;
        if(mSecure && !isSslCheckRelaxed())
            break MISSING_BLOCK_LABEL_77;
        if(mInsecureFactory != null) goto _L2; else goto _L1
_L1:
        if(!mSecure) goto _L4; else goto _L3
_L3:
        Log.w("SSLCertificateSocketFactory", "*** BYPASSING SSL SECURITY CHECKS (socket.relaxsslcheck=yes) ***");
_L5:
        mInsecureFactory = makeSocketFactory(mKeyManagers, INSECURE_TRUST_MANAGER);
_L2:
        SSLSocketFactory sslsocketfactory = mInsecureFactory;
_L6:
        this;
        JVM INSTR monitorexit ;
        return sslsocketfactory;
_L4:
        Log.w("SSLCertificateSocketFactory", "Bypassing SSL security checks at caller's request");
          goto _L5
        Exception exception;
        exception;
        throw exception;
        if(mSecureFactory == null)
            mSecureFactory = makeSocketFactory(mKeyManagers, mTrustManagers);
        sslsocketfactory = mSecureFactory;
          goto _L6
    }

    public static org.apache.http.conn.ssl.SSLSocketFactory getHttpSocketFactory(int i, SSLSessionCache sslsessioncache) {
        return new org.apache.http.conn.ssl.SSLSocketFactory(new SSLCertificateSocketFactory(i, sslsessioncache, true));
    }

    public static SSLSocketFactory getInsecure(int i, SSLSessionCache sslsessioncache) {
        return new SSLCertificateSocketFactory(i, sslsessioncache, false);
    }

    private static boolean isSslCheckRelaxed() {
        boolean flag;
        if("1".equals(SystemProperties.get("ro.debuggable")) && "yes".equals(SystemProperties.get("socket.relaxsslcheck")))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private SSLSocketFactory makeSocketFactory(KeyManager akeymanager[], TrustManager atrustmanager[]) {
        SSLSocketFactory sslsocketfactory1;
        OpenSSLContextImpl opensslcontextimpl = new OpenSSLContextImpl();
        opensslcontextimpl.engineInit(akeymanager, atrustmanager, null);
        opensslcontextimpl.engineGetClientSessionContext().setPersistentCache(mSessionCache);
        sslsocketfactory1 = opensslcontextimpl.engineGetSocketFactory();
        SSLSocketFactory sslsocketfactory = sslsocketfactory1;
_L2:
        return sslsocketfactory;
        KeyManagementException keymanagementexception;
        keymanagementexception;
        Log.wtf("SSLCertificateSocketFactory", keymanagementexception);
        sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        if(true) goto _L2; else goto _L1
_L1:
    }

    static transient byte[] toNpnProtocolsList(byte abyte0[][]) {
        if(abyte0.length == 0)
            throw new IllegalArgumentException("npnProtocols.length == 0");
        int i = 0;
        int j = abyte0.length;
        for(int k = 0; k < j; k++) {
            byte abyte3[] = abyte0[k];
            if(abyte3.length == 0 || abyte3.length > 255)
                throw new IllegalArgumentException((new StringBuilder()).append("s.length == 0 || s.length > 255: ").append(abyte3.length).toString());
            i += 1 + abyte3.length;
        }

        byte abyte1[] = new byte[i];
        int l = abyte0.length;
        int i1 = 0;
        int j1 = 0;
        for(; i1 < l; i1++) {
            byte abyte2[] = abyte0[i1];
            int k1 = j1 + 1;
            abyte1[j1] = (byte)abyte2.length;
            int l1 = abyte2.length;
            int i2 = 0;
            int j2;
            for(j1 = k1; i2 < l1; j1 = j2) {
                byte byte0 = abyte2[i2];
                j2 = j1 + 1;
                abyte1[j1] = byte0;
                i2++;
            }

        }

        return abyte1;
    }

    public static void verifyHostname(Socket socket, String s) throws IOException {
        if(!(socket instanceof SSLSocket))
            throw new IllegalArgumentException("Attempt to verify non-SSL socket");
        if(!isSslCheckRelaxed()) {
            SSLSocket sslsocket = (SSLSocket)socket;
            sslsocket.startHandshake();
            javax.net.ssl.SSLSession sslsession = sslsocket.getSession();
            if(sslsession == null)
                throw new SSLException("Cannot verify SSL socket without session");
            if(!HOSTNAME_VERIFIER.verify(s, sslsession))
                throw new SSLPeerUnverifiedException((new StringBuilder()).append("Cannot verify hostname: ").append(s).toString());
        }
    }

    public Socket createSocket() throws IOException {
        OpenSSLSocketImpl opensslsocketimpl = (OpenSSLSocketImpl)getDelegate().createSocket();
        opensslsocketimpl.setNpnProtocols(mNpnProtocols);
        opensslsocketimpl.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return opensslsocketimpl;
    }

    public Socket createSocket(String s, int i) throws IOException {
        OpenSSLSocketImpl opensslsocketimpl = (OpenSSLSocketImpl)getDelegate().createSocket(s, i);
        opensslsocketimpl.setNpnProtocols(mNpnProtocols);
        opensslsocketimpl.setHandshakeTimeout(mHandshakeTimeoutMillis);
        if(mSecure)
            verifyHostname(opensslsocketimpl, s);
        return opensslsocketimpl;
    }

    public Socket createSocket(String s, int i, InetAddress inetaddress, int j) throws IOException {
        OpenSSLSocketImpl opensslsocketimpl = (OpenSSLSocketImpl)getDelegate().createSocket(s, i, inetaddress, j);
        opensslsocketimpl.setNpnProtocols(mNpnProtocols);
        opensslsocketimpl.setHandshakeTimeout(mHandshakeTimeoutMillis);
        if(mSecure)
            verifyHostname(opensslsocketimpl, s);
        return opensslsocketimpl;
    }

    public Socket createSocket(InetAddress inetaddress, int i) throws IOException {
        OpenSSLSocketImpl opensslsocketimpl = (OpenSSLSocketImpl)getDelegate().createSocket(inetaddress, i);
        opensslsocketimpl.setNpnProtocols(mNpnProtocols);
        opensslsocketimpl.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return opensslsocketimpl;
    }

    public Socket createSocket(InetAddress inetaddress, int i, InetAddress inetaddress1, int j) throws IOException {
        OpenSSLSocketImpl opensslsocketimpl = (OpenSSLSocketImpl)getDelegate().createSocket(inetaddress, i, inetaddress1, j);
        opensslsocketimpl.setNpnProtocols(mNpnProtocols);
        opensslsocketimpl.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return opensslsocketimpl;
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag) throws IOException {
        OpenSSLSocketImpl opensslsocketimpl = (OpenSSLSocketImpl)getDelegate().createSocket(socket, s, i, flag);
        opensslsocketimpl.setNpnProtocols(mNpnProtocols);
        opensslsocketimpl.setHandshakeTimeout(mHandshakeTimeoutMillis);
        if(mSecure)
            verifyHostname(opensslsocketimpl, s);
        return opensslsocketimpl;
    }

    public String[] getDefaultCipherSuites() {
        return getDelegate().getSupportedCipherSuites();
    }

    public byte[] getNpnSelectedProtocol(Socket socket) {
        return ((OpenSSLSocketImpl)socket).getNpnSelectedProtocol();
    }

    public String[] getSupportedCipherSuites() {
        return getDelegate().getSupportedCipherSuites();
    }

    public void setKeyManagers(KeyManager akeymanager[]) {
        mKeyManagers = akeymanager;
        mSecureFactory = null;
        mInsecureFactory = null;
    }

    public void setNpnProtocols(byte abyte0[][]) {
        mNpnProtocols = toNpnProtocolsList(abyte0);
    }

    public void setTrustManagers(TrustManager atrustmanager[]) {
        mTrustManagers = atrustmanager;
        mSecureFactory = null;
    }

    private static final HostnameVerifier HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
    private static final TrustManager INSECURE_TRUST_MANAGER[];
    private static final String TAG = "SSLCertificateSocketFactory";
    private final int mHandshakeTimeoutMillis;
    private SSLSocketFactory mInsecureFactory;
    private KeyManager mKeyManagers[];
    private byte mNpnProtocols[];
    private final boolean mSecure;
    private SSLSocketFactory mSecureFactory;
    private final SSLClientSessionCache mSessionCache;
    private TrustManager mTrustManagers[];

    static  {
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
        INSECURE_TRUST_MANAGER = atrustmanager;
    }
}
