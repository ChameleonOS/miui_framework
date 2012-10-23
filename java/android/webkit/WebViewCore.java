// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaFile;
import android.net.ProxyProperties;
import android.net.Uri;
import android.net.http.CertificateChainValidator;
import android.os.*;
import android.util.*;
import android.view.*;
import java.io.OutputStream;
import java.util.*;
import junit.framework.Assert;

// Referenced classes of package android.webkit:
//            DeviceMotionAndOrientationManager, WebCoreThreadWatchdog, WebSettingsClassic, WebIconDatabase, 
//            WebStorageClassic, GeolocationPermissionsClassic, WebViewClassic, BrowserFrame, 
//            CacheManager, ViewManager, PluginManager, WebIconDatabaseClassic, 
//            CallbackProxy, JWebCoreJavaBridge, WebBackForwardList, WebHistoryItem, 
//            ViewStateSerializer, ValueCallback, DeviceMotionService, DeviceOrientationService, 
//            WebView, WebViewInputDispatcher, CookieManagerClassic, SslCertLookupTable

public final class WebViewCore {
    static class ShowRectData {

        int mContentHeight;
        int mContentWidth;
        int mHeight;
        int mLeft;
        int mTop;
        int mWidth;
        float mXPercentInDoc;
        float mXPercentInView;
        float mYPercentInDoc;
        float mYPercentInView;

        ShowRectData() {
        }
    }

    static class DrawData {

        int mBaseLayer;
        Point mContentSize;
        boolean mFirstLayoutForNonStandardLoad;
        boolean mFocusSizeChanged;
        int mMinPrefWidth;
        Point mViewSize;
        ViewState mViewState;

        DrawData() {
            mBaseLayer = 0;
            mContentSize = new Point();
        }
    }

    static class ViewState {

        float mDefaultScale;
        boolean mIsRestored;
        float mMaxScale;
        float mMinScale;
        boolean mMobileSite;
        int mScrollX;
        int mScrollY;
        boolean mShouldStartScrolledRight;
        float mTextWrapScale;
        float mViewScale;

        ViewState() {
        }
    }

