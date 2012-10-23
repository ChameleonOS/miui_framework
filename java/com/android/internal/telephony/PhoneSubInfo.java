// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.os.Binder;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import com.android.internal.telephony.ims.IsimRecords;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.android.internal.telephony:
//            Phone

public class PhoneSubInfo extends IPhoneSubInfo.Stub {

    public PhoneSubInfo(Phone phone) {
        mPhone = phone;
        mContext = phone.getContext();
    }

    public void dispose() {
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        if(mContext.checkCallingOrSelfPermission("android.permission.DUMP") != 0) {
            printwriter.println((new StringBuilder()).append("Permission Denial: can't dump PhoneSubInfo from from pid=").append(Binder.getCallingPid()).append(", uid=").append(Binder.getCallingUid()).toString());
        } else {
            printwriter.println("Phone Subscriber Info:");
            printwriter.println((new StringBuilder()).append("  Phone Type = ").append(mPhone.getPhoneName()).toString());
            printwriter.println((new StringBuilder()).append("  Device ID = ").append(mPhone.getDeviceId()).toString());
        }
    }

    protected void finalize() {
        try {
            super.finalize();
        }
        catch(Throwable throwable) {
            Log.e("PHONE", "Error while finalizing:", throwable);
        }
        Log.d("PHONE", "PhoneSubInfo finalized");
    }

    public String getCompleteVoiceMailNumber() {
        mContext.enforceCallingOrSelfPermission("android.permission.CALL_PRIVILEGED", "Requires CALL_PRIVILEGED");
        String s = mPhone.getVoiceMailNumber();
        Log.d("PHONE", "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
        return s;
    }

    public String getDeviceId() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        return mPhone.getDeviceId();
    }

    public String getDeviceSvn() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        return mPhone.getDeviceSvn();
    }

    public String getIccSerialNumber() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        return mPhone.getIccSerialNumber();
    }

    public String getIsimDomain() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isimrecords = mPhone.getIsimRecords();
        String s;
        if(isimrecords != null)
            s = isimrecords.getIsimDomain();
        else
            s = null;
        return s;
    }

    public String getIsimImpi() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isimrecords = mPhone.getIsimRecords();
        String s;
        if(isimrecords != null)
            s = isimrecords.getIsimImpi();
        else
            s = null;
        return s;
    }

    public String[] getIsimImpu() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isimrecords = mPhone.getIsimRecords();
        String as[];
        if(isimrecords != null)
            as = isimrecords.getIsimImpu();
        else
            as = null;
        return as;
    }

    public String getLine1AlphaTag() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        return mPhone.getLine1AlphaTag();
    }

    public String getLine1Number() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        return mPhone.getLine1Number();
    }

    public String getMsisdn() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        return mPhone.getMsisdn();
    }

    public String getSubscriberId() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        return mPhone.getSubscriberId();
    }

    public String getVoiceMailAlphaTag() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        return mPhone.getVoiceMailAlphaTag();
    }

    public String getVoiceMailNumber() {
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", "Requires READ_PHONE_STATE");
        String s = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        Log.d("PHONE", "VM: PhoneSubInfo.getVoiceMailNUmber: ");
        return s;
    }

    private static final String CALL_PRIVILEGED = "android.permission.CALL_PRIVILEGED";
    static final String LOG_TAG = "PHONE";
    private static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    private static final String READ_PRIVILEGED_PHONE_STATE = "android.permission.READ_PRIVILEGED_PHONE_STATE";
    private Context mContext;
    private Phone mPhone;
}
