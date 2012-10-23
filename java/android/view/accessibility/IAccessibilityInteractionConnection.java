// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.os.*;

// Referenced classes of package android.view.accessibility:
//            IAccessibilityInteractionConnectionCallback

public interface IAccessibilityInteractionConnection
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccessibilityInteractionConnection {
        private static class Proxy
            implements IAccessibilityInteractionConnection {

            public IBinder asBinder() {
                return mRemote;
            }

            public void findAccessibilityNodeInfoByAccessibilityId(long l, int i, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int i1, 
                    int j1, long l1) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnection");
                parcel.writeLong(l);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(iaccessibilityinteractionconnectioncallback != null)
                    ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                parcel.writeLong(l1);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void findAccessibilityNodeInfoByViewId(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                    int j1, int k1, long l1) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnection");
                parcel.writeLong(l);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(i1);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_108;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(j1);
                parcel.writeInt(k1);
                parcel.writeLong(l1);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void findAccessibilityNodeInfosByText(long l, String s, int i, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                    int i1, int j1, long l1) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnection");
                parcel.writeLong(l);
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_108;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                parcel.writeLong(l1);
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void findFocus(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                    int j1, int k1, long l1) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnection");
                parcel.writeLong(l);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(i1);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_108;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(j1);
                parcel.writeInt(k1);
                parcel.writeLong(l1);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void focusSearch(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                    int j1, int k1, long l1) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnection");
                parcel.writeLong(l);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(i1);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_108;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(j1);
                parcel.writeInt(k1);
                parcel.writeLong(l1);
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.view.accessibility.IAccessibilityInteractionConnection";
            }

            public void performAccessibilityAction(long l, int i, Bundle bundle, int j, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int k, 
                    int i1, long l1) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnection");
                parcel.writeLong(l);
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_117;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(j);
                if(iaccessibilityinteractionconnectioncallback != null)
                    ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(k);
                parcel.writeInt(i1);
                parcel.writeLong(l1);
                mRemote.transact(6, parcel, null, 1);
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


        public static IAccessibilityInteractionConnection asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.view.accessibility.IAccessibilityInteractionConnection");
                if(iinterface != null && (iinterface instanceof IAccessibilityInteractionConnection))
                    obj = (IAccessibilityInteractionConnection)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccessibilityInteractionConnection) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 7: default 68
        //                       1: 94
        //                       2: 145
        //                       3: 200
        //                       4: 255
        //                       5: 310
        //                       6: 365
        //                       1598968902: 82;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L10:
            return flag;
_L8:
            parcel1.writeString("android.view.accessibility.IAccessibilityInteractionConnection");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnection");
            findAccessibilityNodeInfoByAccessibilityId(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnection");
            findAccessibilityNodeInfoByViewId(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnection");
            findAccessibilityNodeInfosByText(parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnection");
            findFocus(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnection");
            focusSearch(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnection");
            long l = parcel.readLong();
            int k = parcel.readInt();
            Bundle bundle;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            performAccessibilityAction(l, k, bundle, parcel.readInt(), IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
            flag = true;
            if(true) goto _L10; else goto _L9
_L9:
        }

        private static final String DESCRIPTOR = "android.view.accessibility.IAccessibilityInteractionConnection";
        static final int TRANSACTION_findAccessibilityNodeInfoByAccessibilityId = 1;
        static final int TRANSACTION_findAccessibilityNodeInfoByViewId = 2;
        static final int TRANSACTION_findAccessibilityNodeInfosByText = 3;
        static final int TRANSACTION_findFocus = 4;
        static final int TRANSACTION_focusSearch = 5;
        static final int TRANSACTION_performAccessibilityAction = 6;

        public Stub() {
            attachInterface(this, "android.view.accessibility.IAccessibilityInteractionConnection");
        }
    }


    public abstract void findAccessibilityNodeInfoByAccessibilityId(long l, int i, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int i1, 
            int j1, long l1) throws RemoteException;

    public abstract void findAccessibilityNodeInfoByViewId(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            int j1, int k1, long l1) throws RemoteException;

    public abstract void findAccessibilityNodeInfosByText(long l, String s, int i, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            int i1, int j1, long l1) throws RemoteException;

    public abstract void findFocus(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            int j1, int k1, long l1) throws RemoteException;

    public abstract void focusSearch(long l, int i, int j, int k, int i1, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            int j1, int k1, long l1) throws RemoteException;

    public abstract void performAccessibilityAction(long l, int i, Bundle bundle, int j, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int k, 
            int i1, long l1) throws RemoteException;
}
