// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.*;

// Referenced classes of package android.media:
//            MediaFormat, MediaCrypto

public final class MediaCodec {
    public static final class CryptoInfo {

        public void set(int i, int ai[], int ai1[], byte abyte0[], byte abyte1[], int j) {
            numSubSamples = i;
            numBytesOfClearData = ai;
            numBytesOfEncryptedData = ai1;
            key = abyte0;
            iv = abyte1;
            mode = j;
        }

        public byte iv[];
        public byte key[];
        public int mode;
        public int numBytesOfClearData[];
        public int numBytesOfEncryptedData[];
        public int numSubSamples;

        public CryptoInfo() {
        }
    }

    public static final class CryptoException extends RuntimeException {

        public int getErrorCode() {
            return mErrorCode;
        }

        private int mErrorCode;

        public CryptoException(int i, String s) {
            super(s);
            mErrorCode = i;
        }
    }

    public static final class BufferInfo {

        public void set(int i, int j, long l, int k) {
            offset = i;
            size = j;
            presentationTimeUs = l;
            flags = k;
        }

        public int flags;
        public int offset;
        public long presentationTimeUs;
        public int size;

        public BufferInfo() {
        }
    }


    private MediaCodec(String s, boolean flag, boolean flag1) {
        native_setup(s, flag, flag1);
    }

    public static MediaCodec createByCodecName(String s) {
        return new MediaCodec(s, false, false);
    }

    public static MediaCodec createDecoderByType(String s) {
        return new MediaCodec(s, true, false);
    }

    public static MediaCodec createEncoderByType(String s) {
        return new MediaCodec(s, true, true);
    }

    private final native ByteBuffer[] getBuffers(boolean flag);

    private final native Map getOutputFormatNative();

    private final native void native_configure(String as[], Object aobj[], Surface surface, MediaCrypto mediacrypto, int i);

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(String s, boolean flag, boolean flag1);

    public void configure(MediaFormat mediaformat, Surface surface, MediaCrypto mediacrypto, int i) {
        Map map = mediaformat.getMap();
        String as[] = null;
        Object aobj[] = null;
        if(mediaformat != null) {
            as = new String[map.size()];
            aobj = new Object[map.size()];
            int j = 0;
            for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                as[j] = (String)entry.getKey();
                aobj[j] = entry.getValue();
                j++;
            }

        }
        native_configure(as, aobj, surface, mediacrypto, i);
    }

    public final native int dequeueInputBuffer(long l);

    public final native int dequeueOutputBuffer(BufferInfo bufferinfo, long l);

    protected void finalize() {
        native_finalize();
    }

    public final native void flush();

    public ByteBuffer[] getInputBuffers() {
        return getBuffers(true);
    }

    public ByteBuffer[] getOutputBuffers() {
        return getBuffers(false);
    }

    public final MediaFormat getOutputFormat() {
        return new MediaFormat(getOutputFormatNative());
    }

    public final native void queueInputBuffer(int i, int j, int k, long l, int i1) throws CryptoException;

    public final native void queueSecureInputBuffer(int i, int j, CryptoInfo cryptoinfo, long l, int k) throws CryptoException;

    public final native void release();

    public final native void releaseOutputBuffer(int i, boolean flag);

    public final native void setVideoScalingMode(int i);

    public final native void start();

    public final native void stop();

    public static final int BUFFER_FLAG_CODEC_CONFIG = 2;
    public static final int BUFFER_FLAG_END_OF_STREAM = 4;
    public static final int BUFFER_FLAG_SYNC_FRAME = 1;
    public static final int CONFIGURE_FLAG_ENCODE = 1;
    public static final int CRYPTO_MODE_AES_CTR = 1;
    public static final int CRYPTO_MODE_UNENCRYPTED = 0;
    public static final int INFO_OUTPUT_BUFFERS_CHANGED = -3;
    public static final int INFO_OUTPUT_FORMAT_CHANGED = -2;
    public static final int INFO_TRY_AGAIN_LATER = -1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    private int mNativeContext;

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }
}
