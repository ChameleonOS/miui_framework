// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.wallpaper;

import android.os.*;
import android.view.MotionEvent;

public interface IWallpaperEngine
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IWallpaperEngine {
        private static class Proxy
            implements IWallpaperEngine {

            public IBinder asBinder() {
                return mRemote;
            }

            public void destroy() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.wallpaper.IWallpaperEngine");
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchPointer(MotionEvent motionevent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.wallpaper.IWallpaperEngine");
                if(motionevent == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                motionevent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void dispatchWallpaperCommand(String s, int i, int j, int k, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.wallpaper.IWallpaperEngine");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_77;
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

            public String getInterfaceDescriptor() {
                return "android.service.wallpaper.IWallpaperEngine";
            }

            public void setDesiredSize(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.wallpaper.IWallpaperEngine");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setVisibility(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.wallpaper.IWallpaperEngine");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(2, parcel, null, 1);
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


        public static IWallpaperEngine asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.service.wallpaper.IWallpaperEngine");
                if(iinterface != null && (iinterface instanceof IWallpaperEngine))
                    obj = (IWallpaperEngine)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IWallpaperEngine) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 108
        //                       3: 140
        //                       4: 182
        //                       5: 256
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.service.wallpaper.IWallpaperEngine");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.service.wallpaper.IWallpaperEngine");
            setDesiredSize(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.service.wallpaper.IWallpaperEngine");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            setVisibility(flag1);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.service.wallpaper.IWallpaperEngine");
            MotionEvent motionevent;
            if(parcel.readInt() != 0)
                motionevent = (MotionEvent)MotionEvent.CREATOR.createFromParcel(parcel);
            else
                motionevent = null;
            dispatchPointer(motionevent);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.service.wallpaper.IWallpaperEngine");
            String s = parcel.readString();
            int k = parcel.readInt();
            int l = parcel.readInt();
            int i1 = parcel.readInt();
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            dispatchWallpaperCommand(s, k, l, i1, bundle);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.service.wallpaper.IWallpaperEngine");
            destroy();
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.service.wallpaper.IWallpaperEngine";
        static final int TRANSACTION_destroy = 5;
        static final int TRANSACTION_dispatchPointer = 3;
        static final int TRANSACTION_dispatchWallpaperCommand = 4;
        static final int TRANSACTION_setDesiredSize = 1;
        static final int TRANSACTION_setVisibility = 2;

        public Stub() {
            attachInterface(this, "android.service.wallpaper.IWallpaperEngine");
        }
    }


    public abstract void destroy() throws RemoteException;

    public abstract void dispatchPointer(MotionEvent motionevent) throws RemoteException;

    public abstract void dispatchWallpaperCommand(String s, int i, int j, int k, Bundle bundle) throws RemoteException;

    public abstract void setDesiredSize(int i, int j) throws RemoteException;

    public abstract void setVisibility(boolean flag) throws RemoteException;
}
