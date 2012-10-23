// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            PathEffect

public class DashPathEffect extends PathEffect {

    public DashPathEffect(float af[], float f) {
        if(af.length < 2) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            super.native_instance = nativeCreate(af, f);
            return;
        }
    }

    private static native int nativeCreate(float af[], float f);
}
