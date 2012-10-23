// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, Message, Binder, 
//            IBinder, Parcel

public interface IMessenger
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IMessenger {
        private static class Proxy
            implements IMessenger {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.os.IMessenger";
            }

            public void send(Message message) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.IMessenger");
                if(message == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                message.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IMessenger asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.IMessenger");
                if(iinterface != null && (iinterface instanceof IMessenger))
                    obj = (IMessenger)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IMessenger) (obj));
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
            parcel1.writeString("android.os.IMessenger");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.IMessenger");
            Message message;
            if(parcel.readInt() != 0)
                message = (Message)Message.CREATOR.createFromParcel(parcel);
            else
                message = null;
            send(message);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.os.IMessenger";
        static final int TRANSACTION_send = 1;

        public Stub() {
            attachInterface(this, "android.os.IMessenger");
        }
    }


    public abstract void send(Message message) throws RemoteException;
}
