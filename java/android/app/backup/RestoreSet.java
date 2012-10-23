// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.os.Parcel;
import android.os.Parcelable;

public class RestoreSet
    implements Parcelable {

    public RestoreSet() {
    }

    private RestoreSet(Parcel parcel) {
        name = parcel.readString();
        device = parcel.readString();
        token = parcel.readLong();
    }


    public RestoreSet(String s, String s1, long l) {
        name = s;
        device = s1;
        token = l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(device);
        parcel.writeLong(token);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RestoreSet createFromParcel(Parcel parcel) {
            return new RestoreSet(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public RestoreSet[] newArray(int i) {
            return new RestoreSet[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public String device;
    public String name;
    public long token;

}
