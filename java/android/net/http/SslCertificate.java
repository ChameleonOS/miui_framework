// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.android.org.bouncycastle.asn1.x509.X509Name;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class SslCertificate {
    public class DName {

        public String getCName() {
            String s;
            if(mCName != null)
                s = mCName;
            else
                s = "";
            return s;
        }

        public String getDName() {
            String s;
            if(mDName != null)
                s = mDName;
            else
                s = "";
            return s;
        }

        public String getOName() {
            String s;
            if(mOName != null)
                s = mOName;
            else
                s = "";
            return s;
        }

        public String getUName() {
            String s;
            if(mUName != null)
                s = mUName;
            else
                s = "";
            return s;
        }

        private String mCName;
        private String mDName;
        private String mOName;
        private String mUName;
        final SslCertificate this$0;

        public DName(String s) {
            this$0 = SslCertificate.this;
            super();
            if(s == null)
                break MISSING_BLOCK_LABEL_156;
            mDName = s;
            Vector vector;
            Vector vector1;
            int i;
            X509Name x509name = new X509Name(s);
            vector = x509name.getValues();
            vector1 = x509name.getOIDs();
            i = 0;
_L1:
            if(i >= vector1.size())
                break MISSING_BLOCK_LABEL_156;
            if(vector1.elementAt(i).equals(X509Name.CN))
                mCName = (String)vector.elementAt(i);
            else
            if(vector1.elementAt(i).equals(X509Name.O))
                mOName = (String)vector.elementAt(i);
            else
            if(vector1.elementAt(i).equals(X509Name.OU))
                mUName = (String)vector.elementAt(i);
            i++;
              goto _L1
            IllegalArgumentException illegalargumentexception;
            illegalargumentexception;
        }
    }


    public SslCertificate(String s, String s1, String s2, String s3) {
        this(s, s1, parseDate(s2), parseDate(s3), null);
    }

    public SslCertificate(String s, String s1, Date date, Date date1) {
        this(s, s1, date, date1, null);
    }

    private SslCertificate(String s, String s1, Date date, Date date1, X509Certificate x509certificate) {
        mIssuedTo = new DName(s);
        mIssuedBy = new DName(s1);
        mValidNotBefore = cloneDate(date);
        mValidNotAfter = cloneDate(date1);
        mX509Certificate = x509certificate;
    }

    public SslCertificate(X509Certificate x509certificate) {
        this(x509certificate.getSubjectDN().getName(), x509certificate.getIssuerDN().getName(), x509certificate.getNotBefore(), x509certificate.getNotAfter(), x509certificate);
    }

    private static Date cloneDate(Date date) {
        Date date1;
        if(date == null)
            date1 = null;
        else
            date1 = (Date)date.clone();
        return date1;
    }

    private static final String fingerprint(byte abyte0[]) {
        String s;
        if(abyte0 == null) {
            s = "";
        } else {
            StringBuilder stringbuilder = new StringBuilder();
            for(int i = 0; i < abyte0.length; i++) {
                IntegralToString.appendByteAsHex(stringbuilder, abyte0[i], true);
                if(i + 1 != abyte0.length)
                    stringbuilder.append(':');
            }

            s = stringbuilder.toString();
        }
        return s;
    }

    private String formatCertificateDate(Context context, Date date) {
        String s;
        if(date == null)
            s = "";
        else
            s = DateFormat.getDateFormat(context).format(date);
        return s;
    }

    private static String formatDate(Date date) {
        String s;
        if(date == null)
            s = "";
        else
            s = (new SimpleDateFormat(ISO_8601_DATE_FORMAT)).format(date);
        return s;
    }

    private static String getDigest(X509Certificate x509certificate, String s) {
        if(x509certificate != null) goto _L2; else goto _L1
_L1:
        String s1 = "";
_L4:
        return s1;
_L2:
        String s2;
        byte abyte0[] = x509certificate.getEncoded();
        s2 = fingerprint(MessageDigest.getInstance(s).digest(abyte0));
        s1 = s2;
        continue; /* Loop/switch isn't completed */
        CertificateEncodingException certificateencodingexception;
        certificateencodingexception;
        s1 = "";
        continue; /* Loop/switch isn't completed */
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        s1 = "";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static String getSerialNumber(X509Certificate x509certificate) {
        String s;
        if(x509certificate == null) {
            s = "";
        } else {
            BigInteger biginteger = x509certificate.getSerialNumber();
            if(biginteger == null)
                s = "";
            else
                s = fingerprint(biginteger.toByteArray());
        }
        return s;
    }

    private static Date parseDate(String s) {
        Date date1 = (new SimpleDateFormat(ISO_8601_DATE_FORMAT)).parse(s);
        Date date = date1;
_L2:
        return date;
        ParseException parseexception;
        parseexception;
        date = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static SslCertificate restoreState(Bundle bundle) {
        if(bundle != null) goto _L2; else goto _L1
_L1:
        SslCertificate sslcertificate = null;
_L4:
        return sslcertificate;
_L2:
        byte abyte0[];
        X509Certificate x509certificate;
        abyte0 = bundle.getByteArray("x509-certificate");
        if(abyte0 != null)
            break; /* Loop/switch isn't completed */
        x509certificate = null;
_L5:
        sslcertificate = new SslCertificate(bundle.getString("issued-to"), bundle.getString("issued-by"), parseDate(bundle.getString("valid-not-before")), parseDate(bundle.getString("valid-not-after")), x509certificate);
        if(true) goto _L4; else goto _L3
_L3:
        try {
            x509certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(abyte0));
        }
        catch(CertificateException certificateexception) {
            x509certificate = null;
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public static Bundle saveState(SslCertificate sslcertificate) {
        if(sslcertificate != null) goto _L2; else goto _L1
_L1:
        Bundle bundle = null;
_L4:
        return bundle;
_L2:
        bundle = new Bundle();
        bundle.putString("issued-to", sslcertificate.getIssuedTo().getDName());
        bundle.putString("issued-by", sslcertificate.getIssuedBy().getDName());
        bundle.putString("valid-not-before", sslcertificate.getValidNotBefore());
        bundle.putString("valid-not-after", sslcertificate.getValidNotAfter());
        X509Certificate x509certificate = sslcertificate.mX509Certificate;
        if(x509certificate != null)
            try {
                bundle.putByteArray("x509-certificate", x509certificate.getEncoded());
            }
            catch(CertificateEncodingException certificateencodingexception) { }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public DName getIssuedBy() {
        return mIssuedBy;
    }

    public DName getIssuedTo() {
        return mIssuedTo;
    }

    public String getValidNotAfter() {
        return formatDate(mValidNotAfter);
    }

    public Date getValidNotAfterDate() {
        return cloneDate(mValidNotAfter);
    }

    public String getValidNotBefore() {
        return formatDate(mValidNotBefore);
    }

    public Date getValidNotBeforeDate() {
        return cloneDate(mValidNotBefore);
    }

    public View inflateCertificateView(Context context) {
        View view = LayoutInflater.from(context).inflate(0x10900ac, null);
        DName dname = getIssuedTo();
        if(dname != null) {
            ((TextView)view.findViewById(0x1020337)).setText(dname.getCName());
            ((TextView)view.findViewById(0x1020339)).setText(dname.getOName());
            ((TextView)view.findViewById(0x102033b)).setText(dname.getUName());
        }
        ((TextView)view.findViewById(0x102033d)).setText(getSerialNumber(mX509Certificate));
        DName dname1 = getIssuedBy();
        if(dname1 != null) {
            ((TextView)view.findViewById(0x102033f)).setText(dname1.getCName());
            ((TextView)view.findViewById(0x1020341)).setText(dname1.getOName());
            ((TextView)view.findViewById(0x1020343)).setText(dname1.getUName());
        }
        String s = formatCertificateDate(context, getValidNotBeforeDate());
        ((TextView)view.findViewById(0x1020346)).setText(s);
        String s1 = formatCertificateDate(context, getValidNotAfterDate());
        ((TextView)view.findViewById(0x1020348)).setText(s1);
        ((TextView)view.findViewById(0x102034b)).setText(getDigest(mX509Certificate, "SHA256"));
        ((TextView)view.findViewById(0x102034d)).setText(getDigest(mX509Certificate, "SHA1"));
        return view;
    }

    public String toString() {
        return (new StringBuilder()).append("Issued to: ").append(mIssuedTo.getDName()).append(";\n").append("Issued by: ").append(mIssuedBy.getDName()).append(";\n").toString();
    }

    private static String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";
    private static final String ISSUED_BY = "issued-by";
    private static final String ISSUED_TO = "issued-to";
    private static final String VALID_NOT_AFTER = "valid-not-after";
    private static final String VALID_NOT_BEFORE = "valid-not-before";
    private static final String X509_CERTIFICATE = "x509-certificate";
    private final DName mIssuedBy;
    private final DName mIssuedTo;
    private final Date mValidNotAfter;
    private final Date mValidNotBefore;
    private final X509Certificate mX509Certificate;

}
