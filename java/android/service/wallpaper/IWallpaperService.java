// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.wallpaper;

import android.os.*;

// Referenced classes of package android.service.wallpaper:
//            IWallpaperConnection

public interface IWallpaperService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWallpaperService {
        private static class Proxy
            implements IWallpaperService {

            public IBinder asBinder() {
                return mRemote;
            }

            public void attach(IWallpaperConnection iwallpaperconnection, IBinder ibinder, int i, boolean flag, int j, int k) throws RemoteException {
                IBinder ibinder1;
                int l;
                Parcel parcel;
                ibinder1 = null;
                l = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.wallpaper.IWallpaperService");
                if(iwallpaperconnection != null)
                    ibinder1 = iwallpaperconnection.asBinder();
                parcel.writeStrongBinder(ibinder1);
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                if(!flag)
                    l = 0;
                parcel.writeInt(l);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.service.wallpaper.IWallpaperService";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IWallpaperService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.service.wallpaper.IWallpaperService");
                if(iinterface != null && (iinterface instanceof IWallpaperService))
                    obj = (IWallpaperService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWallpaperService) (obj));
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
            parcel1.writeString("android.service.wallpaper.IWallpaperService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.service.wallpaper.IWallpaperService");
            IWallpaperConnection iwallpaperconnection = IWallpaperConnection.Stub.asInterface(parcel.readStrongBinder());
            IBinder ibinder = parcel.readStrongBinder();
            int k = parcel.readInt();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            attach(iwallpaperconnection, ibinder, k, flag1, parcel.readInt(), parcel.readInt());
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.service.wallpaper.IWallpaperService";
        static final int TRANSACTION_attach = 1;

        public Stub() {
            attachInterface(this, "android.service.wallpaper.IWallpaperService");
        }
    }


    public abstract void attach(IWallpaperConnection iwallpaperconnection, IBinder ibinder, int i, boolean flag, int j, int k) throws RemoteException;
}
