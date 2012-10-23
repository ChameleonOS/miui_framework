// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.content.*;
import android.os.Message;
import android.os.PowerManager;
import android.server.BluetoothA2dpService;
import android.server.BluetoothService;
import android.util.Log;
import android.util.Pair;
import com.android.internal.util.*;
import java.util.List;

// Referenced classes of package android.bluetooth:
//            BluetoothDevice, BluetoothAdapter, BluetoothHeadset, BluetoothPbap, 
//            BluetoothProfile

public final class BluetoothDeviceProfileState extends StateMachine {
    private class IncomingHid extends State {

        public void enter() {
            log((new StringBuilder()).append("Entering IncomingHid state with: ").append(getCurrentMessage().what).toString());
            mCommand = getCurrentMessage().what;
            if(mCommand != 6 && mCommand != 55)
                Log.e("BluetoothDeviceProfileState", (new StringBuilder()).append("Error: IncomingHid state with command:").append(mCommand).toString());
            mStatus = processCommand(mCommand);
            if(!mStatus)
                sendMessage(102);
        }

        public boolean processMessage(Message message) {
            boolean flag;
            flag = false;
            log((new StringBuilder()).append("IncomingHid State->Processing Message: ").append(message.what).toString());
            new Message();
            message.what;
            JVM INSTR lookupswitch 18: default 196
        //                       1: 198
        //                       2: 198
        //                       3: 198
        //                       4: 198
        //                       5: 198
        //                       6: 198
        //                       50: 198
        //                       51: 206
        //                       52: 198
        //                       53: 206
        //                       54: 198
        //                       55: 206
        //                       56: 301
        //                       100: 301
        //                       101: 301
        //                       102: 312
        //                       104: 211
        //                       105: 261;
               goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L2 _L3 _L2 _L3 _L4 _L4 _L4 _L5 _L6 _L7
_L5:
            break MISSING_BLOCK_LABEL_312;
_L3:
            break; /* Loop/switch isn't completed */
_L1:
            return flag;
_L2:
            deferMessage(message);
_L8:
            flag = true;
            if(true) goto _L1; else goto _L6
_L6:
            mConnectionAccessReplyReceived = true;
            int i = message.arg1;
            setTrust(i);
            BluetoothDeviceProfileState bluetoothdeviceprofilestate = BluetoothDeviceProfileState.this;
            if(i == 1)
                flag = true;
            bluetoothdeviceprofilestate.handleIncomingConnection(6, flag);
              goto _L8
_L7:
            if(!mConnectionAccessReplyReceived) {
                handleIncomingConnection(6, false);
                sendConnectionAccessRemovalIntent();
                sendMessage(102);
            }
              goto _L8
_L4:
            deferMessage(message);
              goto _L8
            transitionTo(mBondedDevice);
              goto _L8
        }

        private int mCommand;
        private boolean mStatus;
        final BluetoothDeviceProfileState this$0;

        private IncomingHid() {
            this$0 = BluetoothDeviceProfileState.this;
            super();
            mStatus = false;
        }

    }

    private class OutgoingHid extends State {

        public void enter() {
            log((new StringBuilder()).append("Entering OutgoingHid state with: ").append(getCurrentMessage().what).toString());
            mCommand = getCurrentMessage().what;
            if(mCommand != 5 && mCommand != 54)
                Log.e("BluetoothDeviceProfileState", (new StringBuilder()).append("Error: OutgoingHid state with command:").append(mCommand).toString());
            mStatus = processCommand(mCommand);
            if(!mStatus)
                sendMessage(102);
        }

        public boolean processMessage(Message message) {
            Message message1;
            log((new StringBuilder()).append("OutgoingHid State->Processing Message: ").append(message.what).toString());
            message1 = new Message();
            message.what;
            JVM INSTR lookupswitch 16: default 180
        //                       1: 184
        //                       2: 197
        //                       3: 184
        //                       4: 214
        //                       5: 184
        //                       6: 254
        //                       50: 184
        //                       51: 271
        //                       52: 184
        //                       53: 271
        //                       54: 184
        //                       55: 192
        //                       56: 297
        //                       100: 297
        //                       101: 297
        //                       102: 308;
               goto _L1 _L2 _L3 _L2 _L4 _L2 _L5 _L2 _L6 _L2 _L6 _L2 _L7 _L8 _L8 _L8 _L9
_L9:
            break MISSING_BLOCK_LABEL_308;
_L7:
            break; /* Loop/switch isn't completed */
_L1:
            boolean flag = false;
_L10:
            return flag;
_L2:
            deferMessage(message);
_L11:
            flag = true;
            if(true) goto _L10; else goto _L3
_L3:
            transitionTo(mIncomingHandsfree);
              goto _L11
_L4:
            transitionTo(mIncomingA2dp);
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
              goto _L11
_L5:
            transitionTo(mIncomingHid);
              goto _L11
_L6:
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
              goto _L11
_L8:
            deferMessage(message);
              goto _L11
            transitionTo(mBondedDevice);
              goto _L11
        }

        private int mCommand;
        private boolean mStatus;
        final BluetoothDeviceProfileState this$0;

        private OutgoingHid() {
            this$0 = BluetoothDeviceProfileState.this;
            super();
            mStatus = false;
        }

    }

    private class IncomingA2dp extends State {

        public void enter() {
            Log.i("BluetoothDeviceProfileState", (new StringBuilder()).append("Entering IncomingA2dp state with: ").append(getCurrentMessage().what).toString());
            mCommand = getCurrentMessage().what;
            if(mCommand != 4 && mCommand != 53)
                Log.e("BluetoothDeviceProfileState", (new StringBuilder()).append("Error: IncomingA2DP state with command:").append(mCommand).toString());
            mStatus = processCommand(mCommand);
            if(!mStatus) {
                sendMessage(102);
                mService.sendProfileStateMessage(1, 100);
            }
        }

