// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.Context;
import android.os.*;
import android.util.Log;
import com.android.internal.telephony.*;

public final class RuimRecords extends IccRecords {

    public RuimRecords(IccCard icccard, Context context, CommandsInterface commandsinterface) {
        super(icccard, context, commandsinterface);
        m_ota_commited = false;
        super.adnCache = new AdnRecordCache(super.mFh);
        super.recordsRequested = false;
        super.recordsToLoad = 0;
        super.mCi.registerForOffOrNotAvailable(this, 2, null);
        super.mCi.registerForIccRefresh(this, 31, null);
        onRadioOffOrNotAvailable();
    }

    private void fetchRuimRecords() {
        super.recordsRequested = true;
        Log.v("CDMA", (new StringBuilder()).append("RuimRecords:fetchRuimRecords ").append(super.recordsToLoad).toString());
        super.mCi.getIMSI(obtainMessage(3));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(12258, obtainMessage(5));
        super.recordsToLoad = 1 + super.recordsToLoad;
        log((new StringBuilder()).append("RuimRecords:fetchRuimRecords ").append(super.recordsToLoad).append(" requested: ").append(super.recordsRequested).toString());
    }

    private void handleRuimRefresh(IccRefreshResponse iccrefreshresponse) {
        if(iccrefreshresponse != null) goto _L2; else goto _L1
_L1:
        log("handleRuimRefresh received without input");
_L4:
        return;
_L2:
        if(iccrefreshresponse.aid != null && !iccrefreshresponse.aid.equals(super.mParentCard.getAid())) goto _L4; else goto _L3
_L3:
        switch(iccrefreshresponse.refreshResult) {
        default:
            log("handleRuimRefresh with unknown operation");
            break;

        case 0: // '\0'
            log("handleRuimRefresh with SIM_REFRESH_FILE_UPDATED");
            super.adnCache.reset();
            fetchRuimRecords();
            break;

        case 1: // '\001'
            log("handleRuimRefresh with SIM_REFRESH_INIT");
            fetchRuimRecords();
            break;

        case 2: // '\002'
            log("handleRuimRefresh with SIM_REFRESH_RESET");
            super.mCi.setRadioPower(false, null);
            break;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public void dispose() {
        log((new StringBuilder()).append("Disposing RuimRecords ").append(this).toString());
        super.mCi.unregisterForOffOrNotAvailable(this);
        super.mCi.unregisterForIccRefresh(this);
        super.dispose();
    }

    protected void finalize() {
        log("RuimRecords finalized");
    }

    public String getCdmaMin() {
        return mMin2Min1;
    }

    public int getDisplayRule(String s) {
        return 0;
    }

    public String getMdnNumber() {
        return mMyMobileNumber;
    }

    public String getPrlVersion() {
        return mPrlVersion;
    }

    public String getRUIMOperatorNumeric() {
        String s;
        if(mImsi == null)
            s = null;
        else
        if(super.mncLength != -1 && super.mncLength != 0) {
            s = mImsi.substring(0, 3 + super.mncLength);
        } else {
            int i = Integer.parseInt(mImsi.substring(0, 3));
            s = mImsi.substring(0, 3 + MccTable.smallestDigitsMccForMnc(i));
        }
        return s;
    }

    public void handleMessage(Message message) {
        boolean flag = false;
        if(!super.mDestroyed) goto _L2; else goto _L1
_L1:
        loge((new StringBuilder()).append("Received message ").append(message).append("[").append(message.what).append("] while being destroyed. Ignoring.").toString());
_L14:
        return;
_L2:
        int i = message.what;
        i;
        JVM INSTR lookupswitch 12: default 164
    //                   2: 175
    //                   3: 221
    //                   4: 201
    //                   5: 515
    //                   10: 418
    //                   14: 590
    //                   17: 656
    //                   18: 624
    //                   19: 624
    //                   21: 624
    //                   22: 624
    //                   31: 666;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L11 _L11 _L11 _L12
_L3:
        if(!flag) goto _L14; else goto _L13
_L13:
        onRecordLoaded();
        break; /* Loop/switch isn't completed */
_L4:
        onRadioOffOrNotAvailable();
          goto _L3
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("CDMA", "Exception parsing RUIM record", runtimeexception);
        if(!flag) goto _L14; else goto _L13
_L6:
        log("Event EVENT_GET_DEVICE_IDENTITY_DONE Received");
          goto _L3
        Exception exception;
        exception;
        if(flag)
            onRecordLoaded();
        throw exception;
_L5:
        flag = true;
        AsyncResult asyncresult4 = (AsyncResult)message.obj;
        if(asyncresult4.exception != null) {
            loge((new StringBuilder()).append("Exception querying IMSI, Exception:").append(asyncresult4.exception).toString());
        } else {
            mImsi = (String)asyncresult4.result;
            if(mImsi != null && (mImsi.length() < 6 || mImsi.length() > 15)) {
                loge((new StringBuilder()).append("invalid IMSI ").append(mImsi).toString());
                mImsi = null;
            }
            log((new StringBuilder()).append("IMSI: ").append(mImsi.substring(0, 6)).append("xxxxxxxxx").toString());
            String s = getRUIMOperatorNumeric();
            if(s != null && s.length() <= 6)
                MccTable.updateMccMncConfiguration(super.mContext, s);
        }
          goto _L3
_L8:
        AsyncResult asyncresult3 = (AsyncResult)message.obj;
        String as[] = (String[])(String[])asyncresult3.result;
        if(asyncresult3.exception == null) {
            mMyMobileNumber = as[0];
            mMin2Min1 = as[3];
            mPrlVersion = as[4];
            log((new StringBuilder()).append("MDN: ").append(mMyMobileNumber).append(" MIN: ").append(mMin2Min1).toString());
        }
          goto _L3
_L7:
        flag = true;
        AsyncResult asyncresult2 = (AsyncResult)message.obj;
        byte abyte0[] = (byte[])(byte[])asyncresult2.result;
        if(asyncresult2.exception == null) {
            super.iccid = IccUtils.bcdToString(abyte0, 0, abyte0.length);
            log((new StringBuilder()).append("iccid: ").append(super.iccid).toString());
        }
          goto _L3
_L9:
        AsyncResult asyncresult1 = (AsyncResult)message.obj;
        if(asyncresult1.exception != null)
            Log.i("CDMA", "RuimRecords update failed", asyncresult1.exception);
          goto _L3
_L11:
        Log.w("CDMA", (new StringBuilder()).append("Event not supported: ").append(message.what).toString());
          goto _L3
_L10:
        log("Event EVENT_GET_SST_DONE Received");
          goto _L3
_L12:
        flag = false;
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception == null)
            handleRuimRefresh((IccRefreshResponse)asyncresult.result);
          goto _L3
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[RuimRecords] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("CDMA", (new StringBuilder()).append("[RuimRecords] ").append(s).toString());
    }

    protected void onAllRecordsLoaded() {
        String s = getRUIMOperatorNumeric();
        log((new StringBuilder()).append("RuimRecords: onAllRecordsLoaded set 'gsm.sim.operator.numeric' to operator='").append(s).append("'").toString());
        SystemProperties.set("gsm.sim.operator.numeric", s);
        if(mImsi != null)
            SystemProperties.set("gsm.sim.operator.iso-country", MccTable.countryCodeForMcc(Integer.parseInt(mImsi.substring(0, 3))));
        super.recordsLoadedRegistrants.notifyRegistrants(new AsyncResult(null, null, null));
        super.mParentCard.broadcastIccStateChangedIntent("LOADED", null);
    }

    protected void onRadioOffOrNotAvailable() {
        super.countVoiceMessages = 0;
        super.mncLength = -1;
        super.iccid = null;
        super.adnCache.reset();
        super.recordsRequested = false;
    }

    public void onReady() {
        super.mParentCard.broadcastIccStateChangedIntent("READY", null);
        fetchRuimRecords();
        super.mCi.getCDMASubscription(obtainMessage(10));
    }

    protected void onRecordLoaded() {
        super.recordsToLoad = -1 + super.recordsToLoad;
        log((new StringBuilder()).append("RuimRecords:onRecordLoaded ").append(super.recordsToLoad).append(" requested: ").append(super.recordsRequested).toString());
        if(super.recordsToLoad != 0 || !super.recordsRequested) goto _L2; else goto _L1
_L1:
        onAllRecordsLoaded();
_L4:
        return;
_L2:
        if(super.recordsToLoad < 0) {
            loge("RuimRecords: recordsToLoad <0, programmer error suspected");
            super.recordsToLoad = 0;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onRefresh(boolean flag, int ai[]) {
        if(flag)
            fetchRuimRecords();
    }

    public void setVoiceMailNumber(String s, String s1, Message message) {
        AsyncResult.forMessage(message).exception = new IccException("setVoiceMailNumber not implemented");
        message.sendToTarget();
        loge("method setVoiceMailNumber is not implemented");
    }

    public void setVoiceMessageWaiting(int i, int j) {
        if(i == 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(j >= 0)
            break; /* Loop/switch isn't completed */
        j = -1;
_L5:
        super.countVoiceMessages = j;
        super.mRecordsEventsRegistrants.notifyResult(Integer.valueOf(0));
        if(true) goto _L1; else goto _L3
_L3:
        if(j <= 255) goto _L5; else goto _L4
_L4:
        j = 255;
          goto _L5
    }

    private static final boolean DBG = true;
    private static final int EVENT_GET_ALL_SMS_DONE = 18;
    private static final int EVENT_GET_CDMA_SUBSCRIPTION_DONE = 10;
    private static final int EVENT_GET_DEVICE_IDENTITY_DONE = 4;
    private static final int EVENT_GET_ICCID_DONE = 5;
    private static final int EVENT_GET_IMSI_DONE = 3;
    private static final int EVENT_GET_SMS_DONE = 22;
    private static final int EVENT_GET_SST_DONE = 17;
    private static final int EVENT_MARK_SMS_READ_DONE = 19;
    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    private static final int EVENT_RUIM_REFRESH = 31;
    private static final int EVENT_SMS_ON_RUIM = 21;
    private static final int EVENT_UPDATE_DONE = 14;
    static final String LOG_TAG = "CDMA";
    private String mImsi;
    private String mMin2Min1;
    private String mMyMobileNumber;
    private String mPrlVersion;
    private boolean m_ota_commited;
}
