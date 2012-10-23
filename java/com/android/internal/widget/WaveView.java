// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.widget:
//            DrawableHolder

public class WaveView extends View
    implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public static interface OnTriggerListener {

        public abstract void onGrabbedStateChange(View view, int i);

        public abstract void onTrigger(View view, int i);

        public static final int CENTER_HANDLE = 10;
        public static final int NO_HANDLE;
    }


    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mDrawables = new ArrayList(3);
        mLightWaves = new ArrayList(20);
        mFingerDown = false;
        mRingRadius = 182F;
        mSnapRadius = 136;
        mWaveCount = 20;
        mWaveTimerDelay = 100L;
        mCurrentWave = 0;
        mLockState = 0;
        mGrabbedState = 0;
        mLockTimerActions = new Runnable() {

            public void run() {
                if(mLockState == 3)
                    mLockState = 0;
                if(mLockState == 5)
                    mLockState = 0;
                invalidate();
            }

            final WaveView this$0;

             {
                this$0 = WaveView.this;
                super();
            }
        };
        mAddWaveAction = new Runnable() {

            public void run() {
                int i = (int)Math.ceil(Math.hypot(mMouseX - mLockCenterX, mMouseY - mLockCenterY));
                if(mLockState == 3 && i < mSnapRadius && mWaveTimerDelay >= 100L) {
                    mWaveTimerDelay = Math.min(2000L, 15L + mWaveTimerDelay);
                    DrawableHolder drawableholder = (DrawableHolder)mLightWaves.get(mCurrentWave);
                    drawableholder.setAlpha(0.0F);
                    drawableholder.setScaleX(0.2F);
                    drawableholder.setScaleY(0.2F);
                    drawableholder.setX(mMouseX);
                    drawableholder.setY(mMouseY);
                    drawableholder.addAnimTo(2000L, 0L, "x", mLockCenterX, true);
                    drawableholder.addAnimTo(2000L, 0L, "y", mLockCenterY, true);
                    drawableholder.addAnimTo(1333L, 0L, "alpha", 1.0F, true);
                    drawableholder.addAnimTo(2000L, 0L, "scaleX", 1.0F, true);
                    drawableholder.addAnimTo(2000L, 0L, "scaleY", 1.0F, true);
                    drawableholder.addAnimTo(1000L, 1300L, "alpha", 0.0F, false);
                    drawableholder.startAnimations(WaveView.this);
                    mCurrentWave = (1 + mCurrentWave) % mWaveCount;
                } else {
                    long l1 = <no variable> + this.access$900;
                }
                if(mFinishWaves)
                    mWavesRunning = false;
                else
                    postDelayed(mAddWaveAction, mWaveTimerDelay);
            }

            final WaveView this$0;

             {
                this$0 = WaveView.this;
                super();
            }
        };
        initDrawables();
    }

    private void announceUnlockHandle() {
        setContentDescription(super.mContext.getString(0x10404cd));
        sendAccessibilityEvent(8);
        setContentDescription(null);
    }

    private void dispatchTriggerEvent(int i) {
        vibrate(20L);
        if(mOnTriggerListener != null)
            mOnTriggerListener.onTrigger(this, i);
    }

    private float getScaledGrabHandleRadius() {
        float f;
        if(AccessibilityManager.getInstance(super.mContext).isEnabled())
            f = 1.0F * (float)mUnlockHalo.getWidth();
        else
            f = 0.5F * (float)mUnlockHalo.getWidth();
        return f;
    }

    private void initDrawables() {
        mUnlockRing = new DrawableHolder(createDrawable(0x10805f8));
        mUnlockRing.setX(mLockCenterX);
        mUnlockRing.setY(mLockCenterY);
        mUnlockRing.setScaleX(0.1F);
        mUnlockRing.setScaleY(0.1F);
        mUnlockRing.setAlpha(0.0F);
        mDrawables.add(mUnlockRing);
        mUnlockDefault = new DrawableHolder(createDrawable(0x10805f6));
        mUnlockDefault.setX(mLockCenterX);
        mUnlockDefault.setY(mLockCenterY);
        mUnlockDefault.setScaleX(0.1F);
        mUnlockDefault.setScaleY(0.1F);
        mUnlockDefault.setAlpha(0.0F);
        mDrawables.add(mUnlockDefault);
        mUnlockHalo = new DrawableHolder(createDrawable(0x10805f7));
        mUnlockHalo.setX(mLockCenterX);
        mUnlockHalo.setY(mLockCenterY);
        mUnlockHalo.setScaleX(0.1F);
        mUnlockHalo.setScaleY(0.1F);
        mUnlockHalo.setAlpha(0.0F);
        mDrawables.add(mUnlockHalo);
        BitmapDrawable bitmapdrawable = createDrawable(0x10805f9);
        for(int i = 0; i < mWaveCount; i++) {
            DrawableHolder drawableholder = new DrawableHolder(bitmapdrawable);
            mLightWaves.add(drawableholder);
            drawableholder.setAlpha(0.0F);
        }

    }

    private void setGrabbedState(int i) {
        if(i != mGrabbedState) {
            mGrabbedState = i;
            if(mOnTriggerListener != null)
                mOnTriggerListener.onGrabbedStateChange(this, mGrabbedState);
        }
    }

    private void tryTransitionToStartAttemptState(MotionEvent motionevent) {
        float f = motionevent.getX() - mUnlockHalo.getX();
        float f1 = motionevent.getY() - mUnlockHalo.getY();
        if((float)Math.hypot(f, f1) <= getScaledGrabHandleRadius()) {
            setGrabbedState(10);
            if(mLockState == 1) {
                mLockState = 2;
                if(AccessibilityManager.getInstance(super.mContext).isEnabled())
                    announceUnlockHandle();
            }
        }
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

    private void waveUpdateFrame(float f, float f1, boolean flag) {
        int i;
        float f2;
        float f3;
        double d = f - mLockCenterX;
        double d1 = f1 - mLockCenterY;
        i = (int)Math.ceil(Math.hypot(d, d1));
        double d2 = Math.atan2(d, d1);
        f2 = (float)((double)mLockCenterX + (double)mRingRadius * Math.sin(d2));
        f3 = (float)((double)mLockCenterY + (double)mRingRadius * Math.cos(d2));
        mLockState;
        JVM INSTR tableswitch 0 5: default 124
    //                   0 149
    //                   1 711
    //                   2 721
    //                   3 938
    //                   4 1152
    //                   5 1836;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        mUnlockDefault.startAnimations(this);
        mUnlockHalo.startAnimations(this);
        mUnlockRing.startAnimations(this);
        return;
_L2:
        mWaveTimerDelay = 100L;
        int j1 = 0;
        do {
            int k1 = mLightWaves.size();
            if(j1 >= k1)
                break;
            ((DrawableHolder)mLightWaves.get(j1)).addAnimTo(300L, 0L, "alpha", 0.0F, false);
            j1++;
        } while(true);
        int i2 = 0;
        do {
            int j2 = mLightWaves.size();
            if(i2 >= j2)
                break;
            ((DrawableHolder)mLightWaves.get(i2)).startAnimations(this);
            i2++;
        } while(true);
        mUnlockRing.addAnimTo(300L, 0L, "x", mLockCenterX, true);
        mUnlockRing.addAnimTo(300L, 0L, "y", mLockCenterY, true);
        mUnlockRing.addAnimTo(300L, 0L, "scaleX", 0.1F, true);
        mUnlockRing.addAnimTo(300L, 0L, "scaleY", 0.1F, true);
        mUnlockRing.addAnimTo(300L, 0L, "alpha", 0.0F, true);
        mUnlockDefault.removeAnimationFor("x");
        mUnlockDefault.removeAnimationFor("y");
        mUnlockDefault.removeAnimationFor("scaleX");
        mUnlockDefault.removeAnimationFor("scaleY");
        mUnlockDefault.removeAnimationFor("alpha");
        mUnlockDefault.setX(mLockCenterX);
        mUnlockDefault.setY(mLockCenterY);
        mUnlockDefault.setScaleX(0.1F);
        mUnlockDefault.setScaleY(0.1F);
        mUnlockDefault.setAlpha(0.0F);
        mUnlockDefault.addAnimTo(300L, 100L, "scaleX", 1.0F, true);
        mUnlockDefault.addAnimTo(300L, 100L, "scaleY", 1.0F, true);
        mUnlockDefault.addAnimTo(300L, 100L, "alpha", 1.0F, true);
        mUnlockHalo.removeAnimationFor("x");
        mUnlockHalo.removeAnimationFor("y");
        mUnlockHalo.removeAnimationFor("scaleX");
        mUnlockHalo.removeAnimationFor("scaleY");
        mUnlockHalo.removeAnimationFor("alpha");
        mUnlockHalo.setX(mLockCenterX);
        mUnlockHalo.setY(mLockCenterY);
        mUnlockHalo.setScaleX(0.1F);
        mUnlockHalo.setScaleY(0.1F);
        mUnlockHalo.setAlpha(0.0F);
        mUnlockHalo.addAnimTo(300L, 100L, "x", mLockCenterX, true);
        mUnlockHalo.addAnimTo(300L, 100L, "y", mLockCenterY, true);
        mUnlockHalo.addAnimTo(300L, 100L, "scaleX", 1.0F, true);
        mUnlockHalo.addAnimTo(300L, 100L, "scaleY", 1.0F, true);
        mUnlockHalo.addAnimTo(300L, 100L, "alpha", 1.0F, true);
        removeCallbacks(mLockTimerActions);
        mLockState = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        mWaveTimerDelay = 100L;
        continue; /* Loop/switch isn't completed */
_L4:
        mUnlockDefault.removeAnimationFor("x");
        mUnlockDefault.removeAnimationFor("y");
        mUnlockDefault.removeAnimationFor("scaleX");
        mUnlockDefault.removeAnimationFor("scaleY");
        mUnlockDefault.removeAnimationFor("alpha");
        mUnlockDefault.setX(182F + mLockCenterX);
        mUnlockDefault.setY(mLockCenterY);
        mUnlockDefault.setScaleX(0.1F);
        mUnlockDefault.setScaleY(0.1F);
        mUnlockDefault.setAlpha(0.0F);
        mUnlockDefault.addAnimTo(300L, 100L, "scaleX", 1.0F, false);
        mUnlockDefault.addAnimTo(300L, 100L, "scaleY", 1.0F, false);
        mUnlockDefault.addAnimTo(300L, 100L, "alpha", 1.0F, false);
        mUnlockRing.addAnimTo(300L, 0L, "scaleX", 1.0F, true);
        mUnlockRing.addAnimTo(300L, 0L, "scaleY", 1.0F, true);
        mUnlockRing.addAnimTo(300L, 0L, "alpha", 1.0F, true);
        mLockState = 3;
        continue; /* Loop/switch isn't completed */
_L5:
        if(i > mSnapRadius) {
            mFinishWaves = true;
            if(flag) {
                mUnlockHalo.addAnimTo(0L, 0L, "x", f2, true);
                mUnlockHalo.addAnimTo(0L, 0L, "y", f3, true);
                mUnlockHalo.addAnimTo(0L, 0L, "scaleX", 1.0F, true);
                mUnlockHalo.addAnimTo(0L, 0L, "scaleY", 1.0F, true);
                mUnlockHalo.addAnimTo(0L, 0L, "alpha", 1.0F, true);
            } else {
                mLockState = 4;
            }
        } else {
            if(!mWavesRunning) {
                mWavesRunning = true;
                mFinishWaves = false;
                postDelayed(mAddWaveAction, mWaveTimerDelay);
            }
            mUnlockHalo.addAnimTo(0L, 0L, "x", f, true);
            mUnlockHalo.addAnimTo(0L, 0L, "y", f1, true);
            mUnlockHalo.addAnimTo(0L, 0L, "scaleX", 1.0F, true);
            mUnlockHalo.addAnimTo(0L, 0L, "scaleY", 1.0F, true);
            mUnlockHalo.addAnimTo(0L, 0L, "alpha", 1.0F, true);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if(i > mSnapRadius) {
            int j = 0;
            do {
                int k = mLightWaves.size();
                if(j >= k)
                    break;
                DrawableHolder drawableholder = (DrawableHolder)mLightWaves.get(j);
                long l1 = (1000L * (long)((j + 6) - mCurrentWave)) / 10L;
                drawableholder.addAnimTo(200L, l1, "x", f2, true);
                drawableholder.addAnimTo(200L, l1, "y", f3, true);
                drawableholder.addAnimTo(200L, l1, "scaleX", 0.1F, true);
                drawableholder.addAnimTo(200L, l1, "scaleY", 0.1F, true);
                drawableholder.addAnimTo(200L, l1, "alpha", 0.0F, true);
                j++;
            } while(true);
            int l = 0;
            do {
                int i1 = mLightWaves.size();
                if(l >= i1)
                    break;
                ((DrawableHolder)mLightWaves.get(l)).startAnimations(this);
                l++;
            } while(true);
            mUnlockRing.addAnimTo(200L, 0L, "x", f2, false);
            mUnlockRing.addAnimTo(200L, 0L, "y", f3, false);
            mUnlockRing.addAnimTo(200L, 0L, "scaleX", 0.1F, false);
            mUnlockRing.addAnimTo(200L, 0L, "scaleY", 0.1F, false);
            mUnlockRing.addAnimTo(200L, 0L, "alpha", 0.0F, false);
            mUnlockRing.addAnimTo(200L, 200L, "alpha", 0.0F, false);
            mUnlockDefault.removeAnimationFor("x");
            mUnlockDefault.removeAnimationFor("y");
            mUnlockDefault.removeAnimationFor("scaleX");
            mUnlockDefault.removeAnimationFor("scaleY");
            mUnlockDefault.removeAnimationFor("alpha");
            mUnlockDefault.setX(f2);
            mUnlockDefault.setY(f3);
            mUnlockDefault.setScaleX(0.1F);
            mUnlockDefault.setScaleY(0.1F);
            mUnlockDefault.setAlpha(0.0F);
            mUnlockDefault.addAnimTo(200L, 0L, "x", f2, true);
            mUnlockDefault.addAnimTo(200L, 0L, "y", f3, true);
            mUnlockDefault.addAnimTo(200L, 0L, "scaleX", 1.0F, true);
            mUnlockDefault.addAnimTo(200L, 0L, "scaleY", 1.0F, true);
            mUnlockDefault.addAnimTo(200L, 0L, "alpha", 1.0F, true);
            mUnlockDefault.addAnimTo(200L, 200L, "scaleX", 3F, false);
            mUnlockDefault.addAnimTo(200L, 200L, "scaleY", 3F, false);
            mUnlockDefault.addAnimTo(200L, 200L, "alpha", 0.0F, false);
            mUnlockHalo.addAnimTo(200L, 0L, "x", f2, false);
            mUnlockHalo.addAnimTo(200L, 0L, "y", f3, false);
            mUnlockHalo.addAnimTo(200L, 200L, "scaleX", 3F, false);
            mUnlockHalo.addAnimTo(200L, 200L, "scaleY", 3F, false);
            mUnlockHalo.addAnimTo(200L, 200L, "alpha", 0.0F, false);
            removeCallbacks(mLockTimerActions);
            postDelayed(mLockTimerActions, 3000L);
            dispatchTriggerEvent(10);
            mLockState = 5;
        } else {
            mLockState = 0;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        removeCallbacks(mAddWaveAction);
        if(true) goto _L1; else goto _L8
_L8:
    }

    BitmapDrawable createDrawable(int i) {
        android.content.res.Resources resources = getResources();
        return new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, i));
    }

    protected int getSuggestedMinimumHeight() {
        return mUnlockRing.getHeight() + mUnlockHalo.getHeight();
    }

    protected int getSuggestedMinimumWidth() {
        return mUnlockRing.getWidth() + mUnlockHalo.getWidth();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator) {
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        waveUpdateFrame(mMouseX, mMouseY, mFingerDown);
        for(int i = 0; i < mDrawables.size(); i++)
            ((DrawableHolder)mDrawables.get(i)).draw(canvas);

        for(int j = 0; j < mLightWaves.size(); j++)
            ((DrawableHolder)mLightWaves.get(j)).draw(canvas);

    }

    public boolean onHoverEvent(MotionEvent motionevent) {
        if(!AccessibilityManager.getInstance(super.mContext).isTouchExplorationEnabled()) goto _L2; else goto _L1
_L1:
        int i = motionevent.getAction();
        i;
        JVM INSTR tableswitch 7 10: default 48
    //                   7 73
    //                   8 48
    //                   9 65
    //                   10 81;
           goto _L3 _L4 _L3 _L5 _L6
_L3:
        onTouchEvent(motionevent);
        motionevent.setAction(i);
_L2:
        return super.onHoverEvent(motionevent);
_L5:
        motionevent.setAction(0);
        continue; /* Loop/switch isn't completed */
_L4:
        motionevent.setAction(2);
        continue; /* Loop/switch isn't completed */
_L6:
        motionevent.setAction(1);
        if(true) goto _L3; else goto _L7
_L7:
    }

    protected void onMeasure(int i, int j) {
        int k = android.view.View.MeasureSpec.getMode(i);
        int l = android.view.View.MeasureSpec.getMode(j);
        int i1 = android.view.View.MeasureSpec.getSize(i);
        int j1 = android.view.View.MeasureSpec.getSize(j);
        int k1;
        int l1;
        if(k == 0x80000000)
            k1 = Math.min(i1, getSuggestedMinimumWidth());
        else
        if(k == 0x40000000)
            k1 = i1;
        else
            k1 = getSuggestedMinimumWidth();
        if(l == 0x80000000)
            l1 = Math.min(j1, getSuggestedMinimumWidth());
        else
        if(l == 0x40000000)
            l1 = j1;
        else
            l1 = getSuggestedMinimumHeight();
        setMeasuredDimension(k1, l1);
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        mLockCenterX = 0.5F * (float)i;
        mLockCenterY = 0.5F * (float)j;
        super.onSizeChanged(i, j, k, l);
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        int i;
        boolean flag1;
        flag = true;
        i = motionevent.getAction();
        mMouseX = motionevent.getX();
        mMouseY = motionevent.getY();
        flag1 = false;
        i;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 67
    //                   1 103
    //                   2 92
    //                   3 147;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_147;
_L6:
        invalidate();
        if(!flag1)
            flag = super.onTouchEvent(motionevent);
        return flag;
_L2:
        removeCallbacks(mLockTimerActions);
        mFingerDown = flag;
        tryTransitionToStartAttemptState(motionevent);
        flag1 = true;
          goto _L6
_L4:
        tryTransitionToStartAttemptState(motionevent);
        flag1 = true;
          goto _L6
_L3:
        mFingerDown = false;
        postDelayed(mLockTimerActions, 3000L);
        setGrabbedState(0);
        waveUpdateFrame(mMouseX, mMouseY, mFingerDown);
        flag1 = true;
          goto _L6
        mFingerDown = false;
        flag1 = true;
          goto _L6
    }

    public void reset() {
        mLockState = 0;
        invalidate();
    }

    public void setOnTriggerListener(OnTriggerListener ontriggerlistener) {
        mOnTriggerListener = ontriggerlistener;
    }

    private static final boolean DBG = false;
    private static final long DELAY_INCREMENT = 15L;
    private static final long DELAY_INCREMENT2 = 12L;
    private static final long DURATION = 300L;
    private static final long FINAL_DELAY = 200L;
    private static final long FINAL_DURATION = 200L;
    private static final float GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_DISABLED = 0.5F;
    private static final float GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1F;
    private static final long RESET_TIMEOUT = 3000L;
    private static final long RING_DELAY = 1300L;
    private static final long SHORT_DELAY = 100L;
    private static final int STATE_ATTEMPTING = 3;
    private static final int STATE_READY = 1;
    private static final int STATE_RESET_LOCK = 0;
    private static final int STATE_START_ATTEMPT = 2;
    private static final int STATE_UNLOCK_ATTEMPT = 4;
    private static final int STATE_UNLOCK_SUCCESS = 5;
    private static final String TAG = "WaveView";
    private static final long VIBRATE_LONG = 20L;
    private static final long VIBRATE_SHORT = 20L;
    private static final int WAVE_COUNT = 20;
    private static final long WAVE_DELAY = 100L;
    private static final long WAVE_DURATION = 2000L;
    private final Runnable mAddWaveAction;
    private int mCurrentWave;
    private ArrayList mDrawables;
    private boolean mFingerDown;
    private boolean mFinishWaves;
    private int mGrabbedState;
    private ArrayList mLightWaves;
    private float mLockCenterX;
    private float mLockCenterY;
    private int mLockState;
    private final Runnable mLockTimerActions;
    private float mMouseX;
    private float mMouseY;
    private OnTriggerListener mOnTriggerListener;
    private float mRingRadius;
    private int mSnapRadius;
    private DrawableHolder mUnlockDefault;
    private DrawableHolder mUnlockHalo;
    private DrawableHolder mUnlockRing;
    private Vibrator mVibrator;
    private int mWaveCount;
    private long mWaveTimerDelay;
    private boolean mWavesRunning;



/*
    static int access$002(WaveView waveview, int i) {
        waveview.mLockState = i;
        return i;
    }

*/




/*
    static boolean access$1102(WaveView waveview, boolean flag) {
        waveview.mWavesRunning = flag;
        return flag;
    }

*/








/*
    static long access$602(WaveView waveview, long l) {
        waveview.mWaveTimerDelay = l;
        return l;
    }

*/


/*
    static long access$614(WaveView waveview, long l) {
        long l1 = l + waveview.mWaveTimerDelay;
        waveview.mWaveTimerDelay = l1;
        return l1;
    }

*/



/*
    static int access$702(WaveView waveview, int i) {
        waveview.mCurrentWave = i;
        return i;
    }

*/


}
