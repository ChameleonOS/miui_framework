// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;


// Referenced classes of package android.widget:
//            Adapter

public interface ListAdapter
    extends Adapter {

    public abstract boolean areAllItemsEnabled();

    public abstract boolean isEnabled(int i);
}
