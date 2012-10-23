// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.security;

import android.content.Context;
import android.content.Intent;

public class IntentScope {

    public IntentScope() {
    }

    public static Intent processInentScope(Context context, Intent intent, String s) {
        if(intent != null)
            intent.setPackage(s);
        return intent;
    }

    public static final String PACKAGE_NAME_PHONE = "com.android.phone";
}
