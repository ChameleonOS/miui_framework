// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.io.*;
import java.net.DatagramSocket;
import java.net.Socket;

// Referenced classes of package android.os:
//            Parcelable, Parcel, MemoryFile

public class ParcelFileDescriptor
    implements Parcelable, Closeable {
    public static class AutoCloseOutputStream extends FileOutputStream {

        public void close() throws IOException {
            mFd.close();
            super.close();
            return;
            Exception exception;
            exception;
            super.close();
            throw exception;
        }

        private final ParcelFileDescriptor mFd;

        public AutoCloseOutputStream(ParcelFileDescriptor parcelfiledescriptor) {
            super(parcelfiledescriptor.getFileDescriptor());
            mFd = parcelfiledescriptor;
        }
    }

    public static class AutoCloseInputStream extends FileInputStream {

        public void close() throws IOException {
            mFd.close();
            super.close();
            return;
            Exception exception;
            exception;
            super.close();
            throw exception;
        }

        private final ParcelFileDescriptor mFd;

        public AutoCloseInputStream(ParcelFileDescriptor parcelfiledescriptor) {
            super(parcelfiledescriptor.getFileDescriptor());
            mFd = parcelfiledescriptor;
        }
    }


    public ParcelFileDescriptor(ParcelFileDescriptor parcelfiledescriptor) {
        mParcelDescriptor = parcelfiledescriptor;
        mFileDescriptor = mParcelDescriptor.mFileDescriptor;
    }

    ParcelFileDescriptor(FileDescriptor filedescriptor) {
        if(filedescriptor == null) {
            throw new NullPointerException("descriptor must not be null");
        } else {
            mFileDescriptor = filedescriptor;
            mParcelDescriptor = null;
            return;
        }
    }

    public static ParcelFileDescriptor adoptFd(int i) {
        return new ParcelFileDescriptor(getFileDescriptorFromFdNoDup(i));
    }

    public static ParcelFileDescriptor[] createPipe() throws IOException {
        FileDescriptor afiledescriptor[] = new FileDescriptor[2];
        createPipeNative(afiledescriptor);
        ParcelFileDescriptor aparcelfiledescriptor[] = new ParcelFileDescriptor[2];
        aparcelfiledescriptor[0] = new ParcelFileDescriptor(afiledescriptor[0]);
        aparcelfiledescriptor[1] = new ParcelFileDescriptor(afiledescriptor[1]);
        return aparcelfiledescriptor;
    }

    private static native void createPipeNative(FileDescriptor afiledescriptor[]) throws IOException;

    public static ParcelFileDescriptor dup(FileDescriptor filedescriptor) throws IOException {
        FileDescriptor filedescriptor1 = Parcel.dupFileDescriptor(filedescriptor);
        ParcelFileDescriptor parcelfiledescriptor;
        if(filedescriptor1 != null)
            parcelfiledescriptor = new ParcelFileDescriptor(filedescriptor1);
        else
            parcelfiledescriptor = null;
        return parcelfiledescriptor;
    }

    public static ParcelFileDescriptor fromData(byte abyte0[], String s) throws IOException {
        ParcelFileDescriptor parcelfiledescriptor = null;
        if(abyte0 != null) goto _L2; else goto _L1
_L1:
        return parcelfiledescriptor;
_L2:
        MemoryFile memoryfile = new MemoryFile(s, abyte0.length);
        if(abyte0.length > 0)
            memoryfile.writeBytes(abyte0, 0, 0, abyte0.length);
        memoryfile.deactivate();
        FileDescriptor filedescriptor = memoryfile.getFileDescriptor();
        if(filedescriptor != null)
            parcelfiledescriptor = new ParcelFileDescriptor(filedescriptor);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static ParcelFileDescriptor fromDatagramSocket(DatagramSocket datagramsocket) {
        FileDescriptor filedescriptor = datagramsocket.getFileDescriptor$();
        ParcelFileDescriptor parcelfiledescriptor;
        if(filedescriptor != null)
            parcelfiledescriptor = new ParcelFileDescriptor(filedescriptor);
        else
            parcelfiledescriptor = null;
        return parcelfiledescriptor;
    }

    public static ParcelFileDescriptor fromFd(int i) throws IOException {
        return new ParcelFileDescriptor(getFileDescriptorFromFd(i));
    }

    public static ParcelFileDescriptor fromSocket(Socket socket) {
        FileDescriptor filedescriptor = socket.getFileDescriptor$();
        ParcelFileDescriptor parcelfiledescriptor;
        if(filedescriptor != null)
            parcelfiledescriptor = new ParcelFileDescriptor(filedescriptor);
        else
            parcelfiledescriptor = null;
        return parcelfiledescriptor;
    }

    private native int getFdNative();

    private static native FileDescriptor getFileDescriptorFromFd(int i) throws IOException;

    private static native FileDescriptor getFileDescriptorFromFdNoDup(int i);

    public static ParcelFileDescriptor open(File file, int i) throws FileNotFoundException {
        String s = file.getPath();
        SecurityManager securitymanager = System.getSecurityManager();
        if(securitymanager != null) {
            securitymanager.checkRead(s);
            if((0x20000000 & i) != 0)
                securitymanager.checkWrite(s);
        }
        if((0x30000000 & i) == 0)
            throw new IllegalArgumentException("Must specify MODE_READ_ONLY, MODE_WRITE_ONLY, or MODE_READ_WRITE");
        FileDescriptor filedescriptor = Parcel.openFileDescriptor(s, i);
        ParcelFileDescriptor parcelfiledescriptor;
        if(filedescriptor != null)
            parcelfiledescriptor = new ParcelFileDescriptor(filedescriptor);
        else
            parcelfiledescriptor = null;
        return parcelfiledescriptor;
    }

    public void close() throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(!mClosed)
            break MISSING_BLOCK_LABEL_14;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_50;
        mClosed = true;
        this;
        JVM INSTR monitorexit ;
        Exception exception;
        if(mParcelDescriptor != null)
            mParcelDescriptor.close();
        else
            Parcel.closeFileDescriptor(mFileDescriptor);
        break MISSING_BLOCK_LABEL_50;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int describeContents() {
        return 1;
    }

    public int detachFd() {
        if(mClosed)
            throw new IllegalStateException("Already closed");
        int j;
        if(mParcelDescriptor != null) {
            int k = mParcelDescriptor.detachFd();
            mClosed = true;
            j = k;
        } else {
            int i = getFd();
            mClosed = true;
            Parcel.clearFileDescriptor(mFileDescriptor);
            j = i;
        }
        return j;
    }

    public ParcelFileDescriptor dup() throws IOException {
        return dup(getFileDescriptor());
    }

    protected void finalize() throws Throwable {
        if(!mClosed)
            close();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getFd() {
        if(mClosed)
            throw new IllegalStateException("Already closed");
        else
            return getFdNative();
    }

    public FileDescriptor getFileDescriptor() {
        return mFileDescriptor;
    }

    public native long getStatSize();

    public native long seekTo(long l);

    public String toString() {
        return (new StringBuilder()).append("{ParcelFileDescriptor: ").append(mFileDescriptor).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFileDescriptor(mFileDescriptor);
        if((i & 1) == 0 || mClosed)
            break MISSING_BLOCK_LABEL_25;
        close();
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public ParcelFileDescriptor createFromParcel(Parcel parcel) {
            return parcel.readFileDescriptor();
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ParcelFileDescriptor[] newArray(int i) {
            return new ParcelFileDescriptor[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int MODE_APPEND = 0x2000000;
    public static final int MODE_CREATE = 0x8000000;
    public static final int MODE_READ_ONLY = 0x10000000;
    public static final int MODE_READ_WRITE = 0x30000000;
    public static final int MODE_TRUNCATE = 0x4000000;
    public static final int MODE_WORLD_READABLE = 1;
    public static final int MODE_WORLD_WRITEABLE = 2;
    public static final int MODE_WRITE_ONLY = 0x20000000;
    private boolean mClosed;
    private final FileDescriptor mFileDescriptor;
    private final ParcelFileDescriptor mParcelDescriptor;

}
