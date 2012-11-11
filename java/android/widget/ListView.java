// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.internal.util.Predicate;
import com.google.android.collect.Lists;
import java.util.ArrayList;

// Referenced classes of package android.widget:
//            AbsListView, ArrayAdapter, AdapterView, PopupWindow, 
//            ListAdapter, Checkable, HeaderViewListAdapter, Adapter

public class ListView extends AbsListView {
    private static class ArrowScrollFocusResult {

        public int getAmountToScroll() {
            return mAmountToScroll;
        }

        public int getSelectedPosition() {
            return mSelectedPosition;
        }

        void populate(int i, int j) {
            mSelectedPosition = i;
            mAmountToScroll = j;
        }

        private int mAmountToScroll;
        private int mSelectedPosition;

        private ArrowScrollFocusResult() {
        }

    }

    private class FocusSelector
        implements Runnable {

        public void run() {
            setSelectionFromTop(mPosition, mPositionTop);
        }

        public FocusSelector setup(int i, int j) {
            mPosition = i;
            mPositionTop = j;
            return this;
        }

        private int mPosition;
        private int mPositionTop;
        final ListView this$0;

        private FocusSelector() {
            this$0 = ListView.this;
            super();
        }

    }

    public class FixedViewInfo {

        public Object data;
        public boolean isSelectable;
        final ListView this$0;
        public View view;

        public FixedViewInfo() {
            this$0 = ListView.this;
            super();
        }
    }


    public ListView(Context context) {
        this(context, null);
    }

