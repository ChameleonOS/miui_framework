// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebView, WebSettings, AccessibilityInjectorFallback

class AccessibilityInjector {
    private static class CallbackHandler {

        private void clearResultLocked() {
            mResultId = -1L;
            mResult = false;
        }

        private boolean getResultAndClear(int i) {
            Object obj = mResultLock;
            obj;
            JVM INSTR monitorenter ;
            boolean flag;
            if(waitForResultTimedLocked(i))
                flag = mResult;
            else
                flag = false;
            clearResultLocked();
            return flag;
        }

        private boolean performAction(WebView webview, String s) {
            int i = mResultIdCounter.getAndIncrement();
            Object aobj[] = new Object[3];
            aobj[0] = mInterfaceName;
            aobj[1] = Integer.valueOf(i);
            aobj[2] = s;
            webview.loadUrl(String.format("javascript:(function() { %s.onResult(%d, %s); })();", aobj));
            return getResultAndClear(i);
        }

        private boolean waitForResultTimedLocked(int i) {
            boolean flag = false;
            long l = SystemClock.uptimeMillis();
            do
                try {
                    if(mResultId == (long)i) {
                        flag = true;
                        break;
                    }
                    if(mResultId > (long)i)
                        break;
                    long l1 = 5000L - (SystemClock.uptimeMillis() - l);
                    if(l1 <= 0L)
                        break;
                    mResultLock.wait(l1);
                }
                catch(InterruptedException interruptedexception) { }
            while(true);
            return flag;
        }

        public void onResult(String s, String s1) {
            long l = Long.parseLong(s);
            Object obj = mResultLock;
            obj;
            JVM INSTR monitorenter ;
            if(l > mResultId) {
                mResult = Boolean.parseBoolean(s1);
                mResultId = l;
            }
            mResultLock.notifyAll();
_L2:
            return;
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private static final String JAVASCRIPT_ACTION_TEMPLATE = "javascript:(function() { %s.onResult(%d, %s); })();";
        private static final long RESULT_TIMEOUT = 5000L;
        private final String mInterfaceName;
        private boolean mResult;
        private long mResultId;
        private final AtomicInteger mResultIdCounter;
        private final Object mResultLock;


        private CallbackHandler(String s) {
            mResultIdCounter = new AtomicInteger();
            mResultLock = new Object();
            mResult = false;
            mResultId = -1L;
            mInterfaceName = s;
        }

    }


    public AccessibilityInjector(WebViewClassic webviewclassic) {
        mWebViewClassic = webviewclassic;
        mWebView = webviewclassic.getWebView();
        mContext = webviewclassic.getContext();
        mAccessibilityManager = AccessibilityManager.getInstance(mContext);
    }

    private void addCallbackApis() {
        if(mCallback == null) {
            mCallback = new CallbackHandler("accessibilityTraversal");
            mWebView.addJavascriptInterface(mCallback, "accessibilityTraversal");
        }
    }

    private void addTtsApis() {
        if(mTextToSpeech == null) {
            String s = mContext.getPackageName();
            mTextToSpeech = new TextToSpeech(mContext, null, null, (new StringBuilder()).append(s).append(".**webview**").toString(), true);
            mWebView.addJavascriptInterface(mTextToSpeech, "accessibility");
        }
    }

    private int getAxsUrlParameterValue(String s) {
        int i = -1;
        if(s != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j;
        Iterator iterator = URLEncodedUtils.parse(new URI(s), null).iterator();
        NameValuePair namevaluepair;
        do {
            if(!iterator.hasNext())
                continue; /* Loop/switch isn't completed */
            namevaluepair = (NameValuePair)iterator.next();
        } while(!"axs".equals(namevaluepair.getName()));
        j = verifyInjectionValue(namevaluepair.getValue());
        i = j;
        continue; /* Loop/switch isn't completed */
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private String getScreenReaderInjectionUrl() {
        String s = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "accessibility_script_injection_url");
        Object aobj[] = new Object[1];
        aobj[0] = s;
        return String.format("javascript:(function() {    var chooser = document.createElement('script');    chooser.type = 'text/javascript';    chooser.src = '%1s';    document.getElementsByTagName('head')[0].appendChild(chooser);  })();", aobj);
    }

    private boolean isAccessibilityEnabled() {
        return mAccessibilityManager.isEnabled();
    }

    private boolean isJavaScriptEnabled() {
        return mWebView.getSettings().getJavaScriptEnabled();
    }

    private boolean isScriptInjectionEnabled() {
        boolean flag = true;
        if(android.provider.Settings.Secure.getInt(mContext.getContentResolver(), "accessibility_script_injection", 0) != flag)
            flag = false;
        return flag;
    }

    private void removeCallbackApis() {
        if(mCallback != null) {
            mWebView.removeJavascriptInterface("accessibilityTraversal");
            mCallback = null;
        }
    }

    private void removeTtsApis() {
        if(mTextToSpeech != null) {
            mWebView.removeJavascriptInterface("accessibility");
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
            mTextToSpeech = null;
        }
    }

    private boolean sendActionToAndroidVox(int i, Bundle bundle) {
        boolean flag = false;
        String s1;
        Object aobj[];
        String s2;
        if(mAccessibilityJSONObject == null) {
            mAccessibilityJSONObject = new JSONObject();
        } else {
            Iterator iterator = mAccessibilityJSONObject.keys();
            while(iterator.hasNext())  {
                iterator.next();
                iterator.remove();
            }
        }
        mAccessibilityJSONObject.accumulate("action", Integer.valueOf(i));
        i;
        JVM INSTR lookupswitch 4: default 76
    //                   256: 159
    //                   512: 159
    //                   1024: 189
    //                   2048: 189;
           goto _L1 _L2 _L2 _L3 _L3
_L1:
        s1 = mAccessibilityJSONObject.toString();
        aobj = new Object[1];
        aobj[flag] = s1;
        s2 = String.format("cvox.AndroidVox.performAction('%1s')", aobj);
        flag = mCallback.performAction(mWebView, s2);
_L5:
        return flag;
_L2:
        if(bundle == null) goto _L1; else goto _L4
_L4:
        int j = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        mAccessibilityJSONObject.accumulate("granularity", Integer.valueOf(j));
          goto _L1
_L3:
        if(bundle != null) {
            String s = bundle.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
            mAccessibilityJSONObject.accumulate("element", s);
        }
          goto _L1
        JSONException jsonexception;
        jsonexception;
          goto _L5
    }

    private boolean shouldInjectJavaScript(String s) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(isJavaScriptEnabled() && getAxsUrlParameterValue(s) != 0 && isScriptInjectionEnabled())
            flag = true;
        return flag;
    }

