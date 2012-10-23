// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Transformation;

// Referenced classes of package android.widget:
//            AbsSpinner, AdapterView, SpinnerAdapter, Scroller

public class Gallery extends AbsSpinner
    implements android.view.GestureDetector.OnGestureListener {
    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {

        public LayoutParams(int i, int j) {
            super(i, j);
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
            super(layoutparams);
        }
    }


    public Gallery(Context context) {
        Gallery(context, null);
    }

    public Gallery(Context context, AttributeSet attributeset) {
        Gallery(context, attributeset, 0x1010070);
    }

    public Gallery(Context context, AttributeSet attributeset, int i) {
        AbsSpinner(context, attributeset, i);
        mSpacing = 0;
        mAnimationDuration = 400;
        mFlingRunnable = new FlingRunnable();
        mShouldCallbackDuringFling = true;
        mShouldCallbackOnUnselectedItemClick = true;
        mIsRtl = true;
        mGestureDetector = new GestureDetector(context, this);
        mGestureDetector.setIsLongpressEnabled(true);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Gallery, i, 0);
        int j = typedarray.getInt(0, -1);
        if(j >= 0)
            setGravity(j);
        int k = typedarray.getInt(1, -1);
        if(k > 0)
            setAnimationDuration(k);
        setSpacing(typedarray.getDimensionPixelOffset(2, 0));
        setUnselectedAlpha(typedarray.getFloat(3, 0.5F));
        typedarray.recycle();
        super.mGroupFlags = 0x400 | super.mGroupFlags;
        super.mGroupFlags = 0x800 | super.mGroupFlags;
    }

    private int calculateTop(View view, boolean flag) {
        int i;
        int j;
        int k;
        if(flag)
            i = getMeasuredHeight();
        else
            i = getHeight();
        if(flag)
            j = view.getMeasuredHeight();
        else
            j = view.getHeight();
        k = 0;
        mGravity;
        JVM INSTR lookupswitch 3: default 60
    //                   16: 92
    //                   48: 80
    //                   80: 131;
           goto _L1 _L2 _L3 _L4
_L1:
        return k;
_L3:
        k = super.mSpinnerPadding.top;
        continue; /* Loop/switch isn't completed */
_L2:
        int l = i - super.mSpinnerPadding.bottom - super.mSpinnerPadding.top - j;
        k = super.mSpinnerPadding.top + l / 2;
        continue; /* Loop/switch isn't completed */
_L4:
        k = i - super.mSpinnerPadding.bottom - j;
        if(true) goto _L1; else goto _L5
_L5:
    }

    private void detachOffScreenChildren(boolean flag) {
        int i;
        int j;
        int k;
        int l;
        i = getChildCount();
        j = super.mFirstPosition;
        k = 0;
        l = 0;
        if(!flag) goto _L2; else goto _L1
_L1:
        int l1;
        int i2;
        l1 = super.mPaddingLeft;
        i2 = 0;
_L6:
        if(i2 >= i) goto _L4; else goto _L3
_L3:
        int j2;
        View view1;
        if(mIsRtl)
            j2 = i - 1 - i2;
        else
            j2 = i2;
        view1 = getChildAt(j2);
        if(view1.getRight() < l1) goto _L5; else goto _L4
_L4:
        if(!mIsRtl)
            k = 0;
_L7:
        detachViewsFromParent(k, l);
        if(flag != mIsRtl)
            super.mFirstPosition = l + super.mFirstPosition;
        return;
_L5:
        k = j2;
        l++;
        super.mRecycler.put(j + j2, view1);
        i2++;
          goto _L6
_L2:
        int i1;
        int j1;
        i1 = getWidth() - super.mPaddingRight;
        j1 = i - 1;
_L8:
        int k1;
        View view;
label0:
        {
            if(j1 >= 0) {
                if(mIsRtl)
                    k1 = i - 1 - j1;
                else
                    k1 = j1;
                view = getChildAt(k1);
                if(view.getLeft() > i1)
                    break label0;
            }
            if(mIsRtl)
                k = 0;
        }
          goto _L7
        k = k1;
        l++;
        super.mRecycler.put(j + k1, view);
        j1--;
          goto _L8
    }

    private boolean dispatchLongPress(View view, int i, long l) {
        boolean flag = false;
        if(super.mOnItemLongClickListener != null)
            flag = super.mOnItemLongClickListener.onItemLongClick(this, mDownTouchView, mDownTouchPosition, l);
        if(!flag) {
            mContextMenuInfo = new AdapterContextMenuInfo(view, i, l);
            flag = showContextMenuForChild(this);
        }
        if(flag)
            performHapticFeedback(0);
        return flag;
    }

    private void dispatchPress(View view) {
        if(view != null)
            view.setPressed(true);
        setPressed(true);
    }

    private void dispatchUnpress() {
        for(int i = -1 + getChildCount(); i >= 0; i--)
            getChildAt(i).setPressed(false);

        setPressed(false);
    }

    private void fillToGalleryLeft() {
        if(mIsRtl)
            fillToGalleryLeftRtl();
        else
            fillToGalleryLeftLtr();
    }

    private void fillToGalleryLeftLtr() {
        int i = mSpacing;
        int j = super.mPaddingLeft;
        View view = getChildAt(0);
        int k;
        int l;
        if(view != null) {
            k = -1 + super.mFirstPosition;
            l = view.getLeft() - i;
        } else {
            k = 0;
            l = super.mRight - super.mLeft - super.mPaddingRight;
            mShouldStopFling = true;
        }
        for(; l > j && k >= 0; k--) {
            View view1 = makeAndAddView(k, k - super.mSelectedPosition, l, false);
            super.mFirstPosition = k;
            l = view1.getLeft() - i;
        }

    }

    private void fillToGalleryLeftRtl() {
        int i = mSpacing;
        int j = super.mPaddingLeft;
        int k = getChildCount();
        int _tmp = super.mItemCount;
        View view = getChildAt(k - 1);
        int l;
        int i1;
        if(view != null) {
            l = k + super.mFirstPosition;
            i1 = view.getLeft() - i;
        } else {
            l = -1 + super.mItemCount;
            super.mFirstPosition = l;
            i1 = super.mRight - super.mLeft - super.mPaddingRight;
            mShouldStopFling = true;
        }
        for(; i1 > j && l < super.mItemCount; l++)
            i1 = makeAndAddView(l, l - super.mSelectedPosition, i1, false).getLeft() - i;

    }

    private void fillToGalleryRight() {
        if(mIsRtl)
            fillToGalleryRightRtl();
        else
            fillToGalleryRightLtr();
    }

    private void fillToGalleryRightLtr() {
        int i = mSpacing;
        int j = super.mRight - super.mLeft - super.mPaddingRight;
        int k = getChildCount();
        int l = super.mItemCount;
        View view = getChildAt(k - 1);
        int i1;
        int j1;
        if(view != null) {
            i1 = k + super.mFirstPosition;
            j1 = i + view.getRight();
        } else {
            i1 = -1 + super.mItemCount;
            super.mFirstPosition = i1;
            j1 = super.mPaddingLeft;
            mShouldStopFling = true;
        }
        for(; j1 < j && i1 < l; i1++)
            j1 = i + makeAndAddView(i1, i1 - super.mSelectedPosition, j1, true).getRight();

    }

    private void fillToGalleryRightRtl() {
        int i = mSpacing;
        int j = super.mRight - super.mLeft - super.mPaddingRight;
        View view = getChildAt(0);
        int k;
        int l;
        if(view != null) {
            k = -1 + super.mFirstPosition;
            l = i + view.getRight();
        } else {
            k = 0;
            l = super.mPaddingLeft;
            mShouldStopFling = true;
        }
        for(; l < j && k >= 0; k--) {
            View view1 = makeAndAddView(k, k - super.mSelectedPosition, l, true);
            super.mFirstPosition = k;
            l = i + view1.getRight();
        }

    }

    private int getCenterOfGallery() {
        return (getWidth() - super.mPaddingLeft - super.mPaddingRight) / 2 + super.mPaddingLeft;
    }

    private static int getCenterOfView(View view) {
        return view.getLeft() + view.getWidth() / 2;
    }

    private View makeAndAddView(int i, int j, int k, boolean flag) {
        if(super.mDataChanged) goto _L2; else goto _L1
_L1:
        View view2 = super.mRecycler.get(i);
        if(view2 == null) goto _L2; else goto _L3
_L3:
        View view1;
        int l = view2.getLeft();
        mRightMost = Math.max(mRightMost, l + view2.getMeasuredWidth());
        mLeftMost = Math.min(mLeftMost, l);
        setUpChild(view2, j, k, flag);
        view1 = view2;
_L5:
        return view1;
_L2:
        View view = super.mAdapter.getView(i, null, this);
        setUpChild(view, j, k, flag);
        view1 = view;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void offsetChildrenLeftAndRight(int i) {
        for(int j = -1 + getChildCount(); j >= 0; j--)
            getChildAt(j).offsetLeftAndRight(i);

    }

    private void onFinishedMovement() {
        if(mSuppressSelectionChanged) {
            mSuppressSelectionChanged = false;
            selectionChanged();
        }
        invalidate();
    }

    private void scrollIntoSlots() {
        if(getChildCount() != 0 && mSelectedChild != null) {
            int i = getCenterOfView(mSelectedChild);
            int j = getCenterOfGallery() - i;
            if(j != 0)
                mFlingRunnable.startUsingDistance(j);
            else
                onFinishedMovement();
        }
    }

    private boolean scrollToChild(int i) {
        View view = getChildAt(i);
        boolean flag;
        if(view != null) {
            int j = getCenterOfGallery() - getCenterOfView(view);
            mFlingRunnable.startUsingDistance(j);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private void setSelectionToCenterChild() {
        View view = mSelectedChild;
        if(mSelectedChild != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        int k;
        int l;
        i = getCenterOfGallery();
        if(view.getLeft() <= i && view.getRight() >= i)
            continue; /* Loop/switch isn't completed */
        j = 0x7fffffff;
        k = 0;
        l = -1 + getChildCount();
_L4:
        View view1;
label0:
        {
            if(l >= 0) {
                view1 = getChildAt(l);
                if(view1.getLeft() > i || view1.getRight() < i)
                    break label0;
                k = l;
            }
            int i1 = k + super.mFirstPosition;
            if(i1 != super.mSelectedPosition) {
                setSelectedPositionInt(i1);
                setNextSelectedPositionInt(i1);
                checkSelectionChanged();
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        int j1 = Math.min(Math.abs(view1.getLeft() - i), Math.abs(view1.getRight() - i));
        if(j1 < j) {
            j = j1;
            k = l;
        }
        l--;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    private void setUpChild(View view, int i, int j, boolean flag) {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if(layoutparams == null)
            layoutparams = (LayoutParams)generateDefaultLayoutParams();
        byte byte0;
        boolean flag1;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if(flag != mIsRtl)
            byte0 = -1;
        else
            byte0 = 0;
        addViewInLayout(view, byte0, layoutparams);
        if(i == 0)
            flag1 = true;
        else
            flag1 = false;
        view.setSelected(flag1);
        k = ViewGroup.getChildMeasureSpec(super.mHeightMeasureSpec, super.mSpinnerPadding.top + super.mSpinnerPadding.bottom, ((android.view.ViewGroup.LayoutParams) (layoutparams)).height);
        view.measure(ViewGroup.getChildMeasureSpec(super.mWidthMeasureSpec, super.mSpinnerPadding.left + super.mSpinnerPadding.right, ((android.view.ViewGroup.LayoutParams) (layoutparams)).width), k);
        l = calculateTop(view, true);
        i1 = l + view.getMeasuredHeight();
        j1 = view.getMeasuredWidth();
        if(flag) {
            k1 = j;
            l1 = k1 + j1;
        } else {
            k1 = j - j1;
            l1 = j;
        }
        view.layout(k1, l, l1, i1);
    }

    private void updateSelectedItemMetadata() {
        View view;
        View view1;
        view = mSelectedChild;
        view1 = getChildAt(super.mSelectedPosition - super.mFirstPosition);
        mSelectedChild = view1;
        if(view1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        view1.setSelected(true);
        view1.setFocusable(true);
        if(hasFocus())
            view1.requestFocus();
        if(view != null && view != view1) {
            view.setSelected(false);
            view.setFocusable(false);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    protected int computeHorizontalScrollExtent() {
        return 1;
    }

    protected int computeHorizontalScrollOffset() {
        return super.mSelectedPosition;
    }

    protected int computeHorizontalScrollRange() {
        return super.mItemCount;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        return keyevent.dispatch(this, null, null);
    }

    protected void dispatchSetPressed(boolean flag) {
        if(mSelectedChild != null)
            mSelectedChild.setPressed(flag);
    }

    public void dispatchSetSelected(boolean flag) {
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return new LayoutParams(layoutparams);
    }

    protected int getChildDrawingOrder(int i, int j) {
        int k = super.mSelectedPosition - super.mFirstPosition;
        if(k >= 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        if(j == i - 1)
            j = k;
        else
        if(j >= k)
            j++;
        if(true) goto _L1; else goto _L3
_L3:
    }

    int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        float f;
        if(view == mSelectedChild)
            f = 1.0F;
        else
            f = mUnselectedAlpha;
        transformation.setAlpha(f);
        return true;
    }

    protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return mContextMenuInfo;
    }

    int getLimitedMotionScrollAmount(boolean flag, int i) {
        int j;
        View view;
        j = 0;
        int k;
        if(flag != mIsRtl)
            k = -1 + super.mItemCount;
        else
            k = 0;
        view = getChildAt(k - super.mFirstPosition);
        if(view != null) goto _L2; else goto _L1
_L1:
        j = i;
_L4:
        return j;
_L2:
        int l = getCenterOfView(view);
        int i1 = getCenterOfGallery();
        if(flag ? l > i1 : l < i1) {
            int j1 = i1 - l;
            if(flag)
                j = Math.max(j1, i);
            else
                j = Math.min(j1, i);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    void layout(int i, boolean flag) {
        mIsRtl = isLayoutRtl();
        int j = super.mSpinnerPadding.left;
        int k = super.mRight - super.mLeft - super.mSpinnerPadding.left - super.mSpinnerPadding.right;
        if(super.mDataChanged)
            handleDataChanged();
        if(super.mItemCount == 0) {
            resetList();
        } else {
            if(super.mNextSelectedPosition >= 0)
                setSelectedPositionInt(super.mNextSelectedPosition);
            recycleAllViews();
            detachAllViewsFromParent();
            mRightMost = 0;
            mLeftMost = 0;
            super.mFirstPosition = super.mSelectedPosition;
            View view = makeAndAddView(super.mSelectedPosition, 0, 0, true);
            view.offsetLeftAndRight((j + k / 2) - view.getWidth() / 2);
            fillToGalleryRight();
            fillToGalleryLeft();
            super.mRecycler.clear();
            invalidate();
            checkSelectionChanged();
            super.mDataChanged = false;
            super.mNeedSync = false;
            setNextSelectedPositionInt(super.mSelectedPosition);
            updateSelectedItemMetadata();
        }
    }

    boolean moveNext() {
        boolean flag;
        if(super.mItemCount > 0 && super.mSelectedPosition < -1 + super.mItemCount) {
            scrollToChild(1 + (super.mSelectedPosition - super.mFirstPosition));
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    boolean movePrevious() {
        boolean flag;
        if(super.mItemCount > 0 && super.mSelectedPosition > 0) {
            scrollToChild(-1 + (super.mSelectedPosition - super.mFirstPosition));
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    void onCancel() {
        onUp();
    }

    public boolean onDown(MotionEvent motionevent) {
        mFlingRunnable.stop(false);
        mDownTouchPosition = pointToPosition((int)motionevent.getX(), (int)motionevent.getY());
        if(mDownTouchPosition >= 0) {
            mDownTouchView = getChildAt(mDownTouchPosition - super.mFirstPosition);
            mDownTouchView.setPressed(true);
        }
        mIsFirstScroll = true;
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1) {
        if(!mShouldCallbackDuringFling) {
            removeCallbacks(mDisableSuppressSelectionChangedRunnable);
            if(!mSuppressSelectionChanged)
                mSuppressSelectionChanged = true;
        }
        mFlingRunnable.startUsingVelocity((int)(-f));
        return true;
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect) {
        onFocusChanged(flag, i, rect);
        if(flag && mSelectedChild != null) {
            mSelectedChild.requestFocus(i);
            mSelectedChild.setSelected(true);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/Gallery.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        boolean flag = true;
        onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/Gallery.getName());
        if(super.mItemCount <= flag)
            flag = false;
        accessibilitynodeinfo.setScrollable(flag);
        if(isEnabled()) {
            if(super.mItemCount > 0 && super.mSelectedPosition < -1 + super.mItemCount)
                accessibilitynodeinfo.addAction(4096);
            if(isEnabled() && super.mItemCount > 0 && super.mSelectedPosition > 0)
                accessibilitynodeinfo.addAction(8192);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   21: 53
    //                   22: 68
    //                   23: 83
    //                   66: 83;
           goto _L1 _L2 _L3 _L4 _L4
_L1:
        flag = onKeyDown(i, keyevent);
_L5:
        return flag;
_L2:
        if(movePrevious())
            playSoundEffect(flag);
        continue; /* Loop/switch isn't completed */
_L3:
        if(moveNext())
            playSoundEffect(3);
        if(true) goto _L5; else goto _L4
_L4:
        mReceivedInvokeKeyDown = flag;
        if(true) goto _L1; else goto _L6
_L6:
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   23: 37
    //                   66: 37;
           goto _L1 _L2 _L2
_L1:
        boolean flag = onKeyUp(i, keyevent);
_L4:
        return flag;
_L2:
        if(mReceivedInvokeKeyDown && super.mItemCount > 0) {
            dispatchPress(mSelectedChild);
            postDelayed(new Runnable() {

                public void run() {
                    dispatchUnpress();
                }

                final Gallery this$0;

             {
                this$0 = Gallery.this;
                super();
            }
            }, ViewConfiguration.getPressedStateDuration());
            performItemClick(getChildAt(super.mSelectedPosition - super.mFirstPosition), super.mSelectedPosition, super.mAdapter.getItemId(super.mSelectedPosition));
        }
        mReceivedInvokeKeyDown = false;
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        super.onLayout(flag, i, j, k, l);
        super.mInLayout = true;
        layout(0, false);
        super.mInLayout = false;
    }

    public void onLongPress(MotionEvent motionevent) {
        if(mDownTouchPosition >= 0) {
            performHapticFeedback(0);
            long l = getItemIdAtPosition(mDownTouchPosition);
            dispatchLongPress(mDownTouchView, mDownTouchPosition, l);
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1) {
        super.mParent.requestDisallowInterceptTouchEvent(true);
        if(mShouldCallbackDuringFling) goto _L2; else goto _L1
_L1:
        if(mIsFirstScroll) {
            if(!mSuppressSelectionChanged)
                mSuppressSelectionChanged = true;
            postDelayed(mDisableSuppressSelectionChangedRunnable, 250L);
        }
_L4:
        trackMotionScroll(-1 * (int)f);
        mIsFirstScroll = false;
        return true;
_L2:
        if(mSuppressSelectionChanged)
            mSuppressSelectionChanged = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onShowPress(MotionEvent motionevent) {
    }

    public boolean onSingleTapUp(MotionEvent motionevent) {
        boolean flag;
        if(mDownTouchPosition >= 0) {
            scrollToChild(mDownTouchPosition - super.mFirstPosition);
            if(mShouldCallbackOnUnselectedItemClick || mDownTouchPosition == super.mSelectedPosition)
                performItemClick(mDownTouchView, mDownTouchPosition, super.mAdapter.getItemId(mDownTouchPosition));
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        int i;
        flag = mGestureDetector.onTouchEvent(motionevent);
        i = motionevent.getAction();
        if(i != 1) goto _L2; else goto _L1
_L1:
        onUp();
_L4:
        return flag;
_L2:
        if(i == 3)
            onCancel();
        if(true) goto _L4; else goto _L3
_L3:
    }

    void onUp() {
        if(mFlingRunnable.mScroller.isFinished())
            scrollIntoSlots();
        dispatchUnpress();
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean flag = false;
        if(!super.performAccessibilityAction(i, bundle)) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        switch(i) {
        case 4096: 
            if(isEnabled() && super.mItemCount > 0 && super.mSelectedPosition < -1 + super.mItemCount)
                flag = scrollToChild(1 + (super.mSelectedPosition - super.mFirstPosition));
            break;

        case 8192: 
            if(isEnabled() && super.mItemCount > 0 && super.mSelectedPosition > 0)
                flag = scrollToChild(-1 + (super.mSelectedPosition - super.mFirstPosition));
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    void selectionChanged() {
        if(!mSuppressSelectionChanged)
            super.selectionChanged();
    }

    public void setAnimationDuration(int i) {
        mAnimationDuration = i;
    }

    public void setCallbackDuringFling(boolean flag) {
        mShouldCallbackDuringFling = flag;
    }

    public void setCallbackOnUnselectedItemClick(boolean flag) {
        mShouldCallbackOnUnselectedItemClick = flag;
    }

    public void setGravity(int i) {
        if(mGravity != i) {
            mGravity = i;
            requestLayout();
        }
    }

    void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        updateSelectedItemMetadata();
    }

    public void setSpacing(int i) {
        mSpacing = i;
    }

    public void setUnselectedAlpha(float f) {
        mUnselectedAlpha = f;
    }

    public boolean showContextMenu() {
        boolean flag;
        if(isPressed() && super.mSelectedPosition >= 0)
            flag = dispatchLongPress(getChildAt(super.mSelectedPosition - super.mFirstPosition), super.mSelectedPosition, super.mSelectedRowId);
        else
            flag = false;
        return flag;
    }

    public boolean showContextMenuForChild(View view) {
        int i = getPositionForView(view);
        boolean flag;
        if(i < 0)
            flag = false;
        else
            flag = dispatchLongPress(view, i, super.mAdapter.getItemId(i));
        return flag;
    }

    void trackMotionScroll(int i) {
        if(getChildCount() != 0) {
            boolean flag;
            int j;
            if(i < 0)
                flag = true;
            else
                flag = false;
            j = getLimitedMotionScrollAmount(flag, i);
            if(j != i) {
                mFlingRunnable.endFling(false);
                onFinishedMovement();
            }
            offsetChildrenLeftAndRight(j);
            detachOffScreenChildren(flag);
            if(flag)
                fillToGalleryRight();
            else
                fillToGalleryLeft();
            super.mRecycler.clear();
            setSelectionToCenterChild();
            onScrollChanged(0, 0, 0, 0);
            invalidate();
        }
    }

    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    private static final String TAG = "Gallery";
    private static final boolean localLOGV;
    private int mAnimationDuration;
    private AdapterView.AdapterContextMenuInfo mContextMenuInfo;
    private Runnable mDisableSuppressSelectionChangedRunnable = new Runnable() {

        public void run() {
            mSuppressSelectionChanged = false;
            selectionChanged();
        }

        final Gallery this$0;

             {
                this$0 = Gallery.this;
                super();
            }
    };
    private int mDownTouchPosition;
    private View mDownTouchView;
    private FlingRunnable mFlingRunnable;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private boolean mIsFirstScroll;
    private boolean mIsRtl;
    private int mLeftMost;
    private boolean mReceivedInvokeKeyDown;
    private int mRightMost;
    private View mSelectedChild;
    private boolean mShouldCallbackDuringFling;
    private boolean mShouldCallbackOnUnselectedItemClick;
    private boolean mShouldStopFling;
    private int mSpacing;
    private boolean mSuppressSelectionChanged;
    private float mUnselectedAlpha;


/*
    static boolean access$002(Gallery gallery, boolean flag) {
        gallery.mSuppressSelectionChanged = flag;
        return flag;
    }

*/









/*
    static boolean access$602(Gallery gallery, boolean flag) {
        gallery.mShouldStopFling = flag;
        return flag;
    }

*/


/*
    static int access$702(Gallery gallery, int i) {
        gallery.mDownTouchPosition = i;
        return i;
    }

*/


}
