// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.PrintStream;

// Referenced classes of package android.util:
//            DisplayMetrics

public class TypedValue {

    public TypedValue() {
        changingConfigurations = -1;
    }

    public static float applyDimension(int i, float f, DisplayMetrics displaymetrics) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 42
    //                   1 44
    //                   2 54
    //                   3 64
    //                   4 77
    //                   5 87;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        f = 0.0F;
_L9:
        return f;
_L3:
        f *= displaymetrics.density;
        continue; /* Loop/switch isn't completed */
_L4:
        f *= displaymetrics.scaledDensity;
        continue; /* Loop/switch isn't completed */
_L5:
        f = 0.01388889F * (f * displaymetrics.xdpi);
        continue; /* Loop/switch isn't completed */
_L6:
        f *= displaymetrics.xdpi;
        continue; /* Loop/switch isn't completed */
_L7:
        f = 0.03937008F * (f * displaymetrics.xdpi);
        if(true) goto _L9; else goto _L8
_L8:
    }

    public static final String coerceToString(int i, int j) {
        String s = null;
        i;
        JVM INSTR tableswitch 0 18: default 92
    //                   0 127
    //                   1 129
    //                   2 152
    //                   3 92
    //                   4 175
    //                   5 186
    //                   6 223
    //                   7 92
    //                   8 92
    //                   9 92
    //                   10 92
    //                   11 92
    //                   12 92
    //                   13 92
    //                   14 92
    //                   15 92
    //                   16 92
    //                   17 263
    //                   18 289;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L8 _L9
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        if(i < 28 || i > 31) goto _L11; else goto _L10
_L10:
        s = (new StringBuilder()).append("#").append(Integer.toHexString(j)).toString();
_L13:
        return s;
_L3:
        s = (new StringBuilder()).append("@").append(j).toString();
        continue; /* Loop/switch isn't completed */
_L4:
        s = (new StringBuilder()).append("?").append(j).toString();
        continue; /* Loop/switch isn't completed */
_L5:
        s = Float.toString(Float.intBitsToFloat(j));
        continue; /* Loop/switch isn't completed */
_L6:
        s = (new StringBuilder()).append(Float.toString(complexToFloat(j))).append(DIMENSION_UNIT_STRS[0xf & j >> 0]).toString();
        continue; /* Loop/switch isn't completed */
_L7:
        s = (new StringBuilder()).append(Float.toString(100F * complexToFloat(j))).append(FRACTION_UNIT_STRS[0xf & j >> 0]).toString();
        continue; /* Loop/switch isn't completed */
_L8:
        s = (new StringBuilder()).append("0x").append(Integer.toHexString(j)).toString();
        continue; /* Loop/switch isn't completed */
_L9:
        if(j != 0)
            s = "true";
        else
            s = "false";
        continue; /* Loop/switch isn't completed */
_L11:
        if(i >= 16 && i <= 31)
            s = Integer.toString(j);
        if(true) goto _L13; else goto _L12
_L12:
    }

    public static float complexToDimension(int i, DisplayMetrics displaymetrics) {
        return applyDimension(0xf & i >> 0, complexToFloat(i), displaymetrics);
    }

    public static float complexToDimensionNoisy(int i, DisplayMetrics displaymetrics) {
        float f = complexToDimension(i, displaymetrics);
        System.out.println((new StringBuilder()).append("Dimension (0x").append(0xffffff & i >> 8).append("*").append(RADIX_MULTS[3 & i >> 4] / 0.00390625F).append(")").append(DIMENSION_UNIT_STRS[0xf & i >> 0]).append(" = ").append(f).toString());
        return f;
    }

    public static int complexToDimensionPixelOffset(int i, DisplayMetrics displaymetrics) {
        return (int)applyDimension(0xf & i >> 0, complexToFloat(i), displaymetrics);
    }

    public static int complexToDimensionPixelSize(int i, DisplayMetrics displaymetrics) {
        float f = complexToFloat(i);
        int j = (int)(0.5F + applyDimension(0xf & i >> 0, f, displaymetrics));
        if(j == 0)
            if(f == 0.0F)
                j = 0;
            else
            if(f > 0.0F)
                j = 1;
            else
                j = -1;
        return j;
    }

    public static float complexToFloat(int i) {
        return (float)(i & 0xffffff00) * RADIX_MULTS[3 & i >> 4];
    }

    public static float complexToFraction(int i, float f, float f1) {
        0xf & i >> 0;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 32
    //                   1 42;
           goto _L1 _L2 _L3
_L1:
        float f2 = 0.0F;
_L5:
        return f2;
_L2:
        f2 = f * complexToFloat(i);
        continue; /* Loop/switch isn't completed */
_L3:
        f2 = f1 * complexToFloat(i);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public final CharSequence coerceToString() {
        int i = type;
        Object obj;
        if(i == 3)
            obj = string;
        else
            obj = coerceToString(i, data);
        return ((CharSequence) (obj));
    }

    public float getDimension(DisplayMetrics displaymetrics) {
        return complexToDimension(data, displaymetrics);
    }

    public final float getFloat() {
        return Float.intBitsToFloat(data);
    }

    public float getFraction(float f, float f1) {
        return complexToFraction(data, f, f1);
    }

    public void setTo(TypedValue typedvalue) {
        type = typedvalue.type;
        string = typedvalue.string;
        data = typedvalue.data;
        assetCookie = typedvalue.assetCookie;
        resourceId = typedvalue.resourceId;
        density = typedvalue.density;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("TypedValue{t=0x").append(Integer.toHexString(type));
        stringbuilder.append("/d=0x").append(Integer.toHexString(data));
        if(type == 3) {
            StringBuilder stringbuilder1 = stringbuilder.append(" \"");
            Object obj;
            if(string != null)
                obj = string;
            else
                obj = "<null>";
            stringbuilder1.append(((CharSequence) (obj))).append("\"");
        }
        if(assetCookie != 0)
            stringbuilder.append(" a=").append(assetCookie);
        if(resourceId != 0)
            stringbuilder.append(" r=0x").append(Integer.toHexString(resourceId));
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public static final int COMPLEX_MANTISSA_MASK = 0xffffff;
    public static final int COMPLEX_MANTISSA_SHIFT = 8;
    public static final int COMPLEX_RADIX_0p23 = 3;
    public static final int COMPLEX_RADIX_16p7 = 1;
    public static final int COMPLEX_RADIX_23p0 = 0;
    public static final int COMPLEX_RADIX_8p15 = 2;
    public static final int COMPLEX_RADIX_MASK = 3;
    public static final int COMPLEX_RADIX_SHIFT = 4;
    public static final int COMPLEX_UNIT_DIP = 1;
    public static final int COMPLEX_UNIT_FRACTION = 0;
    public static final int COMPLEX_UNIT_FRACTION_PARENT = 1;
    public static final int COMPLEX_UNIT_IN = 4;
    public static final int COMPLEX_UNIT_MASK = 15;
    public static final int COMPLEX_UNIT_MM = 5;
    public static final int COMPLEX_UNIT_PT = 3;
    public static final int COMPLEX_UNIT_PX = 0;
    public static final int COMPLEX_UNIT_SHIFT = 0;
    public static final int COMPLEX_UNIT_SP = 2;
    public static final int DENSITY_DEFAULT = 0;
    public static final int DENSITY_NONE = 65535;
    private static final String DIMENSION_UNIT_STRS[];
    private static final String FRACTION_UNIT_STRS[];
    private static final float MANTISSA_MULT = 0.00390625F;
    private static final float RADIX_MULTS[];
    public static final int TYPE_ATTRIBUTE = 2;
    public static final int TYPE_DIMENSION = 5;
    public static final int TYPE_FIRST_COLOR_INT = 28;
    public static final int TYPE_FIRST_INT = 16;
    public static final int TYPE_FLOAT = 4;
    public static final int TYPE_FRACTION = 6;
    public static final int TYPE_INT_BOOLEAN = 18;
    public static final int TYPE_INT_COLOR_ARGB4 = 30;
    public static final int TYPE_INT_COLOR_ARGB8 = 28;
    public static final int TYPE_INT_COLOR_RGB4 = 31;
    public static final int TYPE_INT_COLOR_RGB8 = 29;
    public static final int TYPE_INT_DEC = 16;
    public static final int TYPE_INT_HEX = 17;
    public static final int TYPE_LAST_COLOR_INT = 31;
    public static final int TYPE_LAST_INT = 31;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_REFERENCE = 1;
    public static final int TYPE_STRING = 3;
    public int assetCookie;
    public int changingConfigurations;
    public int data;
    public int density;
    public int resourceId;
    public CharSequence string;
    public int type;

    static  {
        float af[] = new float[4];
        af[0] = 0.00390625F;
        af[1] = 3.051758E-05F;
        af[2] = 1.192093E-07F;
        af[3] = 4.656613E-10F;
        RADIX_MULTS = af;
        String as[] = new String[6];
        as[0] = "px";
        as[1] = "dip";
        as[2] = "sp";
        as[3] = "pt";
        as[4] = "in";
        as[5] = "mm";
        DIMENSION_UNIT_STRS = as;
        String as1[] = new String[2];
        as1[0] = "%";
        as1[1] = "%p";
        FRACTION_UNIT_STRS = as1;
    }
}
