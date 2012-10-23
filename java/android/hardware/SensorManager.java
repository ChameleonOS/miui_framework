// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;

import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import java.util.*;

// Referenced classes of package android.hardware:
//            LegacySensorManager, Sensor, SensorEventListener, SensorListener, 
//            SensorEvent

public abstract class SensorManager {
    protected static final class SensorEventPool {

        private SensorEvent createSensorEvent() {
            return new SensorEvent(3);
        }

        SensorEvent getFromPool() {
            SensorEvent sensorevent = null;
            this;
            JVM INSTR monitorenter ;
            if(mNumItemsInPool > 0) {
                int i = mPoolSize - mNumItemsInPool;
                sensorevent = mPool[i];
                mPool[i] = null;
                mNumItemsInPool = -1 + mNumItemsInPool;
            }
            this;
            JVM INSTR monitorexit ;
            if(sensorevent == null)
                sensorevent = createSensorEvent();
            return sensorevent;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        void returnToPool(SensorEvent sensorevent) {
            this;
            JVM INSTR monitorenter ;
            if(mNumItemsInPool < mPoolSize) {
                mNumItemsInPool = 1 + mNumItemsInPool;
                int i = mPoolSize - mNumItemsInPool;
                mPool[i] = sensorevent;
            }
            return;
        }

        private int mNumItemsInPool;
        private final SensorEvent mPool[];
        private final int mPoolSize;

        SensorEventPool(int i) {
            mPoolSize = i;
            mNumItemsInPool = i;
            mPool = new SensorEvent[i];
        }
    }


    public SensorManager() {
    }

    public static float getAltitude(float f, float f1) {
        return 44330F * (1.0F - (float)Math.pow(f1 / f, 0.19029495120048523D));
    }

    public static void getAngleChange(float af[], float af1[], float af2[]) {
        float f = 0.0F;
        float f1 = 0.0F;
        float f2 = 0.0F;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        float f7 = 0.0F;
        float f8 = 0.0F;
        float f9 = 0.0F;
        float f10 = 0.0F;
        float f11 = 0.0F;
        float f12 = 0.0F;
        float f13 = 0.0F;
        float f14 = 0.0F;
        float f15 = 0.0F;
        float f16 = 0.0F;
        float f17 = 0.0F;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        if(af1.length == 9) {
            f = af1[0];
            f1 = af1[1];
            f2 = af1[2];
            f3 = af1[3];
            f4 = af1[4];
            f5 = af1[5];
            f6 = af1[6];
            f7 = af1[7];
            f8 = af1[8];
        } else
        if(af1.length == 16) {
            f = af1[0];
            f1 = af1[1];
            f2 = af1[2];
            f3 = af1[4];
            f4 = af1[5];
            f5 = af1[6];
            f6 = af1[8];
            f7 = af1[9];
            f8 = af1[10];
        }
        if(af2.length == 9) {
            f9 = af2[0];
            f10 = af2[1];
            f11 = af2[2];
            f12 = af2[3];
            f13 = af2[4];
            f14 = af2[5];
            f15 = af2[6];
            f16 = af2[7];
            f17 = af2[8];
        } else
        if(af2.length == 16) {
            f9 = af2[0];
            f10 = af2[1];
            f11 = af2[2];
            f12 = af2[4];
            f13 = af2[5];
            f14 = af2[6];
            f15 = af2[8];
            f16 = af2[9];
            f17 = af2[10];
        }
        f18 = f9 * f1 + f12 * f4 + f15 * f7;
        f19 = f10 * f1 + f13 * f4 + f16 * f7;
        f20 = f11 * f + f14 * f3 + f17 * f6;
        f21 = f11 * f1 + f14 * f4 + f17 * f7;
        f22 = f11 * f2 + f14 * f5 + f17 * f8;
        af[0] = (float)Math.atan2(f18, f19);
        af[1] = (float)Math.asin(-f21);
        af[2] = (float)Math.atan2(-f20, f22);
    }

    public static float getInclination(float af[]) {
        float f;
        if(af.length == 9)
            f = (float)Math.atan2(af[5], af[4]);
        else
            f = (float)Math.atan2(af[6], af[5]);
        return f;
    }

