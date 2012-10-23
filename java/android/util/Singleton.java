// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


public abstract class Singleton {

    public Singleton() {
    }

    protected abstract Object create();

    public final Object get() {
        this;
        JVM INSTR monitorenter ;
        if(mInstance == null)
            mInstance = create();
        Object obj = mInstance;
        return obj;
    }

    private Object mInstance;
}
