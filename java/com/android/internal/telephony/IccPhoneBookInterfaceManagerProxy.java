// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.RemoteException;
import android.os.ServiceManager;
import java.util.List;

// Referenced classes of package com.android.internal.telephony:
//            IccPhoneBookInterfaceManager

public class IccPhoneBookInterfaceManagerProxy extends IIccPhoneBook.Stub {

    public IccPhoneBookInterfaceManagerProxy(IccPhoneBookInterfaceManager iccphonebookinterfacemanager) {
        mIccPhoneBookInterfaceManager = iccphonebookinterfacemanager;
        if(ServiceManager.getService("simphonebook") == null)
            ServiceManager.addService("simphonebook", this);
    }

    public int getAdnCapacity() {
        return mIccPhoneBookInterfaceManager.getAdnCapacity();
    }

    public List getAdnRecordsInEf(int i) throws RemoteException {
        return mIccPhoneBookInterfaceManager.getAdnRecordsInEf(i);
    }

    public int[] getAdnRecordsSize(int i) throws RemoteException {
        return mIccPhoneBookInterfaceManager.getAdnRecordsSize(i);
    }

    public int getFreeAdn() {
        return mIccPhoneBookInterfaceManager.getFreeAdn();
    }

    public void setmIccPhoneBookInterfaceManager(IccPhoneBookInterfaceManager iccphonebookinterfacemanager) {
        mIccPhoneBookInterfaceManager = iccphonebookinterfacemanager;
    }

    public boolean updateAdnRecordsInEfByIndex(int i, String s, String s1, int j, String s2) throws RemoteException {
        return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(i, s, s1, j, s2);
    }

    public boolean updateAdnRecordsInEfBySearch(int i, String s, String s1, String s2, String s3, String s4) throws RemoteException {
        return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(i, s, s1, s2, s3, s4);
    }

    private IccPhoneBookInterfaceManager mIccPhoneBookInterfaceManager;
}
