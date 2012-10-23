// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.*;

public final class CdmaLteUiccFileHandler extends IccFileHandler {

    public CdmaLteUiccFileHandler(IccCard icccard, String s, CommandsInterface commandsinterface) {
        super(icccard, s, commandsinterface);
    }

    protected String getEFPath(int i) {
        i;
        JVM INSTR lookupswitch 10: default 92
    //                   28418: 112
    //                   28419: 112
    //                   28420: 112
    //                   28450: 100
    //                   28456: 100
    //                   28474: 100
    //                   28481: 100
    //                   28484: 100
    //                   28506: 100
    //                   28589: 106;
           goto _L1 _L2 _L2 _L2 _L3 _L3 _L3 _L3 _L3 _L3 _L4
_L1:
        String s = getCommonIccEFPath(i);
_L6:
        return s;
_L3:
        s = "3F007F25";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "3F007F20";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "3F007FFF";
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void loadEFTransparent(int i, Message message) {
        if(i == 28506)
            super.mCi.iccIOForApp(176, i, getEFPath(i), 0, 0, 4, null, null, super.mAid, obtainMessage(5, i, 0, message));
        else
            super.loadEFTransparent(i, message);
    }

    protected void logd(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CdmaLteUiccFileHandler] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("CDMA", (new StringBuilder()).append("[CdmaLteUiccFileHandler] ").append(s).toString());
    }

    static final String LOG_TAG = "CDMA";
}
