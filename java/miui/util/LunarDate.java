// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LunarDate {

    public LunarDate() {
    }

    public static final long[] calLunar(int i, int j, int k) {
        long al[] = new long[7];
        int l = 0;
        long l1 = getDayOffset(i, j, k);
        al[5] = 40L + l1;
        al[4] = 14L;
        int i1;
        for(i1 = 1900; i1 < 2050 && l1 > 0L; i1++) {
            l = yrDays(i1);
            l1 -= l;
            al[4] = 12L + al[4];
        }

        if(l1 < 0L) {
            l1 += l;
            i1--;
            al[4] = al[4] - 12L;
        }
        al[0] = i1;
        al[3] = i1 - 1864;
        int j1 = rMonth(i1);
        al[6] = 0L;
        int k1 = 1;
        while(k1 < 13 && l1 > 0L)  {
            if(j1 > 0 && k1 == j1 + 1 && al[6] == 0L) {
                k1--;
                al[6] = 1L;
                l = rMthDays((int)al[0]);
            } else {
                l = mthDays((int)al[0], k1);
            }
            if(al[6] == 1L && k1 == j1 + 1)
                al[6] = 0L;
            l1 -= l;
            if(al[6] == 0L)
                al[4] = 1L + al[4];
            k1++;
        }
        if(l1 == 0L && j1 > 0 && k1 == j1 + 1)
            if(al[6] == 1L) {
                al[6] = 0L;
            } else {
                al[6] = 1L;
                k1--;
                al[4] = al[4] - 1L;
            }
        if(l1 < 0L) {
            l1 += l;
            k1--;
            al[4] = al[4] - 1L;
        }
        al[1] = k1;
        al[2] = 1L + l1;
        return al;
    }

    public static String formatLunarDate(int i, int j, int k) {
        StringBuilder stringbuilder = new StringBuilder();
        if(i > 0) {
            stringbuilder.append(i);
            stringbuilder.append("-");
        }
        stringbuilder.append(j + 1);
        stringbuilder.append("-");
        stringbuilder.append(k);
        return stringbuilder.toString();
    }

    private static final int getDayOffset(int i, int j, int k) {
        int l = 0;
        GregorianCalendar gregoriancalendar = (GregorianCalendar)Calendar.getInstance();
        gregoriancalendar.clear();
        int i1 = 1900;
        while(i1 < i)  {
            if(gregoriancalendar.isLeapYear(i1))
                l += 366;
            else
                l += 365;
            i1++;
        }
        gregoriancalendar.set(i, j, k);
        int j1 = l + gregoriancalendar.get(6);
        gregoriancalendar.set(1900, 0, 31);
        return j1 - gregoriancalendar.get(6);
    }

    public static final String getDayString(Resources resources, int i) {
        String s = "";
        if(i != 10) goto _L2; else goto _L1
_L1:
        String s1 = resources.getString(0x60c0051);
_L14:
        return s1;
_L2:
        if(i == 20) {
            s1 = resources.getString(0x60c0052);
            continue; /* Loop/switch isn't completed */
        }
        if(i == 30) {
            s1 = resources.getString(0x60c0053);
            continue; /* Loop/switch isn't completed */
        }
        int j = i / 10;
        if(j == 0)
            s = resources.getString(0x60c0054);
        if(j == 1)
            s = resources.getString(0x60c004e);
        if(j == 2)
            s = resources.getString(0x60c0055);
        if(j == 3)
            s = resources.getString(0x60c0047);
        i % 10;
        JVM INSTR tableswitch 1 9: default 168
    //                   1 174
    //                   2 202
    //                   3 230
    //                   4 258
    //                   5 286
    //                   6 314
    //                   7 342
    //                   8 370
    //                   9 398;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_398;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L15:
        s1 = s;
        if(true) goto _L14; else goto _L13
_L13:
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c0045)).toString();
          goto _L15
_L5:
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c0046)).toString();
          goto _L15
_L6:
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c0047)).toString();
          goto _L15
_L7:
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c0048)).toString();
          goto _L15
_L8:
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c0049)).toString();
          goto _L15
_L9:
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c004a)).toString();
          goto _L15
_L10:
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c004b)).toString();
          goto _L15
