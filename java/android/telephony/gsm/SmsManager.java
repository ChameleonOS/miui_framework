// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony.gsm;

import android.app.PendingIntent;
import java.util.ArrayList;

public final class SmsManager {

    private SmsManager() {
        mSmsMgrProxy = android.telephony.SmsManager.getDefault();
    }

    public static final SmsManager getDefault() {
        if(sInstance == null)
            sInstance = new SmsManager();
        return sInstance;
    }

    public final boolean copyMessageToSim(byte abyte0[], byte abyte1[], int i) {
        return mSmsMgrProxy.copyMessageToIcc(abyte0, abyte1, i);
    }

    public final boolean deleteMessageFromSim(int i) {
        return mSmsMgrProxy.deleteMessageFromIcc(i);
    }

    public final ArrayList divideMessage(String s) {
        return mSmsMgrProxy.divideMessage(s);
    }

    public final ArrayList getAllMessagesFromSim() {
        android.telephony.SmsManager _tmp = mSmsMgrProxy;
        return android.telephony.SmsManager.getAllMessagesFromIcc();
    }

    public final void sendDataMessage(String s, String s1, short word0, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1) {
        mSmsMgrProxy.sendDataMessage(s, s1, word0, abyte0, pendingintent, pendingintent1);
    }

    public final void sendMultipartTextMessage(String s, String s1, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2) {
        mSmsMgrProxy.sendMultipartTextMessage(s, s1, arraylist, arraylist1, arraylist2);
    }

    public final void sendTextMessage(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1) {
        mSmsMgrProxy.sendTextMessage(s, s1, s2, pendingintent, pendingintent1);
    }

    public final boolean updateMessageOnSim(int i, int j, byte abyte0[]) {
        return mSmsMgrProxy.updateMessageOnIcc(i, j, abyte0);
    }

    public static final int RESULT_ERROR_GENERIC_FAILURE = 1;
    public static final int RESULT_ERROR_NO_SERVICE = 4;
    public static final int RESULT_ERROR_NULL_PDU = 3;
    public static final int RESULT_ERROR_RADIO_OFF = 2;
    public static final int STATUS_ON_SIM_FREE = 0;
    public static final int STATUS_ON_SIM_READ = 1;
    public static final int STATUS_ON_SIM_SENT = 5;
    public static final int STATUS_ON_SIM_UNREAD = 3;
    public static final int STATUS_ON_SIM_UNSENT = 7;
    private static SmsManager sInstance;
    private android.telephony.SmsManager mSmsMgrProxy;
}
