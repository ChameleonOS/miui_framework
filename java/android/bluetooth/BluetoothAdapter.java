// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.content.Context;
import android.os.*;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;
import java.util.*;

// Referenced classes of package android.bluetooth:
//            BluetoothServerSocket, BluetoothSocket, IBluetooth, BluetoothHeadset, 
//            BluetoothA2dp, BluetoothInputDevice, BluetoothPan, BluetoothHealth, 
//            BluetoothDevice, BluetoothProfile

public final class BluetoothAdapter {
    public class StateChangeCallbackWrapper extends IBluetoothStateChangeCallback.Stub {

        public void onBluetoothStateChange(boolean flag) {
            mCallback.onBluetoothStateChange(flag);
        }

        private BluetoothStateChangeCallback mCallback;
        final BluetoothAdapter this$0;

        StateChangeCallbackWrapper(BluetoothStateChangeCallback bluetoothstatechangecallback) {
            this$0 = BluetoothAdapter.this;
            super();
            mCallback = bluetoothstatechangecallback;
        }
    }

    public static interface BluetoothStateChangeCallback {

        public abstract void onBluetoothStateChange(boolean flag);
    }

    private static class RfcommChannelPicker {

        public int nextChannel() {
            int i;
            if(mChannels.size() == 0)
                i = -1;
            else
                i = ((Integer)mChannels.remove(sRandom.nextInt(mChannels.size()))).intValue();
            return i;
        }

        private static final int RESERVED_RFCOMM_CHANNELS[];
        private static LinkedList sChannels;
        private static Random sRandom;
        private final LinkedList mChannels;
        private final UUID mUuid;

        static  {
            int ai[] = new int[4];
            ai[0] = 10;
            ai[1] = 11;
            ai[2] = 12;
            ai[3] = 19;
            RESERVED_RFCOMM_CHANNELS = ai;
        }

        public RfcommChannelPicker(UUID uuid) {
            android/bluetooth/BluetoothAdapter$RfcommChannelPicker;
            JVM INSTR monitorenter ;
            if(sChannels == null) {
                sChannels = new LinkedList();
                for(int i = 1; i <= 30; i++)
                    sChannels.addLast(new Integer(i));

                int ai[] = RESERVED_RFCOMM_CHANNELS;
                int j = ai.length;
                for(int k = 0; k < j; k++) {
                    int l = ai[k];
                    sChannels.remove(new Integer(l));
                }

                sRandom = new Random();
            }
            mChannels = (LinkedList)sChannels.clone();
            android/bluetooth/BluetoothAdapter$RfcommChannelPicker;
            JVM INSTR monitorexit ;
            mUuid = uuid;
            return;
            Exception exception;
            exception;
            android/bluetooth/BluetoothAdapter$RfcommChannelPicker;
            JVM INSTR monitorexit ;
            throw exception;
        }
    }


    public BluetoothAdapter(IBluetooth ibluetooth) {
        if(ibluetooth == null) {
            throw new IllegalArgumentException("service is null");
        } else {
            mService = ibluetooth;
            mServiceRecordHandler = null;
            return;
        }
    }

    public static boolean checkBluetoothAddress(String s) {
        boolean flag = false;
        if(s != null && s.length() == 17) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = 0;
_L8:
        if(i >= 17) goto _L4; else goto _L3
_L3:
        char c = s.charAt(i);
        i % 3;
        JVM INSTR tableswitch 0 2: default 60
    //                   0 66
    //                   1 66
    //                   2 93;
           goto _L5 _L6 _L6 _L7
_L5:
        i++;
          goto _L8
_L6:
        if((c < '0' || c > '9') && (c < 'A' || c > 'F')) goto _L9; else goto _L5
_L9:
        break; /* Loop/switch isn't completed */
_L7:
        if(c != ':') goto _L1; else goto _L5
_L4:
        flag = true;
        if(true) goto _L1; else goto _L10
_L10:
    }

