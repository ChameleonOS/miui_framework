// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.net;

import android.accounts.Account;
import android.os.*;

// Referenced classes of package miui.net:
//            ICloudManagerResponse

public interface ICloudManagerService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ICloudManagerService {
        private static class Proxy
            implements ICloudManagerService {

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancelNotification(int i, ICloudManagerResponse icloudmanagerresponse) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("miui.net.ICloudManagerService");
                parcel.writeInt(i);
                if(icloudmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = icloudmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public void getActivatedPhone(ICloudManagerResponse icloudmanagerresponse) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("miui.net.ICloudManagerService");
                if(icloudmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = icloudmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public void getActivatedStatus(ICloudManagerResponse icloudmanagerresponse) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("miui.net.ICloudManagerService");
                if(icloudmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = icloudmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, parcel1, 0);
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

            public void getFindDeviceToken(ICloudManagerResponse icloudmanagerresponse) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("miui.net.ICloudManagerService");
                if(icloudmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = icloudmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
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

            public String getInterfaceDescriptor() {
                return "miui.net.ICloudManagerService";
            }

            public void getSmsGateway(ICloudManagerResponse icloudmanagerresponse) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("miui.net.ICloudManagerService");
                if(icloudmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = icloudmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void getSubSyncAutomatically(Account account, String s, ICloudManagerResponse icloudmanagerresponse) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.ICloudManagerService");
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                parcel.writeString(s);
                if(icloudmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_115;
                ibinder = icloudmanagerresponse.asBinder();
_L4:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                ibinder = null;
                  goto _L4
            }

            public void getUserSecurity(ICloudManagerResponse icloudmanagerresponse) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("miui.net.ICloudManagerService");
                if(icloudmanagerresponse == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = icloudmanagerresponse.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(5, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ICloudManagerService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("miui.net.ICloudManagerService");
                if(iinterface != null && (iinterface instanceof ICloudManagerService))
                    obj = (ICloudManagerService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ICloudManagerService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 8: default 80
        //                       1: 103
        //                       2: 127
        //                       3: 151
        //                       4: 208
        //                       5: 232
        //                       6: 256
        //                       7: 280
        //                       1598968902: 94;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L11:
            return flag;
_L9:
            parcel1.writeString("miui.net.ICloudManagerService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("miui.net.ICloudManagerService");
            getActivatedPhone(ICloudManagerResponse.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("miui.net.ICloudManagerService");
            getActivatedStatus(ICloudManagerResponse.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("miui.net.ICloudManagerService");
            Account account;
            if(parcel.readInt() != 0)
                account = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account = null;
            getSubSyncAutomatically(account, parcel.readString(), ICloudManagerResponse.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("miui.net.ICloudManagerService");
            getSmsGateway(ICloudManagerResponse.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("miui.net.ICloudManagerService");
            getUserSecurity(ICloudManagerResponse.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("miui.net.ICloudManagerService");
            getFindDeviceToken(ICloudManagerResponse.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("miui.net.ICloudManagerService");
            cancelNotification(parcel.readInt(), ICloudManagerResponse.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(true) goto _L11; else goto _L10
_L10:
        }

        private static final String DESCRIPTOR = "miui.net.ICloudManagerService";
        static final int TRANSACTION_cancelNotification = 7;
        static final int TRANSACTION_getActivatedPhone = 1;
        static final int TRANSACTION_getActivatedStatus = 2;
        static final int TRANSACTION_getFindDeviceToken = 6;
        static final int TRANSACTION_getSmsGateway = 4;
        static final int TRANSACTION_getSubSyncAutomatically = 3;
        static final int TRANSACTION_getUserSecurity = 5;

        public Stub() {
            attachInterface(this, "miui.net.ICloudManagerService");
        }
    }


    public abstract void cancelNotification(int i, ICloudManagerResponse icloudmanagerresponse) throws RemoteException;

    public abstract void getActivatedPhone(ICloudManagerResponse icloudmanagerresponse) throws RemoteException;

    public abstract void getActivatedStatus(ICloudManagerResponse icloudmanagerresponse) throws RemoteException;

    public abstract void getFindDeviceToken(ICloudManagerResponse icloudmanagerresponse) throws RemoteException;

    public abstract void getSmsGateway(ICloudManagerResponse icloudmanagerresponse) throws RemoteException;

    public abstract void getSubSyncAutomatically(Account account, String s, ICloudManagerResponse icloudmanagerresponse) throws RemoteException;

    public abstract void getUserSecurity(ICloudManagerResponse icloudmanagerresponse) throws RemoteException;
}
