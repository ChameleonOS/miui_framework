// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.bluetooth.*;
import android.content.*;
import android.content.res.Resources;
import android.os.*;
import android.util.Log;
import android.util.Pair;
import com.android.internal.app.IBatteryStats;
import java.io.*;
import java.util.*;

// Referenced classes of package android.server:
//            BluetoothBondState, BluetoothAdapterProperties, BluetoothDeviceProperties, BluetoothInputProfileHandler, 
//            BluetoothPanProfileHandler, BluetoothHealthProfileHandler, BluetoothEventLoop, BluetoothAdapterStateMachine, 
//            BluetoothA2dpService

public class BluetoothService extends android.bluetooth.IBluetooth.Stub {
    private class Reaper
        implements android.os.IBinder.DeathRecipient {

        public void binderDied() {
            BluetoothService bluetoothservice = BluetoothService.this;
            bluetoothservice;
            JVM INSTR monitorenter ;
            Log.d("BluetoothService", (new StringBuilder()).append("Tracked app ").append(mPid).append(" died").append("Type:").append(mType).toString());
            if(mType != 10) goto _L2; else goto _L1
_L1:
            checkAndRemoveRecord(mHandle, mPid);
_L4:
            bluetoothservice;
            JVM INSTR monitorexit ;
            return;
_L2:
            if(mType == 11)
                mStateChangeTracker.remove(Integer.valueOf(mPid));
            if(true) goto _L4; else goto _L3
_L3:
        }

        int mHandle;
        int mPid;
        int mType;
        final BluetoothService this$0;

        Reaper(int i, int j) {
            this$0 = BluetoothService.this;
            super();
            mPid = i;
            mType = j;
        }

        Reaper(int i, int j, int k) {
            this$0 = BluetoothService.this;
            super();
            mPid = j;
            mHandle = i;
            mType = k;
        }
    }

    private static class RemoteService {

        public boolean equals(Object obj) {
            boolean flag = false;
            if(obj instanceof RemoteService) {
                RemoteService remoteservice = (RemoteService)obj;
                if(address.equals(remoteservice.address) && uuid.equals(remoteservice.uuid))
                    flag = true;
            }
            return flag;
        }

        public int hashCode() {
            int i = 0;
            int j;
            int k;
            if(address == null)
                j = 0;
            else
                j = address.hashCode();
            k = 31 * (j + 31);
            if(uuid != null)
                i = uuid.hashCode();
            return k + i;
        }

        public String address;
        public ParcelUuid uuid;

        public RemoteService(String s, ParcelUuid parceluuid) {
            address = s;
            uuid = parceluuid;
        }
    }

    private static class ServiceRecordClient {

        IBinder binder;
        android.os.IBinder.DeathRecipient death;
        int pid;

        private ServiceRecordClient() {
        }

    }


    public BluetoothService(Context context) {
        mStateChangeTracker = Collections.synchronizedMap(new HashMap());
        mProfilesConnected = 0;
        mProfilesConnecting = 0;
        mProfilesDisconnecting = 0;
        mAllowConnect = true;
        mAdapterConnectionState = 0;
        mBluetoothProfileServiceListener = new android.bluetooth.BluetoothProfile.ServiceListener() {

            public void onServiceConnected(int i, BluetoothProfile bluetoothprofile) {
                if(i != 1) goto _L2; else goto _L1
_L1:
                mHeadsetProxy = (BluetoothHeadset)bluetoothprofile;
_L4:
                return;
_L2:
                if(i == 4)
                    mInputDevice = (BluetoothInputDevice)bluetoothprofile;
                else
                if(i == 5)
                    mPan = (BluetoothPan)bluetoothprofile;
                if(true) goto _L4; else goto _L3
_L3:
            }

            public void onServiceDisconnected(int i) {
                if(i != 1) goto _L2; else goto _L1
_L1:
                mHeadsetProxy = null;
_L4:
                return;
_L2:
                if(i == 4)
                    mInputDevice = null;
                else
                if(i == 5)
                    mPan = null;
                if(true) goto _L4; else goto _L3
_L3:
            }

            final BluetoothService this$0;

             {
                this$0 = BluetoothService.this;
                super();
            }
        };
        mContext = context;
        initializeNativeDataNative();
        if(isEnabledNative() == 1) {
            Log.w("BluetoothService", "Bluetooth daemons already running - runtime restart? ");
            disableNative();
        }
        mBondState = new BluetoothBondState(context, this);
        mAdapterProperties = new BluetoothAdapterProperties(context, this);
        mA2dpProfileState = new BluetoothProfileState(mContext, 1);
        mHfpProfileState = new BluetoothProfileState(mContext, 0);
        mHfpProfileState.start();
        mA2dpProfileState.start();
        IntentFilter intentfilter = new IntentFilter();
        registerForAirplaneMode(intentfilter);
        intentfilter.addAction("android.intent.action.DOCK_EVENT");
        mContext.registerReceiver(mReceiver, intentfilter);
        mBluetoothInputProfileHandler = BluetoothInputProfileHandler.getInstance(mContext, this);
        mBluetoothPanProfileHandler = BluetoothPanProfileHandler.getInstance(mContext, this);
        mBluetoothHealthProfileHandler = BluetoothHealthProfileHandler.getInstance(mContext, this);
        mIncomingConnections = new HashMap();
        mProfileConnectionState = new HashMap();
    }

