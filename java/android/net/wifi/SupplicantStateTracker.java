// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.internal.util.*;

// Referenced classes of package android.net.wifi:
//            WifiConfigStore, StateChangeResult, SupplicantState, WifiStateMachine

class SupplicantStateTracker extends StateMachine {
    class DormantState extends State {

        public void enter() {
        }

        final SupplicantStateTracker this$0;

        DormantState() {
            this$0 = SupplicantStateTracker.this;
            super();
        }
    }

    class CompletedState extends State {

        public void enter() {
            mAuthenticationFailuresCount = 0;
            if(mNetworksDisabledDuringConnect) {
                mWifiConfigStore.enableAllNetworks();
                mNetworksDisabledDuringConnect = false;
            }
        }

        public boolean processMessage(Message message) {
            boolean flag = false;
            message.what;
            JVM INSTR lookupswitch 2: default 32
        //                       131183: 88
        //                       147462: 34;
               goto _L1 _L2 _L3
_L1:
            return flag;
_L3:
            StateChangeResult statechangeresult = (StateChangeResult)message.obj;
            SupplicantState supplicantstate = statechangeresult.state;
            sendSupplicantStateChangedBroadcast(supplicantstate, mAuthFailureInSupplicantBroadcast);
            if(!SupplicantState.isConnecting(supplicantstate))
                transitionOnSupplicantStateChange(statechangeresult);
_L4:
            flag = true;
            if(true) goto _L1; else goto _L2
_L2:
            sendSupplicantStateChangedBroadcast(SupplicantState.DISCONNECTED, false);
            transitionTo(mUninitializedState);
              goto _L4
        }

        final SupplicantStateTracker this$0;

        CompletedState() {
            this$0 = SupplicantStateTracker.this;
            super();
        }
    }

    class HandshakeState extends State {

        public void enter() {
            mLoopDetectIndex = 0;
            mLoopDetectCount = 0;
        }

        public boolean processMessage(Message message) {
            boolean flag = false;
            message.what;
            JVM INSTR tableswitch 147462 147462: default 24
        //                       147462 26;
               goto _L1 _L2
_L1:
            return flag;
_L2:
            StateChangeResult statechangeresult = (StateChangeResult)message.obj;
            SupplicantState supplicantstate = statechangeresult.state;
            if(SupplicantState.isHandshakeState(supplicantstate)) {
                if(mLoopDetectIndex > supplicantstate.ordinal())
                    mLoopDetectCount = 1 + mLoopDetectCount;
                if(mLoopDetectCount > 4) {
                    Log.d("SupplicantStateTracker", (new StringBuilder()).append("Supplicant loop detected, disabling network ").append(statechangeresult.networkId).toString());
                    handleNetworkConnectionFailure(statechangeresult.networkId);
                }
                mLoopDetectIndex = supplicantstate.ordinal();
                sendSupplicantStateChangedBroadcast(supplicantstate, mAuthFailureInSupplicantBroadcast);
                flag = true;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private static final int MAX_SUPPLICANT_LOOP_ITERATIONS = 4;
        private int mLoopDetectCount;
        private int mLoopDetectIndex;
        final SupplicantStateTracker this$0;

        HandshakeState() {
            this$0 = SupplicantStateTracker.this;
            super();
        }
    }

    class ScanState extends State {

        public void enter() {
        }

        final SupplicantStateTracker this$0;

        ScanState() {
            this$0 = SupplicantStateTracker.this;
            super();
        }
    }

    class DisconnectedState extends State {

        public void enter() {
            StateChangeResult statechangeresult = (StateChangeResult)getCurrentMessage().obj;
            if(mAuthenticationFailuresCount >= 2) {
                Log.d("SupplicantStateTracker", (new StringBuilder()).append("Failed to authenticate, disabling network ").append(statechangeresult.networkId).toString());
                handleNetworkConnectionFailure(statechangeresult.networkId);
                mAuthenticationFailuresCount = 0;
            }
        }

        final SupplicantStateTracker this$0;

        DisconnectedState() {
            this$0 = SupplicantStateTracker.this;
            super();
        }
    }

    class InactiveState extends State {

        public void enter() {
        }

        final SupplicantStateTracker this$0;

        InactiveState() {
            this$0 = SupplicantStateTracker.this;
            super();
        }
    }

    class UninitializedState extends State {

        public void enter() {
        }

        final SupplicantStateTracker this$0;

        UninitializedState() {
            this$0 = SupplicantStateTracker.this;
            super();
        }
    }

    class DefaultState extends State {

        public void enter() {
        }

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 4: default 48
        //                       131183: 145
        //                       147462: 95
        //                       147463: 75
        //                       151553: 162;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            Log.e("SupplicantStateTracker", (new StringBuilder()).append("Ignoring ").append(message).toString());
_L7:
            return true;
_L4:
            int i = this.access$100;
            mAuthFailureInSupplicantBroadcast = true;
            continue; /* Loop/switch isn't completed */
_L3:
            StateChangeResult statechangeresult = (StateChangeResult)message.obj;
            SupplicantState supplicantstate = statechangeresult.state;
            sendSupplicantStateChangedBroadcast(supplicantstate, mAuthFailureInSupplicantBroadcast);
            mAuthFailureInSupplicantBroadcast = false;
            transitionOnSupplicantStateChange(statechangeresult);
            continue; /* Loop/switch isn't completed */
_L2:
            transitionTo(mUninitializedState);
            continue; /* Loop/switch isn't completed */
_L5:
            mNetworksDisabledDuringConnect = true;
            if(true) goto _L7; else goto _L6
_L6:
        }

        final SupplicantStateTracker this$0;

        DefaultState() {
            this$0 = SupplicantStateTracker.this;
            super();
        }
    }


