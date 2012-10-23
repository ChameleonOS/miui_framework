// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.PatternMatcher;

public class PathPermission extends PatternMatcher {

    public PathPermission(Parcel parcel) {
        super(parcel);
        mReadPermission = parcel.readString();
        mWritePermission = parcel.readString();
    }

    public PathPermission(String s, int i, String s1, String s2) {
        super(s, i);
        mReadPermission = s1;
        mWritePermission = s2;
    }

    public String getReadPermission() {
        return mReadPermission;
    }

    public String getWritePermission() {
        return mWritePermission;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(mReadPermission);
        parcel.writeString(mWritePermission);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PathPermission createFromParcel(Parcel parcel) {
            return new PathPermission(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PathPermission[] newArray(int i) {
            return new PathPermission[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final String mReadPermission;
    private final String mWritePermission;

}
