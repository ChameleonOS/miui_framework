// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            MaskFilter

public class TableMaskFilter extends MaskFilter {

    private TableMaskFilter(int i) {
        super.native_instance = i;
    }

    public TableMaskFilter(byte abyte0[]) {
        if(abyte0.length < 256) {
            throw new RuntimeException("table.length must be >= 256");
        } else {
            super.native_instance = nativeNewTable(abyte0);
            return;
        }
    }

    public static TableMaskFilter CreateClipTable(int i, int j) {
        return new TableMaskFilter(nativeNewClip(i, j));
    }

    public static TableMaskFilter CreateGammaTable(float f) {
        return new TableMaskFilter(nativeNewGamma(f));
    }

    private static native int nativeNewClip(int i, int j);

    private static native int nativeNewGamma(float f);

    private static native int nativeNewTable(byte abyte0[]);
}
