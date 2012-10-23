// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.os.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.content:
//            Context, ContentProviderClient, SyncResult, SyncContext, 
//            ContentResolver, ISyncContext

public abstract class AbstractThreadedSyncAdapter {
    private class SyncThread extends Thread {

        private boolean isCanceled() {
            return Thread.currentThread().isInterrupted();
        }

        public void run() {
            SyncResult syncresult;
            ContentProviderClient contentproviderclient;
            Process.setThreadPriority(10);
            Trace.traceBegin(128L, mAuthority);
            syncresult = new SyncResult();
            contentproviderclient = null;
            boolean flag = isCanceled();
            if(!flag) goto _L2; else goto _L1
_L1:
            Trace.traceEnd(128L);
            if(false)
                throw null;
            if(!isCanceled())
                mSyncContext.onFinished(syncresult);
            synchronized(mSyncThreadLock) {
                mSyncThreads.remove(mThreadsKey);
            }
_L8:
            return;
_L2:
            contentproviderclient = mContext.getContentResolver().acquireContentProviderClient(mAuthority);
            if(contentproviderclient == null) goto _L4; else goto _L3
_L3:
            onPerformSync(mAccount, mExtras, mAuthority, contentproviderclient, syncresult);
_L6:
            Trace.traceEnd(128L);
            if(contentproviderclient != null)
                contentproviderclient.release();
            if(!isCanceled())
                mSyncContext.onFinished(syncresult);
            Object obj1 = mSyncThreadLock;
            obj1;
            JVM INSTR monitorenter ;
            mSyncThreads.remove(mThreadsKey);
            continue; /* Loop/switch isn't completed */
_L4:
            syncresult.databaseError = true;
            if(true) goto _L6; else goto _L5
_L5:
            Exception exception;
            exception;
            Trace.traceEnd(128L);
            if(contentproviderclient != null)
                contentproviderclient.release();
            if(!isCanceled())
                mSyncContext.onFinished(syncresult);
            synchronized(mSyncThreadLock) {
                mSyncThreads.remove(mThreadsKey);
            }
            throw exception;
            exception1;
            obj;
            JVM INSTR monitorexit ;
            throw exception1;
            exception2;
            obj2;
            JVM INSTR monitorexit ;
            throw exception2;
            if(true) goto _L8; else goto _L7
_L7:
        }

        private final Account mAccount;
        private final String mAuthority;
        private final Bundle mExtras;
        private final SyncContext mSyncContext;
        private final Account mThreadsKey;
        final AbstractThreadedSyncAdapter this$0;


        private SyncThread(String s, SyncContext synccontext, String s1, Account account, Bundle bundle) {
            this$0 = AbstractThreadedSyncAdapter.this;
            super(s);
            mSyncContext = synccontext;
            mAuthority = s1;
            mAccount = account;
            mExtras = bundle;
            mThreadsKey = toSyncKey(account);
        }

    }

    private class ISyncAdapterImpl extends ISyncAdapter.Stub {

        public void cancelSync(ISyncContext isynccontext) {
            SyncThread syncthread = null;
            synchronized(mSyncThreadLock) {
                Iterator iterator = mSyncThreads.values().iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    SyncThread syncthread1 = (SyncThread)iterator.next();
                    if(syncthread1.mSyncContext.getSyncContextBinder() != isynccontext.asBinder())
                        continue;
                    syncthread = syncthread1;
                    break;
                } while(true);
            }
            if(syncthread != null)
                if(mAllowParallelSyncs)
                    onSyncCanceled(syncthread);
                else
                    onSyncCanceled();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void initialize(Account account, String s) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putBoolean("initialize", true);
            startSync(null, s, account, bundle);
        }

        public void startSync(ISyncContext isynccontext, String s, Account account, Bundle bundle) {
            SyncContext synccontext;
            Account account1;
            synccontext = new SyncContext(isynccontext);
            account1 = toSyncKey(account);
            Object obj = mSyncThreadLock;
            obj;
            JVM INSTR monitorenter ;
            boolean flag;
            if(mSyncThreads.containsKey(account1))
                break MISSING_BLOCK_LABEL_195;
            if(mAutoInitialize && bundle != null && bundle.getBoolean("initialize", false)) {
                if(ContentResolver.getIsSyncable(account, s) < 0)
                    ContentResolver.setIsSyncable(account, s, 1);
                synccontext.onFinished(new SyncResult());
                break MISSING_BLOCK_LABEL_209;
            }
            SyncThread syncthread = new SyncThread((new StringBuilder()).append("SyncAdapterThread-").append(mNumSyncStarts.incrementAndGet()).toString(), synccontext, s, account, bundle);
            mSyncThreads.put(account1, syncthread);
            syncthread.start();
            flag = false;
_L2:
            if(flag)
                synccontext.onFinished(SyncResult.ALREADY_IN_PROGRESS);
            break MISSING_BLOCK_LABEL_209;
            flag = true;
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        final AbstractThreadedSyncAdapter this$0;

        private ISyncAdapterImpl() {
            this$0 = AbstractThreadedSyncAdapter.this;
            super();
        }

    }


    public AbstractThreadedSyncAdapter(Context context, boolean flag) {
        this(context, flag, false);
    }

    public AbstractThreadedSyncAdapter(Context context, boolean flag, boolean flag1) {
        mSyncThreads = new HashMap();
        mSyncThreadLock = new Object();
        mContext = context;
        mISyncAdapterImpl = new ISyncAdapterImpl();
        mNumSyncStarts = new AtomicInteger(0);
        mAutoInitialize = flag;
        mAllowParallelSyncs = flag1;
    }

    private Account toSyncKey(Account account) {
        if(!mAllowParallelSyncs)
            account = null;
        return account;
    }

    public Context getContext() {
        return mContext;
    }

    public final IBinder getSyncAdapterBinder() {
        return mISyncAdapterImpl.asBinder();
    }

    public abstract void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentproviderclient, SyncResult syncresult);

    public void onSyncCanceled() {
        SyncThread syncthread;
        synchronized(mSyncThreadLock) {
            syncthread = (SyncThread)mSyncThreads.get(null);
        }
        if(syncthread != null)
            syncthread.interrupt();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onSyncCanceled(Thread thread) {
        thread.interrupt();
    }

    public static final int LOG_SYNC_DETAILS = 2743;
    private boolean mAllowParallelSyncs;
    private final boolean mAutoInitialize;
    private final Context mContext;
    private final ISyncAdapterImpl mISyncAdapterImpl;
    private final AtomicInteger mNumSyncStarts;
    private final Object mSyncThreadLock;
    private final HashMap mSyncThreads;







}
