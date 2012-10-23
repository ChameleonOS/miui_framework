// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.hardware.*;
import android.util.Log;

// Referenced classes of package android.view:
//            OrientationListener

public abstract class OrientationEventListener {
    class SensorEventListenerImpl
        implements SensorEventListener {

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorevent) {
            float af[] = sensorevent.values;
            int i = -1;
            float f = -af[0];
            float f1 = -af[1];
            float f2 = -af[2];
            if(4F * (f * f + f1 * f1) >= f2 * f2) {
                for(i = 90 - Math.round(57.29578F * (float)Math.atan2(-f1, f)); i >= 360; i -= 360);
                for(; i < 0; i += 360);
            }
            if(mOldListener != null)
                mOldListener.onSensorChanged(1, sensorevent.values);
            if(i != mOrientation) {
                mOrientation = i;
                onOrientationChanged(i);
            }
        }

        private static final int _DATA_X = 0;
        private static final int _DATA_Y = 1;
        private static final int _DATA_Z = 2;
        final OrientationEventListener this$0;

        SensorEventListenerImpl() {
            this$0 = OrientationEventListener.this;
            super();
        }
    }


    public OrientationEventListener(Context context) {
        this(context, 3);
    }

    public OrientationEventListener(Context context, int i) {
        mOrientation = -1;
        mEnabled = false;
        mSensorManager = (SensorManager)context.getSystemService("sensor");
        mRate = i;
        mSensor = mSensorManager.getDefaultSensor(1);
        if(mSensor != null)
            mSensorEventListener = new SensorEventListenerImpl();
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
        Log.w("OrientationEventListener", "Cannot detect sensors. Invalid disable");
_L4:
        return;
_L2:
        if(mEnabled) {
            mSensorManager.unregisterListener(mSensorEventListener);
            mEnabled = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void enable() {
        if(mSensor != null) goto _L2; else goto _L1
_L1:
        Log.w("OrientationEventListener", "Cannot detect sensors. Not enabled");
_L4:
        return;
_L2:
        if(!mEnabled) {
            mSensorManager.registerListener(mSensorEventListener, mSensor, mRate);
            mEnabled = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public abstract void onOrientationChanged(int i);

    void registerListener(OrientationListener orientationlistener) {
        mOldListener = orientationlistener;
    }

    private static final boolean DEBUG = false;
    public static final int ORIENTATION_UNKNOWN = -1;
    private static final String TAG = "OrientationEventListener";
    private static final boolean localLOGV;
    private boolean mEnabled;
    private OrientationListener mOldListener;
    private int mOrientation;
    private int mRate;
    private Sensor mSensor;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;




/*
    static int access$102(OrientationEventListener orientationeventlistener, int i) {
        orientationeventlistener.mOrientation = i;
        return i;
    }

*/
}
