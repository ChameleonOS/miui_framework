// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.util.FloatMath;

// Referenced classes of package android.view:
//            InputEventConsistencyVerifier, ViewConfiguration, MotionEvent

public class ScaleGestureDetector {
    public static class SimpleOnScaleGestureListener
        implements OnScaleGestureListener {

        public boolean onScale(ScaleGestureDetector scalegesturedetector) {
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scalegesturedetector) {
        }

        public SimpleOnScaleGestureListener() {
        }
    }

    public static interface OnScaleGestureListener {

        public abstract boolean onScale(ScaleGestureDetector scalegesturedetector);

        public abstract boolean onScaleBegin(ScaleGestureDetector scalegesturedetector);

        public abstract void onScaleEnd(ScaleGestureDetector scalegesturedetector);
    }


    public ScaleGestureDetector(Context context, OnScaleGestureListener onscalegesturelistener) {
        InputEventConsistencyVerifier inputeventconsistencyverifier;
        if(InputEventConsistencyVerifier.isInstrumentationEnabled())
            inputeventconsistencyverifier = new InputEventConsistencyVerifier(this, 0);
        else
            inputeventconsistencyverifier = null;
        mInputEventConsistencyVerifier = inputeventconsistencyverifier;
        mContext = context;
        mListener = onscalegesturelistener;
        mSpanSlop = 2 * ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public float getCurrentSpan() {
        return mCurrSpan;
    }

    public float getCurrentSpanX() {
        return mCurrSpanX;
    }

    public float getCurrentSpanY() {
        return mCurrSpanY;
    }

    public long getEventTime() {
        return mCurrTime;
    }

    public float getFocusX() {
        return mFocusX;
    }

    public float getFocusY() {
        return mFocusY;
    }

    public float getPreviousSpan() {
        return mPrevSpan;
    }

    public float getPreviousSpanX() {
        return mPrevSpanX;
    }

    public float getPreviousSpanY() {
        return mPrevSpanY;
    }

    public float getScaleFactor() {
        float f;
        if(mPrevSpan > 0.0F)
            f = mCurrSpan / mPrevSpan;
        else
            f = 1.0F;
        return f;
    }

    public long getTimeDelta() {
        return mCurrTime - mPrevTime;
    }

    public boolean isInProgress() {
        return mInProgress;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        int i;
        boolean flag4;
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onTouchEvent(motionevent, 0);
        i = motionevent.getActionMasked();
        boolean flag;
        if(i == 1 || i == 3)
            flag = true;
        else
            flag = false;
        if(i != 0 && !flag) goto _L2; else goto _L1
_L1:
        if(mInProgress) {
            mListener.onScaleEnd(this);
            mInProgress = false;
            mInitialSpan = 0.0F;
        }
        if(!flag) goto _L2; else goto _L3
_L3:
        flag4 = true;
_L5:
        return flag4;
_L2:
        boolean flag1;
        boolean flag2;
        int j;
        float f;
        float f1;
        int k;
        int l;
        if(i == 6 || i == 5)
            flag1 = true;
        else
            flag1 = false;
        if(i == 6)
            flag2 = true;
        else
            flag2 = false;
        if(flag2)
            j = motionevent.getActionIndex();
        else
            j = -1;
        f = 0.0F;
        f1 = 0.0F;
        k = motionevent.getPointerCount();
        l = 0;
        while(l < k)  {
            if(j != l) {
                f += motionevent.getX(l);
                f1 += motionevent.getY(l);
            }
            l++;
        }
        int i1;
        float f2;
        float f3;
        float f4;
        float f5;
        int j1;
        if(flag2)
            i1 = k - 1;
        else
            i1 = k;
        f2 = f / (float)i1;
        f3 = f1 / (float)i1;
        f4 = 0.0F;
        f5 = 0.0F;
        j1 = 0;
        while(j1 < k)  {
            if(j != j1) {
                f4 += Math.abs(motionevent.getX(j1) - f2);
                f5 += Math.abs(motionevent.getY(j1) - f3);
            }
            j1++;
        }
        float f6 = f4 / (float)i1;
        float f7 = f5 / (float)i1;
        float f8 = f6 * 2.0F;
        float f9 = f7 * 2.0F;
        float f10 = FloatMath.sqrt(f8 * f8 + f9 * f9);
        boolean flag3 = mInProgress;
        mFocusX = f2;
        mFocusY = f3;
        if(mInProgress && (f10 == 0.0F || flag1)) {
            mListener.onScaleEnd(this);
            mInProgress = false;
            mInitialSpan = f10;
        }
        if(flag1) {
            mCurrSpanX = f8;
            mPrevSpanX = f8;
            mCurrSpanY = f9;
            mPrevSpanY = f9;
            mCurrSpan = f10;
            mPrevSpan = f10;
            mInitialSpan = f10;
        }
        if(!mInProgress && f10 != 0.0F && (flag3 || Math.abs(f10 - mInitialSpan) > (float)mSpanSlop)) {
            mCurrSpanX = f8;
            mPrevSpanX = f8;
            mCurrSpanY = f9;
            mPrevSpanY = f9;
            mCurrSpan = f10;
            mPrevSpan = f10;
            mInProgress = mListener.onScaleBegin(this);
        }
        if(i == 2) {
            mCurrSpanX = f8;
            mCurrSpanY = f9;
            mCurrSpan = f10;
            boolean flag5 = true;
            if(mInProgress)
                flag5 = mListener.onScale(this);
            if(flag5) {
                mPrevSpanX = mCurrSpanX;
                mPrevSpanY = mCurrSpanY;
                mPrevSpan = mCurrSpan;
            }
        }
        flag4 = true;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static final String TAG = "ScaleGestureDetector";
    private final Context mContext;
    private float mCurrSpan;
    private float mCurrSpanX;
    private float mCurrSpanY;
    private long mCurrTime;
    private float mFocusX;
    private float mFocusY;
    private boolean mInProgress;
    private float mInitialSpan;
    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    private final OnScaleGestureListener mListener;
    private float mPrevSpan;
    private float mPrevSpanX;
    private float mPrevSpanY;
    private long mPrevTime;
    private int mSpanSlop;
}
