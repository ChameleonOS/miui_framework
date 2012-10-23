// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import java.io.*;

// Referenced classes of package android.net:
//            LocalSocketAddress, Credentials

class LocalSocketImpl {
    class SocketOutputStream extends OutputStream {

        public void close() throws IOException {
            LocalSocketImpl.this.close();
        }

        public void write(int i) throws IOException {
            Object obj = writeMonitor;
            obj;
            JVM INSTR monitorenter ;
            FileDescriptor filedescriptor;
            filedescriptor = fd;
            if(filedescriptor == null)
                throw new IOException("socket closed");
            break MISSING_BLOCK_LABEL_39;
            Exception exception;
            exception;
            throw exception;
            write_native(i, filedescriptor);
            obj;
            JVM INSTR monitorexit ;
        }

        public void write(byte abyte0[]) throws IOException {
            write(abyte0, 0, abyte0.length);
        }

        public void write(byte abyte0[], int i, int j) throws IOException {
            Object obj = writeMonitor;
            obj;
            JVM INSTR monitorenter ;
            FileDescriptor filedescriptor;
            filedescriptor = fd;
            if(filedescriptor == null)
                throw new IOException("socket closed");
            break MISSING_BLOCK_LABEL_44;
            Exception exception;
            exception;
            throw exception;
            int k;
            if(i < 0 || j < 0)
                break MISSING_BLOCK_LABEL_64;
            k = i + j;
            if(k <= abyte0.length)
                break MISSING_BLOCK_LABEL_72;
            throw new ArrayIndexOutOfBoundsException();
            writeba_native(abyte0, i, j, filedescriptor);
            obj;
            JVM INSTR monitorexit ;
        }

        final LocalSocketImpl this$0;

        SocketOutputStream() {
            this$0 = LocalSocketImpl.this;
            super();
        }
    }

    class SocketInputStream extends InputStream {

        public int available() throws IOException {
            return available_native(fd);
        }

        public void close() throws IOException {
            LocalSocketImpl.this.close();
        }

        public int read() throws IOException {
            Object obj = readMonitor;
            obj;
            JVM INSTR monitorenter ;
            FileDescriptor filedescriptor;
            filedescriptor = fd;
            if(filedescriptor == null)
                throw new IOException("socket closed");
            break MISSING_BLOCK_LABEL_37;
            Exception exception;
            exception;
            throw exception;
            int i = read_native(filedescriptor);
            obj;
            JVM INSTR monitorexit ;
            return i;
        }

        public int read(byte abyte0[]) throws IOException {
            return read(abyte0, 0, abyte0.length);
        }

        public int read(byte abyte0[], int i, int j) throws IOException {
            Object obj = readMonitor;
            obj;
            JVM INSTR monitorenter ;
            FileDescriptor filedescriptor;
            filedescriptor = fd;
            if(filedescriptor == null)
                throw new IOException("socket closed");
            break MISSING_BLOCK_LABEL_44;
            Exception exception;
            exception;
            throw exception;
            int k;
            if(i < 0 || j < 0)
                break MISSING_BLOCK_LABEL_64;
            k = i + j;
            if(k <= abyte0.length)
                break MISSING_BLOCK_LABEL_72;
            throw new ArrayIndexOutOfBoundsException();
            int l = readba_native(abyte0, i, j, filedescriptor);
            obj;
            JVM INSTR monitorexit ;
            return l;
        }

        final LocalSocketImpl this$0;

        SocketInputStream() {
            this$0 = LocalSocketImpl.this;
            super();
        }
    }


    LocalSocketImpl() {
        readMonitor = new Object();
        writeMonitor = new Object();
    }

    LocalSocketImpl(FileDescriptor filedescriptor) throws IOException {
        readMonitor = new Object();
        writeMonitor = new Object();
        fd = filedescriptor;
    }

    private native FileDescriptor accept(FileDescriptor filedescriptor, LocalSocketImpl localsocketimpl) throws IOException;

    private native int available_native(FileDescriptor filedescriptor) throws IOException;

    private native void bindLocal(FileDescriptor filedescriptor, String s, int i) throws IOException;

    private native void close_native(FileDescriptor filedescriptor) throws IOException;

    private native void connectLocal(FileDescriptor filedescriptor, String s, int i) throws IOException;

    private native FileDescriptor create_native(boolean flag) throws IOException;

    private native int getOption_native(FileDescriptor filedescriptor, int i) throws IOException;

    private native Credentials getPeerCredentials_native(FileDescriptor filedescriptor) throws IOException;

    private native void listen_native(FileDescriptor filedescriptor, int i) throws IOException;

    private native int read_native(FileDescriptor filedescriptor) throws IOException;

    private native int readba_native(byte abyte0[], int i, int j, FileDescriptor filedescriptor) throws IOException;

    private native void setOption_native(FileDescriptor filedescriptor, int i, int j, int k) throws IOException;

