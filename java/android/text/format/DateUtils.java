// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.format;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.text.DateFormat;
import java.util.*;

// Referenced classes of package android.text.format:
//            Time, DateFormat

public class DateUtils {

    public DateUtils() {
    }

    public static void assign(Calendar calendar, Calendar calendar1) {
        calendar.clear();
        calendar.setTimeInMillis(calendar1.getTimeInMillis());
    }

    public static String formatDateRange(Context context, long l, long l1, int i) {
        return formatDateRange(context, new Formatter(new StringBuilder(50), Locale.getDefault()), l, l1, i).toString();
    }

    public static Formatter formatDateRange(Context context, Formatter formatter, long l, long l1, int i) {
        return formatDateRange(context, formatter, l, l1, i, null);
    }

    public static Formatter formatDateRange(Context context, Formatter formatter, long l, long l1, int i, String s) {
        Resources resources;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        Time time;
        Time time1;
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        int k2;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        Formatter formatter1;
        resources = Resources.getSystem();
        boolean flag3;
        boolean flag4;
        boolean flag5;
        int k;
        if((i & 1) != 0)
            flag = true;
        else
            flag = false;
        if((i & 2) != 0)
            flag1 = true;
        else
            flag1 = false;
        if((i & 4) != 0)
            flag2 = true;
        else
            flag2 = false;
        if((i & 8) != 0)
            flag3 = true;
        else
            flag3 = false;
        if((i & 0x2000) != 0)
            flag4 = true;
        else
            flag4 = false;
        if((0x88000 & i) != 0)
            flag5 = true;
        else
            flag5 = false;
        if((0x90000 & i) != 0)
            flag6 = true;
        else
            flag6 = false;
        if((i & 0x20) != 0)
            flag7 = true;
        else
            flag7 = false;
        if((0x20000 & i) != 0)
            flag8 = true;
        else
            flag8 = false;
        if(l == l1)
            flag9 = true;
        else
            flag9 = false;
        if(s != null)
            time = new Time(s);
        else
        if(flag4)
            time = new Time("UTC");
        else
            time = new Time();
        time.set(l);
        if(flag9) {
            time1 = time;
            k = 0;
        } else {
            int j;
            if(s != null)
                time1 = new Time(s);
            else
            if(flag4)
                time1 = new Time("UTC");
            else
                time1 = new Time();
            time1.set(l1);
            j = Time.getJulianDay(l, time.gmtoff);
            k = Time.getJulianDay(l1, time1.gmtoff) - j;
        }
        if(!flag9 && (time1.hour | time1.minute | time1.second) == 0 && (!flag || k <= 1)) {
            time1.monthDay = -1 + time1.monthDay;
            time1.normalize(true);
        }
        i1 = time.monthDay;
        j1 = time.month;
        k1 = time.year;
        i2 = time1.monthDay;
        j2 = time1.month;
        k2 = time1.year;
        s1 = "";
        s2 = "";
        if(flag1) {
            Object aobj8[];
            String s21;
            if(flag5)
                s21 = "%a";
            else
                s21 = "%A";
            s1 = time.format(s21);
            if(flag9)
                s2 = s1;
            else
                s2 = time1.format(s21);
        }
        s3 = "";
        s4 = "";
        if(flag) {
            String s19 = "";
            boolean flag11;
            boolean flag12;
            boolean flag13;
            String s20;
            if((i & 0x80) != 0)
                flag11 = true;
            else
                flag11 = false;
            if((i & 0x40) != 0)
                flag12 = true;
            else
                flag12 = false;
            if(flag11)
                flag13 = true;
            else
            if(flag12)
                flag13 = false;
            else
                flag13 = DateFormat.is24HourFormat(context);
            if(flag13) {
                s19 = resources.getString(0x104007e);
                s20 = s19;
            } else {
                boolean flag14;
                boolean flag15;
                boolean flag16;
                boolean flag17;
                boolean flag18;
                boolean flag19;
                boolean flag20;
                boolean flag21;
                if((0x84000 & i) != 0)
                    flag14 = true;
                else
                    flag14 = false;
                if((i & 0x100) != 0)
                    flag15 = true;
                else
                    flag15 = false;
                if((i & 0x200) != 0)
                    flag16 = true;
                else
                    flag16 = false;
                if((i & 0x400) != 0)
                    flag17 = true;
                else
                    flag17 = false;
                if((i & 0x800) != 0)
                    flag18 = true;
                else
                    flag18 = false;
                if((i & 0x1000) != 0)
                    flag19 = true;
                else
                    flag19 = false;
                if(time.minute == 0 && time.second == 0)
                    flag20 = true;
                else
                    flag20 = false;
                if(time1.minute == 0 && time1.second == 0)
                    flag21 = true;
                else
                    flag21 = false;
                if(flag14 && flag20) {
                    if(flag15)
                        s20 = resources.getString(0x1040336);
                    else
                        s20 = resources.getString(0x1040335);
                } else
                if(flag15)
                    s20 = resources.getString(0x1040080);
                else
                    s20 = resources.getString(0x104007f);
                if(!flag9) {
                    if(flag14 && flag21) {
                        if(flag15)
                            s19 = resources.getString(0x1040336);
                        else
                            s19 = resources.getString(0x1040335);
                    } else
                    if(flag15)
                        s19 = resources.getString(0x1040080);
                    else
                        s19 = resources.getString(0x104007f);
                    if(time1.hour == 12 && flag21 && !flag16) {
                        if(flag17)
                            s19 = resources.getString(0x10403b8);
                        else
                            s19 = resources.getString(0x10403b7);
                    } else
                    if(time1.hour == 0 && flag21 && !flag18)
                        if(flag19)
                            s19 = resources.getString(0x10403ba);
                        else
                            s19 = resources.getString(0x10403b9);
                }
                if(time.hour == 12 && flag20 && !flag16)
                    if(flag17)
                        s20 = resources.getString(0x10403b8);
                    else
                        s20 = resources.getString(0x10403b7);
            }
            s3 = time.format(s20);
            if(flag9)
                s4 = s3;
            else
                s4 = time1.format(s19);
        }
        if(!flag2)
            if(flag3)
                flag2 = false;
            else
            if(k1 != k2) {
                flag2 = true;
            } else {
                Time time2 = new Time();
                time2.setToNow();
                if(k1 != time2.year)
                    flag2 = true;
                else
                    flag2 = false;
            }
        if(flag8)
            s5 = resources.getString(0x1040083);
        else
        if(flag2) {
            if(flag6) {
                if(flag7)
                    s5 = resources.getString(0x1040091);
                else
                    s5 = resources.getString(0x104008b);
            } else
            if(flag7)
                s5 = resources.getString(0x104008e);
            else
                s5 = resources.getString(0x1040086);
        } else
        if(flag6) {
            if(flag7)
                s5 = resources.getString(0x1040090);
            else
                s5 = resources.getString(0x104008f);
        } else
        if(flag7)
            s5 = resources.getString(0x104008d);
        else
            s5 = resources.getString(0x104008c);
        if(flag1) {
            if(flag)
                s6 = resources.getString(0x104009c);
            else
                s6 = resources.getString(0x104009d);
        } else
        if(flag)
            s6 = resources.getString(0x104009e);
        else
            s6 = resources.getString(0x1040093);
        if(!flag7 || j1 != j2 || k1 != k2) goto _L2; else goto _L1
_L1:
        aobj8 = new Object[1];
        aobj8[0] = time.format(s5);
        formatter1 = formatter.format("%s", aobj8);
_L11:
        return formatter1;
_L2:
        String s13;
        String s14;
        String s15;
        if(k1 != k2 || flag7) {
            String s7 = time.format(s5);
            String s8 = time1.format(s5);
            Object aobj[] = new Object[6];
            aobj[0] = s1;
            aobj[1] = s7;
            aobj[2] = s3;
            aobj[3] = s2;
            aobj[4] = s8;
            aobj[5] = s4;
            formatter1 = formatter.format(s6, aobj);
            continue; /* Loop/switch isn't completed */
        }
        String s9;
        String s10;
        String s11;
        String s12;
        Object obj;
        Object obj1;
        Object obj2;
        if(flag8)
            s9 = "%m";
        else
        if(flag6)
            s9 = resources.getString(0x10400b2);
        else
            s9 = "%B";
        s10 = time.format(s9);
        s11 = time.format("%-d");
        s12 = time.format("%Y");
        if(flag9)
            obj = null;
        else
            obj = time1.format(s9);
        if(flag9)
            obj1 = null;
        else
            obj1 = time1.format("%-d");
        if(flag9)
            obj2 = null;
        else
            obj2 = time1.format("%Y");
        if(j1 != j2) {
            int i3 = 0;
            if(flag1)
                i3 = 1;
            if(flag2)
                i3 += 2;
            if(flag)
                i3 += 4;
            if(flag8)
                i3 += 8;
            String s18 = resources.getString(sameYearTable[i3]);
            Object aobj7[] = new Object[10];
            aobj7[0] = s1;
            aobj7[1] = s10;
            aobj7[2] = s11;
            aobj7[3] = s12;
            aobj7[4] = s3;
            aobj7[5] = s2;
            aobj7[6] = obj;
            aobj7[7] = obj1;
            aobj7[8] = obj2;
            aobj7[9] = s4;
            formatter1 = formatter.format(s18, aobj7);
            continue; /* Loop/switch isn't completed */
        }
        if(i1 != i2) {
            int l2 = 0;
            if(flag1)
                l2 = 1;
            if(flag2)
                l2 += 2;
            if(flag)
                l2 += 4;
            if(flag8)
                l2 += 8;
            String s17 = resources.getString(sameMonthTable[l2]);
            Object aobj6[] = new Object[10];
            aobj6[0] = s1;
            aobj6[1] = s10;
            aobj6[2] = s11;
            aobj6[3] = s12;
            aobj6[4] = s3;
            aobj6[5] = s2;
            aobj6[6] = obj;
            aobj6[7] = obj1;
            aobj6[8] = obj2;
            aobj6[9] = s4;
            formatter1 = formatter.format(s17, aobj6);
            continue; /* Loop/switch isn't completed */
        }
        boolean flag10;
        Object aobj2[];
        if((i & 0x10) != 0)
            flag10 = true;
        else
            flag10 = false;
        if(!flag && !flag10 && !flag1)
            flag10 = true;
        s13 = "";
        if(flag)
            if(flag9) {
                s13 = s3;
            } else {
                String s16 = resources.getString(0x1040092);
                Object aobj5[] = new Object[2];
                aobj5[0] = s3;
                aobj5[1] = s4;
                s13 = String.format(s16, aobj5);
            }
        s14 = "";
        s15 = "";
        if(!flag10) goto _L4; else goto _L3
_L3:
        s15 = time.format(s5);
        if(!flag1) goto _L6; else goto _L5
_L5:
        if(flag)
            s14 = resources.getString(0x104009f);
        else
            s14 = resources.getString(0x10400a0);
_L8:
        aobj2 = new Object[3];
        aobj2[0] = s13;
        aobj2[1] = s1;
        aobj2[2] = s15;
        formatter1 = formatter.format(s14, aobj2);
        continue; /* Loop/switch isn't completed */
_L6:
        if(flag) {
            s14 = resources.getString(0x104008a);
            continue; /* Loop/switch isn't completed */
        }
        Object aobj4[] = new Object[1];
        aobj4[0] = s15;
        formatter1 = formatter.format("%s", aobj4);
        continue; /* Loop/switch isn't completed */
_L4:
        if(!flag1)
            continue; /* Loop/switch isn't completed */
        if(!flag)
            break; /* Loop/switch isn't completed */
        s14 = resources.getString(0x10400a1);
        if(true) goto _L8; else goto _L7
_L7:
        Object aobj3[] = new Object[1];
        aobj3[0] = s1;
        formatter1 = formatter.format("%s", aobj3);
        continue; /* Loop/switch isn't completed */
        if(!flag) goto _L8; else goto _L9
_L9:
        Object aobj1[] = new Object[1];
        aobj1[0] = s13;
        formatter1 = formatter.format("%s", aobj1);
        if(true) goto _L11; else goto _L10
_L10:
    }

