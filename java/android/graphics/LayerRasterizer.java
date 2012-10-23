// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Rasterizer, Paint

public class LayerRasterizer extends Rasterizer {

    public LayerRasterizer() {
        super.native_instance = nativeConstructor();
    }

    private static native void nativeAddLayer(int i, int j, float f, float f1);

    private static native int nativeConstructor();

    public void addLayer(Paint paint) {
        nativeAddLayer(super.native_instance, paint.mNativePaint, 0.0F, 0.0F);
    }

    public void addLayer(Paint paint, float f, float f1) {
        nativeAddLayer(super.native_instance, paint.mNativePaint, f, f1);
    }
}
