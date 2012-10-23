// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.os.*;

// Referenced classes of package android.accounts:
//            IAccountManagerResponse

public class AccountManagerResponse
    implements Parcelable {

    public AccountManagerResponse(IAccountManagerResponse iaccountmanagerresponse) {
        mResponse = iaccountmanagerresponse;
    }

    public AccountManagerResponse(Parcel parcel) {
        mResponse = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    public int describeContents() {
        return 0;
    }

    public void onError(int i, String s) {
        mResponse.onError(i, s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void onResult(Bundle bundle) {
        mResponse.onResult(bundle);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(mResponse.asBinder());
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AccountManagerResponse createFromParcel(Parcel parcel) {
            return new AccountManagerResponse(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public AccountManagerResponse[] newArray(int i) {
            return new AccountManagerResponse[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private IAccountManagerResponse mResponse;

}
