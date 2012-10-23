// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.os.Parcel;
import android.os.Parcelable;

public class ObbInfo
    implements Parcelable {

    ObbInfo() {
    }

    private ObbInfo(Parcel parcel) {
        filename = parcel.readString();
        packageName = parcel.readString();
        version = parcel.readInt();
        flags = parcel.readInt();
        salt = parcel.createByteArray();
    }


    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("ObbInfo{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" packageName=");
        stringbuilder.append(packageName);
        stringbuilder.append(",version=");
        stringbuilder.append(version);
        stringbuilder.append(",flags=");
        stringbuilder.append(flags);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(filename);
        parcel.writeString(packageName);
        parcel.writeInt(version);
        parcel.writeInt(flags);
        parcel.writeByteArray(salt);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ObbInfo createFromParcel(Parcel parcel) {
            return new ObbInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ObbInfo[] newArray(int i) {
            return new ObbInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int OBB_OVERLAY = 1;
    public String filename;
    public int flags;
    public String packageName;
    public byte salt[];
    public int version;

}
