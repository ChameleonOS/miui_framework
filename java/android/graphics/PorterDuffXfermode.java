// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Xfermode

public class PorterDuffXfermode extends Xfermode {

    public PorterDuffXfermode(PorterDuff.Mode mode1) {
        mode = mode1;
        super.native_instance = nativeCreateXfermode(mode1.nativeInt);
    }

    private static native int nativeCreateXfermode(int i);

    public final PorterDuff.Mode mode;
}
