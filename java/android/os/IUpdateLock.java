// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, IBinder, Binder, 
//            Parcel

public interface IUpdateLock
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IUpdateLock {
        private static class Proxy
            implements IUpdateLock {

            public void acquireUpdateLock(IBinder ibinder, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IUpdateLock");
                parcel.writeStrongBinder(ibinder);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.os.IUpdateLock";
            }

            public void releaseUpdateLock(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IUpdateLock");
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IUpdateLock asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.IUpdateLock");
                if(iinterface != null && (iinterface instanceof IUpdateLock))
                    obj = (IUpdateLock)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IUpdateLock) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 88
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.os.IUpdateLock");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.IUpdateLock");
            acquireUpdateLock(parcel.readStrongBinder(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.os.IUpdateLock");
            releaseUpdateLock(parcel.readStrongBinder());
            parcel1.writeNoException();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.os.IUpdateLock";
        static final int TRANSACTION_acquireUpdateLock = 1;
        static final int TRANSACTION_releaseUpdateLock = 2;

        public Stub() {
            attachInterface(this, "android.os.IUpdateLock");
        }
    }


    public abstract void acquireUpdateLock(IBinder ibinder, String s) throws RemoteException;

    public abstract void releaseUpdateLock(IBinder ibinder) throws RemoteException;
}
