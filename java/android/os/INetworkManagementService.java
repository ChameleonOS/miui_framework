// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.net.*;
import android.net.wifi.WifiConfiguration;

// Referenced classes of package android.os:
//            IInterface, RemoteException, Binder, IBinder, 
//            Parcel

public interface INetworkManagementService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INetworkManagementService {
        private static class Proxy
            implements INetworkManagementService {

            public void addRoute(String s, RouteInfo routeinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                if(routeinfo == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                routeinfo.writeToParcel(parcel, 0);
_L1:
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

            public void addSecondaryRoute(String s, RouteInfo routeinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                if(routeinfo == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                routeinfo.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(15, parcel, parcel1, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void attachPppd(String s, String s1, String s2, String s3, String s4) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                parcel.writeString(s3);
                parcel.writeString(s4);
                mRemote.transact(31, parcel, parcel1, 0);
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

            public void clearInterfaceAddresses(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
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

            public void detachPppd(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(32, parcel, parcel1, 0);
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

            public void disableIpv6(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void disableNat(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            public void enableIpv6(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
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

            public void enableNat(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(28, parcel, parcel1, 0);
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

            public void flushDefaultDnsCache() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(54, parcel, parcel1, 0);
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

            public void flushInterfaceDnsCache(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(55, parcel, parcel1, 0);
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

            public String[] getDnsForwarders() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(27, parcel, parcel1, 0);
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

            public InterfaceConfiguration getInterfaceConfig(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                InterfaceConfiguration interfaceconfiguration = (InterfaceConfiguration)InterfaceConfiguration.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return interfaceconfiguration;
_L2:
                interfaceconfiguration = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.os.INetworkManagementService";
            }

            public int getInterfaceRxThrottle(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(50, parcel, parcel1, 0);
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

            public int getInterfaceTxThrottle(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(51, parcel, parcel1, 0);
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

            public boolean getIpForwardingEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(18, parcel, parcel1, 0);
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

            public NetworkStats getNetworkStatsDetail() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(39, parcel, parcel1, 0);
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

            public NetworkStats getNetworkStatsSummaryDev() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(37, parcel, parcel1, 0);
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

            public NetworkStats getNetworkStatsSummaryXt() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(38, parcel, parcel1, 0);
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

            public NetworkStats getNetworkStatsTethering(String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeStringArray(as);
                mRemote.transact(41, parcel, parcel1, 0);
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

            public NetworkStats getNetworkStatsUidDetail(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeInt(i);
                mRemote.transact(40, parcel, parcel1, 0);
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

            public RouteInfo[] getRoutes(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                RouteInfo arouteinfo[];
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                arouteinfo = (RouteInfo[])parcel1.createTypedArray(RouteInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arouteinfo;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isBandwidthControlEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(48, parcel, parcel1, 0);
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

            public boolean isTetheringStarted() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(22, parcel, parcel1, 0);
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

            public String[] listInterfaces() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(3, parcel, parcel1, 0);
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

            public String[] listTetheredInterfaces() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(25, parcel, parcel1, 0);
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

            public String[] listTtys() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(30, parcel, parcel1, 0);
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

            public void registerObserver(INetworkManagementEventObserver inetworkmanagementeventobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                if(inetworkmanagementeventobserver == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = inetworkmanagementeventobserver.asBinder();
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

            public void removeInterfaceAlert(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(45, parcel, parcel1, 0);
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

            public void removeInterfaceQuota(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(43, parcel, parcel1, 0);
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

            public void removeRoute(String s, RouteInfo routeinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                if(routeinfo == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                routeinfo.writeToParcel(parcel, 0);
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

            public void removeSecondaryRoute(String s, RouteInfo routeinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                if(routeinfo == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                routeinfo.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(16, parcel, parcel1, 0);
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

            public void setAccessPoint(WifiConfiguration wificonfiguration, String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                if(wificonfiguration == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                wificonfiguration.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(36, parcel, parcel1, 0);
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

            public void setDefaultInterfaceForDns(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(52, parcel, parcel1, 0);
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

            public void setDnsForwarders(String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeStringArray(as);
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

            public void setDnsServersForInterface(String s, String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                parcel.writeStringArray(as);
                mRemote.transact(53, parcel, parcel1, 0);
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

            public void setGlobalAlert(long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeLong(l);
                mRemote.transact(46, parcel, parcel1, 0);
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

            public void setInterfaceAlert(String s, long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                parcel.writeLong(l);
                mRemote.transact(44, parcel, parcel1, 0);
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

            public void setInterfaceConfig(String s, InterfaceConfiguration interfaceconfiguration) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                if(interfaceconfiguration == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                interfaceconfiguration.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(5, parcel, parcel1, 0);
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

            public void setInterfaceDown(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
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

            public void setInterfaceIpv6PrivacyExtensions(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(9, parcel, parcel1, 0);
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

            public void setInterfaceQuota(String s, long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                parcel.writeLong(l);
                mRemote.transact(42, parcel, parcel1, 0);
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

            public void setInterfaceThrottle(String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(49, parcel, parcel1, 0);
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

            public void setInterfaceUp(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
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

            public void setIpForwardingEnabled(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(19, parcel, parcel1, 0);
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

            public void setUidNetworkRules(int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                mRemote.transact(47, parcel, parcel1, 0);
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

            public void shutdown() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                mRemote.transact(17, parcel, parcel1, 0);
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

            public void startAccessPoint(WifiConfiguration wificonfiguration, String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                if(wificonfiguration == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                wificonfiguration.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(34, parcel, parcel1, 0);
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

            public void startTethering(String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeStringArray(as);
                mRemote.transact(20, parcel, parcel1, 0);
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

            public void stopAccessPoint(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(35, parcel, parcel1, 0);
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

            public void stopTethering() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
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

            public void tetherInterface(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
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

            public void unregisterObserver(INetworkManagementEventObserver inetworkmanagementeventobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                if(inetworkmanagementeventobserver == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = inetworkmanagementeventobserver.asBinder();
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

            public void untetherInterface(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                mRemote.transact(24, parcel, parcel1, 0);
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

            public void wifiFirmwareReload(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.os.INetworkManagementService");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(33, parcel, parcel1, 0);
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


        public static INetworkManagementService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.os.INetworkManagementService");
                if(iinterface != null && (iinterface instanceof INetworkManagementService))
                    obj = (INetworkManagementService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INetworkManagementService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 56: default 460
        //                       1: 486
        //                       2: 513
        //                       3: 540
        //                       4: 568
        //                       5: 619
        //                       6: 676
        //                       7: 700
        //                       8: 724
        //                       9: 748
        //                       10: 794
        //                       11: 818
        //                       12: 842
        //                       13: 875
        //                       14: 932
        //                       15: 989
        //                       16: 1046
        //                       17: 1103
        //                       18: 1123
        //                       19: 1165
        //                       20: 1203
        //                       21: 1227
        //                       22: 1247
        //                       23: 1289
        //                       24: 1313
        //                       25: 1337
        //                       26: 1365
        //                       27: 1389
        //                       28: 1417
        //                       29: 1445
        //                       30: 1473
        //                       31: 1501
        //                       32: 1541
        //                       33: 1565
        //                       34: 1593
        //                       35: 1650
        //                       36: 1674
        //                       37: 1731
        //                       38: 1778
        //                       39: 1825
        //                       40: 1872
        //                       41: 1923
        //                       42: 1974
        //                       43: 2002
        //                       44: 2026
        //                       45: 2054
        //                       46: 2078
        //                       47: 2102
        //                       48: 2148
        //                       49: 2190
        //                       50: 2222
        //                       51: 2254
        //                       52: 2286
        //                       53: 2310
        //                       54: 2338
        //                       55: 2358
        //                       1598968902: 474;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L59:
            return flag;
_L57:
            parcel1.writeString("android.os.INetworkManagementService");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.os.INetworkManagementService");
            registerObserver(android.net.INetworkManagementEventObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.os.INetworkManagementService");
            unregisterObserver(android.net.INetworkManagementEventObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String as3[] = listInterfaces();
            parcel1.writeNoException();
            parcel1.writeStringArray(as3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.os.INetworkManagementService");
            InterfaceConfiguration interfaceconfiguration1 = getInterfaceConfig(parcel.readString());
            parcel1.writeNoException();
            if(interfaceconfiguration1 != null) {
                parcel1.writeInt(1);
                interfaceconfiguration1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String s5 = parcel.readString();
            InterfaceConfiguration interfaceconfiguration;
            if(parcel.readInt() != 0)
                interfaceconfiguration = (InterfaceConfiguration)InterfaceConfiguration.CREATOR.createFromParcel(parcel);
            else
                interfaceconfiguration = null;
            setInterfaceConfig(s5, interfaceconfiguration);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.os.INetworkManagementService");
            clearInterfaceAddresses(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setInterfaceDown(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setInterfaceUp(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String s4 = parcel.readString();
            boolean flag6;
            if(parcel.readInt() != 0)
                flag6 = true;
            else
                flag6 = false;
            setInterfaceIpv6PrivacyExtensions(s4, flag6);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.os.INetworkManagementService");
            disableIpv6(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.os.INetworkManagementService");
            enableIpv6(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.os.INetworkManagementService");
            RouteInfo arouteinfo[] = getRoutes(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeTypedArray(arouteinfo, 1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String s3 = parcel.readString();
            RouteInfo routeinfo3;
            if(parcel.readInt() != 0)
                routeinfo3 = (RouteInfo)RouteInfo.CREATOR.createFromParcel(parcel);
            else
                routeinfo3 = null;
            addRoute(s3, routeinfo3);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String s2 = parcel.readString();
            RouteInfo routeinfo2;
            if(parcel.readInt() != 0)
                routeinfo2 = (RouteInfo)RouteInfo.CREATOR.createFromParcel(parcel);
            else
                routeinfo2 = null;
            removeRoute(s2, routeinfo2);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String s1 = parcel.readString();
            RouteInfo routeinfo1;
            if(parcel.readInt() != 0)
                routeinfo1 = (RouteInfo)RouteInfo.CREATOR.createFromParcel(parcel);
            else
                routeinfo1 = null;
            addSecondaryRoute(s1, routeinfo1);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String s = parcel.readString();
            RouteInfo routeinfo;
            if(parcel.readInt() != 0)
                routeinfo = (RouteInfo)RouteInfo.CREATOR.createFromParcel(parcel);
            else
                routeinfo = null;
            removeSecondaryRoute(s, routeinfo);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.os.INetworkManagementService");
            shutdown();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.os.INetworkManagementService");
            boolean flag5 = getIpForwardingEnabled();
            parcel1.writeNoException();
            int l1;
            if(flag5)
                l1 = 1;
            else
                l1 = 0;
            parcel1.writeInt(l1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.os.INetworkManagementService");
            boolean flag4;
            if(parcel.readInt() != 0)
                flag4 = true;
            else
                flag4 = false;
            setIpForwardingEnabled(flag4);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.os.INetworkManagementService");
            startTethering(parcel.createStringArray());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.os.INetworkManagementService");
            stopTethering();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.os.INetworkManagementService");
            boolean flag3 = isTetheringStarted();
            parcel1.writeNoException();
            int k1;
            if(flag3)
                k1 = 1;
            else
                k1 = 0;
            parcel1.writeInt(k1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.os.INetworkManagementService");
            tetherInterface(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.os.INetworkManagementService");
            untetherInterface(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String as2[] = listTetheredInterfaces();
            parcel1.writeNoException();
            parcel1.writeStringArray(as2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setDnsForwarders(parcel.createStringArray());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String as1[] = getDnsForwarders();
            parcel1.writeNoException();
            parcel1.writeStringArray(as1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.os.INetworkManagementService");
            enableNat(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.os.INetworkManagementService");
            disableNat(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.os.INetworkManagementService");
            String as[] = listTtys();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("android.os.INetworkManagementService");
            attachPppd(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("android.os.INetworkManagementService");
            detachPppd(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("android.os.INetworkManagementService");
            wifiFirmwareReload(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("android.os.INetworkManagementService");
            WifiConfiguration wificonfiguration1;
            if(parcel.readInt() != 0)
                wificonfiguration1 = (WifiConfiguration)WifiConfiguration.CREATOR.createFromParcel(parcel);
            else
                wificonfiguration1 = null;
            startAccessPoint(wificonfiguration1, parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("android.os.INetworkManagementService");
            stopAccessPoint(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("android.os.INetworkManagementService");
            WifiConfiguration wificonfiguration;
            if(parcel.readInt() != 0)
                wificonfiguration = (WifiConfiguration)WifiConfiguration.CREATOR.createFromParcel(parcel);
            else
                wificonfiguration = null;
            setAccessPoint(wificonfiguration, parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("android.os.INetworkManagementService");
            NetworkStats networkstats4 = getNetworkStatsSummaryDev();
            parcel1.writeNoException();
            if(networkstats4 != null) {
                parcel1.writeInt(1);
                networkstats4.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("android.os.INetworkManagementService");
            NetworkStats networkstats3 = getNetworkStatsSummaryXt();
            parcel1.writeNoException();
            if(networkstats3 != null) {
                parcel1.writeInt(1);
                networkstats3.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("android.os.INetworkManagementService");
            NetworkStats networkstats2 = getNetworkStatsDetail();
            parcel1.writeNoException();
            if(networkstats2 != null) {
                parcel1.writeInt(1);
                networkstats2.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("android.os.INetworkManagementService");
            NetworkStats networkstats1 = getNetworkStatsUidDetail(parcel.readInt());
            parcel1.writeNoException();
            if(networkstats1 != null) {
                parcel1.writeInt(1);
                networkstats1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("android.os.INetworkManagementService");
            NetworkStats networkstats = getNetworkStatsTethering(parcel.createStringArray());
            parcel1.writeNoException();
            if(networkstats != null) {
                parcel1.writeInt(1);
                networkstats.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L43:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setInterfaceQuota(parcel.readString(), parcel.readLong());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L44:
            parcel.enforceInterface("android.os.INetworkManagementService");
            removeInterfaceQuota(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L45:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setInterfaceAlert(parcel.readString(), parcel.readLong());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L46:
            parcel.enforceInterface("android.os.INetworkManagementService");
            removeInterfaceAlert(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L47:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setGlobalAlert(parcel.readLong());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L48:
            parcel.enforceInterface("android.os.INetworkManagementService");
            int j1 = parcel.readInt();
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = true;
            else
                flag2 = false;
            setUidNetworkRules(j1, flag2);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L49:
            parcel.enforceInterface("android.os.INetworkManagementService");
            boolean flag1 = isBandwidthControlEnabled();
            parcel1.writeNoException();
            int i1;
            if(flag1)
                i1 = 1;
            else
                i1 = 0;
            parcel1.writeInt(i1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L50:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setInterfaceThrottle(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L51:
            parcel.enforceInterface("android.os.INetworkManagementService");
            int l = getInterfaceRxThrottle(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(l);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L52:
            parcel.enforceInterface("android.os.INetworkManagementService");
            int k = getInterfaceTxThrottle(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L53:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setDefaultInterfaceForDns(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L54:
            parcel.enforceInterface("android.os.INetworkManagementService");
            setDnsServersForInterface(parcel.readString(), parcel.createStringArray());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L55:
            parcel.enforceInterface("android.os.INetworkManagementService");
            flushDefaultDnsCache();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L56:
            parcel.enforceInterface("android.os.INetworkManagementService");
            flushInterfaceDnsCache(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L59; else goto _L58
_L58:
        }

        private static final String DESCRIPTOR = "android.os.INetworkManagementService";
        static final int TRANSACTION_addRoute = 13;
        static final int TRANSACTION_addSecondaryRoute = 15;
        static final int TRANSACTION_attachPppd = 31;
        static final int TRANSACTION_clearInterfaceAddresses = 6;
        static final int TRANSACTION_detachPppd = 32;
        static final int TRANSACTION_disableIpv6 = 10;
        static final int TRANSACTION_disableNat = 29;
        static final int TRANSACTION_enableIpv6 = 11;
        static final int TRANSACTION_enableNat = 28;
        static final int TRANSACTION_flushDefaultDnsCache = 54;
        static final int TRANSACTION_flushInterfaceDnsCache = 55;
        static final int TRANSACTION_getDnsForwarders = 27;
        static final int TRANSACTION_getInterfaceConfig = 4;
        static final int TRANSACTION_getInterfaceRxThrottle = 50;
        static final int TRANSACTION_getInterfaceTxThrottle = 51;
        static final int TRANSACTION_getIpForwardingEnabled = 18;
        static final int TRANSACTION_getNetworkStatsDetail = 39;
        static final int TRANSACTION_getNetworkStatsSummaryDev = 37;
        static final int TRANSACTION_getNetworkStatsSummaryXt = 38;
        static final int TRANSACTION_getNetworkStatsTethering = 41;
        static final int TRANSACTION_getNetworkStatsUidDetail = 40;
        static final int TRANSACTION_getRoutes = 12;
        static final int TRANSACTION_isBandwidthControlEnabled = 48;
        static final int TRANSACTION_isTetheringStarted = 22;
        static final int TRANSACTION_listInterfaces = 3;
        static final int TRANSACTION_listTetheredInterfaces = 25;
        static final int TRANSACTION_listTtys = 30;
        static final int TRANSACTION_registerObserver = 1;
        static final int TRANSACTION_removeInterfaceAlert = 45;
        static final int TRANSACTION_removeInterfaceQuota = 43;
        static final int TRANSACTION_removeRoute = 14;
        static final int TRANSACTION_removeSecondaryRoute = 16;
        static final int TRANSACTION_setAccessPoint = 36;
        static final int TRANSACTION_setDefaultInterfaceForDns = 52;
        static final int TRANSACTION_setDnsForwarders = 26;
        static final int TRANSACTION_setDnsServersForInterface = 53;
        static final int TRANSACTION_setGlobalAlert = 46;
        static final int TRANSACTION_setInterfaceAlert = 44;
        static final int TRANSACTION_setInterfaceConfig = 5;
        static final int TRANSACTION_setInterfaceDown = 7;
        static final int TRANSACTION_setInterfaceIpv6PrivacyExtensions = 9;
        static final int TRANSACTION_setInterfaceQuota = 42;
        static final int TRANSACTION_setInterfaceThrottle = 49;
        static final int TRANSACTION_setInterfaceUp = 8;
        static final int TRANSACTION_setIpForwardingEnabled = 19;
        static final int TRANSACTION_setUidNetworkRules = 47;
        static final int TRANSACTION_shutdown = 17;
        static final int TRANSACTION_startAccessPoint = 34;
        static final int TRANSACTION_startTethering = 20;
        static final int TRANSACTION_stopAccessPoint = 35;
        static final int TRANSACTION_stopTethering = 21;
        static final int TRANSACTION_tetherInterface = 23;
        static final int TRANSACTION_unregisterObserver = 2;
        static final int TRANSACTION_untetherInterface = 24;
        static final int TRANSACTION_wifiFirmwareReload = 33;

        public Stub() {
            attachInterface(this, "android.os.INetworkManagementService");
        }
    }


    public abstract void addRoute(String s, RouteInfo routeinfo) throws RemoteException;

    public abstract void addSecondaryRoute(String s, RouteInfo routeinfo) throws RemoteException;

    public abstract void attachPppd(String s, String s1, String s2, String s3, String s4) throws RemoteException;

    public abstract void clearInterfaceAddresses(String s) throws RemoteException;

    public abstract void detachPppd(String s) throws RemoteException;

    public abstract void disableIpv6(String s) throws RemoteException;

    public abstract void disableNat(String s, String s1) throws RemoteException;

    public abstract void enableIpv6(String s) throws RemoteException;

    public abstract void enableNat(String s, String s1) throws RemoteException;

    public abstract void flushDefaultDnsCache() throws RemoteException;

    public abstract void flushInterfaceDnsCache(String s) throws RemoteException;

    public abstract String[] getDnsForwarders() throws RemoteException;

    public abstract InterfaceConfiguration getInterfaceConfig(String s) throws RemoteException;

    public abstract int getInterfaceRxThrottle(String s) throws RemoteException;

    public abstract int getInterfaceTxThrottle(String s) throws RemoteException;

    public abstract boolean getIpForwardingEnabled() throws RemoteException;

    public abstract NetworkStats getNetworkStatsDetail() throws RemoteException;

    public abstract NetworkStats getNetworkStatsSummaryDev() throws RemoteException;

    public abstract NetworkStats getNetworkStatsSummaryXt() throws RemoteException;

    public abstract NetworkStats getNetworkStatsTethering(String as[]) throws RemoteException;

    public abstract NetworkStats getNetworkStatsUidDetail(int i) throws RemoteException;

    public abstract RouteInfo[] getRoutes(String s) throws RemoteException;

    public abstract boolean isBandwidthControlEnabled() throws RemoteException;

    public abstract boolean isTetheringStarted() throws RemoteException;

    public abstract String[] listInterfaces() throws RemoteException;

    public abstract String[] listTetheredInterfaces() throws RemoteException;

    public abstract String[] listTtys() throws RemoteException;

    public abstract void registerObserver(INetworkManagementEventObserver inetworkmanagementeventobserver) throws RemoteException;

    public abstract void removeInterfaceAlert(String s) throws RemoteException;

    public abstract void removeInterfaceQuota(String s) throws RemoteException;

    public abstract void removeRoute(String s, RouteInfo routeinfo) throws RemoteException;

    public abstract void removeSecondaryRoute(String s, RouteInfo routeinfo) throws RemoteException;

    public abstract void setAccessPoint(WifiConfiguration wificonfiguration, String s, String s1) throws RemoteException;

    public abstract void setDefaultInterfaceForDns(String s) throws RemoteException;

    public abstract void setDnsForwarders(String as[]) throws RemoteException;

    public abstract void setDnsServersForInterface(String s, String as[]) throws RemoteException;

    public abstract void setGlobalAlert(long l) throws RemoteException;

    public abstract void setInterfaceAlert(String s, long l) throws RemoteException;

    public abstract void setInterfaceConfig(String s, InterfaceConfiguration interfaceconfiguration) throws RemoteException;

    public abstract void setInterfaceDown(String s) throws RemoteException;

    public abstract void setInterfaceIpv6PrivacyExtensions(String s, boolean flag) throws RemoteException;

    public abstract void setInterfaceQuota(String s, long l) throws RemoteException;

    public abstract void setInterfaceThrottle(String s, int i, int j) throws RemoteException;

    public abstract void setInterfaceUp(String s) throws RemoteException;

    public abstract void setIpForwardingEnabled(boolean flag) throws RemoteException;

    public abstract void setUidNetworkRules(int i, boolean flag) throws RemoteException;

    public abstract void shutdown() throws RemoteException;

    public abstract void startAccessPoint(WifiConfiguration wificonfiguration, String s, String s1) throws RemoteException;

    public abstract void startTethering(String as[]) throws RemoteException;

    public abstract void stopAccessPoint(String s) throws RemoteException;

    public abstract void stopTethering() throws RemoteException;

    public abstract void tetherInterface(String s) throws RemoteException;

    public abstract void unregisterObserver(INetworkManagementEventObserver inetworkmanagementeventobserver) throws RemoteException;

    public abstract void untetherInterface(String s) throws RemoteException;

    public abstract void wifiFirmwareReload(String s, String s1) throws RemoteException;
}
