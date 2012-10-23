// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.*;
import java.util.List;

// Referenced classes of package android.bluetooth:
//            BluetoothDevice

public interface IBluetoothA2dp
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBluetoothA2dp {
        private static class Proxy
            implements IBluetoothA2dp {

            public boolean allowIncomingConnect(BluetoothDevice bluetoothdevice, boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
                if(bluetoothdevice == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
                  goto _L3
_L4:
                int i;
                int j;
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
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

            public boolean connect(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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

            public boolean connectSinkInternal(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(11, parcel, parcel1, 0);
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
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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

            public boolean disconnectSinkInternal(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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

            public List getConnectedDevices() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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
                return "android.bluetooth.IBluetoothA2dp";
            }

            public int getPriority(BluetoothDevice bluetoothdevice) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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

            public boolean isA2dpPlaying(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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

            public boolean resumeSink(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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

            public boolean setPriority(BluetoothDevice bluetoothdevice, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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

            public boolean suspendSink(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothA2dp");
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


        public static IBluetoothA2dp asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.bluetooth.IBluetoothA2dp");
                if(iinterface != null && (iinterface instanceof IBluetoothA2dp))
                    obj = (IBluetoothA2dp)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBluetoothA2dp) (obj));
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
            JVM INSTR lookupswitch 14: default 128
        //                       1: 151
        //                       2: 214
        //                       3: 277
        //                       4: 302
        //                       5: 331
        //                       6: 385
        //                       7: 452
        //                       8: 506
        //                       9: 569
        //                       10: 632
        //                       11: 695
        //                       12: 758
        //                       13: 821
        //                       1598968902: 142;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L17:
            return flag;
_L15:
            parcel1.writeString("android.bluetooth.IBluetoothA2dp");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice10;
            boolean flag10;
            if(parcel.readInt() != 0)
                bluetoothdevice10 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice10 = null;
            flag10 = connect(bluetoothdevice10);
            parcel1.writeNoException();
            if(flag10)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice9;
            boolean flag9;
            if(parcel.readInt() != 0)
                bluetoothdevice9 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice9 = null;
            flag9 = disconnect(bluetoothdevice9);
            parcel1.writeNoException();
            if(flag9)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            List list1 = getConnectedDevices();
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            List list = getDevicesMatchingConnectionStates(parcel.createIntArray());
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice8;
            int i1;
            if(parcel.readInt() != 0)
                bluetoothdevice8 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice8 = null;
            i1 = getConnectionState(bluetoothdevice8);
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice7;
            boolean flag8;
            if(parcel.readInt() != 0)
                bluetoothdevice7 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice7 = null;
            flag8 = setPriority(bluetoothdevice7, parcel.readInt());
            parcel1.writeNoException();
            if(flag8)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice6;
            int l;
            if(parcel.readInt() != 0)
                bluetoothdevice6 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice6 = null;
            l = getPriority(bluetoothdevice6);
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice5;
            boolean flag7;
            if(parcel.readInt() != 0)
                bluetoothdevice5 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice5 = null;
            flag7 = isA2dpPlaying(bluetoothdevice5);
            parcel1.writeNoException();
            if(flag7)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice4;
            boolean flag6;
            if(parcel.readInt() != 0)
                bluetoothdevice4 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice4 = null;
            flag6 = suspendSink(bluetoothdevice4);
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice3;
            boolean flag5;
            if(parcel.readInt() != 0)
                bluetoothdevice3 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice3 = null;
            flag5 = resumeSink(bluetoothdevice3);
            parcel1.writeNoException();
            if(flag5)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice2;
            boolean flag4;
            if(parcel.readInt() != 0)
                bluetoothdevice2 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice2 = null;
            flag4 = connectSinkInternal(bluetoothdevice2);
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice1;
            boolean flag3;
            if(parcel.readInt() != 0)
                bluetoothdevice1 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice1 = null;
            flag3 = disconnectSinkInternal(bluetoothdevice1);
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.bluetooth.IBluetoothA2dp");
            BluetoothDevice bluetoothdevice;
            boolean flag1;
            boolean flag2;
            if(parcel.readInt() != 0)
                bluetoothdevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice = null;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            flag2 = allowIncomingConnect(bluetoothdevice, flag1);
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L17; else goto _L16
_L16:
        }

        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothA2dp";
        static final int TRANSACTION_allowIncomingConnect = 13;
        static final int TRANSACTION_connect = 1;
        static final int TRANSACTION_connectSinkInternal = 11;
        static final int TRANSACTION_disconnect = 2;
        static final int TRANSACTION_disconnectSinkInternal = 12;
        static final int TRANSACTION_getConnectedDevices = 3;
        static final int TRANSACTION_getConnectionState = 5;
        static final int TRANSACTION_getDevicesMatchingConnectionStates = 4;
        static final int TRANSACTION_getPriority = 7;
        static final int TRANSACTION_isA2dpPlaying = 8;
        static final int TRANSACTION_resumeSink = 10;
        static final int TRANSACTION_setPriority = 6;
        static final int TRANSACTION_suspendSink = 9;

        public Stub() {
            attachInterface(this, "android.bluetooth.IBluetoothA2dp");
        }
    }


    public abstract boolean allowIncomingConnect(BluetoothDevice bluetoothdevice, boolean flag) throws RemoteException;

    public abstract boolean connect(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean connectSinkInternal(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean disconnect(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean disconnectSinkInternal(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract List getConnectedDevices() throws RemoteException;

    public abstract int getConnectionState(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract List getDevicesMatchingConnectionStates(int ai[]) throws RemoteException;

    public abstract int getPriority(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean isA2dpPlaying(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean resumeSink(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract boolean setPriority(BluetoothDevice bluetoothdevice, int i) throws RemoteException;

    public abstract boolean suspendSink(BluetoothDevice bluetoothdevice) throws RemoteException;
}
