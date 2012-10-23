// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.net;

import android.os.*;

public interface IFirewall
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IFirewall {
        private static class Proxy
            implements IFirewall {

            public void addAccessControlPass(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeString(s);
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

            public void addOneShotFlag(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean checkAccessControlPass(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeString(s);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "miui.net.IFirewall";
            }

            public boolean getOneShotFlag(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeInt(i);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onDataConnected(int i, String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeInt(i);
                parcel.writeString(s);
                parcel.writeString(s1);
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

            public void onDataDisconnected(int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeInt(i);
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

            public void onStartUsingNetworkFeature(int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
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

            public void onStopUsingNetworkFeature(int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
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

            public void removeAccessControlPass(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.IFirewall");
                parcel.writeString(s);
                mRemote.transact(6, parcel, parcel1, 0);
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


        public static IFirewall asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("miui.net.IFirewall");
                if(iinterface != null && (iinterface instanceof IFirewall))
                    obj = (IFirewall)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IFirewall) (obj));
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
            JVM INSTR lookupswitch 10: default 96
        //                       1: 119
        //                       2: 148
        //                       3: 177
        //                       4: 206
        //                       5: 231
        //                       6: 252
        //                       7: 273
        //                       8: 311
        //                       9: 332
        //                       1598968902: 110;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L13:
            return flag;
_L11:
            parcel1.writeString("miui.net.IFirewall");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("miui.net.IFirewall");
            onStartUsingNetworkFeature(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("miui.net.IFirewall");
            onStopUsingNetworkFeature(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("miui.net.IFirewall");
            onDataConnected(parcel.readInt(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("miui.net.IFirewall");
            onDataDisconnected(parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("miui.net.IFirewall");
            addAccessControlPass(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("miui.net.IFirewall");
            removeAccessControlPass(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("miui.net.IFirewall");
            boolean flag2 = checkAccessControlPass(parcel.readString());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("miui.net.IFirewall");
            addOneShotFlag(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("miui.net.IFirewall");
            boolean flag1 = getOneShotFlag(parcel.readInt());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final String DESCRIPTOR = "miui.net.IFirewall";
        static final int TRANSACTION_addAccessControlPass = 5;
        static final int TRANSACTION_addOneShotFlag = 8;
        static final int TRANSACTION_checkAccessControlPass = 7;
        static final int TRANSACTION_getOneShotFlag = 9;
        static final int TRANSACTION_onDataConnected = 3;
        static final int TRANSACTION_onDataDisconnected = 4;
        static final int TRANSACTION_onStartUsingNetworkFeature = 1;
        static final int TRANSACTION_onStopUsingNetworkFeature = 2;
        static final int TRANSACTION_removeAccessControlPass = 6;

        public Stub() {
            attachInterface(this, "miui.net.IFirewall");
        }
    }


    public abstract void addAccessControlPass(String s) throws RemoteException;

    public abstract void addOneShotFlag(int i) throws RemoteException;

    public abstract boolean checkAccessControlPass(String s) throws RemoteException;

    public abstract boolean getOneShotFlag(int i) throws RemoteException;

    public abstract void onDataConnected(int i, String s, String s1) throws RemoteException;

    public abstract void onDataDisconnected(int i, String s) throws RemoteException;

    public abstract void onStartUsingNetworkFeature(int i, int j, int k) throws RemoteException;

    public abstract void onStopUsingNetworkFeature(int i, int j, int k) throws RemoteException;

    public abstract void removeAccessControlPass(String s) throws RemoteException;
}
