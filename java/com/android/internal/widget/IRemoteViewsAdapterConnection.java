// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.os.*;

public interface IRemoteViewsAdapterConnection
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRemoteViewsAdapterConnection {
        private static class Proxy
            implements IRemoteViewsAdapterConnection {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.widget.IRemoteViewsAdapterConnection";
            }

            public void onServiceConnected(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsAdapterConnection");
                parcel.writeStrongBinder(ibinder);
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

            public void onServiceDisconnected() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsAdapterConnection");
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IRemoteViewsAdapterConnection asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.widget.IRemoteViewsAdapterConnection");
                if(iinterface != null && (iinterface instanceof IRemoteViewsAdapterConnection))
                    obj = (IRemoteViewsAdapterConnection)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRemoteViewsAdapterConnection) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 84
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("com.android.internal.widget.IRemoteViewsAdapterConnection");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsAdapterConnection");
            onServiceConnected(parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsAdapterConnection");
            onServiceDisconnected();
            parcel1.writeNoException();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "com.android.internal.widget.IRemoteViewsAdapterConnection";
        static final int TRANSACTION_onServiceConnected = 1;
        static final int TRANSACTION_onServiceDisconnected = 2;

        public Stub() {
            attachInterface(this, "com.android.internal.widget.IRemoteViewsAdapterConnection");
        }
    }


    public abstract void onServiceConnected(IBinder ibinder) throws RemoteException;

    public abstract void onServiceDisconnected() throws RemoteException;
}
