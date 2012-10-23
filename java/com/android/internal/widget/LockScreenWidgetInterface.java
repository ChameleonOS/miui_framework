// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;


// Referenced classes of package com.android.internal.widget:
//            LockScreenWidgetCallback

public interface LockScreenWidgetInterface {

    public abstract boolean providesClock();

    public abstract void setCallback(LockScreenWidgetCallback lockscreenwidgetcallback);
}
