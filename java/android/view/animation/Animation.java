// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.TypedValue;
import dalvik.system.CloseGuard;

// Referenced classes of package android.view.animation:
//            Transformation, AccelerateDecelerateInterpolator, Interpolator, AnimationUtils

public abstract class Animation
    implements Cloneable {
    public static interface AnimationListener {

        public abstract void onAnimationEnd(Animation animation);

        public abstract void onAnimationRepeat(Animation animation);

        public abstract void onAnimationStart(Animation animation);
    }

    protected static class Description {

        static Description parseValue(TypedValue typedvalue) {
            int i;
            Description description;
            i = 1;
            description = new Description();
            if(typedvalue != null) goto _L2; else goto _L1
_L1:
            description.type = 0;
            description.value = 0.0F;
_L5:
            description.type = 0;
            description.value = 0.0F;
_L3:
            return description;
_L2:
            if(typedvalue.type == 6) {
                if((0xf & typedvalue.data) == i)
                    i = 2;
                description.type = i;
                description.value = TypedValue.complexToFloat(typedvalue.data);
            } else {
                if(typedvalue.type != 4)
                    continue; /* Loop/switch isn't completed */
                description.type = 0;
                description.value = typedvalue.getFloat();
            }
              goto _L3
            if(typedvalue.type < 16 || typedvalue.type > 31) goto _L5; else goto _L4
_L4:
            description.type = 0;
            description.value = typedvalue.data;
              goto _L3
            if(true) goto _L5; else goto _L6
_L6:
        }

        public int type;
        public float value;

        protected Description() {
        }
    }


    public Animation() {
        mEnded = false;
        mStarted = false;
        mCycleFlip = false;
        mInitialized = false;
        mFillBefore = true;
        mFillAfter = false;
        mFillEnabled = false;
        mStartTime = -1L;
        mRepeatCount = 0;
        mRepeated = 0;
        mRepeatMode = 1;
        mScaleFactor = 1.0F;
        mDetachWallpaper = false;
        mMore = true;
        mOneMoreTime = true;
        mPreviousRegion = new RectF();
        mRegion = new RectF();
        mTransformation = new Transformation();
        mPreviousTransformation = new Transformation();
        guard = CloseGuard.get();
        ensureInterpolator();
    }

    public Animation(Context context, AttributeSet attributeset) {
        mEnded = false;
        mStarted = false;
        mCycleFlip = false;
        mInitialized = false;
        mFillBefore = true;
        mFillAfter = false;
        mFillEnabled = false;
        mStartTime = -1L;
        mRepeatCount = 0;
        mRepeated = 0;
        mRepeatMode = 1;
        mScaleFactor = 1.0F;
        mDetachWallpaper = false;
        mMore = true;
        mOneMoreTime = true;
        mPreviousRegion = new RectF();
        mRegion = new RectF();
        mTransformation = new Transformation();
        mPreviousTransformation = new Transformation();
        guard = CloseGuard.get();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Animation);
        setDuration(typedarray.getInt(2, 0));
        setStartOffset(typedarray.getInt(5, 0));
        setFillEnabled(typedarray.getBoolean(9, mFillEnabled));
        setFillBefore(typedarray.getBoolean(3, mFillBefore));
        setFillAfter(typedarray.getBoolean(4, mFillAfter));
        setRepeatCount(typedarray.getInt(6, mRepeatCount));
        setRepeatMode(typedarray.getInt(7, 1));
        setZAdjustment(typedarray.getInt(8, 0));
        setBackgroundColor(typedarray.getInt(0, 0));
        setDetachWallpaper(typedarray.getBoolean(10, false));
        int i = typedarray.getResourceId(1, 0);
        typedarray.recycle();
        if(i > 0)
            setInterpolator(context, i);
        ensureInterpolator();
    }

    private void fireAnimationEnd() {
        if(mListener != null)
            if(mListenerHandler == null)
                mListener.onAnimationEnd(this);
            else
                mListenerHandler.postAtFrontOfQueue(mOnEnd);
    }

    private void fireAnimationRepeat() {
        if(mListener != null)
            if(mListenerHandler == null)
                mListener.onAnimationRepeat(this);
            else
                mListenerHandler.postAtFrontOfQueue(mOnRepeat);
    }

    private void fireAnimationStart() {
        if(mListener != null)
            if(mListenerHandler == null)
                mListener.onAnimationStart(this);
            else
                mListenerHandler.postAtFrontOfQueue(mOnStart);
    }

    protected void applyTransformation(float f, Transformation transformation) {
    }

    public void cancel() {
        if(mStarted && !mEnded) {
            fireAnimationEnd();
            mEnded = true;
            guard.close();
        }
        mStartTime = 0x8000000000000000L;
        mOneMoreTime = false;
        mMore = false;
    }

    protected Animation clone() throws CloneNotSupportedException {
        Animation animation = (Animation)super.clone();
        animation.mPreviousRegion = new RectF();
        animation.mRegion = new RectF();
        animation.mTransformation = new Transformation();
        animation.mPreviousTransformation = new Transformation();
        return animation;
    }

    protected volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * (long)(1 + getRepeatCount());
    }

    public void detach() {
        if(mStarted && !mEnded) {
            mEnded = true;
            guard.close();
            fireAnimationEnd();
        }
    }

    protected void ensureInterpolator() {
        if(mInterpolator == null)
            mInterpolator = new AccelerateDecelerateInterpolator();
    }

    protected void finalize() throws Throwable {
        if(guard != null)
            guard.warnIfOpen();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return mDetachWallpaper;
    }

    public long getDuration() {
        return mDuration;
    }

    public boolean getFillAfter() {
        return mFillAfter;
    }

    public boolean getFillBefore() {
        return mFillBefore;
    }

    public Interpolator getInterpolator() {
        return mInterpolator;
    }

    public void getInvalidateRegion(int i, int j, int k, int l, RectF rectf, Transformation transformation) {
        RectF rectf1 = mRegion;
        RectF rectf2 = mPreviousRegion;
        rectf.set(i, j, k, l);
        transformation.getMatrix().mapRect(rectf);
        rectf.inset(-1F, -1F);
        rectf1.set(rectf);
        rectf.union(rectf2);
        rectf2.set(rectf1);
        Transformation transformation1 = mTransformation;
        Transformation transformation2 = mPreviousTransformation;
        transformation1.set(transformation);
        transformation.set(transformation2);
        transformation2.set(transformation1);
    }

    public int getRepeatCount() {
        return mRepeatCount;
    }

    public int getRepeatMode() {
        return mRepeatMode;
    }

    protected float getScaleFactor() {
        return mScaleFactor;
    }

    public long getStartOffset() {
        return mStartOffset;
    }

    public long getStartTime() {
        return mStartTime;
    }

    public boolean getTransformation(long l, Transformation transformation) {
        if(mStartTime == -1L)
            mStartTime = l;
        long l1 = getStartOffset();
        long l2 = mDuration;
        float f;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if(l2 != 0L)
            f = (float)(l - (l1 + mStartTime)) / (float)l2;
        else
        if(l < mStartTime)
            f = 0.0F;
        else
            f = 1.0F;
        if(f >= 1.0F)
            flag = true;
        else
            flag = false;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        mMore = flag1;
        if(!mFillEnabled)
            f = Math.max(Math.min(f, 1.0F), 0.0F);
        if((f >= 0.0F || mFillBefore) && (f <= 1.0F || mFillAfter)) {
            if(!mStarted) {
                fireAnimationStart();
                mStarted = true;
                if(USE_CLOSEGUARD)
                    guard.open("cancel or detach or getTransformation");
            }
            if(mFillEnabled)
                f = Math.max(Math.min(f, 1.0F), 0.0F);
            if(mCycleFlip)
                f = 1.0F - f;
            applyTransformation(mInterpolator.getInterpolation(f), transformation);
        }
        if(flag)
            if(mRepeatCount == mRepeated) {
                if(!mEnded) {
                    mEnded = true;
                    guard.close();
                    fireAnimationEnd();
                }
            } else {
                if(mRepeatCount > 0)
                    mRepeated = 1 + mRepeated;
                if(mRepeatMode == 2) {
                    boolean flag3;
                    if(!mCycleFlip)
                        flag3 = true;
                    else
                        flag3 = false;
                    mCycleFlip = flag3;
                }
                mStartTime = -1L;
                mMore = true;
                fireAnimationRepeat();
            }
        if(!mMore && mOneMoreTime) {
            mOneMoreTime = false;
            flag2 = true;
        } else {
            flag2 = mMore;
        }
        return flag2;
    }

    public boolean getTransformation(long l, Transformation transformation, float f) {
        mScaleFactor = f;
        return getTransformation(l, transformation);
    }

    public int getZAdjustment() {
        return mZAdjustment;
    }

    public boolean hasAlpha() {
        return false;
    }

    public boolean hasEnded() {
        return mEnded;
    }

    public boolean hasStarted() {
        return mStarted;
    }

    public void initialize(int i, int j, int k, int l) {
        reset();
        mInitialized = true;
    }

    public void initializeInvalidateRegion(int i, int j, int k, int l) {
        RectF rectf = mPreviousRegion;
        rectf.set(i, j, k, l);
        rectf.inset(-1F, -1F);
        if(mFillBefore) {
            Transformation transformation = mPreviousTransformation;
            applyTransformation(mInterpolator.getInterpolation(0.0F), transformation);
        }
    }

    public boolean isFillEnabled() {
        return mFillEnabled;
    }

    public boolean isInitialized() {
        return mInitialized;
    }

    public void reset() {
        mPreviousRegion.setEmpty();
        mPreviousTransformation.clear();
        mInitialized = false;
        mCycleFlip = false;
        mRepeated = 0;
        mMore = true;
        mOneMoreTime = true;
        mListenerHandler = null;
    }

    protected float resolveSize(int i, float f, int j, int k) {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 28
    //                   1 30
    //                   2 38;
           goto _L1 _L1 _L2 _L3
_L1:
        return f;
_L2:
        f *= j;
        continue; /* Loop/switch isn't completed */
_L3:
        f *= k;
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void restrictDuration(long l) {
        if(mStartOffset <= l) goto _L2; else goto _L1
_L1:
        mStartOffset = l;
        mDuration = 0L;
        mRepeatCount = 0;
_L4:
        return;
_L2:
        long l1 = mDuration + mStartOffset;
        if(l1 > l) {
            mDuration = l - mStartOffset;
            l1 = l;
        }
        if(mDuration <= 0L) {
            mDuration = 0L;
            mRepeatCount = 0;
        } else
        if(mRepeatCount < 0 || (long)mRepeatCount > l || l1 * (long)mRepeatCount > l) {
            mRepeatCount = -1 + (int)(l / l1);
            if(mRepeatCount < 0)
                mRepeatCount = 0;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void scaleCurrentDuration(float f) {
        mDuration = (long)(f * (float)mDuration);
        mStartOffset = (long)(f * (float)mStartOffset);
    }

    public void setAnimationListener(AnimationListener animationlistener) {
        mListener = animationlistener;
    }

    public void setBackgroundColor(int i) {
        mBackgroundColor = i;
    }

    public void setDetachWallpaper(boolean flag) {
        mDetachWallpaper = flag;
    }

    public void setDuration(long l) {
        if(l < 0L) {
            throw new IllegalArgumentException("Animation duration cannot be negative");
        } else {
            mDuration = l;
            return;
        }
    }

    public void setFillAfter(boolean flag) {
        mFillAfter = flag;
    }

    public void setFillBefore(boolean flag) {
        mFillBefore = flag;
    }

    public void setFillEnabled(boolean flag) {
        mFillEnabled = flag;
    }

    public void setInterpolator(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    public void setListenerHandler(Handler handler) {
        if(mListenerHandler == null) {
            mOnStart = new Runnable() {

                public void run() {
                    if(mListener != null)
                        mListener.onAnimationStart(Animation.this);
                }

                final Animation this$0;

             {
                this$0 = Animation.this;
                super();
            }
            };
            mOnRepeat = new Runnable() {

                public void run() {
                    if(mListener != null)
                        mListener.onAnimationRepeat(Animation.this);
                }

                final Animation this$0;

             {
                this$0 = Animation.this;
                super();
            }
            };
            mOnEnd = new Runnable() {

                public void run() {
                    if(mListener != null)
                        mListener.onAnimationEnd(Animation.this);
                }

                final Animation this$0;

             {
                this$0 = Animation.this;
                super();
            }
            };
        }
        mListenerHandler = handler;
    }

    public void setRepeatCount(int i) {
        if(i < 0)
            i = -1;
        mRepeatCount = i;
    }

    public void setRepeatMode(int i) {
        mRepeatMode = i;
    }

    public void setStartOffset(long l) {
        mStartOffset = l;
    }

    public void setStartTime(long l) {
        mStartTime = l;
        mEnded = false;
        mStarted = false;
        mCycleFlip = false;
        mRepeated = 0;
        mMore = true;
    }

    public void setZAdjustment(int i) {
        mZAdjustment = i;
    }

    public void start() {
        setStartTime(-1L);
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }

    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    private static final boolean USE_CLOSEGUARD = false;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private final CloseGuard guard;
    private int mBackgroundColor;
    boolean mCycleFlip;
    private boolean mDetachWallpaper;
    long mDuration;
    boolean mEnded;
    boolean mFillAfter;
    boolean mFillBefore;
    boolean mFillEnabled;
    boolean mInitialized;
    Interpolator mInterpolator;
    AnimationListener mListener;
    private Handler mListenerHandler;
    private boolean mMore;
    private Runnable mOnEnd;
    private Runnable mOnRepeat;
    private Runnable mOnStart;
    private boolean mOneMoreTime;
    RectF mPreviousRegion;
    Transformation mPreviousTransformation;
    RectF mRegion;
    int mRepeatCount;
    int mRepeatMode;
    int mRepeated;
    private float mScaleFactor;
    long mStartOffset;
    long mStartTime;
    boolean mStarted;
    Transformation mTransformation;
    private int mZAdjustment;

    static  {
        USE_CLOSEGUARD = SystemProperties.getBoolean("log.closeguard.Animation", false);
    }
}
