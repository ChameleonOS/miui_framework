// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import java.util.Arrays;

// Referenced classes of package com.android.internal.telephony:
//            SmsAddress, SmsHeader

public abstract class SmsMessageBase {
    public static abstract class SubmitPduBase {

        public String toString() {
            return (new StringBuilder()).append("SubmitPdu: encodedScAddress = ").append(Arrays.toString(encodedScAddress)).append(", encodedMessage = ").append(Arrays.toString(encodedMessage)).toString();
        }

        public byte encodedMessage[];
        public byte encodedScAddress[];

        public SubmitPduBase() {
        }
    }

    public static class TextEncodingDetails {

        public String toString() {
            return (new StringBuilder()).append("TextEncodingDetails { msgCount=").append(msgCount).append(", codeUnitCount=").append(codeUnitCount).append(", codeUnitsRemaining=").append(codeUnitsRemaining).append(", codeUnitSize=").append(codeUnitSize).append(", languageTable=").append(languageTable).append(", languageShiftTable=").append(languageShiftTable).append(" }").toString();
        }

        public int codeUnitCount;
        public int codeUnitSize;
        public int codeUnitsRemaining;
        public int languageShiftTable;
        public int languageTable;
        public int msgCount;

        public TextEncodingDetails() {
        }
    }


    public SmsMessageBase() {
        statusOnIcc = -1;
        indexOnIcc = -1;
    }

    protected void extractEmailAddressFromMessageBody() {
        String as[] = messageBody.split("( /)|( )", 2);
        if(as.length >= 2) {
            emailFrom = as[0];
            emailBody = as[1];
            isEmail = android.provider.Telephony.Mms.isEmailAddress(emailFrom);
        }
    }

    public String getDisplayMessageBody() {
        String s;
        if(isEmail)
            s = emailBody;
        else
            s = getMessageBody();
        return s;
    }

    public String getDisplayOriginatingAddress() {
        String s;
        if(isEmail)
            s = emailFrom;
        else
            s = getOriginatingAddress();
        return s;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public int getIndexOnIcc() {
        return indexOnIcc;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public abstract android.telephony.SmsMessage.MessageClass getMessageClass();

    public String getOriginatingAddress() {
        String s;
        if(originatingAddress == null)
            s = null;
        else
            s = originatingAddress.getAddressString();
        return s;
    }

    public byte[] getPdu() {
        return mPdu;
    }

    public abstract int getProtocolIdentifier();

    public String getPseudoSubject() {
        String s;
        if(pseudoSubject == null)
            s = "";
        else
            s = pseudoSubject;
        return s;
    }

    public String getServiceCenterAddress() {
        return scAddress;
    }

    public abstract int getStatus();

    public int getStatusOnIcc() {
        return statusOnIcc;
    }

    public long getTimestampMillis() {
        return scTimeMillis;
    }

    public byte[] getUserData() {
        return userData;
    }

    public SmsHeader getUserDataHeader() {
        return userDataHeader;
    }

    public abstract boolean isCphsMwiMessage();

    public boolean isEmail() {
        return isEmail;
    }

    public abstract boolean isMWIClearMessage();

    public abstract boolean isMWISetMessage();

    public abstract boolean isMwiDontStore();

    public abstract boolean isReplace();

    public abstract boolean isReplyPathPresent();

    public abstract boolean isStatusReportMessage();

    protected void parseMessageBody() {
        if(originatingAddress != null && originatingAddress.couldBeEmailGateway())
            extractEmailAddressFromMessageBody();
    }

    private static final String LOG_TAG = "SMS";
    protected String emailBody;
    protected String emailFrom;
    protected int indexOnIcc;
    protected boolean isEmail;
    protected boolean isMwi;
    protected byte mPdu[];
    protected String messageBody;
    public int messageRef;
    protected boolean mwiDontStore;
    protected boolean mwiSense;
    protected SmsAddress originatingAddress;
    protected String pseudoSubject;
    protected String scAddress;
    protected long scTimeMillis;
    protected int statusOnIcc;
    protected byte userData[];
    protected SmsHeader userDataHeader;
}
