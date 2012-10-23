// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.*;
import java.nio.CharBuffer;

// Referenced classes of package miui.util:
//            SimplePool

public class MiuiDateUtils {

    public MiuiDateUtils() {
    }

    public static String formatDateTime(Context context, long l, int i) {
        CharBuffer charbuffer = (CharBuffer)mCharBufferPool.acquire();
        formatDateTime(context, l, i, charbuffer);
        String s = new String(charbuffer.array(), 0, charbuffer.position());
        mCharBufferPool.release(charbuffer);
        return s;
    }

    public static void formatDateTime(Context context, long l, int i, CharBuffer charbuffer) {
        Time time = (Time)mTimePool.acquire();
        time.set(l);
        getFormatTime(context, time, i, DateFormat.is24HourFormat(context), charbuffer);
        mTimePool.release(time);
    }

    private static String getDetailedAmPm(int i) {
        if(sAmPmIndex == null) {
            sAmPmIndex = new int[24];
            int ai[] = Resources.getSystem().getIntArray(0x606000a);
            int j = 23;
            for(int k = -1 + ai.length; j >= 0 && k >= 0; j--) {
                if(j < ai[k])
                    k--;
                sAmPmIndex[j] = k;
            }

        }
        return Resources.getSystem().getStringArray(0x606000b)[sAmPmIndex[i]];
    }

    private static void getFormatTime(Context context, Time time, int i, boolean flag, CharBuffer charbuffer) {
        long l = time.toMillis(true);
        boolean flag1;
        if((i & 1) != 0)
            flag1 = true;
        else
            flag1 = false;
        if(flag)
            charbuffer.append(DateUtils.formatDateRange(context, l, l, i));
        else
        if(flag1) {
            if((i ^ 1) != 0) {
                charbuffer.append(DateUtils.formatDateRange(context, l, l, i ^ 1));
                charbuffer.append(" ");
            }
            String s = getDetailedAmPm(time.hour);
            if(time.hour > 12)
                time.hour = -12 + time.hour;
            long l1 = time.toMillis(true);
            String s1 = DateUtils.formatDateRange(context, l1, l1, 129);
            Resources resources = Resources.getSystem();
            Object aobj[] = new Object[2];
            aobj[0] = s1;
            aobj[1] = s;
            charbuffer.append(resources.getString(0x60c01f7, aobj));
        } else {
            charbuffer.append(DateUtils.formatDateRange(context, l, l, i));
        }
    }

    public static void getRelativeTimeSpanString(Context context, long l, CharBuffer charbuffer) {
        long l1 = System.currentTimeMillis();
        Resources resources = Resources.getSystem();
        String as[] = new String[12];
        as[0] = resources.getString(0x60c01be);
        as[1] = resources.getString(0x60c01bf);
        as[2] = resources.getString(0x60c01c0);
        as[3] = resources.getString(0x60c01c1);
        as[4] = resources.getString(0x60c01c2);
        as[5] = resources.getString(0x60c01c3);
        as[6] = resources.getString(0x60c01c4);
        as[7] = resources.getString(0x60c01c5);
        as[8] = resources.getString(0x60c01c6);
        as[9] = resources.getString(0x60c01c7);
        as[10] = resources.getString(0x60c01c8);
        as[11] = resources.getString(0x60c01c9);
        sMonth = as;
        boolean flag;
        long l2;
        Time time;
        Time time1;
        boolean flag1;
        int i;
        long l3;
        if(l1 >= l)
            flag = true;
        else
            flag = false;
        l2 = Math.abs(l1 - l);
        time = (Time)mTimePool.acquire();
        time1 = (Time)mTimePool.acquire();
        time.set(l1);
        time1.set(l);
        flag1 = DateFormat.is24HourFormat(context);
        i = -1;
        l3 = l2 / 60000L;
        if(l3 <= 60L) {
            if(flag) {
                if(l3 == 60L)
                    i = 0x6100004;
                else
                if(l3 == 30L)
                    i = 0x610000a;
                else
                if(l3 == 0L)
                    i = 0x6100005;
                else
                    i = 0x610000c;
            } else
            if(l3 == 60L)
                i = 0x6100007;
            else
            if(l3 == 30L)
                i = 0x6100002;
            else
            if(l3 == 0L)
                i = 0x610000b;
            else
                i = 0x610000e;
        } else
        if(time.year == time1.year && time.yearDay == time1.yearDay)
            getFormatTime(context, time1, 1, flag1, charbuffer);
        else
        if(time.year == time1.year && Math.abs(time.yearDay - time1.yearDay) < 2) {
            if(flag) {
                charbuffer.append(resources.getString(0x60c01a8));
                charbuffer.append(" ");
                getFormatTime(context, time1, 1, flag1, charbuffer);
            } else {
                charbuffer.append(resources.getString(0x60c01a9));
                charbuffer.append(" ");
                getFormatTime(context, time1, 1, flag1, charbuffer);
            }
        } else
        if(time.year == time1.year && time.getWeekNumber() == time1.getWeekNumber()) {
            charbuffer.append(DateUtils.formatDateRange(context, l, l, 0x80002));
            charbuffer.append(" ");
            getFormatTime(context, time1, 1, flag1, charbuffer);
        } else
        if(time.year == time1.year) {
            String s1 = sMonth[time1.month];
            Object aobj1[] = new Object[1];
            aobj1[0] = Integer.valueOf(time1.monthDay);
            String s2 = resources.getString(0x60c01ca, aobj1);
            charbuffer.append((new StringBuilder()).append(s1).append(s2).toString());
        } else {
            charbuffer.append(DateUtils.formatDateRange(context, l, l, 0x80014));
        }
        if(i != -1) {
            int j = (int)l3;
            String s = resources.getQuantityString(i, j);
            Object aobj[] = new Object[1];
            aobj[0] = Long.valueOf(l3);
            charbuffer.append(String.format(s, aobj));
        }
        mTimePool.release(time);
        mTimePool.release(time1);
    }

    private static final int CHAR_BUFFER_CAPACITY = 64;
    private static final SimplePool.PoolInstance mCharBufferPool = SimplePool.newInsance(new SimplePool.Manager() {

        public volatile Object createInstance() {
            return createInstance();
        }

        public CharBuffer createInstance() {
            return CharBuffer.allocate(64);
        }

        public volatile void onRelease(Object obj) {
            onRelease((CharBuffer)obj);
        }

        public void onRelease(CharBuffer charbuffer) {
            charbuffer.clear();
        }

    }, 2);
    private static final SimplePool.PoolInstance mTimePool = SimplePool.newInsance(new SimplePool.Manager() {

        public Time createInstance() {
            return new Time();
        }

        public volatile Object createInstance() {
            return createInstance();
        }

    }, 4);
    private static int sAmPmIndex[];
    private static String sMonth[];

}
