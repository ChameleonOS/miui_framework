// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.bluetooth:
//            BluetoothProfile, BluetoothAdapter, BluetoothDevice, IBluetooth

public final class BluetoothInputDevice
    implements BluetoothProfile {

    BluetoothInputDevice(Context context, BluetoothProfile.ServiceListener servicelistener) {
        android.os.IBinder ibinder = ServiceManager.getService("bluetooth");
        mServiceListener = servicelistener;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(ibinder != null) {
            mService = IBluetooth.Stub.asInterface(ibinder);
            if(mServiceListener != null)
                mServiceListener.onServiceConnected(4, this);
        } else {
            Log.w("BluetoothInputDevice", "Bluetooth Service not available!");
            mService = null;
        }
    }

    private boolean isEnabled() {
        boolean flag;
        if(mAdapter.getState() == 12)
            flag = true;
        else
            flag = false;
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
        Log.d("BluetoothInputDevice", s);
    }

    void close() {
        mServiceListener = null;
    }

    public boolean connect(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1;
        try {
            flag1 = mService.connectInputDevice(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothInputDevice", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothInputDevice", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean disconnect(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1;
        try {
            flag1 = mService.disconnectInputDevice(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothInputDevice", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothInputDevice", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public List getConnectedDevices() {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        Object obj;
        List list;
        try {
            list = mService.getConnectedInputDevices();
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothInputDevice", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            obj = new ArrayList();
            continue; /* Loop/switch isn't completed */
        }
        obj = list;
_L4:
        return ((List) (obj));
_L2:
        if(mService == null)
            Log.w("BluetoothInputDevice", "Proxy not attached to service");
        obj = new ArrayList();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getConnectionState(BluetoothDevice bluetoothdevice) {
        int i = 0;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        int j;
        try {
            j = mService.getInputDeviceConnectionState(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothInputDevice", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        i = j;
_L4:
        return i;
_L2:
        if(mService == null)
            Log.w("BluetoothInputDevice", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public List getDevicesMatchingConnectionStates(int ai[]) {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        Object obj;
        List list;
        try {
            list = mService.getInputDevicesMatchingConnectionStates(ai);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothInputDevice", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            obj = new ArrayList();
            continue; /* Loop/switch isn't completed */
        }
        obj = list;
_L4:
        return ((List) (obj));
_L2:
        if(mService == null)
            Log.w("BluetoothInputDevice", "Proxy not attached to service");
        obj = new ArrayList();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getPriority(BluetoothDevice bluetoothdevice) {
        int i = 0;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        int j;
        try {
            j = mService.getInputDevicePriority(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothInputDevice", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        i = j;
_L4:
        return i;
_L2:
        if(mService == null)
            Log.w("BluetoothInputDevice", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean setPriority(BluetoothDevice bluetoothdevice, int i) {
        boolean flag = false;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        if(i == 0 || i == 100) goto _L4; else goto _L3
_L3:
        return flag;
_L4:
        boolean flag1;
        try {
            flag1 = mService.setInputDevicePriority(bluetoothdevice, i);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothInputDevice", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L2:
        if(mService == null)
            Log.w("BluetoothInputDevice", "Proxy not attached to service");
        if(true) goto _L3; else goto _L5
_L5:
    }

    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED";
    private static final boolean DBG = false;
    public static final int INPUT_CONNECT_FAILED_ALREADY_CONNECTED = 5001;
    public static final int INPUT_CONNECT_FAILED_ATTEMPT_FAILED = 5002;
    public static final int INPUT_DISCONNECT_FAILED_NOT_CONNECTED = 5000;
    public static final int INPUT_OPERATION_GENERIC_FAILURE = 5003;
    public static final int INPUT_OPERATION_SUCCESS = 5004;
    private static final String TAG = "BluetoothInputDevice";
    private BluetoothAdapter mAdapter;
    private IBluetooth mService;
    private BluetoothProfile.ServiceListener mServiceListener;
}
