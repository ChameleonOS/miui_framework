// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.os.*;

public interface IAudioFocusDispatcher
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAudioFocusDispatcher {
        private static class Proxy
            implements IAudioFocusDispatcher {

            public IBinder asBinder() {
                return mRemote;
            }

            public void dispatchAudioFocusChange(int i, String s) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IAudioFocusDispatcher");
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.media.IAudioFocusDispatcher";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAudioFocusDispatcher asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.media.IAudioFocusDispatcher");
                if(iinterface != null && (iinterface instanceof IAudioFocusDispatcher))
                    obj = (IAudioFocusDispatcher)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAudioFocusDispatcher) (obj));
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
            parcel1.writeString("android.media.IAudioFocusDispatcher");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.media.IAudioFocusDispatcher");
            dispatchAudioFocusChange(parcel.readInt(), parcel.readString());
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.media.IAudioFocusDispatcher";
        static final int TRANSACTION_dispatchAudioFocusChange = 1;

        public Stub() {
            attachInterface(this, "android.media.IAudioFocusDispatcher");
        }
    }


    public abstract void dispatchAudioFocusChange(int i, String s) throws RemoteException;
}
