// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandParams, TextMessage, CommandDetails

class DisplayTextParams extends CommandParams {

    DisplayTextParams(CommandDetails commanddetails, TextMessage textmessage) {
        super(commanddetails);
        textMsg = textmessage;
    }

    boolean setIcon(Bitmap bitmap) {
        boolean flag;
        if(bitmap != null && textMsg != null) {
            textMsg.icon = bitmap;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    TextMessage textMsg;
}
