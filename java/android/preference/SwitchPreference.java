// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;

// Referenced classes of package android.preference:
//            TwoStatePreference

public class SwitchPreference extends TwoStatePreference {
    private class Listener
        implements android.widget.CompoundButton.OnCheckedChangeListener {

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag) {
            if(!callChangeListener(Boolean.valueOf(flag))) {
                boolean flag1;
                if(!flag)
                    flag1 = true;
                else
                    flag1 = false;
                compoundbutton.setChecked(flag1);
            } else {
                setChecked(flag);
            }
        }

        final SwitchPreference this$0;

        private Listener() {
            this$0 = SwitchPreference.this;
            super();
        }

    }


    public SwitchPreference(Context context) {
        this(context, null);
    }

    public SwitchPreference(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101036d);
    }

    public SwitchPreference(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mListener = new Listener();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.SwitchPreference, i, 0);
        setSummaryOn(typedarray.getString(0));
        setSummaryOff(typedarray.getString(1));
        setSwitchTextOn(typedarray.getString(3));
        setSwitchTextOff(typedarray.getString(4));
        setDisableDependentsState(typedarray.getBoolean(2, false));
        typedarray.recycle();
    }

    public CharSequence getSwitchTextOff() {
        return mSwitchOff;
    }

    public CharSequence getSwitchTextOn() {
        return mSwitchOn;
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        View view1 = view.findViewById(0x102030d);
        if(view1 != null && (view1 instanceof Checkable)) {
            ((Checkable)view1).setChecked(super.mChecked);
            sendAccessibilityEvent(view1);
            if(view1 instanceof Switch) {
                Switch switch1 = (Switch)view1;
                switch1.setTextOn(mSwitchOn);
                switch1.setTextOff(mSwitchOff);
                switch1.setOnCheckedChangeListener(mListener);
            }
        }
        syncSummaryView(view);
    }

    public void setSwitchTextOff(int i) {
        setSwitchTextOff(((CharSequence) (getContext().getString(i))));
    }

    public void setSwitchTextOff(CharSequence charsequence) {
        mSwitchOff = charsequence;
        notifyChanged();
    }

    public void setSwitchTextOn(int i) {
        setSwitchTextOn(((CharSequence) (getContext().getString(i))));
    }

    public void setSwitchTextOn(CharSequence charsequence) {
        mSwitchOn = charsequence;
        notifyChanged();
    }

    private final Listener mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;
}
