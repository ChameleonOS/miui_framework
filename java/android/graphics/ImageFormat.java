// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


public class ImageFormat {

    public ImageFormat() {
    }

    public static int getBitsPerPixel(int i) {
        byte byte0 = 16;
        i;
        JVM INSTR lookupswitch 6: default 64
    //                   4: 67
    //                   16: 67
    //                   17: 75
    //                   20: 67
    //                   512: 67
    //                   842094169: 69;
           goto _L1 _L2 _L2 _L3 _L2 _L2 _L4
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        byte0 = -1;
_L6:
        return byte0;
_L4:
        byte0 = 12;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 12;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static final int BAYER_RGGB = 512;
    public static final int JPEG = 256;
    public static final int NV16 = 16;
    public static final int NV21 = 17;
    public static final int RGB_565 = 4;
    public static final int UNKNOWN = 0;
    public static final int YUY2 = 20;
    public static final int YV12 = 0x32315659;
}
