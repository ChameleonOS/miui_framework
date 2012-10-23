// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;


// Referenced classes of package android.media:
//            MediaCodecInfo

public final class MediaCodecList {

    private MediaCodecList() {
    }

    static final native MediaCodecInfo.CodecCapabilities getCodecCapabilities(int i, String s);

    public static final native int getCodecCount();

    public static final MediaCodecInfo getCodecInfoAt(int i) {
        if(i < 0 || i > getCodecCount())
            throw new IllegalArgumentException();
        else
            return new MediaCodecInfo(i);
    }

    static final native String getCodecName(int i);

    static final native String[] getSupportedTypes(int i);

    static final native boolean isEncoder(int i);

    private static final native void native_init();

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }
}
