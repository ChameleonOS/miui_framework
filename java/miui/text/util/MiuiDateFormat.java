// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.text.util;

import android.content.res.Resources;
import java.text.*;
import java.util.*;

public class MiuiDateFormat extends SimpleDateFormat {

    public MiuiDateFormat() {
    }

    public MiuiDateFormat(String s) {
        super(s);
    }

    public MiuiDateFormat(String s, DateFormatSymbols dateformatsymbols) {
        super(s, dateformatsymbols);
    }

    public MiuiDateFormat(String s, Locale locale) {
        super(s, locale);
    }

    private String getDetailedAmPm(int i) {
        int ai[];
        String as[];
        int j;
        ai = Resources.getSystem().getIntArray(0x606000a);
        as = Resources.getSystem().getStringArray(0x606000b);
        j = -1 + ai.length;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_53;
        if(i < ai[j]) goto _L2; else goto _L1
_L1:
        String s = as[j];
_L4:
        return s;
_L2:
        j--;
          goto _L3
        s = null;
          goto _L4
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition) {
        DateFormatSymbols dateformatsymbols = getDateFormatSymbols();
        calendar.setTime(date);
        String as[] = dateformatsymbols.getAmPmStrings();
        as[calendar.get(9)] = getDetailedAmPm(calendar.get(11));
        dateformatsymbols.setAmPmStrings(as);
        setDateFormatSymbols(dateformatsymbols);
        return super.format(date, stringbuffer, fieldposition);
    }

    private static final long serialVersionUID = 1L;
}
