// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.dreams;

import android.os.*;

public interface IDreamService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IDreamService {
        private static class Proxy
            implements IDreamService {

            public IBinder asBinder() {
                return mRemote;
            }

            public void attach(IBinder ibinder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.dreams.IDreamService");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.service.dreams.IDreamService";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IDreamService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.service.dreams.IDreamService");
                if(iinterface != null && (iinterface instanceof IDreamService))
                    obj = (IDreamService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IDreamService) (obj));
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
            parcel1.writeString("android.service.dreams.IDreamService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.service.dreams.IDreamService");
            attach(parcel.readStrongBinder());
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.service.dreams.IDreamService";
        static final int TRANSACTION_attach = 1;

        public Stub() {
            attachInterface(this, "android.service.dreams.IDreamService");
        }
    }


    public abstract void attach(IBinder ibinder) throws RemoteException;
}
