// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.content.Context;
import android.os.*;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.bluetooth:
//            BluetoothProfile, BluetoothAdapter, BluetoothDevice, IBluetooth, 
//            BluetoothHealthAppConfiguration, BluetoothHealthCallback

public final class BluetoothHealth
    implements BluetoothProfile {
    private static class BluetoothHealthCallbackWrapper extends IBluetoothHealthCallback.Stub {

        public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) {
            mCallback.onHealthAppConfigurationStatusChange(bluetoothhealthappconfiguration, i);
        }

        public void onHealthChannelStateChange(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, BluetoothDevice bluetoothdevice, int i, int j, ParcelFileDescriptor parcelfiledescriptor, int k) {
            mCallback.onHealthChannelStateChange(bluetoothhealthappconfiguration, bluetoothdevice, i, j, parcelfiledescriptor, k);
        }

        private BluetoothHealthCallback mCallback;

        public BluetoothHealthCallbackWrapper(BluetoothHealthCallback bluetoothhealthcallback) {
            mCallback = bluetoothhealthcallback;
        }
    }


    BluetoothHealth(Context context, BluetoothProfile.ServiceListener servicelistener) {
        android.os.IBinder ibinder = ServiceManager.getService("bluetooth");
        mServiceListener = servicelistener;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(ibinder != null) {
            mService = IBluetooth.Stub.asInterface(ibinder);
            if(mServiceListener != null)
                mServiceListener.onServiceConnected(3, this);
        } else {
            Log.w("BluetoothHealth", "Bluetooth Service not available!");
            mService = null;
        }
    }

    private boolean checkAppParam(String s, int i, int j, BluetoothHealthCallback bluetoothhealthcallback) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_3;
        if(s != null && (i == 1 || i == 2) && (j == 10 || j == 11 || j == 12) && bluetoothhealthcallback != null && (i != 1 || j != 12))
            flag = true;
        return flag;
    }

    private boolean isEnabled() {
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        boolean flag;
        if(bluetoothadapter != null && bluetoothadapter.getState() == 12) {
            flag = true;
        } else {
            log("Bluetooth is Not enabled");
            flag = false;
        }
        return flag;
    }

    private boolean isValidDevice(BluetoothDevice bluetoothdevice) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(bluetoothdevice != null && BluetoothAdapter.checkBluetoothAddress(bluetoothdevice.getAddress()))
            flag = true;
        return flag;
    }

    private static void log(String s) {
        Log.d("BluetoothHealth", s);
    }

    void close() {
        mServiceListener = null;
    }

    public boolean connectChannelToSink(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice) || bluetoothhealthappconfiguration == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.connectChannelToSink(bluetoothdevice, bluetoothhealthappconfiguration, i);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHealth", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHealth", "Proxy not attached to service");
          goto _L4
    }

    public boolean connectChannelToSource(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice) || bluetoothhealthappconfiguration == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.connectChannelToSource(bluetoothdevice, bluetoothhealthappconfiguration);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHealth", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHealth", "Proxy not attached to service");
          goto _L4
    }

    public boolean disconnectChannel(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice) || bluetoothhealthappconfiguration == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.disconnectChannel(bluetoothdevice, bluetoothhealthappconfiguration, i);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHealth", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHealth", "Proxy not attached to service");
          goto _L4
    }

    public List getConnectedDevices() {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        Object obj;
        List list;
        try {
            list = mService.getConnectedHealthDevices();
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothHealth", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            obj = new ArrayList();
            continue; /* Loop/switch isn't completed */
        }
        obj = list;
_L4:
        return ((List) (obj));
_L2:
        if(mService == null)
            Log.w("BluetoothHealth", "Proxy not attached to service");
        obj = new ArrayList();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getConnectionState(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        int j = mService.getHealthDeviceConnectionState(bluetoothdevice);
        int i = j;
_L3:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHealth", remoteexception.toString());
_L4:
        i = 0;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHealth", "Proxy not attached to service");
          goto _L4
    }

    public List getDevicesMatchingConnectionStates(int ai[]) {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        Object obj;
        List list;
        try {
            list = mService.getHealthDevicesMatchingConnectionStates(ai);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothHealth", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            obj = new ArrayList();
            continue; /* Loop/switch isn't completed */
        }
        obj = list;
_L4:
        return ((List) (obj));
_L2:
        if(mService == null)
            Log.w("BluetoothHealth", "Proxy not attached to service");
        obj = new ArrayList();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public ParcelFileDescriptor getMainChannelFd(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice) || bluetoothhealthappconfiguration == null) goto _L2; else goto _L1
_L1:
        ParcelFileDescriptor parcelfiledescriptor1 = mService.getMainChannelFd(bluetoothdevice, bluetoothhealthappconfiguration);
        ParcelFileDescriptor parcelfiledescriptor = parcelfiledescriptor1;
_L3:
        return parcelfiledescriptor;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHealth", remoteexception.toString());
_L4:
        parcelfiledescriptor = null;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHealth", "Proxy not attached to service");
          goto _L4
    }

    public boolean registerAppConfiguration(String s, int i, int j, int k, BluetoothHealthCallback bluetoothhealthcallback) {
        boolean flag = false;
        if(isEnabled() && checkAppParam(s, j, k, bluetoothhealthcallback)) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        BluetoothHealthCallbackWrapper bluetoothhealthcallbackwrapper;
        BluetoothHealthAppConfiguration bluetoothhealthappconfiguration;
        bluetoothhealthcallbackwrapper = new BluetoothHealthCallbackWrapper(bluetoothhealthcallback);
        bluetoothhealthappconfiguration = new BluetoothHealthAppConfiguration(s, i, j, k);
        if(mService == null)
            break; /* Loop/switch isn't completed */
        boolean flag2 = mService.registerAppConfiguration(bluetoothhealthappconfiguration, bluetoothhealthcallbackwrapper);
        flag = flag2;
_L5:
        flag1 = flag;
        if(true) goto _L4; else goto _L3
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHealth", remoteexception.toString());
          goto _L5
_L3:
        Log.w("BluetoothHealth", "Proxy not attached to service");
          goto _L5
    }

    public boolean registerSinkAppConfiguration(String s, int i, BluetoothHealthCallback bluetoothhealthcallback) {
        boolean flag;
        if(!isEnabled() || s == null)
            flag = false;
        else
            flag = registerAppConfiguration(s, i, 2, 12, bluetoothhealthcallback);
        return flag;
    }

    public boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) {
        boolean flag = false;
        if(mService == null || !isEnabled() || bluetoothhealthappconfiguration == null) goto _L2; else goto _L1
_L1:
        boolean flag1;
        try {
            flag1 = mService.unregisterAppConfiguration(bluetoothhealthappconfiguration);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothHealth", remoteexception.toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        Log.w("BluetoothHealth", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final int APP_CONFIG_REGISTRATION_FAILURE = 1;
    public static final int APP_CONFIG_REGISTRATION_SUCCESS = 0;
    public static final int APP_CONFIG_UNREGISTRATION_FAILURE = 3;
    public static final int APP_CONFIG_UNREGISTRATION_SUCCESS = 2;
    public static final int CHANNEL_TYPE_ANY = 12;
    public static final int CHANNEL_TYPE_RELIABLE = 10;
    public static final int CHANNEL_TYPE_STREAMING = 11;
    private static final boolean DBG = false;
    public static final int HEALTH_OPERATION_ERROR = 6001;
    public static final int HEALTH_OPERATION_GENERIC_FAILURE = 6003;
    public static final int HEALTH_OPERATION_INVALID_ARGS = 6002;
    public static final int HEALTH_OPERATION_NOT_ALLOWED = 6005;
    public static final int HEALTH_OPERATION_NOT_FOUND = 6004;
    public static final int HEALTH_OPERATION_SUCCESS = 6000;
    public static final int SINK_ROLE = 2;
    public static final int SOURCE_ROLE = 1;
    public static final int STATE_CHANNEL_CONNECTED = 2;
    public static final int STATE_CHANNEL_CONNECTING = 1;
    public static final int STATE_CHANNEL_DISCONNECTED = 0;
    public static final int STATE_CHANNEL_DISCONNECTING = 3;
    private static final String TAG = "BluetoothHealth";
    BluetoothAdapter mAdapter;
    private IBluetooth mService;
    private BluetoothProfile.ServiceListener mServiceListener;
}
