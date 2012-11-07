// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import java.text.DateFormatSymbols;
import java.util.*;

// Referenced classes of package android.widget:
//            FrameLayout, NumberPicker, EditText, TextView, 
//            Button

public class TimePicker extends FrameLayout {
    private static class SavedState extends android.view.View.BaseSavedState {

        public int getHour() {
            return mHour;
        }

        public int getMinute() {
            return mMinute;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(mHour);
            parcel.writeInt(mMinute);
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
        private final int mHour;
        private final int mMinute;


        private SavedState(Parcel parcel) {
            super(parcel);
            mHour = parcel.readInt();
            mMinute = parcel.readInt();
        }


        private SavedState(Parcelable parcelable, int i, int j) {
            super(parcelable);
            mHour = i;
            mMinute = j;
        }

    }

    public static interface OnTimeChangedListener {

        public abstract void onTimeChanged(TimePicker timepicker, int i, int j);
    }

    class OnMinuteChangeListener
        implements NumberPicker.OnValueChangeListener {

        public void onValueChange(NumberPicker numberpicker, int i, int j) {
            callUpdateInputState();
            callOnTimeChanged();
        }

        final TimePicker this$0;

        OnMinuteChangeListener() {
            this$0 = TimePicker.this;
            super();
        }
    }


    public TimePicker(Context context) {
        this(context, null);
    }

    public TimePicker(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x10103c3);
    }

    public TimePicker(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.TimePicker, i, 0);
        int j = typedarray.getResourceId(0, 0x10900bc);
        typedarray.recycle();
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(j, this, true);
        mHourSpinner = (NumberPicker)findViewById(0x102034e);
        mHourSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            public void onValueChange(NumberPicker numberpicker, int k, int l) {
                updateInputState();
                if(!is24HourView() && (k == 11 && l == 12 || k == 12 && l == 11)) {
                    TimePicker timepicker = TimePicker.this;
                    boolean flag;
                    if(!mIsAm)
                        flag = true;
                    else
                        flag = false;
                    timepicker.mIsAm = flag;
                    updateAmPmControl();
                }
                onTimeChanged();
            }

            final TimePicker this$0;

