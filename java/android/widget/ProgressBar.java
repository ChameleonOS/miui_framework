// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.*;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.*;
import android.view.View;
import android.view.accessibility.*;
import android.view.animation.*;
import java.util.ArrayList;

public class ProgressBar extends View {
    private class AccessibilityEventSender
        implements Runnable {

        public void run() {
            sendAccessibilityEvent(4);
        }

        final ProgressBar this$0;

        private AccessibilityEventSender() {
            this$0 = ProgressBar.this;
            super();
        }

    }

    static class SavedState extends android.view.View.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(progress);
            parcel.writeInt(secondaryProgress);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        int progress;
        int secondaryProgress;


        private SavedState(Parcel parcel) {
            super(parcel);
            progress = parcel.readInt();
            secondaryProgress = parcel.readInt();
        }


        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private static class RefreshData
        implements Poolable {

        public static RefreshData obtain(int i, int j, boolean flag) {
            RefreshData refreshdata = (RefreshData)sPool.acquire();
            refreshdata.id = i;
            refreshdata.progress = j;
            refreshdata.fromUser = flag;
            return refreshdata;
        }

        public RefreshData getNextPoolable() {
            return mNext;
        }

        public volatile Object getNextPoolable() {
            return getNextPoolable();
        }

        public boolean isPooled() {
            return mIsPooled;
        }

        public void recycle() {
            sPool.release(this);
        }

        public void setNextPoolable(RefreshData refreshdata) {
            mNext = refreshdata;
        }

        public volatile void setNextPoolable(Object obj) {
            setNextPoolable((RefreshData)obj);
        }

        public void setPooled(boolean flag) {
            mIsPooled = flag;
        }

        private static final int POOL_MAX = 24;
        private static final Pool sPool = Pools.synchronizedPool(Pools.finitePool(new PoolableManager() {

            public volatile Poolable newInstance() {
                return newInstance();
            }

            public RefreshData newInstance() {
                return new RefreshData();
            }

            public volatile void onAcquired(Poolable poolable) {
                onAcquired((RefreshData)poolable);
            }

            public void onAcquired(RefreshData refreshdata) {
            }

            public volatile void onReleased(Poolable poolable) {
                onReleased((RefreshData)poolable);
            }

            public void onReleased(RefreshData refreshdata) {
            }

        }, 24));
        public boolean fromUser;
        public int id;
        private boolean mIsPooled;
        private RefreshData mNext;
        public int progress;


        private RefreshData() {
        }

    }

    private class RefreshProgressRunnable
        implements Runnable {

        public void run() {
            ProgressBar progressbar = ProgressBar.this;
            progressbar;
            JVM INSTR monitorenter ;
            int i = mRefreshData.size();
            for(int j = 0; j < i; j++) {
                RefreshData refreshdata = (RefreshData)mRefreshData.get(j);
                doRefreshProgress(refreshdata.id, refreshdata.progress, refreshdata.fromUser, true);
                refreshdata.recycle();
            }

            mRefreshData.clear();
            mRefreshIsPosted = false;
            return;
        }

        final ProgressBar this$0;

        private RefreshProgressRunnable() {
            this$0 = ProgressBar.this;
            super();
        }

    }


    public ProgressBar(Context context) {
        this(context, null);
    }