        public boolean processMessage(Message message) {
            boolean flag;
            flag = false;
            log((new StringBuilder()).append("IncomingA2dp State->Processing Message: ").append(message.what).toString());
            message.what;
            JVM INSTR lookupswitch 19: default 196
        //                       1: 198
        //                       2: 211
        //                       3: 311
        //                       4: 206
        //                       5: 344
        //                       6: 206
        //                       50: 322
        //                       51: 206
        //                       52: 333
        //                       53: 206
        //                       54: 344
        //                       55: 206
        //                       56: 355
        //                       100: 355
        //                       101: 355
        //                       102: 366
        //                       103: 355
        //                       104: 222
        //                       105: 272;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L5 _L7 _L5 _L8 _L5 _L6 _L5 _L9 _L9 _L9 _L10 _L9 _L11 _L12
_L10:
            break MISSING_BLOCK_LABEL_366;
_L5:
            break; /* Loop/switch isn't completed */
_L1:
            return flag;
_L2:
            deferMessage(message);
_L13:
            flag = true;
            if(true) goto _L1; else goto _L3
_L3:
            deferMessage(message);
              goto _L13
_L11:
            int i = message.arg1;
            mConnectionAccessReplyReceived = true;
            boolean flag1 = false;
            if(i == 1)
                flag1 = true;
            setTrust(i);
            handleIncomingConnection(4, flag1);
              goto _L13
_L12:
            if(!mConnectionAccessReplyReceived) {
                handleIncomingConnection(4, false);
                sendConnectionAccessRemovalIntent();
                sendMessage(102);
            }
              goto _L13
_L4:
            deferMessage(message);
              goto _L13
_L7:
            deferMessage(message);
              goto _L13
_L8:
            deferMessage(message);
              goto _L13
_L6:
            deferMessage(message);
              goto _L13
_L9:
            deferMessage(message);
              goto _L13
            transitionTo(mBondedDevice);
              goto _L13
        }

        private int mCommand;
        private boolean mStatus;
        final BluetoothDeviceProfileState this$0;

        private IncomingA2dp() {
            this$0 = BluetoothDeviceProfileState.this;
            super();
            mStatus = false;
        }

    }

    private class OutgoingA2dp extends State {

        public void enter() {
            Log.i("BluetoothDeviceProfileState", (new StringBuilder()).append("Entering OutgoingA2dp state with: ").append(getCurrentMessage().what).toString());
            mCommand = getCurrentMessage().what;
            if(mCommand != 3 && mCommand != 52)
                Log.e("BluetoothDeviceProfileState", (new StringBuilder()).append("Error: OutgoingA2DP state with command:").append(mCommand).toString());
            mStatus = processCommand(mCommand);
            if(!mStatus) {
                sendMessage(102);
                mService.sendProfileStateMessage(1, 100);
            }
        }

        public boolean processMessage(Message message) {
            boolean flag;
            Message message1;
            flag = true;
            log((new StringBuilder()).append("OutgoingA2dp State->Processing Message: ").append(message.what).toString());
            message1 = new Message();
            message.what;
            JVM INSTR lookupswitch 17: default 188
        //                       1: 192
        //                       2: 227
        //                       3: 190
        //                       4: 262
        //                       5: 327
        //                       6: 338
        //                       50: 279
        //                       51: 290
        //                       52: 316
        //                       53: 190
        //                       54: 327
        //                       55: 378
        //                       56: 404
        //                       100: 404
        //                       101: 404
        //                       102: 415
        //                       103: 404;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L4 _L6 _L11 _L12 _L12 _L12 _L13 _L12
_L4:
            break; /* Loop/switch isn't completed */
_L1:
            flag = false;
_L15:
            return flag;
_L2:
            processCommand(flag);
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            processCommand(2);
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            transitionTo(mIncomingA2dp);
            continue; /* Loop/switch isn't completed */
_L8:
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L9:
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L10:
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L6:
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L7:
            transitionTo(mIncomingHid);
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L11:
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L12:
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L13:
            transitionTo(mBondedDevice);
            if(true) goto _L15; else goto _L14
_L14:
        }

        private int mCommand;
        private boolean mStatus;
        final BluetoothDeviceProfileState this$0;

        private OutgoingA2dp() {
            this$0 = BluetoothDeviceProfileState.this;
            super();
            mStatus = false;
        }

    }

    private class IncomingHandsfree extends State {

        public void enter() {
            Log.i("BluetoothDeviceProfileState", (new StringBuilder()).append("Entering IncomingHandsfree state with: ").append(getCurrentMessage().what).toString());
            mCommand = getCurrentMessage().what;
            if(mCommand != 2 && mCommand != 51)
                Log.e("BluetoothDeviceProfileState", (new StringBuilder()).append("Error: IncomingHandsfree state with command:").append(mCommand).toString());
            mStatus = processCommand(mCommand);
            if(!mStatus) {
                sendMessage(102);
                mService.sendProfileStateMessage(0, 100);
            }
        }