             {
                this$0 = TimePicker.this;
                super();
            }
        });
        mHourSpinnerInput = (EditText)mHourSpinner.findViewById(0x10202fc);
        mHourSpinnerInput.setImeOptions(5);
        mDivider = (TextView)findViewById(0x1020352);
        if(mDivider != null)
            mDivider.setText(0x10400bc);
        mMinuteSpinner = (NumberPicker)findViewById(0x102034f);
        mMinuteSpinner.setMinValue(0);
        mMinuteSpinner.setMaxValue(59);
        mMinuteSpinner.setOnLongPressUpdateInterval(100L);
        mMinuteSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mMinuteSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            public void onValueChange(NumberPicker numberpicker, int k, int l) {
                boolean flag;
                int i1;
                int j1;
                flag = true;
                updateInputState();
                i1 = mMinuteSpinner.getMinValue();
                j1 = mMinuteSpinner.getMaxValue();
                if(k != j1 || l != i1) goto _L2; else goto _L1
_L1:
                int l1 = 1 + mHourSpinner.getValue();
                if(!is24HourView() && l1 == 12) {
                    TimePicker timepicker1 = TimePicker.this;
                    if(mIsAm)
                        flag = false;
                    timepicker1.mIsAm = flag;
                    updateAmPmControl();
                }
                mHourSpinner.setValue(l1);
_L4:
                onTimeChanged();
                return;
_L2:
                if(k == i1 && l == j1) {
                    int k1 = -1 + mHourSpinner.getValue();
                    if(!is24HourView() && k1 == 11) {
                        TimePicker timepicker = TimePicker.this;
                        if(mIsAm)
                            flag = false;
                        timepicker.mIsAm = flag;
                        updateAmPmControl();
                    }
                    mHourSpinner.setValue(k1);
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final TimePicker this$0;

             {
                this$0 = TimePicker.this;
                super();
            }
        });
        mMinuteSpinner.setOnValueChangedListener(new OnMinuteChangeListener());
        mMinuteSpinnerInput = (EditText)mMinuteSpinner.findViewById(0x10202fc);
        mMinuteSpinnerInput.setImeOptions(5);
        mAmPmStrings = (new DateFormatSymbols()).getAmPmStrings();
        View view = findViewById(0x1020350);
        if(view instanceof Button) {
            mAmPmSpinner = null;
            mAmPmSpinnerInput = null;
            mAmPmButton = (Button)view;
            mAmPmButton.setOnClickListener(new android.view.View.OnClickListener() {

                public void onClick(View view1) {
                    view1.requestFocus();
                    TimePicker timepicker = TimePicker.this;
                    boolean flag;
                    if(!mIsAm)
                        flag = true;
                    else
                        flag = false;
                    timepicker.mIsAm = flag;
                    updateAmPmControl();
                    onTimeChanged();
                }

                final TimePicker this$0;

             {
                this$0 = TimePicker.this;
                super();
            }
            });
        } else {
            mAmPmButton = null;
            mAmPmSpinner = (NumberPicker)view;
            mAmPmSpinner.setMinValue(0);
            mAmPmSpinner.setMaxValue(1);
            mAmPmSpinner.setDisplayedValues(mAmPmStrings);
            mAmPmSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

                public void onValueChange(NumberPicker numberpicker, int k, int l) {
                    updateInputState();
                    numberpicker.requestFocus();
                    TimePicker timepicker = TimePicker.this;
                    boolean flag;
                    if(!mIsAm)
                        flag = true;
                    else
                        flag = false;
                    timepicker.mIsAm = flag;
                    updateAmPmControl();
                    onTimeChanged();
                }

                final TimePicker this$0;

             {
                this$0 = TimePicker.this;
                super();
            }
            });
            mAmPmSpinnerInput = (EditText)mAmPmSpinner.findViewById(0x10202fc);
            mAmPmSpinnerInput.setImeOptions(6);
        }
        updateHourControl();
        updateAmPmControl();
        setOnTimeChangedListener(NO_OP_CHANGE_LISTENER);
        setCurrentHour(Integer.valueOf(mTempCalendar.get(11)));
        setCurrentMinute(Integer.valueOf(mTempCalendar.get(12)));
        if(!isEnabled())
            setEnabled(false);
        setContentDescriptions();
        if(getImportantForAccessibility() == 0)
            setImportantForAccessibility(1);
    }

    private void onTimeChanged() {
        sendAccessibilityEvent(4);
        if(mOnTimeChangedListener != null)
            mOnTimeChangedListener.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
    }

    private void setContentDescriptions() {
        trySetContentDescription(mMinuteSpinner, 0x10202fb, 0x10404ad);
        trySetContentDescription(mMinuteSpinner, 0x10202fd, 0x10404ae);
        trySetContentDescription(mHourSpinner, 0x10202fb, 0x10404af);
        trySetContentDescription(mHourSpinner, 0x10202fd, 0x10404b0);
        if(mAmPmSpinner != null) {
            trySetContentDescription(mAmPmSpinner, 0x10202fb, 0x10404b1);
            trySetContentDescription(mAmPmSpinner, 0x10202fd, 0x10404b2);
        }
    }

    private void setCurrentLocale(Locale locale) {
        if(!locale.equals(mCurrentLocale)) {
            mCurrentLocale = locale;
            mTempCalendar = Calendar.getInstance(locale);
        }
    }

    private void trySetContentDescription(View view, int i, int j) {
        View view1 = view.findViewById(i);
        if(view1 != null)
            view1.setContentDescription(super.mContext.getString(j));
    }

    private void updateAmPmControl() {
        if(is24HourView()) {
            if(mAmPmSpinner != null)
                mAmPmSpinner.setVisibility(8);
            else
                mAmPmButton.setVisibility(8);
        } else {
            int i;
            if(mIsAm)
                i = 0;
            else
                i = 1;
            if(mAmPmSpinner != null) {
                mAmPmSpinner.setValue(i);
                mAmPmSpinner.setVisibility(0);
            } else {
                mAmPmButton.setText(mAmPmStrings[i]);
                mAmPmButton.setVisibility(0);
            }
        }
        sendAccessibilityEvent(4);
    }

    private void updateHourControl() {
        if(is24HourView()) {
            mHourSpinner.setMinValue(0);
            mHourSpinner.setMaxValue(23);
            mHourSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        } else {
            mHourSpinner.setMinValue(1);
            mHourSpinner.setMaxValue(12);
            mHourSpinner.setFormatter(null);
        }
    }

    private void updateInputState() {
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager == null) goto _L2; else goto _L1
_L1:
        if(!inputmethodmanager.isActive(mHourSpinnerInput)) goto _L4; else goto _L3
_L3:
        mHourSpinnerInput.clearFocus();
        inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
_L2:
        return;
