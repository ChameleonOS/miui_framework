// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.hardware.*;
import android.os.SystemProperties;
import android.util.*;

public abstract class WindowOrientationListener {
    static final class SensorEventListenerImpl
        implements SensorEventListener {

        private void addTiltHistoryEntry(long l, float f) {
            mTiltHistory[mTiltHistoryIndex] = f;
            mTiltHistoryTimestampNanos[mTiltHistoryIndex] = l;
            mTiltHistoryIndex = (1 + mTiltHistoryIndex) % 40;
            mTiltHistoryTimestampNanos[mTiltHistoryIndex] = 0x8000000000000000L;
        }

        private void clearPredictedRotation() {
            mPredictedRotation = -1;
            mPredictedRotationTimestampNanos = 0x8000000000000000L;
        }

        private void clearTiltHistory() {
            mTiltHistoryTimestampNanos[0] = 0x8000000000000000L;
            mTiltHistoryIndex = 1;
        }

        private boolean isAccelerating(float f) {
            boolean flag;
            if(f < 5.80665F || f > 13.80665F)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private boolean isFlat(long l) {
            int i = mTiltHistoryIndex;
_L2:
            boolean flag;
            i = nextTiltHistoryIndex(i);
            if(i >= 0 && mTiltHistory[i] >= 75F)
                continue; /* Loop/switch isn't completed */
            flag = false;
_L3:
            return flag;
            if(0x3b9aca00L + mTiltHistoryTimestampNanos[i] > l) goto _L2; else goto _L1
_L1:
            flag = true;
              goto _L3
            if(true) goto _L2; else goto _L4
_L4:
        }

        private boolean isOrientationAngleAcceptable(int i, int j) {
            boolean flag;
            int k;
            flag = false;
            k = mOrientationListener.mCurrentRotation;
            if(k < 0) goto _L2; else goto _L1
_L1:
            if(i != k && i != (k + 1) % 4) goto _L4; else goto _L3
_L3:
            int l = 22 + (-45 + i * 90);
            if(i != 0 ? j < l : j >= 315 && j < l + 360) goto _L5; else goto _L4
_L5:
            return flag;
_L4:
            if(i != k && i != (k + 3) % 4) goto _L2; else goto _L6
_L6:
            int i1 = -22 + (45 + i * 90);
            if(i != 0 ? j <= i1 : j > 45 || j <= i1) goto _L2; else goto _L7
_L7:
            continue; /* Loop/switch isn't completed */
_L2:
            flag = true;
            if(true) goto _L5; else goto _L8
_L8:
        }

        private boolean isPredictedRotationAcceptable(long l) {
            boolean flag;
            flag = false;
            break MISSING_BLOCK_LABEL_2;
            if(l >= 0x2625a00L + mPredictedRotationTimestampNanos && l >= 0x1dcd6500L + mFlatTimestampNanos && l >= 0x11e1a300L + mSwingTimestampNanos && l >= 0x1dcd6500L + mAccelerationTimestampNanos)
                flag = true;
            return flag;
        }

        private boolean isSwinging(long l, float f) {
            int i = mTiltHistoryIndex;
_L2:
            boolean flag;
            i = nextTiltHistoryIndex(i);
            if(i >= 0 && 0x11e1a300L + mTiltHistoryTimestampNanos[i] >= l)
                continue; /* Loop/switch isn't completed */
            flag = false;
_L3:
            return flag;
            if(20F + mTiltHistory[i] > f) goto _L2; else goto _L1
_L1:
            flag = true;
              goto _L3
            if(true) goto _L2; else goto _L4
_L4:
        }

        private boolean isTiltAngleAcceptable(int i, int j) {
            boolean flag = true;
            if(j < TILT_TOLERANCE[i][0] || j > TILT_TOLERANCE[i][flag])
                flag = false;
            return flag;
        }

        private int nextTiltHistoryIndex(int i) {
            if(i == 0)
                i = 40;
            int j = i - 1;
            if(mTiltHistoryTimestampNanos[j] == 0x8000000000000000L)
                j = -1;
            return j;
        }

        private static float remainingMS(long l, long l1) {
            float f;
            if(l >= l1)
                f = 0.0F;
            else
                f = 1E-06F * (float)(l1 - l);
            return f;
        }

        private void reset() {
            mLastFilteredTimestampNanos = 0x8000000000000000L;
            mProposedRotation = -1;
            mFlatTimestampNanos = 0x8000000000000000L;
            mSwingTimestampNanos = 0x8000000000000000L;
            mAccelerationTimestampNanos = 0x8000000000000000L;
            clearPredictedRotation();
            clearTiltHistory();
        }

        private void updatePredictedRotation(long l, int i) {
            if(mPredictedRotation != i) {
                mPredictedRotation = i;
                mPredictedRotationTimestampNanos = l;
            }
        }

        public int getProposedRotation() {
            return mProposedRotation;
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorevent) {
            float f;
            float f1;
            float f2;
            long l;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            float f4;
            f = sensorevent.values[0];
            f1 = sensorevent.values[1];
            f2 = sensorevent.values[2];
            if(WindowOrientationListener.LOG)
                Slog.v("WindowOrientationListener", (new StringBuilder()).append("Raw acceleration vector: x=").append(f).append(", y=").append(f1).append(", z=").append(f2).append(", magnitude=").append(FloatMath.sqrt(f * f + f1 * f1 + f2 * f2)).toString());
            l = sensorevent.timestamp;
            long l1 = mLastFilteredTimestampNanos;
            float f3 = 1E-06F * (float)(l - l1);
            boolean flag;
            int i;
            if(l < l1 || l > 0x3b9aca00L + l1 || f == 0.0F && f1 == 0.0F && f2 == 0.0F) {
                if(WindowOrientationListener.LOG)
                    Slog.v("WindowOrientationListener", "Resetting orientation listener.");
                reset();
                flag = true;
            } else {
                float f5 = f3 / (200F + f3);
                f = f5 * (f - mLastFilteredX) + mLastFilteredX;
                f1 = f5 * (f1 - mLastFilteredY) + mLastFilteredY;
                f2 = f5 * (f2 - mLastFilteredZ) + mLastFilteredZ;
                if(WindowOrientationListener.LOG)
                    Slog.v("WindowOrientationListener", (new StringBuilder()).append("Filtered acceleration vector: x=").append(f).append(", y=").append(f1).append(", z=").append(f2).append(", magnitude=").append(FloatMath.sqrt(f * f + f1 * f1 + f2 * f2)).toString());
                flag = false;
            }
            mLastFilteredTimestampNanos = l;
            mLastFilteredX = f;
            mLastFilteredY = f1;
            mLastFilteredZ = f2;
            flag1 = false;
            flag2 = false;
            flag3 = false;
            if(flag) goto _L2; else goto _L1
_L1:
            f4 = FloatMath.sqrt(f * f + f1 * f1 + f2 * f2);
            if(f4 >= 1.0F) goto _L4; else goto _L3
_L3:
            if(WindowOrientationListener.LOG)
                Slog.v("WindowOrientationListener", "Ignoring sensor data, magnitude too close to zero.");
            clearPredictedRotation();
_L2:
            i = mProposedRotation;
            if(mPredictedRotation < 0 || isPredictedRotationAcceptable(l))
                mProposedRotation = mPredictedRotation;
            if(WindowOrientationListener.LOG)
                Slog.v("WindowOrientationListener", (new StringBuilder()).append("Result: currentRotation=").append(mOrientationListener.mCurrentRotation).append(", proposedRotation=").append(mProposedRotation).append(", predictedRotation=").append(mPredictedRotation).append(", timeDeltaMS=").append(f3).append(", isAccelerating=").append(flag1).append(", isFlat=").append(flag2).append(", isSwinging=").append(flag3).append(", timeUntilSettledMS=").append(remainingMS(l, 0x2625a00L + mPredictedRotationTimestampNanos)).append(", timeUntilAccelerationDelayExpiredMS=").append(remainingMS(l, 0x1dcd6500L + mAccelerationTimestampNanos)).append(", timeUntilFlatDelayExpiredMS=").append(remainingMS(l, 0x1dcd6500L + mFlatTimestampNanos)).append(", timeUntilSwingDelayExpiredMS=").append(remainingMS(l, 0x11e1a300L + mSwingTimestampNanos)).toString());
            if(mProposedRotation != i && mProposedRotation >= 0) {
                if(WindowOrientationListener.LOG)
                    Slog.v("WindowOrientationListener", (new StringBuilder()).append("Proposed rotation changed!  proposedRotation=").append(mProposedRotation).append(", oldProposedRotation=").append(i).toString());
                mOrientationListener.onProposedRotationChanged(mProposedRotation);
            }
            return;
_L4:
            if(isAccelerating(f4)) {
                flag1 = true;
                mAccelerationTimestampNanos = l;
            }
            int j = (int)Math.round(57.295780181884766D * Math.asin(f2 / f4));
            addTiltHistoryEntry(l, j);
            if(isFlat(l)) {
                flag2 = true;
                mFlatTimestampNanos = l;
            }
            if(isSwinging(l, j)) {
                flag3 = true;
                mSwingTimestampNanos = l;
            }
            if(Math.abs(j) > 75) {
                if(WindowOrientationListener.LOG)
                    Slog.v("WindowOrientationListener", (new StringBuilder()).append("Ignoring sensor data, tilt angle too high: tiltAngle=").append(j).toString());
                clearPredictedRotation();
            } else {
                int k = (int)Math.round(57.295780181884766D * -Math.atan2(-f, f1));
                if(k < 0)
                    k += 360;
                int i1 = (k + 45) / 90;
                if(i1 == 4)
                    i1 = 0;
                if(isTiltAngleAcceptable(i1, j) && isOrientationAngleAcceptable(i1, k)) {
                    updatePredictedRotation(l, i1);
                    if(WindowOrientationListener.LOG)
                        Slog.v("WindowOrientationListener", (new StringBuilder()).append("Predicted: tiltAngle=").append(j).append(", orientationAngle=").append(k).append(", predictedRotation=").append(mPredictedRotation).append(", predictedRotationAgeMS=").append(1E-06F * (float)(l - mPredictedRotationTimestampNanos)).toString());
                } else {
                    if(WindowOrientationListener.LOG)
                        Slog.v("WindowOrientationListener", (new StringBuilder()).append("Ignoring sensor data, no predicted rotation: tiltAngle=").append(j).append(", orientationAngle=").append(k).toString());
                    clearPredictedRotation();
                }
            }
            if(true) goto _L2; else goto _L5
_L5:
        }

        private static final float ACCELERATION_TOLERANCE = 4F;
        private static final int ACCELEROMETER_DATA_X = 0;
        private static final int ACCELEROMETER_DATA_Y = 1;
        private static final int ACCELEROMETER_DATA_Z = 2;
        private static final int ADJACENT_ORIENTATION_ANGLE_GAP = 45;
        private static final float FILTER_TIME_CONSTANT_MS = 200F;
        private static final float FLAT_ANGLE = 75F;
        private static final long FLAT_TIME_NANOS = 0x3b9aca00L;
        private static final float MAX_ACCELERATION_MAGNITUDE = 13.80665F;
        private static final long MAX_FILTER_DELTA_TIME_NANOS = 0x3b9aca00L;
        private static final int MAX_TILT = 75;
        private static final float MIN_ACCELERATION_MAGNITUDE = 5.80665F;
        private static final long NANOS_PER_MS = 0xf4240L;
        private static final float NEAR_ZERO_MAGNITUDE = 1F;
        private static final long PROPOSAL_MIN_TIME_SINCE_ACCELERATION_ENDED_NANOS = 0x1dcd6500L;
        private static final long PROPOSAL_MIN_TIME_SINCE_FLAT_ENDED_NANOS = 0x1dcd6500L;
        private static final long PROPOSAL_MIN_TIME_SINCE_SWING_ENDED_NANOS = 0x11e1a300L;
        private static final long PROPOSAL_SETTLE_TIME_NANOS = 0x2625a00L;
        private static final float RADIANS_TO_DEGREES = 57.29578F;
        private static final float SWING_AWAY_ANGLE_DELTA = 20F;
        private static final long SWING_TIME_NANOS = 0x11e1a300L;
        private static final int TILT_HISTORY_SIZE = 40;
        private static final int TILT_TOLERANCE[][];
        private long mAccelerationTimestampNanos;
        private long mFlatTimestampNanos;
        private long mLastFilteredTimestampNanos;
        private float mLastFilteredX;
        private float mLastFilteredY;
        private float mLastFilteredZ;
        private final WindowOrientationListener mOrientationListener;
        private int mPredictedRotation;
        private long mPredictedRotationTimestampNanos;
        private int mProposedRotation;
        private long mSwingTimestampNanos;
        private float mTiltHistory[];
        private int mTiltHistoryIndex;
        private long mTiltHistoryTimestampNanos[];

        static  {
            int ai[][] = new int[4][];
            int ai1[] = new int[2];
            ai1[0] = -25;
            ai1[1] = 70;
            ai[0] = ai1;
            int ai2[] = new int[2];
            ai2[0] = -25;
            ai2[1] = 65;
            ai[1] = ai2;
            int ai3[] = new int[2];
            ai3[0] = -25;
            ai3[1] = 60;
            ai[2] = ai3;
            int ai4[] = new int[2];
            ai4[0] = -25;
            ai4[1] = 65;
            ai[3] = ai4;
            TILT_TOLERANCE = ai;
        }

        public SensorEventListenerImpl(WindowOrientationListener windoworientationlistener) {
            mTiltHistory = new float[40];
            mTiltHistoryTimestampNanos = new long[40];
            mOrientationListener = windoworientationlistener;
            reset();
        }
    }


    public WindowOrientationListener(Context context) {
        this(context, 3);
    }

    private WindowOrientationListener(Context context, int i) {
        mCurrentRotation = -1;
        mSensorManager = (SensorManager)context.getSystemService("sensor");
        mRate = i;
        mSensor = mSensorManager.getDefaultSensor(1);
        if(mSensor != null)
            mSensorEventListener = new SensorEventListenerImpl(this);
    }

    public boolean canDetectOrientation() {
        boolean flag;
        if(mSensor != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void disable() {
        if(mSensor != null) goto _L2; else goto _L1
_L1:
        Log.w("WindowOrientationListener", "Cannot detect sensors. Invalid disable");
_L4:
        return;
_L2:
        if(mEnabled) {
            if(LOG)
                Log.d("WindowOrientationListener", "WindowOrientationListener disabled");
            mSensorManager.unregisterListener(mSensorEventListener);
            mEnabled = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void enable() {
        if(mSensor != null) goto _L2; else goto _L1
_L1:
        Log.w("WindowOrientationListener", "Cannot detect sensors. Not enabled");
_L4:
        return;
_L2:
        if(!mEnabled) {
            if(LOG)
                Log.d("WindowOrientationListener", "WindowOrientationListener enabled");
            mSensorManager.registerListener(mSensorEventListener, mSensor, mRate);
            mEnabled = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getProposedRotation() {
        int i;
        if(mEnabled)
            i = mSensorEventListener.getProposedRotation();
        else
            i = -1;
        return i;
    }

    public abstract void onProposedRotationChanged(int i);

    public void setCurrentRotation(int i) {
        mCurrentRotation = i;
    }

    private static final boolean LOG = false;
    private static final String TAG = "WindowOrientationListener";
    private static final boolean USE_GRAVITY_SENSOR;
    int mCurrentRotation;
    private boolean mEnabled;
    private int mRate;
    private Sensor mSensor;
    private SensorEventListenerImpl mSensorEventListener;
    private SensorManager mSensorManager;

    static  {
        LOG = SystemProperties.getBoolean("debug.orientation.log", false);
    }

}
