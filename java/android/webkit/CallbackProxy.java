// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.app.Activity;
import android.content.*;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package android.webkit:
//            WebBackForwardList, URLUtil, WebCoreThreadWatchdog, WebViewClassic, 
//            WebViewCore, WebViewClient, WebChromeClient, HttpAuthHandler, 
//            SslErrorHandler, ClientCertRequestHandler, DownloadListener, JsPromptResult, 
//            ConsoleMessage, ValueCallback, WebHistoryItem, WebBackForwardListClient, 
//            SearchBoxImpl, BrowserFrame, WebResourceResponse, JsResult

class CallbackProxy extends Handler {
    private class UploadFile
        implements ValueCallback {

        public Uri getResult() {
            return mValue;
        }

        public void onReceiveValue(Uri uri) {
            mValue = uri;
            CallbackProxy callbackproxy = CallbackProxy.this;
            callbackproxy;
            JVM INSTR monitorenter ;
            notify();
            return;
        }

        public volatile void onReceiveValue(Object obj) {
            onReceiveValue((Uri)obj);
        }

        private Uri mValue;
        final CallbackProxy this$0;

        private UploadFile() {
            this$0 = CallbackProxy.this;
            super();
        }

    }

    private static class UploadFileMessageData {

        public String getAcceptType() {
            return mAcceptType;
        }

        public String getCapture() {
            return mCapture;
        }

        public UploadFile getUploadFile() {
            return mCallback;
        }

        private String mAcceptType;
        private UploadFile mCallback;
        private String mCapture;

        public UploadFileMessageData(UploadFile uploadfile, String s, String s1) {
            mCallback = uploadfile;
            mAcceptType = s;
            mCapture = s1;
        }
    }

    private class JsResultReceiver
        implements JsResult.ResultReceiver {

        private void notifyCallbackProxy() {
            CallbackProxy callbackproxy = CallbackProxy.this;
            callbackproxy;
            JVM INSTR monitorenter ;
            notify();
            return;
        }

        public void onJsResultComplete(JsResult jsresult) {
            if(mReady)
                notifyCallbackProxy();
            else
                mTriedToNotifyBeforeReady = true;
        }

        final void setReady() {
            mReady = true;
            if(mTriedToNotifyBeforeReady)
                notifyCallbackProxy();
        }

        public JsPromptResult mJsResult;
        private boolean mReady;
        private boolean mTriedToNotifyBeforeReady;
        final CallbackProxy this$0;

        private JsResultReceiver() {
            this$0 = CallbackProxy.this;
            super();
            mJsResult = new JsPromptResult(this);
        }

    }

    private static class ResultTransport {

        /**
         * @deprecated Method getResult is deprecated
         */

