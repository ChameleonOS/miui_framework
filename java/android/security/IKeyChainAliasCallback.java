// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.security;

import android.os.*;

public interface IKeyChainAliasCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IKeyChainAliasCallback {
        private static class Proxy
            implements IKeyChainAliasCallback {

            public void alias(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.security.IKeyChainAliasCallback");
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

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.security.IKeyChainAliasCallback";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IKeyChainAliasCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.security.IKeyChainAliasCallback");
                if(iinterface != null && (iinterface instanceof IKeyChainAliasCallback))
                    obj = (IKeyChainAliasCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IKeyChainAliasCallback) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 2: default 32
        //                       1: 55
        //                       1598968902: 46;
               goto _L1 _L2 _L3
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L5:
            return flag;
_L3:
            parcel1.writeString("android.security.IKeyChainAliasCallback");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.security.IKeyChainAliasCallback");
            alias(parcel.readString());
            parcel1.writeNoException();
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.security.IKeyChainAliasCallback";
        static final int TRANSACTION_alias = 1;

        public Stub() {
            attachInterface(this, "android.security.IKeyChainAliasCallback");
        }
    }


    public abstract void alias(String s) throws RemoteException;
}
