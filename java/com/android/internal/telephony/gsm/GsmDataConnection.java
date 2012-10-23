// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.os.Message;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.android.internal.telephony.*;
import com.android.internal.util.IState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GsmDataConnection extends DataConnection {

    private GsmDataConnection(PhoneBase phonebase, String s, int i, RetryManager retrymanager, DataConnectionTracker dataconnectiontracker) {
        super(phonebase, s, i, retrymanager, dataconnectiontracker);
        mProfileId = 0;
    }

    private boolean isIpAddress(String s) {
        boolean flag;
        if(s == null)
            flag = false;
        else
            flag = Patterns.IP_ADDRESS.matcher(s).matches();
        return flag;
    }

    static GsmDataConnection makeDataConnection(PhoneBase phonebase, int i, RetryManager retrymanager, DataConnectionTracker dataconnectiontracker) {
        synchronized(mCountLock) {
            mCount = 1 + mCount;
        }
        GsmDataConnection gsmdataconnection = new GsmDataConnection(phonebase, (new StringBuilder()).append("GsmDC-").append(mCount).toString(), i, retrymanager, dataconnectiontracker);
        gsmdataconnection.start();
        gsmdataconnection.log((new StringBuilder()).append("Made ").append(gsmdataconnection.getName()).toString());
        return gsmdataconnection;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("GsmDataConnection extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" mProfileId=").append(mProfileId).toString());
    }

    public int getProfileId() {
        return mProfileId;
    }

    protected boolean isDnsOk(String as[]) {
        boolean flag = false;
        if("0.0.0.0".equals(as[0]) && "0.0.0.0".equals(as[1]) && !super.phone.isDnsCheckDisabled() && (!super.mApn.types[0].equals("mms") || !isIpAddress(super.mApn.mmsProxy))) {
            Object aobj[] = new Object[4];
            aobj[flag] = super.mApn.types[0];
            aobj[1] = "mms";
            aobj[2] = super.mApn.mmsProxy;
            aobj[3] = Boolean.valueOf(isIpAddress(super.mApn.mmsProxy));
            log(String.format("isDnsOk: return false apn.types[0]=%s APN_TYPE_MMS=%s isIpAddress(%s)=%s", aobj));
        } else {
            flag = true;
        }
        return flag;
    }

    protected void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[").append(getName()).append("] ").append(s).toString());
    }

    protected void onConnect(com.android.internal.telephony.DataConnection.ConnectionParams connectionparams) {
        super.mApn = connectionparams.apn;
        log((new StringBuilder()).append("Connecting to carrier: '").append(super.mApn.carrier).append("' APN: '").append(super.mApn.apn).append("' proxy: '").append(super.mApn.proxy).append("' port: '").append(super.mApn.port).toString());
        super.createTime = -1L;
        super.lastFailTime = -1L;
        super.lastFailCause = com.android.internal.telephony.DataConnection.FailCause.NONE;
        Message message = obtainMessage(0x40001, connectionparams);
        message.obj = connectionparams;
        int i = super.mApn.authType;
        String s;
        if(i == -1)
            if(TextUtils.isEmpty(super.mApn.user))
                i = 0;
            else
                i = 3;
        if(super.phone.getServiceState().getRoaming())
            s = super.mApn.roamingProtocol;
        else
            s = super.mApn.protocol;
        super.phone.mCM.setupDataCall(Integer.toString(getRilRadioTechnology(1)), Integer.toString(mProfileId), super.mApn.apn, super.mApn.user, super.mApn.password, Integer.toString(i), s, message);
    }

    public void setProfileId(int i) {
        mProfileId = i;
    }

    public String toString() {
        return (new StringBuilder()).append("{").append(getName()).append(": State=").append(getCurrentState().getName()).append(" apnSetting=").append(super.mApn).append(" apnList= ").append(super.mApnList).append(" RefCount=").append(super.mRefCount).append(" cid=").append(super.cid).append(" create=").append(super.createTime).append(" lastFail=").append(super.lastFailTime).append(" lastFailCause=").append(super.lastFailCause).append("}").toString();
    }

    private static final String LOG_TAG = "GSM";
    protected int mProfileId;
}
