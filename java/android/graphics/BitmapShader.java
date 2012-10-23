// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Shader, Bitmap

public class BitmapShader extends Shader {

    public BitmapShader(Bitmap bitmap, Shader.TileMode tilemode, Shader.TileMode tilemode1) {
        mBitmap = bitmap;
        int i = bitmap.ni();
        super.native_instance = nativeCreate(i, tilemode.nativeInt, tilemode1.nativeInt);
        super.native_shader = nativePostCreate(super.native_instance, i, tilemode.nativeInt, tilemode1.nativeInt);
    }

    private static native int nativeCreate(int i, int j, int k);

    private static native int nativePostCreate(int i, int j, int k, int l);

    public final Bitmap mBitmap;
}
