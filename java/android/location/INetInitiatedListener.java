// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;

public interface INetInitiatedListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INetInitiatedListener {
        private static class Proxy
            implements INetInitiatedListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.location.INetInitiatedListener";
            }

            public boolean sendNiResponse(int i, int j) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("android.location.INetInitiatedListener");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
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


        public static INetInitiatedListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.INetInitiatedListener");
                if(iinterface != null && (iinterface instanceof INetInitiatedListener))
                    obj = (INetInitiatedListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INetInitiatedListener) (obj));
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
            parcel1.writeString("android.location.INetInitiatedListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.INetInitiatedListener");
            boolean flag1 = sendNiResponse(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            int k;
            if(flag1)
                k = ((flag) ? 1 : 0);
            else
                k = 0;
            parcel1.writeInt(k);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.location.INetInitiatedListener";
        static final int TRANSACTION_sendNiResponse = 1;

        public Stub() {
            attachInterface(this, "android.location.INetInitiatedListener");
        }
    }


    public abstract boolean sendNiResponse(int i, int j) throws RemoteException;
}
