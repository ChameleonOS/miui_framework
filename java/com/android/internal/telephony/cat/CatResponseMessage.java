// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


// Referenced classes of package com.android.internal.telephony.cat:
//            ResultCode, CatCmdMessage, CommandDetails

public class CatResponseMessage {

    public CatResponseMessage(CatCmdMessage catcmdmessage) {
        cmdDet = null;
        resCode = ResultCode.OK;
        usersMenuSelection = 0;
        usersInput = null;
        usersYesNoSelection = false;
        usersConfirm = false;
        cmdDet = catcmdmessage.mCmdDet;
    }

    CommandDetails getCmdDetails() {
        return cmdDet;
    }

    public void setConfirmation(boolean flag) {
        usersConfirm = flag;
    }

    public void setInput(String s) {
        usersInput = s;
    }

    public void setMenuSelection(int i) {
        usersMenuSelection = i;
    }

    public void setResultCode(ResultCode resultcode) {
        resCode = resultcode;
    }

    public void setYesNo(boolean flag) {
        usersYesNoSelection = flag;
    }

    CommandDetails cmdDet;
    ResultCode resCode;
    boolean usersConfirm;
    String usersInput;
    int usersMenuSelection;
    boolean usersYesNoSelection;
}
