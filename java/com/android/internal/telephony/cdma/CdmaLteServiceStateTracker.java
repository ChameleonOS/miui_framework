// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.Context;
import android.os.*;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.gsm.GsmDataConnectionTracker;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CdmaServiceStateTracker, CdmaLteUiccRecords, CDMAPhone, CdmaDataConnectionTracker, 
//            CDMALTEPhone

public class CdmaLteServiceStateTracker extends CdmaServiceStateTracker {

    public CdmaLteServiceStateTracker(CDMALTEPhone cdmaltephone) {
        super(cdmaltephone);
        mCdmaLtePhone = cdmaltephone;
        mLteSS = new ServiceState();
        log("CdmaLteServiceStateTracker Constructors");
    }

    private boolean isInHomeSidNid(int i, int j) {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
label0:
        while(true)  {
            do
                return flag;
            while(isSidsAllZeros() || super.mHomeSystemId.length != super.mHomeNetworkId.length || i == 0);
            for(int k = 0; k < super.mHomeSystemId.length; k++)
                if(super.mHomeSystemId[k] == i && (super.mHomeNetworkId[k] == 0 || super.mHomeNetworkId[k] == 65535 || j == 0 || j == 65535 || super.mHomeNetworkId[k] == j))
                    continue label0;

            flag = false;
        }
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("CdmaLteServiceStateTracker extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" mCdmaLtePhone=").append(mCdmaLtePhone).toString());
        printwriter.println((new StringBuilder()).append(" mLteSS=").append(mLteSS).toString());
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR lookupswitch 2: default 32
    //                   5: 38
    //                   27: 64;
           goto _L1 _L2 _L3
_L1:
        super.handleMessage(message);
_L5:
        return;
_L2:
        log("handleMessage EVENT_POLL_STATE_GPRS");
        AsyncResult asyncresult = (AsyncResult)message.obj;
        handlePollStateResult(message.what, asyncresult);
        continue; /* Loop/switch isn't completed */
_L3:
        CdmaLteUiccRecords cdmalteuiccrecords = (CdmaLteUiccRecords)((PhoneBase) (super.phone)).mIccRecords;
        if(cdmalteuiccrecords != null && cdmalteuiccrecords.isProvisioned()) {
            super.mMdn = cdmalteuiccrecords.getMdn();
            super.mMin = cdmalteuiccrecords.getMin();
            parseSidNid(cdmalteuiccrecords.getSid(), cdmalteuiccrecords.getNid());
            super.mPrlVersion = cdmalteuiccrecords.getPrlVersion();
            super.mIsMinInfoReady = true;
            updateOtaspState();
        }
        pollState();
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected void handlePollStateResultMessage(int i, AsyncResult asyncresult) {
        String as[];
        int j;
        int k;
        if(i != 5)
            break MISSING_BLOCK_LABEL_118;
        log("handlePollStateResultMessage: EVENT_POLL_STATE_GPRS");
        as = (String[])(String[])asyncresult.result;
        j = 0;
        k = -1;
        if(as.length <= 0)
            break MISSING_BLOCK_LABEL_66;
        int l;
        k = Integer.parseInt(as[0]);
        if(as.length < 4 || as[3] == null)
            break MISSING_BLOCK_LABEL_66;
        l = Integer.parseInt(as[3]);
        j = l;
_L1:
        mLteSS.setRadioTechnology(j);
        mLteSS.setState(regCodeToServiceState(k));
_L2:
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        loge((new StringBuilder()).append("handlePollStateResultMessage: error parsing GprsRegistrationState: ").append(numberformatexception).toString());
          goto _L1
        super.handlePollStateResultMessage(i, asyncresult);
          goto _L2
    }

    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean flag;
        if(super.mRilRadioTechnology == 14)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CdmaLteSST] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("CDMA", (new StringBuilder()).append("[CdmaLteSST] ").append(s).toString());
    }

