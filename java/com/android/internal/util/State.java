// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import android.os.Message;

// Referenced classes of package com.android.internal.util:
//            IState

public class State
    implements IState {

    protected State() {
    }

    public void enter() {
    }

    public void exit() {
    }

    public String getName() {
        String s = getClass().getName();
        return s.substring(1 + s.lastIndexOf('$'));
    }

    public boolean processMessage(Message message) {
        return false;
    }
}
