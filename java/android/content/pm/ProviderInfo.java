// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.*;

// Referenced classes of package android.content.pm:
//            ComponentInfo, PathPermission, PackageItemInfo

public final class ProviderInfo extends ComponentInfo
    implements Parcelable {

    public ProviderInfo() {
        authority = null;
        readPermission = null;
        writePermission = null;
        grantUriPermissions = false;
        uriPermissionPatterns = null;
        pathPermissions = null;
        multiprocess = false;
        initOrder = 0;
        isSyncable = false;
    }

    public ProviderInfo(ProviderInfo providerinfo) {
        super(providerinfo);
        authority = null;
        readPermission = null;
        writePermission = null;
        grantUriPermissions = false;
        uriPermissionPatterns = null;
        pathPermissions = null;
        multiprocess = false;
        initOrder = 0;
        isSyncable = false;
        authority = providerinfo.authority;
        readPermission = providerinfo.readPermission;
        writePermission = providerinfo.writePermission;
        grantUriPermissions = providerinfo.grantUriPermissions;
        uriPermissionPatterns = providerinfo.uriPermissionPatterns;
        pathPermissions = providerinfo.pathPermissions;
        multiprocess = providerinfo.multiprocess;
        initOrder = providerinfo.initOrder;
        isSyncable = providerinfo.isSyncable;
    }

    private ProviderInfo(Parcel parcel) {
        boolean flag = true;
        super(parcel);
        authority = null;
        readPermission = null;
        writePermission = null;
        grantUriPermissions = false;
        uriPermissionPatterns = null;
        pathPermissions = null;
        multiprocess = false;
        initOrder = 0;
        isSyncable = false;
        authority = parcel.readString();
        readPermission = parcel.readString();
        writePermission = parcel.readString();
        boolean flag1;
        boolean flag2;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        grantUriPermissions = flag1;
        uriPermissionPatterns = (PatternMatcher[])parcel.createTypedArray(PatternMatcher.CREATOR);
        pathPermissions = (PathPermission[])parcel.createTypedArray(PathPermission.CREATOR);
        if(parcel.readInt() != 0)
            flag2 = flag;
        else
            flag2 = false;
        multiprocess = flag2;
        initOrder = parcel.readInt();
        if(parcel.readInt() == 0)
            flag = false;
        isSyncable = flag;
    }


    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder()).append("ContentProviderInfo{name=").append(authority).append(" className=").append(super.name).append(" isSyncable=");
        String s;
        if(isSyncable)
            s = "true";
        else
            s = "false";
        return stringbuilder.append(s).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(authority);
        parcel.writeString(readPermission);
        parcel.writeString(writePermission);
        int k;
        int l;
        if(grantUriPermissions)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        parcel.writeTypedArray(uriPermissionPatterns, i);
        parcel.writeTypedArray(pathPermissions, i);
        if(multiprocess)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        parcel.writeInt(initOrder);
        if(!isSyncable)
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProviderInfo createFromParcel(Parcel parcel) {
            return new ProviderInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ProviderInfo[] newArray(int i) {
            return new ProviderInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public String authority;
    public boolean grantUriPermissions;
    public int initOrder;
    public boolean isSyncable;
    public boolean multiprocess;
    public PathPermission pathPermissions[];
    public String readPermission;
    public PatternMatcher uriPermissionPatterns[];
    public String writePermission;

}
