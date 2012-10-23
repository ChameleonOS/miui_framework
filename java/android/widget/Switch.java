// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.text.*;
import android.text.method.AllCapsTransformationMethod;
import android.text.method.TransformationMethod2;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

// Referenced classes of package android.widget:
//            CompoundButton

public class Switch extends CompoundButton {

    public Switch(Context context) {
        this(context, null);
    }

    public Switch(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x10103da);
    }

    public Switch(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mVelocityTracker = VelocityTracker.obtain();
        mTempRect = new Rect();
        mTextPaint = new TextPaint(1);
        Resources resources = getResources();
        mTextPaint.density = resources.getDisplayMetrics().density;
        mTextPaint.setCompatibilityScaling(resources.getCompatibilityInfo().applicationScale);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Switch, i, 0);
        mThumbDrawable = typedarray.getDrawable(2);
        mTrackDrawable = typedarray.getDrawable(4);
        mTextOn = typedarray.getText(0);
        mTextOff = typedarray.getText(1);
        mThumbTextPadding = typedarray.getDimensionPixelSize(7, 0);
        mSwitchMinWidth = typedarray.getDimensionPixelSize(5, 0);
        mSwitchPadding = typedarray.getDimensionPixelSize(6, 0);
        int j = typedarray.getResourceId(3, 0);
        if(j != 0)
            setSwitchTextAppearance(context, j);
        typedarray.recycle();
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        mTouchSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void animateThumbToCheckedState(boolean flag) {
        setChecked(flag);
    }

    private void cancelSuperTouch(MotionEvent motionevent) {
        MotionEvent motionevent1 = MotionEvent.obtain(motionevent);
        motionevent1.setAction(3);
        super.onTouchEvent(motionevent1);
        motionevent1.recycle();
    }

    private boolean getTargetCheckedState() {
        boolean flag;
        if(mThumbPosition >= (float)(getThumbScrollRange() / 2))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private int getThumbScrollRange() {
        int i;
        if(mTrackDrawable == null) {
            i = 0;
        } else {
            mTrackDrawable.getPadding(mTempRect);
            i = mSwitchWidth - mThumbWidth - mTempRect.left - mTempRect.right;
        }
        return i;
    }

    private boolean hitThumb(float f, float f1) {
        mThumbDrawable.getPadding(mTempRect);
        int i = mSwitchTop - mTouchSlop;
        int j = (mSwitchLeft + (int)(0.5F + mThumbPosition)) - mTouchSlop;
        int k = j + mThumbWidth + mTempRect.left + mTempRect.right + mTouchSlop;
        int l = mSwitchBottom + mTouchSlop;
        boolean flag;
        if(f > (float)j && f < (float)k && f1 > (float)i && f1 < (float)l)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private Layout makeLayout(CharSequence charsequence) {
        CharSequence charsequence1;
        if(mSwitchTransformationMethod != null)
            charsequence1 = mSwitchTransformationMethod.getTransformation(charsequence, this);
        else
            charsequence1 = charsequence;
        return new StaticLayout(charsequence1, mTextPaint, (int)Math.ceil(Layout.getDesiredWidth(charsequence1, mTextPaint)), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }

    private void setSwitchTypefaceByIndex(int i, int j) {
        Typeface typeface = null;
        i;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 35
    //                   2 42
    //                   3 49;
           goto _L1 _L2 _L3 _L4
_L1:
        setSwitchTypeface(typeface, j);
        return;
_L2:
        typeface = Typeface.SANS_SERIF;
        continue; /* Loop/switch isn't completed */
_L3:
        typeface = Typeface.SERIF;
        continue; /* Loop/switch isn't completed */
_L4:
        typeface = Typeface.MONOSPACE;
        if(true) goto _L1; else goto _L5
_L5:
    }

    private void stopDrag(MotionEvent motionevent) {
        mTouchMode = 0;
        boolean flag;
        if(motionevent.getAction() == 1 && isEnabled())
            flag = true;
        else
            flag = false;
        cancelSuperTouch(motionevent);
        if(flag) {
            mVelocityTracker.computeCurrentVelocity(1000);
            float f = mVelocityTracker.getXVelocity();
            boolean flag1;
            if(Math.abs(f) > (float)mMinFlingVelocity) {
                if(f > 0.0F)
                    flag1 = true;
                else
                    flag1 = false;
            } else {
                flag1 = getTargetCheckedState();
            }
            animateThumbToCheckedState(flag1);
        } else {
            animateThumbToCheckedState(isChecked());
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int ai[] = getDrawableState();
        if(mThumbDrawable != null)
            mThumbDrawable.setState(ai);
        if(mTrackDrawable != null)
            mTrackDrawable.setState(ai);
        invalidate();
    }

    public int getCompoundPaddingRight() {
        int i = super.getCompoundPaddingRight() + mSwitchWidth;
        if(!TextUtils.isEmpty(getText()))
            i += mSwitchPadding;
        return i;
    }

    public int getSwitchMinWidth() {
        return mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return mTextOff;
    }

    public CharSequence getTextOn() {
        return mTextOn;
    }

    public Drawable getThumbDrawable() {
        return mThumbDrawable;
    }

    public int getThumbTextPadding() {
        return mThumbTextPadding;
    }

    public Drawable getTrackDrawable() {
        return mTrackDrawable;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mThumbDrawable.jumpToCurrentState();
        mTrackDrawable.jumpToCurrentState();
    }

    protected int[] onCreateDrawableState(int i) {
        int ai[] = super.onCreateDrawableState(i + 1);
        if(isChecked())
            mergeDrawableStates(ai, CHECKED_STATE_SET);
        return ai;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = mSwitchLeft;
        int j = mSwitchTop;
        int k = mSwitchRight;
        int l = mSwitchBottom;
        mTrackDrawable.setBounds(i, j, k, l);
        mTrackDrawable.draw(canvas);
        canvas.save();
        mTrackDrawable.getPadding(mTempRect);
        int i1 = i + mTempRect.left;
        int j1 = j + mTempRect.top;
        int k1 = k - mTempRect.right;
        int l1 = l - mTempRect.bottom;
        canvas.clipRect(i1, j, k1, l);
        mThumbDrawable.getPadding(mTempRect);
        int i2 = (int)(0.5F + mThumbPosition);
        int j2 = i2 + (i1 - mTempRect.left);
        int k2 = i1 + i2 + mThumbWidth + mTempRect.right;
        mThumbDrawable.setBounds(j2, j, k2, l);
        mThumbDrawable.draw(canvas);
        if(mTextColors != null)
            mTextPaint.setColor(mTextColors.getColorForState(getDrawableState(), mTextColors.getDefaultColor()));
        mTextPaint.drawableState = getDrawableState();
        Layout layout;
        if(getTargetCheckedState())
            layout = mOnLayout;
        else
            layout = mOffLayout;
        canvas.translate((j2 + k2) / 2 - layout.getWidth() / 2, (j1 + l1) / 2 - layout.getHeight() / 2);
        layout.draw(canvas);
        canvas.restore();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/Switch.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/Switch.getName());
        CharSequence charsequence;
        if(isChecked())
            charsequence = mTextOn;
        else
            charsequence = mTextOff;
        if(!TextUtils.isEmpty(charsequence)) {
            CharSequence charsequence1 = accessibilitynodeinfo.getText();
            if(TextUtils.isEmpty(charsequence1)) {
                accessibilitynodeinfo.setText(charsequence);
            } else {
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(charsequence1).append(' ').append(charsequence);
                accessibilitynodeinfo.setText(stringbuilder);
            }
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        int k1;
        int l1;
        super.onLayout(flag, i, j, k, l);
        float f;
        int i1;
        int j1;
        if(isChecked())
            f = getThumbScrollRange();
        else
            f = 0.0F;
        mThumbPosition = f;
        i1 = getWidth() - getPaddingRight();
        j1 = i1 - mSwitchWidth;
        0x70 & getGravity();
        JVM INSTR lookupswitch 2: default 84
    //                   16: 130
    //                   80: 167;
           goto _L1 _L2 _L3
_L1:
        l1 = getPaddingTop();
        k1 = l1 + mSwitchHeight;
_L5:
        mSwitchLeft = j1;
        mSwitchTop = l1;
        mSwitchBottom = k1;
        mSwitchRight = i1;
        return;
_L2:
        l1 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2 - mSwitchHeight / 2;
        k1 = l1 + mSwitchHeight;
        continue; /* Loop/switch isn't completed */
_L3:
        k1 = getHeight() - getPaddingBottom();
        l1 = k1 - mSwitchHeight;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void onMeasure(int i, int j) {
        int k;
        int l;
        int i1;
        int j1;
        int l1;
        int i2;
        k = android.view.View.MeasureSpec.getMode(i);
        l = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(i);
        j1 = android.view.View.MeasureSpec.getSize(j);
        if(mOnLayout == null)
            mOnLayout = makeLayout(mTextOn);
        if(mOffLayout == null)
            mOffLayout = makeLayout(mTextOff);
        mTrackDrawable.getPadding(mTempRect);
        int k1 = Math.max(mOnLayout.getWidth(), mOffLayout.getWidth());
        l1 = Math.max(mSwitchMinWidth, k1 * 2 + 4 * mThumbTextPadding + mTempRect.left + mTempRect.right);
        i2 = mTrackDrawable.getIntrinsicHeight();
        mThumbWidth = k1 + 2 * mThumbTextPadding;
        k;
        JVM INSTR lookupswitch 2: default 176
    //                   -2147483648: 242
    //                   0: 253;
           goto _L1 _L2 _L1
_L1:
        l;
        JVM INSTR lookupswitch 2: default 204
    //                   -2147483648: 256
    //                   0: 267;
           goto _L3 _L4 _L3
_L3:
        mSwitchWidth = l1;
        mSwitchHeight = i2;
        super.onMeasure(i, j);
        if(getMeasuredHeight() < i2)
            setMeasuredDimension(getMeasuredWidthAndState(), i2);
        return;
_L2:
        Math.min(i1, l1);
          goto _L1
_L4:
        Math.min(j1, i2);
          goto _L3
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onPopulateAccessibilityEvent(accessibilityevent);
        CharSequence charsequence;
        if(isChecked())
            charsequence = mOnLayout.getText();
        else
            charsequence = mOffLayout.getText();
        if(!TextUtils.isEmpty(charsequence))
            accessibilityevent.getText().add(charsequence);
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        flag = true;
        mVelocityTracker.addMovement(motionevent);
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 3: default 44
    //                   0 52
    //                   1 273
    //                   2 102
    //                   3 273;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        flag = super.onTouchEvent(motionevent);
_L6:
        return flag;
_L2:
        float f4 = motionevent.getX();
        float f5 = motionevent.getY();
        if(isEnabled() && hitThumb(f4, f5)) {
            mTouchMode = ((flag) ? 1 : 0);
            mTouchX = f4;
            mTouchY = f5;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        switch(mTouchMode) {
        case 0: // '\0'
        default:
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            float f2 = motionevent.getX();
            float f3 = motionevent.getY();
            if(Math.abs(f2 - mTouchX) <= (float)mTouchSlop && Math.abs(f3 - mTouchY) <= (float)mTouchSlop)
                continue; /* Loop/switch isn't completed */
            mTouchMode = 2;
            getParent().requestDisallowInterceptTouchEvent(flag);
            mTouchX = f2;
            mTouchY = f3;
            break;

        case 2: // '\002'
            float f = motionevent.getX();
            float f1 = Math.max(0.0F, Math.min((f - mTouchX) + mThumbPosition, getThumbScrollRange()));
            if(f1 != mThumbPosition) {
                mThumbPosition = f1;
                mTouchX = f;
                invalidate();
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(mTouchMode != 2)
            break; /* Loop/switch isn't completed */
        stopDrag(motionevent);
        if(true) goto _L6; else goto _L5
_L5:
        mTouchMode = 0;
        mVelocityTracker.clear();
        if(true) goto _L1; else goto _L7
_L7:
    }

    public void setChecked(boolean flag) {
        super.setChecked(flag);
        float f;
        if(flag)
            f = getThumbScrollRange();
        else
            f = 0.0F;
        mThumbPosition = f;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        mSwitchMinWidth = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        mSwitchPadding = i;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i) {
        TypedArray typedarray = context.obtainStyledAttributes(i, com.android.internal.R.styleable.TextAppearance);
        ColorStateList colorstatelist = typedarray.getColorStateList(3);
        int j;
        if(colorstatelist != null)
            mTextColors = colorstatelist;
        else
            mTextColors = getTextColors();
        j = typedarray.getDimensionPixelSize(0, 0);
        if(j != 0 && (float)j != mTextPaint.getTextSize()) {
            mTextPaint.setTextSize(j);
            requestLayout();
        }
        setSwitchTypefaceByIndex(typedarray.getInt(1, -1), typedarray.getInt(2, -1));
        if(typedarray.getBoolean(7, false)) {
            mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
            mSwitchTransformationMethod.setLengthChangesAllowed(true);
        } else {
            mSwitchTransformationMethod = null;
        }
        typedarray.recycle();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if(mTextPaint.getTypeface() != typeface) {
            mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        boolean flag = false;
        if(i > 0) {
            Typeface typeface1;
            int j;
            int k;
            TextPaint textpaint;
            TextPaint textpaint1;
            float f;
            if(typeface == null)
                typeface1 = Typeface.defaultFromStyle(i);
            else
                typeface1 = Typeface.create(typeface, i);
            setSwitchTypeface(typeface1);
            if(typeface1 != null)
                j = typeface1.getStyle();
            else
                j = 0;
            k = i & ~j;
            textpaint = mTextPaint;
            if((k & 1) != 0)
                flag = true;
            textpaint.setFakeBoldText(flag);
            textpaint1 = mTextPaint;
            if((k & 2) != 0)
                f = -0.25F;
            else
                f = 0.0F;
            textpaint1.setTextSkewX(f);
        } else {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0.0F);
            setSwitchTypeface(typeface);
        }
    }

    public void setTextOff(CharSequence charsequence) {
        mTextOff = charsequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charsequence) {
        mTextOn = charsequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        mThumbDrawable = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(getContext().getResources().getDrawable(i));
    }

    public void setThumbTextPadding(int i) {
        mThumbTextPadding = i;
        requestLayout();
    }

    public void setTrackDrawable(Drawable drawable) {
        mTrackDrawable = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean flag;
        if(super.verifyDrawable(drawable) || drawable == mThumbDrawable || drawable == mTrackDrawable)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final int CHECKED_STATE_SET[];
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod2 mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private float mThumbPosition;
    private int mThumbTextPadding;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private VelocityTracker mVelocityTracker;

    static  {
        int ai[] = new int[1];
        ai[0] = 0x10100a0;
        CHECKED_STATE_SET = ai;
    }
}
