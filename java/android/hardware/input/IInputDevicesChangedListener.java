// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.input;

import android.os.*;

public interface IInputDevicesChangedListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputDevicesChangedListener {
        private static class Proxy
            implements IInputDevicesChangedListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.hardware.input.IInputDevicesChangedListener";
            }

            public void onInputDevicesChanged(int ai[]) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.input.IInputDevicesChangedListener");
                parcel.writeIntArray(ai);
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


        public static IInputDevicesChangedListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.hardware.input.IInputDevicesChangedListener");
                if(iinterface != null && (iinterface instanceof IInputDevicesChangedListener))
                    obj = (IInputDevicesChangedListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputDevicesChangedListener) (obj));
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
            parcel1.writeString("android.hardware.input.IInputDevicesChangedListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.hardware.input.IInputDevicesChangedListener");
            onInputDevicesChanged(parcel.createIntArray());
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.hardware.input.IInputDevicesChangedListener";
        static final int TRANSACTION_onInputDevicesChanged = 1;

        public Stub() {
            attachInterface(this, "android.hardware.input.IInputDevicesChangedListener");
        }
    }


    public abstract void onInputDevicesChanged(int ai[]) throws RemoteException;
}
