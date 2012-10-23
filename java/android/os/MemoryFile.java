// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import java.io.*;

public class MemoryFile {
    private class MemoryOutputStream extends OutputStream {

        public void write(int i) throws IOException {
            if(mSingleByte == null)
                mSingleByte = new byte[1];
            mSingleByte[0] = (byte)i;
            write(mSingleByte, 0, 1);
        }

        public void write(byte abyte0[], int i, int j) throws IOException {
            writeBytes(abyte0, i, mOffset, j);
            mOffset = j + mOffset;
        }

        private int mOffset;
        private byte mSingleByte[];
        final MemoryFile this$0;

        private MemoryOutputStream() {
            this$0 = MemoryFile.this;
            super();
            mOffset = 0;
        }

    }

    private class MemoryInputStream extends InputStream {

        public int available() throws IOException {
            int i;
            if(mOffset >= mLength)
                i = 0;
            else
                i = mLength - mOffset;
            return i;
        }

        public void mark(int i) {
            mMark = mOffset;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() throws IOException {
            if(mSingleByte == null)
                mSingleByte = new byte[1];
            byte byte0;
            if(read(mSingleByte, 0, 1) != 1)
                byte0 = -1;
            else
                byte0 = mSingleByte[0];
            return byte0;
        }

        public int read(byte abyte0[], int i, int j) throws IOException {
            int k;
            if(i < 0 || j < 0 || i + j > abyte0.length)
                throw new IndexOutOfBoundsException();
            k = Math.min(j, available());
            if(k >= 1) goto _L2; else goto _L1
_L1:
            int l = -1;
_L4:
            return l;
_L2:
            l = readBytes(abyte0, mOffset, i, k);
            if(l > 0)
                mOffset = l + mOffset;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void reset() throws IOException {
            mOffset = mMark;
        }

        public long skip(long l) throws IOException {
            if(l + (long)mOffset > (long)mLength)
                l = mLength - mOffset;
            mOffset = (int)(l + (long)mOffset);
            return l;
        }

        private int mMark;
        private int mOffset;
        private byte mSingleByte[];
        final MemoryFile this$0;

        private MemoryInputStream() {
            this$0 = MemoryFile.this;
            super();
            mMark = 0;
            mOffset = 0;
        }

    }


    public MemoryFile(String s, int i) throws IOException {
        mAllowPurging = false;
        mLength = i;
        mFD = native_open(s, i);
        if(i > 0)
            mAddress = native_mmap(mFD, i, 3);
        else
            mAddress = 0;
    }

    public static int getSize(FileDescriptor filedescriptor) throws IOException {
        return native_get_size(filedescriptor);
    }

    private boolean isClosed() {
        boolean flag;
        if(!mFD.valid())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isDeactivated() {
        boolean flag;
        if(mAddress == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static native void native_close(FileDescriptor filedescriptor);

    private static native int native_get_size(FileDescriptor filedescriptor) throws IOException;

    private static native int native_mmap(FileDescriptor filedescriptor, int i, int j) throws IOException;

    private static native void native_munmap(int i, int j) throws IOException;

    private static native FileDescriptor native_open(String s, int i) throws IOException;

    private static native void native_pin(FileDescriptor filedescriptor, boolean flag) throws IOException;

    private static native int native_read(FileDescriptor filedescriptor, int i, byte abyte0[], int j, int k, int l, boolean flag) throws IOException;

    private static native void native_write(FileDescriptor filedescriptor, int i, byte abyte0[], int j, int k, int l, boolean flag) throws IOException;

    /**
     * @deprecated Method allowPurging is deprecated
     */

    public boolean allowPurging(boolean flag) throws IOException {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = mAllowPurging;
        if(flag1 == flag) goto _L2; else goto _L1
_L1:
        FileDescriptor filedescriptor;
        boolean flag2;
        filedescriptor = mFD;
        if(flag)
            break MISSING_BLOCK_LABEL_41;
        flag2 = true;
_L3:
        native_pin(filedescriptor, flag2);
        mAllowPurging = flag;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag1;
        flag2 = false;
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    public void close() {
        deactivate();
        if(!isClosed())
            native_close(mFD);
    }

    void deactivate() {
        if(isDeactivated())
            break MISSING_BLOCK_LABEL_23;
        native_munmap(mAddress, mLength);
        mAddress = 0;
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.e(TAG, ioexception.toString());
          goto _L1
    }

    protected void finalize() {
        if(!isClosed()) {
            Log.e(TAG, "MemoryFile.finalize() called while ashmem still open");
            close();
        }
    }

    public FileDescriptor getFileDescriptor() throws IOException {
        return mFD;
    }

    public InputStream getInputStream() {
        return new MemoryInputStream();
    }

    public OutputStream getOutputStream() {
        return new MemoryOutputStream();
    }

    public boolean isPurgingAllowed() {
        return mAllowPurging;
    }

    public int length() {
        return mLength;
    }

    public int readBytes(byte abyte0[], int i, int j, int k) throws IOException {
        if(isDeactivated())
            throw new IOException("Can't read from deactivated memory file.");
        if(j < 0 || j > abyte0.length || k < 0 || k > abyte0.length - j || i < 0 || i > mLength || k > mLength - i)
            throw new IndexOutOfBoundsException();
        else
            return native_read(mFD, mAddress, abyte0, i, j, k, mAllowPurging);
    }

    public void writeBytes(byte abyte0[], int i, int j, int k) throws IOException {
        if(isDeactivated())
            throw new IOException("Can't write to deactivated memory file.");
        if(i < 0 || i > abyte0.length || k < 0 || k > abyte0.length - i || j < 0 || j > mLength || k > mLength - j) {
            throw new IndexOutOfBoundsException();
        } else {
            native_write(mFD, mAddress, abyte0, i, j, k, mAllowPurging);
            return;
        }
    }

    private static final int PROT_READ = 1;
    private static final int PROT_WRITE = 2;
    private static String TAG = "MemoryFile";
    private int mAddress;
    private boolean mAllowPurging;
    private FileDescriptor mFD;
    private int mLength;


}
