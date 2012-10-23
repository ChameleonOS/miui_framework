// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.security;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.*;
import android.os.*;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.security.*;
import java.security.cert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import libcore.util.Objects;
import org.apache.harmony.xnet.provider.jsse.OpenSSLEngine;
import org.apache.harmony.xnet.provider.jsse.TrustedCertificateStore;

// Referenced classes of package android.security:
//            IKeyChainService, KeyChainException, KeyChainAliasCallback

public final class KeyChain {
    public static final class KeyChainConnection
        implements Closeable {

        public void close() {
            context.unbindService(serviceConnection);
        }

        public IKeyChainService getService() {
            return service;
        }

        private final Context context;
        private final IKeyChainService service;
        private final ServiceConnection serviceConnection;

        private KeyChainConnection(Context context1, ServiceConnection serviceconnection, IKeyChainService ikeychainservice) {
            context = context1;
            serviceConnection = serviceconnection;
            service = ikeychainservice;
        }

    }

    private static class AliasResponse extends IKeyChainAliasCallback.Stub {

        public void alias(String s) {
            keyChainAliasResponse.alias(s);
        }

        private final KeyChainAliasCallback keyChainAliasResponse;

        private AliasResponse(KeyChainAliasCallback keychainaliascallback) {
            keyChainAliasResponse = keychainaliascallback;
        }

    }


    public KeyChain() {
    }

    public static KeyChainConnection bind(Context context) throws InterruptedException {
        if(context == null)
            throw new NullPointerException("context == null");
        ensureNotOnMainThread(context);
        final LinkedBlockingQueue q = new LinkedBlockingQueue(1);
        ServiceConnection serviceconnection = new ServiceConnection() {

            public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
                if(mConnectedAtLeastOnce)
                    break MISSING_BLOCK_LABEL_25;
                mConnectedAtLeastOnce = true;
                q.put(IKeyChainService.Stub.asInterface(ibinder));
_L2:
                return;
                InterruptedException interruptedexception;
                interruptedexception;
                if(true) goto _L2; else goto _L1
_L1:
            }

            public void onServiceDisconnected(ComponentName componentname) {
            }

            volatile boolean mConnectedAtLeastOnce;
            final BlockingQueue val$q;

             {
                q = blockingqueue;
                super();
                mConnectedAtLeastOnce = false;
            }
        };
        if(!context.bindService(new Intent(android/security/IKeyChainService.getName()), serviceconnection, 1))
            throw new AssertionError("could not bind to KeyChainService");
        else
            return new KeyChainConnection(context, serviceconnection, (IKeyChainService)q.take());
    }

    public static void choosePrivateKeyAlias(Activity activity, KeyChainAliasCallback keychainaliascallback, String as[], Principal aprincipal[], String s, int i, String s1) {
        if(activity == null)
            throw new NullPointerException("activity == null");
        if(keychainaliascallback == null) {
            throw new NullPointerException("response == null");
        } else {
            Intent intent = new Intent("com.android.keychain.CHOOSER");
            intent.putExtra("response", new AliasResponse(keychainaliascallback));
            intent.putExtra("host", s);
            intent.putExtra("port", i);
            intent.putExtra("alias", s1);
            intent.putExtra("sender", PendingIntent.getActivity(activity, 0, new Intent(), 0));
            activity.startActivity(intent);
            return;
        }
    }

    public static Intent createInstallIntent() {
        Intent intent = new Intent("android.credentials.INSTALL");
        intent.setClassName("com.android.certinstaller", "com.android.certinstaller.CertInstallerMain");
        return intent;
    }

    private static void ensureNotOnMainThread(Context context) {
        Looper looper = Looper.myLooper();
        if(looper != null && looper == context.getMainLooper())
            throw new IllegalStateException("calling this from your main thread can lead to deadlock");
        else
            return;
    }

    public static X509Certificate[] getCertificateChain(Context context, String s) throws KeyChainException, InterruptedException {
        KeyChainConnection keychainconnection;
        if(s == null)
            throw new NullPointerException("alias == null");
        keychainconnection = bind(context);
        ArrayList arraylist;
        TrustedCertificateStore trustedcertificatestore;
        int i;
        byte abyte0[] = keychainconnection.getService().getCertificate(s);
        arraylist = new ArrayList();
        arraylist.add(toCertificate(abyte0));
        trustedcertificatestore = new TrustedCertificateStore();
        i = 0;
_L4:
        X509Certificate x509certificate = (X509Certificate)arraylist.get(i);
        if(!Objects.equal(x509certificate.getSubjectX500Principal(), x509certificate.getIssuerX500Principal())) goto _L2; else goto _L1
_L1:
        X509Certificate ax509certificate[] = (X509Certificate[])arraylist.toArray(new X509Certificate[arraylist.size()]);
        X509Certificate x509certificate1;
        keychainconnection.close();
        return ax509certificate;
_L2:
        if((x509certificate1 = trustedcertificatestore.findIssuer(x509certificate)) == null) goto _L1; else goto _L3
_L3:
        arraylist.add(x509certificate1);
        i++;
          goto _L4
        RemoteException remoteexception;
        remoteexception;
        throw new KeyChainException(remoteexception);
        Exception exception;
        exception;
        keychainconnection.close();
        throw exception;
        RuntimeException runtimeexception;
        runtimeexception;
        throw new KeyChainException(runtimeexception);
    }

    public static PrivateKey getPrivateKey(Context context, String s) throws KeyChainException, InterruptedException {
        KeyChainConnection keychainconnection;
        if(s == null)
            throw new NullPointerException("alias == null");
        keychainconnection = bind(context);
        String s1;
        s1 = keychainconnection.getService().requestPrivateKey(s);
        if(s1 == null)
            throw new KeyChainException("keystore had a problem");
        break MISSING_BLOCK_LABEL_67;
        RemoteException remoteexception;
        remoteexception;
        throw new KeyChainException(remoteexception);
        Exception exception;
        exception;
        keychainconnection.close();
        throw exception;
        PrivateKey privatekey = OpenSSLEngine.getInstance("keystore").getPrivateKeyById(s1);
        keychainconnection.close();
        return privatekey;
        RuntimeException runtimeexception;
        runtimeexception;
        throw new KeyChainException(runtimeexception);
        InvalidKeyException invalidkeyexception;
        invalidkeyexception;
        throw new KeyChainException(invalidkeyexception);
    }

    private static X509Certificate toCertificate(byte abyte0[]) {
        if(abyte0 == null)
            throw new IllegalArgumentException("bytes == null");
        X509Certificate x509certificate;
        try {
            x509certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(abyte0));
        }
        catch(CertificateException certificateexception) {
            throw new AssertionError(certificateexception);
        }
        return x509certificate;
    }

    public static final String ACCOUNT_TYPE = "com.android.keychain";
    private static final String ACTION_CHOOSER = "com.android.keychain.CHOOSER";
    private static final String ACTION_INSTALL = "android.credentials.INSTALL";
    public static final String ACTION_STORAGE_CHANGED = "android.security.STORAGE_CHANGED";
    public static final String EXTRA_ALIAS = "alias";
    public static final String EXTRA_CERTIFICATE = "CERT";
    public static final String EXTRA_HOST = "host";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_PKCS12 = "PKCS12";
    public static final String EXTRA_PORT = "port";
    public static final String EXTRA_RESPONSE = "response";
    public static final String EXTRA_SENDER = "sender";
    private static final String TAG = "KeyChain";
}
