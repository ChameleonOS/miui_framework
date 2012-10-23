// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.os.SystemClock;
import android.util.*;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable, Animatable, BitmapDrawable

public class AnimatedRotateDrawable extends Drawable
    implements Drawable.Callback, Runnable, Animatable {
    static final class AnimatedRotateState extends Drawable.ConstantState {

        public boolean canConstantState() {
            if(!mCheckedConstantState) {
                boolean flag;
                if(mDrawable.getConstantState() != null)
                    flag = true;
                else
                    flag = false;
                mCanConstantState = flag;
                mCheckedConstantState = true;
            }
            return mCanConstantState;
        }

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new AnimatedRotateDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimatedRotateDrawable(this, resources);
        }

        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        Drawable mDrawable;
        int mFrameDuration;
        int mFramesCount;
        float mPivotX;
        boolean mPivotXRel;
        float mPivotY;
        boolean mPivotYRel;

        public AnimatedRotateState(AnimatedRotateState animatedrotatestate, AnimatedRotateDrawable animatedrotatedrawable, Resources resources) {
            if(animatedrotatestate != null) {
                if(resources != null)
                    mDrawable = animatedrotatestate.mDrawable.getConstantState().newDrawable(resources);
                else
                    mDrawable = animatedrotatestate.mDrawable.getConstantState().newDrawable();
                mDrawable.setCallback(animatedrotatedrawable);
                mPivotXRel = animatedrotatestate.mPivotXRel;
                mPivotX = animatedrotatestate.mPivotX;
                mPivotYRel = animatedrotatestate.mPivotYRel;
                mPivotY = animatedrotatestate.mPivotY;
                mFramesCount = animatedrotatestate.mFramesCount;
                mFrameDuration = animatedrotatestate.mFrameDuration;
                mCheckedConstantState = true;
                mCanConstantState = true;
            }
        }
    }


    public AnimatedRotateDrawable() {
        this(null, null);
    }

    private AnimatedRotateDrawable(AnimatedRotateState animatedrotatestate, Resources resources) {
        mState = new AnimatedRotateState(animatedrotatestate, this, resources);
        init();
    }


    private void init() {
        AnimatedRotateState animatedrotatestate = mState;
        mIncrement = 360F / (float)animatedrotatestate.mFramesCount;
        Drawable drawable = animatedrotatestate.mDrawable;
        if(drawable != null) {
            drawable.setFilterBitmap(true);
            if(drawable instanceof BitmapDrawable)
                ((BitmapDrawable)drawable).setAntiAlias(true);
        }
    }

    private void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + (long)mState.mFrameDuration);
    }

    public void draw(Canvas canvas) {
        int i = canvas.save();
        AnimatedRotateState animatedrotatestate = mState;
        Drawable drawable = animatedrotatestate.mDrawable;
        Rect rect = drawable.getBounds();
        int j = rect.right - rect.left;
        int k = rect.bottom - rect.top;
        float f;
        float f1;
        if(animatedrotatestate.mPivotXRel)
            f = (float)j * animatedrotatestate.mPivotX;
        else
            f = animatedrotatestate.mPivotX;
        if(animatedrotatestate.mPivotYRel)
            f1 = (float)k * animatedrotatestate.mPivotY;
        else
            f1 = animatedrotatestate.mPivotY;
        canvas.rotate(mCurrentDegrees, f + (float)rect.left, f1 + (float)rect.top);
        drawable.draw(canvas);
        canvas.restoreToCount(i);
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mState.mChangingConfigurations | mState.mDrawable.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        AnimatedRotateState animatedrotatestate;
        if(mState.canConstantState()) {
            mState.mChangingConfigurations = getChangingConfigurations();
            animatedrotatestate = mState;
        } else {
            animatedrotatestate = null;
        }
        return animatedrotatestate;
    }

    public Drawable getDrawable() {
        return mState.mDrawable;
    }

    public int getIntrinsicHeight() {
        return mState.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return mState.mDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        return mState.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return mState.mDrawable.getPadding(rect);
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AnimatedRotateDrawable);
        super.inflateWithAttributes(resources, xmlpullparser, typedarray, 0);
        TypedValue typedvalue = typedarray.peekValue(2);
        boolean flag;
        float f;
        TypedValue typedvalue1;
        boolean flag1;
        float f1;
        int i;
        Drawable drawable;
        int j;
        if(typedvalue.type == 6)
            flag = true;
        else
            flag = false;
        if(flag)
            f = typedvalue.getFraction(1.0F, 1.0F);
        else
            f = typedvalue.getFloat();
        typedvalue1 = typedarray.peekValue(3);
        if(typedvalue1.type == 6)
            flag1 = true;
        else
            flag1 = false;
        if(flag1)
            f1 = typedvalue1.getFraction(1.0F, 1.0F);
        else
            f1 = typedvalue1.getFloat();
        setFramesCount(typedarray.getInt(5, 12));
        setFramesDuration(typedarray.getInt(4, 150));
        i = typedarray.getResourceId(1, 0);
        drawable = null;
        if(i > 0)
            drawable = resources.getDrawable(i);
        typedarray.recycle();
        j = xmlpullparser.getDepth();
        do {
            int k = xmlpullparser.next();
            if(k == 1 || k == 3 && xmlpullparser.getDepth() <= j)
                break;
            if(k == 2) {
                drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
                if(drawable == null)
                    Log.w("drawable", (new StringBuilder()).append("Bad element under <animated-rotate>: ").append(xmlpullparser.getName()).toString());
            }
        } while(true);
        if(drawable == null)
            Log.w("drawable", "No drawable specified for <animated-rotate>");
        AnimatedRotateState animatedrotatestate = mState;
        animatedrotatestate.mDrawable = drawable;
        animatedrotatestate.mPivotXRel = flag;
        animatedrotatestate.mPivotX = f;
        animatedrotatestate.mPivotYRel = flag1;
        animatedrotatestate.mPivotY = f1;
        init();
        if(drawable != null)
            drawable.setCallback(this);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.invalidateDrawable(this);
    }

    public boolean isRunning() {
        return mRunning;
    }

    public boolean isStateful() {
        return mState.mDrawable.isStateful();
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mState.mDrawable.mutate();
            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        mState.mDrawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void run() {
        mCurrentDegrees = mCurrentDegrees + mIncrement;
        if(mCurrentDegrees > 360F - mIncrement)
            mCurrentDegrees = 0.0F;
        invalidateSelf();
        nextFrame();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.scheduleDrawable(this, runnable, l);
    }

    public void setAlpha(int i) {
        mState.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter) {
        mState.mDrawable.setColorFilter(colorfilter);
    }

    public void setFramesCount(int i) {
        mState.mFramesCount = i;
        mIncrement = 360F / (float)mState.mFramesCount;
    }

    public void setFramesDuration(int i) {
        mState.mFrameDuration = i;
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        mState.mDrawable.setVisible(flag, flag1);
        boolean flag2 = super.setVisible(flag, flag1);
        if(flag) {
            if(flag2 || flag1) {
                mCurrentDegrees = 0.0F;
                nextFrame();
            }
        } else {
            unscheduleSelf(this);
        }
        return flag2;
    }

    public void start() {
        if(!mRunning) {
            mRunning = true;
            nextFrame();
        }
    }

    public void stop() {
        mRunning = false;
        unscheduleSelf(this);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.unscheduleDrawable(this, runnable);
    }

    private float mCurrentDegrees;
    private float mIncrement;
    private boolean mMutated;
    private boolean mRunning;
    private AnimatedRotateState mState;
}
