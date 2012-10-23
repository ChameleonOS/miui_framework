// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.os.*;

// Referenced classes of package android.media:
//            IMediaScannerListener

public interface IMediaScannerService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IMediaScannerService {
        private static class Proxy
            implements IMediaScannerService {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.media.IMediaScannerService";
            }

            public void requestScanFile(String s, String s1, IMediaScannerListener imediascannerlistener) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.media.IMediaScannerService");
                parcel.writeString(s);
                parcel.writeString(s1);
                if(imediascannerlistener == null)
                    break MISSING_BLOCK_LABEL_80;
                ibinder = imediascannerlistener.asBinder();
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

            public void scanFile(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.media.IMediaScannerService");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IMediaScannerService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.media.IMediaScannerService");
                if(iinterface != null && (iinterface instanceof IMediaScannerService))
                    obj = (IMediaScannerService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IMediaScannerService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 95
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.media.IMediaScannerService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.media.IMediaScannerService");
            requestScanFile(parcel.readString(), parcel.readString(), IMediaScannerListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.media.IMediaScannerService");
            scanFile(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.media.IMediaScannerService";
        static final int TRANSACTION_requestScanFile = 1;
        static final int TRANSACTION_scanFile = 2;

        public Stub() {
            attachInterface(this, "android.media.IMediaScannerService");
        }
    }


    public abstract void requestScanFile(String s, String s1, IMediaScannerListener imediascannerlistener) throws RemoteException;

    public abstract void scanFile(String s, String s1) throws RemoteException;
}
