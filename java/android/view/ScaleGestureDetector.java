// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;

// Referenced classes of package android.view:
//            InputEventConsistencyVerifier, MotionEvent

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
    }

    private int findNewActiveIndex(MotionEvent motionevent, int i, int j) {
        int k;
        int l;
        int i1;
        k = motionevent.getPointerCount();
        l = motionevent.findPointerIndex(i);
        i1 = 0;
_L3:
        if(i1 >= k)
            break MISSING_BLOCK_LABEL_45;
        if(i1 == j || i1 == l) goto _L2; else goto _L1
_L1:
        return i1;
_L2:
        i1++;
          goto _L3
        i1 = -1;
          goto _L1
    }

    private void reset() {
        if(mPrevEvent != null) {
            mPrevEvent.recycle();
            mPrevEvent = null;
        }
        if(mCurrEvent != null) {
            mCurrEvent.recycle();
            mCurrEvent = null;
        }
        mGestureInProgress = false;
        mActiveId0 = -1;
        mActiveId1 = -1;
        mInvalidGesture = false;
    }

    private void setContext(MotionEvent motionevent) {
        if(mCurrEvent != null)
            mCurrEvent.recycle();
        mCurrEvent = MotionEvent.obtain(motionevent);
        mCurrLen = -1F;
        mPrevLen = -1F;
        mScaleFactor = -1F;
        MotionEvent motionevent1 = mPrevEvent;
        int i = motionevent1.findPointerIndex(mActiveId0);
        int j = motionevent1.findPointerIndex(mActiveId1);
        int k = motionevent.findPointerIndex(mActiveId0);
        int l = motionevent.findPointerIndex(mActiveId1);
        if(i < 0 || j < 0 || k < 0 || l < 0) {
            mInvalidGesture = true;
            Log.e("ScaleGestureDetector", "Invalid MotionEvent stream detected.", new Throwable());
            if(mGestureInProgress)
                mListener.onScaleEnd(this);
        } else {
            float f = motionevent1.getX(i);
            float f1 = motionevent1.getY(i);
            float f2 = motionevent1.getX(j);
            float f3 = motionevent1.getY(j);
            float f4 = motionevent.getX(k);
            float f5 = motionevent.getY(k);
            float f6 = motionevent.getX(l);
            float f7 = motionevent.getY(l);
            float f8 = f2 - f;
            float f9 = f3 - f1;
            float f10 = f6 - f4;
            float f11 = f7 - f5;
            mPrevFingerDiffX = f8;
            mPrevFingerDiffY = f9;
            mCurrFingerDiffX = f10;
            mCurrFingerDiffY = f11;
            mFocusX = f4 + 0.5F * f10;
            mFocusY = f5 + 0.5F * f11;
            mTimeDelta = motionevent.getEventTime() - motionevent1.getEventTime();
            mCurrPressure = motionevent.getPressure(k) + motionevent.getPressure(l);
            mPrevPressure = motionevent1.getPressure(i) + motionevent1.getPressure(j);
        }
    }

    public float getCurrentSpan() {
        if(mCurrLen == -1F) {
            float f = mCurrFingerDiffX;
            float f1 = mCurrFingerDiffY;
            mCurrLen = FloatMath.sqrt(f * f + f1 * f1);
        }
        return mCurrLen;
    }

    public float getCurrentSpanX() {
        return mCurrFingerDiffX;
    }

    public float getCurrentSpanY() {
        return mCurrFingerDiffY;
    }

    public long getEventTime() {
        return mCurrEvent.getEventTime();
    }

    public float getFocusX() {
        return mFocusX;
    }

    public float getFocusY() {
        return mFocusY;
    }

    public float getPreviousSpan() {
        if(mPrevLen == -1F) {
            float f = mPrevFingerDiffX;
            float f1 = mPrevFingerDiffY;
            mPrevLen = FloatMath.sqrt(f * f + f1 * f1);
        }
        return mPrevLen;
    }

    public float getPreviousSpanX() {
        return mPrevFingerDiffX;
    }

    public float getPreviousSpanY() {
        return mPrevFingerDiffY;
    }

    public float getScaleFactor() {
        if(mScaleFactor == -1F)
            mScaleFactor = getCurrentSpan() / getPreviousSpan();
        return mScaleFactor;
    }

    public long getTimeDelta() {
        return mTimeDelta;
    }

    public boolean isInProgress() {
        return mGestureInProgress;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        int i;
        boolean flag;
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onTouchEvent(motionevent, 0);
        i = motionevent.getActionMasked();
        if(i == 0)
            reset();
        flag = true;
        if(!mInvalidGesture) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        if(!flag && mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onUnhandledEvent(motionevent, 0);
        return flag;
_L2:
        if(!mGestureInProgress) {
            switch(i) {
            case 0: // '\0'
                mActiveId0 = motionevent.getPointerId(0);
                mActive0MostRecent = true;
                break;

            case 1: // '\001'
                reset();
                break;

            case 5: // '\005'
                if(mPrevEvent != null)
                    mPrevEvent.recycle();
                mPrevEvent = MotionEvent.obtain(motionevent);
                mTimeDelta = 0L;
                int k2 = motionevent.getActionIndex();
                int l2 = motionevent.findPointerIndex(mActiveId0);
                mActiveId1 = motionevent.getPointerId(k2);
                if(l2 < 0 || l2 == k2)
                    mActiveId0 = motionevent.getPointerId(findNewActiveIndex(motionevent, mActiveId1, -1));
                mActive0MostRecent = false;
                setContext(motionevent);
                mGestureInProgress = mListener.onScaleBegin(this);
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        switch(i) {
        case 4: // '\004'
        default:
            break;

        case 1: // '\001'
            reset();
            break;

        case 5: // '\005'
            mListener.onScaleEnd(this);
            int i2 = mActiveId0;
            int j2 = mActiveId1;
            reset();
            mPrevEvent = MotionEvent.obtain(motionevent);
            if(!mActive0MostRecent)
                i2 = j2;
            mActiveId0 = i2;
            mActiveId1 = motionevent.getPointerId(motionevent.getActionIndex());
            mActive0MostRecent = false;
            if(motionevent.findPointerIndex(mActiveId0) < 0 || mActiveId0 == mActiveId1) {
                Log.e("ScaleGestureDetector", (new StringBuilder()).append("Got ").append(MotionEvent.actionToString(i)).append(" with bad state while a gesture was in progress. ").append("Did you forget to pass an event to ").append("ScaleGestureDetector#onTouchEvent?").toString());
                mActiveId0 = motionevent.getPointerId(findNewActiveIndex(motionevent, mActiveId1, -1));
            }
            setContext(motionevent);
            mGestureInProgress = mListener.onScaleBegin(this);
            break;

        case 6: // '\006'
            int j = motionevent.getPointerCount();
            int k = motionevent.getActionIndex();
            int l = motionevent.getPointerId(k);
            boolean flag1 = false;
            int i1;
            if(j > 2) {
                if(l == mActiveId0) {
                    int l1 = findNewActiveIndex(motionevent, mActiveId1, k);
                    int j1;
                    if(l1 >= 0) {
                        mListener.onScaleEnd(this);
                        mActiveId0 = motionevent.getPointerId(l1);
                        mActive0MostRecent = true;
                        mPrevEvent = MotionEvent.obtain(motionevent);
                        setContext(motionevent);
                        mGestureInProgress = mListener.onScaleBegin(this);
                    } else {
                        flag1 = true;
                    }
                } else
                if(l == mActiveId1) {
                    int k1 = findNewActiveIndex(motionevent, mActiveId0, k);
                    if(k1 >= 0) {
                        mListener.onScaleEnd(this);
                        mActiveId1 = motionevent.getPointerId(k1);
                        mActive0MostRecent = false;
                        mPrevEvent = MotionEvent.obtain(motionevent);
                        setContext(motionevent);
                        mGestureInProgress = mListener.onScaleBegin(this);
                    } else {
                        flag1 = true;
                    }
                }
                mPrevEvent.recycle();
                mPrevEvent = MotionEvent.obtain(motionevent);
                setContext(motionevent);
            } else {
                flag1 = true;
            }
            if(!flag1)
                break;
            setContext(motionevent);
            if(l == mActiveId0)
                i1 = mActiveId1;
            else
                i1 = mActiveId0;
            j1 = motionevent.findPointerIndex(i1);
            mFocusX = motionevent.getX(j1);
            mFocusY = motionevent.getY(j1);
            mListener.onScaleEnd(this);
            reset();
            mActiveId0 = i1;
            mActive0MostRecent = true;
            break;

        case 3: // '\003'
            mListener.onScaleEnd(this);
            reset();
            break;

        case 2: // '\002'
            setContext(motionevent);
            if(mCurrPressure / mPrevPressure > 0.67F && mListener.onScale(this)) {
                mPrevEvent.recycle();
                mPrevEvent = MotionEvent.obtain(motionevent);
            }
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final float PRESSURE_THRESHOLD = 0.67F;
    private static final String TAG = "ScaleGestureDetector";
    private boolean mActive0MostRecent;
    private int mActiveId0;
    private int mActiveId1;
    private final Context mContext;
    private MotionEvent mCurrEvent;
    private float mCurrFingerDiffX;
    private float mCurrFingerDiffY;
    private float mCurrLen;
    private float mCurrPressure;
    private float mFocusX;
    private float mFocusY;
    private boolean mGestureInProgress;
    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    private boolean mInvalidGesture;
    private final OnScaleGestureListener mListener;
    private MotionEvent mPrevEvent;
    private float mPrevFingerDiffX;
    private float mPrevFingerDiffY;
    private float mPrevLen;
    private float mPrevPressure;
    private float mScaleFactor;
    private long mTimeDelta;
}
