// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package miui.animation:
//            AnimatorBuilder

public class ViewPropertyAnimator extends Animator {
    public static class Builder extends AnimatorBuilder {

        public volatile AnimatorBuilder addListener(android.animation.Animator.AnimatorListener animatorlistener) {
            return addListener(animatorlistener);
        }

        public Builder addListener(android.animation.Animator.AnimatorListener animatorlistener) {
            super.mAnimator.addListener(animatorlistener);
            return this;
        }

        public volatile AnimatorBuilder setDuration(long l) {
            return setDuration(l);
        }

        public Builder setDuration(long l) {
            super.mAnimator.setDuration(l);
            return this;
        }

        public Builder setFinalValue(float f) {
            ((ViewPropertyAnimator)super.mAnimator).setFinalValue(f);
            return this;
        }

        public Builder setFinalVisibility(int i) {
            ((ViewPropertyAnimator)super.mAnimator).setFinalVisibility(i);
            return this;
        }

        public volatile AnimatorBuilder setInterpolator(TimeInterpolator timeinterpolator) {
            return setInterpolator(timeinterpolator);
        }

        public Builder setInterpolator(TimeInterpolator timeinterpolator) {
            super.mAnimator.setInterpolator(timeinterpolator);
            return this;
        }

        public Builder setRepeatCount(int i) {
            ((ViewPropertyAnimator)super.mAnimator).setRepeatCount(i);
            return this;
        }

        public Builder setRepeatMode(int i) {
            ((ViewPropertyAnimator)super.mAnimator).setRepeatMode(i);
            return this;
        }

        public volatile AnimatorBuilder setStartDelay(long l) {
            return setStartDelay(l);
        }

        public Builder setStartDelay(long l) {
            super.mAnimator.setStartDelay(l);
            return this;
        }

        public Builder(ViewPropertyAnimator viewpropertyanimator) {
            super(viewpropertyanimator);
        }
    }


    public ViewPropertyAnimator(View view, int i, float f, float f1) {
        float af[] = new float[1];
        af[0] = 1.0F;
        mAnimator = ValueAnimator.ofFloat(af);
        mFinalVisibility = -1;
        mFinalValue = 1.401298E-45F;
        mView = view;
        mProperty = i;
        mFromValue = f;
        mToValue = f1;
        mAnimator.addListener(new android.animation.Animator.AnimatorListener() {

            public void onAnimationCancel(Animator animator) {
                ViewPropertyAnimator.setAnimator(mView, null);
                setFinalValues();
                ArrayList arraylist = getListeners();
                if(arraylist != null) {
                    for(Iterator iterator = ((ArrayList)arraylist.clone()).iterator(); iterator.hasNext(); ((android.animation.Animator.AnimatorListener)iterator.next()).onAnimationCancel(ViewPropertyAnimator.this));
                }
            }

            public void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator.setAnimator(mView, null);
                setFinalValues();
                ArrayList arraylist = getListeners();
                if(arraylist != null) {
                    for(Iterator iterator = ((ArrayList)arraylist.clone()).iterator(); iterator.hasNext(); ((android.animation.Animator.AnimatorListener)iterator.next()).onAnimationEnd(ViewPropertyAnimator.this));
                }
            }

            public void onAnimationRepeat(Animator animator) {
                ArrayList arraylist = getListeners();
                if(arraylist != null) {
                    for(Iterator iterator = ((ArrayList)arraylist.clone()).iterator(); iterator.hasNext(); ((android.animation.Animator.AnimatorListener)iterator.next()).onAnimationRepeat(ViewPropertyAnimator.this));
                }
            }

            public void onAnimationStart(Animator animator) {
                ArrayList arraylist = getListeners();
                if(arraylist != null) {
                    for(Iterator iterator = ((ArrayList)arraylist.clone()).iterator(); iterator.hasNext(); ((android.animation.Animator.AnimatorListener)iterator.next()).onAnimationStart(ViewPropertyAnimator.this));
                }
            }

            final ViewPropertyAnimator this$0;

             {
                this$0 = ViewPropertyAnimator.this;
                super();
            }
        });
        mAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            public void onAnimationUpdate(ValueAnimator valueanimator) {
                setValue(mFromValue + valueanimator.getAnimatedFraction() * (mToValue - mFromValue));
            }

            final ViewPropertyAnimator this$0;

