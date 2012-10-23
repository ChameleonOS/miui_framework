// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandParams, ToneSettings, TextMessage, CommandDetails, 
//            Tone, Duration

class PlayToneParams extends CommandParams {

    PlayToneParams(CommandDetails commanddetails, TextMessage textmessage, Tone tone, Duration duration, boolean flag) {
        super(commanddetails);
        textMsg = textmessage;
        settings = new ToneSettings(duration, tone, flag);
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

    ToneSettings settings;
    TextMessage textMsg;
}
