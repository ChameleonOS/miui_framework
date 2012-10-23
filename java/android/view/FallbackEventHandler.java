// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;


// Referenced classes of package android.view:
//            KeyEvent, View

public interface FallbackEventHandler {

    public abstract boolean dispatchKeyEvent(KeyEvent keyevent);

    public abstract void preDispatchKeyEvent(KeyEvent keyevent);

    public abstract void setView(View view);
}
