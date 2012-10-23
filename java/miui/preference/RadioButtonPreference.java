// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.preference;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;

public class RadioButtonPreference extends CheckBoxPreference {

    public RadioButtonPreference(Context context) {
        this(context, null);
    }

    public RadioButtonPreference(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        setWidgetLayoutResource(0x6030019);
    }
}
