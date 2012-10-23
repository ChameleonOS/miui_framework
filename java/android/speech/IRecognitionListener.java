// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech;

import android.os.*;

public interface IRecognitionListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRecognitionListener {
        private static class Proxy
            implements IRecognitionListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.speech.IRecognitionListener";
            }

            public void onBeginningOfSpeech() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onBufferReceived(byte abyte0[]) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                parcel.writeByteArray(abyte0);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onEndOfSpeech() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onError(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                parcel.writeInt(i);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onEvent(int i, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                parcel.writeInt(i);
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

            public void onPartialResults(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
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

            public void onReadyForSpeech(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
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

            public void onResults(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_45;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
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

            public void onRmsChanged(float f) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionListener");
                parcel.writeFloat(f);
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


        public static IRecognitionListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.speech.IRecognitionListener");
                if(iinterface != null && (iinterface instanceof IRecognitionListener))
                    obj = (IRecognitionListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRecognitionListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 10: default 96
        //                       1: 119
        //                       2: 161
        //                       3: 174
        //                       4: 191
        //                       5: 208
        //                       6: 221
        //                       7: 238
        //                       8: 280
        //                       9: 322
        //                       1598968902: 110;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L13:
            return flag;
_L11:
            parcel1.writeString("android.speech.IRecognitionListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            Bundle bundle3;
            if(parcel.readInt() != 0)
                bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle3 = null;
            onReadyForSpeech(bundle3);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            onBeginningOfSpeech();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            onRmsChanged(parcel.readFloat());
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            onBufferReceived(parcel.createByteArray());
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            onEndOfSpeech();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            onError(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            Bundle bundle2;
            if(parcel.readInt() != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle2 = null;
            onResults(bundle2);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            Bundle bundle1;
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            onPartialResults(bundle1);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.speech.IRecognitionListener");
            int k = parcel.readInt();
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            onEvent(k, bundle);
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final String DESCRIPTOR = "android.speech.IRecognitionListener";
        static final int TRANSACTION_onBeginningOfSpeech = 2;
        static final int TRANSACTION_onBufferReceived = 4;
        static final int TRANSACTION_onEndOfSpeech = 5;
        static final int TRANSACTION_onError = 6;
        static final int TRANSACTION_onEvent = 9;
        static final int TRANSACTION_onPartialResults = 8;
        static final int TRANSACTION_onReadyForSpeech = 1;
        static final int TRANSACTION_onResults = 7;
        static final int TRANSACTION_onRmsChanged = 3;

        public Stub() {
            attachInterface(this, "android.speech.IRecognitionListener");
        }
    }


    public abstract void onBeginningOfSpeech() throws RemoteException;

    public abstract void onBufferReceived(byte abyte0[]) throws RemoteException;

    public abstract void onEndOfSpeech() throws RemoteException;

    public abstract void onError(int i) throws RemoteException;

    public abstract void onEvent(int i, Bundle bundle) throws RemoteException;

    public abstract void onPartialResults(Bundle bundle) throws RemoteException;

    public abstract void onReadyForSpeech(Bundle bundle) throws RemoteException;

    public abstract void onResults(Bundle bundle) throws RemoteException;

    public abstract void onRmsChanged(float f) throws RemoteException;
}
