// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.os.Handler;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.apache.harmony.xnet.provider.jsse.*;

// Referenced classes of package android.webkit:
//            SslClientCertLookupTable, BrowserFrame

public final class ClientCertRequestHandler extends Handler {

    ClientCertRequestHandler(BrowserFrame browserframe, int i, String s, SslClientCertLookupTable sslclientcertlookuptable) {
        mBrowserFrame = browserframe;
        mHandle = i;
        mHostAndPort = s;
        mTable = sslclientcertlookuptable;
    }

    private void setSslClientCertFromCtx(final int ctx, final byte chainBytes[][]) {
        post(new Runnable() {

            public void run() {
                mBrowserFrame.nativeSslClientCert(mHandle, ctx, chainBytes);
            }

            final ClientCertRequestHandler this$0;
            final byte val$chainBytes[][];
            final int val$ctx;

             {
                this$0 = ClientCertRequestHandler.this;
                ctx = i;
                chainBytes = abyte0;
                super();
            }
        });
    }

    private void setSslClientCertFromPKCS8(final byte key[], final byte chainBytes[][]) {
        post(new Runnable() {

            public void run() {
                mBrowserFrame.nativeSslClientCert(mHandle, key, chainBytes);
            }

            final ClientCertRequestHandler this$0;
            final byte val$chainBytes[][];
            final byte val$key[];

             {
                this$0 = ClientCertRequestHandler.this;
                key = abyte0;
                chainBytes = abyte1;
                super();
            }
        });
    }

    public void cancel() {
        mTable.Deny(mHostAndPort);
        post(new Runnable() {

            public void run() {
                mBrowserFrame.nativeSslClientCert(mHandle, 0, (byte[][])null);
            }

            final ClientCertRequestHandler this$0;

             {
                this$0 = ClientCertRequestHandler.this;
                super();
            }
        });
    }

    public void ignore() {
        post(new Runnable() {

            public void run() {
                mBrowserFrame.nativeSslClientCert(mHandle, 0, (byte[][])null);
            }

            final ClientCertRequestHandler this$0;

             {
                this$0 = ClientCertRequestHandler.this;
                super();
            }
        });
    }

    public void proceed(PrivateKey privatekey, X509Certificate ax509certificate[]) {
        byte abyte0[][];
        try {
            abyte0 = NativeCrypto.encodeCertificates(ax509certificate);
            mTable.Allow(mHostAndPort, privatekey, abyte0);
            if(privatekey instanceof OpenSSLRSAPrivateKey) {
                setSslClientCertFromCtx(((OpenSSLRSAPrivateKey)privatekey).getPkeyContext(), abyte0);
                break MISSING_BLOCK_LABEL_95;
            }
            if(privatekey instanceof OpenSSLDSAPrivateKey) {
                setSslClientCertFromCtx(((OpenSSLDSAPrivateKey)privatekey).getPkeyContext(), abyte0);
                break MISSING_BLOCK_LABEL_95;
            }
        }
        catch(CertificateEncodingException certificateencodingexception) {
            post(new Runnable() {

                public void run() {
                    mBrowserFrame.nativeSslClientCert(mHandle, 0, (byte[][])null);
                }

                final ClientCertRequestHandler this$0;

             {
                this$0 = ClientCertRequestHandler.this;
                super();
            }
            });
            break MISSING_BLOCK_LABEL_95;
        }
        setSslClientCertFromPKCS8(privatekey.getEncoded(), abyte0);
    }

    private final BrowserFrame mBrowserFrame;
    private final int mHandle;
    private final String mHostAndPort;
    private final SslClientCertLookupTable mTable;


}
