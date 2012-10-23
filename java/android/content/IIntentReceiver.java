// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.*;

// Referenced classes of package android.content:
//            Intent

public interface IIntentReceiver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IIntentReceiver {
        private static class Proxy
            implements IIntentReceiver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.content.IIntentReceiver";
            }

            public void performReceive(Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) throws RemoteException {
                int j;
                Parcel parcel;
                j = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IIntentReceiver");
                if(intent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L6:
                parcel.writeInt(i);
                parcel.writeString(s);
                if(bundle == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
                  goto _L5
_L7:
                int k;
                parcel.writeInt(k);
                Exception exception;
                if(!flag1)
                    j = 0;
                parcel.writeInt(j);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L6
                exception;
                parcel.recycle();
                throw exception;
_L4:
                parcel.writeInt(0);
                  goto _L5
_L9:
                k = 0;
                  goto _L7
_L5:
                if(!flag) goto _L9; else goto _L8
_L8:
                k = j;
                  goto _L7
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IIntentReceiver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.IIntentReceiver");
                if(iinterface != null && (iinterface instanceof IIntentReceiver))
                    obj = (IIntentReceiver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IIntentReceiver) (obj));
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
            parcel1.writeString("android.content.IIntentReceiver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.IIntentReceiver");
            Intent intent;
            int k;
            String s;
            Bundle bundle;
            boolean flag1;
            boolean flag2;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            k = parcel.readInt();
            s = parcel.readString();
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            performReceive(intent, k, s, bundle, flag1, flag2);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.content.IIntentReceiver";
        static final int TRANSACTION_performReceive = 1;

        public Stub() {
            attachInterface(this, "android.content.IIntentReceiver");
        }
    }


    public abstract void performReceive(Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) throws RemoteException;
}