_L11:
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c004c)).toString();
          goto _L15
        s = (new StringBuilder()).append(s).append(resources.getString(0x60c004d)).toString();
          goto _L15
    }

    private static String getDigitString(Resources resources, int i) {
        i;
        JVM INSTR tableswitch 0 9: default 56
    //                   0 62
    //                   1 73
    //                   2 84
    //                   3 95
    //                   4 106
    //                   5 117
    //                   6 128
    //                   7 139
    //                   8 150
    //                   9 161;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        String s = "";
_L13:
        return s;
_L2:
        s = resources.getString(0x60c0044);
        continue; /* Loop/switch isn't completed */
_L3:
        s = resources.getString(0x60c0045);
        continue; /* Loop/switch isn't completed */
_L4:
        s = resources.getString(0x60c0046);
        continue; /* Loop/switch isn't completed */
_L5:
        s = resources.getString(0x60c0047);
        continue; /* Loop/switch isn't completed */
_L6:
        s = resources.getString(0x60c0048);
        continue; /* Loop/switch isn't completed */
_L7:
        s = resources.getString(0x60c0049);
        continue; /* Loop/switch isn't completed */
_L8:
        s = resources.getString(0x60c004a);
        continue; /* Loop/switch isn't completed */
_L9:
        s = resources.getString(0x60c004b);
        continue; /* Loop/switch isn't completed */
_L10:
        s = resources.getString(0x60c004c);
        continue; /* Loop/switch isn't completed */
_L11:
        s = resources.getString(0x60c004d);
        if(true) goto _L13; else goto _L12
_L12:
    }

    public static String getHoliday(Resources resources, long al[], Calendar calendar) {
        String s = null;
        int i;
        int j;
        int k;
        int l;
        i = 1 + calendar.get(2);
        j = calendar.get(5);
        k = solarHolidaysTable.length;
        l = 0;
_L9:
        if(l >= k) goto _L2; else goto _L1
_L1:
        if(solarHolidaysTable[l] / 100 != i || solarHolidaysTable[l] % 100 != j)
            break MISSING_BLOCK_LABEL_172;
        s = resources.getString(solarHolidays[l]);
          goto _L3
_L2:
        if(al[6] == 1L) goto _L3; else goto _L4
_L4:
        int i1;
        int j1;
        int k1;
        int l1;
        i1 = (int)al[1];
        j1 = (int)al[2];
        k1 = lunarHolidaysTable.length;
        l1 = 0;
_L8:
        if(l1 >= k1) goto _L3; else goto _L5
_L5:
        if(lunarHolidaysTable[l1] / 100 != i1 || lunarHolidaysTable[l1] % 100 != j1) goto _L7; else goto _L6
_L6:
        String s1 = resources.getString(lunarHolidays[l1]);
        s = s1;
          goto _L3
_L7:
        l1++;
          goto _L8
        Exception exception;
        exception;
        throw exception;
_L3:
        return s;
        l++;
          goto _L9
    }

    public static int[][] getLunarBirthdays(int i, int j, int k) {
        int l = 0;
        int i1 = j + 1;
        int ai[][];
        if(i1 > 12) {
            if(i1 - 12 == rMonth(i)) {
                ai = new int[2][];
                int l1 = Math.min(rMthDays(i), k);
                int ai3[] = lunarToSolar(i, i1, l1);
                int ai4[] = new int[4];
                ai4[l] = ai3[0];
                ai4[1] = -1 + ai3[1];
                ai4[2] = ai3[2];
                int j1;
                int ai1[];
                int k1;
                int ai2[];
                int i2;
                if(l1 == k)
                    i2 = 0;
                else
                    i2 = 1;
                ai4[3] = i2;
                ai[l] = ai4;
            } else {
                ai = new int[1][];
            }
            i1 -= 12;
        } else {
            ai = new int[1][];
        }
        j1 = Math.min(mthDays(i, i1), k);
        ai1 = lunarToSolar(i, i1, j1);
        k1 = -1 + ai.length;
        ai2 = new int[4];
        ai2[l] = ai1[0];
        ai2[1] = -1 + ai1[1];
        ai2[2] = ai1[2];
        if(j1 != k)
            l = 1;
        ai2[3] = l;
        ai[k1] = ai2;
        return ai;
    }

    private static int getLunarNewYearOffsetDays(int i, int j, int k) {
        int l = 0;
        int i1 = rMonth(i);
        if(i1 > 0 && i1 == j - 12) {
            j = i1;
            l = 0 + mthDays(i, j);
        }
        for(int j1 = 1; j1 < j; j1++) {
            l += mthDays(i, j1);
            if(j1 == i1)
                l += rMthDays(i);
        }

        return l + (k - 1);
    }

    public static String getLunarString(Resources resources, int i, int j, int k) {
        StringBuilder stringbuilder = new StringBuilder();
        if(i > 0)
            stringbuilder.append(Integer.toString(i)).append(resources.getString(0x60c0057));
        if(j >= 12) {
            stringbuilder.append(resources.getString(0x60c0043));
            j -= 12;
        }
        stringbuilder.append(getMonthString(resources, j + 1));
        stringbuilder.append(resources.getString(0x60c0056));
        stringbuilder.append(getDayString(resources, k));
        return stringbuilder.toString();
    }

    public static String getMonthString(Resources resources, int i) {
        String s = null;
        if(i <= 12) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        switch(i) {
        case 0: // '\0'
            s = "";
            break;

        case 1: // '\001'
            s = resources.getString(0x60c0042);
            break;

        case 2: // '\002'
            s = resources.getString(0x60c0046);
            break;

        case 3: // '\003'
            s = resources.getString(0x60c0047);
            break;

        case 4: // '\004'
            s = resources.getString(0x60c0048);
            break;

        case 5: // '\005'
            s = resources.getString(0x60c0049);
            break;

        case 6: // '\006'
            s = resources.getString(0x60c004a);
            break;

        case 7: // '\007'
            s = resources.getString(0x60c004b);
            break;

        case 8: // '\b'
            s = resources.getString(0x60c004c);
            break;

        case 9: // '\t'
            s = resources.getString(0x60c004d);
            break;

        case 10: // '\n'
            s = resources.getString(0x60c004e);
            break;

        case 11: // '\013'
            s = resources.getString(0x60c004f);
            break;

        case 12: // '\f'
            s = resources.getString(0x60c0050);
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static long getNextLunarBirthday(int i, int j) {
        Time time = new Time();
        time.setToNow();
        int k = (int)calLunar(time.year, time.month, time.monthDay)[0];
        time.second = 0;
        time.minute = 0;
        time.hour = 0;
        long l = time.normalize(false);
        long l1;
        for(l1 = 0x7fffffffffffffffL; 0x7fffffffffffffffL == l1 && k >= 1900 && k < 2050; k++) {
            int ai[][] = getLunarBirthdays(k, i, j);
            int i1 = ai.length;
            for(int j1 = 0; j1 < i1; j1++) {
                int ai1[] = ai[j1];
                time.set(ai1[2], ai1[1], ai1[0]);
                long l2 = time.normalize(false);
                if(l2 >= l)
                    l1 = Math.min(l1, l2);
            }

        }

        if(0x7fffffffffffffffL == l1)
            l1 = 0L;
        return l1;
    }

    public static String getSolarTerm(Resources resources, Calendar calendar) {
        int i = calendar.get(1);
        int j = calendar.get(2);
        int k = calendar.get(5);
        char c = solarTermsTable[j + 12 * (i - 1901)];
        String s;
        if(k == 15 + c % 16)
            s = resources.getString(solarTerms[1 + j * 2]);
        else
        if(k == 15 - c / 16)
            s = resources.getString(solarTerms[j * 2]);
        else
            s = null;
        return s;
    }

    static int getSolarYearMonthDays(int i, int j) {
        byte byte0;
        if(j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12)
            byte0 = 31;
        else
        if(j == 4 || j == 6 || j == 9 || j == 11)
            byte0 = 30;
        else
        if(j == 2) {
            if(isSolarLeapYear(i))
                byte0 = 29;
            else
                byte0 = 28;
        } else {
            byte0 = 0;
        }
        return byte0;
    }

    public static String getString(Resources resources, Calendar calendar) {
        return solar2lunar(resources, calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public static String getYearString(Resources resources, int i) {
        StringBuffer stringbuffer = new StringBuffer();
        int j = i;
        do {
            int k = j % 10;
            j /= 10;
            stringbuffer.insert(0, getDigitString(resources, k));
        } while(j > 0);
        return stringbuffer.toString();
    }

    static boolean isSolarLeapYear(int i) {
        boolean flag;
        if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static int[] lunarToSolar(int i, int j, int k) {
        int ai[] = new int[3];
        int l = getLunarNewYearOffsetDays(i, j, k) + iSolarLunarOffsetTable[i - 1901];
        char c;
        int i1;
        int j1;
        int k1;
        if(isSolarLeapYear(i))
            c = '\u016E';
        else
            c = '\u016D';
        if(l >= c) {
            i1 = i + 1;
            l -= c;
        } else {
            i1 = i;
        }
        j1 = l + 1;
        for(k1 = 1; l >= 0; k1++) {
            j1 = l + 1;
            l -= getSolarYearMonthDays(i1, k1);
        }

        int l1 = k1 - 1;
        ai[0] = i1;
        ai[1] = l1;
        ai[2] = j1;
        return ai;
    }

    public static final int mthDays(int i, int j) {
        byte byte0;
        if((luYearData[i - 1900] & (long)(0x10000 >> j)) == 0L)
            byte0 = 29;
        else
            byte0 = 30;
        return byte0;
    }

    public static int[] parseLunarDate(String s) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int ai[] = null;
_L4:
        return ai;
_L2:
        String as[];
        ai = new int[3];
        try {
            as = s.split("-");
            if(as.length == 2) {
                ai[0] = Integer.parseInt(as[1].trim());
                ai[1] = -1 + Integer.parseInt(as[0].trim());
                ai[2] = 0;
                continue; /* Loop/switch isn't completed */
            }
        }
        catch(NumberFormatException numberformatexception) {
            numberformatexception.printStackTrace();
            ai = null;
            continue; /* Loop/switch isn't completed */
        }
        if(as.length == 3) {
            ai[0] = Integer.parseInt(as[2].trim());
            ai[1] = -1 + Integer.parseInt(as[1].trim());
            ai[2] = Integer.parseInt(as[0].trim());
            continue; /* Loop/switch isn't completed */
        }
        ai = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final int rMonth(int i) {
        return (int)(15L & luYearData[i - 1900]);
    }

    public static final int rMthDays(int i) {
        byte byte0;
        if(rMonth(i) != 0) {
            if((0x10000L & luYearData[i - 1900]) != 0L)
                byte0 = 30;
            else
                byte0 = 29;
        } else {
            byte0 = 0;
        }
        return byte0;
    }

    public static String solar2lunar(Resources resources, int i, int j, int k) {
        long al[];
        StringBuffer stringbuffer;
        al = calLunar(i, j, k);
        stringbuffer = new StringBuffer();
        String s;
        if(al[6] == 1L)
            stringbuffer.append(resources.getString(0x60c0043));
        stringbuffer.append(getMonthString(resources, (int)al[1]));
        stringbuffer.append(resources.getString(0x60c0056));
        stringbuffer.append(getDayString(resources, (int)al[2]));
        s = stringbuffer.toString();
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    private static final int yrDays(int i) {
        int j = 348;
        for(int k = 32768; k > 8; k >>= 1)
            if((luYearData[i - 1900] & (long)k) != 0L)
                j++;

        return j + rMthDays(i);
    }

    public static final int MAX_LUNAR_YEAR = 2050;
    public static final int MIN_LUNAR_YEAR = 1900;
    private static final char iSolarLunarOffsetTable[];
    private static final long luYearData[];
    private static int lunarHolidays[];
    private static int lunarHolidaysTable[];
    private static int solarHolidays[];
    private static int solarHolidaysTable[];
    private static int solarTerms[];
    private static char solarTermsTable[];

    static  {
        long al[] = new long[150];
        al[0] = 19416L;
        al[1] = 19168L;
        al[2] = 42352L;
        al[3] = 21717L;
        al[4] = 53856L;
        al[5] = 55632L;
        al[6] = 0x16554L;
        al[7] = 22176L;
        al[8] = 39632L;
        al[9] = 21970L;
        al[10] = 19168L;
        al[11] = 42422L;
        al[12] = 42192L;
        al[13] = 53840L;
        al[14] = 0x1d255L;
        al[15] = 46400L;
        al[16] = 54944L;
        al[17] = 44450L;
        al[18] = 38320L;
        al[19] = 0x14977L;
        al[20] = 18800L;
        al[21] = 42160L;
        al[22] = 46261L;
        al[23] = 27216L;
        al[24] = 27968L;
        al[25] = 0x1ab54L;
        al[26] = 11104L;
        al[27] = 38256L;
        al[28] = 21234L;
        al[29] = 18800L;
        al[30] = 25958L;
        al[31] = 54432L;
        al[32] = 59984L;
        al[33] = 28309L;
        al[34] = 23248L;
        al[35] = 11104L;
        al[36] = 0x186e3L;
        al[37] = 37600L;
        al[38] = 0x1c8d7L;
        al[39] = 51536L;
        al[40] = 54432L;
        al[41] = 0x1d8a6L;
        al[42] = 46416L;
        al[43] = 22176L;
        al[44] = 0x1a5b4L;
        al[45] = 9680L;
        al[46] = 37584L;
        al[47] = 53938L;
        al[48] = 43344L;
        al[49] = 46423L;
        al[50] = 27808L;
        al[51] = 46416L;
        al[52] = 0x15355L;
        al[53] = 19872L;
        al[54] = 42448L;
        al[55] = 0x14573L;
        al[56] = 21200L;
        al[57] = 43432L;
        al[58] = 59728L;
        al[59] = 27296L;
        al[60] = 44710L;
        al[61] = 43856L;
        al[62] = 19296L;
        al[63] = 43748L;
        al[64] = 42352L;
        al[65] = 21088L;
        al[66] = 62051L;
        al[67] = 55632L;
        al[68] = 23383L;
        al[69] = 22176L;
        al[70] = 38608L;
        al[71] = 19925L;
        al[72] = 19152L;
        al[73] = 42192L;
        al[74] = 54484L;
        al[75] = 53840L;
        al[76] = 54616L;
        al[77] = 46400L;
        al[78] = 46496L;
        al[79] = 0x195a6L;
        al[80] = 38320L;
        al[81] = 18864L;
        al[82] = 43380L;
        al[83] = 42160L;
        al[84] = 45690L;
        al[85] = 27216L;
        al[86] = 27968L;
        al[87] = 44870L;
        al[88] = 43872L;
        al[89] = 38256L;
        al[90] = 19189L;
        al[91] = 18800L;
        al[92] = 25776L;
        al[93] = 29859L;
        al[94] = 59984L;
        al[95] = 27480L;
        al[96] = 21952L;
        al[97] = 43872L;
        al[98] = 38613L;
        al[99] = 37600L;
        al[100] = 51552L;
        al[101] = 55636L;
        al[102] = 54432L;
        al[103] = 55888L;
        al[104] = 30034L;
        al[105] = 22176L;
        al[106] = 43959L;
        al[107] = 9680L;
        al[108] = 37584L;
        al[109] = 51893L;
        al[110] = 43344L;
        al[111] = 46240L;
        al[112] = 47780L;
        al[113] = 44368L;
        al[114] = 21977L;
        al[115] = 19360L;
        al[116] = 42416L;
        al[117] = 0x15176L;
        al[118] = 21168L;
        al[119] = 43312L;
        al[120] = 31060L;
        al[121] = 27296L;
        al[122] = 44368L;
        al[123] = 23378L;
        al[124] = 19296L;
        al[125] = 42726L;
        al[126] = 42208L;
        al[127] = 53856L;
        al[128] = 60005L;
        al[129] = 54576L;
        al[130] = 23200L;
        al[131] = 30371L;
        al[132] = 38608L;
        al[133] = 19415L;
        al[134] = 19152L;
        al[135] = 42192L;
        al[136] = 0x1d0b6L;
        al[137] = 53840L;
        al[138] = 54560L;
        al[139] = 56645L;
        al[140] = 46496L;
        al[141] = 22224L;
        al[142] = 21938L;
        al[143] = 18864L;
        al[144] = 42359L;
        al[145] = 42160L;
        al[146] = 43600L;
        al[147] = 0x1b255L;
        al[148] = 27936L;
        al[149] = 44448L;
        luYearData = al;
        char ac[] = new char[150];
        ac[0] = '1';
        ac[1] = '&';
        ac[2] = '\034';
        ac[3] = '.';
        ac[4] = '"';
        ac[5] = '\030';
        ac[6] = '+';
        ac[7] = ' ';
        ac[8] = '\025';
        ac[9] = '(';
        ac[10] = '\035';
        ac[11] = '0';
        ac[12] = '$';
        ac[13] = '\031';
        ac[14] = ',';
        ac[15] = '!';
        ac[16] = '\026';
        ac[17] = ')';
        ac[18] = '\037';
        ac[19] = '2';
        ac[20] = '&';
        ac[21] = '\033';
        ac[22] = '.';
        ac[23] = '#';
        ac[24] = '\027';
        ac[25] = '+';
        ac[26] = ' ';
        ac[27] = '\026';
        ac[28] = '(';
        ac[29] = '\035';
        ac[30] = '/';
        ac[31] = '$';
        ac[32] = '\031';
        ac[33] = ',';
        ac[34] = '"';
        ac[35] = '\027';
        ac[36] = ')';
        ac[37] = '\036';
        ac[38] = '1';
        ac[39] = '&';
        ac[40] = '\032';
        ac[41] = '-';
        ac[42] = '#';
        ac[43] = '\030';
        ac[44] = '+';
        ac[45] = ' ';
        ac[46] = '\025';
        ac[47] = '(';
        ac[48] = '\034';
        ac[49] = '/';
        ac[50] = '$';
        ac[51] = '\032';
        ac[52] = ',';
        ac[53] = '!';
        ac[54] = '\027';
        ac[55] = '*';
        ac[56] = '\036';
        ac[57] = '0';
        ac[58] = '&';
        ac[59] = '\033';
        ac[60] = '-';
        ac[61] = '#';
        ac[62] = '\030';
        ac[63] = '+';
        ac[64] = ' ';
        ac[65] = '\024';
        ac[66] = '\'';
        ac[67] = '\035';
        ac[68] = '/';
        ac[69] = '$';
        ac[70] = '\032';
        ac[71] = '-';
        ac[72] = '!';
        ac[73] = '\026';
        ac[74] = ')';
        ac[75] = '\036';
        ac[76] = '0';
        ac[77] = '%';
        ac[78] = '\033';
        ac[79] = '.';
        ac[80] = '#';
        ac[81] = '\030';
        ac[82] = '+';
        ac[83] = ' ';
        ac[84] = '2';
        ac[85] = '\'';
        ac[86] = '\034';
        ac[87] = '/';
        ac[88] = '$';
        ac[89] = '\032';
        ac[90] = '-';
        ac[91] = '"';
        ac[92] = '\026';
        ac[93] = '(';
        ac[94] = '\036';
        ac[95] = '1';
        ac[96] = '%';
        ac[97] = '\033';
        ac[98] = '.';
        ac[99] = '#';
        ac[100] = '\027';
        ac[101] = '*';
        ac[102] = '\037';
        ac[103] = '\025';
        ac[104] = '\'';
        ac[105] = '\034';
        ac[106] = '0';
        ac[107] = '%';
        ac[108] = '\031';
        ac[109] = ',';
        ac[110] = '!';
        ac[111] = '\026';
        ac[112] = '(';
        ac[113] = '\036';
        ac[114] = '1';
        ac[115] = '&';
        ac[116] = '\033';
        ac[117] = '.';
        ac[118] = '#';
        ac[119] = '\030';
        ac[120] = '*';
        ac[121] = '\037';
        ac[122] = '\025';
        ac[123] = '(';
        ac[124] = '\034';
        ac[125] = '/';
        ac[126] = '$';
        ac[127] = '\031';
        ac[128] = '+';
        ac[129] = '!';
        ac[130] = '\026';
        ac[131] = ')';
        ac[132] = '\036';
        ac[133] = '1';
        ac[134] = '&';
        ac[135] = '\033';
        ac[136] = '-';
        ac[137] = '"';
        ac[138] = '\027';
        ac[139] = '*';
        ac[140] = '\037';
        ac[141] = '\025';
        ac[142] = '(';
        ac[143] = '\035';
        ac[144] = '/';
        ac[145] = '$';
        ac[146] = '\031';
        ac[147] = ',';
        ac[148] = ' ';
        ac[149] = '\026';
        iSolarLunarOffsetTable = ac;
        int ai[] = new int[7];
        ai[0] = 101;
        ai[1] = 115;
        ai[2] = 505;
        ai[3] = 707;
        ai[4] = 815;
        ai[5] = 909;
        ai[6] = 1208;
        lunarHolidaysTable = ai;
        int ai1[] = new int[13];
        ai1[0] = 101;
        ai1[1] = 214;
        ai1[2] = 308;
        ai1[3] = 312;
        ai1[4] = 401;
        ai1[5] = 501;
        ai1[6] = 504;
        ai1[7] = 601;
        ai1[8] = 701;
        ai1[9] = 801;
        ai1[10] = 910;
        ai1[11] = 1001;
        ai1[12] = 1225;
        solarHolidaysTable = ai1;
        int ai2[] = new int[7];
        ai2[0] = 0x60c0058;
        ai2[1] = 0x60c0059;
        ai2[2] = 0x60c005a;
        ai2[3] = 0x60c005b;
        ai2[4] = 0x60c005c;
        ai2[5] = 0x60c005d;
        ai2[6] = 0x60c005e;
        lunarHolidays = ai2;
        int ai3[] = new int[13];
        ai3[0] = 0x60c005f;
        ai3[1] = 0x60c0060;
        ai3[2] = 0x60c0061;
        ai3[3] = 0x60c0062;
        ai3[4] = 0x60c0063;
        ai3[5] = 0x60c0064;
        ai3[6] = 0x60c0065;
        ai3[7] = 0x60c0066;
        ai3[8] = 0x60c0067;
        ai3[9] = 0x60c0068;
        ai3[10] = 0x60c0069;
        ai3[11] = 0x60c006a;
        ai3[12] = 0x60c006b;
        solarHolidays = ai3;
        int ai4[] = new int[24];
        ai4[0] = 0x60c006c;
        ai4[1] = 0x60c006d;
        ai4[2] = 0x60c006e;
        ai4[3] = 0x60c006f;
        ai4[4] = 0x60c0070;
        ai4[5] = 0x60c0071;
        ai4[6] = 0x60c0072;
        ai4[7] = 0x60c0073;
        ai4[8] = 0x60c0074;
        ai4[9] = 0x60c0075;
        ai4[10] = 0x60c0076;
        ai4[11] = 0x60c0077;
        ai4[12] = 0x60c0078;
        ai4[13] = 0x60c0079;
        ai4[14] = 0x60c007a;
        ai4[15] = 0x60c007b;
        ai4[16] = 0x60c007c;
        ai4[17] = 0x60c007d;
        ai4[18] = 0x60c007e;
        ai4[19] = 0x60c007f;
        ai4[20] = 0x60c0080;
        ai4[21] = 0x60c0081;
        ai4[22] = 0x60c0082;
        ai4[23] = 0x60c0083;
        solarTerms = ai4;
        char ac1[] = new char[1800];
        ac1[0] = '\226';
        ac1[1] = '\264';
        ac1[2] = '\226';
        ac1[3] = '\246';
        ac1[4] = '\227';
        ac1[5] = '\227';
        ac1[6] = 'x';
        ac1[7] = 'y';
        ac1[8] = 'y';
        ac1[9] = 'i';
        ac1[10] = 'x';
        ac1[11] = 'w';
        ac1[12] = '\226';
        ac1[13] = '\244';
        ac1[14] = '\226';
        ac1[15] = '\226';
        ac1[16] = '\227';
        ac1[17] = '\207';
        ac1[18] = 'y';
        ac1[19] = 'y';
        ac1[20] = 'y';
        ac1[21] = 'i';
        ac1[22] = 'x';
        ac1[23] = 'x';
        ac1[24] = '\226';
        ac1[25] = '\245';
        ac1[26] = '\207';
        ac1[27] = '\226';
        ac1[28] = '\207';
        ac1[29] = '\207';
        ac1[30] = 'y';
        ac1[31] = 'i';
        ac1[32] = 'i';
        ac1[33] = 'i';
        ac1[34] = 'x';
        ac1[35] = 'x';
        ac1[36] = '\206';
        ac1[37] = '\245';
        ac1[38] = '\226';
        ac1[39] = '\245';
        ac1[40] = '\226';
        ac1[41] = '\227';
        ac1[42] = '\210';
        ac1[43] = 'x';
        ac1[44] = 'x';
        ac1[45] = 'y';
        ac1[46] = 'x';
        ac1[47] = '\207';
        ac1[48] = '\226';
        ac1[49] = '\264';
        ac1[50] = '\226';
        ac1[51] = '\246';
        ac1[52] = '\227';
        ac1[53] = '\227';
        ac1[54] = 'x';
        ac1[55] = 'y';
        ac1[56] = 'y';
        ac1[57] = 'i';
        ac1[58] = 'x';
        ac1[59] = 'w';
        ac1[60] = '\226';
        ac1[61] = '\244';
        ac1[62] = '\226';
        ac1[63] = '\226';
        ac1[64] = '\227';
        ac1[65] = '\227';
        ac1[66] = 'y';
        ac1[67] = 'y';
        ac1[68] = 'y';
        ac1[69] = 'i';
        ac1[70] = 'x';
        ac1[71] = 'x';
        ac1[72] = '\226';
        ac1[73] = '\245';
        ac1[74] = '\207';
        ac1[75] = '\226';
        ac1[76] = '\207';
        ac1[77] = '\207';
        ac1[78] = 'y';
        ac1[79] = 'i';
        ac1[80] = 'i';
        ac1[81] = 'i';
        ac1[82] = 'x';
        ac1[83] = 'x';
        ac1[84] = '\206';
        ac1[85] = '\245';
        ac1[86] = '\226';
        ac1[87] = '\245';
        ac1[88] = '\226';
        ac1[89] = '\227';
        ac1[90] = '\210';
        ac1[91] = 'x';
        ac1[92] = 'x';
        ac1[93] = 'i';
        ac1[94] = 'x';
        ac1[95] = '\207';
        ac1[96] = '\226';
        ac1[97] = '\264';
        ac1[98] = '\226';
        ac1[99] = '\246';
        ac1[100] = '\227';
        ac1[101] = '\227';
        ac1[102] = 'x';
        ac1[103] = 'y';
        ac1[104] = 'y';
        ac1[105] = 'i';
        ac1[106] = 'x';
        ac1[107] = 'w';
        ac1[108] = '\226';
        ac1[109] = '\244';
        ac1[110] = '\226';
        ac1[111] = '\226';
        ac1[112] = '\227';
        ac1[113] = '\227';
        ac1[114] = 'y';
        ac1[115] = 'y';
        ac1[116] = 'y';
        ac1[117] = 'i';
        ac1[118] = 'x';
        ac1[119] = 'x';
        ac1[120] = '\226';
        ac1[121] = '\245';
        ac1[122] = '\207';
        ac1[123] = '\226';
        ac1[124] = '\207';
        ac1[125] = '\207';
        ac1[126] = 'y';
        ac1[127] = 'i';
        ac1[128] = 'i';
        ac1[129] = 'i';
        ac1[130] = 'x';
        ac1[131] = 'x';
        ac1[132] = '\206';
        ac1[133] = '\245';
        ac1[134] = '\226';
        ac1[135] = '\245';
        ac1[136] = '\226';
        ac1[137] = '\227';
        ac1[138] = '\210';
        ac1[139] = 'x';
        ac1[140] = 'x';
        ac1[141] = 'i';
        ac1[142] = 'x';
        ac1[143] = '\207';
        ac1[144] = '\225';
        ac1[145] = '\264';
        ac1[146] = '\226';
        ac1[147] = '\246';
        ac1[148] = '\227';
        ac1[149] = '\227';
        ac1[150] = 'x';
        ac1[151] = 'y';
        ac1[152] = 'y';
        ac1[153] = 'i';
        ac1[154] = 'x';
        ac1[155] = 'w';
        ac1[156] = '\226';
        ac1[157] = '\264';
        ac1[158] = '\226';
        ac1[159] = '\246';
        ac1[160] = '\227';
        ac1[161] = '\227';
        ac1[162] = 'y';
        ac1[163] = 'y';
        ac1[164] = 'y';
        ac1[165] = 'i';
        ac1[166] = 'x';
        ac1[167] = 'x';
        ac1[168] = '\226';
        ac1[169] = '\245';
        ac1[170] = '\227';
        ac1[171] = '\226';
        ac1[172] = '\227';
        ac1[173] = '\207';
        ac1[174] = 'y';
        ac1[175] = 'y';
        ac1[176] = 'i';
        ac1[177] = 'i';
        ac1[178] = 'x';
        ac1[179] = 'x';
        ac1[180] = '\226';
        ac1[181] = '\245';
        ac1[182] = '\226';
        ac1[183] = '\245';
        ac1[184] = '\226';
        ac1[185] = '\227';
        ac1[186] = '\210';
        ac1[187] = 'x';
        ac1[188] = 'x';
        ac1[189] = 'y';
        ac1[190] = 'w';
        ac1[191] = '\207';
        ac1[192] = '\225';
        ac1[193] = '\264';
        ac1[194] = '\226';
        ac1[195] = '\246';
        ac1[196] = '\226';
        ac1[197] = '\227';
        ac1[198] = 'x';
        ac1[199] = 'y';
        ac1[200] = 'x';
        ac1[201] = 'i';
        ac1[202] = 'x';
        ac1[203] = '\207';
        ac1[204] = '\226';
        ac1[205] = '\264';
        ac1[206] = '\226';
        ac1[207] = '\246';
        ac1[208] = '\227';
        ac1[209] = '\227';
        ac1[210] = 'y';
        ac1[211] = 'y';
        ac1[212] = 'y';
        ac1[213] = 'i';
        ac1[214] = 'x';
        ac1[215] = 'w';
        ac1[216] = '\226';
        ac1[217] = '\245';
        ac1[218] = '\227';
        ac1[219] = '\226';
        ac1[220] = '\227';
        ac1[221] = '\207';
        ac1[222] = 'y';
        ac1[223] = 'y';
        ac1[224] = 'i';
        ac1[225] = 'i';
        ac1[226] = 'x';
        ac1[227] = 'x';
        ac1[228] = '\226';
        ac1[229] = '\245';
        ac1[230] = '\226';
        ac1[231] = '\245';
        ac1[232] = '\226';
        ac1[233] = '\227';
        ac1[234] = '\210';
        ac1[235] = 'x';
        ac1[236] = 'x';
        ac1[237] = 'y';
        ac1[238] = 'w';
        ac1[239] = '\207';
        ac1[240] = '\225';
        ac1[241] = '\264';
        ac1[242] = '\226';
        ac1[243] = '\245';
        ac1[244] = '\226';
        ac1[245] = '\227';
        ac1[246] = 'x';
        ac1[247] = 'y';
        ac1[248] = 'x';
        ac1[249] = 'i';
        ac1[250] = 'x';
        ac1[251] = '\207';
        ac1[252] = '\226';
        ac1[253] = '\264';
        ac1[254] = '\226';
        ac1[255] = '\246';
        ac1[256] = '\227';
        ac1[257] = '\227';
        ac1[258] = 'y';
        ac1[259] = 'y';
        ac1[260] = 'y';
        ac1[261] = 'i';
        ac1[262] = 'x';
        ac1[263] = 'w';
        ac1[264] = '\226';
        ac1[265] = '\244';
        ac1[266] = '\226';
        ac1[267] = '\226';
        ac1[268] = '\227';
        ac1[269] = '\207';
        ac1[270] = 'y';
        ac1[271] = 'y';
        ac1[272] = 'i';
        ac1[273] = 'i';
        ac1[274] = 'x';
        ac1[275] = 'x';
        ac1[276] = '\226';
        ac1[277] = '\245';
        ac1[278] = '\226';
        ac1[279] = '\245';
        ac1[280] = '\226';
        ac1[281] = '\227';
        ac1[282] = '\210';
        ac1[283] = 'x';
        ac1[284] = 'x';
        ac1[285] = 'y';
        ac1[286] = 'w';
        ac1[287] = '\207';
        ac1[288] = '\225';
        ac1[289] = '\264';
        ac1[290] = '\226';
        ac1[291] = '\245';
        ac1[292] = '\226';
        ac1[293] = '\227';
        ac1[294] = 'x';
        ac1[295] = 'y';
        ac1[296] = 'x';
        ac1[297] = 'i';
        ac1[298] = 'x';
        ac1[299] = '\207';
        ac1[300] = '\226';
        ac1[301] = '\264';
        ac1[302] = '\226';
        ac1[303] = '\246';
        ac1[304] = '\227';
        ac1[305] = '\227';
        ac1[306] = 'x';
        ac1[307] = 'y';
        ac1[308] = 'y';
        ac1[309] = 'i';
        ac1[310] = 'x';
        ac1[311] = 'w';
        ac1[312] = '\226';
        ac1[313] = '\244';
        ac1[314] = '\226';
        ac1[315] = '\226';
        ac1[316] = '\227';
        ac1[317] = '\207';
        ac1[318] = 'y';
        ac1[319] = 'y';
        ac1[320] = 'y';
        ac1[321] = 'i';
        ac1[322] = 'x';
        ac1[323] = 'x';
        ac1[324] = '\226';
        ac1[325] = '\245';
        ac1[326] = '\226';
        ac1[327] = '\245';
        ac1[328] = '\226';
        ac1[329] = '\226';
        ac1[330] = '\210';
        ac1[331] = 'x';
        ac1[332] = 'x';
        ac1[333] = 'x';
        ac1[334] = '\207';
        ac1[335] = '\207';
        ac1[336] = '\225';
        ac1[337] = '\264';
        ac1[338] = '\226';
        ac1[339] = '\245';
        ac1[340] = '\226';
        ac1[341] = '\227';
        ac1[342] = '\210';
        ac1[343] = 'x';
        ac1[344] = 'x';
        ac1[345] = 'y';
        ac1[346] = 'w';
        ac1[347] = '\207';
        ac1[348] = '\226';
        ac1[349] = '\264';
        ac1[350] = '\226';
        ac1[351] = '\246';
        ac1[352] = '\227';
        ac1[353] = '\227';
        ac1[354] = 'x';
        ac1[355] = 'y';
        ac1[356] = 'y';
        ac1[357] = 'i';
        ac1[358] = 'x';
        ac1[359] = 'w';
        ac1[360] = '\226';
        ac1[361] = '\244';
        ac1[362] = '\226';
        ac1[363] = '\226';
        ac1[364] = '\227';
        ac1[365] = '\207';
        ac1[366] = 'y';
        ac1[367] = 'y';
        ac1[368] = 'y';
        ac1[369] = 'i';
        ac1[370] = 'x';
        ac1[371] = 'x';
        ac1[372] = '\226';
        ac1[373] = '\245';
        ac1[374] = '\226';
        ac1[375] = '\245';
        ac1[376] = '\226';
        ac1[377] = '\226';
        ac1[378] = '\210';
        ac1[379] = 'x';
        ac1[380] = 'x';
        ac1[381] = 'x';
        ac1[382] = '\207';
        ac1[383] = '\207';
        ac1[384] = '\225';
        ac1[385] = '\264';
        ac1[386] = '\226';
        ac1[387] = '\245';
        ac1[388] = '\226';
        ac1[389] = '\227';
        ac1[390] = '\210';
        ac1[391] = 'x';
        ac1[392] = 'x';
        ac1[393] = 'i';
        ac1[394] = 'x';
        ac1[395] = '\207';
        ac1[396] = '\226';
        ac1[397] = '\264';
        ac1[398] = '\226';
        ac1[399] = '\246';
        ac1[400] = '\227';
        ac1[401] = '\227';
        ac1[402] = 'x';
        ac1[403] = 'y';
        ac1[404] = 'y';
        ac1[405] = 'i';
        ac1[406] = 'x';
        ac1[407] = 'w';
        ac1[408] = '\226';
        ac1[409] = '\244';
        ac1[410] = '\226';
        ac1[411] = '\226';
        ac1[412] = '\227';
        ac1[413] = '\227';
        ac1[414] = 'y';
        ac1[415] = 'y';
        ac1[416] = 'y';
        ac1[417] = 'i';
        ac1[418] = 'x';
        ac1[419] = 'x';
        ac1[420] = '\226';
        ac1[421] = '\245';
        ac1[422] = '\226';
        ac1[423] = '\245';
        ac1[424] = '\226';
        ac1[425] = '\226';
        ac1[426] = '\210';
        ac1[427] = 'x';
        ac1[428] = 'x';
        ac1[429] = 'x';
        ac1[430] = '\207';
        ac1[431] = '\207';
        ac1[432] = '\225';
        ac1[433] = '\264';
        ac1[434] = '\226';
        ac1[435] = '\245';
        ac1[436] = '\226';
        ac1[437] = '\227';
        ac1[438] = '\210';
        ac1[439] = 'x';
        ac1[440] = 'x';
        ac1[441] = 'i';
        ac1[442] = 'x';
        ac1[443] = '\207';
        ac1[444] = '\226';
        ac1[445] = '\264';
        ac1[446] = '\226';
        ac1[447] = '\246';
        ac1[448] = '\227';
        ac1[449] = '\227';
        ac1[450] = 'x';
        ac1[451] = 'y';
        ac1[452] = 'y';
        ac1[453] = 'i';
        ac1[454] = 'x';
        ac1[455] = 'w';
        ac1[456] = '\226';
        ac1[457] = '\244';
        ac1[458] = '\226';
        ac1[459] = '\226';
        ac1[460] = '\227';
        ac1[461] = '\227';
        ac1[462] = 'y';
        ac1[463] = 'y';
        ac1[464] = 'y';
        ac1[465] = 'i';
        ac1[466] = 'x';
        ac1[467] = 'x';
        ac1[468] = '\226';
        ac1[469] = '\245';
        ac1[470] = '\226';
        ac1[471] = '\245';
        ac1[472] = '\226';
        ac1[473] = '\226';
        ac1[474] = '\210';
        ac1[475] = 'x';
        ac1[476] = 'x';
        ac1[477] = 'x';
        ac1[478] = '\207';
        ac1[479] = '\207';
        ac1[480] = '\225';
        ac1[481] = '\264';
        ac1[482] = '\226';
        ac1[483] = '\245';
        ac1[484] = '\226';
        ac1[485] = '\227';
        ac1[486] = '\210';
        ac1[487] = 'x';
        ac1[488] = 'x';
        ac1[489] = 'i';
        ac1[490] = 'x';
        ac1[491] = '\207';
        ac1[492] = '\226';
        ac1[493] = '\264';
        ac1[494] = '\226';
        ac1[495] = '\246';
        ac1[496] = '\227';
        ac1[497] = '\227';
        ac1[498] = 'x';
        ac1[499] = 'y';
        ac1[500] = 'y';
        ac1[501] = 'i';
        ac1[502] = 'x';
        ac1[503] = 'w';
        ac1[504] = '\226';
        ac1[505] = '\244';
        ac1[506] = '\226';
        ac1[507] = '\226';
        ac1[508] = '\227';
        ac1[509] = '\227';
        ac1[510] = 'y';
        ac1[511] = 'y';
        ac1[512] = 'y';
        ac1[513] = 'i';
        ac1[514] = 'x';
        ac1[515] = 'x';
        ac1[516] = '\226';
        ac1[517] = '\245';
        ac1[518] = '\226';
        ac1[519] = '\245';
        ac1[520] = '\246';
        ac1[521] = '\226';
        ac1[522] = '\210';
        ac1[523] = 'x';
        ac1[524] = 'x';
        ac1[525] = 'x';
        ac1[526] = '\207';
        ac1[527] = '\207';
        ac1[528] = '\225';
        ac1[529] = '\264';
        ac1[530] = '\226';
        ac1[531] = '\245';
        ac1[532] = '\226';
        ac1[533] = '\227';
        ac1[534] = '\210';
        ac1[535] = 'x';
        ac1[536] = 'x';
        ac1[537] = 'y';
        ac1[538] = 'w';
        ac1[539] = '\207';
        ac1[540] = '\225';
        ac1[541] = '\264';
        ac1[542] = '\226';
        ac1[543] = '\246';
        ac1[544] = '\227';
        ac1[545] = '\227';
        ac1[546] = 'x';
        ac1[547] = 'y';
        ac1[548] = 'x';
        ac1[549] = 'i';
        ac1[550] = 'x';
        ac1[551] = 'w';
        ac1[552] = '\226';
        ac1[553] = '\264';
        ac1[554] = '\226';
        ac1[555] = '\246';
        ac1[556] = '\227';
        ac1[557] = '\227';
        ac1[558] = 'y';
        ac1[559] = 'y';
        ac1[560] = 'y';
        ac1[561] = 'i';
        ac1[562] = 'x';
        ac1[563] = 'x';
        ac1[564] = '\226';
        ac1[565] = '\245';
        ac1[566] = '\246';
        ac1[567] = '\245';
        ac1[568] = '\246';
        ac1[569] = '\226';
        ac1[570] = '\210';
        ac1[571] = '\210';
        ac1[572] = 'x';
        ac1[573] = 'x';
        ac1[574] = '\207';
        ac1[575] = '\207';
        ac1[576] = '\245';
        ac1[577] = '\264';
        ac1[578] = '\226';
        ac1[579] = '\245';
        ac1[580] = '\226';
        ac1[581] = '\227';
        ac1[582] = '\210';
        ac1[583] = 'y';
        ac1[584] = 'x';
        ac1[585] = 'y';
        ac1[586] = 'w';
        ac1[587] = '\207';
        ac1[588] = '\225';
        ac1[589] = '\264';
        ac1[590] = '\226';
        ac1[591] = '\245';
        ac1[592] = '\226';
        ac1[593] = '\227';
        ac1[594] = 'x';
        ac1[595] = 'y';
        ac1[596] = 'x';
        ac1[597] = 'i';
        ac1[598] = 'x';
        ac1[599] = 'w';
        ac1[600] = '\226';
        ac1[601] = '\264';
        ac1[602] = '\226';
        ac1[603] = '\246';
        ac1[604] = '\227';
        ac1[605] = '\227';
        ac1[606] = 'y';
        ac1[607] = 'y';
        ac1[608] = 'y';
        ac1[609] = 'i';
        ac1[610] = 'x';
        ac1[611] = 'x';
        ac1[612] = '\226';
        ac1[613] = '\245';
        ac1[614] = '\246';
        ac1[615] = '\245';
        ac1[616] = '\246';
        ac1[617] = '\226';
        ac1[618] = '\210';
        ac1[619] = '\210';
        ac1[620] = 'x';
        ac1[621] = 'x';
        ac1[622] = '\207';
        ac1[623] = '\207';
        ac1[624] = '\245';
        ac1[625] = '\264';
        ac1[626] = '\226';
        ac1[627] = '\245';
        ac1[628] = '\226';
        ac1[629] = '\227';
        ac1[630] = '\210';
        ac1[631] = 'x';
        ac1[632] = 'x';
        ac1[633] = 'y';
        ac1[634] = 'w';
        ac1[635] = '\207';
        ac1[636] = '\225';
        ac1[637] = '\264';
        ac1[638] = '\226';
        ac1[639] = '\245';
        ac1[640] = '\226';
        ac1[641] = '\227';
        ac1[642] = 'x';
        ac1[643] = 'y';
        ac1[644] = 'x';
        ac1[645] = 'h';
        ac1[646] = 'x';
        ac1[647] = '\207';
        ac1[648] = '\226';
        ac1[649] = '\264';
        ac1[650] = '\226';
        ac1[651] = '\246';
        ac1[652] = '\227';
        ac1[653] = '\227';
        ac1[654] = 'x';
        ac1[655] = 'y';
        ac1[656] = 'y';
        ac1[657] = 'i';
        ac1[658] = 'x';
        ac1[659] = 'w';
        ac1[660] = '\226';
        ac1[661] = '\245';
        ac1[662] = '\245';
        ac1[663] = '\245';
        ac1[664] = '\246';
        ac1[665] = '\226';
        ac1[666] = '\210';
        ac1[667] = '\210';
        ac1[668] = 'x';
        ac1[669] = 'x';
        ac1[670] = '\207';
        ac1[671] = '\207';
        ac1[672] = '\245';
        ac1[673] = '\264';
        ac1[674] = '\226';
        ac1[675] = '\245';
        ac1[676] = '\226';
        ac1[677] = '\227';
        ac1[678] = '\210';
        ac1[679] = 'x';
        ac1[680] = 'x';
        ac1[681] = 'y';
        ac1[682] = 'w';
        ac1[683] = '\207';
        ac1[684] = '\225';
        ac1[685] = '\264';
        ac1[686] = '\226';
        ac1[687] = '\245';
        ac1[688] = '\226';
        ac1[689] = '\227';
        ac1[690] = '\210';
        ac1[691] = 'x';
        ac1[692] = 'x';
        ac1[693] = 'i';
        ac1[694] = 'x';
        ac1[695] = '\207';
        ac1[696] = '\226';
        ac1[697] = '\264';
        ac1[698] = '\226';
        ac1[699] = '\246';
        ac1[700] = '\227';
        ac1[701] = '\227';
        ac1[702] = 'x';
        ac1[703] = 'y';
        ac1[704] = 'y';
        ac1[705] = 'i';
        ac1[706] = 'x';
        ac1[707] = 'w';
        ac1[708] = '\226';
        ac1[709] = '\244';
        ac1[710] = '\245';
        ac1[711] = '\245';
        ac1[712] = '\246';
        ac1[713] = '\226';
        ac1[714] = '\210';
        ac1[715] = '\210';
        ac1[716] = '\210';
        ac1[717] = 'x';
        ac1[718] = '\207';
        ac1[719] = '\207';
        ac1[720] = '\245';
        ac1[721] = '\264';
        ac1[722] = '\226';
        ac1[723] = '\245';
        ac1[724] = '\226';
        ac1[725] = '\226';
        ac1[726] = '\210';
        ac1[727] = 'x';
        ac1[728] = 'x';
        ac1[729] = 'x';
        ac1[730] = '\207';
        ac1[731] = '\207';
        ac1[732] = '\226';
        ac1[733] = '\264';
        ac1[734] = '\226';
        ac1[735] = '\245';
        ac1[736] = '\226';
        ac1[737] = '\227';
        ac1[738] = '\210';
        ac1[739] = 'x';
        ac1[740] = 'x';
        ac1[741] = 'i';
        ac1[742] = 'x';
        ac1[743] = '\207';
        ac1[744] = '\226';
        ac1[745] = '\264';
        ac1[746] = '\226';
        ac1[747] = '\246';
        ac1[748] = '\227';
        ac1[749] = '\227';
        ac1[750] = 'x';
        ac1[751] = 'y';
        ac1[752] = 'y';
        ac1[753] = 'i';
        ac1[754] = 'x';
        ac1[755] = 'w';
        ac1[756] = '\226';
        ac1[757] = '\244';
        ac1[758] = '\245';
        ac1[759] = '\245';
        ac1[760] = '\246';
        ac1[761] = '\226';
        ac1[762] = '\210';
        ac1[763] = '\210';
        ac1[764] = '\210';
        ac1[765] = 'x';
        ac1[766] = '\207';
        ac1[767] = '\207';
        ac1[768] = '\245';
        ac1[769] = '\264';
        ac1[770] = '\226';
        ac1[771] = '\245';
        ac1[772] = '\226';
        ac1[773] = '\226';
        ac1[774] = '\210';
        ac1[775] = 'x';
        ac1[776] = 'x';
        ac1[777] = 'x';
        ac1[778] = '\207';
        ac1[779] = '\207';
        ac1[780] = '\225';
        ac1[781] = '\264';
        ac1[782] = '\226';
        ac1[783] = '\245';
        ac1[784] = '\226';
        ac1[785] = '\227';
        ac1[786] = '\210';
        ac1[787] = 'x';
        ac1[788] = 'x';
        ac1[789] = 'i';
        ac1[790] = 'x';
        ac1[791] = '\207';
        ac1[792] = '\226';
        ac1[793] = '\264';
        ac1[794] = '\226';
        ac1[795] = '\246';
        ac1[796] = '\227';
        ac1[797] = '\227';
        ac1[798] = 'x';
        ac1[799] = 'y';
        ac1[800] = 'y';
        ac1[801] = 'i';
        ac1[802] = 'x';
        ac1[803] = 'w';
        ac1[804] = '\226';
        ac1[805] = '\244';
        ac1[806] = '\245';
        ac1[807] = '\245';
        ac1[808] = '\246';
        ac1[809] = '\246';
        ac1[810] = '\210';
        ac1[811] = '\210';
        ac1[812] = '\210';
        ac1[813] = 'x';
        ac1[814] = '\207';
        ac1[815] = '\207';
        ac1[816] = '\245';
        ac1[817] = '\264';
        ac1[818] = '\226';
        ac1[819] = '\245';
        ac1[820] = '\226';
        ac1[821] = '\226';
        ac1[822] = '\210';
        ac1[823] = 'x';
        ac1[824] = 'x';
        ac1[825] = 'x';
        ac1[826] = '\207';
        ac1[827] = '\207';
        ac1[828] = '\225';
        ac1[829] = '\264';
        ac1[830] = '\226';
        ac1[831] = '\245';
        ac1[832] = '\226';
        ac1[833] = '\227';
        ac1[834] = '\210';
        ac1[835] = 'x';
        ac1[836] = 'x';
        ac1[837] = 'i';
        ac1[838] = 'x';
        ac1[839] = '\207';
        ac1[840] = '\226';
        ac1[841] = '\264';
        ac1[842] = '\226';
        ac1[843] = '\246';
        ac1[844] = '\227';
        ac1[845] = '\227';
        ac1[846] = 'x';
        ac1[847] = 'y';
        ac1[848] = 'y';
        ac1[849] = 'i';
        ac1[850] = 'x';
        ac1[851] = 'w';
        ac1[852] = '\226';
        ac1[853] = '\244';
        ac1[854] = '\245';
        ac1[855] = '\245';
        ac1[856] = '\246';
        ac1[857] = '\246';
        ac1[858] = '\210';
        ac1[859] = '\210';
        ac1[860] = '\210';
        ac1[861] = 'x';
        ac1[862] = '\207';
        ac1[863] = '\207';
        ac1[864] = '\245';
        ac1[865] = '\265';
        ac1[866] = '\226';
        ac1[867] = '\245';
        ac1[868] = '\246';
        ac1[869] = '\226';
        ac1[870] = '\210';
        ac1[871] = 'x';
        ac1[872] = 'x';
        ac1[873] = 'x';
        ac1[874] = '\207';
        ac1[875] = '\207';
        ac1[876] = '\225';
        ac1[877] = '\264';
        ac1[878] = '\226';
        ac1[879] = '\245';
        ac1[880] = '\226';
        ac1[881] = '\227';
        ac1[882] = '\210';
        ac1[883] = 'x';
        ac1[884] = 'x';
        ac1[885] = 'i';
        ac1[886] = 'x';
        ac1[887] = '\207';
        ac1[888] = '\226';
        ac1[889] = '\264';
        ac1[890] = '\226';
        ac1[891] = '\246';
        ac1[892] = '\227';
        ac1[893] = '\227';
        ac1[894] = 'x';
        ac1[895] = 'y';
        ac1[896] = 'x';
        ac1[897] = 'i';
        ac1[898] = 'x';
        ac1[899] = 'w';
        ac1[900] = '\226';
        ac1[901] = '\244';
        ac1[902] = '\245';
        ac1[903] = '\265';
        ac1[904] = '\246';
        ac1[905] = '\246';
        ac1[906] = '\210';
        ac1[907] = '\211';
        ac1[908] = '\210';
        ac1[909] = 'x';
        ac1[910] = '\207';
        ac1[911] = '\207';
        ac1[912] = '\245';
        ac1[913] = '\264';
        ac1[914] = '\226';
        ac1[915] = '\245';
        ac1[916] = '\226';
        ac1[917] = '\226';
        ac1[918] = '\210';
        ac1[919] = '\210';
        ac1[920] = 'x';
        ac1[921] = 'x';
        ac1[922] = '\207';
        ac1[923] = '\207';
        ac1[924] = '\225';
        ac1[925] = '\264';
        ac1[926] = '\226';
        ac1[927] = '\245';
        ac1[928] = '\226';
        ac1[929] = '\227';
        ac1[930] = '\210';
        ac1[931] = 'x';
        ac1[932] = 'x';
        ac1[933] = 'y';
        ac1[934] = 'x';
        ac1[935] = '\207';
        ac1[936] = '\226';
        ac1[937] = '\264';
        ac1[938] = '\226';
        ac1[939] = '\246';
        ac1[940] = '\226';
        ac1[941] = '\227';
        ac1[942] = 'x';
        ac1[943] = 'y';
        ac1[944] = 'x';
        ac1[945] = 'i';
        ac1[946] = 'x';
        ac1[947] = 'w';
        ac1[948] = '\226';
        ac1[949] = '\244';
        ac1[950] = '\245';
        ac1[951] = '\265';
        ac1[952] = '\246';
        ac1[953] = '\246';
        ac1[954] = '\210';
        ac1[955] = '\210';
        ac1[956] = '\210';
        ac1[957] = 'x';
        ac1[958] = '\207';
        ac1[959] = '\207';
        ac1[960] = '\245';
        ac1[961] = '\264';
        ac1[962] = '\226';
        ac1[963] = '\245';
        ac1[964] = '\246';
        ac1[965] = '\226';
        ac1[966] = '\210';
        ac1[967] = '\210';
        ac1[968] = 'x';
        ac1[969] = 'x';
        ac1[970] = 'w';
        ac1[971] = '\207';
        ac1[972] = '\225';
        ac1[973] = '\264';
        ac1[974] = '\226';
        ac1[975] = '\245';
        ac1[976] = '\226';
        ac1[977] = '\227';
        ac1[978] = '\210';
        ac1[979] = 'x';
        ac1[980] = 'x';
        ac1[981] = 'y';
        ac1[982] = 'w';
        ac1[983] = '\207';
        ac1[984] = '\225';
        ac1[985] = '\264';
        ac1[986] = '\226';
        ac1[987] = '\245';
        ac1[988] = '\226';
        ac1[989] = '\227';
        ac1[990] = 'x';
        ac1[991] = 'y';
        ac1[992] = 'x';
        ac1[993] = 'i';
        ac1[994] = 'x';
        ac1[995] = 'w';
        ac1[996] = '\226';
        ac1[997] = '\264';
        ac1[998] = '\245';
        ac1[999] = '\265';
        ac1[1000] = '\246';
        ac1[1001] = '\246';
        ac1[1002] = '\207';
        ac1[1003] = '\210';
        ac1[1004] = '\210';
        ac1[1005] = 'x';
        ac1[1006] = '\207';
        ac1[1007] = '\207';
        ac1[1008] = '\245';
        ac1[1009] = '\264';
        ac1[1010] = '\246';
        ac1[1011] = '\245';
        ac1[1012] = '\246';
        ac1[1013] = '\226';
        ac1[1014] = '\210';
        ac1[1015] = '\210';
        ac1[1016] = 'x';
        ac1[1017] = 'x';
        ac1[1018] = '\207';
        ac1[1019] = '\207';
        ac1[1020] = '\245';
        ac1[1021] = '\264';
        ac1[1022] = '\226';
        ac1[1023] = '\245';
        ac1[1024] = '\226';
        ac1[1025] = '\227';
        ac1[1026] = '\210';
        ac1[1027] = 'x';
        ac1[1028] = 'x';
        ac1[1029] = 'y';
        ac1[1030] = 'w';
        ac1[1031] = '\207';
        ac1[1032] = '\225';
        ac1[1033] = '\264';
        ac1[1034] = '\226';
        ac1[1035] = '\245';
        ac1[1036] = '\226';
        ac1[1037] = '\227';
        ac1[1038] = '\210';
        ac1[1039] = 'y';
        ac1[1040] = 'x';
        ac1[1041] = 'i';
        ac1[1042] = 'x';
        ac1[1043] = '\207';
        ac1[1044] = '\226';
        ac1[1045] = '\264';
        ac1[1046] = '\245';
        ac1[1047] = '\265';
        ac1[1048] = '\246';
        ac1[1049] = '\246';
        ac1[1050] = '\207';
        ac1[1051] = '\210';
        ac1[1052] = '\210';
        ac1[1053] = 'x';
        ac1[1054] = '\207';
        ac1[1055] = '\206';
        ac1[1056] = '\245';
        ac1[1057] = '\264';
        ac1[1058] = '\245';
        ac1[1059] = '\245';
        ac1[1060] = '\246';
        ac1[1061] = '\226';
        ac1[1062] = '\210';
        ac1[1063] = '\210';
        ac1[1064] = '\210';
        ac1[1065] = 'x';
        ac1[1066] = '\207';
        ac1[1067] = '\207';
        ac1[1068] = '\245';
        ac1[1069] = '\264';
        ac1[1070] = '\226';
        ac1[1071] = '\245';
        ac1[1072] = '\226';
        ac1[1073] = '\226';
        ac1[1074] = '\210';
        ac1[1075] = 'x';
        ac1[1076] = 'x';
        ac1[1077] = 'y';
        ac1[1078] = 'w';
        ac1[1079] = '\207';
        ac1[1080] = '\225';
        ac1[1081] = '\264';
        ac1[1082] = '\226';
        ac1[1083] = '\245';
        ac1[1084] = '\206';
        ac1[1085] = '\227';
        ac1[1086] = '\210';
        ac1[1087] = 'x';
        ac1[1088] = 'x';
        ac1[1089] = 'i';
        ac1[1090] = 'x';
        ac1[1091] = '\207';
        ac1[1092] = '\226';
        ac1[1093] = '\264';
        ac1[1094] = '\245';
        ac1[1095] = '\265';
        ac1[1096] = '\246';
        ac1[1097] = '\246';
        ac1[1098] = '\207';
        ac1[1099] = '\210';
        ac1[1100] = '\210';
        ac1[1101] = 'x';
        ac1[1102] = '\207';
        ac1[1103] = '\206';
        ac1[1104] = '\245';
        ac1[1105] = '\263';
        ac1[1106] = '\245';
        ac1[1107] = '\245';
        ac1[1108] = '\246';
        ac1[1109] = '\226';
        ac1[1110] = '\210';
        ac1[1111] = '\210';
        ac1[1112] = '\210';
        ac1[1113] = 'x';
        ac1[1114] = '\207';
        ac1[1115] = '\207';
        ac1[1116] = '\245';
        ac1[1117] = '\264';
        ac1[1118] = '\226';
        ac1[1119] = '\245';
        ac1[1120] = '\226';
        ac1[1121] = '\226';
        ac1[1122] = '\210';
        ac1[1123] = 'x';
        ac1[1124] = 'x';
        ac1[1125] = 'x';
        ac1[1126] = '\207';
        ac1[1127] = '\207';
        ac1[1128] = '\225';
        ac1[1129] = '\264';
        ac1[1130] = '\226';
        ac1[1131] = '\245';
        ac1[1132] = '\226';
        ac1[1133] = '\227';
        ac1[1134] = '\210';
        ac1[1135] = 'v';
        ac1[1136] = 'x';
        ac1[1137] = 'i';
        ac1[1138] = 'x';
        ac1[1139] = '\207';
        ac1[1140] = '\226';
        ac1[1141] = '\264';
        ac1[1142] = '\245';
        ac1[1143] = '\265';
        ac1[1144] = '\246';
        ac1[1145] = '\246';
        ac1[1146] = '\207';
        ac1[1147] = '\210';
        ac1[1148] = '\210';
        ac1[1149] = 'x';
        ac1[1150] = '\207';
        ac1[1151] = '\206';
        ac1[1152] = '\245';
        ac1[1153] = '\263';
        ac1[1154] = '\245';
        ac1[1155] = '\245';
        ac1[1156] = '\246';
        ac1[1157] = '\246';
        ac1[1158] = '\210';
        ac1[1159] = '\210';
        ac1[1160] = '\210';
        ac1[1161] = 'x';
        ac1[1162] = '\207';
        ac1[1163] = '\207';
        ac1[1164] = '\245';
        ac1[1165] = '\264';
        ac1[1166] = '\226';
        ac1[1167] = '\245';
        ac1[1168] = '\226';
        ac1[1169] = '\226';
        ac1[1170] = '\210';
        ac1[1171] = 'x';
        ac1[1172] = 'x';
        ac1[1173] = 'x';
        ac1[1174] = '\207';
        ac1[1175] = '\207';
        ac1[1176] = '\225';
        ac1[1177] = '\264';
        ac1[1178] = '\226';
        ac1[1179] = '\245';
        ac1[1180] = '\226';
        ac1[1181] = '\227';
        ac1[1182] = '\210';
        ac1[1183] = 'x';
        ac1[1184] = 'x';
        ac1[1185] = 'i';
        ac1[1186] = 'x';
        ac1[1187] = '\207';
        ac1[1188] = '\226';
        ac1[1189] = '\264';
        ac1[1190] = '\245';
        ac1[1191] = '\265';
        ac1[1192] = '\246';
        ac1[1193] = '\246';
        ac1[1194] = '\207';
        ac1[1195] = '\210';
        ac1[1196] = '\210';
        ac1[1197] = 'x';
        ac1[1198] = '\207';
        ac1[1199] = '\206';
        ac1[1200] = '\245';
        ac1[1201] = '\263';
        ac1[1202] = '\245';
        ac1[1203] = '\245';
        ac1[1204] = '\246';
        ac1[1205] = '\246';
        ac1[1206] = '\210';
        ac1[1207] = '\210';
        ac1[1208] = '\210';
        ac1[1209] = 'x';
        ac1[1210] = '\207';
        ac1[1211] = '\207';
        ac1[1212] = '\245';
        ac1[1213] = '\264';
        ac1[1214] = '\226';
        ac1[1215] = '\245';
        ac1[1216] = '\226';
        ac1[1217] = '\226';
        ac1[1218] = '\210';
        ac1[1219] = 'x';
        ac1[1220] = 'x';
        ac1[1221] = 'x';
        ac1[1222] = '\207';
        ac1[1223] = '\207';
        ac1[1224] = '\225';
        ac1[1225] = '\264';
        ac1[1226] = '\226';
        ac1[1227] = '\245';
        ac1[1228] = '\226';
        ac1[1229] = '\227';
        ac1[1230] = '\210';
        ac1[1231] = 'x';
        ac1[1232] = 'x';
        ac1[1233] = 'i';
        ac1[1234] = 'x';
        ac1[1235] = '\207';
        ac1[1236] = '\226';
        ac1[1237] = '\264';
        ac1[1238] = '\245';
        ac1[1239] = '\265';
        ac1[1240] = '\246';
        ac1[1241] = '\246';
        ac1[1242] = '\207';
        ac1[1243] = '\210';
        ac1[1244] = '\210';
        ac1[1245] = 'x';
        ac1[1246] = '\207';
        ac1[1247] = '\206';
        ac1[1248] = '\245';
        ac1[1249] = '\263';
        ac1[1250] = '\245';
        ac1[1251] = '\245';
        ac1[1252] = '\246';
        ac1[1253] = '\246';
        ac1[1254] = '\210';
        ac1[1255] = '\210';
        ac1[1256] = '\210';
        ac1[1257] = 'x';
        ac1[1258] = '\207';
        ac1[1259] = '\207';
        ac1[1260] = '\245';
        ac1[1261] = '\264';
        ac1[1262] = '\226';
        ac1[1263] = '\245';
        ac1[1264] = '\246';
        ac1[1265] = '\226';
        ac1[1266] = '\210';
        ac1[1267] = '\210';
        ac1[1268] = 'x';
        ac1[1269] = 'x';
        ac1[1270] = '\207';
        ac1[1271] = '\207';
        ac1[1272] = '\225';
        ac1[1273] = '\264';
        ac1[1274] = '\226';
        ac1[1275] = '\245';
        ac1[1276] = '\226';
        ac1[1277] = '\227';
        ac1[1278] = '\210';
        ac1[1279] = 'x';
        ac1[1280] = 'x';
        ac1[1281] = 'i';
        ac1[1282] = 'x';
        ac1[1283] = '\207';
        ac1[1284] = '\226';
        ac1[1285] = '\264';
        ac1[1286] = '\245';
        ac1[1287] = '\265';
        ac1[1288] = '\246';
        ac1[1289] = '\246';
        ac1[1290] = '\207';
        ac1[1291] = '\210';
        ac1[1292] = '\207';
        ac1[1293] = 'x';
        ac1[1294] = '\207';
        ac1[1295] = '\206';
        ac1[1296] = '\245';
        ac1[1297] = '\263';
        ac1[1298] = '\245';
        ac1[1299] = '\265';
        ac1[1300] = '\246';
        ac1[1301] = '\246';
        ac1[1302] = '\210';
        ac1[1303] = '\210';
        ac1[1304] = '\210';
        ac1[1305] = 'x';
        ac1[1306] = '\207';
        ac1[1307] = '\207';
        ac1[1308] = '\245';
        ac1[1309] = '\264';
        ac1[1310] = '\226';
        ac1[1311] = '\245';
        ac1[1312] = '\246';
        ac1[1313] = '\226';
        ac1[1314] = '\210';
        ac1[1315] = '\210';
        ac1[1316] = 'x';
        ac1[1317] = 'x';
        ac1[1318] = '\207';
        ac1[1319] = '\207';
        ac1[1320] = '\225';
        ac1[1321] = '\264';
        ac1[1322] = '\226';
        ac1[1323] = '\245';
        ac1[1324] = '\226';
        ac1[1325] = '\227';
        ac1[1326] = '\210';
        ac1[1327] = 'x';
        ac1[1328] = 'x';
        ac1[1329] = 'y';
        ac1[1330] = 'x';
        ac1[1331] = '\207';
        ac1[1332] = '\226';
        ac1[1333] = '\264';
        ac1[1334] = '\245';
        ac1[1335] = '\265';
        ac1[1336] = '\245';
        ac1[1337] = '\246';
        ac1[1338] = '\207';
        ac1[1339] = '\210';
        ac1[1340] = '\207';
        ac1[1341] = 'x';
        ac1[1342] = '\207';
        ac1[1343] = '\206';
        ac1[1344] = '\245';
        ac1[1345] = '\263';
        ac1[1346] = '\245';
        ac1[1347] = '\265';
        ac1[1348] = '\246';
        ac1[1349] = '\246';
        ac1[1350] = '\207';
        ac1[1351] = '\210';
        ac1[1352] = '\210';
        ac1[1353] = 'x';
        ac1[1354] = '\207';
        ac1[1355] = '\207';
        ac1[1356] = '\245';
        ac1[1357] = '\264';
        ac1[1358] = '\226';
        ac1[1359] = '\245';
        ac1[1360] = '\246';
        ac1[1361] = '\226';
        ac1[1362] = '\210';
        ac1[1363] = '\210';
        ac1[1364] = 'x';
        ac1[1365] = 'x';
        ac1[1366] = '\207';
        ac1[1367] = '\207';
        ac1[1368] = '\225';
        ac1[1369] = '\264';
        ac1[1370] = '\226';
        ac1[1371] = '\245';
        ac1[1372] = '\226';
        ac1[1373] = '\227';
        ac1[1374] = '\210';
        ac1[1375] = 'x';
        ac1[1376] = 'x';
        ac1[1377] = 'y';
        ac1[1378] = 'w';
        ac1[1379] = '\207';
        ac1[1380] = '\225';
        ac1[1381] = '\264';
        ac1[1382] = '\245';
        ac1[1383] = '\264';
        ac1[1384] = '\245';
        ac1[1385] = '\246';
        ac1[1386] = '\207';
        ac1[1387] = '\210';
        ac1[1388] = '\207';
        ac1[1389] = 'x';
        ac1[1390] = '\207';
        ac1[1391] = '\206';
        ac1[1392] = '\245';
        ac1[1393] = '\303';
        ac1[1394] = '\245';
        ac1[1395] = '\265';
        ac1[1396] = '\246';
        ac1[1397] = '\246';
        ac1[1398] = '\207';
        ac1[1399] = '\210';
        ac1[1400] = '\210';
        ac1[1401] = 'x';
        ac1[1402] = '\207';
        ac1[1403] = '\207';
        ac1[1404] = '\245';
        ac1[1405] = '\264';
        ac1[1406] = '\246';
        ac1[1407] = '\245';
        ac1[1408] = '\246';
        ac1[1409] = '\226';
        ac1[1410] = '\210';
        ac1[1411] = '\210';
        ac1[1412] = 'x';
        ac1[1413] = 'x';
        ac1[1414] = '\207';
        ac1[1415] = '\207';
        ac1[1416] = '\245';
        ac1[1417] = '\264';
        ac1[1418] = '\226';
        ac1[1419] = '\245';
        ac1[1420] = '\226';
        ac1[1421] = '\226';
        ac1[1422] = '\210';
        ac1[1423] = 'x';
        ac1[1424] = 'x';
        ac1[1425] = 'y';
        ac1[1426] = 'w';
        ac1[1427] = '\207';
        ac1[1428] = '\225';
        ac1[1429] = '\264';
        ac1[1430] = '\245';
        ac1[1431] = '\264';
        ac1[1432] = '\245';
        ac1[1433] = '\246';
        ac1[1434] = '\227';
        ac1[1435] = '\207';
        ac1[1436] = '\207';
        ac1[1437] = 'x';
        ac1[1438] = '\207';
        ac1[1439] = '\206';
        ac1[1440] = '\245';
        ac1[1441] = '\303';
        ac1[1442] = '\245';
        ac1[1443] = '\265';
        ac1[1444] = '\246';
        ac1[1445] = '\246';
        ac1[1446] = '\207';
        ac1[1447] = '\210';
        ac1[1448] = '\210';
        ac1[1449] = 'x';
        ac1[1450] = '\207';
        ac1[1451] = '\206';
        ac1[1452] = '\245';
        ac1[1453] = '\264';
        ac1[1454] = '\245';
        ac1[1455] = '\245';
        ac1[1456] = '\246';
        ac1[1457] = '\226';
        ac1[1458] = '\210';
        ac1[1459] = '\210';
        ac1[1460] = '\210';
        ac1[1461] = 'x';
        ac1[1462] = '\207';
        ac1[1463] = '\207';
        ac1[1464] = '\245';
        ac1[1465] = '\264';
        ac1[1466] = '\226';
        ac1[1467] = '\245';
        ac1[1468] = '\226';
        ac1[1469] = '\226';
        ac1[1470] = '\210';
        ac1[1471] = 'x';
        ac1[1472] = 'x';
        ac1[1473] = 'y';
        ac1[1474] = 'w';
        ac1[1475] = '\207';
        ac1[1476] = '\225';
        ac1[1477] = '\264';
        ac1[1478] = '\245';
        ac1[1479] = '\264';
        ac1[1480] = '\245';
        ac1[1481] = '\246';
        ac1[1482] = '\227';
        ac1[1483] = '\207';
        ac1[1484] = '\207';
        ac1[1485] = 'x';
        ac1[1486] = '\207';
        ac1[1487] = '\226';
        ac1[1488] = '\245';
        ac1[1489] = '\303';
        ac1[1490] = '\245';
        ac1[1491] = '\265';
        ac1[1492] = '\246';
        ac1[1493] = '\246';
        ac1[1494] = '\207';
        ac1[1495] = '\210';
        ac1[1496] = '\210';
        ac1[1497] = 'x';
        ac1[1498] = '\207';
        ac1[1499] = '\206';
        ac1[1500] = '\245';
        ac1[1501] = '\263';
        ac1[1502] = '\245';
        ac1[1503] = '\245';
        ac1[1504] = '\246';
        ac1[1505] = '\246';
        ac1[1506] = '\210';
        ac1[1507] = '\210';
        ac1[1508] = '\210';
        ac1[1509] = 'x';
        ac1[1510] = '\207';
        ac1[1511] = '\207';
        ac1[1512] = '\245';
        ac1[1513] = '\264';
        ac1[1514] = '\226';
        ac1[1515] = '\245';
        ac1[1516] = '\226';
        ac1[1517] = '\226';
        ac1[1518] = '\210';
        ac1[1519] = 'x';
        ac1[1520] = 'x';
        ac1[1521] = 'x';
        ac1[1522] = '\207';
        ac1[1523] = '\207';
        ac1[1524] = '\225';
        ac1[1525] = '\264';
        ac1[1526] = '\245';
        ac1[1527] = '\264';
        ac1[1528] = '\245';
        ac1[1529] = '\246';
        ac1[1530] = '\227';
        ac1[1531] = '\207';
        ac1[1532] = '\207';
        ac1[1533] = 'x';
        ac1[1534] = '\207';
        ac1[1535] = '\226';
        ac1[1536] = '\245';
        ac1[1537] = '\303';
        ac1[1538] = '\245';
        ac1[1539] = '\265';
        ac1[1540] = '\246';
        ac1[1541] = '\246';
        ac1[1542] = '\207';
        ac1[1543] = '\210';
        ac1[1544] = '\210';
        ac1[1545] = 'x';
        ac1[1546] = '\207';
        ac1[1547] = '\206';
        ac1[1548] = '\245';
        ac1[1549] = '\263';
        ac1[1550] = '\245';
        ac1[1551] = '\245';
        ac1[1552] = '\246';
        ac1[1553] = '\246';
        ac1[1554] = '\210';
        ac1[1555] = '\210';
        ac1[1556] = '\210';
        ac1[1557] = 'x';
        ac1[1558] = '\207';
        ac1[1559] = '\207';
        ac1[1560] = '\245';
        ac1[1561] = '\264';
        ac1[1562] = '\226';
        ac1[1563] = '\245';
        ac1[1564] = '\226';
        ac1[1565] = '\226';
        ac1[1566] = '\210';
        ac1[1567] = 'x';
        ac1[1568] = 'x';
        ac1[1569] = 'x';
        ac1[1570] = '\207';
        ac1[1571] = '\207';
        ac1[1572] = '\225';
        ac1[1573] = '\264';
        ac1[1574] = '\245';
        ac1[1575] = '\264';
        ac1[1576] = '\245';
        ac1[1577] = '\246';
        ac1[1578] = '\227';
        ac1[1579] = '\207';
        ac1[1580] = '\207';
        ac1[1581] = 'x';
        ac1[1582] = '\207';
        ac1[1583] = '\226';
        ac1[1584] = '\245';
        ac1[1585] = '\303';
        ac1[1586] = '\245';
        ac1[1587] = '\265';
        ac1[1588] = '\246';
        ac1[1589] = '\246';
        ac1[1590] = '\210';
        ac1[1591] = '\210';
        ac1[1592] = '\210';
        ac1[1593] = 'x';
        ac1[1594] = '\207';
        ac1[1595] = '\206';
        ac1[1596] = '\245';
        ac1[1597] = '\263';
        ac1[1598] = '\245';
        ac1[1599] = '\245';
        ac1[1600] = '\246';
        ac1[1601] = '\246';
        ac1[1602] = '\210';
        ac1[1603] = 'x';
        ac1[1604] = '\210';
        ac1[1605] = 'x';
        ac1[1606] = '\207';
        ac1[1607] = '\207';
        ac1[1608] = '\245';
        ac1[1609] = '\264';
        ac1[1610] = '\226';
        ac1[1611] = '\245';
        ac1[1612] = '\246';
        ac1[1613] = '\226';
        ac1[1614] = '\210';
        ac1[1615] = '\210';
        ac1[1616] = 'x';
        ac1[1617] = 'x';
        ac1[1618] = '\207';
        ac1[1619] = '\207';
        ac1[1620] = '\225';
        ac1[1621] = '\264';
        ac1[1622] = '\245';
        ac1[1623] = '\264';
        ac1[1624] = '\245';
        ac1[1625] = '\246';
        ac1[1626] = '\227';
        ac1[1627] = '\207';
        ac1[1628] = '\207';
        ac1[1629] = 'x';
        ac1[1630] = '\207';
        ac1[1631] = '\226';
        ac1[1632] = '\245';
        ac1[1633] = '\303';
        ac1[1634] = '\245';
        ac1[1635] = '\265';
        ac1[1636] = '\246';
        ac1[1637] = '\246';
        ac1[1638] = '\207';
        ac1[1639] = '\210';
        ac1[1640] = '\210';
        ac1[1641] = 'x';
        ac1[1642] = '\207';
        ac1[1643] = '\206';
        ac1[1644] = '\245';
        ac1[1645] = '\263';
        ac1[1646] = '\245';
        ac1[1647] = '\245';
        ac1[1648] = '\246';
        ac1[1649] = '\246';
        ac1[1650] = '\210';
        ac1[1651] = '\210';
        ac1[1652] = '\210';
        ac1[1653] = 'x';
        ac1[1654] = '\207';
        ac1[1655] = '\207';
        ac1[1656] = '\245';
        ac1[1657] = '\264';
        ac1[1658] = '\226';
        ac1[1659] = '\245';
        ac1[1660] = '\246';
        ac1[1661] = '\226';
        ac1[1662] = '\210';
        ac1[1663] = '\210';
        ac1[1664] = 'x';
        ac1[1665] = 'x';
        ac1[1666] = '\207';
        ac1[1667] = '\207';
        ac1[1668] = '\225';
        ac1[1669] = '\264';
        ac1[1670] = '\245';
        ac1[1671] = '\264';
        ac1[1672] = '\245';
        ac1[1673] = '\246';
        ac1[1674] = '\227';
        ac1[1675] = '\207';
        ac1[1676] = '\207';
        ac1[1677] = 'x';
        ac1[1678] = '\207';
        ac1[1679] = '\226';
        ac1[1680] = '\245';
        ac1[1681] = '\303';
        ac1[1682] = '\245';
        ac1[1683] = '\265';
        ac1[1684] = '\245';
        ac1[1685] = '\246';
        ac1[1686] = '\207';
        ac1[1687] = '\210';
        ac1[1688] = '\207';
        ac1[1689] = 'x';
        ac1[1690] = '\207';
        ac1[1691] = '\206';
        ac1[1692] = '\245';
        ac1[1693] = '\263';
        ac1[1694] = '\245';
        ac1[1695] = '\265';
        ac1[1696] = '\246';
        ac1[1697] = '\246';
        ac1[1698] = '\210';
        ac1[1699] = '\210';
        ac1[1700] = '\210';
        ac1[1701] = 'x';
        ac1[1702] = '\207';
        ac1[1703] = '\207';
        ac1[1704] = '\245';
        ac1[1705] = '\264';
        ac1[1706] = '\226';
        ac1[1707] = '\245';
        ac1[1708] = '\246';
        ac1[1709] = '\226';
        ac1[1710] = '\210';
        ac1[1711] = '\210';
        ac1[1712] = 'x';
        ac1[1713] = 'x';
        ac1[1714] = '\207';
        ac1[1715] = '\207';
        ac1[1716] = '\225';
        ac1[1717] = '\264';
        ac1[1718] = '\245';
        ac1[1719] = '\264';
        ac1[1720] = '\245';
        ac1[1721] = '\246';
        ac1[1722] = '\227';
        ac1[1723] = '\207';
        ac1[1724] = '\207';
        ac1[1725] = '\210';
        ac1[1726] = '\207';
        ac1[1727] = '\226';
        ac1[1728] = '\245';
        ac1[1729] = '\303';
        ac1[1730] = '\245';
        ac1[1731] = '\264';
        ac1[1732] = '\245';
        ac1[1733] = '\246';
        ac1[1734] = '\207';
        ac1[1735] = '\210';
        ac1[1736] = '\207';
        ac1[1737] = 'x';
        ac1[1738] = '\207';
        ac1[1739] = '\206';
        ac1[1740] = '\245';
        ac1[1741] = '\263';
        ac1[1742] = '\245';
        ac1[1743] = '\265';
        ac1[1744] = '\246';
        ac1[1745] = '\246';
        ac1[1746] = '\207';
        ac1[1747] = '\210';
        ac1[1748] = '\210';
        ac1[1749] = 'x';
        ac1[1750] = '\207';
        ac1[1751] = '\207';
        ac1[1752] = '\245';
        ac1[1753] = '\264';
        ac1[1754] = '\226';
        ac1[1755] = '\245';
        ac1[1756] = '\246';
        ac1[1757] = '\226';
        ac1[1758] = '\210';
        ac1[1759] = '\210';
        ac1[1760] = 'x';
        ac1[1761] = 'x';
        ac1[1762] = '\207';
        ac1[1763] = '\207';
        ac1[1764] = '\225';
        ac1[1765] = '\264';
        ac1[1766] = '\245';
        ac1[1767] = '\264';
        ac1[1768] = '\245';
        ac1[1769] = '\245';
        ac1[1770] = '\227';
        ac1[1771] = '\207';
        ac1[1772] = '\207';
        ac1[1773] = '\210';
        ac1[1774] = '\206';
        ac1[1775] = '\226';
        ac1[1776] = '\244';
        ac1[1777] = '\303';
        ac1[1778] = '\245';
        ac1[1779] = '\245';
        ac1[1780] = '\245';
        ac1[1781] = '\246';
        ac1[1782] = '\227';
        ac1[1783] = '\207';
        ac1[1784] = '\207';
        ac1[1785] = 'x';
        ac1[1786] = '\207';
        ac1[1787] = '\206';
        ac1[1788] = '\245';
        ac1[1789] = '\303';
        ac1[1790] = '\245';
        ac1[1791] = '\265';
        ac1[1792] = '\246';
        ac1[1793] = '\246';
        ac1[1794] = '\207';
        ac1[1795] = '\210';
        ac1[1796] = 'x';
        ac1[1797] = 'x';
        ac1[1798] = '\207';
        ac1[1799] = '\207';
        solarTermsTable = ac1;
    }
}
