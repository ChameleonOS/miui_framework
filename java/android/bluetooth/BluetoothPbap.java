// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.content.*;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package android.bluetooth:
//            IBluetoothPbap, BluetoothClass, BluetoothDevice

public class BluetoothPbap {
    public static interface ServiceListener {

        public abstract void onServiceConnected();

        public abstract void onServiceDisconnected();
    }


    public BluetoothPbap(Context context, ServiceListener servicelistener) {
        mConnection = new ServiceConnection() {

            public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
                mService = IBluetoothPbap.Stub.asInterface(ibinder);
                if(mServiceListener != null)
                    mServiceListener.onServiceConnected();
            }

            public void onServiceDisconnected(ComponentName componentname) {
                mService = null;
                if(mServiceListener != null)
                    mServiceListener.onServiceDisconnected();
            }

            final BluetoothPbap this$0;

             {
                this$0 = BluetoothPbap.this;
                super();
            }
        };
        mContext = context;
        mServiceListener = servicelistener;
        if(!context.bindService(new Intent(android/bluetooth/IBluetoothPbap.getName()), mConnection, 0))
            Log.e("BluetoothPbap", "Could not bind to Bluetooth Pbap Service");
    }

    public static boolean doesClassMatchSink(BluetoothClass bluetoothclass) {
        bluetoothclass.getDeviceClass();
        JVM INSTR lookupswitch 4: default 48
    //                   256: 52
    //                   260: 52
    //                   264: 52
    //                   268: 52;
           goto _L1 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void log(String s) {
        Log.d("BluetoothPbap", s);
    }

    /**
     * @deprecated Method close is deprecated
     */

    public void close() {
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

    public boolean disconnect() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        mService.disconnect();
        boolean flag = true;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothPbap", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothPbap", "Proxy not attached to service");
          goto _L4
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public BluetoothDevice getClient() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        BluetoothDevice bluetoothdevice1 = mService.getClient();
        BluetoothDevice bluetoothdevice = bluetoothdevice1;
_L3:
        return bluetoothdevice;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothPbap", remoteexception.toString());
_L4:
        bluetoothdevice = null;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothPbap", "Proxy not attached to service");
          goto _L4
    }

    public int getState() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getState();
        int i = j;
_L3:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothPbap", remoteexception.toString());
_L4:
        i = -1;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothPbap", "Proxy not attached to service");
          goto _L4
    }

    public boolean isConnected(BluetoothDevice bluetoothdevice) {
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mService.isConnected(bluetoothdevice);
        boolean flag = flag1;
_L3:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothPbap", remoteexception.toString());
_L4:
        flag = false;
        if(true) goto _L3; else goto _L2
_L2:
        Log.w("BluetoothPbap", "Proxy not attached to service");
          goto _L4
    }

    private static final boolean DBG = false;
    public static final String PBAP_PREVIOUS_STATE = "android.bluetooth.pbap.intent.PBAP_PREVIOUS_STATE";
    public static final String PBAP_STATE = "android.bluetooth.pbap.intent.PBAP_STATE";
    public static final String PBAP_STATE_CHANGED_ACTION = "android.bluetooth.pbap.intent.action.PBAP_STATE_CHANGED";
    public static final int RESULT_CANCELED = 2;
    public static final int RESULT_FAILURE = 0;
    public static final int RESULT_SUCCESS = 1;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_ERROR = -1;
    private static final String TAG = "BluetoothPbap";
    private ServiceConnection mConnection;
    private final Context mContext;
    private IBluetoothPbap mService;
    private ServiceListener mServiceListener;


/*
    static IBluetoothPbap access$002(BluetoothPbap bluetoothpbap, IBluetoothPbap ibluetoothpbap) {
        bluetoothpbap.mService = ibluetoothpbap;
        return ibluetoothpbap;
    }

*/

}
