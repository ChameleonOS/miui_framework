// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.database.IContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.util.SparseIntArray;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package android.content:
//            SyncManager, Context, SyncStorageEngine, ContentResolver, 
//            IContentService, ISyncStatusObserver, SyncAdapterType, SyncStatusInfo

public final class ContentService extends IContentService.Stub {
    public static final class ObserverNode {
        private class ObserverEntry
            implements android.os.IBinder.DeathRecipient {

            public void binderDied() {
                Object obj = observersLock;
                obj;
                JVM INSTR monitorenter ;
                removeObserverLocked(observer);
                return;
            }

            public void dumpLocked(FileDescriptor filedescriptor, PrintWriter printwriter, String as[], String s, String s1, SparseIntArray sparseintarray) {
                sparseintarray.put(pid, 1 + sparseintarray.get(pid));
                printwriter.print(s1);
                printwriter.print(s);
                printwriter.print(": pid=");
                printwriter.print(pid);
                printwriter.print(" uid=");
                printwriter.print(uid);
                printwriter.print(" target=");
                IBinder ibinder;
                if(observer != null)
                    ibinder = observer.asBinder();
                else
                    ibinder = null;
                printwriter.println(Integer.toHexString(System.identityHashCode(ibinder)));
            }

            public final boolean notifyForDescendents;
            public final IContentObserver observer;
            private final Object observersLock;
            public final int pid;
            final ObserverNode this$0;
            public final int uid;

            public ObserverEntry(IContentObserver icontentobserver, boolean flag, Object obj, int i, int j) {
                this$0 = ObserverNode.this;
                super();
                observersLock = obj;
                observer = icontentobserver;
                uid = i;
                pid = j;
                notifyForDescendents = flag;
                observer.asBinder().linkToDeath(this, 0);
_L1:
                return;
                RemoteException remoteexception;
                remoteexception;
                binderDied();
                  goto _L1
            }
        }


