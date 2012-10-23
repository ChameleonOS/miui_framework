// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.view.*;
import com.android.internal.view.menu.*;

public class PopupMenu
    implements com.android.internal.view.menu.MenuBuilder.Callback, com.android.internal.view.menu.MenuPresenter.Callback {
    public static interface OnMenuItemClickListener {

        public abstract boolean onMenuItemClick(MenuItem menuitem);
    }

    public static interface OnDismissListener {

        public abstract void onDismiss(PopupMenu popupmenu);
    }


    public PopupMenu(Context context, View view) {
        mContext = context;
        mMenu = new MenuBuilder(context);
        mMenu.setCallback(this);
        mAnchor = view;
        mPopup = new MenuPopupHelper(context, mMenu, view);
        mPopup.setCallback(this);
    }

    public void dismiss() {
        mPopup.dismiss();
    }

    public Menu getMenu() {
        return mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new MenuInflater(mContext);
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, mMenu);
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
        if(mDismissListener != null)
            mDismissListener.onDismiss(this);
    }

    public void onCloseSubMenu(SubMenuBuilder submenubuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem) {
        boolean flag;
        if(mMenuItemClickListener != null)
            flag = mMenuItemClickListener.onMenuItemClick(menuitem);
        else
            flag = false;
        return flag;
    }

    public void onMenuModeChange(MenuBuilder menubuilder) {
    }

    public boolean onOpenSubMenu(MenuBuilder menubuilder) {
        boolean flag = true;
        if(menubuilder != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(menubuilder.hasVisibleItems())
            (new MenuPopupHelper(mContext, menubuilder, mAnchor)).show();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setOnDismissListener(OnDismissListener ondismisslistener) {
        mDismissListener = ondismisslistener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onmenuitemclicklistener) {
        mMenuItemClickListener = onmenuitemclicklistener;
    }

    public void show() {
        mPopup.show();
    }

    private View mAnchor;
    private Context mContext;
    private OnDismissListener mDismissListener;
    private MenuBuilder mMenu;
    private OnMenuItemClickListener mMenuItemClickListener;
    private MenuPopupHelper mPopup;
}
