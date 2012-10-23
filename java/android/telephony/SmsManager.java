// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import com.android.internal.telephony.ISms;
import com.android.internal.telephony.SmsRawData;
import java.util.*;

// Referenced classes of package android.telephony:
//            SmsMessage

public final class SmsManager {

    private SmsManager() {
    }

    private static ArrayList createMessageListFromRawRecords(List list) {
        ArrayList arraylist = new ArrayList();
        if(list != null) {
            int i = list.size();
            for(int j = 0; j < i; j++) {
                SmsRawData smsrawdata = (SmsRawData)list.get(j);
                if(smsrawdata == null)
                    continue;
                SmsMessage smsmessage = SmsMessage.createFromEfRecord(j + 1, smsrawdata.getBytes());
                if(smsmessage != null)
                    arraylist.add(smsmessage);
            }

        }
        return arraylist;
    }

    public static ArrayList getAllMessagesFromIcc() {
        List list = null;
        List list1;
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms == null)
            break MISSING_BLOCK_LABEL_24;
        list1 = isms.getAllMessagesFromIccEf();
        list = list1;
_L2:
        return createMessageListFromRawRecords(list);
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static SmsManager getDefault() {
        return sInstance;
    }

    public boolean copyMessageToIcc(byte abyte0[], byte abyte1[], int i) {
        boolean flag = false;
        boolean flag1;
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms == null)
            break MISSING_BLOCK_LABEL_34;
        flag1 = isms.copyMessageToIccEf(i, abyte1, abyte0);
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean deleteMessageFromIcc(int i) {
        boolean flag;
        byte abyte0[];
        flag = false;
        abyte0 = new byte[175];
        Arrays.fill(abyte0, (byte)-1);
        boolean flag1;
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms == null)
            break MISSING_BLOCK_LABEL_44;
        flag1 = isms.updateMessageOnIccEf(i, 0, abyte0);
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean disableCellBroadcast(int i) {
        boolean flag = false;
        boolean flag1;
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms == null)
            break MISSING_BLOCK_LABEL_30;
        flag1 = isms.disableCellBroadcast(i);
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean disableCellBroadcastRange(int i, int j) {
        boolean flag = false;
        boolean flag1;
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms == null)
            break MISSING_BLOCK_LABEL_31;
        flag1 = isms.disableCellBroadcastRange(i, j);
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public ArrayList divideMessage(String s) {
        return SmsMessage.fragmentText(s);
    }

    public boolean enableCellBroadcast(int i) {
        boolean flag = false;
        boolean flag1;
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms == null)
            break MISSING_BLOCK_LABEL_30;
        flag1 = isms.enableCellBroadcast(i);
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean enableCellBroadcastRange(int i, int j) {
        boolean flag = false;
        boolean flag1;
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms == null)
            break MISSING_BLOCK_LABEL_31;
        flag1 = isms.enableCellBroadcastRange(i, j);
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void sendDataMessage(String s, String s1, short word0, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1) {
        if(TextUtils.isEmpty(s))
            throw new IllegalArgumentException("Invalid destinationAddress");
        if(abyte0 == null || abyte0.length == 0)
            throw new IllegalArgumentException("Invalid message data");
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms != null)
            isms.sendData(s, s1, word0 & 0xffff, abyte0, pendingintent, pendingintent1);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void sendMultipartTextMessage(String s, String s1, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2) {
        if(TextUtils.isEmpty(s))
            throw new IllegalArgumentException("Invalid destinationAddress");
        if(arraylist == null || arraylist.size() < 1)
            throw new IllegalArgumentException("Invalid message body");
        if(arraylist.size() <= 1) goto _L2; else goto _L1
_L1:
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms != null)
            isms.sendMultipartText(s, s1, arraylist, arraylist1, arraylist2);
_L4:
        return;
_L2:
        PendingIntent pendingintent = null;
        PendingIntent pendingintent1 = null;
        if(arraylist1 != null && arraylist1.size() > 0)
            pendingintent = (PendingIntent)arraylist1.get(0);
        if(arraylist2 != null && arraylist2.size() > 0)
            pendingintent1 = (PendingIntent)arraylist2.get(0);
        sendTextMessage(s, s1, (String)arraylist.get(0), pendingintent, pendingintent1);
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void sendTextMessage(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1) {
        if(TextUtils.isEmpty(s))
            throw new IllegalArgumentException("Invalid destinationAddress");
        if(TextUtils.isEmpty(s2))
            throw new IllegalArgumentException("Invalid message body");
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms != null)
            isms.sendText(s, s1, s2, pendingintent, pendingintent1);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean updateMessageOnIcc(int i, int j, byte abyte0[]) {
        boolean flag = false;
        boolean flag1;
        ISms isms = com.android.internal.telephony.ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if(isms == null)
            break MISSING_BLOCK_LABEL_34;
        flag1 = isms.updateMessageOnIccEf(i, j, abyte0);
        flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final int RESULT_ERROR_FDN_CHECK_FAILURE = 6;
    public static final int RESULT_ERROR_GENERIC_FAILURE = 1;
    public static final int RESULT_ERROR_LIMIT_EXCEEDED = 5;
    public static final int RESULT_ERROR_NO_SERVICE = 4;
    public static final int RESULT_ERROR_NULL_PDU = 3;
    public static final int RESULT_ERROR_RADIO_OFF = 2;
    public static final int STATUS_ON_ICC_FREE = 0;
    public static final int STATUS_ON_ICC_READ = 1;
    public static final int STATUS_ON_ICC_SENT = 5;
    public static final int STATUS_ON_ICC_UNREAD = 3;
    public static final int STATUS_ON_ICC_UNSENT = 7;
    private static final SmsManager sInstance = new SmsManager();

}
