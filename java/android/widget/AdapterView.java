// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.*;

// Referenced classes of package android.widget:
//            Adapter

public abstract class AdapterView extends ViewGroup {
    private class SelectionNotifier
        implements Runnable {

        public void run() {
            if(mDataChanged) {
                if(getAdapter() != null)
                    post(this);
            } else {
                fireOnSelected();
                performAccessibilityActionsOnSelected();
            }
        }

        final AdapterView this$0;

        private SelectionNotifier() {
            this$0 = AdapterView.this;
            super();
        }

    }

    class AdapterDataSetObserver extends DataSetObserver {

        public void clearSavedState() {
            mInstanceState = null;
        }

        public void onChanged() {
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = getAdapter().getCount();
            if(getAdapter().hasStableIds() && mInstanceState != null && mOldItemCount == 0 && mItemCount > 0) {
                onRestoreInstanceState(mInstanceState);
                mInstanceState = null;
            } else {
                rememberSyncState();
            }
            checkFocus();
            requestLayout();
        }

        public void onInvalidated() {
            mDataChanged = true;
            if(getAdapter().hasStableIds())
                mInstanceState = onSaveInstanceState();
            mOldItemCount = mItemCount;
            mItemCount = 0;
            mSelectedPosition = -1;
            mSelectedRowId = 0x8000000000000000L;
            mNextSelectedPosition = -1;
            mNextSelectedRowId = 0x8000000000000000L;
            mNeedSync = false;
            checkFocus();
            requestLayout();
        }

        private Parcelable mInstanceState;
        final AdapterView this$0;

        AdapterDataSetObserver() {
            this$0 = AdapterView.this;
            super();
            mInstanceState = null;
        }
    }

    public static class AdapterContextMenuInfo
        implements android.view.ContextMenu.ContextMenuInfo {

        public long id;
        public int position;
        public View targetView;

        public AdapterContextMenuInfo(View view, int i, long l) {
            targetView = view;
            position = i;
            id = l;
        }
    }

    public static interface OnItemSelectedListener {

        public abstract void onItemSelected(AdapterView adapterview, View view, int i, long l);

        public abstract void onNothingSelected(AdapterView adapterview);
    }

    public static interface OnItemLongClickListener {

        public abstract boolean onItemLongClick(AdapterView adapterview, View view, int i, long l);
    }

    public static interface OnItemClickListener {

        public abstract void onItemClick(AdapterView adapterview, View view, int i, long l);
    }


    public AdapterView(Context context) {
        super(context);
        mFirstPosition = 0;
        mSyncRowId = 0x8000000000000000L;
        mNeedSync = false;
        mInLayout = false;
        mNextSelectedPosition = -1;
        mNextSelectedRowId = 0x8000000000000000L;
        mSelectedPosition = -1;
        mSelectedRowId = 0x8000000000000000L;
        mOldSelectedPosition = -1;
        mOldSelectedRowId = 0x8000000000000000L;
        mBlockLayoutRequests = false;
    }