    public SupplicantStateTracker(Context context, WifiStateMachine wifistatemachine, WifiConfigStore wificonfigstore, Handler handler) {
        super("SupplicantStateTracker", handler.getLooper());
        mAuthenticationFailuresCount = 0;
        mAuthFailureInSupplicantBroadcast = false;
        mNetworksDisabledDuringConnect = false;
        mUninitializedState = new UninitializedState();
        mDefaultState = new DefaultState();
        mInactiveState = new InactiveState();
        mDisconnectState = new DisconnectedState();
        mScanState = new ScanState();
        mHandshakeState = new HandshakeState();
        mCompletedState = new CompletedState();
        mDormantState = new DormantState();
        mContext = context;
        mWifiStateMachine = wifistatemachine;
        mWifiConfigStore = wificonfigstore;
        addState(mDefaultState);
        addState(mUninitializedState, mDefaultState);
        addState(mInactiveState, mDefaultState);
        addState(mDisconnectState, mDefaultState);
        addState(mScanState, mDefaultState);
        addState(mHandshakeState, mDefaultState);
        addState(mCompletedState, mDefaultState);
        addState(mDormantState, mDefaultState);
        setInitialState(mUninitializedState);
        start();
    }

    private void handleNetworkConnectionFailure(int i) {
        if(mNetworksDisabledDuringConnect) {
            mWifiConfigStore.enableAllNetworks();
            mNetworksDisabledDuringConnect = false;
        }
        mWifiConfigStore.disableNetwork(i, 3);
    }

    private void sendSupplicantStateChangedBroadcast(SupplicantState supplicantstate, boolean flag) {
        Intent intent = new Intent("android.net.wifi.supplicant.STATE_CHANGE");
        intent.addFlags(0x28000000);
        intent.putExtra("newState", supplicantstate);
        if(flag)
            intent.putExtra("supplicantError", 1);
        mContext.sendStickyBroadcast(intent);
    }

