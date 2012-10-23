// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.android.internal.view.menu:
//            MenuBuilder, MenuItemImpl

public interface MenuView {
    public static interface ItemView {

        public abstract MenuItemImpl getItemData();

        public abstract void initialize(MenuItemImpl menuitemimpl, int i);

        public abstract boolean prefersCondensedTitle();

        public abstract void setCheckable(boolean flag);

        public abstract void setChecked(boolean flag);

        public abstract void setEnabled(boolean flag);

        public abstract void setIcon(Drawable drawable);

        public abstract void setShortcut(boolean flag, char c);

        public abstract void setTitle(CharSequence charsequence);

        public abstract boolean showsIcon();
    }


    public abstract int getWindowAnimations();

    public abstract void initialize(MenuBuilder menubuilder);
}
