// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget.multiwaveview;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class TargetDrawable {
    static class DrawableWithAlpha extends Drawable {

        public void draw(Canvas canvas) {
            mRealDrawable.setAlpha(Math.round(255F * mAlpha));
            mRealDrawable.draw(canvas);
        }

        public float getAlpha() {
            return mAlpha;
        }

        public int getOpacity() {
            return mRealDrawable.getOpacity();
        }

        public void setAlpha(float f) {
            mAlpha = f;
        }

        public void setAlpha(int i) {
            mRealDrawable.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorfilter) {
            mRealDrawable.setColorFilter(colorfilter);
        }

        private float mAlpha;
        private Drawable mRealDrawable;

        public DrawableWithAlpha(Drawable drawable) {
            mAlpha = 1.0F;
            mRealDrawable = drawable;
        }
    }


    public TargetDrawable(Resources resources, int i) {
        mTranslationX = 0.0F;
        mTranslationY = 0.0F;
        mPositionX = 0.0F;
        mPositionY = 0.0F;
        mScaleX = 1.0F;
        mScaleY = 1.0F;
        mAlpha = 1.0F;
        mEnabled = true;
        mResourceId = i;
        setDrawable(resources, i);
    }

    public TargetDrawable(TargetDrawable targetdrawable) {
        mTranslationX = 0.0F;
        mTranslationY = 0.0F;
        mPositionX = 0.0F;
        mPositionY = 0.0F;
        mScaleX = 1.0F;
        mScaleY = 1.0F;
        mAlpha = 1.0F;
        mEnabled = true;
        mResourceId = targetdrawable.mResourceId;
        Drawable drawable;
        if(targetdrawable.mDrawable != null)
            drawable = targetdrawable.mDrawable.mutate();
        else
            drawable = null;
        mDrawable = drawable;
        resizeDrawables();
        setState(STATE_INACTIVE);
    }

    private void resizeDrawables() {
        if(mDrawable instanceof StateListDrawable) {
            StateListDrawable statelistdrawable = (StateListDrawable)mDrawable;
            int i = 0;
            int j = 0;
            for(int k = 0; k < statelistdrawable.getStateCount(); k++) {
                Drawable drawable = statelistdrawable.getStateDrawable(k);
                i = Math.max(i, drawable.getIntrinsicWidth());
                j = Math.max(j, drawable.getIntrinsicHeight());
            }

            statelistdrawable.setBounds(0, 0, i, j);
            for(int l = 0; l < statelistdrawable.getStateCount(); l++)
                statelistdrawable.getStateDrawable(l).setBounds(0, 0, i, j);

        } else
        if(mDrawable != null)
            mDrawable.setBounds(0, 0, mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
    }

    public void draw(Canvas canvas) {
        if(mDrawable != null && mEnabled) {
            canvas.save(1);
            canvas.scale(mScaleX, mScaleY, mPositionX, mPositionY);
            canvas.translate(mTranslationX + mPositionX, mTranslationY + mPositionY);
            canvas.translate(-0.5F * (float)getWidth(), -0.5F * (float)getHeight());
            mDrawable.setAlpha(Math.round(255F * mAlpha));
            mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    public float getAlpha() {
        return mAlpha;
    }

    public int getHeight() {
        int i;
        if(mDrawable != null)
            i = mDrawable.getIntrinsicHeight();
        else
            i = 0;
        return i;
    }

    public float getPositionX() {
        return mPositionX;
    }

    public float getPositionY() {
        return mPositionY;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public float getScaleX() {
        return mScaleX;
    }

    public float getScaleY() {
        return mScaleY;
    }

    public int getWidth() {
        int i;
        if(mDrawable != null)
            i = mDrawable.getIntrinsicWidth();
        else
            i = 0;
        return i;
    }

    public float getX() {
        return mTranslationX;
    }

    public float getY() {
        return mTranslationY;
    }

    public boolean hasState(int ai[]) {
        boolean flag = false;
        if((mDrawable instanceof StateListDrawable) && ((StateListDrawable)mDrawable).getStateDrawableIndex(ai) != -1)
            flag = true;
        return flag;
    }

    public boolean isActive() {
        int ai[];
        int i;
        if(!(mDrawable instanceof StateListDrawable))
            break MISSING_BLOCK_LABEL_47;
        ai = ((StateListDrawable)mDrawable).getState();
        i = 0;
_L3:
        if(i >= ai.length)
            break MISSING_BLOCK_LABEL_47;
        if(ai[i] != 0x101009c) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public boolean isEnabled() {
        boolean flag;
        if(mDrawable != null && mEnabled)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void setAlpha(float f) {
        mAlpha = f;
    }

    public void setDrawable(Resources resources, int i) {
        Drawable drawable = null;
        Drawable drawable1;
        if(i == 0)
            drawable1 = null;
        else
            drawable1 = resources.getDrawable(i);
        if(drawable1 != null)
            drawable = drawable1.mutate();
        mDrawable = drawable;
        resizeDrawables();
        setState(STATE_INACTIVE);
    }

    public void setEnabled(boolean flag) {
        mEnabled = flag;
    }

    public void setPositionX(float f) {
        mPositionX = f;
    }

    public void setPositionY(float f) {
        mPositionY = f;
    }

    public void setScaleX(float f) {
        mScaleX = f;
    }

    public void setScaleY(float f) {
        mScaleY = f;
    }

    public void setState(int ai[]) {
        if(mDrawable instanceof StateListDrawable)
            ((StateListDrawable)mDrawable).setState(ai);
    }

    public void setX(float f) {
        mTranslationX = f;
    }

    public void setY(float f) {
        mTranslationY = f;
    }

    private static final boolean DEBUG = false;
    public static final int STATE_ACTIVE[];
    public static final int STATE_FOCUSED[];
    public static final int STATE_INACTIVE[];
    private static final String TAG = "TargetDrawable";
    private float mAlpha;
    private Drawable mDrawable;
    private boolean mEnabled;
    private float mPositionX;
    private float mPositionY;
    private final int mResourceId;
    private float mScaleX;
    private float mScaleY;
    private float mTranslationX;
    private float mTranslationY;

    static  {
        int ai[] = new int[2];
        ai[0] = 0x101009e;
        ai[1] = 0x10100a2;
        STATE_ACTIVE = ai;
        int ai1[] = new int[2];
        ai1[0] = 0x101009e;
        ai1[1] = 0xfefeff5e;
        STATE_INACTIVE = ai1;
        int ai2[] = new int[3];
        ai2[0] = 0x101009e;
        ai2[1] = 0xfefeff5e;
        ai2[2] = 0x101009c;
        STATE_FOCUSED = ai2;
    }
}
