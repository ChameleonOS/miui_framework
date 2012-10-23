// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


public class PixelFormat {

    public PixelFormat() {
    }

    public static boolean formatHasAlpha(int i) {
        i;
        JVM INSTR tableswitch -3 10: default 72
    //                   -3 76
    //                   -2 76
    //                   -1 72
    //                   0 72
    //                   1 76
    //                   2 72
    //                   3 72
    //                   4 72
    //                   5 72
    //                   6 76
    //                   7 76
    //                   8 76
    //                   9 72
    //                   10 76;
           goto _L1 _L2 _L2 _L1 _L1 _L2 _L1 _L1 _L1 _L1 _L2 _L2 _L2 _L1 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static native void getPixelFormatInfo(int i, PixelFormat pixelformat);

    private static native void nativeClassInit();

    public static final int A_8 = 8;
    public static final int JPEG = 256;
    public static final int LA_88 = 10;
    public static final int L_8 = 9;
    public static final int OPAQUE = -1;
    public static final int RGBA_4444 = 7;
    public static final int RGBA_5551 = 6;
    public static final int RGBA_8888 = 1;
    public static final int RGBX_8888 = 2;
    public static final int RGB_332 = 11;
    public static final int RGB_565 = 4;
    public static final int RGB_888 = 3;
    public static final int TRANSLUCENT = -3;
    public static final int TRANSPARENT = -2;
    public static final int UNKNOWN = 0;
    public static final int YCbCr_420_SP = 17;
    public static final int YCbCr_422_I = 20;
    public static final int YCbCr_422_SP = 16;
    public int bitsPerPixel;
    public int bytesPerPixel;

    static  {
        nativeClassInit();
    }
}
