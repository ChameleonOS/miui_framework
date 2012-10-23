// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.*;

public interface IProcessObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IProcessObserver {
        private static class Proxy
            implements IProcessObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.IProcessObserver";
            }

            public void onForegroundActivitiesChanged(int i, int j, boolean flag) throws RemoteException {
                int k;
                Parcel parcel;
                k = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IProcessObserver");
                parcel.writeInt(i);
                parcel.writeInt(j);
                if(!flag)
                    k = 0;
                parcel.writeInt(k);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onImportanceChanged(int i, int j, int k) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IProcessObserver");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onProcessDied(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IProcessObserver");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(3, parcel, null, 1);
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


        public static IProcessObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IProcessObserver");
                if(iinterface != null && (iinterface instanceof IProcessObserver))
                    obj = (IProcessObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IProcessObserver) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 119
        //                       3: 144
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.app.IProcessObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IProcessObserver");
            int k = parcel.readInt();
            int l = parcel.readInt();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            onForegroundActivitiesChanged(k, l, flag1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.IProcessObserver");
            onImportanceChanged(parcel.readInt(), parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.IProcessObserver");
            onProcessDied(parcel.readInt(), parcel.readInt());
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.app.IProcessObserver";
        static final int TRANSACTION_onForegroundActivitiesChanged = 1;
        static final int TRANSACTION_onImportanceChanged = 2;
        static final int TRANSACTION_onProcessDied = 3;

        public Stub() {
            attachInterface(this, "android.app.IProcessObserver");
        }
    }


    public abstract void onForegroundActivitiesChanged(int i, int j, boolean flag) throws RemoteException;

    public abstract void onImportanceChanged(int i, int j, int k) throws RemoteException;

    public abstract void onProcessDied(int i, int j) throws RemoteException;
}
