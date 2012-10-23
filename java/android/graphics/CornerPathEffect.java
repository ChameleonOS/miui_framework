// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            PathEffect

public class CornerPathEffect extends PathEffect {

    public CornerPathEffect(float f) {
        super.native_instance = nativeCreate(f);
    }

    private static native int nativeCreate(float f);
}
