// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.text.util;

import android.content.Context;
import android.content.res.Resources;

public final class MiuiFormatter {

    public MiuiFormatter() {
    }

    public static String formatFileSize(Context context, long l) {
        return formatFileSize(context, l, false);
    }

    private static String formatFileSize(Context context, long l, boolean flag) {
        if(context != null) goto _L2; else goto _L1
_L1:
        String s1 = "";
_L4:
        return s1;
_L2:
        float f;
        int i;
        String s;
        f = l;
        i = 0x60c01de;
        if(f > 900F) {
            i = 0x60c017b;
            f /= 1000F;
        }
        if(f > 900F) {
            i = 0x60c017c;
            f /= 1000F;
        }
        if(f > 900F) {
            i = 0x60c019b;
            f /= 1000F;
        }
        if(f > 900F) {
            i = 0x60c01df;
            f /= 1000F;
        }
        if(f > 900F) {
            i = 0x60c01e0;
            f /= 1000F;
        }
        if(f >= 1.0F)
            break; /* Loop/switch isn't completed */
        Object aobj6[] = new Object[1];
        aobj6[0] = Float.valueOf(f);
        s = String.format("%.2f", aobj6);
_L5:
        Resources resources = context.getResources();
        Object aobj1[] = new Object[2];
        aobj1[0] = s;
        aobj1[1] = context.getString(i);
        s1 = resources.getString(0x60c01e1, aobj1);
        if(true) goto _L4; else goto _L3
_L3:
        if(f < 10F) {
            if(flag) {
                Object aobj5[] = new Object[1];
                aobj5[0] = Float.valueOf(f);
                s = String.format("%.1f", aobj5);
            } else {
                Object aobj4[] = new Object[1];
                aobj4[0] = Float.valueOf(f);
                s = String.format("%.2f", aobj4);
            }
        } else
        if(f < 100F) {
            if(flag) {
                Object aobj3[] = new Object[1];
                aobj3[0] = Float.valueOf(f);
                s = String.format("%.0f", aobj3);
            } else {
                Object aobj2[] = new Object[1];
                aobj2[0] = Float.valueOf(f);
                s = String.format("%.2f", aobj2);
            }
        } else {
            Object aobj[] = new Object[1];
            aobj[0] = Float.valueOf(f);
            s = String.format("%.0f", aobj);
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public static String formatShortFileSize(Context context, long l) {
        return formatFileSize(context, l, true);
    }

    public static final long GB = 0x3b9aca00L;
    public static final long KB = 1000L;
    public static final long MB = 0xf4240L;
    private static final long UNIT = 1000L;
}
