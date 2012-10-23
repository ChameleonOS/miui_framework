// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;

// Referenced classes of package android.webkit:
//            WebViewFactory, WebViewFactoryProvider, MustOverrideException

public class WebViewDatabase {

    protected WebViewDatabase() {
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static WebViewDatabase getInstance(Context context) {
        android/webkit/WebViewDatabase;
        JVM INSTR monitorenter ;
        WebViewDatabase webviewdatabase = WebViewFactory.getProvider().getWebViewDatabase(context);
        android/webkit/WebViewDatabase;
        JVM INSTR monitorexit ;
        return webviewdatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearFormData() {
        throw new MustOverrideException();
    }

    public void clearHttpAuthUsernamePassword() {
        throw new MustOverrideException();
    }

    public void clearUsernamePassword() {
        throw new MustOverrideException();
    }

    public boolean hasFormData() {
        throw new MustOverrideException();
    }

    public boolean hasHttpAuthUsernamePassword() {
        throw new MustOverrideException();
    }

    public boolean hasUsernamePassword() {
        throw new MustOverrideException();
    }

    protected static final String LOGTAG = "webviewdatabase";
}
