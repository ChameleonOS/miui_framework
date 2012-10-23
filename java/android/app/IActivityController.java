// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Intent;
import android.os.*;

public interface IActivityController
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IActivityController {
        private static class Proxy
            implements IActivityController {

            public boolean activityResuming(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.IActivityController");
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

            public boolean activityStarting(Intent intent, String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IActivityController");
                if(intent == null)
                    break MISSING_BLOCK_LABEL_87;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L1:
                int i;
                parcel.writeString(s);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean appCrashed(String s, int i, String s1, String s2, long l, String s3) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.app.IActivityController");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeString(s1);
                parcel.writeString(s2);
                parcel.writeLong(l);
                parcel.writeString(s3);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public int appEarlyNotResponding(String s, int i, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.app.IActivityController");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeString(s1);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public int appNotResponding(String s, int i, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.app.IActivityController");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeString(s1);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.IActivityController";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IActivityController asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IActivityController");
                if(iinterface != null && (iinterface instanceof IActivityController))
                    obj = (IActivityController)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IActivityController) (obj));
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
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 160
        //                       3: 198
        //                       4: 256
        //                       5: 293
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.app.IActivityController");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IActivityController");
            Intent intent;
            boolean flag3;
            int j1;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            flag3 = activityStarting(intent, parcel.readString());
            parcel1.writeNoException();
            if(flag3)
                j1 = ((flag) ? 1 : 0);
            else
                j1 = 0;
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.IActivityController");
            boolean flag2 = activityResuming(parcel.readString());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.IActivityController");
            boolean flag1 = appCrashed(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.IActivityController");
            int i1 = appEarlyNotResponding(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.IActivityController");
            int l = appNotResponding(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(l);
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.app.IActivityController";
        static final int TRANSACTION_activityResuming = 2;
        static final int TRANSACTION_activityStarting = 1;
        static final int TRANSACTION_appCrashed = 3;
        static final int TRANSACTION_appEarlyNotResponding = 4;
        static final int TRANSACTION_appNotResponding = 5;

        public Stub() {
            attachInterface(this, "android.app.IActivityController");
        }
    }


    public abstract boolean activityResuming(String s) throws RemoteException;

    public abstract boolean activityStarting(Intent intent, String s) throws RemoteException;

    public abstract boolean appCrashed(String s, int i, String s1, String s2, long l, String s3) throws RemoteException;

    public abstract int appEarlyNotResponding(String s, int i, String s1) throws RemoteException;

    public abstract int appNotResponding(String s, int i, String s1) throws RemoteException;
}