    private void toggleFallbackAccessibilityInjector(boolean flag) {
        if(flag && mAccessibilityInjectorFallback == null)
            mAccessibilityInjectorFallback = new AccessibilityInjectorFallback(mWebViewClassic);
        else
            mAccessibilityInjectorFallback = null;
    }

    private int verifyInjectionValue(String s) {
        int i = Integer.parseInt(s);
        i;
        JVM INSTR tableswitch 0 1: default 32
    //                   0 37
    //                   1 42;
           goto _L1 _L2 _L3
_L1:
        byte byte0 = -1;
_L5:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        if(true) goto _L5; else goto _L4
_L4:
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void addAccessibilityApisIfNecessary() {
        if(isAccessibilityEnabled() && isJavaScriptEnabled()) {
            addTtsApis();
            addCallbackApis();
        }
    }

    public boolean handleKeyEventIfNecessary(KeyEvent keyevent) {
        boolean flag = false;
        if(isAccessibilityEnabled()) goto _L2; else goto _L1
_L1:
        mAccessibilityScriptInjected = false;
        toggleFallbackAccessibilityInjector(false);
_L4:
        return flag;
_L2:
        if(mAccessibilityScriptInjected) {
            if(keyevent.getAction() == 1) {
                mWebViewClassic.sendBatchableInputMessage(104, 0, 0, keyevent);
            } else {
                if(keyevent.getAction() != 0)
                    continue; /* Loop/switch isn't completed */
                mWebViewClassic.sendBatchableInputMessage(103, 0, 0, keyevent);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        if(mAccessibilityInjectorFallback != null)
            flag = mAccessibilityInjectorFallback.onKeyEvent(keyevent);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void handleSelectionChangedIfNecessary(String s) {
        if(mAccessibilityInjectorFallback != null)
            mAccessibilityInjectorFallback.onSelectionStringChange(s);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        accessibilitynodeinfo.setMovementGranularities(31);
        accessibilitynodeinfo.addAction(256);
        accessibilitynodeinfo.addAction(512);
        accessibilitynodeinfo.addAction(1024);
        accessibilitynodeinfo.addAction(2048);
        accessibilitynodeinfo.addAction(16);
        accessibilitynodeinfo.setClickable(true);
    }

    public void onPageFinished(String s) {
        if(!isAccessibilityEnabled()) {
            mAccessibilityScriptInjected = false;
            toggleFallbackAccessibilityInjector(false);
        } else
        if(!shouldInjectJavaScript(s)) {
            toggleFallbackAccessibilityInjector(true);
        } else {
            toggleFallbackAccessibilityInjector(false);
            String s1 = getScreenReaderInjectionUrl();
            mWebView.loadUrl(s1);
            mAccessibilityScriptInjected = true;
        }
    }

    public void onPageStarted(String s) {
        mAccessibilityScriptInjected = false;
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean flag = false;
        if(isAccessibilityEnabled()) goto _L2; else goto _L1
_L1:
        mAccessibilityScriptInjected = false;
        toggleFallbackAccessibilityInjector(false);
_L4:
        return flag;
_L2:
        if(mAccessibilityScriptInjected)
            flag = sendActionToAndroidVox(i, bundle);
        else
        if(mAccessibilityInjectorFallback != null)
            flag = mAccessibilityInjectorFallback.performAccessibilityAction(i, bundle);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void removeAccessibilityApisIfNecessary() {
        removeTtsApis();
        removeCallbackApis();
    }

    public boolean supportsAccessibilityAction(int i) {
        i;
        JVM INSTR lookupswitch 5: default 52
    //                   16: 56
    //                   256: 56
    //                   512: 56
    //                   1024: 56
    //                   2048: 56;
           goto _L1 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final String ACCESSIBILITY_ANDROIDVOX_TEMPLATE = "cvox.AndroidVox.performAction('%1s')";
    private static final String ACCESSIBILITY_SCREEN_READER_JAVASCRIPT_TEMPLATE = "javascript:(function() {    var chooser = document.createElement('script');    chooser.type = 'text/javascript';    chooser.src = '%1s';    document.getElementsByTagName('head')[0].appendChild(chooser);  })();";
    private static final int ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT = 0;
    private static final int ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED = 1;
    private static final int ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED = -1;
    private static final String ALIAS_TRAVERSAL_JS_INTERFACE = "accessibilityTraversal";
    private static final String ALIAS_TTS_JS_INTERFACE = "accessibility";
    private AccessibilityInjectorFallback mAccessibilityInjectorFallback;
    private JSONObject mAccessibilityJSONObject;
    private AccessibilityManager mAccessibilityManager;
    private boolean mAccessibilityScriptInjected;
    private CallbackHandler mCallback;
    private final Context mContext;
    private TextToSpeech mTextToSpeech;
    private final WebView mWebView;
    private final WebViewClassic mWebViewClassic;
}
