// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


// Referenced classes of package android.util:
//            MonthDisplayHelper

public class DayOfMonthCursor extends MonthDisplayHelper {

    public DayOfMonthCursor(int i, int j, int k, int l) {
        super(i, j, l);
        mRow = getRowOf(k);
        mColumn = getColumnOf(k);
    }

    public boolean down() {
        boolean flag = false;
        if(isWithinCurrentMonth(1 + mRow, mColumn)) {
            mRow = 1 + mRow;
        } else {
            nextMonth();
            for(mRow = 0; !isWithinCurrentMonth(mRow, mColumn); mRow = 1 + mRow);
            flag = true;
        }
        return flag;
    }

    public int getSelectedColumn() {
        return mColumn;
    }

    public int getSelectedDayOfMonth() {
        return getDayAt(mRow, mColumn);
    }

    public int getSelectedMonthOffset() {
        int i;
        if(isWithinCurrentMonth(mRow, mColumn))
            i = 0;
        else
        if(mRow == 0)
            i = -1;
        else
            i = 1;
        return i;
    }

    public int getSelectedRow() {
        return mRow;
    }

    public boolean isSelected(int i, int j) {
        boolean flag;
        if(mRow == i && mColumn == j)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean left() {
        boolean flag;
        if(mColumn == 0) {
            mRow = -1 + mRow;
            mColumn = 6;
        } else {
            mColumn = -1 + mColumn;
        }
        if(isWithinCurrentMonth(mRow, mColumn)) {
            flag = false;
        } else {
            previousMonth();
            int i = getNumberOfDaysInMonth();
            mRow = getRowOf(i);
            mColumn = getColumnOf(i);
            flag = true;
        }
        return flag;
    }

    public boolean right() {
        boolean flag = false;
        if(mColumn == 6) {
            mRow = 1 + mRow;
            mColumn = 0;
        } else {
            mColumn = 1 + mColumn;
        }
        if(!isWithinCurrentMonth(mRow, mColumn)) {
            nextMonth();
            mRow = 0;
            for(mColumn = 0; !isWithinCurrentMonth(mRow, mColumn); mColumn = 1 + mColumn);
            flag = true;
        }
        return flag;
    }

    public void setSelectedDayOfMonth(int i) {
        mRow = getRowOf(i);
        mColumn = getColumnOf(i);
    }

    public void setSelectedRowColumn(int i, int j) {
        mRow = i;
        mColumn = j;
    }

    public boolean up() {
        boolean flag;
        if(isWithinCurrentMonth(-1 + mRow, mColumn)) {
            mRow = -1 + mRow;
            flag = false;
        } else {
            previousMonth();
            for(mRow = 5; !isWithinCurrentMonth(mRow, mColumn); mRow = -1 + mRow);
            flag = true;
        }
        return flag;
    }

    private int mColumn;
    private int mRow;
}
