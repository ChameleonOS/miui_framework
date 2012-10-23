// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.hardware.Camera;

public class CamcorderProfile {

    private CamcorderProfile(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, int k2, int l2) {
        duration = i;
        quality = j;
        fileFormat = k;
        videoCodec = l;
        videoBitRate = i1;
        videoFrameRate = j1;
        videoFrameWidth = k1;
        videoFrameHeight = l1;
        audioCodec = i2;
        audioBitRate = j2;
        audioSampleRate = k2;
        audioChannels = l2;
    }

    public static CamcorderProfile get(int i) {
        int j;
        android.hardware.Camera.CameraInfo camerainfo;
        int k;
        j = Camera.getNumberOfCameras();
        camerainfo = new android.hardware.Camera.CameraInfo();
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_47;
        Camera.getCameraInfo(k, camerainfo);
        if(camerainfo.facing != 0) goto _L2; else goto _L1
_L1:
        CamcorderProfile camcorderprofile = get(k, i);
_L4:
        return camcorderprofile;
_L2:
        k++;
          goto _L3
        camcorderprofile = null;
          goto _L4
    }

    public static CamcorderProfile get(int i, int j) {
        if((j < 0 || j > 7) && (j < 1000 || j > 1007))
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported quality level: ").append(j).toString());
        else
            return native_get_camcorder_profile(i, j);
    }

    public static boolean hasProfile(int i) {
        int j;
        android.hardware.Camera.CameraInfo camerainfo;
        int k;
        j = Camera.getNumberOfCameras();
        camerainfo = new android.hardware.Camera.CameraInfo();
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_47;
        Camera.getCameraInfo(k, camerainfo);
        if(camerainfo.facing != 0) goto _L2; else goto _L1
_L1:
        boolean flag = hasProfile(k, i);
_L4:
        return flag;
_L2:
        k++;
          goto _L3
        flag = false;
          goto _L4
    }

    public static boolean hasProfile(int i, int j) {
        return native_has_camcorder_profile(i, j);
    }

    private static final native CamcorderProfile native_get_camcorder_profile(int i, int j);

    private static final native boolean native_has_camcorder_profile(int i, int j);

    private static final native void native_init();

    public static final int QUALITY_1080P = 6;
    public static final int QUALITY_480P = 4;
    public static final int QUALITY_720P = 5;
    public static final int QUALITY_CIF = 3;
    public static final int QUALITY_HIGH = 1;
    private static final int QUALITY_LIST_END = 7;
    private static final int QUALITY_LIST_START = 0;
    public static final int QUALITY_LOW = 0;
    public static final int QUALITY_QCIF = 2;
    public static final int QUALITY_QVGA = 7;
    public static final int QUALITY_TIME_LAPSE_1080P = 1006;
    public static final int QUALITY_TIME_LAPSE_480P = 1004;
    public static final int QUALITY_TIME_LAPSE_720P = 1005;
    public static final int QUALITY_TIME_LAPSE_CIF = 1003;
    public static final int QUALITY_TIME_LAPSE_HIGH = 1001;
    private static final int QUALITY_TIME_LAPSE_LIST_END = 1007;
    private static final int QUALITY_TIME_LAPSE_LIST_START = 1000;
    public static final int QUALITY_TIME_LAPSE_LOW = 1000;
    public static final int QUALITY_TIME_LAPSE_QCIF = 1002;
    public static final int QUALITY_TIME_LAPSE_QVGA = 1007;
    public int audioBitRate;
    public int audioChannels;
    public int audioCodec;
    public int audioSampleRate;
    public int duration;
    public int fileFormat;
    public int quality;
    public int videoBitRate;
    public int videoCodec;
    public int videoFrameHeight;
    public int videoFrameRate;
    public int videoFrameWidth;

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }
}
