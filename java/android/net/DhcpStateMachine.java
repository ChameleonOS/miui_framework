// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.*;
import android.os.*;
import android.util.Log;
import com.android.internal.util.*;

// Referenced classes of package android.net:
//            DhcpInfoInternal, NetworkUtils

public class DhcpStateMachine extends StateMachine {
    class WaitBeforeRenewalState extends State {

        public void enter() {
        }

        public void exit() {
            mDhcpRenewWakeLock.release();
        }

        public boolean processMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR tableswitch 196609 196614: default 44
        //                       196609 46
        //                       196610 48
        //                       196611 44
        //                       196612 44
        //                       196613 44
        //                       196614 126;
               goto _L1 _L2 _L3 _L1 _L1 _L1 _L4
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            flag = false;
_L6:
            return flag;
_L3:
            mAlarmManager.cancel(mDhcpRenewalIntent);
            if(!NetworkUtils.stopDhcp(mInterfaceName))
                Log.e("DhcpStateMachine", (new StringBuilder()).append("Failed to stop Dhcp on ").append(mInterfaceName).toString());
            transitionTo(mStoppedState);
            continue; /* Loop/switch isn't completed */
_L4:
            if(runDhcp(DhcpAction.RENEW))
                transitionTo(mRunningState);
            else
                transitionTo(mStoppedState);
            if(true) goto _L6; else goto _L5
_L5:
        }

        final DhcpStateMachine this$0;

