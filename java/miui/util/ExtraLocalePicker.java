// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import java.util.Locale;

public class ExtraLocalePicker {

    public ExtraLocalePicker() {
    }

    public static void adjustLocaleOrder(com.android.internal.app.LocalePicker.LocaleInfo alocaleinfo[]) {
        moveLocaleToFirst(alocaleinfo, "en_US");
        moveLocaleToFirst(alocaleinfo, "zh_TW");
        moveLocaleToFirst(alocaleinfo, "zh_CN");
    }

    private static void moveLocaleToFirst(com.android.internal.app.LocalePicker.LocaleInfo alocaleinfo[], String s) {
        int i = 0;
        do {
label0:
            {
                if(i < alocaleinfo.length) {
                    if(!s.equals(alocaleinfo[i].getLocale().toString()))
                        break label0;
                    if(i != 0) {
                        com.android.internal.app.LocalePicker.LocaleInfo localeinfo = alocaleinfo[i];
                        for(int j = i; j > 0; j--)
                            alocaleinfo[j] = alocaleinfo[j - 1];

                        alocaleinfo[0] = localeinfo;
                    }
                }
                return;
            }
            i++;
        } while(true);
    }
}
