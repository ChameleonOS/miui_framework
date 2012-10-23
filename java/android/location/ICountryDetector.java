// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;

// Referenced classes of package android.location:
//            ICountryListener, Country

public interface ICountryDetector
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ICountryDetector {
        private static class Proxy
            implements ICountryDetector {

            public void addCountryListener(ICountryListener icountrylistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.location.ICountryDetector");
                if(icountrylistener == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = icountrylistener.asBinder();
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

            public IBinder asBinder() {
                return mRemote;
            }

            public Country detectCountry() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ICountryDetector");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Country country = (Country)Country.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return country;
_L2:
                country = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.location.ICountryDetector";
            }

            public void removeCountryListener(ICountryListener icountrylistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.location.ICountryDetector");
                if(icountrylistener == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = icountrylistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, parcel1, 0);
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


        public static ICountryDetector asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.ICountryDetector");
                if(iinterface != null && (iinterface instanceof ICountryDetector))
                    obj = (ICountryDetector)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ICountryDetector) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 117
        //                       3: 141
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.location.ICountryDetector");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.ICountryDetector");
            Country country = detectCountry();
            parcel1.writeNoException();
            if(country != null) {
                parcel1.writeInt(flag);
                country.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.location.ICountryDetector");
            addCountryListener(ICountryListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.location.ICountryDetector");
            removeCountryListener(ICountryListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.location.ICountryDetector";
        static final int TRANSACTION_addCountryListener = 2;
        static final int TRANSACTION_detectCountry = 1;
        static final int TRANSACTION_removeCountryListener = 3;

        public Stub() {
            attachInterface(this, "android.location.ICountryDetector");
        }
    }


    public abstract void addCountryListener(ICountryListener icountrylistener) throws RemoteException;

    public abstract Country detectCountry() throws RemoteException;

    public abstract void removeCountryListener(ICountryListener icountrylistener) throws RemoteException;
}
