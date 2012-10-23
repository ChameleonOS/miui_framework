// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.*;

// Referenced classes of package android.content:
//            SyncResult

public interface ISyncContext
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISyncContext {
        private static class Proxy
            implements ISyncContext {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.content.ISyncContext";
            }

            public void onFinished(SyncResult syncresult) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.ISyncContext");
                if(syncresult == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                syncresult.writeToParcel(parcel, 0);
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

            public void sendHeartbeat() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.ISyncContext");
                mRemote.transact(1, parcel, parcel1, 0);
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


        public static ISyncContext asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.ISyncContext");
                if(iinterface != null && (iinterface instanceof ISyncContext))
                    obj = (ISyncContext)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISyncContext) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 80
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.content.ISyncContext");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.ISyncContext");
            sendHeartbeat();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.content.ISyncContext");
            SyncResult syncresult;
            if(parcel.readInt() != 0)
                syncresult = (SyncResult)SyncResult.CREATOR.createFromParcel(parcel);
            else
                syncresult = null;
            onFinished(syncresult);
            parcel1.writeNoException();
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.content.ISyncContext";
        static final int TRANSACTION_onFinished = 2;
        static final int TRANSACTION_sendHeartbeat = 1;

        public Stub() {
            attachInterface(this, "android.content.ISyncContext");
        }
    }


    public abstract void onFinished(SyncResult syncresult) throws RemoteException;

    public abstract void sendHeartbeat() throws RemoteException;
}
