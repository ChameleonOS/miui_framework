// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Calendar;

// Referenced classes of package android.widget:
//            TextView

public class DigitalClock extends TextView {
    private class FormatChangeObserver extends ContentObserver {

        public void onChange(boolean flag) {
            setFormat();
        }

        final DigitalClock this$0;

        public FormatChangeObserver() {
            this$0 = DigitalClock.this;
            super(new Handler());
        }
    }


    public DigitalClock(Context context) {
        super(context);
        mTickerStopped = false;
        initClock(context);
    }

    public DigitalClock(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mTickerStopped = false;
        initClock(context);
    }

    private boolean get24HourMode() {
        return DateFormat.is24HourFormat(getContext());
    }

    private void initClock(Context context) {
        super.mContext.getResources();
        if(mCalendar == null)
            mCalendar = Calendar.getInstance();
        mFormatChangeObserver = new FormatChangeObserver();
        getContext().getContentResolver().registerContentObserver(android.provider.Settings.System.CONTENT_URI, true, mFormatChangeObserver);
        setFormat();
    }

    private void setFormat() {
        if(get24HourMode())
            mFormat = "k:mm:ss";
        else
            mFormat = "h:mm:ss aa";
    }

    protected void onAttachedToWindow() {
        mTickerStopped = false;
        super.onAttachedToWindow();
        mHandler = new Handler();
        mTicker = new Runnable() {

            public void run() {
                if(!mTickerStopped) {
                    mCalendar.setTimeInMillis(System.currentTimeMillis());
                    setText(DateFormat.format(mFormat, mCalendar));
                    invalidate();
                    long l = SystemClock.uptimeMillis();
                    long l1 = l + (1000L - l % 1000L);
                    mHandler.postAtTime(mTicker, l1);
                }
            }

            final DigitalClock this$0;

             {
                this$0 = DigitalClock.this;
                super();
            }
        };
        mTicker.run();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mTickerStopped = true;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/DigitalClock.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/DigitalClock.getName());
    }

    private static final String m12 = "h:mm:ss aa";
    private static final String m24 = "k:mm:ss";
    Calendar mCalendar;
    String mFormat;
    private FormatChangeObserver mFormatChangeObserver;
    private Handler mHandler;
    private Runnable mTicker;
    private boolean mTickerStopped;




}
