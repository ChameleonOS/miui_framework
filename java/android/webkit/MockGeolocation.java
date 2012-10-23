// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;


public final class MockGeolocation {

    public MockGeolocation() {
    }

    public static MockGeolocation getInstance() {
        if(sMockGeolocation == null)
            sMockGeolocation = new MockGeolocation();
        return sMockGeolocation;
    }

    private static native void nativeSetError(int i, String s);

    private static native void nativeSetPosition(double d, double d1, double d2);

    public void setError(int i, String s) {
        nativeSetError(i, s);
    }

    public void setPosition(double d, double d1, double d2) {
        nativeSetPosition(d, d1, d2);
    }

    private static MockGeolocation sMockGeolocation;
}
