// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.statusbar;

import android.os.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.statusbar:
//            IStatusBar, StatusBarIconList, StatusBarNotification

public interface IStatusBarService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IStatusBarService {
        private static class Proxy
            implements IStatusBarService {

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancelPreloadRecentApps() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                mRemote.transact(19, parcel, parcel1, 0);
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

            public void collapse() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
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

            public void disable(int i, IBinder ibinder, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeInt(i);
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void expand() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
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

            public String getInterfaceDescriptor() {
                return "com.android.internal.statusbar.IStatusBarService";
            }

            public void onClearAllNotifications() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                mRemote.transact(13, parcel, parcel1, 0);
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

            public void onNotificationClear(String s, String s1, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
                mRemote.transact(14, parcel, parcel1, 0);
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

            public void onNotificationClick(String s, String s1, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
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

            public void onNotificationError(String s, String s1, int i, int j, int k, String s2) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeString(s2);
                mRemote.transact(12, parcel, parcel1, 0);
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

            public void onPanelRevealed() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void preloadRecentApps() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                mRemote.transact(18, parcel, parcel1, 0);
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

            public void registerStatusBar(IStatusBar istatusbar, StatusBarIconList statusbariconlist, List list, List list1, int ai[], List list2) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                if(istatusbar == null) goto _L2; else goto _L1
_L1:
                IBinder ibinder = istatusbar.asBinder();
_L5:
                parcel.writeStrongBinder(ibinder);
                if(ai != null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(-1);
_L6:
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() != 0)
                    statusbariconlist.readFromParcel(parcel1);
                parcel1.readBinderList(list);
                parcel1.readTypedList(list1, StatusBarNotification.CREATOR);
                parcel1.readIntArray(ai);
                parcel1.readBinderList(list2);
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                ibinder = null;
                  goto _L5
_L4:
                parcel.writeInt(ai.length);
                  goto _L6
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                  goto _L5
            }

            public void removeIcon(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeString(s);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public void setHardKeyboardEnabled(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(16, parcel, parcel1, 0);
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

            public void setIcon(String s, String s1, int i, int j, String s2) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeString(s2);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void setIconVisibility(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
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

            public void setImeWindowStatus(IBinder ibinder, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(8, parcel, parcel1, 0);
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

            public void setSystemUiVisibility(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public void toggleRecentApps() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                mRemote.transact(17, parcel, parcel1, 0);
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

            public void topAppWindowChanged(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBarService");
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
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


        public static IStatusBarService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.statusbar.IStatusBarService");
                if(iinterface != null && (iinterface instanceof IStatusBarService))
                    obj = (IStatusBarService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IStatusBarService) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 20: default 172
        //                       1: 198
        //                       2: 218
        //                       3: 238
        //                       4: 270
        //                       5: 310
        //                       6: 356
        //                       7: 380
        //                       8: 418
        //                       9: 450
        //                       10: 599
        //                       11: 619
        //                       12: 651
        //                       13: 695
        //                       14: 715
        //                       15: 747
        //                       16: 775
        //                       17: 813
        //                       18: 833
        //                       19: 853
        //                       1598968902: 186;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L23:
            return flag;
_L21:
            parcel1.writeString("com.android.internal.statusbar.IStatusBarService");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            expand();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            collapse();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            disable(parcel.readInt(), parcel.readStrongBinder(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            setIcon(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            String s = parcel.readString();
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            setIconVisibility(s, flag3);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            removeIcon(parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = true;
            else
                flag2 = false;
            topAppWindowChanged(flag2);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            setImeWindowStatus(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            IStatusBar istatusbar = IStatusBar.Stub.asInterface(parcel.readStrongBinder());
            StatusBarIconList statusbariconlist = new StatusBarIconList();
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist1 = new ArrayList();
            int k = parcel.readInt();
            int ai[];
            ArrayList arraylist2;
            if(k < 0)
                ai = null;
            else
                ai = new int[k];
            arraylist2 = new ArrayList();
            registerStatusBar(istatusbar, statusbariconlist, arraylist, arraylist1, ai, arraylist2);
            parcel1.writeNoException();
            if(statusbariconlist != null) {
                parcel1.writeInt(1);
                statusbariconlist.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            parcel1.writeBinderList(arraylist);
            parcel1.writeTypedList(arraylist1);
            parcel1.writeIntArray(ai);
            parcel1.writeBinderList(arraylist2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            onPanelRevealed();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            onNotificationClick(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            onNotificationError(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            onClearAllNotifications();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            onNotificationClear(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            setSystemUiVisibility(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = true;
            else
                flag1 = false;
            setHardKeyboardEnabled(flag1);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            toggleRecentApps();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            preloadRecentApps();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBarService");
            cancelPreloadRecentApps();
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L23; else goto _L22
_L22:
        }

        private static final String DESCRIPTOR = "com.android.internal.statusbar.IStatusBarService";
        static final int TRANSACTION_cancelPreloadRecentApps = 19;
        static final int TRANSACTION_collapse = 2;
        static final int TRANSACTION_disable = 3;
        static final int TRANSACTION_expand = 1;
        static final int TRANSACTION_onClearAllNotifications = 13;
        static final int TRANSACTION_onNotificationClear = 14;
        static final int TRANSACTION_onNotificationClick = 11;
        static final int TRANSACTION_onNotificationError = 12;
        static final int TRANSACTION_onPanelRevealed = 10;
        static final int TRANSACTION_preloadRecentApps = 18;
        static final int TRANSACTION_registerStatusBar = 9;
        static final int TRANSACTION_removeIcon = 6;
        static final int TRANSACTION_setHardKeyboardEnabled = 16;
        static final int TRANSACTION_setIcon = 4;
        static final int TRANSACTION_setIconVisibility = 5;
        static final int TRANSACTION_setImeWindowStatus = 8;
        static final int TRANSACTION_setSystemUiVisibility = 15;
        static final int TRANSACTION_toggleRecentApps = 17;
        static final int TRANSACTION_topAppWindowChanged = 7;

        public Stub() {
            attachInterface(this, "com.android.internal.statusbar.IStatusBarService");
        }
    }


    public abstract void cancelPreloadRecentApps() throws RemoteException;

    public abstract void collapse() throws RemoteException;

    public abstract void disable(int i, IBinder ibinder, String s) throws RemoteException;

    public abstract void expand() throws RemoteException;

    public abstract void onClearAllNotifications() throws RemoteException;

    public abstract void onNotificationClear(String s, String s1, int i) throws RemoteException;

    public abstract void onNotificationClick(String s, String s1, int i) throws RemoteException;

    public abstract void onNotificationError(String s, String s1, int i, int j, int k, String s2) throws RemoteException;

    public abstract void onPanelRevealed() throws RemoteException;

    public abstract void preloadRecentApps() throws RemoteException;

    public abstract void registerStatusBar(IStatusBar istatusbar, StatusBarIconList statusbariconlist, List list, List list1, int ai[], List list2) throws RemoteException;

    public abstract void removeIcon(String s) throws RemoteException;

    public abstract void setHardKeyboardEnabled(boolean flag) throws RemoteException;

    public abstract void setIcon(String s, String s1, int i, int j, String s2) throws RemoteException;

    public abstract void setIconVisibility(String s, boolean flag) throws RemoteException;

    public abstract void setImeWindowStatus(IBinder ibinder, int i, int j) throws RemoteException;

    public abstract void setSystemUiVisibility(int i, int j) throws RemoteException;

    public abstract void toggleRecentApps() throws RemoteException;

    public abstract void topAppWindowChanged(boolean flag) throws RemoteException;
}
