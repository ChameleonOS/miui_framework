// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.dreams;

import android.content.ComponentName;
import android.os.*;

public interface IDreamManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IDreamManager {
        private static class Proxy
            implements IDreamManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public void awaken() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.dreams.IDreamManager");
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

            public void dream() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.dreams.IDreamManager");
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

            public ComponentName getDreamComponent() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.dreams.IDreamManager");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ComponentName componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return componentname;
_L2:
                componentname = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.service.dreams.IDreamManager";
            }

            public void setDreamComponent(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.dreams.IDreamManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void testDream(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.service.dreams.IDreamManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(5, parcel, parcel1, 0);
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


        public static IDreamManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.service.dreams.IDreamManager");
                if(iinterface != null && (iinterface instanceof IDreamManager))
                    obj = (IDreamManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IDreamManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 104
        //                       3: 121
        //                       4: 167
        //                       5: 213
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.service.dreams.IDreamManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.service.dreams.IDreamManager");
            dream();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.service.dreams.IDreamManager");
            awaken();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.service.dreams.IDreamManager");
            ComponentName componentname2;
            if(parcel.readInt() != 0)
                componentname2 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname2 = null;
            setDreamComponent(componentname2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.service.dreams.IDreamManager");
            ComponentName componentname1 = getDreamComponent();
            parcel1.writeNoException();
            if(componentname1 != null) {
                parcel1.writeInt(flag);
                componentname1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.service.dreams.IDreamManager");
            ComponentName componentname;
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            testDream(componentname);
            parcel1.writeNoException();
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.service.dreams.IDreamManager";
        static final int TRANSACTION_awaken = 2;
        static final int TRANSACTION_dream = 1;
        static final int TRANSACTION_getDreamComponent = 4;
        static final int TRANSACTION_setDreamComponent = 3;
        static final int TRANSACTION_testDream = 5;

        public Stub() {
            attachInterface(this, "android.service.dreams.IDreamManager");
        }
    }


    public abstract void awaken() throws RemoteException;

    public abstract void dream() throws RemoteException;

    public abstract ComponentName getDreamComponent() throws RemoteException;

    public abstract void setDreamComponent(ComponentName componentname) throws RemoteException;

    public abstract void testDream(ComponentName componentname) throws RemoteException;
}
