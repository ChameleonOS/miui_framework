// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.*;

public interface IRemoteControlDisplay
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRemoteControlDisplay {
        private static class Proxy
            implements IRemoteControlDisplay {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.media.IRemoteControlDisplay";
            }

            public void setAllMetadata(int i, Bundle bundle, Bitmap bitmap) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlDisplay");
                parcel.writeInt(i);
                if(bundle == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L3:
                if(bitmap == null)
                    break MISSING_BLOCK_LABEL_93;
                parcel.writeInt(1);
                bitmap.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void setArtwork(int i, Bitmap bitmap) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlDisplay");
                parcel.writeInt(i);
                if(bitmap == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                bitmap.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setCurrentClientId(int i, PendingIntent pendingintent, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                j = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlDisplay");
                parcel.writeInt(i);
                if(pendingintent != null) {
                    parcel.writeInt(1);
                    pendingintent.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_88;
                }
                  goto _L1
_L2:
                parcel.writeInt(j);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_88;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    j = 0;
                    break;
                }
                  goto _L2
            }

            public void setMetadata(int i, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlDisplay");
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setPlaybackState(int i, int j, long l) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlDisplay");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeLong(l);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setTransportControlFlags(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRemoteControlDisplay");
                parcel.writeInt(i);
                parcel.writeInt(j);
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


        public static IRemoteControlDisplay asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.media.IRemoteControlDisplay");
                if(iinterface != null && (iinterface instanceof IRemoteControlDisplay))
                    obj = (IRemoteControlDisplay)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRemoteControlDisplay) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 7: default 72
        //                       1: 95
        //                       2: 164
        //                       3: 189
        //                       4: 210
        //                       5: 260
        //                       6: 310
        //                       1598968902: 86;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L10:
            return flag;
_L8:
            parcel1.writeString("android.media.IRemoteControlDisplay");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.media.IRemoteControlDisplay");
            int j1 = parcel.readInt();
            PendingIntent pendingintent;
            boolean flag1;
            if(parcel.readInt() != 0)
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            else
                pendingintent = null;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            setCurrentClientId(j1, pendingintent, flag1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.media.IRemoteControlDisplay");
            setPlaybackState(parcel.readInt(), parcel.readInt(), parcel.readLong());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.media.IRemoteControlDisplay");
            setTransportControlFlags(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.media.IRemoteControlDisplay");
            int i1 = parcel.readInt();
            Bundle bundle1;
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            setMetadata(i1, bundle1);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.media.IRemoteControlDisplay");
            int l = parcel.readInt();
            Bitmap bitmap1;
            if(parcel.readInt() != 0)
                bitmap1 = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
            else
                bitmap1 = null;
            setArtwork(l, bitmap1);
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.media.IRemoteControlDisplay");
            int k = parcel.readInt();
            Bundle bundle;
            Bitmap bitmap;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            if(parcel.readInt() != 0)
                bitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
            else
                bitmap = null;
            setAllMetadata(k, bundle, bitmap);
            if(true) goto _L10; else goto _L9
_L9:
        }

        private static final String DESCRIPTOR = "android.media.IRemoteControlDisplay";
        static final int TRANSACTION_setAllMetadata = 6;
        static final int TRANSACTION_setArtwork = 5;
        static final int TRANSACTION_setCurrentClientId = 1;
        static final int TRANSACTION_setMetadata = 4;
        static final int TRANSACTION_setPlaybackState = 2;
        static final int TRANSACTION_setTransportControlFlags = 3;

        public Stub() {
            attachInterface(this, "android.media.IRemoteControlDisplay");
        }
    }


    public abstract void setAllMetadata(int i, Bundle bundle, Bitmap bitmap) throws RemoteException;

    public abstract void setArtwork(int i, Bitmap bitmap) throws RemoteException;

    public abstract void setCurrentClientId(int i, PendingIntent pendingintent, boolean flag) throws RemoteException;

    public abstract void setMetadata(int i, Bundle bundle) throws RemoteException;

    public abstract void setPlaybackState(int i, int j, long l) throws RemoteException;

    public abstract void setTransportControlFlags(int i, int j) throws RemoteException;
}
