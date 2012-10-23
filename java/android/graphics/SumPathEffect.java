// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            PathEffect

public class SumPathEffect extends PathEffect {

    public SumPathEffect(PathEffect patheffect, PathEffect patheffect1) {
        super.native_instance = nativeCreate(patheffect.native_instance, patheffect1.native_instance);
    }

    private static native int nativeCreate(int i, int j);
}