    public static String formatDateTime(Context context, long l, int i) {
        return formatDateRange(context, l, l, i);
    }

    public static String formatElapsedTime(long l) {
        return formatElapsedTime(null, l);
    }

    public static String formatElapsedTime(StringBuilder stringbuilder, long l) {
        initFormatStrings();
        long l1 = 0L;
        long l2 = 0L;
        if(l >= 3600L) {
            l1 = l / 3600L;
            l -= 3600L * l1;
        }
        if(l >= 60L) {
            l2 = l / 60L;
            l -= 60L * l2;
        }
        long l3 = l;
        String s;
        if(l1 > 0L)
            s = formatElapsedTime(stringbuilder, sElapsedFormatHMMSS, l1, l2, l3);
        else
            s = formatElapsedTime(stringbuilder, sElapsedFormatMMSS, l2, l3);
        return s;
    }

    private static String formatElapsedTime(StringBuilder stringbuilder, String s, long l, long l1) {
        String s1;
        if("%1$02d:%2$02d".equals(s)) {
            StringBuilder stringbuilder1 = stringbuilder;
            if(stringbuilder1 == null)
                stringbuilder1 = new StringBuilder(8);
            else
                stringbuilder1.setLength(0);
            if(l < 10L)
                stringbuilder1.append('0');
            else
                stringbuilder1.append(toDigitChar(l / 10L));
            stringbuilder1.append(toDigitChar(l % 10L));
            stringbuilder1.append(':');
            if(l1 < 10L)
                stringbuilder1.append('0');
            else
                stringbuilder1.append(toDigitChar(l1 / 10L));
            stringbuilder1.append(toDigitChar(l1 % 10L));
            s1 = stringbuilder1.toString();
        } else {
            Object aobj[] = new Object[2];
            aobj[0] = Long.valueOf(l);
            aobj[1] = Long.valueOf(l1);
            s1 = String.format(s, aobj);
        }
        return s1;
    }

