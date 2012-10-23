// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            AbsListView, AdapterView, PopupWindow, ListAdapter, 
//            Checkable, Adapter

public class GridView extends AbsListView {

    public GridView(Context context) {
        this(context, null);
    }

    public GridView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010071);
    }

    public GridView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mNumColumns = -1;
        mHorizontalSpacing = 0;
        mVerticalSpacing = 0;
        mStretchMode = 2;
        mReferenceView = null;
        mReferenceViewInSelectedRow = null;
        mGravity = 3;
        mTempRect = new Rect();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.GridView, i, 0);
        setHorizontalSpacing(typedarray.getDimensionPixelOffset(1, 0));
        setVerticalSpacing(typedarray.getDimensionPixelOffset(2, 0));
        int j = typedarray.getInt(3, 2);
        if(j >= 0)
            setStretchMode(j);
        int k = typedarray.getDimensionPixelOffset(4, -1);
        if(k > 0)
            setColumnWidth(k);
        setNumColumns(typedarray.getInt(5, 1));
        int l = typedarray.getInt(0, -1);
        if(l >= 0)
            setGravity(l);
        typedarray.recycle();
    }

    private void adjustForBottomFadingEdge(View view, int i, int j) {
        if(view.getBottom() > j)
            offsetChildrenTopAndBottom(-Math.min(view.getTop() - i, view.getBottom() - j));
    }

    private void adjustForTopFadingEdge(View view, int i, int j) {
        if(view.getTop() < i)
            offsetChildrenTopAndBottom(Math.min(i - view.getTop(), j - view.getBottom()));
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
            j -= mVerticalSpacing;
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
            j += mVerticalSpacing;
        if(j > 0)
            j = 0;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean commonKey(int i, int j, KeyEvent keyevent) {
        boolean flag = false;
        if(super.mAdapter != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1;
        int k;
        if(super.mDataChanged)
            layoutChildren();
        flag1 = false;
        k = keyevent.getAction();
        if(k == 1) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR lookupswitch 11: default 140
    //                   19: 221
    //                   20: 292
    //                   21: 151
    //                   22: 186
    //                   23: 365
    //                   62: 407
    //                   66: 365
    //                   92: 496
    //                   93: 567
    //                   122: 640
    //                   123: 675;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L9 _L11 _L12 _L13 _L14
_L4:
        if(!flag1)
            break; /* Loop/switch isn't completed */
        flag = true;
        continue; /* Loop/switch isn't completed */
_L7:
        if(keyevent.hasNoModifiers())
            if(resurrectSelectionIfNeeded() || arrowScroll(17))
                flag1 = true;
            else
                flag1 = false;
        continue; /* Loop/switch isn't completed */
_L8:
        if(keyevent.hasNoModifiers())
            if(resurrectSelectionIfNeeded() || arrowScroll(66))
                flag1 = true;
            else
                flag1 = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if(keyevent.hasNoModifiers()) {
            if(resurrectSelectionIfNeeded() || arrowScroll(33))
                flag1 = true;
            else
                flag1 = false;
        } else
        if(keyevent.hasModifiers(2))
            if(resurrectSelectionIfNeeded() || fullScroll(33))
                flag1 = true;
            else
                flag1 = false;
        continue; /* Loop/switch isn't completed */
_L6:
        if(keyevent.hasNoModifiers()) {
            if(resurrectSelectionIfNeeded() || arrowScroll(130))
                flag1 = true;
            else
                flag1 = false;
        } else
        if(keyevent.hasModifiers(2))
            if(resurrectSelectionIfNeeded() || fullScroll(130))
                flag1 = true;
            else
                flag1 = false;
        continue; /* Loop/switch isn't completed */
_L9:
        if(keyevent.hasNoModifiers()) {
            flag1 = resurrectSelectionIfNeeded();
            if(!flag1 && keyevent.getRepeatCount() == 0 && getChildCount() > 0) {
                keyPressed();
                flag1 = true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if(super.mPopup == null || !super.mPopup.isShowing())
            if(keyevent.hasNoModifiers()) {
                if(resurrectSelectionIfNeeded() || pageScroll(130))
                    flag1 = true;
                else
                    flag1 = false;
            } else
            if(keyevent.hasModifiers(1))
                if(resurrectSelectionIfNeeded() || pageScroll(33))
                    flag1 = true;
                else
                    flag1 = false;
        continue; /* Loop/switch isn't completed */
_L11:
        if(keyevent.hasNoModifiers()) {
            if(resurrectSelectionIfNeeded() || pageScroll(33))
                flag1 = true;
            else
                flag1 = false;
        } else
        if(keyevent.hasModifiers(2))
            if(resurrectSelectionIfNeeded() || fullScroll(33))
                flag1 = true;
            else
                flag1 = false;
        continue; /* Loop/switch isn't completed */
_L12:
        if(keyevent.hasNoModifiers()) {
            if(resurrectSelectionIfNeeded() || pageScroll(130))
                flag1 = true;
            else
                flag1 = false;
        } else
        if(keyevent.hasModifiers(2))
            if(resurrectSelectionIfNeeded() || fullScroll(130))
                flag1 = true;
            else
                flag1 = false;
        continue; /* Loop/switch isn't completed */
_L13:
        if(keyevent.hasNoModifiers())
            if(resurrectSelectionIfNeeded() || fullScroll(33))
                flag1 = true;
            else
                flag1 = false;
        continue; /* Loop/switch isn't completed */
_L14:
        if(keyevent.hasNoModifiers())
            if(resurrectSelectionIfNeeded() || fullScroll(130))
                flag1 = true;
            else
                flag1 = false;
        if(true) goto _L4; else goto _L15
_L15:
        if(!sendToTextFilter(i, j, keyevent))
            break; /* Loop/switch isn't completed */
        flag = true;
        if(true) goto _L1; else goto _L16
_L16:
        switch(k) {
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
        if(true) goto _L1; else goto _L17
_L17:
    }

    private void correctTooHigh(int i, int j, int k) {
        if(-1 + (k + super.mFirstPosition) == -1 + super.mItemCount && k > 0) {
            int l = getChildAt(k - 1).getBottom();
            int i1 = super.mBottom - super.mTop - super.mListPadding.bottom - l;
            View view = getChildAt(0);
            int j1 = view.getTop();
            if(i1 > 0 && (super.mFirstPosition > 0 || j1 < super.mListPadding.top)) {
                if(super.mFirstPosition == 0)
                    i1 = Math.min(i1, super.mListPadding.top - j1);
                offsetChildrenTopAndBottom(i1);
                if(super.mFirstPosition > 0) {
                    int k1 = super.mFirstPosition;
                    if(super.mStackFromBottom)
                        i = 1;
                    fillUp(k1 - i, view.getTop() - j);
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private void correctTooLow(int i, int j, int k) {
        if(super.mFirstPosition == 0 && k > 0) {
            int l = getChildAt(0).getTop();
            int i1 = super.mListPadding.top;
            int j1 = super.mBottom - super.mTop - super.mListPadding.bottom;
            int k1 = l - i1;
            View view = getChildAt(k - 1);
            int l1 = view.getBottom();
            int i2 = -1 + (k + super.mFirstPosition);
            if(k1 > 0 && (i2 < -1 + super.mItemCount || l1 > j1)) {
                if(i2 == -1 + super.mItemCount)
                    k1 = Math.min(k1, l1 - j1);
                offsetChildrenTopAndBottom(-k1);
                if(i2 < -1 + super.mItemCount) {
                    if(!super.mStackFromBottom)
                        i = 1;
                    fillDown(i2 + i, j + view.getBottom());
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private boolean determineColumns(int i) {
        int j;
        int l;
        int i1;
        j = mRequestedHorizontalSpacing;
        int k = mStretchMode;
        l = mRequestedColumnWidth;
        boolean flag = false;
        if(mRequestedNumColumns == -1) {
            if(l > 0)
                mNumColumns = (i + j) / (l + j);
            else
                mNumColumns = 2;
        } else {
            mNumColumns = mRequestedNumColumns;
        }
        if(mNumColumns <= 0)
            mNumColumns = 1;
        k;
        JVM INSTR tableswitch 0 0: default 76
    //                   0 154;
           goto _L1 _L2
_L1:
        i1 = i - l * mNumColumns - j * (-1 + mNumColumns);
        if(i1 < 0)
            flag = true;
        k;
        JVM INSTR tableswitch 1 3: default 132
    //                   1 190
    //                   2 168
    //                   3 234;
           goto _L3 _L4 _L5 _L6
_L3:
        return flag;
_L2:
        mColumnWidth = l;
        mHorizontalSpacing = j;
        continue; /* Loop/switch isn't completed */
_L5:
        mColumnWidth = l + i1 / mNumColumns;
        mHorizontalSpacing = j;
        continue; /* Loop/switch isn't completed */
_L4:
        mColumnWidth = l;
        if(mNumColumns > 1)
            mHorizontalSpacing = j + i1 / (-1 + mNumColumns);
        else
            mHorizontalSpacing = j + i1;
        continue; /* Loop/switch isn't completed */
_L6:
        mColumnWidth = l;
        if(mNumColumns > 1)
            mHorizontalSpacing = j + i1 / (1 + mNumColumns);
        else
            mHorizontalSpacing = j + i1;
        if(true) goto _L3; else goto _L7
_L7:
    }

    private View fillDown(int i, int j) {
        View view = null;
        int k = super.mBottom - super.mTop;
        if((0x22 & super.mGroupFlags) == 34)
            k -= super.mListPadding.bottom;
        for(; j < k && i < super.mItemCount; i += mNumColumns) {
            View view1 = makeRow(i, j, true);
            if(view1 != null)
                view = view1;
            j = mReferenceView.getBottom() + mVerticalSpacing;
        }

        setVisibleRangeHint(super.mFirstPosition, -1 + (super.mFirstPosition + getChildCount()));
        return view;
    }

    private View fillFromBottom(int i, int j) {
        int k = Math.min(Math.max(i, super.mSelectedPosition), -1 + super.mItemCount);
        int l = (-1 + super.mItemCount) - k;
        return fillUp((-1 + super.mItemCount) - (l - l % mNumColumns), j);
    }

    private View fillFromSelection(int i, int j, int k) {
        int l = getVerticalFadingEdgeLength();
        int i1 = super.mSelectedPosition;
        int j1 = mNumColumns;
        int k1 = mVerticalSpacing;
        int l1 = -1;
        int j2;
        int k2;
        int l2;
        int i3;
        View view;
        View view1;
        if(!super.mStackFromBottom) {
            j2 = i1 - i1 % j1;
        } else {
            int i2 = (-1 + super.mItemCount) - i1;
            l1 = (-1 + super.mItemCount) - (i2 - i2 % j1);
            j2 = Math.max(0, 1 + (l1 - j1));
        }
        k2 = getTopSelectionPixel(j, l, j2);
        l2 = getBottomSelectionPixel(k, l, j1, j2);
        if(super.mStackFromBottom)
            i3 = l1;
        else
            i3 = j2;
        view = makeRow(i3, i, true);
        super.mFirstPosition = j2;
        view1 = mReferenceView;
        adjustForTopFadingEdge(view1, k2, l2);
        adjustForBottomFadingEdge(view1, k2, l2);
        if(!super.mStackFromBottom) {
            fillUp(j2 - j1, view1.getTop() - k1);
            adjustViewsUpOrDown();
            fillDown(j2 + j1, k1 + view1.getBottom());
        } else {
            fillDown(l1 + j1, k1 + view1.getBottom());
            adjustViewsUpOrDown();
            fillUp(j2 - 1, view1.getTop() - k1);
        }
        return view;
    }

    private View fillFromTop(int i) {
        super.mFirstPosition = Math.min(super.mFirstPosition, super.mSelectedPosition);
        super.mFirstPosition = Math.min(super.mFirstPosition, -1 + super.mItemCount);
        if(super.mFirstPosition < 0)
            super.mFirstPosition = 0;
        super.mFirstPosition = super.mFirstPosition - super.mFirstPosition % mNumColumns;
        return fillDown(super.mFirstPosition, i);
    }

    private View fillSelection(int i, int j) {
        int k = reconcileSelectedPosition();
        int l = mNumColumns;
        int i1 = mVerticalSpacing;
        int j1 = -1;
        int l1;
        int i2;
        int j2;
        int k2;
        View view;
        View view1;
        if(!super.mStackFromBottom) {
            l1 = k - k % l;
        } else {
            int k1 = (-1 + super.mItemCount) - k;
            j1 = (-1 + super.mItemCount) - (k1 - k1 % l);
            l1 = Math.max(0, 1 + (j1 - l));
        }
        i2 = getVerticalFadingEdgeLength();
        j2 = getTopSelectionPixel(i, i2, l1);
        if(super.mStackFromBottom)
            k2 = j1;
        else
            k2 = l1;
        view = makeRow(k2, j2, true);
        super.mFirstPosition = l1;
        view1 = mReferenceView;
        if(!super.mStackFromBottom) {
            fillDown(l1 + l, i1 + view1.getBottom());
            pinToBottom(j);
            fillUp(l1 - l, view1.getTop() - i1);
            adjustViewsUpOrDown();
        } else {
            offsetChildrenTopAndBottom(getBottomSelectionPixel(j, i2, l, l1) - view1.getBottom());
            fillUp(l1 - 1, view1.getTop() - i1);
            pinToTop(i);
            fillDown(j1 + l, i1 + view1.getBottom());
            adjustViewsUpOrDown();
        }
        return view;
    }

    private View fillSpecific(int i, int j) {
        int k;
        int l;
        int j1;
        View view;
        View view1;
        k = mNumColumns;
        l = -1;
        int k1;
        if(!super.mStackFromBottom) {
            j1 = i - i % k;
        } else {
            int i1 = (-1 + super.mItemCount) - i;
            l = (-1 + super.mItemCount) - (i1 - i1 % k);
            j1 = Math.max(0, 1 + (l - k));
        }
        if(super.mStackFromBottom)
            k1 = l;
        else
            k1 = j1;
        view = makeRow(k1, j, true);
        super.mFirstPosition = j1;
        view1 = mReferenceView;
        if(view1 != null) goto _L2; else goto _L1
_L1:
        view = null;
_L5:
        return view;
_L2:
        int l1 = mVerticalSpacing;
        if(super.mStackFromBottom) goto _L4; else goto _L3
_L3:
        View view2;
        View view3;
        view3 = fillUp(j1 - k, view1.getTop() - l1);
        adjustViewsUpOrDown();
        view2 = fillDown(j1 + k, l1 + view1.getBottom());
        int j2 = getChildCount();
        if(j2 > 0)
            correctTooHigh(k, l1, j2);
_L6:
        if(view == null)
            if(view3 != null)
                view = view3;
            else
                view = view2;
        if(true) goto _L5; else goto _L4
_L4:
        view2 = fillDown(l + k, l1 + view1.getBottom());
        adjustViewsUpOrDown();
        view3 = fillUp(j1 - 1, view1.getTop() - l1);
        int i2 = getChildCount();
        if(i2 > 0)
            correctTooLow(k, l1, i2);
          goto _L6
    }

    private View fillUp(int i, int j) {
        View view = null;
        int k = 0;
        if((0x22 & super.mGroupFlags) == 34)
            k = super.mListPadding.top;
        for(; j > k && i >= 0; i -= mNumColumns) {
            View view1 = makeRow(i, j, false);
            if(view1 != null)
                view = view1;
            j = mReferenceView.getTop() - mVerticalSpacing;
            super.mFirstPosition = i;
        }

        if(super.mStackFromBottom)
            super.mFirstPosition = Math.max(0, i + 1);
        setVisibleRangeHint(super.mFirstPosition, -1 + (super.mFirstPosition + getChildCount()));
        return view;
    }

    private int getBottomSelectionPixel(int i, int j, int k, int l) {
        int i1 = i;
        if(-1 + (l + k) < -1 + super.mItemCount)
            i1 -= j;
        return i1;
    }

    private int getTopSelectionPixel(int i, int j, int k) {
        int l = i;
        if(k > 0)
            l += j;
        return l;
    }

    private boolean isCandidateSelection(int i, int j) {
        boolean flag;
        int k;
        int i1;
        int j1;
        flag = true;
        k = getChildCount();
        int l = k - 1 - i;
        if(!super.mStackFromBottom) {
            j1 = i - i % mNumColumns;
            i1 = Math.max(-1 + (j1 + mNumColumns), k);
        } else {
            i1 = k - 1 - (l - l % mNumColumns);
            j1 = Math.max(0, 1 + (i1 - mNumColumns));
        }
        j;
        JVM INSTR lookupswitch 6: default 108
    //                   1: 218
    //                   2: 202
    //                   17: 177
    //                   33: 188
    //                   66: 154
    //                   130: 167;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
_L6:
        if(i != j1)
            flag = false;
_L9:
        return flag;
_L7:
        if(j1 != 0)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L4:
        if(i != i1)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if(i1 != k - 1)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        if(i != j1 || j1 != 0)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L2:
        if(i != i1 || i1 != k - 1)
            flag = false;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private View makeAndAddView(int i, int j, boolean flag, int k, boolean flag1, int l) {
        if(super.mDataChanged) goto _L2; else goto _L1
_L1:
        View view2 = super.mRecycler.getActiveView(i);
        if(view2 == null) goto _L2; else goto _L3
_L3:
        View view1;
        setupChild(view2, i, j, flag, k, flag1, true, l);
        view1 = view2;
_L5:
        return view1;
_L2:
        View view = obtainView(i, super.mIsScrap);
        setupChild(view, i, j, flag, k, flag1, super.mIsScrap[0], l);
        view1 = view;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private View makeRow(int i, int j, boolean flag) {
        int k = mColumnWidth;
        int l = mHorizontalSpacing;
        int i1 = super.mListPadding.left;
        int j1;
        int k1;
        int l1;
        View view;
        boolean flag1;
        boolean flag2;
        int i2;
        View view1;
        int j2;
        if(mStretchMode == 3)
            j1 = l;
        else
            j1 = 0;
        k1 = i1 + j1;
        if(!super.mStackFromBottom) {
            l1 = Math.min(i + mNumColumns, super.mItemCount);
        } else {
            l1 = i + 1;
            i = Math.max(0, 1 + (i - mNumColumns));
            if(l1 - i < mNumColumns)
                k1 += (mNumColumns - (l1 - i)) * (k + l);
        }
        view = null;
        flag1 = shouldShowSelector();
        flag2 = touchModeDrawsInPressedState();
        i2 = super.mSelectedPosition;
        view1 = null;
        j2 = i;
        while(j2 < l1)  {
            boolean flag3;
            int k2;
            if(j2 == i2)
                flag3 = true;
            else
                flag3 = false;
            if(flag)
                k2 = -1;
            else
                k2 = j2 - i;
            view1 = makeAndAddView(j2, j, flag, k1, flag3, k2);
            k1 += k;
            if(j2 < l1 - 1)
                k1 += l;
            if(flag3 && (flag1 || flag2))
                view = view1;
            j2++;
        }
        mReferenceView = view1;
        if(view != null)
            mReferenceViewInSelectedRow = mReferenceView;
        return view;
    }

    private View moveSelection(int i, int j, int k) {
        int l = getVerticalFadingEdgeLength();
        int i1 = super.mSelectedPosition;
        int j1 = mNumColumns;
        int k1 = mVerticalSpacing;
        int l1 = -1;
        int j2;
        int l2;
        int i3;
        int j3;
        int k3;
        View view;
        View view1;
        if(!super.mStackFromBottom) {
            l2 = i1 - i - (i1 - i) % j1;
            j2 = i1 - i1 % j1;
        } else {
            int i2 = (-1 + super.mItemCount) - i1;
            l1 = (-1 + super.mItemCount) - (i2 - i2 % j1);
            j2 = Math.max(0, 1 + (l1 - j1));
            int k2 = (-1 + super.mItemCount) - (i1 - i);
            l2 = Math.max(0, 1 + ((-1 + super.mItemCount) - (k2 - k2 % j1) - j1));
        }
        i3 = j2 - l2;
        j3 = getTopSelectionPixel(j, l, j2);
        k3 = getBottomSelectionPixel(k, l, j1, j2);
        super.mFirstPosition = j2;
        if(i3 > 0) {
            int i5;
            int j5;
            int k5;
            if(mReferenceViewInSelectedRow == null)
                i5 = 0;
            else
                i5 = mReferenceViewInSelectedRow.getBottom();
            if(super.mStackFromBottom)
                j5 = l1;
            else
                j5 = j2;
            k5 = i5 + k1;
            view = makeRow(j5, k5, true);
            view1 = mReferenceView;
            adjustForBottomFadingEdge(view1, j3, k3);
        } else
        if(i3 < 0) {
            int j4;
            int k4;
            int l4;
            if(mReferenceViewInSelectedRow == null)
                j4 = 0;
            else
                j4 = mReferenceViewInSelectedRow.getTop();
            if(super.mStackFromBottom)
                k4 = l1;
            else
                k4 = j2;
            l4 = j4 - k1;
            view = makeRow(k4, l4, false);
            view1 = mReferenceView;
            adjustForTopFadingEdge(view1, j3, k3);
        } else {
            int l3;
            int i4;
            if(mReferenceViewInSelectedRow == null)
                l3 = 0;
            else
                l3 = mReferenceViewInSelectedRow.getTop();
            if(super.mStackFromBottom)
                i4 = l1;
            else
                i4 = j2;
            view = makeRow(i4, l3, true);
            view1 = mReferenceView;
        }
        if(!super.mStackFromBottom) {
            fillUp(j2 - j1, view1.getTop() - k1);
            adjustViewsUpOrDown();
            fillDown(j2 + j1, k1 + view1.getBottom());
        } else {
            fillDown(l1 + j1, k1 + view1.getBottom());
            adjustViewsUpOrDown();
            fillUp(j2 - 1, view1.getTop() - k1);
        }
        return view;
    }

    private void pinToBottom(int i) {
        int j = getChildCount();
        if(j + super.mFirstPosition == super.mItemCount) {
            int k = i - getChildAt(j - 1).getBottom();
            if(k > 0)
                offsetChildrenTopAndBottom(k);
        }
    }

    private void pinToTop(int i) {
        if(super.mFirstPosition == 0) {
            int j = i - getChildAt(0).getTop();
            if(j < 0)
                offsetChildrenTopAndBottom(j);
        }
    }

    private void setupChild(View view, int i, int j, boolean flag, int k, boolean flag1, boolean flag2, 
            int l) {
        int k1;
        int i2;
        int k2;
        boolean flag3;
        boolean flag4;
        int i1;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        AbsListView.LayoutParams layoutparams;
        int j1;
        int l1;
        int j2;
        if(flag1 && shouldShowSelector())
            flag3 = true;
        else
            flag3 = false;
        if(flag3 != view.isSelected())
            flag4 = true;
        else
            flag4 = false;
        i1 = super.mTouchMode;
        if(i1 > 0 && i1 < 3 && super.mMotionPosition == i)
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
        j1 = super.mAdapter.getItemViewType(i);
        layoutparams.viewType = j1;
        if(flag2 && !layoutparams.forceAdd) {
            attachViewToParent(view, l, layoutparams);
        } else {
            layoutparams.forceAdd = false;
            addViewInLayout(view, l, layoutparams, true);
        }
        if(flag4) {
            view.setSelected(flag3);
            if(flag3)
                requestFocus();
        }
        if(flag6)
            view.setPressed(flag5);
        if(super.mChoiceMode != 0 && super.mCheckStates != null)
            if(view instanceof Checkable)
                ((Checkable)view).setChecked(super.mCheckStates.get(i));
            else
            if(getContext().getApplicationInfo().targetSdkVersion >= 11)
                view.setActivated(super.mCheckStates.get(i));
        if(flag7) {
            int l2 = ViewGroup.getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), 0, ((android.view.ViewGroup.LayoutParams) (layoutparams)).height);
            view.measure(ViewGroup.getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(mColumnWidth, 0x40000000), 0, ((android.view.ViewGroup.LayoutParams) (layoutparams)).width), l2);
        } else {
            cleanupLayoutState(view);
        }
        k1 = view.getMeasuredWidth();
        l1 = view.getMeasuredHeight();
        if(flag)
            i2 = j;
        else
            i2 = j - l1;
        j2 = getResolvedLayoutDirection();
        7 & Gravity.getAbsoluteGravity(mGravity, j2);
        JVM INSTR tableswitch 1 5: default 340
    //                   1 507
    //                   2 340
    //                   3 500
    //                   4 340
    //                   5 524;
           goto _L1 _L2 _L1 _L3 _L1 _L4
_L4:
        break MISSING_BLOCK_LABEL_524;
_L1:
        k2 = k;
_L5:
        if(flag7) {
            view.layout(k2, i2, k2 + k1, i2 + l1);
        } else {
            view.offsetLeftAndRight(k2 - view.getLeft());
            view.offsetTopAndBottom(i2 - view.getTop());
        }
        if(super.mCachingStarted)
            view.setDrawingCacheEnabled(true);
        if(flag2 && ((AbsListView.LayoutParams)view.getLayoutParams()).scrappedFromPosition != i)
            view.jumpDrawablesToCurrentState();
        return;
_L3:
        k2 = k;
          goto _L5
_L2:
        k2 = k + (mColumnWidth - k1) / 2;
          goto _L5
        k2 = (k + mColumnWidth) - k1;
          goto _L5
    }

    boolean arrowScroll(int i) {
        int j;
        int k;
        boolean flag;
        int i1;
        int j1;
        j = super.mSelectedPosition;
        k = mNumColumns;
        flag = false;
        if(!super.mStackFromBottom) {
            j1 = k * (j / k);
            i1 = Math.min(-1 + (j1 + k), -1 + super.mItemCount);
        } else {
            int l = (-1 + super.mItemCount) - j;
            i1 = (-1 + super.mItemCount) - k * (l / k);
            j1 = Math.max(0, 1 + (i1 - k));
        }
        i;
        JVM INSTR lookupswitch 4: default 88
    //                   17: 229
    //                   33: 160
    //                   66: 258
    //                   130: 188;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if(flag) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            invokeOnItemScrollListener();
        }
        if(flag)
            awakenScrollBars();
        return flag;
_L3:
        if(j1 > 0) {
            super.mLayoutMode = 6;
            setSelectionInt(Math.max(0, j - k));
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if(i1 < -1 + super.mItemCount) {
            super.mLayoutMode = 6;
            setSelectionInt(Math.min(j + k, -1 + super.mItemCount));
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if(j > j1) {
            super.mLayoutMode = 6;
            setSelectionInt(Math.max(0, j - 1));
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(j < i1) {
            super.mLayoutMode = 6;
            setSelectionInt(Math.min(j + 1, -1 + super.mItemCount));
            flag = true;
        }
        if(true) goto _L1; else goto _L6
_L6:
    }

    protected void attachLayoutAnimationParameters(View view, android.view.ViewGroup.LayoutParams layoutparams, int i, int j) {
        android.view.animation.GridLayoutAnimationController.AnimationParameters animationparameters = (android.view.animation.GridLayoutAnimationController.AnimationParameters)layoutparams.layoutAnimationParameters;
        if(animationparameters == null) {
            animationparameters = new android.view.animation.GridLayoutAnimationController.AnimationParameters();
            layoutparams.layoutAnimationParameters = animationparameters;
        }
        animationparameters.count = j;
        animationparameters.index = i;
        animationparameters.columnsCount = mNumColumns;
        animationparameters.rowsCount = j / mNumColumns;
        if(!super.mStackFromBottom) {
            animationparameters.column = i % mNumColumns;
            animationparameters.row = i / mNumColumns;
        } else {
            int k = j - 1 - i;
            animationparameters.column = (-1 + mNumColumns) - k % mNumColumns;
            animationparameters.row = (-1 + animationparameters.rowsCount) - k / mNumColumns;
        }
    }

    protected int computeVerticalScrollExtent() {
        int i = getChildCount();
        int j;
        if(i > 0) {
            int k = mNumColumns;
            j = 100 * ((-1 + (i + k)) / k);
            View view = getChildAt(0);
            int l = view.getTop();
            int i1 = view.getHeight();
            if(i1 > 0)
                j += (l * 100) / i1;
            View view1 = getChildAt(i - 1);
            int j1 = view1.getBottom();
            int k1 = view1.getHeight();
            if(k1 > 0)
                j -= (100 * (j1 - getHeight())) / k1;
        } else {
            j = 0;
        }
        return j;
    }

    protected int computeVerticalScrollOffset() {
        int i = 0;
        if(super.mFirstPosition >= 0 && getChildCount() > 0) {
            View view = getChildAt(0);
            int j = view.getTop();
            int k = view.getHeight();
            if(k > 0) {
                int l = mNumColumns;
                int i1 = super.mFirstPosition / l;
                int j1 = (-1 + (l + super.mItemCount)) / l;
                i = Math.max((i1 * 100 - (j * 100) / k) + (int)(100F * (((float)super.mScrollY / (float)getHeight()) * (float)j1)), 0);
            }
        }
        return i;
    }

    protected int computeVerticalScrollRange() {
        int i = mNumColumns;
        int j = (-1 + (i + super.mItemCount)) / i;
        int k = Math.max(j * 100, 0);
        if(super.mScrollY != 0)
            k += Math.abs((int)(100F * (((float)super.mScrollY / (float)getHeight()) * (float)j)));
        return k;
    }

    void fillGap(boolean flag) {
        int i = mNumColumns;
        int j = mVerticalSpacing;
        int k = getChildCount();
        if(flag) {
            int l1 = 0;
            if((0x22 & super.mGroupFlags) == 34)
                l1 = getListPaddingTop();
            int i2;
            int j2;
            if(k > 0)
                i2 = j + getChildAt(k - 1).getBottom();
            else
                i2 = l1;
            j2 = k + super.mFirstPosition;
            if(super.mStackFromBottom)
                j2 += i - 1;
            fillDown(j2, i2);
            correctTooHigh(i, j, getChildCount());
        } else {
            int l = 0;
            if((0x22 & super.mGroupFlags) == 34)
                l = getListPaddingBottom();
            int i1;
            int j1;
            int k1;
            if(k > 0)
                i1 = getChildAt(0).getTop() - j;
            else
                i1 = getHeight() - l;
            j1 = super.mFirstPosition;
            if(!super.mStackFromBottom)
                k1 = j1 - i;
            else
                k1 = j1 - 1;
            fillUp(k1, i1);
            correctTooLow(i, j, getChildCount());
        }
    }

    int findMotionRow(int i) {
        int j;
        int l;
        j = getChildCount();
        if(j <= 0)
            break MISSING_BLOCK_LABEL_108;
        l = mNumColumns;
        if(super.mStackFromBottom) goto _L2; else goto _L1
_L1:
        int j1 = 0;
_L5:
        if(j1 >= j)
            break MISSING_BLOCK_LABEL_108;
        if(i > getChildAt(j1).getBottom()) goto _L4; else goto _L3
_L3:
        int k = j1 + super.mFirstPosition;
_L6:
        return k;
_L4:
        j1 += l;
          goto _L5
_L2:
        int i1 = j - 1;
_L7:
label0:
        {
            if(i1 < 0)
                break MISSING_BLOCK_LABEL_108;
            if(i < getChildAt(i1).getTop())
                break label0;
            k = i1 + super.mFirstPosition;
        }
          goto _L6
        i1 -= l;
          goto _L7
        k = -1;
          goto _L6
    }

    boolean fullScroll(int i) {
        boolean flag = false;
        if(i != 33) goto _L2; else goto _L1
_L1:
        super.mLayoutMode = 2;
        setSelectionInt(0);
        invokeOnItemScrollListener();
        flag = true;
_L4:
        if(flag)
            awakenScrollBars();
        return flag;
_L2:
        if(i == 130) {
            super.mLayoutMode = 2;
            setSelectionInt(-1 + super.mItemCount);
            invokeOnItemScrollListener();
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

    public int getColumnWidth() {
        return mColumnWidth;
    }

    public int getGravity() {
        return mGravity;
    }

    public int getHorizontalSpacing() {
        return mHorizontalSpacing;
    }

    public int getNumColumns() {
        return mNumColumns;
    }

    public int getRequestedColumnWidth() {
        return mRequestedColumnWidth;
    }

    public int getRequestedHorizontalSpacing() {
        return mRequestedHorizontalSpacing;
    }

    public int getStretchMode() {
        return mStretchMode;
    }

    public int getVerticalSpacing() {
        return mVerticalSpacing;
    }

    protected void layoutChildren() {
        boolean flag;
        flag = super.mBlockLayoutRequests;
        if(!flag)
            super.mBlockLayoutRequests = true;
        super.layoutChildren();
        invalidate();
        if(super.mAdapter != null) goto _L2; else goto _L1
_L1:
        resetList();
        invokeOnItemScrollListener();
        if(flag) goto _L4; else goto _L3
_L3:
        super.mBlockLayoutRequests = false;
_L4:
        return;
_L2:
        int i;
        int j;
        int k;
        int l;
        View view;
        View view1;
        View view2;
        i = super.mListPadding.top;
        j = super.mBottom - super.mTop - super.mListPadding.bottom;
        k = getChildCount();
        l = 0;
        view = null;
        view1 = null;
        view2 = null;
        super.mLayoutMode;
        JVM INSTR tableswitch 1 6: default 136
    //                   1 174
    //                   2 211
    //                   3 174
    //                   4 174
    //                   5 174
    //                   6 245;
           goto _L5 _L6 _L7 _L6 _L6 _L6 _L8
_L8:
        break MISSING_BLOCK_LABEL_245;
_L6:
        break; /* Loop/switch isn't completed */
_L5:
        int l2 = super.mSelectedPosition - super.mFirstPosition;
        if(l2 >= 0 && l2 < k)
            view = getChildAt(l2);
        view1 = getChildAt(0);
_L9:
        boolean flag1;
        flag1 = super.mDataChanged;
        if(flag1)
            handleDataChanged();
        if(super.mItemCount != 0)
            break MISSING_BLOCK_LABEL_266;
        resetList();
        invokeOnItemScrollListener();
        if(!flag)
            break; /* Loop/switch isn't completed */
          goto _L4
_L7:
        int k2 = super.mNextSelectedPosition - super.mFirstPosition;
        if(k2 >= 0 && k2 < k)
            view2 = getChildAt(k2);
          goto _L9
        if(super.mNextSelectedPosition >= 0)
            l = super.mNextSelectedPosition - super.mSelectedPosition;
          goto _L9
        AbsListView.RecycleBin recyclebin;
        setSelectedPositionInt(super.mNextSelectedPosition);
        int i1 = super.mFirstPosition;
        recyclebin = super.mRecycler;
        if(flag1) {
            for(int j2 = 0; j2 < k; j2++)
                recyclebin.addScrapView(getChildAt(j2), i1 + j2);

        } else {
            recyclebin.fillActiveViews(k, i1);
        }
        detachAllViewsFromParent();
        recyclebin.removeSkippedScrap();
        super.mLayoutMode;
        JVM INSTR tableswitch 1 6: default 384
    //                   1 557
    //                   2 523
    //                   3 588
    //                   4 610
    //                   5 627
    //                   6 644;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L10:
        if(k != 0) goto _L18; else goto _L17
_L17:
        if(super.mStackFromBottom) goto _L20; else goto _L19
_L19:
        Exception exception;
        View view3;
        int l1;
        int i2;
        byte byte0;
        if(super.mAdapter == null || isInTouchMode())
            byte0 = -1;
        else
            byte0 = 0;
        setSelectedPositionInt(byte0);
        view3 = fillFromTop(i);
_L21:
        recyclebin.scrapActiveViews();
        if(view3 == null)
            break MISSING_BLOCK_LABEL_807;
        positionSelector(-1, view3);
        super.mSelectedTop = view3.getTop();
_L22:
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
        if(flag) goto _L4; else goto _L3
_L12:
        if(view2 != null)
            view3 = fillFromSelection(view2.getTop(), i, j);
        else
            view3 = fillSelection(i, j);
          goto _L21
_L11:
        super.mFirstPosition = 0;
        view3 = fillFromTop(i);
        adjustViewsUpOrDown();
          goto _L21
        exception;
        if(!flag)
            super.mBlockLayoutRequests = false;
        throw exception;
_L13:
        view3 = fillUp(-1 + super.mItemCount, j);
        adjustViewsUpOrDown();
          goto _L21
_L14:
        view3 = fillSpecific(super.mSelectedPosition, super.mSpecificTop);
          goto _L21
_L15:
        view3 = fillSpecific(super.mSyncPosition, super.mSpecificTop);
          goto _L21
_L16:
        view3 = moveSelection(l, i, j);
          goto _L21
_L20:
        l1 = -1 + super.mItemCount;
        if(super.mAdapter == null || isInTouchMode())
            i2 = -1;
        else
            i2 = l1;
        setSelectedPositionInt(i2);
        view3 = fillFromBottom(l1, j);
          goto _L21
_L18:
        if(super.mSelectedPosition >= 0 && super.mSelectedPosition < super.mItemCount) {
            int k1 = super.mSelectedPosition;
            if(view != null)
                i = view.getTop();
            view3 = fillSpecific(k1, i);
        } else
        if(super.mFirstPosition < super.mItemCount) {
            int j1 = super.mFirstPosition;
            if(view1 != null)
                i = view1.getTop();
            view3 = fillSpecific(j1, i);
        } else {
            view3 = fillSpecific(0, i);
        }
          goto _L21
        if(super.mTouchMode > 0 && super.mTouchMode < 3) {
            View view4 = getChildAt(super.mMotionPosition - super.mFirstPosition);
            if(view4 != null)
                positionSelector(super.mMotionPosition, view4);
        } else {
            super.mSelectedTop = 0;
            super.mSelectorRect.setEmpty();
        }
          goto _L22
    }

    int lookForSelectablePosition(int i, boolean flag) {
        if(super.mAdapter != null && !isInTouchMode()) goto _L2; else goto _L1
_L1:
        i = -1;
_L4:
        return i;
_L2:
        if(i < 0 || i >= super.mItemCount)
            i = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect) {
        super.onFocusChanged(flag, i, rect);
        int j = -1;
        if(flag && rect != null) {
            rect.offset(super.mScrollX, super.mScrollY);
            Rect rect1 = mTempRect;
            int k = 0x7fffffff;
            int l = getChildCount();
            int i1 = 0;
            while(i1 < l)  {
                if(isCandidateSelection(i1, i)) {
                    View view = getChildAt(i1);
                    view.getDrawingRect(rect1);
                    offsetDescendantRectToMyCoords(view, rect1);
                    int j1 = getDistance(rect, rect1, i);
                    if(j1 < k) {
                        k = j1;
                        j = i1;
                    }
                }
                i1++;
            }
        }
        if(j >= 0)
            setSelection(j + super.mFirstPosition);
        else
            requestLayout();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/GridView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/GridView.getName());
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
        int k2;
        int l2;
        super.onMeasure(i, j);
        int k = android.view.View.MeasureSpec.getMode(i);
        int l = android.view.View.MeasureSpec.getMode(j);
        int i1 = android.view.View.MeasureSpec.getSize(i);
        int j1 = android.view.View.MeasureSpec.getSize(j);
        int l1;
        if(k == 0) {
            boolean flag;
            int k1;
            int i2;
            int j2;
            View view;
            AbsListView.LayoutParams layoutparams;
            int i3;
            int j3;
            int k3;
            if(mColumnWidth > 0)
                k3 = mColumnWidth + super.mListPadding.left + super.mListPadding.right;
            else
                k3 = super.mListPadding.left + super.mListPadding.right;
            i1 = k3 + getVerticalScrollbarWidth();
        }
        flag = determineColumns(i1 - super.mListPadding.left - super.mListPadding.right);
        k1 = 0;
        if(super.mAdapter == null)
            l1 = 0;
        else
            l1 = super.mAdapter.getCount();
        super.mItemCount = l1;
        i2 = super.mItemCount;
        if(i2 > 0) {
            view = obtainView(0, super.mIsScrap);
            layoutparams = (AbsListView.LayoutParams)view.getLayoutParams();
            if(layoutparams == null) {
                layoutparams = (AbsListView.LayoutParams)generateDefaultLayoutParams();
                view.setLayoutParams(layoutparams);
            }
            i3 = super.mAdapter.getItemViewType(0);
            layoutparams.viewType = i3;
            layoutparams.forceAdd = true;
            j3 = getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), 0, ((android.view.ViewGroup.LayoutParams) (layoutparams)).height);
            view.measure(getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(mColumnWidth, 0x40000000), 0, ((android.view.ViewGroup.LayoutParams) (layoutparams)).width), j3);
            k1 = view.getMeasuredHeight();
            combineMeasuredStates(0, view.getMeasuredState());
            if(super.mRecycler.shouldRecycleViewType(layoutparams.viewType))
                super.mRecycler.addScrapView(view, -1);
        }
        if(l == 0)
            j1 = k1 + (super.mListPadding.top + super.mListPadding.bottom) + 2 * getVerticalFadingEdgeLength();
        if(l != 0x80000000) goto _L2; else goto _L1
_L1:
        j2 = super.mListPadding.top + super.mListPadding.bottom;
        k2 = mNumColumns;
        l2 = 0;
_L8:
        if(l2 >= i2) goto _L4; else goto _L3
_L3:
        j2 += k1;
        if(l2 + k2 < i2)
            j2 += mVerticalSpacing;
        if(j2 < j1) goto _L6; else goto _L5
_L5:
        j2 = j1;
_L4:
        j1 = j2;
_L2:
        if(k == 0x80000000 && mRequestedNumColumns != -1 && (mRequestedNumColumns * mColumnWidth + (-1 + mRequestedNumColumns) * mHorizontalSpacing + super.mListPadding.left + super.mListPadding.right > i1 || flag))
            i1 |= 0x1000000;
        setMeasuredDimension(i1, j1);
        super.mWidthMeasureSpec = i;
        return;
_L6:
        l2 += k2;
        if(true) goto _L8; else goto _L7
_L7:
    }

    boolean pageScroll(int i) {
        boolean flag;
        int j;
        flag = false;
        j = -1;
        if(i != 33) goto _L2; else goto _L1
_L1:
        j = Math.max(0, super.mSelectedPosition - getChildCount());
_L4:
        if(j >= 0) {
            setSelectionInt(j);
            invokeOnItemScrollListener();
            awakenScrollBars();
            flag = true;
        }
        return flag;
_L2:
        if(i == 130)
            j = Math.min(-1 + super.mItemCount, super.mSelectedPosition + getChildCount());
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean sequenceScroll(int i) {
        int j;
        int l;
        int j1;
        int k1;
        boolean flag;
        boolean flag1;
        j = super.mSelectedPosition;
        int k = mNumColumns;
        l = super.mItemCount;
        if(!super.mStackFromBottom) {
            k1 = k * (j / k);
            j1 = Math.min(-1 + (k1 + k), l - 1);
        } else {
            int i1 = l - 1 - j;
            j1 = l - 1 - k * (i1 / k);
            k1 = Math.max(0, 1 + (j1 - k));
        }
        flag = false;
        flag1 = false;
        i;
        JVM INSTR tableswitch 1 2: default 76
    //                   1 184
    //                   2 142;
           goto _L1 _L2 _L3
_L1:
        if(flag) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            invokeOnItemScrollListener();
        }
        if(flag1)
            awakenScrollBars();
        return flag;
_L3:
        if(j < l - 1) {
            super.mLayoutMode = 6;
            setSelectionInt(j + 1);
            flag = true;
            if(j == j1)
                flag1 = true;
            else
                flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if(j > 0) {
            super.mLayoutMode = 6;
            setSelectionInt(j - 1);
            flag = true;
            if(j == k1)
                flag1 = true;
            else
                flag1 = false;
        }
        if(true) goto _L1; else goto _L4
_L4:
    }

    public volatile void setAdapter(Adapter adapter) {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter) {
        if(super.mAdapter != null && super.mDataSetObserver != null)
            super.mAdapter.unregisterDataSetObserver(super.mDataSetObserver);
        resetList();
        super.mRecycler.clear();
        super.mAdapter = listadapter;
        super.mOldSelectedPosition = -1;
        super.mOldSelectedRowId = 0x8000000000000000L;
        super.setAdapter(listadapter);
        if(super.mAdapter != null) {
            super.mOldItemCount = super.mItemCount;
            super.mItemCount = super.mAdapter.getCount();
            super.mDataChanged = true;
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
            checkSelectionChanged();
        } else {
            checkFocus();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setColumnWidth(int i) {
        if(i != mRequestedColumnWidth) {
            mRequestedColumnWidth = i;
            requestLayoutIfNecessary();
        }
    }

    public void setGravity(int i) {
        if(mGravity != i) {
            mGravity = i;
            requestLayoutIfNecessary();
        }
    }

    public void setHorizontalSpacing(int i) {
        if(i != mRequestedHorizontalSpacing) {
            mRequestedHorizontalSpacing = i;
            requestLayoutIfNecessary();
        }
    }

    public void setNumColumns(int i) {
        if(i != mRequestedNumColumns) {
            mRequestedNumColumns = i;
            requestLayoutIfNecessary();
        }
    }

    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
    }

    public void setSelection(int i) {
        if(!isInTouchMode())
            setNextSelectedPositionInt(i);
        else
            super.mResurrectToPosition = i;
        super.mLayoutMode = 2;
        if(super.mPositionScroller != null)
            super.mPositionScroller.stop();
        requestLayout();
    }

    void setSelectionInt(int i) {
        int j = super.mNextSelectedPosition;
        if(super.mPositionScroller != null)
            super.mPositionScroller.stop();
        setNextSelectedPositionInt(i);
        layoutChildren();
        int k;
        int l;
        if(super.mStackFromBottom)
            k = (-1 + super.mItemCount) - super.mNextSelectedPosition;
        else
            k = super.mNextSelectedPosition;
        if(super.mStackFromBottom)
            l = (-1 + super.mItemCount) - j;
        else
            l = j;
        if(k / mNumColumns != l / mNumColumns)
            awakenScrollBars();
    }

    public void setStretchMode(int i) {
        if(i != mStretchMode) {
            mStretchMode = i;
            requestLayoutIfNecessary();
        }
    }

    public void setVerticalSpacing(int i) {
        if(i != mVerticalSpacing) {
            mVerticalSpacing = i;
            requestLayoutIfNecessary();
        }
    }

    public void smoothScrollByOffset(int i) {
        super.smoothScrollByOffset(i);
    }

    public void smoothScrollToPosition(int i) {
        super.smoothScrollToPosition(i);
    }

    public static final int AUTO_FIT = -1;
    public static final int NO_STRETCH = 0;
    public static final int STRETCH_COLUMN_WIDTH = 2;
    public static final int STRETCH_SPACING = 1;
    public static final int STRETCH_SPACING_UNIFORM = 3;
    private int mColumnWidth;
    private int mGravity;
    private int mHorizontalSpacing;
    private int mNumColumns;
    private View mReferenceView;
    private View mReferenceViewInSelectedRow;
    private int mRequestedColumnWidth;
    private int mRequestedHorizontalSpacing;
    private int mRequestedNumColumns;
    private int mStretchMode;
    private final Rect mTempRect;
    private int mVerticalSpacing;
}
