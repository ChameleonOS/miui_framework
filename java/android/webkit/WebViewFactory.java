// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.util.Log;

// Referenced classes of package android.webkit:
//            WebViewFactoryProvider

class WebViewFactory {

    WebViewFactory() {
    }

    private static WebViewFactoryProvider getFactoryByName(String s) {
        WebViewFactoryProvider webviewfactoryprovider = (WebViewFactoryProvider)Class.forName(s).newInstance();
_L2:
        return webviewfactoryprovider;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        Log.e("WebViewFactory", (new StringBuilder()).append("error loading ").append(s).toString(), classnotfoundexception);
_L3:
        webviewfactoryprovider = null;
        if(true) goto _L2; else goto _L1
_L1:
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        Log.e("WebViewFactory", (new StringBuilder()).append("error loading ").append(s).toString(), illegalaccessexception);
          goto _L3
        InstantiationException instantiationexception;
        instantiationexception;
        Log.e("WebViewFactory", (new StringBuilder()).append("error loading ").append(s).toString(), instantiationexception);
          goto _L3
    }

    /**
     * @deprecated Method getProvider is deprecated
     */

    static WebViewFactoryProvider getProvider() {
        android/webkit/WebViewFactory;
        JVM INSTR monitorenter ;
        if(sProviderInstance == null) goto _L2; else goto _L1
_L1:
        WebViewFactoryProvider webviewfactoryprovider = sProviderInstance;
_L4:
        android/webkit/WebViewFactory;
        JVM INSTR monitorexit ;
        return webviewfactoryprovider;
_L2:
        sProviderInstance = getFactoryByName("android.webkit.WebViewClassic$Factory");
        if(sProviderInstance == null)
            sProviderInstance = new WebViewClassic.Factory();
        webviewfactoryprovider = sProviderInstance;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static final boolean DEBUG = false;
    private static final String DEFAULT_WEB_VIEW_FACTORY = "android.webkit.WebViewClassic$Factory";
    private static final String LOGTAG = "WebViewFactory";
    private static WebViewFactoryProvider sProviderInstance;
}
