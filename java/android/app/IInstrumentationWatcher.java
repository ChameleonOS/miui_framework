// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.ComponentName;
import android.os.*;

public interface IInstrumentationWatcher
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IInstrumentationWatcher {
        private static class Proxy
            implements IInstrumentationWatcher {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.app.IInstrumentationWatcher";
            }

            public void instrumentationFinished(ComponentName componentname, int i, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IInstrumentationWatcher");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_92;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void instrumentationStatus(ComponentName componentname, int i, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.IInstrumentationWatcher");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_92;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IInstrumentationWatcher asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.IInstrumentationWatcher");
                if(iinterface != null && (iinterface instanceof IInstrumentationWatcher))
                    obj = (IInstrumentationWatcher)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IInstrumentationWatcher) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 3: default 40
        //                       1: 63
        //                       2: 142
        //                       1598968902: 54;
               goto _L1 _L2 _L3 _L4
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L6:
            return flag;
_L4:
            parcel1.writeString("android.app.IInstrumentationWatcher");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.IInstrumentationWatcher");
            ComponentName componentname1;
            int l;
            Bundle bundle1;
            if(parcel.readInt() != 0)
                componentname1 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname1 = null;
            l = parcel.readInt();
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            instrumentationStatus(componentname1, l, bundle1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.IInstrumentationWatcher");
            ComponentName componentname;
            int k;
            Bundle bundle;
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            k = parcel.readInt();
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            instrumentationFinished(componentname, k, bundle);
            if(true) goto _L6; else goto _L5
_L5:
        }

        private static final String DESCRIPTOR = "android.app.IInstrumentationWatcher";
        static final int TRANSACTION_instrumentationFinished = 2;
        static final int TRANSACTION_instrumentationStatus = 1;

        public Stub() {
            attachInterface(this, "android.app.IInstrumentationWatcher");
        }
    }


    public abstract void instrumentationFinished(ComponentName componentname, int i, Bundle bundle) throws RemoteException;

    public abstract void instrumentationStatus(ComponentName componentname, int i, Bundle bundle) throws RemoteException;
}
