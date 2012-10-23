// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.*;
import android.text.*;
import android.util.*;
import android.view.*;
import android.view.accessibility.*;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.widget:
//            AdapterView, Filterable, PopupWindow, EditText, 
//            EdgeEffect, Checkable, ListAdapter, FastScroller, 
//            RemoteViewsAdapter, Filter, OverScroller, Adapter

public abstract class AbsListView extends AdapterView
    implements TextWatcher, android.view.ViewTreeObserver.OnGlobalLayoutListener, Filter.FilterListener, android.view.ViewTreeObserver.OnTouchModeChangeListener, RemoteViewsAdapter.RemoteAdapterConnectionCallback {
    class RecycleBin {

        private void pruneScrapViews() {
            int i = mActiveViews.length;
            int j = mViewTypeCount;
            ArrayList aarraylist[] = mScrapViews;
            for(int k = 0; k < j; k++) {
                ArrayList arraylist = aarraylist[k];
                int i1 = arraylist.size();
                int j1 = i1 - i;
                int k1 = i1 - 1;
                int l1 = 0;
                int j2;
                for(int i2 = k1; l1 < j1; i2 = j2) {
                    AbsListView abslistview = AbsListView.this;
                    j2 = i2 - 1;
                    abslistview.removeDetachedView((View)arraylist.remove(i2), false);
                    l1++;
                }

            }

            if(mTransientStateViews != null) {
                for(int l = 0; l < mTransientStateViews.size(); l++)
                    if(!((View)mTransientStateViews.valueAt(l)).hasTransientState()) {
                        mTransientStateViews.removeAt(l);
                        l--;
                    }

            }
        }

        void addScrapView(View view, int i) {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if(layoutparams != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            layoutparams.scrappedFromPosition = i;
            int j = layoutparams.viewType;
            boolean flag = view.hasTransientState();
            if(!shouldRecycleViewType(j) || flag) {
                if(j != -2 || flag) {
                    if(mSkippedScrap == null)
                        mSkippedScrap = new ArrayList();
                    mSkippedScrap.add(view);
                }
                if(flag) {
                    if(mTransientStateViews == null)
                        mTransientStateViews = new SparseArray();
                    view.dispatchStartTemporaryDetach();
                    mTransientStateViews.put(i, view);
                }
            } else {
                view.dispatchStartTemporaryDetach();
                if(mViewTypeCount == 1)
                    mCurrentScrap.add(view);
                else
                    mScrapViews[j].add(view);
                view.setAccessibilityDelegate(null);
                if(mRecyclerListener != null)
                    mRecyclerListener.onMovedToScrapHeap(view);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        void clear() {
            if(mViewTypeCount == 1) {
                ArrayList arraylist1 = mCurrentScrap;
                int i1 = arraylist1.size();
                for(int j1 = 0; j1 < i1; j1++)
                    removeDetachedView((View)arraylist1.remove(i1 - 1 - j1), false);

            } else {
                int i = mViewTypeCount;
                for(int j = 0; j < i; j++) {
                    ArrayList arraylist = mScrapViews[j];
                    int k = arraylist.size();
                    for(int l = 0; l < k; l++)
                        removeDetachedView((View)arraylist.remove(k - 1 - l), false);

                }

            }
            if(mTransientStateViews != null)
                mTransientStateViews.clear();
        }

        void clearTransientStateViews() {
            if(mTransientStateViews != null)
                mTransientStateViews.clear();
        }

        void fillActiveViews(int i, int j) {
            if(mActiveViews.length < i)
                mActiveViews = new View[i];
            mFirstActivePosition = j;
            View aview[] = mActiveViews;
            for(int k = 0; k < i; k++) {
                View view = getChildAt(k);
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                if(layoutparams != null && layoutparams.viewType != -2)
                    aview[k] = view;
            }

        }

        View getActiveView(int i) {
            int j = i - mFirstActivePosition;
            View aview[] = mActiveViews;
            View view;
            if(j >= 0 && j < aview.length) {
                view = aview[j];
                aview[j] = null;
            } else {
                view = null;
            }
            return view;
        }

        View getScrapView(int i) {
            View view;
            if(mViewTypeCount == 1) {
                view = AbsListView.retrieveFromScrap(mCurrentScrap, i);
            } else {
                int j = mAdapter.getItemViewType(i);
                if(j >= 0 && j < mScrapViews.length)
                    view = AbsListView.retrieveFromScrap(mScrapViews[j], i);
                else
                    view = null;
            }
            return view;
        }

        View getTransientStateView(int i) {
            View view = null;
            if(mTransientStateViews != null) goto _L2; else goto _L1
_L1:
            return view;
_L2:
            int j = mTransientStateViews.indexOfKey(i);
            if(j >= 0) {
                view = (View)mTransientStateViews.valueAt(j);
                mTransientStateViews.removeAt(j);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void markChildrenDirty() {
            if(mViewTypeCount == 1) {
                ArrayList arraylist1 = mCurrentScrap;
                int k1 = arraylist1.size();
                for(int l1 = 0; l1 < k1; l1++)
                    ((View)arraylist1.get(l1)).forceLayout();

            } else {
                int i = mViewTypeCount;
                for(int j = 0; j < i; j++) {
                    ArrayList arraylist = mScrapViews[j];
                    int i1 = arraylist.size();
                    for(int j1 = 0; j1 < i1; j1++)
                        ((View)arraylist.get(j1)).forceLayout();

                }

            }
            if(mTransientStateViews != null) {
                int k = mTransientStateViews.size();
                for(int l = 0; l < k; l++)
                    ((View)mTransientStateViews.valueAt(l)).forceLayout();

            }
        }

        void reclaimScrapViews(List list) {
            if(mViewTypeCount == 1) {
                list.addAll(mCurrentScrap);
            } else {
                int i = mViewTypeCount;
                ArrayList aarraylist[] = mScrapViews;
                int j = 0;
                while(j < i)  {
                    list.addAll(aarraylist[j]);
                    j++;
                }
            }
        }

        void removeSkippedScrap() {
            if(mSkippedScrap != null) {
                int i = mSkippedScrap.size();
                for(int j = 0; j < i; j++)
                    removeDetachedView((View)mSkippedScrap.get(j), false);

                mSkippedScrap.clear();
            }
        }

        void scrapActiveViews() {
            View aview[] = mActiveViews;
            boolean flag;
            boolean flag1;
            ArrayList arraylist;
            int i;
            if(mRecyclerListener != null)
                flag = true;
            else
                flag = false;
            if(mViewTypeCount > 1)
                flag1 = true;
            else
                flag1 = false;
            arraylist = mCurrentScrap;
            i = -1 + aview.length;
            while(i >= 0)  {
                View view = aview[i];
                if(view != null) {
                    LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                    int j = layoutparams.viewType;
                    aview[i] = null;
                    boolean flag2 = view.hasTransientState();
                    if(!shouldRecycleViewType(j) || flag2) {
                        if(j != -2 || flag2)
                            removeDetachedView(view, false);
                        if(flag2) {
                            if(mTransientStateViews == null)
                                mTransientStateViews = new SparseArray();
                            mTransientStateViews.put(i + mFirstActivePosition, view);
                        }
                    } else {
                        if(flag1)
                            arraylist = mScrapViews[j];
                        view.dispatchStartTemporaryDetach();
                        layoutparams.scrappedFromPosition = i + mFirstActivePosition;
                        arraylist.add(view);
                        view.setAccessibilityDelegate(null);
                        if(flag)
                            mRecyclerListener.onMovedToScrapHeap(view);
                    }
                }
                i--;
            }
            pruneScrapViews();
        }

        void setCacheColorHint(int i) {
            if(mViewTypeCount == 1) {
                ArrayList arraylist1 = mCurrentScrap;
                int l1 = arraylist1.size();
                for(int i2 = 0; i2 < l1; i2++)
                    ((View)arraylist1.get(i2)).setDrawingCacheBackgroundColor(i);

            } else {
                int j = mViewTypeCount;
                for(int k = 0; k < j; k++) {
                    ArrayList arraylist = mScrapViews[k];
                    int j1 = arraylist.size();
                    for(int k1 = 0; k1 < j1; k1++)
                        ((View)arraylist.get(k1)).setDrawingCacheBackgroundColor(i);

                }

            }
            View aview[] = mActiveViews;
            int l = aview.length;
            for(int i1 = 0; i1 < l; i1++) {
                View view = aview[i1];
                if(view != null)
                    view.setDrawingCacheBackgroundColor(i);
            }

        }

        public void setViewTypeCount(int i) {
            if(i < 1)
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            ArrayList aarraylist[] = new ArrayList[i];
            for(int j = 0; j < i; j++)
                aarraylist[j] = new ArrayList();

            mViewTypeCount = i;
            mCurrentScrap = aarraylist[0];
            mScrapViews = aarraylist;
        }

        public boolean shouldRecycleViewType(int i) {
            boolean flag;
            if(i >= 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private View mActiveViews[];
        private ArrayList mCurrentScrap;
        private int mFirstActivePosition;
        private RecyclerListener mRecyclerListener;
        private ArrayList mScrapViews[];
        private ArrayList mSkippedScrap;
        private SparseArray mTransientStateViews;
        private int mViewTypeCount;
        final AbsListView this$0;



/*
        static RecyclerListener access$3402(RecycleBin recyclebin, RecyclerListener recyclerlistener) {
            recyclebin.mRecyclerListener = recyclerlistener;
            return recyclerlistener;
        }

*/

        RecycleBin() {
            this$0 = AbsListView.this;
            super();
            mActiveViews = new View[0];
        }
    }

    public static interface RecyclerListener {

        public abstract void onMovedToScrapHeap(View view);
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {

        boolean forceAdd;
        long itemId;
        boolean recycledHeaderFooter;
        int scrappedFromPosition;
        int viewType;

        public LayoutParams(int i, int j) {
            super(i, j);
            itemId = -1L;
        }

        public LayoutParams(int i, int j, int k) {
            super(i, j);
            itemId = -1L;
            viewType = k;
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
            itemId = -1L;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
            super(layoutparams);
            itemId = -1L;
        }
    }

    class MultiChoiceModeWrapper
        implements MultiChoiceModeListener {

        public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem) {
            return mWrapped.onActionItemClicked(actionmode, menuitem);
        }

        public boolean onCreateActionMode(ActionMode actionmode, Menu menu) {
            boolean flag = false;
            if(mWrapped.onCreateActionMode(actionmode, menu)) {
                setLongClickable(false);
                flag = true;
            }
            return flag;
        }

        public void onDestroyActionMode(ActionMode actionmode) {
            mWrapped.onDestroyActionMode(actionmode);
            mChoiceActionMode = null;
            clearChoices();
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
            setLongClickable(true);
        }

        public void onItemCheckedStateChanged(ActionMode actionmode, int i, long l, boolean flag) {
            mWrapped.onItemCheckedStateChanged(actionmode, i, l, flag);
            if(getCheckedItemCount() == 0)
                actionmode.finish();
        }

        public boolean onPrepareActionMode(ActionMode actionmode, Menu menu) {
            return mWrapped.onPrepareActionMode(actionmode, menu);
        }

        public void setWrapped(MultiChoiceModeListener multichoicemodelistener) {
            mWrapped = multichoicemodelistener;
        }

        private MultiChoiceModeListener mWrapped;
        final AbsListView this$0;

        MultiChoiceModeWrapper() {
            this$0 = AbsListView.this;
            super();
        }
    }

    public static interface MultiChoiceModeListener
        extends android.view.ActionMode.Callback {

        public abstract void onItemCheckedStateChanged(ActionMode actionmode, int i, long l, boolean flag);
    }

    class AdapterDataSetObserver extends AdapterView.AdapterDataSetObserver {

        public void onChanged() {
            super.onChanged();
            if(mFastScroller != null)
                mFastScroller.onSectionsChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            if(mFastScroller != null)
                mFastScroller.onSectionsChanged();
        }

        final AbsListView this$0;

        AdapterDataSetObserver() {
            this$0 = AbsListView.this;
            super(AbsListView.this);
        }
    }

    /* member class not found */
    class PositionScroller {}

    final class CheckForTap
        implements Runnable {

        public void run() {
            if(mTouchMode == 0) {
                mTouchMode = 1;
                View view = getChildAt(mMotionPosition - mFirstPosition);
                if(view != null && !view.hasFocusable()) {
                    mLayoutMode = 0;
                    if(!mDataChanged) {
                        view.setPressed(true);
                        setPressed(true);
                        layoutChildren();
                        positionSelector(mMotionPosition, view);
                        refreshDrawableState();
                        int i = ViewConfiguration.getLongPressTimeout();
                        boolean flag = isLongClickable();
                        if(mSelector != null) {
                            Drawable drawable = mSelector.getCurrent();
                            if(drawable != null && (drawable instanceof TransitionDrawable))
                                if(flag)
                                    ((TransitionDrawable)drawable).startTransition(i);
                                else
                                    ((TransitionDrawable)drawable).resetTransition();
                        }
                        if(flag) {
                            if(mPendingCheckForLongPress == null)
                                mPendingCheckForLongPress = new CheckForLongPress();
                            mPendingCheckForLongPress.rememberWindowAttachCount();
                            postDelayed(mPendingCheckForLongPress, i);
                        } else {
                            mTouchMode = 2;
                        }
                    } else {
                        mTouchMode = 2;
                    }
                }
            }
        }

        final AbsListView this$0;

        CheckForTap() {
            this$0 = AbsListView.this;
            Object();
        }
    }

    private class CheckForKeyLongPress extends WindowRunnnable
        implements Runnable {

        public void run() {
            if(!isPressed() || mSelectedPosition < 0) goto _L2; else goto _L1
_L1:
            View view;
            int i = mSelectedPosition - mFirstPosition;
            view = getChildAt(i);
            if(mDataChanged) goto _L4; else goto _L3
_L3:
            boolean flag = false;
            if(sameWindow())
                flag = performLongPress(view, mSelectedPosition, mSelectedRowId);
            if(flag) {
                setPressed(false);
                view.setPressed(false);
            }
_L2:
            return;
_L4:
            setPressed(false);
            if(view != null)
                view.setPressed(false);
            if(true) goto _L2; else goto _L5
_L5:
        }

        final AbsListView this$0;

        private CheckForKeyLongPress() {
            this$0 = AbsListView.this;
            WindowRunnnable();
        }

    }

    private class CheckForLongPress extends WindowRunnnable
        implements Runnable {

        public void run() {
            int i = mMotionPosition;
            View view = getChildAt(i - mFirstPosition);
            if(view != null) {
                int j = mMotionPosition;
                long l = mAdapter.getItemId(mMotionPosition);
                boolean flag = false;
                if(sameWindow() && !mDataChanged)
                    flag = performLongPress(view, j, l);
                if(flag) {
                    mTouchMode = -1;
                    setPressed(false);
                    view.setPressed(false);
                } else {
                    mTouchMode = 2;
                }
            }
        }

        final AbsListView this$0;

        private CheckForLongPress() {
            this$0 = AbsListView.this;
            WindowRunnnable();
        }

    }

    private class PerformClick extends WindowRunnnable
        implements Runnable {

        public void run() {
            if(!mDataChanged) goto _L2; else goto _L1
_L1:
            return;
_L2:
            ListAdapter listadapter = mAdapter;
            int i = mClickMotionPosition;
            if(listadapter != null && mItemCount > 0 && i != -1 && i < listadapter.getCount() && sameWindow()) {
                View view = getChildAt(i - mFirstPosition);
                if(view != null)
                    performItemClick(view, i, listadapter.getItemId(i));
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        int mClickMotionPosition;
        final AbsListView this$0;

        private PerformClick() {
            this$0 = AbsListView.this;
            WindowRunnnable();
        }

    }

    private class WindowRunnnable {

        public void rememberWindowAttachCount() {
            mOriginalAttachCount = getWindowAttachCount();
        }

        public boolean sameWindow() {
            boolean flag;
            if(hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private int mOriginalAttachCount;
        final AbsListView this$0;

        private WindowRunnnable() {
            this$0 = AbsListView.this;
            Object();
        }

    }

    class ListItemAccessibilityDelegate extends android.view.View.AccessibilityDelegate {

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilitynodeinfo) {
            int i;
            ListAdapter listadapter;
            super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfo);
            i = getPositionForView(view);
            listadapter = (ListAdapter)getAdapter();
            break MISSING_BLOCK_LABEL_27;
            while(true)  {
                do
                    return;
                while(i == -1 || listadapter == null || !isEnabled() || !listadapter.isEnabled(i));
                if(i == getSelectedItemPosition()) {
                    accessibilitynodeinfo.setSelected(true);
                    accessibilitynodeinfo.addAction(8);
                } else {
                    accessibilitynodeinfo.addAction(4);
                }
                if(isClickable()) {
                    accessibilitynodeinfo.addAction(16);
                    accessibilitynodeinfo.setClickable(true);
                }
                if(isLongClickable()) {
                    accessibilitynodeinfo.addAction(32);
                    accessibilitynodeinfo.setLongClickable(true);
                }
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            boolean flag = true;
            if(!super.performAccessibilityAction(view, i, bundle)) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            int j;
            j = getPositionForView(view);
            ListAdapter listadapter = (ListAdapter)getAdapter();
            if(j == -1 || listadapter == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(isEnabled() && listadapter.isEnabled(j))
                break; /* Loop/switch isn't completed */
            flag = false;
            if(true) goto _L1; else goto _L3
_L3:
            long l = getItemIdAtPosition(j);
            switch(i) {
            default:
                flag = false;
                break;

            case 8: // '\b'
                if(getSelectedItemPosition() == j)
                    setSelection(-1);
                else
                    flag = false;
                break;

            case 4: // '\004'
                if(getSelectedItemPosition() != j)
                    setSelection(j);
                else
                    flag = false;
                break;

            case 16: // '\020'
                if(isClickable())
                    flag = performItemClick(view, j, l);
                else
                    flag = false;
                break;

            case 32: // ' '
                if(isLongClickable())
                    flag = performLongPress(view, j, l);
                else
                    flag = false;
                break;
            }
            if(true) goto _L1; else goto _L4
_L4:
        }

        final AbsListView this$0;

        ListItemAccessibilityDelegate() {
            this$0 = AbsListView.this;
            AccessibilityDelegate();
        }
    }

    static class SavedState extends android.view.View.BaseSavedState {

        public String toString() {
            return (new StringBuilder()).append("AbsListView.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" selectedId=").append(selectedId).append(" firstId=").append(firstId).append(" viewTop=").append(viewTop).append(" position=").append(position).append(" height=").append(height).append(" filter=").append(filter).append(" checkState=").append(checkState).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(selectedId);
            parcel.writeLong(firstId);
            parcel.writeInt(viewTop);
            parcel.writeInt(position);
            parcel.writeInt(height);
            parcel.writeString(filter);
            int j;
            int k;
            if(inActionMode)
                j = 1;
            else
                j = 0;
            parcel.writeByte((byte)j);
            parcel.writeInt(checkedItemCount);
            parcel.writeSparseBooleanArray(checkState);
            if(checkIdState != null)
                k = checkIdState.size();
            else
                k = 0;
            parcel.writeInt(k);
            for(int l = 0; l < k; l++) {
                parcel.writeLong(checkIdState.keyAt(l));
                parcel.writeInt(((Integer)checkIdState.valueAt(l)).intValue());
            }

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
        LongSparseArray checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        String filter;
        long firstId;
        int height;
        boolean inActionMode;
        int position;
        long selectedId;
        int viewTop;


        private SavedState(Parcel parcel) {
            BaseSavedState(parcel);
            selectedId = parcel.readLong();
            firstId = parcel.readLong();
            viewTop = parcel.readInt();
            position = parcel.readInt();
            height = parcel.readInt();
            filter = parcel.readString();
            boolean flag;
            int i;
            if(parcel.readByte() != 0)
                flag = true;
            else
                flag = false;
            inActionMode = flag;
            checkedItemCount = parcel.readInt();
            checkState = parcel.readSparseBooleanArray();
            i = parcel.readInt();
            if(i > 0) {
                checkIdState = new LongSparseArray();
                for(int j = 0; j < i; j++) {
                    long l = parcel.readLong();
                    int k = parcel.readInt();
                    checkIdState.put(l, Integer.valueOf(k));
                }

            }
        }


        SavedState(Parcelable parcelable) {
            BaseSavedState(parcelable);
        }
    }

    public static interface SelectionBoundsAdjuster {

        public abstract void adjustListItemSelectionBounds(Rect rect);
    }

    public static interface OnScrollListener {

        public abstract void onScroll(AbsListView abslistview, int i, int j, int k);

        public abstract void onScrollStateChanged(AbsListView abslistview, int i);

        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
    }


    public AbsListView(Context context) {
        super(context);
        mChoiceMode = 0;
        mLayoutMode = 0;
        mDeferNotifyDataSetChanged = false;
        mDrawSelectorOnTop = false;
        mSelectorPosition = -1;
        mSelectorRect = new Rect();
        mRecycler = new RecycleBin();
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mListPadding = new Rect();
        mTouchPaddingLeft = 0;
        mTouchPaddingRight = 0;
        mWidthMeasureSpec = 0;
        mTouchMode = -1;
        mSelectedTop = 0;
        mSmoothScrollbarEnabled = true;
        mResurrectToPosition = -1;
        mContextMenuInfo = null;
        mLastTouchMode = -1;
        mScrollProfilingStarted = false;
        mFlingProfilingStarted = false;
        mScrollStrictSpan = null;
        mFlingStrictSpan = null;
        mLastScrollState = 0;
        mVelocityScale = 1.0F;
        mIsScrap = new boolean[1];
        mActivePointerId = -1;
        mDirection = 0;
        initAbsListView();
        setVerticalScrollBarEnabled(true);
        TypedArray typedarray = context.obtainStyledAttributes(com.android.internal.R.styleable.View);
        initializeScrollbars(typedarray);
        typedarray.recycle();
    }

    public AbsListView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101006a);
    }

    public AbsListView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mChoiceMode = 0;
        mLayoutMode = 0;
        mDeferNotifyDataSetChanged = false;
        mDrawSelectorOnTop = false;
        mSelectorPosition = -1;
        mSelectorRect = new Rect();
        mRecycler = new RecycleBin();
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mListPadding = new Rect();
        mTouchPaddingLeft = 0;
        mTouchPaddingRight = 0;
        mWidthMeasureSpec = 0;
        mTouchMode = -1;
        mSelectedTop = 0;
        mSmoothScrollbarEnabled = true;
        mResurrectToPosition = -1;
        mContextMenuInfo = null;
        mLastTouchMode = -1;
        mScrollProfilingStarted = false;
        mFlingProfilingStarted = false;
        mScrollStrictSpan = null;
        mFlingStrictSpan = null;
        mLastScrollState = 0;
        mVelocityScale = 1.0F;
        mIsScrap = new boolean[1];
        mActivePointerId = -1;
        mDirection = 0;
        initAbsListView();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.AbsListView, i, 0);
        Drawable drawable = typedarray.getDrawable(0);
        if(drawable != null)
            setSelector(drawable);
        mDrawSelectorOnTop = typedarray.getBoolean(1, false);
        setStackFromBottom(typedarray.getBoolean(2, false));
        setScrollingCacheEnabled(typedarray.getBoolean(3, true));
        setTextFilterEnabled(typedarray.getBoolean(4, false));
        setTranscriptMode(typedarray.getInt(5, 0));
        setCacheColorHint(typedarray.getColor(6, 0));
        setFastScrollEnabled(typedarray.getBoolean(8, false));
        setSmoothScrollbarEnabled(typedarray.getBoolean(9, true));
        setChoiceMode(typedarray.getInt(7, 0));
        setFastScrollAlwaysVisible(typedarray.getBoolean(10, false));
        typedarray.recycle();
    }

    private boolean acceptFilter() {
        boolean flag;
        if(mTextFilterEnabled && (getAdapter() instanceof Filterable) && ((Filterable)getAdapter()).getFilter() != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void clearScrollingCache() {
        if(!isHardwareAccelerated()) {
            if(mClearScrollingCache == null)
                mClearScrollingCache = new Runnable() ;
            post(mClearScrollingCache);
        }
    }

    private boolean contentFits() {
        boolean flag;
        int i;
        flag = true;
        i = getChildCount();
        if(i != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(i != super.mItemCount)
            flag = false;
        else
        if(getChildAt(0).getTop() < mListPadding.top || getChildAt(i - 1).getBottom() > getHeight() - mListPadding.bottom)
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void createScrollingCache() {
        if(mScrollingCacheEnabled && !mCachingStarted && !isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            mCachingActive = true;
            mCachingStarted = true;
        }
    }

    private void createTextFilter(boolean flag) {
        if(mPopup == null) {
            Context context = getContext();
            PopupWindow popupwindow = new PopupWindow(context);
            mTextFilter = (EditText)((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x10900c1, null);
            mTextFilter.setRawInputType(177);
            mTextFilter.setImeOptions(0x10000000);
            mTextFilter.addTextChangedListener(this);
            popupwindow.setFocusable(false);
            popupwindow.setTouchable(false);
            popupwindow.setInputMethodMode(2);
            popupwindow.setContentView(mTextFilter);
            popupwindow.setWidth(-2);
            popupwindow.setHeight(-2);
            popupwindow.setBackgroundDrawable(null);
            mPopup = popupwindow;
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            mGlobalLayoutListenerAddedFilter = true;
        }
        if(flag)
            mPopup.setAnimationStyle(0x10301e1);
        else
            mPopup.setAnimationStyle(0x10301e2);
    }

    private void dismissPopup() {
        if(mPopup != null)
            mPopup.dismiss();
    }

    private void drawSelector(Canvas canvas) {
        if(!mSelectorRect.isEmpty()) {
            Drawable drawable = mSelector;
            drawable.setBounds(mSelectorRect);
            drawable.draw(canvas);
        }
    }

    private void finishGlows() {
        if(mEdgeGlowTop != null) {
            mEdgeGlowTop.finish();
            mEdgeGlowBottom.finish();
        }
    }

    static int getDistance(Rect rect, Rect rect1, int i) {
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   1: 253
    //                   2: 253
    //                   17: 173
    //                   33: 213
    //                   66: 71
    //                   130: 133;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L6
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
_L5:
        int j;
        int k;
        int l;
        int i1;
        j = rect.right;
        k = rect.top + rect.height() / 2;
        l = rect1.left;
        i1 = rect1.top + rect1.height() / 2;
_L8:
        int j1 = l - j;
        int k1 = i1 - k;
        return k1 * k1 + j1 * j1;
_L6:
        j = rect.left + rect.width() / 2;
        k = rect.bottom;
        l = rect1.left + rect1.width() / 2;
        i1 = rect1.top;
        continue; /* Loop/switch isn't completed */
_L3:
        j = rect.left;
        k = rect.top + rect.height() / 2;
        l = rect1.right;
        i1 = rect1.top + rect1.height() / 2;
        continue; /* Loop/switch isn't completed */
_L4:
        j = rect.left + rect.width() / 2;
        k = rect.top;
        l = rect1.left + rect1.width() / 2;
        i1 = rect1.bottom;
        continue; /* Loop/switch isn't completed */
_L2:
        j = rect.right + rect.width() / 2;
        k = rect.top + rect.height() / 2;
        l = rect1.left + rect1.width() / 2;
        i1 = rect1.top + rect1.height() / 2;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private void initAbsListView() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(super.mContext);
        mTouchSlop = viewconfiguration.getScaledTouchSlop();
        mMinimumVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mOverscrollDistance = viewconfiguration.getScaledOverscrollDistance();
        mOverflingDistance = viewconfiguration.getScaledOverflingDistance();
        mDensityScale = getContext().getResources().getDisplayMetrics().density;
    }

    private void initOrResetVelocityTracker() {
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        else
            mVelocityTracker.clear();
    }

    private void initVelocityTrackerIfNotExists() {
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
    }

    private boolean isOutOfTouchRange(MotionEvent motionevent) {
        boolean flag;
        if(motionevent.getX() < (float)mTouchPaddingLeft || motionevent.getX() > (float)(getWidth() - mTouchPaddingRight))
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
            mMotionX = (int)motionevent.getX(j);
            mMotionY = (int)motionevent.getY(j);
            mMotionCorrection = 0;
            mActivePointerId = motionevent.getPointerId(j);
        }
    }

    private void positionPopup() {
        int i = getResources().getDisplayMetrics().heightPixels;
        int ai[] = new int[2];
        getLocationOnScreen(ai);
        int j = (i - ai[1] - getHeight()) + (int)(20F * mDensityScale);
        if(!mPopup.isShowing())
            mPopup.showAtLocation(this, 81, ai[0], j);
        else
            mPopup.update(ai[0], j, -1, -1);
    }

    private void positionSelector(int i, int j, int k, int l) {
        mSelectorRect.set(i - mSelectionLeftPadding, j - mSelectionTopPadding, k + mSelectionRightPadding, l + mSelectionBottomPadding);
    }

    private void recycleVelocityTracker() {
        if(mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    static View retrieveFromScrap(ArrayList arraylist, int i) {
        int j;
        int k;
        j = arraylist.size();
        if(j <= 0)
            break MISSING_BLOCK_LABEL_71;
        k = 0;
_L5:
        if(k >= j) goto _L2; else goto _L1
_L1:
        View view = (View)arraylist.get(k);
        if(((LayoutParams)view.getLayoutParams()).scrappedFromPosition != i) goto _L4; else goto _L3
_L3:
        arraylist.remove(k);
_L6:
        return view;
_L4:
        k++;
          goto _L5
_L2:
        view = (View)arraylist.remove(j - 1);
          goto _L6
        view = null;
          goto _L6
    }

    private void scrollIfNeeded(int i) {
        int j;
        int l;
        j = i - mMotionY;
        int k = j - mMotionCorrection;
        int j3;
        View view1;
        boolean flag;
        View view2;
        int k3;
        int i4;
        ViewParent viewparent;
        if(mLastY != 0x80000000)
            l = i - mLastY;
        else
            l = k;
        if(mTouchMode != 3) goto _L2; else goto _L1
_L1:
        if(mScrollStrictSpan == null)
            mScrollStrictSpan = StrictMode.enterCriticalSpan("AbsListView-scroll");
        if(i != mLastY) {
            if((0x80000 & super.mGroupFlags) == 0 && Math.abs(j) > mTouchSlop) {
                viewparent = getParent();
                if(viewparent != null)
                    viewparent.requestDisallowInterceptTouchEvent(true);
            }
            int i3;
            if(mMotionPosition >= 0)
                i3 = mMotionPosition - super.mFirstPosition;
            else
                i3 = getChildCount() / 2;
            j3 = 0;
            view1 = getChildAt(i3);
            if(view1 != null)
                j3 = view1.getTop();
            flag = false;
            if(l != 0)
                flag = trackMotionScroll(k, l);
            view2 = getChildAt(i3);
            if(view2 != null) {
                k3 = view2.getTop();
                if(flag) {
                    int l3 = -l - (k3 - j3);
                    overScrollBy(0, l3, 0, super.mScrollY, 0, 0, 0, mOverscrollDistance, true);
                    if(Math.abs(mOverscrollDistance) == Math.abs(super.mScrollY) && mVelocityTracker != null)
                        mVelocityTracker.clear();
                    i4 = getOverScrollMode();
                    if(i4 == 0 || i4 == 1 && !contentFits()) {
                        mDirection = 0;
                        mTouchMode = 5;
                        if(j > 0) {
                            mEdgeGlowTop.onPull((float)l3 / (float)getHeight());
                            if(!mEdgeGlowBottom.isFinished())
                                mEdgeGlowBottom.onRelease();
                            invalidate(mEdgeGlowTop.getBounds(false));
                        } else
                        if(j < 0) {
                            mEdgeGlowBottom.onPull((float)l3 / (float)getHeight());
                            if(!mEdgeGlowTop.isFinished())
                                mEdgeGlowTop.onRelease();
                            invalidate(mEdgeGlowBottom.getBounds(true));
                        }
                    }
                }
                mMotionY = i;
            }
            mLastY = i;
        }
_L10:
        return;
_L2:
        if(mTouchMode != 5 || i == mLastY) goto _L4; else goto _L3
_L3:
        int l1;
        int i1 = super.mScrollY;
        int j1 = i1 - l;
        int k1;
        int i2;
        int j2;
        View view;
        int l2;
        if(i > mLastY)
            k1 = 1;
        else
            k1 = -1;
        if(mDirection == 0)
            mDirection = k1;
        l1 = -l;
        if(j1 < 0 && i1 >= 0 || j1 > 0 && i1 <= 0) {
            l1 = -i1;
            i2 = l + l1;
        } else {
            i2 = 0;
        }
        if(l1 == 0) goto _L6; else goto _L5
_L5:
        overScrollBy(0, l1, 0, super.mScrollY, 0, 0, 0, mOverscrollDistance, true);
        l2 = getOverScrollMode();
        if(l2 != 0 && (l2 != 1 || contentFits())) goto _L6; else goto _L7
_L7:
        if(j <= 0) goto _L9; else goto _L8
_L8:
        mEdgeGlowTop.onPull((float)l1 / (float)getHeight());
        if(!mEdgeGlowBottom.isFinished())
            mEdgeGlowBottom.onRelease();
        invalidate(mEdgeGlowTop.getBounds(false));
_L6:
        if(i2 != 0) {
            if(super.mScrollY != 0) {
                super.mScrollY = 0;
                invalidateParentIfNeeded();
            }
            trackMotionScroll(i2, i2);
            mTouchMode = 3;
            j2 = findClosestMotionRow(i);
            mMotionCorrection = 0;
            view = getChildAt(j2 - super.mFirstPosition);
            int k2;
            if(view != null)
                k2 = view.getTop();
            else
                k2 = 0;
            mMotionViewOriginalTop = k2;
            mMotionY = i;
            mMotionPosition = j2;
        }
        mLastY = i;
        mDirection = k1;
_L4:
        if(true) goto _L10; else goto _L9
_L9:
        if(j < 0) {
            mEdgeGlowBottom.onPull((float)l1 / (float)getHeight());
            if(!mEdgeGlowTop.isFinished())
                mEdgeGlowTop.onRelease();
            invalidate(mEdgeGlowBottom.getBounds(true));
        }
          goto _L6
    }

    private void showPopup() {
        if(getWindowVisibility() == 0) {
            createTextFilter(true);
            positionPopup();
            checkFocus();
        }
    }

    private boolean startScrollIfNeeded(int i) {
        int j = i - mMotionY;
        int k = Math.abs(j);
        boolean flag;
        boolean flag1;
        if(super.mScrollY != 0)
            flag = true;
        else
            flag = false;
        if(flag || k > mTouchSlop) {
            createScrollingCache();
            Handler handler;
            View view;
            ViewParent viewparent;
            if(flag) {
                mTouchMode = 5;
                mMotionCorrection = 0;
            } else {
                mTouchMode = 3;
                int l;
                if(j > 0)
                    l = mTouchSlop;
                else
                    l = -mTouchSlop;
                mMotionCorrection = l;
            }
            handler = getHandler();
            if(handler != null)
                handler.removeCallbacks(mPendingCheckForLongPress);
            setPressed(false);
            view = getChildAt(mMotionPosition - super.mFirstPosition);
            if(view != null)
                view.setPressed(false);
            reportScrollStateChange(1);
            viewparent = getParent();
            if(viewparent != null)
                viewparent.requestDisallowInterceptTouchEvent(true);
            scrollIfNeeded(i);
            flag1 = true;
        } else {
            flag1 = false;
        }
        return flag1;
    }

    private void updateOnScreenCheckedViews() {
        int i = super.mFirstPosition;
        int j = getChildCount();
        boolean flag;
        int k;
        if(getContext().getApplicationInfo().targetSdkVersion >= 11)
            flag = true;
        else
            flag = false;
        k = 0;
        while(k < j)  {
            View view = getChildAt(k);
            int l = i + k;
            if(view instanceof Checkable)
                ((Checkable)view).setChecked(mCheckStates.get(l));
            else
            if(flag)
                view.setActivated(mCheckStates.get(l));
            k++;
        }
    }

    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(0x1080062));
    }

    public void addFocusables(ArrayList arraylist, int i, int j) {
        if((j & 2) != 2) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 4097 4098: default 32
    //                   4097 40
    //                   4098 84;
           goto _L2 _L3 _L4
_L2:
        addFocusables(arraylist, i, j);
_L6:
        return;
_L3:
        Object obj;
        if(getChildCount() > 0)
            obj = getChildAt(-1 + getChildCount());
        else
            obj = this;
        if(((View) (obj)).isAccessibilityFocusable())
            arraylist.add(obj);
        continue; /* Loop/switch isn't completed */
_L4:
        if(isAccessibilityFocusable())
            arraylist.add(this);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void addTouchables(ArrayList arraylist) {
        int i = getChildCount();
        int j = super.mFirstPosition;
        ListAdapter listadapter = mAdapter;
        if(listadapter != null) {
            int k = 0;
            while(k < i)  {
                View view = getChildAt(k);
                if(listadapter.isEnabled(j + k))
                    arraylist.add(view);
                view.addTouchables(arraylist);
                k++;
            }
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k) {
    }

    public boolean checkInputConnectionProxy(View view) {
        boolean flag;
        if(view == mTextFilter)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    public void clearChoices() {
        if(mCheckStates != null)
            mCheckStates.clear();
        if(mCheckedIdStates != null)
            mCheckedIdStates.clear();
        mCheckedItemCount = 0;
    }

    public void clearTextFilter() {
        if(mFiltered) {
            mTextFilter.setText("");
            mFiltered = false;
            if(mPopup != null && mPopup.isShowing())
                dismissPopup();
        }
    }

    protected int computeVerticalScrollExtent() {
        int i = getChildCount();
        int j;
        if(i > 0) {
            if(mSmoothScrollbarEnabled) {
                j = i * 100;
                View view = getChildAt(0);
                int k = view.getTop();
                int l = view.getHeight();
                if(l > 0)
                    j += (k * 100) / l;
                View view1 = getChildAt(i - 1);
                int i1 = view1.getBottom();
                int j1 = view1.getHeight();
                if(j1 > 0)
                    j -= (100 * (i1 - getHeight())) / j1;
            } else {
                j = 1;
            }
        } else {
            j = 0;
        }
        return j;
    }

    protected int computeVerticalScrollOffset() {
        int i;
        int j;
        int k;
        i = 0;
        j = super.mFirstPosition;
        k = getChildCount();
        if(j < 0 || k <= 0) goto _L2; else goto _L1
_L1:
        if(!mSmoothScrollbarEnabled) goto _L4; else goto _L3
_L3:
        View view = getChildAt(0);
        int j1 = view.getTop();
        int k1 = view.getHeight();
        if(k1 > 0)
            i = Math.max((j * 100 - (j1 * 100) / k1) + (int)(100F * (((float)super.mScrollY / (float)getHeight()) * (float)super.mItemCount)), 0);
_L2:
        return i;
_L4:
        int l;
        int i1;
        l = super.mItemCount;
        if(j != 0)
            break; /* Loop/switch isn't completed */
        i1 = 0;
_L6:
        i = (int)((float)j + (float)k * ((float)i1 / (float)l));
        if(true) goto _L2; else goto _L5
_L5:
        if(j + k == l)
            i1 = l;
        else
            i1 = j + k / 2;
          goto _L6
        if(true) goto _L2; else goto _L7
_L7:
    }

    protected int computeVerticalScrollRange() {
        int i;
        if(mSmoothScrollbarEnabled) {
            i = Math.max(100 * super.mItemCount, 0);
            if(super.mScrollY != 0)
                i += Math.abs((int)(100F * (((float)super.mScrollY / (float)getHeight()) * (float)super.mItemCount)));
        } else {
            i = super.mItemCount;
        }
        return i;
    }

    void confirmCheckedPositionsById() {
        boolean flag;
        int i;
        mCheckStates.clear();
        flag = false;
        i = 0;
_L8:
        long l;
        int j;
        int i1;
        boolean flag1;
        int j1;
        if(i >= mCheckedIdStates.size())
            break MISSING_BLOCK_LABEL_227;
        l = mCheckedIdStates.keyAt(i);
        j = ((Integer)mCheckedIdStates.valueAt(i)).intValue();
        if(l == mAdapter.getItemId(j))
            break MISSING_BLOCK_LABEL_214;
        int k = Math.max(0, j - 20);
        i1 = Math.min(j + 20, super.mItemCount);
        flag1 = false;
        j1 = k;
_L5:
        if(j1 >= i1) goto _L2; else goto _L1
_L1:
        if(l != mAdapter.getItemId(j1)) goto _L4; else goto _L3
_L3:
        flag1 = true;
        mCheckStates.put(j1, true);
        mCheckedIdStates.setValueAt(i, Integer.valueOf(j1));
_L2:
        if(!flag1) {
            mCheckedIdStates.delete(l);
            i--;
            mCheckedItemCount = -1 + mCheckedItemCount;
            flag = true;
            if(mChoiceActionMode != null && mMultiChoiceModeCallback != null)
                mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode, j, l, false);
        }
_L6:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        j1++;
          goto _L5
        mCheckStates.put(j, true);
          goto _L6
        if(flag && mChoiceActionMode != null)
            mChoiceActionMode.invalidate();
        return;
        if(true) goto _L8; else goto _L7
_L7:
    }

    android.view.ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long l) {
        return new AdapterContextMenuInfo(view, i, l);
    }

    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
    }

    protected void dispatchDraw(Canvas canvas) {
        int i = 0;
        boolean flag;
        boolean flag1;
        if((0x22 & super.mGroupFlags) == 34)
            flag = true;
        else
            flag = false;
        if(flag) {
            i = canvas.save();
            int j = super.mScrollX;
            int k = super.mScrollY;
            canvas.clipRect(j + super.mPaddingLeft, k + super.mPaddingTop, (j + super.mRight) - super.mLeft - super.mPaddingRight, (k + super.mBottom) - super.mTop - super.mPaddingBottom);
            super.mGroupFlags = 0xffffffdd & super.mGroupFlags;
        }
        flag1 = mDrawSelectorOnTop;
        if(!flag1)
            drawSelector(canvas);
        dispatchDraw(canvas);
        if(flag1)
            drawSelector(canvas);
        if(flag) {
            canvas.restoreToCount(i);
            super.mGroupFlags = 0x22 | super.mGroupFlags;
        }
    }

    protected void dispatchSetPressed(boolean flag) {
    }

    public void draw(Canvas canvas) {
        draw(canvas);
        if(mEdgeGlowTop != null) {
            int k = super.mScrollY;
            if(!mEdgeGlowTop.isFinished()) {
                int k2 = canvas.save();
                int l2 = mListPadding.left + mGlowPaddingLeft;
                int i3 = mListPadding.right + mGlowPaddingRight;
                int j3 = getWidth() - l2 - i3;
                int k3 = Math.min(0, k + mFirstPositionDistanceGuess);
                canvas.translate(l2, k3);
                mEdgeGlowTop.setSize(j3, getHeight());
                if(mEdgeGlowTop.draw(canvas)) {
                    mEdgeGlowTop.setPosition(l2, k3);
                    invalidate(mEdgeGlowTop.getBounds(false));
                }
                canvas.restoreToCount(k2);
            }
            if(!mEdgeGlowBottom.isFinished()) {
                int l = canvas.save();
                int i1 = mListPadding.left + mGlowPaddingLeft;
                int j1 = mListPadding.right + mGlowPaddingRight;
                int k1 = getWidth() - i1 - j1;
                int l1 = getHeight();
                int i2 = i1 + -k1;
                int j2 = Math.max(l1, k + mLastPositionDistanceGuess);
                canvas.translate(i2, j2);
                canvas.rotate(180F, k1, 0.0F);
                mEdgeGlowBottom.setSize(k1, l1);
                if(mEdgeGlowBottom.draw(canvas)) {
                    mEdgeGlowBottom.setPosition(i2 + k1, j2);
                    invalidate(mEdgeGlowBottom.getBounds(true));
                }
                canvas.restoreToCount(l);
            }
        }
        if(mFastScroller != null) {
            int i = super.mScrollY;
            if(i != 0) {
                int j = canvas.save();
                canvas.translate(0.0F, i);
                mFastScroller.draw(canvas);
                canvas.restoreToCount(j);
            } else {
                mFastScroller.draw(canvas);
            }
        }
    }

    protected void drawableStateChanged() {
        drawableStateChanged();
        updateSelectorState();
    }

    abstract void fillGap(boolean flag);

    int findClosestMotionRow(int i) {
        int j = getChildCount();
        if(j != 0) goto _L2; else goto _L1
_L1:
        int k = -1;
_L4:
        return k;
_L2:
        k = findMotionRow(i);
        if(k == -1)
            k = -1 + (j + super.mFirstPosition);
        if(true) goto _L4; else goto _L3
_L3:
    }

    abstract int findMotionRow(int i);

    public View findViewToTakeAccessibilityFocusFromHover(View view, View view1) {
        int i = getPositionForView(view);
        View view2;
        if(i != -1)
            view2 = getChildAt(i - super.mFirstPosition);
        else
            view2 = findViewToTakeAccessibilityFocusFromHover(view, view1);
        return view2;
    }

    public View focusSearch(int i) {
        return focusSearch(((View) (this)), i);
    }

    public View focusSearch(View view, int i) {
        i;
        JVM INSTR tableswitch 4097 4098: default 24
    //                   4097 247
    //                   4098 35;
           goto _L1 _L2 _L3
_L1:
        Object obj = focusSearch(view, i);
_L12:
        return ((View) (obj));
_L3:
        if(view == this) {
            int k1 = getChildCount();
            for(int l1 = 0; l1 < k1; l1++) {
                obj = getChildAt(l1);
                if(((View) (obj)).getVisibility() == 0)
                    continue; /* Loop/switch isn't completed */
            }

            obj = focusSearch(this, i);
            continue; /* Loop/switch isn't completed */
        }
        int i1 = getPositionForView(view);
        if(i1 < 0 || i1 >= getCount()) {
            obj = focusSearch(this, i);
            continue; /* Loop/switch isn't completed */
        }
        View view5 = getChildAt(i1 - getFirstVisiblePosition());
        if(view5.getVisibility() == 0 && (view5 instanceof ViewGroup)) {
            ViewGroup viewgroup1 = (ViewGroup)view5;
            View view6 = FocusFinder.getInstance().findNextFocus(viewgroup1, view, i);
            if(view6 != null && view6 != viewgroup1 && view6 != view) {
                obj = view6;
                continue; /* Loop/switch isn't completed */
            }
        }
        for(int j1 = 1 + (i1 - getFirstVisiblePosition()); j1 < getChildCount(); j1++) {
            obj = getChildAt(j1);
            if(((View) (obj)).getVisibility() == 0)
                continue; /* Loop/switch isn't completed */
        }

        obj = focusSearch(this, i);
        continue; /* Loop/switch isn't completed */
_L2:
        int j;
        View view1;
        if(view == this) {
            int l = -1 + getChildCount();
            do {
                if(l < 0)
                    break;
                View view4 = getChildAt(l);
                if(view4.getVisibility() == 0) {
                    obj = focusSearch(view4, i);
                    continue; /* Loop/switch isn't completed */
                }
                l--;
            } while(true);
            obj = focusSearch(this, i);
            continue; /* Loop/switch isn't completed */
        }
        j = getPositionForView(view);
        if(j < 0 || j >= getCount()) {
            obj = focusSearch(this, i);
            continue; /* Loop/switch isn't completed */
        }
        view1 = getChildAt(j - getFirstVisiblePosition());
        if(view1 != view) goto _L5; else goto _L4
_L4:
        int k;
        view1 = null;
        view = null;
        k = -1 + (j - getFirstVisiblePosition());
_L10:
        if(k < 0) goto _L7; else goto _L6
_L6:
        View view3 = getChildAt(k);
        if(view3.getVisibility() != 0) goto _L9; else goto _L8
_L8:
        view1 = view3;
_L7:
        if(view1 != null)
            break; /* Loop/switch isn't completed */
        obj = this;
        continue; /* Loop/switch isn't completed */
_L9:
        k--;
        if(true) goto _L10; else goto _L5
_L5:
        if(view1.getVisibility() == 0) {
            if(view1 instanceof ViewGroup) {
                ViewGroup viewgroup = (ViewGroup)view1;
                View view2 = FocusFinder.getInstance().findNextFocus(viewgroup, view, i);
                if(view2 != null && view2 != viewgroup && view2 != view) {
                    obj = view2;
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj = view1;
        } else {
            obj = focusSearch(this, i);
        }
        if(true) goto _L12; else goto _L11
_L11:
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2, 0);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return new LayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    protected float getBottomFadingEdgeStrength() {
        int i;
        float f;
        i = getChildCount();
        f = getBottomFadingEdgeStrength();
        if(i != 0) goto _L2; else goto _L1
_L1:
        return f;
_L2:
        if(-1 + (i + super.mFirstPosition) < -1 + super.mItemCount) {
            f = 1.0F;
        } else {
            int j = getChildAt(i - 1).getBottom();
            int k = getHeight();
            float f1 = getVerticalFadingEdgeLength();
            if(j > k - super.mPaddingBottom)
                f = (float)((j - k) + super.mPaddingBottom) / f1;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected int getBottomPaddingOffset() {
        int i;
        if((0x22 & super.mGroupFlags) == 34)
            i = 0;
        else
            i = super.mPaddingBottom;
        return i;
    }

    public int getCacheColorHint() {
        return mCacheColorHint;
    }

    public int getCheckedItemCount() {
        return mCheckedItemCount;
    }

    public long[] getCheckedItemIds() {
        long al[];
        if(mChoiceMode == 0 || mCheckedIdStates == null || mAdapter == null) {
            al = new long[0];
        } else {
            LongSparseArray longsparsearray = mCheckedIdStates;
            int i = longsparsearray.size();
            al = new long[i];
            int j = 0;
            while(j < i)  {
                al[j] = longsparsearray.keyAt(j);
                j++;
            }
        }
        return al;
    }

    public int getCheckedItemPosition() {
        int i;
        if(mChoiceMode == 1 && mCheckStates != null && mCheckStates.size() == 1)
            i = mCheckStates.keyAt(0);
        else
            i = -1;
        return i;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        SparseBooleanArray sparsebooleanarray;
        if(mChoiceMode != 0)
            sparsebooleanarray = mCheckStates;
        else
            sparsebooleanarray = null;
        return sparsebooleanarray;
    }

    public int getChoiceMode() {
        return mChoiceMode;
    }

    protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return mContextMenuInfo;
    }

    public void getFocusedRect(Rect rect) {
        View view = getSelectedView();
        if(view != null && view.getParent() == this) {
            view.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(view, rect);
        } else {
            getFocusedRect(rect);
        }
    }

    int getFooterViewsCount() {
        return 0;
    }

    int getHeaderViewsCount() {
        return 0;
    }

    protected int getLeftPaddingOffset() {
        int i;
        if((0x22 & super.mGroupFlags) == 34)
            i = 0;
        else
            i = -super.mPaddingLeft;
        return i;
    }

    public int getListPaddingBottom() {
        return mListPadding.bottom;
    }

    public int getListPaddingLeft() {
        return mListPadding.left;
    }

    public int getListPaddingRight() {
        return mListPadding.right;
    }

    public int getListPaddingTop() {
        return mListPadding.top;
    }

    protected int getRightPaddingOffset() {
        int i;
        if((0x22 & super.mGroupFlags) == 34)
            i = 0;
        else
            i = super.mPaddingRight;
        return i;
    }

    public View getSelectedView() {
        View view;
        if(super.mItemCount > 0 && super.mSelectedPosition >= 0)
            view = getChildAt(super.mSelectedPosition - super.mFirstPosition);
        else
            view = null;
        return view;
    }

    public Drawable getSelector() {
        return mSelector;
    }

    public int getSolidColor() {
        return mCacheColorHint;
    }

    public CharSequence getTextFilter() {
        Editable editable;
        if(mTextFilterEnabled && mTextFilter != null)
            editable = mTextFilter.getText();
        else
            editable = null;
        return editable;
    }

    protected float getTopFadingEdgeStrength() {
        int i;
        float f;
        i = getChildCount();
        f = getTopFadingEdgeStrength();
        if(i != 0) goto _L2; else goto _L1
_L1:
        return f;
_L2:
        if(super.mFirstPosition > 0) {
            f = 1.0F;
        } else {
            int j = getChildAt(0).getTop();
            float f1 = getVerticalFadingEdgeLength();
            if(j < super.mPaddingTop)
                f = (float)(-(j - super.mPaddingTop)) / f1;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected int getTopPaddingOffset() {
        int i;
        if((0x22 & super.mGroupFlags) == 34)
            i = 0;
        else
            i = -super.mPaddingTop;
        return i;
    }

    public int getTranscriptMode() {
        return mTranscriptMode;
    }

    public int getVerticalScrollbarWidth() {
        int i;
        if(isFastScrollAlwaysVisible())
            i = Math.max(getVerticalScrollbarWidth(), mFastScroller.getWidth());
        else
            i = getVerticalScrollbarWidth();
        return i;
    }

    protected void handleDataChanged() {
        int i;
        int j;
        int k;
        i = 3;
        j = super.mItemCount;
        k = mLastHandledItemCount;
        mLastHandledItemCount = super.mItemCount;
        if(mChoiceMode != 0 && mAdapter != null && mAdapter.hasStableIds())
            confirmCheckedPositionsById();
        mRecycler.clearTransientStateViews();
        if(j <= 0) goto _L2; else goto _L1
_L1:
        if(!super.mNeedSync) goto _L4; else goto _L3
_L3:
        super.mNeedSync = false;
        if(mTranscriptMode != 2) goto _L6; else goto _L5
_L5:
        mLayoutMode = i;
_L10:
        return;
_L6:
        if(mTranscriptMode == 1) {
            if(mForceTranscriptScroll) {
                mForceTranscriptScroll = false;
                mLayoutMode = i;
                continue; /* Loop/switch isn't completed */
            }
            int l1 = getChildCount();
            int i2 = getHeight() - getPaddingBottom();
            View view = getChildAt(l1 - 1);
            int j2;
            if(view != null)
                j2 = view.getBottom();
            else
                j2 = i2;
            if(l1 + super.mFirstPosition >= k && j2 <= i2) {
                mLayoutMode = i;
                continue; /* Loop/switch isn't completed */
            }
            awakenScrollBars();
        }
        super.mSyncMode;
        JVM INSTR tableswitch 0 1: default 220
    //                   0 275
    //                   1 372;
           goto _L4 _L7 _L8
_L4:
        if(!isInTouchMode()) {
            int l = getSelectedItemPosition();
            if(l >= j)
                l = j - 1;
            if(l < 0)
                l = 0;
            int i1 = lookForSelectablePosition(l, true);
            int k1;
            if(i1 >= 0) {
                setNextSelectedPositionInt(i1);
                continue; /* Loop/switch isn't completed */
            }
            int j1 = lookForSelectablePosition(l, false);
            if(j1 >= 0) {
                setNextSelectedPositionInt(j1);
                continue; /* Loop/switch isn't completed */
            }
        } else
        if(mResurrectToPosition >= 0)
            continue; /* Loop/switch isn't completed */
          goto _L2
_L7:
        if(isInTouchMode()) {
            mLayoutMode = 5;
            super.mSyncPosition = Math.min(Math.max(0, super.mSyncPosition), j - 1);
            continue; /* Loop/switch isn't completed */
        }
        k1 = findSyncPosition();
        if(k1 >= 0 && lookForSelectablePosition(k1, true) == k1) {
            super.mSyncPosition = k1;
            if(super.mSyncHeight == (long)getHeight())
                mLayoutMode = 5;
            else
                mLayoutMode = 2;
            setNextSelectedPositionInt(k1);
            continue; /* Loop/switch isn't completed */
        }
          goto _L4
_L8:
        mLayoutMode = 5;
        super.mSyncPosition = Math.min(Math.max(0, super.mSyncPosition), j - 1);
        continue; /* Loop/switch isn't completed */
_L2:
        if(!mStackFromBottom)
            i = 1;
        mLayoutMode = i;
        super.mSelectedPosition = -1;
        super.mSelectedRowId = 0x8000000000000000L;
        super.mNextSelectedPosition = -1;
        super.mNextSelectedRowId = 0x8000000000000000L;
        super.mNeedSync = false;
        mSelectorPosition = -1;
        checkSelectionChanged();
        if(true) goto _L10; else goto _L9
_L9:
    }

    public boolean hasTextFilter() {
        return mFiltered;
    }

    void hideSelector() {
        if(super.mSelectedPosition != -1) {
            if(mLayoutMode != 4)
                mResurrectToPosition = super.mSelectedPosition;
            if(super.mNextSelectedPosition >= 0 && super.mNextSelectedPosition != super.mSelectedPosition)
                mResurrectToPosition = super.mNextSelectedPosition;
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            mSelectedTop = 0;
        }
    }

    public void invalidateViews() {
        super.mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
    }

    void invokeOnItemScrollListener() {
        if(mFastScroller != null)
            mFastScroller.onScroll(this, super.mFirstPosition, getChildCount(), super.mItemCount);
        if(mOnScrollListener != null)
            mOnScrollListener.onScroll(this, super.mFirstPosition, getChildCount(), super.mItemCount);
        onScrollChanged(0, 0, 0, 0);
    }

    public boolean isFastScrollAlwaysVisible() {
        boolean flag;
        if(mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFastScrollEnabled() {
        return mFastScrollEnabled;
    }

    protected boolean isInFilterMode() {
        return mFiltered;
    }

    public boolean isItemChecked(int i) {
        boolean flag;
        if(mChoiceMode != 0 && mCheckStates != null)
            flag = mCheckStates.get(i);
        else
            flag = false;
        return flag;
    }

    protected boolean isPaddingOffsetRequired() {
        boolean flag;
        if((0x22 & super.mGroupFlags) != 34)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isScrollingCacheEnabled() {
        return mScrollingCacheEnabled;
    }

    public boolean isSmoothScrollbarEnabled() {
        return mSmoothScrollbarEnabled;
    }

    public boolean isStackFromBottom() {
        return mStackFromBottom;
    }

    public boolean isTextFilterEnabled() {
        return mTextFilterEnabled;
    }

    protected boolean isVerticalScrollBarHidden() {
        boolean flag;
        if(mFastScroller != null && mFastScroller.isVisible())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void jumpDrawablesToCurrentState() {
        jumpDrawablesToCurrentState();
        if(mSelector != null)
            mSelector.jumpToCurrentState();
    }

    void keyPressed() {
        if(isEnabled() && isClickable()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Drawable drawable = mSelector;
        Rect rect = mSelectorRect;
        if(drawable == null || !isFocused() && !touchModeDrawsInPressedState() || rect.isEmpty())
            continue; /* Loop/switch isn't completed */
        View view = getChildAt(super.mSelectedPosition - super.mFirstPosition);
        if(view != null) {
            if(view.hasFocusable())
                continue; /* Loop/switch isn't completed */
            view.setPressed(true);
        }
        setPressed(true);
        boolean flag = isLongClickable();
        Drawable drawable1 = drawable.getCurrent();
        if(drawable1 != null && (drawable1 instanceof TransitionDrawable))
            if(flag)
                ((TransitionDrawable)drawable1).startTransition(ViewConfiguration.getLongPressTimeout());
            else
                ((TransitionDrawable)drawable1).resetTransition();
        if(flag && !super.mDataChanged) {
            if(mPendingCheckForKeyLongPress == null)
                mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
            mPendingCheckForKeyLongPress.rememberWindowAttachCount();
            postDelayed(mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void layoutChildren() {
    }

    View obtainView(int i, boolean aflag[]) {
        View view;
        aflag[0] = false;
        view = mRecycler.getTransientStateView(i);
        if(view == null) goto _L2; else goto _L1
_L1:
        View view2 = view;
_L5:
        return view2;
_L2:
        View view1 = mRecycler.getScrapView(i);
        if(view1 == null) goto _L4; else goto _L3
_L3:
        view2 = mAdapter.getView(i, view1, this);
        if(view2.getImportantForAccessibility() == 0)
            view2.setImportantForAccessibility(1);
        if(view2 != view1) {
            mRecycler.addScrapView(view1, i);
            if(mCacheColorHint != 0)
                view2.setDrawingCacheBackgroundColor(mCacheColorHint);
        } else {
            aflag[0] = true;
            view2.dispatchFinishTemporaryDetach();
        }
_L6:
        if(mAdapterHasStableIds) {
            android.view.ViewGroup.LayoutParams layoutparams = view2.getLayoutParams();
            LayoutParams layoutparams1;
            if(layoutparams == null)
                layoutparams1 = (LayoutParams)generateDefaultLayoutParams();
            else
            if(!checkLayoutParams(layoutparams))
                layoutparams1 = (LayoutParams)generateLayoutParams(layoutparams);
            else
                layoutparams1 = (LayoutParams)layoutparams;
            layoutparams1.itemId = mAdapter.getItemId(i);
            view2.setLayoutParams(layoutparams1);
        }
        if(AccessibilityManager.getInstance(super.mContext).isEnabled()) {
            if(mAccessibilityDelegate == null)
                mAccessibilityDelegate = new ListItemAccessibilityDelegate();
            view2.setAccessibilityDelegate(mAccessibilityDelegate);
        }
        if(true) goto _L5; else goto _L4
_L4:
        view2 = mAdapter.getView(i, null, this);
        if(view2.getImportantForAccessibility() == 0)
            view2.setImportantForAccessibility(1);
        if(mCacheColorHint != 0)
            view2.setDrawingCacheBackgroundColor(mCacheColorHint);
          goto _L6
    }

    protected void onAttachedToWindow() {
        onAttachedToWindow();
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        viewtreeobserver.addOnTouchModeChangeListener(this);
        if(mTextFilterEnabled && mPopup != null && !mGlobalLayoutListenerAddedFilter)
            viewtreeobserver.addOnGlobalLayoutListener(this);
        if(mAdapter != null && mDataSetObserver == null) {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            super.mDataChanged = true;
            super.mOldItemCount = super.mItemCount;
            super.mItemCount = mAdapter.getCount();
        }
        mIsAttached = true;
    }

    protected int[] onCreateDrawableState(int i) {
        if(!mIsChildViewEnabled) goto _L2; else goto _L1
_L1:
        int ai[] = onCreateDrawableState(i);
_L4:
        return ai;
_L2:
        int j = ENABLED_STATE_SET[0];
        ai = onCreateDrawableState(i + 1);
        int k = -1;
        int l = -1 + ai.length;
        do {
label0:
            {
                if(l >= 0) {
                    if(ai[l] != j)
                        break label0;
                    k = l;
                }
                if(k >= 0)
                    System.arraycopy(ai, k + 1, ai, k, -1 + (ai.length - k));
            }
            if(true)
                continue;
            l--;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo) {
        InputConnectionWrapper inputconnectionwrapper;
        if(isTextFilterEnabled()) {
            createTextFilter(false);
            if(mPublicInputConnection == null) {
                mDefInputConnection = new BaseInputConnection(this, false);
                mPublicInputConnection = new InputConnectionWrapper(mTextFilter.onCreateInputConnection(editorinfo), true) {

                    public boolean performEditorAction(int i) {
                        boolean flag = false;
                        if(i == 6) {
                            InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
                            if(inputmethodmanager != null)
                                inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
                            flag = true;
                        }
                        return flag;
                    }

                    public boolean reportFullscreenMode(boolean flag) {
                        return mDefInputConnection.reportFullscreenMode(flag);
                    }

                    public boolean sendKeyEvent(KeyEvent keyevent) {
                        return mDefInputConnection.sendKeyEvent(keyevent);
                    }

                    final AbsListView this$0;

             {
                this$0 = AbsListView.this;
                InputConnectionWrapper(inputconnection, flag);
            }
                };
            }
            editorinfo.inputType = 177;
            editorinfo.imeOptions = 6;
            inputconnectionwrapper = mPublicInputConnection;
        } else {
            inputconnectionwrapper = null;
        }
        return inputconnectionwrapper;
    }

    protected void onDetachedFromWindow() {
        onDetachedFromWindow();
        dismissPopup();
        mRecycler.clear();
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        viewtreeobserver.removeOnTouchModeChangeListener(this);
        if(mTextFilterEnabled && mPopup != null) {
            viewtreeobserver.removeOnGlobalLayoutListener(this);
            mGlobalLayoutListenerAddedFilter = false;
        }
        if(mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            mDataSetObserver = null;
        }
        if(mScrollStrictSpan != null) {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        }
        if(mFlingStrictSpan != null) {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        }
        if(mFlingRunnable != null)
            removeCallbacks(mFlingRunnable);
        if(mPositionScroller != null)
            mPositionScroller.stop();
        if(mClearScrollingCache != null)
            removeCallbacks(mClearScrollingCache);
        if(mPerformClick != null)
            removeCallbacks(mPerformClick);
        if(mTouchModeReset != null) {
            removeCallbacks(mTouchModeReset);
            mTouchModeReset = null;
        }
        mIsAttached = false;
    }

    protected void onDisplayHint(int i) {
        onDisplayHint(i);
        i;
        JVM INSTR lookupswitch 2: default 32
    //                   0: 69
    //                   4: 45;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_69;
_L4:
        boolean flag;
        if(i == 4)
            flag = true;
        else
            flag = false;
        mPopupHidden = flag;
        return;
_L3:
        if(mPopup != null && mPopup.isShowing())
            dismissPopup();
          goto _L4
        if(mFiltered && mPopup != null && !mPopup.isShowing())
            showPopup();
          goto _L4
    }

    public void onFilterComplete(int i) {
        if(super.mSelectedPosition < 0 && i > 0) {
            mResurrectToPosition = -1;
            resurrectSelection();
        }
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect) {
        onFocusChanged(flag, i, rect);
        if(flag && super.mSelectedPosition < 0 && !isInTouchMode()) {
            if(!mIsAttached && mAdapter != null) {
                super.mDataChanged = true;
                super.mOldItemCount = super.mItemCount;
                super.mItemCount = mAdapter.getCount();
            }
            resurrectSelection();
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
        boolean flag = onGenericMotionEvent(motionevent);
_L5:
        return flag;
_L3:
        float f;
        int i;
        if(mTouchMode != -1 || (f = motionevent.getAxisValue(9)) == 0.0F || trackMotionScroll(i = (int)(f * getVerticalScrollFactor()), i))
            continue; /* Loop/switch isn't completed */
        flag = true;
        if(true) goto _L5; else goto _L4
_L4:
        if(true) goto _L2; else goto _L6
_L6:
    }

    public void onGlobalLayout() {
        if(!isShown()) goto _L2; else goto _L1
_L1:
        if(mFiltered && mPopup != null && !mPopup.isShowing() && !mPopupHidden)
            showPopup();
_L4:
        return;
_L2:
        if(mPopup != null && mPopup.isShowing())
            dismissPopup();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/AbsListView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/AbsListView.getName());
        if(isEnabled()) {
            if(getFirstVisiblePosition() > 0)
                accessibilitynodeinfo.addAction(8192);
            if(getLastVisiblePosition() < -1 + getCount())
                accessibilitynodeinfo.addAction(4096);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent) {
        boolean flag;
        int i;
        flag = false;
        i = motionevent.getAction();
        if(mPositionScroller != null)
            mPositionScroller.stop();
        if(mIsAttached) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(mFastScroller != null && mFastScroller.onInterceptTouchEvent(motionevent))
            flag = true;
        else
label0:
            switch(i & 0xff) {
            case 4: // '\004'
            case 5: // '\005'
            default:
                break;

            case 0: // '\0'
                int l = mTouchMode;
                if(l == 6 || l == 5) {
                    mMotionCorrection = 0;
                    flag = true;
                    break;
                }
                int i1 = (int)motionevent.getX();
                int j1 = (int)motionevent.getY();
                mActivePointerId = motionevent.getPointerId(0);
                int k1 = findMotionRow(j1);
                if(l != 4 && k1 >= 0) {
                    mMotionViewOriginalTop = getChildAt(k1 - super.mFirstPosition).getTop();
                    mMotionX = i1;
                    mMotionY = j1;
                    mMotionPosition = k1;
                    mTouchMode = 0;
                    clearScrollingCache();
                }
                mLastY = 0x80000000;
                initOrResetVelocityTracker();
                mVelocityTracker.addMovement(motionevent);
                if(l == 4)
                    flag = true;
                break;

            case 2: // '\002'
                int k;
                switch(mTouchMode) {
                default:
                    break label0;

                case 0: // '\0'
                    int j = motionevent.findPointerIndex(mActivePointerId);
                    if(j == -1) {
                        j = 0;
                        mActivePointerId = motionevent.getPointerId(0);
                    }
                    k = (int)motionevent.getY(j);
                    initVelocityTrackerIfNotExists();
                    mVelocityTracker.addMovement(motionevent);
                    break;
                }
                if(startScrollIfNeeded(k))
                    flag = true;
                break;

            case 1: // '\001'
            case 3: // '\003'
                mTouchMode = -1;
                mActivePointerId = -1;
                recycleVelocityTracker();
                reportScrollStateChange(0);
                break;

            case 6: // '\006'
                onSecondaryPointerUp(motionevent);
                break;
            }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   23: 37
    //                   66: 37;
           goto _L1 _L2 _L2
_L1:
        flag = onKeyUp(i, keyevent);
_L4:
        return flag;
_L2:
        if(isEnabled()) {
            if(!isClickable() || !isPressed() || super.mSelectedPosition < 0 || mAdapter == null || super.mSelectedPosition >= mAdapter.getCount())
                continue; /* Loop/switch isn't completed */
            View view = getChildAt(super.mSelectedPosition - super.mFirstPosition);
            if(view != null) {
                performItemClick(view, super.mSelectedPosition, super.mSelectedRowId);
                view.setPressed(false);
            }
            setPressed(false);
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L1; else goto _L5
_L5:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        onLayout(flag, i, j, k, l);
        super.mInLayout = true;
        if(flag) {
            int i1 = getChildCount();
            for(int j1 = 0; j1 < i1; j1++)
                getChildAt(j1).forceLayout();

            mRecycler.markChildrenDirty();
        }
        if(mFastScroller != null && super.mItemCount != super.mOldItemCount)
            mFastScroller.onItemCountChanged(super.mOldItemCount, super.mItemCount);
        layoutChildren();
        super.mInLayout = false;
        mOverscrollMax = (l - j) / 3;
    }

    protected void onMeasure(int i, int j) {
        boolean flag = true;
        if(mSelector == null)
            useDefaultSelector();
        Rect rect = mListPadding;
        rect.left = mSelectionLeftPadding + super.mPaddingLeft;
        rect.top = mSelectionTopPadding + super.mPaddingTop;
        rect.right = mSelectionRightPadding + super.mPaddingRight;
        rect.bottom = mSelectionBottomPadding + super.mPaddingBottom;
        if(mTranscriptMode == flag) {
            int k = getChildCount();
            int l = getHeight() - getPaddingBottom();
            View view = getChildAt(k - 1);
            int i1;
            if(view != null)
                i1 = view.getBottom();
            else
                i1 = l;
            if(k + super.mFirstPosition < mLastHandledItemCount || i1 > l)
                flag = false;
            mForceTranscriptScroll = flag;
        }
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1) {
        if(super.mScrollY != j) {
            onScrollChanged(super.mScrollX, j, super.mScrollX, super.mScrollY);
            super.mScrollY = j;
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    public boolean onRemoteAdapterConnected() {
        boolean flag = false;
        if(mRemoteAdapter == mAdapter) goto _L2; else goto _L1
_L1:
        setAdapter(mRemoteAdapter);
        if(mDeferNotifyDataSetChanged) {
            mRemoteAdapter.notifyDataSetChanged();
            mDeferNotifyDataSetChanged = false;
        }
_L4:
        return flag;
_L2:
        if(mRemoteAdapter != null) {
            mRemoteAdapter.superNotifyDataSetChanged();
            flag = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onRemoteAdapterDisconnected() {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate;
        savedstate = (SavedState)parcelable;
        onRestoreInstanceState(savedstate.getSuperState());
        super.mDataChanged = true;
        super.mSyncHeight = savedstate.height;
        if(savedstate.selectedId < 0L) goto _L2; else goto _L1
_L1:
        super.mNeedSync = true;
        super.mSyncRowId = savedstate.selectedId;
        super.mSyncPosition = savedstate.position;
        super.mSpecificTop = savedstate.viewTop;
        super.mSyncMode = 0;
_L4:
        setFilterText(savedstate.filter);
        if(savedstate.checkState != null)
            mCheckStates = savedstate.checkState;
        if(savedstate.checkIdState != null)
            mCheckedIdStates = savedstate.checkIdState;
        mCheckedItemCount = savedstate.checkedItemCount;
        if(savedstate.inActionMode && mChoiceMode == 3 && mMultiChoiceModeCallback != null)
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        requestLayout();
        return;
_L2:
        if(savedstate.firstId >= 0L) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            mSelectorPosition = -1;
            super.mNeedSync = true;
            super.mSyncRowId = savedstate.firstId;
            super.mSyncPosition = savedstate.position;
            super.mSpecificTop = savedstate.viewTop;
            super.mSyncMode = 1;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Parcelable onSaveInstanceState() {
        dismissPopup();
        SavedState savedstate = new SavedState(onSaveInstanceState());
        boolean flag;
        long l;
        boolean flag1;
        if(getChildCount() > 0 && super.mItemCount > 0)
            flag = true;
        else
            flag = false;
        l = getSelectedItemId();
        savedstate.selectedId = l;
        savedstate.height = getHeight();
        if(l >= 0L) {
            savedstate.viewTop = mSelectedTop;
            savedstate.position = getSelectedItemPosition();
            savedstate.firstId = -1L;
        } else
        if(flag && super.mFirstPosition > 0) {
            savedstate.viewTop = getChildAt(0).getTop();
            int k = super.mFirstPosition;
            if(k >= super.mItemCount)
                k = -1 + super.mItemCount;
            savedstate.position = k;
            savedstate.firstId = mAdapter.getItemId(k);
        } else {
            savedstate.viewTop = 0;
            savedstate.firstId = -1L;
            savedstate.position = 0;
        }
        savedstate.filter = null;
        if(mFiltered) {
            EditText edittext = mTextFilter;
            if(edittext != null) {
                Editable editable = edittext.getText();
                if(editable != null)
                    savedstate.filter = editable.toString();
            }
        }
        if(mChoiceMode == 3 && mChoiceActionMode != null)
            flag1 = true;
        else
            flag1 = false;
        savedstate.inActionMode = flag1;
        if(mCheckStates != null)
            savedstate.checkState = mCheckStates.clone();
        if(mCheckedIdStates != null) {
            LongSparseArray longsparsearray = new LongSparseArray();
            int i = mCheckedIdStates.size();
            for(int j = 0; j < i; j++)
                longsparsearray.put(mCheckedIdStates.keyAt(j), mCheckedIdStates.valueAt(j));

            savedstate.checkIdState = longsparsearray;
        }
        savedstate.checkedItemCount = mCheckedItemCount;
        return savedstate;
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        if(getChildCount() > 0) {
            super.mDataChanged = true;
            rememberSyncState();
        }
        if(mFastScroller != null)
            mFastScroller.onSizeChanged(i, j, k, l);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k) {
        if(mPopup == null || !isTextFilterEnabled()) goto _L2; else goto _L1
_L1:
        int l;
        boolean flag;
        l = charsequence.length();
        flag = mPopup.isShowing();
        if(flag || l <= 0) goto _L4; else goto _L3
_L3:
        showPopup();
        mFiltered = true;
_L6:
        if(mAdapter instanceof Filterable) {
            Filter filter = ((Filterable)mAdapter).getFilter();
            if(filter == null)
                break; /* Loop/switch isn't completed */
            filter.filter(charsequence, this);
        }
_L2:
        return;
_L4:
        if(flag && l == 0) {
            dismissPopup();
            mFiltered = false;
        }
        if(true) goto _L6; else goto _L5
_L5:
        throw new IllegalStateException("You cannot call onTextChanged with a non filterable adapter");
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        if(isOutOfTouchRange(motionevent))
            flag = true;
        else
        if(!isEnabled()) {
            if(isClickable() || isLongClickable())
                flag = true;
            else
                flag = false;
        } else {
            if(mPositionScroller != null)
                mPositionScroller.stop();
            if(!mIsAttached) {
                flag = false;
            } else {
label0:
                {
                    if(mFastScroller == null || !mFastScroller.onTouchEvent(motionevent))
                        break label0;
                    flag = true;
                }
            }
        }
_L8:
        return flag;
        int i;
        i = motionevent.getAction();
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(motionevent);
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 164
    //                   0 170
    //                   1 606
    //                   2 494
    //                   3 1534
    //                   4 164
    //                   5 1753
    //                   6 1688;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L17:
        flag = true;
          goto _L8
_L2:
        mTouchMode;
        JVM INSTR tableswitch 6 6: default 192
    //                   6 378;
           goto _L9 _L10
_L9:
        int i5;
        int j5;
        int k5;
        mActivePointerId = motionevent.getPointerId(0);
        i5 = (int)motionevent.getX();
        j5 = (int)motionevent.getY();
        k5 = pointToPosition(i5, j5);
        if(super.mDataChanged) goto _L12; else goto _L11
_L11:
        if(mTouchMode == 4 || k5 < 0 || !((ListAdapter)getAdapter()).isEnabled(k5)) goto _L14; else goto _L13
_L13:
        mTouchMode = 0;
        if(mPendingCheckForTap == null) {
            CheckForTap checkfortap = new CheckForTap();
            mPendingCheckForTap = checkfortap;
        }
        postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
_L12:
        if(k5 >= 0)
            mMotionViewOriginalTop = getChildAt(k5 - super.mFirstPosition).getTop();
        mMotionX = i5;
        mMotionY = j5;
        mMotionPosition = k5;
        mLastY = 0x80000000;
_L15:
        if(performButtonActionOnTouchDown(motionevent) && mTouchMode == 0)
            removeCallbacks(mPendingCheckForTap);
          goto _L1
_L10:
        mFlingRunnable.endFling();
        if(mPositionScroller != null)
            mPositionScroller.stop();
        mTouchMode = 5;
        mMotionX = (int)motionevent.getX();
        int l4 = (int)motionevent.getY();
        mLastY = l4;
        mMotionY = l4;
        mMotionCorrection = 0;
        mActivePointerId = motionevent.getPointerId(0);
        mDirection = 0;
        if(true) goto _L15; else goto _L14
_L14:
        if(mTouchMode == 4) {
            createScrollingCache();
            mTouchMode = 3;
            mMotionCorrection = 0;
            k5 = findMotionRow(j5);
            mFlingRunnable.flywheelTouch();
        }
        if(true) goto _L12; else goto _L4
_L4:
        int j4 = motionevent.findPointerIndex(mActivePointerId);
        if(j4 == -1) {
            j4 = 0;
            mActivePointerId = motionevent.getPointerId(0);
        }
        int k4 = (int)motionevent.getY(j4);
        if(super.mDataChanged)
            layoutChildren();
        switch(mTouchMode) {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            startScrollIfNeeded(k4);
            break;

        case 3: // '\003'
        case 5: // '\005'
            scrollIfNeeded(k4);
            break;
        }
_L1:
        if(true) goto _L17; else goto _L16
_L16:
_L3:
        mTouchMode;
        JVM INSTR tableswitch 0 5: default 648
    //                   0 730
    //                   1 730
    //                   2 730
    //                   3 1139
    //                   4 648
    //                   5 1440;
           goto _L18 _L19 _L19 _L19 _L20 _L18 _L21
_L18:
        setPressed(false);
        if(mEdgeGlowTop != null) {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        }
        invalidate();
        Handler handler1 = getHandler();
        if(handler1 != null)
            handler1.removeCallbacks(mPendingCheckForLongPress);
        recycleVelocityTracker();
        mActivePointerId = -1;
        if(mScrollStrictSpan != null) {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        }
          goto _L17
_L19:
        int i4;
        final PerformClick performClick;
        i4 = mMotionPosition;
        final View child = getChildAt(i4 - super.mFirstPosition);
        float f = motionevent.getX();
        boolean flag1;
        PerformClick performclick;
        Handler handler2;
        Runnable runnable;
        Drawable drawable;
        if(f > (float)mListPadding.left && f < (float)(getWidth() - mListPadding.right))
            flag1 = true;
        else
            flag1 = false;
        if(child == null || child.hasFocusable() || !flag1) goto _L23; else goto _L22
_L22:
        if(mTouchMode != 0)
            child.setPressed(false);
        if(mPerformClick == null) {
            performclick = new PerformClick();
            mPerformClick = performclick;
        }
        performClick = mPerformClick;
        performClick.mClickMotionPosition = i4;
        performClick.rememberWindowAttachCount();
        mResurrectToPosition = i4;
        if(mTouchMode != 0 && mTouchMode != 1) goto _L25; else goto _L24
_L24:
        handler2 = getHandler();
        if(handler2 != null) {
            Object obj;
            if(mTouchMode == 0)
                obj = mPendingCheckForTap;
            else
                obj = mPendingCheckForLongPress;
            handler2.removeCallbacks(((Runnable) (obj)));
        }
        mLayoutMode = 0;
        if(!super.mDataChanged && mAdapter.isEnabled(i4)) {
            mTouchMode = 1;
            setSelectedPositionInt(mMotionPosition);
            layoutChildren();
            child.setPressed(true);
            positionSelector(mMotionPosition, child);
            setPressed(true);
            if(mSelector != null) {
                drawable = mSelector.getCurrent();
                if(drawable != null && (drawable instanceof TransitionDrawable))
                    ((TransitionDrawable)drawable).resetTransition();
            }
            if(mTouchModeReset != null)
                removeCallbacks(mTouchModeReset);
            runnable = new Runnable() {

                public void run() {
                    mTouchMode = -1;
                    child.setPressed(false);
                    setPressed(false);
                    if(!mDataChanged)
                        performClick.run();
                }

                final AbsListView this$0;
                final View val$child;
                final PerformClick val$performClick;

             {
                this$0 = AbsListView.this;
                child = view;
                performClick = performclick;
                Object();
            }
            };
            mTouchModeReset = runnable;
            postDelayed(mTouchModeReset, ViewConfiguration.getPressedStateDuration());
        } else {
            mTouchMode = -1;
            updateSelectorState();
        }
        flag = true;
          goto _L8
_L25:
        if(!super.mDataChanged && mAdapter.isEnabled(i4))
            performClick.run();
_L23:
        mTouchMode = -1;
        updateSelectorState();
          goto _L18
_L20:
        int k2 = getChildCount();
        if(k2 > 0) {
            int l2 = getChildAt(0).getTop();
            int i3 = getChildAt(k2 - 1).getBottom();
            int j3 = mListPadding.top;
            int k3 = getHeight() - mListPadding.bottom;
            if(super.mFirstPosition == 0 && l2 >= j3 && k2 + super.mFirstPosition < super.mItemCount && i3 <= getHeight() - k3) {
                mTouchMode = -1;
                reportScrollStateChange(0);
            } else {
                VelocityTracker velocitytracker1 = mVelocityTracker;
                velocitytracker1.computeCurrentVelocity(1000, mMaximumVelocity);
                int l3 = (int)(velocitytracker1.getYVelocity(mActivePointerId) * mVelocityScale);
                if(Math.abs(l3) > mMinimumVelocity && (super.mFirstPosition != 0 || l2 != j3 - mOverscrollDistance) && (k2 + super.mFirstPosition != super.mItemCount || i3 != k3 + mOverscrollDistance)) {
                    if(mFlingRunnable == null) {
                        FlingRunnable flingrunnable2 = new FlingRunnable();
                        mFlingRunnable = flingrunnable2;
                    }
                    reportScrollStateChange(2);
                    mFlingRunnable.start(-l3);
                } else {
                    mTouchMode = -1;
                    reportScrollStateChange(0);
                    if(mFlingRunnable != null)
                        mFlingRunnable.endFling();
                    if(mPositionScroller != null)
                        mPositionScroller.stop();
                }
            }
        } else {
            mTouchMode = -1;
            reportScrollStateChange(0);
        }
          goto _L18
_L21:
        if(mFlingRunnable == null) {
            FlingRunnable flingrunnable1 = new FlingRunnable();
            mFlingRunnable = flingrunnable1;
        }
        VelocityTracker velocitytracker = mVelocityTracker;
        velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
        int j2 = (int)velocitytracker.getYVelocity(mActivePointerId);
        reportScrollStateChange(2);
        if(Math.abs(j2) > mMinimumVelocity)
            mFlingRunnable.startOverfling(-j2);
        else
            mFlingRunnable.startSpringback();
          goto _L18
_L5:
        mTouchMode;
        JVM INSTR tableswitch 5 6: default 1560
    //                   5 1655
    //                   6 1625;
           goto _L26 _L27 _L28
_L28:
        break; /* Loop/switch isn't completed */
_L26:
        mTouchMode = -1;
        setPressed(false);
        View view = getChildAt(mMotionPosition - super.mFirstPosition);
        if(view != null)
            view.setPressed(false);
        clearScrollingCache();
        Handler handler = getHandler();
        if(handler != null)
            handler.removeCallbacks(mPendingCheckForLongPress);
        recycleVelocityTracker();
_L29:
        if(mEdgeGlowTop != null) {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        }
        mActivePointerId = -1;
          goto _L17
_L27:
        if(mFlingRunnable == null) {
            FlingRunnable flingrunnable = new FlingRunnable();
            mFlingRunnable = flingrunnable;
        }
        mFlingRunnable.startSpringback();
          goto _L29
_L7:
        onSecondaryPointerUp(motionevent);
        int k1 = mMotionX;
        int l1 = mMotionY;
        int i2 = pointToPosition(k1, l1);
        if(i2 >= 0) {
            mMotionViewOriginalTop = getChildAt(i2 - super.mFirstPosition).getTop();
            mMotionPosition = i2;
        }
        mLastY = l1;
          goto _L17
_L6:
        int j = motionevent.getActionIndex();
        int k = motionevent.getPointerId(j);
        int l = (int)motionevent.getX(j);
        int i1 = (int)motionevent.getY(j);
        mMotionCorrection = 0;
        mActivePointerId = k;
        mMotionX = l;
        mMotionY = i1;
        int j1 = pointToPosition(l, i1);
        if(j1 >= 0) {
            mMotionViewOriginalTop = getChildAt(j1 - super.mFirstPosition).getTop();
            mMotionPosition = j1;
        }
        mLastY = i1;
          goto _L17
    }

    public void onTouchModeChanged(boolean flag) {
        if(!flag) goto _L2; else goto _L1
_L1:
        hideSelector();
        if(getHeight() > 0 && getChildCount() > 0)
            layoutChildren();
        updateSelectorState();
_L4:
        return;
_L2:
        int i = mTouchMode;
        if(i == 5 || i == 6) {
            if(mFlingRunnable != null)
                mFlingRunnable.endFling();
            if(mPositionScroller != null)
                mPositionScroller.stop();
            if(super.mScrollY != 0) {
                super.mScrollY = 0;
                invalidateParentCaches();
                finishGlows();
                invalidate();
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onWindowFocusChanged(boolean flag) {
        int i;
        onWindowFocusChanged(flag);
        if(isInTouchMode())
            i = 0;
        else
            i = 1;
        if(flag) goto _L2; else goto _L1
_L1:
        setChildrenDrawingCacheEnabled(false);
        if(mFlingRunnable != null) {
            removeCallbacks(mFlingRunnable);
            mFlingRunnable.endFling();
            if(mPositionScroller != null)
                mPositionScroller.stop();
            if(super.mScrollY != 0) {
                super.mScrollY = 0;
                invalidateParentCaches();
                finishGlows();
                invalidate();
            }
        }
        dismissPopup();
        if(i == 1)
            mResurrectToPosition = super.mSelectedPosition;
_L4:
        mLastTouchMode = i;
        return;
_L2:
        if(mFiltered && !mPopupHidden)
            showPopup();
        if(i != mLastTouchMode && mLastTouchMode != -1)
            if(i == 1) {
                resurrectSelection();
            } else {
                hideSelector();
                mLayoutMode = 0;
                layoutChildren();
            }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean flag = true;
        if(!performAccessibilityAction(i, bundle)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        switch(i) {
        default:
            flag = false;
            break;

        case 4096: 
            if(isEnabled() && getLastVisiblePosition() < -1 + getCount())
                smoothScrollBy(getHeight() - mListPadding.top - mListPadding.bottom, 200);
            else
                flag = false;
            break;

        case 8192: 
            if(isEnabled() && super.mFirstPosition > 0)
                smoothScrollBy(-(getHeight() - mListPadding.top - mListPadding.bottom), 200);
            else
                flag = false;
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean performItemClick(View view, int i, long l) {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = true;
        if(mChoiceMode == 0) goto _L2; else goto _L1
_L1:
        boolean flag2;
        flag = true;
        flag2 = false;
        if(mChoiceMode != 2 && (mChoiceMode != 3 || mChoiceActionMode == null)) goto _L4; else goto _L3
_L3:
        boolean flag3;
        if(!mCheckStates.get(i, false))
            flag3 = true;
        else
            flag3 = false;
        mCheckStates.put(i, flag3);
        if(mCheckedIdStates != null && mAdapter.hasStableIds())
            if(flag3)
                mCheckedIdStates.put(mAdapter.getItemId(i), Integer.valueOf(i));
            else
                mCheckedIdStates.delete(mAdapter.getItemId(i));
        if(flag3)
            mCheckedItemCount = 1 + mCheckedItemCount;
        else
            mCheckedItemCount = -1 + mCheckedItemCount;
        if(mChoiceActionMode != null) {
            mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode, i, l, flag3);
            flag1 = false;
        }
        flag2 = true;
_L6:
        if(flag2)
            updateOnScreenCheckedViews();
_L2:
        if(flag1)
            flag |= performItemClick(view, i, l);
        return flag;
_L4:
        if(mChoiceMode != 1)
            continue; /* Loop/switch isn't completed */
        boolean flag4;
        if(!mCheckStates.get(i, false))
            flag4 = true;
        else
            flag4 = false;
        if(!flag4)
            break; /* Loop/switch isn't completed */
        mCheckStates.clear();
        mCheckStates.put(i, true);
        if(mCheckedIdStates != null && mAdapter.hasStableIds()) {
            mCheckedIdStates.clear();
            mCheckedIdStates.put(mAdapter.getItemId(i), Integer.valueOf(i));
        }
        mCheckedItemCount = 1;
_L8:
        flag2 = true;
        if(true) goto _L6; else goto _L5
_L5:
        if(mCheckStates.size() != 0 && mCheckStates.valueAt(0)) goto _L8; else goto _L7
_L7:
        mCheckedItemCount = 0;
          goto _L8
    }

    boolean performLongPress(View view, int i, long l) {
        boolean flag = true;
        if(mChoiceMode != 3) goto _L2; else goto _L1
_L1:
        if(mChoiceActionMode == null) {
            ActionMode actionmode = startActionMode(mMultiChoiceModeCallback);
            mChoiceActionMode = actionmode;
            if(actionmode != null) {
                setItemChecked(i, flag);
                performHapticFeedback(0);
            }
        }
_L4:
        return flag;
_L2:
        flag = false;
        if(super.mOnItemLongClickListener != null)
            flag = super.mOnItemLongClickListener.onItemLongClick(this, view, i, l);
        if(!flag) {
            mContextMenuInfo = createContextMenuInfo(view, i, l);
            flag = showContextMenuForChild(this);
        }
        if(flag)
            performHapticFeedback(0);
        if(true) goto _L4; else goto _L3
_L3:
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

    public long pointToRowId(int i, int j) {
        int k = pointToPosition(i, j);
        long l;
        if(k >= 0)
            l = mAdapter.getItemId(k);
        else
            l = 0x8000000000000000L;
        return l;
    }

    void positionSelector(int i, View view) {
        if(i != -1)
            mSelectorPosition = i;
        Rect rect = mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if(view instanceof SelectionBoundsAdjuster)
            ((SelectionBoundsAdjuster)view).adjustListItemSelectionBounds(rect);
        positionSelector(rect.left, rect.top, rect.right, rect.bottom);
        boolean flag = mIsChildViewEnabled;
        if(view.isEnabled() != flag) {
            boolean flag1;
            if(!flag)
                flag1 = true;
            else
                flag1 = false;
            mIsChildViewEnabled = flag1;
            if(getSelectedItemPosition() != -1)
                refreshDrawableState();
        }
    }

    public void reclaimViews(List list) {
        int i = getChildCount();
        RecyclerListener recyclerlistener = mRecycler.mRecyclerListener;
        for(int j = 0; j < i; j++) {
            View view = getChildAt(j);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if(layoutparams == null || !mRecycler.shouldRecycleViewType(layoutparams.viewType))
                continue;
            list.add(view);
            view.setAccessibilityDelegate(null);
            if(recyclerlistener != null)
                recyclerlistener.onMovedToScrapHeap(view);
        }

        mRecycler.reclaimScrapViews(list);
        removeAllViewsInLayout();
    }

    int reconcileSelectedPosition() {
        int i = super.mSelectedPosition;
        if(i < 0)
            i = mResurrectToPosition;
        return Math.min(Math.max(0, i), -1 + super.mItemCount);
    }

    void reportScrollStateChange(int i) {
        if(i != mLastScrollState && mOnScrollListener != null) {
            mLastScrollState = i;
            mOnScrollListener.onScrollStateChanged(this, i);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean flag) {
        if(flag)
            recycleVelocityTracker();
        requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout() {
        if(!super.mBlockLayoutRequests && !super.mInLayout)
            requestLayout();
    }

    void requestLayoutIfNecessary() {
        if(getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    void resetList() {
        removeAllViewsInLayout();
        super.mFirstPosition = 0;
        super.mDataChanged = false;
        mPositionScrollAfterLayout = null;
        super.mNeedSync = false;
        super.mOldSelectedPosition = -1;
        super.mOldSelectedRowId = 0x8000000000000000L;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        mSelectedTop = 0;
        mSelectorPosition = -1;
        mSelectorRect.setEmpty();
        invalidate();
    }

    boolean resurrectSelection() {
        int i = getChildCount();
        if(i > 0) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L5:
        return flag1;
_L2:
        int j;
        int k;
        int l;
        int i1;
        int j1;
        boolean flag;
        j = 0;
        k = mListPadding.top;
        l = super.mBottom - super.mTop - mListPadding.bottom;
        i1 = super.mFirstPosition;
        j1 = mResurrectToPosition;
        flag = true;
        if(j1 < i1 || j1 >= i1 + i) goto _L4; else goto _L3
_L3:
        int l1;
        int l2;
        l1 = j1;
        View view1 = getChildAt(l1 - super.mFirstPosition);
        j = view1.getTop();
        int k3 = view1.getBottom();
        if(j < k)
            j = k + getVerticalFadingEdgeLength();
        else
        if(k3 > l)
            j = l - view1.getMeasuredHeight() - getVerticalFadingEdgeLength();
_L6:
        mResurrectToPosition = -1;
        removeCallbacks(mFlingRunnable);
        if(mPositionScroller != null)
            mPositionScroller.stop();
        mTouchMode = -1;
        clearScrollingCache();
        super.mSpecificTop = j;
        l2 = lookForSelectablePosition(l1, flag);
        int k1;
        int i2;
        View view;
        int j2;
        int k2;
        int i3;
        int j3;
        if(l2 >= i1 && l2 <= getLastVisiblePosition()) {
            mLayoutMode = 4;
            updateSelectorState();
            setSelectionInt(l2);
            invokeOnItemScrollListener();
        } else {
            l2 = -1;
        }
        reportScrollStateChange(0);
        if(l2 >= 0)
            flag1 = true;
        else
            flag1 = false;
        if(true) goto _L5; else goto _L4
_L4:
        if(j1 >= i1)
            break MISSING_BLOCK_LABEL_328;
        l1 = i1;
        i3 = 0;
_L7:
        if(i3 < i) {
label0:
            {
                j3 = getChildAt(i3).getTop();
                if(i3 == 0) {
                    j = j3;
                    if(i1 > 0 || j3 < k)
                        k += getVerticalFadingEdgeLength();
                }
                if(j3 < k)
                    break label0;
                l1 = i1 + i3;
                j = j3;
            }
        }
          goto _L6
        i3++;
          goto _L7
        k1 = super.mItemCount;
        flag = false;
        l1 = -1 + (i1 + i);
        i2 = i - 1;
_L8:
        if(i2 >= 0) {
label1:
            {
                view = getChildAt(i2);
                j2 = view.getTop();
                k2 = view.getBottom();
                if(i2 == i - 1) {
                    j = j2;
                    if(i1 + i < k1 || k2 > l)
                        l -= getVerticalFadingEdgeLength();
                }
                if(k2 > l)
                    break label1;
                l1 = i1 + i2;
                j = j2;
            }
        }
          goto _L6
        i2--;
          goto _L8
    }

    boolean resurrectSelectionIfNeeded() {
        boolean flag;
        if(super.mSelectedPosition < 0 && resurrectSelection()) {
            updateSelectorState();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void sendAccessibilityEvent(int i) {
        if(i != 4096) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        j = getFirstVisiblePosition();
        k = getLastVisiblePosition();
        if(mLastAccessibilityScrollEventFromIndex != j || mLastAccessibilityScrollEventToIndex != k) goto _L4; else goto _L3
_L3:
        return;
_L4:
        mLastAccessibilityScrollEventFromIndex = j;
        mLastAccessibilityScrollEventToIndex = k;
_L2:
        sendAccessibilityEvent(i);
        if(true) goto _L3; else goto _L5
_L5:
    }

    boolean sendToTextFilter(int i, int j, KeyEvent keyevent) {
        if(acceptFilter()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L7:
        return flag;
_L2:
        boolean flag1;
        flag = false;
        flag1 = true;
        i;
        JVM INSTR lookupswitch 8: default 96
    //                   4: 184
    //                   19: 178
    //                   20: 178
    //                   21: 178
    //                   22: 178
    //                   23: 178
    //                   62: 287
    //                   66: 178;
           goto _L3 _L4 _L5 _L5 _L5 _L5 _L5 _L6 _L5
_L3:
        if(flag1) {
            createTextFilter(true);
            KeyEvent keyevent1 = keyevent;
            if(keyevent1.getRepeatCount() > 0)
                keyevent1 = KeyEvent.changeTimeRepeat(keyevent, keyevent.getEventTime(), 0);
            android.view.KeyEvent.DispatcherState dispatcherstate;
            switch(keyevent.getAction()) {
            case 0: // '\0'
                flag = mTextFilter.onKeyDown(i, keyevent1);
                break;

            case 1: // '\001'
                flag = mTextFilter.onKeyUp(i, keyevent1);
                break;

            case 2: // '\002'
                flag = mTextFilter.onKeyMultiple(i, j, keyevent);
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        if(true) goto _L7; else goto _L5
_L5:
        flag1 = false;
          goto _L3
_L4:
        if(mFiltered && mPopup != null && mPopup.isShowing())
            if(keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0) {
                dispatcherstate = getKeyDispatcherState();
                if(dispatcherstate != null)
                    dispatcherstate.startTracking(keyevent, this);
                flag = true;
            } else
            if(keyevent.getAction() == 1 && keyevent.isTracking() && !keyevent.isCanceled()) {
                flag = true;
                mTextFilter.setText("");
            }
        flag1 = false;
          goto _L3
_L6:
        flag1 = mFiltered;
          goto _L3
        if(true) goto _L9; else goto _L8
_L8:
        break MISSING_BLOCK_LABEL_322;
_L9:
        break; /* Loop/switch isn't completed */
    }

    public volatile void setAdapter(Adapter adapter) {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter) {
        if(listadapter != null) {
            mAdapterHasStableIds = mAdapter.hasStableIds();
            if(mChoiceMode != 0 && mAdapterHasStableIds && mCheckedIdStates == null)
                mCheckedIdStates = new LongSparseArray();
        }
        if(mCheckStates != null)
            mCheckStates.clear();
        if(mCheckedIdStates != null)
            mCheckedIdStates.clear();
    }

    public void setCacheColorHint(int i) {
        if(i != mCacheColorHint) {
            mCacheColorHint = i;
            int j = getChildCount();
            for(int k = 0; k < j; k++)
                getChildAt(k).setDrawingCacheBackgroundColor(i);

            mRecycler.setCacheColorHint(i);
        }
    }

    public void setChoiceMode(int i) {
        mChoiceMode = i;
        if(mChoiceActionMode != null) {
            mChoiceActionMode.finish();
            mChoiceActionMode = null;
        }
        if(mChoiceMode != 0) {
            if(mCheckStates == null)
                mCheckStates = new SparseBooleanArray();
            if(mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds())
                mCheckedIdStates = new LongSparseArray();
            if(mChoiceMode == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean flag) {
        mDrawSelectorOnTop = flag;
    }

    public void setFastScrollAlwaysVisible(boolean flag) {
        if(flag && !mFastScrollEnabled)
            setFastScrollEnabled(true);
        if(mFastScroller != null)
            mFastScroller.setAlwaysShow(flag);
        computeOpaqueFlags();
        recomputePadding();
    }

    public void setFastScrollEnabled(boolean flag) {
        mFastScrollEnabled = flag;
        if(!flag) goto _L2; else goto _L1
_L1:
        if(mFastScroller == null)
            mFastScroller = new FastScroller(getContext(), this);
_L4:
        return;
_L2:
        if(mFastScroller != null) {
            mFastScroller.stop();
            mFastScroller = null;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setFilterText(String s) {
        if(mTextFilterEnabled && !TextUtils.isEmpty(s)) {
            createTextFilter(false);
            mTextFilter.setText(s);
            mTextFilter.setSelection(s.length());
            if(mAdapter instanceof Filterable) {
                if(mPopup == null)
                    ((Filterable)mAdapter).getFilter().filter(s);
                mFiltered = true;
                mDataSetObserver.clearSavedState();
            }
        }
    }

    protected boolean setFrame(int i, int j, int k, int l) {
        boolean flag = setFrame(i, j, k, l);
        if(flag) {
            boolean flag1;
            if(getWindowVisibility() == 0)
                flag1 = true;
            else
                flag1 = false;
            if(mFiltered && flag1 && mPopup != null && mPopup.isShowing())
                positionPopup();
        }
        return flag;
    }

    public void setFriction(float f) {
        if(mFlingRunnable == null)
            mFlingRunnable = new FlingRunnable();
        mFlingRunnable.mScroller.setFriction(f);
    }

    public void setItemChecked(int i, boolean flag) {
        if(mChoiceMode != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(flag && mChoiceMode == 3 && mChoiceActionMode == null)
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        if(mChoiceMode != 2 && mChoiceMode != 3)
            break; /* Loop/switch isn't completed */
        boolean flag1 = mCheckStates.get(i);
        mCheckStates.put(i, flag);
        if(mCheckedIdStates != null && mAdapter.hasStableIds())
            if(flag)
                mCheckedIdStates.put(mAdapter.getItemId(i), Integer.valueOf(i));
            else
                mCheckedIdStates.delete(mAdapter.getItemId(i));
        if(flag1 != flag)
            if(flag)
                mCheckedItemCount = 1 + mCheckedItemCount;
            else
                mCheckedItemCount = -1 + mCheckedItemCount;
        if(mChoiceActionMode != null) {
            long l = mAdapter.getItemId(i);
            mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode, i, l, flag);
        }
_L4:
        if(!super.mInLayout && !super.mBlockLayoutRequests) {
            super.mDataChanged = true;
            rememberSyncState();
            requestLayout();
        }
        if(true) goto _L1; else goto _L3
_L3:
        boolean flag2;
        if(mCheckedIdStates != null && mAdapter.hasStableIds())
            flag2 = true;
        else
            flag2 = false;
        if(flag || isItemChecked(i)) {
            mCheckStates.clear();
            if(flag2)
                mCheckedIdStates.clear();
        }
        if(flag) {
            mCheckStates.put(i, true);
            if(flag2)
                mCheckedIdStates.put(mAdapter.getItemId(i), Integer.valueOf(i));
            mCheckedItemCount = 1;
        } else
        if(mCheckStates.size() == 0 || !mCheckStates.valueAt(0))
            mCheckedItemCount = 0;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void setMultiChoiceModeListener(MultiChoiceModeListener multichoicemodelistener) {
        if(mMultiChoiceModeCallback == null)
            mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        mMultiChoiceModeCallback.setWrapped(multichoicemodelistener);
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener) {
        mOnScrollListener = onscrolllistener;
        invokeOnItemScrollListener();
    }

    public void setOverScrollEffectPadding(int i, int j) {
        mGlowPaddingLeft = i;
        mGlowPaddingRight = j;
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
        setOverScrollMode(i);
    }

    public void setRecyclerListener(RecyclerListener recyclerlistener) {
        mRecycler.mRecyclerListener = recyclerlistener;
    }

    public void setRemoteViewsAdapter(Intent intent) {
        if(mRemoteAdapter == null || !(new FilterComparison(intent)).equals(new FilterComparison(mRemoteAdapter.getRemoteViewsServiceIntent()))) {
            mDeferNotifyDataSetChanged = false;
            mRemoteAdapter = new RemoteViewsAdapter(getContext(), intent, this);
        }
    }

    public void setScrollIndicators(View view, View view1) {
        mScrollUp = view;
        mScrollDown = view1;
    }

    public void setScrollingCacheEnabled(boolean flag) {
        if(mScrollingCacheEnabled && !flag)
            clearScrollingCache();
        mScrollingCacheEnabled = flag;
    }

    abstract void setSelectionInt(int i);

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setSelector(Drawable drawable) {
        if(mSelector != null) {
            mSelector.setCallback(null);
            unscheduleDrawable(mSelector);
        }
        mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        mSelectionLeftPadding = rect.left;
        mSelectionTopPadding = rect.top;
        mSelectionRightPadding = rect.right;
        mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        updateSelectorState();
    }

    public void setSmoothScrollbarEnabled(boolean flag) {
        mSmoothScrollbarEnabled = flag;
    }

    public void setStackFromBottom(boolean flag) {
        if(mStackFromBottom != flag) {
            mStackFromBottom = flag;
            requestLayoutIfNecessary();
        }
    }

    public void setTextFilterEnabled(boolean flag) {
        mTextFilterEnabled = flag;
    }

    public void setTouchPadding(int i, int j) {
        mTouchPaddingLeft = i;
        mTouchPaddingRight = j;
    }

    public void setTranscriptMode(int i) {
        mTranscriptMode = i;
    }

    public void setVelocityScale(float f) {
        mVelocityScale = f;
    }

    public void setVerticalScrollbarPosition(int i) {
        setVerticalScrollbarPosition(i);
        if(mFastScroller != null)
            mFastScroller.setScrollbarPosition(i);
    }

    void setVisibleRangeHint(int i, int j) {
        if(mRemoteAdapter != null)
            mRemoteAdapter.setVisibleRangeHint(i, j);
    }

    boolean shouldShowSelector() {
        boolean flag;
        if(hasFocus() && !isInTouchMode() || touchModeDrawsInPressedState())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean showContextMenu(float f, float f1, int i) {
        int j = pointToPosition((int)f, (int)f1);
        if(j == -1) goto _L2; else goto _L1
_L1:
        long l;
        View view;
        l = mAdapter.getItemId(j);
        view = getChildAt(j - super.mFirstPosition);
        if(view == null) goto _L2; else goto _L3
_L3:
        boolean flag;
        mContextMenuInfo = createContextMenuInfo(view, j, l);
        flag = showContextMenuForChild(this);
_L5:
        return flag;
_L2:
        flag = showContextMenu(f, f1, i);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public boolean showContextMenuForChild(View view) {
        int i = getPositionForView(view);
        boolean flag;
        if(i >= 0) {
            long l = mAdapter.getItemId(i);
            flag = false;
            if(super.mOnItemLongClickListener != null)
                flag = super.mOnItemLongClickListener.onItemLongClick(this, view, i, l);
            if(!flag) {
                mContextMenuInfo = createContextMenuInfo(getChildAt(i - super.mFirstPosition), i, l);
                flag = showContextMenuForChild(view);
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public void smoothScrollBy(int i, int j) {
        smoothScrollBy(i, j, false);
    }

    void smoothScrollBy(int i, int j, boolean flag) {
        if(mFlingRunnable == null)
            mFlingRunnable = new FlingRunnable();
        int k = super.mFirstPosition;
        int l = getChildCount();
        int i1 = k + l;
        int j1 = getPaddingTop();
        int k1 = getHeight() - getPaddingBottom();
        if(i == 0 || super.mItemCount == 0 || l == 0 || k == 0 && getChildAt(0).getTop() == j1 && i < 0 || i1 == super.mItemCount && getChildAt(l - 1).getBottom() == k1 && i > 0) {
            mFlingRunnable.endFling();
            if(mPositionScroller != null)
                mPositionScroller.stop();
        } else {
            reportScrollStateChange(2);
            mFlingRunnable.startScroll(i, j, flag);
        }
    }

    void smoothScrollByOffset(int i) {
        int j = -1;
        if(i < 0)
            j = getFirstVisiblePosition();
        else
        if(i > 0)
            j = getLastVisiblePosition();
        if(j > -1) {
            View view = getChildAt(j - getFirstVisiblePosition());
            if(view != null) {
                Rect rect = new Rect();
                if(view.getGlobalVisibleRect(rect)) {
                    int k = view.getWidth() * view.getHeight();
                    float f = (float)(rect.width() * rect.height()) / (float)k;
                    if(i < 0 && f < 0.75F)
                        j++;
                    else
                    if(i > 0 && f < 0.75F)
                        j--;
                }
                smoothScrollToPosition(Math.max(0, Math.min(getCount(), j + i)));
            }
        }
    }

    public void smoothScrollToPosition(int i) {
        if(mPositionScroller == null)
            mPositionScroller = new PositionScroller();
        mPositionScroller.start(i);
    }

    public void smoothScrollToPosition(int i, int j) {
        if(mPositionScroller == null)
            mPositionScroller = new PositionScroller();
        mPositionScroller.start(i, j);
    }

    public void smoothScrollToPositionFromTop(int i, int j) {
        if(mPositionScroller == null)
            mPositionScroller = new PositionScroller();
        mPositionScroller.startWithOffset(i, j);
    }

    public void smoothScrollToPositionFromTop(int i, int j, int k) {
        if(mPositionScroller == null)
            mPositionScroller = new PositionScroller();
        mPositionScroller.startWithOffset(i, j, k);
    }

    boolean touchModeDrawsInPressedState() {
        mTouchMode;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 32
    //                   2 32;
           goto _L1 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean trackMotionScroll(int i, int j) {
        int k;
        Rect rect;
        int l1;
        int i2;
        int k2;
        int l2;
        int i3;
        boolean flag2;
        k = getChildCount();
        if(k == 0) {
            flag2 = true;
        } else {
label0:
            {
                int l = getChildAt(0).getTop();
                int i1 = getChildAt(k - 1).getBottom();
                rect = mListPadding;
                int j1 = 0;
                int k1 = 0;
                if((0x22 & super.mGroupFlags) == 34) {
                    j1 = rect.top;
                    k1 = rect.bottom;
                }
                l1 = j1 - l;
                i2 = i1 - (getHeight() - k1);
                int j2 = getHeight() - super.mPaddingBottom - super.mPaddingTop;
                boolean flag;
                boolean flag1;
                if(i < 0)
                    k2 = Math.max(-(j2 - 1), i);
                else
                    k2 = Math.min(j2 - 1, i);
                if(j < 0)
                    l2 = Math.max(-(j2 - 1), j);
                else
                    l2 = Math.min(j2 - 1, j);
                i3 = super.mFirstPosition;
                if(i3 == 0)
                    mFirstPositionDistanceGuess = l - rect.top;
                else
                    mFirstPositionDistanceGuess = l2 + mFirstPositionDistanceGuess;
                if(i3 + k == super.mItemCount)
                    mLastPositionDistanceGuess = i1 + rect.bottom;
                else
                    mLastPositionDistanceGuess = l2 + mLastPositionDistanceGuess;
                if(i3 == 0 && l >= rect.top && l2 >= 0)
                    flag = true;
                else
                    flag = false;
                if(i3 + k == super.mItemCount && i1 <= getHeight() - rect.bottom && l2 <= 0)
                    flag1 = true;
                else
                    flag1 = false;
                if(!flag && !flag1)
                    break label0;
                if(l2 != 0)
                    flag2 = true;
                else
                    flag2 = false;
            }
        }
_L6:
        return flag2;
        int j3;
        int k3;
        int l3;
        int i4;
        int i6;
        View view1;
        boolean flag3;
        boolean flag4;
        int i5;
        int k5;
        int l5;
        if(l2 < 0)
            flag3 = true;
        else
            flag3 = false;
        flag4 = isInTouchMode();
        if(flag4)
            hideSelector();
        j3 = getHeaderViewsCount();
        k3 = super.mItemCount - getFooterViewsCount();
        l3 = 0;
        i4 = 0;
        if(!flag3) goto _L2; else goto _L1
_L1:
        l5 = -l2;
        if((0x22 & super.mGroupFlags) == 34)
            l5 += rect.top;
        i6 = 0;
_L7:
        if(i6 >= k) goto _L4; else goto _L3
_L3:
        view1 = getChildAt(i6);
        if(view1.getBottom() < l5) goto _L5; else goto _L4
_L4:
        mMotionViewNewTop = k2 + mMotionViewOriginalTop;
        super.mBlockLayoutRequests = true;
        if(i4 > 0) {
            detachViewsFromParent(l3, i4);
            mRecycler.removeSkippedScrap();
        }
        if(!awakenScrollBars())
            invalidate();
        offsetChildrenTopAndBottom(l2);
        if(flag3)
            super.mFirstPosition = i4 + super.mFirstPosition;
        i5 = Math.abs(l2);
        if(l1 < i5 || i2 < i5)
            fillGap(flag3);
        int j4;
        int k4;
        View view;
        int l4;
        int j6;
        if(!flag4 && super.mSelectedPosition != -1) {
            k5 = super.mSelectedPosition - super.mFirstPosition;
            if(k5 >= 0 && k5 < getChildCount())
                positionSelector(super.mSelectedPosition, getChildAt(k5));
        } else
        if(mSelectorPosition != -1) {
            int j5 = mSelectorPosition - super.mFirstPosition;
            if(j5 >= 0 && j5 < getChildCount())
                positionSelector(-1, getChildAt(j5));
        } else {
            mSelectorRect.setEmpty();
        }
        super.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        flag2 = false;
          goto _L6
_L5:
        i4++;
        j6 = i3 + i6;
        if(j6 >= j3 && j6 < k3)
            mRecycler.addScrapView(view1, j6);
        i6++;
          goto _L7
_L2:
        j4 = getHeight() - l2;
        if((0x22 & super.mGroupFlags) == 34)
            j4 -= rect.bottom;
        k4 = k - 1;
_L10:
        if(k4 < 0) goto _L4; else goto _L8
_L8:
        view = getChildAt(k4);
        if(view.getTop() <= j4) goto _L4; else goto _L9
_L9:
        l3 = k4;
        i4++;
        l4 = i3 + k4;
        if(l4 >= j3 && l4 < k3)
            mRecycler.addScrapView(view, l4);
        k4--;
          goto _L10
    }

    void updateScrollIndicators() {
        int i = 0;
        if(mScrollUp != null) {
            int j;
            View view;
            boolean flag1;
            View view1;
            int k;
            if(super.mFirstPosition > 0)
                flag1 = true;
            else
                flag1 = false;
            if(!flag1 && getChildCount() > 0)
                if(getChildAt(0).getTop() < mListPadding.top)
                    flag1 = true;
                else
                    flag1 = false;
            view1 = mScrollUp;
            if(flag1)
                k = 0;
            else
                k = 4;
            view1.setVisibility(k);
        }
        if(mScrollDown != null) {
            j = getChildCount();
            boolean flag;
            if(j + super.mFirstPosition < super.mItemCount)
                flag = true;
            else
                flag = false;
            if(!flag && j > 0)
                if(getChildAt(j - 1).getBottom() > super.mBottom - mListPadding.bottom)
                    flag = true;
                else
                    flag = false;
            view = mScrollDown;
            if(!flag)
                i = 4;
            view.setVisibility(i);
        }
    }

    void updateSelectorState() {
        if(mSelector != null)
            if(shouldShowSelector())
                mSelector.setState(getDrawableState());
            else
                mSelector.setState(StateSet.NOTHING);
    }

    public boolean verifyDrawable(Drawable drawable) {
        boolean flag;
        if(mSelector == drawable || verifyDrawable(drawable))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int CHOICE_MODE_MULTIPLE = 2;
    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    private static final int INVALID_POINTER = -1;
    static final int LAYOUT_FORCE_BOTTOM = 3;
    static final int LAYOUT_FORCE_TOP = 1;
    static final int LAYOUT_MOVE_SELECTION = 6;
    static final int LAYOUT_NORMAL = 0;
    static final int LAYOUT_SET_SELECTION = 2;
    static final int LAYOUT_SPECIFIC = 4;
    static final int LAYOUT_SYNC = 5;
    static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    private static final boolean PROFILE_FLINGING = false;
    private static final boolean PROFILE_SCROLLING = false;
    private static final String TAG = "AbsListView";
    static final int TOUCH_MODE_DONE_WAITING = 2;
    static final int TOUCH_MODE_DOWN = 0;
    static final int TOUCH_MODE_FLING = 4;
    private static final int TOUCH_MODE_OFF = 1;
    private static final int TOUCH_MODE_ON = 0;
    static final int TOUCH_MODE_OVERFLING = 6;
    static final int TOUCH_MODE_OVERSCROLL = 5;
    static final int TOUCH_MODE_REST = -1;
    static final int TOUCH_MODE_SCROLL = 3;
    static final int TOUCH_MODE_TAP = 1;
    private static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    static final Interpolator sLinearInterpolator = new LinearInterpolator();
    private ListItemAccessibilityDelegate mAccessibilityDelegate;
    private int mActivePointerId;
    ListAdapter mAdapter;
    boolean mAdapterHasStableIds;
    private int mCacheColorHint;
    boolean mCachingActive;
    boolean mCachingStarted;
    SparseBooleanArray mCheckStates;
    LongSparseArray mCheckedIdStates;
    int mCheckedItemCount;
    ActionMode mChoiceActionMode;
    int mChoiceMode;
    private Runnable mClearScrollingCache;
    private android.view.ContextMenu.ContextMenuInfo mContextMenuInfo;
    AdapterDataSetObserver mDataSetObserver;
    private InputConnection mDefInputConnection;
    private boolean mDeferNotifyDataSetChanged;
    private float mDensityScale;
    private int mDirection;
    boolean mDrawSelectorOnTop;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    boolean mFastScrollEnabled;
    private FastScroller mFastScroller;
    private boolean mFiltered;
    private int mFirstPositionDistanceGuess;
    private boolean mFlingProfilingStarted;
    private FlingRunnable mFlingRunnable;
    private android.os.StrictMode.Span mFlingStrictSpan;
    private boolean mForceTranscriptScroll;
    private boolean mGlobalLayoutListenerAddedFilter;
    private int mGlowPaddingLeft;
    private int mGlowPaddingRight;
    boolean mIsAttached;
    private boolean mIsChildViewEnabled;
    final boolean mIsScrap[];
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    private int mLastHandledItemCount;
    private int mLastPositionDistanceGuess;
    private int mLastScrollState;
    private int mLastTouchMode;
    int mLastY;
    int mLayoutMode;
    Rect mListPadding;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    int mMotionCorrection;
    int mMotionPosition;
    int mMotionViewNewTop;
    int mMotionViewOriginalTop;
    int mMotionX;
    int mMotionY;
    MultiChoiceModeWrapper mMultiChoiceModeCallback;
    private OnScrollListener mOnScrollListener;
    int mOverflingDistance;
    int mOverscrollDistance;
    int mOverscrollMax;
    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private Runnable mPendingCheckForTap;
    private PerformClick mPerformClick;
    PopupWindow mPopup;
    private boolean mPopupHidden;
    Runnable mPositionScrollAfterLayout;
    PositionScroller mPositionScroller;
    private InputConnectionWrapper mPublicInputConnection;
    final RecycleBin mRecycler;
    private RemoteViewsAdapter mRemoteAdapter;
    int mResurrectToPosition;
    View mScrollDown;
    private boolean mScrollProfilingStarted;
    private android.os.StrictMode.Span mScrollStrictSpan;
    View mScrollUp;
    boolean mScrollingCacheEnabled;
    int mSelectedTop;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    int mSelectorPosition;
    Rect mSelectorRect;
    private boolean mSmoothScrollbarEnabled;
    boolean mStackFromBottom;
    EditText mTextFilter;
    private boolean mTextFilterEnabled;
    private Rect mTouchFrame;
    int mTouchMode;
    private Runnable mTouchModeReset;
    int mTouchPaddingLeft;
    int mTouchPaddingRight;
    private int mTouchSlop;
    private int mTranscriptMode;
    private float mVelocityScale;
    private VelocityTracker mVelocityTracker;
    int mWidthMeasureSpec;






/*
    static android.os.StrictMode.Span access$1302(AbsListView abslistview, android.os.StrictMode.Span span) {
        abslistview.mFlingStrictSpan = span;
        return span;
    }

*/































/*
    static CheckForLongPress access$502(AbsListView abslistview, CheckForLongPress checkforlongpress) {
        abslistview.mPendingCheckForLongPress = checkforlongpress;
        return checkforlongpress;
    }

*/


}
