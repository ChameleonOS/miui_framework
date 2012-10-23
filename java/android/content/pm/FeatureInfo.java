// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;

public class FeatureInfo
    implements Parcelable {

    public FeatureInfo() {
    }

    public FeatureInfo(FeatureInfo featureinfo) {
        name = featureinfo.name;
        reqGlEsVersion = featureinfo.reqGlEsVersion;
        flags = featureinfo.flags;
    }

    private FeatureInfo(Parcel parcel) {
        name = parcel.readString();
        reqGlEsVersion = parcel.readInt();
        flags = parcel.readInt();
    }


    public int describeContents() {
        return 0;
    }

    public String getGlEsVersion() {
        int i = (0xffff0000 & reqGlEsVersion) >> 16;
        int j = 0xffff & reqGlEsVersion;
        return (new StringBuilder()).append(String.valueOf(i)).append(".").append(String.valueOf(j)).toString();
    }

    public String toString() {
        String s;
        if(name != null)
            s = (new StringBuilder()).append("FeatureInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(name).append(" fl=0x").append(Integer.toHexString(flags)).append("}").toString();
        else
            s = (new StringBuilder()).append("FeatureInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" glEsVers=").append(getGlEsVersion()).append(" fl=0x").append(Integer.toHexString(flags)).append("}").toString();
        return s;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(reqGlEsVersion);
        parcel.writeInt(flags);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FeatureInfo createFromParcel(Parcel parcel) {
            return new FeatureInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public FeatureInfo[] newArray(int i) {
            return new FeatureInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_REQUIRED = 1;
    public static final int GL_ES_VERSION_UNDEFINED;
    public int flags;
    public String name;
    public int reqGlEsVersion;

}
