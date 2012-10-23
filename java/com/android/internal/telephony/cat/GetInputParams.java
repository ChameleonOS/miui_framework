// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandParams, Input, CommandDetails

class GetInputParams extends CommandParams {

    GetInputParams(CommandDetails commanddetails, Input input1) {
        super(commanddetails);
        input = null;
        input = input1;
    }

    boolean setIcon(Bitmap bitmap) {
        if(bitmap != null && input != null)
            input.icon = bitmap;
        return true;
    }

    Input input;
}
