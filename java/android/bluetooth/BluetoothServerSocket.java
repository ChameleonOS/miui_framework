// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.Handler;
import android.os.Message;
import java.io.Closeable;
import java.io.IOException;

// Referenced classes of package android.bluetooth:
//            BluetoothSocket

public final class BluetoothServerSocket
    implements Closeable {

    BluetoothServerSocket(int i, boolean flag, boolean flag1, int j) throws IOException {
        mChannel = j;
        mSocket = new BluetoothSocket(i, -1, flag, flag1, null, j, null);
    }

    public BluetoothSocket accept() throws IOException {
        return accept(-1);
    }

    public BluetoothSocket accept(int i) throws IOException {
        return mSocket.accept(i);
    }

    public void close() throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(mHandler != null)
            mHandler.obtainMessage(mMessage).sendToTarget();
        this;
        JVM INSTR monitorexit ;
        mSocket.close();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getChannel() {
        return mChannel;
    }

    /**
     * @deprecated Method setCloseHandler is deprecated
     */

    void setCloseHandler(Handler handler, int i) {
        this;
        JVM INSTR monitorenter ;
        mHandler = handler;
        mMessage = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private final int mChannel;
    private Handler mHandler;
    private int mMessage;
    final BluetoothSocket mSocket;
}
