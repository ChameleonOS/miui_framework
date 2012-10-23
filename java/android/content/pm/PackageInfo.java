// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.content.pm:
//            ApplicationInfo, ActivityInfo, ServiceInfo, ProviderInfo, 
//            InstrumentationInfo, PermissionInfo, Signature, ConfigurationInfo, 
//            FeatureInfo

public class PackageInfo
    implements Parcelable {

    public PackageInfo() {
        installLocation = 1;
    }

    private PackageInfo(Parcel parcel) {
        installLocation = 1;
        packageName = parcel.readString();
        versionCode = parcel.readInt();
        versionName = parcel.readString();
        sharedUserId = parcel.readString();
        sharedUserLabel = parcel.readInt();
        if(parcel.readInt() != 0)
            applicationInfo = (ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(parcel);
        firstInstallTime = parcel.readLong();
        lastUpdateTime = parcel.readLong();
        gids = parcel.createIntArray();
        activities = (ActivityInfo[])parcel.createTypedArray(ActivityInfo.CREATOR);
        receivers = (ActivityInfo[])parcel.createTypedArray(ActivityInfo.CREATOR);
        services = (ServiceInfo[])parcel.createTypedArray(ServiceInfo.CREATOR);
        providers = (ProviderInfo[])parcel.createTypedArray(ProviderInfo.CREATOR);
        instrumentation = (InstrumentationInfo[])parcel.createTypedArray(InstrumentationInfo.CREATOR);
        permissions = (PermissionInfo[])parcel.createTypedArray(PermissionInfo.CREATOR);
        requestedPermissions = parcel.createStringArray();
        requestedPermissionsFlags = parcel.createIntArray();
        signatures = (Signature[])parcel.createTypedArray(Signature.CREATOR);
        configPreferences = (ConfigurationInfo[])parcel.createTypedArray(ConfigurationInfo.CREATOR);
        reqFeatures = (FeatureInfo[])parcel.createTypedArray(FeatureInfo.CREATOR);
        installLocation = parcel.readInt();
    }


    public int describeContents() {
        return 0;
    }

    public String toString() {
        return (new StringBuilder()).append("PackageInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(packageName).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(packageName);
        parcel.writeInt(versionCode);
        parcel.writeString(versionName);
        parcel.writeString(sharedUserId);
        parcel.writeInt(sharedUserLabel);
        if(applicationInfo != null) {
            parcel.writeInt(1);
            applicationInfo.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeLong(firstInstallTime);
        parcel.writeLong(lastUpdateTime);
        parcel.writeIntArray(gids);
        parcel.writeTypedArray(activities, i);
        parcel.writeTypedArray(receivers, i);
        parcel.writeTypedArray(services, i);
        parcel.writeTypedArray(providers, i);
        parcel.writeTypedArray(instrumentation, i);
        parcel.writeTypedArray(permissions, i);
        parcel.writeStringArray(requestedPermissions);
        parcel.writeIntArray(requestedPermissionsFlags);
        parcel.writeTypedArray(signatures, i);
        parcel.writeTypedArray(configPreferences, i);
        parcel.writeTypedArray(reqFeatures, i);
        parcel.writeInt(installLocation);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PackageInfo createFromParcel(Parcel parcel) {
            return new PackageInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PackageInfo[] newArray(int i) {
            return new PackageInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int INSTALL_LOCATION_AUTO = 0;
    public static final int INSTALL_LOCATION_INTERNAL_ONLY = 1;
    public static final int INSTALL_LOCATION_PREFER_EXTERNAL = 2;
    public static final int INSTALL_LOCATION_UNSPECIFIED = -1;
    public static final int REQUESTED_PERMISSION_GRANTED = 2;
    public static final int REQUESTED_PERMISSION_REQUIRED = 1;
    public ActivityInfo activities[];
    public ApplicationInfo applicationInfo;
    public ConfigurationInfo configPreferences[];
    public long firstInstallTime;
    public int gids[];
    public int installLocation;
    public InstrumentationInfo instrumentation[];
    public long lastUpdateTime;
    public String packageName;
    public PermissionInfo permissions[];
    public ProviderInfo providers[];
    public ActivityInfo receivers[];
    public FeatureInfo reqFeatures[];
    public String requestedPermissions[];
    public int requestedPermissionsFlags[];
    public ServiceInfo services[];
    public String sharedUserId;
    public int sharedUserLabel;
    public Signature signatures[];
    public int versionCode;
    public String versionName;

}
