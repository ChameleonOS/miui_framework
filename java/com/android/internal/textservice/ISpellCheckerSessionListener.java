// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.textservice;

import android.os.*;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SuggestionsInfo;

public interface ISpellCheckerSessionListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISpellCheckerSessionListener {
        private static class Proxy
            implements ISpellCheckerSessionListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.textservice.ISpellCheckerSessionListener";
            }

            public void onGetSentenceSuggestions(SentenceSuggestionsInfo asentencesuggestionsinfo[]) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ISpellCheckerSessionListener");
                parcel.writeTypedArray(asentencesuggestionsinfo, 0);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onGetSuggestions(SuggestionsInfo asuggestionsinfo[]) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.textservice.ISpellCheckerSessionListener");
                parcel.writeTypedArray(asuggestionsinfo, 0);
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


        public static ISpellCheckerSessionListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.textservice.ISpellCheckerSessionListener");
                if(iinterface != null && (iinterface instanceof ISpellCheckerSessionListener))
                    obj = (ISpellCheckerSessionListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISpellCheckerSessionListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 86
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("com.android.internal.textservice.ISpellCheckerSessionListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.textservice.ISpellCheckerSessionListener");
            onGetSuggestions((SuggestionsInfo[])parcel.createTypedArray(SuggestionsInfo.CREATOR));
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.textservice.ISpellCheckerSessionListener");
            onGetSentenceSuggestions((SentenceSuggestionsInfo[])parcel.createTypedArray(SentenceSuggestionsInfo.CREATOR));
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "com.android.internal.textservice.ISpellCheckerSessionListener";
        static final int TRANSACTION_onGetSentenceSuggestions = 2;
        static final int TRANSACTION_onGetSuggestions = 1;

        public Stub() {
            attachInterface(this, "com.android.internal.textservice.ISpellCheckerSessionListener");
        }
    }


    public abstract void onGetSentenceSuggestions(SentenceSuggestionsInfo asentencesuggestionsinfo[]) throws RemoteException;

    public abstract void onGetSuggestions(SuggestionsInfo asuggestionsinfo[]) throws RemoteException;
}
