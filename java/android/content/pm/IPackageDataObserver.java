// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.*;

public interface IPackageDataObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IPackageDataObserver {
        private static class Proxy
            implements IPackageDataObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.content.pm.IPackageDataObserver";
            }

            public void onRemoveCompleted(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageDataObserver");
                parcel.writeString(s);
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
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


        public static IPackageDataObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.pm.IPackageDataObserver");
                if(iinterface != null && (iinterface instanceof IPackageDataObserver))
                    obj = (IPackageDataObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IPackageDataObserver) (obj));
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
            parcel1.writeString("android.content.pm.IPackageDataObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.pm.IPackageDataObserver");
            String s = parcel.readString();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            onRemoveCompleted(s, flag1);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.content.pm.IPackageDataObserver";
        static final int TRANSACTION_onRemoveCompleted = 1;

        public Stub() {
            attachInterface(this, "android.content.pm.IPackageDataObserver");
        }
    }


    public abstract void onRemoveCompleted(String s, boolean flag) throws RemoteException;
}