    public class EventHub
        implements WebViewInputDispatcher.WebKitCallbacks {

        /**
         * @deprecated Method blockMessages is deprecated
         */

        private void blockMessages() {
            this;
            JVM INSTR monitorenter ;
            mBlockMessages = true;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method removeMessages is deprecated
         */

        private void removeMessages() {
            this;
            JVM INSTR monitorenter ;
            mDrawIsScheduled = false;
            if(mMessages == null) goto _L2; else goto _L1
_L1:
            mMessages.clear();
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            mHandler.removeCallbacksAndMessages(null);
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method removeMessages is deprecated
         */

        private void removeMessages(int i) {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mBlockMessages;
            if(!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            if(i != 130)
                break MISSING_BLOCK_LABEL_30;
            mDrawIsScheduled = false;
            if(mMessages == null)
                break MISSING_BLOCK_LABEL_88;
            Iterator iterator = mMessages.iterator();
            while(iterator.hasNext()) 
                if(((Message)iterator.next()).what == i)
                    iterator.remove();
              goto _L1
            Exception exception;
            exception;
            throw exception;
            mHandler.removeMessages(i);
              goto _L1
        }

        /**
         * @deprecated Method sendMessage is deprecated
         */

        private void sendMessage(Message message) {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mBlockMessages;
            if(!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            if(mMessages == null)
                break MISSING_BLOCK_LABEL_38;
            mMessages.add(message);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            mHandler.sendMessage(message);
              goto _L1
        }

        /**
         * @deprecated Method sendMessageAtFrontOfQueue is deprecated
         */

        private void sendMessageAtFrontOfQueue(Message message) {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mBlockMessages;
            if(!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            if(mMessages == null)
                break MISSING_BLOCK_LABEL_38;
            mMessages.add(0, message);
              goto _L1
            Exception exception;
            exception;
            throw exception;
            mHandler.sendMessageAtFrontOfQueue(message);
              goto _L1
        }

        /**
         * @deprecated Method sendMessageDelayed is deprecated
         */

        private void sendMessageDelayed(Message message, long l) {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mBlockMessages;
            if(!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            mHandler.sendMessageDelayed(message, l);
            if(true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        private void transferMessages() {
            mTid = Process.myTid();
            mSavedPriority = Process.getThreadPriority(mTid);
            mHandler = new Handler() {

                public void handleMessage(Message message) {
                    message.what;
                    JVM INSTR tableswitch 109 110: default 28
                //                               109 55
                //                               110 124;
                       goto _L1 _L2 _L3
_L5:
                    return;
_L2:
                    mSavedPriority = Process.getThreadPriority(mTid);
                    Process.setThreadPriority(mTid, 10);
                    WebViewCore.pauseTimers();
                    if(mNativeClass != 0)
                        nativeCloseIdleConnections(mNativeClass);
                    continue; /* Loop/switch isn't completed */
_L3:
                    Process.setThreadPriority(mTid, mSavedPriority);
                    WebViewCore.resumeTimers();
                    continue; /* Loop/switch isn't completed */
_L1:
                    if(mWebViewClassic == null || mNativeClass == 0 || mDestroying && message.what != 200) goto _L5; else goto _L4
_L4:
                    message.what;
                    JVM INSTR tableswitch 96 225: default 708
                //                               96 711
                //                               97 708
                //                               98 708
                //                               99 887
                //                               100 988
                //                               101 1238
                //                               102 1296
                //                               103 1313
                //                               104 1338
                //                               105 1380
                //                               106 1521
                //                               107 1400
                //                               108 1599
                //                               109 708
                //                               110 708
                //                               111 1816
                //                               112 1852
                //                               113 2458
                //                               114 1884
                //                               115 1944
                //                               116 1469
                //                               117 708
                //                               118 708
                //                               119 1706
                //                               120 2363
                //                               121 708
                //                               122 2412
                //                               123 2570
                //                               124 2646
                //                               125 2974
                //                               126 2673
                //                               127 708
                //                               128 2034
                //                               129 708
                //                               130 734
                //                               131 708
                //                               132 1026
                //                               133 708
                //                               134 2961
                //                               135 2247
                //                               136 708
                //                               137 2278
                //                               138 2136
                //                               139 1067
                //                               140 708
                //                               141 708
                //                               142 2086
                //                               143 1626
                //                               144 1649
                //                               145 1672
                //                               146 708
                //                               147 2853
                //                               148 708
                //                               149 2171
                //                               150 2057
                //                               151 708
                //                               152 708
                //                               153 708
                //                               154 708
                //                               155 708
                //                               156 708
                //                               157 708
                //                               158 708
                //                               159 708
                //                               160 2201
                //                               161 2224
                //                               162 708
                //                               163 708
                //                               164 708
                //                               165 708
                //                               166 708
                //                               167 708
                //                               168 708
                //                               169 708
                //                               170 2700
                //                               171 2750
                //                               172 708
                //                               173 708
                //                               174 2800
                //                               175 2830
                //                               176 708
                //                               177 708
                //                               178 708
                //                               179 708
                //                               180 2914
                //                               181 2987
                //                               182 3020
                //                               183 1755
                //                               184 3093
                //                               185 708
                //                               186 708
                //                               187 708
                //                               188 708
                //                               189 708
                //                               190 2489
                //                               191 3126
                //                               192 3139
                //                               193 708
                //                               194 3189
                //                               195 3047
                //                               196 3070
                //                               197 708
                //                               198 3223
                //                               199 708
                //                               200 747
                //                               201 708
                //                               202 708
                //                               203 708
                //                               204 708
                //                               205 708
                //                               206 708
                //                               207 708
                //                               208 708
                //                               209 708
                //                               210 3316
                //                               211 3265
                //                               212 3398
                //                               213 3428
                //                               214 3507
                //                               215 3595
                //                               216 708
                //                               217 708
                //                               218 708
                //                               219 708
                //                               220 708
                //                               221 3618
                //                               222 3766
                //                               223 1363
                //                               224 3870
                //                               225 3897;
                       goto _L6 _L7 _L6 _L6 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L6 _L6 _L18 _L19 _L20 _L21 _L22 _L23 _L6 _L6 _L24 _L25 _L6 _L26 _L27 _L28 _L29 _L30 _L6 _L31 _L6 _L32 _L6 _L33 _L6 _L34 _L35 _L6 _L36 _L37 _L38 _L6 _L6 _L39 _L40 _L41 _L42 _L6 _L43 _L6 _L44 _L45 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L46 _L47 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L48 _L49 _L6 _L6 _L50 _L51 _L6 _L6 _L6 _L6 _L52 _L53 _L54 _L55 _L56 _L6 _L6 _L6 _L6 _L6 _L57 _L58 _L59 _L6 _L60 _L61 _L62 _L6 _L63 _L6 _L64 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L65 _L66 _L67 _L68 _L69 _L70 _L6 _L6 _L6 _L6 _L6 _L71 _L72 _L73 _L74 _L75
_L6:
                    break; /* Loop/switch isn't completed */
_L7:
                    nativeRevealSelection(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L32:
                    webkitDraw();
                    break; /* Loop/switch isn't completed */
_L64:
                    WebViewCore webviewcore7 = _fld0;
                    webviewcore7;
                    JVM INSTR monitorenter ;
                    mCallbackProxy.shutdown();
                    synchronized(mCallbackProxy) {
                        mCallbackProxy.notify();
                    }
                    mBrowserFrame.destroy();
                    mBrowserFrame = null;
                    mSettings.onDestroyed();
                    mNativeClass = 0;
                    mWebViewClassic = null;
                    webviewcore7;
                    JVM INSTR monitorexit ;
                    break; /* Loop/switch isn't completed */
                    Exception exception2;
                    exception2;
                    throw exception2;
                    exception3;
                    callbackproxy;
                    JVM INSTR monitorexit ;
                    throw exception3;
_L8:
                    float f;
                    Rect rect2;
                    WebViewCore webviewcore6;
                    int i5;
                    int j5;
                    if(message.obj == null)
                        f = 0.0F;
                    else
                        f = ((Float)message.obj).floatValue();
                    rect2 = new Rect();
                    webviewcore6 = _fld0;
                    i5 = mNativeClass;
                    j5 = message.arg2;
                    webviewcore6.nativeScrollFocusedTextInput(i5, f, j5, rect2);
                    Message.obtain(mWebViewClassic.mPrivateHandler, 152, rect2).sendToTarget();
                    break; /* Loop/switch isn't completed */
_L9:
                    CookieManagerClassic.getInstance().waitForCookieOperationsToComplete();
                    GetUrlData geturldata = (GetUrlData)message.obj;
                    loadUrl(geturldata.mUrl, geturldata.mExtraHeaders);
                    break; /* Loop/switch isn't completed */
_L33:
                    CookieManagerClassic.getInstance().waitForCookieOperationsToComplete();
                    PostUrlData posturldata = (PostUrlData)message.obj;
                    mBrowserFrame.postUrl(posturldata.mUrl, posturldata.mPostData);
                    break; /* Loop/switch isn't completed */
_L38:
                    CookieManagerClassic.getInstance().waitForCookieOperationsToComplete();
                    BaseUrlData baseurldata = (BaseUrlData)message.obj;
                    String s2 = baseurldata.mBaseUrl;
                    if(s2 != null) {
                        int l4 = s2.indexOf(':');
                        if(l4 > 0) {
                            String s3 = s2.substring(0, l4);
                            if(!s3.startsWith("http") && !s3.startsWith("ftp") && !s3.startsWith("about") && !s3.startsWith("javascript"))
                                nativeRegisterURLSchemeAsLocal(mNativeClass, s3);
                        }
                    }
                    mBrowserFrame.loadData(s2, baseurldata.mData, baseurldata.mMimeType, baseurldata.mEncoding, baseurldata.mHistoryUrl);
                    nativeContentInvalidateAll(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L10:
                    if(mBrowserFrame.committed() && !mBrowserFrame.firstLayoutDone())
                        mBrowserFrame.didFirstLayout();
                    stopLoading();
                    break; /* Loop/switch isn't completed */
_L11:
                    mBrowserFrame.reload(false);
                    break; /* Loop/switch isn't completed */
_L12:
                    key((KeyEvent)message.obj, message.arg1, true);
                    break; /* Loop/switch isn't completed */
_L13:
                    key((KeyEvent)message.obj, message.arg1, false);
                    break; /* Loop/switch isn't completed */
_L73:
                    keyPress(message.arg1);
                    break; /* Loop/switch isn't completed */
_L14:
                    viewSizeChanged((WebViewClassic.ViewSizeData)message.obj);
                    break; /* Loop/switch isn't completed */
_L16:
                    Point point = (Point)message.obj;
                    WebViewCore webviewcore5 = _fld0;
                    int k4 = mNativeClass;
                    boolean flag6;
                    if(message.arg1 == 1)
                        flag6 = true;
                    else
                        flag6 = false;
                    webviewcore5.nativeSetScrollOffset(k4, flag6, point.x, point.y);
                    break; /* Loop/switch isn't completed */
_L23:
                    Rect rect1 = (Rect)message.obj;
                    nativeSetGlobalBounds(mNativeClass, rect1.left, rect1.top, rect1.width(), rect1.height());
                    break; /* Loop/switch isn't completed */
_L15:
                    if(!mBrowserFrame.committed() && message.arg1 == -1 && mBrowserFrame.loadType() == 0)
                        mBrowserFrame.reload(true);
                    else
                        mBrowserFrame.goBackOrForward(message.arg1);
                    break; /* Loop/switch isn't completed */
_L17:
                    stopLoading();
                    restoreState(message.arg1);
                    break; /* Loop/switch isn't completed */
_L40:
                    nativePause(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L41:
                    nativeResume(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L42:
                    clearCache(false);
                    nativeFreeMemory(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L24:
                    if(BrowserFrame.sJavaBridge == null)
                        throw new IllegalStateException("No WebView has been created in this process!");
                    JWebCoreJavaBridge jwebcorejavabridge = BrowserFrame.sJavaBridge;
                    boolean flag5;
                    if(message.arg1 == 1)
                        flag5 = true;
                    else
                        flag5 = false;
                    jwebcorejavabridge.setNetworkOnLine(flag5);
                    break; /* Loop/switch isn't completed */
_L55:
                    if(BrowserFrame.sJavaBridge == null)
                        throw new IllegalStateException("No WebView has been created in this process!");
                    Map map = (Map)message.obj;
                    BrowserFrame.sJavaBridge.setNetworkType((String)map.get("type"), (String)map.get("subtype"));
                    break; /* Loop/switch isn't completed */
_L18:
                    WebViewCore webviewcore4 = _fld0;
                    boolean flag4;
                    if(message.arg1 == 1)
                        flag4 = true;
                    else
                        flag4 = false;
                    webviewcore4.clearCache(flag4);
                    break; /* Loop/switch isn't completed */
_L19:
                    mCallbackProxy.getBackForwardList().close(mBrowserFrame.mNativeFrame);
                    break; /* Loop/switch isn't completed */
_L21:
                    ReplaceTextData replacetextdata = (ReplaceTextData)message.obj;
                    nativeReplaceTextfieldText(mNativeClass, message.arg1, message.arg2, replacetextdata.mReplace, replacetextdata.mNewStart, replacetextdata.mNewEnd, replacetextdata.mTextGeneration);
                    break; /* Loop/switch isn't completed */
_L22:
                    JSKeyData jskeydata = (JSKeyData)message.obj;
                    KeyEvent keyevent = jskeydata.mEvent;
                    int l3 = keyevent.getKeyCode();
                    int i4 = keyevent.getUnicodeChar();
                    int j4 = message.arg1;
                    passToJs(mNativeClass, j4, jskeydata.mCurrentText, l3, i4, keyevent.isDown(), keyevent.isShiftPressed(), keyevent.isAltPressed(), keyevent.isSymPressed());
                    break; /* Loop/switch isn't completed */
_L31:
                    nativeSaveDocumentState(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L45:
                    SslCertLookupTable.getInstance().clear();
                    nativeCloseIdleConnections(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L39:
                    WebViewCore webviewcore3 = _fld0;
                    int k3 = mNativeClass;
                    boolean flag3;
                    if(message.arg1 == 1)
                        flag3 = true;
                    else
                        flag3 = false;
                    webviewcore3.nativeSetFocusControllerActive(k3, flag3);
                    break; /* Loop/switch isn't completed */
_L37:
                    JSInterfaceData jsinterfacedata1 = (JSInterfaceData)message.obj;
                    mBrowserFrame.addJavascriptInterface(jsinterfacedata1.mObject, jsinterfacedata1.mInterfaceName);
                    break; /* Loop/switch isn't completed */
_L44:
                    JSInterfaceData jsinterfacedata = (JSInterfaceData)message.obj;
                    mBrowserFrame.removeJavascriptInterface(jsinterfacedata.mInterfaceName);
                    break; /* Loop/switch isn't completed */
_L46:
                    mBrowserFrame.externalRepresentation((Message)message.obj);
                    break; /* Loop/switch isn't completed */
_L47:
                    mBrowserFrame.documentAsText((Message)message.obj);
                    break; /* Loop/switch isn't completed */
_L35:
                    nativeMoveMouse(mNativeClass, message.arg1, message.arg2);
                    break; /* Loop/switch isn't completed */
_L36:
                    WebKitHitTest webkithittest = performHitTest(message.arg1, message.arg2, 1, false);
                    Message message2 = (Message)message.obj;
                    Bundle bundle = message2.getData();
                    bundle.putString("url", webkithittest.mLinkUrl);
                    bundle.putString("title", webkithittest.mAnchorText);
                    bundle.putString("src", webkithittest.mImageUrl);
                    message2.sendToTarget();
                    break; /* Loop/switch isn't completed */
_L25:
                    Message message1 = (Message)message.obj;
                    int j3;
                    if(mBrowserFrame.documentHasImages())
                        j3 = 1;
                    else
                        j3 = 0;
                    message1.arg1 = j3;
                    message1.sendToTarget();
                    break; /* Loop/switch isn't completed */
_L26:
                    TextSelectionData textselectiondata = (TextSelectionData)message.obj;
                    nativeDeleteSelection(mNativeClass, textselectiondata.mStart, textselectiondata.mEnd, message.arg1);
                    break; /* Loop/switch isn't completed */
_L20:
                    nativeSetSelection(mNativeClass, message.arg1, message.arg2);
                    break; /* Loop/switch isn't completed */
_L57:
                    mTextSelectionChangeReason = 1;
                    String s1 = nativeModifySelection(mNativeClass, message.arg1, message.arg2);
                    mWebViewClassic.mPrivateHandler.obtainMessage(130, s1).sendToTarget();
                    mTextSelectionChangeReason = 0;
                    break; /* Loop/switch isn't completed */
_L27:
                    SparseBooleanArray sparsebooleanarray = (SparseBooleanArray)message.obj;
                    int l2 = message.arg1;
                    boolean aflag[] = new boolean[l2];
                    for(int i3 = 0; i3 < l2; i3++)
                        aflag[i3] = sparsebooleanarray.get(i3);

                    nativeSendListBoxChoices(mNativeClass, aflag, l2);
                    break; /* Loop/switch isn't completed */
_L28:
                    nativeSendListBoxChoice(mNativeClass, message.arg1);
                    break; /* Loop/switch isn't completed */
_L30:
                    nativeSetBackgroundColor(mNativeClass, message.arg1);
                    break; /* Loop/switch isn't completed */
_L48:
                    WebViewCore webviewcore2 = _fld0;
                    int k2 = mNativeClass;
                    boolean flag2;
                    if(message.arg1 == 1)
                        flag2 = true;
                    else
                        flag2 = false;
                    webviewcore2.nativeDumpDomTree(k2, flag2);
                    break; /* Loop/switch isn't completed */
_L49:
                    WebViewCore webviewcore1 = _fld0;
                    int j2 = mNativeClass;
                    boolean flag1;
                    if(message.arg1 == 1)
                        flag1 = true;
                    else
                        flag1 = false;
                    webviewcore1.nativeDumpRenderTree(j2, flag1);
                    break; /* Loop/switch isn't completed */
_L50:
                    nativeSetJsFlags(mNativeClass, (String)message.obj);
                    break; /* Loop/switch isn't completed */
_L51:
                    nativeContentInvalidateAll(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L43:
                    WebViewClassic.SaveWebArchiveMessage savewebarchivemessage = (WebViewClassic.SaveWebArchiveMessage)message.obj;
                    savewebarchivemessage.mResultFile = saveWebArchive(savewebarchivemessage.mBasename, savewebarchivemessage.mAutoname);
                    mWebViewClassic.mPrivateHandler.obtainMessage(132, savewebarchivemessage).sendToTarget();
                    break; /* Loop/switch isn't completed */
_L52:
                    GeolocationPermissionsData geolocationpermissionsdata = (GeolocationPermissionsData)message.obj;
                    nativeGeolocationPermissionsProvide(mNativeClass, geolocationpermissionsdata.mOrigin, geolocationpermissionsdata.mAllow, geolocationpermissionsdata.mRemember);
                    break; /* Loop/switch isn't completed */
_L34:
                    clearContent();
                    break; /* Loop/switch isn't completed */
_L29:
                    ((Message)message.obj).sendToTarget();
                    break; /* Loop/switch isn't completed */
_L53:
                    nativeProvideVisitedHistory(mNativeClass, (String[])(String[])message.obj);
                    break; /* Loop/switch isn't completed */
_L54:
                    nativeFullScreenPluginHidden(mNativeClass, message.arg1);
                    break; /* Loop/switch isn't completed */
_L61:
                    nativePluginSurfaceReady(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L62:
                    nativeNotifyAnimationStarted(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L56:
                    if(BrowserFrame.sJavaBridge == null)
                        throw new IllegalStateException("No WebView has been created in this process!");
                    BrowserFrame.sJavaBridge.addPackageNames((Set)message.obj);
                    break; /* Loop/switch isn't completed */
_L58:
                    setUseMockDeviceOrientation();
                    break; /* Loop/switch isn't completed */
_L59:
                    nativeAutoFillForm(mNativeClass, message.arg1);
                    mWebViewClassic.mPrivateHandler.obtainMessage(134, null).sendToTarget();
                    break; /* Loop/switch isn't completed */
_L60:
                    if(message.obj instanceof String)
                        mBrowserFrame.stringByEvaluatingJavaScriptFromString((String)message.obj);
                    break; /* Loop/switch isn't completed */
_L63:
                    int i2 = message.arg1;
                    Rect rect = (Rect)message.obj;
                    nativeScrollLayer(mNativeClass, i2, rect);
                    break; /* Loop/switch isn't completed */
_L66:
                    int ai2[] = (int[])(int[])message.obj;
                    nativeDeleteText(mNativeClass, ai2[0], ai2[1], ai2[2], ai2[3]);
                    break; /* Loop/switch isn't completed */
_L65:
                    int ai1[] = (int[])(int[])message.obj;
                    String s = nativeGetText(mNativeClass, ai1[0], ai1[1], ai1[2], ai1[3]);
                    if(s != null)
                        mWebViewClassic.mPrivateHandler.obtainMessage(141, s).sendToTarget();
                    break; /* Loop/switch isn't completed */
_L67:
                    nativeInsertText(mNativeClass, (String)message.obj);
                    break; /* Loop/switch isn't completed */
_L68:
                    int ai[] = (int[])(int[])message.obj;
                    if(ai == null)
                        nativeClearTextSelection(mNativeClass);
                    else
                        nativeSelectText(mNativeClass, ai[0], ai[1], ai[2], ai[3]);
                    break; /* Loop/switch isn't completed */
_L69:
                    mTextSelectionChangeReason = 2;
                    int k1 = message.arg1;
                    int l1 = message.arg2;
                    if(!nativeSelectWordAt(mNativeClass, k1, l1))
                        mWebViewClassic.mPrivateHandler.obtainMessage(151).sendToTarget();
                    mTextSelectionChangeReason = 0;
                    break; /* Loop/switch isn't completed */
_L70:
                    nativeSelectAll(mNativeClass);
                    break; /* Loop/switch isn't completed */
_L71:
                    FindAllRequest findallrequest1 = (FindAllRequest)message.obj;
                    if(findallrequest1 == null) goto _L77; else goto _L76
_L76:
                    int i1 = nativeFindAll(mNativeClass, findallrequest1.mSearchText);
                    int j1 = nativeFindNext(mNativeClass, true);
                    findallrequest1;
                    JVM INSTR monitorenter ;
                    findallrequest1.mMatchCount = i1;
                    findallrequest1.mMatchIndex = j1;
                    findallrequest1.notify();
                    findallrequest1;
                    JVM INSTR monitorexit ;
_L79:
                    Message.obtain(mWebViewClassic.mPrivateHandler, 126, findallrequest1).sendToTarget();
                    break; /* Loop/switch isn't completed */
                    Exception exception1;
                    exception1;
                    findallrequest1;
                    JVM INSTR monitorexit ;
                    throw exception1;
_L77:
                    nativeFindAll(mNativeClass, null);
                    if(true) goto _L79; else goto _L78
_L78:
                    break; /* Loop/switch isn't completed */
_L72:
                    FindAllRequest findallrequest;
                    findallrequest = (FindAllRequest)message.obj;
                    WebViewCore webviewcore = _fld0;
                    int k = mNativeClass;
                    boolean flag;
                    int l;
                    if(message.arg1 != 0)
                        flag = true;
                    else
                        flag = false;
                    l = webviewcore.nativeFindNext(k, flag);
                    findallrequest;
                    JVM INSTR monitorenter ;
                    findallrequest.mMatchIndex = l;
                    findallrequest;
                    JVM INSTR monitorexit ;
                    Message.obtain(mWebViewClassic.mPrivateHandler, 126, findallrequest).sendToTarget();
                    break; /* Loop/switch isn't completed */
                    Exception exception;
                    exception;
                    findallrequest;
                    JVM INSTR monitorexit ;
                    throw exception;
_L74:
                    nativeSetInitialFocus(mNativeClass, message.arg1);
                    break; /* Loop/switch isn't completed */
_L75:
                    SaveViewStateRequest saveviewstaterequest = (SaveViewStateRequest)message.obj;
                    saveViewState(saveviewstaterequest.mStream, saveviewstaterequest.mCallback);
                    if(true) goto _L5; else goto _L80
_L80:
                }

                final EventHub this$1;

                 {
                    this$1 = EventHub.this;
                    super();
                }
            };
            this;
            JVM INSTR monitorenter ;
            int i = mMessages.size();
            for(int j = 0; j < i; j++)
                mHandler.sendMessage((Message)mMessages.get(j));

            mMessages = null;
            return;
        }

        public boolean dispatchWebKitEvent(WebViewInputDispatcher webviewinputdispatcher, MotionEvent motionevent, int i, int j) {
            if(mNativeClass != 0) goto _L2; else goto _L1
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            switch(i) {
            default:
                flag = false;
                break;

            case 6: // '\006'
                int j1 = Math.round(motionevent.getX());
                int k1 = Math.round(motionevent.getY());
                WebKitHitTest webkithittest = performHitTest(j1, k1, mWebViewClassic.getScaledNavSlop(), true);
                mWebViewClassic.mPrivateHandler.obtainMessage(131, webkithittest).sendToTarget();
                flag = false;
                break;

            case 4: // '\004'
                flag = nativeMouseClick(mNativeClass);
                break;

            case 0: // '\0'
                int k = motionevent.getPointerCount();
                int ai[] = new int[k];
                int ai1[] = new int[k];
                int ai2[] = new int[k];
                for(int l = 0; l < k; l++) {
                    ai[l] = motionevent.getPointerId(l);
                    ai1[l] = (int)motionevent.getX(l);
                    ai2[l] = (int)motionevent.getY(l);
                }

                int i1 = nativeHandleTouchEvent(mNativeClass, motionevent.getActionMasked(), ai, ai1, ai2, k, motionevent.getActionIndex(), motionevent.getMetaState());
                if(i1 == 0 && motionevent.getActionMasked() != 3 && (j & 1) == 0)
                    webviewinputdispatcher.skipWebkitForRemainingTouchStream();
                if((i1 & 2) > 0)
                    flag = true;
                else
                    flag = false;
                break;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public Looper getWebKitLooper() {
            return mHandler.getLooper();
        }

        static final int ADD_JS_INTERFACE = 138;
        static final int ADD_PACKAGE_NAME = 185;
        static final int ADD_PACKAGE_NAMES = 184;
        static final int AUTOFILL_FORM = 192;
        static final int CLEAR_CACHE = 111;
        static final int CLEAR_CONTENT = 134;
        static final int CLEAR_HISTORY = 112;
        static final int CLEAR_SSL_PREF_TABLE = 150;
        static final int CONTENT_INVALIDATE_ALL = 175;
        static final int COPY_TEXT = 210;
        static final int DELETE_SELECTION = 122;
        static final int DELETE_SURROUNDING_TEXT = 129;
        static final int DELETE_TEXT = 211;
        private static final int DESTROY = 200;
        static final int DOC_HAS_IMAGES = 120;
        static final int DUMP_DOMTREE = 170;
        static final int DUMP_RENDERTREE = 171;
        static final int EXECUTE_JS = 194;
        static final int FIND_ALL = 221;
        static final int FIND_NEXT = 222;
        private static final int FIRST_PACKAGE_MSG_ID = 96;
        static final int FREE_MEMORY = 145;
        static final int GEOLOCATION_PERMISSIONS_PROVIDE = 180;
        static final int GO_BACK_FORWARD = 106;
        static final int HEARTBEAT = 197;
        static final int HIDE_FULLSCREEN = 182;
        static final int INSERT_TEXT = 212;
        static final int KEY_DOWN = 103;
        static final int KEY_PRESS = 223;
        static final int KEY_UP = 104;
        private static final int LAST_PACKAGE_MSG_ID = 149;
        static final int LISTBOX_CHOICES = 123;
        static final int LOAD_DATA = 139;
        static final int LOAD_URL = 100;
        public static final int MESSAGE_RELAY = 125;
        static final int MODIFY_SELECTION = 190;
        static final int NOTIFY_ANIMATION_STARTED = 196;
        static final int ON_PAUSE = 143;
        static final int ON_RESUME = 144;
        static final int PASS_TO_JS = 115;
        static final int PAUSE_TIMERS = 109;
        static final int PLUGIN_SURFACE_READY = 195;
        static final int POPULATE_VISITED_LINKS = 181;
        static final int POST_URL = 132;
        static final int PROXY_CHANGED = 193;
        static final int RELOAD = 102;
        static final int REMOVE_JS_INTERFACE = 149;
        static final int REMOVE_PACKAGE_NAME = 186;
        static final int REPLACE_TEXT = 114;
        static final int REQUEST_CURSOR_HREF = 137;
        static final int REQUEST_DOC_AS_TEXT = 161;
        static final int REQUEST_EXT_REPRESENTATION = 160;
        static final int RESTORE_STATE = 108;
        static final int RESUME_TIMERS = 110;
        static final int REVEAL_SELECTION = 96;
        static final int SAVE_DOCUMENT_STATE = 128;
        static final int SAVE_VIEW_STATE = 225;
        static final int SAVE_WEBARCHIVE = 147;
        static final int SCROLL_LAYER = 198;
        static final int SCROLL_TEXT_INPUT = 99;
        static final int SELECT_ALL = 215;
        static final int SELECT_TEXT = 213;
        static final int SELECT_WORD_AT = 214;
        static final int SET_ACTIVE = 142;
        static final int SET_BACKGROUND_COLOR = 126;
        static final int SET_GLOBAL_BOUNDS = 116;
        static final int SET_INITIAL_FOCUS = 224;
        static final int SET_JS_FLAGS = 174;
        static final int SET_MOVE_MOUSE = 135;
        static final int SET_NETWORK_STATE = 119;
        static final int SET_NETWORK_TYPE = 183;
        static final int SET_SCROLL_OFFSET = 107;
        static final int SET_SELECTION = 113;
        static final int SET_USE_MOCK_DEVICE_ORIENTATION = 191;
        static final int SINGLE_LISTBOX_CHOICE = 124;
        static final int STOP_LOADING = 101;
        static final int TRUST_STORAGE_UPDATED = 220;
        static final int VIEW_SIZE_CHANGED = 105;
        static final int WEBKIT_DRAW = 130;
        private boolean mBlockMessages;
        private boolean mDestroying;
        private Handler mHandler;
        private LinkedList mMessages;
        private int mSavedPriority;
        private int mTid;
        final WebViewCore this$0;



/*
        static boolean access$1202(EventHub eventhub, boolean flag) {
            eventhub.mDestroying = flag;
            return flag;
        }

*/










/*
        static int access$802(EventHub eventhub, int i) {
            eventhub.mSavedPriority = i;
            return i;
        }

*/


        private EventHub() {
            this$0 = WebViewCore.this;
            super();
            mMessages = new LinkedList();
        }

    }

    static class SaveViewStateRequest {

        public ValueCallback mCallback;
        public OutputStream mStream;

        SaveViewStateRequest(OutputStream outputstream, ValueCallback valuecallback) {
            mStream = outputstream;
            mCallback = valuecallback;
        }
    }

    static class FindAllRequest {

        public int mMatchCount;
        public int mMatchIndex;
        public final String mSearchText;

        public FindAllRequest(String s) {
            mSearchText = s;
            mMatchCount = -1;
            mMatchIndex = -1;
        }
    }

    static class GeolocationPermissionsData {

        boolean mAllow;
        String mOrigin;
        boolean mRemember;

        GeolocationPermissionsData() {
        }
    }

    static class TouchEventData {

        int mAction;
        int mActionIndex;
        int mIds[];
        int mMetaState;
        MotionEvent mMotionEvent;
        int mNativeLayer;
        Rect mNativeLayerRect;
        boolean mNativeResult;
        Point mPoints[];
        Point mPointsInView[];
        boolean mReprocess;
        long mSequence;

        TouchEventData() {
            mNativeLayerRect = new Rect();
        }
    }

    static class TextFieldInitData {

        public Rect mContentBounds;
        public Rect mContentRect;
        public int mFieldPointer;
        public boolean mIsAutoCompleteEnabled;
        public boolean mIsSpellCheckEnabled;
        public boolean mIsTextFieldNext;
        public boolean mIsTextFieldPrev;
        public String mLabel;
        public int mMaxLength;
        public String mName;
        public int mNodeLayerId;
        public String mText;
        public int mType;

        TextFieldInitData() {
        }
    }

    static class AutoFillData {

        public String getPreviewString() {
            return mPreview;
        }

        public int getQueryId() {
            return mQueryId;
        }

        private String mPreview;
        private int mQueryId;

        public AutoFillData() {
            mQueryId = -1;
            mPreview = "";
        }

        public AutoFillData(int i, String s) {
            mQueryId = i;
            mPreview = s;
        }
    }

    static class WebKitHitTest {

        String mAltDisplayString;
        String mAnchorText;
        boolean mEditable;
        Rect mEnclosingParentRects[];
        boolean mHasFocus;
        boolean mHitTestMovedMouse;
        int mHitTestSlop;
        int mHitTestX;
        int mHitTestY;
        String mImageUrl;
        String mIntentUrl;
        String mLinkUrl;
        int mTapHighlightColor;
        String mTitle;
        Rect mTouchRects[];

        WebKitHitTest() {
            mTapHighlightColor = 0x6633b5e5;
        }
    }

    static class TouchHighlightData {

        int mNativeLayer;
        Rect mNativeLayerRect;
        int mSlop;
        int mX;
        int mY;

        TouchHighlightData() {
        }
    }

    static class TouchUpData {

        int mFrame;
        int mMoveGeneration;
        int mNativeLayer;
        Rect mNativeLayerRect;
        int mNode;
        int mX;
        int mY;

        TouchUpData() {
            mNativeLayerRect = new Rect();
        }
    }

    static class TextSelectionData {

        static final int REASON_ACCESSIBILITY_INJECTOR = 1;
        static final int REASON_SELECT_WORD = 2;
        static final int REASON_UNKNOWN;
        int mEnd;
        int mSelectTextPtr;
        int mSelectionReason;
        int mStart;

        public TextSelectionData(int i, int j, int k) {
            mSelectionReason = 0;
            mStart = i;
            mEnd = j;
            mSelectTextPtr = k;
        }
    }

    static class ReplaceTextData {

        int mNewEnd;
        int mNewStart;
        String mReplace;
        int mTextGeneration;

        ReplaceTextData() {
        }
    }

    static class PostUrlData {

        byte mPostData[];
        String mUrl;

        PostUrlData() {
        }
    }

    static class GetUrlData {

        Map mExtraHeaders;
        String mUrl;

        GetUrlData() {
        }
    }

    static class MotionUpData {

        Rect mBounds;
        int mFrame;
        int mNode;
        int mX;
        int mY;

        MotionUpData() {
        }
    }

    static class JSKeyData {

        String mCurrentText;
        KeyEvent mEvent;

        JSKeyData() {
        }
    }

    static class JSInterfaceData {

        String mInterfaceName;
        Object mObject;

        JSInterfaceData() {
        }
    }

    static class BaseUrlData {

        String mBaseUrl;
        String mData;
        String mEncoding;
        String mHistoryUrl;
        String mMimeType;

        BaseUrlData() {
        }
    }

    private static class WebCoreThread
        implements Runnable {

        public void run() {
            Looper.prepare();
            Assert.assertNull(WebViewCore.sWebCoreHandler);
            android/webkit/WebViewCore;
            JVM INSTR monitorenter ;
            WebViewCore.sWebCoreHandler = new Handler() {

                public void handleMessage(Message message) {
                    message.what;
                    JVM INSTR lookupswitch 8: default 80
                //                               0: 81
                //                               1: 94
                //                               2: 101
                //                               185: 108
                //                               186: 140
                //                               193: 172
                //                               197: 204
                //                               220: 217;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
                    return;
_L2:
                    ((WebViewCore)message.obj).initialize();
                    continue; /* Loop/switch isn't completed */
_L3:
                    Process.setThreadPriority(3);
                    continue; /* Loop/switch isn't completed */
_L4:
                    Process.setThreadPriority(0);
                    continue; /* Loop/switch isn't completed */
_L5:
                    if(BrowserFrame.sJavaBridge == null)
                        throw new IllegalStateException("No WebView has been created in this process!");
                    BrowserFrame.sJavaBridge.addPackageName((String)message.obj);
                    continue; /* Loop/switch isn't completed */
_L6:
                    if(BrowserFrame.sJavaBridge == null)
                        throw new IllegalStateException("No WebView has been created in this process!");
                    BrowserFrame.sJavaBridge.removePackageName((String)message.obj);
                    continue; /* Loop/switch isn't completed */
_L7:
                    if(BrowserFrame.sJavaBridge == null)
                        throw new IllegalStateException("No WebView has been created in this process!");
                    BrowserFrame.sJavaBridge.updateProxy((ProxyProperties)message.obj);
                    continue; /* Loop/switch isn't completed */
_L8:
                    ((Message)message.obj).sendToTarget();
                    continue; /* Loop/switch isn't completed */
_L9:
                    WebViewCore.nativeCertTrustChanged();
                    CertificateChainValidator.handleTrustStorageUpdate();
                    if(true) goto _L1; else goto _L10
_L10:
                }

                final WebCoreThread this$0;

                 {
                    this$0 = WebCoreThread.this;
                    super();
                }
            };
            android/webkit/WebViewCore.notify();
            android/webkit/WebViewCore;
            JVM INSTR monitorexit ;
            Looper.loop();
            return;
            Exception exception;
            exception;
            android/webkit/WebViewCore;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private static final int INITIALIZE = 0;
        private static final int REDUCE_PRIORITY = 1;
        private static final int RESUME_PRIORITY = 2;

        private WebCoreThread() {
        }

    }


    public WebViewCore(Context context, WebViewClassic webviewclassic, CallbackProxy callbackproxy, Map map) {
        mViewportWidth = -1;
        mViewportHeight = -1;
        mViewportInitialScale = 0;
        mViewportMinimumScale = 0;
        mViewportMaximumScale = 0;
        mViewportUserScalable = true;
        mViewportDensityDpi = -1;
        mIsRestored = false;
        mRestoredScale = 0.0F;
        mRestoredTextWrapScale = 0.0F;
        mRestoredX = 0;
        mRestoredY = 0;
        mDeviceMotionAndOrientationManager = new DeviceMotionAndOrientationManager(this);
        mTextSelectionChangeReason = 0;
        mCurrentViewWidth = 0;
        mCurrentViewHeight = 0;
        mCurrentViewScale = 1.0F;
        mInitialViewState = null;
        mLastDrawData = null;
        m_skipDrawFlagLock = new Object();
        m_skipDrawFlag = false;
        m_drawWasSkipped = false;
        mCallbackProxy = callbackproxy;
        mWebViewClassic = webviewclassic;
        mJavascriptInterfaces = map;
        mContext = context;
        android/webkit/WebViewCore;
        JVM INSTR monitorenter ;
        if(sWebCoreHandler != null)
            break MISSING_BLOCK_LABEL_207;
        Thread thread = new Thread(new WebCoreThread());
        thread.setName("WebViewCoreThread");
        thread.start();
        try {
            android/webkit/WebViewCore.wait();
        }
        catch(InterruptedException interruptedexception) {
            Log.e("webcore", "Caught exception while waiting for thread creation.");
            Log.e("webcore", Log.getStackTraceString(interruptedexception));
        }
        if(sShouldMonitorWebCoreThread)
            WebCoreThreadWatchdog.start(sWebCoreHandler);
        WebCoreThreadWatchdog.registerWebView(webviewclassic);
        android/webkit/WebViewCore;
        JVM INSTR monitorexit ;
        mEventHub = new EventHub();
        mSettings = new WebSettingsClassic(mContext, mWebViewClassic);
        WebIconDatabase.getInstance();
        WebStorageClassic.getInstance().createUIHandler();
        GeolocationPermissionsClassic.getInstance().createUIHandler();
        ActivityManager activitymanager = (ActivityManager)mContext.getSystemService("activity");
        activitymanager.getMemoryInfo(new android.app.ActivityManager.MemoryInfo());
        mLowMemoryUsageThresholdMb = activitymanager.getLargeMemoryClass();
        mHighMemoryUsageThresholdMb = (int)(1.5D * (double)mLowMemoryUsageThresholdMb);
        mHighUsageDeltaMb = mLowMemoryUsageThresholdMb / 32;
        Message message = sWebCoreHandler.obtainMessage(0, this);
        sWebCoreHandler.sendMessage(message);
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private ViewManager.ChildView addSurface(View view, int i, int j, int k, int l) {
        ViewManager.ChildView childview = createSurface(view);
        childview.attachView(i, j, k, l);
        return childview;
    }

    private int calculateWindowWidth(int i) {
        int j = i;
        if(mSettings.getUseWideViewPort())
            if(mViewportWidth == -1)
                j = 980;
            else
            if(mViewportWidth > 0)
                j = mViewportWidth;
            else
                j = Math.round((float)mWebViewClassic.getViewWidth() / mWebViewClassic.getDefaultZoomScale());
        return j;
    }

    private void centerFitRect(int i, int j, int k, int l) {
        if(mWebViewClassic != null)
            mWebViewClassic.mPrivateHandler.obtainMessage(127, new Rect(i, j, i + k, j + l)).sendToTarget();
    }

    private boolean chromeCanTakeFocus(int i) {
        int j = mapDirection(i);
        boolean flag;
        if(j == mChromeCanFocusDirection && j != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void chromeTakeFocus(int i) {
        if(mWebViewClassic != null) {
            Message message = mWebViewClassic.mPrivateHandler.obtainMessage(110);
            message.arg1 = mapDirection(i);
            message.sendToTarget();
        }
    }

    private void clearCache(boolean flag) {
        mBrowserFrame.clearCache();
        if(flag)
            CacheManager.removeAllCacheFiles();
    }

    private void clearTextEntry() {
        if(mWebViewClassic != null)
            Message.obtain(mWebViewClassic.mPrivateHandler, 111).sendToTarget();
    }

    private void contentScrollTo(int i, int j, boolean flag, boolean flag1) {
        int k = 1;
        if(mBrowserFrame.firstLayoutDone()) goto _L2; else goto _L1
_L1:
        mRestoredX = i;
        mRestoredY = j;
_L4:
        return;
_L2:
        if(mWebViewClassic != null) {
            Handler handler = mWebViewClassic.mPrivateHandler;
            int l;
            Message message;
            if(flag)
                l = k;
            else
                l = 0;
            if(!flag1)
                k = 0;
            message = Message.obtain(handler, 101, l, k, new Point(i, j));
            if(mDrawIsScheduled)
                mEventHub.sendMessage(Message.obtain(null, 125, message));
            else
                message.sendToTarget();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private ViewManager.ChildView createSurface(View view) {
        ViewManager.ChildView childview = null;
        if(mWebViewClassic != null)
            if(view == null) {
                Log.e("webcore", "Attempted to add an empty plugin view to the view hierarchy");
            } else {
                view.setWillNotDraw(false);
                if(view instanceof SurfaceView)
                    ((SurfaceView)view).setZOrderOnTop(true);
                childview = mWebViewClassic.mViewManager.createView();
                childview.mView = view;
            }
        return childview;
    }

    private TextSelectionData createTextSelection(int i, int j, int k) {
        TextSelectionData textselectiondata = new TextSelectionData(i, j, k);
        textselectiondata.mSelectionReason = mTextSelectionChangeReason;
        return textselectiondata;
    }

    private void destroySurface(ViewManager.ChildView childview) {
        childview.removeView();
    }

    private void didFirstLayout(boolean flag) {
        mBrowserFrame.didFirstLayout();
        if(mWebViewClassic != null) {
            boolean flag1;
            if(flag || mIsRestored)
                flag1 = true;
            else
                flag1 = false;
            setupViewport(flag1);
            if(!flag1)
                mWebViewClassic.mViewManager.postReadyToDrawAll();
            mWebViewClassic.mPrivateHandler.sendEmptyMessage(131);
            mRestoredY = 0;
            mRestoredX = 0;
            mIsRestored = false;
            mRestoredTextWrapScale = 0.0F;
            mRestoredScale = 0.0F;
        }
    }

    private void focusNodeChanged(int i, WebKitHitTest webkithittest) {
        if(mWebViewClassic != null)
            mWebViewClassic.mPrivateHandler.obtainMessage(147, i, 0, webkithittest).sendToTarget();
    }

    private Class getPluginClass(String s, String s1) {
        Class class1 = null;
        if(mWebViewClassic != null) goto _L2; else goto _L1
_L1:
        return class1;
_L2:
        PluginManager pluginmanager;
        String s2;
        pluginmanager = PluginManager.getInstance(null);
        s2 = pluginmanager.getPluginsAPKName(s);
        if(s2 == null) {
            Log.w("webcore", (new StringBuilder()).append("Unable to resolve ").append(s).append(" to a plugin APK").toString());
            continue; /* Loop/switch isn't completed */
        }
        Class class2 = pluginmanager.getPluginClass(s2, s1);
        class1 = class2;
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.e("webcore", (new StringBuilder()).append("Unable to find plugin classloader for the apk (").append(s2).append(")").toString());
        continue; /* Loop/switch isn't completed */
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        Log.e("webcore", (new StringBuilder()).append("Unable to find plugin class (").append(s1).append(") in the apk (").append(s2).append(")").toString());
        if(true) goto _L1; else goto _L3
_L3:
    }

    private long getUsedQuota() {
        Collection collection = WebStorageClassic.getInstance().getOriginsSync();
        long l;
        if(collection == null) {
            l = 0L;
        } else {
            l = 0L;
            Iterator iterator = collection.iterator();
            while(iterator.hasNext()) 
                l += ((WebStorage.Origin)iterator.next()).getQuota();
        }
        return l;
    }

    private WebView getWebView() {
        return mWebViewClassic.getWebView();
    }

    private void hideFullScreenPlugin() {
        if(mWebViewClassic != null)
            mWebViewClassic.mPrivateHandler.obtainMessage(121).sendToTarget();
    }

    private void initEditField(int i, int j, int k, TextFieldInitData textfieldinitdata) {
        if(mWebViewClassic != null) {
            Message.obtain(mWebViewClassic.mPrivateHandler, 142, textfieldinitdata).sendToTarget();
            Message.obtain(mWebViewClassic.mPrivateHandler, 112, textfieldinitdata.mFieldPointer, 0, createTextSelection(i, j, k)).sendToTarget();
        }
    }

    private void initialize() {
        mBrowserFrame = new BrowserFrame(mContext, this, mCallbackProxy, mSettings, mJavascriptInterfaces);
        mJavascriptInterfaces = null;
        mSettings.syncSettingsAndCreateHandler(mBrowserFrame);
        WebIconDatabaseClassic.getInstance().createHandler();
        WebStorageClassic.getInstance().createHandler();
        GeolocationPermissionsClassic.getInstance().createHandler();
        mEventHub.transferMessages();
        if(mWebViewClassic != null)
            Message.obtain(mWebViewClassic.mPrivateHandler, 107, mNativeClass, 0).sendToTarget();
    }

    static boolean isSupportedMediaMimeType(String s) {
        int i = MediaFile.getFileTypeForMimeType(s);
        boolean flag;
        if(MediaFile.isAudioFileType(i) || MediaFile.isVideoFileType(i) || MediaFile.isPlayListFileType(i) || s != null && s.startsWith("video/m4v"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    static boolean isUpdatePicturePaused(WebViewCore webviewcore) {
        boolean flag;
        if(webviewcore != null)
            flag = webviewcore.mDrawIsPaused;
        else
            flag = false;
        return flag;
    }

    private void keepScreenOn(boolean flag) {
        if(mWebViewClassic != null) {
            Message message = mWebViewClassic.mPrivateHandler.obtainMessage(136);
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            message.arg1 = i;
            message.sendToTarget();
        }
    }

    private void key(KeyEvent keyevent, int i, boolean flag) {
        mChromeCanFocusDirection = i;
        int j = keyevent.getKeyCode();
        int k = keyevent.getUnicodeChar();
        if(j == 0 && keyevent.getCharacters() != null && keyevent.getCharacters().length() > 0)
            k = keyevent.getCharacters().codePointAt(0);
        boolean flag1 = nativeKey(mNativeClass, j, k, keyevent.getRepeatCount(), keyevent.isShiftPressed(), keyevent.isAltPressed(), keyevent.isSymPressed(), flag);
        mChromeCanFocusDirection = 0;
        if(!flag1 && j != 66)
            if(j >= 19 && j <= 22) {
                if(i != 0 && flag) {
                    Message message = mWebViewClassic.mPrivateHandler.obtainMessage(110);
                    message.arg1 = i;
                    message.sendToTarget();
                }
            } else {
                mCallbackProxy.onUnhandledKeyEvent(keyevent);
            }
    }

    private void keyPress(int i) {
        nativeKey(mNativeClass, 0, i, 0, false, false, false, true);
        nativeKey(mNativeClass, 0, i, 0, false, false, false, false);
    }

    private void loadUrl(String s, Map map) {
        mBrowserFrame.loadUrl(s, map);
    }

    private int mapDirection(int i) {
        i;
        JVM INSTR tableswitch 1 6: default 40
    //                   1 44
    //                   2 49
    //                   3 54
    //                   4 60
    //                   5 67
    //                   6 73;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        int j = 0;
_L9:
        return j;
_L2:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 33;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 130;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 17;
        continue; /* Loop/switch isn't completed */
_L7:
        j = 66;
        if(true) goto _L9; else goto _L8
_L8:
    }

    private native void nativeAutoFillForm(int i, int j);

    private static native void nativeCertTrustChanged();

    private native void nativeClearContent(int i);

    private native void nativeClearTextSelection(int i);

    private native void nativeCloseIdleConnections(int i);

    private native void nativeContentInvalidateAll(int i);

    private native void nativeDeleteSelection(int i, int j, int k, int l);

    private native void nativeDeleteText(int i, int j, int k, int l, int i1);

    private native void nativeDumpDomTree(int i, boolean flag);

    private native void nativeDumpRenderTree(int i, boolean flag);

    static native String nativeFindAddress(String s, boolean flag);

    private native int nativeFindAll(int i, String s);

    private native int nativeFindNext(int i, boolean flag);

    private native boolean nativeFocusBoundsChanged(int i);

    private native void nativeFreeMemory(int i);

    private native void nativeFullScreenPluginHidden(int i, int j);

    private native void nativeGeolocationPermissionsProvide(int i, String s, boolean flag, boolean flag1);

    private native int nativeGetContentMinPrefWidth(int i);

    private native String nativeGetText(int i, int j, int k, int l, int i1);

    private native int nativeHandleTouchEvent(int i, int j, int ai[], int ai1[], int ai2[], int k, int l, 
            int i1);

    private native WebKitHitTest nativeHitTest(int i, int j, int k, int l, boolean flag);

    private native void nativeInsertText(int i, String s);

    private native boolean nativeKey(int i, int j, int k, int l, boolean flag, boolean flag1, boolean flag2, 
            boolean flag3);

    private native String nativeModifySelection(int i, int j, int k);

    private native boolean nativeMouseClick(int i);

    private native void nativeMoveMouse(int i, int j, int k);

    private native void nativeNotifyAnimationStarted(int i);

    private native void nativePause(int i);

    private native void nativePluginSurfaceReady(int i);

    private native void nativeProvideVisitedHistory(int i, String as[]);

    private native int nativeRecordContent(int i, Point point);

    private native void nativeRegisterURLSchemeAsLocal(int i, String s);

    private native void nativeReplaceTextfieldText(int i, int j, int k, String s, int l, int i1, int j1);

    private native String nativeRequestLabel(int i, int j, int k);

    private native void nativeResume(int i);

    private native String nativeRetrieveAnchorText(int i, int j, int k);

    private native String nativeRetrieveHref(int i, int j, int k);

    private native String nativeRetrieveImageSource(int i, int j, int k);

    private native void nativeRevealSelection(int i);

    private native void nativeSaveDocumentState(int i);

    private native void nativeScrollFocusedTextInput(int i, float f, int j, Rect rect);

    private native void nativeScrollLayer(int i, int j, Rect rect);

    private native void nativeSelectAll(int i);

    private native void nativeSelectText(int i, int j, int k, int l, int i1);

    private native boolean nativeSelectWordAt(int i, int j, int k);

    private native void nativeSendListBoxChoice(int i, int j);

    private native void nativeSendListBoxChoices(int i, boolean aflag[], int j);

    private native void nativeSetBackgroundColor(int i, int j);

    private native void nativeSetFocusControllerActive(int i, boolean flag);

    private native void nativeSetGlobalBounds(int i, int j, int k, int l, int i1);

    private native void nativeSetInitialFocus(int i, int j);

    private native void nativeSetIsPaused(int i, boolean flag);

    private native void nativeSetJsFlags(int i, String s);

    private native void nativeSetNewStorageLimit(int i, long l);

    private native void nativeSetScrollOffset(int i, boolean flag, int j, int k);

    private native void nativeSetSelection(int i, int j, int k);

    private native void nativeSetSize(int i, int j, int k, int l, float f, int i1, int j1, 
            int k1, int l1, boolean flag);

    private void needTouchEvents(boolean flag) {
        if(mWebViewClassic != null) {
            Handler handler = mWebViewClassic.mPrivateHandler;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            Message.obtain(handler, 116, i, 0).sendToTarget();
        }
    }

    private String openFileChooser(String s, String s1) {
        Uri uri;
        String s3;
        Cursor cursor;
        uri = mCallbackProxy.openFileChooser(s, s1);
        if(uri == null)
            break MISSING_BLOCK_LABEL_129;
        s3 = "";
        ContentResolver contentresolver = mContext.getContentResolver();
        String as[] = new String[1];
        as[0] = "_data";
        cursor = contentresolver.query(uri, as, null, null, null);
        if(cursor == null) goto _L2; else goto _L1
_L1:
        String s4;
        if(!cursor.moveToNext())
            break MISSING_BLOCK_LABEL_82;
        s4 = cursor.getString(0);
        s3 = s4;
        cursor.close();
_L3:
        String s2;
        s2 = uri.toString();
        BrowserFrame.sJavaBridge.storeFilePathForContentUri(s3, s2);
_L4:
        return s2;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
_L2:
        s3 = uri.getLastPathSegment();
          goto _L3
        s2 = "";
          goto _L4
    }

    private native void passToJs(int i, int j, String s, int k, int l, boolean flag, boolean flag1, 
            boolean flag2, boolean flag3);

    public static void pauseTimers() {
        if(BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException("No WebView has been created in this process!");
        } else {
            BrowserFrame.sJavaBridge.pause();
            return;
        }
    }

    static void pauseUpdatePicture(WebViewCore webviewcore) {
        if(webviewcore != null && webviewcore.getSettings().enableSmoothTransition()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        webviewcore;
        JVM INSTR monitorenter ;
        if(webviewcore.mNativeClass != 0)
            break MISSING_BLOCK_LABEL_43;
        Log.w("webcore", "Cannot pauseUpdatePicture, core destroyed or not initialized!");
          goto _L1
        Exception exception;
        exception;
        throw exception;
        webviewcore.nativeSetIsPaused(webviewcore.mNativeClass, true);
        webviewcore.mDrawIsPaused = true;
        webviewcore;
        JVM INSTR monitorexit ;
          goto _L1
    }

    private WebKitHitTest performHitTest(int i, int j, int k, boolean flag) {
        WebKitHitTest webkithittest = nativeHitTest(mNativeClass, i, j, k, flag);
        webkithittest.mHitTestX = i;
        webkithittest.mHitTestY = j;
        webkithittest.mHitTestSlop = k;
        webkithittest.mHitTestMovedMouse = flag;
        return webkithittest;
    }

    static void reducePriority() {
        sWebCoreHandler.removeMessages(1);
        sWebCoreHandler.removeMessages(2);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler.obtainMessage(1));
    }

    private void requestKeyboard(boolean flag) {
        if(mWebViewClassic != null) {
            Handler handler = mWebViewClassic.mPrivateHandler;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            Message.obtain(handler, 118, i, 0).sendToTarget();
        }
    }

    private void requestListBox(String as[], int ai[], int i) {
        if(mWebViewClassic != null)
            mWebViewClassic.requestListBox(as, ai, i);
    }

    private void requestListBox(String as[], int ai[], int ai1[]) {
        if(mWebViewClassic != null)
            mWebViewClassic.requestListBox(as, ai, ai1);
    }

    private void restoreScale(float f, float f1) {
        if(!mBrowserFrame.firstLayoutDone()) {
            mIsRestored = true;
            mRestoredScale = f;
            if(mSettings.getUseWideViewPort())
                mRestoredTextWrapScale = f1;
        }
    }

    private void restoreState(int i) {
        WebBackForwardList webbackforwardlist = mCallbackProxy.getBackForwardList();
        int j = webbackforwardlist.getSize();
        for(int k = 0; k < j; k++)
            webbackforwardlist.getItemAtIndex(k).inflate(mBrowserFrame.mNativeFrame);

        mBrowserFrame.mLoadInitFromJava = true;
        WebBackForwardList.restoreIndex(mBrowserFrame.mNativeFrame, i);
        mBrowserFrame.mLoadInitFromJava = false;
    }

    static void resumePriority() {
        sWebCoreHandler.removeMessages(1);
        sWebCoreHandler.removeMessages(2);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler.obtainMessage(2));
    }

    public static void resumeTimers() {
        if(BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException("No WebView has been created in this process!");
        } else {
            BrowserFrame.sJavaBridge.resume();
            return;
        }
    }

    static void resumeUpdatePicture(WebViewCore webviewcore) {
        if(webviewcore != null && webviewcore.mDrawIsPaused) goto _L2; else goto _L1
_L1:
        return;
_L2:
        webviewcore;
        JVM INSTR monitorenter ;
        if(webviewcore.mNativeClass != 0)
            break MISSING_BLOCK_LABEL_40;
        Log.w("webcore", "Cannot resumeUpdatePicture, core destroyed!");
          goto _L1
        Exception exception;
        exception;
        throw exception;
        webviewcore.nativeSetIsPaused(webviewcore.mNativeClass, false);
        webviewcore.mDrawIsPaused = false;
        webviewcore.mDrawIsScheduled = false;
        webviewcore;
        JVM INSTR monitorexit ;
          goto _L1
    }

    private void saveViewState(OutputStream outputstream, ValueCallback valuecallback) {
        DrawData drawdata;
        boolean flag;
        drawdata = new DrawData();
        drawdata.mBaseLayer = nativeRecordContent(mNativeClass, drawdata.mContentSize);
        flag = false;
        boolean flag1 = ViewStateSerializer.serializeViewState(outputstream, drawdata);
        flag = flag1;
_L2:
        valuecallback.onReceiveValue(Boolean.valueOf(flag));
        if(drawdata.mBaseLayer != 0) {
            if(mDrawIsScheduled) {
                mDrawIsScheduled = false;
                mEventHub.removeMessages(130);
            }
            mLastDrawData = drawdata;
            webkitDraw(drawdata);
        }
        return;
        Throwable throwable;
        throwable;
        Log.w("webcore", "Failed to save view state", throwable);
        if(true) goto _L2; else goto _L1
_L1:
    }

    private String saveWebArchive(String s, boolean flag) {
        return mBrowserFrame.saveWebArchive(s, flag);
    }

    private void selectAt(int i, int j) {
    }

    private void sendNotifyProgressFinished() {
        contentDraw();
    }

    private void sendPluginDrawMsg() {
        sendMessage(195);
    }

    static void sendStaticMessage(int i, Object obj) {
        if(sWebCoreHandler != null)
            sWebCoreHandler.sendMessage(sWebCoreHandler.obtainMessage(i, obj));
    }

    private void sendViewInvalidate(int i, int j, int k, int l) {
        if(mWebViewClassic != null)
            Message.obtain(mWebViewClassic.mPrivateHandler, 117, new Rect(i, j, k, l)).sendToTarget();
    }

    private void setScrollbarModes(int i, int j) {
        if(mWebViewClassic != null)
            mWebViewClassic.mPrivateHandler.obtainMessage(129, i, j).sendToTarget();
    }

    static void setShouldMonitorWebCoreThread() {
        sShouldMonitorWebCoreThread = true;
    }

    private void setUseMockDeviceOrientation() {
        mDeviceMotionAndOrientationManager.setUseMock();
    }

    private native void setViewportSettingsFromNative(int i);

    private void setWebTextViewAutoFillable(int i, String s) {
        if(mWebViewClassic != null)
            Message.obtain(mWebViewClassic.mPrivateHandler, 133, new AutoFillData(i, s)).sendToTarget();
    }

    private void setupViewport(boolean flag) {
        if(mWebViewClassic != null && mSettings != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float f;
        setViewportSettingsFromNative(mNativeClass);
        if(mViewportInitialScale > 0) {
            if(mViewportMinimumScale > 0)
                mViewportInitialScale = Math.max(mViewportInitialScale, mViewportMinimumScale);
            if(mViewportMaximumScale > 0)
                mViewportInitialScale = Math.min(mViewportInitialScale, mViewportMaximumScale);
        }
        if(mSettings.forceUserScalable()) {
            mViewportUserScalable = true;
            int i;
            ViewState viewstate6;
            if(mViewportInitialScale > 0) {
                if(mViewportMinimumScale > 0)
                    mViewportMinimumScale = Math.min(mViewportMinimumScale, mViewportInitialScale / 2);
                if(mViewportMaximumScale > 0)
                    mViewportMaximumScale = Math.max(mViewportMaximumScale, 2 * mViewportInitialScale);
            } else {
                if(mViewportMinimumScale > 0)
                    mViewportMinimumScale = Math.min(mViewportMinimumScale, 50);
                if(mViewportMaximumScale > 0)
                    mViewportMaximumScale = Math.max(mViewportMaximumScale, 200);
            }
        }
        f = 1.0F;
        if(mViewportDensityDpi != -1) goto _L4; else goto _L3
_L3:
        f = mContext.getResources().getDisplayMetrics().density;
_L5:
        mWebViewClassic.mPrivateHandler.removeMessages(139);
        if(f != mWebViewClassic.getDefaultZoomScale())
            Message.obtain(mWebViewClassic.mPrivateHandler, 139, Float.valueOf(f)).sendToTarget();
        i = (int)(100F * f);
        if(mViewportInitialScale > 0)
            mViewportInitialScale = (int)(f * (float)mViewportInitialScale);
        if(mViewportMinimumScale > 0)
            mViewportMinimumScale = (int)(f * (float)mViewportMinimumScale);
        if(mViewportMaximumScale > 0)
            mViewportMaximumScale = (int)(f * (float)mViewportMaximumScale);
        if(mViewportWidth == 0 && mViewportInitialScale == 0)
            mViewportInitialScale = i;
        if(!mViewportUserScalable) {
            mViewportInitialScale = i;
            mViewportMinimumScale = i;
            mViewportMaximumScale = i;
        }
        if(mViewportMinimumScale > mViewportInitialScale && mViewportInitialScale != 0)
            mViewportMinimumScale = mViewportInitialScale;
        if(mViewportMaximumScale > 0 && mViewportMaximumScale < mViewportInitialScale)
            mViewportMaximumScale = mViewportInitialScale;
        if(mViewportWidth < 0 && mViewportInitialScale == i)
            mViewportWidth = 0;
        if(mViewportWidth != 0 && !flag) {
            mFirstLayoutForNonStandardLoad = true;
            viewstate6 = new ViewState();
            viewstate6.mMinScale = (float)mViewportMinimumScale / 100F;
            viewstate6.mMaxScale = (float)mViewportMaximumScale / 100F;
            viewstate6.mDefaultScale = f;
            viewstate6.mMobileSite = false;
            viewstate6.mScrollX = 0;
            viewstate6.mShouldStartScrolledRight = false;
            Message.obtain(mWebViewClassic.mPrivateHandler, 109, viewstate6).sendToTarget();
        } else {
            int j = mCurrentViewWidth;
            int k;
            ViewState viewstate;
            boolean flag1;
            ViewState viewstate1;
            boolean flag2;
            if(j == 0) {
                k = mWebViewClassic.getViewWidth();
                j = (int)((float)k / f);
                if(j != 0);
            } else {
                k = Math.round((float)j * mCurrentViewScale);
            }
            mInitialViewState = new ViewState();
            mInitialViewState.mMinScale = (float)mViewportMinimumScale / 100F;
            mInitialViewState.mMaxScale = (float)mViewportMaximumScale / 100F;
            mInitialViewState.mDefaultScale = f;
            mInitialViewState.mScrollX = mRestoredX;
            mInitialViewState.mScrollY = mRestoredY;
            viewstate = mInitialViewState;
            if(mRestoredX == 0 && mRestoredY == 0 && mBrowserFrame != null && mBrowserFrame.getShouldStartScrolledRight())
                flag1 = true;
            else
                flag1 = false;
            viewstate.mShouldStartScrolledRight = flag1;
            viewstate1 = mInitialViewState;
            if(mViewportWidth == 0)
                flag2 = true;
            else
                flag2 = false;
            viewstate1.mMobileSite = flag2;
            if(mIsRestored) {
                mInitialViewState.mIsRestored = true;
                mInitialViewState.mViewScale = mRestoredScale;
                WebViewClassic.ViewSizeData viewsizedata1;
                if(mRestoredTextWrapScale > 0.0F)
                    mInitialViewState.mTextWrapScale = mRestoredTextWrapScale;
                else
                    mInitialViewState.mTextWrapScale = mInitialViewState.mViewScale;
            } else
            if(mViewportInitialScale > 0) {
                ViewState viewstate4 = mInitialViewState;
                ViewState viewstate5 = mInitialViewState;
                float f4 = (float)mViewportInitialScale / 100F;
                viewstate5.mTextWrapScale = f4;
                viewstate4.mViewScale = f4;
            } else
            if(mViewportWidth > 0 && mViewportWidth < k && !getSettings().getUseFixedViewport()) {
                ViewState viewstate2 = mInitialViewState;
                ViewState viewstate3 = mInitialViewState;
                float f3 = (float)k / (float)mViewportWidth;
                viewstate3.mTextWrapScale = f3;
                viewstate2.mViewScale = f3;
            } else {
                mInitialViewState.mTextWrapScale = f;
                if(mSettings.getUseWideViewPort())
                    mInitialViewState.mViewScale = 0.0F;
                else
                    mInitialViewState.mViewScale = f;
            }
            if(mWebViewClassic.mHeightCanMeasure) {
                mWebViewClassic.mLastHeightSent = 0;
                viewsizedata1 = new WebViewClassic.ViewSizeData();
                viewsizedata1.mWidth = mWebViewClassic.mLastWidthSent;
                viewsizedata1.mHeight = 0;
                viewsizedata1.mTextWrapWidth = viewsizedata1.mWidth;
                viewsizedata1.mScale = -1F;
                viewsizedata1.mIgnoreHeight = false;
                viewsizedata1.mAnchorY = 0;
                viewsizedata1.mAnchorX = 0;
                mEventHub.removeMessages(105);
                mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null, 105, viewsizedata1));
            } else
            if(j == 0) {
                mWebViewClassic.mLastWidthSent = 0;
            } else {
                WebViewClassic.ViewSizeData viewsizedata = new WebViewClassic.ViewSizeData();
                float f1 = mInitialViewState.mViewScale;
                int l;
                if(f1 == 0.0F) {
                    float f2 = mInitialViewState.mTextWrapScale;
                    int i1 = calculateWindowWidth(Math.round((float)k / f2));
                    viewsizedata.mScale = (float)k / (float)i1;
                    if(!mSettings.getLoadWithOverviewMode())
                        viewsizedata.mScale = Math.max(viewsizedata.mScale, f2);
                    if(mSettings.isNarrowColumnLayout())
                        mInitialViewState.mTextWrapScale = mWebViewClassic.computeReadingLevelScale(viewsizedata.mScale);
                } else {
                    viewsizedata.mScale = f1;
                }
                viewsizedata.mWidth = Math.round((float)k / viewsizedata.mScale);
                if(mCurrentViewHeight == 0)
                    l = Math.round((float)mWebViewClassic.getViewHeight() / viewsizedata.mScale);
                else
                    l = Math.round(((float)mCurrentViewHeight * (float)viewsizedata.mWidth) / (float)j);
                viewsizedata.mHeight = l;
                viewsizedata.mTextWrapWidth = Math.round((float)k / mInitialViewState.mTextWrapScale);
                viewsizedata.mIgnoreHeight = false;
                viewsizedata.mAnchorY = 0;
                viewsizedata.mAnchorX = 0;
                mEventHub.removeMessages(105);
                viewSizeChanged(viewsizedata);
            }
        }
        if(true) goto _L1; else goto _L4
_L4:
        if(mViewportDensityDpi > 0)
            f = (float)mContext.getResources().getDisplayMetrics().densityDpi / (float)mViewportDensityDpi;
          goto _L5
    }

    private void showFullScreenPlugin(ViewManager.ChildView childview, int i, int j) {
        if(mWebViewClassic != null) {
            Message message = mWebViewClassic.mPrivateHandler.obtainMessage(120);
            message.obj = childview.mView;
            message.arg1 = i;
            message.arg2 = j;
            message.sendToTarget();
        }
    }

    private void showRect(int i, int j, int k, int l, int i1, int j1, float f, 
            float f1, float f2, float f3) {
        if(mWebViewClassic != null) {
            ShowRectData showrectdata = new ShowRectData();
            showrectdata.mLeft = i;
            showrectdata.mTop = j;
            showrectdata.mWidth = k;
            showrectdata.mHeight = l;
            showrectdata.mContentWidth = i1;
            showrectdata.mContentHeight = j1;
            showrectdata.mXPercentInDoc = f;
            showrectdata.mXPercentInView = f1;
            showrectdata.mYPercentInDoc = f2;
            showrectdata.mYPercentInView = f3;
            Message.obtain(mWebViewClassic.mPrivateHandler, 113, showrectdata).sendToTarget();
        }
    }

    private void updateSurface(ViewManager.ChildView childview, int i, int j, int k, int l) {
        childview.attachView(i, j, k, l);
    }

    private void updateTextSelection(int i, int j, int k, int l, int i1) {
        if(mWebViewClassic != null)
            Message.obtain(mWebViewClassic.mPrivateHandler, 112, i, l, createTextSelection(j, k, i1)).sendToTarget();
    }

    private void updateTextSizeAndScroll(int i, int j, int k, int l, int i1) {
        if(mWebViewClassic != null) {
            Rect rect = new Rect(-l, -i1, j - l, k - i1);
            Message.obtain(mWebViewClassic.mPrivateHandler, 150, i, 0, rect).sendToTarget();
        }
    }

    private void updateTextfield(int i, boolean flag, String s, int j) {
        if(mWebViewClassic != null) {
            Message message = Message.obtain(mWebViewClassic.mPrivateHandler, 108, i, j, s);
            message.getData().putBoolean("password", flag);
            message.sendToTarget();
        }
    }

    private void updateViewport() {
        setupViewport(true);
    }

    private void viewSizeChanged(WebViewClassic.ViewSizeData viewsizedata) {
        int i;
        int j;
        int k;
        float f;
        i = viewsizedata.mWidth;
        j = viewsizedata.mHeight;
        k = viewsizedata.mTextWrapWidth;
        f = viewsizedata.mScale;
        if(i != 0) goto _L2; else goto _L1
_L1:
        Log.w("webcore", "skip viewSizeChanged as w is 0");
_L4:
        return;
_L2:
        int l = calculateWindowWidth(i);
        int i1 = j;
        int j1;
        boolean flag;
        if(l != i) {
            float f1 = viewsizedata.mHeightWidthRatio;
            float f2;
            if(f1 > 0.0F)
                f2 = f1;
            else
                f2 = (float)j / (float)i;
            i1 = Math.round(f2 * (float)l);
        }
        if(viewsizedata.mActualViewHeight > 0)
            j1 = viewsizedata.mActualViewHeight;
        else
            j1 = j;
        nativeSetSize(mNativeClass, l, i1, k, f, i, j1, viewsizedata.mAnchorX, viewsizedata.mAnchorY, viewsizedata.mIgnoreHeight);
        if(mCurrentViewWidth == 0)
            flag = true;
        else
            flag = false;
        mCurrentViewWidth = i;
        mCurrentViewHeight = j;
        mCurrentViewScale = f;
        if(flag)
            contentDraw();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void webkitDraw() {
        synchronized(m_skipDrawFlagLock) {
            if(m_skipDrawFlag) {
                m_drawWasSkipped = true;
                break MISSING_BLOCK_LABEL_114;
            }
        }
        mDrawIsScheduled = false;
        DrawData drawdata = new DrawData();
        drawdata.mBaseLayer = nativeRecordContent(mNativeClass, drawdata.mContentSize);
        if(drawdata.mBaseLayer == 0) {
            if(mWebViewClassic != null && !mWebViewClassic.isPaused())
                mEventHub.sendMessageDelayed(Message.obtain(null, 130), 10L);
        } else {
            mLastDrawData = drawdata;
            webkitDraw(drawdata);
        }
          goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
    }

    private void webkitDraw(DrawData drawdata) {
        if(mWebViewClassic != null) {
            drawdata.mFocusSizeChanged = nativeFocusBoundsChanged(mNativeClass);
            drawdata.mViewSize = new Point(mCurrentViewWidth, mCurrentViewHeight);
            if(mSettings.getUseWideViewPort()) {
                int i;
                if(mViewportWidth == -1)
                    i = 980;
                else
                if(mViewportWidth == 0)
                    i = mCurrentViewWidth;
                else
                    i = mViewportWidth;
                drawdata.mMinPrefWidth = Math.max(i, nativeGetContentMinPrefWidth(mNativeClass));
            }
            if(mInitialViewState != null) {
                drawdata.mViewState = mInitialViewState;
                mInitialViewState = null;
            }
            if(mFirstLayoutForNonStandardLoad) {
                drawdata.mFirstLayoutForNonStandardLoad = true;
                mFirstLayoutForNonStandardLoad = false;
            }
            pauseWebKitDraw();
            Message.obtain(mWebViewClassic.mPrivateHandler, 105, drawdata).sendToTarget();
        }
    }

    protected void addMessageToConsole(String s, int i, String s1, int j) {
        mCallbackProxy.addMessageToConsole(s, i, s1, j);
    }

    void clearContent() {
        nativeClearContent(mNativeClass);
    }

    void contentDraw() {
        this;
        JVM INSTR monitorenter ;
        if(mWebViewClassic != null && mBrowserFrame != null && (mCurrentViewWidth != 0 && mBrowserFrame.firstLayoutDone())) goto _L2; else goto _L1
        Exception exception;
        exception;
        throw exception;
_L2:
        if(!mDrawIsScheduled) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
          goto _L1
_L4:
        mDrawIsScheduled = true;
        mEventHub.sendMessage(Message.obtain(null, 130));
        this;
        JVM INSTR monitorexit ;
_L1:
    }

    void destroy() {
        EventHub eventhub = mEventHub;
        eventhub;
        JVM INSTR monitorenter ;
        mEventHub.mDestroying = true;
        mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null, 200));
        mEventHub.blockMessages();
        WebCoreThreadWatchdog.unregisterWebView(mWebViewClassic);
        return;
    }

    protected void enterFullscreenForVideoLayer(int i, String s) {
        if(mWebViewClassic != null) {
            Message message = Message.obtain(mWebViewClassic.mPrivateHandler, 137, i, 0);
            message.obj = s;
            message.sendToTarget();
        }
    }

    protected void exceededDatabaseQuota(String s, String s1, long l, long l1) {
        mCallbackProxy.onExceededDatabaseQuota(s, s1, l, l1, getUsedQuota(), new WebStorage.QuotaUpdater() {

            public void updateQuota(long l2) {
                nativeSetNewStorageLimit(mNativeClass, l2);
            }

            final WebViewCore this$0;

             {
                this$0 = WebViewCore.this;
                super();
            }
        });
    }

    protected void exitFullscreenVideo() {
        if(mWebViewClassic != null)
            Message.obtain(mWebViewClassic.mPrivateHandler, 140).sendToTarget();
    }

    protected void geolocationPermissionsHidePrompt() {
        mCallbackProxy.onGeolocationPermissionsHidePrompt();
    }

    protected void geolocationPermissionsShowPrompt(String s) {
        mCallbackProxy.onGeolocationPermissionsShowPrompt(s, new GeolocationPermissions.Callback() {

            public void invoke(String s1, boolean flag, boolean flag1) {
                GeolocationPermissionsData geolocationpermissionsdata = new GeolocationPermissionsData();
                geolocationpermissionsdata.mOrigin = s1;
                geolocationpermissionsdata.mAllow = flag;
                geolocationpermissionsdata.mRemember = flag1;
                sendMessage(180, geolocationpermissionsdata);
            }

            final WebViewCore this$0;

             {
                this$0 = WebViewCore.this;
                super();
            }
        });
    }

    /**
     * @deprecated Method getBrowserFrame is deprecated
     */

    BrowserFrame getBrowserFrame() {
        this;
        JVM INSTR monitorenter ;
        BrowserFrame browserframe = mBrowserFrame;
        this;
        JVM INSTR monitorexit ;
        return browserframe;
        Exception exception;
        exception;
        throw exception;
    }

    Context getContext() {
        return mContext;
    }

    protected DeviceMotionService getDeviceMotionService() {
        if(mDeviceMotionService == null)
            mDeviceMotionService = new DeviceMotionService(mDeviceMotionAndOrientationManager, mContext);
        return mDeviceMotionService;
    }

    protected DeviceOrientationService getDeviceOrientationService() {
        if(mDeviceOrientationService == null)
            mDeviceOrientationService = new DeviceOrientationService(mDeviceMotionAndOrientationManager, mContext);
        return mDeviceOrientationService;
    }

    public WebViewInputDispatcher.WebKitCallbacks getInputDispatcherCallbacks() {
        return mEventHub;
    }

    public WebSettingsClassic getSettings() {
        return mSettings;
    }

    WebViewClassic getWebViewClassic() {
        return mWebViewClassic;
    }

    void initializeSubwindow() {
        initialize();
        sWebCoreHandler.removeMessages(0, this);
    }

    protected void jsAlert(String s, String s1) {
        mCallbackProxy.onJsAlert(s, s1);
    }

    protected boolean jsConfirm(String s, String s1) {
        return mCallbackProxy.onJsConfirm(s, s1);
    }

    protected boolean jsInterrupt() {
        return mCallbackProxy.onJsTimeout();
    }

    protected String jsPrompt(String s, String s1, String s2) {
        return mCallbackProxy.onJsPrompt(s, s1, s2);
    }

    protected boolean jsUnload(String s, String s1) {
        return mCallbackProxy.onJsBeforeUnload(s, s1);
    }

    void pauseWebKitDraw() {
        Object obj = m_skipDrawFlagLock;
        obj;
        JVM INSTR monitorenter ;
        if(!m_skipDrawFlag)
            m_skipDrawFlag = true;
        return;
    }

    protected void populateVisitedLinks() {
        ValueCallback valuecallback = new ValueCallback() {

            public volatile void onReceiveValue(Object obj) {
                onReceiveValue((String[])obj);
            }

            public void onReceiveValue(String as[]) {
                sendMessage(181, as);
            }

            final WebViewCore this$0;

             {
                this$0 = WebViewCore.this;
                super();
            }
        };
        mCallbackProxy.getVisitedHistory(valuecallback);
    }

    protected void reachedMaxAppCacheSize(long l) {
        mCallbackProxy.onReachedMaxAppCacheSize(l, getUsedQuota(), new WebStorage.QuotaUpdater() {

            public void updateQuota(long l1) {
                nativeSetNewStorageLimit(mNativeClass, l1);
            }

            final WebViewCore this$0;

             {
                this$0 = WebViewCore.this;
                super();
            }
        });
    }

    void removeMessages() {
        mEventHub.removeMessages();
    }

    void removeMessages(int i) {
        mEventHub.removeMessages(i);
    }

    void resumeWebKitDraw() {
        Object obj = m_skipDrawFlagLock;
        obj;
        JVM INSTR monitorenter ;
        if(m_skipDrawFlag && m_drawWasSkipped) {
            m_drawWasSkipped = false;
            mEventHub.sendMessage(Message.obtain(null, 130));
        }
        m_skipDrawFlag = false;
        return;
    }

    void sendMessage(int i) {
        mEventHub.sendMessage(Message.obtain(null, i));
    }

    void sendMessage(int i, int j) {
        mEventHub.sendMessage(Message.obtain(null, i, j, 0));
    }

    void sendMessage(int i, int j, int k) {
        mEventHub.sendMessage(Message.obtain(null, i, j, k));
    }

    void sendMessage(int i, int j, int k, Object obj) {
        mEventHub.sendMessage(Message.obtain(null, i, j, k, obj));
    }

    void sendMessage(int i, int j, Object obj) {
        mEventHub.sendMessage(Message.obtain(null, i, j, 0, obj));
    }

    void sendMessage(int i, Object obj) {
        mEventHub.sendMessage(Message.obtain(null, i, obj));
    }

    public void sendMessage(Message message) {
        mEventHub.sendMessage(message);
    }

    void sendMessageAtFrontOfQueue(int i, int j, int k, Object obj) {
        mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null, i, j, k, obj));
    }

    void sendMessageAtFrontOfQueue(int i, Object obj) {
        mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null, i, obj));
    }

    void sendMessageDelayed(int i, Object obj, long l) {
        mEventHub.sendMessageDelayed(Message.obtain(null, i, obj), l);
    }

    void sendMessages(ArrayList arraylist) {
        EventHub eventhub = mEventHub;
        eventhub;
        JVM INSTR monitorenter ;
        for(int i = 0; i < arraylist.size(); i++)
            mEventHub.sendMessage((Message)arraylist.get(i));

        return;
    }

    protected void setInstallableWebApp() {
        mCallbackProxy.setInstallableWebApp();
    }

    public void setMockDeviceOrientation(boolean flag, double d, boolean flag1, double d1, boolean flag2, 
            double d2) {
        mDeviceMotionAndOrientationManager.setMockOrientation(flag, d, flag1, d1, flag2, d2);
    }

    void signalRepaintDone() {
        mRepaintScheduled = false;
    }

    void stopLoading() {
        if(mBrowserFrame != null)
            mBrowserFrame.stopLoading();
    }

    static final int ACTION_DOUBLETAP = 512;
    static final int ACTION_LONGPRESS = 256;
    static final String HandlerDebugString[];
    private static final String LOGTAG = "webcore";
    static final String THREAD_NAME = "WebViewCoreThread";
    private static final int TOUCH_FLAG_HIT_HANDLER = 1;
    private static final int TOUCH_FLAG_PREVENT_DEFAULT = 2;
    private static boolean mRepaintScheduled = false;
    private static boolean sShouldMonitorWebCoreThread;
    private static Handler sWebCoreHandler;
    private BrowserFrame mBrowserFrame;
    private final CallbackProxy mCallbackProxy;
    private int mChromeCanFocusDirection;
    private final Context mContext;
    private int mCurrentViewHeight;
    private float mCurrentViewScale;
    private int mCurrentViewWidth;
    private DeviceMotionAndOrientationManager mDeviceMotionAndOrientationManager;
    private DeviceMotionService mDeviceMotionService;
    private DeviceOrientationService mDeviceOrientationService;
    private boolean mDrawIsPaused;
    private boolean mDrawIsScheduled;
    private final EventHub mEventHub;
    private boolean mFirstLayoutForNonStandardLoad;
    private int mHighMemoryUsageThresholdMb;
    private int mHighUsageDeltaMb;
    private ViewState mInitialViewState;
    private boolean mIsRestored;
    private Map mJavascriptInterfaces;
    DrawData mLastDrawData;
    private int mLowMemoryUsageThresholdMb;
    private int mNativeClass;
    private float mRestoredScale;
    private float mRestoredTextWrapScale;
    private int mRestoredX;
    private int mRestoredY;
    private final WebSettingsClassic mSettings;
    private int mTextSelectionChangeReason;
    private int mViewportDensityDpi;
    private int mViewportHeight;
    private int mViewportInitialScale;
    private int mViewportMaximumScale;
    private int mViewportMinimumScale;
    private boolean mViewportUserScalable;
    private int mViewportWidth;
    private WebViewClassic mWebViewClassic;
    private boolean m_drawWasSkipped;
    private boolean m_skipDrawFlag;
    private Object m_skipDrawFlagLock;

    static  {
        String as[];
        try {
            System.loadLibrary("webcore");
            System.loadLibrary("chromium_net");
        }
        catch(UnsatisfiedLinkError unsatisfiedlinkerror) {
            Log.e("webcore", "Unable to load native support libraries.");
        }
        as = new String[54];
        as[0] = "REVEAL_SELECTION";
        as[1] = "";
        as[2] = "";
        as[3] = "SCROLL_TEXT_INPUT";
        as[4] = "LOAD_URL";
        as[5] = "STOP_LOADING";
        as[6] = "RELOAD";
        as[7] = "KEY_DOWN";
        as[8] = "KEY_UP";
        as[9] = "VIEW_SIZE_CHANGED";
        as[10] = "GO_BACK_FORWARD";
        as[11] = "SET_SCROLL_OFFSET";
        as[12] = "RESTORE_STATE";
        as[13] = "PAUSE_TIMERS";
        as[14] = "RESUME_TIMERS";
        as[15] = "CLEAR_CACHE";
        as[16] = "CLEAR_HISTORY";
        as[17] = "SET_SELECTION";
        as[18] = "REPLACE_TEXT";
        as[19] = "PASS_TO_JS";
        as[20] = "SET_GLOBAL_BOUNDS";
        as[21] = "";
        as[22] = "CLICK";
        as[23] = "SET_NETWORK_STATE";
        as[24] = "DOC_HAS_IMAGES";
        as[25] = "FAKE_CLICK";
        as[26] = "DELETE_SELECTION";
        as[27] = "LISTBOX_CHOICES";
        as[28] = "SINGLE_LISTBOX_CHOICE";
        as[29] = "MESSAGE_RELAY";
        as[30] = "SET_BACKGROUND_COLOR";
        as[31] = "SET_MOVE_FOCUS";
        as[32] = "SAVE_DOCUMENT_STATE";
        as[33] = "129";
        as[34] = "WEBKIT_DRAW";
        as[35] = "131";
        as[36] = "POST_URL";
        as[37] = "";
        as[38] = "CLEAR_CONTENT";
        as[39] = "";
        as[40] = "";
        as[41] = "REQUEST_CURSOR_HREF";
        as[42] = "ADD_JS_INTERFACE";
        as[43] = "LOAD_DATA";
        as[44] = "";
        as[45] = "";
        as[46] = "SET_ACTIVE";
        as[47] = "ON_PAUSE";
        as[48] = "ON_RESUME";
        as[49] = "FREE_MEMORY";
        as[50] = "VALID_NODE_BOUNDS";
        as[51] = "SAVE_WEBARCHIVE";
        as[52] = "WEBKIT_DRAW_LAYERS";
        as[53] = "REMOVE_JS_INTERFACE";
        HandlerDebugString = as;
    }




/*
    static WebViewClassic access$1102(WebViewCore webviewcore, WebViewClassic webviewclassic) {
        webviewcore.mWebViewClassic = webviewclassic;
        return webviewclassic;
    }

*/





/*
    static BrowserFrame access$1502(WebViewCore webviewcore, BrowserFrame browserframe) {
        webviewcore.mBrowserFrame = browserframe;
        return browserframe;
    }

*/


















/*
    static int access$302(WebViewCore webviewcore, int i) {
        webviewcore.mNativeClass = i;
        return i;
    }

*/












/*
    static int access$4002(WebViewCore webviewcore, int i) {
        webviewcore.mTextSelectionChangeReason = i;
        return i;
    }

*/













/*
    static Handler access$502(Handler handler) {
        sWebCoreHandler = handler;
        return handler;
    }

*/























/*
    static boolean access$7002(WebViewCore webviewcore, boolean flag) {
        webviewcore.mDrawIsScheduled = flag;
        return flag;
    }

*/
}