_L4:
        if(inputmethodmanager.isActive(mMinuteSpinnerInput)) {
            mMinuteSpinnerInput.clearFocus();
            inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else
        if(inputmethodmanager.isActive(mAmPmSpinnerInput)) {
            mAmPmSpinnerInput.clearFocus();
            inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        if(true) goto _L2; else goto _L5
_L5:
    }

    void callOnTimeChanged() {
        onTimeChanged();
    }

    void callUpdateInputState() {
        updateInputState();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onPopulateAccessibilityEvent(accessibilityevent);
        return true;
    }

    public int getBaseline() {
        return mHourSpinner.getBaseline();
    }

    public Integer getCurrentHour() {
        int i = mHourSpinner.getValue();
        Integer integer;
        if(is24HourView())
            integer = Integer.valueOf(i);
        else
        if(mIsAm)
            integer = Integer.valueOf(i % 12);
        else
            integer = Integer.valueOf(12 + i % 12);
        return integer;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(mMinuteSpinner.getValue());
    }

    public boolean is24HourView() {
        return mIs24HourView;
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
        accessibilityevent.setClassName(android/widget/TimePicker.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/TimePicker.getName());
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onPopulateAccessibilityEvent(accessibilityevent);
        int i;
        String s;
        if(mIs24HourView)
            i = 1 | 0x80;
        else
            i = 1 | 0x40;
        mTempCalendar.set(11, getCurrentHour().intValue());
        mTempCalendar.set(12, getCurrentMinute().intValue());
        s = DateUtils.formatDateTime(super.mContext, mTempCalendar.getTimeInMillis(), i);
        accessibilityevent.getText().add(s);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        setCurrentHour(Integer.valueOf(savedstate.getHour()));
        setCurrentMinute(Integer.valueOf(savedstate.getMinute()));
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue());
    }

    public void setCurrentHour(Integer integer) {
        if(integer != null && integer != getCurrentHour()) {
            if(!is24HourView()) {
                if(integer.intValue() >= 12) {
                    mIsAm = false;
                    if(integer.intValue() > 12)
                        integer = Integer.valueOf(-12 + integer.intValue());
                } else {
                    mIsAm = true;
                    if(integer.intValue() == 0)
                        integer = Integer.valueOf(12);
                }
                updateAmPmControl();
            }
            mHourSpinner.setValue(integer.intValue());
            onTimeChanged();
        }
    }

    public void setCurrentMinute(Integer integer) {
        if(integer != getCurrentMinute()) {
            mMinuteSpinner.setValue(integer.intValue());
            onTimeChanged();
        }
    }

    public void setEnabled(boolean flag) {
        if(mIsEnabled != flag) {
            super.setEnabled(flag);
            mMinuteSpinner.setEnabled(flag);
            if(mDivider != null)
                mDivider.setEnabled(flag);
            mHourSpinner.setEnabled(flag);
            if(mAmPmSpinner != null)
                mAmPmSpinner.setEnabled(flag);
            else
                mAmPmButton.setEnabled(flag);
            mIsEnabled = flag;
        }
    }

    public void setIs24HourView(Boolean boolean1) {
        if(mIs24HourView != boolean1.booleanValue()) {
            mIs24HourView = boolean1.booleanValue();
            int i = getCurrentHour().intValue();
            updateHourControl();
            setCurrentHour(Integer.valueOf(i));
            updateAmPmControl();
        }
    }

    public void setOnTimeChangedListener(OnTimeChangedListener ontimechangedlistener) {
        mOnTimeChangedListener = ontimechangedlistener;
    }

    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int HOURS_IN_HALF_DAY = 12;
    private static final OnTimeChangedListener NO_OP_CHANGE_LISTENER = new OnTimeChangedListener() {

        public void onTimeChanged(TimePicker timepicker, int i, int j) {
        }

    };
    private final Button mAmPmButton;
    private final NumberPicker mAmPmSpinner;
    private final EditText mAmPmSpinnerInput;
    private final String mAmPmStrings[];
    private Locale mCurrentLocale;
    private final TextView mDivider;
    private final NumberPicker mHourSpinner;
    private final EditText mHourSpinnerInput;
    private boolean mIs24HourView;
    private boolean mIsAm;
    private boolean mIsEnabled;
    private final NumberPicker mMinuteSpinner;
    private final EditText mMinuteSpinnerInput;
    private OnTimeChangedListener mOnTimeChangedListener;
    private Calendar mTempCalendar;





/*
    static boolean access$102(TimePicker timepicker, boolean flag) {
        timepicker.mIsAm = flag;
        return flag;
    }

*/




}
