// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.os.*;

public interface IFullBackupRestoreObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IFullBackupRestoreObserver {
        private static class Proxy
            implements IFullBackupRestoreObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.backup.IFullBackupRestoreObserver";
            }

            public void onBackupPackage(String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IFullBackupRestoreObserver");
                parcel.writeString(s);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onEndBackup() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IFullBackupRestoreObserver");
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onEndRestore() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IFullBackupRestoreObserver");
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onRestorePackage(String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IFullBackupRestoreObserver");
                parcel.writeString(s);
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onStartBackup() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IFullBackupRestoreObserver");
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onStartRestore() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IFullBackupRestoreObserver");
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onTimeout() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IFullBackupRestoreObserver");
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
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


        public static IFullBackupRestoreObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.backup.IFullBackupRestoreObserver");
                if(iinterface != null && (iinterface instanceof IFullBackupRestoreObserver))
                    obj = (IFullBackupRestoreObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IFullBackupRestoreObserver) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 8: default 80
        //                       1: 103
        //                       2: 116
        //                       3: 133
        //                       4: 146
        //                       5: 159
        //                       6: 176
        //                       7: 189
        //                       1598968902: 94;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L11:
            return flag;
_L9:
            parcel1.writeString("android.app.backup.IFullBackupRestoreObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.backup.IFullBackupRestoreObserver");
            onStartBackup();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.backup.IFullBackupRestoreObserver");
            onBackupPackage(parcel.readString());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.backup.IFullBackupRestoreObserver");
            onEndBackup();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.backup.IFullBackupRestoreObserver");
            onStartRestore();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.backup.IFullBackupRestoreObserver");
            onRestorePackage(parcel.readString());
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.app.backup.IFullBackupRestoreObserver");
            onEndRestore();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.app.backup.IFullBackupRestoreObserver");
            onTimeout();
            if(true) goto _L11; else goto _L10
_L10:
        }

        private static final String DESCRIPTOR = "android.app.backup.IFullBackupRestoreObserver";
        static final int TRANSACTION_onBackupPackage = 2;
        static final int TRANSACTION_onEndBackup = 3;
        static final int TRANSACTION_onEndRestore = 6;
        static final int TRANSACTION_onRestorePackage = 5;
        static final int TRANSACTION_onStartBackup = 1;
        static final int TRANSACTION_onStartRestore = 4;
        static final int TRANSACTION_onTimeout = 7;

        public Stub() {
            attachInterface(this, "android.app.backup.IFullBackupRestoreObserver");
        }
    }


    public abstract void onBackupPackage(String s) throws RemoteException;

    public abstract void onEndBackup() throws RemoteException;

    public abstract void onEndRestore() throws RemoteException;

    public abstract void onRestorePackage(String s) throws RemoteException;

    public abstract void onStartBackup() throws RemoteException;

    public abstract void onStartRestore() throws RemoteException;

    public abstract void onTimeout() throws RemoteException;
}
