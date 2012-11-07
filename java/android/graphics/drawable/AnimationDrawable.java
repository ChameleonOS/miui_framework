// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            DrawableContainer, Animatable, Drawable

public class AnimationDrawable extends DrawableContainer
    implements Runnable, Animatable {
    protected static final class AnimationState extends DrawableContainer.DrawableContainerState {

        public void addFrame(Drawable drawable, int i) {
            int j = super.addChild(drawable);
            mDurations[j] = i;
        }

        public void growArray(int i, int j) {
            super.growArray(i, j);
            int ai[] = new int[j];
            System.arraycopy(mDurations, 0, ai, 0, i);
            mDurations = ai;
        }

        public Drawable newDrawable() {
            return new AnimationDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimationDrawable(this, resources);
        }

        void setDuration(int i, int j) {
            mDurations[i] = j;
        }

        private int mDurations[];
        private boolean mOneShot;



/*
        static int[] access$002(AnimationState animationstate, int ai[]) {
            animationstate.mDurations = ai;
            return ai;
        }

*/



/*
        static boolean access$102(AnimationState animationstate, boolean flag) {
            animationstate.mOneShot = flag;
            return flag;
        }

*/

        AnimationState(AnimationState animationstate, AnimationDrawable animationdrawable, Resources resources) {
            super(animationstate, animationdrawable, resources);
            if(animationstate != null) {
                mDurations = animationstate.mDurations;
                mOneShot = animationstate.mOneShot;
            } else {
                mDurations = new int[getChildren().length];
                mOneShot = true;
            }
        }
    }


    public AnimationDrawable() {
        this(null, null);
    }

    private AnimationDrawable(AnimationState animationstate, Resources resources) {
        mCurFrame = -1;
        AnimationState animationstate1 = new AnimationState(animationstate, this, resources);
        mAnimationState = animationstate1;
        setConstantState(animationstate1);
        if(animationstate != null)
            setFrame(0, true, false);
    }


    private void nextFrame(boolean flag) {
        int i = 1 + mCurFrame;
        int j = mAnimationState.getChildCount();
        if(i >= j)
            i = 0;
        boolean flag1;
        if(!mAnimationState.mOneShot || i < j - 1)
            flag1 = true;
        else
            flag1 = false;
        setFrame(i, flag, flag1);
    }

    private void setFrame(int i, boolean flag, boolean flag1) {
        if(i < mAnimationState.getChildCount()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mCurFrame = i;
        selectDrawable(i);
        if(flag)
            unscheduleSelf(this);
        if(flag1) {
            mCurFrame = i;
            scheduleSelf(this, SystemClock.uptimeMillis() + (long)mAnimationState.mDurations[i]);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void addFrame(Drawable drawable, int i) {
        mAnimationState.addFrame(drawable, i);
        if(mCurFrame < 0)
            setFrame(0, true, false);
    }

    AnimationState getAnimationState() {
        return mAnimationState;
    }

    public int getDuration(int i) {
        return mAnimationState.mDurations[i];
    }

    public Drawable getFrame(int i) {
        return mAnimationState.getChildren()[i];
    }

    public int getNumberOfFrames() {
        return mAnimationState.getChildCount();
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AnimationDrawable);
        super.inflateWithAttributes(resources, xmlpullparser, typedarray, 0);
        mAnimationState.setVariablePadding(typedarray.getBoolean(1, false));
        mAnimationState.mOneShot = typedarray.getBoolean(2, false);
        typedarray.recycle();
        int i = 1 + xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j != 1) {
                int k = xmlpullparser.getDepth();
                if(k >= i || j != 3) {
                    if(j == 2 && k <= i && xmlpullparser.getName().equals("item")) {
                        TypedArray typedarray1 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.AnimationDrawableItem);
                        int l = typedarray1.getInt(0, -1);
                        if(l < 0)
                            throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <item> tag requires a 'duration' attribute").toString());
                        int i1 = typedarray1.getResourceId(1, 0);
                        typedarray1.recycle();
                        Drawable drawable;
                        if(i1 != 0) {
                            drawable = resources.getDrawable(i1);
                        } else {
                            int j1;
                            do
                                j1 = xmlpullparser.next();
                            while(j1 == 4);
                            if(j1 != 2)
                                throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <item> tag requires a 'drawable' attribute or child tag").append(" defining a drawable").toString());
                            drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
                        }
                        mAnimationState.addFrame(drawable, l);
                        if(drawable != null)
                            drawable.setCallback(this);
                    }
                    continue;
                }
            }
            setFrame(0, true, false);
            return;
        } while(true);
    }

    public boolean isOneShot() {
        return mAnimationState.mOneShot;
    }

    public boolean isRunning() {
        boolean flag;
        if(mCurFrame > -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mAnimationState.mDurations = (int[])mAnimationState.mDurations.clone();
            mMutated = true;
        }
        return this;
    }

    public void run() {
        nextFrame(false);
    }

    public void setOneShot(boolean flag) {
        mAnimationState.mOneShot = flag;
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        boolean flag2 = super.setVisible(flag, flag1);
        if(flag) {
            if(flag2 || flag1)
                setFrame(0, true, true);
        } else {
            unscheduleSelf(this);
        }
        return flag2;
    }

    public void start() {
        if(!isRunning())
            run();
    }

    public void stop() {
        if(isRunning())
            unscheduleSelf(this);
    }

    public void unscheduleSelf(Runnable runnable) {
        mCurFrame = -1;
        super.unscheduleSelf(runnable);
    }

    private AnimationState mAnimationState;
    private int mCurFrame;
    private boolean mMutated;
}
