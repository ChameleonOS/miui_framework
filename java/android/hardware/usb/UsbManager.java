// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware.usb;

import android.app.PendingIntent;
import android.content.Context;
import android.os.*;
import android.util.Log;
import java.util.*;

// Referenced classes of package android.hardware.usb:
//            IUsbManager, UsbAccessory, UsbDevice, UsbDeviceConnection

public class UsbManager {

    public UsbManager(Context context, IUsbManager iusbmanager) {
        mContext = context;
        mService = iusbmanager;
    }

    private static boolean propertyContainsFunction(String s, String s1) {
        boolean flag;
        String s2;
        int i;
        flag = false;
        s2 = SystemProperties.get(s, "");
        i = s2.indexOf(s1);
        break MISSING_BLOCK_LABEL_16;
        while(true)  {
            do
                return flag;
            while(i < 0 || i > 0 && s2.charAt(i - 1) != ',');
            int j = i + s1.length();
            if(j >= s2.length() || s2.charAt(j) == ',')
                flag = true;
        }
    }

    public UsbAccessory[] getAccessoryList() {
        UsbAccessory ausbaccessory[] = null;
        UsbAccessory ausbaccessory1[];
        UsbAccessory usbaccessory = mService.getCurrentAccessory();
        if(usbaccessory == null)
            break MISSING_BLOCK_LABEL_49;
        ausbaccessory1 = new UsbAccessory[1];
        ausbaccessory1[0] = usbaccessory;
        ausbaccessory = ausbaccessory1;
        break MISSING_BLOCK_LABEL_49;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UsbManager", "RemoteException in getAccessoryList", remoteexception);
        return ausbaccessory;
    }

    public String getDefaultFunction() {
        String s = SystemProperties.get("persist.sys.usb.config", "");
        int i = s.indexOf(',');
        if(i > 0)
            s = s.substring(0, i);
        return s;
    }

    public HashMap getDeviceList() {
        Bundle bundle = new Bundle();
        HashMap hashmap;
        try {
            mService.getDeviceList(bundle);
            hashmap = new HashMap();
            String s;
            for(Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); hashmap.put(s, (UsbDevice)bundle.get(s)))
                s = (String)iterator.next();

        }
        catch(RemoteException remoteexception) {
            Log.e("UsbManager", "RemoteException in getDeviceList", remoteexception);
            hashmap = null;
        }
        return hashmap;
    }

    public boolean hasPermission(UsbAccessory usbaccessory) {
        boolean flag1 = mService.hasAccessoryPermission(usbaccessory);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UsbManager", "RemoteException in hasPermission", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean hasPermission(UsbDevice usbdevice) {
        boolean flag1 = mService.hasDevicePermission(usbdevice);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UsbManager", "RemoteException in hasPermission", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isFunctionEnabled(String s) {
        return propertyContainsFunction("sys.usb.config", s);
    }

    public ParcelFileDescriptor openAccessory(UsbAccessory usbaccessory) {
        ParcelFileDescriptor parcelfiledescriptor1 = mService.openAccessory(usbaccessory);
        ParcelFileDescriptor parcelfiledescriptor = parcelfiledescriptor1;
_L2:
        return parcelfiledescriptor;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UsbManager", "RemoteException in openAccessory", remoteexception);
        parcelfiledescriptor = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public UsbDeviceConnection openDevice(UsbDevice usbdevice) {
        String s;
        ParcelFileDescriptor parcelfiledescriptor;
        s = usbdevice.getDeviceName();
        parcelfiledescriptor = mService.openDevice(s);
        if(parcelfiledescriptor == null) goto _L2; else goto _L1
_L1:
        UsbDeviceConnection usbdeviceconnection;
        boolean flag;
        usbdeviceconnection = new UsbDeviceConnection(usbdevice);
        flag = usbdeviceconnection.open(s, parcelfiledescriptor);
        parcelfiledescriptor.close();
        if(!flag) goto _L2; else goto _L3
_L3:
        return usbdeviceconnection;
        Exception exception;
        exception;
        Log.e("UsbManager", "exception in UsbManager.openDevice", exception);
_L2:
        usbdeviceconnection = null;
        if(true) goto _L3; else goto _L4
_L4:
    }

    public void requestPermission(UsbAccessory usbaccessory, PendingIntent pendingintent) {
        mService.requestAccessoryPermission(usbaccessory, mContext.getPackageName(), pendingintent);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UsbManager", "RemoteException in requestPermission", remoteexception);
          goto _L1
    }

    public void requestPermission(UsbDevice usbdevice, PendingIntent pendingintent) {
        mService.requestDevicePermission(usbdevice, mContext.getPackageName(), pendingintent);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UsbManager", "RemoteException in requestPermission", remoteexception);
          goto _L1
    }

    public void setCurrentFunction(String s, boolean flag) {
        mService.setCurrentFunction(s, flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UsbManager", "RemoteException in setCurrentFunction", remoteexception);
          goto _L1
    }

    public void setMassStorageBackingFile(String s) {
        mService.setMassStorageBackingFile(s);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UsbManager", "RemoteException in setDefaultFunction", remoteexception);
          goto _L1
    }

    public static final String ACTION_USB_ACCESSORY_ATTACHED = "android.hardware.usb.action.USB_ACCESSORY_ATTACHED";
    public static final String ACTION_USB_ACCESSORY_DETACHED = "android.hardware.usb.action.USB_ACCESSORY_DETACHED";
    public static final String ACTION_USB_DEVICE_ATTACHED = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    public static final String ACTION_USB_DEVICE_DETACHED = "android.hardware.usb.action.USB_DEVICE_DETACHED";
    public static final String ACTION_USB_STATE = "android.hardware.usb.action.USB_STATE";
    public static final String EXTRA_ACCESSORY = "accessory";
    public static final String EXTRA_DEVICE = "device";
    public static final String EXTRA_PERMISSION_GRANTED = "permission";
    private static final String TAG = "UsbManager";
    public static final String USB_CONFIGURED = "configured";
    public static final String USB_CONNECTED = "connected";
    public static final String USB_FUNCTION_ACCESSORY = "accessory";
    public static final String USB_FUNCTION_ADB = "adb";
    public static final String USB_FUNCTION_AUDIO_SOURCE = "audio_source";
    public static final String USB_FUNCTION_MASS_STORAGE = "mass_storage";
    public static final String USB_FUNCTION_MTP = "mtp";
    public static final String USB_FUNCTION_PTP = "ptp";
    public static final String USB_FUNCTION_RNDIS = "rndis";
    private final Context mContext;
    private final IUsbManager mService;
}
