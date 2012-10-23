// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.policy;

import android.os.*;

public interface IFaceLockCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IFaceLockCallback {
        private static class Proxy
            implements IFaceLockCallback {

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancel() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockCallback");
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void exposeFallback() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockCallback");
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.policy.IFaceLockCallback";
            }

            public void pokeWakelock(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockCallback");
                parcel.writeInt(i);
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void reportFailedAttempt() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockCallback");
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void unlock() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockCallback");
                mRemote.transact(1, parcel, null, 1);
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


        public static IFaceLockCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.policy.IFaceLockCallback");
                if(iinterface != null && (iinterface instanceof IFaceLockCallback))
                    obj = (IFaceLockCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IFaceLockCallback) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 100
        //                       3: 113
        //                       4: 126
        //                       5: 139
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("com.android.internal.policy.IFaceLockCallback");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockCallback");
            unlock();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockCallback");
            cancel();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockCallback");
            reportFailedAttempt();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockCallback");
            exposeFallback();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockCallback");
            pokeWakelock(parcel.readInt());
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "com.android.internal.policy.IFaceLockCallback";
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_exposeFallback = 4;
        static final int TRANSACTION_pokeWakelock = 5;
        static final int TRANSACTION_reportFailedAttempt = 3;
        static final int TRANSACTION_unlock = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.policy.IFaceLockCallback");
        }
    }


    public abstract void cancel() throws RemoteException;

    public abstract void exposeFallback() throws RemoteException;

    public abstract void pokeWakelock(int i) throws RemoteException;

    public abstract void reportFailedAttempt() throws RemoteException;

    public abstract void unlock() throws RemoteException;
}
