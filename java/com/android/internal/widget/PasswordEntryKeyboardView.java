// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

public class PasswordEntryKeyboardView extends KeyboardView {

    public PasswordEntryKeyboardView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public PasswordEntryKeyboardView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    public boolean setShifted(boolean flag) {
        boolean flag1 = super.setShifted(flag);
        int ai[] = getKeyboard().getShiftKeyIndices();
        int i = ai.length;
        for(int j = 0; j < i; j++)
            invalidateKey(ai[j]);

        return flag1;
    }

    static final int KEYCODE_F1 = -103;
    static final int KEYCODE_NEXT_LANGUAGE = -104;
    static final int KEYCODE_OPTIONS = -100;
    static final int KEYCODE_SHIFT_LONGPRESS = -101;
    static final int KEYCODE_VOICE = -102;
}
