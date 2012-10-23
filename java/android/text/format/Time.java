// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.format;

import android.content.res.Resources;
import java.util.Locale;
import java.util.TimeZone;

public class Time {

    public Time() {
        this(TimeZone.getDefault().getID());
    }

    public Time(Time time) {
        set(time);
    }

    public Time(String s) {
        if(s == null) {
            throw new NullPointerException("timezone is null!");
        } else {
            timezone = s;
            year = 1970;
            monthDay = 1;
            isDst = -1;
            return;
        }
    }

    public static int compare(Time time, Time time1) {
        if(time == null)
            throw new NullPointerException("a == null");
        if(time1 == null)
            throw new NullPointerException("b == null");
        else
            return nativeCompare(time, time1);
    }

    private native String format1(String s);

    public static String getCurrentTimezone() {
        return TimeZone.getDefault().getID();
    }

    public static int getJulianDay(long l, long l1) {
        return 0x253d8c + (int)((l + l1 * 1000L) / 0x5265c00L);
    }

    public static int getJulianMondayFromWeeksSinceEpoch(int i) {
        return 0x253d89 + i * 7;
    }

    public static int getWeeksSinceEpochFromJulianDay(int i, int j) {
        int k = 4 - j;
        if(k < 0)
            k += 7;
        return (i - (0x253d8c - k)) / 7;
    }

    public static boolean isEpoch(Time time) {
        boolean flag = true;
        if(getJulianDay(time.toMillis(flag), 0L) != 0x253d8c)
            flag = false;
        return flag;
    }

    private static native int nativeCompare(Time time, Time time1);

    private native boolean nativeParse(String s);

    private native boolean nativeParse3339(String s);

