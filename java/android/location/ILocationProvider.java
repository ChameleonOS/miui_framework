// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.net.NetworkInfo;
import android.os.*;

// Referenced classes of package android.location:
//            Criteria, Location

public interface ILocationProvider
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ILocationProvider {
        private static class Proxy
            implements ILocationProvider {

            public void addListener(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                parcel.writeInt(i);
                mRemote.transact(21, parcel, parcel1, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void disable() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(12, parcel, parcel1, 0);
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

            public void enable() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(11, parcel, parcel1, 0);
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

            public void enableLocationTracking(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(16, parcel, parcel1, 0);
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

            public int getAccuracy() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.location.ILocationProvider";
            }

            public String getInternalState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPowerRequirement() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getStatus(Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(parcel1.readInt() != 0)
                    bundle.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public long getStatusUpdateTime() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean hasMonetaryCost() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(4, parcel, parcel1, 0);
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

            public boolean meetsCriteria(Criteria criteria) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                if(criteria == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                criteria.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(9, parcel, parcel1, 0);
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

            public void removeListener(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                parcel.writeInt(i);
                mRemote.transact(22, parcel, parcel1, 0);
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

            public boolean requiresCell() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(3, parcel, parcel1, 0);
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

            public boolean requiresNetwork() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean requiresSatellite() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(2, parcel, parcel1, 0);
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

            public boolean sendExtraCommand(String s, Bundle bundle) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_98;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(20, parcel, parcel1, 0);
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

            public void setMinTime(long l, WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                parcel.writeLong(l);
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_73;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(17, parcel, parcel1, 0);
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

            public boolean supportsAltitude() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(5, parcel, parcel1, 0);
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

            public boolean supportsBearing() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(7, parcel, parcel1, 0);
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

            public boolean supportsSpeed() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                mRemote.transact(6, parcel, parcel1, 0);
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

            public void updateLocation(Location location) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                if(location == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(19, parcel, parcel1, 0);
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

            public void updateNetworkState(int i, NetworkInfo networkinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.ILocationProvider");
                parcel.writeInt(i);
                if(networkinfo == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                networkinfo.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(18, parcel, parcel1, 0);
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


        public static ILocationProvider asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.ILocationProvider");
                if(iinterface != null && (iinterface instanceof ILocationProvider))
                    obj = (ILocationProvider)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ILocationProvider) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            int k;
            boolean flag;
            k = 0;
            flag = true;
            i;
            JVM INSTR lookupswitch 23: default 200
        //                       1: 223
        //                       2: 257
        //                       3: 291
        //                       4: 325
        //                       5: 359
        //                       6: 393
        //                       7: 427
        //                       8: 461
        //                       9: 486
        //                       10: 549
        //                       11: 574
        //                       12: 591
        //                       13: 608
        //                       14: 671
        //                       15: 696
        //                       16: 721
        //                       17: 757
        //                       18: 811
        //                       19: 865
        //                       20: 911
        //                       21: 1015
        //                       22: 1036
        //                       1598968902: 214;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L26:
            return flag;
_L24:
            parcel1.writeString("android.location.ILocationProvider");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.ILocationProvider");
            boolean flag10 = requiresNetwork();
            parcel1.writeNoException();
            if(flag10)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.location.ILocationProvider");
            boolean flag9 = requiresSatellite();
            parcel1.writeNoException();
            if(flag9)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.location.ILocationProvider");
            boolean flag8 = requiresCell();
            parcel1.writeNoException();
            if(flag8)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.location.ILocationProvider");
            boolean flag7 = hasMonetaryCost();
            parcel1.writeNoException();
            if(flag7)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.location.ILocationProvider");
            boolean flag6 = supportsAltitude();
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.location.ILocationProvider");
            boolean flag5 = supportsSpeed();
            parcel1.writeNoException();
            if(flag5)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.location.ILocationProvider");
            boolean flag4 = supportsBearing();
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.location.ILocationProvider");
            int i2 = getPowerRequirement();
            parcel1.writeNoException();
            parcel1.writeInt(i2);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.location.ILocationProvider");
            Criteria criteria;
            boolean flag3;
            if(parcel.readInt() != 0)
                criteria = (Criteria)Criteria.CREATOR.createFromParcel(parcel);
            else
                criteria = null;
            flag3 = meetsCriteria(criteria);
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.location.ILocationProvider");
            int k1 = getAccuracy();
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.location.ILocationProvider");
            enable();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.location.ILocationProvider");
            disable();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.location.ILocationProvider");
            Bundle bundle1 = new Bundle();
            int j1 = getStatus(bundle1);
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            if(bundle1 != null) {
                parcel1.writeInt(flag);
                bundle1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.location.ILocationProvider");
            long l2 = getStatusUpdateTime();
            parcel1.writeNoException();
            parcel1.writeLong(l2);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.location.ILocationProvider");
            String s1 = getInternalState();
            parcel1.writeNoException();
            parcel1.writeString(s1);
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.location.ILocationProvider");
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            enableLocationTracking(flag2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.location.ILocationProvider");
            long l1 = parcel.readLong();
            WorkSource worksource;
            if(parcel.readInt() != 0)
                worksource = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource = null;
            setMinTime(l1, worksource);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.location.ILocationProvider");
            int i1 = parcel.readInt();
            NetworkInfo networkinfo;
            if(parcel.readInt() != 0)
                networkinfo = (NetworkInfo)NetworkInfo.CREATOR.createFromParcel(parcel);
            else
                networkinfo = null;
            updateNetworkState(i1, networkinfo);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.location.ILocationProvider");
            Location location;
            if(parcel.readInt() != 0)
                location = (Location)Location.CREATOR.createFromParcel(parcel);
            else
                location = null;
            updateLocation(location);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.location.ILocationProvider");
            String s = parcel.readString();
            Bundle bundle;
            boolean flag1;
            int l;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            flag1 = sendExtraCommand(s, bundle);
            parcel1.writeNoException();
            if(flag1)
                l = ((flag) ? 1 : 0);
            else
                l = 0;
            parcel1.writeInt(l);
            if(bundle != null) {
                parcel1.writeInt(flag);
                bundle.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.location.ILocationProvider");
            addListener(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.location.ILocationProvider");
            removeListener(parcel.readInt());
            parcel1.writeNoException();
            if(true) goto _L26; else goto _L25
_L25:
        }

        private static final String DESCRIPTOR = "android.location.ILocationProvider";
        static final int TRANSACTION_addListener = 21;
        static final int TRANSACTION_disable = 12;
        static final int TRANSACTION_enable = 11;
        static final int TRANSACTION_enableLocationTracking = 16;
        static final int TRANSACTION_getAccuracy = 10;
        static final int TRANSACTION_getInternalState = 15;
        static final int TRANSACTION_getPowerRequirement = 8;
        static final int TRANSACTION_getStatus = 13;
        static final int TRANSACTION_getStatusUpdateTime = 14;
        static final int TRANSACTION_hasMonetaryCost = 4;
        static final int TRANSACTION_meetsCriteria = 9;
        static final int TRANSACTION_removeListener = 22;
        static final int TRANSACTION_requiresCell = 3;
        static final int TRANSACTION_requiresNetwork = 1;
        static final int TRANSACTION_requiresSatellite = 2;
        static final int TRANSACTION_sendExtraCommand = 20;
        static final int TRANSACTION_setMinTime = 17;
        static final int TRANSACTION_supportsAltitude = 5;
        static final int TRANSACTION_supportsBearing = 7;
        static final int TRANSACTION_supportsSpeed = 6;
        static final int TRANSACTION_updateLocation = 19;
        static final int TRANSACTION_updateNetworkState = 18;

        public Stub() {
            attachInterface(this, "android.location.ILocationProvider");
        }
    }


    public abstract void addListener(int i) throws RemoteException;

    public abstract void disable() throws RemoteException;

    public abstract void enable() throws RemoteException;

    public abstract void enableLocationTracking(boolean flag) throws RemoteException;

    public abstract int getAccuracy() throws RemoteException;

    public abstract String getInternalState() throws RemoteException;

    public abstract int getPowerRequirement() throws RemoteException;

    public abstract int getStatus(Bundle bundle) throws RemoteException;

    public abstract long getStatusUpdateTime() throws RemoteException;

    public abstract boolean hasMonetaryCost() throws RemoteException;

    public abstract boolean meetsCriteria(Criteria criteria) throws RemoteException;

    public abstract void removeListener(int i) throws RemoteException;

    public abstract boolean requiresCell() throws RemoteException;

    public abstract boolean requiresNetwork() throws RemoteException;

    public abstract boolean requiresSatellite() throws RemoteException;

    public abstract boolean sendExtraCommand(String s, Bundle bundle) throws RemoteException;

    public abstract void setMinTime(long l, WorkSource worksource) throws RemoteException;

    public abstract boolean supportsAltitude() throws RemoteException;

    public abstract boolean supportsBearing() throws RemoteException;

    public abstract boolean supportsSpeed() throws RemoteException;

    public abstract void updateLocation(Location location) throws RemoteException;

    public abstract void updateNetworkState(int i, NetworkInfo networkinfo) throws RemoteException;
}
