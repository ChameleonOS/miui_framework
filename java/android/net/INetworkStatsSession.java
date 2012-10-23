// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.*;

// Referenced classes of package android.net:
//            NetworkTemplate, NetworkStatsHistory, NetworkStats

public interface INetworkStatsSession
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INetworkStatsSession {
        private static class Proxy
            implements INetworkStatsSession {

            public IBinder asBinder() {
                return mRemote;
            }

            public void close() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsSession");
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

            public NetworkStatsHistory getHistoryForNetwork(NetworkTemplate networktemplate, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsSession");
                if(networktemplate == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                networktemplate.writeToParcel(parcel, 0);
_L3:
                NetworkStatsHistory networkstatshistory;
                parcel.writeInt(i);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_112;
                networkstatshistory = (NetworkStatsHistory)NetworkStatsHistory.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkstatshistory;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                networkstatshistory = null;
                  goto _L4
            }

            public NetworkStatsHistory getHistoryForUid(NetworkTemplate networktemplate, int i, int j, int k, int l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsSession");
                if(networktemplate == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                networktemplate.writeToParcel(parcel, 0);
_L3:
                NetworkStatsHistory networkstatshistory;
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_141;
                networkstatshistory = (NetworkStatsHistory)NetworkStatsHistory.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkstatshistory;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                networkstatshistory = null;
                  goto _L4
            }

            public String getInterfaceDescriptor() {
                return "android.net.INetworkStatsSession";
            }

            public NetworkStats getSummaryForAllUid(NetworkTemplate networktemplate, long l, long l1, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsSession");
                if(networktemplate == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                networktemplate.writeToParcel(parcel, 0);
_L3:
                parcel.writeLong(l);
                parcel.writeLong(l1);
                Exception exception;
                NetworkStats networkstats;
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_149;
                networkstats = (NetworkStats)NetworkStats.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkstats;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                networkstats = null;
                  goto _L4
            }

            public NetworkStats getSummaryForNetwork(NetworkTemplate networktemplate, long l, long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkStatsSession");
                if(networktemplate == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                networktemplate.writeToParcel(parcel, 0);
_L3:
                NetworkStats networkstats;
                parcel.writeLong(l);
                parcel.writeLong(l1);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_128;
                networkstats = (NetworkStats)NetworkStats.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkstats;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                networkstats = null;
                  goto _L4
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static INetworkStatsSession asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.INetworkStatsSession");
                if(iinterface != null && (iinterface instanceof INetworkStatsSession))
                    obj = (INetworkStatsSession)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INetworkStatsSession) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 6: default 60
        //                       1: 86
        //                       2: 170
        //                       3: 250
        //                       4: 360
        //                       5: 468
        //                       1598968902: 74;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.net.INetworkStatsSession");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.INetworkStatsSession");
            NetworkTemplate networktemplate3;
            NetworkStats networkstats1;
            if(parcel.readInt() != 0)
                networktemplate3 = (NetworkTemplate)NetworkTemplate.CREATOR.createFromParcel(parcel);
            else
                networktemplate3 = null;
            networkstats1 = getSummaryForNetwork(networktemplate3, parcel.readLong(), parcel.readLong());
            parcel1.writeNoException();
            if(networkstats1 != null) {
                parcel1.writeInt(1);
                networkstats1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.INetworkStatsSession");
            NetworkTemplate networktemplate2;
            NetworkStatsHistory networkstatshistory1;
            if(parcel.readInt() != 0)
                networktemplate2 = (NetworkTemplate)NetworkTemplate.CREATOR.createFromParcel(parcel);
            else
                networktemplate2 = null;
            networkstatshistory1 = getHistoryForNetwork(networktemplate2, parcel.readInt());
            parcel1.writeNoException();
            if(networkstatshistory1 != null) {
                parcel1.writeInt(1);
                networkstatshistory1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.INetworkStatsSession");
            NetworkTemplate networktemplate1;
            long l1;
            long l2;
            boolean flag1;
            NetworkStats networkstats;
            if(parcel.readInt() != 0)
                networktemplate1 = (NetworkTemplate)NetworkTemplate.CREATOR.createFromParcel(parcel);
            else
                networktemplate1 = null;
            l1 = parcel.readLong();
            l2 = parcel.readLong();
            if(parcel.readInt() != 0)
                flag1 = true;
            else
                flag1 = false;
            networkstats = getSummaryForAllUid(networktemplate1, l1, l2, flag1);
            parcel1.writeNoException();
            if(networkstats != null) {
                parcel1.writeInt(1);
                networkstats.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.INetworkStatsSession");
            NetworkTemplate networktemplate;
            int k;
            int l;
            int i1;
            int j1;
            NetworkStatsHistory networkstatshistory;
            if(parcel.readInt() != 0)
                networktemplate = (NetworkTemplate)NetworkTemplate.CREATOR.createFromParcel(parcel);
            else
                networktemplate = null;
            k = parcel.readInt();
            l = parcel.readInt();
            i1 = parcel.readInt();
            j1 = parcel.readInt();
            networkstatshistory = getHistoryForUid(networktemplate, k, l, i1, j1);
            parcel1.writeNoException();
            if(networkstatshistory != null) {
                parcel1.writeInt(1);
                networkstatshistory.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.INetworkStatsSession");
            close();
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.net.INetworkStatsSession";
        static final int TRANSACTION_close = 5;
        static final int TRANSACTION_getHistoryForNetwork = 2;
        static final int TRANSACTION_getHistoryForUid = 4;
        static final int TRANSACTION_getSummaryForAllUid = 3;
        static final int TRANSACTION_getSummaryForNetwork = 1;

        public Stub() {
            attachInterface(this, "android.net.INetworkStatsSession");
        }
    }


    public abstract void close() throws RemoteException;

    public abstract NetworkStatsHistory getHistoryForNetwork(NetworkTemplate networktemplate, int i) throws RemoteException;

    public abstract NetworkStatsHistory getHistoryForUid(NetworkTemplate networktemplate, int i, int j, int k, int l) throws RemoteException;

    public abstract NetworkStats getSummaryForAllUid(NetworkTemplate networktemplate, long l, long l1, boolean flag) throws RemoteException;

    public abstract NetworkStats getSummaryForNetwork(NetworkTemplate networktemplate, long l, long l1) throws RemoteException;
}
