// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Intent;
import android.os.*;
import android.widget.RemoteViews;

public interface IRemoteViewsFactory
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IRemoteViewsFactory {
        private static class Proxy
            implements IRemoteViewsFactory {

            public IBinder asBinder() {
                return mRemote;
            }

            public int getCount() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.widget.IRemoteViewsFactory";
            }

            public long getItemId(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public RemoteViews getLoadingView() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                RemoteViews remoteviews = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return remoteviews;
_L2:
                remoteviews = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public RemoteViews getViewAt(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                RemoteViews remoteviews = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return remoteviews;
_L2:
                remoteviews = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getViewTypeCount() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean hasStableIds() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
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

            public boolean isCreated() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void onDataSetChanged() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
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

            public void onDataSetChangedAsync() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onDestroy(Intent intent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.widget.IRemoteViewsFactory");
                if(intent == null)
                    break MISSING_BLOCK_LABEL_44;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IRemoteViewsFactory asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.widget.IRemoteViewsFactory");
                if(iinterface != null && (iinterface instanceof IRemoteViewsFactory))
                    obj = (IRemoteViewsFactory)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IRemoteViewsFactory) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            int k;
            boolean flag;
            k = 0;
            flag = true;
            i;
            JVM INSTR lookupswitch 11: default 104
        //                       1: 127
        //                       2: 144
        //                       3: 157
        //                       4: 199
        //                       5: 224
        //                       6: 274
        //                       7: 320
        //                       8: 345
        //                       9: 374
        //                       10: 408
        //                       1598968902: 118;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L14:
            return flag;
_L12:
            parcel1.writeString("com.android.internal.widget.IRemoteViewsFactory");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            onDataSetChanged();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            onDataSetChangedAsync();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            Intent intent;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            onDestroy(intent);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            int j1 = getCount();
            parcel1.writeNoException();
            parcel1.writeInt(j1);
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            RemoteViews remoteviews1 = getViewAt(parcel.readInt());
            parcel1.writeNoException();
            if(remoteviews1 != null) {
                parcel1.writeInt(flag);
                remoteviews1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            RemoteViews remoteviews = getLoadingView();
            parcel1.writeNoException();
            if(remoteviews != null) {
                parcel1.writeInt(flag);
                remoteviews.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            int i1 = getViewTypeCount();
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            long l = getItemId(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeLong(l);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            boolean flag2 = hasStableIds();
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.widget.IRemoteViewsFactory");
            boolean flag1 = isCreated();
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            if(true) goto _L14; else goto _L13
_L13:
        }

        private static final String DESCRIPTOR = "com.android.internal.widget.IRemoteViewsFactory";
        static final int TRANSACTION_getCount = 4;
        static final int TRANSACTION_getItemId = 8;
        static final int TRANSACTION_getLoadingView = 6;
        static final int TRANSACTION_getViewAt = 5;
        static final int TRANSACTION_getViewTypeCount = 7;
        static final int TRANSACTION_hasStableIds = 9;
        static final int TRANSACTION_isCreated = 10;
        static final int TRANSACTION_onDataSetChanged = 1;
        static final int TRANSACTION_onDataSetChangedAsync = 2;
        static final int TRANSACTION_onDestroy = 3;

        public Stub() {
            attachInterface(this, "com.android.internal.widget.IRemoteViewsFactory");
        }
    }


    public abstract int getCount() throws RemoteException;

    public abstract long getItemId(int i) throws RemoteException;

    public abstract RemoteViews getLoadingView() throws RemoteException;

    public abstract RemoteViews getViewAt(int i) throws RemoteException;

    public abstract int getViewTypeCount() throws RemoteException;

    public abstract boolean hasStableIds() throws RemoteException;

    public abstract boolean isCreated() throws RemoteException;

    public abstract void onDataSetChanged() throws RemoteException;

    public abstract void onDataSetChangedAsync() throws RemoteException;

    public abstract void onDestroy(Intent intent) throws RemoteException;
}
