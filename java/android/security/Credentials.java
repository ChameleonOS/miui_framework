// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.security;

import android.content.*;
import android.util.Log;
import com.android.org.bouncycastle.openssl.PEMReader;
import com.android.org.bouncycastle.openssl.PEMWriter;
import java.io.*;
import java.nio.charset.Charsets;
import java.security.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.security:
//            KeyChain

public class Credentials {

    public Credentials() {
    }

    public static List convertFromPem(byte abyte0[]) throws IOException {
        PEMReader pemreader = new PEMReader(new InputStreamReader(new ByteArrayInputStream(abyte0), Charsets.US_ASCII));
        ArrayList arraylist = new ArrayList();
        do {
            Object obj = pemreader.readObject();
            if(obj != null) {
                arraylist.add(obj);
            } else {
                pemreader.close();
                return arraylist;
            }
        } while(true);
    }

    public static transient byte[] convertToPem(Object aobj[]) throws IOException {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PEMWriter pemwriter = new PEMWriter(new OutputStreamWriter(bytearrayoutputstream, Charsets.US_ASCII));
        int i = aobj.length;
        for(int j = 0; j < i; j++)
            pemwriter.writeObject(aobj[j]);

        pemwriter.close();
        return bytearrayoutputstream.toByteArray();
    }

    public static Credentials getInstance() {
        if(singleton == null)
            singleton = new Credentials();
        return singleton;
    }

    public void install(Context context) {
        context.startActivity(KeyChain.createInstallIntent());
_L1:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.w("Credentials", activitynotfoundexception.toString());
          goto _L1
    }

    public void install(Context context, String s, byte abyte0[]) {
        Intent intent = KeyChain.createInstallIntent();
        intent.putExtra(s, abyte0);
        context.startActivity(intent);
_L1:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.w("Credentials", activitynotfoundexception.toString());
          goto _L1
    }

    public void install(Context context, KeyPair keypair) {
        Intent intent = KeyChain.createInstallIntent();
        intent.putExtra("PKEY", keypair.getPrivate().getEncoded());
        intent.putExtra("KEY", keypair.getPublic().getEncoded());
        context.startActivity(intent);
_L1:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.w("Credentials", activitynotfoundexception.toString());
          goto _L1
    }

    public void unlock(Context context) {
        context.startActivity(new Intent("com.android.credentials.UNLOCK"));
_L1:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.w("Credentials", activitynotfoundexception.toString());
          goto _L1
    }

    public static final String CA_CERTIFICATE = "CACERT_";
    public static final String EXTENSION_CER = ".cer";
    public static final String EXTENSION_CRT = ".crt";
    public static final String EXTENSION_P12 = ".p12";
    public static final String EXTENSION_PFX = ".pfx";
    public static final String EXTRA_CA_CERTIFICATES_DATA = "ca_certificates_data";
    public static final String EXTRA_CA_CERTIFICATES_NAME = "ca_certificates_name";
    public static final String EXTRA_PRIVATE_KEY = "PKEY";
    public static final String EXTRA_PUBLIC_KEY = "KEY";
    public static final String EXTRA_USER_CERTIFICATE_DATA = "user_certificate_data";
    public static final String EXTRA_USER_CERTIFICATE_NAME = "user_certificate_name";
    public static final String EXTRA_USER_PRIVATE_KEY_DATA = "user_private_key_data";
    public static final String EXTRA_USER_PRIVATE_KEY_NAME = "user_private_key_name";
    public static final String INSTALL_ACTION = "android.credentials.INSTALL";
    private static final String LOGTAG = "Credentials";
    public static final String UNLOCK_ACTION = "com.android.credentials.UNLOCK";
    public static final String USER_CERTIFICATE = "USRCERT_";
    public static final String USER_PRIVATE_KEY = "USRPKEY_";
    public static final String VPN = "VPN_";
    public static final String WIFI = "WIFI_";
    private static Credentials singleton;
}
