// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.ComponentName;
import android.os.*;

public interface IServiceConnection
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IServiceConnection {
        private static class Proxy
            implements IServiceConnection {

            public IBinder asBinder() {
                return mRemote;
            }

            public void connected(ComponentName componentname, IBinder ibinder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IServiceConnection");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeStrongBinder(ibinder);
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

            public String getInterfaceDescriptor() {
                return "android.app.IServiceConnection";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IServiceConnection asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IServiceConnection");
                if(iinterface != null && (iinterface instanceof IServiceConnection))
                    obj = (IServiceConnection)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IServiceConnection) (obj));
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
            parcel1.writeString("android.app.IServiceConnection");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IServiceConnection");
            ComponentName componentname;
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            connected(componentname, parcel.readStrongBinder());
            if(true) goto _L5; else goto _L4
_L4:
        }

        private static final String DESCRIPTOR = "android.app.IServiceConnection";
        static final int TRANSACTION_connected = 1;

        public Stub() {
            attachInterface(this, "android.app.IServiceConnection");
        }
    }


    public abstract void connected(ComponentName componentname, IBinder ibinder) throws RemoteException;
}
