// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.policy;

import android.os.*;

// Referenced classes of package com.android.internal.policy:
//            IFaceLockCallback

public interface IFaceLockInterface
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IFaceLockInterface {
        private static class Proxy
            implements IFaceLockInterface {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.policy.IFaceLockInterface";
            }

            public void registerCallback(IFaceLockCallback ifacelockcallback) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockInterface");
                if(ifacelockcallback == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = ifacelockcallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void startUi(IBinder ibinder, int i, int j, int k, int l, boolean flag) throws RemoteException {
                int i1;
                Parcel parcel;
                Parcel parcel1;
                i1 = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockInterface");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                if(!flag)
                    i1 = 0;
                parcel.writeInt(i1);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public void stopUi() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockInterface");
                mRemote.transact(2, parcel, parcel1, 0);
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

            public void unregisterCallback(IFaceLockCallback ifacelockcallback) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("com.android.internal.policy.IFaceLockInterface");
                if(ifacelockcallback == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = ifacelockcallback.asBinder();
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IFaceLockInterface asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.policy.IFaceLockInterface");
                if(iinterface != null && (iinterface instanceof IFaceLockInterface))
                    obj = (IFaceLockInterface)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IFaceLockInterface) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 155
        //                       3: 172
        //                       4: 196
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("com.android.internal.policy.IFaceLockInterface");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockInterface");
            IBinder ibinder = parcel.readStrongBinder();
            int k = parcel.readInt();
            int l = parcel.readInt();
            int i1 = parcel.readInt();
            int j1 = parcel.readInt();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            startUi(ibinder, k, l, i1, j1, flag1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockInterface");
            stopUi();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockInterface");
            registerCallback(IFaceLockCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.policy.IFaceLockInterface");
            unregisterCallback(IFaceLockCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "com.android.internal.policy.IFaceLockInterface";
        static final int TRANSACTION_registerCallback = 3;
        static final int TRANSACTION_startUi = 1;
        static final int TRANSACTION_stopUi = 2;
        static final int TRANSACTION_unregisterCallback = 4;

        public Stub() {
            attachInterface(this, "com.android.internal.policy.IFaceLockInterface");
        }
    }


    public abstract void registerCallback(IFaceLockCallback ifacelockcallback) throws RemoteException;

    public abstract void startUi(IBinder ibinder, int i, int j, int k, int l, boolean flag) throws RemoteException;

    public abstract void stopUi() throws RemoteException;

    public abstract void unregisterCallback(IFaceLockCallback ifacelockcallback) throws RemoteException;
}
