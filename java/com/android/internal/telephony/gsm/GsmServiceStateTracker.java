// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.app.*;
import android.content.*;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.*;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.*;
import com.android.internal.telephony.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package com.android.internal.telephony.gsm:
//            GSMPhone, GsmCallTracker, GsmCall, SIMRecords, 
//            SpnOverride

final class GsmServiceStateTracker extends ServiceStateTracker {
    static class Injector {

        static String getPlmn(GsmServiceStateTracker gsmservicestatetracker, String s) {
            String s1 = ((SIMRecords)((PhoneBase) (gsmservicestatetracker.phone)).mIccRecords).mSpnOverride.getSpn(((ServiceStateTracker) (gsmservicestatetracker)).ss.getOperatorNumeric());
            if(!TextUtils.isEmpty(s1))
                s = s1;
            return s;
        }

        static String getSpn(GsmServiceStateTracker gsmservicestatetracker, String s) {
            String s1 = ((SIMRecords)((PhoneBase) (gsmservicestatetracker.phone)).mIccRecords).mSpnOverride.getSpn(((PhoneBase) (gsmservicestatetracker.phone)).mIccRecords.getOperatorNumeric());
            if(!TextUtils.isEmpty(s1))
                s = s1;
            return s;
        }

        Injector() {
        }
    }


