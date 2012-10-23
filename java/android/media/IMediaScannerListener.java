// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.net.Uri;
import android.os.*;

public interface IMediaScannerListener
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IMediaScannerListener {
        private static class Proxy
            implements IMediaScannerListener {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.media.IMediaScannerListener";
            }

            public void scanCompleted(String s, Uri uri) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IMediaScannerListener");
                parcel.writeString(s);
                if(uri == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IMediaScannerListener asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.media.IMediaScannerListener");
                if(iinterface != null && (iinterface instanceof IMediaScannerListener))
                    obj = (IMediaScannerListener)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IMediaScannerListener) (obj));
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
            parcel1.writeString("android.media.IMediaScannerListener");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.media.IMediaScannerListener");
            String s = parcel.readString();
            Uri uri;
            if(parcel.readInt() != 0)
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri = null;
            scanCompleted(s, uri);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.media.IMediaScannerListener";
        static final int TRANSACTION_scanCompleted = 1;

        public Stub() {
            attachInterface(this, "android.media.IMediaScannerListener");
        }
    }


    public abstract void scanCompleted(String s, Uri uri) throws RemoteException;
}
