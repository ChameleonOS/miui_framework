// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.view.ViewRootImpl;

// Referenced classes of package android.webkit:
//            ClientCertRequestHandler, HttpAuthHandler, SslErrorHandler, WebView, 
//            WebResourceResponse

public class WebViewClient {

    public WebViewClient() {
    }

    public void doUpdateVisitedHistory(WebView webview, String s, boolean flag) {
    }

    public void onFormResubmission(WebView webview, Message message, Message message1) {
        message.sendToTarget();
    }

    public void onLoadResource(WebView webview, String s) {
    }

    public void onPageFinished(WebView webview, String s) {
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap) {
    }

    public void onProceededAfterSslError(WebView webview, SslError sslerror) {
    }

    public void onReceivedClientCertRequest(WebView webview, ClientCertRequestHandler clientcertrequesthandler, String s) {
        clientcertrequesthandler.cancel();
    }

    public void onReceivedError(WebView webview, int i, String s, String s1) {
    }

    public void onReceivedHttpAuthRequest(WebView webview, HttpAuthHandler httpauthhandler, String s, String s1) {
        httpauthhandler.cancel();
    }

    public void onReceivedLoginRequest(WebView webview, String s, String s1, String s2) {
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror) {
        sslerrorhandler.cancel();
    }

    public void onScaleChanged(WebView webview, float f, float f1) {
    }

    public void onTooManyRedirects(WebView webview, Message message, Message message1) {
        message.sendToTarget();
    }

    public void onUnhandledKeyEvent(WebView webview, KeyEvent keyevent) {
        ViewRootImpl viewrootimpl = webview.getViewRootImpl();
        if(viewrootimpl != null)
            viewrootimpl.dispatchUnhandledKey(keyevent);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview, String s) {
        return null;
    }

    public boolean shouldOverrideKeyEvent(WebView webview, KeyEvent keyevent) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s) {
        return false;
    }

    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
}
