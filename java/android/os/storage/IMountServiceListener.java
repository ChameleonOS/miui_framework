// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os.storage;

import android.os.*;

public interface IMountServiceListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IMountServiceListener {
        private static class Proxy
            implements IMountServiceListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "IMountServiceListener";
            }

            public void onStorageStateChanged(String s, String s1, String s2) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("IMountServiceListener");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
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

            public void onUsbMassStorageConnectionChanged(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("IMountServiceListener");
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IMountServiceListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("IMountServiceListener");
                if(iinterface != null && (iinterface instanceof IMountServiceListener))
                    obj = (IMountServiceListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IMountServiceListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 99
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("IMountServiceListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("IMountServiceListener");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            onUsbMassStorageConnectionChanged(flag1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("IMountServiceListener");
            onStorageStateChanged(parcel.readString(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "IMountServiceListener";
        static final int TRANSACTION_onStorageStateChanged = 2;
        static final int TRANSACTION_onUsbMassStorageConnectionChanged = 1;

        public Stub() {
            attachInterface(this, "IMountServiceListener");
        }
    }


    public abstract void onStorageStateChanged(String s, String s1, String s2) throws RemoteException;

    public abstract void onUsbMassStorageConnectionChanged(boolean flag) throws RemoteException;
}
