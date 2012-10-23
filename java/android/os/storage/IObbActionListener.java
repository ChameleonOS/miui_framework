// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os.storage;

import android.os.*;

public interface IObbActionListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IObbActionListener {
        private static class Proxy
            implements IObbActionListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "IObbActionListener";
            }

            public void onObbResult(String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("IObbActionListener");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(1, parcel, parcel1, 1);
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


        public static IObbActionListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("IObbActionListener");
                if(iinterface != null && (iinterface instanceof IObbActionListener))
                    obj = (IObbActionListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IObbActionListener) (obj));
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
            parcel1.writeString("IObbActionListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("IObbActionListener");
            onObbResult(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "IObbActionListener";
        static final int TRANSACTION_onObbResult = 1;

        public Stub() {
            attachInterface(this, "IObbActionListener");
        }
    }


    public abstract void onObbResult(String s, int i, int j) throws RemoteException;
}
