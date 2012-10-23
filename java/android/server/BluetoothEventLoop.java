// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.bluetooth.*;
import android.content.Context;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import java.util.*;

// Referenced classes of package android.server:
//            BluetoothService, BluetoothDeviceProperties, BluetoothAdapterProperties, BluetoothAdapterStateMachine

class BluetoothEventLoop {

    BluetoothEventLoop(Context context, BluetoothAdapter bluetoothadapter, BluetoothService bluetoothservice, BluetoothAdapterStateMachine bluetoothadapterstatemachine) {
        mProfileServiceListener = new android.bluetooth.BluetoothProfile.ServiceListener() {

            public void onServiceConnected(int i, BluetoothProfile bluetoothprofile) {
                if(i == 2)
                    mA2dp = (BluetoothA2dp)bluetoothprofile;
            }

            public void onServiceDisconnected(int i) {
                if(i == 2)
                    mA2dp = null;
            }

            final BluetoothEventLoop this$0;

             {
                this$0 = BluetoothEventLoop.this;
                super();
            }
        };
        mBluetoothService = bluetoothservice;
        mContext = context;
        mBluetoothState = bluetoothadapterstatemachine;
        mAdapter = bluetoothadapter;
        mWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(0x3000001a, "BluetoothEventLoop");
        mWakeLock.setReferenceCounted(false);
        initializeNativeDataNative();
    }

