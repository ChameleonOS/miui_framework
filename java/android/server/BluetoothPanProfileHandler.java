// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothTetheringDataTracker;
import android.content.*;
import android.content.res.Resources;
import android.net.*;
import android.os.INetworkManagementService;
import android.os.ServiceManager;
import android.util.Log;
import java.net.InetAddress;
import java.util.*;

// Referenced classes of package android.server:
//            BluetoothService

final class BluetoothPanProfileHandler {
    private class BluetoothPanDevice {

        private String mIface;
        private String mIfaceAddr;
        private int mLocalRole;
        private int mState;
        final BluetoothPanProfileHandler this$0;



/*
        static int access$302(BluetoothPanDevice bluetoothpandevice, int i) {
            bluetoothpandevice.mState = i;
            return i;
        }

*/



/*
        static int access$402(BluetoothPanDevice bluetoothpandevice, int i) {
            bluetoothpandevice.mLocalRole = i;
            return i;
        }

*/



/*
        static String access$502(BluetoothPanDevice bluetoothpandevice, String s) {
            bluetoothpandevice.mIface = s;
            return s;
        }

*/



/*
        static String access$602(BluetoothPanDevice bluetoothpandevice, String s) {
            bluetoothpandevice.mIfaceAddr = s;
            return s;
        }

*/

        BluetoothPanDevice(int i, String s, String s1, int j) {
            this$0 = BluetoothPanProfileHandler.this;
            super();
            mState = i;
            mIfaceAddr = s;
            mIface = s1;
            mLocalRole = j;
        }
    }


    private BluetoothPanProfileHandler(Context context, BluetoothService bluetoothservice) {
        mTetheringReceiver = null;
        mContext = context;
        mPanDevices = new HashMap();
        mBluetoothService = bluetoothservice;
        mTetheringOn = false;
        mBluetoothIfaceAddresses = new ArrayList();
        mMaxPanDevices = context.getResources().getInteger(0x10e000a);
_L1:
        return;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        mMaxPanDevices = 5;
          goto _L1
    }

    private String createNewTetheringAddressLocked() {
        String s;
        if(getConnectedPanDevices().size() == mMaxPanDevices) {
            debugLog("Max PAN device connections reached");
            s = null;
        } else {
            String as[];
            Integer integer;
            for(s = "192.168.44.1"; mBluetoothIfaceAddresses.contains(s); s = s.replace(as[2], integer.toString())) {
                as = s.split("\\.");
                integer = Integer.valueOf(1 + Integer.parseInt(as[2]));
            }

            mBluetoothIfaceAddresses.add(s);
        }
        return s;
    }

    private static void debugLog(String s) {
        Log.d("BluetoothPanProfileHandler", s);
    }

