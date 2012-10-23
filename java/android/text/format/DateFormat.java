// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.format;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package android.text.format:
//            DateUtils

public class DateFormat {

    public DateFormat() {
    }

    private static final int appendQuotedText(SpannableStringBuilder spannablestringbuilder, int i, int j) {
        if(i + 1 >= j || spannablestringbuilder.charAt(i + 1) != '\'') goto _L2; else goto _L1
_L1:
        int k;
        spannablestringbuilder.delete(i, i + 1);
        k = 1;
_L3:
        return k;
_L2:
        int l;
        k = 0;
        spannablestringbuilder.delete(i, i + 1);
        l = j - 1;
_L4:
        while(i < l)  {
label0:
            {
                if(spannablestringbuilder.charAt(i) != '\'')
                    break MISSING_BLOCK_LABEL_117;
                if(i + 1 >= l || spannablestringbuilder.charAt(i + 1) != '\'')
                    break label0;
                spannablestringbuilder.delete(i, i + 1);
                l--;
                k++;
                i++;
            }
        }
          goto _L3
        spannablestringbuilder.delete(i, i + 1);
          goto _L3
        i++;
        k++;
          goto _L4
    }

    public static final CharSequence format(CharSequence charsequence, long l) {
        return format(charsequence, new Date(l));
    }

    public static final CharSequence format(CharSequence charsequence, Calendar calendar) {
        SpannableStringBuilder spannablestringbuilder;
        int i;
        int j;
        spannablestringbuilder = new SpannableStringBuilder(charsequence);
        i = charsequence.length();
        j = 0;
_L2:
        int k;
        char c;
        if(j >= i)
            break MISSING_BLOCK_LABEL_423;
        k = 1;
        c = spannablestringbuilder.charAt(j);
        if(c != '\'')
            break; /* Loop/switch isn't completed */
        k = appendQuotedText(spannablestringbuilder, j, i);
        i = spannablestringbuilder.length();
_L15:
        j += k;
        if(true) goto _L2; else goto _L1
_L1:
        for(; j + k < i && spannablestringbuilder.charAt(j + k) == c; k++);
        c;
        JVM INSTR lookupswitch 11: default 196
    //                   65: 247
    //                   69: 276
    //                   77: 374
    //                   97: 233
    //                   100: 261
    //                   104: 313
    //                   107: 342
    //                   109: 358
    //                   115: 385
    //                   121: 412
    //                   122: 401;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L13:
        break MISSING_BLOCK_LABEL_412;
_L3:
        Object obj1 = null;
_L16:
        if(obj1 != null) {
            spannablestringbuilder.replace(j, j + k, ((CharSequence) (obj1)));
            k = ((String) (obj1)).length();
            i = spannablestringbuilder.length();
        }
          goto _L15
_L7:
        obj1 = DateUtils.getAMPMString(calendar.get(9));
          goto _L16
_L4:
        obj1 = DateUtils.getAMPMString(calendar.get(9));
          goto _L16
_L8:
        obj1 = zeroPad(calendar.get(5), k);
          goto _L16
_L5:
        int i1 = calendar.get(7);
        byte byte0;
        if(k < 4)
            byte0 = 20;
        else
            byte0 = 10;
        obj1 = DateUtils.getDayOfWeekString(i1, byte0);
          goto _L16
_L9:
        int l = calendar.get(10);
        if(l == 0)
            l = 12;
        obj1 = zeroPad(l, k);
          goto _L16
_L10:
        obj1 = zeroPad(calendar.get(11), k);
          goto _L16
_L11:
        obj1 = zeroPad(calendar.get(12), k);
          goto _L16
_L6:
        obj1 = getMonthString(calendar, k);
          goto _L16
_L12:
        obj1 = zeroPad(calendar.get(13), k);
          goto _L16
_L14:
        obj1 = getTimeZoneString(calendar, k);
          goto _L16
        obj1 = getYearString(calendar, k);
          goto _L16
        Object obj;
        if(charsequence instanceof Spanned)
            obj = new SpannedString(spannablestringbuilder);
        else
            obj = spannablestringbuilder.toString();
        return ((CharSequence) (obj));
          goto _L15
    }

