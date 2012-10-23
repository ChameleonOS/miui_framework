// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.*;

// Referenced classes of package android.net:
//            NetworkStats, NetworkTemplate, INetworkStatsSession

public interface INetworkStatsService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INetworkStatsService {
        private static class Proxy
            implements INetworkStatsService {

            public void advisePersistThreshold(long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsService");
                parcel.writeLong(l);
                mRemote.transact(8, parcel, parcel1, 0);
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

            public void forceUpdate() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsService");
                mRemote.transact(7, parcel, parcel1, 0);
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

            public NetworkStats getDataLayerSnapshotForUid(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsService");
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                NetworkStats networkstats = (NetworkStats)NetworkStats.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkstats;
_L2:
                networkstats = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.net.INetworkStatsService";
            }

            public String[] getMobileIfaces() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.net.INetworkStatsService");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                as = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public long getNetworkTotalBytes(NetworkTemplate networktemplate, long l, long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsService");
                if(networktemplate == null)
                    break MISSING_BLOCK_LABEL_88;
                parcel.writeInt(1);
                networktemplate.writeToParcel(parcel, 0);
_L1:
                long l2;
                parcel.writeLong(l);
                parcel.writeLong(l1);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                l2 = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l2;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void incrementOperationCount(int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public INetworkStatsSession openSession() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                INetworkStatsSession inetworkstatssession;
                parcel.writeInterfaceToken("android.net.INetworkStatsService");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                inetworkstatssession = INetworkStatsSession.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return inetworkstatssession;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setUidForeground(int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsService");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                mRemote.transact(6, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static INetworkStatsService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.INetworkStatsService");
                if(iinterface != null && (iinterface instanceof INetworkStatsService))
                    obj = (INetworkStatsService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INetworkStatsService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag;
            boolean flag1;
            flag = false;
            flag1 = true;
            i;
            JVM INSTR lookupswitch 9: default 88
        //                       1: 111
        //                       2: 156
        //                       3: 218
        //                       4: 268
        //                       5: 293
        //                       6: 322
        //                       7: 360
        //                       8: 377
        //                       1598968902: 102;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            flag1 = super.onTransact(i, parcel, parcel1, j);
_L12:
            return flag1;
_L10:
            parcel1.writeString("android.net.INetworkStatsService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.INetworkStatsService");
            INetworkStatsSession inetworkstatssession = openSession();
            parcel1.writeNoException();
            IBinder ibinder;
            if(inetworkstatssession != null)
                ibinder = inetworkstatssession.asBinder();
            else
                ibinder = null;
            parcel1.writeStrongBinder(ibinder);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.INetworkStatsService");
            NetworkTemplate networktemplate;
            long l;
            if(parcel.readInt() != 0)
                networktemplate = (NetworkTemplate)NetworkTemplate.CREATOR.createFromParcel(parcel);
            else
                networktemplate = null;
            l = getNetworkTotalBytes(networktemplate, parcel.readLong(), parcel.readLong());
            parcel1.writeNoException();
            parcel1.writeLong(l);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.INetworkStatsService");
            NetworkStats networkstats = getDataLayerSnapshotForUid(parcel.readInt());
            parcel1.writeNoException();
            if(networkstats != null) {
                parcel1.writeInt(flag1);
                networkstats.writeToParcel(parcel1, flag1);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.INetworkStatsService");
            String as[] = getMobileIfaces();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.INetworkStatsService");
            incrementOperationCount(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.net.INetworkStatsService");
            int k = parcel.readInt();
            if(parcel.readInt() != 0)
                flag = flag1;
            setUidForeground(k, flag);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.net.INetworkStatsService");
            forceUpdate();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.net.INetworkStatsService");
            advisePersistThreshold(parcel.readLong());
            parcel1.writeNoException();
            if(true) goto _L12; else goto _L11
_L11:
        }

        private static final String DESCRIPTOR = "android.net.INetworkStatsService";
        static final int TRANSACTION_advisePersistThreshold = 8;
        static final int TRANSACTION_forceUpdate = 7;
        static final int TRANSACTION_getDataLayerSnapshotForUid = 3;
        static final int TRANSACTION_getMobileIfaces = 4;
        static final int TRANSACTION_getNetworkTotalBytes = 2;
        static final int TRANSACTION_incrementOperationCount = 5;
        static final int TRANSACTION_openSession = 1;
        static final int TRANSACTION_setUidForeground = 6;

        public Stub() {
            attachInterface(this, "android.net.INetworkStatsService");
        }
    }


    public abstract void advisePersistThreshold(long l) throws RemoteException;

    public abstract void forceUpdate() throws RemoteException;

    public abstract NetworkStats getDataLayerSnapshotForUid(int i) throws RemoteException;

    public abstract String[] getMobileIfaces() throws RemoteException;

    public abstract long getNetworkTotalBytes(NetworkTemplate networktemplate, long l, long l1) throws RemoteException;

    public abstract void incrementOperationCount(int i, int j, int k) throws RemoteException;

    public abstract INetworkStatsSession openSession() throws RemoteException;

    public abstract void setUidForeground(int i, boolean flag) throws RemoteException;
}
