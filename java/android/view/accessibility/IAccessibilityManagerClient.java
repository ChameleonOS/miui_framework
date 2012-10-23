// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.os.*;

public interface IAccessibilityManagerClient
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccessibilityManagerClient {
        private static class Proxy
            implements IAccessibilityManagerClient {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.view.accessibility.IAccessibilityManagerClient";
            }

            public void setState(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManagerClient");
                parcel.writeInt(i);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
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


        public static IAccessibilityManagerClient asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.view.accessibility.IAccessibilityManagerClient");
                if(iinterface != null && (iinterface instanceof IAccessibilityManagerClient))
                    obj = (IAccessibilityManagerClient)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccessibilityManagerClient) (obj));
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
            parcel1.writeString("android.view.accessibility.IAccessibilityManagerClient");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManagerClient");
            setState(parcel.readInt());
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.view.accessibility.IAccessibilityManagerClient";
        static final int TRANSACTION_setState = 1;

        public Stub() {
            attachInterface(this, "android.view.accessibility.IAccessibilityManagerClient");
        }
    }


    public abstract void setState(int i) throws RemoteException;
}
