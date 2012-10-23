// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech;

import android.content.Intent;
import android.os.*;

// Referenced classes of package android.speech:
//            IRecognitionListener

public interface IRecognitionService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRecognitionService {
        private static class Proxy
            implements IRecognitionService {

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancel(IRecognitionListener irecognitionlistener) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionService");
                if(irecognitionlistener != null)
                    ibinder = irecognitionlistener.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.speech.IRecognitionService";
            }

            public void startListening(Intent intent, IRecognitionListener irecognitionlistener) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionService");
                if(intent == null)
                    break MISSING_BLOCK_LABEL_69;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L1:
                if(irecognitionlistener != null)
                    ibinder = irecognitionlistener.asBinder();
                parcel.writeStrongBinder(ibinder);
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

            public void stopListening(IRecognitionListener irecognitionlistener) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.speech.IRecognitionService");
                if(irecognitionlistener != null)
                    ibinder = irecognitionlistener.asBinder();
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


        public static IRecognitionService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.speech.IRecognitionService");
                if(iinterface != null && (iinterface instanceof IRecognitionService))
                    obj = (IRecognitionService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRecognitionService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 120
        //                       3: 140
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.speech.IRecognitionService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.speech.IRecognitionService");
            Intent intent;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            startListening(intent, IRecognitionListener.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.speech.IRecognitionService");
            stopListening(IRecognitionListener.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.speech.IRecognitionService");
            cancel(IRecognitionListener.Stub.asInterface(parcel.readStrongBinder()));
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.speech.IRecognitionService";
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_startListening = 1;
        static final int TRANSACTION_stopListening = 2;

        public Stub() {
            attachInterface(this, "android.speech.IRecognitionService");
        }
    }


    public abstract void cancel(IRecognitionListener irecognitionlistener) throws RemoteException;

    public abstract void startListening(Intent intent, IRecognitionListener irecognitionlistener) throws RemoteException;

    public abstract void stopListening(IRecognitionListener irecognitionlistener) throws RemoteException;
}
