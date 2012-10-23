// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;

// Referenced classes of package android.preference:
//            DialogPreference

public class ListPreference extends DialogPreference {
    private static class SavedState extends Preference.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(value);
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
        String value;


        public SavedState(Parcel parcel) {
            super(parcel);
            value = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }


    public ListPreference(Context context) {
        this(context, null);
    }

    public ListPreference(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ListPreference, 0, 0);
        mEntries = typedarray.getTextArray(0);
        mEntryValues = typedarray.getTextArray(1);
        typedarray.recycle();
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Preference, 0, 0);
        mSummary = typedarray1.getString(7);
        typedarray1.recycle();
    }

    private int getValueIndex() {
        return findIndexOfValue(mValue);
    }

    public int findIndexOfValue(String s) {
        int i;
        if(s == null || mEntryValues == null)
            break MISSING_BLOCK_LABEL_45;
        i = -1 + mEntryValues.length;
_L3:
        if(i < 0)
            break MISSING_BLOCK_LABEL_45;
        if(!mEntryValues[i].equals(s)) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i--;
          goto _L3
        i = -1;
          goto _L1
    }

    public CharSequence[] getEntries() {
        return mEntries;
    }

    public CharSequence getEntry() {
        int i = getValueIndex();
        CharSequence charsequence;
        if(i >= 0 && mEntries != null)
            charsequence = mEntries[i];
        else
            charsequence = null;
        return charsequence;
    }

    public CharSequence[] getEntryValues() {
        return mEntryValues;
    }

    public CharSequence getSummary() {
        CharSequence charsequence = getEntry();
        Object obj;
        if(mSummary == null || charsequence == null) {
            obj = super.getSummary();
        } else {
            String s = mSummary;
            Object aobj[] = new Object[1];
            aobj[0] = charsequence;
            obj = String.format(s, aobj);
        }
        return ((CharSequence) (obj));
    }

    public String getValue() {
        return mValue;
    }

    protected void onDialogClosed(boolean flag) {
        super.onDialogClosed(flag);
        if(flag && mClickedDialogEntryIndex >= 0 && mEntryValues != null) {
            String s = mEntryValues[mClickedDialogEntryIndex].toString();
            if(callChangeListener(s))
                setValue(s);
        }
    }

    protected Object onGetDefaultValue(TypedArray typedarray, int i) {
        return typedarray.getString(i);
    }

    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        if(mEntries == null || mEntryValues == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        } else {
            mClickedDialogEntryIndex = getValueIndex();
            builder.setSingleChoiceItems(mEntries, mClickedDialogEntryIndex, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int i) {
                    mClickedDialogEntryIndex = i;
                    ListPreference.this.onClick(dialoginterface, -1);
                    dialoginterface.dismiss();
                }

                final ListPreference this$0;

             {
                this$0 = ListPreference.this;
                super();
            }
            });
            builder.setPositiveButton(null, null);
            return;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable == null || !parcelable.getClass().equals(android/preference/ListPreference$SavedState)) {
            super.onRestoreInstanceState(parcelable);
        } else {
            SavedState savedstate = (SavedState)parcelable;
            super.onRestoreInstanceState(savedstate.getSuperState());
            setValue(savedstate.value);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Object obj = super.onSaveInstanceState();
        if(!isPersistent()) {
            SavedState savedstate = new SavedState(((Parcelable) (obj)));
            savedstate.value = getValue();
            obj = savedstate;
        }
        return ((Parcelable) (obj));
    }

    protected void onSetInitialValue(boolean flag, Object obj) {
        String s;
        if(flag)
            s = getPersistedString(mValue);
        else
            s = (String)obj;
        setValue(s);
    }

    public void setEntries(int i) {
        setEntries(getContext().getResources().getTextArray(i));
    }

    public void setEntries(CharSequence acharsequence[]) {
        mEntries = acharsequence;
    }

    public void setEntryValues(int i) {
        setEntryValues(getContext().getResources().getTextArray(i));
    }

    public void setEntryValues(CharSequence acharsequence[]) {
        mEntryValues = acharsequence;
    }

    public void setSummary(CharSequence charsequence) {
        super.setSummary(charsequence);
        if(charsequence != null || mSummary == null) goto _L2; else goto _L1
_L1:
        mSummary = null;
_L4:
        return;
_L2:
        if(charsequence != null && !charsequence.equals(mSummary))
            mSummary = charsequence.toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setValue(String s) {
        mValue = s;
        persistString(s);
    }

    public void setValueIndex(int i) {
        if(mEntryValues != null)
            setValue(mEntryValues[i].toString());
    }

    private int mClickedDialogEntryIndex;
    private CharSequence mEntries[];
    private CharSequence mEntryValues[];
    private String mSummary;
    private String mValue;


/*
    static int access$002(ListPreference listpreference, int i) {
        listpreference.mClickedDialogEntryIndex = i;
        return i;
    }

*/
}
