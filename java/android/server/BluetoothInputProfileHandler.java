// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.bluetooth.*;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import java.util.*;

// Referenced classes of package android.server:
//            BluetoothService

final class BluetoothInputProfileHandler {

    private BluetoothInputProfileHandler(Context context, BluetoothService bluetoothservice) {
        mContext = context;
        mBluetoothService = bluetoothservice;
        mHidProfileState = new BluetoothProfileState(mContext, 2);
        mHidProfileState.start();
    }

    private static void debugLog(String s) {
        Log.d("BluetoothInputProfileHandler", s);
    }

    private static void errorLog(String s) {
        Log.e("BluetoothInputProfileHandler", s);
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    static BluetoothInputProfileHandler getInstance(Context context, BluetoothService bluetoothservice) {
        android/server/BluetoothInputProfileHandler;
        JVM INSTR monitorenter ;
        BluetoothInputProfileHandler bluetoothinputprofilehandler;
        if(sInstance == null)
            sInstance = new BluetoothInputProfileHandler(context, bluetoothservice);
        bluetoothinputprofilehandler = sInstance;
        android/server/BluetoothInputProfileHandler;
        JVM INSTR monitorexit ;
        return bluetoothinputprofilehandler;
        Exception exception;
        exception;
        throw exception;
    }

    private void handleInputDeviceStateChange(BluetoothDevice bluetoothdevice, int i) {
        int j;
        if(mInputDevices.get(bluetoothdevice) == null)
            j = 0;
        else
            j = ((Integer)mInputDevices.get(bluetoothdevice)).intValue();
        if(j != i) {
            mInputDevices.put(bluetoothdevice, Integer.valueOf(i));
            if(getInputDevicePriority(bluetoothdevice) > 0 && i == 1 || i == 2)
                setInputDevicePriority(bluetoothdevice, 1000);
            Intent intent = new Intent("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
            intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothdevice);
            intent.putExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", j);
            intent.putExtra("android.bluetooth.profile.extra.STATE", i);
            intent.addFlags(0x8000000);
            mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
            debugLog((new StringBuilder()).append("InputDevice state : device: ").append(bluetoothdevice).append(" State:").append(j).append("->").append(i).toString());
            mBluetoothService.sendConnectionStateChange(bluetoothdevice, 4, i, j);
        }
    }

    boolean connectInputDevice(BluetoothDevice bluetoothdevice, BluetoothDeviceProfileState bluetoothdeviceprofilestate) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress()) != null && getInputDeviceConnectionState(bluetoothdevice) == 0 && getInputDevicePriority(bluetoothdevice) != 0 && bluetoothdeviceprofilestate != null) {
            Message message = new Message();
            message.arg1 = 5;
            message.obj = bluetoothdeviceprofilestate;
            mHidProfileState.sendMessage(message);
            flag = true;
        }
        return flag;
    }

    boolean connectInputDeviceInternal(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        handleInputDeviceStateChange(bluetoothdevice, 1);
        if(!mBluetoothService.connectInputDeviceNative(s))
            handleInputDeviceStateChange(bluetoothdevice, 0);
        else
            flag = true;
        return flag;
    }

    boolean disconnectInputDevice(BluetoothDevice bluetoothdevice, BluetoothDeviceProfileState bluetoothdeviceprofilestate) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress()) != null && getInputDeviceConnectionState(bluetoothdevice) != 0 && bluetoothdeviceprofilestate != null) {
            Message message = new Message();
            message.arg1 = 54;
            message.obj = bluetoothdeviceprofilestate;
            mHidProfileState.sendMessage(message);
            flag = true;
        }
        return flag;
    }

    boolean disconnectInputDeviceInternal(BluetoothDevice bluetoothdevice) {
        String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        handleInputDeviceStateChange(bluetoothdevice, 3);
        boolean flag;
        if(!mBluetoothService.disconnectInputDeviceNative(s)) {
            handleInputDeviceStateChange(bluetoothdevice, 2);
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    List getConnectedInputDevices() {
        int ai[] = new int[1];
        ai[0] = 2;
        return lookupInputDevicesMatchingStates(ai);
    }

    int getInputDeviceConnectionState(BluetoothDevice bluetoothdevice) {
        int i;
        if(mInputDevices.get(bluetoothdevice) == null)
            i = 0;
        else
            i = ((Integer)mInputDevices.get(bluetoothdevice)).intValue();
        return i;
    }

    int getInputDevicePriority(BluetoothDevice bluetoothdevice) {
        return android.provider.Settings.Secure.getInt(mContext.getContentResolver(), android.provider.Settings.Secure.getBluetoothInputDevicePriorityKey(bluetoothdevice.getAddress()), -1);
    }

    List getInputDevicesMatchingConnectionStates(int ai[]) {
        return lookupInputDevicesMatchingStates(ai);
    }

    void handleInputDevicePropertyChange(String s, boolean flag) {
        byte byte0;
        if(flag)
            byte0 = 2;
        else
            byte0 = 0;
        handleInputDeviceStateChange(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(s), byte0);
    }

    List lookupInputDevicesMatchingStates(int ai[]) {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mInputDevices.keySet().iterator();
label0:
        do {
            if(iterator.hasNext()) {
                BluetoothDevice bluetoothdevice = (BluetoothDevice)iterator.next();
                int i = getInputDeviceConnectionState(bluetoothdevice);
                int j = ai.length;
                int k = 0;
                do {
                    if(k >= j)
                        continue label0;
                    if(ai[k] == i) {
                        arraylist.add(bluetoothdevice);
                        continue label0;
                    }
                    k++;
                } while(true);
            }
            return arraylist;
        } while(true);
    }

    void setInitialInputDevicePriority(BluetoothDevice bluetoothdevice, int i) {
        i;
        JVM INSTR tableswitch 10 12: default 28
    //                   10 50
    //                   11 28
    //                   12 29;
           goto _L1 _L2 _L1 _L3
_L1:
        return;
_L3:
        if(getInputDevicePriority(bluetoothdevice) == -1)
            setInputDevicePriority(bluetoothdevice, 100);
        continue; /* Loop/switch isn't completed */
_L2:
        setInputDevicePriority(bluetoothdevice, -1);
        if(true) goto _L1; else goto _L4
_L4:
    }

    boolean setInputDevicePriority(BluetoothDevice bluetoothdevice, int i) {
        boolean flag;
        if(!BluetoothAdapter.checkBluetoothAddress(bluetoothdevice.getAddress()))
            flag = false;
        else
            flag = android.provider.Settings.Secure.putInt(mContext.getContentResolver(), android.provider.Settings.Secure.getBluetoothInputDevicePriorityKey(bluetoothdevice.getAddress()), i);
        return flag;
    }

    private static final boolean DBG = true;
    private static final String TAG = "BluetoothInputProfileHandler";
    public static BluetoothInputProfileHandler sInstance;
    private BluetoothService mBluetoothService;
    private Context mContext;
    private final BluetoothProfileState mHidProfileState;
    private final HashMap mInputDevices = new HashMap();
}
