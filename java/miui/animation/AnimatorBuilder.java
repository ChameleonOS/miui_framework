// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;

// Referenced classes of package miui.animation:
//            ViewPropertyAnimator

public class AnimatorBuilder {

    public AnimatorBuilder(Animator animator1) {
        mAnimator = animator1;
    }

    public static AnimatorBuilder of(Animator animator1) {
        return new AnimatorBuilder(animator1);
    }

    public static ViewPropertyAnimator.Builder of(ViewPropertyAnimator viewpropertyanimator) {
        return new ViewPropertyAnimator.Builder(viewpropertyanimator);
    }

    public AnimatorBuilder addListener(android.animation.Animator.AnimatorListener animatorlistener) {
        mAnimator.addListener(animatorlistener);
        return this;
    }

    public Animator animator() {
        return mAnimator;
    }

    public AnimatorBuilder setDuration(long l) {
        mAnimator.setDuration(l);
        return this;
    }

    public AnimatorBuilder setInterpolator(TimeInterpolator timeinterpolator) {
        mAnimator.setInterpolator(timeinterpolator);
        return this;
    }

    public AnimatorBuilder setStartDelay(long l) {
        mAnimator.setStartDelay(l);
        return this;
    }

    public Animator start() {
        mAnimator.start();
        return mAnimator;
    }

    protected Animator mAnimator;
}
