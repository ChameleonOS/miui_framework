// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.content.res.Resources;
import java.util.Calendar;

public class DateSorter {

    public DateSorter(Context context) {
        mBins = new long[4];
        mLabels = new String[5];
        Resources resources = context.getResources();
        Calendar calendar = Calendar.getInstance();
        beginningOfDay(calendar);
        mBins[0] = calendar.getTimeInMillis();
        calendar.add(6, -1);
        mBins[1] = calendar.getTimeInMillis();
        calendar.add(6, -6);
        mBins[2] = calendar.getTimeInMillis();
        calendar.add(6, 7);
        calendar.add(2, -1);
        mBins[3] = calendar.getTimeInMillis();
        mLabels[0] = context.getText(0x104007c).toString();
        mLabels[1] = context.getText(0x104007b).toString();
        String s = resources.getQuantityString(0x1130003, 7);
        String as[] = mLabels;
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(7);
        as[2] = String.format(s, aobj);
        mLabels[3] = context.getString(0x10403a5);
        mLabels[4] = context.getString(0x10403a6);
    }

    private void beginningOfDay(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    public long getBoundary(int i) {
        if(i < 0 || i > 4)
            i = 0;
        long l;
        if(i == 4)
            l = 0x8000000000000000L;
        else
            l = mBins[i];
        return l;
    }

    public int getIndex(long l) {
        int i = 0;
_L3:
        if(i >= 4)
            break MISSING_BLOCK_LABEL_26;
        if(l <= mBins[i]) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i++;
          goto _L3
        i = 4;
          goto _L1
    }

    public String getLabel(int i) {
        String s;
        if(i < 0 || i >= 5)
            s = "";
        else
            s = mLabels[i];
        return s;
    }

    public static final int DAY_COUNT = 5;
    private static final String LOGTAG = "webkit";
    private static final int NUM_DAYS_AGO = 7;
    private long mBins[];
    private String mLabels[];
}
