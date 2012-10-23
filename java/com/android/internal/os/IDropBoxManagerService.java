// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.os.*;

public interface IDropBoxManagerService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IDropBoxManagerService {
        private static class Proxy
            implements IDropBoxManagerService {

            public void add(android.os.DropBoxManager.Entry entry) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.os.IDropBoxManagerService");
                if(entry == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                entry.writeToParcel(parcel, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.os.IDropBoxManagerService";
            }

            public android.os.DropBoxManager.Entry getNextEntry(String s, long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.os.IDropBoxManagerService");
                parcel.writeString(s);
                parcel.writeLong(l);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                android.os.DropBoxManager.Entry entry = (android.os.DropBoxManager.Entry)android.os.DropBoxManager.Entry.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return entry;
_L2:
                entry = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isTagEnabled(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.os.IDropBoxManagerService");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IDropBoxManagerService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.os.IDropBoxManagerService");
                if(iinterface != null && (iinterface instanceof IDropBoxManagerService))
                    obj = (IDropBoxManagerService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IDropBoxManagerService) (obj));
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
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 117
        //                       3: 155
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("com.android.internal.os.IDropBoxManagerService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.os.IDropBoxManagerService");
            android.os.DropBoxManager.Entry entry1;
            if(parcel.readInt() != 0)
                entry1 = (android.os.DropBoxManager.Entry)android.os.DropBoxManager.Entry.CREATOR.createFromParcel(parcel);
            else
                entry1 = null;
            add(entry1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.os.IDropBoxManagerService");
            boolean flag1 = isTagEnabled(parcel.readString());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.os.IDropBoxManagerService");
            android.os.DropBoxManager.Entry entry = getNextEntry(parcel.readString(), parcel.readLong());
            parcel1.writeNoException();
            if(entry != null) {
                parcel1.writeInt(flag);
                entry.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "com.android.internal.os.IDropBoxManagerService";
        static final int TRANSACTION_add = 1;
        static final int TRANSACTION_getNextEntry = 3;
        static final int TRANSACTION_isTagEnabled = 2;

        public Stub() {
            attachInterface(this, "com.android.internal.os.IDropBoxManagerService");
        }
    }


    public abstract void add(android.os.DropBoxManager.Entry entry) throws RemoteException;

    public abstract android.os.DropBoxManager.Entry getNextEntry(String s, long l) throws RemoteException;

    public abstract boolean isTagEnabled(String s) throws RemoteException;
}
