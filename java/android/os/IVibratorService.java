// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, IBinder, Binder, 
//            Parcel

public interface IVibratorService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IVibratorService {
        private static class Proxy
            implements IVibratorService {

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancelVibrate(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IVibratorService");
                parcel.writeStrongBinder(ibinder);
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

            public String getInterfaceDescriptor() {
                return "android.os.IVibratorService";
            }

            public boolean hasVibrator() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.IVibratorService");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void vibrate(long l, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IVibratorService");
                parcel.writeLong(l);
                parcel.writeStrongBinder(ibinder);
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

            public void vibratePattern(long al[], int i, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IVibratorService");
                parcel.writeLongArray(al);
                parcel.writeInt(i);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IVibratorService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.IVibratorService");
                if(iinterface != null && (iinterface instanceof IVibratorService))
                    obj = (IVibratorService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IVibratorService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 119
        //                       3: 144
        //                       4: 173
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("android.os.IVibratorService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.IVibratorService");
            boolean flag1 = hasVibrator();
            parcel1.writeNoException();
            int k;
            if(flag1)
                k = ((flag) ? 1 : 0);
            else
                k = 0;
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.os.IVibratorService");
            vibrate(parcel.readLong(), parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.os.IVibratorService");
            vibratePattern(parcel.createLongArray(), parcel.readInt(), parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.os.IVibratorService");
            cancelVibrate(parcel.readStrongBinder());
            parcel1.writeNoException();
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "android.os.IVibratorService";
        static final int TRANSACTION_cancelVibrate = 4;
        static final int TRANSACTION_hasVibrator = 1;
        static final int TRANSACTION_vibrate = 2;
        static final int TRANSACTION_vibratePattern = 3;

        public Stub() {
            attachInterface(this, "android.os.IVibratorService");
        }
    }


    public abstract void cancelVibrate(IBinder ibinder) throws RemoteException;

    public abstract boolean hasVibrator() throws RemoteException;

    public abstract void vibrate(long l, IBinder ibinder) throws RemoteException;

    public abstract void vibratePattern(long al[], int i, IBinder ibinder) throws RemoteException;
}
