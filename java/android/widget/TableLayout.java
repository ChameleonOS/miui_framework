// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.regex.Pattern;

// Referenced classes of package android.widget:
//            LinearLayout, TableRow

public class TableLayout extends LinearLayout {
    private class PassThroughHierarchyChangeListener
        implements android.view.ViewGroup.OnHierarchyChangeListener {

        public void onChildViewAdded(View view, View view1) {
            trackCollapsedColumns(view1);
            if(mOnHierarchyChangeListener != null)
                mOnHierarchyChangeListener.onChildViewAdded(view, view1);
        }

        public void onChildViewRemoved(View view, View view1) {
            if(mOnHierarchyChangeListener != null)
                mOnHierarchyChangeListener.onChildViewRemoved(view, view1);
        }

        private android.view.ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
        final TableLayout this$0;


/*
        static android.view.ViewGroup.OnHierarchyChangeListener access$102(PassThroughHierarchyChangeListener passthroughhierarchychangelistener, android.view.ViewGroup.OnHierarchyChangeListener onhierarchychangelistener) {
            passthroughhierarchychangelistener.mOnHierarchyChangeListener = onhierarchychangelistener;
            return onhierarchychangelistener;
        }

*/

        private PassThroughHierarchyChangeListener() {
            this$0 = TableLayout.this;
            super();
        }

    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        protected void setBaseAttributes(TypedArray typedarray, int i, int j) {
            super.width = -1;
            if(typedarray.hasValue(j))
                super.height = typedarray.getLayoutDimension(j, "layout_height");
            else
                super.height = -2;
        }

        public LayoutParams() {
            super(-1, -2);
        }

        public LayoutParams(int i, int j) {
            super(-1, j);
        }

        public LayoutParams(int i, int j, float f) {
            super(-1, j, f);
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
            super(layoutparams);
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams) {
            super(marginlayoutparams);
        }
    }


    public TableLayout(Context context) {
        super(context);
        initTableLayout();
    }

