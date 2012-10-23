// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.*;

public interface INetworkPolicyListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INetworkPolicyListener {
        private static class Proxy
            implements INetworkPolicyListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.net.INetworkPolicyListener";
            }

            public void onMeteredIfacesChanged(String as[]) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyListener");
                parcel.writeStringArray(as);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onRestrictBackgroundChanged(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyListener");
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

            public void onUidRulesChanged(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.INetworkPolicyListener");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
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


        public static INetworkPolicyListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.INetworkPolicyListener");
                if(iinterface != null && (iinterface instanceof INetworkPolicyListener))
                    obj = (INetworkPolicyListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INetworkPolicyListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 92
        //                       3: 109
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.net.INetworkPolicyListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.INetworkPolicyListener");
            onUidRulesChanged(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.INetworkPolicyListener");
            onMeteredIfacesChanged(parcel.createStringArray());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.INetworkPolicyListener");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            onRestrictBackgroundChanged(flag1);
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.net.INetworkPolicyListener";
        static final int TRANSACTION_onMeteredIfacesChanged = 2;
        static final int TRANSACTION_onRestrictBackgroundChanged = 3;
        static final int TRANSACTION_onUidRulesChanged = 1;

        public Stub() {
            attachInterface(this, "android.net.INetworkPolicyListener");
        }
    }


    public abstract void onMeteredIfacesChanged(String as[]) throws RemoteException;

    public abstract void onRestrictBackgroundChanged(boolean flag) throws RemoteException;

    public abstract void onUidRulesChanged(int i, int j) throws RemoteException;
}