    public boolean after(Time time) {
        boolean flag;
        if(compare(this, time) > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean before(Time time) {
        boolean flag;
        if(compare(this, time) < 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void clear(String s) {
        if(s == null) {
            throw new NullPointerException("timezone is null!");
        } else {
            timezone = s;
            allDay = false;
            second = 0;
            minute = 0;
            hour = 0;
            monthDay = 0;
            month = 0;
            year = 0;
            weekDay = 0;
            yearDay = 0;
            gmtoff = 0L;
            isDst = -1;
            return;
        }
    }

    public String format(String s) {
        android/text/format/Time;
        JVM INSTR monitorenter ;
        Locale locale = Locale.getDefault();
        if(sLocale == null || locale == null || !locale.equals(sLocale)) {
            Resources resources = Resources.getSystem();
            String as[] = new String[12];
            as[0] = resources.getString(0x1040045);
            as[1] = resources.getString(0x1040046);
            as[2] = resources.getString(0x1040047);
            as[3] = resources.getString(0x1040048);
            as[4] = resources.getString(0x1040049);
            as[5] = resources.getString(0x104004a);
            as[6] = resources.getString(0x104004b);
            as[7] = resources.getString(0x104004c);
            as[8] = resources.getString(0x104004d);
            as[9] = resources.getString(0x104004e);
            as[10] = resources.getString(0x104004f);
            as[11] = resources.getString(0x1040050);
            sShortMonths = as;
            String as1[] = new String[12];
            as1[0] = resources.getString(0x1040039);
            as1[1] = resources.getString(0x104003a);
            as1[2] = resources.getString(0x104003b);
            as1[3] = resources.getString(0x104003c);
            as1[4] = resources.getString(0x104003d);
            as1[5] = resources.getString(0x104003e);
            as1[6] = resources.getString(0x104003f);
            as1[7] = resources.getString(0x1040040);
            as1[8] = resources.getString(0x1040041);
            as1[9] = resources.getString(0x1040042);
            as1[10] = resources.getString(0x1040043);
            as1[11] = resources.getString(0x1040044);
            sLongMonths = as1;
            String as2[] = new String[12];
            as2[0] = resources.getString(0x104002d);
            as2[1] = resources.getString(0x104002e);
            as2[2] = resources.getString(0x104002f);
            as2[3] = resources.getString(0x1040030);
            as2[4] = resources.getString(0x1040031);
            as2[5] = resources.getString(0x1040032);
            as2[6] = resources.getString(0x1040033);
            as2[7] = resources.getString(0x1040034);
            as2[8] = resources.getString(0x1040035);
            as2[9] = resources.getString(0x1040036);
            as2[10] = resources.getString(0x1040037);
            as2[11] = resources.getString(0x1040038);
            sLongStandaloneMonths = as2;
            String as3[] = new String[7];
            as3[0] = resources.getString(0x1040064);
            as3[1] = resources.getString(0x1040065);
            as3[2] = resources.getString(0x1040066);
            as3[3] = resources.getString(0x1040067);
            as3[4] = resources.getString(0x1040068);
            as3[5] = resources.getString(0x1040069);
            as3[6] = resources.getString(0x104006a);
            sShortWeekdays = as3;
            String as4[] = new String[7];
            as4[0] = resources.getString(0x104005d);
            as4[1] = resources.getString(0x104005e);
            as4[2] = resources.getString(0x104005f);
            as4[3] = resources.getString(0x1040060);
            as4[4] = resources.getString(0x1040061);
            as4[5] = resources.getString(0x1040062);
            as4[6] = resources.getString(0x1040063);
            sLongWeekdays = as4;
            sTimeOnlyFormat = resources.getString(0x1040087);
            sDateOnlyFormat = resources.getString(0x1040086);
            sDateTimeFormat = resources.getString(0x1040088);
            sAm = resources.getString(0x1040079);
            sPm = resources.getString(0x104007a);
            sLocale = locale;
        }
        String s1 = format1(s);
        return s1;
    }

    public native String format2445();

    public String format3339(boolean flag) {
        String s2;
        if(flag)
            s2 = format("%Y-%m-%d");
        else
        if("UTC".equals(timezone)) {
            s2 = format("%Y-%m-%dT%H:%M:%S.000Z");
        } else {
            String s = format("%Y-%m-%dT%H:%M:%S.000");
            String s1;
            int i;
            int j;
            int k;
            Object aobj[];
            if(gmtoff < 0L)
                s1 = "-";
            else
                s1 = "+";
            i = (int)Math.abs(gmtoff);
            j = (i % 3600) / 60;
            k = i / 3600;
            aobj = new Object[4];
            aobj[0] = s;
            aobj[1] = s1;
            aobj[2] = Integer.valueOf(k);
            aobj[3] = Integer.valueOf(j);
            s2 = String.format("%s%s%02d:%02d", aobj);
        }
        return s2;
    }

    public int getActualMaximum(int i) {
        int j = 28;
        i;
        JVM INSTR tableswitch 1 9: default 56
    //                   1 84
    //                   2 89
    //                   3 95
    //                   4 101
    //                   5 159
    //                   6 165
    //                   7 172
    //                   8 178
    //                   9 218;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        throw new RuntimeException((new StringBuilder()).append("bad field=").append(i).toString());
_L2:
        j = 59;
_L11:
        return j;
_L3:
        j = 59;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 23;
        continue; /* Loop/switch isn't completed */
_L5:
        int l = DAYS_PER_MONTH[month];
        if(l != j) {
            j = l;
        } else {
            int i1 = year;
            if(i1 % 4 == 0 && (i1 % 100 != 0 || i1 % 400 == 0))
                j = 29;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        j = 11;
        continue; /* Loop/switch isn't completed */
_L7:
        j = 2037;
        continue; /* Loop/switch isn't completed */
_L8:
        j = 6;
        continue; /* Loop/switch isn't completed */
_L9:
        int k = year;
        if(k % 4 == 0 && (k % 100 != 0 || k % 400 == 0))
            j = 365;
        else
            j = 364;
        if(true) goto _L11; else goto _L10
_L10:
        throw new RuntimeException("WEEK_NUM not implemented");
    }

    public int getWeekNumber() {
        int i = yearDay + sThursdayOffset[weekDay];
        int j;
        if(i >= 0 && i <= 364) {
            j = 1 + i / 7;
        } else {
            Time time = new Time(this);
            time.monthDay = time.monthDay + sThursdayOffset[weekDay];
            time.normalize(true);
            j = 1 + time.yearDay / 7;
        }
        return j;
    }

    public native long normalize(boolean flag);

    public boolean parse(String s) {
        boolean flag;
        if(nativeParse(s)) {
            timezone = "UTC";
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean parse3339(String s) {
        if(s == null)
            throw new NullPointerException("time string is null");
        boolean flag;
        if(nativeParse3339(s)) {
            timezone = "UTC";
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void set(int i, int j, int k) {
        allDay = true;
        second = 0;
        minute = 0;
        hour = 0;
        monthDay = i;
        month = j;
        year = k;
        weekDay = 0;
        yearDay = 0;
        isDst = -1;
        gmtoff = 0L;
    }

    public void set(int i, int j, int k, int l, int i1, int j1) {
        allDay = false;
        second = i;
        minute = j;
        hour = k;
        monthDay = l;
        month = i1;
        year = j1;
        weekDay = 0;
        yearDay = 0;
        isDst = -1;
        gmtoff = 0L;
    }

    public native void set(long l);

    public void set(Time time) {
        timezone = time.timezone;
        allDay = time.allDay;
        second = time.second;
        minute = time.minute;
        hour = time.hour;
        monthDay = time.monthDay;
        month = time.month;
        year = time.year;
        weekDay = time.weekDay;
        yearDay = time.yearDay;
        isDst = time.isDst;
        gmtoff = time.gmtoff;
    }

    public long setJulianDay(int i) {
        long l = 0x5265c00L * (long)(i - 0x253d8c);
        set(l);
        monthDay = (i - getJulianDay(l, gmtoff)) + monthDay;
        hour = 0;
        minute = 0;
        second = 0;
        return normalize(true);
    }

    public native void setToNow();

    public native void switchTimezone(String s);

    public native long toMillis(boolean flag);

    public native String toString();

    private static final int DAYS_PER_MONTH[];
    public static final int EPOCH_JULIAN_DAY = 0x253d8c;
    public static final int FRIDAY = 5;
    public static final int HOUR = 3;
    public static final int MINUTE = 2;
    public static final int MONDAY = 1;
    public static final int MONDAY_BEFORE_JULIAN_EPOCH = 0x253d89;
    public static final int MONTH = 5;
    public static final int MONTH_DAY = 4;
    public static final int SATURDAY = 6;
    public static final int SECOND = 1;
    public static final int SUNDAY = 0;
    public static final int THURSDAY = 4;
    public static final String TIMEZONE_UTC = "UTC";
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int WEEK_DAY = 7;
    public static final int WEEK_NUM = 9;
    public static final int YEAR = 6;
    public static final int YEAR_DAY = 8;
    private static final String Y_M_D = "%Y-%m-%d";
    private static final String Y_M_D_T_H_M_S_000 = "%Y-%m-%dT%H:%M:%S.000";
    private static final String Y_M_D_T_H_M_S_000_Z = "%Y-%m-%dT%H:%M:%S.000Z";
    private static String sAm;
    private static String sDateCommand = "%a %b %e %H:%M:%S %Z %Y";
    private static String sDateOnlyFormat;
    private static String sDateTimeFormat;
    private static Locale sLocale;
    private static String sLongMonths[];
    private static String sLongStandaloneMonths[];
    private static String sLongWeekdays[];
    private static String sPm;
    private static String sShortMonths[];
    private static String sShortWeekdays[];
    private static final int sThursdayOffset[];
    private static String sTimeOnlyFormat;
    public boolean allDay;
    public long gmtoff;
    public int hour;
    public int isDst;
    public int minute;
    public int month;
    public int monthDay;
    public int second;
    public String timezone;
    public int weekDay;
    public int year;
    public int yearDay;

    static  {
        int ai[] = new int[12];
        ai[0] = 31;
        ai[1] = 28;
        ai[2] = 31;
        ai[3] = 30;
        ai[4] = 31;
        ai[5] = 30;
        ai[6] = 31;
        ai[7] = 31;
        ai[8] = 30;
        ai[9] = 31;
        ai[10] = 30;
        ai[11] = 31;
        DAYS_PER_MONTH = ai;
        int ai1[] = new int[7];
        ai1[0] = -3;
        ai1[1] = 3;
        ai1[2] = 2;
        ai1[3] = 1;
        ai1[4] = 0;
        ai1[5] = -1;
        ai1[6] = -2;
        sThursdayOffset = ai1;
    }
}
