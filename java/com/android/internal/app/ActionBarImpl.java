// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.animation.*;
import android.app.*;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.widget.SpinnerAdapter;
import com.android.internal.view.ActionBarPolicy;
import com.android.internal.view.menu.*;
import com.android.internal.widget.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarImpl extends ActionBar {
    public class TabImpl extends android.app.ActionBar.Tab {

        public android.app.ActionBar.TabListener getCallback() {
            return mCallback;
        }

        public CharSequence getContentDescription() {
            return mContentDesc;
        }

        public View getCustomView() {
            return mCustomView;
        }

        public Drawable getIcon() {
            return mIcon;
        }

        public int getPosition() {
            return mPosition;
        }

        public Object getTag() {
            return mTag;
        }

        public CharSequence getText() {
            return mText;
        }

        public void select() {
            selectTab(this);
        }

        public android.app.ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(mContext.getResources().getText(i));
        }

        public android.app.ActionBar.Tab setContentDescription(CharSequence charsequence) {
            mContentDesc = charsequence;
            if(mPosition >= 0)
                mTabScrollView.updateTab(mPosition);
            return this;
        }

        public android.app.ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, null));
        }

        public android.app.ActionBar.Tab setCustomView(View view) {
            mCustomView = view;
            if(mPosition >= 0)
                mTabScrollView.updateTab(mPosition);
            return this;
        }

        public android.app.ActionBar.Tab setIcon(int i) {
            return setIcon(mContext.getResources().getDrawable(i));
        }

        public android.app.ActionBar.Tab setIcon(Drawable drawable) {
            mIcon = drawable;
            if(mPosition >= 0)
                mTabScrollView.updateTab(mPosition);
            return this;
        }

        public void setPosition(int i) {
            mPosition = i;
        }

        public android.app.ActionBar.Tab setTabListener(android.app.ActionBar.TabListener tablistener) {
            mCallback = tablistener;
            return this;
        }

        public android.app.ActionBar.Tab setTag(Object obj) {
            mTag = obj;
            return this;
        }

        public android.app.ActionBar.Tab setText(int i) {
            return setText(mContext.getResources().getText(i));
        }

        public android.app.ActionBar.Tab setText(CharSequence charsequence) {
            mText = charsequence;
            if(mPosition >= 0)
                mTabScrollView.updateTab(mPosition);
            return this;
        }

        private android.app.ActionBar.TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition;
        private Object mTag;
        private CharSequence mText;
        final ActionBarImpl this$0;

        public TabImpl() {
            this$0 = ActionBarImpl.this;
            super();
            mPosition = -1;
        }
    }

    public class ActionModeImpl extends ActionMode
        implements com.android.internal.view.menu.MenuBuilder.Callback {

        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            boolean flag = mCallback.onCreateActionMode(this, mMenu);
            mMenu.startDispatchingItemsChanged();
            return flag;
            Exception exception;
            exception;
            mMenu.startDispatchingItemsChanged();
            throw exception;
        }

        public void finish() {
            if(mActionMode == this) {
                if(!ActionBarImpl.checkShowingFlags(mHiddenByApp, mHiddenBySystem, false)) {
                    mDeferredDestroyActionMode = this;
                    mDeferredModeDestroyCallback = mCallback;
                } else {
                    mCallback.onDestroyActionMode(this);
                }
                mCallback = null;
                animateToMode(false);
                mContextView.closeMode();
                mActionView.sendAccessibilityEvent(32);
                mActionMode = null;
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
            return new MenuInflater(getThemedContext());
        }

        public CharSequence getSubtitle() {
            return mContextView.getSubtitle();
        }

        public CharSequence getTitle() {
            return mContextView.getTitle();
        }

        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            mCallback.onPrepareActionMode(this, mMenu);
            mMenu.startDispatchingItemsChanged();
            return;
            Exception exception;
            exception;
            mMenu.startDispatchingItemsChanged();
            throw exception;
        }

        public boolean isTitleOptional() {
            return mContextView.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
        }

        public void onCloseSubMenu(SubMenuBuilder submenubuilder) {
        }

        public boolean onMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem) {
            boolean flag;
            if(mCallback != null)
                flag = mCallback.onActionItemClicked(this, menuitem);
            else
                flag = false;
            return flag;
        }

        public void onMenuModeChange(MenuBuilder menubuilder) {
            if(mCallback != null) {
                invalidate();
                mContextView.showOverflowMenu();
            }
        }

        public boolean onSubMenuSelected(SubMenuBuilder submenubuilder) {
            boolean flag = true;
            if(mCallback != null) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            if(submenubuilder.hasVisibleItems())
                (new MenuPopupHelper(getThemedContext(), submenubuilder)).show();
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void setCustomView(View view) {
            mContextView.setCustomView(view);
            mCustomView = new WeakReference(view);
        }

        public void setSubtitle(int i) {
            setSubtitle(((CharSequence) (mContext.getResources().getString(i))));
        }

        public void setSubtitle(CharSequence charsequence) {
            mContextView.setSubtitle(charsequence);
        }

        public void setTitle(int i) {
            setTitle(((CharSequence) (mContext.getResources().getString(i))));
        }

        public void setTitle(CharSequence charsequence) {
            mContextView.setTitle(charsequence);
        }

        public void setTitleOptionalHint(boolean flag) {
            super.setTitleOptionalHint(flag);
            mContextView.setTitleOptional(flag);
        }

        private android.view.ActionMode.Callback mCallback;
        private WeakReference mCustomView;
        private MenuBuilder mMenu;
        final ActionBarImpl this$0;

        public ActionModeImpl(android.view.ActionMode.Callback callback) {
            this$0 = ActionBarImpl.this;
            super();
            mCallback = callback;
            mMenu = (new MenuBuilder(getThemedContext())).setDefaultShowAsAction(1);
            mMenu.setCallback(this);
        }
    }


    public ActionBarImpl(Activity activity) {
        mTabs = new ArrayList();
        mSavedTabPosition = -1;
        mMenuVisibilityListeners = new ArrayList();
        mHandler = new Handler();
        mCurWindowVisibility = 0;
        mNowShowing = true;
        mHideListener = new AnimatorListenerAdapter() {

            public void onAnimationEnd(Animator animator) {
                if(mContentView != null) {
                    mContentView.setTranslationY(0.0F);
                    mTopVisibilityView.setTranslationY(0.0F);
                }
                if(mSplitView != null && mContextDisplayMode == 1)
                    mSplitView.setVisibility(8);
                mTopVisibilityView.setVisibility(8);
                mContainerView.setTransitioning(false);
                mCurrentShowAnim = null;
                completeDeferredDestroyActionMode();
                if(mOverlayLayout != null)
                    mOverlayLayout.requestFitSystemWindows();
            }

            final ActionBarImpl this$0;

             {
                this$0 = ActionBarImpl.this;
                super();
            }
        };
        mShowListener = new AnimatorListenerAdapter() {

            public void onAnimationEnd(Animator animator) {
                mCurrentShowAnim = null;
                mTopVisibilityView.requestLayout();
            }

            final ActionBarImpl this$0;

             {
                this$0 = ActionBarImpl.this;
                super();
            }
        };
        mActivity = activity;
        View view = activity.getWindow().getDecorView();
        init(view);
        if(!mActivity.getWindow().hasFeature(9))
            mContentView = view.findViewById(0x1020002);
    }

    public ActionBarImpl(Dialog dialog) {
        mTabs = new ArrayList();
        mSavedTabPosition = -1;
        mMenuVisibilityListeners = new ArrayList();
        mHandler = new Handler();
        mCurWindowVisibility = 0;
        mNowShowing = true;
        mHideListener = new _cls1();
        mShowListener = new _cls2();
        mDialog = dialog;
        init(dialog.getWindow().getDecorView());
    }

    private static boolean checkShowingFlags(boolean flag, boolean flag1, boolean flag2) {
        boolean flag3;
        flag3 = true;
        break MISSING_BLOCK_LABEL_2;
        if(!flag2 && (flag || flag1))
            flag3 = false;
        return flag3;
    }

    private void cleanupTabs() {
        if(mSelectedTab != null)
            selectTab(null);
        mTabs.clear();
        if(mTabScrollView != null)
            mTabScrollView.removeAllTabs();
        mSavedTabPosition = -1;
    }

    private void configureTab(android.app.ActionBar.Tab tab, int i) {
        TabImpl tabimpl = (TabImpl)tab;
        if(tabimpl.getCallback() == null)
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        tabimpl.setPosition(i);
        mTabs.add(i, tabimpl);
        int j = mTabs.size();
        for(int k = i + 1; k < j; k++)
            ((TabImpl)mTabs.get(k)).setPosition(k);

    }

    private void ensureTabsExist() {
        if(mTabScrollView == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ScrollingTabContainerView scrollingtabcontainerview;
        scrollingtabcontainerview = new ScrollingTabContainerView(mContext);
        if(!mHasEmbeddedTabs)
            break; /* Loop/switch isn't completed */
        scrollingtabcontainerview.setVisibility(0);
        mActionView.setEmbeddedTabView(scrollingtabcontainerview);
_L4:
        mTabScrollView = scrollingtabcontainerview;
        if(true) goto _L1; else goto _L3
_L3:
        if(getNavigationMode() == 2) {
            scrollingtabcontainerview.setVisibility(0);
            if(mOverlayLayout != null)
                mOverlayLayout.requestFitSystemWindows();
        } else {
            scrollingtabcontainerview.setVisibility(8);
        }
        mContainerView.setTabContainer(scrollingtabcontainerview);
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    private void hideForActionMode() {
        if(mShowingForMode) {
            mShowingForMode = false;
            if(mOverlayLayout != null)
                mOverlayLayout.setShowingForActionMode(false);
            updateVisibility(false);
        }
    }

    private void init(View view) {
        boolean flag = false;
        mContext = view.getContext();
        mOverlayLayout = (ActionBarOverlayLayout)view.findViewById(0x1020322);
        if(mOverlayLayout != null)
            mOverlayLayout.setActionBar(this);
        mActionView = (ActionBarView)view.findViewById(0x102031f);
        mContextView = (ActionBarContextView)view.findViewById(0x1020320);
        mContainerView = (ActionBarContainer)view.findViewById(0x102031e);
        mTopVisibilityView = (ViewGroup)view.findViewById(0x1020323);
        if(mTopVisibilityView == null)
            mTopVisibilityView = mContainerView;
        mSplitView = (ActionBarContainer)view.findViewById(0x1020321);
        if(mActionView == null || mContextView == null || mContainerView == null)
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with a compatible window decor layout").toString());
        mActionView.setContextView(mContextView);
        int i;
        boolean flag1;
        ActionBarPolicy actionbarpolicy;
        if(mActionView.isSplitActionBar())
            i = 1;
        else
            i = 0;
        mContextDisplayMode = i;
        if((4 & mActionView.getDisplayOptions()) != 0)
            flag1 = true;
        else
            flag1 = false;
        if(flag1)
            mDisplayHomeAsUpSet = true;
        actionbarpolicy = ActionBarPolicy.get(mContext);
        if(actionbarpolicy.enableHomeButtonByDefault() || flag1)
            flag = true;
        setHomeButtonEnabled(flag);
        setHasEmbeddedTabs(actionbarpolicy.hasEmbeddedTabs());
    }

    private void setHasEmbeddedTabs(boolean flag) {
        boolean flag1 = true;
        mHasEmbeddedTabs = flag;
        boolean flag2;
        ActionBarView actionbarview;
        if(!mHasEmbeddedTabs) {
            mActionView.setEmbeddedTabView(null);
            mContainerView.setTabContainer(mTabScrollView);
        } else {
            mContainerView.setTabContainer(null);
            mActionView.setEmbeddedTabView(mTabScrollView);
        }
        if(getNavigationMode() == 2)
            flag2 = flag1;
        else
            flag2 = false;
        if(mTabScrollView != null)
            if(flag2) {
                mTabScrollView.setVisibility(0);
                if(mOverlayLayout != null)
                    mOverlayLayout.requestFitSystemWindows();
            } else {
                mTabScrollView.setVisibility(8);
            }
        actionbarview = mActionView;
        if(mHasEmbeddedTabs || !flag2)
            flag1 = false;
        actionbarview.setCollapsable(flag1);
    }

    private void showForActionMode() {
        if(!mShowingForMode) {
            mShowingForMode = true;
            if(mOverlayLayout != null)
                mOverlayLayout.setShowingForActionMode(true);
            updateVisibility(false);
        }
    }

    private void updateVisibility(boolean flag) {
        if(!checkShowingFlags(mHiddenByApp, mHiddenBySystem, mShowingForMode)) goto _L2; else goto _L1
_L1:
        if(!mNowShowing) {
            mNowShowing = true;
            doShow(flag);
        }
_L4:
        return;
_L2:
        if(mNowShowing) {
            mNowShowing = false;
            doHide(flag);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void addOnMenuVisibilityListener(android.app.ActionBar.OnMenuVisibilityListener onmenuvisibilitylistener) {
        mMenuVisibilityListeners.add(onmenuvisibilitylistener);
    }

    public void addTab(android.app.ActionBar.Tab tab) {
        addTab(tab, mTabs.isEmpty());
    }

    public void addTab(android.app.ActionBar.Tab tab, int i) {
        addTab(tab, i, mTabs.isEmpty());
    }

    public void addTab(android.app.ActionBar.Tab tab, int i, boolean flag) {
        ensureTabsExist();
        mTabScrollView.addTab(tab, i, flag);
        configureTab(tab, i);
        if(flag)
            selectTab(tab);
    }

    public void addTab(android.app.ActionBar.Tab tab, boolean flag) {
        ensureTabsExist();
        mTabScrollView.addTab(tab, flag);
        configureTab(tab, mTabs.size());
        if(flag)
            selectTab(tab);
    }

    void animateToMode(boolean flag) {
        byte byte0 = 8;
        ActionBarView actionbarview;
        byte byte1;
        ActionBarContextView actionbarcontextview;
        int i;
        if(flag)
            showForActionMode();
        else
            hideForActionMode();
        actionbarview = mActionView;
        if(flag)
            byte1 = byte0;
        else
            byte1 = 0;
        actionbarview.animateToVisibility(byte1);
        actionbarcontextview = mContextView;
        if(flag)
            i = 0;
        else
            i = byte0;
        actionbarcontextview.animateToVisibility(i);
        if(mTabScrollView != null && !mActionView.hasEmbeddedTabs() && mActionView.isCollapsed()) {
            ScrollingTabContainerView scrollingtabcontainerview = mTabScrollView;
            if(!flag)
                byte0 = 0;
            scrollingtabcontainerview.animateToVisibility(byte0);
        }
    }

    void completeDeferredDestroyActionMode() {
        if(mDeferredModeDestroyCallback != null) {
            mDeferredModeDestroyCallback.onDestroyActionMode(mDeferredDestroyActionMode);
            mDeferredDestroyActionMode = null;
            mDeferredModeDestroyCallback = null;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean flag) {
        if(flag != mLastMenuVisibility) {
            mLastMenuVisibility = flag;
            int i = mMenuVisibilityListeners.size();
            int j = 0;
            while(j < i)  {
                ((android.app.ActionBar.OnMenuVisibilityListener)mMenuVisibilityListeners.get(j)).onMenuVisibilityChanged(flag);
                j++;
            }
        }
    }

    public void doHide(boolean flag) {
        if(mCurrentShowAnim != null)
            mCurrentShowAnim.end();
        if(mCurWindowVisibility == 0 && (mShowHideAnimationEnabled || flag)) {
            mTopVisibilityView.setAlpha(1.0F);
            mContainerView.setTransitioning(true);
            AnimatorSet animatorset = new AnimatorSet();
            float f = -mTopVisibilityView.getHeight();
            if(flag) {
                int ai[] = new int[2];
                ai[0] = 0;
                ai[1] = 0;
                mTopVisibilityView.getLocationInWindow(ai);
                f -= ai[1];
            }
            ViewGroup viewgroup = mTopVisibilityView;
            float af[] = new float[1];
            af[0] = f;
            android.animation.AnimatorSet.Builder builder = animatorset.play(ObjectAnimator.ofFloat(viewgroup, "translationY", af));
            if(mContentView != null) {
                View view = mContentView;
                float af2[] = new float[2];
                af2[0] = 0.0F;
                af2[1] = f;
                builder.with(ObjectAnimator.ofFloat(view, "translationY", af2));
            }
            if(mSplitView != null && mSplitView.getVisibility() == 0) {
                mSplitView.setAlpha(1.0F);
                ActionBarContainer actionbarcontainer = mSplitView;
                float af1[] = new float[1];
                af1[0] = mSplitView.getHeight();
                builder.with(ObjectAnimator.ofFloat(actionbarcontainer, "translationY", af1));
            }
            animatorset.setInterpolator(AnimationUtils.loadInterpolator(mContext, 0x10c0002));
            animatorset.setDuration(250L);
            animatorset.addListener(mHideListener);
            mCurrentShowAnim = animatorset;
            animatorset.start();
        } else {
            mHideListener.onAnimationEnd(null);
        }
    }

    public void doShow(boolean flag) {
        if(mCurrentShowAnim != null)
            mCurrentShowAnim.end();
        mTopVisibilityView.setVisibility(0);
        if(mCurWindowVisibility == 0 && (mShowHideAnimationEnabled || flag)) {
            mTopVisibilityView.setTranslationY(0.0F);
            float f = -mTopVisibilityView.getHeight();
            if(flag) {
                int ai[] = new int[2];
                ai[0] = 0;
                ai[1] = 0;
                mTopVisibilityView.getLocationInWindow(ai);
                f -= ai[1];
            }
            mTopVisibilityView.setTranslationY(f);
            AnimatorSet animatorset = new AnimatorSet();
            ViewGroup viewgroup = mTopVisibilityView;
            float af[] = new float[1];
            af[0] = 0.0F;
            android.animation.AnimatorSet.Builder builder = animatorset.play(ObjectAnimator.ofFloat(viewgroup, "translationY", af));
            if(mContentView != null) {
                View view = mContentView;
                float af2[] = new float[2];
                af2[0] = f;
                af2[1] = 0.0F;
                builder.with(ObjectAnimator.ofFloat(view, "translationY", af2));
            }
            if(mSplitView != null && mContextDisplayMode == 1) {
                mSplitView.setTranslationY(mSplitView.getHeight());
                mSplitView.setVisibility(0);
                ActionBarContainer actionbarcontainer = mSplitView;
                float af1[] = new float[1];
                af1[0] = 0.0F;
                builder.with(ObjectAnimator.ofFloat(actionbarcontainer, "translationY", af1));
            }
            animatorset.setInterpolator(AnimationUtils.loadInterpolator(mContext, 0x10c0003));
            animatorset.setDuration(250L);
            animatorset.addListener(mShowListener);
            mCurrentShowAnim = animatorset;
            animatorset.start();
        } else {
            mTopVisibilityView.setAlpha(1.0F);
            mTopVisibilityView.setTranslationY(0.0F);
            if(mContentView != null)
                mContentView.setTranslationY(0.0F);
            if(mSplitView != null && mContextDisplayMode == 1) {
                mSplitView.setAlpha(1.0F);
                mSplitView.setTranslationY(0.0F);
                mSplitView.setVisibility(0);
            }
            mShowListener.onAnimationEnd(null);
        }
        if(mOverlayLayout != null)
            mOverlayLayout.requestFitSystemWindows();
    }

    public View getCustomView() {
        return mActionView.getCustomNavigationView();
    }

    public int getDisplayOptions() {
        return mActionView.getDisplayOptions();
    }

    public int getHeight() {
        return mContainerView.getHeight();
    }

    public int getNavigationItemCount() {
        int i = 0;
        mActionView.getNavigationMode();
        JVM INSTR tableswitch 1 2: default 32
    //                   1 45
    //                   2 34;
           goto _L1 _L2 _L3
_L1:
        return i;
_L3:
        i = mTabs.size();
        continue; /* Loop/switch isn't completed */
_L2:
        SpinnerAdapter spinneradapter = mActionView.getDropdownAdapter();
        if(spinneradapter != null)
            i = spinneradapter.getCount();
        if(true) goto _L1; else goto _L4
_L4:
    }

    public int getNavigationMode() {
        return mActionView.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        int i = -1;
        mActionView.getNavigationMode();
        JVM INSTR tableswitch 1 2: default 32
    //                   1 52
    //                   2 34;
           goto _L1 _L2 _L3
_L1:
        return i;
_L3:
        if(mSelectedTab != null)
            i = mSelectedTab.getPosition();
        continue; /* Loop/switch isn't completed */
_L2:
        i = mActionView.getDropdownSelectedPosition();
        if(true) goto _L1; else goto _L4
_L4:
    }

    public android.app.ActionBar.Tab getSelectedTab() {
        return mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return mActionView.getSubtitle();
    }

    public android.app.ActionBar.Tab getTabAt(int i) {
        return (android.app.ActionBar.Tab)mTabs.get(i);
    }

    public int getTabCount() {
        return mTabs.size();
    }

    public Context getThemedContext() {
        if(mThemedContext == null) {
            TypedValue typedvalue = new TypedValue();
            mContext.getTheme().resolveAttribute(0x1010397, typedvalue, true);
            int i = typedvalue.resourceId;
            if(i != 0 && mContext.getThemeResId() != i)
                mThemedContext = new ContextThemeWrapper(mContext, i);
            else
                mThemedContext = mContext;
        }
        return mThemedContext;
    }

    public CharSequence getTitle() {
        return mActionView.getTitle();
    }

    public boolean hasNonEmbeddedTabs() {
        boolean flag;
        if(!mHasEmbeddedTabs && getNavigationMode() == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void hide() {
        if(!mHiddenByApp) {
            mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    public void hideForSystem() {
        if(!mHiddenBySystem) {
            mHiddenBySystem = true;
            updateVisibility(true);
        }
    }

    public boolean isShowing() {
        return mNowShowing;
    }

    public boolean isSystemShowing() {
        boolean flag;
        if(!mHiddenBySystem)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public android.app.ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(ActionBarPolicy.get(mContext).hasEmbeddedTabs());
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(android.app.ActionBar.OnMenuVisibilityListener onmenuvisibilitylistener) {
        mMenuVisibilityListeners.remove(onmenuvisibilitylistener);
    }

    public void removeTab(android.app.ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if(mTabScrollView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        TabImpl tabimpl;
        int k;
        if(mSelectedTab != null)
            j = mSelectedTab.getPosition();
        else
            j = mSavedTabPosition;
        mTabScrollView.removeTabAt(i);
        tabimpl = (TabImpl)mTabs.remove(i);
        if(tabimpl != null)
            tabimpl.setPosition(-1);
        k = mTabs.size();
        for(int l = i; l < k; l++)
            ((TabImpl)mTabs.get(l)).setPosition(l);

        if(j == i) {
            Object obj;
            if(mTabs.isEmpty())
                obj = null;
            else
                obj = (TabImpl)mTabs.get(Math.max(0, i - 1));
            selectTab(((android.app.ActionBar.Tab) (obj)));
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void selectTab(android.app.ActionBar.Tab tab) {
        int i = -1;
        if(getNavigationMode() == 2) goto _L2; else goto _L1
_L1:
        if(tab != null)
            i = tab.getPosition();
        mSavedTabPosition = i;
_L4:
        return;
_L2:
        FragmentTransaction fragmenttransaction;
        fragmenttransaction = mActivity.getFragmentManager().beginTransaction().disallowAddToBackStack();
        if(mSelectedTab != tab)
            break; /* Loop/switch isn't completed */
        if(mSelectedTab != null) {
            mSelectedTab.getCallback().onTabReselected(mSelectedTab, fragmenttransaction);
            mTabScrollView.animateToTab(tab.getPosition());
        }
_L5:
        if(!fragmenttransaction.isEmpty())
            fragmenttransaction.commit();
        if(true) goto _L4; else goto _L3
_L3:
        ScrollingTabContainerView scrollingtabcontainerview = mTabScrollView;
        if(tab != null)
            i = tab.getPosition();
        scrollingtabcontainerview.setTabSelected(i);
        if(mSelectedTab != null)
            mSelectedTab.getCallback().onTabUnselected(mSelectedTab, fragmenttransaction);
        mSelectedTab = (TabImpl)tab;
        if(mSelectedTab != null)
            mSelectedTab.getCallback().onTabSelected(mSelectedTab, fragmenttransaction);
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void setBackgroundDrawable(Drawable drawable) {
        mContainerView.setPrimaryBackground(drawable);
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, mActionView, false));
    }

    public void setCustomView(View view) {
        mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(View view, android.app.ActionBar.LayoutParams layoutparams) {
        view.setLayoutParams(layoutparams);
        mActionView.setCustomNavigationView(view);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean flag) {
        if(!mDisplayHomeAsUpSet)
            setDisplayHomeAsUpEnabled(flag);
    }

    public void setDisplayHomeAsUpEnabled(boolean flag) {
        byte byte0;
        if(flag)
            byte0 = 4;
        else
            byte0 = 0;
        setDisplayOptions(byte0, 4);
    }

    public void setDisplayOptions(int i) {
        if((i & 4) != 0)
            mDisplayHomeAsUpSet = true;
        mActionView.setDisplayOptions(i);
    }

    public void setDisplayOptions(int i, int j) {
        int k = mActionView.getDisplayOptions();
        if((j & 4) != 0)
            mDisplayHomeAsUpSet = true;
        mActionView.setDisplayOptions(i & j | k & ~j);
    }

    public void setDisplayShowCustomEnabled(boolean flag) {
        byte byte0;
        if(flag)
            byte0 = 16;
        else
            byte0 = 0;
        setDisplayOptions(byte0, 16);
    }

    public void setDisplayShowHomeEnabled(boolean flag) {
        byte byte0;
        if(flag)
            byte0 = 2;
        else
            byte0 = 0;
        setDisplayOptions(byte0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean flag) {
        byte byte0;
        if(flag)
            byte0 = 8;
        else
            byte0 = 0;
        setDisplayOptions(byte0, 8);
    }

    public void setDisplayUseLogoEnabled(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        setDisplayOptions(i, 1);
    }

    public void setHomeButtonEnabled(boolean flag) {
        mActionView.setHomeButtonEnabled(flag);
    }

    public void setIcon(int i) {
        mActionView.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        mActionView.setIcon(drawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinneradapter, android.app.ActionBar.OnNavigationListener onnavigationlistener) {
        mActionView.setDropdownAdapter(spinneradapter);
        mActionView.setCallback(onnavigationlistener);
    }

    public void setLogo(int i) {
        mActionView.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        mActionView.setLogo(drawable);
    }

    public void setNavigationMode(int i) {
        boolean flag;
        int j;
        flag = false;
        j = mActionView.getNavigationMode();
        j;
        JVM INSTR tableswitch 2 2: default 28
    //                   2 107;
           goto _L1 _L2
_L1:
        if(j != i && !mHasEmbeddedTabs && mOverlayLayout != null)
            mOverlayLayout.requestFitSystemWindows();
        mActionView.setNavigationMode(i);
        i;
        JVM INSTR tableswitch 2 2: default 80
    //                   2 132;
           goto _L3 _L4
_L3:
        ActionBarView actionbarview = mActionView;
        if(i == 2 && !mHasEmbeddedTabs)
            flag = true;
        actionbarview.setCollapsable(flag);
        return;
_L2:
        mSavedTabPosition = getSelectedNavigationIndex();
        selectTab(null);
        mTabScrollView.setVisibility(8);
          goto _L1
_L4:
        ensureTabsExist();
        mTabScrollView.setVisibility(0);
        if(mSavedTabPosition != -1) {
            setSelectedNavigationItem(mSavedTabPosition);
            mSavedTabPosition = -1;
        }
          goto _L3
    }

    public void setSelectedNavigationItem(int i) {
        mActionView.getNavigationMode();
        JVM INSTR tableswitch 1 2: default 28
    //                   1 55
    //                   2 39;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
_L3:
        selectTab((android.app.ActionBar.Tab)mTabs.get(i));
_L5:
        return;
_L2:
        mActionView.setDropdownSelectedPosition(i);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void setShowHideAnimationEnabled(boolean flag) {
        mShowHideAnimationEnabled = flag;
        if(!flag && mCurrentShowAnim != null)
            mCurrentShowAnim.end();
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
        if(mSplitView != null)
            mSplitView.setSplitBackground(drawable);
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        mContainerView.setStackedBackground(drawable);
    }

    public void setSubtitle(int i) {
        setSubtitle(((CharSequence) (mContext.getString(i))));
    }

    public void setSubtitle(CharSequence charsequence) {
        mActionView.setSubtitle(charsequence);
    }

    public void setTitle(int i) {
        setTitle(((CharSequence) (mContext.getString(i))));
    }

    public void setTitle(CharSequence charsequence) {
        mActionView.setTitle(charsequence);
    }

    public void setWindowVisibility(int i) {
        mCurWindowVisibility = i;
    }

    public void show() {
        if(mHiddenByApp) {
            mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    public void showForSystem() {
        if(mHiddenBySystem) {
            mHiddenBySystem = false;
            updateVisibility(true);
        }
    }

    public ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        if(mActionMode != null)
            mActionMode.finish();
        mContextView.killMode();
        ActionModeImpl actionmodeimpl = new ActionModeImpl(callback);
        if(actionmodeimpl.dispatchOnCreate()) {
            actionmodeimpl.invalidate();
            mContextView.initForMode(actionmodeimpl);
            animateToMode(true);
            if(mSplitView != null && mContextDisplayMode == 1 && mSplitView.getVisibility() != 0) {
                mSplitView.setVisibility(0);
                if(mOverlayLayout != null)
                    mOverlayLayout.requestFitSystemWindows();
            }
            mContextView.sendAccessibilityEvent(32);
            mActionMode = actionmodeimpl;
        } else {
            actionmodeimpl = null;
        }
        return actionmodeimpl;
    }

    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "ActionBarImpl";
    ActionModeImpl mActionMode;
    private ActionBarView mActionView;
    private Activity mActivity;
    private ActionBarContainer mContainerView;
    private View mContentView;
    private Context mContext;
    private int mContextDisplayMode;
    private ActionBarContextView mContextView;
    private int mCurWindowVisibility;
    private Animator mCurrentShowAnim;
    ActionMode mDeferredDestroyActionMode;
    android.view.ActionMode.Callback mDeferredModeDestroyCallback;
    private Dialog mDialog;
    private boolean mDisplayHomeAsUpSet;
    final Handler mHandler;
    private boolean mHasEmbeddedTabs;
    private boolean mHiddenByApp;
    private boolean mHiddenBySystem;
    final android.animation.Animator.AnimatorListener mHideListener;
    private boolean mLastMenuVisibility;
    private ArrayList mMenuVisibilityListeners;
    private boolean mNowShowing;
    private ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final android.animation.Animator.AnimatorListener mShowListener;
    private boolean mShowingForMode;
    private ActionBarContainer mSplitView;
    private ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList mTabs;
    private Context mThemedContext;
    private ViewGroup mTopVisibilityView;











/*
    static Animator access$502(ActionBarImpl actionbarimpl, Animator animator) {
        actionbarimpl.mCurrentShowAnim = animator;
        return animator;
    }

*/




}
