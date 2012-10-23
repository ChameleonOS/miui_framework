// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.util.Arrays;
import java.util.jar.Attributes;

public class ManifestDigest
    implements Parcelable {

    private ManifestDigest(Parcel parcel) {
        mDigest = parcel.createByteArray();
    }


    ManifestDigest(byte abyte0[]) {
        mDigest = abyte0;
    }

    static ManifestDigest fromAttributes(Attributes attributes) {
        ManifestDigest manifestdigest = null;
        if(attributes != null) goto _L2; else goto _L1
_L1:
        return manifestdigest;
_L2:
        String s = null;
        int i = 0;
        do {
label0:
            {
                if(i < DIGEST_TYPES.length) {
                    String s1 = attributes.getValue(DIGEST_TYPES[i]);
                    if(s1 == null)
                        break label0;
                    s = s1;
                }
                if(s != null)
                    manifestdigest = new ManifestDigest(Base64.decode(s, 0));
            }
            if(true)
                continue;
            i++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof ManifestDigest) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        ManifestDigest manifestdigest = (ManifestDigest)obj;
        if(this == manifestdigest || Arrays.equals(mDigest, manifestdigest.mDigest))
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return Arrays.hashCode(mDigest);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(1 + ("ManifestDigest {mDigest=".length() + 3 * mDigest.length));
        stringbuilder.append("ManifestDigest {mDigest=");
        int i = mDigest.length;
        for(int j = 0; j < i; j++) {
            IntegralToString.appendByteAsHex(stringbuilder, mDigest[j], false);
            stringbuilder.append(',');
        }

        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(mDigest);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ManifestDigest createFromParcel(Parcel parcel) {
            return new ManifestDigest(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ManifestDigest[] newArray(int i) {
            return new ManifestDigest[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String DIGEST_TYPES[];
    private static final String TO_STRING_PREFIX = "ManifestDigest {mDigest=";
    private final byte mDigest[];

    static  {
        String as[] = new String[3];
        as[0] = "SHA1-Digest";
        as[1] = "SHA-Digest";
        as[2] = "MD5-Digest";
        DIGEST_TYPES = as;
    }
}