    public ProgressBar(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010077);
    }

    public ProgressBar(Context context, AttributeSet attributeset, int i) {
        this(context, attributeset, i, 0);
    }

    public ProgressBar(Context context, AttributeSet attributeset, int i, int j) {
        boolean flag = false;
        super(context, attributeset, i);
        mRefreshData = new ArrayList();
        mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ProgressBar, i, j);
        mNoInvalidate = true;
        Drawable drawable = typedarray.getDrawable(8);
        if(drawable != null)
            setProgressDrawable(tileify(drawable, false));
        mDuration = typedarray.getInt(9, mDuration);
        mMinWidth = typedarray.getDimensionPixelSize(11, mMinWidth);
        mMaxWidth = typedarray.getDimensionPixelSize(0, mMaxWidth);
        mMinHeight = typedarray.getDimensionPixelSize(12, mMinHeight);
        mMaxHeight = typedarray.getDimensionPixelSize(1, mMaxHeight);
        mBehavior = typedarray.getInt(10, mBehavior);
        int k = typedarray.getResourceId(13, 0x10a000b);
        if(k > 0)
            setInterpolator(context, k);
        setMax(typedarray.getInt(2, mMax));
        setProgress(typedarray.getInt(3, mProgress));
        setSecondaryProgress(typedarray.getInt(4, mSecondaryProgress));
        Drawable drawable1 = typedarray.getDrawable(7);
        if(drawable1 != null)
            setIndeterminateDrawable(tileifyIndeterminate(drawable1));
        mOnlyIndeterminate = typedarray.getBoolean(6, mOnlyIndeterminate);
        mNoInvalidate = false;
        if(mOnlyIndeterminate || typedarray.getBoolean(5, mIndeterminate))
            flag = true;
        setIndeterminate(flag);
        typedarray.recycle();
    }

    /**
     * @deprecated Method doRefreshProgress is deprecated
     */

    private void doRefreshProgress(int i, int j, boolean flag, boolean flag1) {
        this;
        JVM INSTR monitorenter ;
        if(mMax <= 0) goto _L2; else goto _L1
_L1:
        float f = (float)j / (float)mMax;
_L6:
        Drawable drawable = mCurrentDrawable;
        if(drawable == null) goto _L4; else goto _L3
_L3:
        Drawable drawable1;
        drawable1 = null;
        if(drawable instanceof LayerDrawable)
            drawable1 = ((LayerDrawable)drawable).findDrawableByLayerId(i);
          goto _L5
_L8:
        int k;
        drawable1.setLevel(k);
_L7:
        if(flag1 && i == 0x102000d)
            onProgressRefresh(f, flag);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f = 0.0F;
          goto _L6
_L9:
        drawable1 = drawable;
        break; /* Loop/switch isn't completed */
_L4:
        invalidate();
          goto _L7
        Exception exception;
        exception;
        throw exception;
_L5:
        k = (int)(10000F * f);
        if(drawable1 == null) goto _L9; else goto _L8
    }

    private void initProgressBar() {
        mMax = 100;
        mProgress = 0;
        mSecondaryProgress = 0;
        mIndeterminate = false;
        mOnlyIndeterminate = false;
        mDuration = 4000;
        mBehavior = 1;
        mMinWidth = 24;
        mMaxWidth = 48;
        mMinHeight = 24;
        mMaxHeight = 48;
    }

    /**
     * @deprecated Method refreshProgress is deprecated
     */

    private void refreshProgress(int i, int j, boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mUiThreadId != Thread.currentThread().getId()) goto _L2; else goto _L1
