// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.*;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.*;
import android.widget.LinearLayout;

// Referenced classes of package com.android.internal.view.menu:
//            MenuBuilder, SubMenuBuilder

public final class MenuItemImpl
    implements MenuItem {

    MenuItemImpl(MenuBuilder menubuilder, int i, int j, int k, int l, CharSequence charsequence, int i1) {
        mIconResId = 0;
        mFlags = 16;
        mShowAsAction = 0;
        mIsActionViewExpanded = false;
        if(sPrependShortcutLabel == null) {
            sPrependShortcutLabel = menubuilder.getContext().getResources().getString(0x1040398);
            sEnterShortcutLabel = menubuilder.getContext().getResources().getString(0x104039a);
            sDeleteShortcutLabel = menubuilder.getContext().getResources().getString(0x104039b);
            sSpaceShortcutLabel = menubuilder.getContext().getResources().getString(0x1040399);
        }
        mMenu = menubuilder;
        mId = j;
        mGroup = i;
        mCategoryOrder = k;
        mOrdering = l;
        mTitle = charsequence;
        mShowAsAction = i1;
    }

    public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
    }

    public boolean collapseActionView() {
        boolean flag = false;
        if((8 & mShowAsAction) != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(mActionView == null)
            flag = true;
        else
        if(mOnActionExpandListener == null || mOnActionExpandListener.onMenuItemActionCollapse(this))
            flag = mMenu.collapseItemActionView(this);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean expandActionView() {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if((8 & mShowAsAction) != 0 && mActionView != null && (mOnActionExpandListener == null || mOnActionExpandListener.onMenuItemActionExpand(this)))
            flag = mMenu.expandItemActionView(this);
        return flag;
    }

    public ActionProvider getActionProvider() {
        return mActionProvider;
    }

    public View getActionView() {
        View view;
        if(mActionView != null)
            view = mActionView;
        else
        if(mActionProvider != null) {
            mActionView = mActionProvider.onCreateActionView(this);
            view = mActionView;
        } else {
            view = null;
        }
        return view;
    }

    public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }

    Runnable getCallback() {
        return mItemCallback;
    }

    public int getGroupId() {
        return mGroup;
    }

    public Drawable getIcon() {
        Drawable drawable;
        if(mIconDrawable != null)
            drawable = mIconDrawable;
        else
        if(mIconResId != 0) {
            drawable = mMenu.getResources().getDrawable(mIconResId);
            mIconResId = 0;
            mIconDrawable = drawable;
        } else {
            drawable = null;
        }
        return drawable;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public int getItemId() {
        return mId;
    }

    public android.view.ContextMenu.ContextMenuInfo getMenuInfo() {
        return mMenuInfo;
    }

    public char getNumericShortcut() {
        return mShortcutNumericChar;
    }

    public int getOrder() {
        return mCategoryOrder;
    }

    public int getOrdering() {
        return mOrdering;
    }

    char getShortcut() {
        char c;
        if(mMenu.isQwertyMode())
            c = mShortcutAlphabeticChar;
        else
            c = mShortcutNumericChar;
        return c;
    }

    String getShortcutLabel() {
        char c = getShortcut();
        if(c != 0) goto _L2; else goto _L1
_L1:
        String s = "";
_L8:
        return s;
_L2:
        StringBuilder stringbuilder = new StringBuilder(sPrependShortcutLabel);
        c;
        JVM INSTR lookupswitch 3: default 64
    //                   8: 90
    //                   10: 79
    //                   32: 101;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_101;
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        stringbuilder.append(c);
_L9:
        s = stringbuilder.toString();
        if(true) goto _L8; else goto _L7
_L7:
        stringbuilder.append(sEnterShortcutLabel);
          goto _L9
_L4:
        stringbuilder.append(sDeleteShortcutLabel);
          goto _L9
        stringbuilder.append(sSpaceShortcutLabel);
          goto _L9
    }

    public SubMenu getSubMenu() {
        return mSubMenu;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charsequence;
        if(mTitleCondensed != null)
            charsequence = mTitleCondensed;
        else
            charsequence = mTitle;
        return charsequence;
    }

    CharSequence getTitleForItemView(MenuView.ItemView itemview) {
        CharSequence charsequence;
        if(itemview != null && itemview.prefersCondensedTitle())
            charsequence = getTitleCondensed();
        else
            charsequence = getTitle();
        return charsequence;
    }

    public boolean hasCollapsibleActionView() {
        boolean flag;
        if((8 & mShowAsAction) != 0 && mActionView != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasSubMenu() {
        boolean flag;
        if(mSubMenu != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean invoke() {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return flag;
            while(mClickListener != null && mClickListener.onMenuItemClick(this) || mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this));
            if(mItemCallback != null) {
                mItemCallback.run();
                continue;
            }
            if(mIntent != null)
                try {
                    mMenu.getContext().startActivity(mIntent);
                    continue;
                }
                catch(ActivityNotFoundException activitynotfoundexception) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", activitynotfoundexception);
                }
            if(mActionProvider == null || !mActionProvider.onPerformDefaultAction())
                flag = false;
        }
    }

    public boolean isActionButton() {
        boolean flag;
        if((0x20 & mFlags) == 32)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isActionViewExpanded() {
        return mIsActionViewExpanded;
    }

    public boolean isCheckable() {
        boolean flag = true;
        if((1 & mFlags) != flag)
            flag = false;
        return flag;
    }

    public boolean isChecked() {
        boolean flag;
        if((2 & mFlags) == 2)
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

    public boolean isExclusiveCheckable() {
        boolean flag;
        if((4 & mFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isForceShowText() {
        boolean flag;
        if((0x80000000 & mShowAsAction) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isVisible() {
        boolean flag = true;
        if(mActionProvider == null || !mActionProvider.overridesItemVisibility()) goto _L2; else goto _L1
_L1:
        if((8 & mFlags) != 0 || !mActionProvider.isVisible())
            flag = false;
_L4:
        return flag;
_L2:
        if((8 & mFlags) != 0)
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean requestsActionButton() {
        boolean flag = true;
        if((1 & mShowAsAction) != flag)
            flag = false;
        return flag;
    }

    public boolean requiresActionButton() {
        boolean flag;
        if((2 & mShowAsAction) == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public MenuItem setActionProvider(ActionProvider actionprovider) {
        if(mActionProvider != null)
            mActionProvider.setVisibilityListener(null);
        mActionView = null;
        mActionProvider = actionprovider;
        mMenu.onItemsChanged(true);
        mActionProvider.setVisibilityListener(new android.view.ActionProvider.VisibilityListener() {

            public void onActionProviderVisibilityChanged(boolean flag) {
                mMenu.onItemVisibleChanged(MenuItemImpl.this);
            }

            final MenuItemImpl this$0;

             {
                this$0 = MenuItemImpl.this;
                super();
            }
        });
        return this;
    }

    public MenuItem setActionView(int i) {
        Context context = mMenu.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public MenuItem setActionView(View view) {
        mActionView = view;
        mActionProvider = null;
        if(view != null && view.getId() == -1 && mId > 0)
            view.setId(mId);
        mMenu.onItemActionRequestChanged(this);
        return this;
    }

    public void setActionViewExpanded(boolean flag) {
        mIsActionViewExpanded = flag;
        mMenu.onItemsChanged(false);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if(mShortcutAlphabeticChar != c) {
            mShortcutAlphabeticChar = Character.toLowerCase(c);
            mMenu.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        mItemCallback = runnable;
        return this;
    }

    public MenuItem setCheckable(boolean flag) {
        int i = mFlags;
        int j = -2 & mFlags;
        boolean flag1;
        if(flag)
            flag1 = true;
        else
            flag1 = false;
        mFlags = flag1 | j;
        if(i != mFlags)
            mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setChecked(boolean flag) {
        if((4 & mFlags) != 0)
            mMenu.setExclusiveItemChecked(this);
        else
            setCheckedInt(flag);
        return this;
    }

    void setCheckedInt(boolean flag) {
        int i = mFlags;
        int j = -3 & mFlags;
        byte byte0;
        if(flag)
            byte0 = 2;
        else
            byte0 = 0;
        mFlags = byte0 | j;
        if(i != mFlags)
            mMenu.onItemsChanged(false);
    }

    public MenuItem setEnabled(boolean flag) {
        if(flag)
            mFlags = 0x10 | mFlags;
        else
            mFlags = 0xffffffef & mFlags;
        mMenu.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean flag) {
        int i = -5 & mFlags;
        byte byte0;
        if(flag)
            byte0 = 4;
        else
            byte0 = 0;
        mFlags = byte0 | i;
    }

    public MenuItem setIcon(int i) {
        mIconDrawable = null;
        mIconResId = i;
        mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        mIconResId = 0;
        mIconDrawable = drawable;
        mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
        return this;
    }

    public void setIsActionButton(boolean flag) {
        if(flag)
            mFlags = 0x20 | mFlags;
        else
            mFlags = 0xffffffdf & mFlags;
    }

    void setMenuInfo(android.view.ContextMenu.ContextMenuInfo contextmenuinfo) {
        mMenuInfo = contextmenuinfo;
    }

    public MenuItem setNumericShortcut(char c) {
        if(mShortcutNumericChar != c) {
            mShortcutNumericChar = c;
            mMenu.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener) {
        mOnActionExpandListener = onactionexpandlistener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener) {
        mClickListener = onmenuitemclicklistener;
        return this;
    }

    public MenuItem setShortcut(char c, char c1) {
        mShortcutNumericChar = c;
        mShortcutAlphabeticChar = Character.toLowerCase(c1);
        mMenu.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch(i & 3) {
        default:
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            mShowAsAction = i;
            break;
        }
        mMenu.onItemActionRequestChanged(this);
    }

    public MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    void setSubMenu(SubMenuBuilder submenubuilder) {
        mSubMenu = submenubuilder;
        submenubuilder.setHeaderTitle(getTitle());
    }

    public MenuItem setTitle(int i) {
        return setTitle(((CharSequence) (mMenu.getContext().getString(i))));
    }

    public MenuItem setTitle(CharSequence charsequence) {
        mTitle = charsequence;
        mMenu.onItemsChanged(false);
        if(mSubMenu != null)
            mSubMenu.setHeaderTitle(charsequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charsequence) {
        mTitleCondensed = charsequence;
        if(charsequence == null) {
            CharSequence _tmp = mTitle;
        }
        mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean flag) {
        if(setVisibleInt(flag))
            mMenu.onItemVisibleChanged(this);
        return this;
    }

    boolean setVisibleInt(boolean flag) {
        boolean flag1 = false;
        int i = mFlags;
        int j = -9 & mFlags;
        byte byte0;
        if(flag)
            byte0 = 0;
        else
            byte0 = 8;
        mFlags = byte0 | j;
        if(i != mFlags)
            flag1 = true;
        return flag1;
    }

    public boolean shouldShowIcon() {
        return mMenu.getOptionalIconsVisible();
    }

    boolean shouldShowShortcut() {
        boolean flag;
        if(mMenu.isShortcutsVisible() && getShortcut() != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean showsTextAsAction() {
        boolean flag;
        if((4 & mShowAsAction) == 4)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toString() {
        return mTitle.toString();
    }

    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private static String sDeleteShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sPrependShortcutLabel;
    private static String sSpaceShortcutLabel;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private android.view.MenuItem.OnMenuItemClickListener mClickListener;
    private int mFlags;
    private final int mGroup;
    private Drawable mIconDrawable;
    private int mIconResId;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    private MenuBuilder mMenu;
    private android.view.ContextMenu.ContextMenuInfo mMenuInfo;
    private android.view.MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;

}
