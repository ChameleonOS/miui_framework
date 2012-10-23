// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.Parcel;
import android.util.Log;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsMessageBase;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package android.telephony:
//            TelephonyManager

public class SmsMessage {
    public static class SubmitPdu {

        public String toString() {
            return (new StringBuilder()).append("SubmitPdu: encodedScAddress = ").append(Arrays.toString(encodedScAddress)).append(", encodedMessage = ").append(Arrays.toString(encodedMessage)).toString();
        }

        public byte encodedMessage[];
        public byte encodedScAddress[];

        protected SubmitPdu(com.android.internal.telephony.SmsMessageBase.SubmitPduBase submitpdubase) {
            encodedMessage = submitpdubase.encodedMessage;
            encodedScAddress = submitpdubase.encodedScAddress;
        }
    }

    public static final class MessageClass extends Enum {

        public static MessageClass valueOf(String s) {
            return (MessageClass)Enum.valueOf(android/telephony/SmsMessage$MessageClass, s);
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


    private SmsMessage(SmsMessageBase smsmessagebase) {
        mWrappedSmsMessage = smsmessagebase;
    }

    public static int[] calculateLength(CharSequence charsequence, boolean flag) {
        com.android.internal.telephony.SmsMessageBase.TextEncodingDetails textencodingdetails;
        int ai[];
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            textencodingdetails = com.android.internal.telephony.cdma.SmsMessage.calculateLength(charsequence, flag);
        else
            textencodingdetails = com.android.internal.telephony.gsm.SmsMessage.calculateLength(charsequence, flag);
        ai = new int[4];
        ai[0] = textencodingdetails.msgCount;
        ai[1] = textencodingdetails.codeUnitCount;
        ai[2] = textencodingdetails.codeUnitsRemaining;
        ai[3] = textencodingdetails.codeUnitSize;
        return ai;
    }

    public static int[] calculateLength(String s, boolean flag) {
        return calculateLength(((CharSequence) (s)), flag);
    }

    public static SmsMessage createFromEfRecord(int i, byte abyte0[]) {
        Object obj;
        SmsMessage smsmessage;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            obj = com.android.internal.telephony.cdma.SmsMessage.createFromEfRecord(i, abyte0);
        else
            obj = com.android.internal.telephony.gsm.SmsMessage.createFromEfRecord(i, abyte0);
        if(obj != null)
            smsmessage = new SmsMessage(((SmsMessageBase) (obj)));
        else
            smsmessage = null;
        return smsmessage;
    }

    public static SmsMessage createFromPdu(byte abyte0[]) {
        String s;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            s = "3gpp2";
        else
            s = "3gpp";
        return createFromPdu(abyte0, s);
    }

    public static SmsMessage createFromPdu(byte abyte0[], String s) {
        SmsMessage smsmessage;
        Object obj;
        if("3gpp2".equals(s)) {
            obj = com.android.internal.telephony.cdma.SmsMessage.createFromPdu(abyte0);
        } else {
label0:
            {
                if(!"3gpp".equals(s))
                    break label0;
                obj = com.android.internal.telephony.gsm.SmsMessage.createFromPdu(abyte0);
            }
        }
        smsmessage = new SmsMessage(((SmsMessageBase) (obj)));
_L2:
        return smsmessage;
        Log.e("SMS", (new StringBuilder()).append("createFromPdu(): unsupported message format ").append(s).toString());
        smsmessage = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static ArrayList fragmentText(String s) {
        int i = TelephonyManager.getDefault().getCurrentPhoneType();
        com.android.internal.telephony.SmsMessageBase.TextEncodingDetails textencodingdetails;
        int j;
        int k;
        int l;
        ArrayList arraylist;
        if(2 == i)
            textencodingdetails = com.android.internal.telephony.cdma.SmsMessage.calculateLength(s, false);
        else
            textencodingdetails = com.android.internal.telephony.gsm.SmsMessage.calculateLength(s, false);
        if(textencodingdetails.codeUnitSize == 1) {
            int j1;
            if(textencodingdetails.languageTable != 0 && textencodingdetails.languageShiftTable != 0)
                j1 = 7;
            else
            if(textencodingdetails.languageTable != 0 || textencodingdetails.languageShiftTable != 0)
                j1 = 4;
            else
                j1 = 0;
            if(textencodingdetails.msgCount > 1)
                j1 += 6;
            if(j1 != 0)
                j1++;
            j = 160 - j1;
        } else
        if(textencodingdetails.msgCount > 1)
            j = 134;
        else
            j = 140;
        k = 0;
        l = s.length();
        arraylist = new ArrayList(textencodingdetails.msgCount);
        do {
            int i1;
label0:
            {
                if(k < l) {
                    if(textencodingdetails.codeUnitSize == 1) {
                        if(i == 2 && textencodingdetails.msgCount == 1)
                            i1 = k + Math.min(j, l - k);
                        else
                            i1 = GsmAlphabet.findGsmSeptetLimitIndex(s, k, j, textencodingdetails.languageTable, textencodingdetails.languageShiftTable);
                    } else {
                        i1 = k + Math.min(j / 2, l - k);
                    }
                    if(i1 > k && i1 <= l)
                        break label0;
                    Log.e("SMS", (new StringBuilder()).append("fragmentText failed (").append(k).append(" >= ").append(i1).append(" or ").append(i1).append(" >= ").append(l).append(")").toString());
                }
                return arraylist;
            }
            arraylist.add(s.substring(k, i1));
            k = i1;
        } while(true);
    }

    public static SubmitPdu getSubmitPdu(String s, String s1, String s2, boolean flag) {
        Object obj;
        if(2 == TelephonyManager.getDefault().getCurrentPhoneType())
            obj = com.android.internal.telephony.cdma.SmsMessage.getSubmitPdu(s, s1, s2, flag, null);
        else
            obj = com.android.internal.telephony.gsm.SmsMessage.getSubmitPdu(s, s1, s2, flag);
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

    public static SmsMessage newFromCMT(String as[]) {
        return new SmsMessage(com.android.internal.telephony.gsm.SmsMessage.newFromCMT(as));
    }

    public static SmsMessage newFromParcel(Parcel parcel) {
        return new SmsMessage(com.android.internal.telephony.cdma.SmsMessage.newFromParcel(parcel));
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
        return mWrappedSmsMessage.getMessageClass();
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
    public static final int ENCODING_KSC5601 = 4;
    public static final int ENCODING_UNKNOWN = 0;
    public static final String FORMAT_3GPP = "3gpp";
    public static final String FORMAT_3GPP2 = "3gpp2";
    private static final String LOG_TAG = "SMS";
    public static final int MAX_USER_DATA_BYTES = 140;
    public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
    public static final int MAX_USER_DATA_SEPTETS = 160;
    public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
    public SmsMessageBase mWrappedSmsMessage;
}
