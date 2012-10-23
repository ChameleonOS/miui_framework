// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.app.AlarmManager;
import android.content.*;
import android.database.ContentObserver;
import android.os.*;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.*;
import com.android.internal.telephony.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package com.android.internal.telephony.cdma:
//            CDMAPhone, CdmaSubscriptionSourceManager, EriManager, CdmaCallTracker, 
//            CdmaCall

public class CdmaServiceStateTracker extends ServiceStateTracker {
    private class LocaleChangedIntentReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            if(((PhoneBase) (phone)).mIsTheCurrentActivePhone) goto _L2; else goto _L1
_L1:
            Log.e("CDMA", (new StringBuilder()).append("Received Intent ").append(intent).append(" while being destroyed. Ignoring.").toString());
_L4:
            return;
_L2:
            if(intent.getAction().equals("android.intent.action.LOCALE_CHANGED"))
                updateSpnDisplay();
            if(true) goto _L4; else goto _L3
_L3:
        }

        final CdmaServiceStateTracker this$0;

        private LocaleChangedIntentReceiver() {
            this$0 = CdmaServiceStateTracker.this;
            super();
        }

    }


    public CdmaServiceStateTracker(CDMAPhone cdmaphone) {
        boolean flag = false;
        super();
        mCurrentOtaspMode = 0;
        mNitzUpdateSpacing = SystemProperties.getInt("ro.nitz_update_spacing", 0x927c0);
        mNitzUpdateDiff = SystemProperties.getInt("ro.nitz_update_diff", 2000);
        mCdmaRoaming = false;
        mDataConnectionState = 1;
        mNewDataConnectionState = 1;
        mRegistrationState = -1;
        cdmaForSubscriptionInfoReadyRegistrants = new RegistrantList();
        mNeedFixZone = false;
        mGotCountryCode = false;
        mNeedToRegForRuimLoaded = false;
        mCurPlmn = null;
        mHomeSystemId = null;
        mHomeNetworkId = null;
        mIsMinInfoReady = false;
        isEriTextLoaded = false;
        isSubscriptionFromRuim = false;
        currentCarrier = null;
        mIntentReceiver = new LocaleChangedIntentReceiver();
        mAutoTimeObserver = new ContentObserver(new Handler()) {

            public void onChange(boolean flag2) {
                log("Auto time state changed");
                revertToNitzTime();
            }

            final CdmaServiceStateTracker this$0;

             {
                this$0 = CdmaServiceStateTracker.this;
                super(handler);
            }
        };
        mAutoTimeZoneObserver = new ContentObserver(new Handler()) {

            public void onChange(boolean flag2) {
                log("Auto time zone state changed");
                revertToNitzTimeZone();
            }

            final CdmaServiceStateTracker this$0;

             {
                this$0 = CdmaServiceStateTracker.this;
                super(handler);
            }
        };
        phone = cdmaphone;
        cr = cdmaphone.getContext().getContentResolver();
        super.cm = ((PhoneBase) (cdmaphone)).mCM;
        super.ss = new ServiceState();
        super.newSS = new ServiceState();
        cellLoc = new CdmaCellLocation();
        newCellLoc = new CdmaCellLocation();
        super.mSignalStrength = new SignalStrength();
        mCdmaSSM = CdmaSubscriptionSourceManager.getInstance(cdmaphone.getContext(), super.cm, this, 39, null);
        boolean flag1;
        if(mCdmaSSM.getCdmaSubscriptionSource() == 0)
            flag1 = true;
        else
            flag1 = false;
        isSubscriptionFromRuim = flag1;
        mWakeLock = ((PowerManager)cdmaphone.getContext().getSystemService("power")).newWakeLock(1, "ServiceStateTracker");
        super.cm.registerForRadioStateChanged(this, 1, null);
        super.cm.registerForVoiceNetworkStateChanged(this, 30, null);
        super.cm.setOnNITZTime(this, 11, null);
        super.cm.setOnSignalStrengthUpdate(this, 12, null);
        super.cm.registerForCdmaPrlChanged(this, 40, null);
        cdmaphone.registerForEriFileLoaded(this, 36, null);
        super.cm.registerForCdmaOtaProvision(this, 37, null);
        if(android.provider.Settings.System.getInt(cr, "airplane_mode_on", 0) <= 0)
            flag = true;
        super.mDesiredPowerState = flag;
        cr.registerContentObserver(android.provider.Settings.System.getUriFor("auto_time"), true, mAutoTimeObserver);
        cr.registerContentObserver(android.provider.Settings.System.getUriFor("auto_time_zone"), true, mAutoTimeZoneObserver);
        setSignalStrengthDefaultValues();
        mNeedToRegForRuimLoaded = true;
        monitorLocaleChange();
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
        int i = android.provider.Settings.System.getInt(cr, "auto_time");
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
        int i = android.provider.Settings.System.getInt(cr, "auto_time_zone");
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

    private void getSubscriptionInfoAndStartPollingThreads() {
        super.cm.getCDMASubscription(obtainMessage(34));
        pollState();
    }

    private void handleCdmaSubscriptionSource(int i) {
        log((new StringBuilder()).append("Subscription Source : ").append(i).toString());
        boolean flag;
        if(i == 0)
            flag = true;
        else
            flag = false;
        isSubscriptionFromRuim = flag;
        saveCdmaSubscriptionSource(i);
        if(!isSubscriptionFromRuim)
            sendMessage(obtainMessage(35));
        else
            phone.getIccCard().registerForReady(this, 26, null);
    }

    private boolean isHomeSid(int i) {
        int j;
        if(mHomeSystemId == null)
            break MISSING_BLOCK_LABEL_38;
        j = 0;
_L3:
        if(j >= mHomeSystemId.length)
            break MISSING_BLOCK_LABEL_38;
        if(i != mHomeSystemId[j]) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    private boolean isRoamIndForHomeSystem(String s) {
        boolean flag;
        String s1;
        flag = false;
        s1 = SystemProperties.get("ro.cdma.homesystem");
        if(TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        int j;
        as = s1.split(",");
        i = as.length;
        j = 0;
_L7:
        if(j >= i) goto _L2; else goto _L3
_L3:
        if(!as[j].equals(s)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        j++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private boolean isRoamingBetweenOperators(boolean flag, ServiceState servicestate) {
        boolean flag1 = true;
        String s = SystemProperties.get("gsm.sim.operator.alpha", "empty");
        String s1 = servicestate.getOperatorAlphaLong();
        String s2 = servicestate.getOperatorAlphaShort();
        boolean flag2;
        boolean flag3;
        if(s1 != null && s.equals(s1))
            flag2 = flag1;
        else
            flag2 = false;
        if(s2 != null && s.equals(s2))
            flag3 = flag1;
        else
            flag3 = false;
        if(!flag || flag2 || flag3)
            flag1 = false;
        return flag1;
    }

    private void monitorLocaleChange() {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.LOCALE_CHANGED");
        phone.getContext().registerReceiver(mIntentReceiver, intentfilter);
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

    private void revertToNitzTime() {
        if(android.provider.Settings.System.getInt(cr, "auto_time", 0) != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        log((new StringBuilder()).append("revertToNitzTime: mSavedTime=").append(mSavedTime).append(" mSavedAtTime=").append(mSavedAtTime).toString());
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
        log((new StringBuilder()).append("revertToNitzTimeZone: tz='").append(mSavedTimeZone).toString());
        if(mSavedTimeZone != null)
            setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void saveCdmaSubscriptionSource(int i) {
        log((new StringBuilder()).append("Storing cdma subscription source: ").append(i).toString());
        android.provider.Settings.Secure.putInt(phone.getContext().getContentResolver(), "subscription_mode", i);
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
    }

    private void setTimeFromNITZString(String s, long l) {
        long l1;
        l1 = SystemClock.elapsedRealtime();
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
_L30:
        int i = Integer.parseInt(as[6]);
        if(as.length < 8) goto _L4; else goto _L3
_L3:
        int j = Integer.parseInt(as[7]);
          goto _L5
_L28:
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
_L31:
        long l11 = calendar.getTimeInMillis();
        timezone = TimeUtils.getTimeZone(k, flag5, l11, s1);
_L7:
        if(timezone == null || mZoneOffset != k) goto _L13; else goto _L12
_L12:
        boolean flag2 = mZoneDst;
        if(j == 0) goto _L15; else goto _L14
_L14:
        boolean flag3 = true;
          goto _L16
_L13:
        boolean flag1;
        mNeedFixZone = true;
        mZoneOffset = k;
        if(j == 0)
            break MISSING_BLOCK_LABEL_1317;
        flag1 = true;
_L33:
        mZoneDst = flag1;
        mZoneTime = calendar.getTimeInMillis();
_L29:
        boolean flag4;
        StringBuilder stringbuilder = (new StringBuilder()).append("NITZ: tzOffset=").append(k).append(" dst=").append(j).append(" zone=");
        String s2;
        String s3;
        long l10;
        if(timezone != null)
            s2 = timezone.getID();
        else
            s2 = "NULL";
        log(stringbuilder.append(s2).append(" iso=").append(s1).append(" mGotCountryCode=").append(mGotCountryCode).append(" mNeedFixZone=").append(mNeedFixZone).toString());
        if(timezone != null) {
            if(getAutoTimeZone())
                setAndBroadcastNetworkSetTimeZone(timezone.getID());
            saveNitzTimeZone(timezone.getID());
        }
        s3 = SystemProperties.get("gsm.ignore-nitz");
        if(s3 == null || !s3.equals("yes")) goto _L18; else goto _L17
_L17:
        log("NITZ: Not setting clock because gsm.ignore-nitz is set");
          goto _L19
_L32:
        l10 = calendar.getTimeInMillis();
        timezone = getNitzTimeZone(k, flag4, l10);
          goto _L7
_L18:
        long l3;
        mWakeLock.acquire();
        l3 = SystemClock.elapsedRealtime() - l;
        if(l3 >= 0L) goto _L21; else goto _L20
_L20:
        log((new StringBuilder()).append("NITZ: not setting time, clock has rolled backwards since NITZ time was received, ").append(s).toString());
        try {
            long l9 = SystemClock.elapsedRealtime();
            log((new StringBuilder()).append("NITZ: end=").append(l9).append(" dur=").append(l9 - l1).toString());
            mWakeLock.release();
        }
        catch(RuntimeException runtimeexception) {
            loge((new StringBuilder()).append("NITZ: Parsing NITZ time ").append(s).append(" ex=").append(runtimeexception).toString());
        }
          goto _L19
_L21:
        if(l3 <= 0x7fffffffL) goto _L23; else goto _L22
_L22:
        log((new StringBuilder()).append("NITZ: not setting time, processing has taken ").append(l3 / 0x5265c00L).append(" days").toString());
        long l8 = SystemClock.elapsedRealtime();
        log((new StringBuilder()).append("NITZ: end=").append(l8).append(" dur=").append(l8 - l1).toString());
        mWakeLock.release();
          goto _L19
_L23:
        int i1 = (int)l3;
        calendar.add(14, i1);
        if(!getAutoTime()) goto _L25; else goto _L24
_L24:
        long l5;
        long l6;
        int j1;
        int k1;
        l5 = calendar.getTimeInMillis() - System.currentTimeMillis();
        l6 = SystemClock.elapsedRealtime() - mSavedAtTime;
        j1 = android.provider.Settings.Secure.getInt(cr, "nitz_update_spacing", mNitzUpdateSpacing);
        k1 = android.provider.Settings.Secure.getInt(cr, "nitz_update_diff", mNitzUpdateDiff);
        if(mSavedAtTime != 0L && l6 <= (long)j1 && Math.abs(l5) <= (long)k1) goto _L27; else goto _L26
_L26:
        log((new StringBuilder()).append("NITZ: Auto updating time of day to ").append(calendar.getTime()).append(" NITZ receive delay=").append(l3).append("ms gained=").append(l5).append("ms from ").append(s).toString());
        setAndBroadcastNetworkSetTime(calendar.getTimeInMillis());
_L25:
        log("NITZ: update nitz time property");
        SystemProperties.set("gsm.nitz.time", String.valueOf(calendar.getTimeInMillis()));
        mSavedTime = calendar.getTimeInMillis();
        mSavedAtTime = SystemClock.elapsedRealtime();
        long l4 = SystemClock.elapsedRealtime();
        log((new StringBuilder()).append("NITZ: end=").append(l4).append(" dur=").append(l4 - l1).toString());
        mWakeLock.release();
          goto _L19
_L27:
        log((new StringBuilder()).append("NITZ: ignore, a previous update was ").append(l6).append("ms ago and gained=").append(l5).append("ms").toString());
        long l7 = SystemClock.elapsedRealtime();
        log((new StringBuilder()).append("NITZ: end=").append(l7).append(" dur=").append(l7 - l1).toString());
        mWakeLock.release();
          goto _L19
        Exception exception;
        exception;
        long l2 = SystemClock.elapsedRealtime();
        log((new StringBuilder()).append("NITZ: end=").append(l2).append(" dur=").append(l2 - l1).toString());
        mWakeLock.release();
        throw exception;
_L5:
        if(flag)
            byte0 = 1;
        else
            byte0 = -1;
          goto _L28
_L16:
        if(flag2 == flag3) goto _L29; else goto _L13
_L19:
        return;
_L2:
        flag = false;
          goto _L30
_L4:
        j = 0;
          goto _L5
_L11:
        flag5 = false;
          goto _L31
_L9:
        if(j != 0)
            flag4 = true;
        else
            flag4 = false;
          goto _L32
_L15:
        flag3 = false;
          goto _L16
        flag1 = false;
          goto _L33
    }

    public void dispose() {
        super.cm.unregisterForRadioStateChanged(this);
        super.cm.unregisterForVoiceNetworkStateChanged(this);
        phone.getIccCard().unregisterForReady(this);
        super.cm.unregisterForCdmaOtaProvision(this);
        phone.unregisterForEriFileLoaded(this);
        ((PhoneBase) (phone)).mIccRecords.unregisterForRecordsLoaded(this);
        super.cm.unSetOnSignalStrengthUpdate(this);
        super.cm.unSetOnNITZTime(this);
        cr.unregisterContentObserver(mAutoTimeObserver);
        cr.unregisterContentObserver(mAutoTimeZoneObserver);
        mCdmaSSM.dispose(this);
        super.cm.unregisterForCdmaPrlChanged(this);
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("CdmaServiceStateTracker extends:");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" phone=").append(phone).toString());
        printwriter.println((new StringBuilder()).append(" cellLoc=").append(cellLoc).toString());
        printwriter.println((new StringBuilder()).append(" newCellLoc=").append(newCellLoc).toString());
        printwriter.println((new StringBuilder()).append(" mCurrentOtaspMode=").append(mCurrentOtaspMode).toString());
        printwriter.println((new StringBuilder()).append(" mCdmaRoaming=").append(mCdmaRoaming).toString());
        printwriter.println((new StringBuilder()).append(" mRoamingIndicator=").append(mRoamingIndicator).toString());
        printwriter.println((new StringBuilder()).append(" mIsInPrl=").append(mIsInPrl).toString());
        printwriter.println((new StringBuilder()).append(" mDefaultRoamingIndicator=").append(mDefaultRoamingIndicator).toString());
        printwriter.println((new StringBuilder()).append(" mDataConnectionState=").append(mDataConnectionState).toString());
        printwriter.println((new StringBuilder()).append(" mNewDataConnectionState=").append(mNewDataConnectionState).toString());
        printwriter.println((new StringBuilder()).append(" mRegistrationState=").append(mRegistrationState).toString());
        printwriter.println((new StringBuilder()).append(" mNeedFixZone=").append(mNeedFixZone).toString());
        printwriter.println((new StringBuilder()).append(" mZoneOffset=").append(mZoneOffset).toString());
        printwriter.println((new StringBuilder()).append(" mZoneDst=").append(mZoneDst).toString());
        printwriter.println((new StringBuilder()).append(" mZoneTime=").append(mZoneTime).toString());
        printwriter.println((new StringBuilder()).append(" mGotCountryCode=").append(mGotCountryCode).toString());
        printwriter.println((new StringBuilder()).append(" mSavedTimeZone=").append(mSavedTimeZone).toString());
        printwriter.println((new StringBuilder()).append(" mSavedTime=").append(mSavedTime).toString());
        printwriter.println((new StringBuilder()).append(" mSavedAtTime=").append(mSavedAtTime).toString());
        printwriter.println((new StringBuilder()).append(" mNeedToRegForRuimLoaded=").append(mNeedToRegForRuimLoaded).toString());
        printwriter.println((new StringBuilder()).append(" mWakeLock=").append(mWakeLock).toString());
        printwriter.println((new StringBuilder()).append(" mCurPlmn=").append(mCurPlmn).toString());
        printwriter.println((new StringBuilder()).append(" mMdn=").append(mMdn).toString());
        printwriter.println((new StringBuilder()).append(" mHomeSystemId=").append(mHomeSystemId).toString());
        printwriter.println((new StringBuilder()).append(" mHomeNetworkId=").append(mHomeNetworkId).toString());
        printwriter.println((new StringBuilder()).append(" mMin=").append(mMin).toString());
        printwriter.println((new StringBuilder()).append(" mPrlVersion=").append(mPrlVersion).toString());
        printwriter.println((new StringBuilder()).append(" mIsMinInfoReady=").append(mIsMinInfoReady).toString());
        printwriter.println((new StringBuilder()).append(" isEriTextLoaded=").append(isEriTextLoaded).toString());
        printwriter.println((new StringBuilder()).append(" isSubscriptionFromRuim=").append(isSubscriptionFromRuim).toString());
        printwriter.println((new StringBuilder()).append(" mCdmaSSM=").append(mCdmaSSM).toString());
        printwriter.println((new StringBuilder()).append(" mRegistrationDeniedReason=").append(mRegistrationDeniedReason).toString());
        printwriter.println((new StringBuilder()).append(" currentCarrier=").append(currentCarrier).toString());
    }

    protected void finalize() {
        log("CdmaServiceStateTracker finalized");
    }

    protected void fixTimeZone(String s) {
        String s1 = SystemProperties.get("persist.sys.timezone");
        log((new StringBuilder()).append("fixTimeZone zoneName='").append(s1).append("' mZoneOffset=").append(mZoneOffset).append(" mZoneDst=").append(mZoneDst).append(" iso-cc='").append(s).append("' iso-cc-idx=").append(Arrays.binarySearch(GMT_COUNTRY_CODES, s)).toString());
        TimeZone timezone;
        if(mZoneOffset == 0 && !mZoneDst && s1 != null && s1.length() > 0 && Arrays.binarySearch(GMT_COUNTRY_CODES, s) < 0) {
            timezone = TimeZone.getDefault();
            if(mNeedFixZone) {
                long l = System.currentTimeMillis();
                long l1 = timezone.getOffset(l);
                log((new StringBuilder()).append("fixTimeZone: tzOffset=").append(l1).append(" ltod=").append(TimeUtils.logTimeOfDay(l)).toString());
                if(getAutoTime()) {
                    long l2 = l - l1;
                    log((new StringBuilder()).append("fixTimeZone: adj ltod=").append(TimeUtils.logTimeOfDay(l2)).toString());
                    setAndBroadcastNetworkSetTime(l2);
                } else {
                    mSavedTime = mSavedTime - l1;
                    log((new StringBuilder()).append("fixTimeZone: adj mSavedTime=").append(mSavedTime).toString());
                }
            }
            log("fixTimeZone: using default TimeZone");
        } else
        if(s.equals("")) {
            timezone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
            log("fixTimeZone: using NITZ TimeZone");
        } else {
            timezone = TimeUtils.getTimeZone(mZoneOffset, mZoneDst, mZoneTime, s);
            log("fixTimeZone: using getTimeZone(off, dst, time, iso)");
        }
        mNeedFixZone = false;
        if(timezone != null) {
            log((new StringBuilder()).append("fixTimeZone: zone != null zone.getID=").append(timezone.getID()).toString());
            if(getAutoTimeZone())
                setAndBroadcastNetworkSetTimeZone(timezone.getID());
            else
                log("fixTimeZone: skip changing zone as getAutoTimeZone was false");
            saveNitzTimeZone(timezone.getID());
        } else {
            log("fixTimeZone: zone == null, do nothing for zone");
        }
    }

    public String getCdmaMin() {
        return mMin;
    }

    public int getCurrentDataConnectionState() {
        return mDataConnectionState;
    }

    String getImsi() {
        String s = SystemProperties.get("gsm.sim.operator.numeric", "");
        String s1;
        if(!TextUtils.isEmpty(s) && getCdmaMin() != null)
            s1 = (new StringBuilder()).append(s).append(getCdmaMin()).toString();
        else
            s1 = null;
        return s1;
    }

    public String getMdnNumber() {
        return mMdn;
    }

    int getOtasp() {
        int i;
        if(mMin == null || mMin.length() < 6) {
            log((new StringBuilder()).append("getOtasp: bad mMin='").append(mMin).append("'").toString());
            i = 1;
        } else
        if(mMin.equals("1111110111") || mMin.substring(0, 6).equals("000000") || SystemProperties.getBoolean("test_cdma_setup", false))
            i = 2;
        else
            i = 3;
        log((new StringBuilder()).append("getOtasp: state=").append(i).toString());
        return i;
    }

    protected Phone getPhone() {
        return phone;
    }

    public String getPrlVersion() {
        return mPrlVersion;
    }

    public void handleMessage(Message message) {
        if(((PhoneBase) (phone)).mIsTheCurrentActivePhone) goto _L2; else goto _L1
_L1:
        loge((new StringBuilder()).append("Received message ").append(message).append("[").append(message.what).append("]").append(" while being destroyed. Ignoring.").toString());
_L21:
        return;
_L2:
        message.what;
        JVM INSTR tableswitch 1 40: default 240
    //                   1 341
    //                   2 240
    //                   3 389
    //                   4 240
    //                   5 240
    //                   6 240
    //                   7 240
    //                   8 240
    //                   9 240
    //                   10 818
    //                   11 835
    //                   12 886
    //                   13 240
    //                   14 240
    //                   15 240
    //                   16 240
    //                   17 240
    //                   18 916
    //                   19 240
    //                   20 240
    //                   21 240
    //                   22 240
    //                   23 240
    //                   24 636
    //                   25 636
    //                   26 262
    //                   27 909
    //                   28 240
    //                   29 240
    //                   30 382
    //                   31 422
    //                   32 240
    //                   33 240
    //                   34 658
    //                   35 334
    //                   36 948
    //                   37 962
    //                   38 240
    //                   39 248
    //                   40 1030;
           goto _L3 _L4 _L3 _L5 _L3 _L3 _L3 _L3 _L3 _L3 _L6 _L7 _L8 _L3 _L3 _L3 _L3 _L3 _L9 _L3 _L3 _L3 _L3 _L3 _L10 _L10 _L11 _L12 _L3 _L3 _L13 _L14 _L3 _L3 _L15 _L16 _L17 _L18 _L3 _L19 _L20
_L3:
        super.handleMessage(message);
          goto _L21
_L19:
        handleCdmaSubscriptionSource(mCdmaSSM.getCdmaSubscriptionSource());
          goto _L21
_L11:
        if(mNeedToRegForRuimLoaded) {
            ((PhoneBase) (phone)).mIccRecords.registerForRecordsLoaded(this, 27, null);
            mNeedToRegForRuimLoaded = false;
        }
        if(phone.getLteOnCdmaMode() == 1) {
            log("Receive EVENT_RUIM_READY");
            pollState();
        } else {
            log("Receive EVENT_RUIM_READY and Send Request getCDMASubscription.");
            getSubscriptionInfoAndStartPollingThreads();
        }
        phone.prepareEri();
          goto _L21
_L16:
        getSubscriptionInfoAndStartPollingThreads();
          goto _L21
_L4:
        if(super.cm.getRadioState() == com.android.internal.telephony.CommandsInterface.RadioState.RADIO_ON) {
            handleCdmaSubscriptionSource(mCdmaSSM.getCdmaSubscriptionSource());
            queueNextSignalStrengthPoll();
        }
        setPowerStateToDesired();
        pollState();
          goto _L21
_L13:
        pollState();
          goto _L21
_L5:
        if(super.cm.getRadioState().isOn()) {
            onSignalStrengthResult((AsyncResult)message.obj);
            queueNextSignalStrengthPoll();
        }
          goto _L21
_L14:
        AsyncResult asyncresult6 = (AsyncResult)message.obj;
        if(asyncresult6.exception != null) goto _L23; else goto _L22
_L22:
        String as1[];
        int j;
        int k;
        int l;
        int i1;
        int j1;
        as1 = (String[])(String[])asyncresult6.result;
        j = -1;
        k = 0x7fffffff;
        l = 0x7fffffff;
        i1 = -1;
        j1 = -1;
        if(as1.length <= 9) goto _L25; else goto _L24
_L24:
        if(as1[4] != null)
            j = Integer.parseInt(as1[4]);
        if(as1[5] != null)
            k = Integer.parseInt(as1[5]);
        if(as1[6] != null)
            l = Integer.parseInt(as1[6]);
          goto _L26
_L28:
        if(as1[8] != null)
            i1 = Integer.parseInt(as1[8]);
        if(as1[9] == null) goto _L25; else goto _L27
_L27:
        int k1 = Integer.parseInt(as1[9]);
        j1 = k1;
_L25:
        cellLoc.setCellLocationData(j, k, l, i1, j1);
        phone.notifyLocationChanged();
_L23:
        disableSingleLocationUpdate();
          goto _L21
        NumberFormatException numberformatexception;
        numberformatexception;
        loge((new StringBuilder()).append("error parsing cell location data: ").append(numberformatexception).toString());
          goto _L25
_L10:
        AsyncResult asyncresult5 = (AsyncResult)message.obj;
        handlePollStateResult(message.what, asyncresult5);
          goto _L21
_L15:
        AsyncResult asyncresult4 = (AsyncResult)message.obj;
        if(asyncresult4.exception == null) {
            String as[] = (String[])(String[])asyncresult4.result;
            if(as != null && as.length >= 5) {
                mMdn = as[0];
                parseSidNid(as[1], as[2]);
                mMin = as[3];
                mPrlVersion = as[4];
                log((new StringBuilder()).append("GET_CDMA_SUBSCRIPTION: MDN=").append(mMdn).toString());
                mIsMinInfoReady = true;
                updateOtaspState();
                phone.getIccCard().broadcastIccStateChangedIntent("IMSI", null);
            } else {
                log((new StringBuilder()).append("GET_CDMA_SUBSCRIPTION: error parsing cdmaSubscription params num=").append(as.length).toString());
            }
        }
          goto _L21
_L6:
        super.cm.getSignalStrength(obtainMessage(3));
          goto _L21
_L7:
        AsyncResult asyncresult3 = (AsyncResult)message.obj;
        setTimeFromNITZString((String)((Object[])(Object[])asyncresult3.result)[0], ((Long)((Object[])(Object[])asyncresult3.result)[1]).longValue());
          goto _L21
_L8:
        AsyncResult asyncresult2 = (AsyncResult)message.obj;
        super.dontPollSignalStrength = true;
        onSignalStrengthResult(asyncresult2);
          goto _L21
_L12:
        updateSpnDisplay();
          goto _L21
_L9:
        if(((AsyncResult)message.obj).exception == null)
            super.cm.getVoiceRegistrationState(obtainMessage(31, null));
          goto _L21
_L17:
        log("[CdmaServiceStateTracker] ERI file has been loaded, repolling.");
        pollState();
          goto _L21
_L18:
        AsyncResult asyncresult1 = (AsyncResult)message.obj;
        if(asyncresult1.exception == null) {
            int i = ((int[])(int[])asyncresult1.result)[0];
            if(i == 8 || i == 10) {
                log("EVENT_OTA_PROVISION_STATUS_CHANGE: Complete, Reload MDN");
                super.cm.getCDMASubscription(obtainMessage(34));
            }
        }
          goto _L21
_L20:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception == null)
            mPrlVersion = Integer.toString(((int[])(int[])asyncresult.result)[0]);
          goto _L21
_L26:
        if(k == 0 && l == 0) {
            k = 0x7fffffff;
            l = 0x7fffffff;
        }
          goto _L28
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
            loge((new StringBuilder()).append("handlePollStateResult: RIL returned an error where it must succeed").append(asyncresult.exception).toString());
_L10:
        int ai[] = super.pollingContext;
        ai[0] = -1 + ai[0];
        if(super.pollingContext[0] == 0) {
            boolean flag = false;
            if(!isSidsAllZeros() && isHomeSid(super.newSS.getSystemId()))
                flag = true;
            RuntimeException runtimeexception;
            boolean flag1;
            int j;
            if(isSubscriptionFromRuim)
                super.newSS.setRoaming(isRoamingBetweenOperators(mCdmaRoaming, super.newSS));
            else
                super.newSS.setRoaming(mCdmaRoaming);
            super.newSS.setCdmaDefaultRoamingIndicator(mDefaultRoamingIndicator);
            super.newSS.setCdmaRoamingIndicator(mRoamingIndicator);
            flag1 = true;
            if(TextUtils.isEmpty(mPrlVersion))
                flag1 = false;
            if(!flag1)
                super.newSS.setCdmaRoamingIndicator(1);
            else
            if(!isSidsAllZeros())
                if(!flag && !mIsInPrl)
                    super.newSS.setCdmaRoamingIndicator(mDefaultRoamingIndicator);
                else
                if(flag && !mIsInPrl)
                    super.newSS.setCdmaRoamingIndicator(2);
                else
                if(!flag && mIsInPrl)
                    super.newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                else
                if(mRoamingIndicator <= 2)
                    super.newSS.setCdmaRoamingIndicator(1);
                else
                    super.newSS.setCdmaRoamingIndicator(mRoamingIndicator);
            j = super.newSS.getCdmaRoamingIndicator();
            super.newSS.setCdmaEriIconIndex(phone.mEriManager.getCdmaEriIconIndex(j, mDefaultRoamingIndicator));
            super.newSS.setCdmaEriIconMode(phone.mEriManager.getCdmaEriIconMode(j, mDefaultRoamingIndicator));
            log((new StringBuilder()).append("Set CDMA Roaming Indicator to: ").append(super.newSS.getCdmaRoamingIndicator()).append(". mCdmaRoaming = ").append(mCdmaRoaming).append(", isPrlLoaded = ").append(flag1).append(". namMatch = ").append(flag).append(" , mIsInPrl = ").append(mIsInPrl).append(", mRoamingIndicator = ").append(mRoamingIndicator).append(", mDefaultRoamingIndicator= ").append(mDefaultRoamingIndicator).toString());
            pollStateDone();
        }
_L7:
        if(true) goto _L1; else goto _L4
_L4:
        try {
            handlePollStateResultMessage(i, asyncresult);
        }
        // Misplaced declaration of an exception variable
        catch(RuntimeException runtimeexception) {
            loge((new StringBuilder()).append("handlePollStateResult: Exception while polling service state. Probably malformed RIL response.").append(runtimeexception).toString());
        }
          goto _L10
    }

    protected void handlePollStateResultMessage(int i, AsyncResult asyncresult) {
        i;
        JVM INSTR tableswitch 24 25: default 24
    //                   24 32
    //                   25 582;
           goto _L1 _L2 _L3
_L1:
        loge("handlePollStateResultMessage: RIL response handle in wrong phone! Expected CDMA RIL request and get GSM RIL request.");
_L8:
        return;
_L2:
        String as1[];
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        as1 = (String[])(String[])asyncresult.result;
        j = 4;
        k = -1;
        l = -1;
        i1 = 0x7fffffff;
        j1 = 0x7fffffff;
        k1 = 0;
        l1 = 0;
        i2 = 0;
        j2 = -1;
        k2 = 0;
        l2 = 0;
        i3 = 0;
        if(as1.length < 14) goto _L5; else goto _L4
_L4:
        if(as1[0] != null)
            j = Integer.parseInt(as1[0]);
        if(as1[3] != null)
            k = Integer.parseInt(as1[3]);
        if(as1[4] != null)
            l = Integer.parseInt(as1[4]);
        if(as1[5] != null)
            i1 = Integer.parseInt(as1[5]);
        if(as1[6] != null)
            j1 = Integer.parseInt(as1[6]);
        break MISSING_BLOCK_LABEL_734;
_L9:
        if(as1[7] != null)
            k1 = Integer.parseInt(as1[7]);
        if(as1[8] != null)
            l1 = Integer.parseInt(as1[8]);
        if(as1[9] != null)
            i2 = Integer.parseInt(as1[9]);
        if(as1[10] != null)
            j2 = Integer.parseInt(as1[10]);
        if(as1[11] != null)
            k2 = Integer.parseInt(as1[11]);
        if(as1[12] != null)
            l2 = Integer.parseInt(as1[12]);
        if(as1[13] == null) goto _L7; else goto _L6
_L6:
        int j3 = Integer.parseInt(as1[13]);
        i3 = j3;
_L7:
        mRegistrationState = j;
        NumberFormatException numberformatexception;
        boolean flag;
        boolean flag1;
        if(regCodeIsRoaming(j) && !isRoamIndForHomeSystem(as1[10]))
            flag = true;
        else
            flag = false;
        mCdmaRoaming = flag;
        super.newSS.setState(regCodeToServiceState(j));
        setCdmaTechnology(k);
        super.newSS.setCssIndicator(k1);
        super.newSS.setSystemAndNetworkId(l1, i2);
        mRoamingIndicator = j2;
        if(k2 == 0)
            flag1 = false;
        else
            flag1 = true;
        mIsInPrl = flag1;
        mDefaultRoamingIndicator = l2;
        newCellLoc.setCellLocationData(l, i1, j1, l1, i2);
        if(i3 == 0)
            mRegistrationDeniedReason = "General";
        else
        if(i3 == 1)
            mRegistrationDeniedReason = "Authentication Failure";
        else
            mRegistrationDeniedReason = "";
        if(mRegistrationState == 3)
            log((new StringBuilder()).append("Registration denied, ").append(mRegistrationDeniedReason).toString());
          goto _L8
        numberformatexception;
        loge((new StringBuilder()).append("EVENT_POLL_STATE_REGISTRATION_CDMA: error parsing: ").append(numberformatexception).toString());
          goto _L7
_L5:
        throw new RuntimeException((new StringBuilder()).append("Warning! Wrong number of parameters returned from RIL_REQUEST_REGISTRATION_STATE: expected 14 or more strings and got ").append(as1.length).append(" strings").toString());
_L3:
        String as[] = (String[])(String[])asyncresult.result;
        if(as != null && as.length >= 3) {
            if(as[2] == null || as[2].length() < 5 || "00000".equals(as[2])) {
                as[2] = SystemProperties.get(CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC, "00000");
                log((new StringBuilder()).append("RIL_REQUEST_OPERATOR.response[2], the numeric,  is bad. Using SystemProperties '").append(CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC).append("'= ").append(as[2]).toString());
            }
            if(!isSubscriptionFromRuim)
                super.newSS.setOperatorName(null, as[1], as[2]);
            else
                super.newSS.setOperatorName(as[0], as[1], as[2]);
        } else {
            log("EVENT_POLL_STATE_OPERATOR_CDMA: error parsing opNames");
        }
          goto _L8
        if(i1 == 0 && j1 == 0) {
            i1 = 0x7fffffff;
            j1 = 0x7fffffff;
        }
          goto _L9
    }

    protected void hangupAndPowerOff() {
        phone.mCT.ringingCall.hangupIfAlive();
        phone.mCT.backgroundCall.hangupIfAlive();
        phone.mCT.foregroundCall.hangupIfAlive();
        super.cm.setRadioPower(false, null);
    }

    public boolean isConcurrentVoiceAndDataAllowed() {
        return false;
    }

    public boolean isMinInfoReady() {
        return mIsMinInfoReady;
    }

    protected boolean isSidsAllZeros() {
        int i;
        if(mHomeSystemId == null)
            break MISSING_BLOCK_LABEL_37;
        i = 0;
_L3:
        if(i >= mHomeSystemId.length)
            break MISSING_BLOCK_LABEL_37;
        if(mHomeSystemId[i] == 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = true;
          goto _L4
    }

    protected void log(String s) {
        Log.d("CDMA", (new StringBuilder()).append("[CdmaSST] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("CDMA", (new StringBuilder()).append("[CdmaSST] ").append(s).toString());
    }

    protected void onSignalStrengthResult(AsyncResult asyncresult) {
        super.mSignalStrength;
        if(asyncresult.exception != null) {
            setSignalStrengthDefaultValues();
        } else {
            int ai[] = (int[])(int[])asyncresult.result;
            int i;
            int j;
            int k;
            int l;
            int i1;
            if(ai[2] > 0)
                i = -ai[2];
            else
                i = -120;
            if(ai[3] > 0)
                j = -ai[3];
            else
                j = -160;
            if(ai[4] > 0)
                k = -ai[4];
            else
                k = -120;
            if(ai[5] > 0)
                l = -ai[5];
            else
                l = -1;
            if(ai[6] > 0 && ai[6] <= 8)
                i1 = ai[6];
            else
                i1 = -1;
            super.mSignalStrength = new SignalStrength(99, -1, i, j, k, l, i1, false);
        }
        phone.notifySignalStrength();
_L1:
        return;
        NullPointerException nullpointerexception;
        nullpointerexception;
        loge((new StringBuilder()).append("onSignalStrengthResult() Phone already destroyed: ").append(nullpointerexception).append("SignalStrength not notified").toString());
          goto _L1
    }

    protected void parseSidNid(String s, String s1) {
        if(s != null) {
            String as1[] = s.split(",");
            mHomeSystemId = new int[as1.length];
            int j = 0;
            while(j < as1.length)  {
                try {
                    mHomeSystemId[j] = Integer.parseInt(as1[j]);
                }
                catch(NumberFormatException numberformatexception1) {
                    loge((new StringBuilder()).append("error parsing system id: ").append(numberformatexception1).toString());
                }
                j++;
            }
        }
        log((new StringBuilder()).append("CDMA_SUBSCRIPTION: SID=").append(s).toString());
        if(s1 != null) {
            String as[] = s1.split(",");
            mHomeNetworkId = new int[as.length];
            int i = 0;
            while(i < as.length)  {
                try {
                    mHomeNetworkId[i] = Integer.parseInt(as[i]);
                }
                catch(NumberFormatException numberformatexception) {
                    loge((new StringBuilder()).append("CDMA_SUBSCRIPTION: error parsing network id: ").append(numberformatexception).toString());
                }
                i++;
            }
        }
        log((new StringBuilder()).append("CDMA_SUBSCRIPTION: NID=").append(s1).toString());
    }

    protected void pollState() {
        super.pollingContext = new int[1];
        super.pollingContext[0] = 0;
        class _cls3 {

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

        _cls3..SwitchMap.com.android.internal.telephony.CommandsInterface.RadioState[super.cm.getRadioState().ordinal()];
        JVM INSTR tableswitch 1 2: default 52
    //                   1 117
    //                   2 147;
           goto _L1 _L2 _L3
_L1:
        int ai[] = super.pollingContext;
        ai[0] = 1 + ai[0];
        super.cm.getOperator(obtainMessage(25, super.pollingContext));
        int ai1[] = super.pollingContext;
        ai1[0] = 1 + ai1[0];
        super.cm.getVoiceRegistrationState(obtainMessage(24, super.pollingContext));
_L5:
        return;
_L2:
        super.newSS.setStateOutOfService();
        newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        mGotCountryCode = false;
        pollStateDone();
        continue; /* Loop/switch isn't completed */
_L3:
        super.newSS.setStateOff();
        newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        mGotCountryCode = false;
        pollStateDone();
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected void pollStateDone() {
        String s;
        String s1;
        log((new StringBuilder()).append("pollStateDone: oldSS=[").append(super.ss).append("] newSS=[").append(super.newSS).append("]").toString());
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        ServiceState servicestate;
        CdmaCellLocation cdmacelllocation;
        CDMAPhone cdmaphone;
        if(super.ss.getState() != 0 && super.newSS.getState() == 0)
            flag = true;
        else
            flag = false;
        if(super.ss.getState() != 0 || super.newSS.getState() == 0);
        if(mDataConnectionState != 0 && mNewDataConnectionState == 0)
            flag1 = true;
        else
            flag1 = false;
        if(mDataConnectionState == 0 && mNewDataConnectionState != 0)
            flag2 = true;
        else
            flag2 = false;
        if(mDataConnectionState != mNewDataConnectionState)
            flag3 = true;
        else
            flag3 = false;
        if(super.mRilRadioTechnology != super.mNewRilRadioTechnology)
            flag4 = true;
        else
            flag4 = false;
        if(!super.newSS.equals(super.ss))
            flag5 = true;
        else
            flag5 = false;
        if(!super.ss.getRoaming() && super.newSS.getRoaming())
            flag6 = true;
        else
            flag6 = false;
        if(super.ss.getRoaming() && !super.newSS.getRoaming())
            flag7 = true;
        else
            flag7 = false;
        if(!newCellLoc.equals(cellLoc))
            flag8 = true;
        else
            flag8 = false;
        if(super.ss.getState() != super.newSS.getState() || mDataConnectionState != mNewDataConnectionState) {
            Object aobj[] = new Object[4];
            aobj[0] = Integer.valueOf(super.ss.getState());
            aobj[1] = Integer.valueOf(mDataConnectionState);
            aobj[2] = Integer.valueOf(super.newSS.getState());
            aobj[3] = Integer.valueOf(mNewDataConnectionState);
            EventLog.writeEvent(50116, aobj);
        }
        servicestate = super.ss;
        super.ss = super.newSS;
        super.newSS = servicestate;
        super.newSS.setStateOutOfService();
        cdmacelllocation = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = cdmacelllocation;
        mDataConnectionState = mNewDataConnectionState;
        super.mRilRadioTechnology = super.mNewRilRadioTechnology;
        super.mNewRilRadioTechnology = 0;
        super.newSS.setStateOutOfService();
        if(flag4)
            phone.setSystemProperty("gsm.network.type", ServiceState.rilRadioTechnologyToString(super.mRilRadioTechnology));
        if(flag)
            super.mNetworkAttachedRegistrants.notifyRegistrants();
        if(!flag5) goto _L2; else goto _L1
_L1:
        if(super.cm.getRadioState().isOn() && !isSubscriptionFromRuim) {
            String s5;
            if(super.ss.getState() == 0)
                s5 = phone.getCdmaEriText();
            else
                s5 = phone.getContext().getText(0x1040109).toString();
            super.ss.setOperatorAlphaLong(s5);
        }
        phone.setSystemProperty("gsm.operator.alpha", super.ss.getOperatorAlphaLong());
        s = SystemProperties.get("gsm.operator.numeric", "");
        s1 = super.ss.getOperatorNumeric();
        phone.setSystemProperty("gsm.operator.numeric", s1);
        if(s1 != null) goto _L4; else goto _L3
_L3:
        log("operatorNumeric is null");
        phone.setSystemProperty("gsm.operator.iso-country", "");
        mGotCountryCode = false;
_L5:
        cdmaphone = phone;
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
        phone.notifyServiceStateChanged(super.ss);
_L2:
        if(flag1)
            super.mAttachedRegistrants.notifyRegistrants();
        if(flag2)
            super.mDetachedRegistrants.notifyRegistrants();
        if(flag3 || flag4)
            phone.notifyDataConnection(null);
        if(flag6)
            super.mRoamingOnRegistrants.notifyRegistrants();
        if(flag7)
            super.mRoamingOffRegistrants.notifyRegistrants();
        if(flag8)
            phone.notifyLocationChanged();
        return;
_L4:
        s2 = "";
        s1.substring(0, 3);
        s4 = MccTable.countryCodeForMcc(Integer.parseInt(s1.substring(0, 3)));
        s2 = s4;
_L6:
        phone.setSystemProperty("gsm.operator.iso-country", s2);
        mGotCountryCode = true;
        if(shouldFixTimeZoneNow(phone, s1, s, mNeedFixZone))
            fixTimeZone(s2);
          goto _L5
        numberformatexception;
        loge((new StringBuilder()).append("pollStateDone: countryCodeForMcc error").append(numberformatexception).toString());
          goto _L6
        stringindexoutofboundsexception;
        loge((new StringBuilder()).append("pollStateDone: countryCodeForMcc error").append(stringindexoutofboundsexception).toString());
          goto _L6
    }

    protected int radioTechnologyToDataServiceState(int i) {
        int j = 1;
        i;
        JVM INSTR tableswitch 0 13: default 72
    //                   0 79
    //                   1 79
    //                   2 79
    //                   3 79
    //                   4 79
    //                   5 79
    //                   6 81
    //                   7 81
    //                   8 81
    //                   9 72
    //                   10 72
    //                   11 72
    //                   12 81
    //                   13 81;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L3 _L3 _L1 _L1 _L1 _L3 _L3
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        loge("radioTechnologyToDataServiceState: Wrong radioTechnology code.");
_L5:
        return j;
_L3:
        j = 0;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected int regCodeToServiceState(int i) {
        int j = 1;
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 64
    //                   1 66
    //                   2 64
    //                   3 64
    //                   4 64
    //                   5 71;
           goto _L1 _L2 _L3 _L2 _L2 _L2 _L4
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

    public void registerForSubscriptionInfoReady(Handler handler, int i, Object obj) {
        Registrant registrant = new Registrant(handler, i, obj);
        cdmaForSubscriptionInfoReadyRegistrants.add(registrant);
        if(isMinInfoReady())
            registrant.notifyRegistrant();
    }

    protected void setCdmaTechnology(int i) {
        mNewDataConnectionState = radioTechnologyToDataServiceState(i);
        super.newSS.setRadioTechnology(i);
        super.mNewRilRadioTechnology = i;
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

    protected void setSignalStrengthDefaultValues() {
        super.mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
    }

    public void unregisterForSubscriptionInfoReady(Handler handler) {
        cdmaForSubscriptionInfoReadyRegistrants.remove(handler);
    }

    protected void updateOtaspState() {
        int i = getOtasp();
        int j = mCurrentOtaspMode;
        mCurrentOtaspMode = i;
        if(cdmaForSubscriptionInfoReadyRegistrants != null) {
            log("CDMA_SUBSCRIPTION: call notifyRegistrants()");
            cdmaForSubscriptionInfoReadyRegistrants.notifyRegistrants();
        }
        if(j != mCurrentOtaspMode) {
            log((new StringBuilder()).append("CDMA_SUBSCRIPTION: call notifyOtaspChanged old otaspMode=").append(j).append(" new otaspMode=").append(mCurrentOtaspMode).toString());
            phone.notifyOtaspChanged(mCurrentOtaspMode);
        }
    }

    protected void updateSpnDisplay() {
        String s = super.ss.getOperatorAlphaLong();
        if(!TextUtils.equals(s, mCurPlmn)) {
            boolean flag;
            Object aobj[];
            Intent intent;
            if(s != null)
                flag = true;
            else
                flag = false;
            aobj = new Object[2];
            aobj[0] = Boolean.valueOf(flag);
            aobj[1] = s;
            log(String.format("updateSpnDisplay: changed sending intent showPlmn='%b' plmn='%s'", aobj));
            intent = new Intent("android.provider.Telephony.SPN_STRINGS_UPDATED");
            intent.addFlags(0x20000000);
            intent.putExtra("showSpn", false);
            intent.putExtra("spn", "");
            intent.putExtra("showPlmn", flag);
            intent.putExtra("plmn", s);
            phone.getContext().sendStickyBroadcast(intent);
        }
        mCurPlmn = s;
    }

    static final String LOG_TAG = "CDMA";
    private static final int NITZ_UPDATE_DIFF_DEFAULT = 2000;
    private static final int NITZ_UPDATE_SPACING_DEFAULT = 0x927c0;
    private static final String UNACTIVATED_MIN2_VALUE = "000000";
    private static final String UNACTIVATED_MIN_VALUE = "1111110111";
    private static final String WAKELOCK_TAG = "ServiceStateTracker";
    protected RegistrantList cdmaForSubscriptionInfoReadyRegistrants;
    CdmaCellLocation cellLoc;
    private ContentResolver cr;
    private String currentCarrier;
    private boolean isEriTextLoaded;
    protected boolean isSubscriptionFromRuim;
    private ContentObserver mAutoTimeObserver;
    private ContentObserver mAutoTimeZoneObserver;
    private boolean mCdmaRoaming;
    private CdmaSubscriptionSourceManager mCdmaSSM;
    protected String mCurPlmn;
    int mCurrentOtaspMode;
    protected int mDataConnectionState;
    private int mDefaultRoamingIndicator;
    protected boolean mGotCountryCode;
    protected int mHomeNetworkId[];
    protected int mHomeSystemId[];
    private BroadcastReceiver mIntentReceiver;
    private boolean mIsInPrl;
    protected boolean mIsMinInfoReady;
    protected String mMdn;
    protected String mMin;
    protected boolean mNeedFixZone;
    private boolean mNeedToRegForRuimLoaded;
    protected int mNewDataConnectionState;
    private int mNitzUpdateDiff;
    private int mNitzUpdateSpacing;
    protected String mPrlVersion;
    private String mRegistrationDeniedReason;
    protected int mRegistrationState;
    private int mRoamingIndicator;
    long mSavedAtTime;
    long mSavedTime;
    String mSavedTimeZone;
    private android.os.PowerManager.WakeLock mWakeLock;
    private boolean mZoneDst;
    private int mZoneOffset;
    private long mZoneTime;
    CdmaCellLocation newCellLoc;
    CDMAPhone phone;


}
