// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.os.*;
import android.util.Log;

// Referenced classes of package android.view:
//            Display, DisplayEventReceiver

public final class Choreographer {
    private final class CallbackQueue {

        public void addCallbackLocked(long l, Object obj, Object obj1) {
            CallbackRecord callbackrecord;
            CallbackRecord callbackrecord1;
            callbackrecord = obtainCallbackLocked(l, obj, obj1);
            callbackrecord1 = mHead;
            if(callbackrecord1 != null) goto _L2; else goto _L1
_L1:
            mHead = callbackrecord;
_L7:
            return;
_L2:
            if(l < callbackrecord1.dueTime) {
                callbackrecord.next = callbackrecord1;
                mHead = callbackrecord;
                continue; /* Loop/switch isn't completed */
            }
              goto _L3
_L5:
            callbackrecord1 = callbackrecord1.next;
_L3:
            if(callbackrecord1.next == null)
                break; /* Loop/switch isn't completed */
            if(l >= callbackrecord1.next.dueTime)
                continue; /* Loop/switch isn't completed */
            callbackrecord.next = callbackrecord1.next;
            break; /* Loop/switch isn't completed */
            if(true) goto _L5; else goto _L4
_L4:
            callbackrecord1.next = callbackrecord;
            if(true) goto _L7; else goto _L6
_L6:
        }

        public CallbackRecord extractDueCallbacksLocked(long l) {
            CallbackRecord callbackrecord = mHead;
            if(callbackrecord != null && callbackrecord.dueTime <= l) goto _L2; else goto _L1
_L1:
            callbackrecord = null;
_L4:
            return callbackrecord;
_L2:
            CallbackRecord callbackrecord1 = callbackrecord;
            CallbackRecord callbackrecord2 = callbackrecord1.next;
            do {
label0:
                {
                    if(callbackrecord2 != null) {
                        if(callbackrecord2.dueTime <= l)
                            break label0;
                        callbackrecord1.next = null;
                    }
                    mHead = callbackrecord2;
                }
                if(true)
                    continue;
                callbackrecord1 = callbackrecord2;
                callbackrecord2 = callbackrecord2.next;
            } while(true);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public boolean hasDueCallbacksLocked(long l) {
            boolean flag;
            if(mHead != null && mHead.dueTime <= l)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void removeCallbacksLocked(Object obj, Object obj1) {
            CallbackRecord callbackrecord = null;
            CallbackRecord callbackrecord1 = mHead;
            while(callbackrecord1 != null)  {
                CallbackRecord callbackrecord2 = callbackrecord1.next;
                if((obj == null || callbackrecord1.action == obj) && (obj1 == null || callbackrecord1.token == obj1)) {
                    if(callbackrecord != null)
                        callbackrecord.next = callbackrecord2;
                    else
                        mHead = callbackrecord2;
                    recycleCallbackLocked(callbackrecord1);
                } else {
                    callbackrecord = callbackrecord1;
                }
                callbackrecord1 = callbackrecord2;
            }
        }

        private CallbackRecord mHead;
        final Choreographer this$0;

        private CallbackQueue() {
            this$0 = Choreographer.this;
            super();
        }

    }

    private static final class CallbackRecord {

        public void run(long l) {
            if(token == Choreographer.FRAME_CALLBACK_TOKEN)
                ((FrameCallback)action).doFrame(l);
            else
                ((Runnable)action).run();
        }

        public Object action;
        public long dueTime;
        public CallbackRecord next;
        public Object token;

        private CallbackRecord() {
        }

    }

    private final class FrameDisplayEventReceiver extends DisplayEventReceiver
        implements Runnable {

        public void onVsync(long l, int i) {
            long l1 = System.nanoTime();
            if(l > l1) {
                Log.w("Choreographer", (new StringBuilder()).append("Frame time is ").append(1E-06F * (float)(l - l1)).append(" ms in the future!  Check that graphics HAL is generating vsync ").append("timestamps using the correct timebase.").toString());
                l = l1;
            }
            Message message;
            if(mHavePendingVsync)
                Log.w("Choreographer", "Already have a pending vsync event.  There should only be one at a time.");
            else
                mHavePendingVsync = true;
            mTimestampNanos = l;
            mFrame = i;
            message = Message.obtain(mHandler, this);
            message.setAsynchronous(true);
            mHandler.sendMessageAtTime(message, l / 0xf4240L);
        }

        public void run() {
            mHavePendingVsync = false;
            doFrame(mTimestampNanos, mFrame);
        }

        private int mFrame;
        private boolean mHavePendingVsync;
        private long mTimestampNanos;
        final Choreographer this$0;

        public FrameDisplayEventReceiver(Looper looper) {
            this$0 = Choreographer.this;
            super(looper);
        }
    }

    private final class FrameHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 0 2: default 32
        //                       0 33
        //                       1 47
        //                       2 57;
               goto _L1 _L2 _L3 _L4
_L1:
            return;
_L2:
            doFrame(System.nanoTime(), 0);
            continue; /* Loop/switch isn't completed */
_L3:
            doScheduleVsync();
            continue; /* Loop/switch isn't completed */
_L4:
            doScheduleCallback(message.arg1);
            if(true) goto _L1; else goto _L5
_L5:
        }

