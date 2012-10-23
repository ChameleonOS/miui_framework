// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            ColorFilter

public class LightingColorFilter extends ColorFilter {

    public LightingColorFilter(int i, int j) {
        super.native_instance = native_CreateLightingFilter(i, j);
        super.nativeColorFilter = nCreateLightingFilter(super.native_instance, i, j);
    }

    private static native int nCreateLightingFilter(int i, int j, int k);

    private static native int native_CreateLightingFilter(int i, int j);
}
