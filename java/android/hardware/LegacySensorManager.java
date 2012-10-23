// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.IWindowManager;
import java.util.*;

// Referenced classes of package android.hardware:
//            SensorManager, Sensor, SensorListener, SensorEventListener, 
//            SensorEvent

final class LegacySensorManager {
    private static final class LmsFilter {

        public float filter(long l, float f) {
            float f1;
            float f2;
            float f3;
            f1 = f;
            f2 = 1E-09F * (float)l;
            f3 = mV[mIndex];
            if(f1 - f3 <= 180F) goto _L2; else goto _L1
_L1:
            f1 -= 360F;
_L4:
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            mIndex = 1 + mIndex;
            if(mIndex >= 24)
                mIndex = 12;
            mV[mIndex] = f1;
            mT[mIndex] = f2;
            mV[-12 + mIndex] = f1;
            mT[-12 + mIndex] = f2;
            f4 = 0.0F;
            f5 = 0.0F;
            f6 = 0.0F;
            f7 = 0.0F;
            f8 = 0.0F;
            for(int i = 0; i < 11; i++) {
                int j = (-1 + mIndex) - i;
                float f12 = mV[j];
                float f13 = 0.5F * (mT[j] + mT[j + 1]) - f2;
                float f14 = mT[j] - mT[j + 1];
                float f15 = f14 * f14;
                f8 += f12 * f15;
                f7 += f13 * (f13 * f15);
                f6 += f13 * f15;
                f5 += f12 * (f13 * f15);
                f4 += f15;
            }

            break; /* Loop/switch isn't completed */
_L2:
            if(f3 - f1 > 180F)
                f1 += 360F;
            if(true) goto _L4; else goto _L3
_L3:
            float f9 = (f8 * f7 + f6 * f5) / (f4 * f7 + f6 * f6);
            float f10 = 0.002777778F * (f9 + 0.08F * ((f4 * f9 - f8) / f6));
            float f11;
            if(f10 >= 0.0F)
                f11 = f10;
            else
                f11 = -f10;
            if(f11 >= 0.5F)
                f10 = 1.0F + (f10 - (float)Math.ceil(0.5F + f10));
            if(f10 < 0.0F)
                f10++;
            return f10 * 360F;
        }

        private static final int COUNT = 12;
        private static final float PREDICTION_RATIO = 0.3333333F;
        private static final float PREDICTION_TIME = 0.08F;
        private static final int SENSORS_RATE_MS = 20;
        private int mIndex;
        private float mT[];
        private float mV[];

        public LmsFilter() {
            mV = new float[24];
            mT = new float[24];
            mIndex = 12;
        }
    }

