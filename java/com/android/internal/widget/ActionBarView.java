// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.*;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.widget.*;
import com.android.internal.view.menu.*;
import java.util.List;

// Referenced classes of package com.android.internal.widget:
//            AbsActionBarView, ScrollingTabContainerView, ActionBarContextView, ActionBarContainer

public class ActionBarView extends AbsActionBarView {
    private class ExpandedActionViewMenuPresenter
        implements MenuPresenter {

        public boolean collapseItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl) {
            if(mExpandedActionView instanceof CollapsibleActionView)
                ((CollapsibleActionView)mExpandedActionView).onActionViewCollapsed();
            removeView(mExpandedActionView);
            removeView(mExpandedHomeLayout);
            mExpandedActionView = null;
            if((2 & mDisplayOptions) != 0)
                mHomeLayout.setVisibility(0);
            if((8 & mDisplayOptions) != 0)
                if(mTitleLayout == null)
                    initTitle();
                else
                    mTitleLayout.setVisibility(0);
            if(mTabScrollView != null && mNavigationMode == 2)
                mTabScrollView.setVisibility(0);
            if(mSpinner != null && mNavigationMode == 1)
                mSpinner.setVisibility(0);
            if(mCustomNavView != null && (0x10 & mDisplayOptions) != 0)
                mCustomNavView.setVisibility(0);
            mExpandedHomeLayout.setIcon(null);
            mCurrentExpandedItem = null;
            requestLayout();
            menuitemimpl.setActionViewExpanded(false);
            return true;
        }