        public boolean processMessage(Message message) {
            boolean flag;
            flag = false;
            log((new StringBuilder()).append("IncomingHandsfree State -> Processing Message: ").append(message.what).toString());
            message.what;
            JVM INSTR lookupswitch 19: default 196
        //                       1: 198
        //                       2: 211
        //                       3: 322
        //                       4: 311
        //                       5: 355
        //                       6: 206
        //                       50: 333
        //                       51: 206
        //                       52: 344
        //                       53: 206
        //                       54: 355
        //                       55: 206
        //                       56: 366
        //                       100: 366
        //                       101: 366
        //                       102: 377
        //                       103: 366
        //                       104: 222
        //                       105: 272;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L7 _L9 _L7 _L6 _L7 _L10 _L10 _L10 _L11 _L10 _L12 _L13
_L11:
            break MISSING_BLOCK_LABEL_377;
_L7:
            break; /* Loop/switch isn't completed */
_L1:
            return flag;
_L2:
            deferMessage(message);
_L14:
            flag = true;
            if(true) goto _L1; else goto _L3
_L3:
            Log.e("BluetoothDeviceProfileState", "Error: Incoming connection with a pending incoming connection");
              goto _L14
_L12:
            int i = message.arg1;
            mConnectionAccessReplyReceived = true;
            boolean flag1 = false;
            if(i == 1)
                flag1 = true;
            setTrust(i);
            handleIncomingConnection(2, flag1);
              goto _L14
_L13:
            if(!mConnectionAccessReplyReceived) {
                handleIncomingConnection(2, false);
                sendConnectionAccessRemovalIntent();
                sendMessage(102);
            }
              goto _L14
_L5:
            deferMessage(message);
              goto _L14
_L4:
            deferMessage(message);
              goto _L14
_L8:
            deferMessage(message);
              goto _L14
_L9:
            deferMessage(message);
              goto _L14
_L6:
            deferMessage(message);
              goto _L14
_L10:
            deferMessage(message);
              goto _L14
            transitionTo(mBondedDevice);
              goto _L14
        }

        private int mCommand;
        private boolean mStatus;
        final BluetoothDeviceProfileState this$0;

        private IncomingHandsfree() {
            this$0 = BluetoothDeviceProfileState.this;
            super();
            mStatus = false;
        }

    }

    private class OutgoingHandsfree extends State {

        public void enter() {
            Log.i("BluetoothDeviceProfileState", (new StringBuilder()).append("Entering OutgoingHandsfree state with: ").append(getCurrentMessage().what).toString());
            mCommand = getCurrentMessage().what;
            if(mCommand != 1 && mCommand != 50)
                Log.e("BluetoothDeviceProfileState", (new StringBuilder()).append("Error: OutgoingHandsfree state with command:").append(mCommand).toString());
            mStatus = processCommand(mCommand);
            if(!mStatus) {
                sendMessage(102);
                mService.sendProfileStateMessage(0, 100);
            }
        }

        public boolean processMessage(Message message) {
            boolean flag;
            Message message1;
            int i;
            flag = true;
            log((new StringBuilder()).append("OutgoingHandsfree State -> Processing Message: ").append(message.what).toString());
            message1 = new Message();
            i = message.what;
            i;
            JVM INSTR lookupswitch 17: default 192
        //                       1: 196
        //                       2: 216
        //                       3: 300
        //                       4: 260
        //                       5: 388
        //                       6: 399
        //                       50: 311
        //                       51: 340
        //                       52: 351
        //                       53: 362
        //                       54: 388
        //                       55: 439
        //                       56: 465
        //                       100: 465
        //                       101: 465
        //                       102: 476
        //                       103: 465;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L6 _L12 _L13 _L13 _L13 _L14 _L13
_L1:
            flag = false;
_L16:
            return flag;
_L2:
            if(i != mCommand)
                deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L3:
            if(mCommand == flag) {
                cancelCommand(flag);
                transitionTo(mIncomingHandsfree);
            } else {
                deferMessage(message);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            transitionTo(mIncomingA2dp);
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L8:
            if(mCommand == flag) {
                cancelCommand(flag);
                processCommand(50);
            }
            continue; /* Loop/switch isn't completed */
_L9:
            cancelCommand(flag);
            continue; /* Loop/switch isn't completed */
_L10:
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L11:
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L7:
            transitionTo(mIncomingHid);
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L12:
            if(mStatus) {
                message1.what = mCommand;
                deferMessage(message1);
            }
            continue; /* Loop/switch isn't completed */
_L13:
            deferMessage(message);
            continue; /* Loop/switch isn't completed */
_L14:
            transitionTo(mBondedDevice);
            if(true) goto _L16; else goto _L15
_L15:
        }

        private int mCommand;
        private boolean mStatus;
        final BluetoothDeviceProfileState this$0;

        private OutgoingHandsfree() {
            this$0 = BluetoothDeviceProfileState.this;
            super();
            mStatus = false;
        }

    }

    private class BondedDevice extends State {

        public void enter() {
            Log.i("BluetoothDeviceProfileState", (new StringBuilder()).append("Entering ACL Connected state with: ").append(getCurrentMessage().what).toString());
            Message message = new Message();
            message.copyFrom(getCurrentMessage());
            sendMessageAtFrontOfQueue(message);
        }