        public Object getResult() {
            this;
            JVM INSTR monitorenter ;
            Object obj = mResult;
            this;
            JVM INSTR monitorexit ;
            return obj;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method setResult is deprecated
         */

        public void setResult(Object obj) {
            this;
            JVM INSTR monitorenter ;
            mResult = obj;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private Object mResult;

        public ResultTransport(Object obj) {
            mResult = obj;
        }
    }


    public CallbackProxy(Context context, WebViewClassic webviewclassic) {
        mLatestProgress = 100;
        mContext = context;
        mWebView = webviewclassic;
    }

    private String getJsDialogTitle(String s) {
        String s1 = s;
        if(!URLUtil.isDataUrl(s)) goto _L2; else goto _L1
_L1:
        s1 = mContext.getString(0x104033e);
_L4:
        return s1;
_L2:
        String s2;
        URL url = new URL(s);
        Context context = mContext;
        Object aobj[] = new Object[1];
        aobj[0] = (new StringBuilder()).append(url.getProtocol()).append("://").append(url.getHost()).toString();
        s2 = context.getString(0x104033d, aobj);
        s1 = s2;
        continue; /* Loop/switch isn't completed */
        MalformedURLException malformedurlexception;
        malformedurlexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    /**
     * @deprecated Method sendMessageToUiThreadSync is deprecated
     */

    private void sendMessageToUiThreadSync(Message message) {
        this;
        JVM INSTR monitorenter ;
        sendMessage(message);
        WebCoreThreadWatchdog.pause();
        wait();
_L1:
        WebCoreThreadWatchdog.resume();
        this;
        JVM INSTR monitorexit ;
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e("CallbackProxy", "Caught exception waiting for synchronous UI message to be processed");
        Log.e("CallbackProxy", Log.getStackTraceString(interruptedexception));
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public void addMessageToConsole(String s, int i, String s1, int j) {
        if(mWebChromeClient != null) {
            Message message = obtainMessage(129);
            message.getData().putString("message", s);
            message.getData().putString("sourceID", s1);
            message.getData().putInt("lineNumber", i);
            message.getData().putInt("msgLevel", j);
            sendMessage(message);
        }
    }

    /**
     * @deprecated Method blockMessages is deprecated
     */

    protected void blockMessages() {
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

    boolean canShowAlertDialog() {
        return mContext instanceof Activity;
    }

    public BrowserFrame createWindow(boolean flag, boolean flag1) {
        int i = 1;
        if(mWebChromeClient != null) goto _L2; else goto _L1
_L1:
        BrowserFrame browserframe = null;
_L4:
        return browserframe;
_L2:
        WebView webview = mWebView.getWebView();
        webview.getClass();
        WebView.WebViewTransport webviewtransport = new WebView.WebViewTransport(webview);
        Message message = obtainMessage(200);
        message.obj = webviewtransport;
        int j;
        WebViewClassic webviewclassic;
        if(flag)
            j = i;
        else
            j = 0;
        if(!flag1)
            i = 0;
        sendMessageToUiThreadSync(obtainMessage(109, j, i, message));
        webviewclassic = WebViewClassic.fromWebView(webviewtransport.getWebView());
        if(webviewclassic != null) {
            WebViewCore webviewcore = webviewclassic.getWebViewCore();
            if(webviewcore != null) {
                webviewcore.initializeSubwindow();
                browserframe = webviewcore.getBrowserFrame();
                continue; /* Loop/switch isn't completed */
            }
        }
        browserframe = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void doUpdateVisitedHistory(String s, boolean flag) {
        if(mWebViewClient != null) {
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            sendMessage(obtainMessage(107, i, 0, s));
        }
    }

    public WebBackForwardList getBackForwardList() {
        return mBackForwardList;
    }

    public int getProgress() {
        return mLatestProgress;
    }

    public void getVisitedHistory(ValueCallback valuecallback) {
        if(mWebChromeClient != null) {
            Message message = obtainMessage(133);
            message.obj = valuecallback;
            sendMessage(message);
        }
    }

    WebBackForwardListClient getWebBackForwardListClient() {
        return mWebBackForwardListClient;
    }

    public WebChromeClient getWebChromeClient() {
        return mWebChromeClient;
    }

    public WebViewClient getWebViewClient() {
        return mWebViewClient;
    }

    public void handleMessage(Message message) {
        if(!messagesBlocked()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        message.what;
        JVM INSTR tableswitch 100 210: default 472
    //                   100 475
    //                   101 597
    //                   102 690
    //                   103 847
    //                   104 900
    //                   105 963
    //                   106 1104
    //                   107 1148
    //                   108 1209
    //                   109 1335
    //                   110 1461
    //                   111 1488
    //                   112 1871
    //                   113 2027
    //                   114 2199
    //                   115 2439
    //                   116 1565
    //                   117 472
    //                   118 1240
    //                   119 721
    //                   120 781
    //                   121 529
    //                   122 1437
    //                   123 2708
    //                   124 2673
    //                   125 2752
    //                   126 1596
    //                   127 1721
    //                   128 2619
    //                   129 2762
    //                   130 1798
    //                   131 1854
    //                   132 628
    //                   133 3015
    //                   134 3039
    //                   135 3080
    //                   136 3104
    //                   137 3132
    //                   138 3198
    //                   139 3215
    //                   140 3256
    //                   141 1049
    //                   142 3322
    //                   143 3348
    //                   144 1018
    //                   145 472
    //                   146 472
    //                   147 472
    //                   148 472
    //                   149 472
    //                   150 472
    //                   151 472
    //                   152 472
    //                   153 472
    //                   154 472
    //                   155 472
    //                   156 472
    //                   157 472
    //                   158 472
    //                   159 472
    //                   160 472
    //                   161 472
    //                   162 472
    //                   163 472
    //                   164 472
    //                   165 472
    //                   166 472
    //                   167 472
    //                   168 472
    //                   169 472
    //                   170 472
    //                   171 472
    //                   172 472
    //                   173 472
    //                   174 472
    //                   175 472
    //                   176 472
    //                   177 472
    //                   178 472
    //                   179 472
    //                   180 472
    //                   181 472
    //                   182 472
    //                   183 472
    //                   184 472
    //                   185 472
    //                   186 472
    //                   187 472
    //                   188 472
    //                   189 472
    //                   190 472
    //                   191 472
    //                   192 472
    //                   193 472
    //                   194 472
    //                   195 472
    //                   196 472
    //                   197 472
    //                   198 472
    //                   199 472
    //                   200 2690
    //                   201 472
    //                   202 472
    //                   203 472
    //                   204 472
    //                   205 472
    //                   206 472
    //                   207 472
    //                   208 472
    //                   209 472
    //                   210 573;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L3 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L48 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L49
_L3:
        continue; /* Loop/switch isn't completed */
_L4:
        String s37 = message.getData().getString("url");
        mWebView.onPageStarted(s37);
        if(mWebViewClient != null)
            mWebViewClient.onPageStarted(mWebView.getWebView(), s37, (Bitmap)message.obj);
        continue; /* Loop/switch isn't completed */
_L24:
        String s36 = (String)message.obj;
        mWebView.onPageFinished(s36);
        if(mWebViewClient != null)
            mWebViewClient.onPageFinished(mWebView.getWebView(), s36);
        continue; /* Loop/switch isn't completed */
_L49:
        if(mWebViewClient != null)
            mWebViewClient.onMainFrameFinishParsing(mWebView.getWebView());
        continue; /* Loop/switch isn't completed */
_L5:
        if(mWebChromeClient != null)
            mWebChromeClient.onReceivedIcon(mWebView.getWebView(), (Bitmap)message.obj);
        continue; /* Loop/switch isn't completed */
_L35:
        if(mWebChromeClient != null) {
            WebChromeClient webchromeclient1 = mWebChromeClient;
            WebView webview2 = mWebView.getWebView();
            String s35 = (String)message.obj;
            boolean flag4;
            if(message.arg1 == 1)
                flag4 = true;
            else
                flag4 = false;
            webchromeclient1.onReceivedTouchIconUrl(webview2, s35, flag4);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if(mWebChromeClient != null)
            mWebChromeClient.onReceivedTitle(mWebView.getWebView(), (String)message.obj);
        continue; /* Loop/switch isn't completed */
_L22:
        if(mWebViewClient != null) {
            int i1 = message.arg1;
            String s33 = message.getData().getString("description");
            String s34 = message.getData().getString("failingUrl");
            mWebViewClient.onReceivedError(mWebView.getWebView(), i1, s33, s34);
        }
        continue; /* Loop/switch isn't completed */
_L23:
        Message message1 = (Message)message.getData().getParcelable("resend");
        Message message2 = (Message)message.getData().getParcelable("dontResend");
        if(mWebViewClient != null)
            mWebViewClient.onFormResubmission(mWebView.getWebView(), message2, message1);
        else
            message2.sendToTarget();
        continue; /* Loop/switch isn't completed */
_L7:
        boolean flag3 = uiOverrideUrlLoading(message.getData().getString("url"));
        ResultTransport resulttransport = (ResultTransport)message.obj;
        this;
        JVM INSTR monitorenter ;
        resulttransport.setResult(Boolean.valueOf(flag3));
        notify();
        continue; /* Loop/switch isn't completed */
_L8:
        if(mWebViewClient != null) {
            HttpAuthHandler httpauthhandler = (HttpAuthHandler)message.obj;
            String s31 = message.getData().getString("host");
            String s32 = message.getData().getString("realm");
            mWebViewClient.onReceivedHttpAuthRequest(mWebView.getWebView(), httpauthhandler, s31, s32);
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if(mWebViewClient != null) {
            HashMap hashmap4 = (HashMap)message.obj;
            mWebViewClient.onReceivedSslError(mWebView.getWebView(), (SslErrorHandler)hashmap4.get("handler"), (SslError)hashmap4.get("error"));
        }
        continue; /* Loop/switch isn't completed */
_L47:
        if(mWebViewClient != null)
            mWebViewClient.onProceededAfterSslError(mWebView.getWebView(), (SslError)message.obj);
        continue; /* Loop/switch isn't completed */
_L44:
        if(mWebViewClient != null) {
            HashMap hashmap3 = (HashMap)message.obj;
            mWebViewClient.onReceivedClientCertRequest(mWebView.getWebView(), (ClientCertRequestHandler)hashmap3.get("handler"), (String)hashmap3.get("host_and_port"));
        }
        continue; /* Loop/switch isn't completed */
_L10:
        this;
        JVM INSTR monitorenter ;
        if(mWebChromeClient != null)
            mWebChromeClient.onProgressChanged(mWebView.getWebView(), mLatestProgress);
        mProgressUpdatePending = false;
        continue; /* Loop/switch isn't completed */
_L11:
        if(mWebViewClient != null) {
            WebViewClient webviewclient = mWebViewClient;
            WebView webview1 = mWebView.getWebView();
            String s30 = (String)message.obj;
            boolean flag2;
            if(message.arg1 != 0)
                flag2 = true;
            else
                flag2 = false;
            webviewclient.doUpdateVisitedHistory(webview1, s30, flag2);
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if(mWebViewClient != null)
            mWebViewClient.onLoadResource(mWebView.getWebView(), (String)message.obj);
        continue; /* Loop/switch isn't completed */
_L21:
        if(mDownloadListener != null) {
            String s26 = message.getData().getString("url");
            String s27 = message.getData().getString("userAgent");
            String s28 = message.getData().getString("contentDisposition");
            String s29 = message.getData().getString("mimetype");
            Long long1 = Long.valueOf(message.getData().getLong("contentLength"));
            mDownloadListener.onDownloadStart(s26, s27, s28, s29, long1.longValue());
        }
        continue; /* Loop/switch isn't completed */
_L13:
        if(mWebChromeClient == null)
            continue; /* Loop/switch isn't completed */
        WebChromeClient webchromeclient = mWebChromeClient;
        WebView webview = mWebView.getWebView();
        boolean flag;
        boolean flag1;
        if(message.arg1 == 1)
            flag = true;
        else
            flag = false;
        if(message.arg2 == 1)
            flag1 = true;
        else
            flag1 = false;
        if(webchromeclient.onCreateWindow(webview, flag, flag1, (Message)message.obj)) goto _L51; else goto _L50
_L50:
        this;
        JVM INSTR monitorenter ;
        notify();
        this;
        JVM INSTR monitorexit ;
_L51:
        mWebView.dismissZoomControl();
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L25:
        if(mWebChromeClient != null)
            mWebChromeClient.onRequestFocus(mWebView.getWebView());
        continue; /* Loop/switch isn't completed */
_L14:
        if(mWebChromeClient != null)
            mWebChromeClient.onCloseWindow(((WebViewClassic)message.obj).getWebView());
        continue; /* Loop/switch isn't completed */
_L15:
        Bundle bundle = message.getData();
        String s23 = bundle.getString("host");
        String s24 = bundle.getString("username");
        String s25 = bundle.getString("password");
        if(mWebView.onSavePassword(s23, s24, s25, (Message)message.obj))
            continue; /* Loop/switch isn't completed */
        this;
        JVM INSTR monitorenter ;
        notify();
        continue; /* Loop/switch isn't completed */
_L20:
        if(mWebViewClient != null)
            mWebViewClient.onUnhandledKeyEvent(mWebView.getWebView(), (KeyEvent)message.obj);
        continue; /* Loop/switch isn't completed */
_L29:
        if(mWebChromeClient != null) {
            HashMap hashmap2 = (HashMap)message.obj;
            String s21 = (String)hashmap2.get("databaseIdentifier");
            String s22 = (String)hashmap2.get("url");
            long l2 = ((Long)hashmap2.get("quota")).longValue();
            long l3 = ((Long)hashmap2.get("totalQuota")).longValue();
            long l4 = ((Long)hashmap2.get("estimatedDatabaseSize")).longValue();
            WebStorage.QuotaUpdater quotaupdater1 = (WebStorage.QuotaUpdater)hashmap2.get("quotaUpdater");
            mWebChromeClient.onExceededDatabaseQuota(s22, s21, l2, l4, l3, quotaupdater1);
        }
        continue; /* Loop/switch isn't completed */
_L30:
        if(mWebChromeClient != null) {
            HashMap hashmap1 = (HashMap)message.obj;
            long l = ((Long)hashmap1.get("requiredStorage")).longValue();
            long l1 = ((Long)hashmap1.get("quota")).longValue();
            WebStorage.QuotaUpdater quotaupdater = (WebStorage.QuotaUpdater)hashmap1.get("quotaUpdater");
            mWebChromeClient.onReachedMaxAppCacheSize(l, l1, quotaupdater);
        }
        continue; /* Loop/switch isn't completed */
_L33:
        if(mWebChromeClient != null) {
            HashMap hashmap = (HashMap)message.obj;
            String s20 = (String)hashmap.get("origin");
            GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback)hashmap.get("callback");
            mWebChromeClient.onGeolocationPermissionsShowPrompt(s20, callback);
        }
        continue; /* Loop/switch isn't completed */
_L34:
        if(mWebChromeClient != null)
            mWebChromeClient.onGeolocationPermissionsHidePrompt();
        continue; /* Loop/switch isn't completed */
_L16:
        if(mWebChromeClient == null)
            continue; /* Loop/switch isn't completed */
        JsResultReceiver jsresultreceiver4 = (JsResultReceiver)message.obj;
        final JsPromptResult res = jsresultreceiver4.mJsResult;
        String s18 = message.getData().getString("message");
        String s19 = message.getData().getString("url");
        if(!mWebChromeClient.onJsAlert(mWebView.getWebView(), s19, s18, res)) {
            if(!canShowAlertDialog()) {
                res.cancel();
                jsresultreceiver4.setReady();
                continue; /* Loop/switch isn't completed */
            }
            (new android.app.AlertDialog.Builder(mContext)).setTitle(getJsDialogTitle(s19)).setMessage(s18).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j1) {
                    res.confirm();
                }

                final CallbackProxy this$0;
                final JsResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jsresult;
                super();
            }
            }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                public void onCancel(DialogInterface dialoginterface) {
                    res.cancel();
                }

                final CallbackProxy this$0;
                final JsResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jsresult;
                super();
            }
            }).show();
        }
        jsresultreceiver4.setReady();
        continue; /* Loop/switch isn't completed */
_L17:
        if(mWebChromeClient == null)
            continue; /* Loop/switch isn't completed */
        JsResultReceiver jsresultreceiver3 = (JsResultReceiver)message.obj;
        final JsPromptResult res = jsresultreceiver3.mJsResult;
        String s16 = message.getData().getString("message");
        String s17 = message.getData().getString("url");
        if(!mWebChromeClient.onJsConfirm(mWebView.getWebView(), s17, s16, res)) {
            if(!canShowAlertDialog()) {
                res.cancel();
                jsresultreceiver3.setReady();
                continue; /* Loop/switch isn't completed */
            }
            (new android.app.AlertDialog.Builder(mContext)).setTitle(getJsDialogTitle(s17)).setMessage(s16).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j1) {
                    res.confirm();
                }

                final CallbackProxy this$0;
                final JsResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jsresult;
                super();
            }
            }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j1) {
                    res.cancel();
                }