        private void addObserverLocked(Uri uri, int i, IContentObserver icontentobserver, boolean flag, Object obj, int j, int k) {
            if(i != countUriSegments(uri)) goto _L2; else goto _L1
_L1:
            mObservers.add(new ObserverEntry(icontentobserver, flag, obj, j, k));
_L4:
            return;
_L2:
            String s = getUriSegment(uri, i);
            if(s == null)
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid Uri (").append(uri).append(") used for observer").toString());
            int l = mChildren.size();
            int i1 = 0;
            do {
                if(i1 >= l)
                    break;
                ObserverNode observernode1 = (ObserverNode)mChildren.get(i1);
                if(observernode1.mName.equals(s)) {
                    observernode1.addObserverLocked(uri, i + 1, icontentobserver, flag, obj, j, k);
                    continue; /* Loop/switch isn't completed */
                }
                i1++;
            } while(true);
            ObserverNode observernode = new ObserverNode(s);
            mChildren.add(observernode);
            observernode.addObserverLocked(uri, i + 1, icontentobserver, flag, obj, j, k);
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void collectMyObserversLocked(boolean flag, IContentObserver icontentobserver, boolean flag1, ArrayList arraylist) {
            ObserverEntry observerentry;
            boolean flag2;
            int i = mObservers.size();
            IBinder ibinder;
            int j;
            if(icontentobserver == null)
                ibinder = null;
            else
                ibinder = icontentobserver.asBinder();
            j = 0;
            break MISSING_BLOCK_LABEL_19;
            if(j >= i)
                break;
            observerentry = (ObserverEntry)mObservers.get(j);
            if(observerentry.observer.asBinder() == ibinder)
                flag2 = true;
            else
                flag2 = false;
            if((!flag2 || flag1) && (flag || !flag && observerentry.notifyForDescendents))
                arraylist.add(new ObserverCall(this, observerentry.observer, flag2));
            break MISSING_BLOCK_LABEL_67;
            for(j++; true;)
                break MISSING_BLOCK_LABEL_19;

            return;
        }

        private int countUriSegments(Uri uri) {
            int i;
            if(uri == null)
                i = 0;
            else
                i = 1 + uri.getPathSegments().size();
            return i;
        }

        private String getUriSegment(Uri uri, int i) {
            String s;
            if(uri != null) {
                if(i == 0)
                    s = uri.getAuthority();
                else
                    s = (String)uri.getPathSegments().get(i - 1);
            } else {
                s = null;
            }
            return s;
        }

        public void addObserverLocked(Uri uri, IContentObserver icontentobserver, boolean flag, Object obj, int i, int j) {
            addObserverLocked(uri, 0, icontentobserver, flag, obj, i, j);
        }

        public void collectObserversLocked(Uri uri, int i, IContentObserver icontentobserver, boolean flag, ArrayList arraylist) {
            String s = null;
            int j = countUriSegments(uri);
            int k;
            int l;
            if(i >= j)
                collectMyObserversLocked(true, icontentobserver, flag, arraylist);
            else
            if(i < j) {
                s = getUriSegment(uri, i);
                collectMyObserversLocked(false, icontentobserver, flag, arraylist);
            }
            k = mChildren.size();
            l = 0;
            do {
label0:
                {
                    if(l < k) {
                        ObserverNode observernode = (ObserverNode)mChildren.get(l);
                        if(s != null && !observernode.mName.equals(s))
                            break label0;
                        observernode.collectObserversLocked(uri, i + 1, icontentobserver, flag, arraylist);
                        if(s == null)
                            break label0;
                    }
                    return;
                }
                l++;
            } while(true);
        }

        public void dumpLocked(FileDescriptor filedescriptor, PrintWriter printwriter, String as[], String s, String s1, int ai[], SparseIntArray sparseintarray) {
            String s2 = null;
            if(mObservers.size() > 0) {
                int j;
                if("".equals(s))
                    s2 = mName;
                else
                    s2 = (new StringBuilder()).append(s).append("/").append(mName).toString();
                for(j = 0; j < mObservers.size(); j++) {
                    ai[1] = 1 + ai[1];
                    ((ObserverEntry)mObservers.get(j)).dumpLocked(filedescriptor, printwriter, as, s2, s1, sparseintarray);
                }

            }
            if(mChildren.size() > 0) {
                int i;
                if(s2 == null)
                    if("".equals(s))
                        s2 = mName;
                    else
                        s2 = (new StringBuilder()).append(s).append("/").append(mName).toString();
                for(i = 0; i < mChildren.size(); i++) {
                    ai[0] = 1 + ai[0];
                    ((ObserverNode)mChildren.get(i)).dumpLocked(filedescriptor, printwriter, as, s2, s1, ai, sparseintarray);
                }

            }
        }

        public boolean removeObserverLocked(IContentObserver icontentobserver) {
            int i = mChildren.size();
            for(int j = 0; j < i; j++)
                if(((ObserverNode)mChildren.get(j)).removeObserverLocked(icontentobserver)) {
                    mChildren.remove(j);
                    j--;
                    i--;
                }

            IBinder ibinder = icontentobserver.asBinder();
            int k = mObservers.size();
            int l = 0;
            do {
label0:
                {
                    if(l < k) {
                        ObserverEntry observerentry = (ObserverEntry)mObservers.get(l);
                        if(observerentry.observer.asBinder() != ibinder)
                            break label0;
                        mObservers.remove(l);
                        ibinder.unlinkToDeath(observerentry, 0);
                    }
                    boolean flag;
                    if(mChildren.size() == 0 && mObservers.size() == 0)
                        flag = true;
                    else
                        flag = false;
                    return flag;
                }
                l++;
            } while(true);
        }

        public static final int DELETE_TYPE = 2;
        public static final int INSERT_TYPE = 0;
        public static final int UPDATE_TYPE = 1;
        private ArrayList mChildren;
        private String mName;
        private ArrayList mObservers;


        public ObserverNode(String s) {
            mChildren = new ArrayList();
            mObservers = new ArrayList();
            mName = s;
        }
    }

    public static final class ObserverCall {

        final ObserverNode mNode;
        final IContentObserver mObserver;
        final boolean mSelfChange;

        ObserverCall(ObserverNode observernode, IContentObserver icontentobserver, boolean flag) {
            mNode = observernode;
            mObserver = icontentobserver;
            mSelfChange = flag;
        }
    }