    private LegacySensorManager getLegacySensorManager() {
        SparseArray sparsearray = mSensorListByType;
        sparsearray;
        JVM INSTR monitorenter ;
        if(mLegacySensorManager == null) {
            Log.i("SensorManager", "This application is using deprecated SensorManager API which will be removed someday.  Please consider switching to the new API.");
            mLegacySensorManager = new LegacySensorManager(this);
        }
        LegacySensorManager legacysensormanager = mLegacySensorManager;
        return legacysensormanager;
    }

    public static float[] getOrientation(float af[], float af1[]) {
        if(af.length == 9) {
            af1[0] = (float)Math.atan2(af[1], af[4]);
            af1[1] = (float)Math.asin(-af[7]);
            af1[2] = (float)Math.atan2(-af[6], af[8]);
        } else {
            af1[0] = (float)Math.atan2(af[1], af[5]);
            af1[1] = (float)Math.asin(-af[9]);
            af1[2] = (float)Math.atan2(-af[8], af[10]);
        }
        return af1;
    }

    public static void getQuaternionFromVector(float af[], float af1[]) {
        float f = 0.0F;
        if(af1.length == 4) {
            af[0] = af1[3];
        } else {
            af[0] = 1.0F - af1[0] * af1[0] - af1[1] * af1[1] - af1[2] * af1[2];
            if(af[0] > 0.0F)
                f = (float)Math.sqrt(af[0]);
            af[0] = f;
        }
        af[1] = af1[0];
        af[2] = af1[1];
        af[3] = af1[2];
    }

    public static boolean getRotationMatrix(float af[], float af1[], float af2[], float af3[]) {
        float f;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        f = af2[0];
        f1 = af2[1];
        f2 = af2[2];
        f3 = af3[0];
        f4 = af3[1];
        f5 = af3[2];
        f6 = f4 * f2 - f5 * f1;
        f7 = f5 * f - f3 * f2;
        f8 = f3 * f1 - f4 * f;
        f9 = (float)Math.sqrt(f6 * f6 + f7 * f7 + f8 * f8);
        if(f9 >= 0.1F) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        float f22;
        float f23;
        float f10 = 1.0F / f9;
        float f11 = f6 * f10;
        float f12 = f7 * f10;
        float f13 = f8 * f10;
        float f14 = 1.0F / (float)Math.sqrt(f * f + f1 * f1 + f2 * f2);
        float f15 = f * f14;
        float f16 = f1 * f14;
        float f17 = f2 * f14;
        float f18 = f16 * f13 - f17 * f12;
        float f19 = f17 * f11 - f15 * f13;
        float f20 = f15 * f12 - f16 * f11;
        if(af != null)
            if(af.length == 9) {
                af[0] = f11;
                af[1] = f12;
                af[2] = f13;
                af[3] = f18;
                af[4] = f19;
                af[5] = f20;
                af[6] = f15;
                af[7] = f16;
                af[8] = f17;
            } else
            if(af.length == 16) {
                af[0] = f11;
                af[1] = f12;
                af[2] = f13;
                af[3] = 0.0F;
                af[4] = f18;
                af[5] = f19;
                af[6] = f20;
                af[7] = 0.0F;
                af[8] = f15;
                af[9] = f16;
                af[10] = f17;
                af[11] = 0.0F;
                af[12] = 0.0F;
                af[13] = 0.0F;
                af[14] = 0.0F;
                af[15] = 1.0F;
            }
        if(af1 != null) {
            float f21 = 1.0F / (float)Math.sqrt(f3 * f3 + f4 * f4 + f5 * f5);
            f22 = f21 * (f3 * f18 + f4 * f19 + f5 * f20);
            f23 = f21 * (f3 * f15 + f4 * f16 + f5 * f17);
            if(af1.length != 9)
                break; /* Loop/switch isn't completed */
            af1[0] = 1.0F;
            af1[1] = 0.0F;
            af1[2] = 0.0F;
            af1[3] = 0.0F;
            af1[4] = f22;
            af1[5] = f23;
            af1[6] = 0.0F;
            af1[7] = -f23;
            af1[8] = f22;
        }
_L6:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        if(af1.length != 16) goto _L6; else goto _L5
_L5:
        af1[0] = 1.0F;
        af1[1] = 0.0F;
        af1[2] = 0.0F;
        af1[4] = 0.0F;
        af1[5] = f22;
        af1[6] = f23;
        af1[8] = 0.0F;
        af1[9] = -f23;
        af1[10] = f22;
        af1[14] = 0.0F;
        af1[13] = 0.0F;
        af1[12] = 0.0F;
        af1[11] = 0.0F;
        af1[7] = 0.0F;
        af1[3] = 0.0F;
        af1[15] = 1.0F;
          goto _L6
    }