                final CallbackProxy this$0;
                final JsResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jsresult;
                super();
            }
            }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                public void onCancel(DialogInterface dialoginterface) {
                    res.cancel();
                }

                final CallbackProxy this$0;
                final JsResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jsresult;
                super();
            }
            }).show();
        }
        jsresultreceiver3.setReady();
        continue; /* Loop/switch isn't completed */
_L18:
        if(mWebChromeClient == null)
            continue; /* Loop/switch isn't completed */
        JsResultReceiver jsresultreceiver2 = (JsResultReceiver)message.obj;
        final JsPromptResult res = jsresultreceiver2.mJsResult;
        String s13 = message.getData().getString("message");
        String s14 = message.getData().getString("default");
        String s15 = message.getData().getString("url");
        if(!mWebChromeClient.onJsPrompt(mWebView.getWebView(), s15, s13, s14, res)) {
            if(!canShowAlertDialog()) {
                res.cancel();
                jsresultreceiver2.setReady();
                continue; /* Loop/switch isn't completed */
            }
            View view = LayoutInflater.from(mContext).inflate(0x109004a, null);
            final EditText v = (EditText)view.findViewById(0x1020292);
            v.setText(s14);
            ((TextView)view.findViewById(0x102000b)).setText(s13);
            (new android.app.AlertDialog.Builder(mContext)).setTitle(getJsDialogTitle(s15)).setView(view).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j1) {
                    res.confirm(v.getText().toString());
                }

                final CallbackProxy this$0;
                final JsPromptResult val$res;
                final EditText val$v;

             {
                this$0 = CallbackProxy.this;
                res = jspromptresult;
                v = edittext;
                super();
            }
            }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j1) {
                    res.cancel();
                }

                final CallbackProxy this$0;
                final JsPromptResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jspromptresult;
                super();
            }
            }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                public void onCancel(DialogInterface dialoginterface) {
                    res.cancel();
                }

                final CallbackProxy this$0;
                final JsPromptResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jspromptresult;
                super();
            }
            }).show();
        }
        jsresultreceiver2.setReady();
        continue; /* Loop/switch isn't completed */
