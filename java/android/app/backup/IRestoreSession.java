// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.os.*;

// Referenced classes of package android.app.backup:
//            IRestoreObserver

public interface IRestoreSession
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRestoreSession {
        private static class Proxy
            implements IRestoreSession {

            public IBinder asBinder() {
                return mRemote;
            }

            public void endRestoreSession() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IRestoreSession");
                mRemote.transact(5, parcel, parcel1, 0);
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

            public int getAvailableRestoreSets(IRestoreObserver irestoreobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.app.backup.IRestoreSession");
                if(irestoreobserver == null)
                    break MISSING_BLOCK_LABEL_67;
                ibinder = irestoreobserver.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.app.backup.IRestoreSession";
            }

            public int restoreAll(long l, IRestoreObserver irestoreobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.app.backup.IRestoreSession");
                parcel.writeLong(l);
                if(irestoreobserver == null)
                    break MISSING_BLOCK_LABEL_83;
                ibinder = irestoreobserver.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int restorePackage(String s, IRestoreObserver irestoreobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.app.backup.IRestoreSession");
                parcel.writeString(s);
                if(irestoreobserver == null)
                    break MISSING_BLOCK_LABEL_77;
                ibinder = irestoreobserver.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int restoreSome(long l, IRestoreObserver irestoreobserver, String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.app.backup.IRestoreSession");
                parcel.writeLong(l);
                if(irestoreobserver == null)
                    break MISSING_BLOCK_LABEL_90;
                ibinder = irestoreobserver.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                parcel.writeStringArray(as);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
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


        public static IRestoreSession asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.backup.IRestoreSession");
                if(iinterface != null && (iinterface instanceof IRestoreSession))
                    obj = (IRestoreSession)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRestoreSession) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 119
        //                       3: 155
        //                       4: 195
        //                       5: 231
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.app.backup.IRestoreSession");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.backup.IRestoreSession");
            int j1 = getAvailableRestoreSets(IRestoreObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.backup.IRestoreSession");
            int i1 = restoreAll(parcel.readLong(), IRestoreObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.backup.IRestoreSession");
            int l = restoreSome(parcel.readLong(), IRestoreObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.createStringArray());
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.backup.IRestoreSession");
            int k = restorePackage(parcel.readString(), IRestoreObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.backup.IRestoreSession");
            endRestoreSession();
            parcel1.writeNoException();
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.app.backup.IRestoreSession";
        static final int TRANSACTION_endRestoreSession = 5;
        static final int TRANSACTION_getAvailableRestoreSets = 1;
        static final int TRANSACTION_restoreAll = 2;
        static final int TRANSACTION_restorePackage = 4;
        static final int TRANSACTION_restoreSome = 3;

        public Stub() {
            attachInterface(this, "android.app.backup.IRestoreSession");
        }
    }


    public abstract void endRestoreSession() throws RemoteException;

    public abstract int getAvailableRestoreSets(IRestoreObserver irestoreobserver) throws RemoteException;

    public abstract int restoreAll(long l, IRestoreObserver irestoreobserver) throws RemoteException;

    public abstract int restorePackage(String s, IRestoreObserver irestoreobserver) throws RemoteException;

    public abstract int restoreSome(long l, IRestoreObserver irestoreobserver, String as[]) throws RemoteException;
}
