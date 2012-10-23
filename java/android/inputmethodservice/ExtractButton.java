// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

class ExtractButton extends Button {

    public ExtractButton(Context context) {
        super(context, null);
    }

    public ExtractButton(Context context, AttributeSet attributeset) {
        super(context, attributeset, 0x1010048);
    }

    public ExtractButton(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    public boolean hasWindowFocus() {
        boolean flag;
        if(isEnabled() && getVisibility() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }
}
