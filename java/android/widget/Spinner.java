// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.*;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            AbsSpinner, AdapterView, SpinnerAdapter, Adapter, 
//            ListPopupWindow, ListView, ListAdapter

public class Spinner extends AbsSpinner
    implements android.content.DialogInterface.OnClickListener {
    private class DropdownPopup extends ListPopupWindow
        implements SpinnerPopup {

        public CharSequence getHintText() {
            return mHintText;
        }

        public void setAdapter(ListAdapter listadapter) {
            super.setAdapter(listadapter);
            mAdapter = listadapter;
        }

        public void setPromptText(CharSequence charsequence) {
            mHintText = charsequence;
        }

        public void show() {
            Drawable drawable = getBackground();
            int i = 0;
            int j;
            if(drawable != null) {
                drawable.getPadding(mTempRect);
                i = -mTempRect.left;
            } else {
                Rect rect = mTempRect;
                mTempRect.right = 0;
                rect.left = 0;
            }
            j = getPaddingLeft();
            if(mDropDownWidth == -2) {
                int i1 = getWidth();
                int j1 = getPaddingRight();
                int k1 = measureContentWidth((SpinnerAdapter)mAdapter, getBackground());
                int l1 = setChoiceMode.getResources().getDisplayMetrics().widthPixels - mTempRect.left - mTempRect.right;
                if(k1 > l1)
                    k1 = l1;
                setContentWidth(Math.max(k1, i1 - j - j1));
            } else
            if(mDropDownWidth == -1) {
                int k = getWidth();
                int l = getPaddingRight();
                setContentWidth(k - j - l);
            } else {
                setContentWidth(mDropDownWidth);
            }
            setHorizontalOffset(i + j);
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(1);
            setSelection(getSelectedItemPosition());
        }

        private ListAdapter mAdapter;
        private CharSequence mHintText;
        final Spinner this$0;


        public DropdownPopup(Context context, AttributeSet attributeset, int i) {
            this$0 = Spinner.this;
            super(context, attributeset, 0, i);
            setAnchorView(Spinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView adapterview, View view, int j, long l) {
                    setSelection(j);
                    if(mOnItemClickListener != null)
                        performItemClick(view, j, mAdapter.getItemId(j));
                    dismiss();
                }

                final DropdownPopup this$1;
                final Spinner val$this$0;


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
            });
        }
    }

    private class DialogPopup
        implements SpinnerPopup, android.content.DialogInterface.OnClickListener {

        public void dismiss() {
            mPopup.dismiss();
            mPopup = null;
        }

        public Drawable getBackground() {
            return null;
        }

        public CharSequence getHintText() {
            return mPrompt;
        }

        public int getHorizontalOffset() {
            return 0;
        }

        public int getVerticalOffset() {
            return 0;
        }

        public boolean isShowing() {
            boolean flag;
            if(mPopup != null)
                flag = mPopup.isShowing();
            else
                flag = false;
            return flag;
        }

        public void onClick(DialogInterface dialoginterface, int i) {
            setSelection(i);
            if(mOnItemClickListener != null)
                performItemClick(null, i, mListAdapter.getItemId(i));
            dismiss();
        }

        public void setAdapter(ListAdapter listadapter) {
            mListAdapter = listadapter;
        }

        public void setBackgroundDrawable(Drawable drawable) {
            Log.e("Spinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void setHorizontalOffset(int i) {
            Log.e("Spinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public void setPromptText(CharSequence charsequence) {
            mPrompt = charsequence;
        }

        public void setVerticalOffset(int i) {
            Log.e("Spinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void show() {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
            if(mPrompt != null)
                builder.setTitle(mPrompt);
            mPopup = builder.setSingleChoiceItems(mListAdapter, getSelectedItemPosition(), this).show();
        }

        private ListAdapter mListAdapter;
        private AlertDialog mPopup;
        private CharSequence mPrompt;
        final Spinner this$0;

        private DialogPopup() {
            this$0 = Spinner.this;
            super();
        }

    }

    private static interface SpinnerPopup {

        public abstract void dismiss();

        public abstract Drawable getBackground();

        public abstract CharSequence getHintText();

        public abstract int getHorizontalOffset();

        public abstract int getVerticalOffset();

        public abstract boolean isShowing();

        public abstract void setAdapter(ListAdapter listadapter);

        public abstract void setBackgroundDrawable(Drawable drawable);

        public abstract void setHorizontalOffset(int i);

        public abstract void setPromptText(CharSequence charsequence);

        public abstract void setVerticalOffset(int i);

        public abstract void show();
    }

    private static class DropDownAdapter
        implements ListAdapter, SpinnerAdapter {

        public boolean areAllItemsEnabled() {
            ListAdapter listadapter = mListAdapter;
            boolean flag;
            if(listadapter != null)
                flag = listadapter.areAllItemsEnabled();
            else
                flag = true;
            return flag;
        }

        public int getCount() {
            int i;
            if(mAdapter == null)
                i = 0;
            else
                i = mAdapter.getCount();
            return i;
        }

        public View getDropDownView(int i, View view, ViewGroup viewgroup) {
            View view1;
            if(mAdapter == null)
                view1 = null;
            else
                view1 = mAdapter.getDropDownView(i, view, viewgroup);
            return view1;
        }

        public Object getItem(int i) {
            Object obj;
            if(mAdapter == null)
                obj = null;
            else
                obj = mAdapter.getItem(i);
            return obj;
        }

        public long getItemId(int i) {
            long l;
            if(mAdapter == null)
                l = -1L;
            else
                l = mAdapter.getItemId(i);
            return l;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            return getDropDownView(i, view, viewgroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            boolean flag;
            if(mAdapter != null && mAdapter.hasStableIds())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isEmpty() {
            boolean flag;
            if(getCount() == 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isEnabled(int i) {
            ListAdapter listadapter = mListAdapter;
            boolean flag;
            if(listadapter != null)
                flag = listadapter.isEnabled(i);
            else
                flag = true;
            return flag;
        }

        public void registerDataSetObserver(DataSetObserver datasetobserver) {
            if(mAdapter != null)
                mAdapter.registerDataSetObserver(datasetobserver);
        }

        public void unregisterDataSetObserver(DataSetObserver datasetobserver) {
            if(mAdapter != null)
                mAdapter.unregisterDataSetObserver(datasetobserver);
        }

        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter spinneradapter) {
            mAdapter = spinneradapter;
            if(spinneradapter instanceof ListAdapter)
                mListAdapter = (ListAdapter)spinneradapter;
        }
    }


    public Spinner(Context context) {
        this(context, ((AttributeSet) (null)));
    }

    public Spinner(Context context, int i) {
        this(context, null, 0x1010081, i);
    }

    public Spinner(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010081);
    }

    public Spinner(Context context, AttributeSet attributeset, int i) {
        this(context, attributeset, i, -1);
    }

    public Spinner(Context context, AttributeSet attributeset, int i, int j) {
        TypedArray typedarray;
        super(context, attributeset, i);
        mTempRect = new Rect();
        typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Spinner, i, 0);
        if(j == -1)
            j = typedarray.getInt(7, 0);
        j;
        JVM INSTR tableswitch 0 1: default 72
    //                   0 142
    //                   1 158;
           goto _L1 _L2 _L3
_L1:
        mGravity = typedarray.getInt(0, 17);
        mPopup.setPromptText(typedarray.getString(3));
        mDisableChildrenWhenDisabled = typedarray.getBoolean(9, false);
        typedarray.recycle();
        if(mTempAdapter != null) {
            mPopup.setAdapter(mTempAdapter);
            mTempAdapter = null;
        }
        return;
_L2:
        mPopup = new DialogPopup();
        continue; /* Loop/switch isn't completed */
_L3:
        DropdownPopup dropdownpopup = new DropdownPopup(context, attributeset, i);
        mDropDownWidth = typedarray.getLayoutDimension(4, -2);
        dropdownpopup.setBackgroundDrawable(typedarray.getDrawable(2));
        int k = typedarray.getDimensionPixelOffset(6, 0);
        if(k != 0)
            dropdownpopup.setVerticalOffset(k);
        int l = typedarray.getDimensionPixelOffset(5, 0);
        if(l != 0)
            dropdownpopup.setHorizontalOffset(l);
        mPopup = dropdownpopup;
        if(true) goto _L1; else goto _L4
_L4:
    }

    private View makeAndAddView(int i) {
        if(super.mDataChanged) goto _L2; else goto _L1
_L1:
        View view2 = super.mRecycler.get(i);
        if(view2 == null) goto _L2; else goto _L3
_L3:
        View view1;
        setUpChild(view2);
        view1 = view2;
_L5:
        return view1;
_L2:
        View view = super.mAdapter.getView(i, null, this);
        setUpChild(view);
        view1 = view;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void setUpChild(View view) {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if(layoutparams == null)
            layoutparams = generateDefaultLayoutParams();
        addViewInLayout(view, 0, layoutparams);
        view.setSelected(hasFocus());
        if(mDisableChildrenWhenDisabled)
            view.setEnabled(isEnabled());
        int i = ViewGroup.getChildMeasureSpec(super.mHeightMeasureSpec, super.mSpinnerPadding.top + super.mSpinnerPadding.bottom, layoutparams.height);
        view.measure(ViewGroup.getChildMeasureSpec(super.mWidthMeasureSpec, super.mSpinnerPadding.left + super.mSpinnerPadding.right, layoutparams.width), i);
        int j = super.mSpinnerPadding.top + (getMeasuredHeight() - super.mSpinnerPadding.bottom - super.mSpinnerPadding.top - view.getMeasuredHeight()) / 2;
        int k = j + view.getMeasuredHeight();
        view.layout(0, j, 0 + view.getMeasuredWidth(), k);
    }

    public int getBaseline() {
        int i;
        View view;
        i = -1;
        view = null;
        if(getChildCount() <= 0) goto _L2; else goto _L1
_L1:
        view = getChildAt(0);
_L4:
        if(view != null) {
            int j = view.getBaseline();
            if(j >= 0)
                i = j + view.getTop();
        }
        return i;
_L2:
        if(super.mAdapter != null && super.mAdapter.getCount() > 0) {
            view = makeAndAddView(0);
            super.mRecycler.put(0, view);
            removeAllViewsInLayout();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getDropDownHorizontalOffset() {
        return mPopup.getHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        return mPopup.getVerticalOffset();
    }

    public int getDropDownWidth() {
        return mDropDownWidth;
    }

    public int getGravity() {
        return mGravity;
    }

    public Drawable getPopupBackground() {
        return mPopup.getBackground();
    }

    public CharSequence getPrompt() {
        return mPopup.getHintText();
    }

    void layout(int i, boolean flag) {
        int j;
        int k;
        j = super.mSpinnerPadding.left;
        k = super.mRight - super.mLeft - super.mSpinnerPadding.left - super.mSpinnerPadding.right;
        if(super.mDataChanged)
            handleDataChanged();
        if(super.mItemCount != 0) goto _L2; else goto _L1
_L1:
        resetList();
_L4:
        return;
_L2:
        View view;
        int l;
        int i1;
        if(super.mNextSelectedPosition >= 0)
            setSelectedPositionInt(super.mNextSelectedPosition);
        recycleAllViews();
        removeAllViewsInLayout();
        super.mFirstPosition = super.mSelectedPosition;
        view = makeAndAddView(super.mSelectedPosition);
        l = view.getMeasuredWidth();
        i1 = j;
        switch(7 & mGravity) {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 5: // '\005'
            break;
        }
        break MISSING_BLOCK_LABEL_203;
_L5:
        view.offsetLeftAndRight(i1);
        super.mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        super.mDataChanged = false;
        super.mNeedSync = false;
        setNextSelectedPositionInt(super.mSelectedPosition);
        if(true) goto _L4; else goto _L3
_L3:
        i1 = (j + k / 2) - l / 2;
          goto _L5
        i1 = (j + k) - l;
          goto _L5
    }

    int measureContentWidth(SpinnerAdapter spinneradapter, Drawable drawable) {
        if(spinneradapter != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        i = 0;
        View view = null;
        int j = 0;
        int k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int l = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int i1 = Math.max(0, getSelectedItemPosition());
        int j1 = Math.min(spinneradapter.getCount(), i1 + 15);
        for(int k1 = Math.max(0, i1 - (15 - (j1 - i1))); k1 < j1; k1++) {
            int l1 = spinneradapter.getItemViewType(k1);
            if(l1 != j) {
                j = l1;
                view = null;
            }
            view = spinneradapter.getView(k1, view, this);
            if(view.getLayoutParams() == null)
                view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            view.measure(k, l);
            i = Math.max(i, view.getMeasuredWidth());
        }

        if(drawable != null) {
            drawable.getPadding(mTempRect);
            i += mTempRect.left + mTempRect.right;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onClick(DialogInterface dialoginterface, int i) {
        setSelection(i);
        dialoginterface.dismiss();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mPopup != null && mPopup.isShowing())
            mPopup.dismiss();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/Spinner.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/Spinner.getName());
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        super.onLayout(flag, i, j, k, l);
        super.mInLayout = true;
        layout(0, false);
        super.mInLayout = false;
    }

    protected void onMeasure(int i, int j) {
        super.onMeasure(i, j);
        if(mPopup != null && android.view.View.MeasureSpec.getMode(i) == 0x80000000)
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth(getAdapter(), getBackground())), android.view.View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    public boolean performClick() {
        boolean flag = super.performClick();
        if(!flag) {
            flag = true;
            if(!mPopup.isShowing())
                mPopup.show();
        }
        return flag;
    }

    public volatile void setAdapter(Adapter adapter) {
        setAdapter((SpinnerAdapter)adapter);
    }

    public void setAdapter(SpinnerAdapter spinneradapter) {
        super.setAdapter(spinneradapter);
        if(mPopup != null)
            mPopup.setAdapter(new DropDownAdapter(spinneradapter));
        else
            mTempAdapter = new DropDownAdapter(spinneradapter);
    }

    public void setDropDownHorizontalOffset(int i) {
        mPopup.setHorizontalOffset(i);
    }

    public void setDropDownVerticalOffset(int i) {
        mPopup.setVerticalOffset(i);
    }

    public void setDropDownWidth(int i) {
        if(!(mPopup instanceof DropdownPopup))
            Log.e("Spinner", "Cannot set dropdown width for MODE_DIALOG, ignoring");
        else
            mDropDownWidth = i;
    }

    public void setEnabled(boolean flag) {
        super.setEnabled(flag);
        if(mDisableChildrenWhenDisabled) {
            int i = getChildCount();
            for(int j = 0; j < i; j++)
                getChildAt(j).setEnabled(flag);

        }
    }

    public void setGravity(int i) {
        if(mGravity != i) {
            if((i & 7) == 0)
                i |= 3;
            mGravity = i;
            requestLayout();
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onitemclicklistener) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    public void setOnItemClickListenerInt(AdapterView.OnItemClickListener onitemclicklistener) {
        super.setOnItemClickListener(onitemclicklistener);
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if(!(mPopup instanceof DropdownPopup))
            Log.e("Spinner", "setPopupBackgroundDrawable: incompatible spinner mode; ignoring...");
        else
            ((DropdownPopup)mPopup).setBackgroundDrawable(drawable);
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPrompt(CharSequence charsequence) {
        mPopup.setPromptText(charsequence);
    }

    public void setPromptId(int i) {
        setPrompt(getContext().getText(i));
    }

    private static final int MAX_ITEMS_MEASURED = 15;
    public static final int MODE_DIALOG = 0;
    public static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "Spinner";
    private boolean mDisableChildrenWhenDisabled;
    int mDropDownWidth;
    private int mGravity;
    private SpinnerPopup mPopup;
    private DropDownAdapter mTempAdapter;
    private Rect mTempRect;


}
