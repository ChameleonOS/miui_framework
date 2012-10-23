// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.security.Credentials;
import android.util.Log;
import com.android.org.bouncycastle.asn1.DERObject;
import com.android.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.android.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.org.bouncycastle.jce.netscape.NetscapeCertRequest;
import com.android.org.bouncycastle.util.encoders.Base64;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;

final class CertTool {

    private CertTool() {
    }

    static void addCertificate(Context context, String s, byte abyte0[]) {
        Credentials.getInstance().install(context, s, abyte0);
    }

    static String getCertType(String s) {
        return (String)sCertificateTypeMap.get(s);
    }

    static String[] getKeyStrengthList() {
        String as[] = new String[2];
        as[0] = "High Grade";
        as[1] = "Medium Grade";
        return as;
    }

    static String getSignedPublicKey(Context context, int i, String s) {
        KeyPairGenerator keypairgenerator = KeyPairGenerator.getInstance("RSA");
        if(i != 0) goto _L2; else goto _L1
_L1:
        char c = '\u0800';
_L3:
        String s1;
        keypairgenerator.initialize(c);
        KeyPair keypair = keypairgenerator.genKeyPair();
        NetscapeCertRequest netscapecertrequest = new NetscapeCertRequest(s, MD5_WITH_RSA, keypair.getPublic());
        netscapecertrequest.sign(keypair.getPrivate());
        byte abyte0[] = netscapecertrequest.toASN1Object().getDEREncoded();
        Credentials.getInstance().install(context, keypair);
        s1 = new String(Base64.encode(abyte0));
_L4:
        return s1;
_L2:
        c = '\u0400';
          goto _L3
        Exception exception;
        exception;
        Log.w("CertTool", exception);
        s1 = null;
          goto _L4
    }

    private static final String LOGTAG = "CertTool";
    private static final AlgorithmIdentifier MD5_WITH_RSA;
    private static HashMap sCertificateTypeMap;

    static  {
        MD5_WITH_RSA = new AlgorithmIdentifier(PKCSObjectIdentifiers.md5WithRSAEncryption);
        sCertificateTypeMap = new HashMap();
        sCertificateTypeMap.put("application/x-x509-ca-cert", "CERT");
        sCertificateTypeMap.put("application/x-x509-user-cert", "CERT");
        sCertificateTypeMap.put("application/x-pkcs12", "PKCS12");
    }
}
