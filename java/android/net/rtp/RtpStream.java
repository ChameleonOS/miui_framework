// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.rtp;

import java.net.*;

public class RtpStream {

    RtpStream(InetAddress inetaddress) throws SocketException {
        mRemotePort = -1;
        mMode = 0;
        mSocket = -1;
        mLocalPort = create(inetaddress.getHostAddress());
        mLocalAddress = inetaddress;
    }

    private native void close();

    private native int create(String s) throws SocketException;

    public void associate(InetAddress inetaddress, int i) {
        if(isBusy())
            throw new IllegalStateException("Busy");
        if((!(inetaddress instanceof Inet4Address) || !(mLocalAddress instanceof Inet4Address)) && (!(inetaddress instanceof Inet6Address) || !(mLocalAddress instanceof Inet6Address)))
            throw new IllegalArgumentException("Unsupported address");
        if(i < 0 || i > 65535) {
            throw new IllegalArgumentException("Invalid port");
        } else {
            mRemoteAddress = inetaddress;
            mRemotePort = i;
            return;
        }
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public InetAddress getLocalAddress() {
        return mLocalAddress;
    }

    public int getLocalPort() {
        return mLocalPort;
    }

    public int getMode() {
        return mMode;
    }

    public InetAddress getRemoteAddress() {
        return mRemoteAddress;
    }

    public int getRemotePort() {
        return mRemotePort;
    }

    int getSocket() {
        return mSocket;
    }

    public boolean isBusy() {
        return false;
    }

    public void release() {
        this;
        JVM INSTR monitorenter ;
        if(isBusy())
            throw new IllegalStateException("Busy");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        throw exception;
        close();
        this;
        JVM INSTR monitorexit ;
    }

    public void setMode(int i) {
        if(isBusy())
            throw new IllegalStateException("Busy");
        if(i < 0 || i > 2) {
            throw new IllegalArgumentException("Invalid mode");
        } else {
            mMode = i;
            return;
        }
    }

    private static final int MODE_LAST = 2;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_RECEIVE_ONLY = 2;
    public static final int MODE_SEND_ONLY = 1;
    private final InetAddress mLocalAddress;
    private final int mLocalPort;
    private int mMode;
    private InetAddress mRemoteAddress;
    private int mRemotePort;
    private int mSocket;

    static  {
        System.loadLibrary("rtp_jni");
    }
}
