// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;

public interface IGpsStatusListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IGpsStatusListener {
        private static class Proxy
            implements IGpsStatusListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.location.IGpsStatusListener";
            }

            public void onFirstFix(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.IGpsStatusListener");
                parcel.writeInt(i);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onGpsStarted() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.IGpsStatusListener");
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onGpsStopped() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.IGpsStatusListener");
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onNmeaReceived(long l, String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.IGpsStatusListener");
                parcel.writeLong(l);
                parcel.writeString(s);
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onSvStatusChanged(int i, int ai[], float af[], float af1[], float af2[], int j, int k, 
                    int l) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.location.IGpsStatusListener");
                parcel.writeInt(i);
                parcel.writeIntArray(ai);
                parcel.writeFloatArray(af);
                parcel.writeFloatArray(af1);
                parcel.writeFloatArray(af2);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                mRemote.transact(4, parcel, null, 1);
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


        public static IGpsStatusListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.location.IGpsStatusListener");
                if(iinterface != null && (iinterface instanceof IGpsStatusListener))
                    obj = (IGpsStatusListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IGpsStatusListener) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 6: default 60
        //                       1: 86
        //                       2: 102
        //                       3: 118
        //                       4: 138
        //                       5: 186
        //                       1598968902: 74;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.location.IGpsStatusListener");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.location.IGpsStatusListener");
            onGpsStarted();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.location.IGpsStatusListener");
            onGpsStopped();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.location.IGpsStatusListener");
            onFirstFix(parcel.readInt());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.location.IGpsStatusListener");
            onSvStatusChanged(parcel.readInt(), parcel.createIntArray(), parcel.createFloatArray(), parcel.createFloatArray(), parcel.createFloatArray(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.location.IGpsStatusListener");
            onNmeaReceived(parcel.readLong(), parcel.readString());
            flag = true;
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.location.IGpsStatusListener";
        static final int TRANSACTION_onFirstFix = 3;
        static final int TRANSACTION_onGpsStarted = 1;
        static final int TRANSACTION_onGpsStopped = 2;
        static final int TRANSACTION_onNmeaReceived = 5;
        static final int TRANSACTION_onSvStatusChanged = 4;

        public Stub() {
            attachInterface(this, "android.location.IGpsStatusListener");
        }
    }


    public abstract void onFirstFix(int i) throws RemoteException;

    public abstract void onGpsStarted() throws RemoteException;

    public abstract void onGpsStopped() throws RemoteException;

    public abstract void onNmeaReceived(long l, String s) throws RemoteException;

    public abstract void onSvStatusChanged(int i, int ai[], float af[], float af1[], float af2[], int j, int k, 
            int l) throws RemoteException;
}
