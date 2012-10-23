// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            Pool, Poolable, PoolableManager, Log

class FinitePool
    implements Pool {

    FinitePool(PoolableManager poolablemanager) {
        mManager = poolablemanager;
        mLimit = 0;
        mInfinite = true;
    }

    FinitePool(PoolableManager poolablemanager, int i) {
        if(i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        } else {
            mManager = poolablemanager;
            mLimit = i;
            mInfinite = false;
            return;
        }
    }

    public Poolable acquire() {
        Poolable poolable;
        if(mRoot != null) {
            poolable = mRoot;
            mRoot = (Poolable)poolable.getNextPoolable();
            mPoolCount = -1 + mPoolCount;
        } else {
            poolable = mManager.newInstance();
        }
        if(poolable != null) {
            poolable.setNextPoolable(null);
            poolable.setPooled(false);
            mManager.onAcquired(poolable);
        }
        return poolable;
    }

    public void release(Poolable poolable) {
        if(!poolable.isPooled()) {
            if(mInfinite || mPoolCount < mLimit) {
                mPoolCount = 1 + mPoolCount;
                poolable.setNextPoolable(mRoot);
                poolable.setPooled(true);
                mRoot = poolable;
            }
            mManager.onReleased(poolable);
        } else {
            Log.w("FinitePool", (new StringBuilder()).append("Element is already in pool: ").append(poolable).toString());
        }
    }

    private static final String LOG_TAG = "FinitePool";
    private final boolean mInfinite;
    private final int mLimit;
    private final PoolableManager mManager;
    private int mPoolCount;
    private Poolable mRoot;
}
