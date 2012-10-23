// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.view:
//            ActionProvider, View, SubMenu

public interface MenuItem {
    public static interface OnActionExpandListener {

        public abstract boolean onMenuItemActionCollapse(MenuItem menuitem);

        public abstract boolean onMenuItemActionExpand(MenuItem menuitem);
    }

    public static interface OnMenuItemClickListener {

        public abstract boolean onMenuItemClick(MenuItem menuitem);
    }


    public abstract boolean collapseActionView();

    public abstract boolean expandActionView();

    public abstract ActionProvider getActionProvider();

    public abstract View getActionView();

    public abstract char getAlphabeticShortcut();

    public abstract int getGroupId();

    public abstract Drawable getIcon();

    public abstract Intent getIntent();

    public abstract int getItemId();

    public abstract ContextMenu.ContextMenuInfo getMenuInfo();

    public abstract char getNumericShortcut();

    public abstract int getOrder();

    public abstract SubMenu getSubMenu();

    public abstract CharSequence getTitle();

    public abstract CharSequence getTitleCondensed();

    public abstract boolean hasSubMenu();

    public abstract boolean isActionViewExpanded();

    public abstract boolean isCheckable();

    public abstract boolean isChecked();

    public abstract boolean isEnabled();

    public abstract boolean isVisible();

    public abstract MenuItem setActionProvider(ActionProvider actionprovider);

    public abstract MenuItem setActionView(int i);

    public abstract MenuItem setActionView(View view);

    public abstract MenuItem setAlphabeticShortcut(char c);

    public abstract MenuItem setCheckable(boolean flag);

    public abstract MenuItem setChecked(boolean flag);

    public abstract MenuItem setEnabled(boolean flag);

    public abstract MenuItem setIcon(int i);

    public abstract MenuItem setIcon(Drawable drawable);

    public abstract MenuItem setIntent(Intent intent);

    public abstract MenuItem setNumericShortcut(char c);

    public abstract MenuItem setOnActionExpandListener(OnActionExpandListener onactionexpandlistener);

    public abstract MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onmenuitemclicklistener);

    public abstract MenuItem setShortcut(char c, char c1);

    public abstract void setShowAsAction(int i);

    public abstract MenuItem setShowAsActionFlags(int i);

    public abstract MenuItem setTitle(int i);

    public abstract MenuItem setTitle(CharSequence charsequence);

    public abstract MenuItem setTitleCondensed(CharSequence charsequence);

    public abstract MenuItem setVisible(boolean flag);

    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
}
