// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.animation.*;
import java.util.*;

// Referenced classes of package android.view:
//            View, DisplayList

public class ViewPropertyAnimator {
    private class AnimatorEventListener
        implements android.animation.Animator.AnimatorListener, android.animation.ValueAnimator.AnimatorUpdateListener {

        public void onAnimationCancel(Animator animator) {
            if(mListener != null)
                mListener.onAnimationCancel(animator);
            if(mAnimatorOnEndMap != null)
                mAnimatorOnEndMap.remove(animator);
        }

        public void onAnimationEnd(Animator animator) {
            mView.setHasTransientState(false);
            if(mListener != null)
                mListener.onAnimationEnd(animator);
            if(mAnimatorOnEndMap != null) {
                Runnable runnable1 = (Runnable)mAnimatorOnEndMap.get(animator);
                if(runnable1 != null)
                    runnable1.run();
                mAnimatorOnEndMap.remove(animator);
            }
            if(mAnimatorCleanupMap != null) {
                Runnable runnable = (Runnable)mAnimatorCleanupMap.get(animator);
                if(runnable != null)
                    runnable.run();
                mAnimatorCleanupMap.remove(animator);
            }
            mAnimatorMap.remove(animator);
        }

        public void onAnimationRepeat(Animator animator) {
            if(mListener != null)
                mListener.onAnimationRepeat(animator);
        }

        public void onAnimationStart(Animator animator) {
            if(mAnimatorSetupMap != null) {
                Runnable runnable1 = (Runnable)mAnimatorSetupMap.get(animator);
                if(runnable1 != null)
                    runnable1.run();
                mAnimatorSetupMap.remove(animator);
            }
            if(mAnimatorOnStartMap != null) {
                Runnable runnable = (Runnable)mAnimatorOnStartMap.get(animator);
                if(runnable != null)
                    runnable.run();
                mAnimatorOnStartMap.remove(animator);
            }
            if(mListener != null)
                mListener.onAnimationStart(animator);
        }

        public void onAnimationUpdate(ValueAnimator valueanimator) {
            PropertyBundle propertybundle = (PropertyBundle)mAnimatorMap.get(valueanimator);
            if(propertybundle != null) {
                boolean flag;
                boolean flag1;
                float f;
                int i;
                ArrayList arraylist;
                if(mView.mDisplayList != null)
                    flag = true;
                else
                    flag = false;
                flag1 = false;
                if(!flag)
                    mView.invalidateParentCaches();
                f = valueanimator.getAnimatedFraction();
                i = propertybundle.mPropertyMask;
                if((i & 0x1ff) != 0)
                    mView.invalidateViewProperty(false, false);
                arraylist = propertybundle.mNameValuesHolder;
                if(arraylist != null) {
                    int j = arraylist.size();
                    int k = 0;
                    while(k < j)  {
                        NameValuesHolder namevaluesholder = (NameValuesHolder)arraylist.get(k);
                        float f1 = namevaluesholder.mFromValue + f * namevaluesholder.mDeltaValue;
                        if(namevaluesholder.mNameConstant == 512)
                            flag1 = mView.setAlphaNoInvalidation(f1);
                        else
                            setValue(namevaluesholder.mNameConstant, f1);
                        k++;
                    }
                }
                if((i & 0x1ff) != 0) {
                    mView.mTransformationInfo.mMatrixDirty = true;
                    if(!flag) {
                        View view = mView;
                        view.mPrivateFlags = 0x20 | view.mPrivateFlags;
                    }
                }
                if(flag1)
                    mView.invalidate(true);
                else
                    mView.invalidateViewProperty(false, false);
            }
        }

        final ViewPropertyAnimator this$0;

        private AnimatorEventListener() {
            this$0 = ViewPropertyAnimator.this;
            super();
        }

    }

    private static class NameValuesHolder {

        float mDeltaValue;
        float mFromValue;
        int mNameConstant;

        NameValuesHolder(int i, float f, float f1) {
            mNameConstant = i;
            mFromValue = f;
            mDeltaValue = f1;
        }
    }

    private static class PropertyBundle {

        boolean cancel(int i) {
            int j;
            int k;
            if((i & mPropertyMask) == 0 || mNameValuesHolder == null)
                break MISSING_BLOCK_LABEL_85;
            j = mNameValuesHolder.size();
            k = 0;
_L3:
            if(k >= j)
                break MISSING_BLOCK_LABEL_85;
            if(((NameValuesHolder)mNameValuesHolder.get(k)).mNameConstant != i) goto _L2; else goto _L1
_L1:
            boolean flag;
            mNameValuesHolder.remove(k);
            mPropertyMask = mPropertyMask & ~i;
            flag = true;
_L4:
            return flag;
_L2:
            k++;
              goto _L3
            flag = false;
              goto _L4
        }

