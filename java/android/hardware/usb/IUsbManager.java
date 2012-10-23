// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.usb;

import android.app.PendingIntent;
import android.os.*;

// Referenced classes of package android.hardware.usb:
//            UsbAccessory, UsbDevice

public interface IUsbManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IUsbManager {
        private static class Proxy
            implements IUsbManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public void clearDefaults(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                parcel.writeString(s);
                mRemote.transact(14, parcel, parcel1, 0);
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

            public UsbAccessory getCurrentAccessory() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                UsbAccessory usbaccessory = (UsbAccessory)UsbAccessory.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return usbaccessory;
_L2:
                usbaccessory = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getDeviceList(Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() != 0)
                    bundle.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.hardware.usb.IUsbManager";
            }

            public void grantAccessoryPermission(UsbAccessory usbaccessory, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbaccessory == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                usbaccessory.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(12, parcel, parcel1, 0);
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

            public void grantDevicePermission(UsbDevice usbdevice, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbdevice == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                usbdevice.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
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

            public boolean hasAccessoryPermission(UsbAccessory usbaccessory) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbaccessory == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                usbaccessory.writeToParcel(parcel, 0);
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

            public boolean hasDefaults(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                parcel.writeString(s);
                mRemote.transact(13, parcel, parcel1, 0);
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

            public boolean hasDevicePermission(UsbDevice usbdevice) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbdevice == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                usbdevice.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(7, parcel, parcel1, 0);
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

            public ParcelFileDescriptor openAccessory(UsbAccessory usbaccessory) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbaccessory == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                usbaccessory.writeToParcel(parcel, 0);
_L3:
                ParcelFileDescriptor parcelfiledescriptor;
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_100;
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

            public ParcelFileDescriptor openDevice(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ParcelFileDescriptor parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return parcelfiledescriptor;
_L2:
                parcelfiledescriptor = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void requestAccessoryPermission(UsbAccessory usbaccessory, String s, PendingIntent pendingintent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbaccessory == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                usbaccessory.writeToParcel(parcel, 0);
_L3:
                parcel.writeString(s);
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_114;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void requestDevicePermission(UsbDevice usbdevice, String s, PendingIntent pendingintent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbdevice == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                usbdevice.writeToParcel(parcel, 0);
_L3:
                parcel.writeString(s);
                if(pendingintent == null)
                    break MISSING_BLOCK_LABEL_114;
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void setAccessoryPackage(UsbAccessory usbaccessory, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbaccessory == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                usbaccessory.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public void setCurrentFunction(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
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

            public void setDevicePackage(UsbDevice usbdevice, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                if(usbdevice == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                usbdevice.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
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

            public void setMassStorageBackingFile(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.usb.IUsbManager");
                parcel.writeString(s);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IUsbManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.hardware.usb.IUsbManager");
                if(iinterface != null && (iinterface instanceof IUsbManager))
                    obj = (IUsbManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IUsbManager) (obj));
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
            JVM INSTR lookupswitch 17: default 152
        //                       1: 175
        //                       2: 230
        //                       3: 280
        //                       4: 326
        //                       5: 401
        //                       6: 451
        //                       7: 501
        //                       8: 564
        //                       9: 627
        //                       10: 710
        //                       11: 793
        //                       12: 843
        //                       13: 893
        //                       14: 931
        //                       15: 952
        //                       16: 996
        //                       1598968902: 166;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L20:
            return flag;
_L18:
            parcel1.writeString("android.hardware.usb.IUsbManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            Bundle bundle = new Bundle();
            getDeviceList(bundle);
            parcel1.writeNoException();
            if(bundle != null) {
                parcel1.writeInt(flag);
                bundle.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            ParcelFileDescriptor parcelfiledescriptor1 = openDevice(parcel.readString());
            parcel1.writeNoException();
            if(parcelfiledescriptor1 != null) {
                parcel1.writeInt(flag);
                parcelfiledescriptor1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbAccessory usbaccessory5 = getCurrentAccessory();
            parcel1.writeNoException();
            if(usbaccessory5 != null) {
                parcel1.writeInt(flag);
                usbaccessory5.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbAccessory usbaccessory4;
            ParcelFileDescriptor parcelfiledescriptor;
            if(parcel.readInt() != 0)
                usbaccessory4 = (UsbAccessory)UsbAccessory.CREATOR.createFromParcel(parcel);
            else
                usbaccessory4 = null;
            parcelfiledescriptor = openAccessory(usbaccessory4);
            parcel1.writeNoException();
            if(parcelfiledescriptor != null) {
                parcel1.writeInt(flag);
                parcelfiledescriptor.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbDevice usbdevice3;
            if(parcel.readInt() != 0)
                usbdevice3 = (UsbDevice)UsbDevice.CREATOR.createFromParcel(parcel);
            else
                usbdevice3 = null;
            setDevicePackage(usbdevice3, parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbAccessory usbaccessory3;
            if(parcel.readInt() != 0)
                usbaccessory3 = (UsbAccessory)UsbAccessory.CREATOR.createFromParcel(parcel);
            else
                usbaccessory3 = null;
            setAccessoryPackage(usbaccessory3, parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbDevice usbdevice2;
            boolean flag4;
            if(parcel.readInt() != 0)
                usbdevice2 = (UsbDevice)UsbDevice.CREATOR.createFromParcel(parcel);
            else
                usbdevice2 = null;
            flag4 = hasDevicePermission(usbdevice2);
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbAccessory usbaccessory2;
            boolean flag3;
            if(parcel.readInt() != 0)
                usbaccessory2 = (UsbAccessory)UsbAccessory.CREATOR.createFromParcel(parcel);
            else
                usbaccessory2 = null;
            flag3 = hasAccessoryPermission(usbaccessory2);
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbDevice usbdevice1;
            String s2;
            PendingIntent pendingintent1;
            if(parcel.readInt() != 0)
                usbdevice1 = (UsbDevice)UsbDevice.CREATOR.createFromParcel(parcel);
            else
                usbdevice1 = null;
            s2 = parcel.readString();
            if(parcel.readInt() != 0)
                pendingintent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent1 = null;
            requestDevicePermission(usbdevice1, s2, pendingintent1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbAccessory usbaccessory1;
            String s1;
            PendingIntent pendingintent;
            if(parcel.readInt() != 0)
                usbaccessory1 = (UsbAccessory)UsbAccessory.CREATOR.createFromParcel(parcel);
            else
                usbaccessory1 = null;
            s1 = parcel.readString();
            if(parcel.readInt() != 0)
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent = null;
            requestAccessoryPermission(usbaccessory1, s1, pendingintent);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbDevice usbdevice;
            if(parcel.readInt() != 0)
                usbdevice = (UsbDevice)UsbDevice.CREATOR.createFromParcel(parcel);
            else
                usbdevice = null;
            grantDevicePermission(usbdevice, parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            UsbAccessory usbaccessory;
            if(parcel.readInt() != 0)
                usbaccessory = (UsbAccessory)UsbAccessory.CREATOR.createFromParcel(parcel);
            else
                usbaccessory = null;
            grantAccessoryPermission(usbaccessory, parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            boolean flag2 = hasDefaults(parcel.readString());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            clearDefaults(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            String s = parcel.readString();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            setCurrentFunction(s, flag1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.hardware.usb.IUsbManager");
            setMassStorageBackingFile(parcel.readString());
            parcel1.writeNoException();
            if(true) goto _L20; else goto _L19
_L19:
        }

        private static final String DESCRIPTOR = "android.hardware.usb.IUsbManager";
        static final int TRANSACTION_clearDefaults = 14;
        static final int TRANSACTION_getCurrentAccessory = 3;
        static final int TRANSACTION_getDeviceList = 1;
        static final int TRANSACTION_grantAccessoryPermission = 12;
        static final int TRANSACTION_grantDevicePermission = 11;
        static final int TRANSACTION_hasAccessoryPermission = 8;
        static final int TRANSACTION_hasDefaults = 13;
        static final int TRANSACTION_hasDevicePermission = 7;
        static final int TRANSACTION_openAccessory = 4;
        static final int TRANSACTION_openDevice = 2;
        static final int TRANSACTION_requestAccessoryPermission = 10;
        static final int TRANSACTION_requestDevicePermission = 9;
        static final int TRANSACTION_setAccessoryPackage = 6;
        static final int TRANSACTION_setCurrentFunction = 15;
        static final int TRANSACTION_setDevicePackage = 5;
        static final int TRANSACTION_setMassStorageBackingFile = 16;

        public Stub() {
            attachInterface(this, "android.hardware.usb.IUsbManager");
        }
    }


    public abstract void clearDefaults(String s) throws RemoteException;

    public abstract UsbAccessory getCurrentAccessory() throws RemoteException;

    public abstract void getDeviceList(Bundle bundle) throws RemoteException;

    public abstract void grantAccessoryPermission(UsbAccessory usbaccessory, int i) throws RemoteException;

    public abstract void grantDevicePermission(UsbDevice usbdevice, int i) throws RemoteException;

    public abstract boolean hasAccessoryPermission(UsbAccessory usbaccessory) throws RemoteException;

    public abstract boolean hasDefaults(String s) throws RemoteException;

    public abstract boolean hasDevicePermission(UsbDevice usbdevice) throws RemoteException;

    public abstract ParcelFileDescriptor openAccessory(UsbAccessory usbaccessory) throws RemoteException;

    public abstract ParcelFileDescriptor openDevice(String s) throws RemoteException;

    public abstract void requestAccessoryPermission(UsbAccessory usbaccessory, String s, PendingIntent pendingintent) throws RemoteException;

    public abstract void requestDevicePermission(UsbDevice usbdevice, String s, PendingIntent pendingintent) throws RemoteException;

    public abstract void setAccessoryPackage(UsbAccessory usbaccessory, String s) throws RemoteException;

    public abstract void setCurrentFunction(String s, boolean flag) throws RemoteException;

    public abstract void setDevicePackage(UsbDevice usbdevice, String s) throws RemoteException;

    public abstract void setMassStorageBackingFile(String s) throws RemoteException;
}
