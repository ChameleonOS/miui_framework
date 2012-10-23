// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.bluetooth:
//            BluetoothSocket

final class BluetoothInputStream extends InputStream {

    BluetoothInputStream(BluetoothSocket bluetoothsocket) {
        mSocket = bluetoothsocket;
    }

    public int available() throws IOException {
        return mSocket.available();
    }

    public void close() throws IOException {
        mSocket.close();
    }

    public int read() throws IOException {
        byte abyte0[] = new byte[1];
        int i;
        if(mSocket.read(abyte0, 0, 1) == 1)
            i = 0xff & abyte0[0];
        else
            i = -1;
        return i;
    }

    public int read(byte abyte0[], int i, int j) throws IOException {
        if(abyte0 == null)
            throw new NullPointerException("byte array is null");
        if((i | j) < 0 || j > abyte0.length - i)
            throw new ArrayIndexOutOfBoundsException("invalid offset or length");
        else
            return mSocket.read(abyte0, i, j);
    }

    private BluetoothSocket mSocket;
}