    ContentService(Context context, boolean flag) {
        mSyncManager = null;
        mContext = context;
        mFactoryTest = flag;
        getSyncManager();
    }

    private SyncManager getSyncManager() {
        Object obj = mSyncManagerLock;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        SyncManager syncmanager;
        try {
            if(mSyncManager == null)
                mSyncManager = new SyncManager(mContext, mFactoryTest);
        }
        catch(SQLiteException sqliteexception) {
            Log.e("ContentService", "Can't create SyncManager", sqliteexception);
        }
        finally {
            obj;
        }
        syncmanager = mSyncManager;
        return syncmanager;
        throw exception;
    }

    public static IContentService main(Context context, boolean flag) {
        ContentService contentservice = new ContentService(context, flag);
        ServiceManager.addService("content", contentservice);
        return contentservice;
    }

    public void addPeriodicSync(Account account, String s, Bundle bundle, long l) {
        int i;
        long l1;
        mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        i = UserId.getCallingUserId();
        l1 = clearCallingIdentity();
        getSyncManager().getSyncStorageEngine().addPeriodicSync(account, i, s, bundle, l);
        restoreCallingIdentity(l1);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l1);
        throw exception;
    }

    public void addStatusChangeListener(int i, ISyncStatusObserver isyncstatusobserver) {
        long l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager != null && isyncstatusobserver != null)
            syncmanager.getSyncStorageEngine().addStatusChangeListener(i, isyncstatusobserver);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void cancelSync(Account account, String s) {
        int i;
        long l;
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager != null) {
            syncmanager.clearScheduledSyncOperations(account, i, s);
            syncmanager.cancelActiveSync(account, i, s);
        }
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    /**
     * @deprecated Method dump is deprecated
     */

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        this;
        JVM INSTR monitorenter ;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.DUMP", "caller doesn't have the DUMP permission");
        l = clearCallingIdentity();
        if(mSyncManager != null)
            break MISSING_BLOCK_LABEL_130;
        printwriter.println("No SyncManager created!  (Disk full?)");
_L2:
        printwriter.println();
        printwriter.println("Observer tree:");
        ObserverNode observernode = mRootNode;
        observernode;
        JVM INSTR monitorenter ;
        int ai[];
        final SparseIntArray pidCounts;
        ArrayList arraylist;
        int i;
        ai = new int[2];
        pidCounts = new SparseIntArray();
        mRootNode.dumpLocked(filedescriptor, printwriter, as, "", "  ", ai, pidCounts);
        printwriter.println();
        arraylist = new ArrayList();
        i = 0;
_L1:
        if(i >= pidCounts.size())
            break MISSING_BLOCK_LABEL_159;
        arraylist.add(Integer.valueOf(pidCounts.keyAt(i)));
        i++;
          goto _L1
        mSyncManager.dump(filedescriptor, printwriter);
          goto _L2
        Exception exception1;
        exception1;
        restoreCallingIdentity(l);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Collections.sort(arraylist, new Comparator() {

            public int compare(Integer integer, Integer integer1) {
                int i1 = pidCounts.get(integer.intValue());
                int j1 = pidCounts.get(integer1.intValue());
                int k1;
                if(i1 < j1)
                    k1 = 1;
                else
                if(i1 > j1)
                    k1 = -1;
                else
                    k1 = 0;
                return k1;
            }

            public volatile int compare(Object obj, Object obj1) {
                return compare((Integer)obj, (Integer)obj1);
            }

            final ContentService this$0;
            final SparseIntArray val$pidCounts;

             {
                this$0 = ContentService.this;
                pidCounts = sparseintarray;
                super();
            }
        });
        for(int j = 0; j < arraylist.size(); j++) {
            int k = ((Integer)arraylist.get(j)).intValue();
            printwriter.print("  pid ");
            printwriter.print(k);
            printwriter.print(": ");
            printwriter.print(pidCounts.get(k));
            printwriter.println(" observers");
        }

