// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.os.*;

// Referenced classes of package android.content:
//            SyncStorageEngine

public class PeriodicSync
    implements Parcelable {

    public PeriodicSync(Account account1, String s, Bundle bundle, long l) {
        account = account1;
        authority = s;
        extras = new Bundle(bundle);
        period = l;
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
        if(!(obj instanceof PeriodicSync)) {
            flag = false;
        } else {
            PeriodicSync periodicsync = (PeriodicSync)obj;
            if(!account.equals(periodicsync.account) || !authority.equals(periodicsync.authority) || period != periodicsync.period || !SyncStorageEngine.equals(extras, periodicsync.extras))
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i) {
        account.writeToParcel(parcel, i);
        parcel.writeString(authority);
        parcel.writeBundle(extras);
        parcel.writeLong(period);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PeriodicSync createFromParcel(Parcel parcel) {
            return new PeriodicSync((Account)Account.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readBundle(), parcel.readLong());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PeriodicSync[] newArray(int i) {
            return new PeriodicSync[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public final Account account;
    public final String authority;
    public final Bundle extras;
    public final long period;

}
