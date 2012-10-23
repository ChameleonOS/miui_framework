// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.graphics.Bitmap;
import android.os.*;

public interface IThumbnailRetriever
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IThumbnailRetriever {
        private static class Proxy
            implements IThumbnailRetriever {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.IThumbnailRetriever";
            }

            public Bitmap getThumbnail(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IThumbnailRetriever");
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Bitmap bitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bitmap;
_L2:
                bitmap = null;
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


        public static IThumbnailRetriever asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IThumbnailRetriever");
                if(iinterface != null && (iinterface instanceof IThumbnailRetriever))
                    obj = (IThumbnailRetriever)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IThumbnailRetriever) (obj));
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
            parcel1.writeString("android.app.IThumbnailRetriever");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IThumbnailRetriever");
            Bitmap bitmap = getThumbnail(parcel.readInt());
            parcel1.writeNoException();
            if(bitmap != null) {
                parcel1.writeInt(flag);
                bitmap.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.app.IThumbnailRetriever";
        static final int TRANSACTION_getThumbnail = 1;

        public Stub() {
            attachInterface(this, "android.app.IThumbnailRetriever");
        }
    }


    public abstract Bitmap getThumbnail(int i) throws RemoteException;
}