    public GsmServiceStateTracker(GSMPhone gsmphone) {
        boolean flag = false;
        super();
        gprsState = 1;
        newGPRSState = 1;
        mMaxDataCalls = 1;
        mNewMaxDataCalls = 1;
        mReasonDataDenied = -1;
        mNewReasonDataDenied = -1;
        mGsmRoaming = false;
        mDataRoaming = false;
        mEmergencyOnly = false;
        mNeedFixZoneAfterNitz = false;
        mGotCountryCode = false;
        mNitzUpdatedTime = false;
        mStartedGprsRegCheck = false;
        mReportedGprsNoReg = false;
        curSpn = null;
        curPlmn = null;
        curSpnRule = 0;
        mIntentReceiver = new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals("android.intent.action.LOCALE_CHANGED"))
                    updateSpnDisplay();
            }

            final GsmServiceStateTracker this$0;

             {
                this$0 = GsmServiceStateTracker.this;
                super();
            }
        };
        mAutoTimeObserver = new ContentObserver(new Handler()) {

            public void onChange(boolean flag1) {
                Log.i("GsmServiceStateTracker", "Auto time state changed");
                revertToNitzTime();
            }

            final GsmServiceStateTracker this$0;

             {
                this$0 = GsmServiceStateTracker.this;
                super(handler);
            }
        };
        mAutoTimeZoneObserver = new ContentObserver(new Handler()) {

            public void onChange(boolean flag1) {
                Log.i("GsmServiceStateTracker", "Auto time zone state changed");
                revertToNitzTimeZone();
            }

            final GsmServiceStateTracker this$0;

             {
                this$0 = GsmServiceStateTracker.this;
                super(handler);
            }
        };
        phone = gsmphone;
        super.cm = ((PhoneBase) (gsmphone)).mCM;
        super.ss = new ServiceState();
        super.newSS = new ServiceState();
        cellLoc = new GsmCellLocation();
        newCellLoc = new GsmCellLocation();
        super.mSignalStrength = new SignalStrength();
        mWakeLock = ((PowerManager)gsmphone.getContext().getSystemService("power")).newWakeLock(1, "ServiceStateTracker");
        super.cm.registerForAvailable(this, 13, null);
        super.cm.registerForRadioStateChanged(this, 1, null);
        super.cm.registerForVoiceNetworkStateChanged(this, 2, null);
        super.cm.setOnNITZTime(this, 11, null);
        super.cm.setOnSignalStrengthUpdate(this, 12, null);
        super.cm.setOnRestrictedStateChanged(this, 23, null);
        gsmphone.getIccCard().registerForReady(this, 17, null);
        if(android.provider.Settings.System.getInt(gsmphone.getContext().getContentResolver(), "airplane_mode_on", 0) <= 0)
            flag = true;
        super.mDesiredPowerState = flag;
        cr = gsmphone.getContext().getContentResolver();
        cr.registerContentObserver(android.provider.Settings.System.getUriFor("auto_time"), true, mAutoTimeObserver);
        cr.registerContentObserver(android.provider.Settings.System.getUriFor("auto_time_zone"), true, mAutoTimeZoneObserver);
        setSignalStrengthDefaultValues();
        mNeedToRegForSimLoaded = true;
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.LOCALE_CHANGED");
        gsmphone.getContext().registerReceiver(mIntentReceiver, intentfilter);
        gsmphone.notifyOtaspChanged(3);
    }

    private static String displayNameFor(int i) {
        int j = i / 1000 / 60;
        char ac[] = new char[9];
        ac[0] = 'G';
        ac[1] = 'M';
        ac[2] = 'T';
        int k;
        int l;
        if(j < 0) {
            ac[3] = '-';
            j = -j;
        } else {
            ac[3] = '+';
        }
        k = j / 60;
        l = j % 60;
        ac[4] = (char)(48 + k / 10);
        ac[5] = (char)(48 + k % 10);
        ac[6] = ':';
        ac[7] = (char)(48 + l / 10);
        ac[8] = (char)(48 + l % 10);
        return new String(ac);
    }

    private TimeZone findTimeZone(int i, boolean flag, long l) {
        int j = i;
        if(flag)
            j += 4480;
        String as[] = TimeZone.getAvailableIDs(j);
        TimeZone timezone = null;
        Date date = new Date(l);
        int k = as.length;
        int i1 = 0;
        do {
label0:
            {
                if(i1 < k) {
                    TimeZone timezone1 = TimeZone.getTimeZone(as[i1]);
                    if(timezone1.getOffset(l) != i || timezone1.inDaylightTime(date) != flag)
                        break label0;
                    timezone = timezone1;
                }
                return timezone;
            }
            i1++;
        } while(true);
    }

    private boolean getAutoTime() {
        boolean flag = true;
        int i = android.provider.Settings.System.getInt(phone.getContext().getContentResolver(), "auto_time");
        if(i <= 0)
            flag = false;
_L2:
        return flag;
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        settingnotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private boolean getAutoTimeZone() {
        boolean flag = true;
        int i = android.provider.Settings.System.getInt(phone.getContext().getContentResolver(), "auto_time_zone");
        if(i <= 0)
            flag = false;
_L2:
        return flag;
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        settingnotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private TimeZone getNitzTimeZone(int i, boolean flag, long l) {
        TimeZone timezone = findTimeZone(i, flag, l);
        Object obj;
        if(timezone == null) {
            StringBuilder stringbuilder;
            boolean flag1;
            if(!flag)
                flag1 = true;
            else
                flag1 = false;
            timezone = findTimeZone(i, flag1, l);
        }
        stringbuilder = (new StringBuilder()).append("getNitzTimeZone returning ");
        if(timezone == null)
            obj = timezone;
        else
            obj = timezone.getID();
        log(stringbuilder.append(obj).toString());
        return timezone;
    }

    private boolean isGprsConsistent(int i, int j) {
        boolean flag;
        if(j != 0 || i == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isRoamingBetweenOperators(boolean flag, ServiceState servicestate) {
        boolean flag1;
        flag1 = true;
        String s = SystemProperties.get("gsm.sim.operator.alpha", "empty");
        String s1 = servicestate.getOperatorAlphaLong();
        String s2 = servicestate.getOperatorAlphaShort();
        boolean flag2;
        boolean flag3;
        String s3;
        String s4;
        boolean flag4;
        boolean flag5;
        if(s1 != null && s.equals(s1))
            flag2 = flag1;
        else
            flag2 = false;
        if(s2 != null && s.equals(s2))
            flag3 = flag1;
        else
            flag3 = false;
        s3 = SystemProperties.get("gsm.sim.operator.numeric", "");
        s4 = servicestate.getOperatorNumeric();
        flag4 = true;
        flag5 = s3.substring(0, 3).equals(s4.substring(0, 3));
        flag4 = flag5;
_L2:
        if(!flag || flag4 && (flag2 || flag3))
            flag1 = false;
        return flag1;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void onRestrictedStateChanged(AsyncResult asyncresult) {
        boolean flag = true;
        RestrictedState restrictedstate = new RestrictedState();
        log((new StringBuilder()).append("onRestrictedStateChanged: E rs ").append(super.mRestrictedState).toString());
        if(asyncresult.exception == null) {
            int i = ((int[])(int[])asyncresult.result)[0];
            boolean flag1;
            if((i & 1) != 0 || (i & 4) != 0)
                flag1 = flag;
            else
                flag1 = false;
            restrictedstate.setCsEmergencyRestricted(flag1);
            if(phone.getIccCard().getState() == com.android.internal.telephony.IccCard.State.READY) {
                boolean flag2;
                if((i & 2) != 0 || (i & 4) != 0)
                    flag2 = flag;
                else
                    flag2 = false;
                restrictedstate.setCsNormalRestricted(flag2);
                if((i & 0x10) == 0)
                    flag = false;
                restrictedstate.setPsRestricted(flag);
            }
            log((new StringBuilder()).append("onRestrictedStateChanged: new rs ").append(restrictedstate).toString());
            if(!super.mRestrictedState.isPsRestricted() && restrictedstate.isPsRestricted()) {
                super.mPsRestrictEnabledRegistrants.notifyRegistrants();
                setNotification(1001);
            } else
            if(super.mRestrictedState.isPsRestricted() && !restrictedstate.isPsRestricted()) {
                super.mPsRestrictDisabledRegistrants.notifyRegistrants();
                setNotification(1002);
            }
            if(super.mRestrictedState.isCsRestricted()) {
                if(!restrictedstate.isCsRestricted())
                    setNotification(1004);
                else
                if(!restrictedstate.isCsNormalRestricted())
                    setNotification(1006);
                else
                if(!restrictedstate.isCsEmergencyRestricted())
                    setNotification(1005);
            } else
            if(super.mRestrictedState.isCsEmergencyRestricted() && !super.mRestrictedState.isCsNormalRestricted()) {
                if(!restrictedstate.isCsRestricted())
                    setNotification(1004);
                else
                if(restrictedstate.isCsRestricted())
                    setNotification(1003);
                else
                if(restrictedstate.isCsNormalRestricted())
                    setNotification(1005);
            } else
            if(!super.mRestrictedState.isCsEmergencyRestricted() && super.mRestrictedState.isCsNormalRestricted()) {
                if(!restrictedstate.isCsRestricted())
                    setNotification(1004);
                else
                if(restrictedstate.isCsRestricted())
                    setNotification(1003);
                else
                if(restrictedstate.isCsEmergencyRestricted())
                    setNotification(1006);
            } else
            if(restrictedstate.isCsRestricted())
                setNotification(1003);
            else
            if(restrictedstate.isCsEmergencyRestricted())
                setNotification(1006);
            else
            if(restrictedstate.isCsNormalRestricted())
                setNotification(1005);
            super.mRestrictedState = restrictedstate;
        }
        log((new StringBuilder()).append("onRestrictedStateChanged: X rs ").append(super.mRestrictedState).toString());
    }

    private void onSignalStrengthResult(AsyncResult asyncresult) {
        SignalStrength signalstrength = super.mSignalStrength;
        int i = 99;
        int j = -1;
        int k = -1;
        int l = -1;
        int i1 = 0x7fffffff;
        int j1 = -1;
        if(asyncresult.exception != null) {
            setSignalStrengthDefaultValues();
        } else {
            int ai[] = (int[])(int[])asyncresult.result;
            if(ai.length != 0) {
                i = ai[0];
                j = ai[7];
                k = ai[8];
                l = ai[9];
                i1 = ai[10];
                j1 = ai[11];
            } else {
                loge("Bogus signal strength response");
                i = 99;
            }
        }
        super.mSignalStrength = new SignalStrength(i, -1, -1, -1, -1, -1, -1, j, k, l, i1, j1, true);
        if(super.mSignalStrength.equals(signalstrength))
            break MISSING_BLOCK_LABEL_93;
        phone.notifySignalStrength();
_L1:
        return;
        NullPointerException nullpointerexception;
        nullpointerexception;
        log((new StringBuilder()).append("onSignalStrengthResult() Phone already destroyed: ").append(nullpointerexception).append("SignalStrength not notified").toString());
          goto _L1
    }

    private void pollState() {
        super.pollingContext = new int[1];
        super.pollingContext[0] = 0;
        class _cls4 {

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

        _cls4..SwitchMap.com.android.internal.telephony.CommandsInterface.RadioState[super.cm.getRadioState().ordinal()];
        JVM INSTR tableswitch 1 2: default 52
    //                   1 182
    //                   2 217;
           goto _L1 _L2 _L3
_L1:
        int ai[] = super.pollingContext;
        ai[0] = 1 + ai[0];
        super.cm.getOperator(obtainMessage(6, super.pollingContext));
        int ai1[] = super.pollingContext;
        ai1[0] = 1 + ai1[0];
        super.cm.getDataRegistrationState(obtainMessage(5, super.pollingContext));
        int ai2[] = super.pollingContext;
        ai2[0] = 1 + ai2[0];
        super.cm.getVoiceRegistrationState(obtainMessage(4, super.pollingContext));
        int ai3[] = super.pollingContext;
        ai3[0] = 1 + ai3[0];
        super.cm.getNetworkSelectionMode(obtainMessage(14, super.pollingContext));
_L5:
        return;
_L2:
        super.newSS.setStateOutOfService();
        newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        mGotCountryCode = false;
        mNitzUpdatedTime = false;
        pollStateDone();
        continue; /* Loop/switch isn't completed */
_L3:
        super.newSS.setStateOff();
        newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        mGotCountryCode = false;
        mNitzUpdatedTime = false;
        pollStateDone();
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void pollStateDone() {
        String s;
        String s1;
        log((new StringBuilder()).append("Poll ServiceState done:  oldSS=[").append(super.ss).append("] newSS=[").append(super.newSS).append("] oldGprs=").append(gprsState).append(" newData=").append(newGPRSState).append(" oldMaxDataCalls=").append(mMaxDataCalls).append(" mNewMaxDataCalls=").append(mNewMaxDataCalls).append(" oldReasonDataDenied=").append(mReasonDataDenied).append(" mNewReasonDataDenied=").append(mNewReasonDataDenied).append(" oldType=").append(ServiceState.rilRadioTechnologyToString(super.mRilRadioTechnology)).append(" newType=").append(ServiceState.rilRadioTechnologyToString(super.mNewRilRadioTechnology)).toString());
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        ServiceState servicestate;
        GsmCellLocation gsmcelllocation;
        int i;
        GSMPhone gsmphone;
        if(super.ss.getState() != 0 && super.newSS.getState() == 0)
            flag = true;
        else
            flag = false;
        if(super.ss.getState() != 0 || super.newSS.getState() == 0);
        if(gprsState != 0 && newGPRSState == 0)
            flag1 = true;
        else
            flag1 = false;
        if(gprsState == 0 && newGPRSState != 0)
            flag2 = true;
        else
            flag2 = false;
        if(super.mRilRadioTechnology != super.mNewRilRadioTechnology)
            flag3 = true;
        else
            flag3 = false;
        if(!super.newSS.equals(super.ss))
            flag4 = true;
        else
            flag4 = false;
        if(!super.ss.getRoaming() && super.newSS.getRoaming())
            flag5 = true;
        else
            flag5 = false;
        if(super.ss.getRoaming() && !super.newSS.getRoaming())
            flag6 = true;
        else
            flag6 = false;
        if(!newCellLoc.equals(cellLoc))
            flag7 = true;
        else
            flag7 = false;
        if(super.ss.getState() != super.newSS.getState() || gprsState != newGPRSState) {
            Object aobj[] = new Object[4];
            aobj[0] = Integer.valueOf(super.ss.getState());
            aobj[1] = Integer.valueOf(gprsState);
            aobj[2] = Integer.valueOf(super.newSS.getState());
            aobj[3] = Integer.valueOf(newGPRSState);
            EventLog.writeEvent(50114, aobj);
        }
        servicestate = super.ss;
        super.ss = super.newSS;
        super.newSS = servicestate;
        super.newSS.setStateOutOfService();
        gsmcelllocation = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = gsmcelllocation;
        if(flag3) {
            int j = -1;
            GsmCellLocation gsmcelllocation1 = (GsmCellLocation)phone.getCellLocation();
            if(gsmcelllocation1 != null)
                j = gsmcelllocation1.getCid();
            Object aobj1[] = new Object[3];
            aobj1[0] = Integer.valueOf(j);
            aobj1[1] = Integer.valueOf(super.mRilRadioTechnology);
            aobj1[2] = Integer.valueOf(super.mNewRilRadioTechnology);
            EventLog.writeEvent(50112, aobj1);
            log((new StringBuilder()).append("RAT switched ").append(ServiceState.rilRadioTechnologyToString(super.mRilRadioTechnology)).append(" -> ").append(ServiceState.rilRadioTechnologyToString(super.mNewRilRadioTechnology)).append(" at cell ").append(j).toString());
        }
        gprsState = newGPRSState;
        mReasonDataDenied = mNewReasonDataDenied;
        mMaxDataCalls = mNewMaxDataCalls;
        super.mRilRadioTechnology = super.mNewRilRadioTechnology;
        super.mNewRilRadioTechnology = 0;
        super.newSS.setStateOutOfService();
        if(flag3)
            phone.setSystemProperty("gsm.network.type", ServiceState.rilRadioTechnologyToString(super.mRilRadioTechnology));
        if(flag) {
            super.mNetworkAttachedRegistrants.notifyRegistrants();
            log((new StringBuilder()).append("pollStateDone: registering current mNitzUpdatedTime=").append(mNitzUpdatedTime).append(" changing to false").toString());
            mNitzUpdatedTime = false;
        }
        if(!flag4) goto _L2; else goto _L1
_L1:
        updateSpnDisplay();
        phone.setSystemProperty("gsm.operator.alpha", super.ss.getOperatorAlphaLong());
        s = SystemProperties.get("gsm.operator.numeric", "");
        s1 = super.ss.getOperatorNumeric();
        phone.setSystemProperty("gsm.operator.numeric", s1);
        if(!TextUtils.isEmpty(s1)) goto _L4; else goto _L3
_L3:
        log("operatorNumeric is null");
        phone.setSystemProperty("gsm.operator.iso-country", "");
        mGotCountryCode = false;
        mNitzUpdatedTime = false;
_L5:
        gsmphone = phone;
        String s2;
        String s3;
        StringIndexOutOfBoundsException stringindexoutofboundsexception;
        String s4;
        TimeZone timezone;
        String s5;
        long l;
        long l1;
        long l2;
        boolean flag8;
        ArrayList arraylist;
        TimeZone timezone1;
        NumberFormatException numberformatexception;
        String s6;
        if(super.ss.getRoaming())
            s5 = "true";
        else
            s5 = "false";
        gsmphone.setSystemProperty("gsm.operator.isroaming", s5);
        phone.notifyServiceStateChanged(super.ss);
_L2:
        if(flag1)
            super.mAttachedRegistrants.notifyRegistrants();
        if(flag2)
            super.mDetachedRegistrants.notifyRegistrants();
        if(flag3)
            phone.notifyDataConnection("nwTypeChanged");
        if(flag5)
            super.mRoamingOnRegistrants.notifyRegistrants();
        if(flag6)
            super.mRoamingOffRegistrants.notifyRegistrants();
        if(flag7)
            phone.notifyLocationChanged();
        if(!isGprsConsistent(gprsState, super.ss.getState())) {
            if(!mStartedGprsRegCheck && !mReportedGprsNoReg) {
                mStartedGprsRegCheck = true;
                i = android.provider.Settings.Secure.getInt(phone.getContext().getContentResolver(), "gprs_register_check_period_ms", 60000);
                sendMessageDelayed(obtainMessage(22), i);
            }
        } else {
            mReportedGprsNoReg = false;
        }
        return;
_L4:
        s2 = "";
        s3 = s1.substring(0, 3);
        s6 = MccTable.countryCodeForMcc(Integer.parseInt(s3));
        s2 = s6;
_L6:
        phone.setSystemProperty("gsm.operator.iso-country", s2);
        mGotCountryCode = true;
        if(!mNitzUpdatedTime && !s3.equals("000") && !TextUtils.isEmpty(s2) && getAutoTimeZone()) {
            if(SystemProperties.getBoolean("telephony.test.ignore.nitz", false) && (1L & SystemClock.uptimeMillis()) == 0L)
                flag8 = true;
            else
                flag8 = false;
            arraylist = TimeUtils.getTimeZonesWithUniqueOffsets(s2);
            if(arraylist.size() == 1 || flag8) {
                timezone1 = (TimeZone)arraylist.get(0);
                log((new StringBuilder()).append("pollStateDone: no nitz but one TZ for iso-cc=").append(s2).append(" with zone.getID=").append(timezone1.getID()).append(" testOneUniqueOffsetPath=").append(flag8).toString());
                setAndBroadcastNetworkSetTimeZone(timezone1.getID());
            } else {
                log((new StringBuilder()).append("pollStateDone: there are ").append(arraylist.size()).append(" unique offsets for iso-cc='").append(s2).append(" testOneUniqueOffsetPath=").append(flag8).append("', do nothing").toString());
            }
        }
        if(shouldFixTimeZoneNow(phone, s1, s, mNeedFixZoneAfterNitz)) {
            s4 = SystemProperties.get("persist.sys.timezone");
            log((new StringBuilder()).append("pollStateDone: fix time zone zoneName='").append(s4).append("' mZoneOffset=").append(mZoneOffset).append(" mZoneDst=").append(mZoneDst).append(" iso-cc='").append(s2).append("' iso-cc-idx=").append(Arrays.binarySearch(GMT_COUNTRY_CODES, s2)).toString());
            if(mZoneOffset == 0 && !mZoneDst && s4 != null && s4.length() > 0 && Arrays.binarySearch(GMT_COUNTRY_CODES, s2) < 0) {
                timezone = TimeZone.getDefault();
                if(mNeedFixZoneAfterNitz) {
                    l = System.currentTimeMillis();
                    l1 = timezone.getOffset(l);
                    log((new StringBuilder()).append("pollStateDone: tzOffset=").append(l1).append(" ltod=").append(TimeUtils.logTimeOfDay(l)).toString());
                    if(getAutoTime()) {
                        l2 = l - l1;
                        log((new StringBuilder()).append("pollStateDone: adj ltod=").append(TimeUtils.logTimeOfDay(l2)).toString());
                        setAndBroadcastNetworkSetTime(l2);
                    } else {
                        mSavedTime = mSavedTime - l1;
                    }
                }
                log("pollStateDone: using default TimeZone");
            } else
            if(s2.equals("")) {
                timezone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
                log("pollStateDone: using NITZ TimeZone");
            } else {
                timezone = TimeUtils.getTimeZone(mZoneOffset, mZoneDst, mZoneTime, s2);
                log("pollStateDone: using getTimeZone(off, dst, time, iso)");
            }
            mNeedFixZoneAfterNitz = false;
            if(timezone != null) {
                log((new StringBuilder()).append("pollStateDone: zone != null zone.getID=").append(timezone.getID()).toString());
                if(getAutoTimeZone())
                    setAndBroadcastNetworkSetTimeZone(timezone.getID());
                saveNitzTimeZone(timezone.getID());
            } else {
                log("pollStateDone: zone == null");
            }
        }
          goto _L5
        numberformatexception;
        loge((new StringBuilder()).append("pollStateDone: countryCodeForMcc error").append(numberformatexception).toString());
          goto _L6
        stringindexoutofboundsexception;
        loge((new StringBuilder()).append("pollStateDone: countryCodeForMcc error").append(stringindexoutofboundsexception).toString());
          goto _L6
    }

    private void queueNextSignalStrengthPoll() {
        if(!super.dontPollSignalStrength) {
            Message message = obtainMessage();
            message.what = 10;
            sendMessageDelayed(message, 20000L);
        }
    }

    private boolean regCodeIsRoaming(int i) {
        boolean flag;
        if(5 == i)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private int regCodeToServiceState(int i) {
        int j = 1;
        i;
        JVM INSTR tableswitch 0 14: default 76
    //                   0 100
    //                   1 102
    //                   2 100
    //                   3 100
    //                   4 100
    //                   5 107
    //                   6 76
    //                   7 76
    //                   8 76
    //                   9 76
    //                   10 100
    //                   11 76
    //                   12 100
    //                   13 100
    //                   14 100;
           goto _L1 _L2 _L3 _L2 _L2 _L2 _L4 _L1 _L1 _L1 _L1 _L2 _L1 _L2 _L2 _L2
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        loge((new StringBuilder()).append("regCodeToServiceState: unexpected service state ").append(i).toString());
_L6:
        return j;
_L3:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 0;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void revertToNitzTime() {
        if(android.provider.Settings.System.getInt(phone.getContext().getContentResolver(), "auto_time", 0) != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        log((new StringBuilder()).append("Reverting to NITZ Time: mSavedTime=").append(mSavedTime).append(" mSavedAtTime=").append(mSavedAtTime).toString());
        if(mSavedTime != 0L && mSavedAtTime != 0L)
            setAndBroadcastNetworkSetTime(mSavedTime + (SystemClock.elapsedRealtime() - mSavedAtTime));
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void revertToNitzTimeZone() {
        if(android.provider.Settings.System.getInt(phone.getContext().getContentResolver(), "auto_time_zone", 0) != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        log((new StringBuilder()).append("Reverting to NITZ TimeZone: tz='").append(mSavedTimeZone).toString());
        if(mSavedTimeZone != null)
            setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void saveNitzTime(long l) {
        mSavedTime = l;
        mSavedAtTime = SystemClock.elapsedRealtime();
    }

    private void saveNitzTimeZone(String s) {
        mSavedTimeZone = s;
    }

    private void setAndBroadcastNetworkSetTime(long l) {
        log((new StringBuilder()).append("setAndBroadcastNetworkSetTime: time=").append(l).append("ms").toString());
        SystemClock.setCurrentTimeMillis(l);
        Intent intent = new Intent("android.intent.action.NETWORK_SET_TIME");
        intent.addFlags(0x20000000);
        intent.putExtra("time", l);
        phone.getContext().sendStickyBroadcast(intent);
    }

    private void setAndBroadcastNetworkSetTimeZone(String s) {
        log((new StringBuilder()).append("setAndBroadcastNetworkSetTimeZone: setTimeZone=").append(s).toString());
        ((AlarmManager)phone.getContext().getSystemService("alarm")).setTimeZone(s);
        Intent intent = new Intent("android.intent.action.NETWORK_SET_TIMEZONE");
        intent.addFlags(0x20000000);
        intent.putExtra("time-zone", s);
        phone.getContext().sendStickyBroadcast(intent);
        log((new StringBuilder()).append("setAndBroadcastNetworkSetTimeZone: call alarm.setTimeZone and broadcast zoneId=").append(s).toString());
    }

    private void setNotification(int i) {
        Context context;
        Object obj;
        CharSequence charsequence;
        char c;
        log((new StringBuilder()).append("setNotification: create notification ").append(i).toString());
        context = phone.getContext();
        mNotification = new Notification();
        mNotification.when = System.currentTimeMillis();
        mNotification.flags = 16;
        mNotification.icon = 0x108008a;
        Intent intent = new Intent();
        mNotification.contentIntent = PendingIntent.getActivity(context, 0, intent, 0x10000000);
        obj = "";
        charsequence = context.getText(0x10400eb);
        c = '\u03E7';
        i;
        JVM INSTR tableswitch 1001 1006: default 156
    //                   1001 254
    //                   1002 271
    //                   1003 279
    //                   1004 156
    //                   1005 291
    //                   1006 303;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_303;
_L7:
        log((new StringBuilder()).append("setNotification: put notification ").append(charsequence).append(" / ").append(obj).toString());
        mNotification.tickerText = charsequence;
        mNotification.setLatestEventInfo(context, charsequence, ((CharSequence) (obj)), mNotification.contentIntent);
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        if(i == 1002 || i == 1004)
            notificationmanager.cancel(c);
        else
            notificationmanager.notify(c, mNotification);
        return;
_L2:
        c = '\u0378';
        obj = context.getText(0x10400ec);
          goto _L7
_L3:
        c = '\u0378';
          goto _L7
_L4:
        obj = context.getText(0x10400ef);
          goto _L7
_L5:
        obj = context.getText(0x10400ee);
          goto _L7
        obj = context.getText(0x10400ed);
          goto _L7
    }

    private void setSignalStrengthDefaultValues() {
        super.mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0x7fffffff, -1, true);
    }

    private void setTimeFromNITZString(String s, long l) {
        long l1 = SystemClock.elapsedRealtime();
        log((new StringBuilder()).append("NITZ: ").append(s).append(",").append(l).append(" start=").append(l1).append(" delay=").append(l1 - l).toString());
        Calendar calendar;
        String as[];
        calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.clear();
        calendar.set(16, 0);
        as = s.split("[/:,+-]");
        calendar.set(1, 2000 + Integer.parseInt(as[0]));
        calendar.set(2, -1 + Integer.parseInt(as[1]));
        calendar.set(5, Integer.parseInt(as[2]));
        calendar.set(10, Integer.parseInt(as[3]));
        calendar.set(12, Integer.parseInt(as[4]));
        calendar.set(13, Integer.parseInt(as[5]));
        if(s.indexOf('-') != -1) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L32:
        int i = Integer.parseInt(as[6]);
        if(as.length < 8) goto _L4; else goto _L3
_L3:
        int j = Integer.parseInt(as[7]);
          goto _L5
_L30:
        byte byte0;
        int k;
        TimeZone timezone;
        String s1;
        k = 1000 * (60 * (15 * (byte0 * i)));
        timezone = null;
        if(as.length >= 9)
            timezone = TimeZone.getTimeZone(as[8].replace('!', '/'));
        s1 = SystemProperties.get("gsm.operator.iso-country");
        if(timezone != null || !mGotCountryCode) goto _L7; else goto _L6
_L6:
        if(s1 == null || s1.length() <= 0) goto _L9; else goto _L8
_L8:
        if(j == 0) goto _L11; else goto _L10
_L10:
        boolean flag5 = true;
_L33:
        long l4 = calendar.getTimeInMillis();
        timezone = TimeUtils.getTimeZone(k, flag5, l4, s1);
_L7:
        if(timezone == null || mZoneOffset != k) goto _L13; else goto _L12
_L12:
        boolean flag2 = mZoneDst;
        if(j == 0) goto _L15; else goto _L14
_L14:
        boolean flag3 = true;
          goto _L16
_L13:
        mNeedFixZoneAfterNitz = true;
        mZoneOffset = k;
        if(j == 0) goto _L18; else goto _L17
_L17:
        boolean flag1 = true;
_L23:
        mZoneDst = flag1;
        mZoneTime = calendar.getTimeInMillis();
_L31:
        String s2;
        if(timezone != null) {
            if(getAutoTimeZone())
                setAndBroadcastNetworkSetTimeZone(timezone.getID());
            saveNitzTimeZone(timezone.getID());
        }
        s2 = SystemProperties.get("gsm.ignore-nitz");
        if(s2 == null || !s2.equals("yes")) goto _L20; else goto _L19
_L19:
        log("NITZ: Not setting clock because gsm.ignore-nitz is set");
          goto _L21
_L22:
        boolean flag4;
        TimeZone timezone1;
        long l3 = calendar.getTimeInMillis();
        timezone1 = getNitzTimeZone(k, flag4, l3);
        timezone = timezone1;
          goto _L7
_L35:
        flag4 = false;
          goto _L22
_L15:
        flag3 = false;
        continue; /* Loop/switch isn't completed */
_L18:
        flag1 = false;
          goto _L23
_L20:
        mWakeLock.acquire();
        if(!getAutoTime()) goto _L25; else goto _L24
_L24:
        long l2 = SystemClock.elapsedRealtime() - l;
        if(l2 >= 0L) goto _L27; else goto _L26
_L26:
        log((new StringBuilder()).append("NITZ: not setting time, clock has rolled backwards since NITZ time was received, ").append(s).toString());
        try {
            mWakeLock.release();
        }
        catch(RuntimeException runtimeexception) {
            loge((new StringBuilder()).append("NITZ: Parsing NITZ time ").append(s).append(" ex=").append(runtimeexception).toString());
        }
          goto _L21
_L27:
        if(l2 <= 0x7fffffffL) goto _L29; else goto _L28
_L28:
        log((new StringBuilder()).append("NITZ: not setting time, processing has taken ").append(l2 / 0x5265c00L).append(" days").toString());
        mWakeLock.release();
          goto _L21
_L29:
        int i1 = (int)l2;
        calendar.add(14, i1);
        log((new StringBuilder()).append("NITZ: Setting time of day to ").append(calendar.getTime()).append(" NITZ receive delay(ms): ").append(l2).append(" gained(ms): ").append(calendar.getTimeInMillis() - System.currentTimeMillis()).append(" from ").append(s).toString());
        setAndBroadcastNetworkSetTime(calendar.getTimeInMillis());
        Log.i("GSM", "NITZ: after Setting time of day");
_L25:
        SystemProperties.set("gsm.nitz.time", String.valueOf(calendar.getTimeInMillis()));
        saveNitzTime(calendar.getTimeInMillis());
        mNitzUpdatedTime = true;
        mWakeLock.release();
          goto _L21
        Exception exception;
        exception;
        mWakeLock.release();
        throw exception;
_L5:
        if(flag)
            byte0 = 1;
        else
            byte0 = -1;
          goto _L30
_L16:
        if(flag2 == flag3) goto _L31; else goto _L13
_L21:
        return;
_L2:
        flag = false;
          goto _L32
_L4:
        j = 0;
          goto _L5
_L11:
        flag5 = false;
          goto _L33
_L9:
        if(j == 0) goto _L35; else goto _L34
_L34:
        flag4 = true;
          goto _L22
    }

    private static void sloge(String s) {
        Log.e("GSM", (new StringBuilder()).append("[GsmSST] ").append(s).toString());
    }

    private static int twoDigitsAt(String s, int i) {
        int j = Character.digit(s.charAt(i), 10);
        int k = Character.digit(s.charAt(i + 1), 10);
        if(j < 0 || k < 0)
            throw new RuntimeException("invalid format");
        else
            return k + j * 10;
    }

    public void dispose() {
        super.cm.unregisterForAvailable(this);
        super.cm.unregisterForRadioStateChanged(this);
        super.cm.unregisterForVoiceNetworkStateChanged(this);
        phone.getIccCard().unregisterForReady(this);
        ((PhoneBase) (phone)).mIccRecords.unregisterForRecordsLoaded(this);
        super.cm.unSetOnSignalStrengthUpdate(this);
        super.cm.unSetOnRestrictedStateChanged(this);
        super.cm.unSetOnNITZTime(this);
        cr.unregisterContentObserver(mAutoTimeObserver);
        cr.unregisterContentObserver(mAutoTimeZoneObserver);
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("GsmServiceStateTracker extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" phone=").append(phone).toString());
        printwriter.println((new StringBuilder()).append(" cellLoc=").append(cellLoc).toString());
        printwriter.println((new StringBuilder()).append(" newCellLoc=").append(newCellLoc).toString());
        printwriter.println((new StringBuilder()).append(" mPreferredNetworkType=").append(mPreferredNetworkType).toString());
        printwriter.println((new StringBuilder()).append(" gprsState=").append(gprsState).toString());
        printwriter.println((new StringBuilder()).append(" newGPRSState=").append(newGPRSState).toString());
        printwriter.println((new StringBuilder()).append(" mMaxDataCalls=").append(mMaxDataCalls).toString());
        printwriter.println((new StringBuilder()).append(" mNewMaxDataCalls=").append(mNewMaxDataCalls).toString());
        printwriter.println((new StringBuilder()).append(" mReasonDataDenied=").append(mReasonDataDenied).toString());
        printwriter.println((new StringBuilder()).append(" mNewReasonDataDenied=").append(mNewReasonDataDenied).toString());
        printwriter.println((new StringBuilder()).append(" mGsmRoaming=").append(mGsmRoaming).toString());
        printwriter.println((new StringBuilder()).append(" mDataRoaming=").append(mDataRoaming).toString());
        printwriter.println((new StringBuilder()).append(" mEmergencyOnly=").append(mEmergencyOnly).toString());
        printwriter.println((new StringBuilder()).append(" mNeedFixZoneAfterNitz=").append(mNeedFixZoneAfterNitz).toString());
        printwriter.println((new StringBuilder()).append(" mZoneOffset=").append(mZoneOffset).toString());
        printwriter.println((new StringBuilder()).append(" mZoneDst=").append(mZoneDst).toString());
        printwriter.println((new StringBuilder()).append(" mZoneTime=").append(mZoneTime).toString());
        printwriter.println((new StringBuilder()).append(" mGotCountryCode=").append(mGotCountryCode).toString());
        printwriter.println((new StringBuilder()).append(" mNitzUpdatedTime=").append(mNitzUpdatedTime).toString());
        printwriter.println((new StringBuilder()).append(" mSavedTimeZone=").append(mSavedTimeZone).toString());
        printwriter.println((new StringBuilder()).append(" mSavedTime=").append(mSavedTime).toString());
        printwriter.println((new StringBuilder()).append(" mSavedAtTime=").append(mSavedAtTime).toString());
        printwriter.println((new StringBuilder()).append(" mNeedToRegForSimLoaded=").append(mNeedToRegForSimLoaded).toString());
        printwriter.println((new StringBuilder()).append(" mStartedGprsRegCheck=").append(mStartedGprsRegCheck).toString());
        printwriter.println((new StringBuilder()).append(" mReportedGprsNoReg=").append(mReportedGprsNoReg).toString());
        printwriter.println((new StringBuilder()).append(" mNotification=").append(mNotification).toString());
        printwriter.println((new StringBuilder()).append(" mWakeLock=").append(mWakeLock).toString());
        printwriter.println((new StringBuilder()).append(" curSpn=").append(curSpn).toString());
        printwriter.println((new StringBuilder()).append(" curPlmn=").append(curPlmn).toString());
        printwriter.println((new StringBuilder()).append(" curSpnRule=").append(curSpnRule).toString());
    }

    protected void finalize() {
        log("finalize");
    }

    public int getCurrentDataConnectionState() {
        return gprsState;
    }

    int getCurrentGprsState() {
        return gprsState;
    }

    protected Phone getPhone() {
        return phone;
    }

    public void handleMessage(Message message) {
        if(((PhoneBase) (phone)).mIsTheCurrentActivePhone) goto _L2; else goto _L1
_L1:
        Log.e("GSM", (new StringBuilder()).append("Received message ").append(message).append("[").append(message.what).append("] while being destroyed. Ignoring.").toString());
_L25:
        return;
_L2:
        message.what;
        JVM INSTR tableswitch 1 23: default 168
    //                   1 249
    //                   2 260
    //                   3 267
    //                   4 462
    //                   5 462
    //                   6 462
    //                   7 168
    //                   8 168
    //                   9 168
    //                   10 484
    //                   11 501
    //                   12 552
    //                   13 55
    //                   14 462
    //                   15 300
    //                   16 575
    //                   17 176
    //                   18 582
    //                   19 700
    //                   20 614
    //                   21 650
    //                   22 772
    //                   23 869;
           goto _L3 _L4 _L5 _L6 _L7 _L7 _L7 _L3 _L3 _L3 _L8 _L9 _L10 _L11 _L7 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20
_L11:
        continue; /* Loop/switch isn't completed */
_L3:
        super.handleMessage(message);
        continue; /* Loop/switch isn't completed */
_L14:
        super.cm.setCurrentPreferredNetworkType();
        if(mNeedToRegForSimLoaded) {
            ((PhoneBase) (phone)).mIccRecords.registerForRecordsLoaded(this, 16, null);
            mNeedToRegForSimLoaded = false;
        }
        if(!phone.getContext().getResources().getBoolean(0x111002d))
            phone.restoreSavedNetworkSelection(null);
        pollState();
        queueNextSignalStrengthPoll();
        continue; /* Loop/switch isn't completed */
_L4:
        setPowerStateToDesired();
        pollState();
        continue; /* Loop/switch isn't completed */
_L5:
        pollState();
        continue; /* Loop/switch isn't completed */
_L6:
        if(super.cm.getRadioState().isOn()) {
            onSignalStrengthResult((AsyncResult)message.obj);
            queueNextSignalStrengthPoll();
        }
        continue; /* Loop/switch isn't completed */
_L12:
        AsyncResult asyncresult5 = (AsyncResult)message.obj;
        if(asyncresult5.exception != null) goto _L22; else goto _L21
_L21:
        String as[];
        int j;
        int k;
        as = (String[])(String[])asyncresult5.result;
        j = -1;
        k = -1;
        if(as.length < 3)
            break MISSING_BLOCK_LABEL_405;
        int l;
        if(as[1] != null && as[1].length() > 0)
            j = Integer.parseInt(as[1], 16);
        if(as[2] == null || as[2].length() <= 0)
            break MISSING_BLOCK_LABEL_405;
        l = Integer.parseInt(as[2], 16);
        k = l;
_L23:
        cellLoc.setLacAndCid(j, k);
        phone.notifyLocationChanged();
_L22:
        disableSingleLocationUpdate();
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.w("GSM", (new StringBuilder()).append("error parsing location: ").append(numberformatexception).toString());
          goto _L23
_L7:
        AsyncResult asyncresult4 = (AsyncResult)message.obj;
        handlePollStateResult(message.what, asyncresult4);
        continue; /* Loop/switch isn't completed */
_L8:
        super.cm.getSignalStrength(obtainMessage(3));
        continue; /* Loop/switch isn't completed */
_L9:
        AsyncResult asyncresult3 = (AsyncResult)message.obj;
        setTimeFromNITZString((String)((Object[])(Object[])asyncresult3.result)[0], ((Long)((Object[])(Object[])asyncresult3.result)[1]).longValue());
        continue; /* Loop/switch isn't completed */
_L10:
        AsyncResult asyncresult2 = (AsyncResult)message.obj;
        super.dontPollSignalStrength = true;
        onSignalStrengthResult(asyncresult2);
        continue; /* Loop/switch isn't completed */
_L13:
        updateSpnDisplay();
        continue; /* Loop/switch isn't completed */
_L15:
        if(((AsyncResult)message.obj).exception == null)
            super.cm.getVoiceRegistrationState(obtainMessage(15, null));
        continue; /* Loop/switch isn't completed */
_L17:
        Message message2 = obtainMessage(21, ((AsyncResult)message.obj).userObj);
        super.cm.setPreferredNetworkType(mPreferredNetworkType, message2);
        continue; /* Loop/switch isn't completed */
_L18:
        AsyncResult asyncresult1 = (AsyncResult)message.obj;
        if(asyncresult1.userObj != null) {
            AsyncResult.forMessage((Message)asyncresult1.userObj).exception = asyncresult1.exception;
            ((Message)asyncresult1.userObj).sendToTarget();
        }
        continue; /* Loop/switch isn't completed */
_L16:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        Message message1;
        if(asyncresult.exception == null)
            mPreferredNetworkType = ((int[])(int[])asyncresult.result)[0];
        else
            mPreferredNetworkType = 7;
        message1 = obtainMessage(20, asyncresult.userObj);
        super.cm.setPreferredNetworkType(7, message1);
        continue; /* Loop/switch isn't completed */
_L19:
        if(super.ss != null && !isGprsConsistent(gprsState, super.ss.getState())) {
            GsmCellLocation gsmcelllocation = (GsmCellLocation)phone.getCellLocation();
            Object aobj[] = new Object[2];
            aobj[0] = super.ss.getOperatorNumeric();
            int i;
            if(gsmcelllocation != null)
                i = gsmcelllocation.getCid();
            else
                i = -1;
            aobj[1] = Integer.valueOf(i);
            EventLog.writeEvent(50107, aobj);
            mReportedGprsNoReg = true;
        }
        mStartedGprsRegCheck = false;
        continue; /* Loop/switch isn't completed */
_L20:
        log("EVENT_RESTRICTED_STATE_CHANGED");
        onRestrictedStateChanged((AsyncResult)message.obj);
        if(true) goto _L25; else goto _L24
_L24:
    }

    protected void handlePollStateResult(int i, AsyncResult asyncresult) {
        if(asyncresult.userObj == super.pollingContext) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(asyncresult.exception == null) goto _L4; else goto _L3
_L3:
        com.android.internal.telephony.CommandException.Error error;
        error = null;
        if(asyncresult.exception instanceof CommandException)
            error = ((CommandException)(CommandException)asyncresult.exception).getCommandError();
        if(error != com.android.internal.telephony.CommandException.Error.RADIO_NOT_AVAILABLE) goto _L6; else goto _L5
_L5:
        cancelPollState();
          goto _L7
_L6:
        if(super.cm.getRadioState().isOn()) goto _L9; else goto _L8
_L8:
        cancelPollState();
          goto _L7
_L9:
        if(error != com.android.internal.telephony.CommandException.Error.OP_NOT_ALLOWED_BEFORE_REG_NW)
            loge((new StringBuilder()).append("RIL implementation has returned an error where it must succeed").append(asyncresult.exception).toString());
_L10:
        int ai1[] = super.pollingContext;
        ai1[0] = -1 + ai1[0];
        if(super.pollingContext[0] == 0) {
            int ai[];
            ServiceState servicestate;
            boolean flag;
            boolean flag1;
            RuntimeException runtimeexception;
            String as[];
            String as1[];
            int j;
            int k;
            int l;
            NumberFormatException numberformatexception;
            String as2[];
            int i1;
            int j1;
            int k1;
            int l1;
            int i2;
            NumberFormatException numberformatexception1;
            int j2;
            if(mGsmRoaming || mDataRoaming)
                flag1 = true;
            else
                flag1 = false;
            if(mGsmRoaming && !isRoamingBetweenOperators(mGsmRoaming, super.newSS))
                flag1 = false;
            super.newSS.setRoaming(flag1);
            super.newSS.setEmergencyOnly(mEmergencyOnly);
            pollStateDone();
        }
_L7:
        if(true) goto _L1; else goto _L4
_L4:
        i;
        JVM INSTR lookupswitch 4: default 256
    //                   4: 259
    //                   5: 559
    //                   6: 742
    //                   14: 788;
           goto _L10 _L11 _L12 _L13 _L14
_L11:
        as2 = (String[])(String[])asyncresult.result;
        i1 = -1;
        j1 = -1;
        k1 = -1;
        l1 = -1;
        i2 = as2.length;
        if(i2 <= 0)
            break MISSING_BLOCK_LABEL_412;
        k1 = Integer.parseInt(as2[0]);
        if(as2.length >= 3) {
            if(as2[1] != null && as2[1].length() > 0)
                i1 = Integer.parseInt(as2[1], 16);
            if(as2[2] != null && as2[2].length() > 0)
                j1 = Integer.parseInt(as2[2], 16);
        }
        if(as2.length <= 14 || as2[14] == null || as2[14].length() <= 0)
            break MISSING_BLOCK_LABEL_412;
        j2 = Integer.parseInt(as2[14], 16);
        l1 = j2;
_L17:
        mGsmRoaming = regCodeIsRoaming(k1);
        super.newSS.setState(regCodeToServiceState(k1));
        if(k1 != 10 && k1 != 12 && k1 != 13 && k1 != 14) goto _L16; else goto _L15
_L15:
        mEmergencyOnly = true;
_L18:
        newCellLoc.setLacAndCid(i1, j1);
        newCellLoc.setPsc(l1);
          goto _L10
        runtimeexception;
        loge((new StringBuilder()).append("Exception while polling service state. Probably malformed RIL response.").append(runtimeexception).toString());
          goto _L10
        numberformatexception1;
        loge((new StringBuilder()).append("error parsing RegistrationState: ").append(numberformatexception1).toString());
          goto _L17
_L16:
        mEmergencyOnly = false;
          goto _L18
_L12:
        as1 = (String[])(String[])asyncresult.result;
        j = 0;
        k = -1;
        mNewReasonDataDenied = -1;
        mNewMaxDataCalls = 1;
        l = as1.length;
        if(l <= 0) goto _L20; else goto _L19
_L19:
        try {
            k = Integer.parseInt(as1[0]);
            if(as1.length >= 4 && as1[3] != null)
                j = Integer.parseInt(as1[3]);
            if(as1.length >= 5 && k == 3)
                mNewReasonDataDenied = Integer.parseInt(as1[4]);
            if(as1.length >= 6)
                mNewMaxDataCalls = Integer.parseInt(as1[5]);
        }
        // Misplaced declaration of an exception variable
        catch(NumberFormatException numberformatexception) {
            loge((new StringBuilder()).append("error parsing GprsRegistrationState: ").append(numberformatexception).toString());
        }
_L20:
        newGPRSState = regCodeToServiceState(k);
        mDataRoaming = regCodeIsRoaming(k);
        super.mNewRilRadioTechnology = j;
        super.newSS.setRadioTechnology(j);
          goto _L10
_L13:
        as = (String[])(String[])asyncresult.result;
        if(as != null && as.length >= 3)
            super.newSS.setOperatorName(as[0], as[1], as[2]);
          goto _L10
_L14:
        ai = (int[])(int[])asyncresult.result;
        servicestate = super.newSS;
        if(ai[0] != 1) goto _L22; else goto _L21
_L21:
        flag = true;
_L23:
        servicestate.setIsManualSelection(flag);
          goto _L10
_L22:
        flag = false;
          goto _L23
    }

    protected void hangupAndPowerOff() {
        if(phone.isInCall()) {
            phone.mCT.ringingCall.hangupIfAlive();
            phone.mCT.backgroundCall.hangupIfAlive();
            phone.mCT.foregroundCall.hangupIfAlive();
        }
        super.cm.setRadioPower(false, null);
    }

    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean flag;
        if(super.mRilRadioTechnology >= 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[GsmSST] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("GSM", (new StringBuilder()).append("[GsmSST] ").append(s).toString());
    }

    protected void setPowerStateToDesired() {
        if(!super.mDesiredPowerState || super.cm.getRadioState() != com.android.internal.telephony.CommandsInterface.RadioState.RADIO_OFF) goto _L2; else goto _L1
_L1:
        super.cm.setRadioPower(true, null);
_L4:
        return;
_L2:
        if(!super.mDesiredPowerState && super.cm.getRadioState().isOn())
            powerOffRadioSafely(((PhoneBase) (phone)).mDataConnectionTracker);
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void updateSpnDisplay() {
        int i = ((PhoneBase) (phone)).mIccRecords.getDisplayRule(super.ss.getOperatorNumeric());
        String s = Injector.getSpn(this, ((PhoneBase) (phone)).mIccRecords.getServiceProviderName());
        String s1 = Injector.getPlmn(this, super.ss.getOperatorAlphaLong());
        if(mEmergencyOnly && super.cm.getRadioState().isOn()) {
            s1 = Resources.getSystem().getText(0x1040310).toString();
            log((new StringBuilder()).append("updateSpnDisplay: emergency only and radio is on plmn='").append(s1).append("'").toString());
        }
        if(i != curSpnRule || !TextUtils.equals(s, curSpn) || !TextUtils.equals(s1, curPlmn)) {
            boolean flag;
            boolean flag1;
            String s2;
            Object aobj[];
            Intent intent;
            if(!mEmergencyOnly && !TextUtils.isEmpty(s) && (i & 1) == 1)
                flag = true;
            else
                flag = false;
            if(!TextUtils.isEmpty(s1) && (mEmergencyOnly || (i & 2) == 2))
                flag1 = true;
            else
                flag1 = false;
            s2 = (new StringBuilder()).append("updateSpnDisplay: changed sending intent rule=").append(i).append(" showPlmn='%b' plmn='%s' showSpn='%b' spn='%s'").toString();
            aobj = new Object[4];
            aobj[0] = Boolean.valueOf(flag1);
            aobj[1] = s1;
            aobj[2] = Boolean.valueOf(flag);
            aobj[3] = s;
            log(String.format(s2, aobj));
            intent = new Intent("android.provider.Telephony.SPN_STRINGS_UPDATED");
            intent.addFlags(0x20000000);
            intent.putExtra("showSpn", flag);
            intent.putExtra("spn", s);
            intent.putExtra("showPlmn", flag1);
            intent.putExtra("plmn", s1);
            phone.getContext().sendStickyBroadcast(intent);
        }
        curSpnRule = i;
        curSpn = s;
        curPlmn = s1;
    }

    static final int CS_DISABLED = 1004;
    static final int CS_EMERGENCY_ENABLED = 1006;
    static final int CS_ENABLED = 1003;
    static final int CS_NORMAL_ENABLED = 1005;
    static final int CS_NOTIFICATION = 999;
    static final boolean DBG = true;
    static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60000;
    static final String LOG_TAG = "GSM";
    static final int PS_DISABLED = 1002;
    static final int PS_ENABLED = 1001;
    static final int PS_NOTIFICATION = 888;
    private static final String WAKELOCK_TAG = "ServiceStateTracker";
    GsmCellLocation cellLoc;
    private ContentResolver cr;
    private String curPlmn;
    private String curSpn;
    private int curSpnRule;
    private int gprsState;
    private ContentObserver mAutoTimeObserver;
    private ContentObserver mAutoTimeZoneObserver;
    private boolean mDataRoaming;
    private boolean mEmergencyOnly;
    private boolean mGotCountryCode;
    private boolean mGsmRoaming;
    private BroadcastReceiver mIntentReceiver;
    private int mMaxDataCalls;
    private boolean mNeedFixZoneAfterNitz;
    private boolean mNeedToRegForSimLoaded;
    private int mNewMaxDataCalls;
    private int mNewReasonDataDenied;
    private boolean mNitzUpdatedTime;
    private Notification mNotification;
    int mPreferredNetworkType;
    private int mReasonDataDenied;
    private boolean mReportedGprsNoReg;
    long mSavedAtTime;
    long mSavedTime;
    String mSavedTimeZone;
    private boolean mStartedGprsRegCheck;
    private android.os.PowerManager.WakeLock mWakeLock;
    private boolean mZoneDst;
    private int mZoneOffset;
    private long mZoneTime;
    GsmCellLocation newCellLoc;
    private int newGPRSState;
    GSMPhone phone;


}
