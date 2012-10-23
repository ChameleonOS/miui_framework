// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


public interface Poolable {

    public abstract Object getNextPoolable();

    public abstract boolean isPooled();

    public abstract void setNextPoolable(Object obj);

    public abstract void setPooled(boolean flag);
}