        public boolean expandItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl) {
            mExpandedActionView = menuitemimpl.getActionView();
            mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
            mCurrentExpandedItem = menuitemimpl;
            if(mExpandedActionView.getParent() != ActionBarView.this)
                addView(mExpandedActionView);
            if(mExpandedHomeLayout.getParent() != ActionBarView.this)
                addView(mExpandedHomeLayout);
            mHomeLayout.setVisibility(8);
            if(mTitleLayout != null)
                mTitleLayout.setVisibility(8);
            if(mTabScrollView != null)
                mTabScrollView.setVisibility(8);
            if(mSpinner != null)
                mSpinner.setVisibility(8);
            if(mCustomNavView != null)
                mCustomNavView.setVisibility(8);
            requestLayout();
            menuitemimpl.setActionViewExpanded(true);
            if(mExpandedActionView instanceof CollapsibleActionView)
                ((CollapsibleActionView)mExpandedActionView).onActionViewExpanded();
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup viewgroup) {
            return null;
        }

        public void initForMenu(Context context, MenuBuilder menubuilder) {
            if(mMenu != null && mCurrentExpandedItem != null)
                mMenu.collapseItemActionView(mCurrentExpandedItem);
            mMenu = menubuilder;
        }

        public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder submenubuilder) {
            return false;
        }

        public void setCallback(com.android.internal.view.menu.MenuPresenter.Callback callback) {
        }

        public void updateMenuView(boolean flag) {
            if(mCurrentExpandedItem == null) goto _L2; else goto _L1
_L1:
            boolean flag1 = false;
            if(mMenu == null) goto _L4; else goto _L3
_L3:
            int i;
            int j;
            i = mMenu.size();
            j = 0;
_L9:
            if(j >= i) goto _L4; else goto _L5
_L5:
            if(mMenu.getItem(j) != mCurrentExpandedItem) goto _L7; else goto _L6
_L6:
            flag1 = true;
_L4:
            if(!flag1)
                collapseItemActionView(mMenu, mCurrentExpandedItem);
_L2:
            return;
_L7:
            j++;
            if(true) goto _L9; else goto _L8
_L8:
        }

        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;
        final ActionBarView this$0;

        private ExpandedActionViewMenuPresenter() {
            this$0 = ActionBarView.this;
            super();
        }

    }

    private static class HomeView extends FrameLayout {

        public boolean dispatchHoverEvent(MotionEvent motionevent) {
            return onHoverEvent(motionevent);
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
            onPopulateAccessibilityEvent(accessibilityevent);
            return true;
        }

        ImageView getIconView() {
            return mIconView;
        }

        public int getLeftOffset() {
            int i;
            if(Injector.getUpViewVisibility(this, mUpView) == 8)
                i = mUpWidth;
            else
                i = 0;
            return i;
        }

        View getUpView() {
            return mUpView;
        }

        protected void onFinishInflate() {
            mUpView = findViewById(0x102023b);
            mIconView = (ImageView)findViewById(0x102002c);
            Injector.switchToCompactMode(this);
        }

        protected void onLayout(boolean flag, int i, int j, int k, int l) {
            int i1 = (l - j) / 2;
            int j1 = k - i;
            int k1 = 0;
            if(mUpView.getVisibility() != 8) {
                android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)mUpView.getLayoutParams();
                int i3 = mUpView.getMeasuredHeight();
                int j3 = mUpView.getMeasuredWidth();
                int k3 = i1 - i3 / 2;
                mUpView.layout(0, k3, j3, k3 + i3);
                k1 = j3 + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).rightMargin;
                int _tmp = j1 - k1;
                i += k1;
            }
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)mIconView.getLayoutParams();
            int l1 = mIconView.getMeasuredHeight();
            int i2 = mIconView.getMeasuredWidth();
            int j2 = (k - i) / 2;
            int k2 = k1 + Math.max(((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin, j2 - i2 / 2);
            int l2 = Math.max(((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin, i1 - l1 / 2);
            mIconView.layout(k2, l2, k2 + i2, l2 + l1);
        }

        protected void onMeasure(int i, int j) {
            int i1;
            int j1;
            int i2;
            int j2;
            measureChildWithMargins(mUpView, i, 0, j, 0);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)mUpView.getLayoutParams();
            mUpWidth = ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin + mUpView.getMeasuredWidth() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin;
            int k;
            int l;
            android.widget.FrameLayout.LayoutParams layoutparams1;
            int k1;
            int l1;
            if(mUpView.getVisibility() == 8)
                k = 0;
            else
                k = mUpWidth;
            l = ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin + mUpView.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
            measureChildWithMargins(mIconView, i, k, j, 0);
            layoutparams1 = (android.widget.FrameLayout.LayoutParams)mIconView.getLayoutParams();
            i1 = k + (((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).leftMargin + mIconView.getMeasuredWidth() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).rightMargin);
            j1 = Math.max(l, ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).topMargin + mIconView.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).bottomMargin);
            k1 = android.view.View.MeasureSpec.getMode(i);
            l1 = android.view.View.MeasureSpec.getMode(j);
            i2 = android.view.View.MeasureSpec.getSize(i);
            j2 = android.view.View.MeasureSpec.getSize(j);
            k1;
            JVM INSTR lookupswitch 2: default 204
        //                       -2147483648: 250
        //                       1073741824: 262;
               goto _L1 _L2 _L3
_L1:
            l1;
            JVM INSTR lookupswitch 2: default 232
        //                       -2147483648: 269
        //                       1073741824: 281;
               goto _L4 _L5 _L6
_L4:
            setMeasuredDimension(i1, j1);
            return;
_L2:
            i1 = Math.min(i1, i2);
              goto _L1
_L3:
            i1 = i2;
              goto _L1
_L5:
            j1 = Math.min(j1, j2);
              goto _L4
_L6:
            j1 = j2;
              goto _L4
        }

        public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
            super.onPopulateAccessibilityEvent(accessibilityevent);
            CharSequence charsequence = getContentDescription();
            if(!TextUtils.isEmpty(charsequence))
                accessibilityevent.getText().add(charsequence);
        }

        public void setIcon(Drawable drawable) {
            mIconView.setImageDrawable(drawable);
            Injector.setIcon(this, drawable);
        }

        public void setUp(boolean flag) {
            View view = mUpView;
            int i;
            if(flag)
                i = 0;
            else
                i = 8;
            view.setVisibility(i);
            Injector.setIcon(this);
        }

        boolean mCompactMode;
        Drawable mIconDrawable;
        private ImageView mIconView;
        private View mUpView;
        private int mUpWidth;

        public HomeView(Context context) {
            this(context, null);
        }

        public HomeView(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }
    }

    static class SavedState extends android.view.View.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(expandedMenuItemId);
            int j;
            if(isOverflowOpen)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
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
        int expandedMenuItemId;
        boolean isOverflowOpen;


        private SavedState(Parcel parcel) {
            super(parcel);
            expandedMenuItemId = parcel.readInt();
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            isOverflowOpen = flag;
        }


        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    static class Injector {

        static int getUpViewVisibility(HomeView homeview, View view) {
            byte byte0 = 8;
            if(homeview.mCompactMode || view.getVisibility() != byte0)
                byte0 = 0;
            return byte0;
        }

        static void setIcon(HomeView homeview) {
            ImageView imageview = homeview.getIconView();
            if(homeview.mCompactMode && homeview.getUpView().getVisibility() == 0)
                imageview.setImageDrawable(null);
            else
                imageview.setImageDrawable(homeview.mIconDrawable);
        }

        static void setIcon(HomeView homeview, Drawable drawable) {
            homeview.mIconDrawable = drawable;
            setIcon(homeview);
        }

        static void switchToCompactMode(HomeView homeview) {
            boolean flag = true;
            View view = homeview.getUpView();
            if(view instanceof ImageView) {
                if((float)((ImageView)view).getDrawable().getMinimumWidth() <= TypedValue.applyDimension(flag, 20F, homeview.getResources().getDisplayMetrics()))
                    flag = false;
                homeview.mCompactMode = flag;
            }
        }

        Injector() {
        }
    }


    public ActionBarView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mDisplayOptions = -1;
        setBackgroundResource(0);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ActionBar, 0x10102ce, 0);
        ApplicationInfo applicationinfo = context.getApplicationInfo();
        PackageManager packagemanager = context.getPackageManager();
        mNavigationMode = typedarray.getInt(7, 0);
        mTitle = typedarray.getText(5);
        mSubtitle = typedarray.getText(9);
        mLogo = typedarray.getDrawable(6);
        if(mLogo == null) {
            LayoutInflater layoutinflater;
            int i;
            int j;
            if(context instanceof Activity)
                try {
                    mLogo = packagemanager.getActivityLogo(((Activity)context).getComponentName());
                }
                catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1) {
                    Log.e("ActionBarView", "Activity component name not found!", namenotfoundexception1);
                }
            if(mLogo == null)
                mLogo = applicationinfo.loadLogo(packagemanager);
        }
        mIcon = typedarray.getDrawable(0);
        if(mIcon == null) {
            if(context instanceof Activity)
                try {
                    mIcon = packagemanager.getActivityIcon(((Activity)context).getComponentName());
                }
                catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
                    Log.e("ActionBarView", "Activity component name not found!", namenotfoundexception);
                }
            if(mIcon == null)
                mIcon = applicationinfo.loadIcon(packagemanager);
        }
        layoutinflater = LayoutInflater.from(context);
        i = typedarray.getResourceId(15, 0x1090018);
        mHomeLayout = (HomeView)layoutinflater.inflate(i, this, false);
        mExpandedHomeLayout = (HomeView)layoutinflater.inflate(i, this, false);
        mExpandedHomeLayout.setUp(true);
        mExpandedHomeLayout.setOnClickListener(mExpandedActionViewUpListener);
        mExpandedHomeLayout.setContentDescription(getResources().getText(0x10404d1));
        mTitleStyleRes = typedarray.getResourceId(11, 0);
        mSubtitleStyleRes = typedarray.getResourceId(12, 0);
        mProgressStyle = typedarray.getResourceId(1, 0);
        mIndeterminateProgressStyle = typedarray.getResourceId(13, 0);
        mProgressBarPadding = typedarray.getDimensionPixelOffset(14, 0);
        mItemPadding = typedarray.getDimensionPixelOffset(16, 0);
        setDisplayOptions(typedarray.getInt(8, 0));
        j = typedarray.getResourceId(10, 0);
        if(j != 0) {
            mCustomNavView = layoutinflater.inflate(j, this, false);
            mNavigationMode = 0;
            setDisplayOptions(0x10 | mDisplayOptions);
        }
        super.mContentHeight = typedarray.getLayoutDimension(4, 0);
        typedarray.recycle();
        mLogoNavItem = new ActionMenuItem(context, 0, 0x102002c, 0, 0, mTitle);
        mHomeLayout.setOnClickListener(mUpClickListener);
        mHomeLayout.setClickable(true);
        mHomeLayout.setFocusable(true);
        if(getImportantForAccessibility() == 0)
            setImportantForAccessibility(1);
        mMaxHomeSlop = (int)(0.5F + 32F * context.getResources().getDisplayMetrics().density);
    }

    private void configPresenters(MenuBuilder menubuilder) {
        if(menubuilder != null) {
            menubuilder.addMenuPresenter(super.mActionMenuPresenter);
            menubuilder.addMenuPresenter(mExpandedMenuPresenter);
        } else {
            super.mActionMenuPresenter.initForMenu(super.mContext, null);
            mExpandedMenuPresenter.initForMenu(super.mContext, null);
            super.mActionMenuPresenter.updateMenuView(true);
            mExpandedMenuPresenter.updateMenuView(true);
        }
    }

    private void initTitle() {
        boolean flag = true;
        if(mTitleLayout == null) {
            mTitleLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(0x1090019, this, false);
            mTitleView = (TextView)mTitleLayout.findViewById(0x1020242);
            mSubtitleView = (TextView)mTitleLayout.findViewById(0x1020243);
            mTitleUpView = mTitleLayout.findViewById(0x102023b);
            mTitleLayout.setOnClickListener(mUpClickListener);
            if(mTitleStyleRes != 0)
                mTitleView.setTextAppearance(super.mContext, mTitleStyleRes);
            if(mTitle != null)
                mTitleView.setText(mTitle);
            if(mSubtitleStyleRes != 0)
                mSubtitleView.setTextAppearance(super.mContext, mSubtitleStyleRes);
            if(mSubtitle != null) {
                mSubtitleView.setText(mSubtitle);
                mSubtitleView.setVisibility(0);
            }
            boolean flag1;
            boolean flag2;
            boolean flag3;
            View view;
            int i;
            LinearLayout linearlayout;
            boolean flag4;
            LinearLayout linearlayout1;
            if((4 & mDisplayOptions) != 0)
                flag1 = flag;
            else
                flag1 = false;
            if((2 & mDisplayOptions) != 0)
                flag2 = flag;
            else
                flag2 = false;
            if(!flag2)
                flag3 = flag;
            else
                flag3 = false;
            view = mTitleUpView;
            if(flag3) {
                if(flag1)
                    i = 0;
                else
                    i = 4;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            linearlayout = mTitleLayout;
            if(flag1 && flag3)
                flag4 = flag;
            else
                flag4 = false;
            linearlayout.setEnabled(flag4);
            linearlayout1 = mTitleLayout;
            if(!flag1 || !flag3)
                flag = false;
            linearlayout1.setClickable(flag);
        }
        addView(mTitleLayout);
        if(mExpandedActionView != null || TextUtils.isEmpty(mTitle) && TextUtils.isEmpty(mSubtitle))
            mTitleLayout.setVisibility(8);
    }

    private void setTitleImpl(CharSequence charsequence) {
        int i = 0;
        mTitle = charsequence;
        if(mTitleView != null) {
            mTitleView.setText(charsequence);
            boolean flag;
            LinearLayout linearlayout;
            if(mExpandedActionView == null && (8 & mDisplayOptions) != 0 && (!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle)))
                flag = true;
            else
                flag = false;
            linearlayout = mTitleLayout;
            if(!flag)
                i = 8;
            linearlayout.setVisibility(i);
        }
        if(mLogoNavItem != null)
            mLogoNavItem.setTitle(charsequence);
    }

    public void collapseActionView() {
        MenuItemImpl menuitemimpl;
        if(mExpandedMenuPresenter == null)
            menuitemimpl = null;
        else
            menuitemimpl = mExpandedMenuPresenter.mCurrentExpandedItem;
        if(menuitemimpl != null)
            menuitemimpl.collapseActionView();
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new android.app.ActionBar.LayoutParams(19);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new android.app.ActionBar.LayoutParams(getContext(), attributeset);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        if(layoutparams == null)
            layoutparams = generateDefaultLayoutParams();
        return layoutparams;
    }

    public View getCustomNavigationView() {
        return mCustomNavView;
    }

    public int getDisplayOptions() {
        return mDisplayOptions;
    }

    public SpinnerAdapter getDropdownAdapter() {
        return mSpinnerAdapter;
    }

    public int getDropdownSelectedPosition() {
        return mSpinner.getSelectedItemPosition();
    }

    public int getNavigationMode() {
        return mNavigationMode;
    }

    public CharSequence getSubtitle() {
        return mSubtitle;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public boolean hasEmbeddedTabs() {
        return mIncludeTabs;
    }

    public boolean hasExpandedActionView() {
        boolean flag;
        if(mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void initIndeterminateProgress() {
        mIndeterminateProgressView = new ProgressBar(super.mContext, null, 0, mIndeterminateProgressStyle);
        mIndeterminateProgressView.setId(0x102031c);
        mIndeterminateProgressView.setVisibility(8);
        addView(mIndeterminateProgressView);
    }

    public void initProgress() {
        mProgressView = new ProgressBar(super.mContext, null, 0, mProgressStyle);
        mProgressView.setId(0x102031d);
        mProgressView.setMax(10000);
        mProgressView.setVisibility(8);
        addView(mProgressView);
    }

    public boolean isCollapsed() {
        return mIsCollapsed;
    }

    public boolean isSplitActionBar() {
        return super.mSplitActionBar;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mTitleView = null;
        mSubtitleView = null;
        mTitleUpView = null;
        if(mTitleLayout != null && mTitleLayout.getParent() == this)
            removeView(mTitleLayout);
        mTitleLayout = null;
        if((8 & mDisplayOptions) != 0)
            initTitle();
        if(mTabScrollView != null && mIncludeTabs) {
            android.view.ViewGroup.LayoutParams layoutparams = mTabScrollView.getLayoutParams();
            if(layoutparams != null) {
                layoutparams.width = -2;
                layoutparams.height = -1;
            }
            mTabScrollView.setAllowCollapse(true);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mTabSelector);
        if(super.mActionMenuPresenter != null) {
            super.mActionMenuPresenter.hideOverflowMenu();
            super.mActionMenuPresenter.hideSubMenus();
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        addView(mHomeLayout);
        if(mCustomNavView != null && (0x10 & mDisplayOptions) != 0) {
            android.view.ViewParent viewparent = mCustomNavView.getParent();
            if(viewparent != this) {
                if(viewparent instanceof ViewGroup)
                    ((ViewGroup)viewparent).removeView(mCustomNavView);
                addView(mCustomNavView);
            }
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        int i1;
        int j1;
        int k1;
        i1 = getPaddingLeft();
        j1 = getPaddingTop();
        k1 = l - j - getPaddingTop() - getPaddingBottom();
        if(k1 > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l1;
        int i2;
        int j2;
        View view;
        int i3;
        int j3;
        int k3;
        int i4;
        int k4;
        boolean flag2;
        HomeView homeview;
        boolean flag1;
        if(mExpandedActionView != null)
            homeview = mExpandedHomeLayout;
        else
            homeview = mHomeLayout;
        flag1 = false;
        l1 = mMaxHomeSlop;
        i2 = 0;
        if(homeview.getVisibility() != 8) {
            int i6 = homeview.getLeftOffset();
            i1 += i6 + positionChild(homeview, i1 + i6, j1, k1);
            TouchDelegate touchdelegate;
            int k2;
            android.view.ViewGroup.LayoutParams layoutparams;
            int j4;
            int l4;
            int i5;
            int j5;
            if(homeview == mHomeLayout)
                flag1 = true;
            else
                flag1 = false;
            i2 = i1;
        }
        if(mExpandedActionView != null) goto _L4; else goto _L3
_L3:
        if(mTitleLayout != null && mTitleLayout.getVisibility() != 8 && (8 & mDisplayOptions) != 0)
            flag2 = true;
        else
            flag2 = false;
        if(flag2)
            i1 += positionChild(mTitleLayout, i1, j1, k1);
        mNavigationMode;
        JVM INSTR tableswitch 0 2: default 208
    //                   0 208
    //                   1 744
    //                   2 808;
           goto _L4 _L4 _L5 _L6
_L4:
        j2 = k - i - getPaddingRight();
        if(super.mMenuView != null && super.mMenuView.getParent() == this) {
            positionChildInverse(super.mMenuView, j2, j1, k1);
            j2 -= super.mMenuView.getMeasuredWidth();
        }
        if(mIndeterminateProgressView != null && mIndeterminateProgressView.getVisibility() != 8) {
            positionChildInverse(mIndeterminateProgressView, j2, j1, k1);
            j2 -= mIndeterminateProgressView.getMeasuredWidth();
        }
        view = null;
        if(mExpandedActionView != null)
            view = mExpandedActionView;
        else
        if((0x10 & mDisplayOptions) != 0 && mCustomNavView != null)
            view = mCustomNavView;
        if(view == null) goto _L8; else goto _L7
_L7:
        layoutparams = view.getLayoutParams();
        android.app.ActionBar.LayoutParams layoutparams1;
        int l2;
        int l3;
        if(layoutparams instanceof android.app.ActionBar.LayoutParams)
            layoutparams1 = (android.app.ActionBar.LayoutParams)layoutparams;
        else
            layoutparams1 = null;
        if(layoutparams1 != null)
            l2 = layoutparams1.gravity;
        else
            l2 = 19;
        i3 = view.getMeasuredWidth();
        j3 = 0;
        k3 = 0;
        if(layoutparams1 != null) {
            i1 += ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).leftMargin;
            j2 -= ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).rightMargin;
            j3 = ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).topMargin;
            k3 = ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).bottomMargin;
        }
        l3 = l2 & 7;
        if(l3 == 1) {
            int l5 = (super.mRight - super.mLeft - i3) / 2;
            if(l5 < i1)
                l3 = 3;
            else
            if(l5 + i3 > j2)
                l3 = 5;
        } else
        if(l2 == -1)
            l3 = 3;
        i4 = 0;
        l3;
        JVM INSTR tableswitch 1 5: default 496
    //                   1 940
    //                   2 496
    //                   3 959
    //                   4 496
    //                   5 966;
           goto _L9 _L10 _L9 _L11 _L9 _L12
_L9:
        j4 = l2 & 0x70;
        if(l2 == -1)
            j4 = 16;
        k4 = 0;
        j4;
        JVM INSTR lookupswitch 3: default 552
    //                   16: 976
    //                   48: 1012
    //                   80: 1024;
           goto _L13 _L14 _L15 _L16
_L13:
        break; /* Loop/switch isn't completed */
_L16:
        break MISSING_BLOCK_LABEL_1024;
_L17:
        l4 = view.getMeasuredWidth();
        i5 = i4 + l4;
        j5 = k4 + view.getMeasuredHeight();
        view.layout(i4, k4, i5, j5);
        l1 = Math.min(l1, Math.max(i4 - i2, 0));
        i1 + l4;
_L8:
        if(mProgressView != null) {
            mProgressView.bringToFront();
            k2 = mProgressView.getMeasuredHeight() / 2;
            mProgressView.layout(mProgressBarPadding, -k2, mProgressBarPadding + mProgressView.getMeasuredWidth(), k2);
        }
        int k5;
        if(flag1) {
            mTempRect.set(homeview.getLeft(), homeview.getTop(), l1 + homeview.getRight(), homeview.getBottom());
            touchdelegate = new TouchDelegate(mTempRect, homeview);
            setTouchDelegate(touchdelegate);
        } else {
            setTouchDelegate(null);
        }
          goto _L1
_L5:
        if(mListNavLayout != null) {
            if(flag2)
                i1 += mItemPadding;
            l1 = Math.min(l1, Math.max(i1 - i2, 0));
            i1 += positionChild(mListNavLayout, i1, j1, k1) + mItemPadding;
        }
          goto _L4
_L6:
        if(mTabScrollView != null) {
            if(flag2)
                i1 += mItemPadding;
            l1 = Math.min(l1, Math.max(i1 - i2, 0));
            i1 += positionChild(mTabScrollView, i1, j1, k1) + mItemPadding;
        }
          goto _L4
_L10:
        i4 = (super.mRight - super.mLeft - i3) / 2;
          goto _L9
_L11:
        i4 = i1;
          goto _L9
_L12:
        i4 = j2 - i3;
          goto _L9
_L14:
        k5 = getPaddingTop();
        k4 = (super.mBottom - super.mTop - getPaddingBottom() - k5 - view.getMeasuredHeight()) / 2;
          goto _L17
_L15:
        k4 = j3 + getPaddingTop();
          goto _L17
        k4 = getHeight() - getPaddingBottom() - view.getMeasuredHeight() - k3;
          goto _L17
    }

    protected void onMeasure(int i, int j) {
        int k = getChildCount();
        if(!mIsCollapsable) goto _L2; else goto _L1
_L1:
        int l8;
        l8 = 0;
        for(int i9 = 0; i9 < k; i9++) {
            View view1 = getChildAt(i9);
            if(view1.getVisibility() != 8 && (view1 != super.mMenuView || super.mMenuView.getChildCount() != 0))
                l8++;
        }

        if(l8 != 0) goto _L2; else goto _L3
_L3:
        setMeasuredDimension(0, 0);
        mIsCollapsed = true;
_L10:
        return;
_L2:
        int l;
        int i1;
        int i2;
        int k2;
        int l2;
        boolean flag;
        int j3;
        mIsCollapsed = false;
        if(android.view.View.MeasureSpec.getMode(i) != 0x40000000)
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with android:layout_width=\"match_parent\" (or fill_parent)").toString());
        if(android.view.View.MeasureSpec.getMode(j) != 0x80000000)
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with android:layout_height=\"wrap_content\"").toString());
        l = android.view.View.MeasureSpec.getSize(i);
        int j1;
        int k1;
        int l1;
        int j2;
        int i3;
        HomeView homeview;
        if(super.mContentHeight > 0)
            i1 = super.mContentHeight;
        else
            i1 = android.view.View.MeasureSpec.getSize(j);
        j1 = getPaddingTop() + getPaddingBottom();
        k1 = getPaddingLeft();
        l1 = getPaddingRight();
        i2 = i1 - j1;
        j2 = android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x80000000);
        k2 = l - k1 - l1;
        l2 = k2 / 2;
        i3 = l2;
        if(mExpandedActionView != null)
            homeview = mExpandedHomeLayout;
        else
            homeview = mHomeLayout;
        if(homeview.getVisibility() != 8) {
            android.view.ViewGroup.LayoutParams layoutparams2 = homeview.getLayoutParams();
            int k3;
            int l3;
            int i4;
            int j4;
            int l4;
            int k5;
            int i8;
            int j8;
            int k8;
            if(layoutparams2.width < 0)
                i8 = android.view.View.MeasureSpec.makeMeasureSpec(k2, 0x80000000);
            else
                i8 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams2.width, 0x40000000);
            j8 = android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x40000000);
            homeview.measure(i8, j8);
            k8 = homeview.getMeasuredWidth() + homeview.getLeftOffset();
            k2 = Math.max(0, k2 - k8);
            l2 = Math.max(0, k2 - k8);
        }
        if(super.mMenuView != null && super.mMenuView.getParent() == this) {
            k2 = measureChildView(super.mMenuView, k2, j2, 0);
            i3 = Math.max(0, i3 - super.mMenuView.getMeasuredWidth());
        }
        if(mIndeterminateProgressView != null && mIndeterminateProgressView.getVisibility() != 8) {
            k2 = measureChildView(mIndeterminateProgressView, k2, j2, 0);
            i3 = Math.max(0, i3 - mIndeterminateProgressView.getMeasuredWidth());
        }
        if(mTitleLayout != null && mTitleLayout.getVisibility() != 8 && (8 & mDisplayOptions) != 0)
            flag = true;
        else
            flag = false;
        if(mExpandedActionView != null) goto _L5; else goto _L4
