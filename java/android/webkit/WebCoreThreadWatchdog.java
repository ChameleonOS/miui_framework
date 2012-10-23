// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.content.DialogInterface;
import android.os.*;
import java.util.*;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebView

class WebCoreThreadWatchdog
    implements Runnable {
    private class PageNotRespondingRunnable
        implements Runnable {

        public void run() {
            if(!$assertionsDisabled && Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new AssertionError();
            } else {
                (new android.app.AlertDialog.Builder(mContext)).setMessage(0x10403da).setPositiveButton(0x10403d7, new android.content.DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialoginterface, int i) {
                        Process.killProcess(Process.myPid());
                    }

                    final PageNotRespondingRunnable this$1;

                 {
                    this$1 = PageNotRespondingRunnable.this;
                    super();
                }
                }).setNegativeButton(0x10403d9, new android.content.DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialoginterface, int i) {
                        mWatchdogHandler.sendMessageDelayed(mWatchdogHandler.obtainMessage(101), 15000L);
                    }

                    final PageNotRespondingRunnable this$1;

                 {
                    this$1 = PageNotRespondingRunnable.this;
                    super();
                }
                }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    public void onCancel(DialogInterface dialoginterface) {
                        mWatchdogHandler.sendMessageDelayed(mWatchdogHandler.obtainMessage(101), 15000L);
                    }

                    final PageNotRespondingRunnable this$1;

                 {
                    this$1 = PageNotRespondingRunnable.this;
                    super();
                }
                }).setIcon(0x1080027).show();
                return;
            }
        }

        static final boolean $assertionsDisabled;
        Context mContext;
        private Handler mWatchdogHandler;
        final WebCoreThreadWatchdog this$0;

        static  {
            boolean flag;
            if(!android/webkit/WebCoreThreadWatchdog.desiredAssertionStatus())
                flag = true;
            else
                flag = false;
            $assertionsDisabled = flag;
        }


        public PageNotRespondingRunnable(Context context, Handler handler) {
            this$0 = WebCoreThreadWatchdog.this;
            super();
            mContext = context;
            mWatchdogHandler = handler;
        }
    }


    private WebCoreThreadWatchdog(Handler handler) {
        mWebCoreThreadHandler = handler;
    }

    private void addWebView(WebViewClassic webviewclassic) {
        if(mWebViews == null)
            mWebViews = new HashSet();
        mWebViews.add(webviewclassic);
    }

    private void createHandler() {
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorenter ;
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 100 101: default 28
            //                           100 29
            //                           101 121;
                   goto _L1 _L2 _L3
_L1:
                return;
_L2:
                android/webkit/WebCoreThreadWatchdog;
                JVM INSTR monitorenter ;
                if(mPaused)
                    continue; /* Loop/switch isn't completed */
                  goto _L4
                Exception exception;
                exception;
                throw exception;
_L4:
                removeMessages(101);
                sendMessageDelayed(obtainMessage(101), 30000L);
                mWebCoreThreadHandler.sendMessageDelayed(mWebCoreThreadHandler.obtainMessage(197, mHandler.obtainMessage(100)), 10000L);
                android/webkit/WebCoreThreadWatchdog;
                JVM INSTR monitorexit ;
                continue; /* Loop/switch isn't completed */
_L3:
                boolean flag = false;
                android/webkit/WebCoreThreadWatchdog;
                JVM INSTR monitorenter ;
                Iterator iterator = mWebViews.iterator();
label0:
                do {
                    WebView webview;
                    do {
                        if(!iterator.hasNext())
                            break label0;
                        webview = ((WebViewClassic)iterator.next()).getWebView();
                    } while(webview.getWindowToken() == null || webview.getViewRootImpl() == null);
                    flag = webview.post(new PageNotRespondingRunnable(webview.getContext(), this));
                } while(!flag);
                if(!flag)
                    sendMessageDelayed(obtainMessage(101), 15000L);
                if(true) goto _L1; else goto _L5
_L5:
            }

            final WebCoreThreadWatchdog this$0;

             {
                this$0 = WebCoreThreadWatchdog.this;
                super();
            }
        };
        return;
    }

    /**
     * @deprecated Method pause is deprecated
     */

    public static void pause() {
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorenter ;
        if(sInstance != null)
            sInstance.pauseWatchdog();
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void pauseWatchdog() {
        mPaused = true;
        if(mHandler != null) {
            mHandler.removeMessages(101);
            mHandler.removeMessages(100);
            mWebCoreThreadHandler.removeMessages(197);
        }
    }

    /**
     * @deprecated Method registerWebView is deprecated
     */

    public static void registerWebView(WebViewClassic webviewclassic) {
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorenter ;
        if(sInstance != null)
            sInstance.addWebView(webviewclassic);
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void removeWebView(WebViewClassic webviewclassic) {
        mWebViews.remove(webviewclassic);
    }

    /**
     * @deprecated Method resume is deprecated
     */

    public static void resume() {
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorenter ;
        if(sInstance != null)
            sInstance.resumeWatchdog();
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void resumeWatchdog() {
        if(mPaused) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mPaused = false;
        if(mHandler != null) {
            mWebCoreThreadHandler.obtainMessage(197, mHandler.obtainMessage(100)).sendToTarget();
            mHandler.sendMessageDelayed(mHandler.obtainMessage(101), 30000L);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    /**
     * @deprecated Method start is deprecated
     */

    public static WebCoreThreadWatchdog start(Handler handler) {
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorenter ;
        WebCoreThreadWatchdog webcorethreadwatchdog;
        if(sInstance == null) {
            sInstance = new WebCoreThreadWatchdog(handler);
            (new Thread(sInstance, "WebCoreThreadWatchdog")).start();
        }
        webcorethreadwatchdog = sInstance;
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorexit ;
        return webcorethreadwatchdog;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method unregisterWebView is deprecated
     */

    public static void unregisterWebView(WebViewClassic webviewclassic) {
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorenter ;
        if(sInstance != null)
            sInstance.removeWebView(webviewclassic);
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void run() {
        Looper.prepare();
        createHandler();
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorenter ;
        if(!mPaused) {
            mWebCoreThreadHandler.obtainMessage(197, mHandler.obtainMessage(100)).sendToTarget();
            mHandler.sendMessageDelayed(mHandler.obtainMessage(101), 30000L);
        }
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorexit ;
        Looper.loop();
        return;
        Exception exception;
        exception;
        android/webkit/WebCoreThreadWatchdog;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static final int HEARTBEAT_PERIOD = 10000;
    private static final int IS_ALIVE = 100;
    private static final int SUBSEQUENT_TIMEOUT_PERIOD = 15000;
    private static final int TIMED_OUT = 101;
    private static final int TIMEOUT_PERIOD = 30000;
    private static WebCoreThreadWatchdog sInstance;
    private Handler mHandler;
    private boolean mPaused;
    private Handler mWebCoreThreadHandler;
    private Set mWebViews;




}
