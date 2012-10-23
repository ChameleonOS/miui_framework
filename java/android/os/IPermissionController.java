// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, Binder, IBinder, 
//            Parcel

public interface IPermissionController
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IPermissionController {
        private static class Proxy
            implements IPermissionController {

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean checkPermission(String s, int i, int j) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("android.os.IPermissionController");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k == 0)
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
                return "android.os.IPermissionController";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IPermissionController asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.IPermissionController");
                if(iinterface != null && (iinterface instanceof IPermissionController))
                    obj = (IPermissionController)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IPermissionController) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 2: default 32
        //                       1: 55
        //                       1598968902: 46;
               goto _L1 _L2 _L3
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L5:
            return flag;
_L3:
            parcel1.writeString("android.os.IPermissionController");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.IPermissionController");
            boolean flag1 = checkPermission(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            int k;
            if(flag1)
                k = ((flag) ? 1 : 0);
            else
                k = 0;
            parcel1.writeInt(k);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.os.IPermissionController";
        static final int TRANSACTION_checkPermission = 1;

        public Stub() {
            attachInterface(this, "android.os.IPermissionController");
        }
    }


    public abstract boolean checkPermission(String s, int i, int j) throws RemoteException;
}
