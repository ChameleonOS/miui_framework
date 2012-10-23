// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            AdapterView, ArrayAdapter, SpinnerAdapter, Adapter

public abstract class AbsSpinner extends AdapterView {
    class RecycleBin {

        void clear() {
            SparseArray sparsearray = mScrapHeap;
            int i = sparsearray.size();
            for(int j = 0; j < i; j++) {
                View view = (View)sparsearray.valueAt(j);
                if(view != null)
                    removeDetachedView(view, true);
            }

            sparsearray.clear();
        }

        View get(int i) {
            View view = (View)mScrapHeap.get(i);
            if(view != null)
                mScrapHeap.delete(i);
            return view;
        }

        public void put(int i, View view) {
            mScrapHeap.put(i, view);
        }

        private final SparseArray mScrapHeap = new SparseArray();
        final AbsSpinner this$0;

        RecycleBin() {
            this$0 = AbsSpinner.this;
            super();
        }
    }

    static class SavedState extends android.view.View.BaseSavedState {

        public String toString() {
            return (new StringBuilder()).append("AbsSpinner.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" selectedId=").append(selectedId).append(" position=").append(position).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(selectedId);
            parcel.writeInt(position);
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
        int position;
        long selectedId;


        private SavedState(Parcel parcel) {
            super(parcel);
            selectedId = parcel.readLong();
            position = parcel.readInt();
        }


        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }


    public AbsSpinner(Context context) {
        super(context);
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mSpinnerPadding = new Rect();
        mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    public AbsSpinner(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public AbsSpinner(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mSpinnerPadding = new Rect();
        mRecycler = new RecycleBin();
        initAbsSpinner();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.AbsSpinner, i, 0);
        CharSequence acharsequence[] = typedarray.getTextArray(0);
        if(acharsequence != null) {
            ArrayAdapter arrayadapter = new ArrayAdapter(context, 0x1090008, acharsequence);
            arrayadapter.setDropDownViewResource(0x1090009);
            setAdapter(arrayadapter);
        }
        typedarray.recycle();
    }

    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new android.view.ViewGroup.LayoutParams(-1, -2);
    }

    public volatile Adapter getAdapter() {
        return getAdapter();
    }

    public SpinnerAdapter getAdapter() {
        return mAdapter;
    }

    int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    int getChildWidth(View view) {
        return view.getMeasuredWidth();
    }

    public int getCount() {
        return super.mItemCount;
    }

    public View getSelectedView() {
        View view;
        if(super.mItemCount > 0 && super.mSelectedPosition >= 0)
            view = getChildAt(super.mSelectedPosition - super.mFirstPosition);
        else
            view = null;
        return view;
    }

    abstract void layout(int i, boolean flag);

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/AbsSpinner.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/AbsSpinner.getName());
    }

