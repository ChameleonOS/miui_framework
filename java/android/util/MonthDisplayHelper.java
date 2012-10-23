// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.util.Calendar;

public class MonthDisplayHelper {

    public MonthDisplayHelper(int i, int j) {
        this(i, j, 1);
    }

    public MonthDisplayHelper(int i, int j, int k) {
        if(k < 1 || k > 7) {
            throw new IllegalArgumentException();
        } else {
            mWeekStartDay = k;
            mCalendar = Calendar.getInstance();
            mCalendar.set(1, i);
            mCalendar.set(2, j);
            mCalendar.set(5, 1);
            mCalendar.set(11, 0);
            mCalendar.set(12, 0);
            mCalendar.set(13, 0);
            mCalendar.getTimeInMillis();
            recalculate();
            return;
        }
    }

    private void recalculate() {
        mNumDaysInMonth = mCalendar.getActualMaximum(5);
        mCalendar.add(2, -1);
        mNumDaysInPrevMonth = mCalendar.getActualMaximum(5);
        mCalendar.add(2, 1);
        int i = getFirstDayOfMonth() - mWeekStartDay;
        if(i < 0)
            i += 7;
        mOffset = i;
    }

    public int getColumnOf(int i) {
        return (-1 + (i + mOffset)) % 7;
    }

    public int getDayAt(int i, int j) {
        if(i != 0 || j >= mOffset) goto _L2; else goto _L1
_L1:
        int k = 1 + ((j + mNumDaysInPrevMonth) - mOffset);
_L4:
        return k;
_L2:
        k = 1 + ((j + i * 7) - mOffset);
        if(k > mNumDaysInMonth)
            k -= mNumDaysInMonth;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int[] getDigitsForRow(int i) {
        if(i < 0 || i > 5)
            throw new IllegalArgumentException((new StringBuilder()).append("row ").append(i).append(" out of range (0-5)").toString());
        int ai[] = new int[7];
        for(int j = 0; j < 7; j++)
            ai[j] = getDayAt(i, j);

        return ai;
    }

    public int getFirstDayOfMonth() {
        return mCalendar.get(7);
    }

    public int getMonth() {
        return mCalendar.get(2);
    }

    public int getNumberOfDaysInMonth() {
        return mNumDaysInMonth;
    }

    public int getOffset() {
        return mOffset;
    }

    public int getRowOf(int i) {
        return (-1 + (i + mOffset)) / 7;
    }

    public int getWeekStartDay() {
        return mWeekStartDay;
    }

    public int getYear() {
        return mCalendar.get(1);
    }

    public boolean isWithinCurrentMonth(int i, int j) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(i >= 0 && j >= 0 && i <= 5 && j <= 6 && (i != 0 || j >= mOffset) && 1 + ((j + i * 7) - mOffset) <= mNumDaysInMonth)
            flag = true;
        return flag;
    }

    public void nextMonth() {
        mCalendar.add(2, 1);
        recalculate();
    }

    public void previousMonth() {
        mCalendar.add(2, -1);
        recalculate();
    }

    private Calendar mCalendar;
    private int mNumDaysInMonth;
    private int mNumDaysInPrevMonth;
    private int mOffset;
    private final int mWeekStartDay;
}
