// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.content.ComponentName;
import android.os.*;
import com.android.internal.os.PkgUsageStats;

public interface IUsageStats
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IUsageStats {
        private static class Proxy
            implements IUsageStats {

            public IBinder asBinder() {
                return mRemote;
            }

            public PkgUsageStats[] getAllPkgUsageStats() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                PkgUsageStats apkgusagestats[];
                parcel.writeInterfaceToken("com.android.internal.app.IUsageStats");
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                apkgusagestats = (PkgUsageStats[])parcel1.createTypedArray(PkgUsageStats.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return apkgusagestats;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.app.IUsageStats";
            }

            public PkgUsageStats getPkgUsageStats(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IUsageStats");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                PkgUsageStats pkgusagestats;
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_100;
                pkgusagestats = (PkgUsageStats)PkgUsageStats.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return pkgusagestats;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                pkgusagestats = null;
                  goto _L4
            }

            public void noteLaunchTime(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IUsageStats");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void notePauseComponent(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IUsageStats");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteResumeComponent(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IUsageStats");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
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


        public static IUsageStats asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.app.IUsageStats");
                if(iinterface != null && (iinterface instanceof IUsageStats))
                    obj = (IUsageStats)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IUsageStats) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 133
        //                       3: 179
        //                       4: 229
        //                       5: 304
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("com.android.internal.app.IUsageStats");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.app.IUsageStats");
            ComponentName componentname3;
            if(parcel.readInt() != 0)
                componentname3 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname3 = null;
            noteResumeComponent(componentname3);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.app.IUsageStats");
            ComponentName componentname2;
            if(parcel.readInt() != 0)
                componentname2 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname2 = null;
            notePauseComponent(componentname2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.app.IUsageStats");
            ComponentName componentname1;
            if(parcel.readInt() != 0)
                componentname1 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname1 = null;
            noteLaunchTime(componentname1, parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.app.IUsageStats");
            ComponentName componentname;
            PkgUsageStats pkgusagestats;
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            pkgusagestats = getPkgUsageStats(componentname);
            parcel1.writeNoException();
            if(pkgusagestats != null) {
                parcel1.writeInt(flag);
                pkgusagestats.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.app.IUsageStats");
            PkgUsageStats apkgusagestats[] = getAllPkgUsageStats();
            parcel1.writeNoException();
            parcel1.writeTypedArray(apkgusagestats, flag);
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "com.android.internal.app.IUsageStats";
        static final int TRANSACTION_getAllPkgUsageStats = 5;
        static final int TRANSACTION_getPkgUsageStats = 4;
        static final int TRANSACTION_noteLaunchTime = 3;
        static final int TRANSACTION_notePauseComponent = 2;
        static final int TRANSACTION_noteResumeComponent = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.app.IUsageStats");
        }
    }


    public abstract PkgUsageStats[] getAllPkgUsageStats() throws RemoteException;

    public abstract PkgUsageStats getPkgUsageStats(ComponentName componentname) throws RemoteException;

    public abstract void noteLaunchTime(ComponentName componentname, int i) throws RemoteException;

    public abstract void notePauseComponent(ComponentName componentname) throws RemoteException;

    public abstract void noteResumeComponent(ComponentName componentname) throws RemoteException;
}
