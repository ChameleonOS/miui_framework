// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.internal.app.ActionBarImpl;

// Referenced classes of package com.android.internal.widget:
//            ActionBarContainer, ActionBarView

public class ActionBarOverlayLayout extends FrameLayout {

    public ActionBarOverlayLayout(Context context) {
        super(context);
        mWindowVisibility = 0;
        mZeroRect = new Rect(0, 0, 0, 0);
        init(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mWindowVisibility = 0;
        mZeroRect = new Rect(0, 0, 0, 0);
        init(context);
    }

    private boolean applyInsets(View view, Rect rect, boolean flag, boolean flag1, boolean flag2, boolean flag3) {
        boolean flag4 = false;
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        if(flag && ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin != rect.left) {
            flag4 = true;
            layoutparams.leftMargin = rect.left;
        }
        if(flag1 && ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin != rect.top) {
            flag4 = true;
            layoutparams.topMargin = rect.top;
        }
        if(flag3 && ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin != rect.right) {
            flag4 = true;
            layoutparams.rightMargin = rect.right;
        }
        if(flag2 && ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin != rect.bottom) {
            flag4 = true;
            layoutparams.bottomMargin = rect.bottom;
        }
        return flag4;
    }

    private void init(Context context) {
        TypedArray typedarray = getContext().getTheme().obtainStyledAttributes(mActionBarSizeAttr);
        mActionBarHeight = typedarray.getDimensionPixelSize(0, 0);
        typedarray.recycle();
    }

    protected boolean fitSystemWindows(Rect rect) {
        pullChildren();
        int i = getWindowSystemUiVisibility();
        boolean flag;
        boolean flag1;
        boolean flag2;
        if((i & 0x100) != 0)
            flag = true;
        else
            flag = false;
        flag1 = applyInsets(mActionBarTop, rect, true, true, false, true);
        if(mActionBarBottom != null)
            flag1 |= applyInsets(mActionBarBottom, rect, true, false, true, true);
        if((i & 0x600) == 0) {
            flag2 = flag1 | applyInsets(mContent, rect, true, true, true, true);
            rect.set(0, 0, 0, 0);
        } else {
            flag2 = flag1 | applyInsets(mContent, mZeroRect, true, true, true, true);
        }
        if(flag || mActionBarTop.getVisibility() == 0)
            rect.top = rect.top + mActionBarHeight;
        if(mActionBar != null && mActionBar.hasNonEmbeddedTabs()) {
            View view = mContainerView.getTabContainer();
            if(flag || view != null && view.getVisibility() == 0)
                rect.top = rect.top + mActionBarHeight;
        }
        if(mActionView.isSplitActionBar() && (flag || mActionBarBottom != null && mActionBarBottom.getVisibility() == 0))
            rect.bottom = rect.bottom + mActionBarHeight;
        if(flag2)
            requestLayout();
        return super.fitSystemWindows(rect);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        pullChildren();
        int j = i ^ mLastSystemUiVisibility;
        mLastSystemUiVisibility = i;
        boolean flag;
        if((i & 4) == 0)
            flag = true;
        else
            flag = false;
        if(mActionBar != null)
            mActionBar.isSystemShowing();
        if(mActionBar != null)
            if(flag)
                mActionBar.showForSystem();
            else
                mActionBar.hideForSystem();
        if((j & 0x100) != 0 && mActionBar != null)
            requestFitSystemWindows();
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        mWindowVisibility = i;
        if(mActionBar != null)
            mActionBar.setWindowVisibility(i);
    }

    void pullChildren() {
        if(mContent == null) {
            mContent = findViewById(0x1020002);
            mActionBarTop = findViewById(0x1020323);
            mContainerView = (ActionBarContainer)findViewById(0x102031e);
            mActionView = (ActionBarView)findViewById(0x102031f);
            mActionBarBottom = findViewById(0x1020321);
        }
    }

    public void setActionBar(ActionBarImpl actionbarimpl) {
        mActionBar = actionbarimpl;
        if(getWindowToken() != null) {
            mActionBar.setWindowVisibility(mWindowVisibility);
            if(mLastSystemUiVisibility != 0) {
                onWindowSystemUiVisibilityChanged(mLastSystemUiVisibility);
                requestFitSystemWindows();
            }
        }
    }

    public void setShowingForActionMode(boolean flag) {
        if(flag) {
            if((0x500 & getWindowSystemUiVisibility()) == 1280)
                setDisabledSystemUiVisibility(4);
        } else {
            setDisabledSystemUiVisibility(0);
        }
    }

    static final int mActionBarSizeAttr[];
    private ActionBarImpl mActionBar;
    private View mActionBarBottom;
    private int mActionBarHeight;
    private View mActionBarTop;
    private ActionBarView mActionView;
    private ActionBarContainer mContainerView;
    private View mContent;
    private int mLastSystemUiVisibility;
    private int mWindowVisibility;
    private final Rect mZeroRect;

    static  {
        int ai[] = new int[1];
        ai[0] = 0x10102eb;
        mActionBarSizeAttr = ai;
    }
}