_L4:
        mNavigationMode;
        JVM INSTR tableswitch 1 2: default 536
    //                   1 922
    //                   2 1030;
           goto _L6 _L7 _L8
_L6:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_1030;
_L5:
        View view = null;
        if(mExpandedActionView != null)
            view = mExpandedActionView;
        else
        if((0x10 & mDisplayOptions) != 0 && mCustomNavView != null)
            view = mCustomNavView;
        if(view != null) {
            android.view.ViewGroup.LayoutParams layoutparams = generateLayoutParams(view.getLayoutParams());
            android.app.ActionBar.LayoutParams layoutparams1;
            int k4;
            int i5;
            int j5;
            int l5;
            int i6;
            int j6;
            int k6;
            int l6;
            int i7;
            int j7;
            int k7;
            int l7;
            if(layoutparams instanceof android.app.ActionBar.LayoutParams)
                layoutparams1 = (android.app.ActionBar.LayoutParams)layoutparams;
            else
                layoutparams1 = null;
            i4 = 0;
            j4 = 0;
            if(layoutparams1 != null) {
                i4 = ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).rightMargin;
                j4 = ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).bottomMargin;
            }
            if(super.mContentHeight <= 0)
                k4 = 0x80000000;
            else
            if(layoutparams.height != -2)
                k4 = 0x40000000;
            else
                k4 = 0x80000000;
            if(layoutparams.height >= 0)
                i2 = Math.min(layoutparams.height, i2);
            l4 = Math.max(0, i2 - j4);
            if(layoutparams.width != -2)
                i5 = 0x40000000;
            else
                i5 = 0x80000000;
            if(layoutparams.width >= 0)
                j5 = Math.min(layoutparams.width, k2);
            else
                j5 = k2;
            k5 = Math.max(0, j5 - i4);
            if(layoutparams1 != null)
                l5 = layoutparams1.gravity;
            else
                l5 = 19;
            if((l5 & 7) == 1 && layoutparams.width == -1)
                k5 = 2 * Math.min(l2, i3);
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k5, i5), android.view.View.MeasureSpec.makeMeasureSpec(l4, k4));
            k2 -= i4 + view.getMeasuredWidth();
        }
        if(mExpandedActionView == null && flag) {
            measureChildView(mTitleLayout, k2, android.view.View.MeasureSpec.makeMeasureSpec(super.mContentHeight, 0x40000000), 0);
            Math.max(0, l2 - mTitleLayout.getMeasuredWidth());
        }
        if(super.mContentHeight > 0)
            break; /* Loop/switch isn't completed */
        j3 = 0;
        for(k3 = 0; k3 < k; k3++) {
            l3 = j1 + getChildAt(k3).getMeasuredHeight();
            if(l3 > j3)
                j3 = l3;
        }

        break MISSING_BLOCK_LABEL_1218;
