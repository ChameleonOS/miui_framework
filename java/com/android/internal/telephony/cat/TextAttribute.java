// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


// Referenced classes of package com.android.internal.telephony.cat:
//            TextAlignment, TextColor, FontSize

public class TextAttribute {

    public TextAttribute(int i, int j, TextAlignment textalignment, FontSize fontsize, boolean flag, boolean flag1, boolean flag2, 
            boolean flag3, TextColor textcolor) {
        start = i;
        length = j;
        align = textalignment;
        size = fontsize;
        bold = flag;
        italic = flag1;
        underlined = flag2;
        strikeThrough = flag3;
        color = textcolor;
    }

    public TextAlignment align;
    public boolean bold;
    public TextColor color;
    public boolean italic;
    public int length;
    public FontSize size;
    public int start;
    public boolean strikeThrough;
    public boolean underlined;
}
