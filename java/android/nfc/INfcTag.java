// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.os.*;

// Referenced classes of package android.nfc:
//            NdefMessage, Tag, TransceiveResult

public interface INfcTag
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INfcTag {
        private static class Proxy
            implements INfcTag {

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean canMakeReadOnly(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(17, parcel, parcel1, 0);
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

            public int close(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public int connect(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return k;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int formatNdef(int i, byte abyte0[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                parcel.writeByteArray(abyte0);
                mRemote.transact(12, parcel, parcel1, 0);
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

            public boolean getExtendedLengthApdusSupported() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                mRemote.transact(19, parcel, parcel1, 0);
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
                return "android.nfc.INfcTag";
            }

            public int getMaxTransceiveLength(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(18, parcel, parcel1, 0);
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

            public int[] getTechList(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int ai[];
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                ai = parcel1.createIntArray();
                parcel1.recycle();
                parcel.recycle();
                return ai;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getTimeout(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public boolean isNdef(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public boolean isPresent(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public boolean ndefIsWritable(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
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

            public int ndefMakeReadOnly(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(10, parcel, parcel1, 0);
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

            public NdefMessage ndefRead(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
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

            public int ndefWrite(int i, NdefMessage ndefmessage) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                if(ndefmessage == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                ndefmessage.writeToParcel(parcel, 0);
_L1:
                int j;
                mRemote.transact(9, parcel, parcel1, 0);
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

            public int reconnect(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public Tag rediscover(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Tag tag = (Tag)Tag.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return tag;
_L2:
                tag = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void resetTimeouts() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcTag");
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

            public int setTimeout(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return k;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public TransceiveResult transceive(int i, byte abyte0[], boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.nfc.INfcTag");
                parcel.writeInt(i);
                parcel.writeByteArray(abyte0);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                TransceiveResult transceiveresult = (TransceiveResult)TransceiveResult.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return transceiveresult;
_L2:
                transceiveresult = null;
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


        public static INfcTag asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.nfc.INfcTag");
                if(iinterface != null && (iinterface instanceof INfcTag))
                    obj = (INfcTag)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INfcTag) (obj));
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
            JVM INSTR lookupswitch 20: default 176
        //                       1: 199
        //                       2: 228
        //                       3: 261
        //                       4: 290
        //                       5: 319
        //                       6: 357
        //                       7: 395
        //                       8: 476
        //                       9: 526
        //                       10: 588
        //                       11: 617
        //                       12: 655
        //                       13: 688
        //                       14: 738
        //                       15: 771
        //                       16: 800
        //                       17: 817
        //                       18: 855
        //                       19: 884
        //                       1598968902: 190;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L23:
            return flag;
_L21:
            parcel1.writeString("android.nfc.INfcTag");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.nfc.INfcTag");
            int j3 = close(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(j3);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.nfc.INfcTag");
            int i3 = connect(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(i3);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.nfc.INfcTag");
            int l2 = reconnect(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(l2);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.nfc.INfcTag");
            int ai[] = getTechList(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeIntArray(ai);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.nfc.INfcTag");
            boolean flag6 = isNdef(parcel.readInt());
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.nfc.INfcTag");
            boolean flag5 = isPresent(parcel.readInt());
            parcel1.writeNoException();
            if(flag5)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.nfc.INfcTag");
            int k2 = parcel.readInt();
            byte abyte0[] = parcel.createByteArray();
            boolean flag4;
            TransceiveResult transceiveresult;
            if(parcel.readInt() != 0)
                flag4 = flag;
            else
                flag4 = false;
            transceiveresult = transceive(k2, abyte0, flag4);
            parcel1.writeNoException();
            if(transceiveresult != null) {
                parcel1.writeInt(flag);
                transceiveresult.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.nfc.INfcTag");
            NdefMessage ndefmessage1 = ndefRead(parcel.readInt());
            parcel1.writeNoException();
            if(ndefmessage1 != null) {
                parcel1.writeInt(flag);
                ndefmessage1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.nfc.INfcTag");
            int i2 = parcel.readInt();
            NdefMessage ndefmessage;
            int j2;
            if(parcel.readInt() != 0)
                ndefmessage = (NdefMessage)NdefMessage.CREATOR.createFromParcel(parcel);
            else
                ndefmessage = null;
            j2 = ndefWrite(i2, ndefmessage);
            parcel1.writeNoException();
            parcel1.writeInt(j2);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.nfc.INfcTag");
            int l1 = ndefMakeReadOnly(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(l1);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.nfc.INfcTag");
            boolean flag3 = ndefIsWritable(parcel.readInt());
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.nfc.INfcTag");
            int k1 = formatNdef(parcel.readInt(), parcel.createByteArray());
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.nfc.INfcTag");
            Tag tag = rediscover(parcel.readInt());
            parcel1.writeNoException();
            if(tag != null) {
                parcel1.writeInt(flag);
                tag.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.nfc.INfcTag");
            int j1 = setTimeout(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.nfc.INfcTag");
            int i1 = getTimeout(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.nfc.INfcTag");
            resetTimeouts();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.nfc.INfcTag");
            boolean flag2 = canMakeReadOnly(parcel.readInt());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.nfc.INfcTag");
            int l = getMaxTransceiveLength(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.nfc.INfcTag");
            boolean flag1 = getExtendedLengthApdusSupported();
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L23; else goto _L22
_L22:
        }

        private static final String DESCRIPTOR = "android.nfc.INfcTag";
        static final int TRANSACTION_canMakeReadOnly = 17;
        static final int TRANSACTION_close = 1;
        static final int TRANSACTION_connect = 2;
        static final int TRANSACTION_formatNdef = 12;
        static final int TRANSACTION_getExtendedLengthApdusSupported = 19;
        static final int TRANSACTION_getMaxTransceiveLength = 18;
        static final int TRANSACTION_getTechList = 4;
        static final int TRANSACTION_getTimeout = 15;
        static final int TRANSACTION_isNdef = 5;
        static final int TRANSACTION_isPresent = 6;
        static final int TRANSACTION_ndefIsWritable = 11;
        static final int TRANSACTION_ndefMakeReadOnly = 10;
        static final int TRANSACTION_ndefRead = 8;
        static final int TRANSACTION_ndefWrite = 9;
        static final int TRANSACTION_reconnect = 3;
        static final int TRANSACTION_rediscover = 13;
        static final int TRANSACTION_resetTimeouts = 16;
        static final int TRANSACTION_setTimeout = 14;
        static final int TRANSACTION_transceive = 7;

        public Stub() {
            attachInterface(this, "android.nfc.INfcTag");
        }
    }


    public abstract boolean canMakeReadOnly(int i) throws RemoteException;

    public abstract int close(int i) throws RemoteException;

    public abstract int connect(int i, int j) throws RemoteException;

    public abstract int formatNdef(int i, byte abyte0[]) throws RemoteException;

    public abstract boolean getExtendedLengthApdusSupported() throws RemoteException;

    public abstract int getMaxTransceiveLength(int i) throws RemoteException;

    public abstract int[] getTechList(int i) throws RemoteException;

    public abstract int getTimeout(int i) throws RemoteException;

    public abstract boolean isNdef(int i) throws RemoteException;

    public abstract boolean isPresent(int i) throws RemoteException;

    public abstract boolean ndefIsWritable(int i) throws RemoteException;

    public abstract int ndefMakeReadOnly(int i) throws RemoteException;

    public abstract NdefMessage ndefRead(int i) throws RemoteException;

    public abstract int ndefWrite(int i, NdefMessage ndefmessage) throws RemoteException;

    public abstract int reconnect(int i) throws RemoteException;

    public abstract Tag rediscover(int i) throws RemoteException;

    public abstract void resetTimeouts() throws RemoteException;

    public abstract int setTimeout(int i, int j) throws RemoteException;

    public abstract TransceiveResult transceive(int i, byte abyte0[], boolean flag) throws RemoteException;
}
