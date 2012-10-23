// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.*;

// Referenced classes of package com.android.internal.view:
//            InputBindResult

public interface IInputMethodClient
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputMethodClient {
        private static class Proxy
            implements IInputMethodClient {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.view.IInputMethodClient";
            }

            public void onBindMethod(InputBindResult inputbindresult) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodClient");
                if(inputbindresult == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                inputbindresult.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onUnbindMethod(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodClient");
                parcel.writeInt(i);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setActive(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodClient");
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

            public void setUsingInputMethod(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodClient");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
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


        public static IInputMethodClient asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.view.IInputMethodClient");
                if(iinterface != null && (iinterface instanceof IInputMethodClient))
                    obj = (IInputMethodClient)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputMethodClient) (obj));
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
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 105
        //                       3: 147
        //                       4: 164
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag1 = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag1;
_L6:
            parcel1.writeString("com.android.internal.view.IInputMethodClient");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.view.IInputMethodClient");
            if(parcel.readInt() != 0)
                flag = flag1;
            setUsingInputMethod(flag);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.view.IInputMethodClient");
            InputBindResult inputbindresult;
            if(parcel.readInt() != 0)
                inputbindresult = (InputBindResult)InputBindResult.CREATOR.createFromParcel(parcel);
            else
                inputbindresult = null;
            onBindMethod(inputbindresult);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.view.IInputMethodClient");
            onUnbindMethod(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.view.IInputMethodClient");
            if(parcel.readInt() != 0)
                flag = flag1;
            setActive(flag);
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "com.android.internal.view.IInputMethodClient";
        static final int TRANSACTION_onBindMethod = 2;
        static final int TRANSACTION_onUnbindMethod = 3;
        static final int TRANSACTION_setActive = 4;
        static final int TRANSACTION_setUsingInputMethod = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.view.IInputMethodClient");
        }
    }


    public abstract void onBindMethod(InputBindResult inputbindresult) throws RemoteException;

    public abstract void onUnbindMethod(int i) throws RemoteException;

    public abstract void setActive(boolean flag) throws RemoteException;

    public abstract void setUsingInputMethod(boolean flag) throws RemoteException;
}
