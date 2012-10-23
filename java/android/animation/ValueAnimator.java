// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import android.view.animation.*;
import java.util.*;

// Referenced classes of package android.animation:
//            Animator, TimeInterpolator, PropertyValuesHolder, TypeEvaluator

public class ValueAnimator extends Animator {
    public static interface AnimatorUpdateListener {

        public abstract void onAnimationUpdate(ValueAnimator valueanimator);
    }

    private static class AnimationHandler
        implements Runnable {

        private void doAnimationFrame(long l) {
            while(mPendingAnimations.size() > 0)  {
                ArrayList arraylist = (ArrayList)mPendingAnimations.clone();
                mPendingAnimations.clear();
                int i2 = arraylist.size();
                int j2 = 0;
                while(j2 < i2)  {
                    ValueAnimator valueanimator3 = (ValueAnimator)arraylist.get(j2);
                    if(valueanimator3.mStartDelay == 0L)
                        valueanimator3.startAnimation(this);
                    else
                        mDelayedAnims.add(valueanimator3);
                    j2++;
                }
            }
            int i = mDelayedAnims.size();
            for(int j = 0; j < i; j++) {
                ValueAnimator valueanimator2 = (ValueAnimator)mDelayedAnims.get(j);
                if(valueanimator2.delayedAnimationFrame(l))
                    mReadyAnims.add(valueanimator2);
            }

            int k = mReadyAnims.size();
            if(k > 0) {
                for(int l1 = 0; l1 < k; l1++) {
                    ValueAnimator valueanimator1 = (ValueAnimator)mReadyAnims.get(l1);
                    valueanimator1.startAnimation(this);
                    valueanimator1.mRunning = true;
                    mDelayedAnims.remove(valueanimator1);
                }

                mReadyAnims.clear();
            }
            int i1 = mAnimations.size();
            for(int j1 = 0; j1 < i1;) {
                ValueAnimator valueanimator = (ValueAnimator)mAnimations.get(j1);
                if(valueanimator.doAnimationFrame(l))
                    mEndingAnims.add(valueanimator);
                if(mAnimations.size() == i1) {
                    j1++;
                } else {
                    i1--;
                    mEndingAnims.remove(valueanimator);
                }
            }

            if(mEndingAnims.size() > 0) {
                for(int k1 = 0; k1 < mEndingAnims.size(); k1++)
                    ((ValueAnimator)mEndingAnims.get(k1)).endAnimation(this);

                mEndingAnims.clear();
            }
            if(!mAnimations.isEmpty() || !mDelayedAnims.isEmpty())
                scheduleAnimation();
        }

        private void scheduleAnimation() {
            if(!mAnimationScheduled) {
                mChoreographer.postCallback(1, this, null);
                mAnimationScheduled = true;
            }
        }

        public void run() {
            mAnimationScheduled = false;
            doAnimationFrame(mChoreographer.getFrameTime());
        }

        public void start() {
            scheduleAnimation();
        }

        private boolean mAnimationScheduled;
        private final ArrayList mAnimations;
        private final Choreographer mChoreographer;
        private final ArrayList mDelayedAnims;
        private final ArrayList mEndingAnims;
        private final ArrayList mPendingAnimations;
        private final ArrayList mReadyAnims;




        private AnimationHandler() {
            mAnimations = new ArrayList();
            mPendingAnimations = new ArrayList();
            mDelayedAnims = new ArrayList();
            mEndingAnims = new ArrayList();
            mReadyAnims = new ArrayList();
            mChoreographer = Choreographer.getInstance();
        }

    }


    public ValueAnimator() {
        mSeekTime = -1L;
        mPlayingBackwards = false;
        mCurrentIteration = 0;
        mCurrentFraction = 0.0F;
        mStartedDelay = false;
        mPlayingState = 0;
        mRunning = false;
        mStarted = false;
        mStartListenersCalled = false;
        mInitialized = false;
        mDuration = (long)(300F * sDurationScale);
        mUnscaledDuration = 300L;
        mStartDelay = 0L;
        mUnscaledStartDelay = 0L;
        mRepeatCount = 0;
        mRepeatMode = 1;
        mInterpolator = sDefaultInterpolator;
        mUpdateListeners = null;
    }

