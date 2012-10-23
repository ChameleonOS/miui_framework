// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.bluetooth.*;
import android.content.*;
import android.util.Log;
import java.io.*;
import java.util.*;

// Referenced classes of package android.server:
//            BluetoothInputProfileHandler, BluetoothService, BluetoothAdapterProperties

class BluetoothBondState {

    BluetoothBondState(Context context, BluetoothService bluetoothservice) {
        mPairingRequestRcvd = new ArrayList();
        mProfileServiceListener = new android.bluetooth.BluetoothProfile.ServiceListener() {

            public void onServiceConnected(int i, BluetoothProfile bluetoothprofile) {
                if(i != 2) goto _L2; else goto _L1
_L1:
                mA2dpProxy = (BluetoothA2dp)bluetoothprofile;
_L4:
                return;
_L2:
                if(i == 1)
                    mHeadsetProxy = (BluetoothHeadset)bluetoothprofile;
                if(true) goto _L4; else goto _L3
_L3:
            }

            public void onServiceDisconnected(int i) {
                if(i != 2) goto _L2; else goto _L1
_L1:
                mA2dpProxy = null;
_L4:
                return;
_L2:
                if(i == 1)
                    mHeadsetProxy = null;
                if(true) goto _L4; else goto _L3
_L3:
            }

            final BluetoothBondState this$0;

             {
                this$0 = BluetoothBondState.this;
                super();
            }
        };
        mContext = context;
        mService = bluetoothservice;
        mBluetoothInputProfileHandler = BluetoothInputProfileHandler.getInstance(mContext, mService);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        mContext.registerReceiver(mReceiver, intentfilter);
        readAutoPairingData();
    }

    private void closeProfileProxy() {
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if(mA2dpProxy != null)
            bluetoothadapter.closeProfileProxy(2, mA2dpProxy);
        if(mHeadsetProxy != null)
            bluetoothadapter.closeProfileProxy(1, mHeadsetProxy);
    }

