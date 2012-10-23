// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.*;

// Referenced classes of package android.content.pm:
//            PackageStats

public interface IPackageStatsObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IPackageStatsObserver {
        private static class Proxy
            implements IPackageStatsObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.content.pm.IPackageStatsObserver";
            }

            public void onGetStatsCompleted(PackageStats packagestats, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageStatsObserver");
                if(packagestats != null) {
                    parcel.writeInt(1);
                    packagestats.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_80;
                }
                  goto _L1
_L2:
                parcel.writeInt(i);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_80;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L2
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IPackageStatsObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.pm.IPackageStatsObserver");
                if(iinterface != null && (iinterface instanceof IPackageStatsObserver))
                    obj = (IPackageStatsObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IPackageStatsObserver) (obj));
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
            parcel1.writeString("android.content.pm.IPackageStatsObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.pm.IPackageStatsObserver");
            PackageStats packagestats;
            boolean flag1;
            if(parcel.readInt() != 0)
                packagestats = (PackageStats)PackageStats.CREATOR.createFromParcel(parcel);
            else
                packagestats = null;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            onGetStatsCompleted(packagestats, flag1);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.content.pm.IPackageStatsObserver";
        static final int TRANSACTION_onGetStatsCompleted = 1;

        public Stub() {
            attachInterface(this, "android.content.pm.IPackageStatsObserver");
        }
    }


    public abstract void onGetStatsCompleted(PackageStats packagestats, boolean flag) throws RemoteException;
}