    public static void clearAllAnimations() {
        AnimationHandler animationhandler = (AnimationHandler)sAnimationHandler.get();
        if(animationhandler != null) {
            animationhandler.mAnimations.clear();
            animationhandler.mPendingAnimations.clear();
            animationhandler.mDelayedAnims.clear();
        }
    }

    private boolean delayedAnimationFrame(long l) {
        boolean flag = true;
        if(mStartedDelay) goto _L2; else goto _L1
_L1:
        mStartedDelay = flag;
        mDelayStartTime = l;
_L6:
        flag = false;
_L4:
        return flag;
_L2:
        long l1 = l - mDelayStartTime;
        if(l1 <= mStartDelay)
            continue; /* Loop/switch isn't completed */
        mStartTime = l - (l1 - mStartDelay);
        mPlayingState = ((flag) ? 1 : 0);
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void endAnimation(AnimationHandler animationhandler) {
        animationhandler.mAnimations.remove(this);
        animationhandler.mPendingAnimations.remove(this);
        animationhandler.mDelayedAnims.remove(this);
        mPlayingState = 0;
        if((mStarted || mRunning) && super.mListeners != null) {
            if(!mRunning)
                notifyStartListeners();
            ArrayList arraylist = (ArrayList)super.mListeners.clone();
            int i = arraylist.size();
            for(int j = 0; j < i; j++)
                ((Animator.AnimatorListener)arraylist.get(j)).onAnimationEnd(this);

        }
        mRunning = false;
        mStarted = false;
        mStartListenersCalled = false;
    }

    public static int getCurrentAnimationsCount() {
        AnimationHandler animationhandler = (AnimationHandler)sAnimationHandler.get();
        int i;
        if(animationhandler != null)
            i = animationhandler.mAnimations.size();
        else
            i = 0;
        return i;
    }

    public static long getFrameDelay() {
        return Choreographer.getFrameDelay();
    }

    private AnimationHandler getOrCreateAnimationHandler() {
        AnimationHandler animationhandler = (AnimationHandler)sAnimationHandler.get();
        if(animationhandler == null) {
            animationhandler = new AnimationHandler();
            sAnimationHandler.set(animationhandler);
        }
        return animationhandler;
    }

    private void notifyStartListeners() {
        if(super.mListeners != null && !mStartListenersCalled) {
            ArrayList arraylist = (ArrayList)super.mListeners.clone();
            int i = arraylist.size();
            for(int j = 0; j < i; j++)
                ((Animator.AnimatorListener)arraylist.get(j)).onAnimationStart(this);

        }
        mStartListenersCalled = true;
    }

    public static transient ValueAnimator ofFloat(float af[]) {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setFloatValues(af);
        return valueanimator;
    }

    public static transient ValueAnimator ofInt(int ai[]) {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setIntValues(ai);
        return valueanimator;
    }

    public static transient ValueAnimator ofObject(TypeEvaluator typeevaluator, Object aobj[]) {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setObjectValues(aobj);
        valueanimator.setEvaluator(typeevaluator);
        return valueanimator;
    }

    public static transient ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder apropertyvaluesholder[]) {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setValues(apropertyvaluesholder);
        return valueanimator;
    }

    public static void setDurationScale(float f) {
        sDurationScale = f;
    }

    public static void setFrameDelay(long l) {
        Choreographer.setFrameDelay(l);
    }

    private void start(boolean flag) {
        if(Looper.myLooper() == null)
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        mPlayingBackwards = flag;
        mCurrentIteration = 0;
        mPlayingState = 0;
        mStarted = true;
        mStartedDelay = false;
        AnimationHandler animationhandler = getOrCreateAnimationHandler();
        animationhandler.mPendingAnimations.add(this);
        if(mStartDelay == 0L) {
            setCurrentPlayTime(0L);
            mPlayingState = 0;
            mRunning = true;
            notifyStartListeners();
        }
        animationhandler.start();
    }

