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
import java.util.Arrays;

// Referenced classes of package android.preference:
//            DialogPreference

public class MultiCheckPreference extends DialogPreference {
    private static class SavedState extends Preference.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBooleanArray(values);
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
        boolean values[];


        public SavedState(Parcel parcel) {
            super(parcel);
            values = parcel.createBooleanArray();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }


    public MultiCheckPreference(Context context) {
        this(context, null);
    }

    public MultiCheckPreference(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ListPreference, 0, 0);
        mEntries = typedarray.getTextArray(0);
        if(mEntries != null)
            setEntries(mEntries);
        setEntryValuesCS(typedarray.getTextArray(1));
        typedarray.recycle();
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Preference, 0, 0);
        mSummary = typedarray1.getString(7);
        typedarray1.recycle();
    }

    private void setEntryValuesCS(CharSequence acharsequence[]) {
        setValues(null);
        if(acharsequence != null) {
            mEntryValues = new String[acharsequence.length];
            for(int i = 0; i < acharsequence.length; i++)
                mEntryValues[i] = acharsequence[i].toString();

        }
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

    public String[] getEntryValues() {
        return mEntryValues;
    }

    public CharSequence getSummary() {
        Object obj;
        if(mSummary == null)
            obj = super.getSummary();
        else
            obj = mSummary;
        return ((CharSequence) (obj));
    }

    public boolean getValue(int i) {
        return mSetValues[i];
    }

    public boolean[] getValues() {
        return mSetValues;
    }

    protected void onDialogClosed(boolean flag) {
        super.onDialogClosed(flag);
        if(!flag || !callChangeListener(getValues()))
            System.arraycopy(mOrigValues, 0, mSetValues, 0, mSetValues.length);
    }

    protected Object onGetDefaultValue(TypedArray typedarray, int i) {
        return typedarray.getString(i);
    }

    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        if(mEntries == null || mEntryValues == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        } else {
            mOrigValues = Arrays.copyOf(mSetValues, mSetValues.length);
            builder.setMultiChoiceItems(mEntries, mSetValues, new android.content.DialogInterface.OnMultiChoiceClickListener() {

                public void onClick(DialogInterface dialoginterface, int i, boolean flag) {
                    mSetValues[i] = flag;
                }

                final MultiCheckPreference this$0;

             {
                this$0 = MultiCheckPreference.this;
                super();
            }
            });
            return;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable == null || !parcelable.getClass().equals(android/preference/MultiCheckPreference$SavedState)) {
            super.onRestoreInstanceState(parcelable);
        } else {
            SavedState savedstate = (SavedState)parcelable;
            super.onRestoreInstanceState(savedstate.getSuperState());
            setValues(savedstate.values);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Object obj = super.onSaveInstanceState();
        if(!isPersistent()) {
            SavedState savedstate = new SavedState(((Parcelable) (obj)));
            savedstate.values = getValues();
            obj = savedstate;
        }
        return ((Parcelable) (obj));
    }

    protected void onSetInitialValue(boolean flag, Object obj) {
    }

    public void setEntries(int i) {
        setEntries(getContext().getResources().getTextArray(i));
    }

    public void setEntries(CharSequence acharsequence[]) {
        mEntries = acharsequence;
        mSetValues = new boolean[acharsequence.length];
        mOrigValues = new boolean[acharsequence.length];
    }

    public void setEntryValues(int i) {
        setEntryValuesCS(getContext().getResources().getTextArray(i));
    }

    public void setEntryValues(String as[]) {
        mEntryValues = as;
        Arrays.fill(mSetValues, false);
        Arrays.fill(mOrigValues, false);
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

    public void setValue(int i, boolean flag) {
        mSetValues[i] = flag;
    }

    public void setValues(boolean aflag[]) {
        if(mSetValues != null) {
            Arrays.fill(mSetValues, false);
            Arrays.fill(mOrigValues, false);
            if(aflag != null) {
                boolean aflag1[] = mSetValues;
                int i;
                if(aflag.length < mSetValues.length)
                    i = aflag.length;
                else
                    i = mSetValues.length;
                System.arraycopy(aflag, 0, aflag1, 0, i);
            }
        }
    }

    private CharSequence mEntries[];
    private String mEntryValues[];
    private boolean mOrigValues[];
    private boolean mSetValues[];
    private String mSummary;

}
