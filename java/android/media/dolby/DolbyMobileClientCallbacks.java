// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.dolby;


public interface DolbyMobileClientCallbacks {

    public abstract void onEffectOnChanged(boolean flag);

    public abstract void onPresetChanged(int i, int j);

    public abstract void onServiceConnected();

    public abstract void onServiceDisconnected();
}
