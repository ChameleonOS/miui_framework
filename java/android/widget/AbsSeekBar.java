// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            ProgressBar

public abstract class AbsSeekBar extends ProgressBar {

    public AbsSeekBar(Context context) {
        super(context);
        mIsUserSeekable = true;
        mKeyProgressIncrement = 1;
    }

    public AbsSeekBar(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mIsUserSeekable = true;
        mKeyProgressIncrement = 1;
    }

    public AbsSeekBar(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mIsUserSeekable = true;
        mKeyProgressIncrement = 1;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.SeekBar, i, 0);
        setThumb(typedarray.getDrawable(0));
        setThumbOffset(typedarray.getDimensionPixelOffset(1, getThumbOffset()));
        typedarray.recycle();
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Theme, 0, 0);
        mDisabledAlpha = typedarray1.getFloat(3, 0.5F);
        typedarray1.recycle();
        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void attemptClaimDrag() {
        if(super.mParent != null)
            super.mParent.requestDisallowInterceptTouchEvent(true);
    }

    private void setThumbPos(int i, Drawable drawable, float f, int j) {
        int k = i - super.mPaddingLeft - super.mPaddingRight;
        int l = drawable.getIntrinsicWidth();
        int i1 = drawable.getIntrinsicHeight();
        int j1 = (int)(f * (float)((k - l) + 2 * mThumbOffset));
        int k1;
        int l1;
        if(j == 0x80000000) {
            Rect rect = drawable.getBounds();
            k1 = rect.top;
            l1 = rect.bottom;
        } else {
            k1 = j;
            l1 = j + i1;
        }
        drawable.setBounds(j1, k1, j1 + l, l1);
    }

    private void trackTouchEvent(MotionEvent motionevent) {
        int i = getWidth();
        int j = i - super.mPaddingLeft - super.mPaddingRight;
        int k = (int)motionevent.getX();
        float f = 0.0F;
        float f1;
        if(k < super.mPaddingLeft)
            f1 = 0.0F;
        else
        if(k > i - super.mPaddingRight) {
            f1 = 1.0F;
        } else {
            f1 = (float)(k - super.mPaddingLeft) / (float)j;
            f = mTouchProgressOffset;
        }
        setProgress((int)(f + f1 * (float)getMax()), true);
    }

    private void updateThumbPos(int i, int j) {
        Drawable drawable;
        Drawable drawable1;
        int k;
        int l;
        float f;
        drawable = getCurrentDrawable();
        drawable1 = mThumb;
        int i1;
        int k1;
        if(drawable1 == null)
            k = 0;
        else
            k = drawable1.getIntrinsicHeight();
        l = Math.min(super.mMaxHeight, j - super.mPaddingTop - super.mPaddingBottom);
        i1 = getMax();
        if(i1 > 0)
            f = (float)getProgress() / (float)i1;
        else
            f = 0.0F;
        if(k <= l) goto _L2; else goto _L1
_L1:
        if(drawable1 != null)
            setThumbPos(i, drawable1, f, 0);
        k1 = (k - l) / 2;
        if(drawable != null)
            drawable.setBounds(0, k1, i - super.mPaddingRight - super.mPaddingLeft, j - super.mPaddingBottom - k1 - super.mPaddingTop);
_L4:
        return;
_L2:
        if(drawable != null)
            drawable.setBounds(0, 0, i - super.mPaddingRight - super.mPaddingLeft, j - super.mPaddingBottom - super.mPaddingTop);
        int j1 = (l - k) / 2;
        if(drawable1 != null)
            setThumbPos(i, drawable1, f, j1);
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = getProgressDrawable();
        if(drawable != null) {
            int ai[];
            int i;
            if(isEnabled())
                i = 255;
            else
                i = (int)(255F * mDisabledAlpha);
            drawable.setAlpha(i);
        }
        if(mThumb != null && mThumb.isStateful()) {
            ai = getDrawableState();
            mThumb.setState(ai);
        }
    }

    public int getKeyProgressIncrement() {
        return mKeyProgressIncrement;
    }

    public Drawable getThumb() {
        return mThumb;
    }

    public int getThumbOffset() {
        return mThumbOffset;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if(mThumb != null)
            mThumb.jumpToCurrentState();
    }

    /**
     * @deprecated Method onDraw is deprecated
     */

    protected void onDraw(Canvas canvas) {
        this;
        JVM INSTR monitorenter ;
        super.onDraw(canvas);
        if(mThumb != null) {
            canvas.save();
            canvas.translate(super.mPaddingLeft - mThumbOffset, super.mPaddingTop);
            mThumb.draw(canvas);
            canvas.restore();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/AbsSeekBar.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/AbsSeekBar.getName());
        if(isEnabled()) {
            int i = getProgress();
            if(i > 0)
                accessibilitynodeinfo.addAction(8192);
            if(i < getMax())
                accessibilitynodeinfo.addAction(4096);
        }
    }

    void onKeyChange() {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag = true;
        if(!isEnabled()) goto _L2; else goto _L1
_L1:
        int j = getProgress();
        i;
        JVM INSTR tableswitch 21 22: default 40
    //                   21 49
    //                   22 73;
           goto _L2 _L3 _L4
_L2:
        flag = super.onKeyDown(i, keyevent);
_L6:
        return flag;
_L3:
        if(j <= 0) goto _L2; else goto _L5
_L5:
        setProgress(j - mKeyProgressIncrement, flag);
        onKeyChange();
          goto _L6
_L4:
        if(j >= getMax()) goto _L2; else goto _L7
_L7:
        setProgress(j + mKeyProgressIncrement, flag);
        onKeyChange();
          goto _L6
    }

    /**
     * @deprecated Method onMeasure is deprecated
     */

    protected void onMeasure(int i, int j) {
        int k = 0;
        this;
        JVM INSTR monitorenter ;
        Drawable drawable = getCurrentDrawable();
        if(mThumb != null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
        int j1 = 0;
        if(drawable != null) {
            i1 = Math.max(super.mMinWidth, Math.min(super.mMaxWidth, drawable.getIntrinsicWidth()));
            j1 = Math.max(k, Math.max(super.mMinHeight, Math.min(super.mMaxHeight, drawable.getIntrinsicHeight())));
        }
        int k1 = i1 + (super.mPaddingLeft + super.mPaddingRight);
        int l1 = j1 + (super.mPaddingTop + super.mPaddingBottom);
        setMeasuredDimension(resolveSizeAndState(k1, i, 0), resolveSizeAndState(l1, j, 0));
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int l = mThumb.getIntrinsicHeight();
        k = l;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    void onProgressRefresh(float f, boolean flag) {
        super.onProgressRefresh(f, flag);
        Drawable drawable = mThumb;
        if(drawable != null) {
            setThumbPos(getWidth(), drawable, f, 0x80000000);
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        updateThumbPos(i, j);
    }

    void onStartTrackingTouch() {
        mIsDragging = true;
    }

    void onStopTrackingTouch() {
        mIsDragging = false;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag = true;
        if(mIsUserSeekable && isEnabled()) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        switch(motionevent.getAction()) {
        case 0: // '\0'
            if(isInScrollingContainer()) {
                mTouchDownX = motionevent.getX();
            } else {
                setPressed(flag);
                if(mThumb != null)
                    invalidate(mThumb.getBounds());
                onStartTrackingTouch();
                trackTouchEvent(motionevent);
                attemptClaimDrag();
            }
            break;

        case 2: // '\002'
            if(mIsDragging)
                trackTouchEvent(motionevent);
            else
            if(Math.abs(motionevent.getX() - mTouchDownX) > (float)mScaledTouchSlop) {
                setPressed(flag);
                if(mThumb != null)
                    invalidate(mThumb.getBounds());
                onStartTrackingTouch();
                trackTouchEvent(motionevent);
                attemptClaimDrag();
            }
            break;

        case 1: // '\001'
            if(mIsDragging) {
                trackTouchEvent(motionevent);
                onStopTrackingTouch();
                setPressed(false);
            } else {
                onStartTrackingTouch();
                trackTouchEvent(motionevent);
                onStopTrackingTouch();
            }
            invalidate();
            break;

        case 3: // '\003'
            if(mIsDragging) {
                onStopTrackingTouch();
                setPressed(false);
            }
            invalidate();
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean flag = true;
        if(!super.performAccessibilityAction(i, bundle)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(isEnabled())
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
        int j = getProgress();
        int k = Math.max(flag, Math.round((float)getMax() / 5F));
        switch(i) {
        default:
            flag = false;
            break;

        case 8192: 
            if(j <= 0) {
                flag = false;
            } else {
                setProgress(j - k, flag);
                onKeyChange();
            }
            break;

        case 4096: 
            if(j >= getMax()) {
                flag = false;
            } else {
                setProgress(j + k, flag);
                onKeyChange();
            }
            break;
        }
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void setKeyProgressIncrement(int i) {
        if(i < 0)
            i = -i;
        mKeyProgressIncrement = i;
    }

    /**
     * @deprecated Method setMax is deprecated
     */

    public void setMax(int i) {
        this;
        JVM INSTR monitorenter ;
        super.setMax(i);
        if(mKeyProgressIncrement == 0 || getMax() / mKeyProgressIncrement > 20)
            setKeyProgressIncrement(Math.max(1, Math.round((float)getMax() / 20F)));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setThumb(Drawable drawable) {
        boolean flag;
        if(mThumb != null && drawable != mThumb) {
            mThumb.setCallback(null);
            flag = true;
        } else {
            flag = false;
        }
        if(drawable != null) {
            drawable.setCallback(this);
            mThumbOffset = drawable.getIntrinsicWidth() / 2;
            if(flag && (drawable.getIntrinsicWidth() != mThumb.getIntrinsicWidth() || drawable.getIntrinsicHeight() != mThumb.getIntrinsicHeight()))
                requestLayout();
        }
        mThumb = drawable;
        invalidate();
        if(flag) {
            updateThumbPos(getWidth(), getHeight());
            if(drawable != null && drawable.isStateful())
                drawable.setState(getDrawableState());
        }
    }

    public void setThumbOffset(int i) {
        mThumbOffset = i;
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean flag;
        if(drawable == mThumb || super.verifyDrawable(drawable))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final int NO_ALPHA = 255;
    private float mDisabledAlpha;
    private boolean mIsDragging;
    boolean mIsUserSeekable;
    private int mKeyProgressIncrement;
    private int mScaledTouchSlop;
    private Drawable mThumb;
    private int mThumbOffset;
    private float mTouchDownX;
    float mTouchProgressOffset;
}
