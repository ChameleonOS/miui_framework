// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.*;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

// Referenced classes of package android.widget:
//            Scroller

public class OverScroller {
    static class SplineOverScroller {

        private void adjustDuration(int i, int j, int k) {
            int l = j - i;
            float f = Math.abs((float)(k - i) / (float)l);
            int i1 = (int)(100F * f);
            if(i1 < 100) {
                float f1 = (float)i1 / 100F;
                float f2 = (float)(i1 + 1) / 100F;
                float f3 = SPLINE_TIME[i1];
                float f4 = SPLINE_TIME[i1 + 1];
                mDuration = (int)((f3 + ((f - f1) / (f2 - f1)) * (f4 - f3)) * (float)mDuration);
            }
        }

        private void fitOnBounceCurve(int i, int j, int k) {
            float f = (float)(-k) / mDeceleration;
            float f1 = (float)Math.sqrt((2D * (double)((float)(k * k) / 2.0F / Math.abs(mDeceleration) + (float)Math.abs(j - i))) / (double)Math.abs(mDeceleration));
            mStartTime = mStartTime - (long)(int)(1000F * (f1 - f));
            mStart = j;
            mVelocity = (int)(f1 * -mDeceleration);
        }

        private static float getDeceleration(int i) {
            float f;
            if(i > 0)
                f = -2000F;
            else
                f = 2000F;
            return f;
        }

        private double getSplineDeceleration(int i) {
            return Math.log((0.35F * (float)Math.abs(i)) / (mFlingFriction * PHYSICAL_COEF));
        }

        private double getSplineFlingDistance(int i) {
            double d = getSplineDeceleration(i);
            double d1 = (double)DECELERATION_RATE - 1.0D;
            return (double)(mFlingFriction * PHYSICAL_COEF) * Math.exp(d * ((double)DECELERATION_RATE / d1));
        }

        private int getSplineFlingDuration(int i) {
            return (int)(1000D * Math.exp(getSplineDeceleration(i) / ((double)DECELERATION_RATE - 1.0D)));
        }

        static void initFromContext(Context context) {
            PHYSICAL_COEF = 0.84F * (386.0878F * (160F * context.getResources().getDisplayMetrics().density));
        }

        private void onEdgeReached() {
            float f = (float)(mVelocity * mVelocity) / (2.0F * Math.abs(mDeceleration));
            float f1 = Math.signum(mVelocity);
            if(f > (float)mOver) {
                mDeceleration = (-f1 * (float)mVelocity * (float)mVelocity) / (2.0F * (float)mOver);
                f = mOver;
            }
            mOver = (int)f;
            mState = 2;
            int i = mStart;
            if(mVelocity <= 0)
                f = -f;
            mFinal = i + (int)f;
            mDuration = -(int)((1000F * (float)mVelocity) / mDeceleration);
        }

        private void startAfterEdge(int i, int j, int k, int l) {
            if(i > j && i < k) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                mFinished = true;
            } else {
                boolean flag;
                int i1;
                int j1;
                boolean flag1;
                if(i > k)
                    flag = true;
                else
                    flag = false;
                if(flag)
                    i1 = k;
                else
                    i1 = j;
                j1 = i - i1;
                if(j1 * l >= 0)
                    flag1 = true;
                else
                    flag1 = false;
                if(flag1)
                    startBounceAfterEdge(i, i1, l);
                else
                if(getSplineFlingDistance(l) > (double)Math.abs(j1)) {
                    int k1;
                    int l1;
                    if(flag)
                        k1 = j;
                    else
                        k1 = i;
                    if(flag)
                        l1 = i;
                    else
                        l1 = k;
                    fling(i, l, k1, l1, mOver);
                } else {
                    startSpringback(i, i1, l);
                }
            }
        }

        private void startBounceAfterEdge(int i, int j, int k) {
            int l;
            if(k == 0)
                l = i - j;
            else
                l = k;
            mDeceleration = getDeceleration(l);
            fitOnBounceCurve(i, j, k);
            onEdgeReached();
        }

        private void startSpringback(int i, int j, int k) {
            mFinished = false;
            mState = 1;
            mStart = i;
            mFinal = j;
            int l = i - j;
            mDeceleration = getDeceleration(l);
            mVelocity = -l;
            mOver = Math.abs(l);
            mDuration = (int)(1000D * Math.sqrt((-2D * (double)l) / (double)mDeceleration));
        }

