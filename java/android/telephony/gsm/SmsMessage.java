// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony.gsm;

import android.telephony.TelephonyManager;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase;
import java.util.Arrays;

public class SmsMessage {
    public static class SubmitPdu {

        public String toString() {
            return (new StringBuilder()).append("SubmitPdu: encodedScAddress = ").append(Arrays.toString(encodedScAddress)).append(", encodedMessage = ").append(Arrays.toString(encodedMessage)).toString();
        }

        public byte encodedMessage[];
        public byte encodedScAddress[];

        public SubmitPdu() {
        }

        protected SubmitPdu(com.android.internal.telephony.SmsMessageBase.SubmitPduBase submitpdubase) {
            encodedMessage = submitpdubase.encodedMessage;
            encodedScAddress = submitpdubase.encodedScAddress;
        }
    }

    public static final class MessageClass extends Enum {

        public static MessageClass valueOf(String s) {
            return (MessageClass)Enum.valueOf(android/telephony/gsm/SmsMessage$MessageClass, s);
        }

        public static MessageClass[] values() {
            return (MessageClass[])$VALUES.clone();
        }

        private static final MessageClass $VALUES[];
        public static final MessageClass CLASS_0;
        public static final MessageClass CLASS_1;
        public static final MessageClass CLASS_2;
        public static final MessageClass CLASS_3;
        public static final MessageClass UNKNOWN;

        static  {
            UNKNOWN = new MessageClass("UNKNOWN", 0);
            CLASS_0 = new MessageClass("CLASS_0", 1);
            CLASS_1 = new MessageClass("CLASS_1", 2);
            CLASS_2 = new MessageClass("CLASS_2", 3);
            CLASS_3 = new MessageClass("CLASS_3", 4);
            MessageClass amessageclass[] = new MessageClass[5];
            amessageclass[0] = UNKNOWN;
            amessageclass[1] = CLASS_0;
            amessageclass[2] = CLASS_1;
            amessageclass[3] = CLASS_2;
            amessageclass[4] = CLASS_3;
            $VALUES = amessageclass;
        }

        private MessageClass(String s, int i) {
            super(s, i);
        }
    }


    public SmsMessage() {
        this(getSmsFacility());
    }

    private SmsMessage(SmsMessageBase smsmessagebase) {
        mWrappedSmsMessage = smsmessagebase;
    }

    public static int[] calculateLength(CharSequence charsequence, boolean flag) {
        com.android.internal.telephony.SmsMessageBase.TextEncodingDetails textencodingdetails = com.android.internal.telephony.gsm.SmsMessage.calculateLength(charsequence, flag);
        int ai[] = new int[4];
        ai[0] = textencodingdetails.msgCount;
        ai[1] = textencodingdetails.codeUnitCount;
        ai[2] = textencodingdetails.codeUnitsRemaining;
        ai[3] = textencodingdetails.codeUnitSize;
        return ai;
    }

    public static int[] calculateLength(String s, boolean flag) {
        return calculateLength(((CharSequence) (s)), flag);
    }

    public static SmsMessage createFromPdu(byte abyte0[]) {
        Object obj;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            obj = com.android.internal.telephony.cdma.SmsMessage.createFromPdu(abyte0);
        else
            obj = com.android.internal.telephony.gsm.SmsMessage.createFromPdu(abyte0);
        return new SmsMessage(((SmsMessageBase) (obj)));
    }

