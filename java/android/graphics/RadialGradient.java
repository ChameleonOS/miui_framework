// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Shader

public class RadialGradient extends Shader {

    public RadialGradient(float f, float f1, float f2, int i, int j, Shader.TileMode tilemode) {
        if(f2 <= 0.0F) {
            throw new IllegalArgumentException("radius must be > 0");
        } else {
            super.native_instance = nativeCreate2(f, f1, f2, i, j, tilemode.nativeInt);
            super.native_shader = nativePostCreate2(super.native_instance, f, f1, f2, i, j, tilemode.nativeInt);
            return;
        }
    }

    public RadialGradient(float f, float f1, float f2, int ai[], float af[], Shader.TileMode tilemode) {
        if(f2 <= 0.0F)
            throw new IllegalArgumentException("radius must be > 0");
        if(ai.length < 2)
            throw new IllegalArgumentException("needs >= 2 number of colors");
        if(af != null && ai.length != af.length) {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
        } else {
            super.native_instance = nativeCreate1(f, f1, f2, ai, af, tilemode.nativeInt);
            super.native_shader = nativePostCreate1(super.native_instance, f, f1, f2, ai, af, tilemode.nativeInt);
            return;
        }
    }

    private static native int nativeCreate1(float f, float f1, float f2, int ai[], float af[], int i);

    private static native int nativeCreate2(float f, float f1, float f2, int i, int j, int k);

    private static native int nativePostCreate1(int i, float f, float f1, float f2, int ai[], float af[], int j);

    private static native int nativePostCreate2(int i, float f, float f1, float f2, int j, int k, int l);
}
