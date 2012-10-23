// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.policy;

import android.content.Context;
import android.view.*;

public interface IPolicy {

    public abstract FallbackEventHandler makeNewFallbackEventHandler(Context context);

    public abstract LayoutInflater makeNewLayoutInflater(Context context);

    public abstract Window makeNewWindow(Context context);

    public abstract WindowManagerPolicy makeNewWindowManager();
}
