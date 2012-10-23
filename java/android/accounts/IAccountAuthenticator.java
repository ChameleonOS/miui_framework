// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.os.*;

// Referenced classes of package android.accounts:
//            IAccountAuthenticatorResponse, Account

public interface IAccountAuthenticator
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccountAuthenticator {
        private static class Proxy
            implements IAccountAuthenticator {

            public void addAccount(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s, String s1, String as[], Bundle bundle) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticator");
                if(iaccountauthenticatorresponse != null)
                    ibinder = iaccountauthenticatorresponse.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeStringArray(as);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_93;
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void confirmCredentials(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, Bundle bundle) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticator");
                if(iaccountauthenticatorresponse != null)
                    ibinder = iaccountauthenticatorresponse.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_108;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void editProperties(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticator");
                if(iaccountauthenticatorresponse != null)
                    ibinder = iaccountauthenticatorresponse.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void getAccountRemovalAllowed(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticator");
                if(iaccountauthenticatorresponse != null)
                    ibinder = iaccountauthenticatorresponse.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(account == null)
                    break MISSING_BLOCK_LABEL_70;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(8, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void getAuthToken(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String s, Bundle bundle) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticator");
                if(iaccountauthenticatorresponse != null)
                    ibinder = iaccountauthenticatorresponse.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_116;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void getAuthTokenLabel(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticator");
                if(iaccountauthenticatorresponse != null)
                    ibinder = iaccountauthenticatorresponse.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.accounts.IAccountAuthenticator";
            }

            public void hasFeatures(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String as[]) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticator");
                if(iaccountauthenticatorresponse != null)
                    ibinder = iaccountauthenticatorresponse.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(account == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeStringArray(as);
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void updateCredentials(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String s, Bundle bundle) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountAuthenticator");
                if(iaccountauthenticatorresponse != null)
                    ibinder = iaccountauthenticatorresponse.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_116;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAccountAuthenticator asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.accounts.IAccountAuthenticator");
                if(iinterface != null && (iinterface instanceof IAccountAuthenticator))
                    obj = (IAccountAuthenticator)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccountAuthenticator) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 9: default 84
        //                       1: 110
        //                       2: 190
        //                       3: 275
        //                       4: 368
        //                       5: 395
        //                       6: 488
        //                       7: 515
        //                       8: 575
        //                       1598968902: 98;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L12:
            return flag;
_L10:
            parcel1.writeString("android.accounts.IAccountAuthenticator");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.accounts.IAccountAuthenticator");
            IAccountAuthenticatorResponse iaccountauthenticatorresponse5 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
            String s2 = parcel.readString();
            String s3 = parcel.readString();
            String as[] = parcel.createStringArray();
            Bundle bundle3;
            if(parcel.readInt() != 0)
                bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle3 = null;
            addAccount(iaccountauthenticatorresponse5, s2, s3, as, bundle3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.accounts.IAccountAuthenticator");
            IAccountAuthenticatorResponse iaccountauthenticatorresponse4 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account4;
            Bundle bundle2;
            if(parcel.readInt() != 0)
                account4 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account4 = null;
            if(parcel.readInt() != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle2 = null;
            confirmCredentials(iaccountauthenticatorresponse4, account4, bundle2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.accounts.IAccountAuthenticator");
            IAccountAuthenticatorResponse iaccountauthenticatorresponse3 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account3;
            String s1;
            Bundle bundle1;
            if(parcel.readInt() != 0)
                account3 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account3 = null;
            s1 = parcel.readString();
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            getAuthToken(iaccountauthenticatorresponse3, account3, s1, bundle1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.accounts.IAccountAuthenticator");
            getAuthTokenLabel(IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.accounts.IAccountAuthenticator");
            IAccountAuthenticatorResponse iaccountauthenticatorresponse2 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account2;
            String s;
            Bundle bundle;
            if(parcel.readInt() != 0)
                account2 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account2 = null;
            s = parcel.readString();
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            updateCredentials(iaccountauthenticatorresponse2, account2, s, bundle);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.accounts.IAccountAuthenticator");
            editProperties(IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.accounts.IAccountAuthenticator");
            IAccountAuthenticatorResponse iaccountauthenticatorresponse1 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account1;
            if(parcel.readInt() != 0)
                account1 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account1 = null;
            hasFeatures(iaccountauthenticatorresponse1, account1, parcel.createStringArray());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.accounts.IAccountAuthenticator");
            IAccountAuthenticatorResponse iaccountauthenticatorresponse = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account;
            if(parcel.readInt() != 0)
                account = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account = null;
            getAccountRemovalAllowed(iaccountauthenticatorresponse, account);
            flag = true;
            if(true) goto _L12; else goto _L11
_L11:
        }

        private static final String DESCRIPTOR = "android.accounts.IAccountAuthenticator";
        static final int TRANSACTION_addAccount = 1;
        static final int TRANSACTION_confirmCredentials = 2;
        static final int TRANSACTION_editProperties = 6;
        static final int TRANSACTION_getAccountRemovalAllowed = 8;
        static final int TRANSACTION_getAuthToken = 3;
        static final int TRANSACTION_getAuthTokenLabel = 4;
        static final int TRANSACTION_hasFeatures = 7;
        static final int TRANSACTION_updateCredentials = 5;

        public Stub() {
            attachInterface(this, "android.accounts.IAccountAuthenticator");
        }
    }


    public abstract void addAccount(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s, String s1, String as[], Bundle bundle) throws RemoteException;

    public abstract void confirmCredentials(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, Bundle bundle) throws RemoteException;

    public abstract void editProperties(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s) throws RemoteException;

    public abstract void getAccountRemovalAllowed(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account) throws RemoteException;

    public abstract void getAuthToken(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String s, Bundle bundle) throws RemoteException;

    public abstract void getAuthTokenLabel(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s) throws RemoteException;

    public abstract void hasFeatures(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String as[]) throws RemoteException;

    public abstract void updateCredentials(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String s, Bundle bundle) throws RemoteException;
}
