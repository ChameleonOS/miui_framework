// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            AbsSeekBar, ProgressBar

public class RatingBar extends AbsSeekBar {
    public static interface OnRatingBarChangeListener {

        public abstract void onRatingChanged(RatingBar ratingbar, float f, boolean flag);
    }


    public RatingBar(Context context) {
        this(context, null);
    }

    public RatingBar(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101007c);
    }

    public RatingBar(Context context, AttributeSet attributeset, int i) {
        boolean flag = false;
        super(context, attributeset, i);
        mNumStars = 5;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.RatingBar, i, 0);
        int j = typedarray.getInt(0, mNumStars);
        if(!super.mIsUserSeekable)
            flag = true;
        setIsIndicator(typedarray.getBoolean(3, flag));
        float f = typedarray.getFloat(1, -1F);
        float f1 = typedarray.getFloat(2, -1F);
        typedarray.recycle();
        if(j > 0 && j != mNumStars)
            setNumStars(j);
        if(f1 >= 0.0F)
            setStepSize(f1);
        else
            setStepSize(0.5F);
        if(f >= 0.0F)
            setRating(f);
        super.mTouchProgressOffset = 1.1F;
    }

    private float getProgressPerStar() {
        float f = 1.0F;
        if(mNumStars > 0)
            f = (f * (float)getMax()) / (float)mNumStars;
        return f;
    }

    private void updateSecondaryProgress(int i) {
        float f = getProgressPerStar();
        if(f > 0.0F)
            setSecondaryProgress((int)(Math.ceil((float)i / f) * (double)f));
    }

    void dispatchRatingChange(boolean flag) {
        if(mOnRatingBarChangeListener != null)
            mOnRatingBarChangeListener.onRatingChanged(this, getRating(), flag);
    }

    Shape getDrawableShape() {
        return new RectShape();
    }

    public int getNumStars() {
        return mNumStars;
    }

    public OnRatingBarChangeListener getOnRatingBarChangeListener() {
        return mOnRatingBarChangeListener;
    }

    public float getRating() {
        return (float)getProgress() / getProgressPerStar();
    }

    public float getStepSize() {
        return (float)getNumStars() / (float)getMax();
    }

    public boolean isIndicator() {
        boolean flag;
        if(!super.mIsUserSeekable)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/RatingBar.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/RatingBar.getName());
    }

    void onKeyChange() {
        super.onKeyChange();
        dispatchRatingChange(true);
    }

    /**
     * @deprecated Method onMeasure is deprecated
     */

    protected void onMeasure(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        super.onMeasure(i, j);
        if(super.mSampleTile != null)
            setMeasuredDimension(resolveSizeAndState(super.mSampleTile.getWidth() * mNumStars, i, 0), getMeasuredHeight());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void onProgressRefresh(float f, boolean flag) {
        super.onProgressRefresh(f, flag);
        updateSecondaryProgress(getProgress());
        if(!flag)
            dispatchRatingChange(false);
    }

    void onStartTrackingTouch() {
        mProgressOnStartTracking = getProgress();
        super.onStartTrackingTouch();
    }

    void onStopTrackingTouch() {
        super.onStopTrackingTouch();
        if(getProgress() != mProgressOnStartTracking)
            dispatchRatingChange(true);
    }

    public void setIsIndicator(boolean flag) {
        boolean flag1 = true;
        boolean flag2;
        if(!flag)
            flag2 = flag1;
        else
            flag2 = false;
        super.mIsUserSeekable = flag2;
        if(flag)
            flag1 = false;
        setFocusable(flag1);
    }

    /**
     * @deprecated Method setMax is deprecated
     */

    public void setMax(int i) {
        this;
        JVM INSTR monitorenter ;
        if(i > 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        super.setMax(i);
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setNumStars(int i) {
        if(i > 0) {
            mNumStars = i;
            requestLayout();
        }
    }

    public void setOnRatingBarChangeListener(OnRatingBarChangeListener onratingbarchangelistener) {
        mOnRatingBarChangeListener = onratingbarchangelistener;
    }

    public void setRating(float f) {
        setProgress(Math.round(f * getProgressPerStar()));
    }

    public void setStepSize(float f) {
        if(f > 0.0F) {
            float f1 = (float)mNumStars / f;
            int i = (int)((f1 / (float)getMax()) * (float)getProgress());
            setMax((int)f1);
            setProgress(i);
        }
    }

    private int mNumStars;
    private OnRatingBarChangeListener mOnRatingBarChangeListener;
    private int mProgressOnStartTracking;
}
