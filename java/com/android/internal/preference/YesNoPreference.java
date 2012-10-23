// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.DialogPreference;
import android.util.AttributeSet;

public class YesNoPreference extends DialogPreference {
    private static class SavedState extends android.preference.Preference.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int j;
            if(wasPositiveResult)
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
        boolean wasPositiveResult;


        public SavedState(Parcel parcel) {
            boolean flag = true;
            super(parcel);
            if(parcel.readInt() != flag)
                flag = false;
            wasPositiveResult = flag;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }


    public YesNoPreference(Context context) {
        this(context, null);
    }

    public YesNoPreference(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010090);
    }

    public YesNoPreference(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    public boolean getValue() {
        return mWasPositiveResult;
    }

    protected void onDialogClosed(boolean flag) {
        super.onDialogClosed(flag);
        if(callChangeListener(Boolean.valueOf(flag)))
            setValue(flag);
    }

    protected Object onGetDefaultValue(TypedArray typedarray, int i) {
        return Boolean.valueOf(typedarray.getBoolean(i, false));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if(!parcelable.getClass().equals(com/android/internal/preference/YesNoPreference$SavedState)) {
            super.onRestoreInstanceState(parcelable);
        } else {
            SavedState savedstate = (SavedState)parcelable;
            super.onRestoreInstanceState(savedstate.getSuperState());
            setValue(savedstate.wasPositiveResult);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Object obj = super.onSaveInstanceState();
        if(!isPersistent()) {
            SavedState savedstate = new SavedState(((Parcelable) (obj)));
            savedstate.wasPositiveResult = getValue();
            obj = savedstate;
        }
        return ((Parcelable) (obj));
    }

    protected void onSetInitialValue(boolean flag, Object obj) {
        boolean flag1;
        if(flag)
            flag1 = getPersistedBoolean(mWasPositiveResult);
        else
            flag1 = ((Boolean)obj).booleanValue();
        setValue(flag1);
    }

    public void setValue(boolean flag) {
        mWasPositiveResult = flag;
        persistBoolean(flag);
        boolean flag1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        notifyDependencyChange(flag1);
    }

    public boolean shouldDisableDependents() {
        boolean flag;
        if(!mWasPositiveResult || super.shouldDisableDependents())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean mWasPositiveResult;
}
