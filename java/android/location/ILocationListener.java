// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;

// Referenced classes of package android.location:
//            Location

public interface ILocationListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ILocationListener {
        private static class Proxy
            implements ILocationListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.location.ILocationListener";
            }

            public void onLocationChanged(Location location) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationListener");
                if(location == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
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

            public void onProviderDisabled(String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationListener");
                parcel.writeString(s);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onProviderEnabled(String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationListener");
                parcel.writeString(s);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onStatusChanged(String s, int i, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationListener");
                parcel.writeString(s);
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_62;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(2, parcel, null, 1);
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


        public static ILocationListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.ILocationListener");
                if(iinterface != null && (iinterface instanceof ILocationListener))
                    obj = (ILocationListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ILocationListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 121
        //                       3: 179
        //                       4: 196
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("android.location.ILocationListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.ILocationListener");
            Location location;
            if(parcel.readInt() != 0)
                location = (Location)Location.CREATOR.createFromParcel(parcel);
            else
                location = null;
            onLocationChanged(location);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.location.ILocationListener");
            String s = parcel.readString();
            int k = parcel.readInt();
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            onStatusChanged(s, k, bundle);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.location.ILocationListener");
            onProviderEnabled(parcel.readString());
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.location.ILocationListener");
            onProviderDisabled(parcel.readString());
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "android.location.ILocationListener";
        static final int TRANSACTION_onLocationChanged = 1;
        static final int TRANSACTION_onProviderDisabled = 4;
        static final int TRANSACTION_onProviderEnabled = 3;
        static final int TRANSACTION_onStatusChanged = 2;

        public Stub() {
            attachInterface(this, "android.location.ILocationListener");
        }
    }


    public abstract void onLocationChanged(Location location) throws RemoteException;

    public abstract void onProviderDisabled(String s) throws RemoteException;

    public abstract void onProviderEnabled(String s) throws RemoteException;

    public abstract void onStatusChanged(String s, int i, Bundle bundle) throws RemoteException;
}
