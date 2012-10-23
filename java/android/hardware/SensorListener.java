// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;


public interface SensorListener {

    public abstract void onAccuracyChanged(int i, int j);

    public abstract void onSensorChanged(int i, float af[]);
}
