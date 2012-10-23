// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandParams, TextMessage, CommandDetails

class CallSetupParams extends CommandParams {

    CallSetupParams(CommandDetails commanddetails, TextMessage textmessage, TextMessage textmessage1) {
        super(commanddetails);
        confirmMsg = textmessage;
        callMsg = textmessage1;
    }

    boolean setIcon(Bitmap bitmap) {
        boolean flag = false;
        if(bitmap != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(confirmMsg != null && confirmMsg.icon == null) {
            confirmMsg.icon = bitmap;
            flag = true;
        } else
        if(callMsg != null && callMsg.icon == null) {
            callMsg.icon = bitmap;
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    TextMessage callMsg;
    TextMessage confirmMsg;
}
