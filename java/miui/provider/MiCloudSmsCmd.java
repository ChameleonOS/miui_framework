// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class MiCloudSmsCmd {

    public MiCloudSmsCmd() {
    }

    public static boolean checkSmsCmd(Context context, String s, String s1) {
        boolean flag = false;
        if(!TextUtils.isEmpty(s1) && s1.startsWith("mfc,") && s1.indexOf("##") >= 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String as[] = s1.split(",");
        if(as != null && as.length >= 5) {
            String s2 = as[1];
            String s3 = as[2];
            String s4 = as[3];
            String s5 = null;
            String s6;
            if("k".equals(s2)) {
                s5 = as[4];
                s6 = as[5];
            } else {
                s6 = as[4];
            }
            sendCmd(context, s3, s4, s2, s5, s6.substring(0, s6.lastIndexOf("##")));
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static void sendCmd(Context context, String s, String s1, String s2, String s3, String s4) {
        Intent intent;
        String s5;
        intent = new Intent();
        intent.putExtra("android.intent.extra.device_msgId", s);
        intent.putExtra("android.intent.extra.device_time", s1);
        intent.putExtra("android.intent.extra.device_digest", s4);
        intent.putExtra("android.intent.extra.device_cmd", s2);
        intent.putExtra("android.intent.extra.lock_password", s3);
        s5 = null;
        if(!"l".equals(s2)) goto _L2; else goto _L1
_L1:
        s5 = "miui.intent.action.REQUEST_LOCATION";
_L4:
        if(!TextUtils.isEmpty(s5)) {
            intent.setAction(s5);
            context.startService(intent);
        }
        return;
_L2:
        if("n".equals(s2))
            s5 = "miui.intent.action.NOISE";
        else
        if("k".equals(s2))
            s5 = "miui.intent.action.LOCK_DEVICE";
        else
        if("w".equals(s2))
            s5 = "miui.intent.action.WIPE_DATA";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final int CMD_INDEX = 1;
    private static final int MSG_ID_INDEX = 2;
    private static final String SMS_CMD_HEADER = "mfc,";
    private static final String SMS_CMD_TAIL = "##";
    private static final int TIME_INDEX = 3;
    public static final String TYPE_LOCATION = "l";
    public static final String TYPE_LOCK = "k";
    public static final String TYPE_NOISE = "n";
    public static final String TYPE_WIPE = "w";
}
