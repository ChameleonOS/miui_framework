// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.*;
import java.util.List;

// Referenced classes of package android.content:
//            ISyncStatusObserver, SyncAdapterType, SyncStatusInfo, SyncInfo, 
//            PeriodicSync

public interface IContentService
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IContentService {
        private static class Proxy
            implements IContentService {

            public void addPeriodicSync(Account account, String s, Bundle bundle, long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_121;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                parcel.writeLong(l);
                mRemote.transact(9, parcel, parcel1, 0);
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

            public void addStatusChangeListener(int i, ISyncStatusObserver isyncstatusobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.IContentService");
                parcel.writeInt(i);
                if(isyncstatusobserver == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = isyncstatusobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(20, parcel, parcel1, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public void cancelSync(Account account, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public List getCurrentSyncs() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.content.IContentService");
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(SyncInfo.CREATOR);
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
                return "android.content.IContentService";
            }

            public int getIsSyncable(Account account, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                int i;
                parcel.writeString(s);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean getMasterSyncAutomatically() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.IContentService");
                mRemote.transact(14, parcel, parcel1, 0);
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

            public List getPeriodicSyncs(Account account, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null)
                    break MISSING_BLOCK_LABEL_78;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                java.util.ArrayList arraylist;
                parcel.writeString(s);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(PeriodicSync.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public SyncAdapterType[] getSyncAdapterTypes() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                SyncAdapterType asyncadaptertype[];
                parcel.writeInterfaceToken("android.content.IContentService");
                mRemote.transact(17, parcel, parcel1, 0);
                parcel1.readException();
                asyncadaptertype = (SyncAdapterType[])parcel1.createTypedArray(SyncAdapterType.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return asyncadaptertype;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean getSyncAutomatically(Account account, String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null)
                    break MISSING_BLOCK_LABEL_88;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                int i;
                parcel.writeString(s);
                mRemote.transact(6, parcel, parcel1, 0);
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

            public SyncStatusInfo getSyncStatus(Account account, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                SyncStatusInfo syncstatusinfo;
                parcel.writeString(s);
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_113;
                syncstatusinfo = (SyncStatusInfo)SyncStatusInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return syncstatusinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                syncstatusinfo = null;
                  goto _L4
            }

            public boolean isSyncActive(Account account, String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null)
                    break MISSING_BLOCK_LABEL_88;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                int i;
                parcel.writeString(s);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public boolean isSyncPending(Account account, String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null)
                    break MISSING_BLOCK_LABEL_88;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                int i;
                parcel.writeString(s);
                mRemote.transact(19, parcel, parcel1, 0);
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

            public void notifyChange(Uri uri, IContentObserver icontentobserver, boolean flag, boolean flag1) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
_L5:
                if(icontentobserver == null) goto _L4; else goto _L3
_L3:
                IBinder ibinder = icontentobserver.asBinder();
_L6:
                int j;
                parcel.writeStrongBinder(ibinder);
                if(!flag)
                    break MISSING_BLOCK_LABEL_145;
                j = i;
_L7:
                parcel.writeInt(j);
                Exception exception;
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L5
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L4:
                ibinder = null;
                  goto _L6
                j = 0;
                  goto _L7
            }

            public void registerContentObserver(Uri uri, boolean flag, IContentObserver icontentobserver) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
                  goto _L3
_L7:
                parcel.writeInt(i);
                if(icontentobserver == null) goto _L5; else goto _L4
_L4:
                IBinder ibinder = icontentobserver.asBinder();
_L6:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(1, parcel, parcel1, 0);
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
_L8:
                i = 0;
                break; /* Loop/switch isn't completed */
_L5:
                ibinder = null;
                  goto _L6
_L3:
                if(!flag) goto _L8; else goto _L7
            }

            public void removePeriodicSync(Account account, String s, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_114;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(10, parcel, parcel1, 0);
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

            public void removeStatusChangeListener(ISyncStatusObserver isyncstatusobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.IContentService");
                if(isyncstatusobserver == null)
                    break MISSING_BLOCK_LABEL_60;
                ibinder = isyncstatusobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(21, parcel, parcel1, 0);
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

            public void requestSync(Account account, String s, Bundle bundle) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L3:
                parcel.writeString(s);
                if(bundle == null)
                    break MISSING_BLOCK_LABEL_113;
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(4, parcel, parcel1, 0);
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

            public void setIsSyncable(Account account, String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null)
                    break MISSING_BLOCK_LABEL_79;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(12, parcel, parcel1, 0);
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

            public void setMasterSyncAutomatically(boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(flag)
                    i = 1;
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

            public void setSyncAutomatically(Account account, String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.IContentService");
                if(account == null)
                    break MISSING_BLOCK_LABEL_87;
                parcel.writeInt(1);
                account.writeToParcel(parcel, 0);
_L1:
                parcel.writeString(s);
                Exception exception;
                if(!flag)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void unregisterContentObserver(IContentObserver icontentobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.IContentService");
                if(icontentobserver == null)
                    break MISSING_BLOCK_LABEL_59;
                ibinder = icontentobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(2, parcel, parcel1, 0);
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


        public static IContentService asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.IContentService");
                if(iinterface != null && (iinterface instanceof IContentService))
                    obj = (IContentService)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IContentService) (obj));
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
            JVM INSTR lookupswitch 22: default 192
        //                       1: 215
        //                       2: 287
        //                       3: 311
        //                       4: 406
        //                       5: 489
        //                       6: 539
        //                       7: 606
        //                       8: 679
        //                       9: 737
        //                       10: 824
        //                       11: 907
        //                       12: 965
        //                       13: 1019
        //                       14: 1055
        //                       15: 1089
        //                       16: 1156
        //                       17: 1181
        //                       18: 1208
        //                       19: 1287
        //                       20: 1354
        //                       21: 1382
        //                       1598968902: 206;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L25:
            return flag;
_L23:
            parcel1.writeString("android.content.IContentService");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.IContentService");
            Uri uri1;
            boolean flag9;
            if(parcel.readInt() != 0)
                uri1 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri1 = null;
            if(parcel.readInt() != 0)
                flag9 = flag;
            else
                flag9 = false;
            registerContentObserver(uri1, flag9, android.database.IContentObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.content.IContentService");
            unregisterContentObserver(android.database.IContentObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.content.IContentService");
            Uri uri;
            IContentObserver icontentobserver;
            boolean flag7;
            boolean flag8;
            if(parcel.readInt() != 0)
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri = null;
            icontentobserver = android.database.IContentObserver.Stub.asInterface(parcel.readStrongBinder());
            if(parcel.readInt() != 0)
                flag7 = flag;
            else
                flag7 = false;
            if(parcel.readInt() != 0)
                flag8 = flag;
            else
                flag8 = false;
            notifyChange(uri, icontentobserver, flag7, flag8);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.content.IContentService");
            Account account11;
            String s3;
            Bundle bundle2;
            if(parcel.readInt() != 0)
                account11 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account11 = null;
            s3 = parcel.readString();
            if(parcel.readInt() != 0)
                bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle2 = null;
            requestSync(account11, s3, bundle2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.content.IContentService");
            Account account10;
            if(parcel.readInt() != 0)
                account10 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account10 = null;
            cancelSync(account10, parcel.readString());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.content.IContentService");
            Account account9;
            boolean flag6;
            if(parcel.readInt() != 0)
                account9 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account9 = null;
            flag6 = getSyncAutomatically(account9, parcel.readString());
            parcel1.writeNoException();
            if(flag6)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.content.IContentService");
            Account account8;
            String s2;
            boolean flag5;
            if(parcel.readInt() != 0)
                account8 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account8 = null;
            s2 = parcel.readString();
            if(parcel.readInt() != 0)
                flag5 = flag;
            else
                flag5 = false;
            setSyncAutomatically(account8, s2, flag5);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.content.IContentService");
            Account account7;
            List list1;
            if(parcel.readInt() != 0)
                account7 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account7 = null;
            list1 = getPeriodicSyncs(account7, parcel.readString());
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.content.IContentService");
            Account account6;
            String s1;
            Bundle bundle1;
            if(parcel.readInt() != 0)
                account6 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account6 = null;
            s1 = parcel.readString();
            if(parcel.readInt() != 0)
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle1 = null;
            addPeriodicSync(account6, s1, bundle1, parcel.readLong());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.content.IContentService");
            Account account5;
            String s;
            Bundle bundle;
            if(parcel.readInt() != 0)
                account5 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account5 = null;
            s = parcel.readString();
            if(parcel.readInt() != 0)
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            else
                bundle = null;
            removePeriodicSync(account5, s, bundle);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.content.IContentService");
            Account account4;
            int l;
            if(parcel.readInt() != 0)
                account4 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account4 = null;
            l = getIsSyncable(account4, parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(l);
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.content.IContentService");
            Account account3;
            if(parcel.readInt() != 0)
                account3 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account3 = null;
            setIsSyncable(account3, parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.content.IContentService");
            boolean flag4;
            if(parcel.readInt() != 0)
                flag4 = flag;
            else
                flag4 = false;
            setMasterSyncAutomatically(flag4);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.content.IContentService");
            boolean flag3 = getMasterSyncAutomatically();
            parcel1.writeNoException();
            if(flag3)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.content.IContentService");
            Account account2;
            boolean flag2;
            if(parcel.readInt() != 0)
                account2 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account2 = null;
            flag2 = isSyncActive(account2, parcel.readString());
            parcel1.writeNoException();
            if(flag2)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.content.IContentService");
            List list = getCurrentSyncs();
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.content.IContentService");
            SyncAdapterType asyncadaptertype[] = getSyncAdapterTypes();
            parcel1.writeNoException();
            parcel1.writeTypedArray(asyncadaptertype, flag);
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.content.IContentService");
            Account account1;
            SyncStatusInfo syncstatusinfo;
            if(parcel.readInt() != 0)
                account1 = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account1 = null;
            syncstatusinfo = getSyncStatus(account1, parcel.readString());
            parcel1.writeNoException();
            if(syncstatusinfo != null) {
                parcel1.writeInt(flag);
                syncstatusinfo.writeToParcel(parcel1, flag);
            } else {
                parcel1.writeInt(0);
            }
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.content.IContentService");
            Account account;
            boolean flag1;
            if(parcel.readInt() != 0)
                account = (Account)Account.CREATOR.createFromParcel(parcel);
            else
                account = null;
            flag1 = isSyncPending(account, parcel.readString());
            parcel1.writeNoException();
            if(flag1)
                k = ((flag) ? 1 : 0);
            parcel1.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.content.IContentService");
            addStatusChangeListener(parcel.readInt(), ISyncStatusObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.content.IContentService");
            removeStatusChangeListener(ISyncStatusObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if(true) goto _L25; else goto _L24
_L24:
        }

        private static final String DESCRIPTOR = "android.content.IContentService";
        static final int TRANSACTION_addPeriodicSync = 9;
        static final int TRANSACTION_addStatusChangeListener = 20;
        static final int TRANSACTION_cancelSync = 5;
        static final int TRANSACTION_getCurrentSyncs = 16;
        static final int TRANSACTION_getIsSyncable = 11;
        static final int TRANSACTION_getMasterSyncAutomatically = 14;
        static final int TRANSACTION_getPeriodicSyncs = 8;
        static final int TRANSACTION_getSyncAdapterTypes = 17;
        static final int TRANSACTION_getSyncAutomatically = 6;
        static final int TRANSACTION_getSyncStatus = 18;
        static final int TRANSACTION_isSyncActive = 15;
        static final int TRANSACTION_isSyncPending = 19;
        static final int TRANSACTION_notifyChange = 3;
        static final int TRANSACTION_registerContentObserver = 1;
        static final int TRANSACTION_removePeriodicSync = 10;
        static final int TRANSACTION_removeStatusChangeListener = 21;
        static final int TRANSACTION_requestSync = 4;
        static final int TRANSACTION_setIsSyncable = 12;
        static final int TRANSACTION_setMasterSyncAutomatically = 13;
        static final int TRANSACTION_setSyncAutomatically = 7;
        static final int TRANSACTION_unregisterContentObserver = 2;

        public Stub() {
            attachInterface(this, "android.content.IContentService");
        }
    }


    public abstract void addPeriodicSync(Account account, String s, Bundle bundle, long l) throws RemoteException;

    public abstract void addStatusChangeListener(int i, ISyncStatusObserver isyncstatusobserver) throws RemoteException;

    public abstract void cancelSync(Account account, String s) throws RemoteException;

    public abstract List getCurrentSyncs() throws RemoteException;

    public abstract int getIsSyncable(Account account, String s) throws RemoteException;

    public abstract boolean getMasterSyncAutomatically() throws RemoteException;

    public abstract List getPeriodicSyncs(Account account, String s) throws RemoteException;

    public abstract SyncAdapterType[] getSyncAdapterTypes() throws RemoteException;

    public abstract boolean getSyncAutomatically(Account account, String s) throws RemoteException;

    public abstract SyncStatusInfo getSyncStatus(Account account, String s) throws RemoteException;

    public abstract boolean isSyncActive(Account account, String s) throws RemoteException;

    public abstract boolean isSyncPending(Account account, String s) throws RemoteException;

    public abstract void notifyChange(Uri uri, IContentObserver icontentobserver, boolean flag, boolean flag1) throws RemoteException;

    public abstract void registerContentObserver(Uri uri, boolean flag, IContentObserver icontentobserver) throws RemoteException;

    public abstract void removePeriodicSync(Account account, String s, Bundle bundle) throws RemoteException;

    public abstract void removeStatusChangeListener(ISyncStatusObserver isyncstatusobserver) throws RemoteException;

    public abstract void requestSync(Account account, String s, Bundle bundle) throws RemoteException;

    public abstract void setIsSyncable(Account account, String s, int i) throws RemoteException;

    public abstract void setMasterSyncAutomatically(boolean flag) throws RemoteException;

    public abstract void setSyncAutomatically(Account account, String s, boolean flag) throws RemoteException;

    public abstract void unregisterContentObserver(IContentObserver icontentobserver) throws RemoteException;
}