    public ListView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010074);
    }

    public ListView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mHeaderViewInfos = Lists.newArrayList();
        mFooterViewInfos = Lists.newArrayList();
        mAreAllItemsSelectable = true;
        mItemsCanFocus = false;
        mTempRect = new Rect();
        mArrowScrollFocusResult = new ArrowScrollFocusResult();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ListView, i, 0);
        CharSequence acharsequence[] = typedarray.getTextArray(0);
        if(acharsequence != null)
            setAdapter(new ArrayAdapter(context, 0x1090003, acharsequence));
        Drawable drawable = typedarray.getDrawable(1);
        if(drawable != null)
            setDivider(drawable);
        Drawable drawable1 = typedarray.getDrawable(5);
        if(drawable1 != null)
            setOverscrollHeader(drawable1);
        Drawable drawable2 = typedarray.getDrawable(6);
        if(drawable2 != null)
            setOverscrollFooter(drawable2);
        int j = typedarray.getDimensionPixelSize(2, 0);
        if(j != 0)
            setDividerHeight(j);
        mHeaderDividersEnabled = typedarray.getBoolean(3, true);
        mFooterDividersEnabled = typedarray.getBoolean(4, true);
        typedarray.recycle();
    }

    private View addViewAbove(View view, int i) {
        int j = i - 1;
        View view1 = obtainView(j, super.mIsScrap);
        setupChild(view1, j, view.getTop() - mDividerHeight, false, super.mListPadding.left, false, super.mIsScrap[0]);
        return view1;
    }

    private View addViewBelow(View view, int i) {
        int j = i + 1;
        View view1 = obtainView(j, super.mIsScrap);
        setupChild(view1, j, view.getBottom() + mDividerHeight, true, super.mListPadding.left, false, super.mIsScrap[0]);
        return view1;
    }

    private void adjustViewsUpOrDown() {
        int i = getChildCount();
        if(i <= 0) goto _L2; else goto _L1
_L1:
        if(super.mStackFromBottom) goto _L4; else goto _L3
_L3:
        int j;
        j = getChildAt(0).getTop() - super.mListPadding.top;
        if(super.mFirstPosition != 0)
            j -= mDividerHeight;
        if(j < 0)
            j = 0;
_L6:
        if(j != 0)
            offsetChildrenTopAndBottom(-j);
_L2:
        return;
_L4:
        j = getChildAt(i - 1).getBottom() - (getHeight() - super.mListPadding.bottom);
        if(i + super.mFirstPosition < super.mItemCount)
            j += mDividerHeight;
        if(j > 0)
            j = 0;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private int amountToScroll(int i, int j) {
        int k = getHeight() - super.mListPadding.bottom;
        int l = super.mListPadding.top;
        int i1 = getChildCount();
        int j2;
        if(i == 130) {
            int k2 = i1 - 1;
            if(j != -1)
                k2 = j - super.mFirstPosition;
            int l2 = k2 + super.mFirstPosition;
            View view1 = getChildAt(k2);
            int i3 = k;
            if(l2 < -1 + super.mItemCount)
                i3 -= getArrowScrollPreviewLength();
            if(view1.getBottom() <= i3)
                j2 = 0;
            else
            if(j != -1 && i3 - view1.getTop() >= getMaxScrollAmount()) {
                j2 = 0;
            } else {
                int j3 = view1.getBottom() - i3;
                if(i1 + super.mFirstPosition == super.mItemCount)
                    j3 = Math.min(j3, getChildAt(i1 - 1).getBottom() - k);
                j2 = Math.min(j3, getMaxScrollAmount());
            }
        } else {
            int j1 = 0;
            if(j != -1)
                j1 = j - super.mFirstPosition;
            int k1 = j1 + super.mFirstPosition;
            View view = getChildAt(j1);
            int l1 = l;
            if(k1 > 0)
                l1 += getArrowScrollPreviewLength();
            if(view.getTop() >= l1)
                j2 = 0;
            else
            if(j != -1 && view.getBottom() - l1 >= getMaxScrollAmount()) {
                j2 = 0;
            } else {
                int i2 = l1 - view.getTop();
                if(super.mFirstPosition == 0)
                    i2 = Math.min(i2, l - getChildAt(0).getTop());
                j2 = Math.min(i2, getMaxScrollAmount());
            }
        }
        return j2;
    }

    private int amountToScrollToNewFocus(int i, View view, int j) {
        int k;
        k = 0;
        view.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view, mTempRect);
        if(i != 33) goto _L2; else goto _L1
_L1:
        if(mTempRect.top < super.mListPadding.top) {
            k = super.mListPadding.top - mTempRect.top;
            if(j > 0)
                k += getArrowScrollPreviewLength();
        }
_L4:
        return k;
_L2:
        int l = getHeight() - super.mListPadding.bottom;
        if(mTempRect.bottom > l) {
            k = mTempRect.bottom - l;
            if(j < -1 + super.mItemCount)
                k += getArrowScrollPreviewLength();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private ArrowScrollFocusResult arrowScrollFocused(int i) {
        View view1;
        ArrowScrollFocusResult arrowscrollfocusresult;
        int j1;
        View view = getSelectedView();
        int i2;
        if(view != null && view.hasFocus()) {
            View view2 = view.findFocus();
            view1 = FocusFinder.getInstance().findNextFocus(this, view2, i);
        } else {
            if(i == 130) {
                boolean flag1;
                int j2;
                int k2;
                int l2;
                int i3;
                if(super.mFirstPosition > 0)
                    flag1 = true;
                else
                    flag1 = false;
                j2 = super.mListPadding.top;
                if(flag1)
                    k2 = getArrowScrollPreviewLength();
                else
                    k2 = 0;
                l2 = j2 + k2;
                if(view != null && view.getTop() > l2)
                    i3 = view.getTop();
                else
                    i3 = l2;
                mTempRect.set(0, i3, 0, i3);
            } else {
                boolean flag;
                int j;
                int k;
                int l;
                int i1;
                if(-1 + (super.mFirstPosition + getChildCount()) < super.mItemCount)
                    flag = true;
                else
                    flag = false;
                j = getHeight() - super.mListPadding.bottom;
                if(flag)
                    k = getArrowScrollPreviewLength();
                else
                    k = 0;
                l = j - k;
                if(view != null && view.getBottom() < l)
                    i1 = view.getBottom();
                else
                    i1 = l;
                mTempRect.set(0, i1, 0, i1);
            }
            view1 = FocusFinder.getInstance().findNextFocusFromRect(this, mTempRect, i);
        }
        if(view1 == null) goto _L2; else goto _L1
_L1:
        j1 = positionOfNewFocus(view1);
        if(super.mSelectedPosition == -1 || j1 == super.mSelectedPosition) goto _L4; else goto _L3
_L3:
        i2 = lookForSelectablePositionOnScreen(i);
        if(i2 == -1 || (i != 130 || i2 >= j1) && (i != 33 || i2 <= j1)) goto _L4; else goto _L5
_L5:
        arrowscrollfocusresult = null;
_L7:
        return arrowscrollfocusresult;
_L4:
        int k1 = amountToScrollToNewFocus(i, view1, j1);
        int l1 = getMaxScrollAmount();
        if(k1 < l1) {
            view1.requestFocus(i);
            mArrowScrollFocusResult.populate(j1, k1);
            arrowscrollfocusresult = mArrowScrollFocusResult;
            continue; /* Loop/switch isn't completed */
        }
        if(distanceToView(view1) < l1) {
            view1.requestFocus(i);
            mArrowScrollFocusResult.populate(j1, l1);
            arrowscrollfocusresult = mArrowScrollFocusResult;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        arrowscrollfocusresult = null;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private boolean arrowScrollImpl(int i) {
        boolean flag = false;
        if(getChildCount() > 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        View view = getSelectedView();
        int j = super.mSelectedPosition;
        int k = lookForSelectablePositionOnScreen(i);
        int l = amountToScroll(i, k);
        ArrowScrollFocusResult arrowscrollfocusresult;
        boolean flag1;
        if(mItemsCanFocus)
            arrowscrollfocusresult = arrowScrollFocused(i);
        else
            arrowscrollfocusresult = null;
        if(arrowscrollfocusresult != null) {
            k = arrowscrollfocusresult.getSelectedPosition();
            l = arrowscrollfocusresult.getAmountToScroll();
        }
        if(arrowscrollfocusresult != null)
            flag1 = true;
        else
            flag1 = false;
        if(k != -1) {
            View view1;
            boolean flag2;
            if(arrowscrollfocusresult != null)
                flag2 = true;
            else
                flag2 = false;
            handleNewSelectionChange(view, i, k, flag2);
            setSelectedPositionInt(k);
            setNextSelectedPositionInt(k);
            view = getSelectedView();
            j = k;
            if(mItemsCanFocus && arrowscrollfocusresult == null) {
                View view2 = getFocusedChild();
                if(view2 != null)
                    view2.clearFocus();
            }
            flag1 = true;
            checkSelectionChanged();
        }
        if(l > 0) {
            if(i != 33)
                l = -l;
            scrollListItemsBy(l);
            flag1 = true;
        }
        if(mItemsCanFocus && arrowscrollfocusresult == null && view != null && view.hasFocus()) {
            view1 = view.findFocus();
            if(!isViewAncestorOf(view1, this) || distanceToView(view1) > 0)
                view1.clearFocus();
        }
        if(k == -1 && view != null && !isViewAncestorOf(view, this)) {
            view = null;
            hideSelector();
            super.mResurrectToPosition = -1;
        }
        if(flag1) {
            if(view != null) {
                positionSelector(j, view);
                super.mSelectedTop = view.getTop();
            }
            if(!awakenScrollBars())
                invalidate();
            invokeOnItemScrollListener();
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void clearRecycledState(ArrayList arraylist) {
        if(arraylist != null) {
            int i = arraylist.size();
            for(int j = 0; j < i; j++) {
                AbsListView.LayoutParams layoutparams = (AbsListView.LayoutParams)((FixedViewInfo)arraylist.get(j)).view.getLayoutParams();
                if(layoutparams != null)
                    layoutparams.recycledHeaderFooter = false;
            }

        }
    }

    private boolean commonKey(int i, int j, KeyEvent keyevent) {
        boolean flag = true;
        if(super.mAdapter != null && super.mIsAttached) goto _L2; else goto _L1
_L1:
        flag = false;
_L15:
        return flag;
_L2:
        int k;
        int l;
        if(super.mDataChanged)
            layoutChildren();
        k = 0;
        l = keyevent.getAction();
        if(l == flag) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR lookupswitch 11: default 148
    //                   19: 198
    //                   20: 284
    //                   21: 372
    //                   22: 390
    //                   23: 408
    //                   62: 450
    //                   66: 408
    //                   92: 537
    //                   93: 610
    //                   122: 685
    //                   123: 721;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L9 _L11 _L12 _L13 _L14
_L4:
        if(k == 0 && !sendToTextFilter(i, j, keyevent)) {
            int i1;
            int j1;
            switch(l) {
            default:
                flag = false;
                break;

            case 0: // '\0'
                flag = super.onKeyDown(i, keyevent);
                break;

            case 1: // '\001'
                flag = super.onKeyUp(i, keyevent);
                break;

            case 2: // '\002'
                flag = super.onKeyMultiple(i, j, keyevent);
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        if(true) goto _L15; else goto _L5
_L5:
        if(!keyevent.hasNoModifiers())
            break MISSING_BLOCK_LABEL_247;
        k = resurrectSelectionIfNeeded();
        if(k != 0) goto _L4; else goto _L16
_L16:
        j1 = j;
_L18:
        j = j1 - 1;
        if(j1 <= 0 || !arrowScroll(33)) goto _L4; else goto _L17
_L17:
        k = 1;
        j1 = j;
          goto _L18
        if(keyevent.hasModifiers(2))
            if(resurrectSelectionIfNeeded() || fullScroll(33))
                k = ((flag) ? 1 : 0);
            else
                k = 0;
          goto _L4
_L6:
        if(!keyevent.hasNoModifiers())
            break MISSING_BLOCK_LABEL_334;
        k = resurrectSelectionIfNeeded();
        if(k != 0) goto _L4; else goto _L19
_L19:
        i1 = j;
_L21:
        j = i1 - 1;
        if(i1 <= 0 || !arrowScroll(130)) goto _L4; else goto _L20
_L20:
        k = 1;
        i1 = j;
          goto _L21
        if(keyevent.hasModifiers(2))
            if(resurrectSelectionIfNeeded() || fullScroll(130))
                k = ((flag) ? 1 : 0);
            else
                k = 0;
          goto _L4
_L7:
        if(keyevent.hasNoModifiers())
            k = handleHorizontalFocusWithinListItem(17);
          goto _L4
_L8:
        if(keyevent.hasNoModifiers())
            k = handleHorizontalFocusWithinListItem(66);
          goto _L4
_L9:
        if(keyevent.hasNoModifiers()) {
            k = resurrectSelectionIfNeeded();
            if(k == 0 && keyevent.getRepeatCount() == 0 && getChildCount() > 0) {
                keyPressed();
                k = 1;
            }
        }
          goto _L4
_L10:
        if(super.mPopup == null || !super.mPopup.isShowing()) {
            if(keyevent.hasNoModifiers()) {
                if(resurrectSelectionIfNeeded() || pageScroll(130)) {
                    flag;
                }
            } else
            if(keyevent.hasModifiers(flag) && (resurrectSelectionIfNeeded() || pageScroll(33))) {
                flag;
            }
            k = 1;
        }
          goto _L4
_L11:
        if(keyevent.hasNoModifiers()) {
            if(resurrectSelectionIfNeeded() || pageScroll(33))
                k = ((flag) ? 1 : 0);
            else
                k = 0;
        } else
        if(keyevent.hasModifiers(2))
            if(resurrectSelectionIfNeeded() || fullScroll(33))
                k = ((flag) ? 1 : 0);
            else
                k = 0;
          goto _L4
_L12:
        if(keyevent.hasNoModifiers()) {
            if(resurrectSelectionIfNeeded() || pageScroll(130))
                k = ((flag) ? 1 : 0);
            else
                k = 0;
        } else
        if(keyevent.hasModifiers(2))
            if(resurrectSelectionIfNeeded() || fullScroll(130))
                k = ((flag) ? 1 : 0);
            else
                k = 0;
          goto _L4
_L13:
        if(keyevent.hasNoModifiers())
            if(resurrectSelectionIfNeeded() || fullScroll(33))
                k = ((flag) ? 1 : 0);
            else
                k = 0;
          goto _L4
_L14:
        if(keyevent.hasNoModifiers())
            if(resurrectSelectionIfNeeded() || fullScroll(130))
                k = ((flag) ? 1 : 0);
            else
                k = 0;
          goto _L4
        if(true) goto _L23; else goto _L22
_L22:
        break MISSING_BLOCK_LABEL_788;
_L23:
        break; /* Loop/switch isn't completed */
    }

    private void correctTooHigh(int i) {
        if(-1 + (i + super.mFirstPosition) == -1 + super.mItemCount && i > 0) {
            int j = getChildAt(i - 1).getBottom();
            int k = super.mBottom - super.mTop - super.mListPadding.bottom - j;
            View view = getChildAt(0);
            int l = view.getTop();
            if(k > 0 && (super.mFirstPosition > 0 || l < super.mListPadding.top)) {
                if(super.mFirstPosition == 0)
                    k = Math.min(k, super.mListPadding.top - l);
                offsetChildrenTopAndBottom(k);
                if(super.mFirstPosition > 0) {
                    fillUp(-1 + super.mFirstPosition, view.getTop() - mDividerHeight);
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private void correctTooLow(int i) {
        if(super.mFirstPosition != 0 || i <= 0) goto _L2; else goto _L1
_L1:
        int l;
        int i1;
        View view;
        int j1;
        int k1;
        int j = getChildAt(0).getTop();
        int k = super.mListPadding.top;
        l = super.mBottom - super.mTop - super.mListPadding.bottom;
        i1 = j - k;
        view = getChildAt(i - 1);
        j1 = view.getBottom();
        k1 = -1 + (i + super.mFirstPosition);
        if(i1 <= 0) goto _L2; else goto _L3
_L3:
        if(k1 >= -1 + super.mItemCount && j1 <= l) goto _L5; else goto _L4
_L4:
        if(k1 == -1 + super.mItemCount)
            i1 = Math.min(i1, j1 - l);
        offsetChildrenTopAndBottom(-i1);
        if(k1 < -1 + super.mItemCount) {
            fillDown(k1 + 1, view.getBottom() + mDividerHeight);
            adjustViewsUpOrDown();
        }
_L2:
        return;
_L5:
        if(k1 == -1 + super.mItemCount)
            adjustViewsUpOrDown();
        if(true) goto _L2; else goto _L6
_L6:
    }

    private int distanceToView(View view) {
        int i;
        int j;
        i = 0;
        view.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view, mTempRect);
        j = super.mBottom - super.mTop - super.mListPadding.bottom;
        if(mTempRect.bottom >= super.mListPadding.top) goto _L2; else goto _L1
_L1:
        i = super.mListPadding.top - mTempRect.bottom;
_L4:
        return i;
_L2:
        if(mTempRect.top > j)
            i = mTempRect.top - j;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void fillAboveAndBelow(View view, int i) {
        int j = mDividerHeight;
        if(!super.mStackFromBottom) {
            fillUp(i - 1, view.getTop() - j);
            adjustViewsUpOrDown();
            fillDown(i + 1, j + view.getBottom());
        } else {
            fillDown(i + 1, j + view.getBottom());
            adjustViewsUpOrDown();
            fillUp(i - 1, view.getTop() - j);
        }
    }

    private View fillDown(int i, int j) {
        View view = null;
        int k = super.mBottom - super.mTop;
        if((0x22 & super.mGroupFlags) == 34)
            k -= super.mListPadding.bottom;
        while(j < k && i < super.mItemCount)  {
            boolean flag;
            int l;
            View view1;
            if(i == super.mSelectedPosition)
                flag = true;
            else
                flag = false;
            l = super.mListPadding.left;
            view1 = makeAndAddView(i, j, true, l, flag);
            j = view1.getBottom() + mDividerHeight;
            if(flag)
                view = view1;
            i++;
        }
        setVisibleRangeHint(super.mFirstPosition, -1 + (super.mFirstPosition + getChildCount()));
        return view;
    }

    private View fillFromMiddle(int i, int j) {
        int k = j - i;
        int l = reconcileSelectedPosition();
        View view = makeAndAddView(l, i, true, super.mListPadding.left, true);
        super.mFirstPosition = l;
        int i1 = view.getMeasuredHeight();
        if(i1 <= k)
            view.offsetTopAndBottom((k - i1) / 2);
        fillAboveAndBelow(view, l);
        if(!super.mStackFromBottom)
            correctTooHigh(getChildCount());
        else
            correctTooLow(getChildCount());
        return view;
    }

    private View fillFromSelection(int i, int j, int k) {
        int l = getVerticalFadingEdgeLength();
        int i1 = super.mSelectedPosition;
        int j1 = getTopSelectionPixel(j, l, i1);
        int k1 = getBottomSelectionPixel(k, l, i1);
        View view = makeAndAddView(i1, i, true, super.mListPadding.left, true);
        if(view.getBottom() > k1)
            view.offsetTopAndBottom(-Math.min(view.getTop() - j1, view.getBottom() - k1));
        else
        if(view.getTop() < j1)
            view.offsetTopAndBottom(Math.min(j1 - view.getTop(), k1 - view.getBottom()));
        fillAboveAndBelow(view, i1);
        if(!super.mStackFromBottom)
            correctTooHigh(getChildCount());
        else
            correctTooLow(getChildCount());
        return view;
    }

    private View fillFromTop(int i) {
        super.mFirstPosition = Math.min(super.mFirstPosition, super.mSelectedPosition);
        super.mFirstPosition = Math.min(super.mFirstPosition, -1 + super.mItemCount);
        if(super.mFirstPosition < 0)
            super.mFirstPosition = 0;
        return fillDown(super.mFirstPosition, i);
    }

    private View fillSpecific(int i, int j) {
        boolean flag;
        View view;
        int k;
        View view1;
        View view2;
        if(i == super.mSelectedPosition)
            flag = true;
        else
            flag = false;
        view = makeAndAddView(i, j, true, super.mListPadding.left, flag);
        super.mFirstPosition = i;
        k = mDividerHeight;
        if(!super.mStackFromBottom) {
            view2 = fillUp(i - 1, view.getTop() - k);
            adjustViewsUpOrDown();
            view1 = fillDown(i + 1, k + view.getBottom());
            int i1 = getChildCount();
            if(i1 > 0)
                correctTooHigh(i1);
        } else {
            view1 = fillDown(i + 1, k + view.getBottom());
            adjustViewsUpOrDown();
            view2 = fillUp(i - 1, view.getTop() - k);
            int l = getChildCount();
            if(l > 0)
                correctTooLow(l);
        }
        if(!flag)
            if(view2 != null)
                view = view2;
            else
                view = view1;
        return view;
    }

    private View fillUp(int i, int j) {
        View view = null;
        int k = 0;
        if((0x22 & super.mGroupFlags) == 34)
            k = super.mListPadding.top;
        while(j > k && i >= 0)  {
            boolean flag;
            int l;
            View view1;
            if(i == super.mSelectedPosition)
                flag = true;
            else
                flag = false;
            l = super.mListPadding.left;
            view1 = makeAndAddView(i, j, false, l, flag);
            j = view1.getTop() - mDividerHeight;
            if(flag)
                view = view1;
            i--;
        }
        super.mFirstPosition = i + 1;
        setVisibleRangeHint(super.mFirstPosition, -1 + (super.mFirstPosition + getChildCount()));
        return view;
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getVerticalFadingEdgeLength());
    }

    private int getBottomSelectionPixel(int i, int j, int k) {
        int l = i;
        if(k != -1 + super.mItemCount)
            l -= j;
        return l;
    }

    private int getTopSelectionPixel(int i, int j, int k) {
        int l = i;
        if(k > 0)
            l += j;
        return l;
    }

    private boolean handleHorizontalFocusWithinListItem(int i) {
        int j;
        if(i != 17 && i != 66)
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
        j = getChildCount();
        if(!mItemsCanFocus || j <= 0 || super.mSelectedPosition == -1) goto _L2; else goto _L1
_L1:
        View view = getSelectedView();
        if(view == null || !view.hasFocus() || !(view instanceof ViewGroup)) goto _L2; else goto _L3
_L3:
        View view1;
        View view2;
        view1 = view.findFocus();
        view2 = FocusFinder.getInstance().findNextFocus((ViewGroup)view, view1, i);
        if(view2 == null) goto _L5; else goto _L4
_L4:
        view1.getFocusedRect(mTempRect);
        offsetDescendantRectToMyCoords(view1, mTempRect);
        offsetRectIntoDescendantCoords(view2, mTempRect);
        if(!view2.requestFocus(i, mTempRect)) goto _L5; else goto _L6
_L6:
        boolean flag = true;
_L8:
        return flag;
_L5:
        View view3 = FocusFinder.getInstance().findNextFocus((ViewGroup)getRootView(), view1, i);
        if(view3 != null) {
            flag = isViewAncestorOf(view3, this);
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = false;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private void handleNewSelectionChange(View view, int i, int j, boolean flag) {
        if(j == -1)
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        boolean flag1 = false;
        int k = super.mSelectedPosition - super.mFirstPosition;
        int l = j - super.mFirstPosition;
        int i1;
        int j1;
        View view1;
        View view2;
        int k1;
        if(i == 33) {
            i1 = l;
            j1 = k;
            view1 = getChildAt(i1);
            view2 = view;
            flag1 = true;
        } else {
            i1 = k;
            j1 = l;
            view1 = view;
            view2 = getChildAt(j1);
        }
        k1 = getChildCount();
        if(view1 != null) {
            boolean flag3;
            if(!flag && flag1)
                flag3 = true;
            else
                flag3 = false;
            view1.setSelected(flag3);
            measureAndAdjustDown(view1, i1, k1);
        }
        if(view2 != null) {
            boolean flag2;
            if(!flag && !flag1)
                flag2 = true;
            else
                flag2 = false;
            view2.setSelected(flag2);
            measureAndAdjustDown(view2, j1, k1);
        }
    }

    private boolean isDirectChildHeaderOrFooter(View view) {
        ArrayList arraylist;
        int i;
        int j;
        arraylist = mHeaderViewInfos;
        i = arraylist.size();
        j = 0;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        if(view != ((FixedViewInfo)arraylist.get(j)).view) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        return flag;
_L4:
        j++;
          goto _L5
_L2:
        ArrayList arraylist1;
        int k;
        int l;
        arraylist1 = mFooterViewInfos;
        k = arraylist1.size();
        l = 0;
_L7:
label0:
        {
            if(l >= k)
                break MISSING_BLOCK_LABEL_99;
            if(view != ((FixedViewInfo)arraylist1.get(l)).view)
                break label0;
            flag = true;
        }
          goto _L6
        l++;
          goto _L7
        flag = false;
          goto _L6
    }

    private boolean isViewAncestorOf(View view, View view1) {
        boolean flag = true;
        if(view != view1) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        android.view.ViewParent viewparent = view.getParent();
        if(!(viewparent instanceof ViewGroup) || !isViewAncestorOf((View)viewparent, view1))
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private int lookForSelectablePositionOnScreen(int i) {
        int j = super.mFirstPosition;
        if(i != 130) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        if(super.mSelectedPosition != -1)
            j1 = 1 + super.mSelectedPosition;
        else
            j1 = j;
        if(j1 < super.mAdapter.getCount()) goto _L4; else goto _L3
_L3:
        i1 = -1;
_L7:
        return i1;
_L4:
        if(j1 < j)
            j1 = j;
        int k1 = getLastVisiblePosition();
        ListAdapter listadapter1 = getAdapter();
        for(i1 = j1; i1 <= k1; i1++)
            if(listadapter1.isEnabled(i1) && getChildAt(i1 - j).getVisibility() == 0)
                continue; /* Loop/switch isn't completed */

          goto _L5
_L2:
        int k = -1 + (j + getChildCount());
        int l;
        if(super.mSelectedPosition != -1)
            l = -1 + super.mSelectedPosition;
        else
            l = -1 + (j + getChildCount());
        if(l < 0 || l >= super.mAdapter.getCount()) {
            i1 = -1;
            continue; /* Loop/switch isn't completed */
        }
        if(l > k)
            l = k;
        ListAdapter listadapter = getAdapter();
        for(i1 = l; i1 >= j; i1--)
            if(listadapter.isEnabled(i1) && getChildAt(i1 - j).getVisibility() == 0)
                continue; /* Loop/switch isn't completed */

_L5:
        i1 = -1;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private View makeAndAddView(int i, int j, boolean flag, int k, boolean flag1) {
        if(super.mDataChanged) goto _L2; else goto _L1
_L1:
        View view2 = super.mRecycler.getActiveView(i);
        if(view2 == null) goto _L2; else goto _L3
_L3:
        View view1;
        setupChild(view2, i, j, flag, k, flag1, true);
        view1 = view2;
_L5:
        return view1;
_L2:
        View view = obtainView(i, super.mIsScrap);
        setupChild(view, i, j, flag, k, flag1, super.mIsScrap[0]);
        view1 = view;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void measureAndAdjustDown(View view, int i, int j) {
        int k = view.getHeight();
        measureItem(view);
        if(view.getMeasuredHeight() != k) {
            relayoutMeasuredItem(view);
            int l = view.getMeasuredHeight() - k;
            for(int i1 = i + 1; i1 < j; i1++)
                getChildAt(i1).offsetTopAndBottom(l);

        }
    }

    private void measureItem(View view) {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if(layoutparams == null)
            layoutparams = new android.view.ViewGroup.LayoutParams(-1, -2);
        int i = ViewGroup.getChildMeasureSpec(super.mWidthMeasureSpec, super.mListPadding.left + super.mListPadding.right, layoutparams.width);
        int j = layoutparams.height;
        int k;
        if(j > 0)
            k = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
        else
            k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(i, k);
    }

    private void measureScrapChild(View view, int i, int j) {
        AbsListView.LayoutParams layoutparams = (AbsListView.LayoutParams)view.getLayoutParams();
        if(layoutparams == null) {
            layoutparams = (AbsListView.LayoutParams)generateDefaultLayoutParams();
            view.setLayoutParams(layoutparams);
        }
        layoutparams.viewType = super.mAdapter.getItemViewType(i);
        layoutparams.forceAdd = true;
        int k = ViewGroup.getChildMeasureSpec(j, super.mListPadding.left + super.mListPadding.right, ((android.view.ViewGroup.LayoutParams) (layoutparams)).width);
        int l = ((android.view.ViewGroup.LayoutParams) (layoutparams)).height;
        int i1;
        if(l > 0)
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(l, 0x40000000);
        else
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(k, i1);
    }

    private View moveSelection(View view, View view1, int i, int j, int k) {
        int l = getVerticalFadingEdgeLength();
        int i1 = super.mSelectedPosition;
        int j1 = getTopSelectionPixel(j, l, i1);
        int k1 = getBottomSelectionPixel(j, l, i1);
        View view2;
        if(i > 0) {
            View view3 = makeAndAddView(i1 - 1, view.getTop(), true, super.mListPadding.left, false);
            int l2 = mDividerHeight;
            view2 = makeAndAddView(i1, l2 + view3.getBottom(), true, super.mListPadding.left, true);
            if(view2.getBottom() > k1) {
                int i3 = view2.getTop() - j1;
                int j3 = view2.getBottom() - k1;
                int k3 = (k - j) / 2;
                int l3 = Math.min(Math.min(i3, j3), k3);
                view3.offsetTopAndBottom(-l3);
                view2.offsetTopAndBottom(-l3);
            }
            if(!super.mStackFromBottom) {
                fillUp(-2 + super.mSelectedPosition, view2.getTop() - l2);
                adjustViewsUpOrDown();
                fillDown(1 + super.mSelectedPosition, l2 + view2.getBottom());
            } else {
                fillDown(1 + super.mSelectedPosition, l2 + view2.getBottom());
                adjustViewsUpOrDown();
                fillUp(-2 + super.mSelectedPosition, view2.getTop() - l2);
            }
        } else
        if(i < 0) {
            if(view1 != null)
                view2 = makeAndAddView(i1, view1.getTop(), true, super.mListPadding.left, true);
            else
                view2 = makeAndAddView(i1, view.getTop(), false, super.mListPadding.left, true);
            if(view2.getTop() < j1) {
                int i2 = j1 - view2.getTop();
                int j2 = k1 - view2.getBottom();
                int k2 = (k - j) / 2;
                view2.offsetTopAndBottom(Math.min(Math.min(i2, j2), k2));
            }
            fillAboveAndBelow(view2, i1);
        } else {
            int l1 = view.getTop();
            view2 = makeAndAddView(i1, l1, true, super.mListPadding.left, true);
            if(l1 < j && view2.getBottom() < j + 20)
                view2.offsetTopAndBottom(j - view2.getTop());
            fillAboveAndBelow(view2, i1);
        }
        return view2;
    }

    private int positionOfNewFocus(View view) {
        int i = getChildCount();
        for(int j = 0; j < i; j++)
            if(isViewAncestorOf(view, getChildAt(j)))
                return j + super.mFirstPosition;

        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private void relayoutMeasuredItem(View view) {
        int i = view.getMeasuredWidth();
        int j = view.getMeasuredHeight();
        int k = super.mListPadding.left;
        int l = k + i;
        int i1 = view.getTop();
        view.layout(k, i1, l, i1 + j);
    }

    private void removeFixedViewInfo(View view, ArrayList arraylist) {
        int i = arraylist.size();
        int j = 0;
        do {
label0:
            {
                if(j < i) {
                    if(((FixedViewInfo)arraylist.get(j)).view != view)
                        break label0;
                    arraylist.remove(j);
                }
                return;
            }
            j++;
        } while(true);
    }

    private void scrollListItemsBy(int i) {
        offsetChildrenTopAndBottom(i);
        int j = getHeight() - super.mListPadding.bottom;
        int k = super.mListPadding.top;
        AbsListView.RecycleBin recyclebin = super.mRecycler;
        if(i < 0) {
            int i1 = getChildCount();
            View view2 = getChildAt(i1 - 1);
            do {
                if(view2.getBottom() >= j)
                    break;
                int j1 = -1 + (i1 + super.mFirstPosition);
                if(j1 >= -1 + super.mItemCount)
                    break;
                view2 = addViewBelow(view2, j1);
                i1++;
            } while(true);
            if(view2.getBottom() < j)
                offsetChildrenTopAndBottom(j - view2.getBottom());
            View view3 = getChildAt(0);
            while(view3.getBottom() < k)  {
                if(recyclebin.shouldRecycleViewType(((AbsListView.LayoutParams)view3.getLayoutParams()).viewType)) {
                    detachViewFromParent(view3);
                    recyclebin.addScrapView(view3, super.mFirstPosition);
                } else {
                    removeViewInLayout(view3);
                }
                view3 = getChildAt(0);
                super.mFirstPosition = 1 + super.mFirstPosition;
            }
        } else {
            View view;
            for(view = getChildAt(0); view.getTop() > k && super.mFirstPosition > 0; super.mFirstPosition = -1 + super.mFirstPosition)
                view = addViewAbove(view, super.mFirstPosition);

            if(view.getTop() > k)
                offsetChildrenTopAndBottom(k - view.getTop());
            int l = -1 + getChildCount();
            View view1 = getChildAt(l);
            while(view1.getTop() > j)  {
                if(recyclebin.shouldRecycleViewType(((AbsListView.LayoutParams)view1.getLayoutParams()).viewType)) {
                    detachViewFromParent(view1);
                    recyclebin.addScrapView(view1, l + super.mFirstPosition);
                } else {
                    removeViewInLayout(view1);
                }
                l--;
                view1 = getChildAt(l);
            }
        }
    }

    private void setupChild(View view, int i, int j, boolean flag, int k, boolean flag1, boolean flag2) {
        boolean flag3;
        boolean flag4;
        int l;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        AbsListView.LayoutParams layoutparams;
        int j1;
        int k1;
        if(flag1 && shouldShowSelector())
            flag3 = true;
        else
            flag3 = false;
        if(flag3 != view.isSelected())
            flag4 = true;
        else
            flag4 = false;
        l = super.mTouchMode;
        if(l > 0 && l < 3 && super.mMotionPosition == i)
            flag5 = true;
        else
            flag5 = false;
        if(flag5 != view.isPressed())
            flag6 = true;
        else
            flag6 = false;
        if(!flag2 || flag4 || view.isLayoutRequested())
            flag7 = true;
        else
            flag7 = false;
        layoutparams = (AbsListView.LayoutParams)view.getLayoutParams();
        if(layoutparams == null)
            layoutparams = (AbsListView.LayoutParams)generateDefaultLayoutParams();
        layoutparams.viewType = super.mAdapter.getItemViewType(i);
        if(flag2 && !layoutparams.forceAdd || layoutparams.recycledHeaderFooter && layoutparams.viewType == -2) {
            int i1;
            int l1;
            int i2;
            byte byte1;
            if(flag)
                byte1 = -1;
            else
                byte1 = 0;
            attachViewToParent(view, byte1, layoutparams);
        } else {
            layoutparams.forceAdd = false;
            if(layoutparams.viewType == -2)
                layoutparams.recycledHeaderFooter = true;
            byte byte0;
            if(flag)
                byte0 = -1;
            else
                byte0 = 0;
            addViewInLayout(view, byte0, layoutparams, true);
        }
        if(flag4)
            view.setSelected(flag3);
        if(flag6)
            view.setPressed(flag5);
        if(super.mChoiceMode != 0 && super.mCheckStates != null)
            if(view instanceof Checkable)
                ((Checkable)view).setChecked(super.mCheckStates.get(i));
            else
            if(getContext().getApplicationInfo().targetSdkVersion >= 11)
                view.setActivated(super.mCheckStates.get(i));
        if(flag7) {
            l1 = ViewGroup.getChildMeasureSpec(super.mWidthMeasureSpec, super.mListPadding.left + super.mListPadding.right, ((android.view.ViewGroup.LayoutParams) (layoutparams)).width);
            i2 = ((android.view.ViewGroup.LayoutParams) (layoutparams)).height;
            int j2;
            if(i2 > 0)
                j2 = android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x40000000);
            else
                j2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            view.measure(l1, j2);
        } else {
            cleanupLayoutState(view);
        }
        i1 = view.getMeasuredWidth();
        j1 = view.getMeasuredHeight();
        if(flag)
            k1 = j;
        else
            k1 = j - j1;
        if(flag7) {
            view.layout(k, k1, k + i1, k1 + j1);
        } else {
            view.offsetLeftAndRight(k - view.getLeft());
            view.offsetTopAndBottom(k1 - view.getTop());
        }
        if(super.mCachingStarted && !view.isDrawingCacheEnabled())
            view.setDrawingCacheEnabled(true);
        if(flag2 && ((AbsListView.LayoutParams)view.getLayoutParams()).scrappedFromPosition != i)
            view.jumpDrawablesToCurrentState();
    }

    private boolean showingBottomFadingEdge() {
        int i = getChildCount();
        int j = getChildAt(i - 1).getBottom();
        int k = -1 + (i + super.mFirstPosition);
        int l = (super.mScrollY + getHeight()) - super.mListPadding.bottom;
        boolean flag;
        if(k < -1 + super.mItemCount || j < l)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean showingTopFadingEdge() {
        boolean flag = false;
        int i = super.mScrollY + super.mListPadding.top;
        if(super.mFirstPosition > 0 || getChildAt(0).getTop() > i)
            flag = true;
        return flag;
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true);
    }

    public void addFooterView(View view, Object obj, boolean flag) {
        FixedViewInfo fixedviewinfo = new FixedViewInfo();
        fixedviewinfo.view = view;
        fixedviewinfo.data = obj;
        fixedviewinfo.isSelectable = flag;
        mFooterViewInfos.add(fixedviewinfo);
        if(super.mAdapter != null && super.mDataSetObserver != null)
            super.mDataSetObserver.onChanged();
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    public void addHeaderView(View view, Object obj, boolean flag) {
        if(super.mAdapter != null && !(super.mAdapter instanceof HeaderViewListAdapter))
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        FixedViewInfo fixedviewinfo = new FixedViewInfo();
        fixedviewinfo.view = view;
        fixedviewinfo.data = obj;
        fixedviewinfo.isSelectable = flag;
        mHeaderViewInfos.add(fixedviewinfo);
        if(super.mAdapter != null && super.mDataSetObserver != null)
            super.mDataSetObserver.onChanged();
    }

    boolean arrowScroll(int i) {
        boolean flag;
        super.mInLayout = true;
        flag = arrowScrollImpl(i);
        if(flag)
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        super.mInLayout = false;
        return flag;
        Exception exception;
        exception;
        super.mInLayout = false;
        throw exception;
    }

    protected boolean canAnimate() {
        boolean flag;
        if(super.canAnimate() && super.mItemCount > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void dispatchDraw(Canvas canvas) {
        int i;
        Drawable drawable;
        Drawable drawable1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        Rect rect;
        int j;
        int k;
        int l;
        int i1;
        boolean flag3;
        boolean flag4;
        int j1;
        boolean flag5;
        ListAdapter listadapter;
        boolean flag6;
        Paint paint;
        int k1;
        int i2;
        int k3;
        if(super.mCachingStarted)
            super.mCachingActive = true;
        i = mDividerHeight;
        drawable = mOverScrollHeader;
        drawable1 = mOverScrollFooter;
        int l1;
        int l3;
        int i4;
        int k4;
        int l4;
        if(drawable != null)
            flag = true;
        else
            flag = false;
        if(drawable1 != null)
            flag1 = true;
        else
            flag1 = false;
        if(i > 0 && mDivider != null)
            flag2 = true;
        else
            flag2 = false;
        if(!flag2 && !flag && !flag1) goto _L2; else goto _L1
_L1:
        rect = mTempRect;
        rect.left = super.mPaddingLeft;
        rect.right = super.mRight - super.mLeft - super.mPaddingRight;
        j = getChildCount();
        k = mHeaderViewInfos.size();
        l = super.mItemCount;
        i1 = -1 + (l - mFooterViewInfos.size());
        flag3 = mHeaderDividersEnabled;
        flag4 = mFooterDividersEnabled;
        j1 = super.mFirstPosition;
        flag5 = mAreAllItemsSelectable;
        listadapter = super.mAdapter;
        if(isOpaque() && !super.isOpaque())
            flag6 = true;
        else
            flag6 = false;
        if(flag6 && mDividerPaint == null && mIsCacheColorOpaque) {
            mDividerPaint = new Paint();
            mDividerPaint.setColor(getCacheColorHint());
        }
        paint = mDividerPaint;
        k1 = 0;
        l1 = 0;
        if((0x22 & super.mGroupFlags) == 34) {
            k1 = super.mListPadding.top;
            l1 = super.mListPadding.bottom;
        }
        i2 = (super.mBottom - super.mTop - l1) + super.mScrollY;
        if(super.mStackFromBottom) goto _L4; else goto _L3
_L3:
        k3 = 0;
        l3 = super.mScrollY;
        if(j <= 0 || l3 >= 0) goto _L6; else goto _L5
_L5:
        if(!flag) goto _L8; else goto _L7
_L7:
        rect.bottom = 0;
        rect.top = l3;
        drawOverscrollHeader(canvas, drawable, rect);
_L6:
        i4 = 0;
_L19:
        if(i4 >= j)
            break; /* Loop/switch isn't completed */
        if(!flag3 && j1 + i4 < k || !flag4 && j1 + i4 >= i1) goto _L10; else goto _L9
_L9:
        k3 = getChildAt(i4).getBottom();
        if(!flag2 || k3 >= i2) goto _L10; else goto _L11
_L11:
        if(!flag1) goto _L13; else goto _L12
_L12:
        l4 = j - 1;
        if(i4 == l4) goto _L10; else goto _L13
_L13:
        if(flag5) goto _L15; else goto _L14
_L14:
        if(!listadapter.isEnabled(j1 + i4)) goto _L17; else goto _L16
_L16:
        k4 = j - 1;
        if(i4 != k4 && !listadapter.isEnabled(1 + (j1 + i4))) goto _L17; else goto _L15
_L15:
        rect.top = k3;
        rect.bottom = k3 + i;
        drawDivider(canvas, rect, i4);
_L10:
        i4++;
        if(true) goto _L19; else goto _L18
_L8:
        if(flag2) {
            rect.bottom = 0;
            rect.top = -i;
            drawDivider(canvas, rect, -1);
        }
        continue; /* Loop/switch isn't completed */
_L17:
        if(flag6) {
            rect.top = k3;
            rect.bottom = k3 + i;
            canvas.drawRect(rect, paint);
        }
          goto _L10
_L18:
        int j4 = super.mBottom + super.mScrollY;
        if(flag1 && j1 + j == l && j4 > k3) {
            rect.top = k3;
            rect.bottom = j4;
            drawOverscrollFooter(canvas, drawable1, rect);
        }
_L2:
        super.dispatchDraw(canvas);
        return;
_L4:
        int j2;
        int i3;
        j2 = super.mScrollY;
        if(j > 0 && flag) {
            rect.top = j2;
            rect.bottom = getChildAt(0).getTop();
            drawOverscrollHeader(canvas, drawable, rect);
        }
        boolean flag7;
        int k2;
        int j3;
        if(flag)
            flag7 = true;
        else
            flag7 = false;
        k2 = ((flag7) ? 1 : 0);
_L25:
        if(k2 >= j)
            break MISSING_BLOCK_LABEL_885;
        if((flag3 || j1 + k2 >= k) && (flag4 || j1 + k2 < i1)) {
            i3 = getChildAt(k2).getTop();
            if(i3 > k1) {
                if(!flag5) {
                    if(!listadapter.isEnabled(j1 + k2))
                        break; /* Loop/switch isn't completed */
                    j3 = j - 1;
                    if(k2 != j3 && !listadapter.isEnabled(1 + (j1 + k2)))
                        break; /* Loop/switch isn't completed */
                }
                rect.top = i3 - i;
                rect.bottom = i3;
                drawDivider(canvas, rect, k2 - 1);
            }
        }
_L23:
        k2++;
        if(true) goto _L21; else goto _L20
_L21:
        break MISSING_BLOCK_LABEL_709;
_L20:
        if(flag6) {
            rect.top = i3 - i;
            rect.bottom = i3;
            canvas.drawRect(rect, paint);
        }
        if(true) goto _L23; else goto _L22
_L22:
        if(true) goto _L25; else goto _L24
_L24:
        if(j > 0 && j2 > 0)
            if(flag1) {
                int l2 = super.mBottom;
                rect.top = l2;
                rect.bottom = l2 + j2;
                drawOverscrollFooter(canvas, drawable1, rect);
            } else
            if(flag2) {
                rect.top = i2;
                rect.bottom = i2 + i;
                drawDivider(canvas, rect, -1);
            }
        if(true) goto _L2; else goto _L26
_L26:
        if(true) goto _L6; else goto _L27
_L27:
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        boolean flag = super.dispatchKeyEvent(keyevent);
        if(!flag && getFocusedChild() != null && keyevent.getAction() == 0)
            flag = onKeyDown(keyevent.getKeyCode(), keyevent);
        return flag;
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        boolean flag = super.drawChild(canvas, view, l);
        if(super.mCachingActive && view.mCachingFailed)
            super.mCachingActive = false;
        return flag;
    }

    void drawDivider(Canvas canvas, Rect rect, int i) {
        Drawable drawable = mDivider;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
        int i = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        if(rect.bottom - rect.top < i)
            rect.bottom = i + rect.top;
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
        int i = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        if(rect.bottom - rect.top < i)
            rect.top = rect.bottom - i;
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    void fillGap(boolean flag) {
        int i = getChildCount();
        if(flag) {
            int l = 0;
            if((0x22 & super.mGroupFlags) == 34)
                l = getListPaddingTop();
            int i1;
            if(i > 0)
                i1 = getChildAt(i - 1).getBottom() + mDividerHeight;
            else
                i1 = l;
            fillDown(i + super.mFirstPosition, i1);
            correctTooHigh(getChildCount());
        } else {
            int j = 0;
            if((0x22 & super.mGroupFlags) == 34)
                j = getListPaddingBottom();
            int k;
            if(i > 0)
                k = getChildAt(0).getTop() - mDividerHeight;
            else
                k = getHeight() - j;
            fillUp(-1 + super.mFirstPosition, k);
            correctTooLow(getChildCount());
        }
    }

    int findMotionRow(int i) {
        int j;
        j = getChildCount();
        if(j <= 0)
            break MISSING_BLOCK_LABEL_94;
        if(super.mStackFromBottom) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L5:
        if(i1 >= j)
            break MISSING_BLOCK_LABEL_94;
        if(i > getChildAt(i1).getBottom()) goto _L4; else goto _L3
_L3:
        int k = i1 + super.mFirstPosition;
_L6:
        return k;
_L4:
        i1++;
          goto _L5
_L2:
        int l = j - 1;
_L7:
label0:
        {
            if(l < 0)
                break MISSING_BLOCK_LABEL_94;
            if(i < getChildAt(l).getTop())
                break label0;
            k = l + super.mFirstPosition;
        }
          goto _L6
        l--;
          goto _L7
        k = -1;
          goto _L6
    }

    View findViewByPredicateInHeadersOrFooters(ArrayList arraylist, Predicate predicate, View view) {
        int i;
        int j;
        if(arraylist == null)
            break MISSING_BLOCK_LABEL_70;
        i = arraylist.size();
        j = 0;
_L3:
        if(j >= i) goto _L2; else goto _L1
_L1:
        View view1;
        View view2 = ((FixedViewInfo)arraylist.get(j)).view;
        if(view2 == view || view2.isRootNamespace())
            continue; /* Loop/switch isn't completed */
        view1 = view2.findViewByPredicate(predicate);
        if(view1 == null)
            continue; /* Loop/switch isn't completed */
_L4:
        return view1;
        j++;
          goto _L3
_L2:
        view1 = null;
          goto _L4
    }

    protected View findViewByPredicateTraversal(Predicate predicate, View view) {
        View view1 = super.findViewByPredicateTraversal(predicate, view);
        if(view1 != null) goto _L2; else goto _L1
_L1:
        View view3 = findViewByPredicateInHeadersOrFooters(mHeaderViewInfos, predicate, view);
        if(view3 == null) goto _L4; else goto _L3
_L3:
        View view2 = view3;
_L6:
        return view2;
_L4:
        view1 = findViewByPredicateInHeadersOrFooters(mFooterViewInfos, predicate, view);
        if(view1 != null) {
            view2 = view1;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        view2 = view1;
        if(true) goto _L6; else goto _L5
_L5:
    }

    View findViewInHeadersOrFooters(ArrayList arraylist, int i) {
        int j;
        int k;
        if(arraylist == null)
            break MISSING_BLOCK_LABEL_61;
        j = arraylist.size();
        k = 0;
_L3:
        if(k >= j) goto _L2; else goto _L1
_L1:
        View view;
        View view1 = ((FixedViewInfo)arraylist.get(k)).view;
        if(view1.isRootNamespace())
            continue; /* Loop/switch isn't completed */
        view = view1.findViewById(i);
        if(view == null)
            continue; /* Loop/switch isn't completed */
_L4:
        return view;
        k++;
          goto _L3
_L2:
        view = null;
          goto _L4
    }

    protected View findViewTraversal(int i) {
        View view = super.findViewTraversal(i);
        if(view != null) goto _L2; else goto _L1
_L1:
        View view2 = findViewInHeadersOrFooters(mHeaderViewInfos, i);
        if(view2 == null) goto _L4; else goto _L3
_L3:
        View view1 = view2;
_L6:
        return view1;
_L4:
        view = findViewInHeadersOrFooters(mFooterViewInfos, i);
        if(view != null) {
            view1 = view;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        view1 = view;
        if(true) goto _L6; else goto _L5
_L5:
    }

    View findViewWithTagInHeadersOrFooters(ArrayList arraylist, Object obj) {
        int i;
        int j;
        if(arraylist == null)
            break MISSING_BLOCK_LABEL_61;
        i = arraylist.size();
        j = 0;
_L3:
        if(j >= i) goto _L2; else goto _L1
_L1:
        View view;
        View view1 = ((FixedViewInfo)arraylist.get(j)).view;
        if(view1.isRootNamespace())
            continue; /* Loop/switch isn't completed */
        view = view1.findViewWithTag(obj);
        if(view == null)
            continue; /* Loop/switch isn't completed */
_L4:
        return view;
        j++;
          goto _L3
_L2:
        view = null;
          goto _L4
    }

    protected View findViewWithTagTraversal(Object obj) {
        View view = super.findViewWithTagTraversal(obj);
        if(view != null) goto _L2; else goto _L1
_L1:
        View view2 = findViewWithTagInHeadersOrFooters(mHeaderViewInfos, obj);
        if(view2 == null) goto _L4; else goto _L3
_L3:
        View view1 = view2;
_L6:
        return view1;
_L4:
        view = findViewWithTagInHeadersOrFooters(mFooterViewInfos, obj);
        if(view != null) {
            view1 = view;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        view1 = view;
        if(true) goto _L6; else goto _L5
_L5:
    }

    boolean fullScroll(int i) {
        boolean flag = false;
        if(i != 33) goto _L2; else goto _L1
_L1:
        if(super.mSelectedPosition != 0) {
            int k = lookForSelectablePosition(0, true);
            if(k >= 0) {
                super.mLayoutMode = 1;
                setSelectionInt(k);
                invokeOnItemScrollListener();
            }
            flag = true;
        }
_L4:
        if(flag && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return flag;
_L2:
        if(i == 130 && super.mSelectedPosition < -1 + super.mItemCount) {
            int j = lookForSelectablePosition(-1 + super.mItemCount, true);
            if(j >= 0) {
                super.mLayoutMode = 3;
                setSelectionInt(j);
                invokeOnItemScrollListener();
            }
            flag = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public volatile Adapter getAdapter() {
        return getAdapter();
    }

    public ListAdapter getAdapter() {
        return super.mAdapter;
    }

    public long[] getCheckItemIds() {
        if(super.mAdapter == null || !super.mAdapter.hasStableIds()) goto _L2; else goto _L1
_L1:
        long al[] = getCheckedItemIds();
_L4:
        return al;
_L2:
        if(super.mChoiceMode != 0 && super.mCheckStates != null && super.mAdapter != null) {
            SparseBooleanArray sparsebooleanarray = super.mCheckStates;
            int i = sparsebooleanarray.size();
            al = new long[i];
            ListAdapter listadapter = super.mAdapter;
            int j = 0;
            int k = 0;
            while(j < i)  {
                long al1[];
                int l;
                if(sparsebooleanarray.valueAt(j)) {
                    l = k + 1;
                    al[k] = listadapter.getItemId(sparsebooleanarray.keyAt(j));
                } else {
                    l = k;
                }
                j++;
                k = l;
            }
            if(k != i) {
                al1 = new long[k];
                System.arraycopy(al, 0, al1, 0, k);
                al = al1;
            }
        } else {
            al = new long[0];
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Drawable getDivider() {
        return mDivider;
    }

    public int getDividerHeight() {
        return mDividerHeight;
    }

    public int getFooterViewsCount() {
        return mFooterViewInfos.size();
    }

    public int getHeaderViewsCount() {
        return mHeaderViewInfos.size();
    }

    public boolean getItemsCanFocus() {
        return mItemsCanFocus;
    }

    public int getMaxScrollAmount() {
        return (int)(0.33F * (float)(super.mBottom - super.mTop));
    }

    public Drawable getOverscrollFooter() {
        return mOverScrollFooter;
    }

    public Drawable getOverscrollHeader() {
        return mOverScrollHeader;
    }

    public boolean isOpaque() {
        boolean flag;
        if(super.mCachingActive && mIsCacheColorOpaque && mDividerIsOpaque && hasOpaqueScrollbars() || super.isOpaque())
            flag = true;
        else
            flag = false;
        if(!flag) goto _L2; else goto _L1
_L1:
        int i;
        View view;
        if(super.mListPadding != null)
            i = super.mListPadding.top;
        else
            i = super.mPaddingTop;
        view = getChildAt(0);
        if(view != null && view.getTop() <= i) goto _L4; else goto _L3
_L3:
        flag = false;
_L2:
        return flag;
_L4:
        int j = getHeight();
        int k;
        int l;
        View view1;
        if(super.mListPadding != null)
            k = super.mListPadding.bottom;
        else
            k = super.mPaddingBottom;
        l = j - k;
        view1 = getChildAt(-1 + getChildCount());
        if(view1 == null || view1.getBottom() < l)
            flag = false;
        if(true) goto _L2; else goto _L5
_L5:
    }

    protected void layoutChildren() {
        boolean flag = super.mBlockLayoutRequests;
        if(flag) goto _L2; else goto _L1
_L1:
        super.mBlockLayoutRequests = true;
        super.layoutChildren();
        invalidate();
        if(super.mAdapter != null) goto _L4; else goto _L3
_L3:
        resetList();
        invokeOnItemScrollListener();
        if(flag) goto _L2; else goto _L5
_L5:
        super.mBlockLayoutRequests = false;
_L2:
        return;
_L4:
        int i;
        int j;
        int k;
        int l;
        View view;
        View view1;
        View view2;
        View view3;
        i = super.mListPadding.top;
        j = super.mBottom - super.mTop - super.mListPadding.bottom;
        k = getChildCount();
        l = 0;
        view = null;
        view1 = null;
        view2 = null;
        view3 = null;
        switch(super.mLayoutMode) {
        default:
            int j2 = super.mSelectedPosition - super.mFirstPosition;
            if(j2 >= 0 && j2 < k)
                view = getChildAt(j2);
            view1 = getChildAt(0);
            if(super.mNextSelectedPosition >= 0)
                l = super.mNextSelectedPosition - super.mSelectedPosition;
            view2 = getChildAt(j2 + l);
            break;

        case 1: // '\001'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            break;

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_236;
        }
_L6:
        boolean flag1;
        flag1 = super.mDataChanged;
        if(flag1)
            handleDataChanged();
        int i1;
        if(super.mItemCount == 0) {
            resetList();
            invokeOnItemScrollListener();
            if(!flag)
                break; /* Loop/switch isn't completed */
        } else {
            if(super.mItemCount != super.mAdapter.getCount())
                throw new IllegalStateException((new StringBuilder()).append("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(").append(getId()).append(", ").append(getClass()).append(") with Adapter(").append(super.mAdapter.getClass()).append(")]").toString());
            break MISSING_BLOCK_LABEL_364;
        }
          goto _L2
        i1 = super.mNextSelectedPosition - super.mFirstPosition;
        if(i1 >= 0 && i1 < k)
            view2 = getChildAt(i1);
          goto _L6
        Exception exception;
        exception;
        if(!flag)
            super.mBlockLayoutRequests = false;
        throw exception;
        AbsListView.RecycleBin recyclebin;
        View view4;
        setSelectedPositionInt(super.mNextSelectedPosition);
        int j1 = super.mFirstPosition;
        recyclebin = super.mRecycler;
        view4 = null;
        if(flag1) {
            for(int i2 = 0; i2 < k; i2++)
                recyclebin.addScrapView(getChildAt(i2), j1 + i2);

        } else {
            recyclebin.fillActiveViews(k, j1);
        }
        View view5 = getFocusedChild();
        if(view5 != null) {
            if(!flag1 || isDirectChildHeaderOrFooter(view5)) {
                view4 = view5;
                view3 = findFocus();
                if(view3 != null)
                    view3.onStartTemporaryDetach();
            }
            requestFocus();
        }
        detachAllViewsFromParent();
        recyclebin.removeSkippedScrap();
        super.mLayoutMode;
        JVM INSTR tableswitch 1 6: default 536
    //                   1 827
    //                   2 754
    //                   3 805
    //                   4 846
    //                   5 788
    //                   6 863;
           goto _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L7:
        View view6;
        boolean flag2;
        if(k == 0) {
            if(!super.mStackFromBottom) {
                setSelectedPositionInt(lookForSelectablePosition(0, true));
                view6 = fillFromTop(i);
            } else {
                setSelectedPositionInt(lookForSelectablePosition(-1 + super.mItemCount, false));
                view6 = fillUp(-1 + super.mItemCount, j);
            }
        } else
        if(super.mSelectedPosition >= 0 && super.mSelectedPosition < super.mItemCount) {
            int l1 = super.mSelectedPosition;
            if(view != null)
                i = view.getTop();
            view6 = fillSpecific(l1, i);
        } else
        if(super.mFirstPosition < super.mItemCount) {
            int k1 = super.mFirstPosition;
            if(view1 != null)
                i = view1.getTop();
            view6 = fillSpecific(k1, i);
        } else {
            view6 = fillSpecific(0, i);
        }
_L16:
        recyclebin.scrapActiveViews();
        if(view6 == null)
            break MISSING_BLOCK_LABEL_1046;
        if(!mItemsCanFocus || !hasFocus() || view6.hasFocus()) goto _L15; else goto _L14
_L14:
        if(view6 == view4 && view3 != null && view3.requestFocus() || view6.requestFocus())
            flag2 = true;
        else
            flag2 = false;
        if(!flag2) {
            View view8 = getFocusedChild();
            if(view8 != null)
                view8.clearFocus();
            positionSelector(-1, view6);
        } else {
            view6.setSelected(false);
            super.mSelectorRect.setEmpty();
        }
_L17:
        super.mSelectedTop = view6.getTop();
_L18:
        if(view3 != null && view3.getWindowToken() != null)
            view3.onFinishTemporaryDetach();
        super.mLayoutMode = 0;
        super.mDataChanged = false;
        if(super.mPositionScrollAfterLayout != null) {
            post(super.mPositionScrollAfterLayout);
            super.mPositionScrollAfterLayout = null;
        }
        super.mNeedSync = false;
        setNextSelectedPositionInt(super.mSelectedPosition);
        updateScrollIndicators();
        if(super.mItemCount > 0)
            checkSelectionChanged();
        invokeOnItemScrollListener();
        if(flag) goto _L2; else goto _L5
_L9:
        if(view2 != null)
            view6 = fillFromSelection(view2.getTop(), i, j);
        else
            view6 = fillFromMiddle(i, j);
          goto _L16
_L12:
        view6 = fillSpecific(super.mSyncPosition, super.mSpecificTop);
          goto _L16
_L10:
        view6 = fillUp(-1 + super.mItemCount, j);
        adjustViewsUpOrDown();
          goto _L16
_L8:
        super.mFirstPosition = 0;
        view6 = fillFromTop(i);
        adjustViewsUpOrDown();
          goto _L16
_L11:
        view6 = fillSpecific(reconcileSelectedPosition(), super.mSpecificTop);
          goto _L16
_L13:
        view6 = moveSelection(view, view2, l, i, j);
          goto _L16
_L15:
        positionSelector(-1, view6);
          goto _L17
        if(super.mTouchMode > 0 && super.mTouchMode < 3) {
            View view7 = getChildAt(super.mMotionPosition - super.mFirstPosition);
            if(view7 != null)
                positionSelector(super.mMotionPosition, view7);
        } else {
            super.mSelectedTop = 0;
            super.mSelectorRect.setEmpty();
        }
        if(hasFocus() && view3 != null)
            view3.requestFocus();
          goto _L18
    }

    int lookForSelectablePosition(int i, boolean flag) {
        int j;
        ListAdapter listadapter;
        j = -1;
        listadapter = super.mAdapter;
        if(listadapter != null && !isInTouchMode()) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int k = listadapter.getCount();
        if(!mAreAllItemsSelectable) {
            int l;
            if(flag)
                for(l = Math.max(0, i); l < k && !listadapter.isEnabled(l); l++);
            else
                for(l = Math.min(i, k - 1); l >= 0 && !listadapter.isEnabled(l); l--);
            if(l >= 0 && l < k)
                j = l;
        } else
        if(i >= 0 && i < k)
            j = i;
        if(true) goto _L1; else goto _L3
_L3:
    }

    final int measureHeightOfChildren(int i, int j, int k, int l, int i1) {
        ListAdapter listadapter = super.mAdapter;
        if(listadapter != null) goto _L2; else goto _L1
_L1:
        int l1 = super.mListPadding.top + super.mListPadding.bottom;
_L4:
        return l1;
_L2:
        int j1 = super.mListPadding.top + super.mListPadding.bottom;
        int k1;
        AbsListView.RecycleBin recyclebin;
        boolean flag;
        boolean aflag[];
        if(mDividerHeight > 0 && mDivider != null)
            k1 = mDividerHeight;
        else
            k1 = 0;
        l1 = 0;
        if(k == -1)
            k = -1 + listadapter.getCount();
        recyclebin = super.mRecycler;
        flag = recycleOnMeasure();
        aflag = super.mIsScrap;
        for(int i2 = j; i2 <= k; i2++) {
            View view = obtainView(i2, aflag);
            measureScrapChild(view, i2, i);
            if(i2 > 0)
                j1 += k1;
            if(flag && recyclebin.shouldRecycleViewType(((AbsListView.LayoutParams)view.getLayoutParams()).viewType))
                recyclebin.addScrapView(view, -1);
            j1 += view.getMeasuredHeight();
            if(j1 >= l) {
                if(i1 < 0 || i2 <= i1 || l1 <= 0 || j1 == l)
                    l1 = l;
                continue; /* Loop/switch isn't completed */
            }
            if(i1 >= 0 && i2 >= i1)
                l1 = j1;
        }

        l1 = j1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = getChildCount();
        if(i > 0) {
            for(int j = 0; j < i; j++)
                addHeaderView(getChildAt(j));

            removeAllViews();
        }
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect) {
        super.onFocusChanged(flag, i, rect);
        ListAdapter listadapter = super.mAdapter;
        int j = -1;
        int k = 0;
        if(listadapter != null && flag && rect != null) {
            rect.offset(super.mScrollX, super.mScrollY);
            if(listadapter.getCount() < getChildCount() + super.mFirstPosition) {
                super.mLayoutMode = 0;
                layoutChildren();
            }
            Rect rect1 = mTempRect;
            int l = 0x7fffffff;
            int i1 = getChildCount();
            int j1 = super.mFirstPosition;
            int k1 = 0;
            while(k1 < i1)  {
                if(listadapter.isEnabled(j1 + k1)) {
                    View view = getChildAt(k1);
                    view.getDrawingRect(rect1);
                    offsetDescendantRectToMyCoords(view, rect1);
                    int l1 = getDistance(rect, rect1, i);
                    if(l1 < l) {
                        l = l1;
                        j = k1;
                        k = view.getTop();
                    }
                }
                k1++;
            }
        }
        if(j >= 0)
            setSelectionFromTop(j + super.mFirstPosition, k);
        else
            requestLayout();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ListView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ListView.getName());
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        return commonKey(i, 1, keyevent);
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent) {
        return commonKey(i, j, keyevent);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        return commonKey(i, 1, keyevent);
    }

    protected void onMeasure(int i, int j) {
        super.onMeasure(i, j);
        int k = android.view.View.MeasureSpec.getMode(i);
        int l = android.view.View.MeasureSpec.getMode(j);
        int i1 = android.view.View.MeasureSpec.getSize(i);
        int j1 = android.view.View.MeasureSpec.getSize(j);
        int k1 = 0;
        int l1 = 0;
        int i2 = 0;
        int j2;
        int k2;
        if(super.mAdapter == null)
            j2 = 0;
        else
            j2 = super.mAdapter.getCount();
        super.mItemCount = j2;
        if(super.mItemCount > 0 && (k == 0 || l == 0)) {
            View view = obtainView(0, super.mIsScrap);
            measureScrapChild(view, 0, i);
            k1 = view.getMeasuredWidth();
            l1 = view.getMeasuredHeight();
            i2 = combineMeasuredStates(0, view.getMeasuredState());
            if(recycleOnMeasure() && super.mRecycler.shouldRecycleViewType(((AbsListView.LayoutParams)view.getLayoutParams()).viewType))
                super.mRecycler.addScrapView(view, -1);
        }
        if(k == 0)
            k2 = k1 + (super.mListPadding.left + super.mListPadding.right) + getVerticalScrollbarWidth();
        else
            k2 = i1 | 0xff000000 & i2;
        if(l == 0)
            j1 = l1 + (super.mListPadding.top + super.mListPadding.bottom) + 2 * getVerticalFadingEdgeLength();
        if(l == 0x80000000)
            j1 = measureHeightOfChildren(i, 0, -1, j1, -1);
        setMeasuredDimension(k2, j1);
        super.mWidthMeasureSpec = i;
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        if(getChildCount() > 0) {
            View view = getFocusedChild();
            if(view != null) {
                int i1 = super.mFirstPosition + indexOfChild(view);
                int j1 = Math.max(0, view.getBottom() - (j - super.mPaddingTop));
                int k1 = view.getTop() - j1;
                if(mFocusSelector == null)
                    mFocusSelector = new FocusSelector();
                post(mFocusSelector.setup(i1, k1));
            }
        }
        super.onSizeChanged(i, j, k, l);
    }

    boolean pageScroll(int i) {
        boolean flag;
        flag = true;
        int j = -1;
        boolean flag1 = false;
        int k;
        if(i == 33)
            j = Math.max(0, -1 + (super.mSelectedPosition - getChildCount()));
        else
        if(i == 130) {
            j = Math.min(-1 + super.mItemCount, -1 + (super.mSelectedPosition + getChildCount()));
            flag1 = true;
        }
        if(j < 0) goto _L2; else goto _L1
_L1:
        k = lookForSelectablePosition(j, flag1);
        if(k < 0) goto _L2; else goto _L3
_L3:
        super.mLayoutMode = 4;
        super.mSpecificTop = super.mPaddingTop + getVerticalFadingEdgeLength();
        if(flag1 && k > super.mItemCount - getChildCount())
            super.mLayoutMode = 3;
        if(!flag1 && k < getChildCount())
            super.mLayoutMode = ((flag) ? 1 : 0);
        setSelectionInt(k);
        invokeOnItemScrollListener();
        if(!awakenScrollBars())
            invalidate();
_L5:
        return flag;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected boolean recycleOnMeasure() {
        return true;
    }

    public boolean removeFooterView(View view) {
        boolean flag;
        if(mFooterViewInfos.size() > 0) {
            flag = false;
            if(super.mAdapter != null && ((HeaderViewListAdapter)super.mAdapter).removeFooter(view)) {
                if(super.mDataSetObserver != null)
                    super.mDataSetObserver.onChanged();
                flag = true;
            }
            removeFixedViewInfo(view, mFooterViewInfos);
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean removeHeaderView(View view) {
        boolean flag;
        if(mHeaderViewInfos.size() > 0) {
            flag = false;
            if(super.mAdapter != null && ((HeaderViewListAdapter)super.mAdapter).removeHeader(view)) {
                if(super.mDataSetObserver != null)
                    super.mDataSetObserver.onChanged();
                flag = true;
            }
            removeFixedViewInfo(view, mHeaderViewInfos);
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag) {
        int i = rect.top;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int j = getHeight();
        int k = getScrollY();
        int l = k + j;
        int i1 = getVerticalFadingEdgeLength();
        if(showingTopFadingEdge() && (super.mSelectedPosition > 0 || i > i1))
            k += i1;
        int j1 = getChildAt(-1 + getChildCount()).getBottom();
        if(showingBottomFadingEdge() && (super.mSelectedPosition < -1 + super.mItemCount || rect.bottom < j1 - i1))
            l -= i1;
        int k1 = 0;
        boolean flag1;
        if(rect.bottom > l && rect.top > k) {
            int i2;
            if(rect.height() > j)
                i2 = 0 + (rect.top - k);
            else
                i2 = 0 + (rect.bottom - l);
            k1 = Math.min(i2, j1 - l);
        } else
        if(rect.top < k && rect.bottom < l) {
            int l1;
            if(rect.height() > j)
                l1 = 0 - (l - rect.bottom);
            else
                l1 = 0 - (k - rect.top);
            k1 = Math.max(l1, getChildAt(0).getTop() - k);
        }
        if(k1 != 0)
            flag1 = true;
        else
            flag1 = false;
        if(flag1) {
            scrollListItemsBy(-k1);
            positionSelector(-1, view);
            super.mSelectedTop = view.getTop();
            invalidate();
        }
        return flag1;
    }

    void resetList() {
        clearRecycledState(mHeaderViewInfos);
        clearRecycledState(mFooterViewInfos);
        super.resetList();
        super.mLayoutMode = 0;
    }

    public volatile void setAdapter(Adapter adapter) {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter) {
        if(super.mAdapter != null && super.mDataSetObserver != null)
            super.mAdapter.unregisterDataSetObserver(super.mDataSetObserver);
        resetList();
        super.mRecycler.clear();
        if(mHeaderViewInfos.size() > 0 || mFooterViewInfos.size() > 0)
            super.mAdapter = new HeaderViewListAdapter(mHeaderViewInfos, mFooterViewInfos, listadapter);
        else
            super.mAdapter = listadapter;
        super.mOldSelectedPosition = -1;
        super.mOldSelectedRowId = 0x8000000000000000L;
        super.setAdapter(listadapter);
        if(super.mAdapter != null) {
            mAreAllItemsSelectable = super.mAdapter.areAllItemsEnabled();
            super.mOldItemCount = super.mItemCount;
            super.mItemCount = super.mAdapter.getCount();
            checkFocus();
            super.mDataSetObserver = new AbsListView.AdapterDataSetObserver(this);
            super.mAdapter.registerDataSetObserver(super.mDataSetObserver);
            super.mRecycler.setViewTypeCount(super.mAdapter.getViewTypeCount());
            int i;
            if(super.mStackFromBottom)
                i = lookForSelectablePosition(-1 + super.mItemCount, false);
            else
                i = lookForSelectablePosition(0, true);
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if(super.mItemCount == 0)
                checkSelectionChanged();
        } else {
            mAreAllItemsSelectable = true;
            checkFocus();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setCacheColorHint(int i) {
        boolean flag;
        if(i >>> 24 == 255)
            flag = true;
        else
            flag = false;
        mIsCacheColorOpaque = flag;
        if(flag) {
            if(mDividerPaint == null)
                mDividerPaint = new Paint();
            mDividerPaint.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    public void setDivider(Drawable drawable) {
        boolean flag = false;
        if(drawable != null)
            mDividerHeight = drawable.getIntrinsicHeight();
        else
            mDividerHeight = 0;
        mDivider = drawable;
        if(drawable == null || drawable.getOpacity() == -1)
            flag = true;
        mDividerIsOpaque = flag;
        requestLayout();
        invalidate();
    }

    public void setDividerHeight(int i) {
        mDividerHeight = i;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean flag) {
        mFooterDividersEnabled = flag;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean flag) {
        mHeaderDividersEnabled = flag;
        invalidate();
    }

    public void setItemsCanFocus(boolean flag) {
        mItemsCanFocus = flag;
        if(!flag)
            setDescendantFocusability(0x60000);
    }

    public void setOverscrollFooter(Drawable drawable) {
        mOverScrollFooter = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        mOverScrollHeader = drawable;
        if(super.mScrollY < 0)
            invalidate();
    }

    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
    }

    public void setSelection(int i) {
        setSelectionFromTop(i, 0);
    }

    public void setSelectionAfterHeaderView() {
        int i = mHeaderViewInfos.size();
        if(i > 0)
            super.mNextSelectedPosition = 0;
        else
        if(super.mAdapter != null) {
            setSelection(i);
        } else {
            super.mNextSelectedPosition = i;
            super.mLayoutMode = 2;
        }
    }

    public void setSelectionFromTop(int i, int j) {
        if(super.mAdapter != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(!isInTouchMode()) {
            i = lookForSelectablePosition(i, true);
            if(i >= 0)
                setNextSelectedPositionInt(i);
        } else {
            super.mResurrectToPosition = i;
        }
        if(i >= 0) {
            super.mLayoutMode = 4;
            super.mSpecificTop = j + super.mListPadding.top;
            if(super.mNeedSync) {
                super.mSyncPosition = i;
                super.mSyncRowId = super.mAdapter.getItemId(i);
            }
            if(super.mPositionScroller != null)
                super.mPositionScroller.stop();
            requestLayout();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    void setSelectionInt(int i) {
        boolean flag;
        int j;
        setNextSelectedPositionInt(i);
        flag = false;
        j = super.mSelectedPosition;
        if(j < 0) goto _L2; else goto _L1
_L1:
        if(i != j - 1) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        if(super.mPositionScroller != null)
            super.mPositionScroller.stop();
        layoutChildren();
        if(flag)
            awakenScrollBars();
        return;
_L4:
        if(i == j + 1)
            flag = true;
        if(true) goto _L2; else goto _L5
_L5:
    }

    public void smoothScrollByOffset(int i) {
        super.smoothScrollByOffset(i);
    }

    public void smoothScrollToPosition(int i) {
        super.smoothScrollToPosition(i);
    }

    private static final float MAX_SCROLL_FACTOR = 0.33F;
    private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
    static final int NO_POSITION = -1;
    private boolean mAreAllItemsSelectable;
    private final ArrowScrollFocusResult mArrowScrollFocusResult;
    Drawable mDivider;
    int mDividerHeight;
    private boolean mDividerIsOpaque;
    private Paint mDividerPaint;
    private FocusSelector mFocusSelector;
    private boolean mFooterDividersEnabled;
    private ArrayList mFooterViewInfos;
    private boolean mHeaderDividersEnabled;
    private ArrayList mHeaderViewInfos;
    private boolean mIsCacheColorOpaque;
    private boolean mItemsCanFocus;
    Drawable mOverScrollFooter;
    Drawable mOverScrollHeader;
    private final Rect mTempRect;
}
