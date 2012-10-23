// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.os.Vibrator;
import android.util.*;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

public class RotarySelector extends View {
    public static interface OnDialTriggerListener {

        public abstract void onDialTrigger(View view, int i);

        public abstract void onGrabbedStateChange(View view, int i);

        public static final int LEFT_HANDLE = 1;
        public static final int RIGHT_HANDLE = 2;
    }


    public RotarySelector(Context context) {
        this(context, null);
    }

    public RotarySelector(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mRotaryOffsetX = 0;
        mAnimating = false;
        mPaint = new Paint();
        mBgMatrix = new Matrix();
        mArrowMatrix = new Matrix();
        mGrabbedState = 0;
        mTriggered = false;
        mDimplesOfFling = 0;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.RotarySelector);
        mOrientation = typedarray.getInt(0, 0);
        typedarray.recycle();
        mDensity = getResources().getDisplayMetrics().density;
        mBackground = getBitmapFor(0x1080381);
        mDimple = getBitmapFor(0x1080382);
        mDimpleDim = getBitmapFor(0x1080383);
        mArrowLongLeft = getBitmapFor(0x1080379);
        mArrowLongRight = getBitmapFor(0x108037c);
        mArrowShortLeftAndRight = getBitmapFor(0x108037f);
        mInterpolator = new DecelerateInterpolator(1.0F);
        mEdgeTriggerThresh = (int)(100F * mDensity);
        mDimpleWidth = mDimple.getWidth();
        mBackgroundWidth = mBackground.getWidth();
        mBackgroundHeight = mBackground.getHeight();
        mOuterRadius = (int)(390F * mDensity);
        mInnerRadius = (int)(307F * mDensity);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(super.mContext);
        mMinimumVelocity = 2 * viewconfiguration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
    }

    private void dispatchTriggerEvent(int i) {
        vibrate(20L);
        if(mOnDialTriggerListener != null)
            mOnDialTriggerListener.onDialTrigger(this, i);
    }

    private void drawCentered(Bitmap bitmap, Canvas canvas, int i, int j) {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        canvas.drawBitmap(bitmap, i - k / 2, j - l / 2, mPaint);
    }

    private Bitmap getBitmapFor(int i) {
        return BitmapFactory.decodeResource(getContext().getResources(), i);
    }

    private int getYOnArc(int i, int j, int k, int l) {
        int i1 = (k - j) / 2;
        int j1 = j + i1;
        int k1 = i / 2 - l;
        return i1 + (j1 - (int)Math.sqrt(j1 * j1 - k1 * k1));
    }

    private boolean isHoriz() {
        boolean flag;
        if(mOrientation == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void log(String s) {
        Log.d("RotarySelector", s);
    }

    private void reset() {
        mAnimating = false;
        mRotaryOffsetX = 0;
        mDimplesOfFling = 0;
        setGrabbedState(0);
        mTriggered = false;
    }

    private void setGrabbedState(int i) {
        if(i != mGrabbedState) {
            mGrabbedState = i;
            if(mOnDialTriggerListener != null)
                mOnDialTriggerListener.onGrabbedStateChange(this, mGrabbedState);
        }
    }

    private void startAnimation(int i, int j, int k) {
        mAnimating = true;
        mAnimationStartTime = AnimationUtils.currentAnimationTimeMillis();
        mAnimationDuration = k;
        mAnimatingDeltaXStart = i;
        mAnimatingDeltaXEnd = j;
        setGrabbedState(0);
        mDimplesOfFling = 0;
        invalidate();
    }

    private void startAnimationWithVelocity(int i, int j, int k) {
        mAnimating = true;
        mAnimationStartTime = AnimationUtils.currentAnimationTimeMillis();
        mAnimationDuration = (1000 * (j - i)) / k;
        mAnimatingDeltaXStart = i;
        mAnimatingDeltaXEnd = j;
        setGrabbedState(0);
        invalidate();
    }

    private void updateAnimation() {
        long l;
        int i;
        boolean flag;
        l = AnimationUtils.currentAnimationTimeMillis() - mAnimationStartTime;
        long l1 = mAnimationDuration - l;
        i = mAnimatingDeltaXStart - mAnimatingDeltaXEnd;
        if(i < 0)
            flag = true;
        else
            flag = false;
        if(l1 > 0L) goto _L2; else goto _L1
_L1:
        reset();
_L4:
        return;
_L2:
        float f = mInterpolator.getInterpolation((float)l / (float)mAnimationDuration);
        mRotaryOffsetX = (int)((float)i * (1.0F - f)) + mAnimatingDeltaXEnd;
        if(mDimplesOfFling > 0) {
            if(flag || mRotaryOffsetX >= -3 * mDimpleSpacing)
                break; /* Loop/switch isn't completed */
            mRotaryOffsetX = mRotaryOffsetX + mDimplesOfFling * mDimpleSpacing;
        }
_L6:
        invalidate();
        if(true) goto _L4; else goto _L3
_L3:
        if(!flag || mRotaryOffsetX <= 3 * mDimpleSpacing) goto _L6; else goto _L5
_L5:
        mRotaryOffsetX = mRotaryOffsetX - mDimplesOfFling * mDimpleSpacing;
          goto _L6
    }

    /**
     * @deprecated Method vibrate is deprecated
     */

    private void vibrate(long l) {
        this;
        JVM INSTR monitorenter ;
        if(mVibrator == null)
            mVibrator = (Vibrator)getContext().getSystemService("vibrator");
        mVibrator.vibrate(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void onDraw(Canvas canvas) {
        int i;
        int j;
        super.onDraw(canvas);
        i = getWidth();
        j = getHeight();
        if(mAnimating)
            updateAnimation();
        canvas.drawBitmap(mBackground, mBgMatrix, mPaint);
        mArrowMatrix.reset();
        switch(mGrabbedState) {
        default:
            throw new IllegalStateException((new StringBuilder()).append("invalid mGrabbedState: ").append(mGrabbedState).toString());

        case 0: // '\0'
            break;

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_513;

        case 1: // '\001'
            mArrowMatrix.setTranslate(0.0F, 0.0F);
            if(!isHoriz()) {
                mArrowMatrix.preRotate(-90F, 0.0F, 0.0F);
                mArrowMatrix.postTranslate(0.0F, j);
            }
            canvas.drawBitmap(mArrowLongLeft, mArrowMatrix, mPaint);
            break;
        }
_L1:
        int l;
        int l3;
        int k = mBackgroundHeight;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        if(isHoriz())
            l = j - k;
        else
            l = i - k;
        i1 = mLeftHandleX + mRotaryOffsetX;
        j1 = getYOnArc(mBackgroundWidth, mInnerRadius, mOuterRadius, i1);
        if(isHoriz())
            k1 = i1;
        else
            k1 = j1 + l;
        if(isHoriz())
            l1 = j1 + l;
        else
            l1 = j - i1;
        if(mGrabbedState != 2) {
            drawCentered(mDimple, canvas, k1, l1);
            drawCentered(mLeftHandleIcon, canvas, k1, l1);
        } else {
            drawCentered(mDimpleDim, canvas, k1, l1);
        }
        if(isHoriz())
            i2 = i / 2 + mRotaryOffsetX;
        else
            i2 = j / 2 + mRotaryOffsetX;
        j2 = getYOnArc(mBackgroundWidth, mInnerRadius, mOuterRadius, i2);
        if(isHoriz())
            drawCentered(mDimpleDim, canvas, i2, j2 + l);
        else
            drawCentered(mDimpleDim, canvas, j2 + l, j - i2);
        k2 = mRightHandleX + mRotaryOffsetX;
        l2 = getYOnArc(mBackgroundWidth, mInnerRadius, mOuterRadius, k2);
        if(isHoriz())
            i3 = k2;
        else
            i3 = l2 + l;
        if(isHoriz())
            j3 = l2 + l;
        else
            j3 = j - k2;
        if(mGrabbedState != 1) {
            drawCentered(mDimple, canvas, i3, j3);
            drawCentered(mRightHandleIcon, canvas, i3, j3);
        } else {
            drawCentered(mDimpleDim, canvas, i3, j3);
        }
        k3 = (mRotaryOffsetX + mLeftHandleX) - mDimpleSpacing;
        l3 = mDimpleWidth / 2;
        while(k3 > -l3)  {
            int l4 = getYOnArc(mBackgroundWidth, mInnerRadius, mOuterRadius, k3);
            if(isHoriz())
                drawCentered(mDimpleDim, canvas, k3, l4 + l);
            else
                drawCentered(mDimpleDim, canvas, l4 + l, j - k3);
            k3 -= mDimpleSpacing;
        }
        break MISSING_BLOCK_LABEL_713;
        mArrowMatrix.setTranslate(0.0F, 0.0F);
        if(!isHoriz()) {
            mArrowMatrix.preRotate(-90F, 0.0F, 0.0F);
            mArrowMatrix.postTranslate(0.0F, j + (mBackgroundWidth - j));
        }
        canvas.drawBitmap(mArrowLongRight, mArrowMatrix, mPaint);
          goto _L1
        int i4 = mRotaryOffsetX + mRightHandleX + mDimpleSpacing;
        int j4 = l3 + super.mRight;
        while(i4 < j4)  {
            int k4 = getYOnArc(mBackgroundWidth, mInnerRadius, mOuterRadius, i4);
            if(isHoriz())
                drawCentered(mDimpleDim, canvas, i4, k4 + l);
            else
                drawCentered(mDimpleDim, canvas, k4 + l, j - i4);
            i4 += mDimpleSpacing;
        }
        return;
    }

    protected void onMeasure(int i, int j) {
        int k;
        int l;
        int i1;
        if(isHoriz())
            k = android.view.View.MeasureSpec.getSize(i);
        else
            k = android.view.View.MeasureSpec.getSize(j);
        l = (int)(6F * mDensity);
        i1 = (mArrowShortLeftAndRight.getHeight() + mBackgroundHeight) - l;
        if(isHoriz())
            setMeasuredDimension(k, i1);
        else
            setMeasuredDimension(i1, k);
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        super.onSizeChanged(i, j, k, l);
        int i1 = (int)(9F * mDensity);
        mLeftHandleX = i1 + mDimpleWidth / 2;
        int j1;
        if(isHoriz())
            j1 = i;
        else
            j1 = j;
        mRightHandleX = j1 - i1 - mDimpleWidth / 2;
        mDimpleSpacing = j1 / 2 - mLeftHandleX;
        mBgMatrix.setTranslate(0.0F, 0.0F);
        if(!isHoriz()) {
            int k1 = i - mBackgroundHeight;
            mBgMatrix.preRotate(-90F, 0.0F, 0.0F);
            mBgMatrix.postTranslate(k1, j);
        } else {
            mBgMatrix.postTranslate(0.0F, j - mBackgroundHeight);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        if(!mAnimating) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(motionevent);
        int i = getHeight();
        int j;
        int k;
        if(isHoriz())
            j = (int)motionevent.getX();
        else
            j = i - (int)motionevent.getY();
        k = mDimpleWidth;
        switch(motionevent.getAction()) {
        default:
            break;

        case 0: // '\0'
            mTriggered = false;
            if(mGrabbedState != 0) {
                reset();
                invalidate();
            }
            if(j < k + mLeftHandleX) {
                mRotaryOffsetX = j - mLeftHandleX;
                setGrabbedState(1);
                invalidate();
                vibrate(20L);
            } else
            if(j > mRightHandleX - k) {
                mRotaryOffsetX = j - mRightHandleX;
                setGrabbedState(2);
                invalidate();
                vibrate(20L);
            }
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            if(mGrabbedState == 1) {
                mRotaryOffsetX = j - mLeftHandleX;
                invalidate();
                int j1;
                if(isHoriz())
                    j1 = getRight();
                else
                    j1 = i;
                if(j >= j1 - mEdgeTriggerThresh && !mTriggered) {
                    mTriggered = true;
                    dispatchTriggerEvent(1);
                    VelocityTracker velocitytracker1 = mVelocityTracker;
                    velocitytracker1.computeCurrentVelocity(1000, mMaximumVelocity);
                    int k1;
                    int l1;
                    if(isHoriz())
                        k1 = (int)velocitytracker1.getXVelocity();
                    else
                        k1 = -(int)velocitytracker1.getYVelocity();
                    l1 = Math.max(mMinimumVelocity, k1);
                    mDimplesOfFling = Math.max(8, Math.abs(l1 / mDimpleSpacing));
                    startAnimationWithVelocity(j - mLeftHandleX, mDimplesOfFling * mDimpleSpacing, l1);
                }
            } else
            if(mGrabbedState == 2) {
                mRotaryOffsetX = j - mRightHandleX;
                invalidate();
                if(j <= mEdgeTriggerThresh && !mTriggered) {
                    mTriggered = true;
                    dispatchTriggerEvent(2);
                    VelocityTracker velocitytracker = mVelocityTracker;
                    velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
                    int l;
                    int i1;
                    if(isHoriz())
                        l = (int)velocitytracker.getXVelocity();
                    else
                        l = -(int)velocitytracker.getYVelocity();
                    i1 = Math.min(-mMinimumVelocity, l);
                    mDimplesOfFling = Math.max(8, Math.abs(i1 / mDimpleSpacing));
                    startAnimationWithVelocity(j - mRightHandleX, -(mDimplesOfFling * mDimpleSpacing), i1);
                }
            }
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            if(mGrabbedState == 1 && Math.abs(j - mLeftHandleX) > 5)
                startAnimation(j - mLeftHandleX, 0, 300);
            else
            if(mGrabbedState == 2 && Math.abs(j - mRightHandleX) > 5)
                startAnimation(j - mRightHandleX, 0, 300);
            mRotaryOffsetX = 0;
            setGrabbedState(0);
            invalidate();
            if(mVelocityTracker != null) {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            }
            continue; /* Loop/switch isn't completed */

        case 3: // '\003'
            reset();
            invalidate();
            if(mVelocityTracker != null) {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            }
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setLeftHandleResource(int i) {
        if(i != 0)
            mLeftHandleIcon = getBitmapFor(i);
        invalidate();
    }

    public void setOnDialTriggerListener(OnDialTriggerListener ondialtriggerlistener) {
        mOnDialTriggerListener = ondialtriggerlistener;
    }

    public void setRightHandleResource(int i) {
        if(i != 0)
            mRightHandleIcon = getBitmapFor(i);
        invalidate();
    }

    private static final int ARROW_SCRUNCH_DIP = 6;
    private static final boolean DBG = false;
    private static final int EDGE_PADDING_DIP = 9;
    private static final int EDGE_TRIGGER_DIP = 100;
    public static final int HORIZONTAL = 0;
    public static final int LEFT_HANDLE_GRABBED = 1;
    private static final String LOG_TAG = "RotarySelector";
    public static final int NOTHING_GRABBED = 0;
    static final int OUTER_ROTARY_RADIUS_DIP = 390;
    public static final int RIGHT_HANDLE_GRABBED = 2;
    static final int ROTARY_STROKE_WIDTH_DIP = 83;
    static final int SNAP_BACK_ANIMATION_DURATION_MILLIS = 300;
    static final int SPIN_ANIMATION_DURATION_MILLIS = 800;
    public static final int VERTICAL = 1;
    private static final long VIBRATE_LONG = 20L;
    private static final long VIBRATE_SHORT = 20L;
    private static final boolean VISUAL_DEBUG;
    private boolean mAnimating;
    private int mAnimatingDeltaXEnd;
    private int mAnimatingDeltaXStart;
    private long mAnimationDuration;
    private long mAnimationStartTime;
    private Bitmap mArrowLongLeft;
    private Bitmap mArrowLongRight;
    final Matrix mArrowMatrix;
    private Bitmap mArrowShortLeftAndRight;
    private Bitmap mBackground;
    private int mBackgroundHeight;
    private int mBackgroundWidth;
    final Matrix mBgMatrix;
    private float mDensity;
    private Bitmap mDimple;
    private Bitmap mDimpleDim;
    private int mDimpleSpacing;
    private int mDimpleWidth;
    private int mDimplesOfFling;
    private int mEdgeTriggerThresh;
    private int mGrabbedState;
    private final int mInnerRadius;
    private DecelerateInterpolator mInterpolator;
    private Bitmap mLeftHandleIcon;
    private int mLeftHandleX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnDialTriggerListener mOnDialTriggerListener;
    private int mOrientation;
    private final int mOuterRadius;
    private Paint mPaint;
    private Bitmap mRightHandleIcon;
    private int mRightHandleX;
    private int mRotaryOffsetX;
    private boolean mTriggered;
    private VelocityTracker mVelocityTracker;
    private Vibrator mVibrator;
}
