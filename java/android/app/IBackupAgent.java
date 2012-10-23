// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.app.backup.IBackupManager;
import android.os.*;

public interface IBackupAgent
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBackupAgent {
        private static class Proxy
            implements IBackupAgent {

            public IBinder asBinder() {
                return mRemote;
            }

            public void doBackup(ParcelFileDescriptor parcelfiledescriptor, ParcelFileDescriptor parcelfiledescriptor1, ParcelFileDescriptor parcelfiledescriptor2, int i, IBackupManager ibackupmanager) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IBackupAgent");
                if(parcelfiledescriptor == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L5:
                if(parcelfiledescriptor1 == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                parcelfiledescriptor1.writeToParcel(parcel, 0);
_L6:
                if(parcelfiledescriptor2 == null)
                    break MISSING_BLOCK_LABEL_143;
                parcel.writeInt(1);
                parcelfiledescriptor2.writeToParcel(parcel, 0);
_L7:
                parcel.writeInt(i);
                if(ibackupmanager != null)
                    ibinder = ibackupmanager.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L5
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
_L4:
                parcel.writeInt(0);
                  goto _L6
                parcel.writeInt(0);
                  goto _L7
            }

            public void doFullBackup(ParcelFileDescriptor parcelfiledescriptor, int i, IBackupManager ibackupmanager) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IBackupAgent");
                if(parcelfiledescriptor == null)
                    break MISSING_BLOCK_LABEL_78;
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                if(ibackupmanager != null)
                    ibinder = ibackupmanager.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void doRestore(ParcelFileDescriptor parcelfiledescriptor, int i, ParcelFileDescriptor parcelfiledescriptor1, int j, IBackupManager ibackupmanager) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IBackupAgent");
                if(parcelfiledescriptor == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L3:
                parcel.writeInt(i);
                if(parcelfiledescriptor1 == null)
                    break MISSING_BLOCK_LABEL_123;
                parcel.writeInt(1);
                parcelfiledescriptor1.writeToParcel(parcel, 0);
_L4:
                parcel.writeInt(j);
                if(ibackupmanager != null)
                    ibinder = ibackupmanager.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void doRestoreFile(ParcelFileDescriptor parcelfiledescriptor, long l, int i, String s, String s1, long l1, long l2, int j, IBackupManager ibackupmanager) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IBackupAgent");
                if(parcelfiledescriptor == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                parcel.writeLong(l);
                parcel.writeInt(i);
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeLong(l1);
                parcel.writeLong(l2);
                parcel.writeInt(j);
                if(ibackupmanager == null)
                    break MISSING_BLOCK_LABEL_138;
                ibinder = ibackupmanager.asBinder();
_L4:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                ibinder = null;
                  goto _L4
            }

            public String getInterfaceDescriptor() {
                return "android.app.IBackupAgent";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IBackupAgent asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IBackupAgent");
                if(iinterface != null && (iinterface instanceof IBackupAgent))
                    obj = (IBackupAgent)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBackupAgent) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 5: default 52
        //                       1: 78
        //                       2: 192
        //                       3: 285
        //                       4: 341
        //                       1598968902: 66;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("android.app.IBackupAgent");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IBackupAgent");
            ParcelFileDescriptor parcelfiledescriptor4;
            ParcelFileDescriptor parcelfiledescriptor5;
            ParcelFileDescriptor parcelfiledescriptor6;
            if(parcel.readInt() != 0)
                parcelfiledescriptor4 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor4 = null;
            if(parcel.readInt() != 0)
                parcelfiledescriptor5 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor5 = null;
            if(parcel.readInt() != 0)
                parcelfiledescriptor6 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor6 = null;
            doBackup(parcelfiledescriptor4, parcelfiledescriptor5, parcelfiledescriptor6, parcel.readInt(), android.app.backup.IBackupManager.Stub.asInterface(parcel.readStrongBinder()));
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.IBackupAgent");
            ParcelFileDescriptor parcelfiledescriptor2;
            int j1;
            ParcelFileDescriptor parcelfiledescriptor3;
            if(parcel.readInt() != 0)
                parcelfiledescriptor2 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor2 = null;
            j1 = parcel.readInt();
            if(parcel.readInt() != 0)
                parcelfiledescriptor3 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor3 = null;
            doRestore(parcelfiledescriptor2, j1, parcelfiledescriptor3, parcel.readInt(), android.app.backup.IBackupManager.Stub.asInterface(parcel.readStrongBinder()));
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.IBackupAgent");
            ParcelFileDescriptor parcelfiledescriptor1;
            if(parcel.readInt() != 0)
                parcelfiledescriptor1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor1 = null;
            doFullBackup(parcelfiledescriptor1, parcel.readInt(), android.app.backup.IBackupManager.Stub.asInterface(parcel.readStrongBinder()));
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.IBackupAgent");
            ParcelFileDescriptor parcelfiledescriptor;
            long l;
            int k;
            String s;
            String s1;
            long l1;
            long l2;
            int i1;
            IBackupManager ibackupmanager;
            if(parcel.readInt() != 0)
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor = null;
            l = parcel.readLong();
            k = parcel.readInt();
            s = parcel.readString();
            s1 = parcel.readString();
            l1 = parcel.readLong();
            l2 = parcel.readLong();
            i1 = parcel.readInt();
            ibackupmanager = android.app.backup.IBackupManager.Stub.asInterface(parcel.readStrongBinder());
            doRestoreFile(parcelfiledescriptor, l, k, s, s1, l1, l2, i1, ibackupmanager);
            flag = true;
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "android.app.IBackupAgent";
        static final int TRANSACTION_doBackup = 1;
        static final int TRANSACTION_doFullBackup = 3;
        static final int TRANSACTION_doRestore = 2;
        static final int TRANSACTION_doRestoreFile = 4;

        public Stub() {
            attachInterface(this, "android.app.IBackupAgent");
        }
    }


    public abstract void doBackup(ParcelFileDescriptor parcelfiledescriptor, ParcelFileDescriptor parcelfiledescriptor1, ParcelFileDescriptor parcelfiledescriptor2, int i, IBackupManager ibackupmanager) throws RemoteException;

    public abstract void doFullBackup(ParcelFileDescriptor parcelfiledescriptor, int i, IBackupManager ibackupmanager) throws RemoteException;

    public abstract void doRestore(ParcelFileDescriptor parcelfiledescriptor, int i, ParcelFileDescriptor parcelfiledescriptor1, int j, IBackupManager ibackupmanager) throws RemoteException;

    public abstract void doRestoreFile(ParcelFileDescriptor parcelfiledescriptor, long l, int i, String s, String s1, long l1, long l2, int j, IBackupManager ibackupmanager) throws RemoteException;
}
