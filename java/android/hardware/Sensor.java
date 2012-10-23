// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;


public class Sensor {

    Sensor() {
    }

    int getHandle() {
        return mHandle;
    }

    public float getMaximumRange() {
        return mMaxRange;
    }

    public int getMinDelay() {
        return mMinDelay;
    }

    public String getName() {
        return mName;
    }

    public float getPower() {
        return mPower;
    }

    public float getResolution() {
        return mResolution;
    }

    public int getType() {
        return mType;
    }

    public String getVendor() {
        return mVendor;
    }

    public int getVersion() {
        return mVersion;
    }

    void setRange(float f, float f1) {
        mMaxRange = f;
        mResolution = f1;
    }

    public static final int TYPE_ACCELEROMETER = 1;
    public static final int TYPE_ALL = -1;
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
    public static final int TYPE_GRAVITY = 9;
    public static final int TYPE_GYROSCOPE = 4;
    public static final int TYPE_LIGHT = 5;
    public static final int TYPE_LINEAR_ACCELERATION = 10;
    public static final int TYPE_MAGNETIC_FIELD = 2;
    public static final int TYPE_ORIENTATION = 3;
    public static final int TYPE_PRESSURE = 6;
    public static final int TYPE_PROXIMITY = 8;
    public static final int TYPE_RELATIVE_HUMIDITY = 12;
    public static final int TYPE_ROTATION_VECTOR = 11;
    public static final int TYPE_TEMPERATURE = 7;
    private int mHandle;
    private float mMaxRange;
    private int mMinDelay;
    private String mName;
    private float mPower;
    private float mResolution;
    private int mType;
    private String mVendor;
    private int mVersion;
}