    private void transitionOnSupplicantStateChange(StateChangeResult statechangeresult) {
        SupplicantState supplicantstate = statechangeresult.state;
        class _cls1 {

            static final int $SwitchMap$android$net$wifi$SupplicantState[];

            static  {
                $SwitchMap$android$net$wifi$SupplicantState = new int[SupplicantState.values().length];
                NoSuchFieldError nosuchfielderror12;
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.DISCONNECTED.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INTERFACE_DISABLED.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.SCANNING.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.AUTHENTICATING.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.ASSOCIATING.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.ASSOCIATED.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 8;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.COMPLETED.ordinal()] = 9;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.DORMANT.ordinal()] = 10;
                }
                catch(NoSuchFieldError nosuchfielderror9) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INACTIVE.ordinal()] = 11;
                }
                catch(NoSuchFieldError nosuchfielderror10) { }
                try {
                    $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.UNINITIALIZED.ordinal()] = 12;
                }
                catch(NoSuchFieldError nosuchfielderror11) { }
                $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INVALID.ordinal()] = 13;
_L2:
                return;
                nosuchfielderror12;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.android.net.wifi.SupplicantState[supplicantstate.ordinal()];
        JVM INSTR tableswitch 1 13: default 80
    //                   1 106
    //                   2 105
    //                   3 117
    //                   4 128
    //                   5 128
    //                   6 128
    //                   7 128
    //                   8 128
    //                   9 139
    //                   10 150
    //                   11 161
    //                   12 172
    //                   13 172;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L5 _L5 _L5 _L6 _L7 _L8 _L9 _L9
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        Log.e("SupplicantStateTracker", (new StringBuilder()).append("Unknown supplicant state ").append(supplicantstate).toString());
_L11:
        return;
_L2:
        transitionTo(mDisconnectState);
        continue; /* Loop/switch isn't completed */
_L4:
        transitionTo(mScanState);
        continue; /* Loop/switch isn't completed */
_L5:
        transitionTo(mHandshakeState);
        continue; /* Loop/switch isn't completed */
_L6:
        transitionTo(mCompletedState);
        continue; /* Loop/switch isn't completed */
_L7:
        transitionTo(mDormantState);
        continue; /* Loop/switch isn't completed */
_L8:
        transitionTo(mInactiveState);
        continue; /* Loop/switch isn't completed */
_L9:
        transitionTo(mUninitializedState);
        if(true) goto _L11; else goto _L10
_L10:
    }

    private static final boolean DBG = false;
    private static final int MAX_RETRIES_ON_AUTHENTICATION_FAILURE = 2;
    private static final String TAG = "SupplicantStateTracker";
    private boolean mAuthFailureInSupplicantBroadcast;
    private int mAuthenticationFailuresCount;
    private State mCompletedState;
    private Context mContext;
    private State mDefaultState;
    private State mDisconnectState;
    private State mDormantState;
    private State mHandshakeState;
    private State mInactiveState;
    private boolean mNetworksDisabledDuringConnect;
    private State mScanState;
    private State mUninitializedState;
    private WifiConfigStore mWifiConfigStore;
    private WifiStateMachine mWifiStateMachine;



/*
    static int access$002(SupplicantStateTracker supplicantstatetracker, int i) {
        supplicantstatetracker.mAuthenticationFailuresCount = i;
        return i;
    }

*/


/*
    static int access$008(SupplicantStateTracker supplicantstatetracker) {
        int i = supplicantstatetracker.mAuthenticationFailuresCount;
        supplicantstatetracker.mAuthenticationFailuresCount = i + 1;
        return i;
    }

*/




/*
    static boolean access$102(SupplicantStateTracker supplicantstatetracker, boolean flag) {
        supplicantstatetracker.mAuthFailureInSupplicantBroadcast = flag;
        return flag;
    }

*/







/*
    static boolean access$602(SupplicantStateTracker supplicantstatetracker, boolean flag) {
        supplicantstatetracker.mNetworksDisabledDuringConnect = flag;
        return flag;
    }

*/



}
