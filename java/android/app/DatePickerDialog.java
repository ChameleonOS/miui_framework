// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import java.util.Calendar;

// Referenced classes of package android.app:
//            AlertDialog, Dialog

public class DatePickerDialog extends AlertDialog
    implements android.content.DialogInterface.OnClickListener, android.widget.DatePicker.OnDateChangedListener {
    public static interface OnDateSetListener {

        public abstract void onDateSet(DatePicker datepicker, int i, int j, int k);
    }


    public DatePickerDialog(Context context, int i, OnDateSetListener ondatesetlistener, int j, int k, int l) {
        super(context, i);
        mTitleNeedsUpdate = true;
        mCallBack = ondatesetlistener;
        mCalendar = Calendar.getInstance();
        Context context1 = getContext();
        setButton(-1, context1.getText(0x1040423), this);
        setIcon(0);
        View view = ((LayoutInflater)context1.getSystemService("layout_inflater")).inflate(0x1090036, null);
        setView(view);
        mDatePicker = (DatePicker)view.findViewById(0x1020273);
        mDatePicker.init(j, k, l, this);
        updateTitle(j, k, l);
    }

    public DatePickerDialog(Context context, OnDateSetListener ondatesetlistener, int i, int j, int k) {
        this(context, 0, ondatesetlistener, i, j, k);
    }

    private void tryNotifyDateSet() {
        if(mCallBack != null) {
            mDatePicker.clearFocus();
            mCallBack.onDateSet(mDatePicker, mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
        }
    }

    private void updateTitle(int i, int j, int k) {
        if(mDatePicker.getCalendarViewShown()) goto _L2; else goto _L1
_L1:
        mCalendar.set(1, i);
        mCalendar.set(2, j);
        mCalendar.set(5, k);
        setTitle(DateUtils.formatDateTime(super.mContext, mCalendar.getTimeInMillis(), 0x18016));
        mTitleNeedsUpdate = true;
_L4:
        return;
_L2:
        if(mTitleNeedsUpdate) {
            mTitleNeedsUpdate = false;
            setTitle(0x1040421);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public DatePicker getDatePicker() {
        return mDatePicker;
    }

    public void onClick(DialogInterface dialoginterface, int i) {
        tryNotifyDateSet();
    }

    public void onDateChanged(DatePicker datepicker, int i, int j, int k) {
        mDatePicker.init(i, j, k, this);
        updateTitle(i, j, k);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("year");
        int j = bundle.getInt("month");
        int k = bundle.getInt("day");
        mDatePicker.init(i, j, k, this);
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle = super.onSaveInstanceState();
        bundle.putInt("year", mDatePicker.getYear());
        bundle.putInt("month", mDatePicker.getMonth());
        bundle.putInt("day", mDatePicker.getDayOfMonth());
        return bundle;
    }

    protected void onStop() {
        tryNotifyDateSet();
        super.onStop();
    }

    public void updateDate(int i, int j, int k) {
        mDatePicker.updateDate(i, j, k);
    }

    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private final Calendar mCalendar;
    private final OnDateSetListener mCallBack;
    private final DatePicker mDatePicker;
    private boolean mTitleNeedsUpdate;
}
