// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.os.*;

// Referenced classes of package android.media:
//            IRemoteControlDisplay

public interface IRemoteControlClient
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRemoteControlClient {
        private static class Proxy
            implements IRemoteControlClient {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.media.IRemoteControlClient";
            }

            public void onInformationRequested(int i, int j, int k, int l) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlClient");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void plugRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlClient");
                if(iremotecontroldisplay != null)
                    ibinder = iremotecontroldisplay.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setCurrentClientGenerationId(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlClient");
                parcel.writeInt(i);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void unplugRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlClient");
                if(iremotecontroldisplay != null)
                    ibinder = iremotecontroldisplay.asBinder();
                parcel.writeStrongBinder(ibinder);
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


        public static IRemoteControlClient asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.media.IRemoteControlClient");
                if(iinterface != null && (iinterface instanceof IRemoteControlClient))
                    obj = (IRemoteControlClient)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRemoteControlClient) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 108
        //                       3: 125
        //                       4: 145
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("android.media.IRemoteControlClient");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.media.IRemoteControlClient");
            onInformationRequested(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.media.IRemoteControlClient");
            setCurrentClientGenerationId(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.media.IRemoteControlClient");
            plugRemoteControlDisplay(IRemoteControlDisplay.Stub.asInterface(parcel.readStrongBinder()));
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.media.IRemoteControlClient");
            unplugRemoteControlDisplay(IRemoteControlDisplay.Stub.asInterface(parcel.readStrongBinder()));
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "android.media.IRemoteControlClient";
        static final int TRANSACTION_onInformationRequested = 1;
        static final int TRANSACTION_plugRemoteControlDisplay = 3;
        static final int TRANSACTION_setCurrentClientGenerationId = 2;
        static final int TRANSACTION_unplugRemoteControlDisplay = 4;

        public Stub() {
            attachInterface(this, "android.media.IRemoteControlClient");
        }
    }


    public abstract void onInformationRequested(int i, int j, int k, int l) throws RemoteException;

    public abstract void plugRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) throws RemoteException;

    public abstract void setCurrentClientGenerationId(int i) throws RemoteException;

    public abstract void unplugRemoteControlDisplay(IRemoteControlDisplay iremotecontroldisplay) throws RemoteException;
}
