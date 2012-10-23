// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.os.*;
import java.util.List;

// Referenced classes of package android.view.accessibility:
//            AccessibilityNodeInfo

public interface IAccessibilityInteractionConnectionCallback
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAccessibilityInteractionConnectionCallback {
        private static class Proxy
            implements IAccessibilityInteractionConnectionCallback {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.view.accessibility.IAccessibilityInteractionConnectionCallback";
            }

            public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo accessibilitynodeinfo, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnectionCallback");
                if(accessibilitynodeinfo == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                accessibilitynodeinfo.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void setFindAccessibilityNodeInfosResult(List list, int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnectionCallback");
                parcel.writeTypedList(list);
                parcel.writeInt(i);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setPerformAccessibilityActionResult(boolean flag, int i) throws RemoteException {
                int j;
                Parcel parcel;
                j = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("android.view.accessibility.IAccessibilityInteractionConnectionCallback");
                if(!flag)
                    j = 0;
                parcel.writeInt(j);
                parcel.writeInt(i);
                mRemote.transact(3, parcel, null, 1);
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


        public static IAccessibilityInteractionConnectionCallback asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.view.accessibility.IAccessibilityInteractionConnectionCallback");
                if(iinterface != null && (iinterface instanceof IAccessibilityInteractionConnectionCallback))
                    obj = (IAccessibilityInteractionConnectionCallback)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAccessibilityInteractionConnectionCallback) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 117
        //                       3: 141
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("android.view.accessibility.IAccessibilityInteractionConnectionCallback");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnectionCallback");
            AccessibilityNodeInfo accessibilitynodeinfo;
            if(parcel.readInt() != 0)
                accessibilitynodeinfo = (AccessibilityNodeInfo)AccessibilityNodeInfo.CREATOR.createFromParcel(parcel);
            else
                accessibilitynodeinfo = null;
            setFindAccessibilityNodeInfoResult(accessibilitynodeinfo, parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnectionCallback");
            setFindAccessibilityNodeInfosResult(parcel.createTypedArrayList(AccessibilityNodeInfo.CREATOR), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.view.accessibility.IAccessibilityInteractionConnectionCallback");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            setPerformAccessibilityActionResult(flag1, parcel.readInt());
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "android.view.accessibility.IAccessibilityInteractionConnectionCallback";
        static final int TRANSACTION_setFindAccessibilityNodeInfoResult = 1;
        static final int TRANSACTION_setFindAccessibilityNodeInfosResult = 2;
        static final int TRANSACTION_setPerformAccessibilityActionResult = 3;

        public Stub() {
            attachInterface(this, "android.view.accessibility.IAccessibilityInteractionConnectionCallback");
        }
    }


    public abstract void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo accessibilitynodeinfo, int i) throws RemoteException;

    public abstract void setFindAccessibilityNodeInfosResult(List list, int i) throws RemoteException;

    public abstract void setPerformAccessibilityActionResult(boolean flag, int i) throws RemoteException;
}
