// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.content.*;
import android.os.Message;
import android.util.Log;
import com.android.internal.util.*;

// Referenced classes of package android.bluetooth:
//            BluetoothDevice, BluetoothDeviceProfileState

public class BluetoothProfileState extends StateMachine {
    private class PendingCommandState extends State {

        private void dispatchMessage(Message message) {
            BluetoothDeviceProfileState bluetoothdeviceprofilestate = (BluetoothDeviceProfileState)message.obj;
            int i = message.arg1;
            if(mPendingDevice == null || mPendingDevice.equals(bluetoothdeviceprofilestate.getDevice())) {
                mPendingDevice = bluetoothdeviceprofilestate.getDevice();
                bluetoothdeviceprofilestate.sendMessage(i);
            } else {
                Message message1 = new Message();
                message1.arg1 = i;
                message1.obj = bluetoothdeviceprofilestate;
                deferMessage(message1);
            }
        }

        public void enter() {
            log("Entering PendingCommandState State");
            dispatchMessage(getCurrentMessage());
        }

        public boolean processMessage(Message message) {
            if(message.what == 100)
                transitionTo(mStableState);
            else
                dispatchMessage(message);
            return true;
        }

        final BluetoothProfileState this$0;

        private PendingCommandState() {
            this$0 = BluetoothProfileState.this;
            super();
        }

    }

    private class StableState extends State {

        public void enter() {
            log("Entering Stable State");
            mPendingDevice = null;
        }

        public boolean processMessage(Message message) {
            if(message.what != 100)
                transitionTo(mPendingCommandState);
            return true;
        }

        final BluetoothProfileState this$0;

        private StableState() {
            this$0 = BluetoothProfileState.this;
            super();
        }

    }


    public BluetoothProfileState(Context context, int i) {
        super((new StringBuilder()).append("BluetoothProfileState:").append(i).toString());
        mPendingCommandState = new PendingCommandState();
        mStableState = new StableState();
        mBroadcastReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                String s;
                BluetoothDevice bluetoothdevice;
                s = intent.getAction();
                bluetoothdevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if(bluetoothdevice != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if(s.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    int l = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                    if(mProfile == 0 && (l == 2 || l == 0))
                        sendMessage(100);
                } else
                if(s.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                    int k = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                    if(mProfile == 1 && (k == 2 || k == 0))
                        sendMessage(100);
                } else
                if(s.equals("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED")) {
                    int j = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                    if(mProfile == 2 && (j == 2 || j == 0))
                        sendMessage(100);
                } else
                if(s.equals("android.bluetooth.device.action.ACL_DISCONNECTED") && bluetoothdevice.equals(mPendingDevice))
                    sendMessage(100);
                if(true) goto _L1; else goto _L3
_L3:
            }

            final BluetoothProfileState this$0;

             {
                this$0 = BluetoothProfileState.this;
                super();
            }
        };
        mProfile = i;
        addState(mStableState);
        addState(mPendingCommandState);
        setInitialState(mStableState);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        context.registerReceiver(mBroadcastReceiver, intentfilter);
    }

    private void log(String s) {
        Log.i("BluetoothProfileState", (new StringBuilder()).append("Message:").append(s).toString());
    }

    public static final int A2DP = 1;
    private static final boolean DBG = true;
    public static final int HFP = 0;
    public static final int HID = 2;
    private static final String TAG = "BluetoothProfileState";
    static final int TRANSITION_TO_STABLE = 100;
    private BroadcastReceiver mBroadcastReceiver;
    private PendingCommandState mPendingCommandState;
    private BluetoothDevice mPendingDevice;
    private int mProfile;
    private StableState mStableState;





/*
    static BluetoothDevice access$302(BluetoothProfileState bluetoothprofilestate, BluetoothDevice bluetoothdevice) {
        bluetoothprofilestate.mPendingDevice = bluetoothdevice;
        return bluetoothdevice;
    }

*/






}
