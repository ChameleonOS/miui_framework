// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.android.internal.util.HexDump;
import java.util.*;

// Referenced classes of package com.android.internal.telephony:
//            PhoneBase, SmsRawData, SMSDispatcher

public abstract class IccSmsInterfaceManager extends ISms.Stub {

    protected IccSmsInterfaceManager(PhoneBase phonebase) {
        mPhone = phonebase;
        mContext = phonebase.getContext();
    }

    protected ArrayList buildValidRawData(ArrayList arraylist) {
        int i = arraylist.size();
        ArrayList arraylist1 = new ArrayList(i);
        int j = 0;
        while(j < i)  {
            if(((byte[])arraylist.get(j))[0] == 0)
                arraylist1.add(null);
            else
                arraylist1.add(new SmsRawData((byte[])arraylist.get(j)));
            j++;
        }
        return arraylist1;
    }

    protected void enforceReceiveAndSend(String s) {
        mContext.enforceCallingPermission("android.permission.RECEIVE_SMS", s);
        mContext.enforceCallingPermission("android.permission.SEND_SMS", s);
    }

    protected abstract void log(String s);

    protected byte[] makeSmsRecordData(int i, byte abyte0[]) {
        byte abyte1[] = new byte[176];
        abyte1[0] = (byte)(i & 7);
        System.arraycopy(abyte0, 0, abyte1, 1, abyte0.length);
        for(int j = 1 + abyte0.length; j < 176; j++)
            abyte1[j] = -1;

        return abyte1;
    }

    public void sendData(String s, String s1, int i, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1) {
        mPhone.getContext().enforceCallingPermission("android.permission.SEND_SMS", "Sending SMS message");
        if(Log.isLoggable("SMS", 2))
            log((new StringBuilder()).append("sendData: destAddr=").append(s).append(" scAddr=").append(s1).append(" destPort=").append(i).append(" data='").append(HexDump.toHexString(abyte0)).append("' sentIntent=").append(pendingintent).append(" deliveryIntent=").append(pendingintent1).toString());
        mDispatcher.sendData(s, s1, i, abyte0, pendingintent, pendingintent1);
    }

    public void sendMultipartText(String s, String s1, List list, List list1, List list2) {
        mPhone.getContext().enforceCallingPermission("android.permission.SEND_SMS", "Sending SMS message");
        if(Log.isLoggable("SMS", 2)) {
            int i = 0;
            for(Iterator iterator = list.iterator(); iterator.hasNext();) {
                String s2 = (String)iterator.next();
                StringBuilder stringbuilder = (new StringBuilder()).append("sendMultipartText: destAddr=").append(s).append(", srAddr=").append(s1).append(", part[");
                int j = i + 1;
                log(stringbuilder.append(i).append("]=").append(s2).toString());
                i = j;
            }

        }
        mDispatcher.sendMultipartText(s, s1, (ArrayList)list, (ArrayList)list1, (ArrayList)list2);
    }

    public void sendText(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1) {
        mPhone.getContext().enforceCallingPermission("android.permission.SEND_SMS", "Sending SMS message");
        if(Log.isLoggable("SMS", 2))
            log((new StringBuilder()).append("sendText: destAddr=").append(s).append(" scAddr=").append(s1).append(" text='").append(s2).append("' sentIntent=").append(pendingintent).append(" deliveryIntent=").append(pendingintent1).toString());
        mDispatcher.sendText(s, s1, s2, pendingintent, pendingintent1);
    }

    protected Context mContext;
    protected SMSDispatcher mDispatcher;
    protected PhoneBase mPhone;
}
