// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.usb;

import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;

// Referenced classes of package android.hardware.usb:
//            UsbEndpoint, UsbInterface, UsbRequest, UsbDevice

public class UsbDeviceConnection {

    public UsbDeviceConnection(UsbDevice usbdevice) {
        mDevice = usbdevice;
    }

    private native int native_bulk_request(int i, byte abyte0[], int j, int k);

    private native boolean native_claim_interface(int i, boolean flag);

    private native void native_close();

    private native int native_control_request(int i, int j, int k, int l, byte abyte0[], int i1, int j1);

    private native byte[] native_get_desc();

    private native int native_get_fd();

    private native String native_get_serial();

    private native boolean native_open(String s, FileDescriptor filedescriptor);

    private native boolean native_release_interface(int i);

    private native UsbRequest native_request_wait();

    public int bulkTransfer(UsbEndpoint usbendpoint, byte abyte0[], int i, int j) {
        return native_bulk_request(usbendpoint.getAddress(), abyte0, i, j);
    }

    public boolean claimInterface(UsbInterface usbinterface, boolean flag) {
        return native_claim_interface(usbinterface.getId(), flag);
    }

    public void close() {
        native_close();
    }

    public int controlTransfer(int i, int j, int k, int l, byte abyte0[], int i1, int j1) {
        return native_control_request(i, j, k, l, abyte0, i1, j1);
    }

    public int getFileDescriptor() {
        return native_get_fd();
    }

    public byte[] getRawDescriptors() {
        return native_get_desc();
    }

    public String getSerial() {
        return native_get_serial();
    }

    boolean open(String s, ParcelFileDescriptor parcelfiledescriptor) {
        return native_open(s, parcelfiledescriptor.getFileDescriptor());
    }

    public boolean releaseInterface(UsbInterface usbinterface) {
        return native_release_interface(usbinterface.getId());
    }

    public UsbRequest requestWait() {
        UsbRequest usbrequest = native_request_wait();
        if(usbrequest != null)
            usbrequest.dequeue();
        return usbrequest;
    }

    private static final String TAG = "UsbDeviceConnection";
    private final UsbDevice mDevice;
    private int mNativeContext;
}
