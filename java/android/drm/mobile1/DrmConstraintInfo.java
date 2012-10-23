// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm.mobile1;

import java.util.Date;

public class DrmConstraintInfo {

    DrmConstraintInfo() {
        count = -1;
        startDate = -1L;
        endDate = -1L;
        interval = -1L;
    }

    public int getCount() {
        return count;
    }

    public Date getEndDate() {
        Date date;
        if(endDate == -1L)
            date = null;
        else
            date = new Date(endDate);
        return date;
    }

    public long getInterval() {
        return interval;
    }

    public Date getStartDate() {
        Date date;
        if(startDate == -1L)
            date = null;
        else
            date = new Date(startDate);
        return date;
    }

    private int count;
    private long endDate;
    private long interval;
    private long startDate;
}
