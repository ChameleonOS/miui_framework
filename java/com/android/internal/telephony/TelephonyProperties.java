// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public interface TelephonyProperties {

    public static final String CURRENT_ACTIVE_PHONE = "gsm.current.phone-type";
    public static final String PROPERTY_BASEBAND_VERSION = "gsm.version.baseband";
    public static final String PROPERTY_CALL_RING_DELAY = "ro.telephony.call_ring.delay";
    public static final String PROPERTY_CDMA_MSG_ID = "persist.radio.cdma.msgid";
    public static final String PROPERTY_DATA_NETWORK_TYPE = "gsm.network.type";
    public static final String PROPERTY_DISABLE_CALL = "ro.telephony.disable-call";
    public static final String PROPERTY_ECM_EXIT_TIMER = "ro.cdma.ecmexittimer";
    public static final String PROPERTY_ICC_OPERATOR_ALPHA = "gsm.sim.operator.alpha";
    public static final String PROPERTY_ICC_OPERATOR_ISO_COUNTRY = "gsm.sim.operator.iso-country";
    public static final String PROPERTY_ICC_OPERATOR_NUMERIC = "gsm.sim.operator.numeric";
    public static final String PROPERTY_IDP_STRING = "ro.cdma.idpstring";
    public static final String PROPERTY_IGNORE_NITZ = "telephony.test.ignore.nitz";
    public static final String PROPERTY_INECM_MODE = "ril.cdma.inecmmode";
    public static final String PROPERTY_LTE_ON_CDMA_DEVICE = "telephony.lteOnCdmaDevice";
    public static final String PROPERTY_LTE_ON_CDMA_PRODUCT_TYPE = "telephony.lteOnCdmaProductType";
    public static final String PROPERTY_OPERATOR_ALPHA = "gsm.operator.alpha";
    public static final String PROPERTY_OPERATOR_ISMANUAL = "operator.ismanual";
    public static final String PROPERTY_OPERATOR_ISO_COUNTRY = "gsm.operator.iso-country";
    public static final String PROPERTY_OPERATOR_ISROAMING = "gsm.operator.isroaming";
    public static final String PROPERTY_OPERATOR_NUMERIC = "gsm.operator.numeric";
    public static final String PROPERTY_OTASP_NUM_SCHEMA = "ro.cdma.otaspnumschema";
    public static final String PROPERTY_RESET_ON_RADIO_TECH_CHANGE = "persist.radio.reset_on_switch";
    public static final String PROPERTY_RIL_IMPL = "gsm.version.ril-impl";
    public static final String PROPERTY_RIL_SENDS_MULTIPLE_CALL_RING = "ro.telephony.call_ring.multiple";
    public static final String PROPERTY_SIM_STATE = "gsm.sim.state";
    public static final String PROPERTY_SMS_RECEIVE = "telephony.sms.receive";
    public static final String PROPERTY_SMS_SEND = "telephony.sms.send";
    public static final String PROPERTY_TEST_CSIM = "persist.radio.test-csim";
    public static final String PROPERTY_WAKE_LOCK_TIMEOUT = "ro.ril.wake_lock_timeout";
}
