// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class Scroller {

    public Scroller(Context context) {
        this(context, null);
    }

    public Scroller(Context context, Interpolator interpolator) {
        boolean flag;
        if(context.getApplicationInfo().targetSdkVersion >= 11)
            flag = true;
        else
            flag = false;
        this(context, interpolator, flag);
    }

    public Scroller(Context context, Interpolator interpolator, boolean flag) {
        mFinished = true;
        mInterpolator = interpolator;
        mPpi = 160F * context.getResources().getDisplayMetrics().density;
        mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        mFlywheel = flag;
    }

    private float computeDeceleration(float f) {
        return f * (386.0878F * mPpi);
    }

    static float viscousFluid(float f) {
        float f1 = f * sViscousFluidScale;
        float f2;
        if(f1 < 1.0F)
            f2 = f1 - (1.0F - (float)Math.exp(-f1));
        else
            f2 = 0.3678795F + (1.0F - (float)Math.exp(1.0F - f1)) * (1.0F - 0.3678795F);
        return f2 * sViscousFluidNormalize;
    }

    public void abortAnimation() {
        mCurrX = mFinalX;
        mCurrY = mFinalY;
        mFinished = true;
    }

    public boolean computeScrollOffset() {
        boolean flag = true;
        if(!mFinished) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        int i = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        if(i < mDuration) {
            switch(mMode) {
            case 0: // '\0'
                float f6 = (float)i * mDurationReciprocal;
                float f7;
                if(mInterpolator == null)
                    f7 = viscousFluid(f6);
                else
                    f7 = mInterpolator.getInterpolation(f6);
                mCurrX = mStartX + Math.round(f7 * mDeltaX);
                mCurrY = mStartY + Math.round(f7 * mDeltaY);
                break;

            case 1: // '\001'
                float f = (float)i / (float)mDuration;
                int j = (int)(100F * f);
                float f1 = (float)j / 100F;
                float f2 = (float)(j + 1) / 100F;
                float f3 = SPLINE[j];
                float f4 = SPLINE[j + 1];
                float f5 = f3 + ((f - f1) / (f2 - f1)) * (f4 - f3);
                mCurrX = mStartX + Math.round(f5 * (float)(mFinalX - mStartX));
                mCurrX = Math.min(mCurrX, mMaxX);
                mCurrX = Math.max(mCurrX, mMinX);
                mCurrY = mStartY + Math.round(f5 * (float)(mFinalY - mStartY));
                mCurrY = Math.min(mCurrY, mMaxY);
                mCurrY = Math.max(mCurrY, mMinY);
                if(mCurrX == mFinalX && mCurrY == mFinalY)
                    mFinished = flag;
                break;
            }
        } else {
            mCurrX = mFinalX;
            mCurrY = mFinalY;
            mFinished = flag;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void extendDuration(int i) {
        mDuration = i + timePassed();
        mDurationReciprocal = 1.0F / (float)mDuration;
        mFinished = false;
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
        if(mFlywheel && !mFinished) {
            float f3 = getCurrVelocity();
            float f4 = mFinalX - mStartX;
            float f5 = mFinalY - mStartY;
            float f6 = FloatMath.sqrt(f4 * f4 + f5 * f5);
            float f7 = f4 / f6;
            float f8 = f5 / f6;
            float f9 = f7 * f3;
            float f10 = f8 * f3;
            if(Math.signum(k) == Math.signum(f9) && Math.signum(l) == Math.signum(f10)) {
                k = (int)(f9 + (float)k);
                l = (int)(f10 + (float)l);
            }
        }
        mMode = 1;
        mFinished = false;
        float f = FloatMath.sqrt(k * k + l * l);
        mVelocity = f;
        double d = Math.log((f * START_TENSION) / ALPHA);
        mDuration = (int)(1000D * Math.exp(d / ((double)DECELERATION_RATE - 1.0D)));
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = i;
        mStartY = j;
        float f1;
        float f2;
        int i2;
        if(f == 0.0F)
            f1 = 1.0F;
        else
            f1 = (float)k / f;
        if(f == 0.0F)
            f2 = 1.0F;
        else
            f2 = (float)l / f;
        i2 = (int)((double)ALPHA * Math.exp(d * ((double)DECELERATION_RATE / ((double)DECELERATION_RATE - 1.0D))));
        mMinX = i1;
        mMaxX = j1;
        mMinY = k1;
        mMaxY = l1;
        mFinalX = i + Math.round(f1 * (float)i2);
        mFinalX = Math.min(mFinalX, mMaxX);
        mFinalX = Math.max(mFinalX, mMinX);
        mFinalY = j + Math.round(f2 * (float)i2);
        mFinalY = Math.min(mFinalY, mMaxY);
        mFinalY = Math.max(mFinalY, mMinY);
    }

    public final void forceFinished(boolean flag) {
        mFinished = flag;
    }

    public float getCurrVelocity() {
        return mVelocity - (mDeceleration * (float)timePassed()) / 2000F;
    }

    public final int getCurrX() {
        return mCurrX;
    }

    public final int getCurrY() {
        return mCurrY;
    }

    public final int getDuration() {
        return mDuration;
    }

    public final int getFinalX() {
        return mFinalX;
    }

    public final int getFinalY() {
        return mFinalY;
    }

    public final int getStartX() {
        return mStartX;
    }

    public final int getStartY() {
        return mStartY;
    }

    public final boolean isFinished() {
        return mFinished;
    }

    public boolean isScrollingInDirection(float f, float f1) {
        boolean flag;
        if(!mFinished && Math.signum(f) == Math.signum(mFinalX - mStartX) && Math.signum(f1) == Math.signum(mFinalY - mStartY))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void setFinalX(int i) {
        mFinalX = i;
        mDeltaX = mFinalX - mStartX;
        mFinished = false;
    }

    public void setFinalY(int i) {
        mFinalY = i;
        mDeltaY = mFinalY - mStartY;
        mFinished = false;
    }

    public final void setFriction(float f) {
        mDeceleration = computeDeceleration(f);
    }

    public void startScroll(int i, int j, int k, int l) {
        startScroll(i, j, k, l, 250);
    }

    public void startScroll(int i, int j, int k, int l, int i1) {
        mMode = 0;
        mFinished = false;
        mDuration = i1;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = i;
        mStartY = j;
        mFinalX = i + k;
        mFinalY = j + l;
        mDeltaX = k;
        mDeltaY = l;
        mDurationReciprocal = 1.0F / (float)mDuration;
    }

    public int timePassed() {
        return (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
    }

    private static float ALPHA = 0F;
    private static float DECELERATION_RATE = 0F;
    private static final int DEFAULT_DURATION = 250;
    private static float END_TENSION = 0F;
    private static final int FLING_MODE = 1;
    private static final int NB_SAMPLES = 100;
    private static final int SCROLL_MODE;
    private static final float SPLINE[];
    private static float START_TENSION;
    private static float sViscousFluidNormalize;
    private static float sViscousFluidScale;
    private int mCurrX;
    private int mCurrY;
    private float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private int mDuration;
    private float mDurationReciprocal;
    private int mFinalX;
    private int mFinalY;
    private boolean mFinished;
    private boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private int mMode;
    private final float mPpi;
    private long mStartTime;
    private int mStartX;
    private int mStartY;
    private float mVelocity;

    static  {
        DECELERATION_RATE = (float)(Math.log(0.75D) / Math.log(0.90000000000000002D));
        ALPHA = 800F;
        START_TENSION = 0.4F;
        END_TENSION = 1.0F - START_TENSION;
        SPLINE = new float[101];
        float f = 0.0F;
        int i = 0;
label0:
        do {
            if(i <= 100) {
                float f1 = (float)i / 100F;
                float f2 = 1.0F;
                do {
                    float f3 = f + (f2 - f) / 2.0F;
                    float f4 = 3F * f3 * (1.0F - f3);
                    float f5 = f4 * ((1.0F - f3) * START_TENSION + f3 * END_TENSION) + f3 * (f3 * f3);
                    if((double)Math.abs(f5 - f1) < 1.0000000000000001E-05D) {
                        float f6 = f4 + f3 * (f3 * f3);
                        SPLINE[i] = f6;
                        i++;
                        continue label0;
                    }
                    if(f5 > f1)
                        f2 = f3;
                    else
                        f = f3;
                } while(true);
            }
            SPLINE[100] = 1.0F;
            sViscousFluidScale = 8F;
            sViscousFluidNormalize = 1.0F;
            sViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
        } while(true);
    }
}
