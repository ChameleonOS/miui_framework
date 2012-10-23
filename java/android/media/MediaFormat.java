// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class MediaFormat {

    public MediaFormat() {
        mMap = new HashMap();
    }

    MediaFormat(Map map) {
        mMap = map;
    }

    public static final MediaFormat createAudioFormat(String s, int i, int j) {
        MediaFormat mediaformat = new MediaFormat();
        mediaformat.setString("mime", s);
        mediaformat.setInteger("sample-rate", i);
        mediaformat.setInteger("channel-count", j);
        return mediaformat;
    }

    public static final MediaFormat createVideoFormat(String s, int i, int j) {
        MediaFormat mediaformat = new MediaFormat();
        mediaformat.setString("mime", s);
        mediaformat.setInteger("width", i);
        mediaformat.setInteger("height", j);
        return mediaformat;
    }

    public final boolean containsKey(String s) {
        return mMap.containsKey(s);
    }

    public final ByteBuffer getByteBuffer(String s) {
        return (ByteBuffer)mMap.get(s);
    }

    public final float getFloat(String s) {
        return ((Float)mMap.get(s)).floatValue();
    }

    public final int getInteger(String s) {
        return ((Integer)mMap.get(s)).intValue();
    }

    public final long getLong(String s) {
        return ((Long)mMap.get(s)).longValue();
    }

    Map getMap() {
        return mMap;
    }

    public final String getString(String s) {
        return (String)mMap.get(s);
    }

    public final void setByteBuffer(String s, ByteBuffer bytebuffer) {
        mMap.put(s, bytebuffer);
    }

    public final void setFloat(String s, float f) {
        mMap.put(s, new Float(f));
    }

    public final void setInteger(String s, int i) {
        mMap.put(s, new Integer(i));
    }

    public final void setLong(String s, long l) {
        mMap.put(s, new Long(l));
    }

    public final void setString(String s, String s1) {
        mMap.put(s, s1);
    }

    public String toString() {
        return mMap.toString();
    }

    public static final String KEY_AAC_PROFILE = "aac-profile";
    public static final String KEY_BIT_RATE = "bitrate";
    public static final String KEY_CHANNEL_COUNT = "channel-count";
    public static final String KEY_CHANNEL_MASK = "channel-mask";
    public static final String KEY_COLOR_FORMAT = "color-format";
    public static final String KEY_DURATION = "durationUs";
    public static final String KEY_FLAC_COMPRESSION_LEVEL = "flac-compression-level";
    public static final String KEY_FRAME_RATE = "frame-rate";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_IS_ADTS = "is-adts";
    public static final String KEY_I_FRAME_INTERVAL = "i-frame-interval";
    public static final String KEY_MAX_INPUT_SIZE = "max-input-size";
    public static final String KEY_MIME = "mime";
    public static final String KEY_SAMPLE_RATE = "sample-rate";
    public static final String KEY_SLICE_HEIGHT = "slice-height";
    public static final String KEY_STRIDE = "stride";
    public static final String KEY_WIDTH = "width";
    private Map mMap;
}
