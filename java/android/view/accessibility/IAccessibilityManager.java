// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.os.*;
import android.view.IWindow;
import java.util.List;

// Referenced classes of package android.view.accessibility:
//            IAccessibilityInteractionConnection, IAccessibilityManagerClient, AccessibilityEvent

public interface IAccessibilityManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccessibilityManager {
        private static class Proxy
            implements IAccessibilityManager {

            public int addAccessibilityInteractionConnection(IWindow iwindow, IAccessibilityInteractionConnection iaccessibilityinteractionconnection) throws RemoteException {
                IBinder ibinder;
                Parcel parcel;
                Parcel parcel1;
                ibinder = null;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder1;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_97;
                ibinder1 = iwindow.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder1);
                if(iaccessibilityinteractionconnection != null)
                    ibinder = iaccessibilityinteractionconnection.asBinder();
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                ibinder1 = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int addClient(IAccessibilityManagerClient iaccessibilitymanagerclient) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                if(iaccessibilitymanagerclient == null)
                    break MISSING_BLOCK_LABEL_67;
                ibinder = iaccessibilitymanagerclient.asBinder();
_L1:
                int i;
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public List getEnabledAccessibilityServiceList(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(AccessibilityServiceInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getInstalledAccessibilityServiceList() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(AccessibilityServiceInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.view.accessibility.IAccessibilityManager";
            }

            public void interrupt() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                mRemote.transact(5, parcel, parcel1, 0);
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

            public void registerUiTestAutomationService(IAccessibilityServiceClient iaccessibilityserviceclient, AccessibilityServiceInfo accessibilityserviceinfo) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                if(iaccessibilityserviceclient == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = iaccessibilityserviceclient.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                if(accessibilityserviceinfo == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                accessibilityserviceinfo.writeToParcel(parcel, 0);
_L6:
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public void removeAccessibilityInteractionConnection(IWindow iwindow) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                if(iwindow == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iwindow.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public boolean sendAccessibilityEvent(AccessibilityEvent accessibilityevent) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                if(accessibilityevent == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                accessibilityevent.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void unregisterUiTestAutomationService(IAccessibilityServiceClient iaccessibilityserviceclient) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityManager");
                if(iaccessibilityserviceclient == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = iaccessibilityserviceclient.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(9, parcel, parcel1, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAccessibilityManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.view.accessibility.IAccessibilityManager");
                if(iinterface != null && (iinterface instanceof IAccessibilityManager))
                    obj = (IAccessibilityManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccessibilityManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 10: default 96
        //                       1: 119
        //                       2: 151
        //                       3: 220
        //                       4: 245
        //                       5: 274
        //                       6: 291
        //                       7: 330
        //                       8: 354
        //                       9: 411
        //                       1598968902: 110;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L13:
            return flag;
_L11:
            parcel1.writeString("android.view.accessibility.IAccessibilityManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            int i1 = addClient(IAccessibilityManagerClient.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            AccessibilityEvent accessibilityevent;
            boolean flag1;
            int l;
            if(parcel.readInt() != 0)
                accessibilityevent = (AccessibilityEvent)AccessibilityEvent.CREATOR.createFromParcel(parcel);
            else
                accessibilityevent = null;
            flag1 = sendAccessibilityEvent(accessibilityevent);
            parcel1.writeNoException();
            if(flag1)
                l = ((flag) ? 1 : 0);
            else
                l = 0;
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            List list1 = getInstalledAccessibilityServiceList();
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            List list = getEnabledAccessibilityServiceList(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            interrupt();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            int k = addAccessibilityInteractionConnection(android.view.IWindow.Stub.asInterface(parcel.readStrongBinder()), IAccessibilityInteractionConnection.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            removeAccessibilityInteractionConnection(android.view.IWindow.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            IAccessibilityServiceClient iaccessibilityserviceclient = android.accessibilityservice.IAccessibilityServiceClient.Stub.asInterface(parcel.readStrongBinder());
            AccessibilityServiceInfo accessibilityserviceinfo;
            if(parcel.readInt() != 0)
                accessibilityserviceinfo = (AccessibilityServiceInfo)AccessibilityServiceInfo.CREATOR.createFromParcel(parcel);
            else
                accessibilityserviceinfo = null;
            registerUiTestAutomationService(iaccessibilityserviceclient, accessibilityserviceinfo);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityManager");
            unregisterUiTestAutomationService(android.accessibilityservice.IAccessibilityServiceClient.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final String DESCRIPTOR = "android.view.accessibility.IAccessibilityManager";
        static final int TRANSACTION_addAccessibilityInteractionConnection = 6;
        static final int TRANSACTION_addClient = 1;
        static final int TRANSACTION_getEnabledAccessibilityServiceList = 4;
        static final int TRANSACTION_getInstalledAccessibilityServiceList = 3;
        static final int TRANSACTION_interrupt = 5;
        static final int TRANSACTION_registerUiTestAutomationService = 8;
        static final int TRANSACTION_removeAccessibilityInteractionConnection = 7;
        static final int TRANSACTION_sendAccessibilityEvent = 2;
        static final int TRANSACTION_unregisterUiTestAutomationService = 9;

        public Stub() {
            attachInterface(this, "android.view.accessibility.IAccessibilityManager");
        }
    }


    public abstract int addAccessibilityInteractionConnection(IWindow iwindow, IAccessibilityInteractionConnection iaccessibilityinteractionconnection) throws RemoteException;

    public abstract int addClient(IAccessibilityManagerClient iaccessibilitymanagerclient) throws RemoteException;

    public abstract List getEnabledAccessibilityServiceList(int i) throws RemoteException;

    public abstract List getInstalledAccessibilityServiceList() throws RemoteException;

    public abstract void interrupt() throws RemoteException;

    public abstract void registerUiTestAutomationService(IAccessibilityServiceClient iaccessibilityserviceclient, AccessibilityServiceInfo accessibilityserviceinfo) throws RemoteException;

    public abstract void removeAccessibilityInteractionConnection(IWindow iwindow) throws RemoteException;

    public abstract boolean sendAccessibilityEvent(AccessibilityEvent accessibilityevent) throws RemoteException;

    public abstract void unregisterUiTestAutomationService(IAccessibilityServiceClient iaccessibilityserviceclient) throws RemoteException;
}
