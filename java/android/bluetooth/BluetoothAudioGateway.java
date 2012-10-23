// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package android.bluetooth:
//            BluetoothAdapter, BluetoothDevice

public final class BluetoothAudioGateway {
    public class IncomingConnectionInfo {

        public BluetoothAdapter mAdapter;
        public BluetoothDevice mRemoteDevice;
        public int mRfcommChan;
        public int mSocketFd;
        final BluetoothAudioGateway this$0;

        IncomingConnectionInfo(BluetoothAdapter bluetoothadapter, BluetoothDevice bluetoothdevice, int i, int j) {
            this$0 = BluetoothAudioGateway.this;
            super();
            mAdapter = bluetoothadapter;
            mRemoteDevice = bluetoothdevice;
            mSocketFd = i;
            mRfcommChan = j;
        }
    }


    public BluetoothAudioGateway(BluetoothAdapter bluetoothadapter) {
        this(bluetoothadapter, 10, 11);
    }

    public BluetoothAudioGateway(BluetoothAdapter bluetoothadapter, int i, int j) {
        mHandsfreeAgRfcommChannel = -1;
        mHeadsetAgRfcommChannel = -1;
        mAdapter = bluetoothadapter;
        mHandsfreeAgRfcommChannel = i;
        mHeadsetAgRfcommChannel = j;
        initializeNativeDataNative();
    }

    private static native void classInitNative();

    private native void cleanupNativeDataNative();

    private native void initializeNativeDataNative();

    private static void log(String s) {
        Log.d("BT Audio Gateway", s);
    }

    private native boolean setUpListeningSocketsNative();

    private native void tearDownListeningSocketsNative();

    private native boolean waitForHandsfreeConnectNative(int i);

    protected void finalize() throws Throwable {
        cleanupNativeDataNative();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    /**
     * @deprecated Method start is deprecated
     */

    public boolean start(Handler handler) {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if(mConnectThead != null) goto _L2; else goto _L1
_L1:
        mCallback = handler;
        mConnectThead = new Thread("BT Audio Gateway") {

            public void run() {
                do {
                    if(mInterrupted)
                        break;
                    mConnectingHeadsetRfcommChannel = -1;
                    mConnectingHandsfreeRfcommChannel = -1;
                    if(!waitForHandsfreeConnectNative(1000)) {
                        if(mTimeoutRemainingMs > 0)
                            try {
                                Log.i("BT Audio Gateway", (new StringBuilder()).append("select thread timed out, but ").append(mTimeoutRemainingMs).append("ms of waiting remain.").toString());
                                Thread.sleep(mTimeoutRemainingMs);
                            }
                            catch(InterruptedException interruptedexception) {
                                Log.i("BT Audio Gateway", "select thread was interrupted (2), exiting");
                                mInterrupted = true;
                            }
                    } else {
                        Log.i("BT Audio Gateway", "connect notification!");
                        if(mConnectingHeadsetRfcommChannel >= 0) {
                            Log.i("BT Audio Gateway", (new StringBuilder()).append("Incoming connection from headset ").append(mConnectingHeadsetAddress).append(" on channel ").append(mConnectingHeadsetRfcommChannel).toString());
                            Message message1 = Message.obtain(mCallback);
                            message1.what = 100;
                            message1.obj = new IncomingConnectionInfo(mAdapter, mAdapter.getRemoteDevice(mConnectingHeadsetAddress), mConnectingHeadsetSocketFd, mConnectingHeadsetRfcommChannel);
                            message1.sendToTarget();
                        }
                        if(mConnectingHandsfreeRfcommChannel >= 0) {
                            Log.i("BT Audio Gateway", (new StringBuilder()).append("Incoming connection from handsfree ").append(mConnectingHandsfreeAddress).append(" on channel ").append(mConnectingHandsfreeRfcommChannel).toString());
                            Message message = Message.obtain();
                            message.setTarget(mCallback);
                            message.what = 101;
                            message.obj = new IncomingConnectionInfo(mAdapter, mAdapter.getRemoteDevice(mConnectingHandsfreeAddress), mConnectingHandsfreeSocketFd, mConnectingHandsfreeRfcommChannel);
                            message.sendToTarget();
                        }
                    }
                } while(true);
            }

            final BluetoothAudioGateway this$0;

             {
                this$0 = BluetoothAudioGateway.this;
                super(s);
            }
        };
        if(setUpListeningSocketsNative()) goto _L4; else goto _L3
_L3:
        Log.e("BT Audio Gateway", "Could not set up listening socket, exiting");
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        mInterrupted = false;
        mConnectThead.start();
_L2:
        flag = true;
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method stop is deprecated
     */

    public void stop() {
        this;
        JVM INSTR monitorenter ;
        if(mConnectThead == null)
            break MISSING_BLOCK_LABEL_42;
        mInterrupted = true;
        mConnectThead.interrupt();
        mConnectThead.join();
        mConnectThead = null;
        mCallback = null;
        tearDownListeningSocketsNative();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.w("BT Audio Gateway", "Interrupted waiting for Connect Thread to join");
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    private static final boolean DBG = false;
    public static final int DEFAULT_HF_AG_CHANNEL = 10;
    public static final int DEFAULT_HS_AG_CHANNEL = 11;
    public static final int MSG_INCOMING_HANDSFREE_CONNECTION = 101;
    public static final int MSG_INCOMING_HEADSET_CONNECTION = 100;
    private static final int SELECT_WAIT_TIMEOUT = 1000;
    private static final String TAG = "BT Audio Gateway";
    private final BluetoothAdapter mAdapter;
    private Handler mCallback;
    private Thread mConnectThead;
    private String mConnectingHandsfreeAddress;
    private int mConnectingHandsfreeRfcommChannel;
    private int mConnectingHandsfreeSocketFd;
    private String mConnectingHeadsetAddress;
    private int mConnectingHeadsetRfcommChannel;
    private int mConnectingHeadsetSocketFd;
    private int mHandsfreeAgRfcommChannel;
    private int mHeadsetAgRfcommChannel;
    private volatile boolean mInterrupted;
    private int mNativeData;
    private int mTimeoutRemainingMs;

    static  {
        classInitNative();
    }



/*
    static boolean access$002(BluetoothAudioGateway bluetoothaudiogateway, boolean flag) {
        bluetoothaudiogateway.mInterrupted = flag;
        return flag;
    }

*/




/*
    static int access$102(BluetoothAudioGateway bluetoothaudiogateway, int i) {
        bluetoothaudiogateway.mConnectingHeadsetRfcommChannel = i;
        return i;
    }

*/



/*
    static int access$202(BluetoothAudioGateway bluetoothaudiogateway, int i) {
        bluetoothaudiogateway.mConnectingHandsfreeRfcommChannel = i;
        return i;
    }

*/







}
