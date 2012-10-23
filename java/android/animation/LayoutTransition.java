// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;

import android.view.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.*;

// Referenced classes of package android.animation:
//            PropertyValuesHolder, ObjectAnimator, Animator, ValueAnimator, 
//            TimeInterpolator, AnimatorListenerAdapter, KeyframeSet, Keyframe

public class LayoutTransition {
    public static interface TransitionListener {

        public abstract void endTransition(LayoutTransition layouttransition, ViewGroup viewgroup, View view, int i);

        public abstract void startTransition(LayoutTransition layouttransition, ViewGroup viewgroup, View view, int i);
    }


    public LayoutTransition() {
        mDisappearingAnim = null;
        mAppearingAnim = null;
        mChangingAppearingAnim = null;
        mChangingDisappearingAnim = null;
        mChangingAnim = null;
        mChangingAppearingDuration = DEFAULT_DURATION;
        mChangingDisappearingDuration = DEFAULT_DURATION;
        mChangingDuration = DEFAULT_DURATION;
        mAppearingDuration = DEFAULT_DURATION;
        mDisappearingDuration = DEFAULT_DURATION;
        mAppearingDelay = DEFAULT_DURATION;
        mDisappearingDelay = 0L;
        mChangingAppearingDelay = 0L;
        mChangingDisappearingDelay = DEFAULT_DURATION;
        mChangingDelay = 0L;
        mChangingAppearingStagger = 0L;
        mChangingDisappearingStagger = 0L;
        mChangingStagger = 0L;
        mAppearingInterpolator = new AccelerateDecelerateInterpolator();
        mDisappearingInterpolator = new AccelerateDecelerateInterpolator();
        mChangingAppearingInterpolator = new DecelerateInterpolator();
        mChangingDisappearingInterpolator = new DecelerateInterpolator();
        mChangingInterpolator = new DecelerateInterpolator();
        mTransitionTypes = 15;
        mAnimateParentHierarchy = true;
        if(defaultChangeIn == null) {
            int ai[] = new int[2];
            ai[0] = 0;
            ai[1] = 1;
            PropertyValuesHolder propertyvaluesholder = PropertyValuesHolder.ofInt("left", ai);
            int ai1[] = new int[2];
            ai1[0] = 0;
            ai1[1] = 1;
            PropertyValuesHolder propertyvaluesholder1 = PropertyValuesHolder.ofInt("top", ai1);
            int ai2[] = new int[2];
            ai2[0] = 0;
            ai2[1] = 1;
            PropertyValuesHolder propertyvaluesholder2 = PropertyValuesHolder.ofInt("right", ai2);
            int ai3[] = new int[2];
            ai3[0] = 0;
            ai3[1] = 1;
            PropertyValuesHolder propertyvaluesholder3 = PropertyValuesHolder.ofInt("bottom", ai3);
            int ai4[] = new int[2];
            ai4[0] = 0;
            ai4[1] = 1;
            PropertyValuesHolder propertyvaluesholder4 = PropertyValuesHolder.ofInt("scrollX", ai4);
            int ai5[] = new int[2];
            ai5[0] = 0;
            ai5[1] = 1;
            PropertyValuesHolder propertyvaluesholder5 = PropertyValuesHolder.ofInt("scrollY", ai5);
            Object obj = (Object)null;
            PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[6];
            apropertyvaluesholder[0] = propertyvaluesholder;
            apropertyvaluesholder[1] = propertyvaluesholder1;
            apropertyvaluesholder[2] = propertyvaluesholder2;
            apropertyvaluesholder[3] = propertyvaluesholder3;
            apropertyvaluesholder[4] = propertyvaluesholder4;
            apropertyvaluesholder[5] = propertyvaluesholder5;
            defaultChangeIn = ObjectAnimator.ofPropertyValuesHolder(obj, apropertyvaluesholder);
            defaultChangeIn.setDuration(DEFAULT_DURATION);
            defaultChangeIn.setStartDelay(mChangingAppearingDelay);
            defaultChangeIn.setInterpolator(mChangingAppearingInterpolator);
            defaultChangeOut = defaultChangeIn.clone();
            defaultChangeOut.setStartDelay(mChangingDisappearingDelay);
            defaultChangeOut.setInterpolator(mChangingDisappearingInterpolator);
            defaultChange = defaultChangeIn.clone();
            defaultChange.setStartDelay(mChangingDelay);
            defaultChange.setInterpolator(mChangingInterpolator);
            float af[] = new float[2];
            af[0] = 0.0F;
            af[1] = 1.0F;
            defaultFadeIn = ObjectAnimator.ofFloat(null, "alpha", af);
            defaultFadeIn.setDuration(DEFAULT_DURATION);
            defaultFadeIn.setStartDelay(mAppearingDelay);
            defaultFadeIn.setInterpolator(mAppearingInterpolator);
            float af1[] = new float[2];
            af1[0] = 1.0F;
            af1[1] = 0.0F;
            defaultFadeOut = ObjectAnimator.ofFloat(null, "alpha", af1);
            defaultFadeOut.setDuration(DEFAULT_DURATION);
            defaultFadeOut.setStartDelay(mDisappearingDelay);
            defaultFadeOut.setInterpolator(mDisappearingInterpolator);
        }
        mChangingAppearingAnim = defaultChangeIn;
        mChangingDisappearingAnim = defaultChangeOut;
        mChangingAnim = defaultChange;
        mAppearingAnim = defaultFadeIn;
        mDisappearingAnim = defaultFadeOut;
    }

