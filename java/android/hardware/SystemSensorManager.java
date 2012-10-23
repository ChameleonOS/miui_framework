// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;

import android.os.*;
import android.util.*;
import java.util.*;

// Referenced classes of package android.hardware:
//            SensorManager, Sensor, SensorEventListener, SensorEvent

public class SystemSensorManager extends SensorManager {
    private class ListenerDelegate {

        void addSensor(Sensor sensor) {
            mSensors.put(sensor.getHandle(), true);
            mSensorList.add(sensor);
        }

        Object getListener() {
            return mSensorEventListener;
        }

        List getSensors() {
            return mSensorList;
        }

        boolean hasSensor(Sensor sensor) {
            return mSensors.get(sensor.getHandle());
        }

        void onSensorChangedLocked(Sensor sensor, float af[], long al[], int i) {
            SensorEvent sensorevent = SystemSensorManager.sPool.getFromPool();
            float af1[] = sensorevent.values;
            af1[0] = af[0];
            af1[1] = af[1];
            af1[2] = af[2];
            sensorevent.timestamp = al[0];
            sensorevent.accuracy = i;
            sensorevent.sensor = sensor;
            Message message = Message.obtain();
            message.what = 0;
            message.obj = sensorevent;
            message.setAsynchronous(true);
            mHandler.sendMessage(message);
        }

        int removeSensor(Sensor sensor) {
            mSensors.delete(sensor.getHandle());
            mSensorList.remove(sensor);
            return mSensors.size();
        }

        public SparseBooleanArray mFirstEvent;
        private final Handler mHandler;
        public SparseIntArray mSensorAccuracies;
        private final SensorEventListener mSensorEventListener;
        private final ArrayList mSensorList = new ArrayList();
        public SparseBooleanArray mSensors;
        final SystemSensorManager this$0;


        ListenerDelegate(SensorEventListener sensoreventlistener, Sensor sensor, Handler handler) {
            this$0 = SystemSensorManager.this;
            super();
            mSensors = new SparseBooleanArray();
            mFirstEvent = new SparseBooleanArray();
            mSensorAccuracies = new SparseIntArray();
            mSensorEventListener = sensoreventlistener;
            final Looper final_looper;
            if(handler != null)
                final_looper = handler.getLooper();
            else
                final_looper = mMainLooper;
            mHandler = new Handler(SystemSensorManager.this) {

                public void handleMessage(Message message) {
                    SensorEvent sensorevent;
                    int i;
                    sensorevent = (SensorEvent)message.obj;
                    i = sensorevent.sensor.getHandle();
                    sensorevent.sensor.getType();
                    JVM INSTR tableswitch 2 3: default 44
                //                               2 108
                //                               3 108;
                       goto _L1 _L2 _L2
_L1:
                    if(!mFirstEvent.get(i)) {
                        mFirstEvent.put(i, true);
                        mSensorEventListener.onAccuracyChanged(sensorevent.sensor, 3);
                    }
_L4:
                    mSensorEventListener.onSensorChanged(sensorevent);
                    SystemSensorManager.sPool.returnToPool(sensorevent);
                    return;
_L2:
                    int j = mSensorAccuracies.get(i);
                    if(sensorevent.accuracy >= 0 && j != sensorevent.accuracy) {
                        mSensorAccuracies.put(i, sensorevent.accuracy);
                        mSensorEventListener.onAccuracyChanged(sensorevent.sensor, sensorevent.accuracy);
                    }
                    if(true) goto _L4; else goto _L3
_L3:
                }

                final ListenerDelegate this$1;
                final SystemSensorManager val$this$0;

                 {
                    this$1 = ListenerDelegate.this;
                    this$0 = systemsensormanager;
                    super(final_looper);
                }
            };
            addSensor(sensor);
        }
    }