    private void addDevice(String s, String as[]) {
        BluetoothDeviceProperties bluetoothdeviceproperties = mBluetoothService.getDeviceProperties();
        bluetoothdeviceproperties.addProperties(s, as);
        String s1 = bluetoothdeviceproperties.getProperty(s, "RSSI");
        String s2 = bluetoothdeviceproperties.getProperty(s, "Class");
        String s3 = bluetoothdeviceproperties.getProperty(s, "Name");
        short word0;
        if(s1 != null)
            word0 = (short)Integer.valueOf(s1).intValue();
        else
            word0 = -32768;
        if(s2 != null) {
            Intent intent = new Intent("android.bluetooth.device.action.FOUND");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s));
            intent.putExtra("android.bluetooth.device.extra.CLASS", new BluetoothClass(Integer.valueOf(s2).intValue()));
            intent.putExtra("android.bluetooth.device.extra.RSSI", word0);
            intent.putExtra("android.bluetooth.device.extra.NAME", s3);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
        } else {
            log((new StringBuilder()).append("ClassValue: ").append(s2).append(" for remote device: ").append(s).append(" is null").toString());
        }
    }

    private String checkPairingRequestAndGetAddress(String s, int i) {
        String s1 = null;
        String s2 = mBluetoothService.getAddressFromObjectPath(s);
        if(s2 == null) {
            Log.e("BluetoothEventLoop", "Unable to get device address in checkPairingRequestAndGetAddress, returning null");
        } else {
            String s3 = s2.toUpperCase();
            mPasskeyAgentRequestData.put(s3, new Integer(i));
            if(mBluetoothService.getBluetoothState() == 13) {
                mBluetoothService.cancelPairingUserInput(s3);
            } else {
                if(mBluetoothService.getBondState(s3) != 12)
                    mBluetoothService.setBondState(s3, 11);
                s1 = s3;
            }
        }
        return s1;
    }

    private static native void classInitNative();

    private native void cleanupNativeDataNative();

    private native void initializeNativeDataNative();

    private native boolean isEventLoopRunningNative();

    private boolean isOtherSinkInNonDisconnectedState(String s) {
        boolean flag;
        List list;
        flag = false;
        BluetoothA2dp bluetootha2dp = mA2dp;
        int ai[] = new int[3];
        ai[0] = 2;
        ai[1] = 1;
        ai[2] = 3;
        list = bluetootha2dp.getDevicesMatchingConnectionStates(ai);
        if(list.size() != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        Iterator iterator = list.iterator();
        do
            if(!iterator.hasNext())
                continue; /* Loop/switch isn't completed */
        while(((BluetoothDevice)iterator.next()).getAddress().equals(s));
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static void log(String s) {
        Log.d("BluetoothEventLoop", s);
    }

    private void onAgentAuthorize(String s, String s1, int i) {
        if(mBluetoothService.isEnabled()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s2;
        boolean flag;
        ParcelUuid parceluuid;
        BluetoothDevice bluetoothdevice;
        s2 = mBluetoothService.getAddressFromObjectPath(s);
        if(s2 == null) {
            Log.e("BluetoothEventLoop", "Unable to get device address in onAuthAgentAuthorize");
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        parceluuid = ParcelUuid.fromString(s1);
        bluetoothdevice = mAdapter.getRemoteDevice(s2);
        mAuthorizationAgentRequestData.put(s2, new Integer(i));
        if(mA2dp == null || !BluetoothUuid.isAudioSource(parceluuid) && !BluetoothUuid.isAvrcpTarget(parceluuid) && !BluetoothUuid.isAdvAudioDist(parceluuid) || isOtherSinkInNonDisconnectedState(s2))
            break; /* Loop/switch isn't completed */
        if(mA2dp.getPriority(bluetoothdevice) > 0)
            flag = true;
        else
            flag = false;
        if(flag && !BluetoothUuid.isAvrcpTarget(parceluuid)) {
            Log.i("BluetoothEventLoop", (new StringBuilder()).append("First check pass for incoming A2DP / AVRCP connection from ").append(s2).toString());
            mBluetoothService.notifyIncomingA2dpConnection(s2, false);
        } else {
            Log.i("BluetoothEventLoop", (new StringBuilder()).append("").append(flag).append("Incoming A2DP / AVRCP connection from ").append(s2).toString());
            mA2dp.allowIncomingConnect(bluetoothdevice, flag);
            mBluetoothService.notifyIncomingA2dpConnection(s2, true);
        }
_L4:
        log((new StringBuilder()).append("onAgentAuthorize(").append(s).append(", ").append(s1).append(") = ").append(flag).toString());
        if(true) goto _L1; else goto _L3
_L3:
        if(BluetoothUuid.isInputDevice(parceluuid)) {
            if(mBluetoothService.getInputDevicePriority(bluetoothdevice) > 0)
                flag = true;
            else
                flag = false;
            if(flag) {
                Log.i("BluetoothEventLoop", (new StringBuilder()).append("First check pass for incoming HID connection from ").append(s2).toString());
                mBluetoothService.notifyIncomingHidConnection(s2);
            } else {
                Log.i("BluetoothEventLoop", (new StringBuilder()).append("Rejecting incoming HID connection from ").append(s2).toString());
                mBluetoothService.allowIncomingProfileConnect(bluetoothdevice, flag);
            }
        } else
        if(BluetoothUuid.isBnep(parceluuid)) {
            flag = mBluetoothService.allowIncomingTethering();
            mBluetoothService.allowIncomingProfileConnect(bluetoothdevice, flag);
        } else {
            Log.i("BluetoothEventLoop", (new StringBuilder()).append("Rejecting incoming ").append(s1).append(" connection from ").append(s2).toString());
            mBluetoothService.allowIncomingProfileConnect(bluetoothdevice, false);
        }
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    private void onAgentCancel() {
        Intent intent = new Intent("android.bluetooth.device.action.PAIRING_CANCEL");
        mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
        mHandler.sendMessageDelayed(mHandler.obtainMessage(2), 1500L);
    }

    private boolean onAgentOutOfBandDataAvailable(String s) {
        boolean flag = false;
        if(mBluetoothService.isEnabled()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String s1 = mBluetoothService.getAddressFromObjectPath(s);
        if(s1 != null && mBluetoothService.getDeviceOutOfBandData(mAdapter.getRemoteDevice(s1)) != null)
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void onCreateDeviceResult(String s, int i) {
        i;
        JVM INSTR tableswitch -1 1: default 28
    //                   -1 66
    //                   0 28
    //                   1 29;
           goto _L1 _L2 _L1 _L3
_L1:
        return;
_L3:
        String s1 = mBluetoothService.getObjectPathFromAddress(s);
        if(s1 != null) {
            mBluetoothService.discoverServicesNative(s1, "");
            continue; /* Loop/switch isn't completed */
        }
        Log.w("BluetoothEventLoop", "Device exists, but we don't have the bluez path, failing");
_L2:
        mBluetoothService.sendUuidIntent(s);
        mBluetoothService.makeServiceChannelCallbacks(s);
        if(true) goto _L1; else goto _L4
_L4:
    }

    private void onCreatePairedDeviceResult(String s, int i) {
        String s1 = s.toUpperCase();
        mBluetoothService.onCreatePairedDeviceResult(s1, i);
    }

    private void onDeviceCreated(String s) {
        String s1 = mBluetoothService.getAddressFromObjectPath(s);
        if(s1 != null) goto _L2; else goto _L1
_L1:
        Log.e("BluetoothEventLoop", (new StringBuilder()).append("onDeviceCreated: device address null! deviceObjectPath: ").append(s).toString());
_L4:
        return;
_L2:
        if(!mBluetoothService.isRemoteDeviceInCache(s1)) {
            String as[] = mBluetoothService.getRemoteDeviceProperties(s1);
            if(as != null)
                addDevice(s1, as);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void onDeviceDisappeared(String s) {
        Intent intent = new Intent("android.bluetooth.device.action.DISAPPEARED");
        intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s));
        mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
    }

    private void onDeviceDisconnectRequested(String s) {
        String s1 = mBluetoothService.getAddressFromObjectPath(s);
        if(s1 == null) {
            Log.e("BluetoothEventLoop", "onDeviceDisconnectRequested: Address of the remote device in null");
        } else {
            Intent intent = new Intent("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s1));
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
        }
    }

    private void onDeviceFound(String s, String as[]) {
        if(as == null)
            Log.e("BluetoothEventLoop", "ERROR: Remote device properties are null");
        else
            addDevice(s, as);
    }

    private void onDevicePropertyChanged(String s, String as[]) {
        String s1;
        String s2;
        s1 = as[0];
        s2 = mBluetoothService.getAddressFromObjectPath(s);
        if(s2 != null) goto _L2; else goto _L1
_L1:
        Log.e("BluetoothEventLoop", "onDevicePropertyChanged: Address of the remote device in null");
_L4:
        return;
_L2:
        log((new StringBuilder()).append("Device property changed: ").append(s2).append(" property: ").append(s1).append(" value: ").append(as[1]).toString());
        BluetoothDevice bluetoothdevice = mAdapter.getRemoteDevice(s2);
        if(s1.equals("Name")) {
            mBluetoothService.setRemoteDeviceProperty(s2, s1, as[1]);
            Intent intent3 = new Intent("android.bluetooth.device.action.NAME_CHANGED");
            intent3.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothdevice);
            intent3.putExtra("android.bluetooth.device.extra.NAME", as[1]);
            intent3.addFlags(0x8000000);
            mContext.sendBroadcast(intent3, "android.permission.BLUETOOTH");
        } else
        if(s1.equals("Alias")) {
            mBluetoothService.setRemoteDeviceProperty(s2, s1, as[1]);
            Intent intent2 = new Intent("android.bluetooth.device.action.ALIAS_CHANGED");
            intent2.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothdevice);
            intent2.addFlags(0x8000000);
            mContext.sendBroadcast(intent2, "android.permission.BLUETOOTH");
        } else
        if(s1.equals("Class")) {
            mBluetoothService.setRemoteDeviceProperty(s2, s1, as[1]);
            Intent intent1 = new Intent("android.bluetooth.device.action.CLASS_CHANGED");
            intent1.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothdevice);
            intent1.putExtra("android.bluetooth.device.extra.CLASS", new BluetoothClass(Integer.valueOf(as[1]).intValue()));
            intent1.addFlags(0x8000000);
            mContext.sendBroadcast(intent1, "android.permission.BLUETOOTH");
        } else
        if(s1.equals("Connected")) {
            mBluetoothService.setRemoteDeviceProperty(s2, s1, as[1]);
            Intent intent;
            if(as[1].equals("true")) {
                intent = new Intent("android.bluetooth.device.action.ACL_CONNECTED");
                if(mBluetoothService.isBluetoothDock(s2))
                    mBluetoothService.setLinkTimeout(s2, 8000);
            } else {
                intent = new Intent("android.bluetooth.device.action.ACL_DISCONNECTED");
            }
            intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothdevice);
            intent.addFlags(0x8000000);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
        } else
        if(s1.equals("UUIDs")) {
            String s3 = null;
            if(Integer.valueOf(as[1]).intValue() > 0) {
                StringBuilder stringbuilder = new StringBuilder();
                for(int i = 2; i < as.length; i++) {
                    stringbuilder.append(as[i]);
                    stringbuilder.append(",");
                }

                s3 = stringbuilder.toString();
            }
            mBluetoothService.setRemoteDeviceProperty(s2, s1, s3);
            mBluetoothService.updateDeviceServiceChannelCache(s2);
            mBluetoothService.sendUuidIntent(s2);
        } else
        if(s1.equals("Paired")) {
            if(as[1].equals("true")) {
                if(mBluetoothService.getPendingOutgoingBonding() == null)
                    mBluetoothService.setBondState(s2, 12);
            } else {
                mBluetoothService.setBondState(s2, 10);
                mBluetoothService.setRemoteDeviceProperty(s2, "Trusted", "false");
            }
        } else
        if(s1.equals("Trusted"))
            mBluetoothService.setRemoteDeviceProperty(s2, s1, as[1]);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void onDeviceRemoved(String s) {
        String s1 = mBluetoothService.getAddressFromObjectPath(s);
        if(s1 != null) {
            mBluetoothService.setBondState(s1.toUpperCase(), 10, 9);
            mBluetoothService.setRemoteDeviceProperty(s1, "UUIDs", null);
        }
    }

    private void onDiscoverServicesResult(String s, boolean flag) {
        String s1 = mBluetoothService.getAddressFromObjectPath(s);
        if(s1 != null) {
            if(flag)
                mBluetoothService.updateRemoteDevicePropertiesCache(s1);
            mBluetoothService.sendUuidIntent(s1);
            mBluetoothService.makeServiceChannelCallbacks(s1);
        }
    }

    private void onDisplayPasskey(String s, int i, int j) {
        String s1 = checkPairingRequestAndGetAddress(s, j);
        if(s1 != null) {
            mWakeLock.acquire();
            Intent intent = new Intent("android.bluetooth.device.action.PAIRING_REQUEST");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s1));
            intent.putExtra("android.bluetooth.device.extra.PAIRING_KEY", i);
            intent.putExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 4);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
            mWakeLock.release();
        }
    }

    private void onHealthDeviceChannelChanged(String s, String s1, boolean flag) {
        log((new StringBuilder()).append("Health Device : devicePath: ").append(s).append(":channelPath:").append(s1).append(":exists").append(flag).toString());
        mBluetoothService.onHealthDeviceChannelChanged(s, s1, flag);
    }

    private void onHealthDeviceConnectionResult(int i, int j) {
        log((new StringBuilder()).append("onHealthDeviceConnectionResult ").append(i).append(" ").append(j).toString());
        if(j != 6000)
            mBluetoothService.onHealthDeviceChannelConnectionError(i, 0);
    }

    private void onHealthDevicePropertyChanged(String s, String as[]) {
        log((new StringBuilder()).append("Health Device : Name of Property is: ").append(as[0]).append(" Value:").append(as[1]).toString());
        mBluetoothService.onHealthDevicePropertyChanged(s, as[1]);
    }

    private void onInputDeviceConnectionResult(String s, int i) {
        if(i == 5004) goto _L2; else goto _L1
_L1:
        String s1 = mBluetoothService.getAddressFromObjectPath(s);
        if(s1 != null) goto _L3; else goto _L2
_L2:
        return;
_L3:
        boolean flag;
        int j;
        flag = false;
        BluetoothDevice bluetoothdevice = mAdapter.getRemoteDevice(s1);
        j = mBluetoothService.getInputDeviceConnectionState(bluetoothdevice);
        if(j != 1)
            break; /* Loop/switch isn't completed */
        if(i == 5001)
            flag = true;
        else
            flag = false;
_L5:
        mBluetoothService.handleInputDevicePropertyChange(s1, flag);
        if(true) goto _L2; else goto _L4
_L4:
        if(j == 3) {
            if(i == 5000)
                flag = false;
            else
                flag = true;
        } else {
            Log.e("BluetoothEventLoop", (new StringBuilder()).append("Error onInputDeviceConnectionResult. State is:").append(j).toString());
        }
          goto _L5
        if(true) goto _L2; else goto _L6
_L6:
    }

    private void onInputDevicePropertyChanged(String s, String as[]) {
        String s1 = mBluetoothService.getAddressFromObjectPath(s);
        if(s1 == null) {
            Log.e("BluetoothEventLoop", "onInputDevicePropertyChanged: Address of the remote device is null");
        } else {
            log((new StringBuilder()).append("Input Device : Name of Property is: ").append(as[0]).toString());
            boolean flag = false;
            if(as[1].equals("true"))
                flag = true;
            mBluetoothService.handleInputDevicePropertyChange(s1, flag);
        }
    }

    private void onNetworkDeviceConnected(String s, String s1, int i) {
        BluetoothDevice bluetoothdevice = mAdapter.getRemoteDevice(s);
        mBluetoothService.handlePanDeviceStateChange(bluetoothdevice, s1, 2, 1);
    }

    private void onNetworkDeviceDisconnected(String s) {
        BluetoothDevice bluetoothdevice = mAdapter.getRemoteDevice(s);
        mBluetoothService.handlePanDeviceStateChange(bluetoothdevice, 0, 1);
    }

    private void onPanDeviceConnectionResult(String s, int i) {
        log((new StringBuilder()).append("onPanDeviceConnectionResult ").append(s).append(" ").append(i).toString());
        if(i == 1004) goto _L2; else goto _L1
_L1:
        String s1 = mBluetoothService.getAddressFromObjectPath(s);
        if(s1 != null) goto _L3; else goto _L2
_L2:
        return;
_L3:
        boolean flag;
        BluetoothDevice bluetoothdevice;
        int j;
        flag = false;
        bluetoothdevice = mAdapter.getRemoteDevice(s1);
        j = mBluetoothService.getPanDeviceConnectionState(bluetoothdevice);
        if(j != 1) goto _L5; else goto _L4
_L4:
        byte byte0;
        if(i == 1001)
            flag = true;
        else
            flag = false;
_L6:
        if(flag)
            byte0 = 2;
        else
            byte0 = 0;
        mBluetoothService.handlePanDeviceStateChange(bluetoothdevice, byte0, 2);
        if(true) goto _L2; else goto _L5
_L5:
        if(j == 3) {
            if(i == 1000)
                flag = false;
            else
                flag = true;
        } else {
            Log.e("BluetoothEventLoop", (new StringBuilder()).append("Error onPanDeviceConnectionResult. State is: ").append(j).append(" result: ").append(i).toString());
        }
          goto _L6
    }

    private void onPanDevicePropertyChanged(String s, String as[]) {
        String s1;
        String s2;
        s1 = as[0];
        s2 = mBluetoothService.getAddressFromObjectPath(s);
        if(s2 != null) goto _L2; else goto _L1
_L1:
        Log.e("BluetoothEventLoop", "onPanDevicePropertyChanged: Address of the remote device in null");
_L4:
        return;
_L2:
        BluetoothDevice bluetoothdevice = mAdapter.getRemoteDevice(s2);
        if(s1.equals("Connected")) {
            if(as[1].equals("false"))
                mBluetoothService.handlePanDeviceStateChange(bluetoothdevice, 0, 2);
        } else
        if(s1.equals("Interface")) {
            String s3 = as[1];
            if(!s3.equals(""))
                mBluetoothService.handlePanDeviceStateChange(bluetoothdevice, s3, 2, 2);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void onRequestOobData(String s, int i) {
        String s1 = checkPairingRequestAndGetAddress(s, i);
        if(s1 != null) {
            Intent intent = new Intent("android.bluetooth.device.action.PAIRING_REQUEST");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s1));
            intent.putExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 6);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
        }
    }

    private void onRequestPairingConsent(String s, int i) {
        String s1 = checkPairingRequestAndGetAddress(s, i);
        if(s1 != null)
            if(mBluetoothService.getBondState(s1) == 12) {
                Message message = mHandler.obtainMessage(1);
                message.obj = s1;
                mHandler.sendMessageDelayed(message, 1500L);
            } else {
                mWakeLock.acquire();
                Intent intent = new Intent("android.bluetooth.device.action.PAIRING_REQUEST");
                intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s1));
                intent.putExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 3);
                mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
                mWakeLock.release();
            }
    }

    private void onRequestPasskey(String s, int i) {
        String s1 = checkPairingRequestAndGetAddress(s, i);
        if(s1 != null) {
            mWakeLock.acquire();
            Intent intent = new Intent("android.bluetooth.device.action.PAIRING_REQUEST");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s1));
            intent.putExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 1);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
            mWakeLock.release();
        }
    }

    private void onRequestPasskeyConfirmation(String s, int i, int j) {
        String s1 = checkPairingRequestAndGetAddress(s, j);
        if(s1 != null) {
            mWakeLock.acquire();
            Intent intent = new Intent("android.bluetooth.device.action.PAIRING_REQUEST");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s1));
            intent.putExtra("android.bluetooth.device.extra.PAIRING_KEY", i);
            intent.putExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 2);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
            mWakeLock.release();
        }
    }

    private void onRequestPinCode(String s, int i) {
        String s1 = checkPairingRequestAndGetAddress(s, i);
        if(s1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        String s2 = mBluetoothService.getPendingOutgoingBonding();
        j = (new BluetoothClass(mBluetoothService.getRemoteClass(s1))).getDeviceClass();
        if(!s1.equals(s2))
            break; /* Loop/switch isn't completed */
label0:
        {
            if(!mBluetoothService.isBluetoothDock(s1))
                break label0;
            String s3 = mBluetoothService.getDockPin();
            mBluetoothService.setPin(s1, BluetoothDevice.convertPinToBytes(s3));
        }
        if(true) goto _L1; else goto _L3
        j;
        JVM INSTR lookupswitch 5: default 140
    //                   1028: 185
    //                   1032: 185
    //                   1048: 185
    //                   1052: 185
    //                   1064: 185;
           goto _L3 _L4 _L4 _L4 _L4 _L4
_L3:
        if(j == 1344 || j == 1472) {
            if(mBluetoothService.isFixedPinZerosAutoPairKeyboard(s1))
                mBluetoothService.setPin(s1, BluetoothDevice.convertPinToBytes("0000"));
            else
                sendDisplayPinIntent(s1, (int)Math.floor(10000D * Math.random()));
        } else {
            mWakeLock.acquire();
            Intent intent = new Intent("android.bluetooth.device.action.PAIRING_REQUEST");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s1));
            intent.putExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 0);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
            mWakeLock.release();
        }
        break; /* Loop/switch isn't completed */
