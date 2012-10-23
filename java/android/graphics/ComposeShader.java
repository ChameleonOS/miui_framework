// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Shader, Xfermode, PorterDuffXfermode

public class ComposeShader extends Shader {

    public ComposeShader(Shader shader, Shader shader1, PorterDuff.Mode mode) {
        mShaderA = shader;
        mShaderB = shader1;
        super.native_instance = nativeCreate2(shader.native_instance, shader1.native_instance, mode.nativeInt);
        super.native_shader = nativePostCreate2(super.native_instance, shader.native_shader, shader1.native_shader, mode.nativeInt);
    }

    public ComposeShader(Shader shader, Shader shader1, Xfermode xfermode) {
        int i = 0;
        super();
        mShaderA = shader;
        mShaderB = shader1;
        int j = shader.native_instance;
        int k = shader1.native_instance;
        int l;
        if(xfermode != null)
            l = xfermode.native_instance;
        else
            l = 0;
        super.native_instance = nativeCreate1(j, k, l);
        if(xfermode instanceof PorterDuffXfermode) {
            PorterDuff.Mode mode = ((PorterDuffXfermode)xfermode).mode;
            int l1 = super.native_instance;
            int i2 = shader.native_shader;
            int j2 = shader1.native_shader;
            if(mode != null)
                i = mode.nativeInt;
            super.native_shader = nativePostCreate2(l1, i2, j2, i);
        } else {
            int i1 = super.native_instance;
            int j1 = shader.native_shader;
            int k1 = shader1.native_shader;
            if(xfermode != null)
                i = xfermode.native_instance;
            super.native_shader = nativePostCreate1(i1, j1, k1, i);
        }
    }

    private static native int nativeCreate1(int i, int j, int k);

    private static native int nativeCreate2(int i, int j, int k);

    private static native int nativePostCreate1(int i, int j, int k, int l);

    private static native int nativePostCreate2(int i, int j, int k, int l);

    private final Shader mShaderA;
    private final Shader mShaderB;
}
