// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


public class ConditionVariable {

    public ConditionVariable() {
        mCondition = false;
    }

    public ConditionVariable(boolean flag) {
        mCondition = flag;
    }

    public void block() {
        this;
        JVM INSTR monitorenter ;
_L3:
        boolean flag = mCondition;
        if(flag) goto _L2; else goto _L1
_L1:
        Exception exception;
        try {
            wait();
        }
        catch(InterruptedException interruptedexception) { }
        finally {
            this;
        }
        if(true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

    public boolean block(long l) {
        if(l == 0L)
            break MISSING_BLOCK_LABEL_76;
        this;
        JVM INSTR monitorenter ;
        long l1;
        long l2;
        l1 = System.currentTimeMillis();
        l2 = l1 + l;
_L1:
        boolean flag1 = mCondition;
        boolean flag;
label0:
        {
            if(flag1 || l1 >= l2)
                break label0;
            long l3 = l2 - l1;
            Exception exception;
            try {
                wait(l3);
            }
            catch(InterruptedException interruptedexception) { }
            finally {
                this;
            }
            l1 = System.currentTimeMillis();
        }
          goto _L1
        flag = mCondition;
        if(true)
            break MISSING_BLOCK_LABEL_90;
        JVM INSTR monitorexit ;
        throw exception;
        block();
        flag = true;
        return flag;
    }

    public void close() {
        this;
        JVM INSTR monitorenter ;
        mCondition = false;
        return;
    }

    public void open() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mCondition;
        mCondition = true;
        if(!flag)
            notifyAll();
        return;
    }

    private volatile boolean mCondition;
}
