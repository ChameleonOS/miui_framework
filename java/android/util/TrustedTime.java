// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


public interface TrustedTime {

    public abstract long currentTimeMillis();

    public abstract boolean forceRefresh();

    public abstract long getCacheAge();

    public abstract long getCacheCertainty();

    public abstract boolean hasCache();
}
