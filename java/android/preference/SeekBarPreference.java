// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;

// Referenced classes of package android.preference:
//            Preference

public class SeekBarPreference extends Preference
    implements android.widget.SeekBar.OnSeekBarChangeListener {
    private static class SavedState extends Preference.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(progress);
            parcel.writeInt(max);
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
        int max;
        int progress;


        public SavedState(Parcel parcel) {
            super(parcel);
            progress = parcel.readInt();
            max = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }


    public SeekBarPreference(Context context) {
        this(context, null);
    }

    public SeekBarPreference(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ProgressBar, i, 0);
        setMax(typedarray.getInt(2, mMax));
        typedarray.recycle();
        setLayoutResource(0x109008b);
    }

    private void setProgress(int i, boolean flag) {
        if(i > mMax)
            i = mMax;
        if(i < 0)
            i = 0;
        if(i != mProgress) {
            mProgress = i;
            persistInt(i);
            if(flag)
                notifyChanged();
        }
    }

    public int getProgress() {
        return mProgress;
    }

    public CharSequence getSummary() {
        return null;
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        SeekBar seekbar = (SeekBar)view.findViewById(0x1020307);
        seekbar.setOnSeekBarChangeListener(this);
        seekbar.setMax(mMax);
        seekbar.setProgress(mProgress);
        seekbar.setEnabled(isEnabled());
    }

    protected Object onGetDefaultValue(TypedArray typedarray, int i) {
        return Integer.valueOf(typedarray.getInt(i, 0));
    }

    public boolean onKey(View view, int i, KeyEvent keyevent) {
        boolean flag = true;
        if(keyevent.getAction() == flag) goto _L2; else goto _L1
_L1:
        if(i != 81 && i != 70) goto _L4; else goto _L3
_L3:
        setProgress(1 + getProgress());
_L6:
        return flag;
_L4:
        if(i == 69) {
            setProgress(-1 + getProgress());
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag) {
        if(flag && !mTrackingTouch)
            syncProgress(seekbar);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if(!parcelable.getClass().equals(android/preference/SeekBarPreference$SavedState)) {
            super.onRestoreInstanceState(parcelable);
        } else {
            SavedState savedstate = (SavedState)parcelable;
            super.onRestoreInstanceState(savedstate.getSuperState());
            mProgress = savedstate.progress;
            mMax = savedstate.max;
            notifyChanged();
        }
    }

    protected Parcelable onSaveInstanceState() {
        Object obj = super.onSaveInstanceState();
        if(!isPersistent()) {
            SavedState savedstate = new SavedState(((Parcelable) (obj)));
            savedstate.progress = mProgress;
            savedstate.max = mMax;
            obj = savedstate;
        }
        return ((Parcelable) (obj));
    }

    protected void onSetInitialValue(boolean flag, Object obj) {
        int i;
        if(flag)
            i = getPersistedInt(mProgress);
        else
            i = ((Integer)obj).intValue();
        setProgress(i);
    }

    public void onStartTrackingTouch(SeekBar seekbar) {
        mTrackingTouch = true;
    }

    public void onStopTrackingTouch(SeekBar seekbar) {
        mTrackingTouch = false;
        if(seekbar.getProgress() != mProgress)
            syncProgress(seekbar);
    }

    public void setMax(int i) {
        if(i != mMax) {
            mMax = i;
            notifyChanged();
        }
    }

    public void setProgress(int i) {
        setProgress(i, true);
    }

    void syncProgress(SeekBar seekbar) {
        int i = seekbar.getProgress();
        if(i != mProgress)
            if(callChangeListener(Integer.valueOf(i)))
                setProgress(i, false);
            else
                seekbar.setProgress(mProgress);
    }

    private int mMax;
    private int mProgress;
    private boolean mTrackingTouch;
}