    public TableLayout(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.TableLayout);
        String s = typedarray.getString(0);
        String s1;
        String s2;
        if(s != null)
            if(s.charAt(0) == '*')
                mStretchAllColumns = true;
            else
                mStretchableColumns = parseColumns(s);
        s1 = typedarray.getString(1);
        if(s1 != null)
            if(s1.charAt(0) == '*')
                mShrinkAllColumns = true;
            else
                mShrinkableColumns = parseColumns(s1);
        s2 = typedarray.getString(2);
        if(s2 != null)
            mCollapsedColumns = parseColumns(s2);
        typedarray.recycle();
        initTableLayout();
    }

    private void findLargestCells(int i) {
        boolean flag = true;
        int j = getChildCount();
        int k = 0;
        do {
            if(k >= j)
                break;
            View view = getChildAt(k);
            if(view.getVisibility() != 8 && (view instanceof TableRow)) {
                TableRow tablerow = (TableRow)view;
                tablerow.getLayoutParams().height = -2;
                int ai[] = tablerow.getColumnsWidths(i);
                int l = ai.length;
                if(flag) {
                    if(mMaxWidths == null || mMaxWidths.length != l)
                        mMaxWidths = new int[l];
                    System.arraycopy(ai, 0, mMaxWidths, 0, l);
                    flag = false;
                } else {
                    int i1 = mMaxWidths.length;
                    int j1 = l - i1;
                    if(j1 > 0) {
                        int ai2[] = mMaxWidths;
                        mMaxWidths = new int[l];
                        System.arraycopy(ai2, 0, mMaxWidths, 0, ai2.length);
                        System.arraycopy(ai, ai2.length, mMaxWidths, ai2.length, j1);
                    }
                    int ai1[] = mMaxWidths;
                    int k1 = Math.min(i1, l);
                    int l1 = 0;
                    while(l1 < k1)  {
                        ai1[l1] = Math.max(ai1[l1], ai[l1]);
                        l1++;
                    }
                }
            }
            k++;
        } while(true);
    }

    private void initTableLayout() {
        if(mCollapsedColumns == null)
            mCollapsedColumns = new SparseBooleanArray();
        if(mStretchableColumns == null)
            mStretchableColumns = new SparseBooleanArray();
        if(mShrinkableColumns == null)
            mShrinkableColumns = new SparseBooleanArray();
        mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(mPassThroughListener);
        mInitialized = true;
    }

    private void mutateColumnsWidth(SparseBooleanArray sparsebooleanarray, boolean flag, int i, int j) {
label0:
        {
            int k = 0;
            int ai[] = mMaxWidths;
            int l = ai.length;
            int i1;
            int j1;
            int k1;
            if(flag)
                i1 = l;
            else
                i1 = sparsebooleanarray.size();
            j1 = (i - j) / i1;
            k1 = getChildCount();
            for(int l1 = 0; l1 < k1; l1++) {
                View view = getChildAt(l1);
                if(view instanceof TableRow)
                    view.forceLayout();
            }

            if(!flag) {
                int j2 = 0;
                while(j2 < i1)  {
                    int j3 = sparsebooleanarray.keyAt(j2);
                    if(sparsebooleanarray.valueAt(j2))
                        if(j3 < l)
                            ai[j3] = j1 + ai[j3];
                        else
                            k++;
                    j2++;
                }
            } else {
                for(int i2 = 0; i2 < i1; i2++)
                    ai[i2] = j1 + ai[i2];

                break label0;
            }
            if(k > 0 && k < i1) {
                int k2 = (k * j1) / (i1 - k);
                int l2 = 0;
                while(l2 < i1)  {
                    int i3 = sparsebooleanarray.keyAt(l2);
                    if(sparsebooleanarray.valueAt(l2) && i3 < l)
                        if(k2 > ai[i3])
                            ai[i3] = 0;
                        else
                            ai[i3] = k2 + ai[i3];
                    l2++;
                }
            }
        }
    }

    private static SparseBooleanArray parseColumns(String s) {
        SparseBooleanArray sparsebooleanarray = new SparseBooleanArray();
        String as[] = Pattern.compile("\\s*,\\s*").split(s);
        int i = as.length;
        int j = 0;
        while(j < i)  {
            String s1 = as[j];
            try {
                int k = Integer.parseInt(s1);
                if(k >= 0)
                    sparsebooleanarray.put(k, true);
            }
            catch(NumberFormatException numberformatexception) { }
            j++;
        }
        return sparsebooleanarray;
    }

    private void requestRowsLayout() {
        if(mInitialized) {
            int i = getChildCount();
            for(int j = 0; j < i; j++)
                getChildAt(j).requestLayout();

        }
    }

    private void shrinkAndStretchColumns(int i) {
        if(mMaxWidths != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j = 0;
        int ai[] = mMaxWidths;
        int k = ai.length;
        for(int l = 0; l < k; l++)
            j += ai[l];

        int i1 = android.view.View.MeasureSpec.getSize(i) - super.mPaddingLeft - super.mPaddingRight;
        if(j > i1 && (mShrinkAllColumns || mShrinkableColumns.size() > 0))
            mutateColumnsWidth(mShrinkableColumns, mShrinkAllColumns, i1, j);
        else
        if(j < i1 && (mStretchAllColumns || mStretchableColumns.size() > 0))
            mutateColumnsWidth(mStretchableColumns, mStretchAllColumns, i1, j);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void trackCollapsedColumns(View view) {
        if(view instanceof TableRow) {
            TableRow tablerow = (TableRow)view;
            SparseBooleanArray sparsebooleanarray = mCollapsedColumns;
            int i = sparsebooleanarray.size();
            for(int j = 0; j < i; j++) {
                int k = sparsebooleanarray.keyAt(j);
                boolean flag = sparsebooleanarray.valueAt(j);
                if(flag)
                    tablerow.setColumnCollapsed(k, flag);
            }

        }
    }

    public void addView(View view) {
        super.addView(view);
        requestRowsLayout();
    }

    public void addView(View view, int i) {
        super.addView(view, i);
        requestRowsLayout();
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        super.addView(view, i, layoutparams);
        requestRowsLayout();
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams) {
        super.addView(view, layoutparams);
        requestRowsLayout();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return generateLayoutParams(layoutparams);
    }

    public volatile LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    protected LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return new LayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    public boolean isColumnCollapsed(int i) {
        return mCollapsedColumns.get(i);
    }

    public boolean isColumnShrinkable(int i) {
        boolean flag;
        if(mShrinkAllColumns || mShrinkableColumns.get(i))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isColumnStretchable(int i) {
        boolean flag;
        if(mStretchAllColumns || mStretchableColumns.get(i))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isShrinkAllColumns() {
        return mShrinkAllColumns;
    }

    public boolean isStretchAllColumns() {
        return mStretchAllColumns;
    }

    void measureChildBeforeLayout(View view, int i, int j, int k, int l, int i1) {
        if(view instanceof TableRow)
            ((TableRow)view).setColumnsWidthConstraints(mMaxWidths);
        super.measureChildBeforeLayout(view, i, j, k, l, i1);
    }

    void measureVertical(int i, int j) {
        findLargestCells(i);
        shrinkAndStretchColumns(i);
        super.measureVertical(i, j);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/TableLayout.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/TableLayout.getName());
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        layoutVertical();
    }

    protected void onMeasure(int i, int j) {
        measureVertical(i, j);
    }

    public void requestLayout() {
        if(mInitialized) {
            int i = getChildCount();
            for(int j = 0; j < i; j++)
                getChildAt(j).forceLayout();

        }
        super.requestLayout();
    }

    public void setColumnCollapsed(int i, boolean flag) {
        mCollapsedColumns.put(i, flag);
        int j = getChildCount();
        for(int k = 0; k < j; k++) {
            View view = getChildAt(k);
            if(view instanceof TableRow)
                ((TableRow)view).setColumnCollapsed(i, flag);
        }

        requestRowsLayout();
    }

    public void setColumnShrinkable(int i, boolean flag) {
        mShrinkableColumns.put(i, flag);
        requestRowsLayout();
    }

    public void setColumnStretchable(int i, boolean flag) {
        mStretchableColumns.put(i, flag);
        requestRowsLayout();
    }

    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener onhierarchychangelistener) {
        mPassThroughListener.mOnHierarchyChangeListener = onhierarchychangelistener;
    }

    public void setShrinkAllColumns(boolean flag) {
        mShrinkAllColumns = flag;
    }

    public void setStretchAllColumns(boolean flag) {
        mStretchAllColumns = flag;
    }

    private SparseBooleanArray mCollapsedColumns;
    private boolean mInitialized;
    private int mMaxWidths[];
    private PassThroughHierarchyChangeListener mPassThroughListener;
    private boolean mShrinkAllColumns;
    private SparseBooleanArray mShrinkableColumns;
    private boolean mStretchAllColumns;
    private SparseBooleanArray mStretchableColumns;

}
