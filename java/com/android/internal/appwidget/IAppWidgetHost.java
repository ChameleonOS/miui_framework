// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.appwidget;

import android.appwidget.AppWidgetProviderInfo;
import android.os.*;
import android.widget.RemoteViews;

public interface IAppWidgetHost
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAppWidgetHost {
        private static class Proxy
            implements IAppWidgetHost {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.appwidget.IAppWidgetHost";
            }

            public void providerChanged(int i, AppWidgetProviderInfo appwidgetproviderinfo) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetHost");
                parcel.writeInt(i);
                if(appwidgetproviderinfo == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                appwidgetproviderinfo.writeToParcel(parcel, 0);
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

            public void updateAppWidget(int i, RemoteViews remoteviews) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetHost");
                parcel.writeInt(i);
                if(remoteviews == null)
                    break MISSING_BLOCK_LABEL_49;
                parcel.writeInt(1);
                remoteviews.writeToParcel(parcel, 0);
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

            public void viewDataChanged(int i, int j) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetHost");
                parcel.writeInt(i);
                parcel.writeInt(j);
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


        public static IAppWidgetHost asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.appwidget.IAppWidgetHost");
                if(iinterface != null && (iinterface instanceof IAppWidgetHost))
                    obj = (IAppWidgetHost)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAppWidgetHost) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       1: 71
        //                       2: 121
        //                       3: 171
        //                       1598968902: 62;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L7:
            return flag;
_L5:
            parcel1.writeString("com.android.internal.appwidget.IAppWidgetHost");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetHost");
            int l = parcel.readInt();
            RemoteViews remoteviews;
            if(parcel.readInt() != 0)
                remoteviews = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel);
            else
                remoteviews = null;
            updateAppWidget(l, remoteviews);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetHost");
            int k = parcel.readInt();
            AppWidgetProviderInfo appwidgetproviderinfo;
            if(parcel.readInt() != 0)
                appwidgetproviderinfo = (AppWidgetProviderInfo)AppWidgetProviderInfo.CREATOR.createFromParcel(parcel);
            else
                appwidgetproviderinfo = null;
            providerChanged(k, appwidgetproviderinfo);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetHost");
            viewDataChanged(parcel.readInt(), parcel.readInt());
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static final String DESCRIPTOR = "com.android.internal.appwidget.IAppWidgetHost";
        static final int TRANSACTION_providerChanged = 2;
        static final int TRANSACTION_updateAppWidget = 1;
        static final int TRANSACTION_viewDataChanged = 3;

        public Stub() {
            attachInterface(this, "com.android.internal.appwidget.IAppWidgetHost");
        }
    }


    public abstract void providerChanged(int i, AppWidgetProviderInfo appwidgetproviderinfo) throws RemoteException;

    public abstract void updateAppWidget(int i, RemoteViews remoteviews) throws RemoteException;

    public abstract void viewDataChanged(int i, int j) throws RemoteException;
}
