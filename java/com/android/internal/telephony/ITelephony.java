// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import java.util.List;

public interface ITelephony
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ITelephony {
        private static class Proxy
            implements ITelephony {

            public void answerRingingCall() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void call(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
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

            public void cancelMissedCallsNotification() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(13, parcel, parcel1, 0);
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

            public void dial(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
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

            public int disableApnType(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                parcel.writeString(s);
                mRemote.transact(23, parcel, parcel1, 0);
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

            public boolean disableDataConnectivity() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(25, parcel, parcel1, 0);
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

            public void disableLocationUpdates() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(21, parcel, parcel1, 0);
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

            public int enableApnType(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                parcel.writeString(s);
                mRemote.transact(22, parcel, parcel1, 0);
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

            public boolean enableDataConnectivity() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(24, parcel, parcel1, 0);
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

            public void enableLocationUpdates() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(20, parcel, parcel1, 0);
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

            public boolean endCall() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
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

            public int getActivePhoneType() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(32, parcel, parcel1, 0);
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

            public List getAllCellInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(41, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(CellInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getCallState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(29, parcel, parcel1, 0);
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

            public int getCdmaEriIconIndex() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(33, parcel, parcel1, 0);
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

            public int getCdmaEriIconMode() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(34, parcel, parcel1, 0);
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

            public String getCdmaEriText() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(35, parcel, parcel1, 0);
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

            public Bundle getCellLocation() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(27, parcel, parcel1, 0);
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

            public int getDataActivity() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(30, parcel, parcel1, 0);
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

            public int getDataState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(31, parcel, parcel1, 0);
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
                return "com.android.internal.telephony.ITelephony";
            }

            public int getLteOnCdmaMode() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(40, parcel, parcel1, 0);
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

            public List getNeighboringCellInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(28, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(NeighboringCellInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getNetworkType() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(38, parcel, parcel1, 0);
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

            public int getVoiceMessageCount() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(37, parcel, parcel1, 0);
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

            public boolean handlePinMmi(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                parcel.writeString(s);
                mRemote.transact(16, parcel, parcel1, 0);
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

            public boolean hasIccCard() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(39, parcel, parcel1, 0);
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

            public boolean isDataConnectivityPossible() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(26, parcel, parcel1, 0);
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

            public boolean isIdle() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(10, parcel, parcel1, 0);
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

            public boolean isOffhook() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
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

            public boolean isRadioOn() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(11, parcel, parcel1, 0);
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

            public boolean isRinging() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(9, parcel, parcel1, 0);
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

            public boolean isSimPinEnabled() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(12, parcel, parcel1, 0);
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

            public boolean needsOtaServiceProvisioning() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(36, parcel, parcel1, 0);
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

            public boolean setRadio(boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                if(!flag)
                    break MISSING_BLOCK_LABEL_74;
                i = ((flag1) ? 1 : 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(18, parcel, parcel1, 0);
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

            public boolean showCallScreen() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(3, parcel, parcel1, 0);
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

            public boolean showCallScreenWithDialpad(boolean flag) throws RemoteException {
                boolean flag1;
                Parcel parcel;
                Parcel parcel1;
                flag1 = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
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

            public void silenceRinger() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(7, parcel, parcel1, 0);
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

            public boolean supplyPin(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                parcel.writeString(s);
                mRemote.transact(14, parcel, parcel1, 0);
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

            public boolean supplyPuk(String s, String s1) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public void toggleRadioOnOff() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(17, parcel, parcel1, 0);
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

            public void updateServiceLocation() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
                mRemote.transact(19, parcel, parcel1, 0);
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


        public static ITelephony asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.ITelephony");
                if(iinterface != null && (iinterface instanceof ITelephony))
                    obj = (ITelephony)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ITelephony) (obj));
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
            JVM INSTR lookupswitch 42: default 352
        //                       1: 375
        //                       2: 396
        //                       3: 417
        //                       4: 451
        //                       5: 504
        //                       6: 538
        //                       7: 555
        //                       8: 572
        //                       9: 606
        //                       10: 640
        //                       11: 674
        //                       12: 708
        //                       13: 742
        //                       14: 759
        //                       15: 797
        //                       16: 839
        //                       17: 877
        //                       18: 894
        //                       19: 947
        //                       20: 964
        //                       21: 981
        //                       22: 998
        //                       23: 1027
        //                       24: 1056
        //                       25: 1090
        //                       26: 1124
        //                       27: 1158
        //                       28: 1204
        //                       29: 1229
        //                       30: 1254
        //                       31: 1279
        //                       32: 1304
        //                       33: 1329
        //                       34: 1354
        //                       35: 1379
        //                       36: 1404
        //                       37: 1438
        //                       38: 1463
        //                       39: 1488
        //                       40: 1522
        //                       41: 1547
        //                       1598968902: 366;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L45:
            return flag;
_L43:
            parcel1.writeString("com.android.internal.telephony.ITelephony");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            dial(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            call(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag19 = showCallScreen();
            parcel1.writeNoException();
            if(flag19)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag17;
            boolean flag18;
            if(parcel.readInt() != 0)
                flag17 = flag;
            else
                flag17 = false;
            flag18 = showCallScreenWithDialpad(flag17);
            parcel1.writeNoException();
            if(flag18)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag16 = endCall();
            parcel1.writeNoException();
            if(flag16)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            answerRingingCall();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            silenceRinger();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag15 = isOffhook();
            parcel1.writeNoException();
            if(flag15)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag14 = isRinging();
            parcel1.writeNoException();
            if(flag14)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag13 = isIdle();
            parcel1.writeNoException();
            if(flag13)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag12 = isRadioOn();
            parcel1.writeNoException();
            if(flag12)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag11 = isSimPinEnabled();
            parcel1.writeNoException();
            if(flag11)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            cancelMissedCallsNotification();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag10 = supplyPin(parcel.readString());
            parcel1.writeNoException();
            if(flag10)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag9 = supplyPuk(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(flag9)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag8 = handlePinMmi(parcel.readString());
            parcel1.writeNoException();
            if(flag8)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            toggleRadioOnOff();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag6;
            boolean flag7;
            if(parcel.readInt() != 0)
                flag6 = flag;
            else
                flag6 = false;
            flag7 = setRadio(flag6);
            parcel1.writeNoException();
            if(flag7)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            updateServiceLocation();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            enableLocationUpdates();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            disableLocationUpdates();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int j3 = enableApnType(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(j3);
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int i3 = disableApnType(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i3);
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag5 = enableDataConnectivity();
            parcel1.writeNoException();
            if(flag5)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag4 = disableDataConnectivity();
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag3 = isDataConnectivityPossible();
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            Bundle bundle = getCellLocation();
            parcel1.writeNoException();
            if(bundle != null) {
                parcel1.writeInt(flag);
                bundle.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            List list1 = getNeighboringCellInfo();
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int l2 = getCallState();
            parcel1.writeNoException();
            parcel1.writeInt(l2);
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int k2 = getDataActivity();
            parcel1.writeNoException();
            parcel1.writeInt(k2);
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int j2 = getDataState();
            parcel1.writeNoException();
            parcel1.writeInt(j2);
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int i2 = getActivePhoneType();
            parcel1.writeNoException();
            parcel1.writeInt(i2);
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int l1 = getCdmaEriIconIndex();
            parcel1.writeNoException();
            parcel1.writeInt(l1);
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int k1 = getCdmaEriIconMode();
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            String s = getCdmaEriText();
            parcel1.writeNoException();
            parcel1.writeString(s);
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag2 = needsOtaServiceProvisioning();
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int j1 = getVoiceMessageCount();
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int i1 = getNetworkType();
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag1 = hasIccCard();
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            int l = getLteOnCdmaMode();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            List list = getAllCellInfo();
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            if(true) goto _L45; else goto _L44
_L44:
        }

        private static final String DESCRIPTOR = "com.android.internal.telephony.ITelephony";
        static final int TRANSACTION_answerRingingCall = 6;
        static final int TRANSACTION_call = 2;
        static final int TRANSACTION_cancelMissedCallsNotification = 13;
        static final int TRANSACTION_dial = 1;
        static final int TRANSACTION_disableApnType = 23;
        static final int TRANSACTION_disableDataConnectivity = 25;
        static final int TRANSACTION_disableLocationUpdates = 21;
        static final int TRANSACTION_enableApnType = 22;
        static final int TRANSACTION_enableDataConnectivity = 24;
        static final int TRANSACTION_enableLocationUpdates = 20;
        static final int TRANSACTION_endCall = 5;
        static final int TRANSACTION_getActivePhoneType = 32;
        static final int TRANSACTION_getAllCellInfo = 41;
        static final int TRANSACTION_getCallState = 29;
        static final int TRANSACTION_getCdmaEriIconIndex = 33;
        static final int TRANSACTION_getCdmaEriIconMode = 34;
        static final int TRANSACTION_getCdmaEriText = 35;
        static final int TRANSACTION_getCellLocation = 27;
        static final int TRANSACTION_getDataActivity = 30;
        static final int TRANSACTION_getDataState = 31;
        static final int TRANSACTION_getLteOnCdmaMode = 40;
        static final int TRANSACTION_getNeighboringCellInfo = 28;
        static final int TRANSACTION_getNetworkType = 38;
        static final int TRANSACTION_getVoiceMessageCount = 37;
        static final int TRANSACTION_handlePinMmi = 16;
        static final int TRANSACTION_hasIccCard = 39;
        static final int TRANSACTION_isDataConnectivityPossible = 26;
        static final int TRANSACTION_isIdle = 10;
        static final int TRANSACTION_isOffhook = 8;
        static final int TRANSACTION_isRadioOn = 11;
        static final int TRANSACTION_isRinging = 9;
        static final int TRANSACTION_isSimPinEnabled = 12;
        static final int TRANSACTION_needsOtaServiceProvisioning = 36;
        static final int TRANSACTION_setRadio = 18;
        static final int TRANSACTION_showCallScreen = 3;
        static final int TRANSACTION_showCallScreenWithDialpad = 4;
        static final int TRANSACTION_silenceRinger = 7;
        static final int TRANSACTION_supplyPin = 14;
        static final int TRANSACTION_supplyPuk = 15;
        static final int TRANSACTION_toggleRadioOnOff = 17;
        static final int TRANSACTION_updateServiceLocation = 19;

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.ITelephony");
        }
    }


    public abstract void answerRingingCall() throws RemoteException;

    public abstract void call(String s) throws RemoteException;

    public abstract void cancelMissedCallsNotification() throws RemoteException;

    public abstract void dial(String s) throws RemoteException;

    public abstract int disableApnType(String s) throws RemoteException;

    public abstract boolean disableDataConnectivity() throws RemoteException;

    public abstract void disableLocationUpdates() throws RemoteException;

    public abstract int enableApnType(String s) throws RemoteException;

    public abstract boolean enableDataConnectivity() throws RemoteException;

    public abstract void enableLocationUpdates() throws RemoteException;

    public abstract boolean endCall() throws RemoteException;

    public abstract int getActivePhoneType() throws RemoteException;

    public abstract List getAllCellInfo() throws RemoteException;

    public abstract int getCallState() throws RemoteException;

    public abstract int getCdmaEriIconIndex() throws RemoteException;

    public abstract int getCdmaEriIconMode() throws RemoteException;

    public abstract String getCdmaEriText() throws RemoteException;

    public abstract Bundle getCellLocation() throws RemoteException;

    public abstract int getDataActivity() throws RemoteException;

    public abstract int getDataState() throws RemoteException;

    public abstract int getLteOnCdmaMode() throws RemoteException;

    public abstract List getNeighboringCellInfo() throws RemoteException;

    public abstract int getNetworkType() throws RemoteException;

    public abstract int getVoiceMessageCount() throws RemoteException;

    public abstract boolean handlePinMmi(String s) throws RemoteException;

    public abstract boolean hasIccCard() throws RemoteException;

    public abstract boolean isDataConnectivityPossible() throws RemoteException;

    public abstract boolean isIdle() throws RemoteException;

    public abstract boolean isOffhook() throws RemoteException;

    public abstract boolean isRadioOn() throws RemoteException;

    public abstract boolean isRinging() throws RemoteException;

    public abstract boolean isSimPinEnabled() throws RemoteException;

    public abstract boolean needsOtaServiceProvisioning() throws RemoteException;

    public abstract boolean setRadio(boolean flag) throws RemoteException;

    public abstract boolean showCallScreen() throws RemoteException;

    public abstract boolean showCallScreenWithDialpad(boolean flag) throws RemoteException;

    public abstract void silenceRinger() throws RemoteException;

    public abstract boolean supplyPin(String s) throws RemoteException;

    public abstract boolean supplyPuk(String s, String s1) throws RemoteException;

    public abstract void toggleRadioOnOff() throws RemoteException;

    public abstract void updateServiceLocation() throws RemoteException;
}