    private static final SmsMessageBase getSmsFacility() {
        Object obj;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            obj = new com.android.internal.telephony.cdma.SmsMessage();
        else
            obj = new com.android.internal.telephony.gsm.SmsMessage();
        return ((SmsMessageBase) (obj));
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, String s2, boolean flag) {
        Object obj;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            obj = com.android.internal.telephony.cdma.SmsMessage.getSubmitPdu(s, s1, s2, flag, null);
        else
            obj = com.android.internal.telephony.gsm.SmsMessage.getSubmitPdu(s, s1, s2, flag);
        return new SubmitPdu(((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (obj)));
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, String s2, boolean flag, byte abyte0[]) {
        Object obj;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            obj = com.android.internal.telephony.cdma.SmsMessage.getSubmitPdu(s, s1, s2, flag, SmsHeader.fromByteArray(abyte0));
        else
            obj = com.android.internal.telephony.gsm.SmsMessage.getSubmitPdu(s, s1, s2, flag, abyte0);
        return new SubmitPdu(((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (obj)));
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, short word0, byte abyte0[], boolean flag) {
        Object obj;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            obj = com.android.internal.telephony.cdma.SmsMessage.getSubmitPdu(s, s1, word0, abyte0, flag);
        else
            obj = com.android.internal.telephony.gsm.SmsMessage.getSubmitPdu(s, s1, word0, abyte0, flag);
        return new SubmitPdu(((com.android.internal.telephony.SmsMessageBase.SubmitPduBase) (obj)));
    }

    public static int getTPLayerLengthForPDU(String s) {
        int i;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            i = com.android.internal.telephony.cdma.SmsMessage.getTPLayerLengthForPDU(s);
        else
            i = com.android.internal.telephony.gsm.SmsMessage.getTPLayerLengthForPDU(s);
        return i;
    }

    public String getDisplayMessageBody() {
        return mWrappedSmsMessage.getDisplayMessageBody();
    }

    public String getDisplayOriginatingAddress() {
        return mWrappedSmsMessage.getDisplayOriginatingAddress();
    }

    public String getEmailBody() {
        return mWrappedSmsMessage.getEmailBody();
    }

    public String getEmailFrom() {
        return mWrappedSmsMessage.getEmailFrom();
    }

    public int getIndexOnIcc() {
        return mWrappedSmsMessage.getIndexOnIcc();
    }

    public int getIndexOnSim() {
        return mWrappedSmsMessage.getIndexOnIcc();
    }

    public String getMessageBody() {
        return mWrappedSmsMessage.getMessageBody();
    }

    public MessageClass getMessageClass() {
        int i = mWrappedSmsMessage.getMessageClass().ordinal();
        return MessageClass.values()[i];
    }

    public String getOriginatingAddress() {
        return mWrappedSmsMessage.getOriginatingAddress();
    }

    public byte[] getPdu() {
        return mWrappedSmsMessage.getPdu();
    }

    public int getProtocolIdentifier() {
        return mWrappedSmsMessage.getProtocolIdentifier();
    }

    public String getPseudoSubject() {
        return mWrappedSmsMessage.getPseudoSubject();
    }

    public String getServiceCenterAddress() {
        return mWrappedSmsMessage.getServiceCenterAddress();
    }

    public int getStatus() {
        return mWrappedSmsMessage.getStatus();
    }

    public int getStatusOnIcc() {
        return mWrappedSmsMessage.getStatusOnIcc();
    }

    public int getStatusOnSim() {
        return mWrappedSmsMessage.getStatusOnIcc();
    }

    public long getTimestampMillis() {
        return mWrappedSmsMessage.getTimestampMillis();
    }

    public byte[] getUserData() {
        return mWrappedSmsMessage.getUserData();
    }

    public boolean isCphsMwiMessage() {
        return mWrappedSmsMessage.isCphsMwiMessage();
    }

    public boolean isEmail() {
        return mWrappedSmsMessage.isEmail();
    }

    public boolean isMWIClearMessage() {
        return mWrappedSmsMessage.isMWIClearMessage();
    }

    public boolean isMWISetMessage() {
        return mWrappedSmsMessage.isMWISetMessage();
    }

    public boolean isMwiDontStore() {
        return mWrappedSmsMessage.isMwiDontStore();
    }

    public boolean isReplace() {
        return mWrappedSmsMessage.isReplace();
    }

    public boolean isReplyPathPresent() {
        return mWrappedSmsMessage.isReplyPathPresent();
    }

    public boolean isStatusReportMessage() {
        return mWrappedSmsMessage.isStatusReportMessage();
    }

    public static final int ENCODING_16BIT = 3;
    public static final int ENCODING_7BIT = 1;
    public static final int ENCODING_8BIT = 2;
    public static final int ENCODING_UNKNOWN = 0;
    private static final boolean LOCAL_DEBUG = true;
    private static final String LOG_TAG = "SMS";
    public static final int MAX_USER_DATA_BYTES = 140;
    public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
    public static final int MAX_USER_DATA_SEPTETS = 160;
    public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
    public SmsMessageBase mWrappedSmsMessage;
}
