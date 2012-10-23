// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.util.MathUtils;
import java.util.HashMap;
import java.util.Locale;

public class Color {

    public Color() {
    }

    public static int HSBtoColor(float f, float f1, float f2) {
        float f5;
        float f6;
        float f7;
        float f8;
        int i;
        float f11;
        float f12;
        float f13;
        float f3 = MathUtils.constrain(f, 0.0F, 1.0F);
        float f4 = MathUtils.constrain(f1, 0.0F, 1.0F);
        f5 = MathUtils.constrain(f2, 0.0F, 1.0F);
        f6 = 0.0F;
        f7 = 0.0F;
        f8 = 0.0F;
        float f9 = 6F * (f3 - (float)(int)f3);
        i = (int)f9;
        float f10 = f9 - (float)i;
        f11 = f5 * (1.0F - f4);
        f12 = f5 * (1.0F - f4 * f10);
        f13 = f5 * (1.0F - f4 * (1.0F - f10));
        i;
        JVM INSTR tableswitch 0 5: default 132
    //                   0 162
    //                   1 177
    //                   2 192
    //                   3 207
    //                   4 222
    //                   5 237;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return 0xff000000 | (int)(f6 * 255F) << 16 | (int)(f7 * 255F) << 8 | (int)(f8 * 255F);
_L2:
        f6 = f5;
        f7 = f13;
        f8 = f11;
        continue; /* Loop/switch isn't completed */
_L3:
        f6 = f12;
        f7 = f5;
        f8 = f11;
        continue; /* Loop/switch isn't completed */
_L4:
        f6 = f11;
        f7 = f5;
        f8 = f13;
        continue; /* Loop/switch isn't completed */
_L5:
        f6 = f11;
        f7 = f12;
        f8 = f5;
        continue; /* Loop/switch isn't completed */
_L6:
        f6 = f13;
        f7 = f11;
        f8 = f5;
        continue; /* Loop/switch isn't completed */
_L7:
        f6 = f5;
        f7 = f11;
        f8 = f12;
        if(true) goto _L1; else goto _L8
_L8:
    }

    public static int HSBtoColor(float af[]) {
        return HSBtoColor(af[0], af[1], af[2]);
    }

    public static int HSVToColor(int i, float af[]) {
        if(af.length < 3)
            throw new RuntimeException("3 components required for hsv");
        else
            return nativeHSVToColor(i, af);
    }

    public static int HSVToColor(float af[]) {
        return HSVToColor(255, af);
    }

    public static void RGBToHSV(int i, int j, int k, float af[]) {
        if(af.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        } else {
            nativeRGBToHSV(i, j, k, af);
            return;
        }
    }

    public static int alpha(int i) {
        return i >>> 24;
    }

    public static int argb(int i, int j, int k, int l) {
        return l | (i << 24 | j << 16 | k << 8);
    }

    public static int blue(int i) {
        return i & 0xff;
    }

    public static float brightness(int i) {
        int j = 0xff & i >> 16;
        int k = 0xff & i >> 8;
        return (float)Math.max(i & 0xff, Math.max(j, k)) / 255F;
    }

    public static void colorToHSV(int i, float af[]) {
        RGBToHSV(0xff & i >> 16, 0xff & i >> 8, i & 0xff, af);
    }

    public static int green(int i) {
        return 0xff & i >> 8;
    }

    public static float hue(int i) {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        j = 0xff & i >> 16;
        k = 0xff & i >> 8;
        l = i & 0xff;
        i1 = Math.max(l, Math.max(j, k));
        j1 = Math.min(l, Math.min(j, k));
        if(i1 != j1) goto _L2; else goto _L1
_L1:
        float f5 = 0.0F;
_L4:
        return f5;
_L2:
        float f = i1 - j1;
        float f1 = (float)(i1 - j) / f;
        float f2 = (float)(i1 - k) / f;
        float f3 = (float)(i1 - l) / f;
        float f4;
        if(j == i1)
            f4 = f3 - f2;
        else
        if(k == i1)
            f4 = (2.0F + f1) - f3;
        else
            f4 = (4F + f2) - f1;
        f5 = f4 / 6F;
        if(f5 < 0.0F)
            f5++;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static native int nativeHSVToColor(int i, float af[]);

    private static native void nativeRGBToHSV(int i, int j, int k, float af[]);

    public static int parseColor(String s) {
        long l;
        if(s.charAt(0) != '#')
            break MISSING_BLOCK_LABEL_60;
        l = Long.parseLong(s.substring(1), 16);
        if(s.length() != 7) goto _L2; else goto _L1
_L1:
        l |= 0xffffffffff000000L;
_L4:
        int i = (int)l;
_L5:
        return i;
_L2:
        if(s.length() == 9) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException("Unknown color");
        Integer integer = (Integer)sColorNameMap.get(s.toLowerCase(Locale.US));
        if(integer != null)
            i = integer.intValue();
        else
            throw new IllegalArgumentException("Unknown color");
          goto _L5
    }

    public static int red(int i) {
        return 0xff & i >> 16;
    }

    public static int rgb(int i, int j, int k) {
        return k | (0xff000000 | i << 16 | j << 8);
    }

    public static float saturation(int i) {
        int j = 0xff & i >> 16;
        int k = 0xff & i >> 8;
        int l = i & 0xff;
        int i1 = Math.max(l, Math.max(j, k));
        int j1 = Math.min(l, Math.min(j, k));
        float f;
        if(i1 == j1)
            f = 0.0F;
        else
            f = (float)(i1 - j1) / (float)i1;
        return f;
    }

    public static final int BLACK = 0xff000000;
    public static final int BLUE = 0xff0000ff;
    public static final int CYAN = 0xff00ffff;
    public static final int DKGRAY = 0xff444444;
    public static final int GRAY = 0xff888888;
    public static final int GREEN = 0xff00ff00;
    public static final int LTGRAY = 0xffcccccc;
    public static final int MAGENTA = -65281;
    public static final int RED = 0xffff0000;
    public static final int TRANSPARENT = 0;
    public static final int WHITE = -1;
    public static final int YELLOW = -256;
    private static final HashMap sColorNameMap;

    static  {
        sColorNameMap = new HashMap();
        sColorNameMap.put("black", Integer.valueOf(0xff000000));
        sColorNameMap.put("darkgray", Integer.valueOf(0xff444444));
        sColorNameMap.put("gray", Integer.valueOf(0xff888888));
        sColorNameMap.put("lightgray", Integer.valueOf(0xffcccccc));
        sColorNameMap.put("white", Integer.valueOf(-1));
        sColorNameMap.put("red", Integer.valueOf(0xffff0000));
        sColorNameMap.put("green", Integer.valueOf(0xff00ff00));
        sColorNameMap.put("blue", Integer.valueOf(0xff0000ff));
        sColorNameMap.put("yellow", Integer.valueOf(-256));
        sColorNameMap.put("cyan", Integer.valueOf(0xff00ffff));
        sColorNameMap.put("magenta", Integer.valueOf(-65281));
    }
}