    private static class SensorThread {
        private class SensorThreadRunnable
            implements Runnable {

            private boolean open() {
                SystemSensorManager.sQueue = SystemSensorManager.sensors_create_queue();
                return true;
            }

            public void run() {
                float af[];
                int ai[];
                long al[];
                af = new float[3];
                ai = new int[1];
                al = new long[1];
                Process.setThreadPriority(-8);
                if(open()) goto _L2; else goto _L1
_L1:
                return;
_L2:
                this;
                JVM INSTR monitorenter ;
                mSensorsReady = true;
                notify();
                this;
                JVM INSTR monitorexit ;
_L7:
                int i;
                int j;
                i = SystemSensorManager.sensors_data_poll(SystemSensorManager.sQueue, af, ai, al);
                j = ai[0];
                ArrayList arraylist = SystemSensorManager.sListeners;
                arraylist;
                JVM INSTR monitorenter ;
                if(i != -1 && !SystemSensorManager.sListeners.isEmpty())
                    break MISSING_BLOCK_LABEL_163;
                if(i == -1 && !SystemSensorManager.sListeners.isEmpty())
                    Log.e("SensorManager", (new StringBuilder()).append("_sensors_data_poll() failed, we bail out: sensors=").append(i).toString());
                SystemSensorManager.sensors_destroy_queue(SystemSensorManager.sQueue);
                SystemSensorManager.sQueue = 0;
                mThread = null;
                  goto _L1
                Exception exception1;
                exception1;
                throw exception1;
                Exception exception;
                exception;
                this;
                JVM INSTR monitorexit ;
                throw exception;
                Sensor sensor = (Sensor)SystemSensorManager.sHandleToSensor.get(i);
                if(sensor == null) goto _L4; else goto _L3
_L3:
                int k;
                int l;
                k = SystemSensorManager.sListeners.size();
                l = 0;
_L8:
                if(l >= k) goto _L4; else goto _L5
_L5:
                ListenerDelegate listenerdelegate = (ListenerDelegate)SystemSensorManager.sListeners.get(l);
                if(listenerdelegate.hasSensor(sensor))
                    listenerdelegate.onSensorChangedLocked(sensor, af, al, j);
                  goto _L6
_L4:
                arraylist;
                JVM INSTR monitorexit ;
                  goto _L7
_L6:
                l++;
                  goto _L8
            }

            final SensorThread this$0;

            SensorThreadRunnable() {
                this$0 = SensorThread.this;
                super();
            }
        }


        protected void finalize() {
        }

        boolean startLocked() {
            boolean flag = false;
            if(mThread != null) goto _L2; else goto _L1
_L1:
            SensorThreadRunnable sensorthreadrunnable;
            Thread thread;
            mSensorsReady = false;
            sensorthreadrunnable = new SensorThreadRunnable();
            thread = new Thread(sensorthreadrunnable, android/hardware/SystemSensorManager$SensorThread.getName());
            thread.start();
            sensorthreadrunnable;
            JVM INSTR monitorenter ;
            while(!mSensorsReady) 
                sensorthreadrunnable.wait();
              goto _L3
            Exception exception;
            exception;
            try {
                throw exception;
            }
            catch(InterruptedException interruptedexception) { }
_L2:
            if(mThread != null)
                flag = true;
            return flag;
_L3:
            sensorthreadrunnable;
            JVM INSTR monitorexit ;
            mThread = thread;
              goto _L2
        }

        boolean mSensorsReady;
        Thread mThread;

        SensorThread() {
        }
    }


    public SystemSensorManager(Looper looper) {
        mMainLooper = looper;
        ArrayList arraylist = sListeners;
        arraylist;
        JVM INSTR monitorenter ;
        if(!sSensorModuleInitialized) {
            sSensorModuleInitialized = true;
            nativeClassInit();
            sensors_module_init();
            ArrayList arraylist1 = sFullSensorsList;
            int i = 0;
            do {
                Sensor sensor = new Sensor();
                i = sensors_module_get_next_sensor(sensor, i);
                if(i >= 0) {
                    arraylist1.add(sensor);
                    sHandleToSensor.append(sensor.getHandle(), sensor);
                }
            } while(i > 0);
            sPool = new SensorManager.SensorEventPool(2 * sFullSensorsList.size());
            sSensorThread = new SensorThread();
        }
        return;
    }