    protected void onSignalStrengthResult(AsyncResult asyncresult) {
        super.mSignalStrength;
        if(asyncresult.exception != null) {
            setSignalStrengthDefaultValues();
        } else {
            int ai[] = (int[])(int[])asyncresult.result;
            int i = -1;
            int j = -1;
            int k = -1;
            int l = 0x7fffffff;
            int i1 = -1;
            int j1;
            int k1;
            int l1;
            int i2;
            int j2;
            if(ai[2] > 0)
                j1 = -ai[2];
            else
                j1 = -120;
            if(ai[3] > 0)
                k1 = -ai[3];
            else
                k1 = -160;
            if(ai[4] > 0)
                l1 = -ai[4];
            else
                l1 = -120;
            if(ai[5] > 0)
                i2 = -ai[5];
            else
                i2 = -1;
            if(ai[6] > 0 && ai[6] <= 8)
                j2 = ai[6];
            else
                j2 = -1;
            if(super.mRilRadioTechnology == 14) {
                i = ai[7];
                j = ai[8];
                k = ai[9];
                l = ai[10];
                i1 = ai[11];
            }
            if(super.mRilRadioTechnology != 14)
                super.mSignalStrength = new SignalStrength(99, -1, j1, k1, l1, i2, j2, false);
            else
                super.mSignalStrength = new SignalStrength(99, -1, j1, k1, l1, i2, j2, i, j, k, l, i1, true);
        }
        super.phone.notifySignalStrength();
_L1:
        return;
        NullPointerException nullpointerexception;
        nullpointerexception;
        loge((new StringBuilder()).append("onSignalStrengthResult() Phone already destroyed: ").append(nullpointerexception).append("SignalStrength not notified").toString());
          goto _L1
    }

