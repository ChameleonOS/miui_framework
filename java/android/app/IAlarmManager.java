// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.*;

// Referenced classes of package android.app:
//            PendingIntent

public interface IAlarmManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAlarmManager {
        private static class Proxy
            implements IAlarmManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.IAlarmManager";
            }

            public void remove(PendingIntent pendingintent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IAlarmManager");
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(6, parcel, parcel1, 0);
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

            public void set(int i, long l, PendingIntent pendingintent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IAlarmManager");
                parcel.writeInt(i);
                parcel.writeLong(l);
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_80;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
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

            public void setInexactRepeating(int i, long l, long l1, PendingIntent pendingintent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IAlarmManager");
                parcel.writeInt(i);
                parcel.writeLong(l);
                parcel.writeLong(l1);
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_87;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L1:
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

            public void setRepeating(int i, long l, long l1, PendingIntent pendingintent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IAlarmManager");
                parcel.writeInt(i);
                parcel.writeLong(l);
                parcel.writeLong(l1);
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_87;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
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

            public void setTime(long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IAlarmManager");
                parcel.writeLong(l);
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

            public void setTimeZone(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IAlarmManager");
                parcel.writeString(s);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAlarmManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IAlarmManager");
                if(iinterface != null && (iinterface instanceof IAlarmManager))
                    obj = (IAlarmManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAlarmManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 7: default 68
        //                       1: 94
        //                       2: 159
        //                       3: 232
        //                       4: 305
        //                       5: 329
        //                       6: 353
        //                       1598968902: 82;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L10:
            return flag;
_L8:
            parcel1.writeString("android.app.IAlarmManager");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IAlarmManager");
            int j1 = parcel.readInt();
            long l4 = parcel.readLong();
            PendingIntent pendingintent3;
            if(parcel.readInt() != 0)
                pendingintent3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent3 = null;
            set(j1, l4, pendingintent3);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.IAlarmManager");
            int i1 = parcel.readInt();
            long l2 = parcel.readLong();
            long l3 = parcel.readLong();
            PendingIntent pendingintent2;
            if(parcel.readInt() != 0)
                pendingintent2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent2 = null;
            setRepeating(i1, l2, l3, pendingintent2);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.IAlarmManager");
            int k = parcel.readInt();
            long l = parcel.readLong();
            long l1 = parcel.readLong();
            PendingIntent pendingintent1;
            if(parcel.readInt() != 0)
                pendingintent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent1 = null;
            setInexactRepeating(k, l, l1, pendingintent1);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.IAlarmManager");
            setTime(parcel.readLong());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.IAlarmManager");
            setTimeZone(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.app.IAlarmManager");
            PendingIntent pendingintent;
            if(parcel.readInt() != 0)
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent = null;
            remove(pendingintent);
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L10; else goto _L9
_L9:
        }

        private static final String DESCRIPTOR = "android.app.IAlarmManager";
        static final int TRANSACTION_remove = 6;
        static final int TRANSACTION_set = 1;
        static final int TRANSACTION_setInexactRepeating = 3;
        static final int TRANSACTION_setRepeating = 2;
        static final int TRANSACTION_setTime = 4;
        static final int TRANSACTION_setTimeZone = 5;

        public Stub() {
            attachInterface(this, "android.app.IAlarmManager");
        }
    }


    public abstract void remove(PendingIntent pendingintent) throws RemoteException;

    public abstract void set(int i, long l, PendingIntent pendingintent) throws RemoteException;

    public abstract void setInexactRepeating(int i, long l, long l1, PendingIntent pendingintent) throws RemoteException;

    public abstract void setRepeating(int i, long l, long l1, PendingIntent pendingintent) throws RemoteException;

    public abstract void setTime(long l) throws RemoteException;

    public abstract void setTimeZone(String s) throws RemoteException;
}
