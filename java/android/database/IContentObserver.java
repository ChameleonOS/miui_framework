// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.net.Uri;
import android.os.*;

public interface IContentObserver
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IContentObserver {
        private static class Proxy
            implements IContentObserver {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.database.IContentObserver";
            }

            public void onChange(boolean flag, Uri uri) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.database.IContentObserver");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                if(uri == null)
                    break MISSING_BLOCK_LABEL_67;
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


        public static IContentObserver asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.database.IContentObserver");
                if(iinterface != null && (iinterface instanceof IContentObserver))
                    obj = (IContentObserver)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IContentObserver) (obj));
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
            parcel1.writeString("android.database.IContentObserver");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.database.IContentObserver");
            boolean flag1;
            Uri uri;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            if(parcel.readInt() != 0)
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri = null;
            onChange(flag1, uri);
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.database.IContentObserver";
        static final int TRANSACTION_onChange = 1;

        public Stub() {
            attachInterface(this, "android.database.IContentObserver");
        }
    }


    public abstract void onChange(boolean flag, Uri uri) throws RemoteException;
}
