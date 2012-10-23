// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.util.Locale;
import libcore.icu.ICU;

public class LocaleUtil {

    private LocaleUtil() {
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        int i = 0;
        Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        JVM INSTR tableswitch 1 2: default 36
    //                   1 38
    //                   2 38;
           goto _L1 _L2 _L2
_L1:
        return i;
_L2:
        i = 1;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        if(locale == null || locale.equals(Locale.ROOT)) goto _L2; else goto _L1
_L1:
        String s = ICU.getScript(ICU.addLikelySubtags(locale.toString()));
        if(s != null) goto _L4; else goto _L3
_L3:
        int i = getLayoutDirectionFromFirstChar(locale);
_L6:
        return i;
_L4:
        if(s.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || s.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        i = 0;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";

}
