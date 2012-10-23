// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.app.ActivityManager;
import android.content.*;
import android.content.res.*;
import android.graphics.Bitmap;
import android.net.*;
import android.net.http.*;
import android.os.Handler;
import android.os.Message;
import android.util.*;
import android.view.*;
import java.io.*;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.util.*;
import libcore.net.MimeUtils;
import org.apache.harmony.security.provider.cert.X509CertImpl;
import org.apache.harmony.xnet.provider.jsse.OpenSSLDSAPrivateKey;
import org.apache.harmony.xnet.provider.jsse.OpenSSLRSAPrivateKey;

// Referenced classes of package android.webkit:
//            JWebCoreJavaBridge, CacheManager, CookieSyncManager, PluginManager, 
//            SearchBoxImpl, CallbackProxy, WebViewCore, KeyStoreHandler, 
//            MimeTypeMap, CertTool, WebSettingsClassic, WebBackForwardList, 
//            WebHistoryItem, WebViewDatabaseClassic, SslCertLookupTable, SslClientCertLookupTable, 
//            ClientCertRequestHandler, WebTextView, WebResourceResponse, WebViewClassic, 
//            ViewManager, URLUtil, SearchBox, HttpAuthHandler, 
//            SslErrorHandler

class BrowserFrame extends Handler {
    private static class ConfigCallback
        implements ComponentCallbacks {

        /**
         * @deprecated Method addHandler is deprecated
         */

        public void addHandler(Handler handler) {
            this;
            JVM INSTR monitorenter ;
            mHandlers.add(new WeakReference(handler));
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void onConfigurationChanged(Configuration configuration) {
            if(mHandlers.size() != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i = mWindowManager.getDefaultDisplay().getOrientation();
            i;
            JVM INSTR tableswitch 0 3: default 56
        //                       0 164
        //                       1 145
        //                       2 151
        //                       3 158;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            this;
            JVM INSTR monitorenter ;
            ArrayList arraylist;
            Iterator iterator;
            arraylist = new ArrayList(mHandlers.size());
            iterator = mHandlers.iterator();
_L12:
            if(!iterator.hasNext()) goto _L9; else goto _L8
_L8:
            WeakReference weakreference1;
            Handler handler;
            weakreference1 = (WeakReference)iterator.next();
            handler = (Handler)weakreference1.get();
            if(handler == null) goto _L11; else goto _L10
_L10:
            handler.sendMessage(handler.obtainMessage(1002, i, 0));
              goto _L12
            Exception exception;
            exception;
            throw exception;
_L5:
            i = 90;
              goto _L3
_L6:
            i = 180;
              goto _L3
_L7:
            i = -90;
              goto _L3
_L4:
            i = 0;
              goto _L3
_L11:
            arraylist.add(weakreference1);
              goto _L12
_L9:
            WeakReference weakreference;
            for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); mHandlers.remove(weakreference))
                weakreference = (WeakReference)iterator1.next();

            this;
            JVM INSTR monitorexit ;
              goto _L1
        }

        public void onLowMemory() {
        }

        private final ArrayList mHandlers = new ArrayList();
        private final WindowManager mWindowManager;

        ConfigCallback(WindowManager windowmanager) {
            mWindowManager = windowmanager;
        }
    }


    public BrowserFrame(Context context, WebViewCore webviewcore, CallbackProxy callbackproxy, WebSettingsClassic websettingsclassic, Map map) {
        mFirstLayoutDone = true;
        mCommitted = true;
        mBlockMessages = false;
        mOrientation = -1;
        mKeyStoreHandler = null;
        Context context1 = context.getApplicationContext();
        if(sJavaBridge == null) {
            sJavaBridge = new JWebCoreJavaBridge();
            if(((ActivityManager)context.getSystemService("activity")).getMemoryClass() > 16)
                sJavaBridge.setCacheSize(0x800000);
            else
                sJavaBridge.setCacheSize(0x400000);
            CacheManager.init(context1);
            CookieSyncManager.createInstance(context1);
            PluginManager.getInstance(context1);
        }
        if(sConfigCallback == null) {
            sConfigCallback = new ConfigCallback((WindowManager)context1.getSystemService("window"));
            ViewRootImpl.addConfigCallback(sConfigCallback);
        }
        sConfigCallback.addHandler(this);
        mJavaScriptObjects = map;
        if(mJavaScriptObjects == null)
            mJavaScriptObjects = new HashMap();
        mRemovedJavaScriptObjects = new HashSet();
        mSettings = websettingsclassic;
        mContext = context;
        mCallbackProxy = callbackproxy;
        mWebViewCore = webviewcore;
        mSearchBox = new SearchBoxImpl(mWebViewCore, mCallbackProxy);
        mJavaScriptObjects.put("searchBoxJavaBridge_", mSearchBox);
        nativeCreateFrame(webviewcore, context.getAssets(), callbackproxy.getBackForwardList());
    }

