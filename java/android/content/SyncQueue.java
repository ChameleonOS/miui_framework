// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.collect.Maps;
import java.util.*;

// Referenced classes of package android.content:
//            SyncStorageEngine, SyncAdapterType, SyncAdaptersCache, SyncOperation

public class SyncQueue {

    public SyncQueue(SyncStorageEngine syncstorageengine, SyncAdaptersCache syncadapterscache) {
        mSyncStorageEngine = syncstorageengine;
        ArrayList arraylist = mSyncStorageEngine.getPendingOperations();
        int i = arraylist.size();
        int j = 0;
        while(j < i)  {
            SyncStorageEngine.PendingOperation pendingoperation = (SyncStorageEngine.PendingOperation)arraylist.get(j);
            Pair pair = syncstorageengine.getBackoff(pendingoperation.account, pendingoperation.userId, pendingoperation.authority);
            android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo = syncadapterscache.getServiceInfo(SyncAdapterType.newKey(pendingoperation.authority, pendingoperation.account.type));
            if(serviceinfo != null) {
                Account account = pendingoperation.account;
                int k = pendingoperation.userId;
                int l = pendingoperation.syncSource;
                String s = pendingoperation.authority;
                android.os.Bundle bundle = pendingoperation.extras;
                long l1;
                SyncOperation syncoperation;
                if(pair != null)
                    l1 = ((Long)pair.first).longValue();
                else
                    l1 = 0L;
                syncoperation = new SyncOperation(account, k, l, s, bundle, 0L, l1, syncstorageengine.getDelayUntilTime(pendingoperation.account, pendingoperation.userId, pendingoperation.authority), ((SyncAdapterType)serviceinfo.type).allowParallelSyncs());
                syncoperation.expedited = pendingoperation.expedited;
                syncoperation.pendingOperation = pendingoperation;
                add(syncoperation, pendingoperation);
            }
            j++;
        }
    }

    private boolean add(SyncOperation syncoperation, SyncStorageEngine.PendingOperation pendingoperation) {
        String s;
        SyncOperation syncoperation1;
        s = syncoperation.key;
        syncoperation1 = (SyncOperation)mOperationsMap.get(s);
        if(syncoperation1 == null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
        if(syncoperation1.expedited != syncoperation.expedited) goto _L4; else goto _L3
_L3:
        long l = Math.min(syncoperation1.earliestRunTime, syncoperation.earliestRunTime);
        if(syncoperation1.earliestRunTime != l) {
            syncoperation1.earliestRunTime = l;
            flag = true;
        }
_L6:
        return flag;
_L4:
        if(syncoperation.expedited) {
            syncoperation1.expedited = true;
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        syncoperation.pendingOperation = pendingoperation;
        if(syncoperation.pendingOperation == null) {
            SyncStorageEngine.PendingOperation pendingoperation1 = new SyncStorageEngine.PendingOperation(syncoperation.account, syncoperation.userId, syncoperation.syncSource, syncoperation.authority, syncoperation.extras, syncoperation.expedited);
            SyncStorageEngine.PendingOperation pendingoperation2 = mSyncStorageEngine.insertIntoPending(pendingoperation1);
            if(pendingoperation2 == null)
                throw new IllegalStateException((new StringBuilder()).append("error adding pending sync operation ").append(syncoperation).toString());
            syncoperation.pendingOperation = pendingoperation2;
        }
        mOperationsMap.put(s, syncoperation);
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean add(SyncOperation syncoperation) {
        return add(syncoperation, null);
    }

    public void dump(StringBuilder stringbuilder) {
        long l = SystemClock.elapsedRealtime();
        stringbuilder.append("SyncQueue: ").append(mOperationsMap.size()).append(" operation(s)\n");
        Iterator iterator = mOperationsMap.values().iterator();
        while(iterator.hasNext())  {
            SyncOperation syncoperation = (SyncOperation)iterator.next();
            stringbuilder.append("  ");
            if(syncoperation.effectiveRunTime <= l)
                stringbuilder.append("READY");
            else
                stringbuilder.append(DateUtils.formatElapsedTime((syncoperation.effectiveRunTime - l) / 1000L));
            stringbuilder.append(" - ");
            stringbuilder.append(syncoperation.dump(false)).append("\n");
        }
    }

    public void onBackoffChanged(Account account, int i, String s, long l) {
        Iterator iterator = mOperationsMap.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            SyncOperation syncoperation = (SyncOperation)iterator.next();
            if(syncoperation.account.equals(account) && syncoperation.authority.equals(s) && syncoperation.userId == i) {
                syncoperation.backoff = Long.valueOf(l);
                syncoperation.updateEffectiveRunTime();
            }
        } while(true);
    }

    public void onDelayUntilTimeChanged(Account account, String s, long l) {
        Iterator iterator = mOperationsMap.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            SyncOperation syncoperation = (SyncOperation)iterator.next();
            if(syncoperation.account.equals(account) && syncoperation.authority.equals(s)) {
                syncoperation.delayUntil = l;
                syncoperation.updateEffectiveRunTime();
            }
        } while(true);
    }

    public void remove(Account account, int i, String s) {
        Iterator iterator = mOperationsMap.entrySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            SyncOperation syncoperation = (SyncOperation)((java.util.Map.Entry)iterator.next()).getValue();
            if((account == null || syncoperation.account.equals(account)) && (s == null || syncoperation.authority.equals(s)) && i == syncoperation.userId) {
                iterator.remove();
                if(!mSyncStorageEngine.deleteFromPending(syncoperation.pendingOperation)) {
                    String s1 = (new StringBuilder()).append("unable to find pending row for ").append(syncoperation).toString();
                    Log.e("SyncManager", s1, new IllegalStateException(s1));
                }
            }
        } while(true);
    }

    public void remove(SyncOperation syncoperation) {
        SyncOperation syncoperation1;
        syncoperation1 = (SyncOperation)mOperationsMap.remove(syncoperation.key);
        break MISSING_BLOCK_LABEL_15;
        if(syncoperation1 != null && !mSyncStorageEngine.deleteFromPending(syncoperation1.pendingOperation)) {
            String s = (new StringBuilder()).append("unable to find pending row for ").append(syncoperation1).toString();
            Log.e("SyncManager", s, new IllegalStateException(s));
        }
        return;
    }

    public void removeUser(int i) {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mOperationsMap.values().iterator();
        do {
            if(!iterator.hasNext())
                break;
            SyncOperation syncoperation = (SyncOperation)iterator.next();
            if(syncoperation.userId == i)
                arraylist.add(syncoperation);
        } while(true);
        for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); remove((SyncOperation)iterator1.next()));
    }

    private static final String TAG = "SyncManager";
    public final HashMap mOperationsMap = Maps.newHashMap();
    private SyncStorageEngine mSyncStorageEngine;
}
