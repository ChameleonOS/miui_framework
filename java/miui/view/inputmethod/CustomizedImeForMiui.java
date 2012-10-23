// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.view.inputmethod;

import android.content.ContentResolver;

public class CustomizedImeForMiui {

    public CustomizedImeForMiui() {
    }

    public static boolean defaultImeIsCustomizedForMiui(ContentResolver contentresolver) {
        boolean flag;
        if("com.sogou.inputmethod.mi/.SogouIME".equals(android.provider.Settings.Secure.getString(contentresolver, "default_input_method")))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final String CUSTOMIZED_SOGOU_IME_FOR_MIUI_ID = "com.sogou.inputmethod.mi/.SogouIME";
}
