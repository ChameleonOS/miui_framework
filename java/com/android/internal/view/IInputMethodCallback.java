// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.*;

// Referenced classes of package com.android.internal.view:
//            IInputMethodSession

public interface IInputMethodCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputMethodCallback {
        private static class Proxy
            implements IInputMethodCallback {

            public IBinder asBinder() {
                return mRemote;
            }

            public void finishedEvent(int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                j = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodCallback");
                parcel.writeInt(i);
                if(!flag)
                    j = 0;
                parcel.writeInt(j);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.view.IInputMethodCallback";
            }

            public void sessionCreated(IInputMethodSession iinputmethodsession) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodCallback");
                if(iinputmethodsession != null)
                    ibinder = iinputmethodsession.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, null, 1);
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


        public static IInputMethodCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.view.IInputMethodCallback");
                if(iinterface != null && (iinterface instanceof IInputMethodCallback))
                    obj = (IInputMethodCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputMethodCallback) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 103
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("com.android.internal.view.IInputMethodCallback");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.view.IInputMethodCallback");
            int k = parcel.readInt();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            finishedEvent(k, flag1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.view.IInputMethodCallback");
            sessionCreated(IInputMethodSession.Stub.asInterface(parcel.readStrongBinder()));
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "com.android.internal.view.IInputMethodCallback";
        static final int TRANSACTION_finishedEvent = 1;
        static final int TRANSACTION_sessionCreated = 2;

        public Stub() {
            attachInterface(this, "com.android.internal.view.IInputMethodCallback");
        }
    }


    public abstract void finishedEvent(int i, boolean flag) throws RemoteException;

    public abstract void sessionCreated(IInputMethodSession iinputmethodsession) throws RemoteException;
}
