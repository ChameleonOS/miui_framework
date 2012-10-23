// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.content.Context;
import android.view.*;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;
import com.android.internal.view.menu.SubMenuBuilder;
import com.android.internal.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class StandaloneActionMode extends ActionMode
    implements com.android.internal.view.menu.MenuBuilder.Callback {

    public StandaloneActionMode(Context context, ActionBarContextView actionbarcontextview, android.view.ActionMode.Callback callback, boolean flag) {
        mContext = context;
        mContextView = actionbarcontextview;
        mCallback = callback;
        mMenu = (new MenuBuilder(context)).setDefaultShowAsAction(1);
        mMenu.setCallback(this);
        mFocusable = flag;
    }

    public void finish() {
        if(!mFinished) {
            mFinished = true;
            mContextView.sendAccessibilityEvent(32);
            mCallback.onDestroyActionMode(this);
        }
    }

    public View getCustomView() {
        View view;
        if(mCustomView != null)
            view = (View)mCustomView.get();
        else
            view = null;
        return view;
    }

    public Menu getMenu() {
        return mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new MenuInflater(mContext);
    }

    public CharSequence getSubtitle() {
        return mContextView.getSubtitle();
    }

    public CharSequence getTitle() {
        return mContextView.getTitle();
    }

    public void invalidate() {
        mCallback.onPrepareActionMode(this, mMenu);
    }

    public boolean isTitleOptional() {
        return mContextView.isTitleOptional();
    }

    public boolean isUiFocusable() {
        return mFocusable;
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
    }

    public void onCloseSubMenu(SubMenuBuilder submenubuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem) {
        return mCallback.onActionItemClicked(this, menuitem);
    }

    public void onMenuModeChange(MenuBuilder menubuilder) {
        invalidate();
        mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder) {
        if(submenubuilder.hasVisibleItems())
            (new MenuPopupHelper(mContext, submenubuilder)).show();
        return true;
    }

    public void setCustomView(View view) {
        mContextView.setCustomView(view);
        WeakReference weakreference;
        if(view != null)
            weakreference = new WeakReference(view);
        else
            weakreference = null;
        mCustomView = weakreference;
    }

    public void setSubtitle(int i) {
        setSubtitle(((CharSequence) (mContext.getString(i))));
    }

    public void setSubtitle(CharSequence charsequence) {
        mContextView.setSubtitle(charsequence);
    }

    public void setTitle(int i) {
        setTitle(((CharSequence) (mContext.getString(i))));
    }

    public void setTitle(CharSequence charsequence) {
        mContextView.setTitle(charsequence);
    }

    public void setTitleOptionalHint(boolean flag) {
        super.setTitleOptionalHint(flag);
        mContextView.setTitleOptional(flag);
    }

    private android.view.ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;
}