_L7:
        if(mListNavLayout != null) {
            if(flag)
                i7 = 2 * mItemPadding;
            else
                i7 = mItemPadding;
            j7 = Math.max(0, k2 - i7);
            k7 = Math.max(0, l2 - i7);
            mListNavLayout.measure(android.view.View.MeasureSpec.makeMeasureSpec(j7, 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x40000000));
            l7 = mListNavLayout.getMeasuredWidth();
            k2 = Math.max(0, j7 - l7);
            l2 = Math.max(0, k7 - l7);
        }
          goto _L5
        if(mTabScrollView != null) {
            if(flag)
                i6 = 2 * mItemPadding;
            else
                i6 = mItemPadding;
            j6 = Math.max(0, k2 - i6);
            k6 = Math.max(0, l2 - i6);
            mTabScrollView.measure(android.view.View.MeasureSpec.makeMeasureSpec(j6, 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x40000000));
            l6 = mTabScrollView.getMeasuredWidth();
            k2 = Math.max(0, j6 - l6);
            l2 = Math.max(0, k6 - l6);
        }
          goto _L5
        setMeasuredDimension(l, j3);
_L11:
        if(mContextView != null)
            mContextView.setContentHeight(getMeasuredHeight());
        if(mProgressView != null && mProgressView.getVisibility() != 8)
            mProgressView.measure(android.view.View.MeasureSpec.makeMeasureSpec(l - 2 * mProgressBarPadding, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0x80000000));
        if(true) goto _L10; else goto _L9
