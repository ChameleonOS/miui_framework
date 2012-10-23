// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.*;

// Referenced classes of package com.android.internal.view.menu:
//            MenuBuilder, MenuItemImpl

public class SubMenuBuilder extends MenuBuilder
    implements SubMenu {

    public SubMenuBuilder(Context context, MenuBuilder menubuilder, MenuItemImpl menuitemimpl) {
        super(context);
        mParentMenu = menubuilder;
        mItem = menuitemimpl;
    }

    public boolean collapseItemActionView(MenuItemImpl menuitemimpl) {
        return mParentMenu.collapseItemActionView(menuitemimpl);
    }

    boolean dispatchMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem) {
        boolean flag;
        if(super.dispatchMenuItemSelected(menubuilder, menuitem) || mParentMenu.dispatchMenuItemSelected(menubuilder, menuitem))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean expandItemActionView(MenuItemImpl menuitemimpl) {
        return mParentMenu.expandItemActionView(menuitemimpl);
    }

    public String getActionViewStatesKey() {
        int i;
        String s;
        if(mItem != null)
            i = mItem.getItemId();
        else
            i = 0;
        if(i == 0)
            s = null;
        else
            s = (new StringBuilder()).append(super.getActionViewStatesKey()).append(":").append(i).toString();
        return s;
    }

    public MenuItem getItem() {
        return mItem;
    }

    public Menu getParentMenu() {
        return mParentMenu;
    }

    public MenuBuilder getRootMenu() {
        return mParentMenu;
    }

    public boolean isQwertyMode() {
        return mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return mParentMenu.isShortcutsVisible();
    }

    public void setCallback(MenuBuilder.Callback callback) {
        mParentMenu.setCallback(callback);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu)super.setHeaderIconInt(i);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu)super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu)super.setHeaderTitleInt(i);
    }

    public SubMenu setHeaderTitle(CharSequence charsequence) {
        return (SubMenu)super.setHeaderTitleInt(charsequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu)super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(int i) {
        mItem.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        mItem.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean flag) {
        mParentMenu.setQwertyMode(flag);
    }

    public void setShortcutsVisible(boolean flag) {
        mParentMenu.setShortcutsVisible(flag);
    }

    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;
}
