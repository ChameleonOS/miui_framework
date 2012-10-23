// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.*;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.*;

// Referenced classes of package com.android.internal.view:
//            IInputContextCallback

public interface IInputContext
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputContext {
        private static class Proxy
            implements IInputContext {

            public IBinder asBinder() {
                return mRemote;
            }

            public void beginBatchEdit() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                mRemote.transact(14, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void clearMetaKeyStates(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                mRemote.transact(18, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void commitCompletion(CompletionInfo completioninfo) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                if(completioninfo == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                completioninfo.writeToParcel(parcel, 0);
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

            public void commitCorrection(CorrectionInfo correctioninfo) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                if(correctioninfo == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                correctioninfo.writeToParcel(parcel, 0);
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

            public void commitText(CharSequence charsequence, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                if(charsequence == null)
                    break MISSING_BLOCK_LABEL_50;
                parcel.writeInt(1);
                TextUtils.writeToParcel(charsequence, parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void deleteSurroundingText(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void endBatchEdit() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                mRemote.transact(15, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void finishComposingText() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void getCursorCapsMode(int i, int j, IInputContextCallback iinputcontextcallback) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                parcel.writeInt(j);
                if(iinputcontextcallback != null)
                    ibinder = iinputcontextcallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void getExtractedText(ExtractedTextRequest extractedtextrequest, int i, int j, IInputContextCallback iinputcontextcallback) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                if(extractedtextrequest == null)
                    break MISSING_BLOCK_LABEL_86;
                parcel.writeInt(1);
                extractedtextrequest.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                parcel.writeInt(j);
                if(iinputcontextcallback != null)
                    ibinder = iinputcontextcallback.asBinder();
                parcel.writeStrongBinder(ibinder);
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

            public String getInterfaceDescriptor() {
                return "com.android.internal.view.IInputContext";
            }

            public void getSelectedText(int i, int j, IInputContextCallback iinputcontextcallback) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                parcel.writeInt(j);
                if(iinputcontextcallback != null)
                    ibinder = iinputcontextcallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(21, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void getTextAfterCursor(int i, int j, int k, IInputContextCallback iinputcontextcallback) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(iinputcontextcallback != null)
                    ibinder = iinputcontextcallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void getTextBeforeCursor(int i, int j, int k, IInputContextCallback iinputcontextcallback) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(iinputcontextcallback != null)
                    ibinder = iinputcontextcallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void performContextMenuAction(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                mRemote.transact(13, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void performEditorAction(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                mRemote.transact(12, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void performPrivateCommand(String s, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_50;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(19, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void reportFullscreenMode(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(16, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void sendKeyEvent(KeyEvent keyevent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                if(keyevent == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                keyevent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(17, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setComposingRegion(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(20, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setComposingText(CharSequence charsequence, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                if(charsequence == null)
                    break MISSING_BLOCK_LABEL_50;
                parcel.writeInt(1);
                TextUtils.writeToParcel(charsequence, parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setSelection(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContext");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(11, parcel, null, 1);
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


        public static IInputContext asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.view.IInputContext");
                if(iinterface != null && (iinterface instanceof IInputContext))
                    obj = (IInputContext)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputContext) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 22: default 192
        //                       1: 215
        //                       2: 247
        //                       3: 279
        //                       4: 307
        //                       5: 364
        //                       6: 385
        //                       7: 431
        //                       8: 444
        //                       9: 490
        //                       10: 532
        //                       11: 574
        //                       12: 595
        //                       13: 612
        //                       14: 629
        //                       15: 642
        //                       16: 655
        //                       17: 687
        //                       18: 729
        //                       19: 746
        //                       20: 796
        //                       21: 817
        //                       1598968902: 206;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L25:
            return flag;
_L23:
            parcel1.writeString("com.android.internal.view.IInputContext");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            getTextBeforeCursor(parcel.readInt(), parcel.readInt(), parcel.readInt(), IInputContextCallback.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            getTextAfterCursor(parcel.readInt(), parcel.readInt(), parcel.readInt(), IInputContextCallback.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            getCursorCapsMode(parcel.readInt(), parcel.readInt(), IInputContextCallback.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            ExtractedTextRequest extractedtextrequest;
            if(parcel.readInt() != 0)
                extractedtextrequest = (ExtractedTextRequest)ExtractedTextRequest.CREATOR.createFromParcel(parcel);
            else
                extractedtextrequest = null;
            getExtractedText(extractedtextrequest, parcel.readInt(), parcel.readInt(), IInputContextCallback.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            deleteSurroundingText(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            CharSequence charsequence1;
            if(parcel.readInt() != 0)
                charsequence1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            else
                charsequence1 = null;
            setComposingText(charsequence1, parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            finishComposingText();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            CharSequence charsequence;
            if(parcel.readInt() != 0)
                charsequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            else
                charsequence = null;
            commitText(charsequence, parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            CompletionInfo completioninfo;
            if(parcel.readInt() != 0)
                completioninfo = (CompletionInfo)CompletionInfo.CREATOR.createFromParcel(parcel);
            else
                completioninfo = null;
            commitCompletion(completioninfo);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            CorrectionInfo correctioninfo;
            if(parcel.readInt() != 0)
                correctioninfo = (CorrectionInfo)CorrectionInfo.CREATOR.createFromParcel(parcel);
            else
                correctioninfo = null;
            commitCorrection(correctioninfo);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            setSelection(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            performEditorAction(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            performContextMenuAction(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            beginBatchEdit();
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            endBatchEdit();
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            reportFullscreenMode(flag1);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            KeyEvent keyevent;
            if(parcel.readInt() != 0)
                keyevent = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel);
            else
                keyevent = null;
            sendKeyEvent(keyevent);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            clearMetaKeyStates(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            String s = parcel.readString();
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            performPrivateCommand(s, bundle);
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            setComposingRegion(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("com.android.internal.view.IInputContext");
            getSelectedText(parcel.readInt(), parcel.readInt(), IInputContextCallback.Stub.asInterface(parcel.readStrongBinder()));
            if(true) goto _L25; else goto _L24
_L24:
        }

        private static final String DESCRIPTOR = "com.android.internal.view.IInputContext";
        static final int TRANSACTION_beginBatchEdit = 14;
        static final int TRANSACTION_clearMetaKeyStates = 18;
        static final int TRANSACTION_commitCompletion = 9;
        static final int TRANSACTION_commitCorrection = 10;
        static final int TRANSACTION_commitText = 8;
        static final int TRANSACTION_deleteSurroundingText = 5;
        static final int TRANSACTION_endBatchEdit = 15;
        static final int TRANSACTION_finishComposingText = 7;
        static final int TRANSACTION_getCursorCapsMode = 3;
        static final int TRANSACTION_getExtractedText = 4;
        static final int TRANSACTION_getSelectedText = 21;
        static final int TRANSACTION_getTextAfterCursor = 2;
        static final int TRANSACTION_getTextBeforeCursor = 1;
        static final int TRANSACTION_performContextMenuAction = 13;
        static final int TRANSACTION_performEditorAction = 12;
        static final int TRANSACTION_performPrivateCommand = 19;
        static final int TRANSACTION_reportFullscreenMode = 16;
        static final int TRANSACTION_sendKeyEvent = 17;
        static final int TRANSACTION_setComposingRegion = 20;
        static final int TRANSACTION_setComposingText = 6;
        static final int TRANSACTION_setSelection = 11;

        public Stub() {
            attachInterface(this, "com.android.internal.view.IInputContext");
        }
    }


    public abstract void beginBatchEdit() throws RemoteException;

    public abstract void clearMetaKeyStates(int i) throws RemoteException;

    public abstract void commitCompletion(CompletionInfo completioninfo) throws RemoteException;

    public abstract void commitCorrection(CorrectionInfo correctioninfo) throws RemoteException;

    public abstract void commitText(CharSequence charsequence, int i) throws RemoteException;

    public abstract void deleteSurroundingText(int i, int j) throws RemoteException;

    public abstract void endBatchEdit() throws RemoteException;

    public abstract void finishComposingText() throws RemoteException;

    public abstract void getCursorCapsMode(int i, int j, IInputContextCallback iinputcontextcallback) throws RemoteException;

    public abstract void getExtractedText(ExtractedTextRequest extractedtextrequest, int i, int j, IInputContextCallback iinputcontextcallback) throws RemoteException;

    public abstract void getSelectedText(int i, int j, IInputContextCallback iinputcontextcallback) throws RemoteException;

    public abstract void getTextAfterCursor(int i, int j, int k, IInputContextCallback iinputcontextcallback) throws RemoteException;

    public abstract void getTextBeforeCursor(int i, int j, int k, IInputContextCallback iinputcontextcallback) throws RemoteException;

    public abstract void performContextMenuAction(int i) throws RemoteException;

    public abstract void performEditorAction(int i) throws RemoteException;

    public abstract void performPrivateCommand(String s, Bundle bundle) throws RemoteException;

    public abstract void reportFullscreenMode(boolean flag) throws RemoteException;

    public abstract void sendKeyEvent(KeyEvent keyevent) throws RemoteException;

    public abstract void setComposingRegion(int i, int j) throws RemoteException;

    public abstract void setComposingText(CharSequence charsequence, int i) throws RemoteException;

    public abstract void setSelection(int i, int j) throws RemoteException;
}
