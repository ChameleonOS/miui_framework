// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.telephony.*;

public interface IPhoneStateListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IPhoneStateListener {
        private static class Proxy
            implements IPhoneStateListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.telephony.IPhoneStateListener";
            }

            public void onCallForwardingIndicatorChanged(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onCallStateChanged(int i, String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onCellInfoChanged(CellInfo cellinfo) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                if(cellinfo == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                cellinfo.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(11, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onCellLocationChanged(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onDataActivity(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                parcel.writeInt(i);
                mRemote.transact(8, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onDataConnectionStateChanged(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onMessageWaitingIndicatorChanged(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onOtaspChanged(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                parcel.writeInt(i);
                mRemote.transact(10, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onServiceStateChanged(ServiceState servicestate) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                if(servicestate == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                servicestate.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onSignalStrengthChanged(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                parcel.writeInt(i);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onSignalStrengthsChanged(SignalStrength signalstrength) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.IPhoneStateListener");
                if(signalstrength == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                signalstrength.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(9, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IPhoneStateListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.IPhoneStateListener");
                if(iinterface != null && (iinterface instanceof IPhoneStateListener))
                    obj = (IPhoneStateListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IPhoneStateListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag;
            boolean flag1;
            flag = false;
            flag1 = true;
            i;
            JVM INSTR lookupswitch 12: default 112
        //                       1: 135
        //                       2: 177
        //                       3: 194
        //                       4: 220
        //                       5: 246
        //                       6: 288
        //                       7: 309
        //                       8: 330
        //                       9: 347
        //                       10: 389
        //                       11: 406
        //                       1598968902: 126;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
            flag1 = super.onTransact(i, parcel, parcel1, j);
_L15:
            return flag1;
_L13:
            parcel1.writeString("com.android.internal.telephony.IPhoneStateListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            ServiceState servicestate;
            if(parcel.readInt() != 0)
                servicestate = (ServiceState)ServiceState.CREATOR.createFromParcel(parcel);
            else
                servicestate = null;
            onServiceStateChanged(servicestate);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            onSignalStrengthChanged(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            if(parcel.readInt() != 0)
                flag = flag1;
            onMessageWaitingIndicatorChanged(flag);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            if(parcel.readInt() != 0)
                flag = flag1;
            onCallForwardingIndicatorChanged(flag);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            onCellLocationChanged(bundle);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            onCallStateChanged(parcel.readInt(), parcel.readString());
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            onDataConnectionStateChanged(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            onDataActivity(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            SignalStrength signalstrength;
            if(parcel.readInt() != 0)
                signalstrength = (SignalStrength)SignalStrength.CREATOR.createFromParcel(parcel);
            else
                signalstrength = null;
            onSignalStrengthsChanged(signalstrength);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            onOtaspChanged(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.telephony.IPhoneStateListener");
            CellInfo cellinfo;
            if(parcel.readInt() != 0)
                cellinfo = (CellInfo)CellInfo.CREATOR.createFromParcel(parcel);
            else
                cellinfo = null;
            onCellInfoChanged(cellinfo);
            if(true) goto _L15; else goto _L14
_L14:
        }

        private static final String DESCRIPTOR = "com.android.internal.telephony.IPhoneStateListener";
        static final int TRANSACTION_onCallForwardingIndicatorChanged = 4;
        static final int TRANSACTION_onCallStateChanged = 6;
        static final int TRANSACTION_onCellInfoChanged = 11;
        static final int TRANSACTION_onCellLocationChanged = 5;
        static final int TRANSACTION_onDataActivity = 8;
        static final int TRANSACTION_onDataConnectionStateChanged = 7;
        static final int TRANSACTION_onMessageWaitingIndicatorChanged = 3;
        static final int TRANSACTION_onOtaspChanged = 10;
        static final int TRANSACTION_onServiceStateChanged = 1;
        static final int TRANSACTION_onSignalStrengthChanged = 2;
        static final int TRANSACTION_onSignalStrengthsChanged = 9;

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.IPhoneStateListener");
        }
    }


    public abstract void onCallForwardingIndicatorChanged(boolean flag) throws RemoteException;

    public abstract void onCallStateChanged(int i, String s) throws RemoteException;

    public abstract void onCellInfoChanged(CellInfo cellinfo) throws RemoteException;

    public abstract void onCellLocationChanged(Bundle bundle) throws RemoteException;

    public abstract void onDataActivity(int i) throws RemoteException;

    public abstract void onDataConnectionStateChanged(int i, int j) throws RemoteException;

    public abstract void onMessageWaitingIndicatorChanged(boolean flag) throws RemoteException;

    public abstract void onOtaspChanged(int i) throws RemoteException;

    public abstract void onServiceStateChanged(ServiceState servicestate) throws RemoteException;

    public abstract void onSignalStrengthChanged(int i) throws RemoteException;

    public abstract void onSignalStrengthsChanged(SignalStrength signalstrength) throws RemoteException;
}
