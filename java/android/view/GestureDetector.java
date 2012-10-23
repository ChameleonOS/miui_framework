// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package android.view:
//            ViewConfiguration, InputEventConsistencyVerifier, VelocityTracker, MotionEvent

public class GestureDetector {
    private class GestureHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 3: default 32
        //                       1 59
        //                       2 79
        //                       3 89;
               goto _L1 _L2 _L3 _L4
_L1:
            throw new RuntimeException((new StringBuilder()).append("Unknown message ").append(message).toString());
_L2:
            mListener.onShowPress(mCurrentDownEvent);
_L6:
            return;
_L3:
            dispatchLongPress();
            continue; /* Loop/switch isn't completed */
_L4:
            if(mDoubleTapListener != null && !mStillDown)
                mDoubleTapListener.onSingleTapConfirmed(mCurrentDownEvent);
            if(true) goto _L6; else goto _L5
_L5:
        }

        final GestureDetector this$0;

        GestureHandler() {
            this$0 = GestureDetector.this;
            super();
        }

        GestureHandler(Handler handler) {
            this$0 = GestureDetector.this;
            super(handler.getLooper());
        }
    }

    public static class SimpleOnGestureListener
        implements OnGestureListener, OnDoubleTapListener {

        public boolean onDoubleTap(MotionEvent motionevent) {
            return false;
        }

        public boolean onDoubleTapEvent(MotionEvent motionevent) {
            return false;
        }

        public boolean onDown(MotionEvent motionevent) {
            return false;
        }

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1) {
            return false;
        }

        public void onLongPress(MotionEvent motionevent) {
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1) {
            return false;
        }

        public void onShowPress(MotionEvent motionevent) {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionevent) {
            return false;
        }

        public boolean onSingleTapUp(MotionEvent motionevent) {
            return false;
        }

        public SimpleOnGestureListener() {
        }
    }

    public static interface OnDoubleTapListener {

        public abstract boolean onDoubleTap(MotionEvent motionevent);

        public abstract boolean onDoubleTapEvent(MotionEvent motionevent);

        public abstract boolean onSingleTapConfirmed(MotionEvent motionevent);
    }

    public static interface OnGestureListener {

        public abstract boolean onDown(MotionEvent motionevent);

        public abstract boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1);

        public abstract void onLongPress(MotionEvent motionevent);

        public abstract boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1);

        public abstract void onShowPress(MotionEvent motionevent);

        public abstract boolean onSingleTapUp(MotionEvent motionevent);
    }


    public GestureDetector(Context context, OnGestureListener ongesturelistener) {
        this(context, ongesturelistener, null);
    }

    public GestureDetector(Context context, OnGestureListener ongesturelistener, Handler handler) {
        InputEventConsistencyVerifier inputeventconsistencyverifier;
        if(InputEventConsistencyVerifier.isInstrumentationEnabled())
            inputeventconsistencyverifier = new InputEventConsistencyVerifier(this, 0);
        else
            inputeventconsistencyverifier = null;
        mInputEventConsistencyVerifier = inputeventconsistencyverifier;
        if(handler != null)
            mHandler = new GestureHandler(handler);
        else
            mHandler = new GestureHandler();
        mListener = ongesturelistener;
        if(ongesturelistener instanceof OnDoubleTapListener)
            setOnDoubleTapListener((OnDoubleTapListener)ongesturelistener);
        init(context);
    }

    public GestureDetector(Context context, OnGestureListener ongesturelistener, Handler handler, boolean flag) {
        this(context, ongesturelistener, handler);
    }

    public GestureDetector(OnGestureListener ongesturelistener) {
        this(null, ongesturelistener, null);
    }

    public GestureDetector(OnGestureListener ongesturelistener, Handler handler) {
        this(null, ongesturelistener, handler);
    }

    private void cancel() {
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        mHandler.removeMessages(3);
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mIsDoubleTapping = false;
        mStillDown = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        if(mInLongPress)
            mInLongPress = false;
    }

    private void cancelTaps() {
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        mHandler.removeMessages(3);
        mIsDoubleTapping = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        if(mInLongPress)
            mInLongPress = false;
    }

    private void dispatchLongPress() {
        mHandler.removeMessages(3);
        mInLongPress = true;
        mListener.onLongPress(mCurrentDownEvent);
    }

    private void init(Context context) {
        if(mListener == null)
            throw new NullPointerException("OnGestureListener must not be null");
        mIsLongpressEnabled = true;
        int i;
        int j;
        int k;
        if(context == null) {
            i = ViewConfiguration.getTouchSlop();
            j = i;
            k = ViewConfiguration.getDoubleTapSlop();
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
            i = viewconfiguration.getScaledTouchSlop();
            j = viewconfiguration.getScaledDoubleTapTouchSlop();
            k = viewconfiguration.getScaledDoubleTapSlop();
            mMinimumFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        }
        mTouchSlopSquare = i * i;
        mDoubleTapTouchSlopSquare = j * j;
        mDoubleTapSlopSquare = k * k;
    }

    private boolean isConsideredDoubleTap(MotionEvent motionevent, MotionEvent motionevent1, MotionEvent motionevent2) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_3;
        while(true)  {
            do
                return flag;
            while(!mAlwaysInBiggerTapRegion || motionevent2.getEventTime() - motionevent1.getEventTime() > (long)DOUBLE_TAP_TIMEOUT);
            int i = (int)motionevent.getX() - (int)motionevent2.getX();
            int j = (int)motionevent.getY() - (int)motionevent2.getY();
            if(i * i + j * j < mDoubleTapSlopSquare)
                flag = true;
        }
    }

    public boolean isLongpressEnabled() {
        return mIsLongpressEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        float f2;
        float f3;
        boolean flag1;
        if(mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onTouchEvent(motionevent, 0);
        int i = motionevent.getAction();
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(motionevent);
        boolean flag;
        int j;
        float f;
        float f1;
        int k;
        int l;
        if((i & 0xff) == 6)
            flag = true;
        else
            flag = false;
        if(flag)
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
        if(flag)
            i1 = k - 1;
        else
            i1 = k;
        f2 = f / (float)i1;
        f3 = f1 / (float)i1;
        flag1 = false;
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 212
    //                   0 301
    //                   1 792
    //                   2 561
    //                   3 1027
    //                   4 212
    //                   5 243
    //                   6 274;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        if(!flag1 && mInputEventConsistencyVerifier != null)
            mInputEventConsistencyVerifier.onUnhandledEvent(motionevent, 0);
        return flag1;
_L6:
        mLastFocusX = f2;
        mDownFocusX = f2;
        mLastFocusY = f3;
        mDownFocusY = f3;
        cancelTaps();
        continue; /* Loop/switch isn't completed */
_L7:
        mLastFocusX = f2;
        mDownFocusX = f2;
        mLastFocusY = f3;
        mDownFocusY = f3;
        continue; /* Loop/switch isn't completed */
_L2:
        if(mDoubleTapListener != null) {
            boolean flag2 = mHandler.hasMessages(3);
            if(flag2)
                mHandler.removeMessages(3);
            if(mCurrentDownEvent != null && mPreviousUpEvent != null && flag2 && isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, motionevent)) {
                mIsDoubleTapping = true;
                flag1 = false | mDoubleTapListener.onDoubleTap(mCurrentDownEvent) | mDoubleTapListener.onDoubleTapEvent(motionevent);
            } else {
                mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
            }
        }
        mLastFocusX = f2;
        mDownFocusX = f2;
        mLastFocusY = f3;
        mDownFocusY = f3;
        if(mCurrentDownEvent != null)
            mCurrentDownEvent.recycle();
        mCurrentDownEvent = MotionEvent.obtain(motionevent);
        mAlwaysInTapRegion = true;
        mAlwaysInBiggerTapRegion = true;
        mStillDown = true;
        mInLongPress = false;
        if(mIsLongpressEnabled) {
            mHandler.removeMessages(2);
            mHandler.sendEmptyMessageAtTime(2, mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT + (long)LONGPRESS_TIMEOUT);
        }
        mHandler.sendEmptyMessageAtTime(1, mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT);
        flag1 |= mListener.onDown(motionevent);
        continue; /* Loop/switch isn't completed */
_L4:
        if(!mInLongPress) {
            float f6 = mLastFocusX - f2;
            float f7 = mLastFocusY - f3;
            if(mIsDoubleTapping)
                flag1 = false | mDoubleTapListener.onDoubleTapEvent(motionevent);
            else
            if(mAlwaysInTapRegion) {
                int k1 = (int)(f2 - mDownFocusX);
                int l1 = (int)(f3 - mDownFocusY);
                int i2 = k1 * k1 + l1 * l1;
                if(i2 > mTouchSlopSquare) {
                    flag1 = mListener.onScroll(mCurrentDownEvent, motionevent, f6, f7);
                    mLastFocusX = f2;
                    mLastFocusY = f3;
                    mAlwaysInTapRegion = false;
                    mHandler.removeMessages(3);
                    mHandler.removeMessages(1);
                    mHandler.removeMessages(2);
                }
                if(i2 > mDoubleTapTouchSlopSquare)
                    mAlwaysInBiggerTapRegion = false;
            } else
            if(Math.abs(f6) >= 1.0F || Math.abs(f7) >= 1.0F) {
                flag1 = mListener.onScroll(mCurrentDownEvent, motionevent, f6, f7);
                mLastFocusX = f2;
                mLastFocusY = f3;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        MotionEvent motionevent1;
        mStillDown = false;
        motionevent1 = MotionEvent.obtain(motionevent);
        if(!mIsDoubleTapping) goto _L9; else goto _L8
_L8:
        flag1 = false | mDoubleTapListener.onDoubleTapEvent(motionevent);
_L10:
        if(mPreviousUpEvent != null)
            mPreviousUpEvent.recycle();
        mPreviousUpEvent = motionevent1;
        if(mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
        mIsDoubleTapping = false;
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        continue; /* Loop/switch isn't completed */
_L9:
        if(mInLongPress) {
            mHandler.removeMessages(3);
            mInLongPress = false;
        } else
        if(mAlwaysInTapRegion) {
            flag1 = mListener.onSingleTapUp(motionevent);
        } else {
            VelocityTracker velocitytracker = mVelocityTracker;
            int j1 = motionevent.getPointerId(0);
            velocitytracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
            float f4 = velocitytracker.getYVelocity(j1);
            float f5 = velocitytracker.getXVelocity(j1);
            if(Math.abs(f4) > (float)mMinimumFlingVelocity || Math.abs(f5) > (float)mMinimumFlingVelocity)
                flag1 = mListener.onFling(mCurrentDownEvent, motionevent, f5, f4);
        }
        if(true) goto _L10; else goto _L5
_L5:
        cancel();
        if(true) goto _L1; else goto _L11
_L11:
    }

    public void setIsLongpressEnabled(boolean flag) {
        mIsLongpressEnabled = flag;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener ondoubletaplistener) {
        mDoubleTapListener = ondoubletaplistener;
    }

    private static final int DOUBLE_TAP_TIMEOUT = 0;
    private static final int LONGPRESS_TIMEOUT = 0;
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    private MotionEvent mCurrentDownEvent;
    private OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private int mDoubleTapTouchSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mInLongPress;
    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    private final OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    private boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;

    static  {
        LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    }





}
