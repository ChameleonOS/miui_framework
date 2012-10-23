// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            LinearLayout, RadioButton, CompoundButton

public class RadioGroup extends LinearLayout {
    private class PassThroughHierarchyChangeListener
        implements android.view.ViewGroup.OnHierarchyChangeListener {

        public void onChildViewAdded(View view, View view1) {
            if(view == RadioGroup.this && (view1 instanceof RadioButton)) {
                if(view1.getId() == -1)
                    view1.setId(view1.hashCode());
                ((RadioButton)view1).setOnCheckedChangeWidgetListener(mChildOnCheckedChangeListener);
            }
            if(mOnHierarchyChangeListener != null)
                mOnHierarchyChangeListener.onChildViewAdded(view, view1);
        }

        public void onChildViewRemoved(View view, View view1) {
            if(view == RadioGroup.this && (view1 instanceof RadioButton))
                ((RadioButton)view1).setOnCheckedChangeWidgetListener(null);
            if(mOnHierarchyChangeListener != null)
                mOnHierarchyChangeListener.onChildViewRemoved(view, view1);
        }

        private android.view.ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
        final RadioGroup this$0;


/*
        static android.view.ViewGroup.OnHierarchyChangeListener access$202(PassThroughHierarchyChangeListener passthroughhierarchychangelistener, android.view.ViewGroup.OnHierarchyChangeListener onhierarchychangelistener) {
            passthroughhierarchychangelistener.mOnHierarchyChangeListener = onhierarchychangelistener;
            return onhierarchychangelistener;
        }

*/

        private PassThroughHierarchyChangeListener() {
            this$0 = RadioGroup.this;
            super();
        }

    }

    private class CheckedStateTracker
        implements CompoundButton.OnCheckedChangeListener {

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag) {
            if(!mProtectFromCheckedChange) {
                mProtectFromCheckedChange = true;
                if(mCheckedId != -1)
                    setCheckedStateForView(mCheckedId, false);
                mProtectFromCheckedChange = false;
                int i = compoundbutton.getId();
                setCheckedId(i);
            }
        }

        final RadioGroup this$0;

        private CheckedStateTracker() {
            this$0 = RadioGroup.this;
            super();
        }

    }

    public static interface OnCheckedChangeListener {

        public abstract void onCheckedChanged(RadioGroup radiogroup, int i);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        protected void setBaseAttributes(TypedArray typedarray, int i, int j) {
            if(typedarray.hasValue(i))
                super.width = typedarray.getLayoutDimension(i, "layout_width");
            else
                super.width = -2;
            if(typedarray.hasValue(j))
                super.height = typedarray.getLayoutDimension(j, "layout_height");
            else
                super.height = -2;
        }

        public LayoutParams(int i, int j) {
            super(i, j);
        }

        public LayoutParams(int i, int j, float f) {
            super(i, j, f);
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


    public RadioGroup(Context context) {
        super(context);
        mCheckedId = -1;
        mProtectFromCheckedChange = false;
        setOrientation(1);
        init();
    }

    public RadioGroup(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mCheckedId = -1;
        mProtectFromCheckedChange = false;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.RadioGroup, 0x101007e, 0);
        int i = typedarray.getResourceId(1, -1);
        if(i != -1)
            mCheckedId = i;
        setOrientation(typedarray.getInt(0, 1));
        typedarray.recycle();
        init();
    }

    private void init() {
        mChildOnCheckedChangeListener = new CheckedStateTracker();
        mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(mPassThroughListener);
    }

    private void setCheckedId(int i) {
        mCheckedId = i;
        if(mOnCheckedChangeListener != null)
            mOnCheckedChangeListener.onCheckedChanged(this, mCheckedId);
    }

    private void setCheckedStateForView(int i, boolean flag) {
        View view = findViewById(i);
        if(view != null && (view instanceof RadioButton))
            ((RadioButton)view).setChecked(flag);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        if(view instanceof RadioButton) {
            RadioButton radiobutton = (RadioButton)view;
            if(radiobutton.isChecked()) {
                mProtectFromCheckedChange = true;
                if(mCheckedId != -1)
                    setCheckedStateForView(mCheckedId, false);
                mProtectFromCheckedChange = false;
                setCheckedId(radiobutton.getId());
            }
        }
        super.addView(view, i, layoutparams);
    }

    public void check(int i) {
        if(i == -1 || i != mCheckedId) {
            if(mCheckedId != -1)
                setCheckedStateForView(mCheckedId, false);
            if(i != -1)
                setCheckedStateForView(i, true);
            setCheckedId(i);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    public void clearCheck() {
        check(-1);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    public volatile LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    public int getCheckedRadioButtonId() {
        return mCheckedId;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if(mCheckedId != -1) {
            mProtectFromCheckedChange = true;
            setCheckedStateForView(mCheckedId, true);
            mProtectFromCheckedChange = false;
            setCheckedId(mCheckedId);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/RadioGroup.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/RadioGroup.getName());
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener oncheckedchangelistener) {
        mOnCheckedChangeListener = oncheckedchangelistener;
    }

    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener onhierarchychangelistener) {
        mPassThroughListener.mOnHierarchyChangeListener = onhierarchychangelistener;
    }

    private int mCheckedId;
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private PassThroughHierarchyChangeListener mPassThroughListener;
    private boolean mProtectFromCheckedChange;



/*
    static boolean access$302(RadioGroup radiogroup, boolean flag) {
        radiogroup.mProtectFromCheckedChange = flag;
        return flag;
    }

*/




}
