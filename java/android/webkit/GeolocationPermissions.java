// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;


// Referenced classes of package android.webkit:
//            WebViewFactory, WebViewFactoryProvider, ValueCallback

public class GeolocationPermissions {
    public static interface Callback {

        public abstract void invoke(String s, boolean flag, boolean flag1);
    }


    public GeolocationPermissions() {
    }

    public static GeolocationPermissions getInstance() {
        return WebViewFactory.getProvider().getGeolocationPermissions();
    }

    public void allow(String s) {
    }

    public void clear(String s) {
    }

    public void clearAll() {
    }

    public void getAllowed(String s, ValueCallback valuecallback) {
    }

    public void getOrigins(ValueCallback valuecallback) {
    }
}
