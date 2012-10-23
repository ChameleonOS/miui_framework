// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class SyncAdapterType
    implements Parcelable {

    public SyncAdapterType(Parcel parcel) {
        boolean flag = false;
        String s = parcel.readString();
        String s1 = parcel.readString();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if(parcel.readInt() != 0)
            flag1 = true;
        else
            flag1 = false;
        if(parcel.readInt() != 0)
            flag2 = true;
        else
            flag2 = false;
        if(parcel.readInt() != 0)
            flag3 = true;
        else
            flag3 = false;
        if(parcel.readInt() != 0)
            flag = true;
        this(s, s1, flag1, flag2, flag3, flag, parcel.readString());
    }

    private SyncAdapterType(String s, String s1) {
        if(TextUtils.isEmpty(s))
            throw new IllegalArgumentException((new StringBuilder()).append("the authority must not be empty: ").append(s).toString());
        if(TextUtils.isEmpty(s1)) {
            throw new IllegalArgumentException((new StringBuilder()).append("the accountType must not be empty: ").append(s1).toString());
        } else {
            authority = s;
            accountType = s1;
            userVisible = true;
            supportsUploading = true;
            isAlwaysSyncable = false;
            allowParallelSyncs = false;
            settingsActivity = null;
            isKey = true;
            return;
        }
    }

    public SyncAdapterType(String s, String s1, boolean flag, boolean flag1) {
        if(TextUtils.isEmpty(s))
            throw new IllegalArgumentException((new StringBuilder()).append("the authority must not be empty: ").append(s).toString());
        if(TextUtils.isEmpty(s1)) {
            throw new IllegalArgumentException((new StringBuilder()).append("the accountType must not be empty: ").append(s1).toString());
        } else {
            authority = s;
            accountType = s1;
            userVisible = flag;
            supportsUploading = flag1;
            isAlwaysSyncable = false;
            allowParallelSyncs = false;
            settingsActivity = null;
            isKey = false;
            return;
        }
    }

    public SyncAdapterType(String s, String s1, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s2) {
        if(TextUtils.isEmpty(s))
            throw new IllegalArgumentException((new StringBuilder()).append("the authority must not be empty: ").append(s).toString());
        if(TextUtils.isEmpty(s1)) {
            throw new IllegalArgumentException((new StringBuilder()).append("the accountType must not be empty: ").append(s1).toString());
        } else {
            authority = s;
            accountType = s1;
            userVisible = flag;
            supportsUploading = flag1;
            isAlwaysSyncable = flag2;
            allowParallelSyncs = flag3;
            settingsActivity = s2;
            isKey = false;
            return;
        }
    }

    public static SyncAdapterType newKey(String s, String s1) {
        return new SyncAdapterType(s, s1);
    }

    public boolean allowParallelSyncs() {
        if(isKey)
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        else
            return allowParallelSyncs;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(obj != this) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(obj instanceof SyncAdapterType)) {
            flag = false;
        } else {
            SyncAdapterType syncadaptertype = (SyncAdapterType)obj;
            if(!authority.equals(syncadaptertype.authority) || !accountType.equals(syncadaptertype.accountType))
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public String getSettingsActivity() {
        if(isKey)
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        else
            return settingsActivity;
    }

    public int hashCode() {
        return 31 * (527 + authority.hashCode()) + accountType.hashCode();
    }

    public boolean isAlwaysSyncable() {
        if(isKey)
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        else
            return isAlwaysSyncable;
    }

    public boolean isUserVisible() {
        if(isKey)
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        else
            return userVisible;
    }

    public boolean supportsUploading() {
        if(isKey)
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        else
            return supportsUploading;
    }

    public String toString() {
        String s;
        if(isKey)
            s = (new StringBuilder()).append("SyncAdapterType Key {name=").append(authority).append(", type=").append(accountType).append("}").toString();
        else
            s = (new StringBuilder()).append("SyncAdapterType {name=").append(authority).append(", type=").append(accountType).append(", userVisible=").append(userVisible).append(", supportsUploading=").append(supportsUploading).append(", isAlwaysSyncable=").append(isAlwaysSyncable).append(", allowParallelSyncs=").append(allowParallelSyncs).append(", settingsActivity=").append(settingsActivity).append("}").toString();
        return s;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        if(isKey)
            throw new IllegalStateException("keys aren't parcelable");
        parcel.writeString(authority);
        parcel.writeString(accountType);
        int k;
        int l;
        int i1;
        if(userVisible)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(supportsUploading)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        if(isAlwaysSyncable)
            i1 = j;
        else
            i1 = 0;
        parcel.writeInt(i1);
        if(!allowParallelSyncs)
            j = 0;
        parcel.writeInt(j);
        parcel.writeString(settingsActivity);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SyncAdapterType createFromParcel(Parcel parcel) {
            return new SyncAdapterType(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SyncAdapterType[] newArray(int i) {
            return new SyncAdapterType[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public final String accountType;
    private final boolean allowParallelSyncs;
    public final String authority;
    private final boolean isAlwaysSyncable;
    public final boolean isKey;
    private final String settingsActivity;
    private final boolean supportsUploading;
    private final boolean userVisible;

}
