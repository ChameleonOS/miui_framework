// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.os.*;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.cat.ComprehensionTlvTag;

// Referenced classes of package com.android.internal.telephony.gsm:
//            SmsMessage

public class UsimDataDownloadHandler extends Handler {

    public UsimDataDownloadHandler(CommandsInterface commandsinterface) {
        mCI = commandsinterface;
    }

    private void acknowledgeSmsWithError(int i) {
        mCI.acknowledgeLastIncomingGsmSms(false, i, null);
    }

    private static int getEnvelopeBodyLength(int i, int j) {
        int k = j + 5;
        byte byte0;
        int l;
        if(j > 127)
            byte0 = 2;
        else
            byte0 = 1;
        l = k + byte0;
        if(i != 0)
            l = i + (l + 2);
        return l;
    }

    private void handleDataDownload(SmsMessage smsmessage) {
        int i = smsmessage.getDataCodingScheme();
        int j = smsmessage.getProtocolIdentifier();
        byte abyte0[] = smsmessage.getPdu();
        int k = 0xff & abyte0[0];
        int l = k + 1;
        int i1 = abyte0.length - l;
        int j1 = getEnvelopeBodyLength(k, i1);
        int k1 = j1 + 1;
        byte byte0;
        byte abyte1[];
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        if(j1 > 127)
            byte0 = 2;
        else
            byte0 = 1;
        abyte1 = new byte[k1 + byte0];
        l1 = 0 + 1;
        abyte1[0] = -47;
        if(j1 > 127) {
            i2 = l1 + 1;
            abyte1[l1] = -127;
        } else {
            i2 = l1;
        }
        j2 = i2 + 1;
        abyte1[i2] = (byte)j1;
        k2 = j2 + 1;
        abyte1[j2] = (byte)(0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value());
        l2 = k2 + 1;
        abyte1[k2] = 2;
        i3 = l2 + 1;
        abyte1[l2] = -125;
        j3 = i3 + 1;
        abyte1[i3] = -127;
        if(k != 0) {
            int k4 = j3 + 1;
            abyte1[j3] = (byte)ComprehensionTlvTag.ADDRESS.value();
            int l4 = k4 + 1;
            abyte1[k4] = (byte)k;
            System.arraycopy(abyte0, 1, abyte1, l4, k);
            k3 = l4 + k;
        } else {
            k3 = j3;
        }
        l3 = k3 + 1;
        abyte1[k3] = (byte)(0x80 | ComprehensionTlvTag.SMS_TPDU.value());
        if(i1 > 127) {
            i4 = l3 + 1;
            abyte1[l3] = -127;
        } else {
            i4 = l3;
        }
        j4 = i4 + 1;
        abyte1[i4] = (byte)i1;
        System.arraycopy(abyte0, l, abyte1, j4, i1);
        if(j4 + i1 != abyte1.length) {
            Log.e("UsimDataDownloadHandler", "startDataDownload() calculated incorrect envelope length, aborting.");
            acknowledgeSmsWithError(255);
        } else {
            String s = IccUtils.bytesToHexString(abyte1);
            CommandsInterface commandsinterface = mCI;
            int ai[] = new int[2];
            ai[0] = i;
            ai[1] = j;
            commandsinterface.sendEnvelopeWithStatus(s, obtainMessage(2, ai));
        }
    }

