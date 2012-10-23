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

final class DeviceMotionService
    implements SensorEventListener {

    public DeviceMotionService(DeviceMotionAndOrientationManager devicemotionandorientationmanager, Context context) {
        mManager = devicemotionandorientationmanager;
        if(!$assertionsDisabled && mManager == null)
            throw new AssertionError();
        mContext = context;
        if(!$assertionsDisabled && mContext == null)
            throw new AssertionError();
        else
            return;
    }

    private void createHandler() {
        if(mHandler == null) {
            mHandler = new Handler();
            mUpdateRunnable = new Runnable() {

                public void run() {
                    if(!$assertionsDisabled && !mIsRunning) {
                        throw new AssertionError();
                    } else {
                        mManager.onMotionChange(new Double(mLastAcceleration[0]), new Double(mLastAcceleration[1]), new Double(mLastAcceleration[2]), 100D);
                        mHandler.postDelayed(mUpdateRunnable, 100L);
                        mHaveSentErrorEvent = false;
                        return;
                    }
                }

                static final boolean $assertionsDisabled;
                final DeviceMotionService this$0;

                static  {
                    boolean flag;
                    if(!android/webkit/DeviceMotionService.desiredAssertionStatus())
                        flag = true;
                    else
                        flag = false;
                    $assertionsDisabled = flag;
                }

             {
                this$0 = DeviceMotionService.this;
                super();
            }
            };
        }
    }

    private SensorManager getSensorManager() {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        if(mSensorManager == null)
            mSensorManager = (SensorManager)mContext.getSystemService("sensor");
        return mSensorManager;
    }

    private boolean registerForAccelerometerSensor() {
        boolean flag = false;
        List list = getSensorManager().getSensorList(1);
        if(!list.isEmpty()) {
            createHandler();
            flag = getSensorManager().registerListener(this, (Sensor)list.get(0), 2, mHandler);
        }
        return flag;
    }

    private void registerForSensor() {
        if(!registerForAccelerometerSensor())
            sendErrorEvent();
    }

    private void sendErrorEvent() {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        if(!mHaveSentErrorEvent) {
            mHaveSentErrorEvent = true;
            createHandler();
            mHandler.post(new Runnable() {

                public void run() {
                    if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
                        throw new AssertionError();
                    if(mIsRunning)
                        mManager.onMotionChange(null, null, null, 0.0D);
                }

                static final boolean $assertionsDisabled;
                final DeviceMotionService this$0;

                static  {
                    boolean flag;
                    if(!android/webkit/DeviceMotionService.desiredAssertionStatus())
                        flag = true;
                    else
                        flag = false;
                    $assertionsDisabled = flag;
                }

             {
                this$0 = DeviceMotionService.this;
                super();
            }
            });
        }
    }

    private void startSendingUpdates() {
        createHandler();
        mUpdateRunnable.run();
    }

    private void stopSendingUpdates() {
        mHandler.removeCallbacks(mUpdateRunnable);
        mLastAcceleration = null;
    }

    private void unregisterFromSensor() {
        getSensorManager().unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        else
            return;
    }

    public void onSensorChanged(SensorEvent sensorevent) {
        int i;
        i = 1;
        if(!$assertionsDisabled && sensorevent.values.length != 3)
            throw new AssertionError();
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName()))
            throw new AssertionError();
        if(!$assertionsDisabled && sensorevent.sensor.getType() != i)
            throw new AssertionError();
        if(mIsRunning) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mLastAcceleration != null)
            i = 0;
        mLastAcceleration = sensorevent.values;
        if(i != 0)
            startSendingUpdates();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void resume() {
        if(mIsRunning)
            registerForSensor();
    }

    public void start() {
        mIsRunning = true;
        registerForSensor();
    }

    public void stop() {
        mIsRunning = false;
        stopSendingUpdates();
        unregisterFromSensor();
    }

    public void suspend() {
        if(mIsRunning) {
            stopSendingUpdates();
            unregisterFromSensor();
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final int INTERVAL_MILLIS = 100;
    private Context mContext;
    private Handler mHandler;
    private boolean mHaveSentErrorEvent;
    private boolean mIsRunning;
    private float mLastAcceleration[];
    private DeviceMotionAndOrientationManager mManager;
    private SensorManager mSensorManager;
    private Runnable mUpdateRunnable;

    static  {
        boolean flag;
        if(!android/webkit/DeviceMotionService.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }







/*
    static boolean access$502(DeviceMotionService devicemotionservice, boolean flag) {
        devicemotionservice.mHaveSentErrorEvent = flag;
        return flag;
    }

*/
}
