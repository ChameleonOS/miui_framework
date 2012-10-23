// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.*;

public interface IWallpaperManagerCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWallpaperManagerCallback {
        private static class Proxy
            implements IWallpaperManagerCallback {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.IWallpaperManagerCallback";
            }

            public void onWallpaperChanged() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IWallpaperManagerCallback");
                mRemote.transact(1, parcel, null, 1);
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


        public static IWallpaperManagerCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IWallpaperManagerCallback");
                if(iinterface != null && (iinterface instanceof IWallpaperManagerCallback))
                    obj = (IWallpaperManagerCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWallpaperManagerCallback) (obj));
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
            parcel1.writeString("android.app.IWallpaperManagerCallback");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IWallpaperManagerCallback");
            onWallpaperChanged();
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.app.IWallpaperManagerCallback";
        static final int TRANSACTION_onWallpaperChanged = 1;

        public Stub() {
            attachInterface(this, "android.app.IWallpaperManagerCallback");
        }
    }


    public abstract void onWallpaperChanged() throws RemoteException;
}
