// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;

// Referenced classes of package android.widget:
//            ListView, ExpandableListPosition, ExpandableListAdapter, AdapterView, 
//            ExpandableListConnector, AbsListView, ListAdapter, Adapter

public class ExpandableListView extends ListView {
    static class SavedState extends android.view.View.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(expandedGroupMetadataList);
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
        ArrayList expandedGroupMetadataList;


        private SavedState(Parcel parcel) {
            super(parcel);
            expandedGroupMetadataList = new ArrayList();
            parcel.readList(expandedGroupMetadataList, android/widget/ExpandableListConnector.getClassLoader());
        }


        SavedState(Parcelable parcelable, ArrayList arraylist) {
            super(parcelable);
            expandedGroupMetadataList = arraylist;
        }
    }

    public static class ExpandableListContextMenuInfo
        implements android.view.ContextMenu.ContextMenuInfo {

        public long id;
        public long packedPosition;
        public View targetView;

        public ExpandableListContextMenuInfo(View view, long l, long l1) {
            targetView = view;
            packedPosition = l;
            id = l1;
        }
    }

    public static interface OnChildClickListener {

        public abstract boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l);
    }

    public static interface OnGroupClickListener {

        public abstract boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l);
    }

    public static interface OnGroupExpandListener {

        public abstract void onGroupExpand(int i);
    }

    public static interface OnGroupCollapseListener {

        public abstract void onGroupCollapse(int i);
    }


    public ExpandableListView(Context context) {
        this(context, null);
    }

    public ExpandableListView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101006f);
    }

    public ExpandableListView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mIndicatorRect = new Rect();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ExpandableListView, i, 0);
        mGroupIndicator = typedarray.getDrawable(0);
        mChildIndicator = typedarray.getDrawable(1);
        mIndicatorLeft = typedarray.getDimensionPixelSize(2, 0);
        mIndicatorRight = typedarray.getDimensionPixelSize(3, 0);
        if(mIndicatorRight == 0 && mGroupIndicator != null)
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        mChildIndicatorLeft = typedarray.getDimensionPixelSize(4, -1);
        mChildIndicatorRight = typedarray.getDimensionPixelSize(5, -1);
        mChildDivider = typedarray.getDrawable(6);
        typedarray.recycle();
    }

    private int getAbsoluteFlatPosition(int i) {
        return i + getHeaderViewsCount();
    }

    private long getChildOrGroupId(ExpandableListPosition expandablelistposition) {
        long l;
        if(expandablelistposition.type == 1)
            l = mAdapter.getChildId(expandablelistposition.groupPos, expandablelistposition.childPos);
        else
            l = mAdapter.getGroupId(expandablelistposition.groupPos);
        return l;
    }

    private int getFlatPositionForConnector(int i) {
        return i - getHeaderViewsCount();
    }

    private Drawable getIndicator(ExpandableListConnector.PositionMetadata positionmetadata) {
        boolean flag;
        byte byte0;
        flag = true;
        byte0 = 0;
        if(positionmetadata.position.type != 2) goto _L2; else goto _L1
_L1:
        Drawable drawable;
        drawable = mGroupIndicator;
        if(drawable != null && drawable.isStateful()) {
            boolean flag1;
            int i;
            if(positionmetadata.groupMetadata == null || positionmetadata.groupMetadata.lastChildFlPos == positionmetadata.groupMetadata.flPos)
                flag1 = flag;
            else
                flag1 = false;
            if(!positionmetadata.isExpanded())
                flag = false;
            if(flag1)
                byte0 = 2;
            i = flag | byte0;
            drawable.setState(GROUP_STATE_SETS[i]);
        }
_L4:
        return drawable;
_L2:
        drawable = mChildIndicator;
        if(drawable != null && drawable.isStateful()) {
            int ai[];
            if(positionmetadata.position.flatListPos == positionmetadata.groupMetadata.lastChildFlPos)
                ai = CHILD_LAST_STATE_SET;
            else
                ai = EMPTY_STATE_SET;
            drawable.setState(ai);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static int getPackedPositionChild(long l) {
        int i;
        i = -1;
        break MISSING_BLOCK_LABEL_3;
        if(l != 0xffffffffL && (l & 0x8000000000000000L) == 0x8000000000000000L)
            i = (int)(l & 0xffffffffL);
        return i;
    }

    public static long getPackedPositionForChild(int i, int j) {
        return 0x8000000000000000L | (0x7fffffffL & (long)i) << 32 | -1L & (long)j;
    }

    public static long getPackedPositionForGroup(int i) {
        return (0x7fffffffL & (long)i) << 32;
    }

    public static int getPackedPositionGroup(long l) {
        int i;
        if(l == 0xffffffffL)
            i = -1;
        else
            i = (int)((0x7fffffff00000000L & l) >> 32);
        return i;
    }

    public static int getPackedPositionType(long l) {
        byte byte0;
        if(l == 0xffffffffL)
            byte0 = 2;
        else
        if((l & 0x8000000000000000L) == 0x8000000000000000L)
            byte0 = 1;
        else
            byte0 = 0;
        return byte0;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        int j = super.mItemCount - getFooterViewsCount();
        boolean flag;
        if(i < getHeaderViewsCount() || i >= j)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean collapseGroup(int i) {
        boolean flag = mConnector.collapseGroup(i);
        if(mOnGroupCollapseListener != null)
            mOnGroupCollapseListener.onGroupCollapse(i);
        return flag;
    }

    android.view.ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long l) {
        Object obj;
        if(isHeaderOrFooterPosition(i)) {
            obj = new AdapterView.AdapterContextMenuInfo(view, i, l);
        } else {
            int j = getFlatPositionForConnector(i);
            ExpandableListConnector.PositionMetadata positionmetadata = mConnector.getUnflattenedPos(j);
            ExpandableListPosition expandablelistposition = positionmetadata.position;
            long l1 = getChildOrGroupId(expandablelistposition);
            long l2 = expandablelistposition.getPackedPosition();
            positionmetadata.recycle();
            obj = new ExpandableListContextMenuInfo(view, l2, l1);
        }
        return ((android.view.ContextMenu.ContextMenuInfo) (obj));
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if(mChildIndicator != null || mGroupIndicator != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        boolean flag;
        int k;
        int l;
        int i1;
        Rect rect;
        int k1;
        int l1;
        i = 0;
        int j;
        int j1;
        if((0x22 & super.mGroupFlags) == 34)
            flag = true;
        else
            flag = false;
        if(flag) {
            i = canvas.save();
            int i3 = super.mScrollX;
            int j3 = super.mScrollY;
            canvas.clipRect(i3 + super.mPaddingLeft, j3 + super.mPaddingTop, (i3 + super.mRight) - super.mLeft - super.mPaddingRight, (j3 + super.mBottom) - super.mTop - super.mPaddingBottom);
        }
        j = getHeaderViewsCount();
        k = -1 + (super.mItemCount - getFooterViewsCount() - j);
        l = super.mBottom;
        i1 = -4;
        rect = mIndicatorRect;
        j1 = getChildCount();
        k1 = 0;
        l1 = super.mFirstPosition - j;
        if(k1 >= j1) goto _L4; else goto _L3
_L3:
        if(l1 >= 0) goto _L6; else goto _L5
_L5:
        k1++;
        l1++;
        break MISSING_BLOCK_LABEL_167;
_L6:
        if(l1 <= k)
            break MISSING_BLOCK_LABEL_212;
_L4:
        if(flag)
            canvas.restoreToCount(i);
          goto _L1
        View view = getChildAt(k1);
        int i2 = view.getTop();
        int j2 = view.getBottom();
        if(j2 >= 0 && i2 <= l) {
            ExpandableListConnector.PositionMetadata positionmetadata = mConnector.getUnflattenedPos(l1);
            if(positionmetadata.position.type != i1) {
                if(positionmetadata.position.type == 1) {
                    Drawable drawable;
                    int k2;
                    int l2;
                    if(mChildIndicatorLeft == -1)
                        k2 = mIndicatorLeft;
                    else
                        k2 = mChildIndicatorLeft;
                    rect.left = k2;
                    if(mChildIndicatorRight == -1)
                        l2 = mIndicatorRight;
                    else
                        l2 = mChildIndicatorRight;
                    rect.right = l2;
                } else {
                    rect.left = mIndicatorLeft;
                    rect.right = mIndicatorRight;
                }
                rect.left = rect.left + super.mPaddingLeft;
                rect.right = rect.right + super.mPaddingLeft;
                i1 = positionmetadata.position.type;
            }
            if(rect.left != rect.right) {
                if(super.mStackFromBottom) {
                    rect.top = i2;
                    rect.bottom = j2;
                } else {
                    rect.top = i2;
                    rect.bottom = j2;
                }
                drawable = getIndicator(positionmetadata);
                if(drawable != null) {
                    drawable.setBounds(rect);
                    drawable.draw(canvas);
                }
            }
            positionmetadata.recycle();
        }
          goto _L5
    }

    void drawDivider(Canvas canvas, Rect rect, int i) {
        int j = i + super.mFirstPosition;
        if(j < 0) goto _L2; else goto _L1
_L1:
        ExpandableListConnector.PositionMetadata positionmetadata;
        int k = getFlatPositionForConnector(j);
        positionmetadata = mConnector.getUnflattenedPos(k);
        if(positionmetadata.position.type != 1 && (!positionmetadata.isExpanded() || positionmetadata.groupMetadata.lastChildFlPos == positionmetadata.groupMetadata.flPos)) goto _L4; else goto _L3
_L3:
        Drawable drawable = mChildDivider;
        drawable.setBounds(rect);
        drawable.draw(canvas);
        positionmetadata.recycle();
_L6:
        return;
_L4:
        positionmetadata.recycle();
_L2:
        super.drawDivider(canvas, rect, j);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean expandGroup(int i) {
        return expandGroup(i, false);
    }

    public boolean expandGroup(int i, boolean flag) {
        ExpandableListPosition expandablelistposition = ExpandableListPosition.obtain(2, i, -1, -1);
        ExpandableListConnector.PositionMetadata positionmetadata = mConnector.getFlattenedPos(expandablelistposition);
        expandablelistposition.recycle();
        boolean flag1 = mConnector.expandGroup(positionmetadata);
        if(mOnGroupExpandListener != null)
            mOnGroupExpandListener.onGroupExpand(i);
        if(flag) {
            int j = positionmetadata.position.flatListPos + getHeaderViewsCount();
            smoothScrollToPosition(j + mAdapter.getChildrenCount(i), j);
        }
        positionmetadata.recycle();
        return flag1;
    }

    public volatile Adapter getAdapter() {
        return getAdapter();
    }

    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return mAdapter;
    }

    public long getExpandableListPosition(int i) {
        long l;
        if(isHeaderOrFooterPosition(i)) {
            l = 0xffffffffL;
        } else {
            int j = getFlatPositionForConnector(i);
            ExpandableListConnector.PositionMetadata positionmetadata = mConnector.getUnflattenedPos(j);
            l = positionmetadata.position.getPackedPosition();
            positionmetadata.recycle();
        }
        return l;
    }

    public int getFlatListPosition(long l) {
        ExpandableListPosition expandablelistposition = ExpandableListPosition.obtainPosition(l);
        ExpandableListConnector.PositionMetadata positionmetadata = mConnector.getFlattenedPos(expandablelistposition);
        expandablelistposition.recycle();
        int i = positionmetadata.position.flatListPos;
        positionmetadata.recycle();
        return getAbsoluteFlatPosition(i);
    }

    public long getSelectedId() {
        long l = getSelectedPosition();
        long l1;
        if(l == 0xffffffffL) {
            l1 = -1L;
        } else {
            int i = getPackedPositionGroup(l);
            if(getPackedPositionType(l) == 0)
                l1 = mAdapter.getGroupId(i);
            else
                l1 = mAdapter.getChildId(i, getPackedPositionChild(l));
        }
        return l1;
    }

    public long getSelectedPosition() {
        return getExpandableListPosition(getSelectedItemPosition());
    }

    boolean handleItemClick(View view, int i, long l) {
        ExpandableListConnector.PositionMetadata positionmetadata;
        long l1;
        positionmetadata = mConnector.getUnflattenedPos(i);
        l1 = getChildOrGroupId(positionmetadata.position);
        if(positionmetadata.position.type != 2) goto _L2; else goto _L1
_L1:
        if(mOnGroupClickListener == null || !mOnGroupClickListener.onGroupClick(this, view, positionmetadata.position.groupPos, l1)) goto _L4; else goto _L3
_L3:
        boolean flag;
        positionmetadata.recycle();
        flag = true;
_L5:
        return flag;
_L4:
        if(positionmetadata.isExpanded()) {
            mConnector.collapseGroup(positionmetadata);
            playSoundEffect(0);
            if(mOnGroupCollapseListener != null)
                mOnGroupCollapseListener.onGroupCollapse(positionmetadata.position.groupPos);
        } else {
            mConnector.expandGroup(positionmetadata);
            playSoundEffect(0);
            if(mOnGroupExpandListener != null)
                mOnGroupExpandListener.onGroupExpand(positionmetadata.position.groupPos);
            int j = positionmetadata.position.groupPos;
            int k = positionmetadata.position.flatListPos + getHeaderViewsCount();
            smoothScrollToPosition(k + mAdapter.getChildrenCount(j), k);
        }
        flag = true;
_L6:
        positionmetadata.recycle();
          goto _L5
_L2:
label0:
        {
            if(mOnChildClickListener == null)
                break label0;
            playSoundEffect(0);
            flag = mOnChildClickListener.onChildClick(this, view, positionmetadata.position.groupPos, positionmetadata.position.childPos, l1);
        }
          goto _L5
        flag = false;
          goto _L6
    }

    public boolean isGroupExpanded(int i) {
        return mConnector.isGroupExpanded(i);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ExpandableListView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ExpandableListView.getName());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable instanceof SavedState) goto _L2; else goto _L1
_L1:
        super.onRestoreInstanceState(parcelable);
_L4:
        return;
_L2:
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if(mConnector != null && savedstate.expandedGroupMetadataList != null)
            mConnector.setExpandedGroupMetadataList(savedstate.expandedGroupMetadataList);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        ArrayList arraylist;
        if(mConnector != null)
            arraylist = mConnector.getExpandedGroupMetadataList();
        else
            arraylist = null;
        return new SavedState(parcelable, arraylist);
    }

    public boolean performItemClick(View view, int i, long l) {
        boolean flag;
        if(isHeaderOrFooterPosition(i))
            flag = super.performItemClick(view, i, l);
        else
            flag = handleItemClick(view, getFlatPositionForConnector(i), l);
        return flag;
    }

    public volatile void setAdapter(Adapter adapter) {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ExpandableListAdapter expandablelistadapter) {
        mAdapter = expandablelistadapter;
        if(expandablelistadapter != null)
            mConnector = new ExpandableListConnector(expandablelistadapter);
        else
            mConnector = null;
        super.setAdapter(mConnector);
    }

    public void setAdapter(ListAdapter listadapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    public void setChildDivider(Drawable drawable) {
        mChildDivider = drawable;
    }

    public void setChildIndicator(Drawable drawable) {
        mChildIndicator = drawable;
    }

    public void setChildIndicatorBounds(int i, int j) {
        mChildIndicatorLeft = i;
        mChildIndicatorRight = j;
    }

    public void setGroupIndicator(Drawable drawable) {
        mGroupIndicator = drawable;
        if(mIndicatorRight == 0 && mGroupIndicator != null)
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
    }

    public void setIndicatorBounds(int i, int j) {
        mIndicatorLeft = i;
        mIndicatorRight = j;
    }

    public void setOnChildClickListener(OnChildClickListener onchildclicklistener) {
        mOnChildClickListener = onchildclicklistener;
    }

    public void setOnGroupClickListener(OnGroupClickListener ongroupclicklistener) {
        mOnGroupClickListener = ongroupclicklistener;
    }

    public void setOnGroupCollapseListener(OnGroupCollapseListener ongroupcollapselistener) {
        mOnGroupCollapseListener = ongroupcollapselistener;
    }

    public void setOnGroupExpandListener(OnGroupExpandListener ongroupexpandlistener) {
        mOnGroupExpandListener = ongroupexpandlistener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onitemclicklistener) {
        super.setOnItemClickListener(onitemclicklistener);
    }

    public boolean setSelectedChild(int i, int j, boolean flag) {
        ExpandableListPosition expandablelistposition;
        ExpandableListConnector.PositionMetadata positionmetadata;
        expandablelistposition = ExpandableListPosition.obtainChildPosition(i, j);
        positionmetadata = mConnector.getFlattenedPos(expandablelistposition);
        if(positionmetadata != null) goto _L2; else goto _L1
_L1:
        if(flag) goto _L4; else goto _L3
_L3:
        boolean flag1 = false;
_L6:
        return flag1;
_L4:
        expandGroup(i);
        positionmetadata = mConnector.getFlattenedPos(expandablelistposition);
        if(positionmetadata == null)
            throw new IllegalStateException("Could not find child");
_L2:
        super.setSelection(getAbsoluteFlatPosition(positionmetadata.position.flatListPos));
        expandablelistposition.recycle();
        positionmetadata.recycle();
        flag1 = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void setSelectedGroup(int i) {
        ExpandableListPosition expandablelistposition = ExpandableListPosition.obtainGroupPosition(i);
        ExpandableListConnector.PositionMetadata positionmetadata = mConnector.getFlattenedPos(expandablelistposition);
        expandablelistposition.recycle();
        super.setSelection(getAbsoluteFlatPosition(positionmetadata.position.flatListPos));
        positionmetadata.recycle();
    }

    public static final int CHILD_INDICATOR_INHERIT = -1;
    private static final int CHILD_LAST_STATE_SET[];
    private static final int EMPTY_STATE_SET[];
    private static final int GROUP_EMPTY_STATE_SET[];
    private static final int GROUP_EXPANDED_EMPTY_STATE_SET[];
    private static final int GROUP_EXPANDED_STATE_SET[];
    private static final int GROUP_STATE_SETS[][];
    private static final long PACKED_POSITION_INT_MASK_CHILD = -1L;
    private static final long PACKED_POSITION_INT_MASK_GROUP = 0x7fffffffL;
    private static final long PACKED_POSITION_MASK_CHILD = 0xffffffffL;
    private static final long PACKED_POSITION_MASK_GROUP = 0x7fffffff00000000L;
    private static final long PACKED_POSITION_MASK_TYPE = 0x8000000000000000L;
    private static final long PACKED_POSITION_SHIFT_GROUP = 32L;
    private static final long PACKED_POSITION_SHIFT_TYPE = 63L;
    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    public static final int PACKED_POSITION_TYPE_NULL = 2;
    public static final long PACKED_POSITION_VALUE_NULL = 0xffffffffL;
    private ExpandableListAdapter mAdapter;
    private Drawable mChildDivider;
    private Drawable mChildIndicator;
    private int mChildIndicatorLeft;
    private int mChildIndicatorRight;
    private ExpandableListConnector mConnector;
    private Drawable mGroupIndicator;
    private int mIndicatorLeft;
    private final Rect mIndicatorRect;
    private int mIndicatorRight;
    private OnChildClickListener mOnChildClickListener;
    private OnGroupClickListener mOnGroupClickListener;
    private OnGroupCollapseListener mOnGroupCollapseListener;
    private OnGroupExpandListener mOnGroupExpandListener;

    static  {
        EMPTY_STATE_SET = new int[0];
        int ai[] = new int[1];
        ai[0] = 0x10100a8;
        GROUP_EXPANDED_STATE_SET = ai;
        int ai1[] = new int[1];
        ai1[0] = 0x10100a9;
        GROUP_EMPTY_STATE_SET = ai1;
        int ai2[] = new int[2];
        ai2[0] = 0x10100a8;
        ai2[1] = 0x10100a9;
        GROUP_EXPANDED_EMPTY_STATE_SET = ai2;
        int ai3[][] = new int[4][];
        ai3[0] = EMPTY_STATE_SET;
        ai3[1] = GROUP_EXPANDED_STATE_SET;
        ai3[2] = GROUP_EMPTY_STATE_SET;
        ai3[3] = GROUP_EXPANDED_EMPTY_STATE_SET;
        GROUP_STATE_SETS = ai3;
        int ai4[] = new int[1];
        ai4[0] = 0x10100a6;
        CHILD_LAST_STATE_SET = ai4;
    }
}