_L9:
        setMeasuredDimension(l, i1);
          goto _L11
        if(true) goto _L10; else goto _L12
_L12:
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if(savedstate.expandedMenuItemId != 0 && mExpandedMenuPresenter != null && mOptionsMenu != null) {
            MenuItem menuitem = mOptionsMenu.findItem(savedstate.expandedMenuItemId);
            if(menuitem != null)
                menuitem.expandActionView();
        }
        if(savedstate.isOverflowOpen)
            postShowOverflowMenu();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if(mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null)
            savedstate.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        savedstate.isOverflowOpen = isOverflowMenuShowing();
        return savedstate;
    }

    public void setCallback(android.app.ActionBar.OnNavigationListener onnavigationlistener) {
        mCallback = onnavigationlistener;
    }

    public void setCollapsable(boolean flag) {
        mIsCollapsable = flag;
    }

    public void setContextView(ActionBarContextView actionbarcontextview) {
        mContextView = actionbarcontextview;
    }

    public void setCustomNavigationView(View view) {
        boolean flag;
        if((0x10 & mDisplayOptions) != 0)
            flag = true;
        else
            flag = false;
        if(mCustomNavView != null && flag)
            removeView(mCustomNavView);
        mCustomNavView = view;
        if(mCustomNavView != null && flag)
            addView(mCustomNavView);
    }

    public void setDisplayOptions(int i) {
        byte byte0 = 8;
        int j = -1;
        boolean flag = true;
        if(mDisplayOptions != j)
            j = i ^ mDisplayOptions;
        mDisplayOptions = i;
        if((j & 0x1f) != 0) {
            boolean flag1;
            int k;
            if((i & 2) != 0)
                flag1 = flag;
            else
                flag1 = false;
            if(flag1 && mExpandedActionView == null)
                k = 0;
            else
                k = byte0;
            mHomeLayout.setVisibility(k);
            if((j & 4) != 0) {
                View view;
                LinearLayout linearlayout;
                LinearLayout linearlayout1;
                HomeView homeview;
                boolean flag5;
                if((i & 4) != 0)
                    flag5 = flag;
                else
                    flag5 = false;
                mHomeLayout.setUp(flag5);
                if(flag5)
                    setHomeButtonEnabled(flag);
            }
            if((j & 1) != 0) {
                boolean flag4;
                Drawable drawable;
                if(mLogo != null && (i & 1) != 0)
                    flag4 = flag;
                else
                    flag4 = false;
                homeview = mHomeLayout;
                if(flag4)
                    drawable = mLogo;
                else
                    drawable = mIcon;
                homeview.setIcon(drawable);
            }
            if((j & 8) != 0)
                if((i & 8) != 0)
                    initTitle();
                else
                    removeView(mTitleLayout);
            if(mTitleLayout != null && (j & 6) != 0) {
                boolean flag2;
                boolean flag3;
                if((4 & mDisplayOptions) != 0)
                    flag2 = flag;
                else
                    flag2 = false;
                view = mTitleUpView;
                if(!flag1)
                    if(flag2)
                        byte0 = 0;
                    else
                        byte0 = 4;
                view.setVisibility(byte0);
                linearlayout = mTitleLayout;
                if(!flag1 && flag2)
                    flag3 = flag;
                else
                    flag3 = false;
                linearlayout.setEnabled(flag3);
                linearlayout1 = mTitleLayout;
                if(flag1 || !flag2)
                    flag = false;
                linearlayout1.setClickable(flag);
            }
            if((j & 0x10) != 0 && mCustomNavView != null)
                if((i & 0x10) != 0)
                    addView(mCustomNavView);
                else
                    removeView(mCustomNavView);
            requestLayout();
        } else {
            invalidate();
        }
        if(!mHomeLayout.isEnabled())
            mHomeLayout.setContentDescription(null);
        else
        if((i & 4) != 0)
            mHomeLayout.setContentDescription(super.mContext.getResources().getText(0x10404d1));
        else
            mHomeLayout.setContentDescription(super.mContext.getResources().getText(0x10404d0));
    }

    public void setDropdownAdapter(SpinnerAdapter spinneradapter) {
        mSpinnerAdapter = spinneradapter;
        if(mSpinner != null)
            mSpinner.setAdapter(spinneradapter);
    }

    public void setDropdownSelectedPosition(int i) {
        mSpinner.setSelection(i);
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingtabcontainerview) {
        if(mTabScrollView != null)
            removeView(mTabScrollView);
        mTabScrollView = scrollingtabcontainerview;
        boolean flag;
        if(scrollingtabcontainerview != null)
            flag = true;
        else
            flag = false;
        mIncludeTabs = flag;
        if(mIncludeTabs && mNavigationMode == 2) {
            addView(mTabScrollView);
            android.view.ViewGroup.LayoutParams layoutparams = mTabScrollView.getLayoutParams();
            layoutparams.width = -2;
            layoutparams.height = -1;
            scrollingtabcontainerview.setAllowCollapse(true);
        }
    }

    public void setHomeButtonEnabled(boolean flag) {
        mHomeLayout.setEnabled(flag);
        mHomeLayout.setFocusable(flag);
        if(!flag)
            mHomeLayout.setContentDescription(null);
        else
        if((4 & mDisplayOptions) != 0)
            mHomeLayout.setContentDescription(super.mContext.getResources().getText(0x10404d1));
        else
            mHomeLayout.setContentDescription(super.mContext.getResources().getText(0x10404d0));
    }

    public void setIcon(int i) {
        setIcon(super.mContext.getResources().getDrawable(i));
    }

    public void setIcon(Drawable drawable) {
        mIcon = drawable;
        if(drawable != null && ((1 & mDisplayOptions) == 0 || mLogo == null))
            mHomeLayout.setIcon(drawable);
        if(mExpandedActionView != null)
            mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
    }

    public void setLogo(int i) {
        setLogo(super.mContext.getResources().getDrawable(i));
    }

    public void setLogo(Drawable drawable) {
        mLogo = drawable;
        if(drawable != null && (1 & mDisplayOptions) != 0)
            mHomeLayout.setIcon(drawable);
    }

    public void setMenu(Menu menu, com.android.internal.view.menu.MenuPresenter.Callback callback) {
        if(menu != mOptionsMenu) goto _L2; else goto _L1
_L1:
        return;
_L2:
        MenuBuilder menubuilder;
        android.view.ViewGroup.LayoutParams layoutparams;
        ActionMenuView actionmenuview;
        if(mOptionsMenu != null) {
            mOptionsMenu.removeMenuPresenter(super.mActionMenuPresenter);
            mOptionsMenu.removeMenuPresenter(mExpandedMenuPresenter);
        }
        menubuilder = (MenuBuilder)menu;
        mOptionsMenu = menubuilder;
        if(super.mMenuView != null) {
            ViewGroup viewgroup2 = (ViewGroup)super.mMenuView.getParent();
            if(viewgroup2 != null)
                viewgroup2.removeView(super.mMenuView);
        }
        if(super.mActionMenuPresenter == null) {
            super.mActionMenuPresenter = new ActionMenuPresenter(super.mContext);
            super.mActionMenuPresenter.setCallback(callback);
            super.mActionMenuPresenter.setId(0x102023f);
            mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
        }
        layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
        if(super.mSplitActionBar)
            break; /* Loop/switch isn't completed */
        super.mActionMenuPresenter.setExpandedActionViewsExclusive(getResources().getBoolean(0x1110005));
        configPresenters(menubuilder);
        actionmenuview = (ActionMenuView)super.mActionMenuPresenter.getMenuView(this);
        ViewGroup viewgroup1 = (ViewGroup)actionmenuview.getParent();
        if(viewgroup1 != null && viewgroup1 != this)
            viewgroup1.removeView(actionmenuview);
        addView(actionmenuview, layoutparams);
_L4:
        super.mMenuView = actionmenuview;
        if(true) goto _L1; else goto _L3
_L3:
        super.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
        super.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
        super.mActionMenuPresenter.setItemLimit(0x7fffffff);
        layoutparams.width = -1;
        configPresenters(menubuilder);
        actionmenuview = (ActionMenuView)super.mActionMenuPresenter.getMenuView(this);
        if(super.mSplitView != null) {
            ViewGroup viewgroup = (ViewGroup)actionmenuview.getParent();
            if(viewgroup != null && viewgroup != super.mSplitView)
                viewgroup.removeView(actionmenuview);
            actionmenuview.setVisibility(getAnimatedVisibility());
            super.mSplitView.addView(actionmenuview, layoutparams);
        } else {
            actionmenuview.setLayoutParams(layoutparams);
        }
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void setNavigationMode(int i) {
        int j = mNavigationMode;
        if(i == j) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 66
    //                   2 84;
           goto _L3 _L4 _L5
_L3:
        i;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 109
    //                   2 231;
           goto _L6 _L7 _L8
_L6:
        mNavigationMode = i;
        requestLayout();
_L2:
        return;
_L4:
        if(mListNavLayout != null)
            removeView(mListNavLayout);
          goto _L3
_L5:
        if(mTabScrollView != null && mIncludeTabs)
            removeView(mTabScrollView);
          goto _L3
_L7:
        if(mSpinner == null) {
            mSpinner = new Spinner(super.mContext, null, 0x10102d7);
            mListNavLayout = new LinearLayout(super.mContext, null, 0x10102f4);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -1);
            layoutparams.gravity = 17;
            mListNavLayout.addView(mSpinner, layoutparams);
        }
        if(mSpinner.getAdapter() != mSpinnerAdapter)
            mSpinner.setAdapter(mSpinnerAdapter);
        mSpinner.setOnItemSelectedListener(mNavItemSelectedListener);
        addView(mListNavLayout);
          goto _L6
_L8:
        if(mTabScrollView != null && mIncludeTabs)
            addView(mTabScrollView);
          goto _L6
    }

    public void setSplitActionBar(boolean flag) {
        if(super.mSplitActionBar != flag) {
            if(super.mMenuView != null) {
                ViewGroup viewgroup = (ViewGroup)super.mMenuView.getParent();
                if(viewgroup != null)
                    viewgroup.removeView(super.mMenuView);
                ActionBarContainer actionbarcontainer;
                if(flag) {
                    if(super.mSplitView != null)
                        super.mSplitView.addView(super.mMenuView);
                    super.mMenuView.getLayoutParams().width = -1;
                } else {
                    addView(super.mMenuView);
                    super.mMenuView.getLayoutParams().width = -2;
                }
                super.mMenuView.requestLayout();
            }
            if(super.mSplitView != null) {
                actionbarcontainer = super.mSplitView;
                int i;
                if(flag)
                    i = 0;
                else
                    i = 8;
                actionbarcontainer.setVisibility(i);
            }
            if(super.mActionMenuPresenter != null)
                if(!flag) {
                    super.mActionMenuPresenter.setExpandedActionViewsExclusive(getResources().getBoolean(0x1110005));
                } else {
                    super.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
                    super.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    super.mActionMenuPresenter.setItemLimit(0x7fffffff);
                }
            super.setSplitActionBar(flag);
        }
    }

    public void setSubtitle(CharSequence charsequence) {
        int i = 0;
        mSubtitle = charsequence;
        if(mSubtitleView != null) {
            mSubtitleView.setText(charsequence);
            TextView textview = mSubtitleView;
            int j;
            boolean flag;
            LinearLayout linearlayout;
            if(charsequence != null)
                j = 0;
            else
                j = 8;
            textview.setVisibility(j);
            if(mExpandedActionView == null && (8 & mDisplayOptions) != 0 && (!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle)))
                flag = true;
            else
                flag = false;
            linearlayout = mTitleLayout;
            if(!flag)
                i = 8;
            linearlayout.setVisibility(i);
        }
    }

    public void setTitle(CharSequence charsequence) {
        mUserTitle = true;
        setTitleImpl(charsequence);
    }

    public void setWindowCallback(android.view.Window.Callback callback) {
        mWindowCallback = callback;
    }

    public void setWindowTitle(CharSequence charsequence) {
        if(!mUserTitle)
            setTitleImpl(charsequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    private static final int DEFAULT_CUSTOM_GRAVITY = 19;
    public static final int DISPLAY_DEFAULT = 0;
    private static final int DISPLAY_RELAYOUT_MASK = 31;
    private static final int MAX_HOME_SLOP = 32;
    private static final String TAG = "ActionBarView";
    private android.app.ActionBar.OnNavigationListener mCallback;
    private ActionBarContextView mContextView;
    private View mCustomNavView;
    private int mDisplayOptions;
    View mExpandedActionView;
    private final android.view.View.OnClickListener mExpandedActionViewUpListener = new android.view.View.OnClickListener() {

        public void onClick(View view) {
            MenuItemImpl menuitemimpl = mExpandedMenuPresenter.mCurrentExpandedItem;
            if(menuitemimpl != null)
                menuitemimpl.collapseActionView();
        }

        final ActionBarView this$0;

             {
                this$0 = ActionBarView.this;
                super();
            }
    };
    private HomeView mExpandedHomeLayout;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private HomeView mHomeLayout;
    private Drawable mIcon;
    private boolean mIncludeTabs;
    private int mIndeterminateProgressStyle;
    private ProgressBar mIndeterminateProgressView;
    private boolean mIsCollapsable;
    private boolean mIsCollapsed;
    private int mItemPadding;
    private LinearLayout mListNavLayout;
    private Drawable mLogo;
    private ActionMenuItem mLogoNavItem;
    private int mMaxHomeSlop;
    private final android.widget.AdapterView.OnItemSelectedListener mNavItemSelectedListener = new android.widget.AdapterView.OnItemSelectedListener() {

        public void onItemSelected(AdapterView adapterview, View view, int k, long l) {
            if(mCallback != null)
                mCallback.onNavigationItemSelected(k, l);
        }

        public void onNothingSelected(AdapterView adapterview) {
        }

        final ActionBarView this$0;

             {
                this$0 = ActionBarView.this;
                super();
            }
    };
    private int mNavigationMode;
    private MenuBuilder mOptionsMenu;
    private int mProgressBarPadding;
    private int mProgressStyle;
    private ProgressBar mProgressView;
    private Spinner mSpinner;
    private SpinnerAdapter mSpinnerAdapter;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private ScrollingTabContainerView mTabScrollView;
    private Runnable mTabSelector;
    private final Rect mTempRect = new Rect();
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private int mTitleStyleRes;
    private View mTitleUpView;
    private TextView mTitleView;
    private final android.view.View.OnClickListener mUpClickListener = new android.view.View.OnClickListener() {

        public void onClick(View view) {
            mWindowCallback.onMenuItemSelected(0, mLogoNavItem);
        }

        final ActionBarView this$0;

             {
                this$0 = ActionBarView.this;
                super();
            }
    };
    private boolean mUserTitle;
    android.view.Window.Callback mWindowCallback;













}