    protected void pollState() {
        super.pollingContext = new int[1];
        super.pollingContext[0] = 0;
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$CommandsInterface$RadioState[];

            static  {
                $SwitchMap$com$android$internal$telephony$CommandsInterface$RadioState = new int[com.android.internal.telephony.CommandsInterface.RadioState.values().length];
                NoSuchFieldError nosuchfielderror1;
                try {
                    $SwitchMap$com$android$internal$telephony$CommandsInterface$RadioState[com.android.internal.telephony.CommandsInterface.RadioState.RADIO_UNAVAILABLE.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                $SwitchMap$com$android$internal$telephony$CommandsInterface$RadioState[com.android.internal.telephony.CommandsInterface.RadioState.RADIO_OFF.ordinal()] = 2;
_L2:
                return;
                nosuchfielderror1;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.com.android.internal.telephony.CommandsInterface.RadioState[super.cm.getRadioState().ordinal()];
        JVM INSTR tableswitch 1 2: default 52
    //                   1 205
    //                   2 235;
           goto _L1 _L2 _L3
_L1:
        int ai[] = super.pollingContext;
        ai[0] = 1 + ai[0];
        super.cm.getOperator(obtainMessage(25, super.pollingContext));
        int ai1[] = super.pollingContext;
        ai1[0] = 1 + ai1[0];
        super.cm.getVoiceRegistrationState(obtainMessage(24, super.pollingContext));
        int i = android.provider.Settings.Secure.getInt(super.phone.getContext().getContentResolver(), "preferred_network_mode", 0);
        log((new StringBuilder()).append("pollState: network mode here is = ").append(i).toString());
        if(i == 7 || i == 11) {
            int ai2[] = super.pollingContext;
            ai2[0] = 1 + ai2[0];
            super.cm.getDataRegistrationState(obtainMessage(5, super.pollingContext));
        }
_L5:
        return;
_L2:
        super.newSS.setStateOutOfService();
        super.newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        super.mGotCountryCode = false;
        pollStateDone();
        continue; /* Loop/switch isn't completed */
_L3:
        super.newSS.setStateOff();
        super.newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        super.mGotCountryCode = false;
        pollStateDone();
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected void pollStateDone() {
        String s;
        String s1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        boolean flag10;
        boolean flag11;
        boolean flag12;
        ServiceState servicestate;
        CdmaCellLocation cdmacelllocation;
        CDMAPhone cdmaphone;
        boolean flag13;
        int i;
        if(mLteSS.getState() == 0) {
            super.mNewRilRadioTechnology = mLteSS.getRilRadioTechnology();
            super.mNewDataConnectionState = mLteSS.getState();
            super.newSS.setRadioTechnology(super.mNewRilRadioTechnology);
            log((new StringBuilder()).append("pollStateDone LTE/eHRPD STATE_IN_SERVICE mNewRilRadioTechnology = ").append(super.mNewRilRadioTechnology).toString());
        } else {
            super.mNewRilRadioTechnology = super.newSS.getRilRadioTechnology();
            super.mNewDataConnectionState = radioTechnologyToDataServiceState(super.mNewRilRadioTechnology);
            log((new StringBuilder()).append("pollStateDone CDMA STATE_IN_SERVICE mNewRilRadioTechnology = ").append(super.mNewRilRadioTechnology).append(" mNewDataConnectionState = ").append(super.mNewDataConnectionState).toString());
        }
        if(super.newSS.getState() == 1 && android.provider.Settings.Secure.getInt(super.phone.getContext().getContentResolver(), "preferred_network_mode", 0) == 11) {
            log("pollState: LTE Only mode");
            super.newSS.setState(mLteSS.getState());
        }
        log((new StringBuilder()).append("pollStateDone: oldSS=[").append(super.ss).append("] newSS=[").append(super.newSS).append("]").toString());
        if(super.ss.getState() != 0 && super.newSS.getState() == 0)
            flag = true;
        else
            flag = false;
        if(super.ss.getState() == 0 && super.newSS.getState() != 0)
            flag1 = true;
        else
            flag1 = false;
        if(super.mDataConnectionState != 0 && super.mNewDataConnectionState == 0)
            flag2 = true;
        else
            flag2 = false;
        if(super.mDataConnectionState == 0 && super.mNewDataConnectionState != 0)
            flag3 = true;
        else
            flag3 = false;
        if(super.mDataConnectionState != super.mNewDataConnectionState)
            flag4 = true;
        else
            flag4 = false;
        if(super.mRilRadioTechnology != super.mNewRilRadioTechnology)
            flag5 = true;
        else
            flag5 = false;
        if(!super.newSS.equals(super.ss))
            flag6 = true;
        else
            flag6 = false;
        if(!super.ss.getRoaming() && super.newSS.getRoaming())
            flag7 = true;
        else
            flag7 = false;
        if(super.ss.getRoaming() && !super.newSS.getRoaming())
            flag8 = true;
        else
            flag8 = false;
        if(!super.newCellLoc.equals(super.cellLoc))
            flag9 = true;
        else
            flag9 = false;
        if(super.mNewDataConnectionState == 0 && (super.mRilRadioTechnology == 14 && super.mNewRilRadioTechnology == 13 || super.mRilRadioTechnology == 13 && super.mNewRilRadioTechnology == 14))
            flag10 = true;
        else
            flag10 = false;
        if((super.mNewRilRadioTechnology == 14 || super.mNewRilRadioTechnology == 13) && super.mRilRadioTechnology != 14 && super.mRilRadioTechnology != 13)
            flag11 = true;
        else
            flag11 = false;
        if(super.mNewRilRadioTechnology >= 4 && super.mNewRilRadioTechnology <= 8)
            flag12 = true;
        else
            flag12 = false;
        log((new StringBuilder()).append("pollStateDone: hasRegistered=").append(flag).append(" hasDeegistered=").append(flag1).append(" hasCdmaDataConnectionAttached=").append(flag2).append(" hasCdmaDataConnectionDetached=").append(flag3).append(" hasCdmaDataConnectionChanged=").append(flag4).append(" hasRadioTechnologyChanged = ").append(flag5).append(" hasChanged=").append(flag6).append(" hasRoamingOn=").append(flag7).append(" hasRoamingOff=").append(flag8).append(" hasLocationChanged=").append(flag9).append(" has4gHandoff = ").append(flag10).append(" hasMultiApnSupport=").append(flag11).append(" hasLostMultiApnSupport=").append(flag12).toString());
        if(super.ss.getState() != super.newSS.getState() || super.mDataConnectionState != super.mNewDataConnectionState) {
            Object aobj[] = new Object[4];
            aobj[0] = Integer.valueOf(super.ss.getState());
            aobj[1] = Integer.valueOf(super.mDataConnectionState);
            aobj[2] = Integer.valueOf(super.newSS.getState());
            aobj[3] = Integer.valueOf(super.mNewDataConnectionState);
            EventLog.writeEvent(50116, aobj);
        }
        servicestate = super.ss;
        super.ss = super.newSS;
        super.newSS = servicestate;
        super.newSS.setStateOutOfService();
        mLteSS.setStateOutOfService();
        if(flag11 && (((PhoneBase) (super.phone)).mDataConnectionTracker instanceof CdmaDataConnectionTracker)) {
            log("GsmDataConnectionTracker Created");
            ((PhoneBase) (super.phone)).mDataConnectionTracker.dispose();
            super.phone.mDataConnectionTracker = new GsmDataConnectionTracker(mCdmaLtePhone);
        }
        if(flag12 && (((PhoneBase) (super.phone)).mDataConnectionTracker instanceof GsmDataConnectionTracker)) {
            log("GsmDataConnectionTracker disposed");
            ((PhoneBase) (super.phone)).mDataConnectionTracker.dispose();
            super.phone.mDataConnectionTracker = new CdmaDataConnectionTracker(super.phone);
        }
        cdmacelllocation = super.cellLoc;
        super.cellLoc = super.newCellLoc;
        super.newCellLoc = cdmacelllocation;
        super.mDataConnectionState = super.mNewDataConnectionState;
        super.mRilRadioTechnology = super.mNewRilRadioTechnology;
        super.mNewRilRadioTechnology = 0;
        super.newSS.setStateOutOfService();
        if(flag5)
            super.phone.setSystemProperty("gsm.network.type", ServiceState.rilRadioTechnologyToString(super.mRilRadioTechnology));
        if(flag)
            super.mNetworkAttachedRegistrants.notifyRegistrants();
        if(!flag6) goto _L2; else goto _L1
_L1:
        if(super.phone.isEriFileLoaded()) {
            String s5;
            if(super.ss.getState() == 0)
                s5 = super.phone.getCdmaEriText();
            else
            if(super.ss.getState() == 3) {
                s5 = ((PhoneBase) (super.phone)).mIccRecords.getServiceProviderName();
                if(TextUtils.isEmpty(s5))
                    s5 = SystemProperties.get("ro.cdma.home.operator.alpha");
            } else {
                s5 = super.phone.getContext().getText(0x1040109).toString();
            }
            super.ss.setOperatorAlphaLong(s5);
        }
        if(super.phone.getIccCard().getState() == com.android.internal.telephony.IccCard.State.READY) {
            flag13 = ((CdmaLteUiccRecords)((PhoneBase) (super.phone)).mIccRecords).getCsimSpnDisplayCondition();
            i = super.ss.getCdmaEriIconIndex();
            if(flag13 && i == 1 && isInHomeSidNid(super.ss.getSystemId(), super.ss.getNetworkId()))
                super.ss.setOperatorAlphaLong(((PhoneBase) (super.phone)).mIccRecords.getServiceProviderName());
        }
        super.phone.setSystemProperty("gsm.operator.alpha", super.ss.getOperatorAlphaLong());
        s = SystemProperties.get("gsm.operator.numeric", "");
        s1 = super.ss.getOperatorNumeric();
        super.phone.setSystemProperty("gsm.operator.numeric", s1);
        if(s1 != null) goto _L4; else goto _L3
_L3:
        log("operatorNumeric is null");
        super.phone.setSystemProperty("gsm.operator.iso-country", "");
        super.mGotCountryCode = false;
_L5:
        cdmaphone = super.phone;
        String s2;
        StringIndexOutOfBoundsException stringindexoutofboundsexception;
        String s3;
        NumberFormatException numberformatexception;
        String s4;
        if(super.ss.getRoaming())
            s3 = "true";
        else
            s3 = "false";
        cdmaphone.setSystemProperty("gsm.operator.isroaming", s3);
        updateSpnDisplay();
        super.phone.notifyServiceStateChanged(super.ss);
_L2:
        if(flag2 || flag10)
            super.mAttachedRegistrants.notifyRegistrants();
        if(flag3)
            super.mDetachedRegistrants.notifyRegistrants();
        if(flag4 || flag5)
            super.phone.notifyDataConnection(null);
        if(flag7)
            super.mRoamingOnRegistrants.notifyRegistrants();
        if(flag8)
            super.mRoamingOffRegistrants.notifyRegistrants();
        if(flag9)
            super.phone.notifyLocationChanged();
        return;
_L4:
        s2 = "";
        s1.substring(0, 3);
        s4 = MccTable.countryCodeForMcc(Integer.parseInt(s1.substring(0, 3)));
        s2 = s4;
_L6:
        super.phone.setSystemProperty("gsm.operator.iso-country", s2);
        super.mGotCountryCode = true;
        if(shouldFixTimeZoneNow(super.phone, s1, s, super.mNeedFixZone))
            fixTimeZone(s2);
          goto _L5
        numberformatexception;
        loge((new StringBuilder()).append("countryCodeForMcc error").append(numberformatexception).toString());
          goto _L6
        stringindexoutofboundsexception;
        loge((new StringBuilder()).append("countryCodeForMcc error").append(stringindexoutofboundsexception).toString());
          goto _L6
    }

    protected void setCdmaTechnology(int i) {
        super.newSS.setRadioTechnology(i);
    }

    protected void setSignalStrengthDefaultValues() {
        super.mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0x7fffffff, -1, false);
    }

    CDMALTEPhone mCdmaLtePhone;
    private ServiceState mLteSS;
}
