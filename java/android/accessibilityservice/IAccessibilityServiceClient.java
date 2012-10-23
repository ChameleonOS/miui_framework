// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accessibilityservice;

import android.os.*;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.accessibilityservice:
//            IAccessibilityServiceConnection

public interface IAccessibilityServiceClient
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccessibilityServiceClient {
        private static class Proxy
            implements IAccessibilityServiceClient {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.accessibilityservice.IAccessibilityServiceClient";
            }

            public void onAccessibilityEvent(AccessibilityEvent accessibilityevent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceClient");
                if(accessibilityevent == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                accessibilityevent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onGesture(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceClient");
                parcel.writeInt(i);
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onInterrupt() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceClient");
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setConnection(IAccessibilityServiceConnection iaccessibilityserviceconnection, int i) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.accessibilityservice.IAccessibilityServiceClient");
                if(iaccessibilityserviceconnection != null)
                    ibinder = iaccessibilityserviceconnection.asBinder();
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(1, parcel, null, 1);
                parcel.recycle();
                return;
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


        public static IAccessibilityServiceClient asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.accessibilityservice.IAccessibilityServiceClient");
                if(iinterface != null && (iinterface instanceof IAccessibilityServiceClient))
                    obj = (IAccessibilityServiceClient)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccessibilityServiceClient) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 5: default 56
        //                       1: 79
        //                       2: 103
        //                       3: 145
        //                       4: 158
        //                       1598968902: 70;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L8:
            return flag;
_L6:
            parcel1.writeString("android.accessibilityservice.IAccessibilityServiceClient");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceClient");
            setConnection(IAccessibilityServiceConnection.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceClient");
            AccessibilityEvent accessibilityevent;
            if(parcel.readInt() != 0)
                accessibilityevent = (AccessibilityEvent)AccessibilityEvent.CREATOR.createFromParcel(parcel);
            else
                accessibilityevent = null;
            onAccessibilityEvent(accessibilityevent);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceClient");
            onInterrupt();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.accessibilityservice.IAccessibilityServiceClient");
            onGesture(parcel.readInt());
            if(true) goto _L8; else goto _L7
_L7:
        }

        private static final String DESCRIPTOR = "android.accessibilityservice.IAccessibilityServiceClient";
        static final int TRANSACTION_onAccessibilityEvent = 2;
        static final int TRANSACTION_onGesture = 4;
        static final int TRANSACTION_onInterrupt = 3;
        static final int TRANSACTION_setConnection = 1;

        public Stub() {
            attachInterface(this, "android.accessibilityservice.IAccessibilityServiceClient");
        }
    }


    public abstract void onAccessibilityEvent(AccessibilityEvent accessibilityevent) throws RemoteException;

    public abstract void onGesture(int i) throws RemoteException;

    public abstract void onInterrupt() throws RemoteException;

    public abstract void setConnection(IAccessibilityServiceConnection iaccessibilityserviceconnection, int i) throws RemoteException;
}