        printwriter.println();
        printwriter.print(" Total number of nodes: ");
        printwriter.println(ai[0]);
        printwriter.print(" Total number of observers: ");
        printwriter.println(ai[1]);
        observernode;
        JVM INSTR monitorexit ;
        restoreCallingIdentity(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception2;
        exception2;
        observernode;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    public List getCurrentSyncs() {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_STATS", "no permission to read the sync stats");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        List list = getSyncManager().getSyncStorageEngine().getCurrentSyncs(i);
        restoreCallingIdentity(l);
        return list;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public int getIsSyncable(Account account, String s) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_SETTINGS", "no permission to read the sync settings");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager == null) goto _L2; else goto _L1
_L1:
        int k = syncmanager.getSyncStorageEngine().getIsSyncable(account, i, s);
        int j;
        j = k;
        restoreCallingIdentity(l);
_L4:
        return j;
_L2:
        restoreCallingIdentity(l);
        j = -1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public boolean getMasterSyncAutomatically() {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_SETTINGS", "no permission to read the sync settings");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = syncmanager.getSyncStorageEngine().getMasterSyncAutomatically(i);
        boolean flag;
        flag = flag1;
        restoreCallingIdentity(l);
_L4:
        return flag;
_L2:
        restoreCallingIdentity(l);
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public List getPeriodicSyncs(Account account, String s) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_SETTINGS", "no permission to read the sync settings");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        List list = getSyncManager().getSyncStorageEngine().getPeriodicSyncs(account, i, s);
        restoreCallingIdentity(l);
        return list;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public SyncAdapterType[] getSyncAdapterTypes() {
        long l = clearCallingIdentity();
        SyncAdapterType asyncadaptertype[] = getSyncManager().getSyncAdapterTypes();
        restoreCallingIdentity(l);
        return asyncadaptertype;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public boolean getSyncAutomatically(Account account, String s) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_SETTINGS", "no permission to read the sync settings");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = syncmanager.getSyncStorageEngine().getSyncAutomatically(account, i, s);
        boolean flag;
        flag = flag1;
        restoreCallingIdentity(l);
_L4:
        return flag;
_L2:
        restoreCallingIdentity(l);
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public SyncStatusInfo getSyncStatus(Account account, String s) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_STATS", "no permission to read the sync stats");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager == null) goto _L2; else goto _L1
_L1:
        SyncStatusInfo syncstatusinfo1 = syncmanager.getSyncStorageEngine().getStatusByAccountAndAuthority(account, i, s);
        SyncStatusInfo syncstatusinfo;
        syncstatusinfo = syncstatusinfo1;
        restoreCallingIdentity(l);
_L4:
        return syncstatusinfo;
_L2:
        restoreCallingIdentity(l);
        syncstatusinfo = null;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public boolean isSyncActive(Account account, String s) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_STATS", "no permission to read the sync stats");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = syncmanager.getSyncStorageEngine().isSyncActive(account, i, s);
        boolean flag;
        flag = flag1;
        restoreCallingIdentity(l);
_L4:
        return flag;
_L2:
        restoreCallingIdentity(l);
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public boolean isSyncPending(Account account, String s) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.READ_SYNC_STATS", "no permission to read the sync stats");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = syncmanager.getSyncStorageEngine().isSyncPending(account, i, s);
        boolean flag;
        flag = flag1;
        restoreCallingIdentity(l);
_L4:
        return flag;
_L2:
        restoreCallingIdentity(l);
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void notifyChange(Uri uri, IContentObserver icontentobserver, boolean flag, boolean flag1) {
        int i;
        long l;
        if(Log.isLoggable("ContentService", 2))
            Log.v("ContentService", (new StringBuilder()).append("Notifying update of ").append(uri).append(" from observer ").append(icontentobserver).append(", syncToNetwork ").append(flag1).toString());
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        ArrayList arraylist = new ArrayList();
        synchronized(mRootNode) {
            mRootNode.collectObserversLocked(uri, 0, icontentobserver, flag, arraylist);
        }
        int j;
        int k;
        j = arraylist.size();
        k = 0;
_L3:
        if(k >= j) goto _L2; else goto _L1
_L1:
        ObserverCall observercall = (ObserverCall)arraylist.get(k);
        observercall.mObserver.onChange(observercall.mSelfChange, uri);
        if(Log.isLoggable("ContentService", 2))
            Log.v("ContentService", (new StringBuilder()).append("Notified ").append(observercall.mObserver).append(" of ").append("update at ").append(uri).toString());
_L5:
        k++;
          goto _L3
        exception1;
        observernode;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        ObserverNode observernode1 = mRootNode;
        observernode1;
        JVM INSTR monitorenter ;
        IBinder ibinder;
        ArrayList arraylist1;
        int i1;
        int j1;
        Log.w("ContentService", "Found dead observer, removing");
        ibinder = observercall.mObserver.asBinder();
        arraylist1 = observercall.mNode.mObservers;
        i1 = arraylist1.size();
        j1 = 0;
_L7:
        if(j1 >= i1) goto _L5; else goto _L4
_L2:
        if(flag1) {
            SyncManager syncmanager = getSyncManager();
            if(syncmanager != null)
                syncmanager.scheduleLocalSync(null, i, uri.getAuthority());
        }
        restoreCallingIdentity(l);
        return;
_L4:
        if(((ObserverNode.ObserverEntry)arraylist1.get(j1)).observer.asBinder() == ibinder) {
            arraylist1.remove(j1);
            j1--;
            i1--;
        }
        j1++;
        if(true) goto _L7; else goto _L6
_L6:
          goto _L5
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
        boolean flag;
        try {
            flag = super.onTransact(i, parcel, parcel1, j);
        }
        catch(RuntimeException runtimeexception) {
            if(!(runtimeexception instanceof SecurityException))
                Log.e("ContentService", "Content Service Crash", runtimeexception);
            throw runtimeexception;
        }
        return flag;
    }

    public void registerContentObserver(Uri uri, boolean flag, IContentObserver icontentobserver) {
        if(icontentobserver == null || uri == null)
            throw new IllegalArgumentException("You must pass a valid uri and observer");
        ObserverNode observernode = mRootNode;
        observernode;
        JVM INSTR monitorenter ;
        mRootNode.addObserverLocked(uri, icontentobserver, flag, mRootNode, Binder.getCallingUid(), Binder.getCallingPid());
        return;
    }

    public void removePeriodicSync(Account account, String s, Bundle bundle) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        getSyncManager().getSyncStorageEngine().removePeriodicSync(account, i, s, bundle);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void removeStatusChangeListener(ISyncStatusObserver isyncstatusobserver) {
        long l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager != null && isyncstatusobserver != null)
            syncmanager.getSyncStorageEngine().removeStatusChangeListener(isyncstatusobserver);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void requestSync(Account account, String s, Bundle bundle) {
        int i;
        long l;
        ContentResolver.validateSyncExtrasBundle(bundle);
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager != null)
            syncmanager.scheduleSync(account, i, s, bundle, 0L, false);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void setIsSyncable(Account account, String s, int i) {
        int j;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        j = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager != null)
            syncmanager.getSyncStorageEngine().setIsSyncable(account, j, s, i);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void setMasterSyncAutomatically(boolean flag) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager != null)
            syncmanager.getSyncStorageEngine().setMasterSyncAutomatically(flag, i);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void setSyncAutomatically(Account account, String s, boolean flag) {
        int i;
        long l;
        mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SYNC_SETTINGS", "no permission to write the sync settings");
        i = UserId.getCallingUserId();
        l = clearCallingIdentity();
        SyncManager syncmanager = getSyncManager();
        if(syncmanager != null)
            syncmanager.getSyncStorageEngine().setSyncAutomatically(account, i, s, flag);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void unregisterContentObserver(IContentObserver icontentobserver) {
        if(icontentobserver == null)
            throw new IllegalArgumentException("You must pass a valid observer");
        ObserverNode observernode = mRootNode;
        observernode;
        JVM INSTR monitorenter ;
        mRootNode.removeObserverLocked(icontentobserver);
        return;
    }

    private static final String TAG = "ContentService";
    private Context mContext;
    private boolean mFactoryTest;
    private final ObserverNode mRootNode = new ObserverNode("");
    private SyncManager mSyncManager;
    private final Object mSyncManagerLock = new Object();
}
