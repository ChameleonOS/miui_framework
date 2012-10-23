// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;


// Referenced classes of package android.hardware:
//            Sensor, SensorEvent

public interface SensorEventListener {

    public abstract void onAccuracyChanged(Sensor sensor, int i);

    public abstract void onSensorChanged(SensorEvent sensorevent);
}
