// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.security;

import android.os.*;

public interface IKeyChainService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IKeyChainService {
        private static class Proxy
            implements IKeyChainService {

            public IBinder asBinder() {
                return mRemote;
            }

            public boolean deleteCaCertificate(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.security.IKeyChainService");
                parcel.writeString(s);
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

            public byte[] getCertificate(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                byte abyte0[];
                parcel.writeInterfaceToken("android.security.IKeyChainService");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                abyte0 = parcel1.createByteArray();
                parcel1.recycle();
                parcel.recycle();
                return abyte0;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.security.IKeyChainService";
            }

            public boolean hasGrant(int i, String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.security.IKeyChainService");
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public void installCaCertificate(byte abyte0[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.security.IKeyChainService");
                parcel.writeByteArray(abyte0);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public String requestPrivateKey(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("android.security.IKeyChainService");
                parcel.writeString(s);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean reset() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.security.IKeyChainService");
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

            public void setGrant(int i, String s, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.security.IKeyChainService");
                parcel.writeInt(i);
                parcel.writeString(s);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IKeyChainService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.security.IKeyChainService");
                if(iinterface != null && (iinterface instanceof IKeyChainService))
                    obj = (IKeyChainService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IKeyChainService) (obj));
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
            JVM INSTR lookupswitch 8: default 80
        //                       1: 103
        //                       2: 132
        //                       3: 161
        //                       4: 182
        //                       5: 220
        //                       6: 254
        //                       7: 306
        //                       1598968902: 94;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L11:
            return flag;
_L9:
            parcel1.writeString("android.security.IKeyChainService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.security.IKeyChainService");
            String s1 = requestPrivateKey(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.security.IKeyChainService");
            byte abyte0[] = getCertificate(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeByteArray(abyte0);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.security.IKeyChainService");
            installCaCertificate(parcel.createByteArray());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.security.IKeyChainService");
            boolean flag4 = deleteCaCertificate(parcel.readString());
            parcel1.writeNoException();
            if(flag4)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.security.IKeyChainService");
            boolean flag3 = reset();
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.security.IKeyChainService");
            int l = parcel.readInt();
            String s = parcel.readString();
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            setGrant(l, s, flag2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.security.IKeyChainService");
            boolean flag1 = hasGrant(parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L11; else goto _L10
_L10:
        }

        private static final String DESCRIPTOR = "android.security.IKeyChainService";
        static final int TRANSACTION_deleteCaCertificate = 4;
        static final int TRANSACTION_getCertificate = 2;
        static final int TRANSACTION_hasGrant = 7;
        static final int TRANSACTION_installCaCertificate = 3;
        static final int TRANSACTION_requestPrivateKey = 1;
        static final int TRANSACTION_reset = 5;
        static final int TRANSACTION_setGrant = 6;

        public Stub() {
            attachInterface(this, "android.security.IKeyChainService");
        }
    }


    public abstract boolean deleteCaCertificate(String s) throws RemoteException;

    public abstract byte[] getCertificate(String s) throws RemoteException;

    public abstract boolean hasGrant(int i, String s) throws RemoteException;

    public abstract void installCaCertificate(byte abyte0[]) throws RemoteException;

    public abstract String requestPrivateKey(String s) throws RemoteException;

    public abstract boolean reset() throws RemoteException;

    public abstract void setGrant(int i, String s, boolean flag) throws RemoteException;
}
