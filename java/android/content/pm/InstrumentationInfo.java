// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.content.pm:
//            PackageItemInfo

public class InstrumentationInfo extends PackageItemInfo
    implements Parcelable {

    public InstrumentationInfo() {
    }

    public InstrumentationInfo(InstrumentationInfo instrumentationinfo) {
        super(instrumentationinfo);
        targetPackage = instrumentationinfo.targetPackage;
        sourceDir = instrumentationinfo.sourceDir;
        publicSourceDir = instrumentationinfo.publicSourceDir;
        dataDir = instrumentationinfo.dataDir;
        nativeLibraryDir = instrumentationinfo.nativeLibraryDir;
        handleProfiling = instrumentationinfo.handleProfiling;
        functionalTest = instrumentationinfo.functionalTest;
    }

    private InstrumentationInfo(Parcel parcel) {
        boolean flag = true;
        super(parcel);
        targetPackage = parcel.readString();
        sourceDir = parcel.readString();
        publicSourceDir = parcel.readString();
        dataDir = parcel.readString();
        nativeLibraryDir = parcel.readString();
        boolean flag1;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        handleProfiling = flag1;
        if(parcel.readInt() == 0)
            flag = false;
        functionalTest = flag;
    }


    public int describeContents() {
        return 0;
    }

    public String toString() {
        return (new StringBuilder()).append("InstrumentationInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(super.packageName).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 0;
        super.writeToParcel(parcel, i);
        parcel.writeString(targetPackage);
        parcel.writeString(sourceDir);
        parcel.writeString(publicSourceDir);
        parcel.writeString(dataDir);
        parcel.writeString(nativeLibraryDir);
        int k;
        if(!handleProfiling)
            k = 0;
        else
            k = 1;
        parcel.writeInt(k);
        if(functionalTest)
            j = 1;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InstrumentationInfo createFromParcel(Parcel parcel) {
            return new InstrumentationInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public InstrumentationInfo[] newArray(int i) {
            return new InstrumentationInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public String dataDir;
    public boolean functionalTest;
    public boolean handleProfiling;
    public String nativeLibraryDir;
    public String publicSourceDir;
    public String sourceDir;
    public String targetPackage;

}
