// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.os.*;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

final class WebViewInputDispatcher {
    private static final class TouchStream {

        private void updateLastEvent(MotionEvent motionevent) {
            if(mLastEvent != null)
                mLastEvent.recycle();
            MotionEvent motionevent1;
            if(motionevent != null)
                motionevent1 = MotionEvent.obtainNoHistory(motionevent);
            else
                motionevent1 = null;
            mLastEvent = motionevent1;
        }

        public MotionEvent getLastEvent() {
            return mLastEvent;
        }

        public boolean isCancelNeeded() {
            boolean flag = true;
            if(mLastEvent == null || mLastEvent.getAction() == flag)
                flag = false;
            return flag;
        }

        public MotionEvent update(MotionEvent motionevent) {
            MotionEvent motionevent1 = null;
            if(motionevent != null) goto _L2; else goto _L1
_L1:
            if(isCancelNeeded()) {
                motionevent = mLastEvent;
                if(motionevent != null) {
                    motionevent.setAction(3);
                    mLastEvent = null;
                }
            }
            motionevent1 = motionevent;
_L4:
            return motionevent1;
_L2:
            switch(motionevent.getActionMasked()) {
            case 0: // '\0'
                updateLastEvent(motionevent);
                motionevent1 = motionevent;
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 5: // '\005'
            case 6: // '\006'
                if(mLastEvent != null && mLastEvent.getAction() != 1) {
                    updateLastEvent(motionevent);
                    motionevent1 = motionevent;
                }
                break;

            case 3: // '\003'
                if(mLastEvent != null) {
                    updateLastEvent(null);
                    motionevent1 = motionevent;
                }
                break;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private MotionEvent mLastEvent;

        private TouchStream() {
        }

    }

    private static final class DispatchEventQueue {

        public DispatchEvent dequeue() {
            DispatchEvent dispatchevent = mHead;
            if(dispatchevent != null) {
                DispatchEvent dispatchevent1 = dispatchevent.mNext;
                if(dispatchevent1 == null) {
                    mHead = null;
                    mTail = null;
                } else {
                    mHead = dispatchevent1;
                    dispatchevent.mNext = null;
                }
            }
            return dispatchevent;
        }

        public DispatchEvent dequeueList() {
            DispatchEvent dispatchevent = mHead;
            if(dispatchevent != null) {
                mHead = null;
                mTail = null;
            }
            return dispatchevent;
        }

        public void enqueue(DispatchEvent dispatchevent) {
            if(mHead == null) {
                mHead = dispatchevent;
                mTail = dispatchevent;
            } else {
                mTail.mNext = dispatchevent;
                mTail = dispatchevent;
            }
        }

        public boolean isEmpty() {
            boolean flag;
            if(mHead != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public DispatchEvent mHead;
        public DispatchEvent mTail;

        private DispatchEventQueue() {
        }

    }

    private static final class DispatchEvent {

        public MotionEvent mEvent;
        public int mEventType;
        public int mFlags;
        public DispatchEvent mNext;
        public long mTimeoutTime;
        public float mWebKitScale;
        public int mWebKitXOffset;
        public int mWebKitYOffset;

        private DispatchEvent() {
        }

    }

    private final class WebKitHandler extends Handler {

        public void handleMessage(Message message) {
            switch(message.what) {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown message type: ").append(message.what).toString());

            case 1: // '\001'
                dispatchWebKitEvents(true);
                break;
            }
        }

        public static final int MSG_DISPATCH_WEBKIT_EVENTS = 1;
        final WebViewInputDispatcher this$0;

        public WebKitHandler(Looper looper) {
            this$0 = WebViewInputDispatcher.this;
            super(looper);
        }
    }

    private final class UiHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 6: default 44
        //                       1 74
        //                       2 83
        //                       3 93
        //                       4 103
        //                       5 113
        //                       6 124;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            throw new IllegalStateException((new StringBuilder()).append("Unknown message type: ").append(message.what).toString());
_L2:
            dispatchUiEvents(true);
_L9:
            return;
_L3:
            handleWebKitTimeout();
            continue; /* Loop/switch isn't completed */
_L4:
            postLongPress();
            continue; /* Loop/switch isn't completed */
_L5:
            postClick();
            continue; /* Loop/switch isn't completed */
_L6:
            postShowTapHighlight(true);
            continue; /* Loop/switch isn't completed */
_L7:
            postShowTapHighlight(false);
            if(true) goto _L9; else goto _L8
_L8:
        }

        public static final int MSG_CLICK = 4;
        public static final int MSG_DISPATCH_UI_EVENTS = 1;
        public static final int MSG_HIDE_TAP_HIGHLIGHT = 6;
        public static final int MSG_LONG_PRESS = 3;
        public static final int MSG_SHOW_TAP_HIGHLIGHT = 5;
        public static final int MSG_WEBKIT_TIMEOUT = 2;
        final WebViewInputDispatcher this$0;

        public UiHandler(Looper looper) {
            this$0 = WebViewInputDispatcher.this;
            super(looper);
        }
    }

    public static interface WebKitCallbacks {

        public abstract boolean dispatchWebKitEvent(WebViewInputDispatcher webviewinputdispatcher, MotionEvent motionevent, int i, int j);

        public abstract Looper getWebKitLooper();
    }

    public static interface UiCallbacks {

        public abstract void clearPreviousHitTest();

        public abstract void dispatchUiEvent(MotionEvent motionevent, int i, int j);

        public abstract Context getContext();

        public abstract Looper getUiLooper();

        public abstract boolean shouldInterceptTouchEvent(MotionEvent motionevent);

        public abstract void showTapHighlight(boolean flag);
    }


    public WebViewInputDispatcher(UiCallbacks uicallbacks, WebKitCallbacks webkitcallbacks) {
        mUiCallbacks = uicallbacks;
        mUiHandler = new UiHandler(uicallbacks.getUiLooper());
        mWebKitCallbacks = webkitcallbacks;
        mWebKitHandler = new WebKitHandler(webkitcallbacks.getWebKitLooper());
        ViewConfiguration viewconfiguration = ViewConfiguration.get(mUiCallbacks.getContext());
        mDoubleTapSlopSquared = viewconfiguration.getScaledDoubleTapSlop();
        mDoubleTapSlopSquared = mDoubleTapSlopSquared * mDoubleTapSlopSquared;
        mTouchSlopSquared = viewconfiguration.getScaledTouchSlop();
        mTouchSlopSquared = mTouchSlopSquared * mTouchSlopSquared;
    }

    private boolean batchEventLocked(DispatchEvent dispatchevent, DispatchEvent dispatchevent1) {
        boolean flag;
        if(dispatchevent1 != null && dispatchevent1.mEvent != null && dispatchevent.mEvent != null && dispatchevent.mEventType == dispatchevent1.mEventType && dispatchevent.mFlags == dispatchevent1.mFlags && dispatchevent.mWebKitXOffset == dispatchevent1.mWebKitXOffset && dispatchevent.mWebKitYOffset == dispatchevent1.mWebKitYOffset && dispatchevent.mWebKitScale == dispatchevent1.mWebKitScale)
            flag = dispatchevent1.mEvent.addBatch(dispatchevent.mEvent);
        else
            flag = false;
        return flag;
    }

    private void checkForDoubleTapOnDownLocked(MotionEvent motionevent) {
        mIsDoubleTapCandidate = false;
        if(mPostClickScheduled) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = (int)mInitialDownX - (int)motionevent.getX();
        int j = (int)mInitialDownY - (int)motionevent.getY();
        if((float)(i * i + j * j) < mDoubleTapSlopSquared) {
            unscheduleClickLocked();
            mIsDoubleTapCandidate = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void checkForSlopLocked(MotionEvent motionevent) {
        if(mIsTapCandidate) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = (int)mInitialDownX - (int)motionevent.getX();
        int j = (int)mInitialDownY - (int)motionevent.getY();
        if((float)(i * i + j * j) > mTouchSlopSquared) {
            unscheduleLongPressLocked();
            mIsTapCandidate = false;
            hideTapCandidateLocked();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private DispatchEvent copyDispatchEventLocked(DispatchEvent dispatchevent) {
        DispatchEvent dispatchevent1 = obtainUninitializedDispatchEventLocked();
        if(dispatchevent.mEvent != null)
            dispatchevent1.mEvent = dispatchevent.mEvent.copy();
        dispatchevent1.mEventType = dispatchevent.mEventType;
        dispatchevent1.mFlags = dispatchevent.mFlags;
        dispatchevent1.mTimeoutTime = dispatchevent.mTimeoutTime;
        dispatchevent1.mWebKitXOffset = dispatchevent.mWebKitXOffset;
        dispatchevent1.mWebKitYOffset = dispatchevent.mWebKitYOffset;
        dispatchevent1.mWebKitScale = dispatchevent.mWebKitScale;
        dispatchevent1.mNext = dispatchevent.mNext;
        return dispatchevent1;
    }

    private void dispatchUiEvent(MotionEvent motionevent, int i, int j) {
        mUiCallbacks.dispatchUiEvent(motionevent, i, j);
    }

    private void dispatchUiEvents(boolean flag) {
        do {
            MotionEvent motionevent;
            int i;
            int j;
            do
                synchronized(mLock) {
                    DispatchEvent dispatchevent = mUiDispatchEventQueue.dequeue();
                    if(dispatchevent == null) {
                        if(mUiDispatchScheduled) {
                            mUiDispatchScheduled = false;
                            if(!flag)
                                mUiHandler.removeMessages(1);
                        }
                        return;
                    }
                    motionevent = dispatchevent.mEvent;
                    if(motionevent != null && (8 & dispatchevent.mFlags) != 0) {
                        motionevent.scale(1.0F / dispatchevent.mWebKitScale);
                        motionevent.offsetLocation(-dispatchevent.mWebKitXOffset, -dispatchevent.mWebKitYOffset);
                        dispatchevent.mFlags = -9 & dispatchevent.mFlags;
                    }
                    i = dispatchevent.mEventType;
                    if(i == 0)
                        motionevent = mUiTouchStream.update(motionevent);
                    j = dispatchevent.mFlags;
                    if(motionevent == dispatchevent.mEvent)
                        dispatchevent.mEvent = null;
                    recycleDispatchEventLocked(dispatchevent);
                    if(i == 4)
                        scheduleHideTapHighlightLocked();
                }
            while(motionevent == null);
            dispatchUiEvent(motionevent, i, j);
            motionevent.recycle();
        } while(true);
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean dispatchWebKitEvent(MotionEvent motionevent, int i, int j) {
        return mWebKitCallbacks.dispatchWebKitEvent(this, motionevent, i, j);
    }

    private void dispatchWebKitEvents(boolean flag) {
_L1:
        DispatchEvent dispatchevent;
        boolean flag1;
        int k;
        MotionEvent motionevent;
        int i;
        int j;
        synchronized(mLock) {
            dispatchevent = mWebKitDispatchEventQueue.mHead;
            if(dispatchevent == null) {
                if(mWebKitDispatchScheduled) {
                    mWebKitDispatchScheduled = false;
                    if(!flag)
                        mWebKitHandler.removeMessages(1);
                }
                return;
            }
            motionevent = dispatchevent.mEvent;
            if(motionevent != null) {
                motionevent.offsetLocation(dispatchevent.mWebKitXOffset, dispatchevent.mWebKitYOffset);
                motionevent.scale(dispatchevent.mWebKitScale);
                dispatchevent.mFlags = 8 | dispatchevent.mFlags;
            }
            i = dispatchevent.mEventType;
            if(i == 0)
                motionevent = mWebKitTouchStream.update(motionevent);
            dispatchevent.mFlags = 2 | dispatchevent.mFlags;
            j = dispatchevent.mFlags;
        }
        Object obj1;
        Exception exception1;
        if(motionevent == null)
            flag1 = false;
        else
            flag1 = dispatchWebKitEvent(motionevent, i, j);
        obj1 = mLock;
        obj1;
        JVM INSTR monitorenter ;
        k = dispatchevent.mFlags;
        dispatchevent.mFlags = k & -3;
        boolean flag2;
        if(motionevent != dispatchevent.mEvent)
            flag2 = true;
        else
            flag2 = false;
        if((k & 4) == 0)
            break MISSING_BLOCK_LABEL_269;
        recycleDispatchEventLocked(dispatchevent);
_L2:
        if(motionevent != null && flag2)
            motionevent.recycle();
        if(i == 4)
            scheduleHideTapHighlightLocked();
          goto _L1
        exception1;
        throw exception1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if(!$assertionsDisabled && mWebKitDispatchEventQueue.mHead != dispatchevent)
            throw new AssertionError();
        mWebKitDispatchEventQueue.dequeue();
        updateWebKitTimeoutLocked();
        if((k & 1) != 0)
            recycleDispatchEventLocked(dispatchevent);
        else
        if(flag1) {
            if(dispatchevent.mEventType == 0) {
                enqueueUiCancelTouchEventIfNeededLocked();
                unscheduleLongPressLocked();
            }
        } else {
            enqueueUiEventUnbatchedLocked(dispatchevent);
        }
          goto _L2
    }

    private void drainStaleWebKitEventsLocked() {
        DispatchEvent dispatchevent;
        DispatchEvent dispatchevent1;
        for(dispatchevent = mWebKitDispatchEventQueue.mHead; dispatchevent != null && dispatchevent.mNext != null && isMoveEventLocked(dispatchevent) && isMoveEventLocked(dispatchevent.mNext); dispatchevent = dispatchevent1) {
            dispatchevent1 = dispatchevent.mNext;
            skipWebKitEventLocked(dispatchevent);
        }

        mWebKitDispatchEventQueue.mHead = dispatchevent;
    }

    private void enqueueDoubleTapLocked(MotionEvent motionevent) {
        enqueueEventLocked(obtainDispatchEventLocked(MotionEvent.obtainNoHistory(motionevent), 5, 0, mPostLastWebKitXOffset, mPostLastWebKitYOffset, mPostLastWebKitScale));
    }

    private void enqueueEventLocked(DispatchEvent dispatchevent) {
        if(!shouldSkipWebKit(dispatchevent))
            enqueueWebKitEventLocked(dispatchevent);
        else
            enqueueUiEventLocked(dispatchevent);
    }

    private void enqueueHitTestLocked(MotionEvent motionevent) {
        mUiCallbacks.clearPreviousHitTest();
        enqueueEventLocked(obtainDispatchEventLocked(MotionEvent.obtainNoHistory(motionevent), 6, 0, mPostLastWebKitXOffset, mPostLastWebKitYOffset, mPostLastWebKitScale));
    }

    private void enqueueUiCancelTouchEventIfNeededLocked() {
        if(mUiTouchStream.isCancelNeeded() || !mUiDispatchEventQueue.isEmpty())
            enqueueUiEventUnbatchedLocked(obtainDispatchEventLocked(null, 0, 1, 0, 0, 1.0F));
    }

    private void enqueueUiEventLocked(DispatchEvent dispatchevent) {
        if(batchEventLocked(dispatchevent, mUiDispatchEventQueue.mTail))
            recycleDispatchEventLocked(dispatchevent);
        else
            enqueueUiEventUnbatchedLocked(dispatchevent);
    }

    private void enqueueUiEventUnbatchedLocked(DispatchEvent dispatchevent) {
        mUiDispatchEventQueue.enqueue(dispatchevent);
        scheduleUiDispatchLocked();
    }

    private void enqueueWebKitCancelTouchEventIfNeededLocked() {
        if(mWebKitTouchStream.isCancelNeeded() || !mWebKitDispatchEventQueue.isEmpty()) {
            enqueueWebKitEventUnbatchedLocked(obtainDispatchEventLocked(null, 0, 1, 0, 0, 1.0F));
            mPostDoNotSendTouchEventsToWebKitUntilNextGesture = true;
        }
    }

    private void enqueueWebKitEventLocked(DispatchEvent dispatchevent) {
        if(batchEventLocked(dispatchevent, mWebKitDispatchEventQueue.mTail))
            recycleDispatchEventLocked(dispatchevent);
        else
            enqueueWebKitEventUnbatchedLocked(dispatchevent);
    }

    private void enqueueWebKitEventUnbatchedLocked(DispatchEvent dispatchevent) {
        mWebKitDispatchEventQueue.enqueue(dispatchevent);
        scheduleWebKitDispatchLocked();
        updateWebKitTimeoutLocked();
    }

    private void handleWebKitTimeout() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mWebKitTimeoutScheduled) {
            mWebKitTimeoutScheduled = false;
            DispatchEvent dispatchevent = mWebKitDispatchEventQueue.dequeueList();
            if((2 & dispatchevent.mFlags) != 0) {
                dispatchevent.mFlags = 4 | dispatchevent.mFlags;
                DispatchEvent dispatchevent1;
                if((1 & dispatchevent.mFlags) != 0) {
                    dispatchevent = dispatchevent.mNext;
                } else {
                    dispatchevent = copyDispatchEventLocked(dispatchevent);
                    dispatchevent.mFlags = -3 & dispatchevent.mFlags;
                }
            }
            for(; dispatchevent != null; dispatchevent = dispatchevent1) {
                dispatchevent1 = dispatchevent.mNext;
                skipWebKitEventLocked(dispatchevent);
            }

            break MISSING_BLOCK_LABEL_111;
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
        enqueueWebKitCancelTouchEventIfNeededLocked();
        obj;
        JVM INSTR monitorexit ;
_L1:
    }

    private void hideTapCandidateLocked() {
        unscheduleHideTapHighlightLocked();
        unscheduleShowTapHighlightLocked();
        mUiCallbacks.showTapHighlight(false);
    }

    private boolean isClickCandidateLocked(MotionEvent motionevent) {
        boolean flag = true;
        if(motionevent != null && motionevent.getActionMasked() == flag && mIsTapCandidate) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(motionevent.getEventTime() - motionevent.getDownTime() >= (long)LONG_PRESS_TIMEOUT)
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean isMoveEventLocked(DispatchEvent dispatchevent) {
        boolean flag;
        if(dispatchevent.mEvent != null && dispatchevent.mEvent.getActionMasked() == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private DispatchEvent obtainDispatchEventLocked(MotionEvent motionevent, int i, int j, int k, int l, float f) {
        DispatchEvent dispatchevent = obtainUninitializedDispatchEventLocked();
        dispatchevent.mEvent = motionevent;
        dispatchevent.mEventType = i;
        dispatchevent.mFlags = j;
        dispatchevent.mTimeoutTime = 200L + SystemClock.uptimeMillis();
        dispatchevent.mWebKitXOffset = k;
        dispatchevent.mWebKitYOffset = l;
        dispatchevent.mWebKitScale = f;
        return dispatchevent;
    }

    private DispatchEvent obtainUninitializedDispatchEventLocked() {
        DispatchEvent dispatchevent = mDispatchEventPool;
        if(dispatchevent != null) {
            mDispatchEventPoolSize = -1 + mDispatchEventPoolSize;
            mDispatchEventPool = dispatchevent.mNext;
            dispatchevent.mNext = null;
        } else {
            dispatchevent = new DispatchEvent();
        }
        return dispatchevent;
    }

    private void postClick() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mPostClickScheduled) goto _L2; else goto _L1
_L2:
        MotionEvent motionevent;
        mPostClickScheduled = false;
        motionevent = mPostTouchStream.getLastEvent();
        if(motionevent != null && motionevent.getAction() == 1) goto _L3; else goto _L1
        Exception exception;
        exception;
        throw exception;
_L3:
        showTapCandidateLocked();
        enqueueEventLocked(obtainDispatchEventLocked(MotionEvent.obtainNoHistory(motionevent), 4, 0, mPostLastWebKitXOffset, mPostLastWebKitYOffset, mPostLastWebKitScale));
        obj;
        JVM INSTR monitorexit ;
_L1:
    }

    private void postLongPress() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mPostLongPressScheduled) goto _L2; else goto _L1
_L2:
        MotionEvent motionevent;
        mPostLongPressScheduled = false;
        motionevent = mPostTouchStream.getLastEvent();
        if(motionevent != null) goto _L3; else goto _L1
        Exception exception;
        exception;
        throw exception;
_L3:
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 92
    //                   0 97
    //                   1 92
    //                   2 97
    //                   3 92
    //                   4 92
    //                   5 97
    //                   6 97;
           goto _L4 _L5 _L4 _L5 _L4 _L4 _L5 _L5
_L4:
        obj;
        JVM INSTR monitorexit ;
          goto _L1
_L5:
        MotionEvent motionevent1 = MotionEvent.obtainNoHistory(motionevent);
        motionevent1.setAction(2);
        enqueueEventLocked(obtainDispatchEventLocked(motionevent1, 3, 0, mPostLastWebKitXOffset, mPostLastWebKitYOffset, mPostLastWebKitScale));
        obj;
        JVM INSTR monitorexit ;
_L1:
    }

    private void postShowTapHighlight(boolean flag) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(!flag) goto _L2; else goto _L1
_L1:
        if(mPostShowTapHighlightScheduled) goto _L4; else goto _L3
_L4:
        mPostShowTapHighlightScheduled = false;
_L5:
        mUiCallbacks.showTapHighlight(flag);
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L2:
        if(mPostHideTapHighlightScheduled)
            break MISSING_BLOCK_LABEL_60;
        obj;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        mPostHideTapHighlightScheduled = false;
        if(true) goto _L5; else goto _L3
_L3:
    }

    private void recycleDispatchEventLocked(DispatchEvent dispatchevent) {
        if(dispatchevent.mEvent != null) {
            dispatchevent.mEvent.recycle();
            dispatchevent.mEvent = null;
        }
        if(mDispatchEventPoolSize < 10) {
            mDispatchEventPoolSize = 1 + mDispatchEventPoolSize;
            dispatchevent.mNext = mDispatchEventPool;
            mDispatchEventPool = dispatchevent;
        }
    }

    private void scheduleClickLocked() {
        unscheduleClickLocked();
        mPostClickScheduled = true;
        mUiHandler.sendEmptyMessageDelayed(4, DOUBLE_TAP_TIMEOUT);
    }

    private void scheduleHideTapHighlightLocked() {
        unscheduleHideTapHighlightLocked();
        mPostHideTapHighlightScheduled = true;
        mUiHandler.sendEmptyMessageDelayed(6, PRESSED_STATE_DURATION);
    }

    private void scheduleLongPressLocked() {
        unscheduleLongPressLocked();
        mPostLongPressScheduled = true;
        mUiHandler.sendEmptyMessageDelayed(3, LONG_PRESS_TIMEOUT);
    }

    private void scheduleShowTapHighlightLocked() {
        unscheduleShowTapHighlightLocked();
        mPostShowTapHighlightScheduled = true;
        mUiHandler.sendEmptyMessageDelayed(5, TAP_TIMEOUT);
    }

    private void scheduleUiDispatchLocked() {
        if(!mUiDispatchScheduled) {
            mUiHandler.sendEmptyMessage(1);
            mUiDispatchScheduled = true;
        }
    }

    private void scheduleWebKitDispatchLocked() {
        if(!mWebKitDispatchScheduled) {
            mWebKitHandler.sendEmptyMessage(1);
            mWebKitDispatchScheduled = true;
        }
    }

    private boolean shouldSkipWebKit(DispatchEvent dispatchevent) {
        boolean flag = false;
        dispatchevent.mEventType;
        JVM INSTR tableswitch 0 6: default 48
    //                   0 52
    //                   1 50
    //                   2 50
    //                   3 48
    //                   4 50
    //                   5 48
    //                   6 50;
           goto _L1 _L2 _L3 _L3 _L1 _L3 _L1 _L3
_L1:
        flag = true;
_L3:
        return flag;
_L2:
        if(mIsTapCandidate && dispatchevent.mEvent != null && dispatchevent.mEvent.getActionMasked() == 2)
            flag = true;
        else
        if(!mPostSendTouchEventsToWebKit || mPostDoNotSendTouchEventsToWebKitUntilNextGesture)
            flag = true;
        if(true) goto _L3; else goto _L4
_L4:
    }

    private void showTapCandidateLocked() {
        unscheduleHideTapHighlightLocked();
        unscheduleShowTapHighlightLocked();
        mUiCallbacks.showTapHighlight(true);
    }

    private void skipWebKitEventLocked(DispatchEvent dispatchevent) {
        dispatchevent.mNext = null;
        if((1 & dispatchevent.mFlags) != 0) {
            recycleDispatchEventLocked(dispatchevent);
        } else {
            dispatchevent.mFlags = 4 | dispatchevent.mFlags;
            enqueueUiEventUnbatchedLocked(dispatchevent);
        }
    }

    private void unscheduleClickLocked() {
        if(mPostClickScheduled) {
            mPostClickScheduled = false;
            mUiHandler.removeMessages(4);
        }
    }

    private void unscheduleHideTapHighlightLocked() {
        if(mPostHideTapHighlightScheduled) {
            mPostHideTapHighlightScheduled = false;
            mUiHandler.removeMessages(6);
        }
    }

    private void unscheduleLongPressLocked() {
        if(mPostLongPressScheduled) {
            mPostLongPressScheduled = false;
            mUiHandler.removeMessages(3);
        }
    }

    private void unscheduleShowTapHighlightLocked() {
        if(mPostShowTapHighlightScheduled) {
            mPostShowTapHighlightScheduled = false;
            mUiHandler.removeMessages(5);
        }
    }

    private void updateStateTrackersLocked(DispatchEvent dispatchevent, MotionEvent motionevent) {
        int i;
        mPostLastWebKitXOffset = dispatchevent.mWebKitXOffset;
        mPostLastWebKitYOffset = dispatchevent.mWebKitYOffset;
        mPostLastWebKitScale = dispatchevent.mWebKitScale;
        if(motionevent != null)
            i = motionevent.getAction();
        else
            i = 3;
        if(dispatchevent.mEventType == 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(i == 3 || motionevent.getPointerCount() > 1) {
            unscheduleLongPressLocked();
            unscheduleClickLocked();
            hideTapCandidateLocked();
            mIsDoubleTapCandidate = false;
            mIsTapCandidate = false;
            hideTapCandidateLocked();
        } else
        if(i == 0) {
            checkForDoubleTapOnDownLocked(motionevent);
            scheduleLongPressLocked();
            mIsTapCandidate = true;
            mInitialDownX = motionevent.getX();
            mInitialDownY = motionevent.getY();
            enqueueHitTestLocked(motionevent);
            if(mIsDoubleTapCandidate)
                hideTapCandidateLocked();
            else
                scheduleShowTapHighlightLocked();
        } else
        if(i == 1) {
            unscheduleLongPressLocked();
            if(isClickCandidateLocked(motionevent)) {
                if(mIsDoubleTapCandidate) {
                    hideTapCandidateLocked();
                    enqueueDoubleTapLocked(motionevent);
                } else {
                    scheduleClickLocked();
                }
            } else {
                hideTapCandidateLocked();
            }
        } else
        if(i == 2)
            checkForSlopLocked(motionevent);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void updateWebKitTimeoutLocked() {
        DispatchEvent dispatchevent = mWebKitDispatchEventQueue.mHead;
        if(dispatchevent == null || !mWebKitTimeoutScheduled || mWebKitTimeoutTime != dispatchevent.mTimeoutTime) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mWebKitTimeoutScheduled) {
            mUiHandler.removeMessages(2);
            mWebKitTimeoutScheduled = false;
        }
        if(dispatchevent != null) {
            mUiHandler.sendEmptyMessageAtTime(2, dispatchevent.mTimeoutTime);
            mWebKitTimeoutScheduled = true;
            mWebKitTimeoutTime = dispatchevent.mTimeoutTime;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void dispatchUiEvents() {
        dispatchUiEvents(false);
    }

    public void dispatchWebKitEvents() {
        dispatchWebKitEvents(false);
    }

    public boolean postPointerEvent(MotionEvent motionevent, int i, int j, float f) {
        boolean flag;
        int k;
        flag = false;
        if(motionevent == null)
            throw new IllegalArgumentException("event cannot be null");
        k = motionevent.getActionMasked();
        k;
        JVM INSTR tableswitch 0 10: default 84
    //                   0 87
    //                   1 87
    //                   2 87
    //                   3 87
    //                   4 84
    //                   5 87
    //                   6 87
    //                   7 154
    //                   8 148
    //                   9 154
    //                   10 154;
           goto _L1 _L2 _L2 _L2 _L2 _L1 _L2 _L2 _L3 _L4 _L3 _L3
_L1:
        return flag;
_L2:
        byte byte0 = 0;
_L9:
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        MotionEvent motionevent1 = motionevent;
        if(byte0 != 0) goto _L6; else goto _L5
_L5:
        motionevent1 = mPostTouchStream.update(motionevent);
        if(motionevent1 != null) goto _L8; else goto _L7
_L7:
        unscheduleLongPressLocked();
        unscheduleClickLocked();
        hideTapCandidateLocked();
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L4:
        byte0 = 2;
          goto _L9
_L3:
        byte0 = 1;
          goto _L9
_L8:
        if(k != 0) goto _L6; else goto _L10
_L10:
        DispatchEvent dispatchevent;
        if(mPostSendTouchEventsToWebKit)
            if(mUiCallbacks.shouldInterceptTouchEvent(motionevent1))
                mPostDoNotSendTouchEventsToWebKitUntilNextGesture = true;
            else
            if(mPostDoNotSendTouchEventsToWebKitUntilNextGesture)
                mPostDoNotSendTouchEventsToWebKitUntilNextGesture = false;
_L6:
        if(motionevent1 == motionevent)
            motionevent1 = motionevent.copy();
        dispatchevent = obtainDispatchEventLocked(motionevent1, byte0, 0, i, j, f);
        updateStateTrackersLocked(dispatchevent, motionevent);
        enqueueEventLocked(dispatchevent);
        obj;
        JVM INSTR monitorexit ;
        flag = true;
          goto _L1
    }

    public void setWebKitWantsTouchEvents(boolean flag) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mPostSendTouchEventsToWebKit != flag) {
            if(!flag)
                enqueueWebKitCancelTouchEventIfNeededLocked();
            mPostSendTouchEventsToWebKit = flag;
        }
        return;
    }

    public void skipWebkitForRemainingTouchStream() {
        handleWebKitTimeout();
    }

    static final boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final int DOUBLE_TAP_TIMEOUT = 0;
    private static final boolean ENABLE_EVENT_BATCHING = true;
    public static final int EVENT_TYPE_CLICK = 4;
    public static final int EVENT_TYPE_DOUBLE_TAP = 5;
    public static final int EVENT_TYPE_HIT_TEST = 6;
    public static final int EVENT_TYPE_HOVER = 1;
    public static final int EVENT_TYPE_LONG_PRESS = 3;
    public static final int EVENT_TYPE_SCROLL = 2;
    public static final int EVENT_TYPE_TOUCH = 0;
    public static final int FLAG_PRIVATE = 1;
    public static final int FLAG_WEBKIT_IN_PROGRESS = 2;
    public static final int FLAG_WEBKIT_TIMEOUT = 4;
    public static final int FLAG_WEBKIT_TRANSFORMED_EVENT = 8;
    private static final int LONG_PRESS_TIMEOUT = 0;
    private static final int MAX_DISPATCH_EVENT_POOL_SIZE = 10;
    private static final int PRESSED_STATE_DURATION = 0;
    private static final String TAG = "WebViewInputDispatcher";
    private static final int TAP_TIMEOUT = 0;
    private static final long WEBKIT_TIMEOUT_MILLIS = 200L;
    private DispatchEvent mDispatchEventPool;
    private int mDispatchEventPoolSize;
    private float mDoubleTapSlopSquared;
    private float mInitialDownX;
    private float mInitialDownY;
    private boolean mIsDoubleTapCandidate;
    private boolean mIsTapCandidate;
    private final Object mLock = new Object();
    private boolean mPostClickScheduled;
    private boolean mPostDoNotSendTouchEventsToWebKitUntilNextGesture;
    private boolean mPostHideTapHighlightScheduled;
    private float mPostLastWebKitScale;
    private int mPostLastWebKitXOffset;
    private int mPostLastWebKitYOffset;
    private boolean mPostLongPressScheduled;
    private boolean mPostSendTouchEventsToWebKit;
    private boolean mPostShowTapHighlightScheduled;
    private final TouchStream mPostTouchStream = new TouchStream();
    private float mTouchSlopSquared;
    private final UiCallbacks mUiCallbacks;
    private final DispatchEventQueue mUiDispatchEventQueue = new DispatchEventQueue();
    private boolean mUiDispatchScheduled;
    private final UiHandler mUiHandler;
    private final TouchStream mUiTouchStream = new TouchStream();
    private final WebKitCallbacks mWebKitCallbacks;
    private final DispatchEventQueue mWebKitDispatchEventQueue = new DispatchEventQueue();
    private boolean mWebKitDispatchScheduled;
    private final WebKitHandler mWebKitHandler;
    private boolean mWebKitTimeoutScheduled;
    private long mWebKitTimeoutTime;
    private final TouchStream mWebKitTouchStream = new TouchStream();

    static  {
        boolean flag;
        if(!android/webkit/WebViewInputDispatcher.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
        TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        LONG_PRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout() + TAP_TIMEOUT;
        DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        PRESSED_STATE_DURATION = ViewConfiguration.getPressedStateDuration();
    }






}
