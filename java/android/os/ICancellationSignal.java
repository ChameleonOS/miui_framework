// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, Binder, IBinder, 
//            Parcel

public interface ICancellationSignal
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ICancellationSignal {
        private static class Proxy
            implements ICancellationSignal {

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancel() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.ICancellationSignal");
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.os.ICancellationSignal";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ICancellationSignal asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.ICancellationSignal");
                if(iinterface != null && (iinterface instanceof ICancellationSignal))
                    obj = (ICancellationSignal)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ICancellationSignal) (obj));
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
            parcel1.writeString("android.os.ICancellationSignal");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.ICancellationSignal");
            cancel();
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.os.ICancellationSignal";
        static final int TRANSACTION_cancel = 1;

        public Stub() {
            attachInterface(this, "android.os.ICancellationSignal");
        }
    }


    public abstract void cancel() throws RemoteException;
}
