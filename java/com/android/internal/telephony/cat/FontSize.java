// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


public final class FontSize extends Enum {

    private FontSize(String s, int i, int j) {
        super(s, i);
        mValue = j;
    }

    public static FontSize fromInt(int i) {
        FontSize afontsize[];
        int j;
        int k;
        afontsize = values();
        j = afontsize.length;
        k = 0;
_L3:
        FontSize fontsize;
        if(k >= j)
            break MISSING_BLOCK_LABEL_37;
        fontsize = afontsize[k];
        if(fontsize.mValue != i) goto _L2; else goto _L1
_L1:
        return fontsize;
_L2:
        k++;
          goto _L3
        fontsize = null;
          goto _L1
    }

    public static FontSize valueOf(String s) {
        return (FontSize)Enum.valueOf(com/android/internal/telephony/cat/FontSize, s);
    }

    public static FontSize[] values() {
        return (FontSize[])$VALUES.clone();
    }

    private static final FontSize $VALUES[];
    public static final FontSize LARGE;
    public static final FontSize NORMAL;
    public static final FontSize SMALL;
    private int mValue;

    static  {
        NORMAL = new FontSize("NORMAL", 0, 0);
        LARGE = new FontSize("LARGE", 1, 1);
        SMALL = new FontSize("SMALL", 2, 2);
        FontSize afontsize[] = new FontSize[3];
        afontsize[0] = NORMAL;
        afontsize[1] = LARGE;
        afontsize[2] = SMALL;
        $VALUES = afontsize;
    }
}
