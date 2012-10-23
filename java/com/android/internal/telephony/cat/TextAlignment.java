// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


public final class TextAlignment extends Enum {

    private TextAlignment(String s, int i, int j) {
        super(s, i);
        mValue = j;
    }

    public static TextAlignment fromInt(int i) {
        TextAlignment atextalignment[];
        int j;
        int k;
        atextalignment = values();
        j = atextalignment.length;
        k = 0;
_L3:
        TextAlignment textalignment;
        if(k >= j)
            break MISSING_BLOCK_LABEL_37;
        textalignment = atextalignment[k];
        if(textalignment.mValue != i) goto _L2; else goto _L1
_L1:
        return textalignment;
_L2:
        k++;
          goto _L3
        textalignment = null;
          goto _L1
    }

    public static TextAlignment valueOf(String s) {
        return (TextAlignment)Enum.valueOf(com/android/internal/telephony/cat/TextAlignment, s);
    }

    public static TextAlignment[] values() {
        return (TextAlignment[])$VALUES.clone();
    }

    private static final TextAlignment $VALUES[];
    public static final TextAlignment CENTER;
    public static final TextAlignment DEFAULT;
    public static final TextAlignment LEFT;
    public static final TextAlignment RIGHT;
    private int mValue;

    static  {
        LEFT = new TextAlignment("LEFT", 0, 0);
        CENTER = new TextAlignment("CENTER", 1, 1);
        RIGHT = new TextAlignment("RIGHT", 2, 2);
        DEFAULT = new TextAlignment("DEFAULT", 3, 3);
        TextAlignment atextalignment[] = new TextAlignment[4];
        atextalignment[0] = LEFT;
        atextalignment[1] = CENTER;
        atextalignment[2] = RIGHT;
        atextalignment[3] = DEFAULT;
        $VALUES = atextalignment;
    }
}
