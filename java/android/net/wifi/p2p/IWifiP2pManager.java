// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;

import android.os.*;

public interface IWifiP2pManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWifiP2pManager {
        private static class Proxy
            implements IWifiP2pManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.net.wifi.p2p.IWifiP2pManager";
            }

            public Messenger getMessenger() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.p2p.IWifiP2pManager");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Messenger messenger = (Messenger)Messenger.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return messenger;
_L2:
                messenger = null;
                if(true) goto _L4; else goto _L3
_L3:
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


        public static IWifiP2pManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.wifi.p2p.IWifiP2pManager");
                if(iinterface != null && (iinterface instanceof IWifiP2pManager))
                    obj = (IWifiP2pManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWifiP2pManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 2: default 32
        //                       1: 55
        //                       1598968902: 46;
               goto _L1 _L2 _L3
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L5:
            return flag;
_L3:
            parcel1.writeString("android.net.wifi.p2p.IWifiP2pManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.wifi.p2p.IWifiP2pManager");
            Messenger messenger = getMessenger();
            parcel1.writeNoException();
            if(messenger != null) {
                parcel1.writeInt(flag);
                messenger.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.net.wifi.p2p.IWifiP2pManager";
        static final int TRANSACTION_getMessenger = 1;

        public Stub() {
            attachInterface(this, "android.net.wifi.p2p.IWifiP2pManager");
        }
    }


    public abstract Messenger getMessenger() throws RemoteException;
}