    /**
     * @deprecated Method addReservedSdpRecords is deprecated
     */

    private void addReservedSdpRecords(ArrayList arraylist) {
        this;
        JVM INSTR monitorenter ;
        int ai[] = new int[arraylist.size()];
        for(int i = 0; i < arraylist.size(); i++)
            ai[i] = BluetoothUuid.getServiceIdentifierFromParcelUuid((ParcelUuid)arraylist.get(i));

        mAdapterSdpHandles = addReservedServiceRecordsNative(ai);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private native int[] addReservedServiceRecordsNative(int ai[]);

    private native int addRfcommServiceRecordNative(String s, long l, long l1, short word0);

    private void autoConnect() {
        this;
        JVM INSTR monitorenter ;
        if(mAllowConnect)
            break MISSING_BLOCK_LABEL_23;
        Log.d("BluetoothService", "Not auto-connecting devices because of temporary BT on state.");
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_109;
        this;
        JVM INSTR monitorexit ;
        String as[] = getKnownDevices();
        if(as != null) {
            int i = as.length;
            for(int j = 0; j < i; j++) {
                String s = getAddressFromObjectPath(as[j]);
                BluetoothDeviceProfileState bluetoothdeviceprofilestate = (BluetoothDeviceProfileState)mDeviceProfileState.get(s);
                if(bluetoothdeviceprofilestate != null) {
                    Message message = new Message();
                    message.what = 101;
                    bluetoothdeviceprofilestate.sendMessage(message);
                }
            }

        }
        break MISSING_BLOCK_LABEL_109;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static int bluezStringToScanMode(boolean flag, boolean flag1) {
        byte byte0;
        if(flag && flag1)
            byte0 = 23;
        else
        if(flag && !flag1)
            byte0 = 21;
        else
            byte0 = 20;
        return byte0;
    }

    private native boolean cancelDeviceCreationNative(String s);

    private native boolean cancelPairingUserInputNative(String s, int i);

    /**
     * @deprecated Method checkAndRemoveRecord is deprecated
     */

    private void checkAndRemoveRecord(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        ServiceRecordClient servicerecordclient = (ServiceRecordClient)mServiceRecordToPid.get(Integer.valueOf(i));
        if(servicerecordclient != null && j == servicerecordclient.pid) {
            Log.d("BluetoothService", (new StringBuilder()).append("Removing service record ").append(Integer.toHexString(i)).append(" for pid ").append(j).toString());
            if(servicerecordclient.death != null)
                servicerecordclient.binder.unlinkToDeath(servicerecordclient.death, 0);
            mServiceRecordToPid.remove(Integer.valueOf(i));
            removeServiceRecordNative(i);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static native void classInitNative();

    private native void cleanupNativeDataNative();

    private ParcelUuid[] convertStringToParcelUuid(String s) {
        String as[] = s.split(",");
        ParcelUuid aparceluuid[] = new ParcelUuid[as.length];
        for(int i = 0; i < as.length; i++)
            aparceluuid[i] = ParcelUuid.fromString(as[i]);

        return aparceluuid;
    }

    private int convertToAdapterState(int i) {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 46
    //                   1 61
    //                   2 56
    //                   3 51;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte byte0;
        Log.e("BluetoothService", "Error in convertToAdapterState");
        byte0 = -1;
_L7:
        return byte0;
_L2:
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L5:
        byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 2;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private native boolean createDeviceNative(String s);

    private void createIncomingConnectionStateFile() {
        File file;
        file = new File("/data/misc/bluetooth/incoming_connection.conf");
        if(file.exists())
            break MISSING_BLOCK_LABEL_22;
        file.createNewFile();
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.e("BluetoothService", "IOException: cannot create file");
          goto _L1
    }

    private native boolean createPairedDeviceNative(String s, int i);

    private native boolean createPairedDeviceOutOfBandNative(String s, int i);

    private void dumpAclConnectedDevices(PrintWriter printwriter) {
        String as[] = getKnownDevices();
        printwriter.println("\n--ACL connected devices--");
        if(as != null) {
            int i = as.length;
            for(int j = 0; j < i; j++)
                printwriter.println(getAddressFromObjectPath(as[j]));

        }
    }

    private void dumpApplicationServiceRecords(PrintWriter printwriter) {
        printwriter.println("\n--Application Service Records--");
        Integer integer;
        Integer integer1;
        for(Iterator iterator = mServiceRecordToPid.keySet().iterator(); iterator.hasNext(); printwriter.println((new StringBuilder()).append("\tpid ").append(integer1).append(" handle ").append(Integer.toHexString(integer.intValue())).toString())) {
            integer = (Integer)iterator.next();
            integer1 = Integer.valueOf(((ServiceRecordClient)mServiceRecordToPid.get(integer)).pid);
        }

    }

    private void dumpHeadsetConnectionState(PrintWriter printwriter, BluetoothDevice bluetoothdevice) {
        mHeadsetProxy.getConnectionState(bluetoothdevice);
        JVM INSTR lookupswitch 4: default 52
    //                   1: 53
    //                   2: 63
    //                   3: 73
    //                   12: 83;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        printwriter.println("getConnectionState() = STATE_CONNECTING");
        continue; /* Loop/switch isn't completed */
_L3:
        printwriter.println("getConnectionState() = STATE_CONNECTED");
        continue; /* Loop/switch isn't completed */
_L4:
        printwriter.println("getConnectionState() = STATE_DISCONNECTING");
        continue; /* Loop/switch isn't completed */
_L5:
        printwriter.println("getConnectionState() = STATE_AUDIO_CONNECTED");
        if(true) goto _L1; else goto _L6
_L6:
    }

    private void dumpHeadsetService(PrintWriter printwriter) {
        printwriter.println("\n--Headset Service--");
        if(mHeadsetProxy != null) {
            List list = mHeadsetProxy.getConnectedDevices();
            BluetoothHeadset bluetoothheadset;
            int ai[];
            List list1;
            Iterator iterator;
            if(list.size() == 0) {
                printwriter.println("No headsets connected");
            } else {
                BluetoothDevice bluetoothdevice = (BluetoothDevice)list.get(0);
                printwriter.println((new StringBuilder()).append("\ngetConnectedDevices[0] = ").append(bluetoothdevice).toString());
                dumpHeadsetConnectionState(printwriter, bluetoothdevice);
                printwriter.println((new StringBuilder()).append("getBatteryUsageHint() = ").append(mHeadsetProxy.getBatteryUsageHint(bluetoothdevice)).toString());
            }
            list.clear();
            bluetoothheadset = mHeadsetProxy;
            ai = new int[2];
            ai[0] = 2;
            ai[1] = 0;
            list1 = bluetoothheadset.getDevicesMatchingConnectionStates(ai);
            printwriter.println("--Connected and Disconnected Headsets");
            iterator = list1.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                BluetoothDevice bluetoothdevice1 = (BluetoothDevice)iterator.next();
                printwriter.println(bluetoothdevice1);
                if(mHeadsetProxy.isAudioConnected(bluetoothdevice1))
                    printwriter.println((new StringBuilder()).append("SCO audio connected to device:").append(bluetoothdevice1).toString());
            } while(true);
        }
    }

    private void dumpInputDeviceProfile(PrintWriter printwriter) {
        printwriter.println("\n--Bluetooth Service- Input Device Profile");
        if(mInputDevice == null) goto _L2; else goto _L1
_L1:
        List list = mInputDevice.getConnectedDevices();
        if(list.size() != 0) goto _L4; else goto _L3
_L3:
        printwriter.println("No input devices connected");
_L5:
        list.clear();
        BluetoothInputDevice bluetoothinputdevice = mInputDevice;
        int ai[] = new int[2];
        ai[0] = 2;
        ai[1] = 0;
        List list1 = bluetoothinputdevice.getDevicesMatchingConnectionStates(ai);
        printwriter.println("--Connected and Disconnected input devices");
        for(Iterator iterator = list1.iterator(); iterator.hasNext(); printwriter.println((BluetoothDevice)iterator.next()));
        break; /* Loop/switch isn't completed */
_L4:
        printwriter.println((new StringBuilder()).append("Number of connected devices:").append(list.size()).toString());
        BluetoothDevice bluetoothdevice = (BluetoothDevice)list.get(0);
        printwriter.println((new StringBuilder()).append("getConnectedDevices[0] = ").append(bluetoothdevice).toString());
        printwriter.println((new StringBuilder()).append("Priority of Connected device = ").append(mInputDevice.getPriority(bluetoothdevice)).toString());
        switch(mInputDevice.getConnectionState(bluetoothdevice)) {
        case 1: // '\001'
            printwriter.println("getConnectionState() = STATE_CONNECTING");
            break;

        case 2: // '\002'
            printwriter.println("getConnectionState() = STATE_CONNECTED");
            break;

        case 3: // '\003'
            printwriter.println("getConnectionState() = STATE_DISCONNECTING");
            break;
        }
        if(true) goto _L5; else goto _L2
_L2:
    }

    private void dumpKnownDevices(PrintWriter printwriter) {
        printwriter.println("\n--Known devices--");
        for(Iterator iterator = mDeviceProperties.keySet().iterator(); iterator.hasNext();) {
            String s = (String)iterator.next();
            int i = mBondState.getBondState(s);
            Object aobj[] = new Object[4];
            aobj[0] = s;
            aobj[1] = toBondStateString(i);
            aobj[2] = Integer.valueOf(mBondState.getAttempt(s));
            aobj[3] = getRemoteName(s);
            printwriter.printf("%s %10s (%d) %s\n", aobj);
            Map map = (Map)mDeviceServiceChannelCache.get(s);
            Iterator iterator2;
            if(map == null) {
                printwriter.println("\tuuids = null");
            } else {
                Iterator iterator1 = map.keySet().iterator();
                while(iterator1.hasNext())  {
                    ParcelUuid parceluuid = (ParcelUuid)iterator1.next();
                    Integer integer = (Integer)map.get(parceluuid);
                    if(integer == null)
                        printwriter.println((new StringBuilder()).append("\t").append(parceluuid).toString());
                    else
                        printwriter.println((new StringBuilder()).append("\t").append(parceluuid).append(" RFCOMM channel = ").append(integer).toString());
                }
            }
            iterator2 = mUuidCallbackTracker.keySet().iterator();
            while(iterator2.hasNext())  {
                RemoteService remoteservice = (RemoteService)iterator2.next();
                if(remoteservice.address.equals(s))
                    printwriter.println((new StringBuilder()).append("\tPENDING CALLBACK: ").append(remoteservice.uuid).toString());
            }
        }

    }

    private void dumpPanProfile(PrintWriter printwriter) {
        printwriter.println("\n--Bluetooth Service- Pan Profile");
        if(mPan == null) goto _L2; else goto _L1
_L1:
        List list = mPan.getConnectedDevices();
        if(list.size() != 0) goto _L4; else goto _L3
_L3:
        printwriter.println("No Pan devices connected");
_L5:
        list.clear();
        BluetoothPan bluetoothpan = mPan;
        int ai[] = new int[2];
        ai[0] = 2;
        ai[1] = 0;
        List list1 = bluetoothpan.getDevicesMatchingConnectionStates(ai);
        printwriter.println("--Connected and Disconnected Pan devices");
        for(Iterator iterator = list1.iterator(); iterator.hasNext(); printwriter.println((BluetoothDevice)iterator.next()));
        break; /* Loop/switch isn't completed */
_L4:
        printwriter.println((new StringBuilder()).append("Number of connected devices:").append(list.size()).toString());
        BluetoothDevice bluetoothdevice = (BluetoothDevice)list.get(0);
        printwriter.println((new StringBuilder()).append("getConnectedDevices[0] = ").append(bluetoothdevice).toString());
        switch(mPan.getConnectionState(bluetoothdevice)) {
        case 1: // '\001'
            printwriter.println("getConnectionState() = STATE_CONNECTING");
            break;

        case 2: // '\002'
            printwriter.println("getConnectionState() = STATE_CONNECTED");
            break;

        case 3: // '\003'
            printwriter.println("getConnectionState() = STATE_DISCONNECTING");
            break;
        }
        if(true) goto _L5; else goto _L2
_L2:
    }

    private void dumpProfileState(PrintWriter printwriter) {
        printwriter.println("\n--Profile State dump--");
        printwriter.println((new StringBuilder()).append("\n Headset profile state:").append(mAdapter.getProfileConnectionState(1)).toString());
        printwriter.println((new StringBuilder()).append("\n A2dp profile state:").append(mAdapter.getProfileConnectionState(2)).toString());
        printwriter.println((new StringBuilder()).append("\n HID profile state:").append(mAdapter.getProfileConnectionState(4)).toString());
        printwriter.println((new StringBuilder()).append("\n PAN profile state:").append(mAdapter.getProfileConnectionState(5)).toString());
    }

    private native Object[] getDevicePropertiesNative(String s);

    pr