// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.drawable.Drawable;

// Referenced classes of package android.view:
//            Menu, MenuItem, View

public interface SubMenu
    extends Menu {

    public abstract void clearHeader();

    public abstract MenuItem getItem();

    public abstract SubMenu setHeaderIcon(int i);

    public abstract SubMenu setHeaderIcon(Drawable drawable);

    public abstract SubMenu setHeaderTitle(int i);

    public abstract SubMenu setHeaderTitle(CharSequence charsequence);

    public abstract SubMenu setHeaderView(View view);

    public abstract SubMenu setIcon(int i);

    public abstract SubMenu setIcon(Drawable drawable);
}
