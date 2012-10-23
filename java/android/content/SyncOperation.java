// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package android.content:
//            SyncStorageEngine

public class SyncOperation
    implements Comparable {

    public SyncOperation(Account account1, int i, int j, String s, Bundle bundle, long l, 
            long l1, long l2, boolean flag) {
        account = account1;
        userId = i;
        syncSource = j;
        authority = s;
        allowParallelSyncs = flag;
        extras = new Bundle(bundle);
        removeFalseExtra("upload");
        removeFalseExtra("force");
        removeFalseExtra("ignore_settings");
        removeFalseExtra("ignore_backoff");
        removeFalseExtra("do_not_retry");
        removeFalseExtra("discard_deletions");
        removeFalseExtra("expedited");
        removeFalseExtra("deletions_override");
        delayUntil = l2;
        backoff = Long.valueOf(l1);
        long l3 = SystemClock.elapsedRealtime();
        if(l < 0L) {
            expedited = true;
            earliestRunTime = l3;
        } else {
            expedited = false;
            earliestRunTime = l3 + l;
        }
        updateEffectiveRunTime();
        key = toKey();
    }

    SyncOperation(SyncOperation syncoperation) {
        account = syncoperation.account;
        userId = syncoperation.userId;
        syncSource = syncoperation.syncSource;
        authority = syncoperation.authority;
        extras = new Bundle(syncoperation.extras);
        expedited = syncoperation.expedited;
        earliestRunTime = SystemClock.elapsedRealtime();
        backoff = syncoperation.backoff;
        delayUntil = syncoperation.delayUntil;
        allowParallelSyncs = syncoperation.allowParallelSyncs;
        updateEffectiveRunTime();
        key = toKey();
    }

    public static void extrasToStringBuilder(Bundle bundle, StringBuilder stringbuilder) {
        stringbuilder.append("[");
        String s;
        for(Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); stringbuilder.append(s).append("=").append(bundle.get(s)).append(" "))
            s = (String)iterator.next();

        stringbuilder.append("]");
    }

    private void removeFalseExtra(String s) {
        if(!extras.getBoolean(s, false))
            extras.remove(s);
    }

    private String toKey() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("authority: ").append(authority);
        stringbuilder.append((new StringBuilder()).append(" account {name=").append(account.name).append(", user=").append(userId).append(", type=").append(account.type).append("}").toString());
        stringbuilder.append(" extras: ");
        extrasToStringBuilder(extras, stringbuilder);
        return stringbuilder.toString();
    }

    public int compareTo(Object obj) {
        byte byte0;
        SyncOperation syncoperation;
        byte0 = -1;
        syncoperation = (SyncOperation)obj;
        if(expedited == syncoperation.expedited) goto _L2; else goto _L1
_L1:
        if(!expedited)
            byte0 = 1;
_L4:
        return byte0;
_L2:
        if(effectiveRunTime == syncoperation.effectiveRunTime)
            byte0 = 0;
        else
        if(effectiveRunTime >= syncoperation.effectiveRunTime)
            byte0 = 1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String dump(boolean flag) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(account.name);
        stringbuilder.append((new StringBuilder()).append(" (").append(account.type).append(")").toString());
        stringbuilder.append((new StringBuilder()).append(", ").append(authority).toString());
        stringbuilder.append(", ");
        stringbuilder.append(SyncStorageEngine.SOURCES[syncSource]);
        stringbuilder.append((new StringBuilder()).append(", earliestRunTime ").append(earliestRunTime).toString());
        if(expedited)
            stringbuilder.append(", EXPEDITED");
        if(!flag && !extras.keySet().isEmpty()) {
            stringbuilder.append("\n    ");
            extrasToStringBuilder(extras, stringbuilder);
        }
        return stringbuilder.toString();
    }

    public boolean ignoreBackoff() {
        return extras.getBoolean("ignore_backoff", false);
    }

    public boolean isExpedited() {
        return extras.getBoolean("expedited", false);
    }

    public boolean isInitialization() {
        return extras.getBoolean("initialize", false);
    }

    public String toString() {
        return dump(true);
    }

    public void updateEffectiveRunTime() {
        long l;
        if(ignoreBackoff())
            l = earliestRunTime;
        else
            l = Math.max(Math.max(earliestRunTime, delayUntil), backoff.longValue());
        effectiveRunTime = l;
    }

    public final Account account;
    public final boolean allowParallelSyncs;
    public String authority;
    public Long backoff;
    public long delayUntil;
    public long earliestRunTime;
    public long effectiveRunTime;
    public boolean expedited;
    public Bundle extras;
    public final String key;
    public SyncStorageEngine.PendingOperation pendingOperation;
    public int syncSource;
    public final int userId;
}
