// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.os.*;

public interface ILockSettings
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ILockSettings {
        private static class Proxy
            implements ILockSettings {

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean checkPassword(byte abyte0[], int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeByteArray(abyte0);
                parcel.writeInt(i);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
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

            public boolean checkPattern(byte abyte0[], int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeByteArray(abyte0);
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
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

            public boolean getBoolean(String s, boolean flag, int i) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeString(s);
                if(!flag)
                    break MISSING_BLOCK_LABEL_93;
                j = ((flag1) ? 1 : 0);
_L1:
                int k;
                parcel.writeInt(j);
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
                j = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.widget.ILockSettings";
            }

            public long getLong(String s, long l, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l1;
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeString(s);
                parcel.writeLong(l);
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                l1 = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getString(String s, String s1, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s2;
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                s2 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s2;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean havePassword(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeInt(i);
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
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

            public boolean havePattern(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
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

            public void removeUser(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
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

            public void setBoolean(String s, boolean flag, int i) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeString(s);
                if(!flag)
                    j = 0;
                parcel.writeInt(j);
                parcel.writeInt(i);
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

            public void setLockPassword(byte abyte0[], int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeByteArray(abyte0);
                parcel.writeInt(i);
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

            public void setLockPattern(byte abyte0[], int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeByteArray(abyte0);
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

            public void setLong(String s, long l, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeString(s);
                parcel.writeLong(l);
                parcel.writeInt(i);
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

            public void setString(String s, String s1, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.ILockSettings");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ILockSettings asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.widget.ILockSettings");
                if(iinterface != null && (iinterface instanceof ILockSettings))
                    obj = (ILockSettings)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ILockSettings) (obj));
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
            JVM INSTR lookupswitch 14: default 128
        //                       1: 151
        //                       2: 199
        //                       3: 228
        //                       4: 257
        //                       5: 322
        //                       6: 359
        //                       7: 396
        //                       8: 421
        //                       9: 463
        //                       10: 488
        //                       11: 530
        //                       12: 568
        //                       13: 606
        //                       1598968902: 142;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L17:
            return flag;
_L15:
            parcel1.writeString("com.android.internal.widget.ILockSettings");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            String s2 = parcel.readString();
            boolean flag7;
            if(parcel.readInt() != 0)
                flag7 = flag;
            else
                flag7 = false;
            setBoolean(s2, flag7, parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            setLong(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            setString(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            String s1 = parcel.readString();
            boolean flag5;
            boolean flag6;
            if(parcel.readInt() != 0)
                flag5 = flag;
            else
                flag5 = false;
            flag6 = getBoolean(s1, flag5, parcel.readInt());
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            long l = getLong(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeLong(l);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            String s = getString(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeString(s);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            setLockPattern(parcel.createByteArray(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            boolean flag4 = checkPattern(parcel.createByteArray(), parcel.readInt());
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            setLockPassword(parcel.createByteArray(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            boolean flag3 = checkPassword(parcel.createByteArray(), parcel.readInt());
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            boolean flag2 = havePattern(parcel.readInt());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            boolean flag1 = havePassword(parcel.readInt());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.widget.ILockSettings");
            removeUser(parcel.readInt());
            parcel1.writeNoException();
            if(true) goto _L17; else goto _L16
_L16:
        }

        private static final String DESCRIPTOR = "com.android.internal.widget.ILockSettings";
        static final int TRANSACTION_checkPassword = 10;
        static final int TRANSACTION_checkPattern = 8;
        static final int TRANSACTION_getBoolean = 4;
        static final int TRANSACTION_getLong = 5;
        static final int TRANSACTION_getString = 6;
        static final int TRANSACTION_havePassword = 12;
        static final int TRANSACTION_havePattern = 11;
        static final int TRANSACTION_removeUser = 13;
        static final int TRANSACTION_setBoolean = 1;
        static final int TRANSACTION_setLockPassword = 9;
        static final int TRANSACTION_setLockPattern = 7;
        static final int TRANSACTION_setLong = 2;
        static final int TRANSACTION_setString = 3;

        public Stub() {
            attachInterface(this, "com.android.internal.widget.ILockSettings");
        }
    }


    public abstract boolean checkPassword(byte abyte0[], int i) throws RemoteException;

    public abstract boolean checkPattern(byte abyte0[], int i) throws RemoteException;

    public abstract boolean getBoolean(String s, boolean flag, int i) throws RemoteException;

    public abstract long getLong(String s, long l, int i) throws RemoteException;

    public abstract String getString(String s, String s1, int i) throws RemoteException;

    public abstract boolean havePassword(int i) throws RemoteException;

    public abstract boolean havePattern(int i) throws RemoteException;

    public abstract void removeUser(int i) throws RemoteException;

    public abstract void setBoolean(String s, boolean flag, int i) throws RemoteException;

    public abstract void setLockPassword(byte abyte0[], int i) throws RemoteException;

    public abstract void setLockPattern(byte abyte0[], int i) throws RemoteException;

    public abstract void setLong(String s, long l, int i) throws RemoteException;

    public abstract void setString(String s, String s1, int i) throws RemoteException;
}
