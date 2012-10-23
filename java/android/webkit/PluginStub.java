// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.view.View;

public interface PluginStub {

    public abstract View getEmbeddedView(int i, Context context);

    public abstract View getFullScreenView(int i, Context context);
}
