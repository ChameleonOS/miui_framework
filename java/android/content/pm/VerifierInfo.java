// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import java.security.PublicKey;

public class VerifierInfo
    implements Parcelable {

    private VerifierInfo(Parcel parcel) {
        packageName = parcel.readString();
        publicKey = (PublicKey)parcel.readSerializable();
    }


    public VerifierInfo(String s, PublicKey publickey) {
        if(s == null || s.length() == 0)
            throw new IllegalArgumentException("packageName must not be null or empty");
        if(publickey == null) {
            throw new IllegalArgumentException("publicKey must not be null");
        } else {
            packageName = s;
            publicKey = publickey;
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(packageName);
        parcel.writeSerializable(publicKey);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VerifierInfo createFromParcel(Parcel parcel) {
            return new VerifierInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public VerifierInfo[] newArray(int i) {
            return new VerifierInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public final String packageName;
    public final PublicKey publicKey;

}
