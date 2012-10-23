// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.usb;

import android.util.Log;
import java.nio.ByteBuffer;

// Referenced classes of package android.hardware.usb:
//            UsbEndpoint, UsbDeviceConnection

public class UsbRequest {

    public UsbRequest() {
    }

    private native boolean native_cancel();

    private native void native_close();

    private native void native_dequeue_array(byte abyte0[], int i, boolean flag);

    private native void native_dequeue_direct();

    private native boolean native_init(UsbDeviceConnection usbdeviceconnection, int i, int j, int k, int l);

    private native boolean native_queue_array(byte abyte0[], int i, boolean flag);

    private native boolean native_queue_direct(ByteBuffer bytebuffer, int i, boolean flag);

    public boolean cancel() {
        return native_cancel();
    }

    public void close() {
        mEndpoint = null;
        native_close();
    }

    void dequeue() {
        boolean flag;
        if(mEndpoint.getDirection() == 0)
            flag = true;
        else
            flag = false;
        if(mBuffer.isDirect())
            native_dequeue_direct();
        else
            native_dequeue_array(mBuffer.array(), mLength, flag);
        mBuffer = null;
        mLength = 0;
    }

    protected void finalize() throws Throwable {
        if(mEndpoint != null) {
            Log.v("UsbRequest", (new StringBuilder()).append("endpoint still open in finalize(): ").append(this).toString());
            close();
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public Object getClientData() {
        return mClientData;
    }

    public UsbEndpoint getEndpoint() {
        return mEndpoint;
    }

    public boolean initialize(UsbDeviceConnection usbdeviceconnection, UsbEndpoint usbendpoint) {
        mEndpoint = usbendpoint;
        return native_init(usbdeviceconnection, usbendpoint.getAddress(), usbendpoint.getAttributes(), usbendpoint.getMaxPacketSize(), usbendpoint.getInterval());
    }

    public boolean queue(ByteBuffer bytebuffer, int i) {
        boolean flag;
        boolean flag1;
        if(mEndpoint.getDirection() == 0)
            flag = true;
        else
            flag = false;
        if(bytebuffer.isDirect())
            flag1 = native_queue_direct(bytebuffer, i, flag);
        else
        if(bytebuffer.hasArray())
            flag1 = native_queue_array(bytebuffer.array(), i, flag);
        else
            throw new IllegalArgumentException("buffer is not direct and has no array");
        if(flag1) {
            mBuffer = bytebuffer;
            mLength = i;
        }
        return flag1;
    }

    public void setClientData(Object obj) {
        mClientData = obj;
    }

    private static final String TAG = "UsbRequest";
    private ByteBuffer mBuffer;
    private Object mClientData;
    private UsbEndpoint mEndpoint;
    private int mLength;
    private int mNativeContext;
}
