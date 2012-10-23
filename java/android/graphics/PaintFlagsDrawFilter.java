// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            DrawFilter

public class PaintFlagsDrawFilter extends DrawFilter {

    public PaintFlagsDrawFilter(int i, int j) {
        clearBits = i;
        setBits = j;
        super.mNativeInt = nativeConstructor(i, j);
    }

    private static native int nativeConstructor(int i, int j);

    public final int clearBits;
    public final int setBits;
}
