// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.wallpaper;

import android.os.*;

// Referenced classes of package android.service.wallpaper:
//            IWallpaperEngine

public interface IWallpaperConnection
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWallpaperConnection {
        private static class Proxy
            implements IWallpaperConnection {

            public IBinder asBinder() {
                return mRemote;
            }

            public void attachEngine(IWallpaperEngine iwallpaperengine) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.service.wallpaper.IWallpaperConnection");
                if(iwallpaperengine == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = iwallpaperengine.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "android.service.wallpaper.IWallpaperConnection";
            }

            public ParcelFileDescriptor setWallpaper(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.wallpaper.IWallpaperConnection");
                parcel.writeString(s);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ParcelFileDescriptor parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return parcelfiledescriptor;
_L2:
                parcelfiledescriptor = null;
                if(true) goto _L4; else goto _L3
_L3:
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


        public static IWallpaperConnection asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.service.wallpaper.IWallpaperConnection");
                if(iinterface != null && (iinterface instanceof IWallpaperConnection))
                    obj = (IWallpaperConnection)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWallpaperConnection) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 87
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.service.wallpaper.IWallpaperConnection");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.service.wallpaper.IWallpaperConnection");
            attachEngine(IWallpaperEngine.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.service.wallpaper.IWallpaperConnection");
            ParcelFileDescriptor parcelfiledescriptor = setWallpaper(parcel.readString());
            parcel1.writeNoException();
            if(parcelfiledescriptor != null) {
                parcel1.writeInt(flag);
                parcelfiledescriptor.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.service.wallpaper.IWallpaperConnection";
        static final int TRANSACTION_attachEngine = 1;
        static final int TRANSACTION_setWallpaper = 2;

        public Stub() {
            attachInterface(this, "android.service.wallpaper.IWallpaperConnection");
        }
    }


    public abstract void attachEngine(IWallpaperEngine iwallpaperengine) throws RemoteException;

    public abstract ParcelFileDescriptor setWallpaper(String s) throws RemoteException;
}
