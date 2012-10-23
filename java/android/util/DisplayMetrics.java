// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import android.os.SystemProperties;

public class DisplayMetrics {

    public DisplayMetrics() {
    }

    private static int getDeviceDensity() {
        return SystemProperties.getInt("qemu.sf.lcd_density", SystemProperties.getInt("ro.sf.lcd_density", 160));
    }

    public void setTo(DisplayMetrics displaymetrics) {
        widthPixels = displaymetrics.widthPixels;
        heightPixels = displaymetrics.heightPixels;
        density = displaymetrics.density;
        densityDpi = displaymetrics.densityDpi;
        scaledDensity = displaymetrics.scaledDensity;
        xdpi = displaymetrics.xdpi;
        ydpi = displaymetrics.ydpi;
        noncompatWidthPixels = displaymetrics.noncompatWidthPixels;
        noncompatHeightPixels = displaymetrics.noncompatHeightPixels;
        noncompatDensity = displaymetrics.noncompatDensity;
        noncompatScaledDensity = displaymetrics.noncompatScaledDensity;
        noncompatXdpi = displaymetrics.noncompatXdpi;
        noncompatYdpi = displaymetrics.noncompatYdpi;
    }

    public void setToDefaults() {
        widthPixels = 0;
        heightPixels = 0;
        density = (float)DENSITY_DEVICE / 160F;
        densityDpi = DENSITY_DEVICE;
        scaledDensity = density;
        xdpi = DENSITY_DEVICE;
        ydpi = DENSITY_DEVICE;
        noncompatWidthPixels = 0;
        noncompatHeightPixels = 0;
    }

    public String toString() {
        return (new StringBuilder()).append("DisplayMetrics{density=").append(density).append(", width=").append(widthPixels).append(", height=").append(heightPixels).append(", scaledDensity=").append(scaledDensity).append(", xdpi=").append(xdpi).append(", ydpi=").append(ydpi).append("}").toString();
    }

    public static final int DENSITY_DEFAULT = 160;
    public static final int DENSITY_DEVICE = 0;
    public static final int DENSITY_HIGH = 240;
    public static final int DENSITY_LOW = 120;
    public static final int DENSITY_MEDIUM = 160;
    public static final int DENSITY_TV = 213;
    public static final int DENSITY_XHIGH = 320;
    public static final int DENSITY_XXHIGH = 480;
    public float density;
    public int densityDpi;
    public int heightPixels;
    public float noncompatDensity;
    public int noncompatHeightPixels;
    public float noncompatScaledDensity;
    public int noncompatWidthPixels;
    public float noncompatXdpi;
    public float noncompatYdpi;
    public float scaledDensity;
    public int widthPixels;
    public float xdpi;
    public float ydpi;

    static  {
        DENSITY_DEVICE = getDeviceDensity();
    }
}
