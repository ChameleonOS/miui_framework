// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            Button, Checkable

public abstract class CompoundButton extends Button
    implements Checkable {
    static class SavedState extends android.view.View.BaseSavedState {

        public String toString() {
            return (new StringBuilder()).append("CompoundButton.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" checked=").append(checked).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(checked));
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
        boolean checked;


        private SavedState(Parcel parcel) {
            super(parcel);
            checked = ((Boolean)parcel.readValue(null)).booleanValue();
        }


        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static interface OnCheckedChangeListener {

        public abstract void onCheckedChanged(CompoundButton compoundbutton, boolean flag);
    }


    public CompoundButton(Context context) {
        this(context, null);
    }

    public CompoundButton(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public CompoundButton(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.CompoundButton, i, 0);
        Drawable drawable = typedarray.getDrawable(1);
        if(drawable != null)
            setButtonDrawable(drawable);
        setChecked(typedarray.getBoolean(0, false));
        typedarray.recycle();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mButtonDrawable != null) {
            int ai[] = getDrawableState();
            mButtonDrawable.setState(ai);
            invalidate();
        }
    }

    public boolean isChecked() {
        return mChecked;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if(mButtonDrawable != null)
            mButtonDrawable.jumpToCurrentState();
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
        drawable = mButtonDrawable;
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
    //                   16: 94
    //                   80: 82;
           goto _L3 _L4 _L5
_L3:
        drawable.setBounds(0, k, drawable.getIntrinsicWidth(), k + j);
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
        accessibilityevent.setClassName(android/widget/CompoundButton.getName());
        accessibilityevent.setChecked(mChecked);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/CompoundButton.getName());
        accessibilitynodeinfo.setCheckable(true);
        accessibilitynodeinfo.setChecked(mChecked);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        setChecked(savedstate.checked);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        setFreezesText(true);
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.checked = isChecked();
        return savedstate;
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setButtonDrawable(int i) {
        if(i == 0 || i != mButtonResource) {
            mButtonResource = i;
            Drawable drawable = null;
            if(mButtonResource != 0)
                drawable = getResources().getDrawable(mButtonResource);
            setButtonDrawable(drawable);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        if(drawable != null) {
            if(mButtonDrawable != null) {
                mButtonDrawable.setCallback(null);
                unscheduleDrawable(mButtonDrawable);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            boolean flag;
            if(getVisibility() == 0)
                flag = true;
            else
                flag = false;
            drawable.setVisible(flag, false);
            mButtonDrawable = drawable;
            mButtonDrawable.setState(null);
            setMinHeight(mButtonDrawable.getIntrinsicHeight());
        }
        refreshDrawableState();
    }

    public void setChecked(boolean flag) {
        if(mChecked != flag) {
            mChecked = flag;
            refreshDrawableState();
            notifyAccessibilityStateChanged();
            if(!mBroadcasting) {
                mBroadcasting = true;
                if(mOnCheckedChangeListener != null)
                    mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
                if(mOnCheckedChangeWidgetListener != null)
                    mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
                mBroadcasting = false;
            }
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener oncheckedchangelistener) {
        mOnCheckedChangeListener = oncheckedchangelistener;
    }

    void setOnCheckedChangeWidgetListener(OnCheckedChangeListener oncheckedchangelistener) {
        mOnCheckedChangeWidgetListener = oncheckedchangelistener;
    }

    public void toggle() {
        boolean flag;
        if(!mChecked)
            flag = true;
        else
            flag = false;
        setChecked(flag);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean flag;
        if(super.verifyDrawable(drawable) || drawable == mButtonDrawable)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final int CHECKED_STATE_SET[];
    private boolean mBroadcasting;
    private Drawable mButtonDrawable;
    private int mButtonResource;
    private boolean mChecked;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;

    static  {
        int ai[] = new int[1];
        ai[0] = 0x10100a0;
        CHECKED_STATE_SET = ai;
    }
}
