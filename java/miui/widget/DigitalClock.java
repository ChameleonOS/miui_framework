// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.widget;

import android.content.*;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class DigitalClock extends RelativeLayout {
    private static class FormatChangeObserver extends ContentObserver {

        public void onChange(boolean flag) {
            DigitalClock digitalclock = (DigitalClock)mClock.get();
            if(digitalclock != null) {
                digitalclock.setDateFormat();
                digitalclock.updateTime();
            } else {
                try {
                    mContext.getContentResolver().unregisterContentObserver(this);
                }
                catch(RuntimeException runtimeexception) { }
            }
        }

        private WeakReference mClock;
        private Context mContext;

        public FormatChangeObserver(DigitalClock digitalclock) {
            super(new Handler());
            mClock = new WeakReference(digitalclock);
            mContext = digitalclock.getContext();
        }
    }

    static class AmPm {

        void setIsMorning(boolean flag) {
            if(mAmPmTextView != null) {
                TextView textview = mAmPmTextView;
                String s;
                if(flag)
                    s = mAmString;
                else
                    s = mPmString;
                textview.setText(s);
            }
        }

        void setShowAmPm(boolean flag) {
            if(mAmPmTextView != null) {
                TextView textview = mAmPmTextView;
                int i;
                if(flag)
                    i = 0;
                else
                    i = 8;
                textview.setVisibility(i);
            }
        }

        private TextView mAmPmTextView;
        private String mAmString;
        private String mPmString;

        AmPm(View view, Typeface typeface) {
            if(mAmPmTextView != null && typeface != null)
                mAmPmTextView.setTypeface(typeface);
            String as[] = (new DateFormatSymbols()).getAmPmStrings();
            mAmString = as[0];
            mPmString = as[1];
        }
    }

    private static class TimeChangedReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            final boolean timezoneChanged = intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED");
            final DigitalClock clock = (DigitalClock)mClock.get();
            if(clock != null)
                clock.mHandler.post(new Runnable() {

                    public void run() {
                        if(timezoneChanged)
                            clock.mCalendar = Calendar.getInstance();
                        clock.updateTime();
                    }

                    final TimeChangedReceiver this$0;
                    final DigitalClock val$clock;
                    final boolean val$timezoneChanged;

                 {
                    this$0 = TimeChangedReceiver.this;
                    timezoneChanged = flag;
                    clock = digitalclock;
                    super();
                }
                });
            else
                try {
                    mContext.unregisterReceiver(this);
                }
                catch(RuntimeException runtimeexception) { }
        }

        private WeakReference mClock;
        private Context mContext;

        public TimeChangedReceiver(DigitalClock digitalclock) {
            mClock = new WeakReference(digitalclock);
            mContext = digitalclock.getContext();
        }
    }


    public DigitalClock(Context context) {
        this(context, null);
    }

    public DigitalClock(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mAttached = 0;
        mHandler = new Handler();
    }

    private void setDateFormat() {
        String s;
        if(DateFormat.is24HourFormat(getContext()))
            s = "kk:mm";
        else
            s = "h:mm";
        mFormat = s;
        mAmPm.setShowAmPm(mFormat.equals("h:mm"));
    }

    private void updateTime() {
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        CharSequence charsequence = DateFormat.format(mFormat, mCalendar);
        mTimeDisplayBackground.setText(charsequence);
        mTimeDisplayForeground.setText(charsequence);
        AmPm ampm = mAmPm;
        boolean flag;
        if(mCalendar.get(9) == 0)
            flag = true;
        else
            flag = false;
        ampm.setIsMorning(flag);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAttached = 1 + mAttached;
        if(mIntentReceiver == null) {
            mIntentReceiver = new TimeChangedReceiver(this);
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.TIME_TICK");
            intentfilter.addAction("android.intent.action.TIME_SET");
            intentfilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            super.mContext.registerReceiver(mIntentReceiver, intentfilter);
        }
        if(mFormatChangeObserver == null) {
            mFormatChangeObserver = new FormatChangeObserver(this);
            super.mContext.getContentResolver().registerContentObserver(android.provider.Settings.System.CONTENT_URI, true, mFormatChangeObserver);
        }
        updateTime();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAttached = -1 + mAttached;
        if(mIntentReceiver != null)
            super.mContext.unregisterReceiver(mIntentReceiver);
        if(mFormatChangeObserver != null)
            super.mContext.getContentResolver().unregisterContentObserver(mFormatChangeObserver);
        mFormatChangeObserver = null;
        mIntentReceiver = null;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        mTimeDisplayBackground = (TextView)findViewById(0x60b0013);
        mTimeDisplayBackground.setTypeface(sBackgroundFont);
        mTimeDisplayBackground.setVisibility(4);
        mTimeDisplayForeground = (TextView)findViewById(0x60b0014);
        mTimeDisplayForeground.setTypeface(sForegroundFont);
        mAmPm = new AmPm(this, null);
        mCalendar = Calendar.getInstance();
        setDateFormat();
    }

    void updateTime(Calendar calendar) {
        mCalendar = calendar;
        updateTime();
    }

    private static final String M12 = "h:mm";
    private static final String M24 = "kk:mm";
    private static final String SYSTEM = "/system/fonts/";
    private static final String SYSTEM_FONT_TIME_BACKGROUND = "/system/fonts/AndroidClock.ttf";
    private static final String SYSTEM_FONT_TIME_FOREGROUND = "/system/fonts/AndroidClock_Highlight.ttf";
    private static final Typeface sBackgroundFont = Typeface.createFromFile("/system/fonts/AndroidClock.ttf");
    private static final Typeface sForegroundFont = Typeface.createFromFile("/system/fonts/AndroidClock_Highlight.ttf");
    private AmPm mAmPm;
    private int mAttached;
    private Calendar mCalendar;
    private String mFormat;
    private ContentObserver mFormatChangeObserver;
    private final Handler mHandler;
    private BroadcastReceiver mIntentReceiver;
    private TextView mTimeDisplayBackground;
    private TextView mTimeDisplayForeground;



/*
    static Calendar access$002(DigitalClock digitalclock, Calendar calendar) {
        digitalclock.mCalendar = calendar;
        return calendar;
    }

*/



}
