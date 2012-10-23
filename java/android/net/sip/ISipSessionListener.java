// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;

import android.os.*;

// Referenced classes of package android.net.sip:
//            ISipSession, SipProfile

public interface ISipSessionListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISipSessionListener {
        private static class Proxy
            implements ISipSessionListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.net.sip.ISipSessionListener";
            }

            public void onCallBusy(ISipSession isipsession) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onCallChangeFailed(ISipSession isipsession, int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onCallEnded(ISipSession isipsession) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onCallEstablished(ISipSession isipsession, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_68;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onCallTransferring(ISipSession isipsession, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onCalling(ISipSession isipsession) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onError(ISipSession isipsession, int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onRegistering(ISipSession isipsession) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onRegistrationDone(ISipSession isipsession, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onRegistrationFailed(ISipSession isipsession, int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onRegistrationTimeout(ISipSession isipsession) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void onRinging(ISipSession isipsession, SipProfile sipprofile, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = isipsession.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                if(sipprofile == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                sipprofile.writeToParcel(parcel, 0);
_L6:
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public void onRingingBack(ISipSession isipsession) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSessionListener");
                if(isipsession == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = isipsession.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ISipSessionListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.sip.ISipSessionListener");
                if(iinterface != null && (iinterface instanceof ISipSessionListener))
                    obj = (ISipSessionListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISipSessionListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 14: default 128
        //                       1: 151
        //                       2: 175
        //                       3: 236
        //                       4: 260
        //                       5: 288
        //                       6: 312
        //                       7: 336
        //                       8: 364
        //                       9: 396
        //                       10: 428
        //                       11: 452
        //                       12: 480
        //                       13: 512
        //                       1598968902: 142;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L17:
            return flag;
_L15:
            parcel1.writeString("android.net.sip.ISipSessionListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onCalling(ISipSession.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            ISipSession isipsession = ISipSession.Stub.asInterface(parcel.readStrongBinder());
            SipProfile sipprofile;
            if(parcel.readInt() != 0)
                sipprofile = (SipProfile)SipProfile.CREATOR.createFromParcel(parcel);
            else
                sipprofile = null;
            onRinging(isipsession, sipprofile, parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onRingingBack(ISipSession.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onCallEstablished(ISipSession.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onCallEnded(ISipSession.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onCallBusy(ISipSession.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onCallTransferring(ISipSession.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onError(ISipSession.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onCallChangeFailed(ISipSession.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onRegistering(ISipSession.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onRegistrationDone(ISipSession.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onRegistrationFailed(ISipSession.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.net.sip.ISipSessionListener");
            onRegistrationTimeout(ISipSession.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(true) goto _L17; else goto _L16
_L16:
        }

        private static final String DESCRIPTOR = "android.net.sip.ISipSessionListener";
        static final int TRANSACTION_onCallBusy = 6;
        static final int TRANSACTION_onCallChangeFailed = 9;
        static final int TRANSACTION_onCallEnded = 5;
        static final int TRANSACTION_onCallEstablished = 4;
        static final int TRANSACTION_onCallTransferring = 7;
        static final int TRANSACTION_onCalling = 1;
        static final int TRANSACTION_onError = 8;
        static final int TRANSACTION_onRegistering = 10;
        static final int TRANSACTION_onRegistrationDone = 11;
        static final int TRANSACTION_onRegistrationFailed = 12;
        static final int TRANSACTION_onRegistrationTimeout = 13;
        static final int TRANSACTION_onRinging = 2;
        static final int TRANSACTION_onRingingBack = 3;

        public Stub() {
            attachInterface(this, "android.net.sip.ISipSessionListener");
        }
    }


    public abstract void onCallBusy(ISipSession isipsession) throws RemoteException;

    public abstract void onCallChangeFailed(ISipSession isipsession, int i, String s) throws RemoteException;

    public abstract void onCallEnded(ISipSession isipsession) throws RemoteException;

    public abstract void onCallEstablished(ISipSession isipsession, String s) throws RemoteException;

    public abstract void onCallTransferring(ISipSession isipsession, String s) throws RemoteException;

    public abstract void onCalling(ISipSession isipsession) throws RemoteException;

    public abstract void onError(ISipSession isipsession, int i, String s) throws RemoteException;

    public abstract void onRegistering(ISipSession isipsession) throws RemoteException;

    public abstract void onRegistrationDone(ISipSession isipsession, int i) throws RemoteException;

    public abstract void onRegistrationFailed(ISipSession isipsession, int i, String s) throws RemoteException;

    public abstract void onRegistrationTimeout(ISipSession isipsession) throws RemoteException;

    public abstract void onRinging(ISipSession isipsession, SipProfile sipprofile, String s) throws RemoteException;

    public abstract void onRingingBack(ISipSession isipsession) throws RemoteException;
}
