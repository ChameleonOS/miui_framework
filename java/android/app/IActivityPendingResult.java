// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.*;

public interface IActivityPendingResult
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IActivityPendingResult {
        private static class Proxy
            implements IActivityPendingResult {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.IActivityPendingResult";
            }

            public boolean sendResult(int i, String s, Bundle bundle) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IActivityPendingResult");
                parcel.writeInt(i);
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_95;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                int j;
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
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


        public static IActivityPendingResult asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IActivityPendingResult");
                if(iinterface != null && (iinterface instanceof IActivityPendingResult))
                    obj = (IActivityPendingResult)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IActivityPendingResult) (obj));
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
            parcel1.writeString("android.app.IActivityPendingResult");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IActivityPendingResult");
            int k = parcel.readInt();
            String s = parcel.readString();
            Bundle bundle;
            boolean flag1;
            int l;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            flag1 = sendResult(k, s, bundle);
            parcel1.writeNoException();
            if(flag1)
                l = ((flag) ? 1 : 0);
            else
                l = 0;
            parcel1.writeInt(l);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.app.IActivityPendingResult";
        static final int TRANSACTION_sendResult = 1;

        public Stub() {
            attachInterface(this, "android.app.IActivityPendingResult");
        }
    }


    public abstract boolean sendResult(int i, String s, Bundle bundle) throws RemoteException;
}
