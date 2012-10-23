// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Handler, SystemClock, Message

public abstract class CountDownTimer {

    public CountDownTimer(long l, long l1) {
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                CountDownTimer countdowntimer = CountDownTimer.this;
                countdowntimer;
                JVM INSTR monitorenter ;
                long l2;
                l2 = mStopTimeInFuture - SystemClock.elapsedRealtime();
                if(l2 <= 0L) {
                    onFinish();
                } else {
                    if(l2 >= mCountdownInterval)
                        break MISSING_BLOCK_LABEL_70;
                    sendMessageDelayed(obtainMessage(1), l2);
                }
_L1:
                countdowntimer;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                throw exception;
                long l3 = SystemClock.elapsedRealtime();
                onTick(l2);
                long l4;
                for(l4 = (l3 + mCountdownInterval) - SystemClock.elapsedRealtime(); l4 < 0L; l4 += mCountdownInterval);
                sendMessageDelayed(obtainMessage(1), l4);
                  goto _L1
            }

            final CountDownTimer this$0;

             {
                this$0 = CountDownTimer.this;
                super();
            }
        };
        mMillisInFuture = l;
        mCountdownInterval = l1;
    }

    public final void cancel() {
        mHandler.removeMessages(1);
    }

    public abstract void onFinish();

    public abstract void onTick(long l);

    /**
     * @deprecated Method start is deprecated
     */

    public final CountDownTimer start() {
        this;
        JVM INSTR monitorenter ;
        if(mMillisInFuture > 0L) goto _L2; else goto _L1
_L1:
        onFinish();
        CountDownTimer countdowntimer = this;
_L4:
        this;
        JVM INSTR monitorexit ;
        return countdowntimer;
_L2:
        mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
        mHandler.sendMessage(mHandler.obtainMessage(1));
        countdowntimer = this;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static final int MSG = 1;
    private final long mCountdownInterval;
    private Handler mHandler;
    private final long mMillisInFuture;
    private long mStopTimeInFuture;


}