        boolean continueWhenFinished() {
            boolean flag = false;
            mState;
            JVM INSTR tableswitch 0 2: default 32
        //                       0 41
        //                       1 39
        //                       2 101;
               goto _L1 _L2 _L3 _L4
_L1:
            update();
            flag = true;
_L3:
            return flag;
_L2:
            if(mDuration >= mSplineDuration) goto _L3; else goto _L5
_L5:
            mStart = mFinal;
            mVelocity = (int)mCurrVelocity;
            mDeceleration = getDeceleration(mVelocity);
            mStartTime = mStartTime + (long)mDuration;
            onEdgeReached();
            continue; /* Loop/switch isn't completed */
_L4:
            mStartTime = mStartTime + (long)mDuration;
            startSpringback(mFinal, mStart, 0);
            if(true) goto _L1; else goto _L6
_L6:
        }

        void extendDuration(int i) {
            mDuration = i + (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
            mFinished = false;
        }

        void finish() {
            mCurrentPosition = mFinal;
            mFinished = true;
        }

        void fling(int i, int j, int k, int l, int i1) {
            mOver = i1;
            mFinished = false;
            mVelocity = j;
            mCurrVelocity = j;
            mSplineDuration = 0;
            mDuration = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mStart = i;
            mCurrentPosition = i;
            if(i <= l && i >= k) goto _L2; else goto _L1
_L1:
            startAfterEdge(i, k, l, j);
_L4:
            return;
_L2:
            mState = 0;
            double d = 0.0D;
            if(j != 0) {
                int j1 = getSplineFlingDuration(j);
                mSplineDuration = j1;
                mDuration = j1;
                d = getSplineFlingDistance(j);
            }
            mSplineDistance = (int)(d * (double)Math.signum(j));
            mFinal = i + mSplineDistance;
            if(mFinal < k) {
                adjustDuration(mStart, mFinal, k);
                mFinal = k;
            }
            if(mFinal > l) {
                adjustDuration(mStart, mFinal, l);
                mFinal = l;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        void notifyEdgeReached(int i, int j, int k) {
            if(mState == 0) {
                mOver = k;
                mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i, j, j, (int)mCurrVelocity);
            }
        }

        void setFinalPosition(int i) {
            mFinal = i;
            mFinished = false;
        }

        void setFriction(float f) {
            mFlingFriction = f;
        }

        boolean springback(int i, int j, int k) {
            boolean flag = true;
            mFinished = flag;
            mFinal = i;
            mStart = i;
            mVelocity = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = 0;
            if(i < j)
                startSpringback(i, j, 0);
            else
            if(i > k)
                startSpringback(i, k, 0);
            if(mFinished)
                flag = false;
            return flag;
        }

        void startScroll(int i, int j, int k) {
            mFinished = false;
            mStart = i;
            mFinal = i + j;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = k;
            mDeceleration = 0.0F;
            mVelocity = 0;
        }

        boolean update() {
            long l = AnimationUtils.currentAnimationTimeMillis() - mStartTime;
            if(l <= (long)mDuration) goto _L2; else goto _L1
_L1:
            boolean flag = false;
_L8:
            return flag;
_L2:
            double d = 0.0D;
            mState;
            JVM INSTR tableswitch 0 2: default 56
        //                       0 76
        //                       1 249
        //                       2 199;
               goto _L3 _L4 _L5 _L6
_L5:
            break MISSING_BLOCK_LABEL_249;
_L3:
            break; /* Loop/switch isn't completed */
_L4:
            break; /* Loop/switch isn't completed */
_L9:
            mCurrentPosition = mStart + (int)Math.round(d);
            flag = true;
            if(true) goto _L8; else goto _L7
_L7:
            float f4 = (float)l / (float)mSplineDuration;
            int i = (int)(100F * f4);
            float f5 = 1.0F;
            float f6 = 0.0F;
            if(i < 100) {
                float f7 = (float)i / 100F;
                float f8 = (float)(i + 1) / 100F;
                float f9 = SPLINE_POSITION[i];
                f6 = (SPLINE_POSITION[i + 1] - f9) / (f8 - f7);
                f5 = f9 + f6 * (f4 - f7);
            }
            d = f5 * (float)mSplineDistance;
            mCurrVelocity = 1000F * ((f6 * (float)mSplineDistance) / (float)mSplineDuration);
              goto _L9
_L6:
            float f3 = (float)l / 1000F;
            mCurrVelocity = (float)mVelocity + f3 * mDeceleration;
            d = f3 * (float)mVelocity + (f3 * (f3 * mDeceleration)) / 2.0F;
              goto _L9
            float f = (float)l / (float)mDuration;
            float f1 = f * f;
            float f2 = Math.signum(mVelocity);
            d = f2 * (float)mOver * (3F * f1 - f1 * (2.0F * f));
            mCurrVelocity = 6F * (f2 * (float)mOver) * (f1 + -f);
              goto _L9
        }

        void updateScroll(float f) {
            mCurrentPosition = mStart + Math.round(f * (float)(mFinal - mStart));
        }

        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static float DECELERATION_RATE = 0F;
        private static final float END_TENSION = 1F;
        private static final float GRAVITY = 2000F;
        private static final float INFLEXION = 0.35F;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175F;
        private static final float P2 = 0.35F;
        private static float PHYSICAL_COEF = 0F;
        private static final int SPLINE = 0;
        private static final float SPLINE_POSITION[];
        private static final float SPLINE_TIME[];
        private static final float START_TENSION = 0.5F;
        private float mCurrVelocity;
        private int mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private int mFinal;
        private boolean mFinished;
        private float mFlingFriction;
        private int mOver;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mStart;
        private long mStartTime;
        private int mState;
        private int mVelocity;

        static  {
            float f;
            float f1;
            int i;
            DECELERATION_RATE = (float)(Math.log(0.78000000000000003D) / Math.log(0.90000000000000002D));
            SPLINE_POSITION = new float[101];
            SPLINE_TIME = new float[101];
            f = 0.0F;
            f1 = 0.0F;
            i = 0;
_L6:
            float f2;
            float f3;
            if(i >= 100)
                break MISSING_BLOCK_LABEL_288;
            f2 = (float)i / 100F;
            f3 = 1.0F;
_L3:
            float f4;
            float f5;
            float f6;
            f4 = f + (f3 - f) / 2.0F;
            f5 = 3F * f4 * (1.0F - f4);
            f6 = f5 * (0.175F * (1.0F - f4) + 0.35F * f4) + f4 * (f4 * f4);
            if((double)Math.abs(f6 - f2) >= 1.0000000000000001E-05D) goto _L2; else goto _L1
_L1:
            float f7;
            SPLINE_POSITION[i] = f5 * (f4 + 0.5F * (1.0F - f4)) + f4 * (f4 * f4);
            f7 = 1.0F;
_L4:
            float f8;
            float f10;
            f8 = f1 + (f7 - f1) / 2.0F;
            float f9 = 3F * f8 * (1.0F - f8);
            f10 = f9 * (f8 + 0.5F * (1.0F - f8)) + f8 * (f8 * f8);
            if((double)Math.abs(f10 - f2) < 1.0000000000000001E-05D) {
                SPLINE_TIME[i] = f9 * (0.175F * (1.0F - f8) + 0.35F * f8) + f8 * (f8 * f8);
                i++;
                continue; /* Loop/switch isn't completed */
            }
            break MISSING_BLOCK_LABEL_267;
_L2:
            if(f6 > f2)
                f3 = f4;
            else
                f = f4;
              goto _L3
            if(f10 > f2)
                f7 = f8;
            else
                f1 = f8;
              goto _L4
            float af[] = SPLINE_POSITION;
            SPLINE_TIME[100] = 1.0F;
            af[100] = 1.0F;
            if(true) goto _L6; else goto _L5
_L5:
        }



/*
        static boolean access$002(SplineOverScroller splineoverscroller, boolean flag) {
            splineoverscroller.mFinished = flag;
            return flag;
        }

*/








        SplineOverScroller() {
            mFlingFriction = ViewConfiguration.getScrollFriction();
            mState = 0;
            mFinished = true;
        }
    }


    public OverScroller(Context context) {
        this(context, null);
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f1) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f1, boolean flag) {
        this(context, interpolator, flag);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean flag) {
        mInterpolator = interpolator;
        mFlywheel = flag;
        mScrollerX = new SplineOverScroller();
        mScrollerY = new SplineOverScroller();
        SplineOverScroller.initFromContext(context);
    }

