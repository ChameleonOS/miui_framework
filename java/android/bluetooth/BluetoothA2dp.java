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
//            BluetoothProfile, BluetoothAdapter, BluetoothDevice, IBluetoothA2dp, 
//            BluetoothUuid

public final class BluetoothA2dp
    implements BluetoothProfile {

    BluetoothA2dp(Context context, BluetoothProfile.ServiceListener servicelistener) {
        android.os.IBinder ibinder = ServiceManager.getService("bluetooth_a2dp");
        mServiceListener = servicelistener;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(ibinder != null) {
            mService = IBluetoothA2dp.Stub.asInterface(ibinder);
            if(mServiceListener != null)
                mServiceListener.onServiceConnected(2, this);
        } else {
            Log.w("BluetoothA2dp", "Bluetooth A2DP service not available!");
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
        Log.d("BluetoothA2dp", s);
    }

    public static String stateToString(int i) {
        i;
        JVM INSTR tableswitch 0 11: default 64
    //                   0 91
    //                   1 97
    //                   2 103
    //                   3 109
    //                   4 64
    //                   5 64
    //                   6 64
    //                   7 64
    //                   8 64
    //                   9 64
    //                   10 115
    //                   11 121;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1 _L1 _L1 _L1 _L1 _L6 _L7
_L1:
        String s = (new StringBuilder()).append("<unknown state ").append(i).append(">").toString();
_L9:
        return s;
_L2:
        s = "disconnected";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "connecting";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "connected";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "disconnecting";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "playing";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "not playing";
        if(true) goto _L9; else goto _L8
_L8:
    }

    public boolean allowIncomingConnect(BluetoothDevice bluetoothdevice, boolean flag) {
        boolean flag2 = mService.allowIncomingConnect(bluetoothdevice, flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothA2dp", "", remoteexception);
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
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
            flag1 = mService.connect(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean disconnect(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1;
        try {
            flag1 = mService.disconnect(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public List getConnectedDevices() {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        Object obj;
        List list;
        try {
            list = mService.getConnectedDevices();
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            obj = new ArrayList();
            continue; /* Loop/switch isn't completed */
        }
        obj = list;
_L4:
        return ((List) (obj));
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
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
            j = mService.getConnectionState(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        i = j;
_L4:
        return i;
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public List getDevicesMatchingConnectionStates(int ai[]) {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        Object obj;
        List list;
        try {
            list = mService.getDevicesMatchingConnectionStates(ai);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            obj = new ArrayList();
            continue; /* Loop/switch isn't completed */
        }
        obj = list;
_L4:
        return ((List) (obj));
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
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
            j = mService.getPriority(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        i = j;
_L4:
        return i;
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isA2dpPlaying(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1;
        try {
            flag1 = mService.isA2dpPlaying(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean resumeSink(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1;
        try {
            flag1 = mService.resumeSink(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
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
            flag1 = mService.setPriority(bluetoothdevice, i);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
        if(true) goto _L3; else goto _L5
_L5:
    }

    public boolean shouldSendVolumeKeys(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        if(!isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        android.os.ParcelUuid aparceluuid[] = bluetoothdevice.getUuids();
        if(aparceluuid != null) goto _L3; else goto _L2
_L2:
        return flag;
_L3:
        int i = aparceluuid.length;
        int j = 0;
        do {
            if(j < i) {
label0:
                {
                    if(!BluetoothUuid.isAvrcpTarget(aparceluuid[j]))
                        break label0;
                    flag = true;
                }
            }
            if(true)
                continue;
            j++;
        } while(true);
        if(true) goto _L2; else goto _L4
_L4:
    }

    public boolean suspendSink(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1;
        try {
            flag1 = mService.suspendSink(bluetoothdevice);
        }
        catch(RemoteException remoteexception) {
            Log.e("BluetoothA2dp", (new StringBuilder()).append("Stack:").append(Log.getStackTraceString(new Throwable())).toString());
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothA2dp", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    public static final String ACTION_PLAYING_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED";
    private static final boolean DBG = false;
    public static final int STATE_NOT_PLAYING = 11;
    public static final int STATE_PLAYING = 10;
    private static final String TAG = "BluetoothA2dp";
    private BluetoothAdapter mAdapter;
    private IBluetoothA2dp mService;
    private BluetoothProfile.ServiceListener mServiceListener;
}
