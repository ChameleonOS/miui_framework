// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.*;
import android.util.Log;

// Referenced classes of package android.bluetooth:
//            BluetoothDevice, AtParser, AtCommandResult, BluetoothAdapter

public final class HeadsetBase {

    public HeadsetBase(PowerManager powermanager, BluetoothAdapter bluetoothadapter, BluetoothDevice bluetoothdevice, int i) {
        mDirection = 2;
        mConnectTimestamp = System.currentTimeMillis();
        mAdapter = bluetoothadapter;
        mRemoteDevice = bluetoothdevice;
        mAddress = bluetoothdevice.getAddress();
        mRfcommChannel = i;
        mWakeLock = powermanager.newWakeLock(1, "HeadsetBase");
        mWakeLock.setReferenceCounted(false);
        initializeAtParser();
        initializeNativeDataNative(-1);
    }

    public HeadsetBase(PowerManager powermanager, BluetoothAdapter bluetoothadapter, BluetoothDevice bluetoothdevice, int i, int j, Handler handler) {
        mDirection = 1;
        mConnectTimestamp = System.currentTimeMillis();
        mAdapter = bluetoothadapter;
        mRemoteDevice = bluetoothdevice;
        mAddress = bluetoothdevice.getAddress();
        mRfcommChannel = j;
        mEventThreadHandler = handler;
        mWakeLock = powermanager.newWakeLock(1, "HeadsetBase");
        mWakeLock.setReferenceCounted(false);
        initializeAtParser();
        initializeNativeDataNative(i);
    }

    /**
     * @deprecated Method acquireWakeLock is deprecated
     */

    private void acquireWakeLock() {
        this;
        JVM INSTR monitorenter ;
        if(!mWakeLock.isHeld())
            mWakeLock.acquire();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static native void classInitNative();

    private native void cleanupNativeDataNative();

    private native int connectAsyncNative();

    private native boolean connectNative();

    private native void disconnectNative();

    public static int getAtInputCount() {
        return sAtInputCount;
    }

    private native int getLastReadStatusNative();

    private native void initializeNativeDataNative(int i);

    private static void log(String s) {
        Log.d("Bluetooth HeadsetBase", s);
    }

    private native String readNative(int i);

    /**
     * @deprecated Method releaseWakeLock is deprecated
     */

    private void releaseWakeLock() {
        this;
        JVM INSTR monitorenter ;
        if(mWakeLock.isHeld())
            mWakeLock.release();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private native boolean sendURCNative(String s);

    private void stopEventThread() {
        mEventThreadInterrupted = true;
        mEventThread.interrupt();
        try {
            mEventThread.join();
        }
        catch(InterruptedException interruptedexception) { }
        mEventThread = null;
    }

    private native int waitForAsyncConnectNative(int i);

    public boolean connect(Handler handler) {
        if(mEventThread != null) goto _L2; else goto _L1
_L1:
        if(connectNative()) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        return flag;
_L4:
        mEventThreadHandler = handler;
_L2:
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean connectAsync() {
        boolean flag;
        if(connectAsyncNative() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void disconnect() {
        if(mEventThread != null)
            stopEventThread();
        disconnectNative();
    }

    protected void finalize() throws Throwable {
        cleanupNativeDataNative();
        releaseWakeLock();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public AtParser getAtParser() {
        return mAtParser;
    }

    public long getConnectTimestamp() {
        return mConnectTimestamp;
    }

    public int getDirection() {
        return mDirection;
    }

    public int getRemainingAsyncConnectWaitingTimeMs() {
        return mTimeoutRemainingMs;
    }

    public BluetoothDevice getRemoteDevice() {
        return mRemoteDevice;
    }

    protected void handleInput(String s) {
        acquireWakeLock();
        android/bluetooth/HeadsetBase;
        JVM INSTR monitorenter ;
        if(sAtInputCount != 0x7fffffff)
            break MISSING_BLOCK_LABEL_83;
        sAtInputCount = 0;
_L1:
        android/bluetooth/HeadsetBase;
        JVM INSTR monitorexit ;
        AtCommandResult atcommandresult = mAtParser.process(s);
        if(atcommandresult.getResultCode() == 1)
            Log.i("Bluetooth HeadsetBase", (new StringBuilder()).append("Error processing <").append(s).append(">").toString());
        sendURC(atcommandresult.toString());
        releaseWakeLock();
        return;
        sAtInputCount = 1 + sAtInputCount;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    protected void initializeAtParser() {
        mAtParser = new AtParser();
    }

    public boolean isConnected() {
        boolean flag;
        if(mEventThread != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    /**
     * @deprecated Method sendURC is deprecated
     */

    public boolean sendURC(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s.length() <= 0) goto _L2; else goto _L1
_L1:
        boolean flag1 = sendURCNative(s);
        boolean flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void startEventThread() {
        mEventThread = new Thread("HeadsetBase Event Thread") {

            public void run() {
                do {
                    if(mEventThreadInterrupted)
                        break;
                    String s = readNative(500);
                    if(s != null) {
                        handleInput(s);
                        continue;
                    }
                    int i = getLastReadStatusNative();
                    if(i == 0)
                        continue;
                    Log.i("Bluetooth HeadsetBase", (new StringBuilder()).append("headset read error ").append(i).toString());
                    if(mEventThreadHandler != null)
                        mEventThreadHandler.obtainMessage(1).sendToTarget();
                    disconnectNative();
                    break;
                } while(true);
            }

            final HeadsetBase this$0;

             {
                this$0 = HeadsetBase.this;
                super(s);
            }
        };
        mEventThreadInterrupted = false;
        mEventThread.start();
    }

    public int waitForAsyncConnect(int i, Handler handler) {
        int j = waitForAsyncConnectNative(i);
        if(j > 0)
            mEventThreadHandler = handler;
        return j;
    }

    private static final boolean DBG = false;
    public static final int DIRECTION_INCOMING = 1;
    public static final int DIRECTION_OUTGOING = 2;
    public static final int RFCOMM_DISCONNECTED = 1;
    private static final String TAG = "Bluetooth HeadsetBase";
    private static int sAtInputCount = 0;
    private final BluetoothAdapter mAdapter;
    private final String mAddress;
    protected AtParser mAtParser;
    private final long mConnectTimestamp;
    private final int mDirection;
    private Thread mEventThread;
    private Handler mEventThreadHandler;
    private volatile boolean mEventThreadInterrupted;
    private int mNativeData;
    private final BluetoothDevice mRemoteDevice;
    private final int mRfcommChannel;
    private int mTimeoutRemainingMs;
    private android.os.PowerManager.WakeLock mWakeLock;

    static  {
        classInitNative();
    }





}
