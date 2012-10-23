// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.content.Context;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.android.internal.telephony.gsm:
//            VoiceMailConstants, MiuiSpnOverrideImpl, SmsMessage, MiuiSpnOverride, 
//            SimTlv, SpnOverride, UsimServiceTable

public class SIMRecords extends IccRecords {
    private static final class Get_Spn_Fsm_State extends Enum {

        public static Get_Spn_Fsm_State valueOf(String s) {
            return (Get_Spn_Fsm_State)Enum.valueOf(com/android/internal/telephony/gsm/SIMRecords$Get_Spn_Fsm_State, s);
        }

        public static Get_Spn_Fsm_State[] values() {
            return (Get_Spn_Fsm_State[])$VALUES.clone();
        }

        private static final Get_Spn_Fsm_State $VALUES[];
        public static final Get_Spn_Fsm_State IDLE;
        public static final Get_Spn_Fsm_State INIT;
        public static final Get_Spn_Fsm_State READ_SPN_3GPP;
        public static final Get_Spn_Fsm_State READ_SPN_CPHS;
        public static final Get_Spn_Fsm_State READ_SPN_SHORT_CPHS;

        static  {
            IDLE = new Get_Spn_Fsm_State("IDLE", 0);
            INIT = new Get_Spn_Fsm_State("INIT", 1);
            READ_SPN_3GPP = new Get_Spn_Fsm_State("READ_SPN_3GPP", 2);
            READ_SPN_CPHS = new Get_Spn_Fsm_State("READ_SPN_CPHS", 3);
            READ_SPN_SHORT_CPHS = new Get_Spn_Fsm_State("READ_SPN_SHORT_CPHS", 4);
            Get_Spn_Fsm_State aget_spn_fsm_state[] = new Get_Spn_Fsm_State[5];
            aget_spn_fsm_state[0] = IDLE;
            aget_spn_fsm_state[1] = INIT;
            aget_spn_fsm_state[2] = READ_SPN_3GPP;
            aget_spn_fsm_state[3] = READ_SPN_CPHS;
            aget_spn_fsm_state[4] = READ_SPN_SHORT_CPHS;
            $VALUES = aget_spn_fsm_state;
        }

        private Get_Spn_Fsm_State(String s, int i) {
            super(s, i);
        }
    }


    public SIMRecords(IccCard icccard, Context context, CommandsInterface commandsinterface) {
        super(icccard, context, commandsinterface);
        mCphsInfo = null;
        mCspPlmnEnabled = true;
        efMWIS = null;
        efCPHS_MWI = null;
        mEfCff = null;
        mEfCfis = null;
        spdiNetworks = null;
        pnnHomeName = null;
        super.adnCache = new AdnRecordCache(super.mFh);
        mVmConfig = new VoiceMailConstants();
        mSpnOverride = new MiuiSpnOverrideImpl();
        super.recordsRequested = false;
        super.recordsToLoad = 0;
        super.mCi.registerForOffOrNotAvailable(this, 2, null);
        super.mCi.setOnSmsOnSim(this, 21, null);
        super.mCi.registerForIccRefresh(this, 31, null);
        onRadioOffOrNotAvailable();
    }

