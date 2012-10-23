// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.*;
import android.text.TextUtils;
import android.view.inputmethod.ExtractedText;

public interface IInputContextCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInputContextCallback {
        private static class Proxy
            implements IInputContextCallback {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.view.IInputContextCallback";
            }

            public void setCursorCapsMode(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContextCallback");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setExtractedText(ExtractedText extractedtext, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContextCallback");
                if(extractedtext == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                extractedtext.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void setSelectedText(CharSequence charsequence, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContextCallback");
                if(charsequence == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                TextUtils.writeToParcel(charsequence, parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void setTextAfterCursor(CharSequence charsequence, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContextCallback");
                if(charsequence == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                TextUtils.writeToParcel(charsequence, parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void setTextBeforeCursor(CharSequence charsequence, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.view.IInputContextCallback");
                if(charsequence == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                TextUtils.writeToParcel(charsequence, parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
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


        public static IInputContextCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.view.IInputContextCallback");
                if(iinterface != null && (iinterface instanceof IInputContextCallback))
                    obj = (IInputContextCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInputContextCallback) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 133
        //                       3: 179
        //                       4: 200
        //                       5: 246
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("com.android.internal.view.IInputContextCallback");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.view.IInputContextCallback");
            CharSequence charsequence2;
            if(parcel.readInt() != 0)
                charsequence2 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            else
                charsequence2 = null;
            setTextBeforeCursor(charsequence2, parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.view.IInputContextCallback");
            CharSequence charsequence1;
            if(parcel.readInt() != 0)
                charsequence1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            else
                charsequence1 = null;
            setTextAfterCursor(charsequence1, parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.view.IInputContextCallback");
            setCursorCapsMode(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.view.IInputContextCallback");
            ExtractedText extractedtext;
            if(parcel.readInt() != 0)
                extractedtext = (ExtractedText)ExtractedText.CREATOR.createFromParcel(parcel);
            else
                extractedtext = null;
            setExtractedText(extractedtext, parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.view.IInputContextCallback");
            CharSequence charsequence;
            if(parcel.readInt() != 0)
                charsequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            else
                charsequence = null;
            setSelectedText(charsequence, parcel.readInt());
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "com.android.internal.view.IInputContextCallback";
        static final int TRANSACTION_setCursorCapsMode = 3;
        static final int TRANSACTION_setExtractedText = 4;
        static final int TRANSACTION_setSelectedText = 5;
        static final int TRANSACTION_setTextAfterCursor = 2;
        static final int TRANSACTION_setTextBeforeCursor = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.view.IInputContextCallback");
        }
    }


    public abstract void setCursorCapsMode(int i, int j) throws RemoteException;

    public abstract void setExtractedText(ExtractedText extractedtext, int i) throws RemoteException;

    public abstract void setSelectedText(CharSequence charsequence, int i) throws RemoteException;

    public abstract void setTextAfterCursor(CharSequence charsequence, int i) throws RemoteException;

    public abstract void setTextBeforeCursor(CharSequence charsequence, int i) throws RemoteException;
}
