// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import miui.widget.SlidingButton;

// Referenced classes of package android.preference:
//            TwoStatePreference, PreferenceManager

public class CheckBoxPreference extends TwoStatePreference {

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101008f);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.CheckBoxPreference, i, 0);
        setSummaryOn(typedarray.getString(0));
        setSummaryOff(typedarray.getString(1));
        setDisableDependentsState(typedarray.getBoolean(2, false));
        typedarray.recycle();
    }

    private void setSlidingButtonListener(View view) {
        if(view != null && (view instanceof SlidingButton)) {
            final SlidingButton slidingButton = (SlidingButton)view;
            slidingButton.setOnCheckedChangedListener(new miui.widget.SlidingButton.OnCheckedChangedListener() {

                public void onCheckedChanged(boolean flag) {
                    performClick(getPreferenceManager().getPreferenceScreen());
                    if(flag != isChecked()) {
                        slidingButton.setOnCheckedChangedListener(null);
                        SlidingButton slidingbutton = slidingButton;
                        boolean flag1;
                        if(!flag)
                            flag1 = true;
                        else
                            flag1 = false;
                        slidingbutton.setChecked(flag1);
                        slidingButton.setOnCheckedChangedListener(this);
                    }
                }

                final CheckBoxPreference this$0;
                final SlidingButton val$slidingButton;

             {
                this$0 = CheckBoxPreference.this;
                slidingButton = slidingbutton;
                super();
            }
            });
        }
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        View view1 = view.findViewById(0x1020001);
        if(view1 != null && (view1 instanceof Checkable)) {
            ((Checkable)view1).setChecked(mChecked);
            sendAccessibilityEvent(view1);
        }
        setSlidingButtonListener(view1);
        syncSummaryView(view);
    }
}
