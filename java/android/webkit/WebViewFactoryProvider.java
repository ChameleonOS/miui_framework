// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;

// Referenced classes of package android.webkit:
//            WebView, WebViewProvider, CookieManager, GeolocationPermissions, 
//            WebIconDatabase, WebStorage, WebViewDatabase

public interface WebViewFactoryProvider {
    public static interface Statics {

        public abstract String findAddress(String s);

        public abstract void setPlatformNotificationsEnabled(boolean flag);
    }


    public abstract WebViewProvider createWebView(WebView webview, WebView.PrivateAccess privateaccess);

    public abstract CookieManager getCookieManager();

    public abstract GeolocationPermissions getGeolocationPermissions();

    public abstract Statics getStatics();

    public abstract WebIconDatabase getWebIconDatabase();

    public abstract WebStorage getWebStorage();

    public abstract WebViewDatabase getWebViewDatabase(Context context);
}
