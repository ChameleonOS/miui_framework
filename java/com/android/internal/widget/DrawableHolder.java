// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class DrawableHolder
    implements android.animation.Animator.AnimatorListener {

    public DrawableHolder(BitmapDrawable bitmapdrawable) {
        this(bitmapdrawable, 0.0F, 0.0F);
    }

    public DrawableHolder(BitmapDrawable bitmapdrawable, float f, float f1) {
        mX = 0.0F;
        mY = 0.0F;
        mScaleX = 1.0F;
        mScaleY = 1.0F;
        mAlpha = 1.0F;
        mAnimators = new ArrayList();
        mNeedToStart = new ArrayList();
        mDrawable = bitmapdrawable;
        mX = f;
        mY = f1;
        mDrawable.getPaint().setAntiAlias(true);
        mDrawable.setBounds(0, 0, mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
    }

    private DrawableHolder addAnimation(ObjectAnimator objectanimator, boolean flag) {
        if(objectanimator != null)
            mAnimators.add(objectanimator);
        mNeedToStart.add(objectanimator);
        return this;
    }

    public ObjectAnimator addAnimTo(long l, long l1, String s, float f, boolean flag) {
        if(flag)
            removeAnimationFor(s);
        float af[] = new float[1];
        af[0] = f;
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, s, af);
        objectanimator.setDuration(l);
        objectanimator.setStartDelay(l1);
        objectanimator.setInterpolator(EASE_OUT_INTERPOLATOR);
        addAnimation(objectanimator, flag);
        return objectanimator;
    }

    public void clearAnimations() {
        for(Iterator iterator = mAnimators.iterator(); iterator.hasNext(); ((ObjectAnimator)iterator.next()).cancel());
        mAnimators.clear();
    }

    public void draw(Canvas canvas) {
        if(mAlpha > 0.00390625F) {
            canvas.save(1);
            canvas.translate(mX, mY);
            canvas.scale(mScaleX, mScaleY);
            canvas.translate(-0.5F * (float)getWidth(), -0.5F * (float)getHeight());
            mDrawable.setAlpha(Math.round(255F * mAlpha));
            mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    public float getAlpha() {
        return mAlpha;
    }

    public BitmapDrawable getDrawable() {
        return mDrawable;
    }

    public int getHeight() {
        return mDrawable.getIntrinsicHeight();
    }

    public float getScaleX() {
        return mScaleX;
    }

    public float getScaleY() {
        return mScaleY;
    }

    public int getWidth() {
        return mDrawable.getIntrinsicWidth();
    }

    public float getX() {
        return mX;
    }

    public float getY() {
        return mY;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        mAnimators.remove(animator);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void removeAnimationFor(String s) {
        Iterator iterator = ((ArrayList)mAnimators.clone()).iterator();
        do {
            if(!iterator.hasNext())
                break;
            ObjectAnimator objectanimator = (ObjectAnimator)iterator.next();
            if(s.equals(objectanimator.getPropertyName()))
                objectanimator.cancel();
        } while(true);
    }

    public void setAlpha(float f) {
        mAlpha = f;
    }

    public void setScaleX(float f) {
        mScaleX = f;
    }

    public void setScaleY(float f) {
        mScaleY = f;
    }

    public void setX(float f) {
        mX = f;
    }

    public void setY(float f) {
        mY = f;
    }

    public void startAnimations(android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener) {
        for(int i = 0; i < mNeedToStart.size(); i++) {
            ObjectAnimator objectanimator = (ObjectAnimator)mNeedToStart.get(i);
            objectanimator.addUpdateListener(animatorupdatelistener);
            objectanimator.addListener(this);
            objectanimator.start();
        }

        mNeedToStart.clear();
    }

    private static final boolean DBG = false;
    public static final DecelerateInterpolator EASE_OUT_INTERPOLATOR = new DecelerateInterpolator();
    private static final String TAG = "DrawableHolder";
    private float mAlpha;
    private ArrayList mAnimators;
    private BitmapDrawable mDrawable;
    private ArrayList mNeedToStart;
    private float mScaleX;
    private float mScaleY;
    private float mX;
    private float mY;

}
