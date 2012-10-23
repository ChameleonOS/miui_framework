// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.graphics.*;
import android.os.SystemClock;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class DrawableContainer extends Drawable
    implements Drawable.Callback {
    public static abstract class DrawableContainerState extends Drawable.ConstantState {

        public final int addChild(Drawable drawable) {
            int i = mNumChildren;
            if(i >= mDrawables.length)
                growArray(i, i + 10);
            drawable.setVisible(false, true);
            drawable.setCallback(mOwner);
            mDrawables[i] = drawable;
            mNumChildren = 1 + mNumChildren;
            mChildrenChangingConfigurations = mChildrenChangingConfigurations | drawable.getChangingConfigurations();
            mHaveOpacity = false;
            mHaveStateful = false;
            mConstantPadding = null;
            mPaddingChecked = false;
            mComputedConstantSize = false;
            return i;
        }

        /**
         * @deprecated Method canConstantState is deprecated
         */

        public boolean canConstantState() {
            this;
            JVM INSTR monitorenter ;
            if(mCheckedConstantState) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            mCanConstantState = true;
            i = mNumChildren;
            j = 0;
_L3:
            if(j < i) {
                if(mDrawables[j].getConstantState() != null)
                    break MISSING_BLOCK_LABEL_60;
                mCanConstantState = false;
            }
            mCheckedConstantState = true;
_L2:
            boolean flag = mCanConstantState;
            this;
            JVM INSTR monitorexit ;
            return flag;
            j++;
              goto _L3
            Exception exception;
            exception;
            throw exception;
        }

        protected void computeConstantSize() {
            mComputedConstantSize = true;
            int i = getChildCount();
            Drawable adrawable[] = mDrawables;
            mConstantHeight = -1;
            mConstantWidth = -1;
            mConstantMinimumHeight = 0;
            mConstantMinimumWidth = 0;
            for(int j = 0; j < i; j++) {
                Drawable drawable = adrawable[j];
                int k = drawable.getIntrinsicWidth();
                if(k > mConstantWidth)
                    mConstantWidth = k;
                int l = drawable.getIntrinsicHeight();
                if(l > mConstantHeight)
                    mConstantHeight = l;
                int i1 = drawable.getMinimumWidth();
                if(i1 > mConstantMinimumWidth)
                    mConstantMinimumWidth = i1;
                int j1 = drawable.getMinimumHeight();
                if(j1 > mConstantMinimumHeight)
                    mConstantMinimumHeight = j1;
            }

        }

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public final int getChildCount() {
            return mNumChildren;
        }

        public final Drawable[] getChildren() {
            return mDrawables;
        }

        public final int getConstantHeight() {
            if(!mComputedConstantSize)
                computeConstantSize();
            return mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if(!mComputedConstantSize)
                computeConstantSize();
            return mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if(!mComputedConstantSize)
                computeConstantSize();
            return mConstantMinimumWidth;
        }

        public final Rect getConstantPadding() {
            Rect rect;
            if(mVariablePadding)
                rect = null;
            else
            if(mConstantPadding != null || mPaddingChecked) {
                rect = mConstantPadding;
            } else {
                rect = null;
                Rect rect1 = new Rect();
                int i = getChildCount();
                Drawable adrawable[] = mDrawables;
                for(int j = 0; j < i; j++) {
                    if(!adrawable[j].getPadding(rect1))
                        continue;
                    if(rect == null)
                        rect = new Rect(0, 0, 0, 0);
                    if(rect1.left > rect.left)
                        rect.left = rect1.left;
                    if(rect1.top > rect.top)
                        rect.top = rect1.top;
                    if(rect1.right > rect.right)
                        rect.right = rect1.right;
                    if(rect1.bottom > rect.bottom)
                        rect.bottom = rect1.bottom;
                }

                mPaddingChecked = true;
                mConstantPadding = rect;
            }
            return rect;
        }

        public final int getConstantWidth() {
            if(!mComputedConstantSize)
                computeConstantSize();
            return mConstantWidth;
        }

        public final int getEnterFadeDuration() {
            return mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return mExitFadeDuration;
        }

        public final int getOpacity() {
            int j;
            if(mHaveOpacity) {
                j = mOpacity;
            } else {
                int i = getChildCount();
                Drawable adrawable[] = mDrawables;
                int k;
                if(i > 0)
                    j = adrawable[0].getOpacity();
                else
                    j = -2;
                for(k = 1; k < i; k++)
                    j = Drawable.resolveOpacity(j, adrawable[k].getOpacity());

                mOpacity = j;
                mHaveOpacity = true;
            }
            return j;
        }

        public void growArray(int i, int j) {
            Drawable adrawable[] = new Drawable[j];
            System.arraycopy(mDrawables, 0, adrawable, 0, i);
            mDrawables = adrawable;
        }

        public final boolean isConstantSize() {
            return mConstantSize;
        }

        public final boolean isStateful() {
            if(!mHaveStateful) goto _L2; else goto _L1
_L1:
            boolean flag = mStateful;
_L4:
            return flag;
_L2:
            flag = false;
            int i = getChildCount();
            int j = 0;
            do {
label0:
                {
                    if(j < i) {
                        if(!mDrawables[j].isStateful())
                            break label0;
                        flag = true;
                    }
                    mStateful = flag;
                    mHaveStateful = true;
                }
                if(true)
                    continue;
                j++;
            } while(true);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public final void setConstantSize(boolean flag) {
            mConstantSize = flag;
        }

        public final void setEnterFadeDuration(int i) {
            mEnterFadeDuration = i;
        }

        public final void setExitFadeDuration(int i) {
            mExitFadeDuration = i;
        }

        public final void setVariablePadding(boolean flag) {
            mVariablePadding = flag;
        }

        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantState;
        int mChildrenChangingConfigurations;
        boolean mComputedConstantSize;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize;
        int mConstantWidth;
        boolean mDither;
        Drawable mDrawables[];
        int mEnterFadeDuration;
        int mExitFadeDuration;
        boolean mHaveOpacity;
        boolean mHaveStateful;
        int mNumChildren;
        int mOpacity;
        final DrawableContainer mOwner;
        boolean mPaddingChecked;
        boolean mStateful;
        boolean mVariablePadding;

        DrawableContainerState(DrawableContainerState drawablecontainerstate, DrawableContainer drawablecontainer, Resources resources) {
            mVariablePadding = false;
            mConstantPadding = null;
            mConstantSize = false;
            mComputedConstantSize = false;
            mHaveOpacity = false;
            mHaveStateful = false;
            mPaddingChecked = false;
            mDither = true;
            mOwner = drawablecontainer;
            if(drawablecontainerstate != null) {
                mChangingConfigurations = drawablecontainerstate.mChangingConfigurations;
                mChildrenChangingConfigurations = drawablecontainerstate.mChildrenChangingConfigurations;
                Drawable adrawable[] = drawablecontainerstate.mDrawables;
                mDrawables = new Drawable[adrawable.length];
                mNumChildren = drawablecontainerstate.mNumChildren;
                int i = mNumChildren;
                int j = 0;
                while(j < i)  {
                    if(resources != null)
                        mDrawables[j] = adrawable[j].getConstantState().newDrawable(resources);
                    else
                        mDrawables[j] = adrawable[j].getConstantState().newDrawable();
                    mDrawables[j].setCallback(drawablecontainer);
                    j++;
                }
                mCanConstantState = true;
                mCheckedConstantState = true;
                mVariablePadding = drawablecontainerstate.mVariablePadding;
                if(drawablecontainerstate.mConstantPadding != null)
                    mConstantPadding = new Rect(drawablecontainerstate.mConstantPadding);
                mConstantSize = drawablecontainerstate.mConstantSize;
                mComputedConstantSize = drawablecontainerstate.mComputedConstantSize;
                mConstantWidth = drawablecontainerstate.mConstantWidth;
                mConstantHeight = drawablecontainerstate.mConstantHeight;
                mConstantMinimumWidth = drawablecontainerstate.mConstantMinimumWidth;
                mConstantMinimumHeight = drawablecontainerstate.mConstantMinimumHeight;
                mHaveOpacity = drawablecontainerstate.mHaveOpacity;
                mOpacity = drawablecontainerstate.mOpacity;
                mHaveStateful = drawablecontainerstate.mHaveStateful;
                mStateful = drawablecontainerstate.mStateful;
                mDither = drawablecontainerstate.mDither;
                mEnterFadeDuration = drawablecontainerstate.mEnterFadeDuration;
                mExitFadeDuration = drawablecontainerstate.mExitFadeDuration;
            } else {
                mDrawables = new Drawable[10];
                mNumChildren = 0;
                mCanConstantState = false;
                mCheckedConstantState = false;
            }
        }
    }


    public DrawableContainer() {
        mAlpha = 255;
        mCurIndex = -1;
    }

    void animate(boolean flag) {
        long l = SystemClock.uptimeMillis();
        boolean flag1 = false;
        if(mCurrDrawable != null) {
            if(mEnterAnimationEnd != 0L)
                if(mEnterAnimationEnd <= l) {
                    mCurrDrawable.setAlpha(mAlpha);
                    mEnterAnimationEnd = 0L;
                } else {
                    int j = (int)(255L * (mEnterAnimationEnd - l)) / mDrawableContainerState.mEnterFadeDuration;
                    mCurrDrawable.setAlpha(((255 - j) * mAlpha) / 255);
                    flag1 = true;
                }
        } else {
            mEnterAnimationEnd = 0L;
        }
        if(mLastDrawable != null) {
            if(mExitAnimationEnd != 0L)
                if(mExitAnimationEnd <= l) {
                    mLastDrawable.setVisible(false, false);
                    mLastDrawable = null;
                    mExitAnimationEnd = 0L;
                } else {
                    int i = (int)(255L * (mExitAnimationEnd - l)) / mDrawableContainerState.mExitFadeDuration;
                    mLastDrawable.setAlpha((i * mAlpha) / 255);
                    flag1 = true;
                }
        } else {
            mExitAnimationEnd = 0L;
        }
        if(flag && flag1)
            scheduleSelf(mAnimationRunnable, 16L + l);
    }

    public void draw(Canvas canvas) {
        if(mCurrDrawable != null)
            mCurrDrawable.draw(canvas);
        if(mLastDrawable != null)
            mLastDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mDrawableContainerState.mChangingConfigurations | mDrawableContainerState.mChildrenChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        DrawableContainerState drawablecontainerstate;
        if(mDrawableContainerState.canConstantState()) {
            mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            drawablecontainerstate = mDrawableContainerState;
        } else {
            drawablecontainerstate = null;
        }
        return drawablecontainerstate;
    }

    public Drawable getCurrent() {
        return mCurrDrawable;
    }

    public int getIntrinsicHeight() {
        int i;
        if(mDrawableContainerState.isConstantSize())
            i = mDrawableContainerState.getConstantHeight();
        else
        if(mCurrDrawable != null)
            i = mCurrDrawable.getIntrinsicHeight();
        else
            i = -1;
        return i;
    }

    public int getIntrinsicWidth() {
        int i;
        if(mDrawableContainerState.isConstantSize())
            i = mDrawableContainerState.getConstantWidth();
        else
        if(mCurrDrawable != null)
            i = mCurrDrawable.getIntrinsicWidth();
        else
            i = -1;
        return i;
    }

    public Insets getLayoutInsets() {
        Insets insets;
        if(mCurrDrawable == null)
            insets = Insets.NONE;
        else
            insets = mCurrDrawable.getLayoutInsets();
        return insets;
    }

    public int getMinimumHeight() {
        int i;
        if(mDrawableContainerState.isConstantSize())
            i = mDrawableContainerState.getConstantMinimumHeight();
        else
        if(mCurrDrawable != null)
            i = mCurrDrawable.getMinimumHeight();
        else
            i = 0;
        return i;
    }

    public int getMinimumWidth() {
        int i;
        if(mDrawableContainerState.isConstantSize())
            i = mDrawableContainerState.getConstantMinimumWidth();
        else
        if(mCurrDrawable != null)
            i = mCurrDrawable.getMinimumWidth();
        else
            i = 0;
        return i;
    }

    public int getOpacity() {
        int i;
        if(mCurrDrawable == null || !mCurrDrawable.isVisible())
            i = -2;
        else
            i = mDrawableContainerState.getOpacity();
        return i;
    }

    public boolean getPadding(Rect rect) {
        Rect rect1 = mDrawableContainerState.getConstantPadding();
        boolean flag;
        if(rect1 != null) {
            rect.set(rect1);
            flag = true;
        } else
        if(mCurrDrawable != null)
            flag = mCurrDrawable.getPadding(rect);
        else
            flag = super.getPadding(rect);
        return flag;
    }

    public void invalidateDrawable(Drawable drawable) {
        if(drawable == mCurrDrawable && getCallback() != null)
            getCallback().invalidateDrawable(this);
    }

    public boolean isStateful() {
        return mDrawableContainerState.isStateful();
    }

    public void jumpToCurrentState() {
        boolean flag = false;
        if(mLastDrawable != null) {
            mLastDrawable.jumpToCurrentState();
            mLastDrawable = null;
            flag = true;
        }
        if(mCurrDrawable != null) {
            mCurrDrawable.jumpToCurrentState();
            mCurrDrawable.setAlpha(mAlpha);
        }
        if(mExitAnimationEnd != 0L) {
            mExitAnimationEnd = 0L;
            flag = true;
        }
        if(mEnterAnimationEnd != 0L) {
            mEnterAnimationEnd = 0L;
            flag = true;
        }
        if(flag)
            invalidateSelf();
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            int i = mDrawableContainerState.getChildCount();
            Drawable adrawable[] = mDrawableContainerState.getChildren();
            for(int j = 0; j < i; j++)
                if(adrawable[j] != null)
                    adrawable[j].mutate();

            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if(mLastDrawable != null)
            mLastDrawable.setBounds(rect);
        if(mCurrDrawable != null)
            mCurrDrawable.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        boolean flag;
        if(mLastDrawable != null)
            flag = mLastDrawable.setLevel(i);
        else
        if(mCurrDrawable != null)
            flag = mCurrDrawable.setLevel(i);
        else
            flag = false;
        return flag;
    }

    protected boolean onStateChange(int ai[]) {
        boolean flag;
        if(mLastDrawable != null)
            flag = mLastDrawable.setState(ai);
        else
        if(mCurrDrawable != null)
            flag = mCurrDrawable.setState(ai);
        else
            flag = false;
        return flag;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        if(drawable == mCurrDrawable && getCallback() != null)
            getCallback().scheduleDrawable(this, runnable, l);
    }

    public boolean selectDrawable(int i) {
        boolean flag = false;
        if(i != mCurIndex) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        long l = SystemClock.uptimeMillis();
        if(mDrawableContainerState.mExitFadeDuration <= 0) goto _L4; else goto _L3
_L3:
        if(mLastDrawable != null)
            mLastDrawable.setVisible(false, false);
        if(mCurrDrawable != null) {
            mLastDrawable = mCurrDrawable;
            mExitAnimationEnd = l + (long)mDrawableContainerState.mExitFadeDuration;
        } else {
            mLastDrawable = null;
            mExitAnimationEnd = 0L;
        }
_L5:
        if(i >= 0 && i < mDrawableContainerState.mNumChildren) {
            Drawable drawable = mDrawableContainerState.mDrawables[i];
            mCurrDrawable = drawable;
            mCurIndex = i;
            if(drawable != null) {
                if(mDrawableContainerState.mEnterFadeDuration > 0)
                    mEnterAnimationEnd = l + (long)mDrawableContainerState.mEnterFadeDuration;
                else
                    drawable.setAlpha(mAlpha);
                drawable.setVisible(isVisible(), true);
                drawable.setDither(mDrawableContainerState.mDither);
                drawable.setColorFilter(mColorFilter);
                drawable.setState(getState());
                drawable.setLevel(getLevel());
                drawable.setBounds(getBounds());
            }
        } else {
            mCurrDrawable = null;
            mCurIndex = -1;
        }
        if(mEnterAnimationEnd != 0L || mExitAnimationEnd != 0L) {
            if(mAnimationRunnable == null)
                mAnimationRunnable = new Runnable() {

                    public void run() {
                        animate(true);
                        invalidateSelf();
                    }

                    final DrawableContainer this$0;

             {
                this$0 = DrawableContainer.this;
                super();
            }
                };
            else
                unscheduleSelf(mAnimationRunnable);
            animate(true);
        }
        invalidateSelf();
        flag = true;
        if(true) goto _L1; else goto _L4
_L4:
        if(mCurrDrawable != null)
            mCurrDrawable.setVisible(false, false);
          goto _L5
    }

    public void setAlpha(int i) {
        if(mAlpha != i) {
            mAlpha = i;
            if(mCurrDrawable != null)
                if(mEnterAnimationEnd == 0L)
                    mCurrDrawable.setAlpha(i);
                else
                    animate(false);
        }
    }

    public void setColorFilter(ColorFilter colorfilter) {
        if(mColorFilter != colorfilter) {
            mColorFilter = colorfilter;
            if(mCurrDrawable != null)
                mCurrDrawable.setColorFilter(colorfilter);
        }
    }

    protected void setConstantState(DrawableContainerState drawablecontainerstate) {
        mDrawableContainerState = drawablecontainerstate;
    }

    public void setDither(boolean flag) {
        if(mDrawableContainerState.mDither != flag) {
            mDrawableContainerState.mDither = flag;
            if(mCurrDrawable != null)
                mCurrDrawable.setDither(mDrawableContainerState.mDither);
        }
    }

    public void setEnterFadeDuration(int i) {
        mDrawableContainerState.mEnterFadeDuration = i;
    }

    public void setExitFadeDuration(int i) {
        mDrawableContainerState.mExitFadeDuration = i;
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        boolean flag2 = super.setVisible(flag, flag1);
        if(mLastDrawable != null)
            mLastDrawable.setVisible(flag, flag1);
        if(mCurrDrawable != null)
            mCurrDrawable.setVisible(flag, flag1);
        return flag2;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if(drawable == mCurrDrawable && getCallback() != null)
            getCallback().unscheduleDrawable(this, runnable);
    }

    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainer";
    private int mAlpha;
    private Runnable mAnimationRunnable;
    private ColorFilter mColorFilter;
    private int mCurIndex;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private Drawable mLastDrawable;
    private boolean mMutated;
}
