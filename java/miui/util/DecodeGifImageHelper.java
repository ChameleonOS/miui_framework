// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.graphics.Bitmap;
import android.os.*;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package miui.util:
//            InputStreamLoader, GifDecoder, DecodeGifFrames

public class DecodeGifImageHelper {
    public static class GifFrame {

        public int mDuration;
        public Bitmap mImage;
        public int mIndex;

        public GifFrame(Bitmap bitmap, int i, int j) {
            mImage = bitmap;
            mDuration = i;
            mIndex = j;
        }
    }

    public static class GifDecodeResult {

        public GifDecoder mGifDecoder;
        public boolean mIsDecodeOk;

        public GifDecodeResult() {
        }
    }


    public DecodeGifImageHelper() {
        mMaxDecodeSize = 0x100000L;
        mFrames = new ArrayList();
        mMaxFrames = 0;
        mRealFrameCount = 0;
        mDecodedAllFrames = false;
    }

    private int calcFrameIndex(int i) {
        if(mRealFrameCount != 0)
            i %= mRealFrameCount;
        return i;
    }

    public static GifDecodeResult decode(InputStreamLoader inputstreamloader, long l, int i) {
        boolean flag = false;
        GifDecodeResult gifdecoderesult = new GifDecodeResult();
        gifdecoderesult.mGifDecoder = null;
        gifdecoderesult.mIsDecodeOk = false;
        java.io.InputStream inputstream = inputstreamloader.get();
        if(inputstream != null) {
            gifdecoderesult.mGifDecoder = new GifDecoder();
            GifDecoder gifdecoder = gifdecoderesult.mGifDecoder;
            gifdecoder.setStartFrame(i);
            gifdecoder.setMaxDecodeSize(l);
            if(gifdecoder.read(inputstream) == 0)
                flag = true;
            gifdecoderesult.mIsDecodeOk = flag;
        }
        inputstreamloader.close();
        return gifdecoderesult;
    }

    private int getLastFrameIndex() {
        return ((GifFrame)mFrames.get(-1 + mFrames.size())).mIndex;
    }

    public GifDecodeResult decodeFrom(int i) {
        return decode(mGifSource, mMaxDecodeSize, i);
    }

    public void decodeNextFrames() {
        int i = mFrames.size();
        boolean flag;
        if(mMaxFrames <= 3) {
            if(i <= 2)
                flag = true;
            else
                flag = false;
        } else
        if(i <= mMaxFrames / 2)
            flag = true;
        else
            flag = false;
        if(flag) {
            int j = calcFrameIndex(1 + getLastFrameIndex());
            mDecodeGifFrames.decode(j);
        }
    }

    public void destroy() {
        if(mDecodeGifFrames != null)
            mDecodeGifFrames.destroy();
    }

    public void firstDecodeNextFrames() {
        mDecodeFrameHandler = new Handler(Looper.getMainLooper()) {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 1 1: default 24
            //                           1 25;
                   goto _L1 _L2
_L1:
                return;
_L2:
                if(handleDecodeFramesResult(mDecodeGifFrames.getAndClearDecodeResult()))
                    decodeNextFrames();
                if(true) goto _L1; else goto _L3
_L3:
            }

            final DecodeGifImageHelper this$0;

             {
                this$0 = DecodeGifImageHelper.this;
                super(looper);
            }
        };
        mDecodeGifFrames = DecodeGifFrames.createInstance(mGifSource, mMaxDecodeSize, mDecodeFrameHandler);
        mMaxFrames = mFrames.size();
        decodeNextFrames();
    }

    public boolean handleDecodeFramesResult(GifDecodeResult gifdecoderesult) {
        boolean flag = true;
        if(gifdecoderesult.mIsDecodeOk && gifdecoderesult.mGifDecoder != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        GifDecoder gifdecoder = gifdecoderesult.mGifDecoder;
        Object aobj[] = new Object[4];
        aobj[0] = Long.valueOf(Thread.currentThread().getId());
        aobj[flag] = Integer.valueOf(gifdecoderesult.mGifDecoder.getFrameCount());
        aobj[2] = Boolean.valueOf(gifdecoderesult.mIsDecodeOk);
        aobj[3] = Integer.valueOf(mRealFrameCount);
        Log.d("dumpFrameIndex", String.format("Thread#%d: decoded %d frames [%s] [%d]", aobj));
        if(gifdecoder.isDecodeToTheEnd())
            mRealFrameCount = gifdecoder.getRealFrameCount();
        int i = gifdecoder.getFrameCount();
        if(i > 0) {
            int j = getLastFrameIndex();
            int k = 0;
            while(k < i)  {
                Bitmap bitmap = gifdecoder.getFrame(k);
                int l = gifdecoder.getDelay(k);
                int i1 = calcFrameIndex(k + (j + 1));
                mFrames.add(new GifFrame(bitmap, l, i1));
                k++;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final int MESSAGE_WHAT_DECODE_FRAMES = 1;
    public Handler mDecodeFrameHandler;
    private DecodeGifFrames mDecodeGifFrames;
    public boolean mDecodedAllFrames;
    public List mFrames;
    public InputStreamLoader mGifSource;
    public long mMaxDecodeSize;
    private int mMaxFrames;
    public int mRealFrameCount;

}
