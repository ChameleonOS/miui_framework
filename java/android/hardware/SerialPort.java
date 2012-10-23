// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;

import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SerialPort {

    public SerialPort(String s) {
        mName = s;
    }

    private native void native_close();

    private native void native_open(FileDescriptor filedescriptor, int i) throws IOException;

    private native int native_read_array(byte abyte0[], int i) throws IOException;

    private native int native_read_direct(ByteBuffer bytebuffer, int i) throws IOException;

    private native void native_send_break();

    private native void native_write_array(byte abyte0[], int i) throws IOException;

    private native void native_write_direct(ByteBuffer bytebuffer, int i) throws IOException;

    public void close() throws IOException {
        if(mFileDescriptor != null) {
            mFileDescriptor.close();
            mFileDescriptor = null;
        }
        native_close();
    }

    public String getName() {
        return mName;
    }

    public void open(ParcelFileDescriptor parcelfiledescriptor, int i) throws IOException {
        native_open(parcelfiledescriptor.getFileDescriptor(), i);
        mFileDescriptor = parcelfiledescriptor;
    }

    public int read(ByteBuffer bytebuffer) throws IOException {
        int i;
        if(bytebuffer.isDirect())
            i = native_read_direct(bytebuffer, bytebuffer.remaining());
        else
        if(bytebuffer.hasArray())
            i = native_read_array(bytebuffer.array(), bytebuffer.remaining());
        else
            throw new IllegalArgumentException("buffer is not direct and has no array");
        return i;
    }

    public void sendBreak() {
        native_send_break();
    }

    public void write(ByteBuffer bytebuffer, int i) throws IOException {
        if(bytebuffer.isDirect())
            native_write_direct(bytebuffer, i);
        else
        if(bytebuffer.hasArray())
            native_write_array(bytebuffer.array(), i);
        else
            throw new IllegalArgumentException("buffer is not direct and has no array");
    }

    private static final String TAG = "SerialPort";
    private ParcelFileDescriptor mFileDescriptor;
    private final String mName;
    private int mNativeContext;
}
