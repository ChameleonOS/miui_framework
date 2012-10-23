// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.os.*;

public interface ITextToSpeechCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ITextToSpeechCallback {
        private static class Proxy
            implements ITextToSpeechCallback {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.speech.tts.ITextToSpeechCallback";
            }

            public void onDone(String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechCallback");
                parcel.writeString(s);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onError(String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechCallback");
                parcel.writeString(s);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onStart(String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.tts.ITextToSpeechCallback");
                parcel.writeString(s);
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


        public static ITextToSpeechCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.speech.tts.ITextToSpeechCallback");
                if(iinterface != null && (iinterface instanceof ITextToSpeechCallback))
                    obj = (ITextToSpeechCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ITextToSpeechCallback) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 88
        //                       3: 105
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.speech.tts.ITextToSpeechCallback");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechCallback");
            onStart(parcel.readString());
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechCallback");
            onDone(parcel.readString());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.speech.tts.ITextToSpeechCallback");
            onError(parcel.readString());
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.speech.tts.ITextToSpeechCallback";
        static final int TRANSACTION_onDone = 2;
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onStart = 1;

        public Stub() {
            attachInterface(this, "android.speech.tts.ITextToSpeechCallback");
        }
    }


    public abstract void onDone(String s) throws RemoteException;

    public abstract void onError(String s) throws RemoteException;

    public abstract void onStart(String s) throws RemoteException;
}
