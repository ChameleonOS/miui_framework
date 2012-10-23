// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;


// Referenced classes of package android.animation:
//            ValueAnimator

public class TimeAnimator extends ValueAnimator {
    public static interface TimeListener {

        public abstract void onTimeUpdate(TimeAnimator timeanimator, long l, long l1);
    }


    public TimeAnimator() {
        mPreviousTime = -1L;
    }

    void animateValue(float f) {
    }

    boolean animationFrame(long l) {
        long l1 = 0L;
        if(mListener != null) {
            long l2 = l - super.mStartTime;
            if(mPreviousTime >= l1)
                l1 = l - mPreviousTime;
            mPreviousTime = l;
            mListener.onTimeUpdate(this, l2, l1);
        }
        return false;
    }

    void initAnimation() {
    }

    public void setTimeListener(TimeListener timelistener) {
        mListener = timelistener;
    }

    private TimeListener mListener;
    private long mPreviousTime;
}
