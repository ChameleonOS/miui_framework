// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.*;

// Referenced classes of package android.net:
//            NetworkPolicy, NetworkState, NetworkQuotaInfo, INetworkPolicyListener, 
//            NetworkTemplate

public interface INetworkPolicyManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INetworkPolicyManager {
        private static class Proxy
            implements INetworkPolicyManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public int getAppPolicy(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                parcel.writeInt(i);
                mRemote.transact(2, parcel, parcel1, 0);
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

            public int[] getAppsWithPolicy(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int ai[];
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "android.net.INetworkPolicyManager";
            }

            public NetworkPolicy[] getNetworkPolicies() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                NetworkPolicy anetworkpolicy[];
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                anetworkpolicy = (NetworkPolicy[])parcel1.createTypedArray(NetworkPolicy.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return anetworkpolicy;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public NetworkQuotaInfo getNetworkQuotaInfo(NetworkState networkstate) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                if(networkstate == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                networkstate.writeToParcel(parcel, 0);
_L3:
                NetworkQuotaInfo networkquotainfo;
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_101;
                networkquotainfo = (NetworkQuotaInfo)NetworkQuotaInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return networkquotainfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                networkquotainfo = null;
                  goto _L4
            }

            public boolean getRestrictBackground() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
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

            public boolean isNetworkMetered(NetworkState networkstate) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                if(networkstate == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                networkstate.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isUidForeground(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void registerListener(INetworkPolicyListener inetworkpolicylistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                if(inetworkpolicylistener == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = inetworkpolicylistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public void setAppPolicy(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
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

            public void setNetworkPolicies(NetworkPolicy anetworkpolicy[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                parcel.writeTypedArray(anetworkpolicy, 0);
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

            public void setRestrictBackground(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void snoozeLimit(NetworkTemplate networktemplate) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                if(networktemplate == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                networktemplate.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(9, parcel, parcel1, 0);
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

            public void unregisterListener(INetworkPolicyListener inetworkpolicylistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.INetworkPolicyManager");
                if(inetworkpolicylistener == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = inetworkpolicylistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(6, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static INetworkPolicyManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.INetworkPolicyManager");
                if(iinterface != null && (iinterface instanceof INetworkPolicyManager))
                    obj = (INetworkPolicyManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INetworkPolicyManager) (obj));
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
            JVM INSTR lookupswitch 14: default 128
        //                       1: 151
        //                       2: 176
        //                       3: 205
        //                       4: 234
        //                       5: 272
        //                       6: 296
        //                       7: 320
        //                       8: 347
        //                       9: 374
        //                       10: 420
        //                       11: 456
        //                       12: 490
        //                       13: 565
        //                       1598968902: 142;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L17:
            return flag;
_L15:
            parcel1.writeString("android.net.INetworkPolicyManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            setAppPolicy(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            int l = getAppPolicy(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            int ai[] = getAppsWithPolicy(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeIntArray(ai);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            boolean flag4 = isUidForeground(parcel.readInt());
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            registerListener(INetworkPolicyListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            unregisterListener(INetworkPolicyListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            setNetworkPolicies((NetworkPolicy[])parcel.createTypedArray(NetworkPolicy.CREATOR));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            NetworkPolicy anetworkpolicy[] = getNetworkPolicies();
            parcel1.writeNoException();
            parcel1.writeTypedArray(anetworkpolicy, flag);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            NetworkTemplate networktemplate;
            if(parcel.readInt() != 0)
                networktemplate = (NetworkTemplate)NetworkTemplate.CREATOR.createFromParcel(parcel);
            else
                networktemplate = null;
            snoozeLimit(networktemplate);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            setRestrictBackground(flag3);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            boolean flag2 = getRestrictBackground();
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            NetworkState networkstate1;
            NetworkQuotaInfo networkquotainfo;
            if(parcel.readInt() != 0)
                networkstate1 = (NetworkState)NetworkState.CREATOR.createFromParcel(parcel);
            else
                networkstate1 = null;
            networkquotainfo = getNetworkQuotaInfo(networkstate1);
            parcel1.writeNoException();
            if(networkquotainfo != null) {
                parcel1.writeInt(flag);
                networkquotainfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.net.INetworkPolicyManager");
            NetworkState networkstate;
            boolean flag1;
            if(parcel.readInt() != 0)
                networkstate = (NetworkState)NetworkState.CREATOR.createFromParcel(parcel);
            else
                networkstate = null;
            flag1 = isNetworkMetered(networkstate);
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L17; else goto _L16
_L16:
        }

        private static final String DESCRIPTOR = "android.net.INetworkPolicyManager";
        static final int TRANSACTION_getAppPolicy = 2;
        static final int TRANSACTION_getAppsWithPolicy = 3;
        static final int TRANSACTION_getNetworkPolicies = 8;
        static final int TRANSACTION_getNetworkQuotaInfo = 12;
        static final int TRANSACTION_getRestrictBackground = 11;
        static final int TRANSACTION_isNetworkMetered = 13;
        static final int TRANSACTION_isUidForeground = 4;
        static final int TRANSACTION_registerListener = 5;
        static final int TRANSACTION_setAppPolicy = 1;
        static final int TRANSACTION_setNetworkPolicies = 7;
        static final int TRANSACTION_setRestrictBackground = 10;
        static final int TRANSACTION_snoozeLimit = 9;
        static final int TRANSACTION_unregisterListener = 6;

        public Stub() {
            attachInterface(this, "android.net.INetworkPolicyManager");
        }
    }


    public abstract int getAppPolicy(int i) throws RemoteException;

    public abstract int[] getAppsWithPolicy(int i) throws RemoteException;

    public abstract NetworkPolicy[] getNetworkPolicies() throws RemoteException;

    public abstract NetworkQuotaInfo getNetworkQuotaInfo(NetworkState networkstate) throws RemoteException;

    public abstract boolean getRestrictBackground() throws RemoteException;

    public abstract boolean isNetworkMetered(NetworkState networkstate) throws RemoteException;

    public abstract boolean isUidForeground(int i) throws RemoteException;

    public abstract void registerListener(INetworkPolicyListener inetworkpolicylistener) throws RemoteException;

    public abstract void setAppPolicy(int i, int j) throws RemoteException;

    public abstract void setNetworkPolicies(NetworkPolicy anetworkpolicy[]) throws RemoteException;

    public abstract void setRestrictBackground(boolean flag) throws RemoteException;

    public abstract void snoozeLimit(NetworkTemplate networktemplate) throws RemoteException;

    public abstract void unregisterListener(INetworkPolicyListener inetworkpolicylistener) throws RemoteException;
}
