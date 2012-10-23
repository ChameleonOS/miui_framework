// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.bluetooth.*;
import android.content.Context;
import android.os.*;
import android.util.Log;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.server:
//            BluetoothService

final class BluetoothHealthProfileHandler {
    class HealthChannel {

        private ParcelFileDescriptor mChannelFd;
        private String mChannelPath;
        private int mChannelType;
        private BluetoothHealthAppConfiguration mConfig;
        private BluetoothDevice mDevice;
        private int mId;
        private boolean mMainChannel;
        private int mState;
        final BluetoothHealthProfileHandler this$0;





/*
        static int access$1202(HealthChannel healthchannel, int i) {
            healthchannel.mChannelType = i;
            return i;
        }

*/



/*
        static boolean access$1402(HealthChannel healthchannel, boolean flag) {
            healthchannel.mMainChannel = flag;
            return flag;
        }

*/



/*
        static String access$1502(HealthChannel healthchannel, String s) {
            healthchannel.mChannelPath = s;
            return s;
        }

*/



/*
        static ParcelFileDescriptor access$1602(HealthChannel healthchannel, ParcelFileDescriptor parcelfiledescriptor) {
            healthchannel.mChannelFd = parcelfiledescriptor;
            return parcelfiledescriptor;
        }

*/




/*
        static int access$902(HealthChannel healthchannel, int i) {
            healthchannel.mState = i;
            return i;
        }

*/

        HealthChannel(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, ParcelFileDescriptor parcelfiledescriptor, boolean flag, String s) {
            this$0 = BluetoothHealthProfileHandler.this;
            super();
            mChannelFd = parcelfiledescriptor;
            mMainChannel = flag;
            mChannelPath = s;
            mDevice = bluetoothdevice;
            mConfig = bluetoothhealthappconfiguration;
            mState = 0;
            mId = getChannelId();
        }
    }


    private BluetoothHealthProfileHandler(Context context, BluetoothService bluetoothservice) {
        mBluetoothService = bluetoothservice;
        mHealthAppConfigs = new HashMap();
        mHealthChannels = new ArrayList();
        mHealthDevices = new HashMap();
        mCallbacks = new HashMap();
    }

