// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.*;

public class CheckableLinearLayout extends LinearLayout
    implements Checkable {

    public CheckableLinearLayout(Context context) {
        super(context);
    }

    public CheckableLinearLayout(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public CheckableLinearLayout(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    public boolean isChecked() {
        return mCheckBox.isChecked();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        mCheckBox = (CheckBox)findViewById(0x10202df);
    }

    public void setChecked(boolean flag) {
        mCheckBox.setChecked(flag);
    }

    public void toggle() {
        mCheckBox.toggle();
    }

    private CheckBox mCheckBox;
}