    public void abortAnimation() {
        mScrollerX.finish();
        mScrollerY.finish();
    }

    public boolean computeScrollOffset() {
        if(!isFinished()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        switch(mMode) {
        default:
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break;
        }
        break MISSING_BLOCK_LABEL_136;
_L5:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        long l = AnimationUtils.currentAnimationTimeMillis() - mScrollerX.mStartTime;
        int i = mScrollerX.mDuration;
        if(l < (long)i) {
            float f = (float)l / (float)i;
            float f1;
            if(mInterpolator == null)
                f1 = Scroller.viscousFluid(f);
            else
                f1 = mInterpolator.getInterpolation(f);
            mScrollerX.updateScroll(f1);
            mScrollerY.updateScroll(f1);
        } else {
            abortAnimation();
        }
          goto _L5
        if(!mScrollerX.mFinished && !mScrollerX.update() && !mScrollerX.continueWhenFinished())
            mScrollerX.finish();
        if(!mScrollerY.mFinished && !mScrollerY.update() && !mScrollerY.continueWhenFinished())
            mScrollerY.finish();
          goto _L5
    }

    public void extendDuration(int i) {
        mScrollerX.extendDuration(i);
        mScrollerY.extendDuration(i);
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
        fling(i, j, k, l, i1, j1, k1, l1, 0, 0);
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2) {
        if(mFlywheel && !isFinished()) {
            float f = mScrollerX.mCurrVelocity;
            float f1 = mScrollerY.mCurrVelocity;
            if(Math.signum(k) == Math.signum(f) && Math.signum(l) == Math.signum(f1)) {
                k = (int)(f + (float)k);
                l = (int)(f1 + (float)l);
            }
        }
        mMode = 1;
        mScrollerX.fling(i, k, i1, j1, i2);
        mScrollerY.fling(j, l, k1, l1, j2);
    }

    public final void forceFinished(boolean flag) {
        mScrollerX.mFinished = mScrollerY.mFinished = flag;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt(mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity + mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity);
    }

    public final int getCurrX() {
        return mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return mScrollerY.mCurrentPosition;
    }

    public final int getDuration() {
        return Math.max(mScrollerX.mDuration, mScrollerY.mDuration);
    }

    public final int getFinalX() {
        return mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return mScrollerY.mFinal;
    }

    public final int getStartX() {
        return mScrollerX.mStart;
    }

    public final int getStartY() {
        return mScrollerY.mStart;
    }

    public final boolean isFinished() {
        boolean flag;
        if(mScrollerX.mFinished && mScrollerY.mFinished)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isOverScrolled() {
        boolean flag;
        if(!mScrollerX.mFinished && mScrollerX.mState != 0 || !mScrollerY.mFinished && mScrollerY.mState != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isScrollingInDirection(float f, float f1) {
        int i = mScrollerX.mFinal - mScrollerX.mStart;
        int j = mScrollerY.mFinal - mScrollerY.mStart;
        boolean flag;
        if(!isFinished() && Math.signum(f) == Math.signum(i) && Math.signum(f1) == Math.signum(j))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void notifyHorizontalEdgeReached(int i, int j, int k) {
        mScrollerX.notifyEdgeReached(i, j, k);
    }

    public void notifyVerticalEdgeReached(int i, int j, int k) {
        mScrollerY.notifyEdgeReached(i, j, k);
    }

    public void setFinalX(int i) {
        mScrollerX.setFinalPosition(i);
    }

    public void setFinalY(int i) {
        mScrollerY.setFinalPosition(i);
    }

    public final void setFriction(float f) {
        mScrollerX.setFriction(f);
        mScrollerY.setFriction(f);
    }

    void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    public boolean springBack(int i, int j, int k, int l, int i1, int j1) {
        boolean flag = true;
        mMode = ((flag) ? 1 : 0);
        boolean flag1 = mScrollerX.springback(i, k, l);
        boolean flag2 = mScrollerY.springback(j, i1, j1);
        if(!flag1 && !flag2)
            flag = false;
        return flag;
    }

    public void startScroll(int i, int j, int k, int l) {
        startScroll(i, j, k, l, 250);
    }

    public void startScroll(int i, int j, int k, int l, int i1) {
        mMode = 0;
        mScrollerX.startScroll(i, k, i1);
        mScrollerY.startScroll(j, l, i1);
    }

    public int timePassed() {
        return (int)(AnimationUtils.currentAnimationTimeMillis() - Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime));
    }

    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;
}
