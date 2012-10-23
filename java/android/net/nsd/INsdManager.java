// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.nsd;

import android.os.*;

public interface INsdManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INsdManager {
        private static class Proxy
            implements INsdManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.net.nsd.INsdManager";
            }

            public Messenger getMessenger() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.nsd.INsdManager");
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

            public void setEnabled(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.nsd.INsdManager");
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static INsdManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.nsd.INsdManager");
                if(iinterface != null && (iinterface instanceof INsdManager))
                    obj = (INsdManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INsdManager) (obj));
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
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 109
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag1 = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag1;
_L4:
            parcel1.writeString("android.net.nsd.INsdManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.nsd.INsdManager");
            Messenger messenger = getMessenger();
            parcel1.writeNoException();
            if(messenger != null) {
                parcel1.writeInt(flag1);
                messenger.writeToParcel(parcel1, flag1);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.nsd.INsdManager");
            if(parcel.readInt() != 0)
                flag = flag1;
            setEnabled(flag);
            parcel1.writeNoException();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.net.nsd.INsdManager";
        static final int TRANSACTION_getMessenger = 1;
        static final int TRANSACTION_setEnabled = 2;

        public Stub() {
            attachInterface(this, "android.net.nsd.INsdManager");
        }
    }


    public abstract Messenger getMessenger() throws RemoteException;

    public abstract void setEnabled(boolean flag) throws RemoteException;
}
