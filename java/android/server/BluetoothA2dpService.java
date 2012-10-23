// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.bluetooth.*;
import android.content.*;
import android.media.AudioManager;
import android.os.*;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package android.server:
//            BluetoothService

public class BluetoothA2dpService extends android.bluetooth.IBluetoothA2dp.Stub {
    private class IntentBroadcastHandler extends Handler {

        private void onConnectionStateChanged(BluetoothDevice bluetoothdevice, int i, int j) {
            Intent intent = new Intent("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothdevice);
            intent.putExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", i);
            intent.putExtra("android.bluetooth.profile.extra.STATE", j);
            intent.addFlags(0x8000000);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
            BluetoothA2dpService.log((new StringBuilder()).append("A2DP state : device: ").append(bluetoothdevice).append(" State:").append(i).append("->").append(j).toString());
            mBluetoothService.sendConnectionStateChange(bluetoothdevice, 2, j, i);
        }

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 0 0: default 24
        //                       0 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            onConnectionStateChanged((BluetoothDevice)message.obj, message.arg1, message.arg2);
            mWakeLock.release();
            if(true) goto _L1; else goto _L3
_L3:
        }

        final BluetoothA2dpService this$0;

        private IntentBroadcastHandler() {
            this$0 = BluetoothA2dpService.this;
            super();
        }

    }