    private void autoLogin(String s, String s1, String s2) {
        mCallbackProxy.onReceivedLoginRequest(s, s1, s2);
    }

    private native String childFramesAsText();

    private void closeWindow(WebViewCore webviewcore) {
        mCallbackProxy.onCloseWindow(webviewcore.getWebViewClassic());
    }

    private BrowserFrame createWindow(boolean flag, boolean flag1) {
        return mCallbackProxy.createWindow(flag, flag1);
    }

    private void decidePolicyForFormResubmission(int i) {
        Message message = obtainMessage(1003, i, 2);
        Message message1 = obtainMessage(1003, i, 0);
        mCallbackProxy.onFormResubmission(message, message1);
    }

    private float density() {
        return mContext.getResources().getDisplayMetrics().density;
    }

    private void didFinishLoading() {
        if(mKeyStoreHandler != null) {
            mKeyStoreHandler.installCert(mContext);
            mKeyStoreHandler = null;
        }
    }

    private void didReceiveAuthenticationChallenge(final int handle, String s, String s1, final boolean useCachedCredentials, final boolean suppressDialog) {
        HttpAuthHandler httpauthhandler = new HttpAuthHandler() {

            public void cancel() {
                nativeAuthenticationCancel(handle);
            }

            public void proceed(String s2, String s3) {
                nativeAuthenticationProceed(handle, s2, s3);
            }

            public boolean suppressDialog() {
                return suppressDialog;
            }

            public boolean useHttpAuthUsernamePassword() {
                return useCachedCredentials;
            }

            final BrowserFrame this$0;
            final int val$handle;
            final boolean val$suppressDialog;
            final boolean val$useCachedCredentials;

             {
                this$0 = BrowserFrame.this;
                useCachedCredentials = flag;
                handle = i;
                suppressDialog = flag1;
                super();
            }
        };
        mCallbackProxy.onReceivedHttpAuthRequest(httpauthhandler, s, s1);
    }

    private void didReceiveData(byte abyte0[], int i) {
        if(mKeyStoreHandler != null)
            mKeyStoreHandler.didReceiveData(abyte0, i);
    }

    private void didReceiveIcon(Bitmap bitmap) {
        mCallbackProxy.onReceivedIcon(bitmap);
    }

    private void didReceiveTouchIconUrl(String s, boolean flag) {
        mCallbackProxy.onReceivedTouchIconUrl(s, flag);
    }

    private native String documentAsText();

    private void downloadStart(String s, String s1, String s2, String s3, long l) {
        String s4;
        if(s3.isEmpty())
            try {
                s3 = MimeUtils.guessMimeTypeFromExtension(s.substring(1 + s.lastIndexOf('.')));
                if(s3 == null)
                    s3 = "";
            }
            catch(IndexOutOfBoundsException indexoutofboundsexception) { }
        s4 = MimeTypeMap.getSingleton().remapGenericMimeType(s3, s, s2);
        if(CertTool.getCertType(s4) != null)
            mKeyStoreHandler = new KeyStoreHandler(s4);
        else
            mCallbackProxy.onDownloadStart(s, s1, s2, s4, l);
    }

    private native String externalRepresentation();

    private int getFile(String s, byte abyte0[], int i, int j) {
        int k;
        InputStream inputstream;
        inputstream = mContext.getContentResolver().openInputStream(Uri.parse(s));
        k = inputstream.available();
        if(k > j || abyte0 == null || abyte0.length - i < k) goto _L2; else goto _L1
_L1:
        inputstream.read(abyte0, i, k);
_L3:
        inputstream.close();
_L4:
        return k;
_L2:
        k = 0;
          goto _L3
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Log.e("webkit", (new StringBuilder()).append("FileNotFoundException:").append(filenotfoundexception).toString());
        k = 0;
          goto _L4
        IOException ioexception;
        ioexception;
        Log.e("webkit", (new StringBuilder()).append("IOException: ").append(ioexception).toString());
        k = 0;
          goto _L4
    }

