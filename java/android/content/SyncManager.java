// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.*;
import android.app.*;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.RegisteredServicesCacheListener;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.*;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.*;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package android.content:
//            SyncStorageEngine, SyncAdaptersCache, SyncQueue, Intent, 
//            IntentFilter, Context, SyncOperation, SyncAdapterType, 
//            SyncStatusInfo, SyncResult, BroadcastReceiver, SyncActivityTooManyDeletes, 
//            ISyncAdapter, SyncStats, ServiceConnection, SyncInfo, 
//            ComponentName

public class SyncManager
    implements OnAccountsUpdateListener {
    class SyncHandler extends Handler {
        class SyncNotificationInfo {

            public String toString() {
                StringBuilder stringbuilder = new StringBuilder();
                toString(stringbuilder);
                return stringbuilder.toString();
            }

            public void toString(StringBuilder stringbuilder) {
                stringbuilder.append("isActive ").append(isActive).append(", startTime ").append(startTime);
            }

            public boolean isActive;
            public Long startTime;
            final SyncHandler this$1;

            SyncNotificationInfo() {
                this$1 = SyncHandler.this;
                super();
                isActive = false;
                startTime = null;
            }
        }


        private void cancelActiveSyncLocked(Account account, int i, String s) {
            Iterator iterator = (new ArrayList(mActiveSyncContexts)).iterator();
            do {
                if(!iterator.hasNext())
                    break;
                ActiveSyncContext activesynccontext = (ActiveSyncContext)iterator.next();
                if(activesynccontext != null && (account == null || account.equals(activesynccontext.mSyncOperation.account)) && (s == null || s.equals(activesynccontext.mSyncOperation.authority)) && (i == -1 || i == activesynccontext.mSyncOperation.userId))
                    runSyncFinishedOrCanceledLocked(null, activesynccontext);
            } while(true);
        }

        private void closeActiveSyncContext(ActiveSyncContext activesynccontext) {
            activesynccontext.close();
            mActiveSyncContexts.remove(activesynccontext);
            mSyncStorageEngine.removeActiveSync(activesynccontext.mSyncInfo, activesynccontext.mSyncOperation.userId);
        }

        private boolean dispatchSyncOperation(SyncOperation syncoperation) {
            if(Log.isLoggable("SyncManager", 2)) {
                Log.v("SyncManager", (new StringBuilder()).append("dispatchSyncOperation: we are going to sync ").append(syncoperation).toString());
                Log.v("SyncManager", (new StringBuilder()).append("num active syncs: ").append(mActiveSyncContexts.size()).toString());
                for(Iterator iterator = mActiveSyncContexts.iterator(); iterator.hasNext(); Log.v("SyncManager", ((ActiveSyncContext)iterator.next()).toString()));
            }
            SyncAdapterType syncadaptertype = SyncAdapterType.newKey(syncoperation.authority, syncoperation.account.type);
            android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo = mSyncAdapters.getServiceInfo(syncadaptertype);
            boolean flag;
            if(serviceinfo == null) {
                Log.d("SyncManager", (new StringBuilder()).append("can't find a sync adapter for ").append(syncadaptertype).append(", removing settings for it").toString());
                mSyncStorageEngine.removeAuthority(syncoperation.account, syncoperation.userId, syncoperation.authority);
                flag = false;
            } else {
                ActiveSyncContext activesynccontext = new ActiveSyncContext(syncoperation, insertStartSyncEvent(syncoperation), serviceinfo.uid);
                activesynccontext.mSyncInfo = mSyncStorageEngine.addActiveSync(activesynccontext);
                mActiveSyncContexts.add(activesynccontext);
                if(Log.isLoggable("SyncManager", 2))
                    Log.v("SyncManager", (new StringBuilder()).append("dispatchSyncOperation: starting ").append(activesynccontext).toString());
                if(!activesynccontext.bindToSyncAdapter(serviceinfo)) {
                    Log.e("SyncManager", (new StringBuilder()).append("Bind attempt failed to ").append(serviceinfo).toString());
                    closeActiveSyncContext(activesynccontext);
                    flag = false;
                } else {
                    flag = true;
                }
            }
            return flag;
        }

        private android.os.PowerManager.WakeLock getSyncWakeLock(Account account, String s) {
            Pair pair = Pair.create(account, s);
            android.os.PowerManager.WakeLock wakelock = (android.os.PowerManager.WakeLock)mWakeLocks.get(pair);
            if(wakelock == null) {
                String s1 = (new StringBuilder()).append("*sync*_").append(s).append("_").append(account).toString();
                wakelock = mPowerManager.newWakeLock(1, s1);
                wakelock.setReferenceCounted(false);
                mWakeLocks.put(pair, wakelock);
            }
            return wakelock;
        }

        private void installHandleTooManyDeletesNotification(Account account, String s, long l) {
            if(mNotificationMgr != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            ProviderInfo providerinfo = mContext.getPackageManager().resolveContentProvider(s, 0);
            if(providerinfo != null) {
                CharSequence charsequence = providerinfo.loadLabel(mContext.getPackageManager());
                Intent intent = new Intent(mContext, android/content/SyncActivityTooManyDeletes);
                intent.putExtra("account", account);
                intent.putExtra("authority", s);
                intent.putExtra("provider", charsequence.toString());
                intent.putExtra("numDeletes", l);
                if(!isActivityAvailable(intent)) {
                    Log.w("SyncManager", "No activity found to handle too many deletes.");
                } else {
                    PendingIntent pendingintent = PendingIntent.getActivity(mContext, 0, intent, 0x10000000);
                    CharSequence charsequence1 = mContext.getResources().getText(0x1040122);
                    Notification notification = new Notification(0x1080516, mContext.getString(0x1040120), System.currentTimeMillis());
                    Context context = mContext;
                    String s1 = mContext.getString(0x1040121);
                    String s2 = charsequence1.toString();
                    Object aobj[] = new Object[1];
                    aobj[0] = charsequence;
                    notification.setLatestEventInfo(context, s1, String.format(s2, aobj), pendingintent);
                    notification.flags = 2 | notification.flags;
                    mNotificationMgr.notify(account.hashCode() ^ s.hashCode(), notification);
                }
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private boolean isActivityAvailable(Intent intent) {
            boolean flag = false;
            List list = mContext.getPackageManager().queryIntentActivities(intent, 0);
            int i = list.size();
            int j = 0;
            do {
label0:
                {
                    if(j < i) {
                        if((1 & ((ComponentInfo) (((ResolveInfo)list.get(j)).activityInfo)).applicationInfo.flags) == 0)
                            break label0;
                        flag = true;
                    }
                    return flag;
                }
                j++;
            } while(true);
        }

        private void manageSyncAlarmLocked(long l, long l1) {
_L2:
            return;
            if(!mDataConnectionIsConnected || mStorageIsLow) goto _L2; else goto _L1
_L1:
            long l2;
            long l3;
            Iterator iterator;
            if(!mSyncHandler.mSyncNotificationInfo.isActive && mSyncHandler.mSyncNotificationInfo.startTime != null)
                l2 = mSyncHandler.mSyncNotificationInfo.startTime.longValue() + SyncManager.SYNC_NOTIFICATION_DELAY;
            else
                l2 = 0x7fffffffffffffffL;
            l3 = 0x7fffffffffffffffL;
            iterator = mActiveSyncContexts.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                long l6 = ((ActiveSyncContext)iterator.next()).mTimeoutStartTime + SyncManager.MAX_TIME_PER_SYNC;
                if(Log.isLoggable("SyncManager", 2))
                    Log.v("SyncManager", (new StringBuilder()).append("manageSyncAlarm: active sync, mTimeoutStartTime + MAX is ").append(l6).toString());
                if(l3 > l6)
                    l3 = l6;
            } while(true);
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("manageSyncAlarm: notificationTime is ").append(l2).toString());
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("manageSyncAlarm: earliestTimeoutTime is ").append(l3).toString());
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("manageSyncAlarm: nextPeriodicEventElapsedTime is ").append(l).toString());
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("manageSyncAlarm: nextPendingEventElapsedTime is ").append(l1).toString());
            long l4 = Math.min(Math.min(Math.min(l2, l3), l), l1);
            long l5 = SystemClock.elapsedRealtime();
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if(l4 < 30000L + l5) {
                if(Log.isLoggable("SyncManager", 2))
                    Log.v("SyncManager", (new StringBuilder()).append("manageSyncAlarm: the alarmTime is too small, ").append(l4).append(", setting to ").append(30000L + l5).toString());
                l4 = l5 + 30000L;
            } else
            if(l4 > 0x6ddd00L + l5) {
                if(Log.isLoggable("SyncManager", 2))
                    Log.v("SyncManager", (new StringBuilder()).append("manageSyncAlarm: the alarmTime is too large, ").append(l4).append(", setting to ").append(30000L + l5).toString());
                l4 = l5 + 0x6ddd00L;
            }
            flag = false;
            flag1 = false;
            if(mAlarmScheduleTime != null)
                flag2 = true;
            else
                flag2 = false;
            if(l4 != 0x7fffffffffffffffL)
                flag3 = true;
            else
                flag3 = false;
            if(flag3) {
                if(!flag2 || l4 < mAlarmScheduleTime.longValue())
                    flag = true;
            } else {
                flag1 = flag2;
            }
            ensureAlarmService();
            if(flag) {
                if(Log.isLoggable("SyncManager", 2))
                    Log.v("SyncManager", (new StringBuilder()).append("requesting that the alarm manager wake us up at elapsed time ").append(l4).append(", now is ").append(l5).append(", ").append((l4 - l5) / 1000L).append(" secs from now").toString());
                mAlarmScheduleTime = Long.valueOf(l4);
                mAlarmService.set(2, l4, mSyncAlarmIntent);
            } else
            if(flag1) {
                mAlarmScheduleTime = null;
                mAlarmService.cancel(mSyncAlarmIntent);
            }
            continue; /* Loop/switch isn't completed */
            if(true) goto _L2; else goto _L3
_L3:
        }

        private void manageSyncNotificationLocked() {
            if(!mActiveSyncContexts.isEmpty()) goto _L2; else goto _L1
_L1:
            boolean flag;
            boolean flag2;
            mSyncNotificationInfo.startTime = null;
            flag = mSyncNotificationInfo.isActive;
            flag2 = false;
_L4:
            if(flag && !flag2) {
                mNeedSyncActiveNotification = false;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = false;
            }
            if(flag2) {
                mNeedSyncActiveNotification = true;
                sendSyncStateIntent();
                mSyncNotificationInfo.isActive = true;
            }
            return;
_L2:
            long l = SystemClock.elapsedRealtime();
            if(mSyncNotificationInfo.startTime == null)
                mSyncNotificationInfo.startTime = Long.valueOf(l);
            if(mSyncNotificationInfo.isActive) {
                flag = false;
                flag2 = false;
                continue; /* Loop/switch isn't completed */
            }
            flag = false;
            boolean flag1;
            if(l > mSyncNotificationInfo.startTime.longValue() + SyncManager.SYNC_NOTIFICATION_DELAY)
                flag1 = true;
            else
                flag1 = false;
            if(flag1) {
                flag2 = true;
                continue; /* Loop/switch isn't completed */
            }
            flag2 = false;
            Iterator iterator = mActiveSyncContexts.iterator();
            do
                if(!iterator.hasNext())
                    continue; /* Loop/switch isn't completed */
            while(!((ActiveSyncContext)iterator.next()).mSyncOperation.extras.getBoolean("force", false));
            flag2 = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        private long maybeStartNextSyncLocked() {
            boolean flag;
            flag = Log.isLoggable("SyncManager", 2);
            if(flag)
                Log.v("SyncManager", "maybeStartNextSync");
            if(mDataConnectionIsConnected) goto _L2; else goto _L1
_L1:
            long l1;
            if(flag)
                Log.v("SyncManager", "maybeStartNextSync: no data connection, skipping");
            l1 = 0x7fffffffffffffffL;
_L4:
            return l1;
_L2:
            AccountAndUser aaccountanduser[];
            if(mStorageIsLow) {
                if(flag)
                    Log.v("SyncManager", "maybeStartNextSync: memory low, skipping");
                l1 = 0x7fffffffffffffffL;
                continue; /* Loop/switch isn't completed */
            }
            aaccountanduser = mAccounts;
            if(aaccountanduser != SyncManager.INITIAL_ACCOUNTS_ARRAY)
                break; /* Loop/switch isn't completed */
            if(flag)
                Log.v("SyncManager", "maybeStartNextSync: accounts not known, skipping");
            l1 = 0x7fffffffffffffffL;
            if(true) goto _L4; else goto _L3
_L3:
            boolean flag1;
            long l;
            ArrayList arraylist;
            flag1 = getConnectivityManager().getBackgroundDataSetting();
            l = SystemClock.elapsedRealtime();
            l1 = 0x7fffffffffffffffL;
            arraylist = new ArrayList();
            SyncQueue syncqueue = mSyncQueue;
            syncqueue;
            JVM INSTR monitorenter ;
            if(flag)
                Log.v("SyncManager", (new StringBuilder()).append("build the operation array, syncQueue size is ").append(mSyncQueue.mOperationsMap.size()).toString());
_L7:
            int i;
            int j;
            boolean flag4;
            Exception exception;
            Iterator iterator;
            SyncOperation syncoperation2;
            int j2;
            android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo;
            NetworkInfo networkinfo;
            for(iterator = mSyncQueue.mOperationsMap.values().iterator(); iterator.hasNext(); mSyncStorageEngine.deleteFromPending(syncoperation2.pendingOperation)) {
                syncoperation2 = (SyncOperation)iterator.next();
                if(containsAccountAndUser(aaccountanduser, syncoperation2.account, syncoperation2.userId))
                    break MISSING_BLOCK_LABEL_299;
                iterator.remove();
            }

            if(flag)
                Log.v("SyncManager", (new StringBuilder()).append("sort the candidate operations, size ").append(arraylist.size()).toString());
            Collections.sort(arraylist);
            if(flag)
                Log.v("SyncManager", "dispatch all ready sync operations");
            i = 0;
            j = arraylist.size();
              goto _L5
            exception;
            throw exception;
label0:
            {
                j2 = mSyncStorageEngine.getIsSyncable(syncoperation2.account, syncoperation2.userId, syncoperation2.authority);
                if(j2 == 0) {
                    iterator.remove();
                    mSyncStorageEngine.deleteFromPending(syncoperation2.pendingOperation);
                } else {
                    if(syncoperation2.effectiveRunTime <= l)
                        break label0;
                    if(l1 > syncoperation2.effectiveRunTime)
                        l1 = syncoperation2.effectiveRunTime;
                }
            }
            if(true) goto _L7; else goto _L6
_L6:
            serviceinfo = mSyncAdapters.getServiceInfo(SyncAdapterType.newKey(syncoperation2.authority, syncoperation2.account.type));
            if(serviceinfo == null)
                break MISSING_BLOCK_LABEL_1462;
            networkinfo = getConnectivityManager().getActiveNetworkInfoForUid(serviceinfo.uid);
            if(networkinfo == null || !networkinfo.isConnected()) goto _L9; else goto _L8
_L8:
            flag4 = true;
_L26:
            if(!syncoperation2.extras.getBoolean("ignore_settings", false) && j2 > 0 && (!mSyncStorageEngine.getMasterSyncAutomatically(syncoperation2.userId) || !flag1 || !flag4 || !mSyncStorageEngine.getSyncAutomatically(syncoperation2.account, syncoperation2.userId, syncoperation2.authority))) {
                iterator.remove();
                mSyncStorageEngine.deleteFromPending(syncoperation2.pendingOperation);
            } else {
                arraylist.add(syncoperation2);
            }
              goto _L7
_L5:
            if(i >= j) goto _L4; else goto _L10
_L10:
            SyncOperation syncoperation;
            boolean flag2;
            int k;
            int i1;
            ActiveSyncContext activesynccontext;
            ActiveSyncContext activesynccontext1;
            ActiveSyncContext activesynccontext2;
            ActiveSyncContext activesynccontext3;
            Iterator iterator1;
            syncoperation = (SyncOperation)arraylist.get(i);
            flag2 = syncoperation.isInitialization();
            k = 0;
            i1 = 0;
            activesynccontext = null;
            activesynccontext1 = null;
            activesynccontext2 = null;
            activesynccontext3 = null;
            iterator1 = mActiveSyncContexts.iterator();
_L16:
            ActiveSyncContext activesynccontext4;
            SyncOperation syncoperation1;
            if(!iterator1.hasNext())
                break; /* Loop/switch isn't completed */
            activesynccontext4 = (ActiveSyncContext)iterator1.next();
            syncoperation1 = activesynccontext4.mSyncOperation;
            if(!syncoperation1.isInitialization()) goto _L12; else goto _L11
_L11:
            k++;
_L14:
            if(!syncoperation1.account.type.equals(syncoperation.account.type) || !syncoperation1.authority.equals(syncoperation.authority) || syncoperation1.userId != syncoperation.userId || syncoperation1.allowParallelSyncs && !syncoperation1.account.name.equals(syncoperation.account.name))
                break; /* Loop/switch isn't completed */
            activesynccontext = activesynccontext4;
            continue; /* Loop/switch isn't completed */
_L12:
            i1++;
            if(!syncoperation1.isExpedited() && (activesynccontext3 == null || activesynccontext3.mStartTime > activesynccontext4.mStartTime))
                activesynccontext3 = activesynccontext4;
            if(true) goto _L14; else goto _L13
_L13:
            if(flag2 == syncoperation1.isInitialization() && activesynccontext4.mStartTime + SyncManager.MAX_TIME_PER_SYNC < l)
                activesynccontext1 = activesynccontext4;
            if(true) goto _L16; else goto _L15
_L15:
            boolean flag3;
            if(flag) {
                Log.v("SyncManager", (new StringBuilder()).append("candidate ").append(i + 1).append(" of ").append(j).append(": ").append(syncoperation).toString());
                Log.v("SyncManager", (new StringBuilder()).append("  numActiveInit=").append(k).append(", numActiveRegular=").append(i1).toString());
                Log.v("SyncManager", (new StringBuilder()).append("  longRunning: ").append(activesynccontext1).toString());
                Log.v("SyncManager", (new StringBuilder()).append("  conflict: ").append(activesynccontext).toString());
                Log.v("SyncManager", (new StringBuilder()).append("  oldestNonExpeditedRegular: ").append(activesynccontext3).toString());
            }
            if(flag2) {
                int i2 = SyncManager.MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
                int k1;
                if(k < i2)
                    flag3 = true;
                else
                    flag3 = false;
            } else {
                int j1 = SyncManager.MAX_SIMULTANEOUS_REGULAR_SYNCS;
                if(i1 < j1)
                    flag3 = true;
                else
                    flag3 = false;
            }
            if(activesynccontext == null) goto _L18; else goto _L17
_L17:
            if(!flag2 || activesynccontext.mSyncOperation.isInitialization()) goto _L20; else goto _L19
_L19:
            k1 = SyncManager.MAX_SIMULTANEOUS_INITIALIZATION_SYNCS;
            if(k >= k1) goto _L20; else goto _L21
_L21:
            activesynccontext2 = activesynccontext;
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("canceling and rescheduling sync since an initialization takes higher priority, ").append(activesynccontext).toString());
_L24:
            if(activesynccontext2 != null) {
                runSyncFinishedOrCanceledLocked(null, activesynccontext2);
                scheduleSyncOperation(activesynccontext2.mSyncOperation);
            }
            synchronized(mSyncQueue) {
                mSyncQueue.remove(syncoperation);
            }
            dispatchSyncOperation(syncoperation);
_L23:
            i++;
              goto _L5
_L20:
            if(!syncoperation.expedited || activesynccontext.mSyncOperation.expedited || flag2 != activesynccontext.mSyncOperation.isInitialization()) goto _L23; else goto _L22
_L22:
            activesynccontext2 = activesynccontext;
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("canceling and rescheduling sync since an expedited takes higher priority, ").append(activesynccontext).toString());
              goto _L24
