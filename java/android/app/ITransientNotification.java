// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.*;

public interface ITransientNotification
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ITransientNotification {
        private static class Proxy
            implements ITransientNotification {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.ITransientNotification";
            }

            public void hide() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.ITransientNotification");
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void show() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.ITransientNotification");
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


        public static ITransientNotification asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.ITransientNotification");
                if(iinterface != null && (iinterface instanceof ITransientNotification))
                    obj = (ITransientNotification)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ITransientNotification) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 76
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.app.ITransientNotification");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.ITransientNotification");
            show();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.ITransientNotification");
            hide();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.app.ITransientNotification";
        static final int TRANSACTION_hide = 2;
        static final int TRANSACTION_show = 1;

        public Stub() {
            attachInterface(this, "android.app.ITransientNotification");
        }
    }


    public abstract void hide() throws RemoteException;

    public abstract void show() throws RemoteException;
}