    private static boolean is7bitDcs(int i) {
        boolean flag;
        if((i & 0x8c) == 0 || (i & 0xf4) == 240)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void sendSmsAckForEnvelopeResponse(IccIoResult iccioresult, int i, int j) {
        int k;
        int l;
        k = iccioresult.sw1;
        l = iccioresult.sw2;
        if((k != 144 || l != 0) && k != 145) goto _L2; else goto _L1
_L1:
        boolean flag;
        Log.d("UsimDataDownloadHandler", (new StringBuilder()).append("USIM data download succeeded: ").append(iccioresult.toString()).toString());
        flag = true;
_L5:
        byte abyte0[] = iccioresult.payload;
        if(abyte0 == null || abyte0.length == 0) {
            if(flag)
                mCI.acknowledgeLastIncomingGsmSms(true, 0, null);
            else
                acknowledgeSmsWithError(213);
        } else {
            byte abyte1[];
            int l1;
            int i2;
            int j2;
            int l2;
            if(flag) {
                abyte1 = new byte[5 + abyte0.length];
                int k3 = 0 + 1;
                abyte1[0] = 0;
                l1 = k3 + 1;
                abyte1[k3] = 7;
            } else {
                abyte1 = new byte[6 + abyte0.length];
                int i1 = 0 + 1;
                abyte1[0] = 0;
                int j1 = i1 + 1;
                abyte1[i1] = -43;
                int k1 = j1 + 1;
                abyte1[j1] = 7;
                l1 = k1;
            }
            i2 = l1 + 1;
            abyte1[l1] = (byte)j;
            j2 = i2 + 1;
            abyte1[i2] = (byte)i;
            if(is7bitDcs(i)) {
                int i3 = (8 * abyte0.length) / 7;
                int j3 = j2 + 1;
                abyte1[j2] = (byte)i3;
                l2 = j3;
            } else {
                int k2 = j2 + 1;
                abyte1[j2] = (byte)abyte0.length;
                l2 = k2;
            }
            System.arraycopy(abyte0, 0, abyte1, l2, abyte0.length);
            mCI.acknowledgeIncomingGsmSmsWithPdu(flag, IccUtils.bytesToHexString(abyte1), null);
        }
_L4:
        return;
_L2:
        if(k != 147 || l != 0)
            break; /* Loop/switch isn't completed */
        Log.e("UsimDataDownloadHandler", "USIM data download failed: Toolkit busy");
        acknowledgeSmsWithError(212);
        if(true) goto _L4; else goto _L3
_L3:
        if(k == 98 || k == 99) {
            Log.e("UsimDataDownloadHandler", (new StringBuilder()).append("USIM data download failed: ").append(iccioresult.toString()).toString());
            flag = false;
        } else {
            Log.e("UsimDataDownloadHandler", (new StringBuilder()).append("Unexpected SW1/SW2 response from UICC: ").append(iccioresult.toString()).toString());
            flag = false;
        }
          goto _L5
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 57
    //                   2 71;
           goto _L1 _L2 _L3
_L1:
        Log.e("UsimDataDownloadHandler", (new StringBuilder()).append("Ignoring unexpected message, what=").append(message.what).toString());
_L5:
        return;
_L2:
        handleDataDownload((SmsMessage)message.obj);
        continue; /* Loop/switch isn't completed */
_L3:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception != null) {
            Log.e("UsimDataDownloadHandler", (new StringBuilder()).append("UICC Send Envelope failure, exception: ").append(asyncresult.exception).toString());
            acknowledgeSmsWithError(213);
        } else {
            int ai[] = (int[])(int[])asyncresult.userObj;
            sendSmsAckForEnvelopeResponse((IccIoResult)asyncresult.result, ai[0], ai[1]);
        }
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int startDataDownload(SmsMessage smsmessage) {
        byte byte0;
        if(sendMessage(obtainMessage(1, smsmessage))) {
            byte0 = -1;
        } else {
            Log.e("UsimDataDownloadHandler", "startDataDownload failed to send message to start data download.");
            byte0 = 2;
        }
        return byte0;
    }

    private static final int BER_SMS_PP_DOWNLOAD_TAG = 209;
    private static final int DEV_ID_NETWORK = 131;
    private static final int DEV_ID_UICC = 129;
    private static final int EVENT_SEND_ENVELOPE_RESPONSE = 2;
    private static final int EVENT_START_DATA_DOWNLOAD = 1;
    private static final String TAG = "UsimDataDownloadHandler";
    private final CommandsInterface mCI;
}
