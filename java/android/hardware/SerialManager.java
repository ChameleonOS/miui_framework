// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

// Referenced classes of package android.hardware:
//            ISerialManager, SerialPort

public class SerialManager {

    public SerialManager(Context context, ISerialManager iserialmanager) {
        mContext = context;
        mService = iserialmanager;
    }

    public String[] getSerialPorts() {
        String as1[] = mService.getSerialPorts();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SerialManager", "RemoteException in getSerialPorts", remoteexception);
        as = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public SerialPort openSerialPort(String s, int i) throws IOException {
        SerialPort serialport;
        try {
            android.os.ParcelFileDescriptor parcelfiledescriptor = mService.openSerialPort(s);
            if(parcelfiledescriptor != null) {
                serialport = new SerialPort(s);
                serialport.open(parcelfiledescriptor, i);
            } else {
                throw new IOException((new StringBuilder()).append("Could not open serial port ").append(s).toString());
            }
        }
        catch(RemoteException remoteexception) {
            Log.e("SerialManager", "exception in UsbManager.openDevice", remoteexception);
            serialport = null;
        }
        return serialport;
    }

    private static final String TAG = "SerialManager";
    private final Context mContext;
    private final ISerialManager mService;
}
