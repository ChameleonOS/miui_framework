// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.*;
import android.widget.ImageButton;
import com.android.internal.view.ActionBarPolicy;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.view.menu:
//            BaseMenuPresenter, ActionMenuView, ActionMenuItemView, MenuBuilder, 
//            MenuItemImpl, MenuPopupHelper, SubMenuBuilder, MenuView

public class ActionMenuPresenter extends BaseMenuPresenter
    implements android.view.ActionProvider.SubUiVisibilityListener {
    private class OpenOverflowRunnable
        implements Runnable {

        public void run() {
            mMenu.changeMenuMode();
            View view = (View)mMenuView;
            if(view != null && view.getWindowToken() != null && mPopup.tryShow())
                mOverflowPopup = mPopup;
            mPostedOpenRunnable = null;
        }

        private OverflowPopup mPopup;
        final ActionMenuPresenter this$0;

        public OpenOverflowRunnable(OverflowPopup overflowpopup) {
            this$0 = ActionMenuPresenter.this;
            super();
            mPopup = overflowpopup;
        }
    }

    private class PopupPresenterCallback
        implements MenuPresenter.Callback {

        public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
            if(menubuilder instanceof SubMenuBuilder)
                ((SubMenuBuilder)menubuilder).getRootMenu().close(false);
        }

        public boolean onOpenSubMenu(MenuBuilder menubuilder) {
            if(menubuilder != null)
                mOpenSubMenuId = ((SubMenuBuilder)menubuilder).getItem().getItemId();
            return false;
        }

        final ActionMenuPresenter this$0;

        private PopupPresenterCallback() {
            this$0 = ActionMenuPresenter.this;
            super();
        }

    }

    private class ActionButtonSubmenu extends MenuPopupHelper {

        public void onDismiss() {
            super.onDismiss();
            mActionButtonPopup = null;
            mOpenSubMenuId = 0;
        }

        private SubMenuBuilder mSubMenu;
        final ActionMenuPresenter this$0;

        public ActionButtonSubmenu(Context context, SubMenuBuilder submenubuilder) {
            this$0 = ActionMenuPresenter.this;
            super(context, submenubuilder);
            mSubMenu = submenubuilder;
            int j;
            if(!((MenuItemImpl)submenubuilder.getItem()).isActionButton()) {
                boolean flag;
                int i;
                MenuItem menuitem;
                View view;
                if(mOverflowButton == null)
                    view = (View)mMenuView;
                else
                    view = mOverflowButton;
                setAnchorView(view);
            }
            setCallback(mPopupPresenterCallback);
            flag = false;
            i = submenubuilder.size();
            j = 0;
            do {
label0:
                {
                    if(j < i) {
                        menuitem = submenubuilder.getItem(j);
                        if(!menuitem.isVisible() || menuitem.getIcon() == null)
                            break label0;
                        flag = true;
                    }
                    setForceShowIcon(flag);
                    return;
                }
                j++;
            } while(true);
        }
    }

    private class OverflowPopup extends MenuPopupHelper {

        public void onDismiss() {
            super.onDismiss();
            mMenu.close();
            mOverflowPopup = null;
        }

        final ActionMenuPresenter this$0;

        public OverflowPopup(Context context, MenuBuilder menubuilder, View view, boolean flag) {
            this$0 = ActionMenuPresenter.this;
            super(context, menubuilder, view, flag);
            setCallback(mPopupPresenterCallback);
        }
    }

    private class OverflowMenuButton extends ImageButton
        implements ActionMenuView.ActionMenuChildView {

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if(!super.performClick()) {
                playSoundEffect(0);
                showOverflowMenu();
            }
            return true;
        }

        final ActionMenuPresenter this$0;

        public OverflowMenuButton(Context context) {
            this$0 = ActionMenuPresenter.this;
            super(context, null, 0x10102f6);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
        }
    }

    private static class SavedState
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(openSubMenuId);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public int openSubMenuId;


        SavedState() {
        }

        SavedState(Parcel parcel) {
            openSubMenuId = parcel.readInt();
        }
    }


    public ActionMenuPresenter(Context context) {
        super(context, 0x109001b, 0x109001a);
    }

    private View findViewForItem(MenuItem menuitem) {
        ViewGroup viewgroup = (ViewGroup)super.mMenuView;
        if(viewgroup != null) goto _L2; else goto _L1
_L1:
        View view = null;
_L4:
        return view;
_L2:
        int i = viewgroup.getChildCount();
        for(int j = 0; j < i; j++) {
            view = viewgroup.getChildAt(j);
            if((view instanceof MenuView.ItemView) && ((MenuView.ItemView)view).getItemData() == menuitem)
                continue; /* Loop/switch isn't completed */
        }

        view = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void bindItemView(MenuItemImpl menuitemimpl, MenuView.ItemView itemview) {
        itemview.initialize(menuitemimpl, 0);
        ActionMenuView actionmenuview = (ActionMenuView)super.mMenuView;
        ((ActionMenuItemView)itemview).setItemInvoker(actionmenuview);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewgroup, int i) {
        boolean flag;
        if(viewgroup.getChildAt(i) == mOverflowButton)
            flag = false;
        else
            flag = super.filterLeftoverView(viewgroup, i);
        return flag;
    }

    public boolean flagActionItems() {
        ArrayList arraylist = super.mMenu.getVisibleItems();
        int i = arraylist.size();
        int j = mMaxItems;
        int k = mActionItemWidthLimit;
        int l = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewgroup = (ViewGroup)super.mMenuView;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        boolean flag = false;
        int l1 = 0;
        while(l1 < i)  {
            MenuItemImpl menuitemimpl2 = (MenuItemImpl)arraylist.get(l1);
            if(menuitemimpl2.requiresActionButton())
                i1++;
            else
            if(menuitemimpl2.requestsActionButton())
                j1++;
            else
                flag = true;
            if(mExpandedActionViewsExclusive && menuitemimpl2.isActionViewExpanded())
                j = 0;
            l1++;
        }
        if(mReserveOverflow && (flag || i1 + j1 > j))
            j--;
        int i2 = j - i1;
        SparseBooleanArray sparsebooleanarray = mActionButtonGroups;
        sparsebooleanarray.clear();
        int j2 = 0;
        int k2 = 0;
        if(mStrictWidthLimit) {
            k2 = k / mMinCellSize;
            int k4 = k % mMinCellSize;
            j2 = mMinCellSize + k4 / k2;
        }
        int l2 = 0;
        do {
            if(l2 < i) {
                MenuItemImpl menuitemimpl = (MenuItemImpl)arraylist.get(l2);
                if(menuitemimpl.requiresActionButton()) {
                    View view1 = getItemView(menuitemimpl, mScrapActionButtonView, viewgroup);
                    if(mScrapActionButtonView == null)
                        mScrapActionButtonView = view1;
                    int i4;
                    int j4;
                    if(mStrictWidthLimit)
                        k2 -= ActionMenuView.measureChildForCells(view1, j2, k2, l, 0);
                    else
                        view1.measure(l, l);
                    i4 = view1.getMeasuredWidth();
                    k -= i4;
                    if(k1 == 0)
                        k1 = i4;
                    j4 = menuitemimpl.getGroupId();
                    if(j4 != 0)
                        sparsebooleanarray.put(j4, true);
                    menuitemimpl.setIsActionButton(true);
                } else
                if(menuitemimpl.requestsActionButton()) {
                    int i3 = menuitemimpl.getGroupId();
                    boolean flag1 = sparsebooleanarray.get(i3);
                    boolean flag2;
                    if((i2 > 0 || flag1) && k > 0 && (!mStrictWidthLimit || k2 > 0))
                        flag2 = true;
                    else
                        flag2 = false;
                    if(flag2) {
                        View view = getItemView(menuitemimpl, mScrapActionButtonView, viewgroup);
                        if(mScrapActionButtonView == null)
                            mScrapActionButtonView = view;
                        int k3;
                        if(mStrictWidthLimit) {
                            int l3 = ActionMenuView.measureChildForCells(view, j2, k2, l, 0);
                            k2 -= l3;
                            if(l3 == 0)
                                flag2 = false;
                        } else {
                            view.measure(l, l);
                        }
                        k3 = view.getMeasuredWidth();
                        k -= k3;
                        if(k1 == 0)
                            k1 = k3;
                        if(mStrictWidthLimit) {
                            boolean flag4;
                            if(k >= 0)
                                flag4 = true;
                            else
                                flag4 = false;
                            flag2 &= flag4;
                        } else {
                            boolean flag3;
                            if(k + k1 > 0)
                                flag3 = true;
                            else
                                flag3 = false;
                            flag2 &= flag3;
                        }
                    }
                    if(flag2 && i3 != 0)
                        sparsebooleanarray.put(i3, true);
                    else
                    if(flag1) {
                        sparsebooleanarray.put(i3, false);
                        int j3 = 0;
                        while(j3 < l2)  {
                            MenuItemImpl menuitemimpl1 = (MenuItemImpl)arraylist.get(j3);
                            if(menuitemimpl1.getGroupId() == i3) {
                                if(menuitemimpl1.isActionButton())
                                    i2++;
                                menuitemimpl1.setIsActionButton(false);
                            }
                            j3++;
                        }
                    }
                    if(flag2)
                        i2--;
                    menuitemimpl.setIsActionButton(flag2);
                }
            } else {
                return true;
            }
            l2++;
        } while(true);
    }

    public View getItemView(MenuItemImpl menuitemimpl, View view, ViewGroup viewgroup) {
        View view1 = menuitemimpl.getActionView();
        if(view1 == null || menuitemimpl.hasCollapsibleActionView()) {
            if(!(view instanceof ActionMenuItemView))
                view = null;
            view1 = super.getItemView(menuitemimpl, view, viewgroup);
        }
        byte byte0;
        ActionMenuView actionmenuview;
        android.view.ViewGroup.LayoutParams layoutparams;
        if(menuitemimpl.isActionViewExpanded())
            byte0 = 8;
        else
            byte0 = 0;
        view1.setVisibility(byte0);
        actionmenuview = (ActionMenuView)viewgroup;
        layoutparams = view1.getLayoutParams();
        if(!actionmenuview.checkLayoutParams(layoutparams))
            view1.setLayoutParams(actionmenuview.generateLayoutParams(layoutparams));
        return view1;
    }

    public MenuView getMenuView(ViewGroup viewgroup) {
        MenuView menuview = super.getMenuView(viewgroup);
        ((ActionMenuView)menuview).setPresenter(this);
        return menuview;
    }

    public boolean hideOverflowMenu() {
        boolean flag;
        if(mPostedOpenRunnable != null && super.mMenuView != null) {
            ((View)super.mMenuView).removeCallbacks(mPostedOpenRunnable);
            mPostedOpenRunnable = null;
            flag = true;
        } else {
            OverflowPopup overflowpopup = mOverflowPopup;
            if(overflowpopup != null) {
                overflowpopup.dismiss();
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    public boolean hideSubMenus() {
        boolean flag;
        if(mActionButtonPopup != null) {
            mActionButtonPopup.dismiss();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void initForMenu(Context context, MenuBuilder menubuilder) {
        super.initForMenu(context, menubuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionbarpolicy = ActionBarPolicy.get(context);
        if(!mReserveOverflowSet)
            mReserveOverflow = false;
        if(!mWidthLimitSet)
            mWidthLimit = actionbarpolicy.getEmbeddedMenuWidthLimit();
        if(!mMaxItemsSet)
            mMaxItems = actionbarpolicy.getMaxActionButtons();
        int i = mWidthLimit;
        if(mReserveOverflow) {
            if(mOverflowButton == null) {
                mOverflowButton = new OverflowMenuButton(super.mSystemContext);
                int j = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                mOverflowButton.measure(j, j);
            }
            i -= mOverflowButton.getMeasuredWidth();
        } else {
            mOverflowButton = null;
        }
        mActionItemWidthLimit = i;
        mMinCellSize = (int)(56F * resources.getDisplayMetrics().density);
        mScrapActionButtonView = null;
    }

    public boolean isOverflowMenuShowing() {
        boolean flag;
        if(mOverflowPopup != null && mOverflowPopup.isShowing())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isOverflowReserved() {
        return mReserveOverflow;
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
        dismissPopupMenus();
        super.onCloseMenu(menubuilder, flag);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if(!mMaxItemsSet)
            mMaxItems = super.mContext.getResources().getInteger(0x10e0033);
        if(super.mMenu != null)
            super.mMenu.onItemsChanged(true);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        if(savedstate.openSubMenuId > 0) {
            MenuItem menuitem = super.mMenu.findItem(savedstate.openSubMenuId);
            if(menuitem != null)
                onSubMenuSelected((SubMenuBuilder)menuitem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedstate = new SavedState();
        savedstate.openSubMenuId = mOpenSubMenuId;
        return savedstate;
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder) {
        boolean flag = false;
        if(submenubuilder.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        SubMenuBuilder submenubuilder1;
        for(submenubuilder1 = submenubuilder; submenubuilder1.getParentMenu() != super.mMenu; submenubuilder1 = (SubMenuBuilder)submenubuilder1.getParentMenu());
        View view = findViewForItem(submenubuilder1.getItem());
        if(view == null) {
            if(mOverflowButton == null)
                continue; /* Loop/switch isn't completed */
            view = mOverflowButton;
        }
        mOpenSubMenuId = submenubuilder.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(super.mContext, submenubuilder);
        mActionButtonPopup.setAnchorView(view);
        mActionButtonPopup.show();
        super.onSubMenuSelected(submenubuilder);
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void onSubUiVisibilityChanged(boolean flag) {
        if(flag)
            super.onSubMenuSelected(null);
        else
            super.mMenu.close(false);
    }

    public void setExpandedActionViewsExclusive(boolean flag) {
        mExpandedActionViewsExclusive = flag;
    }

    public void setItemLimit(int i) {
        mMaxItems = i;
        mMaxItemsSet = true;
    }

    public void setReserveOverflow(boolean flag) {
        mReserveOverflow = flag;
        mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean flag) {
        mWidthLimit = i;
        mStrictWidthLimit = flag;
        mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuitemimpl) {
        return menuitemimpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        boolean flag = true;
        if(mReserveOverflow && !isOverflowMenuShowing() && super.mMenu != null && super.mMenuView != null && mPostedOpenRunnable == null) {
            mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(super.mContext, super.mMenu, mOverflowButton, flag));
            ((View)super.mMenuView).post(mPostedOpenRunnable);
            super.onSubMenuSelected(null);
        } else {
            flag = false;
        }
        return flag;
    }

    public void updateMenuView(boolean flag) {
        super.updateMenuView(flag);
        if(super.mMenu != null) {
            ArrayList arraylist1 = super.mMenu.getActionItems();
            int j = arraylist1.size();
            for(int k = 0; k < j; k++) {
                ActionProvider actionprovider = ((MenuItemImpl)arraylist1.get(k)).getActionProvider();
                if(actionprovider != null)
                    actionprovider.setSubUiVisibilityListener(this);
            }

        }
        ArrayList arraylist;
        boolean flag1;
        if(super.mMenu != null)
            arraylist = super.mMenu.getNonActionItems();
        else
            arraylist = null;
        flag1 = false;
        if(mReserveOverflow && arraylist != null) {
            int i = arraylist.size();
            ViewGroup viewgroup;
            ActionMenuView actionmenuview;
            if(i == 1) {
                if(!((MenuItemImpl)arraylist.get(0)).isActionViewExpanded())
                    flag1 = true;
                else
                    flag1 = false;
            } else
            if(i > 0)
                flag1 = true;
            else
                flag1 = false;
        }
        if(!flag1) goto _L2; else goto _L1
_L1:
        if(mOverflowButton == null)
            mOverflowButton = new OverflowMenuButton(super.mSystemContext);
        viewgroup = (ViewGroup)mOverflowButton.getParent();
        if(viewgroup != super.mMenuView) {
            if(viewgroup != null)
                viewgroup.removeView(mOverflowButton);
            actionmenuview = (ActionMenuView)super.mMenuView;
            actionmenuview.addView(mOverflowButton, actionmenuview.generateOverflowButtonLayoutParams());
        }
_L4:
        ((ActionMenuView)super.mMenuView).setOverflowReserved(mReserveOverflow);
        return;
_L2:
        if(mOverflowButton != null && mOverflowButton.getParent() == super.mMenuView)
            ((ViewGroup)super.mMenuView).removeView(mOverflowButton);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private View mOverflowButton;
    private OverflowPopup mOverflowPopup;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;


/*
    static OverflowPopup access$102(ActionMenuPresenter actionmenupresenter, OverflowPopup overflowpopup) {
        actionmenupresenter.mOverflowPopup = overflowpopup;
        return overflowpopup;
    }

*/



/*
    static ActionButtonSubmenu access$302(ActionMenuPresenter actionmenupresenter, ActionButtonSubmenu actionbuttonsubmenu) {
        actionmenupresenter.mActionButtonPopup = actionbuttonsubmenu;
        return actionbuttonsubmenu;
    }

*/


/*
    static OpenOverflowRunnable access$402(ActionMenuPresenter actionmenupresenter, OpenOverflowRunnable openoverflowrunnable) {
        actionmenupresenter.mPostedOpenRunnable = openoverflowrunnable;
        return openoverflowrunnable;
    }

*/
}
