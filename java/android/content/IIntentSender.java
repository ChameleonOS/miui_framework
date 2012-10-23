// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.*;

// Referenced classes of package android.content:
//            Intent, IIntentReceiver

public interface IIntentSender
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IIntentSender {
        private static class Proxy
            implements IIntentSender {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.content.IIntentSender";
            }

            public int send(int i, Intent intent, String s, IIntentReceiver iintentreceiver, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IIntentSender");
                parcel.writeInt(i);
                if(intent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                parcel.writeString(s);
                if(iintentreceiver == null)
                    break MISSING_BLOCK_LABEL_139;
                ibinder = iintentreceiver.asBinder();
_L4:
                int j;
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s1);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                ibinder = null;
                  goto _L4
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IIntentSender asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.IIntentSender");
                if(iinterface != null && (iinterface instanceof IIntentSender))
                    obj = (IIntentSender)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IIntentSender) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 2: default 28
        //                       1: 54
        //                       1598968902: 42;
               goto _L1 _L2 _L3
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L5:
            return flag;
_L3:
            parcel1.writeString("android.content.IIntentSender");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.IIntentSender");
            int k = parcel.readInt();
            Intent intent;
            int l;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            l = send(k, intent, parcel.readString(), IIntentReceiver.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(l);
            flag = true;
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.content.IIntentSender";
        static final int TRANSACTION_send = 1;

        public Stub() {
            attachInterface(this, "android.content.IIntentSender");
        }
    }


    public abstract int send(int i, Intent intent, String s, IIntentReceiver iintentreceiver, String s1) throws RemoteException;
}
