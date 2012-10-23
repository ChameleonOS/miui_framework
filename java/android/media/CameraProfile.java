// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.hardware.Camera;
import java.util.Arrays;
import java.util.HashMap;

public class CameraProfile {

    public CameraProfile() {
    }

    private static int[] getImageEncodingQualityLevels(int i) {
        int j = native_get_num_image_encoding_quality_levels(i);
        if(j != 3)
            throw new RuntimeException((new StringBuilder()).append("Unexpected Jpeg encoding quality levels ").append(j).toString());
        int ai[] = new int[j];
        for(int k = 0; k < j; k++)
            ai[k] = native_get_image_encoding_quality_level(i, k);

        Arrays.sort(ai);
        return ai;
    }

    public static int getJpegEncodingQualityParameter(int i) {
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
        int l = getJpegEncodingQualityParameter(k, i);
_L4:
        return l;
_L2:
        k++;
          goto _L3
        l = 0;
          goto _L4
    }

    public static int getJpegEncodingQualityParameter(int i, int j) {
        if(j < 0 || j > 2)
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported quality level: ").append(j).toString());
        HashMap hashmap = sCache;
        hashmap;
        JVM INSTR monitorenter ;
        int ai[] = (int[])sCache.get(Integer.valueOf(i));
        if(ai == null) {
            ai = getImageEncodingQualityLevels(i);
            sCache.put(Integer.valueOf(i), ai);
        }
        int k = ai[j];
        return k;
    }

    private static final native int native_get_image_encoding_quality_level(int i, int j);

    private static final native int native_get_num_image_encoding_quality_levels(int i);

    private static final native void native_init();

    public static final int QUALITY_HIGH = 2;
    public static final int QUALITY_LOW = 0;
    public static final int QUALITY_MEDIUM = 1;
    private static final HashMap sCache = new HashMap();

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }
}
