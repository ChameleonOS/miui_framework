// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.ComponentName;
import android.os.*;

// Referenced classes of package android.app:
//            IWallpaperManagerCallback, WallpaperInfo

public interface IWallpaperManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWallpaperManager {
        private static class Proxy
            implements IWallpaperManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public void clearWallpaper() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IWallpaperManager");
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

            public int getHeightHint() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.IWallpaperManager");
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.app.IWallpaperManager";
            }

            public ParcelFileDescriptor getWallpaper(IWallpaperManagerCallback iwallpapermanagercallback, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IWallpaperManager");
                if(iwallpapermanagercallback == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iwallpapermanagercallback.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L4; else goto _L3
_L3:
                ParcelFileDescriptor parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
_L6:
                if(parcel1.readInt() != 0)
                    bundle.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return parcelfiledescriptor;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcelfiledescriptor = null;
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public WallpaperInfo getWallpaperInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IWallpaperManager");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                WallpaperInfo wallpaperinfo = (WallpaperInfo)WallpaperInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return wallpaperinfo;
_L2:
                wallpaperinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getWidthHint() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.IWallpaperManager");
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setDimensionHints(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IWallpaperManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public ParcelFileDescriptor setWallpaper(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IWallpaperManager");
                parcel.writeString(s);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public void setWallpaperComponent(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IWallpaperManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(2, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IWallpaperManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IWallpaperManager");
                if(iinterface != null && (iinterface instanceof IWallpaperManager))
                    obj = (IWallpaperManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWallpaperManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 9: default 88
        //                       1: 111
        //                       2: 161
        //                       3: 207
        //                       4: 302
        //                       5: 348
        //                       6: 365
        //                       7: 390
        //                       8: 415
        //                       1598968902: 102;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L12:
            return flag;
_L10:
            parcel1.writeString("android.app.IWallpaperManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IWallpaperManager");
            ParcelFileDescriptor parcelfiledescriptor1 = setWallpaper(parcel.readString());
            parcel1.writeNoException();
            if(parcelfiledescriptor1 != null) {
                parcel1.writeInt(flag);
                parcelfiledescriptor1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.IWallpaperManager");
            ComponentName componentname;
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            setWallpaperComponent(componentname);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.IWallpaperManager");
            IWallpaperManagerCallback iwallpapermanagercallback = IWallpaperManagerCallback.Stub.asInterface(parcel.readStrongBinder());
            Bundle bundle = new Bundle();
            ParcelFileDescriptor parcelfiledescriptor = getWallpaper(iwallpapermanagercallback, bundle);
            parcel1.writeNoException();
            if(parcelfiledescriptor != null) {
                parcel1.writeInt(flag);
                parcelfiledescriptor.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            if(bundle != null) {
                parcel1.writeInt(flag);
                bundle.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.IWallpaperManager");
            WallpaperInfo wallpaperinfo = getWallpaperInfo();
            parcel1.writeNoException();
            if(wallpaperinfo != null) {
                parcel1.writeInt(flag);
                wallpaperinfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.IWallpaperManager");
            clearWallpaper();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.app.IWallpaperManager");
            setDimensionHints(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.app.IWallpaperManager");
            int l = getWidthHint();
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.app.IWallpaperManager");
            int k = getHeightHint();
            parcel1.writeNoException();
            parcel1.writeInt(k);
            if(true) goto _L12; else goto _L11
_L11:
        }

        private static final String DESCRIPTOR = "android.app.IWallpaperManager";
        static final int TRANSACTION_clearWallpaper = 5;
        static final int TRANSACTION_getHeightHint = 8;
        static final int TRANSACTION_getWallpaper = 3;
        static final int TRANSACTION_getWallpaperInfo = 4;
        static final int TRANSACTION_getWidthHint = 7;
        static final int TRANSACTION_setDimensionHints = 6;
        static final int TRANSACTION_setWallpaper = 1;
        static final int TRANSACTION_setWallpaperComponent = 2;

        public Stub() {
            attachInterface(this, "android.app.IWallpaperManager");
        }
    }


    public abstract void clearWallpaper() throws RemoteException;

    public abstract int getHeightHint() throws RemoteException;

    public abstract ParcelFileDescriptor getWallpaper(IWallpaperManagerCallback iwallpapermanagercallback, Bundle bundle) throws RemoteException;

    public abstract WallpaperInfo getWallpaperInfo() throws RemoteException;

    public abstract int getWidthHint() throws RemoteException;

    public abstract void setDimensionHints(int i, int j) throws RemoteException;

    public abstract ParcelFileDescriptor setWallpaper(String s) throws RemoteException;

    public abstract void setWallpaperComponent(ComponentName componentname) throws RemoteException;
}
