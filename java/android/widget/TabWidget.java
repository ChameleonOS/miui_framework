// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            LinearLayout

public class TabWidget extends LinearLayout
    implements android.view.View.OnFocusChangeListener {
    static interface OnTabSelectionChanged {

        public abstract void onTabSelectionChanged(int i, boolean flag);
    }

    private class TabClickListener
        implements android.view.View.OnClickListener {

        public void onClick(View view) {
            mSelectionChangedListener.onTabSelectionChanged(mTabIndex, true);
        }

        private final int mTabIndex;
        final TabWidget this$0;

        private TabClickListener(int i) {
            this$0 = TabWidget.this;
            super();
            mTabIndex = i;
        }

    }


    public TabWidget(Context context) {
        this(context, null);
    }

    public TabWidget(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010083);
    }

    public TabWidget(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mSelectedTab = -1;
        mDrawBottomStrips = true;
        mBounds = new Rect();
        mImposedTabsHeight = -1;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.TabWidget, i, 0);
        setStripEnabled(typedarray.getBoolean(3, true));
        setLeftStripDrawable(typedarray.getDrawable(1));
        setRightStripDrawable(typedarray.getDrawable(2));
        typedarray.recycle();
        initTabWidget();
    }

    private void initTabWidget() {
        Context context;
        Resources resources;
        setChildrenDrawingOrderEnabled(true);
        context = super.mContext;
        resources = context.getResources();
        if(context.getApplicationInfo().targetSdkVersion > 4) goto _L2; else goto _L1
_L1:
        if(mLeftStrip == null)
            mLeftStrip = resources.getDrawable(0x1080598);
        if(mRightStrip == null)
            mRightStrip = resources.getDrawable(0x108059a);
_L4:
        setFocusable(true);
        setOnFocusChangeListener(this);
        return;
_L2:
        if(mLeftStrip == null)
            mLeftStrip = resources.getDrawable(0x1080597);
        if(mRightStrip == null)
            mRightStrip = resources.getDrawable(0x1080599);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void addView(View view) {
        if(view.getLayoutParams() == null) {
            LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(0, -1, 1.0F);
            layoutparams.setMargins(0, 0, 0, 0);
            view.setLayoutParams(layoutparams);
        }
        view.setFocusable(true);
        view.setClickable(true);
        super.addView(view);
        view.setOnClickListener(new TabClickListener(-1 + getTabCount()));
        view.setOnFocusChangeListener(this);
    }

    public void childDrawableStateChanged(View view) {
        if(getTabCount() > 0 && view == getChildTabViewAt(mSelectedTab))
            invalidate();
        super.childDrawableStateChanged(view);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        break MISSING_BLOCK_LABEL_5;
        if(getTabCount() != 0 && mDrawBottomStrips) {
            View view = getChildTabViewAt(mSelectedTab);
            Drawable drawable = mLeftStrip;
            Drawable drawable1 = mRightStrip;
            drawable.setState(view.getDrawableState());
            drawable1.setState(view.getDrawableState());
            if(mStripMoved) {
                Rect rect = mBounds;
                rect.left = view.getLeft();
                rect.right = view.getRight();
                int i = getHeight();
                drawable.setBounds(Math.min(0, rect.left - drawable.getIntrinsicWidth()), i - drawable.getIntrinsicHeight(), rect.left, i);
                drawable1.setBounds(rect.right, i - drawable1.getIntrinsicHeight(), Math.max(getWidth(), rect.right + drawable1.getIntrinsicWidth()), i);
                mStripMoved = false;
            }
            drawable.draw(canvas);
            drawable1.draw(canvas);
        }
        return;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onPopulateAccessibilityEvent(accessibilityevent);
        if(mSelectedTab == -1) goto _L2; else goto _L1
_L1:
        View view = getChildTabViewAt(mSelectedTab);
        if(view == null || view.getVisibility() != 0) goto _L2; else goto _L3
_L3:
        boolean flag = view.dispatchPopulateAccessibilityEvent(accessibilityevent);
_L5:
        return flag;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void focusCurrentTab(int i) {
        int j = mSelectedTab;
        setCurrentTab(i);
        if(j != i)
            getChildTabViewAt(i).requestFocus();
    }

    protected int getChildDrawingOrder(int i, int j) {
        if(mSelectedTab != -1) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        if(j == i - 1)
            j = mSelectedTab;
        else
        if(j >= mSelectedTab)
            j++;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public View getChildTabViewAt(int i) {
        return getChildAt(i);
    }

    public int getTabCount() {
        return getChildCount();
    }

    public boolean isStripEnabled() {
        return mDrawBottomStrips;
    }

    void measureChildBeforeLayout(View view, int i, int j, int k, int l, int i1) {
        if(!isMeasureWithLargestChildEnabled() && mImposedTabsHeight >= 0) {
            j = android.view.View.MeasureSpec.makeMeasureSpec(k + mImposedTabWidths[i], 0x40000000);
            l = android.view.View.MeasureSpec.makeMeasureSpec(mImposedTabsHeight, 0x40000000);
        }
        super.measureChildBeforeLayout(view, i, j, k, l, i1);
    }

    void measureHorizontal(int i, int j) {
        if(android.view.View.MeasureSpec.getMode(i) == 0) {
            super.measureHorizontal(i, j);
        } else {
            int k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            mImposedTabsHeight = -1;
            super.measureHorizontal(k, j);
            int l = getMeasuredWidth() - android.view.View.MeasureSpec.getSize(i);
            if(l > 0) {
                int i1 = getChildCount();
                int j1 = 0;
                int k1 = 0;
                while(k1 < i1)  {
                    if(getChildAt(k1).getVisibility() != 8)
                        j1++;
                    k1++;
                }
                if(j1 > 0) {
                    if(mImposedTabWidths == null || mImposedTabWidths.length != i1)
                        mImposedTabWidths = new int[i1];
                    int l1 = 0;
                    while(l1 < i1)  {
                        View view = getChildAt(l1);
                        if(view.getVisibility() != 8) {
                            int i2 = view.getMeasuredWidth();
                            int j2 = Math.max(0, i2 - l / j1);
                            mImposedTabWidths[l1] = j2;
                            l -= i2 - j2;
                            j1--;
                            mImposedTabsHeight = Math.max(mImposedTabsHeight, view.getMeasuredHeight());
                        }
                        l1++;
                    }
                }
            }
            super.measureHorizontal(i, j);
        }
    }

    public void onFocusChange(View view, boolean flag) {
        if(view != this || !flag || getTabCount() <= 0) goto _L2; else goto _L1
_L1:
        getChildTabViewAt(mSelectedTab).requestFocus();
_L4:
        return;
_L2:
        int i;
        int j;
        if(!flag)
            continue; /* Loop/switch isn't completed */
        i = 0;
        j = getTabCount();
_L5:
        if(i < j) {
label0:
            {
                if(getChildTabViewAt(i) != view)
                    break label0;
                setCurrentTab(i);
                mSelectionChangedListener.onTabSelectionChanged(i, false);
                if(isShown())
                    sendAccessibilityEvent(8);
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
        i++;
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/TabWidget.getName());
        accessibilityevent.setItemCount(getTabCount());
        accessibilityevent.setCurrentItemIndex(mSelectedTab);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/TabWidget.getName());
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        mStripMoved = true;
        super.onSizeChanged(i, j, k, l);
    }

    public void removeAllViews() {
        super.removeAllViews();
        mSelectedTab = -1;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityevent) {
        if(accessibilityevent.getEventType() == 8 && isFocused())
            accessibilityevent.recycle();
        else
            super.sendAccessibilityEventUnchecked(accessibilityevent);
    }

    public void setCurrentTab(int i) {
        if(i >= 0 && i < getTabCount() && i != mSelectedTab) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mSelectedTab != -1)
            getChildTabViewAt(mSelectedTab).setSelected(false);
        mSelectedTab = i;
        getChildTabViewAt(mSelectedTab).setSelected(true);
        mStripMoved = true;
        if(isShown())
            sendAccessibilityEvent(4);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setDividerDrawable(int i) {
        setDividerDrawable(getResources().getDrawable(i));
    }

    public void setDividerDrawable(Drawable drawable) {
        super.setDividerDrawable(drawable);
    }

    public void setEnabled(boolean flag) {
        super.setEnabled(flag);
        int i = getTabCount();
        for(int j = 0; j < i; j++)
            getChildTabViewAt(j).setEnabled(flag);

    }

    public void setLeftStripDrawable(int i) {
        setLeftStripDrawable(getResources().getDrawable(i));
    }

    public void setLeftStripDrawable(Drawable drawable) {
        mLeftStrip = drawable;
        requestLayout();
        invalidate();
    }

    public void setRightStripDrawable(int i) {
        setRightStripDrawable(getResources().getDrawable(i));
    }

    public void setRightStripDrawable(Drawable drawable) {
        mRightStrip = drawable;
        requestLayout();
        invalidate();
    }

    public void setStripEnabled(boolean flag) {
        mDrawBottomStrips = flag;
        invalidate();
    }

    void setTabSelectionListener(OnTabSelectionChanged ontabselectionchanged) {
        mSelectionChangedListener = ontabselectionchanged;
    }

    private final Rect mBounds;
    private boolean mDrawBottomStrips;
    private int mImposedTabWidths[];
    private int mImposedTabsHeight;
    private Drawable mLeftStrip;
    private Drawable mRightStrip;
    private int mSelectedTab;
    private OnTabSelectionChanged mSelectionChangedListener;
    private boolean mStripMoved;

}
