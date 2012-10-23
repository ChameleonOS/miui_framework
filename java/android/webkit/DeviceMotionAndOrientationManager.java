// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;


// Referenced classes of package android.webkit:
//            WebViewCore

final class DeviceMotionAndOrientationManager {

    public DeviceMotionAndOrientationManager(WebViewCore webviewcore) {
        mWebViewCore = webviewcore;
    }

    private static native void nativeOnMotionChange(WebViewCore webviewcore, boolean flag, double d, boolean flag1, double d1, boolean flag2, 
            double d2, double d3);

    private static native void nativeOnOrientationChange(WebViewCore webviewcore, boolean flag, double d, boolean flag1, double d1, boolean flag2, 
            double d2);

    private static native void nativeSetMockOrientation(WebViewCore webviewcore, boolean flag, double d, boolean flag1, double d1, boolean flag2, 
            double d2);

    private static native void nativeSetUseMock(WebViewCore webviewcore);

    public void onMotionChange(Double double1, Double double2, Double double3, double d) {
        WebViewCore webviewcore = mWebViewCore;
        boolean flag;
        double d1;
        boolean flag1;
        double d2;
        boolean flag2;
        double d3;
        if(double1 != null)
            flag = true;
        else
            flag = false;
        if(double1 != null)
            d1 = double1.doubleValue();
        else
            d1 = 0.0D;
        if(double2 != null)
            flag1 = true;
        else
            flag1 = false;
        if(double2 != null)
            d2 = double2.doubleValue();
        else
            d2 = 0.0D;
        if(double3 != null)
            flag2 = true;
        else
            flag2 = false;
        if(double3 != null)
            d3 = double3.doubleValue();
        else
            d3 = 0.0D;
        nativeOnMotionChange(webviewcore, flag, d1, flag1, d2, flag2, d3, d);
    }

    public void onOrientationChange(Double double1, Double double2, Double double3) {
        boolean flag = true;
        double d = 0.0D;
        WebViewCore webviewcore = mWebViewCore;
        boolean flag1;
        double d1;
        boolean flag2;
        double d2;
        if(double1 != null)
            flag1 = flag;
        else
            flag1 = false;
        if(double1 != null)
            d1 = double1.doubleValue();
        else
            d1 = d;
        if(double2 != null)
            flag2 = flag;
        else
            flag2 = false;
        if(double2 != null)
            d2 = double2.doubleValue();
        else
            d2 = d;
        if(double3 == null)
            flag = false;
        if(double3 != null)
            d = double3.doubleValue();
        nativeOnOrientationChange(webviewcore, flag1, d1, flag2, d2, flag, d);
    }

    public void setMockOrientation(boolean flag, double d, boolean flag1, double d1, boolean flag2, 
            double d2) {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        } else {
            nativeSetMockOrientation(mWebViewCore, flag, d, flag1, d1, flag2, d2);
            return;
        }
    }

    public void setUseMock() {
        if(!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        } else {
            nativeSetUseMock(mWebViewCore);
            return;
        }
    }

    static final boolean $assertionsDisabled;
    private WebViewCore mWebViewCore;

    static  {
        boolean flag;
        if(!android/webkit/DeviceMotionAndOrientationManager.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }
}
