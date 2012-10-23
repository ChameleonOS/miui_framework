// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.os.ServiceManager;
import java.util.List;

// Referenced classes of package com.android.internal.telephony:
//            IccSmsInterfaceManager

public class IccSmsInterfaceManagerProxy extends ISms.Stub {

    public IccSmsInterfaceManagerProxy(IccSmsInterfaceManager iccsmsinterfacemanager) {
        mIccSmsInterfaceManager = iccsmsinterfacemanager;
        if(ServiceManager.getService("isms") == null)
            ServiceManager.addService("isms", this);
    }

    public boolean copyMessageToIccEf(int i, byte abyte0[], byte abyte1[]) throws RemoteException {
        return mIccSmsInterfaceManager.copyMessageToIccEf(i, abyte0, abyte1);
    }

    public boolean disableCellBroadcast(int i) throws RemoteException {
        return mIccSmsInterfaceManager.disableCellBroadcast(i);
    }

    public boolean disableCellBroadcastRange(int i, int j) throws RemoteException {
        return mIccSmsInterfaceManager.disableCellBroadcastRange(i, j);
    }

    public boolean enableCellBroadcast(int i) throws RemoteException {
        return mIccSmsInterfaceManager.enableCellBroadcast(i);
    }

    public boolean enableCellBroadcastRange(int i, int j) throws RemoteException {
        return mIccSmsInterfaceManager.enableCellBroadcastRange(i, j);
    }

    public List getAllMessagesFromIccEf() throws RemoteException {
        return mIccSmsInterfaceManager.getAllMessagesFromIccEf();
    }

    public void sendData(String s, String s1, int i, byte abyte0[], PendingIntent pendingintent, PendingIntent pendingintent1) {
        mIccSmsInterfaceManager.sendData(s, s1, i, abyte0, pendingintent, pendingintent1);
    }

    public void sendMultipartText(String s, String s1, List list, List list1, List list2) throws RemoteException {
        mIccSmsInterfaceManager.sendMultipartText(s, s1, list, list1, list2);
    }

    public void sendText(String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1) {
        mIccSmsInterfaceManager.sendText(s, s1, s2, pendingintent, pendingintent1);
    }

    public void setmIccSmsInterfaceManager(IccSmsInterfaceManager iccsmsinterfacemanager) {
        mIccSmsInterfaceManager = iccsmsinterfacemanager;
    }

    public boolean updateMessageOnIccEf(int i, int j, byte abyte0[]) throws RemoteException {
        return mIccSmsInterfaceManager.updateMessageOnIccEf(i, j, abyte0);
    }

    private IccSmsInterfaceManager mIccSmsInterfaceManager;
}
