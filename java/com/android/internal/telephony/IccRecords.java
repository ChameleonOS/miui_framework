// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.Context;
import android.os.*;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;

// Referenced classes of package com.android.internal.telephony:
//            IccConstants, IccCard, AdnRecord, AdnRecordLoader, 
//            AdnRecordCache, CommandsInterface, IccFileHandler

public abstract class IccRecords extends Handler
    implements IccConstants {
    public static interface IccRecordLoaded {

        public abstract String getEfName();

        public abstract void onRecordLoaded(AsyncResult asyncresult);
    }


    public IccRecords(IccCard icccard, Context context, CommandsInterface commandsinterface) {
        mDestroyed = false;
        recordsLoadedRegistrants = new RegistrantList();
        mRecordsEventsRegistrants = new RegistrantList();
        mNewSmsRegistrants = new RegistrantList();
        mNetworkSelectionModeAutomaticRegistrants = new RegistrantList();
        recordsRequested = false;
        msisdn = null;
        msisdnTag = null;
        voiceMailNum = null;
        voiceMailTag = null;
        newVoiceMailNum = null;
        newVoiceMailTag = null;
        isVoiceMailFixed = false;
        countVoiceMessages = 0;
        mncLength = -1;
        mailboxIndex = 0;
        mContext = context;
        mCi = commandsinterface;
        mFh = icccard.getIccFileHandler();
        mParentCard = icccard;
    }

    public void dispose() {
        mDestroyed = true;
        mParentCard = null;
        mFh = null;
        mCi = null;
        mContext = null;
    }

    public AdnRecordCache getAdnCache() {
        return adnCache;
    }

    public abstract int getDisplayRule(String s);

    public String getIMSI() {
        return null;
    }

    public IccCard getIccCard() {
        return mParentCard;
    }

    public IsimRecords getIsimRecords() {
        return null;
    }

    public String getMsisdnAlphaTag() {
        return msisdnTag;
    }

    public String getMsisdnNumber() {
        return msisdn;
    }

    public String getOperatorNumeric() {
        return null;
    }

    public boolean getRecordsLoaded() {
        boolean flag = true;
        if(recordsToLoad != 0 || recordsRequested != flag)
            flag = false;
        return flag;
    }

    public String getServiceProviderName() {
        return spn;
    }

    public UsimServiceTable getUsimServiceTable() {
        return null;
    }

    public boolean getVoiceCallForwardingFlag() {
        return false;
    }

    public String getVoiceMailAlphaTag() {
        return voiceMailTag;
    }

    public String getVoiceMailNumber() {
        return voiceMailNum;
    }

    public int getVoiceMessageCount() {
        return countVoiceMessages;
    }

    public boolean getVoiceMessageWaiting() {
        boolean flag;
        if(countVoiceMessages != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 100 100: default 24
    //                   100 30;
           goto _L1 _L2
_L1:
        super.handleMessage(message);
_L4:
        return;
_L2:
        AsyncResult asyncresult;
        IccRecordLoaded iccrecordloaded;
        asyncresult = (AsyncResult)message.obj;
        iccrecordloaded = (IccRecordLoaded)asyncresult.userObj;
        log((new StringBuilder()).append(iccrecordloaded.getEfName()).append(" LOADED").toString());
        if(asyncresult.exception == null)
            break; /* Loop/switch isn't completed */
        loge((new StringBuilder()).append("Record Load Exception: ").append(asyncresult.exception).toString());
_L5:
        onRecordLoaded();
        if(true) goto _L4; else goto _L3
_L3:
        iccrecordloaded.onRecordLoaded(asyncresult);
          goto _L5
        RuntimeException runtimeexception;
        runtimeexception;
        loge((new StringBuilder()).append("Exception parsing SIM record: ").append(runtimeexception).toString());
          goto _L5
        Exception exception;
        exception;
        onRecordLoaded();
        throw exception;
    }

    public boolean isCspPlmnEnabled() {
        return false;
    }

    public boolean isProvisioned() {
        return true;
    }

    protected abstract void log(String s);

    protected abstract void loge(String s);

    protected abstract void onAllRecordsLoaded();

    protected abstract void onRadioOffOrNotAvailable();

    public abstract void onReady();

    protected abstract void onRecordLoaded();

    public abstract void onRefresh(boolean flag, int ai[]);

    public void registerForNetworkSelectionModeAutomatic(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mNetworkSelectionModeAutomaticRegistrants.add(registrant);
    }

    public void registerForNewSms(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mNewSmsRegistrants.add(registrant);
    }

    public void registerForRecordsEvents(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        mRecordsEventsRegistrants.add(registrant);
    }

    public void registerForRecordsLoaded(Handler handler, int i, Object obj) {
        if(!mDestroyed) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Registrant registrant = new Registrant(handler, i, obj);
        recordsLoadedRegistrants.add(registrant);
        if(recordsToLoad == 0 && recordsRequested)
            registrant.notifyRegistrant(new AsyncResult(null, null, null));
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setMsisdnNumber(String s, String s1, Message message) {
        msisdn = s1;
        msisdnTag = s;
        log((new StringBuilder()).append("Set MSISDN: ").append(msisdnTag).append(" ").append(msisdn).toString());
        AdnRecord adnrecord = new AdnRecord(msisdnTag, msisdn);
        (new AdnRecordLoader(mFh)).updateEF(adnrecord, 28480, 28490, 1, null, obtainMessage(30, message));
    }

    public void setVoiceCallForwardingFlag(int i, boolean flag) {
    }

    public abstract void setVoiceMailNumber(String s, String s1, Message message);

    public abstract void setVoiceMessageWaiting(int i, int j);

    public void unregisterForNetworkSelectionModeAutomatic(Handler handler) {
        mNetworkSelectionModeAutomaticRegistrants.remove(handler);
    }

    public void unregisterForNewSms(Handler handler) {
        mNewSmsRegistrants.remove(handler);
    }

    public void unregisterForRecordsEvents(Handler handler) {
        mRecordsEventsRegistrants.remove(handler);
    }

    public void unregisterForRecordsLoaded(Handler handler) {
        recordsLoadedRegistrants.remove(handler);
    }

    protected static final boolean DBG = true;
    public static final int EVENT_CFI = 1;
    public static final int EVENT_GET_ICC_RECORD_DONE = 100;
    public static final int EVENT_MWI = 0;
    protected static final int EVENT_SET_MSISDN_DONE = 30;
    public static final int EVENT_SPN = 2;
    protected static final int SPN_RULE_SHOW_PLMN = 2;
    protected static final int SPN_RULE_SHOW_SPN = 1;
    protected static final int UNINITIALIZED = -1;
    protected static final int UNKNOWN;
    protected AdnRecordCache adnCache;
    protected int countVoiceMessages;
    public String iccid;
    protected boolean isVoiceMailFixed;
    protected CommandsInterface mCi;
    protected Context mContext;
    protected boolean mDestroyed;
    protected IccFileHandler mFh;
    protected RegistrantList mNetworkSelectionModeAutomaticRegistrants;
    protected RegistrantList mNewSmsRegistrants;
    protected IccCard mParentCard;
    protected RegistrantList mRecordsEventsRegistrants;
    protected int mailboxIndex;
    protected int mncLength;
    protected String msisdn;
    protected String msisdnTag;
    protected String newVoiceMailNum;
    protected String newVoiceMailTag;
    protected RegistrantList recordsLoadedRegistrants;
    protected boolean recordsRequested;
    protected int recordsToLoad;
    protected String spn;
    protected String voiceMailNum;
    protected String voiceMailTag;
}
