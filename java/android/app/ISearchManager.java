// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import android.os.*;
import java.util.List;

// Referenced classes of package android.app:
//            SearchableInfo

public interface ISearchManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements ISearchManager {
        private static class Proxy
            implements ISearchManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public List getGlobalSearchActivities() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.app.ISearchManager");
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ResolveInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ComponentName getGlobalSearchActivity() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.ISearchManager");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ComponentName componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return componentname;
_L2:
                componentname = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.app.ISearchManager";
            }

            public SearchableInfo getSearchableInfo(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.ISearchManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                SearchableInfo searchableinfo;
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_100;
                searchableinfo = (SearchableInfo)SearchableInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return searchableinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                searchableinfo = null;
                  goto _L4
            }

            public List getSearchablesInGlobalSearch() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.app.ISearchManager");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(SearchableInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ComponentName getWebSearchActivity() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.ISearchManager");
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ComponentName componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return componentname;
_L2:
                componentname = null;
                if(true) goto _L4; else goto _L3
_L3:
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


        public static ISearchManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.ISearchManager");
                if(iinterface != null && (iinterface instanceof ISearchManager))
                    obj = (ISearchManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((ISearchManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 6: default 64
        //                       1: 87
        //                       2: 162
        //                       3: 187
        //                       4: 212
        //                       5: 258
        //                       1598968902: 78;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L9:
            return flag;
_L7:
            parcel1.writeString("android.app.ISearchManager");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.ISearchManager");
            ComponentName componentname2;
            SearchableInfo searchableinfo;
            if(parcel.readInt() != 0)
                componentname2 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname2 = null;
            searchableinfo = getSearchableInfo(componentname2);
            parcel1.writeNoException();
            if(searchableinfo != null) {
                parcel1.writeInt(flag);
                searchableinfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.ISearchManager");
            List list1 = getSearchablesInGlobalSearch();
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.ISearchManager");
            List list = getGlobalSearchActivities();
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.ISearchManager");
            ComponentName componentname1 = getGlobalSearchActivity();
            parcel1.writeNoException();
            if(componentname1 != null) {
                parcel1.writeInt(flag);
                componentname1.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.ISearchManager");
            ComponentName componentname = getWebSearchActivity();
            parcel1.writeNoException();
            if(componentname != null) {
                parcel1.writeInt(flag);
                componentname.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            if(true) goto _L9; else goto _L8
_L8:
        }

        private static final String DESCRIPTOR = "android.app.ISearchManager";
        static final int TRANSACTION_getGlobalSearchActivities = 3;
        static final int TRANSACTION_getGlobalSearchActivity = 4;
        static final int TRANSACTION_getSearchableInfo = 1;
        static final int TRANSACTION_getSearchablesInGlobalSearch = 2;
        static final int TRANSACTION_getWebSearchActivity = 5;

        public Stub() {
            attachInterface(this, "android.app.ISearchManager");
        }
    }


    public abstract List getGlobalSearchActivities() throws RemoteException;

    public abstract ComponentName getGlobalSearchActivity() throws RemoteException;

    public abstract SearchableInfo getSearchableInfo(ComponentName componentname) throws RemoteException;

    public abstract List getSearchablesInGlobalSearch() throws RemoteException;

    public abstract ComponentName getWebSearchActivity() throws RemoteException;
}
