// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import android.os.Message;

public interface IState {

    public abstract void enter();

    public abstract void exit();

    public abstract String getName();

    public abstract boolean processMessage(Message message);

    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED;
}