    private void broadcastHealthDeviceStateChange(BluetoothDevice bluetoothdevice, int i, int j) {
        int k;
        int l;
        if(mHealthDevices.get(bluetoothdevice) == null)
            mHealthDevices.put(bluetoothdevice, Integer.valueOf(0));
        k = ((Integer)mHealthDevices.get(bluetoothdevice)).intValue();
        l = convertState(j);
        if(k == l) goto _L2; else goto _L1
_L1:
        k;
        JVM INSTR tableswitch 0 3: default 88
    //                   0 89
    //                   1 101
    //                   2 161
    //                   3 203;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        return;
_L3:
        updateAndSendIntent(bluetoothdevice, k, l);
        continue; /* Loop/switch isn't completed */
_L4:
        if(l == 2) {
            updateAndSendIntent(bluetoothdevice, k, l);
        } else {
            int ai2[] = new int[2];
            ai2[0] = 1;
            ai2[1] = 3;
            if(findChannelByStates(bluetoothdevice, ai2).isEmpty())
                updateAndSendIntent(bluetoothdevice, k, l);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        int ai1[] = new int[2];
        ai1[0] = 1;
        ai1[1] = 2;
        if(findChannelByStates(bluetoothdevice, ai1).isEmpty())
            updateAndSendIntent(bluetoothdevice, k, l);
        continue; /* Loop/switch isn't completed */
_L6:
        int ai[] = new int[2];
        ai[0] = 1;
        ai[1] = 3;
        if(findChannelByStates(bluetoothdevice, ai).isEmpty())
            updateAndSendIntent(bluetoothdevice, k, l);
        if(true) goto _L2; else goto _L7
_L7:
    }

    private void callHealthApplicationStatusCallback(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) {
        IBluetoothHealthCallback ibluetoothhealthcallback;
        debugLog((new StringBuilder()).append("Health Device Application: ").append(bluetoothhealthappconfiguration).append(" State Change: status:").append(i).toString());
        ibluetoothhealthcallback = (IBluetoothHealthCallback)mCallbacks.get(bluetoothhealthappconfiguration);
        if(ibluetoothhealthcallback == null)
            break MISSING_BLOCK_LABEL_55;
        ibluetoothhealthcallback.onHealthAppConfigurationStatusChange(bluetoothhealthappconfiguration, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        errorLog((new StringBuilder()).append("Remote Exception:").append(remoteexception).toString());
          goto _L1
    }

    private void callHealthChannelCallback(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, BluetoothDevice bluetoothdevice, int i, int j, ParcelFileDescriptor parcelfiledescriptor, int k) {
        ParcelFileDescriptor parcelfiledescriptor1;
        broadcastHealthDeviceStateChange(bluetoothdevice, i, j);
        debugLog((new StringBuilder()).append("Health Device Callback: ").append(bluetoothdevice).append(" State Change: ").append(i).append("->").append(j).toString());
        parcelfiledescriptor1 = null;
        if(parcelfiledescriptor == null)
            break MISSING_BLOCK_LABEL_68;
        ParcelFileDescriptor parcelfiledescriptor2 = parcelfiledescriptor.dup();
        parcelfiledescriptor1 = parcelfiledescriptor2;
_L1:
        IBluetoothHealthCallback ibluetoothhealthcallback;
        ibluetoothhealthcallback = (IBluetoothHealthCallback)mCallbacks.get(bluetoothhealthappconfiguration);
        if(ibluetoothhealthcallback == null)
            break MISSING_BLOCK_LABEL_102;
        ibluetoothhealthcallback.onHealthChannelStateChange(bluetoothhealthappconfiguration, bluetoothdevice, i, j, parcelfiledescriptor1, k);
_L2:
        return;
        IOException ioexception;
        ioexception;
        parcelfiledescriptor1 = null;
        errorLog((new StringBuilder()).append("Exception while duping: ").append(ioexception).toString());
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        errorLog((new StringBuilder()).append("Remote Exception:").append(remoteexception).toString());
          goto _L2
    }

    private int convertState(int i) {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 57
    //                   1 47
    //                   2 42
    //                   3 52;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte byte0;
        errorLog("Mismatch in Channel and Health Device State");
        byte0 = -1;
_L7:
        return byte0;
_L4:
        byte0 = 2;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L5:
        byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L2:
        byte0 = 0;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static void debugLog(String s) {
    }

    private static void errorLog(String s) {
        Log.e("BluetoothHealthProfileHandler", s);
    }

    private HealthChannel findChannelById(int i) {
        Iterator iterator = mHealthChannels.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        HealthChannel healthchannel = (HealthChannel)iterator.next();
        if(healthchannel.mId != i) goto _L4; else goto _L3
_L3:
        return healthchannel;
_L2:
        healthchannel = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private HealthChannel findChannelByPath(BluetoothDevice bluetoothdevice, String s) {
        Iterator iterator = mHealthChannels.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        HealthChannel healthchannel = (HealthChannel)iterator.next();
        if(!s.equals(healthchannel.mChannelPath) || !bluetoothdevice.equals(healthchannel.mDevice)) goto _L4; else goto _L3
_L3:
        return healthchannel;
_L2:
        healthchannel = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private List findChannelByStates(BluetoothDevice bluetoothdevice, int ai[]) {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mHealthChannels.iterator();
        do {
            if(!iterator.hasNext())
                break;
            HealthChannel healthchannel = (HealthChannel)iterator.next();
            if(healthchannel.mDevice.equals(bluetoothdevice)) {
                int i = ai.length;
                int j = 0;
                while(j < i)  {
                    int k = ai[j];
                    if(healthchannel.mState == k)
                        arraylist.add(healthchannel);
                    j++;
                }
            }
        } while(true);
        return arraylist;
    }

    private HealthChannel findConnectingChannel(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) {
        Iterator iterator = mHealthChannels.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        HealthChannel healthchannel = (HealthChannel)iterator.next();
        if(!healthchannel.mDevice.equals(bluetoothdevice) || !healthchannel.mConfig.equals(bluetoothhealthappconfiguration) || healthchannel.mState != 1) goto _L4; else goto _L3
_L3:
        return healthchannel;
_L2:
        healthchannel = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private BluetoothHealthAppConfiguration findHealthApplication(BluetoothDevice bluetoothdevice, String s) {
        BluetoothHealthAppConfiguration bluetoothhealthappconfiguration;
        HealthChannel healthchannel;
        bluetoothhealthappconfiguration = null;
        healthchannel = findChannelByPath(bluetoothdevice, s);
        if(healthchannel == null) goto _L2; else goto _L1
_L1:
        bluetoothhealthappconfiguration = healthchannel.mConfig;
_L4:
        return bluetoothhealthappconfiguration;
_L2:
        String s1 = mBluetoothService.getChannelApplicationNative(s);
        if(s1 == null) {
            errorLog("Config path is null for application");
        } else {
            Iterator iterator = mHealthAppConfigs.entrySet().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if(((String)entry.getValue()).equals(s1))
                    bluetoothhealthappconfiguration = (BluetoothHealthAppConfiguration)entry.getKey();
            } while(true);
            if(bluetoothhealthappconfiguration == null)
                errorLog((new StringBuilder()).append("No associated application for path:").append(s1).toString());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int getChannelId() {
        int i;
        boolean flag;
        do {
            i = sChannelId.incrementAndGet();
            flag = false;
            Iterator iterator = mHealthChannels.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                if(((HealthChannel)iterator.next()).mId == i)
                    flag = true;
            } while(true);
        } while(flag);
        return i;
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    static BluetoothHealthProfileHandler getInstance(Context context, BluetoothService bluetoothservice) {
        android/server/BluetoothHealthProfileHandler;
        JVM INSTR monitorenter ;
        BluetoothHealthProfileHandler bluetoothhealthprofilehandler;
        if(sInstance == null)
            sInstance = new BluetoothHealthProfileHandler(context, bluetoothservice);
        bluetoothhealthprofilehandler = sInstance;
        android/server/BluetoothHealthProfileHandler;
        JVM INSTR monitorexit ;
        return bluetoothhealthprofilehandler;
        Exception exception;
        exception;
        throw exception;
    }

    private HealthChannel getMainChannel(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) {
        Iterator iterator = mHealthChannels.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        HealthChannel healthchannel = (HealthChannel)iterator.next();
        if(!healthchannel.mDevice.equals(bluetoothdevice) || !healthchannel.mConfig.equals(bluetoothhealthappconfiguration) || !healthchannel.mMainChannel) goto _L4; else goto _L3
_L3:
        return healthchannel;
_L2:
        healthchannel = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private String getStringChannelType(int i) {
        String s;
        if(i == 10)
            s = "Reliable";
        else
        if(i == 11)
            s = "Streaming";
        else
            s = "Any";
        return s;
    }

    private String getStringRole(int i) {
        String s;
        if(i == 2)
            s = "Sink";
        else
        if(i == 1)
            s = "Streaming";
        else
            s = null;
        return s;
    }

    private void updateAndSendIntent(BluetoothDevice bluetoothdevice, int i, int j) {
        mHealthDevices.put(bluetoothdevice, Integer.valueOf(j));
        mBluetoothService.sendConnectionStateChange(bluetoothdevice, 3, j, i);
    }

    boolean connectChannel(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) {
        boolean flag;
        if(mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress()) == null)
            flag = false;
        else
        if((String)mHealthAppConfigs.get(bluetoothhealthappconfiguration) == null) {
            flag = false;
        } else {
            HealthChannel healthchannel = new HealthChannel(bluetoothdevice, bluetoothhealthappconfiguration, null, false, null);
            healthchannel.mState = 1;
            healthchannel.mChannelType = i;
            mHealthChannels.add(healthchannel);
            callHealthChannelCallback(bluetoothhealthappconfiguration, bluetoothdevice, 0, 1, null, healthchannel.mId);
            Message message = mHandler.obtainMessage(2);
            message.obj = healthchannel;
            mHandler.sendMessage(message);
            flag = true;
        }
        return flag;
    }

    boolean connectChannelToSource(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) {
        return connectChannel(bluetoothdevice, bluetoothhealthappconfiguration, 12);
    }

    boolean disconnectChannel(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) {
        HealthChannel healthchannel = findChannelById(i);
        boolean flag;
        if(healthchannel == null) {
            flag = false;
        } else {
            String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
            mBluetoothService.releaseChannelFdNative(healthchannel.mChannelPath);
            int j = healthchannel.mState;
            healthchannel.mState = 3;
            callHealthChannelCallback(bluetoothhealthappconfiguration, bluetoothdevice, j, healthchannel.mState, null, healthchannel.mId);
            if(!mBluetoothService.destroyChannelNative(s, healthchannel.mChannelPath, healthchannel.mId)) {
                int k = healthchannel.mState;
                healthchannel.mState = 2;
                callHealthChannelCallback(bluetoothhealthappconfiguration, bluetoothdevice, k, healthchannel.mState, healthchannel.mChannelFd, healthchannel.mId);
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    List getConnectedHealthDevices() {
        int ai[] = new int[1];
        ai[0] = 2;
        return lookupHealthDevicesMatchingStates(ai);
    }

    int getHealthDeviceConnectionState(BluetoothDevice bluetoothdevice) {
        int i;
        if(mHealthDevices.get(bluetoothdevice) == null)
            i = 0;
        else
            i = ((Integer)mHealthDevices.get(bluetoothdevice)).intValue();
        return i;
    }

    List getHealthDevicesMatchingConnectionStates(int ai[]) {
        return lookupHealthDevicesMatchingStates(ai);
    }

    ParcelFileDescriptor getMainChannelFd(BluetoothDevice bluetoothdevice, BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) {
        HealthChannel healthchannel = getMainChannel(bluetoothdevice, bluetoothhealthappconfiguration);
        if(healthchannel == null) goto _L2; else goto _L1
_L1:
        ParcelFileDescriptor parcelfiledescriptor;
        ParcelFileDescriptor parcelfiledescriptor2;
        try {
            parcelfiledescriptor2 = healthchannel.mChannelFd.dup();
        }
        catch(IOException ioexception1) {
            parcelfiledescriptor = null;
            continue; /* Loop/switch isn't completed */
        }
        parcelfiledescriptor = parcelfiledescriptor2;
_L4:
        return parcelfiledescriptor;
_L2:
        HealthChannel healthchannel1;
        String s = mBluetoothService.getObjectPathFromAddress(bluetoothdevice.getAddress());
        if(s == null) {
            parcelfiledescriptor = null;
            continue; /* Loop/switch isn't completed */
        }
        String s1 = mBluetoothService.getMainChannelNative(s);
        if(s1 == null) {
            parcelfiledescriptor = null;
            continue; /* Loop/switch isn't completed */
        }
        healthchannel1 = findChannelByPath(bluetoothdevice, s1);
        if(healthchannel1 == null) {
            errorLog((new StringBuilder()).append("Main Channel present but we don't have any account of it:").append(bluetoothdevice).append(":").append(bluetoothhealthappconfiguration).toString());
            parcelfiledescriptor = null;
            continue; /* Loop/switch isn't completed */
        }
        healthchannel1.mMainChannel = true;
        ParcelFileDescriptor parcelfiledescriptor1 = healthchannel1.mChannelFd.dup();
        parcelfiledescriptor = parcelfiledescriptor1;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        parcelfiledescriptor = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    List lookupHealthDevicesMatchingStates(int ai[]) {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mHealthDevices.keySet().iterator();
label0:
        do {
            if(iterator.hasNext()) {
                BluetoothDevice bluetoothdevice = (BluetoothDevice)iterator.next();
                int i = getHealthDeviceConnectionState(bluetoothdevice);
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

    void onHealthDeviceChannelChanged(String s, String s1, boolean flag) {
        HealthChannel healthchannel;
        debugLog((new StringBuilder()).append("onHealthDeviceChannelChanged: devicePath: ").append(s).append("ChannelPath: ").append(s1).append("Exists: ").append(flag).toString());
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        String s2 = mBluetoothService.getAddressFromObjectPath(s);
        if(s2 != null) {
            BluetoothDevice bluetoothdevice = bluetoothadapter.getRemoteDevice(s2);
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration = findHealthApplication(bluetoothdevice, s1);
            ParcelFileDescriptor parcelfiledescriptor;
            boolean flag1;
            String s3;
            if(flag) {
                healthchannel = findConnectingChannel(bluetoothdevice, bluetoothhealthappconfiguration);
                if(healthchannel == null) {
                    healthchannel = new HealthChannel(bluetoothdevice, bluetoothhealthappconfiguration, null, false, s1);
                    healthchannel.mState = 0;
                    mHealthChannels.add(healthchannel);
                }
                healthchannel.mChannelPath = s1;
                parcelfiledescriptor = mBluetoothService.getChannelFdNative(s1);
                if(parcelfiledescriptor == null) {
                    errorLog((new StringBuilder()).append("Error obtaining fd for channel:").append(s1).toString());
                    disconnectChannel(bluetoothdevice, bluetoothhealthappconfiguration, healthchannel.mId);
                } else {
label0:
                    {
                        if(getMainChannel(bluetoothdevice, bluetoothhealthappconfiguration) == null)
                            flag1 = false;
                        else
                            flag1 = true;
                        if(flag1)
                            break MISSING_BLOCK_LABEL_275;
                        s3 = mBluetoothService.getMainChannelNative(s);
                        if(s3 != null)
                            break label0;
                        errorLog((new StringBuilder()).append("Main Channel Path is null for devicePath:").append(s).toString());
                    }
                }
            } else {
label1:
                {
                    healthchannel = findChannelByPath(bluetoothdevice, s1);
                    if(healthchannel != null)
                        break label1;
                    errorLog((new StringBuilder()).append("Channel not found:").append(bluetoothhealthappconfiguration).append(":").append(s1).toString());
                }
            }
        }
_L2:
        return;
        if(s3.equals(s1))
            flag1 = true;
        healthchannel.mChannelFd = parcelfiledescriptor;
        healthchannel.mMainChannel = flag1;
        int i = healthchannel.mState;
        byte byte0 = 2;
        do {
            healthchannel.mState = byte0;
            callHealthChannelCallback(bluetoothhealthappconfiguration, bluetoothdevice, i, byte0, healthchannel.mChannelFd, healthchannel.mId);
            if(true)
                break MISSING_BLOCK_LABEL_63;
            mHealthChannels.remove(healthchannel);
            healthchannel.mChannelFd = null;
            i = healthchannel.mState;
            byte0 = 0;
        } while(true);
        if(true) goto _L2; else goto _L1
_L1:
    }

    void onHealthDeviceChannelConnectionError(int i, int j) {
        HealthChannel healthchannel = findChannelById(i);
        if(healthchannel == null)
            errorLog((new StringBuilder()).append("No record of this channel:").append(i).toString());
        callHealthChannelCallback(healthchannel.mConfig, healthchannel.mDevice, healthchannel.mState, j, null, i);
    }

    void onHealthDevicePropertyChanged(String s, String s1) {
        BluetoothAdapter bluetoothadapter;
        String s2;
        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        s2 = mBluetoothService.getAddressFromObjectPath(s);
        break MISSING_BLOCK_LABEL_14;
        while(true)  {
            do
                return;
            while(s2 == null || s1.equals("/"));
            BluetoothDevice bluetoothdevice = bluetoothadapter.getRemoteDevice(s2);
            if(findHealthApplication(bluetoothdevice, s1) != null) {
                HealthChannel healthchannel = findChannelByPath(bluetoothdevice, s1);
                if(healthchannel == null)
                    errorLog((new StringBuilder()).append("Health Channel is not present:").append(s1).toString());
                else
                    healthchannel.mMainChannel = true;
            }
        }
    }

    boolean registerAppConfiguration(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, IBluetoothHealthCallback ibluetoothhealthcallback) {
        Message message = mHandler.obtainMessage(0);
        message.obj = bluetoothhealthappconfiguration;
        mHandler.sendMessage(message);
        mCallbacks.put(bluetoothhealthappconfiguration, ibluetoothhealthcallback);
        return true;
    }

    boolean unregisterAppConfiguration(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration) {
        boolean flag = true;
        if((String)mHealthAppConfigs.get(bluetoothhealthappconfiguration) == null) {
            flag = false;
        } else {
            Message message = mHandler.obtainMessage(flag);
            message.obj = bluetoothhealthappconfiguration;
            mHandler.sendMessage(message);
        }
        return flag;
    }

    private static final boolean DBG = false;
    private static final int MESSAGE_CONNECT_CHANNEL = 2;
    private static final int MESSAGE_REGISTER_APPLICATION = 0;
    private static final int MESSAGE_UNREGISTER_APPLICATION = 1;
    private static final String TAG = "BluetoothHealthProfileHandler";
    private static final AtomicInteger sChannelId = new AtomicInteger();
    private static BluetoothHealthProfileHandler sInstance;
    private BluetoothService mBluetoothService;
    private HashMap mCallbacks;
    private final Handler mHandler = new Handler() {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 0 2: default 32
        //                       0 33
        //                       1 191
        //                       2 358;
               goto _L1 _L2 _L3 _L4
_L1:
            return;
_L2:
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration1 = (BluetoothHealthAppConfiguration)message.obj;
            int j = bluetoothhealthappconfiguration1.getRole();
            String s3;
            if(j == 2)
                s3 = mBluetoothService.registerHealthApplicationNative(bluetoothhealthappconfiguration1.getDataType(), getStringRole(j), bluetoothhealthappconfiguration1.getName());
            else
                s3 = mBluetoothService.registerHealthApplicationNative(bluetoothhealthappconfiguration1.getDataType(), getStringRole(j), bluetoothhealthappconfiguration1.getName(), getStringChannelType(bluetoothhealthappconfiguration1.getChannelType()));
            if(s3 == null) {
                callHealthApplicationStatusCallback(bluetoothhealthappconfiguration1, 1);
                mCallbacks.remove(bluetoothhealthappconfiguration1);
            } else {
                mHealthAppConfigs.put(bluetoothhealthappconfiguration1, s3);
                callHealthApplicationStatusCallback(bluetoothhealthappconfiguration1, 0);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            BluetoothHealthAppConfiguration bluetoothhealthappconfiguration = (BluetoothHealthAppConfiguration)message.obj;
            Iterator iterator = mHealthChannels.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                HealthChannel healthchannel1 = (HealthChannel)iterator.next();
                if(healthchannel1.mConfig.equals(bluetoothhealthappconfiguration) && healthchannel1.mState != 0)
                    disconnectChannel(healthchannel1.mDevice, bluetoothhealthappconfiguration, healthchannel1.mId);
            } while(true);
            if(mBluetoothService.unregisterHealthApplicationNative((String)mHealthAppConfigs.get(bluetoothhealthappconfiguration))) {
                callHealthApplicationStatusCallback(bluetoothhealthappconfiguration, 2);
                mCallbacks.remove(bluetoothhealthappconfiguration);
                mHealthAppConfigs.remove(bluetoothhealthappconfiguration);
            } else {
                callHealthApplicationStatusCallback(bluetoothhealthappconfiguration, 3);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            HealthChannel healthchannel = (HealthChannel)message.obj;
            String s = mBluetoothService.getObjectPathFromAddress(healthchannel.mDevice.getAddress());
            String s1 = (String)mHealthAppConfigs.get(healthchannel.mConfig);
            String s2 = getStringChannelType(healthchannel.mChannelType);
            if(!mBluetoothService.createChannelNative(s, s1, s2, healthchannel.mId)) {
                int i = healthchannel.mState;
                callHealthChannelCallback(healthchannel.mConfig, healthchannel.mDevice, i, 0, null, healthchannel.mId);
                mHealthChannels.remove(healthchannel);
            }
            if(true) goto _L1; else goto _L5
_L5:
        }

        final BluetoothHealthProfileHandler this$0;

             {
                this$0 = BluetoothHealthProfileHandler.this;
                super();
            }
    };
    private HashMap mHealthAppConfigs;
    private ArrayList mHealthChannels;
    private HashMap mHealthDevices;










}
