// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import java.util.List;

// Referenced classes of package android.widget:
//            FrameLayout, OverScroller, EdgeEffect

public class HorizontalScrollView extends FrameLayout {

    public HorizontalScrollView(Context context) {
        this(context, null);
    }

    public HorizontalScrollView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010353);
    }

    public HorizontalScrollView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mTempRect = new Rect();
        mIsLayoutDirty = true;
        mChildToScrollTo = null;
        mIsBeingDragged = false;
        mSmoothScrollingEnabled = true;
        mActivePointerId = -1;
        initScrollView();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.R.styleable.HorizontalScrollView, i, 0);
        setFillViewport(typedarray.getBoolean(0, false));
        typedarray.recycle();
    }

    private boolean canScroll() {
        boolean flag = false;
        View view = getChildAt(0);
        if(view != null) {
            int i = view.getWidth();
            if(getWidth() < i + super.mPaddingLeft + super.mPaddingRight)
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

    private void doScrollX(int i) {
        if(i != 0)
            if(mSmoothScrollingEnabled)
                smoothScrollBy(i, 0);
            else
                scrollBy(i, 0);
    }

    private View findFocusableViewInBounds(boolean flag, int i, int j) {
        java.util.ArrayList arraylist = getFocusables(2);
        View view = null;
        boolean flag1 = false;
        int k = arraylist.size();
        int l = 0;
        while(l < k)  {
            View view1 = (View)arraylist.get(l);
            int i1 = view1.getLeft();
            int j1 = view1.getRight();
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
                    if(flag && i1 < view.getLeft() || !flag && j1 > view.getRight())
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

    private View findFocusableViewInMyBounds(boolean flag, int i, View view) {
        int j = getHorizontalFadingEdgeLength() / 2;
        int k = i + j;
        int l = (i + getWidth()) - j;
        if(view == null || view.getLeft() >= l || view.getRight() <= k)
            view = findFocusableViewInBounds(flag, k, l);
        return view;
    }

    private int getScrollRange() {
        int i = 0;
        if(getChildCount() > 0)
            i = Math.max(0, getChildAt(0).getWidth() - (getWidth() - super.mPaddingLeft - super.mPaddingRight));
        return i;
    }

    private boolean inChild(int i, int j) {
        boolean flag = false;
        if(getChildCount() > 0) {
            int k = super.mScrollX;
            View view = getChildAt(0);
            if(j >= view.getTop() && j < view.getBottom() && i >= view.getLeft() - k && i < view.getRight() - k)
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
        if(!isWithinDeltaOfScreen(view, 0))
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

    private boolean isWithinDeltaOfScreen(View view, int i) {
        view.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view, mTempRect);
        boolean flag;
        if(i + mTempRect.right >= getScrollX() && mTempRect.left - i <= getScrollX() + getWidth())
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
            mLastMotionX = (int)motionevent.getX(j);
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
        int l = getWidth();
        int i1 = getScrollX();
        int j1 = i1 + l;
        boolean flag1;
        Object obj;
        if(i == 17)
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
            doScrollX(k1);
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
            scrollBy(i, 0);
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
                scrollBy(i, 0);
            else
                smoothScrollBy(i, 0);
        return flag1;
    }

    public void addView(View view) {
        if(getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        } else {
            super.addView(view);
            return;
        }
    }

    public void addView(View view, int i) {
        if(getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        } else {
            super.addView(view, i);
            return;
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        if(getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        } else {
            super.addView(view, i, layoutparams);
            return;
        }
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams) {
        if(getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
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
        if(view1 == null || !isWithinDeltaOfScreen(view1, j)) goto _L2; else goto _L1
_L1:
        view1.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view1, mTempRect);
        doScrollX(computeScrollDeltaToGetChildRectOnScreen(mTempRect));
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
        if(i == 17 && getScrollX() < k)
            k = getScrollX();
        else
        if(i == 66 && getChildCount() > 0) {
            int l = getChildAt(0).getRight();
            int i1 = getScrollX() + getWidth();
            if(l - i1 < j)
                k = l - i1;
        }
        if(k == 0) goto _L4; else goto _L3
_L3:
        int j1;
        if(i == 66)
            j1 = k;
        else
            j1 = -k;
        doScrollX(j1);
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected int computeHorizontalScrollOffset() {
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    protected int computeHorizontalScrollRange() {
        int i;
        int j;
        i = getChildCount();
        j = getWidth() - super.mPaddingLeft - super.mPaddingRight;
        if(i != 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int k;
        int l;
        int i1;
        k = getChildAt(0).getRight();
        l = super.mScrollX;
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

    public void computeScroll() {
        int i = 1;
        if(!mScroller.computeScrollOffset()) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        int l;
        int i1;
        j = super.mScrollX;
        k = super.mScrollY;
        l = mScroller.getCurrX();
        i1 = mScroller.getCurrY();
        if(j == l && k == i1) goto _L4; else goto _L3
_L3:
        int j1;
        j1 = getScrollRange();
        int k1 = getOverScrollMode();
        if(k1 != 0 && (k1 != i || j1 <= 0))
            i = 0;
        overScrollBy(l - j, i1 - k, j, k, j1, 0, mOverflingDistance, 0, false);
        onScrollChanged(super.mScrollX, super.mScrollY, j, k);
        if(i == 0) goto _L4; else goto _L5
_L5:
        if(l >= 0 || j < 0) goto _L7; else goto _L6
_L6:
        mEdgeGlowLeft.onAbsorb((int)mScroller.getCurrVelocity());
_L4:
        if(!awakenScrollBars())
            postInvalidateOnAnimation();
_L2:
        return;
_L7:
        if(l > j1 && j <= j1)
            mEdgeGlowRight.onAbsorb((int)mScroller.getCurrVelocity());
        if(true) goto _L4; else goto _L8
_L8:
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if(getChildCount() != 0) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L4:
        return i1;
_L2:
        int i = getWidth();
        int j = getScrollX();
        int k = j + i;
        int l = getHorizontalFadingEdgeLength();
        if(rect.left > 0)
            j += l;
        if(rect.right < getChildAt(0).getWidth())
            k -= l;
        i1 = 0;
        if(rect.right > k && rect.left > j) {
            int k1;
            if(rect.width() > i)
                k1 = 0 + (rect.left - j);
            else
                k1 = 0 + (rect.right - k);
            i1 = Math.min(k1, getChildAt(0).getRight() - k);
        } else
        if(rect.left < j && rect.right < k) {
            int j1;
            if(rect.width() > i)
                j1 = 0 - (k - rect.right);
            else
                j1 = 0 - (j - rect.left);
            i1 = Math.max(j1, -getScrollX());
        }
        if(true) goto _L4; else goto _L3
_L3:
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
        if(mEdgeGlowLeft != null) {
            int i = super.mScrollX;
            if(!mEdgeGlowLeft.isFinished()) {
                int i1 = canvas.save();
                int j1 = getHeight() - super.mPaddingTop - super.mPaddingBottom;
                canvas.rotate(270F);
                canvas.translate(-j1 + super.mPaddingTop, Math.min(0, i));
                mEdgeGlowLeft.setSize(j1, getWidth());
                if(mEdgeGlowLeft.draw(canvas))
                    postInvalidateOnAnimation();
                canvas.restoreToCount(i1);
            }
            if(!mEdgeGlowRight.isFinished()) {
                int j = canvas.save();
                int k = getWidth();
                int l = getHeight() - super.mPaddingTop - super.mPaddingBottom;
                canvas.rotate(90F);
                canvas.translate(-super.mPaddingTop, -(k + Math.max(getScrollRange(), i)));
                mEdgeGlowRight.setSize(l, k);
                if(mEdgeGlowRight.draw(canvas))
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
        if(isFocused()) {
            View view = findFocus();
            if(view == this)
                view = null;
            View view1 = FocusFinder.getInstance().findNextFocus(this, view, 66);
            if(view1 != null && view1 != this && view1.requestFocus(66))
                flag = true;
        }
_L10:
        return flag;
_L2:
        boolean flag1 = false;
        if(keyevent.getAction() != 0) goto _L4; else goto _L3
_L3:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 124
    //                   21: 129
    //                   22: 156
    //                   62: 183;
           goto _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_183;
_L5:
        break; /* Loop/switch isn't completed */
_L6:
        break; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        if(true) goto _L10; else goto _L9
_L9:
        if(!keyevent.isAltPressed())
            flag1 = arrowScroll(17);
        else
            flag1 = fullScroll(17);
          goto _L4
_L7:
        if(!keyevent.isAltPressed())
            flag1 = arrowScroll(66);
        else
            flag1 = fullScroll(66);
          goto _L4
        byte byte0;
        if(keyevent.isShiftPressed())
            byte0 = 17;
        else
            byte0 = 66;
        pageScroll(byte0);
          goto _L4
    }

    public void fling(int i) {
        if(getChildCount() > 0) {
            int j = getWidth() - super.mPaddingRight - super.mPaddingLeft;
            int k = getChildAt(0).getWidth();
            mScroller.fling(super.mScrollX, super.mScrollY, i, 0, 0, Math.max(0, k - j), 0, 0, j / 2, 0);
            boolean flag;
            View view;
            Object obj;
            if(i > 0)
                flag = true;
            else
                flag = false;
            view = findFocus();
            obj = findFocusableViewInMyBounds(flag, mScroller.getFinalX(), view);
            if(obj == null)
                obj = this;
            if(obj != view) {
                byte byte0;
                if(flag)
                    byte0 = 66;
                else
                    byte0 = 17;
                ((View) (obj)).requestFocus(byte0);
            }
            postInvalidateOnAnimation();
        }
    }

    public boolean fullScroll(int i) {
        boolean flag;
        int j;
        if(i == 66)
            flag = true;
        else
            flag = false;
        j = getWidth();
        mTempRect.left = 0;
        mTempRect.right = j;
        if(flag && getChildCount() > 0) {
            View view = getChildAt(0);
            mTempRect.right = view.getRight();
            mTempRect.left = mTempRect.right - j;
        }
        return scrollAndFocus(i, mTempRect.left, mTempRect.right);
    }

    protected float getLeftFadingEdgeStrength() {
        float f;
        if(getChildCount() == 0) {
            f = 0.0F;
        } else {
            int i = getHorizontalFadingEdgeLength();
            if(super.mScrollX < i)
                f = (float)super.mScrollX / (float)i;
            else
                f = 1.0F;
        }
        return f;
    }

    public int getMaxScrollAmount() {
        return (int)(0.5F * (float)(super.mRight - super.mLeft));
    }

    protected float getRightFadingEdgeStrength() {
        float f;
        if(getChildCount() == 0) {
            f = 0.0F;
        } else {
            int i = getHorizontalFadingEdgeLength();
            int j = getWidth() - super.mPaddingRight;
            int k = getChildAt(0).getRight() - super.mScrollX - j;
            if(k < i)
                f = (float)k / (float)i;
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
        int k = getChildMeasureSpec(j, super.mPaddingTop + super.mPaddingBottom, layoutparams.height);
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), k);
    }

    protected void measureChildWithMargins(View view, int i, int j, int k, int l) {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i1 = getChildMeasureSpec(k, l + (super.mPaddingTop + super.mPaddingBottom + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin), ((android.view.ViewGroup.LayoutParams) (marginlayoutparams)).height);
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(marginlayoutparams.leftMargin + marginlayoutparams.rightMargin, 0), i1);
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
_L7:
        return flag;
_L3:
        if(mIsBeingDragged) goto _L2; else goto _L4
_L4:
        float f;
        if((1 & motionevent.getMetaState()) != 0)
            f = -motionevent.getAxisValue(9);
        else
            f = motionevent.getAxisValue(10);
        if(f == 0.0F) goto _L2; else goto _L5
_L5:
        int i = (int)(f * getHorizontalScrollFactor());
        int j = getScrollRange();
        int k = super.mScrollX;
        int l = k + i;
        if(l < 0)
            l = 0;
        else
        if(l > j)
            l = j;
        if(l == k) goto _L2; else goto _L6
_L6:
        super.scrollTo(l, super.mScrollY);
        flag = true;
          goto _L7
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/HorizontalScrollView.getName());
        boolean flag;
        if(getScrollRange() > 0)
            flag = true;
        else
            flag = false;
        accessibilityevent.setScrollable(flag);
        accessibilityevent.setScrollX(super.mScrollX);
        accessibilityevent.setScrollY(super.mScrollY);
        accessibilityevent.setMaxScrollX(getScrollRange());
        accessibilityevent.setMaxScrollY(super.mScrollY);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/HorizontalScrollView.getName());
        int i = getScrollRange();
        if(i > 0) {
            accessibilitynodeinfo.setScrollable(true);
            if(isEnabled() && super.mScrollX > 0)
                accessibilitynodeinfo.addAction(8192);
            if(isEnabled() && super.mScrollX < i)
                accessibilitynodeinfo.addAction(4096);
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
    //                   0 166
    //                   1 246
    //                   2 80
    //                   3 246
    //                   4 72
    //                   5 289
    //                   6 319;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_319;
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        break; /* Loop/switch isn't completed */
_L10:
        flag = mIsBeingDragged;
        if(true) goto _L1; else goto _L9
_L9:
        int l = mActivePointerId;
        if(l != -1) {
            int i1 = (int)motionevent.getX(motionevent.findPointerIndex(l));
            if(Math.abs(i1 - mLastMotionX) > mTouchSlop) {
                mIsBeingDragged = flag;
                mLastMotionX = i1;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(motionevent);
                if(super.mParent != null)
                    super.mParent.requestDisallowInterceptTouchEvent(flag);
            }
        }
          goto _L10
_L4:
        int k = (int)motionevent.getX();
        if(!inChild(k, (int)motionevent.getY())) {
            mIsBeingDragged = false;
            recycleVelocityTracker();
        } else {
            mLastMotionX = k;
            mActivePointerId = motionevent.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(motionevent);
            if(!mScroller.isFinished())
                flag1 = flag;
            mIsBeingDragged = flag1;
        }
          goto _L10
_L5:
        mIsBeingDragged = false;
        mActivePointerId = -1;
        if(mScroller.springBack(super.mScrollX, super.mScrollY, 0, getScrollRange(), 0, 0))
            postInvalidateOnAnimation();
          goto _L10
_L7:
        int j = motionevent.getActionIndex();
        mLastMotionX = (int)motionevent.getX(j);
        mActivePointerId = motionevent.getPointerId(j);
          goto _L10
        onSecondaryPointerUp(motionevent);
        mLastMotionX = (int)motionevent.getX(motionevent.findPointerIndex(mActivePointerId));
          goto _L10
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
            while(!mFillViewport || android.view.View.MeasureSpec.getMode(i) == 0 || getChildCount() <= 0);
            View view = getChildAt(0);
            int k = getMeasuredWidth();
            if(view.getMeasuredWidth() < k) {
                FrameLayout.LayoutParams layoutparams = (FrameLayout.LayoutParams)view.getLayoutParams();
                int l = getChildMeasureSpec(j, super.mPaddingTop + super.mPaddingBottom, ((android.view.ViewGroup.LayoutParams) (layoutparams)).height);
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k - super.mPaddingLeft - super.mPaddingRight, 0x40000000), l);
            }
        }
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1) {
        if(!mScroller.isFinished()) {
            super.mScrollX = i;
            super.mScrollY = j;
            invalidateParentIfNeeded();
            if(flag)
                mScroller.springBack(super.mScrollX, super.mScrollY, 0, getScrollRange(), 0, 0);
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
            i = 66;
        else
        if(i == 1)
            i = 17;
        if(rect == null)
            view = FocusFinder.getInstance().findNextFocus(this, null, i);
        else
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        break MISSING_BLOCK_LABEL_25;
        if(view != null && !isOffScreen(view))
            flag = view.requestFocus(i, rect);
        return flag;
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        View view;
        super.onSizeChanged(i, j, k, l);
        view = findFocus();
        break MISSING_BLOCK_LABEL_15;
        if(view != null && this != view && isWithinDeltaOfScreen(view, super.mRight - super.mLeft)) {
            view.getDrawingRect(mTempRect);
            offsetDescendantRectToMyCoords(view, mTempRect);
            doScrollX(computeScrollDeltaToGetChildRectOnScreen(mTempRect));
        }
        return;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(motionevent);
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 64
    //                   0 68
    //                   1 496
    //                   2 167
    //                   3 628
    //                   4 64
    //                   5 64
    //                   6 710;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1 _L6
_L1:
        boolean flag = true;
_L8:
        return flag;
_L2:
        if(getChildCount() != 0)
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L8; else goto _L7
_L7:
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
        if(!mScroller.isFinished())
            mScroller.abortAnimation();
        mLastMotionX = (int)motionevent.getX();
        mActivePointerId = motionevent.getPointerId(0);
        continue; /* Loop/switch isn't completed */
_L4:
        int j = (int)motionevent.getX(motionevent.findPointerIndex(mActivePointerId));
        int k = mLastMotionX - j;
        int j1;
        boolean flag1;
        int l1;
        if(!mIsBeingDragged && Math.abs(k) > mTouchSlop) {
            ViewParent viewparent = getParent();
            if(viewparent != null)
                viewparent.requestDisallowInterceptTouchEvent(true);
            mIsBeingDragged = true;
            int l;
            int i1;
            int k1;
            if(k > 0)
                k -= mTouchSlop;
            else
                k += mTouchSlop;
        }
        if(!mIsBeingDragged)
            continue; /* Loop/switch isn't completed */
        mLastMotionX = j;
        l = super.mScrollX;
        i1 = super.mScrollY;
        j1 = getScrollRange();
        k1 = getOverScrollMode();
        if(k1 == 0 || k1 == 1 && j1 > 0)
            flag1 = true;
        else
            flag1 = false;
        if(overScrollBy(k, 0, super.mScrollX, 0, j1, 0, mOverscrollDistance, 0, true))
            mVelocityTracker.clear();
        onScrollChanged(super.mScrollX, super.mScrollY, l, i1);
        if(!flag1)
            continue; /* Loop/switch isn't completed */
        l1 = l + k;
        if(l1 < 0) {
            mEdgeGlowLeft.onPull((float)k / (float)getWidth());
            if(!mEdgeGlowRight.isFinished())
                mEdgeGlowRight.onRelease();
        } else
        if(l1 > j1) {
            mEdgeGlowRight.onPull((float)k / (float)getWidth());
            if(!mEdgeGlowLeft.isFinished())
                mEdgeGlowLeft.onRelease();
        }
        if(mEdgeGlowLeft != null && (!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()))
            postInvalidateOnAnimation();
        continue; /* Loop/switch isn't completed */
_L3:
        if(!mIsBeingDragged)
            continue; /* Loop/switch isn't completed */
        VelocityTracker velocitytracker = mVelocityTracker;
        velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
        int i = (int)velocitytracker.getXVelocity(mActivePointerId);
        if(getChildCount() > 0)
            if(Math.abs(i) > mMinimumVelocity)
                fling(-i);
            else
            if(mScroller.springBack(super.mScrollX, super.mScrollY, 0, getScrollRange(), 0, 0))
                postInvalidateOnAnimation();
        mActivePointerId = -1;
        mIsBeingDragged = false;
        recycleVelocityTracker();
        if(mEdgeGlowLeft != null) {
            mEdgeGlowLeft.onRelease();
            mEdgeGlowRight.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if(mIsBeingDragged && getChildCount() > 0) {
            if(mScroller.springBack(super.mScrollX, super.mScrollY, 0, getScrollRange(), 0, 0))
                postInvalidateOnAnimation();
            mActivePointerId = -1;
            mIsBeingDragged = false;
            recycleVelocityTracker();
            if(mEdgeGlowLeft != null) {
                mEdgeGlowLeft.onRelease();
                mEdgeGlowRight.onRelease();
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        onSecondaryPointerUp(motionevent);
        if(true) goto _L1; else goto _L9
_L9:
    }

    public boolean pageScroll(int i) {
        int j;
        boolean flag;
        View view;
        if(i == 66)
            flag = true;
        else
            flag = false;
        j = getWidth();
        if(!flag) goto _L2; else goto _L1
_L1:
        mTempRect.left = j + getScrollX();
        if(getChildCount() > 0) {
            view = getChildAt(0);
            if(j + mTempRect.left > view.getRight())
                mTempRect.left = view.getRight() - j;
        }
_L4:
        mTempRect.right = j + mTempRect.left;
        return scrollAndFocus(i, mTempRect.left, mTempRect.right);
_L2:
        mTempRect.left = getScrollX() - j;
        if(mTempRect.left < 0)
            mTempRect.left = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean flag = true;
        if(!super.performAccessibilityAction(i, bundle)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        switch(i) {
        default:
            flag = false;
            break;

        case 4096: 
            if(!isEnabled()) {
                flag = false;
            } else {
                int l = Math.min((getWidth() - super.mPaddingLeft - super.mPaddingRight) + super.mScrollX, getScrollRange());
                if(l != super.mScrollX)
                    smoothScrollTo(l, 0);
                else
                    flag = false;
            }
            break;

        case 8192: 
            if(!isEnabled()) {
                flag = false;
            } else {
                int j = getWidth() - super.mPaddingLeft - super.mPaddingRight;
                int k = Math.max(0, super.mScrollX - j);
                if(k != super.mScrollX)
                    smoothScrollTo(k, 0);
                else
                    flag = false;
            }
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
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
            if(mEdgeGlowLeft == null) {
                Context context = getContext();
                mEdgeGlowLeft = new EdgeEffect(context);
                mEdgeGlowRight = new EdgeEffect(context);
            }
        } else {
            mEdgeGlowLeft = null;
            mEdgeGlowRight = null;
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
        int k = getWidth() - super.mPaddingRight - super.mPaddingLeft;
        int l = Math.max(0, getChildAt(0).getWidth() - k);
        int i1 = super.mScrollX;
        int j1 = Math.max(0, Math.min(i1 + i, l)) - i1;
        mScroller.startScroll(i1, super.mScrollY, j1, 0);
        postInvalidateOnAnimation();
_L4:
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        if(true) goto _L1; else goto _L3
_L3:
        if(!mScroller.isFinished())
            mScroller.abortAnimation();
        scrollBy(i, j);
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public final void smoothScrollTo(int i, int j) {
        smoothScrollBy(i - super.mScrollX, j - super.mScrollY);
    }

    private static final int ANIMATED_SCROLL_GAP = 250;
    private static final int INVALID_POINTER = -1;
    private static final float MAX_SCROLL_FACTOR = 0.5F;
    private int mActivePointerId;
    private View mChildToScrollTo;
    private EdgeEffect mEdgeGlowLeft;
    private EdgeEffect mEdgeGlowRight;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLayoutDirty;
    private int mLastMotionX;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
}
