// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.view.*;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.view.menu:
//            MenuPresenter, MenuView, MenuBuilder, MenuItemImpl, 
//            SubMenuBuilder

public abstract class BaseMenuPresenter
    implements MenuPresenter {

    public BaseMenuPresenter(Context context, int i, int j) {
        mSystemContext = context;
        mSystemInflater = LayoutInflater.from(context);
        mMenuLayoutRes = i;
        mItemLayoutRes = j;
    }

    protected void addItemView(View view, int i) {
        ViewGroup viewgroup = (ViewGroup)view.getParent();
        if(viewgroup != null)
            viewgroup.removeView(view);
        ((ViewGroup)mMenuView).addView(view, i);
    }

    public abstract void bindItemView(MenuItemImpl menuitemimpl, MenuView.ItemView itemview);

    public boolean collapseItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup viewgroup) {
        return (MenuView.ItemView)mSystemInflater.inflate(mItemLayoutRes, viewgroup, false);
    }

    public boolean expandItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl) {
        return false;
    }

    protected boolean filterLeftoverView(ViewGroup viewgroup, int i) {
        viewgroup.removeViewAt(i);
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return mId;
    }

    public View getItemView(MenuItemImpl menuitemimpl, View view, ViewGroup viewgroup) {
        MenuView.ItemView itemview;
        if(view instanceof MenuView.ItemView)
            itemview = (MenuView.ItemView)view;
        else
            itemview = createItemView(viewgroup);
        bindItemView(menuitemimpl, itemview);
        return (View)itemview;
    }

    public MenuView getMenuView(ViewGroup viewgroup) {
        if(mMenuView == null) {
            mMenuView = (MenuView)mSystemInflater.inflate(mMenuLayoutRes, viewgroup, false);
            mMenuView.initialize(mMenu);
            updateMenuView(true);
        }
        return mMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menubuilder) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mMenu = menubuilder;
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
        if(mCallback != null)
            mCallback.onCloseMenu(menubuilder, flag);
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder) {
        boolean flag;
        if(mCallback != null)
            flag = mCallback.onOpenSubMenu(submenubuilder);
        else
            flag = false;
        return flag;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        mCallback = callback;
    }

    public void setId(int i) {
        mId = i;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuitemimpl) {
        return true;
    }

    public void updateMenuView(boolean flag) {
        ViewGroup viewgroup = (ViewGroup)mMenuView;
        if(viewgroup != null) {
            int i = 0;
            if(mMenu != null) {
                mMenu.flagActionItems();
                ArrayList arraylist = mMenu.getVisibleItems();
                int j = arraylist.size();
                int k = 0;
                while(k < j)  {
                    MenuItemImpl menuitemimpl = (MenuItemImpl)arraylist.get(k);
                    if(!shouldIncludeItem(i, menuitemimpl))
                        continue;
                    View view = viewgroup.getChildAt(i);
                    MenuItemImpl menuitemimpl1;
                    View view1;
                    if(view instanceof MenuView.ItemView)
                        menuitemimpl1 = ((MenuView.ItemView)view).getItemData();
                    else
                        menuitemimpl1 = null;
                    view1 = getItemView(menuitemimpl, view, viewgroup);
                    if(menuitemimpl != menuitemimpl1) {
                        view1.setPressed(false);
                        view1.jumpDrawablesToCurrentState();
                    }
                    if(view1 != view)
                        addItemView(view1, i);
                    i++;
                    k++;
                }
            }
            while(i < viewgroup.getChildCount()) 
                if(!filterLeftoverView(viewgroup, i))
                    i++;
        }
    }

    private MenuPresenter.Callback mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected MenuView mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;
}