        public boolean processMessage(Message message) {
            boolean flag;
            flag = false;
            log((new StringBuilder()).append("ACL Connected State -> Processing Message: ").append(message.what).toString());
            message.what;
            JVM INSTR lookupswitch 18: default 188
        //                       -1: 858
        //                       1: 190
        //                       2: 209
        //                       3: 243
        //                       4: 260
        //                       5: 277
        //                       6: 294
        //                       50: 190
        //                       51: 226
        //                       52: 243
        //                       53: 260
        //                       54: 277
        //                       55: 294
        //                       56: 311
        //                       100: 324
        //                       101: 437
        //                       102: 204
        //                       103: 700;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L3 _L9 _L5 _L6 _L7 _L8 _L10 _L11 _L12 _L13 _L14
_L1:
            return flag;
_L3:
            transitionTo(mOutgoingHandsfree);
_L13:
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            transitionTo(mIncomingHandsfree);
            continue; /* Loop/switch isn't completed */
_L9:
            transitionTo(mIncomingHandsfree);
            continue; /* Loop/switch isn't completed */
_L5:
            transitionTo(mOutgoingA2dp);
            continue; /* Loop/switch isn't completed */
_L6:
            transitionTo(mIncomingA2dp);
            continue; /* Loop/switch isn't completed */
_L7:
            transitionTo(mOutgoingHid);
            continue; /* Loop/switch isn't completed */
_L8:
            transitionTo(mIncomingHid);
            continue; /* Loop/switch isn't completed */
_L10:
            processCommand(56);
            continue; /* Loop/switch isn't completed */
_L11:
            if(mHeadsetState != 0) {
                sendMessage(50);
                deferMessage(message);
            } else
            if(mA2dpState != 0) {
                sendMessage(52);
                deferMessage(message);
            } else
            if(mService.getInputDeviceConnectionState(mDevice) != 0) {
                sendMessage(54);
                deferMessage(message);
            } else {
                processCommand(100);
            }
            continue; /* Loop/switch isn't completed */
_L12:
            if(isPhoneDocked(mDevice))
                continue; /* Loop/switch isn't completed */
            if(mHeadsetService != null) goto _L16; else goto _L15
_L15:
            mAutoConnectionPending = true;
_L17:
            if(mA2dpService != null && mA2dpService.getPriority(mDevice) == 1000) {
                BluetoothA2dpService bluetootha2dpservice = mA2dpService;
                int ai1[] = new int[3];
                ai1[0] = 2;
                ai1[1] = 1;
                ai1[2] = 3;
                if(bluetootha2dpservice.getDevicesMatchingConnectionStates(ai1).size() == 0)
                    mA2dpService.connect(mDevice);
            }
            if(mService.getInputDevicePriority(mDevice) == 1000)
                mService.connectInputDevice(mDevice);
            continue; /* Loop/switch isn't completed */
_L16:
            if(mHeadsetService.getPriority(mDevice) == 1000) {
                BluetoothHeadset bluetoothheadset = mHeadsetService;
                int ai[] = new int[3];
                ai[0] = 2;
                ai[1] = 1;
                ai[2] = 3;
                if(bluetoothheadset.getDevicesMatchingConnectionStates(ai).size() == 0)
                    mHeadsetService.connect(mDevice);
            }
            if(true) goto _L17; else goto _L14
_L14:
            if(!isPhoneDocked(mDevice))
                if(message.arg1 == 3) {
                    if(mA2dpService != null && mA2dpService.getConnectedDevices().size() == 0) {
                        Log.i("BluetoothDeviceProfileState", "A2dp:Connect Other Profiles");
                        mA2dpService.connect(mDevice);
                    }
                } else
                if(message.arg1 == 1)
                    if(mHeadsetService == null)
                        deferMessage(message);
                    else
                    if(mHeadsetService.getConnectedDevices().size() == 0) {
                        Log.i("BluetoothDeviceProfileState", "Headset:Connect Other Profiles");
                        mHeadsetService.connect(mDevice);
                    }
            if(true) goto _L13; else goto _L2
_L2:
            mContext.unregisterReceiver(mBroadcastReceiver);
            mBroadcastReceiver = null;
            mAdapter.closeProfileProxy(1, mHeadsetService);
            mBluetoothProfileServiceListener = null;
            mOutgoingHandsfree = null;
            mPbap = null;
            mPbapService.close();
            mPbapService = null;
            mIncomingHid = null;
            mOutgoingHid = null;
            mIncomingHandsfree = null;
            mOutgoingHandsfree = null;
            mIncomingA2dp = null;
            mOutgoingA2dp = null;
            mBondedDevice = null;
            if(true) goto _L1; else goto _L18
_L18:
        }

        final BluetoothDeviceProfileState this$0;

        private BondedDevice() {
            this$0 = BluetoothDeviceProfileState.this;
            super();
        }

    }

    private class PbapServiceListener
        implements BluetoothPbap.ServiceListener {

        public void onServiceConnected() {
            BluetoothDeviceProfileState bluetoothdeviceprofilestate = BluetoothDeviceProfileState.this;
            bluetoothdeviceprofilestate;
            JVM INSTR monitorenter ;
            mPbapServiceConnected = true;
            return;
        }

        public void onServiceDisconnected() {
            BluetoothDeviceProfileState bluetoothdeviceprofilestate = BluetoothDeviceProfileState.this;
            bluetoothdeviceprofilestate;
            JVM INSTR monitorenter ;
            mPbapServiceConnected = false;
            return;
        }

        final BluetoothDeviceProfileState this$0;

        public PbapServiceListener() {
            this$0 = BluetoothDeviceProfileState.this;
            super();
            mPbapService = new BluetoothPbap(mContext, this);
        }
    }