    private void getSpnFsm(boolean flag, AsyncResult asyncresult) {
        if(!flag) goto _L2; else goto _L1
_L1:
        if(spnState != Get_Spn_Fsm_State.READ_SPN_3GPP && spnState != Get_Spn_Fsm_State.READ_SPN_CPHS && spnState != Get_Spn_Fsm_State.READ_SPN_SHORT_CPHS && spnState != Get_Spn_Fsm_State.INIT) goto _L4; else goto _L3
_L3:
        spnState = Get_Spn_Fsm_State.INIT;
_L6:
        return;
_L4:
        spnState = Get_Spn_Fsm_State.INIT;
_L2:
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$gsm$SIMRecords$Get_Spn_Fsm_State[];

            static  {
                $SwitchMap$com$android$internal$telephony$gsm$SIMRecords$Get_Spn_Fsm_State = new int[Get_Spn_Fsm_State.values().length];
                NoSuchFieldError nosuchfielderror3;
                try {
                    $SwitchMap$com$android$internal$telephony$gsm$SIMRecords$Get_Spn_Fsm_State[Get_Spn_Fsm_State.INIT.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$gsm$SIMRecords$Get_Spn_Fsm_State[Get_Spn_Fsm_State.READ_SPN_3GPP.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$gsm$SIMRecords$Get_Spn_Fsm_State[Get_Spn_Fsm_State.READ_SPN_CPHS.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$android$internal$telephony$gsm$SIMRecords$Get_Spn_Fsm_State[Get_Spn_Fsm_State.READ_SPN_SHORT_CPHS.ordinal()] = 4;
_L2:
                return;
                nosuchfielderror3;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        switch(_cls1..SwitchMap.com.android.internal.telephony.gsm.SIMRecords.Get_Spn_Fsm_State[spnState.ordinal()]) {
        default:
            spnState = Get_Spn_Fsm_State.IDLE;
            break;

        case 1: // '\001'
            super.spn = null;
            super.mFh.loadEFTransparent(28486, obtainMessage(12));
            super.recordsToLoad = 1 + super.recordsToLoad;
            spnState = Get_Spn_Fsm_State.READ_SPN_3GPP;
            break;

        case 2: // '\002'
            if(asyncresult != null && asyncresult.exception == null) {
                byte abyte2[] = (byte[])(byte[])asyncresult.result;
                spnDisplayCondition = 0xff & abyte2[0];
                super.spn = IccUtils.adnStringFieldToString(abyte2, 1, -1 + abyte2.length);
                log((new StringBuilder()).append("Load EF_SPN: ").append(super.spn).append(" spnDisplayCondition: ").append(spnDisplayCondition).toString());
                SystemProperties.set("gsm.sim.operator.alpha", super.spn);
                spnState = Get_Spn_Fsm_State.IDLE;
            } else {
                super.mFh.loadEFTransparent(28436, obtainMessage(12));
                super.recordsToLoad = 1 + super.recordsToLoad;
                spnState = Get_Spn_Fsm_State.READ_SPN_CPHS;
                spnDisplayCondition = -1;
            }
            break;

        case 3: // '\003'
            if(asyncresult != null && asyncresult.exception == null) {
                byte abyte1[] = (byte[])(byte[])asyncresult.result;
                super.spn = IccUtils.adnStringFieldToString(abyte1, 0, -1 + abyte1.length);
                log((new StringBuilder()).append("Load EF_SPN_CPHS: ").append(super.spn).toString());
                SystemProperties.set("gsm.sim.operator.alpha", super.spn);
                spnState = Get_Spn_Fsm_State.IDLE;
            } else {
                super.mFh.loadEFTransparent(28440, obtainMessage(12));
                super.recordsToLoad = 1 + super.recordsToLoad;
                spnState = Get_Spn_Fsm_State.READ_SPN_SHORT_CPHS;
            }
            break;

        case 4: // '\004'
            if(asyncresult != null && asyncresult.exception == null) {
                byte abyte0[] = (byte[])(byte[])asyncresult.result;
                super.spn = IccUtils.adnStringFieldToString(abyte0, 0, -1 + abyte0.length);
                log((new StringBuilder()).append("Load EF_SPN_SHORT_CPHS: ").append(super.spn).toString());
                SystemProperties.set("gsm.sim.operator.alpha", super.spn);
            } else {
                log("No SPN loaded in either CHPS or 3GPP");
            }
            spnState = Get_Spn_Fsm_State.IDLE;
            break;
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void handleEfCspData(byte abyte0[]) {
        int i;
        int j;
        i = abyte0.length / 2;
        mCspPlmnEnabled = true;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_108;
        if(abyte0[j * 2] != -64) goto _L2; else goto _L1
_L1:
        log((new StringBuilder()).append("[CSP] found ValueAddedServicesGroup, value ").append(abyte0[1 + j * 2]).toString());
        if((0x80 & abyte0[1 + j * 2]) == 128) {
            mCspPlmnEnabled = true;
        } else {
            mCspPlmnEnabled = false;
            log("[CSP] Set Automatic Network Selection");
            super.mNetworkSelectionModeAutomaticRegistrants.notifyRegistrants();
        }
_L4:
        return;
_L2:
        j++;
          goto _L3
        log("[CSP] Value Added Service Group (0xC0), not found!");
          goto _L4
    }

    private void handleFileUpdate(int i) {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   28437: 131
    //                   28439: 91
    //                   28615: 48;
           goto _L1 _L2 _L3 _L4
_L1:
        super.adnCache.reset();
        fetchSimRecords();
_L6:
        return;
_L4:
        super.recordsToLoad = 1 + super.recordsToLoad;
        (new AdnRecordLoader(super.mFh)).loadFromEF(28615, 28616, super.mailboxIndex, obtainMessage(6));
        continue; /* Loop/switch isn't completed */
_L3:
        super.recordsToLoad = 1 + super.recordsToLoad;
        (new AdnRecordLoader(super.mFh)).loadFromEF(28439, 28490, 1, obtainMessage(11));
        continue; /* Loop/switch isn't completed */
_L2:
        super.recordsToLoad = 1 + super.recordsToLoad;
        log("[CSP] SIM Refresh for EF_CSP_CPHS");
        super.mFh.loadEFTransparent(28437, obtainMessage(33));
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void handleSimRefresh(IccRefreshResponse iccrefreshresponse) {
        if(iccrefreshresponse != null) goto _L2; else goto _L1
_L1:
        log("handleSimRefresh received without input");
_L4:
        return;
_L2:
        if(iccrefreshresponse.aid != null && !iccrefreshresponse.aid.equals(super.mParentCard.getAid())) goto _L4; else goto _L3
_L3:
        switch(iccrefreshresponse.refreshResult) {
        default:
            log("handleSimRefresh with unknown operation");
            break;

        case 0: // '\0'
            log("handleSimRefresh with SIM_FILE_UPDATED");
            handleFileUpdate(iccrefreshresponse.efId);
            break;

        case 1: // '\001'
            log("handleSimRefresh with SIM_REFRESH_INIT");
            super.adnCache.reset();
            fetchSimRecords();
            break;

        case 2: // '\002'
            log("handleSimRefresh with SIM_REFRESH_RESET");
            super.mCi.setRadioPower(false, null);
            break;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    private void handleSms(byte abyte0[]) {
        if(abyte0[0] != 0)
            Log.d("ENF", (new StringBuilder()).append("status : ").append(abyte0[0]).toString());
        if(abyte0[0] == 3) {
            int i = abyte0.length;
            byte abyte1[] = new byte[i - 1];
            System.arraycopy(abyte0, 1, abyte1, 0, i - 1);
            dispatchGsmMessage(SmsMessage.createFromPdu(abyte1));
        }
    }

    private void handleSmses(ArrayList arraylist) {
        int i = arraylist.size();
        for(int j = 0; j < i; j++) {
            byte abyte0[] = (byte[])(byte[])arraylist.get(j);
            if(abyte0[0] != 0)
                Log.i("ENF", (new StringBuilder()).append("status ").append(j).append(": ").append(abyte0[0]).toString());
            if(abyte0[0] == 3) {
                int k = abyte0.length;
                byte abyte1[] = new byte[k - 1];
                System.arraycopy(abyte0, 1, abyte1, 0, k - 1);
                dispatchGsmMessage(SmsMessage.createFromPdu(abyte1));
                abyte0[0] = 1;
            }
        }

    }

    private boolean isCphsMailboxEnabled() {
        int i = 1;
        int j = 0;
        if(mCphsInfo != null) {
            if((0x30 & mCphsInfo[i]) != 48)
                i = 0;
            j = i;
        }
        return j;
    }

    private boolean isOnMatchingPlmn(String s) {
        boolean flag = false;
        if(s != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(s.equals(getOperatorNumeric())) {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        if(MiuiSpnOverride.getInstance().getEquivalentOperatorNumeric(s).equals(MiuiSpnOverride.getInstance().getEquivalentOperatorNumeric(getOperatorNumeric()))) {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        if(spdiNetworks == null)
            continue; /* Loop/switch isn't completed */
        Iterator iterator = spdiNetworks.iterator();
        do
            if(!iterator.hasNext())
                continue; /* Loop/switch isn't completed */
        while(!s.equals((String)iterator.next()));
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void parseEfSpdi(byte abyte0[]) {
        SimTlv simtlv = new SimTlv(abyte0, 0, abyte0.length);
        byte abyte1[] = null;
        do {
label0:
            {
                if(simtlv.isValidObject()) {
                    if(simtlv.getTag() == 163)
                        simtlv = new SimTlv(simtlv.getData(), 0, simtlv.getData().length);
                    if(simtlv.getTag() != 128)
                        break label0;
                    abyte1 = simtlv.getData();
                }
                if(abyte1 != null) {
                    spdiNetworks = new ArrayList(abyte1.length / 3);
                    int i = 0;
                    while(i + 2 < abyte1.length)  {
                        String s = IccUtils.bcdToString(abyte1, i, 3);
                        if(s.length() >= 5) {
                            log((new StringBuilder()).append("EF_SPDI network: ").append(s).toString());
                            spdiNetworks.add(s);
                        }
                        i += 3;
                    }
                }
                return;
            }
            simtlv.nextObject();
        } while(true);
    }

    private void setSpnFromConfig(String s) {
        if(mSpnOverride.containsCarrier(s)) {
            super.spn = mSpnOverride.getSpn(s);
            if(!TextUtils.isEmpty(super.spn))
                spnDisplayCondition = 0;
        }
    }

    private void setVoiceMailByCountry(String s) {
        if(mVmConfig.containsCarrier(s)) {
            super.isVoiceMailFixed = true;
            super.voiceMailNum = mVmConfig.getVoiceMailNumber(s);
            super.voiceMailTag = mVmConfig.getVoiceMailTag(s);
        }
    }

    protected int dispatchGsmMessage(SmsMessageBase smsmessagebase) {
        super.mNewSmsRegistrants.notifyResult(smsmessagebase);
        return 0;
    }

    public void dispose() {
        log((new StringBuilder()).append("Disposing SIMRecords ").append(this).toString());
        super.mCi.unregisterForOffOrNotAvailable(this);
        super.mCi.unregisterForIccRefresh(this);
        super.mCi.unSetOnSmsOnSim(this);
        super.dispose();
    }

    protected void fetchSimRecords() {
        super.recordsRequested = true;
        log((new StringBuilder()).append("fetchSimRecords ").append(super.recordsToLoad).toString());
        super.mCi.getIMSIForApp(super.mParentCard.getAid(), obtainMessage(3));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(12258, obtainMessage(4));
        super.recordsToLoad = 1 + super.recordsToLoad;
        (new AdnRecordLoader(super.mFh)).loadFromEF(28480, 28490, 1, obtainMessage(10));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFLinearFixed(28617, 1, obtainMessage(5));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28589, obtainMessage(9));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFLinearFixed(28618, 1, obtainMessage(7));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28433, obtainMessage(8));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFLinearFixed(28619, 1, obtainMessage(32));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28435, obtainMessage(24));
        super.recordsToLoad = 1 + super.recordsToLoad;
        getSpnFsm(true, null);
        super.mFh.loadEFTransparent(28621, obtainMessage(13));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFLinearFixed(28613, 1, obtainMessage(15));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28472, obtainMessage(17));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28438, obtainMessage(26));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28437, obtainMessage(33));
        super.recordsToLoad = 1 + super.recordsToLoad;
        log((new StringBuilder()).append("fetchSimRecords ").append(super.recordsToLoad).append(" requested: ").append(super.recordsRequested).toString());
    }

    protected void finalize() {
        log("finalized");
    }

    public int getDisplayRule(String s) {
        if(super.spn != null && spnDisplayCondition != -1) goto _L2; else goto _L1
_L1:
        int i = 2;
_L4:
        return i;
_L2:
        if(isOnMatchingPlmn(s)) {
            i = 1;
            if((1 & spnDisplayCondition) == 1)
                i |= 2;
        } else {
            i = 2;
            if((2 & spnDisplayCondition) == 0)
                i |= 1;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String getIMSI() {
        return imsi;
    }

    public String getMsisdnAlphaTag() {
        return super.msisdnTag;
    }

    public String getMsisdnNumber() {
        return super.msisdn;
    }

    public String getOperatorNumeric() {
        String s = null;
        if(imsi == null)
            log("getOperatorNumeric: IMSI == null");
        else
        if(super.mncLength == -1 || super.mncLength == 0)
            log("getSIMOperatorNumeric: bad mncLength");
        else
            s = imsi.substring(0, 3 + super.mncLength);
        return s;
    }

    public UsimServiceTable getUsimServiceTable() {
        return mUsimServiceTable;
    }

    public boolean getVoiceCallForwardingFlag() {
        return callForwardingEnabled;
    }

    public String getVoiceMailAlphaTag() {
        return super.voiceMailTag;
    }

    public String getVoiceMailNumber() {
        return super.voiceMailNum;
    }

    public void handleMessage(Message message) {
        boolean flag = false;
        if(!super.mDestroyed) goto _L2; else goto _L1
_L1:
        loge((new StringBuilder()).append("Received message ").append(message).append("[").append(message.what).append("] ").append(" while being destroyed. Ignoring.").toString());
_L31:
        return;
_L2:
        message.what;
        JVM INSTR tableswitch 2 33: default 204
    //                   2 220
    //                   3 245
    //                   4 1367
    //                   5 570
    //                   6 750
    //                   7 1126
    //                   8 1272
    //                   9 1442
    //                   10 1007
    //                   11 750
    //                   12 2446
    //                   13 2571
    //                   14 2612
    //                   15 2644
    //                   16 204
    //                   17 3007
    //                   18 2740
    //                   19 2774
    //                   20 3149
    //                   21 2807
    //                   22 2939
    //                   23 204
    //                   24 2463
    //                   25 3346
    //                   26 3082
    //                   27 204
    //                   28 204
    //                   29 204
    //                   30 1074
    //                   31 3460
    //                   32 3522
    //                   33 3620;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L8 _L13 _L14 _L15 _L16 _L3 _L17 _L18 _L19 _L20 _L21 _L22 _L3 _L23 _L24 _L25 _L3 _L3 _L3 _L26 _L27 _L28 _L29
_L3:
        super.handleMessage(message);
_L32:
        if(!flag) goto _L31; else goto _L30
_L30:
        onRecordLoaded();
        break; /* Loop/switch isn't completed */
_L4:
        onRadioOffOrNotAvailable();
          goto _L32
        RuntimeException runtimeexception;
        runtimeexception;
        logw("Exception parsing SIM record", runtimeexception);
        if(!flag) goto _L31; else goto _L30
_L5:
        flag = true;
        AsyncResult asyncresult22 = (AsyncResult)message.obj;
        if(asyncresult22.exception == null) goto _L34; else goto _L33
_L33:
        loge((new StringBuilder()).append("Exception querying IMSI, Exception:").append(asyncresult22.exception).toString());
          goto _L32
        Exception exception;
        exception;
        if(flag)
            onRecordLoaded();
        throw exception;
_L34:
        imsi = (String)asyncresult22.result;
        if(imsi != null && (imsi.length() < 6 || imsi.length() > 15)) {
            loge((new StringBuilder()).append("invalid IMSI ").append(imsi).toString());
            imsi = null;
        }
        log("IMSI: xxxxxxx");
        if(super.mncLength != 0 && super.mncLength != 2 || imsi == null || imsi.length() < 6) goto _L36; else goto _L35
_L35:
        String s12;
        String as5[];
        int i3;
        int j3;
        s12 = imsi.substring(0, 6);
        as5 = MCCMNC_CODES_HAVING_3DIGITS_MNC;
        i3 = as5.length;
        j3 = 0;
_L116:
        if(j3 >= i3) goto _L36; else goto _L37
_L37:
        if(!as5[j3].equals(s12)) goto _L39; else goto _L38
_L38:
        super.mncLength = 3;
_L36:
        int l2 = super.mncLength;
        if(l2 != 0) goto _L41; else goto _L40
_L40:
        try {
            super.mncLength = MccTable.smallestDigitsMccForMnc(Integer.parseInt(imsi.substring(0, 3)));
        }
        catch(NumberFormatException numberformatexception5) {
            super.mncLength = 0;
            loge("Corrupt IMSI!");
        }
_L41:
        if(super.mncLength != 0 && super.mncLength != -1)
            MccTable.updateMccMncConfiguration(super.mContext, imsi.substring(0, 3 + super.mncLength));
        super.mParentCard.broadcastIccStateChangedIntent("IMSI", null);
          goto _L32
_L7:
        flag = true;
        AsyncResult asyncresult21 = (AsyncResult)message.obj;
        byte abyte10[] = (byte[])(byte[])asyncresult21.result;
        boolean flag4 = false;
        if(asyncresult21.exception == null) {
            log((new StringBuilder()).append("EF_MBI: ").append(IccUtils.bytesToHexString(abyte10)).toString());
            super.mailboxIndex = 0xff & abyte10[0];
            if(super.mailboxIndex != 0 && super.mailboxIndex != 255) {
                log("Got valid mailbox number for MBDN");
                flag4 = true;
            }
        }
        super.recordsToLoad = 1 + super.recordsToLoad;
        if(flag4)
            (new AdnRecordLoader(super.mFh)).loadFromEF(28615, 28616, super.mailboxIndex, obtainMessage(6));
        else
            (new AdnRecordLoader(super.mFh)).loadFromEF(28439, 28490, 1, obtainMessage(11));
          goto _L32
_L8:
        AsyncResult asyncresult20;
        super.voiceMailNum = null;
        super.voiceMailTag = null;
        flag = true;
        asyncresult20 = (AsyncResult)message.obj;
        if(asyncresult20.exception == null) goto _L43; else goto _L42
_L42:
        StringBuilder stringbuilder1 = (new StringBuilder()).append("Invalid or missing EF");
        if(message.what != 11) goto _L45; else goto _L44
_L44:
        String s11 = "[MAILBOX]";
_L117:
        log(stringbuilder1.append(s11).toString());
        if(message.what == 6) {
            super.recordsToLoad = 1 + super.recordsToLoad;
            (new AdnRecordLoader(super.mFh)).loadFromEF(28439, 28490, 1, obtainMessage(11));
        }
          goto _L32
_L43:
        AdnRecord adnrecord2;
        StringBuilder stringbuilder;
        adnrecord2 = (AdnRecord)asyncresult20.result;
        stringbuilder = (new StringBuilder()).append("VM: ").append(adnrecord2);
        if(message.what != 11) goto _L47; else goto _L46
_L46:
        String s10 = " EF[MAILBOX]";
_L118:
        log(stringbuilder.append(s10).toString());
        if(adnrecord2.isEmpty() && message.what == 6) {
            super.recordsToLoad = 1 + super.recordsToLoad;
            (new AdnRecordLoader(super.mFh)).loadFromEF(28439, 28490, 1, obtainMessage(11));
        } else {
            super.voiceMailNum = adnrecord2.getNumber();
            super.voiceMailTag = adnrecord2.getAlphaTag();
        }
          goto _L32
_L12:
        flag = true;
        AsyncResult asyncresult19 = (AsyncResult)message.obj;
        if(asyncresult19.exception != null) {
            log("Invalid or missing EF[MSISDN]");
        } else {
            AdnRecord adnrecord1 = (AdnRecord)asyncresult19.result;
            super.msisdn = adnrecord1.getNumber();
            super.msisdnTag = adnrecord1.getAlphaTag();
            log("MSISDN: xxxxxxx");
        }
          goto _L32
_L26:
        flag = false;
        AsyncResult asyncresult18 = (AsyncResult)message.obj;
        if(asyncresult18.userObj != null) {
            AsyncResult.forMessage((Message)asyncresult18.userObj).exception = asyncresult18.exception;
            ((Message)asyncresult18.userObj).sendToTarget();
        }
          goto _L32
_L9:
        AsyncResult asyncresult17;
        byte abyte9[];
        flag = true;
        asyncresult17 = (AsyncResult)message.obj;
        abyte9 = (byte[])(byte[])asyncresult17.result;
        if(asyncresult17.exception != null) goto _L32; else goto _L48
_L48:
        log((new StringBuilder()).append("EF_MWIS: ").append(IccUtils.bytesToHexString(abyte9)).toString());
        efMWIS = abyte9;
        if((0xff & abyte9[0]) != 255) goto _L50; else goto _L49
_L49:
        log("Uninitialized record MWIS");
          goto _L32
_L50:
        if((1 & abyte9[0]) == 0) goto _L52; else goto _L51
_L51:
        boolean flag3 = true;
_L119:
        super.countVoiceMessages = 0xff & abyte9[1];
        if(flag3 && super.countVoiceMessages == 0)
            super.countVoiceMessages = -1;
        super.mRecordsEventsRegistrants.notifyResult(Integer.valueOf(0));
          goto _L32
_L10:
        flag = true;
        AsyncResult asyncresult16 = (AsyncResult)message.obj;
        byte abyte8[] = (byte[])(byte[])asyncresult16.result;
        if(asyncresult16.exception == null) {
            efCPHS_MWI = abyte8;
            if(efMWIS == null) {
                int k2 = 0xf & abyte8[0];
                if(k2 == 10)
                    super.countVoiceMessages = -1;
                else
                if(k2 == 5)
                    super.countVoiceMessages = 0;
                super.mRecordsEventsRegistrants.notifyResult(Integer.valueOf(0));
            }
        }
          goto _L32
_L6:
        flag = true;
        AsyncResult asyncresult15 = (AsyncResult)message.obj;
        byte abyte7[] = (byte[])(byte[])asyncresult15.result;
        if(asyncresult15.exception == null) {
            super.iccid = IccUtils.bcdToString(abyte7, 0, abyte7.length);
            log((new StringBuilder()).append("iccid: ").append(super.iccid).toString());
        }
          goto _L32
_L11:
        flag = true;
        byte abyte6[];
        Throwable throwable;
        AsyncResult asyncresult14 = (AsyncResult)message.obj;
        abyte6 = (byte[])(byte[])asyncresult14.result;
        throwable = asyncresult14.exception;
        if(throwable == null) goto _L54; else goto _L53
_L53:
        if(super.mncLength != -1 && super.mncLength != 0 && super.mncLength != 2 || imsi == null || imsi.length() < 6) goto _L56; else goto _L55
_L55:
        String s9;
        String as4[];
        int i2;
        int j2;
        s9 = imsi.substring(0, 6);
        as4 = MCCMNC_CODES_HAVING_3DIGITS_MNC;
        i2 = as4.length;
        j2 = 0;
_L123:
        if(j2 >= i2) goto _L56; else goto _L57
_L57:
        if(!as4[j2].equals(s9)) goto _L59; else goto _L58
_L58:
        super.mncLength = 3;
_L56:
        if(super.mncLength != 0 && super.mncLength != -1) goto _L61; else goto _L60
_L60:
        String s8 = imsi;
        if(s8 == null) goto _L63; else goto _L62
_L62:
        AsyncResult asyncresult1;
        byte abyte1[];
        boolean flag1;
        AsyncResult asyncresult10;
        byte abyte3[];
        SimTlv simtlv;
        AsyncResult asyncresult13;
        byte abyte5[];
        boolean flag2;
        Exception exception1;
        String s;
        String s1;
        String as[];
        int i;
        int j;
        String s2;
        String s3;
        String as1[];
        int k;
        int l;
        String s4;
        String s5;
        String as2[];
        int i1;
        int j1;
        String s6;
        String s7;
        String as3[];
        int k1;
        int l1;
        try {
            super.mncLength = MccTable.smallestDigitsMccForMnc(Integer.parseInt(imsi.substring(0, 3)));
        }
        catch(NumberFormatException numberformatexception4) {
            super.mncLength = 0;
            loge("Corrupt IMSI!");
        }
_L61:
        if(imsi != null && super.mncLength != 0)
            MccTable.updateMccMncConfiguration(super.mContext, imsi.substring(0, 3 + super.mncLength));
          goto _L32
_L54:
        log((new StringBuilder()).append("EF_AD: ").append(IccUtils.bytesToHexString(abyte6)).toString());
        if(abyte6.length >= 3) goto _L65; else goto _L64
_L64:
        log("Corrupt AD data on SIM");
        if(super.mncLength != -1 && super.mncLength != 0 && super.mncLength != 2 || imsi == null || imsi.length() < 6) goto _L67; else goto _L66
_L66:
        s7 = imsi.substring(0, 6);
        as3 = MCCMNC_CODES_HAVING_3DIGITS_MNC;
        k1 = as3.length;
        l1 = 0;
_L124:
        if(l1 >= k1) goto _L67; else goto _L68
_L68:
        if(!as3[l1].equals(s7)) goto _L70; else goto _L69
_L69:
        super.mncLength = 3;
_L67:
        if(super.mncLength != 0 && super.mncLength != -1) goto _L72; else goto _L71
_L71:
        s6 = imsi;
        if(s6 == null) goto _L74; else goto _L73
_L73:
        try {
            super.mncLength = MccTable.smallestDigitsMccForMnc(Integer.parseInt(imsi.substring(0, 3)));
        }
        catch(NumberFormatException numberformatexception3) {
            super.mncLength = 0;
            loge("Corrupt IMSI!");
        }
_L72:
        if(imsi != null && super.mncLength != 0)
            MccTable.updateMccMncConfiguration(super.mContext, imsi.substring(0, 3 + super.mncLength));
          goto _L32
_L65:
        if(abyte6.length != 3) goto _L76; else goto _L75
_L75:
        log("MNC length not present in EF_AD");
        if(super.mncLength != -1 && super.mncLength != 0 && super.mncLength != 2 || imsi == null || imsi.length() < 6) goto _L78; else goto _L77
_L77:
        s5 = imsi.substring(0, 6);
        as2 = MCCMNC_CODES_HAVING_3DIGITS_MNC;
        i1 = as2.length;
        j1 = 0;
_L125:
        if(j1 >= i1) goto _L78; else goto _L79
_L79:
        if(!as2[j1].equals(s5)) goto _L81; else goto _L80
_L80:
        super.mncLength = 3;
_L78:
        if(super.mncLength != 0 && super.mncLength != -1) goto _L83; else goto _L82
_L82:
        s4 = imsi;
        if(s4 == null) goto _L85; else goto _L84
_L84:
        try {
            super.mncLength = MccTable.smallestDigitsMccForMnc(Integer.parseInt(imsi.substring(0, 3)));
        }
        catch(NumberFormatException numberformatexception2) {
            super.mncLength = 0;
            loge("Corrupt IMSI!");
        }
_L83:
        if(imsi != null && super.mncLength != 0)
            MccTable.updateMccMncConfiguration(super.mContext, imsi.substring(0, 3 + super.mncLength));
          goto _L32
_L76:
        super.mncLength = 0xf & abyte6[3];
        if(super.mncLength == 15)
            super.mncLength = 0;
        if(super.mncLength != -1 && super.mncLength != 0 && super.mncLength != 2 || imsi == null || imsi.length() < 6) goto _L87; else goto _L86
_L86:
        s3 = imsi.substring(0, 6);
        as1 = MCCMNC_CODES_HAVING_3DIGITS_MNC;
        k = as1.length;
        l = 0;
_L126:
        if(l >= k) goto _L87; else goto _L88
_L88:
        if(!as1[l].equals(s3)) goto _L90; else goto _L89
_L89:
        super.mncLength = 3;
_L87:
        if(super.mncLength != 0 && super.mncLength != -1) goto _L92; else goto _L91
_L91:
        s2 = imsi;
        if(s2 == null) goto _L94; else goto _L93
_L93:
        try {
            super.mncLength = MccTable.smallestDigitsMccForMnc(Integer.parseInt(imsi.substring(0, 3)));
        }
        catch(NumberFormatException numberformatexception1) {
            super.mncLength = 0;
            loge("Corrupt IMSI!");
        }
_L92:
        if(imsi != null && super.mncLength != 0)
            MccTable.updateMccMncConfiguration(super.mContext, imsi.substring(0, 3 + super.mncLength));
          goto _L32
        exception1;
        if(super.mncLength != -1 && super.mncLength != 0 && super.mncLength != 2 || imsi == null || imsi.length() < 6) goto _L96; else goto _L95
_L95:
        s1 = imsi.substring(0, 6);
        as = MCCMNC_CODES_HAVING_3DIGITS_MNC;
        i = as.length;
        j = 0;
_L122:
        if(j >= i) goto _L96; else goto _L97
_L97:
        if(!as[j].equals(s1)) goto _L99; else goto _L98
_L98:
        super.mncLength = 3;
_L96:
        if(super.mncLength != 0 && super.mncLength != -1) goto _L101; else goto _L100
_L100:
        s = imsi;
        if(s == null) goto _L103; else goto _L102
_L102:
        try {
            super.mncLength = MccTable.smallestDigitsMccForMnc(Integer.parseInt(imsi.substring(0, 3)));
        }
        catch(NumberFormatException numberformatexception) {
            super.mncLength = 0;
            loge("Corrupt IMSI!");
        }
_L101:
        if(imsi != null && super.mncLength != 0)
            MccTable.updateMccMncConfiguration(super.mContext, imsi.substring(0, 3 + super.mncLength));
        throw exception1;
_L13:
        flag = true;
        getSpnFsm(false, (AsyncResult)message.obj);
          goto _L32
_L23:
        flag = true;
        asyncresult13 = (AsyncResult)message.obj;
        abyte5 = (byte[])(byte[])asyncresult13.result;
        if(asyncresult13.exception != null) goto _L32; else goto _L104
_L104:
        log((new StringBuilder()).append("EF_CFF_CPHS: ").append(IccUtils.bytesToHexString(abyte5)).toString());
        mEfCff = abyte5;
        if(mEfCfis != null) goto _L32; else goto _L105
_L105:
        if((0xf & abyte5[0]) != 10) goto _L107; else goto _L106
_L106:
        flag2 = true;
_L120:
        callForwardingEnabled = flag2;
        super.mRecordsEventsRegistrants.notifyResult(Integer.valueOf(1));
          goto _L32
_L14:
        flag = true;
        AsyncResult asyncresult12 = (AsyncResult)message.obj;
        byte abyte4[] = (byte[])(byte[])asyncresult12.result;
        if(asyncresult12.exception == null)
            parseEfSpdi(abyte4);
          goto _L32
_L15:
        AsyncResult asyncresult11 = (AsyncResult)message.obj;
        if(asyncresult11.exception != null)
            logw("update failed. ", asyncresult11.exception);
          goto _L32
_L16:
        flag = true;
        asyncresult10 = (AsyncResult)message.obj;
        abyte3 = (byte[])(byte[])asyncresult10.result;
        if(asyncresult10.exception != null) goto _L32; else goto _L108
_L108:
        simtlv = new SimTlv(abyte3, 0, abyte3.length);
_L112:
        if(!simtlv.isValidObject()) goto _L32; else goto _L109
_L109:
        if(simtlv.getTag() != 67) goto _L111; else goto _L110
_L110:
        pnnHomeName = IccUtils.networkNameToString(simtlv.getData(), 0, simtlv.getData().length);
          goto _L32
_L111:
        simtlv.nextObject();
          goto _L112
_L18:
        flag = true;
        AsyncResult asyncresult9 = (AsyncResult)message.obj;
        if(asyncresult9.exception == null)
            handleSmses((ArrayList)asyncresult9.result);
          goto _L32
_L19:
        Log.i("ENF", (new StringBuilder()).append("marked read: sms ").append(message.arg1).toString());
          goto _L32
_L21:
        flag = false;
        AsyncResult asyncresult8 = (AsyncResult)message.obj;
        int ai[] = (int[])(int[])asyncresult8.result;
        if(asyncresult8.exception != null || ai.length != 1) {
            loge((new StringBuilder()).append("Error on SMS_ON_SIM with exp ").append(asyncresult8.exception).append(" length ").append(ai.length).toString());
        } else {
            log((new StringBuilder()).append("READ EF_SMS RECORD index=").append(ai[0]).toString());
            super.mFh.loadEFLinearFixed(28476, ai[0], obtainMessage(22));
        }
          goto _L32
_L22:
        flag = false;
        AsyncResult asyncresult7 = (AsyncResult)message.obj;
        if(asyncresult7.exception == null)
            handleSms((byte[])(byte[])asyncresult7.result);
        else
            loge((new StringBuilder()).append("Error on GET_SMS with exp ").append(asyncresult7.exception).toString());
          goto _L32
_L17:
        flag = true;
        AsyncResult asyncresult6 = (AsyncResult)message.obj;
        byte abyte2[] = (byte[])(byte[])asyncresult6.result;
        if(asyncresult6.exception == null) {
            mUsimServiceTable = new UsimServiceTable(abyte2);
            log((new StringBuilder()).append("SST: ").append(mUsimServiceTable).toString());
        }
          goto _L32
_L25:
        flag = true;
        AsyncResult asyncresult5 = (AsyncResult)message.obj;
        if(asyncresult5.exception == null) {
            mCphsInfo = (byte[])(byte[])asyncresult5.result;
            log((new StringBuilder()).append("iCPHS: ").append(IccUtils.bytesToHexString(mCphsInfo)).toString());
        }
          goto _L32
_L20:
        flag = false;
        AsyncResult asyncresult4 = (AsyncResult)message.obj;
        if(asyncresult4.exception == null) {
            super.voiceMailNum = super.newVoiceMailNum;
            super.voiceMailTag = super.newVoiceMailTag;
        }
        if(isCphsMailboxEnabled()) {
            AdnRecord adnrecord = new AdnRecord(super.voiceMailTag, super.voiceMailNum);
            Message message1 = (Message)asyncresult4.userObj;
            if(asyncresult4.exception == null && asyncresult4.userObj != null) {
                AsyncResult.forMessage((Message)asyncresult4.userObj).exception = null;
                ((Message)asyncresult4.userObj).sendToTarget();
                log("Callback with MBDN successful.");
                message1 = null;
            }
            (new AdnRecordLoader(super.mFh)).updateEF(adnrecord, 28439, 28490, 1, null, obtainMessage(25, message1));
        } else
        if(asyncresult4.userObj != null) {
            AsyncResult.forMessage((Message)asyncresult4.userObj).exception = asyncresult4.exception;
            ((Message)asyncresult4.userObj).sendToTarget();
        }
          goto _L32
_L24:
        flag = false;
        AsyncResult asyncresult3 = (AsyncResult)message.obj;
        if(asyncresult3.exception == null) {
            super.voiceMailNum = super.newVoiceMailNum;
            super.voiceMailTag = super.newVoiceMailTag;
        } else {
            log((new StringBuilder()).append("Set CPHS MailBox with exception: ").append(asyncresult3.exception).toString());
        }
        if(asyncresult3.userObj != null) {
            log("Callback with CPHS MB successful.");
            AsyncResult.forMessage((Message)asyncresult3.userObj).exception = asyncresult3.exception;
            ((Message)asyncresult3.userObj).sendToTarget();
        }
          goto _L32
_L27:
        flag = false;
        AsyncResult asyncresult2 = (AsyncResult)message.obj;
        log((new StringBuilder()).append("Sim REFRESH with exception: ").append(asyncresult2.exception).toString());
        if(asyncresult2.exception == null)
            handleSimRefresh((IccRefreshResponse)asyncresult2.result);
          goto _L32
_L28:
        flag = true;
        asyncresult1 = (AsyncResult)message.obj;
        abyte1 = (byte[])(byte[])asyncresult1.result;
        if(asyncresult1.exception != null) goto _L32; else goto _L113
_L113:
        log((new StringBuilder()).append("EF_CFIS: ").append(IccUtils.bytesToHexString(abyte1)).toString());
        mEfCfis = abyte1;
        if((1 & abyte1[1]) == 0) goto _L115; else goto _L114
_L114:
        flag1 = true;
_L121:
        callForwardingEnabled = flag1;
        super.mRecordsEventsRegistrants.notifyResult(Integer.valueOf(1));
          goto _L32
_L29:
        flag = true;
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception != null) {
            loge((new StringBuilder()).append("Exception in fetching EF_CSP data ").append(asyncresult.exception).toString());
        } else {
            byte abyte0[] = (byte[])(byte[])asyncresult.result;
            log((new StringBuilder()).append("EF_CSP: ").append(IccUtils.bytesToHexString(abyte0)).toString());
            handleEfCspData(abyte0);
        }
          goto _L32
_L103:
        super.mncLength = 0;
        log("MNC length not present in EF_AD");
          goto _L101
_L63:
        super.mncLength = 0;
        log("MNC length not present in EF_AD");
          goto _L61
_L74:
        super.mncLength = 0;
        log("MNC length not present in EF_AD");
          goto _L72
_L85:
        super.mncLength = 0;
        log("MNC length not present in EF_AD");
          goto _L83
_L94:
        super.mncLength = 0;
        log("MNC length not present in EF_AD");
          goto _L92
_L39:
        j3++;
          goto _L116
_L45:
        s11 = "[MBDN]";
          goto _L117
_L47:
        s10 = " EF[MBDN]";
          goto _L118
_L52:
        flag3 = false;
          goto _L119
_L107:
        flag2 = false;
          goto _L120
_L115:
        flag1 = false;
          goto _L121
_L99:
        j++;
          goto _L122
_L59:
        j2++;
          goto _L123
_L70:
        l1++;
          goto _L124
_L81:
        j1++;
          goto _L125
_L90:
        l++;
          goto _L126
    }

    public boolean isCspPlmnEnabled() {
        return mCspPlmnEnabled;
    }

    protected void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[SIMRecords] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("GSM", (new StringBuilder()).append("[SIMRecords] ").append(s).toString());
    }

    protected void logv(String s) {
        Log.v("GSM", (new StringBuilder()).append("[SIMRecords] ").append(s).toString());
    }

    protected void logw(String s, Throwable throwable) {
        Log.w("GSM", (new StringBuilder()).append("[SIMRecords] ").append(s).toString(), throwable);
    }

    protected void onAllRecordsLoaded() {
        String s = getOperatorNumeric();
        log((new StringBuilder()).append("SIMRecords: onAllRecordsLoaded set 'gsm.sim.operator.numeric' to operator='").append(s).append("'").toString());
        SystemProperties.set("gsm.sim.operator.numeric", s);
        if(imsi != null)
            SystemProperties.set("gsm.sim.operator.iso-country", MccTable.countryCodeForMcc(Integer.parseInt(imsi.substring(0, 3))));
        else
            loge("onAllRecordsLoaded: imsi is NULL!");
        setVoiceMailByCountry(s);
        setSpnFromConfig(s);
        super.recordsLoadedRegistrants.notifyRegistrants(new AsyncResult(null, null, null));
        super.mParentCard.broadcastIccStateChangedIntent("LOADED", null);
    }

    protected void onRadioOffOrNotAvailable() {
        imsi = null;
        super.msisdn = null;
        super.voiceMailNum = null;
        super.countVoiceMessages = 0;
        super.mncLength = -1;
        super.iccid = null;
        spnDisplayCondition = -1;
        efMWIS = null;
        efCPHS_MWI = null;
        spdiNetworks = null;
        pnnHomeName = null;
        super.adnCache.reset();
        log("SIMRecords: onRadioOffOrNotAvailable set 'gsm.sim.operator.numeric' to operator=null");
        SystemProperties.set("gsm.sim.operator.numeric", null);
        SystemProperties.set("gsm.sim.operator.alpha", null);
        SystemProperties.set("gsm.sim.operator.iso-country", null);
        super.recordsRequested = false;
    }

    public void onReady() {
        super.mParentCard.broadcastIccStateChangedIntent("READY", null);
        fetchSimRecords();
    }

    protected void onRecordLoaded() {
        super.recordsToLoad = -1 + super.recordsToLoad;
        log((new StringBuilder()).append("onRecordLoaded ").append(super.recordsToLoad).append(" requested: ").append(super.recordsRequested).toString());
        if(super.recordsToLoad != 0 || !super.recordsRequested) goto _L2; else goto _L1
_L1:
        onAllRecordsLoaded();
_L4:
        return;
_L2:
        if(super.recordsToLoad < 0) {
            loge("recordsToLoad <0, programmer error suspected");
            super.recordsToLoad = 0;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onRefresh(boolean flag, int ai[]) {
        if(flag)
            fetchSimRecords();
    }

    public void setMsisdnNumber(String s, String s1, Message message) {
        super.msisdn = s1;
        super.msisdnTag = s;
        log((new StringBuilder()).append("Set MSISDN: ").append(super.msisdnTag).append(" ").append("xxxxxxx").toString());
        AdnRecord adnrecord = new AdnRecord(super.msisdnTag, super.msisdn);
        (new AdnRecordLoader(super.mFh)).updateEF(adnrecord, 28480, 28490, 1, null, obtainMessage(30, message));
    }

    public void setVoiceCallForwardingFlag(int i, boolean flag) {
        if(i == 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        callForwardingEnabled = flag;
        super.mRecordsEventsRegistrants.notifyResult(Integer.valueOf(1));
        if(mEfCfis == null) goto _L4; else goto _L3
_L3:
        if(!flag) goto _L6; else goto _L5
_L5:
        byte abyte1[] = mEfCfis;
        abyte1[1] = (byte)(1 | abyte1[1]);
_L8:
        super.mFh.updateEFLinearFixed(28619, 1, mEfCfis, null, obtainMessage(14, Integer.valueOf(28619)));
_L4:
        if(mEfCff == null) goto _L1; else goto _L7
_L7:
        if(!flag)
            break MISSING_BLOCK_LABEL_172;
        mEfCff[0] = (byte)(0xa | 0xf0 & mEfCff[0]);
_L9:
        super.mFh.updateEFTransparent(28435, mEfCff, obtainMessage(14, Integer.valueOf(28435)));
          goto _L1
        ArrayIndexOutOfBoundsException arrayindexoutofboundsexception;
        arrayindexoutofboundsexception;
        logw("Error saving call fowarding flag to SIM. Probably malformed SIM record", arrayindexoutofboundsexception);
          goto _L1
_L6:
        byte abyte0[] = mEfCfis;
        abyte0[1] = (byte)(0xfe & abyte0[1]);
          goto _L8
        mEfCff[0] = (byte)(5 | 0xf0 & mEfCff[0]);
          goto _L9
    }

    public void setVoiceMailNumber(String s, String s1, Message message) {
        if(super.isVoiceMailFixed) {
            AsyncResult.forMessage(message).exception = new IccVmFixedException("Voicemail number is fixed by operator");
            message.sendToTarget();
        } else {
            super.newVoiceMailNum = s1;
            super.newVoiceMailTag = s;
            AdnRecord adnrecord = new AdnRecord(super.newVoiceMailTag, super.newVoiceMailNum);
            if(super.mailboxIndex != 0 && super.mailboxIndex != 255)
                (new AdnRecordLoader(super.mFh)).updateEF(adnrecord, 28615, 28616, super.mailboxIndex, null, obtainMessage(20, message));
            else
            if(isCphsMailboxEnabled()) {
                (new AdnRecordLoader(super.mFh)).updateEF(adnrecord, 28439, 28490, 1, null, obtainMessage(25, message));
            } else {
                AsyncResult.forMessage(message).exception = new IccVmNotSupportedException("Update SIM voice mailbox error");
                message.sendToTarget();
            }
        }
    }

    public void setVoiceMessageWaiting(int i, int j) {
        boolean flag = false;
        if(i == 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        byte byte0;
        ArrayIndexOutOfBoundsException arrayindexoutofboundsexception;
        byte abyte0[];
        int k;
        byte abyte1[];
        int l;
        if(j < 0)
            j = -1;
        else
        if(j > 255)
            j = 255;
        super.countVoiceMessages = j;
        super.mRecordsEventsRegistrants.notifyResult(Integer.valueOf(0));
        if(efMWIS == null) goto _L4; else goto _L3
_L3:
        abyte1 = efMWIS;
        l = 0xfe & efMWIS[0];
        if(super.countVoiceMessages != 0)
            flag = true;
        abyte1[0] = (byte)(flag | l);
        if(j >= 0) goto _L6; else goto _L5
_L5:
        efMWIS[1] = 0;
_L8:
        super.mFh.updateEFLinearFixed(28618, 1, efMWIS, null, obtainMessage(14, Integer.valueOf(28618)));
_L4:
        if(efCPHS_MWI == null) goto _L1; else goto _L7
_L7:
        abyte0 = efCPHS_MWI;
        k = 0xf0 & efCPHS_MWI[0];
        if(super.countVoiceMessages != 0)
            break MISSING_BLOCK_LABEL_229;
        byte0 = 5;
_L9:
        abyte0[0] = (byte)(byte0 | k);
        super.mFh.updateEFTransparent(28433, efCPHS_MWI, obtainMessage(14, Integer.valueOf(28433)));
          goto _L1
        arrayindexoutofboundsexception;
        logw("Error saving voice mail state to SIM. Probably malformed SIM record", arrayindexoutofboundsexception);
          goto _L1
_L6:
        efMWIS[1] = (byte)j;
          goto _L8
        byte0 = 10;
          goto _L9
    }

    static final int CFF_LINE1_MASK = 15;
    static final int CFF_LINE1_RESET = 240;
    static final int CFF_UNCONDITIONAL_ACTIVE = 10;
    static final int CFF_UNCONDITIONAL_DEACTIVE = 5;
    private static final int CPHS_SST_MBN_ENABLED = 48;
    private static final int CPHS_SST_MBN_MASK = 48;
    private static final boolean CRASH_RIL = false;
    protected static final boolean DBG = true;
    protected static final int EVENT_GET_AD_DONE = 9;
    private static final int EVENT_GET_ALL_SMS_DONE = 18;
    private static final int EVENT_GET_CFF_DONE = 24;
    private static final int EVENT_GET_CFIS_DONE = 32;
    private static final int EVENT_GET_CPHS_MAILBOX_DONE = 11;
    private static final int EVENT_GET_CSP_CPHS_DONE = 33;
    protected static final int EVENT_GET_ICCID_DONE = 4;
    protected static final int EVENT_GET_IMSI_DONE = 3;
    private static final int EVENT_GET_INFO_CPHS_DONE = 26;
    private static final int EVENT_GET_MBDN_DONE = 6;
    private static final int EVENT_GET_MBI_DONE = 5;
    protected static final int EVENT_GET_MSISDN_DONE = 10;
    private static final int EVENT_GET_MWIS_DONE = 7;
    private static final int EVENT_GET_PNN_DONE = 15;
    private static final int EVENT_GET_SMS_DONE = 22;
    private static final int EVENT_GET_SPDI_DONE = 13;
    private static final int EVENT_GET_SPN_DONE = 12;
    protected static final int EVENT_GET_SST_DONE = 17;
    private static final int EVENT_GET_VOICE_MAIL_INDICATOR_CPHS_DONE = 8;
    private static final int EVENT_MARK_SMS_READ_DONE = 19;
    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    private static final int EVENT_SET_CPHS_MAILBOX_DONE = 25;
    private static final int EVENT_SET_MBDN_DONE = 20;
    private static final int EVENT_SET_MSISDN_DONE = 30;
    private static final int EVENT_SIM_REFRESH = 31;
    private static final int EVENT_SMS_ON_SIM = 21;
    private static final int EVENT_UPDATE_DONE = 14;
    protected static final String LOG_TAG = "GSM";
    private static final String MCCMNC_CODES_HAVING_3DIGITS_MNC[];
    static final int SPN_RULE_SHOW_PLMN = 2;
    static final int SPN_RULE_SHOW_SPN = 1;
    static final int TAG_FULL_NETWORK_NAME = 67;
    static final int TAG_SHORT_NETWORK_NAME = 69;
    static final int TAG_SPDI = 163;
    static final int TAG_SPDI_PLMN_LIST = 128;
    private boolean callForwardingEnabled;
    byte efCPHS_MWI[];
    byte efMWIS[];
    private String imsi;
    private byte mCphsInfo[];
    boolean mCspPlmnEnabled;
    byte mEfCff[];
    byte mEfCfis[];
    SpnOverride mSpnOverride;
    UsimServiceTable mUsimServiceTable;
    VoiceMailConstants mVmConfig;
    String pnnHomeName;
    ArrayList spdiNetworks;
    int spnDisplayCondition;
    private Get_Spn_Fsm_State spnState;

    static  {
        String as[] = new String[122];
        as[0] = "405025";
        as[1] = "405026";
        as[2] = "405027";
        as[3] = "405028";
        as[4] = "405029";
        as[5] = "405030";
        as[6] = "405031";
        as[7] = "405032";
        as[8] = "405033";
        as[9] = "405034";
        as[10] = "405035";
        as[11] = "405036";
        as[12] = "405037";
        as[13] = "405038";
        as[14] = "405039";
        as[15] = "405040";
        as[16] = "405041";
        as[17] = "405042";
        as[18] = "405043";
        as[19] = "405044";
        as[20] = "405045";
        as[21] = "405046";
        as[22] = "405047";
        as[23] = "405750";
        as[24] = "405751";
        as[25] = "405752";
        as[26] = "405753";
        as[27] = "405754";
        as[28] = "405755";
        as[29] = "405756";
        as[30] = "405799";
        as[31] = "405800";
        as[32] = "405801";
        as[33] = "405802";
        as[34] = "405803";
        as[35] = "405804";
        as[36] = "405805";
        as[37] = "405806";
        as[38] = "405807";
        as[39] = "405808";
        as[40] = "405809";
        as[41] = "405810";
        as[42] = "405811";
        as[43] = "405812";
        as[44] = "405813";
        as[45] = "405814";
        as[46] = "405815";
        as[47] = "405816";
        as[48] = "405817";
        as[49] = "405818";
        as[50] = "405819";
        as[51] = "405820";
        as[52] = "405821";
        as[53] = "405822";
        as[54] = "405823";
        as[55] = "405824";
        as[56] = "405825";
        as[57] = "405826";
        as[58] = "405827";
        as[59] = "405828";
        as[60] = "405829";
        as[61] = "405830";
        as[62] = "405831";
        as[63] = "405832";
        as[64] = "405833";
        as[65] = "405834";
        as[66] = "405835";
        as[67] = "405836";
        as[68] = "405837";
        as[69] = "405838";
        as[70] = "405839";
        as[71] = "405840";
        as[72] = "405841";
        as[73] = "405842";
        as[74] = "405843";
        as[75] = "405844";
        as[76] = "405845";
        as[77] = "405846";
        as[78] = "405847";
        as[79] = "405848";
        as[80] = "405849";
        as[81] = "405850";
        as[82] = "405851";
        as[83] = "405852";
        as[84] = "405853";
        as[85] = "405875";
        as[86] = "405876";
        as[87] = "405877";
        as[88] = "405878";
        as[89] = "405879";
        as[90] = "405880";
        as[91] = "405881";
        as[92] = "405882";
        as[93] = "405883";
        as[94] = "405884";
        as[95] = "405885";
        as[96] = "405886";
        as[97] = "405908";
        as[98] = "405909";
        as[99] = "405910";
        as[100] = "405911";
        as[101] = "405912";
        as[102] = "405913";
        as[103] = "405914";
        as[104] = "405915";
        as[105] = "405916";
        as[106] = "405917";
        as[107] = "405918";
        as[108] = "405919";
        as[109] = "405920";
        as[110] = "405921";
        as[111] = "405922";
        as[112] = "405923";
        as[113] = "405924";
        as[114] = "405925";
        as[115] = "405926";
        as[116] = "405927";
        as[117] = "405928";
        as[118] = "405929";
        as[119] = "405930";
        as[120] = "405931";
        as[121] = "405932";
        MCCMNC_CODES_HAVING_3DIGITS_MNC = as;
    }
}
