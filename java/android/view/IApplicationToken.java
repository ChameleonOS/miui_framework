// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.os.*;

public interface IApplicationToken
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IApplicationToken {
        private static class Proxy
            implements IApplicationToken {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.view.IApplicationToken";
            }

            public long getKeyDispatchingTimeout() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("android.view.IApplicationToken");
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean keyDispatchingTimedOut() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.view.IApplicationToken");
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

            public void windowsDrawn() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IApplicationToken");
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

            public void windowsGone() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IApplicationToken");
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

            public void windowsVisible() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.IApplicationToken");
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IApplicationToken asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.view.IApplicationToken");
                if(iinterface != null && (iinterface instanceof IApplicationToken))
                    obj = (IApplicationToken)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IApplicationToken) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 104
        //                       3: 121
        //                       4: 138
        //                       5: 178
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.view.IApplicationToken");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.view.IApplicationToken");
            windowsDrawn();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.view.IApplicationToken");
            windowsVisible();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.view.IApplicationToken");
            windowsGone();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.view.IApplicationToken");
            boolean flag1 = keyDispatchingTimedOut();
            parcel1.writeNoException();
            int k;
            if(flag1)
                k = ((flag) ? 1 : 0);
            else
                k = 0;
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.view.IApplicationToken");
            long l = getKeyDispatchingTimeout();
            parcel1.writeNoException();
            parcel1.writeLong(l);
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.view.IApplicationToken";
        static final int TRANSACTION_getKeyDispatchingTimeout = 5;
        static final int TRANSACTION_keyDispatchingTimedOut = 4;
        static final int TRANSACTION_windowsDrawn = 1;
        static final int TRANSACTION_windowsGone = 3;
        static final int TRANSACTION_windowsVisible = 2;

        public Stub() {
            attachInterface(this, "android.view.IApplicationToken");
        }
    }


    public abstract long getKeyDispatchingTimeout() throws RemoteException;

    public abstract boolean keyDispatchingTimedOut() throws RemoteException;

    public abstract void windowsDrawn() throws RemoteException;

    public abstract void windowsGone() throws RemoteException;

    public abstract void windowsVisible() throws RemoteException;
}
