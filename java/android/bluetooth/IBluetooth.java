// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.*;
import java.util.List;

// Referenced classes of package android.bluetooth:
//            BluetoothDevice, IBluetoothStateChangeCallback, BluetoothHealthAppConfiguration, IBluetoothCallback, 
//            IBluetoothHealthCallback

public interface IBluetooth
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBluetooth {
        private static class Proxy
            implements IBluetooth {

            public int addRfcommServiceRecord(String s, ParcelUuid parceluuid, int i, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                if(parceluuid == null)
                    break MISSING_BLOCK_LABEL_95;
                parcel.writeInt(1);
                parceluuid.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(43, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean allowIncomingProfileConnect(BluetoothDevice bluetoothdevice, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
                  goto _L3
_L4:
                int i;
                int j;
                parcel.writeInt(i);
                mRemote.transact(45, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L6:
                i = 0;
                  goto _L4
_L3:
                if(!flag) goto _L6; else goto _L5
_L5:
                i = ((flag1) ? 1 : 0);
                  goto _L4
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean cancelBondProcess(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
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

            public boolean cancelDiscovery() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(15, parcel, parcel1, 0);
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

            public boolean cancelPairingUserInput(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(39, parcel, parcel1, 0);
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

            public boolean changeApplicationBluetoothState(boolean flag, IBluetoothStateChangeCallback ibluetoothstatechangecallback, IBinder ibinder) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(!flag) goto _L2; else goto _L1
_L1:
                int i = ((flag1) ? 1 : 0);
_L5:
                parcel.writeInt(i);
                if(ibluetoothstatechangecallback == null) goto _L4; else goto _L3
_L3:
                IBinder ibinder1 = ibluetoothstatechangecallback.asBinder();
_L6:
                int j;
                parcel.writeStrongBinder(ibinder1);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j == 0)
                    flag1 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag1;
_L2:
                i = 0;
                  goto _L5
_L4:
                ibinder1 = null;
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public boolean connectChannelToSink(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L3:
                if(bluetoothhealthappconfiguration == null)
                    break MISSING_BLOCK_LABEL_131;
                parcel.writeInt(1);
                bluetoothhealthappconfiguration.writeToParcel(parcel, 0);
_L4:
                int j;
                parcel.writeInt(i);
                mRemote.transact(66, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
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

            public boolean connectChannelToSource(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L3:
                if(bluetoothhealthappconfiguration == null)
                    break MISSING_BLOCK_LABEL_123;
                parcel.writeInt(1);
                bluetoothhealthappconfiguration.writeToParcel(parcel, 0);
_L4:
                int i;
                mRemote.transact(65, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
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

            public boolean connectHeadset(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(46, parcel, parcel1, 0);
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

            public boolean connectInputDevice(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(49, parcel, parcel1, 0);
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

            public boolean connectPanDevice(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(61, parcel, parcel1, 0);
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

            public boolean createBond(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(21, parcel, parcel1, 0);
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

            public boolean createBondOutOfBand(String s, byte abyte0[], byte abyte1[]) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                parcel.writeByteArray(abyte0);
                parcel.writeByteArray(abyte1);
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

            public boolean disable(boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(!flag)
                    break MISSING_BLOCK_LABEL_73;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public boolean disconnectChannel(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L3:
                if(bluetoothhealthappconfiguration == null)
                    break MISSING_BLOCK_LABEL_131;
                parcel.writeInt(1);
                bluetoothhealthappconfiguration.writeToParcel(parcel, 0);
_L4:
                int j;
                parcel.writeInt(i);
                mRemote.transact(67, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
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

            public boolean disconnectHeadset(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(47, parcel, parcel1, 0);
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

            public boolean disconnectInputDevice(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(50, parcel, parcel1, 0);
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

            public boolean disconnectPanDevice(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(62, parcel, parcel1, 0);
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

            public boolean enable() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
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

            public boolean enableNoAutoConnect() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
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

            public boolean fetchRemoteUuids(String s, ParcelUuid parceluuid, IBluetoothCallback ibluetoothcallback) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                if(parceluuid == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                parceluuid.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                if(ibluetoothcallback == null)
                    break MISSING_BLOCK_LABEL_133;
                ibinder = ibluetoothcallback.asBinder();
_L4:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(33, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
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

            public int getAdapterConnectionState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(18, parcel, parcel1, 0);
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

            public String getAddress() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(6, parcel, parcel1, 0);
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

            public int getBluetoothState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
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

            public int getBondState(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(26, parcel, parcel1, 0);
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

            public List getConnectedHealthDevices() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(69, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(BluetoothDevice.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getConnectedInputDevices() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(51, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(BluetoothDevice.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getConnectedPanDevices() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(59, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(BluetoothDevice.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getDiscoverableTimeout() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(12, parcel, parcel1, 0);
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

            public int getHealthDeviceConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(71, parcel, parcel1, 0);
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

            public List getHealthDevicesMatchingConnectionStates(int ai[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeIntArray(ai);
                mRemote.transact(70, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(BluetoothDevice.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getInputDeviceConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(53, parcel, parcel1, 0);
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

            public int getInputDevicePriority(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(55, parcel, parcel1, 0);
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

            public List getInputDevicesMatchingConnectionStates(int ai[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeIntArray(ai);
                mRemote.transact(52, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(BluetoothDevice.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.bluetooth.IBluetooth";
            }

            public ParcelFileDescriptor getMainChannelFd(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L5:
                if(bluetoothhealthappconfiguration == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                bluetoothhealthappconfiguration.writeToParcel(parcel, 0);
_L6:
                ParcelFileDescriptor parcelfiledescriptor;
                mRemote.transact(68, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_131;
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
_L7:
                parcel1.recycle();
                parcel.recycle();
                return parcelfiledescriptor;
_L2:
                parcel.writeInt(0);
                  goto _L5
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L4:
                parcel.writeInt(0);
                  goto _L6
                parcelfiledescriptor = null;
                  goto _L7
            }

            public String getName() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(7, parcel, parcel1, 0);
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

            public int getPanDeviceConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(58, parcel, parcel1, 0);
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

            public List getPanDevicesMatchingConnectionStates(int ai[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeIntArray(ai);
                mRemote.transact(60, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(BluetoothDevice.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getProfileConnectionState(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeInt(i);
                mRemote.transact(19, parcel, parcel1, 0);
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

            public String getRemoteAlias(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(29, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getRemoteClass(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(31, parcel, parcel1, 0);
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

            public String getRemoteName(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(28, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getRemoteServiceChannel(String s, ParcelUuid parceluuid) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                if(parceluuid == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                parceluuid.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(34, parcel, parcel1, 0);
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

            public ParcelUuid[] getRemoteUuids(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ParcelUuid aparceluuid[];
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(32, parcel, parcel1, 0);
                parcel1.readException();
                aparceluuid = (ParcelUuid[])parcel1.createTypedArray(ParcelUuid.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return aparceluuid;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getScanMode() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
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

            public boolean getTrustState(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
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

            public ParcelUuid[] getUuids() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ParcelUuid aparceluuid[];
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                aparceluuid = (ParcelUuid[])parcel1.createTypedArray(ParcelUuid.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return aparceluuid;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isBluetoothDock(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(42, parcel, parcel1, 0);
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

            public boolean isDiscovering() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
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

            public boolean isEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
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

            public boolean isTetheringOn() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(56, parcel, parcel1, 0);
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

            public String[] listBonds() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
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

            public boolean notifyIncomingConnection(String s, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                if(!flag)
                    break MISSING_BLOCK_LABEL_85;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(48, parcel, parcel1, 0);
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

            public byte[] readOutOfBandData() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                byte abyte0[];
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(17, parcel, parcel1, 0);
                parcel1.readException();
                abyte0 = parcel1.createByteArray();
                parcel1.recycle();
                parcel.recycle();
                return abyte0;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean registerAppConfiguration(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, IBluetoothHealthCallback ibluetoothhealthcallback) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothhealthappconfiguration == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bluetoothhealthappconfiguration.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                if(ibluetoothhealthcallback == null)
                    break MISSING_BLOCK_LABEL_125;
                ibinder = ibluetoothhealthcallback.asBinder();
_L4:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(63, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
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

            public boolean removeBond(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(24, parcel, parcel1, 0);
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

            public void removeServiceRecord(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeInt(i);
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

            public void sendConnectionStateChange(BluetoothDevice bluetoothdevice, int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_86;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(72, parcel, parcel1, 0);
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

            public void setBluetoothTethering(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(57, parcel, parcel1, 0);
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

            public boolean setDeviceOutOfBandData(String s, byte abyte0[], byte abyte1[]) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                parcel.writeByteArray(abyte0);
                parcel.writeByteArray(abyte1);
                mRemote.transact(27, parcel, parcel1, 0);
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

            public boolean setDiscoverableTimeout(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
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

            public boolean setInputDevicePriority(BluetoothDevice bluetoothdevice, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_88;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(54, parcel, parcel1, 0);
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

            public boolean setName(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(8, parcel, parcel1, 0);
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

            public boolean setPairingConfirmation(String s, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                if(!flag)
                    break MISSING_BLOCK_LABEL_85;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(37, parcel, parcel1, 0);
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

            public boolean setPasskey(String s, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(36, parcel, parcel1, 0);
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

            public boolean setPin(String s, byte abyte0[]) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                parcel.writeByteArray(abyte0);
                mRemote.transact(35, parcel, parcel1, 0);
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

            public boolean setRemoteAlias(String s, String s1) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(30, parcel, parcel1, 0);
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

            public boolean setRemoteOutOfBandData(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                mRemote.transact(38, parcel, parcel1, 0);
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

            public boolean setScanMode(int i, int j) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(11, parcel, parcel1, 0);
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

            public boolean setTrust(String s, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                parcel.writeString(s);
                if(!flag)
                    break MISSING_BLOCK_LABEL_85;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(40, parcel, parcel1, 0);
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

            public boolean startDiscovery() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                mRemote.transact(14, parcel, parcel1, 0);
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

            public boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetooth");
                if(bluetoothhealthappconfiguration == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothhealthappconfiguration.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(64, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IBluetooth asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.bluetooth.IBluetooth");
                if(iinterface != null && (iinterface instanceof IBluetooth))
                    obj = (IBluetooth)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBluetooth) (obj));
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
            JVM INSTR lookupswitch 73: default 600
        //                       1: 623
        //                       2: 657
        //                       3: 682
        //                       4: 716
        //                       5: 750
        //                       6: 803
        //                       7: 828
        //                       8: 853
        //                       9: 891
        //                       10: 918
        //                       11: 943
        //                       12: 985
        //                       13: 1010
        //                       14: 1048
        //                       15: 1082
        //                       16: 1116
        //                       17: 1150
        //                       18: 1175
        //                       19: 1200
        //                       20: 1229
        //                       21: 1293
        //                       22: 1331
        //                       23: 1377
        //                       24: 1415
        //                       25: 1453
        //                       26: 1478
        //                       27: 1507
        //                       28: 1553
        //                       29: 1582
        //                       30: 1611
        //                       31: 1653
        //                       32: 1682
        //                       33: 1713
        //                       34: 1791
        //                       35: 1853
        //                       36: 1895
        //                       37: 1937
        //                       38: 1998
        //                       39: 2036
        //                       40: 2074
        //                       41: 2135
        //                       42: 2173
        //                       43: 2211
        //                       44: 2281
        //                       45: 2302
        //                       46: 2384
        //                       47: 2422
        //                       48: 2460
        //                       49: 2521
        //                       50: 2584
        //                       51: 2647
        //                       52: 2672
        //                       53: 2701
        //                       54: 2755
        //                       55: 2822
        //                       56: 2876
        //                       57: 2910
        //                       58: 2946
        //                       59: 3000
        //                       60: 3025
        //                       61: 3054
        //                       62: 3117
        //                       63: 3180
        //                       64: 3250
        //                       65: 3313
        //                       66: 3405
        //                       67: 3501
        //                       68: 3597
        //                       69: 3701
        //                       70: 3726
        //                       71: 3755
        //                       72: 3809
        //                       1598968902: 614;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L76:
            return flag;
_L74:
            parcel1.writeString("android.bluetooth.IBluetooth");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag48 = isEnabled();
            parcel1.writeNoException();
            if(flag48)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            int l3 = getBluetoothState();
            parcel1.writeNoException();
            parcel1.writeInt(l3);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag47 = enable();
            parcel1.writeNoException();
            if(flag47)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag46 = enableNoAutoConnect();
            parcel1.writeNoException();
            if(flag46)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag44;
            boolean flag45;
            if(parcel.readInt() != 0)
                flag44 = flag;
            else
                flag44 = false;
            flag45 = disable(flag44);
            parcel1.writeNoException();
            if(flag45)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s9 = getAddress();
            parcel1.writeNoException();
            parcel1.writeString(s9);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s8 = getName();
            parcel1.writeNoException();
            parcel1.writeString(s8);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag43 = setName(parcel.readString());
            parcel1.writeNoException();
            if(flag43)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            ParcelUuid aparceluuid1[] = getUuids();
            parcel1.writeNoException();
            parcel1.writeTypedArray(aparceluuid1, flag);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            int k3 = getScanMode();
            parcel1.writeNoException();
            parcel1.writeInt(k3);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag42 = setScanMode(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(flag42)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            int j3 = getDiscoverableTimeout();
            parcel1.writeNoException();
            parcel1.writeInt(j3);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag41 = setDiscoverableTimeout(parcel.readInt());
            parcel1.writeNoException();
            if(flag41)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag40 = startDiscovery();
            parcel1.writeNoException();
            if(flag40)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag39 = cancelDiscovery();
            parcel1.writeNoException();
            if(flag39)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag38 = isDiscovering();
            parcel1.writeNoException();
            if(flag38)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            byte abyte0[] = readOutOfBandData();
            parcel1.writeNoException();
            parcel1.writeByteArray(abyte0);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            int i3 = getAdapterConnectionState();
            parcel1.writeNoException();
            parcel1.writeInt(i3);
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            int l2 = getProfileConnectionState(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(l2);
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag36;
            boolean flag37;
            if(parcel.readInt() != 0)
                flag36 = flag;
            else
                flag36 = false;
            flag37 = changeApplicationBluetoothState(flag36, IBluetoothStateChangeCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readStrongBinder());
            parcel1.writeNoException();
            if(flag37)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag35 = createBond(parcel.readString());
            parcel1.writeNoException();
            if(flag35)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag34 = createBondOutOfBand(parcel.readString(), parcel.createByteArray(), parcel.createByteArray());
            parcel1.writeNoException();
            if(flag34)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag33 = cancelBondProcess(parcel.readString());
            parcel1.writeNoException();
            if(flag33)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag32 = removeBond(parcel.readString());
            parcel1.writeNoException();
            if(flag32)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String as[] = listBonds();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            int k2 = getBondState(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k2);
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag31 = setDeviceOutOfBandData(parcel.readString(), parcel.createByteArray(), parcel.createByteArray());
            parcel1.writeNoException();
            if(flag31)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s7 = getRemoteName(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s7);
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s6 = getRemoteAlias(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s6);
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag30 = setRemoteAlias(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(flag30)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            int j2 = getRemoteClass(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(j2);
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            ParcelUuid aparceluuid[] = getRemoteUuids(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeTypedArray(aparceluuid, flag);
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s5 = parcel.readString();
            ParcelUuid parceluuid2;
            boolean flag29;
            if(parcel.readInt() != 0)
                parceluuid2 = (ParcelUuid)ParcelUuid.CREATOR.createFromParcel(parcel);
            else
                parceluuid2 = null;
            flag29 = fetchRemoteUuids(s5, parceluuid2, IBluetoothCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(flag29)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s4 = parcel.readString();
            ParcelUuid parceluuid1;
            int i2;
            if(parcel.readInt() != 0)
                parceluuid1 = (ParcelUuid)ParcelUuid.CREATOR.createFromParcel(parcel);
            else
                parceluuid1 = null;
            i2 = getRemoteServiceChannel(s4, parceluuid1);
            parcel1.writeNoException();
            parcel1.writeInt(i2);
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag28 = setPin(parcel.readString(), parcel.createByteArray());
            parcel1.writeNoException();
            if(flag28)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag27 = setPasskey(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            if(flag27)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s3 = parcel.readString();
            boolean flag25;
            boolean flag26;
            if(parcel.readInt() != 0)
                flag25 = flag;
            else
                flag25 = false;
            flag26 = setPairingConfirmation(s3, flag25);
            parcel1.writeNoException();
            if(flag26)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag24 = setRemoteOutOfBandData(parcel.readString());
            parcel1.writeNoException();
            if(flag24)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag23 = cancelPairingUserInput(parcel.readString());
            parcel1.writeNoException();
            if(flag23)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s2 = parcel.readString();
            boolean flag21;
            boolean flag22;
            if(parcel.readInt() != 0)
                flag21 = flag;
            else
                flag21 = false;
            flag22 = setTrust(s2, flag21);
            parcel1.writeNoException();
            if(flag22)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag20 = getTrustState(parcel.readString());
            parcel1.writeNoException();
            if(flag20)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L43:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag19 = isBluetoothDock(parcel.readString());
            parcel1.writeNoException();
            if(flag19)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L44:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s1 = parcel.readString();
            ParcelUuid parceluuid;
            int l1;
            if(parcel.readInt() != 0)
                parceluuid = (ParcelUuid)ParcelUuid.CREATOR.createFromParcel(parcel);
            else
                parceluuid = null;
            l1 = addRfcommServiceRecord(s1, parceluuid, parcel.readInt(), parcel.readStrongBinder());
            parcel1.writeNoException();
            parcel1.writeInt(l1);
            continue; /* Loop/switch isn't completed */
_L45:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            removeServiceRecord(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L46:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice14;
            boolean flag17;
            boolean flag18;
            if(parcel.readInt() != 0)
                bluetoothdevice14 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice14 = null;
            if(parcel.readInt() != 0)
                flag17 = flag;
            else
                flag17 = false;
            flag18 = allowIncomingProfileConnect(bluetoothdevice14, flag17);
            parcel1.writeNoException();
            if(flag18)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L47:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag16 = connectHeadset(parcel.readString());
            parcel1.writeNoException();
            if(flag16)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L48:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag15 = disconnectHeadset(parcel.readString());
            parcel1.writeNoException();
            if(flag15)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L49:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            String s = parcel.readString();
            boolean flag13;
            boolean flag14;
            if(parcel.readInt() != 0)
                flag13 = flag;
            else
                flag13 = false;
            flag14 = notifyIncomingConnection(s, flag13);
            parcel1.writeNoException();
            if(flag14)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L50:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice13;
            boolean flag12;
            if(parcel.readInt() != 0)
                bluetoothdevice13 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice13 = null;
            flag12 = connectInputDevice(bluetoothdevice13);
            parcel1.writeNoException();
            if(flag12)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L51:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice12;
            boolean flag11;
            if(parcel.readInt() != 0)
                bluetoothdevice12 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice12 = null;
            flag11 = disconnectInputDevice(bluetoothdevice12);
            parcel1.writeNoException();
            if(flag11)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L52:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            List list5 = getConnectedInputDevices();
            parcel1.writeNoException();
            parcel1.writeTypedList(list5);
            continue; /* Loop/switch isn't completed */
_L53:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            List list4 = getInputDevicesMatchingConnectionStates(parcel.createIntArray());
            parcel1.writeNoException();
            parcel1.writeTypedList(list4);
            continue; /* Loop/switch isn't completed */
_L54:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice11;
            int k1;
            if(parcel.readInt() != 0)
                bluetoothdevice11 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice11 = null;
            k1 = getInputDeviceConnectionState(bluetoothdevice11);
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            continue; /* Loop/switch isn't completed */
_L55:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice10;
            boolean flag10;
            if(parcel.readInt() != 0)
                bluetoothdevice10 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice10 = null;
            flag10 = setInputDevicePriority(bluetoothdevice10, parcel.readInt());
            parcel1.writeNoException();
            if(flag10)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L56:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice9;
            int j1;
            if(parcel.readInt() != 0)
                bluetoothdevice9 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice9 = null;
            j1 = getInputDevicePriority(bluetoothdevice9);
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L57:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag9 = isTetheringOn();
            parcel1.writeNoException();
            if(flag9)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L58:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            boolean flag8;
            if(parcel.readInt() != 0)
                flag8 = flag;
            else
                flag8 = false;
            setBluetoothTethering(flag8);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L59:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice8;
            int i1;
            if(parcel.readInt() != 0)
                bluetoothdevice8 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice8 = null;
            i1 = getPanDeviceConnectionState(bluetoothdevice8);
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L60:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            List list3 = getConnectedPanDevices();
            parcel1.writeNoException();
            parcel1.writeTypedList(list3);
            continue; /* Loop/switch isn't completed */
_L61:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            List list2 = getPanDevicesMatchingConnectionStates(parcel.createIntArray());
            parcel1.writeNoException();
            parcel1.writeTypedList(list2);
            continue; /* Loop/switch isn't completed */
_L62:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice7;
            boolean flag7;
            if(parcel.readInt() != 0)
                bluetoothdevice7 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice7 = null;
            flag7 = connectPanDevice(bluetoothdevice7);
            parcel1.writeNoException();
            if(flag7)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L63:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice6;
            boolean flag6;
            if(parcel.readInt() != 0)
                bluetoothdevice6 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice6 = null;
            flag6 = disconnectPanDevice(bluetoothdevice6);
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L64:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration5;
            boolean flag5;
            if(parcel.readInt() != 0)
                bluetoothhealthappconfiguration5 = (BluetoothHealthAppConfiguration)BluetoothHealthAppConfiguration.CREATOR.createFromParcel(parcel);
            else
                bluetoothhealthappconfiguration5 = null;
            flag5 = registerAppConfiguration(bluetoothhealthappconfiguration5, IBluetoothHealthCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(flag5)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L65:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration4;
            boolean flag4;
            if(parcel.readInt() != 0)
                bluetoothhealthappconfiguration4 = (BluetoothHealthAppConfiguration)BluetoothHealthAppConfiguration.CREATOR.createFromParcel(parcel);
            else
                bluetoothhealthappconfiguration4 = null;
            flag4 = unregisterAppConfiguration(bluetoothhealthappconfiguration4);
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L66:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice5;
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration3;
            boolean flag3;
            if(parcel.readInt() != 0)
                bluetoothdevice5 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice5 = null;
            if(parcel.readInt() != 0)
                bluetoothhealthappconfiguration3 = (BluetoothHealthAppConfiguration)BluetoothHealthAppConfiguration.CREATOR.createFromParcel(parcel);
            else
                bluetoothhealthappconfiguration3 = null;
            flag3 = connectChannelToSource(bluetoothdevice5, bluetoothhealthappconfiguration3);
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L67:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice4;
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration2;
            boolean flag2;
            if(parcel.readInt() != 0)
                bluetoothdevice4 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice4 = null;
            if(parcel.readInt() != 0)
                bluetoothhealthappconfiguration2 = (BluetoothHealthAppConfiguration)BluetoothHealthAppConfiguration.CREATOR.createFromParcel(parcel);
            else
                bluetoothhealthappconfiguration2 = null;
            flag2 = connectChannelToSink(bluetoothdevice4, bluetoothhealthappconfiguration2, parcel.readInt());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L68:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice3;
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration1;
            boolean flag1;
            if(parcel.readInt() != 0)
                bluetoothdevice3 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice3 = null;
            if(parcel.readInt() != 0)
                bluetoothhealthappconfiguration1 = (BluetoothHealthAppConfiguration)BluetoothHealthAppConfiguration.CREATOR.createFromParcel(parcel);
            else
                bluetoothhealthappconfiguration1 = null;
            flag1 = disconnectChannel(bluetoothdevice3, bluetoothhealthappconfiguration1, parcel.readInt());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L69:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice2;
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration;
            ParcelFileDescriptor parcelfiledescriptor;
            if(parcel.readInt() != 0)
                bluetoothdevice2 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice2 = null;
            if(parcel.readInt() != 0)
                bluetoothhealthappconfiguration = (BluetoothHealthAppConfiguration)BluetoothHealthAppConfiguration.CREATOR.createFromParcel(parcel);
            else
                bluetoothhealthappconfiguration = null;
            parcelfiledescriptor = getMainChannelFd(bluetoothdevice2, bluetoothhealthappconfiguration);
            parcel1.writeNoException();
            if(parcelfiledescriptor != null) {
                parcel1.writeInt(flag);
                parcelfiledescriptor.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L70:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            List list1 = getConnectedHealthDevices();
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            continue; /* Loop/switch isn't completed */
_L71:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            List list = getHealthDevicesMatchingConnectionStates(parcel.createIntArray());
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L72:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice1;
            int l;
            if(parcel.readInt() != 0)
                bluetoothdevice1 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice1 = null;
            l = getHealthDeviceConnectionState(bluetoothdevice1);
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L73:
            parcel.enforceInterface("android.bluetooth.IBluetooth");
            BluetoothDevice bluetoothdevice;
            if(parcel.readInt() != 0)
                bluetoothdevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice = null;
            sendConnectionStateChange(bluetoothdevice, parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(true) goto _L76; else goto _L75
_L75:
        }

        private static final String DESCRIPTOR = "android.bluetooth.IBluetooth";
        static final int TRANSACTION_addRfcommServiceRecord = 43;
        static final int TRANSACTION_allowIncomingProfileConnect = 45;
        static final int TRANSACTION_cancelBondProcess = 23;
        static final int TRANSACTION_cancelDiscovery = 15;
        static final int TRANSACTION_cancelPairingUserInput = 39;
        static final int TRANSACTION_changeApplicationBluetoothState = 20;
        static final int TRANSACTION_connectChannelToSink = 66;
        static final int TRANSACTION_connectChannelToSource = 65;
        static final int TRANSACTION_connectHeadset = 46;
        static final int TRANSACTION_connectInputDevice = 49;
        static final int TRANSACTION_connectPanDevice = 61;
        static final int TRANSACTION_createBond = 21;
        static final int TRANSACTION_createBondOutOfBand = 22;
        static final int TRANSACTION_disable = 5;
        static final int TRANSACTION_disconnectChannel = 67;
        static final int TRANSACTION_disconnectHeadset = 47;
        static final int TRANSACTION_disconnectInputDevice = 50;
        static final int TRANSACTION_disconnectPanDevice = 62;
        static final int TRANSACTION_enable = 3;
        static final int TRANSACTION_enableNoAutoConnect = 4;
        static final int TRANSACTION_fetchRemoteUuids = 33;
        static final int TRANSACTION_getAdapterConnectionState = 18;
        static final int TRANSACTION_getAddress = 6;
        static final int TRANSACTION_getBluetoothState = 2;
        static final int TRANSACTION_getBondState = 26;
        static final int TRANSACTION_getConnectedHealthDevices = 69;
        static final int TRANSACTION_getConnectedInputDevices = 51;
        static final int TRANSACTION_getConnectedPanDevices = 59;
        static final int TRANSACTION_getDiscoverableTimeout = 12;
        static final int TRANSACTION_getHealthDeviceConnectionState = 71;
        static final int TRANSACTION_getHealthDevicesMatchingConnectionStates = 70;
        static final int TRANSACTION_getInputDeviceConnectionState = 53;
        static final int TRANSACTION_getInputDevicePriority = 55;
        static final int TRANSACTION_getInputDevicesMatchingConnectionStates = 52;
        static final int TRANSACTION_getMainChannelFd = 68;
        static final int TRANSACTION_getName = 7;
        static final int TRANSACTION_getPanDeviceConnectionState = 58;
        static final int TRANSACTION_getPanDevicesMatchingConnectionStates = 60;
        static final int TRANSACTION_getProfileConnectionState = 19;
        static final int TRANSACTION_getRemoteAlias = 29;
        static final int TRANSACTION_getRemoteClass = 31;
        static final int TRANSACTION_getRemoteName = 28;
        static final int TRANSACTION_getRemoteServiceChannel = 34;
        static final int TRANSACTION_getRemoteUuids = 32;
        static final int TRANSACTION_getScanMode = 10;
        static final int TRANSACTION_getTrustState = 41;
        static final int TRANSACTION_getUuids = 9;
        static final int TRANSACTION_isBluetoothDock = 42;
        static final int TRANSACTION_isDiscovering = 16;
        static final int TRANSACTION_isEnabled = 1;
        static final int TRANSACTION_isTetheringOn = 56;
        static final int TRANSACTION_listBonds = 25;
        static final int TRANSACTION_notifyIncomingConnection = 48;
        static final int TRANSACTION_readOutOfBandData = 17;
        static final int TRANSACTION_registerAppConfiguration = 63;
        static final int TRANSACTION_removeBond = 24;
        static final int TRANSACTION_removeServiceRecord = 44;
        static final int TRANSACTION_sendConnectionStateChange = 72;
        static final int TRANSACTION_setBluetoothTethering = 57;
        static final int TRANSACTION_setDeviceOutOfBandData = 27;
        static final int TRANSACTION_setDiscoverableTimeout = 13;
        static final int TRANSACTION_setInputDevicePriority = 54;
        static final int TRANSACTION_setName = 8;
        static final int TRANSACTION_setPairingConfirmation = 37;
        static final int TRANSACTION_setPasskey = 36;
        static final int TRANSACTION_setPin = 35;
        static final int TRANSACTION_setRemoteAlias = 30;
        static final int TRANSACTION_setRemoteOutOfBandData = 38;
        static final int TRANSACTION_setScanMode = 11;
        static final int TRANSACTION_setTrust = 40;
        static final int TRANSACTION_startDiscovery = 14;
        static final int TRANSACTION_unregisterAppConfiguration = 64;

        public Stub() {
            attachInterface(this, "android.bluetooth.IBluetooth");
        }
    }


    public abstract int addRfcommServiceRecord(String s, ParcelUuid parceluuid, int i, IBinder ibinder) throws RemoteException;

    public abstract boolean allowIncomingProfileConnect(BluetoothDevice bluetoothdevice, boolean flag) throws RemoteException;

    public abstract boolean cancelBondProcess(String s) throws RemoteException;

    public abstract boolean cancelDiscovery() throws RemoteException;

    public abstract boolean cancelPairingUserInput(String s) throws RemoteException;

    public abstract boolean changeApplicationBluetoothState(boolean flag, IBluetoothStateChangeCallback ibluetoothstatechangecallback, IBinder ibinder) throws RemoteException;

    public abstract boolean connectChannelToSink(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) throws RemoteException;

    public abstract boolean connectChannelToSource(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) throws RemoteException;

    public abstract boolean connectHeadset(String s) throws RemoteException;

    public abstract boolean connectInputDevice(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean connectPanDevice(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean createBond(String s) throws RemoteException;

    public abstract boolean createBondOutOfBand(String s, byte abyte0[], byte abyte1[]) throws RemoteException;

    public abstract boolean disable(boolean flag) throws RemoteException;

    public abstract boolean disconnectChannel(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) throws RemoteException;

    public abstract boolean disconnectHeadset(String s) throws RemoteException;

    public abstract boolean disconnectInputDevice(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean disconnectPanDevice(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean enable() throws RemoteException;

    public abstract boolean enableNoAutoConnect() throws RemoteException;

    public abstract boolean fetchRemoteUuids(String s, ParcelUuid parceluuid, IBluetoothCallback ibluetoothcallback) throws RemoteException;

    public abstract int getAdapterConnectionState() throws RemoteException;

    public abstract String getAddress() throws RemoteException;

    public abstract int getBluetoothState() throws RemoteException;

    public abstract int getBondState(String s) throws RemoteException;

    public abstract List getConnectedHealthDevices() throws RemoteException;

    public abstract List getConnectedInputDevices() throws RemoteException;

    public abstract List getConnectedPanDevices() throws RemoteException;

    public abstract int getDiscoverableTimeout() throws RemoteException;

    public abstract int getHealthDeviceConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract List getHealthDevicesMatchingConnectionStates(int ai[]) throws RemoteException;

    public abstract int getInputDeviceConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract int getInputDevicePriority(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract List getInputDevicesMatchingConnectionStates(int ai[]) throws RemoteException;

    public abstract ParcelFileDescriptor getMainChannelFd(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) throws RemoteException;

    public abstract String getName() throws RemoteException;

    public abstract int getPanDeviceConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract List getPanDevicesMatchingConnectionStates(int ai[]) throws RemoteException;

    public abstract int getProfileConnectionState(int i) throws RemoteException;

    public abstract String getRemoteAlias(String s) throws RemoteException;

    public abstract int getRemoteClass(String s) throws RemoteException;

    public abstract String getRemoteName(String s) throws RemoteException;

    public abstract int getRemoteServiceChannel(String s, ParcelUuid parceluuid) throws RemoteException;

    public abstract ParcelUuid[] getRemoteUuids(String s) throws RemoteException;

    public abstract int getScanMode() throws RemoteException;

    public abstract boolean getTrustState(String s) throws RemoteException;

    public abstract ParcelUuid[] getUuids() throws RemoteException;

    public abstract boolean isBluetoothDock(String s) throws RemoteException;

    public abstract boolean isDiscovering() throws RemoteException;

    public abstract boolean isEnabled() throws RemoteException;

    public abstract boolean isTetheringOn() throws RemoteException;

    public abstract String[] listBonds() throws RemoteException;

    public abstract boolean notifyIncomingConnection(String s, boolean flag) throws RemoteException;

    public abstract byte[] readOutOfBandData() throws RemoteException;

    public abstract boolean registerAppConfiguration(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, IBluetoothHealthCallback ibluetoothhealthcallback) throws RemoteException;

    public abstract boolean removeBond(String s) throws RemoteException;

    public abstract void removeServiceRecord(int i) throws RemoteException;

    public abstract void sendConnectionStateChange(BluetoothDevice bluetoothdevice, int i, int j, int k) throws RemoteException;

    public abstract void setBluetoothTethering(boolean flag) throws RemoteException;

    public abstract boolean setDeviceOutOfBandData(String s, byte abyte0[], byte abyte1[]) throws RemoteException;

    public abstract boolean setDiscoverableTimeout(int i) throws RemoteException;

    public abstract boolean setInputDevicePriority(BluetoothDevice bluetoothdevice, int i) throws RemoteException;

    public abstract boolean setName(String s) throws RemoteException;

    public abstract boolean setPairingConfirmation(String s, boolean flag) throws RemoteException;

    public abstract boolean setPasskey(String s, int i) throws RemoteException;

    public abstract boolean setPin(String s, byte abyte0[]) throws RemoteException;

    public abstract boolean setRemoteAlias(String s, String s1) throws RemoteException;

    public abstract boolean setRemoteOutOfBandData(String s) throws RemoteException;

    public abstract boolean setScanMode(int i, int j) throws RemoteException;

    public abstract boolean setTrust(String s, boolean flag) throws RemoteException;

    public abstract boolean startDiscovery() throws RemoteException;

    public abstract boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) throws RemoteException;
}
