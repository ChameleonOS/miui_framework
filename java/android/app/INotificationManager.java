// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.*;

// Referenced classes of package android.app:
//            ITransientNotification, Notification

public interface INotificationManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements INotificationManager {
        private static class Proxy
            implements INotificationManager {

            public boolean areNotificationsEnabledForPackage(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.INotificationManager");
                parcel.writeString(s);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancelAllNotifications(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.INotificationManager");
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

            public void cancelNotification(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.INotificationManager");
                parcel.writeString(s);
                parcel.writeInt(i);
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

            public void cancelNotificationWithTag(String s, String s1, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.INotificationManager");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            public void cancelToast(String s, ITransientNotification itransientnotification) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.app.INotificationManager");
                parcel.writeString(s);
                if(itransientnotification == null)
                    break MISSING_BLOCK_LABEL_68;
                ibinder = itransientnotification.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public void enqueueNotification(String s, int i, Notification notification, int ai[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.INotificationManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                if(notification == null)
                    break MISSING_BLOCK_LABEL_92;
                parcel.writeInt(1);
                notification.writeToParcel(parcel, 0);
_L1:
                parcel.writeIntArray(ai);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.readIntArray(ai);
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

            public void enqueueNotificationWithTag(String s, String s1, int i, Notification notification, int ai[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.INotificationManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                parcel.writeInt(i);
                if(notification == null)
                    break MISSING_BLOCK_LABEL_101;
                parcel.writeInt(1);
                notification.writeToParcel(parcel, 0);
_L1:
                parcel.writeIntArray(ai);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.readIntArray(ai);
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

            public void enqueueToast(String s, ITransientNotification itransientnotification, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.app.INotificationManager");
                parcel.writeString(s);
                if(itransientnotification == null)
                    break MISSING_BLOCK_LABEL_80;
                ibinder = itransientnotification.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(4, parcel, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "android.app.INotificationManager";
            }

            public void setNotificationsEnabledForPackage(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.INotificationManager");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static INotificationManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.INotificationManager");
                if(iinterface != null && (iinterface instanceof INotificationManager))
                    obj = (INotificationManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((INotificationManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag;
            boolean flag1;
            flag = false;
            flag1 = true;
            i;
            JVM INSTR lookupswitch 10: default 96
        //                       1: 119
        //                       2: 195
        //                       3: 220
        //                       4: 241
        //                       5: 273
        //                       6: 301
        //                       7: 385
        //                       8: 414
        //                       9: 452
        //                       1598968902: 110;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            flag1 = super.onTransact(i, parcel, parcel1, j);
_L13:
            return flag1;
_L11:
            parcel1.writeString("android.app.INotificationManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.INotificationManager");
            String s3 = parcel.readString();
            int l = parcel.readInt();
            Notification notification1;
            int ai1[];
            if(parcel.readInt() != 0)
                notification1 = (Notification)Notification.CREATOR.createFromParcel(parcel);
            else
                notification1 = null;
            ai1 = parcel.createIntArray();
            enqueueNotification(s3, l, notification1, ai1);
            parcel1.writeNoException();
            parcel1.writeIntArray(ai1);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.INotificationManager");
            cancelNotification(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.INotificationManager");
            cancelAllNotifications(parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.INotificationManager");
            enqueueToast(parcel.readString(), ITransientNotification.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.INotificationManager");
            cancelToast(parcel.readString(), ITransientNotification.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.app.INotificationManager");
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            int k = parcel.readInt();
            Notification notification;
            int ai[];
            if(parcel.readInt() != 0)
                notification = (Notification)Notification.CREATOR.createFromParcel(parcel);
            else
                notification = null;
            ai = parcel.createIntArray();
            enqueueNotificationWithTag(s1, s2, k, notification, ai);
            parcel1.writeNoException();
            parcel1.writeIntArray(ai);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.app.INotificationManager");
            cancelNotificationWithTag(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.app.INotificationManager");
            String s = parcel.readString();
            if(parcel.readInt() != 0)
                flag = flag1;
            setNotificationsEnabledForPackage(s, flag);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.app.INotificationManager");
            boolean flag2 = areNotificationsEnabledForPackage(parcel.readString());
            parcel1.writeNoException();
            if(flag2)
                flag = flag1;
            parcel1.writeInt(flag);
            if(true) goto _L13; else goto _L12
_L12:
        }

        private static final String DESCRIPTOR = "android.app.INotificationManager";
        static final int TRANSACTION_areNotificationsEnabledForPackage = 9;
        static final int TRANSACTION_cancelAllNotifications = 3;
        static final int TRANSACTION_cancelNotification = 2;
        static final int TRANSACTION_cancelNotificationWithTag = 7;
        static final int TRANSACTION_cancelToast = 5;
        static final int TRANSACTION_enqueueNotification = 1;
        static final int TRANSACTION_enqueueNotificationWithTag = 6;
        static final int TRANSACTION_enqueueToast = 4;
        static final int TRANSACTION_setNotificationsEnabledForPackage = 8;

        public Stub() {
            attachInterface(this, "android.app.INotificationManager");
        }
    }


    public abstract boolean areNotificationsEnabledForPackage(String s) throws RemoteException;

    public abstract void cancelAllNotifications(String s) throws RemoteException;

    public abstract void cancelNotification(String s, int i) throws RemoteException;

    public abstract void cancelNotificationWithTag(String s, String s1, int i) throws RemoteException;

    public abstract void cancelToast(String s, ITransientNotification itransientnotification) throws RemoteException;

    public abstract void enqueueNotification(String s, int i, Notification notification, int ai[]) throws RemoteException;

    public abstract void enqueueNotificationWithTag(String s, String s1, int i, Notification notification, int ai[]) throws RemoteException;

    public abstract void enqueueToast(String s, ITransientNotification itransientnotification, int i) throws RemoteException;

    public abstract void setNotificationsEnabledForPackage(String s, boolean flag) throws RemoteException;
}
