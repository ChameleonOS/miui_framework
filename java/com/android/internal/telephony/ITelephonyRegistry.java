// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.os.*;
import android.telephony.*;

// Referenced classes of package com.android.internal.telephony:
//            IPhoneStateListener

public interface ITelephonyRegistry
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ITelephonyRegistry {
        private static class Proxy
            implements ITelephonyRegistry {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.telephony.ITelephonyRegistry";
            }

            public void listen(String s, IPhoneStateListener iphonestatelistener, int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                parcel.writeString(s);
                if(iphonestatelistener == null)
                    break MISSING_BLOCK_LABEL_95;
                ibinder = iphonestatelistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(!flag)
                    j = 0;
                parcel.writeInt(j);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public void notifyCallForwardingChanged(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
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

            public void notifyCallState(int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                parcel.writeInt(i);
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

            public void notifyCellInfo(CellInfo cellinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                if(cellinfo == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                cellinfo.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(12, parcel, parcel1, 0);
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

            public void notifyCellLocation(Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void notifyDataActivity(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                parcel.writeInt(i);
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

            public void notifyDataConnection(int i, boolean flag, String s, String s1, String s2, LinkProperties linkproperties, LinkCapabilities linkcapabilities, 
                    int j, boolean flag1) throws RemoteException {
                int k;
                Parcel parcel;
                Parcel parcel1;
                k = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                parcel.writeInt(i);
                if(!flag) goto _L2; else goto _L1
_L1:
                int l = k;
_L5:
                parcel.writeInt(l);
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeString(s2);
                if(linkproperties == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                linkproperties.writeToParcel(parcel, 0);
_L6:
                if(linkcapabilities == null)
                    break MISSING_BLOCK_LABEL_181;
                parcel.writeInt(1);
                linkcapabilities.writeToParcel(parcel, 0);
_L7:
                parcel.writeInt(j);
                Exception exception;
                if(!flag1)
                    k = 0;
                parcel.writeInt(k);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                l = 0;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L7
            }

            public void notifyDataConnectionFailed(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(9, parcel, parcel1, 0);
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

            public void notifyMessageWaitingChanged(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public void notifyOtaspChanged(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
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

            public void notifyServiceState(ServiceState servicestate) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                if(servicestate == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                servicestate.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void notifySignalStrength(SignalStrength signalstrength) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.telephony.ITelephonyRegistry");
                if(signalstrength == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                signalstrength.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(4, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ITelephonyRegistry asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.ITelephonyRegistry");
                if(iinterface != null && (iinterface instanceof ITelephonyRegistry))
                    obj = (ITelephonyRegistry)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ITelephonyRegistry) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 13: default 116
        //                       1: 142
        //                       2: 207
        //                       3: 235
        //                       4: 284
        //                       5: 333
        //                       6: 371
        //                       7: 409
        //                       8: 433
        //                       9: 587
        //                       10: 615
        //                       11: 664
        //                       12: 688
        //                       1598968902: 130;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L16:
            return flag;
_L14:
            parcel1.writeString("com.android.internal.telephony.ITelephonyRegistry");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            String s3 = parcel.readString();
            IPhoneStateListener iphonestatelistener = IPhoneStateListener.Stub.asInterface(parcel.readStrongBinder());
            int i1 = parcel.readInt();
            boolean flag5;
            if(parcel.readInt() != 0)
                flag5 = true;
            else
                flag5 = false;
            listen(s3, iphonestatelistener, i1, flag5);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            notifyCallState(parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            ServiceState servicestate;
            if(parcel.readInt() != 0)
                servicestate = (ServiceState)ServiceState.CREATOR.createFromParcel(parcel);
            else
                servicestate = null;
            notifyServiceState(servicestate);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            SignalStrength signalstrength;
            if(parcel.readInt() != 0)
                signalstrength = (SignalStrength)SignalStrength.CREATOR.createFromParcel(parcel);
            else
                signalstrength = null;
            notifySignalStrength(signalstrength);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            boolean flag4;
            if(parcel.readInt() != 0)
                flag4 = true;
            else
                flag4 = false;
            notifyMessageWaitingChanged(flag4);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            notifyCallForwardingChanged(flag3);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            notifyDataActivity(parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            int k = parcel.readInt();
            boolean flag1;
            String s;
            String s1;
            String s2;
            LinkProperties linkproperties;
            LinkCapabilities linkcapabilities;
            int l;
            boolean flag2;
            if(parcel.readInt() != 0)
                flag1 = true;
            else
                flag1 = false;
            s = parcel.readString();
            s1 = parcel.readString();
            s2 = parcel.readString();
            if(parcel.readInt() != 0)
                linkproperties = (LinkProperties)LinkProperties.CREATOR.createFromParcel(parcel);
            else
                linkproperties = null;
            if(parcel.readInt() != 0)
                linkcapabilities = (LinkCapabilities)LinkCapabilities.CREATOR.createFromParcel(parcel);
            else
                linkcapabilities = null;
            l = parcel.readInt();
            if(parcel.readInt() != 0)
                flag2 = true;
            else
                flag2 = false;
            notifyDataConnection(k, flag1, s, s1, s2, linkproperties, linkcapabilities, l, flag2);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            notifyDataConnectionFailed(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            notifyCellLocation(bundle);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            notifyOtaspChanged(parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.telephony.ITelephonyRegistry");
            CellInfo cellinfo;
            if(parcel.readInt() != 0)
                cellinfo = (CellInfo)CellInfo.CREATOR.createFromParcel(parcel);
            else
                cellinfo = null;
            notifyCellInfo(cellinfo);
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L16; else goto _L15
_L15:
        }

        private static final String DESCRIPTOR = "com.android.internal.telephony.ITelephonyRegistry";
        static final int TRANSACTION_listen = 1;
        static final int TRANSACTION_notifyCallForwardingChanged = 6;
        static final int TRANSACTION_notifyCallState = 2;
        static final int TRANSACTION_notifyCellInfo = 12;
        static final int TRANSACTION_notifyCellLocation = 10;
        static final int TRANSACTION_notifyDataActivity = 7;
        static final int TRANSACTION_notifyDataConnection = 8;
        static final int TRANSACTION_notifyDataConnectionFailed = 9;
        static final int TRANSACTION_notifyMessageWaitingChanged = 5;
        static final int TRANSACTION_notifyOtaspChanged = 11;
        static final int TRANSACTION_notifyServiceState = 3;
        static final int TRANSACTION_notifySignalStrength = 4;

        public Stub() {
            attachInterface(this, "com.android.internal.telephony.ITelephonyRegistry");
        }
    }


    public abstract void listen(String s, IPhoneStateListener iphonestatelistener, int i, boolean flag) throws RemoteException;

    public abstract void notifyCallForwardingChanged(boolean flag) throws RemoteException;

    public abstract void notifyCallState(int i, String s) throws RemoteException;

    public abstract void notifyCellInfo(CellInfo cellinfo) throws RemoteException;

    public abstract void notifyCellLocation(Bundle bundle) throws RemoteException;

    public abstract void notifyDataActivity(int i) throws RemoteException;

    public abstract void notifyDataConnection(int i, boolean flag, String s, String s1, String s2, LinkProperties linkproperties, LinkCapabilities linkcapabilities, 
            int j, boolean flag1) throws RemoteException;

    public abstract void notifyDataConnectionFailed(String s, String s1) throws RemoteException;

    public abstract void notifyMessageWaitingChanged(boolean flag) throws RemoteException;

    public abstract void notifyOtaspChanged(int i) throws RemoteException;

    public abstract void notifyServiceState(ServiceState servicestate) throws RemoteException;

    public abstract void notifySignalStrength(SignalStrength signalstrength) throws RemoteException;
}
