// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

// Referenced classes of package android.app:
//            AlertDialog

public class TimePickerDialog extends AlertDialog
    implements android.content.DialogInterface.OnClickListener, android.widget.TimePicker.OnTimeChangedListener {
    public static interface OnTimeSetListener {

        public abstract void onTimeSet(TimePicker timepicker, int i, int j);
    }


    public TimePickerDialog(Context context, int i, OnTimeSetListener ontimesetlistener, int j, int k, boolean flag) {
        super(context, i);
        mCallback = ontimesetlistener;
        mInitialHourOfDay = j;
        mInitialMinute = k;
        mIs24HourView = flag;
        setIcon(0);
        setTitle(0x1040420);
        Context context1 = getContext();
        setButton(-1, context1.getText(0x1040423), this);
        View view = ((LayoutInflater)context1.getSystemService("layout_inflater")).inflate(0x10900bd, null);
        setView(view);
        mTimePicker = (TimePicker)view.findViewById(0x102034c);
        mTimePicker.setIs24HourView(Boolean.valueOf(mIs24HourView));
        mTimePicker.setCurrentHour(Integer.valueOf(mInitialHourOfDay));
        mTimePicker.setCurrentMinute(Integer.valueOf(mInitialMinute));
        mTimePicker.setOnTimeChangedListener(this);
    }

    public TimePickerDialog(Context context, OnTimeSetListener ontimesetlistener, int i, int j, boolean flag) {
        this(context, 0, ontimesetlistener, i, j, flag);
    }

    private void tryNotifyTimeSet() {
        if(mCallback != null) {
            mTimePicker.clearFocus();
            mCallback.onTimeSet(mTimePicker, mTimePicker.getCurrentHour().intValue(), mTimePicker.getCurrentMinute().intValue());
        }
    }

    public void onClick(DialogInterface dialoginterface, int i) {
        tryNotifyTimeSet();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("hour");
        int j = bundle.getInt("minute");
        mTimePicker.setIs24HourView(Boolean.valueOf(bundle.getBoolean("is24hour")));
        mTimePicker.setCurrentHour(Integer.valueOf(i));
        mTimePicker.setCurrentMinute(Integer.valueOf(j));
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle = super.onSaveInstanceState();
        bundle.putInt("hour", mTimePicker.getCurrentHour().intValue());
        bundle.putInt("minute", mTimePicker.getCurrentMinute().intValue());
        bundle.putBoolean("is24hour", mTimePicker.is24HourView());
        return bundle;
    }

    protected void onStop() {
        tryNotifyTimeSet();
        super.onStop();
    }

    public void onTimeChanged(TimePicker timepicker, int i, int j) {
    }

    public void updateTime(int i, int j) {
        mTimePicker.setCurrentHour(Integer.valueOf(i));
        mTimePicker.setCurrentMinute(Integer.valueOf(j));
    }

    private static final String HOUR = "hour";
    private static final String IS_24_HOUR = "is24hour";
    private static final String MINUTE = "minute";
    private final OnTimeSetListener mCallback;
    int mInitialHourOfDay;
    int mInitialMinute;
    boolean mIs24HourView;
    private final TimePicker mTimePicker;
}
