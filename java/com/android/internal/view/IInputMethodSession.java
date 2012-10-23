// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.graphics.Rect;
import android.os.*;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.ExtractedText;

// Referenced classes of package com.android.internal.view:
//            IInputMethodCallback

public interface IInputMethodSession
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputMethodSession {
        private static class Proxy
            implements IInputMethodSession {

            public void appPrivateCommand(String s, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_50;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void dispatchKeyEvent(int i, KeyEvent keyevent, IInputMethodCallback iinputmethodcallback) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                parcel.writeInt(i);
                if(keyevent == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                keyevent.writeToParcel(parcel, 0);
_L1:
                if(iinputmethodcallback != null)
                    ibinder = iinputmethodcallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchTrackballEvent(int i, MotionEvent motionevent, IInputMethodCallback iinputmethodcallback) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                parcel.writeInt(i);
                if(motionevent == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                motionevent.writeToParcel(parcel, 0);
_L1:
                if(iinputmethodcallback != null)
                    ibinder = iinputmethodcallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(8, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void displayCompletions(CompletionInfo acompletioninfo[]) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                parcel.writeTypedArray(acompletioninfo, 0);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void finishInput() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void finishSession() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                mRemote.transact(11, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.view.IInputMethodSession";
            }

            public void toggleSoftInput(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(10, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void updateCursor(Rect rect) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                if(rect == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                rect.writeToParcel(parcel, 0);
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

            public void updateExtractedText(int i, ExtractedText extractedtext) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                parcel.writeInt(i);
                if(extractedtext == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                extractedtext.writeToParcel(parcel, 0);
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

            public void updateSelection(int i, int j, int k, int l, int i1, int j1) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void viewClicked(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputMethodSession");
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IInputMethodSession asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.view.IInputMethodSession");
                if(iinterface != null && (iinterface instanceof IInputMethodSession))
                    obj = (IInputMethodSession)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputMethodSession) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 12: default 112
        //                       1: 135
        //                       2: 148
        //                       3: 198
        //                       4: 235
        //                       5: 267
        //                       6: 309
        //                       7: 332
        //                       8: 389
        //                       9: 446
        //                       10: 496
        //                       11: 517
        //                       1598968902: 126;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L15:
            return flag;
_L13:
            parcel1.writeString("com.android.internal.view.IInputMethodSession");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            finishInput();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            int i1 = parcel.readInt();
            ExtractedText extractedtext;
            if(parcel.readInt() != 0)
                extractedtext = (ExtractedText)ExtractedText.CREATOR.createFromParcel(parcel);
            else
                extractedtext = null;
            updateExtractedText(i1, extractedtext);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            updateSelection(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            viewClicked(flag1);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            Rect rect;
            if(parcel.readInt() != 0)
                rect = (Rect)Rect.CREATOR.createFromParcel(parcel);
            else
                rect = null;
            updateCursor(rect);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            displayCompletions((CompletionInfo[])parcel.createTypedArray(CompletionInfo.CREATOR));
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            int l = parcel.readInt();
            KeyEvent keyevent;
            if(parcel.readInt() != 0)
                keyevent = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel);
            else
                keyevent = null;
            dispatchKeyEvent(l, keyevent, IInputMethodCallback.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            int k = parcel.readInt();
            MotionEvent motionevent;
            if(parcel.readInt() != 0)
                motionevent = (MotionEvent)MotionEvent.CREATOR.createFromParcel(parcel);
            else
                motionevent = null;
            dispatchTrackballEvent(k, motionevent, IInputMethodCallback.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            String s = parcel.readString();
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            appPrivateCommand(s, bundle);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            toggleSoftInput(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.view.IInputMethodSession");
            finishSession();
            if(true) goto _L15; else goto _L14
_L14:
        }

        private static final String DESCRIPTOR = "com.android.internal.view.IInputMethodSession";
        static final int TRANSACTION_appPrivateCommand = 9;
        static final int TRANSACTION_dispatchKeyEvent = 7;
        static final int TRANSACTION_dispatchTrackballEvent = 8;
        static final int TRANSACTION_displayCompletions = 6;
        static final int TRANSACTION_finishInput = 1;
        static final int TRANSACTION_finishSession = 11;
        static final int TRANSACTION_toggleSoftInput = 10;
        static final int TRANSACTION_updateCursor = 5;
        static final int TRANSACTION_updateExtractedText = 2;
        static final int TRANSACTION_updateSelection = 3;
        static final int TRANSACTION_viewClicked = 4;

        public Stub() {
            attachInterface(this, "com.android.internal.view.IInputMethodSession");
        }
    }


    public abstract void appPrivateCommand(String s, Bundle bundle) throws RemoteException;

    public abstract void dispatchKeyEvent(int i, KeyEvent keyevent, IInputMethodCallback iinputmethodcallback) throws RemoteException;

    public abstract void dispatchTrackballEvent(int i, MotionEvent motionevent, IInputMethodCallback iinputmethodcallback) throws RemoteException;

    public abstract void displayCompletions(CompletionInfo acompletioninfo[]) throws RemoteException;

    public abstract void finishInput() throws RemoteException;

    public abstract void finishSession() throws RemoteException;

    public abstract void toggleSoftInput(int i, int j) throws RemoteException;

    public abstract void updateCursor(Rect rect) throws RemoteException;

    public abstract void updateExtractedText(int i, ExtractedText extractedtext) throws RemoteException;

    public abstract void updateSelection(int i, int j, int k, int l, int i1, int j1) throws RemoteException;

    public abstract void viewClicked(boolean flag) throws RemoteException;
}
