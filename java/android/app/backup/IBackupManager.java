// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.content.Intent;
import android.os.*;

// Referenced classes of package android.app.backup:
//            IFullBackupRestoreObserver, IRestoreSession

public interface IBackupManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBackupManager {
        private static class Proxy
            implements IBackupManager {

            public void acknowledgeFullBackupOrRestore(int i, boolean flag, String s, String s1, IFullBackupRestoreObserver ifullbackuprestoreobserver) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                parcel.writeString(s);
                parcel.writeString(s1);
                if(ifullbackuprestoreobserver == null)
                    break MISSING_BLOCK_LABEL_107;
                ibinder = ifullbackuprestoreobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public void agentConnected(String s, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void agentDisconnected(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void backupNow() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                mRemote.transact(12, parcel, parcel1, 0);
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

            public IRestoreSession beginRestoreSession(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IRestoreSession irestoresession;
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                irestoresession = IRestoreSession.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return irestoresession;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void clearBackupData(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
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

            public void dataChanged(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public void fullBackup(ParcelFileDescriptor parcelfiledescriptor, boolean flag, boolean flag1, boolean flag2, boolean flag3, String as[]) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                if(parcelfiledescriptor == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
                  goto _L3
_L8:
                int j;
                parcel.writeInt(j);
                if(!flag1) goto _L5; else goto _L4
_L4:
                int k = i;
_L9:
                parcel.writeInt(k);
                if(!flag2) goto _L7; else goto _L6
_L6:
                int l = i;
_L10:
                parcel.writeInt(l);
                Exception exception;
                if(!flag3)
                    i = 0;
                parcel.writeInt(i);
                parcel.writeStringArray(as);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L12:
                j = 0;
                  goto _L8
_L5:
                k = 0;
                  goto _L9
_L7:
                l = 0;
                  goto _L10
_L3:
                if(!flag) goto _L12; else goto _L11
_L11:
                j = i;
                  goto _L8
            }

            public void fullRestore(ParcelFileDescriptor parcelfiledescriptor) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                if(parcelfiledescriptor == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(14, parcel, parcel1, 0);
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

            public Intent getConfigurationIntent(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
                mRemote.transact(19, parcel, parcel1, 0);
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

            public String getCurrentTransport() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                mRemote.transact(16, parcel, parcel1, 0);
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

            public String getDestinationString(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
                mRemote.transact(20, parcel, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "android.app.backup.IBackupManager";
            }

            public boolean hasBackupPassword() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                mRemote.transact(11, parcel, parcel1, 0);
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

            public boolean isBackupEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                mRemote.transact(9, parcel, parcel1, 0);
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

            public String[] listAllTransports() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                mRemote.transact(17, parcel, parcel1, 0);
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

            public void opComplete(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeInt(i);
                mRemote.transact(22, parcel, parcel1, 0);
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

            public void restoreAtInstall(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public String selectBackupTransport(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
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

            public void setAutoRestore(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public void setBackupEnabled(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public boolean setBackupPassword(String s, String s1) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void setBackupProvisioned(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.backup.IBackupManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IBackupManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.backup.IBackupManager");
                if(iinterface != null && (iinterface instanceof IBackupManager))
                    obj = (IBackupManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBackupManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            int k;
            boolean flag;
            k = 0;
            flag = true;
            i;
            JVM INSTR lookupswitch 23: default 200
        //                       1: 223
        //                       2: 244
        //                       3: 265
        //                       4: 290
        //                       5: 311
        //                       6: 336
        //                       7: 372
        //                       8: 408
        //                       9: 444
        //                       10: 478
        //                       11: 520
        //                       12: 554
        //                       13: 571
        //                       14: 697
        //                       15: 743
        //                       16: 802
        //                       17: 827
        //                       18: 852
        //                       19: 881
        //                       20: 931
        //                       21: 960
        //                       22: 1013
        //                       1598968902: 214;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L26:
            return flag;
_L24:
            parcel1.writeString("android.app.backup.IBackupManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            dataChanged(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            clearBackupData(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            agentConnected(parcel.readString(), parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            agentDisconnected(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            restoreAtInstall(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            boolean flag11;
            if(parcel.readInt() != 0)
                flag11 = flag;
            else
                flag11 = false;
            setBackupEnabled(flag11);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            boolean flag10;
            if(parcel.readInt() != 0)
                flag10 = flag;
            else
                flag10 = false;
            setAutoRestore(flag10);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            boolean flag9;
            if(parcel.readInt() != 0)
                flag9 = flag;
            else
                flag9 = false;
            setBackupProvisioned(flag9);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            boolean flag8 = isBackupEnabled();
            parcel1.writeNoException();
            if(flag8)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            boolean flag7 = setBackupPassword(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(flag7)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            boolean flag6 = hasBackupPassword();
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            backupNow();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            ParcelFileDescriptor parcelfiledescriptor1;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            boolean flag5;
            if(parcel.readInt() != 0)
                parcelfiledescriptor1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor1 = null;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            if(parcel.readInt() != 0)
                flag4 = flag;
            else
                flag4 = false;
            if(parcel.readInt() != 0)
                flag5 = flag;
            else
                flag5 = false;
            fullBackup(parcelfiledescriptor1, flag2, flag3, flag4, flag5, parcel.createStringArray());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            ParcelFileDescriptor parcelfiledescriptor;
            if(parcel.readInt() != 0)
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor = null;
            fullRestore(parcelfiledescriptor);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            int l = parcel.readInt();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            acknowledgeFullBackupOrRestore(l, flag1, parcel.readString(), parcel.readString(), IFullBackupRestoreObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            String s2 = getCurrentTransport();
            parcel1.writeNoException();
            parcel1.writeString(s2);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            String as[] = listAllTransports();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            String s1 = selectBackupTransport(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s1);
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            Intent intent = getConfigurationIntent(parcel.readString());
            parcel1.writeNoException();
            if(intent != null) {
                parcel1.writeInt(flag);
                intent.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            String s = getDestinationString(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s);
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            IRestoreSession irestoresession = beginRestoreSession(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            IBinder ibinder;
            if(irestoresession != null)
                ibinder = irestoresession.asBinder();
            else
                ibinder = null;
            parcel1.writeStrongBinder(ibinder);
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.app.backup.IBackupManager");
            opComplete(parcel.readInt());
            parcel1.writeNoException();
            if(true) goto _L26; else goto _L25
_L25:
        }

        private static final String DESCRIPTOR = "android.app.backup.IBackupManager";
        static final int TRANSACTION_acknowledgeFullBackupOrRestore = 15;
        static final int TRANSACTION_agentConnected = 3;
        static final int TRANSACTION_agentDisconnected = 4;
        static final int TRANSACTION_backupNow = 12;
        static final int TRANSACTION_beginRestoreSession = 21;
        static final int TRANSACTION_clearBackupData = 2;
        static final int TRANSACTION_dataChanged = 1;
        static final int TRANSACTION_fullBackup = 13;
        static final int TRANSACTION_fullRestore = 14;
        static final int TRANSACTION_getConfigurationIntent = 19;
        static final int TRANSACTION_getCurrentTransport = 16;
        static final int TRANSACTION_getDestinationString = 20;
        static final int TRANSACTION_hasBackupPassword = 11;
        static final int TRANSACTION_isBackupEnabled = 9;
        static final int TRANSACTION_listAllTransports = 17;
        static final int TRANSACTION_opComplete = 22;
        static final int TRANSACTION_restoreAtInstall = 5;
        static final int TRANSACTION_selectBackupTransport = 18;
        static final int TRANSACTION_setAutoRestore = 7;
        static final int TRANSACTION_setBackupEnabled = 6;
        static final int TRANSACTION_setBackupPassword = 10;
        static final int TRANSACTION_setBackupProvisioned = 8;

        public Stub() {
            attachInterface(this, "android.app.backup.IBackupManager");
        }
    }


    public abstract void acknowledgeFullBackupOrRestore(int i, boolean flag, String s, String s1, IFullBackupRestoreObserver ifullbackuprestoreobserver) throws RemoteException;

    public abstract void agentConnected(String s, IBinder ibinder) throws RemoteException;

    public abstract void agentDisconnected(String s) throws RemoteException;

    public abstract void backupNow() throws RemoteException;

    public abstract IRestoreSession beginRestoreSession(String s, String s1) throws RemoteException;

    public abstract void clearBackupData(String s) throws RemoteException;

    public abstract void dataChanged(String s) throws RemoteException;

    public abstract void fullBackup(ParcelFileDescriptor parcelfiledescriptor, boolean flag, boolean flag1, boolean flag2, boolean flag3, String as[]) throws RemoteException;

    public abstract void fullRestore(ParcelFileDescriptor parcelfiledescriptor) throws RemoteException;

    public abstract Intent getConfigurationIntent(String s) throws RemoteException;

    public abstract String getCurrentTransport() throws RemoteException;

    public abstract String getDestinationString(String s) throws RemoteException;

    public abstract boolean hasBackupPassword() throws RemoteException;

    public abstract boolean isBackupEnabled() throws RemoteException;

    public abstract String[] listAllTransports() throws RemoteException;

    public abstract void opComplete(int i) throws RemoteException;

    public abstract void restoreAtInstall(String s, int i) throws RemoteException;

    public abstract String selectBackupTransport(String s) throws RemoteException;

    public abstract void setAutoRestore(boolean flag) throws RemoteException;

    public abstract void setBackupEnabled(boolean flag) throws RemoteException;

    public abstract boolean setBackupPassword(String s, String s1) throws RemoteException;

    public abstract void setBackupProvisioned(boolean flag) throws RemoteException;
}
