// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.*;

public interface IPackageInstallObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IPackageInstallObserver {
        private static class Proxy
            implements IPackageInstallObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.content.pm.IPackageInstallObserver";
            }

            public void packageInstalled(String s, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageInstallObserver");
                parcel.writeString(s);
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


        public static IPackageInstallObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.pm.IPackageInstallObserver");
                if(iinterface != null && (iinterface instanceof IPackageInstallObserver))
                    obj = (IPackageInstallObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IPackageInstallObserver) (obj));
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
            parcel1.writeString("android.content.pm.IPackageInstallObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.pm.IPackageInstallObserver");
            packageInstalled(parcel.readString(), parcel.readInt());
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.content.pm.IPackageInstallObserver";
        static final int TRANSACTION_packageInstalled = 1;

        public Stub() {
            attachInterface(this, "android.content.pm.IPackageInstallObserver");
        }
    }


    public abstract void packageInstalled(String s, int i) throws RemoteException;
}
