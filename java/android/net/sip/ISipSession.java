// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;

import android.os.*;

// Referenced classes of package android.net.sip:
//            SipProfile, ISipSessionListener

public interface ISipSession
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISipSession {
        private static class Proxy
            implements ISipSession {

            public void answerCall(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public void changeCall(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void endCall() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getCallId() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.net.sip.ISipSession";
            }

            public String getLocalIp() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public SipProfile getLocalProfile() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                SipProfile sipprofile = (SipProfile)SipProfile.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return sipprofile;
_L2:
                sipprofile = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public SipProfile getPeerProfile() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                SipProfile sipprofile = (SipProfile)SipProfile.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return sipprofile;
_L2:
                sipprofile = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getState() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isInCall() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void makeCall(SipProfile sipprofile, String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                if(sipprofile == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                sipprofile.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void register(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setListener(ISipSessionListener isipsessionlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                if(isipsessionlistener == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = isipsessionlistener.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
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

            public void unregister() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipSession");
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
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


        public static ISipSession asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.sip.ISipSession");
                if(iinterface != null && (iinterface instanceof ISipSession))
                    obj = (ISipSession)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISipSession) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            int k;
            boolean flag;
            k = 0;
            flag = true;
            i;
            JVM INSTR lookupswitch 14: default 128
        //                       1: 151
        //                       2: 176
        //                       3: 222
        //                       4: 268
        //                       5: 293
        //                       6: 327
        //                       7: 352
        //                       8: 376
        //                       9: 397
        //                       10: 414
        //                       11: 468
        //                       12: 493
        //                       13: 510
        //                       1598968902: 142;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L17:
            return flag;
_L15:
            parcel1.writeString("android.net.sip.ISipSession");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.sip.ISipSession");
            String s1 = getLocalIp();
            parcel1.writeNoException();
            parcel1.writeString(s1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.sip.ISipSession");
            SipProfile sipprofile2 = getLocalProfile();
            parcel1.writeNoException();
            if(sipprofile2 != null) {
                parcel1.writeInt(flag);
                sipprofile2.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.sip.ISipSession");
            SipProfile sipprofile1 = getPeerProfile();
            parcel1.writeNoException();
            if(sipprofile1 != null) {
                parcel1.writeInt(flag);
                sipprofile1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.sip.ISipSession");
            int l = getState();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.sip.ISipSession");
            boolean flag1 = isInCall();
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.net.sip.ISipSession");
            String s = getCallId();
            parcel1.writeNoException();
            parcel1.writeString(s);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.net.sip.ISipSession");
            setListener(ISipSessionListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.net.sip.ISipSession");
            register(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.net.sip.ISipSession");
            unregister();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.net.sip.ISipSession");
            SipProfile sipprofile;
            if(parcel.readInt() != 0)
                sipprofile = (SipProfile)SipProfile.CREATOR.createFromParcel(parcel);
            else
                sipprofile = null;
            makeCall(sipprofile, parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.net.sip.ISipSession");
            answerCall(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.net.sip.ISipSession");
            endCall();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.net.sip.ISipSession");
            changeCall(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            if(true) goto _L17; else goto _L16
_L16:
        }

        private static final String DESCRIPTOR = "android.net.sip.ISipSession";
        static final int TRANSACTION_answerCall = 11;
        static final int TRANSACTION_changeCall = 13;
        static final int TRANSACTION_endCall = 12;
        static final int TRANSACTION_getCallId = 6;
        static final int TRANSACTION_getLocalIp = 1;
        static final int TRANSACTION_getLocalProfile = 2;
        static final int TRANSACTION_getPeerProfile = 3;
        static final int TRANSACTION_getState = 4;
        static final int TRANSACTION_isInCall = 5;
        static final int TRANSACTION_makeCall = 10;
        static final int TRANSACTION_register = 8;
        static final int TRANSACTION_setListener = 7;
        static final int TRANSACTION_unregister = 9;

        public Stub() {
            attachInterface(this, "android.net.sip.ISipSession");
        }
    }


    public abstract void answerCall(String s, int i) throws RemoteException;

    public abstract void changeCall(String s, int i) throws RemoteException;

    public abstract void endCall() throws RemoteException;

    public abstract String getCallId() throws RemoteException;

    public abstract String getLocalIp() throws RemoteException;

    public abstract SipProfile getLocalProfile() throws RemoteException;

    public abstract SipProfile getPeerProfile() throws RemoteException;

    public abstract int getState() throws RemoteException;

    public abstract boolean isInCall() throws RemoteException;

    public abstract void makeCall(SipProfile sipprofile, String s, int i) throws RemoteException;

    public abstract void register(int i) throws RemoteException;

    public abstract void setListener(ISipSessionListener isipsessionlistener) throws RemoteException;

    public abstract void unregister() throws RemoteException;
}
