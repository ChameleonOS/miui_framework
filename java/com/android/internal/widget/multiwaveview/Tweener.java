// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget.multiwaveview;

import android.animation.*;
import java.util.*;

class Tweener {

    public Tweener(ObjectAnimator objectanimator) {
        animator = objectanimator;
    }

    private static void remove(Animator animator1) {
        Iterator iterator = sTweens.entrySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            if(((Tweener)((java.util.Map.Entry)iterator.next()).getValue()).animator != animator1)
                continue;
            iterator.remove();
            break;
        } while(true);
    }

    private static transient void replace(ArrayList arraylist, Object aobj[]) {
        int i = aobj.length;
        int j = 0;
        while(j < i)  {
            Object obj = aobj[j];
            Tweener tweener = (Tweener)sTweens.get(obj);
            if(tweener != null) {
                tweener.animator.cancel();
                if(arraylist != null)
                    tweener.animator.setValues((PropertyValuesHolder[])arraylist.toArray(new PropertyValuesHolder[arraylist.size()]));
                else
                    sTweens.remove(tweener);
            }
            j++;
        }
    }

    public static void reset() {
        sTweens.clear();
    }

    public static transient Tweener to(Object obj, long l, Object aobj[]) {
        long l1 = 0L;
        android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener = null;
        android.animation.Animator.AnimatorListener animatorlistener = null;
        TimeInterpolator timeinterpolator = null;
        ArrayList arraylist = new ArrayList(aobj.length / 2);
        int i = 0;
        while(i < aobj.length)  {
            if(!(aobj[i] instanceof String))
                throw new IllegalArgumentException((new StringBuilder()).append("Key must be a string: ").append(aobj[i]).toString());
            String s = (String)aobj[i];
            Object obj1 = aobj[i + 1];
            if(!"simultaneousTween".equals(s))
                if("ease".equals(s))
                    timeinterpolator = (TimeInterpolator)obj1;
                else
                if("onUpdate".equals(s) || "onUpdateListener".equals(s))
                    animatorupdatelistener = (android.animation.ValueAnimator.AnimatorUpdateListener)obj1;
                else
                if("onComplete".equals(s) || "onCompleteListener".equals(s))
                    animatorlistener = (android.animation.Animator.AnimatorListener)obj1;
                else
                if("delay".equals(s))
                    l1 = ((Number)obj1).longValue();
                else
                if(!"syncWith".equals(s))
                    if(obj1 instanceof float[]) {
                        float af1[] = new float[2];
                        af1[0] = ((float[])(float[])obj1)[0];
                        af1[1] = ((float[])(float[])obj1)[1];
                        arraylist.add(PropertyValuesHolder.ofFloat(s, af1));
                    } else
                    if(obj1 instanceof int[]) {
                        int ai[] = new int[2];
                        ai[0] = ((int[])(int[])obj1)[0];
                        ai[1] = ((int[])(int[])obj1)[1];
                        arraylist.add(PropertyValuesHolder.ofInt(s, ai));
                    } else
                    if(obj1 instanceof Number) {
                        float f = ((Number)obj1).floatValue();
                        float af[] = new float[1];
                        af[0] = f;
                        arraylist.add(PropertyValuesHolder.ofFloat(s, af));
                    } else {
                        throw new IllegalArgumentException((new StringBuilder()).append("Bad argument for key \"").append(s).append("\" with value ").append(obj1.getClass()).toString());
                    }
            i += 2;
        }
        Tweener tweener = (Tweener)sTweens.get(obj);
        ObjectAnimator objectanimator;
        if(tweener == null) {
            objectanimator = ObjectAnimator.ofPropertyValuesHolder(obj, (PropertyValuesHolder[])arraylist.toArray(new PropertyValuesHolder[arraylist.size()]));
            tweener = new Tweener(objectanimator);
            sTweens.put(obj, tweener);
        } else {
            objectanimator = ((Tweener)sTweens.get(obj)).animator;
            Object aobj1[] = new Object[1];
            aobj1[0] = obj;
            replace(arraylist, aobj1);
        }
        if(timeinterpolator != null)
            objectanimator.setInterpolator(timeinterpolator);
        objectanimator.setStartDelay(l1);
        objectanimator.setDuration(l);
        if(animatorupdatelistener != null) {
            objectanimator.removeAllUpdateListeners();
            objectanimator.addUpdateListener(animatorupdatelistener);
        }
        if(animatorlistener != null) {
            objectanimator.removeAllListeners();
            objectanimator.addListener(animatorlistener);
        }
        objectanimator.addListener(mCleanupListener);
        return tweener;
    }

    transient Tweener from(Object obj, long l, Object aobj[]) {
        return to(obj, l, aobj);
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "Tweener";
    private static android.animation.Animator.AnimatorListener mCleanupListener = new AnimatorListenerAdapter() {

        public void onAnimationCancel(Animator animator1) {
            Tweener.remove(animator1);
        }

        public void onAnimationEnd(Animator animator1) {
            Tweener.remove(animator1);
        }

    };
    private static HashMap sTweens = new HashMap();
    ObjectAnimator animator;


}
