// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.*;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.view.menu:
//            BaseMenuPresenter, IconMenuItemView, IconMenuView, MenuItemImpl, 
//            SubMenuBuilder, MenuDialogHelper, MenuBuilder

public class IconMenuPresenter extends BaseMenuPresenter {
    class SubMenuPresenterCallback
        implements MenuPresenter.Callback {

        public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
            mOpenSubMenuId = 0;
            if(mOpenSubMenu != null) {
                mOpenSubMenu.dismiss();
                mOpenSubMenu = null;
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menubuilder) {
            if(menubuilder != null)
                mOpenSubMenuId = ((SubMenuBuilder)menubuilder).getItem().getItemId();
            return false;
        }

        final IconMenuPresenter this$0;

        SubMenuPresenterCallback() {
            this$0 = IconMenuPresenter.this;
            super();
        }
    }


    public IconMenuPresenter(Context context) {
        super(new ContextThemeWrapper(context, 0x10302ee), 0x1090046, 0x1090045);
        mMaxItems = -1;
        mSubMenuPresenterCallback = new SubMenuPresenterCallback();
    }

    protected void addItemView(View view, int i) {
        IconMenuItemView iconmenuitemview = (IconMenuItemView)view;
        IconMenuView iconmenuview = (IconMenuView)super.mMenuView;
        iconmenuitemview.setIconMenuView(iconmenuview);
        iconmenuitemview.setItemInvoker(iconmenuview);
        iconmenuitemview.setBackgroundDrawable(iconmenuview.getItemBackgroundDrawable());
        super.addItemView(view, i);
    }

    public void bindItemView(MenuItemImpl menuitemimpl, MenuView.ItemView itemview) {
        IconMenuItemView iconmenuitemview = (IconMenuItemView)itemview;
        iconmenuitemview.setItemData(menuitemimpl);
        iconmenuitemview.initialize(menuitemimpl.getTitleForItemView(iconmenuitemview), menuitemimpl.getIcon());
        int i;
        if(menuitemimpl.isVisible())
            i = 0;
        else
            i = 8;
        iconmenuitemview.setVisibility(i);
        iconmenuitemview.setEnabled(iconmenuitemview.isEnabled());
        iconmenuitemview.setLayoutParams(iconmenuitemview.getTextAppropriateLayoutParams());
    }

    protected boolean filterLeftoverView(ViewGroup viewgroup, int i) {
        boolean flag;
        if(viewgroup.getChildAt(i) != mMoreView)
            flag = super.filterLeftoverView(viewgroup, i);
        else
            flag = false;
        return flag;
    }

    public int getNumActualItemsShown() {
        return ((IconMenuView)super.mMenuView).getNumActualItemsShown();
    }

    public void initForMenu(Context context, MenuBuilder menubuilder) {
        super.initForMenu(context, menubuilder);
        mMaxItems = -1;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle)parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if(super.mMenuView != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Parcelable) (obj));
_L2:
        obj = new Bundle();
        saveHierarchyState(((Bundle) (obj)));
        if(mOpenSubMenuId > 0)
            ((Bundle) (obj)).putInt("android:menu:icon:submenu", mOpenSubMenuId);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder) {
        boolean flag;
        if(!submenubuilder.hasVisibleItems()) {
            flag = false;
        } else {
            MenuDialogHelper menudialoghelper = new MenuDialogHelper(submenubuilder);
            menudialoghelper.setPresenterCallback(mSubMenuPresenterCallback);
            menudialoghelper.show(null);
            mOpenSubMenu = menudialoghelper;
            mOpenSubMenuId = submenubuilder.getItem().getItemId();
            super.onSubMenuSelected(submenubuilder);
            flag = true;
        }
        return flag;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray sparsearray = bundle.getSparseParcelableArray("android:menu:icon");
        if(sparsearray != null)
            ((View)super.mMenuView).restoreHierarchyState(sparsearray);
        int i = bundle.getInt("android:menu:icon:submenu", 0);
        if(i > 0 && super.mMenu != null) {
            MenuItem menuitem = super.mMenu.findItem(i);
            if(menuitem != null)
                onSubMenuSelected((SubMenuBuilder)menuitem.getSubMenu());
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparsearray = new SparseArray();
        if(super.mMenuView != null)
            ((View)super.mMenuView).saveHierarchyState(sparsearray);
        bundle.putSparseParcelableArray("android:menu:icon", sparsearray);
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuitemimpl) {
        boolean flag = true;
        boolean flag1;
        if(super.mMenu.getNonActionItems().size() == mMaxItems && i < mMaxItems || i < -1 + mMaxItems)
            flag1 = flag;
        else
            flag1 = false;
        if(!flag1 || menuitemimpl.isActionButton())
            flag = false;
        return flag;
    }

    public void updateMenuView(boolean flag) {
        IconMenuView iconmenuview = (IconMenuView)super.mMenuView;
        if(mMaxItems < 0)
            mMaxItems = iconmenuview.getMaxItems();
        ArrayList arraylist = super.mMenu.getNonActionItems();
        boolean flag1;
        int i;
        if(arraylist.size() > mMaxItems)
            flag1 = true;
        else
            flag1 = false;
        super.updateMenuView(flag);
        if(flag1 && (mMoreView == null || mMoreView.getParent() != iconmenuview)) {
            if(mMoreView == null) {
                mMoreView = iconmenuview.createMoreItemView();
                mMoreView.setBackgroundDrawable(iconmenuview.getItemBackgroundDrawable());
            }
            iconmenuview.addView(mMoreView);
        } else
        if(!flag1 && mMoreView != null)
            iconmenuview.removeView(mMoreView);
        if(flag1)
            i = -1 + mMaxItems;
        else
            i = arraylist.size();
        iconmenuview.setNumActualItemsShown(i);
    }

    private static final String OPEN_SUBMENU_KEY = "android:menu:icon:submenu";
    private static final String VIEWS_TAG = "android:menu:icon";
    private int mMaxItems;
    private IconMenuItemView mMoreView;
    MenuDialogHelper mOpenSubMenu;
    int mOpenSubMenuId;
    SubMenuPresenterCallback mSubMenuPresenterCallback;
}