        WaitBeforeRenewalState() {
            this$0 = DhcpStateMachine.this;
            super();
        }
    }

    class RunningState extends State {

        public void enter() {
        }

        public boolean processMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR tableswitch 196609 196611: default 32
        //                       196609 34
        //                       196610 36
        //                       196611 114;
               goto _L1 _L2 _L3 _L4
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            flag = false;
_L6:
            return flag;
_L3:
            mAlarmManager.cancel(mDhcpRenewalIntent);
            if(!NetworkUtils.stopDhcp(mInterfaceName))
                Log.e("DhcpStateMachine", (new StringBuilder()).append("Failed to stop Dhcp on ").append(mInterfaceName).toString());
            transitionTo(mStoppedState);
            continue; /* Loop/switch isn't completed */
_L4:
            if(mRegisteredForPreDhcpNotification) {
                mController.sendMessage(0x30004);
                transitionTo(mWaitBeforeRenewalState);
            } else {
                if(!runDhcp(DhcpAction.RENEW))
                    transitionTo(mStoppedState);
                mDhcpRenewWakeLock.release();
            }
            if(true) goto _L6; else goto _L5
_L5:
        }

        final DhcpStateMachine this$0;

        RunningState() {
            this$0 = DhcpStateMachine.this;
            super();
        }
    }

    class WaitBeforeStartState extends State {

        public void enter() {
        }

        public boolean processMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR tableswitch 196609 196614: default 44
        //                       196609 46
        //                       196610 95
        //                       196611 44
        //                       196612 44
        //                       196613 44
        //                       196614 48;
               goto _L1 _L2 _L3 _L1 _L1 _L1 _L4
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            flag = false;
_L6:
            return flag;
_L4:
            if(runDhcp(DhcpAction.START))
                transitionTo(mRunningState);
            else
                transitionTo(mStoppedState);
            continue; /* Loop/switch isn't completed */
_L3:
            transitionTo(mStoppedState);
            if(true) goto _L6; else goto _L5
_L5:
        }

        final DhcpStateMachine this$0;

        WaitBeforeStartState() {
            this$0 = DhcpStateMachine.this;
            super();
        }
    }

    class StoppedState extends State {

        public void enter() {
        }

        public boolean processMessage(Message message) {
            boolean flag = true;
            message.what;
            JVM INSTR tableswitch 196609 196610: default 28
        //                       196609 32
        //                       196610 30;
               goto _L1 _L2 _L3
_L1:
            flag = false;
_L3:
            return flag;
_L2:
            if(mRegisteredForPreDhcpNotification) {
                mController.sendMessage(0x30004);
                transitionTo(mWaitBeforeStartState);
            } else
            if(runDhcp(DhcpAction.START))
                transitionTo(mRunningState);
            if(true) goto _L3; else goto _L4
_L4:
        }

        final DhcpStateMachine this$0;

        StoppedState() {
            this$0 = DhcpStateMachine.this;
            super();
        }
    }

    class DefaultState extends State {

        public boolean processMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 2: default 32
        //                       -1: 105
        //                       196611: 61;
               goto _L1 _L2 _L3
_L2:
            break MISSING_BLOCK_LABEL_105;
_L1:
            Log.e("DhcpStateMachine", (new StringBuilder()).append("Error! unhandled message  ").append(message).toString());
_L4:
            boolean flag = true;
_L5:
            return flag;
_L3:
            Log.e("DhcpStateMachine", (new StringBuilder()).append("Error! Failed to handle a DHCP renewal on ").append(mInterfaceName).toString());
            mDhcpRenewWakeLock.release();
              goto _L4
            mContext.unregisterReceiver(mBroadcastReceiver);
            flag = false;
              goto _L5
        }

        final DhcpStateMachine this$0;

        DefaultState() {
            this$0 = DhcpStateMachine.this;
            super();
        }
    }

    private static final class DhcpAction extends Enum {

        public static DhcpAction valueOf(String s) {
            return (DhcpAction)Enum.valueOf(android/net/DhcpStateMachine$DhcpAction, s);
        }

        public static DhcpAction[] values() {
            return (DhcpAction[])$VALUES.clone();
        }

        private static final DhcpAction $VALUES[];
        public static final DhcpAction RENEW;
        public static final DhcpAction START;

        static  {
            START = new DhcpAction("START", 0);
            RENEW = new DhcpAction("RENEW", 1);
            DhcpAction adhcpaction[] = new DhcpAction[2];
            adhcpaction[0] = START;
            adhcpaction[1] = RENEW;
            $VALUES = adhcpaction;
        }

        private DhcpAction(String s, int i) {
            super(s, i);
        }
    }


    private DhcpStateMachine(Context context, StateMachine statemachine, String s) {
        super("DhcpStateMachine");
        mRegisteredForPreDhcpNotification = false;
        mDefaultState = new DefaultState();
        mStoppedState = new StoppedState();
        mWaitBeforeStartState = new WaitBeforeStartState();
        mRunningState = new RunningState();
        mWaitBeforeRenewalState = new WaitBeforeRenewalState();
        mContext = context;
        mController = statemachine;
        mInterfaceName = s;
        mAlarmManager = (AlarmManager)mContext.getSystemService("alarm");
        Intent intent = new Intent("android.net.wifi.DHCP_RENEW", null);
        mDhcpRenewalIntent = PendingIntent.getBroadcast(mContext, 0, intent, 0);
        mDhcpRenewWakeLock = ((PowerManager)mContext.getSystemService("power")).newWakeLock(1, "DHCP");
        mDhcpRenewWakeLock.setReferenceCounted(false);
        mBroadcastReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent1) {
                mDhcpRenewWakeLock.acquire(40000L);
                sendMessage(0x30003);
            }

            final DhcpStateMachine this$0;

             {
                this$0 = DhcpStateMachine.this;
                super();
            }
        };
        mContext.registerReceiver(mBroadcastReceiver, new IntentFilter("android.net.wifi.DHCP_RENEW"));
        addState(mDefaultState);
        addState(mStoppedState, mDefaultState);
        addState(mWaitBeforeStartState, mDefaultState);
        addState(mRunningState, mDefaultState);
        addState(mWaitBeforeRenewalState, mDefaultState);
        setInitialState(mStoppedState);
    }

    public static DhcpStateMachine makeDhcpStateMachine(Context context, StateMachine statemachine, String s) {
        DhcpStateMachine dhcpstatemachine = new DhcpStateMachine(context, statemachine, s);
        dhcpstatemachine.start();
        return dhcpstatemachine;
    }

    private boolean runDhcp(DhcpAction dhcpaction) {
        boolean flag = false;
        DhcpInfoInternal dhcpinfointernal = new DhcpInfoInternal();
        if(dhcpaction == DhcpAction.START) {
            flag = NetworkUtils.runDhcp(mInterfaceName, dhcpinfointernal);
            mDhcpInfo = dhcpinfointernal;
        } else
        if(dhcpaction == DhcpAction.RENEW) {
            flag = NetworkUtils.runDhcpRenew(mInterfaceName, dhcpinfointernal);
            dhcpinfointernal.updateFromDhcpRequest(mDhcpInfo);
        }
        if(flag) {
            long l = dhcpinfointernal.leaseDuration;
            if(l >= 0L) {
                if(l < 300L)
                    l = 300L;
                mAlarmManager.set(2, SystemClock.elapsedRealtime() + 480L * l, mDhcpRenewalIntent);
            }
            mController.obtainMessage(0x30005, 1, 0, dhcpinfointernal).sendToTarget();
        } else {
            Log.e("DhcpStateMachine", (new StringBuilder()).append("DHCP failed on ").append(mInterfaceName).append(": ").append(NetworkUtils.getDhcpError()).toString());
            NetworkUtils.stopDhcp(mInterfaceName);
            mController.obtainMessage(0x30005, 2, 0).sendToTarget();
        }
        return flag;
    }

    public void registerForPreDhcpNotification() {
        mRegisteredForPreDhcpNotification = true;
    }

    private static final String ACTION_DHCP_RENEW = "android.net.wifi.DHCP_RENEW";
    private static final int BASE = 0x30000;
    public static final int CMD_POST_DHCP_ACTION = 0x30005;
    public static final int CMD_PRE_DHCP_ACTION = 0x30004;
    public static final int CMD_PRE_DHCP_ACTION_COMPLETE = 0x30006;
    public static final int CMD_RENEW_DHCP = 0x30003;
    public static final int CMD_START_DHCP = 0x30001;
    public static final int CMD_STOP_DHCP = 0x30002;
    private static final boolean DBG = false;
    public static final int DHCP_FAILURE = 2;
    private static final int DHCP_RENEW = 0;
    public static final int DHCP_SUCCESS = 1;
    private static final int MIN_RENEWAL_TIME_SECS = 300;
    private static final String TAG = "DhcpStateMachine";
    private static final String WAKELOCK_TAG = "DHCP";
    private AlarmManager mAlarmManager;
    private BroadcastReceiver mBroadcastReceiver;
    private Context mContext;
    private StateMachine mController;
    private State mDefaultState;
    private DhcpInfoInternal mDhcpInfo;
    private android.os.PowerManager.WakeLock mDhcpRenewWakeLock;
    private PendingIntent mDhcpRenewalIntent;
    private String mInterfaceName;
    private boolean mRegisteredForPreDhcpNotification;
    private State mRunningState;
    private State mStoppedState;
    private State mWaitBeforeRenewalState;
    private State mWaitBeforeStartState;
























}
