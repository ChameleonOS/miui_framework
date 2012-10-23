// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.*;

public final class RuimFileHandler extends IccFileHandler {

    public RuimFileHandler(IccCard icccard, String s, CommandsInterface commandsinterface) {
        super(icccard, s, commandsinterface);
    }

    protected void finalize() {
        Log.d("CDMA", "RuimFileHandler finalized");
    }

    protected String getEFPath(int i) {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   28466: 44
    //                   28476: 44
    //                   28481: 44;
           goto _L1 _L2 _L2 _L2
_L1:
        String s = getCommonIccEFPath(i);
_L4:
        return s;
_L2:
        s = "3F007F25";
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
    }

    public void loadEFImgTransparent(int i, int j, int k, int l, Message message) {
        Message message1 = obtainMessage(10, i, 0, message);
        super.mCi.iccIOForApp(192, i, "img", 0, 0, 10, null, null, super.mAid, message1);
    }

    protected void logd(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[RuimFileHandler] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("CDMA", (new StringBuilder()).append("[RuimFileHandler] ").append(s).toString());
    }

    static final String LOG_TAG = "CDMA";
}
