// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.os.*;

public interface IAccountAuthenticatorResponse
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccountAuthenticatorResponse {
        private static class Proxy
            implements IAccountAuthenticatorResponse {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.accounts.IAccountAuthenticatorResponse";
            }

            public void onError(int i, String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticatorResponse");
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onRequestContinued() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticatorResponse");
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onResult(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticatorResponse");
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAccountAuthenticatorResponse asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.accounts.IAccountAuthenticatorResponse");
                if(iinterface != null && (iinterface instanceof IAccountAuthenticatorResponse))
                    obj = (IAccountAuthenticatorResponse)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccountAuthenticatorResponse) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 113
        //                       3: 126
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.accounts.IAccountAuthenticatorResponse");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            onResult(bundle);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            onRequestContinued();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            onError(parcel.readInt(), parcel.readString());
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.accounts.IAccountAuthenticatorResponse";
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onRequestContinued = 2;
        static final int TRANSACTION_onResult = 1;

        public Stub() {
            attachInterface(this, "android.accounts.IAccountAuthenticatorResponse");
        }
    }


    public abstract void onError(int i, String s) throws RemoteException;

    public abstract void onRequestContinued() throws RemoteException;

    public abstract void onResult(Bundle bundle) throws RemoteException;
}
