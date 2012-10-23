// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, Binder, IBinder, 
//            Parcel

public interface ISchedulingPolicyService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISchedulingPolicyService {
        private static class Proxy
            implements ISchedulingPolicyService {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.os.ISchedulingPolicyService";
            }

            public int requestPriority(int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int l;
                parcel.writeInterfaceToken("android.os.ISchedulingPolicyService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return l;
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


        public static ISchedulingPolicyService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.ISchedulingPolicyService");
                if(iinterface != null && (iinterface instanceof ISchedulingPolicyService))
                    obj = (ISchedulingPolicyService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISchedulingPolicyService) (obj));
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
            parcel1.writeString("android.os.ISchedulingPolicyService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.ISchedulingPolicyService");
            int k = requestPriority(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(k);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.os.ISchedulingPolicyService";
        static final int TRANSACTION_requestPriority = 1;

        public Stub() {
            attachInterface(this, "android.os.ISchedulingPolicyService");
        }
    }


    public abstract int requestPriority(int i, int j, int k) throws RemoteException;
}
