// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


// Referenced classes of package com.android.internal.telephony.cat:
//            CatException, ResultCode

public class ResultException extends CatException {

    public ResultException(ResultCode resultcode) {
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$cat$ResultCode[];

            static  {
                $SwitchMap$com$android$internal$telephony$cat$ResultCode = new int[ResultCode.values().length];
                NoSuchFieldError nosuchfielderror7;
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.TERMINAL_CRNTLY_UNABLE_TO_PROCESS.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.NETWORK_CRNTLY_UNABLE_TO_PROCESS.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.LAUNCH_BROWSER_ERROR.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.MULTI_CARDS_CMD_ERROR.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.USIM_CALL_CONTROL_PERMANENT.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.BIP_ERROR.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.FRAMES_ERROR.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.MMS_ERROR.ordinal()] = 8;
_L2:
                return;
                nosuchfielderror7;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        switch(_cls1..SwitchMap.com.android.internal.telephony.cat.ResultCode[resultcode.ordinal()]) {
        default:
            mResult = resultcode;
            mAdditionalInfo = -1;
            mExplanation = "";
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            throw new AssertionError((new StringBuilder()).append("For result code, ").append(resultcode).append(", additional information must be given!").toString());
        }
    }

    public ResultException(ResultCode resultcode, int i) {
        this(resultcode);
        if(i < 0) {
            throw new AssertionError("Additional info must be greater than zero!");
        } else {
            mAdditionalInfo = i;
            return;
        }
    }

    public ResultException(ResultCode resultcode, int i, String s) {
        this(resultcode, i);
        mExplanation = s;
    }

    public ResultException(ResultCode resultcode, String s) {
        this(resultcode);
        mExplanation = s;
    }

    public int additionalInfo() {
        return mAdditionalInfo;
    }

    public String explanation() {
        return mExplanation;
    }

    public boolean hasAdditionalInfo() {
        boolean flag;
        if(mAdditionalInfo >= 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public ResultCode result() {
        return mResult;
    }

    public String toString() {
        return (new StringBuilder()).append("result=").append(mResult).append(" additionalInfo=").append(mAdditionalInfo).append(" explantion=").append(mExplanation).toString();
    }

    private int mAdditionalInfo;
    private String mExplanation;
    private ResultCode mResult;
}
