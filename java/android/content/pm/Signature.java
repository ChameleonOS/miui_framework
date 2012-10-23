// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.ByteArrayInputStream;
import java.lang.ref.SoftReference;
import java.security.PublicKey;
import java.security.cert.*;
import java.util.Arrays;

public class Signature
    implements Parcelable {

    private Signature(Parcel parcel) {
        mSignature = parcel.createByteArray();
    }


    public Signature(String s) {
        byte abyte0[] = s.getBytes();
        int i = abyte0.length;
        if(i % 2 != 0)
            throw new IllegalArgumentException((new StringBuilder()).append("text size ").append(i).append(" is not even").toString());
        byte abyte1[] = new byte[i / 2];
        int j = 0;
        int k1;
        for(int k = 0; j < i; k = k1) {
            int l = j + 1;
            int i1 = parseHexDigit(abyte0[j]);
            j = l + 1;
            int j1 = parseHexDigit(abyte0[l]);
            k1 = k + 1;
            abyte1[k] = (byte)(j1 | i1 << 4);
        }

        mSignature = abyte1;
    }

    public Signature(byte abyte0[]) {
        mSignature = (byte[])abyte0.clone();
    }

    private static final int parseHexDigit(int i) {
        int j;
        if(48 <= i && i <= 57)
            j = i - 48;
        else
        if(97 <= i && i <= 102)
            j = 10 + (i - 97);
        else
        if(65 <= i && i <= 70)
            j = 10 + (i - 65);
        else
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid character ").append(i).append(" in hex string").toString());
        return j;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        flag = false;
        if(obj == null)
            break MISSING_BLOCK_LABEL_39;
        boolean flag1;
        Signature signature = (Signature)obj;
        if(this == signature)
            break MISSING_BLOCK_LABEL_37;
        flag1 = Arrays.equals(mSignature, signature.mSignature);
        if(!flag1)
            break MISSING_BLOCK_LABEL_39;
        flag = true;
_L2:
        return flag;
        ClassCastException classcastexception;
        classcastexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public PublicKey getPublicKey() throws CertificateException {
        return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(mSignature)).getPublicKey();
    }

    public int hashCode() {
        int i;
        if(mHaveHashCode) {
            i = mHashCode;
        } else {
            mHashCode = Arrays.hashCode(mSignature);
            mHaveHashCode = true;
            i = mHashCode;
        }
        return i;
    }

    public byte[] toByteArray() {
        byte abyte0[] = new byte[mSignature.length];
        System.arraycopy(mSignature, 0, abyte0, 0, mSignature.length);
        return abyte0;
    }

    public char[] toChars() {
        return toChars(null, null);
    }

    public char[] toChars(char ac[], int ai[]) {
        byte abyte0[] = mSignature;
        int i = abyte0.length;
        int j = i * 2;
        char ac1[];
        int k;
        if(ac == null || j > ac.length)
            ac1 = new char[j];
        else
            ac1 = ac;
        k = 0;
        while(k < i)  {
            byte byte0 = abyte0[k];
            int l = 0xf & byte0 >> 4;
            int i1 = k * 2;
            int j1;
            int k1;
            int l1;
            int i2;
            if(l >= 10)
                j1 = -10 + (l + 97);
            else
                j1 = l + 48;
            ac1[i1] = (char)j1;
            k1 = byte0 & 0xf;
            l1 = 1 + k * 2;
            if(k1 >= 10)
                i2 = -10 + (k1 + 97);
            else
                i2 = k1 + 48;
            ac1[l1] = (char)i2;
            k++;
        }
        if(ai != null)
            ai[0] = i;
        return ac1;
    }

    public String toCharsString() {
        String s;
        String s2;
        if(mStringRef == null)
            s = null;
        else
            s = (String)mStringRef.get();
        if(s != null) {
            s2 = s;
        } else {
            String s1 = new String(toChars());
            mStringRef = new SoftReference(s1);
            s2 = s1;
        }
        return s2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(mSignature);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Signature createFromParcel(Parcel parcel) {
            return new Signature(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Signature[] newArray(int i) {
            return new Signature[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private int mHashCode;
    private boolean mHaveHashCode;
    private final byte mSignature[];
    private SoftReference mStringRef;

}
