// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.ParcelFileDescriptor;
import android.util.Log;

// Referenced classes of package android.bluetooth:
//            BluetoothHealthAppConfiguration, BluetoothDevice

public abstract class BluetoothHealthCallback {

    public BluetoothHealthCallback() {
    }

    public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, int i) {
        Log.d("BluetoothHealthCallback", (new StringBuilder()).append("onHealthAppConfigurationStatusChange: ").append(bluetoothhealthappconfiguration).append("Status: ").append(i).toString());
    }

    public void onHealthChannelStateChange(BluetoothHealthAppConfiguration bluetoothhealthappconfiguration, BluetoothDevice bluetoothdevice, int i, int j, ParcelFileDescriptor parcelfiledescriptor, int k) {
        Log.d("BluetoothHealthCallback", (new StringBuilder()).append("onHealthChannelStateChange: ").append(bluetoothhealthappconfiguration).append("Device: ").append(bluetoothdevice).append("prevState:").append(i).append("newState:").append(j).append("ParcelFd:").append(parcelfiledescriptor).append("ChannelId:").append(k).toString());
    }

    private static final String TAG = "BluetoothHealthCallback";
}
