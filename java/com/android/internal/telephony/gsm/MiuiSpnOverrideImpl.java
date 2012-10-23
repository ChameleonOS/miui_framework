// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.app.ActivityThread;
import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;

// Referenced classes of package com.android.internal.telephony.gsm:
//            SpnOverride

class MiuiSpnOverrideImpl extends SpnOverride {

    public MiuiSpnOverrideImpl() {
    }

    private String getFromSettings(String s) {
        return android.provider.Settings.System.getString(ActivityThread.currentApplication().getContentResolver(), (new StringBuilder()).append("MOBILE_OPERATOR_NAME_").append(s).toString());
    }

    private int getIndex(String s) {
        int i = 0;
_L3:
        if(i >= mNumericValues.length)
            break MISSING_BLOCK_LABEL_32;
        if(!mNumericValues[i].equals(s)) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

    boolean containsCarrier(String s) {
        boolean flag;
        if(getIndex(s) >= 0 || super.containsCarrier(s) || !TextUtils.isEmpty(getFromSettings(s)))
            flag = true;
        else
            flag = false;
        return flag;
    }

    String getEquivalentOperatorNumeric(String s) {
        int i = getIndex(s);
        if(i >= 0)
            s = mNumericEquivalencies[i];
        return s;
    }

    String getSpn(String s) {
        String s1 = getFromSettings(s);
        if(TextUtils.isEmpty(s1)) {
            int i = getIndex(s);
            if(i >= 0)
                s1 = Resources.getSystem().getStringArray(0x6060001)[i];
            else
                s1 = super.getSpn(s);
        }
        return s1;
    }

    private static final String SETTING_PREFIX = "MOBILE_OPERATOR_NAME_";
    private final String mNumericEquivalencies[] = Resources.getSystem().getStringArray(0x6060007);
    private final String mNumericValues[] = Resources.getSystem().getStringArray(0x6060000);
}
