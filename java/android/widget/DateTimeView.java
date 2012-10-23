// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.format.Time;
import android.util.AttributeSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package android.widget:
//            TextView

public class DateTimeView extends TextView {

    public DateTimeView(Context context) {
        super(context);
        mLastDisplay = -1;
    }

    public DateTimeView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mLastDisplay = -1;
    }

    private DateFormat getDateFormat() {
        String s = android.provider.Settings.System.getString(getContext().getContentResolver(), "date_format");
        Object obj;
        if(s == null || "".equals(s))
            obj = DateFormat.getDateInstance(3);
        else
            try {
                obj = new SimpleDateFormat(s);
            }
            catch(IllegalArgumentException illegalargumentexception) {
                obj = DateFormat.getDateInstance(3);
            }
        return ((DateFormat) (obj));
    }

    private DateFormat getTimeFormat() {
        Context context = getContext();
        int i;
        if(android.text.format.DateFormat.is24HourFormat(context))
            i = 0x1040082;
        else
            i = 0x1040081;
        return new SimpleDateFormat(context.getString(i));
    }

    private void registerReceivers() {
        Context context = getContext();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.TIME_TICK");
        intentfilter.addAction("android.intent.action.TIME_SET");
        intentfilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        intentfilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        context.registerReceiver(mBroadcastReceiver, intentfilter);
        android.net.Uri uri = android.provider.Settings.System.getUriFor("date_format");
        context.getContentResolver().registerContentObserver(uri, true, mContentObserver);
    }

    private void unregisterReceivers() {
        Context context = getContext();
        context.unregisterReceiver(mBroadcastReceiver);
        context.getContentResolver().unregisterContentObserver(mContentObserver);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerReceivers();
        mAttachedToWindow = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterReceivers();
        mAttachedToWindow = false;
    }

    public void setTime(long l) {
        Time time = new Time();
        time.set(l);
        time.second = 0;
        mTimeMillis = time.toMillis(false);
        mTime = new Date(-1900 + time.year, time.month, time.monthDay, time.hour, time.minute, 0);
        update();
    }

    void update() {
        if(mTime != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        long l;
        long l1;
        long l2;
        long l3;
        long l4;
        int i;
        DateFormat dateformat;
        System.nanoTime();
        mTime;
        Time time = new Time();
        time.set(mTimeMillis);
        time.second = 0;
        time.hour = -12 + time.hour;
        l = time.toMillis(false);
        time.hour = 12 + time.hour;
        l1 = time.toMillis(false);
        time.hour = 0;
        time.minute = 0;
        l2 = time.toMillis(false);
        time.monthDay = 1 + time.monthDay;
        l3 = time.toMillis(false);
        time.set(System.currentTimeMillis());
        time.second = 0;
        l4 = time.normalize(false);
        if(l4 >= l2 && l4 < l3 || l4 >= l && l4 < l1)
            i = 0;
        else
            i = 1;
        if(i != mLastDisplay || mLastFormat == null) goto _L4; else goto _L3
_L3:
        dateformat = mLastFormat;
_L5:
        setText(dateformat.format(mTime));
        if(i == 0) {
            if(l1 <= l3)
                l1 = l3;
            mUpdateTimeMillis = l1;
        } else
        if(mTimeMillis < l4) {
            mUpdateTimeMillis = 0L;
        } else {
            if(l >= l2)
                l = l2;
            mUpdateTimeMillis = l;
        }
        System.nanoTime();
        if(true) goto _L1; else goto _L4
_L4:
        switch(i) {
        default:
            throw new RuntimeException((new StringBuilder()).append("unknown display value: ").append(i).toString());

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_315;

        case 0: // '\0'
            dateformat = getTimeFormat();
            break;
        }
_L6:
        mLastFormat = dateformat;
          goto _L5
        dateformat = getDateFormat();
          goto _L6
    }

    private static final int SHOW_MONTH_DAY_YEAR = 1;
    private static final int SHOW_TIME = 0;
    private static final String TAG = "DateTimeView";
    private static final long TWELVE_HOURS_IN_MINUTES = 720L;
    private static final long TWENTY_FOUR_HOURS_IN_MILLIS = 0x5265c00L;
    private boolean mAttachedToWindow;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

        public void onReceive(Context context1, Intent intent) {
            if(!"android.intent.action.TIME_TICK".equals(intent.getAction()) || System.currentTimeMillis() >= mUpdateTimeMillis) {
                mLastFormat = null;
                update();
            }
        }

        final DateTimeView this$0;

             {
                this$0 = DateTimeView.this;
                super();
            }
    };
    private ContentObserver mContentObserver = new ContentObserver(new Handler()) {

        public void onChange(boolean flag) {
            mLastFormat = null;
            update();
        }

        final DateTimeView this$0;

             {
                this$0 = DateTimeView.this;
                super(handler);
            }
    };
    int mLastDisplay;
    DateFormat mLastFormat;
    Date mTime;
    long mTimeMillis;
    private long mUpdateTimeMillis;

}
