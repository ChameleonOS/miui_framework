// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony;

import android.content.Context;
import android.os.SystemProperties;

// Referenced classes of package miui.telephony:
//            PhoneNumberUtils

public class ExtraTelephonyManager {

    public ExtraTelephonyManager() {
    }

    public static String getSimOperator(Context context) {
        String s;
        s = SystemProperties.get("gsm.sim.operator.numeric");
        break MISSING_BLOCK_LABEL_6;
        while(true)  {
            do
                return s;
            while(context == null || !"com.android.vending".equals(context.getPackageName()) || !PhoneNumberUtils.isChineseOperator(s));
            String s1 = android.provider.Settings.System.getString(context.getContentResolver(), "fake_mobile_operator_for_vending");
            if(s1 != null) {
                if(s1.length() != 0)
                    s = s1;
            } else {
                s = "310410";
            }
        }
    }

    public static final String ACTION_ENTER_INCALL_SCREEN_DURING_CALL = "android.intent.action.ENTER_INCALL_SCREEN_DURING_CALL";
    public static final String ACTION_LEAVE_INCALL_SCREEN_DURING_CALL = "android.intent.action.LEAVE_INCALL_SCREEN_DURING_CALL";
    public static final String EXTRA_BASE_TIME = "base_time";
    public static final String EXTRA_CALL_STATE = "call_state";
    public static final String EXTRA_CALL_STATE_ACTIVE;
    public static final String EXTRA_CALL_STATE_DIALING;
    public static final String EXTRA_CALL_STATE_HOLDING;

    static  {
        EXTRA_CALL_STATE_DIALING = com.android.internal.telephony.Call.State.DIALING.toString();
        EXTRA_CALL_STATE_ACTIVE = com.android.internal.telephony.Call.State.ACTIVE.toString();
        EXTRA_CALL_STATE_HOLDING = com.android.internal.telephony.Call.State.HOLDING.toString();
    }
}
