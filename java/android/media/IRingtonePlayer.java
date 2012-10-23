// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.net.Uri;
import android.os.*;

public interface IRingtonePlayer
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRingtonePlayer {
        private static class Proxy
            implements IRingtonePlayer {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.media.IRingtonePlayer";
            }

            public boolean isPlaying(IBinder ibinder) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.media.IRingtonePlayer");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void play(IBinder ibinder, Uri uri, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRingtonePlayer");
                parcel.writeStrongBinder(ibinder);
                if(uri == null)
                    break MISSING_BLOCK_LABEL_78;
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void playAsync(Uri uri, boolean flag, int i) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRingtonePlayer");
                if(uri != null) {
                    parcel.writeInt(1);
                    uri.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_109;
                }
                  goto _L1
_L2:
                parcel.writeInt(j);
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_109;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    j = 0;
                    break;
                }
                  goto _L2
            }

            public void stop(IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRingtonePlayer");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, parcel1, 0);
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

            public void stopAsync() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IRingtonePlayer");
                mRemote.transact(5, parcel, parcel1, 0);
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


        public static IRingtonePlayer asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.media.IRingtonePlayer");
                if(iinterface != null && (iinterface instanceof IRingtonePlayer))
                    obj = (IRingtonePlayer)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRingtonePlayer) (obj));
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
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 145
        //                       3: 166
        //                       4: 204
        //                       5: 273
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.media.IRingtonePlayer");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.media.IRingtonePlayer");
            IBinder ibinder = parcel.readStrongBinder();
            Uri uri1;
            if(parcel.readInt() != 0)
                uri1 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri1 = null;
            play(ibinder, uri1, parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.media.IRingtonePlayer");
            stop(parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.media.IRingtonePlayer");
            boolean flag2 = isPlaying(parcel.readStrongBinder());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.media.IRingtonePlayer");
            Uri uri;
            boolean flag1;
            if(parcel.readInt() != 0)
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri = null;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            playAsync(uri, flag1, parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.media.IRingtonePlayer");
            stopAsync();
            parcel1.writeNoException();
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.media.IRingtonePlayer";
        static final int TRANSACTION_isPlaying = 3;
        static final int TRANSACTION_play = 1;
        static final int TRANSACTION_playAsync = 4;
        static final int TRANSACTION_stop = 2;
        static final int TRANSACTION_stopAsync = 5;

        public Stub() {
            attachInterface(this, "android.media.IRingtonePlayer");
        }
    }


    public abstract boolean isPlaying(IBinder ibinder) throws RemoteException;

    public abstract void play(IBinder ibinder, Uri uri, int i) throws RemoteException;

    public abstract void playAsync(Uri uri, boolean flag, int i) throws RemoteException;

    public abstract void stop(IBinder ibinder) throws RemoteException;

    public abstract void stopAsync() throws RemoteException;
}
