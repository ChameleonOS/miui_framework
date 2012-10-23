// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.res.Configuration;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.io.File;
import java.util.Map;

// Referenced classes of package android.webkit:
//            WebBackForwardList, WebSettings, ValueCallback, DownloadListener, 
//            WebChromeClient, WebViewClient

public interface WebViewProvider {
    public static interface ScrollDelegate {

        public abstract int computeHorizontalScrollOffset();

        public abstract int computeHorizontalScrollRange();

        public abstract void computeScroll();

        public abstract int computeVerticalScrollExtent();

        public abstract int computeVerticalScrollOffset();

        public abstract int computeVerticalScrollRange();
    }

    public static interface ViewDelegate {

        public abstract boolean dispatchKeyEvent(KeyEvent keyevent);

        public abstract void onAttachedToWindow();

        public abstract void onConfigurationChanged(Configuration configuration);

        public abstract InputConnection onCreateInputConnection(EditorInfo editorinfo);

        public abstract void onDetachedFromWindow();

        public abstract void onDraw(Canvas canvas);

        public abstract void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int j, int k, int l);

        public abstract void onFocusChanged(boolean flag, int i, Rect rect);

        public abstract boolean onGenericMotionEvent(MotionEvent motionevent);

        public abstract boolean onHoverEvent(MotionEvent motionevent);

        public abstract void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent);

        public abstract void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo);

        public abstract boolean onKeyDown(int i, KeyEvent keyevent);

        public abstract boolean onKeyMultiple(int i, int j, KeyEvent keyevent);

        public abstract boolean onKeyUp(int i, KeyEvent keyevent);

        public abstract void onMeasure(int i, int j);

        public abstract void onOverScrolled(int i, int j, boolean flag, boolean flag1);

        public abstract void onScrollChanged(int i, int j, int k, int l);

        public abstract void onSizeChanged(int i, int j, int k, int l);

        public abstract boolean onTouchEvent(MotionEvent motionevent);

        public abstract boolean onTrackballEvent(MotionEvent motionevent);

        public abstract void onVisibilityChanged(View view, int i);

        public abstract void onWindowFocusChanged(boolean flag);

        public abstract void onWindowVisibilityChanged(int i);

        public abstract boolean performAccessibilityAction(int i, Bundle bundle);

        public abstract boolean performLongClick();

        public abstract boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag);

        public abstract boolean requestFocus(int i, Rect rect);

        public abstract void setBackgroundColor(int i);

        public abstract boolean setFrame(int i, int j, int k, int l);

        public abstract void setLayerType(int i, Paint paint);

        public abstract void setLayoutParams(android.view.ViewGroup.LayoutParams layoutparams);

        public abstract void setOverScrollMode(int i);

        public abstract void setScrollBarStyle(int i);

        public abstract boolean shouldDelayChildPressedState();
    }


    public abstract void addJavascriptInterface(Object obj, String s);

    public abstract boolean canGoBack();

    public abstract boolean canGoBackOrForward(int i);

    public abstract boolean canGoForward();

    public abstract boolean canZoomIn();

    public abstract boolean canZoomOut();

    public abstract Picture capturePicture();

    public abstract void clearCache(boolean flag);

    public abstract void clearFormData();

    public abstract void clearHistory();

    public abstract void clearMatches();

    public abstract void clearSslPreferences();

    public abstract void clearView();

    public abstract WebBackForwardList copyBackForwardList();

    public abstract void debugDump();

    public abstract void destroy();

    public abstract void documentHasImages(Message message);

    public abstract void emulateShiftHeld();

    public abstract int findAll(String s);

    public abstract void findAllAsync(String s);

    public abstract void findNext(boolean flag);

    public abstract void flingScroll(int i, int j);

    public abstract void freeMemory();

    public abstract SslCertificate getCertificate();

    public abstract int getContentHeight();

    public abstract int getContentWidth();

    public abstract Bitmap getFavicon();

    public abstract WebView.HitTestResult getHitTestResult();

    public abstract String[] getHttpAuthUsernamePassword(String s, String s1);

    public abstract String getOriginalUrl();

    public abstract int getProgress();

    public abstract float getScale();

    public abstract ScrollDelegate getScrollDelegate();

    public abstract WebSettings getSettings();

    public abstract String getTitle();

    public abstract String getTouchIconUrl();

    public abstract String getUrl();

    public abstract ViewDelegate getViewDelegate();

    public abstract int getVisibleTitleHeight();

    public abstract View getZoomControls();

    public abstract void goBack();

    public abstract void goBackOrForward(int i);

    public abstract void goForward();

    public abstract void init(Map map, boolean flag);

    public abstract void invokeZoomPicker();

    public abstract boolean isPaused();

    public abstract boolean isPrivateBrowsingEnabled();

    public abstract void loadData(String s, String s1, String s2);

    public abstract void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4);

    public abstract void loadUrl(String s);

    public abstract void loadUrl(String s, Map map);

    public abstract void onPause();

    public abstract void onResume();

    public abstract boolean overlayHorizontalScrollbar();

    public abstract boolean overlayVerticalScrollbar();

    public abstract boolean pageDown(boolean flag);

    public abstract boolean pageUp(boolean flag);

    public abstract void pauseTimers();

    public abstract void postUrl(String s, byte abyte0[]);

    public abstract void reload();

    public abstract void removeJavascriptInterface(String s);

    public abstract void requestFocusNodeHref(Message message);

    public abstract void requestImageRef(Message message);

    public abstract boolean restorePicture(Bundle bundle, File file);

    public abstract WebBackForwardList restoreState(Bundle bundle);

    public abstract void resumeTimers();

    public abstract void savePassword(String s, String s1, String s2);

    public abstract boolean savePicture(Bundle bundle, File file);

    public abstract WebBackForwardList saveState(Bundle bundle);

    public abstract void saveWebArchive(String s);

    public abstract void saveWebArchive(String s, boolean flag, ValueCallback valuecallback);

    public abstract void setCertificate(SslCertificate sslcertificate);

    public abstract void setDownloadListener(DownloadListener downloadlistener);

    public abstract void setFindListener(WebView.FindListener findlistener);

    public abstract void setHorizontalScrollbarOverlay(boolean flag);

    public abstract void setHttpAuthUsernamePassword(String s, String s1, String s2, String s3);

    public abstract void setInitialScale(int i);

    public abstract void setMapTrackballToArrowKeys(boolean flag);

    public abstract void setNetworkAvailable(boolean flag);

    public abstract void setPictureListener(WebView.PictureListener picturelistener);

    public abstract void setVerticalScrollbarOverlay(boolean flag);

    public abstract void setWebChromeClient(WebChromeClient webchromeclient);

    public abstract void setWebViewClient(WebViewClient webviewclient);

    public abstract boolean showFindDialog(String s, boolean flag);

    public abstract void stopLoading();

    public abstract boolean zoomIn();

    public abstract boolean zoomOut();
}
