// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.graphics.*;
import android.media.MediaPlayer;
import android.net.http.*;
import android.os.*;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebViewCore, WebChromeClient, HTML5VideoView, 
//            HTML5VideoFullScreen, HTML5VideoInline

class HTML5VideoViewProxy extends Handler
    implements android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.graphics.SurfaceTexture.OnFrameAvailableListener {
    private static final class PosterDownloader
        implements EventHandler {

        private void cleanup() {
            if(mPosterBytes != null) {
                Exception exception;
                try {
                    mPosterBytes.close();
                }
                catch(IOException ioexception) { }
                finally {
                    mPosterBytes = null;
                }
                mPosterBytes = null;
            }
            return;
            throw exception;
        }

        private void releaseQueue() {
            if(mQueueRefCount != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i = -1 + mQueueRefCount;
            mQueueRefCount = i;
            if(i == 0) {
                mRequestQueue.shutdown();
                mRequestQueue = null;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private void retainQueue() {
            if(mRequestQueue == null)
                mRequestQueue = new RequestQueue(mProxy.getContext());
            mQueueRefCount = 1 + mQueueRefCount;
        }

        public void cancelAndReleaseQueue() {
            if(mRequestHandle != null) {
                mRequestHandle.cancel();
                mRequestHandle = null;
            }
            releaseQueue();
        }

        public void certificate(SslCertificate sslcertificate) {
        }

        public void data(byte abyte0[], int i) {
            if(mPosterBytes == null)
                mPosterBytes = new ByteArrayOutputStream();
            mPosterBytes.write(abyte0, 0, i);
        }

        public void endData() {
            if(mStatusCode != 200) goto _L2; else goto _L1
_L1:
            if(mPosterBytes.size() > 0) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(mPosterBytes.toByteArray(), 0, mPosterBytes.size());
                mProxy.doSetPoster(bitmap);
            }
            cleanup();
_L4:
            return;
_L2:
            if(mStatusCode >= 300 && mStatusCode < 400) {
                try {
                    mUrl = new URL(mHeaders.getLocation());
                }
                catch(MalformedURLException malformedurlexception) {
                    mUrl = null;
                }
                if(mUrl != null)
                    mHandler.post(new Runnable() {

                        public void run() {
                            if(mRequestHandle != null)
                                mRequestHandle.setupRedirect(mUrl.toString(), mStatusCode, new HashMap());
                        }

                        final PosterDownloader this$0;

                 {
                    this$0 = PosterDownloader.this;
                    super();
                }
                    });
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void error(int i, String s) {
            cleanup();
        }

        public boolean handleSslErrorRequest(SslError sslerror) {
            return false;
        }

        public void headers(Headers headers1) {
            mHeaders = headers1;
        }

        public void start() {
            retainQueue();
            if(mUrl != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            String s = mUrl.getProtocol();
            if("http".equals(s) || "https".equals(s))
                mRequestHandle = mRequestQueue.queueRequest(mUrl.toString(), "GET", null, this, null, 0);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void status(int i, int j, int k, String s) {
            mStatusCode = k;
        }

        private static int mQueueRefCount = 0;
        private static RequestQueue mRequestQueue;
        private Handler mHandler;
        private Headers mHeaders;
        private ByteArrayOutputStream mPosterBytes;
        private final HTML5VideoViewProxy mProxy;
        private RequestHandle mRequestHandle;
        private int mStatusCode;
        private URL mUrl;





        public PosterDownloader(String s, HTML5VideoViewProxy html5videoviewproxy) {
            try {
                mUrl = new URL(s);
            }
            catch(MalformedURLException malformedurlexception) {
                mUrl = null;
            }
            mProxy = html5videoviewproxy;
            mHandler = new Handler();
        }
    }

    private static final class VideoPlayer {

        public static void end() {
            mHTML5VideoView.showControllerInFullScreen();
            if(mCurrentProxy != null)
                if(isVideoSelfEnded)
                    mCurrentProxy.dispatchOnEnded();
                else
                    mCurrentProxy.dispatchOnPaused();
            isVideoSelfEnded = false;
        }

        public static void enterFullScreenVideo(int i, String s, HTML5VideoViewProxy html5videoviewproxy, WebViewClassic webviewclassic) {
            int j;
            boolean flag;
            boolean flag1;
            j = 0;
            flag = false;
            flag1 = false;
            if(mHTML5VideoView == null) goto _L2; else goto _L1
_L1:
            if(mHTML5VideoView.fullScreenExited() || !mHTML5VideoView.isFullScreenMode()) goto _L4; else goto _L3
_L3:
            Log.w("HTML5VideoViewProxy", "Try to reenter the full screen mode");
_L6:
            return;
_L4:
            int k;
            k = mHTML5VideoView.getCurrentState();
            if(i == mHTML5VideoView.getVideoLayerId()) {
                j = mHTML5VideoView.getCurrentPosition();
                if((k == 1 || k == 2 || k == 3) && !mHTML5VideoView.isFullScreenMode())
                    flag = true;
                else
                    flag = false;
            }
            if(flag)
                break; /* Loop/switch isn't completed */
            mHTML5VideoView.reset();
_L2:
            mHTML5VideoView = new HTML5VideoFullScreen(html5videoviewproxy.getContext(), i, j, flag);
            mHTML5VideoView.setStartWhenPrepared(flag1);
            mCurrentProxy = html5videoviewproxy;
            mHTML5VideoView.setVideoURI(s, mCurrentProxy);
            mHTML5VideoView.enterFullScreenVideoState(i, html5videoviewproxy, webviewclassic);
            if(true) goto _L6; else goto _L5
_L5:
            if(k == 1 || k == 3)
                flag1 = true;
            else
                flag1 = false;
              goto _L2
            if(true) goto _L6; else goto _L7
_L7:
        }

        public static void exitFullScreenVideo(HTML5VideoViewProxy html5videoviewproxy, WebViewClassic webviewclassic) {
            if(!mHTML5VideoView.fullScreenExited() && mHTML5VideoView.isFullScreenMode()) {
                WebChromeClient webchromeclient = webviewclassic.getWebChromeClient();
                if(webchromeclient != null)
                    webchromeclient.onHideCustomView();
            }
        }

        public static int getCurrentPosition() {
            int i = 0;
            if(mHTML5VideoView != null)
                i = mHTML5VideoView.getCurrentPosition();
            return i;
        }

        public static boolean isPlaying(HTML5VideoViewProxy html5videoviewproxy) {
            boolean flag;
            if(mCurrentProxy == html5videoviewproxy && mHTML5VideoView != null && mHTML5VideoView.isPlaying())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static void onPrepared() {
            if(!mHTML5VideoView.isFullScreenMode())
                mHTML5VideoView.start();
            if(mBaseLayer != 0)
                setBaseLayer(mBaseLayer);
        }

        public static void pause(HTML5VideoViewProxy html5videoviewproxy) {
            if(mCurrentProxy == html5videoviewproxy && mHTML5VideoView != null)
                mHTML5VideoView.pause();
        }

        public static void pauseAndDispatch() {
            if(mHTML5VideoView != null) {
                mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                setBaseLayer(mBaseLayer);
            }
        }

        public static void play(String s, int i, HTML5VideoViewProxy html5videoviewproxy, WebChromeClient webchromeclient, int j) {
            int k;
            boolean flag;
            k = -1;
            flag = false;
            if(mHTML5VideoView == null) goto _L2; else goto _L1
_L1:
            k = mHTML5VideoView.getVideoLayerId();
            flag = mHTML5VideoView.fullScreenExited();
            if(!mHTML5VideoView.isFullScreenMode() || flag || k == j || mCurrentProxy == html5videoviewproxy) goto _L2; else goto _L3
_L3:
            mCurrentProxy = html5videoviewproxy;
            mHTML5VideoView.setStartWhenPrepared(true);
            mHTML5VideoView.setVideoURI(s, html5videoviewproxy);
            mHTML5VideoView.reprepareData(html5videoviewproxy);
_L5:
            return;
_L2:
            if(flag || k != j || mHTML5VideoView.surfaceTextureDeleted()) {
                if(mHTML5VideoView != null) {
                    if(!flag)
                        mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                    mHTML5VideoView.reset();
                }
                mCurrentProxy = html5videoviewproxy;
                mHTML5VideoView = new HTML5VideoInline(j, i);
                mHTML5VideoView.setVideoURI(s, mCurrentProxy);
                mHTML5VideoView.prepareDataAndDisplayMode(html5videoviewproxy);
            } else
            if(mCurrentProxy == html5videoviewproxy) {
                if(!mHTML5VideoView.isPlaying()) {
                    mHTML5VideoView.seekTo(i);
                    mHTML5VideoView.start();
                }
            } else
            if(mCurrentProxy != null)
                html5videoviewproxy.dispatchOnEnded();
            if(true) goto _L5; else goto _L4
_L4:
        }

        public static void seek(int i, HTML5VideoViewProxy html5videoviewproxy) {
            if(mCurrentProxy == html5videoviewproxy && i >= 0 && mHTML5VideoView != null)
                mHTML5VideoView.seekTo(i);
        }

        public static void setBaseLayer(int i) {
            if(mHTML5VideoView != null && !mHTML5VideoView.isFullScreenMode() && !mHTML5VideoView.surfaceTextureDeleted()) {
                mBaseLayer = i;
                int j = mHTML5VideoView.getVideoLayerId();
                SurfaceTexture surfacetexture = HTML5VideoInline.getSurfaceTexture(j);
                int k = mHTML5VideoView.getTextureName();
                if(i != 0 && surfacetexture != null && j != -1) {
                    int l = mHTML5VideoView.getCurrentState();
                    if(mHTML5VideoView.getPlayerBuffering())
                        l = 1;
                    boolean flag = HTML5VideoViewProxy.nativeSendSurfaceTexture(surfacetexture, i, j, k, l);
                    if(l >= 2 && !flag) {
                        mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                        mHTML5VideoView.deleteSurfaceTexture();
                    }
                }
            }
        }

        private static void setPlayerBuffering(boolean flag) {
            mHTML5VideoView.setPlayerBuffering(flag);
        }

        private static boolean isVideoSelfEnded = false;
        private static int mBaseLayer = 0;
        private static HTML5VideoViewProxy mCurrentProxy;
        private static HTML5VideoView mHTML5VideoView;



/*
        static boolean access$102(boolean flag) {
            isVideoSelfEnded = flag;
            return flag;
        }

*/


        private VideoPlayer() {
        }
    }


    private HTML5VideoViewProxy(WebViewClassic webviewclassic, int i) {
        super(Looper.getMainLooper());
        mWebView = webviewclassic;
        mWebView.setHTML5VideoViewProxy(this);
        mNativePointer = i;
        createWebCoreHandler();
    }

    private void createWebCoreHandler() {
        mWebCoreHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR lookupswitch 7: default 72
            //                           200: 73
            //                           201: 156
            //                           202: 199
            //                           203: 182
            //                           204: 246
            //                           205: 263
            //                           300: 225;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
                return;
_L2:
                Map map = (Map)message.obj;
                Integer integer = (Integer)map.get("dur");
                Integer integer1 = (Integer)map.get("width");
                Integer integer2 = (Integer)map.get("height");
                nativeOnPrepared(integer.intValue(), integer1.intValue(), integer2.intValue(), mNativePointer);
                continue; /* Loop/switch isn't completed */
_L3:
                mSeekPosition = 0;
                nativeOnEnded(mNativePointer);
                continue; /* Loop/switch isn't completed */
_L5:
                nativeOnPaused(mNativePointer);
                continue; /* Loop/switch isn't completed */
_L4:
                Bitmap bitmap = (Bitmap)message.obj;
                nativeOnPosterFetched(bitmap, mNativePointer);
                continue; /* Loop/switch isn't completed */
_L8:
                nativeOnTimeupdate(message.arg1, mNativePointer);
                continue; /* Loop/switch isn't completed */
_L6:
                nativeOnStopFullscreen(mNativePointer);
                continue; /* Loop/switch isn't completed */
_L7:
                nativeOnRestoreState(mNativePointer);
                if(true) goto _L1; else goto _L9
_L9:
            }

            final HTML5VideoViewProxy this$0;

             {
                this$0 = HTML5VideoViewProxy.this;
                super();
            }
        };
    }

    private void doSetPoster(Bitmap bitmap) {
        if(bitmap != null) {
            mPoster = bitmap;
            Message message = Message.obtain(mWebCoreHandler, 202);
            message.obj = bitmap;
            mWebCoreHandler.sendMessage(message);
        }
    }

    public static HTML5VideoViewProxy getInstance(WebViewCore webviewcore, int i) {
        return new HTML5VideoViewProxy(webviewcore.getWebViewClassic(), i);
    }

    private native void nativeOnEnded(int i);

    private native void nativeOnPaused(int i);

    private native void nativeOnPosterFetched(Bitmap bitmap, int i);

    private native void nativeOnPrepared(int i, int j, int k, int l);

    private native void nativeOnRestoreState(int i);

    private native void nativeOnStopFullscreen(int i);

    private native void nativeOnTimeupdate(int i, int j);

    private static native boolean nativeSendSurfaceTexture(SurfaceTexture surfacetexture, int i, int j, int k, int l);

    private void sendTimeupdate() {
        Message message = Message.obtain(mWebCoreHandler, 300);
        message.arg1 = VideoPlayer.getCurrentPosition();
        mWebCoreHandler.sendMessage(message);
    }

    public void dispatchOnEnded() {
        Message message = Message.obtain(mWebCoreHandler, 201);
        mWebCoreHandler.sendMessage(message);
    }

    public void dispatchOnPaused() {
        Message message = Message.obtain(mWebCoreHandler, 203);
        mWebCoreHandler.sendMessage(message);
    }

    public void dispatchOnRestoreState() {
        Message message = Message.obtain(mWebCoreHandler, 205);
        mWebCoreHandler.sendMessage(message);
    }

    public void dispatchOnStopFullScreen() {
        Message message = Message.obtain(mWebCoreHandler, 204);
        mWebCoreHandler.sendMessage(message);
    }

    public void enterFullScreenVideo(int i, String s) {
        VideoPlayer.enterFullScreenVideo(i, s, this, mWebView);
    }

    public void exitFullScreenVideo() {
        VideoPlayer.exitFullScreenVideo(this, mWebView);
    }

    public Context getContext() {
        return mWebView.getContext();
    }

    WebViewClassic getWebView() {
        return mWebView;
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR lookupswitch 9: default 88
    //                   100: 89
    //                   101: 135
    //                   102: 160
    //                   103: 186
    //                   104: 205
    //                   105: 242
    //                   106: 249
    //                   201: 167
    //                   300: 228;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        return;
_L2:
        String s = (String)message.obj;
        WebChromeClient webchromeclient2 = mWebView.getWebChromeClient();
        int i = message.arg1;
        if(webchromeclient2 != null)
            VideoPlayer.play(s, mSeekPosition, this, webchromeclient2, i);
        continue; /* Loop/switch isn't completed */
_L3:
        mSeekPosition = ((Integer)message.obj).intValue();
        VideoPlayer.seek(mSeekPosition, this);
        continue; /* Loop/switch isn't completed */
_L4:
        VideoPlayer.pause(this);
        continue; /* Loop/switch isn't completed */
_L9:
        if(message.arg1 == 1)
            VideoPlayer.isVideoSelfEnded = true;
        VideoPlayer.end();
        continue; /* Loop/switch isn't completed */
_L5:
        WebChromeClient webchromeclient1 = mWebView.getWebChromeClient();
        if(webchromeclient1 != null)
            webchromeclient1.onHideCustomView();
        continue; /* Loop/switch isn't completed */
_L6:
        WebChromeClient webchromeclient = mWebView.getWebChromeClient();
        if(webchromeclient != null)
            doSetPoster(webchromeclient.getDefaultVideoPoster());
        continue; /* Loop/switch isn't completed */
_L10:
        if(VideoPlayer.isPlaying(this))
            sendTimeupdate();
        continue; /* Loop/switch isn't completed */
_L7:
        VideoPlayer.setPlayerBuffering(true);
        continue; /* Loop/switch isn't completed */
_L8:
        VideoPlayer.setPlayerBuffering(false);
        if(true) goto _L1; else goto _L11
_L11:
    }

    public void loadPoster(String s) {
        if(s == null) {
            sendMessage(obtainMessage(104));
        } else {
            if(mPosterDownloader != null)
                mPosterDownloader.cancelAndReleaseQueue();
            mPosterDownloader = new PosterDownloader(s, this);
            mPosterDownloader.start();
        }
    }

    public void onCompletion(MediaPlayer mediaplayer) {
        sendMessage(obtainMessage(201, 1, 0));
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j) {
        sendMessage(obtainMessage(103));
        return false;
    }

    public void onFrameAvailable(SurfaceTexture surfacetexture) {
        mWebView.invalidate();
    }

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j) {
        if(i != 701) goto _L2; else goto _L1
_L1:
        sendMessage(obtainMessage(105, i, j));
_L4:
        return false;
_L2:
        if(i == 702)
            sendMessage(obtainMessage(106, i, j));
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onPrepared(MediaPlayer mediaplayer) {
        VideoPlayer.onPrepared();
        Message message = Message.obtain(mWebCoreHandler, 200);
        HashMap hashmap = new HashMap();
        hashmap.put("dur", new Integer(mediaplayer.getDuration()));
        hashmap.put("width", new Integer(mediaplayer.getVideoWidth()));
        hashmap.put("height", new Integer(mediaplayer.getVideoHeight()));
        message.obj = hashmap;
        mWebCoreHandler.sendMessage(message);
    }

    public void onTimeupdate() {
        sendMessage(obtainMessage(300));
    }

    public void pause() {
        sendMessage(obtainMessage(102));
    }

    public void pauseAndDispatch() {
        VideoPlayer.pauseAndDispatch();
    }

    public void play(String s, int i, int j) {
        if(s != null) {
            if(i > 0)
                seek(i);
            Message message = obtainMessage(100);
            message.arg1 = j;
            message.obj = s;
            sendMessage(message);
        }
    }

    public void seek(int i) {
        Message message = obtainMessage(101);
        message.obj = new Integer(i);
        sendMessage(message);
    }

    public void setBaseLayer(int i) {
        VideoPlayer.setBaseLayer(i);
    }

    public void teardown() {
        if(mPosterDownloader != null)
            mPosterDownloader.cancelAndReleaseQueue();
        mNativePointer = 0;
    }

    private static final int BUFFERING_END = 106;
    private static final int BUFFERING_START = 105;
    private static final int ENDED = 201;
    private static final int ERROR = 103;
    private static final int LOAD_DEFAULT_POSTER = 104;
    private static final String LOGTAG = "HTML5VideoViewProxy";
    private static final int PAUSE = 102;
    private static final int PAUSED = 203;
    private static final int PLAY = 100;
    private static final int POSTER_FETCHED = 202;
    private static final int PREPARED = 200;
    private static final int RESTORESTATE = 205;
    private static final int SEEK = 101;
    private static final int STOPFULLSCREEN = 204;
    private static final int TIMEUPDATE = 300;
    int mNativePointer;
    private Bitmap mPoster;
    private PosterDownloader mPosterDownloader;
    private int mSeekPosition;
    private Handler mWebCoreHandler;
    private WebViewClassic mWebView;










/*
    static int access$802(HTML5VideoViewProxy html5videoviewproxy, int i) {
        html5videoviewproxy.mSeekPosition = i;
        return i;
    }

*/

}