    public BluetoothDeviceProfileState(Context context, String s, BluetoothService bluetoothservice, BluetoothA2dpService bluetootha2dpservice, boolean flag) {
        super(s);
        mBondedDevice = new BondedDevice();
        mOutgoingHandsfree = new OutgoingHandsfree();
        mIncomingHandsfree = new IncomingHandsfree();
        mIncomingA2dp = new IncomingA2dp();
        mOutgoingA2dp = new OutgoingA2dp();
        mOutgoingHid = new OutgoingHid();
        mIncomingHid = new IncomingHid();
        mHeadsetState = 0;
        mA2dpState = 0;
        mConnectionAccessReplyReceived = false;
        mPairingRequestRcvd = false;
        mBroadcastReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                String s1;
                BluetoothDevice bluetoothdevice;
                s1 = intent.getAction();
                bluetoothdevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if(bluetoothdevice != null && bluetoothdevice.equals(mDevice)) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if(s1.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                    int k1 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                    int l1 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
                    if(k1 == 2)
                        setTrust(1);
                    mA2dpState = k1;
                    if(l1 == 2 && k1 == 0)
                        sendMessage(53);
                    if(k1 == 2 || k1 == 0)
                        sendMessage(102);
                } else
                if(s1.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    int i1 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                    int j1 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
                    if(i1 == 2)
                        setTrust(1);
                    mHeadsetState = i1;
                    if(j1 == 2 && i1 == 0)
                        sendMessage(51);
                    if(i1 == 2 || i1 == 0)
                        sendMessage(102);
                } else
                if(s1.equals("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED")) {
                    int k = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                    int l = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
                    if(k == 2)
                        setTrust(1);
                    if(l == 2 && k == 0)
                        sendMessage(55);
                    if(k == 2 || k == 0)
                        sendMessage(102);
                } else
                if(s1.equals("android.bluetooth.device.action.ACL_DISCONNECTED"))
                    sendMessage(102);
                else
                if(s1.equals("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY")) {
                    mWakeLock.release();
                    int j = intent.getIntExtra("android.bluetooth.device.extra.CONNECTION_ACCESS_RESULT", 2);
                    Message message = obtainMessage(104);
                    message.arg1 = j;
                    sendMessage(message);
                } else
                if(s1.equals("android.bluetooth.device.action.PAIRING_REQUEST"))
                    mPairingRequestRcvd = true;
                else
                if(s1.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                    int i = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 0x80000000);
                    if(i == 12 && mPairingRequestRcvd) {
                        setTrust(1);
                        mPairingRequestRcvd = false;
                    } else
                    if(i == 10)
                        mPairingRequestRcvd = false;
                }
                if(true) goto _L1; else goto _L3
_L3:
            }

            final BluetoothDeviceProfileState this$0;

