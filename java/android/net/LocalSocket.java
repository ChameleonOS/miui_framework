// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import java.io.*;

// Referenced classes of package android.net:
//            LocalSocketImpl, LocalSocketAddress, Credentials

public class LocalSocket {

    public LocalSocket() {
        this(new LocalSocketImpl());
        isBound = false;
        isConnected = false;
    }

    LocalSocket(LocalSocketImpl localsocketimpl) {
        impl = localsocketimpl;
        isConnected = false;
        isBound = false;
    }

    private void implCreateIfNeeded() throws IOException {
        if(implCreated)
            break MISSING_BLOCK_LABEL_49;
        this;
        JVM INSTR monitorenter ;
        boolean flag = implCreated;
        if(flag)
            break MISSING_BLOCK_LABEL_31;
        impl.create(true);
        implCreated = true;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_49;
        Exception exception1;
        exception1;
        implCreated = true;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
    }

    public void bind(LocalSocketAddress localsocketaddress) throws IOException {
        implCreateIfNeeded();
        this;
        JVM INSTR monitorenter ;
        if(isBound)
            throw new IOException("already bound");
        break MISSING_BLOCK_LABEL_28;
        Exception exception;
        exception;
        throw exception;
        localAddress = localsocketaddress;
        impl.bind(localAddress);
        isBound = true;
        this;
        JVM INSTR monitorexit ;
    }

    public void close() throws IOException {
        implCreateIfNeeded();
        impl.close();
    }

    public void connect(LocalSocketAddress localsocketaddress) throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(isConnected)
            throw new IOException("already connected");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        throw exception;
        implCreateIfNeeded();
        impl.connect(localsocketaddress, 0);
        isConnected = true;
        isBound = true;
        this;
        JVM INSTR monitorexit ;
    }

    public void connect(LocalSocketAddress localsocketaddress, int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        return impl.getAncillaryFileDescriptors();
    }

    public FileDescriptor getFileDescriptor() {
        return impl.getFileDescriptor();
    }

    public InputStream getInputStream() throws IOException {
        implCreateIfNeeded();
        return impl.getInputStream();
    }

    public LocalSocketAddress getLocalSocketAddress() {
        return localAddress;
    }

    public OutputStream getOutputStream() throws IOException {
        implCreateIfNeeded();
        return impl.getOutputStream();
    }

    public Credentials getPeerCredentials() throws IOException {
        return impl.getPeerCredentials();
    }

    public int getReceiveBufferSize() throws IOException {
        return ((Integer)impl.getOption(4098)).intValue();
    }

    public LocalSocketAddress getRemoteSocketAddress() {
        throw new UnsupportedOperationException();
    }

    public int getSendBufferSize() throws IOException {
        return ((Integer)impl.getOption(4097)).intValue();
    }

    public int getSoTimeout() throws IOException {
        return ((Integer)impl.getOption(4102)).intValue();
    }

    /**
     * @deprecated Method isBound is deprecated
     */

    public boolean isBound() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isBound;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    /**
     * @deprecated Method isConnected is deprecated
     */

    public boolean isConnected() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isConnected;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isInputShutdown() {
        throw new UnsupportedOperationException();
    }

    public boolean isOutputShutdown() {
        throw new UnsupportedOperationException();
    }

    public void setFileDescriptorsForSend(FileDescriptor afiledescriptor[]) {
        impl.setFileDescriptorsForSend(afiledescriptor);
    }

    public void setReceiveBufferSize(int i) throws IOException {
        impl.setOption(4098, Integer.valueOf(i));
    }

    public void setSendBufferSize(int i) throws IOException {
        impl.setOption(4097, Integer.valueOf(i));
    }

    public void setSoTimeout(int i) throws IOException {
        impl.setOption(4102, Integer.valueOf(i));
    }

    public void shutdownInput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownInput();
    }

    public void shutdownOutput() throws IOException {
        implCreateIfNeeded();
        impl.shutdownOutput();
    }

    public String toString() {
        return (new StringBuilder()).append(super.toString()).append(" impl:").append(impl).toString();
    }

    private LocalSocketImpl impl;
    private volatile boolean implCreated;
    private boolean isBound;
    private boolean isConnected;
    private LocalSocketAddress localAddress;
}