    private native void shutdown(FileDescriptor filedescriptor, boolean flag);

    private native void write_native(int i, FileDescriptor filedescriptor) throws IOException;

    private native void writeba_native(byte abyte0[], int i, int j, FileDescriptor filedescriptor) throws IOException;

    protected void accept(LocalSocketImpl localsocketimpl) throws IOException {
        if(fd == null) {
            throw new IOException("socket not created");
        } else {
            localsocketimpl.fd = accept(fd, localsocketimpl);
            return;
        }
    }

    protected int available() throws IOException {
        return getInputStream().available();
    }

    public void bind(LocalSocketAddress localsocketaddress) throws IOException {
        if(fd == null) {
            throw new IOException("socket not created");
        } else {
            bindLocal(fd, localsocketaddress.getName(), localsocketaddress.getNamespace().getId());
            return;
        }
    }

    public void close() throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(fd != null) {
            close_native(fd);
            fd = null;
        }
        return;
    }

    protected void connect(LocalSocketAddress localsocketaddress, int i) throws IOException {
        if(fd == null) {
            throw new IOException("socket not created");
        } else {
            connectLocal(fd, localsocketaddress.getName(), localsocketaddress.getNamespace().getId());
            return;
        }
    }

    public void create(boolean flag) throws IOException {
        if(fd == null)
            fd = create_native(flag);
    }

    protected void finalize() throws IOException {
        close();
    }

    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        Object obj = readMonitor;
        obj;
        JVM INSTR monitorenter ;
        FileDescriptor afiledescriptor[] = inboundFileDescriptors;
        inboundFileDescriptors = null;
        return afiledescriptor;
    }

    protected FileDescriptor getFileDescriptor() {
        return fd;
    }

    protected InputStream getInputStream() throws IOException {
        if(fd == null)
            throw new IOException("socket not created");
        this;
        JVM INSTR monitorenter ;
        if(fis == null)
            fis = new SocketInputStream();
        SocketInputStream socketinputstream = fis;
        return socketinputstream;
    }

    public Object getOption(int i) throws IOException {
        if(fd == null)
            throw new IOException("socket not created");
        if(i != 4102) goto _L2; else goto _L1
_L1:
        Integer integer = Integer.valueOf(0);
_L4:
        return integer;
_L2:
        int j = getOption_native(fd, i);
        switch(i) {
        default:
            integer = Integer.valueOf(j);
            break;

        case 4097: 
        case 4098: 
            integer = Integer.valueOf(j);
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected OutputStream getOutputStream() throws IOException {
        if(fd == null)
            throw new IOException("socket not created");
        this;
        JVM INSTR monitorenter ;
        if(fos == null)
            fos = new SocketOutputStream();
        SocketOutputStream socketoutputstream = fos;
        return socketoutputstream;
    }

    public Credentials getPeerCredentials() throws IOException {
        return getPeerCredentials_native(fd);
    }

    public LocalSocketAddress getSockAddress() throws IOException {
        return null;
    }

    protected void listen(int i) throws IOException {
        if(fd == null) {
            throw new IOException("socket not created");
        } else {
            listen_native(fd, i);
            return;
        }
    }

    protected void sendUrgentData(int i) throws IOException {
        throw new RuntimeException("not impled");
    }

    public void setFileDescriptorsForSend(FileDescriptor afiledescriptor[]) {
        Object obj = writeMonitor;
        obj;
        JVM INSTR monitorenter ;
        outboundFileDescriptors = afiledescriptor;
        return;
    }

    public void setOption(int i, Object obj) throws IOException {
        byte byte0 = -1;
        int j = 0;
        if(fd == null)
            throw new IOException("socket not created");
        if(obj instanceof Integer)
            j = ((Integer)obj).intValue();
        else
        if(obj instanceof Boolean) {
            if(((Boolean)obj).booleanValue())
                byte0 = 1;
            else
                byte0 = 0;
        } else {
            throw new IOException((new StringBuilder()).append("bad value: ").append(obj).toString());
        }
        setOption_native(fd, i, byte0, j);
    }

    protected void shutdownInput() throws IOException {
        if(fd == null) {
            throw new IOException("socket not created");
        } else {
            shutdown(fd, true);
            return;
        }
    }

    protected void shutdownOutput() throws IOException {
        if(fd == null) {
            throw new IOException("socket not created");
        } else {
            shutdown(fd, false);
            return;
        }
    }

    protected boolean supportsUrgentData() {
        return false;
    }

    public String toString() {
        return (new StringBuilder()).append(super.toString()).append(" fd:").append(fd).toString();
    }

    private FileDescriptor fd;
    private SocketInputStream fis;
    private SocketOutputStream fos;
    FileDescriptor inboundFileDescriptors[];
    FileDescriptor outboundFileDescriptors[];
    private Object readMonitor;
    private Object writeMonitor;








}
