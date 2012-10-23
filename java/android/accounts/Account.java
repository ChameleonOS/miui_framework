// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class Account
    implements Parcelable {

    public Account(Parcel parcel) {
        name = parcel.readString();
        type = parcel.readString();
    }

    public Account(String s, String s1) {
        if(TextUtils.isEmpty(s))
            throw new IllegalArgumentException((new StringBuilder()).append("the name must not be empty: ").append(s).toString());
        if(TextUtils.isEmpty(s1)) {
            throw new IllegalArgumentException((new StringBuilder()).append("the type must not be empty: ").append(s1).toString());
        } else {
            name = s;
            type = s1;
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(obj != this) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(obj instanceof Account)) {
            flag = false;
        } else {
            Account account = (Account)obj;
            if(!name.equals(account.name) || !type.equals(account.type))
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return 31 * (527 + name.hashCode()) + type.hashCode();
    }

    public String toString() {
        return (new StringBuilder()).append("Account {name=").append(name).append(", type=").append(type).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(type);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Account createFromParcel(Parcel parcel) {
            return new Account(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Account[] newArray(int i) {
            return new Account[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public final String name;
    public final String type;

}
