// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.os.*;

public interface INfcAdapterExtras
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INfcAdapterExtras {
        private static class Proxy
            implements INfcAdapterExtras {

            public IBinder asBinder() {
                return mRemote;
            }

            public void authenticate(String s, byte abyte0[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcAdapterExtras");
                parcel.writeString(s);
                parcel.writeByteArray(abyte0);
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

            public Bundle close(String s, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcAdapterExtras");
                parcel.writeString(s);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bundle;
_L2:
                bundle = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getCardEmulationRoute(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.nfc.INfcAdapterExtras");
                parcel.writeString(s);
                mRemote.transact(4, parcel, parcel1, 0);
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
                return "android.nfc.INfcAdapterExtras";
            }

            public Bundle open(String s, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcAdapterExtras");
                parcel.writeString(s);
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bundle;
_L2:
                bundle = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setCardEmulationRoute(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcAdapterExtras");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public Bundle transceive(String s, byte abyte0[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcAdapterExtras");
                parcel.writeString(s);
                parcel.writeByteArray(abyte0);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bundle;
_L2:
                bundle = null;
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


        public static INfcAdapterExtras asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.nfc.INfcAdapterExtras");
                if(iinterface != null && (iinterface instanceof INfcAdapterExtras))
                    obj = (INfcAdapterExtras)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INfcAdapterExtras) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 7: default 72
        //                       1: 95
        //                       2: 149
        //                       3: 203
        //                       4: 257
        //                       5: 286
        //                       6: 311
        //                       1598968902: 86;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L10:
            return flag;
_L8:
            parcel1.writeString("android.nfc.INfcAdapterExtras");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.nfc.INfcAdapterExtras");
            Bundle bundle2 = open(parcel.readString(), parcel.readStrongBinder());
            parcel1.writeNoException();
            if(bundle2 != null) {
                parcel1.writeInt(flag);
                bundle2.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.nfc.INfcAdapterExtras");
            Bundle bundle1 = close(parcel.readString(), parcel.readStrongBinder());
            parcel1.writeNoException();
            if(bundle1 != null) {
                parcel1.writeInt(flag);
                bundle1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.nfc.INfcAdapterExtras");
            Bundle bundle = transceive(parcel.readString(), parcel.createByteArray());
            parcel1.writeNoException();
            if(bundle != null) {
                parcel1.writeInt(flag);
                bundle.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.nfc.INfcAdapterExtras");
            int k = getCardEmulationRoute(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.nfc.INfcAdapterExtras");
            setCardEmulationRoute(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.nfc.INfcAdapterExtras");
            authenticate(parcel.readString(), parcel.createByteArray());
            parcel1.writeNoException();
            if(true) goto _L10; else goto _L9
_L9:
        }

        private static final String DESCRIPTOR = "android.nfc.INfcAdapterExtras";
        static final int TRANSACTION_authenticate = 6;
        static final int TRANSACTION_close = 2;
        static final int TRANSACTION_getCardEmulationRoute = 4;
        static final int TRANSACTION_open = 1;
        static final int TRANSACTION_setCardEmulationRoute = 5;
        static final int TRANSACTION_transceive = 3;

        public Stub() {
            attachInterface(this, "android.nfc.INfcAdapterExtras");
        }
    }


    public abstract void authenticate(String s, byte abyte0[]) throws RemoteException;

    public abstract Bundle close(String s, IBinder ibinder) throws RemoteException;

    public abstract int getCardEmulationRoute(String s) throws RemoteException;

    public abstract Bundle open(String s, IBinder ibinder) throws RemoteException;

    public abstract void setCardEmulationRoute(String s, int i) throws RemoteException;

    public abstract Bundle transceive(String s, byte abyte0[]) throws RemoteException;
}
