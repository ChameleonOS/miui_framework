// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            CompoundButton

public class ToggleButton extends CompoundButton {

    public ToggleButton(Context context) {
        this(context, null);
    }

    public ToggleButton(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101004b);
    }

    public ToggleButton(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ToggleButton, i, 0);
        mTextOn = typedarray.getText(1);
        mTextOff = typedarray.getText(2);
        mDisabledAlpha = typedarray.getFloat(0, 0.5F);
        syncTextState();
        typedarray.recycle();
    }

    private void syncTextState() {
        boolean flag = isChecked();
        if(!flag || mTextOn == null) goto _L2; else goto _L1
_L1:
        setText(mTextOn);
_L4:
        return;
_L2:
        if(!flag && mTextOff != null)
            setText(mTextOff);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void updateReferenceToIndicatorDrawable(Drawable drawable) {
        if(drawable instanceof LayerDrawable)
            mIndicatorDrawable = ((LayerDrawable)drawable).findDrawableByLayerId(0x1020017);
        else
            mIndicatorDrawable = null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mIndicatorDrawable != null) {
            Drawable drawable = mIndicatorDrawable;
            int i;
            if(isEnabled())
                i = 255;
            else
                i = (int)(255F * mDisabledAlpha);
            drawable.setAlpha(i);
        }
    }

    public CharSequence getTextOff() {
        return mTextOff;
    }

    public CharSequence getTextOn() {
        return mTextOn;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        updateReferenceToIndicatorDrawable(getBackground());
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ToggleButton.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ToggleButton.getName());
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        updateReferenceToIndicatorDrawable(drawable);
    }

    public void setChecked(boolean flag) {
        super.setChecked(flag);
        syncTextState();
    }

    public void setTextOff(CharSequence charsequence) {
        mTextOff = charsequence;
    }

    public void setTextOn(CharSequence charsequence) {
        mTextOn = charsequence;
    }

    private static final int NO_ALPHA = 255;
    private float mDisabledAlpha;
    private Drawable mIndicatorDrawable;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
}
