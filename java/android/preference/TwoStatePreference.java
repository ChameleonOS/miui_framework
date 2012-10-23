// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;

// Referenced classes of package android.preference:
//            Preference

public abstract class TwoStatePreference extends Preference {
    static class SavedState extends Preference.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int j;
            if(checked)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
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
        boolean checked;


        public SavedState(Parcel parcel) {
            boolean flag = true;
            super(parcel);
            if(parcel.readInt() != flag)
                flag = false;
            checked = flag;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }


    public TwoStatePreference(Context context) {
        this(context, null);
    }

    public TwoStatePreference(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    public boolean getDisableDependentsState() {
        return mDisableDependentsState;
    }

    public CharSequence getSummaryOff() {
        return mSummaryOff;
    }

    public CharSequence getSummaryOn() {
        return mSummaryOn;
    }

    public boolean isChecked() {
        return mChecked;
    }

    protected void onClick() {
        super.onClick();
        boolean flag;
        if(!isChecked())
            flag = true;
        else
            flag = false;
        mSendClickAccessibilityEvent = true;
        if(callChangeListener(Boolean.valueOf(flag)))
            setChecked(flag);
    }

    protected Object onGetDefaultValue(TypedArray typedarray, int i) {
        return Boolean.valueOf(typedarray.getBoolean(i, false));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable == null || !parcelable.getClass().equals(android/preference/TwoStatePreference$SavedState)) {
            super.onRestoreInstanceState(parcelable);
        } else {
            SavedState savedstate = (SavedState)parcelable;
            super.onRestoreInstanceState(savedstate.getSuperState());
            setChecked(savedstate.checked);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Object obj = super.onSaveInstanceState();
        if(!isPersistent()) {
            SavedState savedstate = new SavedState(((Parcelable) (obj)));
            savedstate.checked = isChecked();
            obj = savedstate;
        }
        return ((Parcelable) (obj));
    }

    protected void onSetInitialValue(boolean flag, Object obj) {
        boolean flag1;
        if(flag)
            flag1 = getPersistedBoolean(mChecked);
        else
            flag1 = ((Boolean)obj).booleanValue();
        setChecked(flag1);
    }

    void sendAccessibilityEvent(View view) {
        AccessibilityManager accessibilitymanager = AccessibilityManager.getInstance(getContext());
        if(mSendClickAccessibilityEvent && accessibilitymanager.isEnabled()) {
            AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain();
            accessibilityevent.setEventType(1);
            view.onInitializeAccessibilityEvent(accessibilityevent);
            view.dispatchPopulateAccessibilityEvent(accessibilityevent);
            accessibilitymanager.sendAccessibilityEvent(accessibilityevent);
        }
        mSendClickAccessibilityEvent = false;
    }

    public void setChecked(boolean flag) {
        if(mChecked != flag) {
            mChecked = flag;
            persistBoolean(flag);
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setDisableDependentsState(boolean flag) {
        mDisableDependentsState = flag;
    }

    public void setSummaryOff(int i) {
        setSummaryOff(((CharSequence) (getContext().getString(i))));
    }

    public void setSummaryOff(CharSequence charsequence) {
        mSummaryOff = charsequence;
        if(!isChecked())
            notifyChanged();
    }

    public void setSummaryOn(int i) {
        setSummaryOn(((CharSequence) (getContext().getString(i))));
    }

    public void setSummaryOn(CharSequence charsequence) {
        mSummaryOn = charsequence;
        if(isChecked())
            notifyChanged();
    }

    public boolean shouldDisableDependents() {
        boolean flag = false;
        boolean flag1;
        if(mDisableDependentsState)
            flag1 = mChecked;
        else
        if(!mChecked)
            flag1 = true;
        else
            flag1 = false;
        if(flag1 || super.shouldDisableDependents())
            flag = true;
        return flag;
    }

    void syncSummaryView(View view) {
        TextView textview = (TextView)view.findViewById(0x1020010);
        if(textview == null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
        if(!mChecked || mSummaryOn == null) goto _L4; else goto _L3
_L3:
        textview.setText(mSummaryOn);
        flag = false;
_L6:
        if(flag) {
            CharSequence charsequence = getSummary();
            if(charsequence != null) {
                textview.setText(charsequence);
                flag = false;
            }
        }
        byte byte0 = 8;
        if(!flag)
            byte0 = 0;
        if(byte0 != textview.getVisibility())
            textview.setVisibility(byte0);
_L2:
        return;
_L4:
        if(!mChecked && mSummaryOff != null) {
            textview.setText(mSummaryOff);
            flag = false;
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    boolean mChecked;
    private boolean mDisableDependentsState;
    private boolean mSendClickAccessibilityEvent;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;
}
