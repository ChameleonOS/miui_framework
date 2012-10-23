// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.net.DhcpInfo;
import android.os.*;
import java.util.List;

// Referenced classes of package android.net.wifi:
//            WifiConfiguration, WifiInfo, ScanResult

public interface IWifiManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWifiManager {
        private static class Proxy
            implements IWifiManager {

            public void acquireMulticastLock(IBinder ibinder, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
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

            public boolean acquireWifiLock(IBinder ibinder, int i, String s, WorkSource worksource) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeString(s);
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_104;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                int j;
                mRemote.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
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

            public int addOrUpdateNetwork(WifiConfiguration wificonfiguration) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                if(wificonfiguration == null)
                    break MISSING_BLOCK_LABEL_64;
                parcel.writeInt(1);
                wificonfiguration.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void addToBlacklist(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void clearBlacklist() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public boolean disableNetwork(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public void disconnect() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public boolean enableNetwork(int i, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeInt(i);
                if(!flag)
                    break MISSING_BLOCK_LABEL_84;
                j = ((flag1) ? 1 : 0);
_L1:
                int k;
                parcel.writeInt(j);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public String getConfigFile() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(38, parcel, parcel1, 0);
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

            public List getConfiguredNetworks() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(WifiConfiguration.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public WifiInfo getConnectionInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                WifiInfo wifiinfo = (WifiInfo)WifiInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return wifiinfo;
_L2:
                wifiinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public DhcpInfo getDhcpInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                DhcpInfo dhcpinfo = (DhcpInfo)DhcpInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return dhcpinfo;
_L2:
                dhcpinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getFrequencyBand() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(17, parcel, parcel1, 0);
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
                return "android.net.wifi.IWifiManager";
            }

            public List getScanResults() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ScanResult.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public WifiConfiguration getWifiApConfiguration() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(30, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                WifiConfiguration wificonfiguration = (WifiConfiguration)WifiConfiguration.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return wificonfiguration;
_L2:
                wificonfiguration = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getWifiApEnabledState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(29, parcel, parcel1, 0);
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

            public int getWifiEnabledState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(14, parcel, parcel1, 0);
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

            public Messenger getWifiServiceMessenger() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(36, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Messenger messenger = (Messenger)Messenger.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return messenger;
_L2:
                messenger = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public Messenger getWifiStateMachineMessenger() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                mRemote.transact(37, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Messenger messenger = (Messenger)Messenger.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return messenger;
_L2:
                messenger = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void initializeMulticastFiltering() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public boolean isDualBandSupported() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public boolean isMulticastEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public boolean pingSupplicant() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public void reassociate() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public void reconnect() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public void releaseMulticastLock() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public boolean releaseWifiLock(IBinder ibinder) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(23, parcel, parcel1, 0);
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

            public boolean removeNetwork(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public boolean saveConfiguration() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public void setCountryCode(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public void setFrequencyBand(int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
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

            public void setWifiApConfiguration(WifiConfiguration wificonfiguration) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                if(wificonfiguration == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                wificonfiguration.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(31, parcel, parcel1, 0);
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

            public void setWifiApEnabled(WifiConfiguration wificonfiguration, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                if(wificonfiguration != null) {
                    parcel.writeInt(1);
                    wificonfiguration.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_102;
                }
                  goto _L1
_L2:
                parcel.writeInt(i);
                mRemote.transact(28, parcel, parcel1, 0);
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

            public boolean setWifiEnabled(boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public void startScan(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
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

            public void startWifi() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public void stopWifi() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
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

            public void updateWifiLockWorkSource(IBinder ibinder, WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.wifi.IWifiManager");
                parcel.writeStrongBinder(ibinder);
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(22, parcel, parcel1, 0);
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


        public static IWifiManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.wifi.IWifiManager");
                if(iinterface != null && (iinterface instanceof IWifiManager))
                    obj = (IWifiManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWifiManager) (obj));
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
            JVM INSTR lookupswitch 39: default 328
        //                       1: 351
        //                       2: 376
        //                       3: 430
        //                       4: 468
        //                       5: 529
        //                       6: 567
        //                       7: 601
        //                       8: 637
        //                       9: 662
        //                       10: 679
        //                       11: 696
        //                       12: 713
        //                       13: 759
        //                       14: 812
        //                       15: 837
        //                       16: 881
        //                       17: 925
        //                       18: 950
        //                       19: 984
        //                       20: 1018
        //                       21: 1064
        //                       22: 1151
        //                       23: 1205
        //                       24: 1243
        //                       25: 1260
        //                       26: 1294
        //                       27: 1319
        //                       28: 1336
        //                       29: 1401
        //                       30: 1426
        //                       31: 1472
        //                       32: 1518
        //                       33: 1535
        //                       34: 1552
        //                       35: 1573
        //                       36: 1590
        //                       37: 1636
        //                       38: 1682
        //                       1598968902: 342;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L42:
            return flag;
_L40:
            parcel1.writeString("android.net.wifi.IWifiManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            List list1 = getConfiguredNetworks();
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            WifiConfiguration wificonfiguration3;
            int j2;
            if(parcel.readInt() != 0)
                wificonfiguration3 = (WifiConfiguration)WifiConfiguration.CREATOR.createFromParcel(parcel);
            else
                wificonfiguration3 = null;
            j2 = addOrUpdateNetwork(wificonfiguration3);
            parcel1.writeNoException();
            parcel1.writeInt(j2);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag16 = removeNetwork(parcel.readInt());
            parcel1.writeNoException();
            if(flag16)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            int i2 = parcel.readInt();
            boolean flag14;
            boolean flag15;
            if(parcel.readInt() != 0)
                flag14 = flag;
            else
                flag14 = false;
            flag15 = enableNetwork(i2, flag14);
            parcel1.writeNoException();
            if(flag15)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag13 = disableNetwork(parcel.readInt());
            parcel1.writeNoException();
            if(flag13)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag12 = pingSupplicant();
            parcel1.writeNoException();
            if(flag12)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag11;
            if(parcel.readInt() != 0)
                flag11 = flag;
            else
                flag11 = false;
            startScan(flag11);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            List list = getScanResults();
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            disconnect();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            reconnect();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            reassociate();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            WifiInfo wifiinfo = getConnectionInfo();
            parcel1.writeNoException();
            if(wifiinfo != null) {
                parcel1.writeInt(flag);
                wifiinfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag9;
            boolean flag10;
            if(parcel.readInt() != 0)
                flag9 = flag;
            else
                flag9 = false;
            flag10 = setWifiEnabled(flag9);
            parcel1.writeNoException();
            if(flag10)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            int l1 = getWifiEnabledState();
            parcel1.writeNoException();
            parcel1.writeInt(l1);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            String s2 = parcel.readString();
            boolean flag8;
            if(parcel.readInt() != 0)
                flag8 = flag;
            else
                flag8 = false;
            setCountryCode(s2, flag8);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            int k1 = parcel.readInt();
            boolean flag7;
            if(parcel.readInt() != 0)
                flag7 = flag;
            else
                flag7 = false;
            setFrequencyBand(k1, flag7);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            int j1 = getFrequencyBand();
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag6 = isDualBandSupported();
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag5 = saveConfiguration();
            parcel1.writeNoException();
            if(flag5)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            DhcpInfo dhcpinfo = getDhcpInfo();
            parcel1.writeNoException();
            if(dhcpinfo != null) {
                parcel1.writeInt(flag);
                dhcpinfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            IBinder ibinder1 = parcel.readStrongBinder();
            int i1 = parcel.readInt();
            String s1 = parcel.readString();
            WorkSource worksource1;
            boolean flag4;
            if(parcel.readInt() != 0)
                worksource1 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource1 = null;
            flag4 = acquireWifiLock(ibinder1, i1, s1, worksource1);
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            IBinder ibinder = parcel.readStrongBinder();
            WorkSource worksource;
            if(parcel.readInt() != 0)
                worksource = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource = null;
            updateWifiLockWorkSource(ibinder, worksource);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag3 = releaseWifiLock(parcel.readStrongBinder());
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            initializeMulticastFiltering();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            boolean flag2 = isMulticastEnabled();
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            acquireMulticastLock(parcel.readStrongBinder(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            releaseMulticastLock();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            WifiConfiguration wificonfiguration2;
            boolean flag1;
            if(parcel.readInt() != 0)
                wificonfiguration2 = (WifiConfiguration)WifiConfiguration.CREATOR.createFromParcel(parcel);
            else
                wificonfiguration2 = null;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            setWifiApEnabled(wificonfiguration2, flag1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            int l = getWifiApEnabledState();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            WifiConfiguration wificonfiguration1 = getWifiApConfiguration();
            parcel1.writeNoException();
            if(wificonfiguration1 != null) {
                parcel1.writeInt(flag);
                wificonfiguration1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            WifiConfiguration wificonfiguration;
            if(parcel.readInt() != 0)
                wificonfiguration = (WifiConfiguration)WifiConfiguration.CREATOR.createFromParcel(parcel);
            else
                wificonfiguration = null;
            setWifiApConfiguration(wificonfiguration);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            startWifi();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            stopWifi();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            addToBlacklist(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            clearBlacklist();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            Messenger messenger1 = getWifiServiceMessenger();
            parcel1.writeNoException();
            if(messenger1 != null) {
                parcel1.writeInt(flag);
                messenger1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            Messenger messenger = getWifiStateMachineMessenger();
            parcel1.writeNoException();
            if(messenger != null) {
                parcel1.writeInt(flag);
                messenger.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("android.net.wifi.IWifiManager");
            String s = getConfigFile();
            parcel1.writeNoException();
            parcel1.writeString(s);
            if(true) goto _L42; else goto _L41
_L41:
        }

        private static final String DESCRIPTOR = "android.net.wifi.IWifiManager";
        static final int TRANSACTION_acquireMulticastLock = 26;
        static final int TRANSACTION_acquireWifiLock = 21;
        static final int TRANSACTION_addOrUpdateNetwork = 2;
        static final int TRANSACTION_addToBlacklist = 34;
        static final int TRANSACTION_clearBlacklist = 35;
        static final int TRANSACTION_disableNetwork = 5;
        static final int TRANSACTION_disconnect = 9;
        static final int TRANSACTION_enableNetwork = 4;
        static final int TRANSACTION_getConfigFile = 38;
        static final int TRANSACTION_getConfiguredNetworks = 1;
        static final int TRANSACTION_getConnectionInfo = 12;
        static final int TRANSACTION_getDhcpInfo = 20;
        static final int TRANSACTION_getFrequencyBand = 17;
        static final int TRANSACTION_getScanResults = 8;
        static final int TRANSACTION_getWifiApConfiguration = 30;
        static final int TRANSACTION_getWifiApEnabledState = 29;
        static final int TRANSACTION_getWifiEnabledState = 14;
        static final int TRANSACTION_getWifiServiceMessenger = 36;
        static final int TRANSACTION_getWifiStateMachineMessenger = 37;
        static final int TRANSACTION_initializeMulticastFiltering = 24;
        static final int TRANSACTION_isDualBandSupported = 18;
        static final int TRANSACTION_isMulticastEnabled = 25;
        static final int TRANSACTION_pingSupplicant = 6;
        static final int TRANSACTION_reassociate = 11;
        static final int TRANSACTION_reconnect = 10;
        static final int TRANSACTION_releaseMulticastLock = 27;
        static final int TRANSACTION_releaseWifiLock = 23;
        static final int TRANSACTION_removeNetwork = 3;
        static final int TRANSACTION_saveConfiguration = 19;
        static final int TRANSACTION_setCountryCode = 15;
        static final int TRANSACTION_setFrequencyBand = 16;
        static final int TRANSACTION_setWifiApConfiguration = 31;
        static final int TRANSACTION_setWifiApEnabled = 28;
        static final int TRANSACTION_setWifiEnabled = 13;
        static final int TRANSACTION_startScan = 7;
        static final int TRANSACTION_startWifi = 32;
        static final int TRANSACTION_stopWifi = 33;
        static final int TRANSACTION_updateWifiLockWorkSource = 22;

        public Stub() {
            attachInterface(this, "android.net.wifi.IWifiManager");
        }
    }


    public abstract void acquireMulticastLock(IBinder ibinder, String s) throws RemoteException;

    public abstract boolean acquireWifiLock(IBinder ibinder, int i, String s, WorkSource worksource) throws RemoteException;

    public abstract int addOrUpdateNetwork(WifiConfiguration wificonfiguration) throws RemoteException;

    public abstract void addToBlacklist(String s) throws RemoteException;

    public abstract void clearBlacklist() throws RemoteException;

    public abstract boolean disableNetwork(int i) throws RemoteException;

    public abstract void disconnect() throws RemoteException;

    public abstract boolean enableNetwork(int i, boolean flag) throws RemoteException;

    public abstract String getConfigFile() throws RemoteException;

    public abstract List getConfiguredNetworks() throws RemoteException;

    public abstract WifiInfo getConnectionInfo() throws RemoteException;

    public abstract DhcpInfo getDhcpInfo() throws RemoteException;

    public abstract int getFrequencyBand() throws RemoteException;

    public abstract List getScanResults() throws RemoteException;

    public abstract WifiConfiguration getWifiApConfiguration() throws RemoteException;

    public abstract int getWifiApEnabledState() throws RemoteException;

    public abstract int getWifiEnabledState() throws RemoteException;

    public abstract Messenger getWifiServiceMessenger() throws RemoteException;

    public abstract Messenger getWifiStateMachineMessenger() throws RemoteException;

    public abstract void initializeMulticastFiltering() throws RemoteException;

    public abstract boolean isDualBandSupported() throws RemoteException;

    public abstract boolean isMulticastEnabled() throws RemoteException;

    public abstract boolean pingSupplicant() throws RemoteException;

    public abstract void reassociate() throws RemoteException;

    public abstract void reconnect() throws RemoteException;

    public abstract void releaseMulticastLock() throws RemoteException;

    public abstract boolean releaseWifiLock(IBinder ibinder) throws RemoteException;

    public abstract boolean removeNetwork(int i) throws RemoteException;

    public abstract boolean saveConfiguration() throws RemoteException;

    public abstract void setCountryCode(String s, boolean flag) throws RemoteException;

    public abstract void setFrequencyBand(int i, boolean flag) throws RemoteException;

    public abstract void setWifiApConfiguration(WifiConfiguration wificonfiguration) throws RemoteException;

    public abstract void setWifiApEnabled(WifiConfiguration wificonfiguration, boolean flag) throws RemoteException;

    public abstract boolean setWifiEnabled(boolean flag) throws RemoteException;

    public abstract void startScan(boolean flag) throws RemoteException;

    public abstract void startWifi() throws RemoteException;

    public abstract void stopWifi() throws RemoteException;

    public abstract void updateWifiLockWorkSource(IBinder ibinder, WorkSource worksource) throws RemoteException;
}
