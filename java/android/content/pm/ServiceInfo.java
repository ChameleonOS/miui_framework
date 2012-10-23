// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

// Referenced classes of package android.content.pm:
//            ComponentInfo, PackageItemInfo

public class ServiceInfo extends ComponentInfo
    implements Parcelable {

    public ServiceInfo() {
    }

    public ServiceInfo(ServiceInfo serviceinfo) {
        super(serviceinfo);
        permission = serviceinfo.permission;
        flags = serviceinfo.flags;
    }

    private ServiceInfo(Parcel parcel) {
        super(parcel);
        permission = parcel.readString();
        flags = parcel.readInt();
    }


    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        super.dumpFront(printer, s);
        printer.println((new StringBuilder()).append(s).append("permission=").append(permission).toString());
        printer.println((new StringBuilder()).append(s).append("flags=0x").append(Integer.toHexString(flags)).toString());
    }

    public String toString() {
        return (new StringBuilder()).append("ServiceInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(super.name).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(permission);
        parcel.writeInt(flags);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ServiceInfo createFromParcel(Parcel parcel) {
            return new ServiceInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ServiceInfo[] newArray(int i) {
            return new ServiceInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_ISOLATED_PROCESS = 2;
    public static final int FLAG_STOP_WITH_TASK = 1;
    public int flags;
    public String permission;

}
