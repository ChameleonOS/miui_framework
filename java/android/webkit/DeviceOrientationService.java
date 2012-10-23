// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.hardware.*;
import android.os.Handler;
import java.util.List;

// Referenced classes of package android.webkit:
//            DeviceMotionAndOrientationManager

final class DeviceOrientationService
    implements SensorEventListener {

    public DeviceOrientationService(DeviceMotionAndOrientationManager devicemotionandorientationmanager, Context context) {
        mManager = devicemotionandorientationmanager;
        if(!$assertionsDisabled && mManager == null)
            throw new AssertionError();
        mContext = context;
        if(!$assertionsDisabled && mContext == null)
            throw new AssertionError();
        else
            return;
    }

    private void getOrientationUsingGetRotationMatrix() {
        if(mGravityVector != null && mMagneticFieldVector != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float af[] = new float[9];
        if(SensorManager.getRotationMatrix(af, null, mGravityVector, mMagneticFieldVector)) {
            float af1[] = new float[3];
            SensorManager.getOrientation(af, af1);
            double d;
            for(d = Math.toDegrees(-af1[0]) - 90D; d < 0.0D; d += 360D);
            double d1;
            for(d1 = Math.toDegrees(-af1[1]); d1 < -180D; d1 += 360D);
            double d2;
            for(d2 = Math.toDegrees(af1[2]); d2 < -90D; d2 += 360D);
            maybeSendChange(d, d1, d2);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private SensorManager getSensorManager() {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        if(mSensorManager == null)
            mSensorManager = (SensorManager)mContext.getSystemService("sensor");
        return mSensorManager;
    }

    private void maybeSendChange(double d, double d1, double d2) {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        if(mAlpha == null || mBeta == null || mGamma == null || Math.abs(d - mAlpha.doubleValue()) > 1.0D || Math.abs(d1 - mBeta.doubleValue()) > 1.0D || Math.abs(d2 - mGamma.doubleValue()) > 1.0D) {
            mAlpha = Double.valueOf(d);
            mBeta = Double.valueOf(d1);
            mGamma = Double.valueOf(d2);
            mManager.onOrientationChange(mAlpha, mBeta, mGamma);
            mHaveSentErrorEvent = false;
        }
    }

    private boolean registerForAccelerometerSensor() {
        List list = getSensorManager().getSensorList(1);
        boolean flag;
        if(list.isEmpty())
            flag = false;
        else
            flag = getSensorManager().registerListener(this, (Sensor)list.get(0), 0, mHandler);
        return flag;
    }

    private boolean registerForMagneticFieldSensor() {
        List list = getSensorManager().getSensorList(2);
        boolean flag;
        if(list.isEmpty())
            flag = false;
        else
            flag = getSensorManager().registerListener(this, (Sensor)list.get(0), 0, mHandler);
        return flag;
    }

    private void registerForSensors() {
        if(mHandler == null)
            mHandler = new Handler();
        if(!registerForAccelerometerSensor() || !registerForMagneticFieldSensor()) {
            unregisterFromSensors();
            sendErrorEvent();
        }
    }

    private void sendErrorEvent() {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        if(!mHaveSentErrorEvent) {
            mHaveSentErrorEvent = true;
            mHandler.post(new Runnable() {

                public void run() {
                    if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
                        throw new AssertionError();
                    if(mIsRunning)
                        mManager.onOrientationChange(null, null, null);
                }

                static final boolean $assertionsDisabled;
                final DeviceOrientationService this$0;

                static  {
                    boolean flag;
                    if(!android/webkit/DeviceOrientationService.desiredAssertionStatus())
                        flag = true;
                    else
                        flag = false;
                    $assertionsDisabled = flag;
                }

             {
                this$0 = DeviceOrientationService.this;
                super();
            }
            });
        }
    }

    private void unregisterFromSensors() {
        getSensorManager().unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        else
            return;
    }

    public void onSensorChanged(SensorEvent sensorevent) {
        if(!$assertionsDisabled && sensorevent.values.length != 3)
            throw new AssertionError();
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        if(mIsRunning) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch(sensorevent.sensor.getType()) {
        default:
            if(!$assertionsDisabled)
                throw new AssertionError();
            break;

        case 1: // '\001'
            if(mGravityVector == null)
                mGravityVector = new float[3];
            mGravityVector[0] = sensorevent.values[0];
            mGravityVector[1] = sensorevent.values[1];
            mGravityVector[2] = sensorevent.values[2];
            getOrientationUsingGetRotationMatrix();
            break;

        case 2: // '\002'
            if(mMagneticFieldVector == null)
                mMagneticFieldVector = new float[3];
            mMagneticFieldVector[0] = sensorevent.values[0];
            mMagneticFieldVector[1] = sensorevent.values[1];
            mMagneticFieldVector[2] = sensorevent.values[2];
            getOrientationUsingGetRotationMatrix();
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void resume() {
        if(mIsRunning)
            registerForSensors();
    }

    public void start() {
        mIsRunning = true;
        registerForSensors();
    }

    public void stop() {
        mIsRunning = false;
        unregisterFromSensors();
    }

    public void suspend() {
        if(mIsRunning)
            unregisterFromSensors();
    }

    static final boolean $assertionsDisabled = false;
    private static final double DELTA_DEGRESS = 1D;
    private Double mAlpha;
    private Double mBeta;
    private Context mContext;
    private Double mGamma;
    private float mGravityVector[];
    private Handler mHandler;
    private boolean mHaveSentErrorEvent;
    private boolean mIsRunning;
    private float mMagneticFieldVector[];
    private DeviceMotionAndOrientationManager mManager;
    private SensorManager mSensorManager;

    static  {
        boolean flag;
        if(!android/webkit/DeviceOrientationService.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }


}
