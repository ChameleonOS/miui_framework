// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.app.PendingIntent;
import android.content.IntentFilter;
import android.os.*;

// Referenced classes of package android.nfc:
//            Tag, INfcAdapterExtras, INfcTag, TechListParcel, 
//            INdefPushCallback

public interface INfcAdapter
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INfcAdapter {
        private static class Proxy
            implements INfcAdapter {

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean disable(boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                if(!flag)
                    break MISSING_BLOCK_LABEL_73;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public boolean disableNdefPush() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                mRemote.transact(7, parcel, parcel1, 0);
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

            public void dispatch(Tag tag) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                if(tag == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                tag.writeToParcel(parcel, 0);
_L1:
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

            public boolean enable() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                mRemote.transact(5, parcel, parcel1, 0);
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

            public boolean enableNdefPush() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
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

            public String getInterfaceDescriptor() {
                return "android.nfc.INfcAdapter";
            }

            public INfcAdapterExtras getNfcAdapterExtrasInterface(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                INfcAdapterExtras infcadapterextras;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                infcadapterextras = INfcAdapterExtras.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return infcadapterextras;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public INfcTag getNfcTagInterface() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                INfcTag infctag;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                infctag = INfcTag.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return infctag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                mRemote.transact(3, parcel, parcel1, 0);
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

            public boolean isNdefPushEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
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

            public void setForegroundDispatch(PendingIntent pendingintent, IntentFilter aintentfilter[], TechListParcel techlistparcel) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                if(pendingintent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L3:
                parcel.writeTypedArray(aintentfilter, 0);
                if(techlistparcel == null)
                    break MISSING_BLOCK_LABEL_115;
                parcel.writeInt(1);
                techlistparcel.writeToParcel(parcel, 0);
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

            public void setNdefPushCallback(INdefPushCallback indefpushcallback) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                if(indefpushcallback == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = indefpushcallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setP2pModes(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcAdapter");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(12, parcel, parcel1, 0);
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


        public static INfcAdapter asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.nfc.INfcAdapter");
                if(iinterface != null && (iinterface instanceof INfcAdapter))
                    obj = (INfcAdapter)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INfcAdapter) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            IBinder ibinder;
            int k;
            boolean flag;
            ibinder = null;
            k = 0;
            flag = true;
            i;
            JVM INSTR lookupswitch 13: default 124
        //                       1: 147
        //                       2: 186
        //                       3: 229
        //                       4: 254
        //                       5: 307
        //                       6: 341
        //                       7: 375
        //                       8: 409
        //                       9: 443
        //                       10: 532
        //                       11: 556
        //                       12: 602
        //                       1598968902: 138;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L16:
            return flag;
_L14:
            parcel1.writeString("android.nfc.INfcAdapter");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            INfcTag infctag = getNfcTagInterface();
            parcel1.writeNoException();
            if(infctag != null)
                ibinder = infctag.asBinder();
            parcel1.writeStrongBinder(ibinder);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            INfcAdapterExtras infcadapterextras = getNfcAdapterExtrasInterface(parcel.readString());
            parcel1.writeNoException();
            if(infcadapterextras != null)
                ibinder = infcadapterextras.asBinder();
            parcel1.writeStrongBinder(ibinder);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            int l = getState();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            boolean flag5;
            boolean flag6;
            if(parcel.readInt() != 0)
                flag5 = flag;
            else
                flag5 = false;
            flag6 = disable(flag5);
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            boolean flag4 = enable();
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            boolean flag3 = enableNdefPush();
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            boolean flag2 = disableNdefPush();
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            boolean flag1 = isNdefPushEnabled();
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            PendingIntent pendingintent;
            IntentFilter aintentfilter[];
            TechListParcel techlistparcel;
            if(parcel.readInt() != 0)
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent = null;
            aintentfilter = (IntentFilter[])parcel.createTypedArray(IntentFilter.CREATOR);
            if(parcel.readInt() != 0)
                techlistparcel = (TechListParcel)TechListParcel.CREATOR.createFromParcel(parcel);
            else
                techlistparcel = null;
            setForegroundDispatch(pendingintent, aintentfilter, techlistparcel);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            setNdefPushCallback(INdefPushCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            Tag tag;
            if(parcel.readInt() != 0)
                tag = (Tag)Tag.CREATOR.createFromParcel(parcel);
            else
                tag = null;
            dispatch(tag);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.nfc.INfcAdapter");
            setP2pModes(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(true) goto _L16; else goto _L15
_L15:
        }

        private static final String DESCRIPTOR = "android.nfc.INfcAdapter";
        static final int TRANSACTION_disable = 4;
        static final int TRANSACTION_disableNdefPush = 7;
        static final int TRANSACTION_dispatch = 11;
        static final int TRANSACTION_enable = 5;
        static final int TRANSACTION_enableNdefPush = 6;
        static final int TRANSACTION_getNfcAdapterExtrasInterface = 2;
        static final int TRANSACTION_getNfcTagInterface = 1;
        static final int TRANSACTION_getState = 3;
        static final int TRANSACTION_isNdefPushEnabled = 8;
        static final int TRANSACTION_setForegroundDispatch = 9;
        static final int TRANSACTION_setNdefPushCallback = 10;
        static final int TRANSACTION_setP2pModes = 12;

        public Stub() {
            attachInterface(this, "android.nfc.INfcAdapter");
        }
    }


    public abstract boolean disable(boolean flag) throws RemoteException;

    public abstract boolean disableNdefPush() throws RemoteException;

    public abstract void dispatch(Tag tag) throws RemoteException;

    public abstract boolean enable() throws RemoteException;

    public abstract boolean enableNdefPush() throws RemoteException;

    public abstract INfcAdapterExtras getNfcAdapterExtrasInterface(String s) throws RemoteException;

    public abstract INfcTag getNfcTagInterface() throws RemoteException;

    public abstract int getState() throws RemoteException;

    public abstract boolean isNdefPushEnabled() throws RemoteException;

    public abstract void setForegroundDispatch(PendingIntent pendingintent, IntentFilter aintentfilter[], TechListParcel techlistparcel) throws RemoteException;

    public abstract void setNdefPushCallback(INdefPushCallback indefpushcallback) throws RemoteException;

    public abstract void setP2pModes(int i, int j) throws RemoteException;
}
