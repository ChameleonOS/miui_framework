// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.PendingIntent;
import android.net.*;
import android.os.*;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.TimeUtils;
import com.android.internal.util.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package com.android.internal.telephony:
//            DataCallState, ApnContext, DataConnectionTracker, CommandException, 
//            PhoneBase, CommandsInterface, RetryManager, DataConnectionAc, 
//            ApnSetting

public abstract class DataConnection extends StateMachine {
    private class DcDisconnectionErrorCreatingConnection extends State {

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 262147 262147: default 24
        //                       262147 28;
               goto _L1 _L2
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            ConnectionParams connectionparams = (ConnectionParams)((AsyncResult)message.obj).userObj;
            if(connectionparams.tag == mTag) {
                log("DcDisconnectionErrorCreatingConnection msg.what=EVENT_DEACTIVATE_DONE");
                mInactiveState.setEnterNotificationParams(connectionparams, FailCause.UNACCEPTABLE_NETWORK_PARAMETER, -1);
                transitionTo(mInactiveState);
            } else {
                log((new StringBuilder()).append("DcDisconnectionErrorCreatingConnection EVENT_DEACTIVATE_DONE stale dp.tag=").append(connectionparams.tag).append(", mTag=").append(mTag).toString());
            }
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        final DataConnection this$0;

        private DcDisconnectionErrorCreatingConnection() {
            this$0 = DataConnection.this;
            super();
        }

    }

    private class DcDisconnectingState extends State {

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 262144 262147: default 36
        //                       262144 42
        //                       262145 36
        //                       262146 36
        //                       262147 88;
               goto _L1 _L2 _L1 _L1 _L3
_L1:
            boolean flag = false;
_L5:
            return flag;
_L2:
            log((new StringBuilder()).append("DcDisconnectingState msg.what=EVENT_CONNECT. Defer. RefCount = ").append(mRefCount).toString());
            deferMessage(message);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            log("DcDisconnectingState msg.what=EVENT_DEACTIVATE_DONE");
            AsyncResult asyncresult = (AsyncResult)message.obj;
            DisconnectParams disconnectparams = (DisconnectParams)asyncresult.userObj;
            if(disconnectparams.tag == mTag) {
                mInactiveState.setEnterNotificationParams((DisconnectParams)asyncresult.userObj);
                transitionTo(mInactiveState);
            } else {
                log((new StringBuilder()).append("DcDisconnectState EVENT_DEACTIVATE_DONE stale dp.tag=").append(disconnectparams.tag).append(" mTag=").append(mTag).toString());
            }
            flag = true;
            if(true) goto _L5; else goto _L4
_L4:
        }

        final DataConnection this$0;