    private boolean disconnectPanServerDevices() {
        boolean flag = true;
        debugLog("disconnect all PAN devices");
        Iterator iterator = mPanDevices.keySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            BluetoothDevice bluetoothdevice = (BluetoothDevice)iterator.next();
            BluetoothPanDevice bluetoothpandevice = (BluetoothPanDevice)mPanDevices.get(bluetoothdevice);
            int i = bluetoothpandevice.mState;
            if(i != 2 || bluetoothpandevice.mLocalRole != flag)
                continue;
            String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
            handlePanDeviceStateChange(bluetoothdevice, bluetoothpandevice.mIface, 3, bluetoothpandevice.mLocalRole);
            if(mBluetoothService.disconnectPanServerDeviceNative(s, bluetoothdevice.getAddress(), bluetoothpandevice.mIface))
                continue;
            errorLog((new StringBuilder()).append("could not disconnect Pan Server Device ").append(bluetoothdevice.getAddress()).toString());
            handlePanDeviceStateChange(bluetoothdevice, bluetoothpandevice.mIface, i, bluetoothpandevice.mLocalRole);
            flag = false;
            break;
        } while(true);
        return flag;
    }

    private String enableTethering(String s) {
        INetworkManagementService inetworkmanagementservice;
        ConnectivityManager connectivitymanager;
        String s1;
        int j;
        debugLog((new StringBuilder()).append("updateTetherState:").append(s).toString());
        inetworkmanagementservice = android.os.INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        connectivitymanager = (ConnectivityManager)mContext.getSystemService("connectivity");
        connectivitymanager.getTetherableBluetoothRegexs();
        new String[0];
        String as[];
        boolean flag;
        int i;
        try {
            as = inetworkmanagementservice.listInterfaces();
        }
        catch(Exception exception) {
            Log.e("BluetoothPanProfileHandler", (new StringBuilder()).append("Error listing Interfaces :").append(exception).toString());
            s1 = null;
            break MISSING_BLOCK_LABEL_103;
        }
        flag = false;
        i = as.length;
        j = 0;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        if(!as[j].equals(s)) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        if(!flag) {
            s1 = null;
        } else {
label0:
            {
                s1 = createNewTetheringAddressLocked();
                if(s1 != null)
                    break label0;
                s1 = null;
            }
        }
_L7:
        return s1;
_L4:
        j++;
          goto _L5
        InterfaceConfiguration interfaceconfiguration = inetworkmanagementservice.getInterfaceConfig(s);
        if(interfaceconfiguration == null) goto _L7; else goto _L6
_L6:
        InetAddress inetaddress;
        LinkAddress linkaddress = interfaceconfiguration.getLinkAddress();
        if(linkaddress != null) {
            inetaddress = linkaddress.getAddress();
            if(inetaddress != null && !inetaddress.equals(NetworkUtils.numericToInetAddress("0.0.0.0")) && !inetaddress.equals(NetworkUtils.numericToInetAddress("::0")))
                break MISSING_BLOCK_LABEL_237;
        }
        inetaddress = NetworkUtils.numericToInetAddress(s1);
        interfaceconfiguration.setInterfaceUp();
        interfaceconfiguration.clearFlag("running");
        LinkAddress linkaddress1 = new LinkAddress(inetaddress, 24);
        interfaceconfiguration.setLinkAddress(linkaddress1);
        inetworkmanagementservice.setInterfaceConfig(s, interfaceconfiguration);
        if(connectivitymanager.tether(s) != 0)
            Log.e("BluetoothPanProfileHandler", (new StringBuilder()).append("Error tethering ").append(s).toString());
          goto _L7
        Exception exception1;
        exception1;
        Log.e("BluetoothPanProfileHandler", (new StringBuilder()).append("Error configuring interface ").append(s).append(", :").append(exception1).toString());
        s1 = null;
          goto _L7
    }

    private static void errorLog(String s) {
        Log.e("BluetoothPanProfileHandler", s);
    }

    static BluetoothPanProfileHandler getInstance(Context context, BluetoothService bluetoothservice) {
        if(sInstance == null)
            sInstance = new BluetoothPanProfileHandler(context, bluetoothservice);
        return sInstance;
    }

    boolean allowIncomingTethering() {
        boolean flag;
        if(isTetheringOn() && getConnectedPanDevices().size() < mMaxPanDevices)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean connectPanDevice(BluetoothDevice bluetoothdevice) {
        boolean flag = false;
        String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        Log.d("BluetoothPanProfileHandler", (new StringBuilder()).append("connect PAN(").append(s).append(")").toString());
        if(getPanDeviceConnectionState(bluetoothdevice) != 0)
            errorLog((new StringBuilder()).append(bluetoothdevice).append(" already connected to PAN").toString());
        int i = 0;
        Iterator iterator = mPanDevices.keySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            if(getPanDeviceConnectionState((BluetoothDevice)iterator.next()) == 2)
                i++;
        } while(true);
        if(i > 8) {
            debugLog((new StringBuilder()).append(bluetoothdevice).append(" could not connect to PAN because 8 other devices are").append("already connected").toString());
        } else {
            handlePanDeviceStateChange(bluetoothdevice, null, 1, 2);
            if(mBluetoothService.connectPanDeviceNative(s, "nap")) {
                debugLog("connecting to PAN");
                flag = true;
            } else {
                handlePanDeviceStateChange(bluetoothdevice, null, 0, 2);
                errorLog("could not connect to PAN");
            }
        }
        return flag;
    }

    boolean disconnectPanDevice(BluetoothDevice bluetoothdevice) {
        boolean flag;
        String s;
        int i;
        flag = false;
        s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        debugLog((new StringBuilder()).append("disconnect PAN(").append(s).append(")").toString());
        i = getPanDeviceConnectionState(bluetoothdevice);
        if(i == 2) goto _L2; else goto _L1
_L1:
        debugLog((new StringBuilder()).append(bluetoothdevice).append(" already disconnected from PAN").toString());
_L4:
        return flag;
_L2:
        BluetoothPanDevice bluetoothpandevice = (BluetoothPanDevice)mPanDevices.get(bluetoothdevice);
        if(bluetoothpandevice == null) {
            errorLog((new StringBuilder()).append("No record for this Pan device:").append(bluetoothdevice).toString());
            continue; /* Loop/switch isn't completed */
        }
        handlePanDeviceStateChange(bluetoothdevice, bluetoothpandevice.mIface, 3, bluetoothpandevice.mLocalRole);
        if(bluetoothpandevice.mLocalRole == 1) {
            if(!mBluetoothService.disconnectPanServerDeviceNative(s, bluetoothdevice.getAddress(), bluetoothpandevice.mIface)) {
                handlePanDeviceStateChange(bluetoothdevice, bluetoothpandevice.mIface, i, bluetoothpandevice.mLocalRole);
                continue; /* Loop/switch isn't completed */
            }
        } else
        if(!mBluetoothService.disconnectPanDeviceNative(s)) {
            handlePanDeviceStateChange(bluetoothdevice, bluetoothpandevice.mIface, i, bluetoothpandevice.mLocalRole);
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    List getConnectedPanDevices() {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mPanDevices.keySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            BluetoothDevice bluetoothdevice = (BluetoothDevice)iterator.next();
            if(getPanDeviceConnectionState(bluetoothdevice) == 2)
                arraylist.add(bluetoothdevice);
        } while(true);
        return arraylist;
    }

    int getPanDeviceConnectionState(BluetoothDevice bluetoothdevice) {
        BluetoothPanDevice bluetoothpandevice = (BluetoothPanDevice)mPanDevices.get(bluetoothdevice);
        int i;
        if(bluetoothpandevice == null)
            i = 0;
        else
            i = bluetoothpandevice.mState;
        return i;
    }

    List getPanDevicesMatchingConnectionStates(int ai[]) {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mPanDevices.keySet().iterator();
label0:
        do {
            if(iterator.hasNext()) {
                BluetoothDevice bluetoothdevice = (BluetoothDevice)iterator.next();
                int i = getPanDeviceConnectionState(bluetoothdevice);
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

    void handlePanDeviceStateChange(BluetoothDevice bluetoothdevice, String s, int i, int j) {
        String s1;
        BluetoothPanDevice bluetoothpandevice;
        int k;
        s1 = null;
        bluetoothpandevice = (BluetoothPanDevice)mPanDevices.get(bluetoothdevice);
        if(bluetoothpandevice == null) {
            k = 0;
        } else {
            k = bluetoothpandevice.mState;
            s1 = bluetoothpandevice.mIfaceAddr;
        }
        if(k != i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(j != 1) goto _L4; else goto _L3
_L3:
        Intent intent;
        if(i == 2) {
            s1 = enableTethering(s);
            if(s1 == null)
                Log.e("BluetoothPanProfileHandler", "Error seting up tether interface");
        } else
        if(i == 0 && s1 != null) {
            mBluetoothIfaceAddresses.remove(s1);
            s1 = null;
        }
_L5:
        if(bluetoothpandevice == null) {
            BluetoothPanDevice bluetoothpandevice1 = new BluetoothPanDevice(i, s1, s, j);
            mPanDevices.put(bluetoothdevice, bluetoothpandevice1);
        } else {
            bluetoothpandevice.mState = i;
            bluetoothpandevice.mIfaceAddr = s1;
            bluetoothpandevice.mLocalRole = j;
            bluetoothpandevice.mIface = s;
        }
        intent = new Intent("android.bluetooth.pan.profile.action.CONNECTION_STATE_CHANGED");
        intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothdevice);
        intent.putExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", k);
        intent.putExtra("android.bluetooth.profile.extra.STATE", i);
        intent.putExtra("android.bluetooth.pan.extra.LOCAL_ROLE", j);
        mContext.sendBroadcast(intent, "android.permission.BLUETOOTH");
        debugLog((new StringBuilder()).append("Pan Device state : device: ").append(bluetoothdevice).append(" State:").append(k).append("->").append(i).toString());
        mBluetoothService.sendConnectionStateChange(bluetoothdevice, 5, i, k);
        if(true) goto _L1; else goto _L4
_L4:
        if(i == 2)
            BluetoothTetheringDataTracker.getInstance().startReverseTether(s, bluetoothdevice);
        else
        if(i == 0 && (k == 2 || k == 3))
            BluetoothTetheringDataTracker.getInstance().stopReverseTether(bluetoothpandevice.mIface);
          goto _L5
    }

    boolean isTetheringOn() {
        return mTetheringOn;
    }

    void setBluetoothTethering(boolean flag) {
        if(!flag)
            disconnectPanServerDevices();
        if(mBluetoothService.getBluetoothState() != 12 && flag) {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            mTetheringReceiver = new BroadcastReceiver() {

                public void onReceive(Context context, Intent intent) {
                    if(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 12) {
                        mTetheringOn = true;
                        mContext.unregisterReceiver(mTetheringReceiver);
                    }
                }

                final BluetoothPanProfileHandler this$0;

             {
                this$0 = BluetoothPanProfileHandler.this;
                super();
            }
            };
            mContext.registerReceiver(mTetheringReceiver, intentfilter);
        } else {
            mTetheringOn = flag;
        }
    }

    private static final String BLUETOOTH_IFACE_ADDR_START = "192.168.44.1";
    private static final int BLUETOOTH_MAX_PAN_CONNECTIONS = 5;
    private static final int BLUETOOTH_PREFIX_LENGTH = 24;
    private static final boolean DBG = true;
    static final String NAP_BRIDGE = "pan1";
    static final String NAP_ROLE = "nap";
    private static final String TAG = "BluetoothPanProfileHandler";
    public static BluetoothPanProfileHandler sInstance;
    private ArrayList mBluetoothIfaceAddresses;
    private BluetoothService mBluetoothService;
    private Context mContext;
    private int mMaxPanDevices;
    private final HashMap mPanDevices;
    private boolean mTetheringOn;
    private BroadcastReceiver mTetheringReceiver;


/*
    static boolean access$002(BluetoothPanProfileHandler bluetoothpanprofilehandler, boolean flag) {
        bluetoothpanprofilehandler.mTetheringOn = flag;
        return flag;
    }

*/


}
