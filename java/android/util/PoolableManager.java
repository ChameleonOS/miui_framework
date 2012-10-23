// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            Poolable

public interface PoolableManager {

    public abstract Poolable newInstance();

    public abstract void onAcquired(Poolable poolable);

    public abstract void onReleased(Poolable poolable);
}
