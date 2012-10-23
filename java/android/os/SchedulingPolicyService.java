// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Binder, Process

public class SchedulingPolicyService extends ISchedulingPolicyService.Stub {

    public SchedulingPolicyService() {
    }

    public int requestPriority(int i, int j, int k) {
        byte byte0 = -1;
        if(Binder.getCallingUid() == 1013 && k >= 1 && k <= 2 && Process.getThreadGroupLeader(j) == i) goto _L2; else goto _L1
_L1:
        return byte0;
_L2:
        byte byte1;
        if(Binder.getCallingPid() != i)
            break MISSING_BLOCK_LABEL_62;
        byte1 = 4;
_L3:
        Process.setThreadGroup(j, byte1);
        Process.setThreadScheduler(j, 1, k);
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
        byte1 = 3;
          goto _L3
        RuntimeException runtimeexception;
        runtimeexception;
        if(true) goto _L1; else goto _L4
_L4:
    }

    private static final int PRIORITY_MAX = 2;
    private static final int PRIORITY_MIN = 1;
    private static final String TAG = "SchedulingPolicyService";
}
