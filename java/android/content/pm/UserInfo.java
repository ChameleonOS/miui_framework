// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo
    implements Parcelable {

    public UserInfo() {
    }

    public UserInfo(int i, String s, int j) {
        id = i;
        name = s;
        flags = j;
    }

    public UserInfo(UserInfo userinfo) {
        name = userinfo.name;
        id = userinfo.id;
        flags = userinfo.flags;
    }

    private UserInfo(Parcel parcel) {
        id = parcel.readInt();
        name = parcel.readString();
        flags = parcel.readInt();
    }


    public int describeContents() {
        return 0;
    }

    public boolean isAdmin() {
        boolean flag;
        if((2 & flags) == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isGuest() {
        boolean flag;
        if((4 & flags) == 4)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isPrimary() {
        boolean flag = true;
        if((1 & flags) != flag)
            flag = false;
        return flag;
    }

    public String toString() {
        return (new StringBuilder()).append("UserInfo{").append(id).append(":").append(name).append(":").append(Integer.toHexString(flags)).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(flags);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_ADMIN = 2;
    public static final int FLAG_GUEST = 4;
    public static final int FLAG_PRIMARY = 1;
    public int flags;
    public int id;
    public String name;

}
