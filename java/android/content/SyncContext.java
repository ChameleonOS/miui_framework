// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.*;

// Referenced classes of package android.content:
//            ISyncContext, SyncResult

public class SyncContext {

    public SyncContext(ISyncContext isynccontext) {
        mSyncContext = isynccontext;
        mLastHeartbeatSendTime = 0L;
    }

    private void updateHeartbeat() {
        long l = SystemClock.elapsedRealtime();
        if(l >= 1000L + mLastHeartbeatSendTime) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try {
            mLastHeartbeatSendTime = l;
            if(mSyncContext != null)
                mSyncContext.sendHeartbeat();
        }
        catch(RemoteException remoteexception) { }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public IBinder getSyncContextBinder() {
        IBinder ibinder;
        if(mSyncContext == null)
            ibinder = null;
        else
            ibinder = mSyncContext.asBinder();
        return ibinder;
    }

    public void onFinished(SyncResult syncresult) {
        if(mSyncContext != null)
            mSyncContext.onFinished(syncresult);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setStatusText(String s) {
        updateHeartbeat();
    }

    private static final long HEARTBEAT_SEND_INTERVAL_IN_MS = 1000L;
    private long mLastHeartbeatSendTime;
    private ISyncContext mSyncContext;
}
