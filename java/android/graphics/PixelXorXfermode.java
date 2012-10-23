// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Xfermode

public class PixelXorXfermode extends Xfermode {

    public PixelXorXfermode(int i) {
        super.native_instance = nativeCreate(i);
    }

    private static native int nativeCreate(int i);
}
