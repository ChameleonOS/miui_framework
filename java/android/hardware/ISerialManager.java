// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;

import android.os.*;

public interface ISerialManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISerialManager {
        private static class Proxy
            implements ISerialManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.hardware.ISerialManager";
            }

            public String[] getSerialPorts() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.hardware.ISerialManager");
                mRemote.transact(1, parcel, parcel1, 0);
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

            public ParcelFileDescriptor openSerialPort(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.hardware.ISerialManager");
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ISerialManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.hardware.ISerialManager");
                if(iinterface != null && (iinterface instanceof ISerialManager))
                    obj = (ISerialManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISerialManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 88
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.hardware.ISerialManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.hardware.ISerialManager");
            String as[] = getSerialPorts();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.hardware.ISerialManager");
            ParcelFileDescriptor parcelfiledescriptor = openSerialPort(parcel.readString());
            parcel1.writeNoException();
            if(parcelfiledescriptor != null) {
                parcel1.writeInt(flag);
                parcelfiledescriptor.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.hardware.ISerialManager";
        static final int TRANSACTION_getSerialPorts = 1;
        static final int TRANSACTION_openSerialPort = 2;

        public Stub() {
            attachInterface(this, "android.hardware.ISerialManager");
        }
    }


    public abstract String[] getSerialPorts() throws RemoteException;

    public abstract ParcelFileDescriptor openSerialPort(String s) throws RemoteException;
}
