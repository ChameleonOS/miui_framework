// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

// Referenced classes of package android.content.pm:
//            PackageItemInfo, PackageManager

public class PermissionInfo extends PackageItemInfo
    implements Parcelable {

    public PermissionInfo() {
    }

    public PermissionInfo(PermissionInfo permissioninfo) {
        super(permissioninfo);
        group = permissioninfo.group;
        descriptionRes = permissioninfo.descriptionRes;
        protectionLevel = permissioninfo.protectionLevel;
        nonLocalizedDescription = permissioninfo.nonLocalizedDescription;
    }

    private PermissionInfo(Parcel parcel) {
        super(parcel);
        group = parcel.readString();
        descriptionRes = parcel.readInt();
        protectionLevel = parcel.readInt();
        nonLocalizedDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }


    public static int fixProtectionLevel(int i) {
        if(i == 3)
            i = 18;
        return i;
    }

    public static String protectionToString(int i) {
        String s = "????";
        i & 0xf;
        JVM INSTR tableswitch 0 3: default 36
    //                   0 98
    //                   1 92
    //                   2 104
    //                   3 110;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if((i & 0x10) != 0)
            s = (new StringBuilder()).append(s).append("|system").toString();
        if((i & 0x20) != 0)
            s = (new StringBuilder()).append(s).append("|development").toString();
        return s;
_L3:
        s = "dangerous";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "normal";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "signature";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "signatureOrSystem";
        if(true) goto _L1; else goto _L6
_L6:
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
        return (new StringBuilder()).append("PermissionInfo{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(super.name).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(group);
        parcel.writeInt(descriptionRes);
        parcel.writeInt(protectionLevel);
        TextUtils.writeToParcel(nonLocalizedDescription, parcel, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PermissionInfo createFromParcel(Parcel parcel) {
            return new PermissionInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PermissionInfo[] newArray(int i) {
            return new PermissionInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int PROTECTION_DANGEROUS = 1;
    public static final int PROTECTION_FLAG_DEVELOPMENT = 32;
    public static final int PROTECTION_FLAG_SYSTEM = 16;
    public static final int PROTECTION_MASK_BASE = 15;
    public static final int PROTECTION_MASK_FLAGS = 240;
    public static final int PROTECTION_NORMAL = 0;
    public static final int PROTECTION_SIGNATURE = 2;
    public static final int PROTECTION_SIGNATURE_OR_SYSTEM = 3;
    public int descriptionRes;
    public String group;
    public CharSequence nonLocalizedDescription;
    public int protectionLevel;

}
