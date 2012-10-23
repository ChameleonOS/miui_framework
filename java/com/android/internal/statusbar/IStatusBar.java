// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.statusbar;

import android.os.*;

// Referenced classes of package com.android.internal.statusbar:
//            StatusBarNotification, StatusBarIcon

public interface IStatusBar
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IStatusBar {
        private static class Proxy
            implements IStatusBar {

            public void addNotification(IBinder ibinder, StatusBarNotification statusbarnotification) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                parcel.writeStrongBinder(ibinder);
                if(statusbarnotification == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                statusbarnotification.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void animateCollapse() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                mRemote.transact(8, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void animateExpand() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancelPreloadRecentApps() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                mRemote.transact(15, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void disable(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                parcel.writeInt(i);
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.statusbar.IStatusBar";
            }

            public void preloadRecentApps() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                mRemote.transact(14, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void removeIcon(int i) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                parcel.writeInt(i);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void removeNotification(IBinder ibinder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(5, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setHardKeyboardStatus(boolean flag, boolean flag1) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                if(!flag)
                    break MISSING_BLOCK_LABEL_60;
                j = i;
_L1:
                parcel.writeInt(j);
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(12, parcel, null, 1);
                parcel.recycle();
                return;
                j = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setIcon(int i, StatusBarIcon statusbaricon) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                parcel.writeInt(i);
                if(statusbaricon == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                statusbaricon.writeToParcel(parcel, 0);
_L1:
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

            public void setImeWindowStatus(IBinder ibinder, int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(11, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void setSystemUiVisibility(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(9, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void toggleRecentApps() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                mRemote.transact(13, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void topAppWindowChanged(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                i = 1;
                parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(10, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void updateNotification(IBinder ibinder, StatusBarNotification statusbarnotification) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.statusbar.IStatusBar");
                parcel.writeStrongBinder(ibinder);
                if(statusbarnotification == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                statusbarnotification.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(4, parcel, null, 1);
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


        public static IStatusBar asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.statusbar.IStatusBar");
                if(iinterface != null && (iinterface instanceof IStatusBar))
                    obj = (IStatusBar)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IStatusBar) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 16: default 144
        //                       1: 167
        //                       2: 217
        //                       3: 234
        //                       4: 284
        //                       5: 334
        //                       6: 351
        //                       7: 368
        //                       8: 381
        //                       9: 394
        //                       10: 415
        //                       11: 447
        //                       12: 472
        //                       13: 523
        //                       14: 536
        //                       15: 549
        //                       1598968902: 158;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L19:
            return flag;
_L17:
            parcel1.writeString("com.android.internal.statusbar.IStatusBar");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            int k = parcel.readInt();
            StatusBarIcon statusbaricon;
            if(parcel.readInt() != 0)
                statusbaricon = (StatusBarIcon)StatusBarIcon.CREATOR.createFromParcel(parcel);
            else
                statusbaricon = null;
            setIcon(k, statusbaricon);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            removeIcon(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            IBinder ibinder1 = parcel.readStrongBinder();
            StatusBarNotification statusbarnotification1;
            if(parcel.readInt() != 0)
                statusbarnotification1 = (StatusBarNotification)StatusBarNotification.CREATOR.createFromParcel(parcel);
            else
                statusbarnotification1 = null;
            addNotification(ibinder1, statusbarnotification1);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            IBinder ibinder = parcel.readStrongBinder();
            StatusBarNotification statusbarnotification;
            if(parcel.readInt() != 0)
                statusbarnotification = (StatusBarNotification)StatusBarNotification.CREATOR.createFromParcel(parcel);
            else
                statusbarnotification = null;
            updateNotification(ibinder, statusbarnotification);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            removeNotification(parcel.readStrongBinder());
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            disable(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            animateExpand();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            animateCollapse();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            setSystemUiVisibility(parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            topAppWindowChanged(flag3);
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            setImeWindowStatus(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            boolean flag1;
            boolean flag2;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            setHardKeyboardStatus(flag1, flag2);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            toggleRecentApps();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            preloadRecentApps();
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("com.android.internal.statusbar.IStatusBar");
            cancelPreloadRecentApps();
            if(true) goto _L19; else goto _L18
_L18:
        }

        private static final String DESCRIPTOR = "com.android.internal.statusbar.IStatusBar";
        static final int TRANSACTION_addNotification = 3;
        static final int TRANSACTION_animateCollapse = 8;
        static final int TRANSACTION_animateExpand = 7;
        static final int TRANSACTION_cancelPreloadRecentApps = 15;
        static final int TRANSACTION_disable = 6;
        static final int TRANSACTION_preloadRecentApps = 14;
        static final int TRANSACTION_removeIcon = 2;
        static final int TRANSACTION_removeNotification = 5;
        static final int TRANSACTION_setHardKeyboardStatus = 12;
        static final int TRANSACTION_setIcon = 1;
        static final int TRANSACTION_setImeWindowStatus = 11;
        static final int TRANSACTION_setSystemUiVisibility = 9;
        static final int TRANSACTION_toggleRecentApps = 13;
        static final int TRANSACTION_topAppWindowChanged = 10;
        static final int TRANSACTION_updateNotification = 4;

        public Stub() {
            attachInterface(this, "com.android.internal.statusbar.IStatusBar");
        }
    }


    public abstract void addNotification(IBinder ibinder, StatusBarNotification statusbarnotification) throws RemoteException;

    public abstract void animateCollapse() throws RemoteException;

    public abstract void animateExpand() throws RemoteException;

    public abstract void cancelPreloadRecentApps() throws RemoteException;

    public abstract void disable(int i) throws RemoteException;

    public abstract void preloadRecentApps() throws RemoteException;

    public abstract void removeIcon(int i) throws RemoteException;

    public abstract void removeNotification(IBinder ibinder) throws RemoteException;

    public abstract void setHardKeyboardStatus(boolean flag, boolean flag1) throws RemoteException;

    public abstract void setIcon(int i, StatusBarIcon statusbaricon) throws RemoteException;

    public abstract void setImeWindowStatus(IBinder ibinder, int i, int j) throws RemoteException;

    public abstract void setSystemUiVisibility(int i, int j) throws RemoteException;

    public abstract void toggleRecentApps() throws RemoteException;

    public abstract void topAppWindowChanged(boolean flag) throws RemoteException;

    public abstract void updateNotification(IBinder ibinder, StatusBarNotification statusbarnotification) throws RemoteException;
}
