// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.net.Uri;
import android.os.*;

// Referenced classes of package android.nfc:
//            NdefMessage

public interface INdefPushCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INdefPushCallback {
        private static class Proxy
            implements INdefPushCallback {

            public IBinder asBinder() {
                return mRemote;
            }

            public NdefMessage createMessage() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INdefPushCallback");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                NdefMessage ndefmessage = (NdefMessage)NdefMessage.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return ndefmessage;
_L2:
                ndefmessage = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.nfc.INdefPushCallback";
            }

            public Uri[] getUris() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                Uri auri[];
                parcel.writeInterfaceToken("android.nfc.INdefPushCallback");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                auri = (Uri[])parcel1.createTypedArray(Uri.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return auri;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onNdefPushComplete() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INdefPushCallback");
                mRemote.transact(3, parcel, parcel1, 0);
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


        public static INdefPushCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.nfc.INdefPushCallback");
                if(iinterface != null && (iinterface instanceof INdefPushCallback))
                    obj = (INdefPushCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INdefPushCallback) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 117
        //                       3: 144
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.nfc.INdefPushCallback");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.nfc.INdefPushCallback");
            NdefMessage ndefmessage = createMessage();
            parcel1.writeNoException();
            if(ndefmessage != null) {
                parcel1.writeInt(flag);
                ndefmessage.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.nfc.INdefPushCallback");
            Uri auri[] = getUris();
            parcel1.writeNoException();
            parcel1.writeTypedArray(auri, flag);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.nfc.INdefPushCallback");
            onNdefPushComplete();
            parcel1.writeNoException();
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.nfc.INdefPushCallback";
        static final int TRANSACTION_createMessage = 1;
        static final int TRANSACTION_getUris = 2;
        static final int TRANSACTION_onNdefPushComplete = 3;

        public Stub() {
            attachInterface(this, "android.nfc.INdefPushCallback");
        }
    }


    public abstract NdefMessage createMessage() throws RemoteException;

    public abstract Uri[] getUris() throws RemoteException;

    public abstract void onNdefPushComplete() throws RemoteException;
}
