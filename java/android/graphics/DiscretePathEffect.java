// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            PathEffect

public class DiscretePathEffect extends PathEffect {

    public DiscretePathEffect(float f, float f1) {
        super.native_instance = nativeCreate(f, f1);
    }

    private static native int nativeCreate(float f, float f1);
}
