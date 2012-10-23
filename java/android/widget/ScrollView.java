// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import java.util.List;

// Referenced classes of package android.widget:
//            FrameLayout, EdgeEffect, OverScroller

public class ScrollView extends FrameLayout {

    public ScrollView(Context context) {
        this(context, null);
    }

    public ScrollView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010080);
    }

    public ScrollView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mTempRect = new Rect();
        mIsLayoutDirty = true;
        mChildToScrollTo = null;
        mIsBeingDragged = false;
        mSmoothScrollingEnabled = true;
        mActivePointerId = -1;
        mScrollStrictSpan = null;
        mFlingStrictSpan = null;
        initScrollView();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ScrollView, i, 0);
        setFillViewport(typedarray.getBoolean(0, false));
        typedarray.recycle();
    }

    private boolean canScroll() {
        boolean flag = false;
        View view = getChildAt(0);
        if(view != null) {
            int i = view.getHeight();
            if(getHeight() < i + super.mPaddingTop + super.mPaddingBottom)
                flag = true;
        }
        return flag;
    }

    private static int clamp(int i, int j, int k) {
        if(j < k && i >= 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        return i;
_L2:
        if(j + i > k)
            i = k - j;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void doScrollY(int i) {
        if(i != 0)
            if(mSmoothScrollingEnabled)
                smoothScrollBy(0, i);
            else
                scrollBy(0, i);
    }

    private void endDrag() {
        mIsBeingDragged = false;
        recycleVelocityTracker();
        if(mEdgeGlowTop != null) {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        }
        if(mScrollStrictSpan != null) {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        }
    }

    private View findFocusableViewInBounds(boolean flag, int i, int j) {
        java.util.ArrayList arraylist = getFocusables(2);
        View view = null;
        boolean flag1 = false;
        int k = arraylist.size();
        int l = 0;
        while(l < k)  {
            View view1 = (View)arraylist.get(l);
            int i1 = view1.getTop();
            int j1 = view1.getBottom();
            if(i < j1 && i1 < j) {
                boolean flag2;
                if(i < i1 && j1 < j)
                    flag2 = true;
                else
                    flag2 = false;
                if(view == null) {
                    view = view1;
                    flag1 = flag2;
                } else {
                    boolean flag3;
                    if(flag && i1 < view.getTop() || !flag && j1 > view.getBottom())
                        flag3 = true;
                    else
                        flag3 = false;
                    if(flag1) {
                        if(flag2 && flag3)
                            view = view1;
                    } else
                    if(flag2) {
                        view = view1;
                        flag1 = true;
                    } else
                    if(flag3)
                        view = view1;
                }
            }
            l++;
        }
        return view;
    }

    private int getScrollRange() {
        int i = 0;
        if(getChildCount() > 0)
            i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - super.mPaddingBottom - super.mPaddingTop));
        return i;
    }

    private boolean inChild(int i, int j) {
        boolean flag = false;
        if(getChildCount() > 0) {
            int k = super.mScrollY;
            View view = getChildAt(0);
            if(j >= view.getTop() - k && j < view.getBottom() - k && i >= view.getLeft() && i < view.getRight())
                flag = true;
        }
        return flag;
    }

    private void initOrResetVelocityTracker() {
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        else
            mVelocityTracker.clear();
    }

    private void initScrollView() {
        mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(0x40000);
        setWillNotDraw(false);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(super.mContext);
        mTouchSlop = viewconfiguration.getScaledTouchSlop();
        mMinimumVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mOverscrollDistance = viewconfiguration.getScaledOverscrollDistance();
        mOverflingDistance = viewconfiguration.getScaledOverflingDistance();
    }

    private void initVelocityTrackerIfNotExists() {
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
    }

    private boolean isOffScreen(View view) {
        boolean flag = false;
        if(!isWithinDeltaOfScreen(view, 0, getHeight()))
            flag = true;
        return flag;
    }

    private static boolean isViewDescendantOf(View view, View view1) {
        boolean flag = true;
        if(view != view1) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        ViewParent viewparent = view.getParent();
        if(!(viewparent instanceof ViewGroup) || !isViewDescendantOf((View)viewparent, view1))
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean isWithinDeltaOfScreen(View view, int i, int j) {
        view.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view, mTempRect);
        boolean flag;
        if(i + mTempRect.bottom >= getScrollY() && mTempRect.top - i <= j + getScrollY())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void onSecondaryPointerUp(MotionEvent motionevent) {
        int i = (0xff00 & motionevent.getAction()) >> 8;
        if(motionevent.getPointerId(i) == mActivePointerId) {
            int j;
            if(i == 0)
                j = 1;
            else
                j = 0;
            mLastMotionY = (int)motionevent.getY(j);
            mActivePointerId = motionevent.getPointerId(j);
            if(mVelocityTracker != null)
                mVelocityTracker.clear();
        }
    }

    private void recycleVelocityTracker() {
        if(mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private boolean scrollAndFocus(int i, int j, int k) {
        boolean flag = true;
        int l = getHeight();
        int i1 = getScrollY();
        int j1 = i1 + l;
        boolean flag1;
        Object obj;
        if(i == 33)
            flag1 = true;
        else
            flag1 = false;
        obj = findFocusableViewInBounds(flag1, j, k);
        if(obj == null)
            obj = this;
        if(j >= i1 && k <= j1) {
            flag = false;
        } else {
            int k1;
            if(flag1)
                k1 = j - i1;
            else
                k1 = k - j1;
            doScrollY(k1);
        }
        if(obj != findFocus())
            ((View) (obj)).requestFocus(i);
        return flag;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view, mTempRect);
        int i = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        if(i != 0)
            scrollBy(0, i);
    }

    private boolean scrollToChildRect(Rect rect, boolean flag) {
        int i = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean flag1;
        if(i != 0)
            flag1 = true;
        else
            flag1 = false;
        if(flag1)
            if(flag)
                scrollBy(0, i);
            else
                smoothScrollBy(0, i);
        return flag1;
    }

    public void addView(View view) {
        if(getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        } else {
            super.addView(view);
            return;
        }
    }

    public void addView(View view, int i) {
        if(getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        } else {
            super.addView(view, i);
            return;
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        if(getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        } else {
            super.addView(view, i, layoutparams);
            return;
        }
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams) {
        if(getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        } else {
            super.addView(view, layoutparams);
            return;
        }
    }

    public boolean arrowScroll(int i) {
        boolean flag;
        View view;
        View view1;
        int j;
        flag = false;
        view = findFocus();
        if(view == this)
            view = null;
        view1 = FocusFinder.getInstance().findNextFocus(this, view, i);
        j = getMaxScrollAmount();
        if(view1 == null || !isWithinDeltaOfScreen(view1, j, getHeight())) goto _L2; else goto _L1
_L1:
        view1.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view1, mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(mTempRect));
        view1.requestFocus(i);
_L6:
        if(view != null && view.isFocused() && isOffScreen(view)) {
            int k1 = getDescendantFocusability();
            setDescendantFocusability(0x20000);
            requestFocus();
            setDescendantFocusability(k1);
        }
        flag = true;
_L4:
        return flag;
_L2:
        int k;
        k = j;
        if(i == 33 && getScrollY() < k)
            k = getScrollY();
        else
        if(i == 130 && getChildCount() > 0) {
            int l = getChildAt(0).getBottom();
            int i1 = (getScrollY() + getHeight()) - super.mPaddingBottom;
            if(l - i1 < j)
                k = l - i1;
        }
        if(k == 0) goto _L4; else goto _L3
_L3:
        int j1;
        if(i == 130)
            j1 = k;
        else
            j1 = -k;
        doScrollY(j1);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void computeScroll() {
        int i = 1;
        if(mScroller.computeScrollOffset()) {
            int j = super.mScrollX;
            int k = super.mScrollY;
            int l = mScroller.getCurrX();
            int i1 = mScroller.getCurrY();
            if(j != l || k != i1) {
                int j1 = getScrollRange();
                int k1 = getOverScrollMode();
                if(k1 != 0 && (k1 != i || j1 <= 0))
                    i = 0;
                overScrollBy(l - j, i1 - k, j, k, 0, j1, 0, mOverflingDistance, false);
                onScrollChanged(super.mScrollX, super.mScrollY, j, k);
                if(i != 0)
                    if(i1 < 0 && k >= 0)
                        mEdgeGlowTop.onAbsorb((int)mScroller.getCurrVelocity());
                    else
                    if(i1 > j1 && k <= j1)
                        mEdgeGlowBottom.onAbsorb((int)mScroller.getCurrVelocity());
            }
            if(!awakenScrollBars())
                postInvalidateOnAnimation();
        } else
        if(mFlingStrictSpan != null) {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        }
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if(getChildCount() != 0) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L4:
        return i1;
_L2:
        int i = getHeight();
        int j = getScrollY();
        int k = j + i;
        int l = getVerticalFadingEdgeLength();
        if(rect.top > 0)
            j += l;
        if(rect.bottom < getChildAt(0).getHeight())
            k -= l;
        i1 = 0;
        if(rect.bottom > k && rect.top > j) {
            int k1;
            if(rect.height() > i)
                k1 = 0 + (rect.top - j);
            else
                k1 = 0 + (rect.bottom - k);
            i1 = Math.min(k1, getChildAt(0).getBottom() - k);
        } else
        if(rect.top < j && rect.bottom < k) {
            int j1;
            if(rect.height() > i)
                j1 = 0 - (k - rect.bottom);
            else
                j1 = 0 - (j - rect.top);
            i1 = Math.max(j1, -getScrollY());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    protected int computeVerticalScrollRange() {
        int i;
        int j;
        i = getChildCount();
        j = getHeight() - super.mPaddingBottom - super.mPaddingTop;
        if(i != 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int k;
        int l;
        int i1;
        k = getChildAt(0).getBottom();
        l = super.mScrollY;
        i1 = Math.max(0, k - j);
        if(l >= 0)
            break; /* Loop/switch isn't completed */
        k -= l;
_L5:
        j = k;
        if(true) goto _L1; else goto _L3
_L3:
        if(l <= i1) goto _L5; else goto _L4
_L4:
        k += l - i1;
          goto _L5
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        boolean flag;
        if(super.dispatchKeyEvent(keyevent) || executeKeyEvent(keyevent))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(mEdgeGlowTop != null) {
            int i = super.mScrollY;
            if(!mEdgeGlowTop.isFinished()) {
                int i1 = canvas.save();
                int j1 = getWidth() - super.mPaddingLeft - super.mPaddingRight;
                canvas.translate(super.mPaddingLeft, Math.min(0, i));
                mEdgeGlowTop.setSize(j1, getHeight());
                if(mEdgeGlowTop.draw(canvas))
                    postInvalidateOnAnimation();
                canvas.restoreToCount(i1);
            }
            if(!mEdgeGlowBottom.isFinished()) {
                int j = canvas.save();
                int k = getWidth() - super.mPaddingLeft - super.mPaddingRight;
                int l = getHeight();
                canvas.translate(-k + super.mPaddingLeft, l + Math.max(getScrollRange(), i));
                canvas.rotate(180F, k, 0.0F);
                mEdgeGlowBottom.setSize(k, l);
                if(mEdgeGlowBottom.draw(canvas))
                    postInvalidateOnAnimation();
                canvas.restoreToCount(j);
            }
        }
    }

    public boolean executeKeyEvent(KeyEvent keyevent) {
        boolean flag;
        flag = false;
        mTempRect.setEmpty();
        if(canScroll()) goto _L2; else goto _L1
_L1:
        if(isFocused() && keyevent.getKeyCode() != 4) {
            View view = findFocus();
            if(view == this)
                view = null;
            View view1 = FocusFinder.getInstance().findNextFocus(this, view, 130);
            if(view1 != null && view1 != this && view1.requestFocus(130))
                flag = true;
        }
_L10:
        return flag;
_L2:
        boolean flag1 = false;
        if(keyevent.getAction() != 0) goto _L4; else goto _L3
_L3:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 132
    //                   19: 137
    //                   20: 164
    //                   62: 193;
           goto _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_193;
_L5:
        break; /* Loop/switch isn't completed */
_L6:
        break; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        if(true) goto _L10; else goto _L9
_L9:
        if(!keyevent.isAltPressed())
            flag1 = arrowScroll(33);
        else
            flag1 = fullScroll(33);
          goto _L4
_L7:
        if(!keyevent.isAltPressed())
            flag1 = arrowScroll(130);
        else
            flag1 = fullScroll(130);
          goto _L4
        char c;
        if(keyevent.isShiftPressed())
            c = '!';
        else
            c = '\202';
        pageScroll(c);
          goto _L4
    }

    public void fling(int i) {
        if(getChildCount() > 0) {
            int j = getHeight() - super.mPaddingBottom - super.mPaddingTop;
            int k = getChildAt(0).getHeight();
            mScroller.fling(super.mScrollX, super.mScrollY, 0, i, 0, 0, 0, Math.max(0, k - j), 0, j / 2);
            if(mFlingStrictSpan == null)
                mFlingStrictSpan = StrictMode.enterCriticalSpan("ScrollView-fling");
            postInvalidateOnAnimation();
        }
    }

    public boolean fullScroll(int i) {
        boolean flag;
        int j;
        if(i == 130)
            flag = true;
        else
            flag = false;
        j = getHeight();
        mTempRect.top = 0;
        mTempRect.bottom = j;
        if(flag) {
            int k = getChildCount();
            if(k > 0) {
                View view = getChildAt(k - 1);
                mTempRect.bottom = view.getBottom() + super.mPaddingBottom;
                mTempRect.top = mTempRect.bottom - j;
            }
        }
        return scrollAndFocus(i, mTempRect.top, mTempRect.bottom);
    }

    protected float getBottomFadingEdgeStrength() {
        float f;
        if(getChildCount() == 0) {
            f = 0.0F;
        } else {
            int i = getVerticalFadingEdgeLength();
            int j = getHeight() - super.mPaddingBottom;
            int k = getChildAt(0).getBottom() - super.mScrollY - j;
            if(k < i)
                f = (float)k / (float)i;
            else
                f = 1.0F;
        }
        return f;
    }

    public int getMaxScrollAmount() {
        return (int)(0.5F * (float)(super.mBottom - super.mTop));
    }

    protected float getTopFadingEdgeStrength() {
        float f;
        if(getChildCount() == 0) {
            f = 0.0F;
        } else {
            int i = getVerticalFadingEdgeLength();
            if(super.mScrollY < i)
                f = (float)super.mScrollY / (float)i;
            else
                f = 1.0F;
        }
        return f;
    }

    public boolean isFillViewport() {
        return mFillViewport;
    }

    public boolean isSmoothScrollingEnabled() {
        return mSmoothScrollingEnabled;
    }

    protected void measureChild(View view, int i, int j) {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, super.mPaddingLeft + super.mPaddingRight, layoutparams.width), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int j, int k, int l) {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, j + (super.mPaddingLeft + super.mPaddingRight + marginlayoutparams.leftMargin + marginlayoutparams.rightMargin), ((android.view.ViewGroup.LayoutParams) (marginlayoutparams)).width), android.view.View.MeasureSpec.makeMeasureSpec(marginlayoutparams.topMargin + marginlayoutparams.bottomMargin, 0));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mScrollStrictSpan != null) {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        }
        if(mFlingStrictSpan != null) {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent) {
        if((2 & motionevent.getSource()) == 0) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 8 8: default 32
    //                   8 40;
           goto _L2 _L3
_L2:
        boolean flag = super.onGenericMotionEvent(motionevent);
_L6:
        return flag;
_L3:
        float f;
        if(mIsBeingDragged || (f = motionevent.getAxisValue(9)) == 0.0F) goto _L2; else goto _L4
_L4:
        int i = (int)(f * getVerticalScrollFactor());
        int j = getScrollRange();
        int k = super.mScrollY;
        int l = k - i;
        if(l < 0)
            l = 0;
        else
        if(l > j)
            l = j;
        if(l == k) goto _L2; else goto _L5
_L5:
        super.scrollTo(super.mScrollX, l);
        flag = true;
          goto _L6
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ScrollView.getName());
        boolean flag;
        if(getScrollRange() > 0)
            flag = true;
        else
            flag = false;
        accessibilityevent.setScrollable(flag);
        accessibilityevent.setScrollX(super.mScrollX);
        accessibilityevent.setScrollY(super.mScrollY);
        accessibilityevent.setMaxScrollX(super.mScrollX);
        accessibilityevent.setMaxScrollY(getScrollRange());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ScrollView.getName());
        if(isEnabled()) {
            int i = getScrollRange();
            if(i > 0) {
                accessibilitynodeinfo.setScrollable(true);
                if(super.mScrollY > 0)
                    accessibilitynodeinfo.addAction(8192);
                if(super.mScrollY < i)
                    accessibilitynodeinfo.addAction(4096);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent) {
        boolean flag;
        boolean flag1;
        int i;
        flag = true;
        flag1 = false;
        i = motionevent.getAction();
        if(i != 2 || !mIsBeingDragged) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 72
    //                   0 185
    //                   1 289
    //                   2 80
    //                   3 289
    //                   4 72
    //                   5 72
    //                   6 336;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L3 _L7
_L7:
        break MISSING_BLOCK_LABEL_336;
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        break; /* Loop/switch isn't completed */
_L9:
        flag = mIsBeingDragged;
        if(true) goto _L1; else goto _L8
_L8:
        int k = mActivePointerId;
        if(k != -1) {
            int l = (int)motionevent.getY(motionevent.findPointerIndex(k));
            if(Math.abs(l - mLastMotionY) > mTouchSlop) {
                mIsBeingDragged = flag;
                mLastMotionY = l;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(motionevent);
                if(mScrollStrictSpan == null)
                    mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
                ViewParent viewparent = getParent();
                if(viewparent != null)
                    viewparent.requestDisallowInterceptTouchEvent(flag);
            }
        }
          goto _L9
_L4:
        int j = (int)motionevent.getY();
        if(!inChild((int)motionevent.getX(), j)) {
            mIsBeingDragged = false;
            recycleVelocityTracker();
        } else {
            mLastMotionY = j;
            mActivePointerId = motionevent.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(motionevent);
            if(!mScroller.isFinished())
                flag1 = flag;
            mIsBeingDragged = flag1;
            if(mIsBeingDragged && mScrollStrictSpan == null)
                mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
        }
          goto _L9
_L5:
        mIsBeingDragged = false;
        mActivePointerId = -1;
        recycleVelocityTracker();
        if(mScroller.springBack(super.mScrollX, super.mScrollY, 0, 0, 0, getScrollRange()))
            postInvalidateOnAnimation();
          goto _L9
        onSecondaryPointerUp(motionevent);
          goto _L9
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        super.onLayout(flag, i, j, k, l);
        mIsLayoutDirty = false;
        if(mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this))
            scrollToChild(mChildToScrollTo);
        mChildToScrollTo = null;
        scrollTo(super.mScrollX, super.mScrollY);
    }

    protected void onMeasure(int i, int j) {
        super.onMeasure(i, j);
        break MISSING_BLOCK_LABEL_6;
        while(true)  {
            do
                return;
            while(!mFillViewport || android.view.View.MeasureSpec.getMode(j) == 0 || getChildCount() <= 0);
            View view = getChildAt(0);
            int k = getMeasuredHeight();
            if(view.getMeasuredHeight() < k) {
                FrameLayout.LayoutParams layoutparams = (FrameLayout.LayoutParams)view.getLayoutParams();
                view.measure(getChildMeasureSpec(i, super.mPaddingLeft + super.mPaddingRight, ((android.view.ViewGroup.LayoutParams) (layoutparams)).width), android.view.View.MeasureSpec.makeMeasureSpec(k - super.mPaddingTop - super.mPaddingBottom, 0x40000000));
            }
        }
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1) {
        if(!mScroller.isFinished()) {
            super.mScrollX = i;
            super.mScrollY = j;
            invalidateParentIfNeeded();
            if(flag1)
                mScroller.springBack(super.mScrollX, super.mScrollY, 0, 0, 0, getScrollRange());
        } else {
            super.scrollTo(i, j);
        }
        awakenScrollBars();
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        boolean flag;
        View view;
        flag = false;
        if(i == 2)
            i = 130;
        else
        if(i == 1)
            i = 33;
        if(rect == null)
            view = FocusFinder.getInstance().findNextFocus(this, null, i);
        else
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        break MISSING_BLOCK_LABEL_26;
        if(view != null && !isOffScreen(view))
            flag = view.requestFocus(i, rect);
        return flag;
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        View view;
        super.onSizeChanged(i, j, k, l);
        view = findFocus();
        break MISSING_BLOCK_LABEL_15;
        if(view != null && this != view && isWithinDeltaOfScreen(view, 0, l)) {
            view.getDrawingRect(mTempRect);
            offsetDescendantRectToMyCoords(view, mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(mTempRect));
        }
        return;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(motionevent);
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 64
    //                   0 68
    //                   1 515
    //                   2 186
    //                   3 624
    //                   4 64
    //                   5 680
    //                   6 707;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        boolean flag = true;
_L9:
        return flag;
_L2:
        if(getChildCount() != 0)
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L9; else goto _L8
_L8:
        boolean flag2;
        if(!mScroller.isFinished())
            flag2 = true;
        else
            flag2 = false;
        mIsBeingDragged = flag2;
        if(flag2) {
            ViewParent viewparent1 = getParent();
            if(viewparent1 != null)
                viewparent1.requestDisallowInterceptTouchEvent(true);
        }
        if(!mScroller.isFinished()) {
            mScroller.abortAnimation();
            if(mFlingStrictSpan != null) {
                mFlingStrictSpan.finish();
                mFlingStrictSpan = null;
            }
        }
        mLastMotionY = (int)motionevent.getY();
        mActivePointerId = motionevent.getPointerId(0);
        continue; /* Loop/switch isn't completed */
_L4:
        int l;
        int k1;
        int i2;
        int k = (int)motionevent.getY(motionevent.findPointerIndex(mActivePointerId));
        l = mLastMotionY - k;
        boolean flag1;
        if(!mIsBeingDragged && Math.abs(l) > mTouchSlop) {
            ViewParent viewparent = getParent();
            if(viewparent != null)
                viewparent.requestDisallowInterceptTouchEvent(true);
            mIsBeingDragged = true;
            int i1;
            int j1;
            int l1;
            if(l > 0)
                l -= mTouchSlop;
            else
                l += mTouchSlop;
        }
        if(!mIsBeingDragged)
            continue; /* Loop/switch isn't completed */
        mLastMotionY = k;
        i1 = super.mScrollX;
        j1 = super.mScrollY;
        k1 = getScrollRange();
        l1 = getOverScrollMode();
        if(l1 == 0 || l1 == 1 && k1 > 0)
            flag1 = true;
        else
            flag1 = false;
        if(overScrollBy(0, l, 0, super.mScrollY, 0, k1, 0, mOverscrollDistance, true))
            mVelocityTracker.clear();
        onScrollChanged(super.mScrollX, super.mScrollY, i1, j1);
        if(!flag1)
            continue; /* Loop/switch isn't completed */
        i2 = j1 + l;
        if(i2 >= 0) goto _L11; else goto _L10
_L10:
        mEdgeGlowTop.onPull((float)l / (float)getHeight());
        if(!mEdgeGlowBottom.isFinished())
            mEdgeGlowBottom.onRelease();
_L12:
        if(mEdgeGlowTop != null && (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished()))
            postInvalidateOnAnimation();
        continue; /* Loop/switch isn't completed */
_L11:
        if(i2 > k1) {
            mEdgeGlowBottom.onPull((float)l / (float)getHeight());
            if(!mEdgeGlowTop.isFinished())
                mEdgeGlowTop.onRelease();
        }
        if(true) goto _L12; else goto _L3
_L3:
        int j;
        if(!mIsBeingDragged)
            continue; /* Loop/switch isn't completed */
        VelocityTracker velocitytracker = mVelocityTracker;
        velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
        j = (int)velocitytracker.getYVelocity(mActivePointerId);
        if(getChildCount() <= 0) goto _L14; else goto _L13
_L13:
        if(Math.abs(j) <= mMinimumVelocity) goto _L16; else goto _L15
_L15:
        fling(-j);
_L14:
        mActivePointerId = -1;
        endDrag();
        continue; /* Loop/switch isn't completed */
_L16:
        if(mScroller.springBack(super.mScrollX, super.mScrollY, 0, 0, 0, getScrollRange()))
            postInvalidateOnAnimation();
        if(true) goto _L14; else goto _L5
_L5:
        if(mIsBeingDragged && getChildCount() > 0) {
            if(mScroller.springBack(super.mScrollX, super.mScrollY, 0, 0, 0, getScrollRange()))
                postInvalidateOnAnimation();
            mActivePointerId = -1;
            endDrag();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        int i = motionevent.getActionIndex();
        mLastMotionY = (int)motionevent.getY(i);
        mActivePointerId = motionevent.getPointerId(i);
        continue; /* Loop/switch isn't completed */
_L7:
        onSecondaryPointerUp(motionevent);
        mLastMotionY = (int)motionevent.getY(motionevent.findPointerIndex(mActivePointerId));
        if(true) goto _L1; else goto _L17
_L17:
    }

    public boolean pageScroll(int i) {
        int j;
        boolean flag;
        int k;
        View view;
        if(i == 130)
            flag = true;
        else
            flag = false;
        j = getHeight();
        if(!flag) goto _L2; else goto _L1
_L1:
        mTempRect.top = j + getScrollY();
        k = getChildCount();
        if(k > 0) {
            view = getChildAt(k - 1);
            if(j + mTempRect.top > view.getBottom())
                mTempRect.top = view.getBottom() - j;
        }
_L4:
        mTempRect.bottom = j + mTempRect.top;
        return scrollAndFocus(i, mTempRect.top, mTempRect.bottom);
_L2:
        mTempRect.top = getScrollY() - j;
        if(mTempRect.top < 0)
            mTempRect.top = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean flag = true;
        if(!super.performAccessibilityAction(i, bundle)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(isEnabled())
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
        switch(i) {
        default:
            flag = false;
            break;

        case 4096: 
            int l = Math.min((getHeight() - super.mPaddingBottom - super.mPaddingTop) + super.mScrollY, getScrollRange());
            if(l != super.mScrollY)
                smoothScrollTo(0, l);
            else
                flag = false;
            break;

        case 8192: 
            int j = getHeight() - super.mPaddingBottom - super.mPaddingTop;
            int k = Math.max(super.mScrollY - j, 0);
            if(k != super.mScrollY)
                smoothScrollTo(0, k);
            else
                flag = false;
            break;
        }
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void requestChildFocus(View view, View view1) {
        if(!mIsLayoutDirty)
            scrollToChild(view1);
        else
            mChildToScrollTo = view1;
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, flag);
    }

    public void requestDisallowInterceptTouchEvent(boolean flag) {
        if(flag)
            recycleVelocityTracker();
        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int j) {
        if(getChildCount() > 0) {
            View view = getChildAt(0);
            int k = clamp(i, getWidth() - super.mPaddingRight - super.mPaddingLeft, view.getWidth());
            int l = clamp(j, getHeight() - super.mPaddingBottom - super.mPaddingTop, view.getHeight());
            if(k != super.mScrollX || l != super.mScrollY)
                super.scrollTo(k, l);
        }
    }

    public void setFillViewport(boolean flag) {
        if(flag != mFillViewport) {
            mFillViewport = flag;
            requestLayout();
        }
    }

    public void setOverScrollMode(int i) {
        if(i != 2) {
            if(mEdgeGlowTop == null) {
                Context context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            }
        } else {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        }
        super.setOverScrollMode(i);
    }

    public void setSmoothScrollingEnabled(boolean flag) {
        mSmoothScrollingEnabled = flag;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, int j) {
        if(getChildCount() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(AnimationUtils.currentAnimationTimeMillis() - mLastScroll <= 250L)
            break; /* Loop/switch isn't completed */
        int k = getHeight() - super.mPaddingBottom - super.mPaddingTop;
        int l = Math.max(0, getChildAt(0).getHeight() - k);
        int i1 = super.mScrollY;
        int j1 = Math.max(0, Math.min(i1 + j, l)) - i1;
        mScroller.startScroll(super.mScrollX, i1, 0, j1);
        postInvalidateOnAnimation();
_L4:
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        if(true) goto _L1; else goto _L3
_L3:
        if(!mScroller.isFinished()) {
            mScroller.abortAnimation();
            if(mFlingStrictSpan != null) {
                mFlingStrictSpan.finish();
                mFlingStrictSpan = null;
            }
        }
        scrollBy(i, j);
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public final void smoothScrollTo(int i, int j) {
        smoothScrollBy(i - super.mScrollX, j - super.mScrollY);
    }

    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5F;
    private int mActivePointerId;
    private View mChildToScrollTo;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private android.os.StrictMode.Span mFlingStrictSpan;
    private boolean mIsBeingDragged;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private android.os.StrictMode.Span mScrollStrictSpan;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
}
