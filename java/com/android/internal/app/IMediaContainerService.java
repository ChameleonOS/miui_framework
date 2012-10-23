// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.content.pm.ContainerEncryptionParams;
import android.content.pm.PackageInfoLite;
import android.content.res.ObbInfo;
import android.net.Uri;
import android.os.*;

public interface IMediaContainerService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IMediaContainerService {
        private static class Proxy
            implements IMediaContainerService {

            public IBinder asBinder() {
                return mRemote;
            }

            public long calculateDirectorySize(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                parcel.writeString(s);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public boolean checkExternalFreeStorage(Uri uri, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
                  goto _L3
_L4:
                int i;
                int j;
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L6:
                i = 0;
                  goto _L4
_L3:
                if(!flag) goto _L6; else goto _L5
_L5:
                i = ((flag1) ? 1 : 0);
                  goto _L4
            }

            public boolean checkInternalFreeStorage(Uri uri, boolean flag, long l) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
                  goto _L3
_L4:
                int i;
                int j;
                parcel.writeInt(i);
                parcel.writeLong(l);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L6:
                i = 0;
                  goto _L4
_L3:
                if(!flag) goto _L6; else goto _L5
_L5:
                i = ((flag1) ? 1 : 0);
                  goto _L4
            }

            public void clearDirectory(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                parcel.writeString(s);
                mRemote.transact(9, parcel, parcel1, 0);
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

            public int copyResource(Uri uri, ContainerEncryptionParams containerencryptionparams, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
_L5:
                if(containerencryptionparams == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                containerencryptionparams.writeToParcel(parcel, 0);
_L6:
                if(parcelfiledescriptor == null)
                    break MISSING_BLOCK_LABEL_142;
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L7:
                int i;
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
_L2:
                parcel.writeInt(0);
                  goto _L5
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L4:
                parcel.writeInt(0);
                  goto _L6
                parcel.writeInt(0);
                  goto _L7
            }

            public String copyResourceToContainer(Uri uri, String s, String s1, String s2, String s3, boolean flag, boolean flag1) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
_L3:
                int j;
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                parcel.writeString(s3);
                if(!flag)
                    break MISSING_BLOCK_LABEL_156;
                j = i;
_L4:
                parcel.writeInt(j);
                Exception exception;
                String s4;
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                s4 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s4;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                j = 0;
                  goto _L4
            }

            public long[] getFileSystemStats(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long al[];
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                parcel.writeString(s);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                al = parcel1.createLongArray();
                parcel1.recycle();
                parcel.recycle();
                return al;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.app.IMediaContainerService";
            }

            public PackageInfoLite getMinimalPackageInfo(String s, int i, long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeLong(l);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                PackageInfoLite packageinfolite = (PackageInfoLite)PackageInfoLite.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return packageinfolite;
_L2:
                packageinfolite = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ObbInfo getObbInfo(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IMediaContainerService");
                parcel.writeString(s);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ObbInfo obbinfo = (ObbInfo)ObbInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return obbinfo;
_L2:
                obbinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
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


        public static IMediaContainerService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.app.IMediaContainerService");
                if(iinterface != null && (iinterface instanceof IMediaContainerService))
                    obj = (IMediaContainerService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IMediaContainerService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 10: default 92
        //                       1: 118
        //                       2: 243
        //                       3: 358
        //                       4: 417
        //                       5: 510
        //                       6: 599
        //                       7: 650
        //                       8: 682
        //                       9: 714
        //                       1598968902: 106;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L13:
            return flag;
_L11:
            parcel1.writeString("com.android.internal.app.IMediaContainerService");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            Uri uri3;
            String s;
            String s1;
            String s2;
            String s3;
            boolean flag5;
            boolean flag6;
            String s4;
            if(parcel.readInt() != 0)
                uri3 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri3 = null;
            s = parcel.readString();
            s1 = parcel.readString();
            s2 = parcel.readString();
            s3 = parcel.readString();
            if(parcel.readInt() != 0)
                flag5 = true;
            else
                flag5 = false;
            if(parcel.readInt() != 0)
                flag6 = true;
            else
                flag6 = false;
            s4 = copyResourceToContainer(uri3, s, s1, s2, s3, flag5, flag6);
            parcel1.writeNoException();
            parcel1.writeString(s4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            Uri uri2;
            ContainerEncryptionParams containerencryptionparams;
            ParcelFileDescriptor parcelfiledescriptor;
            int j1;
            if(parcel.readInt() != 0)
                uri2 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri2 = null;
            if(parcel.readInt() != 0)
                containerencryptionparams = (ContainerEncryptionParams)ContainerEncryptionParams.CREATOR.createFromParcel(parcel);
            else
                containerencryptionparams = null;
            if(parcel.readInt() != 0)
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor = null;
            j1 = copyResource(uri2, containerencryptionparams, parcelfiledescriptor);
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            PackageInfoLite packageinfolite = getMinimalPackageInfo(parcel.readString(), parcel.readInt(), parcel.readLong());
            parcel1.writeNoException();
            if(packageinfolite != null) {
                parcel1.writeInt(1);
                packageinfolite.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            Uri uri1;
            boolean flag3;
            boolean flag4;
            int i1;
            if(parcel.readInt() != 0)
                uri1 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri1 = null;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            flag4 = checkInternalFreeStorage(uri1, flag3, parcel.readLong());
            parcel1.writeNoException();
            if(flag4)
                i1 = 1;
            else
                i1 = 0;
            parcel1.writeInt(i1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            Uri uri;
            boolean flag1;
            boolean flag2;
            int k;
            if(parcel.readInt() != 0)
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri = null;
            if(parcel.readInt() != 0)
                flag1 = true;
            else
                flag1 = false;
            flag2 = checkExternalFreeStorage(uri, flag1);
            parcel1.writeNoException();
            if(flag2)
                k = 1;
            else
                k = 0;
            parcel1.writeInt(k);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            ObbInfo obbinfo = getObbInfo(parcel.readString());
            parcel1.writeNoException();
            if(obbinfo != null) {
                parcel1.writeInt(1);
                obbinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            long l = calculateDirectorySize(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeLong(l);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            long al[] = getFileSystemStats(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeLongArray(al);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.app.IMediaContainerService");
            clearDirectory(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final String DESCRIPTOR = "com.android.internal.app.IMediaContainerService";
        static final int TRANSACTION_calculateDirectorySize = 7;
        static final int TRANSACTION_checkExternalFreeStorage = 5;
        static final int TRANSACTION_checkInternalFreeStorage = 4;
        static final int TRANSACTION_clearDirectory = 9;
        static final int TRANSACTION_copyResource = 2;
        static final int TRANSACTION_copyResourceToContainer = 1;
        static final int TRANSACTION_getFileSystemStats = 8;
        static final int TRANSACTION_getMinimalPackageInfo = 3;
        static final int TRANSACTION_getObbInfo = 6;

        public Stub() {
            attachInterface(this, "com.android.internal.app.IMediaContainerService");
        }
    }


    public abstract long calculateDirectorySize(String s) throws RemoteException;

    public abstract boolean checkExternalFreeStorage(Uri uri, boolean flag) throws RemoteException;

    public abstract boolean checkInternalFreeStorage(Uri uri, boolean flag, long l) throws RemoteException;

    public abstract void clearDirectory(String s) throws RemoteException;

    public abstract int copyResource(Uri uri, ContainerEncryptionParams containerencryptionparams, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException;

    public abstract String copyResourceToContainer(Uri uri, String s, String s1, String s2, String s3, boolean flag, boolean flag1) throws RemoteException;

    public abstract long[] getFileSystemStats(String s) throws RemoteException;

    public abstract PackageInfoLite getMinimalPackageInfo(String s, int i, long l) throws RemoteException;

    public abstract ObbInfo getObbInfo(String s) throws RemoteException;
}
