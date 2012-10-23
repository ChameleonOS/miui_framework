// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;

// Referenced classes of package android.location:
//            IGpsStatusListener

public interface IGpsStatusProvider
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IGpsStatusProvider {
        private static class Proxy
            implements IGpsStatusProvider {

            public void addGpsStatusListener(IGpsStatusListener igpsstatuslistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.location.IGpsStatusProvider");
                if(igpsstatuslistener == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = igpsstatuslistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.location.IGpsStatusProvider";
            }

            public void removeGpsStatusListener(IGpsStatusListener igpsstatuslistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.location.IGpsStatusProvider");
                if(igpsstatuslistener == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = igpsstatuslistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
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


        public static IGpsStatusProvider asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.IGpsStatusProvider");
                if(iinterface != null && (iinterface instanceof IGpsStatusProvider))
                    obj = (IGpsStatusProvider)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IGpsStatusProvider) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 87
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.location.IGpsStatusProvider");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.IGpsStatusProvider");
            addGpsStatusListener(IGpsStatusListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.location.IGpsStatusProvider");
            removeGpsStatusListener(IGpsStatusListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.location.IGpsStatusProvider";
        static final int TRANSACTION_addGpsStatusListener = 1;
        static final int TRANSACTION_removeGpsStatusListener = 2;

        public Stub() {
            attachInterface(this, "android.location.IGpsStatusProvider");
        }
    }


    public abstract void addGpsStatusListener(IGpsStatusListener igpsstatuslistener) throws RemoteException;

    public abstract void removeGpsStatusListener(IGpsStatusListener igpsstatuslistener) throws RemoteException;
}
