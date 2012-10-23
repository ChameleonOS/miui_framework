// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthenticatorDescription
    implements Parcelable {

    private AuthenticatorDescription(Parcel parcel) {
        boolean flag = true;
        super();
        type = parcel.readString();
        packageName = parcel.readString();
        labelId = parcel.readInt();
        iconId = parcel.readInt();
        smallIconId = parcel.readInt();
        accountPreferencesId = parcel.readInt();
        if(parcel.readByte() != flag)
            flag = false;
        customTokens = flag;
    }


    private AuthenticatorDescription(String s) {
        type = s;
        packageName = null;
        labelId = 0;
        iconId = 0;
        smallIconId = 0;
        accountPreferencesId = 0;
        customTokens = false;
    }

    public AuthenticatorDescription(String s, String s1, int i, int j, int k, int l) {
        this(s, s1, i, j, k, l, false);
    }

    public AuthenticatorDescription(String s, String s1, int i, int j, int k, int l, boolean flag) {
        if(s == null)
            throw new IllegalArgumentException("type cannot be null");
        if(s1 == null) {
            throw new IllegalArgumentException("packageName cannot be null");
        } else {
            type = s;
            packageName = s1;
            labelId = i;
            iconId = j;
            smallIconId = k;
            accountPreferencesId = l;
            customTokens = flag;
            return;
        }
    }

    public static AuthenticatorDescription newKey(String s) {
        if(s == null)
            throw new IllegalArgumentException("type cannot be null");
        else
            return new AuthenticatorDescription(s);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj == this)
            flag = true;
        else
        if(!(obj instanceof AuthenticatorDescription)) {
            flag = false;
        } else {
            AuthenticatorDescription authenticatordescription = (AuthenticatorDescription)obj;
            flag = type.equals(authenticatordescription.type);
        }
        return flag;
    }

    public int hashCode() {
        return type.hashCode();
    }

    public String toString() {
        return (new StringBuilder()).append("AuthenticatorDescription {type=").append(type).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(packageName);
        parcel.writeInt(labelId);
        parcel.writeInt(iconId);
        parcel.writeInt(smallIconId);
        parcel.writeInt(accountPreferencesId);
        int j;
        if(customTokens)
            j = 1;
        else
            j = 0;
        parcel.writeByte((byte)j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AuthenticatorDescription createFromParcel(Parcel parcel) {
            return new AuthenticatorDescription(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public AuthenticatorDescription[] newArray(int i) {
            return new AuthenticatorDescription[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public final int accountPreferencesId;
    public final boolean customTokens;
    public final int iconId;
    public final int labelId;
    public final String packageName;
    public final int smallIconId;
    public final String type;

}