    private void copyAutoPairingData() {
        FileInputStream fileinputstream;
        FileOutputStream fileoutputstream;
        fileinputstream = null;
        fileoutputstream = null;
        boolean flag = (new File("/data/misc/bluetooth/dynamic_auto_pairing.conf")).exists();
        if(!flag) goto _L2; else goto _L1
_L1:
        if(true)
            break MISSING_BLOCK_LABEL_29;
        throw null;
        if(false)
            throw null;
_L10:
        return;
_L2:
        FileInputStream fileinputstream1 = new FileInputStream("/etc/bluetooth/auto_pairing.conf");
        FileNotFoundException filenotfoundexception;
        Exception exception;
        IOException ioexception;
        IOException ioexception2;
        IOException ioexception3;
        FileOutputStream fileoutputstream1;
        IOException ioexception4;
        try {
            fileoutputstream1 = new FileOutputStream("/data/misc/bluetooth/dynamic_auto_pairing.conf");
            break MISSING_BLOCK_LABEL_58;
        }
        // Misplaced declaration of an exception variable
        catch(FileNotFoundException filenotfoundexception) {
            fileinputstream = fileinputstream1;
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception2) {
            fileinputstream = fileinputstream1;
            continue; /* Loop/switch isn't completed */
        }
        finally {
            fileinputstream = fileinputstream1;
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
        filenotfoundexception;
        fileoutputstream = fileoutputstream1;
        fileinputstream = fileinputstream1;
_L3:
        Log.e("BluetoothBondState", (new StringBuilder()).append("FileNotFoundException: copyAutoPairingData ").append(filenotfoundexception).toString());
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_132;
        fileinputstream.close();
        if(fileoutputstream != null)
            fileoutputstream.close();
        continue; /* Loop/switch isn't completed */
        ioexception1;
        continue; /* Loop/switch isn't completed */
        byte abyte0[] = new byte[1024];
        IOException ioexception1;
        do {
            int i = fileinputstream1.read(abyte0);
            if(i <= 0)
                break;
            fileoutputstream1.write(abyte0, 0, i);
        } while(true);
        if(fileinputstream1 == null)
            break MISSING_BLOCK_LABEL_158;
        fileinputstream1.close();
        if(fileoutputstream1 != null)
            fileoutputstream1.close();
        continue; /* Loop/switch isn't completed */
        ioexception4;
        continue; /* Loop/switch isn't completed */
        ioexception2;
_L7:
        Log.e("BluetoothBondState", (new StringBuilder()).append("IOException: copyAutoPairingData ").append(ioexception2).toString());
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_212;
        fileinputstream.close();
        if(fileoutputstream != null)
            fileoutputstream.close();
        continue; /* Loop/switch isn't completed */
        ioexception3;
        continue; /* Loop/switch isn't completed */
        exception;
_L5:
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_238;
        fileinputstream.close();
        if(fileoutputstream != null)
            fileoutputstream.close();
_L4:
        throw exception;
        ioexception;
        if(true) goto _L4; else goto _L3
        exception;
        fileoutputstream = fileoutputstream1;
        fileinputstream = fileinputstream1;
        if(true) goto _L5; else goto _L3
        ioexception2;
        fileoutputstream = fileoutputstream1;
        fileinputstream = fileinputstream1;
        if(true) goto _L7; else goto _L6
_L6:
        filenotfoundexception;
        if(true) goto _L3; else goto _L8
_L8:
        IOException ioexception5;
        ioexception5;
        if(true) goto _L10; else goto _L9
_L9:
    }

    private void getProfileProxy() {
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if(mA2dpProxy == null)
            bluetoothadapter.getProfileProxy(mContext, mProfileServiceListener, 2);
        if(mHeadsetProxy == null)
            bluetoothadapter.getProfileProxy(mContext, mProfileServiceListener, 1);
    }

    private void loadBondState() {
        if(mService.getBluetoothStateInternal() == 11) goto _L2; else goto _L1
_L1:
        String s;
        return;
_L2:
        String as[];
        if((s = mService.getAdapterProperties().getProperty("Devices")) != null && (as = s.split(",")) != null) {
            mState.clear();
            Log.d("BluetoothBondState", (new StringBuilder()).append("found ").append(as.length).append(" bonded devices").toString());
            int i = as.length;
            int j = 0;
            while(j < i)  {
                String s1 = as[j];
                mState.put(mService.getAddressFromObjectPath(s1).toUpperCase(), Integer.valueOf(12));
                j++;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void setProfilePriorities(String s, int i) {
        BluetoothDevice bluetoothdevice;
        bluetoothdevice = mService.getRemoteDevice(s);
        mBluetoothInputProfileHandler.setInitialInputDevicePriority(bluetoothdevice, i);
        if(i != 12) goto _L2; else goto _L1
_L1:
        if(mA2dpProxy != null && mA2dpProxy.getPriority(bluetoothdevice) == -1)
            mA2dpProxy.setPriority(bluetoothdevice, 100);
        if(mHeadsetProxy != null && mHeadsetProxy.getPriority(bluetoothdevice) == -1)
            mHeadsetProxy.setPriority(bluetoothdevice, 100);
_L4:
        if(mA2dpProxy == null || mHeadsetProxy == null)
            Log.e("BluetoothBondState", (new StringBuilder()).append("Proxy is null:").append(mA2dpProxy).append(":").append(mHeadsetProxy).toString());
        return;
_L2:
        if(i == 10) {
            if(mA2dpProxy != null)
                mA2dpProxy.setPriority(bluetoothdevice, -1);
            if(mHeadsetProxy != null)
                mHeadsetProxy.setPriority(bluetoothdevice, -1);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void updateAutoPairingData(String s) {
        BufferedWriter bufferedwriter = null;
        BufferedWriter bufferedwriter1 = new BufferedWriter(new FileWriter("/data/misc/bluetooth/dynamic_auto_pairing.conf", true));
        StringBuilder stringbuilder = new StringBuilder();
        if(mAutoPairingDynamicAddressBlacklist.size() == 0)
            stringbuilder.append("DynamicAddressBlacklist=");
        stringbuilder.append(s);
        stringbuilder.append(",");
        bufferedwriter1.write(stringbuilder.toString());
        if(bufferedwriter1 == null)
            break MISSING_BLOCK_LABEL_80;
        bufferedwriter1.close();
_L1:
        return;
        IOException ioexception4;
        ioexception4;
          goto _L1
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
_L5:
        Log.e("BluetoothBondState", (new StringBuilder()).append("FileNotFoundException: updateAutoPairingData ").append(filenotfoundexception).toString());
        if(bufferedwriter != null)
            try {
                bufferedwriter.close();
            }
            catch(IOException ioexception1) { }
          goto _L1
        IOException ioexception2;
        ioexception2;
_L4:
        Log.e("BluetoothBondState", (new StringBuilder()).append("IOException: updateAutoPairingData ").append(ioexception2).toString());
        if(bufferedwriter != null)
            try {
                bufferedwriter.close();
            }
            catch(IOException ioexception3) { }
          goto _L1
        Exception exception;
        exception;
_L3:
        if(bufferedwriter != null)
            try {
                bufferedwriter.close();
            }
            catch(IOException ioexception) { }
        throw exception;
        exception;
        bufferedwriter = bufferedwriter1;
        if(true) goto _L3; else goto _L2
_L2:
        ioexception2;
        bufferedwriter = bufferedwriter1;
          goto _L4
        filenotfoundexception;
        bufferedwriter = bufferedwriter1;
          goto _L5
    }

    /**
     * @deprecated Method addAutoPairingFailure is deprecated
     */

    public void addAutoPairingFailure(String s) {
        this;
        JVM INSTR monitorenter ;
        if(mAutoPairingDynamicAddressBlacklist == null)
            mAutoPairingDynamicAddressBlacklist = new ArrayList();
        updateAutoPairingData(s);
        mAutoPairingDynamicAddressBlacklist.add(s);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method attempt is deprecated
     */

    public void attempt(String s) {
        this;
        JVM INSTR monitorenter ;
        Integer integer = (Integer)mPinAttempt.get(s);
        if(integer != null) goto _L2; else goto _L1
_L1:
        int j = 1;
_L3:
        Log.d("BluetoothBondState", (new StringBuilder()).append("attemp newAttempt: ").append(j).toString());
        mPinAttempt.put(s, new Integer(j));
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i = integer.intValue();
        j = i + 1;
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method clearPinAttempts is deprecated
     */

    public void clearPinAttempts(String s) {
        this;
        JVM INSTR monitorenter ;
        Log.d("BluetoothBondState", (new StringBuilder()).append("clearPinAttempts: ").append(s).toString());
        mPinAttempt.remove(s);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getAttempt is deprecated
     */

    public int getAttempt(String s) {
        this;
        JVM INSTR monitorenter ;
        Integer integer = (Integer)mPinAttempt.get(s);
        if(integer != null) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return j;
_L2:
        int i = integer.intValue();
        j = i;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getBondState is deprecated
     */

    public int getBondState(String s) {
        this;
        JVM INSTR monitorenter ;
        Integer integer = (Integer)mState.get(s);
        if(integer != null) goto _L2; else goto _L1
_L1:
        int j = 10;
_L4:
        this;
        JVM INSTR monitorexit ;
        return j;
_L2:
        int i = integer.intValue();
        j = i;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getPendingOutgoingBonding is deprecated
     */

    public String getPendingOutgoingBonding() {
        this;
        JVM INSTR monitorenter ;
        String s = mPendingOutgoingBonding;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method hasAutoPairingFailed is deprecated
     */

    public boolean hasAutoPairingFailed(String s) {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = mAutoPairingDynamicAddressBlacklist;
        if(arraylist != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        boolean flag = mAutoPairingDynamicAddressBlacklist.contains(s);
        flag1 = flag;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method initBondState is deprecated
     */

    public void initBondState() {
        this;
        JVM INSTR monitorenter ;
        getProfileProxy();
        loadBondState();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method isAutoPairingAttemptsInProgress is deprecated
     */

    public boolean isAutoPairingAttemptsInProgress(String s) {
        this;
        JVM INSTR monitorenter ;
        int i = getAttempt(s);
        boolean flag;
        if(i != 0)
            flag = true;
        else
            flag = false;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isAutoPairingBlacklisted(String s) {
        boolean flag = true;
        if(mAutoPairingAddressBlacklist == null) goto _L2; else goto _L1
_L1:
        Iterator iterator3 = mAutoPairingAddressBlacklist.iterator();
_L5:
        if(!iterator3.hasNext()) goto _L2; else goto _L3
_L3:
        if(!s.startsWith((String)iterator3.next())) goto _L5; else goto _L4
_L4:
        return flag;
_L2:
label0:
        {
            if(mAutoPairingDynamicAddressBlacklist == null)
                break label0;
            Iterator iterator2 = mAutoPairingDynamicAddressBlacklist.iterator();
            do
                if(!iterator2.hasNext())
                    break label0;
            while(!s.equals((String)iterator2.next()));
            continue; /* Loop/switch isn't completed */
        }
label1:
        {
            String s1;
label2:
            {
                s1 = mService.getRemoteName(s);
                if(s1 == null)
                    break label1;
                if(mAutoPairingExactNameBlacklist == null)
                    break label2;
                Iterator iterator1 = mAutoPairingExactNameBlacklist.iterator();
                do
                    if(!iterator1.hasNext())
                        break label2;
       