// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;


// Referenced classes of package android.view:
//            View

public interface ViewManager {

    public abstract void addView(View view, ViewGroup.LayoutParams layoutparams);

    public abstract void removeView(View view);

    public abstract void updateViewLayout(View view, ViewGroup.LayoutParams layoutparams);
}
