// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;

// Referenced classes of package android.location:
//            Country

public interface ICountryListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ICountryListener {
        private static class Proxy
            implements ICountryListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.location.ICountryListener";
            }

            public void onCountryDetected(Country country) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ICountryListener");
                if(country == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                country.writeToParcel(parcel, 0);
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


        public static ICountryListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.ICountryListener");
                if(iinterface != null && (iinterface instanceof ICountryListener))
                    obj = (ICountryListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ICountryListener) (obj));
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
            parcel1.writeString("android.location.ICountryListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.ICountryListener");
            Country country;
            if(parcel.readInt() != 0)
                country = (Country)Country.CREATOR.createFromParcel(parcel);
            else
                country = null;
            onCountryDetected(country);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.location.ICountryListener";
        static final int TRANSACTION_onCountryDetected = 1;

        public Stub() {
            attachInterface(this, "android.location.ICountryListener");
        }
    }


    public abstract void onCountryDetected(Country country) throws RemoteException;
}