    private void startAnimation(AnimationHandler animationhandler) {
        initAnimation();
        animationhandler.mAnimations.add(this);
        if(mStartDelay > 0L && super.mListeners != null)
            notifyStartListeners();
    }

    public void addUpdateListener(AnimatorUpdateListener animatorupdatelistener) {
        if(mUpdateListeners == null)
            mUpdateListeners = new ArrayList();
        mUpdateListeners.add(animatorupdatelistener);
    }

    void animateValue(float f) {
        float f1 = mInterpolator.getInterpolation(f);
        mCurrentFraction = f1;
        int i = mValues.length;
        for(int j = 0; j < i; j++)
            mValues[j].calculateValue(f1);

        if(mUpdateListeners != null) {
            int k = mUpdateListeners.size();
            for(int l = 0; l < k; l++)
                ((AnimatorUpdateListener)mUpdateListeners.get(l)).onAnimationUpdate(this);

        }
    }

    boolean animationFrame(long l) {
        boolean flag = false;
        mPlayingState;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 30
    //                   2 30;
           goto _L1 _L2 _L2
_L1:
        return flag;
_L2:
        float f;
        if(mDuration > 0L)
            f = (float)(l - mStartTime) / (float)mDuration;
        else
            f = 1.0F;
        if(f >= 1.0F)
            if(mCurrentIteration < mRepeatCount || mRepeatCount == -1) {
                if(super.mListeners != null) {
                    int i = super.mListeners.size();
                    for(int j = 0; j < i; j++)
                        ((Animator.AnimatorListener)super.mListeners.get(j)).onAnimationRepeat(this);

                }
                if(mRepeatMode == 2) {
                    boolean flag1;
                    if(mPlayingBackwards)
                        flag1 = false;
                    else
                        flag1 = true;
                    mPlayingBackwards = flag1;
                }
                mCurrentIteration = mCurrentIteration + (int)f;
                f %= 1.0F;
                mStartTime = mStartTime + mDuration;
            } else {
                flag = true;
                f = Math.min(f, 1.0F);
            }
        if(mPlayingBackwards)
            f = 1.0F - f;
        animateValue(f);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void cancel() {
        AnimationHandler animationhandler = getOrCreateAnimationHandler();
        if(mPlayingState != 0 || animationhandler.mPendingAnimations.contains(this) || animationhandler.mDelayedAnims.contains(this)) {
            if((mStarted || mRunning) && super.mListeners != null) {
                if(!mRunning)
                    notifyStartListeners();
                for(Iterator iterator = ((ArrayList)super.mListeners.clone()).iterator(); iterator.hasNext(); ((Animator.AnimatorListener)iterator.next()).onAnimationCancel(this));
            }
            endAnimation(animationhandler);
        }
    }

    public volatile Animator clone() {
        return clone();
    }

    public ValueAnimator clone() {
        ValueAnimator valueanimator = (ValueAnimator)super.clone();
        if(mUpdateListeners != null) {
            ArrayList arraylist = mUpdateListeners;
            valueanimator.mUpdateListeners = new ArrayList();
            int k = arraylist.size();
            for(int l = 0; l < k; l++)
                valueanimator.mUpdateListeners.add(arraylist.get(l));

        }
        valueanimator.mSeekTime = -1L;
        valueanimator.mPlayingBackwards = false;
        valueanimator.mCurrentIteration = 0;
        valueanimator.mInitialized = false;
        valueanimator.mPlayingState = 0;
        valueanimator.mStartedDelay = false;
        PropertyValuesHolder apropertyvaluesholder[] = mValues;
        if(apropertyvaluesholder != null) {
            int i = apropertyvaluesholder.length;
            valueanimator.mValues = new PropertyValuesHolder[i];
            valueanimator.mValuesMap = new HashMap(i);
            for(int j = 0; j < i; j++) {
                PropertyValuesHolder propertyvaluesholder = apropertyvaluesholder[j].clone();
                valueanimator.mValues[j] = propertyvaluesholder;
                valueanimator.mValuesMap.put(propertyvaluesholder.getPropertyName(), propertyvaluesholder);
            }

        }
        return valueanimator;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    final boolean doAnimationFrame(long l) {
        if(mPlayingState == 0) {
            mPlayingState = 1;
            if(mSeekTime < 0L) {
                mStartTime = l;
            } else {
                mStartTime = l - mSeekTime;
                mSeekTime = -1L;
            }
        }
        return animationFrame(Math.max(l, mStartTime));
    }

    public void end() {
        AnimationHandler animationhandler = getOrCreateAnimationHandler();
        if(!animationhandler.mAnimations.contains(this) && !animationhandler.mPendingAnimations.contains(this)) {
            mStartedDelay = false;
            startAnimation(animationhandler);
            mStarted = true;
        } else
        if(!mInitialized)
            initAnimation();
        if(mRepeatCount > 0 && (1 & mRepeatCount) == 1)
            animateValue(0.0F);
        else
            animateValue(1.0F);
        endAnimation(animationhandler);
    }

    public float getAnimatedFraction() {
        return mCurrentFraction;
    }

    public Object getAnimatedValue() {
        Object obj;
        if(mValues != null && mValues.length > 0)
            obj = mValues[0].getAnimatedValue();
        else
            obj = null;
        return obj;
    }

    public Object getAnimatedValue(String s) {
        PropertyValuesHolder propertyvaluesholder = (PropertyValuesHolder)mValuesMap.get(s);
        Object obj;
        if(propertyvaluesholder != null)
            obj = propertyvaluesholder.getAnimatedValue();
        else
            obj = null;
        return obj;
    }

    public long getCurrentPlayTime() {
        long l;
        if(!mInitialized || mPlayingState == 0)
            l = 0L;
        else
            l = AnimationUtils.currentAnimationTimeMillis() - mStartTime;
        return l;
    }

    public long getDuration() {
        return mUnscaledDuration;
    }

    public TimeInterpolator getInterpolator() {
        return mInterpolator;
    }

    public int getRepeatCount() {
        return mRepeatCount;
    }

    public int getRepeatMode() {
        return mRepeatMode;
    }

    public long getStartDelay() {
        return mUnscaledStartDelay;
    }

    public PropertyValuesHolder[] getValues() {
        return mValues;
    }

    void initAnimation() {
        if(!mInitialized) {
            int i = mValues.length;
            for(int j = 0; j < i; j++)
                mValues[j].init();

            mInitialized = true;
        }
    }

    public boolean isRunning() {
        boolean flag = true;
        if(mPlayingState != flag && !mRunning)
            flag = false;
        return flag;
    }

    public boolean isStarted() {
        return mStarted;
    }

    public void removeAllUpdateListeners() {
        if(mUpdateListeners != null) {
            mUpdateListeners.clear();
            mUpdateListeners = null;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorupdatelistener) {
        if(mUpdateListeners != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mUpdateListeners.remove(animatorupdatelistener);
        if(mUpdateListeners.size() == 0)
            mUpdateListeners = null;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void reverse() {
        boolean flag;
        if(!mPlayingBackwards)
            flag = true;
        else
            flag = false;
        mPlayingBackwards = flag;
        if(mPlayingState == 1) {
            long l = AnimationUtils.currentAnimationTimeMillis();
            long l1 = l - mStartTime;
            mStartTime = l - (mDuration - l1);
        } else {
            start(true);
        }
    }

    public void setCurrentPlayTime(long l) {
        initAnimation();
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        if(mPlayingState != 1) {
            mSeekTime = l;
            mPlayingState = 2;
        }
        mStartTime = l1 - l;
        doAnimationFrame(l1);
    }

    public volatile Animator setDuration(long l) {
        return setDuration(l);
    }

    public ValueAnimator setDuration(long l) {
        if(l < 0L) {
            throw new IllegalArgumentException((new StringBuilder()).append("Animators cannot have negative duration: ").append(l).toString());
        } else {
            mUnscaledDuration = l;
            mDuration = (long)((float)l * sDurationScale);
            return this;
        }
    }

    public void setEvaluator(TypeEvaluator typeevaluator) {
        if(typeevaluator != null && mValues != null && mValues.length > 0)
            mValues[0].setEvaluator(typeevaluator);
    }

    public transient void setFloatValues(float af[]) {
        if(af != null && af.length != 0) {
            if(mValues == null || mValues.length == 0) {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofFloat("", af);
                setValues(apropertyvaluesholder);
            } else {
                mValues[0].setFloatValues(af);
            }
            mInitialized = false;
        }
    }

    public transient void setIntValues(int ai[]) {
        if(ai != null && ai.length != 0) {
            if(mValues == null || mValues.length == 0) {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofInt("", ai);
                setValues(apropertyvaluesholder);
            } else {
                mValues[0].setIntValues(ai);
            }
            mInitialized = false;
        }
    }

    public void setInterpolator(TimeInterpolator timeinterpolator) {
        if(timeinterpolator != null)
            mInterpolator = timeinterpolator;
        else
            mInterpolator = new LinearInterpolator();
    }

    public transient void setObjectValues(Object aobj[]) {
        if(aobj != null && aobj.length != 0) {
            if(mValues == null || mValues.length == 0) {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofObject("", (TypeEvaluator)null, aobj);
                setValues(apropertyvaluesholder);
            } else {
                mValues[0].setObjectValues(aobj);
            }
            mInitialized = false;
        }
    }

    public void setRepeatCount(int i) {
        mRepeatCount = i;
    }

    public void setRepeatMode(int i) {
        mRepeatMode = i;
    }

    public void setStartDelay(long l) {
        mStartDelay = (long)((float)l * sDurationScale);
        mUnscaledStartDelay = l;
    }

    public transient void setValues(PropertyValuesHolder apropertyvaluesholder[]) {
        int i = apropertyvaluesholder.length;
        mValues = apropertyvaluesholder;
        mValuesMap = new HashMap(i);
        for(int j = 0; j < i; j++) {
            PropertyValuesHolder propertyvaluesholder = apropertyvaluesholder[j];
            mValuesMap.put(propertyvaluesholder.getPropertyName(), propertyvaluesholder);
        }

        mInitialized = false;
    }

    public void start() {
        start(false);
    }

    public String toString() {
        String s = (new StringBuilder()).append("ValueAnimator@").append(Integer.toHexString(hashCode())).toString();
        if(mValues != null) {
            for(int i = 0; i < mValues.length; i++)
                s = (new StringBuilder()).append(s).append("\n    ").append(mValues[i].toString()).toString();

        }
        return s;
    }

    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED;
    private static ThreadLocal sAnimationHandler = new ThreadLocal();
    private static final TimeInterpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    private static float sDurationScale = 1.0F;
    private float mCurrentFraction;
    private int mCurrentIteration;
    private long mDelayStartTime;
    private long mDuration;
    boolean mInitialized;
    private TimeInterpolator mInterpolator;
    private boolean mPlayingBackwards;
    int mPlayingState;
    private int mRepeatCount;
    private int mRepeatMode;
    private boolean mRunning;
    long mSeekTime;
    private long mStartDelay;
    private boolean mStartListenersCalled;
    long mStartTime;
    private boolean mStarted;
    private boolean mStartedDelay;
    private long mUnscaledDuration;
    private long mUnscaledStartDelay;
    private ArrayList mUpdateListeners;
    PropertyValuesHolder mValues[];
    HashMap mValuesMap;






/*
    static boolean access$302(ValueAnimator valueanimator, boolean flag) {
        valueanimator.mRunning = flag;
        return flag;
    }

*/

}
