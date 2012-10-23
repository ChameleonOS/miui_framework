// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.animation.*;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.*;
import com.android.internal.view.ActionBarPolicy;

// Referenced classes of package com.android.internal.widget:
//            MiuiTabLayout

public class ScrollingTabContainerView extends HorizontalScrollView
    implements android.widget.AdapterView.OnItemClickListener {
    protected class VisibilityAnimListener
        implements android.animation.Animator.AnimatorListener {

        public void onAnimationCancel(Animator animator) {
            mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if(!mCanceled) {
                mVisibilityAnim = null;
                setVisibility(mFinalVisibility);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            setVisibility(0);
            mVisibilityAnim = animator;
            mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(int i) {
            mFinalVisibility = i;
            return this;
        }

        private boolean mCanceled;
        private int mFinalVisibility;
        final ScrollingTabContainerView this$0;

        protected VisibilityAnimListener() {
            this$0 = ScrollingTabContainerView.this;
            super();
            mCanceled = false;
        }
    }

    private class TabClickListener
        implements android.view.View.OnClickListener {

        public void onClick(View view) {
            ((TabView)view).getTab().select();
            int i = mTabLayout.getChildCount();
            int j = 0;
            while(j < i)  {
                View view1 = mTabLayout.getChildAt(j);
                boolean flag;
                if(view1 == view)
                    flag = true;
                else
                    flag = false;
                view1.setSelected(flag);
                j++;
            }
        }

        final ScrollingTabContainerView this$0;

        private TabClickListener() {
            this$0 = ScrollingTabContainerView.this;
            super();
        }

    }

    private class TabAdapter extends BaseAdapter {

        public int getCount() {
            return mTabLayout.getChildCount();
        }

        public Object getItem(int i) {
            return ((TabView)mTabLayout.getChildAt(i)).getTab();
        }

        public long getItemId(int i) {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            if(view == null)
                view = createTabView((android.app.ActionBar.Tab)getItem(i), true);
            else
                ((TabView)view).bindTab((android.app.ActionBar.Tab)getItem(i));
            return view;
        }

        final ScrollingTabContainerView this$0;

        private TabAdapter() {
            this$0 = ScrollingTabContainerView.this;
            super();
        }

    }

    private class TabView extends LinearLayout {

        public void bindTab(android.app.ActionBar.Tab tab) {
            mTab = tab;
            update();
        }

        public android.app.ActionBar.Tab getTab() {
            return mTab;
        }

        public void onMeasure(int i, int j) {
            super.onMeasure(i, j);
            if(mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth)
                super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(mMaxTabWidth, 0x40000000), j);
        }

        public void update() {
            android.app.ActionBar.Tab tab;
            View view;
            tab = mTab;
            view = tab.getCustomView();
            if(view == null) goto _L2; else goto _L1
_L1:
            android.view.ViewParent viewparent = view.getParent();
            if(viewparent != this) {
                if(viewparent != null)
                    ((ViewGroup)viewparent).removeView(view);
                addView(view);
            }
            mCustomView = view;
            if(mTextView != null)
                mTextView.setVisibility(8);
            if(mIconView != null) {
                mIconView.setVisibility(8);
                mIconView.setImageDrawable(null);
            }
_L4:
            return;
_L2:
            if(mCustomView != null) {
                removeView(mCustomView);
                mCustomView = null;
            }
            android.graphics.drawable.Drawable drawable = tab.getIcon();
            CharSequence charsequence = tab.getText();
            if(drawable != null) {
                if(mIconView == null) {
                    ImageView imageview = new ImageView(getContext());
                    android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    layoutparams1.gravity = 16;
                    imageview.setLayoutParams(layoutparams1);
                    addView(imageview, 0);
                    mIconView = imageview;
                }
                mIconView.setImageDrawable(drawable);
                mIconView.setVisibility(0);
            } else
            if(mIconView != null) {
                mIconView.setVisibility(8);
                mIconView.setImageDrawable(null);
            }
            if(charsequence == null)
                break; /* Loop/switch isn't completed */
            if(mTextView == null) {
                TextView textview = new TextView(getContext(), null, 0x10102f5);
                textview.setEllipsize(android.text.TextUtils.TruncateAt.END);
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutparams.gravity = 16;
                textview.setLayoutParams(layoutparams);
                addView(textview);
                mTextView = textview;
            }
            mTextView.setText(charsequence);
            mTextView.setVisibility(0);
_L6:
            if(mIconView != null)
                mIconView.setContentDescription(tab.getContentDescription());
            if(true) goto _L4; else goto _L3
_L3:
            if(mTextView == null) goto _L6; else goto _L5
_L5:
            mTextView.setVisibility(8);
            mTextView.setText(null);
              goto _L6
        }

        private View mCustomView;
        private ImageView mIconView;
        private android.app.ActionBar.Tab mTab;
        private TextView mTextView;
        final ScrollingTabContainerView this$0;

        public TabView(Context context, android.app.ActionBar.Tab tab, boolean flag) {
            this$0 = ScrollingTabContainerView.this;
            super(context, null, 0x10102f3);
            mTab = tab;
            if(flag)
                setGravity(19);
            update();
        }
    }


    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionbarpolicy = ActionBarPolicy.get(context);
        setContentHeight(actionbarpolicy.getTabContainerHeight());
        mStackedTabMaxWidth = actionbarpolicy.getStackedTabMaxWidth();
        mTabLayout = createTabLayout();
        addView(mTabLayout, new android.view.ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner createSpinner() {
        Spinner spinner = new Spinner(getContext(), null, 0x10102d7);
        spinner.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        spinner.setOnItemClickListenerInt(this);
        return spinner;
    }

    private LinearLayout createTabLayout() {
        MiuiTabLayout miuitablayout = new MiuiTabLayout(getContext(), null, 0x10102f4);
        miuitablayout.setMeasureWithLargestChildEnabled(true);
        miuitablayout.setGravity(17);
        miuitablayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        return miuitablayout;
    }

    private TabView createTabView(android.app.ActionBar.Tab tab, boolean flag) {
        TabView tabview = new TabView(getContext(), tab, flag);
        if(flag) {
            tabview.setBackgroundDrawable(null);
            tabview.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, mContentHeight));
        } else {
            tabview.setFocusable(true);
            if(mTabClickListener == null)
                mTabClickListener = new TabClickListener();
            tabview.setOnClickListener(mTabClickListener);
        }
        return tabview;
    }

    private boolean isCollapsed() {
        boolean flag;
        if(mTabSpinner != null && mTabSpinner.getParent() == this)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void performCollapse() {
        if(!isCollapsed()) {
            if(mTabSpinner == null)
                mTabSpinner = createSpinner();
            removeView(mTabLayout);
            addView(mTabSpinner, new android.view.ViewGroup.LayoutParams(-2, -1));
            if(mTabSpinner.getAdapter() == null)
                mTabSpinner.setAdapter(new TabAdapter());
            if(mTabSelector != null) {
                removeCallbacks(mTabSelector);
                mTabSelector = null;
            }
            mTabSpinner.setSelection(mSelectedTabIndex);
        }
    }

    private boolean performExpand() {
        if(isCollapsed()) {
            removeView(mTabSpinner);
            addView(mTabLayout, new android.view.ViewGroup.LayoutParams(-2, -1));
            setTabSelected(mTabSpinner.getSelectedItemPosition());
        }
        return false;
    }

    public void addTab(android.app.ActionBar.Tab tab, int i, boolean flag) {
        TabView tabview = createTabView(tab, false);
        mTabLayout.addView(tabview, i, new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F));
        if(mTabSpinner != null)
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        if(flag)
            tabview.setSelected(true);
        if(mAllowCollapse)
            requestLayout();
    }

    public void addTab(android.app.ActionBar.Tab tab, boolean flag) {
        TabView tabview = createTabView(tab, false);
        mTabLayout.addView(tabview, new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F));
        if(mTabSpinner != null)
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        if(flag)
            tabview.setSelected(true);
        if(mAllowCollapse)
            requestLayout();
    }

    public void animateToTab(int i) {
        final View tabView = mTabLayout.getChildAt(i);
        if(mTabSelector != null)
            removeCallbacks(mTabSelector);
        mTabSelector = new Runnable() {

            public void run() {
                int j = tabView.getLeft() - (getWidth() - tabView.getWidth()) / 2;
                smoothScrollTo(j, 0);
                mTabSelector = null;
            }

            final ScrollingTabContainerView this$0;
            final View val$tabView;

             {
                this$0 = ScrollingTabContainerView.this;
                tabView = view;
                super();
            }
        };
        post(mTabSelector);
    }

    public void animateToVisibility(int i) {
        if(mVisibilityAnim != null)
            mVisibilityAnim.cancel();
        if(i == 0) {
            if(getVisibility() != 0)
                setAlpha(0.0F);
            float af1[] = new float[1];
            af1[0] = 1.0F;
            ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(this, "alpha", af1);
            objectanimator1.setDuration(200L);
            objectanimator1.setInterpolator(sAlphaInterpolator);
            objectanimator1.addListener(mVisAnimListener.withFinalVisibility(i));
            objectanimator1.start();
        } else {
            float af[] = new float[1];
            af[0] = 0.0F;
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "alpha", af);
            objectanimator.setDuration(200L);
            objectanimator.setInterpolator(sAlphaInterpolator);
            objectanimator.addListener(mVisAnimListener.withFinalVisibility(i));
            objectanimator.start();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(mTabSelector != null)
            post(mTabSelector);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionbarpolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionbarpolicy.getTabContainerHeight());
        mStackedTabMaxWidth = actionbarpolicy.getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mTabSelector != null)
            removeCallbacks(mTabSelector);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l) {
        ((TabView)view).getTab().select();
    }

    public void onMeasure(int i, int j) {
        int k = android.view.View.MeasureSpec.getMode(i);
        boolean flag;
        int l;
        boolean flag1;
        if(k == 0x40000000)
            flag = true;
        else
            flag = false;
        setFillViewport(flag);
        l = mTabLayout.getChildCount();
        if(l > 1 && (k == 0x40000000 || k == 0x80000000)) {
            int i1;
            int j1;
            int k1;
            if(l > 2)
                mMaxTabWidth = (int)(0.4F * (float)android.view.View.MeasureSpec.getSize(i));
            else
                mMaxTabWidth = android.view.View.MeasureSpec.getSize(i) / 2;
            mMaxTabWidth = Math.min(mMaxTabWidth, mStackedTabMaxWidth);
        } else {
            mMaxTabWidth = -1;
        }
        i1 = android.view.View.MeasureSpec.makeMeasureSpec(mContentHeight, 0x40000000);
        if(!flag && mAllowCollapse)
            flag1 = true;
        else
            flag1 = false;
        if(flag1) {
            mTabLayout.measure(0, i1);
            if(mTabLayout.getMeasuredWidth() > android.view.View.MeasureSpec.getSize(i))
                performCollapse();
            else
                performExpand();
        } else {
            performExpand();
        }
        j1 = getMeasuredWidth();
        super.onMeasure(i, i1);
        k1 = getMeasuredWidth();
        if(flag && j1 != k1)
            setTabSelected(mSelectedTabIndex);
    }

    public void removeAllTabs() {
        mTabLayout.removeAllViews();
        if(mTabSpinner != null)
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        if(mAllowCollapse)
            requestLayout();
    }

    public void removeTabAt(int i) {
        mTabLayout.removeViewAt(i);
        if(mTabSpinner != null)
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        if(mAllowCollapse)
            requestLayout();
    }

    public void setAllowCollapse(boolean flag) {
        mAllowCollapse = flag;
    }

    public void setContentHeight(int i) {
        mContentHeight = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        mSelectedTabIndex = i;
        int j = mTabLayout.getChildCount();
        int k = 0;
        while(k < j)  {
            View view = mTabLayout.getChildAt(k);
            boolean flag;
            if(k == i)
                flag = true;
            else
                flag = false;
            view.setSelected(flag);
            if(flag)
                animateToTab(i);
            k++;
        }
    }

    public void updateTab(int i) {
        ((TabView)mTabLayout.getChildAt(i)).update();
        if(mTabSpinner != null)
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        if(mAllowCollapse)
            requestLayout();
    }

    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    private LinearLayout mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    protected Animator mVisibilityAnim;



}
