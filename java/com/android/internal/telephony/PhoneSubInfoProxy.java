// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.ServiceManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.android.internal.telephony:
//            PhoneSubInfo

public class PhoneSubInfoProxy extends IPhoneSubInfo.Stub {

    public PhoneSubInfoProxy(PhoneSubInfo phonesubinfo) {
        mPhoneSubInfo = phonesubinfo;
        if(ServiceManager.getService("iphonesubinfo") == null)
            ServiceManager.addService("iphonesubinfo", this);
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        mPhoneSubInfo.dump(filedescriptor, printwriter, as);
    }

    public String getCompleteVoiceMailNumber() {
        return mPhoneSubInfo.getCompleteVoiceMailNumber();
    }

    public String getDeviceId() {
        return mPhoneSubInfo.getDeviceId();
    }

    public String getDeviceSvn() {
        return mPhoneSubInfo.getDeviceSvn();
    }

    public String getIccSerialNumber() {
        return mPhoneSubInfo.getIccSerialNumber();
    }

    public String getIsimDomain() {
        return mPhoneSubInfo.getIsimDomain();
    }

    public String getIsimImpi() {
        return mPhoneSubInfo.getIsimImpi();
    }

    public String[] getIsimImpu() {
        return mPhoneSubInfo.getIsimImpu();
    }

    public String getLine1AlphaTag() {
        return mPhoneSubInfo.getLine1AlphaTag();
    }

    public String getLine1Number() {
        return mPhoneSubInfo.getLine1Number();
    }

    public String getMsisdn() {
        return mPhoneSubInfo.getMsisdn();
    }

    public String getSubscriberId() {
        return mPhoneSubInfo.getSubscriberId();
    }

    public String getVoiceMailAlphaTag() {
        return mPhoneSubInfo.getVoiceMailAlphaTag();
    }

    public String getVoiceMailNumber() {
        return mPhoneSubInfo.getVoiceMailNumber();
    }

    public void setmPhoneSubInfo(PhoneSubInfo phonesubinfo) {
        mPhoneSubInfo = phonesubinfo;
    }

    private PhoneSubInfo mPhoneSubInfo;
}
