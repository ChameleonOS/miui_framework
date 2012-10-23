// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.*;

public class ActionMenuItem
    implements MenuItem {

    public ActionMenuItem(Context context, int i, int j, int k, int l, CharSequence charsequence) {
        mIconResId = 0;
        mFlags = 16;
        mContext = context;
        mId = j;
        mGroup = i;
        mCategoryOrder = k;
        mOrdering = l;
        mTitle = charsequence;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        return null;
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }

    public int getGroupId() {
        return mGroup;
    }

    public Drawable getIcon() {
        return mIconDrawable;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public int getItemId() {
        return mId;
    }

    public android.view.ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return mShortcutNumericChar;
    }

    public int getOrder() {
        return mOrdering;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public CharSequence getTitleCondensed() {
        return mTitleCondensed;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        boolean flag = true;
        if(mClickListener == null || !mClickListener.onMenuItemClick(this))
            if(mIntent != null)
                mContext.startActivity(mIntent);
            else
                flag = false;
        return flag;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        boolean flag;
        if((1 & mFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isChecked() {
        boolean flag;
        if((2 & mFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEnabled() {
        boolean flag;
        if((0x10 & mFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isVisible() {
        boolean flag;
        if((8 & mFlags) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public MenuItem setActionProvider(ActionProvider actionprovider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        mShortcutAlphabeticChar = c;
        return this;
    }

    public MenuItem setCheckable(boolean flag) {
        int i = -2 & mFlags;
        boolean flag1;
        if(flag)
            flag1 = true;
        else
            flag1 = false;
        mFlags = flag1 | i;
        return this;
    }

    public MenuItem setChecked(boolean flag) {
        int i = -3 & mFlags;
        byte byte0;
        if(flag)
            byte0 = 2;
        else
            byte0 = 0;
        mFlags = byte0 | i;
        return this;
    }

    public MenuItem setEnabled(boolean flag) {
        int i = 0xffffffef & mFlags;
        byte byte0;
        if(flag)
            byte0 = 16;
        else
            byte0 = 0;
        mFlags = byte0 | i;
        return this;
    }

    public ActionMenuItem setExclusiveCheckable(boolean flag) {
        int i = -5 & mFlags;
        byte byte0;
        if(flag)
            byte0 = 4;
        else
            byte0 = 0;
        mFlags = byte0 | i;
        return this;
    }

    public MenuItem setIcon(int i) {
        mIconResId = i;
        mIconDrawable = mContext.getResources().getDrawable(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        mIconDrawable = drawable;
        mIconResId = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        mShortcutNumericChar = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener) {
        return this;
    }

    public MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener) {
        mClickListener = onmenuitemclicklistener;
        return this;
    }

    public MenuItem setShortcut(char c, char c1) {
        mShortcutNumericChar = c;
        mShortcutAlphabeticChar = c1;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        mTitle = mContext.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charsequence) {
        mTitle = charsequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charsequence) {
        mTitleCondensed = charsequence;
        return this;
    }

    public MenuItem setVisible(boolean flag) {
        int i = 8 & mFlags;
        byte byte0;
        if(flag)
            byte0 = 0;
        else
            byte0 = 8;
        mFlags = byte0 | i;
        return this;
    }

    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int NO_ICON;
    private final int mCategoryOrder;
    private android.view.MenuItem.OnMenuItemClickListener mClickListener;
    private Context mContext;
    private int mFlags;
    private final int mGroup;
    private Drawable mIconDrawable;
    private int mIconResId;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
}
