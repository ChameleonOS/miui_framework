// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

// Referenced classes of package android.content.pm:
//            PackageItemInfo, PackageManager

public class PermissionGroupInfo extends PackageItemInfo
    implements Parcelable {

    public PermissionGroupInfo() {
    }

    public PermissionGroupInfo(PermissionGroupInfo permissiongroupinfo) {
        super(permissiongroupinfo);
        descriptionRes = permissiongroupinfo.descriptionRes;
        nonLocalizedDescription = permissiongroupinfo.nonLocalizedDescription;
        flags = permissiongroupinfo.flags;
        priority = permissiongroupinfo.priority;
    }

    private PermissionGroupInfo(Parcel parcel) {
        super(parcel);
        descriptionRes = parcel.readInt();
        nonLocalizedDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        flags = parcel.readInt();
        priority = parcel.readInt();
    }


    public int describeContents() {
        return 0;
    }

    public CharSequence loadDescription(PackageManager packagemanager) {
        if(nonLocalizedDescription == null) goto _L2; else goto _L1
_L1:
        CharSequence charsequence = nonLocalizedDescription;
_L4:
        return charsequence;
_L2:
        if(descriptionRes != 0) {
            charsequence = packagemanager.getText(super.packageName, descriptionRes, null);
            if(charsequence != null)
                continue; /* Loop/switch isn't completed */
        }
        charsequence = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String toString() {
        return (new StringBuilder()).append("PermissionGroupInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(super.name).append(" flgs=0x").append(Integer.toHexString(flags)).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(descriptionRes);
        TextUtils.writeToParcel(nonLocalizedDescription, parcel, i);
        parcel.writeInt(flags);
        parcel.writeInt(priority);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PermissionGroupInfo createFromParcel(Parcel parcel) {
            return new PermissionGroupInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PermissionGroupInfo[] newArray(int i) {
            return new PermissionGroupInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_PERSONAL_INFO = 1;
    public int descriptionRes;
    public int flags;
    public CharSequence nonLocalizedDescription;
    public int priority;

}