    private boolean disableSensorLocked(Sensor sensor) {
        Iterator iterator = sListeners.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if(!((ListenerDelegate)iterator.next()).hasSensor(sensor)) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        return flag;
_L2:
        String s = sensor.getName();
        int i = sensor.getHandle();
        flag = sensors_enable_sensor(sQueue, s, i, -1);
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean enableSensorLocked(Sensor sensor, int i) {
        boolean flag = false;
        Iterator iterator = sListeners.iterator();
        do {
            if(!iterator.hasNext())
                break;
            if(!((ListenerDelegate)iterator.next()).hasSensor(sensor))
                continue;
            String s = sensor.getName();
            int j = sensor.getHandle();
            flag = sensors_enable_sensor(sQueue, s, j, i);
            break;
        } while(true);
        return flag;
    }

    private static native void nativeClassInit();

    static native int sensors_create_queue();

    static native int sensors_data_poll(int i, float af[], int ai[], long al[]);

    static native void sensors_destroy_queue(int i);

    static native boolean sensors_enable_sensor(int i, String s, int j, int k);

    private static native int sensors_module_get_next_sensor(Sensor sensor, int i);

    private static native int sensors_module_init();

    protected List getFullSensorList() {
        return sFullSensorsList;
    }

    protected boolean registerListenerImpl(SensorEventListener sensoreventlistener, Sensor sensor, int i, Handler handler) {
        boolean flag = true;
        ArrayList arraylist = sListeners;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = sListeners.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ListenerDelegate listenerdelegate2;
        Object obj;
        listenerdelegate2 = (ListenerDelegate)iterator.next();
        obj = listenerdelegate2.getListener();
        if(obj != sensoreventlistener) goto _L4; else goto _L3
_L3:
        ListenerDelegate listenerdelegate = listenerdelegate2;
_L17:
        if(listenerdelegate != null) goto _L6; else goto _L5
_L5:
        ListenerDelegate listenerdelegate1 = new ListenerDelegate(sensoreventlistener, sensor, handler);
        sListeners.add(listenerdelegate1);
        if(sListeners.isEmpty()) goto _L8; else goto _L7
_L7:
        if(!sSensorThread.startLocked()) goto _L10; else goto _L9
_L9:
        if(!enableSensorLocked(sensor, i)) {
            sListeners.remove(listenerdelegate1);
            flag = false;
        }
_L11:
        arraylist;
        JVM INSTR monitorexit ;
        return flag;
_L10:
        sListeners.remove(listenerdelegate1);
        flag = false;
          goto _L11
_L8:
        flag = false;
          goto _L11
_L6:
        if(listenerdelegate.hasSensor(sensor)) goto _L13; else goto _L12
_L12:
        listenerdelegate.addSensor(sensor);
        if(enableSensorLocked(sensor, i)) goto _L13; else goto _L14
_L14:
        listenerdelegate.removeSensor(sensor);
        flag = false;
        listenerdelegate;
          goto _L11
        Exception exception;
        exception;
_L15:
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        listenerdelegate;
        if(true) goto _L15; else goto _L13
_L13:
        listenerdelegate;
          goto _L11
_L2:
        listenerdelegate = null;
        if(true) goto _L17; else goto _L16
_L16:
    }

    protected void unregisterListenerImpl(SensorEventListener sensoreventlistener, Sensor sensor) {
        ArrayList arraylist = sListeners;
        arraylist;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = sListeners.size();
        j = 0;
_L2:
        ListenerDelegate listenerdelegate;
        if(j >= i)
            break MISSING_BLOCK_LABEL_130;
        listenerdelegate = (ListenerDelegate)sListeners.get(j);
        if(listenerdelegate.getListener() != sensoreventlistener)
            break MISSING_BLOCK_LABEL_133;
        if(sensor == null) {
            sListeners.remove(j);
            for(Iterator iterator = listenerdelegate.getSensors().iterator(); iterator.hasNext(); disableSensorLocked((Sensor)iterator.next()));
            break MISSING_BLOCK_LABEL_130;
        }
        break MISSING_BLOCK_LABEL_106;
        Exception exception;
        exception;
        throw exception;
        if(listenerdelegate.removeSensor(sensor) == 0) {
            sListeners.remove(j);
            disableSensorLocked(sensor);
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        j++;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final int SENSOR_DISABLE = -1;
    private static ArrayList sFullSensorsList = new ArrayList();
    static SparseArray sHandleToSensor = new SparseArray();
    static final ArrayList sListeners = new ArrayList();
    static SensorManager.SensorEventPool sPool;
    private static int sQueue;
    private static boolean sSensorModuleInitialized = false;
    private static SensorThread sSensorThread;
    final Looper mMainLooper;




/*
    static int access$002(int i) {
        sQueue = i;
        return i;
    }

*/
}
