// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.*;

public final class SIMFileHandler extends IccFileHandler
    implements IccConstants {

    public SIMFileHandler(IccCard icccard, String s, CommandsInterface commandsinterface) {
        super(icccard, s, commandsinterface);
    }

    protected void finalize() {
        Log.d("GSM", "SIMFileHandler finalized");
    }

    protected String getEFPath(int i) {
        i;
        JVM INSTR lookupswitch 19: default 164
    //                   20272: 217
    //                   28433: 211
    //                   28435: 211
    //                   28436: 211
    //                   28437: 211
    //                   28438: 211
    //                   28439: 211
    //                   28440: 211
    //                   28472: 205
    //                   28476: 199
    //                   28486: 205
    //                   28589: 205
    //                   28613: 205
    //                   28615: 205
    //                   28616: 205
    //                   28617: 205
    //                   28618: 205
    //                   28619: 205
    //                   28621: 205;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L4 _L5 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L1:
        String s = getCommonIccEFPath(i);
        if(s != null)
            break; /* Loop/switch isn't completed */
        if(super.mParentCard != null && super.mParentCard.isApplicationOnIcc(com.android.internal.telephony.IccCardApplication.AppType.APPTYPE_USIM))
            s = "3F007F105F3A";
        else
            Log.e("GSM", "Error: EF Path being returned in null");
_L7:
        return s;
_L5:
        s = "3F007F10";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "3F007F20";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "3F007F20";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "3F007F105F3A";
        if(true) goto _L7; else goto _L6
_L6:
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
    }

    protected void logd(String s) {
        Log.d("GSM", (new StringBuilder()).append("[SIMFileHandler] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("GSM", (new StringBuilder()).append("[SIMFileHandler] ").append(s).toString());
    }

    static final String LOG_TAG = "GSM";
}