    public AdapterView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mFirstPosition = 0;
        mSyncRowId = 0x8000000000000000L;
        mNeedSync = false;
        mInLayout = false;
        mNextSelectedPosition = -1;
        mNextSelectedRowId = 0x8000000000000000L;
        mSelectedPosition = -1;
        mSelectedRowId = 0x8000000000000000L;
        mOldSelectedPosition = -1;
        mOldSelectedRowId = 0x8000000000000000L;
        mBlockLayoutRequests = false;
    }

    public AdapterView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mFirstPosition = 0;
        mSyncRowId = 0x8000000000000000L;
        mNeedSync = false;
        mInLayout = false;
        mNextSelectedPosition = -1;
        mNextSelectedRowId = 0x8000000000000000L;
        mSelectedPosition = -1;
        mSelectedRowId = 0x8000000000000000L;
        mOldSelectedPosition = -1;
        mOldSelectedRowId = 0x8000000000000000L;
        mBlockLayoutRequests = false;
        if(getImportantForAccessibility() == 0)
            setImportantForAccessibility(1);
    }

    private void fireOnSelected() {
        if(mOnItemSelectedListener != null) {
            int i = getSelectedItemPosition();
            if(i >= 0) {
                View view = getSelectedView();
                mOnItemSelectedListener.onItemSelected(this, view, i, getAdapter().getItemId(i));
            } else {
                mOnItemSelectedListener.onNothingSelected(this);
            }
        }
    }

    private boolean isScrollableForAccessibility() {
        boolean flag = false;
        Adapter adapter = getAdapter();
        if(adapter != null) {
            int i = adapter.getCount();
            if(i > 0 && (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < i - 1))
                flag = true;
        }
        return flag;
    }

    private void performAccessibilityActionsOnSelected() {
        if(AccessibilityManager.getInstance(super.mContext).isEnabled() && getSelectedItemPosition() >= 0)
            sendAccessibilityEvent(4);
    }

    private void updateEmptyStatus(boolean flag) {
        if(isInFilterMode())
            flag = false;
        if(flag) {
            if(mEmptyView != null) {
                mEmptyView.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if(mDataChanged)
                onLayout(false, super.mLeft, super.mTop, super.mRight, super.mBottom);
        } else {
            if(mEmptyView != null)
                mEmptyView.setVisibility(8);
            setVisibility(0);
        }
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    protected boolean canAnimate() {
        boolean flag;
        if(super.canAnimate() && mItemCount > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    void checkFocus() {
        boolean flag = false;
        Adapter adapter = getAdapter();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if(adapter == null || adapter.getCount() == 0)
            flag1 = true;
        else
            flag1 = false;
        if(!flag1 || isInFilterMode())
            flag2 = true;
        else
            flag2 = false;
        if(flag2 && mDesiredFocusableInTouchModeState)
            flag3 = true;
        else
            flag3 = false;
        super.setFocusableInTouchMode(flag3);
        if(flag2 && mDesiredFocusableState)
            flag4 = true;
        else
            flag4 = false;
        super.setFocusable(flag4);
        if(mEmptyView != null) {
            if(adapter == null || adapter.isEmpty())
                flag = true;
            updateEmptyStatus(flag);
        }
    }

    void checkSelectionChanged() {
        if(mSelectedPosition != mOldSelectedPosition || mSelectedRowId != mOldSelectedRowId) {
            selectionChanged();
            mOldSelectedPosition = mSelectedPosition;
            mOldSelectedRowId = mSelectedRowId;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        View view = getSelectedView();
        boolean flag;
        if(view != null && view.getVisibility() == 0 && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray) {
        dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray) {
        dispatchFreezeSelfOnly(sparsearray);
    }

    int findSyncPosition() {
        int i = mItemCount;
        if(i != 0) goto _L2; else goto _L1
_L1:
        int i1 = -1;
_L8:
        return i1;
_L2:
        long l;
        long l1;
        int j1;
        int k1;
        boolean flag;
        Adapter adapter;
        boolean flag1;
        boolean flag2;
        l = mSyncRowId;
        int j = mSyncPosition;
        if(l == 0x8000000000000000L) {
            i1 = -1;
            continue; /* Loop/switch isn't completed */
        }
        int k = Math.max(0, j);
        i1 = Math.min(i - 1, k);
        l1 = 100L + SystemClock.uptimeMillis();
        j1 = i1;
        k1 = i1;
        flag = false;
        adapter = getAdapter();
        if(adapter == null) {
            i1 = -1;
            continue; /* Loop/switch isn't completed */
        }
_L6:
        if(SystemClock.uptimeMillis() > l1)
            break; /* Loop/switch isn't completed */
        if(adapter.getItemId(i1) == l)
            continue; /* Loop/switch isn't completed */
        if(k1 == i - 1)
            flag1 = true;
        else
            flag1 = false;
        if(j1 == 0)
            flag2 = true;
        else
            flag2 = false;
        if(!flag1 || !flag2) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        if(flag2 || flag && !flag1) {
            i1 = ++k1;
            flag = false;
        } else
        if(flag1 || !flag && !flag2) {
            i1 = --j1;
            flag = true;
        }
        if(true) goto _L6; else goto _L5
_L5:
        i1 = -1;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public abstract Adapter getAdapter();

    public int getCount() {
        return mItemCount;
    }

    public View getEmptyView() {
        return mEmptyView;
    }

    public int getFirstVisiblePosition() {
        return mFirstPosition;
    }

    public Object getItemAtPosition(int i) {
        Adapter adapter = getAdapter();
        Object obj;
        if(adapter == null || i < 0)
            obj = null;
        else
            obj = adapter.getItem(i);
        return obj;
    }

    public long getItemIdAtPosition(int i) {
        Adapter adapter = getAdapter();
        long l;
        if(adapter == null || i < 0)
            l = 0x8000000000000000L;
        else
            l = adapter.getItemId(i);
        return l;
    }

    public int getLastVisiblePosition() {
        return -1 + (mFirstPosition + getChildCount());
    }

    public final OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return mOnItemSelectedListener;
    }

    public int getPositionForView(View view) {
        int i;
        View view1;
        i = -1;
        view1 = view;
_L2:
        View view2;
        boolean flag;
        view2 = (View)view1.getParent();
        flag = view2.equals(this);
        if(flag)
            break; /* Loop/switch isn't completed */
        view1 = view2;
        if(true) goto _L2; else goto _L1
        ClassCastException classcastexception;
        classcastexception;
_L4:
        return i;
_L1:
        int j = getChildCount();
        int k = 0;
        do {
            if(k < j) {
label0:
                {
                    if(!getChildAt(k).equals(view1))
                        break label0;
                    i = k + mFirstPosition;
                }
            }
            if(true)
                continue;
            k++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int i = getSelectedItemPosition();
        Object obj;
        if(adapter != null && adapter.getCount() > 0 && i >= 0)
            obj = adapter.getItem(i);
        else
            obj = null;
        return obj;
    }

    public long getSelectedItemId() {
        return mNextSelectedRowId;
    }

    public int getSelectedItemPosition() {
        return mNextSelectedPosition;
    }

    public abstract View getSelectedView();

    void handleDataChanged() {
        int i = mItemCount;
        boolean flag = false;
        if(i > 0) {
            if(mNeedSync) {
                mNeedSync = false;
                int l = findSyncPosition();
                if(l >= 0 && lookForSelectablePosition(l, true) == l) {
                    setNextSelectedPositionInt(l);
                    flag = true;
                }
            }
            if(!flag) {
                int j = getSelectedItemPosition();
                if(j >= i)
                    j = i - 1;
                if(j < 0)
                    j = 0;
                int k = lookForSelectablePosition(j, true);
                if(k < 0)
                    k = lookForSelectablePosition(j, false);
                if(k >= 0) {
                    setNextSelectedPositionInt(k);
                    checkSelectionChanged();
                    flag = true;
                }
            }
        }
        if(!flag) {
            mSelectedPosition = -1;
            mSelectedRowId = 0x8000000000000000L;
            mNextSelectedPosition = -1;
            mNextSelectedRowId = 0x8000000000000000L;
            mNeedSync = false;
            checkSelectionChanged();
        }
        notifyAccessibilityStateChanged();
    }

    boolean isInFilterMode() {
        return false;
    }

    int lookForSelectablePosition(int i, boolean flag) {
        return i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mSelectionNotifier);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/AdapterView.getName());
        accessibilityevent.setScrollable(isScrollableForAccessibility());
        View view = getSelectedView();
        if(view != null)
            accessibilityevent.setEnabled(view.isEnabled());
        accessibilityevent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityevent.setFromIndex(getFirstVisiblePosition());
        accessibilityevent.setToIndex(getLastVisiblePosition());
        accessibilityevent.setItemCount(getCount());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/AdapterView.getName());
        accessibilitynodeinfo.setScrollable(isScrollableForAccessibility());
        View view = getSelectedView();
        if(view != null)
            accessibilitynodeinfo.setEnabled(view.isEnabled());
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        mLayoutHeight = getHeight();
    }

    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityevent) {
        boolean flag;
        if(super.onRequestSendAccessibilityEvent(view, accessibilityevent)) {
            AccessibilityEvent accessibilityevent1 = AccessibilityEvent.obtain();
            onInitializeAccessibilityEvent(accessibilityevent1);
            view.dispatchPopulateAccessibilityEvent(accessibilityevent1);
            accessibilityevent.appendRecord(accessibilityevent1);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean performItemClick(View view, int i, long l) {
        boolean flag = false;
        if(mOnItemClickListener != null) {
            playSoundEffect(0);
            if(view != null)
                view.sendAccessibilityEvent(1);
            mOnItemClickListener.onItemClick(this, view, i, l);
            flag = true;
        }
        return flag;
    }

    void rememberSyncState() {
        if(getChildCount() > 0) {
            mNeedSync = true;
            mSyncHeight = mLayoutHeight;
            if(mSelectedPosition >= 0) {
                View view1 = getChildAt(mSelectedPosition - mFirstPosition);
                mSyncRowId = mNextSelectedRowId;
                mSyncPosition = mNextSelectedPosition;
                if(view1 != null)
                    mSpecificTop = view1.getTop();
                mSyncMode = 0;
            } else {
                View view = getChildAt(0);
                Adapter adapter = getAdapter();
                if(mFirstPosition >= 0 && mFirstPosition < adapter.getCount())
                    mSyncRowId = adapter.getItemId(mFirstPosition);
                else
                    mSyncRowId = -1L;
                mSyncPosition = mFirstPosition;
                if(view != null)
                    mSpecificTop = view.getTop();
                mSyncMode = 1;
            }
        }
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    void selectionChanged() {
        if(mOnItemSelectedListener != null || AccessibilityManager.getInstance(super.mContext).isEnabled())
            if(mInLayout || mBlockLayoutRequests) {
                if(mSelectionNotifier == null)
                    mSelectionNotifier = new SelectionNotifier();
                post(mSelectionNotifier);
            } else {
                fireOnSelected();
                performAccessibilityActionsOnSelected();
            }
    }

    public abstract void setAdapter(Adapter adapter);

    public void setEmptyView(View view) {
        boolean flag = true;
        mEmptyView = view;
        if(view != null && view.getImportantForAccessibility() == 0)
            view.setImportantForAccessibility(flag);
        Adapter adapter = getAdapter();
        if(adapter != null && !adapter.isEmpty())
            flag = false;
        updateEmptyStatus(flag);
    }

    public void setFocusable(boolean flag) {
        boolean flag1 = true;
        Adapter adapter = getAdapter();
        boolean flag2;
        if(adapter == null || adapter.getCount() == 0)
            flag2 = flag1;
        else
            flag2 = false;
        mDesiredFocusableState = flag;
        if(!flag)
            mDesiredFocusableInTouchModeState = false;
        if(!flag || flag2 && !isInFilterMode())
            flag1 = false;
        super.setFocusable(flag1);
    }

    public void setFocusableInTouchMode(boolean flag) {
        boolean flag1 = true;
        Adapter adapter = getAdapter();
        boolean flag2;
        if(adapter == null || adapter.getCount() == 0)
            flag2 = flag1;
        else
            flag2 = false;
        mDesiredFocusableInTouchModeState = flag;
        if(flag)
            mDesiredFocusableState = flag1;
        if(!flag || flag2 && !isInFilterMode())
            flag1 = false;
        super.setFocusableInTouchMode(flag1);
    }

    void setNextSelectedPositionInt(int i) {
        mNextSelectedPosition = i;
        mNextSelectedRowId = getItemIdAtPosition(i);
        if(mNeedSync && mSyncMode == 0 && i >= 0) {
            mSyncPosition = i;
            mSyncRowId = mNextSelectedRowId;
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(OnItemClickListener onitemclicklistener) {
        mOnItemClickListener = onitemclicklistener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onitemlongclicklistener) {
        if(!isLongClickable())
            setLongClickable(true);
        mOnItemLongClickListener = onitemlongclicklistener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onitemselectedlistener) {
        mOnItemSelectedListener = onitemselectedlistener;
    }

    void setSelectedPositionInt(int i) {
        mSelectedPosition = i;
        mSelectedRowId = getItemIdAtPosition(i);
    }

    public abstract void setSelection(int i);

    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = 0x8000000000000000L;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    static final int SYNC_FIRST_POSITION = 1;
    static final int SYNC_MAX_DURATION_MILLIS = 100;
    static final int SYNC_SELECTED_POSITION;
    boolean mBlockLayoutRequests;
    boolean mDataChanged;
    private boolean mDesiredFocusableInTouchModeState;
    private boolean mDesiredFocusableState;
    private View mEmptyView;
    int mFirstPosition;
    boolean mInLayout;
    int mItemCount;
    private int mLayoutHeight;
    boolean mNeedSync;
    int mNextSelectedPosition;
    long mNextSelectedRowId;
    int mOldItemCount;
    int mOldSelectedPosition;
    long mOldSelectedRowId;
    OnItemClickListener mOnItemClickListener;
    OnItemLongClickListener mOnItemLongClickListener;
    OnItemSelectedListener mOnItemSelectedListener;
    int mSelectedPosition;
    long mSelectedRowId;
    private SelectionNotifier mSelectionNotifier;
    int mSpecificTop;
    long mSyncHeight;
    int mSyncMode;
    int mSyncPosition;
    long mSyncRowId;




}
