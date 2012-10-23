// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;

public interface IPhoneSubInfo
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IPhoneSubInfo {
        private static class Proxy
            implements IPhoneSubInfo {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getCompleteVoiceMailNumber() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getDeviceId() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getDeviceSvn() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getIccSerialNumber() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.telephony.IPhoneSubInfo";
            }

            public String getIsimDomain() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getIsimImpi() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String[] getIsimImpu() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(13, parcel, parcel1, 0);
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

            public String getLine1AlphaTag() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getLine1Number() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getMsisdn() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getSubscriberId() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getVoiceMailAlphaTag() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getVoiceMailNumber() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneSubInfo");
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
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


        public static IPhoneSubInfo asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.IPhoneSubInfo");
                if(iinterface != null && (iinterface instanceof IPhoneSubInfo))
                    obj = (IPhoneSubInfo)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IPhoneSubInfo) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 14: default 128
        //                       1: 151
        //                       2: 176
        //                       3: 201
        //                       4: 226
        //                       5: 251
        //                       6: 276
        //                       7: 301
        //                       8: 326
        //                       9: 351
        //                       10: 376
        //                       11: 401
        //                       12: 426
        //                       13: 451
        //                       1598968902: 142;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L17:
            return flag;
_L15:
            parcel1.writeString("com.android.internal.telephony.IPhoneSubInfo");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s11 = getDeviceId();
            parcel1.writeNoException();
            parcel1.writeString(s11);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s10 = getDeviceSvn();
            parcel1.writeNoException();
            parcel1.writeString(s10);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s9 = getSubscriberId();
            parcel1.writeNoException();
            parcel1.writeString(s9);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s8 = getIccSerialNumber();
            parcel1.writeNoException();
            parcel1.writeString(s8);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s7 = getLine1Number();
            parcel1.writeNoException();
            parcel1.writeString(s7);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s6 = getLine1AlphaTag();
            parcel1.writeNoException();
            parcel1.writeString(s6);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s5 = getMsisdn();
            parcel1.writeNoException();
            parcel1.writeString(s5);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s4 = getVoiceMailNumber();
            parcel1.writeNoException();
            parcel1.writeString(s4);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s3 = getCompleteVoiceMailNumber();
            parcel1.writeNoException();
            parcel1.writeString(s3);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s2 = getVoiceMailAlphaTag();
            parcel1.writeNoException();
            parcel1.writeString(s2);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s1 = getIsimImpi();
            parcel1.writeNoException();
            parcel1.writeString(s1);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String s = getIsimDomain();
            parcel1.writeNoException();
            parcel1.writeString(s);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneSubInfo");
            String as[] = getIsimImpu();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            if(true) goto _L17; else goto _L16
_L16:
        }

        private static final String DESCRIPTOR = "com.android.internal.telephony.IPhoneSubInfo";
        static final int TRANSACTION_getCompleteVoiceMailNumber = 9;
        static final int TRANSACTION_getDeviceId = 1;
        static final int TRANSACTION_getDeviceSvn = 2;
        static final int TRANSACTION_getIccSerialNumber = 4;
        static final int TRANSACTION_getIsimDomain = 12;
        static final int TRANSACTION_getIsimImpi = 11;
        static final int TRANSACTION_getIsimImpu = 13;
        static final int TRANSACTION_getLine1AlphaTag = 6;
        static final int TRANSACTION_getLine1Number = 5;
        static final int TRANSACTION_getMsisdn = 7;
        static final int TRANSACTION_getSubscriberId = 3;
        static final int TRANSACTION_getVoiceMailAlphaTag = 10;
        static final int TRANSACTION_getVoiceMailNumber = 8;

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.IPhoneSubInfo");
        }
    }


    public abstract String getCompleteVoiceMailNumber() throws RemoteException;

    public abstract String getDeviceId() throws RemoteException;

    public abstract String getDeviceSvn() throws RemoteException;

    public abstract String getIccSerialNumber() throws RemoteException;

    public abstract String getIsimDomain() throws RemoteException;

    public abstract String getIsimImpi() throws RemoteException;

    public abstract String[] getIsimImpu() throws RemoteException;

    public abstract String getLine1AlphaTag() throws RemoteException;

    public abstract String getLine1Number() throws RemoteException;

    public abstract String getMsisdn() throws RemoteException;

    public abstract String getSubscriberId() throws RemoteException;

    public abstract String getVoiceMailAlphaTag() throws RemoteException;

    public abstract String getVoiceMailNumber() throws RemoteException;
}