_L19:
        if(mWebChromeClient == null)
            continue; /* Loop/switch isn't completed */
        JsResultReceiver jsresultreceiver1 = (JsResultReceiver)message.obj;
        final JsPromptResult res = jsresultreceiver1.mJsResult;
        String s10 = message.getData().getString("message");
        String s11 = message.getData().getString("url");
        if(!mWebChromeClient.onJsBeforeUnload(mWebView.getWebView(), s11, s10, res)) {
            if(!canShowAlertDialog()) {
                res.cancel();
                jsresultreceiver1.setReady();
                continue; /* Loop/switch isn't completed */
            }
            Context context = mContext;
            Object aobj[] = new Object[1];
            aobj[0] = s10;
            String s12 = context.getString(0x104033f, aobj);
            (new android.app.AlertDialog.Builder(mContext)).setMessage(s12).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j1) {
                    res.confirm();
                }

                final CallbackProxy this$0;
                final JsResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jsresult;
                super();
            }
            }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j1) {
                    res.cancel();
                }

                final CallbackProxy this$0;
                final JsResult val$res;

             {
                this$0 = CallbackProxy.this;
                res = jsresult;
                super();
            }
            }).show();
        }
        jsresultreceiver1.setReady();
        continue; /* Loop/switch isn't completed */
