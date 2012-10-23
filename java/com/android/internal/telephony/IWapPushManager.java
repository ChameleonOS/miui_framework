// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Intent;
import android.os.*;

public interface IWapPushManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWapPushManager {
        private static class Proxy
            implements IWapPushManager {

            public boolean addPackage(String s, String s1, String s2, String s3, int i, boolean flag, boolean flag1) throws RemoteException {
                boolean flag2;
                Parcel parcel;
                Parcel parcel1;
                flag2 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IWapPushManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                parcel.writeString(s3);
                parcel.writeInt(i);
                if(!flag) goto _L2; else goto _L1
_L1:
                int j = ((flag2) ? 1 : 0);
_L5:
                parcel.writeInt(j);
                if(!flag1) goto _L4; else goto _L3
_L3:
                int k = ((flag2) ? 1 : 0);
_L6:
                int l;
                parcel.writeInt(k);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                if(l == 0)
                    flag2 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag2;
_L2:
                j = 0;
                  goto _L5
_L4:
                k = 0;
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean deletePackage(String s, String s1, String s2, String s3) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.IWapPushManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                parcel.writeString(s3);
                mRemote.transact(4, parcel, parcel1, 0);
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
                return "com.android.internal.telephony.IWapPushManager";
            }

            public int processMessage(String s, String s1, Intent intent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IWapPushManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                if(intent == null)
                    break MISSING_BLOCK_LABEL_87;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean updatePackage(String s, String s1, String s2, String s3, int i, boolean flag, boolean flag1) throws RemoteException {
                boolean flag2;
                Parcel parcel;
                Parcel parcel1;
                flag2 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IWapPushManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                parcel.writeString(s3);
                parcel.writeInt(i);
                if(!flag) goto _L2; else goto _L1
_L1:
                int j = ((flag2) ? 1 : 0);
_L5:
                parcel.writeInt(j);
                if(!flag1) goto _L4; else goto _L3
_L3:
                int k = ((flag2) ? 1 : 0);
_L6:
                int l;
                parcel.writeInt(k);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                if(l == 0)
                    flag2 = false;
                parcel1.recycle();
                parcel.recycle();
                return flag2;
_L2:
                j = 0;
                  goto _L5
_L4:
                k = 0;
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IWapPushManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.IWapPushManager");
                if(iinterface != null && (iinterface instanceof IWapPushManager))
                    obj = (IWapPushManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWapPushManager) (obj));
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
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 149
        //                       3: 261
        //                       4: 373
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("com.android.internal.telephony.IWapPushManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.telephony.IWapPushManager");
            String s8 = parcel.readString();
            String s9 = parcel.readString();
            Intent intent;
            int j1;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            j1 = processMessage(s8, s9, intent);
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.telephony.IWapPushManager");
            String s4 = parcel.readString();
            String s5 = parcel.readString();
            String s6 = parcel.readString();
            String s7 = parcel.readString();
            int i1 = parcel.readInt();
            boolean flag5;
            boolean flag6;
            boolean flag7;
            if(parcel.readInt() != 0)
                flag5 = flag;
            else
                flag5 = false;
            if(parcel.readInt() != 0)
                flag6 = flag;
            else
                flag6 = false;
            flag7 = addPackage(s4, s5, s6, s7, i1, flag5, flag6);
            parcel1.writeNoException();
            if(flag7)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.telephony.IWapPushManager");
            String s = parcel.readString();
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            String s3 = parcel.readString();
            int l = parcel.readInt();
            boolean flag2;
            boolean flag3;
            boolean flag4;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            flag4 = updatePackage(s, s1, s2, s3, l, flag2, flag3);
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.telephony.IWapPushManager");
            boolean flag1 = deletePackage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "com.android.internal.telephony.IWapPushManager";
        static final int TRANSACTION_addPackage = 2;
        static final int TRANSACTION_deletePackage = 4;
        static final int TRANSACTION_processMessage = 1;
        static final int TRANSACTION_updatePackage = 3;

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.IWapPushManager");
        }
    }


    public abstract boolean addPackage(String s, String s1, String s2, String s3, int i, boolean flag, boolean flag1) throws RemoteException;

    public abstract boolean deletePackage(String s, String s1, String s2, String s3) throws RemoteException;

    public abstract int processMessage(String s, String s1, Intent intent) throws RemoteException;

    public abstract boolean updatePackage(String s, String s1, String s2, String s3, int i, boolean flag, boolean flag1) throws RemoteException;
}
