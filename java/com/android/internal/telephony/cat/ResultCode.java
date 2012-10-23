// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


public final class ResultCode extends Enum {

    private ResultCode(String s, int i, int j) {
        super(s, i);
        mCode = j;
    }

    public static ResultCode fromInt(int i) {
        ResultCode aresultcode[];
        int j;
        int k;
        aresultcode = values();
        j = aresultcode.length;
        k = 0;
_L3:
        ResultCode resultcode;
        if(k >= j)
            break MISSING_BLOCK_LABEL_37;
        resultcode = aresultcode[k];
        if(resultcode.mCode != i) goto _L2; else goto _L1
_L1:
        return resultcode;
_L2:
        k++;
          goto _L3
        resultcode = null;
          goto _L1
    }

    public static ResultCode valueOf(String s) {
        return (ResultCode)Enum.valueOf(com/android/internal/telephony/cat/ResultCode, s);
    }

    public static ResultCode[] values() {
        return (ResultCode[])$VALUES.clone();
    }

    public int value() {
        return mCode;
    }

    private static final ResultCode $VALUES[];
    public static final ResultCode ACCESS_TECH_UNABLE_TO_PROCESS;
    public static final ResultCode BACKWARD_MOVE_BY_USER;
    public static final ResultCode BEYOND_TERMINAL_CAPABILITY;
    public static final ResultCode BIP_ERROR;
    public static final ResultCode CMD_DATA_NOT_UNDERSTOOD;
    public static final ResultCode CMD_NUM_NOT_KNOWN;
    public static final ResultCode CMD_TYPE_NOT_UNDERSTOOD;
    public static final ResultCode CONTRADICTION_WITH_TIMER;
    public static final ResultCode FRAMES_ERROR;
    public static final ResultCode HELP_INFO_REQUIRED;
    public static final ResultCode LAUNCH_BROWSER_ERROR;
    public static final ResultCode MMS_ERROR;
    public static final ResultCode MMS_TEMPORARY;
    public static final ResultCode MULTI_CARDS_CMD_ERROR;
    public static final ResultCode NAA_CALL_CONTROL_TEMPORARY;
    public static final ResultCode NETWORK_CRNTLY_UNABLE_TO_PROCESS;
    public static final ResultCode NO_RESPONSE_FROM_USER;
    public static final ResultCode OK;
    public static final ResultCode PRFRMD_ICON_NOT_DISPLAYED;
    public static final ResultCode PRFRMD_LIMITED_SERVICE;
    public static final ResultCode PRFRMD_MODIFIED_BY_NAA;
    public static final ResultCode PRFRMD_NAA_NOT_ACTIVE;
    public static final ResultCode PRFRMD_TONE_NOT_PLAYED;
    public static final ResultCode PRFRMD_WITH_ADDITIONAL_EFS_READ;
    public static final ResultCode PRFRMD_WITH_MISSING_INFO;
    public static final ResultCode PRFRMD_WITH_MODIFICATION;
    public static final ResultCode PRFRMD_WITH_PARTIAL_COMPREHENSION;
    public static final ResultCode REQUIRED_VALUES_MISSING;
    public static final ResultCode SMS_RP_ERROR;
    public static final ResultCode SS_RETURN_ERROR;
    public static final ResultCode TERMINAL_CRNTLY_UNABLE_TO_PROCESS;
    public static final ResultCode UICC_SESSION_TERM_BY_USER;
    public static final ResultCode USER_CLEAR_DOWN_CALL;
    public static final ResultCode USER_NOT_ACCEPT;
    public static final ResultCode USIM_CALL_CONTROL_PERMANENT;
    public static final ResultCode USSD_RETURN_ERROR;
    public static final ResultCode USSD_SS_SESSION_TERM_BY_USER;
    private int mCode;

