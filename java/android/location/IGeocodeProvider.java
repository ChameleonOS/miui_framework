// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.location:
//            GeocoderParams, Address

public interface IGeocodeProvider
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IGeocodeProvider {
        private static class Proxy
            implements IGeocodeProvider {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getFromLocation(double d, double d1, int i, GeocoderParams geocoderparams, List list) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.IGeocodeProvider");
                parcel.writeDouble(d);
                parcel.writeDouble(d1);
                parcel.writeInt(i);
                if(geocoderparams == null)
                    break MISSING_BLOCK_LABEL_106;
                parcel.writeInt(1);
                geocoderparams.writeToParcel(parcel, 0);
_L1:
                String s;
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.readTypedList(list, Address.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return s;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getFromLocationName(String s, double d, double d1, double d2, 
                    double d3, int i, GeocoderParams geocoderparams, List list) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.IGeocodeProvider");
                parcel.writeString(s);
                parcel.writeDouble(d);
                parcel.writeDouble(d1);
                parcel.writeDouble(d2);
                parcel.writeDouble(d3);
                parcel.writeInt(i);
                if(geocoderparams == null)
                    break MISSING_BLOCK_LABEL_127;
                parcel.writeInt(1);
                geocoderparams.writeToParcel(parcel, 0);
_L1:
                String s1;
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.readTypedList(list, Address.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return s1;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.location.IGeocodeProvider";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IGeocodeProvider asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.IGeocodeProvider");
                if(iinterface != null && (iinterface instanceof IGeocodeProvider))
                    obj = (IGeocodeProvider)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IGeocodeProvider) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 3: default 36
        //                       1: 62
        //                       2: 160
        //                       1598968902: 50;
               goto _L1 _L2 _L3 _L4
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.location.IGeocodeProvider");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.IGeocodeProvider");
            double d4 = parcel.readDouble();
            double d5 = parcel.readDouble();
            int l = parcel.readInt();
            GeocoderParams geocoderparams1;
            ArrayList arraylist1;
            String s2;
            if(parcel.readInt() != 0)
                geocoderparams1 = (GeocoderParams)GeocoderParams.CREATOR.createFromParcel(parcel);
            else
                geocoderparams1 = null;
            arraylist1 = new ArrayList();
            s2 = getFromLocation(d4, d5, l, geocoderparams1, arraylist1);
            parcel1.writeNoException();
            parcel1.writeString(s2);
            parcel1.writeTypedList(arraylist1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.location.IGeocodeProvider");
            String s = parcel.readString();
            double d = parcel.readDouble();
            double d1 = parcel.readDouble();
            double d2 = parcel.readDouble();
            double d3 = parcel.readDouble();
            int k = parcel.readInt();
            GeocoderParams geocoderparams;
            ArrayList arraylist;
            String s1;
            if(parcel.readInt() != 0)
                geocoderparams = (GeocoderParams)GeocoderParams.CREATOR.createFromParcel(parcel);
            else
                geocoderparams = null;
            arraylist = new ArrayList();
            s1 = getFromLocationName(s, d, d1, d2, d3, k, geocoderparams, arraylist);
            parcel1.writeNoException();
            parcel1.writeString(s1);
            parcel1.writeTypedList(arraylist);
            flag = true;
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.location.IGeocodeProvider";
        static final int TRANSACTION_getFromLocation = 1;
        static final int TRANSACTION_getFromLocationName = 2;

        public Stub() {
            attachInterface(this, "android.location.IGeocodeProvider");
        }
    }


    public abstract String getFromLocation(double d, double d1, int i, GeocoderParams geocoderparams, List list) throws RemoteException;

    public abstract String getFromLocationName(String s, double d, double d1, double d2, 
            double d3, int i, GeocoderParams geocoderparams, List list) throws RemoteException;
}
