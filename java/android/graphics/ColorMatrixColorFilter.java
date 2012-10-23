// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            ColorFilter, ColorMatrix

public class ColorMatrixColorFilter extends ColorFilter {

    public ColorMatrixColorFilter(ColorMatrix colormatrix) {
        float af[] = colormatrix.getArray();
        super.native_instance = nativeColorMatrixFilter(af);
        super.nativeColorFilter = nColorMatrixFilter(super.native_instance, af);
    }

    public ColorMatrixColorFilter(float af[]) {
        if(af.length < 20) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            super.native_instance = nativeColorMatrixFilter(af);
            super.nativeColorFilter = nColorMatrixFilter(super.native_instance, af);
            return;
        }
    }

    private static native int nColorMatrixFilter(int i, float af[]);

    private static native int nativeColorMatrixFilter(float af[]);
}