_L1:
        doRefreshProgress(i, j, flag, true);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(mRefreshProgressRunnable == null)
            mRefreshProgressRunnable = new RefreshProgressRunnable();
        RefreshData refreshdata = RefreshData.obtain(i, j, flag);
        mRefreshData.add(refreshdata);
        if(mAttached && !mRefreshIsPosted) {
            post(mRefreshProgressRunnable);
            mRefreshIsPosted = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void scheduleAccessibilityEventSender() {
        if(mAccessibilityEventSender == null)
            mAccessibilityEventSender = new AccessibilityEventSender();
        else
            removeCallbacks(mAccessibilityEventSender);
        postDelayed(mAccessibilityEventSender, 200L);
    }

    private Drawable tileify(Drawable drawable, boolean flag) {
        Object obj;
        if(drawable instanceof LayerDrawable) {
            LayerDrawable layerdrawable = (LayerDrawable)drawable;
            int k = layerdrawable.getNumberOfLayers();
            Drawable adrawable[] = new Drawable[k];
            int l = 0;
            while(l < k)  {
                int j1 = layerdrawable.getId(l);
                Drawable drawable1 = layerdrawable.getDrawable(l);
                boolean flag1;
                if(j1 == 0x102000d || j1 == 0x102000f)
                    flag1 = true;
                else
                    flag1 = false;
                adrawable[l] = tileify(drawable1, flag1);
                l++;
            }
            obj = new LayerDrawable(adrawable);
            for(int i1 = 0; i1 < k; i1++)
                ((LayerDrawable) (obj)).setId(i1, layerdrawable.getId(i1));

        } else
        if(drawable instanceof StateListDrawable) {
            StateListDrawable statelistdrawable = (StateListDrawable)drawable;
            StateListDrawable statelistdrawable1 = new StateListDrawable();
            int i = statelistdrawable.getStateCount();
            for(int j = 0; j < i; j++)
                statelistdrawable1.addState(statelistdrawable.getStateSet(j), tileify(statelistdrawable.getStateDrawable(j), flag));

            obj = statelistdrawable1;
        } else
        if(drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            if(mSampleTile == null)
                mSampleTile = bitmap;
            Object obj1 = new ShapeDrawable(getDrawableShape());
            BitmapShader bitmapshader = new BitmapShader(bitmap, android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.CLAMP);
            ((ShapeDrawable) (obj1)).getPaint().setShader(bitmapshader);
            if(flag)
                obj1 = new ClipDrawable(((Drawable) (obj1)), 3, 1);
            obj = obj1;
        } else {
            obj = drawable;
        }
        return ((Drawable) (obj));
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        if(drawable instanceof AnimationDrawable) {
            AnimationDrawable animationdrawable = (AnimationDrawable)drawable;
            int i = animationdrawable.getNumberOfFrames();
            AnimationDrawable animationdrawable1 = new AnimationDrawable();
            animationdrawable1.setOneShot(animationdrawable.isOneShot());
            for(int j = 0; j < i; j++) {
                Drawable drawable1 = tileify(animationdrawable.getFrame(j), true);
                drawable1.setLevel(10000);
                animationdrawable1.addFrame(drawable1, animationdrawable.getDuration(j));
            }

            animationdrawable1.setLevel(10000);
            drawable = animationdrawable1;
        }
        return drawable;
    }

    private void updateDrawableBounds(int i, int j) {
        int k = i - super.mPaddingRight - super.mPaddingLeft;
        int l = j - super.mPaddingBottom - super.mPaddingTop;
        int i1 = 0;
        int j1 = 0;
        if(mIndeterminateDrawable != null) {
            if(mOnlyIndeterminate && !(mIndeterminateDrawable instanceof AnimationDrawable)) {
                int k1 = mIndeterminateDrawable.getIntrinsicWidth();
                int l1 = mIndeterminateDrawable.getIntrinsicHeight();
                float f = (float)k1 / (float)l1;
                float f1 = (float)i / (float)j;
                if(f != f1)
                    if(f1 > f) {
                        int j2 = (int)(f * (float)j);
                        j1 = (i - j2) / 2;
                        k = j1 + j2;
                    } else {
                        int i2 = (int)((float)i * (1.0F / f));
                        i1 = (j - i2) / 2;
                        l = i1 + i2;
                    }
            }
            mIndeterminateDrawable.setBounds(j1, i1, k, l);
        }
        if(mProgressDrawable != null)
            mProgressDrawable.setBounds(0, 0, k, l);
    }

    private void updateDrawableState() {
        int ai[] = getDrawableState();
        if(mProgressDrawable != null && mProgressDrawable.isStateful())
            mProgressDrawable.setState(ai);
        if(mIndeterminateDrawable != null && mIndeterminateDrawable.isStateful())
            mIndeterminateDrawable.setState(ai);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    Drawable getCurrentDrawable() {
        return mCurrentDrawable;
    }

    Shape getDrawableShape() {
        float af[] = new float[8];
        af[0] = 5F;
        af[1] = 5F;
        af[2] = 5F;
        af[3] = 5F;
        af[4] = 5F;
        af[5] = 5F;
        af[6] = 5F;
        af[7] = 5F;
        return new RoundRectShape(af, null, null);
    }

    public Drawable getIndeterminateDrawable() {
        return mIndeterminateDrawable;
    }

    public Interpolator getInterpolator() {
        return mInterpolator;
    }

    /**
     * @deprecated Method getMax is deprecated
     */

    public int getMax() {
        this;
        JVM INSTR monitorenter ;
        int i = mMax;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getProgress is deprecated
     */

    public int getProgress() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIndeterminate;
        if(!flag) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = mProgress;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public Drawable getProgressDrawable() {
        return mProgressDrawable;
    }

    public int getResolvedLayoutDirection(Drawable drawable) {
        int i;
        if(drawable == mProgressDrawable || drawable == mIndeterminateDrawable)
            i = getResolvedLayoutDirection();
        else
            i = super.getResolvedLayoutDirection(drawable);
        return i;
    }

    /**
     * @deprecated Method getSecondaryProgress is deprecated
     */

    public int getSecondaryProgress() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIndeterminate;
        if(!flag) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = mSecondaryProgress;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method incrementProgressBy is deprecated
     */

    public final void incrementProgressBy(int i) {
        this;
        JVM INSTR monitorenter ;
        setProgress(i + mProgress);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method incrementSecondaryProgressBy is deprecated
     */

    public final void incrementSecondaryProgressBy(int i) {
        this;
        JVM INSTR monitorenter ;
        setSecondaryProgress(i + mSecondaryProgress);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void invalidateDrawable(Drawable drawable) {
        if(!mInDrawing)
            if(verifyDrawable(drawable)) {
                Rect rect = drawable.getBounds();
                int i = super.mScrollX + super.mPaddingLeft;
                int j = super.mScrollY + super.mPaddingTop;
                invalidate(i + rect.left, j + rect.top, i + rect.right, j + rect.bottom);
            } else {
                super.invalidateDrawable(drawable);
            }
    }

    /**
     * @deprecated Method isIndeterminate is deprecated
     */

    public boolean isIndeterminate() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIndeterminate;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if(mProgressDrawable != null)
            mProgressDrawable.jumpToCurrentState();
        if(mIndeterminateDrawable != null)
            mIndeterminateDrawable.jumpToCurrentState();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(mIndeterminate)
            startAnimation();
        if(mRefreshData == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        int i = mRefreshData.size();
        for(int j = 0; j < i; j++) {
            RefreshData refreshdata = (RefreshData)mRefreshData.get(j);
            doRefreshProgress(refreshdata.id, refreshdata.progress, refreshdata.fromUser, true);
            refreshdata.recycle();
        }

        mRefreshData.clear();
        this;
        JVM INSTR monitorexit ;
_L2:
        mAttached = true;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onDetachedFromWindow() {
        if(mIndeterminate)
            stopAnimation();
        if(mRefreshProgressRunnable != null)
            removeCallbacks(mRefreshProgressRunnable);
        if(mRefreshProgressRunnable != null && mRefreshIsPosted)
            removeCallbacks(mRefreshProgressRunnable);
        if(mAccessibilityEventSender != null)
            removeCallbacks(mAccessibilityEventSender);
        super.onDetachedFromWindow();
        mAttached = false;
    }

    /**
     * @deprecated Method onDraw is deprecated
     */

    protected void onDraw(Canvas canvas) {
        this;
        JVM INSTR monitorenter ;
        Drawable drawable;
        float f;
        super.onDraw(canvas);
        drawable = mCurrentDrawable;
        if(drawable == null)
            break MISSING_BLOCK_LABEL_133;
        canvas.save();
        canvas.translate(super.mPaddingLeft, super.mPaddingTop);
        long l = getDrawingTime();
        if(!mHasAnimation)
            break MISSING_BLOCK_LABEL_96;
        mAnimation.getTransformation(l, mTransformation);
        f = mTransformation.getAlpha();
        mInDrawing = true;
        drawable.setLevel((int)(10000F * f));
        mInDrawing = false;
        postInvalidateOnAnimation();
        drawable.draw(canvas);
        canvas.restore();
        if(mShouldStartAnimationDrawable && (drawable instanceof Animatable)) {
            ((Animatable)drawable).start();
            mShouldStartAnimationDrawable = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        mInDrawing = false;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ProgressBar.getName());
        accessibilityevent.setItemCount(mMax);
        accessibilityevent.setCurrentItemIndex(mProgress);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ProgressBar.getName());
    }

    /**
     * @deprecated Method onMeasure is deprecated
     */

    protected void onMeasure(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        Drawable drawable = mCurrentDrawable;
        int k = 0;
        int l = 0;
        if(drawable != null) {
            k = Math.max(mMinWidth, Math.min(mMaxWidth, drawable.getIntrinsicWidth()));
            l = Math.max(mMinHeight, Math.min(mMaxHeight, drawable.getIntrinsicHeight()));
        }
        updateDrawableState();
        int i1 = k + (super.mPaddingLeft + super.mPaddingRight);
        int j1 = l + (super.mPaddingTop + super.mPaddingBottom);
        setMeasuredDimension(resolveSizeAndState(i1, i, 0), resolveSizeAndState(j1, j, 0));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void onProgressRefresh(float f, boolean flag) {
        if(AccessibilityManager.getInstance(super.mContext).isEnabled())
            scheduleAccessibilityEventSender();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        setProgress(savedstate.progress);
        setSecondaryProgress(savedstate.secondaryProgress);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.progress = mProgress;
        savedstate.secondaryProgress = mSecondaryProgress;
        return savedstate;
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        updateDrawableBounds(i, j);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if(mIndeterminate)
            if(i == 8 || i == 4)
                stopAnimation();
            else
                startAnimation();
    }

    public void postInvalidate() {
        if(!mNoInvalidate)
            super.postInvalidate();
    }

    /**
     * @deprecated Method setIndeterminate is deprecated
     */

    public void setIndeterminate(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mOnlyIndeterminate && mIndeterminate || flag == mIndeterminate) goto _L2; else goto _L1
_L1:
        mIndeterminate = flag;
        if(!flag) goto _L4; else goto _L3
_L3:
        mCurrentDrawable = mIndeterminateDrawable;
        startAnimation();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        mCurrentDrawable = mProgressDrawable;
        stopAnimation();
        if(true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if(drawable != null)
            drawable.setCallback(this);
        mIndeterminateDrawable = drawable;
        if(mIndeterminate) {
            mCurrentDrawable = drawable;
            postInvalidate();
        }
    }

    public void setInterpolator(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    /**
     * @deprecated Method setMax is deprecated
     */

    public void setMax(int i) {
        this;
        JVM INSTR monitorenter ;
        if(i < 0)
            i = 0;
        if(i != mMax) {
            mMax = i;
            postInvalidate();
            if(mProgress > i)
                mProgress = i;
            refreshProgress(0x102000d, mProgress, false);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setProgress is deprecated
     */

    public void setProgress(int i) {
        this;
        JVM INSTR monitorenter ;
        setProgress(i, false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setProgress is deprecated
     */

    void setProgress(int i, boolean flag) {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = mIndeterminate;
        if(!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(i < 0)
            i = 0;
        if(i > mMax)
            i = mMax;
        if(i != mProgress) {
            mProgress = i;
            refreshProgress(0x102000d, mProgress, flag);
        }
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setProgressDrawable(Drawable drawable) {
        boolean flag;
        if(mProgressDrawable != null && drawable != mProgressDrawable) {
            mProgressDrawable.setCallback(null);
            flag = true;
        } else {
            flag = false;
        }
        if(drawable != null) {
            drawable.setCallback(this);
            int i = drawable.getMinimumHeight();
            if(mMaxHeight < i) {
                mMaxHeight = i;
                requestLayout();
            }
        }
        mProgressDrawable = drawable;
        if(!mIndeterminate) {
            mCurrentDrawable = drawable;
            postInvalidate();
        }
        if(flag) {
            updateDrawableBounds(getWidth(), getHeight());
            updateDrawableState();
            doRefreshProgress(0x102000d, mProgress, false, false);
            doRefreshProgress(0x102000f, mSecondaryProgress, false, false);
        }
    }

    /**
     * @deprecated Method setSecondaryProgress is deprecated
     */

    public void setSecondaryProgress(int i) {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIndeterminate;
        if(!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(i < 0)
            i = 0;
        if(i > mMax)
            i = mMax;
        if(i != mSecondaryProgress) {
            mSecondaryProgress = i;
            refreshProgress(0x102000f, mSecondaryProgress, false);
        }
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setVisibility(int i) {
        if(getVisibility() != i) {
            super.setVisibility(i);
            if(mIndeterminate)
                if(i == 8 || i == 4)
                    stopAnimation();
                else
                    startAnimation();
        }
    }

    void startAnimation() {
        if(getVisibility() == 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(!(mIndeterminateDrawable instanceof Animatable))
            break; /* Loop/switch isn't completed */
        mShouldStartAnimationDrawable = true;
        mHasAnimation = false;
_L4:
        postInvalidate();
        if(true) goto _L1; else goto _L3
_L3:
        mHasAnimation = true;
        if(mInterpolator == null)
            mInterpolator = new LinearInterpolator();
        if(mTransformation == null)
            mTransformation = new Transformation();
        else
            mTransformation.clear();
        if(mAnimation == null)
            mAnimation = new AlphaAnimation(0.0F, 1.0F);
        else
            mAnimation.reset();
        mAnimation.setRepeatMode(mBehavior);
        mAnimation.setRepeatCount(-1);
        mAnimation.setDuration(mDuration);
        mAnimation.setInterpolator(mInterpolator);
        mAnimation.setStartTime(-1L);
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    void stopAnimation() {
        mHasAnimation = false;
        if(mIndeterminateDrawable instanceof Animatable) {
            ((Animatable)mIndeterminateDrawable).stop();
            mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean flag;
        if(drawable == mProgressDrawable || drawable == mIndeterminateDrawable || super.verifyDrawable(drawable))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final int MAX_LEVEL = 10000;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private AccessibilityEventSender mAccessibilityEventSender;
    private AlphaAnimation mAnimation;
    private boolean mAttached;
    private int mBehavior;
    private Drawable mCurrentDrawable;
    private int mDuration;
    private boolean mHasAnimation;
    private boolean mInDrawing;
    private boolean mIndeterminate;
    private Drawable mIndeterminateDrawable;
    private Interpolator mInterpolator;
    private int mMax;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    private boolean mNoInvalidate;
    private boolean mOnlyIndeterminate;
    private int mProgress;
    private Drawable mProgressDrawable;
    private final ArrayList mRefreshData;
    private boolean mRefreshIsPosted;
    private RefreshProgressRunnable mRefreshProgressRunnable;
    Bitmap mSampleTile;
    private int mSecondaryProgress;
    private boolean mShouldStartAnimationDrawable;
    private Transformation mTransformation;
    private long mUiThreadId;




/*
    static boolean access$202(ProgressBar progressbar, boolean flag) {
        progressbar.mRefreshIsPosted = flag;
        return flag;
    }

*/
}