             {
                this$0 = BluetoothDeviceProfileState.this;
                super();
            }
        };
        mBluetoothProfileServiceListener = new BluetoothProfile.ServiceListener() {

            public void onServiceConnected(int i, BluetoothProfile bluetoothprofile) {
                BluetoothDeviceProfileState bluetoothdeviceprofilestate = BluetoothDeviceProfileState.this;
                bluetoothdeviceprofilestate;
                JVM INSTR monitorenter ;
                mHeadsetService = (BluetoothHeadset)bluetoothprofile;
                if(mAutoConnectionPending) {
                    sendMessage(101);
                    mAutoConnectionPending = false;
                }
                return;
            }

            public void onServiceDisconnected(int i) {
                BluetoothDeviceProfileState bluetoothdeviceprofilestate = BluetoothDeviceProfileState.this;
                bluetoothdeviceprofilestate;
                JVM INSTR monitorenter ;
                mHeadsetService = null;
                return;
            }

            final BluetoothDeviceProfileState this$0;

             {
                this$0 = BluetoothDeviceProfileState.this;
                super();
            }
        };
        mContext = context;
        mDevice = new BluetoothDevice(s);
        mService = bluetoothservice;
        mA2dpService = bluetootha2dpservice;
        addState(mBondedDevice);
        addState(mOutgoingHandsfree);
        addState(mIncomingHandsfree);
        addState(mIncomingA2dp);
        addState(mOutgoingA2dp);
        addState(mOutgoingHid);
        addState(mIncomingHid);
        setInitialState(mBondedDevice);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentfilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentfilter.addAction("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY");
        intentfilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        intentfilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        mContext.registerReceiver(mBroadcastReceiver, intentfilter);
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        mAdapter.getProfileProxy(mContext, mBluetoothProfileServiceListener, 1);
        mPbap = new PbapServiceListener();
        mIncomingConnections = mService.getIncomingState(s);
        mIncomingRejectTimer = readTimerValue();
        mPowerManager = (PowerManager)mContext.getSystemService("power");
        mWakeLock = mPowerManager.newWakeLock(0x30000006, "BluetoothDeviceProfileState");
        mWakeLock.setReferenceCounted(false);
        if(flag)
            setTrust(1);
    }

    private String getStringValue(long l) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Long.toString(System.currentTimeMillis()));
        stringbuilder.append("-");
        stringbuilder.append(Long.toString(l));
        return stringbuilder.toString();
    }

    private int getTrust() {
        mDevice.getAddress();
        int i;
        if(mIncomingConnections != null)
            i = ((Integer)mIncomingConnections.first).intValue();
        else
            i = -1;
        return i;
    }

    private void handleConnectionOfOtherProfiles(int i) {
        i;
        JVM INSTR tableswitch 2 4: default 28
    //                   2 29
    //                   3 28
    //                   4 92;
           goto _L1 _L2 _L1 _L3
_L1:
        return;
_L2:
        if(mA2dpService.getPriority(mDevice) == 100 || mA2dpService.getPriority(mDevice) == 1000) {
            Message message1 = new Message();
            message1.what = 103;
            message1.arg1 = 3;
            sendMessageDelayed(message1, 4000L);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(mHeadsetService != null && (mHeadsetService.getPriority(mDevice) == 100 || mHeadsetService.getPriority(mDevice) == 1000)) {
            Message message = new Message();
            message.what = 103;
            message.arg1 = 1;
            sendMessageDelayed(message, 4000L);
        }
        if(true) goto _L1; else goto _L4
_L4:
    }

    private boolean handleIncomingConnection(int i, boolean flag) {
        boolean flag1;
        flag1 = false;
        Log.i("BluetoothDeviceProfileState", (new StringBuilder()).append("handleIncomingConnection:").append(i).append(":").append(flag).toString());
        i;
        JVM INSTR tableswitch 2 6: default 72
    //                   2 100
    //                   3 72
    //                   4 189
    //                   5 72
    //                   6 245;
           goto _L1 _L2 _L1 _L3 _L1 _L4
_L1:
        Log.e("BluetoothDeviceProfileState", (new StringBuilder()).append("Waiting for incoming connection but state changed to:").append(i).toString());
_L6:
        return flag1;
_L2:
        if(!flag) {
            flag1 = mHeadsetService.rejectIncomingConnect(mDevice);
            sendMessage(102);
            updateIncomingAllowedTimer();
        } else
        if(mHeadsetState == 1) {
            writeTimerValue(0L);
            flag1 = mHeadsetService.acceptIncomingConnect(mDevice);
        } else
        if(mHeadsetState == 0) {
            writeTimerValue(0L);
            handleConnectionOfOtherProfiles(i);
            flag1 = mHeadsetService.createIncomingConnect(mDevice);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(!flag) {
            flag1 = mA2dpService.allowIncomingConnect(mDevice, false);
            sendMessage(102);
            updateIncomingAllowedTimer();
        } else {
            writeTimerValue(0L);
            flag1 = mA2dpService.allowIncomingConnect(mDevice, true);
            handleConnectionOfOtherProfiles(i);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(!flag) {
            flag1 = mService.allowIncomingProfileConnect(mDevice, false);
            sendMessage(102);
            updateIncomingAllowedTimer();
        } else {
            writeTimerValue(0L);
            flag1 = mService.allowIncomingProfileConnect(mDevice, true);
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean isPhoneDocked(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        Intent intent = mContext.registerReceiver(null, new IntentFilter("android.intent.action.DOCK_EVENT"));
        if(intent != null && intent.getIntExtra("android.intent.extra.DOCK_STATE", 0) != 0) {
            BluetoothDevice bluetoothdevice1 = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if(bluetoothdevice1 != null && bluetoothdevice.equals(bluetoothdevice1))
                flag = true;
        }
        return flag;
    }

    private void log(String s) {
    }

    private void processIncomingConnectCommand(int i) {
        int j = getTrust();
        if(j == 1)
            handleIncomingConnection(i, true);
        else
        if(j == 2 && !readIncomingAllowedValue()) {
            handleIncomingConnection(i, false);
        } else {
            sendConnectionAccessIntent();
            sendMessageDelayed(obtainMessage(105), 7000L);
        }
    }

    private boolean readIncomingAllowedValue() {
        boolean flag = true;
        if(readTimerValue() != 0L) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String as[] = ((String)mIncomingConnections.second).split("-");
        if(as == null || as.length != 2 || Long.parseLong(as[0]) + Long.parseLong(as[flag]) > System.currentTimeMillis())
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private long readTimerValue() {
        long l = 0L;
        if(mIncomingConnections != null) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        String as[] = ((String)mIncomingConnections.second).split("-");
        if(as != null && as.length == 2)
            l = Long.parseLong(as[1]);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void sendConnectionAccessIntent() {
        mConnectionAccessReplyReceived = false;
        if(!mPowerManager.isScreenOn())
            mWakeLock.acquire();
        Intent intent = new Intent("android.bluetooth.device.action.CONNECTION_ACCESS_REQUEST");
        intent.setClassName("com.android.settings", "com.android.settings.bluetooth.BluetoothPermissionRequest");
        intent.putExtra("android.bluetooth.device.extra.ACCESS_REQUEST_TYPE", 1);
        intent.putExtra("android.bluetooth.device.extra.DEVICE", mDevice);
        mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
    }

    private void sendConnectionAccessRemovalIntent() {
        mWakeLock.release();
        Intent intent = new Intent("android.bluetooth.device.action.CONNECTION_ACCESS_CANCEL");
        intent.putExtra("android.bluetooth.device.extra.DEVICE", mDevice);
        mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
    }

    private void setTrust(int i) {
        String s;
        if(mIncomingConnections == null)
            s = getStringValue(1000L);
        else
            s = (String)mIncomingConnections.second;
        mIncomingConnections = new Pair(Integer.valueOf(i), s);
        mService.writeIncomingConnectionState(mDevice.getAddress(), mIncomingConnections);
    }

    private void updateIncomingAllowedTimer() {
        if(mIncomingRejectTimer == 0L)
            mIncomingRejectTimer = 1000L;
        mIncomingRejectTimer = 5L * mIncomingRejectTimer;
        if(mIncomingRejectTimer > 0xdbba00L)
            mIncomingRejectTimer = 0xdbba00L;
        writeTimerValue(mIncomingRejectTimer);
    }

    private void writeTimerValue(long l) {
        Integer integer;
        if(mIncomingConnections == null)
            integer = Integer.valueOf(-1);
        else
            integer = (Integer)mIncomingConnections.first;
        mIncomingConnections = new Pair(integer, getStringValue(l));
        mService.writeIncomingConnectionState(mDevice.getAddress(), mIncomingConnections);
    }

    /**
     * @deprecated Method cancelCommand is deprecated
     */

    void cancelCommand(int i) {
        this;
        JVM INSTR monitorenter ;
        if(i != 1)
            break MISSING_BLOCK_LABEL_22;
        if(mHeadsetService != null)
            mHeadsetService.cancelConnectThread();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method deferProfileServiceMessage is deprecated
     */

    void deferProfileServiceMessage(int i) {
        this;
        JVM INSTR monitorenter ;
        Message message = new Message();
        message.what = i;
        deferMessage(message);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    BluetoothDevice getDevice() {
        return mDevice;
    }

    /**
     * @deprecated Method processCommand is deprecated
     */

    boolean processCommand(int i) {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        log((new StringBuilder()).append("Processing command:").append(i).toString());
        i;
        JVM INSTR lookupswitch 14: default 152
    //                   1: 167
    //                   2: 202
    //                   3: 225
    //                   4: 247
    //                   5: 255
    //                   6: 270
    //                   50: 278
    //                   51: 163
    //                   52: 361
    //                   53: 163
    //                   54: 414
    //                   55: 163
    //                   56: 460
    //                   100: 486;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L9 _L11 _L9 _L12 _L13
_L1:
        Log.e("BluetoothDeviceProfileState", "Error: Unknown Command");
_L14:
        flag = false;
_L9:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if(mHeadsetService != null)
            break MISSING_BLOCK_LABEL_187;
        deferProfileServiceMessage(i);
          goto _L14
        Exception exception;
        exception;
        throw exception;
        flag = mHeadsetService.connectHeadsetInternal(mDevice);
          goto _L9
_L3:
        if(mHeadsetService != null) goto _L16; else goto _L15
_L15:
        deferProfileServiceMessage(i);
          goto _L14
_L16:
        processIncomingConnectCommand(i);
          goto _L9
_L4:
        if(mA2dpService == null) goto _L14; else goto _L17
_L17:
        flag = mA2dpService.connectSinkInternal(mDevice);
          goto _L9
_L5:
        processIncomingConnectCommand(i);
          goto _L9
_L6:
        flag = mService.connectInputDeviceInternal(mDevice);
          goto _L9
_L7:
        processIncomingConnectCommand(i);
          goto _L9
_L8:
        if(mHeadsetService != null) goto _L19; else goto _L18
_L18:
        deferProfileServiceMessage(i);
          goto _L14
_L19:
        Message message = new Message();
        message.what = 56;
        deferMessage(message);
        if(mHeadsetService.getPriority(mDevice) == 1000)
            mHeadsetService.setPriority(mDevice, 100);
        flag = mHeadsetService.disconnectHeadsetInternal(mDevice);
          goto _L9
_L10:
        if(mA2dpService == null) goto _L14; else goto _L20
_L20:
        if(mA2dpService.getPriority(mDevice) == 1000)
            mA2dpService.setPriority(mDevice, 100);
        flag = mA2dpService.disconnectSinkInternal(mDevice);
          goto _L9
_L11:
        if(mService.getInputDevicePriority(mDevice) == 1000)
            mService.setInputDevicePriority(mDevice, 100);
        flag = mService.disconnectInputDeviceInternal(mDevice);
          goto _L9
_L12:
        if(mPbapServiceConnected) goto _L22; else goto _L21
_L21:
        deferProfileServiceMessage(i);
          goto _L14
_L22:
        flag = mPbapService.disconnect();
          goto _L9
_L13:
        boolean flag1;
        writeTimerValue(1000L);
        setTrust(-1);
        flag1 = mService.removeBondInternal(mDevice.getAddress());
        flag = flag1;
          goto _L9
    }

    private static final String ACCESS_AUTHORITY_CLASS = "com.android.settings.bluetooth.BluetoothPermissionRequest";
    private static final String ACCESS_AUTHORITY_PACKAGE = "com.android.settings";
    public static final int AUTO_CONNECT_PROFILES = 101;
    private static final String BLUETOOTH_ADMIN_PERM = "android.permission.BLUETOOTH_ADMIN";
    private static final int CONNECTION_ACCESS_REQUEST_EXPIRY = 105;
    private static final int CONNECTION_ACCESS_REQUEST_EXPIRY_TIMEOUT = 7000;
    private static final int CONNECTION_ACCESS_REQUEST_REPLY = 104;
    private static final int CONNECTION_ACCESS_UNDEFINED = -1;
    public static final int CONNECT_A2DP_INCOMING = 4;
    public static final int CONNECT_A2DP_OUTGOING = 3;
    public static final int CONNECT_HFP_INCOMING = 2;
    public static final int CONNECT_HFP_OUTGOING = 1;
    public static final int CONNECT_HID_INCOMING = 6;
    public static final int CONNECT_HID_OUTGOING = 5;
    public static final int CONNECT_OTHER_PROFILES = 103;
    public static final int CONNECT_OTHER_PROFILES_DELAY = 4000;
    private static final boolean DBG = false;
    public static final int DISCONNECT_A2DP_INCOMING = 53;
    public static final int DISCONNECT_A2DP_OUTGOING = 52;
    private static final int DISCONNECT_HFP_INCOMING = 51;
    public static final int DISCONNECT_HFP_OUTGOING = 50;
    public static final int DISCONNECT_HID_INCOMING = 55;
    public static final int DISCONNECT_HID_OUTGOING = 54;
    public static final int DISCONNECT_PBAP_OUTGOING = 56;
    private static final long INIT_INCOMING_REJECT_TIMER = 1000L;
    private static final long MAX_INCOMING_REJECT_TIMER = 0xdbba00L;
    private static final String TAG = "BluetoothDeviceProfileState";
    public static final int TRANSITION_TO_STABLE = 102;
    public static final int UNPAIR = 100;
    private BluetoothA2dpService mA2dpService;
    private int mA2dpState;
    private BluetoothAdapter mAdapter;
    private boolean mAutoConnectionPending;
    private BluetoothProfile.ServiceListener mBluetoothProfileServiceListener;
    private BondedDevice mBondedDevice;
    private BroadcastReceiver mBroadcastReceiver;
    private boolean mConnectionAccessReplyReceived;
    private Context mContext;
    private BluetoothDevice mDevice;
    private BluetoothHeadset mHeadsetService;
    private int mHeadsetState;
    private IncomingA2dp mIncomingA2dp;
    private Pair mIncomingConnections;
    private IncomingHandsfree mIncomingHandsfree;
    private IncomingHid mIncomingHid;
    private long mIncomingRejectTimer;
    private OutgoingA2dp mOutgoingA2dp;
    private OutgoingHandsfree mOutgoingHandsfree;
    private OutgoingHid mOutgoingHid;
    private boolean mPairingRequestRcvd;
    private PbapServiceListener mPbap;
    private BluetoothPbap mPbapService;
    private boolean mPbapServiceConnected;
    private PowerManager mPowerManager;
    private BluetoothService mService;
    private android.os.PowerManager.WakeLock mWakeLock;




/*
    static int access$1002(BluetoothDeviceProfileState bluetoothdeviceprofilestate, int i) {
        bluetoothdeviceprofilestate.mHeadsetState = i;
        return i;
    }

*/


















/*
    static boolean access$1202(BluetoothDeviceProfileState bluetoothdeviceprofilestate, boolean flag) {
        bluetoothdeviceprofilestate.mPairingRequestRcvd = flag;
        return flag;
    }

*/



/*
    static BluetoothHeadset access$1302(BluetoothDeviceProfileState bluetoothdeviceprofilestate, BluetoothHeadset bluetoothheadset) {
        bluetoothdeviceprofilestate.mHeadsetService = bluetoothheadset;
        return bluetoothheadset;
    }

*/



/*
    static boolean access$1402(BluetoothDeviceProfileState bluetoothdeviceprofilestate, boolean flag) {
        bluetoothdeviceprofilestate.mAutoConnectionPending = flag;
        return flag;
    }

*/



/*
    static BluetoothPbap access$1502(BluetoothDeviceProfileState bluetoothdeviceprofilestate, BluetoothPbap bluetoothpbap) {
        bluetoothdeviceprofilestate.mPbapService = bluetoothpbap;
        return bluetoothpbap;
    }

*/



/*
    static boolean access$1702(BluetoothDeviceProfileState bluetoothdeviceprofilestate, boolean flag) {
        bluetoothdeviceprofilestate.mPbapServiceConnected = flag;
        return flag;
    }

*/







/*
    static OutgoingHandsfree access$2202(BluetoothDeviceProfileState bluetoothdeviceprofilestate, OutgoingHandsfree outgoinghandsfree) {
        bluetoothdeviceprofilestate.mOutgoingHandsfree = outgoinghandsfree;
        return outgoinghandsfree;
    }

*/




/*
    static IncomingHandsfree access$2402(BluetoothDeviceProfileState bluetoothdeviceprofilestate, IncomingHandsfree incominghandsfree) {
        bluetoothdeviceprofilestate.mIncomingHandsfree = incominghandsfree;
        return incominghandsfree;
    }

*/





/*
    static OutgoingA2dp access$2702(BluetoothDeviceProfileState bluetoothdeviceprofilestate, OutgoingA2dp outgoinga2dp) {
        bluetoothdeviceprofilestate.mOutgoingA2dp = outgoinga2dp;
        return outgoinga2dp;
    }

*/




/*
    static IncomingA2dp access$2902(BluetoothDeviceProfileState bluetoothdeviceprofilestate, IncomingA2dp incominga2dp) {
        bluetoothdeviceprofilestate.mIncomingA2dp = incominga2dp;
        return incominga2dp;
    }

*/




/*
    static OutgoingHid access$3102(BluetoothDeviceProfileState bluetoothdeviceprofilestate, OutgoingHid outgoinghid) {
        bluetoothdeviceprofilestate.mOutgoingHid = outgoinghid;
        return outgoinghid;
    }

*/




/*
    static IncomingHid access$3302(BluetoothDeviceProfileState bluetoothdeviceprofilestate, IncomingHid incominghid) {
        bluetoothdeviceprofilestate.mIncomingHid = incominghid;
        return incominghid;
    }

*/











/*
    static BroadcastReceiver access$4202(BluetoothDeviceProfileState bluetoothdeviceprofilestate, BroadcastReceiver broadcastreceiver) {
        bluetoothdeviceprofilestate.mBroadcastReceiver = broadcastreceiver;
        return broadcastreceiver;
    }

*/



/*
    static BluetoothProfile.ServiceListener access$4402(BluetoothDeviceProfileState bluetoothdeviceprofilestate, BluetoothProfile.ServiceListener servicelistener) {
        bluetoothdeviceprofilestate.mBluetoothProfileServiceListener = servicelistener;
        return servicelistener;
    }

*/


/*
    static PbapServiceListener access$4502(BluetoothDeviceProfileState bluetoothdeviceprofilestate, PbapServiceListener pbapservicelistener) {
        bluetoothdeviceprofilestate.mPbap = pbapservicelistener;
        return pbapservicelistener;
    }

*/



/*
    static BondedDevice access$4602(BluetoothDeviceProfileState bluetoothdeviceprofilestate, BondedDevice bondeddevice) {
        bluetoothdeviceprofilestate.mBondedDevice = bondeddevice;
        return bondeddevice;
    }

*/






















/*
    static boolean access$6602(BluetoothDeviceProfileState bluetoothdeviceprofilestate, boolean flag) {
        bluetoothdeviceprofilestate.mConnectionAccessReplyReceived = flag;
        return flag;
    }

*/





























/*
    static int access$902(BluetoothDeviceProfileState bluetoothdeviceprofilestate, int i) {
        bluetoothdeviceprofilestate.mA2dpState = i;
        return i;
    }

*/









}
