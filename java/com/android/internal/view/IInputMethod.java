// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.*;
import android.view.inputmethod.*;

// Referenced classes of package com.android.internal.view:
//            IInputMethodCallback, IInputContext, IInputMethodSession

public interface IInputMethod
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputMethod {
        private static class Proxy
            implements IInputMethod {

            public IBinder asBinder() {
                return mRemote;
            }

            public void attachToken(IBinder ibinder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void bindInput(InputBinding inputbinding) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                if(inputbinding == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                inputbinding.writeToParcel(parcel, 0);
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

            public void changeInputMethodSubtype(InputMethodSubtype inputmethodsubtype) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                if(inputmethodsubtype == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                inputmethodsubtype.writeToParcel(parcel, 0);
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

            public void createSession(IInputMethodCallback iinputmethodcallback) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                if(iinputmethodcallback != null)
                    ibinder = iinputmethodcallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.view.IInputMethod";
            }

            public void hideSoftInput(int i, ResultReceiver resultreceiver) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                parcel.writeInt(i);
                if(resultreceiver == null)
                    break MISSING_BLOCK_LABEL_50;
                parcel.writeInt(1);
                resultreceiver.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(10, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void restartInput(IInputContext iinputcontext, EditorInfo editorinfo) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                if(iinputcontext != null)
                    ibinder = iinputcontext.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(editorinfo == null)
                    break MISSING_BLOCK_LABEL_69;
                parcel.writeInt(1);
                editorinfo.writeToParcel(parcel, 0);
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

            public void revokeSession(IInputMethodSession iinputmethodsession) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                if(iinputmethodsession != null)
                    ibinder = iinputmethodsession.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(8, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setSessionEnabled(IInputMethodSession iinputmethodsession, boolean flag) throws RemoteException {
                IBinder ibinder;
                int i;
                Parcel parcel;
                ibinder = null;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                if(iinputmethodsession != null)
                    ibinder = iinputmethodsession.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void showSoftInput(int i, ResultReceiver resultreceiver) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                parcel.writeInt(i);
                if(resultreceiver == null)
                    break MISSING_BLOCK_LABEL_50;
                parcel.writeInt(1);
                resultreceiver.writeToParcel(parcel, 0);
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

            public void startInput(IInputContext iinputcontext, EditorInfo editorinfo) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                if(iinputcontext != null)
                    ibinder = iinputcontext.asBinder();
                parcel.writeStrongBinder(ibinder);
                if(editorinfo == null)
                    break MISSING_BLOCK_LABEL_69;
                parcel.writeInt(1);
                editorinfo.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void unbindInput() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethod");
                mRemote.transact(3, parcel, null, 1);
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


        public static IInputMethod asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.view.IInputMethod");
                if(iinterface != null && (iinterface instanceof IInputMethod))
                    obj = (IInputMethod)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputMethod) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 12: default 112
        //                       1: 135
        //                       2: 152
        //                       3: 194
        //                       4: 207
        //                       5: 260
        //                       6: 313
        //                       7: 333
        //                       8: 376
        //                       9: 396
        //                       10: 446
        //                       11: 496
        //                       1598968902: 126;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L15:
            return flag;
_L13:
            parcel1.writeString("com.android.internal.view.IInputMethod");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            attachToken(parcel.readStrongBinder());
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            InputBinding inputbinding;
            if(parcel.readInt() != 0)
                inputbinding = (InputBinding)InputBinding.CREATOR.createFromParcel(parcel);
            else
                inputbinding = null;
            bindInput(inputbinding);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            unbindInput();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            IInputContext iinputcontext1 = IInputContext.Stub.asInterface(parcel.readStrongBinder());
            EditorInfo editorinfo1;
            if(parcel.readInt() != 0)
                editorinfo1 = (EditorInfo)EditorInfo.CREATOR.createFromParcel(parcel);
            else
                editorinfo1 = null;
            startInput(iinputcontext1, editorinfo1);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            IInputContext iinputcontext = IInputContext.Stub.asInterface(parcel.readStrongBinder());
            EditorInfo editorinfo;
            if(parcel.readInt() != 0)
                editorinfo = (EditorInfo)EditorInfo.CREATOR.createFromParcel(parcel);
            else
                editorinfo = null;
            restartInput(iinputcontext, editorinfo);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            createSession(IInputMethodCallback.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            IInputMethodSession iinputmethodsession = IInputMethodSession.Stub.asInterface(parcel.readStrongBinder());
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            setSessionEnabled(iinputmethodsession, flag1);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            revokeSession(IInputMethodSession.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            int l = parcel.readInt();
            ResultReceiver resultreceiver1;
            if(parcel.readInt() != 0)
                resultreceiver1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
            else
                resultreceiver1 = null;
            showSoftInput(l, resultreceiver1);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            int k = parcel.readInt();
            ResultReceiver resultreceiver;
            if(parcel.readInt() != 0)
                resultreceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
            else
                resultreceiver = null;
            hideSoftInput(k, resultreceiver);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.view.IInputMethod");
            InputMethodSubtype inputmethodsubtype;
            if(parcel.readInt() != 0)
                inputmethodsubtype = (InputMethodSubtype)InputMethodSubtype.CREATOR.createFromParcel(parcel);
            else
                inputmethodsubtype = null;
            changeInputMethodSubtype(inputmethodsubtype);
            if(true) goto _L15; else goto _L14
_L14:
        }

        private static final String DESCRIPTOR = "com.android.internal.view.IInputMethod";
        static final int TRANSACTION_attachToken = 1;
        static final int TRANSACTION_bindInput = 2;
        static final int TRANSACTION_changeInputMethodSubtype = 11;
        static final int TRANSACTION_createSession = 6;
        static final int TRANSACTION_hideSoftInput = 10;
        static final int TRANSACTION_restartInput = 5;
        static final int TRANSACTION_revokeSession = 8;
        static final int TRANSACTION_setSessionEnabled = 7;
        static final int TRANSACTION_showSoftInput = 9;
        static final int TRANSACTION_startInput = 4;
        static final int TRANSACTION_unbindInput = 3;

        public Stub() {
            attachInterface(this, "com.android.internal.view.IInputMethod");
        }
    }


    public abstract void attachToken(IBinder ibinder) throws RemoteException;

    public abstract void bindInput(InputBinding inputbinding) throws RemoteException;

    public abstract void changeInputMethodSubtype(InputMethodSubtype inputmethodsubtype) throws RemoteException;

    public abstract void createSession(IInputMethodCallback iinputmethodcallback) throws RemoteException;

    public abstract void hideSoftInput(int i, ResultReceiver resultreceiver) throws RemoteException;

    public abstract void restartInput(IInputContext iinputcontext, EditorInfo editorinfo) throws RemoteException;

    public abstract void revokeSession(IInputMethodSession iinputmethodsession) throws RemoteException;

    public abstract void setSessionEnabled(IInputMethodSession iinputmethodsession, boolean flag) throws RemoteException;

    public abstract void showSoftInput(int i, ResultReceiver resultreceiver) throws RemoteException;

    public abstract void startInput(IInputContext iinputcontext, EditorInfo editorinfo) throws RemoteException;

    public abstract void unbindInput() throws RemoteException;
}
