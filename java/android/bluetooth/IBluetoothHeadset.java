// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.*;
import java.util.List;

// Referenced classes of package android.bluetooth:
//            BluetoothDevice

public interface IBluetoothHeadset
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBluetoothHeadset {
        private static class Proxy
            implements IBluetoothHeadset {

            public boolean acceptIncomingConnect(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(13, parcel, parcel1, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean cancelConnectThread() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
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

            public boolean connect(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(1, parcel, parcel1, 0);
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

            public boolean connectHeadsetInternal(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(16, parcel, parcel1, 0);
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

            public boolean createIncomingConnect(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(12, parcel, parcel1, 0);
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

            public boolean disconnect(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(2, parcel, parcel1, 0);
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

            public boolean disconnectHeadsetInternal(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(17, parcel, parcel1, 0);
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

            public int getAudioState(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(19, parcel, parcel1, 0);
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

            public int getBatteryUsageHint(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(11, parcel, parcel1, 0);
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

            public List getConnectedDevices() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                mRemote.transact(3, parcel, parcel1, 0);
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

            public int getConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_64;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(5, parcel, parcel1, 0);
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

            public List getDevicesMatchingConnectionStates(int ai[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                parcel.writeIntArray(ai);
                mRemote.transact(4, parcel, parcel1, 0);
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
                return "android.bluetooth.IBluetoothHeadset";
            }

            public int getPriority(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(7, parcel, parcel1, 0);
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

            public boolean isAudioConnected(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(10, parcel, parcel1, 0);
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

            public boolean rejectIncomingConnect(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(14, parcel, parcel1, 0);
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

            public boolean setAudioState(BluetoothDevice bluetoothdevice, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_88;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(18, parcel, parcel1, 0);
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

            public boolean setPriority(BluetoothDevice bluetoothdevice, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_88;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public boolean startScoUsingVirtualVoiceCall(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(20, parcel, parcel1, 0);
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

            public boolean startVoiceRecognition(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(8, parcel, parcel1, 0);
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

            public boolean stopScoUsingVirtualVoiceCall(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(21, parcel, parcel1, 0);
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

            public boolean stopVoiceRecognition(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHeadset");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IBluetoothHeadset asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.bluetooth.IBluetoothHeadset");
                if(iinterface != null && (iinterface instanceof IBluetoothHeadset))
                    obj = (IBluetoothHeadset)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBluetoothHeadset) (obj));
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
            JVM INSTR lookupswitch 22: default 192
        //                       1: 215
        //                       2: 278
        //                       3: 341
        //                       4: 366
        //                       5: 395
        //                       6: 449
        //                       7: 516
        //                       8: 570
        //                       9: 633
        //                       10: 696
        //                       11: 759
        //                       12: 813
        //                       13: 876
        //                       14: 939
        //                       15: 1002
        //                       16: 1036
        //                       17: 1099
        //                       18: 1162
        //                       19: 1229
        //                       20: 1283
        //                       21: 1346
        //                       1598968902: 206;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L25:
            return flag;
_L23:
            parcel1.writeString("android.bluetooth.IBluetoothHeadset");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice17;
            boolean flag15;
            if(parcel.readInt() != 0)
                bluetoothdevice17 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice17 = null;
            flag15 = connect(bluetoothdevice17);
            parcel1.writeNoException();
            if(flag15)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice16;
            boolean flag14;
            if(parcel.readInt() != 0)
                bluetoothdevice16 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice16 = null;
            flag14 = disconnect(bluetoothdevice16);
            parcel1.writeNoException();
            if(flag14)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            List list1 = getConnectedDevices();
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            List list = getDevicesMatchingConnectionStates(parcel.createIntArray());
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice15;
            int k1;
            if(parcel.readInt() != 0)
                bluetoothdevice15 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice15 = null;
            k1 = getConnectionState(bluetoothdevice15);
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice14;
            boolean flag13;
            if(parcel.readInt() != 0)
                bluetoothdevice14 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice14 = null;
            flag13 = setPriority(bluetoothdevice14, parcel.readInt());
            parcel1.writeNoException();
            if(flag13)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice13;
            int j1;
            if(parcel.readInt() != 0)
                bluetoothdevice13 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice13 = null;
            j1 = getPriority(bluetoothdevice13);
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice12;
            boolean flag12;
            if(parcel.readInt() != 0)
                bluetoothdevice12 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice12 = null;
            flag12 = startVoiceRecognition(bluetoothdevice12);
            parcel1.writeNoException();
            if(flag12)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice11;
            boolean flag11;
            if(parcel.readInt() != 0)
                bluetoothdevice11 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice11 = null;
            flag11 = stopVoiceRecognition(bluetoothdevice11);
            parcel1.writeNoException();
            if(flag11)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice10;
            boolean flag10;
            if(parcel.readInt() != 0)
                bluetoothdevice10 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice10 = null;
            flag10 = isAudioConnected(bluetoothdevice10);
            parcel1.writeNoException();
            if(flag10)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice9;
            int i1;
            if(parcel.readInt() != 0)
                bluetoothdevice9 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice9 = null;
            i1 = getBatteryUsageHint(bluetoothdevice9);
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice8;
            boolean flag9;
            if(parcel.readInt() != 0)
                bluetoothdevice8 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice8 = null;
            flag9 = createIncomingConnect(bluetoothdevice8);
            parcel1.writeNoException();
            if(flag9)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice7;
            boolean flag8;
            if(parcel.readInt() != 0)
                bluetoothdevice7 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice7 = null;
            flag8 = acceptIncomingConnect(bluetoothdevice7);
            parcel1.writeNoException();
            if(flag8)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice6;
            boolean flag7;
            if(parcel.readInt() != 0)
                bluetoothdevice6 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice6 = null;
            flag7 = rejectIncomingConnect(bluetoothdevice6);
            parcel1.writeNoException();
            if(flag7)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            boolean flag6 = cancelConnectThread();
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice5;
            boolean flag5;
            if(parcel.readInt() != 0)
                bluetoothdevice5 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice5 = null;
            flag5 = connectHeadsetInternal(bluetoothdevice5);
            parcel1.writeNoException();
            if(flag5)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice4;
            boolean flag4;
            if(parcel.readInt() != 0)
                bluetoothdevice4 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice4 = null;
            flag4 = disconnectHeadsetInternal(bluetoothdevice4);
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice3;
            boolean flag3;
            if(parcel.readInt() != 0)
                bluetoothdevice3 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice3 = null;
            flag3 = setAudioState(bluetoothdevice3, parcel.readInt());
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice2;
            int l;
            if(parcel.readInt() != 0)
                bluetoothdevice2 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice2 = null;
            l = getAudioState(bluetoothdevice2);
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice1;
            boolean flag2;
            if(parcel.readInt() != 0)
                bluetoothdevice1 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice1 = null;
            flag2 = startScoUsingVirtualVoiceCall(bluetoothdevice1);
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.bluetooth.IBluetoothHeadset");
            BluetoothDevice bluetoothdevice;
            boolean flag1;
            if(parcel.readInt() != 0)
                bluetoothdevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice = null;
            flag1 = stopScoUsingVirtualVoiceCall(bluetoothdevice);
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L25; else goto _L24
_L24:
        }

        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothHeadset";
        static final int TRANSACTION_acceptIncomingConnect = 13;
        static final int TRANSACTION_cancelConnectThread = 15;
        static final int TRANSACTION_connect = 1;
        static final int TRANSACTION_connectHeadsetInternal = 16;
        static final int TRANSACTION_createIncomingConnect = 12;
        static final int TRANSACTION_disconnect = 2;
        static final int TRANSACTION_disconnectHeadsetInternal = 17;
        static final int TRANSACTION_getAudioState = 19;
        static final int TRANSACTION_getBatteryUsageHint = 11;
        static final int TRANSACTION_getConnectedDevices = 3;
        static final int TRANSACTION_getConnectionState = 5;
        static final int TRANSACTION_getDevicesMatchingConnectionStates = 4;
        static final int TRANSACTION_getPriority = 7;
        static final int TRANSACTION_isAudioConnected = 10;
        static final int TRANSACTION_rejectIncomingConnect = 14;
        static final int TRANSACTION_setAudioState = 18;
        static final int TRANSACTION_setPriority = 6;
        static final int TRANSACTION_startScoUsingVirtualVoiceCall = 20;
        static final int TRANSACTION_startVoiceRecognition = 8;
        static final int TRANSACTION_stopScoUsingVirtualVoiceCall = 21;
        static final int TRANSACTION_stopVoiceRecognition = 9;

        public Stub() {
            attachInterface(this, "android.bluetooth.IBluetoothHeadset");
        }
    }


    public abstract boolean acceptIncomingConnect(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean cancelConnectThread() throws RemoteException;

    public abstract boolean connect(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean connectHeadsetInternal(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean createIncomingConnect(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean disconnect(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean disconnectHeadsetInternal(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract int getAudioState(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract int getBatteryUsageHint(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract List getConnectedDevices() throws RemoteException;

    public abstract int getConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract List getDevicesMatchingConnectionStates(int ai[]) throws RemoteException;

    public abstract int getPriority(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean isAudioConnected(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean rejectIncomingConnect(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean setAudioState(BluetoothDevice bluetoothdevice, int i) throws RemoteException;

    public abstract boolean setPriority(BluetoothDevice bluetoothdevice, int i) throws RemoteException;

    public abstract boolean startScoUsingVirtualVoiceCall(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean startVoiceRecognition(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean stopScoUsingVirtualVoiceCall(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean stopVoiceRecognition(BluetoothDevice bluetoothdevice) throws RemoteException;
}
