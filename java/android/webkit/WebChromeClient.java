// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;

// Referenced classes of package android.webkit:
//            ConsoleMessage, ValueCallback, WebView, JsResult, 
//            JsPromptResult

public class WebChromeClient {
    public static interface CustomViewCallback {

        public abstract void onCustomViewHidden();
    }


    public WebChromeClient() {
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void getVisitedHistory(ValueCallback valuecallback) {
    }

    public void onCloseWindow(WebView webview) {
    }

    public void onConsoleMessage(String s, int i, String s1) {
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage) {
        onConsoleMessage(consolemessage.message(), consolemessage.lineNumber(), consolemessage.sourceId());
        return false;
    }

    public boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message) {
        return false;
    }

    public void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, WebStorage.QuotaUpdater quotaupdater) {
        quotaupdater.updateQuota(l);
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onGeolocationPermissionsShowPrompt(String s, GeolocationPermissions.Callback callback) {
    }

    public void onHideCustomView() {
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult) {
        return false;
    }

    public boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult) {
        return false;
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult) {
        return false;
    }

    public boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult) {
        return false;
    }

    public boolean onJsTimeout() {
        return true;
    }

    public void onProgressChanged(WebView webview, int i) {
    }

    public void onReachedMaxAppCacheSize(long l, long l1, WebStorage.QuotaUpdater quotaupdater) {
        quotaupdater.updateQuota(l1);
    }

    public void onReceivedIcon(WebView webview, Bitmap bitmap) {
    }

    public void onReceivedTitle(WebView webview, String s) {
    }

    public void onReceivedTouchIconUrl(WebView webview, String s, boolean flag) {
    }

    public void onRequestFocus(WebView webview) {
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customviewcallback) {
    }

    public void onShowCustomView(View view, CustomViewCallback customviewcallback) {
    }

    public void openFileChooser(ValueCallback valuecallback, String s, String s1) {
        valuecallback.onReceiveValue(null);
    }

    public void setInstallableWebApp() {
    }

    public void setupAutoFill(Message message) {
    }
}
