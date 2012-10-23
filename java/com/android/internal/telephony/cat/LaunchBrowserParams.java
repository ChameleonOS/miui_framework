// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandParams, TextMessage, LaunchBrowserMode, CommandDetails

class LaunchBrowserParams extends CommandParams {

    LaunchBrowserParams(CommandDetails commanddetails, TextMessage textmessage, String s, LaunchBrowserMode launchbrowsermode) {
        super(commanddetails);
        confirmMsg = textmessage;
        mode = launchbrowsermode;
        url = s;
    }

    boolean setIcon(Bitmap bitmap) {
        boolean flag;
        if(bitmap != null && confirmMsg != null) {
            confirmMsg.icon = bitmap;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    TextMessage confirmMsg;
    LaunchBrowserMode mode;
    String url;
}
