// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.EventLog;

public class EventLogTags {

    private EventLogTags() {
    }

    public static void writeBadIpAddress(String s) {
        EventLog.writeEvent(50117, s);
    }

    public static void writeCallDrop(int i, int j, int k) {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Integer.valueOf(k);
        EventLog.writeEvent(50106, aobj);
    }

    public static void writeCdmaDataDrop(int i, int j) {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        EventLog.writeEvent(50111, aobj);
    }

    public static void writeCdmaDataSetupFailed(int i, int j, int k) {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Integer.valueOf(k);
        EventLog.writeEvent(50110, aobj);
    }

    public static void writeCdmaDataStateChange(String s, String s1) {
        Object aobj[] = new Object[2];
        aobj[0] = s;
        aobj[1] = s1;
        EventLog.writeEvent(50115, aobj);
    }

    public static void writeCdmaServiceStateChange(int i, int j, int k, int l) {
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Integer.valueOf(k);
        aobj[3] = Integer.valueOf(l);
        EventLog.writeEvent(50116, aobj);
    }

    public static void writeDataNetworkRegistrationFail(int i, int j) {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        EventLog.writeEvent(50107, aobj);
    }

    public static void writeDataNetworkStatusOnRadioOff(String s, int i) {
        Object aobj[] = new Object[2];
        aobj[0] = s;
        aobj[1] = Integer.valueOf(i);
        EventLog.writeEvent(50108, aobj);
    }

    public static void writeDataStallRecoveryCleanup(int i) {
        EventLog.writeEvent(50119, i);
    }

    public static void writeDataStallRecoveryGetDataCallList(int i) {
        EventLog.writeEvent(50118, i);
    }

    public static void writeDataStallRecoveryRadioRestart(int i) {
        EventLog.writeEvent(50121, i);
    }

    public static void writeDataStallRecoveryRadioRestartWithProp(int i) {
        EventLog.writeEvent(50122, i);
    }

    public static void writeDataStallRecoveryReregister(int i) {
        EventLog.writeEvent(50120, i);
    }

    public static void writeGsmDataStateChange(String s, String s1) {
        Object aobj[] = new Object[2];
        aobj[0] = s;
        aobj[1] = s1;
        EventLog.writeEvent(50113, aobj);
    }

    public static void writeGsmRatSwitched(int i, int j, int k) {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Integer.valueOf(k);
        EventLog.writeEvent(50112, aobj);
    }

    public static void writeGsmServiceStateChange(int i, int j, int k, int l) {
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Integer.valueOf(k);
        aobj[3] = Integer.valueOf(l);
        EventLog.writeEvent(50114, aobj);
    }

    public static void writePdpBadDnsAddress(String s) {
        EventLog.writeEvent(50100, s);
    }

    public static void writePdpContextReset(int i) {
        EventLog.writeEvent(50103, i);
    }

    public static void writePdpNetworkDrop(int i, int j) {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        EventLog.writeEvent(50109, aobj);
    }

    public static void writePdpRadioReset(int i) {
        EventLog.writeEvent(50102, i);
    }

    public static void writePdpRadioResetCountdownTriggered(int i) {
        EventLog.writeEvent(50101, i);
    }

    public static void writePdpReregisterNetwork(int i) {
        EventLog.writeEvent(50104, i);
    }

    public static void writePdpSetupFail(int i, int j, int k) {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Integer.valueOf(k);
        EventLog.writeEvent(50105, aobj);
    }

    public static final int BAD_IP_ADDRESS = 50117;
    public static final int CALL_DROP = 50106;
    public static final int CDMA_DATA_DROP = 50111;
    public static final int CDMA_DATA_SETUP_FAILED = 50110;
    public static final int CDMA_DATA_STATE_CHANGE = 50115;
    public static final int CDMA_SERVICE_STATE_CHANGE = 50116;
    public static final int DATA_NETWORK_REGISTRATION_FAIL = 50107;
    public static final int DATA_NETWORK_STATUS_ON_RADIO_OFF = 50108;
    public static final int DATA_STALL_RECOVERY_CLEANUP = 50119;
    public static final int DATA_STALL_RECOVERY_GET_DATA_CALL_LIST = 50118;
    public static final int DATA_STALL_RECOVERY_RADIO_RESTART = 50121;
    public static final int DATA_STALL_RECOVERY_RADIO_RESTART_WITH_PROP = 50122;
    public static final int DATA_STALL_RECOVERY_REREGISTER = 50120;
    public static final int GSM_DATA_STATE_CHANGE = 50113;
    public static final int GSM_RAT_SWITCHED = 50112;
    public static final int GSM_SERVICE_STATE_CHANGE = 50114;
    public static final int PDP_BAD_DNS_ADDRESS = 50100;
    public static final int PDP_CONTEXT_RESET = 50103;
    public static final int PDP_NETWORK_DROP = 50109;
    public static final int PDP_RADIO_RESET = 50102;
    public static final int PDP_RADIO_RESET_COUNTDOWN_TRIGGERED = 50101;
    public static final int PDP_REREGISTER_NETWORK = 50104;
    public static final int PDP_SETUP_FAIL = 50105;
}