        ArrayList mNameValuesHolder;
        int mPropertyMask;

        PropertyBundle(int i, ArrayList arraylist) {
            mPropertyMask = i;
            mNameValuesHolder = arraylist;
        }
    }


    ViewPropertyAnimator(View view) {
        mDurationSet = false;
        mStartDelay = 0L;
        mStartDelaySet = false;
        mInterpolatorSet = false;
        mListener = null;
        mAnimatorEventListener = new AnimatorEventListener();
        mPendingAnimations = new ArrayList();
        mAnimationStarter = new Runnable() {

            public void run() {
                startAnimation();
            }

            final ViewPropertyAnimator this$0;

             {
                this$0 = ViewPropertyAnimator.this;
                super();
            }
        };
        mAnimatorMap = new HashMap();
        mView = view;
        view.ensureTransformationInfo();
    }

    private void animateProperty(int i, float f) {
        float f1 = getValue(i);
        animatePropertyBy(i, f1, f - f1);
    }

    private void animatePropertyBy(int i, float f) {
        animatePropertyBy(i, getValue(i), f);
    }

    private void animatePropertyBy(int i, float f, float f1) {
        if(mAnimatorMap.size() > 0) {
            Animator animator = null;
            Iterator iterator = mAnimatorMap.keySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                Animator animator1 = (Animator)iterator.next();
                PropertyBundle propertybundle = (PropertyBundle)mAnimatorMap.get(animator1);
                if(!propertybundle.cancel(i) || propertybundle.mPropertyMask != 0)
                    continue;
                animator = animator1;
                break;
            } while(true);
            if(animator != null)
                animator.cancel();
        }
        NameValuesHolder namevaluesholder = new NameValuesHolder(i, f, f1);
        mPendingAnimations.add(namevaluesholder);
        mView.removeCallbacks(mAnimationStarter);
        mView.post(mAnimationStarter);
    }

    private float getValue(int i) {
        View.TransformationInfo transformationinfo = mView.mTransformationInfo;
        i;
        JVM INSTR lookupswitch 10: default 100
    //                   1: 104
    //                   2: 112
    //                   4: 144
    //                   8: 152
    //                   16: 120
    //                   32: 128
    //                   64: 136
    //                   128: 160
    //                   256: 177
    //                   512: 194;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        float f = 0.0F;
_L13:
        return f;
_L2:
        f = transformationinfo.mTranslationX;
        continue; /* Loop/switch isn't completed */
_L3:
        f = transformationinfo.mTranslationY;
        continue; /* Loop/switch isn't completed */
_L6:
        f = transformationinfo.mRotation;
        continue; /* Loop/switch isn't completed */
_L7:
        f = transformationinfo.mRotationX;
        continue; /* Loop/switch isn't completed */
_L8:
        f = transformationinfo.mRotationY;
        continue; /* Loop/switch isn't completed */
_L4:
        f = transformationinfo.mScaleX;
        continue; /* Loop/switch isn't completed */
_L5:
        f = transformationinfo.mScaleY;
        continue; /* Loop/switch isn't completed */
_L9:
        f = (float)mView.mLeft + transformationinfo.mTranslationX;
        continue; /* Loop/switch isn't completed */
_L10:
        f = (float)mView.mTop + transformationinfo.mTranslationY;
        continue; /* Loop/switch isn't completed */
_L11:
        f = transformationinfo.mAlpha;
        if(true) goto _L13; else goto _L12
_L12:
    }

    private void setValue(int i, float f) {
        View.TransformationInfo transformationinfo;
        DisplayList displaylist;
        transformationinfo = mView.mTransformationInfo;
        displaylist = mView.mDisplayList;
        i;
        JVM INSTR lookupswitch 10: default 108
    //                   1: 109
    //                   2: 128
    //                   4: 204
    //                   8: 223
    //                   16: 147
    //                   32: 166
    //                   64: 185
    //                   128: 242
    //                   256: 279
    //                   512: 316;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        return;
_L2:
        transformationinfo.mTranslationX = f;
        if(displaylist != null)
            displaylist.setTranslationX(f);
        continue; /* Loop/switch isn't completed */
_L3:
        transformationinfo.mTranslationY = f;
        if(displaylist != null)
            displaylist.setTranslationY(f);
        continue; /* Loop/switch isn't completed */
_L6:
        transformationinfo.mRotation = f;
        if(displaylist != null)
            displaylist.setRotation(f);
        continue; /* Loop/switch isn't completed */
_L7:
        transformationinfo.mRotationX = f;
        if(displaylist != null)
            displaylist.setRotationX(f);
        continue; /* Loop/switch isn't completed */
_L8:
        transformationinfo.mRotationY = f;
        if(displaylist != null)
            displaylist.setRotationY(f);
        continue; /* Loop/switch isn't completed */
_L4:
        transformationinfo.mScaleX = f;
        if(displaylist != null)
            displaylist.setScaleX(f);
        continue; /* Loop/switch isn't completed */
_L5:
        transformationinfo.mScaleY = f;
        if(displaylist != null)
            displaylist.setScaleY(f);
        continue; /* Loop/switch isn't completed */
_L9:
        transformationinfo.mTranslationX = f - (float)mView.mLeft;
        if(displaylist != null)
            displaylist.setTranslationX(f - (float)mView.mLeft);
        continue; /* Loop/switch isn't completed */
_L10:
        transformationinfo.mTranslationY = f - (float)mView.mTop;
        if(displaylist != null)
            displaylist.setTranslationY(f - (float)mView.mTop);
        continue; /* Loop/switch isn't completed */
_L11:
        transformationinfo.mAlpha = f;
        if(displaylist != null)
            displaylist.setAlpha(f);
        if(true) goto _L1; else goto _L12
_L12:
    }

    private void startAnimation() {
        mView.setHasTransientState(true);
        float af[] = new float[1];
        af[0] = 1.0F;
        ValueAnimator valueanimator = ValueAnimator.ofFloat(af);
        ArrayList arraylist = (ArrayList)mPendingAnimations.clone();
        mPendingAnimations.clear();
        int i = 0;
        int j = arraylist.size();
        for(int k = 0; k < j; k++)
            i |= ((NameValuesHolder)arraylist.get(k)).mNameConstant;

        mAnimatorMap.put(valueanimator, new PropertyBundle(i, arraylist));
        if(mPendingSetupAction != null) {
            mAnimatorSetupMap.put(valueanimator, mPendingSetupAction);
            mPendingSetupAction = null;
        }
        if(mPendingCleanupAction != null) {
            mAnimatorCleanupMap.put(valueanimator, mPendingCleanupAction);
            mPendingCleanupAction = null;
        }
        if(mPendingOnStartAction != null) {
            mAnimatorOnStartMap.put(valueanimator, mPendingOnStartAction);
            mPendingOnStartAction = null;
        }
        if(mPendingOnEndAction != null) {
            mAnimatorOnEndMap.put(valueanimator, mPendingOnEndAction);
            mPendingOnEndAction = null;
        }
        valueanimator.addUpdateListener(mAnimatorEventListener);
        valueanimator.addListener(mAnimatorEventListener);
        if(mStartDelaySet)
            valueanimator.setStartDelay(mStartDelay);
        if(mDurationSet)
            valueanimator.setDuration(mDuration);
        if(mInterpolatorSet)
            valueanimator.setInterpolator(mInterpolator);
        valueanimator.start();
    }

    public ViewPropertyAnimator alpha(float f) {
        animateProperty(512, f);
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f) {
        animatePropertyBy(512, f);
        return this;
    }

    public void cancel() {
        if(mAnimatorMap.size() > 0) {
            for(Iterator iterator = ((HashMap)mAnimatorMap.clone()).keySet().iterator(); iterator.hasNext(); ((Animator)iterator.next()).cancel());
        }
        mPendingAnimations.clear();
        mView.removeCallbacks(mAnimationStarter);
    }

    public long getDuration() {
        long l;
        if(mDurationSet)
            l = mDuration;
        else
            l = (new ValueAnimator()).getDuration();
        return l;
    }

    public long getStartDelay() {
        long l;
        if(mStartDelaySet)
            l = mStartDelay;
        else
            l = 0L;
        return l;
    }

    public ViewPropertyAnimator rotation(float f) {
        animateProperty(16, f);
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f) {
        animatePropertyBy(16, f);
        return this;
    }

    public ViewPropertyAnimator rotationX(float f) {
        animateProperty(32, f);
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f) {
        animatePropertyBy(32, f);
        return this;
    }

    public ViewPropertyAnimator rotationY(float f) {
        animateProperty(64, f);
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f) {
        animatePropertyBy(64, f);
        return this;
    }

    public ViewPropertyAnimator scaleX(float f) {
        animateProperty(4, f);
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f) {
        animatePropertyBy(4, f);
        return this;
    }

    public ViewPropertyAnimator scaleY(float f) {
        animateProperty(8, f);
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f) {
        animatePropertyBy(8, f);
        return this;
    }

    public ViewPropertyAnimator setDuration(long l) {
        if(l < 0L) {
            throw new IllegalArgumentException((new StringBuilder()).append("Animators cannot have negative duration: ").append(l).toString());
        } else {
            mDurationSet = true;
            mDuration = l;
            return this;
        }
    }

    public ViewPropertyAnimator setInterpolator(TimeInterpolator timeinterpolator) {
        mInterpolatorSet = true;
        mInterpolator = timeinterpolator;
        return this;
    }

    public ViewPropertyAnimator setListener(android.animation.Animator.AnimatorListener animatorlistener) {
        mListener = animatorlistener;
        return this;
    }

    public ViewPropertyAnimator setStartDelay(long l) {
        if(l < 0L) {
            throw new IllegalArgumentException((new StringBuilder()).append("Animators cannot have negative duration: ").append(l).toString());
        } else {
            mStartDelaySet = true;
            mStartDelay = l;
            return this;
        }
    }

    public void start() {
        mView.removeCallbacks(mAnimationStarter);
        startAnimation();
    }

    public ViewPropertyAnimator translationX(float f) {
        animateProperty(1, f);
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f) {
        animatePropertyBy(1, f);
        return this;
    }

    public ViewPropertyAnimator translationY(float f) {
        animateProperty(2, f);
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f) {
        animatePropertyBy(2, f);
        return this;
    }

    public ViewPropertyAnimator withEndAction(Runnable runnable) {
        mPendingOnEndAction = runnable;
        if(runnable != null && mAnimatorOnEndMap == null)
            mAnimatorOnEndMap = new HashMap();
        return this;
    }

    public ViewPropertyAnimator withLayer() {
        mPendingSetupAction = new Runnable() {

            public void run() {
                mView.setLayerType(2, null);
            }

            final ViewPropertyAnimator this$0;

             {
                this$0 = ViewPropertyAnimator.this;
                super();
            }
        };
        mPendingCleanupAction = new Runnable() {

            public void run() {
                mView.setLayerType(currentLayerType, null);
            }

            final ViewPropertyAnimator this$0;
            final int val$currentLayerType;

             {
                this$0 = ViewPropertyAnimator.this;
                currentLayerType = i;
                super();
            }
        };
        if(mAnimatorSetupMap == null)
            mAnimatorSetupMap = new HashMap();
        if(mAnimatorCleanupMap == null)
            mAnimatorCleanupMap = new HashMap();
        return this;
    }

    public ViewPropertyAnimator withStartAction(Runnable runnable) {
        mPendingOnStartAction = runnable;
        if(runnable != null && mAnimatorOnStartMap == null)
            mAnimatorOnStartMap = new HashMap();
        return this;
    }

    public ViewPropertyAnimator x(float f) {
        animateProperty(128, f);
        return this;
    }

    public ViewPropertyAnimator xBy(float f) {
        animatePropertyBy(128, f);
        return this;
    }

    public ViewPropertyAnimator y(float f) {
        animateProperty(256, f);
        return this;
    }

    public ViewPropertyAnimator yBy(float f) {
        animatePropertyBy(256, f);
        return this;
    }

    private static final int ALPHA = 512;
    private static final int NONE = 0;
    private static final int ROTATION = 16;
    private static final int ROTATION_X = 32;
    private static final int ROTATION_Y = 64;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 8;
    private static final int TRANSFORM_MASK = 511;
    private static final int TRANSLATION_X = 1;
    private static final int TRANSLATION_Y = 2;
    private static final int X = 128;
    private static final int Y = 256;
    private Runnable mAnimationStarter;
    private HashMap mAnimatorCleanupMap;
    private AnimatorEventListener mAnimatorEventListener;
    private HashMap mAnimatorMap;
    private HashMap mAnimatorOnEndMap;
    private HashMap mAnimatorOnStartMap;
    private HashMap mAnimatorSetupMap;
    private long mDuration;
    private boolean mDurationSet;
    private TimeInterpolator mInterpolator;
    private boolean mInterpolatorSet;
    private android.animation.Animator.AnimatorListener mListener;
    ArrayList mPendingAnimations;
    private Runnable mPendingCleanupAction;
    private Runnable mPendingOnEndAction;
    private Runnable mPendingOnStartAction;
    private Runnable mPendingSetupAction;
    private long mStartDelay;
    private boolean mStartDelaySet;
    private final View mView;









}
