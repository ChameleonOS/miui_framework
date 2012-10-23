// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;

import java.util.ArrayList;

// Referenced classes of package android.animation:
//            TimeInterpolator

public abstract class Animator
    implements Cloneable {
    public static interface AnimatorListener {

        public abstract void onAnimationCancel(Animator animator);

        public abstract void onAnimationEnd(Animator animator);

        public abstract void onAnimationRepeat(Animator animator);

        public abstract void onAnimationStart(Animator animator);
    }


    public Animator() {
        mListeners = null;
    }

    public void addListener(AnimatorListener animatorlistener) {
        if(mListeners == null)
            mListeners = new ArrayList();
        mListeners.add(animatorlistener);
    }

    public void cancel() {
    }

    public Animator clone() {
        Animator animator;
        ArrayList arraylist;
        int i;
        int j;
        animator = (Animator)super.clone();
        if(mListeners == null)
            break MISSING_BLOCK_LABEL_76;
        arraylist = mListeners;
        animator.mListeners = new ArrayList();
        i = arraylist.size();
        j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_76;
        animator.mListeners.add(arraylist.get(j));
        j++;
          goto _L1
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        throw new AssertionError();
        return animator;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void end() {
    }

    public abstract long getDuration();

    public ArrayList getListeners() {
        return mListeners;
    }

    public abstract long getStartDelay();

    public abstract boolean isRunning();

    public boolean isStarted() {
        return isRunning();
    }

    public void removeAllListeners() {
        if(mListeners != null) {
            mListeners.clear();
            mListeners = null;
        }
    }

    public void removeListener(AnimatorListener animatorlistener) {
        if(mListeners != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mListeners.remove(animatorlistener);
        if(mListeners.size() == 0)
            mListeners = null;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public abstract Animator setDuration(long l);

    public abstract void setInterpolator(TimeInterpolator timeinterpolator);

    public abstract void setStartDelay(long l);

    public void setTarget(Object obj) {
    }

    public void setupEndValues() {
    }

    public void setupStartValues() {
    }

    public void start() {
    }

    ArrayList mListeners;
}
