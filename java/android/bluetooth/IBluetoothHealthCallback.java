// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.*;

// Referenced classes of package android.bluetooth:
//            BluetoothHealthAppConfiguration, BluetoothDevice

public interface IBluetoothHealthCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBluetoothHealthCallback {
        private static class Proxy
            implements IBluetoothHealthCallback {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.bluetooth.IBluetoothHealthCallback";
            }

            public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHealthCallback");
                if(bluetoothhealthappconfiguration == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                bluetoothhealthappconfiguration.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public void onHealthChannelStateChange(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, BluetoothDevice bluetoothdevice, int i, int j, ParcelFileDescriptor parcelfiledescriptor, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.bluetooth.IBluetoothHealthCallback");
                if(bluetoothhealthappconfiguration == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bluetoothhealthappconfiguration.writeToParcel(parcel, 0);
_L5:
                if(bluetoothdevice == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                bluetoothdevice.writeToParcel(parcel, 0);
_L6:
                parcel.writeInt(i);
                parcel.writeInt(j);
                if(parcelfiledescriptor == null)
                    break MISSING_BLOCK_LABEL_155;
                parcel.writeInt(1);
                parcelfiledescriptor.writeToParcel(parcel, 0);
_L7:
                parcel.writeInt(k);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
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
                parcel.writeInt(0);
                  goto _L7
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IBluetoothHealthCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.bluetooth.IBluetoothHealthCallback");
                if(iinterface != null && (iinterface instanceof IBluetoothHealthCallback))
                    obj = (IBluetoothHealthCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBluetoothHealthCallback) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 3: default 36
        //                       1: 62
        //                       2: 115
        //                       1598968902: 50;
               goto _L1 _L2 _L3 _L4
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.bluetooth.IBluetoothHealthCallback");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.bluetooth.IBluetoothHealthCallback");
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration1;
            if(parcel.readInt() != 0)
                bluetoothhealthappconfiguration1 = (BluetoothHealthAppConfiguration)BluetoothHealthAppConfiguration.CREATOR.createFromParcel(parcel);
            else
                bluetoothhealthappconfiguration1 = null;
            onHealthAppConfigurationStatusChange(bluetoothhealthappconfiguration1, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.bluetooth.IBluetoothHealthCallback");
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration;
            BluetoothDevice bluetoothdevice;
            int k;
            int l;
            ParcelFileDescriptor parcelfiledescriptor;
            if(parcel.readInt() != 0)
                bluetoothhealthappconfiguration = (BluetoothHealthAppConfiguration)BluetoothHealthAppConfiguration.CREATOR.createFromParcel(parcel);
            else
                bluetoothhealthappconfiguration = null;
            if(parcel.readInt() != 0)
                bluetoothdevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(parcel);
            else
                bluetoothdevice = null;
            k = parcel.readInt();
            l = parcel.readInt();
            if(parcel.readInt() != 0)
                parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            else
                parcelfiledescriptor = null;
            onHealthChannelStateChange(bluetoothhealthappconfiguration, bluetoothdevice, k, l, parcelfiledescriptor, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothHealthCallback";
        static final int TRANSACTION_onHealthAppConfigurationStatusChange = 1;
        static final int TRANSACTION_onHealthChannelStateChange = 2;

        public Stub() {
            attachInterface(this, "android.bluetooth.IBluetoothHealthCallback");
        }
    }


    public abstract void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) throws RemoteException;

    public abstract void onHealthChannelStateChange(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, BluetoothDevice bluetoothdevice, int i, int j, ParcelFileDescriptor parcelfiledescriptor, int k) throws RemoteException;
}
