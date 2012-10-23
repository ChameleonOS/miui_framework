// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.CheckBox;

public class SlidingButton extends CheckBox {
    private class SlidingHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1000 1000: default 24
        //                       1000 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            doAnimation();
            if(true) goto _L1; else goto _L3
_L3:
        }

        final SlidingButton this$0;

        private SlidingHandler() {
            this$0 = SlidingButton.this;
            super();
        }

    }

    public static interface OnCheckedChangedListener {

        public abstract void onCheckedChanged(boolean flag);
    }


    public SlidingButton(Context context) {
        this(context, null);
    }

    public SlidingButton(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public SlidingButton(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mAnimating = false;
        mHandler = new SlidingHandler();
        mAnimatedVelocity = 150F;
        mOnCheckedChangedListener = null;
        initialize(context, attributeset, i);
    }

    private void animateOff() {
        performFling(-150F);
        invalidate();
    }

    private void animateOn() {
        performFling(150F);
        invalidate();
    }

    private void animateToggle() {
        if(isChecked())
            animateOff();
        else
            animateOn();
    }

    private void createBarBitmap(BitmapDrawable bitmapdrawable) {
        if(bitmapdrawable != null)
            mBarBitmap = Bitmap.createScaledBitmap(bitmapdrawable.getBitmap(), 2 * mWidth - mSliderWidth, mHeight, true);
    }

    private void cutEdge(int i, int j, int ai[]) {
        for(int k = -1 + i * j; k >= 0; k--)
            ai[k] = ai[k] & 0xffffff + (((ai[k] >>> 24) * (mAlphaPixels[k] >>> 24)) / 255 << 24);

    }

    private void doAnimation() {
        boolean flag = false;
        if(mAnimating) goto _L2; else goto _L1
_L1:
        return;
_L2:
        incrementAnimation();
        moveSlider((int)mAnimationPosition);
        if(mSliderOffset <= 0 || mSliderOffset >= mSliderPosition) {
            mHandler.removeMessages(1000);
            mAnimating = false;
            if(mSliderOffset >= mSliderPosition)
                flag = true;
            setChecked(flag);
            if(mOnCheckedChangedListener != null)
                mOnCheckedChangedListener.onCheckedChanged(isChecked());
        } else {
            mCurrentAnimationTime = 16L + mCurrentAnimationTime;
            mHandler.sendMessageAtTime(mHandler.obtainMessage(1000), mCurrentAnimationTime);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void drawSlidingBar(Canvas canvas) {
        int i = mSliderPosition - mSliderOffset;
        mBarBitmap.getPixels(mBarSlice, 0, mWidth, i, 0, mWidth, mHeight);
        cutEdge(mWidth, mHeight, mBarSlice);
        canvas.drawBitmap(mBarSlice, 0, mWidth, 0, 0, mWidth, mHeight, true, null);
    }

    private void incrementAnimation() {
        long l = SystemClock.uptimeMillis();
        float f = (float)(l - mAnimationLastTime) / 1000F;
        mAnimationPosition = mAnimationPosition + f * mAnimatedVelocity;
        mAnimationLastTime = l;
    }

    private void initialize(Context context, AttributeSet attributeset, int i) {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.miui.internal.R.styleable.SlidingButton, i, 0x60d0027);
        setDrawingCacheEnabled(false);
        mTapThreshold = (int)(0.5F + 6F * getResources().getDisplayMetrics().density);
        mFrame = (BitmapDrawable)typedarray.getDrawable(0);
        mSlider = (BitmapDrawable)typedarray.getDrawable(1);
        mPressedSlider = (BitmapDrawable)typedarray.getDrawable(2);
        mOnDisable = (BitmapDrawable)typedarray.getDrawable(3);
        mOffDisable = (BitmapDrawable)typedarray.getDrawable(4);
        mWidth = mFrame.getIntrinsicWidth();
        mHeight = mFrame.getIntrinsicHeight();
        mActiveSlider = mSlider;
        mSliderWidth = Math.min(mWidth, mSlider.getIntrinsicWidth());
        mSliderPosition = mWidth - mSliderWidth;
        mFrame.setBounds(0, 0, mWidth, mHeight);
        mOnDisable.setBounds(0, 0, mWidth, mHeight);
        mOffDisable.setBounds(0, 0, mWidth, mHeight);
        mAlphaPixels = new int[mWidth * mHeight];
        Bitmap bitmap = ((BitmapDrawable)typedarray.getDrawable(5)).getBitmap();
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, mWidth, mHeight, false);
        bitmap1.getPixels(mAlphaPixels, 0, mWidth, 0, 0, mWidth, mHeight);
        if(bitmap1 != bitmap)
            bitmap1.recycle();
        mBarSlice = new int[mWidth * mHeight];
        createBarBitmap((BitmapDrawable)typedarray.getDrawable(6));
        typedarray.recycle();
    }

    private void moveSlider(int i) {
        mSliderOffset = i + mSliderOffset;
        if(mSliderOffset >= 0) goto _L2; else goto _L1
_L1:
        mSliderOffset = 0;
_L4:
        invalidate();
        return;
_L2:
        if(mSliderOffset > mSliderPosition)
            mSliderOffset = mSliderPosition;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void performFling(float f) {
        mAnimating = true;
        mAnimationPosition = 0.0F;
        mAnimatedVelocity = f;
        long l = SystemClock.uptimeMillis();
        mAnimationLastTime = l;
        mCurrentAnimationTime = 16L + l;
        mHandler.removeMessages(1000);
        mHandler.sendMessageAtTime(mHandler.obtainMessage(1000), mCurrentAnimationTime);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isEnabled()) {
            if(isChecked())
                mOnDisable.draw(canvas);
            else
                mOffDisable.draw(canvas);
        } else {
            drawSlidingBar(canvas);
            mFrame.draw(canvas);
            mActiveSlider.setBounds(mSliderOffset, 0, mSliderWidth + mSliderOffset, mHeight);
            mActiveSlider.draw(canvas);
        }
    }

    protected void onMeasure(int i, int j) {
        setMeasuredDimension(mWidth, mHeight);
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag = false;
        if(isEnabled()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i;
        int j;
        int k;
        Rect rect;
        i = motionevent.getAction();
        j = (int)motionevent.getX();
        k = (int)motionevent.getY();
        rect = new Rect(mSliderOffset, 0, mSliderOffset + mSliderWidth, mHeight);
        i;
        JVM INSTR tableswitch 0 3: default 88
    //                   0 93
    //                   1 209
    //                   2 150
    //                   3 281;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_281;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L9:
        flag = true;
        if(true) goto _L1; else goto _L8
_L8:
        if(rect.contains(j, k)) {
            mTracking = true;
            mActiveSlider = mPressedSlider;
            invalidate();
        } else {
            mTracking = false;
        }
        mLastX = j;
        mOriginalTouchPointX = j;
        mSliderMoved = false;
          goto _L9
_L6:
        if(mTracking) {
            moveSlider(j - mLastX);
            mLastX = j;
            if(Math.abs(j - mOriginalTouchPointX) >= mTapThreshold) {
                mSliderMoved = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
          goto _L9
_L5:
        if(mTracking) {
            if(!mSliderMoved)
                animateToggle();
            else
            if(mSliderOffset >= 0 && mSliderOffset <= mSliderPosition / 2)
                animateOff();
            else
                animateOn();
        } else {
            animateToggle();
        }
        mTracking = false;
        mSliderMoved = false;
          goto _L9
        mTracking = false;
        mSliderMoved = false;
          goto _L9
    }

    public void setBarImageResource(int i) {
        createBarBitmap((BitmapDrawable)super.mContext.getResources().getDrawable(i));
    }

    public void setButtonDrawable(Drawable drawable) {
    }

    public void setChecked(boolean flag) {
        super.setChecked(flag);
        if(flag)
            mSliderOffset = mWidth - mSliderWidth;
        else
            mSliderOffset = 0;
        mActiveSlider = mSlider;
        invalidate();
    }

    public void setOnCheckedChangedListener(OnCheckedChangedListener oncheckedchangedlistener) {
        mOnCheckedChangedListener = oncheckedchangedlistener;
    }

    private static final int ANIMATION_FRAME_DURATION = 16;
    private static final float MAXIMUM_MINOR_VELOCITY = 150F;
    private static final int MSG_ANIMATE = 1000;
    private static final int TAP_THRESHOLD = 6;
    private BitmapDrawable mActiveSlider;
    private int mAlphaPixels[];
    private float mAnimatedVelocity;
    private boolean mAnimating;
    private long mAnimationLastTime;
    private float mAnimationPosition;
    private Bitmap mBarBitmap;
    private int mBarSlice[];
    private long mCurrentAnimationTime;
    private BitmapDrawable mFrame;
    private final Handler mHandler;
    private int mHeight;
    private int mLastX;
    private BitmapDrawable mOffDisable;
    private OnCheckedChangedListener mOnCheckedChangedListener;
    private BitmapDrawable mOnDisable;
    private int mOriginalTouchPointX;
    private BitmapDrawable mPressedSlider;
    private BitmapDrawable mSlider;
    private boolean mSliderMoved;
    private int mSliderOffset;
    private int mSliderPosition;
    private int mSliderWidth;
    private int mTapThreshold;
    private boolean mTracking;
    private int mWidth;

}