    private static final class LegacyListener
        implements SensorEventListener {

        private static int getLegacySensorType(int i) {
            i;
            JVM INSTR tableswitch 1 7: default 44
        //                       1 48
        //                       2 53
        //                       3 59
        //                       4 44
        //                       5 44
        //                       6 44
        //                       7 66;
               goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5
_L1:
            int j = 0;
_L7:
            return j;
_L2:
            j = 2;
            continue; /* Loop/switch isn't completed */
_L3:
            j = 8;
            continue; /* Loop/switch isn't completed */
_L4:
            j = 128;
            continue; /* Loop/switch isn't completed */
_L5:
            j = 4;
            if(true) goto _L7; else goto _L6
_L6:
        }

        private static boolean hasOrientationSensor(int i) {
            boolean flag;
            if((i & 0x81) != 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private void mapSensorDataToWindow(int i, float af[], int j) {
            float f;
            float f1;
            float f2;
            f = af[0];
            f1 = af[1];
            f2 = af[2];
            i;
            JVM INSTR lookupswitch 4: default 60
        //                       1: 205
        //                       2: 213
        //                       8: 231
        //                       128: 205;
               goto _L1 _L2 _L3 _L4 _L2
_L1:
            af[0] = f;
            af[1] = f1;
            af[2] = f2;
            af[3] = f;
            af[4] = f1;
            af[5] = f2;
            if((j & 1) == 0) goto _L6; else goto _L5
_L5:
            i;
            JVM INSTR lookupswitch 4: default 140
        //                       1: 263
        //                       2: 244
        //                       8: 244
        //                       128: 263;
               goto _L6 _L7 _L8 _L8 _L7
_L6:
            if((j & 2) == 0) goto _L10; else goto _L9
_L9:
            float f3;
            float f4;
            float f5;
            f3 = af[0];
            f4 = af[1];
            f5 = af[2];
            i;
            JVM INSTR lookupswitch 4: default 204
        //                       1: 325
        //                       2: 305
        //                       8: 305
        //                       128: 325;
               goto _L11 _L12 _L13 _L13 _L12
_L11:
            break; /* Loop/switch isn't completed */
_L12:
            break MISSING_BLOCK_LABEL_325;
_L10:
            return;
_L2:
            f2 = -f2;
              goto _L1
_L3:
            f = -f;
            f1 = -f1;
            f2 = -f2;
              goto _L1
_L4:
            f = -f;
            f1 = -f1;
              goto _L1
_L8:
            af[0] = -f1;
            af[1] = f;
            af[2] = f2;
              goto _L6
_L7:
            int k;
            if(f < 270F)
                k = 90;
            else
                k = -270;
            af[0] = f + (float)k;
            af[1] = f2;
            af[2] = f1;
              goto _L6
_L13:
            af[0] = -f3;
            af[1] = -f4;
            af[2] = f5;
              goto _L10
            float f6;
            if(f3 >= 180F)
                f6 = f3 - 180F;
            else
                f6 = f3 + 180F;
            af[0] = f6;
            af[1] = -f4;
            af[2] = -f5;
              goto _L10
        }

        boolean hasSensors() {
            boolean flag;
            if(mSensors != 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
            mTarget.onAccuracyChanged(getLegacySensorType(sensor.getType()), i);
_L2:
            return;
            AbstractMethodError abstractmethoderror;
            abstractmethoderror;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void onSensorChanged(SensorEvent sensorevent) {
            float af[] = mValues;
            af[0] = sensorevent.values[0];
            af[1] = sensorevent.values[1];
            af[2] = sensorevent.values[2];
            int i = sensorevent.sensor.getType();
            int j = getLegacySensorType(i);
            mapSensorDataToWindow(j, af, LegacySensorManager.getRotation());
            if(i == 3) {
                if((0x80 & mSensors) != 0)
                    mTarget.onSensorChanged(128, af);
                if((1 & mSensors) != 0) {
                    af[0] = mYawfilter.filter(sensorevent.timestamp, af[0]);
                    mTarget.onSensorChanged(1, af);
                }
            } else {
                mTarget.onSensorChanged(j, af);
            }
        }

        boolean registerSensor(int i) {
            boolean flag = false;
            if((i & mSensors) == 0) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            boolean flag1 = hasOrientationSensor(mSensors);
            mSensors = i | mSensors;
            if(!flag1 || !hasOrientationSensor(i))
                flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        boolean unregisterSensor(int i) {
            boolean flag = false;
            if((i & mSensors) != 0) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            mSensors = mSensors & ~i;
            if(!hasOrientationSensor(i) || !hasOrientationSensor(mSensors))
                flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        private int mSensors;
        private SensorListener mTarget;
        private float mValues[];
        private final LmsFilter mYawfilter = new LmsFilter();

        LegacyListener(SensorListener sensorlistener) {
            mValues = new float[6];
            mTarget = sensorlistener;
            mSensors = 0;
        }
    }


    public LegacySensorManager(SensorManager sensormanager) {
        mLegacyListenersMap = new HashMap();
        mSensorManager = sensormanager;
        android/hardware/SensorManager;
        JVM INSTR monitorenter ;
        IWindowManager iwindowmanager;
        if(sInitialized)
            break MISSING_BLOCK_LABEL_67;
        sWindowManager = android.view.IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        iwindowmanager = sWindowManager;
        Exception exception;
        if(iwindowmanager != null)
            try {
                sRotation = sWindowManager.watchRotation(new android.view.IRotationWatcher.Stub() {

                    public void onRotationChanged(int i) {
                        LegacySensorManager.onRotationChanged(i);
                    }

                    final LegacySensorManager this$0;

             {
                this$0 = LegacySensorManager.this;
                super();
            }
                });
            }
            catch(RemoteException remoteexception) { }
            finally {
                android/hardware/SensorManager;
            }
        android/hardware/SensorManager;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

    static int getRotation() {
        android/hardware/SensorManager;
        JVM INSTR monitorenter ;
        int i = sRotation;
        return i;
    }

    static void onRotationChanged(int i) {
        android/hardware/SensorManager;
        JVM INSTR monitorenter ;
        sRotation = i;
        return;
    }

    private boolean registerLegacyListener(int i, int j, SensorListener sensorlistener, int k, int l) {
        boolean flag;
        Sensor sensor;
        flag = false;
        if((k & i) == 0)
            break MISSING_BLOCK_LABEL_111;
        sensor = mSensorManager.getDefaultSensor(j);
        if(sensor == null)
            break MISSING_BLOCK_LABEL_111;
        HashMap hashmap = mLegacyListenersMap;
        hashmap;
        JVM INSTR monitorenter ;
        LegacyListener legacylistener = (LegacyListener)mLegacyListenersMap.get(sensorlistener);
        if(legacylistener == null) {
            legacylistener = new LegacyListener(sensorlistener);
            mLegacyListenersMap.put(sensorlistener, legacylistener);
        }
        if(legacylistener.registerSensor(i))
            flag = mSensorManager.registerListener(legacylistener, sensor, l);
        else
            flag = true;
        return flag;
    }

    private void unregisterLegacyListener(int i, int j, SensorListener sensorlistener, int k) {
        Sensor sensor;
        if((k & i) == 0)
            break MISSING_BLOCK_LABEL_100;
        sensor = mSensorManager.getDefaultSensor(j);
        if(sensor == null)
            break MISSING_BLOCK_LABEL_100;
        HashMap hashmap = mLegacyListenersMap;
        hashmap;
        JVM INSTR monitorenter ;
        LegacyListener legacylistener = (LegacyListener)mLegacyListenersMap.get(sensorlistener);
        if(legacylistener != null && legacylistener.unregisterSensor(i)) {
            mSensorManager.unregisterListener(legacylistener, sensor);
            if(!legacylistener.hasSensors())
                mLegacyListenersMap.remove(sensorlistener);
        }
    }

    public int getSensors() {
        int i = 0;
        Iterator iterator = mSensorManager.getFullSensorList().iterator();
        do
            if(iterator.hasNext())
                switch(((Sensor)iterator.next()).getType()) {
                case 1: // '\001'
                    i |= 2;
                    break;

                case 2: // '\002'
                    i |= 8;
                    break;

                case 3: // '\003'
                    i |= 0x81;
                    break;
                }
            else
                return i;
        while(true);
    }

    public boolean registerListener(SensorListener sensorlistener, int i, int j) {
        boolean flag = false;
        if(sensorlistener != null) {
            boolean flag1;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            boolean flag5;
            if(registerLegacyListener(2, 1, sensorlistener, i, j) || false)
                flag1 = true;
            else
                flag1 = false;
            if(registerLegacyListener(8, 2, sensorlistener, i, j) || flag1)
                flag2 = true;
            else
                flag2 = false;
            if(registerLegacyListener(128, 3, sensorlistener, i, j) || flag2)
                flag3 = true;
            else
                flag3 = false;
            if(registerLegacyListener(1, 3, sensorlistener, i, j) || flag3)
                flag4 = true;
            else
                flag4 = false;
            if(registerLegacyListener(4, 7, sensorlistener, i, j) || flag4)
                flag5 = true;
            else
                flag5 = false;
            flag = flag5;
        }
        return flag;
    }

    public void unregisterListener(SensorListener sensorlistener, int i) {
        if(sensorlistener != null) {
            unregisterLegacyListener(2, 1, sensorlistener, i);
            unregisterLegacyListener(8, 2, sensorlistener, i);
            unregisterLegacyListener(128, 3, sensorlistener, i);
            unregisterLegacyListener(1, 3, sensorlistener, i);
            unregisterLegacyListener(4, 7, sensorlistener, i);
        }
    }

    private static boolean sInitialized;
    private static int sRotation = 0;
    private static IWindowManager sWindowManager;
    private final HashMap mLegacyListenersMap;
    private final SensorManager mSensorManager;

}
