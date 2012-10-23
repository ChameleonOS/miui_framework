// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.net.ProxyProperties;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

// Referenced classes of package android.webkit:
//            CookieManager, CertTool, PluginManager, WebViewClassic

final class JWebCoreJavaBridge extends Handler {

    public JWebCoreJavaBridge() {
        nativeConstructor();
    }

    private String cookies(String s) {
        return CookieManager.getInstance().getCookie(s);
    }

    private boolean cookiesEnabled() {
        return CookieManager.getInstance().acceptCookie();
    }

    private void fireSharedTimer() {
        mHasInstantTimer = false;
        sharedTimerFired();
    }

    private String[] getKeyStrengthList() {
        return CertTool.getKeyStrengthList();
    }

    private String[] getPluginDirectories() {
        return PluginManager.getInstance(null).getPluginDirectories();
    }

    private String getPluginSharedDataDirectory() {
        return PluginManager.getInstance(null).getPluginSharedDataDirectory();
    }

    /**
     * @deprecated Method getSignedPublicKey is deprecated
     */

    private String getSignedPublicKey(int i, String s, String s1) {
        this;
        JVM INSTR monitorenter ;
        WebViewClassic webviewclassic = (WebViewClassic)sCurrentMainWebView.get();
        if(webviewclassic == null) goto _L2; else goto _L1
_L1:
        String s3 = CertTool.getSignedPublicKey(webviewclassic.getContext(), i, s);
        String s2 = s3;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s2;
_L2:
        Log.e("webkit-timers", "There is no active WebView for getSignedPublicKey");
        s2 = "";
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private native void nativeConstructor();

    private native void nativeFinalize();

    private native void nativeServiceFuncPtrQueue();

    private native void nativeUpdatePluginDirectories(String as[], boolean flag);

    /**
     * @deprecated Method removeActiveWebView is deprecated
     */

    static void removeActiveWebView(WebViewClassic webviewclassic) {
        android/webkit/JWebCoreJavaBridge;
        JVM INSTR monitorenter ;
        Object obj = sCurrentMainWebView.get();
        if(obj == webviewclassic) goto _L2; else goto _L1
_L1:
        android/webkit/JWebCoreJavaBridge;
        JVM INSTR monitorexit ;
        return;
_L2:
        sCurrentMainWebView.clear();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private String resolveFilePathForContentUri(String s) {
        if(mContentUriToFilePathMap == null) goto _L2; else goto _L1
_L1:
        String s1 = (String)mContentUriToFilePathMap.get(s);
        if(s1 == null) goto _L2; else goto _L3
_L3:
        return s1;
_L2:
        s1 = Uri.parse(s).getLastPathSegment();
        if(true) goto _L3; else goto _L4
_L4:
    }

    /**
     * @deprecated Method setActiveWebView is deprecated
     */

    static void setActiveWebView(WebViewClassic webviewclassic) {
        android/webkit/JWebCoreJavaBridge;
        JVM INSTR monitorenter ;
        Object obj = sCurrentMainWebView.get();
        if(obj == null) goto _L2; else goto _L1
_L1:
        android/webkit/JWebCoreJavaBridge;
        JVM INSTR monitorexit ;
        return;
_L2:
        sCurrentMainWebView = new WeakReference(webviewclassic);
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void setCookies(String s, String s1) {
        if(!s1.contains("\r") && !s1.contains("\n")) goto _L2; else goto _L1
_L1:
        int i;
        StringBuilder stringbuilder;
        int j;
        i = s1.length();
        stringbuilder = new StringBuilder(i);
        j = 0;
_L8:
        int i1;
        if(j == -1 || j >= i)
            break MISSING_BLOCK_LABEL_165;
        int k = s1.indexOf('\r', j);
        int l = s1.indexOf('\n', j);
        if(k == -1)
            i1 = l;
        else
        if(l == -1)
            i1 = k;
        else
        if(k < l)
            i1 = k;
        else
            i1 = l;
        if(i1 <= j) goto _L4; else goto _L3
_L3:
        stringbuilder.append(s1.subSequence(j, i1));
_L6:
        j = i1 + 1;
        continue; /* Loop/switch isn't completed */
_L4:
        if(i1 != -1) goto _L6; else goto _L5
_L5:
        stringbuilder.append(s1.subSequence(j, i));
        s1 = stringbuilder.toString();
_L2:
        CookieManager.getInstance().setCookie(s, s1);
        return;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private void setSharedTimer(long l) {
        if(l <= 0L) {
            if(!mHasInstantTimer) {
                mHasInstantTimer = true;
                sendMessageDelayed(obtainMessage(1), l);
            }
        } else {
            sendMessageDelayed(obtainMessage(1), l);
        }
    }

    private native void sharedTimerFired();

    private void signalServiceFuncPtrQueue() {
        sendMessage(obtainMessage(2));
    }

    private void stopSharedTimer() {
        removeMessages(1);
        mHasInstantTimer = false;
        mHasDeferredTimers = false;
    }

    public native void addPackageName(String s);

    public native void addPackageNames(Set set);

    protected void finalize() {
        nativeFinalize();
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR lookupswitch 3: default 40
    //                   1: 41
    //                   2: 63
    //                   100: 70;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if(mTimerPaused)
            mHasDeferredTimers = true;
        else
            fireSharedTimer();
        continue; /* Loop/switch isn't completed */
_L3:
        nativeServiceFuncPtrQueue();
        continue; /* Loop/switch isn't completed */
_L4:
        nativeUpdatePluginDirectories(PluginManager.getInstance(null).getPluginDirectories(), ((Boolean)message.obj).booleanValue());
        if(true) goto _L1; else goto _L5
_L5:
    }

    public native void nativeUpdateProxy(String s, String s1);

    public void pause() {
        if(!mTimerPaused) {
            mTimerPaused = true;
            mHasDeferredTimers = false;
        }
    }

    public native void removePackageName(String s);

    public void resume() {
        if(mTimerPaused) {
            mTimerPaused = false;
            if(mHasDeferredTimers) {
                mHasDeferredTimers = false;
                fireSharedTimer();
            }
        }
    }

    public native void setCacheSize(int i);

    public native void setNetworkOnLine(boolean flag);

    public native void setNetworkType(String s, String s1);

    public void storeFilePathForContentUri(String s, String s1) {
        if(mContentUriToFilePathMap == null)
            mContentUriToFilePathMap = new HashMap();
        mContentUriToFilePathMap.put(s1, s);
    }

    public void updateProxy(ProxyProperties proxyproperties) {
        if(proxyproperties == null) {
            nativeUpdateProxy("", "");
        } else {
            String s = proxyproperties.getHost();
            int i = proxyproperties.getPort();
            if(i != 0)
                s = (new StringBuilder()).append(s).append(":").append(i).toString();
            nativeUpdateProxy(s, proxyproperties.getExclusionList());
        }
    }

    private static final int FUNCPTR_MESSAGE = 2;
    private static final String LOGTAG = "webkit-timers";
    static final int REFRESH_PLUGINS = 100;
    private static final int TIMER_MESSAGE = 1;
    private static WeakReference sCurrentMainWebView = new WeakReference(null);
    private HashMap mContentUriToFilePathMap;
    private boolean mHasDeferredTimers;
    private boolean mHasInstantTimer;
    private int mNativeBridge;
    private boolean mTimerPaused;

}
