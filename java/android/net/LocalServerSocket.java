// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import java.io.FileDescriptor;
import java.io.IOException;

// Referenced classes of package android.net:
//            LocalSocketImpl, LocalSocketAddress, LocalSocket

public class LocalServerSocket {

    public LocalServerSocket(FileDescriptor filedescriptor) throws IOException {
        impl = new LocalSocketImpl(filedescriptor);
        impl.listen(50);
        localAddress = impl.getSockAddress();
    }

    public LocalServerSocket(String s) throws IOException {
        impl = new LocalSocketImpl();
        impl.create(true);
        localAddress = new LocalSocketAddress(s);
        impl.bind(localAddress);
        impl.listen(50);
    }

    public LocalSocket accept() throws IOException {
        LocalSocketImpl localsocketimpl = new LocalSocketImpl();
        impl.accept(localsocketimpl);
        return new LocalSocket(localsocketimpl);
    }

    public void close() throws IOException {
        impl.close();
    }

    public FileDescriptor getFileDescriptor() {
        return impl.getFileDescriptor();
    }

    public LocalSocketAddress getLocalSocketAddress() {
        return localAddress;
    }

    private static final int LISTEN_BACKLOG = 50;
    private final LocalSocketImpl impl;
    private final LocalSocketAddress localAddress;
}
