// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandDetails

class CommandParams {

    CommandParams(CommandDetails commanddetails) {
        cmdDet = commanddetails;
    }

    AppInterface.CommandType getCommandType() {
        return AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
    }

    boolean setIcon(Bitmap bitmap) {
        return true;
    }

    public String toString() {
        return cmdDet.toString();
    }

    CommandDetails cmdDet;
}
