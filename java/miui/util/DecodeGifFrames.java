// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.os.*;

// Referenced classes of package miui.util:
//            DecodeGifImageHelper, InputStreamLoader

class DecodeGifFrames extends Handler {

    public DecodeGifFrames(HandlerThread handlerthread, InputStreamLoader inputstreamloader, long l, Handler handler) {
        super(handlerthread.getLooper());
        mDecodeResult = null;
        mHandlerThread = handlerthread;
        mMaxDecodeSize = l;
        mGifSource = inputstreamloader;
        mCallerHandler = handler;
    }

    public static DecodeGifFrames createInstance(InputStreamLoader inputstreamloader, long l, Handler handler) {
        HandlerThread handlerthread = new HandlerThread("handler thread to decode GIF frames");
        handlerthread.start();
        return new DecodeGifFrames(handlerthread, inputstreamloader, l, handler);
    }

    public void decode(int i) {
        if(mDecodeResult == null) {
            mDecodeResult = new DecodeGifImageHelper.GifDecodeResult();
            sendMessage(obtainMessage(1, i, 0));
        }
    }

    public void destroy() {
        mHandlerThread.quit();
    }

    protected void finalize() throws Throwable {
        mHandlerThread.quit();
        super.finalize();
    }

    public DecodeGifImageHelper.GifDecodeResult getAndClearDecodeResult() {
        DecodeGifImageHelper.GifDecodeResult gifdecoderesult = mDecodeResult;
        mDecodeResult = null;
        return gifdecoderesult;
    }

    public void handleMessage(Message message) {
        if(message.what == 1) {
            int i = message.arg1;
            DecodeGifImageHelper.GifDecodeResult gifdecoderesult = DecodeGifImageHelper.decode(mGifSource, mMaxDecodeSize, i);
            mDecodeResult.mGifDecoder = gifdecoderesult.mGifDecoder;
            mDecodeResult.mIsDecodeOk = gifdecoderesult.mIsDecodeOk;
            mCallerHandler.sendEmptyMessage(1);
        }
    }

    private static final int MESSAGE_WHAT_START = 1;
    protected static final String TAG = "DecodeGifFrames";
    private Handler mCallerHandler;
    DecodeGifImageHelper.GifDecodeResult mDecodeResult;
    private InputStreamLoader mGifSource;
    HandlerThread mHandlerThread;
    private long mMaxDecodeSize;
}
