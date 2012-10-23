// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.net.http.SslCertificate;
import android.os.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsoluteLayout;
import java.io.File;
import java.util.Map;

// Referenced classes of package android.webkit:
//            WebViewProvider, WebViewFactoryProvider, WebViewFactory, PluginList, 
//            WebBackForwardList, WebSettings, ValueCallback, DownloadListener, 
//            WebChromeClient, WebViewClient

public class WebView extends AbsoluteLayout
    implements android.view.ViewTreeObserver.OnGlobalFocusChangeListener, android.view.ViewGroup.OnHierarchyChangeListener {
    public static class HitTestResult {

        public String getExtra() {
            return mExtra;
        }

        public int getType() {
            return mType;
        }

        public void setExtra(String s) {
            mExtra = s;
        }

        public void setType(int i) {
            mType = i;
        }

        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE;
        private String mExtra;
        private int mType;

        public HitTestResult() {
            mType = 0;
        }
    }

    public static interface PictureListener {

        public abstract void onNewPicture(WebView webview, Picture picture);
    }

    public static interface FindListener {

        public abstract void onFindResultReceived(int i, int j, boolean flag);
    }

    public class WebViewTransport {

        /**
         * @deprecated Method getWebView is deprecated
         */

        public WebView getWebView() {
            this;
            JVM INSTR monitorenter ;
            WebView webview = mWebview;
            this;
            JVM INSTR monitorexit ;
            return webview;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method setWebView is deprecated
         */

        public void setWebView(WebView webview) {
            this;
            JVM INSTR monitorenter ;
            mWebview = webview;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private WebView mWebview;
        final WebView this$0;

        public WebViewTransport() {
            this$0 = WebView.this;
            super();
        }
    }


    public WebView(Context context) {
        WebView(context, null);
    }

    public WebView(Context context, AttributeSet attributeset) {
        WebView(context, attributeset, 0x1010085);
    }

    public WebView(Context context, AttributeSet attributeset, int i) {
        WebView(context, attributeset, i, false);
    }

    protected WebView(Context context, AttributeSet attributeset, int i, Map map, boolean flag) {
        AbsoluteLayout(context, attributeset, i);
        if(context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        } else {
            checkThread();
            ensureProviderCreated();
            mProvider.init(map, flag);
            return;
        }
    }

    public WebView(Context context, AttributeSet attributeset, int i, boolean flag) {
        WebView(context, attributeset, i, null, flag);
    }

    private static void checkThread() {
        if(Looper.myLooper() != Looper.getMainLooper()) {
            Throwable throwable = new Throwable((new StringBuilder()).append("Warning: A WebView method was called on thread '").append(Thread.currentThread().getName()).append("'. ").append("All WebView methods must be called on the UI thread. ").append("Future versions of WebView may not support use on other threads.").toString());
            Log.w("webview_proxy", Log.getStackTraceString(throwable));
            StrictMode.onWebViewMethodCalledOnWrongThread(throwable);
        }
    }

    public static void disablePlatformNotifications() {
        checkThread();
        getFactory().getStatics().setPlatformNotificationsEnabled(false);
    }

    public static void enablePlatformNotifications() {
        checkThread();
        getFactory().getStatics().setPlatformNotificationsEnabled(true);
    }

    private void ensureProviderCreated() {
        checkThread();
        if(mProvider == null)
            mProvider = getFactory().createWebView(this, new PrivateAccess());
    }

    public static String findAddress(String s) {
        checkThread();
        return getFactory().getStatics().findAddress(s);
    }

    /**
     * @deprecated Method getFactory is deprecated
     */

    private static WebViewFactoryProvider getFactory() {
        android/webkit/WebView;
        JVM INSTR monitorenter ;
        WebViewFactoryProvider webviewfactoryprovider;
        checkThread();
        webviewfactoryprovider = WebViewFactory.getProvider();
        android/webkit/WebView;
        JVM INSTR monitorexit ;
        return webviewfactoryprovider;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getPluginList is deprecated
     */

    public static PluginList getPluginList() {
        android/webkit/WebView;
        JVM INSTR monitorenter ;
        PluginList pluginlist;
        checkThread();
        pluginlist = new PluginList();
        android/webkit/WebView;
        JVM INSTR monitorexit ;
        return pluginlist;
        Exception exception;
        exception;
        throw exception;
    }

    public void addJavascriptInterface(Object obj, String s) {
        checkThread();
        mProvider.addJavascriptInterface(obj, s);
    }

    public boolean canGoBack() {
        checkThread();
        return mProvider.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        checkThread();
        return mProvider.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        checkThread();
        return mProvider.canGoForward();
    }

    public boolean canZoomIn() {
        checkThread();
        return mProvider.canZoomIn();
    }

    public boolean canZoomOut() {
        checkThread();
        return mProvider.canZoomOut();
    }

    public Picture capturePicture() {
        checkThread();
        return mProvider.capturePicture();
    }

    public void clearCache(boolean flag) {
        checkThread();
        mProvider.clearCache(flag);
    }

    public void clearFormData() {
        checkThread();
        mProvider.clearFormData();
    }

    public void clearHistory() {
        checkThread();
        mProvider.clearHistory();
    }

    public void clearMatches() {
        checkThread();
        mProvider.clearMatches();
    }

    public void clearSslPreferences() {
        checkThread();
        mProvider.clearSslPreferences();
    }

    public void clearView() {
        checkThread();
        mProvider.clearView();
    }

    protected int computeHorizontalScrollOffset() {
        return mProvider.getScrollDelegate().computeHorizontalScrollOffset();
    }

    protected int computeHorizontalScrollRange() {
        return mProvider.getScrollDelegate().computeHorizontalScrollRange();
    }

    public void computeScroll() {
        mProvider.getScrollDelegate().computeScroll();
    }

    protected int computeVerticalScrollExtent() {
        return mProvider.getScrollDelegate().computeVerticalScrollExtent();
    }

    protected int computeVerticalScrollOffset() {
        return mProvider.getScrollDelegate().computeVerticalScrollOffset();
    }

    protected int computeVerticalScrollRange() {
        return mProvider.getScrollDelegate().computeVerticalScrollRange();
    }

    public WebBackForwardList copyBackForwardList() {
        checkThread();
        return mProvider.copyBackForwardList();
    }

    public void debugDump() {
        checkThread();
        mProvider.debugDump();
    }

    public void destroy() {
        checkThread();
        mProvider.destroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        return mProvider.getViewDelegate().dispatchKeyEvent(keyevent);
    }

    public void documentHasImages(Message message) {
        checkThread();
        mProvider.documentHasImages(message);
    }

    public void emulateShiftHeld() {
        checkThread();
        mProvider.emulateShiftHeld();
    }

    public int findAll(String s) {
        checkThread();
        StrictMode.noteSlowCall("findAll blocks UI: prefer findAllAsync");
        return mProvider.findAll(s);
    }

    public void findAllAsync(String s) {
        checkThread();
        mProvider.findAllAsync(s);
    }

    public void findNext(boolean flag) {
        checkThread();
        mProvider.findNext(flag);
    }

    public void flingScroll(int i, int j) {
        checkThread();
        mProvider.flingScroll(i, j);
    }

    public void freeMemory() {
        checkThread();
        mProvider.freeMemory();
    }

    public SslCertificate getCertificate() {
        checkThread();
        return mProvider.getCertificate();
    }

    public int getContentHeight() {
        checkThread();
        return mProvider.getContentHeight();
    }

    public int getContentWidth() {
        return mProvider.getContentWidth();
    }

    public Bitmap getFavicon() {
        checkThread();
        return mProvider.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        checkThread();
        return mProvider.getHitTestResult();
    }

    public String[] getHttpAuthUsernamePassword(String s, String s1) {
        checkThread();
        return mProvider.getHttpAuthUsernamePassword(s, s1);
    }

    public String getOriginalUrl() {
        checkThread();
        return mProvider.getOriginalUrl();
    }

    public int getProgress() {
        checkThread();
        return mProvider.getProgress();
    }

    public float getScale() {
        checkThread();
        return mProvider.getScale();
    }

    public WebSettings getSettings() {
        checkThread();
        return mProvider.getSettings();
    }

    public String getTitle() {
        checkThread();
        return mProvider.getTitle();
    }

    public String getTouchIconUrl() {
        return mProvider.getTouchIconUrl();
    }

    public String getUrl() {
        checkThread();
        return mProvider.getUrl();
    }

    public int getVisibleTitleHeight() {
        checkThread();
        return mProvider.getVisibleTitleHeight();
    }

    public WebViewProvider getWebViewProvider() {
        return mProvider;
    }

    public View getZoomControls() {
        checkThread();
        return mProvider.getZoomControls();
    }

    public void goBack() {
        checkThread();
        mProvider.goBack();
    }

    public void goBackOrForward(int i) {
        checkThread();
        mProvider.goBackOrForward(i);
    }

    public void goForward() {
        checkThread();
        mProvider.goForward();
    }

    public void invokeZoomPicker() {
        checkThread();
        mProvider.invokeZoomPicker();
    }

    public boolean isPaused() {
        return mProvider.isPaused();
    }

    public boolean isPrivateBrowsingEnabled() {
        checkThread();
        return mProvider.isPrivateBrowsingEnabled();
    }

    public void loadData(String s, String s1, String s2) {
        checkThread();
        mProvider.loadData(s, s1, s2);
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4) {
        checkThread();
        mProvider.loadDataWithBaseURL(s, s1, s2, s3, s4);
    }

    public void loadUrl(String s) {
        checkThread();
        mProvider.loadUrl(s);
    }

    public void loadUrl(String s, Map map) {
        checkThread();
        mProvider.loadUrl(s, map);
    }

    protected void onAttachedToWindow() {
        onAttachedToWindow();
        mProvider.getViewDelegate().onAttachedToWindow();
    }

    public void onChildViewAdded(View view, View view1) {
    }

    public void onChildViewRemoved(View view, View view1) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        mProvider.getViewDelegate().onConfigurationChanged(configuration);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo) {
        return mProvider.getViewDelegate().onCreateInputConnection(editorinfo);
    }

    protected void onDetachedFromWindow() {
        mProvider.getViewDelegate().onDetachedFromWindow();
        onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        mProvider.getViewDelegate().onDraw(canvas);
    }

    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int j, int k, int l) {
        mProvider.getViewDelegate().onDrawVerticalScrollBar(canvas, drawable, i, j, k, l);
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect) {
        mProvider.getViewDelegate().onFocusChanged(flag, i, rect);
        onFocusChanged(flag, i, rect);
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent) {
        return mProvider.getViewDelegate().onGenericMotionEvent(motionevent);
    }

    public void onGlobalFocusChanged(View view, View view1) {
    }

    public boolean onHoverEvent(MotionEvent motionevent) {
        return mProvider.getViewDelegate().onHoverEvent(motionevent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/webkit/WebView.getName());
        mProvider.getViewDelegate().onInitializeAccessibilityEvent(accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/webkit/WebView.getName());
        mProvider.getViewDelegate().onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        return mProvider.getViewDelegate().onKeyDown(i, keyevent);
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent) {
        return mProvider.getViewDelegate().onKeyMultiple(i, j, keyevent);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        return mProvider.getViewDelegate().onKeyUp(i, keyevent);
    }

    protected void onMeasure(int i, int j) {
        onMeasure(i, j);
        mProvider.getViewDelegate().onMeasure(i, j);
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1) {
        mProvider.getViewDelegate().onOverScrolled(i, j, flag, flag1);
    }

    public void onPause() {
        checkThread();
        mProvider.onPause();
    }

    public void onResume() {
        checkThread();
        mProvider.onResume();
    }

    protected void onScrollChanged(int i, int j, int k, int l) {
        onScrollChanged(i, j, k, l);
        mProvider.getViewDelegate().onScrollChanged(i, j, k, l);
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        onSizeChanged(i, j, k, l);
        mProvider.getViewDelegate().onSizeChanged(i, j, k, l);
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        return mProvider.getViewDelegate().onTouchEvent(motionevent);
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        return mProvider.getViewDelegate().onTrackballEvent(motionevent);
    }

    protected void onVisibilityChanged(View view, int i) {
        onVisibilityChanged(view, i);
        mProvider.getViewDelegate().onVisibilityChanged(view, i);
    }

    public void onWindowFocusChanged(boolean flag) {
        mProvider.getViewDelegate().onWindowFocusChanged(flag);
        onWindowFocusChanged(flag);
    }

    protected void onWindowVisibilityChanged(int i) {
        onWindowVisibilityChanged(i);
        mProvider.getViewDelegate().onWindowVisibilityChanged(i);
    }

    public boolean overlayHorizontalScrollbar() {
        checkThread();
        return mProvider.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        checkThread();
        return mProvider.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean flag) {
        checkThread();
        return mProvider.pageDown(flag);
    }

    public boolean pageUp(boolean flag) {
        checkThread();
        return mProvider.pageUp(flag);
    }

    public void pauseTimers() {
        checkThread();
        mProvider.pauseTimers();
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return mProvider.getViewDelegate().performAccessibilityAction(i, bundle);
    }

    public boolean performLongClick() {
        return mProvider.getViewDelegate().performLongClick();
    }

    public void postUrl(String s, byte abyte0[]) {
        checkThread();
        mProvider.postUrl(s, abyte0);
    }

    public void refreshPlugins(boolean flag) {
        checkThread();
    }

    public void reload() {
        checkThread();
        mProvider.reload();
    }

    public void removeJavascriptInterface(String s) {
        checkThread();
        mProvider.removeJavascriptInterface(s);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag) {
        return mProvider.getViewDelegate().requestChildRectangleOnScreen(view, rect, flag);
    }

    public boolean requestFocus(int i, Rect rect) {
        return mProvider.getViewDelegate().requestFocus(i, rect);
    }

    public void requestFocusNodeHref(Message message) {
        checkThread();
        mProvider.requestFocusNodeHref(message);
    }

    public void requestImageRef(Message message) {
        checkThread();
        mProvider.requestImageRef(message);
    }

    public boolean restorePicture(Bundle bundle, File file) {
        checkThread();
        return mProvider.restorePicture(bundle, file);
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        checkThread();
        return mProvider.restoreState(bundle);
    }

    public void resumeTimers() {
        checkThread();
        mProvider.resumeTimers();
    }

    public void savePassword(String s, String s1, String s2) {
        checkThread();
        mProvider.savePassword(s, s1, s2);
    }

    public boolean savePicture(Bundle bundle, File file) {
        checkThread();
        return mProvider.savePicture(bundle, file);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        checkThread();
        return mProvider.saveState(bundle);
    }

    public void saveWebArchive(String s) {
        checkThread();
        mProvider.saveWebArchive(s);
    }

    public void saveWebArchive(String s, boolean flag, ValueCallback valuecallback) {
        checkThread();
        mProvider.saveWebArchive(s, flag, valuecallback);
    }

    public void setBackgroundColor(int i) {
        mProvider.getViewDelegate().setBackgroundColor(i);
    }

    public void setCertificate(SslCertificate sslcertificate) {
        checkThread();
        mProvider.setCertificate(sslcertificate);
    }

    public void setDownloadListener(DownloadListener downloadlistener) {
        checkThread();
        mProvider.setDownloadListener(downloadlistener);
    }

    public void setFindListener(FindListener findlistener) {
        checkThread();
        mProvider.setFindListener(findlistener);
    }

    protected boolean setFrame(int i, int j, int k, int l) {
        return mProvider.getViewDelegate().setFrame(i, j, k, l);
    }

    public void setHorizontalScrollbarOverlay(boolean flag) {
        checkThread();
        mProvider.setHorizontalScrollbarOverlay(flag);
    }

    public void setHttpAuthUsernamePassword(String s, String s1, String s2, String s3) {
        checkThread();
        mProvider.setHttpAuthUsernamePassword(s, s1, s2, s3);
    }

    public void setInitialScale(int i) {
        checkThread();
        mProvider.setInitialScale(i);
    }

    public void setLayerType(int i, Paint paint) {
        setLayerType(i, paint);
        mProvider.getViewDelegate().setLayerType(i, paint);
    }

    public void setLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        mProvider.getViewDelegate().setLayoutParams(layoutparams);
    }

    public void setMapTrackballToArrowKeys(boolean flag) {
        checkThread();
        mProvider.setMapTrackballToArrowKeys(flag);
    }

    public void setNetworkAvailable(boolean flag) {
        checkThread();
        mProvider.setNetworkAvailable(flag);
    }

    public void setOverScrollMode(int i) {
        setOverScrollMode(i);
        ensureProviderCreated();
        mProvider.getViewDelegate().setOverScrollMode(i);
    }

    public void setPictureListener(PictureListener picturelistener) {
        checkThread();
        mProvider.setPictureListener(picturelistener);
    }

    public void setScrollBarStyle(int i) {
        mProvider.getViewDelegate().setScrollBarStyle(i);
        setScrollBarStyle(i);
    }

    public void setVerticalScrollbarOverlay(boolean flag) {
        checkThread();
        mProvider.setVerticalScrollbarOverlay(flag);
    }

    public void setWebChromeClient(WebChromeClient webchromeclient) {
        checkThread();
        mProvider.setWebChromeClient(webchromeclient);
    }

    public void setWebViewClient(WebViewClient webviewclient) {
        checkThread();
        mProvider.setWebViewClient(webviewclient);
    }

    public boolean shouldDelayChildPressedState() {
        return mProvider.getViewDelegate().shouldDelayChildPressedState();
    }

    public boolean showFindDialog(String s, boolean flag) {
        checkThread();
        return mProvider.showFindDialog(s, flag);
    }

    public void stopLoading() {
        checkThread();
        mProvider.stopLoading();
    }

    public boolean zoomIn() {
        checkThread();
        return mProvider.zoomIn();
    }

    public boolean zoomOut() {
        checkThread();
        return mProvider.zoomOut();
    }

    private static final String LOGTAG = "webview_proxy";
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    private WebViewProvider mProvider;












/*
    static int access$1802(WebView webview, int i) {
        webview.mScrollX = i;
        return i;
    }

*/


/*
    static int access$1902(WebView webview, int i) {
        webview.mScrollY = i;
        return i;
    }

*/








}