    private static String formatElapsedTime(StringBuilder stringbuilder, String s, long l, long l1, long l2) {
        String s1;
        if("%1$d:%2$02d:%3$02d".equals(s)) {
            StringBuilder stringbuilder1 = stringbuilder;
            if(stringbuilder1 == null)
                stringbuilder1 = new StringBuilder(8);
            else
                stringbuilder1.setLength(0);
            stringbuilder1.append(l);
            stringbuilder1.append(':');
            if(l1 < 10L)
                stringbuilder1.append('0');
            else
                stringbuilder1.append(toDigitChar(l1 / 10L));
            stringbuilder1.append(toDigitChar(l1 % 10L));
            stringbuilder1.append(':');
            if(l2 < 10L)
                stringbuilder1.append('0');
            else
                stringbuilder1.append(toDigitChar(l2 / 10L));
            stringbuilder1.append(toDigitChar(l2 % 10L));
            s1 = stringbuilder1.toString();
        } else {
            Object aobj[] = new Object[3];
            aobj[0] = Long.valueOf(l);
            aobj[1] = Long.valueOf(l1);
            aobj[2] = Long.valueOf(l2);
            s1 = String.format(s, aobj);
        }
        return s1;
    }

    public static final CharSequence formatSameDayTime(long l, long l1, int i, int j) {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTimeInMillis(l);
        java.util.Date date = gregoriancalendar.getTime();
        GregorianCalendar gregoriancalendar1 = new GregorianCalendar();
        gregoriancalendar1.setTimeInMillis(l1);
        DateFormat dateformat;
        if(gregoriancalendar.get(1) == gregoriancalendar1.get(1) && gregoriancalendar.get(2) == gregoriancalendar1.get(2) && gregoriancalendar.get(5) == gregoriancalendar1.get(5))
            dateformat = DateFormat.getTimeInstance(j);
        else
            dateformat = DateFormat.getDateInstance(i);
        return dateformat.format(date);
    }

