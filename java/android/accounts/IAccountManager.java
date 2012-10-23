// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.os.*;

// Referenced classes of package android.accounts:
//            Account, IAccountManagerResponse, AuthenticatorDescription

public interface IAccountManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccountManager {
        private static class Proxy
            implements IAccountManager {

            public boolean addAccount(Account account, String s, Bundle bundle) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_131;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                int i;
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void addAcount(IAccountManagerResponse iaccountmanagerresponse, String s, String s1, String as[], boolean flag, Bundle bundle) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iaccountmanagerresponse.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeStringArray(as);
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                if(bundle == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L6:
                mRemote.transact(17, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public void clearPassword(Account account) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void confirmCredentials(IAccountManagerResponse iaccountmanagerresponse, Account account, Bundle bundle, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iaccountmanagerresponse.asBinder();
_L6:
                parcel.writeStrongBinder(ibinder);
                if(account == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L7:
                if(bundle != null) {
                    parcel.writeInt(1);
                    bundle.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_155;
                }
                  goto _L5
_L8:
                parcel.writeInt(i);
                mRemote.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L6
_L4:
                parcel.writeInt(0);
                  goto _L7
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L5:
                parcel.writeInt(0);
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L8
            }

            public void editProperties(IAccountManagerResponse iaccountmanagerresponse, String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_92;
                ibinder = iaccountmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public Account[] getAccounts(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                Account aaccount[];
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                parcel.writeString(s);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                aaccount = (Account[])parcel1.createTypedArray(Account.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return aaccount;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getAccountsByFeatures(IAccountManagerResponse iaccountmanagerresponse, String s, String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = iaccountmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeStringArray(as);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getAuthToken(IAccountManagerResponse iaccountmanagerresponse, Account account, String s, boolean flag, boolean flag1, Bundle bundle) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iaccountmanagerresponse.asBinder();
_L7:
                parcel.writeStrongBinder(ibinder);
                if(account == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L8:
                parcel.writeString(s);
                if(!flag) goto _L6; else goto _L5
_L5:
                int j = i;
_L9:
                parcel.writeInt(j);
                Exception exception;
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_184;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L10:
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L7
_L4:
                parcel.writeInt(0);
                  goto _L8
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L6:
                j = 0;
                  goto _L9
                parcel.writeInt(0);
                  goto _L10
            }

            public void getAuthTokenLabel(IAccountManagerResponse iaccountmanagerresponse, String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = iaccountmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public AuthenticatorDescription[] getAuthenticatorTypes() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                AuthenticatorDescription aauthenticatordescription[];
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                aauthenticatordescription = (AuthenticatorDescription[])parcel1.createTypedArray(AuthenticatorDescription.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return aauthenticatordescription;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.accounts.IAccountManager";
            }

            public String getPassword(Account account) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null)
                    break MISSING_BLOCK_LABEL_64;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                String s;
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getUserData(Account account, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null)
                    break MISSING_BLOCK_LABEL_74;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                String s1;
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void hasFeatures(IAccountManagerResponse iaccountmanagerresponse, Account account, String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iaccountmanagerresponse.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                if(account == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L6:
                parcel.writeStringArray(as);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public void invalidateAuthToken(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String peekAuthToken(Account account, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                String s1;
                parcel.writeString(s);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void removeAccount(IAccountManagerResponse iaccountmanagerresponse, Account account) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iaccountmanagerresponse.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                if(account == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L6:
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public void setAuthToken(Account account, String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setPassword(Account account, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setUserData(Account account, String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void updateAppPermission(Account account, String s, int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(account == null)
                    break MISSING_BLOCK_LABEL_94;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                parcel.writeInt(i);
                Exception exception;
                if(!flag)
                    j = 0;
                parcel.writeInt(j);
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void updateCredentials(IAccountManagerResponse iaccountmanagerresponse, Account account, String s, boolean flag, Bundle bundle) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accounts.IAccountManager");
                if(iaccountmanagerresponse == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iaccountmanagerresponse.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                if(account == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L6:
                parcel.writeString(s);
                Exception exception;
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_162;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L7:
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L7
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAccountManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.accounts.IAccountManager");
                if(iinterface != null && (iinterface instanceof IAccountManager))
                    obj = (IAccountManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccountManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            int k;
            boolean flag;
            k = 0;
            flag = true;
            i;
            JVM INSTR lookupswitch 22: default 192
        //                       1: 215
        //                       2: 269
        //                       3: 327
        //                       4: 354
        //                       5: 385
        //                       6: 446
        //                       7: 478
        //                       8: 578
        //                       9: 635
        //                       10: 660
        //                       11: 718
        //                       12: 772
        //                       13: 822
        //                       14: 868
        //                       15: 922
        //                       16: 1003
        //                       17: 1135
        //                       18: 1235
        //                       19: 1348
        //                       20: 1403
        //                       21: 1508
        //                       1598968902: 206;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L25:
            return flag;
_L23:
            parcel1.writeString("android.accounts.IAccountManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account13;
            String s9;
            if(parcel.readInt() != 0)
                account13 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account13 = null;
            s9 = getPassword(account13);
            parcel1.writeNoException();
            parcel1.writeString(s9);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account12;
            String s8;
            if(parcel.readInt() != 0)
                account12 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account12 = null;
            s8 = getUserData(account12, parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s8);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.accounts.IAccountManager");
            AuthenticatorDescription aauthenticatordescription[] = getAuthenticatorTypes();
            parcel1.writeNoException();
            parcel1.writeTypedArray(aauthenticatordescription, flag);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account aaccount[] = getAccounts(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeTypedArray(aaccount, flag);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.accounts.IAccountManager");
            IAccountManagerResponse iaccountmanagerresponse6 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account11;
            if(parcel.readInt() != 0)
                account11 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account11 = null;
            hasFeatures(iaccountmanagerresponse6, account11, parcel.createStringArray());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.accounts.IAccountManager");
            getAccountsByFeatures(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.createStringArray());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account10;
            String s7;
            Bundle bundle4;
            boolean flag8;
            if(parcel.readInt() != 0)
                account10 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account10 = null;
            s7 = parcel.readString();
            if(parcel.readInt() != 0)
                bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle4 = null;
            flag8 = addAccount(account10, s7, bundle4);
            parcel1.writeNoException();
            if(flag8)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.accounts.IAccountManager");
            IAccountManagerResponse iaccountmanagerresponse5 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account9;
            if(parcel.readInt() != 0)
                account9 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account9 = null;
            removeAccount(iaccountmanagerresponse5, account9);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.accounts.IAccountManager");
            invalidateAuthToken(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account8;
            String s6;
            if(parcel.readInt() != 0)
                account8 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account8 = null;
            s6 = peekAuthToken(account8, parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s6);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account7;
            if(parcel.readInt() != 0)
                account7 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account7 = null;
            setAuthToken(account7, parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account6;
            if(parcel.readInt() != 0)
                account6 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account6 = null;
            setPassword(account6, parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account5;
            if(parcel.readInt() != 0)
                account5 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account5 = null;
            clearPassword(account5);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account4;
            if(parcel.readInt() != 0)
                account4 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account4 = null;
            setUserData(account4, parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.accounts.IAccountManager");
            Account account3;
            String s5;
            int l;
            boolean flag7;
            if(parcel.readInt() != 0)
                account3 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account3 = null;
            s5 = parcel.readString();
            l = parcel.readInt();
            if(parcel.readInt() != 0)
                flag7 = flag;
            else
                flag7 = false;
            updateAppPermission(account3, s5, l, flag7);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.accounts.IAccountManager");
            IAccountManagerResponse iaccountmanagerresponse4 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account2;
            String s4;
            boolean flag5;
            boolean flag6;
            Bundle bundle3;
            if(parcel.readInt() != 0)
                account2 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account2 = null;
            s4 = parcel.readString();
            if(parcel.readInt() != 0)
                flag5 = flag;
            else
                flag5 = false;
            if(parcel.readInt() != 0)
                flag6 = flag;
            else
                flag6 = false;
            if(parcel.readInt() != 0)
                bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle3 = null;
            getAuthToken(iaccountmanagerresponse4, account2, s4, flag5, flag6, bundle3);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.accounts.IAccountManager");
            IAccountManagerResponse iaccountmanagerresponse3 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
            String s2 = parcel.readString();
            String s3 = parcel.readString();
            String as[] = parcel.createStringArray();
            boolean flag4;
            Bundle bundle2;
            if(parcel.readInt() != 0)
                flag4 = flag;
            else
                flag4 = false;
            if(parcel.readInt() != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle2 = null;
            addAcount(iaccountmanagerresponse3, s2, s3, as, flag4, bundle2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.accounts.IAccountManager");
            IAccountManagerResponse iaccountmanagerresponse2 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account1;
            String s1;
            boolean flag3;
            Bundle bundle1;
            if(parcel.readInt() != 0)
                account1 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account1 = null;
            s1 = parcel.readString();
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            updateCredentials(iaccountmanagerresponse2, account1, s1, flag3, bundle1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.accounts.IAccountManager");
            IAccountManagerResponse iaccountmanagerresponse1 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
            String s = parcel.readString();
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            editProperties(iaccountmanagerresponse1, s, flag2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.accounts.IAccountManager");
            IAccountManagerResponse iaccountmanagerresponse = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
            Account account;
            Bundle bundle;
            boolean flag1;
            if(parcel.readInt() != 0)
                account = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account = null;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            confirmCredentials(iaccountmanagerresponse, account, bundle, flag1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.accounts.IAccountManager");
            getAuthTokenLabel(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(true) goto _L25; else goto _L24
_L24:
        }

        private static final String DESCRIPTOR = "android.accounts.IAccountManager";
        static final int TRANSACTION_addAccount = 7;
        static final int TRANSACTION_addAcount = 17;
        static final int TRANSACTION_clearPassword = 13;
        static final int TRANSACTION_confirmCredentials = 20;
        static final int TRANSACTION_editProperties = 19;
        static final int TRANSACTION_getAccounts = 4;
        static final int TRANSACTION_getAccountsByFeatures = 6;
        static final int TRANSACTION_getAuthToken = 16;
        static final int TRANSACTION_getAuthTokenLabel = 21;
        static final int TRANSACTION_getAuthenticatorTypes = 3;
        static final int TRANSACTION_getPassword = 1;
        static final int TRANSACTION_getUserData = 2;
        static final int TRANSACTION_hasFeatures = 5;
        static final int TRANSACTION_invalidateAuthToken = 9;
        static final int TRANSACTION_peekAuthToken = 10;
        static final int TRANSACTION_removeAccount = 8;
        static final int TRANSACTION_setAuthToken = 11;
        static final int TRANSACTION_setPassword = 12;
        static final int TRANSACTION_setUserData = 14;
        static final int TRANSACTION_updateAppPermission = 15;
        static final int TRANSACTION_updateCredentials = 18;

        public Stub() {
            attachInterface(this, "android.accounts.IAccountManager");
        }
    }


    public abstract boolean addAccount(Account account, String s, Bundle bundle) throws RemoteException;

    public abstract void addAcount(IAccountManagerResponse iaccountmanagerresponse, String s, String s1, String as[], boolean flag, Bundle bundle) throws RemoteException;

    public abstract void clearPassword(Account account) throws RemoteException;

    public abstract void confirmCredentials(IAccountManagerResponse iaccountmanagerresponse, Account account, Bundle bundle, boolean flag) throws RemoteException;

    public abstract void editProperties(IAccountManagerResponse iaccountmanagerresponse, String s, boolean flag) throws RemoteException;

    public abstract Account[] getAccounts(String s) throws RemoteException;

    public abstract void getAccountsByFeatures(IAccountManagerResponse iaccountmanagerresponse, String s, String as[]) throws RemoteException;

    public abstract void getAuthToken(IAccountManagerResponse iaccountmanagerresponse, Account account, String s, boolean flag, boolean flag1, Bundle bundle) throws RemoteException;

    public abstract void getAuthTokenLabel(IAccountManagerResponse iaccountmanagerresponse, String s, String s1) throws RemoteException;

    public abstract AuthenticatorDescription[] getAuthenticatorTypes() throws RemoteException;

    public abstract String getPassword(Account account) throws RemoteException;

    public abstract String getUserData(Account account, String s) throws RemoteException;

    public abstract void hasFeatures(IAccountManagerResponse iaccountmanagerresponse, Account account, String as[]) throws RemoteException;

    public abstract void invalidateAuthToken(String s, String s1) throws RemoteException;

    public abstract String peekAuthToken(Account account, String s) throws RemoteException;

    public abstract void removeAccount(IAccountManagerResponse iaccountmanagerresponse, Account account) throws RemoteException;

    public abstract void setAuthToken(Account account, String s, String s1) throws RemoteException;

    public abstract void setPassword(Account account, String s) throws RemoteException;

    public abstract void setUserData(Account account, String s, String s1) throws RemoteException;

    public abstract void updateAppPermission(Account account, String s, int i, boolean flag) throws RemoteException;

    public abstract void updateCredentials(IAccountManagerResponse iaccountmanagerresponse, Account account, String s, boolean flag, Bundle bundle) throws RemoteException;
}