    public BluetoothA2dpService(Context context, BluetoothService bluetoothservice) {
        mContext = context;
        mWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "BluetoothA2dpService");
        mIntentBroadcastHandler = new IntentBroadcastHandler();
        mAudioManager = (AudioManager)context.getSystemService("audio");
        mBluetoothService = bluetoothservice;
        if(mBluetoothService == null)
            throw new RuntimeException("Platform does not support Bluetooth");
        if(!initNative())
            throw new RuntimeException("Could not init BluetoothA2dpService");
        mIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        mIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        mIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        mContext.registerReceiver(mReceiver, mIntentFilter);
        mAudioDevices = new HashMap();
        if(mBluetoothService.isEnabled())
            onBluetoothEnable();
        mTargetA2dpState = -1;
        mBluetoothService.setA2dpService(this);
    }

    /**
     * @deprecated Method addAudioSink is deprecated
     */

    private void addAudioSink(BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        if(mAudioDevices.get(bluetoothdevice) == null)
            mAudioDevices.put(bluetoothdevice, Integer.valueOf(0));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void adjustOtherSinkPriorities(BluetoothDevice bluetoothdevice) {
        Iterator iterator = mAdapter.getBondedDevices().iterator();
        do {
            if(!iterator.hasNext())
                break;
            BluetoothDevice bluetoothdevice1 = (BluetoothDevice)iterator.next();
            if(getPriority(bluetoothdevice1) >= 1000 && !bluetoothdevice1.equals(bluetoothdevice))
                setPriority(bluetoothdevice1, 100);
        } while(true);
    }

    /**
     * @deprecated Method avrcpVolumeDownNative is deprecated
     */

    private synchronized native boolean avrcpVolumeDownNative(String s);

    /**
     * @deprecated Method avrcpVolumeUpNative is deprecated
     */

    private synchronized native boolean avrcpVolumeUpNative(String s);

    private boolean checkSinkSuspendState(int i) {
        boolean flag = true;
        if(i != mTargetA2dpState)
            if(i == 10 && mTargetA2dpState == 2)
                mAudioManager.setParameters("A2dpSuspended=true");
            else
            if(i == 2 && mTargetA2dpState == 10)
                mAudioManager.setParameters("A2dpSuspended=false");
            else
                flag = false;
        return flag;
    }

    private native void cleanupNative();

    /**
     * @deprecated Method connectSinkNative is deprecated
     */

    private synchronized native boolean connectSinkNative(String s);

    private int convertBluezSinkStringToState(String s) {
        int i;
        if(s.equalsIgnoreCase("disconnected"))
            i = 0;
        else
        if(s.equalsIgnoreCase("connecting"))
            i = 1;
        else
        if(s.equalsIgnoreCase("connected"))
            i = 2;
        else
        if(s.equalsIgnoreCase("playing"))
            i = 10;
        else
            i = -1;
        return i;
    }

    /**
     * @deprecated Method disconnectSinkNative is deprecated
     */

    private synchronized native boolean disconnectSinkNative(String s);

    /**
     * @deprecated Method getSinkPropertiesNative is deprecated
     */

    private synchronized native Object[] getSinkPropertiesNative(String s);

    private void handleSinkPlayingStateChange(BluetoothDevice bluetoothdevice, int i, int j) {
        Intent intent = new Intent("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothdevice);
        intent.putExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", j);
        intent.putExtra("android.bluetooth.profile.extra.STATE", i);
        intent.addFlags(0x8000000);
        mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
        log((new StringBuilder()).append("A2DP Playing state : device: ").append(bluetoothdevice).append(" State:").append(j).append("->").append(i).toString());
    }

    private void handleSinkStateChange(BluetoothDevice bluetoothdevice, int i, int j) {
        if(j != i) {
            mAudioDevices.put(bluetoothdevice, Integer.valueOf(j));
            checkSinkSuspendState(j);
            mTargetA2dpState = -1;
            if(getPriority(bluetoothdevice) > 0 && j == 2) {
                setPriority(bluetoothdevice, 1000);
                adjustOtherSinkPriorities(bluetoothdevice);
            }
            int k = mAudioManager.setBluetoothA2dpDeviceConnectionState(bluetoothdevice, j);
            mWakeLock.acquire();
            mIntentBroadcastHandler.sendMessageDelayed(mIntentBroadcastHandler.obtainMessage(0, i, j, bluetoothdevice), k);
        }
    }

    private native boolean initNative();

    /**
     * @deprecated Method isConnectSinkFeasible is deprecated
     */

    private boolean isConnectSinkFeasible(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if(!mBluetoothService.isEnabled() || !isSinkDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        int i = getPriority(bluetoothdevice);
        if(i != 0) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        String s;
        addAudioSink(bluetoothdevice);
        s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        if(s != null)
            flag = true;
        if(true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method isDisconnectSinkFeasible is deprecated
     */

    private boolean isDisconnectSinkFeasible(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        if(s != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        int i = getConnectionState(bluetoothdevice);
        switch(i) {
        case 1: // '\001'
        case 2: // '\002'
        default:
            flag = true;
            break;

        case 0: // '\0'
        case 3: // '\003'
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
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

    private boolean isSinkDevice(BluetoothDevice bluetoothdevice) {
        ParcelUuid aparceluuid[] = mBluetoothService.getRemoteUuids(bluetoothdevice.getAddress());
        boolean flag;
        if(aparceluuid != null && BluetoothUuid.isUuidPresent(aparceluuid, BluetoothUuid.AudioSink))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static void log(String s) {
        Log.d("BluetoothA2dpService", s);
    }

    /**
     * @deprecated Method onBluetoothDisable is deprecated
     */

    private void onBluetoothDisable() {
        this;
        JVM INSTR monitorenter ;
        if(mAudioDevices.isEmpty()) goto _L2; else goto _L1
_L1:
        BluetoothDevice abluetoothdevice1[];
        int i;
        int j;
        BluetoothDevice abluetoothdevice[] = new BluetoothDevice[mAudioDevices.size()];
        abluetoothdevice1 = (BluetoothDevice[])mAudioDevices.keySet().toArray(abluetoothdevice);
        i = abluetoothdevice1.length;
        j = 0;
_L8:
        if(j >= i) goto _L4; else goto _L3
_L3:
        BluetoothDevice bluetoothdevice;
        int k;
        bluetoothdevice = abluetoothdevice1[j];
        k = getConnectionState(bluetoothdevice);
        k;
        JVM INSTR lookupswitch 4: default 177
    //                   1: 112
    //                   2: 112
    //                   3: 146
    //                   10: 112;
           goto _L5 _L6 _L6 _L7 _L6
_L5:
        break MISSING_BLOCK_LABEL_177;
_L6:
        disconnectSinkNative(mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress()));
        handleSinkStateChange(bluetoothdevice, k, 0);
        break MISSING_BLOCK_LABEL_177;
        Exception exception;
        exception;
        throw exception;
_L7:
        handleSinkStateChange(bluetoothdevice, 3, 0);
        break MISSING_BLOCK_LABEL_177;
_L4:
        mAudioDevices.clear();
_L2:
        mAudioManager.setParameters("bluetooth_enabled=false");
        this;
        JVM INSTR monitorexit ;
        return;
        j++;
          goto _L8
    }

    /**
     * @deprecated Method onBluetoothEnable is deprecated
     */

    private void onBluetoothEnable() {
        this;
        JVM INSTR monitorenter ;
        String as[];
        int i;
        String s = mBluetoothService.getProperty("Devices", true);
        if(s == null)
            break MISSING_BLOCK_LABEL_123;
        as = s.split(",");
        i = as.length;
        Exception exception;
        for(int j = 0; j < i; j++) {
            String s1 = as[j];
            String s2 = mBluetoothService.getAddressFromObjectPath(s1);
            BluetoothDevice bluetoothdevice = mAdapter.getRemoteDevice(s2);
            ParcelUuid aparceluuid[] = mBluetoothService.getRemoteUuids(s2);
            if(aparceluuid != null) {
                ParcelUuid aparceluuid1[] = new ParcelUuid[2];
                aparceluuid1[0] = BluetoothUuid.AudioSink;
                aparceluuid1[1] = BluetoothUuid.AdvAudioDist;
                if(BluetoothUuid.containsAnyUuid(aparceluuid, aparceluuid1))
                    addAudioSink(bluetoothdevice);
            }
            break MISSING_BLOCK_LABEL_150;
        }

        mAudioManager.setParameters("bluetooth_enabled=true");
        mAudioManager.setParameters("A2dpSuspended=false");
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    private void onConnectSinkResult(String s, boolean flag) {
        if(!flag && s != null) {
            String s1 = mBluetoothService.getAddressFromObjectPath(s);
            if(s1 != null) {
                BluetoothDevice bluetoothdevice = mAdapter.getRemoteDevice(s1);
                handleSinkStateChange(bluetoothdevice, getConnectionState(bluetoothdevice), 0);
            }
        }
    }

    /**
     * @deprecated Method onSinkPropertyChanged is deprecated
     */

    private void onSinkPropertyChanged(String s, String as[]) {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mBluetoothService.isEnabled();
        if(flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s1;
        String s2;
        s1 = as[0];
        s2 = mBluetoothService.getAddressFromObjectPath(s);
        if(s2 != null)
            break MISSING_BLOCK_LABEL_56;
        Log.e("BluetoothA2dpService", "onSinkPropertyChanged: Address of the remote device in null");
          goto _L1
        Exception exception;
        exception;
        throw exception;
        BluetoothDevice bluetoothdevice = mAdapter.getRemoteDevice(s2);
        if(s1.equals("State")) {
            int i = convertBluezSinkStringToState(as[1]);
            log((new StringBuilder()).append("A2DP: onSinkPropertyChanged newState is: ").append(i).append("mPlayingA2dpDevice: ").append(mPlayingA2dpDevice).toString());
            if(mAudioDevices.get(bluetoothdevice) == null) {
                addAudioSink(bluetoothdevice);
                handleSinkStateChange(bluetoothdevice, 0, i);
            } else
            if(i == 10 && mPlayingA2dpDevice == null) {
                mPlayingA2dpDevice = bluetoothdevice;
                handleSinkPlayingStateChange(bluetoothdevice, i, 11);
            } else
            if(i == 2 && mPlayingA2dpDevice != null) {
                mPlayingA2dpDevice = null;
                handleSinkPlayingStateChange(bluetoothdevice, 11, 10);
            } else {
                mPlayingA2dpDevice = null;
                handleSinkStateChange(bluetoothdevice, ((Integer)mAudioDevices.get(bluetoothdevice)).intValue(), i);
            }
        }
          goto _L1
    }

    /**
     * @deprecated Method resumeSinkNative is deprecated
     */

    private synchronized native boolean resumeSinkNative(String s);

    /**
     * @deprecated Method suspendSinkNative is deprecated
     */

    private synchronized native boolean suspendSinkNative(String s);

    /**
     * @deprecated Method allowIncomingConnect is deprecated
     */

    public boolean allowIncomingConnect(BluetoothDevice bluetoothdevice, boolean flag) {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        String s;
        boolean flag2;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN", "Need BLUETOOTH_ADMIN permission");
        s = bluetoothdevice.getAddress();
        flag2 = BluetoothAdapter.checkBluetoothAddress(s);
        if(flag2) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        Integer integer;
        integer = mBluetoothService.getAuthorizationAgentRequestData(s);
        if(integer == null) {
            Log.w("BluetoothA2dpService", (new StringBuilder()).append("allowIncomingConnect(").append(bluetoothdevice).append(") called but no native data available").toString());
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_96;
        Exception exception;
        exception;
        throw exception;
        boolean flag3;
        log((new StringBuilder()).append("allowIncomingConnect: A2DP: ").append(bluetoothdevice).append(":").append(flag).toString());
        flag3 = mBluetoothService.setAuthorizationNative(s, flag, integer.intValue());
        flag1 = flag3;
        if(true) goto _L1; else goto _L3
_L3:
    }

    /**
     * @deprecated Method connect is deprecated
     */

    public boolean connect(BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN", "Need BLUETOOTH_ADMIN permission");
        log((new StringBuilder()).append("connectSink(").append(bluetoothdevice).append(")").toString());
        flag = isConnectSinkFeasible(bluetoothdevice);
        if(flag) goto _L2; else goto _L1
_L1:
        boolean flag2 = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag2;
_L2:
        Iterator iterator = mAudioDevices.keySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            BluetoothDevice bluetoothdevice1 = (BluetoothDevice)iterator.next();
            if(getConnectionState(bluetoothdevice1) != 0)
                disconnect(bluetoothdevice1);
        } while(true);
        break MISSING_BLOCK_LABEL_121;
        Exception exception;
        exception;
        throw exception;
        boolean flag1 = mBluetoothService.connectSink(bluetoothdevice.getAddress());
        flag2 = flag1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    /**
     * @deprecated Method connectSinkInternal is deprecated
     */

    public boolean connectSinkInternal(BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mBluetoothService.isEnabled();
        if(flag) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L13:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        int i;
        i = ((Integer)mAudioDevices.get(bluetoothdevice)).intValue();
        int ai[] = new int[3];
        ai[0] = 1;
        ai[1] = 2;
        ai[2] = 3;
        if(getDevicesMatchingConnectionStates(ai).size() != 0) {
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
_L11:
        String s;
        s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        if(getPriority(bluetoothdevice) < 1000)
            setPriority(bluetoothdevice, 1000);
        handleSinkStateChange(bluetoothdevice, i, 1);
        if(connectSinkNative(s)) goto _L5; else goto _L4
_L4:
        handleSinkStateChange(bluetoothdevice, ((Integer)mAudioDevices.get(bluetoothdevice)).intValue(), i);
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L9:
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L7:
        flag1 = true;
        continue; /* Loop/switch isn't completed */
_L5:
        flag1 = true;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L3:
        switch(i) {
        default:
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            break;

        case 2: // '\002'
        case 3: // '\003'
            break; /* Loop/switch isn't completed */
        }
        if(true) goto _L7; else goto _L6
_L6:
        if(true) goto _L9; else goto _L8
_L8:
        if(true) goto _L11; else goto _L10
_L10:
        if(true) goto _L13; else goto _L12
_L12:
    }

    /**
     * @deprecated Method disconnect is deprecated
     */

    public boolean disconnect(BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN", "Need BLUETOOTH_ADMIN permission");
        log((new StringBuilder()).append("disconnectSink(").append(bluetoothdevice).append(")").toString());
        flag = isDisconnectSinkFeasible(bluetoothdevice);
        if(flag) goto _L2; else goto _L1
_L1:
        boolean flag2 = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag2;
_L2:
        boolean flag1 = mBluetoothService.disconnectSink(bluetoothdevice.getAddress());
        flag2 = flag1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method disconnectSinkInternal is deprecated
     */

    public boolean disconnectSinkInternal(BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        int i;
        String s;
        i = getConnectionState(bluetoothdevice);
        s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        i;
        JVM INSTR tableswitch 0 3: default 52
    //                   0 96
    //                   1 52
    //                   2 52
    //                   3 96;
           goto _L1 _L2 _L1 _L1 _L2
_L1:
        handleSinkStateChange(bluetoothdevice, i, 3);
        if(disconnectSinkNative(s)) goto _L4; else goto _L3
_L3:
        handleSinkStateChange(bluetoothdevice, ((Integer)mAudioDevices.get(bluetoothdevice)).intValue(), i);
        boolean flag = false;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L4:
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method dump is deprecated
     */

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        mContext.enforceCallingOrSelfPermission("android.permission.DUMP", "BluetoothA2dpService");
        flag = mAudioDevices.isEmpty();
        if(!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        printwriter.println("Cached audio devices:");
        Iterator iterator = mAudioDevices.keySet().iterator();
        while(iterator.hasNext())  {
            BluetoothDevice bluetoothdevice = (BluetoothDevice)iterator.next();
            int i = ((Integer)mAudioDevices.get(bluetoothdevice)).intValue();
            printwriter.println((new StringBuilder()).append(bluetoothdevice).append(" ").append(BluetoothA2dp.stateToString(i)).toString());
        }
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize() throws Throwable {
        cleanupNative();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    /**
     * @deprecated Method getConnectedDevices is deprecated
     */

    public List getConnectedDevices() {
        this;
        JVM INSTR monitorenter ;
        List list;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH", "Need BLUETOOTH permission");
        int ai[] = new int[1];
        ai[0] = 2;
        list = getDevicesMatchingConnectionStates(ai);
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getConnectionState is deprecated
     */

    public int getConnectionState(BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        Integer integer;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH", "Need BLUETOOTH permission");
        integer = (Integer)mAudioDevices.get(bluetoothdevice);
        if(integer != null) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return j;
_L2:
        int i = integer.intValue();
        j = i;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getDevicesMatchingConnectionStates is deprecated
     */

    public List getDevicesMatchingConnectionStates(int ai[]) {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Iterator iterator;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH", "Need BLUETOOTH permission");
        arraylist = new ArrayList();
        iterator = mAudioDevices.keySet().iterator();
_L5:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        BluetoothDevice bluetoothdevice;
        int i;
        int j;
        int k;
        bluetoothdevice = (BluetoothDevice)iterator.next();
        i = getConnectionState(bluetoothdevice);
        j = ai.length;
        k = 0;
_L3:
        if(k >= j)
            continue; /* Loop/switch isn't completed */
        if(ai[k] == i) {
            arraylist.add(bluetoothdevice);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_104;
        Exception exception;
        exception;
        throw exception;
        k++;
        if(true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        if(true) goto _L5; else goto _L4
_L4:
    }

    /**
     * @deprecated Method getPriority is deprecated
     */

    public int getPriority(BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        int i;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH", "Need BLUETOOTH permission");
        i = android.provider.Settings.Secure.getInt(mContext.getContentResolver(), android.provider.Settings.Secure.getBluetoothA2dpSinkPriorityKey(bluetoothdevice.getAddress()), -1);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method isA2dpPlaying is deprecated
     */

    public boolean isA2dpPlaying(BluetoothDevice bluetoothdevice) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN", "Need BLUETOOTH_ADMIN permission");
        log((new StringBuilder()).append("isA2dpPlaying(").append(bluetoothdevice).append(")").toString());
        flag = bluetoothdevice.equals(mPlayingA2dpDevice);
        boolean flag1;
        if(flag)
            flag1 = true;
        else
            flag1 = false;
        this;
        JVM INSTR monitorexit ;
        return flag1;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method resumeSink is deprecated
     */

    public boolean resumeSink(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN", "Need BLUETOOTH_ADMIN permission");
        log((new StringBuilder()).append("resumeSink(").append(bluetoothdevice).append("), mTargetA2dpState: ").append(mTargetA2dpState).toString());
        if(bluetoothdevice == null) goto _L2; else goto _L1
_L1:
        HashMap hashmap = mAudioDevices;
        if(hashmap != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        boolean flag1;
        String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        Integer integer = (Integer)mAudioDevices.get(bluetoothdevice);
        if(s == null || integer == null)
            continue; /* Loop/switch isn't completed */
        mTargetA2dpState = 10;
        flag1 = checkSinkSuspendState(integer.intValue());
        flag = flag1;
        if(true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setPriority is deprecated
     */

    public boolean setPriority(BluetoothDevice bluetoothdevice, int i) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN", "Need BLUETOOTH_ADMIN permission");
        flag = android.provider.Settings.Secure.putInt(mContext.getContentResolver(), android.provider.Settings.Secure.getBluetoothA2dpSinkPriorityKey(bluetoothdevice.getAddress()), i);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method suspendSink is deprecated
     */

    public boolean suspendSink(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN", "Need BLUETOOTH_ADMIN permission");
        log((new StringBuilder()).append("suspendSink(").append(bluetoothdevice).append("), mTargetA2dpState: ").append(mTargetA2dpState).toString());
        if(bluetoothdevice == null) goto _L2; else goto _L1
_L1:
        HashMap hashmap = mAudioDevices;
        if(hashmap != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        boolean flag1;
        String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        Integer integer = (Integer)mAudioDevices.get(bluetoothdevice);
        if(s == null || integer == null)
            continue; /* Loop/switch isn't completed */
        mTargetA2dpState = 2;
        flag1 = checkSinkSuspendState(integer.intValue());
        flag = flag1;
        if(true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public static final String BLUETOOTH_A2DP_SERVICE = "bluetooth_a2dp";
    private static final String BLUETOOTH_ADMIN_PERM = "android.permission.BLUETOOTH_ADMIN";
    private static final String BLUETOOTH_ENABLED = "bluetooth_enabled";
    private static final String BLUETOOTH_PERM = "android.permission.BLUETOOTH";
    private static final boolean DBG = true;
    private static final int MSG_CONNECTION_STATE_CHANGED = 0;
    private static final String PROPERTY_STATE = "State";
    private static final String TAG = "BluetoothA2dpService";
    private final BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
    private HashMap mAudioDevices;
    private final AudioManager mAudioManager;
    private final BluetoothService mBluetoothService;
    private final Context mContext;
    private IntentBroadcastHandler mIntentBroadcastHandler;
    private final IntentFilter mIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
    private BluetoothDevice mPlayingA2dpDevice;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {

        public void onReceive(Context context1, Intent intent) {
            String s;
            BluetoothDevice bluetoothdevice;
            s = intent.getAction();
            bluetoothdevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if(!s.equals("android.bluetooth.adapter.action.STATE_CHANGED")) goto _L2; else goto _L1
_L1:
            intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0x80000000);
            JVM INSTR tableswitch 12 13: default 56
        //                       12 57
        //                       13 67;
               goto _L3 _L4 _L5
_L3:
            return;
_L4:
            onBluetoothEnable();
            continue; /* Loop/switch isn't completed */
_L5:
            onBluetoothDisable();
            continue; /* Loop/switch isn't completed */
_L2:
            if(!s.equals("android.bluetooth.device.action.ACL_DISCONNECTED"))
                break MISSING_BLOCK_LABEL_147;
            this;
            JVM INSTR monitorenter ;
            if(mAudioDevices.containsKey(bluetoothdevice)) {
                int k = ((Integer)mAudioDevices.get(bluetoothdevice)).intValue();
                handleSinkStateChange(bluetoothdevice, k, 0);
            }
            continue; /* Loop/switch isn't completed */
            if(s.equals("android.media.VOLUME_CHANGED_ACTION") && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                List list = getConnectedDevices();
                if(list.size() != 0 && isPhoneDocked((BluetoothDevice)list.get(0))) {
                    String s1 = ((BluetoothDevice)list.get(0)).getAddress();
                    int i = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                    int j = intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", 0);
                    String s2 = mBluetoothService.getObjectPathFromAddress(s1);
                    if(i > j)
                        avrcpVolumeUpNative(s2);
                    else
                    if(i < j)
                        avrcpVolumeDownNative(s2);
                }
            }
            if(true) goto _L3; else goto _L6
_L6:
        }

        final BluetoothA2dpService this$0;

             {
                this$0 = BluetoothA2dpService.this;
                super();
            }
    };
    private int mTargetA2dpState;
    private final android.os.PowerManager.WakeLock mWakeLock;











}