    public static String getAMPMString(int i) {
        return Resources.getSystem().getString(sAmPm[i + 0]);
    }

    public static String getDayOfWeekString(int i, int j) {
        j;
        JVM INSTR lookupswitch 5: default 52
    //                   10: 68
    //                   20: 75
    //                   30: 82
    //                   40: 89
    //                   50: 96;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        int ai[] = sDaysMedium;
_L8:
        return Resources.getSystem().getString(ai[i - 1]);
_L2:
        ai = sDaysLong;
        continue; /* Loop/switch isn't completed */
_L3:
        ai = sDaysMedium;
        continue; /* Loop/switch isn't completed */
_L4:
        ai = sDaysShort;
        continue; /* Loop/switch isn't completed */
_L5:
        ai = sDaysShort;
        continue; /* Loop/switch isn't completed */
_L6:
        ai = sDaysShortest;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static String getMonthString(int i, int j) {
        j;
        JVM INSTR lookupswitch 5: default 52
    //                   10: 68
    //                   20: 75
    //                   30: 82
    //                   40: 89
    //                   50: 96;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        int ai[] = sMonthsMedium;
_L8:
        return Resources.getSystem().getString(ai[i + 0]);
_L2:
        ai = sMonthsLong;
        continue; /* Loop/switch isn't completed */
_L3:
        ai = sMonthsMedium;
        continue; /* Loop/switch isn't completed */
_L4:
        ai = sMonthsMedium;
        continue; /* Loop/switch isn't completed */
_L5:
        ai = sMonthsMedium;
        continue; /* Loop/switch isn't completed */
_L6:
        ai = sMonthsShortest;
        if(true) goto _L8; else goto _L7
_L7:
    }

    /**
     * @deprecated Method getNumberOfDaysPassed is deprecated
     */

    private static long getNumberOfDaysPassed(long l, long l1) {
        android/text/format/DateUtils;
        JVM INSTR monitorenter ;
        int j;
        if(sThenTime == null)
            sThenTime = new Time();
        sThenTime.set(l);
        int i = Time.getJulianDay(l, sThenTime.gmtoff);
        sThenTime.set(l1);
        j = Math.abs(Time.getJulianDay(l1, sThenTime.gmtoff) - i);
        long l2 = j;
        android/text/format/DateUtils;
        JVM INSTR monitorexit ;
        return l2;
        Exception exception;
        exception;
        throw exception;
    }

    public static CharSequence getRelativeDateTimeString(Context context, long l, long l1, long l2, int i) {
        Resources resources = Resources.getSystem();
        long l3 = System.currentTimeMillis();
        long l4 = Math.abs(l3 - l);
        String s;
        String s1;
        if(l2 > 0x240c8400L)
            l2 = 0x240c8400L;
        else
        if(l2 < 0x5265c00L)
            l2 = 0x5265c00L;
        s = formatDateRange(context, l, l, 1);
        if(l4 < l2) {
            CharSequence charsequence1 = getRelativeTimeSpanString(l, l3, l1, i);
            Object aobj1[] = new Object[2];
            aobj1[0] = charsequence1;
            aobj1[1] = s;
            s1 = resources.getString(0x10403b6, aobj1);
        } else {
            CharSequence charsequence = getRelativeTimeSpanString(context, l, false);
            Object aobj[] = new Object[2];
            aobj[0] = charsequence;
            aobj[1] = s;
            s1 = resources.getString(0x1040089, aobj);
        }
        return s1;
    }

    private static final String getRelativeDayString(Resources resources, long l, long l1) {
        Time time = new Time();
        time.set(l);
        Time time1 = new Time();
        time1.set(l1);
        int i = Time.getJulianDay(l, time.gmtoff);
        int j = Math.abs(Time.getJulianDay(l1, time1.gmtoff) - i);
        boolean flag;
        String s1;
        if(l1 > l)
            flag = true;
        else
            flag = false;
        if(j == 1) {
            if(flag)
                s1 = resources.getString(0x104007b);
            else
                s1 = resources.getString(0x104007d);
        } else
        if(j == 0) {
            s1 = resources.getString(0x104007c);
        } else {
            int k;
            String s;
            Object aobj[];
            if(flag)
                k = 0x1130004;
            else
                k = 0x1130008;
            s = resources.getQuantityString(k, j);
            aobj = new Object[1];
            aobj[0] = Integer.valueOf(j);
            s1 = String.format(s, aobj);
        }
        return s1;
    }

    public static CharSequence getRelativeTimeSpanString(long l) {
        return getRelativeTimeSpanString(l, System.currentTimeMillis(), 60000L);
    }

    public static CharSequence getRelativeTimeSpanString(long l, long l1, long l2) {
        return getRelativeTimeSpanString(l, l1, l2, 0x10014);
    }

    public static CharSequence getRelativeTimeSpanString(long l, long l1, long l2, int i) {
        String s;
        Resources resources = Resources.getSystem();
        boolean flag;
        boolean flag1;
        long l3;
        long l4;
        int j;
        if((0xc0000 & i) != 0)
            flag = true;
        else
            flag = false;
        if(l1 >= l)
            flag1 = true;
        else
            flag1 = false;
        l3 = Math.abs(l1 - l);
        if(l3 < 60000L && l2 < 60000L) {
            l4 = l3 / 1000L;
            String s1;
            Object aobj[];
            if(flag1) {
                if(flag)
                    j = 0x1130009;
                else
                    j = 0x1130000;
            } else
            if(flag)
                j = 0x113000d;
            else
                j = 0x1130005;
        } else
        if(l3 < 0x36ee80L && l2 < 0x36ee80L) {
            l4 = l3 / 60000L;
            if(flag1) {
                if(flag)
                    j = 0x113000a;
                else
                    j = 0x1130001;
            } else
            if(flag)
                j = 0x113000e;
            else
                j = 0x1130006;
        } else
        if(l3 < 0x5265c00L && l2 < 0x5265c00L) {
            l4 = l3 / 0x36ee80L;
            if(flag1) {
                if(flag)
                    j = 0x113000b;
                else
                    j = 0x1130002;
            } else
            if(flag)
                j = 0x113000f;
            else
                j = 0x1130007;
        } else {
label0:
            {
                if(l3 >= 0x240c8400L || l2 >= 0x240c8400L)
                    break label0;
                l4 = getNumberOfDaysPassed(l, l1);
                if(flag1) {
                    if(flag)
                        j = 0x113000c;
                    else
                        j = 0x1130004;
                } else
                if(flag)
                    j = 0x1130010;
                else
                    j = 0x1130008;
            }
        }
        s1 = resources.getQuantityString(j, (int)l4);
        aobj = new Object[1];
        aobj[0] = Long.valueOf(l4);
        s = String.format(s1, aobj);
_L2:
        return s;
        s = formatDateRange(null, l, l, i);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static CharSequence getRelativeTimeSpanString(Context context, long l) {
        return getRelativeTimeSpanString(context, l, false);
    }

    public static CharSequence getRelativeTimeSpanString(Context context, long l, boolean flag) {
        long l1 = System.currentTimeMillis();
        long l2 = l1 - l;
        android/text/format/DateUtils;
        JVM INSTR monitorenter ;
        if(sNowTime == null)
            sNowTime = new Time();
        if(sThenTime == null)
            sThenTime = new Time();
        sNowTime.set(l1);
        sThenTime.set(l);
        String s;
        int i;
        if(l2 < 0x5265c00L && sNowTime.weekDay == sThenTime.weekDay) {
            s = formatDateRange(context, l, l, 1);
            i = 0x10403a8;
        } else
        if(sNowTime.year != sThenTime.year) {
            s = formatDateRange(context, l, l, 0x20014);
            i = 0x10403a7;
        } else {
            s = formatDateRange(context, l, l, 0x10010);
            i = 0x10403a7;
        }
        if(flag) {
            Resources resources = context.getResources();
            Object aobj[] = new Object[1];
            aobj[0] = s;
            s = resources.getString(i, aobj);
        }
        return s;
    }

    public static String getStandaloneMonthString(int i, int j) {
        j;
        JVM INSTR lookupswitch 5: default 52
    //                   10: 68
    //                   20: 75
    //                   30: 82
    //                   40: 89
    //                   50: 96;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        int ai[] = sMonthsMedium;
_L8:
        return Resources.getSystem().getString(ai[i + 0]);
_L2:
        ai = sMonthsStandaloneLong;
        continue; /* Loop/switch isn't completed */
_L3:
        ai = sMonthsMedium;
        continue; /* Loop/switch isn't completed */
_L4:
        ai = sMonthsMedium;
        continue; /* Loop/switch isn't completed */
_L5:
        ai = sMonthsMedium;
        continue; /* Loop/switch isn't completed */
_L6:
        ai = sMonthsShortest;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private static void initFormatStrings() {
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        initFormatStringsLocked();
        return;
    }

    private static void initFormatStringsLocked() {
        Resources resources = Resources.getSystem();
        Configuration configuration = resources.getConfiguration();
        if(sLastConfig == null || !sLastConfig.equals(configuration)) {
            sLastConfig = configuration;
            sStatusTimeFormat = DateFormat.getTimeInstance(3);
            sElapsedFormatMMSS = resources.getString(0x10403bb);
            sElapsedFormatHMMSS = resources.getString(0x10403bc);
        }
    }

    public static boolean isToday(long l) {
        Time time = new Time();
        time.set(l);
        int i = time.year;
        int j = time.month;
        int k = time.monthDay;
        time.set(System.currentTimeMillis());
        boolean flag;
        if(i == time.year && j == time.month && k == time.monthDay)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isUTC(String s) {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        if((s.length() != 16 || s.charAt(15) != 'Z') && (s.length() != 9 || s.charAt(8) != 'Z'))
            flag = false;
        return flag;
    }

    public static Calendar newCalendar(boolean flag) {
        Calendar calendar;
        if(flag)
            calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        else
            calendar = Calendar.getInstance();
        return calendar;
    }

    public static final CharSequence timeString(long l) {
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        initFormatStringsLocked();
        String s = sStatusTimeFormat.format(Long.valueOf(l));
        return s;
    }

    private static char toDigitChar(long l) {
        return (char)(int)(48L + l);
    }

    public static String writeDateTime(Calendar calendar) {
        GregorianCalendar gregoriancalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregoriancalendar.setTimeInMillis(calendar.getTimeInMillis());
        return writeDateTime(((Calendar) (gregoriancalendar)), true);
    }

    public static String writeDateTime(Calendar calendar, StringBuilder stringbuilder) {
        int i = calendar.get(1);
        stringbuilder.setCharAt(3, (char)(48 + i % 10));
        int j = i / 10;
        stringbuilder.setCharAt(2, (char)(48 + j % 10));
        int k = j / 10;
        stringbuilder.setCharAt(1, (char)(48 + k % 10));
        stringbuilder.setCharAt(0, (char)(48 + (k / 10) % 10));
        int l = 1 + calendar.get(2);
        stringbuilder.setCharAt(5, (char)(48 + l % 10));
        stringbuilder.setCharAt(4, (char)(48 + (l / 10) % 10));
        int i1 = calendar.get(5);
        stringbuilder.setCharAt(7, (char)(48 + i1 % 10));
        stringbuilder.setCharAt(6, (char)(48 + (i1 / 10) % 10));
        stringbuilder.setCharAt(8, 'T');
        int j1 = calendar.get(11);
        stringbuilder.setCharAt(10, (char)(48 + j1 % 10));
        stringbuilder.setCharAt(9, (char)(48 + (j1 / 10) % 10));
        int k1 = calendar.get(12);
        stringbuilder.setCharAt(12, (char)(48 + k1 % 10));
        stringbuilder.setCharAt(11, (char)(48 + (k1 / 10) % 10));
        int l1 = calendar.get(13);
        stringbuilder.setCharAt(14, (char)(48 + l1 % 10));
        stringbuilder.setCharAt(13, (char)(48 + (l1 / 10) % 10));
        return stringbuilder.toString();
    }

    public static String writeDateTime(Calendar calendar, boolean flag) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.ensureCapacity(16);
        if(flag) {
            stringbuilder.setLength(16);
            stringbuilder.setCharAt(15, 'Z');
        } else {
            stringbuilder.setLength(15);
        }
        return writeDateTime(calendar, stringbuilder);
    }

    public static final String ABBREV_MONTH_FORMAT = "%b";
    public static final String ABBREV_WEEKDAY_FORMAT = "%a";
    public static final long DAY_IN_MILLIS = 0x5265c00L;
    private static final String FAST_FORMAT_HMMSS = "%1$d:%2$02d:%3$02d";
    private static final String FAST_FORMAT_MMSS = "%1$02d:%2$02d";
    public static final int FORMAT_12HOUR = 64;
    public static final int FORMAT_24HOUR = 128;
    public static final int FORMAT_ABBREV_ALL = 0x80000;
    public static final int FORMAT_ABBREV_MONTH = 0x10000;
    public static final int FORMAT_ABBREV_RELATIVE = 0x40000;
    public static final int FORMAT_ABBREV_TIME = 16384;
    public static final int FORMAT_ABBREV_WEEKDAY = 32768;
    public static final int FORMAT_CAP_AMPM = 256;
    public static final int FORMAT_CAP_MIDNIGHT = 4096;
    public static final int FORMAT_CAP_NOON = 1024;
    public static final int FORMAT_CAP_NOON_MIDNIGHT = 5120;
    public static final int FORMAT_NO_MIDNIGHT = 2048;
    public static final int FORMAT_NO_MONTH_DAY = 32;
    public static final int FORMAT_NO_NOON = 512;
    public static final int FORMAT_NO_NOON_MIDNIGHT = 2560;
    public static final int FORMAT_NO_YEAR = 8;
    public static final int FORMAT_NUMERIC_DATE = 0x20000;
    public static final int FORMAT_SHOW_DATE = 16;
    public static final int FORMAT_SHOW_TIME = 1;
    public static final int FORMAT_SHOW_WEEKDAY = 2;
    public static final int FORMAT_SHOW_YEAR = 4;
    public static final int FORMAT_UTC = 8192;
    public static final long HOUR_IN_MILLIS = 0x36ee80L;
    public static final String HOUR_MINUTE_24 = "%H:%M";
    public static final int LENGTH_LONG = 10;
    public static final int LENGTH_MEDIUM = 20;
    public static final int LENGTH_SHORT = 30;
    public static final int LENGTH_SHORTER = 40;
    public static final int LENGTH_SHORTEST = 50;
    public static final long MINUTE_IN_MILLIS = 60000L;
    public static final String MONTH_DAY_FORMAT = "%-d";
    public static final String MONTH_FORMAT = "%B";
    public static final String NUMERIC_MONTH_FORMAT = "%m";
    public static final long SECOND_IN_MILLIS = 1000L;
    private static final char TIME_PADDING = 48;
    private static final char TIME_SEPARATOR = 58;
    public static final String WEEKDAY_FORMAT = "%A";
    public static final long WEEK_IN_MILLIS = 0x240c8400L;
    public static final String YEAR_FORMAT = "%Y";
    public static final String YEAR_FORMAT_TWO_DIGITS = "%g";
    public static final long YEAR_IN_MILLIS = 0x7528ad000L;
    private static final int sAmPm[];
    private static final int sDaysLong[];
    private static final int sDaysMedium[];
    private static final int sDaysShort[];
    private static final int sDaysShortest[];
    private static String sElapsedFormatHMMSS;
    private static String sElapsedFormatMMSS;
    private static Configuration sLastConfig;
    private static final Object sLock = new Object();
    private static final int sMonthsLong[];
    private static final int sMonthsMedium[];
    private static final int sMonthsShortest[];
    private static final int sMonthsStandaloneLong[];
    private static Time sNowTime;
    private static DateFormat sStatusTimeFormat;
    private static Time sThenTime;
    public static final int sameMonthTable[];
    public static final int sameYearTable[];

    static  {
        int ai[] = new int[7];
        ai[0] = 0x104005d;
        ai[1] = 0x104005e;
        ai[2] = 0x104005f;
        ai[3] = 0x1040060;
        ai[4] = 0x1040061;
        ai[5] = 0x1040062;
        ai[6] = 0x1040063;
        sDaysLong = ai;
        int ai1[] = new int[7];
        ai1[0] = 0x1040064;
        ai1[1] = 0x1040065;
        ai1[2] = 0x1040066;
        ai1[3] = 0x1040067;
        ai1[4] = 0x1040068;
        ai1[5] = 0x1040069;
        ai1[6] = 0x104006a;
        sDaysMedium = ai1;
        int ai2[] = new int[7];
        ai2[0] = 0x104006b;
        ai2[1] = 0x104006c;
        ai2[2] = 0x104006d;
        ai2[3] = 0x104006e;
        ai2[4] = 0x104006f;
        ai2[5] = 0x1040070;
        ai2[6] = 0x1040071;
        sDaysShort = ai2;
        int ai3[] = new int[7];
        ai3[0] = 0x1040072;
        ai3[1] = 0x1040073;
        ai3[2] = 0x1040074;
        ai3[3] = 0x1040075;
        ai3[4] = 0x1040076;
        ai3[5] = 0x1040077;
        ai3[6] = 0x1040078;
        sDaysShortest = ai3;
        int ai4[] = new int[12];
        ai4[0] = 0x104002d;
        ai4[1] = 0x104002e;
        ai4[2] = 0x104002f;
        ai4[3] = 0x1040030;
        ai4[4] = 0x1040031;
        ai4[5] = 0x1040032;
        ai4[6] = 0x1040033;
        ai4[7] = 0x1040034;
        ai4[8] = 0x1040035;
        ai4[9] = 0x1040036;
        ai4[10] = 0x1040037;
        ai4[11] = 0x1040038;
        sMonthsStandaloneLong = ai4;
        int ai5[] = new int[12];
        ai5[0] = 0x1040039;
        ai5[1] = 0x104003a;
        ai5[2] = 0x104003b;
        ai5[3] = 0x104003c;
        ai5[4] = 0x104003d;
        ai5[5] = 0x104003e;
        ai5[6] = 0x104003f;
        ai5[7] = 0x1040040;
        ai5[8] = 0x1040041;
        ai5[9] = 0x1040042;
        ai5[10] = 0x1040043;
        ai5[11] = 0x1040044;
        sMonthsLong = ai5;
        int ai6[] = new int[12];
        ai6[0] = 0x1040045;
        ai6[1] = 0x1040046;
        ai6[2] = 0x1040047;
        ai6[3] = 0x1040048;
        ai6[4] = 0x1040049;
        ai6[5] = 0x104004a;
        ai6[6] = 0x104004b;
        ai6[7] = 0x104004c;
        ai6[8] = 0x104004d;
        ai6[9] = 0x104004e;
        ai6[10] = 0x104004f;
        ai6[11] = 0x1040050;
        sMonthsMedium = ai6;
        int ai7[] = new int[12];
        ai7[0] = 0x1040051;
        ai7[1] = 0x1040052;
        ai7[2] = 0x1040053;
        ai7[3] = 0x1040054;
        ai7[4] = 0x1040055;
        ai7[5] = 0x1040056;
        ai7[6] = 0x1040057;
        ai7[7] = 0x1040058;
        ai7[8] = 0x1040059;
        ai7[9] = 0x104005a;
        ai7[10] = 0x104005b;
        ai7[11] = 0x104005c;
        sMonthsShortest = ai7;
        int ai8[] = new int[2];
        ai8[0] = 0x1040079;
        ai8[1] = 0x104007a;
        sAmPm = ai8;
        int ai9[] = new int[16];
        ai9[0] = 0x10400a2;
        ai9[1] = 0x10400a3;
        ai9[2] = 0x10400af;
        ai9[3] = 0x10400b1;
        ai9[4] = 0x10400a4;
        ai9[5] = 0x10400a6;
        ai9[6] = 0x10400a8;
        ai9[7] = 0x10400aa;
        ai9[8] = 0x1040094;
        ai9[9] = 0x1040095;
        ai9[10] = 0x1040096;
        ai9[11] = 0x1040097;
        ai9[12] = 0x1040099;
        ai9[13] = 0x104009a;
        ai9[14] = 0x104009b;
        ai9[15] = 0x1040098;
        sameYearTable = ai9;
        int ai10[] = new int[16];
        ai10[0] = 0x10400ad;
        ai10[1] = 0x10400ae;
        ai10[2] = 0x10400b0;
        ai10[3] = 0x10400ac;
        ai10[4] = 0x10400a5;
        ai10[5] = 0x10400a7;
        ai10[6] = 0x10400a9;
        ai10[7] = 0x10400ab;
        ai10[8] = 0x1040094;
        ai10[9] = 0x1040095;
        ai10[10] = 0x1040096;
        ai10[11] = 0x1040097;
        ai10[12] = 0x1040099;
        ai10[13] = 0x104009a;
        ai10[14] = 0x104009b;
        ai10[15] = 0x1040098;
        sameMonthTable = ai10;
    }
}
