// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import java.util.ArrayList;
import java.util.List;

public class EncoderCapabilities {
    public static class AudioEncoderCap {

        public final int mCodec;
        public final int mMaxBitRate;
        public final int mMaxChannels;
        public final int mMaxSampleRate;
        public final int mMinBitRate;
        public final int mMinChannels;
        public final int mMinSampleRate;

        private AudioEncoderCap(int i, int j, int k, int l, int i1, int j1, int k1) {
            mCodec = i;
            mMinBitRate = j;
            mMaxBitRate = k;
            mMinSampleRate = l;
            mMaxSampleRate = i1;
            mMinChannels = j1;
            mMaxChannels = k1;
        }
    }

    public static class VideoEncoderCap {

        public final int mCodec;
        public final int mMaxBitRate;
        public final int mMaxFrameHeight;
        public final int mMaxFrameRate;
        public final int mMaxFrameWidth;
        public final int mMinBitRate;
        public final int mMinFrameHeight;
        public final int mMinFrameRate;
        public final int mMinFrameWidth;

        private VideoEncoderCap(int i, int j, int k, int l, int i1, int j1, int k1, 
                int l1, int i2) {
            mCodec = i;
            mMinBitRate = j;
            mMaxBitRate = k;
            mMinFrameRate = l;
            mMaxFrameRate = i1;
            mMinFrameWidth = j1;
            mMaxFrameWidth = k1;
            mMinFrameHeight = l1;
            mMaxFrameHeight = i2;
        }
    }


    private EncoderCapabilities() {
    }

    public static List getAudioEncoders() {
        int i = native_get_num_audio_encoders();
        Object obj;
        if(i == 0) {
            obj = null;
        } else {
            obj = new ArrayList();
            int j = 0;
            while(j < i)  {
                ((List) (obj)).add(native_get_audio_encoder_cap(j));
                j++;
            }
        }
        return ((List) (obj));
    }

    public static int[] getOutputFileFormats() {
        int i = native_get_num_file_formats();
        int ai[];
        if(i == 0) {
            ai = null;
        } else {
            ai = new int[i];
            int j = 0;
            while(j < i)  {
                ai[j] = native_get_file_format(j);
                j++;
            }
        }
        return ai;
    }

    public static List getVideoEncoders() {
        int i = native_get_num_video_encoders();
        Object obj;
        if(i == 0) {
            obj = null;
        } else {
            obj = new ArrayList();
            int j = 0;
            while(j < i)  {
                ((List) (obj)).add(native_get_video_encoder_cap(j));
                j++;
            }
        }
        return ((List) (obj));
    }

    private static final native AudioEncoderCap native_get_audio_encoder_cap(int i);

    private static final native int native_get_file_format(int i);

    private static final native int native_get_num_audio_encoders();

    private static final native int native_get_num_file_formats();

    private static final native int native_get_num_video_encoders();

    private static final native VideoEncoderCap native_get_video_encoder_cap(int i);

    private static final native void native_init();

    private static final String TAG = "EncoderCapabilities";

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }
}