        final Choreographer this$0;

        public FrameHandler(Looper looper) {
            this$0 = Choreographer.this;
            super(looper);
        }
    }

    public static interface FrameCallback {

        public abstract void doFrame(long l);
    }


    private Choreographer(Looper looper) {
        mLock = new Object();
        mLooper = looper;
        mHandler = new FrameHandler(looper);
        FrameDisplayEventReceiver framedisplayeventreceiver;
        if(USE_VSYNC)
            framedisplayeventreceiver = new FrameDisplayEventReceiver(looper);
        else
            framedisplayeventreceiver = null;
        mDisplayEventReceiver = framedisplayeventreceiver;
        mLastFrameTimeNanos = 0x8000000000000000L;
        mFrameIntervalNanos = (long)(1E+09F / (new Display(0, null)).getRefreshRate());
        mCallbackQueues = new CallbackQueue[3];
        for(int i = 0; i <= 2; i++)
            mCallbackQueues[i] = new CallbackQueue();

    }


    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static Choreographer getInstance() {
        return (Choreographer)sThreadInstance.get();
    }

    private boolean isRunningOnLooperThreadLocked() {
        boolean flag;
        if(Looper.myLooper() == mLooper)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private CallbackRecord obtainCallbackLocked(long l, Object obj, Object obj1) {
        CallbackRecord callbackrecord = mCallbackPool;
        if(callbackrecord == null) {
            callbackrecord = new CallbackRecord();
        } else {
            mCallbackPool = callbackrecord.next;
            callbackrecord.next = null;
        }
        callbackrecord.dueTime = l;
        callbackrecord.action = obj;
        callbackrecord.token = obj1;
        return callbackrecord;
    }

    private void postCallbackDelayedInternal(int i, Object obj, Object obj1, long l) {
        Object obj2 = mLock;
        obj2;
        JVM INSTR monitorenter ;
        long l1 = SystemClock.uptimeMillis();
        long l2 = l1 + l;
        mCallbackQueues[i].addCallbackLocked(l2, obj, obj1);
        if(l2 <= l1) {
            scheduleFrameLocked(l1);
        } else {
            Message message = mHandler.obtainMessage(2, obj);
            message.arg1 = i;
            message.setAsynchronous(true);
            mHandler.sendMessageAtTime(message, l2);
        }
        return;
    }

    private void recycleCallbackLocked(CallbackRecord callbackrecord) {
        callbackrecord.action = null;
        callbackrecord.token = null;
        callbackrecord.next = mCallbackPool;
        mCallbackPool = callbackrecord;
    }

    private void removeCallbacksInternal(int i, Object obj, Object obj1) {
        Object obj2 = mLock;
        obj2;
        JVM INSTR monitorenter ;
        mCallbackQueues[i].removeCallbacksLocked(obj, obj1);
        if(obj != null && obj1 == null)
            mHandler.removeMessages(2, obj);
        return;
    }

    private void scheduleFrameLocked(long l) {
        if(!mFrameScheduled) {
            mFrameScheduled = true;
            if(USE_VSYNC) {
                if(isRunningOnLooperThreadLocked()) {
                    scheduleVsyncLocked();
                } else {
                    Message message1 = mHandler.obtainMessage(1);
                    message1.setAsynchronous(true);
                    mHandler.sendMessageAtFrontOfQueue(message1);
                }
            } else {
                long l1 = Math.max(mLastFrameTimeNanos / 0xf4240L + sFrameDelay, l);
                Message message = mHandler.obtainMessage(0);
                message.setAsynchronous(true);
                mHandler.sendMessageAtTime(message, l1);
            }
        }
    }

    private void scheduleVsyncLocked() {
        mDisplayEventReceiver.scheduleVsync();
    }

    public static void setFrameDelay(long l) {
        sFrameDelay = l;
    }

    public static long subtractFrameDelay(long l) {
        long l1 = sFrameDelay;
        long l2;
        if(l <= l1)
            l2 = 0L;
        else
            l2 = l - l1;
        return l2;
    }

    void doCallbacks(int i, long l) {
        CallbackRecord callbackrecord;
        CallbackRecord callbackrecord1;
        synchronized(mLock) {
            long l1 = SystemClock.uptimeMillis();
            callbackrecord = mCallbackQueues[i].extractDueCallbacksLocked(l1);
            if(callbackrecord == null)
                break MISSING_BLOCK_LABEL_181;
            mCallbacksRunning = true;
        }
        callbackrecord1 = callbackrecord;
_L2:
        if(callbackrecord1 == null)
            break; /* Loop/switch isn't completed */
        callbackrecord1.run(l);
        callbackrecord1 = callbackrecord1.next;
        if(true) goto _L2; else goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Exception exception1;
        exception1;
        synchronized(mLock) {
            mCallbacksRunning = false;
            do {
                CallbackRecord callbackrecord3 = callbackrecord.next;
                recycleCallbackLocked(callbackrecord);
                callbackrecord = callbackrecord3;
            } while(callbackrecord != null);
        }
        throw exception1;
        exception2;
        obj2;
        JVM INSTR monitorexit ;
        throw exception2;
_L1:
        Object obj1 = mLock;
        obj1;
        JVM INSTR monitorenter ;
        mCallbacksRunning = false;
        do {
            CallbackRecord callbackrecord2 = callbackrecord.next;
            recycleCallbackLocked(callbackrecord);
            callbackrecord = callbackrecord2;
        } while(callbackrecord != null);
    }

    void doFrame(long l, int i) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mFrameScheduled)
            break MISSING_BLOCK_LABEL_170;
        long l1 = System.nanoTime();
        long l2 = l1 - l;
        if(l2 >= mFrameIntervalNanos) {
            long l3 = l2 / mFrameIntervalNanos;
            if(l3 >= (long)SKIPPED_FRAME_WARNING_LIMIT)
                Log.i("Choreographer", (new StringBuilder()).append("Skipped ").append(l3).append(" frames!  ").append("The application may be doing too much work on its main thread.").toString());
            l = l1 - l2 % mFrameIntervalNanos;
        }
        if(l < mLastFrameTimeNanos) {
            scheduleVsyncLocked();
            break MISSING_BLOCK_LABEL_170;
        }
        break MISSING_BLOCK_LABEL_139;
        Exception exception;
        exception;
        throw exception;
        mFrameScheduled = false;
        mLastFrameTimeNanos = l;
        obj;
        JVM INSTR monitorexit ;
        doCallbacks(0, l);
        doCallbacks(1, l);
        doCallbacks(2, l);
    }

    void doScheduleCallback(int i) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mFrameScheduled) {
            long l = SystemClock.uptimeMillis();
            if(mCallbackQueues[i].hasDueCallbacksLocked(l))
                scheduleFrameLocked(l);
        }
        return;
    }

    void doScheduleVsync() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mFrameScheduled)
            scheduleVsyncLocked();
        return;
    }

    public long getFrameTime() {
        return getFrameTimeNanos() / 0xf4240L;
    }

    public long getFrameTimeNanos() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mCallbacksRunning)
            throw new IllegalStateException("This method must only be called as part of a callback while a frame is in progress.");
        break MISSING_BLOCK_LABEL_30;
        Exception exception;
        exception;
        throw exception;
        if(!USE_FRAME_TIME) goto _L2; else goto _L1
