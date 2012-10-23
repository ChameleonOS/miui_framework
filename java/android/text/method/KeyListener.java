// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;

public interface KeyListener {

    public abstract void clearMetaKeyState(View view, Editable editable, int i);

    public abstract int getInputType();

    public abstract boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyevent);

    public abstract boolean onKeyOther(View view, Editable editable, KeyEvent keyevent);

    public abstract boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyevent);
}
