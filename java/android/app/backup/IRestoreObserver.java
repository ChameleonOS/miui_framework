// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.os.*;

// Referenced classes of package android.app.backup:
//            RestoreSet

public interface IRestoreObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRestoreObserver {
        private static class Proxy
            implements IRestoreObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.backup.IRestoreObserver";
            }

            public void onUpdate(int i, String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IRestoreObserver");
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

            public void restoreFinished(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IRestoreObserver");
                parcel.writeInt(i);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void restoreSetsAvailable(RestoreSet arestoreset[]) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IRestoreObserver");
                parcel.writeTypedArray(arestoreset, 0);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void restoreStarting(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IRestoreObserver");
                parcel.writeInt(i);
                mRemote.transact(2, parcel, null, 1);
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


        public static IRestoreObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.backup.IRestoreObserver");
                if(iinterface != null && (iinterface instanceof IRestoreObserver))
                    obj = (IRestoreObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRestoreObserver) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 102
        //                       3: 119
        //                       4: 140
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("android.app.backup.IRestoreObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.backup.IRestoreObserver");
            restoreSetsAvailable((RestoreSet[])parcel.createTypedArray(RestoreSet.CREATOR));
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.backup.IRestoreObserver");
            restoreStarting(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.backup.IRestoreObserver");
            onUpdate(parcel.readInt(), parcel.readString());
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.backup.IRestoreObserver");
            restoreFinished(parcel.readInt());
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "android.app.backup.IRestoreObserver";
        static final int TRANSACTION_onUpdate = 3;
        static final int TRANSACTION_restoreFinished = 4;
        static final int TRANSACTION_restoreSetsAvailable = 1;
        static final int TRANSACTION_restoreStarting = 2;

        public Stub() {
            attachInterface(this, "android.app.backup.IRestoreObserver");
        }
    }


    public abstract void onUpdate(int i, String s) throws RemoteException;

    public abstract void restoreFinished(int i) throws RemoteException;

    public abstract void restoreSetsAvailable(RestoreSet arestoreset[]) throws RemoteException;

    public abstract void restoreStarting(int i) throws RemoteException;
}
