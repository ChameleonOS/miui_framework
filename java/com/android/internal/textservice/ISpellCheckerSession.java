// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.textservice;

import android.os.*;
import android.view.textservice.TextInfo;

public interface ISpellCheckerSession
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISpellCheckerSession {
        private static class Proxy
            implements ISpellCheckerSession {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.textservice.ISpellCheckerSession";
            }

            public void onCancel() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ISpellCheckerSession");
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onClose() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ISpellCheckerSession");
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onGetSentenceSuggestionsMultiple(TextInfo atextinfo[], int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ISpellCheckerSession");
                parcel.writeTypedArray(atextinfo, 0);
                parcel.writeInt(i);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onGetSuggestionsMultiple(TextInfo atextinfo[], int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                j = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ISpellCheckerSession");
                parcel.writeTypedArray(atextinfo, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ISpellCheckerSession asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.textservice.ISpellCheckerSession");
                if(iinterface != null && (iinterface instanceof ISpellCheckerSession))
                    obj = (ISpellCheckerSession)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISpellCheckerSession) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 133
        //                       3: 160
        //                       4: 173
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("com.android.internal.textservice.ISpellCheckerSession");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.textservice.ISpellCheckerSession");
            TextInfo atextinfo[] = (TextInfo[])parcel.createTypedArray(TextInfo.CREATOR);
            int k = parcel.readInt();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            onGetSuggestionsMultiple(atextinfo, k, flag1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.textservice.ISpellCheckerSession");
            onGetSentenceSuggestionsMultiple((TextInfo[])parcel.createTypedArray(TextInfo.CREATOR), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.textservice.ISpellCheckerSession");
            onCancel();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.textservice.ISpellCheckerSession");
            onClose();
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "com.android.internal.textservice.ISpellCheckerSession";
        static final int TRANSACTION_onCancel = 3;
        static final int TRANSACTION_onClose = 4;
        static final int TRANSACTION_onGetSentenceSuggestionsMultiple = 2;
        static final int TRANSACTION_onGetSuggestionsMultiple = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.textservice.ISpellCheckerSession");
        }
    }


    public abstract void onCancel() throws RemoteException;

    public abstract void onClose() throws RemoteException;

    public abstract void onGetSentenceSuggestionsMultiple(TextInfo atextinfo[], int i) throws RemoteException;

    public abstract void onGetSuggestionsMultiple(TextInfo atextinfo[], int i, boolean flag) throws RemoteException;
}