    public static final CharSequence format(CharSequence charsequence, Date date) {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTime(date);
        return format(charsequence, ((Calendar) (gregoriancalendar)));
    }

    private static final String formatZoneOffset(int i, int j) {
        int k = i / 1000;
        StringBuilder stringbuilder = new StringBuilder();
        int l;
        int i1;
        if(k < 0) {
            stringbuilder.insert(0, "-");
            k = -k;
        } else {
            stringbuilder.insert(0, "+");
        }
        l = k / 3600;
        i1 = (k % 3600) / 60;
        stringbuilder.append(zeroPad(l, 2));
        stringbuilder.append(zeroPad(i1, 2));
        return stringbuilder.toString();
    }

    public static final java.text.DateFormat getDateFormat(Context context) {
        return getDateFormatForSetting(context, android.provider.Settings.System.getString(context.getContentResolver(), "date_format"));
    }

    public static java.text.DateFormat getDateFormatForSetting(Context context, String s) {
        return new SimpleDateFormat(getDateFormatStringForSetting(context, s));
    }

    public static final char[] getDateFormatOrder(Context context) {
        char ac[] = new char[3];
        ac[0] = 'd';
        ac[1] = 'M';
        ac[2] = 'y';
        String s = getDateFormatString(context);
        int i = 0;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        char ac1[] = s.toCharArray();
        int j = ac1.length;
        for(int k = 0; k < j; k++) {
            char c = ac1[k];
            if(!flag && c == 'd') {
                flag = true;
                ac[i] = 'd';
                i++;
            }
            if(!flag1 && c == 'M') {
                flag1 = true;
                ac[i] = 'M';
                i++;
            }
            if(!flag2 && c == 'y') {
                flag2 = true;
                ac[i] = 'y';
                i++;
            }
        }

        return ac;
    }

    private static String getDateFormatString(Context context) {
        return getDateFormatStringForSetting(context, android.provider.Settings.System.getString(context.getContentResolver(), "date_format"));
    }