    private int getFileSize(String s) {
        int i = 0;
        try {
            InputStream inputstream = mContext.getContentResolver().openInputStream(Uri.parse(s));
            i = inputstream.available();
            inputstream.close();
        }
        catch(Exception exception) { }
        return i;
    }

    private String getRawResFilename(int i) {
        return getRawResFilename(i, mContext);
    }

    static String getRawResFilename(int i, Context context) {
        i;
        JVM INSTR tableswitch 1 7: default 44
    //                   1 59
    //                   2 128
    //                   3 135
    //                   4 142
    //                   5 156
    //                   6 170
    //                   7 184;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        String s;
        Log.e("webkit", "getRawResFilename got incompatible resource ID");
        s = "";
_L11:
        return s;
_L2:
        int j = 0x1100004;
_L9:
        TypedValue typedvalue = new TypedValue();
        context.getResources().getValue(j, typedvalue, true);
        if(i == 3) {
            String s1 = typedvalue.string.toString();
            int k = s1.lastIndexOf('/');
            if(k < 0) {
                Log.e("webkit", "Can't find drawable directory.");
                s = "";
            } else {
                s = s1.substring(0, k + 1);
            }
        } else {
            s = typedvalue.string.toString();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        j = 0x1100003;
          goto _L9
_L4:
        j = 0x10800e2;
          goto _L9
_L5:
        s = context.getResources().getString(0x104047f);
        continue; /* Loop/switch isn't completed */
_L6:
        s = context.getResources().getString(0x1040481);
        continue; /* Loop/switch isn't completed */
_L7:
        s = context.getResources().getString(0x1040482);
        continue; /* Loop/switch isn't completed */
_L8:
        s = context.getResources().getString(0x1040480);
        if(true) goto _L11; else goto _L10
_L10:
    }

    private native String[] getUsernamePassword();

    private native boolean hasPasswordField();

    private InputStream inputStreamForAndroidResource(String s) {
        if(!s.startsWith("file:///android_res/")) goto _L2; else goto _L1
_L1:
        String s2 = s.replaceFirst("file:///android_res/", "");
        if(s2 != null && s2.length() != 0) goto _L4; else goto _L3
_L3:
        InputStream inputstream;
        Log.e("webkit", (new StringBuilder()).append("url has length 0 ").append(s2).toString());
        inputstream = null;
_L6:
        return inputstream;
_L4:
        int j = s2.indexOf('/');
        int k = s2.indexOf('.', j);
        if(j == -1 || k == -1) {
            Log.e("webkit", (new StringBuilder()).append("Incorrect res path: ").append(s2).toString());
            inputstream = null;
            continue; /* Loop/switch isn't completed */
        }
        String s3 = s2.substring(0, j);
        String s4 = s2.substring(j + 1, k);
        try {
            int l = mContext.getApplicationContext().getClassLoader().loadClass((new StringBuilder()).append(mContext.getPackageName()).append(".R$").append(s3).toString()).getField(s4).getInt(null);
            TypedValue typedvalue = new TypedValue();
            mContext.getResources().getValue(l, typedvalue, true);
            if(typedvalue.type == 3) {
                inputstream = mContext.getAssets().openNonAsset(typedvalue.assetCookie, typedvalue.string.toString(), 2);
                continue; /* Loop/switch isn't completed */
            }
            Log.e("webkit", (new StringBuilder()).append("not of type string: ").append(s2).toString());
        }
        catch(Exception exception1) {
            Log.e("webkit", (new StringBuilder()).append("Exception: ").append(s2).toString());
            inputstream = null;
            continue; /* Loop/switch isn't completed */
        }
        inputstream = null;
        continue; /* Loop/switch isn't completed */
_L2:
        if(s.startsWith("file:///android_asset/")) {
            String s1 = s.replaceFirst("file:///android_asset/", "");
            InputStream inputstream2;
            try {
                inputstream2 = mContext.getAssets().open(Uri.parse(s1).getPath(), 2);
            }
            catch(IOException ioexception) {
                inputstream = null;
                continue; /* Loop/switch isn't completed */
            }
            inputstream = inputstream2;
            continue; /* Loop/switch isn't completed */
        }
        if(mSettings.getAllowContentAccess() && s.startsWith("content:")) {
            InputStream inputstream1;
            try {
                int i = s.lastIndexOf('?');
                if(i != -1)
                    s = s.substring(0, i);
                Uri uri = Uri.parse(s);
                inputstream1 = mContext.getContentResolver().openInputStream(uri);
            }
            catch(Exception exception) {
                Log.e("webkit", (new StringBuilder()).append("Exception: ").append(s).toString());
                inputstream = null;
                continue; /* Loop/switch isn't completed */
            }
            inputstream = inputstream1;
            continue; /* Loop/switch isn't completed */
        }
        inputstream = null;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void loadFinished(String s, int i, boolean flag) {
        if((flag || i == 0) && flag) {
            resetLoadingStates();
            mCallbackProxy.switchOutDrawHistory();
            mCallbackProxy.onPageFinished(s);
        }
    }

    private void loadStarted(String s, Bitmap bitmap, int i, boolean flag) {
        mIsMainFrame = flag;
        if(flag || i == 0) {
            mLoadType = i;
            if(flag) {
                mCallbackProxy.onPageStarted(s, bitmap);
                mFirstLayoutDone = false;
                mCommitted = false;
                mWebViewCore.clearContent();
                mWebViewCore.removeMessages(130);
            }
        }
    }

    private void maybeSavePassword(byte abyte0[], String s, String s1) {
_L2:
        return;
        if(abyte0 == null || s == null || s.isEmpty() || s1 == null || s1.isEmpty() || !mSettings.getSavePassword()) goto _L2; else goto _L1
_L1:
        try {
            WebAddress webaddress = new WebAddress(mCallbackProxy.getBackForwardList().getCurrentItem().getUrl());
            String s2 = (new StringBuilder()).append(webaddress.getScheme()).append(webaddress.getHost()).toString();
            String s3 = new String(abyte0);
            WebViewDatabaseClassic webviewdatabaseclassic = WebViewDatabaseClassic.getInstance(mContext);
            if(s3.contains(URLEncoder.encode(s)) && s3.contains(URLEncoder.encode(s1))) {
                String as[] = webviewdatabaseclassic.getUsernamePassword(s2);
                if(as != null) {
                    if(as[0] != null)
                        webviewdatabaseclassic.setUsernamePassword(s2, s, s1);
                } else {
                    mCallbackProxy.onSavePassword(s2, s, s1, null);
                }
            }
        }
        catch(ParseException parseexception) { }
        if(true) goto _L2; else goto _L3
_L3:
    }

    private native void nativeAddJavascriptInterface(int i, Object obj, String s);

    private native void nativeAuthenticationCancel(int i);

    private native void nativeAuthenticationProceed(int i, String s, String s1);

    private native void nativeCallPolicyFunction(int i, int j);

    private native void nativeCreateFrame(WebViewCore webviewcore, AssetManager assetmanager, WebBackForwardList webbackforwardlist);

    private native boolean nativeGetShouldStartScrolledRight(int i);

    private native void nativeGoBackOrForward(int i);

    private native void nativeLoadData(String s, String s1, String s2, String s3, String s4);

    private native void nativeLoadUrl(String s, Map map);

    private native void nativeOrientationChanged(int i);

    private native void nativePostUrl(String s, byte abyte0[]);

    private native String nativeSaveWebArchive(String s, boolean flag);

    private native void nativeSslCertErrorCancel(int i, int j);

    private native void nativeSslCertErrorProceed(int i);

    private native void nativeStopLoading();

    private void reportError(int i, String s, String s1) {
        resetLoadingStates();
        if(s == null || s.isEmpty())
            s = ErrorStrings.getString(i, mContext);
        mCallbackProxy.onReceivedError(i, s, s1);
    }

    private void reportSslCertError(final int handle, final int certError, byte abyte0[], String s) {
label0:
        {
            final SslError sslError;
            try {
                sslError = SslError.SslErrorFromChromiumErrorCode(certError, new SslCertificate(new X509CertImpl(abyte0)), s);
            }
            catch(IOException ioexception) {
                Log.e("webkit", "Can't get the certificate from WebKit, canceling");
                nativeSslCertErrorCancel(handle, certError);
                if(false)
                    ;
                else
                    break label0;
            }
            if(SslCertLookupTable.getInstance().isAllowed(sslError)) {
                nativeSslCertErrorProceed(handle);
                mCallbackProxy.onProceededAfterSslError(sslError);
            } else {
                SslErrorHandler sslerrorhandler = new SslErrorHandler() {

                    public void cancel() {
                        post(new Runnable() {

                            public void run() {
                                nativeSslCertErrorCancel(handle, certError);
                            }

                            final _cls2 this$1;

                     {
                        this$1 = _cls2.this;
                        super();
                    }
                        });
                    }

                    public void proceed() {
                        SslCertLookupTable.getInstance().setIsAllowed(sslError);
                        post(new Runnable() {

                            public void run() {
                                nativeSslCertErrorProceed(handle);
                            }

                            final _cls2 this$1;

                     {
                        this$1 = _cls2.this;
                        super();
                    }
                        });
                    }

                    final BrowserFrame this$0;
                    final int val$certError;
                    final int val$handle;
                    final SslError val$sslError;

             {
                this$0 = BrowserFrame.this;
                sslError = sslerror;
                handle = i;
                certError = j;
                super();
            }
                };
                mCallbackProxy.onReceivedSslError(sslerrorhandler, sslError);
            }
        }
    }

    private void requestClientCert(int i, String s) {
        SslClientCertLookupTable sslclientcertlookuptable = SslClientCertLookupTable.getInstance();
        if(sslclientcertlookuptable.IsAllowed(s)) {
            PrivateKey privatekey = sslclientcertlookuptable.PrivateKey(s);
            if(privatekey instanceof OpenSSLRSAPrivateKey)
                nativeSslClientCert(i, ((OpenSSLRSAPrivateKey)privatekey).getPkeyContext(), sslclientcertlookuptable.CertificateChain(s));
            else
            if(privatekey instanceof OpenSSLDSAPrivateKey)
                nativeSslClientCert(i, ((OpenSSLDSAPrivateKey)privatekey).getPkeyContext(), sslclientcertlookuptable.CertificateChain(s));
            else
                nativeSslClientCert(i, privatekey.getEncoded(), sslclientcertlookuptable.CertificateChain(s));
        } else
        if(sslclientcertlookuptable.IsDenied(s))
            nativeSslClientCert(i, 0, (byte[][])null);
        else
            mCallbackProxy.onReceivedClientCertRequest(new ClientCertRequestHandler(this, i, s, sslclientcertlookuptable), s);
    }

    private void requestFocus() {
        mCallbackProxy.onRequestFocus();
    }

    private void resetLoadingStates() {
        mCommitted = true;
        mFirstLayoutDone = true;
    }

    private void saveFormData(HashMap hashmap) {
        if(mSettings.getSaveFormData()) {
            WebHistoryItem webhistoryitem = mCallbackProxy.getBackForwardList().getCurrentItem();
            if(webhistoryitem != null) {
                String s = WebTextView.urlForAutoCompleteData(webhistoryitem.getUrl());
                if(s != null)
                    WebViewDatabaseClassic.getInstance(mContext).setFormData(s, hashmap);
            }
        }
    }

    private void setCertificate(byte abyte0[]) {
        X509CertImpl x509certimpl = new X509CertImpl(abyte0);
        mCallbackProxy.onReceivedCertificate(new SslCertificate(x509certimpl));
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.e("webkit", "Can't get the certificate from WebKit, canceling");
          goto _L1
    }

    private void setProgress(int i) {
        mCallbackProxy.onProgressChanged(i);
        if(i == 100)
            sendMessageDelayed(obtainMessage(1001), 100L);
        if(mFirstLayoutDone && i > 75)
            mCallbackProxy.switchOutDrawHistory();
    }

    private void setTitle(String s) {
        mCallbackProxy.onReceivedTitle(s);
    }

    private native void setUsernamePassword(String s, String s1);

    private WebResourceResponse shouldInterceptRequest(String s) {
        InputStream inputstream = inputStreamForAndroidResource(s);
        if(inputstream == null) goto _L2; else goto _L1
_L1:
        WebResourceResponse webresourceresponse = new WebResourceResponse(null, null, inputstream);
_L4:
        return webresourceresponse;
_L2:
        if(!mSettings.getAllowFileAccess() && s.startsWith("file://")) {
            webresourceresponse = new WebResourceResponse(null, null, null);
            continue; /* Loop/switch isn't completed */
        }
        webresourceresponse = mCallbackProxy.shouldInterceptRequest(s);
        if(webresourceresponse != null || !"browser:incognito".equals(s))
            continue; /* Loop/switch isn't completed */
        WebResourceResponse webresourceresponse1 = new WebResourceResponse("text/html", "utf8", mContext.getResources().openRawResource(0x1100002));
        webresourceresponse = webresourceresponse1;
        continue; /* Loop/switch isn't completed */
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        Log.w("webkit", "Failed opening raw.incognito_mode_start_page", notfoundexception);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean shouldSaveFormData() {
        boolean flag = false;
        if(mSettings.getSaveFormData()) {
            WebHistoryItem webhistoryitem = mCallbackProxy.getBackForwardList().getCurrentItem();
            if(webhistoryitem != null && webhistoryitem.getUrl() != null)
                flag = true;
        }
        return flag;
    }

    private void transitionToCommitted(int i, boolean flag) {
        if(flag) {
            mCommitted = true;
            mWebViewCore.getWebViewClassic().mViewManager.postResetStateAll();
        }
    }

    private void updateVisitedHistory(String s, boolean flag) {
        mCallbackProxy.doUpdateVisitedHistory(s, flag);
    }

    private void windowObjectCleared(int i) {
        Iterator iterator = mJavaScriptObjects.keySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            if(mJavaScriptObjects.get(s) != null)
                nativeAddJavascriptInterface(i, mJavaScriptObjects.get(s), s);
        } while(true);
        mRemovedJavaScriptObjects.clear();
        stringByEvaluatingJavaScriptFromString("(function(){if (!window.chrome) {  window.chrome = {};}if (!window.chrome.searchBox) {  var sb = window.chrome.searchBox = {};  sb.setSuggestions = function(suggestions) {    if (window.searchBoxJavaBridge_) {      window.searchBoxJavaBridge_.setSuggestions(JSON.stringify(suggestions));    }  };  sb.setValue = function(valueArray) { sb.value = valueArray[0]; };  sb.value = '';  sb.x = 0;  sb.y = 0;  sb.width = 0;  sb.height = 0;  sb.selectionStart = 0;  sb.selectionEnd = 0;  sb.verbatim = false;}})();");
    }

    public void addJavascriptInterface(Object obj, String s) {
        if(!$assertionsDisabled && obj == null) {
            throw new AssertionError();
        } else {
            removeJavascriptInterface(s);
            mJavaScriptObjects.put(s, obj);
            return;
        }
    }

    public native void clearCache();

    boolean committed() {
        return mCommitted;
    }

    public void destroy() {
        nativeDestroyFrame();
        mBlockMessages = true;
        removeCallbacksAndMessages(null);
    }

    void didFirstLayout() {
        if(!mFirstLayoutDone) {
            mFirstLayoutDone = true;
            mWebViewCore.contentDraw();
        }
    }

    public void documentAsText(Message message) {
        StringBuilder stringbuilder = new StringBuilder();
        if(message.arg1 != 0)
            stringbuilder.append(documentAsText());
        if(message.arg2 != 0)
            stringbuilder.append(childFramesAsText());
        message.obj = stringbuilder.toString();
        message.sendToTarget();
    }

    public native boolean documentHasImages();

    public void externalRepresentation(Message message) {
        message.obj = externalRepresentation();
        message.sendToTarget();
    }

    boolean firstLayoutDone() {
        return mFirstLayoutDone;
    }

    CallbackProxy getCallbackProxy() {
        return mCallbackProxy;
    }

    SearchBox getSearchBox() {
        return mSearchBox;
    }

    boolean getShouldStartScrolledRight() {
        return nativeGetShouldStartScrolledRight(mNativeFrame);
    }

    String getUserAgentString() {
        return mSettings.getUserAgentString();
    }

    public void goBackOrForward(int i) {
        mLoadInitFromJava = true;
        nativeGoBackOrForward(i);
        mLoadInitFromJava = false;
    }

    public void handleMessage(Message message) {
        if(!mBlockMessages) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch(message.what) {
        case 1001: 
            if(mSettings.getSavePassword() && hasPasswordField()) {
                WebHistoryItem webhistoryitem = mCallbackProxy.getBackForwardList().getCurrentItem();
                if(webhistoryitem != null) {
                    WebAddress webaddress = new WebAddress(webhistoryitem.getUrl());
                    String s = (new StringBuilder()).append(webaddress.getScheme()).append(webaddress.getHost()).toString();
                    String as[] = WebViewDatabaseClassic.getInstance(mContext).getUsernamePassword(s);
                    if(as != null && as[0] != null)
                        setUsernamePassword(as[0], as[1]);
                }
            }
            break;

        case 1003: 
            nativeCallPolicyFunction(message.arg1, message.arg2);
            break;

        case 1002: 
            if(mOrientation != message.arg1) {
                mOrientation = message.arg1;
                nativeOrientationChanged(message.arg1);
            }
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean handleUrl(String s) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(!mLoadInitFromJava && mCallbackProxy.shouldOverrideUrlLoading(s)) {
            didFirstLayout();
            flag = true;
        }
        return flag;
    }

    public void loadData(String s, String s1, String s2, String s3, String s4) {
        mLoadInitFromJava = true;
        if(s4 == null || s4.length() == 0)
            s4 = "about:blank";
        if(s1 == null)
            s1 = "";
        if(s == null || s.length() == 0)
            s = "about:blank";
        if(s2 == null || s2.length() == 0)
            s2 = "text/html";
        nativeLoadData(s, s1, s2, s3, s4);
        mLoadInitFromJava = false;
    }

    int loadType() {
        return mLoadType;
    }

    public void loadUrl(String s, Map map) {
        mLoadInitFromJava = true;
        if(URLUtil.isJavaScriptUrl(s))
            stringByEvaluatingJavaScriptFromString(s.substring("javascript:".length()));
        else
            nativeLoadUrl(s, map);
        mLoadInitFromJava = false;
    }

    public native void nativeDestroyFrame();

    native void nativeSslClientCert(int i, int j, byte abyte0[][]);

    native void nativeSslClientCert(int i, byte abyte0[], byte abyte1[][]);

    public void postUrl(String s, byte abyte0[]) {
        mLoadInitFromJava = true;
        nativePostUrl(s, abyte0);
        mLoadInitFromJava = false;
    }

    public native void reload(boolean flag);

    public void removeJavascriptInterface(String s) {
        if(mJavaScriptObjects.containsKey(s))
            mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(s));
    }

    String saveWebArchive(String s, boolean flag) {
        return nativeSaveWebArchive(s, flag);
    }

    public void stopLoading() {
        if(mIsMainFrame)
            resetLoadingStates();
        nativeStopLoading();
    }

    public native String stringByEvaluatingJavaScriptFromString(String s);

    static final boolean $assertionsDisabled = false;
    static final int DRAWABLEDIR = 3;
    private static final int FILE_UPLOAD_LABEL = 4;
    private static final int FILE_UPLOAD_NO_FILE_CHOSEN = 7;
    static final int FRAME_COMPLETED = 1001;
    static final int FRAME_LOADTYPE_BACK = 1;
    static final int FRAME_LOADTYPE_FORWARD = 2;
    static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    static final int FRAME_LOADTYPE_REDIRECT = 7;
    static final int FRAME_LOADTYPE_RELOAD = 4;
    static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    static final int FRAME_LOADTYPE_REPLACE = 8;
    static final int FRAME_LOADTYPE_SAME = 6;
    static final int FRAME_LOADTYPE_STANDARD = 0;
    private static final int LOADERROR = 2;
    private static final String LOGTAG = "webkit";
    private static final int MAX_OUTSTANDING_REQUESTS = 300;
    private static final int NODOMAIN = 1;
    static final int ORIENTATION_CHANGED = 1002;
    static final int POLICY_FUNCTION = 1003;
    static final int POLICY_IGNORE = 2;
    static final int POLICY_USE = 0;
    private static final int RESET_LABEL = 5;
    private static final int SUBMIT_LABEL = 6;
    private static final int TRANSITION_SWITCH_THRESHOLD = 75;
    static ConfigCallback sConfigCallback;
    static JWebCoreJavaBridge sJavaBridge;
    private boolean mBlockMessages;
    private final CallbackProxy mCallbackProxy;
    private boolean mCommitted;
    private final Context mContext;
    private boolean mFirstLayoutDone;
    private boolean mIsMainFrame;
    private Map mJavaScriptObjects;
    private KeyStoreHandler mKeyStoreHandler;
    boolean mLoadInitFromJava;
    private int mLoadType;
    int mNativeFrame;
    private int mOrientation;
    private Set mRemovedJavaScriptObjects;
    private final SearchBoxImpl mSearchBox;
    private final WebSettingsClassic mSettings;
    private final WebViewCore mWebViewCore;

    static  {
        boolean flag;
        if(!android/webkit/BrowserFrame.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }




}
