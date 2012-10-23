// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.content.Context;
import android.content.res.Resources;
import android.os.*;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GSMPhone

public final class GsmMmiCode extends Handler
    implements MmiCode {

    GsmMmiCode(GSMPhone gsmphone) {
        super(gsmphone.getHandler().getLooper());
        state = com.android.internal.telephony.MmiCode.State.PENDING;
        phone = gsmphone;
        context = gsmphone.getContext();
    }

    private CharSequence createQueryCallBarringResultMessage(int i) {
        StringBuilder stringbuilder = new StringBuilder(context.getText(0x10400c9));
        for(int j = 1; j <= 128; j <<= 1)
            if((j & i) != 0) {
                stringbuilder.append("\n");
                stringbuilder.append(serviceClassToCFString(j & i));
            }

        return stringbuilder;
    }

    private CharSequence createQueryCallWaitingResultMessage(int i) {
        StringBuilder stringbuilder = new StringBuilder(context.getText(0x10400c9));
        for(int j = 1; j <= 128; j <<= 1)
            if((j & i) != 0) {
                stringbuilder.append("\n");
                stringbuilder.append(serviceClassToCFString(j & i));
            }

        return stringbuilder;
    }

    private CharSequence getErrorMessage(AsyncResult asyncresult) {
        CharSequence charsequence;
        if((asyncresult.exception instanceof CommandException) && ((CommandException)(CommandException)asyncresult.exception).getCommandError() == com.android.internal.telephony.CommandException.Error.FDN_CHECK_FAILURE) {
            Log.i("GSM", "FDN_CHECK_FAILURE");
            charsequence = context.getText(0x10400c7);
        } else {
            charsequence = context.getText(0x10400c6);
        }
        return charsequence;
    }

    private CharSequence getScString() {
        if(sc == null) goto _L2; else goto _L1
_L1:
        if(!isServiceCodeCallBarring(sc)) goto _L4; else goto _L3
_L3:
        Object obj = context.getText(0x10400dc);
_L6:
        return ((CharSequence) (obj));
_L4:
        if(isServiceCodeCallForwarding(sc)) {
            obj = context.getText(0x10400da);
            continue; /* Loop/switch isn't completed */
        }
        if(sc.equals("30")) {
            obj = context.getText(0x10400d8);
            continue; /* Loop/switch isn't completed */
        }
        if(sc.equals("31")) {
            obj = context.getText(0x10400d9);
            continue; /* Loop/switch isn't completed */
        }
        if(sc.equals("03")) {
            obj = context.getText(0x10400dd);
            continue; /* Loop/switch isn't completed */
        }
        if(sc.equals("43")) {
            obj = context.getText(0x10400db);
            continue; /* Loop/switch isn't completed */
        }
        if(isPinCommand()) {
            obj = context.getText(0x10400de);
            continue; /* Loop/switch isn't completed */
        }
_L2:
        obj = "";
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void handlePasswordError(int i) {
        state = com.android.internal.telephony.MmiCode.State.FAILED;
        StringBuilder stringbuilder = new StringBuilder(getScString());
        stringbuilder.append("\n");
        stringbuilder.append(context.getText(i));
        message = stringbuilder;
        phone.onMMIDone(this);
    }

    private static boolean isEmptyOrNull(CharSequence charsequence) {
        boolean flag;
        if(charsequence == null || charsequence.length() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    static boolean isServiceCodeCallBarring(String s) {
        boolean flag;
        if(s != null && (s.equals("33") || s.equals("331") || s.equals("332") || s.equals("35") || s.equals("351") || s.equals("330") || s.equals("333") || s.equals("353")))
            flag = true;
        else
            flag = false;
        return flag;
    }

    static boolean isServiceCodeCallForwarding(String s) {
        boolean flag;
        if(s != null && (s.equals("21") || s.equals("67") || s.equals("61") || s.equals("62") || s.equals("002") || s.equals("004")))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isShortCode(String s, GSMPhone gsmphone) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(s != null && s.length() != 0 && !PhoneNumberUtils.isLocalEmergencyNumber(s, gsmphone.getContext()))
            flag = isShortCodeUSSD(s, gsmphone);
        return flag;
    }

    private static boolean isShortCodeUSSD(String s, GSMPhone gsmphone) {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        if(s == null || (!gsmphone.isInCall() || s.length() > 2) && (s.length() > 2 || s.charAt(-1 + s.length()) != '#'))
            flag = false;
        return flag;
    }

    private static boolean isTwoDigitShortCode(Context context1, String s) {
        boolean flag;
        flag = false;
        Log.d("GSM", "isTwoDigitShortCode");
        if(s != null && s.length() == 2) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(sTwoDigitNumberPattern == null)
            sTwoDigitNumberPattern = context1.getResources().getStringArray(0x107002b);
        String as[] = sTwoDigitNumberPattern;
        int i = as.length;
        int j = 0;
        do {
            if(j >= i)
                break;
            String s1 = as[j];
            Log.d("GSM", (new StringBuilder()).append("Two Digit Number Pattern ").append(s1).toString());
            if(s.equals(s1)) {
                Log.d("GSM", "Two Digit Number Pattern -true");
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while(true);
        Log.d("GSM", "Two Digit Number Pattern -false");
        if(true) goto _L1; else goto _L3
_L3:
    }

    private CharSequence makeCFQueryResultMessage(CallForwardInfo callforwardinfo, int i) {
        String as[] = new String[3];
        as[0] = "{0}";
        as[1] = "{1}";
        as[2] = "{2}";
        CharSequence acharsequence[] = new CharSequence[3];
        boolean flag;
        CharSequence charsequence;
        if(callforwardinfo.reason == 2)
            flag = true;
        else
            flag = false;
        if(callforwardinfo.status == 1) {
            if(flag)
                charsequence = context.getText(0x104010c);
            else
                charsequence = context.getText(0x104010b);
        } else
        if(callforwardinfo.status == 0 && isEmptyOrNull(callforwardinfo.number))
            charsequence = context.getText(0x104010a);
        else
        if(flag)
            charsequence = context.getText(0x104010e);
        else
            charsequence = context.getText(0x104010d);
        acharsequence[0] = serviceClassToCFString(i & callforwardinfo.serviceClass);
        acharsequence[1] = PhoneNumberUtils.stringFromStringAndTOA(callforwardinfo.number, callforwardinfo.toa);
        acharsequence[2] = Integer.toString(callforwardinfo.timeSeconds);
        if(callforwardinfo.reason == 0 && (i & callforwardinfo.serviceClass) == 1) {
            boolean flag1;
            if(callforwardinfo.status == 1)
                flag1 = true;
            else
                flag1 = false;
            ((PhoneBase) (phone)).mIccRecords.setVoiceCallForwardingFlag(1, flag1);
        }
        return TextUtils.replace(charsequence, as, acharsequence);
    }

    private static String makeEmptyNull(String s) {
        if(s != null && s.length() == 0)
            s = null;
        return s;
    }

    static GsmMmiCode newFromDialString(String s, GSMPhone gsmphone) {
        GsmMmiCode gsmmmicode;
        Matcher matcher;
        gsmmmicode = null;
        matcher = sPatternSuppService.matcher(s);
        if(!matcher.matches()) goto _L2; else goto _L1
_L1:
        gsmmmicode = new GsmMmiCode(gsmphone);
        gsmmmicode.poundString = makeEmptyNull(matcher.group(1));
        gsmmmicode.action = makeEmptyNull(matcher.group(2));
        gsmmmicode.sc = makeEmptyNull(matcher.group(3));
        gsmmmicode.sia = makeEmptyNull(matcher.group(5));
        gsmmmicode.sib = makeEmptyNull(matcher.group(7));
        gsmmmicode.sic = makeEmptyNull(matcher.group(9));
        gsmmmicode.pwd = makeEmptyNull(matcher.group(11));
        gsmmmicode.dialingNumber = makeEmptyNull(matcher.group(12));
_L4:
        return gsmmmicode;
_L2:
        if(s.endsWith("#")) {
            gsmmmicode = new GsmMmiCode(gsmphone);
            gsmmmicode.poundString = s;
        } else
        if(isTwoDigitShortCode(gsmphone.getContext(), s))
            gsmmmicode = null;
        else
        if(isShortCode(s, gsmphone)) {
            gsmmmicode = new GsmMmiCode(gsmphone);
            gsmmmicode.dialingNumber = s;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    static GsmMmiCode newFromUssdUserInput(String s, GSMPhone gsmphone) {
        GsmMmiCode gsmmmicode = new GsmMmiCode(gsmphone);
        gsmmmicode.message = s;
        gsmmmicode.state = com.android.internal.telephony.MmiCode.State.PENDING;
        gsmmmicode.isPendingUSSD = true;
        return gsmmmicode;
    }

    static GsmMmiCode newNetworkInitiatedUssd(String s, boolean flag, GSMPhone gsmphone) {
        GsmMmiCode gsmmmicode = new GsmMmiCode(gsmphone);
        gsmmmicode.message = s;
        gsmmmicode.isUssdRequest = flag;
        if(flag) {
            gsmmmicode.isPendingUSSD = true;
            gsmmmicode.state = com.android.internal.telephony.MmiCode.State.PENDING;
        } else {
            gsmmmicode.state = com.android.internal.telephony.MmiCode.State.COMPLETE;
        }
        return gsmmmicode;
    }

    private void onGetClirComplete(AsyncResult asyncresult) {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder(getScString());
        stringbuilder.append("\n");
        if(asyncresult.exception == null) goto _L2; else goto _L1
_L1:
        state = com.android.internal.telephony.MmiCode.State.FAILED;
        stringbuilder.append(getErrorMessage(asyncresult));
_L17:
        message = stringbuilder;
        phone.onMMIDone(this);
        return;
_L2:
        int ai[] = (int[])(int[])asyncresult.result;
        ai[1];
        JVM INSTR tableswitch 0 4: default 108
    //                   0 111
    //                   1 136
    //                   2 161
    //                   3 185
    //                   4 273;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append(context.getText(0x10400e9));
        state = com.android.internal.telephony.MmiCode.State.COMPLETE;
        continue; /* Loop/switch isn't completed */
_L5:
        stringbuilder.append(context.getText(0x10400ea));
        state = com.android.internal.telephony.MmiCode.State.COMPLETE;
        continue; /* Loop/switch isn't completed */
_L6:
        stringbuilder.append(context.getText(0x10400c6));
        state = com.android.internal.telephony.MmiCode.State.FAILED;
        continue; /* Loop/switch isn't completed */
_L7:
        ai[0];
        JVM INSTR tableswitch 1 2: default 212
    //                   1 237
    //                   2 255;
           goto _L9 _L10 _L11
_L9:
        stringbuilder.append(context.getText(0x10400e5));
_L12:
        state = com.android.internal.telephony.MmiCode.State.COMPLETE;
        continue; /* Loop/switch isn't completed */
_L10:
        stringbuilder.append(context.getText(0x10400e5));
          goto _L12
_L11:
        stringbuilder.append(context.getText(0x10400e6));
          goto _L12
_L8:
        ai[0];
        JVM INSTR tableswitch 1 2: default 300
    //                   1 325
    //                   2 343;
           goto _L13 _L14 _L15
_L14:
        break; /* Loop/switch isn't completed */
_L13:
        stringbuilder.append(context.getText(0x10400e8));
_L18:
        state = com.android.internal.telephony.MmiCode.State.COMPLETE;
        if(true) goto _L17; else goto _L16
_L16:
        stringbuilder.append(context.getText(0x10400e7));
          goto _L18
_L15:
        stringbuilder.append(context.getText(0x10400e8));
          goto _L18
    }

    private void onQueryCfComplete(AsyncResult asyncresult) {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder(getScString());
        stringbuilder.append("\n");
        if(asyncresult.exception == null) goto _L2; else goto _L1
_L1:
        state = com.android.internal.telephony.MmiCode.State.FAILED;
        stringbuilder.append(getErrorMessage(asyncresult));
_L4:
        message = stringbuilder;
        phone.onMMIDone(this);
        return;
_L2:
        CallForwardInfo acallforwardinfo[];
        acallforwardinfo = (CallForwardInfo[])(CallForwardInfo[])asyncresult.result;
        if(acallforwardinfo.length != 0)
            break; /* Loop/switch isn't completed */
        stringbuilder.append(context.getText(0x10400ca));
        ((PhoneBase) (phone)).mIccRecords.setVoiceCallForwardingFlag(1, false);
_L5:
        state = com.android.internal.telephony.MmiCode.State.COMPLETE;
        if(true) goto _L4; else goto _L3
_L3:
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        for(int i = 1; i <= 128; i <<= 1) {
            int j = 0;
            for(int k = acallforwardinfo.length; j < k; j++)
                if((i & acallforwardinfo[j].serviceClass) != 0) {
                    spannablestringbuilder.append(makeCFQueryResultMessage(acallforwardinfo[j], i));
                    spannablestringbuilder.append("\n");
                }

        }

        stringbuilder.append(spannablestringbuilder);
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    private void onQueryComplete(AsyncResult asyncresult) {
        StringBuilder stringbuilder = new StringBuilder(getScString());
        stringbuilder.append("\n");
        if(asyncresult.exception != null) {
            state = com.android.internal.telephony.MmiCode.State.FAILED;
            stringbuilder.append(getErrorMessage(asyncresult));
        } else {
            int ai[] = (int[])(int[])asyncresult.result;
            if(ai.length != 0) {
                if(ai[0] == 0)
                    stringbuilder.append(context.getText(0x10400ca));
                else
                if(sc.equals("43"))
                    stringbuilder.append(createQueryCallWaitingResultMessage(ai[1]));
                else
                if(isServiceCodeCallBarring(sc))
                    stringbuilder.append(createQueryCallBarringResultMessage(ai[0]));
                else
                if(ai[0] == 1)
                    stringbuilder.append(context.getText(0x10400c8));
                else
                    stringbuilder.append(context.getText(0x10400c6));
            } else {
                stringbuilder.append(context.getText(0x10400c6));
            }
            state = com.android.internal.telephony.MmiCode.State.COMPLETE;
        }
        message = stringbuilder;
        phone.onMMIDone(this);
    }

    private void onSetComplete(AsyncResult asyncresult) {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder(getScString());
        stringbuilder.append("\n");
        if(asyncresult.exception == null) goto _L2; else goto _L1
_L1:
        state = com.android.internal.telephony.MmiCode.State.FAILED;
        if(asyncresult.exception instanceof CommandException) {
            com.android.internal.telephony.CommandException.Error error = ((CommandException)(CommandException)asyncresult.exception).getCommandError();
            if(error == com.android.internal.telephony.CommandException.Error.PASSWORD_INCORRECT) {
                if(isPinCommand()) {
                    if(sc.equals("05") || sc.equals("052"))
                        stringbuilder.append(context.getText(0x10400d0));
                    else
                        stringbuilder.append(context.getText(0x10400cf));
                } else {
                    stringbuilder.append(context.getText(0x10400cd));
                }
            } else
            if(error == com.android.internal.telephony.CommandException.Error.SIM_PUK2) {
                stringbuilder.append(context.getText(0x10400cf));
                stringbuilder.append("\n");
                stringbuilder.append(context.getText(0x10400d5));
            } else
            if(error == com.android.internal.telephony.CommandException.Error.FDN_CHECK_FAILURE) {
                Log.i("GSM", "FDN_CHECK_FAILURE");
                stringbuilder.append(context.getText(0x10400c7));
            } else {
                stringbuilder.append(context.getText(0x10400c6));
            }
        } else {
            stringbuilder.append(context.getText(0x10400c6));
        }
_L4:
        message = stringbuilder;
        phone.onMMIDone(this);
        return;
_L2:
        if(isActivate()) {
            state = com.android.internal.telephony.MmiCode.State.COMPLETE;
            stringbuilder.append(context.getText(0x10400c8));
            if(sc.equals("31"))
                phone.saveClirSetting(1);
        } else
        if(isDeactivate()) {
            state = com.android.internal.telephony.MmiCode.State.COMPLETE;
            stringbuilder.append(context.getText(0x10400ca));
            if(sc.equals("31"))
                phone.saveClirSetting(2);
        } else
        if(isRegister()) {
            state = com.android.internal.telephony.MmiCode.State.COMPLETE;
            stringbuilder.append(context.getText(0x10400cb));
        } else
        if(isErasure()) {
            state = com.android.internal.telephony.MmiCode.State.COMPLETE;
            stringbuilder.append(context.getText(0x10400cc));
        } else {
            state = com.android.internal.telephony.MmiCode.State.FAILED;
            stringbuilder.append(context.getText(0x10400c6));
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    static String scToBarringFacility(String s) {
        if(s == null)
            throw new RuntimeException("invalid call barring sc");
        String s1;
        if(s.equals("33"))
            s1 = "AO";
        else
        if(s.equals("331"))
            s1 = "OI";
        else
        if(s.equals("332"))
            s1 = "OX";
        else
        if(s.equals("35"))
            s1 = "AI";
        else
        if(s.equals("351"))
            s1 = "IR";
        else
        if(s.equals("330"))
            s1 = "AB";
        else
        if(s.equals("333"))
            s1 = "AG";
        else
        if(s.equals("353"))
            s1 = "AC";
        else
            throw new RuntimeException("invalid call barring sc");
        return s1;
    }

    private static int scToCallForwardReason(String s) {
        if(s == null)
            throw new RuntimeException("invalid call forward sc");
        byte byte0;
        if(s.equals("002"))
            byte0 = 4;
        else
        if(s.equals("21"))
            byte0 = 0;
        else
        if(s.equals("67"))
            byte0 = 1;
        else
        if(s.equals("62"))
            byte0 = 3;
        else
        if(s.equals("61"))
            byte0 = 2;
        else
        if(s.equals("004"))
            byte0 = 5;
        else
            throw new RuntimeException("invalid call forward sc");
        return byte0;
    }

    private CharSequence serviceClassToCFString(int i) {
        i;
        JVM INSTR lookupswitch 8: default 76
    //                   1: 80
    //                   2: 94
    //                   4: 108
    //                   8: 122
    //                   16: 136
    //                   32: 150
    //                   64: 164
    //                   128: 178;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        CharSequence charsequence = null;
_L11:
        return charsequence;
_L2:
        charsequence = context.getText(0x10400f4);
        continue; /* Loop/switch isn't completed */
_L3:
        charsequence = context.getText(0x10400f5);
        continue; /* Loop/switch isn't completed */
_L4:
        charsequence = context.getText(0x10400f6);
        continue; /* Loop/switch isn't completed */
_L5:
        charsequence = context.getText(0x10400f7);
        continue; /* Loop/switch isn't completed */
_L6:
        charsequence = context.getText(0x10400f9);
        continue; /* Loop/switch isn't completed */
_L7:
        charsequence = context.getText(0x10400f8);
        continue; /* Loop/switch isn't completed */
_L8:
        charsequence = context.getText(0x10400fa);
        continue; /* Loop/switch isn't completed */
_L9:
        charsequence = context.getText(0x10400fb);
        if(true) goto _L11; else goto _L10
_L10:
    }

    private static int siToServiceClass(String s) {
        if(s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        switch(Integer.parseInt(s, 10)) {
        default:
            throw new RuntimeException((new StringBuilder()).append("unsupported MMI service code ").append(s).toString());

        case 10: // '\n'
            i = 13;
            break;

        case 11: // '\013'
            i = 1;
            break;

        case 12: // '\f'
            i = 12;
            break;

        case 13: // '\r'
            i = 4;
            break;

        case 16: // '\020'
            i = 8;
            break;

        case 19: // '\023'
            i = 5;
            break;

        case 20: // '\024'
            i = 48;
            break;

        case 21: // '\025'
            i = 160;
            break;

        case 22: // '\026'
            i = 80;
            break;

        case 24: // '\030'
            i = 16;
            break;

        case 25: // '\031'
            i = 32;
            break;

        case 26: // '\032'
            i = 17;
            break;

        case 99: // 'c'
            i = 64;
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int siToTime(String s) {
        int i;
        if(s == null || s.length() == 0)
            i = 0;
        else
            i = Integer.parseInt(s, 10);
        return i;
    }

    public void cancel() {
        if(state != com.android.internal.telephony.MmiCode.State.COMPLETE && state != com.android.internal.telephony.MmiCode.State.FAILED) {
            state = com.android.internal.telephony.MmiCode.State.CANCELLED;
            if(isPendingUSSD)
                ((PhoneBase) (phone)).mCM.cancelPendingUssd(obtainMessage(7, this));
            else
                phone.onMMIDone(this);
        }
    }

    int getCLIRMode() {
        if(sc == null || !sc.equals("31")) goto _L2; else goto _L1
_L1:
        if(!isActivate()) goto _L4; else goto _L3
_L3:
        byte byte0 = 2;
_L6:
        return byte0;
_L4:
        if(isDeactivate()) {
            byte0 = 1;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        byte0 = 0;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public CharSequence getMessage() {
        return message;
    }

    public com.android.internal.telephony.MmiCode.State getState() {
        return state;
    }

    public void handleMessage(Message message1) {
        message1.what;
        JVM INSTR tableswitch 1 7: default 48
    //                   1 49
    //                   2 130
    //                   3 147
    //                   4 181
    //                   5 164
    //                   6 66
    //                   7 226;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return;
_L2:
        onSetComplete((AsyncResult)(AsyncResult)message1.obj);
        continue; /* Loop/switch isn't completed */
_L7:
        AsyncResult asyncresult1 = (AsyncResult)(AsyncResult)message1.obj;
        if(asyncresult1.exception == null && message1.arg1 == 1) {
            boolean flag;
            if(message1.arg2 == 1)
                flag = true;
            else
                flag = false;
            ((PhoneBase) (phone)).mIccRecords.setVoiceCallForwardingFlag(1, flag);
        }
        onSetComplete(asyncresult1);
        continue; /* Loop/switch isn't completed */
_L3:
        onGetClirComplete((AsyncResult)(AsyncResult)message1.obj);
        continue; /* Loop/switch isn't completed */
_L4:
        onQueryCfComplete((AsyncResult)(AsyncResult)message1.obj);
        continue; /* Loop/switch isn't completed */
_L6:
        onQueryComplete((AsyncResult)(AsyncResult)message1.obj);
        continue; /* Loop/switch isn't completed */
_L5:
        AsyncResult asyncresult = (AsyncResult)(AsyncResult)message1.obj;
        if(asyncresult.exception != null) {
            state = com.android.internal.telephony.MmiCode.State.FAILED;
            message = getErrorMessage(asyncresult);
            phone.onMMIDone(this);
        }
        continue; /* Loop/switch isn't completed */
_L8:
        phone.onMMIDone(this);
        if(true) goto _L1; else goto _L9
_L9:
    }

    boolean isActivate() {
        boolean flag;
        if(action != null && action.equals("*"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isCancelable() {
        return isPendingUSSD;
    }

    boolean isDeactivate() {
        boolean flag;
        if(action != null && action.equals("#"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isErasure() {
        boolean flag;
        if(action != null && action.equals("##"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isInterrogate() {
        boolean flag;
        if(action != null && action.equals("*#"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isMMI() {
        boolean flag;
        if(poundString != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isPendingUSSD() {
        return isPendingUSSD;
    }

    boolean isPinCommand() {
        boolean flag;
        if(sc != null && (sc.equals("04") || sc.equals("042") || sc.equals("05") || sc.equals("052")))
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

    boolean isShortCode() {
        boolean flag;
        if(poundString == null && dialingNumber != null && dialingNumber.length() <= 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isTemporaryModeCLIR() {
        boolean flag;
        if(sc != null && sc.equals("31") && dialingNumber != null && (isActivate() || isDeactivate()))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isUssdRequest() {
        return isUssdRequest;
    }

    void onUssdFinished(String s, boolean flag) {
        if(state == com.android.internal.telephony.MmiCode.State.PENDING) {
            if(s == null)
                message = context.getText(0x10400ce);
            else
                message = s;
            isUssdRequest = flag;
            if(!flag)
                state = com.android.internal.telephony.MmiCode.State.COMPLETE;
            phone.onMMIDone(this);
        }
    }

    void onUssdFinishedError() {
        if(state == com.android.internal.telephony.MmiCode.State.PENDING) {
            state = com.android.internal.telephony.MmiCode.State.FAILED;
            message = context.getText(0x10400c6);
            phone.onMMIDone(this);
        }
    }

    void processCode() {
        if(!isShortCode()) goto _L2; else goto _L1
_L1:
        Log.d("GSM", "isShortCode");
        sendUssd(dialingNumber);
          goto _L3
_L2:
        if(dialingNumber != null)
            throw new RuntimeException("Invalid or Unsupported MMI Code");
          goto _L4
        RuntimeException runtimeexception;
        runtimeexception;
        state = com.android.internal.telephony.MmiCode.State.FAILED;
        message = context.getText(0x10400c6);
        phone.onMMIDone(this);
          goto _L3
_L4:
        if(sc == null || !sc.equals("30")) goto _L6; else goto _L5
_L5:
        Log.d("GSM", "is CLIP");
        if(isInterrogate())
            ((PhoneBase) (phone)).mCM.queryCLIP(obtainMessage(5, this));
        else
            throw new RuntimeException("Invalid or Unsupported MMI Code");
          goto _L3
_L6:
        if(sc == null || !sc.equals("31")) goto _L8; else goto _L7
_L7:
        Log.d("GSM", "is CLIR");
        if(isActivate())
            ((PhoneBase) (phone)).mCM.setCLIR(1, obtainMessage(1, this));
        else
        if(isDeactivate())
            ((PhoneBase) (phone)).mCM.setCLIR(2, obtainMessage(1, this));
        else
        if(isInterrogate())
            ((PhoneBase) (phone)).mCM.getCLIR(obtainMessage(2, this));
        else
            throw new RuntimeException("Invalid or Unsupported MMI Code");
          goto _L3
_L8:
        if(!isServiceCodeCallForwarding(sc)) goto _L10; else goto _L9
_L9:
        String s7;
        int l;
        int i1;
        int j1;
        Log.d("GSM", "is CF");
        s7 = sia;
        l = siToServiceClass(sib);
        i1 = scToCallForwardReason(sc);
        j1 = siToTime(sic);
        if(!isInterrogate()) goto _L12; else goto _L11
_L11:
        ((PhoneBase) (phone)).mCM.queryCallForwardStatus(i1, l, s7, obtainMessage(3, this));
          goto _L3
_L12:
        byte byte0;
        int k1;
        int l1;
        if(isActivate())
            byte0 = 1;
        else
        if(isDeactivate())
            byte0 = 0;
        else
        if(isRegister())
            byte0 = 3;
        else
        if(isErasure())
            byte0 = 4;
        else
            throw new RuntimeException("invalid action");
          goto _L13
_L26:
        Log.d("GSM", "is CF setCallForward");
        ((PhoneBase) (phone)).mCM.setCallForward(byte0, i1, l, s7, j1, obtainMessage(6, k1, l1, this));
          goto _L3
_L10:
        if(!isServiceCodeCallBarring(sc)) goto _L15; else goto _L14
_L14:
        String s5 = sia;
        int k = siToServiceClass(sib);
        String s6 = scToBarringFacility(sc);
        if(isInterrogate())
            ((PhoneBase) (phone)).mCM.queryFacilityLock(s6, s5, k, obtainMessage(5, this));
        else
        if(isActivate() || isDeactivate())
            ((PhoneBase) (phone)).mCM.setFacilityLock(s6, isActivate(), s5, k, obtainMessage(1, this));
        else
            throw new RuntimeException("Invalid or Unsupported MMI Code");
          goto _L3
_L15:
        if(sc == null || !sc.equals("03")) goto _L17; else goto _L16
_L16:
        String s2 = sib;
        String s3 = sic;
        if(isActivate() || isRegister()) {
            action = "**";
            String s4;
            if(sia == null)
                s4 = "AB";
            else
                s4 = scToBarringFacility(sia);
            if(s3.equals(pwd))
                ((PhoneBase) (phone)).mCM.changeBarringPassword(s4, s2, s3, obtainMessage(1, this));
            else
                handlePasswordError(0x10400cd);
        } else {
            throw new RuntimeException("Invalid or Unsupported MMI Code");
        }
          goto _L3
_L17:
        if(sc == null || !sc.equals("43")) goto _L19; else goto _L18
_L18:
        int j = siToServiceClass(sia);
        if(isActivate() || isDeactivate())
            ((PhoneBase) (phone)).mCM.setCallWaiting(isActivate(), j, obtainMessage(1, this));
        else
        if(isInterrogate())
            ((PhoneBase) (phone)).mCM.queryCallWaiting(j, obtainMessage(5, this));
        else
            throw new RuntimeException("Invalid or Unsupported MMI Code");
          goto _L3
_L19:
        if(!isPinCommand()) goto _L21; else goto _L20
_L20:
        String s;
        String s1;
        int i;
        s = sia;
        s1 = sib;
        i = s1.length();
        if(!isRegister()) goto _L23; else goto _L22
_L22:
        if(s1.equals(sic)) goto _L25; else goto _L24
_L24:
        handlePasswordError(0x10400d1);
          goto _L3
_L27:
        handlePasswordError(0x10400d2);
          goto _L3
_L28:
        if(sc.equals("04") && phone.getIccCard().getState() == com.android.internal.telephony.IccCard.State.PUK_REQUIRED)
            handlePasswordError(0x10400d4);
        else
        if(sc.equals("04"))
            ((PhoneBase) (phone)).mCM.changeIccPin(s, s1, obtainMessage(1, this));
        else
        if(sc.equals("042"))
            ((PhoneBase) (phone)).mCM.changeIccPin2(s, s1, obtainMessage(1, this));
        else
        if(sc.equals("05"))
            ((PhoneBase) (phone)).mCM.supplyIccPuk(s, s1, obtainMessage(1, this));
        else
        if(sc.equals("052"))
            ((PhoneBase) (phone)).mCM.supplyIccPuk2(s, s1, obtainMessage(1, this));
          goto _L3
_L23:
        throw new RuntimeException("Invalid or Unsupported MMI Code");
_L21:
        if(poundString != null)
            sendUssd(poundString);
        else
            throw new RuntimeException("Invalid or Unsupported MMI Code");
_L3:
        return;
_L13:
        if((i1 == 0 || i1 == 4) && ((l & 1) != 0 || l == 0))
            k1 = 1;
        else
            k1 = 0;
        if(byte0 == 1 || byte0 == 3)
            l1 = 1;
        else
            l1 = 0;
          goto _L26
_L25:
        if(i >= 4 && i <= 8) goto _L28; else goto _L27
    }

    void sendUssd(String s) {
        isPendingUSSD = true;
        ((PhoneBase) (phone)).mCM.sendUSSD(s, obtainMessage(4, this));
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("GsmMmiCode {");
        stringbuilder.append((new StringBuilder()).append("State=").append(getState()).toString());
        if(action != null)
            stringbuilder.append((new StringBuilder()).append(" action=").append(action).toString());
        if(sc != null)
            stringbuilder.append((new StringBuilder()).append(" sc=").append(sc).toString());
        if(sia != null)
            stringbuilder.append((new StringBuilder()).append(" sia=").append(sia).toString());
        if(sib != null)
            stringbuilder.append((new StringBuilder()).append(" sib=").append(sib).toString());
        if(sic != null)
            stringbuilder.append((new StringBuilder()).append(" sic=").append(sic).toString());
        if(poundString != null)
            stringbuilder.append((new StringBuilder()).append(" poundString=").append(poundString).toString());
        if(dialingNumber != null)
            stringbuilder.append((new StringBuilder()).append(" dialingNumber=").append(dialingNumber).toString());
        if(pwd != null)
            stringbuilder.append((new StringBuilder()).append(" pwd=").append(pwd).toString());
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    static final String ACTION_ACTIVATE = "*";
    static final String ACTION_DEACTIVATE = "#";
    static final String ACTION_ERASURE = "##";
    static final String ACTION_INTERROGATE = "*#";
    static final String ACTION_REGISTER = "**";
    static final char END_OF_USSD_COMMAND = 35;
    static final int EVENT_GET_CLIR_COMPLETE = 2;
    static final int EVENT_QUERY_CF_COMPLETE = 3;
    static final int EVENT_QUERY_COMPLETE = 5;
    static final int EVENT_SET_CFF_COMPLETE = 6;
    static final int EVENT_SET_COMPLETE = 1;
    static final int EVENT_USSD_CANCEL_COMPLETE = 7;
    static final int EVENT_USSD_COMPLETE = 4;
    static final String LOG_TAG = "GSM";
    static final int MATCH_GROUP_ACTION = 2;
    static final int MATCH_GROUP_DIALING_NUMBER = 12;
    static final int MATCH_GROUP_POUND_STRING = 1;
    static final int MATCH_GROUP_PWD_CONFIRM = 11;
    static final int MATCH_GROUP_SERVICE_CODE = 3;
    static final int MATCH_GROUP_SIA = 5;
    static final int MATCH_GROUP_SIB = 7;
    static final int MATCH_GROUP_SIC = 9;
    static final int MAX_LENGTH_SHORT_CODE = 2;
    static final String SC_BAIC = "35";
    static final String SC_BAICr = "351";
    static final String SC_BAOC = "33";
    static final String SC_BAOIC = "331";
    static final String SC_BAOICxH = "332";
    static final String SC_BA_ALL = "330";
    static final String SC_BA_MO = "333";
    static final String SC_BA_MT = "353";
    static final String SC_CFB = "67";
    static final String SC_CFNR = "62";
    static final String SC_CFNRy = "61";
    static final String SC_CFU = "21";
    static final String SC_CF_All = "002";
    static final String SC_CF_All_Conditional = "004";
    static final String SC_CLIP = "30";
    static final String SC_CLIR = "31";
    static final String SC_PIN = "04";
    static final String SC_PIN2 = "042";
    static final String SC_PUK = "05";
    static final String SC_PUK2 = "052";
    static final String SC_PWD = "03";
    static final String SC_WAIT = "43";
    static Pattern sPatternSuppService = Pattern.compile("((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)([^#]*)");
    private static String sTwoDigitNumberPattern[];
    String action;
    Context context;
    String dialingNumber;
    private boolean isPendingUSSD;
    private boolean isUssdRequest;
    CharSequence message;
    GSMPhone phone;
    String poundString;
    String pwd;
    String sc;
    String sia;
    String sib;
    String sic;
    com.android.internal.telephony.MmiCode.State state;

}