        private DcDisconnectingState() {
            this$0 = DataConnection.this;
            super();
        }

    }

    private class DcActiveState extends State {

        public void enter() {
            if(mConnectionParams != null && mFailCause != null)
                notifyConnectCompleted(mConnectionParams, mFailCause);
        }

        public void exit() {
            mConnectionParams = null;
            mFailCause = null;
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 3: default 40
        //                       262144: 44
        //                       262148: 123
        //                       262150: 258;
               goto _L1 _L2 _L3 _L4
_L1:
            boolean flag = false;
_L9:
            return flag;
_L2:
            DataConnection dataconnection1 = DataConnection.this;
            dataconnection1.mRefCount = 1 + dataconnection1.mRefCount;
            log((new StringBuilder()).append("DcActiveState msg.what=EVENT_CONNECT RefCount=").append(mRefCount).toString());
            if(message.obj != null)
                notifyConnectCompleted((ConnectionParams)message.obj, FailCause.NONE);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            DataConnection dataconnection = DataConnection.this;
            dataconnection.mRefCount = -1 + dataconnection.mRefCount;
            log((new StringBuilder()).append("DcActiveState msg.what=EVENT_DISCONNECT RefCount=").append(mRefCount).toString());
            if(mRefCount != 0) goto _L6; else goto _L5
_L5:
            DisconnectParams disconnectparams1 = (DisconnectParams)message.obj;
            disconnectparams1.tag = mTag;
            tearDownData(disconnectparams1);
            transitionTo(mDisconnectingState);
_L7:
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            if(message.obj != null)
                notifyDisconnectCompleted((DisconnectParams)message.obj, false);
            if(true) goto _L7; else goto _L4
_L4:
            log((new StringBuilder()).append("DcActiveState msg.what=EVENT_DISCONNECT_ALL RefCount=").append(mRefCount).toString());
            mRefCount = 0;
            DisconnectParams disconnectparams = (DisconnectParams)message.obj;
            disconnectparams.tag = mTag;
            tearDownData(disconnectparams);
            transitionTo(mDisconnectingState);
            flag = true;
            if(true) goto _L9; else goto _L8
_L8:
        }

        public void setEnterNotificationParams(ConnectionParams connectionparams, FailCause failcause) {
            mConnectionParams = connectionparams;
            mFailCause = failcause;
        }

        private ConnectionParams mConnectionParams;
        private FailCause mFailCause;
        final DataConnection this$0;

        private DcActiveState() {
            this$0 = DataConnection.this;
            super();
            mConnectionParams = null;
            mFailCause = null;
        }

    }

    private class DcActivatingState extends State {

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 262144 262146: default 32
        //                       262144 38
        //                       262145 84
        //                       262146 375;
               goto _L1 _L2 _L3 _L4
_L1:
            boolean flag = false;
_L14:
            return flag;
_L2:
            log((new StringBuilder()).append("DcActivatingState deferring msg.what=EVENT_CONNECT refCount = ").append(mRefCount).toString());
            deferMessage(message);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            AsyncResult asyncresult1;
            ConnectionParams connectionparams1;
            DataCallState.SetupResult setupresult;
            log("DcActivatingState msg.what=EVENT_SETUP_DATA_CONNECTION_DONE");
            asyncresult1 = (AsyncResult)message.obj;
            connectionparams1 = (ConnectionParams)asyncresult1.userObj;
            setupresult = onSetupConnectionCompleted(asyncresult1);
            log((new StringBuilder()).append("DcActivatingState onSetupConnectionCompleted result=").append(setupresult).toString());
            class _cls1 {

                static final int $SwitchMap$com$android$internal$telephony$DataCallState$SetupResult[];

                static  {
                    $SwitchMap$com$android$internal$telephony$DataCallState$SetupResult = new int[DataCallState.SetupResult.values().length];
                    NoSuchFieldError nosuchfielderror5;
                    try {
                        $SwitchMap$com$android$internal$telephony$DataCallState$SetupResult[DataCallState.SetupResult.SUCCESS.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError nosuchfielderror) { }
                    try {
                        $SwitchMap$com$android$internal$telephony$DataCallState$SetupResult[DataCallState.SetupResult.ERR_BadCommand.ordinal()] = 2;
                    }
                    catch(NoSuchFieldError nosuchfielderror1) { }
                    try {
                        $SwitchMap$com$android$internal$telephony$DataCallState$SetupResult[DataCallState.SetupResult.ERR_UnacceptableParameter.ordinal()] = 3;
                    }
                    catch(NoSuchFieldError nosuchfielderror2) { }
                    try {
                        $SwitchMap$com$android$internal$telephony$DataCallState$SetupResult[DataCallState.SetupResult.ERR_GetLastErrorFromRil.ordinal()] = 4;
                    }
                    catch(NoSuchFieldError nosuchfielderror3) { }
                    try {
                        $SwitchMap$com$android$internal$telephony$DataCallState$SetupResult[DataCallState.SetupResult.ERR_RilError.ordinal()] = 5;
                    }
                    catch(NoSuchFieldError nosuchfielderror4) { }
                    $SwitchMap$com$android$internal$telephony$DataCallState$SetupResult[DataCallState.SetupResult.ERR_Stale.ordinal()] = 6;
_L2:
                    return;
                    nosuchfielderror5;
                    if(true) goto _L2; else goto _L1
_L1:
                }
            }

            _cls1..SwitchMap.com.android.internal.telephony.DataCallState.SetupResult[setupresult.ordinal()];
            JVM INSTR tableswitch 1 6: default 196
        //                       1 206
        //                       2 241
        //                       3 277
        //                       4 303
        //                       5 332
        //                       6 235;
               goto _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
            break; /* Loop/switch isn't completed */
_L5:
            throw new RuntimeException("Unknown SetupResult, should not happen");
_L6:
            mActiveState.setEnterNotificationParams(connectionparams1, FailCause.NONE);
            transitionTo(mActiveState);
_L12:
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            mInactiveState.setEnterNotificationParams(connectionparams1, setupresult.mFailCause, -1);
            transitionTo(mInactiveState);
            continue; /* Loop/switch isn't completed */
_L8:
            tearDownData(connectionparams1);
            transitionTo(mDisconnectingErrorCreatingConnection);
            continue; /* Loop/switch isn't completed */
_L9:
            phone.mCM.getLastDataCallFailCause(obtainMessage(0x40002, connectionparams1));
            continue; /* Loop/switch isn't completed */
_L10:
            mInactiveState.setEnterNotificationParams(connectionparams1, setupresult.mFailCause, getSuggestedRetryTime(asyncresult1));
            transitionTo(mInactiveState);
            if(true) goto _L12; else goto _L4
_L4:
            AsyncResult asyncresult = (AsyncResult)message.obj;
            ConnectionParams connectionparams = (ConnectionParams)asyncresult.userObj;
            FailCause failcause = FailCause.UNKNOWN;
            if(connectionparams.tag == mTag) {
                log("DcActivatingState msg.what=EVENT_GET_LAST_FAIL_DONE");
                if(asyncresult.exception == null)
                    failcause = FailCause.fromInt(((int[])(int[])asyncresult.result)[0]);
                mInactiveState.setEnterNotificationParams(connectionparams, failcause, -1);
                transitionTo(mInactiveState);
            } else {
                log((new StringBuilder()).append("DcActivatingState EVENT_GET_LAST_FAIL_DONE is stale cp.tag=").append(connectionparams.tag).append(", mTag=").append(mTag).toString());
            }
            flag = true;
            if(true) goto _L14; else goto _L13
_L13:
        }

        final DataConnection this$0;

        private DcActivatingState() {
            this$0 = DataConnection.this;
            super();
        }

    }

    private class DcInactiveState extends State {

        public void enter() {
            DataConnection dataconnection = DataConnection.this;
            dataconnection.mTag = 1 + dataconnection.mTag;
            if(mConnectionParams != null && mFailCause != null)
                notifyConnectCompleted(mConnectionParams, mFailCause);
            if(mDisconnectParams != null)
                notifyDisconnectCompleted(mDisconnectParams, true);
            clearSettings();
        }

        public void exit() {
            mConnectionParams = null;
            mFailCause = null;
            mDisconnectParams = null;
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 4: default 48
        //                       262144: 79
        //                       262148: 165
        //                       262150: 194
        //                       266254: 52;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            boolean flag = false;
_L7:
            return flag;
_L5:
            log("DcInactiveState: msg.what=RSP_RESET, ignore we're already reset");
            mAc.replyToMessage(message, 0x4100f);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            ConnectionParams connectionparams = (ConnectionParams)message.obj;
            connectionparams.tag = mTag;
            log((new StringBuilder()).append("DcInactiveState msg.what=EVENT_CONNECT.RefCount = ").append(mRefCount).toString());
            mRefCount = 1;
            onConnect(connectionparams);
            transitionTo(mActivatingState);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            log("DcInactiveState: msg.what=EVENT_DISCONNECT");
            notifyDisconnectCompleted((DisconnectParams)message.obj, false);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            log("DcInactiveState: msg.what=EVENT_DISCONNECT_ALL");
            notifyDisconnectCompleted((DisconnectParams)message.obj, false);
            flag = true;
            if(true) goto _L7; else goto _L6
_L6:
        }

        public void setEnterNotificationParams(ConnectionParams connectionparams, FailCause failcause, int i) {
            mConnectionParams = connectionparams;
            mFailCause = failcause;
            mRetryOverride = i;
        }

        public void setEnterNotificationParams(DisconnectParams disconnectparams) {
            mDisconnectParams = disconnectparams;
        }

        private ConnectionParams mConnectionParams;
        private DisconnectParams mDisconnectParams;
        private FailCause mFailCause;
        final DataConnection this$0;

        private DcInactiveState() {
            this$0 = DataConnection.this;
            super();
            mConnectionParams = null;
            mFailCause = null;
            mDisconnectParams = null;
        }

    }

    private class DcDefaultState extends State {

        public void enter() {
            phone.mCM.registerForRilConnected(getHandler(), 0x40005, null);
        }

        public void exit() {
            phone.mCM.unregisterForRilConnected(getHandler());
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 21: default 184
        //                       69633: 218
        //                       69635: 307
        //                       69636: 320
        //                       262144: 819
        //                       262148: 850
        //                       262149: 936
        //                       262150: 893
        //                       266240: 331
        //                       266242: 393
        //                       266244: 416
        //                       266246: 439
        //                       266248: 473
        //                       266250: 548
        //                       266252: 510
        //                       266254: 582
        //                       266256: 612
        //                       266258: 635
        //                       266260: 692
        //                       266262: 732
        //                       266264: 762
        //                       266266: 796;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22
_L1:
            log((new StringBuilder()).append("DcDefaultState: shouldn't happen but ignore msg.what=0x").append(Integer.toHexString(message.what)).toString());
_L24:
            return true;
_L2:
            if(mAc != null) {
                mAc.replyToMessage(message, 0x11002, 3);
            } else {
                mAc = new AsyncChannel();
                mAc.connected(null, getHandler(), message.replyTo);
                mAc.replyToMessage(message, 0x11002, 0, mId, "hi");
            }
            continue; /* Loop/switch isn't completed */
_L3:
            mAc.disconnect();
            continue; /* Loop/switch isn't completed */
_L4:
            mAc = null;
            continue; /* Loop/switch isn't completed */
_L9:
            boolean flag;
            AsyncChannel asyncchannel;
            int i;
            if(getCurrentState() == mInactiveState)
                flag = true;
            else
                flag = false;
            asyncchannel = mAc;
            if(flag)
                i = 1;
            else
                i = 0;
            asyncchannel.replyToMessage(message, 0x41001, i);
            continue; /* Loop/switch isn't completed */
_L10:
            mAc.replyToMessage(message, 0x41003, cid);
            continue; /* Loop/switch isn't completed */
_L11:
            mAc.replyToMessage(message, 0x41005, mApn);
            continue; /* Loop/switch isn't completed */
_L12:
            LinkProperties linkproperties = new LinkProperties(mLinkProperties);
            mAc.replyToMessage(message, 0x41007, linkproperties);
            continue; /* Loop/switch isn't completed */
_L13:
            ProxyProperties proxyproperties = (ProxyProperties)message.obj;
            mLinkProperties.setHttpProxy(proxyproperties);
            mAc.replyToMessage(message, 0x41009);
            continue; /* Loop/switch isn't completed */
_L15:
            DataCallState datacallstate = (DataCallState)message.obj;
            UpdateLinkPropertyResult updatelinkpropertyresult = updateLinkProperty(datacallstate);
            mAc.replyToMessage(message, 0x4100d, updatelinkpropertyresult);
            continue; /* Loop/switch isn't completed */
_L14:
            LinkCapabilities linkcapabilities = new LinkCapabilities(mCapabilities);
            mAc.replyToMessage(message, 0x4100b, linkcapabilities);
            continue; /* Loop/switch isn't completed */
_L16:
            mAc.replyToMessage(message, 0x4100f);
            transitionTo(mInactiveState);
            continue; /* Loop/switch isn't completed */
_L17:
            mAc.replyToMessage(message, 0x41011, mRefCount);
            continue; /* Loop/switch isn't completed */
_L18:
            ApnContext apncontext1 = (ApnContext)message.obj;
            if(!mApnList.contains(apncontext1))
                mApnList.add(apncontext1);
            mAc.replyToMessage(message, 0x41013);
            continue; /* Loop/switch isn't completed */
_L19:
            ApnContext apncontext = (ApnContext)message.obj;
            mApnList.remove(apncontext);
            mAc.replyToMessage(message, 0x41015);
            continue; /* Loop/switch isn't completed */
_L20:
            mAc.replyToMessage(message, 0x41017, new ArrayList(mApnList));
            continue; /* Loop/switch isn't completed */
_L21:
            PendingIntent pendingintent = (PendingIntent)message.obj;
            mReconnectIntent = pendingintent;
            mAc.replyToMessage(message, 0x41019);
            continue; /* Loop/switch isn't completed */
_L22:
            mAc.replyToMessage(message, 0x4101b, mReconnectIntent);
            continue; /* Loop/switch isn't completed */
_L5:
            log("DcDefaultState: msg.what=EVENT_CONNECT, fail not expected");
            ConnectionParams connectionparams = (ConnectionParams)message.obj;
            notifyConnectCompleted(connectionparams, FailCause.UNKNOWN);
            continue; /* Loop/switch isn't completed */
_L6:
            log((new StringBuilder()).append("DcDefaultState deferring msg.what=EVENT_DISCONNECT").append(mRefCount).toString());
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L8:
            log((new StringBuilder()).append("DcDefaultState deferring msg.what=EVENT_DISCONNECT_ALL").append(mRefCount).toString());
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L7:
            AsyncResult asyncresult = (AsyncResult)message.obj;
            if(asyncresult.exception == null) {
                mRilVersion = ((Integer)asyncresult.result).intValue();
                log((new StringBuilder()).append("DcDefaultState: msg.what=EVENT_RIL_CONNECTED mRilVersion=").append(mRilVersion).toString());
            } else {
                log("Unexpected exception on EVENT_RIL_CONNECTED");
                mRilVersion = -1;
            }
            if(true) goto _L24; else goto _L23
_L23:
        }

        final DataConnection this$0;

        private DcDefaultState() {
            this$0 = DataConnection.this;
            super();
        }

    }

    public static class UpdateLinkPropertyResult {

        public LinkProperties newLp;
        public LinkProperties oldLp;
        public DataCallState.SetupResult setupResult;

        public UpdateLinkPropertyResult(LinkProperties linkproperties) {
            setupResult = DataCallState.SetupResult.SUCCESS;
            oldLp = linkproperties;
            newLp = linkproperties;
        }
    }

    public static class CallSetupException extends Exception {

        public int getRetryOverride() {
            return mRetryOverride;
        }

        private int mRetryOverride;

        CallSetupException(int i) {
            mRetryOverride = -1;
            mRetryOverride = i;
        }
    }

    public static final class FailCause extends Enum {

        public static FailCause fromInt(int i) {
            FailCause failcause = (FailCause)sErrorCodeToFailCauseMap.get(Integer.valueOf(i));
            if(failcause == null)
                failcause = UNKNOWN;
            return failcause;
        }

        public static FailCause valueOf(String s) {
            return (FailCause)Enum.valueOf(com/android/internal/telephony/DataConnection$FailCause, s);
        }

        public static FailCause[] values() {
            return (FailCause[])$VALUES.clone();
        }

        int getErrorCode() {
            return mErrorCode;
        }

        public boolean isEventLoggable() {
            boolean flag;
            if(this == OPERATOR_BARRED || this == INSUFFICIENT_RESOURCES || this == UNKNOWN_PDP_ADDRESS_TYPE || this == USER_AUTHENTICATION || this == ACTIVATION_REJECT_GGSN || this == ACTIVATION_REJECT_UNSPECIFIED || this == SERVICE_OPTION_NOT_SUBSCRIBED || this == SERVICE_OPTION_NOT_SUPPORTED || this == SERVICE_OPTION_OUT_OF_ORDER || this == NSAPI_IN_USE || this == PROTOCOL_ERRORS || this == UNACCEPTABLE_NETWORK_PARAMETER)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isPermanentFail() {
            boolean flag;
            if(this == OPERATOR_BARRED || this == MISSING_UNKNOWN_APN || this == UNKNOWN_PDP_ADDRESS_TYPE || this == USER_AUTHENTICATION || this == SERVICE_OPTION_NOT_SUPPORTED || this == SERVICE_OPTION_NOT_SUBSCRIBED || this == NSAPI_IN_USE || this == PROTOCOL_ERRORS)
                flag = true;
            else
                flag = false;
            return flag;
        }

        private static final FailCause $VALUES[];
        public static final FailCause ACTIVATION_REJECT_GGSN;
        public static final FailCause ACTIVATION_REJECT_UNSPECIFIED;
        public static final FailCause CONNECTION_TO_DATACONNECTIONAC_BROKEN;
        public static final FailCause ERROR_UNSPECIFIED;
        public static final FailCause GPRS_REGISTRATION_FAIL;
        public static final FailCause INSUFFICIENT_RESOURCES;
        public static final FailCause MISSING_UNKNOWN_APN;
        public static final FailCause NONE;
        public static final FailCause NSAPI_IN_USE;
        public static final FailCause ONLY_IPV4_ALLOWED;
        public static final FailCause ONLY_IPV6_ALLOWED;
        public static final FailCause ONLY_SINGLE_BEARER_ALLOWED;
        public static final FailCause OPERATOR_BARRED;
        public static final FailCause PREF_RADIO_TECH_CHANGED;
        public static final FailCause PROTOCOL_ERRORS;
        public static final FailCause RADIO_NOT_AVAILABLE;
        public static final FailCause RADIO_POWER_OFF;
        public static final FailCause REGISTRATION_FAIL;
        public static final FailCause SERVICE_OPTION_NOT_SUBSCRIBED;
        public static final FailCause SERVICE_OPTION_NOT_SUPPORTED;
        public static final FailCause SERVICE_OPTION_OUT_OF_ORDER;
        public static final FailCause SIGNAL_LOST;
        public static final FailCause TETHERED_CALL_ACTIVE;
        public static final FailCause UNACCEPTABLE_NETWORK_PARAMETER;
        public static final FailCause UNKNOWN;
        public static final FailCause UNKNOWN_PDP_ADDRESS_TYPE;
        public static final FailCause USER_AUTHENTICATION;
        private static final HashMap sErrorCodeToFailCauseMap;
        private final int mErrorCode;

        static  {
            NONE = new FailCause("NONE", 0, 0);
            OPERATOR_BARRED = new FailCause("OPERATOR_BARRED", 1, 8);
            INSUFFICIENT_RESOURCES = new FailCause("INSUFFICIENT_RESOURCES", 2, 26);
            MISSING_UNKNOWN_APN = new FailCause("MISSING_UNKNOWN_APN", 3, 27);
            UNKNOWN_PDP_ADDRESS_TYPE = new FailCause("UNKNOWN_PDP_ADDRESS_TYPE", 4, 28);
            USER_AUTHENTICATION = new FailCause("USER_AUTHENTICATION", 5, 29);
            ACTIVATION_REJECT_GGSN = new FailCause("ACTIVATION_REJECT_GGSN", 6, 30);
            ACTIVATION_REJECT_UNSPECIFIED = new FailCause("ACTIVATION_REJECT_UNSPECIFIED", 7, 31);
            SERVICE_OPTION_NOT_SUPPORTED = new FailCause("SERVICE_OPTION_NOT_SUPPORTED", 8, 32);
            SERVICE_OPTION_NOT_SUBSCRIBED = new FailCause("SERVICE_OPTION_NOT_SUBSCRIBED", 9, 33);
            SERVICE_OPTION_OUT_OF_ORDER = new FailCause("SERVICE_OPTION_OUT_OF_ORDER", 10, 34);
            NSAPI_IN_USE = new FailCause("NSAPI_IN_USE", 11, 35);
            ONLY_IPV4_ALLOWED = new FailCause("ONLY_IPV4_ALLOWED", 12, 50);
            ONLY_IPV6_ALLOWED = new FailCause("ONLY_IPV6_ALLOWED", 13, 51);
            ONLY_SINGLE_BEARER_ALLOWED = new FailCause("ONLY_SINGLE_BEARER_ALLOWED", 14, 52);
            PROTOCOL_ERRORS = new FailCause("PROTOCOL_ERRORS", 15, 111);
            REGISTRATION_FAIL = new FailCause("REGISTRATION_FAIL", 16, -1);
            GPRS_REGISTRATION_FAIL = new FailCause("GPRS_REGISTRATION_FAIL", 17, -2);
            SIGNAL_LOST = new FailCause("SIGNAL_LOST", 18, -3);
            PREF_RADIO_TECH_CHANGED = new FailCause("PREF_RADIO_TECH_CHANGED", 19, -4);
            RADIO_POWER_OFF = new FailCause("RADIO_POWER_OFF", 20, -5);
            TETHERED_CALL_ACTIVE = new FailCause("TETHERED_CALL_ACTIVE", 21, -6);
            ERROR_UNSPECIFIED = new FailCause("ERROR_UNSPECIFIED", 22, 65535);
            UNKNOWN = new FailCause("UNKNOWN", 23, 0x10000);
            RADIO_NOT_AVAILABLE = new FailCause("RADIO_NOT_AVAILABLE", 24, 0x10001);
            UNACCEPTABLE_NETWORK_PARAMETER = new FailCause("UNACCEPTABLE_NETWORK_PARAMETER", 25, 0x10002);
            CONNECTION_TO_DATACONNECTIONAC_BROKEN = new FailCause("CONNECTION_TO_DATACONNECTIONAC_BROKEN", 26, 0x10003);
            FailCause afailcause[] = new FailCause[27];
            afailcause[0] = NONE;
            afailcause[1] = OPERATOR_BARRED;
            afailcause[2] = INSUFFICIENT_RESOURCES;
            afailcause[3] = MISSING_UNKNOWN_APN;
            afailcause[4] = UNKNOWN_PDP_ADDRESS_TYPE;
            afailcause[5] = USER_AUTHENTICATION;
            afailcause[6] = ACTIVATION_REJECT_GGSN;
            afailcause[7] = ACTIVATION_REJECT_UNSPECIFIED;
            afailcause[8] = SERVICE_OPTION_NOT_SUPPORTED;
            afailcause[9] = SERVICE_OPTION_NOT_SUBSCRIBED;
            afailcause[10] = SERVICE_OPTION_OUT_OF_ORDER;
            afailcause[11] = NSAPI_IN_USE;
            afailcause[12] = ONLY_IPV4_ALLOWED;
            afailcause[13] = ONLY_IPV6_ALLOWED;
            afailcause[14] = ONLY_SINGLE_BEARER_ALLOWED;
            afailcause[15] = PROTOCOL_ERRORS;
            afailcause[16] = REGISTRATION_FAIL;
            afailcause[17] = GPRS_REGISTRATION_FAIL;
            afailcause[18] = SIGNAL_LOST;
            afailcause[19] = PREF_RADIO_TECH_CHANGED;
            afailcause[20] = RADIO_POWER_OFF;
            afailcause[21] = TETHERED_CALL_ACTIVE;
            afailcause[22] = ERROR_UNSPECIFIED;
            afailcause[23] = UNKNOWN;
            afailcause[24] = RADIO_NOT_AVAILABLE;
            afailcause[25] = UNACCEPTABLE_NETWORK_PARAMETER;
            afailcause[26] = CONNECTION_TO_DATACONNECTIONAC_BROKEN;
            $VALUES = afailcause;
            sErrorCodeToFailCauseMap = new HashMap();
            FailCause afailcause1[] = values();
            int i = afailcause1.length;
            for(int j = 0; j < i; j++) {
                FailCause failcause = afailcause1[j];
                sErrorCodeToFailCauseMap.put(Integer.valueOf(failcause.getErrorCode()), failcause);
            }

        }

        private FailCause(String s, int i, int j) {
            super(s, i);
            mErrorCode = j;
        }
    }

    protected static class DisconnectParams {

        public Message onCompletedMsg;
        public String reason;
        public int tag;

        public DisconnectParams(String s, Message message) {
            reason = s;
            onCompletedMsg = message;
        }
    }

    protected static class ConnectionParams {

        public ApnSetting apn;
        public Message onCompletedMsg;
        public int tag;

        public ConnectionParams(ApnSetting apnsetting, Message message) {
            apn = apnsetting;
            onCompletedMsg = message;
        }
    }


    protected DataConnection(PhoneBase phonebase, String s, int i, RetryManager retrymanager, DataConnectionTracker dataconnectiontracker) {
        super(s);
        mApnList = null;
        mReconnectIntent = null;
        mDataConnectionTracker = null;
        mRilVersion = -1;
        mLinkProperties = new LinkProperties();
        mCapabilities = new LinkCapabilities();
        mRetryOverride = -1;
        mDefaultState = new DcDefaultState(null);
        mInactiveState = new DcInactiveState(null);
        mActivatingState = new DcActivatingState(null);
        mActiveState = new DcActiveState(null);
        mDisconnectingState = new DcDisconnectingState(null);
        mDisconnectingErrorCreatingConnection = new DcDisconnectionErrorCreatingConnection(null);
        setProcessedMessagesSize(100);
        log("DataConnection constructor E");
        phone = phonebase;
        mDataConnectionTracker = dataconnectiontracker;
        mId = i;
        mRetryMgr = retrymanager;
        cid = -1;
        setDbg(false);
        addState(mDefaultState);
        addState(mInactiveState, mDefaultState);
        addState(mActivatingState, mDefaultState);
        addState(mActiveState, mDefaultState);
        addState(mDisconnectingState, mDefaultState);
        addState(mDisconnectingErrorCreatingConnection, mDefaultState);
        setInitialState(mInactiveState);
        mApnList = new ArrayList();
        log("DataConnection constructor X");
    }

    protected static String cmdToString(int i) {
        int j = i - 0x40000;
        String s;
        if(j >= 0 && j < sCmdToString.length)
            s = sCmdToString[j];
        else
            s = null;
        return s;
    }

    private int getSuggestedRetryTime(AsyncResult asyncresult) {
        int i = -1;
        if(asyncresult.exception == null)
            i = ((DataCallState)asyncresult.result).suggestedRetryTime;
        return i;
    }

    private void notifyConnectCompleted(ConnectionParams connectionparams, FailCause failcause) {
        Message message = connectionparams.onCompletedMsg;
        if(message != null) {
            long l = System.currentTimeMillis();
            message.arg1 = cid;
            if(failcause == FailCause.NONE) {
                createTime = l;
                AsyncResult.forMessage(message);
            } else {
                lastFailCause = failcause;
                lastFailTime = l;
                AsyncResult.forMessage(message, failcause, new CallSetupException(mRetryOverride));
            }
            log((new StringBuilder()).append("notifyConnectionCompleted at ").append(l).append(" cause=").append(failcause).toString());
            message.sendToTarget();
        }
    }

    private void notifyDisconnectCompleted(DisconnectParams disconnectparams, boolean flag) {
        ApnContext apncontext = null;
        String s = null;
        if(disconnectparams.onCompletedMsg != null) {
            Message message1 = disconnectparams.onCompletedMsg;
            if(message1.obj instanceof ApnContext)
                apncontext = (ApnContext)message1.obj;
            s = disconnectparams.reason;
            AsyncResult.forMessage(message1);
            message1.sendToTarget();
        }
        if(flag) {
            Iterator iterator = mApnList.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                ApnContext apncontext1 = (ApnContext)iterator.next();
                if(apncontext1 != apncontext) {
                    if(s != null)
                        apncontext1.setReason(s);
                    Message message = mDataConnectionTracker.obtainMessage(0x4200f, apncontext1);
                    AsyncResult.forMessage(message);
                    message.sendToTarget();
                }
            } while(true);
        }
        log((new StringBuilder()).append("NotifyDisconnectCompleted DisconnectParams=").append(disconnectparams).toString());
    }

    private DataCallState.SetupResult onSetupConnectionCompleted(AsyncResult asyncresult) {
        DataCallState datacallstate = (DataCallState)asyncresult.result;
        ConnectionParams connectionparams = (ConnectionParams)asyncresult.userObj;
        DataCallState.SetupResult setupresult;
        if(asyncresult.exception != null) {
            log((new StringBuilder()).append("onSetupConnectionCompleted failed, ar.exception=").append(asyncresult.exception).append(" response=").append(datacallstate).toString());
            if((asyncresult.exception instanceof CommandException) && ((CommandException)(CommandException)asyncresult.exception).getCommandError() == CommandException.Error.RADIO_NOT_AVAILABLE) {
                setupresult = DataCallState.SetupResult.ERR_BadCommand;
                setupresult.mFailCause = FailCause.RADIO_NOT_AVAILABLE;
            } else
            if(datacallstate == null || datacallstate.version < 4) {
                setupresult = DataCallState.SetupResult.ERR_GetLastErrorFromRil;
            } else {
                setupresult = DataCallState.SetupResult.ERR_RilError;
                setupresult.mFailCause = FailCause.fromInt(datacallstate.status);
            }
        } else
        if(connectionparams.tag != mTag) {
            log((new StringBuilder()).append("BUG: onSetupConnectionCompleted is stale cp.tag=").append(connectionparams.tag).append(", mtag=").append(mTag).toString());
            setupresult = DataCallState.SetupResult.ERR_Stale;
        } else
        if(datacallstate.status != 0) {
            setupresult = DataCallState.SetupResult.ERR_RilError;
            setupresult.mFailCause = FailCause.fromInt(datacallstate.status);
        } else {
            log((new StringBuilder()).append("onSetupConnectionCompleted received DataCallState: ").append(datacallstate).toString());
            cid = datacallstate.cid;
            setupresult = updateLinkProperty(datacallstate).setupResult;
        }
        return setupresult;
    }

    private DataCallState.SetupResult setLinkProperties(DataCallState datacallstate, LinkProperties linkproperties) {
        String s = (new StringBuilder()).append("net.").append(datacallstate.ifname).append(".").toString();
        String as[] = new String[2];
        as[0] = SystemProperties.get((new StringBuilder()).append(s).append("dns1").toString());
        as[1] = SystemProperties.get((new StringBuilder()).append(s).append("dns2").toString());
        return datacallstate.setLinkProperties(linkproperties, isDnsOk(as));
    }

    private void tearDownData(Object obj) {
        int i = 0;
        if(obj != null && (obj instanceof DisconnectParams)) {
            DisconnectParams disconnectparams = (DisconnectParams)obj;
            Message _tmp = disconnectparams.onCompletedMsg;
            if(TextUtils.equals(disconnectparams.reason, "radioTurnedOff"))
                i = 1;
            else
            if(TextUtils.equals(disconnectparams.reason, "pdpReset"))
                i = 2;
        }
        if(phone.mCM.getRadioState().isOn()) {
            log("tearDownData radio is on, call deactivateDataCall");
            phone.mCM.deactivateDataCall(cid, i, obtainMessage(0x40003, obj));
        } else {
            log("tearDownData radio is off sendMessage EVENT_DEACTIVATE_DONE immediately");
            sendMessage(obtainMessage(0x40003, new AsyncResult(obj, null, null)));
        }
    }

    private UpdateLinkPropertyResult updateLinkProperty(DataCallState datacallstate) {
        UpdateLinkPropertyResult updatelinkpropertyresult = new UpdateLinkPropertyResult(mLinkProperties);
        if(datacallstate != null) {
            updatelinkpropertyresult.newLp = new LinkProperties();
            updatelinkpropertyresult.setupResult = setLinkProperties(datacallstate, updatelinkpropertyresult.newLp);
            if(updatelinkpropertyresult.setupResult != DataCallState.SetupResult.SUCCESS) {
                log((new StringBuilder()).append("updateLinkProperty failed : ").append(updatelinkpropertyresult.setupResult).toString());
            } else {
                updatelinkpropertyresult.newLp.setHttpProxy(mLinkProperties.getHttpProxy());
                if(!updatelinkpropertyresult.oldLp.equals(updatelinkpropertyresult.newLp)) {
                    log((new StringBuilder()).append("updateLinkProperty old LP=").append(updatelinkpropertyresult.oldLp).toString());
                    log((new StringBuilder()).append("updateLinkProperty new LP=").append(updatelinkpropertyresult.newLp).toString());
                }
                mLinkProperties = updatelinkpropertyresult.newLp;
            }
        }
        return updatelinkpropertyresult;
    }

    public void bringUp(Message message, ApnSetting apnsetting) {
        sendMessage(obtainMessage(0x40000, new ConnectionParams(apnsetting, message)));
    }

    protected void clearSettings() {
        log("clearSettings");
        createTime = -1L;
        lastFailTime = -1L;
        lastFailCause = FailCause.NONE;
        mRetryOverride = -1;
        mRefCount = 0;
        cid = -1;
        mLinkProperties = new LinkProperties();
        mApn = null;
    }

    public boolean configureRetry(int i, int j, int k) {
        return mRetryMgr.configure(i, j, k);
    }

    public boolean configureRetry(String s) {
        return mRetryMgr.configure(s);
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.print("DataConnection ");
        super.dump(filedescriptor, printwriter, as);
        printwriter.println((new StringBuilder()).append(" mApnList=").append(mApnList).toString());
        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" mDataConnectionTracker=").append(mDataConnectionTracker).toString());
        printwriter.println((new StringBuilder()).append(" mApn=").append(mApn).toString());
        printwriter.println((new StringBuilder()).append(" mTag=").append(mTag).toString());
        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" phone=").append(phone).toString());
        printwriter.println((new StringBuilder()).append(" mRilVersion=").append(mRilVersion).toString());
        printwriter.println((new StringBuilder()).append(" cid=").append(cid).toString());
        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" mLinkProperties=").append(mLinkProperties).toString());
        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" mCapabilities=").append(mCapabilities).toString());
        printwriter.println((new StringBuilder()).append(" createTime=").append(TimeUtils.logTimeOfDay(createTime)).toString());
        printwriter.println((new StringBuilder()).append(" lastFailTime=").append(TimeUtils.logTimeOfDay(lastFailTime)).toString());
        printwriter.println((new StringBuilder()).append(" lastFailCause=").append(lastFailCause).toString());
        printwriter.flush();
        printwriter.println((new StringBuilder()).append(" mRetryOverride=").append(mRetryOverride).toString());
        printwriter.println((new StringBuilder()).append(" mRefCount=").append(mRefCount).toString());
        printwriter.println((new StringBuilder()).append(" userData=").append(userData).toString());
        if(mRetryMgr != null)
            printwriter.println((new StringBuilder()).append(" ").append(mRetryMgr).toString());
        printwriter.flush();
    }

    public int getDataConnectionId() {
        return mId;
    }

    protected String getMessageInfo(Message message) {
        String s = cmdToString(message.what);
        if(s == null)
            s = DataConnectionAc.cmdToString(message.what);
        return s;
    }

    public int getRetryCount() {
        return mRetryMgr.getRetryCount();
    }

    public int getRetryTimer() {
        return mRetryMgr.getRetryTimer();
    }

    protected int getRilRadioTechnology(int i) {
        int j;
        if(mRilVersion < 6)
            j = i;
        else
            j = 2 + phone.getServiceState().getRilRadioTechnology();
        return j;
    }

    public void increaseRetryCount() {
        mRetryMgr.increaseRetryCount();
    }

    protected abstract boolean isDnsOk(String as[]);

    public boolean isRetryForever() {
        return mRetryMgr.isRetryForever();
    }

    public boolean isRetryNeeded() {
        return mRetryMgr.isRetryNeeded();
    }

    protected abstract void log(String s);

    protected abstract void onConnect(ConnectionParams connectionparams);

    public void resetRetryCount() {
        mRetryMgr.resetRetryCount();
    }

    public void retryForeverUsingLastTimeout() {
        mRetryMgr.retryForeverUsingLastTimeout();
    }

    public void setRetryCount(int i) {
        log((new StringBuilder()).append("setRetryCount: ").append(i).toString());
        mRetryMgr.setRetryCount(i);
    }

    public void tearDown(String s, Message message) {
        sendMessage(obtainMessage(0x40004, new DisconnectParams(s, message)));
    }

    public void tearDownAll(String s, Message message) {
        sendMessage(obtainMessage(0x40006, new DisconnectParams(s, message)));
    }

    public abstract String toString();

    protected static final int BASE = 0x40000;
    private static final int CMD_TO_STRING_COUNT = 7;
    protected static final boolean DBG = true;
    protected static final int EVENT_CONNECT = 0x40000;
    protected static final int EVENT_DEACTIVATE_DONE = 0x40003;
    protected static final int EVENT_DISCONNECT = 0x40004;
    protected static final int EVENT_DISCONNECT_ALL = 0x40006;
    protected static final int EVENT_GET_LAST_FAIL_DONE = 0x40002;
    protected static final int EVENT_LOG_BAD_DNS_ADDRESS = 50100;
    protected static final int EVENT_RIL_CONNECTED = 0x40005;
    protected static final int EVENT_SETUP_DATA_CONNECTION_DONE = 0x40001;
    protected static final String NULL_IP = "0.0.0.0";
    protected static final boolean VDBG;
    protected static int mCount;
    protected static Object mCountLock = new Object();
    private static String sCmdToString[];
    protected int cid;
    protected long createTime;
    protected FailCause lastFailCause;
    protected long lastFailTime;
    protected AsyncChannel mAc;
    private DcActivatingState mActivatingState;
    private DcActiveState mActiveState;
    protected ApnSetting mApn;
    protected List mApnList;
    protected LinkCapabilities mCapabilities;
    private DataConnectionTracker mDataConnectionTracker;
    private DcDefaultState mDefaultState;
    private DcDisconnectionErrorCreatingConnection mDisconnectingErrorCreatingConnection;
    private DcDisconnectingState mDisconnectingState;
    private int mId;
    private DcInactiveState mInactiveState;
    protected LinkProperties mLinkProperties;
    PendingIntent mReconnectIntent;
    protected int mRefCount;
    private RetryManager mRetryMgr;
    protected int mRetryOverride;
    protected int mRilVersion;
    protected int mTag;
    protected PhoneBase phone;
    Object userData;

    static  {
        sCmdToString = new String[7];
        sCmdToString[0] = "EVENT_CONNECT";
        sCmdToString[1] = "EVENT_SETUP_DATA_CONNECTION_DONE";
        sCmdToString[2] = "EVENT_GET_LAST_FAIL_DONE";
        sCmdToString[3] = "EVENT_DEACTIVATE_DONE";
        sCmdToString[4] = "EVENT_DISCONNECT";
        sCmdToString[5] = "EVENT_RIL_CONNECTED";
        sCmdToString[6] = "EVENT_DISCONNECT_ALL";
    }




























}
