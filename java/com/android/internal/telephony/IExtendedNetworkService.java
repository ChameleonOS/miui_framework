// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.text.TextUtils;

public interface IExtendedNetworkService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IExtendedNetworkService {
        private static class Proxy
            implements IExtendedNetworkService {

            public IBinder asBinder() {
                return mRemote;
            }

            public void clearMmiString() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IExtendedNetworkService");
                mRemote.transact(4, parcel, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "com.android.internal.telephony.IExtendedNetworkService";
            }

            public CharSequence getMmiRunningText() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IExtendedNetworkService");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                CharSequence charsequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return charsequence;
_L2:
                charsequence = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public CharSequence getUserMessage(CharSequence charsequence) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IExtendedNetworkService");
                if(charsequence == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                TextUtils.writeToParcel(charsequence, parcel, 0);
_L3:
                CharSequence charsequence1;
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_100;
                charsequence1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return charsequence1;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                charsequence1 = null;
                  goto _L4
            }

            public void setMmiString(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IExtendedNetworkService");
                parcel.writeString(s);
                mRemote.transact(1, parcel, parcel1, 0);
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


        public static IExtendedNetworkService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.IExtendedNetworkService");
                if(iinterface != null && (iinterface instanceof IExtendedNetworkService))
                    obj = (IExtendedNetworkService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IExtendedNetworkService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 100
        //                       3: 146
        //                       4: 221
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("com.android.internal.telephony.IExtendedNetworkService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.telephony.IExtendedNetworkService");
            setMmiString(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.telephony.IExtendedNetworkService");
            CharSequence charsequence2 = getMmiRunningText();
            parcel1.writeNoException();
            if(charsequence2 != null) {
                parcel1.writeInt(flag);
                TextUtils.writeToParcel(charsequence2, parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.telephony.IExtendedNetworkService");
            CharSequence charsequence;
            CharSequence charsequence1;
            if(parcel.readInt() != 0)
                charsequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            else
                charsequence = null;
            charsequence1 = getUserMessage(charsequence);
            parcel1.writeNoException();
            if(charsequence1 != null) {
                parcel1.writeInt(flag);
                TextUtils.writeToParcel(charsequence1, parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.telephony.IExtendedNetworkService");
            clearMmiString();
            parcel1.writeNoException();
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "com.android.internal.telephony.IExtendedNetworkService";
        static final int TRANSACTION_clearMmiString = 4;
        static final int TRANSACTION_getMmiRunningText = 2;
        static final int TRANSACTION_getUserMessage = 3;
        static final int TRANSACTION_setMmiString = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.IExtendedNetworkService");
        }
    }


    public abstract void clearMmiString() throws RemoteException;

    public abstract CharSequence getMmiRunningText() throws RemoteException;

    public abstract CharSequence getUserMessage(CharSequence charsequence) throws RemoteException;

    public abstract void setMmiString(String s) throws RemoteException;
}
