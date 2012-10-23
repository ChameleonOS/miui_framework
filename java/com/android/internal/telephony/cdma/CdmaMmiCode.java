// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.Context;
import android.os.*;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CDMAPhone

public final class CdmaMmiCode extends Handler
    implements MmiCode {

    CdmaMmiCode(CDMAPhone cdmaphone) {
        super(cdmaphone.getHandler().getLooper());
        state = com.android.internal.telephony.MmiCode.State.PENDING;
        phone = cdmaphone;
        context = cdmaphone.getContext();
    }

    private CharSequence getScString() {
        Object obj;
        if(sc != null && isPukCommand())
            obj = context.getText(0x10400de);
        else
            obj = "";
        return ((CharSequence) (obj));
    }

    private void handlePasswordError(int i) {
        state = com.android.internal.telephony.MmiCode.State.FAILED;
        StringBuilder stringbuilder = new StringBuilder(getScString());
        stringbuilder.append("\n");
        stringbuilder.append(context.getText(i));
        message = stringbuilder;
        phone.onMMIDone(this);
    }

    private static String makeEmptyNull(String s) {
        if(s != null && s.length() == 0)
            s = null;
        return s;
    }

    public static CdmaMmiCode newFromDialString(String s, CDMAPhone cdmaphone) {
        CdmaMmiCode cdmammicode = null;
        Matcher matcher = sPatternSuppService.matcher(s);
        if(matcher.matches()) {
            cdmammicode = new CdmaMmiCode(cdmaphone);
            cdmammicode.poundString = makeEmptyNull(matcher.group(1));
            cdmammicode.action = makeEmptyNull(matcher.group(2));
            cdmammicode.sc = makeEmptyNull(matcher.group(3));
            cdmammicode.sia = makeEmptyNull(matcher.group(5));
            cdmammicode.sib = makeEmptyNull(matcher.group(7));
            cdmammicode.sic = makeEmptyNull(matcher.group(9));
            cdmammicode.pwd = makeEmptyNull(matcher.group(11));
            cdmammicode.dialingNumber = makeEmptyNull(matcher.group(12));
        }
        return cdmammicode;
    }

    private void onSetComplete(AsyncResult asyncresult) {
        StringBuilder stringbuilder = new StringBuilder(getScString());
        stringbuilder.append("\n");
        if(asyncresult.exception != null) {
            state = com.android.internal.telephony.MmiCode.State.FAILED;
            if(asyncresult.exception instanceof CommandException) {
                if(((CommandException)(CommandException)asyncresult.exception).getCommandError() == com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT) {
                    if(isPukCommand())
                        stringbuilder.append(context.getText(0x10400d0));
                    else
                        stringbuilder.append(context.getText(0x10400cd));
                } else {
                    stringbuilder.append(context.getText(0x10400c6));
                }
            } else {
                stringbuilder.append(context.getText(0x10400c6));
            }
        } else
        if(isRegister()) {
            state = com.android.internal.telephony.MmiCode.State.COMPLETE;
            stringbuilder.append(context.getText(0x10400cb));
        } else {
            state = com.android.internal.telephony.MmiCode.State.FAILED;
            stringbuilder.append(context.getText(0x10400c6));
        }
        message = stringbuilder;
        phone.onMMIDone(this);
    }

    public void cancel() {
        if(state != com.android.internal.telephony.MmiCode.State.COMPLETE && state != com.android.internal.telephony.MmiCode.State.FAILED) {
            state = com.android.internal.telephony.MmiCode.State.CANCELLED;
            phone.onMMIDone(this);
        }
    }

    public CharSequence getMessage() {
        return message;
    }

    public com.android.internal.telephony.MmiCode.State getState() {
        return state;
    }

    public void handleMessage(Message message1) {
        if(message1.what == 1)
            onSetComplete((AsyncResult)(AsyncResult)message1.obj);
        else
            Log.e("CDMA_MMI", "Unexpected reply");
    }

    public boolean isCancelable() {
        return false;
    }

    boolean isPukCommand() {
        boolean flag;
        if(sc != null && sc.equals("05"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isRegister() {
        boolean flag;
        if(action != null && action.equals("**"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isUssdRequest() {
        Log.w("CDMA_MMI", "isUssdRequest is not implemented in CdmaMmiCode");
        return false;
    }

    void processCode() {
        if(!isPukCommand()) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        int i;
        s = sia;
        s1 = sib;
        i = s1.length();
        if(!isRegister()) goto _L4; else goto _L3
_L3:
        if(s1.equals(sic)) goto _L6; else goto _L5
_L5:
        handlePasswordError(0x10400d1);
          goto _L7
_L8:
        handlePasswordError(0x10400d2);
          goto _L7
        RuntimeException runtimeexception;
        runtimeexception;
        state = com.android.internal.telephony.MmiCode.State.FAILED;
        message = context.getText(0x10400c6);
        phone.onMMIDone(this);
          goto _L7
_L9:
        ((PhoneBase) (phone)).mCM.supplyIccPuk(s, s1, obtainMessage(1, this));
          goto _L7
_L4:
        throw new RuntimeException("Invalid or Unsupported MMI Code");
_L2:
        throw new RuntimeException("Invalid or Unsupported MMI Code");
_L7:
        return;
_L6:
        if(i >= 4 && i <= 8) goto _L9; else goto _L8
    }

    static final String ACTION_REGISTER = "**";
    static final int EVENT_SET_COMPLETE = 1;
    static final String LOG_TAG = "CDMA_MMI";
    static final int MATCH_GROUP_ACTION = 2;
    static final int MATCH_GROUP_DIALING_NUMBER = 12;
    static final int MATCH_GROUP_POUND_STRING = 1;
    static final int MATCH_GROUP_PWD_CONFIRM = 11;
    static final int MATCH_GROUP_SERVICE_CODE = 3;
    static final int MATCH_GROUP_SIA = 5;
    static final int MATCH_GROUP_SIB = 7;
    static final int MATCH_GROUP_SIC = 9;
    static final String SC_PUK = "05";
    static Pattern sPatternSuppService = Pattern.compile("((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)(.*)");
    String action;
    Context context;
    String dialingNumber;
    CharSequence message;
    CDMAPhone phone;
    String poundString;
    String pwd;
    String sc;
    String sia;
    String sib;
    String sic;
    com.android.internal.telephony.MmiCode.State state;

}
