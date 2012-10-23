// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.*;
import com.android.internal.net.LegacyVpnInfo;
import com.android.internal.net.VpnConfig;

// Referenced classes of package android.net:
//            LinkProperties, NetworkInfo, NetworkQuotaInfo, NetworkState, 
//            ProxyProperties

public interface IConnectivityManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IConnectivityManager {
        private static class Proxy
            implements IConnectivityManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public ParcelFileDescriptor establishVpn(VpnConfig vpnconfig) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                if(vpnconfig == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                vpnconfig.writeToParcel(parcel, 0);
_L3:
                ParcelFileDescriptor parcelfiledescriptor;
                mRemote.transact(42, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_101;
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return parcelfiledescriptor;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcelfiledescriptor = null;
                  goto _L4
            }

            public LinkProperties getActiveLinkProperties() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                LinkProperties linkproperties = (LinkProperties)LinkProperties.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return linkproperties;
_L2:
                linkproperties = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public NetworkInfo getActiveNetworkInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                NetworkInfo networkinfo = (NetworkInfo)NetworkInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkinfo;
_L2:
                networkinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public NetworkInfo getActiveNetworkInfoForUid(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                NetworkInfo networkinfo = (NetworkInfo)NetworkInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkinfo;
_L2:
                networkinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public NetworkQuotaInfo getActiveNetworkQuotaInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                NetworkQuotaInfo networkquotainfo = (NetworkQuotaInfo)NetworkQuotaInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkquotainfo;
_L2:
                networkquotainfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public NetworkInfo[] getAllNetworkInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                NetworkInfo anetworkinfo[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                anetworkinfo = (NetworkInfo[])parcel1.createTypedArray(NetworkInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return anetworkinfo;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public NetworkState[] getAllNetworkState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                NetworkState anetworkstate[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                anetworkstate = (NetworkState[])parcel1.createTypedArray(NetworkState.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return anetworkstate;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ProxyProperties getGlobalProxy() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(36, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ProxyProperties proxyproperties = (ProxyProperties)ProxyProperties.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return proxyproperties;
_L2:
                proxyproperties = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.net.IConnectivityManager";
            }

            public int getLastTetherError(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeString(s);
                mRemote.transact(24, parcel, parcel1, 0);
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

            public LegacyVpnInfo getLegacyVpnInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(44, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                LegacyVpnInfo legacyvpninfo = (LegacyVpnInfo)LegacyVpnInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return legacyvpninfo;
_L2:
                legacyvpninfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public LinkProperties getLinkProperties(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                LinkProperties linkproperties = (LinkProperties)LinkProperties.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return linkproperties;
_L2:
                linkproperties = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean getMobileDataEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
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

            public NetworkInfo getNetworkInfo(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                NetworkInfo networkinfo = (NetworkInfo)NetworkInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkinfo;
_L2:
                networkinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getNetworkPreference() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(2, parcel, parcel1, 0);
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

            public ProxyProperties getProxy() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(38, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ProxyProperties proxyproperties = (ProxyProperties)ProxyProperties.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return proxyproperties;
_L2:
                proxyproperties = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String[] getTetherableBluetoothRegexs() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(32, parcel, parcel1, 0);
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

            public String[] getTetherableIfaces() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(26, parcel, parcel1, 0);
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

            public String[] getTetherableUsbRegexs() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
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

            public String[] getTetherableWifiRegexs() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(31, parcel, parcel1, 0);
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

            public String[] getTetheredIfacePairs() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(28, parcel, parcel1, 0);
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

            public String[] getTetheredIfaces() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
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

            public String[] getTetheringErroredIfaces() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(29, parcel, parcel1, 0);
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

            public boolean isActiveNetworkMetered() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(12, parcel, parcel1, 0);
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

            public boolean isNetworkSupported(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
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

            public boolean isTetheringSupported() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                mRemote.transact(25, parcel, parcel1, 0);
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

            public boolean prepareVpn(String s, String s1) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(41, parcel, parcel1, 0);
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

            public boolean protectVpn(ParcelFileDescriptor parcelfiledescriptor) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                if(parcelfiledescriptor == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(40, parcel, parcel1, 0);
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

            public void reportInetCondition(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
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

            public void requestNetworkTransitionWakelock(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeString(s);
                mRemote.transact(34, parcel, parcel1, 0);
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

            public boolean requestRouteToHost(int i, int j) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(17, parcel, parcel1, 0);
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

            public boolean requestRouteToHostAddress(int i, byte abyte0[]) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                parcel.writeByteArray(abyte0);
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
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

            public void setDataDependency(int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                mRemote.transact(39, parcel, parcel1, 0);
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

            public void setGlobalProxy(ProxyProperties proxyproperties) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                if(proxyproperties == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                proxyproperties.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(37, parcel, parcel1, 0);
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

            public void setMobileDataEnabled(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
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

            public void setNetworkPreference(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public void setPolicyDataEnable(int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
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

            public boolean setRadio(int i, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                if(!flag)
                    break MISSING_BLOCK_LABEL_85;
                j = ((flag1) ? 1 : 0);
_L1:
                int k;
                parcel.writeInt(j);
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
                j = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean setRadios(boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                if(!flag)
                    break MISSING_BLOCK_LABEL_74;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
                i = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int setUsbTethering(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(33, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void startLegacyVpn(VpnConfig vpnconfig, String as[], String as1[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                if(vpnconfig == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                vpnconfig.writeToParcel(parcel, 0);
_L1:
                parcel.writeStringArray(as);
                parcel.writeStringArray(as1);
                mRemote.transact(43, parcel, parcel1, 0);
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

            public int startUsingNetworkFeature(int i, String s, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                parcel.writeString(s);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int stopUsingNetworkFeature(int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int tether(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeString(s);
                mRemote.transact(22, parcel, parcel1, 0);
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

            public int untether(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.IConnectivityManager");
                parcel.writeString(s);
                mRemote.transact(23, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IConnectivityManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.IConnectivityManager");
                if(iinterface != null && (iinterface instanceof IConnectivityManager))
                    obj = (IConnectivityManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IConnectivityManager) (obj));
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
            JVM INSTR lookupswitch 45: default 376
        //                       1: 399
        //                       2: 420
        //                       3: 445
        //                       4: 491
        //                       5: 541
        //                       6: 591
        //                       7: 618
        //                       8: 656
        //                       9: 702
        //                       10: 752
        //                       11: 779
        //                       12: 825
        //                       13: 859
        //                       14: 912
        //                       15: 973
        //                       16: 1010
        //                       17: 1043
        //                       18: 1085
        //                       19: 1127
        //                       20: 1161
        //                       21: 1197
        //                       22: 1241
        //                       23: 1270
        //                       24: 1299
        //                       25: 1328
        //                       26: 1362
        //                       27: 1387
        //                       28: 1412
        //                       29: 1437
        //                       30: 1462
        //                       31: 1487
        //                       32: 1512
        //                       33: 1537
        //                       34: 1581
        //                       35: 1602
        //                       36: 1627
        //                       37: 1673
        //                       38: 1719
        //                       39: 1765
        //                       40: 1809
        //                       41: 1872
        //                       42: 1914
        //                       43: 1989
        //                       44: 2043
        //                       1598968902: 390;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L48:
            return flag;
_L46:
            parcel1.writeString("android.net.IConnectivityManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.IConnectivityManager");
            setNetworkPreference(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int i3 = getNetworkPreference();
            parcel1.writeNoException();
            parcel1.writeInt(i3);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.IConnectivityManager");
            NetworkInfo networkinfo2 = getActiveNetworkInfo();
            parcel1.writeNoException();
            if(networkinfo2 != null) {
                parcel1.writeInt(flag);
                networkinfo2.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.IConnectivityManager");
            NetworkInfo networkinfo1 = getActiveNetworkInfoForUid(parcel.readInt());
            parcel1.writeNoException();
            if(networkinfo1 != null) {
                parcel1.writeInt(flag);
                networkinfo1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.IConnectivityManager");
            NetworkInfo networkinfo = getNetworkInfo(parcel.readInt());
            parcel1.writeNoException();
            if(networkinfo != null) {
                parcel1.writeInt(flag);
                networkinfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.net.IConnectivityManager");
            NetworkInfo anetworkinfo[] = getAllNetworkInfo();
            parcel1.writeNoException();
            parcel1.writeTypedArray(anetworkinfo, flag);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag16 = isNetworkSupported(parcel.readInt());
            parcel1.writeNoException();
            if(flag16)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.net.IConnectivityManager");
            LinkProperties linkproperties1 = getActiveLinkProperties();
            parcel1.writeNoException();
            if(linkproperties1 != null) {
                parcel1.writeInt(flag);
                linkproperties1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.net.IConnectivityManager");
            LinkProperties linkproperties = getLinkProperties(parcel.readInt());
            parcel1.writeNoException();
            if(linkproperties != null) {
                parcel1.writeInt(flag);
                linkproperties.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.net.IConnectivityManager");
            NetworkState anetworkstate[] = getAllNetworkState();
            parcel1.writeNoException();
            parcel1.writeTypedArray(anetworkstate, flag);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.net.IConnectivityManager");
            NetworkQuotaInfo networkquotainfo = getActiveNetworkQuotaInfo();
            parcel1.writeNoException();
            if(networkquotainfo != null) {
                parcel1.writeInt(flag);
                networkquotainfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag15 = isActiveNetworkMetered();
            parcel1.writeNoException();
            if(flag15)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag13;
            boolean flag14;
            if(parcel.readInt() != 0)
                flag13 = flag;
            else
                flag13 = false;
            flag14 = setRadios(flag13);
            parcel1.writeNoException();
            if(flag14)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int l2 = parcel.readInt();
            boolean flag11;
            boolean flag12;
            if(parcel.readInt() != 0)
                flag11 = flag;
            else
                flag11 = false;
            flag12 = setRadio(l2, flag11);
            parcel1.writeNoException();
            if(flag12)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int k2 = startUsingNetworkFeature(parcel.readInt(), parcel.readString(), parcel.readStrongBinder());
            parcel1.writeNoException();
            parcel1.writeInt(k2);
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int j2 = stopUsingNetworkFeature(parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(j2);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag10 = requestRouteToHost(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(flag10)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag9 = requestRouteToHostAddress(parcel.readInt(), parcel.createByteArray());
            parcel1.writeNoException();
            if(flag9)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag8 = getMobileDataEnabled();
            parcel1.writeNoException();
            if(flag8)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag7;
            if(parcel.readInt() != 0)
                flag7 = flag;
            else
                flag7 = false;
            setMobileDataEnabled(flag7);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int i2 = parcel.readInt();
            boolean flag6;
            if(parcel.readInt() != 0)
                flag6 = flag;
            else
                flag6 = false;
            setPolicyDataEnable(i2, flag6);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int l1 = tether(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(l1);
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int k1 = untether(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int j1 = getLastTetherError(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag5 = isTetheringSupported();
            parcel1.writeNoException();
            if(flag5)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.net.IConnectivityManager");
            String as6[] = getTetherableIfaces();
            parcel1.writeNoException();
            parcel1.writeStringArray(as6);
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.net.IConnectivityManager");
            String as5[] = getTetheredIfaces();
            parcel1.writeNoException();
            parcel1.writeStringArray(as5);
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.net.IConnectivityManager");
            String as4[] = getTetheredIfacePairs();
            parcel1.writeNoException();
            parcel1.writeStringArray(as4);
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.net.IConnectivityManager");
            String as3[] = getTetheringErroredIfaces();
            parcel1.writeNoException();
            parcel1.writeStringArray(as3);
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.net.IConnectivityManager");
            String as2[] = getTetherableUsbRegexs();
            parcel1.writeNoException();
            parcel1.writeStringArray(as2);
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("android.net.IConnectivityManager");
            String as1[] = getTetherableWifiRegexs();
            parcel1.writeNoException();
            parcel1.writeStringArray(as1);
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("android.net.IConnectivityManager");
            String as[] = getTetherableBluetoothRegexs();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag4;
            int i1;
            if(parcel.readInt() != 0)
                flag4 = flag;
            else
                flag4 = false;
            i1 = setUsbTethering(flag4);
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("android.net.IConnectivityManager");
            requestNetworkTransitionWakelock(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("android.net.IConnectivityManager");
            reportInetCondition(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("android.net.IConnectivityManager");
            ProxyProperties proxyproperties2 = getGlobalProxy();
            parcel1.writeNoException();
            if(proxyproperties2 != null) {
                parcel1.writeInt(flag);
                proxyproperties2.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("android.net.IConnectivityManager");
            ProxyProperties proxyproperties1;
            if(parcel.readInt() != 0)
                proxyproperties1 = (ProxyProperties)ProxyProperties.CREATOR.createFromParcel(parcel);
            else
                proxyproperties1 = null;
            setGlobalProxy(proxyproperties1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("android.net.IConnectivityManager");
            ProxyProperties proxyproperties = getProxy();
            parcel1.writeNoException();
            if(proxyproperties != null) {
                parcel1.writeInt(flag);
                proxyproperties.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("android.net.IConnectivityManager");
            int l = parcel.readInt();
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            setDataDependency(l, flag3);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("android.net.IConnectivityManager");
            ParcelFileDescriptor parcelfiledescriptor1;
            boolean flag2;
            if(parcel.readInt() != 0)
                parcelfiledescriptor1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor1 = null;
            flag2 = protectVpn(parcelfiledescriptor1);
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("android.net.IConnectivityManager");
            boolean flag1 = prepareVpn(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L43:
            parcel.enforceInterface("android.net.IConnectivityManager");
            VpnConfig vpnconfig1;
            ParcelFileDescriptor parcelfiledescriptor;
            if(parcel.readInt() != 0)
                vpnconfig1 = (VpnConfig)VpnConfig.CREATOR.createFromParcel(parcel);
            else
                vpnconfig1 = null;
            parcelfiledescriptor = establishVpn(vpnconfig1);
            parcel1.writeNoException();
            if(parcelfiledescriptor != null) {
                parcel1.writeInt(flag);
                parcelfiledescriptor.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L44:
            parcel.enforceInterface("android.net.IConnectivityManager");
            VpnConfig vpnconfig;
            if(parcel.readInt() != 0)
                vpnconfig = (VpnConfig)VpnConfig.CREATOR.createFromParcel(parcel);
            else
                vpnconfig = null;
            startLegacyVpn(vpnconfig, parcel.createStringArray(), parcel.createStringArray());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L45:
            parcel.enforceInterface("android.net.IConnectivityManager");
            LegacyVpnInfo legacyvpninfo = getLegacyVpnInfo();
            parcel1.writeNoException();
            if(legacyvpninfo != null) {
                parcel1.writeInt(flag);
                legacyvpninfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            if(true) goto _L48; else goto _L47
_L47:
        }

        private static final String DESCRIPTOR = "android.net.IConnectivityManager";
        static final int TRANSACTION_establishVpn = 42;
        static final int TRANSACTION_getActiveLinkProperties = 8;
        static final int TRANSACTION_getActiveNetworkInfo = 3;
        static final int TRANSACTION_getActiveNetworkInfoForUid = 4;
        static final int TRANSACTION_getActiveNetworkQuotaInfo = 11;
        static final int TRANSACTION_getAllNetworkInfo = 6;
        static final int TRANSACTION_getAllNetworkState = 10;
        static final int TRANSACTION_getGlobalProxy = 36;
        static final int TRANSACTION_getLastTetherError = 24;
        static final int TRANSACTION_getLegacyVpnInfo = 44;
        static final int TRANSACTION_getLinkProperties = 9;
        static final int TRANSACTION_getMobileDataEnabled = 19;
        static final int TRANSACTION_getNetworkInfo = 5;
        static final int TRANSACTION_getNetworkPreference = 2;
        static final int TRANSACTION_getProxy = 38;
        static final int TRANSACTION_getTetherableBluetoothRegexs = 32;
        static final int TRANSACTION_getTetherableIfaces = 26;
        static final int TRANSACTION_getTetherableUsbRegexs = 30;
        static final int TRANSACTION_getTetherableWifiRegexs = 31;
        static final int TRANSACTION_getTetheredIfacePairs = 28;
        static final int TRANSACTION_getTetheredIfaces = 27;
        static final int TRANSACTION_getTetheringErroredIfaces = 29;
        static final int TRANSACTION_isActiveNetworkMetered = 12;
        static final int TRANSACTION_isNetworkSupported = 7;
        static final int TRANSACTION_isTetheringSupported = 25;
        static final int TRANSACTION_prepareVpn = 41;
        static final int TRANSACTION_protectVpn = 40;
        static final int TRANSACTION_reportInetCondition = 35;
        static final int TRANSACTION_requestNetworkTransitionWakelock = 34;
        static final int TRANSACTION_requestRouteToHost = 17;
        static final int TRANSACTION_requestRouteToHostAddress = 18;
        static final int TRANSACTION_setDataDependency = 39;
        static final int TRANSACTION_setGlobalProxy = 37;
        static final int TRANSACTION_setMobileDataEnabled = 20;
        static final int TRANSACTION_setNetworkPreference = 1;
        static final int TRANSACTION_setPolicyDataEnable = 21;
        static final int TRANSACTION_setRadio = 14;
        static final int TRANSACTION_setRadios = 13;
        static final int TRANSACTION_setUsbTethering = 33;
        static final int TRANSACTION_startLegacyVpn = 43;
        static final int TRANSACTION_startUsingNetworkFeature = 15;
        static final int TRANSACTION_stopUsingNetworkFeature = 16;
        static final int TRANSACTION_tether = 22;
        static final int TRANSACTION_untether = 23;

        public Stub() {
            attachInterface(this, "android.net.IConnectivityManager");
        }
    }


    public abstract ParcelFileDescriptor establishVpn(VpnConfig vpnconfig) throws RemoteException;

    public abstract LinkProperties getActiveLinkProperties() throws RemoteException;

    public abstract NetworkInfo getActiveNetworkInfo() throws RemoteException;

    public abstract NetworkInfo getActiveNetworkInfoForUid(int i) throws RemoteException;

    public abstract NetworkQuotaInfo getActiveNetworkQuotaInfo() throws RemoteException;

    public abstract NetworkInfo[] getAllNetworkInfo() throws RemoteException;

    public abstract NetworkState[] getAllNetworkState() throws RemoteException;

    public abstract ProxyProperties getGlobalProxy() throws RemoteException;

    public abstract int getLastTetherError(String s) throws RemoteException;

    public abstract LegacyVpnInfo getLegacyVpnInfo() throws RemoteException;

    public abstract LinkProperties getLinkProperties(int i) throws RemoteException;

    public abstract boolean getMobileDataEnabled() throws RemoteException;

    public abstract NetworkInfo getNetworkInfo(int i) throws RemoteException;

    public abstract int getNetworkPreference() throws RemoteException;

    public abstract ProxyProperties getProxy() throws RemoteException;

    public abstract String[] getTetherableBluetoothRegexs() throws RemoteException;

    public abstract String[] getTetherableIfaces() throws RemoteException;

    public abstract String[] getTetherableUsbRegexs() throws RemoteException;

    public abstract String[] getTetherableWifiRegexs() throws RemoteException;

    public abstract String[] getTetheredIfacePairs() throws RemoteException;

    public abstract String[] getTetheredIfaces() throws RemoteException;

    public abstract String[] getTetheringErroredIfaces() throws RemoteException;

    public abstract boolean isActiveNetworkMetered() throws RemoteException;

    public abstract boolean isNetworkSupported(int i) throws RemoteException;

    public abstract boolean isTetheringSupported() throws RemoteException;

    public abstract boolean prepareVpn(String s, String s1) throws RemoteException;

    public abstract boolean protectVpn(ParcelFileDescriptor parcelfiledescriptor) throws RemoteException;

    public abstract void reportInetCondition(int i, int j) throws RemoteException;

    public abstract void requestNetworkTransitionWakelock(String s) throws RemoteException;

    public abstract boolean requestRouteToHost(int i, int j) throws RemoteException;

    public abstract boolean requestRouteToHostAddress(int i, byte abyte0[]) throws RemoteException;

    public abstract void setDataDependency(int i, boolean flag) throws RemoteException;

    public abstract void setGlobalProxy(ProxyProperties proxyproperties) throws RemoteException;

    public abstract void setMobileDataEnabled(boolean flag) throws RemoteException;

    public abstract void setNetworkPreference(int i) throws RemoteException;

    public abstract void setPolicyDataEnable(int i, boolean flag) throws RemoteException;

    public abstract boolean setRadio(int i, boolean flag) throws RemoteException;

    public abstract boolean setRadios(boolean flag) throws RemoteException;

    public abstract int setUsbTethering(boolean flag) throws RemoteException;

    public abstract void startLegacyVpn(VpnConfig vpnconfig, String as[], String as1[]) throws RemoteException;

    public abstract int startUsingNetworkFeature(int i, String s, IBinder ibinder) throws RemoteException;

    public abstract int stopUsingNetworkFeature(int i, String s) throws RemoteException;

    public abstract int tether(String s) throws RemoteException;

    public abstract int untether(String s) throws RemoteException;
}
