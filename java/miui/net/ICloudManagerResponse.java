// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.net;

import android.os.*;

public interface ICloudManagerResponse
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ICloudManagerResponse {
        private static class Proxy
            implements ICloudManagerResponse {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "miui.net.ICloudManagerResponse";
            }

            public void onError(int i, String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.ICloudManagerResponse");
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onResult(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("miui.net.ICloudManagerResponse");
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
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


        public static ICloudManagerResponse asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("miui.net.ICloudManagerResponse");
                if(iinterface != null && (iinterface instanceof ICloudManagerResponse))
                    obj = (ICloudManagerResponse)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ICloudManagerResponse) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 105
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("miui.net.ICloudManagerResponse");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("miui.net.ICloudManagerResponse");
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            onResult(bundle);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("miui.net.ICloudManagerResponse");
            onError(parcel.readInt(), parcel.readString());
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "miui.net.ICloudManagerResponse";
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onResult = 1;

        public Stub() {
            attachInterface(this, "miui.net.ICloudManagerResponse");
        }
    }


    public abstract void onError(int i, String s) throws RemoteException;

    public abstract void onResult(Bundle bundle) throws RemoteException;
}
