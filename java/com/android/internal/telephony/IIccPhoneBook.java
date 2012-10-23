// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import java.util.List;

// Referenced classes of package com.android.internal.telephony:
//            AdnRecord

public interface IIccPhoneBook
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IIccPhoneBook {
        private static class Proxy
            implements IIccPhoneBook {

            public IBinder asBinder() {
                return mRemote;
            }

            public int getAdnCapacity() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.IIccPhoneBook");
                mRemote.transact(6, parcel, parcel1, 0);
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

            public List getAdnRecordsInEf(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.android.internal.telephony.IIccPhoneBook");
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(AdnRecord.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int[] getAdnRecordsSize(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int ai[];
                parcel.writeInterfaceToken("com.android.internal.telephony.IIccPhoneBook");
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

            public int getFreeAdn() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.IIccPhoneBook");
                mRemote.transact(5, parcel, parcel1, 0);
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
                return "com.android.internal.telephony.IIccPhoneBook";
            }

            public boolean updateAdnRecordsInEfByIndex(int i, String s, String s1, int j, String s2) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("com.android.internal.telephony.IIccPhoneBook");
                parcel.writeInt(i);
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(j);
                parcel.writeString(s2);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public boolean updateAdnRecordsInEfBySearch(int i, String s, String s1, String s2, String s3, String s4) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.telephony.IIccPhoneBook");
                parcel.writeInt(i);
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                parcel.writeString(s3);
                parcel.writeString(s4);
                mRemote.transact(2, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IIccPhoneBook asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.IIccPhoneBook");
                if(iinterface != null && (iinterface instanceof IIccPhoneBook))
                    obj = (IIccPhoneBook)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IIccPhoneBook) (obj));
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
            JVM INSTR lookupswitch 7: default 72
        //                       1: 95
        //                       2: 124
        //                       3: 188
        //                       4: 242
        //                       5: 271
        //                       6: 296
        //                       1598968902: 86;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L10:
            return flag;
_L8:
            parcel1.writeString("com.android.internal.telephony.IIccPhoneBook");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.telephony.IIccPhoneBook");
            List list = getAdnRecordsInEf(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.telephony.IIccPhoneBook");
            boolean flag2 = updateAdnRecordsInEfBySearch(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            int j1;
            if(flag2)
                j1 = ((flag) ? 1 : 0);
            else
                j1 = 0;
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.telephony.IIccPhoneBook");
            boolean flag1 = updateAdnRecordsInEfByIndex(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.telephony.IIccPhoneBook");
            int ai[] = getAdnRecordsSize(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeIntArray(ai);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.telephony.IIccPhoneBook");
            int i1 = getFreeAdn();
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.telephony.IIccPhoneBook");
            int l = getAdnCapacity();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            if(true) goto _L10; else goto _L9
_L9:
        }

        private static final String DESCRIPTOR = "com.android.internal.telephony.IIccPhoneBook";
        static final int TRANSACTION_getAdnCapacity = 6;
        static final int TRANSACTION_getAdnRecordsInEf = 1;
        static final int TRANSACTION_getAdnRecordsSize = 4;
        static final int TRANSACTION_getFreeAdn = 5;
        static final int TRANSACTION_updateAdnRecordsInEfByIndex = 3;
        static final int TRANSACTION_updateAdnRecordsInEfBySearch = 2;

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.IIccPhoneBook");
        }
    }


    public abstract int getAdnCapacity() throws RemoteException;

    public abstract List getAdnRecordsInEf(int i) throws RemoteException;

    public abstract int[] getAdnRecordsSize(int i) throws RemoteException;

    public abstract int getFreeAdn() throws RemoteException;

    public abstract boolean updateAdnRecordsInEfByIndex(int i, String s, String s1, int j, String s2) throws RemoteException;

    public abstract boolean updateAdnRecordsInEfBySearch(int i, String s, String s1, String s2, String s3, String s4) throws RemoteException;
}