    private void addChild(ViewGroup viewgroup, View view, boolean flag) {
        if(viewgroup.getWindowVisibility() == 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if((1 & mTransitionTypes) == 1)
            cancel(3);
        if(flag && (4 & mTransitionTypes) == 4) {
            cancel(0);
            cancel(4);
        }
        if(hasListeners() && (1 & mTransitionTypes) == 1) {
            for(Iterator iterator = ((ArrayList)mListeners.clone()).iterator(); iterator.hasNext(); ((TransitionListener)iterator.next()).startTransition(this, viewgroup, view, 2));
        }
        if(flag && (4 & mTransitionTypes) == 4)
            runChangeTransition(viewgroup, view, 2);
        if((1 & mTransitionTypes) == 1)
            runAppearingTransition(viewgroup, view);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean hasListeners() {
        boolean flag;
        if(mListeners != null && mListeners.size() > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void removeChild(ViewGroup viewgroup, View view, boolean flag) {
        if(viewgroup.getWindowVisibility() == 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if((2 & mTransitionTypes) == 2)
            cancel(2);
        if(flag && (8 & mTransitionTypes) == 8) {
            cancel(1);
            cancel(4);
        }
        if(hasListeners() && (2 & mTransitionTypes) == 2) {
            for(Iterator iterator = ((ArrayList)mListeners.clone()).iterator(); iterator.hasNext(); ((TransitionListener)iterator.next()).startTransition(this, viewgroup, view, 3));
        }
        if(flag && (8 & mTransitionTypes) == 8)
            runChangeTransition(viewgroup, view, 3);
        if((2 & mTransitionTypes) == 2)
            runDisappearingTransition(viewgroup, view);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void runAppearingTransition(final ViewGroup parent, final View child) {
        Animator animator = (Animator)currentDisappearingAnimations.get(child);
        if(animator != null)
            animator.cancel();
        if(mAppearingAnim == null) {
            if(hasListeners()) {
                for(Iterator iterator = ((ArrayList)mListeners.clone()).iterator(); iterator.hasNext(); ((TransitionListener)iterator.next()).endTransition(this, parent, child, 2));
            }
        } else {
            Animator animator1 = mAppearingAnim.clone();
            animator1.setTarget(child);
            animator1.setStartDelay(mAppearingDelay);
            animator1.setDuration(mAppearingDuration);
            if(animator1 instanceof ObjectAnimator)
                ((ObjectAnimator)animator1).setCurrentPlayTime(0L);
            animator1.addListener(new AnimatorListenerAdapter() {

                public void onAnimationEnd(Animator animator2) {
                    currentAppearingAnimations.remove(child);
                    if(hasListeners()) {
                        for(Iterator iterator1 = ((ArrayList)mListeners.clone()).iterator(); iterator1.hasNext(); ((TransitionListener)iterator1.next()).endTransition(LayoutTransition.this, parent, child, 2));
                    }
                }

                final LayoutTransition this$0;
                final View val$child;
                final ViewGroup val$parent;

             {
                this$0 = LayoutTransition.this;
                child = view;
                parent = viewgroup;
                super();
            }
            });
            currentAppearingAnimations.put(child, animator1);
            animator1.start();
        }
    }

    private void runChangeTransition(final ViewGroup parent, View view, int i) {
        Animator animator;
        ObjectAnimator objectanimator;
        animator = null;
        objectanimator = null;
        i;
        JVM INSTR tableswitch 2 4: default 32
    //                   2 41
    //                   3 61
    //                   4 81;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_81;
_L1:
        long l = 0L;
_L5:
        if(animator != null) {
            staggerDelay = 0L;
            ViewTreeObserver viewtreeobserver = parent.getViewTreeObserver();
            if(viewtreeobserver.isAlive()) {
                int j = parent.getChildCount();
                for(int k = 0; k < j; k++) {
                    View view1 = parent.getChildAt(k);
                    if(view1 != view)
                        setupChangeAnimation(parent, i, animator, l, view1);
                }

                if(mAnimateParentHierarchy) {
                    for(ViewGroup viewgroup = parent; viewgroup != null;) {
                        android.view.ViewParent viewparent = viewgroup.getParent();
                        if(viewparent instanceof ViewGroup) {
                            setupChangeAnimation((ViewGroup)viewparent, i, objectanimator, l, viewgroup);
                            viewgroup = (ViewGroup)viewparent;
                        } else {
                            viewgroup = null;
                        }
                    }

                }
                viewtreeobserver.addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

                    public boolean onPreDraw() {
                        parent.getViewTreeObserver().removeOnPreDrawListener(this);
                        if(layoutChangeListenerMap.size() > 0) {
                            View view2;
                            for(Iterator iterator = layoutChangeListenerMap.keySet().iterator(); iterator.hasNext(); view2.removeOnLayoutChangeListener((android.view.View.OnLayoutChangeListener)layoutChangeListenerMap.get(view2)))
                                view2 = (View)iterator.next();

                        }
                        layoutChangeListenerMap.clear();
                        return true;
                    }

                    final LayoutTransition this$0;
                    final ViewGroup val$parent;

             {
                this$0 = LayoutTransition.this;
                parent = viewgroup;
                super();
            }
                });
            }
        }
        return;
_L2:
        animator = mChangingAppearingAnim;
        l = mChangingAppearingDuration;
        objectanimator = defaultChangeIn;
          goto _L5
_L3:
        animator = mChangingDisappearingAnim;
        l = mChangingDisappearingDuration;
        objectanimator = defaultChangeOut;
          goto _L5
        animator = mChangingAnim;
        l = mChangingDuration;
        objectanimator = defaultChange;
          goto _L5
    }

    private void runDisappearingTransition(ViewGroup viewgroup, final View child) {
        Animator animator = (Animator)currentAppearingAnimations.get(child);
        if(animator != null)
            animator.cancel();
        if(mDisappearingAnim == null) {
            if(hasListeners()) {
                for(Iterator iterator = ((ArrayList)mListeners.clone()).iterator(); iterator.hasNext(); ((TransitionListener)iterator.next()).endTransition(this, viewgroup, child, 3));
            }
        } else {
            Animator animator1 = mDisappearingAnim.clone();
            animator1.setStartDelay(mDisappearingDelay);
            animator1.setDuration(mDisappearingDuration);
            animator1.setTarget(child);
            animator1.addListener(new AnimatorListenerAdapter() {

                public void onAnimationEnd(Animator animator2) {
                    currentDisappearingAnimations.remove(child);
                    child.setAlpha(preAnimAlpha);
                    if(hasListeners()) {
                        for(Iterator iterator1 = ((ArrayList)mListeners.clone()).iterator(); iterator1.hasNext(); ((TransitionListener)iterator1.next()).endTransition(LayoutTransition.this, parent, child, 3));
                    }
                }

                final LayoutTransition this$0;
                final View val$child;
                final ViewGroup val$parent;
                final float val$preAnimAlpha;

             {
                this$0 = LayoutTransition.this;
                child = view;
                preAnimAlpha = f;
                parent = viewgroup;
                super();
            }
            });
            if(animator1 instanceof ObjectAnimator)
                ((ObjectAnimator)animator1).setCurrentPlayTime(0L);
            currentDisappearingAnimations.put(child, animator1);
            animator1.start();
        }
    }

    private void setupChangeAnimation(final ViewGroup parent, final int changeReason, Animator animator, final long duration, final View child) {
        if(layoutChangeListenerMap.get(child) == null && (child.getWidth() != 0 || child.getHeight() != 0)) {
            final Animator anim = animator.clone();
            anim.setTarget(child);
            anim.setupStartValues();
            Animator animator1 = (Animator)pendingAnimations.get(child);
            if(animator1 != null) {
                animator1.cancel();
                pendingAnimations.remove(child);
            }
            pendingAnimations.put(child, anim);
            float af[] = new float[2];
            af[0] = 0.0F;
            af[1] = 1.0F;
            ValueAnimator valueanimator = ValueAnimator.ofFloat(af).setDuration(100L + duration);
            valueanimator.addListener(new AnimatorListenerAdapter() {

                public void onAnimationEnd(Animator animator2) {
                    pendingAnimations.remove(child);
                }

                final LayoutTransition this$0;
                final View val$child;

             {
                this$0 = LayoutTransition.this;
                child = view;
                super();
            }
            });
            valueanimator.start();
            final android.view.View.OnLayoutChangeListener listener = new android.view.View.OnLayoutChangeListener() ;
            anim.addListener(new AnimatorListenerAdapter() {

                public void onAnimationCancel(Animator animator2) {
                    child.removeOnLayoutChangeListener(listener);
                    layoutChangeListenerMap.remove(child);
                }

                public void onAnimationEnd(Animator animator2) {
                    currentChangingAnimations.remove(child);
                    if(hasListeners()) {
                        Iterator iterator = ((ArrayList)mListeners.clone()).iterator();
                        while(iterator.hasNext())  {
                            TransitionListener transitionlistener = (TransitionListener)iterator.next();
                            LayoutTransition layouttransition = LayoutTransition.this;
                            ViewGroup viewgroup = parent;
                            View view = child;
                            int i;
                            if(changeReason == 2)
                                i = 0;
                            else
                            if(changeReason == 3)
                                i = 1;
                            else
                                i = 4;
                            transitionlistener.endTransition(layouttransition, viewgroup, view, i);
                        }
                    }
                }

                public void onAnimationStart(Animator animator2) {
                    if(hasListeners()) {
                        Iterator iterator = ((ArrayList)mListeners.clone()).iterator();
                        while(iterator.hasNext())  {
                            TransitionListener transitionlistener = (TransitionListener)iterator.next();
                            LayoutTransition layouttransition = LayoutTransition.this;
                            ViewGroup viewgroup = parent;
                            View view = child;
                            int i;
                            if(changeReason == 2)
                                i = 0;
                            else
                            if(changeReason == 3)
                                i = 1;
                            else
                                i = 4;
                            transitionlistener.startTransition(layouttransition, viewgroup, view, i);
                        }
                    }
                }

                final LayoutTransition this$0;
                final int val$changeReason;
                final View val$child;
                final android.view.View.OnLayoutChangeListener val$listener;
                final ViewGroup val$parent;

             {
                this$0 = LayoutTransition.this;
                parent = viewgroup;
                child = view;
                changeReason = i;
                listener = onlayoutchangelistener;
                super();
            }
            });
            child.addOnLayoutChangeListener(listener);
            layoutChangeListenerMap.put(child, listener);
        }
    }

    public void addChild(ViewGroup viewgroup, View view) {
        addChild(viewgroup, view, true);
    }

    public void addTransitionListener(TransitionListener transitionlistener) {
        if(mListeners == null)
            mListeners = new ArrayList();
        mListeners.add(transitionlistener);
    }

    public void cancel() {
        if(currentChangingAnimations.size() > 0) {
            for(Iterator iterator2 = ((LinkedHashMap)currentChangingAnimations.clone()).values().iterator(); iterator2.hasNext(); ((Animator)iterator2.next()).cancel());
            currentChangingAnimations.clear();
        }
        if(currentAppearingAnimations.size() > 0) {
            for(Iterator iterator1 = ((LinkedHashMap)currentAppearingAnimations.clone()).values().iterator(); iterator1.hasNext(); ((Animator)iterator1.next()).end());
            currentAppearingAnimations.clear();
        }
        if(currentDisappearingAnimations.size() > 0) {
            for(Iterator iterator = ((LinkedHashMap)currentDisappearingAnimations.clone()).values().iterator(); iterator.hasNext(); ((Animator)iterator.next()).end());
            currentDisappearingAnimations.clear();
        }
    }

    public void cancel(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 37
    //                   1 37
    //                   2 103
    //                   3 166
    //                   4 37;
           goto _L1 _L2 _L2 _L3 _L4 _L2
_L1:
        return;
_L2:
        if(currentChangingAnimations.size() > 0) {
            for(Iterator iterator2 = ((LinkedHashMap)currentChangingAnimations.clone()).values().iterator(); iterator2.hasNext(); ((Animator)iterator2.next()).cancel());
            currentChangingAnimations.clear();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(currentAppearingAnimations.size() > 0) {
            for(Iterator iterator1 = ((LinkedHashMap)currentAppearingAnimations.clone()).values().iterator(); iterator1.hasNext(); ((Animator)iterator1.next()).end());
            currentAppearingAnimations.clear();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(currentDisappearingAnimations.size() > 0) {
            for(Iterator iterator = ((LinkedHashMap)currentDisappearingAnimations.clone()).values().iterator(); iterator.hasNext(); ((Animator)iterator.next()).end());
            currentDisappearingAnimations.clear();
        }
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void disableTransitionType(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 65
    //                   1 79
    //                   2 37
    //                   3 51
    //                   4 93;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L4:
        mTransitionTypes = -2 & mTransitionTypes;
        continue; /* Loop/switch isn't completed */
_L5:
        mTransitionTypes = -3 & mTransitionTypes;
        continue; /* Loop/switch isn't completed */
_L2:
        mTransitionTypes = -5 & mTransitionTypes;
        continue; /* Loop/switch isn't completed */
_L3:
        mTransitionTypes = -9 & mTransitionTypes;
        continue; /* Loop/switch isn't completed */
_L6:
        mTransitionTypes = 0xffffffef & mTransitionTypes;
        if(true) goto _L1; else goto _L7
_L7:
    }

    public void enableTransitionType(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 63
    //                   1 76
    //                   2 37
    //                   3 50
    //                   4 90;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L4:
        mTransitionTypes = 1 | mTransitionTypes;
        continue; /* Loop/switch isn't completed */
_L5:
        mTransitionTypes = 2 | mTransitionTypes;
        continue; /* Loop/switch isn't completed */
_L2:
        mTransitionTypes = 4 | mTransitionTypes;
        continue; /* Loop/switch isn't completed */
_L3:
        mTransitionTypes = 8 | mTransitionTypes;
        continue; /* Loop/switch isn't completed */
_L6:
        mTransitionTypes = 0x10 | mTransitionTypes;
        if(true) goto _L1; else goto _L7
_L7:
    }

    public void endChangingAnimations() {
        Animator animator;
        for(Iterator iterator = ((LinkedHashMap)currentChangingAnimations.clone()).values().iterator(); iterator.hasNext(); animator.end()) {
            animator = (Animator)iterator.next();
            animator.start();
        }

        currentChangingAnimations.clear();
    }

    public Animator getAnimator(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 40
    //                   1 48
    //                   2 64
    //                   3 72
    //                   4 56;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        Animator animator = null;
_L8:
        return animator;
_L2:
        animator = mChangingAppearingAnim;
        continue; /* Loop/switch isn't completed */
_L3:
        animator = mChangingDisappearingAnim;
        continue; /* Loop/switch isn't completed */
_L6:
        animator = mChangingAnim;
        continue; /* Loop/switch isn't completed */
_L4:
        animator = mAppearingAnim;
        continue; /* Loop/switch isn't completed */
_L5:
        animator = mDisappearingAnim;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public long getDuration(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 40
    //                   1 48
    //                   2 64
    //                   3 72
    //                   4 56;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        long l = 0L;
_L8:
        return l;
_L2:
        l = mChangingAppearingDuration;
        continue; /* Loop/switch isn't completed */
_L3:
        l = mChangingDisappearingDuration;
        continue; /* Loop/switch isn't completed */
_L6:
        l = mChangingDuration;
        continue; /* Loop/switch isn't completed */
_L4:
        l = mAppearingDuration;
        continue; /* Loop/switch isn't completed */
_L5:
        l = mDisappearingDuration;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public TimeInterpolator getInterpolator(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 40
    //                   1 48
    //                   2 64
    //                   3 72
    //                   4 56;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        TimeInterpolator timeinterpolator = null;
_L8:
        return timeinterpolator;
_L2:
        timeinterpolator = mChangingAppearingInterpolator;
        continue; /* Loop/switch isn't completed */
_L3:
        timeinterpolator = mChangingDisappearingInterpolator;
        continue; /* Loop/switch isn't completed */
_L6:
        timeinterpolator = mChangingInterpolator;
        continue; /* Loop/switch isn't completed */
_L4:
        timeinterpolator = mAppearingInterpolator;
        continue; /* Loop/switch isn't completed */
_L5:
        timeinterpolator = mDisappearingInterpolator;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public long getStagger(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 40
    //                   1 48
    //                   2 36
    //                   3 36
    //                   4 56;
           goto _L1 _L2 _L3 _L1 _L1 _L4
_L1:
        long l = 0L;
_L6:
        return l;
_L2:
        l = mChangingAppearingStagger;
        continue; /* Loop/switch isn't completed */
_L3:
        l = mChangingDisappearingStagger;
        continue; /* Loop/switch isn't completed */
_L4:
        l = mChangingStagger;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public long getStartDelay(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 40
    //                   1 48
    //                   2 64
    //                   3 72
    //                   4 56;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        long l = 0L;
_L8:
        return l;
_L2:
        l = mChangingAppearingDelay;
        continue; /* Loop/switch isn't completed */
_L3:
        l = mChangingDisappearingDelay;
        continue; /* Loop/switch isn't completed */
_L6:
        l = mChangingDelay;
        continue; /* Loop/switch isn't completed */
_L4:
        l = mAppearingDelay;
        continue; /* Loop/switch isn't completed */
_L5:
        l = mDisappearingDelay;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public List getTransitionListeners() {
        return mListeners;
    }

    public void hideChild(ViewGroup viewgroup, View view) {
        removeChild(viewgroup, view, true);
    }

    public void hideChild(ViewGroup viewgroup, View view, int i) {
        boolean flag;
        if(i == 8)
            flag = true;
        else
            flag = false;
        removeChild(viewgroup, view, flag);
    }

    public boolean isChangingLayout() {
        boolean flag;
        if(currentChangingAnimations.size() > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isRunning() {
        boolean flag;
        if(currentChangingAnimations.size() > 0 || currentAppearingAnimations.size() > 0 || currentDisappearingAnimations.size() > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isTransitionTypeEnabled(int i) {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 70
    //                   1 85
    //                   2 40
    //                   3 55
    //                   4 102;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        flag = false;
_L8:
        return flag;
_L4:
        if((1 & mTransitionTypes) != flag)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if((2 & mTransitionTypes) != 2)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L2:
        if((4 & mTransitionTypes) != 4)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        if((8 & mTransitionTypes) != 8)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L6:
        if((0x10 & mTransitionTypes) != 16)
            flag = false;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public void layoutChange(ViewGroup viewgroup) {
        if(viewgroup.getWindowVisibility() == 0 && (0x10 & mTransitionTypes) == 16 && !isRunning())
            runChangeTransition(viewgroup, null, 4);
    }

    public void removeChild(ViewGroup viewgroup, View view) {
        removeChild(viewgroup, view, true);
    }

    public void removeTransitionListener(TransitionListener transitionlistener) {
        if(mListeners != null)
            mListeners.remove(transitionlistener);
    }

    public void setAnimateParentHierarchy(boolean flag) {
        mAnimateParentHierarchy = flag;
    }

    public void setAnimator(int i, Animator animator) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 37
    //                   1 45
    //                   2 61
    //                   3 69
    //                   4 53;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        mChangingAppearingAnim = animator;
        continue; /* Loop/switch isn't completed */
_L3:
        mChangingDisappearingAnim = animator;
        continue; /* Loop/switch isn't completed */
_L6:
        mChangingAnim = animator;
        continue; /* Loop/switch isn't completed */
_L4:
        mAppearingAnim = animator;
        continue; /* Loop/switch isn't completed */
_L5:
        mDisappearingAnim = animator;
        if(true) goto _L1; else goto _L7
_L7:
    }

    public void setDuration(int i, long l) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 37
    //                   1 45
    //                   2 61
    //                   3 69
    //                   4 53;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        mChangingAppearingDuration = l;
        continue; /* Loop/switch isn't completed */
_L3:
        mChangingDisappearingDuration = l;
        continue; /* Loop/switch isn't completed */
_L6:
        mChangingDuration = l;
        continue; /* Loop/switch isn't completed */
_L4:
        mAppearingDuration = l;
        continue; /* Loop/switch isn't completed */
_L5:
        mDisappearingDuration = l;
        if(true) goto _L1; else goto _L7
_L7:
    }

    public void setDuration(long l) {
        mChangingAppearingDuration = l;
        mChangingDisappearingDuration = l;
        mChangingDuration = l;
        mAppearingDuration = l;
        mDisappearingDuration = l;
    }

    public void setInterpolator(int i, TimeInterpolator timeinterpolator) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 37
    //                   1 45
    //                   2 61
    //                   3 69
    //                   4 53;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        mChangingAppearingInterpolator = timeinterpolator;
        continue; /* Loop/switch isn't completed */
_L3:
        mChangingDisappearingInterpolator = timeinterpolator;
        continue; /* Loop/switch isn't completed */
_L6:
        mChangingInterpolator = timeinterpolator;
        continue; /* Loop/switch isn't completed */
_L4:
        mAppearingInterpolator = timeinterpolator;
        continue; /* Loop/switch isn't completed */
_L5:
        mDisappearingInterpolator = timeinterpolator;
        if(true) goto _L1; else goto _L7
_L7:
    }

    public void setStagger(int i, long l) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 37
    //                   1 45
    //                   2 36
    //                   3 36
    //                   4 53;
           goto _L1 _L2 _L3 _L1 _L1 _L4
_L1:
        return;
_L2:
        mChangingAppearingStagger = l;
        continue; /* Loop/switch isn't completed */
_L3:
        mChangingDisappearingStagger = l;
        continue; /* Loop/switch isn't completed */
_L4:
        mChangingStagger = l;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public void setStartDelay(int i, long l) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 37
    //                   1 45
    //                   2 61
    //                   3 69
    //                   4 53;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        mChangingAppearingDelay = l;
        continue; /* Loop/switch isn't completed */
_L3:
        mChangingDisappearingDelay = l;
        continue; /* Loop/switch isn't completed */
_L6:
        mChangingDelay = l;
        continue; /* Loop/switch isn't completed */
_L4:
        mAppearingDelay = l;
        continue; /* Loop/switch isn't completed */
_L5:
        mDisappearingDelay = l;
        if(true) goto _L1; else goto _L7
_L7:
    }

    public void showChild(ViewGroup viewgroup, View view) {
        addChild(viewgroup, view, true);
    }

    public void showChild(ViewGroup viewgroup, View view, int i) {
        boolean flag;
        if(i == 8)
            flag = true;
        else
            flag = false;
        addChild(viewgroup, view, flag);
    }

    public void startChangingAnimations() {
        Animator animator;
        for(Iterator iterator = ((LinkedHashMap)currentChangingAnimations.clone()).values().iterator(); iterator.hasNext(); animator.start()) {
            animator = (Animator)iterator.next();
            if(animator instanceof ObjectAnimator)
                ((ObjectAnimator)animator).setCurrentPlayTime(0L);
        }

    }

    public static final int APPEARING = 2;
    public static final int CHANGE_APPEARING = 0;
    public static final int CHANGE_DISAPPEARING = 1;
    public static final int CHANGING = 4;
    private static long DEFAULT_DURATION = 0L;
    public static final int DISAPPEARING = 3;
    private static final int FLAG_APPEARING = 1;
    private static final int FLAG_CHANGE_APPEARING = 4;
    private static final int FLAG_CHANGE_DISAPPEARING = 8;
    private static final int FLAG_CHANGING = 16;
    private static final int FLAG_DISAPPEARING = 2;
    private static ObjectAnimator defaultChange;
    private static ObjectAnimator defaultChangeIn;
    private static ObjectAnimator defaultChangeOut;
    private static ObjectAnimator defaultFadeIn;
    private static ObjectAnimator defaultFadeOut;
    private final LinkedHashMap currentAppearingAnimations = new LinkedHashMap();
    private final LinkedHashMap currentChangingAnimations = new LinkedHashMap();
    private final LinkedHashMap currentDisappearingAnimations = new LinkedHashMap();
    private final HashMap layoutChangeListenerMap = new HashMap();
    private boolean mAnimateParentHierarchy;
    private Animator mAppearingAnim;
    private long mAppearingDelay;
    private long mAppearingDuration;
    private TimeInterpolator mAppearingInterpolator;
    private Animator mChangingAnim;
    private Animator mChangingAppearingAnim;
    private long mChangingAppearingDelay;
    private long mChangingAppearingDuration;
    private TimeInterpolator mChangingAppearingInterpolator;
    private long mChangingAppearingStagger;
    private long mChangingDelay;
    private Animator mChangingDisappearingAnim;
    private long mChangingDisappearingDelay;
    private long mChangingDisappearingDuration;
    private TimeInterpolator mChangingDisappearingInterpolator;
    private long mChangingDisappearingStagger;
    private long mChangingDuration;
    private TimeInterpolator mChangingInterpolator;
    private long mChangingStagger;
    private Animator mDisappearingAnim;
    private long mDisappearingDelay;
    private long mDisappearingDuration;
    private TimeInterpolator mDisappearingInterpolator;
    private ArrayList mListeners;
    private int mTransitionTypes;
    private final HashMap pendingAnimations = new HashMap();
    private long staggerDelay;

    static  {
        DEFAULT_DURATION = 300L;
    }










/*
    static long access$314(LayoutTransition layouttransition, long l) {
        long l1 = l + layouttransition.staggerDelay;
        layouttransition.staggerDelay = l1;
        return l1;
    }

*/






}