    protected void onMeasure(int i, int j) {
        int k = android.view.View.MeasureSpec.getMode(i);
        Rect rect = mSpinnerPadding;
        int l;
        Rect rect1;
        int i1;
        Rect rect2;
        int j1;
        Rect rect3;
        int k1;
        int l1;
        int i2;
        boolean flag;
        int j2;
        int k2;
        int l2;
        int i3;
        if(super.mPaddingLeft > mSelectionLeftPadding)
            l = super.mPaddingLeft;
        else
            l = mSelectionLeftPadding;
        rect.left = l;
        rect1 = mSpinnerPadding;
        if(super.mPaddingTop > mSelectionTopPadding)
            i1 = super.mPaddingTop;
        else
            i1 = mSelectionTopPadding;
        rect1.top = i1;
        rect2 = mSpinnerPadding;
        if(super.mPaddingRight > mSelectionRightPadding)
            j1 = super.mPaddingRight;
        else
            j1 = mSelectionRightPadding;
        rect2.right = j1;
        rect3 = mSpinnerPadding;
        if(super.mPaddingBottom > mSelectionBottomPadding)
            k1 = super.mPaddingBottom;
        else
            k1 = mSelectionBottomPadding;
        rect3.bottom = k1;
        if(super.mDataChanged)
            handleDataChanged();
        l1 = 0;
        i2 = 0;
        flag = true;
        j2 = getSelectedItemPosition();
        if(j2 >= 0 && mAdapter != null && j2 < mAdapter.getCount()) {
            View view = mRecycler.get(j2);
            if(view == null) {
                view = mAdapter.getView(j2, null, this);
                if(view.getImportantForAccessibility() == 0)
                    view.setImportantForAccessibility(1);
            }
            if(view != null)
                mRecycler.put(j2, view);
            if(view != null) {
                if(view.getLayoutParams() == null) {
                    super.mBlockLayoutRequests = true;
                    view.setLayoutParams(generateDefaultLayoutParams());
                    super.mBlockLayoutRequests = false;
                }
                measureChild(view, i, j);
                l1 = getChildHeight(view) + mSpinnerPadding.top + mSpinnerPadding.bottom;
                i2 = getChildWidth(view) + mSpinnerPadding.left + mSpinnerPadding.right;
                flag = false;
            }
        }
        if(flag) {
            l1 = mSpinnerPadding.top + mSpinnerPadding.bottom;
            if(k == 0)
                i2 = mSpinnerPadding.left + mSpinnerPadding.right;
        }
        k2 = Math.max(l1, getSuggestedMinimumHeight());
        l2 = Math.max(i2, getSuggestedMinimumWidth());
        i3 = resolveSizeAndState(k2, j, 0);
        setMeasuredDimension(resolveSizeAndState(l2, i, 0), i3);
        mHeightMeasureSpec = j;
        mWidthMeasureSpec = i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if(savedstate.selectedId >= 0L) {
            super.mDataChanged = true;
            super.mNeedSync = true;
            super.mSyncRowId = savedstate.selectedId;
            super.mSyncPosition = savedstate.position;
            super.mSyncMode = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.selectedId = getSelectedItemId();
        if(savedstate.selectedId >= 0L)
            savedstate.position = getSelectedItemPosition();
        else
            savedstate.position = -1;
        return savedstate;
    }

    public int pointToPosition(int i, int j) {
        Rect rect;
        int k;
        rect = mTouchFrame;
        if(rect == null) {
            mTouchFrame = new Rect();
            rect = mTouchFrame;
        }
        k = -1 + getChildCount();
_L3:
        if(k < 0) goto _L2; else goto _L1
_L1:
        int l;
        View view = getChildAt(k);
        if(view.getVisibility() != 0)
            continue; /* Loop/switch isn't completed */
        view.getHitRect(rect);
        if(!rect.contains(i, j))
            continue; /* Loop/switch isn't completed */
        l = k + super.mFirstPosition;
_L4:
        return l;
        k--;
          goto _L3
_L2:
        l = -1;
          goto _L4
    }

    void recycleAllViews() {
        int i = getChildCount();
        RecycleBin recyclebin = mRecycler;
        int j = super.mFirstPosition;
        for(int k = 0; k < i; k++) {
            View view = getChildAt(k);
            recyclebin.put(j + k, view);
        }

    }

    public void requestLayout() {
        if(!super.mBlockLayoutRequests)
            super.requestLayout();
    }

    void resetList() {
        super.mDataChanged = false;
        super.mNeedSync = false;
        removeAllViewsInLayout();
        super.mOldSelectedPosition = -1;
        super.mOldSelectedRowId = 0x8000000000000000L;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    public volatile void setAdapter(Adapter adapter) {
        setAdapter((SpinnerAdapter)adapter);
    }

    public void setAdapter(SpinnerAdapter spinneradapter) {
        int i = -1;
        if(mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            resetList();
        }
        mAdapter = spinneradapter;
        super.mOldSelectedPosition = i;
        super.mOldSelectedRowId = 0x8000000000000000L;
        if(mAdapter != null) {
            super.mOldItemCount = super.mItemCount;
            super.mItemCount = mAdapter.getCount();
            checkFocus();
            mDataSetObserver = new AdapterView.AdapterDataSetObserver(this);
            mAdapter.registerDataSetObserver(mDataSetObserver);
            if(super.mItemCount > 0)
                i = 0;
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if(super.mItemCount == 0)
                checkSelectionChanged();
        } else {
            checkFocus();
            resetList();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    public void setSelection(int i, boolean flag) {
        boolean flag1;
        if(flag && super.mFirstPosition <= i && i <= -1 + (super.mFirstPosition + getChildCount()))
            flag1 = true;
        else
            flag1 = false;
        setSelectionInt(i, flag1);
    }

    void setSelectionInt(int i, boolean flag) {
        if(i != super.mOldSelectedPosition) {
            super.mBlockLayoutRequests = true;
            int j = i - super.mSelectedPosition;
            setNextSelectedPositionInt(i);
            layout(j, flag);
            super.mBlockLayoutRequests = false;
        }
    }

    SpinnerAdapter mAdapter;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    final RecycleBin mRecycler;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    final Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

}
