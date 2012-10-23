// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.*;

public interface IThrottleManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IThrottleManager {
        private static class Proxy
            implements IThrottleManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public long getByteCount(String s, int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("android.net.IThrottleManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public int getCliffLevel(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.IThrottleManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public long getCliffThreshold(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("android.net.IThrottleManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public String getHelpUri() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.net.IThrottleManager");
                mRemote.transact(7, parcel, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "android.net.IThrottleManager";
            }

            public long getPeriodStartTime(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("android.net.IThrottleManager");
                parcel.writeString(s);
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

            public long getResetTime(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("android.net.IThrottleManager");
                parcel.writeString(s);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public int getThrottle(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IThrottleManager");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IThrottleManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.IThrottleManager");
                if(iinterface != null && (iinterface instanceof IThrottleManager))
                    obj = (IThrottleManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IThrottleManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 8: default 80
        //                       1: 103
        //                       2: 144
        //                       3: 173
        //                       4: 202
        //                       5: 231
        //                       6: 264
        //                       7: 297
        //                       1598968902: 94;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L11:
            return flag;
_L9:
            parcel1.writeString("android.net.IThrottleManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.IThrottleManager");
            long l3 = getByteCount(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeLong(l3);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.IThrottleManager");
            int i1 = getThrottle(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.IThrottleManager");
            long l2 = getResetTime(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeLong(l2);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.IThrottleManager");
            long l1 = getPeriodStartTime(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeLong(l1);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.IThrottleManager");
            long l = getCliffThreshold(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeLong(l);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.net.IThrottleManager");
            int k = getCliffLevel(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.net.IThrottleManager");
            String s = getHelpUri();
            parcel1.writeNoException();
            parcel1.writeString(s);
            if(true) goto _L11; else goto _L10
_L10:
        }

        private static final String DESCRIPTOR = "android.net.IThrottleManager";
        static final int TRANSACTION_getByteCount = 1;
        static final int TRANSACTION_getCliffLevel = 6;
        static final int TRANSACTION_getCliffThreshold = 5;
        static final int TRANSACTION_getHelpUri = 7;
        static final int TRANSACTION_getPeriodStartTime = 4;
        static final int TRANSACTION_getResetTime = 3;
        static final int TRANSACTION_getThrottle = 2;

        public Stub() {
            attachInterface(this, "android.net.IThrottleManager");
        }
    }


    public abstract long getByteCount(String s, int i, int j, int k) throws RemoteException;

    public abstract int getCliffLevel(String s, int i) throws RemoteException;

    public abstract long getCliffThreshold(String s, int i) throws RemoteException;

    public abstract String getHelpUri() throws RemoteException;

    public abstract long getPeriodStartTime(String s) throws RemoteException;

    public abstract long getResetTime(String s) throws RemoteException;

    public abstract int getThrottle(String s) throws RemoteException;
}