_L31:
        if(mWebChromeClient != null) {
            JsResultReceiver jsresultreceiver = (JsResultReceiver)message.obj;
            JsPromptResult jspromptresult = jsresultreceiver.mJsResult;
            if(mWebChromeClient.onJsTimeout())
                jspromptresult.confirm();
            else
                jspromptresult.cancel();
            jsresultreceiver.setReady();
        }
        continue; /* Loop/switch isn't completed */
_L27:
        mWebView.setCertificate((SslCertificate)message.obj);
        continue; /* Loop/switch isn't completed */
_L48:
        this;
        JVM INSTR monitorenter ;
        notify();
        continue; /* Loop/switch isn't completed */
_L26:
        if(mWebViewClient != null)
            mWebViewClient.onScaleChanged(mWebView.getWebView(), message.getData().getFloat("old"), message.getData().getFloat("new"));
        continue; /* Loop/switch isn't completed */
_L28:
        mWebView.switchOutDrawHistory();
        continue; /* Loop/switch isn't completed */
_L32:
        if(mWebChromeClient != null) {
            String s7 = message.getData().getString("message");
            String s8 = message.getData().getString("sourceID");
            int i = message.getData().getInt("lineNumber");
            int j = message.getData().getInt("msgLevel");
            int k = ConsoleMessage.MessageLevel.values().length;
            if(j < 0 || j >= k)
                j = 0;
            ConsoleMessage.MessageLevel messagelevel = ConsoleMessage.MessageLevel.values()[j];
            if(!mWebChromeClient.onConsoleMessage(new ConsoleMessage(s7, s8, i, messagelevel))) {
                String s9 = (new StringBuilder()).append(s7).append(" at ").append(s8).append(":").append(i).toString();
                class _cls11 {

                    static final int $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[];

                    static  {
                        $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = new int[ConsoleMessage.MessageLevel.values().length];
                        NoSuchFieldError nosuchfielderror4;
                        try {
                            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
                        }
                        catch(NoSuchFieldError nosuchfielderror) { }
                        try {
                            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
                        }
                        catch(NoSuchFieldError nosuchfielderror1) { }
                        try {
                            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
                        }
                        catch(NoSuchFieldError nosuchfielderror2) { }
                        try {
                            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
                        }
                        catch(NoSuchFieldError nosuchfielderror3) { }
                        $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
_L2:
                        return;
                        nosuchfielderror4;
                        if(true) goto _L2; else goto _L1
_L1:
                    }
                }

                switch(_cls11..SwitchMap.android.webkit.ConsoleMessage.MessageLevel[messagelevel.ordinal()]) {
                case 1: // '\001'
                    Log.v("Web Console", s9);
                    break;

                case 2: // '\002'
                    Log.i("Web Console", s9);
                    break;

                case 3: // '\003'
                    Log.w("Web Console", s9);
                    break;

                case 4: // '\004'
                    Log.e("Web Console", s9);
                    break;

                case 5: // '\005'
                    Log.d("Web Console", s9);
                    break;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L36:
        if(mWebChromeClient != null)
            mWebChromeClient.getVisitedHistory((ValueCallback)message.obj);
        continue; /* Loop/switch isn't completed */
_L37:
        if(mWebChromeClient != null) {
            UploadFileMessageData uploadfilemessagedata = (UploadFileMessageData)message.obj;
            mWebChromeClient.openFileChooser(uploadfilemessagedata.getUploadFile(), uploadfilemessagedata.getAcceptType(), uploadfilemessagedata.getCapture());
        }
        continue; /* Loop/switch isn't completed */
_L38:
        if(mWebBackForwardListClient != null)
            mWebBackForwardListClient.onNewHistoryItem((WebHistoryItem)message.obj);
        continue; /* Loop/switch isn't completed */
_L39:
        if(mWebBackForwardListClient != null)
            mWebBackForwardListClient.onIndexChanged((WebHistoryItem)message.obj, message.arg1);
        continue; /* Loop/switch isn't completed */
_L40:
        String s3 = message.getData().getString("host");
        String s4 = message.getData().getString("realm");
        String s5 = message.getData().getString("username");
        String s6 = message.getData().getString("password");
        mWebView.setHttpAuthUsernamePassword(s3, s4, s5, s6);
        continue; /* Loop/switch isn't completed */
_L41:
        if(mWebChromeClient != null)
            mWebChromeClient.setInstallableWebApp();
        continue; /* Loop/switch isn't completed */
_L42:
        SearchBoxImpl searchboximpl1 = (SearchBoxImpl)mWebView.getSearchBox();
        List list = (List)message.obj;
        searchboximpl1.handleSuggestions(message.getData().getString("query"), list);
        continue; /* Loop/switch isn't completed */
_L43:
        if(mWebViewClient != null) {
            String s = message.getData().getString("realm");
            String s1 = message.getData().getString("account");
            String s2 = message.getData().getString("args");
            mWebViewClient.onReceivedLoginRequest(mWebView.getWebView(), s, s1, s2);
        }
        continue; /* Loop/switch isn't completed */
_L45:
        ((SearchBoxImpl)mWebView.getSearchBox()).handleIsSupportedCallback(((Boolean)message.obj).booleanValue());
        continue; /* Loop/switch isn't completed */
_L46:
        SearchBoxImpl searchboximpl = (SearchBoxImpl)mWebView.getSearchBox();
        Boolean boolean1 = (Boolean)message.obj;
        searchboximpl.handleDispatchCompleteCallback(message.getData().getString("function"), message.getData().getInt("id"), boolean1.booleanValue());
        if(true) goto _L1; else goto _L52
_L52:
    }

    /**
     * @deprecated Method messagesBlocked is deprecated
     */

    protected boolean messagesBlocked() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mBlockMessages;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void onCloseWindow(WebViewClassic webviewclassic) {
        if(mWebChromeClient != null)
            sendMessage(obtainMessage(110, webviewclassic));
    }

    public boolean onDownloadStart(String s, String s1, String s2, String s3, long l) {
        boolean flag;
        if(mDownloadListener == null) {
            flag = false;
        } else {
            Message message = obtainMessage(118);
            Bundle bundle = message.getData();
            bundle.putString("url", s);
            bundle.putString("userAgent", s1);
            bundle.putString("mimetype", s3);
            bundle.putLong("contentLength", l);
            bundle.putString("contentDisposition", s2);
            sendMessage(message);
            flag = true;
        }
        return flag;
    }

    public void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, WebStorage.QuotaUpdater quotaupdater) {
        if(mWebChromeClient == null) {
            quotaupdater.updateQuota(l);
        } else {
            Message message = obtainMessage(126);
            HashMap hashmap = new HashMap();
            hashmap.put("databaseIdentifier", s1);
            hashmap.put("url", s);
            hashmap.put("quota", Long.valueOf(l));
            hashmap.put("estimatedDatabaseSize", Long.valueOf(l1));
            hashmap.put("totalQuota", Long.valueOf(l2));
            hashmap.put("quotaUpdater", quotaupdater);
            message.obj = hashmap;
            sendMessage(message);
        }
    }

    public void onFormResubmission(Message message, Message message1) {
        if(mWebViewClient == null) {
            message.sendToTarget();
        } else {
            Message message2 = obtainMessage(120);
            Bundle bundle = message2.getData();
            bundle.putParcelable("resend", message1);
            bundle.putParcelable("dontResend", message);
            sendMessage(message2);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        if(mWebChromeClient != null)
            sendMessage(obtainMessage(131));
    }

    public void onGeolocationPermissionsShowPrompt(String s, GeolocationPermissions.Callback callback) {
        if(mWebChromeClient != null) {
            Message message = obtainMessage(130);
            HashMap hashmap = new HashMap();
            hashmap.put("origin", s);
            hashmap.put("callback", callback);
            message.obj = hashmap;
            sendMessage(message);
        }
    }

    void onIndexChanged(WebHistoryItem webhistoryitem, int i) {
        if(mWebBackForwardListClient != null)
            sendMessage(obtainMessage(136, i, 0, webhistoryitem));
    }

    void onIsSupportedCallback(boolean flag) {
        Message message = obtainMessage(142);
        message.obj = Boolean.valueOf(flag);
        sendMessage(message);
    }

    public void onJsAlert(String s, String s1) {
        if(mWebChromeClient != null) {
            Message message = obtainMessage(112, new JsResultReceiver());
            message.getData().putString("message", s1);
            message.getData().putString("url", s);
            sendMessageToUiThreadSync(message);
        }
    }

    public boolean onJsBeforeUnload(String s, String s1) {
        boolean flag;
        if(mWebChromeClient == null) {
            flag = true;
        } else {
            JsResultReceiver jsresultreceiver = new JsResultReceiver();
            Message message = obtainMessage(115, jsresultreceiver);
            message.getData().putString("message", s1);
            message.getData().putString("url", s);
            sendMessageToUiThreadSync(message);
            flag = jsresultreceiver.mJsResult.getResult();
        }
        return flag;
    }

    public boolean onJsConfirm(String s, String s1) {
        boolean flag;
        if(mWebChromeClient == null) {
            flag = false;
        } else {
            JsResultReceiver jsresultreceiver = new JsResultReceiver();
            Message message = obtainMessage(113, jsresultreceiver);
            message.getData().putString("message", s1);
            message.getData().putString("url", s);
            sendMessageToUiThreadSync(message);
            flag = jsresultreceiver.mJsResult.getResult();
        }
        return flag;
    }

    public String onJsPrompt(String s, String s1, String s2) {
        String s3 = null;
        if(mWebChromeClient != null) {
            JsResultReceiver jsresultreceiver = new JsResultReceiver();
            Message message = obtainMessage(114, jsresultreceiver);
            message.getData().putString("message", s1);
            message.getData().putString("default", s2);
            message.getData().putString("url", s);
            sendMessageToUiThreadSync(message);
            s3 = jsresultreceiver.mJsResult.getStringResult();
        }
        return s3;
    }

    public boolean onJsTimeout() {
        boolean flag;
        if(mWebChromeClient == null) {
            flag = true;
        } else {
            JsResultReceiver jsresultreceiver = new JsResultReceiver();
            sendMessageToUiThreadSync(obtainMessage(128, jsresultreceiver));
            flag = jsresultreceiver.mJsResult.getResult();
        }
        return flag;
    }

    public void onMainFrameFinishParsing() {
        sendMessage(obtainMessage(210));
    }

    void onNewHistoryItem(WebHistoryItem webhistoryitem) {
        if(mWebBackForwardListClient != null)
            sendMessage(obtainMessage(135, webhistoryitem));
    }

    public void onPageFinished(String s) {
        sendMessage(obtainMessage(121, s));
    }

    public void onPageStarted(String s, Bitmap bitmap) {
        Message message = obtainMessage(100);
        message.obj = bitmap;
        message.getData().putString("url", s);
        sendMessage(message);
    }

    public void onProceededAfterSslError(SslError sslerror) {
        if(mWebViewClient != null) {
            Message message = obtainMessage(144);
            message.obj = sslerror;
            sendMessage(message);
        }
    }

    public void onProgressChanged(int i) {
        this;
        JVM INSTR monitorenter ;
        if(mLatestProgress != i) goto _L2; else goto _L1
_L2:
        mLatestProgress = i;
        if(mWebChromeClient != null) goto _L3; else goto _L1
        Exception exception;
        exception;
        throw exception;
_L3:
        if(!mProgressUpdatePending) {
            sendEmptyMessage(106);
            mProgressUpdatePending = true;
        }
        this;
        JVM INSTR monitorexit ;
_L1:
    }

    public void onReachedMaxAppCacheSize(long l, long l1, WebStorage.QuotaUpdater quotaupdater) {
        if(mWebChromeClient == null) {
            quotaupdater.updateQuota(l1);
        } else {
            Message message = obtainMessage(127);
            HashMap hashmap = new HashMap();
            hashmap.put("requiredStorage", Long.valueOf(l));
            hashmap.put("quota", Long.valueOf(l1));
            hashmap.put("quotaUpdater", quotaupdater);
            message.obj = hashmap;
            sendMessage(message);
        }
    }

    public void onReceivedCertificate(SslCertificate sslcertificate) {
        sendMessage(obtainMessage(124, sslcertificate));
    }

    public void onReceivedClientCertRequest(ClientCertRequestHandler clientcertrequesthandler, String s) {
        if(mWebViewClient == null) {
            clientcertrequesthandler.cancel();
        } else {
            Message message = obtainMessage(141);
            HashMap hashmap = new HashMap();
            hashmap.put("handler", clientcertrequesthandler);
            hashmap.put("host_and_port", s);
            message.obj = hashmap;
            sendMessage(message);
        }
    }

    public void onReceivedError(int i, String s, String s1) {
        if(mWebViewClient != null) {
            Message message = obtainMessage(119);
            message.arg1 = i;
            message.getData().putString("description", s);
            message.getData().putString("failingUrl", s1);
            sendMessage(message);
        }
    }

    public void onReceivedHttpAuthCredentials(String s, String s1, String s2, String s3) {
        Message message = obtainMessage(137);
        message.getData().putString("host", s);
        message.getData().putString("realm", s1);
        message.getData().putString("username", s2);
        message.getData().putString("password", s3);
        sendMessage(message);
    }

    public void onReceivedHttpAuthRequest(HttpAuthHandler httpauthhandler, String s, String s1) {
        if(mWebViewClient == null) {
            httpauthhandler.cancel();
        } else {
            Message message = obtainMessage(104, httpauthhandler);
            message.getData().putString("host", s);
            message.getData().putString("realm", s1);
            sendMessage(message);
        }
    }

    public void onReceivedIcon(Bitmap bitmap) {
        WebHistoryItem webhistoryitem = mBackForwardList.getCurrentItem();
        if(webhistoryitem != null)
            webhistoryitem.setFavicon(bitmap);
        if(mWebChromeClient != null)
            sendMessage(obtainMessage(101, bitmap));
    }

    void onReceivedLoginRequest(String s, String s1, String s2) {
        if(mWebViewClient != null) {
            Message message = obtainMessage(140);
            Bundle bundle = message.getData();
            bundle.putString("realm", s);
            bundle.putString("account", s1);
            bundle.putString("args", s2);
            sendMessage(message);
        }
    }

    public void onReceivedSslError(SslErrorHandler sslerrorhandler, SslError sslerror) {
        if(mWebViewClient == null) {
            sslerrorhandler.cancel();
        } else {
            Message message = obtainMessage(105);
            HashMap hashmap = new HashMap();
            hashmap.put("handler", sslerrorhandler);
            hashmap.put("error", sslerror);
            message.obj = hashmap;
            sendMessage(message);
        }
    }

    public void onReceivedTitle(String s) {
        if(mWebChromeClient != null)
            sendMessage(obtainMessage(102, s));
    }

    void onReceivedTouchIconUrl(String s, boolean flag) {
        WebHistoryItem webhistoryitem = mBackForwardList.getCurrentItem();
        if(webhistoryitem != null)
            webhistoryitem.setTouchIconUrl(s, flag);
        if(mWebChromeClient != null) {
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            sendMessage(obtainMessage(132, i, 0, s));
        }
    }

    public void onRequestFocus() {
        if(mWebChromeClient != null)
            sendEmptyMessage(122);
    }

    public boolean onSavePassword(String s, String s1, String s2, Message message) {
        Message message1 = obtainMessage(111, obtainMessage(200));
        Bundle bundle = message1.getData();
        bundle.putString("host", s);
        bundle.putString("username", s1);
        bundle.putString("password", s2);
        sendMessageToUiThreadSync(message1);
        return false;
    }

    public void onScaleChanged(float f, float f1) {
        if(mWebViewClient != null) {
            Message message = obtainMessage(123);
            Bundle bundle = message.getData();
            bundle.putFloat("old", f);
            bundle.putFloat("new", f1);
            sendMessage(message);
        }
    }

    void onSearchboxDispatchCompleteCallback(String s, int i, boolean flag) {
        Message message = obtainMessage(143);
        message.obj = Boolean.valueOf(flag);
        message.getData().putString("function", s);
        message.getData().putInt("id", i);
        sendMessage(message);
    }

    void onSearchboxSuggestionsReceived(String s, List list) {
        Message message = obtainMessage(139);
        message.obj = list;
        message.getData().putString("query", s);
        sendMessage(message);
    }

    public void onTooManyRedirects(Message message, Message message1) {
    }

    public void onUnhandledKeyEvent(KeyEvent keyevent) {
        if(mWebViewClient != null)
            sendMessage(obtainMessage(116, keyevent));
    }

    Uri openFileChooser(String s, String s1) {
        Uri uri = null;
        if(mWebChromeClient != null) {
            Message message = obtainMessage(134);
            UploadFile uploadfile = new UploadFile();
            message.obj = new UploadFileMessageData(uploadfile, s, s1);
            sendMessageToUiThreadSync(message);
            uri = uploadfile.getResult();
        }
        return uri;
    }

    public void setDownloadListener(DownloadListener downloadlistener) {
        mDownloadListener = downloadlistener;
    }

    void setInstallableWebApp() {
        if(mWebChromeClient != null)
            sendMessage(obtainMessage(138));
    }

    void setWebBackForwardListClient(WebBackForwardListClient webbackforwardlistclient) {
        mWebBackForwardListClient = webbackforwardlistclient;
    }

    public void setWebChromeClient(WebChromeClient webchromeclient) {
        mWebChromeClient = webchromeclient;
    }

    public void setWebViewClient(WebViewClient webviewclient) {
        mWebViewClient = webviewclient;
    }

    WebResourceResponse shouldInterceptRequest(String s) {
        if(mWebViewClient != null) goto _L2; else goto _L1
_L1:
        WebResourceResponse webresourceresponse = null;
_L4:
        return webresourceresponse;
_L2:
        webresourceresponse = mWebViewClient.shouldInterceptRequest(mWebView.getWebView(), s);
        if(webresourceresponse == null)
            sendMessage(obtainMessage(108, s));
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean shouldOverrideUrlLoading(String s) {
        ResultTransport resulttransport = new ResultTransport(Boolean.valueOf(false));
        Message message = obtainMessage(103);
        message.getData().putString("url", s);
        message.obj = resulttransport;
        sendMessageToUiThreadSync(message);
        return ((Boolean)resulttransport.getResult()).booleanValue();
    }

    protected void shutdown() {
        removeCallbacksAndMessages(null);
        setWebViewClient(null);
        setWebChromeClient(null);
    }

    void switchOutDrawHistory() {
        sendMessage(obtainMessage(125));
    }

    public boolean uiOverrideKeyEvent(KeyEvent keyevent) {
        boolean flag;
        if(mWebViewClient != null)
            flag = mWebViewClient.shouldOverrideKeyEvent(mWebView.getWebView(), keyevent);
        else
            flag = false;
        return flag;
    }

    public boolean uiOverrideUrlLoading(String s) {
        if(s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        Intent intent;
        flag = false;
        if(mWebViewClient != null) {
            flag = mWebViewClient.shouldOverrideUrlLoading(mWebView.getWebView(), s);
            continue; /* Loop/switch isn't completed */
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.putExtra("com.android.browser.application_id", mContext.getPackageName());
        mContext.startActivity(intent);
        flag = true;
        continue; /* Loop/switch isn't completed */
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final int ADD_HISTORY_ITEM = 135;
    private static final int ADD_MESSAGE_TO_CONSOLE = 129;
    private static final int ASYNC_KEYEVENTS = 116;
    private static final int AUTH_CREDENTIALS = 137;
    private static final int AUTH_REQUEST = 104;
    private static final int AUTO_LOGIN = 140;
    private static final int CLIENT_CERT_REQUEST = 141;
    private static final int CLOSE_WINDOW = 110;
    private static final int CREATE_WINDOW = 109;
    private static final int DOWNLOAD_FILE = 118;
    private static final int EXCEEDED_DATABASE_QUOTA = 126;
    private static final int GEOLOCATION_PERMISSIONS_HIDE_PROMPT = 131;
    private static final int GEOLOCATION_PERMISSIONS_SHOW_PROMPT = 130;
    private static final int GET_VISITED_HISTORY = 133;
    private static final int HISTORY_INDEX_CHANGED = 136;
    private static final int JS_ALERT = 112;
    private static final int JS_CONFIRM = 113;
    private static final int JS_PROMPT = 114;
    private static final int JS_TIMEOUT = 128;
    private static final int JS_UNLOAD = 115;
    private static final int LOAD_RESOURCE = 108;
    private static final String LOGTAG = "CallbackProxy";
    private static final int MAIN_FRAME_FINISH_PARSING = 210;
    private static final int NOTIFY = 200;
    private static final int NOTIFY_SEARCHBOX_LISTENERS = 139;
    private static final int OPEN_FILE_CHOOSER = 134;
    private static final int OVERRIDE_URL = 103;
    private static final int PAGE_FINISHED = 121;
    private static final int PAGE_STARTED = 100;
    private static final boolean PERF_PROBE = false;
    private static final int PROCEEDED_AFTER_SSL_ERROR = 144;
    private static final int PROGRESS = 106;
    private static final int REACHED_APPCACHE_MAXSIZE = 127;
    private static final int RECEIVED_CERTIFICATE = 124;
    private static final int RECEIVED_ICON = 101;
    private static final int RECEIVED_TITLE = 102;
    private static final int RECEIVED_TOUCH_ICON_URL = 132;
    private static final int REPORT_ERROR = 119;
    private static final int REQUEST_FOCUS = 122;
    private static final int RESEND_POST_DATA = 120;
    private static final int SAVE_PASSWORD = 111;
    private static final int SCALE_CHANGED = 123;
    private static final int SEARCHBOX_DISPATCH_COMPLETE_CALLBACK = 143;
    private static final int SEARCHBOX_IS_SUPPORTED_CALLBACK = 142;
    private static final int SET_INSTALLABLE_WEBAPP = 138;
    private static final int SSL_ERROR = 105;
    private static final int SWITCH_OUT_HISTORY = 125;
    private static final int UPDATE_VISITED = 107;
    private final WebBackForwardList mBackForwardList = new WebBackForwardList(this);
    private boolean mBlockMessages;
    private final Context mContext;
    private volatile DownloadListener mDownloadListener;
    private volatile int mLatestProgress;
    private boolean mProgressUpdatePending;
    private volatile WebBackForwardListClient mWebBackForwardListClient;
    private volatile WebChromeClient mWebChromeClient;
    private long mWebCoreIdleTime;
    private long mWebCoreThreadTime;
    private final WebViewClassic mWebView;
    private volatile WebViewClient mWebViewClient;
}
