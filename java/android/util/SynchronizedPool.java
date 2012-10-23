// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            Pool, Poolable

class SynchronizedPool
    implements Pool {

    public SynchronizedPool(Pool pool) {
        mPool = pool;
        mLock = this;
    }

    public SynchronizedPool(Pool pool, Object obj) {
        mPool = pool;
        mLock = obj;
    }

    public Poolable acquire() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Poolable poolable = mPool.acquire();
        return poolable;
    }

    public void release(Poolable poolable) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        mPool.release(poolable);
        return;
    }

    private final Object mLock;
    private final Pool mPool;
}
