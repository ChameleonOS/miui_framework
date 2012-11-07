// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import java.util.List;
import miui.util.*;

// Referenced classes of package android.graphics.drawable:
//            AnimationDrawable, BitmapDrawable

public class GifAnimationDrawable extends AnimationDrawable {

    public GifAnimationDrawable() {
    }

    private boolean handleFirstDecodeResult(miui.util.DecodeGifImageHelper.GifDecodeResult gifdecoderesult) {
        boolean flag = false;
        if(gifdecoderesult.mGifDecoder != null && gifdecoderesult.mIsDecodeOk) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        GifDecoder gifdecoder = gifdecoderesult.mGifDecoder;
        mHelper.mDecodedAllFrames = gifdecoder.isDecodeToTheEnd();
        int i = gifdecoder.getFrameCount();
        if(i > 0) {
            int j = 0;
            while(j < i)  {
                if(mHelper.mDecodedAllFrames) {
                    addFrame(new BitmapDrawable(mResources, gifdecoder.getFrame(j)), gifdecoder.getDelay(j));
                } else {
                    android.graphics.Bitmap bitmap = gifdecoder.getFrame(j);
                    int k = gifdecoder.getDelay(j);
                    mHelper.mFrames.add(new miui.util.DecodeGifImageHelper.GifFrame(bitmap, k, j));
                }
                j++;
            }
            if(!mHelper.mDecodedAllFrames) {
                mHelper.firstDecodeNextFrames();
                miui.util.DecodeGifImageHelper.GifFrame gifframe = (miui.util.DecodeGifImageHelper.GifFrame)mHelper.mFrames.get(0);
                BitmapDrawable bitmapdrawable = new BitmapDrawable(mResources, gifframe.mImage);
                addFrame(bitmapdrawable, gifframe.mDuration);
                addFrame(bitmapdrawable, gifframe.mDuration);
            }
            setOneShot(false);
            super.selectDrawable(0);
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean internalLoad(Resources resources, InputStreamLoader inputstreamloader) {
        mResources = resources;
        mHelper.mGifSource = inputstreamloader;
        return handleFirstDecodeResult(mHelper.decodeFrom(0));
    }

    public boolean load(Resources resources, Context context, Uri uri) {
        return internalLoad(resources, new InputStreamLoader(context, uri));
    }

    public boolean load(Resources resources, String s) {
        return internalLoad(resources, new InputStreamLoader(s));
    }

    public boolean load(Resources resources, byte abyte0[]) {
        return internalLoad(resources, new InputStreamLoader(abyte0));
    }

    public void preSelectDrawable(int i) {
        if(!mHelper.mFrames.isEmpty()) {
            miui.util.DecodeGifImageHelper.GifFrame gifframe = (miui.util.DecodeGifImageHelper.GifFrame)mHelper.mFrames.get(0);
            if(mHelper.mFrames.size() > 1)
                mHelper.mFrames.remove(0);
            mHelper.decodeNextFrames();
            BitmapDrawable bitmapdrawable = new BitmapDrawable(mResources, gifframe.mImage);
            getAnimationState().mDrawables[i] = bitmapdrawable;
            getAnimationState().setDuration(i, gifframe.mDuration);
        }
    }

    public boolean selectDrawable(int i) {
        preSelectDrawable(i);
        return super.selectDrawable(i);
    }

    public void setMaxDecodeSize(long l) {
        mHelper.mMaxDecodeSize = l;
    }

    private final DecodeGifImageHelper mHelper = new DecodeGifImageHelper();
    private Resources mResources;
}
