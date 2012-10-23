// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.*;

public interface INetworkManagementEventObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INetworkManagementEventObserver {
        private static class Proxy
            implements INetworkManagementEventObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.net.INetworkManagementEventObserver";
            }

            public void interfaceAdded(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkManagementEventObserver");
                parcel.writeString(s);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void interfaceLinkStateChanged(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkManagementEventObserver");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
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

            public void interfaceRemoved(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkManagementEventObserver");
                parcel.writeString(s);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void interfaceStatusChanged(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkManagementEventObserver");
                parcel.writeString(s);
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
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

            public void limitReached(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkManagementEventObserver");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static INetworkManagementEventObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.INetworkManagementEventObserver");
                if(iinterface != null && (iinterface instanceof INetworkManagementEventObserver))
                    obj = (INetworkManagementEventObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INetworkManagementEventObserver) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag;
            boolean flag1;
            flag = false;
            flag1 = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 125
        //                       3: 163
        //                       4: 184
        //                       5: 205
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag1 = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag1;
_L7:
            parcel1.writeString("android.net.INetworkManagementEventObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.INetworkManagementEventObserver");
            String s1 = parcel.readString();
            if(parcel.readInt() != 0)
                flag = flag1;
            interfaceStatusChanged(s1, flag);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.INetworkManagementEventObserver");
            String s = parcel.readString();
            if(parcel.readInt() != 0)
                flag = flag1;
            interfaceLinkStateChanged(s, flag);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.INetworkManagementEventObserver");
            interfaceAdded(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.INetworkManagementEventObserver");
            interfaceRemoved(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.INetworkManagementEventObserver");
            limitReached(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.net.INetworkManagementEventObserver";
        static final int TRANSACTION_interfaceAdded = 3;
        static final int TRANSACTION_interfaceLinkStateChanged = 2;
        static final int TRANSACTION_interfaceRemoved = 4;
        static final int TRANSACTION_interfaceStatusChanged = 1;
        static final int TRANSACTION_limitReached = 5;

        public Stub() {
            attachInterface(this, "android.net.INetworkManagementEventObserver");
        }
    }


    public abstract void interfaceAdded(String s) throws RemoteException;

    public abstract void interfaceLinkStateChanged(String s, boolean flag) throws RemoteException;

    public abstract void interfaceRemoved(String s) throws RemoteException;

    public abstract void interfaceStatusChanged(String s, boolean flag) throws RemoteException;

    public abstract void limitReached(String s, String s1) throws RemoteException;
}
