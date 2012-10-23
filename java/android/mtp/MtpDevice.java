// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;

// Referenced classes of package android.mtp:
//            MtpDeviceInfo, MtpObjectInfo, MtpStorageInfo

public final class MtpDevice {

    public MtpDevice(UsbDevice usbdevice) {
        mDevice = usbdevice;
    }

    private native void native_close();

    private native boolean native_delete_object(int i);

    private native MtpDeviceInfo native_get_device_info();

    private native byte[] native_get_object(int i, int j);

    private native int[] native_get_object_handles(int i, int j, int k);

    private native MtpObjectInfo native_get_object_info(int i);

    private native long native_get_parent(int i);

    private native long native_get_storage_id(int i);

    private native int[] native_get_storage_ids();

    private native MtpStorageInfo native_get_storage_info(int i);

    private native byte[] native_get_thumbnail(int i);

    private native boolean native_import_file(int i, String s);

    private native boolean native_open(String s, int i);

    public void close() {
        native_close();
    }

    public boolean deleteObject(int i) {
        return native_delete_object(i);
    }

    protected void finalize() throws Throwable {
        native_close();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getDeviceId() {
        return mDevice.getDeviceId();
    }

    public MtpDeviceInfo getDeviceInfo() {
        return native_get_device_info();
    }

    public String getDeviceName() {
        return mDevice.getDeviceName();
    }

    public byte[] getObject(int i, int j) {
        return native_get_object(i, j);
    }

    public int[] getObjectHandles(int i, int j, int k) {
        return native_get_object_handles(i, j, k);
    }

    public MtpObjectInfo getObjectInfo(int i) {
        return native_get_object_info(i);
    }

    public long getParent(int i) {
        return native_get_parent(i);
    }

    public long getStorageId(int i) {
        return native_get_storage_id(i);
    }

    public int[] getStorageIds() {
        return native_get_storage_ids();
    }

    public MtpStorageInfo getStorageInfo(int i) {
        return native_get_storage_info(i);
    }

    public byte[] getThumbnail(int i) {
        return native_get_thumbnail(i);
    }

    public boolean importFile(int i, String s) {
        return native_import_file(i, s);
    }

    public boolean open(UsbDeviceConnection usbdeviceconnection) {
        boolean flag = native_open(mDevice.getDeviceName(), usbdeviceconnection.getFileDescriptor());
        if(!flag)
            usbdeviceconnection.close();
        return flag;
    }

    public String toString() {
        return mDevice.getDeviceName();
    }

    private static final String TAG = "MtpDevice";
    private final UsbDevice mDevice;
    private int mNativeContext;

    static  {
        System.loadLibrary("media_jni");
    }
}
