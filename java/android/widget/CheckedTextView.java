// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            TextView, Checkable

public class CheckedTextView extends TextView
    implements Checkable {

    public CheckedTextView(Context context) {
        this(context, null);
    }

    public CheckedTextView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public CheckedTextView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.CheckedTextView, i, 0);
        Drawable drawable = typedarray.getDrawable(1);
        if(drawable != null)
            setCheckMarkDrawable(drawable);
        setChecked(typedarray.getBoolean(0, false));
        typedarray.recycle();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mCheckMarkDrawable != null) {
            int ai[] = getDrawableState();
            mCheckMarkDrawable.setState(ai);
            invalidate();
        }
    }

    public Drawable getCheckMarkDrawable() {
        return mCheckMarkDrawable;
    }

    public boolean isChecked() {
        return mChecked;
    }

    protected int[] onCreateDrawableState(int i) {
        int ai[] = super.onCreateDrawableState(i + 1);
        if(isChecked())
            mergeDrawableStates(ai, CHECKED_STATE_SET);
        return ai;
    }

    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        drawable = mCheckMarkDrawable;
        if(drawable == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        i = 0x70 & getGravity();
        j = drawable.getIntrinsicHeight();
        k = 0;
        i;
        JVM INSTR lookupswitch 2: default 60
    //                   16: 114
    //                   80: 102;
           goto _L3 _L4 _L5
_L3:
        int l = getWidth();
        drawable.setBounds(l - super.mPaddingRight, k, (l - super.mPaddingRight) + mCheckMarkWidth, k + j);
        drawable.draw(canvas);
_L2:
        return;
_L5:
        k = getHeight() - j;
        continue; /* Loop/switch isn't completed */
_L4:
        k = (getHeight() - j) / 2;
        if(true) goto _L3; else goto _L6
_L6:
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/CheckedTextView.getName());
        accessibilityevent.setChecked(mChecked);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/CheckedTextView.getName());
        accessibilitynodeinfo.setCheckable(true);
        accessibilitynodeinfo.setChecked(mChecked);
    }

    public void onPaddingChanged(int i) {
        int j;
        boolean flag;
        boolean flag1;
        if(mCheckMarkDrawable != null)
            j = mCheckMarkWidth + mBasePadding;
        else
            j = mBasePadding;
        flag = mNeedRequestlayout;
        if(super.mPaddingRight != j)
            flag1 = true;
        else
            flag1 = false;
        mNeedRequestlayout = flag1 | flag;
        super.mPaddingRight = j;
        if(mNeedRequestlayout) {
            requestLayout();
            mNeedRequestlayout = false;
        }
    }

    public void setCheckMarkDrawable(int i) {
        if(i == 0 || i != mCheckMarkResource) {
            mCheckMarkResource = i;
            Drawable drawable = null;
            if(mCheckMarkResource != 0)
                drawable = getResources().getDrawable(mCheckMarkResource);
            setCheckMarkDrawable(drawable);
        }
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        boolean flag = true;
        if(mCheckMarkDrawable != null) {
            mCheckMarkDrawable.setCallback(null);
            unscheduleDrawable(mCheckMarkDrawable);
        }
        boolean flag1;
        if(drawable != mCheckMarkDrawable)
            flag1 = flag;
        else
            flag1 = false;
        mNeedRequestlayout = flag1;
        if(drawable != null) {
            drawable.setCallback(this);
            if(getVisibility() != 0)
                flag = false;
            drawable.setVisible(flag, false);
            drawable.setState(CHECKED_STATE_SET);
            setMinHeight(drawable.getIntrinsicHeight());
            mCheckMarkWidth = drawable.getIntrinsicWidth();
            drawable.setState(getDrawableState());
        } else {
            mCheckMarkWidth = 0;
        }
        mCheckMarkDrawable = drawable;
        resolvePadding();
    }

    public void setChecked(boolean flag) {
        if(mChecked != flag) {
            mChecked = flag;
            refreshDrawableState();
            notifyAccessibilityStateChanged();
        }
    }

    public void setPadding(int i, int j, int k, int l) {
        super.setPadding(i, j, k, l);
        mBasePadding = super.mPaddingRight;
    }

    public void setPaddingRelative(int i, int j, int k, int l) {
        super.setPaddingRelative(i, j, k, l);
        mBasePadding = getPaddingEnd();
    }

    public void toggle() {
        boolean flag;
        if(!mChecked)
            flag = true;
        else
            flag = false;
        setChecked(flag);
    }

    private static final int CHECKED_STATE_SET[];
    private int mBasePadding;
    private Drawable mCheckMarkDrawable;
    private int mCheckMarkResource;
    private int mCheckMarkWidth;
    private boolean mChecked;
    private boolean mNeedRequestlayout;

    static  {
        int ai[] = new int[1];
        ai[0] = 0x10100a0;
        CHECKED_STATE_SET = ai;
    }
}
