// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.os.*;

public interface IResultReceiver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IResultReceiver {
        private static class Proxy
            implements IResultReceiver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.os.IResultReceiver";
            }

            public void send(int i, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.os.IResultReceiver");
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
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


        public static IResultReceiver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.os.IResultReceiver");
                if(iinterface != null && (iinterface instanceof IResultReceiver))
                    obj = (IResultReceiver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IResultReceiver) (obj));
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
            parcel1.writeString("com.android.internal.os.IResultReceiver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.os.IResultReceiver");
            int k = parcel.readInt();
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            send(k, bundle);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "com.android.internal.os.IResultReceiver";
        static final int TRANSACTION_send = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.os.IResultReceiver");
        }
    }


    public abstract void send(int i, Bundle bundle) throws RemoteException;
}
