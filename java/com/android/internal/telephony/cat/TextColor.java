// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


public final class TextColor extends Enum {

    private TextColor(String s, int i, int j) {
        super(s, i);
        mValue = j;
    }

    public static TextColor fromInt(int i) {
        TextColor atextcolor[];
        int j;
        int k;
        atextcolor = values();
        j = atextcolor.length;
        k = 0;
_L3:
        TextColor textcolor;
        if(k >= j)
            break MISSING_BLOCK_LABEL_37;
        textcolor = atextcolor[k];
        if(textcolor.mValue != i) goto _L2; else goto _L1
_L1:
        return textcolor;
_L2:
        k++;
          goto _L3
        textcolor = null;
          goto _L1
    }

    public static TextColor valueOf(String s) {
        return (TextColor)Enum.valueOf(com/android/internal/telephony/cat/TextColor, s);
    }

    public static TextColor[] values() {
        return (TextColor[])$VALUES.clone();
    }

    private static final TextColor $VALUES[];
    public static final TextColor BLACK;
    public static final TextColor BRIGHT_BLUE;
    public static final TextColor BRIGHT_CYAN;
    public static final TextColor BRIGHT_GREEN;
    public static final TextColor BRIGHT_MAGENTA;
    public static final TextColor BRIGHT_RED;
    public static final TextColor BRIGHT_YELLOW;
    public static final TextColor DARK_BLUE;
    public static final TextColor DARK_CYAN;
    public static final TextColor DARK_GRAY;
    public static final TextColor DARK_GREEN;
    public static final TextColor DARK_MAGENTA;
    public static final TextColor DARK_RED;
    public static final TextColor DARK_YELLOW;
    public static final TextColor GRAY;
    public static final TextColor WHITE;
    private int mValue;

    static  {
        BLACK = new TextColor("BLACK", 0, 0);
        DARK_GRAY = new TextColor("DARK_GRAY", 1, 1);
        DARK_RED = new TextColor("DARK_RED", 2, 2);
        DARK_YELLOW = new TextColor("DARK_YELLOW", 3, 3);
        DARK_GREEN = new TextColor("DARK_GREEN", 4, 4);
        DARK_CYAN = new TextColor("DARK_CYAN", 5, 5);
        DARK_BLUE = new TextColor("DARK_BLUE", 6, 6);
        DARK_MAGENTA = new TextColor("DARK_MAGENTA", 7, 7);
        GRAY = new TextColor("GRAY", 8, 8);
        WHITE = new TextColor("WHITE", 9, 9);
        BRIGHT_RED = new TextColor("BRIGHT_RED", 10, 10);
        BRIGHT_YELLOW = new TextColor("BRIGHT_YELLOW", 11, 11);
        BRIGHT_GREEN = new TextColor("BRIGHT_GREEN", 12, 12);
        BRIGHT_CYAN = new TextColor("BRIGHT_CYAN", 13, 13);
        BRIGHT_BLUE = new TextColor("BRIGHT_BLUE", 14, 14);
        BRIGHT_MAGENTA = new TextColor("BRIGHT_MAGENTA", 15, 15);
        TextColor atextcolor[] = new TextColor[16];
        atextcolor[0] = BLACK;
        atextcolor[1] = DARK_GRAY;
        atextcolor[2] = DARK_RED;
        atextcolor[3] = DARK_YELLOW;
        atextcolor[4] = DARK_GREEN;
        atextcolor[5] = DARK_CYAN;
        atextcolor[6] = DARK_BLUE;
        atextcolor[7] = DARK_MAGENTA;
        atextcolor[8] = GRAY;
        atextcolor[9] = WHITE;
        atextcolor[10] = BRIGHT_RED;
        atextcolor[11] = BRIGHT_YELLOW;
        atextcolor[12] = BRIGHT_GREEN;
        atextcolor[13] = BRIGHT_CYAN;
        atextcolor[14] = BRIGHT_BLUE;
        atextcolor[15] = BRIGHT_MAGENTA;
        $VALUES = atextcolor;
    }
}
