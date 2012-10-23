// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.content.pm:
//            VerifierInfo

public class PackageInfoLite
    implements Parcelable {

    public PackageInfoLite() {
    }

    private PackageInfoLite(Parcel parcel) {
        packageName = parcel.readString();
        recommendedInstallLocation = parcel.readInt();
        installLocation = parcel.readInt();
        int i = parcel.readInt();
        if(i == 0) {
            verifiers = new VerifierInfo[0];
        } else {
            verifiers = new VerifierInfo[i];
            parcel.readTypedArray(verifiers, VerifierInfo.CREATOR);
        }
    }


    public int describeContents() {
        return 0;
    }

    public String toString() {
        return (new StringBuilder()).append("PackageInfoLite{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(packageName).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(packageName);
        parcel.writeInt(recommendedInstallLocation);
        parcel.writeInt(installLocation);
        if(verifiers == null || verifiers.length == 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(verifiers.length);
            parcel.writeTypedArray(verifiers, i);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PackageInfoLite createFromParcel(Parcel parcel) {
            return new PackageInfoLite(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PackageInfoLite[] newArray(int i) {
            return new PackageInfoLite[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public int installLocation;
    public String packageName;
    public int recommendedInstallLocation;
    public VerifierInfo verifiers[];

}
