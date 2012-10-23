// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os.storage;

import android.os.*;

// Referenced classes of package android.os.storage:
//            IObbActionListener, IMountServiceListener, IMountShutdownObserver, StorageVolume

public interface IMountService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IMountService {
        private static class Proxy
            implements IMountService {

            public IBinder asBinder() {
                return mRemote;
            }

            public int changeEncryptionPassword(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(29, parcel, parcel1, 0);
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

            public int createSecureContainer(String s, int i, String s1, String s2, int j, boolean flag) throws RemoteException {
                int k;
                Parcel parcel;
                Parcel parcel1;
                k = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int l;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeString(s1);
                parcel.writeString(s2);
                parcel.writeInt(j);
                if(flag)
                    k = 1;
                parcel.writeInt(k);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int decryptStorage(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(27, parcel, parcel1, 0);
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

            public int destroySecureContainer(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int encryptStorage(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(28, parcel, parcel1, 0);
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

            public int finalizeSecureContainer(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(12, parcel, parcel1, 0);
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

            public void finishMediaUpdate() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("IMountService");
                mRemote.transact(21, parcel, parcel1, 0);
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

            public int fixPermissionsSecureContainer(String s, int i, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeString(s1);
                mRemote.transact(34, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int formatVolume(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
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

            public int getEncryptionState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                mRemote.transact(32, parcel, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "IMountService";
            }

            public String getMountedObbPath(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(25, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getSecureContainerFilesystemPath(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(31, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String[] getSecureContainerList() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("IMountService");
                mRemote.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                as = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getSecureContainerPath(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int[] getStorageUsers(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int ai[];
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                ai = parcel1.createIntArray();
                parcel1.recycle();
                parcel.recycle();
                return ai;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public Parcelable[] getVolumeList() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                Parcelable aparcelable[];
                parcel.writeInterfaceToken("IMountService");
                mRemote.transact(30, parcel, parcel1, 0);
                parcel1.readException();
                aparcelable = parcel1.readParcelableArray(android/os/storage/StorageVolume.getClassLoader());
                parcel1.recycle();
                parcel.recycle();
                return aparcelable;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getVolumeState(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isExternalStorageEmulated() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                mRemote.transact(26, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isObbMounted(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(24, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isSecureContainerMounted(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isUsbMassStorageConnected() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isUsbMassStorageEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void mountObb(String s, String s1, IObbActionListener iobbactionlistener, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                parcel.writeString(s1);
                if(iobbactionlistener == null)
                    break MISSING_BLOCK_LABEL_88;
                ibinder = iobbactionlistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(22, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int mountSecureContainer(String s, String s1, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int mountVolume(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public void registerListener(IMountServiceListener imountservicelistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("IMountService");
                if(imountservicelistener == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = imountservicelistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int renameSecureContainer(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(17, parcel, parcel1, 0);
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

            public void setUsbMassStorageEnabled(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("IMountService");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void shutdown(IMountShutdownObserver imountshutdownobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("IMountService");
                if(imountshutdownobserver == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = imountshutdownobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void unmountObb(String s, boolean flag, IObbActionListener iobbactionlistener, int i) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                if(iobbactionlistener == null)
                    break MISSING_BLOCK_LABEL_99;
                ibinder = iobbactionlistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(23, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int unmountSecureContainer(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void unmountVolume(String s, boolean flag, boolean flag1) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                if(!flag)
                    break MISSING_BLOCK_LABEL_85;
                j = i;
_L1:
                parcel.writeInt(j);
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                j = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void unregisterListener(IMountServiceListener imountservicelistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("IMountService");
                if(imountservicelistener == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = imountservicelistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int verifyEncryptionPassword(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("IMountService");
                parcel.writeString(s);
                mRemote.transact(33, parcel, parcel1, 0);
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

            private final IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IMountService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("IMountService");
                if(iinterface != null && (iinterface instanceof IMountService))
                    obj = (IMountService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IMountService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 34: default 284
        //                       1: 310
        //                       2: 337
        //                       3: 364
        //                       4: 406
        //                       5: 444
        //                       6: 486
        //                       7: 518
        //                       8: 582
        //                       9: 614
        //                       10: 646
        //                       11: 678
        //                       12: 764
        //                       13: 796
        //                       14: 850
        //                       15: 890
        //                       16: 944
        //                       17: 990
        //                       18: 1026
        //                       19: 1058
        //                       20: 1086
        //                       21: 1113
        //                       22: 1133
        //                       23: 1172
        //                       24: 1229
        //                       25: 1275
        //                       26: 1307
        //                       27: 1349
        //                       28: 1381
        //                       29: 1413
        //                       30: 1445
        //                       31: 1474
        //                       32: 1506
        //                       34: 1534
        //                       1598968902: 298;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L37:
            return flag;
_L35:
            parcel1.writeString("IMountService");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("IMountService");
            registerListener(IMountServiceListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("IMountService");
            unregisterListener(IMountServiceListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("IMountService");
            boolean flag12 = isUsbMassStorageConnected();
            parcel1.writeNoException();
            int j5;
            if(flag12)
                j5 = 1;
            else
                j5 = 0;
            parcel1.writeInt(j5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("IMountService");
            boolean flag11;
            if(parcel.readInt() != 0)
                flag11 = true;
            else
                flag11 = false;
            setUsbMassStorageEnabled(flag11);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("IMountService");
            boolean flag10 = isUsbMassStorageEnabled();
            parcel1.writeNoException();
            int i5;
            if(flag10)
                i5 = 1;
            else
                i5 = 0;
            parcel1.writeInt(i5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("IMountService");
            int l4 = mountVolume(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(l4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("IMountService");
            String s10 = parcel.readString();
            boolean flag8;
            boolean flag9;
            if(parcel.readInt() != 0)
                flag8 = true;
            else
                flag8 = false;
            if(parcel.readInt() != 0)
                flag9 = true;
            else
                flag9 = false;
            unmountVolume(s10, flag8, flag9);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("IMountService");
            int k4 = formatVolume(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("IMountService");
            int ai[] = getStorageUsers(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeIntArray(ai);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("IMountService");
            String s9 = getVolumeState(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s9);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("IMountService");
            String s6 = parcel.readString();
            int l3 = parcel.readInt();
            String s7 = parcel.readString();
            String s8 = parcel.readString();
            int i4 = parcel.readInt();
            boolean flag7;
            int j4;
            if(parcel.readInt() != 0)
                flag7 = true;
            else
                flag7 = false;
            j4 = createSecureContainer(s6, l3, s7, s8, i4, flag7);
            parcel1.writeNoException();
            parcel1.writeInt(j4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("IMountService");
            int k3 = finalizeSecureContainer(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("IMountService");
            String s5 = parcel.readString();
            boolean flag6;
            int j3;
            if(parcel.readInt() != 0)
                flag6 = true;
            else
                flag6 = false;
            j3 = destroySecureContainer(s5, flag6);
            parcel1.writeNoException();
            parcel1.writeInt(j3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("IMountService");
            int i3 = mountSecureContainer(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(i3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("IMountService");
            String s4 = parcel.readString();
            boolean flag5;
            int l2;
            if(parcel.readInt() != 0)
                flag5 = true;
            else
                flag5 = false;
            l2 = unmountSecureContainer(s4, flag5);
            parcel1.writeNoException();
            parcel1.writeInt(l2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("IMountService");
            boolean flag4 = isSecureContainerMounted(parcel.readString());
            parcel1.writeNoException();
            int k2;
            if(flag4)
                k2 = 1;
            else
                k2 = 0;
            parcel1.writeInt(k2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("IMountService");
            int j2 = renameSecureContainer(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(j2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("IMountService");
            String s3 = getSecureContainerPath(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("IMountService");
            String as[] = getSecureContainerList();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("IMountService");
            shutdown(IMountShutdownObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("IMountService");
            finishMediaUpdate();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("IMountService");
            mountObb(parcel.readString(), parcel.readString(), IObbActionListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("IMountService");
            String s2 = parcel.readString();
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            unmountObb(s2, flag3, IObbActionListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("IMountService");
            boolean flag2 = isObbMounted(parcel.readString());
            parcel1.writeNoException();
            int i2;
            if(flag2)
                i2 = 1;
            else
                i2 = 0;
            parcel1.writeInt(i2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("IMountService");
            String s1 = getMountedObbPath(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("IMountService");
            boolean flag1 = isExternalStorageEmulated();
            parcel1.writeNoException();
            int l1;
            if(flag1)
                l1 = 1;
            else
                l1 = 0;
            parcel1.writeInt(l1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("IMountService");
            int k1 = decryptStorage(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("IMountService");
            int j1 = encryptStorage(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("IMountService");
            int i1 = changeEncryptionPassword(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("IMountService");
            Parcelable aparcelable[] = getVolumeList();
            parcel1.writeNoException();
            parcel1.writeParcelableArray(aparcelable, 0);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("IMountService");
            String s = getSecureContainerFilesystemPath(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("IMountService");
            int l = getEncryptionState();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("IMountService");
            int k = fixPermissionsSecureContainer(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k);
            flag = true;
            if(true) goto _L37; else goto _L36
_L36:
        }

        private static final String DESCRIPTOR = "IMountService";
        static final int TRANSACTION_changeEncryptionPassword = 29;
        static final int TRANSACTION_createSecureContainer = 11;
        static final int TRANSACTION_decryptStorage = 27;
        static final int TRANSACTION_destroySecureContainer = 13;
        static final int TRANSACTION_encryptStorage = 28;
        static final int TRANSACTION_finalizeSecureContainer = 12;
        static final int TRANSACTION_finishMediaUpdate = 21;
        static final int TRANSACTION_fixPermissionsSecureContainer = 34;
        static final int TRANSACTION_formatVolume = 8;
        static final int TRANSACTION_getEncryptionState = 32;
        static final int TRANSACTION_getMountedObbPath = 25;
        static final int TRANSACTION_getSecureContainerFilesystemPath = 31;
        static final int TRANSACTION_getSecureContainerList = 19;
        static final int TRANSACTION_getSecureContainerPath = 18;
        static final int TRANSACTION_getStorageUsers = 9;
        static final int TRANSACTION_getVolumeList = 30;
        static final int TRANSACTION_getVolumeState = 10;
        static final int TRANSACTION_isExternalStorageEmulated = 26;
        static final int TRANSACTION_isObbMounted = 24;
        static final int TRANSACTION_isSecureContainerMounted = 16;
        static final int TRANSACTION_isUsbMassStorageConnected = 3;
        static final int TRANSACTION_isUsbMassStorageEnabled = 5;
        static final int TRANSACTION_mountObb = 22;
        static final int TRANSACTION_mountSecureContainer = 14;
        static final int TRANSACTION_mountVolume = 6;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_renameSecureContainer = 17;
        static final int TRANSACTION_setUsbMassStorageEnabled = 4;
        static final int TRANSACTION_shutdown = 20;
        static final int TRANSACTION_unmountObb = 23;
        static final int TRANSACTION_unmountSecureContainer = 15;
        static final int TRANSACTION_unmountVolume = 7;
        static final int TRANSACTION_unregisterListener = 2;
        static final int TRANSACTION_verifyEncryptionPassword = 33;

        public Stub() {
            attachInterface(this, "IMountService");
        }
    }


    public abstract int changeEncryptionPassword(String s) throws RemoteException;

    public abstract int createSecureContainer(String s, int i, String s1, String s2, int j, boolean flag) throws RemoteException;

    public abstract int decryptStorage(String s) throws RemoteException;

    public abstract int destroySecureContainer(String s, boolean flag) throws RemoteException;

    public abstract int encryptStorage(String s) throws RemoteException;

    public abstract int finalizeSecureContainer(String s) throws RemoteException;

    public abstract void finishMediaUpdate() throws RemoteException;

    public abstract int fixPermissionsSecureContainer(String s, int i, String s1) throws RemoteException;

    public abstract int formatVolume(String s) throws RemoteException;

    public abstract int getEncryptionState() throws RemoteException;

    public abstract String getMountedObbPath(String s) throws RemoteException;

    public abstract String getSecureContainerFilesystemPath(String s) throws RemoteException;

    public abstract String[] getSecureContainerList() throws RemoteException;

    public abstract String getSecureContainerPath(String s) throws RemoteException;

    public abstract int[] getStorageUsers(String s) throws RemoteException;

    public abstract Parcelable[] getVolumeList() throws RemoteException;

    public abstract String getVolumeState(String s) throws RemoteException;

    public abstract boolean isExternalStorageEmulated() throws RemoteException;

    public abstract boolean isObbMounted(String s) throws RemoteException;

    public abstract boolean isSecureContainerMounted(String s) throws RemoteException;

    public abstract boolean isUsbMassStorageConnected() throws RemoteException;

    public abstract boolean isUsbMassStorageEnabled() throws RemoteException;

    public abstract void mountObb(String s, String s1, IObbActionListener iobbactionlistener, int i) throws RemoteException;

    public abstract int mountSecureContainer(String s, String s1, int i) throws RemoteException;

    public abstract int mountVolume(String s) throws RemoteException;

    public abstract void registerListener(IMountServiceListener imountservicelistener) throws RemoteException;

    public abstract int renameSecureContainer(String s, String s1) throws RemoteException;

    public abstract void setUsbMassStorageEnabled(boolean flag) throws RemoteException;

    public abstract void shutdown(IMountShutdownObserver imountshutdownobserver) throws RemoteException;

    public abstract void unmountObb(String s, boolean flag, IObbActionListener iobbactionlistener, int i) throws RemoteException;

    public abstract int unmountSecureContainer(String s, boolean flag) throws RemoteException;

    public abstract void unmountVolume(String s, boolean flag, boolean flag1) throws RemoteException;

    public abstract void unregisterListener(IMountServiceListener imountservicelistener) throws RemoteException;

    public abstract int verifyEncryptionPassword(String s) throws RemoteException;

    public static final int ENCRYPTION_STATE_ERROR_INCOMPLETE = -2;
    public static final int ENCRYPTION_STATE_ERROR_UNKNOWN = -1;
    public static final int ENCRYPTION_STATE_NONE = 1;
    public static final int ENCRYPTION_STATE_OK;
}
