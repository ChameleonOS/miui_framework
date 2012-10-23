// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.app.PendingIntent;
import android.os.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.location:
//            IGpsStatusListener, Criteria, GeocoderParams, Location, 
//            ILocationListener, Address

public interface ILocationManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ILocationManager {
        private static class Proxy
            implements ILocationManager {

            public boolean addGpsStatusListener(IGpsStatusListener igpsstatuslistener) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(igpsstatuslistener == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = igpsstatuslistener.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void addProximityAlert(double d, double d1, float f, long l, 
                    PendingIntent pendingintent, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeDouble(d);
                parcel.writeDouble(d1);
                parcel.writeFloat(f);
                parcel.writeLong(l);
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_102;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void addTestProvider(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
                    boolean flag6, int i, int j) throws RemoteException {
                int k;
                Parcel parcel;
                Parcel parcel1;
                k = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                if(!flag) goto _L2; else goto _L1
_L1:
                int l = k;
_L13:
                parcel.writeInt(l);
                if(!flag1) goto _L4; else goto _L3
_L3:
                int i1 = k;
_L14:
                parcel.writeInt(i1);
                if(!flag2) goto _L6; else goto _L5
_L5:
                int j1 = k;
_L15:
                parcel.writeInt(j1);
                if(!flag3) goto _L8; else goto _L7
_L7:
                int k1 = k;
_L16:
                parcel.writeInt(k1);
                if(!flag4) goto _L10; else goto _L9
_L9:
                int l1 = k;
_L17:
                parcel.writeInt(l1);
                if(!flag5) goto _L12; else goto _L11
_L11:
                int i2 = k;
_L18:
                parcel.writeInt(i2);
                if(!flag6)
                    k = 0;
                parcel.writeInt(k);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(22, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                l = 0;
                  goto _L13
_L4:
                i1 = 0;
                  goto _L14
_L6:
                j1 = 0;
                  goto _L15
_L8:
                k1 = 0;
                  goto _L16
_L10:
                l1 = 0;
                  goto _L17
_L12:
                i2 = 0;
                  goto _L18
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L13
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public void clearTestProviderEnabled(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                mRemote.transact(27, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void clearTestProviderLocation(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                mRemote.transact(25, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void clearTestProviderStatus(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                mRemote.transact(29, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean geocoderIsPresent() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationManager");
                mRemote.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getAllProviders() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("android.location.ILocationManager");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createStringArrayList();
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getBestProvider(Criteria criteria, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(criteria != null) {
                    parcel.writeInt(1);
                    criteria.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_110;
                }
                  goto _L1
_L2:
                String s;
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_110;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L2
            }

            public String getFromLocation(double d, double d1, int i, GeocoderParams geocoderparams, List list) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeDouble(d);
                parcel.writeDouble(d1);
                parcel.writeInt(i);
                if(geocoderparams == null)
                    break MISSING_BLOCK_LABEL_107;
                parcel.writeInt(1);
                geocoderparams.writeToParcel(parcel, 0);
_L1:
                String s;
                mRemote.transact(20, parcel, parcel1, 0);
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
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                parcel.writeDouble(d);
                parcel.writeDouble(d1);
                parcel.writeDouble(d2);
                parcel.writeDouble(d3);
                parcel.writeInt(i);
                if(geocoderparams == null)
                    break MISSING_BLOCK_LABEL_128;
                parcel.writeInt(1);
                geocoderparams.writeToParcel(parcel, 0);
_L1:
                String s1;
                mRemote.transact(21, parcel, parcel1, 0);
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
                return "android.location.ILocationManager";
            }

            public Location getLastKnownLocation(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(17, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Location location = (Location)Location.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return location;
_L2:
                location = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public Bundle getProviderInfo(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bundle;
_L2:
                bundle = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getProviders(Criteria criteria, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(criteria != null) {
                    parcel.writeInt(1);
                    criteria.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_110;
                }
                  goto _L1
_L2:
                ArrayList arraylist;
                parcel.writeInt(i);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createStringArrayList();
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_110;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L2
            }

            public boolean isProviderEnabled(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void locationCallbackFinished(ILocationListener ilocationlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(ilocationlistener == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = ilocationlistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(11, parcel, parcel1, 0);
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

            public boolean providerMeetsCriteria(String s, Criteria criteria) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                if(criteria == null)
                    break MISSING_BLOCK_LABEL_87;
                parcel.writeInt(1);
                criteria.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void removeGpsStatusListener(IGpsStatusListener igpsstatuslistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(igpsstatuslistener == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = igpsstatuslistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void removeProximityAlert(PendingIntent pendingintent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void removeTestProvider(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                mRemote.transact(23, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void removeUpdates(ILocationListener ilocationlistener, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(ilocationlistener == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = ilocationlistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public void removeUpdatesPI(PendingIntent pendingintent, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void reportLocation(Location location, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                if(location != null) {
                    parcel.writeInt(1);
                    location.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_102;
                }
                  goto _L1
_L2:
                parcel.writeInt(i);
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_102;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L2
            }

            public void requestLocationUpdates(String s, Criteria criteria, long l, float f, boolean flag, ILocationListener ilocationlistener, 
                    String s1) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                if(criteria == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                criteria.writeToParcel(parcel, 0);
_L3:
                parcel.writeLong(l);
                parcel.writeFloat(f);
                Exception exception;
                IBinder ibinder;
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                if(ilocationlistener == null)
                    break MISSING_BLOCK_LABEL_158;
                ibinder = ilocationlistener.asBinder();
_L4:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s1);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                ibinder = null;
                  goto _L4
            }

            public void requestLocationUpdatesPI(String s, Criteria criteria, long l, float f, boolean flag, PendingIntent pendingintent, 
                    String s1) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                if(criteria == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                criteria.writeToParcel(parcel, 0);
_L3:
                parcel.writeLong(l);
                parcel.writeFloat(f);
                Exception exception;
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_157;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L4:
                parcel.writeString(s1);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public boolean sendExtraCommand(String s, String s1, Bundle bundle) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_106;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                Exception exception;
                if(parcel1.readInt() == 0)
                    flag = false;
                if(parcel1.readInt() != 0)
                    bundle.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean sendNiResponse(int i, int j) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(30, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setTestProviderEnabled(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(26, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setTestProviderLocation(String s, Location location) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                if(location == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(24, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setTestProviderStatus(String s, int i, Bundle bundle, long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_86;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                parcel.writeLong(l);
                mRemote.transact(28, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
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


        public static ILocationManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.ILocationManager");
                if(iinterface != null && (iinterface instanceof ILocationManager))
                    obj = (ILocationManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ILocationManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 31: default 260
        //                       1: 286
        //                       2: 314
        //                       3: 389
        //                       4: 464
        //                       5: 543
        //                       6: 645
        //                       7: 769
        //                       8: 800
        //                       9: 853
        //                       10: 902
        //                       11: 929
        //                       12: 956
        //                       13: 1068
        //                       14: 1157
        //                       15: 1206
        //                       16: 1257
        //                       17: 1303
        //                       18: 1358
        //                       19: 1425
        //                       20: 1467
        //                       21: 1565
        //                       22: 1687
        //                       23: 1857
        //                       24: 1881
        //                       25: 1938
        //                       26: 1962
        //                       27: 2008
        //                       28: 2032
        //                       29: 2105
        //                       30: 2129
        //                       1598968902: 274;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32
_L1:
            boolean flag1 = super.onTransact(i, parcel, parcel1, j);
_L34:
            return flag1;
_L32:
            parcel1.writeString("android.location.ILocationManager");
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.ILocationManager");
            List list1 = getAllProviders();
            parcel1.writeNoException();
            parcel1.writeStringList(list1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.location.ILocationManager");
            Criteria criteria4;
            boolean flag19;
            List list;
            if(parcel.readInt() != 0)
                criteria4 = (Criteria)Criteria.CREATOR.createFromParcel(parcel);
            else
                criteria4 = null;
            if(parcel.readInt() != 0)
                flag19 = true;
            else
                flag19 = false;
            list = getProviders(criteria4, flag19);
            parcel1.writeNoException();
            parcel1.writeStringList(list);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.location.ILocationManager");
            Criteria criteria3;
            boolean flag18;
            String s13;
            if(parcel.readInt() != 0)
                criteria3 = (Criteria)Criteria.CREATOR.createFromParcel(parcel);
            else
                criteria3 = null;
            if(parcel.readInt() != 0)
                flag18 = true;
            else
                flag18 = false;
            s13 = getBestProvider(criteria3, flag18);
            parcel1.writeNoException();
            parcel1.writeString(s13);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.location.ILocationManager");
            String s12 = parcel.readString();
            Criteria criteria2;
            boolean flag17;
            int k3;
            if(parcel.readInt() != 0)
                criteria2 = (Criteria)Criteria.CREATOR.createFromParcel(parcel);
            else
                criteria2 = null;
            flag17 = providerMeetsCriteria(s12, criteria2);
            parcel1.writeNoException();
            if(flag17)
                k3 = 1;
            else
                k3 = 0;
            parcel1.writeInt(k3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.location.ILocationManager");
            String s11 = parcel.readString();
            Criteria criteria1;
            long l4;
            float f2;
            boolean flag16;
            if(parcel.readInt() != 0)
                criteria1 = (Criteria)Criteria.CREATOR.createFromParcel(parcel);
            else
                criteria1 = null;
            l4 = parcel.readLong();
            f2 = parcel.readFloat();
            if(parcel.readInt() != 0)
                flag16 = true;
            else
                flag16 = false;
            requestLocationUpdates(s11, criteria1, l4, f2, flag16, ILocationListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.location.ILocationManager");
            String s10 = parcel.readString();
            Criteria criteria;
            long l3;
            float f1;
            boolean flag15;
            PendingIntent pendingintent3;
            if(parcel.readInt() != 0)
                criteria = (Criteria)Criteria.CREATOR.createFromParcel(parcel);
            else
                criteria = null;
            l3 = parcel.readLong();
            f1 = parcel.readFloat();
            if(parcel.readInt() != 0)
                flag15 = true;
            else
                flag15 = false;
            if(parcel.readInt() != 0)
                pendingintent3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent3 = null;
            requestLocationUpdatesPI(s10, criteria, l3, f1, flag15, pendingintent3, parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.location.ILocationManager");
            removeUpdates(ILocationListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.location.ILocationManager");
            PendingIntent pendingintent2;
            if(parcel.readInt() != 0)
                pendingintent2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent2 = null;
            removeUpdatesPI(pendingintent2, parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.location.ILocationManager");
            boolean flag14 = addGpsStatusListener(IGpsStatusListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            int j3;
            if(flag14)
                j3 = 1;
            else
                j3 = 0;
            parcel1.writeInt(j3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.location.ILocationManager");
            removeGpsStatusListener(IGpsStatusListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.location.ILocationManager");
            locationCallbackFinished(ILocationListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.location.ILocationManager");
            String s8 = parcel.readString();
            String s9 = parcel.readString();
            Bundle bundle2;
            boolean flag13;
            int i3;
            if(parcel.readInt() != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle2 = null;
            flag13 = sendExtraCommand(s8, s9, bundle2);
            parcel1.writeNoException();
            if(flag13)
                i3 = 1;
            else
                i3 = 0;
            parcel1.writeInt(i3);
            if(bundle2 != null) {
                parcel1.writeInt(1);
                bundle2.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.location.ILocationManager");
            double d6 = parcel.readDouble();
            double d7 = parcel.readDouble();
            float f = parcel.readFloat();
            long l2 = parcel.readLong();
            PendingIntent pendingintent1;
            String s7;
            if(parcel.readInt() != 0)
                pendingintent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent1 = null;
            s7 = parcel.readString();
            addProximityAlert(d6, d7, f, l2, pendingintent1, s7);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.location.ILocationManager");
            PendingIntent pendingintent;
            if(parcel.readInt() != 0)
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent = null;
            removeProximityAlert(pendingintent);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.location.ILocationManager");
            Bundle bundle1 = getProviderInfo(parcel.readString());
            parcel1.writeNoException();
            if(bundle1 != null) {
                parcel1.writeInt(1);
                bundle1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.location.ILocationManager");
            boolean flag12 = isProviderEnabled(parcel.readString());
            parcel1.writeNoException();
            int k2;
            if(flag12)
                k2 = 1;
            else
                k2 = 0;
            parcel1.writeInt(k2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.location.ILocationManager");
            Location location2 = getLastKnownLocation(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(location2 != null) {
                parcel1.writeInt(1);
                location2.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.location.ILocationManager");
            Location location1;
            boolean flag11;
            if(parcel.readInt() != 0)
                location1 = (Location)Location.CREATOR.createFromParcel(parcel);
            else
                location1 = null;
            if(parcel.readInt() != 0)
                flag11 = true;
            else
                flag11 = false;
            reportLocation(location1, flag11);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.location.ILocationManager");
            boolean flag10 = geocoderIsPresent();
            parcel1.writeNoException();
            int j2;
            if(flag10)
                j2 = 1;
            else
                j2 = 0;
            parcel1.writeInt(j2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.location.ILocationManager");
            double d4 = parcel.readDouble();
            double d5 = parcel.readDouble();
            int i2 = parcel.readInt();
            GeocoderParams geocoderparams1;
            ArrayList arraylist1;
            String s6;
            if(parcel.readInt() != 0)
                geocoderparams1 = (GeocoderParams)GeocoderParams.CREATOR.createFromParcel(parcel);
            else
                geocoderparams1 = null;
            arraylist1 = new ArrayList();
            s6 = getFromLocation(d4, d5, i2, geocoderparams1, arraylist1);
            parcel1.writeNoException();
            parcel1.writeString(s6);
            parcel1.writeTypedList(arraylist1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.location.ILocationManager");
            String s4 = parcel.readString();
            double d = parcel.readDouble();
            double d1 = parcel.readDouble();
            double d2 = parcel.readDouble();
            double d3 = parcel.readDouble();
            int k1 = parcel.readInt();
            GeocoderParams geocoderparams;
            ArrayList arraylist;
            String s5;
            if(parcel.readInt() != 0)
                geocoderparams = (GeocoderParams)GeocoderParams.CREATOR.createFromParcel(parcel);
            else
                geocoderparams = null;
            arraylist = new ArrayList();
            s5 = getFromLocationName(s4, d, d1, d2, d3, k1, geocoderparams, arraylist);
            parcel1.writeNoException();
            parcel1.writeString(s5);
            parcel1.writeTypedList(arraylist);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.location.ILocationManager");
            String s3 = parcel.readString();
            boolean flag3;
            boolean flag4;
            boolean flag5;
            boolean flag6;
            boolean flag7;
            boolean flag8;
            boolean flag9;
            int i1;
            int j1;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            if(parcel.readInt() != 0)
                flag4 = true;
            else
                flag4 = false;
            if(parcel.readInt() != 0)
                flag5 = true;
            else
                flag5 = false;
            if(parcel.readInt() != 0)
                flag6 = true;
            else
                flag6 = false;
            if(parcel.readInt() != 0)
                flag7 = true;
            else
                flag7 = false;
            if(parcel.readInt() != 0)
                flag8 = true;
            else
                flag8 = false;
            if(parcel.readInt() != 0)
                flag9 = true;
            else
                flag9 = false;
            i1 = parcel.readInt();
            j1 = parcel.readInt();
            addTestProvider(s3, flag3, flag4, flag5, flag6, flag7, flag8, flag9, i1, j1);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.location.ILocationManager");
            removeTestProvider(parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.location.ILocationManager");
            String s2 = parcel.readString();
            Location location;
            if(parcel.readInt() != 0)
                location = (Location)Location.CREATOR.createFromParcel(parcel);
            else
                location = null;
            setTestProviderLocation(s2, location);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.location.ILocationManager");
            clearTestProviderLocation(parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.location.ILocationManager");
            String s1 = parcel.readString();
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = true;
            else
                flag2 = false;
            setTestProviderEnabled(s1, flag2);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.location.ILocationManager");
            clearTestProviderEnabled(parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.location.ILocationManager");
            String s = parcel.readString();
            int l = parcel.readInt();
            Bundle bundle;
            long l1;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            l1 = parcel.readLong();
            setTestProviderStatus(s, l, bundle, l1);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.location.ILocationManager");
            clearTestProviderStatus(parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.location.ILocationManager");
            boolean flag = sendNiResponse(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            int k;
            if(flag)
                k = 1;
            else
                k = 0;
            parcel1.writeInt(k);
            flag1 = true;
            if(true) goto _L34; else goto _L33
_L33:
        }

        private static final String DESCRIPTOR = "android.location.ILocationManager";
        static final int TRANSACTION_addGpsStatusListener = 9;
        static final int TRANSACTION_addProximityAlert = 13;
        static final int TRANSACTION_addTestProvider = 22;
        static final int TRANSACTION_clearTestProviderEnabled = 27;
        static final int TRANSACTION_clearTestProviderLocation = 25;
        static final int TRANSACTION_clearTestProviderStatus = 29;
        static final int TRANSACTION_geocoderIsPresent = 19;
        static final int TRANSACTION_getAllProviders = 1;
        static final int TRANSACTION_getBestProvider = 3;
        static final int TRANSACTION_getFromLocation = 20;
        static final int TRANSACTION_getFromLocationName = 21;
        static final int TRANSACTION_getLastKnownLocation = 17;
        static final int TRANSACTION_getProviderInfo = 15;
        static final int TRANSACTION_getProviders = 2;
        static final int TRANSACTION_isProviderEnabled = 16;
        static final int TRANSACTION_locationCallbackFinished = 11;
        static final int TRANSACTION_providerMeetsCriteria = 4;
        static final int TRANSACTION_removeGpsStatusListener = 10;
        static final int TRANSACTION_removeProximityAlert = 14;
        static final int TRANSACTION_removeTestProvider = 23;
        static final int TRANSACTION_removeUpdates = 7;
        static final int TRANSACTION_removeUpdatesPI = 8;
        static final int TRANSACTION_reportLocation = 18;
        static final int TRANSACTION_requestLocationUpdates = 5;
        static final int TRANSACTION_requestLocationUpdatesPI = 6;
        static final int TRANSACTION_sendExtraCommand = 12;
        static final int TRANSACTION_sendNiResponse = 30;
        static final int TRANSACTION_setTestProviderEnabled = 26;
        static final int TRANSACTION_setTestProviderLocation = 24;
        static final int TRANSACTION_setTestProviderStatus = 28;

        public Stub() {
            attachInterface(this, "android.location.ILocationManager");
        }
    }


    public abstract boolean addGpsStatusListener(IGpsStatusListener igpsstatuslistener) throws RemoteException;

    public abstract void addProximityAlert(double d, double d1, float f, long l, 
            PendingIntent pendingintent, String s) throws RemoteException;

    public abstract void addTestProvider(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
            boolean flag6, int i, int j) throws RemoteException;

    public abstract void clearTestProviderEnabled(String s) throws RemoteException;

    public abstract void clearTestProviderLocation(String s) throws RemoteException;

    public abstract void clearTestProviderStatus(String s) throws RemoteException;

    public abstract boolean geocoderIsPresent() throws RemoteException;

    public abstract List getAllProviders() throws RemoteException;

    public abstract String getBestProvider(Criteria criteria, boolean flag) throws RemoteException;

    public abstract String getFromLocation(double d, double d1, int i, GeocoderParams geocoderparams, List list) throws RemoteException;

    public abstract String getFromLocationName(String s, double d, double d1, double d2, 
            double d3, int i, GeocoderParams geocoderparams, List list) throws RemoteException;

    public abstract Location getLastKnownLocation(String s, String s1) throws RemoteException;

    public abstract Bundle getProviderInfo(String s) throws RemoteException;

    public abstract List getProviders(Criteria criteria, boolean flag) throws RemoteException;

    public abstract boolean isProviderEnabled(String s) throws RemoteException;

    public abstract void locationCallbackFinished(ILocationListener ilocationlistener) throws RemoteException;

    public abstract boolean providerMeetsCriteria(String s, Criteria criteria) throws RemoteException;

    public abstract void removeGpsStatusListener(IGpsStatusListener igpsstatuslistener) throws RemoteException;

    public abstract void removeProximityAlert(PendingIntent pendingintent) throws RemoteException;

    public abstract void removeTestProvider(String s) throws RemoteException;

    public abstract void removeUpdates(ILocationListener ilocationlistener, String s) throws RemoteException;

    public abstract void removeUpdatesPI(PendingIntent pendingintent, String s) throws RemoteException;

    public abstract void reportLocation(Location location, boolean flag) throws RemoteException;

    public abstract void requestLocationUpdates(String s, Criteria criteria, long l, float f, boolean flag, ILocationListener ilocationlistener, 
            String s1) throws RemoteException;

    public abstract void requestLocationUpdatesPI(String s, Criteria criteria, long l, float f, boolean flag, PendingIntent pendingintent, 
            String s1) throws RemoteException;

    public abstract boolean sendExtraCommand(String s, String s1, Bundle bundle) throws RemoteException;

    public abstract boolean sendNiResponse(int i, int j) throws RemoteException;

    public abstract void setTestProviderEnabled(String s, boolean flag) throws RemoteException;

    public abstract void setTestProviderLocation(String s, Location location) throws RemoteException;

    public abstract void setTestProviderStatus(String s, int i, Bundle bundle, long l) throws RemoteException;
}
