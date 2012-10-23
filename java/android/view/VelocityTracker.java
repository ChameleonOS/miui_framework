// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.util.*;

// Referenced classes of package android.view:
//            MotionEvent

public final class VelocityTracker
    implements Poolable {
    public static final class Estimator {

        private float estimate(float f, float af[]) {
            float f1 = 0.0F;
            float f2 = 1.0F;
            for(int i = 0; i <= degree; i++) {
                f1 += f2 * af[i];
                f2 *= f;
            }

            return f1;
        }

        public float estimateX(float f) {
            return estimate(f, xCoeff);
        }

        public float estimateY(float f) {
            return estimate(f, yCoeff);
        }

        public float getXCoeff(int i) {
            float f;
            if(i <= degree)
                f = xCoeff[i];
            else
                f = 0.0F;
            return f;
        }

        public float getYCoeff(int i) {
            float f;
            if(i <= degree)
                f = yCoeff[i];
            else
                f = 0.0F;
            return f;
        }

        private static final int MAX_DEGREE = 4;
        public float confidence;
        public int degree;
        public final float xCoeff[] = new float[5];
        public final float yCoeff[] = new float[5];

        public Estimator() {
        }
    }


    private VelocityTracker(String s) {
        mPtr = nativeInitialize(s);
        mStrategy = s;
    }


    private static native void nativeAddMovement(int i, MotionEvent motionevent);

    private static native void nativeClear(int i);

    private static native void nativeComputeCurrentVelocity(int i, int j, float f);

    private static native void nativeDispose(int i);

    private static native boolean nativeGetEstimator(int i, int j, Estimator estimator);

    private static native float nativeGetXVelocity(int i, int j);

    private static native float nativeGetYVelocity(int i, int j);

    private static native int nativeInitialize(String s);

    public static VelocityTracker obtain() {
        return (VelocityTracker)sPool.acquire();
    }

    public static VelocityTracker obtain(String s) {
        VelocityTracker velocitytracker;
        if(s == null)
            velocitytracker = obtain();
        else
            velocitytracker = new VelocityTracker(s);
        return velocitytracker;
    }

    public void addMovement(MotionEvent motionevent) {
        if(motionevent == null) {
            throw new IllegalArgumentException("event must not be null");
        } else {
            nativeAddMovement(mPtr, motionevent);
            return;
        }
    }

    public void clear() {
        nativeClear(mPtr);
    }

    public void computeCurrentVelocity(int i) {
        nativeComputeCurrentVelocity(mPtr, i, 3.402823E+38F);
    }

    public void computeCurrentVelocity(int i, float f) {
        nativeComputeCurrentVelocity(mPtr, i, f);
    }

    protected void finalize() throws Throwable {
        if(mPtr != 0) {
            nativeDispose(mPtr);
            mPtr = 0;
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public boolean getEstimator(int i, Estimator estimator) {
        if(estimator == null)
            throw new IllegalArgumentException("outEstimator must not be null");
        else
            return nativeGetEstimator(mPtr, i, estimator);
    }

    public VelocityTracker getNextPoolable() {
        return mNext;
    }

    public volatile Object getNextPoolable() {
        return getNextPoolable();
    }

    public float getXVelocity() {
        return nativeGetXVelocity(mPtr, -1);
    }

    public float getXVelocity(int i) {
        return nativeGetXVelocity(mPtr, i);
    }

    public float getYVelocity() {
        return nativeGetYVelocity(mPtr, -1);
    }

    public float getYVelocity(int i) {
        return nativeGetYVelocity(mPtr, i);
    }

    public boolean isPooled() {
        return mIsPooled;
    }

    public void recycle() {
        if(mStrategy == null)
            sPool.release(this);
    }

    public void setNextPoolable(VelocityTracker velocitytracker) {
        mNext = velocitytracker;
    }

    public volatile void setNextPoolable(Object obj) {
        setNextPoolable((VelocityTracker)obj);
    }

    public void setPooled(boolean flag) {
        mIsPooled = flag;
    }

    private static final int ACTIVE_POINTER_ID = -1;
    private static final Pool sPool = Pools.synchronizedPool(Pools.finitePool(new PoolableManager() {

        public volatile Poolable newInstance() {
            return newInstance();
        }

        public VelocityTracker newInstance() {
            return new VelocityTracker(null);
        }

        public volatile void onAcquired(Poolable poolable) {
            onAcquired((VelocityTracker)poolable);
        }

        public void onAcquired(VelocityTracker velocitytracker) {
        }

        public volatile void onReleased(Poolable poolable) {
            onReleased((VelocityTracker)poolable);
        }

        public void onReleased(VelocityTracker velocitytracker) {
            velocitytracker.clear();
        }

    }, 2));
    private boolean mIsPooled;
    private VelocityTracker mNext;
    private int mPtr;
    private final String mStrategy;

}
