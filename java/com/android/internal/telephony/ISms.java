// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.PendingIntent;
import android.os.*;
import java.util.List;

// Referenced classes of package com.android.internal.telephony:
//            SmsRawData

public interface ISms
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISms {
        private static class Proxy
            implements ISms {

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean copyMessageToIccEf(int i, byte abyte0[], byte abyte1[]) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeInt(i);
                parcel.writeByteArray(abyte0);
                parcel.writeByteArray(abyte1);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public boolean disableCellBroadcast(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
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

            public boolean disableCellBroadcastRange(int i, int j) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k != 0)
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

            public boolean enableCellBroadcast(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public boolean enableCellBroadcastRange(int i, int j) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k != 0)
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

            public List getAllMessagesFromIccEf() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(SmsRawData.CREATOR);
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
                return "com.android.internal.telephony.ISms";
            }

            public void sendData(String s, String s1, int i, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
                parcel.writeByteArray(abyte0);
                if(pendingintent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L3:
                if(pendingintent1 == null)
                    break MISSING_BLOCK_LABEL_136;
                parcel.writeInt(1);
                pendingintent1.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void sendMultipartText(String s, String s1, List list, List list1, List list2) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeStringList(list);
                parcel.writeTypedList(list1);
                parcel.writeTypedList(list2);
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

            public void sendText(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                if(pendingintent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L3:
                if(pendingintent1 == null)
                    break MISSING_BLOCK_LABEL_129;
                parcel.writeInt(1);
                pendingintent1.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(5, parcel, parcel1, 0);
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

            public boolean updateMessageOnIccEf(int i, int j, byte abyte0[]) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("com.android.internal.telephony.ISms");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeByteArray(abyte0);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                if(k != 0)
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ISms asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.ISms");
                if(iinterface != null && (iinterface instanceof ISms))
                    obj = (ISms)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISms) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 11: default 100
        //                       1: 126
        //                       2: 154
        //                       3: 208
        //                       4: 262
        //                       5: 372
        //                       6: 474
        //                       7: 520
        //                       8: 566
        //                       9: 612
        //                       10: 662
        //                       1598968902: 114;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
            boolean flag1 = super.onTransact(i, parcel, parcel1, j);
_L14:
            return flag1;
_L12:
            parcel1.writeString("com.android.internal.telephony.ISms");
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            List list = getAllMessagesFromIccEf();
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            boolean flag6 = updateMessageOnIccEf(parcel.readInt(), parcel.readInt(), parcel.createByteArray());
            parcel1.writeNoException();
            int i2;
            if(flag6)
                i2 = 1;
            else
                i2 = 0;
            parcel1.writeInt(i2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            boolean flag5 = copyMessageToIccEf(parcel.readInt(), parcel.createByteArray(), parcel.createByteArray());
            parcel1.writeNoException();
            int l1;
            if(flag5)
                l1 = 1;
            else
                l1 = 0;
            parcel1.writeInt(l1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            String s3 = parcel.readString();
            String s4 = parcel.readString();
            int k1 = parcel.readInt();
            byte abyte0[] = parcel.createByteArray();
            PendingIntent pendingintent2;
            PendingIntent pendingintent3;
            if(parcel.readInt() != 0)
                pendingintent2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent2 = null;
            if(parcel.readInt() != 0)
                pendingintent3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent3 = null;
            sendData(s3, s4, k1, abyte0, pendingintent2, pendingintent3);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            String s = parcel.readString();
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            PendingIntent pendingintent;
            PendingIntent pendingintent1;
            if(parcel.readInt() != 0)
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent = null;
            if(parcel.readInt() != 0)
                pendingintent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent1 = null;
            sendText(s, s1, s2, pendingintent, pendingintent1);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            sendMultipartText(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.createTypedArrayList(PendingIntent.CREATOR), parcel.createTypedArrayList(PendingIntent.CREATOR));
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            boolean flag4 = enableCellBroadcast(parcel.readInt());
            parcel1.writeNoException();
            int j1;
            if(flag4)
                j1 = 1;
            else
                j1 = 0;
            parcel1.writeInt(j1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            boolean flag3 = disableCellBroadcast(parcel.readInt());
            parcel1.writeNoException();
            int i1;
            if(flag3)
                i1 = 1;
            else
                i1 = 0;
            parcel1.writeInt(i1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            boolean flag2 = enableCellBroadcastRange(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            int l;
            if(flag2)
                l = 1;
            else
                l = 0;
            parcel1.writeInt(l);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.telephony.ISms");
            boolean flag = disableCellBroadcastRange(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            int k;
            if(flag)
                k = 1;
            else
                k = 0;
            parcel1.writeInt(k);
            flag1 = true;
            if(true) goto _L14; else goto _L13
_L13:
        }

        private static final String DESCRIPTOR = "com.android.internal.telephony.ISms";
        static final int TRANSACTION_copyMessageToIccEf = 3;
        static final int TRANSACTION_disableCellBroadcast = 8;
        static final int TRANSACTION_disableCellBroadcastRange = 10;
        static final int TRANSACTION_enableCellBroadcast = 7;
        static final int TRANSACTION_enableCellBroadcastRange = 9;
        static final int TRANSACTION_getAllMessagesFromIccEf = 1;
        static final int TRANSACTION_sendData = 4;
        static final int TRANSACTION_sendMultipartText = 6;
        static final int TRANSACTION_sendText = 5;
        static final int TRANSACTION_updateMessageOnIccEf = 2;

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.ISms");
        }
    }


    public abstract boolean copyMessageToIccEf(int i, byte abyte0[], byte abyte1[]) throws RemoteException;

    public abstract boolean disableCellBroadcast(int i) throws RemoteException;

    public abstract boolean disableCellBroadcastRange(int i, int j) throws RemoteException;

    public abstract boolean enableCellBroadcast(int i) throws RemoteException;

    public abstract boolean enableCellBroadcastRange(int i, int j) throws RemoteException;

    public abstract List getAllMessagesFromIccEf() throws RemoteException;

    public abstract void sendData(String s, String s1, int i, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1) throws RemoteException;

    public abstract void sendMultipartText(String s, String s1, List list, List list1, List list2) throws RemoteException;

    public abstract void sendText(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1) throws RemoteException;

    public abstract boolean updateMessageOnIccEf(int i, int j, byte abyte0[]) throws RemoteException;
}
