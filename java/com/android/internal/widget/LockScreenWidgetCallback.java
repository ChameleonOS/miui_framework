// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.view.View;

public interface LockScreenWidgetCallback {

    public abstract boolean isVisible(View view);

    public abstract void requestHide(View view);

    public abstract void requestShow(View view);

    public abstract void userActivity(View view);
}
