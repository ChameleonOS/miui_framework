// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Shader

public class SweepGradient extends Shader {

    public SweepGradient(float f, float f1, int i, int j) {
        super.native_instance = nativeCreate2(f, f1, i, j);
        super.native_shader = nativePostCreate2(super.native_instance, f, f1, i, j);
    }

    public SweepGradient(float f, float f1, int ai[], float af[]) {
        if(ai.length < 2)
            throw new IllegalArgumentException("needs >= 2 number of colors");
        if(af != null && ai.length != af.length) {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
        } else {
            super.native_instance = nativeCreate1(f, f1, ai, af);
            super.native_shader = nativePostCreate1(super.native_instance, f, f1, ai, af);
            return;
        }
    }

    private static native int nativeCreate1(float f, float f1, int ai[], float af[]);

    private static native int nativeCreate2(float f, float f1, int i, int j);

    private static native int nativePostCreate1(int i, float f, float f1, int ai[], float af[]);

    private static native int nativePostCreate2(int i, float f, float f1, int j, int k);
}
