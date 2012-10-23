// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.res.CompatibilityInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.*;
import android.util.DisplayMetrics;
import android.util.Slog;

// Referenced classes of package android.view:
//            CompatibilityInfoHolder, IWindowManager

public class Display {

    Display(int i, CompatibilityInfoHolder compatibilityinfoholder) {
        mTmpPoint = new Point();
        mTmpMetrics = new DisplayMetrics();
        synchronized(sStaticInit) {
            if(!sInitialized) {
                nativeClassInit();
                sInitialized = true;
            }
        }
        if(compatibilityinfoholder == null)
            compatibilityinfoholder = new CompatibilityInfoHolder();
        mCompatibilityInfo = compatibilityinfoholder;
        mDisplay = i;
        init(i);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Display createCompatibleDisplay(int i, CompatibilityInfoHolder compatibilityinfoholder) {
        return new Display(i, compatibilityinfoholder);
    }

    static native int getDisplayCount();

    private native int getRawHeightNative();

    private native int getRawWidthNative();

    private void getSizeInternal(Point point, boolean flag) {
        CompatibilityInfo compatibilityinfo;
        IWindowManager iwindowmanager = getWindowManager();
        if(iwindowmanager == null)
            break MISSING_BLOCK_LABEL_136;
        iwindowmanager.getDisplaySize(point);
        if(!flag)
            break MISSING_BLOCK_LABEL_152;
        compatibilityinfo = mCompatibilityInfo.getIfNeeded();
        if(compatibilityinfo == null)
            break MISSING_BLOCK_LABEL_152;
        DisplayMetrics displaymetrics = mTmpMetrics;
        displaymetrics;
        JVM INSTR monitorenter ;
        mTmpMetrics.noncompatWidthPixels = point.x;
        mTmpMetrics.noncompatHeightPixels = point.y;
        mTmpMetrics.density = mDensity;
        compatibilityinfo.applyToDisplayMetrics(mTmpMetrics);
        point.x = mTmpMetrics.widthPixels;
        point.y = mTmpMetrics.heightPixels;
        break MISSING_BLOCK_LABEL_152;
        RemoteException remoteexception;
        remoteexception;
        Slog.w("Display", "Unable to get display size", remoteexception);
        break MISSING_BLOCK_LABEL_152;
        point.x = getRawWidth();
        point.y = getRawHeight();
    }

    static IWindowManager getWindowManager() {
        Object obj = sStaticInit;
        obj;
        JVM INSTR monitorenter ;
        if(sWindowManager == null)
            sWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        IWindowManager iwindowmanager = sWindowManager;
        return iwindowmanager;
    }

    private native void init(int i);

    private static native void nativeClassInit();

    public void getCurrentSizeRange(Point point, Point point1) {
        getWindowManager().getCurrentSizeRange(point, point1);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Slog.w("Display", "Unable to get display size range", remoteexception);
        point.x = 0;
        point.y = 0;
        point1.x = 0;
        point1.y = 0;
          goto _L1
    }

    public int getDisplayId() {
        return mDisplay;
    }

    public int getExternalRotation() {
        return 0;
    }

    public int getHeight() {
        Point point = mTmpPoint;
        point;
        JVM INSTR monitorenter ;
        long l = SystemClock.uptimeMillis();
        if((float)l > 20F + mLastGetTime) {
            getSizeInternal(mTmpPoint, true);
            mLastGetTime = l;
        }
        int i = mTmpPoint.y;
        return i;
    }

    public int getMaximumSizeDimension() {
        int j = getWindowManager().getMaximumSizeDimension();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Slog.w("Display", "Unable to get display maximum size dimension", remoteexception);
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void getMetrics(DisplayMetrics displaymetrics) {
        synchronized(mTmpPoint) {
            getSizeInternal(mTmpPoint, false);
            getMetricsWithSize(displaymetrics, mTmpPoint.x, mTmpPoint.y);
        }
        CompatibilityInfo compatibilityinfo = mCompatibilityInfo.getIfNeeded();
        if(compatibilityinfo != null)
            compatibilityinfo.applyToDisplayMetrics(displaymetrics);
        return;
        exception;
        point;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void getMetricsWithSize(DisplayMetrics displaymetrics, int i, int j) {
        displaymetrics.densityDpi = (int)(0.5F + 160F * mDensity);
        displaymetrics.widthPixels = i;
        displaymetrics.noncompatWidthPixels = i;
        displaymetrics.heightPixels = j;
        displaymetrics.noncompatHeightPixels = j;
        float f = mDensity;
        displaymetrics.noncompatDensity = f;
        displaymetrics.density = f;
        float f1 = displaymetrics.density;
        displaymetrics.noncompatScaledDensity = f1;
        displaymetrics.scaledDensity = f1;
        float f2 = mDpiX;
        displaymetrics.noncompatXdpi = f2;
        displaymetrics.xdpi = f2;
        float f3 = mDpiY;
        displaymetrics.noncompatYdpi = f3;
        displaymetrics.ydpi = f3;
    }

    public native int getOrientation();

    public int getPixelFormat() {
        return mPixelFormat;
    }

    public int getRawExternalHeight() {
        return 720;
    }

    public int getRawExternalWidth() {
        return 1280;
    }

    public int getRawHeight() {
        return getRawHeightNative();
    }

    public int getRawWidth() {
        return getRawWidthNative();
    }

    public void getRealMetrics(DisplayMetrics displaymetrics) {
        Point point = mTmpPoint;
        point;
        JVM INSTR monitorenter ;
        getRealSize(mTmpPoint);
        getMetricsWithSize(displaymetrics, mTmpPoint.x, mTmpPoint.y);
        return;
    }

    public void getRealSize(Point point) {
        try {
            IWindowManager iwindowmanager = getWindowManager();
            if(iwindowmanager != null) {
                iwindowmanager.getRealDisplaySize(point);
            } else {
                point.x = getRawWidth();
                point.y = getRawHeight();
            }
        }
        catch(RemoteException remoteexception) {
            Slog.w("Display", "Unable to get real display size", remoteexception);
        }
    }

    public void getRectSize(Rect rect) {
        Point point = mTmpPoint;
        point;
        JVM INSTR monitorenter ;
        getSizeInternal(mTmpPoint, true);
        rect.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        return;
    }

    public float getRefreshRate() {
        return mRefreshRate;
    }

    public int getRotation() {
        return getOrientation();
    }

    public void getSize(Point point) {
        getSizeInternal(point, true);
    }

    public int getWidth() {
        Point point = mTmpPoint;
        point;
        JVM INSTR monitorenter ;
        long l = SystemClock.uptimeMillis();
        if((float)l > 20F + mLastGetTime) {
            getSizeInternal(mTmpPoint, true);
            mLastGetTime = l;
        }
        int i = mTmpPoint.x;
        return i;
    }

    static final boolean DEBUG_DISPLAY_SIZE = false;
    public static final int DEFAULT_DISPLAY = 0;
    static final String TAG = "Display";
    private static boolean sInitialized = false;
    private static final Object sStaticInit = new Object();
    private static IWindowManager sWindowManager;
    private final CompatibilityInfoHolder mCompatibilityInfo;
    float mDensity;
    private final int mDisplay;
    float mDpiX;
    float mDpiY;
    private float mLastGetTime;
    private int mPixelFormat;
    private float mRefreshRate;
    private final DisplayMetrics mTmpMetrics;
    private final Point mTmpPoint;

}
