// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.backup;

import android.app.backup.RestoreSet;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.*;

public interface IBackupTransport
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBackupTransport {
        private static class Proxy
            implements IBackupTransport {

            public IBinder asBinder() {
                return mRemote;
            }

            public int clearBackupData(PackageInfo packageinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                if(packageinfo == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                packageinfo.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public Intent configurationIntent() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return intent;
_L2:
                intent = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String currentDestinationString() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int finishBackup() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void finishRestore() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(14, parcel, parcel1, 0);
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

            public RestoreSet[] getAvailableRestoreSets() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                RestoreSet arestoreset[];
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                arestoreset = (RestoreSet[])parcel1.createTypedArray(RestoreSet.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arestoreset;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public long getCurrentRestoreSet() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.backup.IBackupTransport";
            }

            public int getRestoreData(ParcelFileDescriptor parcelfiledescriptor) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                if(parcelfiledescriptor == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int initializeDevice() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String nextRestorePackage() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int performBackup(PackageInfo packageinfo, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                if(packageinfo == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                packageinfo.writeToParcel(parcel, 0);
_L3:
                if(parcelfiledescriptor == null)
                    break MISSING_BLOCK_LABEL_107;
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L4:
                int i;
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public long requestBackupTime() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int startRestore(long l, PackageInfo apackageinfo[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                parcel.writeLong(l);
                parcel.writeTypedArray(apackageinfo, 0);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String transportDirName() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.backup.IBackupTransport");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
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


        public static IBackupTransport asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.backup.IBackupTransport");
                if(iinterface != null && (iinterface instanceof IBackupTransport))
                    obj = (IBackupTransport)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBackupTransport) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 15: default 136
        //                       1: 159
        //                       2: 205
        //                       3: 230
        //                       4: 255
        //                       5: 280
        //                       6: 305
        //                       7: 388
        //                       8: 442
        //                       9: 467
        //                       10: 494
        //                       11: 519
        //                       12: 558
        //                       13: 583
        //                       14: 637
        //                       1598968902: 150;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L18:
            return flag;
_L16:
            parcel1.writeString("com.android.internal.backup.IBackupTransport");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            Intent intent = configurationIntent();
            parcel1.writeNoException();
            if(intent != null) {
                parcel1.writeInt(flag);
                intent.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            String s2 = currentDestinationString();
            parcel1.writeNoException();
            parcel1.writeString(s2);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            String s1 = transportDirName();
            parcel1.writeNoException();
            parcel1.writeString(s1);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            long l2 = requestBackupTime();
            parcel1.writeNoException();
            parcel1.writeLong(l2);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            int i2 = initializeDevice();
            parcel1.writeNoException();
            parcel1.writeInt(i2);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            PackageInfo packageinfo1;
            ParcelFileDescriptor parcelfiledescriptor1;
            int k1;
            if(parcel.readInt() != 0)
                packageinfo1 = (PackageInfo)PackageInfo.CREATOR.createFromParcel(parcel);
            else
                packageinfo1 = null;
            if(parcel.readInt() != 0)
                parcelfiledescriptor1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor1 = null;
            k1 = performBackup(packageinfo1, parcelfiledescriptor1);
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            PackageInfo packageinfo;
            int j1;
            if(parcel.readInt() != 0)
                packageinfo = (PackageInfo)PackageInfo.CREATOR.createFromParcel(parcel);
            else
                packageinfo = null;
            j1 = clearBackupData(packageinfo);
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            int i1 = finishBackup();
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            RestoreSet arestoreset[] = getAvailableRestoreSets();
            parcel1.writeNoException();
            parcel1.writeTypedArray(arestoreset, flag);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            long l1 = getCurrentRestoreSet();
            parcel1.writeNoException();
            parcel1.writeLong(l1);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            int l = startRestore(parcel.readLong(), (PackageInfo[])parcel.createTypedArray(PackageInfo.CREATOR));
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            String s = nextRestorePackage();
            parcel1.writeNoException();
            parcel1.writeString(s);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            ParcelFileDescriptor parcelfiledescriptor;
            int k;
            if(parcel.readInt() != 0)
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor = null;
            k = getRestoreData(parcelfiledescriptor);
            parcel1.writeNoException();
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("com.android.internal.backup.IBackupTransport");
            finishRestore();
            parcel1.writeNoException();
            if(true) goto _L18; else goto _L17
_L17:
        }

        private static final String DESCRIPTOR = "com.android.internal.backup.IBackupTransport";
        static final int TRANSACTION_clearBackupData = 7;
        static final int TRANSACTION_configurationIntent = 1;
        static final int TRANSACTION_currentDestinationString = 2;
        static final int TRANSACTION_finishBackup = 8;
        static final int TRANSACTION_finishRestore = 14;
        static final int TRANSACTION_getAvailableRestoreSets = 9;
        static final int TRANSACTION_getCurrentRestoreSet = 10;
        static final int TRANSACTION_getRestoreData = 13;
        static final int TRANSACTION_initializeDevice = 5;
        static final int TRANSACTION_nextRestorePackage = 12;
        static final int TRANSACTION_performBackup = 6;
        static final int TRANSACTION_requestBackupTime = 4;
        static final int TRANSACTION_startRestore = 11;
        static final int TRANSACTION_transportDirName = 3;

        public Stub() {
            attachInterface(this, "com.android.internal.backup.IBackupTransport");
        }
    }


    public abstract int clearBackupData(PackageInfo packageinfo) throws RemoteException;

    public abstract Intent configurationIntent() throws RemoteException;

    public abstract String currentDestinationString() throws RemoteException;

    public abstract int finishBackup() throws RemoteException;

    public abstract void finishRestore() throws RemoteException;

    public abstract RestoreSet[] getAvailableRestoreSets() throws RemoteException;

    public abstract long getCurrentRestoreSet() throws RemoteException;

    public abstract int getRestoreData(ParcelFileDescriptor parcelfiledescriptor) throws RemoteException;

    public abstract int initializeDevice() throws RemoteException;

    public abstract String nextRestorePackage() throws RemoteException;

    public abstract int performBackup(PackageInfo packageinfo, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException;

    public abstract long requestBackupTime() throws RemoteException;

    public abstract int startRestore(long l, PackageInfo apackageinfo[]) throws RemoteException;

    public abstract String transportDirName() throws RemoteException;
}