             {
                this$0 = ViewPropertyAnimator.this;
                super();
            }
        });
    }

    private float calulateAnimatorValue(float f) {
        if(f != 0.003F) goto _L2; else goto _L1
_L1:
        if(mProperty == 128 || mProperty == 1) {
            int ai3[] = new int[2];
            mView.getLocationOnScreen(ai3);
            f = DISPLAY_METRICES_WIDTH - ai3[0];
            if(mProperty == 128)
                f += mView.getLeft();
        }
_L4:
        return f;
_L2:
        if(f == 0.004F) {
            if(mProperty == 128 || mProperty == 1) {
                int ai2[] = new int[2];
                mView.getLocationOnScreen(ai2);
                f = -(getWidthOrMeasureWidth(mView) + (float)ai2[0]);
                if(mProperty == 128)
                    f += mView.getLeft();
            }
        } else
        if(f == 0.001F) {
            if(mProperty == 256 || mProperty == 2) {
                int ai1[] = new int[2];
                mView.getLocationOnScreen(ai1);
                f = -(getHeightOrMeasureHeight(mView) + (float)ai1[1]);
                if(mProperty == 256)
                    f += mView.getTop();
            }
        } else
        if(f == 0.002F) {
            if(mProperty == 256 || mProperty == 2) {
                int ai[] = new int[2];
                mView.getLocationOnScreen(ai);
                f = DISPLAY_METRICES_HEIGHT - ai[1];
                if(mProperty == 256)
                    f += mView.getTop();
            }
        } else
        if(f == 0.008F)
            f = getHeightOrMeasureHeight(mView);
        else
        if(f == 0.005F)
            f = getWidthOrMeasureWidth(mView);
        else
        if(f == 0.009F)
            f = -getHeightOrMeasureHeight(mView);
        else
        if(f == 0.006F)
            f = -getWidthOrMeasureWidth(mView);
        else
        if(f == 0.01F)
            f = getHeightOrMeasureHeight(mView) / 2.0F;
        else
        if(f == 0.007F)
            f = getWidthOrMeasureWidth(mView) / 2.0F;
        else
        if(f == 3.402823E+38F)
            f = getValue();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void cancelAnimator(View view) {
        Animator animator = (Animator)mAnimatorMap.remove(view);
        if(animator != null)
            animator.cancel();
    }

    public static Animator getAnimator(View view) {
        return (Animator)mAnimatorMap.get(view);
    }

    public static float getHeightOrMeasureHeight(View view) {
        int i = view.getHeight();
        if(i == 0) {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            i = view.getMeasuredHeight();
        }
        return (float)i;
    }

    private float getValue() {
        float f = 1.401298E-45F;
        mProperty;
        JVM INSTR lookupswitch 10: default 96
    //                   1: 98
    //                   2: 109
    //                   4: 153
    //                   8: 164
    //                   16: 120
    //                   32: 131
    //                   64: 142
    //                   128: 175
    //                   256: 186
    //                   512: 197;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        return f;
_L2:
        f = mView.getTranslationX();
        continue; /* Loop/switch isn't completed */
_L3:
        f = mView.getTranslationY();
        continue; /* Loop/switch isn't completed */
_L6:
        f = mView.getRotation();
        continue; /* Loop/switch isn't completed */
_L7:
        f = mView.getRotationX();
        continue; /* Loop/switch isn't completed */
_L8:
        f = mView.getRotationY();
        continue; /* Loop/switch isn't completed */
_L4:
        f = mView.getScaleX();
        continue; /* Loop/switch isn't completed */
_L5:
        f = mView.getScaleY();
        continue; /* Loop/switch isn't completed */
_L9:
        f = mView.getX();
        continue; /* Loop/switch isn't completed */
_L10:
        f = mView.getY();
        continue; /* Loop/switch isn't completed */
_L11:
        f = mView.getAlpha();
        if(true) goto _L1; else goto _L12
_L12:
    }

    public static Builder of(View view, int i, float f, float f1) {
        return new Builder(new ViewPropertyAnimator(view, i, f, f1));
    }

    private static void setAnimator(View view, Animator animator) {
        if(animator != null)
            mAnimatorMap.put(view, animator);
        else
            mAnimatorMap.remove(view);
    }

    private void setFinalValues() {
        if(mFinalVisibility != -1)
            mView.setVisibility(mFinalVisibility);
        if(mFinalValue != 1.401298E-45F)
            setValue(mFinalValue);
    }

    private void setValue(float f) {
        mProperty;
        JVM INSTR lookupswitch 10: default 96
    //                   1: 97
    //                   2: 108
    //                   4: 152
    //                   8: 163
    //                   16: 119
    //                   32: 130
    //                   64: 141
    //                   128: 174
    //                   256: 185
    //                   512: 196;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        return;
_L2:
        mView.setTranslationX(f);
        continue; /* Loop/switch isn't completed */
_L3:
        mView.setTranslationY(f);
        continue; /* Loop/switch isn't completed */
_L6:
        mView.setRotation(f);
        continue; /* Loop/switch isn't completed */
_L7:
        mView.setRotationX(f);
        continue; /* Loop/switch isn't completed */
_L8:
        mView.setRotationY(f);
        continue; /* Loop/switch isn't completed */
_L4:
        mView.setScaleX(f);
        continue; /* Loop/switch isn't completed */
_L5:
        mView.setScaleY(f);
        continue; /* Loop/switch isn't completed */
_L9:
        mView.setX(f);
        continue; /* Loop/switch isn't completed */
_L10:
        mView.setY(f);
        continue; /* Loop/switch isn't completed */
_L11:
        mView.setAlpha(f);
        if(true) goto _L1; else goto _L12
_L12:
    }

    private void setupValues() {
        mFromValue = calulateAnimatorValue(mFromValue);
        mToValue = calulateAnimatorValue(mToValue);
        mFinalValue = calulateAnimatorValue(mFinalValue);
    }

    public void cancel() {
        mAnimator.cancel();
    }

    public Animator clone() {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)super.clone();
        viewpropertyanimator.mAnimator = mAnimator.clone();
        viewpropertyanimator.mView = mView;
        viewpropertyanimator.mProperty = mProperty;
        viewpropertyanimator.mFromValue = mFromValue;
        viewpropertyanimator.mToValue = mToValue;
        viewpropertyanimator.mFinalVisibility = mFinalVisibility;
        viewpropertyanimator.mFinalValue = mFinalValue;
        return viewpropertyanimator;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void end() {
        mAnimator.end();
    }

    public long getDuration() {
        return mAnimator.getDuration();
    }

    public float getFinalValue() {
        return mFinalValue;
    }

    public int getFinalVisibility() {
        return mFinalVisibility;
    }

    public int getRepeatCount() {
        return mAnimator.getRepeatCount();
    }

    public int getRepeatMode() {
        return mAnimator.getRepeatMode();
    }

    public long getStartDelay() {
        return mAnimator.getStartDelay();
    }

    public float getWidthOrMeasureWidth(View view) {
        int i = view.getWidth();
        if(i == 0) {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            i = view.getMeasuredWidth();
        }
        return (float)i;
    }

    public boolean isRunning() {
        return mAnimator.isRunning();
    }

    public Animator setDuration(long l) {
        mAnimator.setDuration(l);
        return this;
    }

    public void setFinalValue(float f) {
        mFinalValue = f;
    }

    public void setFinalVisibility(int i) {
        mFinalVisibility = i;
    }

    public void setInterpolator(TimeInterpolator timeinterpolator) {
        mAnimator.setInterpolator(timeinterpolator);
    }

    public void setRepeatCount(int i) {
        mAnimator.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        mAnimator.setRepeatMode(i);
    }

    public void setStartDelay(long l) {
        mAnimator.setStartDelay(l);
    }

    public void start() {
        cancelAnimator(mView);
        Animation animation = mView.getAnimation();
        if(animation != null)
            animation.cancel();
        mView.animate().cancel();
        setAnimator(mView, this);
        setupValues();
        if(mView.getVisibility() != 0)
            mView.setVisibility(0);
        mAnimator.start();
    }

    public static final int ALPHA = 512;
    public static final float CURRENT_HALF_HEIGHT = 0.01F;
    public static final float CURRENT_HALF_WIDTH = 0.007F;
    public static final float CURRENT_HEIGHT = 0.008F;
    public static final float CURRENT_HEIGHT_NEGATIVE = 0.009F;
    public static final float CURRENT_VALUE = 3.402823E+38F;
    public static final float CURRENT_WIDTH = 0.005F;
    public static final float CURRENT_WIDTH_NEGATIVE = 0.006F;
    private static final int DISPLAY_METRICES_HEIGHT = 0;
    private static final int DISPLAY_METRICES_WIDTH = 0;
    public static final float NO_FINAL_VALUE = 1.401298E-45F;
    public static final int NO_FINAL_VISIBILITY = -1;
    public static final float OUT_BOTTOM_SCREEN = 0.002F;
    public static final float OUT_LEFT_SCREEN = 0.003F;
    public static final float OUT_RIGHT_SCREEN = 0.004F;
    public static final float OUT_TOP_SCREEN = 0.001F;
    public static final int ROTATION = 16;
    public static final int ROTATION_X = 32;
    public static final int ROTATION_Y = 64;
    public static final int SCALE_X = 4;
    public static final int SCALE_Y = 8;
    public static final int TRANSLATION_X = 1;
    public static final int TRANSLATION_Y = 2;
    public static final int X = 128;
    public static final int Y = 256;
    private static final HashMap mAnimatorMap = new HashMap();
    private ValueAnimator mAnimator;
    private float mFinalValue;
    private int mFinalVisibility;
    private float mFromValue;
    private int mProperty;
    private float mToValue;
    private View mView;

    static  {
        DISPLAY_METRICES_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
        DISPLAY_METRICES_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;
    }






}
