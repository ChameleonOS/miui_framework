// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.os.*;

// Referenced classes of package android.media:
//            AudioRoutesInfo

public interface IAudioRoutesObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAudioRoutesObserver {
        private static class Proxy
            implements IAudioRoutesObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public void dispatchAudioRoutesChanged(AudioRoutesInfo audioroutesinfo) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioRoutesObserver");
                if(audioroutesinfo == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                audioroutesinfo.writeToParcel(parcel, 0);
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

            public String getInterfaceDescriptor() {
                return "android.media.IAudioRoutesObserver";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAudioRoutesObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.media.IAudioRoutesObserver");
                if(iinterface != null && (iinterface instanceof IAudioRoutesObserver))
                    obj = (IAudioRoutesObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAudioRoutesObserver) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 2: default 32
        //                       1: 55
        //                       1598968902: 46;
               goto _L1 _L2 _L3
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L5:
            return flag;
_L3:
            parcel1.writeString("android.media.IAudioRoutesObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.media.IAudioRoutesObserver");
            AudioRoutesInfo audioroutesinfo;
            if(parcel.readInt() != 0)
                audioroutesinfo = (AudioRoutesInfo)AudioRoutesInfo.CREATOR.createFromParcel(parcel);
            else
                audioroutesinfo = null;
            dispatchAudioRoutesChanged(audioroutesinfo);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.media.IAudioRoutesObserver";
        static final int TRANSACTION_dispatchAudioRoutesChanged = 1;

        public Stub() {
            attachInterface(this, "android.media.IAudioRoutesObserver");
        }
    }


    public abstract void dispatchAudioRoutesChanged(AudioRoutesInfo audioroutesinfo) throws RemoteException;
}
