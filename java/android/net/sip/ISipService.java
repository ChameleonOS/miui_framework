// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;

import android.app.PendingIntent;
import android.os.*;

// Referenced classes of package android.net.sip:
//            SipProfile, ISipSessionListener, ISipSession

public interface ISipService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISipService {
        private static class Proxy
            implements ISipService {

            public IBinder asBinder() {
                return mRemote;
            }

            public void close(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                parcel.writeString(s);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public ISipSession createSession(SipProfile sipprofile, ISipSessionListener isipsessionlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                if(sipprofile == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                sipprofile.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                if(isipsessionlistener == null)
                    break MISSING_BLOCK_LABEL_113;
                ibinder = isipsessionlistener.asBinder();
_L4:
                ISipSession isipsession;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                isipsession = ISipSession.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return isipsession;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                ibinder = null;
                  goto _L4
            }

            public String getInterfaceDescriptor() {
                return "android.net.sip.ISipService";
            }

            public SipProfile[] getListOfProfiles() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                SipProfile asipprofile[];
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                asipprofile = (SipProfile[])parcel1.createTypedArray(SipProfile.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return asipprofile;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ISipSession getPendingSession(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ISipSession isipsession;
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                parcel.writeString(s);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                isipsession = ISipSession.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return isipsession;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isOpened(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                parcel.writeString(s);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public boolean isRegistered(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                parcel.writeString(s);
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

            public void open(SipProfile sipprofile) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                if(sipprofile == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                sipprofile.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, parcel1, 0);
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

            public void open3(SipProfile sipprofile, PendingIntent pendingintent, ISipSessionListener isipsessionlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                if(sipprofile == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                sipprofile.writeToParcel(parcel, 0);
_L5:
                if(pendingintent == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
_L6:
                IBinder ibinder;
                if(isipsessionlistener == null)
                    break MISSING_BLOCK_LABEL_135;
                ibinder = isipsessionlistener.asBinder();
_L7:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L5
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L4:
                parcel.writeInt(0);
                  goto _L6
                ibinder = null;
                  goto _L7
            }

            public void setRegistrationListener(String s, ISipSessionListener isipsessionlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.net.sip.ISipService");
                parcel.writeString(s);
                if(isipsessionlistener == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = isipsessionlistener.asBinder();
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static ISipService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.net.sip.ISipService");
                if(iinterface != null && (iinterface instanceof ISipService))
                    obj = (ISipService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISipService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            IBinder ibinder;
            int k;
            boolean flag;
            ibinder = null;
            k = 0;
            flag = true;
            i;
            JVM INSTR lookupswitch 10: default 100
        //                       1: 123
        //                       2: 169
        //                       3: 251
        //                       4: 272
        //                       5: 310
        //                       6: 348
        //                       7: 376
        //                       8: 457
        //                       9: 500
        //                       1598968902: 114;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L13:
            return flag;
_L11:
            parcel1.writeString("android.net.sip.ISipService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.net.sip.ISipService");
            SipProfile sipprofile2;
            if(parcel.readInt() != 0)
                sipprofile2 = (SipProfile)SipProfile.CREATOR.createFromParcel(parcel);
            else
                sipprofile2 = null;
            open(sipprofile2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.net.sip.ISipService");
            SipProfile sipprofile1;
            PendingIntent pendingintent;
            if(parcel.readInt() != 0)
                sipprofile1 = (SipProfile)SipProfile.CREATOR.createFromParcel(parcel);
            else
                sipprofile1 = null;
            if(parcel.readInt() != 0)
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent = null;
            open3(sipprofile1, pendingintent, ISipSessionListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.net.sip.ISipService");
            close(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.net.sip.ISipService");
            boolean flag2 = isOpened(parcel.readString());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.net.sip.ISipService");
            boolean flag1 = isRegistered(parcel.readString());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.net.sip.ISipService");
            setRegistrationListener(parcel.readString(), ISipSessionListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.net.sip.ISipService");
            SipProfile sipprofile;
            ISipSession isipsession1;
            IBinder ibinder1;
            if(parcel.readInt() != 0)
                sipprofile = (SipProfile)SipProfile.CREATOR.createFromParcel(parcel);
            else
                sipprofile = null;
            isipsession1 = createSession(sipprofile, ISipSessionListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(isipsession1 != null)
                ibinder1 = isipsession1.asBinder();
            else
                ibinder1 = null;
            parcel1.writeStrongBinder(ibinder1);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.net.sip.ISipService");
            ISipSession isipsession = getPendingSession(parcel.readString());
            parcel1.writeNoException();
            if(isipsession != null)
                ibinder = isipsession.asBinder();
            parcel1.writeStrongBinder(ibinder);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.net.sip.ISipService");
            SipProfile asipprofile[] = getListOfProfiles();
            parcel1.writeNoException();
            parcel1.writeTypedArray(asipprofile, flag);
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final String DESCRIPTOR = "android.net.sip.ISipService";
        static final int TRANSACTION_close = 3;
        static final int TRANSACTION_createSession = 7;
        static final int TRANSACTION_getListOfProfiles = 9;
        static final int TRANSACTION_getPendingSession = 8;
        static final int TRANSACTION_isOpened = 4;
        static final int TRANSACTION_isRegistered = 5;
        static final int TRANSACTION_open = 1;
        static final int TRANSACTION_open3 = 2;
        static final int TRANSACTION_setRegistrationListener = 6;

        public Stub() {
            attachInterface(this, "android.net.sip.ISipService");
        }
    }


    public abstract void close(String s) throws RemoteException;

    public abstract ISipSession createSession(SipProfile sipprofile, ISipSessionListener isipsessionlistener) throws RemoteException;

    public abstract SipProfile[] getListOfProfiles() throws RemoteException;

    public abstract ISipSession getPendingSession(String s) throws RemoteException;

    public abstract boolean isOpened(String s) throws RemoteException;

    public abstract boolean isRegistered(String s) throws RemoteException;

    public abstract void open(SipProfile sipprofile) throws RemoteException;

    public abstract void open3(SipProfile sipprofile, PendingIntent pendingintent, ISipSessionListener isipsessionlistener) throws RemoteException;

    public abstract void setRegistrationListener(String s, ISipSessionListener isipsessionlistener) throws RemoteException;
}
