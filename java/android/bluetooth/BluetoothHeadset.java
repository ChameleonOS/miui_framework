// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.content.*;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.bluetooth:
//            BluetoothProfile, BluetoothAdapter, IBluetoothHeadset, BluetoothDevice

public final class BluetoothHeadset
    implements BluetoothProfile {

    BluetoothHeadset(Context context, BluetoothProfile.ServiceListener servicelistener) {
        mConnection = new ServiceConnection() {

            public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
                mService = IBluetoothHeadset.Stub.asInterface(ibinder);
                if(mServiceListener != null)
                    mServiceListener.onServiceConnected(1, BluetoothHeadset.this);
            }

            public void onServiceDisconnected(ComponentName componentname) {
                mService = null;
                if(mServiceListener != null)
                    mServiceListener.onServiceDisconnected(1);
            }

            final BluetoothHeadset this$0;

             {
                this$0 = BluetoothHeadset.this;
                super();
            }
        };
        mContext = context;
        mServiceListener = servicelistener;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!context.bindService(new Intent(android/bluetooth/IBluetoothHeadset.getName()), mConnection, 0))
            Log.e("BluetoothHeadset", "Could not bind to Bluetooth Headset Service");
    }

    public static boolean isBluetoothVoiceDialingEnabled(Context context) {
        return context.getResources().getBoolean(0x1110025);
    }

    private boolean isDisabled() {
        boolean flag;
        if(mAdapter.getState() == 10)
            flag = true;
        else
            flag = false;
        return flag;
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
        Log.d("BluetoothHeadset", s);
    }

    public boolean acceptIncomingConnect(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.acceptIncomingConnect(bluetoothdevice);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
    }

    public boolean cancelConnectThread() {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.cancelConnectThread();
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
    }

    /**
     * @deprecated Method close is deprecated
     */

    void close() {
        this;
        JVM INSTR monitorenter ;
        if(mConnection != null) {
            mContext.unbindService(mConnection);
            mConnection = null;
        }
        mServiceListener = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
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
            Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean connectHeadsetInternal(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.connectHeadsetInternal(bluetoothdevice);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
    }

    public boolean createIncomingConnect(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.createIncomingConnect(bluetoothdevice);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
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
            Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean disconnectHeadsetInternal(BluetoothDevice bluetoothdevice) {
        if(mService == null || isDisabled()) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.disconnectHeadsetInternal(bluetoothdevice);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
    }

    public int getAudioState(BluetoothDevice bluetoothdevice) {
        if(mService == null || isDisabled()) goto _L2; else goto _L1
_L1:
        int j = mService.getAudioState(bluetoothdevice);
        int i = j;
_L3:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        i = 10;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
    }

    public int getBatteryUsageHint(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        int j = mService.getBatteryUsageHint(bluetoothdevice);
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
        i = -1;
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
            Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
            obj = new ArrayList();
            continue; /* Loop/switch isn't completed */
        }
        obj = list;
_L4:
        return ((List) (obj));
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
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
            Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
            continue; /* Loop/switch isn't completed */
        }
        i = j;
_L4:
        return i;
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
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
            Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
            obj = new ArrayList();
            continue; /* Loop/switch isn't completed */
        }
        obj = list;
_L4:
        return ((List) (obj));
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
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
            Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
            continue; /* Loop/switch isn't completed */
        }
        i = j;
_L4:
        return i;
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isAudioConnected(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.isAudioConnected(bluetoothdevice);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean rejectIncomingConnect(BluetoothDevice bluetoothdevice) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.rejectIncomingConnect(bluetoothdevice);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
    }

    public boolean setAudioState(BluetoothDevice bluetoothdevice, int i) {
        if(mService == null || isDisabled()) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.setAudioState(bluetoothdevice, i);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
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
            Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
        if(true) goto _L3; else goto _L5
_L5:
    }

    public boolean startScoUsingVirtualVoiceCall(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.startScoUsingVirtualVoiceCall(bluetoothdevice);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
    }

    public boolean startVoiceRecognition(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.startVoiceRecognition(bluetoothdevice);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean stopScoUsingVirtualVoiceCall(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.stopScoUsingVirtualVoiceCall(bluetoothdevice);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothHeadset", "Proxy not attached to service");
          goto _L4
    }

    public boolean stopVoiceRecognition(BluetoothDevice bluetoothdevice) {
        if(mService == null || !isEnabled() || !isValidDevice(bluetoothdevice)) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.stopVoiceRecognition(bluetoothdevice);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothHeadset", Log.getStackTraceString(new Throwable()));
_L2:
        if(mService == null)
            Log.w("BluetoothHeadset", "Proxy not attached to service");
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final String ACTION_AUDIO_STATE_CHANGED = "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED";
    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
    public static final String ACTION_VENDOR_SPECIFIC_HEADSET_EVENT = "android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT";
    public static final int AT_CMD_TYPE_ACTION = 4;
    public static final int AT_CMD_TYPE_BASIC = 3;
    public static final int AT_CMD_TYPE_READ = 0;
    public static final int AT_CMD_TYPE_SET = 2;
    public static final int AT_CMD_TYPE_TEST = 1;
    private static final boolean DBG = false;
    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_ARGS = "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS";
    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD = "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD";
    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE = "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE";
    public static final int STATE_AUDIO_CONNECTED = 12;
    public static final int STATE_AUDIO_CONNECTING = 11;
    public static final int STATE_AUDIO_DISCONNECTED = 10;
    private static final String TAG = "BluetoothHeadset";
    public static final String VENDOR_SPECIFIC_HEADSET_EVENT_COMPANY_ID_CATEGORY = "android.bluetooth.headset.intent.category.companyid";
    BluetoothAdapter mAdapter;
    private ServiceConnection mConnection;
    private Context mContext;
    private IBluetoothHeadset mService;
    private BluetoothProfile.ServiceListener mServiceListener;


/*
    static IBluetoothHeadset access$002(BluetoothHeadset bluetoothheadset, IBluetoothHeadset ibluetoothheadset) {
        bluetoothheadset.mService = ibluetoothheadset;
        return ibluetoothheadset;
    }

*/

}