    private BluetoothServerSocket createNewRfcommSocketAndRecord(String s, UUID uuid, boolean flag, boolean flag1) throws IOException {
        RfcommChannelPicker rfcommchannelpicker = new RfcommChannelPicker(uuid);
_L5:
        int i;
        BluetoothServerSocket bluetoothserversocket;
        int j;
        i = rfcommchannelpicker.nextChannel();
        if(i == -1)
            throw new IOException("No available channels");
        bluetoothserversocket = new BluetoothServerSocket(1, flag, flag1, i);
        j = bluetoothserversocket.mSocket.bindListen();
        if(j != 0) goto _L2; else goto _L1
_L1:
        int k = -1;
        int l = mService.addRfcommServiceRecord(s, new ParcelUuid(uuid), i, new Binder());
        k = l;
_L3:
        if(k == -1) {
            IOException ioexception;
            IOException ioexception1;
            RemoteException remoteexception;
            try {
                bluetoothserversocket.close();
            }
            catch(IOException ioexception2) { }
            throw new IOException((new StringBuilder()).append("Not able to register SDP record for ").append(s).toString());
        }
        break MISSING_BLOCK_LABEL_193;
_L2:
        if(j == 98) {
            try {
                bluetoothserversocket.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception1) { }
        } else {
            try {
                bluetoothserversocket.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception) { }
            bluetoothserversocket.mSocket.throwErrnoNative(j);
        }
        continue; /* Loop/switch isn't completed */
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
          goto _L3
        if(mServiceRecordHandler == null)
            mServiceRecordHandler = new Handler(Looper.getMainLooper()) {

                public void handleMessage(Message message) {
                    int i1 = message.what;
                    mService.removeServiceRecord(i1);
_L1:
                    return;
                    RemoteException remoteexception1;
                    remoteexception1;
                    Log.e("BluetoothAdapter", "", remoteexception1);
                      goto _L1
                }

                final BluetoothAdapter this$0;

             {
                this$0 = BluetoothAdapter.this;
                super(looper);
            }
            };
        bluetoothserversocket.setCloseHandler(mServiceRecordHandler, k);
        return bluetoothserversocket;
        if(true) goto _L5; else goto _L4
_L4:
    }

    /**
     * @deprecated Method getDefaultAdapter is deprecated
     */

    public static BluetoothAdapter getDefaultAdapter() {
        android/bluetooth/BluetoothAdapter;
        JVM INSTR monitorenter ;
        BluetoothAdapter bluetoothadapter;
        if(sAdapter == null) {
            android.os.IBinder ibinder = ServiceManager.getService("bluetooth");
            if(ibinder != null)
                sAdapter = new BluetoothAdapter(IBluetooth.Stub.asInterface(ibinder));
        }
        bluetoothadapter = sAdapter;
        android/bluetooth/BluetoothAdapter;
        JVM INSTR monitorexit ;
        return bluetoothadapter;
        Exception exception;
        exception;
        throw exception;
    }

    public static BluetoothServerSocket listenUsingScoOn() throws IOException {
        BluetoothServerSocket bluetoothserversocket = new BluetoothServerSocket(2, false, false, -1);
        int i = bluetoothserversocket.mSocket.bindListen();
        if(i != 0) {
            try {
                bluetoothserversocket.close();
            }
            catch(IOException ioexception) { }
            bluetoothserversocket.mSocket.throwErrnoNative(i);
        }
        return bluetoothserversocket;
    }

    private Set toDeviceSet(String as[]) {
        HashSet hashset = new HashSet(as.length);
        for(int i = 0; i < as.length; i++)
            hashset.add(getRemoteDevice(as[i]));

        return Collections.unmodifiableSet(hashset);
    }

