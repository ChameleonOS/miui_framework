// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

// Referenced classes of package android.widget:
//            FrameLayout, LinearLayout, CalendarView, NumberPicker, 
//            EditText, TextView

public class DatePicker extends FrameLayout {
    private static class SavedState extends android.view.View.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(mYear);
            parcel.writeInt(mMonth);
            parcel.writeInt(mDay);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        private final int mDay;
        private final int mMonth;
        private final int mYear;





        private SavedState(Parcel parcel) {
            super(parcel);
            mYear = parcel.readInt();
            mMonth = parcel.readInt();
            mDay = parcel.readInt();
        }


        private SavedState(Parcelable parcelable, int i, int j, int k) {
            super(parcelable);
            mYear = i;
            mMonth = j;
            mDay = k;
        }

    }

    public static interface OnDateChangedListener {

        public abstract void onDateChanged(DatePicker datepicker, int i, int j, int k);
    }

    class OnDateChangeListener
        implements NumberPicker.OnValueChangeListener {

        public void onValueChange(NumberPicker numberpicker, int i, int j) {
            updateInputState();
            mTempDate.setTimeInMillis(mCurrentDate.getTimeInMillis());
            if(numberpicker == mDaySpinner)
                mTempDate.add(5, j - i);
            else
            if(numberpicker == mMonthSpinner)
                mTempDate.add(2, j - i);
            else
            if(numberpicker == mYearSpinner)
                mTempDate.set(1, j);
            else
                throw new IllegalArgumentException();
            setDate(mTempDate.get(1), mTempDate.get(2), mTempDate.get(5));
            updateSpinners();
            updateCalendarView();
            notifyDateChanged();
        }

        final DatePicker this$0;

        OnDateChangeListener() {
            this$0 = DatePicker.this;
            super();
        }
    }


    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101035c);
    }

    public DatePicker(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.DatePicker, i, 0);
        boolean flag = typedarray.getBoolean(4, true);
        boolean flag1 = typedarray.getBoolean(5, true);
        int j = typedarray.getInt(0, 1900);
        int k = typedarray.getInt(1, 2100);
        String s = typedarray.getString(2);
        String s1 = typedarray.getString(3);
        int l = typedarray.getResourceId(6, 0x1090035);
        typedarray.recycle();
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(l, this, true);
        new NumberPicker.OnValueChangeListener() {

            public void onValueChange(NumberPicker numberpicker, int i1, int j1) {
                updateInputState();
                mTempDate.setTimeInMillis(mCurrentDate.getTimeInMillis());
                if(numberpicker == mDaySpinner) {
                    int k1 = mTempDate.getActualMaximum(5);
                    if(i1 == k1 && j1 == 1)
                        mTempDate.add(5, 1);
                    else
                    if(i1 == 1 && j1 == k1)
                        mTempDate.add(5, -1);
                    else
                        mTempDate.add(5, j1 - i1);
                } else
                if(numberpicker == mMonthSpinner) {
                    if(i1 == 11 && j1 == 0)
                        mTempDate.add(2, 1);
                    else
                    if(i1 == 0 && j1 == 11)
                        mTempDate.add(2, -1);
                    else
                        mTempDate.add(2, j1 - i1);
                } else
                if(numberpicker == mYearSpinner)
                    mTempDate.set(1, j1);
                else
                    throw new IllegalArgumentException();
                setDate(mTempDate.get(1), mTempDate.get(2), mTempDate.get(5));
                updateSpinners();
                updateCalendarView();
                notifyDateChanged();
            }

            final DatePicker this$0;

             {
                this$0 = DatePicker.this;
                super();
            }
        };
        OnDateChangeListener ondatechangelistener = new OnDateChangeListener();
        mSpinners = (LinearLayout)findViewById(0x102026e);
        mCalendarView = (CalendarView)findViewById(0x1020272);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            public void onSelectedDayChange(CalendarView calendarview, int i1, int j1, int k1) {
                setDate(i1, j1, k1);
                updateSpinners();
                notifyDateChanged();
            }

            final DatePicker this$0;

             {
                this$0 = DatePicker.this;
                super();
            }
        });
        mDaySpinner = (NumberPicker)findViewById(0x1020270);
        mDaySpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mDaySpinner.setOnLongPressUpdateInterval(100L);
        mDaySpinner.setOnValueChangedListener(ondatechangelistener);
        mDaySpinnerInput = (EditText)mDaySpinner.findViewById(0x10202fc);
        mMonthSpinner = (NumberPicker)findViewById(0x102026f);
        mMonthSpinner.setMinValue(0);
        mMonthSpinner.setMaxValue(-1 + mNumberOfMonths);
        mMonthSpinner.setDisplayedValues(mShortMonths);
        mMonthSpinner.setOnLongPressUpdateInterval(200L);
        mMonthSpinner.setOnValueChangedListener(ondatechangelistener);
        mMonthSpinnerInput = (EditText)mMonthSpinner.findViewById(0x10202fc);
        mYearSpinner = (NumberPicker)findViewById(0x1020271);
        mYearSpinner.setOnLongPressUpdateInterval(100L);
        mYearSpinner.setOnValueChangedListener(ondatechangelistener);
        mYearSpinnerInput = (EditText)mYearSpinner.findViewById(0x10202fc);
        if(!flag && !flag1) {
            setSpinnersShown(true);
        } else {
            setSpinnersShown(flag);
            setCalendarViewShown(flag1);
        }
        mTempDate.clear();
        if(!TextUtils.isEmpty(s)) {
            if(!parseDate(s, mTempDate))
                mTempDate.set(j, 0, 1);
        } else {
            mTempDate.set(j, 0, 1);
        }
        setMinDate(mTempDate.getTimeInMillis());
        mTempDate.clear();
        if(!TextUtils.isEmpty(s1)) {
            if(!parseDate(s1, mTempDate))
                mTempDate.set(k, 11, 31);
        } else {
            mTempDate.set(k, 11, 31);
        }
        setMaxDate(mTempDate.getTimeInMillis());
        mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        init(mCurrentDate.get(1), mCurrentDate.get(2), mCurrentDate.get(5), null);
        reorderSpinners();
        setContentDescriptions();
        if(getImportantForAccessibility() == 0)
            setImportantForAccessibility(1);
    }

    private Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        Calendar calendar1;
        if(calendar == null) {
            calendar1 = Calendar.getInstance(locale);
        } else {
            long l = calendar.getTimeInMillis();
            calendar1 = Calendar.getInstance(locale);
            calendar1.setTimeInMillis(l);
        }
        return calendar1;
    }

    private boolean isNewDate(int i, int j, int k) {
        boolean flag = true;
        if(mCurrentDate.get(flag) == i && mCurrentDate.get(2) == k && mCurrentDate.get(5) == j)
            flag = false;
        return flag;
    }

    private void notifyDateChanged() {
        sendAccessibilityEvent(4);
        if(mOnDateChangedListener != null)
            mOnDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth());
    }

    private boolean parseDate(String s, Calendar calendar) {
        calendar.setTime(mDateFormat.parse(s));
        boolean flag = true;
_L2:
        return flag;
        ParseException parseexception;
        parseexception;
        Log.w(LOG_TAG, (new StringBuilder()).append("Date: ").append(s).append(" not in format: ").append("MM/dd/yyyy").toString());
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void reorderSpinners() {
        char ac[];
        int i;
        int j;
        mSpinners.removeAllViews();
        ac = android.text.format.DateFormat.getDateFormatOrder(getContext());
        i = ac.length;
        j = 0;
_L2:
        if(j >= i)
            break MISSING_BLOCK_LABEL_147;
        switch(ac[j]) {
        default:
            throw new IllegalArgumentException();

        case 77: // 'M'
            break; /* Loop/switch isn't completed */

        case 121: // 'y'
            break MISSING_BLOCK_LABEL_123;

        case 100: // 'd'
            mSpinners.addView(mDaySpinner);
            setImeOptions(mDaySpinner, i, j);
            break;
        }
_L3:
        j++;
        if(true) goto _L2; else goto _L1
_L1:
        mSpinners.addView(mMonthSpinner);
        setImeOptions(mMonthSpinner, i, j);
          goto _L3
        mSpinners.addView(mYearSpinner);
        setImeOptions(mYearSpinner, i, j);
          goto _L3
    }

    private void setContentDescriptions() {
        trySetContentDescription(mDaySpinner, 0x10202fb, 0x10404b5);
        trySetContentDescription(mDaySpinner, 0x10202fd, 0x10404b6);
        trySetContentDescription(mMonthSpinner, 0x10202fb, 0x10404b3);
        trySetContentDescription(mMonthSpinner, 0x10202fd, 0x10404b4);
        trySetContentDescription(mYearSpinner, 0x10202fb, 0x10404b7);
        trySetContentDescription(mYearSpinner, 0x10202fd, 0x10404b8);
    }

    private void setCurrentLocale(Locale locale) {
        if(!locale.equals(mCurrentLocale)) {
            mCurrentLocale = locale;
            mTempDate = getCalendarForLocale(mTempDate, locale);
            mMinDate = getCalendarForLocale(mMinDate, locale);
            mMaxDate = getCalendarForLocale(mMaxDate, locale);
            mCurrentDate = getCalendarForLocale(mCurrentDate, locale);
            mNumberOfMonths = 1 + mTempDate.getActualMaximum(2);
            mShortMonths = new String[mNumberOfMonths];
            int i = 0;
            while(i < mNumberOfMonths)  {
                mShortMonths[i] = DateUtils.getMonthString(i + 0, 20);
                i++;
            }
        }
    }

    private void setDate(int i, int j, int k) {
        mCurrentDate.set(i, j, k);
        if(!mCurrentDate.before(mMinDate)) goto _L2; else goto _L1
_L1:
        mCurrentDate.setTimeInMillis(mMinDate.getTimeInMillis());
_L4:
        return;
_L2:
        if(mCurrentDate.after(mMaxDate))
            mCurrentDate.setTimeInMillis(mMaxDate.getTimeInMillis());
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void setImeOptions(NumberPicker numberpicker, int i, int j) {
        byte byte0;
        if(j < i - 1)
            byte0 = 5;
        else
            byte0 = 6;
        ((TextView)numberpicker.findViewById(0x10202fc)).setImeOptions(byte0);
    }

    private void trySetContentDescription(View view, int i, int j) {
        View view1 = view.findViewById(i);
        if(view1 != null)
            view1.setContentDescription(super.mContext.getString(j));
    }

    private void updateCalendarView() {
        mCalendarView.setDate(mCurrentDate.getTimeInMillis(), false, false);
    }

    private void updateInputState() {
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager == null) goto _L2; else goto _L1
_L1:
        if(!inputmethodmanager.isActive(mYearSpinnerInput)) goto _L4; else goto _L3
_L3:
        mYearSpinnerInput.clearFocus();
        inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
_L2:
        return;
_L4:
        if(inputmethodmanager.isActive(mMonthSpinnerInput)) {
            mMonthSpinnerInput.clearFocus();
            inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else
        if(inputmethodmanager.isActive(mDaySpinnerInput)) {
            mDaySpinnerInput.clearFocus();
            inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        if(true) goto _L2; else goto _L5
_L5:
    }

    private void updateSpinners() {
        String as[];
        if(mCurrentDate.equals(mMinDate)) {
            mDaySpinner.setMinValue(mCurrentDate.get(5));
            mDaySpinner.setMaxValue(mCurrentDate.getActualMaximum(5));
            mDaySpinner.setWrapSelectorWheel(false);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(mCurrentDate.get(2));
            mMonthSpinner.setMaxValue(mCurrentDate.getActualMaximum(2));
            mMonthSpinner.setWrapSelectorWheel(false);
        } else
        if(mCurrentDate.equals(mMaxDate)) {
            mDaySpinner.setMinValue(mCurrentDate.getActualMinimum(5));
            mDaySpinner.setMaxValue(mCurrentDate.get(5));
            mDaySpinner.setWrapSelectorWheel(false);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(mCurrentDate.getActualMinimum(2));
            mMonthSpinner.setMaxValue(mCurrentDate.get(2));
            mMonthSpinner.setWrapSelectorWheel(false);
        } else {
            mDaySpinner.setMinValue(1);
            mDaySpinner.setMaxValue(mCurrentDate.getActualMaximum(5));
            mDaySpinner.setWrapSelectorWheel(true);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(0);
            mMonthSpinner.setMaxValue(11);
            mMonthSpinner.setWrapSelectorWheel(true);
        }
        as = (String[])Arrays.copyOfRange(mShortMonths, mMonthSpinner.getMinValue(), 1 + mMonthSpinner.getMaxValue());
        mMonthSpinner.setDisplayedValues(as);
        mYearSpinner.setMinValue(mMinDate.get(1));
        mYearSpinner.setMaxValue(mMaxDate.get(1));
        mYearSpinner.setWrapSelectorWheel(false);
        mYearSpinner.setValue(mCurrentDate.get(1));
        mMonthSpinner.setValue(mCurrentDate.get(2));
        mDaySpinner.setValue(mCurrentDate.get(5));
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onPopulateAccessibilityEvent(accessibilityevent);
        return true;
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray) {
        dispatchThawSelfOnly(sparsearray);
    }

    public CalendarView getCalendarView() {
        return mCalendarView;
    }

    public boolean getCalendarViewShown() {
        return mCalendarView.isShown();
    }

    public int getDayOfMonth() {
        return mCurrentDate.get(5);
    }

    public long getMaxDate() {
        return mCalendarView.getMaxDate();
    }

    public long getMinDate() {
        return mCalendarView.getMinDate();
    }

    public int getMonth() {
        return mCurrentDate.get(2);
    }

    public boolean getSpinnersShown() {
        return mSpinners.isShown();
    }

    public int getYear() {
        return mCurrentDate.get(1);
    }

    public void init(int i, int j, int k, OnDateChangedListener ondatechangedlistener) {
        setDate(i, j, k);
        updateSpinners();
        updateCalendarView();
        mOnDateChangedListener = ondatechangedlistener;
    }

    public boolean isEnabled() {
        return mIsEnabled;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/DatePicker.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/DatePicker.getName());
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onPopulateAccessibilityEvent(accessibilityevent);
        String s = DateUtils.formatDateTime(super.mContext, mCurrentDate.getTimeInMillis(), 20);
        accessibilityevent.getText().add(s);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        setDate(savedstate.mYear, savedstate.mMonth, savedstate.mDay);
        updateSpinners();
        updateCalendarView();
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth());
    }

    public void setCalendarViewShown(boolean flag) {
        CalendarView calendarview = mCalendarView;
        int i;
        if(flag)
            i = 0;
        else
            i = 8;
        calendarview.setVisibility(i);
    }

    public void setEnabled(boolean flag) {
        if(mIsEnabled != flag) {
            super.setEnabled(flag);
            mDaySpinner.setEnabled(flag);
            mMonthSpinner.setEnabled(flag);
            mYearSpinner.setEnabled(flag);
            mCalendarView.setEnabled(flag);
            mIsEnabled = flag;
        }
    }

    public void setMaxDate(long l) {
        mTempDate.setTimeInMillis(l);
        if(mTempDate.get(1) != mMaxDate.get(1) || mTempDate.get(6) == mMaxDate.get(6)) {
            mMaxDate.setTimeInMillis(l);
            mCalendarView.setMaxDate(l);
            if(mCurrentDate.after(mMaxDate)) {
                mCurrentDate.setTimeInMillis(mMaxDate.getTimeInMillis());
                updateCalendarView();
            }
            updateSpinners();
        }
    }

    public void setMinDate(long l) {
        mTempDate.setTimeInMillis(l);
        if(mTempDate.get(1) != mMinDate.get(1) || mTempDate.get(6) == mMinDate.get(6)) {
            mMinDate.setTimeInMillis(l);
            mCalendarView.setMinDate(l);
            if(mCurrentDate.before(mMinDate)) {
                mCurrentDate.setTimeInMillis(mMinDate.getTimeInMillis());
                updateCalendarView();
            }
            updateSpinners();
        }
    }

    public void setSpinnersShown(boolean flag) {
        LinearLayout linearlayout = mSpinners;
        int i;
        if(flag)
            i = 0;
        else
            i = 8;
        linearlayout.setVisibility(i);
    }

    public void updateDate(int i, int j, int k) {
        if(isNewDate(i, j, k)) {
            setDate(i, j, k);
            updateSpinners();
            updateCalendarView();
            notifyDateChanged();
        }
    }

    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final boolean DEFAULT_CALENDAR_VIEW_SHOWN = true;
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final boolean DEFAULT_SPINNERS_SHOWN = true;
    private static final int DEFAULT_START_YEAR = 1900;
    private static final String LOG_TAG = android/widget/DatePicker.getSimpleName();
    private final CalendarView mCalendarView;
    private Calendar mCurrentDate;
    private Locale mCurrentLocale;
    private final DateFormat mDateFormat;
    private final NumberPicker mDaySpinner;
    private final EditText mDaySpinnerInput;
    private boolean mIsEnabled;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private final NumberPicker mMonthSpinner;
    private final EditText mMonthSpinnerInput;
    private int mNumberOfMonths;
    private OnDateChangedListener mOnDateChangedListener;
    private String mShortMonths[];
    private final LinearLayout mSpinners;
    private Calendar mTempDate;
    private final NumberPicker mYearSpinner;
    private final EditText mYearSpinnerInput;











}
