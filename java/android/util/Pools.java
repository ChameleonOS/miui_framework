// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            FinitePool, SynchronizedPool, PoolableManager, Pool

public class Pools {

    private Pools() {
    }

    public static Pool finitePool(PoolableManager poolablemanager, int i) {
        return new FinitePool(poolablemanager, i);
    }

    public static Pool simplePool(PoolableManager poolablemanager) {
        return new FinitePool(poolablemanager);
    }

    public static Pool synchronizedPool(Pool pool) {
        return new SynchronizedPool(pool);
    }

    public static Pool synchronizedPool(Pool pool, Object obj) {
        return new SynchronizedPool(pool, obj);
    }
}
