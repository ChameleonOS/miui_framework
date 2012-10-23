// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.*;

// Referenced classes of package android.bluetooth:
//            BluetoothDevice

public interface IBluetoothPbap
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBluetoothPbap {
        private static class Proxy
            implements IBluetoothPbap {

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
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothPbap");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void disconnect() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothPbap");
                mRemote.transact(4, parcel, parcel1, 0);
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

            public BluetoothDevice getClient() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothPbap");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                BluetoothDevice bluetoothdevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bluetoothdevice;
_L2:
                bluetoothdevice = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.bluetooth.IBluetoothPbap";
            }

            public int getState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothPbap");
                mRemote.transact(1, parcel, parcel1, 0);
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

            public boolean isConnected(BluetoothDevice bluetoothdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothPbap");
                if(bluetoothdevice == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(5, parcel, parcel1, 0);
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


        public static IBluetoothPbap asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.bluetooth.IBluetoothPbap");
                if(iinterface != null && (iinterface instanceof IBluetoothPbap))
                    obj = (IBluetoothPbap)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBluetoothPbap) (obj));
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
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 112
        //                       3: 158
        //                       4: 221
        //                       5: 238
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.bluetooth.IBluetoothPbap");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.bluetooth.IBluetoothPbap");
            int l = getState();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.bluetooth.IBluetoothPbap");
            BluetoothDevice bluetoothdevice2 = getClient();
            parcel1.writeNoException();
            if(bluetoothdevice2 != null) {
                parcel1.writeInt(flag);
                bluetoothdevice2.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.bluetooth.IBluetoothPbap");
            BluetoothDevice bluetoothdevice1;
            boolean flag2;
            if(parcel.readInt() != 0)
                bluetoothdevice1 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice1 = null;
            flag2 = connect(bluetoothdevice1);
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.bluetooth.IBluetoothPbap");
            disconnect();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.bluetooth.IBluetoothPbap");
            BluetoothDevice bluetoothdevice;
            boolean flag1;
            if(parcel.readInt() != 0)
                bluetoothdevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice = null;
            flag1 = isConnected(bluetoothdevice);
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothPbap";
        static final int TRANSACTION_connect = 3;
        static final int TRANSACTION_disconnect = 4;
        static final int TRANSACTION_getClient = 2;
        static final int TRANSACTION_getState = 1;
        static final int TRANSACTION_isConnected = 5;

        public Stub() {
            attachInterface(this, "android.bluetooth.IBluetoothPbap");
        }
    }


    public abstract boolean connect(BluetoothDevice bluetoothdevice) throws RemoteException;

    public abstract void disconnect() throws RemoteException;

    public abstract BluetoothDevice getClient() throws RemoteException;

    public abstract int getState() throws RemoteException;

    public abstract boolean isConnected(BluetoothDevice bluetoothdevice) throws RemoteException;
}