_L4:
        if(!mBluetoothService.attemptAutoPair(s1)) goto _L3; else goto _L1
    }

    private void sendDisplayPinIntent(String s, int i) {
        mWakeLock.acquire();
        Intent intent = new Intent("android.bluetooth.device.action.PAIRING_REQUEST");
        intent.putExtra("android.bluetooth.device.extra.DEVICE", mAdapter.getRemoteDevice(s));
        intent.putExtra("android.bluetooth.device.extra.PAIRING_KEY", i);
        intent.putExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 5);
        mContext.sendBroadcast(intent, "android.permission.BLUETOOTH_ADMIN");
        mWakeLock.release();
    }

    private native void startEventLoopNative();

    private native void stopEventLoopNative();

    protected void finalize() throws Throwable {
        cleanupNativeDataNative();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    HashMap getAuthorizationAgentRequestData() {
        return mAuthorizationAgentRequestData;
    }

    HashMap getPasskeyAgentRequestData() {
        return mPasskeyAgentRequestData;
    }

    void getProfileProxy() {
        mAdapter.getProfileProxy(mContext, mProfileServiceListener, 2);
        mAdapter.getProfileProxy(mContext, mProfileServiceListener, 4);
    }

    public boolean isEventLoopRunning() {
        return isEventLoopRunningNative();
    }

    void onPropertyChanged(String as[]) {
        BluetoothAdapterProperties bluetoothadapterproperties;
        String s;
        bluetoothadapterproperties = mBluetoothService.getAdapterProperties();
        if(bluetoothadapterproperties.isEmpty())
            bluetoothadapterproperties.getAllProperties();
        log((new StringBuilder()).append("Property Changed: ").append(as[0]).append(" : ").append(as[1]).toString());
        s = as[0];
        if(!s.equals("Name")) goto _L2; else goto _L1
_L1:
        bluetoothadapterproperties.setProperty(s, as[1]);
        Intent intent2 = new Intent("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED");
        intent2.putExtra("android.bluetooth.adapter.extra.LOCAL_NAME", as[1]);
        intent2.addFlags(0x8000000);
        mContext.sendBroadcast(intent2, "android.permission.BLUETOOTH");
_L4:
        return;
_L2:
        if(s.equals("Pairable") || s.equals("Discoverable")) {
            bluetoothadapterproperties.setProperty(s, as[1]);
            if(s.equals("Discoverable"))
                mBluetoothState.sendMessage(53);
            String s1;
            String s2;
            if(s.equals("Pairable"))
                s1 = as[1];
            else
                s1 = bluetoothadapterproperties.getProperty("Pairable");
            if(s.equals("Discoverable"))
                s2 = as[1];
            else
                s2 = bluetoothadapterproperties.getProperty("Discoverable");
            if(s1 != null && s2 != null) {
                int i = BluetoothService.bluezStringToScanMode(s1.equals("true"), s2.equals("true"));
                if(i >= 0) {
                    Intent intent = new Intent("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
                    intent.putExtra("android.bluetooth.adapter.extra.SCAN_MODE", i);
                    intent.addFlags(0x8000000);
                    mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
                }
            }
        } else
        if(s.equals("Discovering")) {
            bluetoothadapterproperties.setProperty(s, as[1]);
            Intent intent1;
            if(as[1].equals("true")) {
                intent1 = new Intent("android.bluetooth.adapter.action.DISCOVERY_STARTED");
            } else {
                mBluetoothService.cancelDiscovery();
                intent1 = new Intent("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            }
            mContext.sendBroadcast(intent1, "android.permission.BLUETOOTH");
        } else
        if(s.equals("Devices") || s.equals("UUIDs")) {
            String s3 = null;
            if(Integer.valueOf(as[1]).intValue() > 0) {
                StringBuilder stringbuilder = new StringBuilder();
                for(int j = 2; j < as.length; j++) {
                    stringbuilder.append(as[j]);
                    stringbuilder.append(",");
                }

                s3 = stringbuilder.toString();
            }
            bluetoothadapterproperties.setProperty(s, s3);
            if(s.equals("UUIDs"))
                mBluetoothService.updateBluetoothState(s3);
        } else
        if(s.equals("Powered")) {
            BluetoothAdapterStateMachine bluetoothadapterstatemachine = mBluetoothState;
            Boolean boolean1;
            if(as[1].equals("true"))
                boolean1 = new Boolean(true);
            else
                boolean1 = new Boolean(false);
            bluetoothadapterstatemachine.sendMessage(54, boolean1);
        } else
        if(s.equals("DiscoverableTimeout"))
            bluetoothadapterproperties.setProperty(s, as[1]);
        if(true) goto _L4; else goto _L3
_L3:
    }

    void start() {
        if(!isEventLoopRunningNative())
            startEventLoopNative();
    }

    public void stop() {
        if(isEventLoopRunningNative())
            stopEventLoopNative();
    }

    private static final String BLUETOOTH_ADMIN_PERM = "android.permission.BLUETOOTH_ADMIN";
    private static final String BLUETOOTH_PERM = "android.permission.BLUETOOTH";
    private static final int CREATE_DEVICE_ALREADY_EXISTS = 1;
    private static final int CREATE_DEVICE_FAILED = -1;
    private static final int CREATE_DEVICE_SUCCESS = 0;
    private static final boolean DBG = false;
    private static final int EVENT_AGENT_CANCEL = 2;
    private static final int EVENT_PAIRING_CONSENT_DELAYED_ACCEPT = 1;
    private static final String TAG = "BluetoothEventLoop";
    private BluetoothA2dp mA2dp;
    private final BluetoothAdapter mAdapter;
    private final HashMap mAuthorizationAgentRequestData = new HashMap();
    private final BluetoothService mBluetoothService;
    private final BluetoothAdapterStateMachine mBluetoothState;
    private final Context mContext;
    private final Handler mHandler = new Handler() {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 2: default 28
        //                       1 29
        //                       2 60;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            String s1 = (String)message.obj;
            if(s1 != null)
                mBluetoothService.setPairingConfirmation(s1, true);
            continue; /* Loop/switch isn't completed */
_L3:
            String as[] = mBluetoothService.listInState(11);
            if(as.length != 0)
                if(as.length > 1) {
                    Log.e("BluetoothEventLoop", " There is more than one device in the Bonding State");
                } else {
                    String s = as[0];
                    mBluetoothService.setBondState(s, 10, 8);
                }
            if(true) goto _L1; else goto _L4
_L4:
        }

        final BluetoothEventLoop this$0;

             {
                this$0 = BluetoothEventLoop.this;
                super();
            }
    };
    private boolean mInterrupted;
    private int mNativeData;
    private final HashMap mPasskeyAgentRequestData = new HashMap();
    private android.bluetooth.BluetoothProfile.ServiceListener mProfileServiceListener;
    private boolean mStarted;
    private Thread mThread;
    private android.os.PowerManager.WakeLock mWakeLock;

    static  {
        classInitNative();
    }



/*
    static BluetoothA2dp access$102(BluetoothEventLoop bluetootheventloop, BluetoothA2dp bluetootha2dp) {
        bluetootheventloop.mA2dp = bluetootha2dp;
        return bluetootha2dp;
    }

*/
}
