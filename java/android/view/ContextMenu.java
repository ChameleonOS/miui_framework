// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.drawable.Drawable;

// Referenced classes of package android.view:
//            Menu, View

public interface ContextMenu
    extends Menu {
    public static interface ContextMenuInfo {
    }


    public abstract void clearHeader();

    public abstract ContextMenu setHeaderIcon(int i);

    public abstract ContextMenu setHeaderIcon(Drawable drawable);

    public abstract ContextMenu setHeaderTitle(int i);

    public abstract ContextMenu setHeaderTitle(CharSequence charsequence);

    public abstract ContextMenu setHeaderView(View view);
}
