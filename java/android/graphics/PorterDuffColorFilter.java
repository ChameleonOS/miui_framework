// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            ColorFilter

public class PorterDuffColorFilter extends ColorFilter {

    public PorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        super.native_instance = native_CreatePorterDuffFilter(i, mode.nativeInt);
        super.nativeColorFilter = nCreatePorterDuffFilter(super.native_instance, i, mode.nativeInt);
    }

    private static native int nCreatePorterDuffFilter(int i, int j, int k);

    private static native int native_CreatePorterDuffFilter(int i, int j);
}