_L18:
            if(!flag3) {
                if(!syncoperation.isExpedited() || activesynccontext3 == null || flag2)
                    continue; /* Loop/switch isn't completed */
                activesynccontext2 = activesynccontext3;
                if(Log.isLoggable("SyncManager", 2))
                    Log.v("SyncManager", (new StringBuilder()).append("canceling and rescheduling sync since an expedited is ready to run, ").append(activesynccontext3).toString());
            }
              goto _L24
            if(activesynccontext1 == null || flag2 != activesynccontext1.mSyncOperation.isInitialization()) goto _L23; else goto _L25
_L25:
            activesynccontext2 = activesynccontext1;
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("canceling and rescheduling sync since it ran roo long, ").append(activesynccontext1).toString());
              goto _L24
            exception1;
            syncqueue1;
            JVM INSTR monitorexit ;
            throw exception1;
_L9:
            flag4 = false;
              goto _L26
            flag4 = false;
              goto _L26
        }

        private void runBoundToSyncAdapter(ActiveSyncContext activesynccontext, ISyncAdapter isyncadapter) {
            SyncOperation syncoperation;
            activesynccontext.mSyncAdapter = isyncadapter;
            syncoperation = activesynccontext.mSyncOperation;
            activesynccontext.mIsLinkedToDeath = true;
            isyncadapter.asBinder().linkToDeath(activesynccontext, 0);
            isyncadapter.startSync(activesynccontext, syncoperation.authority, syncoperation.account, syncoperation.extras);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            Log.d("SyncManager", "maybeStartNextSync: caught a RemoteException, rescheduling", remoteexception);
            closeActiveSyncContext(activesynccontext);
            increaseBackoffSetting(syncoperation);
            scheduleSyncOperation(new SyncOperation(syncoperation));
              goto _L1
            RuntimeException runtimeexception;
            runtimeexception;
            closeActiveSyncContext(activesynccontext);
            Log.e("SyncManager", (new StringBuilder()).append("Caught RuntimeException while starting the sync ").append(syncoperation).toString(), runtimeexception);
              goto _L1
        }

        private void runSyncFinishedOrCanceledLocked(SyncResult syncresult, ActiveSyncContext activesynccontext) {
            boolean flag = Log.isLoggable("SyncManager", 2);
            if(activesynccontext.mIsLinkedToDeath) {
                activesynccontext.mSyncAdapter.asBinder().unlinkToDeath(activesynccontext, 0);
                activesynccontext.mIsLinkedToDeath = false;
            }
            closeActiveSyncContext(activesynccontext);
            SyncOperation syncoperation = activesynccontext.mSyncOperation;
            long l = SystemClock.elapsedRealtime() - activesynccontext.mStartTime;
            String s;
            if(syncresult != null) {
                if(flag)
                    Log.v("SyncManager", (new StringBuilder()).append("runSyncFinishedOrCanceled [finished]: ").append(syncoperation).append(", result ").append(syncresult).toString());
                if(!syncresult.hasError()) {
                    s = "success";
                    clearBackoffSetting(syncoperation);
                } else {
                    Log.d("SyncManager", (new StringBuilder()).append("failed sync operation ").append(syncoperation).append(", ").append(syncresult).toString());
                    if(!syncresult.syncAlreadyInProgress)
                        increaseBackoffSetting(syncoperation);
                    maybeRescheduleSync(syncresult, syncoperation);
                    s = Integer.toString(syncResultToErrorNumber(syncresult));
                }
                setDelayUntilTime(syncoperation, syncresult.delayUntil);
            } else {
                if(flag)
                    Log.v("SyncManager", (new StringBuilder()).append("runSyncFinishedOrCanceled [canceled]: ").append(syncoperation).toString());
                if(activesynccontext.mSyncAdapter != null)
                    try {
                        activesynccontext.mSyncAdapter.cancelSync(activesynccontext);
                    }
                    catch(RemoteException remoteexception) { }
                s = "canceled";
            }
            stopSyncEvent(activesynccontext.mHistoryRowId, syncoperation, s, 0, 0, l);
            if(syncresult != null && syncresult.tooManyDeletions)
                installHandleTooManyDeletesNotification(syncoperation.account, syncoperation.authority, syncresult.stats.numDeletes);
            else
                mNotificationMgr.cancel(syncoperation.account.hashCode() ^ syncoperation.authority.hashCode());
            if(syncresult != null && syncresult.fullSyncRequested)
                scheduleSyncOperation(new SyncOperation(syncoperation.account, syncoperation.userId, syncoperation.syncSource, syncoperation.authority, new Bundle(), 0L, syncoperation.backoff.longValue(), syncoperation.delayUntil, syncoperation.allowParallelSyncs));
        }

        private long scheduleReadyPeriodicSyncs() {
            boolean flag;
            long l;
            flag = getConnectivityManager().getBackgroundDataSetting();
            l = 0x7fffffffffffffffL;
            if(flag) goto _L2; else goto _L1
_L1:
            long l5 = l;
_L7:
            return l5;
_L2:
            long l1;
            SyncStorageEngine.AuthorityInfo authorityinfo;
            SyncStatusInfo syncstatusinfo;
            int i;
            Bundle bundle;
            long l7;
            Pair pair;
            android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo;
            AccountAndUser aaccountanduser[] = mAccounts;
            l1 = System.currentTimeMillis();
            long l2;
            Iterator iterator;
            int j;
            Long long1;
            long l6;
            if(0L < l1 - (long)mSyncRandomOffsetMillis)
                l2 = l1 - (long)mSyncRandomOffsetMillis;
            else
                l2 = 0L;
            iterator = mSyncStorageEngine.getAuthorities().iterator();
            do {
                if(!iterator.hasNext())
                    break MISSING_BLOCK_LABEL_557;
                authorityinfo = (SyncStorageEngine.AuthorityInfo)iterator.next();
            } while(!containsAccountAndUser(aaccountanduser, authorityinfo.account, authorityinfo.userId) || !mSyncStorageEngine.getMasterSyncAutomatically(authorityinfo.userId) || !mSyncStorageEngine.getSyncAutomatically(authorityinfo.account, authorityinfo.userId, authorityinfo.authority) || mSyncStorageEngine.getIsSyncable(authorityinfo.account, authorityinfo.userId, authorityinfo.authority) == 0);
            syncstatusinfo = mSyncStorageEngine.getOrCreateSyncStatus(authorityinfo);
            i = 0;
            j = authorityinfo.periodicSyncs.size();
_L4:
            if(i >= j)
                break MISSING_BLOCK_LABEL_83;
            bundle = (Bundle)((Pair)authorityinfo.periodicSyncs.get(i)).first;
            long1 = Long.valueOf(1000L * ((Long)((Pair)authorityinfo.periodicSyncs.get(i)).second).longValue());
            l6 = syncstatusinfo.getPeriodicSyncTime(i);
            l7 = long1.longValue() - l2 % long1.longValue();
            if(l7 != long1.longValue() && l6 <= l1 && l1 - l6 < long1.longValue())
                break MISSING_BLOCK_LABEL_531;
            pair = mSyncStorageEngine.getBackoff(authorityinfo.account, authorityinfo.userId, authorityinfo.authority);
            serviceinfo = mSyncAdapters.getServiceInfo(SyncAdapterType.newKey(authorityinfo.authority, authorityinfo.account.type));
            if(serviceinfo != null)
                break; /* Loop/switch isn't completed */
_L5:
            i++;
            if(true) goto _L4; else goto _L3
_L3:
            SyncManager syncmanager = SyncManager.this;
            Account account = authorityinfo.account;
            int k = authorityinfo.userId;
            String s = authorityinfo.authority;
            long l8;
            long l9;
            if(pair != null)
                l8 = ((Long)pair.first).longValue();
            else
                l8 = 0L;
            syncmanager.scheduleSyncOperation(new SyncOperation(account, k, 4, s, bundle, 0L, l8, mSyncStorageEngine.getDelayUntilTime(authorityinfo.account, authorityinfo.userId, authorityinfo.authority), ((SyncAdapterType)serviceinfo.type).allowParallelSyncs()));
            syncstatusinfo.setPeriodicSyncTime(i, l1);
            l9 = l1 + l7;
            if(l9 < l)
                l = l9;
              goto _L5
            if(l == 0x7fffffffffffffffL) {
                l5 = 0x7fffffffffffffffL;
            } else {
                long l3 = SystemClock.elapsedRealtime();
                long l4;
                if(l < l1)
                    l4 = 0L;
                else
                    l4 = l - l1;
                l5 = l4 + l3;
            }
            if(true) goto _L7; else goto _L6
_L6:
        }

        private void sendSyncStateIntent() {
            Intent intent = new Intent("android.intent.action.SYNC_STATE_CHANGED");
            intent.addFlags(0x8000000);
            intent.putExtra("active", mNeedSyncActiveNotification);
            intent.putExtra("failing", false);
            mContext.sendBroadcast(intent);
        }

        private int syncResultToErrorNumber(SyncResult syncresult) {
            int i;
            if(syncresult.syncAlreadyInProgress)
                i = 1;
            else
            if(syncresult.stats.numAuthExceptions > 0L)
                i = 2;
            else
            if(syncresult.stats.numIoExceptions > 0L)
                i = 3;
            else
            if(syncresult.stats.numParseExceptions > 0L)
                i = 4;
            else
            if(syncresult.stats.numConflictDetectedExceptions > 0L)
                i = 5;
            else
            if(syncresult.tooManyDeletions)
                i = 6;
            else
            if(syncresult.tooManyRetries)
                i = 7;
            else
            if(syncresult.databaseError)
                i = 8;
            else
                throw new IllegalStateException((new StringBuilder()).append("we are not in an error state, ").append(syncresult).toString());
            return i;
        }

        private void waitUntilReadyToRun() {
            CountDownLatch countdownlatch = mReadyToRunLatch;
            if(countdownlatch == null) goto _L2; else goto _L1
_L1:
            countdownlatch.await();
            mReadyToRunLatch = null;
_L2:
            return;
            InterruptedException interruptedexception;
            interruptedexception;
            Thread.currentThread().interrupt();
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void handleMessage(Message message) {
            long l;
            long l1;
            l = 0x7fffffffffffffffL;
            l1 = 0x7fffffffffffffffL;
            int i;
            waitUntilReadyToRun();
            mDataConnectionIsConnected = readDataConnectionState();
            mSyncManagerWakeLock.acquire();
            l = scheduleReadyPeriodicSyncs();
            i = message.what;
            i;
            JVM INSTR tableswitch 1 6: default 88
        //                       1 215
        //                       2 555
        //                       3 616
        //                       4 346
        //                       5 426
        //                       6 117;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            manageSyncNotificationLocked();
            manageSyncAlarmLocked(l, l1);
            mSyncTimeTracker.update();
            mSyncManagerWakeLock.release();
            return;
_L7:
            Pair pair = (Pair)message.obj;
            if(Log.isLoggable("SyncManager", 2))
                Log.d("SyncManager", (new StringBuilder()).append("handleSyncHandlerMessage: MESSAGE_SERVICE_CANCEL: ").append(pair.first).append(", ").append((String)pair.second).toString());
            cancelActiveSyncLocked((Account)pair.first, message.arg1, (String)pair.second);
            l1 = maybeStartNextSyncLocked();
            continue; /* Loop/switch isn't completed */
_L2:
            SyncHandlerMessagePayload synchandlermessagepayload;
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", "handleSyncHandlerMessage: MESSAGE_SYNC_FINISHED");
            synchandlermessagepayload = (SyncHandlerMessagePayload)message.obj;
            if(!isSyncStillActive(synchandlermessagepayload.activeSyncContext)) {
                Log.d("SyncManager", (new StringBuilder()).append("handleSyncHandlerMessage: dropping since the sync is no longer active: ").append(synchandlermessagepayload.activeSyncContext).toString());
                continue; /* Loop/switch isn't completed */
            }
              goto _L8
            Exception exception;
            exception;
            manageSyncNotificationLocked();
            manageSyncAlarmLocked(l, l1);
            mSyncTimeTracker.update();
            mSyncManagerWakeLock.release();
            throw exception;
_L8:
            runSyncFinishedOrCanceledLocked(synchandlermessagepayload.syncResult, synchandlermessagepayload.activeSyncContext);
            l1 = maybeStartNextSyncLocked();
            continue; /* Loop/switch isn't completed */
_L5:
            ServiceConnectionData serviceconnectiondata = (ServiceConnectionData)message.obj;
            if(Log.isLoggable("SyncManager", 2))
                Log.d("SyncManager", (new StringBuilder()).append("handleSyncHandlerMessage: MESSAGE_SERVICE_CONNECTED: ").append(serviceconnectiondata.activeSyncContext).toString());
            if(isSyncStillActive(serviceconnectiondata.activeSyncContext))
                runBoundToSyncAdapter(serviceconnectiondata.activeSyncContext, serviceconnectiondata.syncAdapter);
            continue; /* Loop/switch isn't completed */
_L6:
            ActiveSyncContext activesynccontext;
            ISyncAdapter isyncadapter;
            activesynccontext = ((ServiceConnectionData)message.obj).activeSyncContext;
            if(Log.isLoggable("SyncManager", 2))
                Log.d("SyncManager", (new StringBuilder()).append("handleSyncHandlerMessage: MESSAGE_SERVICE_DISCONNECTED: ").append(activesynccontext).toString());
            if(!isSyncStillActive(activesynccontext))
                continue; /* Loop/switch isn't completed */
            isyncadapter = activesynccontext.mSyncAdapter;
            if(isyncadapter == null) goto _L10; else goto _L9
_L9:
            long l2;
            Exception exception1;
            long l3;
            SyncResult syncresult;
            SyncStats syncstats;
            try {
                activesynccontext.mSyncAdapter.cancelSync(activesynccontext);
            }
            catch(RemoteException remoteexception) { }
_L10:
            syncresult = new SyncResult();
            syncstats = syncresult.stats;
            syncstats.numIoExceptions = 1L + syncstats.numIoExceptions;
            runSyncFinishedOrCanceledLocked(syncresult, activesynccontext);
            l1 = maybeStartNextSyncLocked();
            continue; /* Loop/switch isn't completed */
_L3:
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", "handleSyncHandlerMessage: MESSAGE_SYNC_ALARM");
            mAlarmScheduleTime = null;
            l3 = maybeStartNextSyncLocked();
            l1 = l3;
            mHandleAlarmWakeLock.release();
            continue; /* Loop/switch isn't completed */
            exception1;
            mHandleAlarmWakeLock.release();
            throw exception1;
_L4:
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", "handleSyncHandlerMessage: MESSAGE_CHECK_ALARMS");
            l2 = maybeStartNextSyncLocked();
            l1 = l2;
            if(true) goto _L1; else goto _L11
_L11:
        }

        public long insertStartSyncEvent(SyncOperation syncoperation) {
            int i = syncoperation.syncSource;
            long l = System.currentTimeMillis();
            Object aobj[] = new Object[4];
            aobj[0] = syncoperation.authority;
            aobj[1] = Integer.valueOf(0);
            aobj[2] = Integer.valueOf(i);
            aobj[3] = Integer.valueOf(syncoperation.account.name.hashCode());
            EventLog.writeEvent(2720, aobj);
            return mSyncStorageEngine.insertStartSyncEvent(syncoperation.account, syncoperation.userId, syncoperation.authority, l, i, syncoperation.isInitialization());
        }

        public void onBootCompleted() {
            mBootCompleted = true;
            List list = getAllUsers();
            if(list != null) {
                UserInfo userinfo;
                for(Iterator iterator = list.iterator(); iterator.hasNext(); mSyncStorageEngine.doDatabaseCleanup(AccountManagerService.getSingleton().getAccounts(userinfo.id), userinfo.id))
                    userinfo = (UserInfo)iterator.next();

            }
            if(mReadyToRunLatch != null)
                mReadyToRunLatch.countDown();
        }

        public void stopSyncEvent(long l, SyncOperation syncoperation, String s, int i, int j, long l1) {
            Object aobj[] = new Object[4];
            aobj[0] = syncoperation.authority;
            aobj[1] = Integer.valueOf(1);
            aobj[2] = Integer.valueOf(syncoperation.syncSource);
            aobj[3] = Integer.valueOf(syncoperation.account.name.hashCode());
            EventLog.writeEvent(2720, aobj);
            mSyncStorageEngine.stopSyncEvent(l, l1, s, j, i);
        }

        private static final int MESSAGE_CANCEL = 6;
        private static final int MESSAGE_CHECK_ALARMS = 3;
        private static final int MESSAGE_SERVICE_CONNECTED = 4;
        private static final int MESSAGE_SERVICE_DISCONNECTED = 5;
        private static final int MESSAGE_SYNC_ALARM = 2;
        private static final int MESSAGE_SYNC_FINISHED = 1;
        private Long mAlarmScheduleTime;
        private volatile CountDownLatch mReadyToRunLatch;
        public final SyncNotificationInfo mSyncNotificationInfo = new SyncNotificationInfo();
        public final SyncTimeTracker mSyncTimeTracker;
        private final HashMap mWakeLocks = Maps.newHashMap();
        final SyncManager this$0;



        public SyncHandler(Looper looper) {
            this$0 = SyncManager.this;
            super(looper);
            mAlarmScheduleTime = null;
            mSyncTimeTracker = new SyncTimeTracker();
            mReadyToRunLatch = new CountDownLatch(1);
        }
    }

    class ServiceConnectionData {

        public final ActiveSyncContext activeSyncContext;
        public final ISyncAdapter syncAdapter;
        final SyncManager this$0;

        ServiceConnectionData(ActiveSyncContext activesynccontext, ISyncAdapter isyncadapter) {
            this$0 = SyncManager.this;
            super();
            activeSyncContext = activesynccontext;
            syncAdapter = isyncadapter;
        }
    }

    private class SyncTimeTracker {

        /**
         * @deprecated Method timeSpentSyncing is deprecated
         */

        public long timeSpentSyncing() {
            this;
            JVM INSTR monitorenter ;
            if(mLastWasSyncing) goto _L2; else goto _L1
_L1:
            long l3 = mTimeSpentSyncing;
_L4:
            this;
            JVM INSTR monitorexit ;
            return l3;
_L2:
            long l;
            long l1;
            long l2;
            l = SystemClock.elapsedRealtime();
            l1 = mTimeSpentSyncing;
            l2 = mWhenSyncStarted;
            l3 = l1 + (l - l2);
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method update is deprecated
         */

        public void update() {
            this;
            JVM INSTR monitorenter ;
            if(mActiveSyncContexts.isEmpty()) goto _L2; else goto _L1
_L1:
            boolean flag = true;
_L5:
            boolean flag1 = mLastWasSyncing;
            if(flag != flag1) goto _L4; else goto _L3
_L3:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            flag = false;
              goto _L5
_L4:
            long l;
            l = SystemClock.elapsedRealtime();
            if(!flag)
                break MISSING_BLOCK_LABEL_63;
            mWhenSyncStarted = l;
_L6:
            mLastWasSyncing = flag;
              goto _L3
            Exception exception;
            exception;
            throw exception;
            mTimeSpentSyncing = mTimeSpentSyncing + (l - mWhenSyncStarted);
              goto _L6
        }

        boolean mLastWasSyncing;
        private long mTimeSpentSyncing;
        long mWhenSyncStarted;
        final SyncManager this$0;

        private SyncTimeTracker() {
            this$0 = SyncManager.this;
            super();
            mLastWasSyncing = false;
            mWhenSyncStarted = 0L;
        }

    }

    private static class AccountSyncStats {

        long elapsedTime;
        String name;
        int times;

        private AccountSyncStats(String s) {
            name = s;
        }

    }

    private static class AuthoritySyncStats {

        Map accountMap;
        long elapsedTime;
        String name;
        int times;

        private AuthoritySyncStats(String s) {
            accountMap = Maps.newHashMap();
            name = s;
        }

    }

    class ActiveSyncContext extends ISyncContext.Stub
        implements ServiceConnection, android.os.IBinder.DeathRecipient {

        boolean bindToSyncAdapter(android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo) {
            if(Log.isLoggable("SyncManager", 2))
                Log.d("SyncManager", (new StringBuilder()).append("bindToSyncAdapter: ").append(serviceinfo.componentName).append(", connection ").append(this).toString());
            Intent intent = new Intent();
            intent.setAction("android.content.SyncAdapter");
            intent.setComponent(serviceinfo.componentName);
            intent.putExtra("android.intent.extra.client_label", 0x1040476);
            intent.putExtra("android.intent.extra.client_intent", PendingIntent.getActivity(mContext, 0, new Intent("android.settings.SYNC_SETTINGS"), 0));
            mBound = true;
            boolean flag = mContext.bindService(intent, this, 21, mSyncOperation.userId);
            if(!flag)
                mBound = false;
            return flag;
        }

        public void binderDied() {
            sendSyncFinishedOrCanceledMessage(this, null);
        }

        protected void close() {
            if(Log.isLoggable("SyncManager", 2))
                Log.d("SyncManager", (new StringBuilder()).append("unBindFromSyncAdapter: connection ").append(this).toString());
            if(mBound) {
                mBound = false;
                mContext.unbindService(this);
            }
            mSyncWakeLock.release();
            mSyncWakeLock.setWorkSource(null);
        }

        public void onFinished(SyncResult syncresult) {
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("onFinished: ").append(this).toString());
            sendSyncFinishedOrCanceledMessage(this, syncresult);
        }

        public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
            Message message = mSyncHandler.obtainMessage();
            message.what = 4;
            message.obj = new ServiceConnectionData(this, ISyncAdapter.Stub.asInterface(ibinder));
            mSyncHandler.sendMessage(message);
        }

        public void onServiceDisconnected(ComponentName componentname) {
            Message message = mSyncHandler.obtainMessage();
            message.what = 5;
            message.obj = new ServiceConnectionData(this, null);
            mSyncHandler.sendMessage(message);
        }

        public void sendHeartbeat() {
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder();
            toString(stringbuilder);
            return stringbuilder.toString();
        }

        public void toString(StringBuilder stringbuilder) {
            stringbuilder.append("startTime ").append(mStartTime).append(", mTimeoutStartTime ").append(mTimeoutStartTime).append(", mHistoryRowId ").append(mHistoryRowId).append(", syncOperation ").append(mSyncOperation);
        }

        boolean mBound;
        final long mHistoryRowId;
        boolean mIsLinkedToDeath;
        final long mStartTime = SystemClock.elapsedRealtime();
        ISyncAdapter mSyncAdapter;
        final int mSyncAdapterUid;
        SyncInfo mSyncInfo;
        final SyncOperation mSyncOperation;
        final android.os.PowerManager.WakeLock mSyncWakeLock;
        long mTimeoutStartTime;
        final SyncManager this$0;

        public ActiveSyncContext(SyncOperation syncoperation, long l, int i) {
            this$0 = SyncManager.this;
            super();
            mIsLinkedToDeath = false;
            mSyncAdapterUid = i;
            mSyncOperation = syncoperation;
            mHistoryRowId = l;
            mSyncAdapter = null;
            mTimeoutStartTime = mStartTime;
            mSyncWakeLock = mSyncHandler.getSyncWakeLock(mSyncOperation.account, mSyncOperation.authority);
            mSyncWakeLock.setWorkSource(new WorkSource(i));
            mSyncWakeLock.acquire();
        }
    }

    class SyncAlarmIntentReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            mHandleAlarmWakeLock.acquire();
            sendSyncAlarmMessage();
        }

        final SyncManager this$0;

        SyncAlarmIntentReceiver() {
            this$0 = SyncManager.this;
            super();
        }
    }

    class SyncHandlerMessagePayload {

        public final ActiveSyncContext activeSyncContext;
        public final SyncResult syncResult;
        final SyncManager this$0;

        SyncHandlerMessagePayload(ActiveSyncContext activesynccontext, SyncResult syncresult) {
            this$0 = SyncManager.this;
            super();
            activeSyncContext = activesynccontext;
            syncResult = syncresult;
        }
    }


    public SyncManager(Context context, boolean flag) {
        mAccounts = INITIAL_ACCOUNTS_ARRAY;
        mDataConnectionIsConnected = false;
        mStorageIsLow = false;
        mAlarmService = null;
        mNeedSyncActiveNotification = false;
        mStorageIntentReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                String s = intent.getAction();
                if(!"android.intent.action.DEVICE_STORAGE_LOW".equals(s)) goto _L2; else goto _L1
_L1:
                if(Log.isLoggable("SyncManager", 2))
                    Log.v("SyncManager", "Internal storage is low.");
                mStorageIsLow = true;
                cancelActiveSync(null, -1, null);
_L4:
                return;
_L2:
                if("android.intent.action.DEVICE_STORAGE_OK".equals(s)) {
                    if(Log.isLoggable("SyncManager", 2))
                        Log.v("SyncManager", "Internal storage is ok.");
                    mStorageIsLow = false;
                    sendCheckAlarmsMessage();
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        };
        mBootCompletedReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                mSyncHandler.onBootCompleted();
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        };
        mBackgroundDataSettingChanged = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                if(getConnectivityManager().getBackgroundDataSetting())
                    scheduleSync(null, -1, null, new Bundle(), 0L, false);
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        };
        mConnectivityIntentReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                boolean flag1 = mDataConnectionIsConnected;
                mDataConnectionIsConnected = readDataConnectionState();
                if(mDataConnectionIsConnected) {
                    if(!flag1) {
                        if(Log.isLoggable("SyncManager", 2))
                            Log.v("SyncManager", "Reconnection detected: clearing all backoffs");
                        mSyncStorageEngine.clearAllBackoffs(mSyncQueue);
                    }
                    sendCheckAlarmsMessage();
                }
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        };
        mShutdownIntentReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                Log.w("SyncManager", "Writing sync state before shutdown...");
                getSyncStorageEngine().writeAllState();
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        };
        mUserIntentReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                onUserRemoved(intent);
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        };
        mBootCompleted = false;
        mContext = context;
        SyncStorageEngine.init(context);
        mSyncStorageEngine = SyncStorageEngine.getSingleton();
        mSyncStorageEngine.setOnSyncRequestListener(new SyncStorageEngine.OnSyncRequestListener() {

            public void onSyncRequest(Account account, int i, String s, Bundle bundle) {
                scheduleSync(account, i, s, bundle, 0L, false);
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        });
        mSyncAdapters = new SyncAdaptersCache(mContext);
        mSyncQueue = new SyncQueue(mSyncStorageEngine, mSyncAdapters);
        HandlerThread handlerthread = new HandlerThread("SyncHandlerThread", 10);
        handlerthread.start();
        mSyncHandler = new SyncHandler(handlerthread.getLooper());
        mSyncAdapters.setListener(new RegisteredServicesCacheListener() {

            public void onServiceChanged(SyncAdapterType syncadaptertype, boolean flag1) {
                if(!flag1)
                    scheduleSync(null, -1, syncadaptertype.authority, null, 0L, false);
            }

            public volatile void onServiceChanged(Object obj, boolean flag1) {
                onServiceChanged((SyncAdapterType)obj, flag1);
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        }, mSyncHandler);
        mSyncAlarmIntent = PendingIntent.getBroadcast(mContext, 0, new Intent("android.content.syncmanager.SYNC_ALARM"), 0);
        IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(mConnectivityIntentReceiver, intentfilter);
        if(!flag) {
            IntentFilter intentfilter1 = new IntentFilter("android.intent.action.BOOT_COMPLETED");
            context.registerReceiver(mBootCompletedReceiver, intentfilter1);
        }
        IntentFilter intentfilter2 = new IntentFilter("android.net.conn.BACKGROUND_DATA_SETTING_CHANGED");
        context.registerReceiver(mBackgroundDataSettingChanged, intentfilter2);
        IntentFilter intentfilter3 = new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW");
        intentfilter3.addAction("android.intent.action.DEVICE_STORAGE_OK");
        context.registerReceiver(mStorageIntentReceiver, intentfilter3);
        IntentFilter intentfilter4 = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        intentfilter4.setPriority(100);
        context.registerReceiver(mShutdownIntentReceiver, intentfilter4);
        IntentFilter intentfilter5 = new IntentFilter();
        intentfilter5.addAction("android.intent.action.USER_REMOVED");
        mContext.registerReceiver(mUserIntentReceiver, intentfilter5);
        if(!flag) {
            mNotificationMgr = (NotificationManager)context.getSystemService("notification");
            context.registerReceiver(new SyncAlarmIntentReceiver(), new IntentFilter("android.content.syncmanager.SYNC_ALARM"));
        } else {
            mNotificationMgr = null;
        }
        mPowerManager = (PowerManager)context.getSystemService("power");
        mHandleAlarmWakeLock = mPowerManager.newWakeLock(1, "SyncManagerHandleSyncAlarm");
        mHandleAlarmWakeLock.setReferenceCounted(false);
        mSyncManagerWakeLock = mPowerManager.newWakeLock(1, "SyncLoopWakeLock");
        mSyncManagerWakeLock.setReferenceCounted(false);
        mSyncStorageEngine.addStatusChangeListener(1, new ISyncStatusObserver.Stub() {

            public void onStatusChanged(int i) {
                sendCheckAlarmsMessage();
            }

            final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
        });
        if(!flag) {
            AccountManager.get(mContext).addOnAccountsUpdatedListener(this, mSyncHandler, false);
            onAccountsUpdated(null);
        }
        mSyncRandomOffsetMillis = 1000 * mSyncStorageEngine.getSyncRandomOffset();
    }

    private void clearBackoffSetting(SyncOperation syncoperation) {
        mSyncStorageEngine.setBackoff(syncoperation.account, syncoperation.userId, syncoperation.authority, -1L, -1L);
        SyncQueue syncqueue = mSyncQueue;
        syncqueue;
        JVM INSTR monitorenter ;
        mSyncQueue.onBackoffChanged(syncoperation.account, syncoperation.userId, syncoperation.authority, 0L);
        return;
    }

    private boolean containsAccountAndUser(AccountAndUser aaccountanduser[], Account account, int i) {
        boolean flag = false;
        int j = 0;
        do {
label0:
            {
                if(j < aaccountanduser.length) {
                    if(aaccountanduser[j].userId != i || !aaccountanduser[j].account.equals(account))
                        break label0;
                    flag = true;
                }
                return flag;
            }
            j++;
        } while(true);
    }

    private void dumpDayStatistic(PrintWriter printwriter, SyncStorageEngine.DayStats daystats) {
        printwriter.print("Success (");
        printwriter.print(daystats.successCount);
        if(daystats.successCount > 0) {
            printwriter.print(" for ");
            dumpTimeSec(printwriter, daystats.successTime);
            printwriter.print(" avg=");
            dumpTimeSec(printwriter, daystats.successTime / (long)daystats.successCount);
        }
        printwriter.print(") Failure (");
        printwriter.print(daystats.failureCount);
        if(daystats.failureCount > 0) {
            printwriter.print(" for ");
            dumpTimeSec(printwriter, daystats.failureTime);
            printwriter.print(" avg=");
            dumpTimeSec(printwriter, daystats.failureTime / (long)daystats.failureCount);
        }
        printwriter.println(")");
    }

    private void dumpDayStatistics(PrintWriter printwriter) {
        SyncStorageEngine.DayStats adaystats[];
        int i;
        int j;
        adaystats = mSyncStorageEngine.getDayStatistics();
        if(adaystats == null || adaystats[0] == null)
            break MISSING_BLOCK_LABEL_305;
        printwriter.println();
        printwriter.println("Sync Statistics");
        printwriter.print("  Today:  ");
        dumpDayStatistic(printwriter, adaystats[0]);
        i = adaystats[0].day;
        j = 1;
_L10:
        if(j > 6 || j >= adaystats.length) goto _L2; else goto _L1
_L1:
        SyncStorageEngine.DayStats daystats2 = adaystats[j];
        if(daystats2 != null) goto _L3; else goto _L2
_L2:
        int k = i;
_L8:
        SyncStorageEngine.DayStats daystats;
        if(j >= adaystats.length)
            break MISSING_BLOCK_LABEL_305;
        daystats = null;
        k -= 7;
_L12:
        if(j >= adaystats.length) goto _L5; else goto _L4
_L4:
        SyncStorageEngine.DayStats daystats1 = adaystats[j];
        if(daystats1 != null) goto _L7; else goto _L6
_L6:
        j = adaystats.length;
_L5:
        int l;
        if(daystats != null) {
            printwriter.print("  Week-");
            printwriter.print((i - k) / 7);
            printwriter.print(": ");
            dumpDayStatistic(printwriter, daystats);
        }
          goto _L8
_L3:
        if((l = i - daystats2.day) > 6) goto _L2; else goto _L9
_L9:
        printwriter.print("  Day-");
        printwriter.print(l);
        printwriter.print(":  ");
        dumpDayStatistic(printwriter, daystats2);
        j++;
          goto _L10
_L7:
        if(k - daystats1.day > 6) goto _L5; else goto _L11
_L11:
        j++;
        if(daystats == null)
            daystats = new SyncStorageEngine.DayStats(k);
        daystats.successCount = daystats.successCount + daystats1.successCount;
        daystats.successTime = daystats.successTime + daystats1.successTime;
        daystats.failureCount = daystats.failureCount + daystats1.failureCount;
        daystats.failureTime = daystats.failureTime + daystats1.failureTime;
          goto _L12
          goto _L8
    }

    private void dumpRecentHistory(PrintWriter printwriter) {
        ArrayList arraylist = mSyncStorageEngine.getSyncHistory();
        if(arraylist != null && arraylist.size() > 0) {
            HashMap hashmap = Maps.newHashMap();
            long l = 0L;
            long l1 = 0L;
            int i = arraylist.size();
            int j = 0;
            int k = 0;
            Iterator iterator = arraylist.iterator();
            while(iterator.hasNext())  {
                SyncStorageEngine.SyncHistoryItem synchistoryitem1 = (SyncStorageEngine.SyncHistoryItem)iterator.next();
                SyncStorageEngine.AuthorityInfo authorityinfo1 = mSyncStorageEngine.getAuthority(synchistoryitem1.authorityId);
                String s13;
                String s14;
                int k2;
                int i3;
                long l8;
                AuthoritySyncStats authoritysyncstats1;
                Map map;
                AccountSyncStats accountsyncstats1;
                if(authorityinfo1 != null) {
                    s13 = authorityinfo1.authority;
                    s14 = (new StringBuilder()).append(authorityinfo1.account.name).append("/").append(authorityinfo1.account.type).toString();
                } else {
                    s13 = "Unknown";
                    s14 = "Unknown";
                }
                k2 = s13.length();
                if(k2 > j)
                    j = k2;
                i3 = s14.length();
                if(i3 > k)
                    k = i3;
                l8 = synchistoryitem1.elapsedTime;
                l += l8;
                l1++;
                authoritysyncstats1 = (AuthoritySyncStats)hashmap.get(s13);
                if(authoritysyncstats1 == null) {
                    authoritysyncstats1 = new AuthoritySyncStats(s13);
                    hashmap.put(s13, authoritysyncstats1);
                }
                authoritysyncstats1.elapsedTime = l8 + authoritysyncstats1.elapsedTime;
                authoritysyncstats1.times = 1 + authoritysyncstats1.times;
                map = authoritysyncstats1.accountMap;
                accountsyncstats1 = (AccountSyncStats)map.get(s14);
                if(accountsyncstats1 == null) {
                    accountsyncstats1 = new AccountSyncStats(s14);
                    map.put(s14, accountsyncstats1);
                }
                accountsyncstats1.elapsedTime = l8 + accountsyncstats1.elapsedTime;
                accountsyncstats1.times = 1 + accountsyncstats1.times;
            }
            if(l > 0L) {
                printwriter.println();
                Object aobj6[] = new Object[2];
                aobj6[0] = Long.valueOf(l1);
                aobj6[1] = Long.valueOf(l / 1000L);
                printwriter.printf("Detailed Statistics (Recent history):  %d (# of times) %ds (sync time)\n", aobj6);
                ArrayList arraylist1 = new ArrayList(hashmap.values());
                Comparator comparator = new Comparator() {

                    public int compare(AuthoritySyncStats authoritysyncstats2, AuthoritySyncStats authoritysyncstats3) {
                        int j3 = Integer.compare(authoritysyncstats3.times, authoritysyncstats2.times);
                        if(j3 == 0)
                            j3 = Long.compare(authoritysyncstats3.elapsedTime, authoritysyncstats2.elapsedTime);
                        return j3;
                    }

                    public volatile int compare(Object obj, Object obj1) {
                        return compare((AuthoritySyncStats)obj, (AuthoritySyncStats)obj1);
                    }

                    final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
                };
                Collections.sort(arraylist1, comparator);
                int j1 = k + 3;
                int k1 = Math.max(j, j1);
                char ac[] = new char[11 + (10 + (2 + (k1 + 4)))];
                Arrays.fill(ac, '-');
                String s5 = new String(ac);
                Object aobj7[] = new Object[1];
                aobj7[0] = Integer.valueOf(k1 + 2);
                String s6 = String.format("  %%-%ds: %%-9s  %%-11s\n", aobj7);
                Object aobj8[] = new Object[1];
                aobj8[0] = Integer.valueOf(k1);
                String s7 = String.format("    %%-%ds:   %%-9s  %%-11s\n", aobj8);
                printwriter.println(s5);
                for(Iterator iterator1 = arraylist1.iterator(); iterator1.hasNext(); printwriter.println(s5)) {
                    AuthoritySyncStats authoritysyncstats = (AuthoritySyncStats)iterator1.next();
                    String s8 = authoritysyncstats.name;
                    long l6 = authoritysyncstats.elapsedTime;
                    int i2 = authoritysyncstats.times;
                    Object aobj9[] = new Object[2];
                    aobj9[0] = Long.valueOf(l6 / 1000L);
                    aobj9[1] = Long.valueOf((100L * l6) / l);
                    String s9 = String.format("%ds/%d%%", aobj9);
                    Object aobj10[] = new Object[2];
                    aobj10[0] = Integer.valueOf(i2);
                    aobj10[1] = Long.valueOf((long)(i2 * 100) / l1);
                    String s10 = String.format("%d/%d%%", aobj10);
                    Object aobj11[] = new Object[3];
                    aobj11[0] = s8;
                    aobj11[1] = s10;
                    aobj11[2] = s9;
                    printwriter.printf(s6, aobj11);
                    ArrayList arraylist2 = new ArrayList(authoritysyncstats.accountMap.values());
                    Comparator comparator1 = new Comparator() {

                        public int compare(AccountSyncStats accountsyncstats2, AccountSyncStats accountsyncstats3) {
                            int j3 = Integer.compare(accountsyncstats3.times, accountsyncstats2.times);
                            if(j3 == 0)
                                j3 = Long.compare(accountsyncstats3.elapsedTime, accountsyncstats2.elapsedTime);
                            return j3;
                        }

                        public volatile int compare(Object obj, Object obj1) {
                            return compare((AccountSyncStats)obj, (AccountSyncStats)obj1);
                        }

                        final SyncManager this$0;

             {
                this$0 = SyncManager.this;
                super();
            }
                    };
                    Collections.sort(arraylist2, comparator1);
                    Object aobj14[];
                    for(Iterator iterator2 = arraylist2.iterator(); iterator2.hasNext(); printwriter.printf(s7, aobj14)) {
                        AccountSyncStats accountsyncstats = (AccountSyncStats)iterator2.next();
                        long l7 = accountsyncstats.elapsedTime;
                        int j2 = accountsyncstats.times;
                        Object aobj12[] = new Object[2];
                        aobj12[0] = Long.valueOf(l7 / 1000L);
                        aobj12[1] = Long.valueOf((100L * l7) / l);
                        String s11 = String.format("%ds/%d%%", aobj12);
                        Object aobj13[] = new Object[2];
                        aobj13[0] = Integer.valueOf(j2);
                        aobj13[1] = Long.valueOf((long)(j2 * 100) / l1);
                        String s12 = String.format("%d/%d%%", aobj13);
                        aobj14 = new Object[3];
                        aobj14[0] = accountsyncstats.name;
                        aobj14[1] = s12;
                        aobj14[2] = s11;
                    }

                }

            }
            printwriter.println();
            printwriter.println("Recent Sync History");
            String s = (new StringBuilder()).append("  %-").append(k).append("s  %s\n").toString();
            HashMap hashmap1 = Maps.newHashMap();
            int i1 = 0;
            while(i1 < i)  {
                SyncStorageEngine.SyncHistoryItem synchistoryitem = (SyncStorageEngine.SyncHistoryItem)arraylist.get(i1);
                SyncStorageEngine.AuthorityInfo authorityinfo = mSyncStorageEngine.getAuthority(synchistoryitem.authorityId);
                String s1;
                String s2;
                long l2;
                Time time;
                long l3;
                String s3;
                Long long1;
                String s4;
                Object aobj1[];
                Object aobj2[];
                if(authorityinfo != null) {
                    s1 = authorityinfo.authority;
                    s2 = (new StringBuilder()).append(authorityinfo.account.name).append("/").append(authorityinfo.account.type).toString();
                } else {
                    s1 = "Unknown";
                    s2 = "Unknown";
                }
                l2 = synchistoryitem.elapsedTime;
                time = new Time();
                l3 = synchistoryitem.eventTime;
                time.set(l3);
                s3 = (new StringBuilder()).append(s1).append("/").append(s2).toString();
                long1 = (Long)hashmap1.get(s3);
                if(long1 == null) {
                    s4 = "";
                } else {
                    long l4 = (long1.longValue() - l3) / 1000L;
                    if(l4 < 60L)
                        s4 = String.valueOf(l4);
                    else
                    if(l4 < 3600L) {
                        Object aobj5[] = new Object[2];
                        aobj5[0] = Long.valueOf(l4 / 60L);
                        aobj5[1] = Long.valueOf(l4 % 60L);
                        s4 = String.format("%02d:%02d", aobj5);
                    } else {
                        long l5 = l4 % 3600L;
                        Object aobj[] = new Object[3];
                        aobj[0] = Long.valueOf(l4 / 3600L);
                        aobj[1] = Long.valueOf(l5 / 60L);
                        aobj[2] = Long.valueOf(l5 % 60L);
                        s4 = String.format("%02d:%02d:%02d", aobj);
                    }
                }
                hashmap1.put(s3, Long.valueOf(l3));
                aobj1 = new Object[5];
                aobj1[0] = Integer.valueOf(i1 + 1);
                aobj1[1] = formatTime(l3);
                aobj1[2] = SyncStorageEngine.SOURCES[synchistoryitem.source];
                aobj1[3] = Float.valueOf((float)l2 / 1000F);
                aobj1[4] = s4;
                printwriter.printf("  #%-3d: %s %8s  %5.1fs  %8s", aobj1);
                aobj2 = new Object[2];
                aobj2[0] = s2;
                aobj2[1] = s1;
                printwriter.printf(s, aobj2);
                if(synchistoryitem.event != 1 || synchistoryitem.upstreamActivity != 0L || synchistoryitem.downstreamActivity != 0L) {
                    Object aobj3[] = new Object[3];
                    aobj3[0] = Integer.valueOf(synchistoryitem.event);
                    aobj3[1] = Long.valueOf(synchistoryitem.upstreamActivity);
                    aobj3[2] = Long.valueOf(synchistoryitem.downstreamActivity);
                    printwriter.printf("    event=%d upstreamActivity=%d downstreamActivity=%d\n", aobj3);
                }
                if(synchistoryitem.mesg != null && !"success".equals(synchistoryitem.mesg)) {
                    Object aobj4[] = new Object[1];
                    aobj4[0] = synchistoryitem.mesg;
                    printwriter.printf("    mesg=%s\n", aobj4);
                }
                i1++;
            }
        }
    }

    private void dumpTimeSec(PrintWriter printwriter, long l) {
        printwriter.print(l / 1000L);
        printwriter.print('.');
        printwriter.print((l / 100L) % 10L);
        printwriter.print('s');
    }

    private void ensureAlarmService() {
        if(mAlarmService == null)
            mAlarmService = (AlarmManager)mContext.getSystemService("alarm");
    }

    static String formatTime(long l) {
        Time time = new Time();
        time.set(l);
        return time.format("%Y-%m-%d %H:%M:%S");
    }

    private List getAllUsers() {
        List list1 = AppGlobals.getPackageManager().getUsers();
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private ConnectivityManager getConnectivityManager() {
        this;
        JVM INSTR monitorenter ;
        if(mConnManagerDoNotUseDirectly == null)
            mConnManagerDoNotUseDirectly = (ConnectivityManager)mContext.getSystemService("connectivity");
        ConnectivityManager connectivitymanager = mConnManagerDoNotUseDirectly;
        return connectivitymanager;
    }

    private String getLastFailureMessage(int i) {
        i;
        JVM INSTR tableswitch 1 8: default 48
    //                   1 54
    //                   2 61
    //                   3 68
    //                   4 75
    //                   5 82
    //                   6 89
    //                   7 96
    //                   8 103;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        String s = "unknown";
_L11:
        return s;
_L2:
        s = "sync already in progress";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "authentication error";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "I/O error";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "parse error";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "conflict error";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "too many deletions error";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "too many retries error";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "internal error";
        if(true) goto _L11; else goto _L10
_L10:
    }

    private void increaseBackoffSetting(SyncOperation syncoperation) {
        long l;
        Pair pair;
        long l1;
        l = SystemClock.elapsedRealtime();
        pair = mSyncStorageEngine.getBackoff(syncoperation.account, syncoperation.userId, syncoperation.authority);
        l1 = -1L;
        if(pair == null) goto _L2; else goto _L1
_L1:
        if(l >= ((Long)pair.first).longValue()) goto _L4; else goto _L3
_L3:
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("Still in backoff, do not increase it. Remaining: ").append((((Long)pair.first).longValue() - l) / 1000L).append(" seconds.").toString());
_L6:
        return;
_L4:
        l1 = 2L * ((Long)pair.second).longValue();
_L2:
        long l3;
        if(l1 <= 0L)
            l1 = jitterize(30000L, 33000L);
        long l2 = android.provider.Settings.Secure.getLong(mContext.getContentResolver(), "sync_max_retry_delay_in_seconds", 3600L);
        if(l1 > 1000L * l2)
            l1 = l2 * 1000L;
        l3 = l + l1;
        mSyncStorageEngine.setBackoff(syncoperation.account, syncoperation.userId, syncoperation.authority, l3, l1);
        syncoperation.backoff = Long.valueOf(l3);
        syncoperation.updateEffectiveRunTime();
        SyncQueue syncqueue = mSyncQueue;
        syncqueue;
        JVM INSTR monitorenter ;
        mSyncQueue.onBackoffChanged(syncoperation.account, syncoperation.userId, syncoperation.authority, l3);
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean isSyncStillActive(ActiveSyncContext activesynccontext) {
        Iterator iterator = mActiveSyncContexts.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if((ActiveSyncContext)iterator.next() != activesynccontext) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        return flag;
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private long jitterize(long l, long l1) {
        Random random = new Random(SystemClock.elapsedRealtime());
        long l2 = l1 - l;
        if(l2 > 0x7fffffffL)
            throw new IllegalArgumentException("the difference between the maxValue and the minValue must be less than 2147483647");
        else
            return l + (long)random.nextInt((int)l2);
    }

    private void onUserRemoved(Intent intent) {
        int i = intent.getIntExtra("android.intent.extra.user_id", -1);
        if(i != -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mSyncStorageEngine.doDatabaseCleanup(new Account[0], i);
        onAccountsUpdated(null);
        SyncQueue syncqueue = mSyncQueue;
        syncqueue;
        JVM INSTR monitorenter ;
        mSyncQueue.removeUser(i);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean readDataConnectionState() {
        NetworkInfo networkinfo = getConnectivityManager().getActiveNetworkInfo();
        boolean flag;
        if(networkinfo != null && networkinfo.isConnected())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void sendCancelSyncsMessage(Account account, int i, String s) {
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", "sending MESSAGE_CANCEL");
        Message message = mSyncHandler.obtainMessage();
        message.what = 6;
        message.obj = Pair.create(account, s);
        message.arg1 = i;
        mSyncHandler.sendMessage(message);
    }

    private void sendCheckAlarmsMessage() {
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", "sending MESSAGE_CHECK_ALARMS");
        mSyncHandler.removeMessages(3);
        mSyncHandler.sendEmptyMessage(3);
    }

    private void sendSyncAlarmMessage() {
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", "sending MESSAGE_SYNC_ALARM");
        mSyncHandler.sendEmptyMessage(2);
    }

    private void sendSyncFinishedOrCanceledMessage(ActiveSyncContext activesynccontext, SyncResult syncresult) {
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", "sending MESSAGE_SYNC_FINISHED");
        Message message = mSyncHandler.obtainMessage();
        message.what = 1;
        message.obj = new SyncHandlerMessagePayload(activesynccontext, syncresult);
        mSyncHandler.sendMessage(message);
    }

    private void setDelayUntilTime(SyncOperation syncoperation, long l) {
        long l1 = l * 1000L;
        long l2 = System.currentTimeMillis();
        long l3;
        SyncQueue syncqueue;
        if(l1 > l2)
            l3 = SystemClock.elapsedRealtime() + (l1 - l2);
        else
            l3 = 0L;
        mSyncStorageEngine.setDelayUntilTime(syncoperation.account, syncoperation.userId, syncoperation.authority, l3);
        syncqueue = mSyncQueue;
        syncqueue;
        JVM INSTR monitorenter ;
        mSyncQueue.onDelayUntilTimeChanged(syncoperation.account, syncoperation.authority, l3);
        return;
    }

    public void cancelActiveSync(Account account, int i, String s) {
        sendCancelSyncsMessage(account, i, s);
    }

    public void clearScheduledSyncOperations(Account account, int i, String s) {
        synchronized(mSyncQueue) {
            mSyncQueue.remove(account, i, s);
        }
        mSyncStorageEngine.setBackoff(account, i, s, -1L, -1L);
        return;
        exception;
        syncqueue;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter) {
        dumpSyncState(printwriter);
        dumpSyncHistory(printwriter);
        printwriter.println();
        printwriter.println("SyncAdapters:");
        android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo;
        for(Iterator iterator = mSyncAdapters.getAllServices().iterator(); iterator.hasNext(); printwriter.println((new StringBuilder()).append("  ").append(serviceinfo).toString()))
            serviceinfo = (android.content.pm.RegisteredServicesCache.ServiceInfo)iterator.next();

    }

    protected void dumpSyncHistory(PrintWriter printwriter) {
        dumpRecentHistory(printwriter);
        dumpDayStatistics(printwriter);
    }

    protected void dumpSyncState(PrintWriter printwriter) {
        AccountAndUser aaccountanduser[];
        long l;
        int i;
        int j;
        printwriter.print("data connected: ");
        printwriter.println(mDataConnectionIsConnected);
        printwriter.print("auto sync: ");
        List list = getAllUsers();
        if(list != null) {
            UserInfo userinfo;
            for(Iterator iterator2 = list.iterator(); iterator2.hasNext(); printwriter.print((new StringBuilder()).append("u").append(userinfo.id).append("=").append(mSyncStorageEngine.getMasterSyncAutomatically(userinfo.id)).toString()))
                userinfo = (UserInfo)iterator2.next();

            printwriter.println();
        }
        printwriter.print("memory low: ");
        printwriter.println(mStorageIsLow);
        aaccountanduser = mAccounts;
        printwriter.print("accounts: ");
        String s;
        StringBuilder stringbuilder;
        if(aaccountanduser != INITIAL_ACCOUNTS_ARRAY)
            printwriter.println(aaccountanduser.length);
        else
            printwriter.println("not known yet");
        l = SystemClock.elapsedRealtime();
        printwriter.print("now: ");
        printwriter.print(l);
        printwriter.println((new StringBuilder()).append(" (").append(formatTime(System.currentTimeMillis())).append(")").toString());
        printwriter.print("offset: ");
        printwriter.print(DateUtils.formatElapsedTime(mSyncRandomOffsetMillis / 1000));
        printwriter.println(" (HH:MM:SS)");
        printwriter.print("uptime: ");
        printwriter.print(DateUtils.formatElapsedTime(l / 1000L));
        printwriter.println(" (HH:MM:SS)");
        printwriter.print("time spent syncing: ");
        printwriter.print(DateUtils.formatElapsedTime(mSyncHandler.mSyncTimeTracker.timeSpentSyncing() / 1000L));
        printwriter.print(" (HH:MM:SS), sync ");
        if(mSyncHandler.mSyncTimeTracker.mLastWasSyncing)
            s = "";
        else
            s = "not ";
        printwriter.print(s);
        printwriter.println("in progress");
        if(mSyncHandler.mAlarmScheduleTime != null) {
            printwriter.print("next alarm time: ");
            printwriter.print(mSyncHandler.mAlarmScheduleTime);
            printwriter.print(" (");
            printwriter.print(DateUtils.formatElapsedTime((mSyncHandler.mAlarmScheduleTime.longValue() - l) / 1000L));
            printwriter.println(" (HH:MM:SS) from now)");
        } else {
            printwriter.println("no alarm is scheduled (there had better not be any pending syncs)");
        }
        printwriter.print("notification info: ");
        stringbuilder = new StringBuilder();
        mSyncHandler.mSyncNotificationInfo.toString(stringbuilder);
        printwriter.println(stringbuilder.toString());
        printwriter.println();
        printwriter.println((new StringBuilder()).append("Active Syncs: ").append(mActiveSyncContexts.size()).toString());
        for(Iterator iterator = mActiveSyncContexts.iterator(); iterator.hasNext(); printwriter.println()) {
            ActiveSyncContext activesynccontext = (ActiveSyncContext)iterator.next();
            long l2 = (l - activesynccontext.mStartTime) / 1000L;
            printwriter.print("  ");
            printwriter.print(DateUtils.formatElapsedTime(l2));
            printwriter.print(" - ");
            printwriter.print(activesynccontext.mSyncOperation.dump(false));
        }

        synchronized(mSyncQueue) {
            stringbuilder.setLength(0);
            mSyncQueue.dump(stringbuilder);
        }
        printwriter.println();
        printwriter.print(stringbuilder.toString());
        printwriter.println();
        printwriter.println("Sync Status");
        i = aaccountanduser.length;
        j = 0;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        AccountAndUser accountanduser;
        Iterator iterator1;
        accountanduser = aaccountanduser[j];
        printwriter.print("  Account ");
        printwriter.print(accountanduser.account.name);
        printwriter.print(" u");
        printwriter.print(accountanduser.userId);
        printwriter.print(" ");
        printwriter.print(accountanduser.account.type);
        printwriter.println(":");
        iterator1 = mSyncAdapters.getAllServices().iterator();
_L4:
        SyncStatusInfo syncstatusinfo;
        if(!iterator1.hasNext())
            continue; /* Loop/switch isn't completed */
        android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo = (android.content.pm.RegisteredServicesCache.ServiceInfo)iterator1.next();
        if(!((SyncAdapterType)serviceinfo.type).accountType.equals(accountanduser.account.type))
            continue; /* Loop/switch isn't completed */
        SyncStorageEngine.AuthorityInfo authorityinfo = mSyncStorageEngine.getOrCreateAuthority(accountanduser.account, accountanduser.userId, ((SyncAdapterType)serviceinfo.type).authority);
        syncstatusinfo = mSyncStorageEngine.getOrCreateSyncStatus(authorityinfo);
        printwriter.print("    ");
        printwriter.print(authorityinfo.authority);
        printwriter.println(":");
        printwriter.print("      settings:");
        StringBuilder stringbuilder1 = (new StringBuilder()).append(" ");
        String s1;
        StringBuilder stringbuilder2;
        String s2;
        int k;
        if(authorityinfo.syncable > 0)
            s1 = "syncable";
        else
        if(authorityinfo.syncable == 0)
            s1 = "not syncable";
        else
            s1 = "not initialized";
        printwriter.print(stringbuilder1.append(s1).toString());
        stringbuilder2 = (new StringBuilder()).append(", ");
        if(authorityinfo.enabled)
            s2 = "enabled";
        else
            s2 = "disabled";
        printwriter.print(stringbuilder2.append(s2).toString());
        if(authorityinfo.delayUntil > l)
            printwriter.print((new StringBuilder()).append(", delay for ").append((authorityinfo.delayUntil - l) / 1000L).append(" sec").toString());
        if(authorityinfo.backoffTime > l)
            printwriter.print((new StringBuilder()).append(", backoff for ").append((authorityinfo.backoffTime - l) / 1000L).append(" sec").toString());
        if(authorityinfo.backoffDelay > 0L)
            printwriter.print((new StringBuilder()).append(", the backoff increment is ").append(authorityinfo.backoffDelay / 1000L).append(" sec").toString());
        printwriter.println();
        k = 0;
        do {
            int i1 = authorityinfo.periodicSyncs.size();
            if(k >= i1)
                break;
            Pair pair = (Pair)authorityinfo.periodicSyncs.get(k);
            long l1 = syncstatusinfo.getPeriodicSyncTime(k) + 1000L * ((Long)pair.second).longValue();
            printwriter.println((new StringBuilder()).append("      periodic period=").append(pair.second).append(", extras=").append(pair.first).append(", next=").append(formatTime(l1)).toString());
            k++;
        } while(true);
        break MISSING_BLOCK_LABEL_1252;
        exception;
        syncqueue;
        JVM INSTR monitorexit ;
        throw exception;
        printwriter.print("      count: local=");
        printwriter.print(syncstatusinfo.numSourceLocal);
        printwriter.print(" poll=");
        printwriter.print(syncstatusinfo.numSourcePoll);
        printwriter.print(" periodic=");
        printwriter.print(syncstatusinfo.numSourcePeriodic);
        printwriter.print(" server=");
        printwriter.print(syncstatusinfo.numSourceServer);
        printwriter.print(" user=");
        printwriter.print(syncstatusinfo.numSourceUser);
        printwriter.print(" total=");
        printwriter.print(syncstatusinfo.numSyncs);
        printwriter.println();
        printwriter.print("      total duration: ");
        printwriter.println(DateUtils.formatElapsedTime(syncstatusinfo.totalElapsedTime / 1000L));
        if(syncstatusinfo.lastSuccessTime != 0L) {
            printwriter.print("      SUCCESS: source=");
            printwriter.print(SyncStorageEngine.SOURCES[syncstatusinfo.lastSuccessSource]);
            printwriter.print(" time=");
            printwriter.println(formatTime(syncstatusinfo.lastSuccessTime));
        }
        if(syncstatusinfo.lastFailureTime != 0L) {
            printwriter.print("      FAILURE: source=");
            printwriter.print(SyncStorageEngine.SOURCES[syncstatusinfo.lastFailureSource]);
            printwriter.print(" initialTime=");
            printwriter.print(formatTime(syncstatusinfo.initialFailureTime));
            printwriter.print(" lastTime=");
            printwriter.println(formatTime(syncstatusinfo.lastFailureTime));
            int j1 = syncstatusinfo.getLastFailureMesgAsInt(0);
            printwriter.print("      message: ");
            printwriter.println((new StringBuilder()).append(getLastFailureMessage(j1)).append(" (").append(j1).append(")").toString());
        }
        if(true) goto _L4; else goto _L3
_L3:
        j++;
          goto _L5
_L2:
    }

    public SyncAdapterType[] getSyncAdapterTypes() {
        Collection collection = mSyncAdapters.getAllServices();
        SyncAdapterType asyncadaptertype[] = new SyncAdapterType[collection.size()];
        int i = 0;
        for(Iterator iterator = collection.iterator(); iterator.hasNext();) {
            asyncadaptertype[i] = (SyncAdapterType)((android.content.pm.RegisteredServicesCache.ServiceInfo)iterator.next()).type;
            i++;
        }

        return asyncadaptertype;
    }

    public SyncStorageEngine getSyncStorageEngine() {
        return mSyncStorageEngine;
    }

    void maybeRescheduleSync(SyncResult syncresult, SyncOperation syncoperation) {
        boolean flag = Log.isLoggable("SyncManager", 3);
        if(flag)
            Log.d("SyncManager", (new StringBuilder()).append("encountered error(s) during the sync: ").append(syncresult).append(", ").append(syncoperation).toString());
        SyncOperation syncoperation1 = new SyncOperation(syncoperation);
        if(syncoperation1.extras.getBoolean("ignore_backoff", false))
            syncoperation1.extras.remove("ignore_backoff");
        if(syncoperation1.extras.getBoolean("do_not_retry", false))
            Log.d("SyncManager", (new StringBuilder()).append("not retrying sync operation because SYNC_EXTRAS_DO_NOT_RETRY was specified ").append(syncoperation1).toString());
        else
        if(syncoperation1.extras.getBoolean("upload", false) && !syncresult.syncAlreadyInProgress) {
            syncoperation1.extras.remove("upload");
            Log.d("SyncManager", (new StringBuilder()).append("retrying sync operation as a two-way sync because an upload-only sync encountered an error: ").append(syncoperation1).toString());
            scheduleSyncOperation(syncoperation1);
        } else
        if(syncresult.tooManyRetries)
            Log.d("SyncManager", (new StringBuilder()).append("not retrying sync operation because it retried too many times: ").append(syncoperation1).toString());
        else
        if(syncresult.madeSomeProgress()) {
            if(flag)
                Log.d("SyncManager", "retrying sync operation because even though it had an error it achieved some success");
            scheduleSyncOperation(syncoperation1);
        } else
        if(syncresult.syncAlreadyInProgress) {
            if(flag)
                Log.d("SyncManager", (new StringBuilder()).append("retrying sync operation that failed because there was already a sync in progress: ").append(syncoperation1).toString());
            scheduleSyncOperation(new SyncOperation(syncoperation1.account, syncoperation1.userId, syncoperation1.syncSource, syncoperation1.authority, syncoperation1.extras, 10000L, syncoperation1.backoff.longValue(), syncoperation1.delayUntil, syncoperation1.allowParallelSyncs));
        } else
        if(syncresult.hasSoftError()) {
            if(flag)
                Log.d("SyncManager", (new StringBuilder()).append("retrying sync operation because it encountered a soft error: ").append(syncoperation1).toString());
            scheduleSyncOperation(syncoperation1);
        } else {
            Log.d("SyncManager", (new StringBuilder()).append("not retrying sync operation because the error is a hard error: ").append(syncoperation1).toString());
        }
    }

    public void onAccountsUpdated(Account aaccount[]) {
        boolean flag;
        List list;
        if(mAccounts == INITIAL_ACCOUNTS_ARRAY)
            flag = true;
        else
            flag = false;
        list = getAllUsers();
        if(list != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        AccountAndUser aaccountanduser[] = AccountManagerService.getSingleton().getAllAccounts();
        Iterator iterator = list.iterator();
        do {
            if(!iterator.hasNext())
                break;
            UserInfo userinfo = (UserInfo)iterator.next();
            if(mBootCompleted) {
                Account aaccount1[] = AccountManagerService.getSingleton().getAccounts(userinfo.id);
                mSyncStorageEngine.doDatabaseCleanup(aaccount1, userinfo.id);
            }
        } while(true);
        mAccounts = aaccountanduser;
        Iterator iterator1 = mActiveSyncContexts.iterator();
        do {
            if(!iterator1.hasNext())
                break;
            ActiveSyncContext activesynccontext = (ActiveSyncContext)iterator1.next();
            if(!containsAccountAndUser(aaccountanduser, activesynccontext.mSyncOperation.account, activesynccontext.mSyncOperation.userId)) {
                Log.d("SyncManager", "canceling sync since the account has been removed");
                sendSyncFinishedOrCanceledMessage(activesynccontext, null);
            }
        } while(true);
        sendCheckAlarmsMessage();
        if(aaccountanduser.length > 0)
            scheduleSync(null, -1, null, null, 0L, flag);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void scheduleLocalSync(Account account, int i, String s) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("upload", true);
        scheduleSync(account, i, s, bundle, LOCAL_SYNC_DELAY, false);
    }

    public void scheduleSync(Account account, int i, String s, Bundle bundle, long l, boolean flag) {
        boolean flag1;
        boolean flag2;
        AccountAndUser aaccountanduser[];
        flag1 = Log.isLoggable("SyncManager", 2);
        Iterator iterator;
        if(!mBootCompleted || getConnectivityManager().getBackgroundDataSetting())
            flag2 = true;
        else
            flag2 = false;
        if(bundle == null)
            bundle = new Bundle();
        if(Boolean.valueOf(bundle.getBoolean("expedited", false)).booleanValue())
            l = -1L;
        if(account != null && i != -1) {
            aaccountanduser = new AccountAndUser[1];
            aaccountanduser[0] = new AccountAndUser(account, i);
            break MISSING_BLOCK_LABEL_94;
        }
        aaccountanduser = mAccounts;
        if(aaccountanduser.length != 0) goto _L2; else goto _L1
_L1:
        if(flag1)
            Log.v("SyncManager", "scheduleSync: no accounts configured, dropping");
_L4:
        return;
_L2:
        boolean flag3 = bundle.getBoolean("upload", false);
        boolean flag4 = bundle.getBoolean("force", false);
        if(flag4) {
            bundle.putBoolean("ignore_backoff", true);
            bundle.putBoolean("ignore_settings", true);
        }
        boolean flag5 = bundle.getBoolean("ignore_settings", false);
        byte byte0;
        HashSet hashset;
        if(flag3)
            byte0 = 1;
        else
        if(flag4)
            byte0 = 3;
        else
        if(s == null)
            byte0 = 2;
        else
            byte0 = 0;
        hashset = new HashSet();
        for(iterator = mSyncAdapters.getAllServices().iterator(); iterator.hasNext(); hashset.add(((SyncAdapterType)((android.content.pm.RegisteredServicesCache.ServiceInfo)iterator.next()).type).authority));
        if(s != null) {
            boolean flag9 = hashset.contains(s);
            hashset.clear();
            if(flag9)
                hashset.add(s);
        }
        Iterator iterator1 = hashset.iterator();
        while(iterator1.hasNext())  {
            String s1 = (String)iterator1.next();
            AccountAndUser aaccountanduser1[] = aaccountanduser;
            int j = aaccountanduser1.length;
            int k = 0;
            while(k < j)  {
                AccountAndUser accountanduser = aaccountanduser1[k];
                int i1 = mSyncStorageEngine.getIsSyncable(accountanduser.account, accountanduser.userId, s1);
                if(i1 != 0) {
                    android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo = mSyncAdapters.getServiceInfo(SyncAdapterType.newKey(s1, accountanduser.account.type));
                    if(serviceinfo != null) {
                        boolean flag6 = ((SyncAdapterType)serviceinfo.type).allowParallelSyncs();
                        boolean flag7 = ((SyncAdapterType)serviceinfo.type).isAlwaysSyncable();
                        if(i1 < 0 && flag7) {
                            mSyncStorageEngine.setIsSyncable(accountanduser.account, accountanduser.userId, s1, 1);
                            i1 = 1;
                        }
                        if((!flag || i1 < 0) && (((SyncAdapterType)serviceinfo.type).supportsUploading() || !flag3)) {
                            boolean flag8;
                            if(i1 < 0 || flag5 || flag2 && mSyncStorageEngine.getMasterSyncAutomatically(accountanduser.userId) && mSyncStorageEngine.getSyncAutomatically(accountanduser.account, accountanduser.userId, s1))
                                flag8 = true;
                            else
                                flag8 = false;
                            if(!flag8) {
                                if(flag1)
                                    Log.d("SyncManager", (new StringBuilder()).append("scheduleSync: sync of ").append(accountanduser).append(", ").append(s1).append(" is not allowed, dropping request").toString());
                            } else {
                                Pair pair = mSyncStorageEngine.getBackoff(accountanduser.account, accountanduser.userId, s1);
                                long l1 = mSyncStorageEngine.getDelayUntilTime(accountanduser.account, accountanduser.userId, s1);
                                long l2;
                                if(pair != null)
                                    l2 = ((Long)pair.first).longValue();
                                else
                                    l2 = 0L;
                                if(i1 < 0) {
                                    Bundle bundle1 = new Bundle();
                                    bundle1.putBoolean("initialize", true);
                                    if(flag1)
                                        Log.v("SyncManager", (new StringBuilder()).append("scheduleSync: delay ").append(l).append(", source ").append(byte0).append(", account ").append(accountanduser).append(", authority ").append(s1).append(", extras ").append(bundle1).toString());
                                    scheduleSyncOperation(new SyncOperation(accountanduser.account, accountanduser.userId, byte0, s1, bundle1, 0L, l2, l1, flag6));
                                }
                                if(!flag) {
                                    if(flag1)
                                        Log.v("SyncManager", (new StringBuilder()).append("scheduleSync: delay ").append(l).append(", source ").append(byte0).append(", account ").append(accountanduser).append(", authority ").append(s1).append(", extras ").append(bundle).toString());
                                    scheduleSyncOperation(new SyncOperation(accountanduser.account, accountanduser.userId, byte0, s1, bundle, l, l2, l1, flag6));
                                }
                            }
                        }
                    }
                }
                k++;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void scheduleSyncOperation(SyncOperation syncoperation) {
        boolean flag;
        synchronized(mSyncQueue) {
            flag = mSyncQueue.add(syncoperation);
        }
        if(!flag) goto _L2; else goto _L1
_L1:
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("scheduleSyncOperation: enqueued ").append(syncoperation).toString());
        sendCheckAlarmsMessage();
_L4:
        return;
        exception;
        syncqueue;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("scheduleSyncOperation: dropping duplicate sync operation ").append(syncoperation).toString());
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final String ACTION_SYNC_ALARM = "android.content.syncmanager.SYNC_ALARM";
    private static final long DEFAULT_MAX_SYNC_RETRY_TIME_IN_SECONDS = 3600L;
    private static final int DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS = 10;
    private static final String HANDLE_SYNC_ALARM_WAKE_LOCK = "SyncManagerHandleSyncAlarm";
    private static final int INITIALIZATION_UNBIND_DELAY_MS = 5000;
    private static final AccountAndUser INITIAL_ACCOUNTS_ARRAY[] = new AccountAndUser[0];
    private static final long INITIAL_SYNC_RETRY_TIME_IN_MS = 30000L;
    private static final long LOCAL_SYNC_DELAY = 0L;
    private static final int MAX_SIMULTANEOUS_INITIALIZATION_SYNCS = 0;
    private static final int MAX_SIMULTANEOUS_REGULAR_SYNCS = 0;
    private static final long MAX_TIME_PER_SYNC = 0L;
    private static final long SYNC_ALARM_TIMEOUT_MAX = 0x6ddd00L;
    private static final long SYNC_ALARM_TIMEOUT_MIN = 30000L;
    private static final String SYNC_LOOP_WAKE_LOCK = "SyncLoopWakeLock";
    private static final long SYNC_NOTIFICATION_DELAY = 0L;
    private static final String SYNC_WAKE_LOCK_PREFIX = "*sync*";
    private static final String TAG = "SyncManager";
    private volatile AccountAndUser mAccounts[];
    protected final ArrayList mActiveSyncContexts = Lists.newArrayList();
    private AlarmManager mAlarmService;
    private BroadcastReceiver mBackgroundDataSettingChanged;
    private volatile boolean mBootCompleted;
    private BroadcastReceiver mBootCompletedReceiver;
    private ConnectivityManager mConnManagerDoNotUseDirectly;
    private BroadcastReceiver mConnectivityIntentReceiver;
    private Context mContext;
    private volatile boolean mDataConnectionIsConnected;
    private volatile android.os.PowerManager.WakeLock mHandleAlarmWakeLock;
    private boolean mNeedSyncActiveNotification;
    private final NotificationManager mNotificationMgr;
    private final PowerManager mPowerManager;
    private BroadcastReceiver mShutdownIntentReceiver;
    private BroadcastReceiver mStorageIntentReceiver;
    private volatile boolean mStorageIsLow;
    protected SyncAdaptersCache mSyncAdapters;
    private final PendingIntent mSyncAlarmIntent;
    private final SyncHandler mSyncHandler;
    private volatile android.os.PowerManager.WakeLock mSyncManagerWakeLock;
    public SyncQueue mSyncQueue;
    private int mSyncRandomOffsetMillis;
    private SyncStorageEngine mSyncStorageEngine;
    private BroadcastReceiver mUserIntentReceiver;

    static  {
        byte byte0 = 2;
        boolean flag = ActivityManager.isLargeRAM();
        byte byte1;
        if(flag)
            byte1 = 5;
        else
            byte1 = byte0;
        if(!flag)
            byte0 = 1;
        MAX_SIMULTANEOUS_INITIALIZATION_SYNCS = SystemProperties.getInt("sync.max_init_syncs", byte1);
        MAX_SIMULTANEOUS_REGULAR_SYNCS = SystemProperties.getInt("sync.max_regular_syncs", byte0);
        LOCAL_SYNC_DELAY = SystemProperties.getLong("sync.local_sync_delay", 30000L);
        MAX_TIME_PER_SYNC = SystemProperties.getLong("sync.max_time_per_sync", 0x493e0L);
        SYNC_NOTIFICATION_DELAY = SystemProperties.getLong("sync.notification_delay", 30000L);
    }



/*
    static boolean access$002(SyncManager syncmanager, boolean flag) {
        syncmanager.mStorageIsLow = flag;
        return flag;
    }

*/





/*
    static boolean access$1702(SyncManager syncmanager, boolean flag) {
        syncmanager.mBootCompleted = flag;
        return flag;
    }

*/





















/*
    static boolean access$3402(SyncManager syncmanager, boolean flag) {
        syncmanager.mNeedSyncActiveNotification = flag;
        return flag;
    }

*/






/*
    static boolean access$402(SyncManager syncmanager, boolean flag) {
        syncmanager.mDataConnectionIsConnected = flag;
        return flag;
    }

*/





}
