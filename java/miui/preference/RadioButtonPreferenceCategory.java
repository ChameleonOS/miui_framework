// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.preference;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;

// Referenced classes of package miui.preference:
//            RadioButtonPreference

public class RadioButtonPreferenceCategory extends PreferenceCategory
    implements android.preference.Preference.OnPreferenceChangeListener {

    public RadioButtonPreferenceCategory(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mRadioButtonPreference = null;
        mCheckedPosition = -1;
    }

    public boolean addPreference(Preference preference) {
        if(!(preference instanceof RadioButtonPreference))
            throw new IllegalArgumentException("Only CheckBoxPreference can be added toRadioButtonPreferenceCategory");
        boolean flag = super.addPreference(preference);
        if(flag)
            preference.setOnPreferenceChangeListener(this);
        return flag;
    }

    public int getCheckedPosition() {
        return mCheckedPosition;
    }

    public Preference getCheckedPreference() {
        return mRadioButtonPreference;
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if(preference != mRadioButtonPreference)
            setCheckedPreference(preference);
        android.preference.Preference.OnPreferenceClickListener onpreferenceclicklistener = getOnPreferenceClickListener();
        if(onpreferenceclicklistener != null)
            onpreferenceclicklistener.onPreferenceClick(this);
        return false;
    }

    public void setCheckedPosition(int i) {
        setCheckedPreference(getPreference(i));
    }

    public void setCheckedPreference(Preference preference) {
        int i = getPreferenceCount();
        int j = 0;
        while(j < i)  {
            RadioButtonPreference radiobuttonpreference = (RadioButtonPreference)getPreference(j);
            if(radiobuttonpreference == preference) {
                mRadioButtonPreference = radiobuttonpreference;
                mCheckedPosition = j;
                radiobuttonpreference.setChecked(true);
            } else {
                radiobuttonpreference.setChecked(false);
            }
            j++;
        }
    }

    private static final String TAG = "RadioButtonPreferenceCategory";
    private int mCheckedPosition;
    private RadioButtonPreference mRadioButtonPreference;
}
