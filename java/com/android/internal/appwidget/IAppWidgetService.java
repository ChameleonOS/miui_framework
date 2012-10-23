// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.appwidget;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.*;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.appwidget:
//            IAppWidgetHost

public interface IAppWidgetService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IAppWidgetService {
        private static class Proxy
            implements IAppWidgetService {

            public int allocateAppWidgetId(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public void bindAppWidgetId(int i, ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeInt(i);
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(18, parcel, parcel1, 0);
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

            public boolean bindAppWidgetIdIfAllowed(String s, int i, ComponentName componentname) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeString(s);
                parcel.writeInt(i);
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_96;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int j;
                mRemote.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
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

            public void bindRemoteViewsService(int i, Intent intent, IBinder ibinder) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeInt(i);
                if(intent == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(20, parcel, parcel1, 0);
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

            public void deleteAllHosts() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
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

            public void deleteAppWidgetId(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeInt(i);
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

            public void deleteHost(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
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

            public int[] getAppWidgetIds(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int ai[];
                mRemote.transact(22, parcel, parcel1, 0);
                parcel1.readException();
                ai = parcel1.createIntArray();
                parcel1.recycle();
                parcel.recycle();
                return ai;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public AppWidgetProviderInfo getAppWidgetInfo(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeInt(i);
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                AppWidgetProviderInfo appwidgetproviderinfo = (AppWidgetProviderInfo)AppWidgetProviderInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return appwidgetproviderinfo;
_L2:
                appwidgetproviderinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public Bundle getAppWidgetOptions(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeInt(i);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bundle;
_L2:
                bundle = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public RemoteViews getAppWidgetViews(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
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

            public List getInstalledProviders() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(AppWidgetProviderInfo.CREATOR);
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
                return "com.android.internal.appwidget.IAppWidgetService";
            }

            public boolean hasBindAppWidgetPermission(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeString(s);
                mRemote.transact(16, parcel, parcel1, 0);
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

            public void notifyAppWidgetViewDataChanged(int ai[], int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeIntArray(ai);
                parcel.writeInt(i);
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

            public void partiallyUpdateAppWidgetIds(int ai[], RemoteViews remoteviews) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeIntArray(ai);
                if(remoteviews == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                remoteviews.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(11, parcel, parcel1, 0);
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

            public void setBindAppWidgetPermission(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
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

            public int[] startListening(IAppWidgetHost iappwidgethost, String s, int i, List list) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                if(iappwidgethost == null)
                    break MISSING_BLOCK_LABEL_99;
                ibinder = iappwidgethost.asBinder();
_L1:
                int ai[];
                parcel.writeStrongBinder(ibinder);
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                ai = parcel1.createIntArray();
                parcel1.readTypedList(list, RemoteViews.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return ai;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void stopListening(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
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

            public void unbindRemoteViewsService(int i, Intent intent) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeInt(i);
                if(intent == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(21, parcel, parcel1, 0);
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

            public void updateAppWidgetIds(int ai[], RemoteViews remoteviews) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeIntArray(ai);
                if(remoteviews == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                remoteviews.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(8, parcel, parcel1, 0);
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

            public void updateAppWidgetOptions(int i, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                parcel.writeInt(i);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(9, parcel, parcel1, 0);
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

            public void updateAppWidgetProvider(ComponentName componentname, RemoteViews remoteviews) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.appwidget.IAppWidgetService");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                if(remoteviews == null)
                    break MISSING_BLOCK_LABEL_98;
                parcel.writeInt(1);
                remoteviews.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IAppWidgetService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.appwidget.IAppWidgetService");
                if(iinterface != null && (iinterface instanceof IAppWidgetService))
                    obj = (IAppWidgetService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IAppWidgetService) (obj));
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
            JVM INSTR lookupswitch 23: default 200
        //                       1: 223
        //                       2: 292
        //                       3: 313
        //                       4: 346
        //                       5: 367
        //                       6: 388
        //                       7: 405
        //                       8: 455
        //                       9: 509
        //                       10: 563
        //                       11: 613
        //                       12: 667
        //                       13: 742
        //                       14: 767
        //                       15: 792
        //                       16: 842
        //                       17: 880
        //                       18: 924
        //                       19: 978
        //                       20: 1057
        //                       21: 1115
        //                       22: 1169
        //                       1598968902: 214;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L26:
            return flag;
_L24:
            parcel1.writeString("com.android.internal.appwidget.IAppWidgetService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            IAppWidgetHost iappwidgethost = IAppWidgetHost.Stub.asInterface(parcel.readStrongBinder());
            String s2 = parcel.readString();
            int j2 = parcel.readInt();
            ArrayList arraylist = new ArrayList();
            int ai3[] = startListening(iappwidgethost, s2, j2, arraylist);
            parcel1.writeNoException();
            parcel1.writeIntArray(ai3);
            parcel1.writeTypedList(arraylist);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            stopListening(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            int i2 = allocateAppWidgetId(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(i2);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            deleteAppWidgetId(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            deleteHost(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            deleteAllHosts();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            RemoteViews remoteviews3 = getAppWidgetViews(parcel.readInt());
            parcel1.writeNoException();
            if(remoteviews3 != null) {
                parcel1.writeInt(flag);
                remoteviews3.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            int ai2[] = parcel.createIntArray();
            RemoteViews remoteviews2;
            if(parcel.readInt() != 0)
                remoteviews2 = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel);
            else
                remoteviews2 = null;
            updateAppWidgetIds(ai2, remoteviews2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            int l1 = parcel.readInt();
            Bundle bundle1;
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            updateAppWidgetOptions(l1, bundle1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            Bundle bundle = getAppWidgetOptions(parcel.readInt());
            parcel1.writeNoException();
            if(bundle != null) {
                parcel1.writeInt(flag);
                bundle.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            int ai1[] = parcel.createIntArray();
            RemoteViews remoteviews1;
            if(parcel.readInt() != 0)
                remoteviews1 = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel);
            else
                remoteviews1 = null;
            partiallyUpdateAppWidgetIds(ai1, remoteviews1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            ComponentName componentname3;
            RemoteViews remoteviews;
            if(parcel.readInt() != 0)
                componentname3 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname3 = null;
            if(parcel.readInt() != 0)
                remoteviews = (RemoteViews)RemoteViews.CREATOR.createFromParcel(parcel);
            else
                remoteviews = null;
            updateAppWidgetProvider(componentname3, remoteviews);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            notifyAppWidgetViewDataChanged(parcel.createIntArray(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            List list = getInstalledProviders();
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            AppWidgetProviderInfo appwidgetproviderinfo = getAppWidgetInfo(parcel.readInt());
            parcel1.writeNoException();
            if(appwidgetproviderinfo != null) {
                parcel1.writeInt(flag);
                appwidgetproviderinfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            boolean flag3 = hasBindAppWidgetPermission(parcel.readString());
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            String s1 = parcel.readString();
            boolean flag2;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            setBindAppWidgetPermission(s1, flag2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            int k1 = parcel.readInt();
            ComponentName componentname2;
            if(parcel.readInt() != 0)
                componentname2 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname2 = null;
            bindAppWidgetId(k1, componentname2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            String s = parcel.readString();
            int j1 = parcel.readInt();
            ComponentName componentname1;
            boolean flag1;
            if(parcel.readInt() != 0)
                componentname1 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname1 = null;
            flag1 = bindAppWidgetIdIfAllowed(s, j1, componentname1);
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            int i1 = parcel.readInt();
            Intent intent1;
            if(parcel.readInt() != 0)
                intent1 = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent1 = null;
            bindRemoteViewsService(i1, intent1, parcel.readStrongBinder());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            int l = parcel.readInt();
            Intent intent;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            unbindRemoteViewsService(l, intent);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("com.android.internal.appwidget.IAppWidgetService");
            ComponentName componentname;
            int ai[];
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            ai = getAppWidgetIds(componentname);
            parcel1.writeNoException();
            parcel1.writeIntArray(ai);
            if(true) goto _L26; else goto _L25
_L25:
        }

        private static final String DESCRIPTOR = "com.android.internal.appwidget.IAppWidgetService";
        static final int TRANSACTION_allocateAppWidgetId = 3;
        static final int TRANSACTION_bindAppWidgetId = 18;
        static final int TRANSACTION_bindAppWidgetIdIfAllowed = 19;
        static final int TRANSACTION_bindRemoteViewsService = 20;
        static final int TRANSACTION_deleteAllHosts = 6;
        static final int TRANSACTION_deleteAppWidgetId = 4;
        static final int TRANSACTION_deleteHost = 5;
        static final int TRANSACTION_getAppWidgetIds = 22;
        static final int TRANSACTION_getAppWidgetInfo = 15;
        static final int TRANSACTION_getAppWidgetOptions = 10;
        static final int TRANSACTION_getAppWidgetViews = 7;
        static final int TRANSACTION_getInstalledProviders = 14;
        static final int TRANSACTION_hasBindAppWidgetPermission = 16;
        static final int TRANSACTION_notifyAppWidgetViewDataChanged = 13;
        static final int TRANSACTION_partiallyUpdateAppWidgetIds = 11;
        static final int TRANSACTION_setBindAppWidgetPermission = 17;
        static final int TRANSACTION_startListening = 1;
        static final int TRANSACTION_stopListening = 2;
        static final int TRANSACTION_unbindRemoteViewsService = 21;
        static final int TRANSACTION_updateAppWidgetIds = 8;
        static final int TRANSACTION_updateAppWidgetOptions = 9;
        static final int TRANSACTION_updateAppWidgetProvider = 12;

        public Stub() {
            attachInterface(this, "com.android.internal.appwidget.IAppWidgetService");
        }
    }


    public abstract int allocateAppWidgetId(String s, int i) throws RemoteException;

    public abstract void bindAppWidgetId(int i, ComponentName componentname) throws RemoteException;

    public abstract boolean bindAppWidgetIdIfAllowed(String s, int i, ComponentName componentname) throws RemoteException;

    public abstract void bindRemoteViewsService(int i, Intent intent, IBinder ibinder) throws RemoteException;

    public abstract void deleteAllHosts() throws RemoteException;

    public abstract void deleteAppWidgetId(int i) throws RemoteException;

    public abstract void deleteHost(int i) throws RemoteException;

    public abstract int[] getAppWidgetIds(ComponentName componentname) throws RemoteException;

    public abstract AppWidgetProviderInfo getAppWidgetInfo(int i) throws RemoteException;

    public abstract Bundle getAppWidgetOptions(int i) throws RemoteException;

    public abstract RemoteViews getAppWidgetViews(int i) throws RemoteException;

    public abstract List getInstalledProviders() throws RemoteException;

    public abstract boolean hasBindAppWidgetPermission(String s) throws RemoteException;

    public abstract void notifyAppWidgetViewDataChanged(int ai[], int i) throws RemoteException;

    public abstract void partiallyUpdateAppWidgetIds(int ai[], RemoteViews remoteviews) throws RemoteException;

    public abstract void setBindAppWidgetPermission(String s, boolean flag) throws RemoteException;

    public abstract int[] startListening(IAppWidgetHost iappwidgethost, String s, int i, List list) throws RemoteException;

    public abstract void stopListening(int i) throws RemoteException;

    public abstract void unbindRemoteViewsService(int i, Intent intent) throws RemoteException;

    public abstract void updateAppWidgetIds(int ai[], RemoteViews remoteviews) throws RemoteException;

    public abstract void updateAppWidgetOptions(int i, Bundle bundle) throws RemoteException;

    public abstract void updateAppWidgetProvider(ComponentName componentname, RemoteViews remoteviews) throws RemoteException;
}
