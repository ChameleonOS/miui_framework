// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accessibilityservice;

import android.os.*;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;

// Referenced classes of package android.accessibilityservice:
//            AccessibilityServiceInfo

public interface IAccessibilityServiceConnection
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccessibilityServiceConnection {
        private static class Proxy
            implements IAccessibilityServiceConnection {

            public IBinder asBinder() {
                return mRemote;
            }

            public float findAccessibilityNodeInfoByAccessibilityId(int i, long l, int j, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int k, long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                parcel.writeInt(i);
                parcel.writeLong(l);
                parcel.writeInt(j);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_112;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                float f;
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(k);
                parcel.writeLong(l1);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                f = parcel1.readFloat();
                parcel1.recycle();
                parcel.recycle();
                return f;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public float findAccessibilityNodeInfoByViewId(int i, long l, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                parcel.writeInt(i);
                parcel.writeLong(l);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_112;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                float f;
                parcel.writeStrongBinder(ibinder);
                parcel.writeLong(l1);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                f = parcel1.readFloat();
                parcel1.recycle();
                parcel.recycle();
                return f;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public float findAccessibilityNodeInfosByText(int i, long l, String s, int j, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                parcel.writeInt(i);
                parcel.writeLong(l);
                parcel.writeString(s);
                parcel.writeInt(j);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_112;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                float f;
                parcel.writeStrongBinder(ibinder);
                parcel.writeLong(l1);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                f = parcel1.readFloat();
                parcel1.recycle();
                parcel.recycle();
                return f;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public float findFocus(int i, long l, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                parcel.writeInt(i);
                parcel.writeLong(l);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_112;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                float f;
                parcel.writeStrongBinder(ibinder);
                parcel.writeLong(l1);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                f = parcel1.readFloat();
                parcel1.recycle();
                parcel.recycle();
                return f;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public float focusSearch(int i, long l, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                parcel.writeInt(i);
                parcel.writeLong(l);
                parcel.writeInt(j);
                parcel.writeInt(k);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_113;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L1:
                float f;
                parcel.writeStrongBinder(ibinder);
                parcel.writeLong(l1);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                f = parcel1.readFloat();
                parcel1.recycle();
                parcel.recycle();
                return f;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.accessibilityservice.IAccessibilityServiceConnection";
            }

            public AccessibilityServiceInfo getServiceInfo() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                AccessibilityServiceInfo accessibilityserviceinfo = (AccessibilityServiceInfo)AccessibilityServiceInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return accessibilityserviceinfo;
_L2:
                accessibilityserviceinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean performAccessibilityAction(int i, long l, int j, Bundle bundle, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
                    long l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                parcel.writeInt(i);
                parcel.writeLong(l);
                parcel.writeInt(j);
                if(bundle == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                parcel.writeInt(k);
                if(iaccessibilityinteractionconnectioncallback == null)
                    break MISSING_BLOCK_LABEL_164;
                ibinder = iaccessibilityinteractionconnectioncallback.asBinder();
_L4:
                int i1;
                parcel.writeStrongBinder(ibinder);
                parcel.writeLong(l1);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                Exception exception;
                boolean flag;
                if(i1 != 0)
                    flag = true;
                else
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
_L2:
                parcel.writeInt(0);
                  goto _L3
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                ibinder = null;
                  goto _L4
            }

            public boolean performGlobalAction(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                parcel.writeInt(i);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setServiceInfo(AccessibilityServiceInfo accessibilityserviceinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceConnection");
                if(accessibilityserviceinfo == null)
                    break MISSING_BLOCK_LABEL_56;
                parcel.writeInt(1);
                accessibilityserviceinfo.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(1, parcel, parcel1, 0);
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


        public static IAccessibilityServiceConnection asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.accessibilityservice.IAccessibilityServiceConnection");
                if(iinterface != null && (iinterface instanceof IAccessibilityServiceConnection))
                    obj = (IAccessibilityServiceConnection)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccessibilityServiceConnection) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 10: default 92
        //                       1: 118
        //                       2: 167
        //                       3: 222
        //                       4: 277
        //                       5: 332
        //                       6: 387
        //                       7: 442
        //                       8: 564
        //                       9: 611
        //                       1598968902: 106;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            boolean flag1 = super.onTransact(i, parcel, parcel1, j);
_L13:
            return flag1;
_L11:
            parcel1.writeString("android.accessibilityservice.IAccessibilityServiceConnection");
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            AccessibilityServiceInfo accessibilityserviceinfo1;
            if(parcel.readInt() != 0)
                accessibilityserviceinfo1 = (AccessibilityServiceInfo)AccessibilityServiceInfo.CREATOR.createFromParcel(parcel);
            else
                accessibilityserviceinfo1 = null;
            setServiceInfo(accessibilityserviceinfo1);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            float f4 = findAccessibilityNodeInfoByAccessibilityId(parcel.readInt(), parcel.readLong(), parcel.readInt(), android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong());
            parcel1.writeNoException();
            parcel1.writeFloat(f4);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            float f3 = findAccessibilityNodeInfosByText(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt(), android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            parcel1.writeFloat(f3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            float f2 = findAccessibilityNodeInfoByViewId(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt(), android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            parcel1.writeFloat(f2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            float f1 = findFocus(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt(), android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            parcel1.writeFloat(f1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            float f = focusSearch(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt(), android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            parcel1.writeFloat(f);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            int l = parcel.readInt();
            long l1 = parcel.readLong();
            int i1 = parcel.readInt();
            Bundle bundle;
            int j1;
            IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback;
            long l2;
            boolean flag2;
            int k1;
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            j1 = parcel.readInt();
            iaccessibilityinteractionconnectioncallback = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(parcel.readStrongBinder());
            l2 = parcel.readLong();
            flag2 = performAccessibilityAction(l, l1, i1, bundle, j1, iaccessibilityinteractionconnectioncallback, l2);
            parcel1.writeNoException();
            if(flag2)
                k1 = 1;
            else
                k1 = 0;
            parcel1.writeInt(k1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            AccessibilityServiceInfo accessibilityserviceinfo = getServiceInfo();
            parcel1.writeNoException();
            if(accessibilityserviceinfo != null) {
                parcel1.writeInt(1);
                accessibilityserviceinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceConnection");
            boolean flag = performGlobalAction(parcel.readInt());
            parcel1.writeNoException();
            int k;
            if(flag)
                k = 1;
            else
                k = 0;
            parcel1.writeInt(k);
            flag1 = true;
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final String DESCRIPTOR = "android.accessibilityservice.IAccessibilityServiceConnection";
        static final int TRANSACTION_findAccessibilityNodeInfoByAccessibilityId = 2;
        static final int TRANSACTION_findAccessibilityNodeInfoByViewId = 4;
        static final int TRANSACTION_findAccessibilityNodeInfosByText = 3;
        static final int TRANSACTION_findFocus = 5;
        static final int TRANSACTION_focusSearch = 6;
        static final int TRANSACTION_getServiceInfo = 8;
        static final int TRANSACTION_performAccessibilityAction = 7;
        static final int TRANSACTION_performGlobalAction = 9;
        static final int TRANSACTION_setServiceInfo = 1;

        public Stub() {
            attachInterface(this, "android.accessibilityservice.IAccessibilityServiceConnection");
        }
    }


    public abstract float findAccessibilityNodeInfoByAccessibilityId(int i, long l, int j, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, int k, long l1) throws RemoteException;

    public abstract float findAccessibilityNodeInfoByViewId(int i, long l, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, long l1) throws RemoteException;

    public abstract float findAccessibilityNodeInfosByText(int i, long l, String s, int j, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, long l1) throws RemoteException;

    public abstract float findFocus(int i, long l, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, long l1) throws RemoteException;

    public abstract float focusSearch(int i, long l, int j, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, long l1) throws RemoteException;

    public abstract AccessibilityServiceInfo getServiceInfo() throws RemoteException;

    public abstract boolean performAccessibilityAction(int i, long l, int j, Bundle bundle, int k, IAccessibilityInteractionConnectionCallback iaccessibilityinteractionconnectioncallback, 
            long l1) throws RemoteException;

    public abstract boolean performGlobalAction(int i) throws RemoteException;

    public abstract void setServiceInfo(AccessibilityServiceInfo accessibilityserviceinfo) throws RemoteException;
}