    public boolean cancelDiscovery() {
        boolean flag = false;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mService.cancelDiscovery();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean changeApplicationBluetoothState(boolean flag, BluetoothStateChangeCallback bluetoothstatechangecallback) {
        boolean flag1 = false;
        if(bluetoothstatechangecallback != null) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        boolean flag2 = mService.changeApplicationBluetoothState(flag, new StateChangeCallbackWrapper(bluetoothstatechangecallback), new Binder());
        flag1 = flag2;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "changeBluetoothState", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void closeProfileProxy(int i, BluetoothProfile bluetoothprofile) {
        if(bluetoothprofile != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch(i) {
        case 1: // '\001'
            ((BluetoothHeadset)bluetoothprofile).close();
            break;

        case 2: // '\002'
            ((BluetoothA2dp)bluetoothprofile).close();
            break;

        case 4: // '\004'
            ((BluetoothInputDevice)bluetoothprofile).close();
            break;

        case 5: // '\005'
            ((BluetoothPan)bluetoothprofile).close();
            break;

        case 3: // '\003'
            ((BluetoothHealth)bluetoothprofile).close();
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean disable() {
        boolean flag1 = mService.disable(true);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean enable() {
        boolean flag1 = mService.enable();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean enableNoAutoConnect() {
        boolean flag1 = mService.enableNoAutoConnect();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getAddress() {
        String s1 = mService.getAddress();
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Set getBondedDevices() {
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        Set set = toDeviceSet(new String[0]);
_L4:
        return set;
_L2:
        Set set1 = toDeviceSet(mService.listBonds());
        set = set1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        set = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getConnectionState() {
        int i = 0;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j = mService.getAdapterConnectionState();
        i = j;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "getConnectionState:", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int getDiscoverableTimeout() {
        int i = -1;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j = mService.getDiscoverableTimeout();
        i = j;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public String getName() {
        String s1 = mService.getName();
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getProfileConnectionState(int i) {
        int j = 0;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int k = mService.getProfileConnectionState(i);
        j = k;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "getProfileConnectionState:", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean getProfileProxy(Context context, BluetoothProfile.ServiceListener servicelistener, int i) {
        boolean flag = true;
        if(context == null || servicelistener == null)
            flag = false;
        else
        if(i == flag)
            new BluetoothHeadset(context, servicelistener);
        else
        if(i == 2)
            new BluetoothA2dp(context, servicelistener);
        else
        if(i == 4)
            new BluetoothInputDevice(context, servicelistener);
        else
        if(i == 5)
            new BluetoothPan(context, servicelistener);
        else
        if(i == 3)
            new BluetoothHealth(context, servicelistener);
        else
            flag = false;
        return flag;
    }

    public BluetoothDevice getRemoteDevice(String s) {
        return new BluetoothDevice(s);
    }

    public BluetoothDevice getRemoteDevice(byte abyte0[]) {
        if(abyte0 == null || abyte0.length != 6) {
            throw new IllegalArgumentException("Bluetooth address must have 6 bytes");
        } else {
            Object aobj[] = new Object[6];
            aobj[0] = Byte.valueOf(abyte0[0]);
            aobj[1] = Byte.valueOf(abyte0[1]);
            aobj[2] = Byte.valueOf(abyte0[2]);
            aobj[3] = Byte.valueOf(abyte0[3]);
            aobj[4] = Byte.valueOf(abyte0[4]);
            aobj[5] = Byte.valueOf(abyte0[5]);
            return new BluetoothDevice(String.format("%02X:%02X:%02X:%02X:%02X:%02X", aobj));
        }
    }

    public int getScanMode() {
        int i = 20;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j = mService.getScanMode();
        i = j;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int getState() {
        int j = mService.getBluetoothState();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        i = 10;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public ParcelUuid[] getUuids() {
        ParcelUuid aparceluuid[] = null;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return aparceluuid;
_L2:
        ParcelUuid aparceluuid1[] = mService.getUuids();
        aparceluuid = aparceluuid1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean isDiscovering() {
        boolean flag = false;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mService.isDiscovering();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean isEnabled() {
        boolean flag1 = mService.isEnabled();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public BluetoothServerSocket listenUsingEncryptedRfcommOn(int i) throws IOException {
        BluetoothServerSocket bluetoothserversocket = new BluetoothServerSocket(1, false, true, i);
        int j = bluetoothserversocket.mSocket.bindListen();
        if(j != 0) {
            try {
                bluetoothserversocket.close();
            }
            catch(IOException ioexception) { }
            bluetoothserversocket.mSocket.throwErrnoNative(j);
        }
        return bluetoothserversocket;
    }

    public BluetoothServerSocket listenUsingEncryptedRfcommWithServiceRecord(String s, UUID uuid) throws IOException {
        return createNewRfcommSocketAndRecord(s, uuid, false, true);
    }

    public BluetoothServerSocket listenUsingInsecureRfcommOn(int i) throws IOException {
        BluetoothServerSocket bluetoothserversocket = new BluetoothServerSocket(1, false, false, i);
        int j = bluetoothserversocket.mSocket.bindListen();
        if(j != 0) {
            try {
                bluetoothserversocket.close();
            }
            catch(IOException ioexception) { }
            bluetoothserversocket.mSocket.throwErrnoNative(j);
        }
        return bluetoothserversocket;
    }

    public BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(String s, UUID uuid) throws IOException {
        return createNewRfcommSocketAndRecord(s, uuid, false, false);
    }

    public BluetoothServerSocket listenUsingRfcommOn(int i) throws IOException {
        BluetoothServerSocket bluetoothserversocket = new BluetoothServerSocket(1, true, true, i);
        int j = bluetoothserversocket.mSocket.bindListen();
        if(j != 0) {
            try {
                bluetoothserversocket.close();
            }
            catch(IOException ioexception) { }
            bluetoothserversocket.mSocket.throwErrnoNative(j);
        }
        return bluetoothserversocket;
    }

    public BluetoothServerSocket listenUsingRfcommWithServiceRecord(String s, UUID uuid) throws IOException {
        return createNewRfcommSocketAndRecord(s, uuid, true, true);
    }

    public Pair readOutOfBandData() {
        Pair pair = null;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return pair;
_L2:
        Pair pair1;
        byte abyte0[] = mService.readOutOfBandData();
        if(abyte0 == null || abyte0.length != 32)
            continue; /* Loop/switch isn't completed */
        pair1 = new Pair(Arrays.copyOfRange(abyte0, 0, 16), Arrays.copyOfRange(abyte0, 16, 32));
        pair = pair1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setDiscoverableTimeout(int i) {
        if(getState() == 12)
            try {
                mService.setDiscoverableTimeout(i);
            }
            catch(RemoteException remoteexception) {
                Log.e("BluetoothAdapter", "", remoteexception);
            }
    }

    public boolean setName(String s) {
        boolean flag = false;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mService.setName(s);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean setScanMode(int i) {
        boolean flag;
        if(getState() != 12)
            flag = false;
        else
            flag = setScanMode(i, 120);
        return flag;
    }

    public boolean setScanMode(int i, int j) {
        boolean flag = false;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mService.setScanMode(i, j);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean startDiscovery() {
        boolean flag = false;
        if(getState() == 12) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mService.startDiscovery();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothAdapter", "", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
    public static final String ACTION_DISCOVERY_FINISHED = "android.bluetooth.adapter.action.DISCOVERY_FINISHED";
    public static final String ACTION_DISCOVERY_STARTED = "android.bluetooth.adapter.action.DISCOVERY_STARTED";
    public static final String ACTION_LOCAL_NAME_CHANGED = "android.bluetooth.adapter.action.LOCAL_NAME_CHANGED";
    public static final String ACTION_REQUEST_DISCOVERABLE = "android.bluetooth.adapter.action.REQUEST_DISCOVERABLE";
    public static final String ACTION_REQUEST_ENABLE = "android.bluetooth.adapter.action.REQUEST_ENABLE";
    public static final String ACTION_SCAN_MODE_CHANGED = "android.bluetooth.adapter.action.SCAN_MODE_CHANGED";
    public static final String ACTION_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";
    private static final int ADDRESS_LENGTH = 17;
    public static final String BLUETOOTH_SERVICE = "bluetooth";
    private static final boolean DBG = false;
    public static final int ERROR = 0x80000000;
    public static final String EXTRA_CONNECTION_STATE = "android.bluetooth.adapter.extra.CONNECTION_STATE";
    public static final String EXTRA_DISCOVERABLE_DURATION = "android.bluetooth.adapter.extra.DISCOVERABLE_DURATION";
    public static final String EXTRA_LOCAL_NAME = "android.bluetooth.adapter.extra.LOCAL_NAME";
    public static final String EXTRA_PREVIOUS_CONNECTION_STATE = "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";
    public static final String EXTRA_PREVIOUS_SCAN_MODE = "android.bluetooth.adapter.extra.PREVIOUS_SCAN_MODE";
    public static final String EXTRA_PREVIOUS_STATE = "android.bluetooth.adapter.extra.PREVIOUS_STATE";
    public static final String EXTRA_SCAN_MODE = "android.bluetooth.adapter.extra.SCAN_MODE";
    public static final String EXTRA_STATE = "android.bluetooth.adapter.extra.STATE";
    public static final int SCAN_MODE_CONNECTABLE = 21;
    public static final int SCAN_MODE_CONNECTABLE_DISCOVERABLE = 23;
    public static final int SCAN_MODE_NONE = 20;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = 3;
    public static final int STATE_OFF = 10;
    public static final int STATE_ON = 12;
    public static final int STATE_TURNING_OFF = 13;
    public static final int STATE_TURNING_ON = 11;
    private static final String TAG = "BluetoothAdapter";
    private static BluetoothAdapter sAdapter;
    private final IBluetooth mService;
    private Handler mServiceRecordHandler;

}