    static  {
        OK = new ResultCode("OK", 0, 0);
        PRFRMD_WITH_PARTIAL_COMPREHENSION = new ResultCode("PRFRMD_WITH_PARTIAL_COMPREHENSION", 1, 1);
        PRFRMD_WITH_MISSING_INFO = new ResultCode("PRFRMD_WITH_MISSING_INFO", 2, 2);
        PRFRMD_WITH_ADDITIONAL_EFS_READ = new ResultCode("PRFRMD_WITH_ADDITIONAL_EFS_READ", 3, 3);
        PRFRMD_ICON_NOT_DISPLAYED = new ResultCode("PRFRMD_ICON_NOT_DISPLAYED", 4, 4);
        PRFRMD_MODIFIED_BY_NAA = new ResultCode("PRFRMD_MODIFIED_BY_NAA", 5, 5);
        PRFRMD_LIMITED_SERVICE = new ResultCode("PRFRMD_LIMITED_SERVICE", 6, 6);
        PRFRMD_WITH_MODIFICATION = new ResultCode("PRFRMD_WITH_MODIFICATION", 7, 7);
        PRFRMD_NAA_NOT_ACTIVE = new ResultCode("PRFRMD_NAA_NOT_ACTIVE", 8, 8);
        PRFRMD_TONE_NOT_PLAYED = new ResultCode("PRFRMD_TONE_NOT_PLAYED", 9, 9);
        UICC_SESSION_TERM_BY_USER = new ResultCode("UICC_SESSION_TERM_BY_USER", 10, 16);
        BACKWARD_MOVE_BY_USER = new ResultCode("BACKWARD_MOVE_BY_USER", 11, 17);
        NO_RESPONSE_FROM_USER = new ResultCode("NO_RESPONSE_FROM_USER", 12, 18);
        HELP_INFO_REQUIRED = new ResultCode("HELP_INFO_REQUIRED", 13, 19);
        USSD_SS_SESSION_TERM_BY_USER = new ResultCode("USSD_SS_SESSION_TERM_BY_USER", 14, 20);
        TERMINAL_CRNTLY_UNABLE_TO_PROCESS = new ResultCode("TERMINAL_CRNTLY_UNABLE_TO_PROCESS", 15, 32);
        NETWORK_CRNTLY_UNABLE_TO_PROCESS = new ResultCode("NETWORK_CRNTLY_UNABLE_TO_PROCESS", 16, 33);
        USER_NOT_ACCEPT = new ResultCode("USER_NOT_ACCEPT", 17, 34);
        USER_CLEAR_DOWN_CALL = new ResultCode("USER_CLEAR_DOWN_CALL", 18, 35);
        CONTRADICTION_WITH_TIMER = new ResultCode("CONTRADICTION_WITH_TIMER", 19, 36);
        NAA_CALL_CONTROL_TEMPORARY = new ResultCode("NAA_CALL_CONTROL_TEMPORARY", 20, 37);
        LAUNCH_BROWSER_ERROR = new ResultCode("LAUNCH_BROWSER_ERROR", 21, 38);
        MMS_TEMPORARY = new ResultCode("MMS_TEMPORARY", 22, 39);
        BEYOND_TERMINAL_CAPABILITY = new ResultCode("BEYOND_TERMINAL_CAPABILITY", 23, 48);
        CMD_TYPE_NOT_UNDERSTOOD = new ResultCode("CMD_TYPE_NOT_UNDERSTOOD", 24, 49);
        CMD_DATA_NOT_UNDERSTOOD = new ResultCode("CMD_DATA_NOT_UNDERSTOOD", 25, 50);
        CMD_NUM_NOT_KNOWN = new ResultCode("CMD_NUM_NOT_KNOWN", 26, 51);
        SS_RETURN_ERROR = new ResultCode("SS_RETURN_ERROR", 27, 52);
        SMS_RP_ERROR = new ResultCode("SMS_RP_ERROR", 28, 53);
        REQUIRED_VALUES_MISSING = new ResultCode("REQUIRED_VALUES_MISSING", 29, 54);
        USSD_RETURN_ERROR = new ResultCode("USSD_RETURN_ERROR", 30, 55);
        MULTI_CARDS_CMD_ERROR = new ResultCode("MULTI_CARDS_CMD_ERROR", 31, 56);
        USIM_CALL_CONTROL_PERMANENT = new ResultCode("USIM_CALL_CONTROL_PERMANENT", 32, 57);
        BIP_ERROR = new ResultCode("BIP_ERROR", 33, 58);
        ACCESS_TECH_UNABLE_TO_PROCESS = new ResultCode("ACCESS_TECH_UNABLE_TO_PROCESS", 34, 59);
        FRAMES_ERROR = new ResultCode("FRAMES_ERROR", 35, 60);
        MMS_ERROR = new ResultCode("MMS_ERROR", 36, 61);
        ResultCode aresultcode[] = new ResultCode[37];
        aresultcode[0] = OK;
        aresultcode[1] = PRFRMD_WITH_PARTIAL_COMPREHENSION;
        aresultcode[2] = PRFRMD_WITH_MISSING_INFO;
        aresultcode[3] = PRFRMD_WITH_ADDITIONAL_EFS_READ;
        aresultcode[4] = PRFRMD_ICON_NOT_DISPLAYED;
        aresultcode[5] = PRFRMD_MODIFIED_BY_NAA;
        aresultcode[6] = PRFRMD_LIMITED_SERVICE;
        aresultcode[7] = PRFRMD_WITH_MODIFICATION;
        aresultcode[8] = PRFRMD_NAA_NOT_ACTIVE;
        aresultcode[9] = PRFRMD_TONE_NOT_PLAYED;
        aresultcode[10] = UICC_SESSION_TERM_BY_USER;
        aresultcode[11] = BACKWARD_MOVE_BY_USER;
        aresultcode[12] = NO_RESPONSE_FROM_USER;
        aresultcode[13] = HELP_INFO_REQUIRED;
        aresultcode[14] = USSD_SS_SESSION_TERM_BY_USER;
        aresultcode[15] = TERMINAL_CRNTLY_UNABLE_TO_PROCESS;
        aresultcode[16] = NETWORK_CRNTLY_UNABLE_TO_PROCESS;
        aresultcode[17] = USER_NOT_ACCEPT;
        aresultcode[18] = USER_CLEAR_DOWN_CALL;
        aresultcode[19] = CONTRADICTION_WITH_TIMER;
        aresultcode[20] = NAA_CALL_CONTROL_TEMPORARY;
        aresultcode[21] = LAUNCH_BROWSER_ERROR;
        aresultcode[22] = MMS_TEMPORARY;
        aresultcode[23] = BEYOND_TERMINAL_CAPABILITY;
        aresultcode[24] = CMD_TYPE_NOT_UNDERSTOOD;
        aresultcode[25] = CMD_DATA_NOT_UNDERSTOOD;
        aresultcode[26] = CMD_NUM_NOT_KNOWN;
        aresultcode[27] = SS_RETURN_ERROR;
        aresultcode[28] = SMS_RP_ERROR;
        aresultcode[29] = REQUIRED_VALUES_MISSING;
        aresultcode[30] = USSD_RETURN_ERROR;
        aresultcode[31] = MULTI_CARDS_CMD_ERROR;
        aresultcode[32] = USIM_CALL_CONTROL_PERMANENT;
        aresultcode[33] = BIP_ERROR;
        aresultcode[34] = ACCESS_TECH_UNABLE_TO_PROCESS;
        aresultcode[35] = FRAMES_ERROR;
        aresultcode[36] = MMS_ERROR;
        $VALUES = aresultcode;
    }
}
