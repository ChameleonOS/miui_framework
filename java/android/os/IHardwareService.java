// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, Binder, IBinder, 
//            Parcel

public interface IHardwareService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IHardwareService {
        private static class Proxy
            implements IHardwareService {

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean getFlashlightEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.IHardwareService");
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

            public String getInterfaceDescriptor() {
                return "android.os.IHardwareService";
            }

            public void setFlashlightEnabled(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IHardwareService");
                if(flag)
                    i = 1;
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IHardwareService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.IHardwareService");
                if(iinterface != null && (iinterface instanceof IHardwareService))
                    obj = (IHardwareService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IHardwareService) (obj));
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
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 97
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.os.IHardwareService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.IHardwareService");
            boolean flag2 = getFlashlightEnabled();
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.os.IHardwareService");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            setFlashlightEnabled(flag1);
            parcel1.writeNoException();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.os.IHardwareService";
        static final int TRANSACTION_getFlashlightEnabled = 1;
        static final int TRANSACTION_setFlashlightEnabled = 2;

        public Stub() {
            attachInterface(this, "android.os.IHardwareService");
        }
    }


    public abstract boolean getFlashlightEnabled() throws RemoteException;

    public abstract void setFlashlightEnabled(boolean flag) throws RemoteException;
}