    private static String getDateFormatStringForSetting(Context context, String s) {
        if(s == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        i = s.indexOf('M');
        j = s.indexOf('d');
        k = s.indexOf('y');
        if(i < 0 || j < 0 || k < 0) goto _L2; else goto _L3
_L3:
        String s1;
        String s2 = context.getString(0x1040085);
        String s3;
        if(k < i && k < j) {
            if(i < j) {
                Object aobj5[] = new Object[3];
                aobj5[0] = "yyyy";
                aobj5[1] = "MM";
                aobj5[2] = "dd";
                s3 = String.format(s2, aobj5);
            } else {
                Object aobj4[] = new Object[3];
                aobj4[0] = "yyyy";
                aobj4[1] = "dd";
                aobj4[2] = "MM";
                s3 = String.format(s2, aobj4);
            }
        } else
        if(i < j) {
            if(j < k) {
                Object aobj3[] = new Object[3];
                aobj3[0] = "MM";
                aobj3[1] = "dd";
                aobj3[2] = "yyyy";
                s3 = String.format(s2, aobj3);
            } else {
                Object aobj2[] = new Object[3];
                aobj2[0] = "MM";
                aobj2[1] = "yyyy";
                aobj2[2] = "dd";
                s3 = String.format(s2, aobj2);
            }
        } else
        if(i < k) {
            Object aobj1[] = new Object[3];
            aobj1[0] = "dd";
            aobj1[1] = "MM";
            aobj1[2] = "yyyy";
            s3 = String.format(s2, aobj1);
        } else {
            Object aobj[] = new Object[3];
            aobj[0] = "dd";
            aobj[1] = "yyyy";
            aobj[2] = "MM";
            s3 = String.format(s2, aobj);
        }
        s1 = s3;
_L5:
        return s1;
_L2:
        s1 = context.getString(0x1040084);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static final java.text.DateFormat getLongDateFormat(Context context) {
        return java.text.DateFormat.getDateInstance(1);
    }

    public static final java.text.DateFormat getMediumDateFormat(Context context) {
        return java.text.DateFormat.getDateInstance(2);
    }

    private static final String getMonthString(Calendar calendar, int i) {
        int j = calendar.get(2);
        String s;
        if(i >= 4)
            s = DateUtils.getMonthString(j, 10);
        else
        if(i == 3)
            s = DateUtils.getMonthString(j, 20);
        else
            s = zeroPad(j + 1, i);
        return s;
    }

    public static final java.text.DateFormat getTimeFormat(Context context) {
        int i;
        if(is24HourFormat(context))
            i = 0x1040082;
        else
            i = 0x1040081;
        return new SimpleDateFormat(context.getString(i));
    }

    private static final String getTimeZoneString(Calendar calendar, int i) {
        TimeZone timezone = calendar.getTimeZone();
        String s;
        if(i < 2) {
            s = formatZoneOffset(calendar.get(16) + calendar.get(15), i);
        } else {
            boolean flag;
            if(calendar.get(16) != 0)
                flag = true;
            else
                flag = false;
            s = timezone.getDisplayName(flag, 0);
        }
        return s;
    }

    private static final String getYearString(Calendar calendar, int i) {
        int j = calendar.get(1);
        String s;
        if(i <= 2)
            s = zeroPad(j % 100, 2);
        else
            s = String.valueOf(j);
        return s;
    }

    public static boolean is24HourFormat(Context context) {
        boolean flag;
        String s;
        flag = true;
        s = android.provider.Settings.System.getString(context.getContentResolver(), "time_12_24");
        if(s != null) goto _L2; else goto _L1
_L1:
        Locale locale = context.getResources().getConfiguration().locale;
        if(!Locale.CHINA.equals(locale)) goto _L4; else goto _L3
_L3:
        return flag;
_L4:
        Object obj = sLocaleLock;
        obj;
        JVM INSTR monitorenter ;
        if(sIs24HourLocale != null && sIs24HourLocale.equals(locale)) {
            flag = sIs24Hour;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_81;
        Exception exception;
        exception;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
        Object obj1;
        boolean flag1;
        java.text.DateFormat dateformat = java.text.DateFormat.getTimeInstance(flag, locale);
        if(dateformat instanceof SimpleDateFormat) {
            if(((SimpleDateFormat)dateformat).toPattern().indexOf('H') >= 0)
                s = "24";
            else
                s = "12";
        } else {
            s = "12";
        }
        obj1 = sLocaleLock;
        obj1;
        JVM INSTR monitorenter ;
        sIs24HourLocale = locale;
        if(s.equals("12")) goto _L6; else goto _L5
_L5:
        flag1 = flag;
_L7:
        sIs24Hour = flag1;
_L2:
        Exception exception1;
        if(s == null || s.equals("12"))
            flag = false;
        continue; /* Loop/switch isn't completed */
_L6:
        flag1 = false;
          goto _L7
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        if(true) goto _L3; else goto _L8
_L8:
    }

    private static final String zeroPad(int i, int j) {
        String s = String.valueOf(i);
        if(s.length() < j) {
            char ac[] = new char[j];
            for(int k = 0; k < j; k++)
                ac[k] = '0';

            s.getChars(0, s.length(), ac, j - s.length());
            s = new String(ac);
        }
        return s;
    }

    public static final char AM_PM = 97;
    public static final char CAPITAL_AM_PM = 65;
    public static final char DATE = 100;
    public static final char DAY = 69;
    public static final char HOUR = 104;
    public static final char HOUR_OF_DAY = 107;
    public static final char MINUTE = 109;
    public static final char MONTH = 77;
    public static final char QUOTE = 39;
    public static final char SECONDS = 115;
    public static final char TIME_ZONE = 122;
    public static final char YEAR = 121;
    private static boolean sIs24Hour;
    private static Locale sIs24HourLocale;
    private static final Object sLocaleLock = new Object();

}
