// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import java.io.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package android.bluetooth:
//            BluetoothInputStream, BluetoothOutputStream, BluetoothDevice, IBluetooth

public final class BluetoothSocket
    implements Closeable {
    private static class SdpHelper extends IBluetoothCallback.Stub {

        /**
         * @deprecated Method cancel is deprecated
         */

        public void cancel() {
            this;
            JVM INSTR monitorenter ;
            if(!canceled) {
                canceled = true;
                channel = -1;
                notifyAll();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method doSdp is deprecated
         */

        public int doSdp() throws IOException {
            this;
            JVM INSTR monitorenter ;
            if(canceled)
                throw new IOException("Service discovery canceled");
            break MISSING_BLOCK_LABEL_24;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            channel = -1;
            boolean flag = false;
            boolean flag1 = service.fetchRemoteUuids(device.getAddress(), uuid, this);
            flag = flag1;
_L2:
            if(flag)
                break; /* Loop/switch isn't completed */
            throw new IOException("Unable to start Service Discovery");
            RemoteException remoteexception;
            remoteexception;
            Log.e("BluetoothSocket", "", remoteexception);
            if(true) goto _L2; else goto _L1
_L1:
            int i;
            try {
                wait(12000L);
            }
            catch(InterruptedException interruptedexception) { }
            if(canceled)
                throw new IOException("Service discovery canceled");
            if(channel < 1)
                throw new IOException("Service discovery failed");
            i = channel;
            this;
            JVM INSTR monitorexit ;
            return i;
        }

        /**
         * @deprecated Method onRfcommChannelFound is deprecated
         */

        public void onRfcommChannelFound(int i) {
            this;
            JVM INSTR monitorenter ;
            if(!canceled) {
                channel = i;
                notifyAll();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private boolean canceled;
        private int channel;
        private final BluetoothDevice device;
        private final IBluetooth service = BluetoothDevice.getService();
        private final ParcelUuid uuid;

        public SdpHelper(BluetoothDevice bluetoothdevice, ParcelUuid parceluuid) {
            device = bluetoothdevice;
            uuid = parceluuid;
            canceled = false;
        }
    }

    private static final class SocketState extends Enum {

        public static SocketState valueOf(String s) {
            return (SocketState)Enum.valueOf(android/bluetooth/BluetoothSocket$SocketState, s);
        }

        public static SocketState[] values() {
            return (SocketState[])$VALUES.clone();
        }

        private static final SocketState $VALUES[];
        public static final SocketState CLOSED;
        public static final SocketState CONNECTED;
        public static final SocketState INIT;

        static  {
            INIT = new SocketState("INIT", 0);
            CONNECTED = new SocketState("CONNECTED", 1);
            CLOSED = new SocketState("CLOSED", 2);
            SocketState asocketstate[] = new SocketState[3];
            asocketstate[0] = INIT;
            asocketstate[1] = CONNECTED;
            asocketstate[2] = CLOSED;
            $VALUES = asocketstate;
        }

        private SocketState(String s, int i) {
            super(s, i);
        }
    }


    BluetoothSocket(int i, int j, boolean flag, boolean flag1, BluetoothDevice bluetoothdevice, int k, ParcelUuid parceluuid) throws IOException {
        if(i == 1 && parceluuid == null && j == -1 && (k < 1 || k > 30))
            throw new IOException((new StringBuilder()).append("Invalid RFCOMM channel: ").append(k).toString());
        if(parceluuid == null) {
            mPort = k;
            mSdp = null;
        } else {
            mSdp = new SdpHelper(bluetoothdevice, parceluuid);
            mPort = -1;
        }
        mType = i;
        mAuth = flag;
        mEncrypt = flag1;
        mDevice = bluetoothdevice;
        if(bluetoothdevice == null)
            mAddress = null;
        else
            mAddress = bluetoothdevice.getAddress();
        if(j == -1)
            initSocketNative();
        else
            initSocketFromFdNative(j);
        mInputStream = new BluetoothInputStream(this);
        mOutputStream = new BluetoothOutputStream(this);
        mSocketState = SocketState.INIT;
        mLock = new ReentrantReadWriteLock();
    }

    private BluetoothSocket(int i, int j, boolean flag, boolean flag1, String s, int k) throws IOException {
        this(i, j, flag, flag1, new BluetoothDevice(s), k, null);
    }

    private native void abortNative() throws IOException;

    private native BluetoothSocket acceptNative(int i) throws IOException;

    private native int availableNative() throws IOException;

    private native int bindListenNative();

    private native void connectNative() throws IOException;

    private native void destroyNative() throws IOException;

    private native void initSocketFromFdNative(int i) throws IOException;

    private native void initSocketNative() throws IOException;

    private native int readNative(byte abyte0[], int i, int j) throws IOException;

    private native int writeNative(byte abyte0[], int i, int j) throws IOException;

    BluetoothSocket accept(int i) throws IOException {
        mLock.readLock().lock();
        if(mSocketState == SocketState.CLOSED)
            throw new IOException("socket closed");
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        mLock.readLock().unlock();
        throw exception;
        BluetoothSocket bluetoothsocket;
        bluetoothsocket = acceptNative(i);
        mSocketState = SocketState.CONNECTED;
        mLock.readLock().unlock();
        return bluetoothsocket;
    }

    int available() throws IOException {
        mLock.readLock().lock();
        if(mSocketState == SocketState.CLOSED)
            throw new IOException("socket closed");
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        mLock.readLock().unlock();
        throw exception;
        int i = availableNative();
        mLock.readLock().unlock();
        return i;
    }

    int bindListen() {
        mLock.readLock().lock();
        SocketState socketstate;
        SocketState socketstate1;
        socketstate = mSocketState;
        socketstate1 = SocketState.CLOSED;
        if(socketstate != socketstate1) goto _L2; else goto _L1
_L1:
        int j;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readlock;
        j = 77;
        readlock = mLock.readLock();
_L4:
        readlock.unlock();
        return j;
_L2:
        int i = bindListenNative();
        j = i;
        readlock = mLock.readLock();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        mLock.readLock().unlock();
        throw exception;
    }

    public void close() throws IOException {
        mLock.readLock().lock();
        SocketState socketstate;
        SocketState socketstate1;
        socketstate = mSocketState;
        socketstate1 = SocketState.CLOSED;
        if(socketstate != socketstate1) goto _L2; else goto _L1
_L1:
        mLock.readLock().unlock();
_L4:
        return;
_L2:
        if(mSdp != null)
            mSdp.cancel();
        abortNative();
        mLock.readLock().unlock();
        mLock.writeLock().lock();
        mSocketState = SocketState.CLOSED;
        destroyNative();
        mLock.writeLock().unlock();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        mLock.readLock().unlock();
        throw exception;
        Exception exception1;
        exception1;
        mLock.writeLock().unlock();
        throw exception1;
    }

    public void connect() throws IOException {
        mLock.readLock().lock();
        if(mSocketState == SocketState.CLOSED)
            throw new IOException("socket closed");
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        mLock.readLock().unlock();
        throw exception;
        if(mSdp != null)
            mPort = mSdp.doSdp();
        connectNative();
        mSocketState = SocketState.CONNECTED;
        mLock.readLock().unlock();
        return;
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

    public InputStream getInputStream() throws IOException {
        return mInputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        return mOutputStream;
    }

    public BluetoothDevice getRemoteDevice() {
        return mDevice;
    }

    public boolean isConnected() {
        boolean flag;
        if(mSocketState == SocketState.CONNECTED)
            flag = true;
        else
            flag = false;
        return flag;
    }

    int read(byte abyte0[], int i, int j) throws IOException {
        mLock.readLock().lock();
        if(mSocketState == SocketState.CLOSED)
            throw new IOException("socket closed");
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        mLock.readLock().unlock();
        throw exception;
        int k = readNative(abyte0, i, j);
        mLock.readLock().unlock();
        return k;
    }

    native void throwErrnoNative(int i) throws IOException;

    int write(byte abyte0[], int i, int j) throws IOException {
        mLock.readLock().lock();
        if(mSocketState == SocketState.CLOSED)
            throw new IOException("socket closed");
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        mLock.readLock().unlock();
        throw exception;
        int k = writeNative(abyte0, i, j);
        mLock.readLock().unlock();
        return k;
    }

    static final int EADDRINUSE = 98;
    static final int EBADFD = 77;
    public static final int MAX_RFCOMM_CHANNEL = 30;
    private static final String TAG = "BluetoothSocket";
    static final int TYPE_L2CAP = 3;
    static final int TYPE_RFCOMM = 1;
    static final int TYPE_SCO = 2;
    private final String mAddress;
    private final boolean mAuth;
    private final BluetoothDevice mDevice;
    private final boolean mEncrypt;
    private final BluetoothInputStream mInputStream;
    private final ReentrantReadWriteLock mLock;
    private final BluetoothOutputStream mOutputStream;
    private int mPort;
    private final SdpHelper mSdp;
    private int mSocketData;
    private SocketState mSocketState;
    private final int mType;
}