_L1:
        long l1 = mLastFrameTimeNanos;
_L3:
        obj;
        JVM INSTR monitorexit ;
        return l1;
_L2:
        long l = System.nanoTime();
        l1 = l;
          goto _L3
    }

    public void postCallback(int i, Runnable runnable, Object obj) {
        postCallbackDelayed(i, runnable, obj, 0L);
    }

    public void postCallbackDelayed(int i, Runnable runnable, Object obj, long l) {
        if(runnable == null)
            throw new IllegalArgumentException("action must not be null");
        if(i < 0 || i > 2) {
            throw new IllegalArgumentException("callbackType is invalid");
        } else {
            postCallbackDelayedInternal(i, runnable, obj, l);
            return;
        }
    }

    public void postFrameCallback(FrameCallback framecallback) {
        postFrameCallbackDelayed(framecallback, 0L);
    }

    public void postFrameCallbackDelayed(FrameCallback framecallback, long l) {
        if(framecallback == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else {
            postCallbackDelayedInternal(1, framecallback, FRAME_CALLBACK_TOKEN, l);
            return;
        }
    }

    public void removeCallbacks(int i, Runnable runnable, Object obj) {
        if(i < 0 || i > 2) {
            throw new IllegalArgumentException("callbackType is invalid");
        } else {
            removeCallbacksInternal(i, runnable, obj);
            return;
        }
    }

    public void removeFrameCallback(FrameCallback framecallback) {
        if(framecallback == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else {
            removeCallbacksInternal(1, framecallback, FRAME_CALLBACK_TOKEN);
            return;
        }
    }

    public static final int CALLBACK_ANIMATION = 1;
    public static final int CALLBACK_INPUT = 0;
    private static final int CALLBACK_LAST = 2;
    public static final int CALLBACK_TRAVERSAL = 2;
    private static final boolean DEBUG = false;
    private static final long DEFAULT_FRAME_DELAY = 10L;
    private static final Object FRAME_CALLBACK_TOKEN = new Object() {

        public String toString() {
            return "FRAME_CALLBACK_TOKEN";
        }

    };
    private static final int MSG_DO_FRAME = 0;
    private static final int MSG_DO_SCHEDULE_CALLBACK = 2;
    private static final int MSG_DO_SCHEDULE_VSYNC = 1;
    private static final long NANOS_PER_MS = 0xf4240L;
    private static final int SKIPPED_FRAME_WARNING_LIMIT = 0;
    private static final String TAG = "Choreographer";
    private static final boolean USE_FRAME_TIME = SystemProperties.getBoolean("debug.choreographer.frametime", true);
    private static final boolean USE_VSYNC = SystemProperties.getBoolean("debug.choreographer.vsync", true);
    private static volatile long sFrameDelay = 10L;
    private static final ThreadLocal sThreadInstance = new ThreadLocal() {

        protected Choreographer initialValue() {
            Looper looper = Looper.myLooper();
            if(looper == null)
                throw new IllegalStateException("The current thread must have a looper!");
            else
                return new Choreographer(looper);
        }

        protected volatile Object initialValue() {
            return initialValue();
        }

    };
    private CallbackRecord mCallbackPool;
    private final CallbackQueue mCallbackQueues[];
    private boolean mCallbacksRunning;
    private final FrameDisplayEventReceiver mDisplayEventReceiver;
    private long mFrameIntervalNanos;
    private boolean mFrameScheduled;
    private final FrameHandler mHandler;
    private long mLastFrameTimeNanos;
    private final Object mLock;
    private final Looper mLooper;

    static  {
        SKIPPED_FRAME_WARNING_LIMIT = SystemProperties.getInt("debug.choreographer.skipwarning", 30);
    }




}
