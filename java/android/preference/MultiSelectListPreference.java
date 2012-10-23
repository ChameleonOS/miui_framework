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
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package android.preference:
//            DialogPreference

public class MultiSelectListPreference extends DialogPreference {
    private static class SavedState extends Preference.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeStringArray((String[])values.toArray(new String[0]));
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
        Set values;


        public SavedState(Parcel parcel) {
            super(parcel);
            values = new HashSet();
            String as[] = parcel.readStringArray();
            int i = as.length;
            for(int j = 0; j < i; j++)
                values.add(as[j]);

        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }


    public MultiSelectListPreference(Context context) {
        this(context, null);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mValues = new HashSet();
        mNewValues = new HashSet();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MultiSelectListPreference, 0, 0);
        mEntries = typedarray.getTextArray(0);
        mEntryValues = typedarray.getTextArray(1);
        typedarray.recycle();
    }

    private boolean[] getSelectedItems() {
        CharSequence acharsequence[] = mEntryValues;
        int i = acharsequence.length;
        Set set = mValues;
        boolean aflag[] = new boolean[i];
        for(int j = 0; j < i; j++)
            aflag[j] = set.contains(acharsequence[j].toString());

        return aflag;
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

    public CharSequence[] getEntryValues() {
        return mEntryValues;
    }

    public Set getValues() {
        return mValues;
    }

    protected void onDialogClosed(boolean flag) {
        super.onDialogClosed(flag);
        if(flag && mPreferenceChanged) {
            Set set = mNewValues;
            if(callChangeListener(set))
                setValues(set);
        }
        mPreferenceChanged = false;
    }

    protected Object onGetDefaultValue(TypedArray typedarray, int i) {
        CharSequence acharsequence[] = typedarray.getTextArray(i);
        int j = acharsequence.length;
        HashSet hashset = new HashSet();
        for(int k = 0; k < j; k++)
            hashset.add(acharsequence[k].toString());

        return hashset;
    }

    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        if(mEntries == null || mEntryValues == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        } else {
            boolean aflag[] = getSelectedItems();
            builder.setMultiChoiceItems(mEntries, aflag, new android.content.DialogInterface.OnMultiChoiceClickListener() );
            mNewValues.clear();
            mNewValues.addAll(mValues);
            return;
        }
    }

    protected Parcelable onSaveInstanceState() {
        Object obj = onSaveInstanceState();
        if(!isPersistent()) {
            SavedState savedstate = new SavedState(((Parcelable) (obj)));
            savedstate.values = getValues();
            obj = savedstate;
        }
        return ((Parcelable) (obj));
    }

    protected void onSetInitialValue(boolean flag, Object obj) {
        Set set;
        if(flag)
            set = getPersistedStringSet(mValues);
        else
            set = (Set)obj;
        setValues(set);
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

    public void setValues(Set set) {
        mValues.clear();
        mValues.addAll(set);
        persistStringSet(set);
    }

    private CharSequence mEntries[];
    private CharSequence mEntryValues[];
    private Set mNewValues;
    private boolean mPreferenceChanged;
    private Set mValues;


/*
    static boolean access$076(MultiSelectListPreference multiselectlistpreference, int i) {
        boolean flag = (byte)(i | multiselectlistpreference.mPreferenceChanged);
        multiselectlistpreference.mPreferenceChanged = flag;
        return flag;
    }

*/


}
