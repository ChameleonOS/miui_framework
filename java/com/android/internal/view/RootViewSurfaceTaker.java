// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;


public interface RootViewSurfaceTaker {

    public abstract void setSurfaceFormat(int i);

    public abstract void setSurfaceKeepScreenOn(boolean flag);

    public abstract void setSurfaceType(int i);

    public abstract android.view.InputQueue.Callback willYouTakeTheInputQueue();

    public abstract android.view.SurfaceHolder.Callback2 willYouTakeTheSurface();
}