    public static void getRotationMatrixFromVector(float af[], float af1[]) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f = af1[0];
        float f1 = af1[1];
        float f2 = af1[2];
        float f4;
        if(af1.length == 4) {
            f4 = af1[3];
        } else {
            float f3 = 1.0F - f * f - f1 * f1 - f2 * f2;
            if(f3 > 0.0F)
                f4 = (float)Math.sqrt(f3);
            else
                f4 = 0.0F;
        }
        f5 = f * (2.0F * f);
        f6 = f1 * (2.0F * f1);
        f7 = f2 * (2.0F * f2);
        f8 = f1 * (2.0F * f);
        f9 = f4 * (2.0F * f2);
        f10 = f2 * (2.0F * f);
        f11 = f4 * (2.0F * f1);
        f12 = f2 * (2.0F * f1);
        f13 = f4 * (2.0F * f);
        if(af.length != 9) goto _L2; else goto _L1
_L1:
        af[0] = 1.0F - f6 - f7;
        af[1] = f8 - f9;
        af[2] = f10 + f11;
        af[3] = f8 + f9;
        af[4] = 1.0F - f5 - f7;
        af[5] = f12 - f13;
        af[6] = f10 - f11;
        af[7] = f12 + f13;
        af[8] = 1.0F - f5 - f6;
_L4:
        return;
_L2:
        if(af.length == 16) {
            af[0] = 1.0F - f6 - f7;
            af[1] = f8 - f9;
            af[2] = f10 + f11;
            af[3] = 0.0F;
            af[4] = f8 + f9;
            af[5] = 1.0F - f5 - f7;
            af[6] = f12 - f13;
            af[7] = 0.0F;
            af[8] = f10 - f11;
            af[9] = f12 + f13;
            af[10] = 1.0F - f5 - f6;
            af[11] = 0.0F;
            af[14] = 0.0F;
            af[13] = 0.0F;
            af[12] = 0.0F;
            af[15] = 1.0F;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean remapCoordinateSystem(float af[], int i, int j, float af1[]) {
        boolean flag;
        if(af == af1)
            synchronized(mTempMatrix) {
                if(remapCoordinateSystemImpl(af, i, j, af2)) {
                    int k = af1.length;
                    for(int l = 0; l < k; l++)
                        af1[l] = af2[l];

                    flag = true;
                    break MISSING_BLOCK_LABEL_85;
                }
            }
        flag = remapCoordinateSystemImpl(af, i, j, af1);
        break MISSING_BLOCK_LABEL_85;
        exception;
        af2;
        JVM INSTR monitorexit ;
        throw exception;
        return flag;
    }

    private static boolean remapCoordinateSystemImpl(float af[], int i, int j, float af1[]) {
        int k = af1.length;
        boolean flag;
        if(af.length != k)
            flag = false;
        else
        if((i & 0x7c) != 0 || (j & 0x7c) != 0)
            flag = false;
        else
        if((i & 3) == 0 || (j & 3) == 0)
            flag = false;
        else
        if((i & 3) == (j & 3)) {
            flag = false;
        } else {
            int l = i ^ j;
            int i1 = -1 + (i & 3);
            int j1 = -1 + (j & 3);
            int k1 = -1 + (l & 3);
            int l1 = (k1 + 1) % 3;
            int i2 = (k1 + 2) % 3;
            if((i1 ^ l1 | j1 ^ i2) != 0)
                l ^= 0x80;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            byte byte0;
            int j2;
            if(i >= 128)
                flag1 = true;
            else
                flag1 = false;
            if(j >= 128)
                flag2 = true;
            else
                flag2 = false;
            if(l >= 128)
                flag3 = true;
            else
                flag3 = false;
            if(k == 16)
                byte0 = 4;
            else
                byte0 = 3;
            for(j2 = 0; j2 < 3; j2++) {
                int k2 = j2 * byte0;
                int l2 = 0;
                while(l2 < 3)  {
                    if(i1 == l2) {
                        int k3 = k2 + l2;
                        int i3;
                        int j3;
                        float f2;
                        if(flag1)
                            f2 = -af[k2 + 0];
                        else
                            f2 = af[k2 + 0];
                        af1[k3] = f2;
                    }
                    if(j1 == l2) {
                        j3 = k2 + l2;
                        float f1;
                        if(flag2)
                            f1 = -af[k2 + 1];
                        else
                            f1 = af[k2 + 1];
                        af1[j3] = f1;
                    }
                    if(k1 == l2) {
                        i3 = k2 + l2;
                        float f;
                        if(flag3)
                            f = -af[k2 + 2];
                        else
                            f = af[k2 + 2];
                        af1[i3] = f;
                    }
                    l2++;
                }
            }

            if(k == 16) {
                af1[14] = 0.0F;
                af1[13] = 0.0F;
                af1[12] = 0.0F;
                af1[11] = 0.0F;
                af1[7] = 0.0F;
                af1[3] = 0.0F;
                af1[15] = 1.0F;
            }
            flag = true;
        }
        return flag;
    }

    public Sensor getDefaultSensor(int i) {
        List list = getSensorList(i);
        Sensor sensor;
        if(list.isEmpty())
            sensor = null;
        else
            sensor = (Sensor)list.get(0);
        return sensor;
    }

    protected abstract List getFullSensorList();

    public List getSensorList(int i) {
        List list = getFullSensorList();
        SparseArray sparsearray = mSensorListByType;
        sparsearray;
        JVM INSTR monitorenter ;
        List list1 = (List)mSensorListByType.get(i);
        if(list1 == null) {
            Object obj;
            if(i == -1) {
                obj = list;
            } else {
                obj = new ArrayList();
                Iterator iterator = list.iterator();
                while(iterator.hasNext())  {
                    Sensor sensor = (Sensor)iterator.next();
                    if(sensor.getType() == i)
                        ((List) (obj)).add(sensor);
                }
            }
            list1 = Collections.unmodifiableList(((List) (obj)));
            mSensorListByType.append(i, list1);
        }
        return list1;
    }

    public int getSensors() {
        return getLegacySensorManager().getSensors();
    }

    public boolean registerListener(SensorEventListener sensoreventlistener, Sensor sensor, int i) {
        return registerListener(sensoreventlistener, sensor, i, null);
    }

    public boolean registerListener(SensorEventListener sensoreventlistener, Sensor sensor, int i, Handler handler) {
        if(sensoreventlistener != null && sensor != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L9:
        return flag;
_L2:
        i;
        JVM INSTR tableswitch 0 3: default 44
    //                   0 62
    //                   1 68
    //                   2 76
    //                   3 83;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_83;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        int j = i;
_L10:
        flag = registerListenerImpl(sensoreventlistener, sensor, j, handler);
        if(true) goto _L9; else goto _L8
_L8:
        j = 0;
          goto _L10
_L5:
        j = 20000;
          goto _L10
_L6:
        j = 0x1046b;
          goto _L10
        j = 0x30d40;
          goto _L10
    }

    public boolean registerListener(SensorListener sensorlistener, int i) {
        return registerListener(sensorlistener, i, 3);
    }

    public boolean registerListener(SensorListener sensorlistener, int i, int j) {
        return getLegacySensorManager().registerListener(sensorlistener, i, j);
    }

    protected abstract boolean registerListenerImpl(SensorEventListener sensoreventlistener, Sensor sensor, int i, Handler handler);

    public void unregisterListener(SensorEventListener sensoreventlistener) {
        if(sensoreventlistener != null)
            unregisterListenerImpl(sensoreventlistener, null);
    }

    public void unregisterListener(SensorEventListener sensoreventlistener, Sensor sensor) {
        if(sensoreventlistener != null && sensor != null)
            unregisterListenerImpl(sensoreventlistener, sensor);
    }

    public void unregisterListener(SensorListener sensorlistener) {
        unregisterListener(sensorlistener, 255);
    }

    public void unregisterListener(SensorListener sensorlistener, int i) {
        getLegacySensorManager().unregisterListener(sensorlistener, i);
    }

    protected abstract void unregisterListenerImpl(SensorEventListener sensoreventlistener, Sensor sensor);

    public static final int AXIS_MINUS_X = 129;
    public static final int AXIS_MINUS_Y = 130;
    public static final int AXIS_MINUS_Z = 131;
    public static final int AXIS_X = 1;
    public static final int AXIS_Y = 2;
    public static final int AXIS_Z = 3;
    public static final int DATA_X = 0;
    public static final int DATA_Y = 1;
    public static final int DATA_Z = 2;
    public static final float GRAVITY_DEATH_STAR_I = 3.530361E-07F;
    public static final float GRAVITY_EARTH = 9.80665F;
    public static final float GRAVITY_JUPITER = 23.12F;
    public static final float GRAVITY_MARS = 3.71F;
    public static final float GRAVITY_MERCURY = 3.7F;
    public static final float GRAVITY_MOON = 1.6F;
    public static final float GRAVITY_NEPTUNE = 11F;
    public static final float GRAVITY_PLUTO = 0.6F;
    public static final float GRAVITY_SATURN = 8.96F;
    public static final float GRAVITY_SUN = 275F;
    public static final float GRAVITY_THE_ISLAND = 4.815162F;
    public static final float GRAVITY_URANUS = 8.69F;
    public static final float GRAVITY_VENUS = 8.87F;
    public static final float LIGHT_CLOUDY = 100F;
    public static final float LIGHT_FULLMOON = 0.25F;
    public static final float LIGHT_NO_MOON = 0.001F;
    public static final float LIGHT_OVERCAST = 10000F;
    public static final float LIGHT_SHADE = 20000F;
    public static final float LIGHT_SUNLIGHT = 110000F;
    public static final float LIGHT_SUNLIGHT_MAX = 120000F;
    public static final float LIGHT_SUNRISE = 400F;
    public static final float MAGNETIC_FIELD_EARTH_MAX = 60F;
    public static final float MAGNETIC_FIELD_EARTH_MIN = 30F;
    public static final float PRESSURE_STANDARD_ATMOSPHERE = 1013.25F;
    public static final int RAW_DATA_INDEX = 3;
    public static final int RAW_DATA_X = 3;
    public static final int RAW_DATA_Y = 4;
    public static final int RAW_DATA_Z = 5;
    public static final int SENSOR_ACCELEROMETER = 2;
    public static final int SENSOR_ALL = 127;
    public static final int SENSOR_DELAY_FASTEST = 0;
    public static final int SENSOR_DELAY_GAME = 1;
    public static final int SENSOR_DELAY_NORMAL = 3;
    public static final int SENSOR_DELAY_UI = 2;
    public static final int SENSOR_LIGHT = 16;
    public static final int SENSOR_MAGNETIC_FIELD = 8;
    public static final int SENSOR_MAX = 64;
    public static final int SENSOR_MIN = 1;
    public static final int SENSOR_ORIENTATION = 1;
    public static final int SENSOR_ORIENTATION_RAW = 128;
    public static final int SENSOR_PROXIMITY = 32;
    public static final int SENSOR_STATUS_ACCURACY_HIGH = 3;
    public static final int SENSOR_STATUS_ACCURACY_LOW = 1;
    public static final int SENSOR_STATUS_ACCURACY_MEDIUM = 2;
    public static final int SENSOR_STATUS_UNRELIABLE = 0;
    public static final int SENSOR_TEMPERATURE = 4;
    public static final int SENSOR_TRICORDER = 64;
    public static final float STANDARD_GRAVITY = 9.80665F;
    protected static final String TAG = "SensorManager";
    private static final float mTempMatrix[] = new float[16];
    private LegacySensorManager mLegacySensorManager;
    private final SparseArray mSensorListByType = new SparseArray();

}
